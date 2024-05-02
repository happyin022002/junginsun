/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0073Event.java
*@FileTitle : A/R Office Code Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.09 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArStupOfcVO;


/**
 * FNS_INV_0073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0073HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0073HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0073Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String arOfcCd = null;
	
	private String procGB = null;
	
	private String chgCd = null;
	
	private String pageType = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArStupOfcVO invArStupOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArStupOfcVO[] invArStupOfcVOs = null;

	public FnsInv0073Event(){}
	
	public void setInvArStupOfcVO(InvArStupOfcVO invArStupOfcVO){
		this. invArStupOfcVO = invArStupOfcVO;
	}

	public void setInvArStupOfcVOS(InvArStupOfcVO[] invArStupOfcVOs){
		this. invArStupOfcVOs = invArStupOfcVOs;
	}

	public InvArStupOfcVO getInvArStupOfcVO(){
		return invArStupOfcVO;
	}

	public InvArStupOfcVO[] getInvArStupOfcVOS(){
		return invArStupOfcVOs;
	}

	public String getArOfcCd() {
		return arOfcCd;
	}

	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	public String getProcGB() {
		return procGB;
	}

	public void setProcGB(String procGB) {
		this.procGB = procGB;
	}

	public String getChgCd() {
		return chgCd;
	}

	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}



}