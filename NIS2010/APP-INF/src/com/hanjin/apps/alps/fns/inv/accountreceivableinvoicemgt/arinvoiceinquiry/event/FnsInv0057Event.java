/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0057Event.java
*@FileTitle : Invoice Not Issued Inquiry by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.23 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotissuedInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0057HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private NotissuedInputVO notissuedInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private NotIssuedListVO[] notIssuedListVOs = null;

	public FnsInv0057Event(){}
	

	public void setNotIssuedListVOS(NotIssuedListVO[] notIssuedListVOs){
		this. notIssuedListVOs = notIssuedListVOs;
	}

	public NotIssuedListVO[] getNotIssuedListVOS(){
		return notIssuedListVOs;
	}


	public NotissuedInputVO getNotissuedInputVO() {
		return notissuedInputVO;
	}


	public void setNotissuedInputVO(NotissuedInputVO notissuedInputVO) {
		this.notissuedInputVO = notissuedInputVO;
	}

}