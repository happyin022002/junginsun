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

public class SoInfoVO {

    private TopBlInfoVO bkgInfoVO;
	private List<TpszQtyVO> tpszQtyVOs;
	private List<CntrSoVO> cntrSoVOs;
	private List<CntrSoDtlVO> cntrSoDtlVOs;
	private String blNo = null;
	private String bkgStsCd = null;
	private String bkgNo = null;
	private List<UsCntrSoDtlInfosVO> usCntrSoDtlInfosVOs;
	private List<UsCntrSoInfosVO> usCntrSoInfosVOs;
	
	public List<TpszQtyVO> getTpszQtyVOs() {
		return tpszQtyVOs;
	}
	public void setTpszQtyVOs(List<TpszQtyVO> tpszQtyVOs) {
		this.tpszQtyVOs = tpszQtyVOs;
	}
	public List<CntrSoVO> getCntrSoVOs() {
		return cntrSoVOs;
	}
	public void setCntrSoVOs(List<CntrSoVO> cntrSoVOs) {
		this.cntrSoVOs = cntrSoVOs;
	}
	public List<CntrSoDtlVO> getCntrSoDtlVOs() {
		return cntrSoDtlVOs;
	}
	public void setCntrSoDtlVOs(List<CntrSoDtlVO> cntrSoDtlVOs) {
		this.cntrSoDtlVOs = cntrSoDtlVOs;
	}
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	public List<UsCntrSoDtlInfosVO> getUsCntrSoDtlInfosVOs() {
		return usCntrSoDtlInfosVOs;
	}
	public void setUsCntrSoDtlInfosVOs(List<UsCntrSoDtlInfosVO> usCntrSoDtlInfosVOs) {
		this.usCntrSoDtlInfosVOs = usCntrSoDtlInfosVOs;
	}
	public List<UsCntrSoInfosVO> getUsCntrSoInfosVOs() {
		return usCntrSoInfosVOs;
	}
	public void setUsCntrSoInfosVOs(List<UsCntrSoInfosVO> usCntrSoInfosVOs) {
		this.usCntrSoInfosVOs = usCntrSoInfosVOs;
	}

	
}
