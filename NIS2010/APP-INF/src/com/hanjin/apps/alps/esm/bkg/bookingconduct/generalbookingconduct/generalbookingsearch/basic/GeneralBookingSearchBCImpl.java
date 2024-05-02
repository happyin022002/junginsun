/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchBCImpl.java
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
* 2011.01.11 이일민 [] 1월 6일자 R4J 관련 수정
* 2011.03.21 이일민 [CHM-201109384-01] Mis-Sales C/A 발생시 Sales Rep에 자동 경고 메세지 송부
* 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
* 2011.09.16 전성진 [SRM-201119861] 301 terminal EDI Flat File 잘림 현상 수정
* 2011.10.14 정선용 [CHM-201113680-01] 남미 5개 국가(브라질, 에콰도르, 도미니카 공화국, 콜롬비아, 우루과이)  BDR이후 C/A issue 직전
* 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
* 2011.12.02 정선용 [CLT-111121273-01]	R4J 패치 이후 발생한 결함 건 수정(Null dereference)
* 2011.11.05 금병주 [CHM-201114706-01] [BKG_1139 :U/I제출] EUR TRO Notice 전송 Pop-up
* 2012.03.29 전성진 [CHM-201217014] 악성 화주 선택시 Warning Message 변경 요청
* 2012.04.02 변종건 [CHM-201216424-01] ALPS Customer Advisory 기능 보완 검토 요청 (Template 문서 첨부 등)
* 2012.08.03 이재위 [CHM-201218218] Simple S/I Download 기능 강화를 위한 CUP, ALPS 변경 요청
* 2012.09.17 김보배 [CHM-201220181] [BKG] ALPS Bkg/Doc Customer Advisory Send 기능 보완 요청 (30초룰 해제)
* 2014.01.14 문동선 [CHM-201328181] [BKG] Space allocation 연계 Waiting booking process 개발 Project
* 2014.08.29 문동선 [CHM-201431517] Pre-Caution 반영 Alert 메세지 생성 로직 삽입 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.axis.utils.StringUtils;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration.GeneralBookingSearchDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration.GeneralBookingSearchEAIDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.AlocStandbyReasonVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgChgOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCreCustInqCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcFaxSndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcMailSndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcRmkVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSchVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndHisSchVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcUploadVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgInforForHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgReceiptSendVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BlHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ClzTmListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrChkDigitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrInfoForEmptyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CustomsHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.DocHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.EdiFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.EstimatedCMPBVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HblCountVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistMainVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistUiNmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.MtyBkgTsRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NoticeHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.OfcRepInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.OfcRepListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.PrdConstraintVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.PropNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.QtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RcvrBkgReviseNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgVO;
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
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Tmnl301BlVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Tmnl301DgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Tmnl301TroMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TmnlRcvIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.UsaCstmsFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.YardAssignVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustInqVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CustSrepVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.fileupload.basic.FileUploadBC;
import com.hanjin.syscommon.common.fileupload.basic.FileUploadBCImpl;
import com.hanjin.syscommon.common.table.BkgCustCntcPsonVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.common.table.ScgAproRqstVO;

/**
 * ALPS-GeneralBookingConduct Business Logic Basic Command implementation<br>
 * - ALPS-GeneralBookingConduct에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0650EventResponse,GeneralBookingSearchBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class GeneralBookingSearchBCImpl extends BasicCommandSupport implements GeneralBookingSearchBC {

	// Database Access Object
	private transient GeneralBookingSearchDBDAO dbDao = null;
	private transient GeneralBookingSearchEAIDAO eaiDao = null;

	/**
	 * GeneralBookingSearchBCImpl 객체 생성<br>
	 * GeneralBookingSearchDBDAO를 생성한다.<br>
	 */
	public GeneralBookingSearchBCImpl() {
		dbDao = new GeneralBookingSearchDBDAO();
		eaiDao = new GeneralBookingSearchEAIDAO();
	}

	/**
	 * TS Route 정보 조회
	 *
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String codRqstSeq
	 * @param 		String opCd
	 * @return 		List<TSRouteVO>
	 * @exception 	EventException
	 */
	public List<TSRouteVO> searchIbTsRoute(BkgBlNoVO bkgBlNoVO, String codRqstSeq, String opCd) throws EventException {
		try {
			if(codRqstSeq != null && codRqstSeq.length() > 0){
				return dbDao.searchCodTsRoute(bkgBlNoVO, codRqstSeq, opCd);
			}else{
				return dbDao.searchIbTsRoute(bkgBlNoVO);
			}			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);         
		}
	}

//	/**
//	 * Customer Inquiry 화면의 Retrieve 이벤트 처리<br>
//	 *
//	 * @author		KimByungKyu
//	 * @param 		String custCntCd
//	 * @param 		String custSeq
//	 * @param 		String custNm
//	 * @param 		String ofcCd
//	 * @return 		BkgCreCustInqVO
//	 * @exception 	EventException
//	 */
//	public BkgCreCustInqVO searchBkgCreCustCntc(	String custCntCd,
//			 																String custSeq,
//			 																String custNm,
//			 																String ofcCd	) throws EventException {
//		try {
//			BkgCreCustInqVO bkgCreCustInqVO = new BkgCreCustInqVO();
//
////			String custCntCd1 = "";
////			String custSeq1 = "";
//			// Customer 목록 조회
//			List<BkgCreCustomerVO> searchBkgCreCustomer = dbDao.searchBkgCreCustomer(custCntCd,custSeq,custNm,ofcCd);
//			bkgCreCustInqVO.setBkgCreCustomerr(searchBkgCreCustomer);
//
////			if(searchBkgCreCustomer != null && searchBkgCreCustomer.size() > 0){
////				BkgCreCustomerVO bkgCreCustCntrVO = searchBkgCreCustomer.get(0);
////				if(bkgCreCustCntrVO != null){
////					custCntCd1 = bkgCreCustCntrVO.getCustCntCd();
////					custSeq1 = bkgCreCustCntrVO.getCustSeq();
////				}
////			}
//
//			// S.OFC 목록 조회
////			List<CustSrepVO> searchCustSrep = dbDao.searchCustSrep(custCntCd1,custSeq1);
////			bkgCreCustInqVO.setCustSrep(searchCustSrep);
////
////			// 화주 담당자 목록 조회
////			List<BkgCustCntcPsonVO> searchCustContact = dbDao.searchCustContact(custCntCd1,custSeq1);
////			bkgCreCustInqVO.setBkgCustCntcPson(searchCustContact);
//
//			return bkgCreCustInqVO;
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//		} catch (Exception de) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
//		}
//	}
	
	/**
	 * Customer Inquiry 화면의 Retrieve 이벤트 처리<br>
	 *
	 * @author		KimByungKyu
	 * @param 		BkgCreCustInqCondVO bkgCreCustInqCondVO
	 * @return 		BkgCreCustInqVO
	 * @exception 	EventException
	 */
	public BkgCreCustInqVO searchBkgCreCustCntc(BkgCreCustInqCondVO bkgCreCustInqCondVO	) throws EventException {
		try {
		
			BkgCreCustInqVO bkgCreCustInqVO = new BkgCreCustInqVO();

//			String custCntCd1 = "";
//			String custSeq1 = "";
			// Customer 목록 조회
			List<BkgCreCustomerVO> searchBkgCreCustomer = dbDao.searchBkgCreCustomer(bkgCreCustInqCondVO);
			bkgCreCustInqVO.setBkgCreCustomerr(searchBkgCreCustomer);


			return bkgCreCustInqVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	
	/**
	 * Customer Inquiry 화면의 Customer 목록 클릭시 이벤트 처리<br>
	 *
	 * @author		KimByungKyu
	 * @param 		String custCntCd
	 * @param 		String custSeq
	 * @return 		BkgCreCustInqVO
	 * @exception 	EventException
	 */
	public BkgCreCustInqVO searchCustContact(String custCntCd, String custSeq	) throws EventException {
		try {
			BkgCreCustInqVO bkgCreCustInqVO = new BkgCreCustInqVO();

			// S.OFC 목록 조회
			List<CustSrepVO> searchCustSrep = dbDao.searchCustSrep(custCntCd,custSeq);
			bkgCreCustInqVO.setCustSrep(searchCustSrep);
			// 화주 담당자 목록 조회
			List<BkgCustCntcPsonVO> searchCustContact = dbDao.searchCustContact(custCntCd,custSeq);
			bkgCreCustInqVO.setBkgCustCntcPson(searchCustContact);

			return bkgCreCustInqVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 *  Service Mode & Route 정보를 조회한다.<br>
	 *
	 * @author		KimByungKyu
	 * @param 		bkgBlNoVO   BkgBlNoVO
	 * @return 		SvcRouteModeVO
	 * @exception 	EventException
	 */
	public SvcRouteModeVO searchSvcRouteMode(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchSvcRouteMode(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Constraint 조회<br>
	 *
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<PrdConstraintVO>
	 * @exception 	EventException
	 */
	public List<PrdConstraintVO> searchConstraint(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchConstraint(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Reference Number 정보를 조회한다<br>
	 *
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<RefNoVO>
	 * @exception 	EventException
	 */
	public List<RefNoVO> searchBkgReference(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchBkgReference(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Node Search 조회<br>
	 *
	 * @author		KimByungKyu
	 * @param 		NodeListInputVO nodeListInputVO
	 * @return 		List<NodeListVO>
	 * @exception 	EventException
	 */
	public List<NodeListVO> searchNodeCode(NodeListInputVO nodeListInputVO) throws EventException {
		try {
			if("Y".equals(nodeListInputVO.getYzFlag())){
				return dbDao.searchYardCode(nodeListInputVO);
			}else{
				return dbDao.searchZoneCode(nodeListInputVO);
			}
	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Location List 조회<br>
	 *
	 * @author		KimByungKyu
	 * @param 		LocationListInputVO locationListInputVO
	 * @return 		List<LocationListVO>
	 * @exception 	EventException
	 */
	public List<LocationListVO> searchLocationList(LocationListInputVO locationListInputVO) throws EventException {
		try {
			return dbDao.searchLocationList(locationListInputVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * Direct NVO-AMS File No를 조회한다<br>
	 *
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		UsaCstmsFileListVO
	 * @exception 	EventException
	 */
	public UsaCstmsFileListVO searchNVOFileNumberList(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			UsaCstmsFileListVO usaCstmsFileListVO = new UsaCstmsFileListVO();
			List<BkgUsaCstmsFileNoVO> nvoFileNumberList = dbDao.searchNVOFileNumberList(bkgBlNoVO);
			List<HblCountVO> hblCount = dbDao.searchHblCount(bkgBlNoVO);
			usaCstmsFileListVO.setBkgUsaCstmsFileNo(nvoFileNumberList);
			if(hblCount != null && hblCount.size() > 0){
				usaCstmsFileListVO.setHblCountVO(hblCount.get(0));
			}

			return usaCstmsFileListVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}



	/**
	 * 해당 booking의 cct 정보를 조회<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return ClzTmListVO
	 * @throws EventException
	 */
	public ClzTmListVO searchCargoClosingTime(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException{
		try {
			ClzTmListVO  clzTmListVO =new ClzTmListVO();

			 clzTmListVO.setClzTmVO(dbDao.searchCargoClosingTime(bkgBlNoVO,account));
			 clzTmListVO.setBkgForCargoClosingVO(dbDao.searchBkgForCargoClosing(bkgBlNoVO));
			 return clzTmListVO;
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * Customer Code 조회
	 * @param SearchActualCustomerVO searchActualCustomerVO
	 * @return List<SearchActualCustomerVO>
	 * @exception EventException
	 */
	public List<SearchActualCustomerVO> searchActualCustomer(SearchActualCustomerVO searchActualCustomerVO) throws EventException {
		try {
			return dbDao.searchActualCustomer(searchActualCustomerVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Empty Repo Bkg에 속해 있는 Container No List를 조회한다.(ESM_BKG_9450)
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<CntrInfoForEmptyVO>
	 * @exception EventException
	 */
	public List<CntrInfoForEmptyVO> searchEmptyCntrByBKG(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchEmptyCntrByBKG(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
	 * 모든 Service Scope의 Code와 Name을 조회한다.(ESM_BKG_0654)
	 * 
	 * @author		KimByungKyu
	 * @return 		List<MdmSvcScpVO>
	 * @exception 	EventException
	 */
	public List<MdmSvcScpVO> searchSvcScp() throws EventException {
		try {
			return dbDao.searchSvcScp();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
	 * 화주 계약서상의 RFA를 조회한다.(ESM_BKG_0654)
	 * 
	 * @author		KimByungKyu
	 * @param 		RfaListInputVO rfaListInputVO
	 * @return 		List<RfaListVO>
	 * @exception 	EventException
	 */
	public List<RfaListVO> searchRfaList(RfaListInputVO rfaListInputVO) throws EventException {
		try {
			return dbDao.searchRfaList(rfaListInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
	 * 화주 계약서상의 S/C를 조회한다.(ESM_BKG_0655)
	 * 
	 * @author		KimByungKyu
	 * @param 		ScListInputVO scListInputVO
	 * @return 		List<ScListVO>
	 * @exception 	EventException
	 */
	public List<ScListVO> searchScList(ScListInputVO scListInputVO) throws EventException {
		try {
			return dbDao.searchScList(scListInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}		


	/**
	 * 화주 계약서상의 TAA를 조회한다.(ESM_BKG_1062)
	 * 
	 * @author		KimByungKyu
	 * @param 		TaaListInputVO taaListInputVO
	 * @return 		List<TaaListVO>
	 * @exception 	EventException
	 */
	public List<TaaListVO> searchTaaList(TaaListInputVO taaListInputVO) throws EventException {
		try {
			return dbDao.searchTaaList(taaListInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
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
	public List<RfaCmdtListVO> searchCmdtByRfa(RfaListInputVO rfaListInputVO, String cmdtNm, String cmdtCd) throws EventException {
		try {
			PropNoVO propNoVO = dbDao.searchPropNoByRfa(rfaListInputVO);
			return dbDao.searchCmdtByRfa(propNoVO, cmdtNm, cmdtCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

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
	public List<ScCmdtListVO> searchCmdtBySc(ScListInputVO scListInputVO, String cmdtNm, String cmdtCd,String svcScpCd) throws EventException {
		try {
			PropNoVO propNoVO = dbDao.searchPropNoBySc(scListInputVO);
			return dbDao.searchCmdtBySc(propNoVO, cmdtNm, cmdtCd, svcScpCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}			
	
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
	public List<TaaCmdtListVO> searchCmdtByTaa(TaaListInputVO taaListInputVO, String cmdtNm, String cmdtCd) throws EventException {
		try {
			PropNoVO propNoVO = dbDao.searchPropNoByTaa(taaListInputVO);
			return dbDao.searchCmdtByTaa(propNoVO, cmdtNm, cmdtCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * ESM_BKG_0566 : History를 조회한다<br>
	 *
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return HistMainVO
	 * @author Lee NamKyung
	 * @exception EventException
	 */
	public HistMainVO searchBlHist(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {			
			HistMainVO histMainVO = new HistMainVO();
			
			//01. Booking Header
			BkgInforForHistVO bkgInfoForHistVO = dbDao.searchBkgInfoForHist(bkgBlNoVO);
			
			//02. Item Combo
			List<HistUiNmVO> histUiNmVOs = dbDao.searchHistUiNm(bkgBlNoVO);
			
			//03. B/L Data
			List<BlHistVO> blHistVOs = dbDao.searchBlHist(bkgBlNoVO);
			
			histMainVO.setBkgInforForHistVO(bkgInfoForHistVO);
			histMainVO.setHistUiNmVOs(histUiNmVOs);
			histMainVO.setBlHistVOs(blHistVOs);
			
			return histMainVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
		
	/**
	 * ESM_BKG_0566_02 : FAX/EDI History를 조회한다<br>
	 *
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<NoticeHistVO>
	 * @author Lee NamKyung
	 * @exception EventException
	 */
	public List<NoticeHistVO> searchNoticeHist(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchNoticeHist(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * ESM_BKG_0566_03 : Customs History를 조회한다<br>
	 *
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<CustomsHistVO>
	 * @author Lee NamKyung
	 * @exception EventException
	 */
	public List<CustomsHistVO> searchCustomsHist(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchCustomsHist(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * ESM_BKG_0566_04 : Documnents History를 조회한다<br>
	 *
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<DocHistVO>
	 * @author Lee NamKyung
	 * @exception EventException
	 */
	public List<DocHistVO> searchDocHist(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchDocHist(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	/**
	 * 해당 booking의 roll over 정보를 조회<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return RollOvrInfoVO
	 * @throws EventException
	 */
	public RollOvrInfoVO searchRollOvr(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			RollOvrInfoVO rollOvrInfoVO = new RollOvrInfoVO();
			rollOvrInfoVO.setBkgInforForHistVO(dbDao.searchBkgInfoForHist(bkgBlNoVO));
			rollOvrInfoVO.setRollOvrVO(dbDao.searchRollOvr(bkgBlNoVO));
			
			return rollOvrInfoVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		
	}

	/**
	 * Booking 리스트에서 5005RD를 FAX로 발송한다.(ESM_BKG_0098)
	 * @author	Jun Yong Jin
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByFax(BkgReceiptSendVO bkgReceiptSendVO, SignOnUserAccount account) throws EventException{
		try {
			return eaiDao.sendBkgReceiptByFax(bkgReceiptSendVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Booking 리스트에서 5005RD를 Mail로 발송한다.(ESM_BKG_0098)
	 * @author	Jun Yong Jin
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param String fileKeys
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByEmail(BkgReceiptSendVO bkgReceiptSendVO, String fileKeys, SignOnUserAccount account) throws EventException{
		try {
			bkgReceiptSendVO.setCcEmail((new BookingUtil()).searchCcEmailAddrRSQL("BK", account.getUsr_id()));
			return eaiDao.sendBkgReceiptByEmail(bkgReceiptSendVO, fileKeys, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Booking 리스트에서 5005RD를 Group Mail로 발송한다.(ESM_BKG_0098)
	 * @author	Jun Yong Jin
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param String fileKeys
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByGroupEmail(BkgReceiptSendVO bkgReceiptSendVO, String fileKeys, SignOnUserAccount account) throws EventException{
		try {
			bkgReceiptSendVO.setCcEmail((new BookingUtil()).searchCcEmailAddrRSQL("BK", account.getUsr_id()));
			return eaiDao.sendBkgReceiptByGroupEmail(bkgReceiptSendVO,fileKeys, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * mty bkg update화면에서 bkg data와 cntr data, VL container List 를 조회한다.
	 * 
	 * @author		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String bkgMvmtCd
	 * @return 		RepoBkgForUpdateVO
	 * @exception 	EventException
	 */
	public RepoBkgForUpdateVO searchEmptyBooking(BkgBlNoVO bkgBlNoVO, String bkgMvmtCd) throws EventException {
		RepoBkgForUpdateVO repoBkgForUpdateVO = new RepoBkgForUpdateVO();
		try {
			RepoBkgVO repoBkgVO = dbDao.searchEmptyBooking(bkgBlNoVO);		
			repoBkgForUpdateVO.setRepoBkgVO(repoBkgVO);			
			if(repoBkgVO != null){
				// B/L 번호를 조회하는 경우도 있으니 새로 생성함.
				BkgBlNoVO newBkgBlNoVO = new BkgBlNoVO();
				newBkgBlNoVO.setBkgNo(repoBkgForUpdateVO.getRepoBkgVO().getBkgNo());
				
				List<RepoCntrVO> emptyCntrList = dbDao.searchEmptyCntr(newBkgBlNoVO);
				// Empty Container 정보가 없을시 Booking Qty를 조회한다.
				if(emptyCntrList == null || emptyCntrList.size() < 1){
					List<BkgQuantityVO> emptyQtyList = dbDao.searchEmptyQty(newBkgBlNoVO) ;
					repoBkgForUpdateVO.setBkgQuantity(emptyQtyList);
				}

				List<RepoCntrVO> cntrTpszList = dbDao.searchCntrTpszCd();
				
				List<RepoCntrVO> repoCntrTpszList = new ArrayList<RepoCntrVO>();
				for(int i=0;i<cntrTpszList.size();i++){
					if(!cntrTpszList.get(i).getTpszCd().equals("Q2")&&!cntrTpszList.get(i).getTpszCd().equals("Q4")){
						repoCntrTpszList.add(cntrTpszList.get(i));
					}						
				}
				
				repoBkgForUpdateVO.setRepoCntr(emptyCntrList);
				repoBkgForUpdateVO.setCntrTpSz(repoCntrTpszList);		
				
				if("VL".equals(bkgMvmtCd)){
					List<RepoCntrVO> vlCntrList = dbDao.searchVLCntr(repoBkgVO.getBkgTrunkVvd(), repoBkgVO.getOrgYdCd());
					
					repoBkgForUpdateVO.setVlCntr(vlCntrList);			
				}
			}else{
				throw new EventException((String)new ErrorHandler("BKG00095").getMessage());				
			}

		} catch (EventException ex) {
			throw ex;						
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return repoBkgForUpdateVO;
	}	


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
	public List<RepoCntrVO> searchMtyCntrList(String mvmtOption, String vvd, String ydCd) throws EventException {
		try {
			if("V".equals(mvmtOption)){
				return dbDao.searchVLCntr(vvd, ydCd);
			}else{
				return dbDao.searchStwgPlan(vvd, ydCd);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}		
	
	/**
	 * Container Digit,TpSz,Stauts Cd를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		String cntrNo
	 * @return 		CntrChkDigitVO
	 * @exception 	EventException
	 */
	public CntrChkDigitVO searchCntrChkDigit(String cntrNo) throws EventException{
		try {
			return dbDao.searchCntrChkDigit(cntrNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

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
	public String createCustBkgReceiptEdiBackEnd(BkgBlNoVO bkgBlNoVO, CustTpIdVO custTpIdVO, String autoManualFlg, SignOnUserAccount account) throws EventException {
		CreateCustBkgReceiptEdiBackEndJob createCustBkgReceiptEdi = new CreateCustBkgReceiptEdiBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			createCustBkgReceiptEdi.setBkgBlNoVO(bkgBlNoVO);
			createCustBkgReceiptEdi.setSignOnUserAccount(account);

			return backEndJobManager.execute(createCustBkgReceiptEdi, account.getUsr_id(), "createCustBkgReceiptEdiBackEnd");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	


	
	
	/**
	 * Customer에게 보낼 EDI정보를 생성 및 전송한다.(ESM_BKG_0702)
	 * @author	Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param CustTpIdVO custTpIdVO
	 * @param String autoManualFlg
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> createCustBkgReceiptEdi(BkgBlNoVO bkgBlNoVO, CustTpIdVO custTpIdVO, String autoManualFlg, SignOnUserAccount account) throws EventException{
		BookingUtil utilBC = new BookingUtil();
		List<CustTpIdVO> custTpIdVOList = new ArrayList<CustTpIdVO>();
		String hostId = null;
		XterRqstNoVO xterRqstNoVO = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();

		String ediHeader = null;
		String ediBlMain = null;
		String ediCntrInfo = null;
		//String ediCntrRfInfo = null;
		List<String> ediCntrRfInfos = null;
		//String ediCntrAwkInfo = null;
		List<String> ediCntrAwkInfos = null;
		//String ediCntrDgInfo = null;
		List<String> ediCntrDgInfos = null;
		String ediTroGen = null;
		String ediTroEur = null;
		String ediDgInfo = null;
		//String ediBlCntr = null;
		List<String> ediBlCntrs = null;
		List<String> ediBlVvds = null;
		String ediBlPoInfo = null;
		String ediBlDesc = null;
		String ediBkgCm = null;
		String ediXterInfo = null;
		//String ediXterCust = null;
		List<String> ediXterCusts = null;
		String ediXterCm = null;

		try {
			if("Y".equals(autoManualFlg)){
				//booking main 화면에 있는 edi block flag를 켜두면 자동 전송하지 않도록 한다.
				if("Y".equals(dbDao.searchAutoEdiBlockFlg(bkgBlNoVO))){
					return bkgNtcHisVOs;
				}
				if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
					return bkgNtcHisVOs;
				}
				if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
					return bkgNtcHisVOs;
				}
			}
			if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
				throw new EventException(new ErrorHandler("BKG08333",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
			}
			if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
				throw new EventException(new ErrorHandler("BKG08284",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
			}
			if ( custTpIdVO == null ) {
				custTpIdVOList = utilBC.searchEdiCustTpId(bkgBlNoVO, "B", autoManualFlg);
			} else {
				custTpIdVOList.add(custTpIdVO);
			}
			// portal에 대해서는 특정 history가 있는 경우 전송한다 
			if(custTpIdVOList.size()==0 && "Y".equals(autoManualFlg)){
				custTpIdVOList = dbDao.searchEdiPortalTpId(bkgBlNoVO);
			}
			if(custTpIdVOList.size()==0){
				return bkgNtcHisVOs;
			}
			// 전송할 flat_file 초기화 Customer(custTpIdVO)의 수 만큼 생성
			String[] flatFiles = new String[custTpIdVOList.size()];
			EdiFlatFileVO ediFlatFileVO = new EdiFlatFileVO();
			for (int i=0;i<custTpIdVOList.size();i++) {
				CustTpIdVO custTpVO = custTpIdVOList.get(i);

				hostId = utilBC.searchEdi301HostId(custTpVO.getRcvId(), "CUST");
				
				ediHeader = utilBC.searchEdiHeader(hostId, custTpVO.getRcvId(), "301   ");
				ediFlatFileVO  = dbDao.searchCust301BlMain(bkgBlNoVO, custTpVO.getGroupId(), custTpVO.getRefCode(), custTpVO.getRcvId());
				ediBlMain = JSPUtil.getNull(ediFlatFileVO.getFlatFile1()) + "\n" 
						+ JSPUtil.getNull(ediFlatFileVO.getFlatFile2()) + "\n"
						+ JSPUtil.getNull(ediFlatFileVO.getFlatFile3());

				flatFiles[i] = "";
				StringBuffer flatFiles1 = new StringBuffer("");
				flatFiles1.append(("".equals(ediHeader))?"":ediHeader).append("\n");
				flatFiles1.append(("".equals(ediBlMain))?"":ediBlMain).append("\n");
				flatFiles[i] = flatFiles1.toString();
//				flatFiles[i] = flatFiles[i] + (("".equals(ediHeader))?"":ediHeader)+"\n";
//				flatFiles[i] = flatFiles[i] + (("".equals(ediBlMain))?"":ediBlMain)+"\n";
			}

			StringBuffer comFlatFile = new StringBuffer();

			ediCntrInfo = JSPUtil.getNull(dbDao.searchEdi301CntrInfo(bkgBlNoVO));
			//ediCntrRfInfo = JSPUtil.getNull(dbDao.searchEdi301CntrRfInfo(bkgBlNoVO));
			ediCntrRfInfos = dbDao.searchEdi301CntrRfInfo(bkgBlNoVO);
			//ediCntrAwkInfo = JSPUtil.getNull(dbDao.searchEdi301CntrAwkInfo(bkgBlNoVO));
			ediCntrAwkInfos = dbDao.searchEdi301CntrAwkInfo(bkgBlNoVO);
			//ediCntrDgInfo = JSPUtil.getNull(dbDao.searchEdi301CntrDgInfo(bkgBlNoVO));	
			ediCntrDgInfos = dbDao.searchEdi301CntrDgInfo(bkgBlNoVO);
			
			ediTroGen = JSPUtil.getNull(dbDao.searchCust301TroGeneralInfo(bkgBlNoVO));
			ediTroEur = JSPUtil.getNull(dbDao.searchCust301TroEurInfo(bkgBlNoVO));
			ediDgInfo = JSPUtil.getNull(dbDao.searchEdi301DgInfo(bkgBlNoVO));
			//ediBlCntr = JSPUtil.getNull(dbDao.searchEdi301BlCntr(bkgBlNoVO));
			ediBlCntrs = dbDao.searchEdi301BlCntr(bkgBlNoVO);
			ediBlVvds = dbDao.searchEdi301BlVvd(bkgBlNoVO);
			ediBlPoInfo = JSPUtil.getNull(dbDao.searchEdi301BlPoInfo(bkgBlNoVO));
			ediBlDesc = JSPUtil.getNull(dbDao.searchCust301BlDesc(bkgBlNoVO));
			ediBkgCm = JSPUtil.getNull(dbDao.searchCust301BkgCm(bkgBlNoVO));

			comFlatFile.append(("".equals(ediCntrInfo))?"":ediCntrInfo+"\n");
			//comFlatFile.append(("".equals(ediCntrRfInfo))?"":ediCntrRfInfo+"\n");
			if(ediCntrRfInfos != null)
			{
				int ediCntrRfInfosMaxSize = ediCntrRfInfos.size();
				for(int idx = 0 ; idx < ediCntrRfInfosMaxSize ; idx++)
				{
					comFlatFile.append(ediCntrRfInfos.get(idx)).append("\n");
				}
			}
			
			//comFlatFile.append(("".equals(ediCntrAwkInfo))?"":ediCntrAwkInfo+"\n");
			if(ediCntrAwkInfos != null)
			{
				int ediCntrAwkInfosMaxSize = ediCntrAwkInfos.size();
				for(int idx = 0 ; idx < ediCntrAwkInfosMaxSize ; idx++)
				{
					comFlatFile.append(ediCntrAwkInfos.get(idx)).append("\n");
				}
			}
			
			//comFlatFile.append(("".equals(ediCntrDgInfo))?"":ediCntrDgInfo+"\n");
			if(ediCntrDgInfos != null)
			{
				int ediCntrDgInfosMaxSize = ediCntrDgInfos.size();
				for(int idx = 0 ; idx < ediCntrDgInfosMaxSize ; idx++)
				{
					comFlatFile.append(ediCntrDgInfos.get(idx)).append("\n");
				}
			}
			
			
			comFlatFile.append(("".equals(ediTroGen))?"":ediTroGen+"\n");
			comFlatFile.append(("".equals(ediTroEur))?"":ediTroEur+"\n");
			comFlatFile.append(("".equals(ediDgInfo))?"":ediDgInfo+"\n");
			//comFlatFile.append(("".equals(ediBlCntr))?"":ediBlCntr+"\n");
			
			if(ediBlCntrs != null)
			{
				int ediBlCntrsMaxSize = ediBlCntrs.size();
				for(int idx = 0 ; idx < ediBlCntrsMaxSize ; idx++)
				{
					comFlatFile.append(ediBlCntrs.get(idx)).append("\n");
				}
			}
			
			if(ediBlVvds != null) {
				int ediBlVvdsMaxSize = ediBlVvds.size();
				for(int idx = 0; idx <ediBlVvdsMaxSize; idx++) {
					comFlatFile.append(ediBlVvds.get(idx)).append("\n");
				}
			}
			
			comFlatFile.append(("".equals(ediBlPoInfo))?"":ediBlPoInfo+"\n");
			comFlatFile.append(("".equals(ediBlDesc))?"":ediBlDesc+"\n");
			comFlatFile.append(("".equals(ediBkgCm))?"":ediBkgCm+"\n");

			xterRqstNoVO = dbDao.searchXterRqstNo(bkgBlNoVO);
			if ( xterRqstNoVO != null ) {
				ediXterInfo = JSPUtil.getNull(dbDao.searchCust301XterInfo(xterRqstNoVO));
				//ediXterCust = JSPUtil.getNull(dbDao.searchCust301XterCust(xterRqstNoVO));
				ediXterCusts = dbDao.searchCust301XterCust(xterRqstNoVO);
				ediXterCm = JSPUtil.getNull(dbDao.searchCust301XterCm(xterRqstNoVO));

				comFlatFile.append(("".equals(ediXterInfo))?"":ediXterInfo+"\n");
				//comFlatFile.append(("".equals(ediXterCust))?"":ediXterCust+"\n");
				if(ediXterCusts != null)
				{
					int ediXterCustsMaxSize = ediXterCusts.size();
					for(int idx = 0; idx < ediXterCustsMaxSize ; idx++)
					{
						comFlatFile.append(ediXterCusts.get(idx)).append("\n");
					}
				}
				comFlatFile.append(("".equals(ediXterCm))?"":ediXterCm+"\n");
			}

			//  1. Customer(custTpIdVO)의 수 만큼 공통 정보 추가하기
			//  2. EDI로 메시지 전송(각 Customer별로)
			for (int j=0;j<flatFiles.length;j++) {
				//flatFiles[j] = flatFiles[j] + comFlatFile.toString();
				StringBuffer flatFiles1 = new StringBuffer("");
				flatFiles1.append(flatFiles[j]);
				flatFiles1.append(comFlatFile.toString());
				
				// 2015.03.24 [CHM-201534745] GTN 경우 특수문자 치환
				String rcvId = custTpIdVOList.get(j).getRcvId();
				if("TRADIANT".equals(rcvId)){
					flatFiles[j] = flatFiles1.toString().replace(">",".").replace("^",".").replace("~",".").replace("?",".");
                } else{
					flatFiles[j] = flatFiles1.toString();
				}
				
				// Send
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFiles[j]);
				String queueNm = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER_301.IBMMQ.QUEUE");
				sendFlatFileVO.setQueueNm(queueNm);
				FlatFileAckVO flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
				log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

				if ( flatFileAckVO.getAckStsCd().equals("E") )
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());

				log.debug("RESULT:"+flatFiles[j]);

				// History
				CustTpIdVO custTpVO2 = custTpIdVOList.get(j);
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setHisSeq(String.valueOf(j+1).toString());
				bkgNtcHisVO.setNtcViaCd("E");
				bkgNtcHisVO.setNtcKndCd("BK");
				bkgNtcHisVO.setEdiId(custTpVO2.getRcvId());
				bkgNtcHisVO.setEsvcGrpCd(custTpVO2.getGroupId());
				if(flatFileAckVO.getAckStsCd()!=null){
					bkgNtcHisVO.setBkgNtcSndRsltCd(flatFileAckVO.getAckStsCd());
				}
				if(ediHeader!=null){
					bkgNtcHisVO.setFltFileRefNo(ediHeader.substring(62));
				}
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
			return bkgNtcHisVOs;
		}catch(EventException ex){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 *  Terminal에 보낼 EDI정보를 생성 및 전송 BackEndJob 처리
	 * 
	 * @author Kim Byung Kyu
	 * @param Vender301ParamVO vender301ParamVO
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String createTmlBkgReceiptEdiBackEnd(Vender301ParamVO vender301ParamVO, SignOnUserAccount account) throws EventException {
		CreateTmlBkgReceiptEdiBackEndJob createTmlBkgReceiptEdiBackEnd = new CreateTmlBkgReceiptEdiBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			createTmlBkgReceiptEdiBackEnd.setVender301ParamVO(vender301ParamVO);
			createTmlBkgReceiptEdiBackEnd.setSignOnUserAccount(account);

			return backEndJobManager.execute(createTmlBkgReceiptEdiBackEnd, account.getUsr_id(), "createTmlBkgReceiptEdiBackEnd");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}		
	
	/**
	 * Terminal에 보낼 EDI정보를 생성 및 전송한다.(ESM_BKG_0702)
	 * @author	Jun Yong Jin
	 * @param Vender301ParamVO vender301ParamVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> createTmlBkgReceiptEdi(Vender301ParamVO vender301ParamVO ,SignOnUserAccount account) throws EventException{
//							 createTmlBkgReceiptEdi(event.getBkgBlNoVO(), null,                    "U",           event.getNtcKndCd()[i], "N", event.getCustTpIdVOs()[i].getRcvId(), account);
		BookingUtil utilBC = new BookingUtil();
		String hostId = null;
//		String cct = null;
		BkgVvdVO bkgVvdVO = new BkgVvdVO();
		List<TmnlRcvIdVO> tmnlRcvIdVOs = new ArrayList<TmnlRcvIdVO>();
		List<TmnlRcvIdVO> tmnlNsBracRcvIdVOs = new ArrayList<TmnlRcvIdVO>();
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		List<Tmnl301DgInfoVO> tmnl301DgInfoVOs = new ArrayList<Tmnl301DgInfoVO>();
		List<Tmnl301TroMainInfoVO> tmnl301TroMainInfoVOs = new ArrayList<Tmnl301TroMainInfoVO>();

		String ediHeader  		= null;
		String ediBlMain1 		= null;
		String ediBlMain2 		= null;
		String ediCntrInfo 		= null;
		String ediCntrRfInfo 	= null;
		String ediCntrAwkInfo 	= null;
		String ediCntrDgInfo 	= null;
//		String ediDgInfo 		= null;
		String ediBlCntr		= null;
//		String ediBlVvd 		= "";
		String ediBlPoInfo 		= null;
		String tmlEdiRefNo 		= null;
		String ediTroMainInfo	= null;
		String ediTroDtlInfo    = null;
		try {
			
			// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
			BkgBlNoVO bkgBlNoVO = vender301ParamVO.getBkgBlNoVO();
			List<BkgVvdVO> oldVvdVOs = vender301ParamVO.getOldVvdVOs();
			List<BkgQuantityVO> oldQtyVOs = vender301ParamVO.getOldQtyVOs();
//			String oldMtyPkupYdCd = vender301ParamVO.getOldMtyPkupYdCd();
			String bracCd = vender301ParamVO.getBracCd();
			String ediKind = vender301ParamVO.getEdiKind();
			String autoManualFlg = vender301ParamVO.getAutoManualFlg();
			String rcvId = vender301ParamVO.getRcvId();
			
			bkgVvdVO = dbDao.searchTmnl301LanePol(bkgBlNoVO);
//			String[] flatFiles = null;

			// 자동 전송일때 별도로 rcv_id 조회함(Booking 생성, Booking 수정, cancel, split, special cargo request시
			if("Y".equals(autoManualFlg)){
				//booking main 화면에 있는 edi block flag를 켜두면 자동 전송하지 않도록 한다.
				if("Y".equals(dbDao.searchAutoEdiBlockFlg(bkgBlNoVO))){
					log.error("자동전송 - edi block flag = Y");
					return bkgNtcHisVOs;
				}
				tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForAutoSend(bkgBlNoVO, bracCd);
				//auto 전송인데 receive id를 못찾은 경우 return
				if(tmnlRcvIdVOs.size()==0){
					log.error("자동전송 - receive id를 못찾은 경우");
					return bkgNtcHisVOs;
				}
				if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
					log.error("자동전송 - no rate block flag = Y");
					return bkgNtcHisVOs;
				}
				if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
					log.error("자동전송 - stand by block flag = Y");
					return bkgNtcHisVOs;
				}
			} else {
				if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
					throw new EventException(new ErrorHandler("BKG08333",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
				}
				if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
					throw new EventException(new ErrorHandler("BKG08284",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
				}
				if(rcvId==null || rcvId.length()<1){//receive id 없을 경우 새로 구함
					if ( "BT".equals(ediKind)){
						tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForBkgCfm(bkgBlNoVO, bkgVvdVO.getSlanCd(), bkgVvdVO.getPolCd(), autoManualFlg);
					} else if ( "CN".equals(ediKind) ) {
						//EMPTY_RELEASE, ESM_BKG_0252.EmptyReleaseOrder EDI 전송
						tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForMtyRel(bkgBlNoVO, bkgVvdVO.getSlanCd(), bkgVvdVO.getPolCd(), autoManualFlg);
					} else if ( "FC".equals(ediKind) ) {
						//FULL_RELEASE <- 실제 발생하지 않음(0098 화면에서는 rcv id를 받아옴)
						tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForFullRel(bkgBlNoVO, bkgVvdVO.getSlanCd(), bkgVvdVO.getPolCd(), autoManualFlg);
					} else if ( "BM".equals(ediKind) ){
						//0616 Booking EDI Transmit to Terminal, 0702 Booking Receipt Draft BL EDI 화면에서 전송시 edi id 새로 구해야 함
						tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForManualSend(bkgBlNoVO, bracCd);								
					} else {
						tmnlRcvIdVOs = dbDao.searchTmnl301RcvIdForDefault(bkgBlNoVO, bkgVvdVO.getSlanCd(), bkgVvdVO.getPolCd(), autoManualFlg);								
					}
					
				}
				if(rcvId!=null && rcvId.length()>1){//receive id 있을 경우, 0098 fax/edi pop-up에서 전송시 
					TmnlRcvIdVO tmnlRcvIdVO = new TmnlRcvIdVO();
					tmnlRcvIdVO.setEdiRcvId(rcvId);					
					tmnlRcvIdVOs.add(tmnlRcvIdVO);
//					flatFiles = new String[tmnlRcvIdVOs.size()];
				} else {//manual인데 rcv id도 지정이 안돼있고 receive id도 못찾은 경우
					if(tmnlRcvIdVOs.size()==0){
						log.error("자동전송N - receive id를 못찾은 경우");
						return bkgNtcHisVOs;
					}
				}
			}
			
			// 전송할 flat_file 초기화 Terminal(tmnlRcvIdVOs)의 수 만큼 생성
//			flatFiles = new String[tmnlRcvIdVOs.size()];
			List<String> flatFiles = new ArrayList<String>();
			
			for (int i=0;i<tmnlRcvIdVOs.size();i++) {
				TmnlRcvIdVO tmnlRcvIdVO = tmnlRcvIdVOs.get(i);

				// 2011.12.09 이인영 [CHM-201114893-01] Split 01-NS RELORD 신규개발 건
				// New_BkgQuantity와 Old_BkgQuantity를 비교하여 NS_BRAC을 설정한다.
				String nsBracCd = "";
				List<BkgQuantityVO> newBkgQtyVOs = dbDao.searchTmnl301BkgQuantity(bkgBlNoVO.getBkgNo());
				
				/* 1. Old_BkgQuantity가 null 일 경우 (물량변경 없는 화면에서 호출된 경우, 배치에서 호출된 경우) : Update
				    2. BRAC_CD가 R(Booking Cancel)일 경우 : R 
				    3. Old_Quantity가 0건일 경우 : New
				    4. 컨테이너 개수만 변경되는 경우               ex) D2 x 1 -> D2 x 2 (Update)
				    5. 컨테이너 Type만 변경되는 경우              ex) D4 x 1 -> D5 x 1 (New)
				                                                                    ex) D2 x 1 -> D2 x 2 (Update)
				                                                                         D4 x 1 ->            (Delete) : 삭제 대상에 대해서는 기술하지 않음.
				    6. 컨테이너 개수,Type 모두 변경된 경우     ex) D2 x 1-> D2 x 2 (Update)
				                                                                                    -> D4 x 1 (New)
					7. NS Batch에서 실행한 경우 파라미터의 brac 값을 그대로 사용한다.				                                                                                    
				    * 4~6에 대해서 New_Quantity를 기준으로 Old_Quantity와 비교하여 TypeCd의 유무에 따라 Update, New를 적용한다.
				*/ 
				
				Set<String> nsBracLoopSet = new HashSet<String>();
				
				if("R".equals(tmnlRcvIdVO.getBracCd())){
					nsBracLoopSet.add("R");
					
				// BRAC_CD가 N(New) 일 경우 : N
				} else if("N".equals(tmnlRcvIdVO.getBracCd())){
					nsBracLoopSet.add("N");
					
				// BRAC_CD가 B 일 경우 : B
				} else if("B".equals(tmnlRcvIdVO.getBracCd())){
					nsBracLoopSet.add("B");
					
				// 1. Old_Quantity가 null 일 경우 : Update
				} else if(oldQtyVOs == null) {
					nsBracLoopSet.add("U");
				
				// EDI Receive ID 가 NS가 아닐땐 BRAC_CD를 설정.
				} else if(!"NS".equals(tmnlRcvIdVO.getEdiRcvId())) {
					nsBracLoopSet.add(tmnlRcvIdVO.getBracCd());
					
				} else if("Y".equals(vender301ParamVO.getNsBatchFlag()))
				{
					nsBracLoopSet.add(vender301ParamVO.getBracCd());
					
				} else {
					String newTpszCd = "";
					String oldTpszCd = "";
					boolean isExist = true;
					
					for(int k=0; k<newBkgQtyVOs.size(); k++){
						newTpszCd = ((BkgQuantityVO)newBkgQtyVOs.get(k)).getCntrTpszCd();

						// Flag 초기화
						isExist = true;

						if(oldQtyVOs.size() > 0) {
							
							for(int l=0; l<oldQtyVOs.size(); l++){
								oldTpszCd = ((BkgQuantityVO)oldQtyVOs.get(l)).getCntrTpszCd();
								
								// New_Qunatity의 TypeCd가 Old_Qunatity에 존재 => NS_BRAC : Update.
								if(newTpszCd.equals(oldTpszCd)){
									nsBracLoopSet.add("U");
									isExist = true;
									break;

								} else {
									isExist = false;
								}
							}

							// New_Qunatity의 TypeCd가 Old_Qunatity에 존재하지 않음 => NS_BRAC : New.
							if(!isExist){
								nsBracLoopSet.add("N");
							}
							
							
							
						// 3. Old_Quantity가 0건일 경우
						} else {
							nsBracLoopSet.add("N");
						}
					}
				}
				
				hostId = utilBC.searchEdi301HostId(tmnlRcvIdVO.getEdiRcvId(), "TMNL");
//					cct = JSPUtil.getNull(dbDao.searchCust301Cct(bkgBlNoVO));// 불필요 -> bkg_clz_tm에서 조회해서 ff에 넣음

				// 전송할 flat_file 생성 New_Quantity의 수 만큼 생성
				Iterator<String> it = nsBracLoopSet.iterator();
				while(it.hasNext()) {
					nsBracCd = (String)it.next();
					
					// *****************    Flat File 생성 로직 (Start) *******
					
					if("Y".equals(autoManualFlg)){//auto 전송일때는 kind를 조회 결과에서 가져옴
						ediKind = tmnlRcvIdVO.getKind();
					}
					
					if ("CN".equals(ediKind)||"FC".equals(ediKind)) {//EMPTY RELEASE or FULL RELEASE 
						ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(hostId, tmnlRcvIdVO.getEdiRcvId(), "RELORD"));
					} else {
						ediHeader = JSPUtil.getNull(utilBC.searchEdiHeader(hostId, tmnlRcvIdVO.getEdiRcvId(), "301"));
					}
					tmlEdiRefNo = ediHeader.substring(62);
					log.debug("tmlEdiRefNo:"+tmlEdiRefNo);
					
					BkgVvdVO oldVvdVO = null;
					if(oldVvdVOs != null){
						for(int j=0 ;j < oldVvdVOs.size(); j++){
							if(oldVvdVOs.get(j).getVslPrePstCd().equals("T"))
								oldVvdVO = oldVvdVOs.get(j);
						}
					}
					if("Y".equals(autoManualFlg)||"BM".equals(ediKind)){
						if(tmnlRcvIdVO.getBracCd() == null || tmnlRcvIdVO.getBracCd().length()<1){
							String tmpBracCd = dbDao.searchTmnl301Brac(bkgBlNoVO, rcvId);
							tmnlRcvIdVO.setBracCd((tmpBracCd == null) ? "N" : tmpBracCd) ;
						}
						
						// Vender301ParamVO로 부터 Tmnl301Bl 정보 검색을 위한 Parameter를 설정한다.
						vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
						vender301ParamVO.setBracCd(tmnlRcvIdVO.getBracCd());
						vender301ParamVO.setNsBracCd(nsBracCd);
						vender301ParamVO.setOldVvdVO(oldVvdVO);
						vender301ParamVO.setCct("");
						vender301ParamVO.setRcvId(tmnlRcvIdVO.getEdiRcvId());
						vender301ParamVO.setBracCdNew(tmnlRcvIdVO.getBracCd());
						
						ediBlMain1 = JSPUtil.getNull(dbDao.searchTmnl301BlMain1(vender301ParamVO));
					} else {
						// cancel로 전송이 아는 경우
						if(!(bracCd != null && bracCd.equals("R"))){	
							String tmpBracCd = dbDao.searchTmnl301Brac(bkgBlNoVO, rcvId);
							bracCd = (tmpBracCd == null) ? "N" : tmpBracCd;
						}
						// Vender301ParamVO로 부터 Tmnl301Bl 정보 검색을 위한 Parameter를 설정한다.
						vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
						vender301ParamVO.setBracCd(bracCd);
						vender301ParamVO.setNsBracCd(nsBracCd);
						vender301ParamVO.setOldVvdVO(oldVvdVO);
						vender301ParamVO.setCct("");
						vender301ParamVO.setRcvId(tmnlRcvIdVO.getEdiRcvId());
						vender301ParamVO.setBracCdNew(bracCd);
						
						ediBlMain1 = JSPUtil.getNull(dbDao.searchTmnl301BlMain1(vender301ParamVO));
					}
					ediBlMain2 = JSPUtil.getNull(dbDao.searchTmnl301BlMain2(bkgBlNoVO, tmnlRcvIdVO.getEdiRcvId()));

					StringBuffer flatFiles1 = new StringBuffer("");
					flatFiles1.append(("".equals(ediHeader))?"":ediHeader+"\n");
					flatFiles1.append(("".equals(ediBlMain1))?"":ediBlMain1+"\n");
					flatFiles1.append(("".equals(ediBlMain2))?"":ediBlMain2+"\n");
					
					flatFiles.add(flatFiles1.toString());
					
					tmnlNsBracRcvIdVOs.add(tmnlRcvIdVO);
				}
				// *****************    Flat File 생성 로직 (End) *******
			}

			StringBuffer comFlatFile = new StringBuffer();
			ediCntrInfo = JSPUtil.getNull(dbDao.searchTmnl301CntrInfo(bkgBlNoVO));
			ediCntrRfInfo = JSPUtil.getNull(dbDao.searchTmnl301CntrRfInfo(bkgBlNoVO));
			ediCntrAwkInfo = JSPUtil.getNull(dbDao.searchTmnl301CntrAwkInfo(bkgBlNoVO));

			comFlatFile.append(("".equals(ediCntrInfo))?"":ediCntrInfo+"\n");
			comFlatFile.append(("".equals(ediCntrRfInfo))?"":ediCntrRfInfo+"\n");
			comFlatFile.append(("".equals(ediCntrAwkInfo))?"":ediCntrAwkInfo+"\n");

			tmnl301DgInfoVOs = dbDao.searchTmnl301DgInfo(bkgBlNoVO);

			for(int i=0; i<tmnl301DgInfoVOs.size(); i++){
				comFlatFile.append(tmnl301DgInfoVOs.get(i).getDgInfo());
	
				ediCntrDgInfo = JSPUtil.getNull(dbDao.searchTmnl301CntrDgInfo(tmnl301DgInfoVOs.get(i)));
				comFlatFile.append(("".equals(ediCntrDgInfo))?"":ediCntrDgInfo+"\n");
				
				// searchEdi301CntrDgInfo의 결과값이 있는 경우만 붙인다.
				comFlatFile.append("}CNTR_INFO\n");
			}
//			// searchEdi301CntrDgInfo의 결과값이 있는 경우만 붙인다.
//			if(!"".equals(ediCntrDgInfo)){
//				comFlatFile.append("}CNTR_INFO\n");
//			}
			
			ediBlCntr = JSPUtil.getNull(dbDao.searchTmnl301BlCntr(bkgBlNoVO, oldQtyVOs));
			comFlatFile.append(("".equals(ediBlCntr))?"":ediBlCntr+"\n");
			List<Tmnl301BlVvdVO> tmnl301BlVvdVOs = dbDao.searchTmnl301BlVvd(bkgBlNoVO);
			for(int j=0; j<tmnl301BlVvdVOs.size(); j++){
				Tmnl301BlVvdVO tmnl301BlVvdVO = tmnl301BlVvdVOs.get(j);
				//comFlatFile.append(tmnl301BlVvdVO.getBlVvd());
				
				String oldVvd = "";
				String addOldVddFlag = "N"; 
				if(oldVvdVOs != null){
					for(int k=0; k < oldVvdVOs.size(); k++){
						BkgVvdVO oldVvdVO = oldVvdVOs.get(k);
						if(tmnl301BlVvdVO.getPolCd().equals(oldVvdVO.getPolCd())){
							if(tmnl301BlVvdVO.getVvdCd().equals(oldVvdVO.getVslCd()+oldVvdVO.getSkdVoyNo()+oldVvdVO.getSkdDirCd())){
								addOldVddFlag = "S";//해당 POL 의 VVD 유지, OLDVVD에 빈값
							}else if(!"S".equals(addOldVddFlag)){
								oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd(oldVvdVO.getVslCd(),oldVvdVO.getSkdVoyNo(),oldVvdVO.getSkdDirCd(),oldVvdVO.getPolCd(),oldVvdVO.getPolYdCd(),oldVvdVO.getPodCd(),oldVvdVO.getPodYdCd()));
								addOldVddFlag = "C";//해당 POL 의 VVD 바뀜
							}
						}
					}
					
					// 미주 Rollover [CHM-201432243] VSL Rollover시 POL이 바뀌는 경우에 대한 BKG Cancel FF 수정
					if(tmnl301BlVvdVO.getPolCd()!=null && tmnl301BlVvdVO.getPolCd().length()>4 
					&& (tmnl301BlVvdVO.getPolCd().substring(0,2).equals("US") || tmnl301BlVvdVO.getPolCd().substring(0,2).equals("CA"))){
						if("N".equals(addOldVddFlag)){// POL 바뀌면서 VVD 바뀐 케이스, 변경 후 유지 안되는 VVD 넣기
							for(int k=0; k < oldVvdVOs.size(); k++){
								BkgVvdVO oldVvdVO = oldVvdVOs.get(k);
								String existflag = "N";
								for(int l=0; l<tmnl301BlVvdVOs.size(); l++){
									Tmnl301BlVvdVO tmnl301BlVvdVO2 = tmnl301BlVvdVOs.get(l);
									if(tmnl301BlVvdVO2.getPolCd().equals(oldVvdVO.getPolCd())){
										if(tmnl301BlVvdVO2.getVvdCd().equals(oldVvdVO.getVslCd()+oldVvdVO.getSkdVoyNo()+oldVvdVO.getSkdDirCd())){
											existflag = "Y";
										}
									}
								}
								if("N".equals(existflag)){// 유지 안되는 VVD, 찍어 줌
									oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd(oldVvdVO.getVslCd(),oldVvdVO.getSkdVoyNo(),oldVvdVO.getSkdDirCd(),oldVvdVO.getPolCd(),oldVvdVO.getPolYdCd(),oldVvdVO.getPodCd(),oldVvdVO.getPodYdCd()));
									comFlatFile.append(tmnl301BlVvdVO.getBlVvd());
									comFlatFile.append(("".equals(oldVvd))?"":oldVvd+"\n");
									addOldVddFlag = "A";
								}
							}
						}
					}
					
					if ("C".equals(addOldVddFlag)){
						comFlatFile.append(tmnl301BlVvdVO.getBlVvd());
						comFlatFile.append(("".equals(oldVvd))?"":oldVvd+"\n");
					}
					if ("N".equals(addOldVddFlag) || "S".equals(addOldVddFlag)) {
						oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd("","","","","","",""));
						comFlatFile.append(tmnl301BlVvdVO.getBlVvd());
						comFlatFile.append(("".equals(oldVvd))?"":oldVvd+"\n");
					}
				} else {
					oldVvd = JSPUtil.getNull(dbDao.searchTmnl301OldVvd("","","","","","",""));
					comFlatFile.append(tmnl301BlVvdVO.getBlVvd());
					comFlatFile.append(("".equals(oldVvd))?"":oldVvd+"\n");
				}
			}
			ediBlPoInfo = JSPUtil.getNull(dbDao.searchEdi301BlPoInfo(bkgBlNoVO));			
			
			comFlatFile.append(("".equals(ediBlPoInfo))?"":ediBlPoInfo+"\n");

			// 2018.06.15 iylee 한국 TRO 일 경우(Receive ID:KTNET), TRO 내용을 추가.
			if("KTNETPCS".equals(rcvId)){
				
				List<TroMstVO> troMstList = dbDao.searchTroInfo(bkgBlNoVO);
				
				// TRO Main 
				for(int t=0; t<troMstList.size(); t++){
				
					tmnl301TroMainInfoVOs = dbDao.searchTmnl301TroMainInfo(troMstList.get(t));
					comFlatFile.append(tmnl301TroMainInfoVOs.get(t).getTroMainInfo());
					
					// TRO Detail
					for(int i=0; i<tmnl301TroMainInfoVOs.size(); i++){
			
						ediTroDtlInfo = JSPUtil.getNull(dbDao.searchTmnl301TroDtlInfo(tmnl301TroMainInfoVOs.get(i)));
						comFlatFile.append(("".equals(ediTroDtlInfo))?"":ediTroDtlInfo+"\n");
						
						// searchEdi301CntrDgInfo의 결과값이 있는 경우만 붙인다.
						//comFlatFile.append("}TRO_OUT\n");
					}
				}
			}
			
			log.debug(comFlatFile.toString());
			//  1. Terminal(tmnlRcvIdVOs)의 수 만큼 공통 정보 추가하기
			//  2. EDI로 메시지 전송(각 Terminal별로)
			for (int j=0;j<flatFiles.size();j++) {
				
				StringBuffer sb = new StringBuffer(flatFiles.get(j));
				sb.append(comFlatFile);
				
				String flatTmp = sb.toString(); 
//				String flatTmp = (String)flatFiles.get(j);
//				flatTmp += comFlatFile.toString();

				// Send
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatTmp);
				String queueNm = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_VENDOR_301.IBMMQ.QUEUE");
				sendFlatFileVO.setQueueNm(queueNm);
				FlatFileAckVO flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
				log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

				if ( flatFileAckVO.getAckStsCd().equals("E") )
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());

				log.debug("RESULT:"+flatTmp);
				log.debug(flatFileAckVO.getSendId());
				
				// History				
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setHisSeq(String.valueOf(j+1).toString());
				bkgNtcHisVO.setNtcViaCd("E"); 

				if("Y".equals(autoManualFlg)){//auto 전송일때는 kind를 조회 결과에서 가져옴
					ediKind = tmnlNsBracRcvIdVOs.get(j).getKind();
				} else if("BM".equals(ediKind)){//"BM" manual 전송은 BT로 바꿈
					ediKind = "BT";
				}
				
				bkgNtcHisVO.setNtcKndCd(StringUtils.isEmpty(ediKind) ? "BT" : ediKind);

				bkgNtcHisVO.setEdiId(tmnlNsBracRcvIdVOs.get(j).getEdiRcvId());
//				bkgNtcHisVO.setEsvcGrpCd(tmnlRcvIdVO2.getGroupId());
				bkgNtcHisVO.setBkgNtcSndRsltCd(flatFileAckVO.getAckStsCd());
				bkgNtcHisVO.setSndId(hostId);
				
				// Account 정보가 없을 경우에는 Batch에서 호출된것으로 판단하여 User ID, Office CD을 SYSTEM으로 설정한다.
				String usrId = "SYSTEM";
				String ofcCd = "SYSTEM";
				
				if(account != null){
					usrId = account.getUsr_id();
					ofcCd = account.getOfc_cd();
				}
				bkgNtcHisVO.setSndUsrId(usrId);
				bkgNtcHisVO.setSndOfcCd(ofcCd);
				bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
				if("Y".equals(autoManualFlg)||"BM".equals(ediKind)){
					bkgNtcHisVO.setTmlNtcSndStsCd(tmnlNsBracRcvIdVOs.get(j).getBracCd());
				} else {
					bkgNtcHisVO.setTmlNtcSndStsCd(bracCd);
				}
				bkgNtcHisVO.setDiffRmk(tmlEdiRefNo);
				bkgNtcHisVO.setCreUsrId(usrId);
				bkgNtcHisVO.setUpdUsrId(usrId);
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
			log.info("####################");
			log.info("bkgNtcHisVOs length : " +bkgNtcHisVOs.size() );
			log.info("####################");
			return bkgNtcHisVOs;
		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Empty Booking의 T/S Route정보를 조회한다.<br>
	 * 
	 * @author		KimByungKyu
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @return 		List<MtyBkgTsRouteVO>
	 * @exception 	EventException
	 */
	public List<MtyBkgTsRouteVO> searchEmptyBkgTsRoute(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			return dbDao.searchEmptyBkgTsRoute(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}		
	
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
	public List<RepoCntrVO> searchCntrByYard(String vvd, String ydCd, String cntrTpsz) throws EventException {
		try {
			return dbDao.searchCntrByYard(vvd, ydCd, cntrTpsz);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}			

	/**
	 * Fax/Email 발송 리스트를 조회한다.(ESM_BKG_0095)<br>
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return List<SendBkgFaxEmailVO>
	 * @exception 	EventException
	 */
	public List<SendBkgFaxEmailVO> searchFaxEmailForNotice(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchFaxEmailForNotice(bkgBlNoVO, account.getOfc_cd());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}			

	/**
	 * EDI 발송 리스트를 조회한다.(ESM_BKG_0095)<br>
	 *
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<SendBkgEdiVO>
	 * @exception 	EventException
	 */
	public List<SendBkgEdiVO> searchEdiForNotice(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchEdiForNotice(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}			

	/**
	 * Bkg Receipt Type을 조회한다.(ESM_BKG_0095)<br>
	 *
	 * @author Jun Yong Jin
	 * @param String usrId
	 * @return String 
	 * @exception 	EventException
	 */
	public String searchBkgReceiptType(String usrId) throws EventException {
		try {
			return dbDao.searchBkgReceiptType(usrId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * edi 전송시 type/size별 yard 구분을 위해 기초 정보를 조회<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param QtyInfoVO qtyInfoVO
	 * @return YardAssignVO
	 * @exception EventException
	 */
	public YardAssignVO searchYardAssign( BkgBlNoVO bkgBlNoVO , QtyInfoVO qtyInfoVO ) throws EventException{
		try {
			YardAssignVO yardAssignVO = new YardAssignVO();
			yardAssignVO.setBkgInfoForYardAssignVO(dbDao.searchBkgInfoForYardAssign(bkgBlNoVO));
			if (qtyInfoVO ==null){
				yardAssignVO.setQtyInfoVOList(dbDao.searchQtyInfoForYardAssign(bkgBlNoVO));
			}			
			
			return yardAssignVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * 입력한 yard가 mdm_yard에 있는지 확인한다.<br>
	 * 
	 * @param QtyInfoVO[] qtyInfoVOs
	 * @exception EventException
	 */
	public void validateYardAssign(QtyInfoVO[] qtyInfoVOs) throws EventException{
		try {
			BookingUtil utilBC = new BookingUtil();
			MdmYardVO mdmYardVO = null;
			List<MdmYardVO> mdmYardVOList = null; 
			
			for(int i=0;i<qtyInfoVOs.length;i++){
				mdmYardVO = new MdmYardVO();
				if (JSPUtil.getNull(qtyInfoVOs[i].getYdCd()).length()==7){
					mdmYardVO.setLocCd(qtyInfoVOs[i].getYdCd().substring(0,5));
					mdmYardVO.setYdCd(qtyInfoVOs[i].getYdCd());
				}else if (JSPUtil.getNull(qtyInfoVOs[i].getYdCd()).length()>4){
					mdmYardVO.setLocCd(qtyInfoVOs[i].getYdCd().substring(0,5));
				}
				 
				mdmYardVOList=utilBC.searchYardCode(mdmYardVO);
				if (mdmYardVOList.isEmpty()){
					throw new EventException((String)new ErrorHandler("BKG01078",new String[]{qtyInfoVOs[i].getYdCd()}).getMessage());
				}
			}
			
		} catch (EventException ex) {
			throw ex;			 
	    } catch(Exception ex) {
	    	log.error(ex.getMessage(),ex);
	    	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 *  Route Detail 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param bkgNo	
	 * @return awkCgoApplVO
	 * @exception EventException
	 */
	public RouteDtlVO searchRouteDetail(String bkgNo) throws EventException {

		RouteDtlVO routeDtlVO = new RouteDtlVO();		
		
        try {        	
        		log.debug("&&&&&&&&&&&&&&&&&& routeDtlVO : " + routeDtlVO);          
                log.debug(">>>>>>>>> bkgNo      : " + bkgNo);
                
                routeDtlVO.setRouteDtlInfo(dbDao.searchRouteDtlInfoList(bkgNo));                
                routeDtlVO.setRouteDtlVvd(dbDao.searchRouteDtlVvdList(bkgNo));
                
                
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
        return routeDtlVO;
    }

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
	public List<BkgNtcHisVO> sendBkgNoticeByFax(String mrdNm, String ntcKndCd, String faxNo, String param, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException{
		try {
			return eaiDao.sendBkgNoticeByFax(bkgBlNoVO, ntcKndCd, faxNo, mrdNm, param, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}		
	}

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
	public List<BkgNtcHisVO> sendBkgNoticeByEmail(String mrdNm, String ntcKndCd, String eml, String param, BkgBlNoVO bkgBlNoVO, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException{
		BookingUtil util = null;
		String ccEmail = null;
		try {
			util = new BookingUtil();
			ccEmail = util.searchCcEmailAddrRSQL("BK", account.getUsr_id());
			return eaiDao.sendBkgNoticeByEmail(bkgBlNoVO, ntcKndCd, eml, mrdNm, param, ccEmail, bkgEmlEdtVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * simple si notice를 전송한다.<br>	 
	 * @param String fileKey	 
	 * @param String ntcKndCd
	 * @param String eml	 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgSimpleSiByEmail(String fileKey, String ntcKndCd, String eml, BkgBlNoVO bkgBlNoVO, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException{
		BookingUtil util = null;
		String ccEmail = null;
		try {
			util = new BookingUtil();
			ccEmail = util.searchCcEmailAddrRSQL(ntcKndCd, account.getUsr_id());
			return eaiDao.sendBkgSimpleSiByEmail(bkgBlNoVO, ntcKndCd, eml, fileKey, ccEmail, bkgEmlEdtVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * searchSimpleSiBkgInfoList 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchSimpleSiBkgInfoList(String bkgNo) throws EventException {
		try {
			return dbDao.searchSimpleSiBkgInfoList(bkgNo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * searchSimpleSiCntrInfoList 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchSimpleSiCntrInfoList(String bkgNo) throws EventException {
		try {
			return dbDao.searchSimpleSiCntrInfoList(bkgNo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * searchSimpleSiHblCntrInfoList 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchSimpleSiHblCntrInfoList(String bkgNo) throws EventException {
		try {
			return dbDao.searchSimpleSiHblCntrInfoList(bkgNo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Booking Creation tab중 어떤 Tab을 보여줘야 하는지 조회한다.<br>
	 *
	 * @author    Lee NamKyung
	 * @param     SignOnUserAccount account
	 * @return    String 
	 * @exception EventException
	 */
	public String searchBkgCreTabByUser(SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchBkgCreTabByUser(account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * booking creation  화면에서 customer code 변경시 이름과 추가 정보를 조회한다.<br>
	 *
	 * @author		KimByungKyu
	 * @param 		String custCntCd
	 * @param 		String custSeq
	 * @return 		BkgCreCustomerVO
	 * @exception 	EventException
	 */
	public BkgCreCustomerVO searchCustNm(	String custCntCd, String custSeq) throws EventException {
		BkgCreCustomerVO bkgCreCustomerVO = null;
		try {
			BookingUtil util = new BookingUtil();
			// SQL Error 가 발생 되지 않도록 custSeq 가 Number 인지 먼저 체크
			if((!"".equals(custCntCd) && null != custCntCd) 
					&& (!"".equals(custSeq) && null != custSeq ) 
					&& !util.isNumberChk(custSeq)){
				throw new EventException(new ErrorHandler("BKG00458",new String[]{custCntCd, custSeq}).getMessage());
			}
			List<BkgCreCustomerVO> searchBkgCreCustomer = dbDao.searchBkgCreCustomer(custCntCd,custSeq,"","");

			if(searchBkgCreCustomer != null && searchBkgCreCustomer.size() > 0){
				bkgCreCustomerVO = searchBkgCreCustomer.get(0);
				if(bkgCreCustomerVO != null){
					if("DELETE".equals(bkgCreCustomerVO.getPb())){
						throw new EventException((String)new ErrorHandler("BKG00353",new String[]{custCntCd, custSeq}).getMessage());
//					}else if("BLACK".equals(bkgCreCustomerVO.getPb())){
//						throw new EventException((String)new ErrorHandler("BKG00055").getMessage());
					}else if("NO USE".equals(bkgCreCustomerVO.getPb())){
						throw new EventException((String)new ErrorHandler("BKG02004",new String[]{custCntCd+custSeq,"\nNo Use Reason : " + bkgCreCustomerVO.getNoUseRsn()}).getMessage());
					}
				}
			}			
		} catch (EventException ex) {
			throw ex;								
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return bkgCreCustomerVO;
	}
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
	public ScgAproRqstVO[] searchBkgForSpclRqst(BkgBlNoVO bkgBlNoVO, String rqstType, SignOnUserAccount account) throws EventException{
		try {
			List<ScgAproRqstVO> aproRqstVO = dbDao.searchBkgForSpclRqst(bkgBlNoVO, rqstType);
			ScgAproRqstVO[] arrAproRqstVO = new ScgAproRqstVO[aproRqstVO.size()];
			for(int i=0;i<aproRqstVO.size();i++){
				arrAproRqstVO[i] = aproRqstVO.get(i); 
        		arrAproRqstVO[i].setIbflag("I");        		
        		arrAproRqstVO[i].setLstRqstDatFlg("N");
        		arrAproRqstVO[i].setRqstUsrId(account.getUsr_id());
        		arrAproRqstVO[i].setRqstOfcCd(account.getOfc_cd());
        		arrAproRqstVO[i].setRqstDt(account.getUpd_dt());
        		arrAproRqstVO[i].setSpclBkgRqstFlg("N");        		
			}
			return arrAproRqstVO;				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		
	}
	/**
	 * special cargo 재 request를 위한 spcl cgo seq들을 조회한다<br>
	 *
	 * @author		Ryu Daeyoung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		SpclReqInVO[]
	 * @exception 	EventException
	 */
	public SpclReqInVO[] searchSpclReqInVO(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			List<SpclReqInVO> spclReqInVOs =  dbDao.searchSpclReqInVO(bkgBlNoVO);
			SpclReqInVO[] rtnSpclReqInVOs = new SpclReqInVO[spclReqInVOs.size()];
			for(int i=0;i<spclReqInVOs.size();i++){
				rtnSpclReqInVOs[i] = spclReqInVOs.get(i);
				rtnSpclReqInVOs[i].setAproCd("R");
			}
			return rtnSpclReqInVOs;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	

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
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendXterReceiptByEmail(BkgBlNoVO[] bkgBlNoVO, String[] emlAddr, String[] remark,String mrdNm, String[] cct, SignOnUserAccount account, String title, String Contents, String vslNm) throws EventException{
//		BLIssuanceBC command = new BLIssuanceBCImpl();
//		String vslNm = null;
		try {
//			vslNm = command.searchVesselNameByBkgNo(bkgBlNoVO[0].getBkgNo());
			return eaiDao.sendXterReceiptByEmail(bkgBlNoVO, emlAddr, remark, mrdNm, cct, vslNm, account, title, Contents );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * bkgNo로 Sale Rep의 계정의 IAM 메일 주소를 조회한다.(ESM_BKG_0079)<br>
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchSlsRepUsrEmlByBkgNo(String bkgNo) throws EventException {
		try {
			return dbDao.searchSlsRepUsrEmlByBkgNo(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0079_01 : searchBkgChgOfc <br>
	 * searchBkgChgOfc 정보를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<BkgChgOfcVO>
	 * @exception EventException
	 */
	public List<BkgChgOfcVO> searchBkgChgOfc(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchBkgChgOfc(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * 남미 5개 국가(브라질, 에콰도르, 도미니카 공화국, 콜롬비아, 우루과이)  BDR이후 C/A issue 직전 체크
	 * @param BkgBlNoVO vo
	 * @return String
	 * @throws EventException
	 */
	public String checkIbByCaIssue(BkgBlNoVO vo) throws EventException {
		try {
			return dbDao.checkIbByCaIssue(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0079_01 : searchXterBkg <br>
	 * 두개의 다른 BKG에 대해 동일 BKG No 채번 방지용 check<br>
	 * 
	 * @param String  bkgNo
	 * @exception EventException
	 */

	public void searchXterBkg(String bkgNo) throws EventException {
		try {
			if(dbDao.searchXterBkg(bkgNo)){
				throw new EventException((String)new ErrorHandler("BKG00460",new String[]{bkgNo}).getMessage());
			}
		} catch (EventException ex) {
			throw ex;								
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * @param OfcRepInputVO ofcRepInputVO
	 * @return List<OfcRepListVO>
	 * @throws EventException
	 */
	public List<OfcRepListVO> searchCtrtRep(OfcRepInputVO ofcRepInputVO)
			throws EventException {
		try {
			return dbDao.searchCtrtRep(ofcRepInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * ESM_BKG_0003 : retrieve <br>
	 * Customer Advisory 정보를 조회한다.<br>
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @return
	 * @throws EventException
	 */
	public List<BkgCustAvcNtcSndVO> searchCustAdvisoryNoticeSendList(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws EventException{
		try{
			return dbDao.searchCustAdvisoryNoticeSendList(bkgCustAvcNtcSchVO);
		} catch(DAOException ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0003 : retrieve <br>
	 * Customer Advisory Cntr Count를 조회한다.<br>
	 *  
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @return String
	 * @throws EventException
	 */
	public String searchCustAdvisoryNoticeCntrCnt(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws EventException{
		try{
			StringBuffer dirStsCdbf = new StringBuffer("'").append(bkgCustAvcNtcSchVO.getEDirCd()).append("','").append(bkgCustAvcNtcSchVO.getWDirCd()).append("','").append(bkgCustAvcNtcSchVO.getSDirCd()).append("','").append(bkgCustAvcNtcSchVO.getNDirCd()).append("'");
			bkgCustAvcNtcSchVO.setDirStsCd(dirStsCdbf.toString());
			
			return dbDao.searchCustAdvisoryNoticeCntrCnt(bkgCustAvcNtcSchVO);
		} catch(DAOException ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0003: upload<br> 
	 * Emergemcy Case 가 발생 한 대상 Container를 기준으로 B/L정보를 저장한다. 
	 * 
	 * @param BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO
	 * @param BkgCustAvcNtcUploadVO[] bkgCustAvcNtcUploadVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createCustAdvisoryNoticeListByUpload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, BkgCustAvcNtcUploadVO[] bkgCustAvcNtcUploadVOs, SignOnUserAccount account) throws EventException{
		try{
			int upSize = bkgCustAvcNtcUploadVOs.length;

			// 0. Excel Upload 의 Cntr No 중복여부를 체크
			ArrayList<String> uploadList = new ArrayList<String>();
			for(int z=0; z<upSize; z++){
				if(bkgCustAvcNtcUploadVOs[z].getCntrNo() != null && !"".equals(bkgCustAvcNtcUploadVOs[z].getCntrNo())){
					uploadList.add(bkgCustAvcNtcUploadVOs[z].getCntrNo());
				}
			}
			
			HashSet<String> upCntrNo = new HashSet<String>();
			upCntrNo.addAll(uploadList);
			if(uploadList.size() != upCntrNo.size()){
				// Error
				throw new EventException(new ErrorHandler("BKG06132").getMessage());
			}
			
			StringBuffer dirStsCdbf = new StringBuffer("'").append(bkgCustAvcNtcSchVO.getEDirCd()).append("','").append(bkgCustAvcNtcSchVO.getWDirCd()).append("','").append(bkgCustAvcNtcSchVO.getSDirCd()).append("','").append(bkgCustAvcNtcSchVO.getNDirCd()).append("'");
			bkgCustAvcNtcSchVO.setDirStsCd(dirStsCdbf.toString());
			
			// 1. 기존에 등록된 Customer Advisory Notice 대상 정보를 삭제
			// Customer Advisory Notice Container
//			dbDao.removeCustAdvisoryNoticeCntrByUpload(bkgCustAvcNtcSchVO);
			// Customer Advisory Notice Detail
//			dbDao.removeCustAdvisoryNoticeDetailByUpload(bkgCustAvcNtcSchVO);
			// Customer Advisory Notice
//			dbDao.removeCustAdvisoryNoticeByUpload(bkgCustAvcNtcSchVO);
			
			
			BkgCustAvcNtcUploadVO bkgCustAvcNtcUploadVO = null;
			StringBuffer cntrs = new StringBuffer();
			// 2. Excel Upload 된 대상을 기준으로 Customer Advisory Notice 정보를 Insert
			for(int i=0; i< upSize; i++){
				
				if(bkgCustAvcNtcUploadVOs[i].getCntrNo() != null && !"".equals(bkgCustAvcNtcUploadVOs[i].getCntrNo())){
					cntrs.append("'").append(bkgCustAvcNtcUploadVOs[i].getCntrNo()).append("'");
				}
				
				if((i< upSize - 1) && ((i+1) % 1000 != 0)) {
					cntrs.append(",");	
				} 
				
				if(i == upSize - 1 || (i+1) % 1000 == 0) {
					bkgCustAvcNtcUploadVO = new BkgCustAvcNtcUploadVO();
					bkgCustAvcNtcUploadVO.setCntrNo(cntrs.toString());
					// Customer Advisory Notice Container
					dbDao.addCustAdvisoryNoticeCntrByUpload(bkgCustAvcNtcSchVO, bkgCustAvcNtcUploadVO, account);
					cntrs = new StringBuffer();
				}
			}

			// Customer Advisory Notice
			dbDao.addCustAdvisoryNoticeByUpload(bkgCustAvcNtcSchVO, account);
			// Customer Advisory Notice Detail
			dbDao.addCustAdvisoryNoticeDetailByUpload(bkgCustAvcNtcSchVO, account);
		
		} catch(EventException ex){
			throw ex;
		} catch(DAOException ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	} 
	
	/**
	 * ESM_BKG_0003: MULTI <br>
	 * Customer Advisory 정보를 변경한다.<br>
	 * 
	 * @param BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCustAdvisoryNoticeList(BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs, SignOnUserAccount account) throws EventException {
		try{
			String[] arrCustCntcTpCd = new String[] { "S", "C", "N", "T"};
			
			for(int i=0; i < bkgCustAvcNtcSndVOs.length; i++){
	
				// FaxNo
				String[] arrFaxNo = new String[] {bkgCustAvcNtcSndVOs[i].getShFaxNo(),bkgCustAvcNtcSndVOs[i].getCnFaxNo(),bkgCustAvcNtcSndVOs[i].getNfFaxNo(),bkgCustAvcNtcSndVOs[i].getCtrtFaxNo()};
				// EMail
				String[] arrMailNo = new String[] {bkgCustAvcNtcSndVOs[i].getShEml(), bkgCustAvcNtcSndVOs[i].getCnEml(), bkgCustAvcNtcSndVOs[i].getNfEml(), bkgCustAvcNtcSndVOs[i].getCtrtCustEml()};

				for(int j=0; j< arrCustCntcTpCd.length; j++){
	
					// Detail 정보 변경 처리
					BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO = new BkgCustAvcNtcDtlVO();
					bkgCustAvcNtcDtlVO.setBlNo(bkgCustAvcNtcSndVOs[i].getBlNo());
					bkgCustAvcNtcDtlVO.setBkgCustTpCd(arrCustCntcTpCd[j]);
					bkgCustAvcNtcDtlVO.setFaxNo(arrFaxNo[j]);
					bkgCustAvcNtcDtlVO.setNtcEml(arrMailNo[j]);
					bkgCustAvcNtcDtlVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());
					
					dbDao.manageCustAdvisoryNoticeList(bkgCustAvcNtcDtlVO, account);
				}
			}
		} catch(DAOException ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0003: fax<br>
	 * 해당 Customer에게  Advisory Notice 에 대한 Fax를 발송한다.
	 *  
	 * @param BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs
	 * @param SignOnUserAccount account
	 * @return int 
	 * @throws EventException
	 */
	public int sendCustAdvisoryNoticeListByFax(BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs, SignOnUserAccount account) throws EventException {
		
		try{
			//String[] arrCustCntcTpCd = new String[] { "S", "C", "N" ,"T"};
			String faxSndId = "";
			int sentInt = 0;
			
			
			// 화주별 list  저장소
			/* 화주별 중복되는 BL 묶어서 전송 
			 * */
			 
			ArrayList groupList = null;
			HashMap custGroupMap = new HashMap();
//			ArrayList preCust = new ArrayList();
//			String nextCust = "";
			//String currCust = "";
//			boolean process = true;
			
			ArrayList preShCust = new ArrayList();
			ArrayList preCnCust = new ArrayList();
			ArrayList preNfCust = new ArrayList();
			ArrayList preCtCust = new ArrayList();
			String nextShCust = "";
			String nextCnCust = "";
			String nextNfCust = "";
			String nextCtCust = "";
			String currShCust = "";
			String currCnCust = "";
			String currNfCust = "";
			String currCtCust = "";
				
			
			boolean shProcess = true;
			boolean cnProcess = true;
			boolean nfProcess = true;
			boolean ctProcess = true;
			
			//4개의 customer 별로 for문을 돌아서 메일을 보내려는 각 customer의 중복성을 막는 CSR 진행
			   //Customer name이 같으면 묶어서 한번에 보냄 (같은 Cusomer 이면 BL_NO, CNTR_NO 합쳐서 한 메일에 보냄)
	           //1. SH 전송 
			for(int i=0; i<bkgCustAvcNtcSndVOs.length; i++){
				if("1".equals(bkgCustAvcNtcSndVOs[i].getShFaxEvntFlg())){
						
					groupList = new ArrayList();
					currShCust = bkgCustAvcNtcSndVOs[i].getShCustNm(); //현재 화주 이름
					
					for(int k = 0; k < preShCust.size() ; k++) {
						if(currShCust.equals(preShCust.get(k))) {
							shProcess = false;
							break;
						}
						shProcess = true;

					}
					
					if(!shProcess)continue;
					
					groupList.add(bkgCustAvcNtcSndVOs[i].getBlNo());

					for(int j=0; j<bkgCustAvcNtcSndVOs.length; j++){
						
						if(i ==  j) continue;
						nextShCust = bkgCustAvcNtcSndVOs[j].getShCustNm();
		
						if(currShCust.equals(nextShCust)) {
							groupList.add(bkgCustAvcNtcSndVOs[j].getBlNo());
							
						}
					}
					preShCust.add(currShCust);
					custGroupMap.put(currShCust, groupList);

					//CHK 가 선택되어있을경우만 실행
				if("1".equals(bkgCustAvcNtcSndVOs[i].getFaxChk())){
	
					// 1. Fax 송신 Flag 를 'Y'로 업데이트 한다.
					dbDao.modifyCustAdvisoryNoticeBySend(bkgCustAvcNtcSndVOs[i], account);
					
//					String[] custName = new String[] {bkgCustAvcNtcSndVOs[i].getShCustNm(), bkgCustAvcNtcSndVOs[i].getCnCustNm(), bkgCustAvcNtcSndVOs[i].getNfCustNm(), bkgCustAvcNtcSndVOs[i].getCtrtFaxNm()};
//					String[] arrFaxlNo = new String[] {bkgCustAvcNtcSndVOs[i].getShFaxNo(),bkgCustAvcNtcSndVOs[i].getCnFaxNo(),bkgCustAvcNtcSndVOs[i].getNfFaxNo(), bkgCustAvcNtcSndVOs[i].getCtrtFaxNo()};
//					String[] arrFaxEvntFlg = new String[] {bkgCustAvcNtcSndVOs[i].getShFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getCnFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getNfFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getCtrtFaxEvntFlg()};
					
					String custName = bkgCustAvcNtcSndVOs[i].getShCustNm();
					String arrFaxlNo = bkgCustAvcNtcSndVOs[i].getShFaxNo();
					//String arrFaxEvntFlg = bkgCustAvcNtcSndVOs[i].getShFaxEvntFlg();
					String blNo = bkgCustAvcNtcSndVOs[i].getBlNo();
					
					// VVD별 Html Contents 정보를 가져온다.
//					BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = dbDao.searchCustAdvisoryNoticeSendCtnt(bkgCustAvcNtcSndVOs[i]);
					
					// Remark 를 조회한다.
//					String rmk = bkgCustAvcNtcSndCtntVO.getRmk();
//					if(rmk == null || "".equals(rmk)){
//						throw new EventException(new ErrorHandler("BKG40119").getMessage()); 
//					}
					
					
					
					//custGroupMap.get(currCust)안에 여러 BL이 들어가 있을 수 있으므로 저 사이즈 만큼 for로 루프
					String hash_bl_no = custGroupMap.get(currShCust).toString();

					hash_bl_no= hash_bl_no.replace("[", "");
					hash_bl_no= hash_bl_no.replace("]", "");
					String[] bl_no = hash_bl_no.split(",");

					BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = null;
					BkgCustAvcNtcSndCtntVO vo = null;
					StringBuffer sb = new StringBuffer();
					
					for(int m=0;m<bl_no.length;m++){
						//for(int m=0;m<bl_no.length;m++){
						//bkgCustAvcNtcSndVOs[i].setBlNo(bl_no[m].trim());// 문제!!
						//}
						//vo = dbDao.searchCustAdvisoryNoticeSendCtnt(bkgCustAvcNtcSndVOs[i]);
						vo = dbDao.searchCustAdvisoryNoticeSendCtntbyDupBlNo(bkgCustAvcNtcSndVOs[i], bl_no[m].trim());
						
					if(vo != null){
						 if(!"".equals(vo.getCntrNo())) {
							sb.append(bl_no[m].trim()).append("/").append(vo.getCntrNo());
							if(bl_no.length > 1 && m < bl_no.length -1) {
								sb.trimToSize();
								sb.append("\n");
							}
						}
						
						
						
						if(m == bl_no.length -1) {
							bkgCustAvcNtcSndCtntVO = new BkgCustAvcNtcSndCtntVO();
							bkgCustAvcNtcSndCtntVO.setCntrNo(sb.toString());
							bkgCustAvcNtcSndCtntVO.setRmk(vo.getRmk());
							bkgCustAvcNtcSndCtntVO.setSndDt(vo.getSndDt());
							bkgCustAvcNtcSndCtntVO.setEmlSubjCtnt(vo.getEmlSubjCtnt());
					
							
						 	}
						}
					}
					
					// Remark 를 조회한다.
					if(bkgCustAvcNtcSndCtntVO != null ) {
						String rmk = bkgCustAvcNtcSndCtntVO.getRmk();					
	
					//for(int j=0; j< arrCustCntcTpCd.length; j++){
	
						// Fax Flag가 '1'인 경우에만 Fax를 전송
						//if(arrFaxEvntFlg[j].equals("1")){
							
							// 2. Fax 전송
							BkgCustAvcNtcFaxSndVO bkgCustAvcNtcFaxSndVO = new BkgCustAvcNtcFaxSndVO();
							bkgCustAvcNtcFaxSndVO.setBlNo(blNo);
							bkgCustAvcNtcFaxSndVO.setBkgNo(bkgCustAvcNtcSndVOs[i].getBkgNo());
							bkgCustAvcNtcFaxSndVO.setCntrNm(custName);
							bkgCustAvcNtcFaxSndVO.setBkgCustTpCd("S");
							bkgCustAvcNtcFaxSndVO.setFaxNo(arrFaxlNo);
							bkgCustAvcNtcFaxSndVO.setVvd(bkgCustAvcNtcSndVOs[i].getVvd());
							bkgCustAvcNtcFaxSndVO.setOfcCd(bkgCustAvcNtcSndVOs[i].getOfcCd());
							bkgCustAvcNtcFaxSndVO.setCntrNo(bkgCustAvcNtcSndCtntVO.getCntrNo());
							
							faxSndId = eaiDao.sendBkgCustAdvisoryNoticeByFax(bkgCustAvcNtcFaxSndVO, account);
					
					  for(int m=0;m<bl_no.length;m++){
							// 2. Fax 전송 후 Advisory Notice 대상 B/L의 연락처 정보를 갱신한다.
							BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO = new BkgCustAvcNtcDtlVO();
							bkgCustAvcNtcDtlVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcDtlVO.setBkgCustTpCd("S");
							bkgCustAvcNtcDtlVO.setCustName(custName);
							bkgCustAvcNtcDtlVO.setFaxNo(arrFaxlNo);
							bkgCustAvcNtcDtlVO.setNtcFaxSndId(faxSndId);
							bkgCustAvcNtcDtlVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());

							dbDao.modifyCustAdvisoryNoticeDetailByFax(bkgCustAvcNtcDtlVO, account);

							// 4. Fax 전송 후 이력정보 Insert
							BkgCustAvcNtcHisVO bkgCustAvcNtcHisVO = new BkgCustAvcNtcHisVO();
							bkgCustAvcNtcHisVO.setVslCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(0, 4));
							bkgCustAvcNtcHisVO.setSkdVoyNo(bkgCustAvcNtcSndVOs[i].getVvd().substring(4, 8));
							bkgCustAvcNtcHisVO.setSkdDirCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(8, 9));
							bkgCustAvcNtcHisVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcHisVO.setNtcViaCd("F");  //F:Fax,M:Email
							bkgCustAvcNtcHisVO.setBkgCustTpCd("S");
							bkgCustAvcNtcHisVO.setPolCd(bkgCustAvcNtcSndVOs[i].getPolCd());
							bkgCustAvcNtcHisVO.setPodCd(bkgCustAvcNtcSndVOs[i].getPodCd());
							bkgCustAvcNtcHisVO.setDelCd(bkgCustAvcNtcSndVOs[i].getDelCd());
							bkgCustAvcNtcHisVO.setFaxNo(bkgCustAvcNtcFaxSndVO.getFaxNo());
							bkgCustAvcNtcHisVO.setNtcSndId(faxSndId);
							bkgCustAvcNtcHisVO.setNtcSndOfcCd(account.getOfc_cd());
							bkgCustAvcNtcHisVO.setNtcSndUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setNtcSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							bkgCustAvcNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setUpdUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setImptNtcRmk(rmk);
							bkgCustAvcNtcHisVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());
							
							dbDao.addCustAdvisoryNoticeHistory(bkgCustAvcNtcHisVO);
							
							// 메일 송신 건수
							sentInt++;
					  }
							if(rmk == null || "".equals(rmk)){
								throw new EventException(new ErrorHandler("BKG40119").getMessage()); 
							}
						} else {
							throw new EventException(new ErrorHandler("BKG40119").getMessage());
						}
						//}
					//}for
				}
			}
			}
			
			 //2. CN 전송 
			for(int i=0; i<bkgCustAvcNtcSndVOs.length; i++){
				if("1".equals(bkgCustAvcNtcSndVOs[i].getCnFaxEvntFlg())){
						
					groupList = new ArrayList();
					currCnCust = bkgCustAvcNtcSndVOs[i].getCnCustNm(); //현재 화주 이름
					
					for(int k = 0; k < preCnCust.size() ; k++) {
						if(currCnCust.equals(preCnCust.get(k))) {
							cnProcess = false;
							break;
						}
						cnProcess = true;

					}
					
					if(!cnProcess)continue;
					
					groupList.add(bkgCustAvcNtcSndVOs[i].getBlNo());

					for(int j=0; j<bkgCustAvcNtcSndVOs.length; j++){
						
						if(i ==  j) continue;
						nextCnCust = bkgCustAvcNtcSndVOs[j].getCnCustNm();
		
						if(currCnCust.equals(nextCnCust)) {
							groupList.add(bkgCustAvcNtcSndVOs[j].getBlNo());
							
						}
					}
					preCnCust.add(currCnCust);
					custGroupMap.put(currCnCust, groupList);

					//CHK 가 선택되어있을경우만 실행
				if("1".equals(bkgCustAvcNtcSndVOs[i].getFaxChk())){
	
					// 1. Fax 송신 Flag 를 'Y'로 업데이트 한다.
					dbDao.modifyCustAdvisoryNoticeBySend(bkgCustAvcNtcSndVOs[i], account);
					
//					String[] custName = new String[] {bkgCustAvcNtcSndVOs[i].getShCustNm(), bkgCustAvcNtcSndVOs[i].getCnCustNm(), bkgCustAvcNtcSndVOs[i].getNfCustNm(), bkgCustAvcNtcSndVOs[i].getCtrtFaxNm()};
//					String[] arrFaxlNo = new String[] {bkgCustAvcNtcSndVOs[i].getShFaxNo(),bkgCustAvcNtcSndVOs[i].getCnFaxNo(),bkgCustAvcNtcSndVOs[i].getNfFaxNo(), bkgCustAvcNtcSndVOs[i].getCtrtFaxNo()};
//					String[] arrFaxEvntFlg = new String[] {bkgCustAvcNtcSndVOs[i].getShFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getCnFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getNfFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getCtrtFaxEvntFlg()};
					
					String custName = bkgCustAvcNtcSndVOs[i].getCnCustNm();
					String arrFaxlNo = bkgCustAvcNtcSndVOs[i].getCnFaxNo();
					//String arrFaxEvntFlg = bkgCustAvcNtcSndVOs[i].getCnFaxEvntFlg();
					String blNo = bkgCustAvcNtcSndVOs[i].getBlNo();
					
					// VVD별 Html Contents 정보를 가져온다.
//					BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = dbDao.searchCustAdvisoryNoticeSendCtnt(bkgCustAvcNtcSndVOs[i]);
					
					// Remark 를 조회한다.
//					String rmk = bkgCustAvcNtcSndCtntVO.getRmk();
//					if(rmk == null || "".equals(rmk)){
//						throw new EventException(new ErrorHandler("BKG40119").getMessage()); 
//					}
					
					
					
					//custGroupMap.get(currCust)안에 여러 BL이 들어가 있을 수 있으므로 저 사이즈 만큼 for로 루프
					String hash_bl_no = custGroupMap.get(currCnCust).toString();

					hash_bl_no= hash_bl_no.replace("[", "");
					hash_bl_no= hash_bl_no.replace("]", "");
					String[] bl_no = hash_bl_no.split(",");

					BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = null;
					BkgCustAvcNtcSndCtntVO vo = null;
					StringBuffer sb = new StringBuffer();
					
					for(int m=0;m<bl_no.length;m++){
						//for(int m=0;m<bl_no.length;m++){
						//bkgCustAvcNtcSndVOs[i].setBlNo(bl_no[m].trim());// 문제!!
						//}
						//vo = dbDao.searchCustAdvisoryNoticeSendCtnt(bkgCustAvcNtcSndVOs[i]);
						vo = dbDao.searchCustAdvisoryNoticeSendCtntbyDupBlNo(bkgCustAvcNtcSndVOs[i], bl_no[m].trim());
					
					if(vo != null){
						if(!"".equals(vo.getCntrNo())) {
							sb.append(bl_no[m].trim()).append("/").append(vo.getCntrNo());
							if(bl_no.length > 1 && m < bl_no.length -1) {
								sb.trimToSize();
								sb.append("\n");
							}
						}
						
						
						
						if(m == bl_no.length -1) {
							bkgCustAvcNtcSndCtntVO = new BkgCustAvcNtcSndCtntVO();
							bkgCustAvcNtcSndCtntVO.setCntrNo(sb.toString());
							bkgCustAvcNtcSndCtntVO.setRmk(vo.getRmk());
							bkgCustAvcNtcSndCtntVO.setSndDt(vo.getSndDt());
							bkgCustAvcNtcSndCtntVO.setEmlSubjCtnt(vo.getEmlSubjCtnt());
					
							
						}
					  }
					}
					
					// Remark 를 조회한다.
					if(bkgCustAvcNtcSndCtntVO != null ) {
						String rmk = bkgCustAvcNtcSndCtntVO.getRmk();
								
					//for(int j=0; j< arrCustCntcTpCd.length; j++){
	
						// Fax Flag가 '1'인 경우에만 Fax를 전송
						//if(arrFaxEvntFlg[j].equals("1")){
							
							// 2. Fax 전송
							BkgCustAvcNtcFaxSndVO bkgCustAvcNtcFaxSndVO = new BkgCustAvcNtcFaxSndVO();
							bkgCustAvcNtcFaxSndVO.setBlNo(blNo);
							bkgCustAvcNtcFaxSndVO.setBkgNo(bkgCustAvcNtcSndVOs[i].getBkgNo());
							bkgCustAvcNtcFaxSndVO.setCntrNm(custName);
							bkgCustAvcNtcFaxSndVO.setBkgCustTpCd("C");
							bkgCustAvcNtcFaxSndVO.setFaxNo(arrFaxlNo);
							bkgCustAvcNtcFaxSndVO.setVvd(bkgCustAvcNtcSndVOs[i].getVvd());
							bkgCustAvcNtcFaxSndVO.setOfcCd(bkgCustAvcNtcSndVOs[i].getOfcCd());
							bkgCustAvcNtcFaxSndVO.setCntrNo(bkgCustAvcNtcSndCtntVO.getCntrNo());
							
							faxSndId = eaiDao.sendBkgCustAdvisoryNoticeByFax(bkgCustAvcNtcFaxSndVO, account);

						for(int m=0;m<bl_no.length;m++){
							// 2. Fax 전송 후 Advisory Notice 대상 B/L의 연락처 정보를 갱신한다.
							BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO = new BkgCustAvcNtcDtlVO();
							bkgCustAvcNtcDtlVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcDtlVO.setBkgCustTpCd("C");
							bkgCustAvcNtcDtlVO.setCustName(custName);
							bkgCustAvcNtcDtlVO.setFaxNo(arrFaxlNo);
							bkgCustAvcNtcDtlVO.setNtcFaxSndId(faxSndId);
							bkgCustAvcNtcDtlVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());

							dbDao.modifyCustAdvisoryNoticeDetailByFax(bkgCustAvcNtcDtlVO, account);

							// 4. Fax 전송 후 이력정보 Insert
							BkgCustAvcNtcHisVO bkgCustAvcNtcHisVO = new BkgCustAvcNtcHisVO();
							bkgCustAvcNtcHisVO.setVslCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(0, 4));
							bkgCustAvcNtcHisVO.setSkdVoyNo(bkgCustAvcNtcSndVOs[i].getVvd().substring(4, 8));
							bkgCustAvcNtcHisVO.setSkdDirCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(8, 9));
							bkgCustAvcNtcHisVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcHisVO.setNtcViaCd("F");  //F:Fax,M:Email
							bkgCustAvcNtcHisVO.setBkgCustTpCd("C");
							bkgCustAvcNtcHisVO.setPolCd(bkgCustAvcNtcSndVOs[i].getPolCd());
							bkgCustAvcNtcHisVO.setPodCd(bkgCustAvcNtcSndVOs[i].getPodCd());
							bkgCustAvcNtcHisVO.setDelCd(bkgCustAvcNtcSndVOs[i].getDelCd());
							bkgCustAvcNtcHisVO.setFaxNo(bkgCustAvcNtcFaxSndVO.getFaxNo());
							bkgCustAvcNtcHisVO.setNtcSndId(faxSndId);
							bkgCustAvcNtcHisVO.setNtcSndOfcCd(account.getOfc_cd());
							bkgCustAvcNtcHisVO.setNtcSndUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setNtcSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							bkgCustAvcNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setUpdUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setImptNtcRmk(rmk);
							bkgCustAvcNtcHisVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());
							
							dbDao.addCustAdvisoryNoticeHistory(bkgCustAvcNtcHisVO);
							
							// 메일 송신 건수
							sentInt++;
						}
						
							if(rmk == null || "".equals(rmk)){
								throw new EventException(new ErrorHandler("BKG40119").getMessage()); 
							}
						} else {
							throw new EventException(new ErrorHandler("BKG40119").getMessage());
						}
						//}
					//}for
				}
			}
			}
			
			//3. NF 전송 
			for(int i=0; i<bkgCustAvcNtcSndVOs.length; i++){
				if("1".equals(bkgCustAvcNtcSndVOs[i].getNfFaxEvntFlg())){
						
					groupList = new ArrayList();
					currNfCust = bkgCustAvcNtcSndVOs[i].getNfCustNm(); //현재 화주 이름
					
					for(int k = 0; k < preNfCust.size() ; k++) {
						if(currNfCust.equals(preNfCust.get(k))) {
							nfProcess = false;
							break;
						}
						nfProcess = true;

					}
					
					if(!nfProcess)continue;
					
					groupList.add(bkgCustAvcNtcSndVOs[i].getBlNo());

					for(int j=0; j<bkgCustAvcNtcSndVOs.length; j++){
						
						if(i ==  j) continue;
						nextNfCust = bkgCustAvcNtcSndVOs[j].getNfCustNm();
		
						if(currNfCust.equals(nextNfCust)) {
							groupList.add(bkgCustAvcNtcSndVOs[j].getBlNo());
							
						}
					}
					preNfCust.add(currNfCust);
					custGroupMap.put(currNfCust, groupList);

					//CHK 가 선택되어있을경우만 실행
				if("1".equals(bkgCustAvcNtcSndVOs[i].getFaxChk())){
	
					// 1. Fax 송신 Flag 를 'Y'로 업데이트 한다.
					dbDao.modifyCustAdvisoryNoticeBySend(bkgCustAvcNtcSndVOs[i], account);
					
//					String[] custName = new String[] {bkgCustAvcNtcSndVOs[i].getShCustNm(), bkgCustAvcNtcSndVOs[i].getCnCustNm(), bkgCustAvcNtcSndVOs[i].getNfCustNm(), bkgCustAvcNtcSndVOs[i].getCtrtFaxNm()};
//					String[] arrFaxlNo = new String[] {bkgCustAvcNtcSndVOs[i].getShFaxNo(),bkgCustAvcNtcSndVOs[i].getCnFaxNo(),bkgCustAvcNtcSndVOs[i].getNfFaxNo(), bkgCustAvcNtcSndVOs[i].getCtrtFaxNo()};
//					String[] arrFaxEvntFlg = new String[] {bkgCustAvcNtcSndVOs[i].getShFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getCnFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getNfFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getCtrtFaxEvntFlg()};
					
					String custName = bkgCustAvcNtcSndVOs[i].getNfCustNm();
					String arrFaxlNo = bkgCustAvcNtcSndVOs[i].getNfFaxNo();
					//String arrFaxEvntFlg = bkgCustAvcNtcSndVOs[i].getNfFaxEvntFlg();
					String blNo = bkgCustAvcNtcSndVOs[i].getBlNo();
					
					// VVD별 Html Contents 정보를 가져온다.
//					BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = dbDao.searchCustAdvisoryNoticeSendCtnt(bkgCustAvcNtcSndVOs[i]);
					
					// Remark 를 조회한다.
//					String rmk = bkgCustAvcNtcSndCtntVO.getRmk();
//					if(rmk == null || "".equals(rmk)){
//						throw new EventException(new ErrorHandler("BKG40119").getMessage()); 
//					}
					
					
					
					//custGroupMap.get(currCust)안에 여러 BL이 들어가 있을 수 있으므로 저 사이즈 만큼 for로 루프
					String hash_bl_no = custGroupMap.get(currNfCust).toString();

					hash_bl_no= hash_bl_no.replace("[", "");
					hash_bl_no= hash_bl_no.replace("]", "");
					String[] bl_no = hash_bl_no.split(",");

					BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = null;
					BkgCustAvcNtcSndCtntVO vo = null;
					StringBuffer sb = new StringBuffer();
					
					for(int m=0;m<bl_no.length;m++){
						//for(int m=0;m<bl_no.length;m++){
						//bkgCustAvcNtcSndVOs[i].setBlNo(bl_no[m].trim());// 문제!!
						//}
						//vo = dbDao.searchCustAdvisoryNoticeSendCtnt(bkgCustAvcNtcSndVOs[i]);
						vo = dbDao.searchCustAdvisoryNoticeSendCtntbyDupBlNo(bkgCustAvcNtcSndVOs[i], bl_no[m].trim());
					
					if(vo != null){
						if(!"".equals(vo.getCntrNo())) {
							sb.append(bl_no[m].trim()).append("/").append(vo.getCntrNo());
							if(bl_no.length > 1 && m < bl_no.length -1) {
								sb.trimToSize();
								sb.append("\n");
							}
						}
						
						
						
						if(m == bl_no.length -1) {
							bkgCustAvcNtcSndCtntVO = new BkgCustAvcNtcSndCtntVO();
							bkgCustAvcNtcSndCtntVO.setCntrNo(sb.toString());
							bkgCustAvcNtcSndCtntVO.setRmk(vo.getRmk());
							bkgCustAvcNtcSndCtntVO.setSndDt(vo.getSndDt());
							bkgCustAvcNtcSndCtntVO.setEmlSubjCtnt(vo.getEmlSubjCtnt());
					
						    }
						}
					}
					
					// Remark 를 조회한다.
					if(bkgCustAvcNtcSndCtntVO != null ) {
						String rmk = bkgCustAvcNtcSndCtntVO.getRmk();
	
					//for(int j=0; j< arrCustCntcTpCd.length; j++){
	
						// Fax Flag가 '1'인 경우에만 Fax를 전송
						//if(arrFaxEvntFlg[j].equals("1")){
							
							// 2. Fax 전송
							BkgCustAvcNtcFaxSndVO bkgCustAvcNtcFaxSndVO = new BkgCustAvcNtcFaxSndVO();
							bkgCustAvcNtcFaxSndVO.setBlNo(blNo);
							bkgCustAvcNtcFaxSndVO.setBkgNo(bkgCustAvcNtcSndVOs[i].getBkgNo());
							bkgCustAvcNtcFaxSndVO.setCntrNm(custName);
							bkgCustAvcNtcFaxSndVO.setBkgCustTpCd("N");
							bkgCustAvcNtcFaxSndVO.setFaxNo(arrFaxlNo);
							bkgCustAvcNtcFaxSndVO.setVvd(bkgCustAvcNtcSndVOs[i].getVvd());
							bkgCustAvcNtcFaxSndVO.setOfcCd(bkgCustAvcNtcSndVOs[i].getOfcCd());
							bkgCustAvcNtcFaxSndVO.setCntrNo(bkgCustAvcNtcSndCtntVO.getCntrNo());
							
							faxSndId = eaiDao.sendBkgCustAdvisoryNoticeByFax(bkgCustAvcNtcFaxSndVO, account);

						for(int m=0;m<bl_no.length;m++){
							// 2. Fax 전송 후 Advisory Notice 대상 B/L의 연락처 정보를 갱신한다.
							BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO = new BkgCustAvcNtcDtlVO();
							bkgCustAvcNtcDtlVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcDtlVO.setBkgCustTpCd("N");
							bkgCustAvcNtcDtlVO.setCustName(custName);
							bkgCustAvcNtcDtlVO.setFaxNo(arrFaxlNo);
							bkgCustAvcNtcDtlVO.setNtcFaxSndId(faxSndId);
							bkgCustAvcNtcDtlVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());

							dbDao.modifyCustAdvisoryNoticeDetailByFax(bkgCustAvcNtcDtlVO, account);

							// 4. Fax 전송 후 이력정보 Insert
							BkgCustAvcNtcHisVO bkgCustAvcNtcHisVO = new BkgCustAvcNtcHisVO();
							bkgCustAvcNtcHisVO.setVslCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(0, 4));
							bkgCustAvcNtcHisVO.setSkdVoyNo(bkgCustAvcNtcSndVOs[i].getVvd().substring(4, 8));
							bkgCustAvcNtcHisVO.setSkdDirCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(8, 9));
							bkgCustAvcNtcHisVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcHisVO.setNtcViaCd("F");  //F:Fax,M:Email
							bkgCustAvcNtcHisVO.setBkgCustTpCd("N");
							bkgCustAvcNtcHisVO.setPolCd(bkgCustAvcNtcSndVOs[i].getPolCd());
							bkgCustAvcNtcHisVO.setPodCd(bkgCustAvcNtcSndVOs[i].getPodCd());
							bkgCustAvcNtcHisVO.setDelCd(bkgCustAvcNtcSndVOs[i].getDelCd());
							bkgCustAvcNtcHisVO.setFaxNo(bkgCustAvcNtcFaxSndVO.getFaxNo());
							bkgCustAvcNtcHisVO.setNtcSndId(faxSndId);
							bkgCustAvcNtcHisVO.setNtcSndOfcCd(account.getOfc_cd());
							bkgCustAvcNtcHisVO.setNtcSndUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setNtcSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							bkgCustAvcNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setUpdUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setImptNtcRmk(rmk);
							bkgCustAvcNtcHisVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());
							
							dbDao.addCustAdvisoryNoticeHistory(bkgCustAvcNtcHisVO);
							
							// 메일 송신 건수
							sentInt++;
							
						}
							if(rmk == null || "".equals(rmk)){
								throw new EventException(new ErrorHandler("BKG40119").getMessage()); 
							}
						} else {
							throw new EventException(new ErrorHandler("BKG40119").getMessage());
						}
						//}
					//}for
				}
			}
			}
			
			//4. CT 전송 
			for(int i=0; i<bkgCustAvcNtcSndVOs.length; i++){
				if("1".equals(bkgCustAvcNtcSndVOs[i].getCtrtFaxEvntFlg())){
						
					groupList = new ArrayList();
					currCtCust = bkgCustAvcNtcSndVOs[i].getCtrtFaxNm(); //현재 화주 이름
					
					for(int k = 0; k < preCtCust.size() ; k++) {
						if(currCtCust.equals(preCtCust.get(k))) {
							ctProcess = false;
							break;
						}
						ctProcess = true;

					}
					
					if(!ctProcess)continue;
					
					groupList.add(bkgCustAvcNtcSndVOs[i].getBlNo());

					for(int j=0; j<bkgCustAvcNtcSndVOs.length; j++){
						
						if(i ==  j) continue;
						nextCtCust = bkgCustAvcNtcSndVOs[j].getCtrtFaxNm();
		
						if(currCtCust.equals(nextCtCust)) {
							groupList.add(bkgCustAvcNtcSndVOs[j].getBlNo());
							
						}
					}
					preCtCust.add(currCtCust);
					custGroupMap.put(currCtCust, groupList);

					//CHK 가 선택되어있을경우만 실행
				if("1".equals(bkgCustAvcNtcSndVOs[i].getFaxChk())){
	
					// 1. Fax 송신 Flag 를 'Y'로 업데이트 한다.
					dbDao.modifyCustAdvisoryNoticeBySend(bkgCustAvcNtcSndVOs[i], account);
					
//					String[] custName = new String[] {bkgCustAvcNtcSndVOs[i].getShCustNm(), bkgCustAvcNtcSndVOs[i].getCnCustNm(), bkgCustAvcNtcSndVOs[i].getNfCustNm(), bkgCustAvcNtcSndVOs[i].getCtrtFaxNm()};
//					String[] arrFaxlNo = new String[] {bkgCustAvcNtcSndVOs[i].getShFaxNo(),bkgCustAvcNtcSndVOs[i].getCnFaxNo(),bkgCustAvcNtcSndVOs[i].getNfFaxNo(), bkgCustAvcNtcSndVOs[i].getCtrtFaxNo()};
//					String[] arrFaxEvntFlg = new String[] {bkgCustAvcNtcSndVOs[i].getShFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getCnFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getNfFaxEvntFlg(), bkgCustAvcNtcSndVOs[i].getCtrtFaxEvntFlg()};
					
					String custName = bkgCustAvcNtcSndVOs[i].getCtrtFaxNm();
					String arrFaxlNo = bkgCustAvcNtcSndVOs[i].getCtrtFaxNo();
					//String arrFaxEvntFlg = bkgCustAvcNtcSndVOs[i].getCtrtFaxEvntFlg();
					String blNo = bkgCustAvcNtcSndVOs[i].getBlNo();
					
					// VVD별 Html Contents 정보를 가져온다.
//					BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = dbDao.searchCustAdvisoryNoticeSendCtnt(bkgCustAvcNtcSndVOs[i]);
					
					// Remark 를 조회한다.
//					String rmk = bkgCustAvcNtcSndCtntVO.getRmk();
//					if(rmk == null || "".equals(rmk)){
//						throw new EventException(new ErrorHandler("BKG40119").getMessage()); 
//					}
					
					
					
					//custGroupMap.get(currCust)안에 여러 BL이 들어가 있을 수 있으므로 저 사이즈 만큼 for로 루프
					String hash_bl_no = custGroupMap.get(currCtCust).toString();

					hash_bl_no= hash_bl_no.replace("[", "");
					hash_bl_no= hash_bl_no.replace("]", "");
					String[] bl_no = hash_bl_no.split(",");

					BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = null;
					BkgCustAvcNtcSndCtntVO vo = null;
					StringBuffer sb = new StringBuffer();
					
					for(int m=0;m<bl_no.length;m++){
						//for(int m=0;m<bl_no.length;m++){
						//bkgCustAvcNtcSndVOs[i].setBlNo(bl_no[m].trim());// 문제!!
						//}
						//vo = dbDao.searchCustAdvisoryNoticeSendCtnt(bkgCustAvcNtcSndVOs[i]);
						vo = dbDao.searchCustAdvisoryNoticeSendCtntbyDupBlNo(bkgCustAvcNtcSndVOs[i], bl_no[m].trim());
						
					if(vo != null){
						if(!"".equals(vo.getCntrNo())) {
							sb.append(bl_no[m].trim()).append("/").append(vo.getCntrNo());
							if(bl_no.length > 1 && m < bl_no.length -1) {
								sb.trimToSize();
								sb.append("\n");
							}
						}
						
						
						
						if(m == bl_no.length -1) {
							bkgCustAvcNtcSndCtntVO = new BkgCustAvcNtcSndCtntVO();
							bkgCustAvcNtcSndCtntVO.setCntrNo(sb.toString());
							bkgCustAvcNtcSndCtntVO.setRmk(vo.getRmk());
							bkgCustAvcNtcSndCtntVO.setSndDt(vo.getSndDt());
							bkgCustAvcNtcSndCtntVO.setEmlSubjCtnt(vo.getEmlSubjCtnt());
					
						    }
						}
					}
					
					// Remark 를 조회한다.
					if(bkgCustAvcNtcSndCtntVO != null ) {
						String rmk = bkgCustAvcNtcSndCtntVO.getRmk();
						
					//for(int j=0; j< arrCustCntcTpCd.length; j++){
	
						// Fax Flag가 '1'인 경우에만 Fax를 전송
						//if(arrFaxEvntFlg[j].equals("1")){
							
							// 2. Fax 전송
							BkgCustAvcNtcFaxSndVO bkgCustAvcNtcFaxSndVO = new BkgCustAvcNtcFaxSndVO();
							bkgCustAvcNtcFaxSndVO.setBlNo(blNo);
							bkgCustAvcNtcFaxSndVO.setBkgNo(bkgCustAvcNtcSndVOs[i].getBkgNo());
							bkgCustAvcNtcFaxSndVO.setCntrNm(custName);
							bkgCustAvcNtcFaxSndVO.setBkgCustTpCd("T");
							bkgCustAvcNtcFaxSndVO.setFaxNo(arrFaxlNo);
							bkgCustAvcNtcFaxSndVO.setVvd(bkgCustAvcNtcSndVOs[i].getVvd());
							bkgCustAvcNtcFaxSndVO.setOfcCd(bkgCustAvcNtcSndVOs[i].getOfcCd());
							bkgCustAvcNtcFaxSndVO.setCntrNo(bkgCustAvcNtcSndCtntVO.getCntrNo());
							
							faxSndId = eaiDao.sendBkgCustAdvisoryNoticeByFax(bkgCustAvcNtcFaxSndVO, account);
							
						for(int m=0;m<bl_no.length;m++){
							// 2. Fax 전송 후 Advisory Notice 대상 B/L의 연락처 정보를 갱신한다.
							BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO = new BkgCustAvcNtcDtlVO();
							bkgCustAvcNtcDtlVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcDtlVO.setBkgCustTpCd("T");
							bkgCustAvcNtcDtlVO.setCustName(custName);
							bkgCustAvcNtcDtlVO.setFaxNo(arrFaxlNo);
							bkgCustAvcNtcDtlVO.setNtcFaxSndId(faxSndId);
							bkgCustAvcNtcDtlVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());

							dbDao.modifyCustAdvisoryNoticeDetailByFax(bkgCustAvcNtcDtlVO, account);

							// 4. Fax 전송 후 이력정보 Insert
							BkgCustAvcNtcHisVO bkgCustAvcNtcHisVO = new BkgCustAvcNtcHisVO();
							bkgCustAvcNtcHisVO.setVslCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(0, 4));
							bkgCustAvcNtcHisVO.setSkdVoyNo(bkgCustAvcNtcSndVOs[i].getVvd().substring(4, 8));
							bkgCustAvcNtcHisVO.setSkdDirCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(8, 9));
							bkgCustAvcNtcHisVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcHisVO.setNtcViaCd("F");  //F:Fax,M:Email
							bkgCustAvcNtcHisVO.setBkgCustTpCd("T");
							bkgCustAvcNtcHisVO.setPolCd(bkgCustAvcNtcSndVOs[i].getPolCd());
							bkgCustAvcNtcHisVO.setPodCd(bkgCustAvcNtcSndVOs[i].getPodCd());
							bkgCustAvcNtcHisVO.setDelCd(bkgCustAvcNtcSndVOs[i].getDelCd());
							bkgCustAvcNtcHisVO.setFaxNo(bkgCustAvcNtcFaxSndVO.getFaxNo());
							bkgCustAvcNtcHisVO.setNtcSndId(faxSndId);
							bkgCustAvcNtcHisVO.setNtcSndOfcCd(account.getOfc_cd());
							bkgCustAvcNtcHisVO.setNtcSndUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setNtcSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							bkgCustAvcNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setUpdUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setImptNtcRmk(rmk);
							bkgCustAvcNtcHisVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());
							
							dbDao.addCustAdvisoryNoticeHistory(bkgCustAvcNtcHisVO);
							
							// 메일 송신 건수
							sentInt++;
						}
							if(rmk == null || "".equals(rmk)){
								throw new EventException(new ErrorHandler("BKG40119").getMessage()); 
							}
						} else {
							throw new EventException(new ErrorHandler("BKG40119").getMessage());
						}
						//}
					//}for
				}
			}
			}
			
			return sentInt;
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
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
	public int sendCustAdvisoryNoticeListByMail(BkgCustAvcNtcSndVO[] bkgCustAvcNtcSndVOs, String urlPath, SignOnUserAccount account) throws EventException {
		FileUploadBC fileUtil = new FileUploadBCImpl();
		try{
			//String[] arrCustCntcTpCd = new String[] { "S", "C", "N", "T"};
			String eMailSndId = "";
			int sentInt = 0;
			
			// 화주별 list  저장소
			/* 화주별 중복되는 BL 묶어서 전송 
			 * */
			 
			ArrayList groupList = null;
			HashMap custGroupMap = new HashMap();
//			ArrayList preCust = new ArrayList();
//			String nextCust = "";
			//String currCust = "";
//			boolean process = true;
			
			ArrayList preShCust = new ArrayList();
			ArrayList preCnCust = new ArrayList();
			ArrayList preNfCust = new ArrayList();
			ArrayList preCtCust = new ArrayList();
			String nextShCust = "";
			String nextCnCust = "";
			String nextNfCust = "";
			String nextCtCust = "";
			String currShCust = "";
			String currCnCust = "";
			String currNfCust = "";
			String currCtCust = "";
				
			
			boolean shProcess = true;
			boolean cnProcess = true;
			boolean nfProcess = true;
			boolean ctProcess = true;

			
		   //4개의 customer 별로 for문을 돌아서 메일을 보내려는 각 customer의 중복성을 막는 CSR 진행
		   //Customer name이 같으면 묶어서 한번에 보냄 (같은 Cusomer 이면 BL_NO, CNTR_NO 합쳐서 한 메일에 보냄)
           //1. SH 전송 
			for (int i = 0; i < bkgCustAvcNtcSndVOs.length; i++) {
				if ("1".equals(bkgCustAvcNtcSndVOs[i].getShEmailEvntFlg())) {

					groupList = new ArrayList();
					currShCust = bkgCustAvcNtcSndVOs[i].getShCustNm(); // 현재 화주
																		// 이름

					for (int k = 0; k < preShCust.size(); k++) {
						if (currShCust.equals(preShCust.get(k))) {
							shProcess = false;
							break;
						}
						shProcess = true;

					}

					if (!shProcess)
						continue;

					groupList.add(bkgCustAvcNtcSndVOs[i].getBlNo());

					for (int j = 0; j < bkgCustAvcNtcSndVOs.length; j++) {

						if (i == j)
							continue;
						nextShCust = bkgCustAvcNtcSndVOs[j].getShCustNm();

						if (currShCust.equals(nextShCust)) {
							groupList.add(bkgCustAvcNtcSndVOs[j].getBlNo());

						}
					}
					preShCust.add(currShCust);
					custGroupMap.put(currShCust, groupList);

					// CHK 가 선택되어있을경우만 실행
					if ("1".equals(bkgCustAvcNtcSndVOs[i].getEmlChk())) {
						// 1. Mail 송신 Flag 를 'Y'로 업데이트 한다.
						dbDao.modifyCustAdvisoryNoticeBySend( bkgCustAvcNtcSndVOs[i], account);
						String custName = bkgCustAvcNtcSndVOs[i].getShCustNm();
						String arrMailNo = bkgCustAvcNtcSndVOs[i].getShEml();
						String blNo = bkgCustAvcNtcSndVOs[i].getBlNo();
						// VVD별 Html Contents 정보를 가져온다.
						// custGroupMap.get(currCust)안에 여러 BL이 들어가 있을 수 있으므로 저
						// 사이즈 만큼 for로 루프
						String hash_bl_no = custGroupMap.get(currShCust).toString();

						hash_bl_no = hash_bl_no.replace("[", "");
						hash_bl_no = hash_bl_no.replace("]", "");
						String[] bl_no = hash_bl_no.split(",");

						BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = null;
						BkgCustAvcNtcSndCtntVO vo = null;
						StringBuffer sb = new StringBuffer();

						for (int m = 0; m < bl_no.length; m++) {
							vo = dbDao.searchCustAdvisoryNoticeSendCtntbyDupBlNo(bkgCustAvcNtcSndVOs[i], bl_no[m].trim());

							if (vo != null) {
								if (!"".equals(vo.getCntrNo())) {
									sb.append(bl_no[m].trim()).append("/").append(vo.getCntrNo());
									if (bl_no.length > 1 && m < bl_no.length - 1) {
										sb.trimToSize();
										sb.append("\n");
									}
								}

								if (m == bl_no.length - 1) {
									bkgCustAvcNtcSndCtntVO = new BkgCustAvcNtcSndCtntVO();
									bkgCustAvcNtcSndCtntVO.setCntrNo(sb.toString());
									bkgCustAvcNtcSndCtntVO.setRmk(vo.getRmk());
									bkgCustAvcNtcSndCtntVO.setSndDt(vo.getSndDt());
									bkgCustAvcNtcSndCtntVO.setEmlSubjCtnt(vo.getEmlSubjCtnt());
									bkgCustAvcNtcSndCtntVO.setFileDesc(vo.getFileDesc());
								}

							}
						}

						// Remark 를 조회한다.
						if (bkgCustAvcNtcSndCtntVO != null) {
							String rmk = bkgCustAvcNtcSndCtntVO.getRmk();
							if (rmk == null || "".equals(rmk)) {
								throw new EventException(new ErrorHandler("BKG40119").getMessage());
							}
						} else {
							throw new EventException(new ErrorHandler("BKG40119").getMessage());
						}

						// 2. 메일 전송
						BkgCustAvcNtcMailSndVO bkgCustAvcNtcMailSndVO = new BkgCustAvcNtcMailSndVO();

						bkgCustAvcNtcMailSndVO.setBlNo(blNo);
						bkgCustAvcNtcMailSndVO.setRcvrNm(custName);
						bkgCustAvcNtcMailSndVO.setRcvrEml(arrMailNo);
						bkgCustAvcNtcMailSndVO.setEmlTitNm(bkgCustAvcNtcSndCtntVO.getEmlSubjCtnt());
						bkgCustAvcNtcMailSndVO.setSndDt(bkgCustAvcNtcSndCtntVO.getSndDt());
						bkgCustAvcNtcMailSndVO.setCntrNo(bkgCustAvcNtcSndCtntVO.getCntrNo());
						bkgCustAvcNtcMailSndVO.setRmk(bkgCustAvcNtcSndCtntVO.getRmk());
						bkgCustAvcNtcMailSndVO.setCntrNoViewFlg(bkgCustAvcNtcSndCtntVO.getFileDesc());

						StringBuffer file = new StringBuffer();
						if (bkgCustAvcNtcSndVOs[i].getFileKey() != null) {
							String fileKeys = bkgCustAvcNtcSndVOs[i].getFileKey();
							/** 여러건 */
							if (fileKeys.indexOf(";") > -1) {
								String[] keyTemp = fileKeys.split(";");
								for (int j = 0; j < keyTemp.length; j++) {
									file.append(fileUtil.copyUploadFile(keyTemp[j])).append(";");
								}
							} else {
								file.append(fileUtil.copyUploadFile(fileKeys)).append(";");
							}
						}
						log.debug("\n sendCustAdvisoryNoticeListByMail file Key : " + file.toString());
						bkgCustAvcNtcMailSndVO.setFileKey(file.toString());
						eMailSndId = eaiDao.sendBkgCustAdvisoryNoticeByEmail(bkgCustAvcNtcMailSndVO, urlPath, account);

						for (int m = 0; m < bl_no.length; m++) {
							// 3. 메일 전송 후 Advisory Notice 대상 B/L의 연락처 정보를 갱신한다.
							BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO = new BkgCustAvcNtcDtlVO();
							bkgCustAvcNtcDtlVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcDtlVO.setBkgCustTpCd("S");
							bkgCustAvcNtcDtlVO.setCustName(custName);
							bkgCustAvcNtcDtlVO.setNtcEml(arrMailNo);
							bkgCustAvcNtcDtlVO.setNtcEmlSndId(eMailSndId);
							bkgCustAvcNtcDtlVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());

							dbDao.modifyCustAdvisoryNoticeDetailByMail(bkgCustAvcNtcDtlVO, account);

							// 4. 메일 전송 후 이력정보 Insert
							BkgCustAvcNtcHisVO bkgCustAvcNtcHisVO = new BkgCustAvcNtcHisVO();
							bkgCustAvcNtcHisVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcHisVO.setVslCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(0, 4));
							bkgCustAvcNtcHisVO.setSkdVoyNo(bkgCustAvcNtcSndVOs[i].getVvd().substring(4, 8));
							bkgCustAvcNtcHisVO.setSkdDirCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(8, 9));
							bkgCustAvcNtcHisVO.setNtcViaCd("E"); // F:Fax,M:Email
							bkgCustAvcNtcHisVO.setBkgCustTpCd("S");
							bkgCustAvcNtcHisVO.setPolCd(bkgCustAvcNtcSndVOs[i].getPolCd());
							bkgCustAvcNtcHisVO.setPodCd(bkgCustAvcNtcSndVOs[i].getPodCd());
							bkgCustAvcNtcHisVO.setDelCd(bkgCustAvcNtcSndVOs[i].getDelCd());
							bkgCustAvcNtcHisVO.setNtcEml(bkgCustAvcNtcMailSndVO.getRcvrEml());
							bkgCustAvcNtcHisVO.setNtcSndId(eMailSndId);
							bkgCustAvcNtcHisVO.setNtcSndOfcCd(account.getOfc_cd());
							bkgCustAvcNtcHisVO.setNtcSndUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setNtcSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							bkgCustAvcNtcHisVO.setImptNtcRmk(bkgCustAvcNtcMailSndVO.getRmk());
							bkgCustAvcNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setUpdUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());

							dbDao.addCustAdvisoryNoticeHistory(bkgCustAvcNtcHisVO);

							// 메일 송신 건수
							sentInt++;
						}
					}
				}// if SH
				
			}//main for
			
		   //2. CN 전송 
			for(int i=0; i<bkgCustAvcNtcSndVOs.length; i++){
				if("1".equals(bkgCustAvcNtcSndVOs[i].getCnEmailEvntFlg())){
					groupList = new ArrayList();
					currCnCust = bkgCustAvcNtcSndVOs[i].getCnCustNm(); //현재 화주 이름
					for(int k = 0; k < preCnCust.size() ; k++) {
						if(currCnCust.equals(preCnCust.get(k))) {
							cnProcess = false;
							break;
						}
						cnProcess = true;

					}
					
					if(!cnProcess) continue;
					
					groupList.add(bkgCustAvcNtcSndVOs[i].getBlNo());

					for(int j=0; j<bkgCustAvcNtcSndVOs.length; j++){
						
						if(i ==  j) continue;
						nextCnCust = bkgCustAvcNtcSndVOs[j].getCnCustNm();
		
						if(currCnCust.equals(nextCnCust)) {
							groupList.add(bkgCustAvcNtcSndVOs[j].getBlNo());
							
						}
					}
					preCnCust.add(currCnCust);
					custGroupMap.put(currCnCust, groupList);
				
					
					//CHK 가 선택되어있을경우만 실행
					if("1".equals(bkgCustAvcNtcSndVOs[i].getEmlChk())){
						
						// 1. Mail 송신 Flag 를 'Y'로 업데이트 한다.
						dbDao.modifyCustAdvisoryNoticeBySend(bkgCustAvcNtcSndVOs[i], account);
						
						String custName = bkgCustAvcNtcSndVOs[i].getCnCustNm();
						String arrMailNo = bkgCustAvcNtcSndVOs[i].getCnEml();
						// VVD별 Html Contents 정보를 가져온다.
						//custGroupMap.get(currCust)안에 여러 BL이 들어가 있을 수 있으므로 저 사이즈 만큼 for로 루프
						String hash_bl_no = custGroupMap.get(currCnCust).toString();

						hash_bl_no= hash_bl_no.replace("[", "");
						hash_bl_no= hash_bl_no.replace("]", "");
						String[] bl_no = hash_bl_no.split(",");

						BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = null;
						BkgCustAvcNtcSndCtntVO vo = null;
						StringBuffer sb = new StringBuffer();
						
						for(int m=0;m<bl_no.length;m++){
	
							vo = dbDao.searchCustAdvisoryNoticeSendCtntbyDupBlNo(bkgCustAvcNtcSndVOs[i], bl_no[m].trim());
							
							if(vo != null){
								if(!"".equals(vo.getCntrNo())) {
									sb.append(bl_no[m].trim()).append("/").append(vo.getCntrNo());
									if(bl_no.length > 1 && m < bl_no.length -1) {
										sb.trimToSize();
										sb.append("\n");
									}
								}
								
								
								
								if(m == bl_no.length -1) {
									bkgCustAvcNtcSndCtntVO = new BkgCustAvcNtcSndCtntVO();
									bkgCustAvcNtcSndCtntVO.setCntrNo(sb.toString());
									bkgCustAvcNtcSndCtntVO.setRmk(vo.getRmk());
									bkgCustAvcNtcSndCtntVO.setSndDt(vo.getSndDt());
									bkgCustAvcNtcSndCtntVO.setEmlSubjCtnt(vo.getEmlSubjCtnt());
									bkgCustAvcNtcSndCtntVO.setFileDesc(vo.getFileDesc());
								}
							}
						}
						
						// Remark 를 조회한다.
						if(bkgCustAvcNtcSndCtntVO != null ) {
							String rmk = bkgCustAvcNtcSndCtntVO.getRmk();
							if(rmk == null || "".equals(rmk)){
								throw new EventException(new ErrorHandler("BKG40119").getMessage()); 
							}
						} else {
							throw new EventException(new ErrorHandler("BKG40119").getMessage());
						}
						
						// 2. 메일 전송
						BkgCustAvcNtcMailSndVO bkgCustAvcNtcMailSndVO = new BkgCustAvcNtcMailSndVO();
						
						bkgCustAvcNtcMailSndVO.setBlNo(bkgCustAvcNtcSndVOs[i].getBlNo());
						bkgCustAvcNtcMailSndVO.setRcvrNm(custName);
						bkgCustAvcNtcMailSndVO.setRcvrEml(arrMailNo);
						bkgCustAvcNtcMailSndVO.setEmlTitNm(bkgCustAvcNtcSndCtntVO.getEmlSubjCtnt());
						bkgCustAvcNtcMailSndVO.setSndDt(bkgCustAvcNtcSndCtntVO.getSndDt());
						bkgCustAvcNtcMailSndVO.setCntrNo(bkgCustAvcNtcSndCtntVO.getCntrNo());
						bkgCustAvcNtcMailSndVO.setRmk(bkgCustAvcNtcSndCtntVO.getRmk());
						bkgCustAvcNtcMailSndVO.setCntrNoViewFlg(bkgCustAvcNtcSndCtntVO.getFileDesc());
						StringBuffer file = new StringBuffer();
						if (bkgCustAvcNtcSndVOs[i].getFileKey() != null) {
							String fileKeys = bkgCustAvcNtcSndVOs[i].getFileKey();
							/** 여러건 */
							if (fileKeys.indexOf(";") > -1) {
								String[] keyTemp = fileKeys.split(";");
								for (int j = 0; j < keyTemp.length; j++) {
									file.append(fileUtil.copyUploadFile(keyTemp[j])).append(";");
								}
							} else {
								file.append(fileUtil.copyUploadFile(fileKeys)).append(";");
							}
						}
						log.debug("\n sendCustAdvisoryNoticeListByMail file Key : " + file.toString());
						bkgCustAvcNtcMailSndVO.setFileKey(file.toString());
						
						eMailSndId = eaiDao.sendBkgCustAdvisoryNoticeByEmail(bkgCustAvcNtcMailSndVO, urlPath, account);
								
						for(int m=0;m<bl_no.length;m++){
							// 3. 메일 전송 후 Advisory Notice 대상 B/L의 연락처 정보를 갱신한다.
							BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO = new BkgCustAvcNtcDtlVO();
							bkgCustAvcNtcDtlVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcDtlVO.setBkgCustTpCd("C");
							bkgCustAvcNtcDtlVO.setCustName(custName);
							bkgCustAvcNtcDtlVO.setNtcEml(arrMailNo);
							bkgCustAvcNtcDtlVO.setNtcEmlSndId(eMailSndId);
							bkgCustAvcNtcDtlVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());

							dbDao.modifyCustAdvisoryNoticeDetailByMail(bkgCustAvcNtcDtlVO, account);
							
							// 4. 메일 전송 후 이력정보 Insert
							BkgCustAvcNtcHisVO bkgCustAvcNtcHisVO = new BkgCustAvcNtcHisVO();
							bkgCustAvcNtcHisVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcHisVO.setVslCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(0, 4));
							bkgCustAvcNtcHisVO.setSkdVoyNo(bkgCustAvcNtcSndVOs[i].getVvd().substring(4, 8));
							bkgCustAvcNtcHisVO.setSkdDirCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(8, 9));
							bkgCustAvcNtcHisVO.setNtcViaCd("E");  //F:Fax,M:Email
							bkgCustAvcNtcHisVO.setBkgCustTpCd("C");
							bkgCustAvcNtcHisVO.setPolCd(bkgCustAvcNtcSndVOs[i].getPolCd());
							bkgCustAvcNtcHisVO.setPodCd(bkgCustAvcNtcSndVOs[i].getPodCd());
							bkgCustAvcNtcHisVO.setDelCd(bkgCustAvcNtcSndVOs[i].getDelCd());
							bkgCustAvcNtcHisVO.setNtcEml(bkgCustAvcNtcMailSndVO.getRcvrEml());
							bkgCustAvcNtcHisVO.setNtcSndId(eMailSndId);
							bkgCustAvcNtcHisVO.setNtcSndOfcCd(account.getOfc_cd());
							bkgCustAvcNtcHisVO.setNtcSndUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setNtcSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							bkgCustAvcNtcHisVO.setImptNtcRmk(bkgCustAvcNtcMailSndVO.getRmk());
							bkgCustAvcNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setUpdUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());
							
							dbDao.addCustAdvisoryNoticeHistory(bkgCustAvcNtcHisVO);
							
							// 메일 송신 건수
							sentInt++;
						}
					}
				}
			}
			
			
			//3. NF 전송 
			for(int i=0; i<bkgCustAvcNtcSndVOs.length; i++){
				if("1".equals(bkgCustAvcNtcSndVOs[i].getNfEmailEvntFlg())){
					
					groupList = new ArrayList();
					currNfCust = bkgCustAvcNtcSndVOs[i].getNfCustNm(); //현재 화주 이름
					for(int k = 0; k < preNfCust.size() ; k++) {
						if(currNfCust.equals(preNfCust.get(k))) {
							nfProcess = false;
							break;
						}
						nfProcess = true;

					}
					
					if(!nfProcess) continue;
					
					groupList.add(bkgCustAvcNtcSndVOs[i].getBlNo());

					for(int j=0; j<bkgCustAvcNtcSndVOs.length; j++){
						
						if(i ==  j) continue;
						nextNfCust = bkgCustAvcNtcSndVOs[j].getNfCustNm();
		
						if(currNfCust.equals(nextNfCust)) {
							groupList.add(bkgCustAvcNtcSndVOs[j].getBlNo());
							
						}
					}
					preNfCust.add(currNfCust);
					custGroupMap.put(currNfCust, groupList);
				
					
					//CHK 가 선택되어있을경우만 실행
					if("1".equals(bkgCustAvcNtcSndVOs[i].getEmlChk())){
						// 1. Mail 송신 Flag 를 'Y'로 업데이트 한다.
						dbDao.modifyCustAdvisoryNoticeBySend(bkgCustAvcNtcSndVOs[i], account);
						
						String custName = bkgCustAvcNtcSndVOs[i].getNfCustNm();
						String arrMailNo = bkgCustAvcNtcSndVOs[i].getNfEml();
						// VVD별 Html Contents 정보를 가져온다.
						//custGroupMap.get(currCust)안에 여러 BL이 들어가 있을 수 있으므로 저 사이즈 만큼 for로 루프
						String hash_bl_no = custGroupMap.get(currNfCust).toString();

						hash_bl_no= hash_bl_no.replace("[", "");
						hash_bl_no= hash_bl_no.replace("]", "");
						String[] bl_no = hash_bl_no.split(",");

						BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = null;
						BkgCustAvcNtcSndCtntVO vo = null;
						StringBuffer sb = new StringBuffer();
						
						for(int m=0;m<bl_no.length;m++){
							vo = dbDao.searchCustAdvisoryNoticeSendCtntbyDupBlNo(bkgCustAvcNtcSndVOs[i], bl_no[m].trim());
							if(vo != null){
								if(!"".equals(vo.getCntrNo())) {
									sb.append(bl_no[m].trim()).append("/").append(vo.getCntrNo());
									if(bl_no.length > 1 && m < bl_no.length -1) {
										sb.trimToSize();
										sb.append("\n");
									}
								}
								if(m == bl_no.length -1) {
									bkgCustAvcNtcSndCtntVO = new BkgCustAvcNtcSndCtntVO();
									bkgCustAvcNtcSndCtntVO.setCntrNo(sb.toString());
									bkgCustAvcNtcSndCtntVO.setRmk(vo.getRmk());
									bkgCustAvcNtcSndCtntVO.setSndDt(vo.getSndDt());
									bkgCustAvcNtcSndCtntVO.setEmlSubjCtnt(vo.getEmlSubjCtnt());
									bkgCustAvcNtcSndCtntVO.setFileDesc(vo.getFileDesc());
								}
							}
						}
						
						// Remark 를 조회한다.
						if(bkgCustAvcNtcSndCtntVO != null ) {
							String rmk = bkgCustAvcNtcSndCtntVO.getRmk();
							if(rmk == null || "".equals(rmk)){
								throw new EventException(new ErrorHandler("BKG40119").getMessage()); 
							}
						} else {
							throw new EventException(new ErrorHandler("BKG40119").getMessage());
						}
		
						// 2. 메일 전송
						BkgCustAvcNtcMailSndVO bkgCustAvcNtcMailSndVO = new BkgCustAvcNtcMailSndVO();
						
						bkgCustAvcNtcMailSndVO.setBlNo(bkgCustAvcNtcSndVOs[i].getBlNo());
						bkgCustAvcNtcMailSndVO.setRcvrNm(custName);
						bkgCustAvcNtcMailSndVO.setRcvrEml(arrMailNo);
						bkgCustAvcNtcMailSndVO.setEmlTitNm(bkgCustAvcNtcSndCtntVO.getEmlSubjCtnt());
						bkgCustAvcNtcMailSndVO.setSndDt(bkgCustAvcNtcSndCtntVO.getSndDt());
						bkgCustAvcNtcMailSndVO.setCntrNo(bkgCustAvcNtcSndCtntVO.getCntrNo());
						bkgCustAvcNtcMailSndVO.setRmk(bkgCustAvcNtcSndCtntVO.getRmk());
						bkgCustAvcNtcMailSndVO.setCntrNoViewFlg(bkgCustAvcNtcSndCtntVO.getFileDesc());
						StringBuffer file = new StringBuffer();
						if (bkgCustAvcNtcSndVOs[i].getFileKey() != null) {
							String fileKeys = bkgCustAvcNtcSndVOs[i].getFileKey();
							/** 여러건 */
							if (fileKeys.indexOf(";") > -1) {
								String[] keyTemp = fileKeys.split(";");
								for (int j = 0; j < keyTemp.length; j++) {
									file.append(fileUtil.copyUploadFile(keyTemp[j])).append(";");
								}
							} else {
								file.append(fileUtil.copyUploadFile(fileKeys)).append(";");
							}
						}
						log.debug("\n sendCustAdvisoryNoticeListByMail file Key : " + file.toString());
						bkgCustAvcNtcMailSndVO.setFileKey(file.toString());
						
						eMailSndId = eaiDao.sendBkgCustAdvisoryNoticeByEmail(bkgCustAvcNtcMailSndVO, urlPath, account);
								
						for(int m=0;m<bl_no.length;m++){
							// 3. 메일 전송 후 Advisory Notice 대상 B/L의 연락처 정보를 갱신한다.
							BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO = new BkgCustAvcNtcDtlVO();
							bkgCustAvcNtcDtlVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcDtlVO.setBkgCustTpCd("N");
							bkgCustAvcNtcDtlVO.setCustName(custName);
							bkgCustAvcNtcDtlVO.setNtcEml(arrMailNo);
							bkgCustAvcNtcDtlVO.setNtcEmlSndId(eMailSndId);
							bkgCustAvcNtcDtlVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());

							dbDao.modifyCustAdvisoryNoticeDetailByMail(bkgCustAvcNtcDtlVO, account);
							
							// 4. 메일 전송 후 이력정보 Insert
							BkgCustAvcNtcHisVO bkgCustAvcNtcHisVO = new BkgCustAvcNtcHisVO();
							bkgCustAvcNtcHisVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcHisVO.setVslCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(0, 4));
							bkgCustAvcNtcHisVO.setSkdVoyNo(bkgCustAvcNtcSndVOs[i].getVvd().substring(4, 8));
							bkgCustAvcNtcHisVO.setSkdDirCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(8, 9));
							bkgCustAvcNtcHisVO.setNtcViaCd("E");  //F:Fax,M:Email
							bkgCustAvcNtcHisVO.setBkgCustTpCd("N");
							bkgCustAvcNtcHisVO.setPolCd(bkgCustAvcNtcSndVOs[i].getPolCd());
							bkgCustAvcNtcHisVO.setPodCd(bkgCustAvcNtcSndVOs[i].getPodCd());
							bkgCustAvcNtcHisVO.setDelCd(bkgCustAvcNtcSndVOs[i].getDelCd());
							bkgCustAvcNtcHisVO.setNtcEml(bkgCustAvcNtcMailSndVO.getRcvrEml());
							bkgCustAvcNtcHisVO.setNtcSndId(eMailSndId);
							bkgCustAvcNtcHisVO.setNtcSndOfcCd(account.getOfc_cd());
							bkgCustAvcNtcHisVO.setNtcSndUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setNtcSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							bkgCustAvcNtcHisVO.setImptNtcRmk(bkgCustAvcNtcMailSndVO.getRmk());
							bkgCustAvcNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setUpdUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());
							
							dbDao.addCustAdvisoryNoticeHistory(bkgCustAvcNtcHisVO);
							
							// 메일 송신 건수
							sentInt++;
						}
					}
				}
			}
			
			//4. CT 전송 
			for(int i=0; i<bkgCustAvcNtcSndVOs.length; i++){
				if("1".equals(bkgCustAvcNtcSndVOs[i].getCtrtEmailEvntFlg())){

					groupList = new ArrayList();
					currCtCust = bkgCustAvcNtcSndVOs[i].getCtrtEmlNm(); //현재 화주 이름
					for(int k = 0; k < preCtCust.size() ; k++) {
						if(currCtCust.equals(preCtCust.get(k))) {
							ctProcess = false;
							break;
						}
						ctProcess = true;

					}
					
					if(!ctProcess) continue;
					
					groupList.add(bkgCustAvcNtcSndVOs[i].getBlNo());

					for(int j=0; j<bkgCustAvcNtcSndVOs.length; j++){
						
						if(i ==  j) continue;
						nextCtCust = bkgCustAvcNtcSndVOs[j].getCtrtEmlNm();
		
						if(currCtCust.equals(nextCtCust)) {
							groupList.add(bkgCustAvcNtcSndVOs[j].getBlNo());
							
						}
					}
					preCtCust.add(currCtCust);
					custGroupMap.put(currCtCust, groupList);

					//CHK 가 선택되어있을경우만 실행
					if("1".equals(bkgCustAvcNtcSndVOs[i].getEmlChk())){
						// 1. Mail 송신 Flag 를 'Y'로 업데이트 한다.
						dbDao.modifyCustAdvisoryNoticeBySend(bkgCustAvcNtcSndVOs[i], account);
						
						String custName = bkgCustAvcNtcSndVOs[i].getCtrtEmlNm();
						String arrMailNo = bkgCustAvcNtcSndVOs[i].getCtrtCustEml();
						// VVD별 Html Contents 정보를 가져온다.
						//custGroupMap.get(currCust)안에 여러 BL이 들어가 있을 수 있으므로 저 사이즈 만큼 for로 루프
						String hash_bl_no = custGroupMap.get(currCtCust).toString();

						hash_bl_no= hash_bl_no.replace("[", "");
						hash_bl_no= hash_bl_no.replace("]", "");
						String[] bl_no = hash_bl_no.split(",");

						BkgCustAvcNtcSndCtntVO bkgCustAvcNtcSndCtntVO = null;
						BkgCustAvcNtcSndCtntVO vo = null;
						StringBuffer sb = new StringBuffer();
						
						for(int m=0;m<bl_no.length;m++){
							vo = dbDao.searchCustAdvisoryNoticeSendCtntbyDupBlNo(bkgCustAvcNtcSndVOs[i], bl_no[m].trim());
							if(vo != null){
								if(!"".equals(vo.getCntrNo())) {
									sb.append(bl_no[m].trim()).append("/").append(vo.getCntrNo());
									if(bl_no.length > 1 && m < bl_no.length -1) {
										sb.trimToSize();
										sb.append("\n");
									}
								}
	
								if(m == bl_no.length -1) {
									bkgCustAvcNtcSndCtntVO = new BkgCustAvcNtcSndCtntVO();
									bkgCustAvcNtcSndCtntVO.setCntrNo(sb.toString());
									bkgCustAvcNtcSndCtntVO.setRmk(vo.getRmk());
									bkgCustAvcNtcSndCtntVO.setSndDt(vo.getSndDt());
									bkgCustAvcNtcSndCtntVO.setEmlSubjCtnt(vo.getEmlSubjCtnt());
									bkgCustAvcNtcSndCtntVO.setFileDesc(vo.getFileDesc());
								}
							}
						}
						// Remark 를 조회한다.
						if(bkgCustAvcNtcSndCtntVO != null ) {
							String rmk = bkgCustAvcNtcSndCtntVO.getRmk();
							if(rmk == null || "".equals(rmk)){
								throw new EventException(new ErrorHandler("BKG40119").getMessage()); 
							}
						} else {
							throw new EventException(new ErrorHandler("BKG40119").getMessage());
						}
						// 2. 메일 전송
						BkgCustAvcNtcMailSndVO bkgCustAvcNtcMailSndVO = new BkgCustAvcNtcMailSndVO();
						
						bkgCustAvcNtcMailSndVO.setBlNo(bkgCustAvcNtcSndVOs[i].getBlNo());
						bkgCustAvcNtcMailSndVO.setRcvrNm(custName);
						bkgCustAvcNtcMailSndVO.setRcvrEml(arrMailNo);
						bkgCustAvcNtcMailSndVO.setEmlTitNm(bkgCustAvcNtcSndCtntVO.getEmlSubjCtnt());
						bkgCustAvcNtcMailSndVO.setSndDt(bkgCustAvcNtcSndCtntVO.getSndDt());
						bkgCustAvcNtcMailSndVO.setCntrNo(bkgCustAvcNtcSndCtntVO.getCntrNo());
						bkgCustAvcNtcMailSndVO.setRmk(bkgCustAvcNtcSndCtntVO.getRmk());
						bkgCustAvcNtcMailSndVO.setCntrNoViewFlg(bkgCustAvcNtcSndCtntVO.getFileDesc());
						StringBuffer file = new StringBuffer();
						if (bkgCustAvcNtcSndVOs[i].getFileKey() != null) {
							String fileKeys = bkgCustAvcNtcSndVOs[i].getFileKey();
							/** 여러건 */
							if (fileKeys.indexOf(";") > -1) {
								String[] keyTemp = fileKeys.split(";");
								for (int j = 0; j < keyTemp.length; j++) {
									file.append(fileUtil.copyUploadFile(keyTemp[j])).append(";");
								}
							} else {
								file.append(fileUtil.copyUploadFile(fileKeys)).append(";");
							}
						}
						log.debug("\n sendCustAdvisoryNoticeListByMail file Key : " + file.toString());
						bkgCustAvcNtcMailSndVO.setFileKey(file.toString());
						eMailSndId = eaiDao.sendBkgCustAdvisoryNoticeByEmail(bkgCustAvcNtcMailSndVO, urlPath, account);
							
						for(int m=0;m<bl_no.length;m++){
							// 3. 메일 전송 후 Advisory Notice 대상 B/L의 연락처 정보를 갱신한다.
							BkgCustAvcNtcDtlVO bkgCustAvcNtcDtlVO = new BkgCustAvcNtcDtlVO();
							bkgCustAvcNtcDtlVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcDtlVO.setBkgCustTpCd("T");
							bkgCustAvcNtcDtlVO.setCustName(custName);
							bkgCustAvcNtcDtlVO.setNtcEml(arrMailNo);
							bkgCustAvcNtcDtlVO.setNtcEmlSndId(eMailSndId);
							bkgCustAvcNtcDtlVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());

							dbDao.modifyCustAdvisoryNoticeDetailByMail(bkgCustAvcNtcDtlVO, account);
							
							// 4. 메일 전송 후 이력정보 Insert
							BkgCustAvcNtcHisVO bkgCustAvcNtcHisVO = new BkgCustAvcNtcHisVO();
							bkgCustAvcNtcHisVO.setBlNo(bl_no[m].trim());
							bkgCustAvcNtcHisVO.setVslCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(0, 4));
							bkgCustAvcNtcHisVO.setSkdVoyNo(bkgCustAvcNtcSndVOs[i].getVvd().substring(4, 8));
							bkgCustAvcNtcHisVO.setSkdDirCd(bkgCustAvcNtcSndVOs[i].getVvd().substring(8, 9));
							bkgCustAvcNtcHisVO.setNtcViaCd("E");  //F:Fax,M:Email
							bkgCustAvcNtcHisVO.setBkgCustTpCd("T");
							bkgCustAvcNtcHisVO.setPolCd(bkgCustAvcNtcSndVOs[i].getPolCd());
							bkgCustAvcNtcHisVO.setPodCd(bkgCustAvcNtcSndVOs[i].getPodCd());
							bkgCustAvcNtcHisVO.setDelCd(bkgCustAvcNtcSndVOs[i].getDelCd());
							bkgCustAvcNtcHisVO.setNtcEml(bkgCustAvcNtcMailSndVO.getRcvrEml());
							bkgCustAvcNtcHisVO.setNtcSndId(eMailSndId);
							bkgCustAvcNtcHisVO.setNtcSndOfcCd(account.getOfc_cd());
							bkgCustAvcNtcHisVO.setNtcSndUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setNtcSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							bkgCustAvcNtcHisVO.setImptNtcRmk(bkgCustAvcNtcMailSndVO.getRmk());
							bkgCustAvcNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setUpdUsrId(account.getUsr_id());
							bkgCustAvcNtcHisVO.setSrcDatTpCd(bkgCustAvcNtcSndVOs[i].getSrcDatTpCd());
							
							dbDao.addCustAdvisoryNoticeHistory(bkgCustAvcNtcHisVO);
							
							// 메일 송신 건수
							sentInt++;
						}
					}
				}	
			}
			
			return sentInt;

		
		} catch (EventException ex){
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0004: init<br>
	 * Customer Advisory Notice Remark 정보를 조회한다.<br>
	 *  
	 * @param BkgCustAvcNtcRmkVO inputVO
	 * @return List<BkgCustAvcNtcRmkVO>
	 * @throws EventException
	 */
	public List<BkgCustAvcNtcRmkVO> searchCustAdvisoryNoticeRemark(BkgCustAvcNtcRmkVO inputVO) throws EventException {
		try {
			return dbDao.searchCustAdvisoryNoticeRemark(inputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0004: save<br>
	 * Customer Advisory Notice Remark 정보를 수정한다.
	 *  
	 * @param BkgCustAvcNtcRmkVO bkgCustAvcNtcRmkVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCustAdvisoryNoticeRemark(BkgCustAvcNtcRmkVO bkgCustAvcNtcRmkVO, SignOnUserAccount account) throws EventException {

		
		try {
			
				// EAST
				dbDao.mergeCustAdvisoryNoticeRemark(bkgCustAvcNtcRmkVO, account);
				
				// WEST
				StringBuffer vvd = new StringBuffer();
				vvd.append(bkgCustAvcNtcRmkVO.getVvd().substring(0, 8));
				vvd.append("W");
				bkgCustAvcNtcRmkVO.setVvd(vvd.toString());
				dbDao.mergeCustAdvisoryNoticeRemark(bkgCustAvcNtcRmkVO, account);
				
                // South
				StringBuffer vvd_south = new StringBuffer();
				vvd_south.append(bkgCustAvcNtcRmkVO.getVvd().substring(0, 8));
				vvd_south.append("S");
				bkgCustAvcNtcRmkVO.setVvd(vvd_south.toString());
				dbDao.mergeCustAdvisoryNoticeRemark(bkgCustAvcNtcRmkVO, account);
				
				// North
				StringBuffer vvd_north = new StringBuffer();
				vvd_north.append(bkgCustAvcNtcRmkVO.getVvd().substring(0, 8));
				vvd_north.append("N");
				bkgCustAvcNtcRmkVO.setVvd(vvd_north.toString());
				dbDao.mergeCustAdvisoryNoticeRemark(bkgCustAvcNtcRmkVO, account);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0005 : retrieve <br>
	 * Customer Advisory History 정보를 조회한다.<br>
	 *  
	 * @param BkgCustAvcNtcSndHisSchVO bkgCustAvcNtcSndHisSchVO
	 * @return List<BkgCustAvcNtcSndHisVO>
	 * @throws EventException
	 */
	public List<BkgCustAvcNtcSndHisVO> searchCustAdvisoryNoticeSendHistory(BkgCustAvcNtcSndHisSchVO bkgCustAvcNtcSndHisSchVO) throws EventException{
		try{
			StringBuffer dirStsCdbf = new StringBuffer("'").append(bkgCustAvcNtcSndHisSchVO.getEDirCd()).append("','").append(bkgCustAvcNtcSndHisSchVO.getWDirCd()).append(bkgCustAvcNtcSndHisSchVO.getSDirCd()).append("','").append(bkgCustAvcNtcSndHisSchVO.getNDirCd()).append("'");
			bkgCustAvcNtcSndHisSchVO.setDirStsCd(dirStsCdbf.toString());
			
			return dbDao.searchCustAdvisoryNoticeSendHistory(bkgCustAvcNtcSndHisSchVO);
		} catch(DAOException ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 
	 * pod변경시 메일 전송.<br>
	 *  
	 * @param Map<String, Object> mailSmsInfo
	 * @return String
	 * @throws EventException
	 */
	public String sendMailByPodChange(Map<String, Object> mailSmsInfo)
			throws EventException {
		String result = null;
		try {
			result = eaiDao.sendMailByPodChange(mailSmsInfo,"");
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return result;
		
	}

	/**
	 * 
	 * pod변경시 메일 전송.<br>
	 *  
	 * @param List<BkgUserSmsListVO> smsList
	 * @param String bkgNo
	 * @param String sndMsg
	 * @param String sndParam
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendMailSmsByPodChange(
			List<BkgUserSmsListVO> smsList, String bkgNo, String sndMsg, String sndParam, SignOnUserAccount account)
			throws EventException {
		Map<String,Object> mailSmsInfo = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		BkgNtcHisVO bkgNtcHisVO = null;
		String sndId = null;
		try {
			
			for (int i = 0; i < smsList.size(); i++) {
				log.debug("\n\nphone:"+JSPUtil.removeCharacter(smsList.get(i).getPhnNo(), "-"));
				mailSmsInfo = new HashMap<String,Object>();
				mailSmsInfo.put("TO_EMAIL", smsList.get(i).getRcvrEml());
				mailSmsInfo.put("TO_SMS", JSPUtil.removeCharacter(smsList.get(i).getPhnNo(), "-"));
				mailSmsInfo.put("EML_SUBJ_CTNT", sndMsg);
				mailSmsInfo.put("FROM_EMAIL", "norelpy@smlines.com");
				mailSmsInfo.put("TEXT", sndMsg);
				
				mailSmsInfo.put("FILE_ATCH_FLG", smsList.get(i).getFileAtchFlg()); //pdf 첨부 추가 여부 
//				sndId = eaiDao.sendMailByPodChange(mailSmsInfo);
				sndId = eaiDao.sendMailByPodChange(mailSmsInfo,sndParam);
				
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgNo);
				bkgNtcHisVO.setNtcViaCd("M");
				bkgNtcHisVO.setNtcKndCd("ES"); // 추후 변경
				bkgNtcHisVO.setNtcEml(smsList.get(i).getRcvrEml());
				bkgNtcHisVO.setSndId(sndId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
				bkgNtcHisVOs.add(bkgNtcHisVO);
//				historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
				
				//SMS 전송
				sndId = eaiDao.sendSmsByPodChange(mailSmsInfo);
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgNo);
				bkgNtcHisVO.setNtcViaCd("S");
				bkgNtcHisVO.setNtcKndCd("ES"); // 추후 변경
				bkgNtcHisVO.setNtcEml(smsList.get(i).getRcvrEml());
				bkgNtcHisVO.setPhnNo(JSPUtil.removeCharacter(smsList.get(i).getPhnNo(), "-"));
				bkgNtcHisVO.setSndId(sndId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
//				bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
				bkgNtcHisVOs.add(bkgNtcHisVO);

				
			}
		} catch(EventException e){
//			rollback();
			throw e;
		}catch(Exception ex){
//			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return bkgNtcHisVOs;
	}
	
	/**
	 * ESM_BKG_1139 : search<br>
	 * TRO Fax/Email 발송 History를 조회한다.
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String ioBndCd
	 * @return List<SendBkgFaxEmailVO>
	 * @throws EventException
	 */
	public List<SendBkgFaxEmailVO> searchEurTroNotice(BkgBlNoVO bkgBlNoVO, String ioBndCd) throws EventException {
		try {
			return dbDao.searchEurTroNotice(bkgBlNoVO, ioBndCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
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
	public String startBackEndJob(SignOnUserAccount account, 
			BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, BkgCustAvcNtcUploadVO[] bkgCustAvcNtcUploadVOs, String pgmNo) throws EventException {
		
		GeneralBookingSearchBackEndJob backEndJob = new GeneralBookingSearchBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		
		if(pgmNo.equals("ESM_BKG_0003")) {
			backEndJob.setBkgCustAvcNtcSchVO(bkgCustAvcNtcSchVO);
			backEndJob.setBkgCustAvcNtcUploadVOs(bkgCustAvcNtcUploadVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUpd_usr_id(), "Customer Advisory Send");
		} else if (pgmNo.equals("BST_DOWNLOAD")) {
			backEndJob.setBkgCustAvcNtcSchVO(bkgCustAvcNtcSchVO);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUpd_usr_id(), "Customer Advisory BST Download");
		}
		
		return resultStr;
	}
	
	/**
	 * ESM_BKG_0003: BST Download<br>
	 *  
	 * @param bkgCustAvcNtcSchVO
	 * @return
	 * @throws EventException
	 */
	public int searchCustAdvisoryNoticeCntByBSTUpload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO) throws EventException {
		try {
			return dbDao.searchCustAdvisoryNoticeCntByBSTUpload(bkgCustAvcNtcSchVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0003: BST Download<br> 
	 * Emergemcy Case 가 발생 한 대상 Container를 기준으로 B/L정보를 저장한다. 
	 * 
	 * @param bkgCustAvcNtcSchVO
	 * @param account
	 * @throws EventException
	 */
	public void manageCustAdvisoryNoticeListByBSTDownload(BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO, SignOnUserAccount account) throws EventException{
		try{
			// Customer Advisory Notice BL
			dbDao.addCustAdvisoryNoticeBLByBSTDownload(bkgCustAvcNtcSchVO, account);
			// Customer Advisory Notice Container
			dbDao.addCustAdvisoryNoticeCntrByBSTDownload(bkgCustAvcNtcSchVO, account);
			// Customer Advisory Notice Detail
			dbDao.addCustAdvisoryNoticeDetailByBSTDownload(bkgCustAvcNtcSchVO, account);
			
		} catch(DAOException ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	} 

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
	public List<BkgNtcHisVO> sendBkgRevisedRateByEmail(String mrdNm, String ntcKndCd, String eml, String param, BkgBlNoVO bkgBlNoVO, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException{
		BookingUtil util = null;
		String ccEmail = null;
		try {
			util = new BookingUtil();
			ccEmail = util.searchCcEmailAddrRSQL(ntcKndCd, account.getUsr_id());
			return eaiDao.sendBkgRevisedRateByEmail(bkgBlNoVO, ntcKndCd, eml, mrdNm, param, ccEmail, bkgEmlEdtVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * Customer List 조회<br>
	 * @param SearchCustomerInqryCondVO searchCustomerInqryCondVO
	 * @param int iPage
	 * @param String custCd
	 * @param String cust
	 * @return List<SearchCustomerInqryVO>
	 * @throws EventException
	 */
    public List<SearchCustomerInqryVO> searchCustomerList(SearchCustomerInqryCondVO searchCustomerInqryCondVO, int iPage, String custCd, String cust ) throws EventException {
        try {
			return  dbDao.searchCustomerList(searchCustomerInqryCondVO, iPage, custCd, cust);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
    }
    
    /**
	 * Booking Vessel Revised Notice 전송<br>
	 * @param List<BkgBlNoVO> bkgBlNoVOs
	 * @param String vslCngRsn
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgVslReviseNotice(List<BkgBlNoVO> bkgBlNoVOs, String vslCngRsn, SignOnUserAccount account) throws EventException{
        try {
			List<RcvrBkgReviseNoticeVO> rcvBkgReviseNoticeVOs = dbDao.searchRcvrBkgReviseNotice(bkgBlNoVOs);
			if(rcvBkgReviseNoticeVOs != null && rcvBkgReviseNoticeVOs.size() > 0){
				String receiptType = dbDao.searchBkgReceiptType(account.getUsr_id());
				return eaiDao.sendBkgVslReviseNotice(rcvBkgReviseNoticeVOs, vslCngRsn, receiptType, account);
			} else {
				return null;
			}
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
	}
	
	/**
	 * 첨부된 파일 리스트를 조회<br>
	 * @param BkgCustAvcNtcRmkVO inputVO
	 * @return List<BkgCustAvcFileListVO>
	 * @throws EventException
	 */
	public List<BkgCustAvcFileListVO> searchCustAdvisoryFileList(BkgCustAvcNtcRmkVO inputVO) throws EventException {
		try {
			return dbDao.searchCustAdvisoryFileList(inputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ALOC_STS_CD 를 조회한다.<br>
	 * @param String bkgNo
	 * @return AlocStandbyReasonVO
	 * @throws EventException
	 */
	public AlocStandbyReasonVO searchAlocStsCdByBkgNo(String bkgNo) throws EventException{
		try {
			return dbDao.searchAlocStsCdByBkgNo(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Allocation Stand by Reason 의 Truck VVD BKG Status vs. Allocation 을 조회한다.<br>
	 * @param String bkgNo
	 * @return List<AlocStandbyReasonVO>
	 * @throws EventException
	 */
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonTruck(String bkgNo) throws EventException{
		try {
			return dbDao.searchAlocStandbyReasonTruck(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Allocation Stand by Reason 의 T/S VVD BKG Status vs. Allocation 을 조회한다.<br>
	 * @param String bkgNo
	 * @return List<AlocStandbyReasonVO>
	 * @throws EventException
	 */
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonTs(String bkgNo) throws EventException{
		try {
			return dbDao.searchAlocStandbyReasonTs(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Allocation Stand by Reason 의 EQ & Commodity Restriction 을 조회한다.<br>
	 * @param String bkgNo
	 * @return List<AlocStandbyReasonVO>
	 * @throws EventException
	 */
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonEq(String bkgNo) throws EventException{
		try {
			return dbDao.searchAlocStandbyReasonEq(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Allocation Stand by Reason 의 Customer Constraint 를 조회한다.<br>
	 * @param String bkgNo
	 * @return List<AlocStandbyReasonVO>
	 * @throws EventException
	 */
	public List<AlocStandbyReasonVO> searchAlocStandbyReasonCust(String bkgNo) throws EventException{
		try {
			return dbDao.searchAlocStandbyReasonCust(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}		
	
	/**
	 * SLS_REP_CD 로 AS 인 PRNT_OFC_CD 정보를 조회한다.(ESM_BKG_0079_01)
	 * 
	 * @author 
	 * @param String srep_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchPrntOfcCdBySRepCd(String srep_cd) throws EventException {
		try {
			return dbDao.searchPrntOfcCdBySRepCd(srep_cd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * MDM_SLS_REP 의 SREP_EML 을 조회 한다.<br>
	 *
	 * @author 
	 * @param  String srepCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSrepEml(String srepCd) throws EventException {
		try {
			return dbDao.searchSrepEml(srepCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * e-Booking Upload Notice 메일 수신인을 조회한다.<br>
	 * WEB을 통해 자동생성된 BKG 중 Auto Notification에 체크되어있고  
	 * Standby:F, NoRate:F인 Booking에 대해 Upload(Receipt) Notice를 전송해준다.
	 * @author 
	 * @param  String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchEBkgUploadNoticeEml(String bkgNo) throws EventException {
		try {
			return dbDao.searchEBkgUploadNoticeEml(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	 /**
	 * ScListInput 파라미터 조회<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return ScListInputVO
	 * @throws EventException
	 */
	public ScListInputVO searchScListInput(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchScListInput(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 *  S/C를 유효성을 조회한다.
	 * 
	 * @author		
	 * @param 		ScListInputVO scListInputVO
	 * @return 		String
	 * @exception 	EventException
	 */
	public String searchScAvailableCust(ScListInputVO scListInputVO) throws EventException {
		try {
			return dbDao.searchScAvailableCust(scListInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * Customer에게 NoRateNotice 를 보내면 안되는 조건인지 조회한다.
	 * 
	 * @author		
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	EventException
	 */
	public String searchNoRateNoticeToCustomerBlock(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			return dbDao.searchNoRateNoticeToCustomerBlock(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Booking Creation Status 돋보기 누르면 나오는 화면에 대한 조회(Estimated CMPB)
	 * 
	 * @author 
	 * @param String bkgNo
	 * @return List<EstimatedCMPBVO>
	 * @exception EventException
	 */
	public List<EstimatedCMPBVO> searchEstimatedCMPB(String bkgNo) throws EventException {
		try {
			return dbDao.searchEstimatedCMPB(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0566 : History를 조회한다<br>
	 *
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @param   SIWebServiceVO sIWebServiceVO
	 * @return HistMainVO
	 * @author Lee NamKyung
	 * @exception EventException
	 */
	public HistMainVO searchBlHist(BkgBlNoVO bkgBlNoVO, SIWebServiceVO sIWebServiceVO) throws EventException {
		try {			
			HistMainVO histMainVO = new HistMainVO();
			
			//01. Booking Header
			BkgInforForHistVO bkgInfoForHistVO = dbDao.searchBkgInfoForHist(bkgBlNoVO);			
			
			//02. Item Combo
			List<HistUiNmVO> histUiNmVOs = dbDao.searchHistUiNm(bkgBlNoVO);
			
			//03. B/L Data
			List<BlHistVO> blHistVOs = dbDao.searchBlHistSi(sIWebServiceVO);
			
			histMainVO.setBkgInforForHistVO(bkgInfoForHistVO);
			histMainVO.setHistUiNmVOs(histUiNmVOs);
			histMainVO.setBlHistVOs(blHistVOs);
			
			return histMainVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
		
	/**
	 * S/I 이후, Awkward Container Weight와 Container Weight의 차이가 20%이상 나는지 여부를 체크
	 * 
	 * @param bkgNo String
	 * @return String
	 * @throws EventException
	 */
	public String checkAkwardOverWgtFlg(String bkgNo) throws EventException {
		try {
			return dbDao.checkAkwardOverWgtFlg(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
}
