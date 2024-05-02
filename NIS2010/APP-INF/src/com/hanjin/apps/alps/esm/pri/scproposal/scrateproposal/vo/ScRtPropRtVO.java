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

package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo;

import java.io.Serializable;

import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutDirVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriSpScpRtVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class ScRtPropRtVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO = null;
	private PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOS = null;
	private PriSpScpRtRoutPntVO[] priSpScpRtRoutOrgPntVOS = null;
	private PriSpScpRtRoutViaVO[] priSpScpRtRoutOrgViaVOS = null;
	private PriSpScpRtRoutViaVO[] priSpScpRtRoutDestViaVOS = null;
	private PriSpScpRtRoutPntVO[] priSpScpRtRoutDestPntVOS = null;
	private PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOS = null;
	private PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOS = null;
	private PriSpScpRtVO[] priSpScpRtVOS = null;

	public PriSpScpRtCmdtRoutVO[] getPriSpScpRtCmdtRoutVOS() {
		return priSpScpRtCmdtRoutVOS;
	}

	public void setPriSpScpRtCmdtRoutVOS(PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVOS) {
		this.priSpScpRtCmdtRoutVOS = priSpScpRtCmdtRoutVOS;
	}

	public PriSpScpRtRoutPntVO[] getPriSpScpRtRoutOrgPntVOS() {
		return priSpScpRtRoutOrgPntVOS;
	}

	public void setPriSpScpRtRoutOrgPntVOS(PriSpScpRtRoutPntVO[] priSpScpRtRoutOrgPntVOS) {
		this.priSpScpRtRoutOrgPntVOS = priSpScpRtRoutOrgPntVOS;
	}

	public PriSpScpRtRoutViaVO[] getPriSpScpRtRoutOrgViaVOS() {
		return priSpScpRtRoutOrgViaVOS;
	}

	public void setPriSpScpRtRoutOrgViaVOS(PriSpScpRtRoutViaVO[] priSpScpRtRoutOrgViaVOS) {
		this.priSpScpRtRoutOrgViaVOS = priSpScpRtRoutOrgViaVOS;
	}

	public PriSpScpRtRoutViaVO[] getPriSpScpRtRoutDestViaVOS() {
		return priSpScpRtRoutDestViaVOS;
	}

	public void setPriSpScpRtRoutDestViaVOS(PriSpScpRtRoutViaVO[] priSpScpRtRoutDestViaVOS) {
		this.priSpScpRtRoutDestViaVOS = priSpScpRtRoutDestViaVOS;
	}

	public PriSpScpRtRoutPntVO[] getPriSpScpRtRoutDestPntVOS() {
		return priSpScpRtRoutDestPntVOS;
	}

	public void setPriSpScpRtRoutDestPntVOS(PriSpScpRtRoutPntVO[] priSpScpRtRoutDestPntVOS) {
		this.priSpScpRtRoutDestPntVOS = priSpScpRtRoutDestPntVOS;
	}

	public PriSpScpRtRoutDirVO[] getPriSpScpRtRoutDirVOS() {
		return priSpScpRtRoutDirVOS;
	}

	public void setPriSpScpRtRoutDirVOS(PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOS) {
		this.priSpScpRtRoutDirVOS = priSpScpRtRoutDirVOS;
	}

	public PriSpScpRtCmdtRnoteVO[] getPriSpScpRtCmdtRnoteVOS() {
		return priSpScpRtCmdtRnoteVOS;
	}

	public void setPriSpScpRtCmdtRnoteVOS(PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOS) {
		this.priSpScpRtCmdtRnoteVOS = priSpScpRtCmdtRnoteVOS;
	}

	public PriSpScpRtVO[] getPriSpScpRtVOS() {
		return priSpScpRtVOS;
	}

	public void setPriSpScpRtVOS(PriSpScpRtVO[] priSpScpRtVOS) {
		this.priSpScpRtVOS = priSpScpRtVOS;
	}

	public PriSpScpRtCmdtRoutVO getPriSpScpRtCmdtRoutVO() {
		return priSpScpRtCmdtRoutVO;
	}

	public void setPriSpScpRtCmdtRoutVO(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) {
		this.priSpScpRtCmdtRoutVO = priSpScpRtCmdtRoutVO;
	}
}
