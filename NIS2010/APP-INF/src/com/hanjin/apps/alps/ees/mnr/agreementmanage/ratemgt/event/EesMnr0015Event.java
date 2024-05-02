/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0015Event.java
*@FileTitle : M&R Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 박명신  
*@LastVersion : 1.0
* 2009.06.09 박명신 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.TariffPopupGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.RepairPartnerGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박명신
 * @see ees_mnr_0015HTMLAction 참조
 * @since J2EE 1.6
 */    
     
public class EesMnr0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	public EesMnr0015Event(){}   

	/** Agreement 조회 조건 및 단건 처리  */
	private AgreementGRPVO agreementGRPVO = null; 
	
	/** RepairPartner 조회 조건 및 단건 처리  */ 
	private RepairPartnerGRPVO repairPartnerGRPVO = null; 
	
	/** 타리프 콤보 조회 */     
	private TariffPopupGRPVO tariffPopupGRPVO = null; 
      
	public TariffPopupGRPVO getTariffPopupGRPVO() {
		return tariffPopupGRPVO;
	}
 
	public void setTariffPopupGRPVO(TariffPopupGRPVO tariffPopupGRPVO) {
		this.tariffPopupGRPVO = tariffPopupGRPVO;
	}

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