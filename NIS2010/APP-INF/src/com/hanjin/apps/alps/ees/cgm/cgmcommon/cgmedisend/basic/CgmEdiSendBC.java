/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmEdiSendBC.java
*@FileTitle : CgmEdiSend
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2016.07.18 두기민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.vo.CgmEdiPodBookingListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Cgmcommon Business Logic Command Interface<br>
 * - ALPS-Cgmcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author DOO KI MIN
 * @see  참조 미정
 * @since J2EE 1.4
 */
public interface CgmEdiSendBC {
	/**
	 * 오늘 시점에서 VVD의 bkg중에 미주(US,CA) POD 인것을 조회합니다.<br>
	 *
	 * @return List<List<CgmEdiPodBookingListVO>>
	 * @exception EventException
	 */
	public List<List<CgmEdiPodBookingListVO>> searchEdiToUsCaImport() throws EventException ;
	
	/**
	 * 오늘시점에서 어제 하루동안 생성된 bkg (export)  POL이 미주 및 캐나다 인것을 조회합니다.<br>
	 *
	 * @return List<List<CgmEdiPodBookingListVO>>
	 * @exception EventException
	 */
	public List<List<CgmEdiPodBookingListVO>> searchEdiToUsCaExport() throws EventException ;
	
	/**
	 * 미주 및 캐나다에 EDI를 전송합니다.<br>
	 *
	 * @param List<List<CgmEdiPodBookingListVO>> arrList
	 * @return String
	 * @exception EventException
	 */
	public String sendEdiToUsCa(List<List<CgmEdiPodBookingListVO>> arrList) throws EventException ;

}
