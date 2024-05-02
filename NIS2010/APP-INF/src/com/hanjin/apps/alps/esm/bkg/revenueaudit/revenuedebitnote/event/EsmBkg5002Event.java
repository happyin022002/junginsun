/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkgEvent.java
*@FileTitle : Unsettled RDN Aging Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2016.07.11 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.UnStlRdnReportVO;
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

public class EsmBkg5002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UnStlRdnReportVO unStlRdnReportVO = null;

	/**
	 * @return the rsltUnmatchStatusReportVO
	 */
	public UnStlRdnReportVO getUnStlRdnReportVO() {
		return unStlRdnReportVO;
	}

	/**
	 * @param unStlRdnReportVO the unStlRdnReportVO to set
	 */
	public void setUnStlRdnReportVO(UnStlRdnReportVO unStlRdnReportVO) {
		this.unStlRdnReportVO = unStlRdnReportVO;
	}


}