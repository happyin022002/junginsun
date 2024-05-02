/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptBC.java
*@FileTitle : BKG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsChgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BdrSpclVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CargoDetailVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CmdtVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ExportReferencesVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.FwrdRefVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ManualBookingCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OceanRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PolPodVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SearchBkgContainerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SpclQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SpclVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VvdAssignVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.XterCustOvflwFlgStatusVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgClzTmVO;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.BkgRollOvrVO;
import com.clt.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgVvdVO;

/**
 * OPUS-Generalbookingonduct Business Logic Command Interface<br>
 * - OPUS-Generalbookingconduct business logic Interface<br>
 *
 * @see Esm_bkg_0079_01EventResponse reference
 * @author KimByungKyu
 * @since J2EE 1.4
 */

public interface GeneralBookingReceiptBC {

	
	/**
	 * modify BkgBooking Data information at BKG_CHG_RT
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 * @exception EventException
	 */
	 public void modifyChgRateBkgBooking(RateMainInfoVO rateMainInfoVO ,String caflag) throws EventException; 
	
	 /**
		 * modify BL TYPE handling<br>
		 * save BL TYPE information of booking
		 * @param String bkgNo
		 * @param String blTpCd
		 * @exception EventException
		 */
	public void modifyBlType(String bkgNo ,String blTpCd) throws EventException;

	/**
	 * retrieve event handling<br>
	 * retrieve Purchase Other Number and other number information
	 * @param PoOtherNoVO poOtherNoVO
	 * @return PoOtherNoVO
	 * @exception EventException
	 */
	public PoOtherNoVO searchPoOtherNo(PoOtherNoVO poOtherNoVO) throws EventException;

	/**
	 * multi event handling<br>
	 * save reference no of booking
	 * create and modify only following types of REFERENCE NUMBER<br>
	 *  . EBRF : BKG Ref # (ext bkg rqst).<br>
	 *  . EBSH : BKG SH Ref # (ext bkg rqst).<br>
	 *  . EBFF : BKG FF Ref # (ext bkg rqst).<br>
	 *  . RGBK : Regional BKG No..<br>
	 *  . ESRF : S/I Ref # (ext rqst).<br>
	 *  . ESSH : S/I SH Ref # (ext rqst).<br>
	 *  . ESFF : S/I FF Ref # (ext rqst).<br>
	 *  . FINV : INV Ref # the relationship between exporters and importers<br>
	 *  .<br>
	 * @param PoOtherNoVO   poOtherNoVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageRefNo(PoOtherNoVO poOtherNoVO, String caFlg) throws EventException;

	/**
	 * multi event handling<br>
	 * save reference detail (HP, COSTCO ) information of booking
	 * @param PoOtherNoVO poOtherNoVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageRefDetail(PoOtherNoVO poOtherNoVO, String caFlg) throws EventException;
	
	/**
	 * multi event handling<br>
	 * save MRNNo , UCRNo
	 * @param PoOtherNoVO poOtherNoVO
	 * @exception EventException
	 */
	public void manageMRNNoUCRNo(PoOtherNoVO poOtherNoVO) throws EventException;
	
    /**
     * bkg  cntr_no list retrieve<br>
     * @author 	
     * @param 	BkgBlNoVO bkgBlNoVO
     * @return	List<BkgComboVO>
     * @throws EventException
     */
    public List<BkgComboVO> searchContainerMrnUcr(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * retrieve event handling<br>
	 * retrieve in order to copy CM information to PO & Other No
	 * @param PoOtherNoVO poOtherNoVO
	 * @return PoOtherNoVO
	 * @exception EventException
	 */
	public PoOtherNoVO searchCmForPo(PoOtherNoVO poOtherNoVO) throws EventException;

	/**
	 * manage Reference information<br>
	 * @param BkgReferenceVO[] bkgReferenceVOs
	 * @param SignOnUserAccount account
	 * @param BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void manageRefNo(	BkgReferenceVO[] bkgReferenceVOs,
											SignOnUserAccount account,
											BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 *  manage House B / L corresponding to the SCAC No<br>
	 * @param 	BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs
	 * @param 	SignOnUserAccount account
	 * @param 	BkgBlNoVO bkgBlNo
	 * @exception EventException
	 */
	public void manageNVOFileNumber(	BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs,
															SignOnUserAccount account,
															BkgBlNoVO bkgBlNo) throws EventException;

	/**
	 * Ocean Route retrieve.(ESM_BKG_0092)<br>
	 * @param 	PolPodVvdVO[] polPodVvdVOs
	 * @param   String bkgNo
	 * @return 	OceanRouteVO
	 * @exception EventException
	 */
	public OceanRouteVO searchTsRoute(PolPodVvdVO[] polPodVvdVOs, String bkgNo) throws EventException;

	/**
	 * Ocean Route Lane/POL ETD/POD ETA retrieve.(ESM_BKG_0092)<br>
	 * @param 	PolPodVvdVO polPodVvdVO
	 * @return 	VslSkdVO
	 * @exception EventException
	 */
	public VslSkdVO searchLaneEtaEtd(PolPodVvdVO polPodVvdVO) throws EventException;

	/**
	 * Ocean Route Lane/POL ETD/POD ETA retrieve.(ESM_BKG_0092)<br>
	 * @param 	PolPodVvdVO[] polPodVvdVOs
	 * @exception EventException
	 */
	public void validateTsRoute(PolPodVvdVO[] polPodVvdVOs) throws EventException;

	/**
	 * modify Tro quantity(ESM_BKG_0079_02A)<br>
	 * @param  BkgQuantityVO[] arrBkgQuantityVO
	 * @param  String boundCd
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgQtyByTro(BkgQuantityVO[] arrBkgQuantityVO, String boundCd, SignOnUserAccount account) throws EventException;

	/**
	 * update to booking information in case of EU tro confirm(ESM_BKG_0079_02C)<br>
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void modifyEurPkupRtnCy(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * BookingCreation user Default information retrieve.(ESM_BKG_0079_01)<br>
	 * @param 	SignOnUserAccount account
	 * @return 	BkgUsrDfltSetVO
	 * @exception 	EventException
	 */
	public BkgUsrDfltSetVO searchUserBkgDefault(SignOnUserAccount account) throws EventException;

	/**
	 * retrieve information as BookingCreation CmdtCd .(ESM_BKG_0079_01)<br>
	 * @param 	String cmdtCd
	 * @return 	CmdtVO
	 * @exception EventException
	 */
	public CmdtVO validatePrecaution(String cmdtCd) throws EventException;

	/**
	 * save cct information<br>
	 * @param  BkgClzTmVO[] bkgClzTmVOs
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCargoClosingTime(BkgClzTmVO[] bkgClzTmVOs,SignOnUserAccount account )throws EventException;

	/**
	 * BookingCreation information retrieve.(ESM_BKG_0079_01)<br>
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	BookingCreationVO
	 * @exception EventException
	 */
	public BookingCreationVO searchBooking(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * assess the suitability of input values​​. in case of creation / modifications Booking(ESM_BKG_0079_01)<br>
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @return 	BookingCreationVO
	 * @exception 	EventException
	 */
	public BookingCreationVO validateBookingSave(BookingCreationVO bookingCreationVO, SignOnUserAccount account) throws EventException;
	/**
	 * create Booking(ESM_BKG_0079_01)<br>
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @exception EventException
	 */
	public void createBooking(BookingCreationVO bookingCreationVO,SignOnUserAccount account ) throws EventException;

	/**
	 * retrieve Booking information before modification(ESM_BKG_0079_01)<br>
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	OldBkgInfoVO
	 * @exception 	EventException
	 */
	public OldBkgInfoVO searchOldBkgInfo(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * modify Booking(ESM_BKG_0079_01)<br>
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @return		BookingSaveValidationVO
	 * @exception 	EventException
	 */
	public BookingSaveValidationVO modifyBooking(BookingCreationVO bookingCreationVO,SignOnUserAccount account ) throws EventException;


	/**
     * modify Booking(ESM_BKG_007901)<br>
     * @param 		BkgBookingVO bkgBookingVO
     * @param 		String caFlg
     * @exception 	EventException
     */
    public void modifyBkgByCm(BkgBookingVO bkgBookingVO, String caFlg) throws EventException;

    /**
	 * modify Booking Staut(ESM_BKG_007901)<br>
	 * @param 		String newStsCd
	 * @param 	  	BkgBlNoVO bkgBlNoVO
	 * @param 		boolean validation	  
	 * @param 		SignOnUserAccount account
	 * @return		boolean
	 * @exception 	EventException
	 */
    public boolean changeBkgStatus(String newStsCd, BkgBlNoVO bkgBlNoVO, boolean validation, SignOnUserAccount account) throws EventException;

    /**
     * delete bkg_referenece of Bkg by cntr
     * @param 		String bkgNo
     * @param 		String cntrNo
     * @param 		String caFlg
	 * @exception 	EventException
     */
    public void removeReferenceByCntr(String bkgNo, String cntrNo, String caFlg) throws EventException;

    /**
     * delete bkg_ref_dtl of Bkg by cntr
     * @param 		String bkgNo
     * @param 		String cntrNo
     * @param 		String caFlg
	 * @exception 	EventException
     */
    public void removeReferenceDetailByCntr(String bkgNo, String cntrNo, String caFlg) throws EventException;

    /**
	 * update changed Reference Detail information
	 * @param 		String bkgNo
	 * @param 	  	String cntrNo
	 * @param 		String cntrNoOld
	 * @param 		String caFlg
	 * @exception 	EventException
	 */
    public void changeReferenceDetailByCntr(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException;

    /**
	 * update changed Reference No information
	 * @param 		String bkgNo
	 * @param 	  	String cntrNo
	 * @param 		String cntrNoOld
	 * @param 		String caFlg
	 * @exception 	EventException
	 */
    public void changeReferenceByCntr(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException;

    /**
	 *  delete BKG_CLZ_TM(ESM_BKG_0079_01)<br>
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	String modeCd
     * @exception EventException
     */
    public void removeBkgClzTm(BkgBlNoVO bkgBlNoVO, String modeCd) throws EventException;
    /**
	 * Cancel Booking(ESM_BKG_007901)<br>
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBooking(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
    
	/**
     * Booking information copies from sourceBkg to targetBkg.
     * using split and cod (ESM_BKG_0099)
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param SplitBkgVO splitBkgVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String copyBookingForSplit (BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, SplitBkgVO splitBkgVO,SignOnUserAccount account)throws EventException;
    
    
    /**
	 * modify special cgo qty(ESM_BKG_0055)<br>
	 * @param SpclQtyVO spclQtyVO
	 * @param String caFlg 
	 * @exception EventException
	 */
	public void modifyAwkQty(SpclQtyVO spclQtyVO, String caFlg) throws EventException;
	
	/**
	 * modify special cgo qty(ESM_BKG_0055)<br>
	 * @param SpclVO spclVO
	 * @param String caFlg 
	 * @exception EventException
	 */
	public void modifyBkgBySpcl(SpclVO spclVO, String caFlg) throws EventException;
    
    
    
	/**
	 * modify Booking information(ESM_BKG_0029)<br>
	 * @param 		String xterRqstViaCd
	 * @param       String saveModeCd
	 * @param 		String autoNotification
	 * @param       XterRqstNoVO xterRqstNoVO
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyBkgByXter(String xterRqstViaCd, String saveModeCd, String autoNotification, XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws EventException;
	/**
	 * create update Booking information about Empty Repo Booking<br>
	 * @param 		MtyBookingCreateVO mtyBookingCreateVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void createMtyRepoBooking(MtyBookingCreateVO mtyBookingCreateVO, SignOnUserAccount account) throws EventException;

	/**
	 * retrieve Customer Information in case of Booking Creation(ESM_BKG_007905)<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return		BlCustomerVO
	 * @exception 	EventException
	 */
	public BlCustomerVO searchBlDocCust(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * checking Validation in case of Customer Information(ESM_BKG_007905)<br>
	 * @param 		BlCustomerVO blCustomerVO
	 * @return			String[]
	 * @exception 	EventException
	 */
	public String[] validateBlDocCust(BlCustomerVO blCustomerVO) throws EventException;	

	/**
	 * modify shipper information(ESM_BKG_007905)<br>
	 * @param 		BlCustomerVO blCustomerVO
	 * @param 		String bkgFlg
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyBlDocCust(BlCustomerVO blCustomerVO, String bkgFlg, SignOnUserAccount account) throws EventException;

	/**
	 * modify saved Inbound Notify information from ANCS, ROCS(ESM_BKG_0045, 0442)<br>
	 * @param 		String bkgNo
	 * @param 		String notifyNm
	 * @param 		String notifyAddr
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyIbCustNmAddr(String bkgNo, String notifyNm, String notifyAddr, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Cargo Detail Information retrieve.<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return			CargoDetailVO
	 * @exception 	EventException
	 */
	public CargoDetailVO searchCargoDetail(BkgBlNoVO bkgBlNoVO) throws EventException;	

	/**
	 * save BkgQtyDtl information<br>
	 * @param 		BkgQtyDtlVO[] bkgQtyDtlVOs
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void manageBkgQtyDtl(BkgQtyDtlVO[] bkgQtyDtlVOs, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * update t/vvd, pod, pod_node, del, del_node from bkg_cod to bkg_booking
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgBlNoVO codBkg 
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBookingFromCod (BkgBlNoVO bkgBlNoVO, BkgBlNoVO codBkg, String codRqstSeq , SignOnUserAccount account ) throws EventException;

	/**
	 * 1. Combine from Qty and Qty Dtl to Master Bkg<br>
	 * 2. Combine from bkg_reference to Master Bkg<br>
	 * @param BkgBlNoVO[] sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String hitchmentYn
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void combineQty (BkgBlNoVO[] sourceBkg , BkgBlNoVO targetBkg, String hitchmentYn,SignOnUserAccount account) throws EventException;

	/**
	 * copy from bkg_referenece of Source Bkg to Target Bkg
	 * @param String copyModeCd
	 * @param BkgBlNoVO[] sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String[] cntrNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyBkgRefByBkg (String copyModeCd, BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg , String[] cntrNo, SignOnUserAccount account) throws EventException;

	/**
     * copy from bkg_referenece of Bkg to Target Bkg
     * @param 		cntrCopyVO
	 * @exception 	EventException
     */
    public void copyBkgRefByCntr(CntrCopyVO cntrCopyVO) throws EventException;

    /**
	 * copy customer information from original bkg
	 * @param BlCopyInVO blCopyInVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyCustByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws EventException;

	/**
     * delete bkg_referenece, bkg_ref_dtl of Bkg by cntr
     * @param 		String bkgNo
     * @param 		String cntrNo
     * @param 		String seq
	 * @exception 	EventException
     */
    public void removeBkgRefByCntr(String bkgNo, String cntrNo, String seq) throws EventException;

    /**
	 * retrieve reference data in order to modify route of Booking using Partial container
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return		PartialBkgVO
	 * @exception 	EventException
	 */
	public PartialBkgVO searchPartialCntrBkg(BkgBlNoVO bkgBlNoVO) throws EventException;    

	/**
	 * update orgin, dest route of Booking<br>
	 * @param 		PartialBkgInfoVO partialBkgInfoVO
	 * @param 		VslSkdVO[] vslSkdVOs
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyBkgRouteForPartialBkg(PartialBkgInfoVO partialBkgInfoVO, VslSkdVO[] vslSkdVOs, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * copy relevant table of booking for C/A<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void createBookingCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * delete relevant table of booking for C/A
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * retrieve data of original booking for copying booking
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return			BookingCopyVO
	 * @exception 	EventException
	 */
	public BookingCopyVO searchBkgForCopy(BkgBlNoVO bkgBlNoVO) throws EventException;	
	
	/**
	 * create data of new booking as inspect and combine data of original booking
	 * @param 		BookingCopyVO bookingCopyVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void validateBkgCopy(BookingCopyVO bookingCopyVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * retrieve booking data status for manual booking copy (EMS_BKG_0077)
	 * @param 		ManualBookingCopyVO[] manualBookingCopyVOs
	 * @param 		String bkgNo
	 * @return		ManualBookingCopyVO[] manualBookingStsVOs
	 * @exception 	EventException
	 */
	public ManualBookingCopyVO[] searchManualBookingStatus(ManualBookingCopyVO[] manualBookingCopyVOs, String bkgNo) throws EventException;

	
	
	/**
	 * copy Booking<br>
	 * @param 		BookingCopyVO bookingCopyVO
	 * @param 		BkgBlNoVO sourceBkg
	 * @param 		BkgBlNoVO targetBkg
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void copyBooking(BookingCopyVO bookingCopyVO, BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account)  throws EventException;		

	/**
	 * split empty repo Booking<br>
	 * @param 		MtyBookingSplitVO mtyBookingSplitVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void splitMtyRepoBooking(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException;	

	/**
	 * complete split of empty repo booking<br>
	 * @param 		MtyBookingSplitVO mtyBookingSplitVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void completeMtyRepoBkgSplit(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancel Empty Booking<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void cancelMtyBkg(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * create/update Booking information about Empty Repo Booking
	 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyMtyRepoBkg(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws EventException ;	
	
	/**
	 * complete to save Container information of empty repo booking
	 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
	 * @param 		SignOnUserAccount account
	 * @return		List<BkgQuantityVO>
	 * @exception 	EventException
	 */
	public List<BkgQuantityVO> completeModifyMtyRepoBkg(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws EventException;	

	/**
	 * modify forwarder code and vsl reference information by Booking in Malaysia(ESM_BKG_0616)
	 * @param FwrdRefVvdVO[] fwrdRefVvdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageMyFwrdRefVvd(FwrdRefVvdVO[] fwrdRefVvdVO, SignOnUserAccount account) throws EventException ;	

	/**
	 * modify spcl flag of bkg_booking from modified data after split, combine
	 * @param 		BkgBlNoVO[] bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifySpclFlag(BkgBlNoVO[] bkgBlNoVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * update from vsk_vsl_port_skd-side modifications to bkg_vvd 
	 * @param 		List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs
	 * @param 		SignOnUserAccount account
	 * @throws 		EventException
	 */
	public void modifyBkgVvdForVslSkdCng(List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs, SignOnUserAccount account)throws EventException ;
	
	/**
	 * modify only Ocean Route of Booking
	 * @param VvdAssignVO vvdAssignVO
	 * @param SignOnUserAccount account
	 * @return BdrSpclVO
	 * @exception EventException
	 */
	public BdrSpclVO modifyOceanRoute(VvdAssignVO vvdAssignVO,SignOnUserAccount account)throws EventException ;
	
	/**
	 * modify to force the status of Booking<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void compFirm(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException ;
	
	/**
     * save entered information from COD at C/A in progress
     * @param BkgBlNoVO bkgBlNoVO
     * @param String codRqstSeq
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyTempHistForCOD (BkgBlNoVO bkgBlNoVO, String codRqstSeq, SignOnUserAccount account) throws EventException;
    
    
    /**
     * save entered VoidQty at SpecialCargo
     * @param String bkgNo
     * @param String ovrVoidSltQty
     * @param  String caFlg
     * @exception EventException
     */
    public void modifyBbVoidQty (String bkgNo, String ovrVoidSltQty, String caFlg) throws EventException;
    
    /**
     * UI-BKG-1054 Customer Code Validation<br>
     * Customer Code Validation Unmatch update<br>
	 * @param CustCdEvaluationVO[] custCdVal
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void modifyCustCdValInfo(CustCdEvaluationVO[] custCdVal, SignOnUserAccount account) throws EventException;
    
    /**
     * UI_BKG-1054 Customer Code Validation<br>
     * Matched information Customer Code Validation changes Unmatch
	 * @param String bkgNo
	 * @param String bkgCustTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeCustCdValInfo(String bkgNo, String bkgCustTpCd, SignOnUserAccount account) throws EventException;
	
	/**
	 * UI-BKG-1054 Customer Code Validation<br>
	 * modify match about matching information  after comparing Booking Customer and MDM.<br>
	 * @param ArrNtcSearchVO arrNtcSearch retrieve condition
	 * @throws EventException
	 */
	public void modifyBkgCustValInfo(ArrNtcSearchVO arrNtcSearch ) throws EventException;
	
	/**
	 * Inbound - Remove Customer Code Validation<br>
	 * removde Customer Code Validation as Booking unit<br>
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void cancelCustCdVal(String bkgNo) throws EventException;
	
	/**
	 * Inbound - UI-BKG-0941 - Customer Code Error Report Confirm<br>
	 * Code Validation result revaluation<br>
	 * @param ArrNtcCustCodeErrListVO[] custCodeErrLists
	 * @throws EventException
	 */
	public void confirmCustCdErrReport(ArrNtcCustCodeErrListVO[] custCodeErrLists ) throws EventException;

	/**
     * ocean route Validation<br>
     * Want to change the route is registered as an ocean route to make sure that.
	 * @param 		PrdMainInfoVO prdMainInfoVO
	 * @exception 	EventException
	 */
	public void validateOceanRoute(PrdMainInfoVO prdMainInfoVO) throws EventException;

	/**
     * create cargo Closing Time<br>
     * @param BkgBlNoVO bkgBlNoVO
     * @param String fromDt
     * @param String toDt
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCargoClosingTime(BkgBlNoVO bkgBlNoVO, String fromDt, String toDt, SignOnUserAccount account) throws EventException;

	/**
     * retrieve bkg_quantity for calculating rail receiving time
     * @param BkgBlNoVO bkgBlNoVO
     * @return PrdQtyInfoVO[]
	 * @exception EventException
	 */
	public PrdQtyInfoVO[] searchBkgQtyForRailTime(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
     * trunk vvd among typed vvd is calculated based on the coa voyage.<br>
     * @param PolPodVvdVO[] polPodVvdVOs
     * @return String
	 * @exception EventException
	 */
	public String searchTrnkVvdByRlane(PolPodVvdVO[] polPodVvdVOs) throws EventException;
	/**
     * Modify Arrival Notice records
     * @param ArrNtcCustListVO[] arrNtcCustListVOS
     * @throws EventException
     */
    public void modifyArrNtcCustChgFlg ( ArrNtcCustListVO[] arrNtcCustListVOS)throws EventException;

    /**
     * retrieve whether c/a tmp deletes
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
     * @throws EventException
     */
	public String searchCaTmp(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
     * retrieve P/O no at eBkg
     * @param BkgBlNoVO bkgBlNoVO
     * @return PoOtherNoVO
     * @throws EventException
     */
	public PoOtherNoVO searchPoOtherNoByXter(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
     * retrieve CBF in case of split at booking split screen
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
	 * @param SignOnUserAccount account
     * @throws EventException
     */
	public String searchCbfFlag(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
     * modify cargo Closing Time<br>
     * @param BkgClzTmVO bkgClzTmVO
	 * @exception EventException
	 */
	public void modifyCargoClosingTime(BkgClzTmVO bkgClzTmVO) throws EventException;
	
	/**
	 * ESM_BKG_0702 : customer click <br>
	 * transmit Customer information Flat File as EDI
	 * @param BkgBlNoVO[] bkgBlNoVO
	 * @param CustTpIdVO[] custTpIdVO
	 * @param String typeGbn
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String sendBkgCustEdiMulti(BkgBlNoVO[] bkgBlNoVO, CustTpIdVO[] custTpIdVO, String typeGbn, SignOnUserAccount account) throws EventException;
	/**
	 * transmission as Customer EDI, BackEndJob result confirmation<br>
	 * @param String key
	 * @return String
	 * @throws EventException
	 */
	public String searchSendBkgCustEdiMulti(String key) throws EventException;
	
	/**
	 * BKG_Quantity 정보를 조회한다.
	 * @param bkgBlNoVO
	 * @return List<BkgQuantityVO>
	 * @throws EventException
	 */
	public List<BkgQuantityVO> searchBkgQuantity(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * SI_FLG 를 조회한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSiFlg(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * Allocation Status를 manage한다.<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param SignOnUserAccount account
	 * @param String docTpCd
	 * @return AllocStsChgVO
	 * @throws EventException
	 */
	public AllocStsChgVO manageAlocStatus(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account, String docTpCd) throws EventException;
	
	/**
	 * EXPORT REFERENCES를 조회한다.
	 * @param ExportReferencesVO exportReferencesVO
	 * @return List<ExportReferencesVO>
	 * @exception EventException
	 */
	public List<ExportReferencesVO> searchExportReferencesByBkg(ExportReferencesVO exportReferencesVO) throws EventException;
	
	/**
	 * EXPORT REFERENCES를 조회한다.(BY CNTR)
	 * @param ExportReferencesVO exportReferencesVO
	 * @return List<ExportReferencesVO>
	 * @exception EventException
	 */
	public List<ExportReferencesVO> searchExportReferencesByCntr(ExportReferencesVO exportReferencesVO) throws EventException;
	
	/**
	 * roll over 정보를 update<br>
	 * 
	 * @author 		
	 * @param 		BkgRollOvrVO[] bkgRollOvrVOs
	 * @exception EventException
	 */
	public void manageBkgRollOver(BkgRollOvrVO[] bkgRollOvrVOs)throws EventException;	
	
    /**
     * SVC_SCP_CD를 조회한다.
     * @param String trnkLaneCd
     * @param String porCd
     * @param String delCd
     * @return String
     */
    public String searchSvcScope(String trnkLaneCd, String porCd, String delCd) throws EventException;

	/**
	 * return booking vvd information.<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<BkgVvdVO>
	 * @exception EventException
	 */
	public List<BkgVvdVO> searchBkgVvd(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * VSL_SEQ를 조회한다.
	 * @param bkgNo
	 * @param vvdCd
	 * @return
	 * @throws EventException
	 */
	public List<BkgVvdVO> searchVslSeqList(String bkgNo, String vvdCd) throws EventException;
	
	/**
	 * eBooking S/I에서 BKG으로 업로드된 Customer Name & Address의 Overlfow 여부를 조회한다.
	 *
	 * @param XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO
	 * @return XterCustOvflwFlgStatusVO
	 * @exception DAOException
	 */
	public XterCustOvflwFlgStatusVO searchXterCustOvrLenFlgStatus(XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO) throws EventException;
	
	/**
	 * Booking cutomer tab에서 cleared한 customer 정보를 업데이트 한다.
	 *
	 * @param XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO
	 * @param String[] custTpcd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterCustOverFlowStatus(XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO, String[] custTpcd, SignOnUserAccount account) throws EventException;
	
	/**
	 * 
	 * @param bkgNo
	 * @return
	 * @throws EventException
	 */
	public List<SearchBkgContainerVO> searchBkgContainerNo(String bkgNo) throws EventException;
	
	/**
     * Change booking status 'F' when Reactivate
     * 
     * @author      KOUNGIL MOON
     * @param       String bkgNo
     * @exception   EventException
     */
    public void reactBkgStatus(String bkgNo) throws EventException;
    
    /**
   	 * Check Dummy customer list from Hard coding table
   	 * @param String custCntCd
   	 * @param String custSeq
   	 * @throws EventException
   	 */
   	public void searchDmyCustCnt (String custCntCd, String custSeq) throws EventException;
    
}
