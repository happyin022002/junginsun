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
package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgRtCmdtRnoteVO;

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
		this.priSgRtCmdtRnoteVOs = priSgRtCmdtRnoteVOs;
	}

	public PriSgRtCmdtRnoteVO getPriSgRtCmdtRnoteVO() {
		return priSgRtCmdtRnoteVO;
	}

	public PriSgRtCmdtRnoteVO[] getPriSgRtCmdtRnoteVOS() {
		return priSgRtCmdtRnoteVOs;
	}

}