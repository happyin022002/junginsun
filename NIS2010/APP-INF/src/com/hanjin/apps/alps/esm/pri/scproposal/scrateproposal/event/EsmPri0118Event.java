/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri0118Event.java
 *@FileTitle : Amendment History - Rate (Route Note)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.18
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.18 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRnoteVO;

/**
 * UI_PRI_0097 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0097HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0091HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0118Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOS = null;

	public EsmPri0118Event() {
	}

	public PriSpScpRtCmdtRnoteVO[] getPriSpScpRtCmdtRnoteVOS() {
		return priSpScpRtCmdtRnoteVOS;
	}

	public void setPriSpScpRtCmdtRnoteVOS(PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOS) {
		this.priSpScpRtCmdtRnoteVOS = priSpScpRtCmdtRnoteVOS;
	}

}