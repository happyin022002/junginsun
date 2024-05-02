/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri0115Event.java
 *@FileTitle : Amendment History - Rate (Route)
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
import com.hanjin.syscommon.common.table.PriSpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutViaVO;

/**
 * UI_PRI_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_PRI_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_0003_08HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0115Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtRoutPntVO[] priSpScpRtRoutOrgPntVO = null;
	private PriSpScpRtRoutViaVO[] priSpScpRtRoutOrgViaVO = null;
	private PriSpScpRtRoutViaVO[] priSpScpRtRoutDestViaVO = null;
	private PriSpScpRtRoutPntVO[] priSpScpRtRoutDestPntVO = null;

	public EsmPri0115Event() {
	}

	public PriSpScpRtRoutPntVO[] getPriSpScpRtRoutOrgPntVO() {
		return priSpScpRtRoutOrgPntVO;
	}

	public void setPriSpScpRtRoutOrgPntVO(PriSpScpRtRoutPntVO[] priSpScpRtRoutOrgPntVO) {
		this.priSpScpRtRoutOrgPntVO = priSpScpRtRoutOrgPntVO;
	}

	public PriSpScpRtRoutViaVO[] getPriSpScpRtRoutOrgViaVO() {
		return priSpScpRtRoutOrgViaVO;
	}

	public void setPriSpScpRtRoutOrgViaVO(PriSpScpRtRoutViaVO[] priSpScpRtRoutOrgViaVO) {
		this.priSpScpRtRoutOrgViaVO = priSpScpRtRoutOrgViaVO;
	}

	public PriSpScpRtRoutViaVO[] getPriSpScpRtRoutDestViaVO() {
		return priSpScpRtRoutDestViaVO;
	}

	public void setPriSpScpRtRoutDestViaVO(PriSpScpRtRoutViaVO[] priSpScpRtRoutDestViaVO) {
		this.priSpScpRtRoutDestViaVO = priSpScpRtRoutDestViaVO;
	}

	public PriSpScpRtRoutPntVO[] getPriSpScpRtRoutDestPntVO() {
		return priSpScpRtRoutDestPntVO;
	}

	public void setPriSpScpRtRoutDestPntVO(PriSpScpRtRoutPntVO[] priSpScpRtRoutDestPntVO) {
		this.priSpScpRtRoutDestPntVO = priSpScpRtRoutDestPntVO;
	}

}