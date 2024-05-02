/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2032Event.java
 *@FileTitle : RFA Proposal Inquiry - Rate (Commodity)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.21 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpScpRtCmdtVO;

/**
 * UI_PRI_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_2003_07HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2032Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtVO[] priRpScpRtCmdtVOS = null;

	public EsmPri2032Event() {
	}

	/**
	 * @return the priRpScpRtCmdtVOS
	 */
	public PriRpScpRtCmdtVO[] getPriRpScpRtCmdtVOS() {
		PriRpScpRtCmdtVO[] tmpVOs = null;
		if (this.priRpScpRtCmdtVOS != null) {
			tmpVOs = new PriRpScpRtCmdtVO[priRpScpRtCmdtVOS.length];
			System.arraycopy(priRpScpRtCmdtVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRpScpRtCmdtVOS the priRpScpRtCmdtVOS to set
	 */
	public void setPriRpScpRtCmdtVOS(PriRpScpRtCmdtVO[] priRpScpRtCmdtVOS) {
		if (priRpScpRtCmdtVOS != null) {
			PriRpScpRtCmdtVO[] tmpVOs = new PriRpScpRtCmdtVO[priRpScpRtCmdtVOS.length];
			System.arraycopy(priRpScpRtCmdtVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCmdtVOS = tmpVOs;
		}
	}

}