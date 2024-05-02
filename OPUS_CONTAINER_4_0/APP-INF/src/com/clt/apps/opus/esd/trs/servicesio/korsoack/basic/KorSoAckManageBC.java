/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : KorSoAckManageBC.java
*@FileTitle : Kor  정보
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.korsoack.basic;

import com.clt.framework.core.layer.event.EventException;

/**
 * eNIS-BIZCOMMON Business Logic Command Interface<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Sang-Woo
 * @see EDI_ENS_003EventResponse 참조
 * @since J2EE 1.4
 */
public interface KorSoAckManageBC  {
	
	/**
	 * Receving Data From<br>
	 * 
	 * @param str
	 * @return
	 * @throws EventException
	 */
	public int receiveKorSoAckManage(String str)  throws EventException;
	
}