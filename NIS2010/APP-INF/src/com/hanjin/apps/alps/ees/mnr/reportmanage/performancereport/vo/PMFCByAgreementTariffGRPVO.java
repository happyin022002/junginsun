/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PMFCByAgreementTariffGRPVO
*@FileTitle : MNR PFMC by Agreement/Tariff
*Open Issues : 
*Change history :
*@LastModifyDate : 2010. 01. 28
*@LastModifier : 
*@LastVersion : 1.0
*2010. 01. 28. 김완규 
** 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

import java.util.List;

/**
 * PMFCByAgreementTariffGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 김완규
 * @since J2EE 1.5 
 * @see ..
 */
public class PMFCByAgreementTariffGRPVO {
	//조회조건을 받기 위한
	private PMFCByAgreementTariffINVO pMFCByAgreementTariffINVO = null;
	//조회결과을 받기 위한
	private  List <PMFCByAgreementTariffListVO> listPMFCByAgreementTariffListVOs = null;
	
	public PMFCByAgreementTariffINVO getPMFCByAgreementTariffINVO() {
		return pMFCByAgreementTariffINVO;
	}
	public void setPMFCByAgreementTariffINVO(PMFCByAgreementTariffINVO byAgreementTariffINVO) {
		pMFCByAgreementTariffINVO = byAgreementTariffINVO;
	}
	public List<PMFCByAgreementTariffListVO> getListPMFCByAgreementTariffListVOs() {
		return listPMFCByAgreementTariffListVOs;
	}
	public void setListPMFCByAgreementTariffListVOs(List<PMFCByAgreementTariffListVO> listPMFCByAgreementTariffListVOs) {
		this.listPMFCByAgreementTariffListVOs = listPMFCByAgreementTariffListVOs;
	}
}
