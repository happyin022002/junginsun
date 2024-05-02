/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0119Event.java
*@FileTitle : VAT Ratio Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.31
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.11 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArEuCntVatVO;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0119 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0119HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see FNS_INV_0119HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0119Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 */
	private InvArEuCntVatVO[] invArEuCntVatVOs = null;
	

	public FnsInv0119Event(){}


	/**
	 * @return the invArEuCntVatVOs
	 */
	public InvArEuCntVatVO[] getInvArEuCntVatVOs() {
		return invArEuCntVatVOs;
	}


	/**
	 * @param invArEuCntVatVOs the invArEuCntVatVOs to set
	 */
	public void setInvArEuCntVatVOs(InvArEuCntVatVO[] invArEuCntVatVOs) {
		this.invArEuCntVatVOs = invArEuCntVatVOs;
	}

	
}