/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeByBookingCustomerGrpVO.java
*@FileTitle : ChargeByBookingCustomerGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.23 이최성환
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect <br>
 * Booking 모듈에서 서비스  요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ChargeByBookingCustomerGrpVO {

	/* Column Info */
	private String demurType = null;
	/* Column Info */
	private List<ChargeByBookingCustomerCntrVO> chargeByBookingCustomerCntrVOS = null;
	/* Column Info */
	private List<ChargeByBookingCustomerInvVO> chargeByBookingCustomerInvVOS = null;
	
	/**
	 * Column Info
	 * @return demurType
	 */
	public String getDemurType() {
		return demurType;
	}

	/**
	 * Column Info
	 * @return this.demurType
	 */
	public void setDemurType(String demurType) {
		this.demurType = demurType;
	}

	/**
	 * Column Info
	 * @return this.chargeByBookingCustomerCntrVOS 
	 */
	public void setChargeByBookingCustomerCntrVOS(List<ChargeByBookingCustomerCntrVO> chargeByBookingCustomerCntrVOS) {
		this.chargeByBookingCustomerCntrVOS = chargeByBookingCustomerCntrVOS;
	}
	
	/**
	 * Column Info
	 * @return this.chargeByBookingCustomerInvVOS
	 */
	public void setChargeByBookingCustomerInvVOS(List<ChargeByBookingCustomerInvVO> chargeByBookingCustomerInvVOS) {
		this.chargeByBookingCustomerInvVOS = chargeByBookingCustomerInvVOS;
	}

	
	/**
	 * Column Info
	 * @return List<ChargeByBookingCustomerCntrVO>
	 */
	public List<ChargeByBookingCustomerCntrVO> getChargeByBookingCustomerCntrVOS() {
		return chargeByBookingCustomerCntrVOS;
	}
	
	/**
	 * Column Info
	 * @return List<ChargeByBookingCustomerInvVO>
	 */
	public List<ChargeByBookingCustomerInvVO> getChargeByBookingCustomerInvVOS() {
		return chargeByBookingCustomerInvVOS;
	}
	
		
}
