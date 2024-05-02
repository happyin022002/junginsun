/**
 * 
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo;

import java.util.List;

/**
 * @author jungjin
 * 
 */
public class NonShippingARVO {
	private static final long serialVersionUID = 1L;

	private NonShippingMainVO nonShippingMainVO = null;
	private List<NonShippingChargeVO> nonShippingChargeVOS = null;

	public NonShippingMainVO getNonShippingMainVO() {
		return nonShippingMainVO;
	}

	public void setNonShippingMainVO(NonShippingMainVO nonShippingMainVO) {
		this.nonShippingMainVO = nonShippingMainVO;
	}

	public List<NonShippingChargeVO> getNonShippingChargeVOS() {
		return nonShippingChargeVOS;
	}

	public void setNonShippingChargeVOS(List<NonShippingChargeVO> nonShippingChargeVOS) {
		this.nonShippingChargeVOS = nonShippingChargeVOS;
	}
}
