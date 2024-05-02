/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnrS308Event.java
*@FileTitle : Disposal Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 함형석   
*@LastVersion : 1.0
* 2009.09.30 함형석  
* 1.0 Creation 
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalInquiryGRPVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_S308 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_MNR_S308HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *	
 * @author 함형석
 * @see EES_MNR_S308HTMLAction 참조
 * @since J2EE 1.6
 */    
 
public class EesMnrS308Event extends EventSupport {

	private static final long serialVersionUID = 1L;
		
	public EesMnrS308Event(){}     
		
	/** Disposal 조회 조건 및 단건 처리  */
	private DisposalInquiryGRPVO disposalInquiryGRPVO = null;
	
	public DisposalInquiryGRPVO getDisposalInquiryGRPVO() {
		return disposalInquiryGRPVO; 
	}  
 
	public void setDisposalInquiryGRPVO(DisposalInquiryGRPVO disposalInquiryGRPVO) {
		this.disposalInquiryGRPVO = disposalInquiryGRPVO;
	} 
	

}