/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MtyBookingCreateVO.java
*@FileTitle : MtyBookingCreateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.28 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;

public class MtyBookingCreateVO {
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
	private MtyBookingVO mtyBookingVO = null;

	public void setMtyBookingVO(MtyBookingVO mtyBookingVO) {
		this.mtyBookingVO = mtyBookingVO;
	}

	public MtyBookingVO getMtyBookingVO() {
		return mtyBookingVO;
	}
	/* MtyBookingVO End  */	
	/* MtyCntrVO Start  */
	private MtyCntrVO[] mtyCntrVOs = null;

	public void setMtyCntrVOs(MtyCntrVO[] mtyCntrVOs) {
		this.mtyCntrVOs = mtyCntrVOs;
	}

	public MtyCntrVO[] getMtyCntrVOs() {
		return mtyCntrVOs;
	}
	/* MtyCntrVO End  */	
	/* MtyQtyVO Start  */
	private MtyQtyVO[] mtyQtyVOs = null;

	public void setMtyQtyVOs(MtyQtyVO[] mtyQtyVOs) {
		this.mtyQtyVOs = mtyQtyVOs;
	}

	public MtyQtyVO[] getMtyQtyVOs() {
		return mtyQtyVOs;
	}
	/* MtyQtyVO End  */		
	/* MtyVvdVO Start  */
	private MtyVvdVO[] mtyVvdVOs = null;

	public void setMtyVvdVOs(MtyVvdVO[] mtyVvdVOs) {
		this.mtyVvdVOs = mtyVvdVOs;
	}

	public MtyVvdVO[] getMtyVvdVOs() {
		return mtyVvdVOs;
	}
	/* MtyVvdVO End  */			
}
