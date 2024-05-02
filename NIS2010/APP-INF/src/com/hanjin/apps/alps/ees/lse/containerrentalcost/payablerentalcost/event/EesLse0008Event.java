/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0008Event.java
*@FileTitle : Invoice File Import
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.10 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_lse_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_lse_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see ees_lse_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0008Event extends EventSupport {

	public EesLse0008Event(){}

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PayableRentalCostVO payableRentalCostVO = null;
	
	public void setPayableRentalCostVO(PayableRentalCostVO payableRentalCostVO) {
		this.payableRentalCostVO = payableRentalCostVO;
	}

	public PayableRentalCostVO getPayableRentalCostVO() {
		return payableRentalCostVO;
	}
}