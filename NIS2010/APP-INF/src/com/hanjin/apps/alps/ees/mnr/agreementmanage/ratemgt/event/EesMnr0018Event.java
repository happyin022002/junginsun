/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0018Event.java
*@FileTitle : M&R Agreement Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : HyungSeok Ham  
*@LastVersion : 1.0
* 2009.07.01 HyungSeok Ham 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementInfoListGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 함형석
 * @see ees_mnr_0018HTMLAction 참조
 * @since J2EE 1.6
 */    
     
public class EesMnr0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	public EesMnr0018Event(){}   

	/** Agreement 조회 조건 및 단건 처리  */
	private AgreementInfoListGRPVO agreementInfoListGRPVO = null; 
	
	public AgreementInfoListGRPVO getAgreementInfoListGRPVO() {
		return agreementInfoListGRPVO;
	} 

	public void setAgreementInfoListGRPVO(AgreementInfoListGRPVO agreementInfoListGRPVO) {
		this.agreementInfoListGRPVO = agreementInfoListGRPVO;
	}  
}