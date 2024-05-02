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

package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo;

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

	private List<RsltRtCmdtHdrListVO> rsltRtCmdtHdrListVOS = null;
	private List<RsltRtCmdtDtlListVO> rsltRtCmdtDtlListVOS = null;
	private List<RsltActCustListVO> rsltActCustListVOS = null;
	private List<RsltRtCnoteListVO> rsltRtCnoteListVOS = null;

	public List<RsltRtCmdtHdrListVO> getRsltRtCmdtHdrListVOS() {
		return rsltRtCmdtHdrListVOS;
	}

	public void setRsltRtCmdtHdrListVOS(List<RsltRtCmdtHdrListVO> rsltRtCmdtHdrListVOS) {
		this.rsltRtCmdtHdrListVOS = rsltRtCmdtHdrListVOS;
	}

	public List<RsltRtCmdtDtlListVO> getRsltRtCmdtDtlListVOS() {
		return rsltRtCmdtDtlListVOS;
	}

	public void setRsltRtCmdtDtlListVOS(List<RsltRtCmdtDtlListVO> rsltRtCmdtDtlListVOS) {
		this.rsltRtCmdtDtlListVOS = rsltRtCmdtDtlListVOS;
	}

	public List<RsltActCustListVO> getRsltActCustListVOS() {
		return rsltActCustListVOS;
	}

	public void setRsltActCustListVOS(List<RsltActCustListVO> rsltActCustListVOS) {
		this.rsltActCustListVOS = rsltActCustListVOS;
	}

	public List<RsltRtCnoteListVO> getRsltRtCnoteListVOS() {
		return rsltRtCnoteListVOS;
	}

	public void setRsltRtCnoteListVOS(List<RsltRtCnoteListVO> rsltRtCnoteListVOS) {
		this.rsltRtCnoteListVOS = rsltRtCnoteListVOS;
	}

}
