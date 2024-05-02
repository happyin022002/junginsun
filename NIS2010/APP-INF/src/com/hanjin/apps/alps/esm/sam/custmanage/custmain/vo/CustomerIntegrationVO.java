/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerIntegrationVO.java
*@FileTitle : CustomerIntegrationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : K.S.W.
*@LastVersion : 1.0
* 2015.01.20
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo;

import java.io.Serializable;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomerIntegrationVO implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private CustomerVO customerVO = null;
	
	private CustomerContactVO customerContactVO = null;
	
	private CustomerContactVO[] customerContactVOs = null;
	
	private List<CustomerContactVO> customerContactVOS = null;
	
	private CustomerAddressVO customerAddressVO = null;
	
	private CustomerAddressVO[] customerAddressVOs = null;
	
	private List<CustomerAddressVO> CustomerAddressVOS = null;
	
	
	public List<CustomerContactVO> getCustomerContactVOS() {
		return customerContactVOS;
	}

	public void setCustomerContactVOS(List<CustomerContactVO> customerContactVOS) {
		this.customerContactVOS = customerContactVOS;
	}

	public List<CustomerAddressVO> getCustomerAddressVOS() {
		return CustomerAddressVOS;
	}

	public void setCustomerAddressVOS(
			List<CustomerAddressVO> customerAddressVOS) {
		CustomerAddressVOS = customerAddressVOS;
	}

	public CustomerVO getCustomerVO() {
		return customerVO;
	}

	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}

	public CustomerContactVO getCustomerContactVO() {
		return customerContactVO;
	}

	public void setCustomerContactVO(CustomerContactVO customerContactVO) {
		this.customerContactVO = customerContactVO;
	}

	/**
	 * return Array of Customer Contact <br> If Array of Customer Contact is NULL then return Array type of Customer Contact List
	 * @return
	 */
	public CustomerContactVO[] getCustomerContactVOs() {
		if(customerContactVOs != null) {
			return customerContactVOs;
		}else if(customerContactVOS != null && customerContactVOS.size() > 0) {
			return customerContactVOS.toArray(new CustomerContactVO[customerContactVOS.size()]);
		}else{
			return null;
		}
	}

	public void setCustomerContactVOs(CustomerContactVO[] customerContactVOs) {
		this.customerContactVOs = customerContactVOs;
	}

	public CustomerAddressVO getCustomerAddressVO() {
		return customerAddressVO;
	}

	public void setCustomerAddressVO(
			CustomerAddressVO customerClassificationVO) {
		this.customerAddressVO = customerClassificationVO;
	}

	/**
	 * return Array of Customer Address <br> If Array of Customer Address is NULL then return Array type of Customer Address List
	 * @return
	 */
	public CustomerAddressVO[] getCustomerAddressVOs() {
		if(customerAddressVOs != null) {
			return customerAddressVOs;
		}else if(CustomerAddressVOS != null && CustomerAddressVOS.size() > 0) {
			return CustomerAddressVOS.toArray(new CustomerAddressVO[CustomerAddressVOS.size()]);
		}else{
			return null;
		}
	}

	public void setCustomerAddressVOs(
			CustomerAddressVO[] customerAddressVOs) {
		this.customerAddressVOs = customerAddressVOs;
	}
	
}