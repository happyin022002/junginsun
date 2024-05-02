/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementInfoListGRPVO
*@FileTitle : AgreementInfoListGRPVO
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 6. 30.
*@LastModifier : 함형석
*@LastVersion : 1.0
*2009. 6. 30. 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo;

import java.util.List;

import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * AgreementInfoList GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 함형석 
 * @since J2EE 1.5 
 * @see	  ..   
 */
 
public class AgreementInfoListGRPVO {
	//조회 INVO
	private AgreementInfoListINVO agreementInfoListINVO = null;
	//로그인정보 
	private SignOnUserAccount account = null;
	
	//M&R Agreement Inquiry_Pop Up 조회용 
	private List<CustomAgreementInfoListDataVO> customAgreementInfoListDataVOs = null;
	
	public SignOnUserAccount getAccount() { 
		return account;  
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account; 
	}

	public List<CustomAgreementInfoListDataVO> getCustomAgreementInfoListDataVOs() {
		return customAgreementInfoListDataVOs;
	}

	public void setCustomAgreementInfoListDataVOs(
			List<CustomAgreementInfoListDataVO> customAgreementInfoListDataVOs) {
		this.customAgreementInfoListDataVOs = customAgreementInfoListDataVOs;
	}
	
	public AgreementInfoListINVO getAgreementInfoListINVO() {
		return agreementInfoListINVO;
	}
	 
	public void setAgreementInfoListINVO(AgreementInfoListINVO agreementInfoListINVO) {
		this.agreementInfoListINVO = agreementInfoListINVO;
	}
	 
}
