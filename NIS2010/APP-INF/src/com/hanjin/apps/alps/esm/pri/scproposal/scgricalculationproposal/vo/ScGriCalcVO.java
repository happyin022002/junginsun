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

package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo;

import java.io.Serializable;

import com.hanjin.syscommon.common.table.PriSpScpGriActCustVO;
import com.hanjin.syscommon.common.table.PriSpScpGriCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRoutPntVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRoutViaVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRtVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class ScGriCalcVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriSpScpGriGrpVO[] priSpScpGriGrpVOS = null;
	private PriSpScpGriCmdtVO[] priSpScpGriCmdtVOS = null;
	private PriSpScpGriActCustVO[] priSpScpGriActCustVOS = null;
	private PriSpScpGriRoutPntVO[] priSpScpGriRoutOrgPntVOS = null;
	private PriSpScpGriRoutViaVO[] priSpScpGriRoutOrgViaVOS = null;
	private PriSpScpGriRoutViaVO[] priSpScpGriRoutDestViaVOS = null;
	private PriSpScpGriRoutPntVO[] priSpScpGriRoutDestPntVOS = null;
	private PriSpScpGriRtVO[] priSpScpGriRtVOS = null;
	
	public PriSpScpGriGrpVO[] getPriSpScpGriGrpVOS() {
		return priSpScpGriGrpVOS;
	}
	public void setPriSpScpGriGrpVOS(PriSpScpGriGrpVO[] priSpScpGriGrpVOS) {
		this.priSpScpGriGrpVOS = priSpScpGriGrpVOS;
	}
	public PriSpScpGriCmdtVO[] getPriSpScpGriCmdtVOS() {
		return priSpScpGriCmdtVOS;
	}
	public void setPriSpScpGriCmdtVOS(PriSpScpGriCmdtVO[] priSpScpGriCmdtVOS) {
		this.priSpScpGriCmdtVOS = priSpScpGriCmdtVOS;
	}
	public PriSpScpGriActCustVO[] getPriSpScpGriActCustVOS() {
		return priSpScpGriActCustVOS;
	}
	public void setPriSpScpGriActCustVOS(PriSpScpGriActCustVO[] priSpScpGriActCustVOS) {
		this.priSpScpGriActCustVOS = priSpScpGriActCustVOS;
	}
	public PriSpScpGriRoutPntVO[] getPriSpScpGriRoutOrgPntVOS() {
		return priSpScpGriRoutOrgPntVOS;
	}
	public void setPriSpScpGriRoutOrgPntVOS(PriSpScpGriRoutPntVO[] priSpScpGriRoutOrgPntVOS) {
		this.priSpScpGriRoutOrgPntVOS = priSpScpGriRoutOrgPntVOS;
	}
	public PriSpScpGriRoutViaVO[] getPriSpScpGriRoutOrgViaVOS() {
		return priSpScpGriRoutOrgViaVOS;
	}
	public void setPriSpScpGriRoutOrgViaVOS(PriSpScpGriRoutViaVO[] priSpScpGriRoutOrgViaVOS) {
		this.priSpScpGriRoutOrgViaVOS = priSpScpGriRoutOrgViaVOS;
	}
	public PriSpScpGriRoutViaVO[] getPriSpScpGriRoutDestViaVOS() {
		return priSpScpGriRoutDestViaVOS;
	}
	public void setPriSpScpGriRoutDestViaVOS(PriSpScpGriRoutViaVO[] priSpScpGriRoutDestViaVOS) {
		this.priSpScpGriRoutDestViaVOS = priSpScpGriRoutDestViaVOS;
	}
	public PriSpScpGriRoutPntVO[] getPriSpScpGriRoutDestPntVOS() {
		return priSpScpGriRoutDestPntVOS;
	}
	public void setPriSpScpGriRoutDestPntVOS(PriSpScpGriRoutPntVO[] priSpScpGriRoutDestPntVOS) {
		this.priSpScpGriRoutDestPntVOS = priSpScpGriRoutDestPntVOS;
	}
	public PriSpScpGriRtVO[] getPriSpScpGriRtVOS() {
		return priSpScpGriRtVOS;
	}
	public void setPriSpScpGriRtVOS(PriSpScpGriRtVO[] priSpScpGriRtVOS) {
		this.priSpScpGriRtVOS = priSpScpGriRtVOS;
	}

}
