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

package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo;

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

public class RsltGriCalcListVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<RsltGriCalcCmdtListVO> rsltGriCalcCmdtListVOS = null;
	private List<RsltGriCalcActCustListVO> rsltGriCalcActCustListVOS = null;
	private List<RsltGriCalcOrgPntListVO> rsltGriCalcOrgPntListVOS = null;
	private List<RsltGriCalcOrgViaListVO> rsltGriCalcOrgViaListVOS = null;
	private List<RsltGriCalcDestViaListVO> rsltGriCalcDestViaListVOS = null;
	private List<RsltGriCalcDestPntListVO> rsltGriCalcDestPntListVOS = null;
	private List<RsltGriCalcRtListVO> rsltGriCalcRtListVOS = null;

	public List<RsltGriCalcCmdtListVO> getRsltGriCalcCmdtListVOS() {
		return rsltGriCalcCmdtListVOS;
	}

	public void setRsltGriCalcCmdtListVOS(List<RsltGriCalcCmdtListVO> rsltGriCalcCmdtListVOS) {
		this.rsltGriCalcCmdtListVOS = rsltGriCalcCmdtListVOS;
	}

	public List<RsltGriCalcActCustListVO> getRsltGriCalcActCustListVOS() {
		return rsltGriCalcActCustListVOS;
	}

	public void setRsltGriCalcActCustListVOS(List<RsltGriCalcActCustListVO> rsltGriCalcActCustListVOS) {
		this.rsltGriCalcActCustListVOS = rsltGriCalcActCustListVOS;
	}

	public List<RsltGriCalcOrgPntListVO> getRsltGriCalcOrgPntListVOS() {
		return rsltGriCalcOrgPntListVOS;
	}

	public void setRsltGriCalcOrgPntListVOS(List<RsltGriCalcOrgPntListVO> rsltGriCalcOrgPntListVOS) {
		this.rsltGriCalcOrgPntListVOS = rsltGriCalcOrgPntListVOS;
	}

	public List<RsltGriCalcOrgViaListVO> getRsltGriCalcOrgViaListVOS() {
		return rsltGriCalcOrgViaListVOS;
	}

	public void setRsltGriCalcOrgViaListVOS(List<RsltGriCalcOrgViaListVO> rsltGriCalcOrgViaListVOS) {
		this.rsltGriCalcOrgViaListVOS = rsltGriCalcOrgViaListVOS;
	}

	public List<RsltGriCalcDestViaListVO> getRsltGriCalcDestViaListVOS() {
		return rsltGriCalcDestViaListVOS;
	}

	public void setRsltGriCalcDestViaListVOS(List<RsltGriCalcDestViaListVO> rsltGriCalcDestViaListVOS) {
		this.rsltGriCalcDestViaListVOS = rsltGriCalcDestViaListVOS;
	}

	public List<RsltGriCalcDestPntListVO> getRsltGriCalcDestPntListVOS() {
		return rsltGriCalcDestPntListVOS;
	}

	public void setRsltGriCalcDestPntListVOS(List<RsltGriCalcDestPntListVO> rsltGriCalcDestPntListVOS) {
		this.rsltGriCalcDestPntListVOS = rsltGriCalcDestPntListVOS;
	}

	public List<RsltGriCalcRtListVO> getRsltGriCalcRtListVOS() {
		return rsltGriCalcRtListVOS;
	}

	public void setRsltGriCalcRtListVOS(List<RsltGriCalcRtListVO> rsltGriCalcRtListVOS) {
		this.rsltGriCalcRtListVOS = rsltGriCalcRtListVOS;
	}

}
