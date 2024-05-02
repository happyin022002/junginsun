/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0074Event.java
*@FileTitle : (Korea)Security Entry 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.23 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvArScrVO;


/**
 * FNS_INV_0074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0074HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see FNS_INV_0074HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0074Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArScrVO invArScrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArScrVO[] invArScrVOs = null;
	
	private String custCntCd = "";
	
	private String custSeq = "";

	public FnsInv0074Event(){}

	/**
	 * @return the invArScrVO
	 */
	public InvArScrVO getInvArScrVO() {
		return invArScrVO;
	}

	/**
	 * @param invArScrVO the invArScrVO to set
	 */
	public void setInvArScrVO(InvArScrVO invArScrVO) {
		this.invArScrVO = invArScrVO;
	}

	/**
	 * @return the invArScrVOs
	 */
	public InvArScrVO[] getInvArScrVOs() {
		return invArScrVOs;
	}

	/**
	 * @param invArScrVOs the invArScrVOs to set
	 */
	public void setInvArScrVOs(InvArScrVO[] invArScrVOs) {
		this.invArScrVOs = invArScrVOs;
	}

	/**
	 * @return the custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	
	

}