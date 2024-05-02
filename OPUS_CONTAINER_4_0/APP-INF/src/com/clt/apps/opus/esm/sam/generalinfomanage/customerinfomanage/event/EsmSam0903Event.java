/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0903Event.java
*@FileTitle : Customer Performance Group Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.09
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 2012.02.09 SHKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustomerGroupCodeVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SAM_0903 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0903HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHKIM
 * @see ESM_SAM_0903HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0903Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerGroupCodeVO customerGroupCodeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerGroupCodeVO[] customerGroupCodeVOs = null;

	public EsmSam0903Event(){}
	
	public void setCustomerGroupCodeVO(CustomerGroupCodeVO customerGroupCodeVO){
		this. customerGroupCodeVO = customerGroupCodeVO;
	}

	public void setCustomerGroupCodeVOS(CustomerGroupCodeVO[] CustomerGroupCodeVOs){
		if(CustomerGroupCodeVOs != null){
			CustomerGroupCodeVO[] tmpVOs = Arrays.copyOf(CustomerGroupCodeVOs, CustomerGroupCodeVOs.length);
			this.customerGroupCodeVOs = tmpVOs;
		}
	}

	public CustomerGroupCodeVO getCustomerGroupCodeVO(){
		return customerGroupCodeVO;
	}

	public CustomerGroupCodeVO[] getCustomerGroupCodeVOS(){
		CustomerGroupCodeVO[] rtnVOs = null;
		if (this.customerGroupCodeVOs != null) {
			rtnVOs = Arrays.copyOf(customerGroupCodeVOs, customerGroupCodeVOs.length);
		}
		return rtnVOs;

	}
}