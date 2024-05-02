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

public class PkupNtcInfoVO {

	private List<BlCustInfoVO> blCustInfoVOs;
	private TopBlInfoVO bkgInfoVO;
	private List<PkupNtcCneeInfoVO> pkupNtcCneeInfoVOs;
	private List<PkupNtcNtfyInfoVO> pkupNtcNtfyInfoVOs;
	private String bkgNo = null;

	
	
	public List<BlCustInfoVO> getBlCustInfoVOs() {
		return blCustInfoVOs;
	}
	public void setBlCustInfoVOs(List<BlCustInfoVO> blCustInfoVOs) {
		this.blCustInfoVOs = blCustInfoVOs;
	}


	public TopBlInfoVO getBkgInfoVO() {
		return bkgInfoVO;
	}
	public void setBkgInfoVO(TopBlInfoVO bkgInfoVO) {
		this.bkgInfoVO = bkgInfoVO;
	}
	public List<PkupNtcCneeInfoVO> getPkupNtcCneeInfoVOs() {
		return pkupNtcCneeInfoVOs;
	}
	public void setPkupNtcCneeInfoVOs(List<PkupNtcCneeInfoVO> pkupNtcCneeInfoVOs) {
		this.pkupNtcCneeInfoVOs = pkupNtcCneeInfoVOs;
	}
	public List<PkupNtcNtfyInfoVO> getPkupNtcNtfyInfoVOs() {
		return pkupNtcNtfyInfoVOs;
	}
	public void setPkupNtcNtfyInfoVOs(List<PkupNtcNtfyInfoVO> pkupNtcNtfyInfoVOs) {
		this.pkupNtcNtfyInfoVOs = pkupNtcNtfyInfoVOs;
	}
	public String getBkgNo() {
		return bkgNo;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}	
}
