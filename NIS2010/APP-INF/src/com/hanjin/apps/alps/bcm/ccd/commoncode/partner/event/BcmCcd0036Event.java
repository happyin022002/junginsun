/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0036Event.java
*@FileTitle : customer address
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0036HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0036Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerAddressVO customerAddressVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerAddressVO[] customerAddressVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCustomerVO mdmCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCustomerVO[] mdmCustomerVOs = null;
	
	
	
	
	private String custCntCd = ""; 
	
	private String custSeq = ""; 
	
	private String addrTpCd = ""; 
	
    private String cntCd = null;
	
	private String steCd = null;
	
    private String custCd = null;
    
    private String prmryChkFlg = null;
    
	
	/**
	 * @return the custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;                 
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;        
	}
	
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
	 * @return the custCd
	 */
	public String getCustCd() {
		return custCd;                 
	}

	/**
	 * @param custCntCd the custCd to set
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;        
	}
	
	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;                 
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;        
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
	

	public BcmCcd0036Event(){}
	
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

}