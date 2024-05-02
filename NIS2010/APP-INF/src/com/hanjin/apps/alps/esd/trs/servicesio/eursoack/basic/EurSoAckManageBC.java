/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EurSoAckManageBC.java
*@FileTitle : Eur S/O  정보
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.eursoack.basic;

import com.hanjin.framework.core.layer.event.EventException;

/**
 * eNIS-BIZCOMMON Business Logic Command Interface<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Sang-Woo
 * @see EDI_ENS_002EventResponse 참조
 * @since J2EE 1.4
 */
public interface EurSoAckManageBC  {
	
	/**
	 * Receving Data From<br>
	 * 
	 * @param str
	 * @return
	 * @throws EventException
	 */
	public int receiveEurSoAckManage(String str)  throws EventException;
	
}