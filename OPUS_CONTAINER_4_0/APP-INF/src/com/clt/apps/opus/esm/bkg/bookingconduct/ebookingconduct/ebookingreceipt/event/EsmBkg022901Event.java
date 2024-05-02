/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022901Event.java
*@FileTitle : e-Booking & SI Process Detail(BOOKING)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.07.02 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgVvdVO;
//import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
//import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
//import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
//import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
//import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
//import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
//import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
//import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
//import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
//import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
//import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.NvoccFileNoVO;
//import com.clt.syscommon.common.table.BkgCntrSealNoVO;
//import com.clt.syscommon.common.table.BkgUsaCstmsFileNoVO;
//import com.clt.syscommon.common.table.BkgUsrDfltSetVO;


/**
 * ESM_BKG_0229 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg022901Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/* 각 탭의 Event를 가지고 있음 */ //-> 0229로 이동
	private EsmBkg022901Event esmBkg022901Event = null;
	
	public EsmBkg022901Event getEsmBkg022901Event() {
		return esmBkg022901Event;
	}

	public void setEsmBkg022901Event(EsmBkg022901Event esmBkg022901Event) {
		this.esmBkg022901Event = esmBkg022901Event;
	}
	
	/** Booking - Table Value Object 조회 조건 및 단건 처리  */
	private XterRqstNoVO xterRqstNoVO= null;
	private XterRqstNoVO[] xterRqstNoVOs = null;
	private BookingCreationVO bookingCreationVO = null;
	private BookingSaveValidationVO bookingSaveValidationVO = null;
	private BkgBlNoVO bkgBlNoVO = null;
	private VslSkdVO vslSkdVO = null;
	private VslSkdVO[] vslSkdVOs = null;
	private BkgVvdVO bkgVvdVO = null;
	private BkgVvdVO[] bkgVvdVOs = null;
	private BkgBookingInfoVO bkgBookingInfoVO = null;
//	private BookingCreationVO[] bookingCreationVOs = null;
	private BkgQuantityVO bkgQuantityVO = null;
	private BkgQuantityVO[] bkgQuantityVOs = null;
	private BkgQtyDtlVO bkgQtyDtlVO = null;	
	private BkgQtyDtlVO[] bkgQtyDtlVOs = null;	
	private BlCustomerInfoVO blCustomerInfoVO = null;
//	private BkgUsrDfltSetVO bkgUserDfltSetVO = null;
	private DocRqstVO docRqstVO= null;
	
	private String xterRqstViaCd = null;
	private String bkgTrunkVvd = null;
	private String caRsnCd = null;
	private String bkgCorrRmk = null;
	private String cmdtCd = null;
	private String mstBkgNo = null;
	private String xerRqstSeq = null;
	private String docTpCd = null;
	private String pctlNo = null;
	private String bdrFlg = null;
	private String autoNotification = null;
	private String bkgCntcPsonEml = null;
	private String bkgPolCd = null;
	
	public EsmBkg022901Event(){}

	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}

	public BookingCreationVO getBookingCreationVO() {
		return bookingCreationVO;
	}

	public void setBookingCreationVO(BookingCreationVO bookingCreationVO) {
		this.bookingCreationVO = bookingCreationVO;
	}

	public BookingSaveValidationVO getBookingSaveValidationVO() {
		return bookingSaveValidationVO;
	}

	public void setBookingSaveValidationVO(
			BookingSaveValidationVO bookingSaveValidationVO) {
		this.bookingSaveValidationVO = bookingSaveValidationVO;
	}

//	public BkgUsrDfltSetVO getBkgUserDfltSetVO() {
//		return bkgUserDfltSetVO;
//	}
//
//	public void setBkgUserDfltSetVO(BkgUsrDfltSetVO bkgUserDfltSetVO) {
//		this.bkgUserDfltSetVO = bkgUserDfltSetVO;
//	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public VslSkdVO getVslSkdVO() {
		return vslSkdVO;
	}

	public void setVslSkdVO(VslSkdVO vslSkdVO) {
		this.vslSkdVO = vslSkdVO;
	}

	public BkgVvdVO getBkgVvdVO() {
		return bkgVvdVO;
	}

	public void setBkgVvdVO(BkgVvdVO bkgVvdVO) {
		this.bkgVvdVO = bkgVvdVO;
	}

	public BkgBookingInfoVO getBkgBookingInfoVO() {
		return bkgBookingInfoVO;
	}

	public void setBkgBookingInfoVO(BkgBookingInfoVO bkgBookingInfoVO) {
		this.bkgBookingInfoVO = bkgBookingInfoVO;
	}

	public BkgQuantityVO getBkgQuantityVO() {
		return bkgQuantityVO;
	}

	public void setBkgQuantityVO(BkgQuantityVO bkgQuantityVO) {
		this.bkgQuantityVO = bkgQuantityVO;
	}

	public BlCustomerInfoVO getBlCustomerInfoVO() {
		return blCustomerInfoVO;
	}

	public void setBlCustomerInfoVO(BlCustomerInfoVO blCustomerInfoVO) {
		this.blCustomerInfoVO = blCustomerInfoVO;
	}

	public XterRqstNoVO[] getXterRqstNoVOs() {
		XterRqstNoVO[] rtnVOs = null;
		if (this.xterRqstNoVOs != null) {
			rtnVOs = Arrays.copyOf(xterRqstNoVOs, xterRqstNoVOs.length);
		}
		return rtnVOs;
	}

	public void setXterRqstNoVOs(XterRqstNoVO[] xterRqstNoVOs) {
		if(xterRqstNoVOs != null){
			XterRqstNoVO[] tmpVOs = Arrays.copyOf(xterRqstNoVOs, xterRqstNoVOs.length);
			this.xterRqstNoVOs  = tmpVOs;
		}
	}
//
//	public BookingCreationVO[] getBookingCreationVOs() {
//		return bookingCreationVOs;
//	}
//
//	public void setBookingCreationVOs(BookingCreationVO[] bookingCreationVOs) {
//		this.bookingCreationVOs = bookingCreationVOs;
//	}

	public VslSkdVO[] getVslSkdVOs() {
		VslSkdVO[] rtnVOs = null;
		if (this.vslSkdVOs != null) {
			rtnVOs = Arrays.copyOf(vslSkdVOs, vslSkdVOs.length);
		}
		return rtnVOs;
	}

	public void setVslSkdVOs(VslSkdVO[] vslSkdVOs) {
		if(vslSkdVOs != null){
			VslSkdVO[] tmpVOs = Arrays.copyOf(vslSkdVOs, vslSkdVOs.length);
			this.vslSkdVOs  = tmpVOs;
		}
	}

	public void setBkgQtyDtlVO(BkgQtyDtlVO bkgQtyDtlVO){
		this. bkgQtyDtlVO = bkgQtyDtlVO;
	}

	public void setBkgQtyDtlVOs(BkgQtyDtlVO[] bkgQtyDtlVOs){
		if(bkgQtyDtlVOs != null){
			BkgQtyDtlVO[] tmpVOs = Arrays.copyOf(bkgQtyDtlVOs, bkgQtyDtlVOs.length);
			this.bkgQtyDtlVOs  = tmpVOs;
		}
	}

	public BkgQtyDtlVO getBkgQtyDtlVO(){
		return bkgQtyDtlVO;
	}

	public BkgQtyDtlVO[] getBkgQtyDtlVOs(){
		BkgQtyDtlVO[] rtnVOs = null;
		if (this.bkgQtyDtlVOs != null) {
			rtnVOs = Arrays.copyOf(bkgQtyDtlVOs, bkgQtyDtlVOs.length);
		}
		return rtnVOs;
	}		
	
	public BkgVvdVO[] getBkgVvdVOs() {
		BkgVvdVO[] rtnVOs = null;
		if (this.bkgVvdVOs != null) {
			rtnVOs = Arrays.copyOf(bkgVvdVOs, bkgVvdVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgVvdVOs(BkgVvdVO[] bkgVvdVOs) {
		if(bkgVvdVOs != null){
			BkgVvdVO[] tmpVOs = Arrays.copyOf(bkgVvdVOs, bkgVvdVOs.length);
			this.bkgVvdVOs  = tmpVOs;
		}
	}

	public BkgQuantityVO[] getBkgQuantityVOs() {
		BkgQuantityVO[] rtnVOs = null;
		if (this.bkgQuantityVOs != null) {
			rtnVOs = Arrays.copyOf(bkgQuantityVOs, bkgQuantityVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgQuantityVOs(BkgQuantityVO[] bkgQuantityVOs) {
		if(bkgQuantityVOs != null){
			BkgQuantityVO[] tmpVOs = Arrays.copyOf(bkgQuantityVOs, bkgQuantityVOs.length);
			this.bkgQuantityVOs  = tmpVOs;
		}
	}

	public String getCmdtCd() {
		return cmdtCd;
	}

	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	public String getMstBkgNo() {
		return mstBkgNo;
	}

	public void setMstBkgNo(String mstBkgNo) {
		this.mstBkgNo = mstBkgNo;
	}

	public String getXerRqstSeq() {
		return xerRqstSeq;
	}

	public void setXerRqstSeq(String xerRqstSeq) {
		this.xerRqstSeq = xerRqstSeq;
	}

	public String getDocTpCd() {
		return docTpCd;
	}

	public void setDocTpCd(String docTpCd) {
		this.docTpCd = docTpCd;
	}

	public String getBkgTrunkVvd() {
		return bkgTrunkVvd;
	}

	public void setBkgTrunkVvd(String bkgTrunkVvd) {
		this.bkgTrunkVvd = bkgTrunkVvd;
	}

	public void setPctlNo(String pctlNo){
		this. pctlNo = pctlNo;
	}

	public String getPctlNo(){
		return pctlNo;
	}	

	public String getBdrFlg() {
		return bdrFlg;
	}

	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	public String getCaRsnCd() {
		return caRsnCd;
	}

	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
	}

	public String getBkgCorrRmk() {
		return bkgCorrRmk;
	}

	public void setBkgCorrRmk(String bkgCorrRmk) {
		this.bkgCorrRmk = bkgCorrRmk;
	}	

	public String getXterRqstViaCd() {
		return xterRqstViaCd;
	}

	public void setXterRqstViaCd(String xterRqstViaCd) {
		this.xterRqstViaCd = xterRqstViaCd;
	}

	public DocRqstVO getDocRqstVO() {
		return docRqstVO;
	}

	public void setDocRqstVO(DocRqstVO docRqstVO) {
		this.docRqstVO = docRqstVO;
	}

	public String getAutoNotification() {
		return autoNotification;
	}

	public void setAutoNotification(String autoNotification) {
		this.autoNotification = autoNotification;
	}

	public String getBkgCntcPsonEml() {
		return bkgCntcPsonEml;
	}

	public void setBkgCntcPsonEml(String bkgCntcPsonEml) {
		this.bkgCntcPsonEml = bkgCntcPsonEml;
	}

	public String getBkgPolCd() {
		return bkgPolCd;
	}

	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}

}