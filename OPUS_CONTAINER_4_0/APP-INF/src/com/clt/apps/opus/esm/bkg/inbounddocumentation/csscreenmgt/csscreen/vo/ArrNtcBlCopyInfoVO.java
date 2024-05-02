/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrNtcBlCopyInfoVO.java
*@FileTitle : ArrNtcBlCopyInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArrNtcBlCopyInfoVO {

	private ArrNtcBlCopyBkgInfoVO arrNtcBlCopyBkgInfoVO;
	private BkgInfoVO bkgInfoVO;
	private List<ArrNtcBlCopyFaxInfoVO> arrNtcBlCopyFaxInfoVOs;
	private List<ArrNtcBlCopyMailInfoVO> arrNtcBlCopyMailInfoVOs;
	private String bkgNo = null;

	public ArrNtcBlCopyBkgInfoVO getArrNtcBlCopyBkgInfoVO() {
		return arrNtcBlCopyBkgInfoVO;
	}
	public void setArrNtcBlCopyBkgInfoVO(ArrNtcBlCopyBkgInfoVO arrNtcBlCopyBkgInfoVO) {
		this.arrNtcBlCopyBkgInfoVO = arrNtcBlCopyBkgInfoVO;
	}
	public List<ArrNtcBlCopyFaxInfoVO> getArrNtcBlCopyFaxInfoVOs() {
		return arrNtcBlCopyFaxInfoVOs;
	}
	public void setArrNtcBlCopyFaxInfoVOs(
			List<ArrNtcBlCopyFaxInfoVO> arrNtcBlCopyFaxInfoVOs) {
		this.arrNtcBlCopyFaxInfoVOs = arrNtcBlCopyFaxInfoVOs;
	}
	public List<ArrNtcBlCopyMailInfoVO> getArrNtcBlCopyMailInfoVOs() {
		return arrNtcBlCopyMailInfoVOs;
	}
	public void setArrNtcBlCopyMailInfoVOs(
			List<ArrNtcBlCopyMailInfoVO> arrNtcBlCopyMailInfoVOs) {
		this.arrNtcBlCopyMailInfoVOs = arrNtcBlCopyMailInfoVOs;
	}
	public String getBkgNo() {
		return bkgNo;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	public BkgInfoVO getBkgInfoVO() {
		return bkgInfoVO;
	}
	public void setBkgInfoVO(BkgInfoVO bkgInfoVO) {
		this.bkgInfoVO = bkgInfoVO;
	}

	
}
