/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0035Event.java
*@FileTitle : customer
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerContactVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerIntegrationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.BkgSalesRepVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0035HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerIntegrationVO customerIntgVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerIntegrationVO[] customerIntgVOArr = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerVO customerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerVO[] customerVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCustomerVO mdmCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCustomerVO[] mdmCustomerVOs = null;
	private MdmCustomerVO[] mdmCustomerVOs2 = null;
	private MdmCustomerVO[] mdmCustomerVOs3 = null;
	
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
	
	
	private String rqstNo = null;
	
	private String creflag = null;
	
	private String saveflag = null;
	
	
	//// addr & cntc pnt ///////////////////
	private CustomerAddressVO customerAddressVO = null;
	
	private CustomerAddressVO[] customerAddressVOs = null;
	
	private String addrTpCd = ""; 
	
    private String cntCd = null;
	
	private String steCd = null;
	
    private String prmryChkFlg = null;
    
	private CustomerContactVO customerContractVO = null;
	
	private CustomerContactVO[] customerContractVOs = null;
    ///////////////////////////////////////
    
	private String isNewYn = null;

	public BcmCcd0035Event(){}

	public void setRqstNo(String rqstNo){
		this.rqstNo = rqstNo;
	}
	
	public String getRqstNo(){
		return rqstNo;
	}

	public void setCreflag(String creflag){
		this.creflag = creflag;
	}
	
	public String getCreflag(){
		return creflag;
	}

	public void setSaveflag(String saveflag){
		this.saveflag = saveflag;
	}
	
	public String getSaveflag(){
		return saveflag;
	}

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

	public void setMdmCustomerVOS2(MdmCustomerVO[] mdmCustomerVOs2){
		if(mdmCustomerVOs2 != null){
			MdmCustomerVO[] tmpVOs = java.util.Arrays.copyOf(mdmCustomerVOs2, mdmCustomerVOs2.length);
			this.mdmCustomerVOs2 = tmpVOs;
		}
	}

	public void setMdmCustomerVOS3(MdmCustomerVO[] mdmCustomerVOs3){
		if(mdmCustomerVOs3 != null){
			MdmCustomerVO[] tmpVOs = java.util.Arrays.copyOf(mdmCustomerVOs3, mdmCustomerVOs3.length);
			this.mdmCustomerVOs3 = tmpVOs;
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
	
	public MdmCustomerVO[] getMdmCustomerVOS2(){
		MdmCustomerVO[] rtnVOs = null;
		if (this.mdmCustomerVOs2 != null) {
			rtnVOs = java.util.Arrays.copyOf(mdmCustomerVOs2, mdmCustomerVOs2.length);
		}
		return rtnVOs;
	}
	
	public MdmCustomerVO[] getMdmCustomerVOS3(){
		MdmCustomerVO[] rtnVOs = null;
		if (this.mdmCustomerVOs3 != null) {
			rtnVOs = java.util.Arrays.copyOf(mdmCustomerVOs3, mdmCustomerVOs3.length);
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

	//// addr & cntc pnt b /////////////
	/**
	 * @return the prmryChkFlg
	 */
	public String getPrmryChkFlg() {
		return prmryChkFlg;                 
	}

	/**
	 * @param prmryChkFlg the prmryChkFlg to set
	 */
	public void setPrmryChkFlg(String prmryChkFlg) {
		this.prmryChkFlg = prmryChkFlg;        
	}
	
	/**
	 * @return the custCntCd
	 */
	public String getAddrTpCd() {
		return addrTpCd;                 
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setAddrTpCd(String addrTpCd) {
		this.addrTpCd = addrTpCd;        
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
	
	public String getCntCd() {
		return cntCd;
	}

	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	public String getSteCd() {
		return steCd;
	}

	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	public void setCustomerContactVO(CustomerContactVO customerContractVO){
		this. customerContractVO = customerContractVO;
	}

	public void setCustomerContactVOS(CustomerContactVO[] customerContractVOs){
		if(customerContractVOs != null){
			CustomerContactVO[] tmpVOs = java.util.Arrays.copyOf(customerContractVOs, customerContractVOs.length);
			this.customerContractVOs = tmpVOs;
		}
	}

	public CustomerContactVO getCustomerContactVO(){
		return customerContractVO;
	}

	public CustomerContactVO[] getCustomerContactVOS(){
		CustomerContactVO[] rtnVOs = null;
		if (this.customerContractVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customerContractVOs, customerContractVOs.length);
		}
		return rtnVOs;
	}	
	////addr & cntc pnt e /////////////

	public CustomerIntegrationVO getCustomerIntgVO() {
		return customerIntgVO;
	}

	public void setCustomerIntgVO(CustomerIntegrationVO customerIntgVO) {
		this.customerIntgVO = customerIntgVO;
	}

	public CustomerIntegrationVO[] getCustomerIntgVOArr() {
		CustomerIntegrationVO[] rtnVOs = null;
		if (this.customerIntgVOArr != null) {
			rtnVOs = java.util.Arrays.copyOf(customerIntgVOArr, customerIntgVOArr.length);
		}
		return rtnVOs;
	}

	public void setCustomerIntgVOArr(CustomerIntegrationVO[] customerIntgVOArr){
		if(customerIntgVOArr != null){
			CustomerIntegrationVO[] tmpVOs = java.util.Arrays.copyOf(customerIntgVOArr, customerIntgVOArr.length);
			this.customerIntgVOArr = tmpVOs;
		}
	}
}