/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseSubleaseBC.java
*@FileTitle : 임차 및 반납 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.09 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusGrpVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusReportListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Equipmentleasehistory Business Logic Command Interface<br>
 * - ALPS-Equipmentleasehistory에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Ho Sun
 * @see Ees_mst_0029EventResponse 참조
 * @since J2EE 1.6
 */

public interface LeaseSubleaseBC {
	/**
	 * EES_MST_0029 : retrieve<br>
	 * Container Status Inquiry 화면에 대한 조회를 합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0029_1
	 * @category searchCntrStatusListByCntrNoBasic     
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return CntrStatusGrpVO
	 * @exception EventException
	 */
	public CntrStatusGrpVO searchCntrStatusListByCntrNoBasic(CntrStatusOptionVO cntrStatusOptionVO) throws EventException;
	/**
	 * EES_MST_0035 : retrieve<br>
	 * Container Check Digit and Container Checking Inquiry 화면에 대한 조회 이벤트 처리<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0035_1
	 * @category searchCntrCheckDigitListBasic    
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrStatusListVO>
	 * @exception EventException
	 */
	public List<CntrStatusListVO> searchCntrCheckDigitListBasic(CntrStatusOptionVO cntrStatusOptionVO) throws EventException;
	
	/**
	 * EES_MST_0027 : retrieve<br>
	 * Lost & Found에 의한 Container Status List를 조회합니다.<br>
	 * 
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrStatusReportListVO>	
	 * @exception EventException
	 */	
	public List<CntrStatusReportListVO> searchCntrStatusReportListBasic(CntrStatusOptionVO cntrStatusOptionVO) throws EventException;	
	
}