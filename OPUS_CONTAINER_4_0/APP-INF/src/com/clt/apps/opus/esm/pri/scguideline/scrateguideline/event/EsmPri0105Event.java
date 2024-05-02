/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri0105Event.java
 *@FileTitle : Rate Guideline Inquiry - Route Note
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.30 박성수
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

public class EsmPri0105Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriSgRtCmdtRnoteVO priSgRtCmdtRnoteVO = null;

	/** Table Value Object Multi Data 처리 */
	private PriSgRtCmdtRnoteVO[] priSgRtCmdtRnoteVOs = null;

	public EsmPri0105Event() {
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