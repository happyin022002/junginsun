/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1010Event.java
*@FileTitle : KPI Target Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.event;

import com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.vo.KpiPerformanceTargetVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_SPE_1010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	


	/** Table Value Object 조회 조건 및 단건 처리  */
	KpiPerformanceTargetVO kpiPerformanceTargetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	KpiPerformanceTargetVO[] kpiPerformanceTargetVOs = null;
	
	public EsdSpe1010Event(){}
	

	public KpiPerformanceTargetVO getKpiPerformanceTargetVO() {
		return kpiPerformanceTargetVO;
	}

	public void setKpiPerformanceTargetVO(
			KpiPerformanceTargetVO kpiPerformanceTargetVO) {
		this.kpiPerformanceTargetVO = kpiPerformanceTargetVO;
	}

	public KpiPerformanceTargetVO[] getKpiPerformanceTargetVOs() {
		return kpiPerformanceTargetVOs;
	}

	public void setKpiPerformanceTargetVOs(
			KpiPerformanceTargetVO[] kpiPerformanceTargetVOs) {
		this.kpiPerformanceTargetVOs = kpiPerformanceTargetVOs;
	}

	
}