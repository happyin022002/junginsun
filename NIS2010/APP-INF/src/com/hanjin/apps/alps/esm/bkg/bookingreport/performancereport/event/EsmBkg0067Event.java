/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0067Event.java
 *@FileTitle : CndManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.25 김경섭
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.05.16 김상수 [CHM-201109394-01] DPCS 고도화 요청 - B/L Turn Time Report (ESM_BKG_0067) 화면, 쿼리, VO및 java Method들의 전면수정
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPerformanceReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPerformanceSummaryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0067 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_00670HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0067HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0067Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocPerformanceSummaryVO docPerformanceSummaryVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocPerformanceReportInVO docPerformanceReportInVO = null;


	public EsmBkg0067Event(){}


	public DocPerformanceSummaryVO getDocPerformanceSummaryVO() {
		return docPerformanceSummaryVO;
	}

	public void setDocPerformanceSummaryVO(DocPerformanceSummaryVO docPerformanceSummaryVO) {
		this.docPerformanceSummaryVO = docPerformanceSummaryVO;
	}


	public DocPerformanceReportInVO getDocPerformanceReportInVO() {
		return docPerformanceReportInVO;
	}

	public void setDocPerformanceReportInVO(DocPerformanceReportInVO docPerformanceReportInVO) {
		this.docPerformanceReportInVO = docPerformanceReportInVO;
	}

}