/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EDI_ENS_004EventResponse.java
*@FileTitle : USATruck WO 신고 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-08
*@LastModifier : Park Jun-Yong
*@LastVersion : 1.0
* 2008-07-08 Park Jun-Yong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usatruckediwoack.basic;

import com.clt.framework.core.layer.event.EventException;

/**
 * eNIS-BIZCOMMON Business Logic Command Interface<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Jun-Yong 
 * @see EDI_ENS_004EventResponse 참조
 * @since J2EE 1.4
 */
public interface USATruckEdiWoAckManageBC  {
	
	/**
	 * Receving Data From<br>
	 * 
	 * @param str
	 * @return
	 * @throws EventException
	 */
	public int receiveUSATruckEdiWoAckManageList(String str) throws EventException;
		
}