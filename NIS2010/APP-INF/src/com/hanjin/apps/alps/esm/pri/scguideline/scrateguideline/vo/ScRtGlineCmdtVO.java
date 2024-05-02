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

package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo;

import java.io.Serializable;

import com.hanjin.syscommon.common.table.PriSgRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSgRtCmdtVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class ScRtGlineCmdtVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriSgRtCmdtHdrVO[] priSgRtCmdtHdrVOS = null;
	private PriSgRtCmdtVO[] priSgRtCmdtVOS = null;

	public PriSgRtCmdtHdrVO[] getPriSgRtCmdtHdrVOS() {
		return priSgRtCmdtHdrVOS;
	}

	public void setPriSgRtCmdtHdrVOS(PriSgRtCmdtHdrVO[] priSgRtCmdtHdrVOS) {
		this.priSgRtCmdtHdrVOS = priSgRtCmdtHdrVOS;
	}

	public PriSgRtCmdtVO[] getPriSgRtCmdtVOS() {
		return priSgRtCmdtVOS;
	}

	public void setPriSgRtCmdtVOS(PriSgRtCmdtVO[] priSgRtCmdtVOS) {
		this.priSgRtCmdtVOS = priSgRtCmdtVOS;
	}
}
