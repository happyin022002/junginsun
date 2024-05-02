/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlInfoVO.java
*@FileTitle : BlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.07.08 안진응 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 안진응
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrMvntVO {

	private TopBlInfoVO bkgInfoVO;
	private List<CntrMvntDtlsVO> cntrMvntDtlsVOs;
	private String cntrNo = null;
	private String bkgStsCd = null;
	private String bkgNo = null;
	private List<CntrMvntMstsVO> cntrMvntMstsVOs;
	private List<CntrUsMvntDtlsVO> cntrUsMvntDtlsVOs;
	private List<CntrClmInfosVO> cntrClmInfosVOs;
	/**
	 * @return the cntrMvntDtlsVOs
	 */
	public List<CntrMvntDtlsVO> getCntrMvntDtlsVOs() {
		return cntrMvntDtlsVOs;
	}
	/**
	 * @param cntrMvntDtlsVOs the cntrMvntDtlsVOs to set
	 */
	public void setCntrMvntDtlsVOs(List<CntrMvntDtlsVO> cntrMvntDtlsVOs) {
		this.cntrMvntDtlsVOs = cntrMvntDtlsVOs;
	}
	/**
	 * @return the cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}
	/**
	 * @param cntrNo the cntrNo to set
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public TopBlInfoVO getBkgInfoVO() {
		return bkgInfoVO;
	}
	public void setBkgInfoVO(TopBlInfoVO bkgInfoVO) {
		this.bkgInfoVO = bkgInfoVO;
	}
	public String getBkgStsCd() {
		return bkgStsCd;
	}
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	public String getBkgNo() {
		return bkgNo;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	public List<CntrMvntMstsVO> getCntrMvntMstsVOs() {
		return cntrMvntMstsVOs;
	}
	public void setCntrMvntMstsVOs(List<CntrMvntMstsVO> cntrMvntMstsVOs) {
		this.cntrMvntMstsVOs = cntrMvntMstsVOs;
	}
	public List<CntrUsMvntDtlsVO> getCntrUsMvntDtlsVOs() {
		return cntrUsMvntDtlsVOs;
	}
	public void setCntrUsMvntDtlsVOs(List<CntrUsMvntDtlsVO> cntrUsMvntDtlsVOs) {
		this.cntrUsMvntDtlsVOs = cntrUsMvntDtlsVOs;
	}
	public List<CntrClmInfosVO> getCntrClmInfosVOs() {
		return cntrClmInfosVOs;
	}
	public void setCntrClmInfosVOs(List<CntrClmInfosVO> cntrClmInfosVOs) {
		this.cntrClmInfosVOs = cntrClmInfosVOs;
	}
	
	
}
