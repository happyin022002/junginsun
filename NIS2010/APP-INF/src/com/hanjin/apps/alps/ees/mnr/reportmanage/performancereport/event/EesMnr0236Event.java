/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0236Event.java
*@FileTitle : MNR PFMC by Agreement/Tariff
*Open Issues :
*Change history : 
*@LastModifyDate : 2010.01.28 	
*@LastModifier : 김완규 	
*@LastVersion : 1.0
* 2010.01.28 김완규  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.PMFCByAgreementTariffGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0236 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0236HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 김완규
 * @see ees_mnr_0236HTMLAction 참조
 * @since J2EE 1.6   
 */    
      
public class EesMnr0236Event extends EventSupport { 

	private static final long serialVersionUID = 1L; 
	 
	public EesMnr0236Event(){}   

	private PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO = null;

	public PMFCByAgreementTariffGRPVO getPMFCByAgreementTariffGRPVO() {
		return pMFCByAgreementTariffGRPVO;
	}

	public void setPMFCByAgreementTariffGRPVO(PMFCByAgreementTariffGRPVO listAgreementTariffGRPVO) {
		pMFCByAgreementTariffGRPVO = listAgreementTariffGRPVO;
	}

}