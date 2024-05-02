/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0164Event.java
*@FileTitle : Disposal Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 함형석   
*@LastVersion : 1.0
* 2009.09.28 함형석  
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0164 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_MNR_0164HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *	
 * @author 함형석
 * @see EES_MNR_0164HTMLAction 참조
 * @since J2EE 1.6
 */    
 
public class EesMnr0164Event extends EventSupport {

	private static final long serialVersionUID = 1L;
		
	public EesMnr0164Event(){}     
		
	/** Disposal 조회 조건 및 단건 처리  */
	private DisposalGRPVO disposalGRPVO = null;
	
	public DisposalGRPVO getDisposalGRPVO() {
		return disposalGRPVO; 
	}  
 
	public void setDisposalGRPVO(DisposalGRPVO disposalGRPVO) {
		this.disposalGRPVO = disposalGRPVO;
	} 
	

}