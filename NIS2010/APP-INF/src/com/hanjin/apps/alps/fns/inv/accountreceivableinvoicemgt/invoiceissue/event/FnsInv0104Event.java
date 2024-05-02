/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0104Event.java
*@FileTitle : CPR Download History Inquiry - Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRIDListInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTListVO;


/**
 * FNS_INV_0104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0104HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CPRTListVO cPRTListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CPRTListVO[] cPRTListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CPRIDListInputVO cPRIDListInputVO = null;
	
	public FnsInv0104Event(){}
	
	public void setCPRTListVO(CPRTListVO cPRTListVO){
		this. cPRTListVO = cPRTListVO;
	}

	public void setCPRTListVOS(CPRTListVO[] cPRTListVOs){
		this. cPRTListVOs = cPRTListVOs;
	}

	public CPRTListVO getCPRTListVO(){
		return cPRTListVO;
	}

	public CPRTListVO[] getCPRTListVOS(){
		return cPRTListVOs;
	}

	public CPRIDListInputVO getCPRIDListInputVO() {
		return cPRIDListInputVO;
	}

	public void setCPRIDListInputVO(CPRIDListInputVO listInputVO) {
		cPRIDListInputVO = listInputVO;
	}

}