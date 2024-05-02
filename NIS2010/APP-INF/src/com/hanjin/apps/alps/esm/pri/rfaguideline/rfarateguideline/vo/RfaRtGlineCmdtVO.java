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

package com.hanjin.apps.alps.esm.pri.rfaguideline.rfarateguideline.vo;

import java.io.Serializable;

import com.hanjin.syscommon.common.table.PriRgRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRgRtCmdtVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class RfaRtGlineCmdtVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PriRgRtCmdtHdrVO[] priRgRtCmdtHdrVOS = null;
	private PriRgRtCmdtVO[] priRgRtCmdtVOS = null;
	
	/**
	 * @return the priRgRtCmdtHdrVOS
	 */
	public PriRgRtCmdtHdrVO[] getPriRgRtCmdtHdrVOS() {
		return priRgRtCmdtHdrVOS;
	}
	
	/**
	 * @param priRgRtCmdtHdrVOS the priRgRtCmdtHdrVOS to set
	 */
	public void setPriRgRtCmdtHdrVOS(PriRgRtCmdtHdrVO[] priRgRtCmdtHdrVOS) {
		this.priRgRtCmdtHdrVOS = priRgRtCmdtHdrVOS;
	}
	
	/**
	 * @return the priRgRtCmdtVOS
	 */
	public PriRgRtCmdtVO[] getPriRgRtCmdtVOS() {
		return priRgRtCmdtVOS;
	}
	
	/**
	 * @param priRgRtCmdtVOS the priRgRtCmdtVOS to set
	 */
	public void setPriRgRtCmdtVOS(PriRgRtCmdtVO[] priRgRtCmdtVOS) {
		this.priRgRtCmdtVOS = priRgRtCmdtVOS;
	}

}
