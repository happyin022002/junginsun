/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0218Event.java
*@FileTitle : M&R AGREEMENT DETAIL Pop_Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : HyungSeok Ham  
*@LastVersion : 1.0
* 2009.07.03 HyungSeok Ham 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.RepairPartnerGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0218 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0218HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 함형석
 * @see ees_mnr_0218HTMLAction 참조
 * @since J2EE 1.6
 */    
     
public class EesMnr0218Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	public EesMnr0218Event(){}   

	/** Agreement 조회 조건 및 단건 처리  */
	private AgreementGRPVO agreementGRPVO = null; 
	
	/** RepairPartner 조회 조건 및 단건 처리  */ 
	private RepairPartnerGRPVO repairPartnerGRPVO = null; 
     
	public RepairPartnerGRPVO getRepairPartnerGRPVO() {
		return repairPartnerGRPVO;
	} 
	   
	public void setRepairPartnerGRPVO(RepairPartnerGRPVO repairPartnerGRPVO) {
		this.repairPartnerGRPVO = repairPartnerGRPVO;
	}

	public AgreementGRPVO getAgreementGRPVO() {
		return agreementGRPVO;
	} 

	public void setAgreementGRPVO(AgreementGRPVO agreementGRPVO) {
		this.agreementGRPVO = agreementGRPVO;
	}  
}