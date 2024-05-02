package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

import java.util.List;

public class BkgReceiptListVO {
	private List<BkgListForBkgReceiptVO> bkgListForBkgReceiptVOs = null;
	private List<BkgListForBkgReceiptCntVO> bkgListForBkgReceiptCntVOs = null;
	
	public void setBkgListForBkgReceiptVOs(List<BkgListForBkgReceiptVO> bkgListForBkgReceiptVOs) {
		this.bkgListForBkgReceiptVOs = bkgListForBkgReceiptVOs;
	}

	public List<BkgListForBkgReceiptVO> getBkgListForBkgReceiptVOs() {
		return bkgListForBkgReceiptVOs;
	}
	public void setBkgListForBkgReceiptCntVOs(List<BkgListForBkgReceiptCntVO> bkgListForBkgReceiptCntVOs) {
		this.bkgListForBkgReceiptCntVOs = bkgListForBkgReceiptCntVOs;
	}

	public List<BkgListForBkgReceiptCntVO> getBkgListForBkgReceiptCntVOs() {
		return bkgListForBkgReceiptCntVOs;
	}
}
