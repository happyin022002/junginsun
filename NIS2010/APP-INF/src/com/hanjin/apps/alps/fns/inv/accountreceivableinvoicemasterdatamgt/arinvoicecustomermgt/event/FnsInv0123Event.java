/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0122HTMLAction.java
*@FileTitle : SVAT Reg. NO for CMBBB
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : 권 민
*@LastVersion : 1.0
* 2011.10.11 권 민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchSVATNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvArSpndVatRgstNoVO;

/**
 * FNS_INV_0123 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0123HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author	Kwon Min
 * @see		FNS_INV_0123HTMLAction 참조
 * @since	J2EE 1.4
 */
 
public class FnsInv0123Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSVATNoVO searchSVATNoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSVATNoVO[] searchSVATNoVOs = null;

	private InvArSpndVatRgstNoVO invArSpndVatRgstNoVO = null;
	
	private InvArSpndVatRgstNoVO[] invArSpndVatRgstNoVOs = null;
	
	public FnsInv0123Event(){}


	public SearchSVATNoVO getSearchSVATNoVO() {
		return searchSVATNoVO;
	}


	public void setSearchSVATNoVO(SearchSVATNoVO searchSVATNoVO) {
		this.searchSVATNoVO = searchSVATNoVO;
	}


	public SearchSVATNoVO[] getSearchSVATNoVOs() {
		return searchSVATNoVOs;
	}


	public void setSearchSVATNoVOs(SearchSVATNoVO[] searchSVATNoVOs) {
		this.searchSVATNoVOs = searchSVATNoVOs;
	}


	public InvArSpndVatRgstNoVO getInvArSpndVatRgstNoVO() {
		return invArSpndVatRgstNoVO;
	}


	public void setInvArSpndVatRgstNoVO(InvArSpndVatRgstNoVO invArSpndVatRgstNoVO) {
		this.invArSpndVatRgstNoVO = invArSpndVatRgstNoVO;
	}


	public InvArSpndVatRgstNoVO[] getInvArSpndVatRgstNoVOs() {
		return invArSpndVatRgstNoVOs;
	}


	public void setInvArSpndVatRgstNoVOs(
			InvArSpndVatRgstNoVO[] invArSpndVatRgstNoVOs) {
		this.invArSpndVatRgstNoVOs = invArSpndVatRgstNoVOs;
	}

}