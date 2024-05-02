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

package com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo;

import java.io.Serializable;

import com.clt.syscommon.common.table.PriSgRtCmdtRnoteVO;
import com.clt.syscommon.common.table.PriSgRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriSgRtRoutPntVO;
import com.clt.syscommon.common.table.PriSgRtRoutViaVO;
import com.clt.syscommon.common.table.PriSgRtVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class ScRtGlineRoutVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriSgRtCmdtRoutVO[] priSgRtCmdtRoutVOS = null;
	private PriSgRtRoutPntVO[] priSgRtRoutOrgPntVOS = null;
	private PriSgRtRoutViaVO[] priSgRtRoutOrgViaVOS = null;
	private PriSgRtRoutViaVO[] priSgRtRoutDestViaVOS = null;
	private PriSgRtRoutPntVO[] priSgRtRoutDestPntVOS = null;
	private PriSgRtCmdtRnoteVO[] priSgRtCmdtRnoteVOS = null;
	private PriSgRtVO[] priSgRtVOS = null;

	public PriSgRtCmdtRoutVO[] getPriSgRtCmdtRoutVOS() {
		return priSgRtCmdtRoutVOS;
	}

	public void setPriSgRtCmdtRoutVOS(PriSgRtCmdtRoutVO[] priSgRtCmdtRoutVOS) {
		this.priSgRtCmdtRoutVOS = priSgRtCmdtRoutVOS;
	}

	public PriSgRtRoutPntVO[] getPriSgRtRoutOrgPntVOS() {
		return priSgRtRoutOrgPntVOS;
	}

	public void setPriSgRtRoutOrgPntVOS(PriSgRtRoutPntVO[] priSgRtRoutOrgPntVOS) {
		this.priSgRtRoutOrgPntVOS = priSgRtRoutOrgPntVOS;
	}

	public PriSgRtRoutViaVO[] getPriSgRtRoutOrgViaVOS() {
		return priSgRtRoutOrgViaVOS;
	}

	public void setPriSgRtRoutOrgViaVOS(PriSgRtRoutViaVO[] priSgRtRoutOrgViaVOS) {
		this.priSgRtRoutOrgViaVOS = priSgRtRoutOrgViaVOS;
	}

	public PriSgRtRoutViaVO[] getPriSgRtRoutDestViaVOS() {
		return priSgRtRoutDestViaVOS;
	}

	public void setPriSgRtRoutDestViaVOS(PriSgRtRoutViaVO[] priSgRtRoutDestViaVOS) {
		this.priSgRtRoutDestViaVOS = priSgRtRoutDestViaVOS;
	}

	public PriSgRtRoutPntVO[] getPriSgRtRoutDestPntVOS() {
		return priSgRtRoutDestPntVOS;
	}

	public void setPriSgRtRoutDestPntVOS(PriSgRtRoutPntVO[] priSgRtRoutDestPntVOS) {
		this.priSgRtRoutDestPntVOS = priSgRtRoutDestPntVOS;
	}

	public PriSgRtCmdtRnoteVO[] getPriSgRtCmdtRnoteVOS() {
		return priSgRtCmdtRnoteVOS;
	}

	public void setPriSgRtCmdtRnoteVOS(PriSgRtCmdtRnoteVO[] priSgRtCmdtRnoteVOS) {
		this.priSgRtCmdtRnoteVOS = priSgRtCmdtRnoteVOS;
	}

	public PriSgRtVO[] getPriSgRtVOS() {
		return priSgRtVOS;
	}

	public void setPriSgRtVOS(PriSgRtVO[] priSgRtVOS) {
		this.priSgRtVOS = priSgRtVOS;
	}
}
