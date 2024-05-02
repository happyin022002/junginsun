/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EDI_ENS_001EventResponse.java
*@FileTitle : USARail WO 신고 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.basic;

import java.util.ArrayList;
import java.util.Collection;

import com.hanjin.framework.core.layer.event.EventException;

/**
 * eNIS-BIZCOMMON Business Logic Command Interface<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Sang-Woo
 * @see EDI_ENS_002EventResponse 참조
 * @since J2EE 1.4
 */
public interface USARailWoAckManageBC  {
	
	/**
	 * Receving Data From<br>
	 * 
	 * @param str
	 * @return
	 * @throws EventException
	 */
	public int receiveUSARailWoAckManageList(String str) throws EventException;
	
	/**
	 * Receving Data From<br>
	 * 
	 * @param str
	 * @return
	 * @throws EventException
	 */
	public int receiveUSARailReWoAckManageList(String str) throws EventException;
	
	/**
	 * Receving Data From<br>
	 * 
	 * @param str
	 * @return
	 * @throws EventException
	 */
	public Collection searchUSARailWoAckManageList(String str) throws EventException;
	
    /**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry MESSAGE Send FAX
	 * 
	 * @param arr_param
	 * @throws EventException
	 */
	public void faxEdiSendConfirm(ArrayList arr_param) throws EventException;	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry MESSAGE Send E-mail
	 * 
	 * @param arr_param
	 * @throws EventException
	 */
	public void emailEdiSendConfirm(ArrayList arr_param) throws EventException;	
}