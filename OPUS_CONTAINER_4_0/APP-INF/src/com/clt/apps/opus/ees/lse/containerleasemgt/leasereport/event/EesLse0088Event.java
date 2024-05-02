/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0088Event.java
*@FileTitle : On-Hire Report Summary By Month
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.09.04 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event;

import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.ReportSearchVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0088 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0088HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0088HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0088Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportSearchVO reportSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ReportSearchVO[] reportSearchVOs = null;

	public EesLse0088Event(){}
	
	public void setReportSearchVO(ReportSearchVO reportSearchVO){
		this. reportSearchVO = reportSearchVO;
	}

	public void setReportSearchVOS(ReportSearchVO[] reportSearchVOs){
		if (reportSearchVOs != null) {
			ReportSearchVO[] tmpVOs = new ReportSearchVO[reportSearchVOs.length];
			System.arraycopy(reportSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.reportSearchVOs = tmpVOs;
		}
	}

	public ReportSearchVO getReportSearchVO(){
		return reportSearchVO;
	}

	public ReportSearchVO[] getReportSearchVOS(){
		ReportSearchVO[] tmpVOs = null;
		if (this.reportSearchVOs != null) {
			tmpVOs = new ReportSearchVO[reportSearchVOs.length];
			System.arraycopy(reportSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}