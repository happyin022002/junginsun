/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 5. 12.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 5. 12. 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Agreement GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신 
 * @since J2EE 1.5 
 * @see	  ..   
 */
    
public class AgreementGRPVO {
	//조회용 searchAgreementBasic 사용 
	private GeneralEventResponse generalEventResponse = null;
	  
	public GeneralEventResponse getGeneralEventResponse() {
		return generalEventResponse;
	}

	public void setGeneralEventResponse(GeneralEventResponse generalEventResponse) {
		this.generalEventResponse = generalEventResponse;
	}

	//조회 INVO
	private AgreementINVO agreementINVO = null;
	//헤더 조회용
	private CustomMnrAgmtHdrVO customMnrAgmtHdrVO = null;
	//Menu 조회용 
	private List<CustomAgreementMenuDataVO> customAgreementMenuDataVOS = null;
	//로그인정보 
	private SignOnUserAccount account = null;
	
	//AplyOfc CUD 
	private CustomMnrAgmtAplyOfcVO[] customMnrAgmtAplyOfcVOS = null;
	
	public CustomMnrAgmtAplyOfcVO[] getCustomMnrAgmtAplyOfcVOS() {
		return customMnrAgmtAplyOfcVOS;
	}

	public void setCustomMnrAgmtAplyOfcVOS(
			CustomMnrAgmtAplyOfcVO[] customMnrAgmtAplyOfcVOS) {
		this.customMnrAgmtAplyOfcVOS = customMnrAgmtAplyOfcVOS;
	}
	
	//AgmtRt CUD  
	private List<CustomMnrAgmtRtVO> customMnrAgmtRtVOS = null;   
		
	//단순 변환용 CustomMnrAgmtRtVO[]	
	private CustomMnrAgmtRtVO[] arrCustomMnrAgmtRtVOS = null;
		
	public CustomMnrAgmtRtVO[] getArrCustomMnrAgmtRtVOS() {
		return arrCustomMnrAgmtRtVOS;
	}

	public void setArrCustomMnrAgmtRtVOS(CustomMnrAgmtRtVO[] arrCustomMnrAgmtRtVOS) {
		this.arrCustomMnrAgmtRtVOS = arrCustomMnrAgmtRtVOS;
	}

	//어그리먼트 콤보 조회용 
	private AgreementComboListINVO agreementComboListINVO = null;
		
	public AgreementComboListINVO getAgreementComboListINVO() {
		return agreementComboListINVO;
	}

	public void setAgreementComboListINVO(
			AgreementComboListINVO agreementComboListINVO) {
		this.agreementComboListINVO = agreementComboListINVO;
	}
	
	
	//어그리먼트 사용 견적서 리스트 조회결과용
	private List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;
	
	public List<CustomMnrRprRqstHdrVO> getCustomMnrRprRqstHdrVOS() {
		return customMnrRprRqstHdrVOS;
	}

	public void setCustomMnrRprRqstHdrVOS(
			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS) {
		this.customMnrRprRqstHdrVOS = customMnrRprRqstHdrVOS;
	}

	//어그리먼트 콤보 조회 결과용 
	private List<CustomMnrAgmtHdrVO> customMnrAgmtHdrVOS = null;
		
	public List<CustomMnrAgmtHdrVO> getCustomMnrAgmtHdrVOS() {
		return customMnrAgmtHdrVOS;
	}
	
	public void setCustomMnrAgmtHdrVOS(List<CustomMnrAgmtHdrVO> customMnrAgmtHdrVOS) {
		this.customMnrAgmtHdrVOS = customMnrAgmtHdrVOS;
	}

	public List<CustomMnrAgmtRtVO> getCustomMnrAgmtRtVOS() {
		return customMnrAgmtRtVOS;
	}  

	public void setCustomMnrAgmtRtVOS(List<CustomMnrAgmtRtVO> customMnrAgmtRtVOS) {
		this.customMnrAgmtRtVOS = customMnrAgmtRtVOS;
	}
	
	public SignOnUserAccount getAccount() { 
		return account;  
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account; 
	}

	public List<CustomAgreementMenuDataVO> getCustomAgreementMenuDataVOS() {
		return customAgreementMenuDataVOS;
	}

	public void setCustomAgreementMenuDataVOS(
			List<CustomAgreementMenuDataVO> customAgreementMenuDataVOS) {
		this.customAgreementMenuDataVOS = customAgreementMenuDataVOS;
	}
    	 
	public AgreementINVO getAgreementINVO() {
		return agreementINVO;
	}
	 
	public void setAgreementINVO(AgreementINVO agreementINVO) {
		this.agreementINVO = agreementINVO;
	}
	 	
	public CustomMnrAgmtHdrVO getCustomMnrAgmtHdrVO() {
		return customMnrAgmtHdrVO;
	}
	
	public void setCustomMnrAgmtHdrVO(CustomMnrAgmtHdrVO customMnrAgmtHdrVO) {
		this.customMnrAgmtHdrVO = customMnrAgmtHdrVO;
	}
}
