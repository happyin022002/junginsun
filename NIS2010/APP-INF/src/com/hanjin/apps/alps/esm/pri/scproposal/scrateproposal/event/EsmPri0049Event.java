/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri0049Event.java
 *@FileTitle : S/C Proposal General/Special Rate - Commodity Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.23
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.23 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtVO;

/**
 * UI_PRI_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0003_08HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0049Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtVO[] priSpScpRtCmdtVOS = null;

	public EsmPri0049Event() {
	}

	public PriSpScpRtCmdtVO[] getPriSpScpRtCmdtVOS() {
		return priSpScpRtCmdtVOS;
	}

	public void setPriSpScpRtCmdtVOS(PriSpScpRtCmdtVO[] priSpScpRtCmdtVOS) {
		this.priSpScpRtCmdtVOS = priSpScpRtCmdtVOS;
	}

}