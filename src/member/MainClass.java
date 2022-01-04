package member;

import java.util.ArrayList;

import com.njy.util.Util;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.MemberDto;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Hello! It's MemberDB");
		// 멤버 정보 DB 활용
		

		// 파일에 있는 데이터를 읽어오기
		String filePath = "C:/Users/pc/Desktop/eclipse_workspace/전공정보.txt";
		
		// DB 연결
		MemberDao dao = new MemberDaoImpl();
		MemberDto dto = new MemberDto();
	
		
		// 읽어 온 데이터를 DB에 넣기
		Member member = new Member();
		ArrayList<MemberDto> list = member.getMemberList(filePath);
		for(MemberDto d : list) {
			dao.insert(d);
		}
		
//		for(MemberDto d:list) {
//		System.out.println(d.getNum());
//		System.out.println(d.getName());
//		System.out.println(d.getMajor());
//		System.out.println(d.getEmail());
//	}
	
		
		// 데이터 보기
		ArrayList<MemberDto> MList = dao.selectAll();
		for(MemberDto d : MList) {
			System.out.println(d.getNum());
			System.out.println(d.getName());
			System.out.println(d.getMajor());
			System.out.println(d.getEmail());
		}
		
		// 데이터 수정
//		dao.update(1);
	}

}
