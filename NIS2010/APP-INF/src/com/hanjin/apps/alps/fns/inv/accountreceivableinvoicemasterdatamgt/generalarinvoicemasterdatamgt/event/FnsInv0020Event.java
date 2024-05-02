/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiInv0020Event.java
*@FileTitle : (Spain)Local Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.25 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArLoclChgVO;


/**
 * UI_INV-0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_INV-0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see UI_INV-0020HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0020Event extends EventSupport {
	
	
	
	private static final long serialVersionUID = 1L;
	
	private String ofc = null;
	private String locCd = null;
	private String acctCd = null;
	private String pageType = null;	
	
	
	
	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getOfc() {
		return ofc;
	}

	public void setOfc(String ofc) {
		this.ofc = ofc;
	}

	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public String getAcctCd() {
		return acctCd;
	}

	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArLoclChgVO invArLoclChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArLoclChgVO[] invArLoclChgVOs = null;

	public FnsInv0020Event(){}
	
	public void setInvArLoclChgVO(InvArLoclChgVO invArLoclChgVO){
		this. invArLoclChgVO = invArLoclChgVO;
	}

	public void setInvArLoclChgVOS(InvArLoclChgVO[] invArLoclChgVOs){
		this. invArLoclChgVOs = invArLoclChgVOs;
	}

	public InvArLoclChgVO getInvArLoclChgVO(){
		return invArLoclChgVO;
	}

	public InvArLoclChgVO[] getInvArLoclChgVOS(){
		return invArLoclChgVOs;
	}
	
	private MdmCurrencyVO mdmCurrencyVO = null;

	public MdmCurrencyVO getMdmCurrencyVO() {
		return mdmCurrencyVO;
	}

	public void setMdmCurrencyVO(MdmCurrencyVO mdmCurrencyVO) {
		this.mdmCurrencyVO = mdmCurrencyVO;
	}

}