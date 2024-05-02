/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0043Event.java
*@FileTitle : Invoice Report by Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.07 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BillInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0043 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see FNS_INV_0043HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0043Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BillInputVO billInputVO = null;

	public FnsInv0043Event(){}

	/**
	 * @return the billInputVO
	 */
	public BillInputVO getBillInputVO() {
		return billInputVO;
	}

	/**
	 * @param billInputVO the billInputVO to set
	 */
	public void setBillInputVO(BillInputVO billInputVO) {
		this.billInputVO = billInputVO;
	}
	
	
	
	

}