/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1021Event.java
*@FileTitle : KPI Detail Report by KPI
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.spe.performancereport.kpidetailreportbykpi.vo.KPIDetailReportVO;


/**
 * ESD_SPE_1021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	KPIDetailReportVO kPIDetailReportVO = null;
	
	/** Table Value Object Multi Data 처리 */
	KPIDetailReportVO[] kPIDetailReportVOs = null;

	public EsdSpe1021Event(){}

	public KPIDetailReportVO getkPIDetailReportVO() {
		return kPIDetailReportVO;
	}

	public void setkPIDetailReportVO(KPIDetailReportVO kPIDetailReportVO) {
		this.kPIDetailReportVO = kPIDetailReportVO;
	}

	public KPIDetailReportVO[] getkPIDetailReportVOs() {
		return kPIDetailReportVOs;
	}

	public void setkPIDetailReportVOs(KPIDetailReportVO[] kPIDetailReportVOs) {
		this.kPIDetailReportVOs = kPIDetailReportVOs;
	}
	


}