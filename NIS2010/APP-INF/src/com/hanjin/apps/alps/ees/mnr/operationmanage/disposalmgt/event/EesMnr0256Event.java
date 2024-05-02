/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0256Event.java
*@FileTitle : Disposal Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.30 신혜정
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalInquiryGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0256 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_MNR_0256HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *	
 * @author 신혜정
 * @see EES_MNR_0256HTMLAction 참조
 * @since J2EE 1.6
 */    
 
public class EesMnr0256Event extends EventSupport {

	private static final long serialVersionUID = 1L;
		
	public EesMnr0256Event(){}     
		
	/** Disposal 조회 조건 및 단건 처리  */
	private DisposalInquiryGRPVO disposalInquiryGRPVO = null;
	
	public DisposalInquiryGRPVO getDisposalInquiryGRPVO() {
		return disposalInquiryGRPVO; 
	}  
 
	public void setDisposalInquiryGRPVO(DisposalInquiryGRPVO disposalInquiryGRPVO) {
		this.disposalInquiryGRPVO = disposalInquiryGRPVO;
	} 
	

}