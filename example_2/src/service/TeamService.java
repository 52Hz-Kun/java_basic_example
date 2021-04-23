package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

/**
 * @Description 关于开发团队成员的管理：添加、删除等
 */
public class TeamService {
    private static int counter = 1; // 给MemberID赋值
    private final static int MAX_MEMBER = 5; // 限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER]; // 保存开发团队的成员
    private int total; // 记录开发团队实际的人数

    /**
     * @Description 获取开发团队中的所有成员
     * @return
     */
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * @Description 将指定的员工添加到开发团队中
     * @param employee
     */
    public void addMember(Employee employee) throws TeamException {

        // 成员已满，无法添加
        if(total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加!");
        }
        // 该成员不是开发人员
        if(!(employee instanceof Programmer)) // 这里已经将不是programmer的对象筛去了
            throw new TeamException("该成员不是开发人员");
        // 该成员已在本开发团队当中
        if (isExist(employee)){
            throw new TeamException("该成员已在本开发团队当中");
        }
        // 该成员已是某团队成员
        Programmer p = (Programmer) employee; // 不会出现ClassCastException
        if(p.getStatus().getNAME().equals("BUSY"))
            throw new TeamException("该成员已是某团队成员");
        // 该成员正在休假，无法添加
        if(p.getStatus().getNAME().equals("VOCATION"))
            throw new TeamException("该成员正在休假，无法添加");
        // 团队中至多只能有一名架构师
        // 团队中至多只能有两名设计师
        // 团队中至多只能有三名程序员

        // 获取team已有成员中架构师，设计师，程序员的个数
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if(team[i] instanceof Architect)
                numOfArch++;
            else if(team[i] instanceof Designer)
                numOfDes++;
            else
                numOfPro++;
            
        }
        if (p instanceof Architect && numOfArch>=1)
            throw new TeamException("团队中至多只能有一名架构师");
        if (p instanceof Designer && numOfDes>=2)
            throw new TeamException("团队中至多只能有两名设计师");
        if (numOfPro>=3)
            throw new TeamException("团队中至多只能有三名程序员");

        // 将p(或employee)添加到现有的team中
        team[total++] = p;
        // p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }

    /**
     * @Description 判断指定的员工是否已经存在于现有的开发团队中
     * @param employee
     * @return
     */
    private boolean isExist(Employee employee) {
        for (int i = 0; i < total; i++) {
            if(team[i].getId() == employee.getId()){
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberID) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if(team[i].getMemberId() == memberID){
                team[i].setStatus(Status.FREE);
                break;
            }            
        }

        // 找不到指定memberId的情况
        if (i == total)
            throw new TeamException("找不到指定memberId的员工，删除失败");


        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        team[--total] = null;

    }

}
