/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdParameterVO.java
*@FileTitle : PrdParameterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.12 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo;

import java.util.ArrayList;
import java.util.List;

public class PrdParameterVO {
	/* PrdQtyInfoVO */
	List<PrdQtyInfoVO> prdQtyInfo 	= new ArrayList<PrdQtyInfoVO>();
	private PrdQtyInfoVO prdQtyInfoVO = null;
	private PrdQtyInfoVO[] prdQtyInfoVOs = null;

	/* PrdMainInfoVO */
	private PrdMainInfoVO prdMainInfoVO = null;

	/* BkgBlNoVO */
	private BkgBlNoVO bkgBlNoVO = null;
	
	/* TroInfoVO */
	private PrdTroInfoVO prdTroInfoVO = null;
	
	
	
	public void setPrdQtyInfoVOs(PrdQtyInfoVO[] prdQtyInfoVOs) {
		this.prdQtyInfoVOs = prdQtyInfoVOs;
	}

	public PrdQtyInfoVO[] getPrdQtyInfoVOs() {
		return prdQtyInfoVOs;
	}

	public void setPrdQtyInfoVO(PrdQtyInfoVO prdQtyInfoVO) {
		this.prdQtyInfoVO = prdQtyInfoVO;
	}

	public PrdQtyInfoVO getPrdQtyInfoVO() {
		return prdQtyInfoVO;
	}

	public List<PrdQtyInfoVO> getPrdQtyInfo() {
		return prdQtyInfo;
	}

	public void setPrdQtyInfo(List<PrdQtyInfoVO> prdQtyInfo) {
		this.prdQtyInfo = prdQtyInfo;
	}
		
	public void setPrdMainInfoVO(PrdMainInfoVO prdMainInfoVO) {
		this.prdMainInfoVO = prdMainInfoVO;
	}

	public PrdMainInfoVO getPrdMainInfoVO() {
		return prdMainInfoVO;
	}	

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	/**
	 * @return the prdTroInfoVO
	 */
	public PrdTroInfoVO getPrdTroInfoVO() {
		return prdTroInfoVO;
	}

	/**
	 * @param prdTroInfoVO the prdTroInfoVO to set
	 */
	public void setPrdTroInfoVO(PrdTroInfoVO prdTroInfoVO) {
		this.prdTroInfoVO = prdTroInfoVO;
	}	
}
