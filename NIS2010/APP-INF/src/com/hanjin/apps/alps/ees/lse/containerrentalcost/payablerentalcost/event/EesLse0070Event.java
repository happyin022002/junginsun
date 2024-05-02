/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0070Event.java
*@FileTitle : EQ Payable Charge Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.25 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.ReportSearchPayableVO;


/**
 * EES_LSE_0070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0070HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0070Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportSearchPayableVO reportSearchPayableVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ReportSearchPayableVO[] reportSearchPayableVOs = null;

	public EesLse0070Event(){}
	
	public void setReportSearchPayableVO(ReportSearchPayableVO reportSearchPayableVO){
		this. reportSearchPayableVO = reportSearchPayableVO;
	}

	public void setReportSearchPayableVOS(ReportSearchPayableVO[] reportSearchPayableVOs){
		this. reportSearchPayableVOs = reportSearchPayableVOs;
	}

	public ReportSearchPayableVO getReportSearchPayableVO(){
		return reportSearchPayableVO;
	}

	public ReportSearchPayableVO[] getReportSearchPayableVOS(){
		return reportSearchPayableVOs;
	}

}