/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0016Event.java
*@FileTitle : Invoice Item Correction(General)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceChargeCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceContainerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0016HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceCorrectionVO aRInvoiceCorrectionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceCorrectionVO[] aRInvoiceCorrectionVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DueDateInputVO dueDateInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DueDateInputVO[] dueDateInputVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DueDateVO dueDateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DueDateVO[] dueDateVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARCorrectionCkVO arCorrectionCkVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARCorrectionCkVO[] arCorrectionCkVOs = null;
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceCreationVO arInvoiceCreationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceCreationVO[] arInvoiceCreationVOs = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvNewCustVO invNewCustVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvNewCustVO[] invNewCustVOs = null;


	private ARInvoiceChargeSumVO aRInvoiceChargeSumVO = null;

	private ARInvoiceChargeSumVO[] aRInvoiceChargeSumVOs = null;
	
	private ARInvoiceChargeCorrectionVO aRInvoiceChargeCorrectionVO = null;

	private ARInvoiceChargeCorrectionVO[] aRInvoiceChargeCorrectionVOs = null;

	private ARInvoiceContainerVO aRInvoiceContainerVO = null;
	
	private ARInvoiceContainerVO[] aRInvoiceContainerVOs = null;

	private InvArCntrVO invArCntrVO = null;

	private InvArCntrVO[] invArCntrVOs = null;
	
	private InvArMnVO invArMnVO = null;

	private InvArMnVO[] invArMnVOs = null;
	
	private ARCreditInputVO aRCreditInputVO = null;
	
	private String ofcCd = null;
	
	private String blNo = null;
	
	private String invNo = null;
	
	private String ifNo = null;
	
	private String splitFlg = null;
	
	private String actInvFlag = null;
	
	private String otherFlag = null;
	
	private String blSrcNo = null;
	
	private String classId = null;
	
	private String arOfcCd = null;
	
	private String otsSmryCd = null;
	
	private String modFlag = null;
	
	private String invCustFlg = null;


	public FnsInv0016Event(){}
	
	public void setARInvoiceCorrectionVO(ARInvoiceCorrectionVO aRInvoiceCorrectionVO){
		this. aRInvoiceCorrectionVO = aRInvoiceCorrectionVO;
	}

	public void setARInvoiceCorrectionVOS(ARInvoiceCorrectionVO[] aRInvoiceCorrectionVOs){
		this. aRInvoiceCorrectionVOs = aRInvoiceCorrectionVOs;
	}

	public ARInvoiceCorrectionVO getARInvoiceCorrectionVO(){
		return aRInvoiceCorrectionVO;
	}

	public ARInvoiceCorrectionVO[] getARInvoiceCorrectionVOS(){
		return aRInvoiceCorrectionVOs;
	}
	
	

	/**
	 * @return the aRCreditInputVO
	 */
	public ARCreditInputVO getARCreditInputVO() {
		return aRCreditInputVO;
	}

	/**
	 * @param creditInputVO the aRCreditInputVO to set
	 */
	public void setARCreditInputVO(ARCreditInputVO creditInputVO) {
		aRCreditInputVO = creditInputVO;
	}

	/**
	 * @return the invCustFlg
	 */
	public String getInvCustFlg() {
		return invCustFlg;
	}

	/**
	 * @param invCustFlg the invCustFlg to set
	 */
	public void setInvCustFlg(String invCustFlg) {
		this.invCustFlg = invCustFlg;
	}

	/**
	 * @return the modFlag
	 */
	public String getModFlag() {
		return modFlag;
	}

	/**
	 * @param modFlag the modFlag to set
	 */
	public void setModFlag(String modFlag) {
		this.modFlag = modFlag;
	}

	/**
	 * @return the dueDateInputVO
	 */
	public DueDateInputVO getDueDateInputVO() {
		return dueDateInputVO;
	}

	/**
	 * @param dueDateInputVO the dueDateInputVO to set
	 */
	public void setDueDateInputVO(DueDateInputVO dueDateInputVO) {
		this.dueDateInputVO = dueDateInputVO;
	}

	/**
	 * @return the dueDateInputVOs
	 */
	public DueDateInputVO[] getDueDateInputVOs() {
		return dueDateInputVOs;
	}

	/**
	 * @param dueDateInputVOs the dueDateInputVOs to set
	 */
	public void setDueDateInputVOs(DueDateInputVO[] dueDateInputVOs) {
		this.dueDateInputVOs = dueDateInputVOs;
	}

	
	
	/**
	 * @return the dueDateVO
	 */
	public DueDateVO getDueDateVO() {
		return dueDateVO;
	}

	/**
	 * @param dueDateVO the dueDateVO to set
	 */
	public void setDueDateVO(DueDateVO dueDateVO) {
		this.dueDateVO = dueDateVO;
	}

	/**
	 * @return the dueDateVOs
	 */
	public DueDateVO[] getDueDateVOs() {
		return dueDateVOs;
	}

	/**
	 * @param dueDateVOs the dueDateVOs to set
	 */
	public void setDueDateVOs(DueDateVO[] dueDateVOs) {
		this.dueDateVOs = dueDateVOs;
	}

	
	
	
	/**
	 * @return the arCorrectionCkVO
	 */
	public ARCorrectionCkVO getArCorrectionCkVO() {
		return arCorrectionCkVO;
	}

	/**
	 * @param arCorrectionCkVO the arCorrectionCkVO to set
	 */
	public void setArCorrectionCkVO(ARCorrectionCkVO arCorrectionCkVO) {
		this.arCorrectionCkVO = arCorrectionCkVO;
	}

	/**
	 * @return the arCorrectionCkVOs
	 */
	public ARCorrectionCkVO[] getArCorrectionCkVOs() {
		return arCorrectionCkVOs;
	}

	/**
	 * @param arCorrectionCkVOs the arCorrectionCkVOs to set
	 */
	public void setArCorrectionCkVOs(ARCorrectionCkVO[] arCorrectionCkVOs) {
		this.arCorrectionCkVOs = arCorrectionCkVOs;
	}

	/**
	 * @return the arInvoiceCreationVO
	 */
	public ARInvoiceCreationVO getArInvoiceCreationVO() {
		return arInvoiceCreationVO;
	}

	/**
	 * @param arInvoiceCreationVO the arInvoiceCreationVO to set
	 */
	public void setArInvoiceCreationVO(ARInvoiceCreationVO arInvoiceCreationVO) {
		this.arInvoiceCreationVO = arInvoiceCreationVO;
	}

	/**
	 * @return the arInvoiceCreationVOs
	 */
	public ARInvoiceCreationVO[] getArInvoiceCreationVOs() {
		return arInvoiceCreationVOs;
	}

	/**
	 * @param arInvoiceCreationVOs the arInvoiceCreationVOs to set
	 */
	public void setArInvoiceCreationVOs(ARInvoiceCreationVO[] arInvoiceCreationVOs) {
		this.arInvoiceCreationVOs = arInvoiceCreationVOs;
	}

	/**
	 * @return the invNewCustVO
	 */
	public InvNewCustVO getInvNewCustVO() {
		return invNewCustVO;
	}

	/**
	 * @param invNewCustVO the invNewCustVO to set
	 */
	public void setInvNewCustVO(InvNewCustVO invNewCustVO) {
		this.invNewCustVO = invNewCustVO;
	}

	/**
	 * @return the invNewCustVOs
	 */
	public InvNewCustVO[] getInvNewCustVOs() {
		return invNewCustVOs;
	}

	/**
	 * @param invNewCustVOs the invNewCustVOs to set
	 */
	public void setInvNewCustVOs(InvNewCustVO[] invNewCustVOs) {
		this.invNewCustVOs = invNewCustVOs;
	}

	
	
	
	/**
	 * @return the aRInvoiceCorrectionVOs
	 */
	public ARInvoiceCorrectionVO[] getARInvoiceCorrectionVOs() {
		return aRInvoiceCorrectionVOs;
	}

	/**
	 * @param invoiceCorrectionVOs the aRInvoiceCorrectionVOs to set
	 */
	public void setARInvoiceCorrectionVOs(
			ARInvoiceCorrectionVO[] invoiceCorrectionVOs) {
		aRInvoiceCorrectionVOs = invoiceCorrectionVOs;
	}

	/**
	 * @return the aRInvoiceChargeSumVO
	 */
	public ARInvoiceChargeSumVO getARInvoiceChargeSumVO() {
		return aRInvoiceChargeSumVO;
	}

	/**
	 * @param invoiceChargeSumVO the aRInvoiceChargeSumVO to set
	 */
	public void setARInvoiceChargeSumVO(ARInvoiceChargeSumVO invoiceChargeSumVO) {
		aRInvoiceChargeSumVO = invoiceChargeSumVO;
	}

	/**
	 * @return the aRInvoiceChargeSumVOs
	 */
	public ARInvoiceChargeSumVO[] getARInvoiceChargeSumVOs() {
		return aRInvoiceChargeSumVOs;
	}

	/**
	 * @param invoiceChargeSumVOs the aRInvoiceChargeSumVOs to set
	 */
	public void setARInvoiceChargeSumVOs(ARInvoiceChargeSumVO[] invoiceChargeSumVOs) {
		aRInvoiceChargeSumVOs = invoiceChargeSumVOs;
	}

	/**
	 * @return the aRInvoiceChargeCorrectionVO
	 */
	public ARInvoiceChargeCorrectionVO getARInvoiceChargeCorrectionVO() {
		return aRInvoiceChargeCorrectionVO;
	}

	/**
	 * @param invoiceChargeCorrectionVO the aRInvoiceChargeCorrectionVO to set
	 */
	public void setARInvoiceChargeCorrectionVO(
			ARInvoiceChargeCorrectionVO invoiceChargeCorrectionVO) {
		aRInvoiceChargeCorrectionVO = invoiceChargeCorrectionVO;
	}

	/**
	 * @return the aRInvoiceChargeCorrectionVOs
	 */
	public ARInvoiceChargeCorrectionVO[] getARInvoiceChargeCorrectionVOs() {
		return aRInvoiceChargeCorrectionVOs;
	}

	/**
	 * @param invoiceChargeCorrectionVOs the aRInvoiceChargeCorrectionVOs to set
	 */
	public void setARInvoiceChargeCorrectionVOs(
			ARInvoiceChargeCorrectionVO[] invoiceChargeCorrectionVOs) {
		aRInvoiceChargeCorrectionVOs = invoiceChargeCorrectionVOs;
	}

	/**
	 * @return the invArCntrVO
	 */
	public InvArCntrVO getInvArCntrVO() {
		return invArCntrVO;
	}

	/**
	 * @param invArCntrVO the invArCntrVO to set
	 */
	public void setInvArCntrVO(InvArCntrVO invArCntrVO) {
		this.invArCntrVO = invArCntrVO;
	}

	/**
	 * @return the invArCntrVOs
	 */
	public InvArCntrVO[] getInvArCntrVOs() {
		return invArCntrVOs;
	}

	/**
	 * @param invArCntrVOs the invArCntrVOs to set
	 */
	public void setInvArCntrVOs(InvArCntrVO[] invArCntrVOs) {
		this.invArCntrVOs = invArCntrVOs;
	}

	
	
	/**
	 * @return the aRInvoiceContainerVO
	 */
	public ARInvoiceContainerVO getARInvoiceContainerVO() {
		return aRInvoiceContainerVO;
	}

	/**
	 * @param invoiceContainerVO the aRInvoiceContainerVO to set
	 */
	public void setARInvoiceContainerVO(ARInvoiceContainerVO invoiceContainerVO) {
		aRInvoiceContainerVO = invoiceContainerVO;
	}

	/**
	 * @return the aRInvoiceContainerVOs
	 */
	public ARInvoiceContainerVO[] getARInvoiceContainerVOs() {
		return aRInvoiceContainerVOs;
	}

	/**
	 * @param invoiceContainerVOs the aRInvoiceContainerVOs to set
	 */
	public void setARInvoiceContainerVOs(ARInvoiceContainerVO[] invoiceContainerVOs) {
		aRInvoiceContainerVOs = invoiceContainerVOs;
	}
	

	/**
	 * @return the otsSmryCd
	 */
	public String getOtsSmryCd() {
		return otsSmryCd;
	}

	/**
	 * @param otsSmryCd the otsSmryCd to set
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}

	/**
	 * @return the blSrcNo
	 */
	public String getBlSrcNo() {
		return blSrcNo;
	}

	/**
	 * @param blSrcNo the blSrcNo to set
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	/**
	 * @return the classId
	 */
	public String getClassId() {
		return classId;
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}

	/**
	 * @return the arOfcCd
	 */
	public String getArOfcCd() {
		return arOfcCd;
	}

	/**
	 * @param arOfcCd the arOfcCd to set
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the blNo
	 */
	public String getBlNo() {
		return blNo;
	}

	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * @return the invNo
	 */
	public String getInvNo() {
		return invNo;
	}

	/**
	 * @param invNo the invNo to set
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * @return the ifNo
	 */
	public String getIfNo() {
		return ifNo;
	}

	/**
	 * @param ifNo the ifNo to set
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}

	/**
	 * @return the splitFlg
	 */
	public String getSplitFlg() {
		return splitFlg;
	}

	/**
	 * @param splitFlg the splitFlg to set
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}

	/**
	 * @return the actInvFlag
	 */
	public String getActInvFlag() {
		return actInvFlag;
	}

	/**
	 * @param actInvFlag the actInvFlag to set
	 */
	public void setActInvFlag(String actInvFlag) {
		this.actInvFlag = actInvFlag;
	}

	/**
	 * @return the otherFlag
	 */
	public String getOtherFlag() {
		return otherFlag;
	}

	/**
	 * @param otherFlag the otherFlag to set
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}

	/**
	 * @return the invArMnVO
	 */
	public InvArMnVO getInvArMnVO() {
		return invArMnVO;
	}

	/**
	 * @param invArMnVO the invArMnVO to set
	 */
	public void setInvArMnVO(InvArMnVO invArMnVO) {
		this.invArMnVO = invArMnVO;
	}

	/**
	 * @return the invArMnVOs
	 */
	public InvArMnVO[] getInvArMnVOs() {
		return invArMnVOs;
	}

	/**
	 * @param invArMnVOs the invArMnVOs to set
	 */
	public void setInvArMnVOs(InvArMnVO[] invArMnVOs) {
		this.invArMnVOs = invArMnVOs;
	}
	
	

}