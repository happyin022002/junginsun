/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : DisposalGRPVO
 *@FileTitle : 
 *Open Issues :	 
 *Change history :
 *@LastModifyDate : 2009. 9. 10
 *@LastModifier : 
 *@LastVersion : 1.0 
 *2009. 9. 10. 박명신 
 * 1.0 Creation
=========================================================*/
 
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo;

import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.EmailSendInfoVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.GeneralMailFormVO;
    
/** 
 * DisposalGRPVO GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신 
 * @since J2EE 1.5 
 * @see	  ..   
 */
public class DisposalGRPVO { 
	//IN 
	private DisposalNVO disposalNVO = null;
	//SEARCH Result
	private List<CustomMnrDispBuyerPartVO> customMnrDispBuyerPartVOS = null; 
	//Buyer MULTI   
	private CustomMnrDispBuyerPartVO[] arrCustomMnrDispBuyerPartVOS = null;
	//SEARCH Result
	private List<CustomMnrDispHdrVO> customMnrDispHdrVOS = null;
	
	//DSP SAVE 
	private CustomMnrDispDtlVO[] arrCustomMnrDispDtlVOS = null; 

	private CustomMnrDispDtlVO customMnrDispDtlVO = null; 
	
	//Buyer DTL Search
	private List<CustomMnrDispBuyrDtlPartVO> customMnrDispBuyrDtlPartVOS = null;
	
	//Buyer DTL MULTI
	private CustomMnrDispBuyrDtlPartVO[] arrCustomMnrDispBuyrDtlPartVOS = null;
	
	private List<CustomMnrDispDtlVO> eqCustomMnrDispDtlVOS = null;
	
	private List<CustomMnrDispDtlVO> qtyCustomMnrDispDtlVOS = null;
	
	//SAVE HDR
	private CustomMnrDispHdrVO customMnrDispHdrVO = null;    
	
	//Mail 전송용 구분 플레그  
	private String noticeMailType = null;
	public String getNoticeMailType() {
		return noticeMailType;
	}

	public void setNoticeMailType(String noticeMailType) {
		this.noticeMailType = noticeMailType;
	}
	
	public CustomMnrDispBuyrDtlPartVO[] getArrCustomMnrDispBuyrDtlPartVOS() {
		return arrCustomMnrDispBuyrDtlPartVOS;
	}
	
	public void setArrCustomMnrDispBuyrDtlPartVOS(
			CustomMnrDispBuyrDtlPartVO[] arrCustomMnrDispBuyrDtlPartVOS) {
		this.arrCustomMnrDispBuyrDtlPartVOS = arrCustomMnrDispBuyrDtlPartVOS;
	}

	public List<CustomMnrDispBuyrDtlPartVO> getCustomMnrDispBuyrDtlPartVOS() {
		return customMnrDispBuyrDtlPartVOS;
	}
	
	public void setCustomMnrDispBuyrDtlPartVOS(
			List<CustomMnrDispBuyrDtlPartVO> customMnrDispBuyrDtlPartVOS) {
		this.customMnrDispBuyrDtlPartVOS = customMnrDispBuyrDtlPartVOS;
	}

	//General Mail
	List<GeneralMailFormVO> generalMailFormVOS = null;
	
	public List<GeneralMailFormVO> getGeneralMailFormVOS() {
		return generalMailFormVOS;
	}
	
	public void setGeneralMailFormVOS(List<GeneralMailFormVO> generalMailFormVOS) {
		this.generalMailFormVOS = generalMailFormVOS;
	}
	
	//Html Template Mail
	List<EmailSendInfoVO> emailSendInfoVOS = null;
	
	public List<EmailSendInfoVO> getEmailSendInfoVOS() {
		return emailSendInfoVOS;	
	}	

	public void setEmailSendInfoVOS(List<EmailSendInfoVO> emailSendInfoVOS) {
		this.emailSendInfoVOS = emailSendInfoVOS;
	}	

	//SEARCH DTL Result 
	private List<CustomMnrDispDtlVO> customMnrDispDtlVOS = null;
	
	public List<CustomMnrDispDtlVO> getEqCustomMnrDispDtlVOS() {
		return eqCustomMnrDispDtlVOS;
	}
	
	public void setEqCustomMnrDispDtlVOS(
			List<CustomMnrDispDtlVO> eqCustomMnrDispDtlVOS) {
		this.eqCustomMnrDispDtlVOS = eqCustomMnrDispDtlVOS;
	}
		
	public List<CustomMnrDispDtlVO> getQtyCustomMnrDispDtlVOS() {
		return qtyCustomMnrDispDtlVOS;
	}
		
	public void setQtyCustomMnrDispDtlVOS(
			List<CustomMnrDispDtlVO> qtyCustomMnrDispDtlVOS) {
		this.qtyCustomMnrDispDtlVOS = qtyCustomMnrDispDtlVOS;
	}
	
	public CustomMnrDispDtlVO[] getArrCustomMnrDispDtlVOS() {
		return arrCustomMnrDispDtlVOS;
	}
	public void setArrCustomMnrDispDtlVOS(
			CustomMnrDispDtlVO[] arrCustomMnrDispDtlVOS) {
		this.arrCustomMnrDispDtlVOS = arrCustomMnrDispDtlVOS;
	}
	public List<CustomMnrDispDtlVO> getCustomMnrDispDtlVOS() {
		return customMnrDispDtlVOS;
	}
	public void setCustomMnrDispDtlVOS(List<CustomMnrDispDtlVO> customMnrDispDtlVOS) {
		this.customMnrDispDtlVOS = customMnrDispDtlVOS;
	}
	public CustomMnrDispHdrVO getCustomMnrDispHdrVO() {
		return customMnrDispHdrVO;
	}
	public void setCustomMnrDispHdrVO(CustomMnrDispHdrVO customMnrDispHdrVO) {
		this.customMnrDispHdrVO = customMnrDispHdrVO;
	}
	public List<CustomMnrDispHdrVO> getCustomMnrDispHdrVOS() {
		return customMnrDispHdrVOS;
	}
	public void setCustomMnrDispHdrVOS(List<CustomMnrDispHdrVO> customMnrDispHdrVOS) {
		this.customMnrDispHdrVOS = customMnrDispHdrVOS;
	}
	public DisposalNVO getDisposalNVO() {
		return disposalNVO;
	}
	public void setDisposalNVO(DisposalNVO disposalNVO) {
		this.disposalNVO = disposalNVO;
	} 
	public List<CustomMnrDispBuyerPartVO> getCustomMnrDispBuyerPartVOS() {
		return customMnrDispBuyerPartVOS;
	}
	public void setCustomMnrDispBuyerPartVOS(
			List<CustomMnrDispBuyerPartVO> customMnrDispBuyerPartVOS) {
		this.customMnrDispBuyerPartVOS = customMnrDispBuyerPartVOS;
	}
	public CustomMnrDispBuyerPartVO[] getArrCustomMnrDispBuyerPartVOS() {
		return arrCustomMnrDispBuyerPartVOS;
	}
	public void setArrCustomMnrDispBuyerPartVOS(
			CustomMnrDispBuyerPartVO[] arrCustomMnrDispBuyerPartVOS) {
		this.arrCustomMnrDispBuyerPartVOS = arrCustomMnrDispBuyerPartVOS;
	}    
	public CustomMnrDispDtlVO getCustomMnrDispDtlVO() {
		return customMnrDispDtlVO;
	}
	public void setCustomMnrDispDtlVO(CustomMnrDispDtlVO customMnrDispDtlVO) {
		this.customMnrDispDtlVO = customMnrDispDtlVO;
	} 	
}
