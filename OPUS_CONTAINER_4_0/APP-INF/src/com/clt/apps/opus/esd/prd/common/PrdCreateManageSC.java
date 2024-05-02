/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCreateManageSC.java
 *@FileTitle : PRD 공통관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-16 jungsunyoung
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.common;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic ServiceCommand<br>
 * PRD에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author jungsunyoung
 * @see EventResponse,PrdCreateManageDBDAO 참조
 * @since J2EE 1.4
 */
public class PrdCreateManageSC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;

	/**
	 * PRD 업무 시나리오 선행작업<br>
	 * PrdCreateManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	@Override
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			if (account.getUsr_id() == null) {
				throw new RuntimeException((new ErrorHandler("PRD00035")).getMessage());
			}
		} catch (Exception e) {
			log.error("PrdCreateManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * PrdCreateManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	@Override
	public void doEnd() {
		log.debug("PrdCreateManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * PRD 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		return new GeneralEventResponse();
	}
}
