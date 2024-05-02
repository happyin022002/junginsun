/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0093Event.java
 *@FileTitle : EsmPri0093Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.30
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.06.30 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriSpScpRtVO;

/**
 * UI_PRI_0093 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0093HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0093HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0093Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO = null;
	private PriSpScpRtVO priSpScpRtVO = null;

	public EsmPri0093Event() {
	}

	public PriSpScpRtCmdtHdrVO getPriSpScpRtCmdtHdrVO() {
		return priSpScpRtCmdtHdrVO;
	}

	public void setPriSpScpRtCmdtHdrVO(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) {
		this.priSpScpRtCmdtHdrVO = priSpScpRtCmdtHdrVO;
	}

	public PriSpScpRtVO getPriSpScpRtVO() {
		return priSpScpRtVO;
	}

	public void setPriSpScpRtVO(PriSpScpRtVO priSpScpRtVO) {
		this.priSpScpRtVO = priSpScpRtVO;
	}


}