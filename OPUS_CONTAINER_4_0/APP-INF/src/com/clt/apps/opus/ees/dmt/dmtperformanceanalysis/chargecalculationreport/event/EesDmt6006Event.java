/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt6006Event.java
*@FileTitle : Summary Report by Customer - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.01 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerParmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_6006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_6006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_6006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt6006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SummaryReportByCustomerParmVO summaryReportByCustomerParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SummaryReportByCustomerParmVO[] summaryReportByCustomerParmVOs = null;

	public EesDmt6006Event(){}
	
	public void setSummaryReportByCustomerParmVO(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO){
		this. summaryReportByCustomerParmVO = summaryReportByCustomerParmVO;
	}

	public void setSummaryReportByCustomerParmVOS(SummaryReportByCustomerParmVO[] summaryReportByCustomerParmVOs){
		if (summaryReportByCustomerParmVOs != null) {
			SummaryReportByCustomerParmVO[] tmpVOs = new SummaryReportByCustomerParmVO[summaryReportByCustomerParmVOs.length];
			System.arraycopy(summaryReportByCustomerParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.summaryReportByCustomerParmVOs = tmpVOs;
		}
	}

	public SummaryReportByCustomerParmVO getSummaryReportByCustomerParmVO(){
		return summaryReportByCustomerParmVO;
	}

	public SummaryReportByCustomerParmVO[] getSummaryReportByCustomerParmVOS(){
		SummaryReportByCustomerParmVO[] tmpVOs = null;
		if (this.summaryReportByCustomerParmVOs != null) {
			tmpVOs = new SummaryReportByCustomerParmVO[summaryReportByCustomerParmVOs.length];
			System.arraycopy(summaryReportByCustomerParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}