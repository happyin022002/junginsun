/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingCopyVO.java
*@FileTitle : BookingCopyVO
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

public class BookingCopyVO {
	/* BkgForCopyVO Start  */
	List<BkgForCopyVO> bkgForCopy 	= new ArrayList<BkgForCopyVO>();
	private BkgForCopyVO bkgForCopyVO = null;
	private BkgForCopyVO[] bkgForCopyVOs = null;

	public void setBkgForCopyVOs(BkgForCopyVO[] bkgForCopyVOs) {
		this.bkgForCopyVOs = bkgForCopyVOs;
	}

	public BkgForCopyVO[] getBkgForCopyVOs() {
		return bkgForCopyVOs;
	}

	public void setBkgForCopyVO(BkgForCopyVO bkgForCopyVO) {
		this.bkgForCopyVO = bkgForCopyVO;
	}

	public BkgForCopyVO getBkgForCopyVO() {
		return bkgForCopyVO;
	}

	public List<BkgForCopyVO> getBkgForCopy() {
		return bkgForCopy;
	}

	public void setBkgForCopy(List<BkgForCopyVO> bkgForCopy) {
		this.bkgForCopy = bkgForCopy;
	}
	/* BkgForCopyVO End  */
	
	/* BlCustomerInfoVO Start  */
	List<BlCustomerInfoVO> blCustomerInfo 	= new ArrayList<BlCustomerInfoVO>();
	private BlCustomerInfoVO blCustomerInfoVO = null;
	private BlCustomerInfoVO[] blCustomerInfoVOs = null;

	public void setBlCustomerInfoVOs(BlCustomerInfoVO[] blCustomerInfoVOs) {
		this.blCustomerInfoVOs = blCustomerInfoVOs;
	}

	public BlCustomerInfoVO[] getBlCustomerInfoVOs() {
		return blCustomerInfoVOs;
	}

	public void setBlCustomerInfoVO(BlCustomerInfoVO blCustomerInfoVO) {
		this.blCustomerInfoVO = blCustomerInfoVO;
	}

	public BlCustomerInfoVO getBlCustomerInfoVO() {
		return blCustomerInfoVO;
	}

	public List<BlCustomerInfoVO> getBlCustomerInfo() {
		return blCustomerInfo;
	}

	public void setBlCustomerInfo(List<BlCustomerInfoVO> blCustomerInfo) {
		this.blCustomerInfo = blCustomerInfo;
	}
	/* BlCustomerInfoVO End  */
	
	/* VslSkdVO Start  */
	List<VslSkdVO> vslSkd 	= new ArrayList<VslSkdVO>();
	private VslSkdVO vslSkdVO = null;
	private VslSkdVO[] vslSkdVOs = null;

	public void setVslSkdVOs(VslSkdVO[] vslSkdVOs) {
		this.vslSkdVOs = vslSkdVOs;
	}

	public VslSkdVO[] getVslSkdVOs() {
		return vslSkdVOs;
	}

	public void setVslSkdVO(VslSkdVO vslSkdVO) {
		this.vslSkdVO = vslSkdVO;
	}

	public VslSkdVO getVslSkdVO() {
		return vslSkdVO;
	}

	public List<VslSkdVO> getVslSkd() {
		return vslSkd;
	}

	public void setVslSkd(List<VslSkdVO> vslSkd) {
		this.vslSkd = vslSkd;
	}
	/* BkgVvdVO End  */	
	/* BkgBlNoVO Start  */
	private BkgBlNoVO bkgBlNoVO = null;

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	/* BkgBlNoVO End  */	
}
