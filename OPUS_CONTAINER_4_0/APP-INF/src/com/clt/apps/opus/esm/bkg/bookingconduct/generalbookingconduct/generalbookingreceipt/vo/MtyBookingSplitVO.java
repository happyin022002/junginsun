/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MtyBookingSplitVO.java
*@FileTitle : MtyBookingSplitVO
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

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;

public class MtyBookingSplitVO {
	/* BkgBlNoVO Start  */
	private BkgBlNoVO bkgBlNoVO = null;

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	/* BkgBlNoVO End  */	
	/* MtyBookingVO Start  */
	List<MtyBookingVO> mtyBooking 	= new ArrayList<MtyBookingVO>();
	private MtyBookingVO mtyBookingVO = null;
	private MtyBookingVO[] mtyBookingVOs = null;

	public void setMtyBookingVOs(MtyBookingVO[] mtyBookingVOs) {
		this.mtyBookingVOs = mtyBookingVOs;
	}

	public MtyBookingVO[] getMtyBookingVOs() {
		return mtyBookingVOs;
	}

	public void setMtyBookingVO(MtyBookingVO mtyBookingVO) {
		this.mtyBookingVO = mtyBookingVO;
	}

	public MtyBookingVO getMtyBookingVO() {
		return mtyBookingVO;
	}

	public List<MtyBookingVO> geMtyBooking() {
		return mtyBooking;
	}

	public void setMtyBooking(List<MtyBookingVO> mtyBooking) {
		this.mtyBooking = mtyBooking;
	}
	/* MtyBookingVO End  */	
	/* MtyCntrVO Start  */
	List<MtyCntrVO> mtyCntr 	= new ArrayList<MtyCntrVO>();
	private MtyCntrVO mtyCntrVO = null;
	private MtyCntrVO[] mtyCntrVOs = null;

	public void setMtyCntrVOs(MtyCntrVO[] mtyCntrVOs) {
		this.mtyCntrVOs = mtyCntrVOs;
	}

	public MtyCntrVO[] getMtyCntrVOs() {
		return mtyCntrVOs;
	}

	public void setMtyCntrVO(MtyCntrVO mtyCntrVO) {
		this.mtyCntrVO = mtyCntrVO;
	}

	public MtyCntrVO getMtyCntrVO() {
		return mtyCntrVO;
	}

	public List<MtyCntrVO> geMtyCntr() {
		return mtyCntr;
	}

	public void setMtyCntr(List<MtyCntrVO> mtyCntr) {
		this.mtyCntr = mtyCntr;
	}
	/* MtyCntrVO End  */
	/* MtyVvdVO Start  */
	List<MtyVvdVO> mtyVvd 	= new ArrayList<MtyVvdVO>();
	private MtyVvdVO mtyVvdVO = null;
	private MtyVvdVO[] mtyVvdVOs = null;

	public void setMtyVvdVOs(MtyVvdVO[] mtyVvdVOs) {
		this.mtyVvdVOs = mtyVvdVOs;
	}

	public MtyVvdVO[] getMtyVvdVOs() {
		return mtyVvdVOs;
	}

	public void setMtyVvdVO(MtyVvdVO mtyVvdVO) {
		this.mtyVvdVO = mtyVvdVO;
	}

	public MtyVvdVO getMtyVvdVO() {
		return mtyVvdVO;
	}

	public List<MtyVvdVO> geMtyVvd() {
		return mtyVvd;
	}

	public void setMtyVvd(List<MtyVvdVO> mtyVvd) {
		this.mtyVvd = mtyVvd;
	}
	/* MtyVvdVO End  */			
	/* NewBkgSplitVO Start  */
	List<NewBkgSplitVO> newBkgSplit 	= new ArrayList<NewBkgSplitVO>();
	private NewBkgSplitVO newBkgSplitVO = null;
	private NewBkgSplitVO[] newBkgSplitVOs = null;

	public void setNewBkgSplits(NewBkgSplitVO[] newBkgSplitVOs) {
		this.newBkgSplitVOs = newBkgSplitVOs;
	}

	public NewBkgSplitVO[] getNewBkgSplitVOs() {
		return newBkgSplitVOs;
	}

	public void setNewBkgSplitVO(NewBkgSplitVO newBkgSplitVO) {
		this.newBkgSplitVO = newBkgSplitVO;
	}

	public NewBkgSplitVO getNewBkgSplitVO() {
		return newBkgSplitVO;
	}

	public List<NewBkgSplitVO> geNewBkgSplit() {
		return newBkgSplit;
	}

	public void setNewBkgSplit(List<NewBkgSplitVO> newBkgSplit) {
		this.newBkgSplit = newBkgSplit;
	}
	/* NewBkgSplitVO End  */			
}
