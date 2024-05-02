/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BkgCmpbVO.java
 *@FileTitle : BkgCmpbVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.12.03  
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.12.03  
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgRevCostVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgCmpbVO {

	private BkgRevCostVO bkgRevCostVO = null;
	private List<BkgChgRateVO> bkgChgRateVOs = null;
	private String diffFlg =""; 
	
	public void setBkgRevCostVO(BkgRevCostVO bkgRevCostVO) {
		this.bkgRevCostVO = bkgRevCostVO;
	}

	public BkgRevCostVO getBkgRevCostVO() {
		return bkgRevCostVO;
	}
	
	/**
	 * @return the bkgChgRateVOs
	 */
	public List<BkgChgRateVO> getBkgChgRateVOs() {
		return bkgChgRateVOs;
	}

	/**
	 * @param bkgChgRateVOs
	 *            the bkgChgRateVOs to set
	 */
	public void setBkgChgRateVOs(List<BkgChgRateVO> bkgChgRateVOs) {
		this.bkgChgRateVOs = bkgChgRateVOs;
	}
	
	/**
	 * @return the diffFlg
	 */
	public String getDiffFlg() {
		return diffFlg;
	}
	/**
	 * @param diffFlg the diffFlg to set
	 */
	public void setDiffFlg(String diffFlg) {
		this.diffFlg = diffFlg;
	}




}