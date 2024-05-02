/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0018Event.java
*@FileTitle : Estimate expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.10.06 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.event;

import com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.vo.EstimatedAuditVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0018HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EstimatedAuditVO estimatedAuditVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EstimatedAuditVO[] estimatedAuditVOs = null;

	private String yearMonth = null;
	
	public EesLse0018Event(){}
	
	public void setEstimatedAuditVO(EstimatedAuditVO estimatedAuditVO){
		this. estimatedAuditVO = estimatedAuditVO;
	}

	public void setEstimatedAuditVOS(EstimatedAuditVO[] estimatedAuditVOs){
		this. estimatedAuditVOs = estimatedAuditVOs;
	}
	
	public void setYearMonth(String yearMonth){
		this.yearMonth = yearMonth;
	}
	
	public EstimatedAuditVO getEstimatedAuditVO(){
		return estimatedAuditVO;
	}

	public EstimatedAuditVO[] getEstimatedAuditVOS(){
		return estimatedAuditVOs;
	}
	
	public String getYearMonth(){
		return yearMonth;
	}

}