/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlCustomerVO.java
*@FileTitle : BlCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.12 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SplitMstBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;

public class BlCustomerVO {
	/* SplitMstBlNoVO Start  */
	List<SplitMstBlNoVO> splitMstBlNo 	= new ArrayList<SplitMstBlNoVO>();
	private SplitMstBlNoVO splitMstBlNoVO = null;
	private SplitMstBlNoVO[] splitMstBlNoVOs = null;

	public void setSplitMstBlNoVOs(SplitMstBlNoVO[] splitMstBlNoVOs) {
		this.splitMstBlNoVOs = splitMstBlNoVOs;
	}

	public SplitMstBlNoVO[] getSplitMstBlNoVOs() {
		return splitMstBlNoVOs;
	}

	public void setSplitMstBlNoVO(SplitMstBlNoVO splitMstBlNoVO) {
		this.splitMstBlNoVO = splitMstBlNoVO;
	}

	public SplitMstBlNoVO getSplitMstBlNoVO() {
		return splitMstBlNoVO;
	}

	public List<SplitMstBlNoVO> getSplitMstBlNo() {
		return splitMstBlNo;
	}

	public void setSplitMstBlNo(List<SplitMstBlNoVO> splitMstBlNo) {
		this.splitMstBlNo = splitMstBlNo;
	}
	/* SplitMstBlNoVO End  */
	/* BlDocCustVO Start  */
	List<BlDocCustVO> blDocCust 	= new ArrayList<BlDocCustVO>();
	private BlDocCustVO blDocCustVO = null;
	private BlDocCustVO[] blDocCustVOs = null;

	public void setBlDocCustVOs(BlDocCustVO[] blDocCustVOs) {
		this.blDocCustVOs = blDocCustVOs;
	}

	public BlDocCustVO[] getBlDocCustVOs() {
		return blDocCustVOs;
	}

	public void setBlDocCustVO(BlDocCustVO blDocCustVO) {
		this.blDocCustVO = blDocCustVO;
	}

	public BlDocCustVO getBlDocCustVO() {
		return blDocCustVO;
	}

	public List<BlDocCustVO> getBlDocCust() {
		return blDocCust;
	}

	public void setBlDocCust(List<BlDocCustVO> blDocCust) {
		this.blDocCust = blDocCust;
	}
	/* BlDocCustVO End  */		
	/* CustEtcVO Start  */
	List<CustEtcVO> custEtc 	= new ArrayList<CustEtcVO>();
	private CustEtcVO custEtcVO = null;
	private CustEtcVO[] custEtcVOs = null;

	public void setCustEtcVOs(CustEtcVO[] custEtcVOs) {
		this.custEtcVOs = custEtcVOs;
	}

	public CustEtcVO[] getCustEtcVOs() {
		return custEtcVOs;
	}

	public void setCustEtcVO(CustEtcVO custEtcVO) {
		this.custEtcVO = custEtcVO;
	}

	public CustEtcVO getCustEtcVO() {
		return custEtcVO;
	}

	public List<CustEtcVO> getCustEtc() {
		return custEtc;
	}

	public void setCustEtc(List<CustEtcVO> custEtc) {
		this.custEtc = custEtc;
	}
	/* CustEtcVO End  */	
	/* BkgBlNoVO Start  */
	List<BkgBlNoVO> bkgBlNo 	= new ArrayList<BkgBlNoVO>();
	private BkgBlNoVO bkgBlNoVO = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		return bkgBlNoVOs;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public List<BkgBlNoVO> getBkgBlNo() {
		return bkgBlNo;
	}

	public void setBkgBlNo(List<BkgBlNoVO> bkgBlNo) {
		this.bkgBlNo = bkgBlNo;
	}
	/* BkgBlNoVO End  */	
}
