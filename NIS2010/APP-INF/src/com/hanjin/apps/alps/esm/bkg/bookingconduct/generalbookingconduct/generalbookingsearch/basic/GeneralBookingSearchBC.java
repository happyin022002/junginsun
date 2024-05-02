/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchBC.java
*@FileTitle : Transhipment Route and VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.04.30 김병규
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2010.11.15 이일민 [CHM-201006562-01] Booking Receipt Notice Fax & Email Service 수정 (DOC CCT 추가 및 EDI 기능)
* 2011.03.21 이일민 [CHM-201109384-01] Mis-Sales C/A 발생시 Sales Rep에 자동 경고 메세지 송부
* 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
* 2011.10.14 정선용 [CHM-201113680-01] 남미 5개 국가(브라질, 에콰도르, 도미니카 공화국, 콜롬비아, 우루과이)  BDR이후 C/A issue 직전
* 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
* 2011.11.28 금병주 [CHM-201114706-01] [BKG_1139 :U/I제출] EUR TRO Notice 전송 Pop-up
* 2012.04.02 변종건 [CHM-201216424-01] ALPS Customer Advisory 기능 보완 검토 요청 (Template 문서 첨부 등)
* 2012.08.03 이재위 [CHM-201218218] Simple S/I Download 기능 강화를 위한 CUP, ALPS 변경 요청
* 2012.09.17 김보배 [CHM-201220181] [BKG] ALPS Bkg/Doc Customer Advisory Send 기능 보완 요청 (30초룰 해제)
* 2014.01.14 문동선 [CHM-201328181] [BKG] Space allocation 연계 Waiting booking process 개발 Project
* 2014.08.29 문동선 [CHM-201431517] Pre-Caution 반영 Alert 메세지 생성 로직 삽입 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.AlocStandbyReasonVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgChgOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCreCustInqCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcRmkVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSchVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndHisSchVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcUploadVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgReceiptSendVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ClzTmListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrChkDigitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrInfoForEmptyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CustomsHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.DocHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.EstimatedCMPBVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistMainVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.MtyBkgTsRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NoticeHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.OfcRepInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.OfcRepListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.PrdConstraintVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.QtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RollOvrInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchActualCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchCustomerInqryCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchCustomerInqryVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgEdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgFaxEmailVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SvcRouteModeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TSRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.UsaCstmsFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.YardAssignVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustInqVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;
import com.hanjin.syscommon.common.table.ScgAproRqstVO;

/**
 * ALPS-Generalbookingconduct Business Logic Command Interface<br>
 * - ALPS-Generalbookingconduct에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KimByungKyu
 * @see Esm_bkg_0650EventResponse 참조
 * @since J2EE 1.4
 */

public interface GeneralBookingSearchBC {




	/**
	 * TS Route 정보 조회
	 *
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String codRqstSeq
	 * @param 		String opCd
	 * @return 		List<TSRouteVO>
	 * @exception 	EventException
	 */
	public List<TSRouteVO> searchIbTsRoute(BkgBlNoVO bkgBlNoVO, String codRqstSeq, String opCd) throws EventException;

	///**
	 //* Customer Inquiry 화면의 Retrieve 이벤트 처리<br>
	 //*
	 //* @param 		String custCntCd
	 //* @param 		String custSeq
	 //* @param 		String custNm
	 //* @param 		String ofcCd
	 //* @return 		BkgCreCustInqVO
	 //* @exception 	EventException
	// */
	//public BkgCreCustInqVO searchBkgCreCustCntc(	String custCntCd,
	//																			String custSeq,
	//																			String custNm,
	//																			String ofcCd) throws EventException;
	
	/**
	 * Customer Inquiry 화면의 Retrieve 이벤트 처리<br>
	 *
	 * @param 		BkgCreCustInqCondVO bkgCreCustInqCondVO
	 * @return 		BkgCreCustInqVO
	 * @exception 	EventException
	 */
	public BkgCreCustInqVO searchBkgCreCustCntc(BkgCreCustInqCondVO bkgCreCustInqCondVO) throws EventException;
	
	/**
	 * Customer Inquiry 화면의 Customer 목록 클릭시 이벤트 처리<br>
	 *
	 * @param 		String custCntCd
	 * @param 		String custSeq
	 * @return 		BkgCreCustInqVO
	 * @exception 	EventException
	 */
	public BkgCreCustInqVO searchCustContact(String custCntCd ,String custSeq) throws EventException;

	/**
	 *  Service Mode & Route 정보를 조회한다.<br>
	 *
	 * @param 		bkgBlNoVO   BkgBlNoVO
	 * @return 		SvcRouteModeVO
	 * @exception 	EventException
	 */
	public SvcRouteModeVO searchSvcRouteMode(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Constraint 조회<br>
	 *
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<PrdConstraintVO>
	 * @exception 	EventException
	 */
	public List<PrdConstraintVO> searchConstraint(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Node Search 조회<br>
	 *
	 * @param 		NodeListInputVO nodeListInputVO
	 * @return 		List<NodeListVO>
	 * @exception 	EventException
	 */
	public List<NodeListVO> searchNodeCode(NodeListInputVO nodeListInputVO) throws EventException;

	/**
	 * Location List 조회<br>
	 *
	 * @author		KimByungKyu
	 * @param 		LocationListInputVO locationListInputVO
	 * @return 		List<LocationListVO>
	 * @exception 	EventException
	 */
	public List<LocationListVO> searchLocationList(LocationListInputVO locationListInputVO) throws EventException;
	
	/**
	 * Reference Number 정보를 조회한다<br>
	 *
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<RefNoVO>
	 * @exception 	EventException
	 */
	public List<RefNoVO> searchBkgReference(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Direct NVO-AMS File No를 조회한다<br>
	 *
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		UsaCstmsFileListVO
	 * @exception 	EventException
	 */
	public UsaCstmsFileListVO searchNVOFileNumberList(BkgBlNoVO bkgBlNoVO) throws EventException;


	/**
	 * 해당 booking의 cct 정보를 조회<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return ClzTmListVO
	 * @exception EventException
	 */
	public ClzTmListVO searchCargoClosingTime(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException;

	/**
	 * Customer Code 조회
	 * @param SearchActualCustomerVO searchActualCustomerVO
	 * @return List<SearchActualCustomerVO>
	 * @exception EventException
	 */
	public List<SearchActualCustomerVO> searchActualCustomer(SearchActualCustomerVO searchActualCustomerVO) throws EventException;

	/**
	 * Empty Repo Bkg에 속해 있는 Container No List를 조회한다.(ESM_BKG_9450)
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<CntrInfoForEmptyVO>
	 * @exception EventException
	 */
	public List<CntrInfoForEmptyVO> searchEmptyCntrByBKG(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * 모든 Service Scope의 Code와 Name을 조회한다.(ESM_BKG_0654)
	 * 
	 * @author		KimByungKyu
	 * @return 		List<MdmSvcScpVO>
	 * @exception 	EventException
	 */
	public List<MdmSvcScpVO> searchSvcScp() throws EventException;

	/**
	 * 화주 계약서상의 RFA를 조회한다.(ESM_BKG_0654)
	 * 
	 * @author		KimByungKyu
	 * @param 		RfaListInputVO rfaListInputVO
	 * @return 		List<RfaListVO>
	 * @exception 	EventException
	 */
	public List<RfaListVO> searchRfaList(RfaListInputVO rfaListInputVO) throws EventException;
	
	/**
	 * 화주 계약서상의 S/C를 조회한다.(ESM_BKG_0655)
	 * 
	 * @author		KimByungKyu
	 * @param 		ScListInputVO scListInputVO
	 * @return 		List<ScListVO>
	 * @exception 	EventException
	 */
	public List<ScListVO> searchScList(ScListInputVO scListInputVO) throws EventException;		
	
	/**
	 * 화주 계약서상의 TAA를 조회한다.(ESM_BKG_1062)
	 * 
	 * @author		KimByungKyu
	 * @param 		TaaListInputVO taaListInputVO
	 * @return 		List<RfaListVO>
	 * @exception 	EventException
	 */
	public List<TaaListVO> searchTaaList(TaaListInputVO taaListInputVO) throws EventException;	
	
	/**
	 * RFA 계약 상의 Commodity를 조회한다.(ESM_BKG_0656)
	 * 
	 * @author		KimByungKyu
	 * @param 		RfaListInputVO rfaListInputVO
	 * @param 		String cmdtNm
	 * @param 		String cmdtCd
	 * @return 		List<RfaCmdtListVO>
	 * @exception 	EventException
	 */
	public List<RfaCmdtListVO> searchCmdtByRfa(RfaListInputVO rfaListInputVO, String cmdtNm, String cmdtCd) throws EventException;		

	/**
	 * S/C 계약 상의 Commodity를 조회한다.(ESM_BKG_0657)
	 * 
	 * @author		KimByungKyu
	 * @param 		ScListInputVO scListInputVO
	 * @param 		String cmdtNm
	 * @param 		String cmdtCd
	 * @param		String svcScpCd
	 * @return 		List<ScCmdtListVO>
	 * @exception 	EventException
	 */
	public List<ScCmdtListVO> searchCmdtBySc(ScListInputVO scListInputVO, String cmdtNm, String cmdtCd, String svcScpCd) throws EventException;

	/**
	 * TAA 계약 상의 Commodity를 조회한다.(ESM_BKG_1078)
	 * 
	 * @author		KimByungKyu
	 * @param 		TaaListInputVO taaListInputVO
	 * @param 		String cmdtNm
	 * @param 		String cmdtCd
	 * @return 		List<TaaCmdtListVO>
	 * @exception 	EventException
	 */
	public List<TaaCmdtListVO> searchCmdtByTaa(TaaListInputVO taaListInputVO, String cmdtNm, String cmdtCd) throws EventException;
	
	/**
	 * ESM_BKG_0566 : History를 조회한다<br>
	 *
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return HistMainVO
	 * @author Lee NamKyung
	 * @exception EventException
	 */
	public HistMainVO searchBlHist(BkgBlNoVO bkgBlNoVO) throws EventException;
		
	/**
	 * ESM_BKG_0566_02 : FAX/EDI History를 조회한다<br>
	 *
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<NoticeHistVO>
	 * @author Lee NamKyung
	 * @exception EventException
	 */
	public List<NoticeHistVO> searchNoticeHist(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * ESM_BKG_0566_03 : Customs History를 조회한다<br>
	 *
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<CustomsHistVO>
	 * @author Lee NamKyung
	 * @exception EventException
	 */
	public List<CustomsHistVO> searchCustomsHist(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * ESM_BKG_0566_04 : Documnents History를 조회한다<br>
	 *
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<DocHistVO>
	 * @author Lee NamKyung
	 * @exception EventException
	 */
	public List<DocHistVO> searchDocHist(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * 해당 booking의 roll over 정보를 조회<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return RollOvrInfoVO
	 * @exception EventException
	 */
	public RollOvrInfoVO searchRollOvr(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * Booking 리스트에서 5005RD를 FAX로 발송한다.(ESM_BKG_0098)
	 * @author	Jun Yong Jin
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByFax(BkgReceiptSendVO bkgReceiptSendVO, SignOnUserAccount account) throws EventException;

	/**
	 * Booking 리스트에서 5005RD를 Mail로 발송한다.(ESM_BKG_0098)
	 * @author	Jun Yong Jin
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param String fileKeys
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByEmail(BkgReceiptSendVO bkgReceiptSendVO, String fileKeys,SignOnUserAccount account) throws EventException;

	/**
	 * Booking 리스트에서 5005RD를 Group Mail로 발송한다.(ESM_BKG_0098)
	 * @author	Jun Yong Jin
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param String fileKeys
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByGroupEmail(BkgReceiptSendVO bkgReceiptSendVO, String fileKeys, SignOnUserAccount account) throws EventException;

	/**
	 * mty bkg update화면에서 bkg data와 cntr data, VL container List 를 조회한다.
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String bkgMvmtCd
	 * @return 		RepoBkgForUpdateVO
	 * @exception 	EventException
	 */
	public RepoBkgForUpdateVO searchEmptyBooking(BkgBlNoVO bkgBlNoVO, String bkgMvmtCd) throws EventException;	
	
	/**
	 * Container Digit,TpSz,Stauts Cd를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		String cntrNo
	 * @return 		CntrChkDigitVO
	 * @exception 	EventException
	 */
	public CntrChkDigitVO searchCntrChkDigit(String cntrNo) throws EventException;

	/**
	 *  Terminal에 보낼 EDI정보를 생성 및 전송 BackEndJob 처리
	 * 
	 * @author Kim Byung Kyu
	 * @param Vender301ParamVO vender301ParamVO
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String createTmlBkgReceiptEdiBackEnd(Vender301ParamVO vender301ParamVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Terminal에 보낼 EDI정보를 생성 및 전송한다.(ESM_BKG_0702)
	 * @author	Jun Yong Jin
	 * @param Vender301ParamVO vender301ParamVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> createTmlBkgReceiptEdi(Vender301ParamVO vender301ParamVO, SignOnUserAccount account) throws EventException;

	/**
	 * CreateCustBkgReceiptEdi BackEndJob 처리
	 * 
	 * @author Kim Byung Kyu
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param CustTpIdVO custTpIdVO
	 * @param String autoManualFlg
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String createCustBkgReceiptEdiBackEnd(BkgBlNoVO bkgBlNoVO, CustTpIdVO custTpIdVO, String autoManualFlg, SignOnUserAccount account) throws EventException;
	
	/**
	 * Customer에게 보낼 EDI정보를 생성 및 전송한다.(ESM_BKG_0702)
	 * @author	Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param CustTpIdVO custTpIdVO
	 * @param String autoManualFlg
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> createCustBkgReceiptEdi(BkgBlNoVO bkgBlNoVO, CustTpIdVO custTpIdVO, String autoManualFlg, SignOnUserAccount account) throws EventException;

	/**
	 * Stowage Plan 조회
	 * 
	 * @author		KimByungKyu
	 * @param 		String mvmtOption
	 * @param 		String vvd 
	 * @param 		String ydCd
	 * @return 		List<RepoCntrVO>
	 * @exception 	EventException
	 */
	public List<RepoCntrVO> searchMtyCntrList(String mvmtOption, String vvd, String ydCd) throws EventException;	
	/**
	 * Empty Booking의 T/S Route정보를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @return 		List<MtyBkgTsRouteVO>
	 * @exception 	EventException
	 */
	public List<MtyBkgTsRouteVO> searchEmptyBkgTsRoute(BkgBlNoVO bkgBlNoVO) throws EventException;	

	/**
	 * Yard에 Empty Status로 존재하는 Container List를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		String vvd
	 * @param  		String ydCd
	 * @param  		String cntrTpsz
	 * @return 		List<RepoCntrVO>
	 * @exception 	EventException
	 */
	public List<RepoCntrVO> searchCntrByYard(String vvd, String ydCd, String cntrTpsz) throws EventException;	

	/**
	 * Fax/Email 발송 리스트를 조회한다.(ESM_BKG_0095)<br>
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return List<SendBkgFaxEmailVO>
	 * @exception 	EventException
	 */
	public List<SendBkgFaxEmailVO> searchFaxEmailForNotice(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
	 * EDI 발송 리스트를 조회한다.(ESM_BKG_0095)<br>
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<SendBkgEdiVO>
	 * @exception 	EventException
	 */
	public List<SendBkgEdiVO> searchEdiForNotice(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Bkg Receipt Type을 조회한다.(ESM_BKG_0095)<br>
	 *
	 * @author Jun Yong Jin
	 * @param String usrId
	 * @return String
	 * @exception 	EventException
	 */
	public String searchBkgReceiptType(String usrId) throws EventException;
	
	/**
	 * edi 전송시 type/size별 yard 구분을 위해 기초 정보를 조회<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param QtyInfoVO qtyInfoVO
	 * @return YardAssignVO
	 * @exception EventException
	 */
	public YardAssignVO searchYardAssign( BkgBlNoVO bkgBlNoVO , QtyInfoVO qtyInfoVO ) throws EventException;
 
	/**
	 * 입력한 yard가 mdm_yard에 있는지 확인한다.<br>
	 * 
	 * @param QtyInfoVO[] qtyInfoVOs
	 * @exception EventException
	 */
	public void validateYardAssign(QtyInfoVO[] qtyInfoVOs ) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Route Detail 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param bkgNo	 
	 * @return
	 * @exception EventException
	 */
	public RouteDtlVO searchRouteDetail(String bkgNo) throws EventException;
	
	/**
	 * surrender notice, carrier haulage notice를 전송한다.<br>	 
	 * @param String mrdNm	 
	 * @param String ntcKndCd
	 * @param String faxNo	 
	 * @param String param
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgNoticeByFax(String mrdNm, String ntcKndCd, String faxNo, String param, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
	 * surrender notice, carrier haulage notice를 전송한다.<br>	 
	 * @param String mrdNm	 
	 * @param String ntcKndCd
	 * @param String eml	 
	 * @param String param
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgNoticeByEmail(String mrdNm, String ntcKndCd, String eml, String param, BkgBlNoVO bkgBlNoVO, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * simple si notice를 전송한다.<br>	 
	 * @param String mrdNm	 
	 * @param String ntcKndCd
	 * @param String eml	 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgSimpleSiByEmail(String mrdNm, String ntcKndCd, String eml, BkgBlNoVO bkgBlNoVO, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * searchSimpleSiBkgInfoList 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchSimpleSiBkgInfoList(String bkgNo) throws EventException;
	
	/**
	 * searchSimpleSiCntrInfoList 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchSimpleSiCntrInfoList(String bkgNo) throws EventException;
	
	/**
	 * searchSimpleSiHblCntrInfoList 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchSimpleSiHblCntrInfoList(String bkgNo) throws EventException;
	
	/**
	 * Booking Creation tab중 어떤 Tab을 보여줘야 하는지 조회한다.<br>
	 *
	 * @author    Lee NamKyung
	 * @param     SignOnUserAccount account
	 * @return    String 
	 * @exception EventException
	 */
	public String searchBkgCreTabByUser(SignOnUserAccount account) throws EventException;

	/**
	 * booking creation  화면에서 customer code 변경시 이름과 추가 정보를 조회한다.<br>
	 *
	 * @author		KimByungKyu
	 * @param 		String custCntCd
	 * @param 		String custSeq
	 * @return 		BkgCreCustomerVO
	 * @exception 	EventException
	 */
	public BkgCreCustomerVO searchCustNm(	String custCntCd, String custSeq) throws EventException;

	/**
	 * special cargo 재 request를 위한 bkg data를 조회한다<br>
	 *
	 * @author		Ryu Daeyoung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String rqstType 
	 * @param		SignOnUserAccount account
	 * @return 		ScgAproRqstVO[]
	 * @exception 	EventException
	 */
	public ScgAproRqstVO[] searchBkgForSpclRqst(BkgBlNoVO bkgBlNoVO, String rqstType, SignOnUserAccount account) throws EventException;

	/**
	 * special cargo 재 request를 위한 spcl cgo seq들을 조회한다<br>
	 *
	 * @author		Ryu Daeyoung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		SpclReqInVO[]
	 * @exception 	EventException
	 */
	public SpclReqInVO[] searchSpclReqInVO(BkgBlNoVO bkgBlNoVO) throws EventException;


	/**
	 * eBooking Doc Type이 'B' 인 경우에 Upload 되면 자동으로 전송한다.
	 * @author	Jun Yong Jin
	 * @param BkgBlNoVO[] bkgBlNoVO
	 * @param String[] emlAddr
	 * @param String[] remark
	 * @param String mrdNm
	 * @param String[] cct
	 * @param SignOnUserAccount account 
	 * @param String title
	 * @param String Contents
	 * @param String vslNm
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendXterReceiptByEmail(BkgBlNoVO[] bkgBlNoVO, String[] emlAddr, String[] remark,String mrdNm, String[] cct, SignOnUserAccount account, String title, String Contents, String vslNm) throws EventException;

	/**
	 * bkgNo로 Sale Rep의 계정의 IAM 메일 주소를 조회한다.(ESM_BKG_0079)<br>
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchSlsRepUsrEmlByBkgNo(String bkgNo) throws EventException;

	/**
	 * ESM_BKG_0079_01 : searchBkgChgOfc <br>
	 * searchBkgChgOfc 정보를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<BkgChgOfcVO>
	 * @exception EventException
	 */
	public List<BkgChgOfcVO> searchBkgChgOfc(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * @param bkgBlNoVO
	 * @return String
	 * @throws EventException
	 */
	public String checkIbByCaIssue(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * @param OfcRepInputVO ofcRepInputVO
	 * @return List<OfcRepListVO>
	 * @throws EventException
	 */
	public List<OfcRepListVO> searchCtrtRep(OfcRepInputVO ofcRepInputVO) throws EventException;

	/**
	 * ESM_BKG_0079_01 : searchXterBkg<br>
	 * 두개의 다른 BKG에 대해 동일 BKG No 채번 방지용 check<br>
	 * 
	 * @param String bkgNo
	 * @exception EventException
	 */
	
	public void searchXterBkg(String bkgNo) throws EventException;
	
	/**
	 * ESM_BKG_0003 : retrieve <br>
	 * Customer Advisory 정보를 조회한다.<br>
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @return List<BkgCustAvcNtcSndVO>
	 * @throws EventException
	 */
	public List<BkgCustAvcNtcSndVO> searchCustAdvisoryNoticeSendList(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws EventException;
	
	/**
	 * ESM_BKG_0003 : retrieve <br>
	 * Customer Advisory Cntr Count를 조회한다.<br>
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @return String
	 * @throws EventException
	 */
	public String searchCustAdvisoryNoticeCntrCnt(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws EventException;
	
	/**
	 * ESM_BKG_0003: upload<br> 
	 * Emergemcy Case 가 발생 한 대상 Container를 기준으로 B/L정보를 저장한다. <br>
	 * 
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @param BkgCustAvcNtcUploadVO[] bkgCustAvcNtcUploadVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createCustAdvisoryNoticeListByUpload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, BkgCustAvcNtcUploadVO[] bkgCustAvcNtcUploadVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BKG_0003: save <br>
	 * Customer Advisory 정보를 변경한다.<br>
	 * 
	 * @param BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCustAdvisoryNoticeList(BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_BKG_0003: fax<br>
	 * 해당 Customer에게  Advisory Notice 에 대한 Fax를 발송한다.
	 *  
	 * @param BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs
	 * @param SignOnUserAccount account
	 * @return int 
	 * @throws EventException
	 */
	public int sendCustAdvisoryNoticeListByFax(BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_BKG_0003: email<br>
	 * 해당 Customer에게  Advisory Notice 에 대한 EMail을 발송한다.
	 *  
	 * @param BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs
	 * @param String urlPath
	 * @param SignOnUserAccount account
	 * @return int 
	 * @throws EventException
	 */
	public int sendCustAdvisoryNoticeListByMail(BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs, String urlPath, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_BKG_0004: init<br>
	 * Customer Advisory Notice Remark 정보를 조회한다.<br>
	 *  
	 * @param BkgCustAvcNtcRmkVO inputVO
	 * @return List<BkgCustAvcNtcRmkVO>
	 * @throws EventException
	 */
	public List<BkgCustAvcNtcRmkVO> searchCustAdvisoryNoticeRemark(BkgCustAvcNtcRmkVO inputVO) throws EventException;
	
	/**
	 * ESM_BKG_0004: save<br>
	 * Customer Advisory Notice Remark 정보를 수정한다.
	 *  
	 * @param BkgCustAvcNtcRmkVO bkgCustAvcNtcRmkVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCustAdvisoryNoticeRemark(BkgCustAvcNtcRmkVO bkgCustAvcNtcRmkVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_BKG_0005 : retrieve <br>
	 * Customer Advisory History 정보를 조회한다.<br>
	 *  
	 * @param BkgCustAvcNtcSndHisSchVO bkgCustAvcNtcSndHisSchVO
	 * @return List<BkgCustAvcNtcSndHisVO>
	 * @throws EventException
	 */
	public List<BkgCustAvcNtcSndHisVO> searchCustAdvisoryNoticeSendHistory(BkgCustAvcNtcSndHisSchVO bkgCustAvcNtcSndHisSchVO) throws EventException;
	
	/**
	 * ESM_BKG_1139 : search<br>
	 * TRO Fax/Email 발송 History를 조회한다.
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String ioBndCd
	 * @return List<SendBkgFaxEmailVO>
	 * @throws EventException
	 */
	public List<SendBkgFaxEmailVO> searchEurTroNotice(BkgBlNoVO bkgBlNoVO, String ioBndCd) throws EventException;

	/**
	 * @param List<BkgUserSmsListVO> smsList
	 * @param String bkgNo
	 * @param String sndMsg
	 * @param String sndParam
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendMailSmsByPodChange(
			List<BkgUserSmsListVO> smsList, String bkgNo, String sndMsg, String sndParam, SignOnUserAccount account) throws EventException;
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @param BkgCustAvcNtcUploadVO[] bkgCustAvcNtcUploadVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, BkgCustAvcNtcUploadVO[] bkgCustAvcNtcUploadVOs, String pgmNo) throws EventException;

	/**
	 * ESM_BKG_0003: BST Download<br>
	 * Booking Data를 대상으로 정보를 조회한다. 
	 *  
	 * @param bkgCustAvcNtcSchVO
	 * @return
	 * @throws EventException
	 */
	public int searchCustAdvisoryNoticeCntByBSTUpload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws EventException;
	
	/**
	 * ESM_BKG_0003 : BST Download <br>
	 * Booking Data를 대상으로 정보를 저장한다. <br>
	 * 
	 * @param bkgCustAvcNtcSchVO
	 * @param account
	 * @throws EventException
	 */
	public void manageCustAdvisoryNoticeListByBSTDownload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Revised Rate notice를 전송한다.<br>	
	 * @param String mrdNm 	 
	 * @param String ntcKndCd
	 * @param String eml	 
	 * @param String param
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgRevisedRateByEmail(String mrdNm, String ntcKndCd, String eml, String param, BkgBlNoVO bkgBlNoVO, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Customer List 조회<br>
	 * @param SearchCustomerInqryCondVO searchCustomerInqryCondVO
	 * @param int iPage
	 * @param String custCd
	 * @param String cust
	 * @return List<SearchCustomerInqryVO>
	 * @throws EventException
	 */
	public List<SearchCustomerInqryVO> searchCustomerList(SearchCustomerInqryCondVO searchCustomerInqryCondVO, int iPage, String custCd, String cust) throws EventException;


	/**
	 * Booking Vessel Revised Notice 전송<br>
	 * @param List<BkgBlNoVO> bkgBlNoVOs
	 * @param String vslCngRsn
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgVslReviseNotice(List<BkgBlNoVO> bkgBlNoVOs, String vslCngRsn, SignOnUserAccount account) throws EventException;
	
	/**
	 * BkgCustAvcFileListVO
	 * @param bkgCustAvcNtcRmkVO
	 * @return
	 * @throws EventException
	 */
	public List<BkgCustAvcFileListVO> searchCustAdvisoryFileList(BkgCustAvcNtcRmkVO bkgCustAvcNtcRmkVO) throws EventException;
	
	/**
	 * ALOC_STS_CD 를 조회한다.<br>
	 * @param String bkgNo
	 * @return AlocStandbyReasonVO
	 * @throws EventException
	 */
	public AlocStandbyReasonVO searchAlocStsCdByBkgNo(String bkgNo) throws EventException;
	
	/**
	 * Allocation Stand by Reason 의 Truck VVD BKG Status vs. Allocation 을 조회한다.<br>
	 * @param String bkgNo
	 * @return List<AlocStandbyReasonVO>
	 * @throws EventException
	 */
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonTruck(String bkgNo) throws EventException;
	
	/**
	 * Allocation Stand by Reason 의 T/S VVD BKG Status vs. Allocation 을 조회한다.<br>
	 * @param String bkgNo
	 * @return List<AlocStandbyReasonVO>
	 * @throws EventException
	 */
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonTs(String bkgNo) throws EventException;
	
	/**
	 * Allocation Stand by Reason 의 EQ & Commodity Restriction 을 조회한다.<br>
	 * @param String bkgNo
	 * @return List<AlocStandbyReasonVO>
	 * @throws EventException
	 */
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonEq(String bkgNo) throws EventException;
	
	/**
	 * Allocation Stand by Reason 의 Customer Constraint 를 조회한다.<br>
	 * @param String bkgNo
	 * @return List<AlocStandbyReasonVO>
	 * @throws EventException
	 */
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonCust(String bkgNo) throws EventException;	
	
	/**
	 * SLS_REP_CD 로 AS 인 PRNT_OFC_CD 정보를 조회한다.(ESM_BKG_0079_01)
	 * 
	 * @author 
	 * @param String srep_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchPrntOfcCdBySRepCd(String srep_cd) throws EventException;
	
	/**
	 * MDM_SLS_REP 의 SREP_EML 을 조회 한다.<br>
	 *
	 * @author 
	 * @param  String srepCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSrepEml(String srepCd) throws EventException ;

	
	/**
	 * e-Booking Upload Notice 메일 수신인을 조회한다.<br>
	 * WEB을 통해 자동생성된 BKG 중 Auto Notification에 체크되어있고  
	 * Standby:F, NoRate:F인 Booking에 대해 Upload(Receipt) Notice를 전송해준다.
	 * @author 
	 * @param  String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchEBkgUploadNoticeEml(String bkgNo) throws EventException;
	
	 /**
	 * ScListInput 파라미터 조회<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return ScListInputVO
	 * @throws EventException
	 */
	public ScListInputVO searchScListInput(BkgBlNoVO bkgBlNoVO) throws EventException;	
	
	/**
	 *  S/C를 유효성을 조회한다.
	 * 
	 * @author		
	 * @param 		ScListInputVO scListInputVO
	 * @return 		String
	 * @exception 	EventException
	 */
	public String searchScAvailableCust(ScListInputVO scListInputVO) throws EventException;
		
	/**
	 * Customer에게 NoRateNotice 를 보내면 안되는 조건인지 조회한다.
	 * 
	 * @author		
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	EventException
	 */
	public String searchNoRateNoticeToCustomerBlock(BkgBlNoVO bkgBlNoVO) throws EventException ;
	
	/**
	 * Booking Creation Status 돋보기 누르면 나오는 화면에 대한 조회(Estimated CMPB)
	 * 
	 * @author 
	 * @param String bkgNo
	 * @return List<EstimatedCMPBVO>
	 * @exception EventException
	 */
	public List<EstimatedCMPBVO> searchEstimatedCMPB(String bkgNo) throws EventException;
	
	/**
	 * ESM_BKG_0566 : History를 조회한다<br>
	 *
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @param   SIWebServiceVO sIWebServiceVO
	 * @return HistMainVO
	 * @author Lee NamKyung
	 * @exception EventException
	 */
	public HistMainVO searchBlHist(BkgBlNoVO bkgBlNoVO, SIWebServiceVO sIWebServiceVO) throws EventException;
	
	/**
	 * S/I 이후, Awkward Container Weight와 Container Weight의 차이가 20%이상 나는지 여부를 체크
	 * @param bkgNo String
	 * @return String
	 * @throws EventException
	 */
	public String checkAkwardOverWgtFlg(String bkgNo) throws EventException;
}
