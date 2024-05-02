/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0021Event.java
*@FileTitle : 지역별Local Charge관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvChnChgVO;


/**
 * FNS_INV_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvChnChgVO invChnChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvChnChgVO[] invChnChgVOs = null;
	
	private String ofc = null;

	public FnsInv0021Event(){}
	
	public void setInvChnChgVO(InvChnChgVO invChnChgVO){
		this. invChnChgVO = invChnChgVO;
	}

	public void setInvChnChgVOS(InvChnChgVO[] invChnChgVOs){
		this. invChnChgVOs = invChnChgVOs;
	}

	public InvChnChgVO getInvChnChgVO(){
		return invChnChgVO;
	}

	public InvChnChgVO[] getInvChnChgVOS(){
		return invChnChgVOs;
	}

	public String getOfc() {
		return ofc;
	}

	public void setOfc(String ofc) {
		this.ofc = ofc;
	}

}