package com.pagination.service;

import com.pagination.entity.Category;
import com.pagination.entity.Member;
import com.pagination.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Page<Member> getMembers(Category category, Pageable pageable) {
        if (category != null) {
            return memberRepository.findByCategory(category, pageable);
        }
        return memberRepository.findAll(pageable);
    }
}
