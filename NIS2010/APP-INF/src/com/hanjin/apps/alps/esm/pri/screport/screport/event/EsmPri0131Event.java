/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmPri0131Event.java
*@FileTitle : Charge Summary Report BL Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.13
*@LastModifier : 이혜민
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportBlInquiryVO;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;


/**
 * ESM_PRI_0131 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0131HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE HYE MIN
 * @see ESM_PRI_0131HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0131Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	private RptSearchChargeSummaryReportBlInquiryVO rptSearchChargeSummaryReportBlInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	private RptSearchChargeSummaryReportBlInquiryVO[] rptSearchChargeSummaryReportBlInquiryVOs = null;
	
	private String backendjobKey = null;
	
	public EsmPri0131Event(){}
	
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	public void setComBakEndJbVOS(ComBakEndJbVO[] comBakEndJbVOs){
		this.comBakEndJbVOs = comBakEndJbVOs;
	}
	
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	public ComBakEndJbVO[] getComBakEndJbVOS(){
		return comBakEndJbVOs;
	}
	
	public void setRptSearchChargeSummaryReportBlInquiryVO(RptSearchChargeSummaryReportBlInquiryVO rptSearchChargeSummaryReportBlInquiryVO){
		this. rptSearchChargeSummaryReportBlInquiryVO = rptSearchChargeSummaryReportBlInquiryVO;
	}

	public void setRptSearchChargeSummaryReportBlInquiryVOS(RptSearchChargeSummaryReportBlInquiryVO[] rptSearchChargeSummaryReportBlInquiryVOs){
		this. rptSearchChargeSummaryReportBlInquiryVOs = rptSearchChargeSummaryReportBlInquiryVOs;
	}

	public RptSearchChargeSummaryReportBlInquiryVO getRptSearchChargeSummaryReportBlInquiryVO(){
		return rptSearchChargeSummaryReportBlInquiryVO;
	}

	public RptSearchChargeSummaryReportBlInquiryVO[] getRptSearchChargeSummaryReportBlInquiryVOS(){
		return rptSearchChargeSummaryReportBlInquiryVOs;
	}
	
	/**
	 * @return the backendjobKey
	 */
	public String getBackendjobKey() {
		return backendjobKey;
	}

	/**
	 * @param backendjobKey the backendjobKey to set
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
	}

}