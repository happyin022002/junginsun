/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0067Event.java
*@FileTitle : EQ Payable Charge Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.25 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event;

import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.ReportSearchPayableVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0067 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0067HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0067HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0067Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportSearchPayableVO reportSearchPayableVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ReportSearchPayableVO[] reportSearchPayableVOs = null;

	public EesLse0067Event(){}
	
	public void setReportSearchPayableVO(ReportSearchPayableVO reportSearchPayableVO){
		this. reportSearchPayableVO = reportSearchPayableVO;
	}

	public void setReportSearchPayableVOS(ReportSearchPayableVO[] reportSearchPayableVOs){
		if (reportSearchPayableVOs != null) {
			ReportSearchPayableVO[] tmpVOs = new ReportSearchPayableVO[reportSearchPayableVOs.length];
			System.arraycopy(reportSearchPayableVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.reportSearchPayableVOs = tmpVOs;
		}
	}

	public ReportSearchPayableVO getReportSearchPayableVO(){
		return reportSearchPayableVO;
	}

	public ReportSearchPayableVO[] getReportSearchPayableVOS(){
		ReportSearchPayableVO[] tmpVOs = null;
		if (this.reportSearchPayableVOs != null) {
			tmpVOs = new ReportSearchPayableVO[reportSearchPayableVOs.length];
			System.arraycopy(reportSearchPayableVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}