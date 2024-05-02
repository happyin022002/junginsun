/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0070Event.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.08
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.06.08 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpRtActCustVO;

/**
 * UI_PRI_0070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0070HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0070Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtActCustVO[] priSpScpRtActCustVOS = null;

	public EsmPri0070Event() {
	}

	public PriSpScpRtActCustVO[] getPriSpScpRtActCustVOS() {
		PriSpScpRtActCustVO[] tmpVOs = null;
		if (this.priSpScpRtActCustVOS != null) {
			tmpVOs = new PriSpScpRtActCustVO[priSpScpRtActCustVOS.length];
			System.arraycopy(priSpScpRtActCustVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSpScpRtActCustVOS(PriSpScpRtActCustVO[] priSpScpRtActCustVOS) {
		if (priSpScpRtActCustVOS != null) {
			PriSpScpRtActCustVO[] tmpVOs = new PriSpScpRtActCustVO[priSpScpRtActCustVOS.length];
			System.arraycopy(priSpScpRtActCustVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpRtActCustVOS = tmpVOs;
		}
	}
}