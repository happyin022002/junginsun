/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0035Event.java
*@FileTitle : Invoice Re-Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.30 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.InvArIssVO;


/**
 * FNS_INV_0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0035HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String pageType = null;	
	
	private String ofcCd = null;
	
	private PrintInvoiceVO prtInvoiceVo = null;
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvIssMainVO issMain = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArIssVO[] invArIssVOs = null;

	public FnsInv0035Event(){}	
	
	public String getPageType() {
		return pageType;
	}
	
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public PrintInvoiceVO getPrtInvoiceVo() {
		return prtInvoiceVo;
	}

	public void setPrtInvoiceVo(PrintInvoiceVO prtInvoiceVo) {
		this.prtInvoiceVo = prtInvoiceVo;
	}

	public void setInvArIssVOS(InvArIssVO[] invArIssVOs){
		if(invArIssVOs != null){
			InvArIssVO[] tmpVOs = new InvArIssVO[invArIssVOs.length];
			System.arraycopy(invArIssVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invArIssVOs = tmpVOs;
		}
	}

	public InvArIssVO[] getInvArIssVOS(){
		InvArIssVO[] rtnVOs = null;
		if (this.invArIssVOs != null) {
			rtnVOs = new InvArIssVO[invArIssVOs.length];
			System.arraycopy(invArIssVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @return the issMain
	 */
	public InvIssMainVO getIssMain() {
		return issMain;
	}

	/**
	 * @param issMain the issMain to set
	 */
	public void setIssMain(InvIssMainVO issMain) {
		this.issMain = issMain;
	}
	

}