/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0094Event.java
 *@FileTitle : EsmPri0094Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.12
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.06.12 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutDirVO;

/**
 * UI_PRI_0094 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0094HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0070HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0094Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOS = null;

	public EsmPri0094Event() {
	}

	public PriSpScpRtRoutDirVO[] getPriSpScpRtRoutDirVOS() {
		return priSpScpRtRoutDirVOS;
	}

	public void setPriSpScpRtRoutDirVOS(PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOS) {
		this.priSpScpRtRoutDirVOS = priSpScpRtRoutDirVOS;
	}

}