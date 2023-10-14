package com.pagination.repository;

import com.pagination.entity.Category;
import com.pagination.entity.Member;

import java.util.List;

public interface MemberRepositoryQuerydsl {
    public List<Member> findAllAfterCursor(String cursor, int limit, Category category);
}
