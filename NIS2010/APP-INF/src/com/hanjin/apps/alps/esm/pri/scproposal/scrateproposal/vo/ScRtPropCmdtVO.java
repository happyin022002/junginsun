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

import com.hanjin.syscommon.common.table.PriSpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCnoteVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class ScRtPropCmdtVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriSpScpRtCmdtHdrVO[] priSpScpRtCmdtHdrVOS = null;
	private PriSpScpRtCmdtVO[] priSpScpRtCmdtVOS = null;
	private PriSpScpRtCnoteVO[] priSpScpRtCnoteVOS = null;
	private PriSpScpRtActCustVO[] priSpScpRtActCustVOS = null;

	public PriSpScpRtCmdtHdrVO[] getPriSpScpRtCmdtHdrVOS() {
		return priSpScpRtCmdtHdrVOS;
	}

	public void setPriSpScpRtCmdtHdrVOS(PriSpScpRtCmdtHdrVO[] priSpScpRtCmdtHdrVOS) {
		this.priSpScpRtCmdtHdrVOS = priSpScpRtCmdtHdrVOS;
	}

	public PriSpScpRtCmdtVO[] getPriSpScpRtCmdtVOS() {
		return priSpScpRtCmdtVOS;
	}

	public void setPriSpScpRtCmdtVOS(PriSpScpRtCmdtVO[] priSpScpRtCmdtVOS) {
		this.priSpScpRtCmdtVOS = priSpScpRtCmdtVOS;
	}

	public PriSpScpRtCnoteVO[] getPriSpScpRtCnoteVOS() {
		return priSpScpRtCnoteVOS;
	}

	public void setPriSpScpRtCnoteVOS(PriSpScpRtCnoteVO[] priSpScpRtCnoteVOS) {
		this.priSpScpRtCnoteVOS = priSpScpRtCnoteVOS;
	}

	public PriSpScpRtActCustVO[] getPriSpScpRtActCustVOS() {
		return priSpScpRtActCustVOS;
	}

	public void setPriSpScpRtActCustVOS(PriSpScpRtActCustVO[] priSpScpRtActCustVOS) {
		this.priSpScpRtActCustVOS = priSpScpRtActCustVOS;
	}

}
