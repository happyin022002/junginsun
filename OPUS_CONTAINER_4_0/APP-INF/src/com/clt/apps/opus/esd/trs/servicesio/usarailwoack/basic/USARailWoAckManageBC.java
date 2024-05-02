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
package com.clt.apps.opus.esd.trs.servicesio.usarailwoack.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;

/**
 * eNIS-BIZCOMMON Business Logic Command Interface<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Lee Sang-Woo
 * @see EDI_ENS_002EventResponse 참조
 * @since J2EE 1.4
 */
public interface USARailWoAckManageBC {

	/**
	 * Receving Data From<br>
	 * 
	 * @param param
	 * @return
	 * @throws EventException
	 */
	public int receiveUSARailWoAckManageList(HashMap<Object, Object> param) throws EventException;

	/**
	 * Receving Data From<br>
	 * 
	 * @param param
	 * @return
	 * @throws EventException
	 */
	public int receiveManageUSARail417WoAck(HashMap<Object, Object> param) throws EventException;

	/**
	 * Receving Data From<br>
	 * 
	 * @param param
	 * @return
	 * @throws EventException
	 */
	public int receiveUSARailReWoAckManageList(HashMap<Object, Object> param) throws EventException;

	/**
	 * Receving Data From<br>
	 * 
	 * @param param
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public Collection searchUSARailWoAckManageList(HashMap<Object, Object> param) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry MESSAGE Send FAX
	 * 
	 * @param arr_param
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public void faxEdiSendConfirm(ArrayList arr_param) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry MESSAGE Send E-mail
	 * 
	 * @param arr_param
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public void emailEdiSendConfirm(ArrayList arr_param) throws EventException;

	/**
	 * 
	 * @param params
	 * @return
	 * @throws EventException
	 */
	public DBRowSet searchCreditSeqUsaEdiCd(HashMap<String, String> params) throws EventException;
}