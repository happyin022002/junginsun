/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0895Event.java
*@FileTitle : bookingutil
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.09 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ReportItemVO;


/**
 * ESM_BKG_0895 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0895HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0895HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0895Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportItemVO reportItemVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ReportItemVO[] reportItemVOs = null;
	
	/** Table Value Object 조회 조건  */
	private String rptId 			= null;
	private String bkgRptKndCd 		= null;

	public EsmBkg0895Event(){}
	
	public void setReportItemVO(ReportItemVO reportItemVO){
		this. reportItemVO = reportItemVO;
	}

	public void setReportItemVOS(ReportItemVO[] reportItemVOs){
		this. reportItemVOs = reportItemVOs;
	}
	
	public void setBkgRptKndCd(String bkgRptKndCd) {
		this.bkgRptKndCd = bkgRptKndCd;
	}
	
	public void setRptId(String rptId) {
		this.rptId = rptId;
	}
	
	public ReportItemVO getReportItemVO(){
		return reportItemVO;
	}

	public ReportItemVO[] getReportItemVOS(){
		return reportItemVOs;
	}
	
	public String getRptId() {
		return this.rptId;
	}
	
	public String getBkgRptKndCd() {
		return this.bkgRptKndCd;
	}

}