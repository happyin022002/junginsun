/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableInvoiceGRPVO
*@FileTitle : PayableInvoiceGRPVO
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.08.17 함형석
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo;

import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;

/**
 * PayableInvoiceGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 함형석
 * @since J2EE 1.5 
 * @see ..
 */ 
public class PayableInvoiceGRPVO { 

	//조회 결과를 받기 위한   	
	private List<CustomPayableINVInquiryListVO> customPayableINVInquiryListVOs = null; 
	
	//조회 결과를 받기 위한   	
	private List<CustomPayableInvoiceDetailINVO> customPayableInvoiceDetailINVOs = null; 

    private EQFlagListINVO eQFlagListINVO = null;    
	
	//조회 조건을 받기 위한 
	private PayableINVInquiryINVO payableINVInquiryINVO = null;

	private CustomPayableINVInquiryListVO[] arrayCustomPayableINVInquiryListVOs = null;

	private CustomPayableInvoiceDetailINVO[] arrayCustomPayableInvoiceDetailINVOs = null;

	
	private List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS = null;     
	
	private CustomMnrPayInvWrkVO customMnrPayInvWrkVO = null;
	
	
	
	//Total Loss 를 위한
	private String ttlLssNo = null;
	private String ttlLssDtlSeq = null;
	private String ttlLssIssDt = null;
	private List<CustomMnrPayInvWrkVO> listCustomMnrPayInvWrkVO = null;
	private CustomMnrPayInvWrkVO[] arrayCustomMnrPayInvWrkVO = null;
	
	public EQFlagListINVO getEQFlagListINVO() {
		return eQFlagListINVO;
	}

	public void setEQFlagListINVO(EQFlagListINVO eQFlagListINVO) {
		this.eQFlagListINVO = eQFlagListINVO;
	}
	
	public List<CustomPayableINVInquiryListVO> getCustomPayableINVInquiryListVOs() {
		return customPayableINVInquiryListVOs;
	}
	public void setCustomPayableINVInquiryListVOs(
			List<CustomPayableINVInquiryListVO> customPayableINVInquiryListVOs) {
		this.customPayableINVInquiryListVOs = customPayableINVInquiryListVOs;
	}
	public List<CustomPayableInvoiceDetailINVO> getCustomPayableInvoiceDetailINVOs() {
		return customPayableInvoiceDetailINVOs;
	}
	public void setCustomPayableInvoiceDetailINVOs(
			List<CustomPayableInvoiceDetailINVO> customPayableInvoiceDetailINVOs) {
		this.customPayableInvoiceDetailINVOs = customPayableInvoiceDetailINVOs;
	}
	public PayableINVInquiryINVO getPayableINVInquiryINVO() {
		return payableINVInquiryINVO;
	}
	public void setPayableINVInquiryINVO(PayableINVInquiryINVO payableINVInquiryINVO) {
		this.payableINVInquiryINVO = payableINVInquiryINVO;
	}
	public CustomMnrPayInvWrkVO getCustomMnrPayInvWrkVO() {
		return customMnrPayInvWrkVO;
	}
	public void setCustomMnrPayInvWrkVO(CustomMnrPayInvWrkVO customMnrPayInvWrkVO) {
		this.customMnrPayInvWrkVO = customMnrPayInvWrkVO;
	}	
	public CustomPayableINVInquiryListVO[] getArrayCustomPayableINVInquiryListVOs() {
		return arrayCustomPayableINVInquiryListVOs;
	}
	public void setArrayCustomPayableINVInquiryListVOs(
			CustomPayableINVInquiryListVO[] arrayCustomPayableINVInquiryListVOs) {
		this.arrayCustomPayableINVInquiryListVOs = arrayCustomPayableINVInquiryListVOs;
	}
	public CustomPayableInvoiceDetailINVO[] getArrayCustomPayableInvoiceDetailINVOs() {
		return arrayCustomPayableInvoiceDetailINVOs;
	}
	public void setArrayCustomPayableInvoiceDetailINVOs(
			CustomPayableInvoiceDetailINVO[] arrayCustomPayableInvoiceDetailINVOs) {
		this.arrayCustomPayableInvoiceDetailINVOs = arrayCustomPayableInvoiceDetailINVOs;
	}
	public List<CustomMnrDatVrfyVO> getCustomMnrDatVrfyVOS() {
		return customMnrDatVrfyVOS;
	}
	public void setCustomMnrDatVrfyVOS(List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS) {
		this.customMnrDatVrfyVOS = customMnrDatVrfyVOS;
	}
	public String getTtlLssNo() {
		return ttlLssNo;
	}
	public void setTtlLssNo(String ttlLssNo) {
		this.ttlLssNo = ttlLssNo;
	}
	public String getTtlLssDtlSeq() {
		return ttlLssDtlSeq;
	}
	public void setTtlLssDtlSeq(String ttlLssDtlSeq) {
		this.ttlLssDtlSeq = ttlLssDtlSeq;
	}
	public String getTtlLssIssDt() {
		return ttlLssIssDt;
	}
	public void setTtlLssIssDt(String ttlLssIssDt) {
		this.ttlLssIssDt = ttlLssIssDt;
	}
	public List<CustomMnrPayInvWrkVO> getListCustomMnrPayInvWrkVO() {
		return listCustomMnrPayInvWrkVO;
	}
	public void setListCustomMnrPayInvWrkVO(
			List<CustomMnrPayInvWrkVO> listCustomMnrPayInvWrkVO) {
		this.listCustomMnrPayInvWrkVO = listCustomMnrPayInvWrkVO;
	}
	public CustomMnrPayInvWrkVO[] getArrayCustomMnrPayInvWrkVO() {
		return arrayCustomMnrPayInvWrkVO;
	}
	public void setArrayCustomMnrPayInvWrkVO(
			CustomMnrPayInvWrkVO[] arrayCustomMnrPayInvWrkVO) {
		this.arrayCustomMnrPayInvWrkVO = arrayCustomMnrPayInvWrkVO;
	}
}	
