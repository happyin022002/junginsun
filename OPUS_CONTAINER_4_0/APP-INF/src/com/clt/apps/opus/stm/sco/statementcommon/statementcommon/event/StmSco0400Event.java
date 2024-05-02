/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : StmSap0120Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event;

import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.TesManualCancellationVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아
 * AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는
 * EventResponse를 request에 셋팅<br>
 * 
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSco0400Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String exeYrmon = "";
	private String cancelFlg = "";
	private String vvd = "";
	private String ydCd = "";

	private TesManualCancellationVO[] tesManualCancellationVOs = null;

	public String getExeYrmon() {
		return exeYrmon;
	}

	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}

	public String getCancelFlg() {
		return cancelFlg;
	}

	public void setCancelFlg(String cancelFlg) {
		this.cancelFlg = cancelFlg;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getYdCd() {
		return ydCd;
	}

	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}

	public TesManualCancellationVO[] getTesManualCancellationVOs() {
		TesManualCancellationVO[] rtnVOs = null;
		if (this.tesManualCancellationVOs != null) {
			rtnVOs = new TesManualCancellationVO[tesManualCancellationVOs.length];
			System.arraycopy(tesManualCancellationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setTesManualCancellationVOs(
			TesManualCancellationVO[] tesManualCancellationVOs) {
		if (tesManualCancellationVOs != null) {
			TesManualCancellationVO[] tmpVOs = new TesManualCancellationVO[tesManualCancellationVOs.length];
			System.arraycopy(tesManualCancellationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tesManualCancellationVOs = tmpVOs;
		}
	}

}