/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0080Event.java
*@FileTitle : EQ Receivable Charge Summary by Charge Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.24 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReportSearchReceivableVO;


/**
 * EES_LSE_0080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0080HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0080Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportSearchReceivableVO reportSearchReceivableVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ReportSearchReceivableVO[] reportSearchReceivableVOs = null;

	public EesLse0080Event(){}
	
	public void setReportSearchReceivableVO(ReportSearchReceivableVO reportSearchReceivableVO){
		this. reportSearchReceivableVO = reportSearchReceivableVO;
	}

	public void setReportSearchReceivableVOS(ReportSearchReceivableVO[] reportSearchReceivableVOs){
		this. reportSearchReceivableVOs = reportSearchReceivableVOs;
	}

	public ReportSearchReceivableVO getReportSearchReceivableVO(){
		return reportSearchReceivableVO;
	}

	public ReportSearchReceivableVO[] getReportSearchReceivableVOS(){
		return reportSearchReceivableVOs;
	}

}