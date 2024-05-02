/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1012Event.java
*@FileTitle : KPI Performance Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.spe.performancemanagement.kpiperformance.vo.KpiPerformanceVO;


/**
 * ESD_SPE_1012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	KpiPerformanceVO kpiPerformanceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	KpiPerformanceVO[] kpiPerformanceVOs = null;

	public EsdSpe1012Event(){}
	
	public void setKpiPerformanceVO(KpiPerformanceVO kpiPerformanceVO){
		this. kpiPerformanceVO = kpiPerformanceVO;
	}

	public void setKpiPerformanceVOs(KpiPerformanceVO[] kpiPerformanceVOs){
		this. kpiPerformanceVOs = kpiPerformanceVOs;
	}

	public KpiPerformanceVO getKpiPerformanceVO(){
		return kpiPerformanceVO;
	}

	public KpiPerformanceVO[] getKpiPerformanceVOs(){
		return kpiPerformanceVOs;
	}

}