/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementApprovalBC.java
*@FileTitle : Agreement Approval 권한 등록
*Open Issues :
*Change history :
*@LastModifyDate : 2014-05-28
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014-05-28 최종혁
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.basic;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchApprovalMgmtVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author agreement
 * @see EsdTrs0237EventResponse 참조
 * @since J2EE 1.6
 */
public interface AgreementApprovalBC  {

	/**
	 * Agreement 결재자 리스트 조회<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchApprovalList(Event e, SignOnUserAccount account) throws EventException;
	
	/**
	 * Agreement 결재자 리스트 조회 저장<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse saveApprovalList(Event e, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Agreement 결재자 리스트 조회 삭제<br>
	 * 
	 * @param e Event
	 * @param account SignOnUserAccount 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse delApprovalList(Event e, SignOnUserAccount account) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Sheet에 USER ID로 USER NAME을 가져오는 이벤트 처리<br>
	 * @param e Event
	 * @return String
	 * @throws EventException
	 */
	public SearchApprovalMgmtVO searchUsrId(Event e) throws EventException ;

}

