package org.sopt.practice.service.dto;

import org.sopt.practice.domain.Member;
import org.sopt.practice.domain.Part;

import java.util.ArrayList;
import java.util.List;

public record MemberFindDto(
        String name,
        Part part,
        int age
) {

    public static MemberFindDto of(Member member) {
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }

    public static List<MemberFindDto> ofAll(List<Member> members) {
        List<MemberFindDto> allMemberFindDto = new ArrayList<MemberFindDto>();
        for (Member m : members) {
            allMemberFindDto.add(new MemberFindDto(m.getName(), m.getPart(), m.getAge()));
        }
        return allMemberFindDto;
    }
}
