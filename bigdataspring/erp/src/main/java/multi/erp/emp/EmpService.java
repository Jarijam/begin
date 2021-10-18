package multi.erp.emp;

import java.util.List;

public interface EmpService { //하니의 job에 대한 논리적인 작업
	int insert(EmpVO user);
	List<EmpVO> getMemberList();
	boolean idCheck(String id);
	EmpVO login(EmpVO loginUser);
}
