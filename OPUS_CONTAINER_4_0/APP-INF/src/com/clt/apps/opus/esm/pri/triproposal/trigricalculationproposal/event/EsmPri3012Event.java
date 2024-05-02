/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri3012Event.java
 *@FileTitle : TRI GRI Calculation - Route Point Select
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.10
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.12.10 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriTriGriGrpVO;
import com.clt.syscommon.common.table.PriTriGriRoutPntVO;
import com.clt.syscommon.common.table.PriTriGriRoutViaVO;

/**
 * UI_PRI_3012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_3012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Sungsoo, Park
 * @see ESM_PRI_3012HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri3012Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PriTriGriGrpVO priTriGriGrpVO = null;
	private PriTriGriRoutPntVO priTriGriRoutOrgPntVO = null;
	private PriTriGriRoutViaVO priTriGriRoutOrgViaVO = null;
	private PriTriGriRoutViaVO priTriGriRoutDestViaVO = null;
	private PriTriGriRoutPntVO priTriGriRoutDestPntVO = null;

	public EsmPri3012Event() {
	}

	/**
	 * @return the priTriGriGrpVO
	 */
	public PriTriGriGrpVO getPriTriGriGrpVO() {
		return priTriGriGrpVO;
	}

	/**
	 * @param priTriGriGrpVO the priTriGriGrpVO to set
	 */
	public void setPriTriGriGrpVO(PriTriGriGrpVO priTriGriGrpVO) {
		this.priTriGriGrpVO = priTriGriGrpVO;
	}

	/**
	 * @return the priTriGriRoutOrgPntVO
	 */
	public PriTriGriRoutPntVO getPriTriGriRoutOrgPntVO() {
		return priTriGriRoutOrgPntVO;
	}

	/**
	 * @param priTriGriRoutOrgPntVO the priTriGriRoutOrgPntVO to set
	 */
	public void setPriTriGriRoutOrgPntVO(PriTriGriRoutPntVO priTriGriRoutOrgPntVO) {
		this.priTriGriRoutOrgPntVO = priTriGriRoutOrgPntVO;
	}

	/**
	 * @return the priTriGriRoutOrgViaVO
	 */
	public PriTriGriRoutViaVO getPriTriGriRoutOrgViaVO() {
		return priTriGriRoutOrgViaVO;
	}

	/**
	 * @param priTriGriRoutOrgViaVO the priTriGriRoutOrgViaVO to set
	 */
	public void setPriTriGriRoutOrgViaVO(PriTriGriRoutViaVO priTriGriRoutOrgViaVO) {
		this.priTriGriRoutOrgViaVO = priTriGriRoutOrgViaVO;
	}

	/**
	 * @return the priTriGriRoutDestViaVO
	 */
	public PriTriGriRoutViaVO getPriTriGriRoutDestViaVO() {
		return priTriGriRoutDestViaVO;
	}

	/**
	 * @param priTriGriRoutDestViaVO the priTriGriRoutDestViaVO to set
	 */
	public void setPriTriGriRoutDestViaVO(PriTriGriRoutViaVO priTriGriRoutDestViaVO) {
		this.priTriGriRoutDestViaVO = priTriGriRoutDestViaVO;
	}

	/**
	 * @return the priTriGriRoutDestPntVO
	 */
	public PriTriGriRoutPntVO getPriTriGriRoutDestPntVO() {
		return priTriGriRoutDestPntVO;
	}

	/**
	 * @param priTriGriRoutDestPntVO the priTriGriRoutDestPntVO to set
	 */
	public void setPriTriGriRoutDestPntVO(PriTriGriRoutPntVO priTriGriRoutDestPntVO) {
		this.priTriGriRoutDestPntVO = priTriGriRoutDestPntVO;
	}

}