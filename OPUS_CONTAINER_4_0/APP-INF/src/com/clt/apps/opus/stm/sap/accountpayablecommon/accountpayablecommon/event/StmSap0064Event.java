/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0064Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.30
*@LastModifier : sangyoung cha
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopPayInvoiceInfomationListVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CLT
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0064Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private PopPayInvoiceInfomationListVO popPayInvoiceInfomationListVO;
	private PopPayInvoiceInfomationListVO[] popPayInvoiceInfomationListVOs;
	
	
	public PopPayInvoiceInfomationListVO getPopPayInvoiceInfomationListVO() {
		return popPayInvoiceInfomationListVO;
	}
	public void setPopPayInvoiceInfomationListVO(
			PopPayInvoiceInfomationListVO popPayInvoiceInfomationListVO) {
		this.popPayInvoiceInfomationListVO = popPayInvoiceInfomationListVO;
	}
	public PopPayInvoiceInfomationListVO[] getPopPayInvoiceInfomationListVOs() {
		PopPayInvoiceInfomationListVO[] rtnVOs = null;
		if(this.popPayInvoiceInfomationListVOs != null) {
			rtnVOs = new PopPayInvoiceInfomationListVO[popPayInvoiceInfomationListVOs.length];
			System.arraycopy(popPayInvoiceInfomationListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setPopPayInvoiceInfomationListVOs( PopPayInvoiceInfomationListVO[] popPayInvoiceInfomationListVOs) {
		if(popPayInvoiceInfomationListVOs != null) {
			PopPayInvoiceInfomationListVO[] tmpVOs = new PopPayInvoiceInfomationListVO[popPayInvoiceInfomationListVOs.length];
			System.arraycopy(popPayInvoiceInfomationListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.popPayInvoiceInfomationListVOs = tmpVOs;
		}

	}
}