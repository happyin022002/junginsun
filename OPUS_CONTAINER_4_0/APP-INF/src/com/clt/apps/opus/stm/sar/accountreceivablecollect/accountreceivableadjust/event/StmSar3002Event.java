/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar3002Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCollectSC로 실행요청<br>
 * - AccountReceivableCollectSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar3002Event 참조
 * @since J2EE 1.4
 */

public class StmSar3002Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	
	private OffsetInfoVO offsetInfoCondVO;
	
	private OffsetInfoVO[] offsetInfoVOs;
	
	public OffsetInfoVO[] getOffsetInfoVOs() {
		OffsetInfoVO[] rtnVOs = null;
		if (this.offsetInfoVOs != null) {
			rtnVOs = new OffsetInfoVO[offsetInfoVOs.length];
			System.arraycopy(offsetInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setOffsetInfoVOs(OffsetInfoVO[] offsetInfoVOs) {
		if (offsetInfoVOs != null) {
			OffsetInfoVO[] tmpVOs = new OffsetInfoVO[offsetInfoVOs.length];
			System.arraycopy(offsetInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.offsetInfoVOs = tmpVOs;
		}
	}


	public OffsetInfoVO getOffsetInfoCondVO() {
		return offsetInfoCondVO;
	}


	public void setOffsetInfoCondVO(OffsetInfoVO offsetInfoCondVO) {
		this.offsetInfoCondVO = offsetInfoCondVO;
	}
	

}