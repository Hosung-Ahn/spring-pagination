package com.pagination.repository;

import com.pagination.entity.Category;
import com.pagination.entity.Member;
import com.pagination.entity.QMember;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.pagination.entity.QMember.*;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberRepositoryQuerydslImpl implements MemberRepositoryQuerydsl{
    private final JPAQueryFactory query;
    @Override
    public List<Member> findAllAfterCursor(String cursor, int limit, Category category) {
        BooleanBuilder whereClause = new BooleanBuilder();

        if (cursor != null) {
            LocalDateTime cursorDateTime = LocalDateTime.parse(cursor);
            whereClause.and(member.updatedAt.lt(cursorDateTime));
        }

        if (category != null) {
            whereClause.and(member.category.eq(category));
        }

        List<Member> result = query
                .selectFrom(member)
                .where(whereClause)
                .orderBy(member.updatedAt.desc())
                .limit(limit)
                .fetch();

        return result;
    }
}
