/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0087Event.java
*@FileTitle : Invoice Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.05 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.InvArIssVO;


/**
 * FNS_INV_0087 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0087HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0087HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0087Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArIssVO invArIssVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArIssVO[] invArIssVOs = null;

	public FnsInv0087Event(){}
	
	public void setInvArIssVO(InvArIssVO invArIssVO){
		this. invArIssVO = invArIssVO;
	}

	public void setInvArIssVOS(InvArIssVO[] invArIssVOs){
		if(invArIssVOs != null){
			InvArIssVO[] tmpVOs = new InvArIssVO[invArIssVOs.length];
			System.arraycopy(invArIssVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invArIssVOs = tmpVOs;
		}
	}

	public InvArIssVO getInvArIssVO(){
		return invArIssVO;
	}

	public InvArIssVO[] getInvArIssVOS(){
		InvArIssVO[] rtnVOs = null;
		if (this.invArIssVOs != null) {
			rtnVOs = new InvArIssVO[invArIssVOs.length];
			System.arraycopy(invArIssVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}