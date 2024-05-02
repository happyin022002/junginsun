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
package com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo;
 
import java.util.List;

import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * RepairPartnerGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신 
 * @since J2EE 1.5 
 * @see	  ..   
 */
     
public class RepairPartnerGRPVO {
	//조회 INVO
	private PartnerMgtINVO partnerMgtINVO = null;
	//조회용
	private List<CustomMnrPartnerVO> customMnrPartnerVOS = null;
	//조회용 단건 
	private CustomMnrPartnerVO customMnrPartnerVO = null;
	//로그인정보      
	private SignOnUserAccount account = null;
	//저장용  
	private CustomMnrPartnerVO[] arrCustomMnrPartnerVOS = null; 
	
	public CustomMnrPartnerVO[] getArrCustomMnrPartnerVOS() {
		return arrCustomMnrPartnerVOS;
	}
	public void setArrCustomMnrPartnerVOS(
			CustomMnrPartnerVO[] arrCustomMnrPartnerVOS) {
		this.arrCustomMnrPartnerVOS = arrCustomMnrPartnerVOS;
	}
	public SignOnUserAccount getAccount() {
		return account;
	}
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
	public PartnerMgtINVO getPartnerMgtINVO() {
		return partnerMgtINVO;
	}
	public void setPartnerMgtINVO(PartnerMgtINVO partnerMgtINVO) {
		this.partnerMgtINVO = partnerMgtINVO;
	}
	public List<CustomMnrPartnerVO> getCustomMnrPartnerVOS() {
		return customMnrPartnerVOS;
	}
	public void setCustomMnrPartnerVOS(List<CustomMnrPartnerVO> customMnrPartnerVOS) {
		this.customMnrPartnerVOS = customMnrPartnerVOS;
	}
	public CustomMnrPartnerVO getCustomMnrPartnerVO() {
		return customMnrPartnerVO;
	} 
	public void setCustomMnrPartnerVO(CustomMnrPartnerVO customMnrPartnerVO) {
		this.customMnrPartnerVO = customMnrPartnerVO;
	}  
}
