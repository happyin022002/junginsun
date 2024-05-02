/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiPri0027Event.java
 *@FileTitle : EsmPri0027Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.10
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.06.10 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpRtRoutPntVO;
import com.clt.syscommon.common.table.PriSpScpRtRoutViaVO;

/**
 * UI_PRI_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0003_08HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0027Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtRoutPntVO[] priSpScpRtRoutOrgPntVO = null;
	private PriSpScpRtRoutViaVO[] priSpScpRtRoutOrgViaVO = null;
	private PriSpScpRtRoutViaVO[] priSpScpRtRoutDestViaVO = null;
	private PriSpScpRtRoutPntVO[] priSpScpRtRoutDestPntVO = null;

	public EsmPri0027Event() {
	}

	public PriSpScpRtRoutPntVO[] getPriSpScpRtRoutOrgPntVO() {
		PriSpScpRtRoutPntVO[] tmpVOs = null;
		if (this.priSpScpRtRoutOrgPntVO != null) {
			tmpVOs = new PriSpScpRtRoutPntVO[priSpScpRtRoutOrgPntVO.length];
			System.arraycopy(priSpScpRtRoutOrgPntVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSpScpRtRoutOrgPntVO(PriSpScpRtRoutPntVO[] priSpScpRtRoutOrgPntVO) {
		if (priSpScpRtRoutOrgPntVO != null) {
			PriSpScpRtRoutPntVO[] tmpVOs = new PriSpScpRtRoutPntVO[priSpScpRtRoutOrgPntVO.length];
			System.arraycopy(priSpScpRtRoutOrgPntVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpRtRoutOrgPntVO = tmpVOs;
		}
	}

	public PriSpScpRtRoutViaVO[] getPriSpScpRtRoutOrgViaVO() {
		PriSpScpRtRoutViaVO[] tmpVOs = null;
		if (this.priSpScpRtRoutOrgViaVO != null) {
			tmpVOs = new PriSpScpRtRoutViaVO[priSpScpRtRoutOrgViaVO.length];
			System.arraycopy(priSpScpRtRoutOrgViaVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSpScpRtRoutOrgViaVO(PriSpScpRtRoutViaVO[] priSpScpRtRoutOrgViaVO) {
		if (priSpScpRtRoutOrgViaVO != null) {
			PriSpScpRtRoutViaVO[] tmpVOs = new PriSpScpRtRoutViaVO[priSpScpRtRoutOrgViaVO.length];
			System.arraycopy(priSpScpRtRoutOrgViaVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpRtRoutOrgViaVO = tmpVOs;
		}
	}

	public PriSpScpRtRoutViaVO[] getPriSpScpRtRoutDestViaVO() {
		PriSpScpRtRoutViaVO[] tmpVOs = null;
		if (this.priSpScpRtRoutDestViaVO != null) {
			tmpVOs = new PriSpScpRtRoutViaVO[priSpScpRtRoutDestViaVO.length];
			System.arraycopy(priSpScpRtRoutDestViaVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSpScpRtRoutDestViaVO(PriSpScpRtRoutViaVO[] priSpScpRtRoutDestViaVO) {
		if (priSpScpRtRoutDestViaVO != null) {
			PriSpScpRtRoutViaVO[] tmpVOs = new PriSpScpRtRoutViaVO[priSpScpRtRoutDestViaVO.length];
			System.arraycopy(priSpScpRtRoutDestViaVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpRtRoutDestViaVO = tmpVOs;
		}
	}

	public PriSpScpRtRoutPntVO[] getPriSpScpRtRoutDestPntVO() {
		PriSpScpRtRoutPntVO[] tmpVOs = null;
		if (this.priSpScpRtRoutDestPntVO != null) {
			tmpVOs = new PriSpScpRtRoutPntVO[priSpScpRtRoutDestPntVO.length];
			System.arraycopy(priSpScpRtRoutDestPntVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriSpScpRtRoutDestPntVO(PriSpScpRtRoutPntVO[] priSpScpRtRoutDestPntVO) {
		if (priSpScpRtRoutDestPntVO != null) {
			PriSpScpRtRoutPntVO[] tmpVOs = new PriSpScpRtRoutPntVO[priSpScpRtRoutDestPntVO.length];
			System.arraycopy(priSpScpRtRoutDestPntVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpRtRoutDestPntVO = tmpVOs;
		}
	}

}