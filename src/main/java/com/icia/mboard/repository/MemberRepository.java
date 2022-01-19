package com.icia.mboard.repository;

import com.icia.mboard.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    MemberEntity findByMemberEmail(String MemberEmail);

}
