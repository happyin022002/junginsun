/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPITargetBC.java
*@FileTitle : KPI Target Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.vo.KpiPerformanceTargetVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Performancemanagement Business Logic Command Interface<br>
 * - ALPS-Performancemanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface KPITargetBC {


	
	/**
	 * KPI Target 가중치 조회 합니다.<br>
	 * 
	 * @param KpiPerformanceTargetVO KpiPerformanceTargetVO
	 * @return List<KpiPerformanceTargetVO>
	 * @exception EventException
	 */
	public List<KpiPerformanceTargetVO> searchKpiPerformanceTarget(KpiPerformanceTargetVO KpiPerformanceTargetVO) throws EventException;

	/**
	 * KPI Service Category 조회
	 * @param KpiPerformanceTargetVO KpiPerformanceTargetVO
	 * @return List<KpiPerformanceTargetVO>
	 * @throws EventException
	 */
	public List<KpiPerformanceTargetVO> searchSpSvcCateKpi(KpiPerformanceTargetVO KpiPerformanceTargetVO) throws EventException;

	/**
	 * KPI Target 저장
	 * @param KpiPerformanceTargetVO[] KpiPerformanceTargetVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiKpiTargetCreation(KpiPerformanceTargetVO[] KpiPerformanceTargetVOS,SignOnUserAccount account) throws EventException;

	
}