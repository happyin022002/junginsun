/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0087Event.java
*@FileTitle : On-Hire Report Summary by RCC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.09.03 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.ReportSearchVO;


/**
 * EES_LSE_0087 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0087HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0087HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0087Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportSearchVO reportSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ReportSearchVO[] reportSearchVOs = null;

	public EesLse0087Event(){}
	
	public void setReportSearchVO(ReportSearchVO reportSearchVO){
		this. reportSearchVO = reportSearchVO;
	}

	public void setReportSearchVOS(ReportSearchVO[] reportSearchVOs){
		this. reportSearchVOs = reportSearchVOs;
	}

	public ReportSearchVO getReportSearchVO(){
		return reportSearchVO;
	}

	public ReportSearchVO[] getReportSearchVOS(){
		return reportSearchVOs;
	}

}