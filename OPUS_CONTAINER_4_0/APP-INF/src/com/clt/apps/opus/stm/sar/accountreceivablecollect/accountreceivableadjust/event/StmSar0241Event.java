/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar0241Event.java
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

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetARPopupListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AROfficeListVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCollectSC로 실행요청<br>
 * - AccountReceivableCollectSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar0241Event 참조
 * @since J2EE 1.4
 */

public class StmSar0241Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	private OffsetARPopupListVO offsetARPopupListVO;

	private AROfficeListVO arOfficeListVO;

	
	
	public AROfficeListVO getArOfficeListVO() {
		return arOfficeListVO;
	}


	public void setArOfficeListVO(AROfficeListVO arOfficeListVO) {
		this.arOfficeListVO = arOfficeListVO;
	}


	public OffsetARPopupListVO getOffsetARPopupListVO() {
		return offsetARPopupListVO;
	}


	public void setOffsetARPopupListVO(OffsetARPopupListVO offsetARPopupListVO) {
		this.offsetARPopupListVO = offsetARPopupListVO;
	}
	

}