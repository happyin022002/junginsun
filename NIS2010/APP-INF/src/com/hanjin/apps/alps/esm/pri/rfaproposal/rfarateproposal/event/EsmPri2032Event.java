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
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtVO;

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
		PriRpScpRtCmdtVO[] rtnVOs = null;
		if (this.priRpScpRtCmdtVOS != null) {
			rtnVOs = new PriRpScpRtCmdtVO[priRpScpRtCmdtVOS.length];
			System.arraycopy(priRpScpRtCmdtVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param priRpScpRtCmdtVOS the priRpScpRtCmdtVOS to set
	 */
	public void setPriRpScpRtCmdtVOS(PriRpScpRtCmdtVO[] priRpScpRtCmdtVOS){
		if(priRpScpRtCmdtVOS != null){
			PriRpScpRtCmdtVO[] tmpVOs = new PriRpScpRtCmdtVO[priRpScpRtCmdtVOS.length];
			System.arraycopy(priRpScpRtCmdtVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtCmdtVOS = tmpVOs;
		}
	}

}