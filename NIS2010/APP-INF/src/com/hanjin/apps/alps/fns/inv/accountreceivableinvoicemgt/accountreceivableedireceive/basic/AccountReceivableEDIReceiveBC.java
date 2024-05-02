/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableEDIReceiveBCImpl.java
 *@FileTitle : Glovis EDI Submission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.12.01
 *@LastModifier : 이석준
 *@LastVersion : 1.0
 *  2011.12.01 이석준
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.12.01 이석준 [CHM-201006884] AR Inovice module내 EDI Submission기능 추가 개발(2차) to Glovis 
 * 2011.02.14 최도순 [CHM-201006644] NIKE, Invoice EDI 신규 개발 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInputVO;
import com.hanjin.framework.core.layer.event.EventException;

/** 
 * ALPS-Accountreceivableinvoicemgt Business Logic Command Interface<br>
 * - ALPS-Accountreceivableinvoicemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author SUK JOON
 * @see UbizhjsAlpsinvGlovisEvent 참조
 * @since J2EE 1.4
 */

public interface AccountReceivableEDIReceiveBC {
	
	/**
	 * Glovis로부터 들어온 EDI Message 수신
	 * 
	 * @param String rcvMsg
	 * @param String userId
	 * @param String integrationId
	 * @exception EventException
	 */
	public void receiveEdiFromGlovis(String rcvMsg, String userId, String integrationId) throws EventException;
	
	/**
	 * EDI Message를 table에 저장
	 * 
	 * @param String rcvMsg
	 * @param String userId
	 * @param String integrationId
	 * @exception EventException
	 */
	public void receiveCommonEdi(String rcvMsg, String userId, String integrationId) throws EventException;
	
}