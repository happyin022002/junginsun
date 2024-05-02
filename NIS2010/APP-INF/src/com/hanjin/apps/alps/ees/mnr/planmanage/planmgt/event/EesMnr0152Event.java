/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0152Event.java
*@FileTitle : Disposal Planning
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 김완규  
*@LastVersion : 1.0
* 2009.08.19 김완규 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.event;

import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.DisposalPlanGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0152 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0152HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김완규
 * @see ees_mnr_0152HTMLAction 참조
 * @since J2EE 1.6
 */    
      
public class EesMnr0152Event extends EventSupport {

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0152Event(){}   

	/** Estimate 조회 조건 및 단건 처리  */
	private DisposalPlanGRPVO disposalPlanGRPVO = null;

	public DisposalPlanGRPVO getDisposalPlanGRPVO() {
		return disposalPlanGRPVO;
	}

	public void setDisposalPlanGRPVO(DisposalPlanGRPVO disposalPlanGRPVO) {
		this.disposalPlanGRPVO = disposalPlanGRPVO;
	}
	
}