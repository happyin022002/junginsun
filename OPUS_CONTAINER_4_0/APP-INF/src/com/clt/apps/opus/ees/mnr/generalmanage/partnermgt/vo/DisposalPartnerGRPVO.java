/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalPartnerGRPVO
*@FileTitle : Disposal Buyer Management
*Open Issues :	
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 
*@LastVersion : 1.0
*2009.10.05. 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo;
 
import java.util.List;

import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * RepairPartnerGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신 
 * @since J2EE 1.5 
 * @see	  ..   
 */
     
public class DisposalPartnerGRPVO {
	//조회 INVO
	private DisposalPartnerMgtINVO disposalPartnerMgtINVO = null;
	//조회용
	private List<CustomMnrPartnerVO> customMnrPartnerVOS = null;
	//CUD처리를 위한 
	private CustomMnrPartnerVO[] arrayCustomMnrPartnerVOs = null;
	//조회용 단건 
	private CustomMnrPartnerVO customMnrPartnerVO = null;
	//조회용 계약
	private List<CustomMnrPrnrCntcPntVO> customMnrPrnrCntcPntVOS= null;
	//CUD처리를 위한 
	private CustomMnrPrnrCntcPntVO[] arrayCustomMnrPrnrCntcPntVOs = null;
	//로그인정보      
	private SignOnUserAccount account = null;
	 
	public SignOnUserAccount getAccount() {
		return account;
	}
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
	public DisposalPartnerMgtINVO getDisposalPartnerMgtINVO() {
		return disposalPartnerMgtINVO;
	}
	public void setDisposalPartnerMgtINVO(DisposalPartnerMgtINVO disposalPartnerMgtINVO) {
		this.disposalPartnerMgtINVO = disposalPartnerMgtINVO;
	}
	public List<CustomMnrPartnerVO> getCustomMnrPartnerVOS() {
		return customMnrPartnerVOS;
	}
	public void setCustomMnrPartnerVOS(List<CustomMnrPartnerVO> customMnrPartnerVOS) {
		this.customMnrPartnerVOS = customMnrPartnerVOS;
	}
	public CustomMnrPartnerVO[] getArrayCustomMnrPartnerVOs() {
		return arrayCustomMnrPartnerVOs;
	}
	public void setArrayCustomMnrPartnerVOs(CustomMnrPartnerVO[] arrayCustomMnrPartnerVOs) {
		this.arrayCustomMnrPartnerVOs = arrayCustomMnrPartnerVOs;
	}	
	
	public List<CustomMnrPrnrCntcPntVO> getCustomMnrPrnrCntcPntVOS() {
		return customMnrPrnrCntcPntVOS;
	}
	public void setCustomMnrPrnrCntcPntVOS(List<CustomMnrPrnrCntcPntVO> customMnrPrnrCntcPntVOS) {
		this.customMnrPrnrCntcPntVOS = customMnrPrnrCntcPntVOS;
	}
	public CustomMnrPrnrCntcPntVO[] getArrayCustomMnrPrnrCntcPntVOs() {
		return arrayCustomMnrPrnrCntcPntVOs;
	}
	public void setArrayCustomMnrPrnrCntcPntVOs(CustomMnrPrnrCntcPntVO[] arrayCustomMnrPrnrCntcPntVOs) {
		this.arrayCustomMnrPrnrCntcPntVOs = arrayCustomMnrPrnrCntcPntVOs;
	}
	
	public CustomMnrPartnerVO getCustomMnrPartnerVO() {
		return customMnrPartnerVO;
	} 
	public void setCustomMnrPartnerVO(CustomMnrPartnerVO customMnrPartnerVO) {
		this.customMnrPartnerVO = customMnrPartnerVO;
	}  
}
