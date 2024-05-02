/**
 * 
 */
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;

/**
 * @author zero
 *
 */
public class InterfaceGRPVO {	
	//TPB 인터페이스 호출을 위한 
	private String tpbRqstEqNo = "";
	//MNR Total Loss Stauts Code 
	private String mnrTotalLossStatusCode = "";
	
	public String getMnrTotalLossStatusCode() {
		return mnrTotalLossStatusCode;
	}

	public void setMnrTotalLossStatusCode(String mnrTotalLossStatusCode) {
		this.mnrTotalLossStatusCode = mnrTotalLossStatusCode;
	}

	//TPB 인터페이스 호출 위해 Repair Seq 와 Version No 추가
	private String tpbRprRqstSeq = "";
	private String tpbRprRqstVerNo = "";

	public String getTpbRprRqstSeq() {
		return tpbRprRqstSeq;
	}

	public void setTpbRprRqstSeq(String tpbRprRqstSeq) {
		this.tpbRprRqstSeq = tpbRprRqstSeq;
	}

	public String getTpbRprRqstVerNo() {
		return tpbRprRqstVerNo;
	}

	public void setTpbRprRqstVerNo(String tpbRprRqstVerNo) {
		this.tpbRprRqstVerNo = tpbRprRqstVerNo;
	}

	public String getTpbRqstEqNo() {
		return tpbRqstEqNo;
	} 

	public void setTpbRqstEqNo(String tpbRqstEqNo) {
		this.tpbRqstEqNo = tpbRqstEqNo;
	}

	//MST 인터페이스 호출을 위한 	
	private List<IFMnrFlagVO> iFMnrFlagVOS = null;

	public List<IFMnrFlagVO> getIFMnrFlagVOS() {
		return iFMnrFlagVOS; 
	}

	public void setIFMnrFlagVOS(List<IFMnrFlagVO> mnrFlagVOS) {
		iFMnrFlagVOS = mnrFlagVOS;	
	}

	//HTML TEMPLATE 메일 전송을 위한 	
	private List<EmailSendInfoVO> emailSendInfoVOS = null;
		
	public List<EmailSendInfoVO> getEmailSendInfoVOS() {
		return emailSendInfoVOS;	
	}		
	
	public void setEmailSendInfoVOS(List<EmailSendInfoVO> emailSendInfoVOS) {
		this.emailSendInfoVOS = emailSendInfoVOS;
	}	
	
	//GENERAL 메일 전송을 위한  	
	private List<GeneralMailFormVO> generalMailFormVOS = null;
	
	public List<GeneralMailFormVO> getGeneralMailFormVOS() {
		return generalMailFormVOS;
	}
	
	public void setGeneralMailFormVOS(List<GeneralMailFormVO> generalMailFormVOS) {
		this.generalMailFormVOS = generalMailFormVOS;
	}

	//ERROR EDI 재전송을 위한 	
	private List<CustomMnrRprRqstTmpHdrVO> customMnrRprRqstTmpHdrVOS = null;
	
	public List<CustomMnrRprRqstTmpHdrVO> getCustomMnrRprRqstTmpHdrVOS() {
		return customMnrRprRqstTmpHdrVOS;
	}

	public void setCustomMnrRprRqstTmpHdrVOS(List<CustomMnrRprRqstTmpHdrVO> customMnrRprRqstTmpHdrVOS) {
		this.customMnrRprRqstTmpHdrVOS = customMnrRprRqstTmpHdrVOS;
	}
	
	//EDI_ERR_CD 재설정
	private String ediErrCd = null;

	public String getEdiErrCd() {
		return ediErrCd;
	}

	public void setEdiErrCd(String ediErrCd) {
		this.ediErrCd = ediErrCd;
	}

	//MQ estimate 처리를 위한	         
	private CustomMnrRprRqstHdrVO checkCustomMnrRprRqstHdrVO = null;
	
	public CustomMnrRprRqstHdrVO getCheckCustomMnrRprRqstHdrVO() {
		return checkCustomMnrRprRqstHdrVO;
	}
		
	public void setCheckCustomMnrRprRqstHdrVO(
			CustomMnrRprRqstHdrVO checkCustomMnrRprRqstHdrVO) {
		this.checkCustomMnrRprRqstHdrVO = checkCustomMnrRprRqstHdrVO;
	}

	private CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = null;
	
	public CustomMnrRprRqstTmpHdrVO getCustomMnrRprRqstTmpHdrVO() {
		return customMnrRprRqstTmpHdrVO;
	}

	public void setCustomMnrRprRqstTmpHdrVO(
			CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) {
		this.customMnrRprRqstTmpHdrVO = customMnrRprRqstTmpHdrVO;
	}
	//Validation Result Total	
	private boolean validOk = true; 
	
	public boolean getValidOk() {
		return validOk;
	}	
		
	public void setValidOk(boolean validOk) {
		this.validOk = validOk; 
	}

	//Validation Date Format 
	private String dateFormChk = null;
	
	public String getDateFormChk() { 
		return dateFormChk;
	}

	public void setDateFormChk(String dateFormChk) {
		this.dateFormChk = dateFormChk;
	}
		
	//Validation Rqst Ref No
	private String rqstRefNoChk = null;	 
										
	public String getRqstRefNoChk() { 
		return rqstRefNoChk;
	}

	public void setRqstRefNoChk(String rqstRefNoChk) {
		this.rqstRefNoChk = rqstRefNoChk; 
	}

	//Validation Vender Seq
	private String venderChk = null;
	
	public String getVenderChk() {
		return venderChk;
	}

	public void setVenderChk(String venderChk) {
		this.venderChk = venderChk;
	}

	//Validation Eq No
	private String eqChk = null;	
		
	public String getEqChk() {
		return eqChk;
	}
	
	public void setEqChk(String eqChk) {
		this.eqChk = eqChk;
	}

	private String eaiRecMsg = null;
	
	public String getEaiRecMsg() {
		return eaiRecMsg;
	}

	public void setEaiRecMsg(String eaiRecMsg) {
		this.eaiRecMsg = eaiRecMsg;
	}
	
	private String fileSeq = null;
	
	public String getFileSeq() {
		return fileSeq;
	}
    
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	private  CustomMnrFileAtchVO[] customMnrFileAtchVOs = null;

	private List<CustomMnrFileAtchVO> listCustomMnrFileAtchVOs = null;
	
	/**
	 * @return the customMnrFileAtchVOs
	 */
	public CustomMnrFileAtchVO[] getCustomMnrFileAtchVOs() {
		return customMnrFileAtchVOs;
	}

	/**
	 * @param customMnrFileAtchVOs the customMnrFileAtchVOs to set
	 */
	public void setCustomMnrFileAtchVOs(CustomMnrFileAtchVO[] customMnrFileAtchVOs) {
		this.customMnrFileAtchVOs = customMnrFileAtchVOs;
	}

	
	public List<CustomMnrFileAtchVO> getListCustomMnrFileAtchVOs() {
		return listCustomMnrFileAtchVOs;
	}
	public void setListCustomMnrFileAtchVOs(
			List<CustomMnrFileAtchVO> listCustomMnrFileAtchVOs) {
		this.listCustomMnrFileAtchVOs = listCustomMnrFileAtchVOs;
	} 
	
}