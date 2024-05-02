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

package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo;

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

public class RsltRtListVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<RsltRtDtlListVO> rsltRtDtlListVOS = null;
	private List<RsltRtRoutOrgPntListVO> rsltRtRoutOrgPntListVOS = null;
	private List<RsltRtRoutOrgViaListVO> rsltRtRoutOrgViaListVOS = null;
	private List<RsltRtRoutDestViaListVO> rsltRtRoutDestViaListVOS = null;
	private List<RsltRtRoutDestPntListVO> rsltRtRoutDestPntListVOS = null;
	private List<RsltRtCmdtRnoteListVO> rsltRtCmdtRnoteListVOS = null;
	private List<RsltRtRoutDirCallListVO> rsltRtRoutDirCallListVOS = null;

	public List<RsltRtDtlListVO> getRsltRtDtlListVOS() {
		return rsltRtDtlListVOS;
	}

	public void setRsltRtDtlListVOS(List<RsltRtDtlListVO> rsltRtDtlListVOS) {
		this.rsltRtDtlListVOS = rsltRtDtlListVOS;
	}

	public List<RsltRtRoutOrgPntListVO> getRsltRtRoutOrgPntListVOS() {
		return rsltRtRoutOrgPntListVOS;
	}

	public void setRsltRtRoutOrgPntListVOS(List<RsltRtRoutOrgPntListVO> rsltRtRoutOrgPntListVOS) {
		this.rsltRtRoutOrgPntListVOS = rsltRtRoutOrgPntListVOS;
	}

	public List<RsltRtRoutOrgViaListVO> getRsltRtRoutOrgViaListVOS() {
		return rsltRtRoutOrgViaListVOS;
	}

	public void setRsltRtRoutOrgViaListVOS(List<RsltRtRoutOrgViaListVO> rsltRtRoutOrgViaListVOS) {
		this.rsltRtRoutOrgViaListVOS = rsltRtRoutOrgViaListVOS;
	}

	public List<RsltRtRoutDestViaListVO> getRsltRtRoutDestViaListVOS() {
		return rsltRtRoutDestViaListVOS;
	}

	public void setRsltRtRoutDestViaListVOS(List<RsltRtRoutDestViaListVO> rsltRtRoutDestViaListVOS) {
		this.rsltRtRoutDestViaListVOS = rsltRtRoutDestViaListVOS;
	}

	public List<RsltRtRoutDestPntListVO> getRsltRtRoutDestPntListVOS() {
		return rsltRtRoutDestPntListVOS;
	}

	public void setRsltRtRoutDestPntListVOS(List<RsltRtRoutDestPntListVO> rsltRtRoutDestPntListVOS) {
		this.rsltRtRoutDestPntListVOS = rsltRtRoutDestPntListVOS;
	}

	public List<RsltRtCmdtRnoteListVO> getRsltRtCmdtRnoteListVOS() {
		return rsltRtCmdtRnoteListVOS;
	}

	public void setRsltRtCmdtRnoteListVOS(List<RsltRtCmdtRnoteListVO> rsltRtCmdtRnoteListVOS) {
		this.rsltRtCmdtRnoteListVOS = rsltRtCmdtRnoteListVOS;
	}

	public List<RsltRtRoutDirCallListVO> getRsltRtRoutDirCallListVOS() {
		return rsltRtRoutDirCallListVOS;
	}

	public void setRsltRtRoutDirCallListVOS(List<RsltRtRoutDirCallListVO> rsltRtRoutDirCallListVOS) {
		this.rsltRtRoutDirCallListVOS = rsltRtRoutDirCallListVOS;
	}

}
