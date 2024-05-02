/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0240Event.java
*@FileTitle : Repair Estimate EDI Auditing
*Open Issues :	
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 박명신  
*@LastVersion : 1.0
* 2010.04.19 박명신 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0240 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0240HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박명신
 * @see ees_mnr_0240HTMLAction 참조
 * @since J2EE 1.6
 */    
		
public class EesMnr0240Event extends EventSupport {

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0240Event(){}   

	/** Estimate 조회 조건 및 단건 처리  */
	private EstimateGRPVO estimateGRPVO = null;

	public EstimateGRPVO getEstimateGRPVO() {
		return estimateGRPVO; 
	}

	public void setEstimateGRPVO(EstimateGRPVO estimateGRPVO) {
		this.estimateGRPVO = estimateGRPVO;
	} 
	 
	
}