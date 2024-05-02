/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0086Event.java
*@FileTitle : Quick Customer Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.28 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PopCustomerListVO;


/**
 * FNS_INV_0086 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0086HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0086HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0086Event extends EventSupport {
	
	private String cntry = null;
	private String custSeq = null;
	private String custNm = null;
	private String zipNo = null;
	private String chkNm = null;
	private String custRgstNo = null;
	
	public String getCustSeq() {
		return custSeq;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}		

	public String getCntry() {
		return cntry;
	}

	public void setCntry(String cntry) {
		this.cntry = cntry;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	public String getZipNo() {
		return zipNo;
	}

	public void setZipNo(String zipNo) {
		this.zipNo = zipNo;
	}

	public String getChkNm() {
		return chkNm;
	}

	public void setChkNm(String chkNm) {
		this.chkNm = chkNm;
	}

	public String getCustRgstNo() {
		return custRgstNo;
	}

	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PopCustomerListVO popCustomerListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PopCustomerListVO[] popCustomerListVOs = null;

	public FnsInv0086Event(){}
	
	public void setPopCustomerListVO(PopCustomerListVO popCustomerListVO){
		this. popCustomerListVO = popCustomerListVO;
	}

	public void setPopCustomerListVOS(PopCustomerListVO[] popCustomerListVOs){
		this. popCustomerListVOs = popCustomerListVOs;
	}

	public PopCustomerListVO getPopCustomerListVO(){
		return popCustomerListVO;
	}

	public PopCustomerListVO[] getPopCustomerListVOS(){
		return popCustomerListVOs;
	}

}