/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPIPerformanceBC.java
*@FileTitle : KPI Performance Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.vo.KpiPerformanceVO;

/**
 * ALPS-Performancemanagement Business Logic Command Interface<br>
 * - ALPS-Performancemanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface KPIPerformanceBC {




	/**
	 * KPI Performance 내용 조회
	 * @param KpiPerformanceVO kpiPerformanceVO
	 * @param SignOnUserAccount account
	 * @return List<KpiPerformanceVO>
	 */
	public List<KpiPerformanceVO> searchKpiPerformanceCfm(KpiPerformanceVO kpiPerformanceVO,SignOnUserAccount account) throws EventException;

	/**
	 * KPI Performance 저장
	 * @param kpiPerformanceVOS
	 * @param account
	 */
	public void multiKpiPerformanceCfm(KpiPerformanceVO[] kpiPerformanceVOS, SignOnUserAccount account)  throws EventException;
}