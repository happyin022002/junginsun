/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtil.java
*@FileTitle : Booking Page
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.23 김영출
* 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
 * 2010.11.09 최도순 [CHM-201006977] Work with Bookings의 조회 옵션에 E/Q Type 추가
 * 2010.11.11 이일민 [CHM-201005869-01] Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 * 2010.11.11 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 * 2010.11.16 김영철 [] R4J 메소드 주석 기술 ( searchMdmCntrTpSz() )
 * 2010.11.17 전성진 [CHM-201005932] PRD FlexHeight 및 TRO Split 처리관련 BKG 수정
 * 2010.12.16 김현화 [CHM-201007561-01] Zip code Creation(UI_BKG_1114) COMBO사용 searchMdmCnt()
 * 2010.12.28 이인영 [CHM-201007771-01] 이란 금융 제재 관련 Black Customer 체크기능 추가
 * 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청 (searchPkgTypeByName 추가)
 * 2010.12.31 이일민 [] R4J 관련 주석 추가
 * 2011.01.06 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청 (searchSteCodeByName 추가)
 * 2011.04.01 김기종 [CHM-201109394-01] DPCS고도화일환으로  DPCS E-MAIL 추가및 화면 개선
 * 2011.04.06 조원주 [CHM-201109864] Customer E-Mail Address 입력 column 추가
 * 2011.05.18 김봉균 [CHM-201110697-01] BDR Open 권한 변경(seacrhManualBdrUserCheck 추가)
 * 2011.08.24 박성진 [SRM-201119229][ENS]POFE ETA in AN - ENS Flat File내의 POFE ETA와 매치(날짜가감기능추가)
 * 2011.09.02 김봉균 [CHM-201113070-01] 카고 릴리즈 화면에서의 금액 출력요청(DEM)
 * 2011.10.10 전성진 [CHM-201111889] T.VVD 변경시, Post VVD 변경 및 관련 Alert Message 처리 요청. 
 * 2012.02.02 변종건 [CHM-201215949-01] e-Booking & SI upload 화면의 USA export 정보 변경 요청
 * 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가.
 * 2012.03.29 전성진 [CHM-201217014] 악성 화주 선택시 Warning Message 변경 요청
 * 2012.04.24 오요한 [CHM-201216516] BKG/DOC System 보완 요청
 * 2012.06.18 조정민 [CHM-201217472] [BKG] BKG/DOC Validation Rule 정리 요청
 * 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
 * 2012.11.08 김보배 [CHM-201221406] [BKG] 이란 Sanction 관련 HS Code 삽입 로직 보완 요청 
 * 2012.11.20 이준근 [CHM-201221047-01] B/L Type의 예외적 처리를 위한 변경 요청
 * 2012.11.29 이재위 [CHM-201220433] [eBKG] Simple BKG 개발 요청
 * 2012.12.20 조정민 [CHM-201221841] Booking Confirmation F/File 발송 조건 추가
 * 2013.04.04 김태경 [CHM-201323821] 통합 SQL ERROR 로그 결과 복구
 * 2013.04.08 김진주 [CHM-201323806] BOOKING STATUS REPORT 판매팀 코드로 산출 기능 추가
 * 2013.04.16  김태경 [CHM-201323803] VFC 310 정보 추가 전송 관련 요청	
 * 2013.04.29 김태경 [CHM-201323821] B/L ISSUE 에서 ROUTE 정보를  LOG에 관리 하도록 기능 추가
 * 2014.06.18 조인영 [CHM-201430731] BKG Status Report에 POL 이나 BKG OFFICE가 US/CA Country에 속하는 경우 1달동아 조회토록 로직 보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerCntrVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerInvVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingnumbergenaration.basic.BookingNumberGenarationBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingnumbergenaration.basic.BookingNumberGenarationBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilEAIDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.AcssAlwInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlckListMntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgCloseVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgCstmsHrdCdgCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgInetBlPrnAuthVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ContinentCodeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ManualSurchargeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MemoSplitMasterBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.OblIssVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.OfcChgProcVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ProductCatalogPoupCheckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ReportItemVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchBlListByCntrNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchBlListByHblNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchBlListByPoNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchLocationCodeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchPortCdByVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchSrepCdListVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchSvcLaneBoundVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SplitMstBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SplitNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.StaffListByOfcCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DmtChargeVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.ToTBilAmtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;
import com.hanjin.syscommon.common.table.BkgHamoTrfVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgIdaSacMstVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgRateVO;
import com.hanjin.syscommon.common.table.BkgTroVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.syscommon.common.table.MdmContinentVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.MdmPckTpVO;
import com.hanjin.syscommon.common.table.MdmSlsRepVO;
import com.hanjin.syscommon.common.table.MdmStateVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.common.table.MdmZoneVO;
import com.hanjin.syscommon.common.table.MstContainerVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * NIS2010-BookingUtil<br>
 * - NIS2010-BookingCommon에 대한 공통 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Youngchul
 * @see UI_Booking_UtilEventResponse 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class BookingUtil{
    // Database Access Object
    private transient BookingUtilDBDAO dbDao = null;
    private transient BookingUtilEAIDAO eaoDao = null;
    private transient Logger log = null;
 
    /**
     * BookingUtil 객체 생성<br>
     * BookingUtilDBDAO를 생성한다.<br>
     */
    public BookingUtil() {

        dbDao = new BookingUtilDBDAO();
        eaoDao = new BookingUtilEAIDAO();        
        log = Logger.getLogger(this.getClass().getName());
    }
	/**
	 * oblIssFlgCheck  이벤트 처리<br>
	 * @param String bkgNo
	 * @param String ca_flg
	 * @return String
	 * @exception EventException
	 */
	public String oblIssFlgCheck(String bkgNo, String ca_flg) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.oblIssFlgCheck(bkgNo, ca_flg);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 
	
	
	/**
	 * searchRtAplyDateCheck  이벤트 처리<br>
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchRtAplyDateCheck(String bkgNo) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchRtAplyDateCheck(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 
	
	/**
	 * autoRatingRFACheck  이벤트 처리<br>
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String autoRatingRFACheck(String bkgNo) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.autoRatingRFACheck(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 
	/**
	 *  searchBkgVvd  이벤트 처리<br>
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchBkgVvdCheck(String bkgNo) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchBkgVvdCheck(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 
    /**
	 * searchScNoValidationCheck 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * ScNumber 유효성을 검사함  <br>
	 * @author Lee Jin Seo
	 * @param String scNo
	 * @return String 
	 * @throws EventException
	 */
	public String searchScNoValidationCheck(String scNo) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchScNoValidationCheck(scNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}   
    /**
	 * searchCountryName 조회 이벤트 처리<br>
	 * 79-02C event체크 <br>
	 * MDM_COUNTRY 이름값을 얻어옴  <br>
	 * @author Lee Jin Seo
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String searchCountryName(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchCountryName(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}   
	/**
	 * BkgTroVO 정보 조회.<br>
	 * @author Lee Jin Seo
	 * @param BkgTroVO vo
	 * @return BkgTroVO
	 * @throws EventException
	 */
	public BkgTroVO searchPcNoforTro(BkgTroVO vo) throws EventException {
		try {
			return dbDao.searchPcNoforTro(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
    /**
	 * repCustomer 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String bkg_no
	 * @return String 
	 * @throws EventException
	 */
	public String repCustomer(String bkg_no) throws EventException{
		String resultExist = "";
		try {
			resultExist = dbDao.repCustomer(bkg_no);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
	/**
	 * BkgRate 을 조회하여 Mater/Cover에 정보를 Return한다.<br>
	 * 
	 * @param String bl_no
	 * @return BkgRateVO
	 * @throws EventException
	 */
	public BkgRateVO searchBkgRate(String bl_no) throws EventException {
		BkgRateVO bkgRateVO = null;
		try {
			bkgRateVO = dbDao.searchBkgRate(bl_no);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return bkgRateVO;
	}
    /**
	 * vesselVoyageDirectionEqual 조회 이벤트 처리<br>
	 * 79-09 event체크 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String bkg_no
	 * @return String 
	 * @throws EventException
	 */
	public String vesselVoyageDirectionEqual(String bkg_no) throws EventException{
		String resultExist = "";
		try {
			resultExist = dbDao.vesselVoyageDirectionEqual(bkg_no);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
    /**
	 * manualSurcharge 함수 <br>
	 *1. 메뉴얼로 Insert 하는 Charge 가 PRI에 Scope 및 CHG CODE 별로 등록 되어있는 항목중에 	
	 *- Charge Code 일치, Cur 일치, Per ='PC' Term 이 일치 할경우 적용
	 * @author Lee Jin Seo
	 * @param String application_date
	 * @param String svc_scp_cd
	 * @return List<ManualSurchargeVO>
	 * @throws EventException
	 */
	public List<ManualSurchargeVO> manualSurcharge(String application_date, String svc_scp_cd) throws EventException{
		try {
			return dbDao.manualSurcharge(application_date,svc_scp_cd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}   
    /**
	 * autoratingRfaAvailable 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * AutoratingRfaAvailable 유효성체크  <br>
	 * @author Lee Jin Seo
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String autoratingRfaAvailable(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.autoratingRfaAvailable(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}   
	 /**
	 * autoratingScAvailable 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * AutoratingScAvailable 유효성체크   <br>
	 * @author Lee Jin Seo
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String autoratingScAvailable(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.autoratingScAvailable(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}   	
	 /**
	 * autoratingTaaAvailable 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * AutoratingTaaAvailable 유효성체크   <br>
	 * @author kim tae kyoung
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String autoratingTaaAvailable(String cntCd) throws EventException{
		String resultExist = "N";
		try{
			resultExist = dbDao.autoratingTaaAvailable(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return resultExist;
	}
	  
    /**
	 * existNoteButtonColor 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * note 버튼 색상변경  <br>
	 * @author Lee Jin Seo
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String existNoteButtonColor(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.existNoteButtonColor(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}    
    /**
	 * existBlackListedCustomer 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * Third (Offce cd) 유효성체크 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public BkgCreCustomerVO existBlackListedCustomer(String cntCd) throws EventException{
		BkgCreCustomerVO bkgCreCustomerVO = null;
		try {
			bkgCreCustomerVO = dbDao.existBlackListedCustomer(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return bkgCreCustomerVO ;
	}
    /**
	 * existCountryCode 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * Third (Offce cd) 유효성체크 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String existCountryCode(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			
			MdmCountryVO mvo = dbDao.searchCountryCode(cntCd);
			if(mvo != null){
				resultExist = "Y"; // 존재함. 
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
    /**
	 * existPerCode 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * Per (per cd) 유효성체크 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String cntCd
	 * @return String 
	 * @throws EventException
	 */
	public String existPerCode(String cntCd) throws EventException{
		String resultExist = "N";
		try {
			
			resultExist = dbDao.existPerCode(cntCd);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
	
    /**
	 * existThirdCode 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * Third (Offce cd) 유효성체크 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String offce_cd
	 * @return String
	 * @throws EventException
	 */
	public String existThirdCode(String offce_cd) throws EventException{
		String resultExist = "N";
		try {
			
			MdmOrganizationVO mvo = dbDao.searchMdmOrzByOfcCd(offce_cd);
			if(mvo != null){
				resultExist = "Y"; // 존재함. 
			}
	     
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
	/**
	 * existPayerCode 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * Payer (custCntCd, custSeq) 유효성체크 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String OUTPUT_TEXT
	 * @throws EventException
	 */
	public String existPayerCode(String input_text) throws EventException{
		String resultExist = "N";
		
		try {
			String[] cust = input_text.split("\\|");
			String custCntCd = cust[0];
			String custSeq = cust[1];
			resultExist = dbDao.existPayerCode(custCntCd, custSeq);	
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		 return resultExist ;
	}

    /**
	 * searchMdmLocName<br>
	 * LOC_CD 코드번호로 LOC_NM값을 얻는 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String OUTPUT_TEXT
	 * @throws EventException
	 */
	public String searchMdmLocName(String input_text) throws EventException{
		try {
			String[] locCd = splitByToken(input_text, "|");
			if(locCd.length>1){
				String locNmList = "";
				for(int i = 0; i<locCd.length; i++){
					
					if(locCd[i] == null || locCd[i].length() < 1){
						continue;
					}
					
					if(i==0){
						locNmList = dbDao.searchMdmLocName(locCd[i]);
					} else {
						locNmList = locNmList + "|" + dbDao.searchMdmLocName(locCd[i]);
					}
				}
				return locNmList;
			} else {
				return dbDao.searchMdmLocName(input_text);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}
    /**
     * searchBkgNoListByBkgNo<br>
     * BKG_NO 번호로 OLD ,NEW BKG_NO 번호 구분자($)로 가져오는 함수 <br>
     * @author Lee Jin Seo
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
        public String searchBkgNoListByBkgNo(String input_text)throws EventException {
            try {
                return dbDao.searchBkgNoListByBkgNo(input_text);
            } catch (DAOException de) {
    			log.error("err " + de.toString(), de);
    			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    		} catch (Exception ex) {
    			log.error("err " + ex.toString(), ex);
    			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
    		}
        }
    /**
     * searchBlListByBl<br>
     * BL_NO 번호로 OLD ,NEW BL_NO 번호 구분자($)로 가져오는 함수 <br>
     * @author Lee Jin Seo
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
    public String searchBlNoListByBlNo(String input_text)throws EventException {
        try {
            return dbDao.searchBlNoListByBlNo(input_text);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    /**
     * existChargeCode<br>
     * ChargeCode 코드번호로 존재여부 판단하는 함수 <br>
     * @author Lee Jin Seo
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
    public String existChargeCode(String input_text)throws EventException {
        try {
            return dbDao.existChargeCode(input_text);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    /**
     * existCurrencyCode<br>
     * CurrencyCode 코드번호로 존재여부 판단하는 함수 <br>
     * @author Lee Jin Seo
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
    public String existCurrencyCode(String input_text)throws EventException {
        try {
            return dbDao.existCurrencyCode(input_text);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }        
    /**
     * 공통콤보 목록조회<br>
     * 
     * @param String comCode
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchCombo(String comCode) throws EventException {
        try {
            return dbDao.searchCombo(comCode);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }
    
    /**
     * BL번호로 BKG NO 조회<br>
     * 
     * @param String blNo
     * @return String
     * @exception EventException
     */
    public String searchBkgNoByBlNo(String blNo) throws EventException {
        try {
            return dbDao.searchBkgNoByBlNo(blNo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }
    
    /**
     * 요청번호로 BKG NO 조회<br>
     * 
     * @param String rqstNo
     * @return String
     * @exception EventException
     */
    public String searchBkgNoByRqstNo(String rqstNo) throws EventException {
    	try {
    		return dbDao.searchBkgNoByRqstNo(rqstNo);
    	} catch (DAOException de) {
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception de) {
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	}
    }

    /**
     * Booking 상태 조회<br>
     *
     * @param     bkgBlNoVO BkgBlNoVO
     * @return    String
     * @exception EventException
     */ 
    public String searchBkgStatusByBkg(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchBkgStatusByBkg(bkgBlNoVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }

   
    /**
     * bkg no로 bkg split no 조회 이벤트 처리<br>
     *
     * @param String bkgNo
     * @return List<BkgComboVO>
     * @throws EventException
     */
    public List<BkgComboVO> searchBkgNoSplitByBkg(String bkgNo) throws EventException {
        try {
            return dbDao.searchBkgNoSplitByBkg(bkgNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * Booking Creation 1_Container Type/Size 조회<br>
     * 
     * @param MdmCntrTpSzVO MdmCntrTpSzVO
     * @return List<MdmCntrTpSzVO>
     * @throws EventException
	 * 
     */
    public List<MdmCntrTpSzVO> searchTypeSize(MdmCntrTpSzVO mdmCntrTpSzVO) throws EventException {
        try {
            return dbDao.searchTypeSize(mdmCntrTpSzVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * container별 TypeSize조회<br>
     * 
     * @param String cntrNo
     * @return List<MstContainerVO>
     * @throws EventException
     */
    public List<MstContainerVO> searchTypeSizeByCntr(String cntrNo) throws EventException {
        try {
            return dbDao.searchTypeSizeByCntr(cntrNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
	/**
	 * Mdm Customer 정보 조회<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String validFlag
	 * @return MdmCustVO
	 * @throws EventException
	 */
	public MdmCustVO searchMdmCust(String custCntCd,String custSeq, String validFlag) throws EventException {
		MdmCustVO mdmCustVO = null;
		try {
			// SQL Error 가 발생 되지 않도록 custSeq 가 Number 인지 먼저 체크
			if((!"".equals(custCntCd) && null != custCntCd) && (!"".equals(custSeq) && null != custSeq ) && !isNumberChk(custSeq)){
				throw new EventException(new ErrorHandler("BKG00458",new String[]{custCntCd, custSeq}).getMessage());
			}
			mdmCustVO = dbDao.searchMdmCust(custCntCd, custSeq);			
			if(mdmCustVO != null){
				// validFlag = "Y" 인 경우에만 체크를 한다.
				if("Y".equals(validFlag)){
					// deltFlag = 'Y'
					if("Y".equals(mdmCustVO.getDeltFlg())){
						throw new EventException((String)new ErrorHandler("BKG00353",new String[]{mdmCustVO.getCustCntCd(),mdmCustVO.getCustSeq()}).getMessage());
					}
					// blockFlag = 'Y'
					if("Y".equals(mdmCustVO.getBlockFlag())){
						throw new EventException((String)new ErrorHandler("BKG00354",new String[]{mdmCustVO.getCustCntCd(),mdmCustVO.getCustSeq()}).getMessage());
					}		
				}
			}else{
				throw new EventException(new ErrorHandler("BKG00458").getMessage());
			}
		} catch(EventException ex) {
			throw ex;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return mdmCustVO;
	}
	
	/**
	 * mdm_cust_cntc_pnt 정보 조회<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return MdmCustVO
	 * @throws EventException
	 */
	public MdmCustVO searchMdmPhnFaxEml(String custCntCd,String custSeq) throws EventException {
		MdmCustVO mdmCustVO = null;
		try {
			// SQL Error 가 발생 되지 않도록 custSeq 가 Number 인지 먼저 체크
			if((!"".equals(custCntCd) && null != custCntCd) && (!"".equals(custSeq) && null != custSeq ) && !isNumberChk(custSeq)){
				throw new EventException(new ErrorHandler("BKG00458",new String[]{custCntCd, custSeq}).getMessage());
			}
			mdmCustVO = dbDao.searchMdmPhnFaxEml(custCntCd, custSeq);
		} catch(EventException ex) {
			throw ex;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return mdmCustVO;
	}
	
	public List<BkgBookingVO> searchTSRoute(BkgBlNoVO vo) throws EventException {
		try {
			return dbDao.searchTSRoute(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	public List<BkgBookingVO> searchDocTp(BkgBlNoVO vo) throws EventException {
		try {
			return dbDao.searchDocTp(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
     * 조회 이벤트 처리<br>
     * SVC Lane 목록을 조회한다.(콤보용)<br>
     * 
     * @return List<MdmVslSvcLaneVO>
     * @throws EventException
     */
	public List<MdmVslSvcLaneVO> searchSvcLaneCd() throws EventException{
        try {
            return dbDao.searchSvcLaneCd();
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
	
	
	/**
	 * mdm yard code 조회<br>
	 * 
	 * @param MdmYardVO vo
	 * @return List<MdmYardVO>
	 * @throws EventException
	 */
	public List<MdmYardVO> searchYardCode(MdmYardVO vo) throws EventException {
		try {
			return dbDao.searchYardCode(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 해당 Location Code가 존재하는지 확인<br>
	 * Location Code가 존재하는 경우  true, 아닌 경우 false return<br>
	 * 
	 * @param locCd Location Code
	 * @return boolean
	 * @throws EventException
	 */
	public boolean validateLoc(String locCd) throws EventException {
		try {
			return dbDao.validateLoc(locCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * RHQ에 대한 Location Code가 올바른지 확인<br>
	 * 해당 Location Code인 경우 true, 아닌 경우 false return<br>
	 * 
	 * @param String rhqCd
	 * @param String cntCd
	 * @return boolean
	 * @throws EventException
	 */
	public boolean validateLocByOrz(String rhqCd, String cntCd) throws EventException {
		try {
			return dbDao.validateLocByOrz(rhqCd, cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Office cd를 이용하여 특정 Organization의 정보를 조회한다.<br>
	 * @author Park Mangeon
	 * @param String ofcCd
	 * @return MdmOrganizationVO
	 * @throws EventException
	 */
	public MdmOrganizationVO searchMdmOrzByOfcCd(String ofcCd) throws EventException {
		try {
			return dbDao.searchMdmOrzByOfcCd(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Office cd를 이용하여 특정 Loc Cd를 조회한다.<br>
	 * @param String ofcCd
	 * @return String loc_cd
	 * @throws EventException
	 */
	public String searchLocCdByOfcCd(String ofcCd) throws EventException {
		try {
			return dbDao.searchLocCdByOfcCd(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  특정 Location Code 를 조회 이벤트 처리<br>
	 * @param String locCd
	 * @return SearchLocationCodeVO
	 * @throws EventException
	 */
	public SearchLocationCodeVO searchLocationCode(String locCd) throws EventException {
		try {
			return dbDao.searchLocationCode(locCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * com_user에서 user_nm을 조회한다<br>
	 * @param String userId
	 * @return String usrNm
	 * @throws EventException
	 */
	
	public String searchUserName(String userId) throws EventException {
		try {
			return dbDao.searchUserName(userId);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	  *  Container No로 조회시 연계된 B/L이 LCL인 경우,관련 B/L List를 조회하고 <br>
	 *  LCL이 아닌 경우,단건의 B/L 정보를 조회한다.<br>
	 * @param String cntrNo
	 * @return List<SearchBlListByCntrNoVO>
	 * @throws EventException
	 */
	
	public List<SearchBlListByCntrNoVO> searchBlListByCntrNo(String cntrNo)  throws EventException {
		try {
			return dbDao.searchBlListByCntrNo(cntrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  vsk의 vessel schedule을 조회한다 <br>
	 * @param String vsl_cd
	 * @param String skd_voy_no
	 * @param String skd_dir_cd
	 * @param String vps_port_cd     
	 * @param String clpt_ind_seq      
	 * @return VskVslPortSkdVO
	 * @throws EventException
	 */
	
	public VskVslPortSkdVO searchEtbEtdEta (String vsl_cd,String skd_voy_no,String skd_dir_cd,String vps_port_cd,String clpt_ind_seq)   throws EventException {
		try {
			return dbDao.searchEtbEtdEta(vsl_cd,skd_voy_no,skd_dir_cd,vps_port_cd,clpt_ind_seq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  mdm zone을 조회한다. <br>
	 * @param String locationCd
	 * @return List<MdmZoneVO>
	 * @throws EventException
	 */
	
	public List<MdmZoneVO> searchZoneCode (String locationCd)   throws EventException {
		try {
			return dbDao.searchZoneCode(locationCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 입력 bkg과 관련된 Booking Split 번호들을 조회한다.<br>
	 * @param String bkgno
	 * @return List<BkgBooking>
	 * @throws EventException
	 */
	
	public List<BkgBookingVO> searchBookingSplitNo (String bkgno)  throws EventException {
		try {
			return dbDao.searchBookingSplitNo(bkgno);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Bkg No로 BDR Flag를 조회한다. <br>
	 * @param BkgBlNoVO vo
	 * @return String bdr_flag
	 * @throws EventException
	 */
	
	public String searchBdrFlgByBkg(BkgBlNoVO vo)  throws EventException {
		try {
			return dbDao.searchBdrFlgByBkg(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * BKG 공통 UTIL <br>
	 *  P.O. No에 둘이상의 B/L 또는 관련 B/L 목록을 List Up하고 아니면 단건의 B/L 항목을 조회한다.  <br>
	 * @param String poNo
	 * @return List<SearchBlListByPoNoVO>
	 * @throws EventException
	 */
	
	public List<SearchBlListByPoNoVO> searchBlListByPoNo (String poNo) throws EventException {
		try {
			return dbDao.searchBlListByPoNo(poNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * HB/L No로 BKG NO 조회. <br>
	 * @param String hbl_no
	 * @return List<SearchBlListByHblNoVO>
	 * @throws EventException
	 */
	
	public  List<SearchBlListByHblNoVO> searchBlListByHblNo (String hbl_no) throws EventException {
		try {
			return dbDao.searchBlListByHblNo(hbl_no);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 *  BKG No로 BKG_PFX_ROUT테이블에서 server 확인. <br>
	 *  BKG NO PREFIX 조건<br>
	 *  => OFFICE PREFIX 3DIGIT<br>
	 *  => booking no에 부여된 앞자리3개의 PreFix<br>
	 * @param BkgBlNoVO vo
	 * @return String svr_id_cd
	 * @throws EventException
	 */
	public String searchSvrByBkgNo (BkgBlNoVO vo) throws  EventException {
		try {
			return dbDao.searchSvrByBkgNo(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 * bkg별 BDR, C/A 상태 조회.<br>
	 * @param BkgBlNoVO vo
	 * @return BkgBlNoVO
	 * @throws EventException
	 */
	public BkgBlNoVO searchBkgBlNoVO (BkgBlNoVO vo) throws EventException {
		try {
			return dbDao.searchBkgBlNoVO(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
	/**
	 * 특정 Country Code 를 조회한다.<br>
	 * @param String cntCd
	 * @return MdmCountryVO
	 * @throws EventException
	 */
	public MdmCountryVO searchCountryCode (String cntCd ) throws EventException {
		try {
			return dbDao.searchCountryCode(cntCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 * HTS Code 체크.<br>
	 * @param String htsCd
	 *  @param String tpCd
	 * @return BkgHamoTrfVO
	 * @throws EventException
	 */
	public BkgHamoTrfVO searchHtsCodeDesc (String htsCd, String tpCd) throws EventException {
		try {
			return dbDao.searchHtsCodeDesc(htsCd, tpCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
		
	
	/**
	 * Package Code 체크.<br>
	 * @param String searchPkgType
	 * @return MdmPckTpVO
	 * @throws EventException
	 */
	public MdmPckTpVO searchPkgType (String searchPkgType )throws EventException {
		try {
			return dbDao.searchPkgType(searchPkgType);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
		
	/**
	 * vvd, pol로 BDR 여부 조회.<br>
	 * @param BkgVvdVO bkgVvdVO
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchVvdBdr(BkgVvdVO bkgVvdVO) throws EventException {
		try {
			return dbDao.searchVvdBdr(bkgVvdVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * imdg_pck_cd값 체크.<br>
	 * @param String dgPkgTpCd
	 * @return String
	 * @throws EventException
	 */
	public String searchPkgTypeForDg(String dgPkgTpCd) throws EventException {
		try {
			return dbDao.searchPkgTypeForDg(dgPkgTpCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Vessel(VVD)존재체크.<br>
	 * @param String vslCd 
	 * @param String voyNo 
	 * @param String dirCd 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean validateVvd (String vslCd ,String voyNo ,String dirCd ) throws EventException {
		try {
			return dbDao.validateVvd(vslCd,voyNo,dirCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Vessel(VVD)가 해당 locationdp calling하는지 체크.<br>
	 * @param String vslCd 
	 * @param String voyNo 
	 * @param String dirCd 
	 * @param String locCd 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean validateVvdLoc (String vslCd ,String voyNo ,String dirCd,String locCd  ) throws EventException {
		try {
			return dbDao.validateVvdLoc(vslCd,voyNo,dirCd,locCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 하드코딩 조회 <br>
	 * bkg_hrd_cdg_desc, bkg_hrd_cdg_desc에서 hrd_cdg_id를 기준으로 조회한다. <br>
	 * 
	 * @param bkgHrdCdgCtntListCondVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */
	public List<BkgHrdCdgCtntVO> searchHardCoding(BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO) throws EventException {
		try {
			//BkgHrdCdgCtntVO가 tableVO이기 때문에  syscommon의 tableVO를 사용함.
			return dbDao.searchHardCoding(bkgHrdCdgCtntListCondVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

    /**
     * C/A STATUS 조회<br>
     * 
     * @param bkgBlNoVO
     * @return String
     * @throws EventException
     */
    public String searchBkgCaStatus(BkgBlNoVO bkgBlNoVO)throws EventException {
        try {
            return dbDao.searchBkgCaStatus(bkgBlNoVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
	
	/**
	 * Bkg No,Bl no 등 생성.<br>
	 * @param String divCd 
	 * @param String officeCd 
	 * @param String usrId 
	 * @return BkgBlNoVO
	 * @throws EventException
	 */
		
	public BkgBlNoVO manageBkgNumberGeneration(String divCd,String officeCd,String usrId )throws EventException {
		try {
			BookingNumberGenarationBC bc = new BookingNumberGenarationBCImpl();	
			return bc.manageBkgNumberGeneration(divCd,officeCd,usrId);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * RPT ,JPD,D/O,CAD,UIT,C/A,KOR NO 등  ReferenceNumber 생성.<br>
	 * @param String divCd 
	 * @param String officeCd 
	 * @param String usrId 
	 * @return BkgReferenceNoGenerationVO
	 * @throws EventException
	 */
		
	public BkgReferenceNoGenerationVO manageBkgReferenceNumberGeneration(String divCd,String officeCd,String usrId )throws EventException {
		try {
			BookingNumberGenarationBC bc = new BookingNumberGenarationBCImpl();
			return bc.manageBkgReferenceNumberGeneration(divCd,officeCd,usrId);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	

	/**
	 * 중국지역 Bl no CheckDigit생성.<br>
	 * @param String blNo 
	 * @return BkgBlNoVO
	 * @throws EventException
	 */
		
	public BkgBlNoVO chnBlNoCheckDigit (String blNo )throws EventException {
		try {
			return dbDao.chnBlNoCheckDigit(blNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * MDM TABLE에 존재하는 코드 조회<br>
	 * 
	 * @param  comboParam
	 * @param String comboCd
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet seacrhMDMCombo (Map<String, Object> comboParam ,String comboCd ) throws EventException {
		try {
			if (comboCd.equals("MDM0001")){
				return dbDao.searchSvcLaneBound();
			}else{
				return new DBRowSet();
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * SlanCd,PodCd 존재체크.<br>
	 * @param String slanCd 
	 * @param String podCd 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchSvcLaneByLoc (String slanCd ,String podCd) throws EventException {
		try {
			return dbDao.searchSvcLaneByLoc(slanCd,podCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * Vendor code Check<br>
	 * @param String vendorCntCc 
	 * @param String vendorSeq
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkVenodrCode (String vendorCntCc ,String vendorSeq) throws EventException {
		try {
			return dbDao.checkVenodrCode(vendorCntCc,vendorSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Report Item 조회.<br>
	 * @param String rptId 
	 * @param String bkgRptKndCd 
	 * @return boolean
	 * @throws EventException
	 */
	public List <ReportItemVO> searchReportItemList (String rptId ,String bkgRptKndCd) throws EventException{
		
		try {
			return dbDao.searchReportItemList(rptId,bkgRptKndCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * report 용 Table,column 조회.<br>
	 * 
	 * @param String rptId 
	 * @param String bkgRptKndCd 
	 * @return List <ReportItemVO>
	 * @throws EventException
	 */
	public List <ReportItemVO> searchTblColList (String rptId ,String bkgRptKndCd) throws EventException{
		
		try {
			return dbDao.searchTblColList(rptId, bkgRptKndCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 전달받은 VVD와 POL, POD로 미주세관 신고 대상인지 확인한다<br>
	 * 	1. searchCanadaFROB()가 True면 "CA"를 return<br>
	 *	2. searchUsaFROB()가 True면 "US"를 retun<br>
	 *	3. 둘다 true이면 'AL'을 return<br>
	 *	4. 그외의 경우 "XX"를 return<br>
	 * @param String bkgNo 
	 * @param String bkgTrunkVvd 
	 * @param String polCd
	 * @param String podCd
	 * @return String
	 * @throws EventException
	 */
	public String searchFrob (String bkgNo, String bkgTrunkVvd ,String polCd, String podCd) throws EventException {
		String rtnValue = "XX";
		try {
			boolean isCanada = dbDao.searchCanadaFrob(bkgNo, bkgTrunkVvd, polCd, podCd);
			boolean isUsa = dbDao.searchUsaFrob(bkgNo, bkgTrunkVvd, polCd, podCd);
			if(isCanada && isUsa){
				rtnValue = "AL";
			}else{
				if(isCanada){
					rtnValue = "CA";	
				}else if(isUsa){
					rtnValue = "US";
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return rtnValue;
	}

    /**
     * 해당 bkg의 tro, cntr에 대해서 s/o가 issue 되었는지 조회한다.<br>
     * 
     * @param String troSeq
     * @param String cntrNo
     * @param BkgBlNoVO bkgBlNoVO
     * @param String boundCd
     * @return String
     * @throws EventException
     */
    public String searchSoStatus(String troSeq, String cntrNo, BkgBlNoVO bkgBlNoVO, String boundCd) throws EventException {
    	// TRS의 guide받은 후 작업 예정임     
    	String rtn;
    	try {
	        rtn = dbDao.searchSoStatus(bkgBlNoVO.getBkgNo(), cntrNo, boundCd);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
        return rtn;
    }	
    
    /**
	 * VSK_PF_SKD_DTL 테이블에서 SVC_LANE,SKD_DIR_CD 조건검색하여 Port cd List를 조회.<br>
	 * @param String vsl_slan_cd
	 * @param String skd_dir_cd
	 * @param String port_cd
	 * @return List<SearchSvcLaneBoundVO> 
	 * @throws EventException
	 */
	public List<SearchSvcLaneBoundVO> searchPortCdListByLane (String vsl_slan_cd,String skd_dir_cd, String port_cd) throws EventException {
		try {
			return dbDao.searchPortCdListByLane(vsl_slan_cd,skd_dir_cd,port_cd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}


	/**
	 * RFA의 가용성을 확인한다.<br>
	 * @param String rfaNo 
	 * @param BkgBlNoVO bkgBlNoVO 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchRfaAvailable (String rfaNo, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchRfaAvailable(rfaNo,bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	    

	/**
	 * SC NO의 가용성을 확인한다.<br>
	 * @param String scNo 
	 * @param BkgBlNoVO bkgBlNoVO 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchScAvailable (String scNo, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchScAvailable(scNo,bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	    		

	/**
	 * Taa NO의 가용성을 확인한다.<br>
	 * @param String taaNo 
	 * @param BkgBlNoVO bkgBlNoVO 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchTaaAvailable (String taaNo, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchTaaAvailable(taaNo,bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	    	


    /**
	 * Booking Split 번호를 조회<br>
	 * 
	 * @param String bkgNo
	 * @return List<SplitNoVO> 
	 * @throws EventException
	 */
	public List<SplitNoVO> searchBkgSplitNo (String bkgNo) throws EventException {
		try {
			return dbDao.searchBkgSplitNo(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

    /**
	 * Booking Split 번호를 조회<br>
	 * @param String bkgNo
	 * @param String size
	 * @return String 
	 * @throws EventException
	 */
	public String searchBkgSplitNoByOptional (String bkgNo, String size) throws EventException {
		StringBuffer html = new StringBuffer("");		
		try {
	        if(size == null || size.length() < 1 ){
	        	size = "5";
	        }
	        
	        html.append("<select name='bkg_split_no_list' size="+ size +" multiple onChange='javascript:bkgSplitNoList(this);' >\n");
	        List<SplitNoVO> bkgList = dbDao.searchBkgSplitNo(bkgNo);
	        SplitNoVO splitNoVO = null;
	        for(int i=0;i<bkgList.size();i++){
	        	splitNoVO = bkgList.get(i);
	            html.append("<option value='"+splitNoVO.getBkgNo()+"'>"+splitNoVO.getBkgNo()+"</option>\n");
	        }
	        html.append("</select>\n");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return html.toString();
	}

	
    /**
	 * 원 Booking의 BL번호를 조회<br>
	 * @param String bkgNo
	 * @return SplitMstBlNoVO 
	 * @throws EventException
	 */
	public SplitMstBlNoVO searchSplitMstBlNo (String bkgNo) throws EventException {
		try {
			return dbDao.searchSplitMstBlNo(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * bkg_hrd_cdg 테이블을 수정한다.<br>
	 * @param bkgHrdCdgCtntVOs
	 * @throws EventException
	 */
	public void manageHardCoding(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs) throws EventException {
		try {
			List<BkgHrdCdgCtntVO> addList = new ArrayList<BkgHrdCdgCtntVO>();
			List<BkgHrdCdgCtntVO> modList = new ArrayList<BkgHrdCdgCtntVO>();
			List<BkgHrdCdgCtntVO> delList = new ArrayList<BkgHrdCdgCtntVO>();

			for (int i=0; i<bkgHrdCdgCtntVOs.length; i++) {
				if ("I".equals(bkgHrdCdgCtntVOs[i].getIbflag())) {
					addList.add(bkgHrdCdgCtntVOs[i]);
				} else if ("U".equals(bkgHrdCdgCtntVOs[i].getIbflag())) {
					modList.add(bkgHrdCdgCtntVOs[i]);
				} else if ("D".equals(bkgHrdCdgCtntVOs[i].getIbflag())) {
					delList.add(bkgHrdCdgCtntVOs[i]);
				}
			}
			if (addList.size() > 0) {
				dbDao.addHardCoding(addList);
			}
			if (modList.size() > 0) {
				dbDao.modifyHardCoding(modList);
			}
			if (delList.size() > 0) {
				dbDao.removeHardCoding(delList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
     * PKG TYPE VALIDATION CHECK  <br>
     * @param  String pckTpCd
     * @return boolean 
     * @throws EventException
     */
    public boolean validatePkgType(String pckTpCd) throws EventException {
        try {
            return dbDao.validatePkgType(pckTpCd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * check HtsCode By Cm<br>
     * 
     * @param hamoTpCd
     * @param hamoTrfCd
     * @return String
     * @exception EventException
     */
    public String checkHtsCodeByCm(String hamoTpCd, String hamoTrfCd) throws EventException {
        try {
            return dbDao.checkHtsCodeByCm(hamoTpCd, hamoTrfCd);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
        }
    }
    
    /**
     * NCM Code Desc. 조회.<br>
     * 
     * @param ncmNo
     * @return String 
     * @exception EventException
     */
    public String searchNcmCodeDesc(String ncmNo) throws EventException {
        try {
            return dbDao.searchNcmCodeDesc(ncmNo);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
        }
    }
    
    /**
     * ESM_BKG_0079_02B : receive header String생성 <br>
     * @param String sndrId
     * @param String rcvId
     * @param String msgId
     * @return String 
     * @throws EventException
     */
    public String searchEdiHeader(String sndrId, String rcvId, String msgId)throws EventException {
        try {
            return dbDao.searchEdiHeader(sndrId, rcvId, msgId);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }    

    
    /**
     * ESM_BKG_0079_01 : VVD로 Lane 조회<br>
     * @author 	KimByungKyu
     * @param  	String vvd
     * @return 	String 
     * @throws EventException
     */
    public String searchSvcLaneByVvd(String vvd)throws EventException {
        try {
            return dbDao.searchSvcLaneByVvd(vvd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }       

    /**
     *  VVD 변경후 Save시, 승인 요청된 special cargo application이 있는 경우<br>
     * @author 	KimByungKyu  
     * @param 	BkgBlNoVO bkgBlNoVO
     * @return		Boolean
     * @throws EventException
     */
    public boolean searchSpclApplForChange(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchSpclApplForChange(bkgBlNoVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }    

    /**
     * P/O No 필수 여부 확인<br>
     *  미주향 BOOKING이면서 특정 화주의 경우 P/O No가 반드시 입력되어야함<br>
     * @author 	KimByungKyu  
     * @param 	String custCntCd
     * @param 	String custSeq
     * @param 	String scNo
     * @param 	BkgBlNoVO bkgBlNoVO
     * @return		Boolean
     * @throws EventException
     */
    public boolean searchPoNoLengthByDtl(String custCntCd, String custSeq, String scNo, BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchPoNoLengthByDtl(bkgBlNoVO,custCntCd, custSeq, scNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }  
    
    /**
     *  Manifest Transmit 공통 함수<br>
     * @author 	Kim Seung Min  
     * @param 	SendFlatFileVO sendFlatFileVO
     * @return	FlatFileAckVO flatFileAckVO
     * @throws EventException
     */    
	public FlatFileAckVO sendFlatFile(SendFlatFileVO sendFlatFileVO) throws EventException {
		FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		try {
			flatFileAckVO = eaoDao.sendFlatFile(sendFlatFileVO);
		}catch(EventException ex){
			throw ex;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

		return flatFileAckVO;
	}    


	/**
     *  MDM CMDT DESC 조회<br>
     * @param 	String cmdtCd
     * @return	String
	 * @throws Exception
	 * @throws EventException
     */
    public String searchMdmCmdtDesc(String cmdtCd) throws EventException {
        try {
            return dbDao.searchMdmCmdtDesc(cmdtCd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     *  MDM CMDT DESC 조회<br>
     * @param 	String cmdtCd
     * @return	String repcmdtCd
	 * @throws Exception
	 * @throws EventException
     */
    public String searchMdmCmdt(String cmdtCd) throws EventException {
        try {
            return dbDao.searchMdmCmdt(cmdtCd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     *  MDM REP CMDT NAME 조회<br>
     * @param 	String repCmdtCd
     * @return	String repCmdtNm
	 * @throws Exception
	 * @throws EventException
     */
    public String searchRepCmdtNm(String repCmdtCd) throws EventException {
        try {
            return dbDao.searchRepCmdtNm(repCmdtCd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    
    /**
     *  P/O 자리수 체크<br>
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
	 * @throws EventException
     */
    public String searchPoNoLength(BkgBlNoVO bkgBlNoVO) throws EventException{
    	try {
            return dbDao.searchPoNoLength(bkgBlNoVO);
    	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     *  화면안에서 security control<BR>
     *  특정 화면 open 시에 user ID 별 또는 user가 속한 country code 별로 <br>
     *  버튼 enable/disable 여부를 판단.<BR> 
     * @param AcssAlwInfoVO vo
     * @return boolean
     * @throws EventException
     */
    public boolean checkIfAccsIsAlw (AcssAlwInfoVO vo) throws EventException {
    	try {
            return dbDao.checkIfAccsIsAlw(vo);
    	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }

    
    /**
	 *  VSK_VSL_PORT_SKD 테이블에서 VVD 조건검색하여 Port cd List를 조회.<br>
	 * @param String vvd
	 * @return List<SearchPortCdByVvdVO> 
	 * @throws EventException
	 */
	public List<SearchPortCdByVvdVO> searchPortCdListByVvd (String vvd) throws EventException {
		try {
            return dbDao.searchPortCdListByVvd(vvd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	



    /**
     *  bkg no, cntr no로 mvmt의 container movement status를 조회한다.<br>
     *  
     * @author 	KimByungKyu  
     * @param 	BkgBlNoVO bkgBlNoVO
     * @param 	String cntrNo
     * @return		String[]
     * @throws EventException
     */
    public String[] searchMVMTStatus(BkgBlNoVO bkgBlNoVO, String cntrNo) throws EventException {
        try {
            return dbDao.searchMVMTStatus(bkgBlNoVO,cntrNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
	 *  COM_USER 테이블에서 ofc_cd 조건검색하여 STAFF 정보를 조회.<br>
	 * @param String ofc_cd
	 * @return List<StaffListByOfcCdVO> 
	 * @throws EventException
	 */
	public List<StaffListByOfcCdVO> searchStaffListByOfcCd (String ofc_cd) throws EventException {
		try {
            return dbDao.searchStaffListByOfcCd(ofc_cd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * BookingComboUtilDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * DMT_OFC_LVL_V에서 REGION 콤보리스트 조회-ESM_BKG_0226 <br>
	 * @return List<BkgComboVO>
	 * @throws EventException
	 */
	public List<BkgComboVO> searchRgnOfficeCd() throws EventException {
		try {
            return dbDao.searchRgnOfficeCd();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Memo Split 된 BKG에 대해서 최초에 생성된 BKG을 조회한다. <br>
	 * @author Lee NameKyung
	 * @param  BkgBlNoVO bkgBlNoVo
	 * @return MemoSplitMasterBkgVO
	 * @exception EventException
	 */
	public MemoSplitMasterBkgVO searchMemoSplitMstBkg(BkgBlNoVO bkgBlNoVo) throws EventException {
		try {
			return dbDao.searchMemoSplitMstBkg(bkgBlNoVo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * mdm currency code를 조회 <br>
	 * @author Lee NameKyung
	 * @param  String currCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmCurr(String currCd) throws EventException {
		try {
			return dbDao.searchMdmCurr(currCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 *  BKG의 CGO TYPE을 조회한다.<br>
     * @author 	KymByungKyu 
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return		String
	 * @throws EventException
	 */
	public String searchBkgCgoTp(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchBkgCgoTp(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	

    /**
     * Office Code로 Server ID를 조회한다.<br>
     * @author 	KimByungKyu
     * @param  	String ofcCd
     * @return 	String
	 * @throws EventException
	 */
	public String searchSvrByOfc(String ofcCd) throws EventException {
		try {
			return dbDao.searchSvrByOfc(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}		

    /**
     * Sender Id, Sender Tp Code(CUST)로 Host Id를 조회한다.<br>
     * 
     * @author 	Jun Yong Jin
     * @param  	String rcvId
     * @param  	String sndrTpCd
     * @return 	String
	 * @throws EventException
	 */
	public String searchEdi301HostId(String rcvId, String sndrTpCd) throws EventException {
		try {
			return dbDao.searchEdi301HostId(rcvId, sndrTpCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}		

    /**
     * Customer Alert 메시지를 조회한다.<br>
     * 
     * @author 	KimByungKyu
     * @param  	String custCntCd
     * @param  	String custSeq
     * @return 	String
	 * @throws EventException
	 */
	public String searchAlertCust(String custCntCd, String custSeq) throws EventException {
		try {
			return dbDao.searchAlertCust(custCntCd, custSeq);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}		

    /**
     * VVD코드로 VSL_NM을 조회한다.<br>
     * @author 	Jun Yong Jin
     * @param  	String vvd
     * @return 	String
     * @throws EventException
     */
    public String searchVslNm(String vvd) throws EventException {
        try {
            return dbDao.searchVslNm(vvd);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }

    /**
     * bkg의 cntr_no목록을 조회한다.<br>
     * @author 	Jun Yong Jin
     * @param 	BkgBlNoVO bkgBlNoVO
     * @return	String[]
     * @throws EventException
     */
    public String[] searchCntrListByBkg(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchCntrListByBkg(bkgBlNoVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }

    /**
     * [Tro] Prd로 보낼 parameter를 조회한다.<br>
     * 
     * @author 	 Lee NamKyung 
     * @param 	 PrdParameterVO prdParameterVO
     * @return   PrdParameterVO
     * @exception EventException
     */
    public PrdParameterVO searchPrdParmForInlandRoute(PrdParameterVO prdParameterVO) throws EventException {
    	
    	PrdParameterVO rtnPrdParameterVO = new PrdParameterVO();
    	
        try {   
        	//TransferOrderIssueBC.validateInlandRoute()로 대치함(20091209 류대영)        	
        	// 01. Location/zone 존재 여부 체크
//	        	String locCd  = "";
//	        	String nodeCd = "";
//	        	String znCd    = prdParameterVO.getPrdTroInfoVO().getDorZone();        	
//	        	if(znCd.length() > 5) {
//	        		locCd = znCd.substring(0,5);
//	        	}    		
//	    		if(!dbDao.searchZone(locCd, znCd)) {
//	    			throw new EventException((String)new ErrorHandler("BKG00268", new String[]{znCd}).getMessage());
//	    		}
//	    		
//	    		// 02. [Pkup] Location/node 존재여부 체크 
//	        	nodeCd = prdParameterVO.getPrdTroInfoVO().getTroPkupCy();
//	        	if(nodeCd.length() > 5) {
//	        		locCd = nodeCd.substring(0,5);
//	        	}
//	    		if(!dbDao.searchNodeCode(locCd, nodeCd)) {
//	    			throw new EventException((String)new ErrorHandler("BKG01041", new String[]{nodeCd}).getMessage());
//	    		}
//	        	
//	    		// 03. [Rtn] Location/node 존재여부 체크 
//	        	nodeCd = prdParameterVO.getPrdTroInfoVO().getTroRtnCy();
//	        	if(nodeCd.length() > 5) {
//	        		locCd = nodeCd.substring(0,5);
//	        	}
//	    		if(!dbDao.searchNodeCode(locCd, nodeCd)) {
//	    			throw new EventException((String)new ErrorHandler("BKG01041", new String[]{nodeCd}).getMessage());
//	    		}
        	
        	// 04. Booking 정보 : 변경
        	rtnPrdParameterVO.setPrdMainInfoVO(dbDao.searchPrdBkg(prdParameterVO.getPrdMainInfoVO(), prdParameterVO.getBkgBlNoVO()));
        	rtnPrdParameterVO.getPrdMainInfoVO().setPcMode(prdParameterVO.getPrdMainInfoVO().getPcMode());
        	// 05. Quantity 정보 : 변경
        	if(prdParameterVO.getPrdQtyInfo() == null || prdParameterVO.getPrdQtyInfo().size() < 1){
        		rtnPrdParameterVO.setPrdQtyInfo(dbDao.searchPrdQty(prdParameterVO.getBkgBlNoVO()));
        	}else{
        		rtnPrdParameterVO.setPrdQtyInfo(prdParameterVO.getPrdQtyInfo());
        	}
        	
        	// BkgBlNo 정보 : 유지 
        	rtnPrdParameterVO.setBkgBlNoVO(prdParameterVO.getBkgBlNoVO());
        	
        	// TroInfo 정보 : 유지 
        	rtnPrdParameterVO.setPrdTroInfoVO(prdParameterVO.getPrdTroInfoVO()); 
        	
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
        
        return rtnPrdParameterVO;
    }	
    
	/**
	 * 전체 운송구간을 PRD로부터 얻기전에 기본적인 VALIDATION을 수행한다.<br>
	 * PRD로 보낼 parameter를 조회한다.<br>
	 * 
     * @author 	KimByungKyu
	 * @param PrdParameterVO prdParameterVO
	 * @return PrdParameterVO
	 * @throws EventException
	 */
	public PrdParameterVO searchPrdParmForFullRoute(PrdParameterVO prdParameterVO) throws EventException {
    	PrdParameterVO rtnPrdParameterVO = new PrdParameterVO();
		try {
			PrdMainInfoVO prdMainInfoVO = prdParameterVO.getPrdMainInfoVO();

			if(prdMainInfoVO != null){
				// 01-01. POR LocationCode 유효성 검사
				String porCd = prdMainInfoVO.getPor();
				if(porCd != null && porCd.length() > 0){
					if(dbDao.searchLocationCode(porCd) == null){
						throw new EventException((String)new ErrorHandler("BKG00068",new String[]{porCd}).getMessage());
					}
				}
				// 01-02. POL LocationCode 유효성 검사
				String polCd = prdMainInfoVO.getPol();
				if(polCd != null && polCd.length() > 0){
					if(!porCd.equals(polCd)){
						if(dbDao.searchLocationCode(polCd) == null){
							throw new EventException((String)new ErrorHandler("BKG00065",new String[]{polCd}).getMessage());
						}
					}
				}
				// 01-03. POD LocationCode 유효성 검사
				String podCd = prdMainInfoVO.getPod();
				if(podCd != null && podCd.length() > 0){
					if(dbDao.searchLocationCode(podCd) == null){
						throw new EventException((String)new ErrorHandler("BKG00067",new String[]{podCd}).getMessage());
					}
				}

				// 01-04. DEL LocationCode 유효성 검사
				String delCd = prdMainInfoVO.getDel();
				if(delCd != null && delCd.length() > 0){				
					if(!podCd.equals(delCd)){
						if(dbDao.searchLocationCode(delCd) == null){
							throw new EventException((String)new ErrorHandler("BKG00066",new String[]{delCd}).getMessage());
						}
					}
				}				
				// 02-01. POR Node Code 유효성 검사
				String porNodeCd = "";
				if(prdMainInfoVO.getPorN() != null){
					porNodeCd = prdMainInfoVO.getPorN();
				}
				if(porCd != null && porCd.length() > 0){
					if(!dbDao.searchNodeCode(porCd, porNodeCd)){
						throw new EventException((String)new ErrorHandler("BKG01041",new String[]{porNodeCd}).getMessage());
					}
				}

				// 02-01. DEL Node Code 유효성 검사
				String delNodCd = "";
				if(prdMainInfoVO.getDelN() != null){
					delNodCd = prdMainInfoVO.getDelN();
				}
				if(delCd != null && delCd.length() > 0){	
					if(!dbDao.searchNodeCode(delCd, delNodCd)){
						throw new EventException((String)new ErrorHandler("BKG01041",new String[]{delNodCd}).getMessage());
					}
				}
				// 03-01. POL Marine Terminal 여부 확인
				String polYdCd = "";
				if(prdMainInfoVO.getPolN() != null){
					polYdCd = prdMainInfoVO.getPolN();
				}
				if(polCd != null && polCd.length() > 0){
					if(!dbDao.searchMarineYard(polCd, polYdCd)){
						throw new EventException((String)new ErrorHandler("BKG00272",new String[]{polYdCd}).getMessage());
					}
				}
				// 03-02. POD Marine Terminal 여부 확인(POD는 존재시만 체크)
				String podYdCd = "";
				if(prdMainInfoVO.getPodN() != null){
					podYdCd = prdMainInfoVO.getPodN();
				}				
				if(podCd != null && podCd.length() > 0){
					if(!dbDao.searchMarineYard(podCd, podYdCd)){
						throw new EventException((String)new ErrorHandler("BKG00272",new String[]{podYdCd}).getMessage());
					}
				}
				// 04. Trunk VVD로 Lane Validation
				String trunkVvd = prdMainInfoVO.getTVvd();
				String laneCd = "";
				if(isCheckVvdCd(trunkVvd)){
					laneCd = dbDao.searchSvcLaneByVvd(trunkVvd);
					if(laneCd == null || laneCd.length() < 1){
						throw new EventException((String)new ErrorHandler("BKG01004").getMessage());
					}
				}

				VslSkdVO vslSkdVO = new VslSkdVO();
				
				// 06. Ocean Route의 VVD 들이 ETD,ETA의 순서가 맞는지 확인(2건 이상일때만 수행)
				String vvd1 = prdMainInfoVO.getVvd1();
				String vvd2 = prdMainInfoVO.getVvd2();	
				if(isCheckVvdCd(vvd1) && isCheckVvdCd(vvd2)){
					String vslPodCd1      = prdMainInfoVO.getPod1();
					String vslPolCd2      = prdMainInfoVO.getPol2();
					String podClptIndSeq1 = prdMainInfoVO.getPod1C();	
					String polClptIndSeq2 = prdMainInfoVO.getPol2C();
					vslSkdVO.setBefVvd       (vvd1);
					vslSkdVO.setBefPodCd     (vslPodCd1);
					vslSkdVO.setBefClptIndSeq(podClptIndSeq1);
					vslSkdVO.setCurVvd       (vvd2);
					vslSkdVO.setCurPolCd     (vslPolCd2);
					vslSkdVO.setCurClptIndSeq(polClptIndSeq2);

					if(!dbDao.searchVslOrder(vslSkdVO)){
						throw new EventException((String)new ErrorHandler("BKG00079", new String[]{vvd2, vvd1}).getMessage());
					}					
				}
				
				// 06. Ocean Route의 VVD 들이 ETD,ETA의 순서가 맞는지 확인(2건 이상일때만 수행)
				String vvd3 = prdMainInfoVO.getVvd3();	
				if(isCheckVvdCd(vvd2) && isCheckVvdCd(vvd3)){
					String vslPodCd2      = prdMainInfoVO.getPod2();	
					String vslPolCd3      = prdMainInfoVO.getPol3();	
					String podClptIndSeq2 = prdMainInfoVO.getPod2C();	
					String polClptIndSeq3 = prdMainInfoVO.getPol3C();
					vslSkdVO.setBefVvd       (vvd2);
					vslSkdVO.setBefPodCd     (vslPodCd2);
					vslSkdVO.setBefClptIndSeq(podClptIndSeq2);
					vslSkdVO.setCurVvd       (vvd3);
					vslSkdVO.setCurPolCd     (vslPolCd3);
					vslSkdVO.setCurClptIndSeq(polClptIndSeq3);

					if(!dbDao.searchVslOrder(vslSkdVO)){
						throw new EventException((String)new ErrorHandler("BKG00079", new String[]{vvd2, vvd3}).getMessage());
					}					
				}	
				
				// 06. Ocean Route의 VVD 들이 ETD,ETA의 순서가 맞는지 확인(2건 이상일때만 수행)
				String vvd4 = prdMainInfoVO.getVvd4();	
				if(isCheckVvdCd(vvd3) && isCheckVvdCd(vvd4)){	
					String vslPodCd3      = prdMainInfoVO.getPod3();
					String vslPolCd4      = prdMainInfoVO.getPol4();
					String podClptIndSeq3 = prdMainInfoVO.getPod3C();
					String polClptIndSeq4 = prdMainInfoVO.getPol4C();
					vslSkdVO.setBefVvd       (vvd3);
					vslSkdVO.setBefPodCd     (vslPodCd3);
					vslSkdVO.setBefClptIndSeq(podClptIndSeq3);
					vslSkdVO.setCurVvd       (vvd4);
					vslSkdVO.setCurPolCd     (vslPolCd4);
					vslSkdVO.setCurClptIndSeq(polClptIndSeq4);

					if(!dbDao.searchVslOrder(vslSkdVO)){
						throw new EventException((String)new ErrorHandler("BKG00079", new String[]{vvd3, vvd4}).getMessage());
					}					
				}				
				
				// 08.PrdParameter 정보 조회
	        	// Booking 정보
	        	rtnPrdParameterVO.setPrdMainInfoVO(dbDao.searchPrdBkg(prdParameterVO.getPrdMainInfoVO(), prdParameterVO.getBkgBlNoVO()));
	        	rtnPrdParameterVO.getPrdMainInfoVO().setPcMode(prdParameterVO.getPrdMainInfoVO().getPcMode());
	        	
	        	// Quantity 정보
	        	if(prdParameterVO.getPrdQtyInfo() == null || prdParameterVO.getPrdQtyInfo().size() < 1){
	        		rtnPrdParameterVO.setPrdQtyInfo(dbDao.searchPrdQty(prdParameterVO.getBkgBlNoVO()));
	        	}else{
	        		rtnPrdParameterVO.setPrdQtyInfo(prdParameterVO.getPrdQtyInfo());
	        	}
	        	// BkgBlNo 정보
	        	rtnPrdParameterVO.setBkgBlNoVO(prdParameterVO.getBkgBlNoVO());				
			}else{
				// 데이터 저장 실패
				throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
			}
		} catch(EventException ex) {
			throw ex;	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);       
		}			
				
		return rtnPrdParameterVO; 
	}
	
	/**
	 * Pseudo VVD인지 여부 확인<br>
	 *
	 * @param String vvd
	 * @return  boolean
	 * @exception EventException
	 */
	private boolean isCheckVvdCd(String vvd){
		boolean isOk = false;
		if(vvd != null && vvd.length() > 0){
			if(!vvd.startsWith("HJXX") && !vvd.startsWith("HJYY") && !vvd.startsWith("HJZZ")){
				isOk = true;
			}
		}
		return isOk;
	}
	
    /**
	 *  BKG_SLS_REP 테이블 SREP_CD  정보를 조회합니다.<br>
	 * @param String ofc_cd
	 * @return List<SearchSrepCdListVO> 
	 * @throws EventException
	 */
	public List<SearchSrepCdListVO> searchSrepCdList (String ofc_cd) throws EventException {
		try {
            return dbDao.searchSrepCdList(ofc_cd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 세관 package (customsdeclaration)에서 사용하는 Flat File Header 생성 <br>
	 * 
	 * @author Min Dong Jin
	 * @param  String sndrId
	 * @param  String rcvId
	 * @param  String msgId
	 * @return String 
	 * @throws EventException
	 */
	public String searchCstmsEdiHeader(String sndrId, String rcvId, String msgId)throws EventException {
	    try {
	        return dbDao.searchCstmsEdiHeader(sndrId, rcvId, msgId);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	 
	/**
	 *  Booking 테이블의  ofc_cd값을 반환한다.<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String 
	 * @throws EventException
	 */
	public String searchBkgOfcByBkg(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
            return dbDao.searchBkgOfcByBkg(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

    /**
	 * EDI로 전송할 BKG의 Customer정보를 조회한다.<br>
	 * 
	 * @author 	Jun Yong Jin
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	String tpCd
	 * @param 	String autoManualFlg
	 * @return 	List<CustTpIdVO>
	 * @throws EventException
	 */
	public List<CustTpIdVO> searchEdiCustTpId(BkgBlNoVO bkgBlNoVO, String tpCd, String autoManualFlg) throws EventException {
		try {
			return dbDao.searchEdiCustTpId(bkgBlNoVO, tpCd, autoManualFlg);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * spilt 되기전 최초 mty bkg을 조회<br>
	 * @author	KimByungKyu
	 * @param 	String bkgNo
	 * @return 	String
	 * @throws EventException
	 */
	public String searchSplitMstBkgNo(String bkgNo) throws EventException{
		try {
            return dbDao.searchSplitMstBkgNo(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	

	/**
	 * GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(String OfficeCd)를 호출하는 method<br>
	 * 즉, Office Cd의 Local Time을 YYYY-MM-DD HH24:MI:SS 포맷의 string으로 반환<br>
	 * 
	 * @author	Min, DongJin
	 * @param 	String ofcCd
	 * @return 	String
	 * @throws EventException
	 */
	public String searchTimeLocalOfcFnc(String ofcCd) throws EventException{
		try {
            return dbDao.searchTimeLocalOfcFnc(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	

	/**
	 * GLOBALDATE_PKG.TIME_CONV_FNC 를 호출하는 method<br>
	 * User Local Time을 YYYY-MM-DD HH24:MI:SS 포맷의 string으로 반환<br>
	 * 
	 * @author	Jang, JiYoung
	 * @param 	String usrLocCd
	 * @return 	String
	 * @throws EventException
	 */
	public String searchLocalTime(String usrLocCd) throws EventException{
		try {
            return dbDao.searchLocalTime(usrLocCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * bkg no로 bkg_bl_iss에서 OBL_RLSE_FLG & BL_NO를 조회<br>
	 * @author Lee NameKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return OblIssVO
	 * @exception EventException
	 */
	public OblIssVO searchOblIssue(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchOblIssue(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Array를 정렬조건(compareName)를 기준으로 재정렬한다.<br>
	 * <br>
	 * 예) <br>
	 * ConfirmHldNtcSendListVO[] hldNtcSendLists = new ConfirmHldNtcSendListVO[];<br> 
	 * sortArray(hldNtcSendLists, "ntcEml");<br>
	 *  
	 * @param Object[] objects 정렬 대상
	 * @param String compareName 정렬 조건명
	 * @return Object[]
	 * @throws Exception
	 */
	public Object[] sortArray(Object[] objects, String compareName) throws Exception {
		
		Object temp = null;
		Object[] results = null;
		String str1, str2;
		int i, j, cnt = 0;
		
		if (objects == null || objects.length <= 1) return objects;
		
		String funcName = "get" + compareName.substring(0,1).toUpperCase() + compareName.substring(1);
		
		Method meth = objects[0].getClass().getMethod(funcName);
		
		for (i=0; i<objects.length; i++) 
		{
			str1 = (String) meth.invoke(objects[i]);
			
			for(cnt=0, j=i+1; j<objects.length; j++) 
			{
				str2 = (String) meth.invoke(objects[j]);
				
			    if(str1.compareTo(str2) == 0)
			    {
			    	cnt++;
			    				    	
				    temp = objects[i+cnt];
				    objects[i+cnt] = objects[j];
				    objects[j] = temp;
			    }
			}
			
			i = i + cnt;
		}
		
		results = objects;
		
		return results;
    }
	
   	/**
	 * 첫번째 sep만 split하여 리턴<br>
	 *
	 * @param String   str
	 * @param String   sep
	 * @return String[]
	 */
	public String[] splitByToken(String str, String sep){
		List<String> retList = new ArrayList<String>();
		String[] retStr = null;
		int idx = 0;
		if(str.indexOf(sep)>0){
			while(str.indexOf(sep)>-1){
				idx++;
		        int splitNo = str.indexOf(sep);
		        retList.add(str.substring(0, splitNo));
		        str = str.substring(splitNo+1, str.length());
		        if(str.length()==0) break;
		        if(idx>10000) break;// 무한 loop 방지
			} 
		}
		if(str.length()>0){
			retList.add(str);
		}		
		if(retList.size()==1){
			retList.add("");
		}
		retStr = new String[retList.size()];
        for(int i = 0;i<retList.size();i++){
        	retStr[i] = retList.get(i);
        }
        return retStr;
    }
	
   	/**
	 * PRD로 보내는 paramater를 log로 남긴다<br>
	 * 여러 군데 중복을 방지하기 위해 util로 이동함<br>
	 *  
	 * @param PrdMainInfoVO prdMainInfoVO
	 * @return String
	 */
	public String prdParameterLog(PrdMainInfoVO prdMainInfoVO) throws EventException{
		String prdLog = "";
		try {
			prdLog = "\n***** to PRD -> "  
				+ "bkg_no:"+prdMainInfoVO.getBkgNo() + ","
				+ "pcMode:"+prdMainInfoVO.getPcMode() + ","
				+ "Tvvd:"+prdMainInfoVO.getTVvd() + ","
				+ "R/D:["+prdMainInfoVO.getRcvT() + "/"+prdMainInfoVO.getDelT() + "],"
				+ "por:"+prdMainInfoVO.getPor() + "["+prdMainInfoVO.getPorN() + "],"
				+ "pol:"+prdMainInfoVO.getPol() + "["+prdMainInfoVO.getPolN() + "],"
				+ "pod:"+prdMainInfoVO.getPod() + "["+prdMainInfoVO.getPodN() + "],"
				+ "del:"+prdMainInfoVO.getDel() + "["+prdMainInfoVO.getDelN() + "]";
			if((prdMainInfoVO.getOrgTrnsMode().trim() + prdMainInfoVO.getDestTrnsMode()).trim().length()>0){
				prdLog = prdLog + "\ntrns:["+prdMainInfoVO.getOrgTrnsMode() + "/"+prdMainInfoVO.getDestTrnsMode()+ "]";
			}
	
			if((prdMainInfoVO.getMtPkupDt().trim() + prdMainInfoVO.getMPu().trim() + prdMainInfoVO.getFRt().trim()).length()>0){
				prdLog = prdLog + "\npkDt:["+prdMainInfoVO.getMtPkupDt()    + "],m_up:["+prdMainInfoVO.getMPu()  + "],f_rt:["+prdMainInfoVO.getFRt()  + "]";
			}

			if(prdMainInfoVO.getFlexHgtFlg() != null) {
				prdLog = prdLog + "\nflexHgtFlg:"+prdMainInfoVO.getFlexHgtFlg();
			}
			
			if(prdMainInfoVO.getPol1()!=null && prdMainInfoVO.getPod1()!=null && prdMainInfoVO.getVvd1()!=null &&
				(prdMainInfoVO.getPol1().trim() + prdMainInfoVO.getPod1().trim() + prdMainInfoVO.getVvd1().trim()).length()>0){
				prdLog = prdLog + "\n"
								+ "pol1:"+prdMainInfoVO.getPol1() + "["+prdMainInfoVO.getPol1N() + "]["+prdMainInfoVO.getPol1C() + "],"  
								+ "pod1:"+prdMainInfoVO.getPod1() + "["+prdMainInfoVO.getPod1N() + "]["+prdMainInfoVO.getPod1C() + "],"
								+ "vvd1:"+prdMainInfoVO.getVvd1() + "["+prdMainInfoVO.getLane1() + "]";
			}
			if(prdMainInfoVO.getPol2()!=null && prdMainInfoVO.getPod2()!=null && prdMainInfoVO.getVvd2()!=null &&
					(prdMainInfoVO.getPol2().trim() + prdMainInfoVO.getPod2().trim() + prdMainInfoVO.getVvd2().trim()).length()>0){			
				prdLog = prdLog + "\n"
								+ "pol2:"+prdMainInfoVO.getPol2() + "["+prdMainInfoVO.getPol2N() + "]["+prdMainInfoVO.getPol2C() + "],"
								+ "pod2:"+prdMainInfoVO.getPod2() + "["+prdMainInfoVO.getPod2N() + "]["+prdMainInfoVO.getPod2C() + "],"
								+ "vvd2:"+prdMainInfoVO.getVvd2() + "["+prdMainInfoVO.getLane2() + "]";
			}
			if(prdMainInfoVO.getPol3()!=null && prdMainInfoVO.getPod3()!=null && prdMainInfoVO.getVvd3()!=null &&
					(prdMainInfoVO.getPol3().trim() + prdMainInfoVO.getPod3().trim() + prdMainInfoVO.getVvd3().trim()).length()>0){	
				prdLog = prdLog + "\n"
								+ "pol3:"+prdMainInfoVO.getPol3() + "["+prdMainInfoVO.getPol3N() + "]["+prdMainInfoVO.getPol3C() + "],"
								+ "pod3:"+prdMainInfoVO.getPod3() + "["+prdMainInfoVO.getPod3N() + "]["+prdMainInfoVO.getPod3C() + "],"
								+ "vvd3:"+prdMainInfoVO.getVvd3() + "["+prdMainInfoVO.getLane3() + "]";
			}
			if(prdMainInfoVO.getPol4()!=null && prdMainInfoVO.getPod4()!=null && prdMainInfoVO.getVvd4()!=null &&
					(prdMainInfoVO.getPol4().trim() + prdMainInfoVO.getPod4().trim() + prdMainInfoVO.getVvd4().trim()).length()>0){	
				prdLog = prdLog + "\n"
								+ "pol4:"+prdMainInfoVO.getPol4() + "["+prdMainInfoVO.getPol4N() + "]["+prdMainInfoVO.getPol4C() + "],"
								+ "pod4:"+prdMainInfoVO.getPod4() + "["+prdMainInfoVO.getPod4N() + "]["+prdMainInfoVO.getPod4C() + "],"
								+ "vvd4:"+prdMainInfoVO.getVvd4() + "["+prdMainInfoVO.getLane4() + "]";
			}

//			dbDao.addBkgLog("BKG_PRD_LOG",prdMainInfoVO.getBkgNo(),prdLog);
//			log.error(prdLog);
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
//		log.debug(prdLog);
		return prdLog;
	}
	
   	/**
	 * bkg으로 해당 vvd, port에서 close 되었는지 확인하여<br>
	 * close 되어 있을 경우 해당 bkg으로 notice에 포함될 내용을 조회한다.<br>
	 * @author Ryu Daeyoung
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String ofcCd
	 * @return BkgCloseVO
	 * @exception EventException
	 */	
	public BkgCloseVO searchBkgClose(BkgBlNoVO bkgBlNoVO, String ofcCd) throws EventException{
		try {
            return dbDao.searchBkgClose(bkgBlNoVO, ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

   	/**
	 * bkg으로 해당 vvd, port에서 T/S close 되었는지 확인하여<br>
	 * @author Ryu Daeyoung
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<String>
	 * @exception EventException
	 */	
	public List<String> searchTsBkgClose(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
            return dbDao.searchTsBkgClose(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 입력받은 hard Query를 수행하여 결과를 실행하고 확인(ESM_BKG_0000.do).<br>
	 * 
	 * @param  String  sql
	 * @return String
	 * @throws EventException
	 */
	public String  executeQuery(String sql)  throws EventException{
		try {
			return dbDao.executeQuery(sql);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage());
			//throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
			//throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * user가 해당 bkg의 office에 있는지 확인<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  SignOnUserAccount account
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchOfcVsBkgOfc(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException{
		try{
			if(dbDao.searchOfcVsBkgOfc(bkgBlNoVO, account)){
				throw new EventException((String)new ErrorHandler("BKG02009").getMessage());
			} else {
				return true;
			}
		} catch(EventException se) {
			throw se;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * bkg의 pol의 service group id를 조회한다(기존 server id)<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchPolSvcByBkgNo(BkgBlNoVO bkgBlNoVO)  throws EventException{
		try{
			return dbDao.searchPolSvrByBkgNo(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
    
	/**
     * DEM.DET 모듈과 I/F 정보를 조합한다.
     * @param chargeByBookingCustomerGrpVO
     * @return dmtChargeVO
     * @throws EventException
     */
	@SuppressWarnings("unchecked")
	public DmtChargeVO searchChargeByCustomer(ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO)throws EventException {

		List<ToTBilAmtVO> bilAmtVOList = new ArrayList<ToTBilAmtVO>();
		DmtChargeVO dmtChargeVO = new DmtChargeVO();
         //왼쪽 합계(
        List<ChargeByBookingCustomerCntrVO> cntrVOList = new ArrayList<ChargeByBookingCustomerCntrVO>();
        
        //오른쪽합계
        List<ChargeByBookingCustomerInvVO> invVOList = new ArrayList<ChargeByBookingCustomerInvVO>();

        Iterator iterator  = chargeByBookingCustomerGrpVO.getChargeByBookingCustomerCntrVOS().iterator();
        Iterator iterator2 = chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS().iterator();


        Map map  = new HashMap();
        Map map2 = new HashMap();
        DecimalFormat df = new DecimalFormat("#.#");
		float sumVar = 0;
		float curVar = 0;

        while (iterator.hasNext()) {
            ChargeByBookingCustomerCntrVO cntrVO = (ChargeByBookingCustomerCntrVO) iterator.next();

            log.debug("------------------------- cntrVO1   "+cntrVO.getColumnValues());

            //DEM.DET 모듈에서 currCd를 VO의 currCd or bzcTrfCurrCd에 세팅하고 있음 두 값을 확인해서 있는 값을 써야 한다.
            //정말 어처구니 없는일이 아닐 수 없습니다.!!! 각성하라 !!
            log.debug("==============================");
            log.debug("DEM.DET CurrCd값 확인");
            log.debug("CurrCd       : "+cntrVO.getCurrCd());
            log.debug("BzcTrfCurrCd : "+cntrVO.getBzcTrfCurrCd());
            log.debug("==============================");
            //String currCd = cntrVO.getCurrCd() == null ? cntrVO.getBzcTrfCurrCd() : cntrVO.getCurrCd();
            //cntrVO.setCurrCd(currCd);
			
            //2010-01-11 DME.DET 이번에는 BzcTrfCurrCd로 currCd를 쓰란다. 빵꾸똥구들...
            cntrVO.setCurrCd(cntrVO.getBzcTrfCurrCd());

            if( null == cntrVO.getBilAmt()){
                cntrVO.setBilAmt("0");
            }

            if(!map.containsKey(cntrVO.getCurrCd())){
                map.put(cntrVO.getCurrCd(),0);
            }
            curVar = Float.valueOf(cntrVO.getBilAmt());        
            sumVar += curVar;
            map.put(cntrVO.getCurrCd(),df.format(sumVar).toString());
            cntrVOList.add(cntrVO);
        }
        dmtChargeVO.setChargeByBookingCustomerCntrVOS(cntrVOList);

        while (iterator2.hasNext()) {
            ChargeByBookingCustomerInvVO cntrVO = (ChargeByBookingCustomerInvVO) iterator2.next();

			log.debug("------------------------- cntrVO2   "+cntrVO.getColumnValues());

            if( null == cntrVO.getBilAmt()){
                cntrVO.setBilAmt("0");
            }

            if(!map2.containsKey(cntrVO.getInvCurrCd())){
                map2.put(cntrVO.getInvCurrCd(),0);
            }
            //갚은상태면 오른쪽합계에 추가한다.
            if(cntrVO.getDmdtArIfCd() != null && cntrVO.getDmdtArIfCd().equals("Y")){
                map2.put(cntrVO.getInvCurrCd(),Float.parseFloat(cntrVO.getBilAmt()) + Float.parseFloat(map2.get(cntrVO.getInvCurrCd()).toString()));
                invVOList.add(cntrVO);
            }
        }
        
		dmtChargeVO.setChargeByBookingCustomerInvVOS(invVOList);

		log.debug("-------------------------- left " + map);
        log.debug("-------------------------- right " + map2);

        Set a = map.keySet();
        Iterator b = a.iterator();
        while(b.hasNext()){
            String currCd = (String) b.next();

            ToTBilAmtVO bilAmtVo = new ToTBilAmtVO();
            log.debug("-------------------- currCd "+ currCd);
            if(currCd == null || currCd.equals("")){
            	bilAmtVo.setCurrCd("");
            }else{
            	bilAmtVo.setCurrCd(currCd);
            }
            
            //빼기 시작
            float leftSum = 0;
            float rightSum = 0;
            if(map.containsKey(currCd) && map.get(currCd) != null){
                leftSum = Float.parseFloat(map.get(currCd).toString());
            }
            if(map2.containsKey(currCd) && map2.get(currCd) != null){
                rightSum = Float.parseFloat(map2.get(currCd).toString());
            }
            bilAmtVo.setTotBilAmt("" + df.format(leftSum - rightSum));
            log.debug("---------- bilAmtVo "+ bilAmtVo.getColumnValues());
            bilAmtVOList.add(bilAmtVo);

        }
        //BILL AMT 추가
        dmtChargeVO.setBilAmtVOList(bilAmtVOList);

        //DemType
        log.debug("------------ setDemurType " + chargeByBookingCustomerGrpVO.getDemurType());
        dmtChargeVO.setDemurType(chargeByBookingCustomerGrpVO.getDemurType());
        return dmtChargeVO;
    }
	

	/**
	 * Route 변경시 Route정보를 조회한다.(ESM_BKG_0079_01)<br>
	 *
	 * @author 	KimByungKyu
	 * @param 	BookingCreationVO bookingCreationVO
	 * @return 	BookingSaveValidationVO
	 * @exception EventException
	 */
	public PrdParameterVO findFullRoute(BookingCreationVO bookingCreationVO) throws EventException {
		PrdParameterVO schPrdParameterVO = null;
		try{			
			// PrdMainInfoVO Set
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();
			BlCustomerInfoVO blCustomerInfoVO = bookingCreationVO.getBlCustomerInfoVO();
			VslSkdVO[] vslSkdVOs = bookingCreationVO.getVslSkdVOs();
			PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
			
			// bkg route
			prdMainInfoVO.setRcvT(bkgBookingInfoVO.getRcvTermCd());
			prdMainInfoVO.setDelT(bkgBookingInfoVO.getDeTermCd());
			prdMainInfoVO.setPor(bkgBookingInfoVO.getBkgPorCd());
			
			int tvvdSeq = 0;
			
			if(bkgBookingInfoVO.getBkgPorYdCd() != null && bkgBookingInfoVO.getBkgPorYdCd().length() > 0){
				prdMainInfoVO.setPorN(bkgBookingInfoVO.getBkgPorCd()+bkgBookingInfoVO.getBkgPorYdCd());
			}else{
				prdMainInfoVO.setPorN(null);
			}
			
			prdMainInfoVO.setPol(bkgBookingInfoVO.getBkgPolCd());
			if(bkgBookingInfoVO.getBkgPolYdCd() != null && bkgBookingInfoVO.getBkgPolYdCd().length() > 0){
				prdMainInfoVO.setPolN(bkgBookingInfoVO.getBkgPolCd()+bkgBookingInfoVO.getBkgPolYdCd());
			}else{
				prdMainInfoVO.setPolN(null);
			}			
			prdMainInfoVO.setPod(bkgBookingInfoVO.getBkgPodCd());
			if(bkgBookingInfoVO.getBkgPodYdCd() != null && bkgBookingInfoVO.getBkgPodYdCd().length() > 0){
				prdMainInfoVO.setPodN(bkgBookingInfoVO.getBkgPodCd()+bkgBookingInfoVO.getBkgPodYdCd());
			}else{
				prdMainInfoVO.setPodN(null);
			}						
			prdMainInfoVO.setDel(bkgBookingInfoVO.getBkgDelCd());
			if(bkgBookingInfoVO.getBkgDelYdCd() != null && bkgBookingInfoVO.getBkgDelYdCd().length() > 0){
				prdMainInfoVO.setDelN(bkgBookingInfoVO.getBkgDelCd()+bkgBookingInfoVO.getBkgDelYdCd());
			}else{
				prdMainInfoVO.setDelN(null);
			}							
			prdMainInfoVO.setTVvd(bkgBookingInfoVO.getBkgTrunkVvd());

			if(bkgBookingInfoVO.getBkgTrunkVvd() != null && bkgBookingInfoVO.getBkgTrunkVvd().length() > 0){
				if(!checkStringFormat("****NNNNC", bkgBookingInfoVO.getBkgTrunkVvd())){
					throw new EventException((String)new ErrorHandler("BKG00651", new String[]{"VVD:"+bkgBookingInfoVO.getBkgTrunkVvd()}).getMessage());
				}    
			}
			if("Y".equals(bkgBookingInfoVO.getTvvdModifyFlg())){
				for(VslSkdVO vo : vslSkdVOs) {
					tvvdSeq += 1;
					if(bkgBookingInfoVO.getBkgTrunkVvd().equals(vo.getBkgVvdCd())) {
						break;
					}
				}
			} else {
				tvvdSeq = 5; // T.VVD만 변경한 경우가 아니면 전체 VVD를 설정하기 위해서 5로 함 
			}
			
			//t/s route
			if(vslSkdVOs != null && vslSkdVOs.length > 0 && tvvdSeq > 0){
				prdMainInfoVO.setVvd1(vslSkdVOs[0].getBkgVvdCd());				
				prdMainInfoVO.setLane1(null);				
				prdMainInfoVO.setPol1(vslSkdVOs[0].getPolCd());
				prdMainInfoVO.setPol1C(vslSkdVOs[0].getPolClptIndSeq());
				if(vslSkdVOs[0].getPolYdCd() != null && vslSkdVOs[0].getPolYdCd().length() > 0){
					prdMainInfoVO.setPol1N(vslSkdVOs[0].getPolCd()+vslSkdVOs[0].getPolYdCd());
				}else{
					prdMainInfoVO.setPol1N(null);
				}
				prdMainInfoVO.setPod1(vslSkdVOs[0].getPodCd());
				prdMainInfoVO.setPod1C(vslSkdVOs[0].getPodClptIndSeq());
				if(vslSkdVOs[0].getPodYdCd() != null && vslSkdVOs[0].getPodYdCd().length() > 0){
					prdMainInfoVO.setPod1N(vslSkdVOs[0].getPodCd()+vslSkdVOs[0].getPodYdCd());
				}else{
					prdMainInfoVO.setPod1N(null);
				}						
			}else{
				prdMainInfoVO = resetNthRoute(prdMainInfoVO, 1);					
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 1 && tvvdSeq > 1){
				prdMainInfoVO.setVvd2(vslSkdVOs[1].getBkgVvdCd());
				prdMainInfoVO.setLane2(null);				
				prdMainInfoVO.setPol2(vslSkdVOs[1].getPolCd());
				prdMainInfoVO.setPol2C(vslSkdVOs[1].getPolClptIndSeq());
				if(vslSkdVOs[1].getPolYdCd() != null && vslSkdVOs[1].getPolYdCd().length() > 0){
					prdMainInfoVO.setPol2N(vslSkdVOs[1].getPolCd()+vslSkdVOs[1].getPolYdCd());
				}else{
					prdMainInfoVO.setPol2N(null);
				}					
				prdMainInfoVO.setPod2(vslSkdVOs[1].getPodCd());
				prdMainInfoVO.setPod2C(vslSkdVOs[1].getPodClptIndSeq());
				if(vslSkdVOs[1].getPodYdCd() != null && vslSkdVOs[1].getPodYdCd().length() > 0){
					prdMainInfoVO.setPod2N(vslSkdVOs[1].getPodCd()+vslSkdVOs[1].getPodYdCd());
				}else{
					prdMainInfoVO.setPod2N(null);
				}					
			}else{
				prdMainInfoVO = resetNthRoute(prdMainInfoVO, 2);				
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 2 && tvvdSeq > 2){
				prdMainInfoVO.setVvd3(vslSkdVOs[2].getBkgVvdCd());
				prdMainInfoVO.setLane3(null);				
				prdMainInfoVO.setPol3(vslSkdVOs[2].getPolCd());
				prdMainInfoVO.setPol3C(vslSkdVOs[2].getPolClptIndSeq());
				if(vslSkdVOs[2].getPolYdCd() != null && vslSkdVOs[2].getPolYdCd().length() > 0){
					prdMainInfoVO.setPol3N(vslSkdVOs[2].getPolCd()+vslSkdVOs[2].getPolYdCd());
				}else{
					prdMainInfoVO.setPol3N(null);
				}					
				prdMainInfoVO.setPod3(vslSkdVOs[2].getPodCd());
				prdMainInfoVO.setPod3C(vslSkdVOs[2].getPodClptIndSeq());
				if(vslSkdVOs[2].getPodYdCd() != null && vslSkdVOs[2].getPodYdCd().length() > 0){
					prdMainInfoVO.setPod3N(vslSkdVOs[2].getPodCd()+vslSkdVOs[2].getPodYdCd());
				}else{
					prdMainInfoVO.setPod3N(null);
				}					
			}else{
				prdMainInfoVO = resetNthRoute(prdMainInfoVO, 3);			
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 3 && tvvdSeq > 3){
				prdMainInfoVO.setVvd4(vslSkdVOs[3].getBkgVvdCd());
				prdMainInfoVO.setLane4(null);				
				prdMainInfoVO.setPol4(vslSkdVOs[3].getPolCd());
				prdMainInfoVO.setPol4C(vslSkdVOs[3].getPolClptIndSeq());
				if(vslSkdVOs[3].getPolYdCd() != null && vslSkdVOs[3].getPolYdCd().length() > 0){
					prdMainInfoVO.setPol4N(vslSkdVOs[3].getPolCd()+vslSkdVOs[3].getPolYdCd());
				}else{
					prdMainInfoVO.setPol4N(null);
				}				
				prdMainInfoVO.setPod4(vslSkdVOs[3].getPodCd());
				prdMainInfoVO.setPod4C(vslSkdVOs[3].getPodClptIndSeq());
				if(vslSkdVOs[3].getPodYdCd() != null && vslSkdVOs[3].getPodYdCd().length() > 0){
					prdMainInfoVO.setPod4N(vslSkdVOs[3].getPodCd()+vslSkdVOs[3].getPodYdCd());
				}else{
					prdMainInfoVO.setPod4N(null);
				}					
			}else{
				prdMainInfoVO = resetNthRoute(prdMainInfoVO, 4);				
			}		
		
			if(bkgBookingInfoVO.getLodgDueDt() != null){
				prdMainInfoVO.setLdDt(bkgBookingInfoVO.getLodgDueDt().replaceAll("-", ""));
			}		
			if(bkgBookingInfoVO.getMtyDorArrDt() != null){
				prdMainInfoVO.setDrDt(bkgBookingInfoVO.getMtyDorArrDt().replaceAll("-", ""));
			}		
			if(bkgBookingInfoVO.getMtyPkupDt() != null){
				prdMainInfoVO.setMtPkupDt(bkgBookingInfoVO.getMtyPkupDt().replaceAll("-", ""));
			}					
			prdMainInfoVO.setMPu(bkgBookingInfoVO.getMtyPkupYdCd());
			prdMainInfoVO.setFRt(bkgBookingInfoVO.getFullRtnYdCd());
			
			if(bkgBookingInfoVO.getOrgTrnsModCd()==null||bkgBookingInfoVO.getOrgTrnsModCd().length()<1 
                    || !bkgBookingInfoVO.getRcvTermCd().equals(bkgBookingInfoVO.getRcvTermCdOld())){
				prdMainInfoVO.setOrgTrnsMode("X");
			} else {
				prdMainInfoVO.setOrgTrnsMode(bkgBookingInfoVO.getOrgTrnsModCd());
			}
			if(bkgBookingInfoVO.getDestTrnsModCd()==null||bkgBookingInfoVO.getDestTrnsModCd().length()<1 
                    || !bkgBookingInfoVO.getDeTermCd().equals(bkgBookingInfoVO.getDeTermCdOld())){
				prdMainInfoVO.setDestTrnsMode("X");
			} else {
				prdMainInfoVO.setDestTrnsMode(bkgBookingInfoVO.getDestTrnsModCd());
			}
			if(bkgBookingInfoVO.getBkgCgoTpCd() != null){
				prdMainInfoVO.setCgoTp(bkgBookingInfoVO.getBkgCgoTpCd());
			}else{
				prdMainInfoVO.setCgoTp("N");
			}
			if(bkgBookingInfoVO.getHotDeFlg() != null){
				prdMainInfoVO.setPmF(bkgBookingInfoVO.getHotDeFlg());
			}else{
				prdMainInfoVO.setPmF("N");
			}			
			if(bkgBookingInfoVO.getDcgoFlg() != null){
				prdMainInfoVO.setDgF(bkgBookingInfoVO.getDcgoFlg());
			}else{
				prdMainInfoVO.setDgF("N");
			}					
			if(bkgBookingInfoVO.getRcFlg() != null){
				prdMainInfoVO.setRfF(bkgBookingInfoVO.getRcFlg());
			}else{
				prdMainInfoVO.setRfF("N");
			}					
			if(bkgBookingInfoVO.getAwkCgoFlg() != null){
				prdMainInfoVO.setAkF(bkgBookingInfoVO.getAwkCgoFlg());
			}else{
				prdMainInfoVO.setAkF("N");
			}					
			if(bkgBookingInfoVO.getBbCgoFlg() != null){
				prdMainInfoVO.setBbF(bkgBookingInfoVO.getBbCgoFlg());
			}else{
				prdMainInfoVO.setBbF("N");
			}					
			prdMainInfoVO.setRdF(bkgBookingInfoVO.getRdCgoFlg());
			prdMainInfoVO.setSocF(bkgBookingInfoVO.getSocFlg());
			prdMainInfoVO.setCom(bkgBookingInfoVO.getCmdtCd());
			prdMainInfoVO.setRepCom(bkgBookingInfoVO.getRepCmdtCd());
			prdMainInfoVO.setBkgOfc(bkgBookingInfoVO.getBkgOfcCd());
			prdMainInfoVO.setOrgSalOfc(bkgBookingInfoVO.getObSlsOfcCd());
			prdMainInfoVO.setRfa(bkgBookingInfoVO.getRfaNo());
			prdMainInfoVO.setSc(bkgBookingInfoVO.getScNo());
			prdMainInfoVO.setShpr(blCustomerInfoVO.getSCustCntCd()+blCustomerInfoVO.getSCustSeq());
			prdMainInfoVO.setCngn(blCustomerInfoVO.getCCustCntCd()+blCustomerInfoVO.getCCustSeq());
			prdMainInfoVO.setWgt(bkgBookingInfoVO.getActWgt());
			prdMainInfoVO.setWgtUn(bkgBookingInfoVO.getWgtUtCd());
			prdMainInfoVO.setHgF(bkgBookingInfoVO.getHngrFlg());
			prdMainInfoVO.setSubF(bkgBookingInfoVO.getEqSubstFlg());
			prdMainInfoVO.setFlexHgtFlg("Y".equals(bkgBookingInfoVO.getFlexHgtFlg())?"Y":"N");
			prdMainInfoVO.setIdaHlgTpCd(bkgBookingInfoVO.getIdaHlgTpCd());
			
			if(bookingCreationVO.getBkgBlNoVO().getBkgNo()==null||bookingCreationVO.getBkgBlNoVO().getBkgNo().length()==0){
				prdMainInfoVO.setBkgNo("");				
			} else {
				BkgBlNoVO schBkg = searchBkgBlNoVO(bookingCreationVO.getBkgBlNoVO());
				if(schBkg!=null){
					prdMainInfoVO.setBkgNo(bkgBookingInfoVO.getBkgNo());					
				} else {				
					prdMainInfoVO.setBkgNo("");
				}
			}
			
			// PrdQuantityVO Set
			List<PrdQtyInfoVO> prdQtyInfo 	= new ArrayList<PrdQtyInfoVO>();
			
			BkgQuantityVO[] bkgQuantityVOs = bookingCreationVO.getBkgQuantityVOs();
			for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
				PrdQtyInfoVO prdQtyInfoVO = new PrdQtyInfoVO();
				
				prdQtyInfoVO.setCTpsz(bkgQuantityVOs[i].getCntrTpszCd());
				prdQtyInfoVO.setCQty(bkgQuantityVOs[i].getOpCntrQty());
				
				prdQtyInfo.add(prdQtyInfoVO);
			}
			
			PrdParameterVO prdParameterVO = new PrdParameterVO();			
			prdParameterVO.setPrdQtyInfo(prdQtyInfo);
			prdParameterVO.setBkgBlNoVO(bookingCreationVO.getBkgBlNoVO());
			prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
			
			// f_cmd,pc_mode Set
			prdParameterVO.getPrdMainInfoVO().setFCmd("3");

			// 01. searchPrdParameter
			schPrdParameterVO = searchPrdParmForFullRoute(prdParameterVO);

//			schPrdParameterVO.getPrdMainInfoVO().setBkgNo(bkgBookingInfoVO.getBkgNo());
			if(schPrdParameterVO.getPrdMainInfoVO().getBkgNo() != null && schPrdParameterVO.getPrdMainInfoVO().getBkgNo().length() > 0){
				// split, tro, copy 구분자 필요
				schPrdParameterVO.getPrdMainInfoVO().setPcMode("R");
			}else{
				schPrdParameterVO.getPrdMainInfoVO().setPcMode("B");
			}
			
			// 조회 한 값보다 T/S ROUTE상에 입력한 값을 우선 반영
			if(vslSkdVOs != null && vslSkdVOs.length > 0 && tvvdSeq > 0){
				schPrdParameterVO.getPrdMainInfoVO().setVvd1(vslSkdVOs[0].getBkgVvdCd());				
				schPrdParameterVO.getPrdMainInfoVO().setLane1(null);	
		        if(vslSkdVOs[0].getBkgVvdCd() != null && vslSkdVOs[0].getBkgVvdCd().length() > 0){ 
		        	if(!checkStringFormat("****NNNNC", vslSkdVOs[0].getBkgVvdCd())){
		        		throw new EventException((String)new ErrorHandler("BKG00651", new String[]{"VVD:"+vslSkdVOs[0].getBkgVvdCd()}).getMessage());
		        	}
		        }
			}else{
				schPrdParameterVO.setPrdMainInfoVO(resetNthRoute(schPrdParameterVO.getPrdMainInfoVO(), 1));				
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 1 && tvvdSeq > 1){
				schPrdParameterVO.getPrdMainInfoVO().setVvd2(vslSkdVOs[1].getBkgVvdCd());
				schPrdParameterVO.getPrdMainInfoVO().setLane2(null);	
				if(vslSkdVOs[1].getBkgVvdCd() != null && vslSkdVOs[1].getBkgVvdCd().length() > 0){ 
			        if(!checkStringFormat("****NNNNC", vslSkdVOs[1].getBkgVvdCd())){
		                throw new EventException((String)new ErrorHandler("BKG00651", new String[]{"VVD:"+vslSkdVOs[1].getBkgVvdCd()}).getMessage());
			        }			
				}
			}else{
				schPrdParameterVO.setPrdMainInfoVO(resetNthRoute(schPrdParameterVO.getPrdMainInfoVO(), 2));					
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 2 && tvvdSeq > 2){
				schPrdParameterVO.getPrdMainInfoVO().setVvd3(vslSkdVOs[2].getBkgVvdCd());
				schPrdParameterVO.getPrdMainInfoVO().setLane3(null);			
				if(vslSkdVOs[2].getBkgVvdCd() != null && vslSkdVOs[2].getBkgVvdCd().length() > 0){ 
			        if(!checkStringFormat("****NNNNC", vslSkdVOs[2].getBkgVvdCd())){
		                throw new EventException((String)new ErrorHandler("BKG00651", new String[]{"VVD:"+vslSkdVOs[2].getBkgVvdCd()}).getMessage());
			        }	
				}
			}else{
				schPrdParameterVO.setPrdMainInfoVO(resetNthRoute(schPrdParameterVO.getPrdMainInfoVO(), 3));						
			}
			if(vslSkdVOs != null && vslSkdVOs.length > 3 && tvvdSeq > 3){
				schPrdParameterVO.getPrdMainInfoVO().setVvd4(vslSkdVOs[3].getBkgVvdCd());
				schPrdParameterVO.getPrdMainInfoVO().setLane4(null);				
				if(vslSkdVOs[3].getBkgVvdCd() != null && vslSkdVOs[3].getBkgVvdCd().length() > 0){ 
			        if(!checkStringFormat("****NNNNC", vslSkdVOs[3].getBkgVvdCd())){
		                throw new EventException((String)new ErrorHandler("BKG00651", new String[]{"VVD:"+vslSkdVOs[3].getBkgVvdCd()}).getMessage());
			        }
				}
			}else{
				schPrdParameterVO.setPrdMainInfoVO(resetNthRoute(schPrdParameterVO.getPrdMainInfoVO(), 4));					
			}		
			
			if(bkgBookingInfoVO.getBkgPorYdCd() == null || bkgBookingInfoVO.getBkgPorYdCd().length() == 0){
				schPrdParameterVO.getPrdMainInfoVO().setPorN(null);
			}
			if(bkgBookingInfoVO.getBkgPolYdCd() == null || bkgBookingInfoVO.getBkgPolYdCd().length() == 0){
				schPrdParameterVO.getPrdMainInfoVO().setPolN(null);				
			}
			if(bkgBookingInfoVO.getBkgPodYdCd() == null || bkgBookingInfoVO.getBkgPodYdCd().length() == 0){
				schPrdParameterVO.getPrdMainInfoVO().setPodN(null);
			}
			if(bkgBookingInfoVO.getBkgDelYdCd() == null || bkgBookingInfoVO.getBkgDelYdCd().length() == 0){
				schPrdParameterVO.getPrdMainInfoVO().setDelN(null);
			}
			if(bkgBookingInfoVO.getBkgTrunkVvd() == null || bkgBookingInfoVO.getBkgTrunkVvd().length() == 0){
				schPrdParameterVO.getPrdMainInfoVO().setTVvd(null);
			}
//			schPrdParameterVO.getPrdMainInfoVO().setOrgTrnsMode(null);
//			schPrdParameterVO.getPrdMainInfoVO().setDestTrnsMode(null);
			
			
		}catch(EventException e){
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return schPrdParameterVO;
	}
	/**
	 * Route 초기화 처리<br>
	 * @param 	PrdMainInfoVO prdMainInfoVO
	 * @param 	int i
	 * @return 	PrdMainInfoVO
	 */
	public PrdMainInfoVO resetNthRoute(PrdMainInfoVO prdMainInfoVO, int i){
		if(i==1){
			prdMainInfoVO.setPod1(null);
			prdMainInfoVO.setPod1N(null);
			prdMainInfoVO.setPod1C(null);
			prdMainInfoVO.setPol1(null);
			prdMainInfoVO.setPol1N(null);
			prdMainInfoVO.setPol1C(null);
			prdMainInfoVO.setVvd1(null);
			prdMainInfoVO.setLane1(null);			
		} else if(i==2){
			prdMainInfoVO.setPod2(null);
			prdMainInfoVO.setPod2N(null);
			prdMainInfoVO.setPod2C(null);
			prdMainInfoVO.setPol2(null);
			prdMainInfoVO.setPol2N(null);
			prdMainInfoVO.setPol2C(null);
			prdMainInfoVO.setVvd2(null);
			prdMainInfoVO.setLane2(null);			
		} else if(i==3){
			prdMainInfoVO.setPod3(null);
			prdMainInfoVO.setPod3N(null);
			prdMainInfoVO.setPod3C(null);
			prdMainInfoVO.setPol3(null);
			prdMainInfoVO.setPol3N(null);
			prdMainInfoVO.setPol3C(null);
			prdMainInfoVO.setVvd3(null);
			prdMainInfoVO.setLane3(null);
			
		} else if(i==4){
			prdMainInfoVO.setPod4(null);
			prdMainInfoVO.setPod4N(null);
			prdMainInfoVO.setPod4C(null);
			prdMainInfoVO.setPol4(null);
			prdMainInfoVO.setPol4N(null);
			prdMainInfoVO.setPol4C(null);
			prdMainInfoVO.setVvd4(null);
			prdMainInfoVO.setLane4(null);
		}
		return prdMainInfoVO;
	}
	
	/**
	 * Bkg Close시 출력할 메일 메시지 본문<br>
	 *
	 * @author 	KimByungKyu
	 * @param 	String[] strParam
	 * @param 	String msgType
	 * @return 	String
	 * @exception Exception
	 */
	public String makeBkgCloseMsg(String[] strParam, String msgType) throws Exception {
/*		
 		1. strParam
 		   1) msgType : B
 		    - strParam[0] : BkgNo
 		    - strParam[1] : PreVvd
 		    - strParam[2] : PrePolCd
 		    - strParam[3] : PrePodCd
 		    - strParam[4] : PreQtyVol
 		    - strParam[5] : PreCntrList
 		    - strParam[6] : NewVvd
 		    - strParam[7] : NewPolCd
 		    - strParam[8] : NewPodCd
 		    - strParam[9] : NewQtyVol
 		    - strParam[10] : NewCntrList
		2. msgType
		    - 'B' : Booking Create,Modify,Cancel
		 	- 'S' : Split
		 	- 'C' : Container
*/		 
		String closeBkgMsg = "";
		try{			
			if("B".equals(msgType)){
//				closeBkgMsg = "Below booking has been created(canceled or changed) after booking closing.<br>";	
				
//				closeBkgMsg = closeBkgMsg + "Please check the change and DO NOT FORGET TO UPDATE STOWAGE PLAN.<br><br>";
				closeBkgMsg = closeBkgMsg + "BKG No : ";
				if(strParam[0] != null && strParam[0].length() > 0){
					String[] bkgArr = splitByToken(strParam[0], ",");
					if(bkgArr.length < 5){
						closeBkgMsg = closeBkgMsg + strParam[0];
					}else{
						for(int i = 0 ; i < bkgArr.length ; i++){
							if(i < 1){
								closeBkgMsg = closeBkgMsg + bkgArr[i];
							}else{
								if(i%4 < 1){
									closeBkgMsg = closeBkgMsg + "<br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + bkgArr[i];
								}else{
									closeBkgMsg = closeBkgMsg + "," + bkgArr[i];
								}
							}
						}
					}					
				}				
				//20100222 mail body 변경
//				closeBkgMsg = closeBkgMsg + "<br><br>";
//				closeBkgMsg = closeBkgMsg + "[Previous]<br>";
//				closeBkgMsg = closeBkgMsg + "1st VVD : " + strParam[1] + "<br>";
//				closeBkgMsg = closeBkgMsg + "1st VVD POL / POD : " + strParam[2] + " / " + strParam[3] + "<br>";
//				closeBkgMsg = closeBkgMsg + "BKG Vol : " + strParam[4] + "<br>";
//				closeBkgMsg = closeBkgMsg + "CNTR No : ";
//				if(strParam[5] != null && strParam[5].length() > 0){
//					String[] preCntrArr = splitByToken(strParam[5], ",");
//					if(preCntrArr.length < 6){
//						closeBkgMsg = closeBkgMsg + strParam[5];
//					}else{
//						for(int i = 0 ; i < preCntrArr.length ; i++){
//							if(i < 1){
//								closeBkgMsg = closeBkgMsg + preCntrArr[i];
//							}else{
//								if(i%5 < 1){
//									closeBkgMsg = closeBkgMsg + "<br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + preCntrArr[i];
//								}else{
//									closeBkgMsg = closeBkgMsg + "," + preCntrArr[i];
//								}
//							}
//						}
//					}
//				}
				closeBkgMsg = closeBkgMsg + "<BR>";			
//				closeBkgMsg = closeBkgMsg + "[Current]<br>";
				closeBkgMsg = closeBkgMsg + "Current VVD : " + strParam[6] + "<BR>";
				closeBkgMsg = closeBkgMsg + "Current ROUTE : " + strParam[7] + "<BR>";
//				closeBkgMsg = closeBkgMsg + "Current Vol : " + strParam[9] + "<br>";
				closeBkgMsg = closeBkgMsg + "Current CNTR No : ";
				if(strParam[10] != null && strParam[10].length() > 0){
					String[] newCntrArr = splitByToken(strParam[10], ",");
					if(newCntrArr.length < 6){
						closeBkgMsg = closeBkgMsg + strParam[10];
					}else{
						for(int i = 0 ; i < newCntrArr.length ; i++){
							if(i < 1){
								closeBkgMsg = closeBkgMsg + newCntrArr[i];
							}else{
								if(i%5 < 1){
									closeBkgMsg = closeBkgMsg + "<br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + newCntrArr[i];
								}else{
									closeBkgMsg = closeBkgMsg + "," + newCntrArr[i];
								}
							}
						}
					}
				} else {
					closeBkgMsg = closeBkgMsg + "<BR>";
				}
				
				closeBkgMsg = closeBkgMsg + "Changes : <br><br><br>";	
				closeBkgMsg = closeBkgMsg + "Above booking has been changed. Please DO NOT FORGET TO UPDATE STOWAGE PLAN ACCORDINGLY.<BR>";
				closeBkgMsg = closeBkgMsg + "<br><br>";						
			}			
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw ex;			
		}
		return closeBkgMsg;
	}	
	
	/**
	 * Quantity가 변경되었는지 여부 확인<br>
	 *
	 * @author 	KimByungKyu
	 * @param 	List<BkgQuantityVO> oldBkgQuantity
	 * @param 	BkgQuantityVO[] newBkgQuantity
	 * @return 	boolean
	 * @exception Exception
	 */
	public boolean isChangeQty(List<BkgQuantityVO> oldBkgQuantity, BkgQuantityVO[] newBkgQuantity) throws Exception {
		boolean isQtyChange = false;
		try{			
			// Qty 증가여부를 판단하기 위해서 변경전 Quantity를 조회한다.
			// Cntr갯수가 많으면 "Y", Old에 없는 Cntr가 입력되면 "Y", 같은 Cntr의 Qty가 증감되면 "Y".(20090720 류대영수석)
			int oldQtyCnt = oldBkgQuantity.size();
			if(oldQtyCnt != newBkgQuantity.length){
				isQtyChange = true;
			}else{
				boolean isQtyUp = false;
				for(int j = 0 ; j < newBkgQuantity.length ; j++){
					int newCntrCnt = 0;
					for(int k = 0 ; k < oldQtyCnt ; k++){
						if(newBkgQuantity[j].getCntrTpszCd().equals(oldBkgQuantity.get(k).getCntrTpszCd()) ){									
							if(Float.compare(Float.parseFloat(newBkgQuantity[j].getOpCntrQty()), Float.parseFloat(oldBkgQuantity.get(k).getOpCntrQty())) != 0){
								// 같은 Cntr인데 Qty가 변경된 경우
								isQtyUp = true;
								break;
							}
						}else{
							newCntrCnt = newCntrCnt + 1;
						}
					}
					// 신규 Cntr
					if(oldQtyCnt == newCntrCnt){
						isQtyUp = true;
					}
					if(isQtyUp){
						break;
					}
				}
				if(isQtyUp){
					isQtyChange = true;
				}											
			}		
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw ex;			
		}
		return isQtyChange;
	}		

    /**
     *  미 세관신고로 download 이후 VVD, POD, DEL을 변경한 경우.(ESM_BKG_0079_01) <br>
     *
     * @author      KimByungKyu
     * @param       BkgBlNoVO bkgBlNoVO
     * @return      boolean
     * @exception   EventException
     */
    public boolean searchUsaCstmsDownload(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchUsaCstmsDownload(bkgBlNoVO);         
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
        }
    }
    
    /**
	 * BKG_CHN_AGN에 CHN_AGN_CD 존재 여부 조회 <br>
	 * 
	 * @param String chnAgnCd
	 * @param String delIncFlag
	 * @return String
	 * @exception EventException
	 */
	public String checkChnAgnCd(String chnAgnCd,String delIncFlag) throws EventException {
		try {
            return dbDao.checkChnAgnCd(chnAgnCd,delIncFlag);         
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
        }
	}    

    
	/**
	 * 중국 agent를 사용하는 지역인지 조회한다.(ESM_BKG_0079, 0229)<br>
	 *
	 * @author Ryu Daeyoung
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String searchChnAgtUse(String usrId) throws EventException {
		try {
			return dbDao.searchChnAgtUse(usrId);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Booking의 route 정보를 조회한다.(ESM_BKG_0079_07, 0178)<br>
	 *
	 * @author Jeon Sungjin
	 * @param String bkgNo
	 * @return BkgRouteVO
	 * @exception EventException
	 */
	public BkgRouteVO searchBkgRoute(String bkgNo) throws EventException {
		try {
			return dbDao.searchBkgRoute(bkgNo);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	

	/**
	 * 대표 email 및 ofc cd 구하는 함수 <br>
	 * <pre>
	 * gubun: EM EMAIL, OFC:OFC_CD
	 * </pre>
	 * @author Kim Gyoung sub
	 * @param String bkg_no
	 * @param String usr_id
	 * @param String gubun
	 * @param String blNtcKndCd
	 * @return String output_text
	 * @exception EventException
	 */
	public String searchGroupEmailAddrRSQL(String bkg_no, String usr_id, String gubun, String blNtcKndCd) throws EventException {
		try {
			return dbDao.searchGroupEmailAddrRSQL( bkg_no,  usr_id, gubun, blNtcKndCd);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * CC 로 처리 되는 대표 email 조회 <br>
	 * <pre>
	 * gubun: EM EMAIL, OFC:OFC_CD
	 * </pre>
	 * @author Kim Gyoung sub
	 * @param String bkg_no
	 * @param String usr_id
	 * @param String gubun
	 * @param String blNtcKndCd
	 * @return String output_text
	 * @exception EventException
	 */
	public String searchGroupCcEmailAddrRSQL(String bkg_no, String usr_id, String gubun, String blNtcKndCd) throws EventException {
		try {
			return dbDao.searchGroupCcEmailAddrRSQL( bkg_no,  usr_id, gubun, blNtcKndCd);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * Cc email address 구하는 함수 <br>
	 * @param String ntc_knd_cd
	 * @param String usr_id
	 * @return String output_text
	 * @exception EventException
	 */
	public String searchCcEmailAddrRSQL(String ntc_knd_cd, String usr_id) throws EventException {
		try {
			return dbDao.searchCcEmailAddrRSQL( ntc_knd_cd,  usr_id);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
    /**
     * VVD코드로 VSL_NM을 조회한다.<br>
     * @author 	Jun Yong Jin
     * @param  	String bkgNo
     * @return 	String
     * @throws EventException
     */
    public String searchFrtTerm(String bkgNo) throws EventException {
        try {
            return dbDao.searchFrtTerm(bkgNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }

    /**
     * 유럽 tro에 대해서 ctm에서 issue한 s/o가 있는지 조회한다..<br>
     * @author 	Ryu Dae Young
     * @param  	BkgBlNoVO bkgBlNoVO
     * @return 	String
     * @throws EventException
     */
	public String searchCtmSoStatus(BkgBlNoVO bkgBlNoVO) throws EventException {
    	String rtn;
    	//미사용, 저장 못하게 하는 validation이 아니라 carrier haulage만 unconfirm 처리하도록 변경함 
    	try {
	        rtn = dbDao.searchCtmSoStatus(bkgBlNoVO.getBkgNo());
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
        return rtn;
	}
	
    /**
     * VVD의 service type code를 조회한다(cca feeder 구분용).<br>
     * @author 	Ryu Dae Young
     * @param  	String vvd
     * @return 	String
     * @throws EventException
     */
	public String searchVslSvcTpCd(String vvd) throws EventException {
    	String rtn;
    	try {
	        rtn = dbDao.searchVslSvcTpCd(vvd);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
        return rtn;
	}
	
    /**
     * word wrap 기능.<br>
     * @author 	Ryu Dae Young
     * @param  	String word
     * @param   int length
     * @return 	String
     */
	@SuppressWarnings("unused")
	public String makeWordWrap(String word, int length){
		String rtn = "";
		String orgWord = word;
		try{
			int stopIdx = 0;
			int position = 0;
			String line = "";
			while(true){
				stopIdx++;
				if(stopIdx > 10000){
					break;
				}
				if(word.length() <= length){
					rtn = rtn + word;
					break;
				} else {
					position = 0;
					line = "";
					// 지정 length전에 줄 바꿈이 있으면 거기까지만 split
					for(int i = 1; i <= length + 2; i++){
						if("\n".equals(word.substring(i-1, i))){
							position = i;
							// 마지막 문자가 개행(\n)일 경우, 개행이 두번 반복되는걸 피하기 위해서 position 값을 재설정 해줌
							if(position == length + 2){
								position = position -1;
							}
						}
					}
					if(position == 0){
						//지정 length부터 거꾸로 공백을 찾아서 거기서 split
						line = word.substring(0, length + 1);
						for(int i = length + 1; i>0; i--){						
							if(" ".equals(word.substring(i-1, i)) || "\n".equals(word.substring(i-1, i))){
								position = i;
								i = 0;
							}
						}
					}
					if(position == 0){
						rtn = rtn + word.substring(0, length) + "\n";
						word = word.substring(length);
					} else {
						rtn = rtn + word.substring(0, position - 1) + "\n";
						word = word.substring(position);
					}
				}				
			}
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			return orgWord;
		}
		return rtn;
	}
		
    /**
     * VVD의 service type code를 조회한다(cca feeder 구분용).<br>
     * @author 	Jeon Sung Jin
     * @param  	String cnt_cd
     * @param  	String ste_cd
     * @return 	List<String>
     * @throws EventException
     */
	public List<String> searchStateByCountry(String cnt_cd, String ste_cd) throws EventException {
    	List<String> rtn;
    	try {
	        rtn = dbDao.searchStateByCountry(cnt_cd, ste_cd);
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
        return rtn;
	}

    /**
     * searchDocProcSkd<br>
     * @param BkgDocProcSkdVO bkgDocProcSkdVO
     * @param String caFlg
     * @return BkgDocProcSkdVO
     * @throws EventException
     */
    public BkgDocProcSkdVO searchDocProcSkd(BkgDocProcSkdVO bkgDocProcSkdVO,String caFlg) throws EventException {
        try {
            return dbDao.searchDocProcSkd(bkgDocProcSkdVO,caFlg);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * 해당 bkg이 NL 지역에 들리는 지 조회<br>
     * @param BkgBlNoVO BkgBlNoVO
     * @return String
     * @throws EventException
     */
	public String searchNlFlagByBkg(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
            return dbDao.searchNlFlagByBkg(bkgBlNoVO);
        } catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * LloydNo로 VSL_CD 조회<br>
	 * @param lloydNo String
	 * @param skdVoyNo String
	 * @param skdDirCd String
	 * @return String
	 * @throws EventException
	 */
	public String searchVslCdByLloydNo(String lloydNo, String skdVoyNo, String skdDirCd) throws EventException {
		try {
            return dbDao.searchVslCdByLloydNo(lloydNo, skdVoyNo, skdDirCd);
        } catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * searchMdmVslSvcLane  이벤트 처리<br>
	 * @param String slanCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmVslSvcLane(String slanCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchMdmVslSvcLane(slanCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 

	
	/**
	 * searchMdmLocPortName  이벤트 처리<br>
	 * @param String portCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmLocPortName(String portCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.searchMdmLocPortName(portCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 

	/**
	 * searchComUserInfo  이벤트 처리<br>
	 * @param String usrID
	 * @return String
	 * @exception EventException
	 */
	public ComUserVO searchComUserInfo(String usrID) throws EventException{
		ComUserVO comUserVo = null;
		try {
			comUserVo = dbDao.searchComUserInfo(usrID);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return comUserVo ;
	}

   	/**
	 * bkg으로 해당 vvd, port에서 CBF 되었는지 확인하여<br>
	 * CBF 되어 있을 경우 해당 bkg으로 notice에 포함될 내용을 조회한다.<br>
	 * @author Ryu Daeyoung
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return BkgCloseVO
	 * @exception EventException
	 */	
	public BkgCloseVO searchBkgCbf(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
            return dbDao.searchBkgCbf(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
     * 공통콤보 목록조회<br>
	 *
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchMdmCntrTpSz() throws EventException {
        try {
            return dbDao.searchMdmCntrTpSz();
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }

   	/**
	 * searchOfcChgProc<br>
	 * 
	 * @param OfcChgProcVO ofcChgProcVO
	 * @return OfcChgProcVO
	 * @exception EventException
	 */	
	public OfcChgProcVO searchOfcChgProc(OfcChgProcVO ofcChgProcVO) throws EventException{
		try {
            return dbDao.searchOfcChgProc(ofcChgProcVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * seacrhDocPerformanceUserCheck  이벤트 처리<br>
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String seacrhDocPerformanceUserCheck(String usrId) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.seacrhDocPerformanceUserCheck(usrId);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	} 
	
	/**
     * MDM Country code목록조회<br>
	 *
     * @return List<MdmCountryVO>
     * @exception EventException
     */
    public List<MdmCountryVO> searchMdmCnt() throws EventException {
        try {
            return dbDao.searchMdmCnt();
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }

	/**
	 * Black Customer(Iran) Check<br>
	 * @param String custNm
	 * @param String fullSchFlg
	 * @return String
	 * @throws EventException
	 */
	public String checkIranBlackCustomer (String custNm, String fullSchFlg)throws EventException {
		try {
			return dbDao.checkIranBlackCustomer(custNm, fullSchFlg);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Black Customer(EU) Check<br>
	 * @param String custNm
	 * @return String
	 * @throws EventException
	 */
	public String checkEuBlackCustomer (String custNm)throws EventException {
		try {
			return dbDao.checkEuBlackCustomer(custNm);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Black Customer(US) Check<br>
	 * @param String custNm
	 * @param String fullSchFlg
	 * @return String
	 * @throws EventException
	 */
	public String checkUsBlackCustomer (String custNm, String fullSchFlg)throws EventException {
		try {
			return dbDao.checkUsBlackCustomer(custNm, fullSchFlg);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * Black Customer(China) Check<br>
	 * @param String custNm
	 * @return String
	 * @throws EventException
	 */
	public String checkBkgBlackCustomer (String custNm)throws EventException {
		try {
			if(custNm != null && !"".equals(custNm)){
				// enter 제거, 특수문자->공란, 공란여러개->공란1개
				custNm = custNm.replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
				custNm = custNm.replace("~", " ").replace("!", " ").replace("@", " ").replace("#", " ").replace("$", " ").replace("%", " ");
				custNm = custNm.replace("^", " ").replace("&", " ").replace("*", " ").replace("(", " ").replace(")", " ").replace("_", " ");
				custNm = custNm.replace("+", " ").replace("`", " ").replace("-", " ").replace("=", " ").replace("{", " ").replace("}", " ");
				custNm = custNm.replace("|", " ").replace("[", " ").replace("]", " ").replace("\\", " ").replace(":", " ").replace(";", " ");
				custNm = custNm.replace("\"", " ").replace("'", " ").replace("/", " ").replace("<", " ").replace(">", " ").replace("?", " ");
				custNm = custNm.replace(",", " ").replace(".", " ");
				custNm = custNm.replace("  ", " ").replace("  ", " ").replace("  ", " "); 
			}
			return dbDao.checkBkgBlackCustomer(custNm);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * 금지어 포함 되었는 지 체크<br>
	 * @param String wordKnd
	 * @param String word
	 * @return String
	 * @throws EventException
	 */
	public String checkWordBlackList (String wordKnd, String word)throws EventException {
		try {
			return dbDao.checkWordBlackList(wordKnd, word);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * Charcoal, Calcium Hypochlorite Manufacturer가 있는지 체크<br>
	 * @param String rmk
	 * @return String
	 * @throws EventException
	 */
	public String checkChaCalHypoBlckList (String rmk)throws EventException {
		try {
			return dbDao.checkChaCalHypoBlckList(rmk);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Package Code 조회.<br>
	 * @param String pkgNm
	 * @return MdmPckTpVO
	 * @throws EventException
	 */
	public MdmPckTpVO searchPkgTypeByName(String pkgNm)throws EventException {
		try {
			return dbDao.searchPkgTypeByName(pkgNm);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * State Code 조회.<br>
	 * @param String steNm
	 * @return MdmStateVO
	 * @throws EventException
	 */
	public MdmStateVO searchSteCodeByName(String steNm)throws EventException {
		try {
			return dbDao.searchSteCodeByName(steNm);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Delivery Type Code 조회.<br>
	 * @param String deTpNm
	 * @return String
	 * @throws EventException
	 */
	public String searchDeTypeByName(String deTpNm)throws EventException {
		try {
			return dbDao.searchDeTypeByName(deTpNm);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Reefer Cargo Nature(Cooling) Type Code 조회.<br>
	 * @param String clngTpNm
	 * @return String
	 * @throws EventException
	 */
	public String searchCoolingTypeByName(String clngTpNm)throws EventException {
		try {
			return dbDao.searchCoolingTypeByName(clngTpNm);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Container Ventilation Type Code 조회.<br>
	 * @param String ventTpNm
	 * @return String
	 * @throws EventException
	 */
	public String searchVentilationTypeByName(String ventTpNm)throws EventException {
		try {
			return dbDao.searchVentilationTypeByName(ventTpNm);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 특정 Continent Code 를 조회한다.<br>
	 * @param String contiCd
	 * @return MdmContinentVO
	 * @throws EventException
	 */
	public MdmContinentVO searchContinentCode(String contiCd)throws EventException {
		try {
			return dbDao.searchContinentCode(contiCd);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * front Office email address 구하는 함수 <br>
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchFntEmailAddrRSQL(String bkgNo) throws EventException {
		try {
			return dbDao.searchFntEmailAddrRSQL(bkgNo);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * seacrhManualBdrUserCheck  이벤트 처리<br>
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String seacrhManualBdrUserCheck(String usrId) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.seacrhManualBdrUserCheck(usrId);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return resultExist ;
	} 
    /**
     * 날짜 가감 기능.<br>
     * @param  	String StrDate
     * @param   int addDt
     * @return 	String
     */
	public String addDate(String StrDate, int addDt){
		
		int yy = 0;
		int mm = 0;
		int dd = 0;
		String tmData = "";
		String rtn = "";
		try{
			Calendar cal = Calendar.getInstance();
			yy = Integer.parseInt(StrDate.substring(0,4));
			mm = Integer.parseInt(StrDate.substring(4,6));
			dd = Integer.parseInt(StrDate.substring(6,8));	
			tmData = StrDate.substring(8);
			
			cal.set(yy, mm-1, dd);
			cal.add(Calendar.DATE, addDt); 

			yy = cal.get(Calendar.YEAR);
			mm = cal.get(Calendar.MONTH)+1;
			dd = cal.get(Calendar.DATE);
		
			rtn = "" + yy + (mm < 10 ? "0" + mm : mm) + (dd < 10 ? "0" + dd : dd) + tmData;

		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
		}
		return rtn;
	}
	
	
	/**
     *  ESM_BKG_0079_01 화면에서 SC No. or RFA No. or TAA No.
     *  화면에서 SC No. or RFA No. or TAA No. Text 클릭시 신규 생성된 Pricing 팝업화면으로의 연결 변경.
     *  
     * @author 		Cho wonjoo
     * @param  		String ctrtType
     * @param  		String ctrtNo
     * @param  		String bkgNo
     * @return 		String
	 * @exception   EventException
	 */	
	public String searchAmdtSeq(String ctrtType, String ctrtNo, String bkgNo) throws EventException {
		try {
			return  dbDao.searchAmdtSeq(ctrtType, ctrtNo, bkgNo);
		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
     *  ESM_BKG_0587 화면에서 Booking Close, Re-open 버튼 클릭시 Office 권한 체크
     *  
     * @param  		BkgCoffTmVO[] bkgCoffTmVOs
     * @param  		SignOnUserAccount account
     * @return 		boolean
	 * @exception   EventException
	 */	
	public boolean checkOfcAuth(BkgCoffTmVO[] bkgCoffTmVOs, SignOnUserAccount account) throws EventException {
		try {
//			for ( int i=0; i<bkgCoffTmVOs.length; i++ ) {
				return  dbDao.checkOfcAuth(bkgCoffTmVOs[0], account);
//			}
		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
     * 조회 이벤트 처리<br>
     * SVC Conti 목록을 조회한다.(콤보용)<br>
     * 
     * @return List<ContinentCodeVO>
     * @throws EventException
     */
	public List<ContinentCodeVO> searchSvcContiCd() throws EventException{
        try {
            return dbDao.searchSvcContiCd();
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
	
	/**
	 * 로그를 기록한다.<br>
	 * 
	 * @param String modName
	 * @param String applInfo
	 * @param String logDesc
	 * @exception DAOException
	 */
	public void addBkgLog(String modName, String applInfo, String logDesc) throws EventException{
        try {
            	dbDao.addBkgLog(modName,applInfo,logDesc);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
	
	
	/**
	 *  ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회<br>
	 *
	 * @author Kim Gyoung-Sub
	 * @param BkgCstmsHrdCdgCtntVO bkgCstmsHrdCdgCtntVO
	 * @return List<BkgCstmsHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgCstmsHrdCdgCtntVO> searchCstmsHardCodingList(BkgCstmsHrdCdgCtntVO bkgCstmsHrdCdgCtntVO)throws EventException{
		
		try {
			return dbDao.searchCstmsHardCodingList(bkgCstmsHrdCdgCtntVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 *  B/L Confirm, B/L Issue 상태를 체크한다.
	 * @param bkgNo
	 * @return string 
	 * @throws EventException
	 */
	public String checkBkgIssStatus(String bkgNo) throws EventException {
	  try { 
	    	String ret = dbDao.checkBkgIssStatus(bkgNo);
			return ret;	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}	
	}
	
	
	/**
	 * String의 format을 확인한다.
	 * @param String format
	 * @param String str
	 * @return EventException
	 */
	public Boolean checkStringFormat(String format, String str){
		
		// email format check
		if(format != null  && "email".equals(format)){
			Boolean existAtMark = false;
			Boolean existDot = false;
			String curStr = "";
			for(int i = 0; i < str.length(); i++){
				curStr = str.substring(i, i + 1);
				if("@".equals(curStr)){
					existAtMark = true;
				}
				
				if(existAtMark){
					if(".".equals(curStr)){
						existDot = true;
					}
				}
			}
			
			if(existAtMark && existDot){
				return true;
			} else {
				return false;
			}
		} 
		// check if there's no character
		if(format != null  && "NOT_C".equals(format)){
			Boolean existChar = false;
			char curStr;
			int curStrAscii = 0;

			for(int i = 0; i < str.length(); i++){
				curStr = str.toCharArray()[i];
				curStrAscii = (int)curStr;
				if( curStrAscii >= 65 && curStrAscii <= 90 ){		
					existChar = true;
				} else if ( curStrAscii >= 97 && curStrAscii <= 122 ){
					existChar = true;
				}
			}
			if(existChar){
				return false;
			} else {
				return true;
			}
			
		}
		
		if(format == null || str == null ||
				format.length() == 0 || format.length() != str.length()){
			return false;
		}
		
		/* other format check
		 * * : anything
		 * C : character (upper case)
		 * c : character (lower case)
		 * N : numeric
		 * - : hyphen 
		 */
		int strLength = format.length();
		String curFormat = null;
		char curStr; 
		int curStrAscii = 0;
		for(int i = 0; i < strLength; i++){
			curFormat = format.substring(i, i + 1);
			curStr = str.toCharArray()[i];
			curStrAscii = (int)curStr;

			if( "*".equals(curFormat) ){
				continue;
			} else if( "C".equals(curFormat) ){
				if( curStrAscii >= 65 && curStrAscii <= 90 ){
					continue;
				} else {
					return false;
				}
			} else if( "c".equals(curFormat) ){
				if( curStrAscii >= 97 && curStrAscii <= 122 ){
					continue;
				} else {
					return false;
				}
			} else if("N".equals(curFormat)){
				if( curStrAscii >= 48 && curStrAscii <= 57 ){
					continue;
				} else {
					return false;
				}				
			} else if("-".equals(curFormat)){
				if( curStrAscii == 45 ){
					continue;
				} else {
					return false;
				}								
			}
		}
		return true;
	}
	
	
	/**
	 * Iran Sanction 관련 CM 특정 HS 코드
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */
	public List<BkgHrdCdgCtntVO> searchSanctionHsCdList(BkgBlNoVO bkgBlNoVO) throws EventException {
		
		try { 
			return dbDao.searchSanctionHsCdList(bkgBlNoVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	   
	   /**
	    * Booking Creation 판매팀 코드 조회<br>
	    * 
	    * @param String ofcCd
	    * @return List<MdmSlsRepVO>
	    * @throws EventException
		 * 
	    */
	   public List<MdmSlsRepVO> searchSalesTeamList(String ofcCd) throws EventException {
	       try {
	           return dbDao.searchSalesTeamList(ofcCd);
	       } catch (DAOException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
			}
	   }
	
	/**
     * Bkg Hard Coding 데이타 확인.<br>
     * 
     * @param  BkgHrdCdgCtntVO bkgHrdCdgCtntVO
     * @param  SignOnUserAccount account
     * @return boolean 
     * @exception EventException
     */
   public boolean checkBkgHrdCdgCtnt(BkgHrdCdgCtntVO bkgHrdCdgCtntVO, SignOnUserAccount account) throws EventException {
		try {
			// Bkg Hard Coding 데이타 확인
			
			// AttrCtnt1 이 'CNT' 이면 AttrCtnt1, AttrCtnt2만 조건으로 주고 해당항목인지 체크한다.
			if("CNT".equals(bkgHrdCdgCtntVO.getAttrCtnt1())) {
				String attrCtnt3 = bkgHrdCdgCtntVO.getAttrCtnt3();
				bkgHrdCdgCtntVO.setAttrCtnt3("");
				BkgHrdCdgCtntVO vo1 = dbDao.checkBkgHrdCdgCtnt(bkgHrdCdgCtntVO);
				if(vo1 != null) {	// 체크 대상
					bkgHrdCdgCtntVO.setAttrCtnt3(attrCtnt3);
					BkgHrdCdgCtntVO vo2 = dbDao.checkBkgHrdCdgCtnt(bkgHrdCdgCtntVO);
					if (vo2 != null)
						return true;
					else
						return false;
				}
				else 
					return false;
			}
			else if("BKG".equals(bkgHrdCdgCtntVO.getAttrCtnt1())) {
				BkgHrdCdgCtntVO vo3 = dbDao.checkBkgHrdCdgCtnt(bkgHrdCdgCtntVO);
				if (vo3 != null)
					return true;
				else
					return false;
			}
			else if("DATE".equals(bkgHrdCdgCtntVO.getAttrCtnt1())) {
				BkgHrdCdgCtntVO vo4 = dbDao.checkBkgHrdCdgCtnt(bkgHrdCdgCtntVO);
				if (vo4 == null)
					return true;
				else
					return false;
			}
			
			return true;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),
					ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
   
   /**
    * 장애 방지를 위해 에러가 발생 가능한 로직에 대하여 적용 유무를 관리 하여 로직 롤백을 간단하게 할수 있도록 한다.<br>
    * 
    * @param  BkgHrdCdgCtntVO bkgHrdCdgCtntVO
    * @param  SignOnUserAccount account
    * @return boolean 
    * @exception EventException
    */
  public boolean checkBkgAplFlg(BkgHrdCdgCtntVO bkgHrdCdgCtntVO, SignOnUserAccount account) throws EventException {
		boolean rValue = false;
		try {
			// Hard Coding ID 와 Contenct1 이 입력 되었는지 확인 한다.
			if(null != bkgHrdCdgCtntVO.getHrdCdgId() && !"".equals(bkgHrdCdgCtntVO.getHrdCdgId()) && null != bkgHrdCdgCtntVO.getAttrCtnt1() && !"".equals(bkgHrdCdgCtntVO.getAttrCtnt1())) {
				BkgHrdCdgCtntVO vo = dbDao.checkBkgAplFlg(bkgHrdCdgCtntVO);
				if(null != vo){
					rValue = true;
				}else{
					rValue = false;
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),	ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return rValue;
	}
   
	/**
	 * 자동전송 Group ID와 BKG 접수 경로를 등록해 놓고 해당 될 경우 처리되게 함
	 * @param String bkgNo
	 * @return CustTpIdVO
	 * @throws EventException
	 */
	public CustTpIdVO searchCustTpIdInfo(String bkgNo) throws EventException{
		CustTpIdVO custTpIdVO = null;
		try {
			custTpIdVO = dbDao.searchCustTpIdInfo(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return custTpIdVO ;
	}
	
	/**
	 * 해당 str 가 Number 인지 확인 한다<br>
	 *
	 * @param String str
	 * @return Boolean
	 */
	public boolean isNumberChk( String str ) {
		boolean returnValue = true;
		if ( str == null || str.equals("") ) returnValue = false;
		for ( int i=0; i<str.length() ; i++ ) {
			char ch = str.charAt(i);
			if ( ch < 48 || ch > 59 ) {
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}
	
	/**
	 * searchBlRouteInfo 조회 이벤트 처리<br>
	 * 007909 에서 Route 정보 변경 History 관리 <br>
	 * 
	 * @author 
	 * @param String bkgNo
	 * @return BlIssInfoVO 
	 * @throws EventException
	 */
	public BlIssInfoVO searchBlRouteInfo(String bkgNo) throws EventException{
		BlIssInfoVO blIssInfoVO = null;
		try {
			blIssInfoVO = dbDao.searchBlRouteInfo(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return blIssInfoVO ;
	}
	
	/**
	 * search0726BlprnUsr 이벤트 처리<br>
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String search0726BlprnUsr(SignOnUserAccount account) throws EventException{
		String cfmFlg = "N";
		try {
			cfmFlg = dbDao.search0726BlprnUsr(account);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return cfmFlg ;
	}
	
	 /**
     * existCustomsEntryCode <br>
     * existCustomsEntryCode 존재여부 판단 <br>
     * @author Kim Tae Kyoung
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
    public String existCustomsEntryCode(String input_text)throws EventException {
        try {
            return dbDao.existCustomsEntryCode(input_text);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
	 /**
     * searchFukushimaUsedCmdt <br>
     * fukushima의 used commodity가 특정 pod로 가는지 확인함 <br>
     * @author Ryu DAe Young
     * @param BkgBlNoVO bkgBlNoVO
     * @param String cmdtCd
     * @param String cstmsDesc
     * @throws EventException
     */
    public void searchFukushimaUsedCmdt(BkgBlNoVO bkgBlNoVO, String cmdtCd, String cstmsDesc) throws EventException {
        try {
            String fukushimaUsedCmdt = dbDao.searchFukushimaUsedCmdt(bkgBlNoVO, cmdtCd, cstmsDesc);
            if(fukushimaUsedCmdt.equals("Y")){
            	throw new EventException(new ErrorHandler("BKG08273").getMessage());            	
            }
        } catch (EventException e){
        	throw e;
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
   /**
    * searchIranToOrdBl <br>
    * IRAN에 Order B/L이 출항, 입항하는지 확인함 <br>
    * @author Ryu DAe Young
    * @param BkgBlNoVO bkgBlNoVO
    * @throws EventException
    */
    public void searchIranToOrdBl(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            String iranToOrdBl = dbDao.searchIranToOrdBl(bkgBlNoVO);
            if(iranToOrdBl.equals("Y")){
            	throw new EventException(new ErrorHandler("BKG08274").getMessage());            	
            }
        } catch (EventException e){
        	throw e;
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /* getNotificationTemplated 
     * 고객 notice의 한국어, 중국어, 영어 email body를 가져온다
     * @author Ryu Dae Young
     * @param String ntcKnd
     * @param String lang
     * @param String[] arg
     * @return StringBuilder[]
     */
    public StringBuilder[] getNotificationTemplated(String ntcKnd, String [] arg) throws EventException {
    	StringBuilder[] template = new StringBuilder[3];
    	template[0] = new StringBuilder(); // title
    	template[1] = new StringBuilder(); // body
    	template[2] = new StringBuilder(); // body
    	String lang = "";
    	String bkgNo = "";
    	
        try {    	
	    	if(ntcKnd.equals("BK")){ // booking receipt
	    		bkgNo = arg[0];
	        	lang = dbDao.searchBkgCustCntCd("S", bkgNo);
	        	if(arg.length > 1 && arg[1] != null && arg[1].length() > 0){
	        		bkgNo = arg[1];
	        	}
	        	String vslNm = dbDao.searchVesselNameByBkgNo(bkgNo);
	        	
	        	// booking receipt는 title은 기존 처리로 함
	    		if(lang.equals("CN")){
//	    			template[0].append("森罗订舱接受通知 (订舱号:"+ bkgNo + ")");
	    			template[1].append("森罗订舱接受通知（订舱号:"+ bkgNo + ")");
	    			template[1].append("\n\n亲爱的顾客,");
	    			template[1].append("\n您的订舱已经被接受.");
	    			template[1].append("\n-订舱号："+ bkgNo);
	    			if(vslNm!=null && vslNm.length() > 0){
	    				template[1].append("\n-船名："+ vslNm);
	    			}
	    			template[1].append("\n假如您发现附上的订舱接受通知上的信息由任何不符，请告知我们所需要修改的地方.");
					template[1].append("\n\n森罗商船");
					template[1].append("\n若想获取更多关于获取的详细信息，请登录我们公司的网站 http://www.smlines.com");
	    		} else if(lang.equals("KR")){    			
//	    			template[0].append("SM상선 예약 수신 통지 서비스 (예약 번호:"+ bkgNo + ")");
					template[1].append("SM상선 예약 수신 통지 서비스（예약 번호:"+ bkgNo + ")");	
					template[1].append("\n\n고객님께서 요청하신 선적 예약이 정상적으로 처리되었음을 알려드립니다.");
					template[1].append("\n-예약번호："+ bkgNo);
					if(vslNm!=null && vslNm.length() > 0){
						template[1].append("\n-선박정보："+ vslNm);
					}
					template[1].append("\n첨부된 Booking Receipt Notice의 내용이 제출하신 정보와 일치하지 않는 경우 변경사항을.");
					template[1].append("\n알려주시기 바랍니다.");
					template[1].append("\n\nSM상선");
	    		} else {
	    			lang = "EN";
//	    			template[0].append("SM Line Booking Receipt Notice (BKG No:"+ bkgNo + ")");
					template[1].append("SM Line Booking Receipt Notice (BKG No:"+ bkgNo + ")");	
					template[1].append("\nDear Customer,");	
					template[1].append("\nPlease be informed that your booking(s) below are received.");
					template[1].append("\n-Booking No："+ bkgNo);
					if(vslNm!=null && vslNm.length() > 0){
						template[1].append("\n-Vessel："+ vslNm);
					}
					template[1].append("\nIf you find any discrepancy on attached booking receipt notice, please advise us of what needs to be amended.");
					template[1].append("\n\nSM Line Corporation");
					template[1].append("For more detailed information on your shipments, Go to http://www.smlines.com");
	    		}
	    		template[2].append(lang);
	    	} else if(ntcKnd.equals("BT") || ntcKnd.equals("CN") || ntcKnd.equals("FC")){ // Empty Release order
	    		bkgNo = arg[0];
	        	lang = dbDao.searchBkgCustCntCd("S", bkgNo);
	        	
	        	if(lang.equals("CN")){ 
	        		template[1].append("森罗空箱放行请求");
	        		template[1].append("\n\n亲爱的同事,");
	        		template[1].append("\n订舱如附件空箱放行请求已确认；请将空箱放行给订舱接受通知的持有人或订舱相关方.");
	        		template[1].append("\n--订舱号：+ "+bkgNo);
	        		template[1].append("\n\n森罗商船");
	        	} else if(lang.equals("KR")){
	        		template[1].append("SM상선 공컨테이너 인도 요청서");
	        		template[1].append("\nSM Line Empty Release Order (BKG No : "+ bkgNo + ")");
	        		template[1].append("\n\n표제 상의 예약이 확정됨에 따라 첨부 요청서에 따라 예약 당사자 혹은 관련자에게 공컨테이너를 인도하여 주시기 바랍니다.");
	        		template[1].append("\n- Booking No : "+ bkgNo);
	        		template[1].append("\n\nSM상선");
	        	} else {
	        		lang = "EN";
	        		template[1].append("SM Line Empty Release Order (BKG No : "+ bkgNo + ")");
	        		template[1].append("\n\nDear Partner,");
	        		template[1].append("\nPlease be informed that HJS booking(s) are confirmed as attached empty release order(s) and release empty continer(s) to the holder of booking receipt notice or booking parties concerned.");
	        		template[1].append("\n- Booking No : "+ bkgNo);
	        		template[1].append("\n\nSM Line Corporation");
	        	}
	    		template[2].append(lang);
	    	} else if(ntcKnd.equals("BL") || ntcKnd.equals("WB") || ntcKnd.equals("NN")){
	    		bkgNo = arg[0];
	        	String vslNm ="";
	    		lang = dbDao.searchBkgCustCntCd("S", bkgNo);
            	
            		StringBuilder titleSb = new StringBuilder("SM Line ");
            		if ("WB".equals(ntcKnd)) {
            			titleSb.append("Sea Waybills");
            		} else if ("NN".equals(ntcKnd)) {
               			titleSb.append("B/L Copy");
            		} else {
            			titleSb.append("Draft B/L(s)");
            		}
            		titleSb.append(" (T/VVD : ").append(vslNm).append(" / B/L No : ").append(bkgNo).append(")");
	    		
	    		
	    		if(lang.equals("CN")){
	    			
	    			template[1].append("森罗Draft提单 (T/VVD : KMTC INCHEON 1308W / B/L No : NJEA37988400)");
	    			template[1].append("\n");
	    			template[1].append("\n亲爱的顾客，");
	    			template[1].append("\n我们已根据您提单确认件缮制完毕您的提单。");
	    			template[1].append("\n--提单号："+bkgNo);
	    			template[1].append("\n");
	    			template[1].append("\n请确认是否和您的要求一致；另外，假如您就附上的Draft提单发现了任何不符之处，请告知我们需要修改的地方。");
	    			template[1].append("\n另外，假如您并非credit客户，请在签单之前结清费用。");
	    			template[1].append("\n");
	    			template[1].append("\n感谢您选择我们。");
	    			template[1].append("\n");
	    			template[1].append("\n森罗商船");
	    			template[1].append("\n");
	    			template[1].append("\n若想获取更多关于获取的详细信息，请登录我们公司的网站 http://www.smlines.com");
	    		}else if(lang.equals("KR")){
	    			template[1].append("SM상선 Draft B/L(s) (T/VVD : KMTC INCHEON 1308W / B/L 번호 : NJEA37988400)"); 
	    			template[1].append("\n");
	    	    	template[1].append("\n");
	    	    	template[1].append("\n평소 SM상선을 이용해주심에 대단히 감사 드립니다.");
	    	    	template[1].append("\n귀 사에서 제출하신 선적요청서를 바탕을 Draft B/L이 첨부와 같이 생성되었습니다.");
	    	    	template[1].append("\n");
	    	    	template[1].append("\n- B/L 번호 : "+bkgNo); 
	    	    	template[1].append("\n");
	    	    	template[1].append("\n첨부 확인하시어 변경사항 여부 확인 부탁 드립니다. 아울러 B/L 발급을 위해");
	    	    	template[1].append("\n운임 지불을 완료하여 주시기 바랍니다.");
	    	    	template[1].append("\n");
	    	    	template[1].append("\n");
	    	    	template[1].append("\nSM상선");
	    	    	template[1].append("\n");
	    		}else{
	    	    	template[1].append("SM Line Draft B/L(s) (T/VVD : KMTC INCHEON 1308W / B/L No : NJEA37988400)"); 
	    	    	template[1].append("\n");
	    	    	template[1].append("\n");
	    	    	template[1].append("\nDear Customer,"); 
	    	    	template[1].append("\n");
	    	    	template[1].append("\nPlease be informed B/L(s) are ready as per your shipping instruction."); 
	    	    	template[1].append("\n");
	    	    	template[1].append("\n- B/L No : "+bkgNo); 
	    	    	template[1].append("\n");
	    	    	template[1].append("\n");
	    	    	template[1].append("\nKindly confirm your approval and B/L requirement, meanwhile if you find any"); 
	    	    	template[1].append("\n");
	    	    	template[1].append("\ndiscrepancy on attached draft B/Ls, please advise us of what needs to be amended."); 
	    	    	template[1].append("\n");
	    	    	template[1].append("\nIn case of non-credit customers, please settle the payment prior to B/L issuance."); 
	    	    	template[1].append("\n");
	    	    	template[1].append("\n");
	    	    	template[1].append("\n");
	    	    	template[1].append("\n");
	    	    	template[1].append("\n");
	    	    	template[1].append("\nThank you for choosing us"); 
	    	    	template[1].append("\n");
	    		}
	    			
	    	}else if(ntcKnd.equals("RR")){
	    		bkgNo = arg[0];
	    		lang = dbDao.searchBkgCustCntCd("S", bkgNo);
	    		
	    		if(lang.equals("CN")){
	    			template[1].append("修改提单运费 (T/VVD: KMTC INCHEON 1308W / B/L No: NJEA37988400)");
   					template[1].append("\n");
					template[1].append("\n亲爱的顾客，");
					template[1].append("\n");
	    			template[1].append("\n您的提单现有一部分运费计算错误。请参考附件当中的修正后的运费。");
	    			template[1].append("\n对于造成的不便，我们表示很抱歉。假如您有任何的疑问，请随时联系我们。"); 
	    			template[1].append("\n");
	    			template[1].append("\n我们将对于您能尽快的补齐运费表示感谢。");
	    			template[1].append("\n");
	    			template[1].append("\n感谢您选择我们。");
	    			template[1].append("\n森罗商船");
	    			template[1].append("\n");
	    			template[1].append("\n若想获取更多关于获取的详细信息，请登录我们公司的网站 http://www.smlines.com");
	    		}else if(lang.equals("KR")){
	    			template[1].append("운임정정 B/L (s) (T/VVD : KMTC INCHEON 1308W / B/L 번호 : NJEA37988400)"); 
	    			template[1].append("\n");
	    			template[1].append("\n");
	    			template[1].append("\n");
	    			template[1].append("\n업무상에 불편을 초래하게 되어 사과의 말씀 드립니다."); 
	    			template[1].append("\n");
	    			template[1].append("\n확인 결과 해당 B/L에 대한 운임이 오적용 되어 재송부 드리오니 확인 부탁 드립니다.");
	    			template[1].append("\n첨부 확인하신 후 문의사항이 있으신 경우는 당 사로 연락 부탁 드립니다.");
	    			template[1].append("\n추가 발생된 운임은 가급적 빠른 시일내 송금하여 주시면 대단히 감사하겠습니다.");
	    			template[1].append("\n");
	    			template[1].append("\nSM상선");
	    		}else{
	    			template[1].append("Revised Rate B/L (s) (T/VVD : KMTC INCHEON 1308W / B/L No : NJEA37988400)"); 
	    			template[1].append("\n");
	    			template[1].append("\n");
	    			template[1].append("\n");
	    			template[1].append("\nDear Customer,"); 
	    			template[1].append("\n");
	    			template[1].append("\n");
	    			template[1].append("\n");
	    			template[1].append("\nPlease be informed that your B/L was found to be rated incorrectly.  Please see attached for revised rate."); 
	    			template[1].append("\n");
	    			template[1].append("\nWe’re sorry for the inconvenience.  If you have any questions or concerns, please feel free to contact us."); 
	    			template[1].append("\n");
	    			template[1].append("\nWe’d appreciate if you can remit payment for the additional amount as soon as possible."); 
	    			template[1].append("\n");
	    			template[1].append("\n");
	    			template[1].append("\n");
	    			template[1].append("\nThank you for choosing us"); 
	    			template[1].append("\n");
	    			template[1].append("\nSM Line Corporation"); 
	    			template[1].append("\n");
	    			template[1].append("\nFor more detailed information on your shipments, Go to http://www.smlines.com"); 
	    		}
	    	}else if(ntcKnd.equals("SN")){
	    		bkgNo = arg[0];
	    		lang = dbDao.searchBkgCustCntCd("S", bkgNo);
	    		
	    		if(lang.equals("CN")){
	    			template[1].append("森罗提单电放通知 [提单号:NJEA37988400]"); 
	    	    	template[1].append("\n亲爱的顾客，"); 
	    	    	template[1].append("\n"); 
	    	    	template[1].append("\n为保证您能在目的港尽快提取货物，该票货物已经被同意电放。"); 
	    	    	template[1].append("\n"); 
	    	    	template[1].append("\n详细信息请参考附件。"); 
	    	    	template[1].append("\n"); 
	    	    	template[1].append("\n感谢您选择我们。"); 
	    	    	template[1].append("\n"); 
	    	    	template[1].append("\n森罗商船"); 
	    	    	template[1].append("\n"); 
	    	    	template[1].append("\n若想获取更多关于获取的详细信息，请登录我们公司的网站 http://www.smlines.com"); 
	    		}else if(lang.equals("KR")){
	    	    	template[1].append("SM상선 O.B/L Surrender 통지 서비스 [B/L 번호 : NJEA37988400]");  
	    	    	template[1].append("\n"); 
	    	    	template[1].append("\n"); 
	    	    	template[1].append("\n평소 SM상선을 이용해주심에 감사 드립니다.");  
	    	    	template[1].append("\n"); 
	    	    	template[1].append("\n목적지에서의 O.B/L 제출 없이 화물 수취를 진행하실 수 있도록 Surrender 처리가 완료되었음을 알려드립니다.");  
	    	    	template[1].append("\n세부사항은 첨부를 참조하여 주시기 바랍니다. "); 
	    	    	template[1].append("\n"); 
	    	    	template[1].append("\nSM상선"); 
	    		}else{
	    			template[1].append("SM Line O.B/L Surrender Notice [B/L No : NJEA37988400] "); 
	    			template[1].append("\n"); 
	    			template[1].append("\n"); 
	    			template[1].append("\nDear Customer,");  
	    			template[1].append("\n"); 
	    			template[1].append("\nPlease be advised that Original Bill(s) of Lading was(were) surrendered to our office for prompt cargo release at destination without presentation of O.B/L.");  
	    			template[1].append("\n"); 
	    			template[1].append("\nFor details, please refer to the attachment.");  
	    			template[1].append("\n"); 
	    			template[1].append("\n"); 
	    			template[1].append("\nThank you for choosing us");  
	    			template[1].append("\n"); 
	    			template[1].append("\nSM Line Corporation");  
	    			template[1].append("\n"); 
	    			template[1].append("\nFor more detailed information on your shipments, Go to http://www.smlines.com");  
	    		}
	    	 } else if(ntcKnd.equals("AN")){ // Arrival Notice
	    		 	bkgNo = arg[0];
	                String bkgNoForLang = bkgNo;
	                //@ 그룹 메일일 경우 첫번째 BKG No로 lang을 조회 한다.
	                if(bkgNo != null && bkgNo.indexOf(",") > 0){
	                	bkgNoForLang = bkgNo.substring(0, bkgNo.indexOf(",")); 
	                }
	                lang = dbDao.searchBkgCustCntCd("C", bkgNoForLang);
	                log.debug("\n\n Booking No =========>" + bkgNo);
	                log.debug("\n\n Language Code =========>" + lang);
	                if(arg.length > 1 && arg[1] != null && arg[1].length() > 0){
	                     bkgNo = arg[1];
	                  }
	                  // booking receipt는 title은 기존 처리로 함
	                 if(lang.equals("CN")){
	                    template[1].append("亲爱的顾客，\r");
//	                    template[1].append("</br></br>您的集装箱不久将会抵达目的港(BKG No:  ").append(bkgNo).append(")。\r");
	                    template[1].append("</br></br>您的集装箱不久将会抵达目的港。\r");
	                    template[1].append("</br></br>请查看附件中关于到货信息的各个细节。\r");
	                    template[1].append("</br></br>假如您有任何的疑问，请根据相关的提单号和船名联系我们。\r");
	                    template[1].append("</br></br>顺致商祺\r");
	                    template[1].append("</br></br>森罗商船</br></br>");
	                 } else if(lang.equals("KR")){                   
	                    template[1].append("평소 SM상선을 이용해주심에 대단히 감사 드립니다.\r"); 
//	                    template[1].append("</br></br>귀사의 화물이 양하항에 곧 도착할 예정입니다(BKG No:  ").append(bkgNo).append(").\r");
	                    template[1].append("</br></br>귀사의 화물이 양하항에 곧 도착할 예정입니다.\r");
	                    template[1].append("</br>세부사항은 첨부의 도착통지서를 확인하여 주시기 바랍니다.\r");
	                    template[1].append("</br></br>추가적인 문의사항이 있는 경우, B/L와 VVD와 함께 수입서비스 팀에 문의하여 주시기 바랍니다.\r");
	                    template[1].append("</br></br>SM상선</br></br>");
	                 } else {
	                    lang = "EN";
	                    template[1].append("Dear Customers\r");    
//	                    template[1].append("</br></br>Please be advised that your container(s) will arrive at Port of Discharge soon(BKG No:  ").append(bkgNo).append(").\r");
	                    template[1].append("</br></br>Please be advised that your container(s) will arrive at Port of Discharge soon.\r");
	                    template[1].append("</br></br>Please find details regarding Arrival Information from the attachment .\r");
	                    template[1].append("</br></br>If you have any inquiry, please contact us with related BL number and VVD.\r");
	                    template[1].append("</br></br>Sincerely.\r");
	                    template[1].append("</br></br>SM Line</br></br>");
	                  
	                 }
	                 template[2].append(lang);
	    	}
	    	return template; 
	
//	    } catch (EventException e){
//	    	throw e;
	    } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
	/**
	 * searchBkgCustCntCd  이벤트 처리<br>
	 * @param String bkgCustTpCd
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchBkgCustCntCd(String bkgCustTpCd, String bkgNo) throws EventException{
		String result = "N";
		try {
			result = dbDao.searchBkgCustCntCd(bkgCustTpCd, bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return result ;
	}
	
	/**
	 * allocation Standby로 notice를 취소할지 여부 조회<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception EventException
	 */
	public Object searchStandbyBlockFlg(BkgBlNoVO bkgBlNoVO) throws EventException{
		String result = "N";
		try {
			result = dbDao.searchStandbyBlockFlg(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return result ;
	} 
	
	/**
	 * No Rate 로 notice를 취소할지 여부 조회<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception EventException
	 */
	public Object searchNoRateBlockFlg(BkgBlNoVO bkgBlNoVO) throws EventException{
		String result = "N";
		try {
			result = dbDao.searchNoRateBlockFlg(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return result ;
	} 
	
    /**
     * VVD가 한국세관 Download 된 적 있는 지 조회.<br>
     * @author 	Dongsun Moon
     * @param  	String vvd_cd
     * @param  	String pod_loc
     * @return 	String
	 * @throws EventException
     */
	public String searchKrCstmsDownload(String vvd_cd, String pod_loc) throws EventException {
		String result = "";
		try {
			result = dbDao.searchKrCstmsDownload(vvd_cd, pod_loc);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return result ;
	} 	
	
	/**
	 * Potential DG 화물 목록을 체크한다<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception EventException
	 */
	public Object searchPotentialDgFlg(BkgBlNoVO bkgBlNoVO) throws EventException{
		String result = "N";
		try {
			result = dbDao.searchPotentialDgFlg(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return result ;
	} 
	
	/**
	 * Potential DG 화물 목록을 체크한다<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String divCd
	 * @return String
	 * @exception EventException
	 */
	public String searchPotentialDgFlg2(BkgBlNoVO bkgBlNoVO, String divCd) throws EventException{
		String result = "N";
		try {
			result = dbDao.searchPotentialDgFlg2(bkgBlNoVO, divCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return result ;
	} 
	
    /**
	 *  MDM_ORGANIZATION 테이블에서 ofc_cd 조건검색하여 LOC_CD 정보를 조회.<br>
	 * @param String ofc_cd
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchLocCdByOfcCd2(String ofc_cd) throws EventException {
		try {
            return dbDao.searchLocCdByOfcCd2(ofc_cd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

    /**
	 * rfaSpotPricingAvailable 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * rfaSpotPricingAvailable 유효성체크  <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String 
	 * @throws EventException
	 */
	public String rfaSpotPricingAvailable(String input_text) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.rfaSpotPricingAvailable(input_text);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}  
	
    /**
	 * rfaSpotPricingAvailable 와 같은 내용이나 파라미터를 달리함<br>
	 * 0079-01 event체크 <br>
	 * rfaSpotPricingAvailableForBkgCre 유효성체크  <br>
	 * @author 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rfaNo
	 * @param String obSrepCd
	 * @return String output_text
	 * @throws EventException
	 */
	public String rfaSpotPricingAvailableForBkgCre(BkgBlNoVO bkgBlNoVO, String rfaNo, String obSrepCd) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.rfaSpotPricingAvailableForBkgCre(bkgBlNoVO, rfaNo, obSrepCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}  
	
    /**
	 * n3rdPartyBlReqOfcAvailable 조회 이벤트 처리<br>
	 * 79-08 event체크 <br>
	 * n3rdPartyBlReqOfcAvailable 유효성체크  <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String 
	 * @throws EventException
	 */
	public String n3rdPartyBlReqOfcAvailable(String input_text) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.n3rdPartyBlReqOfcAvailable(input_text);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}  
	
	 /**
		 * n3rdPartyBlReqAvailable 조회 이벤트 처리<br>
		 * 79-08 event체크 <br>
		 * n3rdPartyBlReqAvailable 유효성체크  <br>
		 * @author Lee Jin Seo
		 * @param String input_text
		 * @return String 
		 * @throws EventException
		 */
	public String n3rdPartyBlReqAvailable(String input_text) throws EventException{
		String resultExist = "N";
		try {
			resultExist = dbDao.n3rdPartyBlReqAvailable(input_text);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		   return resultExist ;
	}
	
	/**
	 * bkg_no 와 cntr_no를 이용해 bkg_container 테이블의 cyc_no 검색
	 * @author Yang Dong Hun
	 * @param String bkg_no
	 * @param String cntr_no
	 * @return List<CntrInfoVO>
	 * @throws EventException
	 */
	public List<CntrInfoVO> searchCntrInfo(String bkg_no,String cntr_no) throws EventException{
		List<CntrInfoVO> result = null;
		try {
			result = dbDao.searchCntrInfo(bkg_no,cntr_no);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	/**
	 * bkg_no 와 cntr_no를 이용해 bkg_container 테이블의 cyc_no 업데이트
	 * @author Yang Dong Hun
	 * @param CntrInfoVO[] vos
	 * @throws EventException
	 */
	public void manageCntrCycNo(CntrInfoVO[] vos) throws EventException{
		for(int i=0;i<vos.length;i++){
			try {
				dbDao.manageCntrCycNo(vos[i]);
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
	}
	
	/**
     * Booking ALOC_STS_CD 상태 조회<br>
     *
     * @param     bkgBlNoVO BkgBlNoVO
     * @return    String
     * @exception EventException
     */ 
    public String searchAlocStsCd(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchAlocStsCd(bkgBlNoVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }
    
	/**
	 * Receipt Notice 메일 내용에 포함 될 Vessel Name 과 Lane 을 조회 한다.
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
    public String searchVesselNameByBkgNo(String bkgNo) throws EventException{
		String vslNm = "";
		try {
			vslNm = dbDao.searchVesselNameByBkgNo(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return vslNm ;
	}
	//수정 끝
    
    
    /**
     * @return List<BkgComboVO>
     * @throws EventException
     */
    public List<BkgComboVO> searchYearCombo() throws EventException {
        try {
            return dbDao.searchYearCombo();
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }
    
    /**
     * @param String ofcCd
     * @return List<BkgComboVO>
     * @throws EventException
     */
    public List<BkgComboVO> searchOfcCombo(String ofcCd) throws EventException {
        try {
            return dbDao.searchOfcCombo(ofcCd);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		}
    }
    
    
	/**
	 * 발짜, 로직별로 적용되는 로직인지를 확인한다.
	 * @param String bkgNo
	 * @param String lgcNm
	 * @param String div
	 * @return String
	 * @throws DAOException 
	 */
	public String searchEffDtDiv(String bkgNo, String lgcNm, String div) throws EventException{
		String effFlg = "N";
		try {
			effFlg = dbDao.searchEffDtDiv(bkgNo, lgcNm, div);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return effFlg ;
	}
	/**
	 * POD가 West Africa Port 인지 확인<br>
	 * Hard Coding 테이블에 들옥된 Port를 대상으로 서아프리카인지 확인한다.
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchWestAfricaPod (String bkgNo)throws EventException {
		try {
			return dbDao.searchWestAfricaPod(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * 첫 번째 VVD 찾기<br>
	 * @param String bkgNo
	 * @return String
	 * @throws EventException 
	 */
	public String searchFirstVVD (String bkgNo)throws EventException {
		try {
			return dbDao.searchFirstVVD(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 *  bkg_blck_list_mntr 테이블에 데이터 insert한다. <br>
	 * @param bkgBlckListMntrVO
	 * @throws EventException 
	 */
	public void addBkgBlckListMntr (BkgBlckListMntrVO bkgBlckListMntrVO)throws EventException {
		try {
			dbDao.addBkgBlckListMntr(bkgBlckListMntrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @return
	 * @throws EventException
	 */
	public String genOblSerNo (String bkgNo)throws EventException {
		try {
			return dbDao.genOblSerNo(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @param serNo
	 * @param account
	 * @throws EventException
	 */
	public void bkgInetBlOblSerNoAdd (String bkgNo, String serNo, SignOnUserAccount account)throws EventException {
		try {
			dbDao.bkgInetBlOblSerNoAdd(bkgNo, serNo, account);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 
	 * @param bkgNo
	 * @param serNo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public List<BkgInetBlPrnAuthVO> bkgInetBlOblSerNoChecked (String bkgNo, String serNo, SignOnUserAccount account)throws EventException {
		List<BkgInetBlPrnAuthVO> list = null;
		try {
			list = dbDao.searchOblSerialNumber(bkgNo, "N", "1");
			for (int i = 0; i < list.size(); i++) {
				BkgInetBlPrnAuthVO vo = list.get(i);
				if(serNo.indexOf(vo.getOblInterSerNo()) > -1){
					dbDao.bkgInetBlOblSerNoChecked(bkgNo, vo.getOblInterSerNo(), "Y", account);
				}else{
					dbDao.bkgInetBlOblSerNoChecked(bkgNo, vo.getOblInterSerNo(), "N", account);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @param checked
	 * @return
	 * @throws EventException
	 */
	public List<BkgInetBlPrnAuthVO> searchOblSerialNumber(String bkgNo, String checked) throws EventException {
		try {
			return dbDao.searchOblSerialNumber(bkgNo, checked, null);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
     * India SAC Code 정보 조회.<br>
     * @author SONG Min Seok
     * @param String idaSacCd
     * @return BkgIdaSacMstVO
     * @throws EventException
     */
    public BkgIdaSacMstVO searchIdaSacMasterInfo(String idaSacCd) throws EventException {
        try {
            return dbDao.searchIdaSacMasterInfo(idaSacCd);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
        }
    }
    
	/**
	 * BKG NO로 조회가능한지 체크 로직
	 * @param bkgNo
	 * @param securitySearchId
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String bkgSecuritySearchCk(String bkgNo, HttpServletRequest hreq, String securitySearchId, String pgmNo, SignOnUserAccount account) throws EventException{
		try {
			/* 광져우 사용자들 BKGKING 조회 제한 로직 */
			if(securitySearchId.equals("BKG_MAIN")){
				return dbDao.bkgLoginOfcCdSearchCk(bkgNo, securitySearchId, pgmNo, String.valueOf((FormCommand.fromRequest(hreq)).getCommand()), account);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return "N";
	}
	/**
	 * 
	 * @param porCd
	 * @return
	 * @throws EventException
	 */
	public String searchPorCdCheck(String porCd) throws EventException {
		try {
			return dbDao.searchPorCdCheck(porCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * XterRqstNoVO 정보 조회.<br>
	 * @author Lim Jae Kwan
	 * @param XterRqstNoVO vo
	 * @return XterRqstNoVO
	 * @throws EventException
	 */
	public XterRqstNoVO searchAperakXterRqstNo(String bkgNo) throws EventException {
		try {
			return dbDao.searchAperakXterRqstNo(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public String searchProductCatalogPopUpCheck(ProductCatalogPoupCheckVO vo) throws EventException {
		try {
			if(dbDao.searchProductCatalogPopUpOpen())
				return dbDao.searchProductCatalogPopUpCheck(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return "";
	}
}
