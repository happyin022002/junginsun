/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TriGriCalcVO.java
 *@FileTitle : TriGriCalcVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.10
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.12.10 박성수 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo;

import java.io.Serializable;

import com.clt.syscommon.common.table.PriTriGriCmdtVO;
import com.clt.syscommon.common.table.PriTriGriGrpVO;
import com.clt.syscommon.common.table.PriTriGriRoutPntVO;
import com.clt.syscommon.common.table.PriTriGriRoutViaVO;
import com.clt.syscommon.common.table.PriTriGriRtVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class TriGriCalcVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriTriGriGrpVO[] priTriGriGrpVOS = null;
	private PriTriGriCmdtVO[] priTriGriCmdtVOS = null;
	private PriTriGriRoutPntVO[] priTriGriRoutOrgPntVOS = null;
	private PriTriGriRoutViaVO[] priTriGriRoutOrgViaVOS = null;
	private PriTriGriRoutViaVO[] priTriGriRoutDestViaVOS = null;
	private PriTriGriRoutPntVO[] priTriGriRoutDestPntVOS = null;
	private PriTriGriRtVO[] priTriGriRtVOS = null;
	
	/**
	 * @return the priTriGriGrpVOS
	 */
	public PriTriGriGrpVO[] getPriTriGriGrpVOS() {
		return priTriGriGrpVOS;
	}
	/**
	 * @param priTriGriGrpVOS the priTriGriGrpVOS to set
	 */
	public void setPriTriGriGrpVOS(PriTriGriGrpVO[] priTriGriGrpVOS) {
		this.priTriGriGrpVOS = priTriGriGrpVOS;
	}
	/**
	 * @return the priTriGriCmdtVOS
	 */
	public PriTriGriCmdtVO[] getPriTriGriCmdtVOS() {
		return priTriGriCmdtVOS;
	}
	/**
	 * @param priTriGriCmdtVOS the priTriGriCmdtVOS to set
	 */
	public void setPriTriGriCmdtVOS(PriTriGriCmdtVO[] priTriGriCmdtVOS) {
		this.priTriGriCmdtVOS = priTriGriCmdtVOS;
	}
	/**
	 * @return the priTriGriRoutOrgPntVOS
	 */
	public PriTriGriRoutPntVO[] getPriTriGriRoutOrgPntVOS() {
		return priTriGriRoutOrgPntVOS;
	}
	/**
	 * @param priTriGriRoutOrgPntVOS the priTriGriRoutOrgPntVOS to set
	 */
	public void setPriTriGriRoutOrgPntVOS(PriTriGriRoutPntVO[] priTriGriRoutOrgPntVOS) {
		this.priTriGriRoutOrgPntVOS = priTriGriRoutOrgPntVOS;
	}
	/**
	 * @return the priTriGriRoutOrgViaVOS
	 */
	public PriTriGriRoutViaVO[] getPriTriGriRoutOrgViaVOS() {
		return priTriGriRoutOrgViaVOS;
	}
	/**
	 * @param priTriGriRoutOrgViaVOS the priTriGriRoutOrgViaVOS to set
	 */
	public void setPriTriGriRoutOrgViaVOS(PriTriGriRoutViaVO[] priTriGriRoutOrgViaVOS) {
		this.priTriGriRoutOrgViaVOS = priTriGriRoutOrgViaVOS;
	}
	/**
	 * @return the priTriGriRoutDestViaVOS
	 */
	public PriTriGriRoutViaVO[] getPriTriGriRoutDestViaVOS() {
		return priTriGriRoutDestViaVOS;
	}
	/**
	 * @param priTriGriRoutDestViaVOS the priTriGriRoutDestViaVOS to set
	 */
	public void setPriTriGriRoutDestViaVOS(PriTriGriRoutViaVO[] priTriGriRoutDestViaVOS) {
		this.priTriGriRoutDestViaVOS = priTriGriRoutDestViaVOS;
	}
	/**
	 * @return the priTriGriRoutDestPntVOS
	 */
	public PriTriGriRoutPntVO[] getPriTriGriRoutDestPntVOS() {
		return priTriGriRoutDestPntVOS;
	}
	/**
	 * @param priTriGriRoutDestPntVOS the priTriGriRoutDestPntVOS to set
	 */
	public void setPriTriGriRoutDestPntVOS(PriTriGriRoutPntVO[] priTriGriRoutDestPntVOS) {
		this.priTriGriRoutDestPntVOS = priTriGriRoutDestPntVOS;
	}
	/**
	 * @return the priTriGriRtVOS
	 */
	public PriTriGriRtVO[] getPriTriGriRtVOS() {
		return priTriGriRtVOS;
	}
	/**
	 * @param priTriGriRtVOS the priTriGriRtVOS to set
	 */
	public void setPriTriGriRtVOS(PriTriGriRtVO[] priTriGriRtVOS) {
		this.priTriGriRtVOS = priTriGriRtVOS;
	}
	


}
