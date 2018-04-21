package com.alegerd.dao;

import com.alegerd.model.Subject;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDao extends GenericDao<Subject, Long>{

    public SubjectDao() {
        super(Subject.class);
    }
}
