/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0052Event.java
*@FileTitle : On-Hire Result by Lease Term/Lessor-Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.03 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event;

import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.ReportSearchVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0052HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportSearchVO reportSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ReportSearchVO[] reportSearchVOs = null;

	public EesLse0052Event(){}
	
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