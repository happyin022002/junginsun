/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkgEvent.java
*@FileTitle : Unsettled Error B/L Aging Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2016.07.11 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UmchErrBlReportVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_ 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeongmin Cho
 * @see ESM_BKG_0698HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1425Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UmchErrBlReportVO umchErrBlReportVO = null;

	/**
	 * @return the rsltUnmatchStatusReportVO
	 */
	public UmchErrBlReportVO getUmchErrBlReportVO() {
		return umchErrBlReportVO;
	}

	/**
	 * @param umchErrBlReportVO the umchErrBlReportVO to set
	 */
	public void setUmchErrBlReportVO(UmchErrBlReportVO umchErrBlReportVO) {
		this.umchErrBlReportVO = umchErrBlReportVO;
	}


}