/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0118Event.java
*@FileTitle : Customized Report Form
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.09.17 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmreport.acmreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmreport.acmreport.vo.ReportItemVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0118 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0118HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0118HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0118Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportItemVO reportItemVO = null;

	/** Table Value Object Multi Data 처리 */
	private ReportItemVO[] reportItemVOs = null;

	public EsmAcm0118Event() {}

	public ReportItemVO getReportItemVO() {
		return reportItemVO;
	}

	public void setReportItemVO(ReportItemVO reportItemVO) {
		this.reportItemVO = reportItemVO;
	}

	public ReportItemVO[] getReportItemVOs() {
		ReportItemVO[] rtnVOs = null;
		if (this.reportItemVOs != null) {
			rtnVOs = Arrays.copyOf(reportItemVOs, reportItemVOs.length);
		}
		return rtnVOs;
	}

	public void setReportItemVOs(ReportItemVO[] reportItemVOs) {
		if(reportItemVOs != null){
			ReportItemVO[] tmpVOs = Arrays.copyOf(reportItemVOs, reportItemVOs.length);
			this.reportItemVOs  = tmpVOs;
		}
	}

}
