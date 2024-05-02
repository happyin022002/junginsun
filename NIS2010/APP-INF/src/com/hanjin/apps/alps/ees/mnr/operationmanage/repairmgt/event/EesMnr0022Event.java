/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0022Event.java
*@FileTitle : Repair Group Auditing
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 박명신  
*@LastVersion : 1.0
* 2009.06.09 박명신 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박명신
 * @see ees_mnr_0022HTMLAction 참조
 * @since J2EE 1.6	
 */    
		
public class EesMnr0022Event extends EventSupport {
	
	private static final long serialVersionUID = 1L; 
	
	public EesMnr0022Event(){}   
	
	/** Estimate 조회 조건 및 단건 처리  */
	private EstimateGRPVO estimateGRPVO = null; 
	
	public EstimateGRPVO getEstimateGRPVO() {	
		return estimateGRPVO;	 
	}
	
	public void setEstimateGRPVO(EstimateGRPVO estimateGRPVO) {
		this.estimateGRPVO = estimateGRPVO;
	} 
}