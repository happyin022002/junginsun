/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0896Event.java
*@FileTitle : BookingReport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.05.28 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.specialreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.BkgRptSetVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0896 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0896HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG-0896HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmBkg0896Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgRptSetVO bkgRptSetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgRptSetVO[] bkgRptSetVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportTemplateListVO reportTemplateListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ReportTemplateListVO[] reportTemplateListVOs = null;
	
	/** Table Value Object 조회 조건  */
	private String usrId 			= null;
	private String rptId 			= null;
	private String bkgRptKndCd 		= null;

	public EsmBkg0896Event(){}
	
	public void setBkgRptSetVO(BkgRptSetVO bkgRptSetVO){
		this. bkgRptSetVO = bkgRptSetVO;
	}

	public void setBkgRptSetVOS(BkgRptSetVO[] bkgRptSetVOs){
		if(bkgRptSetVOs != null){
			BkgRptSetVO[] tmpVOs = Arrays.copyOf(bkgRptSetVOs, bkgRptSetVOs.length);
			this.bkgRptSetVOs = tmpVOs;
		}
	}

	public void setReportTemplateListVO(ReportTemplateListVO reportTemplateListVO){
		this. reportTemplateListVO = reportTemplateListVO;
	}

	public void setReportTemplateListVOS(ReportTemplateListVO[] reportTemplateListVOs){
		if(reportTemplateListVOs != null){
			ReportTemplateListVO[] tmpVOs = Arrays.copyOf(reportTemplateListVOs, reportTemplateListVOs.length);
			this.reportTemplateListVOs = tmpVOs;
		}
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	public void setBkgRptKndCd(String bkgRptKndCd) {
		this.bkgRptKndCd = bkgRptKndCd;
	}
	
	public void setRptId(String rptId) {
		this.rptId = rptId;
	}
	
	public BkgRptSetVO getBkgRptSetVO(){
		return bkgRptSetVO;
	}

	public BkgRptSetVO[] getBkgRptSetVOS(){
		BkgRptSetVO[] rtnVOs = null;
		if(this.bkgRptSetVOs != null){
			rtnVOs= Arrays.copyOf(bkgRptSetVOs, bkgRptSetVOs.length);
		}
		return rtnVOs;
	}

	public ReportTemplateListVO getReportTemplateListVO(){
		return reportTemplateListVO;
	}

	public ReportTemplateListVO[] getReportTemplateListVOS(){
		ReportTemplateListVO[] rtnVOs = null;
		if(this.reportTemplateListVOs != null){
			rtnVOs= Arrays.copyOf(reportTemplateListVOs, reportTemplateListVOs.length);
		}
		return rtnVOs;
	}
	
	public String getUsrId() {
		return this.usrId;
	}
	
	public String getRptId() {
		return this.rptId;
	}
	
	public String getBkgRptKndCd() {
		return this.bkgRptKndCd;
	}

}