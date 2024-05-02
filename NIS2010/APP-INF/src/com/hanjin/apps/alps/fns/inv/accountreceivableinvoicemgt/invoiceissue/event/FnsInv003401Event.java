/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv003401Event.java
*@FileTitle : AccountReceivableInvoiceMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.17 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvArStupOfcVO;


/**
 * FNS_INV_0034_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0034_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0034_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv003401Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String pageType = null;	
	
	private String ofcCd = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArStupOfcVO invArStupOfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArStupOfcVO[] invArStupOfcVOs = null;
	
	private GeneralInvoiceVO genInvVo = null;
	
	/* BackEndJob Key */
	private String backEndJobKey = "";

	public FnsInv003401Event(){}
	
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

	public GeneralInvoiceVO getGenInvVo() {
		return genInvVo;
	}

	public void setGenInvVo(GeneralInvoiceVO genInvVo) {
		this.genInvVo = genInvVo;
	}

	/**
	 * @return the backEndJobKey
	 */
	public String getBackEndJobKey() {
		return backEndJobKey;
	}

	/**
	 * @param backEndJobKey the backEndJobKey to set
	 */
	public void setBackEndJobKey(String backEndJobKey) {
		this.backEndJobKey = backEndJobKey;
	}

}