/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0160Event.java
*@FileTitle : Disposal Sold Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 김완규  
*@LastVersion : 1.0
* 2009.09.28 김완규 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0160 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0160HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김완규
 * @see ees_mnr_0160HTMLAction 참조
 * @since J2EE 1.6
 */    
      
public class EesMnr0160Event extends EventSupport {

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0160Event(){}   

	/** Total Loss 조회 조건 및 단건 처리  */
	private DisposalSoldGRPVO disposalSoldGRPVO = null;

	public DisposalSoldGRPVO getDisposalSoldGRPVO() {
		return disposalSoldGRPVO;
	}

	public void setDisposalSoldGRPVO(DisposalSoldGRPVO disposalSoldGRPVO) {
		this.disposalSoldGRPVO = disposalSoldGRPVO;
	}
}