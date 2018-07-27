package com.bcfou.springbootshiro.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = -5912189689012817664L;
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String memo;
    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private List<Permission> permissionid;

    protected Role() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<Permission> getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(List<Permission> permissionid) {
        this.permissionid = permissionid;
    }
}
