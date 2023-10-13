package com.pagination;

import com.pagination.entity.Category;
import com.pagination.entity.Member;
import com.pagination.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Init {
    private final InitMember initMember;

    @PostConstruct
    public void init() {
        initMember.init();
    }

    @Component
    @RequiredArgsConstructor
    static class InitMember {
        private final MemberRepository memberRepository;

        public void init() {
            for (int i = 0; i < 100; i++) {
                memberRepository.save(new Member("student" + i, Category.STUDENT));
            }
            for (int i = 0; i < 100; i++) {
                memberRepository.save(new Member("teacher" + i, Category.TEACHER));
            }
        }
    }
}
