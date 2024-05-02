/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0340Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.UnsettledAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.UnsettledEntryCondVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CLT
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0340Event extends EventSupport {

	private static final long serialVersionUID = 1L;
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SapCommonVO sapCommonVO = null;

	/** Table Value Object Multi Data 처리 */
	private SapCommonVO[] sapCommonVOs = null;
	
	private UnsettledEntryCondVO unsettledEntryCondVO = null;
	
	public UnsettledAccountListVO unsettledAccountListVO = null;
	
	public UnsettledAccountListVO[] unsettledAccountListVOs = null;
	
	
	public UnsettledEntryCondVO getUnsettledEntryCondVO() {
		return unsettledEntryCondVO;
	}

	public void setUnsettledEntryCondVO(UnsettledEntryCondVO unsettledEntryCondVO) {
		this.unsettledEntryCondVO = unsettledEntryCondVO;
	}

	public SapCommonVO getSapCommonVO() {
		return sapCommonVO;
	}

	public void setSapCommonVO(SapCommonVO sapCommonVO) {
		this.sapCommonVO = sapCommonVO;
	}

	public SapCommonVO[] getSapCommonVOs() {
		SapCommonVO[] rtnVOs = null;
		if(this.sapCommonVOs != null) {
			rtnVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSapCommonVOs(SapCommonVO[] sapCommonVOs) {
		if(sapCommonVOs != null) {
			SapCommonVO[] tmpVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sapCommonVOs = tmpVOs;
		}
	}

	public UnsettledAccountListVO getUnsettledAccountListVO() {
		return unsettledAccountListVO;
	}

	public void setUnsettledAccountListVO(
			UnsettledAccountListVO unsettledAccountListVO) {
		this.unsettledAccountListVO = unsettledAccountListVO;
	}

	public UnsettledAccountListVO[] getUnsettledAccountListVOs() {
		UnsettledAccountListVO[] rtnVOs = null;
		if(this.unsettledAccountListVOs != null) {
			rtnVOs = new UnsettledAccountListVO[unsettledAccountListVOs.length];
			System.arraycopy(unsettledAccountListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}

	public void setUnsettledAccountListVOs(UnsettledAccountListVO[] unsettledAccountListVOs) {
		if(unsettledAccountListVOs != null) {
			UnsettledAccountListVO[] tmpVOs = new UnsettledAccountListVO[unsettledAccountListVOs.length];
			System.arraycopy(unsettledAccountListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.unsettledAccountListVOs = tmpVOs;
		}
	}
	
}