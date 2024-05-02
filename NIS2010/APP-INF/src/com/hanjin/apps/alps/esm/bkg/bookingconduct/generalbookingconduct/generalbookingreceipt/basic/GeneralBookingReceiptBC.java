/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptBC.java
*@FileTitle : BKG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
* -------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
* 2010.11.15 이일민 [CHM-201006562-01] Booking Receipt Notice Fax & Email Service 수정 (DOC CCT 추가 및 EDI 기능)
* 2011.04.18 이일민 [CHM-201109371] PKGSC 업무이관관련 DPCS와 SI Mark 연계로직
* 2011.05.27 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.05.31 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.05.31 채창호 [CHM-201110946-01] [ALPS] Hitchment BKG flag update 요청
* 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
* 2011.07.18 김봉균 [CHM-201112282-01] 중국 Solid Waste 관련 bkg commodity validation 추가
* 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
* 2011.12.19 정선용 [CHM-201115046-01]	선적변경시 웹메일 & SMS 서비스 개발 건 보완요청(2차)
* 2012.02.24 금병주 [CHM-201216172-01] Doc. Performance Report ETD 및 PCT 갱신
* 2012.07.02 조정민 [CHM-201218333] BKG Charge 화면에 S/C No 입력및 저장시 Validation 추가
* 2012.09.25 조정민 [CHM-201219852] [BKG] MEMO BL Cancel건의 BKG Status변경 자동처리 (S->F Manual변경처리하는 현행 개선)
* 2014.06.27 문동선 [CHM-201429314] 일본 세관 사전신고제를 위한 Simple/Console default 적용 로직 추가
* 2014.10.16 문동선 [CHM-201431658] 한진해운 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발
=========================================================*/ 
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsChgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BdrSpclVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgClauseLockVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgReactivateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCopyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CmdtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.FwrdRefVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OceanRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PolPodVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SmsRequirementResultVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SpclQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SpclVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngDoubleCallEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdYardCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VvdAssignVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgPreCheckingStatusVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgClzTmVO;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.BkgRollOvrVO;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;

/**
 * ALPS-Generalbookingconduct Business Logic Command Interface<br>
 * - ALPS-Generalbookingconduct에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KimByungKyu
 * @see Esm_bkg_0079_01EventResponse 참조
 * @since J2EE 1.4
 * 
 * 2011.11.08 전성진 [] booking re-activate 기능 추가
 */

public interface GeneralBookingReceiptBC {

	
	/**
	 * BKG_CHG_RT에서 BkgBooking Data에 해당하는 정보를 수정한다.<br>
	 * //[결함관리지침에 따른 이동]
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 * @param String ctrtOfcCd 
	 * @param String ctrtSrepCd 
	 * @exception EventException
	 */
	 public void modifyChgRateBkgBooking(RateMainInfoVO rateMainInfoVO ,String caflag, String ctrtOfcCd, String ctrtSrepCd) throws EventException;
	
	 /**
	 * BL TYPE 수정 처리<br>
	 * 해당 booking 의 BL TYPE  정보을 저장한다<br>
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String blTpCd
	 * @exception EventException
	 */
	public void modifyBlType(String bkgNo ,String blTpCd) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Purchase Other Number와 그외 number 정보를 조회한다..<br>
	 * @author LEE JIN SEO
	 * @param PoOtherNoVO   poOtherNoVO
	 * @return PoOtherNoVO
	 * @exception EventException
	 */
	public PoOtherNoVO searchPoOtherNo(PoOtherNoVO poOtherNoVO) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * 해당 booking 의 reference no을 저장한다.<br>
	 * 전달받은 VO에서 값이 있는 Row만 생성/수정한다..<br>
	 * 아래 유형의 REFERENCE NUMBER만 생성/수정한다..<br>
	 * '-. 화주로 부터 제공받은 참조번호 유형.<br>
	 *  . EBRF : BKG Ref # (ext bkg rqst).<br>
	 *  . EBSH : BKG SH Ref # (ext bkg rqst).<br>
	 *  . EBFF : BKG FF Ref # (ext bkg rqst).<br>
	 *  . RGBK : Regional BKG No..<br>
	 *  . ESRF : S/I Ref # (ext rqst).<br>
	 *  . ESSH : S/I SH Ref # (ext rqst).<br>
	 *  . ESFF : S/I FF Ref # (ext rqst).<br>
	 *  . FINV : INV Ref # 수출업자와 수입업자의 관계<br>
	 *  .<br>
	 * @author LEE JIN SEO
	 * @param PoOtherNoVO   poOtherNoVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageRefNo(PoOtherNoVO poOtherNoVO, String caFlg) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * 해당 booking 의 reference detail (HP, COSTCO )정보을 저장한다<br>
	 * 전달받은 VO에서 값이 있는 Row만 생성/수정한다..<br>
	 * @author LEE JIN SEO
	 * @param PoOtherNoVO poOtherNoVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageRefDetail(PoOtherNoVO poOtherNoVO, String caFlg) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * PO & Other No에 CM정보를 Copy하기 위해 조회한다.<br>
	 * 1. CM data에서 Description, Package Qty/Type, Weight Qty, Measure Qty 정보를 단순 조회한다..<br>
	 * @author LEE JIN SEO
	 * @param PoOtherNoVO poOtherNoVO
	 * @return PoOtherNoVO
	 * @exception EventException
	 */
	public PoOtherNoVO searchCmForPo(PoOtherNoVO poOtherNoVO) throws EventException;

	/**
	 *  Reference 정보를 관리한다.<br>
	 *
	 * @param 	BkgReferenceVO[] bkgReferenceVOs
	 * @param 	SignOnUserAccount account
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void manageRefNo(	BkgReferenceVO[] bkgReferenceVOs,
											SignOnUserAccount account,
											BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 *  House B/L에 해당하는 SCAC No 관리한다.<br>
	 *
	 * @author	KimByungKyu
	 * @param 	BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs
	 * @param 	SignOnUserAccount account
	 * 	@param 	BkgBlNoVO bkgBlNo
	 * @exception EventException
	 */
	public void manageNVOFileNumber(	BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs,
															SignOnUserAccount account,
															BkgBlNoVO bkgBlNo) throws EventException;

	/**
	 * Ocean Route 조회.(ESM_BKG_0092)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	PolPodVvdVO[] polPodVvdVOs
	 * @param   String bkgNo
	 * @return 	OceanRouteVO
	 * @exception EventException
	 */
	public OceanRouteVO searchTsRoute(PolPodVvdVO[] polPodVvdVOs, String bkgNo) throws EventException;

	/**
	 * Ocean Route Lane/POL ETD/POD ETA 조회.(ESM_BKG_0092)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	PolPodVvdVO polPodVvdVO
	 * @return 	VslSkdVO
	 * @exception EventException
	 */
	public VslSkdVO searchLaneEtaEtd(PolPodVvdVO polPodVvdVO) throws EventException;

	/**
	 * Ocean Route Lane/POL ETD/POD ETA 조회.(ESM_BKG_0092)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	PolPodVvdVO[] polPodVvdVOs
	 * @exception EventException
	 */
	public void validateTsRoute(PolPodVvdVO[] polPodVvdVOs) throws EventException;

	/**
	 * Tro quantity 를 변경한다.(ESM_BKG_0079_02A)<br>
	 * 
	 * @author Lee NamKyung 
	 * @param BkgQuantityVO[] arrBkgQuantityVO
	 * @param String boundCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgQtyByTro(BkgQuantityVO[] arrBkgQuantityVO, String boundCd, SignOnUserAccount account) throws EventException;

	/**
	 * 한국 tro request시 booking 정보에 update한다.(ESM_BKG_0079_02B)<br>
	 * 
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void modifyEurPkupRtnCy(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * 구주 tro confirm시 booking 정보에 update한다.(ESM_BKG_0079_02C)<br>
	 * 
	 * @author Shin Jayoung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void modifyKrPkupRtnCy(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * BookingCreation 사용자 Default 정보 조회.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	SignOnUserAccount account
	 * @return 	BkgUsrDfltSetVO
	 * @exception 	EventException
	 */
	public BkgUsrDfltSetVO searchUserBkgDefault(SignOnUserAccount account) throws EventException;

	/**
	 * BookingCreation CmdtCd로 정보 조회.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	String cmdtCd
	 * @return 	CmdtVO
	 * @exception EventException
	 */
	public CmdtVO validatePrecaution(String cmdtCd) throws EventException;

	/**
	 * BookingCreation CmdtCd로 정보 조회.(ESM_BKG_0079_01)<br>
	 *
	 * @param 	String cmdtCd
	 * @return 	String
	 * @exception EventException
	 */
	public String validateChnWasteCmdt(String cmdtCd) throws EventException;

	/**
	 * 미주OB에 대해서 특정 cmdt code를 입력하면 Vehicle에 자동 체크 (ESM_BKG_0079_01)<br>
	 *
	 * @param 	String cmdtCd
	 * @return 	String
	 * @exception EventException
	 */
	public String validateUSVehicleCommodity(String cmdtCd) throws EventException;

	/**
	 * BookingCreation VVD, BKG_NO로 정보 조회.(ESM_BKG_0079_01)<br>
	 *
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param	List<String> paramVvds
	 * @return 	String
	 * @exception EventException  
	 */
	public String searchManifestTrans(BkgBlNoVO bkgBlNoVO, List<String> paramVvds) throws EventException;
	
	/**
	 * cct 정보를 저장<br>
	 * 
	 * @param BkgClzTmVO[] bkgClzTmVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageCargoClosingTime(BkgClzTmVO[] bkgClzTmVOs,SignOnUserAccount account )throws EventException;

	/**
	 * BookingCreation 정보 조회.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	BookingCreationVO
	 * @exception EventException
	 */
	public BookingCreationVO searchBooking(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Booking 생성/수정시 입력값이 적합한지 확인한다.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @return 	bookingCreationVO
	 * @exception 	EventException
	 */
	public BookingCreationVO validateBookingSave(BookingCreationVO bookingCreationVO, SignOnUserAccount account) throws EventException;
	/**
	 * Booking을 생성한다.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @exception EventException
	 */
	public void createBooking(BookingCreationVO bookingCreationVO,SignOnUserAccount account ) throws EventException;

	/**
	 * 수정전 Booking 정보를 조회한다.(ESM_BKG_0079_01)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	OldBkgInfoVO
	 * @exception 	EventException
	 */
	public OldBkgInfoVO searchOldBkgInfo(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Booking을 수정한다..(ESM_BKG_0079_01 김병규)<br>
	 * @author	KimByungKyu
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @return		BookingSaveValidationVO
	 * @exception 	EventException
	 */
	public BookingSaveValidationVO modifyBooking(BookingCreationVO bookingCreationVO,SignOnUserAccount account ) throws EventException;


    /**
     * Booking을 수정한다.(ESM_BKG_007901)<br>
     *
     * @author 		
     * @param 		BkgBookingVO bkgBookingVO
	 * @param		String caFlg
     * @exception 	EventException
     */
    public void modifyBkgByCm(BkgBookingVO bkgBookingVO, String caFlg) throws EventException;

	/**
	 * Booking Stauts을 수정한다.(ESM_BKG_007901)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		String newStsCd
	 * @param 	  	BkgBlNoVO bkgBlNoVO
	 * @param 		boolean validation
	 * @param 		SignOnUserAccount account
	 * @return		boolean
	 * @exception 	EventException
	 */
    public boolean changeBkgStatus(String newStsCd, BkgBlNoVO bkgBlNoVO, boolean validation, SignOnUserAccount account) throws EventException;

    /**
     * Bkg의 bkg_referenece, bkg_ref_dtl을 cntr별로 삭제한다.<br>
     * 
     * @param bkgNo
     * @param cntrNo
     * @param caFlg
     * @throws EventException
     */
    public void removeReferenceByCntr(String bkgNo, String cntrNo, String caFlg) throws EventException;

    /**
     * Bkg의 bkg_referenece을 cntr별로 삭제한다.<br>
     * 
     * @param bkgNo
     * @param cntrNo
     * @param caFlg
     * @throws EventException
     */
    public void removeReferenceDetailByCntr(String bkgNo, String cntrNo, String caFlg) throws EventException;

    /**
     * Bkg의 bkg_ref_dtl을 cntr별로 삭제한다.<br>
     * @param bkgNo
     * @param cntrNo
     * @param cntrNoOld
     * @param caFlg 
     * @throws EventException
     */
    public void changeReferenceDetailByCntr(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException;

    /**
	 * 변경된 Reference No 정보를 update한다.<br>
     * @param String bkgNo
     * @param String cntrNo
     * @param String cntrNoOld
     * @param String caFlg 
     * @throws EventException
     */
    public void changeReferenceByCntr(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException;

	/**
	 *  BKG_CLZ_TM 삭제.(ESM_BKG_0079_01)<br>
	 *  
	 * @author 	KimByungKyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	String modeCd
     * @exception EventException
     */
    public void removeBkgClzTm(BkgBlNoVO bkgBlNoVO, String modeCd) throws EventException;
	/**
	 * Booking을 Cancel한다.(ESM_BKG_007901)<br>
	 * 
	 * @author 	KimByungKyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBooking(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
    
	/**
     * Booking관련 정보를 sourceBkg에서 targetBkg으로 복사한다. split과 cod에서 사용한다 (ESM_BKG_0099)
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param SplitBkgVO splitBkgVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String copyBookingForSplit (BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, SplitBkgVO splitBkgVO,SignOnUserAccount account)throws EventException;
    
    
    /**
	 *  Booking 상태코드를 변경한다.(ESM_BKG_0055)<br>
	 * 
	 * @param SpclQtyVO spclQtyVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyAwkQty(SpclQtyVO spclQtyVO, String caFlg) throws EventException;
	
	/**
	 *  bkg_Booking.awk_cgo_flg를 변경한다.(ESM_BKG_0055)<br>
	 * 
	 * @param SpclVO spclVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyBkgBySpcl(SpclVO spclVO, String caFlg) throws EventException;
    
    
    
	/**
	 *  bkg_Booking.awk_cgo_flg를 변경한다.(ESM_BKG_0055)<br>
	 * 
	 * @param String xterRqstViaCd
	 * @param String saveModeCd
	 * @param String autoNotification
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgByXter(String xterRqstViaCd, String saveModeCd, String autoNotification, XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws EventException;
	/**
	 * Empty Repo Booking에 대해서 Booking 정보를 생성/update한다<br>
	 * 
     * @author		KimByungKyu
	 * @param 		MtyBookingCreateVO mtyBookingCreateVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void createMtyRepoBooking(MtyBookingCreateVO mtyBookingCreateVO, SignOnUserAccount account) throws EventException;

	/**
	 * Booking Creation시 Customer Information 정보 조회.(ESM_BKG_007905)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return		BlCustomerVO
	 * @exception 	EventException
	 */
	public BlCustomerVO searchBlDocCust(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Customer Information 생성시 Validation 체크.(ESM_BKG_007905)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BlCustomerVO blCustomerVO
	 * @return		String[]
	 * @exception 	EventException
	 */
	public String[] validateBlDocCust(BlCustomerVO blCustomerVO) throws EventException;	

	/**`
	 * 화주 정보를 수정한다.(ESM_BKG_007905)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BlCustomerVO blCustomerVO
	 * @param 		String bkgFlg 
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyBlDocCust(BlCustomerVO blCustomerVO, String bkgFlg, SignOnUserAccount account) throws EventException;
	
	/**
	 * bkg_bl_doc에 ORG_CNT_NM column을 update한다<br>
	 * 
     * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String orgCntNm
	 * @param 		SignOnUserAccount account
	 * @param 		String oldActCustCd
	 * @param 		String newActCustCd
	 * @exception 	EventException
	 */
    public void modifyBlDocExpCust(BkgBlNoVO bkgBlNoVO, String orgCntNm, SignOnUserAccount account, String oldActCustCd, String newActCustCd) throws EventException;	

	/**
	 * ANCS, ROCS에서 저장된 Inbound Notify 정보를 수정한다.(ESM_BKG_0045, 0442)<br>
	 * 
	 * @author 		Jang Jiyoung
	 * @param 		String bkgNo
	 * @param 		String notifyNm
	 * @param 		String notifyAddr
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyIbCustNmAddr(String bkgNo, String notifyNm, String notifyAddr, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Cargo Detail Information 조회.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return		CargoDetailVO
	 * @exception 	EventException
	 */
	public CargoDetailVO searchCargoDetail(BkgBlNoVO bkgBlNoVO) throws EventException;	

	/**
	 * BkgQtyDtl 정보를 저장한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgQtyDtlVO[] bkgQtyDtlVOs
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void manageBkgQtyDtl(BkgQtyDtlVO[] bkgQtyDtlVOs, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * bkg_cod에서 bkg_booking으로 t/vvd, pod, pod_node, del, del_node를 update한다.<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgBlNoVO codBkg
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBookingFromCod (BkgBlNoVO bkgBlNoVO, BkgBlNoVO codBkg, String codRqstSeq , SignOnUserAccount account ) throws EventException;

	/**
	 * Combine에서 Qty와 Qty Dtl 내용을 Master Bkg로 합한다.<br>
	 * 
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO[] sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String hitchmentYn
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void combineQty (BkgBlNoVO[] sourceBkg , BkgBlNoVO targetBkg, String hitchmentYn,SignOnUserAccount account) throws EventException;

	/**
	 * Combine에서 bkg_referenece 내용을 Master Bkg의 referenece로 합한다.<br>
	 * 
	 * @author Jun Yong Jin
	 * @param String copyModeCd
	 * @param BkgBlNoVO[] sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String[] cntrNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyBkgRefByBkg (String copyModeCd, BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg , String[] cntrNo, SignOnUserAccount account) throws EventException;

    /**
     * Bkg의 bkg_referenece를 Target Bkg로 복사한다.<br>
     * @param cntrCopyVO
     * @exception EventException
     */
    public void copyBkgRefByCntr(CntrCopyVO cntrCopyVO) throws EventException;

	/**
	 * customer 정보를 원본 bkg 로부터 복사한다.<br>
	 * 
	 * @param BlCopyInVO blCopyInVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyCustByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws EventException;

    /**
     * Bkg의 bkg_referenece를 cntr별로 삭제한다.<br>
     * @param String bkgNo
     * @param String cntrNo
     * @param String seq
     * @exception EventException
     */
    public void removeBkgRefByCntr(String bkgNo, String cntrNo, String seq) throws EventException;

	/**
	 * Partial container를 사용하는 Booking들의 route를 한번에 변경하기위해 참고 data를 조회한다..<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return		PartialBkgVO
	 * @exception 	EventException
	 */
	public PartialBkgVO searchPartialCntrBkg(BkgBlNoVO bkgBlNoVO) throws EventException;    

	/**
	 * Booking의 orgin, dest route를 update한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		PartialBkgInfoVO partialBkgInfoVO
	 * @param 		VslSkdVO[] vslSkdVOs
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyBkgRouteForPartialBkg(PartialBkgInfoVO partialBkgInfoVO, VslSkdVO[] vslSkdVOs, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * C/A를 위해 booking 관련 table을 복사한다.<br>
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param       String copyTypeCd
	 * @exception 	EventException
	 */
	public void createBookingCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * C/A를 위해 booking 관련 table을 삭제한다.<br>
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param       String copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	/**
	 * booking Copy를 하기 위해 원본이되는 booking의 data를 조회한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return		BookingCopyVO
	 * @exception 	EventException
	 */
	public BookingCopyVO searchBkgForCopy(BkgBlNoVO bkgBlNoVO) throws EventException;	
	
	/**
	 * 원본 Booking의 data를 검사하고 조합하여 new booking의 data를 생성함.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BookingCopyVO bookingCopyVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void validateBkgCopy(BookingCopyVO bookingCopyVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Booking을 Copy한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BookingCopyVO bookingCopyVO
	 * @param 		BkgBlNoVO sourceBkg
	 * @param 		BkgBlNoVO targetBkg
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void copyBooking(BookingCopyVO bookingCopyVO, BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account)  throws EventException;		
	
	/**
	 * roll over 정보를 update<br>
	 * 
	 * @author 		
	 * @param 		BkgRollOvrVO[] bkgRollOvrVOs
	 * @exception EventException
	 */
	public void manageBkgRollOver(BkgRollOvrVO[] bkgRollOvrVOs)throws EventException;	

	/**
	 * empty repo Booking을 split한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		MtyBookingSplitVO mtyBookingSplitVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void splitMtyRepoBooking(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException;	

	/**
	 * empty repo booking의 split을 마무리한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		MtyBookingSplitVO mtyBookingSplitVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void completeMtyRepoBkgSplit(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Empty Booking을 Cancel한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void cancelMtyBkg(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Empty Repo Booking에 대해서 Booking 정보를 생성/update한다..<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyMtyRepoBkg(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws EventException ;	
	
	/**
	 * empty repo booking의 Container정보 저장을 마무리한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
	 * @param 		SignOnUserAccount account
	 * @return		List<BkgQuantityVO>
	 * @exception 	EventException
	 */
	public List<BkgQuantityVO> completeModifyMtyRepoBkg(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws EventException;	

	/**
	 * 말레이지아 지역에서 Booking별로 forwarder code와 vsl reference 정보를 수정한다.(ESM_BKG_0616)
	 * 
	 * @author 		Jun Yong Jin
	 * @param 		FwrdRefVvdVO[] fwrdRefVvdVO
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void manageMyFwrdRefVvd(FwrdRefVvdVO[] fwrdRefVvdVO, SignOnUserAccount account) throws EventException ;	

	/**
	 * split, combine 후 변경된 data로 bkg_booking의 spcl flag를 수정함<br>
	 * 
	 * @author		RyuDaeYoung
	 * @param 		BkgBlNoVO[] bkgBlNoVO
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifySpclFlag(BkgBlNoVO[] bkgBlNoVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * vsk_vsl_port_skd 쪽 수정 사항을 bkg_vvd에 update함<br>
	 * 
	 * @author 		RyuDaeYoung
	 * @param 		List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs
	 * @param       SignOnUserAccount account
	 * @throws 		EventException
	 */
	public void modifyBkgVvdForVslSkdCng(List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs, SignOnUserAccount account)throws EventException ;
	
	/**
	 * vsk_vsl_port_skd ETA 변경시 Notice를 전송함<br>
	 * 
	 * @author 		RyuDaeYoung
	 * @param 		List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs
	 * @param       SignOnUserAccount account
	 * @throws 		EventException
	 */
	public void sendVslSkdCngNotice(List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs, SignOnUserAccount account)throws EventException ;
	
	/**
	 * Booking의 Ocean Route만 수정한다.<br>
	 * 
	 * @param VvdAssignVO vvdAssignVO
	 * @param SignOnUserAccount account
	 * @return BdrSpclVO
	 * @exception EventException
	 */
	public BdrSpclVO modifyOceanRoute(VvdAssignVO vvdAssignVO,SignOnUserAccount account)throws EventException ;
	
	/**
	 * Booking의 status를 강제로 수정한다.<br>
	 * 
	 * @author 	RyuDaeYoung
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String compFirm(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException ;
	
    /**
     * C/A 진행건에 COD에서 입력한 정보를 저장한다.<br>
     * @param BkgBlNoVO bkgBlNoVO
     * @param String codRqstSeq
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyTempHistForCOD (BkgBlNoVO bkgBlNoVO, String codRqstSeq, SignOnUserAccount account) throws EventException;
    
    /**
     * Group VVD/Port Assign에서 입력한 정보를 저장한다.<br>
     * @param BkgBlNoVO bkgBlNoVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyBkgRollOvr (BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
    
    
    /**
     * SpecialCargo에 입력한 VoidQty를 저장한다.<br>
     * @param String bkgNo
     * @param String ovrVoidSltQty
     * @param  String caFlg
     * @exception EventException
     */
    public void modifyBbVoidQty (String bkgNo, String ovrVoidSltQty, String caFlg) throws EventException;
    
	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * Customer Code Validation한  Unmatch 정보를 update 한다.<br>
     * @author Park Mangeon
	 * @param CustCdEvaluationVO[] custCdVal
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void modifyCustCdValInfo(CustCdEvaluationVO[] custCdVal, SignOnUserAccount account) throws EventException;
    
	/**
     * UI_BKG-1054 Customer Code Validation<br>
     * Customer Code Validation작업으로 Match된 정보를 Unmatch로 변경한다.<br>
     * @author Park Mangeon
	 * @param String bkgNo
	 * @param String bkgCustTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeCustCdValInfo(String bkgNo, String bkgCustTpCd, SignOnUserAccount account) throws EventException;
	
	/**
	 * UI-BKG-1054 Customer Code Validation<br>
	 * Booking Customer와 MDM정보를 비교하여 일치하는 정보에 대하여 match되었다고 수정한다.<br>
	 * @param ArrNtcSearchVO arrNtcSearch 검색조회 조건
	 * @throws EventException
	 * @author Park Mangeon
	 */
	public void modifyBkgCustValInfo(ArrNtcSearchVO arrNtcSearch ) throws EventException;
	
	/**
	 * Inbound - Remove Customer Code Validation<br>
	 * Booking단위로 Customer Code Validation을 제거한다.<br>
	 * @param String bkgNo 부킹번호
	 * @throws EventException
	 * @author Park Mangeon
	 */
	public void cancelCustCdVal(String bkgNo) throws EventException;
	
	/**
	 * Inbound - UI-BKG-0941 - Customer Code Error Report Confirm<br>
	 * Code Validation결과를 재평가 한다.<br>
	 * @param ArrNtcCustCodeErrListVO[] custCodeErrLists
	 * @throws EventException
	 * @author Park Mangeon
	 */
	public void confirmCustCdErrReport(ArrNtcCustCodeErrListVO[] custCodeErrLists ) throws EventException;

	/**
     * ocean route Validation<br>
     * 변경하려는 route가 ocean route로 등록되어 있는지 확인한다.<br>
     * @param PrdMainInfoVO prdMainInfoVO
     * @author Ryu Daeyoung
	 * @exception EventException
	 */
	public void validateOceanRoute(PrdMainInfoVO prdMainInfoVO) throws EventException;

	/**
     * cargo Closing Time을 생성한다.<br>
     * @author Ryu Daeyoung
     * @param BkgBlNoVO bkgBlNoVO
     * @param String fromDt
     * @param String toDt
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCargoClosingTime(BkgBlNoVO bkgBlNoVO, String fromDt, String toDt, SignOnUserAccount account) throws EventException;

	/**
     * rail receiving time 계산을 위해 bkg_quantity를 조회한다.<br>
     * @author Ryu Daeyoung
     * @param BkgBlNoVO bkgBlNoVO
     * @return PrdQtyInfoVO[]
	 * @exception EventException
	 */
	public PrdQtyInfoVO[] searchBkgQtyForRailTime(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
     * 입력한 vvd중 trunk vvd를 coa 항차 기준으로 계산한다.<br>
     * @author Ryu Daeyoung
     * @param PolPodVvdVO[] polPodVvdVOs
     * @return String
	 * @exception EventException
	 */
	public String searchTrnkVvdByRlane(PolPodVvdVO[] polPodVvdVOs) throws EventException;
	/**
     * Arrival Notice 기록수정
     * @param ArrNtcCustListVO[] arrNtcCustListVOS
     * @throws EventException
     */
    public void modifyArrNtcCustChgFlg ( ArrNtcCustListVO[] arrNtcCustListVOS)throws EventException;

	/**
     * c/a tmp를 지워야하는 지 조회
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
     * @throws EventException
     */
	public String searchCaTmp(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
     * eBkg에서 P/O no 조회
     * @param BkgBlNoVO bkgBlNoVO
     * @return PoOtherNoVO
     * @throws EventException
     */
	public PoOtherNoVO searchPoOtherNoByXter(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
     * booking split 화면에서 split시 CBF를 조회
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
	 * @param SignOnUserAccount account
     * @throws EventException
     */
	public String searchCbfFlag(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
     * cargo Closing Time을 수정한다.<br>
     * @param BkgClzTmVO bkgClzTmVO
	 * @exception EventException
	 */
	public void modifyCargoClosingTime(BkgClzTmVO bkgClzTmVO) throws EventException;

	/**
     * modifySiFlag<br>
     * @param String bkgNo
	 * @param String siFlag
	 * @exception EventException
	 */
	public void modifySiFlag(String bkgNo, String siFlag) throws EventException;

	/**
	 * ESM_BKG_0702 : customer click <br>
	 * Customer정보를 Flat File로 생성하여 EDI로 전송한다.<br>
	 * 
	 * @param BkgBlNoVO[] bkgBlNoVO
	 * @param CustTpIdVO[] custTpIdVO
	 * @param String typeGbn
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String sendBkgCustEdiMulti(BkgBlNoVO[] bkgBlNoVO, CustTpIdVO[] custTpIdVO, String typeGbn, SignOnUserAccount account) throws EventException;

	/**
	 * Customer EDI로 전송 BackEndJob 결과확인<br>
	 * 
	 * @param String key
	 * @return String
	 * @throws EventException
	 */
	public String searchSendBkgCustEdiMulti(String key) throws EventException;
	
	 /**
     * reactivate 하는 경우 booking status를 F로 변경한다.<br>
     * 
     * @author      KimByungKyu
     * @param       String bkgNo
     * @exception   EventException
     */
    public void reactBkgStatus(String bkgNo) throws EventException;

	/**
	 * @param String bkgNo
	 * @return boolean
	 * @throws EventException
	 */
	public boolean chkSmsRequirement(String bkgNo) throws EventException;

	/**
	 * @param String slanCd
	 * @param String bkgOfcCd
	 * @param String dirCd
	 * @param String polCd
	 * @param String bkgNo
	 * @return List<BkgUserSmsListVO>
	 * @throws EventException
	 */
	public List<BkgUserSmsListVO> getPhnId(String slanCd, String bkgOfcCd, String dirCd, String polCd, String bkgNo) throws EventException;

	/**
	 * @param String bkgNo
	 * @param String oldFirstVvd
	 * @param String newFirstVvd
	 * @param String bkgPolCd
	 * @param String bkgPolCdOld
	 * @return boolean
	 * @throws EventException
	 */
	public boolean chkSmsRequirementVvdChanged(String bkgNo, String oldFirstVvd, String newFirstVvd, String bkgPolCd, String bkgPolCdOld) throws EventException;

	/**
	 * @param BkgBlNoVO schBkgBlNoVO
	 * @return List<VslSkdVO>
	 * @throws EventException
	 */
	public List<VslSkdVO> searchVvdSkdForTsRoute(BkgBlNoVO schBkgBlNoVO) throws EventException;
	/**
	 * @param String bkgNo
	 * @param String oldFirstVvd
	 * @param String newFirstVvd
	 * @param String bkgPolCd
	 * @param String bkgPolCdOld
	 * @return List<SmsRequirementResultVO>
	 * @throws EventException
	 */
	public List<SmsRequirementResultVO> getSmsRequirementResult(String bkgNo,
			String oldFirstVvd, String newFirstVvd, String bkgPolCd, String bkgPolCdOld) throws EventException;
	
	
	/**
	 * BKG_Quantity 정보를 조회한다.
	 * @param bkgBlNoVO
	 * @return List<BkgQuantityVO>
	 * @throws EventException
	 */
	public List<BkgQuantityVO> searchBkgQuantity(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * pct를 조회한다.
	 * @param String bkgNo
	 * @param String caFlg
	 * @return string pct
	 * @throws EventException
	 */
	public String searchPct( String bkgNo, String caFlg ) throws EventException;
	
	/**
	 * pct를 수정한다.
	 * @param bkgBlNoVO
	 * @param pct
	 * @throws EventException
	 */
	public void modifyPct(BkgBlNoVO bkgBlNoVO,String pct) throws EventException;
	
	/**
	 *  bkg_ref NO를 변경한다.(ESM_BKG_0229)<br>
	 * @param String bkgNo
	 * @param BkgReferenceVO[] bkgReferenceVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBkgByXter(String bkgNo, BkgReferenceVO[] bkgReferenceVOs, SignOnUserAccount account) throws EventException;
	

	/** pct를 조회한다.
	 * @param String scNo
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchScType(String scNo, BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * 하위 BKG가 모두 Cancel 된 경우의 bkg_no를 조회한다.
	 * @param String bkgNo
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchMemoSplitFromBkgNo(String bkgNo) throws EventException;
	
    /**
     * Memo Split 이 전체 cancel 된 경우 Master BKG의 상태를 변경한다.<br>
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @param SignOnUserAccount account
     * @exception DAOException
     */
	public void modifyMemoSplitBkgStatus(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Booking-Special Stowage (MUPG) 자동 지정<br>
	 * 
	 * @param bkgNo
	 * @param stwgCd
	 * @param caFlg
	 * @throws EventException
	 */
	public void modifyCmFlgBySpcl(String bkgNo, String stwgCd, String caFlg) throws EventException;

	/**
	 * T/S Close에 대한 Notice를 전송한다<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param String closedtsVvds
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendTsCloseNotice(BkgBlNoVO bkgBlNoVO, String closedTsVvds, SignOnUserAccount account) throws EventException;

	/**
	 * Pre checking Status를 저장한다<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param DgPreCheckingStatusVO dgPreCheckingStatusVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyDGPreChkSts(BkgBlNoVO bkgBlNoVO, DgPreCheckingStatusVO dgPreCheckingStatusVO,
			SignOnUserAccount account) throws EventException;

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
	 * Allocation Status를 Change.<br>
	 * 
	 * @param AllocStsVO allocStsVO
	 * @param BkgBlNoVO bkgblNoVO
	 * @param SignOnUserAccount account
	 * @return AllocStsChgVO
	 * @throws EventException
	 */
	public AllocStsChgVO modifyAllocStatus(AllocStsVO allocStsVO, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
	 * SI_FLG 를 조회한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSiFlg(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * Full Return CY 를 지운다. <br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @throws EventException
	 */
	public void modifyFullRtnCy(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * KR_CSTMS_CUST_TP_CD 를 Update 한다. <br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param String mode
	 * @throws EventException
	 */
	public void modifyKrCstmsCustTpCd(BkgBlNoVO bkgBlNoVO, String mode) throws EventException;
	
	/**
	 * NO_RT_STS_CD 를 Update 한다. <br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param String noRtStsCd
	 * @return int
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public int modifyNoRtStsCd(BkgBlNoVO bkgblNoVO, String noRtStsCd, SignOnUserAccount account) throws EventException;
	
	/**
	 * CUST_REF_NO_CTNT 를 조회한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String bkgRefTpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCustRefNoCtnt(BkgBlNoVO bkgBlNoVO, String bkgRefTpCd) throws EventException; 		
	
	/**
	 * Doc User ID 수정<br>
	 * Doc User ID가 HOMEPAGE인 경우 사용자 ID를 업데이트 한다.<br>
	 * @author KIM JIN JOO
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String usrId
	 * @exception EventException
	 */
	public void modifyDocUserId(String bkgNo ,String caFlg, String usrId) throws EventException;
	
	/**
	 * bouble calling 시 vak skd yard chg notice 를 발송한다.<br>
	 * <br>
	 * @author 
	 * @param VslSkdYardCngNoticeVO vslSkdYardCngNoticeVO
	 * @param List<VslSkdCngDoubleCallEtcVO> vslSkdCngDoubleCallEtcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendVskSkdYardCngNotice(VslSkdYardCngNoticeVO vslSkdYardCngNoticeVO, List<VslSkdCngDoubleCallEtcVO> vslSkdCngDoubleCallEtcVOs ,SignOnUserAccount account) throws EventException;   

	/**
	 * CA 를 통해 첫 배가 바뀌었는지 체크. <br>
	 * <br>
	 * @author 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception EventException
	 */
	public String checkFirstVvdChgByCa(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * CA confirm 시에 BKG_ROLL_OVR 를 생성한다. <br>
	 * <br>
	 * @author 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgRollOvrForCa(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
	 * SPC 로직으로 Allocation Status를 업데이트한다.<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param AllocStsVO allocStsVO
	 * @param SignOnUserAccount account
	 * @return AllocStsChgVO
	 * @throws EventException
	 */
	public AllocStsChgVO modifyAllocStatusForBkg(BkgBlNoVO bkgBlNoVO, AllocStsVO allocStsVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * SPC 로직으로 Allocation Status를 업데이트한다.
	 * SPC 에서 호출하는 경우는 전부 F(Firm)<br>
	 * 
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return boolean
	 * @throws EventException
	 */
	public boolean modifyAllocStatusForSpc(String bkgNo, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Clause Lock을  관리한다.<br>
	 *
	 * @param 	BkgClauseLockVO[] bkgClauseLockVOs
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
    public void manageBkgClauseLock(BkgClauseLockVO[] bkgClauseLockVOs, SignOnUserAccount account) throws EventException ;
    
    /**
	 * Clause Lock 정보를 조회한다.
	 * @param String bkgNo
	 * @param String  cluzLckTpCd
	 * @return List<BkgClauseLockVOs>
	 * @throws EventException
	 */
	public List<BkgClauseLockVO> searchBkgClauseLock(String bkgNo, String  cluzLckTpCd) throws EventException;
	
	/**
	 * COP의 UpdateBkg 메서드 call을 BackEndJob으로 처리
	 * 
	 * @author 
	 * @param String bkgNo
	 * @param String mapSeq
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String callCopUpdateBkgBackEnd(String bkgNo, String mapSeq, SignOnUserAccount account) throws EventException;
	
	/**
	 * COP의 SplitBkg 메서드 call을 BackEndJob으로 처리
	 * 
	 * @author 
	 * @param String bkgNo
	 * @param String[] newBkgNoArr
	 * @param String[] copMapSeqArr
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String callCopSplitBkgBackEnd(String bkgNo, String[] newBkgNoArr, String[] copMapSeqArr, SignOnUserAccount account) throws EventException;

	/**
	 * COP의 combineBkg 메서드 call을 BackEndJob으로 처리
	 * 
	 * @author 
	 * @param String[] combinedBkgNo
	 * @param String targetBkg
	 * @param List<CombineTroNewSeqVO> combineTroNewSeqVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String callCopCombineBkgBackEnd(String[] combinedBkgNo, String targetBkg, List<CombineTroNewSeqVO> combineTroNewSeqVOs, SignOnUserAccount account) throws EventException;

	
	/**
	 * china bkg no가 기존에 생성되어 있는지 조회한다.<br>
	 * 
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	EventException
	 */
	public String searchChnBkgNoExist(BkgBlNoVO bkgBlNoVO) throws EventException ;
	
	/**
	 * BKG Reactive(0078) 화면 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String tVvd
	 * @param String polCd
	 * @param String podCd
	 * @param String sts
	 * @param String cxlRsn
	 * @return 		List<BkgReactivateVO>
	 * @exception 	EventException
	 */
	public List<BkgReactivateVO> searchBkgReactivate(String bkgNo, String tVvd, String polCd, String podCd, String sts, String cxlRsn) throws EventException ;
	
	/**
	 * BKG black 키워드 리스트에 걸리는지 check한다
	 * @param String custNm
	 * @return String
	 * @exception EventException
	 */
	public String checkBlockCustName(String custNm) throws EventException ;
	
	/**
	 * ESM_BKG_0090 <br>
	 * 지정된 Contract No에 맞는 Stowage Code인지 여부를 체크<br>
	 * @param stwgCd
	 * @param ctrtNo
	 * @return String
	 * @exception EventException
	 */
	public String validateStwgCdbyCtrtNo(String stwgCd, String ctrtNo) throws EventException;
	
	/**
	 * RFA Holder Name이 shpr / cnee / freight forwarder 셋 중 어딘가에 있는지 체크.
	 * @param bkgNo
	 * @param rateFlg
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchRFAHolderNameByShprCneeFF(String bkgNo, String rateFlg) throws EventException;
	
	/**
	 * Export Ref.란에 RFA Holder Name을 자동 Copy.
	 * @param bkgNo
	 * @param rfaHolderNm
	 * @return int
	 * @throws EventException
	 */	
	public void modifyExportRefNmByRfaHolderNm(String bkgNo, String rfaHolderNm) throws EventException;
	
	/**
	 * R-BKG -> Firm 변경시 Notice 대상인지 체크한다.
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchConfirmBookingNotice(String bkgNo) throws EventException;
	
}
