/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0192Event.java
*@FileTitle : M&R Agreement POP UP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 박명신  
*@LastVersion : 1.0
* 2009.06.09 박명신 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
	
/**
 * - 견적서 팝업버젼 
 *
 * @author 박명신
 * @see ees_mnr_0192HTMLAction 참조
 * @since J2EE 1.6
 */    
	
public class EesMnr0192Event extends EventSupport {

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0192Event(){}   

	/** Estimate 조회 조건 및 단건 처리  */
	private EstimateGRPVO estimateGRPVO = null;
	
	public EstimateGRPVO getEstimateGRPVO() {
		return estimateGRPVO; 
	}
	
	public void setEstimateGRPVO(EstimateGRPVO estimateGRPVO) {
		this.estimateGRPVO = estimateGRPVO;
	}  
}