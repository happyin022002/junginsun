/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyBkgListInqVO.java
*@FileTitle : EmptyBkgListInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.12 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

import java.util.ArrayList;
import java.util.List;

public class EmptyBkgListInqVO {
	/* EmptyBkgListVO Start  */
	List<EmptyBkgListVO> emptyBkgList 	= new ArrayList<EmptyBkgListVO>();
	private EmptyBkgListVO emptyBkgListVO = null;
	private EmptyBkgListVO[] emptyBkgListVOs = null;

	public void setEmptyBkgListVOs(EmptyBkgListVO[] emptyBkgListVOs) {
		this.emptyBkgListVOs = emptyBkgListVOs;
	}

	public EmptyBkgListVO[] getEmptyBkgListVOs() {
		return emptyBkgListVOs;
	}

	public void setEmptyBkgListVO(EmptyBkgListVO emptyBkgListVO) {
		this.emptyBkgListVO = emptyBkgListVO;
	}

	public EmptyBkgListVO getEmptyBkgListVO() {
		return emptyBkgListVO;
	}

	public List<EmptyBkgListVO> getEmptyBkgList() {
		return emptyBkgList;
	}

	public void setEmptyBkgList(List<EmptyBkgListVO> emptyBkgList) {
		this.emptyBkgList = emptyBkgList;
	}
	/* EmptyBkgListVO End  */		
	
	/* EmptyCntrSumVO Start  */
	private EmptyCntrSumVO emptyCntrSumVO = null;

	public void setEmptyCntrSumVO(EmptyCntrSumVO emptyCntrSumVO) {
		this.emptyCntrSumVO = emptyCntrSumVO;
	}

	public EmptyCntrSumVO getEmptyCntrSumVO() {
		return emptyCntrSumVO;
	}
	/* EmptyCntrSumVO End  */	
}
