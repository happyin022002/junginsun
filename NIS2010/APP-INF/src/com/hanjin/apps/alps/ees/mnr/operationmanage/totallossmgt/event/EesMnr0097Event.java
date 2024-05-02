/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0096Event.java
*@FileTitle : Total Loss Management
*Open Issues :
*Change history : 
*@LastModifyDate : 2009.10.08 	
*@LastModifier : 김완규 	
*@LastVersion : 1.0
* 2009.10.08 김완규  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0096 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0096HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 김완규
 * @see ees_mnr_0096HTMLAction 참조
 * @since J2EE 1.6   
 */    
      
public class EesMnr0097Event extends EventSupport { 

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0097Event(){}   

	/** Total Loss 조회 조건 및 단건 처리  */
	private TotalLossGRPVO totalLossGRPVO = null;

	public TotalLossGRPVO getTotalLossGRPVO() {
		return totalLossGRPVO;
	}

	public void setTotalLossGRPVO(TotalLossGRPVO totalLossGRPVO) {
		this.totalLossGRPVO = totalLossGRPVO;
	}
}