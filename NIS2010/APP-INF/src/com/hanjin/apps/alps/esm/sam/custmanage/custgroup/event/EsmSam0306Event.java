/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : EsmSam0306Event.java
*@FileTitle : customer performance group
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custgroup.event;

import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.vo.CustomerGroupCodeVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerContactVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerPerformanceVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 

/**
 * ESM_SAM_0306 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0306HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  
 * @see ESM_SAM_0306HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0306Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerPerformanceVO customerPerformanceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerPerformanceVO[] customerPerformanceVOs = null;
	
	private String ofcCd = null;
	
	private String srepCd = null;
	
	private String custGrpId = null;

	private CustomerGroupCodeVO customerGroupCodeVO;

	private CustomerGroupCodeVO[] customerGroupCodeVOs;

	public EsmSam0306Event(){}
	
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
	
	public void setCustomerGroupCodeVO(CustomerGroupCodeVO customerGroupCodeVO){
		this. customerGroupCodeVO = customerGroupCodeVO;
	}

	public void setCustomerGroupCodeVOS(CustomerGroupCodeVO[] customerGroupCodeVOs){
		if(customerGroupCodeVOs != null){
			CustomerGroupCodeVO[] tmpVOs = java.util.Arrays.copyOf(customerGroupCodeVOs, customerGroupCodeVOs.length);
			this.customerGroupCodeVOs = tmpVOs;
		}
	}

	public CustomerGroupCodeVO getCustomerGroupCodeVO(){
		return customerGroupCodeVO;
	}

	public CustomerGroupCodeVO[] getCustomerGroupCodeVOS(){
		CustomerGroupCodeVO[] rtnVOs = null;
		if (this.customerGroupCodeVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customerGroupCodeVOs, customerGroupCodeVOs.length);
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
	
}