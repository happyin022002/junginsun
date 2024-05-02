/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0052Event.java
*@FileTitle : Customer Integration 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.event;
 
import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgSalesRepVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.framework.support.layer.event.EventSupport;
 

/**
 * BCM_CCD_0052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0052HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0052Event extends EventSupport {

	/*--035 Customer-------------------------------*/
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerVO customerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerVO[] customerVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCustomerVO mdmCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCustomerVO[] mdmCustomerVOs = null;
	
	private BkgSalesRepVO bkgSalesRepVO = null;
	
	private BkgSalesRepVO[] bkgSalesRepVOs = null;
	
	private MdmDatProcVO mdmDatProcVO = null;
	
	private String custSeq = null;
	
	private String custCntCd = null;
	
	private String custCd = null;
		
	private String locCd = null;
	
	private String ofcCd = null;

	private String vndrSeq = null;
	
	private String capiCurrCd = null;
	
	private String prfRepCmdtCd = null;
	
	private String srepCd = null;
	
	private String custGrpId = null;
	
	private String isNewYn = null;
	
	public BcmCcd0052Event(){}

	public void setIsNewYn(String isNewYn){
		this.isNewYn = isNewYn;
	}
	
	public String getIsNewYn(){
		return isNewYn;
	}

	public void setCustSeq(String custSeq){
		this. custSeq = custSeq;
	}
	
	public String getCustSeq(){
		return custSeq;
	}
	
	public void setCustGrpId(String custGrpId){
		this. custGrpId = custGrpId;
	}
	
	public String getCustGrpId(){
		return custGrpId;
	}
	
	public void setSrepCd(String srepCd){
		this. srepCd = srepCd;
	}
	
	public String getSrepCd(){
		return srepCd;
	}
	
	public void setCustCd(String custCd){
		this. custCd = custCd;
	}
	
	public String getCustCd(){
		return custCd;
	}
	
	public void setCapiCurrCd(String capiCurrCd){
		this. capiCurrCd = capiCurrCd;
	}
	
	public String getCapiCurrCd(){
		return capiCurrCd;
	}
	
	public void setPrfRepCmdtCd(String prfRepCmdtCd){
		this. prfRepCmdtCd = prfRepCmdtCd;
	}
	
	public String getPrfRepCmdtCd(){
		return prfRepCmdtCd;
	}
	
	public void setVndrSeq(String vndrSeq){
		this. vndrSeq = vndrSeq;
	}
	
	public String getVndrSeq(){
		return vndrSeq;
	}
	
	public void setLocCd(String locCd){
		this. locCd = locCd;
	}
	
	public String getLocCd(){
		return locCd;
	}
	
	public void setOfcCd(String ofcCd){
		this. ofcCd = ofcCd;
	}
	
	public String getOfcCd(){
		return ofcCd;
	}
	
	public void setCustCntCd(String custCntCd){
		this. custCntCd = custCntCd;
	}
	
	public String getCustCntCd(){
		return custCntCd;
	}
	
	public void setBkgSalesRepVO(BkgSalesRepVO bkgSalesRepVO){
		this. bkgSalesRepVO = bkgSalesRepVO;
	}

	public void setBkgSalesRepVOS(BkgSalesRepVO[] bkgSalesRepVOs){
		if(bkgSalesRepVOs != null){
			BkgSalesRepVO[] tmpVOs = java.util.Arrays.copyOf(bkgSalesRepVOs, bkgSalesRepVOs.length);
			this.bkgSalesRepVOs = tmpVOs;
		}
	}

	public BkgSalesRepVO getBkgSalesRepVO(){
		return bkgSalesRepVO;
	}

	public BkgSalesRepVO[] getBkgSalesRepVOS(){
		BkgSalesRepVO[] rtnVOs = null;
		if (this.bkgSalesRepVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(bkgSalesRepVOs, bkgSalesRepVOs.length);
		}
		return rtnVOs;
	}
	
	public void setMdmCustomerVO(MdmCustomerVO mdmCustomerVO){
		this. mdmCustomerVO = mdmCustomerVO;
	}

	public void setMdmCustomerVOS(MdmCustomerVO[] mdmCustomerVOs){
		if(mdmCustomerVOs != null){
			MdmCustomerVO[] tmpVOs = java.util.Arrays.copyOf(mdmCustomerVOs, mdmCustomerVOs.length);
			this.mdmCustomerVOs = tmpVOs;
		}
	}

	public MdmCustomerVO getMdmCustomerVO(){
		return mdmCustomerVO;
	}

	public MdmCustomerVO[] getMdmCustomerVOS(){
		MdmCustomerVO[] rtnVOs = null;
		if (this.mdmCustomerVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mdmCustomerVOs, mdmCustomerVOs.length);
		}
		return rtnVOs;
	}
	
	public void setCustomerVO(CustomerVO customerVO){
		this. customerVO = customerVO;
	}

	public void setCustomerVOS(CustomerVO[] customerVOs){
		if(customerVOs != null){
			CustomerVO[] tmpVOs = java.util.Arrays.copyOf(customerVOs, customerVOs.length);
			this.customerVOs = tmpVOs;
		}
	}

	public CustomerVO getCustomerVO(){
		return customerVO;
	}

	public CustomerVO[] getCustomerVOS(){
		CustomerVO[] rtnVOs = null;
		if (this.customerVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customerVOs, customerVOs.length);
		}
		return rtnVOs;
	}

	public MdmDatProcVO getMdmDatProcVO() {
		return mdmDatProcVO;
	}

	public void setMdmDatProcVO(MdmDatProcVO mdmDatProcVO) {
		this.mdmDatProcVO = mdmDatProcVO;
	}
	
	
	/*--036 Customer Address-------------------------------*/

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerAddressVO customerAddressVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerAddressVO[] customerAddressVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCustomerVO amdmCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCustomerVO[] amdmCustomerVOs = null;
	
	
	
	
	private String acustCntCd = ""; 
	
	private String acustSeq = ""; 
	
	private String aaddrTpCd = ""; 
	
    private String acntCd = null;
	
	private String asteCd = null;
	
    private String acustCd = null;
    
    private String aprmryChkFlg = null;
    
	
	/**
	 * @return the custCntCd
	 */
	public String getACustCntCd() {
		return acustCntCd;                 
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setACustCntCd(String acustCntCd) {
		this.acustCntCd = acustCntCd;        
	}
	
	/**
	 * @return the prmryChkFlg
	 */
	public String getAPrmryChkFlg() {
		return aprmryChkFlg;                 
	}

	/**
	 * @param prmryChkFlg the prmryChkFlg to set
	 */
	public void setAPrmryChkFlg(String aprmryChkFlg) {
		this.aprmryChkFlg = aprmryChkFlg;        
	}
	
	/**
	 * @return the custCd
	 */
	public String getACustCd() {
		return acustCd;                 
	}

	/**
	 * @param custCntCd the custCd to set
	 */
	public void setACustCd(String acustCd) {
		this.acustCd = acustCd;        
	}
	
	/**
	 * @return the custSeq
	 */
	public String getACustSeq() {
		return acustSeq;                 
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setACustSeq(String acustSeq) {
		this.acustSeq = acustSeq;        
	}
	
	/**
	 * @return the custCntCd
	 */
	public String getAAddrTpCd() {
		return aaddrTpCd;                 
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setAAddrTpCd(String aaddrTpCd) {
		this.aaddrTpCd = aaddrTpCd;        
	}
	

	public void setAMdmCustomerVO(MdmCustomerVO amdmCustomerVO){
		this.amdmCustomerVO = amdmCustomerVO;
	}

	public void setAMdmCustomerVOS(MdmCustomerVO[] amdmCustomerVOs){
		if(amdmCustomerVOs != null){
			MdmCustomerVO[] tmpVOs = java.util.Arrays.copyOf(amdmCustomerVOs, amdmCustomerVOs.length);
			this.amdmCustomerVOs = tmpVOs;
		}
	}

	public MdmCustomerVO getAMdmCustomerVO(){
		return amdmCustomerVO;
	}

	public MdmCustomerVO[] getAMdmCustomerVOS(){
		MdmCustomerVO[] rtnVOs = null;
		if (this.amdmCustomerVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(amdmCustomerVOs, amdmCustomerVOs.length);
		}
		return rtnVOs;
	}
	


	
	
	public void setCustomerAddressVO(CustomerAddressVO customerAddressVO){
		this. customerAddressVO = customerAddressVO;
	}

	public void setCustomerAddressVOS(CustomerAddressVO[] customerAddressVOs){
		if(customerAddressVOs != null){
			CustomerAddressVO[] tmpVOs = java.util.Arrays.copyOf(customerAddressVOs, customerAddressVOs.length);
			this.customerAddressVOs = tmpVOs;
		}
	}

	public CustomerAddressVO getCustomerAddressVO(){
		return customerAddressVO;
	}

	public CustomerAddressVO[] getCustomerAddressVOS(){
		CustomerAddressVO[] rtnVOs = null;
		if (this.customerAddressVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customerAddressVOs, customerAddressVOs.length);
		}
		return rtnVOs;
	}
	
	public String getACntCd() {
		return acntCd;
	}

	public void setACntCd(String acntCd) {
		this.acntCd = acntCd;
	}
	
	public String getASteCd() {
		return asteCd;
	}

	public void setASteCd(String asteCd) {
		this.asteCd = asteCd;
	}	
	
}