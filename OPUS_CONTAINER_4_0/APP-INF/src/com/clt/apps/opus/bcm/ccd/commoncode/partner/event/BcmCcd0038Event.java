/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0038Event.java
*@FileTitle : customer performance group
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.event;

import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerPerformanceVO;
import com.clt.framework.support.layer.event.EventSupport;
 

/**
 * BCM_CCD_0038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0038HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0038Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerPerformanceVO customerPerformanceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerPerformanceVO[] customerPerformanceVOs = null;
	
	private MdmDatProcVO mdmDatProcVO = null;
	
	private String ofcCd = null;
	
	private String srepCd = null;
	
	private String custGrpId = null;

	public BcmCcd0038Event(){}
	
	public void setCustomerPerformanceVO(CustomerPerformanceVO customerPerformanceVO){
		this. customerPerformanceVO = customerPerformanceVO;
	}

	public void setCustomerPerformanceVOS(CustomerPerformanceVO[] customerPerformanceVOs){
		if(customerPerformanceVOs != null){
			CustomerPerformanceVO[] tmpVOs = java.util.Arrays.copyOf(customerPerformanceVOs, customerPerformanceVOs.length);
			this.customerPerformanceVOs = tmpVOs;
		}
	}

	public CustomerPerformanceVO getCustomerPerformanceVO(){
		return customerPerformanceVO;
	}

	public CustomerPerformanceVO[] getCustomerPerformanceVOS(){
		CustomerPerformanceVO[] rtnVOs = null;
		if (this.customerPerformanceVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customerPerformanceVOs, customerPerformanceVOs.length);
		}
		return rtnVOs;
	}
	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	public String getSrepCd() {
		return srepCd;
	}

	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}

	public String getCustGrpId(){
		return custGrpId;
	}
	
	public void setCustGrpId(){
		this.custGrpId = "";
	}
	
	public MdmDatProcVO getMdmDatProcVO() {
		return mdmDatProcVO;
	}

	public void setMdmDatProcVO(MdmDatProcVO mdmDatProcVO) {
		this.mdmDatProcVO = mdmDatProcVO;
	}
}