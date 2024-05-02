/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : BcmCms0311Event.java
*@FileTitle : credit customer
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.event;

import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreateMdmCustRepVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreditCustomerVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerAddressVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CMS_0311 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CMS_0311HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CMS_0311HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCms0311Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CreditCustomerVO creditCustomerVO = null;
	//private CustomerAddressVO[] createMdmCustRepVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CreateMdmCustRepVO createMdmCustRepVO = null;
	private CreateMdmCustRepVO[] createMdmCustRepVOs = null;
	
    private String custCntCd = ""; 
	
	private String custSeq = ""; 
	
	private String crCltOfcCd = ""; 
	
	private String crCurrCd = ""; 
	
	private String actCustCd ="";
	
	private String custCd = null;
	
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
	 * @return the custCntCd
	 */
	public String getActCustCd() {
		return actCustCd;                 
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setActCustCd(String actCustCd) {
		this.actCustCd = actCustCd;        
	}
	
	/**
	 * @return the custCntCd
	 */
	public String getCrCurrCd() {
		return crCurrCd;                 
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCrCurrCd(String crCurrCd) {
		this.crCurrCd = crCurrCd;        
	}
	
	/**
	 * @return the custCntCd
	 */
	public String getCrCltOfcCd() {
		return crCltOfcCd;                 
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;        
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

	public BcmCms0311Event(){}
	
	public void setCreditCustomerVO(CreditCustomerVO creditCustomerVO){
		this. creditCustomerVO = creditCustomerVO;
	}

	public CreditCustomerVO getCreditCustomerVO(){
		return creditCustomerVO;
	}
	
	public void setCreateMdmCustRepVO(CreateMdmCustRepVO createMdmCustRepVO){
		this. createMdmCustRepVO = createMdmCustRepVO;
	}
	
	public void setCreateMdmCustRepVOS(CreateMdmCustRepVO[] createMdmCustRepVOs){
		if(createMdmCustRepVOs != null){
			CreateMdmCustRepVO[] tmpVOs = java.util.Arrays.copyOf(createMdmCustRepVOs, createMdmCustRepVOs.length);
			this.createMdmCustRepVOs = tmpVOs;
		}
	}
	
	public CreateMdmCustRepVO getCreateMdmCustRepVO(){
		return createMdmCustRepVO;
	}
	
	public CreateMdmCustRepVO[] getCreateMdmCustRepVOS(){
		CreateMdmCustRepVO[] rtnVOs = null;
		if (this.createMdmCustRepVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(createMdmCustRepVOs, createMdmCustRepVOs.length);
		}
		return rtnVOs;
	}
	
	
/*	public void setCustomerAddressVO(CustomerAddressVO customerAddressVO){
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
	}*/
	
	
	
	
}