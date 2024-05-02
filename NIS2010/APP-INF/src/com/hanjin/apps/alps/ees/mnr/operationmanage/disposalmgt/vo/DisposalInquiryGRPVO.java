/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : DisposalInquiryGRPVO
 *@FileTitle : 
 *Open Issues :	 
 *Change history :
 *@LastModifyDate : 2009. 9. 30
 *@LastModifier : 
 *@LastVersion : 1.0 
 *2009. 9. 30. 함형석 
 * 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo;

import java.util.List; 

 
/** 
 * DisposalInquiryGRPVO GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 함형석 
 * @since J2EE 1.5 
 * @see	  ..   
 */
public class DisposalInquiryGRPVO { 
	//IN 
	private DisposalInquiryINVO disposalInquiryINVO = null;
	//SEARCH Result
	private List<CustomMnrRcvInvWrkVO> customMnrRcvInvWrkVOs = null;
	
	private List<CustomBkgOtsDtlVO> customBkgOtsDtlVOs = null;

	private List<CustomDispInvDtIVO> customDispInvDtIVOs = null;
	
	public List<CustomMnrRcvInvWrkVO> getCustomMnrRcvInvWrkVOs() {
		return customMnrRcvInvWrkVOs;
	}
	public void setCustomMnrRcvInvWrkVOs(List<CustomMnrRcvInvWrkVO> customMnrRcvInvWrkVOs) {
		this.customMnrRcvInvWrkVOs = customMnrRcvInvWrkVOs;
	}
	
	public DisposalInquiryINVO getDisposalInquiryINVO() {
		return disposalInquiryINVO;
	}
	public void setDisposalInquiryINVO(DisposalInquiryINVO disposalInquiryINVO) {
		this.disposalInquiryINVO = disposalInquiryINVO;
	} 

	public List<CustomBkgOtsDtlVO> getCustomBkgOtsDtlVOs() {
		return customBkgOtsDtlVOs;
	}
	public void setCustomBkgOtsDtlVOs(List<CustomBkgOtsDtlVO> customBkgOtsDtlVOs) {
		this.customBkgOtsDtlVOs = customBkgOtsDtlVOs;
	}
	
	public List<CustomDispInvDtIVO> getCustomDispInvDtIVOs() {
		return customDispInvDtIVOs;
	}
	public void setCustomDispInvDtIVOs(List<CustomDispInvDtIVO> customDispInvDtIVOs) {
		this.customDispInvDtIVOs = customDispInvDtIVOs;
	}	
}
