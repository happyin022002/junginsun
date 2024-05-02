/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostVO.java
*@FileTitle : PayableRentalCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.18 노정용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo;

import java.util.List;

import com.hanjin.syscommon.common.table.LsePayRntlChgCoVO;
//import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
//import com.hanjin.syscommon.common.table.ApPayInvVO;

/**
 * AgreementRegistrationVO GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 노정용 
 * @since J2EE 1.6
 * @see	  ..   
 */
public class PayableRentalCostVO {

	private String agmtCtyCd    = "";
	private String agmtSeq      = "";
	private String lseCtrtNo    = "";
	private String coCostYrmon  = "";
	private String chgCostYrmon = "";
	private String usrId        = "";
	private String uploadFileNm = "";
	private String chgSeq       = "";
	private String ofcCd        = "";
	private String vndrSeq      = "";
	private String lstmCd       = "";

	/** Table Value Object 단건 Data 처리 */
	private PayableRentalCostCreatVO rentalCostCreatVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<LsePayRntlChgCoVO> lsePayRntlChgCoVOs = null;

	/** Table Value Object Multi Data 처리 */
	private List<PayableRentalCostCreatVO> payableRentalCostCreatVOs = null;

	/** Table Value Object Multi Data 처리 */
	private PayableRentalCostCreatVO[] payableRentalCostCreatVO = null;

	/** Table Value Object Multi Data 처리 */
	private PayableRentalCostAuditSearchVO payableRentalCostAuditSearchVO = null;

	private List<List<PayableRentalCostAuditVO>> payableRentalCostAuditVOs = null;
	
	private PayableRentalCostAuditVO[] payableRentalCostAuditVO = null;
	
	private List<PayableRentalCostInvoiceCreateVO> payableRentalCostInvoiceCreateVOs = null;

	private PayableRentalCostInvoiceCreateVO[] arrPayableRentalCostInvoiceCreateVO = null;

	private PayableRentalCostOperationalInvoiceVO payableRentalCostOperationalInvoiceVO = null;
	
	private List<PayableRentalCostOperationalInvoiceVO> payableRentalCostOperationalInvoiceVOs = null;
	
	private PayableRentalCostOperationalInvoiceVO[] arrPayableRentalCostOperationalInvoiceVO = null;

	/*
	 *  Table Value Object Multi Data 처리<br>
	 *  Payable Rental Charge Creation - Invoice Creation 생성시 AP Master Temp Table 객체
	 */
	//private List<ApPayInvVO> payableInvocieApPayInvVOs = null;

	/*
	 *  Table Value Object Multi Data 처리<br>
	 *  Payable Rental Charge Creation - Invoice Creation 생성시 AP Detail Temp Table 객체
	 */
	//private List<ApPayInvDtlVO> payableInvocieApPayInvDtlVOs = null;

	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	public String getAgmtCtyCd() {
		return agmtCtyCd;
	}

	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	public String getAgmtSeq() {
		return agmtSeq;
	}

	public void setLseCtrtNo(String lseCtrtNo) {
		this.lseCtrtNo = lseCtrtNo;
	}

	public String getLseCtrtNo() {
		return lseCtrtNo;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setCoCostYrmon(String coCostYrmon) {
		this.coCostYrmon = coCostYrmon;
	}

	public String getCoCostYrmon() {
		return coCostYrmon;
	}

	public void setUploadFileNm(String uploadFileNm) {
		this.uploadFileNm = uploadFileNm;
	}

	public String getUploadFileNm() {
		return uploadFileNm;
	}

	public void setChgCostYrmon(String chgCostYrmon) {
		this.chgCostYrmon = chgCostYrmon;
	}

	public String getChgCostYrmon() {
		return chgCostYrmon;
	}

	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}

	public String getChgSeq() {
		return chgSeq;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	public String getLstmCd() {
		return lstmCd;
	}

	public void setLsePayRntlChgCoVOs(List<LsePayRntlChgCoVO> lsePayRntlChgCoVOs) {
		this.lsePayRntlChgCoVOs = lsePayRntlChgCoVOs;
	}

	public List<LsePayRntlChgCoVO> getLsePayRntlChgCoVOs() {
		return lsePayRntlChgCoVOs;
	}

	public void setPayableRentalCostCreatVOs(
			List<PayableRentalCostCreatVO> payableRentalCostCreatVOs) {
		this.payableRentalCostCreatVOs = payableRentalCostCreatVOs;
	}

	public List<PayableRentalCostCreatVO> getPayableRentalCostCreatVOs() {
		return payableRentalCostCreatVOs;
	}

	public void setPayableRentalCostCreatVO(PayableRentalCostCreatVO[] payableRentalCostCreatVO) {
		this.payableRentalCostCreatVO = payableRentalCostCreatVO;
	}

	public PayableRentalCostCreatVO[] getPayableRentalCostCreatVO() {
		return payableRentalCostCreatVO;
	}

	public void setRentalCostCreatVO(PayableRentalCostCreatVO rentalCostCreatVO) {
		this.rentalCostCreatVO = rentalCostCreatVO;
	}

	public PayableRentalCostCreatVO getRentalCostCreatVO() {
		return rentalCostCreatVO;
	}

	public void setPayableRentalCostAuditVOs(
			List<List<PayableRentalCostAuditVO>> payableRentalCostAuditVOs) {
		this.payableRentalCostAuditVOs = payableRentalCostAuditVOs;
	}

	public List<List<PayableRentalCostAuditVO>> getPayableRentalCostAuditVOs() {
		return payableRentalCostAuditVOs;
	}

	public void setPayableRentalCostAuditSearchVO(
			PayableRentalCostAuditSearchVO payableRentalCostAuditSearchVO) {
		this.payableRentalCostAuditSearchVO = payableRentalCostAuditSearchVO;
	}

	public PayableRentalCostAuditSearchVO getPayableRentalCostAuditSearchVO() {
		return payableRentalCostAuditSearchVO;
	}

	public void setPayableRentalCostAuditVO(PayableRentalCostAuditVO[] payableRentalCostAuditVO) {
		this.payableRentalCostAuditVO = payableRentalCostAuditVO;
	}

	public PayableRentalCostAuditVO[] getPayableRentalCostAuditVO() {
		return payableRentalCostAuditVO;
	}

	public void setPayableRentalCostInvoiceCreateVOs(
			List<PayableRentalCostInvoiceCreateVO> payableRentalCostInvoiceCreateVOs) {
		this.payableRentalCostInvoiceCreateVOs = payableRentalCostInvoiceCreateVOs;
	}

	public List<PayableRentalCostInvoiceCreateVO> getPayableRentalCostInvoiceCreateVOs() {
		return payableRentalCostInvoiceCreateVOs;
	}

	public void setPayableRentalCostOperationalInvoiceVO(
			PayableRentalCostOperationalInvoiceVO payableRentalCostOperationalInvoiceVO) {
		this.payableRentalCostOperationalInvoiceVO = payableRentalCostOperationalInvoiceVO;
	}

	public PayableRentalCostOperationalInvoiceVO getPayableRentalCostOperationalInvoiceVO() {
		return payableRentalCostOperationalInvoiceVO;
	}

	public void setPayableRentalCostOperationalInvoiceVOs(
			List<PayableRentalCostOperationalInvoiceVO> payableRentalCostOperationalInvoiceVOs) {
		this.payableRentalCostOperationalInvoiceVOs = payableRentalCostOperationalInvoiceVOs;
	}

	public List<PayableRentalCostOperationalInvoiceVO> getPayableRentalCostOperationalInvoiceVOs() {
		return payableRentalCostOperationalInvoiceVOs;
	}

	public void setArrPayableRentalCostOperationalInvoiceVO(
			PayableRentalCostOperationalInvoiceVO[] arrPayableRentalCostOperationalInvoiceVO) {
		this.arrPayableRentalCostOperationalInvoiceVO = arrPayableRentalCostOperationalInvoiceVO;
	}

	public PayableRentalCostOperationalInvoiceVO[] getArrPayableRentalCostOperationalInvoiceVO() {
		return arrPayableRentalCostOperationalInvoiceVO;
	}
/*
	public void setPayableInvocieApPayInvVOs(
			List<ApPayInvVO> payableInvocieApPayInvVOs) {
		this.payableInvocieApPayInvVOs = payableInvocieApPayInvVOs;
	}

	public List<ApPayInvVO> getPayableInvocieApPayInvVOs() {
		return payableInvocieApPayInvVOs;
	}

	public void setPayableInvocieApPayInvDtlVOs(
			List<ApPayInvDtlVO> payableInvocieApPayInvDtlVOs) {
		this.payableInvocieApPayInvDtlVOs = payableInvocieApPayInvDtlVOs;
	}

	public List<ApPayInvDtlVO> getPayableInvocieApPayInvDtlVOs() {
		return payableInvocieApPayInvDtlVOs;
	}
*/

	public void setArrPayableRentalCostInvoiceCreateVO(
			PayableRentalCostInvoiceCreateVO[] arrPayableRentalCostInvoiceCreateVO) {
		this.arrPayableRentalCostInvoiceCreateVO = arrPayableRentalCostInvoiceCreateVO;
	}

	public PayableRentalCostInvoiceCreateVO[] getArrPayableRentalCostInvoiceCreateVO() {
		return arrPayableRentalCostInvoiceCreateVO;
	}
}