/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri0104Event.java
 *@FileTitle : Guideline Route Note Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.05.20 문동규
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgRtCmdtRnoteVO;

/**
 * ESM_PRI_0104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_0104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Moon Dong Gyu
 * @see ESM_PRI_0104HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0104Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriSgRtCmdtRnoteVO priSgRtCmdtRnoteVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriSgRtCmdtRnoteVO[] priSgRtCmdtRnoteVOs = null;

	public EsmPri0104Event() {
	}

	public void setPriSgRtCmdtRnoteVO(PriSgRtCmdtRnoteVO priSgRtCmdtRnoteVO) {
		this.priSgRtCmdtRnoteVO = priSgRtCmdtRnoteVO;
	}

	public void setPriSgRtCmdtRnoteVOS(PriSgRtCmdtRnoteVO[] priSgRtCmdtRnoteVOs) {
		if (priSgRtCmdtRnoteVOs != null) {
			PriSgRtCmdtRnoteVO[] tmpVOs = new PriSgRtCmdtRnoteVO[priSgRtCmdtRnoteVOs.length];
			System.arraycopy(priSgRtCmdtRnoteVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgRtCmdtRnoteVOs = tmpVOs;
		}
	}

	public PriSgRtCmdtRnoteVO getPriSgRtCmdtRnoteVO() {
		return priSgRtCmdtRnoteVO;
	}

	public PriSgRtCmdtRnoteVO[] getPriSgRtCmdtRnoteVOS() {
		PriSgRtCmdtRnoteVO[] tmpVOs = null;
		if (this.priSgRtCmdtRnoteVOs != null) {
			tmpVOs = new PriSgRtCmdtRnoteVO[priSgRtCmdtRnoteVOs.length];
			System.arraycopy(priSgRtCmdtRnoteVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}