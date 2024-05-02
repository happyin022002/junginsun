/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt6005Event.java
*@FileTitle : Summary Report by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.29 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerParmVO;


/**
 * EES_DMT_6005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_6005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_6005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt6005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SummaryReportByCustomerParmVO summaryReportByCustomerParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SummaryReportByCustomerParmVO[] summaryReportByCustomerParmVOs = null;

	public EesDmt6005Event(){}
	
	public void setSummaryReportByCustomerParmVO(SummaryReportByCustomerParmVO summaryReportByCustomerParmVO){
		this. summaryReportByCustomerParmVO = summaryReportByCustomerParmVO;
	}

	public void setSummaryReportByCustomerParmVOS(SummaryReportByCustomerParmVO[] summaryReportByCustomerParmVOs){
		this. summaryReportByCustomerParmVOs = summaryReportByCustomerParmVOs;
	}

	public SummaryReportByCustomerParmVO getSummaryReportByCustomerParmVO(){
		return summaryReportByCustomerParmVO;
	}

	public SummaryReportByCustomerParmVO[] getSummaryReportByCustomerParmVOS(){
		return summaryReportByCustomerParmVOs;
	}

}