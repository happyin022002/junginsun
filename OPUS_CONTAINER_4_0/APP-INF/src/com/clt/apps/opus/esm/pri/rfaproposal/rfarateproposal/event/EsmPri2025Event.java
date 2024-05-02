/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri2025Event.java
 *@FileTitle : RFA Proposal Creation - Rate (Route Point)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.21 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.clt.syscommon.common.table.PriRpScpRtRoutViaVO;

/**
 * UI_PRI_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_2003_07HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri2025Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriRpScpRtRoutPntVO[] priRpScpRtRoutOrgPntVO = null;
	private PriRpScpRtRoutViaVO[] priRpScpRtRoutOrgViaVO = null;
	private PriRpScpRtRoutViaVO[] priRpScpRtRoutDestViaVO = null;
	private PriRpScpRtRoutPntVO[] priRpScpRtRoutDestPntVO = null;

	public EsmPri2025Event() {
	}

	/**
	 * @return the priRpScpRtRoutOrgPntVO
	 */
	public PriRpScpRtRoutPntVO[] getPriRpScpRtRoutOrgPntVO() {
		PriRpScpRtRoutPntVO[] tmpVOs = null;
		if (this.priRpScpRtRoutOrgPntVO != null) {
			tmpVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutOrgPntVO.length];
			System.arraycopy(priRpScpRtRoutOrgPntVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRpScpRtRoutOrgPntVO the priRpScpRtRoutOrgPntVO to set
	 */
	public void setPriRpScpRtRoutOrgPntVO(PriRpScpRtRoutPntVO[] priRpScpRtRoutOrgPntVO) {
		if (priRpScpRtRoutOrgPntVO != null) {
			PriRpScpRtRoutPntVO[] tmpVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutOrgPntVO.length];
			System.arraycopy(priRpScpRtRoutOrgPntVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutOrgPntVO = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtRoutOrgViaVO
	 */
	public PriRpScpRtRoutViaVO[] getPriRpScpRtRoutOrgViaVO() {
		PriRpScpRtRoutViaVO[] tmpVOs = null;
		if (this.priRpScpRtRoutOrgViaVO != null) {
			tmpVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutOrgViaVO.length];
			System.arraycopy(priRpScpRtRoutOrgViaVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRpScpRtRoutOrgViaVO the priRpScpRtRoutOrgViaVO to set
	 */
	public void setPriRpScpRtRoutOrgViaVO(PriRpScpRtRoutViaVO[] priRpScpRtRoutOrgViaVO) {
		if (priRpScpRtRoutOrgViaVO != null) {
			PriRpScpRtRoutViaVO[] tmpVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutOrgViaVO.length];
			System.arraycopy(priRpScpRtRoutOrgViaVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutOrgViaVO = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtRoutDestViaVO
	 */
	public PriRpScpRtRoutViaVO[] getPriRpScpRtRoutDestViaVO() {
		PriRpScpRtRoutViaVO[] tmpVOs = null;
		if (this.priRpScpRtRoutDestViaVO != null) {
			tmpVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutDestViaVO.length];
			System.arraycopy(priRpScpRtRoutDestViaVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRpScpRtRoutDestViaVO the priRpScpRtRoutDestViaVO to set
	 */
	public void setPriRpScpRtRoutDestViaVO(PriRpScpRtRoutViaVO[] priRpScpRtRoutDestViaVO) {
		if (priRpScpRtRoutDestViaVO != null) {
			PriRpScpRtRoutViaVO[] tmpVOs = new PriRpScpRtRoutViaVO[priRpScpRtRoutDestViaVO.length];
			System.arraycopy(priRpScpRtRoutDestViaVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutDestViaVO = tmpVOs;
		}
	}

	/**
	 * @return the priRpScpRtRoutDestPntVO
	 */
	public PriRpScpRtRoutPntVO[] getPriRpScpRtRoutDestPntVO() {
		PriRpScpRtRoutPntVO[] tmpVOs = null;
		if (this.priRpScpRtRoutDestPntVO != null) {
			tmpVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutDestPntVO.length];
			System.arraycopy(priRpScpRtRoutDestPntVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param priRpScpRtRoutDestPntVO the priRpScpRtRoutDestPntVO to set
	 */
	public void setPriRpScpRtRoutDestPntVO(PriRpScpRtRoutPntVO[] priRpScpRtRoutDestPntVO) {
		if (priRpScpRtRoutDestPntVO != null) {
			PriRpScpRtRoutPntVO[] tmpVOs = new PriRpScpRtRoutPntVO[priRpScpRtRoutDestPntVO.length];
			System.arraycopy(priRpScpRtRoutDestPntVO, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpRtRoutDestPntVO = tmpVOs;
		}
	}

}