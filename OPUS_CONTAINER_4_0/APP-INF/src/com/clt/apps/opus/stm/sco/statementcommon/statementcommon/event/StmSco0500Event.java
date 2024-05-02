/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSco0500.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
//package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event;
//package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event;
//import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankConditionVO;

package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;
//import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.SakuraInterfaceCondVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.SakuraInterfaceCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
//import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankConditionVO;
//import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptUserListConditionVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCommonSC로 실행요청<br>
 * - AccountReceivableCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSco0500Event 참조
 * @since J2EE 1.4
 */

public class StmSco0500Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private SakuraInterfaceCondVO sakuraInterfaceCondVO = null;
	
	public SakuraInterfaceCondVO getSakuraInterfaceCondVO() {
		return sakuraInterfaceCondVO;
	}
	public void setSakuraInterfaceCondVO(SakuraInterfaceCondVO sakuraInterfaceCondVO) {
		this.sakuraInterfaceCondVO = sakuraInterfaceCondVO;
	}
}