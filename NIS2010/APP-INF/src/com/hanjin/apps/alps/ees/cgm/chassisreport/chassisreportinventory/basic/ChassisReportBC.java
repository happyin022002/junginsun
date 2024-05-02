/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisReportBC.java
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.04.16 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.vo.LandInvMonitoringVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ChassisReport Business Logic Command Interface<br>
 * - ALPS-ChassisReport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Choi, Duk Woo
 * @see Ees_cgm_1028EventResponse 참조
 * @since J2EE 1.4 
 */

public interface ChassisReportBC {
	
	/**
	 * [EES_CGM_1157] Summary Tab Back End Job 시작<br>
	 *
	 * @param LandInvMonitoringVO landInvMonitoringVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobSearchLandInvMonitoringSummary(LandInvMonitoringVO landInvMonitoringVO, SignOnUserAccount account);
	
	/**
	 * [EES_CGM_1157] Detail Tab Back End Job 시작<br>
	 *
	 * @param LandInvMonitoringVO landInvMonitoringVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobSearchLandInvMonitoringDetail(LandInvMonitoringVO landInvMonitoringVO, SignOnUserAccount account);

	/**
	 * BackEndJob공통 - Back End Job Status 조회<br>
	 *  (동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException;

	/**
	 * [EES_CGM_1157] Back End Job 처리결과 return<br>
	 *   (Land Inventory Monitoring 목록을 조회)
	 *
	 * @param String backEndJobKey
	 * @return List<LandInvMonitoringVO>
	 * @exception EventException
	 */
	public List<LandInvMonitoringVO> resultBackEndJobSearchLandInvMonitoring(String backEndJobKey) throws EventException;
		
	/**
	 * [EES_CGM_1157]<br>
	 * TP/SZ List의 정보를 조회<br>
	 *
	 * @return List<LandInvMonitoringVO>
	 * @exception EventException
	 */
	public List<LandInvMonitoringVO> searchTpszList() throws EventException;

}
