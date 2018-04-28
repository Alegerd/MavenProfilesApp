package com.alegerd.dao;

import com.alegerd.dao.generic.GenericDao;
import com.alegerd.model.GroupEntity;
import com.alegerd.model.User;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupDao extends GenericDao<GroupEntity, Long> {

    public GroupDao() {
        super(GroupEntity.class);
    }

    public List<User> getAllStudentsInGroupById(Long groupId){
        GroupEntity group = (GroupEntity)getManager().createQuery("select g from GroupEntity g where g.id=:groupId")
                .setParameter("groupId", groupId)
                .getSingleResult();

        return new ArrayList<>(group.getStudents());
    }

    public List<User> getAllStudentsInDepartmentOnCourse(Long depId, Date start, Date finish){
        List<GroupEntity> groups = getManager().createQuery("select g from GroupEntity g where g.department.id=:depId and g.admissionDate between :start and :finish")
                .setParameter("depId", depId)
                .setParameter("start", start)
                .setParameter("finish", finish)
                .getResultList();

        List<User> students = new ArrayList<>();
        for (GroupEntity group :
                groups) {
            group.getStudents().forEach((student)->students.add(student));
        }

        return students;
    }

    public List<User> getAllStudentsInDepartment(Long depId){
        List<GroupEntity> groups = getManager().createQuery("select g from GroupEntity g where g.department.id=:depId")
                .setParameter("depId", depId)
                .getResultList();

        List<User> students = new ArrayList<>();
        for (GroupEntity group :
                groups) {
            group.getStudents().forEach((student)->students.add(student));
        }

        return students;
    }
}
