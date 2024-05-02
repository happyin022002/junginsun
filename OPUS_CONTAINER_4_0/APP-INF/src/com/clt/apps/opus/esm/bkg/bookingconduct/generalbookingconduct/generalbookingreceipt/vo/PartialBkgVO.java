/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartialBkgVO.java
*@FileTitle : PartialBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.12 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.framework.component.rowset.DBRowSet;

public class PartialBkgVO {
	/* PartialBkgInfoVO Start  */
	List<PartialBkgInfoVO> partialBkgInfo 	= new ArrayList<PartialBkgInfoVO>();
	private PartialBkgInfoVO partialBkgInfoVO = null;
	private PartialBkgInfoVO[] partialBkgInfoVOs = null;

	public void setSplitMstBlNoVOs(PartialBkgInfoVO[] partialBkgInfoVOs) {
		this.partialBkgInfoVOs = partialBkgInfoVOs;
	}

	public PartialBkgInfoVO[] getPartialBkgInfoVOs() {
		return partialBkgInfoVOs;
	}

	public void setPartialBkgInfoVO(PartialBkgInfoVO partialBkgInfoVO) {
		this.partialBkgInfoVO = partialBkgInfoVO;
	}

	public PartialBkgInfoVO getPartialBkgInfoVO() {
		return partialBkgInfoVO;
	}

	public List<PartialBkgInfoVO> getPartialBkgInfo() {
		return partialBkgInfo;
	}

	public void setPartialBkgInfo(List<PartialBkgInfoVO> partialBkgInfo) {
		this.partialBkgInfo = partialBkgInfo;
	}
	/* PartialBkgInfoVO End  */
	
	/* PartialBkgCntr RowSet Start  */
	private DBRowSet partialBkgCntrRS = null;
	
	public void setPartialBkgCntrRS(DBRowSet partialBkgCntrRS) {
		this.partialBkgCntrRS = partialBkgCntrRS;
	}
	
	public DBRowSet getPartialBkgCntrRS() {
		return partialBkgCntrRS;
	}
	
	/* PartialBkgCntr RowSet End  */
	
	List<String> cntrNoList = new ArrayList<String>();
	public List<String> getCntrNoList() {
		return cntrNoList;
	}

	public void setCntrNoList(List<String> cntrNoList) {
		this.cntrNoList = cntrNoList;
	}	
}
