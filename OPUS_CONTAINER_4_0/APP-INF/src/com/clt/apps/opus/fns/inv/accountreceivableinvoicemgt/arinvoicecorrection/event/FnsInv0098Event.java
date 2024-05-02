/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0098Event.java
*@FileTitle : Container No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0098 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0098HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0098HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0098Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String cntrNo = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceByBLNoVO aRInvoiceByBLNoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceByBLNoVO[] aRInvoiceByBLNoVOs = null;

	public FnsInv0098Event(){}
		
	/**
	 * @return the cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}

	/**
	 * @param cntrNo the cntrNo to set
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public void setARInvoiceByBLNoVO(ARInvoiceByBLNoVO aRInvoiceByBLNoVO){
		this. aRInvoiceByBLNoVO = aRInvoiceByBLNoVO;
	}

	public void setARInvoiceByBLNoVOS(ARInvoiceByBLNoVO[] aRInvoiceByBLNoVOs){
		if(aRInvoiceByBLNoVOs != null){
			ARInvoiceByBLNoVO[] tmpVOs = new ARInvoiceByBLNoVO[aRInvoiceByBLNoVOs.length];
			System.arraycopy(aRInvoiceByBLNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInvoiceByBLNoVOs = tmpVOs;
		}
	}

	public ARInvoiceByBLNoVO getARInvoiceByBLNoVO(){
		return aRInvoiceByBLNoVO;
	}

	public ARInvoiceByBLNoVO[] getARInvoiceByBLNoVOS(){
		ARInvoiceByBLNoVO[] rtnVOs = null;
		if (this.aRInvoiceByBLNoVOs != null) {
			rtnVOs = new ARInvoiceByBLNoVO[aRInvoiceByBLNoVOs.length];
			System.arraycopy(aRInvoiceByBLNoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}