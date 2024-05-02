/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0037Event.java
*@FileTitle : customer contact point
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerContactVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0037HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerContactVO customerContractVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerContactVO[] customerContractVOs = null;
	private String custCntCd = ""; 
	
	private String custSeq = ""; 
	
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


	public BcmCcd0037Event(){}
	
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

}