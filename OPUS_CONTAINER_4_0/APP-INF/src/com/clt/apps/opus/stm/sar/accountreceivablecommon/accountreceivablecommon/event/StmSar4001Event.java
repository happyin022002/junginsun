/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar4001Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event;

import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.RevAcctMatrixInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.RevAcctMatrixInfoCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCreateAccountingSC로 실행요청<br>
 * - AccountReceivableCreateAccountingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar4001Event 참조
 * @since J2EE 1.4
 */

public class StmSar4001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO = null;
	private RevAcctMatrixInfoVO[] revAcctMatrixInfoVOs = null;
	
	public RevAcctMatrixInfoCondVO getRevAcctMatrixInfoCondVO() {
		return revAcctMatrixInfoCondVO;
	}

	public void setRevAcctMatrixInfoCondVO(RevAcctMatrixInfoCondVO revAcctMatrixInfoCondVO) {
		this.revAcctMatrixInfoCondVO = revAcctMatrixInfoCondVO;
	}
	
	public RevAcctMatrixInfoVO[] getRevAcctMatrixInfoVOs() {	
		RevAcctMatrixInfoVO[] rtnVOs = null;
		if (this.revAcctMatrixInfoVOs != null) {
			rtnVOs = new RevAcctMatrixInfoVO[revAcctMatrixInfoVOs.length];
			System.arraycopy(revAcctMatrixInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRevAcctMatrixInfoVOs(RevAcctMatrixInfoVO[] revAcctMatrixInfoVOs) {
		if (revAcctMatrixInfoVOs != null) {
			RevAcctMatrixInfoVO[] tmpVOs = new RevAcctMatrixInfoVO[revAcctMatrixInfoVOs.length];
			System.arraycopy(revAcctMatrixInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.revAcctMatrixInfoVOs = tmpVOs;
		}
	} 

}