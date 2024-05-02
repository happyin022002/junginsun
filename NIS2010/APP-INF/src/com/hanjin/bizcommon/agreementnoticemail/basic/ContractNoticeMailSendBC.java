/**=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContractNoticeMailSendBC.java
*@FileTitle : Contract Notice Mail Send
*Open Issues :
*Change history :
*@LastModifyDate : 2014-01-24
*@LastModifier : 
*@LastVersion : 1.0
* 2014-01-24
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.agreementnoticemail.basic;

import com.hanjin.framework.core.layer.event.EventException;


/**
 * ALPS-BIZCOMMON Business Logic Command Interface<br>
 * - ALPS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SHIN DONG IL
 * @see  각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public interface ContractNoticeMailSendBC  {
	
	/**
	 * 계약종료 90일 전에 Notice Mail을 보낸다.  
	 * 
	 * @exception EventException 
	 */
	public void sendContractNoticeMail() throws EventException;


}