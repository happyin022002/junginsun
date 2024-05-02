/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltRtRoutListVO.java
 *@FileTitle : RsltRtRoutListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.04 박성수 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo;

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

public class RsltRtRoutListVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<RsltRtListVO> rsltRtListVOS = null;
	private List<RsltRtRoutPntListVO> orgRsltRtRoutPntListVOS = null;
	private List<RsltRtRoutViaListVO> orgRsltRtRoutViaListVOS = null;
	private List<RsltRtRoutViaListVO> destRsltRtRoutViaListVOS = null;
	private List<RsltRtRoutPntListVO> destRsltRtRoutPntListVOS = null;
	private List<RsltRtCmdtRnoteListVO> rsltRtCmdtRnoteListVOS = null;

	public List<RsltRtListVO> getRsltRtListVOS() {
		return rsltRtListVOS;
	}

	public void setRsltRtListVOS(List<RsltRtListVO> rsltRtListVOS) {
		this.rsltRtListVOS = rsltRtListVOS;
	}

	public List<RsltRtRoutPntListVO> getOrgRsltRtRoutPntListVOS() {
		return orgRsltRtRoutPntListVOS;
	}

	public void setOrgRsltRtRoutPntListVOS(List<RsltRtRoutPntListVO> orgRsltRtRoutPntListVOS) {
		this.orgRsltRtRoutPntListVOS = orgRsltRtRoutPntListVOS;
	}

	public List<RsltRtRoutViaListVO> getOrgRsltRtRoutViaListVOS() {
		return orgRsltRtRoutViaListVOS;
	}

	public void setOrgRsltRtRoutViaListVOS(List<RsltRtRoutViaListVO> orgRsltRtRoutViaListVOS) {
		this.orgRsltRtRoutViaListVOS = orgRsltRtRoutViaListVOS;
	}

	public List<RsltRtRoutViaListVO> getDestRsltRtRoutViaListVOS() {
		return destRsltRtRoutViaListVOS;
	}

	public void setDestRsltRtRoutViaListVOS(List<RsltRtRoutViaListVO> destRsltRtRoutViaListVOS) {
		this.destRsltRtRoutViaListVOS = destRsltRtRoutViaListVOS;
	}

	public List<RsltRtRoutPntListVO> getDestRsltRtRoutPntListVOS() {
		return destRsltRtRoutPntListVOS;
	}

	public void setDestRsltRtRoutPntListVOS(List<RsltRtRoutPntListVO> destRsltRtRoutPntListVOS) {
		this.destRsltRtRoutPntListVOS = destRsltRtRoutPntListVOS;
	}

	public List<RsltRtCmdtRnoteListVO> getRsltRtCmdtRnoteListVOS() {
		return rsltRtCmdtRnoteListVOS;
	}

	public void setRsltRtCmdtRnoteListVOS(List<RsltRtCmdtRnoteListVO> rsltRtCmdtRnoteListVOS) {
		this.rsltRtCmdtRnoteListVOS = rsltRtCmdtRnoteListVOS;
	}

}
