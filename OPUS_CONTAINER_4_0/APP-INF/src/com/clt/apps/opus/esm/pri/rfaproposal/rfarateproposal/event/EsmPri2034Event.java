/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2034Event.java
 *@FileTitle : RFA Proposal Creation - Rate [Check Duplicate]
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.25 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * UI_PRI_0093 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0093HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_2036HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2034Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO = null;

	public EsmPri2034Event() {
	}

	/**
	 * @return the priRpScpRtCmdtHdrVO
	 */
	public PriRpScpRtCmdtHdrVO getPriRpScpRtCmdtHdrVO() {
		return priRpScpRtCmdtHdrVO;
	}

	/**
	 * @param priRpScpRtCmdtHdrVO the priRpScpRtCmdtHdrVO to set
	 */
	public void setPriRpScpRtCmdtHdrVO(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) {
		this.priRpScpRtCmdtHdrVO = priRpScpRtCmdtHdrVO;
	}

}