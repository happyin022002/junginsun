/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0091Event.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.08
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.06.08 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtCnoteVO;

/**
 * UI_PRI_0091 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0091HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0091HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0091Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCnoteVO[] priSpScpRtCnoteVOS = null;

	public EsmPri0091Event() {
	}

	public PriSpScpRtCnoteVO[] getPriSpScpRtCnoteVOS() {
		return priSpScpRtCnoteVOS;
	}

	public void setPriSpScpRtCnoteVOS(PriSpScpRtCnoteVO[] priSpScpRtCnoteVOS) {
		this.priSpScpRtCnoteVOS = priSpScpRtCnoteVOS;
	}
}