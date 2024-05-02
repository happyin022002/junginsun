/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2090Event.java
 *@FileTitle : Amendment History - Rate (Actual Customer)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.21 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event.ESM_PRI_0070HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpScpRtActCustVO;

/**
 * UI_PRI_0070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0070HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2090Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtActCustVO[] priRpScpRtActCustVOS = null;

	public EsmPri2090Event() {
	}

	/**
	 * @return the priRpScpRtActCustVOS
	 */
	public PriRpScpRtActCustVO[] getPriRpScpRtActCustVOS() {
		PriRpScpRtActCustVO[] tmpVOs = null;
		if (this.priRpScpRtActCustVOS != null) {
			tmpVOs = new PriRpScpRtActCustVO[priRpScpRtActCustVOS.length];
			System.arraycopy(priRpScpRtActCustVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRpScpRtActCustVOS the priRpScpRtActCustVOS to set
	 */
	public void setPriRpScpRtActCustVOS(PriRpScpRtActCustVO[] priRpScpRtActCustVOS) {
		if (priRpScpRtActCustVOS != null) {
			PriRpScpRtActCustVO[] tmpVOs = new PriRpScpRtActCustVO[priRpScpRtActCustVOS.length];
			System.arraycopy(priRpScpRtActCustVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtActCustVOS = tmpVOs;
		}
	}

}