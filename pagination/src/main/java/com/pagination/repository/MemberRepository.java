package com.pagination.repository;

import com.pagination.entity.Category;
import com.pagination.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryQuerydsl {
    Page<Member> findByCategory (Category category, Pageable pageable);
    Page<Member> findAll(Pageable pageable);
}
