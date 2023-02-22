package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户详细信息对象 user_profile
 * 
 * @author ruoyi
 * @date 2023-02-22
 */
public class UserProfile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long id;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfBirth;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String nativeplace;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicsstatus;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNumber;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 聘用形式 */
    @Excel(name = "聘用形式")
    private String employment;

    /** 入职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date Entrytime;

    /** 离职日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dimissiontime;

    /** 最高学历 */
    @Excel(name = "最高学历")
    private String highestEducation;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String university;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setDateOfBirth(Date dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() 
    {
        return dateOfBirth;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setNativeplace(String nativeplace) 
    {
        this.nativeplace = nativeplace;
    }

    public String getNativeplace() 
    {
        return nativeplace;
    }
    public void setNation(String nation) 
    {
        this.nation = nation;
    }

    public String getNation() 
    {
        return nation;
    }
    public void setPoliticsstatus(String politicsstatus) 
    {
        this.politicsstatus = politicsstatus;
    }

    public String getPoliticsstatus() 
    {
        return politicsstatus;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setEmployment(String employment) 
    {
        this.employment = employment;
    }

    public String getEmployment() 
    {
        return employment;
    }
    public void setEntrytime(Date Entrytime) 
    {
        this.Entrytime = Entrytime;
    }

    public Date getEntrytime() 
    {
        return Entrytime;
    }
    public void setDimissiontime(Date dimissiontime) 
    {
        this.dimissiontime = dimissiontime;
    }

    public Date getDimissiontime() 
    {
        return dimissiontime;
    }
    public void setHighestEducation(String highestEducation) 
    {
        this.highestEducation = highestEducation;
    }

    public String getHighestEducation() 
    {
        return highestEducation;
    }
    public void setUniversity(String university) 
    {
        this.university = university;
    }

    public String getUniversity() 
    {
        return university;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("gender", getGender())
            .append("age", getAge())
            .append("dateOfBirth", getDateOfBirth())
            .append("country", getCountry())
            .append("nativeplace", getNativeplace())
            .append("nation", getNation())
            .append("politicsstatus", getPoliticsstatus())
            .append("city", getCity())
            .append("address", getAddress())
            .append("phoneNumber", getPhoneNumber())
            .append("email", getEmail())
            .append("employment", getEmployment())
            .append("Entrytime", getEntrytime())
            .append("dimissiontime", getDimissiontime())
            .append("highestEducation", getHighestEducation())
            .append("university", getUniversity())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
