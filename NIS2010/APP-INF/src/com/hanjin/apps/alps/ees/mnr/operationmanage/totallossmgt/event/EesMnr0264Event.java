/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0264Event.java
*@FileTitle : Write Off Approval Inquiry
*Open Issues :
*Change history : 
*@LastModifyDate : 2013.09.05	
*@LastModifier : 조경완 	
*@LastVersion : 1.0
* 2013.09.05 조경완  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0264 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0264HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 조경완
 * @see ees_mnr_0264HTMLAction 참조
 * @since J2EE 1.6   
 */    
      
public class EesMnr0264Event extends EventSupport { 

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0264Event(){}   

	/** Total Loss 조회 조건 및 단건 처리  */
	private TotalLossGRPVO totalLossGRPVO = null;

	public TotalLossGRPVO getTotalLossGRPVO() {
		return totalLossGRPVO;
	}

	public void setTotalLossGRPVO(TotalLossGRPVO totalLossGRPVO) {
		this.totalLossGRPVO = totalLossGRPVO;
	}
}