/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0110Event.java
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.25 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaPerformanceReportInVO;


/**
 * ESM_BKG_0110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0110HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0110Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CaPerformanceReportInVO caPerformanceReportInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CaPerformanceReportInVO[] caPerformanceReportInVOs = null;

	public EsmBkg0110Event(){}
	
	public void setCaPerformanceReportInVO(CaPerformanceReportInVO caPerformanceReportInVO){
		this. caPerformanceReportInVO = caPerformanceReportInVO;
	}

	public void setCaPerformanceReportInVOS(CaPerformanceReportInVO[] caPerformanceReportInVOs){
		this. caPerformanceReportInVOs = caPerformanceReportInVOs;
	}

	public CaPerformanceReportInVO getCaPerformanceReportInVO(){
		return caPerformanceReportInVO;
	}

	public CaPerformanceReportInVO[] getCaPerformanceReportInVOS(){
		return caPerformanceReportInVOs;
	}

}