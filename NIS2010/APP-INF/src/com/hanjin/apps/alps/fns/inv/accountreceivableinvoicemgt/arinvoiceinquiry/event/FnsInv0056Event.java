/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0056Event.java
*@FileTitle : Invoice Not Issued Aging Inquiry by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.27 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedAgingInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedAgingVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0056HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0056Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private NotIssuedAgingInputVO notIssAgingVo = null;
	
	/** Table Value Object Multi Data 처리 */
	private NotIssuedAgingVO[] notIssuedAgingVOs = null;

	public FnsInv0056Event(){}

	public void setNotIssuedAgingVOS(NotIssuedAgingVO[] notIssuedAgingVOs){
		this. notIssuedAgingVOs = notIssuedAgingVOs;
	}

	public NotIssuedAgingVO[] getNotIssuedAgingVOS(){
		return notIssuedAgingVOs;
	}

	public NotIssuedAgingInputVO getNotIssAgingVo() {
		return notIssAgingVo;
	}

	public void setNotIssAgingVo(NotIssuedAgingInputVO notIssAgingVo) {
		this.notIssAgingVo = notIssAgingVo;
	}

}