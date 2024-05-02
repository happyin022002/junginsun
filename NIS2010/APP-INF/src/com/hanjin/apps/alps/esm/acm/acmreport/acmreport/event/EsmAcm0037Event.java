/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0037Event.java
*@FileTitle : Commission Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.09.04 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.event;

import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CommReportVO;
import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.ReportItemVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0037HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportItemVO reportItemVO = null;
	private CommReportVO commReportVO = null;

	public EsmAcm0037Event() {}

	public ReportItemVO getReportItemVO() {
		return reportItemVO;
	}

	public void setReportItemVO(ReportItemVO reportItemVO) {
		this.reportItemVO = reportItemVO;
	}

	public CommReportVO getCommReportVO() {
		return commReportVO;
	}

	public void setCommReportVO(CommReportVO commReportVO) {
		this.commReportVO = commReportVO;
	}

}
