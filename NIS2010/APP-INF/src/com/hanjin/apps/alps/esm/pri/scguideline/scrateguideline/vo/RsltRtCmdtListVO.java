/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltRtCmdtListVO.java
 *@FileTitle : RsltRtCmdtListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.04 박성수 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 */

public class RsltRtCmdtListVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<RsltRtCmdtHdrListVO> rsltrtcmdthdrlistvos = null;
	private List<RsltRtCmdtDetailVO> prisgrtcmdtvos = null;

	public List<RsltRtCmdtHdrListVO> getRsltRtCmdtHdrListVOS() {
		return rsltrtcmdthdrlistvos;
	}

	public void setRsltRtCmdtHdrListVOS(List<RsltRtCmdtHdrListVO> rsltRtCmdtHdrListVOS) {
		rsltrtcmdthdrlistvos = rsltRtCmdtHdrListVOS;
	}

	public List<RsltRtCmdtDetailVO> getPriSgRtCmdtVOS() {
		return prisgrtcmdtvos;
	}

	public void setPriSgRtCmdtVOS(List<RsltRtCmdtDetailVO> priSgRtCmdtVOS) {
		prisgrtcmdtvos = priSgRtCmdtVOS;
	}
}
