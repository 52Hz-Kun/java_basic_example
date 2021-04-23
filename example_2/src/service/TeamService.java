package service;

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

        // 该成员已在本开发团队当中
        // 该成员已是某团队成员
        // 该成员正在休假，无法添加
        // 团队中至多只能有一名架构师
        // 团队中至多只能有两名设计师




    }

    public void removeMember(int memberID){

    }

}
