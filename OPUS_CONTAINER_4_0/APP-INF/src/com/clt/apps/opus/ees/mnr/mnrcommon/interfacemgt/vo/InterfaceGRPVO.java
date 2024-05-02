/**
 * 
 */
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;

/**
 * @author zero
 *
 */
public class InterfaceGRPVO {	
	//TPB 인터페이스 호출을 위한 
	private String tpbRqstEqNo = "";
	 
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
	
	//MQ Workorder,invoice 처리를 위한	         
	private CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO = null;

	private List<CustomMnrOrdTmpHdrVO> customMnrOrdTmpHdrVOs = null;

	//MQ Workorder,invoice 처리를 위한	         
	private CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO = null;

	private List<CustomMnrOrdTmpDtlVO> customMnrOrdTmpDtlVOs = null;
	
	private CustomMnrOrdTmpHdrVO[] arrayCustomMnrOrdTmpHdrVOs = null;
	private CustomMnrOrdTmpDtlVO[][] arrayCustomMnrOrdTmpDtlVOs = null;

	public CustomMnrOrdTmpHdrVO getCustomMnrOrdTmpHdrVO() {
		return customMnrOrdTmpHdrVO;
	}

	public void setCustomMnrOrdTmpHdrVO(CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO) {
		this.customMnrOrdTmpHdrVO = customMnrOrdTmpHdrVO;
	}

	public List<CustomMnrOrdTmpHdrVO> getCustomMnrOrdTmpHdrVOs() {
		return customMnrOrdTmpHdrVOs;
	}

	public void setCustomMnrOrdTmpHdrVOs(
			List<CustomMnrOrdTmpHdrVO> customMnrOrdTmpHdrVOs) {
		this.customMnrOrdTmpHdrVOs = customMnrOrdTmpHdrVOs;
	}

	public CustomMnrOrdTmpDtlVO getCustomMnrOrdTmpDtlVO() {
		return customMnrOrdTmpDtlVO;
	}

	public void setCustomMnrOrdTmpDtlVO(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) {
		this.customMnrOrdTmpDtlVO = customMnrOrdTmpDtlVO;
	}

	public List<CustomMnrOrdTmpDtlVO> getCustomMnrOrdTmpDtlVOs() {
		return customMnrOrdTmpDtlVOs;
	}

	public void setCustomMnrOrdTmpDtlVOs(
			List<CustomMnrOrdTmpDtlVO> customMnrOrdTmpDtlVOs) {
		this.customMnrOrdTmpDtlVOs = customMnrOrdTmpDtlVOs;
	}

	public CustomMnrOrdTmpHdrVO[] getArrayCustomMnrOrdTmpHdrVOs() {
		return arrayCustomMnrOrdTmpHdrVOs;
	}

	public void setArrayCustomMnrOrdTmpHdrVOs(
			CustomMnrOrdTmpHdrVO[] arrayCustomMnrOrdTmpHdrVOs) {
		this.arrayCustomMnrOrdTmpHdrVOs = arrayCustomMnrOrdTmpHdrVOs;
	}

	public CustomMnrOrdTmpDtlVO[][] getArrayCustomMnrOrdTmpDtlVOs() {
		return arrayCustomMnrOrdTmpDtlVOs;
	}

	public void setArrayCustomMnrOrdTmpDtlVOs(
			CustomMnrOrdTmpDtlVO[][] arrayCustomMnrOrdTmpDtlVOs) {
		this.arrayCustomMnrOrdTmpDtlVOs = arrayCustomMnrOrdTmpDtlVOs;
	}

	private List<CustomMnrOrdTmpDtlVO> listMnrOrdTmpDtlVOs = new ArrayList<CustomMnrOrdTmpDtlVO>();
	private List<CustomMnrOrdHdrVO> listMnrOrdHdrVOs = new ArrayList<CustomMnrOrdHdrVO>();
	private List<CustomMnrOrdDtlVO> listMnrOrdDtlVOs = new ArrayList<CustomMnrOrdDtlVO>();

	public List<CustomMnrOrdTmpDtlVO> getListMnrOrdTmpDtlVOs() {
		return listMnrOrdTmpDtlVOs;
	}

	public void setListMnrOrdTmpDtlVOs(
			List<CustomMnrOrdTmpDtlVO> listMnrOrdTmpDtlVOs) {
		this.listMnrOrdTmpDtlVOs = listMnrOrdTmpDtlVOs;
	}

	public List<CustomMnrOrdHdrVO> getListMnrOrdHdrVOs() {
		return listMnrOrdHdrVOs;
	}

	public void setListMnrOrdHdrVOs(List<CustomMnrOrdHdrVO> listMnrOrdHdrVOs) {
		this.listMnrOrdHdrVOs = listMnrOrdHdrVOs;
	}

	public List<CustomMnrOrdDtlVO> getListMnrOrdDtlVOs() {
		return listMnrOrdDtlVOs;
	}

	public void setListMnrOrdDtlVOs(List<CustomMnrOrdDtlVO> listMnrOrdDtlVOs) {
		this.listMnrOrdDtlVOs = listMnrOrdDtlVOs;
	}
	
	String batParam = "";

	public String getBatParam() {
		return batParam;
	}

	public void setBatParam(String batParam) {
		this.batParam = batParam;
	}
}