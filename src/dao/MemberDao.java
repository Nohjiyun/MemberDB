package dao;

import java.util.ArrayList;

import dto.MemberDto;

public interface MemberDao {
	
	// 데이터 넣기
		public void insert(MemberDto dto);
		
		// 데이터 보기
		
		// 데이터 한개 보기
		public MemberDto selectOne(int n);
		
		// 데이터 전체 보기	
		public ArrayList<MemberDto> selectAll();
			
		// 데이터 수정
		public void update(MemberDto dto);
	
}
