/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0016Event.java
*@FileTitle : M&R Agreement Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : HyungSeok Ham  
*@LastVersion : 1.0
* 2009.06.29 HyungSeok Ham 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.event;

import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementInfoListGRPVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 함형석
 * @see ees_mnr_0016HTMLAction 참조
 * @since J2EE 1.6
 */    
     
public class EesMnr0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	public EesMnr0016Event(){}   

	/** Agreement 조회 조건 및 단건 처리  */
	private AgreementInfoListGRPVO agreementInfoListGRPVO = null; 
	
	public AgreementInfoListGRPVO getAgreementInfoListGRPVO() {
		return agreementInfoListGRPVO;
	} 

	public void setAgreementInfoListGRPVO(AgreementInfoListGRPVO agreementInfoListGRPVO) {
		this.agreementInfoListGRPVO = agreementInfoListGRPVO;
	}  
}