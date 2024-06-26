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

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

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

public class RsltRtCmdtRoutListVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<RsltRtCmdtHdrListVO> rsltRtCmdtHdrListVOS = null;
	private List<RsltRtRoutHdrListVO> rsltRtRoutHdrListVOS = null;
	
	/**
	 * @return the rsltRtCmdtHdrListVOS
	 */
	public List<RsltRtCmdtHdrListVO> getRsltRtCmdtHdrListVOS() {
		return rsltRtCmdtHdrListVOS;
	}
	
	/**
	 * @param rsltRtCmdtHdrListVOS the rsltRtCmdtHdrListVOS to set
	 */
	public void setRsltRtCmdtHdrListVOS(List<RsltRtCmdtHdrListVO> rsltRtCmdtHdrListVOS) {
		this.rsltRtCmdtHdrListVOS = rsltRtCmdtHdrListVOS;
	}
	
	/**
	 * @return the rsltRtRoutHdrListVOS
	 */
	public List<RsltRtRoutHdrListVO> getRsltRtRoutHdrListVOS() {
		return rsltRtRoutHdrListVOS;
	}
	
	/**
	 * @param rsltRtRoutHdrListVOS the rsltRtRoutHdrListVOS to set
	 */
	public void setRsltRtRoutHdrListVOS(List<RsltRtRoutHdrListVO> rsltRtRoutHdrListVOS) {
		this.rsltRtRoutHdrListVOS = rsltRtRoutHdrListVOS;
	}

}
