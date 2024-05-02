/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltTriPropDtlListVO.java
 *@FileTitle : RsltTriPropDtlListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.04 박성수 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.triproposal.triproposal.vo;

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

public class RsltTriPropDtlListVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<RsltTriRtListVO> rsltTriRtListVOS = null;
	private List<RsltTriRoutOrgPntVO> rsltTriRoutOrgPntVOS = null;
	private List<RsltTriRoutOrgViaVO> rsltTriRoutOrgViaVOS = null;
	private List<RsltTriRoutDestViaVO> rsltTriRoutDestViaVOS = null;
	private List<RsltTriRoutDestPntVO> rsltTriRoutDestPntVOS = null;
	private List<RsltPriTriNoteConvVO> rsltPriTriNoteConvVO = null;
	
	/**
	 * @return the rsltTriRtListVOS
	 */
	public List<RsltTriRtListVO> getRsltTriRtListVOS() {
		return rsltTriRtListVOS;
	}
	
	/**
	 * @param rsltTriRtListVOS the rsltTriRtListVOS to set
	 */
	public void setRsltTriRtListVOS(List<RsltTriRtListVO> rsltTriRtListVOS) {
		this.rsltTriRtListVOS = rsltTriRtListVOS;
	}
	
	/**
	 * @return the rsltTriRoutOrgPntVOS
	 */
	public List<RsltTriRoutOrgPntVO> getRsltTriRoutOrgPntVOS() {
		return rsltTriRoutOrgPntVOS;
	}
	
	/**
	 * @param rsltTriRoutOrgPntVOS the rsltTriRoutOrgPntVOS to set
	 */
	public void setRsltTriRoutOrgPntVOS(List<RsltTriRoutOrgPntVO> rsltTriRoutOrgPntVOS) {
		this.rsltTriRoutOrgPntVOS = rsltTriRoutOrgPntVOS;
	}
	
	/**
	 * @return the rsltTriRoutOrgViaVOS
	 */
	public List<RsltTriRoutOrgViaVO> getRsltTriRoutOrgViaVOS() {
		return rsltTriRoutOrgViaVOS;
	}
	
	/**
	 * @param rsltTriRoutOrgViaVOS the rsltTriRoutOrgViaVOS to set
	 */
	public void setRsltTriRoutOrgViaVOS(List<RsltTriRoutOrgViaVO> rsltTriRoutOrgViaVOS) {
		this.rsltTriRoutOrgViaVOS = rsltTriRoutOrgViaVOS;
	}
	
	/**
	 * @return the rsltTriRoutDestViaVOS
	 */
	public List<RsltTriRoutDestViaVO> getRsltTriRoutDestViaVOS() {
		return rsltTriRoutDestViaVOS;
	}
	
	/**
	 * @param rsltTriRoutDestViaVOS the rsltTriRoutDestViaVOS to set
	 */
	public void setRsltTriRoutDestViaVOS(List<RsltTriRoutDestViaVO> rsltTriRoutDestViaVOS) {
		this.rsltTriRoutDestViaVOS = rsltTriRoutDestViaVOS;
	}
	
	/**
	 * @return the rsltTriRoutDestPntVOS
	 */
	public List<RsltTriRoutDestPntVO> getRsltTriRoutDestPntVOS() {
		return rsltTriRoutDestPntVOS;
	}
	
	/**
	 * @param rsltTriRoutDestPntVOS the rsltTriRoutDestPntVOS to set
	 */
	public void setRsltTriRoutDestPntVOS(List<RsltTriRoutDestPntVO> rsltTriRoutDestPntVOS) {
		this.rsltTriRoutDestPntVOS = rsltTriRoutDestPntVOS;
	}

	/**
	 * @return the rsltPriTriNoteConvVO
	 */
	public List<RsltPriTriNoteConvVO> getRsltPriTriNoteConvVO() {
		return rsltPriTriNoteConvVO;
	}

	/**
	 * @param rsltPriTriNoteConvVO the rsltPriTriNoteConvVO to set
	 */
	public void setRsltPriTriNoteConvVO(List<RsltPriTriNoteConvVO> rsltPriTriNoteConvVO) {
		this.rsltPriTriNoteConvVO = rsltPriTriNoteConvVO;
	}

}
