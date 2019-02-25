package lxd.zhihu.enums;

import com.google.common.collect.Maps;

import java.util.HashMap;

public enum DingtalkGroups {
    /**
     *群1
     */
    GROUP1("group1","38846b13c359d2f2ac9985df73133c9ef9694353bf640b9f08ae771e352c8bd7"),
    /**
     * 群2
     */
    GROUP2("group2","5f5ef6a71b86fc6a95cdd0c3f9563e5627cd55cb811c251783137e785a2f7041")
    ;
    private String groupName;
    private String token;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    DingtalkGroups(String groupName, String token) {
        this.groupName = groupName;
        this.token = token;
    }

    /**
     * 枚举遍历转map
     * @return map
     */
    public static HashMap<String, String> getDingtalkGroupsMap() {
        HashMap<String, String> groupsMap = Maps.newHashMap();
        DingtalkGroups[] groups = DingtalkGroups.values();
        for (DingtalkGroups group: groups
        ) {
            groupsMap.put(group.getGroupName(), group.getToken());
        }
        return groupsMap;
    }

}
