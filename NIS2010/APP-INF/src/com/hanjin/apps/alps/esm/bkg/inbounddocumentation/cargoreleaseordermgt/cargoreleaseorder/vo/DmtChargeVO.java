/**
 * 
 */
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

/**
 * @author User
 *
 */
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerCntrVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerInvVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect <br>
 * DEM/DET 정보 담는 VO
 *
 * @author 박성호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class DmtChargeVO {

	/* Column Info */
	private String demurType = null;
	/* Column Info */
	private List<ChargeByBookingCustomerCntrVO> chargeByBookingCustomerCntrVOS = null;
	/* Column Info */
	private List<ChargeByBookingCustomerInvVO> chargeByBookingCustomerInvVOS = null;
	/* Column Info */
	private List<ToTBilAmtVO> bilAmtVOList = null;
	
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

	public List<ToTBilAmtVO> getBilAmtVOList() {
		return bilAmtVOList;
	}

	public void setBilAmtVOList(List<ToTBilAmtVO> bilAmtVOList) {
		this.bilAmtVOList = bilAmtVOList;
	}
	
		
}