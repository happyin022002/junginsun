package com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.basic;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.vo.IfFtCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.vo.IfFtVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * FreeTime 에 대한 Business Logic Command Interface<br>
 * - FreeTime 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SungHoon - Lee
 * @see 
 * @since J2EE 1.6
 */

public interface FreeTimeBC {

	
	/**
	 * 화주가 납부해야될 최종 Demurrage 를 조회합니다. ( SCE 모듈에서만 호출 )
	 * 1) Inland Demurrage (DEL) 에 대한 FreeTime End Date 를 조회합니다.<br>
	 * 2) Inland Demurrage 가 없는 경우, Port Demurrage (POD) 를 조회합니다.<br>
	 * 
	 * @param IfFtCondVO condVO
	 * @return IfFtVO
	 * @exception EventException
	 */	
	public IfFtVO searchFtOfIbDm(IfFtCondVO condVO) throws EventException;
}
