/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0039Event.java
*@FileTitle : credit customer
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event;
 
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreditCustomerVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0039HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CreditCustomerVO creditCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CreditCustomerVO[] creditCustomerVOs = null;
	
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


	public BcmCcd0039Event(){}
	
	public void setCreditCustomerVO(CreditCustomerVO creditCustomerVO){
		this. creditCustomerVO = creditCustomerVO;
	}

	public void setCreditCustomerVOS(CreditCustomerVO[] creditCustomerVOs){
		if(creditCustomerVOs != null){
			CreditCustomerVO[] tmpVOs = java.util.Arrays.copyOf(creditCustomerVOs, creditCustomerVOs.length);
			this.creditCustomerVOs = tmpVOs;
		}
	}

	public CreditCustomerVO getCreditCustomerVO(){
		return creditCustomerVO;
	}

	public CreditCustomerVO[] getCreditCustomerVOS(){
		CreditCustomerVO[] rtnVOs = null;
		if (this.creditCustomerVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(creditCustomerVOs, creditCustomerVOs.length);
		}
		return rtnVOs;
	}

}