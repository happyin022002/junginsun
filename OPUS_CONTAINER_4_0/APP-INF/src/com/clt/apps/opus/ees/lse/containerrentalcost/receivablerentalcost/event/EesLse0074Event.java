/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0074Event.java
*@FileTitle : EQ Receivable Charge Summary By Charge Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.17 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.event;

import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReportSearchReceivableVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_LSE_0074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0074HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0074HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0074Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportSearchReceivableVO reportSearchReceivableVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ReportSearchReceivableVO[] reportSearchReceivableVOs = null;

	public EesLse0074Event(){}
	
	public void setReportSearchReceivableVO(ReportSearchReceivableVO reportSearchReceivableVO){
		this. reportSearchReceivableVO = reportSearchReceivableVO;
	}

	public void setReportSearchReceivableVOS(ReportSearchReceivableVO[] reportSearchReceivableVOs){
		if (reportSearchReceivableVOs != null) {
			ReportSearchReceivableVO[] tmpVOs = new ReportSearchReceivableVO[reportSearchReceivableVOs.length];
			System.arraycopy(reportSearchReceivableVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.reportSearchReceivableVOs = tmpVOs;
		}
	}

	public ReportSearchReceivableVO getReportSearchReceivableVO(){
		return reportSearchReceivableVO;
	}

	public ReportSearchReceivableVO[] getReportSearchReceivableVOS(){
		ReportSearchReceivableVO[] tmpVOs = null;
		if (this.reportSearchReceivableVOs != null) {
			tmpVOs = new ReportSearchReceivableVO[reportSearchReceivableVOs.length];
			System.arraycopy(reportSearchReceivableVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}