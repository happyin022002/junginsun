/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingCreationVO.java
*@FileTitle : BookingCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.12 김병규
* 1.0 Creation
* -------------------------------------------------------
* HISTORY
* 2010.10.12 김영철 [CHM-201006332-01] PSA AUTO EDI 수정 요청 (Special Cargo 정보 자동 전송 및 WARNING 메세지 추가)
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SplitMstBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SplitNoVO;
import com.clt.syscommon.common.table.BkgCntcPsonVO;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;

public class BookingCreationVO {
	/* BkgBookingInfoVO Start  */
	List<BkgBookingInfoVO> bkgBookingInfo 	= new ArrayList<BkgBookingInfoVO>();
	private BkgBookingInfoVO bkgBookingInfoVO = null;
	private BkgBookingInfoVO[] bkgBookingInfoVOs = null;
	private Boolean toyota = false;
	private String psaValCode = "";

	public void setBkgBookingInfoVOs(BkgBookingInfoVO[] bkgBookingInfoVOs) {
		this.bkgBookingInfoVOs = bkgBookingInfoVOs;
	}

	public BkgBookingInfoVO[] getBkgBookingInfoVOs() {
		return bkgBookingInfoVOs;
	}

	public void setBkgBookingInfoVO(BkgBookingInfoVO bkgBookingInfoVO) {
		this.bkgBookingInfoVO = bkgBookingInfoVO;
	}

	public BkgBookingInfoVO getBkgBookingInfoVO() {
		return bkgBookingInfoVO;
	}

	public List<BkgBookingInfoVO> getBkgBookingInfo() {
		return bkgBookingInfo;
	}

	public void setBkgBookingInfo(List<BkgBookingInfoVO> bkgBookingInfo) {
		this.bkgBookingInfo = bkgBookingInfo;
	}
	/* BkgBookingInfoVO End  */

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

	/* BkgQuantityVO Start  */
	List<BkgQuantityVO> bkgQuantity 	= new ArrayList<BkgQuantityVO>();
	private BkgQuantityVO bkgQuantityVO = null;
	private BkgQuantityVO[] bkgQuantityVOs = null;

	public void setBkgQuantityVOs(BkgQuantityVO[] bkgQuantityVOs) {
		this.bkgQuantityVOs = bkgQuantityVOs;
	}

	public BkgQuantityVO[] getBkgQuantityVOs() {
		return bkgQuantityVOs;
	}

	public void setBkgQuantityVO(BkgQuantityVO bkgQuantityVO) {
		this.bkgQuantityVO = bkgQuantityVO;
	}

	public BkgQuantityVO getBkgQuantityVO() {
		return bkgQuantityVO;
	}

	public List<BkgQuantityVO> getBkgQuantity() {
		return bkgQuantity;
	}

	public void setBkgQuantity(List<BkgQuantityVO> bkgQuantity) {
		this.bkgQuantity = bkgQuantity;
	}
	/* BkgQuantityVO End  */

	/* BkgQtyDtlVO Start  */
	List<BkgQtyDtlVO> bkgQtyDtl 	= new ArrayList<BkgQtyDtlVO>();
	private BkgQtyDtlVO bkgQtyDtlVO = null;
	private BkgQtyDtlVO[] bkgQtyDtlVOs = null;

	public void setBkgQtyDtlVOs(BkgQtyDtlVO[] bkgQtyDtlVOs) {
		this.bkgQtyDtlVOs = bkgQtyDtlVOs;
	}

	public BkgQtyDtlVO[] getBkgQtyDtlVOs() {
		return bkgQtyDtlVOs;
	}

	public void setBkgQtyDtlVO(BkgQtyDtlVO bkgQtyDtlVO) {
		this.bkgQtyDtlVO = bkgQtyDtlVO;
	}

	public BkgQtyDtlVO getBkgQtyDtlVO() {
		return bkgQtyDtlVO;
	}

	public List<BkgQtyDtlVO> getBkgQtyDtl() {
		return bkgQtyDtl;
	}

	public void setBkgQtyDtl(List<BkgQtyDtlVO> bkgQtyDtl) {
		this.bkgQtyDtl = bkgQtyDtl;
	}
	/* BkgQtyDtlVO End  */

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

	/* BkgCntcPsonVO Start  */
	List<BkgCntcPsonVO> bkgCntcPson 	= new ArrayList<BkgCntcPsonVO>();
	private BkgCntcPsonVO bkgCntcPsonVO = null;
	private BkgCntcPsonVO[] bkgCntcPsonVOs = null;

	public void setBkgCntcPsonVOs(BkgCntcPsonVO[] bkgCntcPsonVOs) {
		this.bkgCntcPsonVOs = bkgCntcPsonVOs;
	}

	public BkgCntcPsonVO[] getBkgCntcPsonVOs() {
		return bkgCntcPsonVOs;
	}

	public void setBkgCntcPsonVO(BkgCntcPsonVO bkgCntcPsonVO) {
		this.bkgCntcPsonVO = bkgCntcPsonVO;
	}

	public BkgCntcPsonVO getBkgCntcPsonVO() {
		return bkgCntcPsonVO;
	}

	public List<BkgCntcPsonVO> getBkgCntcPson() {
		return bkgCntcPson;
	}

	public void setBkgCntcPson(List<BkgCntcPsonVO> bkgCntcPson) {
		this.bkgCntcPson = bkgCntcPson;
	}
	/* BkgCntcPsonVO End  */

	/* SplitNoVO Start  */
	List<SplitNoVO> splitNo 	= new ArrayList<SplitNoVO>();
	private SplitNoVO splitNoVO = null;
	private SplitNoVO[] splitNoVOs = null;

	public void setSplitNoVOs(SplitNoVO[] splitNoVOs) {
		this.splitNoVOs = splitNoVOs;
	}

	public SplitNoVO[] getSplitNoVOs() {
		return splitNoVOs;
	}

	public void setSplitNoVO(SplitNoVO splitNoVO) {
		this.splitNoVO = splitNoVO;
	}

	public SplitNoVO getSplitNoVO() {
		return splitNoVO;
	}

	public List<SplitNoVO> getSplitNo() {
		return splitNo;
	}

	public void setSplitNo(List<SplitNoVO> splitNo) {
		this.splitNo = splitNo;
	}
	/* SplitNoVO End  */

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
	/* BookingSaveValidationVO Start  */
	private BookingSaveValidationVO bookingSaveValidationVO = null;

	public void setBookingSaveValidationVO(BookingSaveValidationVO bookingSaveValidationVO) {
		this.bookingSaveValidationVO = bookingSaveValidationVO;
	}

	public BookingSaveValidationVO getBookingSaveValidationVO() {
		return bookingSaveValidationVO;
	}

	/* BookingSaveValidationVO End  */
	/* OldBkgInfoVO Start  */
	private OldBkgInfoVO oldBkgInfVO = null;

	public void setOldBkgInfoVO(OldBkgInfoVO oldBkgInfVO) {
		this.oldBkgInfVO = oldBkgInfVO;
	}

	public OldBkgInfoVO getOldBkgInfoVO() {
		return oldBkgInfVO;
	}

	public String getPsaValCode() {
		return psaValCode;
	}

	public void setPsaValCode(String psaValCode) {
		this.psaValCode = psaValCode;
	}

	public Boolean getToyota() {
		return toyota;
	}

	public void setToyota(Boolean toyota) {
		this.toyota = toyota;
	}

	/* OldBkgInfoVO End  */
}