/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0256Event.java
*@FileTitle : Unmatch B/L Inquiry by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.22 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event;

import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchStatusReportVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0564 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0564HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_BKG_0698HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0564Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltUnmatchStatusReportVO rsltUnmatchStatusReportVO = null;

	/**
	 * @return the rsltUnmatchStatusReportVO
	 */
	public RsltUnmatchStatusReportVO getRsltUnmatchStatusReportVO() {
		return rsltUnmatchStatusReportVO;
	}

	/**
	 * @param rsltUnmatchStatusReportVO the rsltUnmatchStatusReportVO to set
	 */
	public void setRsltUnmatchStatusReportVO(
			RsltUnmatchStatusReportVO rsltUnmatchStatusReportVO) {
		this.rsltUnmatchStatusReportVO = rsltUnmatchStatusReportVO;
	}


}