/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0007Event.java
*@FileTitle : Container Rental Charge Creation Audit & Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.30 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event;

import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ees_lse_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_lse_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see ees_lse_0007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0007PopEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PayableRentalCostVO payableRentalCostVO = null;

	public EesLse0007PopEvent(){}

	public void setPayableRentalCostVO(PayableRentalCostVO payableRentalCostVO) {
		this.payableRentalCostVO = payableRentalCostVO;
	}

	public PayableRentalCostVO getPayableRentalCostVO() {
		return payableRentalCostVO;
	}
}