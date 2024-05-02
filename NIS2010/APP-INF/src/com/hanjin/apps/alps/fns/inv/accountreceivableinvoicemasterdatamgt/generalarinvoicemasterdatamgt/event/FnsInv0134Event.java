/**
 * Copyright(c) 2013 CyberLogitec
 * @FileName : FnsInv0134Event.java
 * @FileTitle : Surcharge Description on Invoice
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2013.05.14
 * @LastModifier : 김준호
 * @LastVersion : 1.0
 * 1.0 Creation 2013.05.14.
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvChgDescConvVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * Surcharge Description 에 대한 parameter value object.
 * 
 * @author 김준호
 * @see 각 DAO Class 참조.
 * @since J2EE 1.4
 */
public class FnsInv0134Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
//	private InvChgDescConvVO invChgDescConvVO[] = null;
	
	private String arHdQtrOfcCd = null;
	private String arOfcCd = null;
	private String chgCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvChgDescConvVO invChgDescConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvChgDescConvVO[] invChgDescConvVOs = null;
	
	
	public String getArHdQtrOfcCd() {
		return arHdQtrOfcCd;
	}

	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}

	public String getArOfcCd() {
		return arOfcCd;
	}

	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	public String getChgCd() {
		return chgCd;
	}

	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	
	public InvChgDescConvVO getInvChgDescConvVO(){
		return invChgDescConvVO;
	}

	public void setInvChgDescConvVO(InvChgDescConvVO invChgDescConvVO){
		this. invChgDescConvVO = invChgDescConvVO;
	}

	public InvChgDescConvVO[] getInvChgDescConvVOs(){
		return invChgDescConvVOs;
	}
	
	public void setInvChgDescConvVOs(InvChgDescConvVO[] invChgDescConvVOs){
		this. invChgDescConvVOs = invChgDescConvVOs;
	}
}
