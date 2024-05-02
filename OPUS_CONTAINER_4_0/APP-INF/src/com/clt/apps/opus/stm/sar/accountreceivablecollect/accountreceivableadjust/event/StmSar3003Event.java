/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : StmSar3003Event.java
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

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutoSettlementInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutoSettlementSubInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutosettlementCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCollectSC로 실행요청<br>
 * - AccountReceivableCollectSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에
 * 셋팅<br>
 * 
 * @author
 * @see StmSar3003Event 참조
 * @since J2EE 1.4
 */

public class StmSar3003Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object */
	private AutosettlementCondVO autosettlementCondVO = null;

	/** Table Value Object Multi Data */
	private AutosettlementCondVO[] autosettlementCondVOs = null;

	/** Table Value Object */
	private AutoSettlementInfoVO autoSettlementInfoVO = null;

	/** Table Value Object Multi Data */
	private AutoSettlementInfoVO[] autoSettlementInfoVOs = null;

	/** Table Value Object */
	private AutoSettlementSubInfoVO autoSettlementSubInfoVO = null;

	/** Table Value Object Multi Data */
	private AutoSettlementSubInfoVO[] autoSettlementSubInfoVOs = null;

	public AutosettlementCondVO getAutosettlementCondVO() {
		return autosettlementCondVO;
	}

	public void setAutosettlementCondVO(AutosettlementCondVO autosettlementCondVO) {
		this.autosettlementCondVO = autosettlementCondVO;
	}

	public AutosettlementCondVO[] getAutosettlementCondVOs() {
		AutosettlementCondVO[] rtnVOs = null;
		if (this.autosettlementCondVOs != null) {
			rtnVOs = new AutosettlementCondVO[autosettlementCondVOs.length];
			System.arraycopy(autosettlementCondVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setAutosettlementCondVOs(AutosettlementCondVO[] autosettlementCondVOs) {
		if (autosettlementCondVOs != null) {
			AutosettlementCondVO[] tmpVOs = new AutosettlementCondVO[autosettlementCondVOs.length];
			System.arraycopy(autosettlementCondVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.autosettlementCondVOs = tmpVOs;
		}
	}

	public AutoSettlementInfoVO getAutoSettlementInfoVO() {
		return autoSettlementInfoVO;
	}

	public void setAutoSettlementInfoVO(AutoSettlementInfoVO autoSettlementInfoVO) {
		this.autoSettlementInfoVO = autoSettlementInfoVO;
	}

	public AutoSettlementInfoVO[] getAutoSettlementInfoVOs() {
		AutoSettlementInfoVO[] rtnVOs = null;
		if (this.autoSettlementInfoVOs != null) {
			rtnVOs = new AutoSettlementInfoVO[autoSettlementInfoVOs.length];
			System.arraycopy(autoSettlementInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setAutoSettlementInfoVOs(AutoSettlementInfoVO[] autoSettlementInfoVOs) {
		if (autoSettlementInfoVOs != null) {
			AutoSettlementInfoVO[] tmpVOs = new AutoSettlementInfoVO[autoSettlementInfoVOs.length];
			System.arraycopy(autoSettlementInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.autoSettlementInfoVOs = tmpVOs;
		}
	}

	public AutoSettlementSubInfoVO getAutoSettlementSubInfoVO() {
		return autoSettlementSubInfoVO;
	}

	public void setAutoSettlementSubInfoVO(AutoSettlementSubInfoVO autoSettlementSubInfoVO) {
		this.autoSettlementSubInfoVO = autoSettlementSubInfoVO;
	}

	public AutoSettlementSubInfoVO[] getAutoSettlementSubInfoVOs() {
		AutoSettlementSubInfoVO[] rtnVOs = null;
		if (this.autoSettlementSubInfoVOs != null) {
			rtnVOs = new AutoSettlementSubInfoVO[autoSettlementSubInfoVOs.length];
			System.arraycopy(autoSettlementSubInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setAutoSettlementSubInfoVOs(AutoSettlementSubInfoVO[] autoSettlementSubInfoVOs) {
		if (autoSettlementSubInfoVOs != null) {
			AutoSettlementSubInfoVO[] tmpVOs = new AutoSettlementSubInfoVO[autoSettlementSubInfoVOs.length];
			System.arraycopy(autoSettlementSubInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.autoSettlementSubInfoVOs = tmpVOs;
		}
	}
}