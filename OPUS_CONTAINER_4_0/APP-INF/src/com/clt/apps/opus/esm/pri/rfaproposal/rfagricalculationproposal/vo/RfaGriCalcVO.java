/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltCdListVO.java
 *@FileTitle : RsltCdListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.16 박성수 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo;

import java.io.Serializable;

import com.clt.syscommon.common.table.PriRpScpGriActCustVO;
import com.clt.syscommon.common.table.PriRpScpGriCmdtVO;
import com.clt.syscommon.common.table.PriRpScpGriGrpVO;
import com.clt.syscommon.common.table.PriRpScpGriRoutPntVO;
import com.clt.syscommon.common.table.PriRpScpGriRoutViaVO;
import com.clt.syscommon.common.table.PriRpScpGriRtVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class RfaGriCalcVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriRpScpGriGrpVO[] priRpScpGriGrpVOS = null;
	private PriRpScpGriCmdtVO[] priRpScpGriCmdtVOS = null;
	private PriRpScpGriActCustVO[] priRpScpGriActCustVOS = null;
	private PriRpScpGriRoutPntVO[] priRpScpGriRoutOrgPntVOS = null;
	private PriRpScpGriRoutViaVO[] priRpScpGriRoutOrgViaVOS = null;
	private PriRpScpGriRoutViaVO[] priRpScpGriRoutDestViaVOS = null;
	private PriRpScpGriRoutPntVO[] priRpScpGriRoutDestPntVOS = null;
	private PriRpScpGriRtVO[] priRpScpGriRtVOS = null;
	
	/**
	 * @return the priRpScpGriGrpVOS
	 */
	public PriRpScpGriGrpVO[] getPriRpScpGriGrpVOS() {
		return priRpScpGriGrpVOS;
	}
	
	/**
	 * @param priRpScpGriGrpVOS the priRpScpGriGrpVOS to set
	 */
	public void setPriRpScpGriGrpVOS(PriRpScpGriGrpVO[] priRpScpGriGrpVOS) {
		this.priRpScpGriGrpVOS = priRpScpGriGrpVOS;
	}
	
	/**
	 * @return the priRpScpGriCmdtVOS
	 */
	public PriRpScpGriCmdtVO[] getPriRpScpGriCmdtVOS() {
		return priRpScpGriCmdtVOS;
	}
	
	/**
	 * @param priRpScpGriCmdtVOS the priRpScpGriCmdtVOS to set
	 */
	public void setPriRpScpGriCmdtVOS(PriRpScpGriCmdtVO[] priRpScpGriCmdtVOS) {
		this.priRpScpGriCmdtVOS = priRpScpGriCmdtVOS;
	}
	
	/**
	 * @return the priRpScpGriActCustVOS
	 */
	public PriRpScpGriActCustVO[] getPriRpScpGriActCustVOS() {
		return priRpScpGriActCustVOS;
	}
	
	/**
	 * @param priRpScpGriActCustVOS the priRpScpGriActCustVOS to set
	 */
	public void setPriRpScpGriActCustVOS(PriRpScpGriActCustVO[] priRpScpGriActCustVOS) {
		this.priRpScpGriActCustVOS = priRpScpGriActCustVOS;
	}
	
	/**
	 * @return the priRpScpGriRoutOrgPntVOS
	 */
	public PriRpScpGriRoutPntVO[] getPriRpScpGriRoutOrgPntVOS() {
		return priRpScpGriRoutOrgPntVOS;
	}
	
	/**
	 * @param priRpScpGriRoutOrgPntVOS the priRpScpGriRoutOrgPntVOS to set
	 */
	public void setPriRpScpGriRoutOrgPntVOS(PriRpScpGriRoutPntVO[] priRpScpGriRoutOrgPntVOS) {
		this.priRpScpGriRoutOrgPntVOS = priRpScpGriRoutOrgPntVOS;
	}
	
	/**
	 * @return the priRpScpGriRoutOrgViaVOS
	 */
	public PriRpScpGriRoutViaVO[] getPriRpScpGriRoutOrgViaVOS() {
		return priRpScpGriRoutOrgViaVOS;
	}
	
	/**
	 * @param priRpScpGriRoutOrgViaVOS the priRpScpGriRoutOrgViaVOS to set
	 */
	public void setPriRpScpGriRoutOrgViaVOS(PriRpScpGriRoutViaVO[] priRpScpGriRoutOrgViaVOS) {
		this.priRpScpGriRoutOrgViaVOS = priRpScpGriRoutOrgViaVOS;
	}
	
	/**
	 * @return the priRpScpGriRoutDestViaVOS
	 */
	public PriRpScpGriRoutViaVO[] getPriRpScpGriRoutDestViaVOS() {
		return priRpScpGriRoutDestViaVOS;
	}
	
	/**
	 * @param priRpScpGriRoutDestViaVOS the priRpScpGriRoutDestViaVOS to set
	 */
	public void setPriRpScpGriRoutDestViaVOS(PriRpScpGriRoutViaVO[] priRpScpGriRoutDestViaVOS) {
		this.priRpScpGriRoutDestViaVOS = priRpScpGriRoutDestViaVOS;
	}
	
	/**
	 * @return the priRpScpGriRoutDestPntVOS
	 */
	public PriRpScpGriRoutPntVO[] getPriRpScpGriRoutDestPntVOS() {
		return priRpScpGriRoutDestPntVOS;
	}
	
	/**
	 * @param priRpScpGriRoutDestPntVOS the priRpScpGriRoutDestPntVOS to set
	 */
	public void setPriRpScpGriRoutDestPntVOS(PriRpScpGriRoutPntVO[] priRpScpGriRoutDestPntVOS) {
		this.priRpScpGriRoutDestPntVOS = priRpScpGriRoutDestPntVOS;
	}
	
	/**
	 * @return the priRpScpGriRtVOS
	 */
	public PriRpScpGriRtVO[] getPriRpScpGriRtVOS() {
		return priRpScpGriRtVOS;
	}
	
	/**
	 * @param priRpScpGriRtVOS the priRpScpGriRtVOS to set
	 */
	public void setPriRpScpGriRtVOS(PriRpScpGriRtVO[] priRpScpGriRtVOS) {
		this.priRpScpGriRtVOS = priRpScpGriRtVOS;
	}
	
}
