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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;


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
	private String locCd = null;
	
	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	private BkgReferenceVO[] bkgReferenceVOs = null;
	
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

	public void setXterRqstNoVOs(XterRqstNoVO[] xterRqstNoVOs){
		if(xterRqstNoVOs != null){
			XterRqstNoVO[] tmpVOs = Arrays.copyOf(xterRqstNoVOs, xterRqstNoVOs.length);
			this.xterRqstNoVOs = tmpVOs;
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

	public void setVslSkdVOs(VslSkdVO[] vslSkdVOs){
		if(vslSkdVOs != null){
			VslSkdVO[] tmpVOs = Arrays.copyOf(vslSkdVOs, vslSkdVOs.length);
			this.vslSkdVOs = tmpVOs;
		}
	}

	public void setBkgQtyDtlVO(BkgQtyDtlVO bkgQtyDtlVO){
		this. bkgQtyDtlVO = bkgQtyDtlVO;
	}

	public void setBkgQtyDtlVOs(BkgQtyDtlVO[] bkgQtyDtlVOs){
		if(bkgQtyDtlVOs != null){
			BkgQtyDtlVO[] tmpVOs = Arrays.copyOf(bkgQtyDtlVOs, bkgQtyDtlVOs.length);
			this.bkgQtyDtlVOs = tmpVOs;
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

	public void setBkgVvdVOs(BkgVvdVO[] bkgVvdVOs){
		if(bkgVvdVOs != null){
			BkgVvdVO[] tmpVOs = Arrays.copyOf(bkgVvdVOs, bkgVvdVOs.length);
			this.bkgVvdVOs = tmpVOs;
		}
	}

	public BkgQuantityVO[] getBkgQuantityVOs() {
		BkgQuantityVO[] rtnVOs = null;
		if (this.bkgQuantityVOs != null) {
			rtnVOs = Arrays.copyOf(bkgQuantityVOs, bkgQuantityVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgQuantityVOs(BkgQuantityVO[] bkgQuantityVOs){
		if(bkgQuantityVOs != null){
			BkgQuantityVO[] tmpVOs = Arrays.copyOf(bkgQuantityVOs, bkgQuantityVOs.length);
			this.bkgQuantityVOs = tmpVOs;
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

	public BkgReferenceVO[] getBkgReferenceVOs() {
		BkgReferenceVO[] rtnVOs = null;
		if (this.bkgReferenceVOs != null) {
			rtnVOs = Arrays.copyOf(bkgReferenceVOs, bkgReferenceVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgReferenceVOs(BkgReferenceVO[] bkgReferenceVOs){
		if(bkgReferenceVOs != null){
			BkgReferenceVO[] tmpVOs = Arrays.copyOf(bkgReferenceVOs, bkgReferenceVOs.length);
			this.bkgReferenceVOs = tmpVOs;
		}
	}

}
//	private EsmBkg022902Event esmBkg022902Event = null;
//	private EsmBkg022903Event esmBkg022903Event = null;
//	private EsmBkg022904Event esmBkg022904Event = null;
//	private EsmBkg022905Event esmBkg022905Event = null;
//	private EsmBkg022906Event esmBkg022906Event = null;
//	private EsmBkg022907Event esmBkg022907Event = null;
//	private EsmBkg022908Event esmBkg022908Event = null;
//	private EsmBkg022909Event esmBkg022909Event = null;
//	private EsmBkg022910Event esmBkg022910Event = null;
//	private EsmBkg022911Event esmBkg022911Event = null;	

//	public EsmBkg022902Event getEsmBkg022902Event() {
//		return esmBkg022902Event;
//	}
//
//	public void setEsmBkg022902Event(EsmBkg022902Event esmBkg022902Event) {
//		this.esmBkg022902Event = esmBkg022902Event;
//	}
//
//	public EsmBkg022903Event getEsmBkg022903Event() {
//		return esmBkg022903Event;
//	}
//
//	public void setEsmBkg022903Event(EsmBkg022903Event esmBkg022903Event) {
//		this.esmBkg022903Event = esmBkg022903Event;
//	}
//
//	public EsmBkg022904Event getEsmBkg022904Event() {
//		return esmBkg022904Event;
//	}
//
//	public void setEsmBkg022904Event(EsmBkg022904Event esmBkg022904Event) {
//		this.esmBkg022904Event = esmBkg022904Event;
//	}
//
//	public EsmBkg022905Event getEsmBkg022905Event() {
//		return esmBkg022905Event;
//	}
//
//	public void setEsmBkg022905Event(EsmBkg022905Event esmBkg022905Event) {
//		this.esmBkg022905Event = esmBkg022905Event;
//	}
//
//	public EsmBkg022906Event getEsmBkg022906Event() {
//		return esmBkg022906Event;
//	}
//
//	public void setEsmBkg022906Event(EsmBkg022906Event esmBkg022906Event) {
//		this.esmBkg022906Event = esmBkg022906Event;
//	}
//
//	public EsmBkg022907Event getEsmBkg022907Event() {
//		return esmBkg022907Event;
//	}
//
//	public void setEsmBkg022907Event(EsmBkg022907Event esmBkg022907Event) {
//		this.esmBkg022907Event = esmBkg022907Event;
//	}
//
//	public EsmBkg022908Event getEsmBkg022908Event() {
//		return esmBkg022908Event;
//	}
//
//	public void setEsmBkg022908Event(EsmBkg022908Event esmBkg022908Event) {
//		this.esmBkg022908Event = esmBkg022908Event;
//	}
//
//	public EsmBkg022909Event getEsmBkg022909Event() {
//		return esmBkg022909Event;
//	}
//
//	public void setEsmBkg022909Event(EsmBkg022909Event esmBkg022909Event) {
//		this.esmBkg022909Event = esmBkg022909Event;
//	}
//
//	public EsmBkg022910Event getEsmBkg022910Event() {
//		return esmBkg022910Event;
//	}
//
//	public void setEsmBkg022910Event(EsmBkg022910Event esmBkg022910Event) {
//		this.esmBkg022910Event = esmBkg022910Event;
//	}
//
//	public EsmBkg022911Event getEsmBkg022911Event() {
//		return esmBkg022911Event;
//	}
//
//	public void setEsmBkg022911Event(EsmBkg022911Event esmBkg022911Event) {
//		this.esmBkg022911Event = esmBkg022911Event;
//	}
	
//	/** Cntr - Table Value Object 조회 조건 및 단건 처리  */
//    private CntrEtcInfoVO bkgEtcInfoVO = null;
//    private CntrEtcInfoVO[] bkgEtcInfoVOs = null;
//    private ContainerVO containerVO = null;
//    private ContainerVO[] containerVOs = null;
//    private BkgCntrSealNoVO bkgCntrSealNoVO = null;
//    private BkgCntrSealNoVO[] bkgCntrSealNoVOs = null;
//
//	/** M&D - Table Value Object 조회 조건 및 단건 처리  */
//    private MndVO             mndVO            = null;
//    private MndVO[]           mndVOs           = null;
//
//	/** CM - Table Value Object 조회 조건 및 단건 처리  */
//	private CmVO cmVO = null;
//	private CmVO[] cmVOs = null;
	
//	/** DG - Table Value Object 조회 조건 및 단건 처리  */
//	private DgCgoListVO[] dgCgoListVOs = null;	
//    private String dcgoSeq = null;
//
//	/** TRO - Table Value Object 조회 조건 및 단건 처리  */
//	public String isEurFlg = null;
//	public String alpsEurCnt = null;
//	private TroVO troVO = null;
//
//	/** AWK - Table Value Object 조회 조건 및 단건 처리  */
//	private BkgAwkCgoVO[] bkgAwkCgoVOs = null;
//
//	/** HBL - Table Value Object Multi Data 처리  */
//    private HblVO hblVO = null;
//    private NvoccFileNoVO nvoccFileNoVO  = null;
//
//	/** HBL2 - Table Value Object Multi Data 처리  */
//	private BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs = null;

	/** 저장용 탭 플래그 */
//	public String saveBkgFlag = null;
//	public String saveCustFlag = null;
//	public String saveCntrFlag = null;
//	public String saveMndFlag = null;
//	public String saveCmFlag = null;
//	public String saveTroFlag = null;
//	public String saveRfFlag = null;
//	public String saveDgFlag = null;
//	public String saveAkFlag = null;
//	public String saveHblFlag = null;
//	public String saveHbl2Flag = null;

//	public String getSaveBkgFlag() {
//		return saveBkgFlag;
//	}
//
//	public void setSaveBkgFlag(String saveBkgFlag) {
//		this.saveBkgFlag = saveBkgFlag;
//	}
//
//	public String getSaveCustFlag() {
//		return saveCustFlag;
//	}
//
//	public void setSaveCustFlag(String saveCustFlag) {
//		this.saveCustFlag = saveCustFlag;
//	}
//
//	public String getSaveCntrFlag() {
//		return saveCntrFlag;
//	}
//
//	public void setSaveCntrFlag(String saveCntrFlag) {
//		this.saveCntrFlag = saveCntrFlag;
//	}
//
//	public String getSaveMndFlag() {
//		return saveMndFlag;
//	}
//
//	public void setSaveMndFlag(String saveMndFlag) {
//		this.saveMndFlag = saveMndFlag;
//	}
//
//	public String getSaveCmFlag() {
//		return saveCmFlag;
//	}
//
//	public void setSaveCmFlag(String saveCmFlag) {
//		this.saveCmFlag = saveCmFlag;
//	}
//
//	public String getSaveTroFlag() {
//		return saveTroFlag;
//	}
//
//	public void setSaveTroFlag(String saveTroFlag) {
//		this.saveTroFlag = saveTroFlag;
//	}
//
//	public String getSaveRfFlag() {
//		return saveRfFlag;
//	}
//
//	public void setSaveRfFlag(String saveRfFlag) {
//		this.saveRfFlag = saveRfFlag;
//	}
//
//	public String getSaveDgFlag() {
//		return saveDgFlag;
//	}
//
//	public void setSaveDgFlag(String saveDgFlag) {
//		this.saveDgFlag = saveDgFlag;
//	}
//
//	public String getSaveAkFlag() {
//		return saveAkFlag;
//	}
//
//	public void setSaveAkFlag(String saveAkFlag) {
//		this.saveAkFlag = saveAkFlag;
//	}
//
//	public String getSaveHblFlag() {
//		return saveHblFlag;
//	}
//
//	public void setSaveHblFlag(String saveHblFlag) {
//		this.saveHblFlag = saveHblFlag;
//	}
//
//	public String getSaveHbl2Flag() {
//		return saveHbl2Flag;
//	}
//
//	public void setSaveHbl2Flag(String saveHbl2Flag) {
//		this.saveHbl2Flag = saveHbl2Flag;
//	}

//	public CntrEtcInfoVO getBkgEtcInfoVO() {
//		return bkgEtcInfoVO;
//	}
//
//	public void setBkgEtcInfoVO(CntrEtcInfoVO bkgEtcInfoVO) {
//		this.bkgEtcInfoVO = bkgEtcInfoVO;
//	}
//
//	public CntrEtcInfoVO[] getBkgEtcInfoVOs() {
//		return bkgEtcInfoVOs;
//	}
//
//	public void setBkgEtcInfoVOs(CntrEtcInfoVO[] bkgEtcInfoVOs) {
//		this.bkgEtcInfoVOs = bkgEtcInfoVOs;
//	}

//	public ContainerVO getContainerVO() {
//		return containerVO;
//	}
//
//	public void setContainerVO(ContainerVO containerVO) {
//		this.containerVO = containerVO;
//	}
//
//	public ContainerVO[] getContainerVOs() {
//		return containerVOs;
//	}
//
//	public void setContainerVOs(ContainerVO[] containerVOs) {
//		this.containerVOs = containerVOs;
//	}
//
//	public BkgCntrSealNoVO getBkgCntrSealNoVO() {
//		return bkgCntrSealNoVO;
//	}
//
//	public void setBkgCntrSealNoVO(BkgCntrSealNoVO bkgCntrSealNoVO) {
//		this.bkgCntrSealNoVO = bkgCntrSealNoVO;
//	}
//
//	public BkgCntrSealNoVO[] getBkgCntrSealNoVOs() {
//		return bkgCntrSealNoVOs;
//	}
//
//	public void setBkgCntrSealNoVOs(BkgCntrSealNoVO[] bkgCntrSealNoVOs) {
//		this.bkgCntrSealNoVOs = bkgCntrSealNoVOs;
//	}

//	public MndVO getMndVO() {
//		return mndVO;
//	}
//
//	public void setMndVO(MndVO mndVO) {
//		this.mndVO = mndVO;
//	}
//
//	public MndVO[] getMndVOs() {
//		return mndVOs;
//	}
//
//	public void setMndVOs(MndVO[] mndVOs) {
//		this.mndVOs = mndVOs;
//	}

//	public CmVO getCmVO() {
//		return cmVO;
//	}
//
//	public void setCmVO(CmVO cmVO) {
//		this.cmVO = cmVO;
//	}
//
//	public CmVO[] getCmVOs() {
//		return cmVOs;
//	}
//
//	public void setCmVOs(CmVO[] cmVOs) {
//		this.cmVOs = cmVOs;
//	}

//	public TroVO getTroVO() {
//		return troVO;
//	}
//
//	public void setTroVO(TroVO troVO) {
//		this.troVO = troVO;
//	}

//	public String getIsEurFlg() {
//		return isEurFlg;
//	}
//
//	public void setIsEurFlg(String isEurFlg) {
//		this.isEurFlg = isEurFlg;
//	}
//
//	public String getAlpsEurCnt() {
//		return alpsEurCnt;
//	}
//
//	public void setAlpsEurCnt(String alpsEurCnt) {
//		this.alpsEurCnt = alpsEurCnt;
//	}

//	public BkgAwkCgoVO[] getBkgAwkCgoVOs() {
//		return bkgAwkCgoVOs;
//	}
//
//	public void setBkgAwkCgoVOs(BkgAwkCgoVO[] bkgAwkCgoVOs) {
//		this.bkgAwkCgoVOs = bkgAwkCgoVOs;
//	}

//	public BkgUsaCstmsFileNoVO[] getBkgUsaCstmsFileNoVOs() {
//		return bkgUsaCstmsFileNoVOs;
//	}
//
//	public void setBkgUsaCstmsFileNoVOs(BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs) {
//		this.bkgUsaCstmsFileNoVOs = bkgUsaCstmsFileNoVOs;
//	}

//	public HblVO getHblVO() {
//		return hblVO;
//	}
//
//	public void setHblVO(HblVO hblVO) {
//		this.hblVO = hblVO;
//	}

//	public NvoccFileNoVO getNvoccFileNoVO() {
//		return nvoccFileNoVO;
//	}
//
//	public void setNvoccFileNoVO(NvoccFileNoVO nvoccFileNoVO) {
//		this.nvoccFileNoVO = nvoccFileNoVO;
//	}

//	public DgCgoListVO[] getDgCgoListVOs() {
//		return dgCgoListVOs;
//	}
//
//	public void setDgCgoListVOs(DgCgoListVO[] dgCgoListVOs) {
//		this.dgCgoListVOs = dgCgoListVOs;
//	}

//	public String getDcgoSeq() {
//		return dcgoSeq;
//	}
//
//	public void setDcgoSeq(String dcgoSeq) {
//		this.dcgoSeq = dcgoSeq;
//	}

//	// Customer 용
//	private CustEtcVO custEtcVO = null;
//	private BlDocCustVO blDocCustVO = null;		
//	private CustEtcVO[] custEtcVOs = null;
//	private BlDocCustVO[] blDocCustVOs = null;		
//	
//	public CustEtcVO getCustEtcVO(){
//		return custEtcVO;
//	}
//
//	public void setCustEtcVO(CustEtcVO custEtcVO){
//		this.custEtcVO = custEtcVO;
//	}
//	
//	public BlDocCustVO getBlDocCustVO(){
//		return blDocCustVO;
//	}
//
//	public void setBlDocCustVO(BlDocCustVO blDocCustVO){
//		this.blDocCustVO = blDocCustVO;
//	}	
//
//	public CustEtcVO[] getCustEtcVOs(){
//		return custEtcVOs;
//	}
//
//	public void setCustEtcVOs(CustEtcVO[] custEtcVOs){
//		this.custEtcVOs = custEtcVOs;
//	}
//	
//	public BlDocCustVO[] getBlDocCustVOs(){
//		return blDocCustVOs;
//	}
//
//	public void setBlDocCustVOs(BlDocCustVO[] blDocCustVOs){
//		this.blDocCustVOs = blDocCustVOs;
//	}