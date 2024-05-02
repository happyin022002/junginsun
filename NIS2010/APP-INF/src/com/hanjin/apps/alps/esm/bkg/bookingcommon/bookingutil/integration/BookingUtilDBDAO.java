/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingUtilDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.04
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.04 김영출
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
 * 2010.11.09 최도순 [CHM-201006977] Work with Bookings의 조회 옵션에 E/Q Type 추가
 * 2010.11.11 이일민 [CHM-201005869-01] Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 * 2010.11.11 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 * 2010.12.16 김현화 [CHM-201007561-01] Zip code Creation(UI_BKG_1114) COMBO사용 searchMdmCnt()
 * 2010.12.28 이인영 [CHM-201007771-01] 이란 금융 제재 관련 Black Customer 체크기능 추가
 * 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청 (searchPkgTypeByName 추가)
 * 2011.01.06 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청 (searchSteCodeByName 추가)
 * 2011.04.01 김기종 [CHM-201109394-01] DPCS고도화일환으로  DPCS E-MAIL 추가및 화면 개선
 * 2011.04.06 조원주 [CHM-201109864] Customer E-Mail Address 입력 column 추가
 * 2011.05.18 김봉균 [CHM-201110697-01] BDR Open 권한 변경(seacrhManualBdrUserCheck 추가) 
 * 2012.02.23 박성호[CHM-201115347] BKG 한국지역 사전 적하목록 제출 시간 변경에 따른 Cut-off time 변경 요청 
 * 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가. 
 * 2012.03.29 전성진 [CHM-201217014] 악성 화주 선택시 Warning Message 변경 요청
 * 2012.04.24 오요한 [CHM-201216516] BKG/DOC System 보완 요청
 * 2012.11.08 김보배 [CHM-201221406] [BKG] 이란 Sanction 관련 HS Code 삽입 로직 보완 요청
 * 2012.11.20 이준근 [CHM-201221047-01] B/L Type의 예외적 처리를 위한 변경 요청
 * 2012.12.20 조정민 [CHM-201221841] Booking Confirmation F/File 발송 조건 추가 
 * 2013.04.08 김진주 [CHM-201323806] BOOKING STATUS REPORT 판매팀 코드로 산출 기능 추가
 * 2013.04.29 김태경 [CHM-201323821] B/L ISSUE 에서 ROUTE 정보를  LOG에 관리 하도록 기능 추가
 * 2014.06.18 조인영 [CHM-201430731] BKG Status Report에 POL 이나 BKG OFFICE가 US/CA Country에 속하는 경우 1달동아 조회토록 로직 보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.AcssAlwInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlckListMntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgCloseVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgCstmsHrdCdgCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgInetBlPrnAuthVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ContinentCodeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ManualSurchargeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MemoSplitMasterBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.OblIssVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.OfcChgProcVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
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
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SplitMstBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SplitNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.StaffListByOfcCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration.BLIssuanceDBDAOmanageIntAuthCSQL;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;
import com.hanjin.syscommon.common.table.BkgHamoTrfVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgIdaSacMstVO;
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
 * NIS2010 BookingUtilDAO <br>
 * - NIS2010-BookingCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Youngchul
 * @see BookingUtil 참조 
 * @since J2EE 1.4
 */
public class BookingUtilDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -26862455431965189L;

	/**
	 * autoRatingRFACheck  이벤트 처리<br>
	 * @author Lee Jin Seo
	 * @param String bkgNo
	 * @param String ca_flg
	 * @return String
	 * @exception EventException
	 */
	public String oblIssFlgCheck(String bkgNo, String ca_flg) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", bkgNo);
			mapVO.put("ca_flg", ca_flg);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOOblIssFlgCheckRSQL template = new BookingUtilDBDAOOblIssFlgCheckRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
    }
	
	
	/**
	 * searchRtAplyDateCheck  이벤트 처리<br>
	 * @author Kim Tae Kyoung
	 * @param String input_text
	 * @return String
	 * @exception EventException
	 */
	public String searchRtAplyDateCheck(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchRtAplyDateCheckRSQL template = new BookingUtilDBDAOSearchRtAplyDateCheckRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
    }
	
	/**
	 * autoRatingRFACheck  이벤트 처리<br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String
	 * @exception EventException
	 */
	public String autoRatingRFACheck(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOAutoRatingRFACheckRSQL template = new BookingUtilDBDAOAutoRatingRFACheckRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
    }
	/**
	 *  searchBkgVvd1  이벤트 처리<br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String
	 * @exception EventException
	 */
	public String searchBkgVvdCheck(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOBkgVvdVORSQL template = new BookingUtilDBDAOBkgVvdVORSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
    }
	
	/**
	 * searchScNoValidationCheck 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String searchScNoValidationCheck(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			String[] note = input_text.split("\\|");
			mapVO.put("sc_no", note[0]);
			mapVO.put("app_date", note[1]);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchScNoValidationCheckRSQL template = new BookingUtilDBDAOSearchScNoValidationCheckRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "N";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}
	/**
	 * searchCountryName 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String searchCountryName(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchCountryNameRSQL template = new BookingUtilDBDAOSearchCountryNameRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}
	/**
	 * BkgTroVO 정보 조회.<br>
	 * @author Lee Jin Seo
	 * @param BkgTroVO vo
	 * @return BkgTroVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgTroVO searchPcNoforTro(BkgTroVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTroVO> list = null;
		BkgTroVO rtnBkgTroVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchPcNoforTroRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTroVO.class);
			if (list != null && list.size() > 0) {
				rtnBkgTroVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnBkgTroVO;
	}
	/**
	 * repCustomer 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String repCustomer(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAORepCustomerRSQL template = new BookingUtilDBDAORepCustomerRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}
	/**
	 * BkgRate 을 조회하여 Mater/Cover에 정보를 Return한다.<br>
	 * 
	 * @param String bl_no
	 * @return BkgRateVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgRateVO searchBkgRate(String bl_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgRateVO> list = null;
		BkgRateVO rkgRateVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bl_no", bl_no);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchBkgRateRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgRateVO.class);

			if (list != null && list.size() > 0) {
				rkgRateVO = (BkgRateVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rkgRateVO;
	}
	
	/**
	 * vesselVoyageDirectionEqual 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String vesselVoyageDirectionEqual(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOVesselVoyageDirectionEqualRSQL template = new BookingUtilDBDAOVesselVoyageDirectionEqualRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}
	/**
	 * manualSurcharge 함수 <br>
	 *1. 메뉴얼로 Insert 하는 Charge 가 PRI에 Scope 및 CHG CODE 별로 등록 되어있는 항목중에 	
	 *- Charge Code 일치, Cur 일치, Per ='PC' Term 이 일치 할경우 적용
	 * @author Lee Jin Seo
	 * @param String application_date 
	 * @param String svc_scp_cd
	 * @return List<ManualSurchargeVO>
	 */
	@SuppressWarnings("unchecked")
	public List<ManualSurchargeVO> manualSurcharge(String application_date , String svc_scp_cd) throws DAOException {
		DBRowSet dbRowset = null;
		// List
		List<ManualSurchargeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("application_date", application_date);
			mapVO.put("svc_scp_cd", svc_scp_cd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOManualSurchargeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ManualSurchargeVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	/**
	 * autoratingRfaAvailable 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String autoratingRfaAvailable(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			String[] note = input_text.split("\\|");
			mapVO.put("bkg_no", note[0]);
			mapVO.put("rfa_no", note[1]);
			mapVO.put("date", note[2]);
			mapVO.put("ca_flg", note[3]);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOAutoratingRfaAvailableRSQL template = new BookingUtilDBDAOAutoratingRfaAvailableRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}
	/**
	 * autoratingScAvailable 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String autoratingScAvailable(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			String[] note = input_text.split("\\|");
			mapVO.put("bkg_no", note[0]);
			mapVO.put("sc_no", note[1]);
			mapVO.put("date", note[2]);
			mapVO.put("ca_flg", note[3]);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOAutoratingScAvailableRSQL template = new BookingUtilDBDAOAutoratingScAvailableRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}
	/**
	 * autoratingTaaAvailable 함수 <br>
	 * @author kim tae kyoung
	 * @param String input_text
	 * @return String output_text
	 */
	public String autoratingTaaAvailable(String input_text) throws DAOException{
		// input_text
		String output_text = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			String[] note = input_text.split("\\|");
			if(note.length != 4) return output_text;
				mapVO.put("bkg_no", note[0]);
				mapVO.put("taa_no", note[1]);
				mapVO.put("date", note[2]);
				mapVO.put("ca_flg", note[3]);

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				BookingUtilDBDAOAutoratingTaaAvailableRSQL template = new BookingUtilDBDAOAutoratingTaaAvailableRSQL();
				DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
				if (dbRowset.next()) {
					output_text = dbRowset.getString("OUTPUT_TEXT");
				} else {
					output_text = "";
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

			return output_text;
		}
	/**
	 * existBlackListedCustomer 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String existNoteButtonColor(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			String[] note = input_text.split("\\|");
			mapVO.put("prop_no", note[0]);
			mapVO.put("amdt_seq", note[1]);
			mapVO.put("svc_scp_cd", note[2]);
			mapVO.put("note_rt_seq", note[3]);
			mapVO.put("gen_spcl_rt_tp_cd",note[4]);
			mapVO.put("cmdt_hdr_seq", note[5]);
			mapVO.put("rout_seq", note[6]);
			
			log.debug("mapVOmapVOmapVO: "+mapVO);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOExistNoteButtonColorRSQL template = new BookingUtilDBDAOExistNoteButtonColorRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("FLG");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}
	/**
	 * existBlackListedCustomer 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	@SuppressWarnings("unchecked")
	public BkgCreCustomerVO existBlackListedCustomer(String input_text) throws DAOException {
		// input_text
		BkgCreCustomerVO bkgCreCustomerVO = null;
		List<BkgCreCustomerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOExistBlackListedCustomerRSQL template = new BookingUtilDBDAOExistBlackListedCustomerRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCreCustomerVO.class);

			if (list != null && list.size() > 0) {
				bkgCreCustomerVO = (BkgCreCustomerVO) list.get(0);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bkgCreCustomerVO;
	}
	/**
	 * searchMdmLocName LOC_CD 코드번호로 LOC_NM값을 얻는 함수 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String searchMdmLocName(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchMdmLocNameRSQL template = new BookingUtilDBDAOSearchMdmLocNameRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}

	/**
	 * searchBkgNoListByBkgNo BKG_NO 번호로 OLD ,NEW BKG_NO 번호 구분자($)로 가져오는 함수 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String searchBkgNoListByBkgNo(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchBkgNoListByBkgNoRSQL template = new BookingUtilDBDAOSearchBkgNoListByBkgNoRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;

	}

	/**
	 * searchBlListByBl BL_NO 번호로 OLD ,NEW BL_NO 번호 구분자($)로 가져오는 함수 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String searchBlNoListByBlNo(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchBlNoListByBlNoRSQL template = new BookingUtilDBDAOSearchBlNoListByBlNoRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}
	/**
	 * existPerCode  코드번호로 존재여부 판단하는 함수 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String existPerCode(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOExistPerCodeRSQL template = new BookingUtilDBDAOExistPerCodeRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}
	
	/**
	 * existPayerCode 체크하는 함수 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String custCntCd
	 * @param String custSeq
	 * @return String output_text
	 */
	public String existPayerCode(String custCntCd, String custSeq) throws DAOException {
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOCheckCustomerCdRSQL template = new BookingUtilDBDAOCheckCustomerCdRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("delt_flg");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}
	
	/**
	 * existChargeCode ChargeCode 코드번호로 존재여부 판단하는 함수 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String existChargeCode(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOExistChargeCodeRSQL template = new BookingUtilDBDAOExistChargeCodeRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}

	/**
	 * existCurrencyCode CurrencyCode 코드번호로 존재여부 판단하는 함수 <br>
	 * 
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String existCurrencyCode(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOExistCurrencyCodeRSQL template = new BookingUtilDBDAOExistCurrencyCodeRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}

	/**
	 * searchDocProcSkd <br>
	 * 
	 * @param BkgDocProcSkdVO bkgDocProcSkdVO
	 * @param String caFlg
	 * @return BkgDocProcSkdVO
	 */
	@SuppressWarnings("unchecked")
	public BkgDocProcSkdVO searchDocProcSkd(BkgDocProcSkdVO bkgDocProcSkdVO,String caFlg) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<BkgDocProcSkdVO> list = null;
		BkgDocProcSkdVO retVO = null;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			if (null != bkgDocProcSkdVO) {
				mapVO = bkgDocProcSkdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("ca_flg",caFlg);
				velParam.put("ca_flg",caFlg);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchDocProcSkdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgDocProcSkdVO.class);
			if (null!=list && 0<list.size()) {
				retVO = (BkgDocProcSkdVO)list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVO;
	}

	/**
	 * 공통콤보 목록조회<br>
	 * 
	 * @param String comCode
	 * @return List<BkgComboVO>
	 * @exception DAOException
	 */
	public List<BkgComboVO> searchCombo(String comCode) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			log.debug("# SEARCH COMMON-CODE : " + comCode);
			if (comCode == null || comCode.length() == 0) {
				// BKG00104 - 필수입력항목
				throw new RuntimeException("BKG00104");
			}

			param.put("cm_code", comCode);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOBkgComboRSQL template = new BookingUtilDBDAOBkgComboRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<BkgComboVO>();
			while (dbRowset.next()) {
				BkgComboVO vo = new BkgComboVO();
				vo.setComboCd(dbRowset.getString("intg_cd_id"));
				vo.setVal(dbRowset.getString("intg_cd_val_ctnt"));
				vo.setName(dbRowset.getString("intg_cd_val_dp_desc"));
				vo.setDesc(dbRowset.getString("intg_cd_val_desc"));
				vo.setMultidesc(dbRowset.getString("multidesc"));
				list.add(vo);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BkgNo 조회 <br>
	 * 
	 * @param String blNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgNoByBlNo(String blNo) throws DAOException {
		// booking status code
		String bkgNo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOBkgNoRSQL template = new BookingUtilDBDAOBkgNoRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				bkgNo = dbRowset.getString("bkg_no");
			} else {
				bkgNo = "";
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgNo;
	}
	
	/**
	 * BkgNo 조회 <br>
	 * 
	 * @param String rqstNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgNoByRqstNo(String rqstNo) throws DAOException {
		// booking status code
		String bkgNo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bkg_no", rqstNo);
			velParam.put("bkg_no", rqstNo);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchBkgNoByRqstNoRSQL template = new BookingUtilDBDAOsearchBkgNoByRqstNoRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				bkgNo = dbRowset.getString("bkg_no");
			} else {
				bkgNo = "";
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgNo;
	}

	/**
	 * Booking 상태 조회<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgStatusByBkg(BkgBlNoVO bkgBlNoVO) throws DAOException {
		// booking status code
		String bkgStsCd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgBlNoVO.getBkgNo());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOBkgStatusRSQL template = new BookingUtilDBDAOBkgStatusRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				bkgStsCd = dbRowset.getString("bkg_sts_cd");
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return bkgStsCd;
	}

	/**
	 * BkgNoSplit No조회
	 * 
	 * @param String bkgNo
	 * @return List<BkgComboVO>
	 * @throws DAOException
	 */
	public List<BkgComboVO> searchBkgNoSplitByBkg(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("bkg_no", bkgNo);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOBkgNoSplitRSQL template = new BookingUtilDBDAOBkgNoSplitRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<BkgComboVO>();
			while (dbRowset.next()) {
				BkgComboVO vo = new BkgComboVO();
				vo.setComboCd(dbRowset.getString("bkg_no"));

				/* bk no 통합으로 별 의미가 없어지는 메소드 */
				/*
				 * vo.setVal(dbRowset.getString("bkg_no_split")); vo.setName(dbRowset.getString("bkg_no_split")); vo.setDesc(dbRowset.getString("bkg_no_split"));
				 */
				list.add(vo);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BookingUtilDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Booking Creation 1_Container Type/Size 조회 table-mdm_cntr_tp_sz
	 * 
	 * @param MdmCntrTpSzVO mdmCntrTpSzVO
	 * @return List<MdmCntrTpSzVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCntrTpSzVO> searchTypeSize(MdmCntrTpSzVO mdmCntrTpSzVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCntrTpSzVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		log.debug("mdmCntrTpSzVO:" + mdmCntrTpSzVO);
		try {
			if (mdmCntrTpSzVO != null) {
				Map<String, String> mapVO = mdmCntrTpSzVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOMdmCntrTpSzVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmCntrTpSzVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BookingUtilDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Booking Creation 1_Container Type/Size 조회 table-mdm_cntr_tp_sz
	 * 
	 * @param String ofcCd
	 * @return List<MdmSlsRepVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmSlsRepVO> searchSalesTeamList(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmSlsRepVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchSalesTeamListRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmSlsRepVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * MDM Customer을 조회하여 BC에 정보를 Return한다.<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return MdmCustVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmCustVO searchMdmCust(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCustVO> list = null;
		MdmCustVO mdmCustVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOMdmCustVORSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmCustVO.class);

			if (list != null && list.size() > 0) {
				mdmCustVO = (MdmCustVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mdmCustVO;
	}
	
	/**
	 * mdm_cust_cntc_pnt을 조회하여 BC에 정보를 Return한다.<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return MdmCustVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmCustVO searchMdmPhnFaxEml(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCustVO> list = null;
		MdmCustVO mdmCustVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOMdmPhnFaxEmlRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmCustVO.class);

			if (list != null && list.size() > 0) {
				mdmCustVO = (MdmCustVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mdmCustVO;
	}
	
	@SuppressWarnings("unchecked")
	public List<BkgBookingVO> searchTSRoute(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingVO> list = null;
		MdmCustVO mdmCustVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", vo.getBkgNo());

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchTSRouteRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<BkgBookingVO> searchDocTp(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", vo.getBkgNo());

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchDocTpRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BookingUtilDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 특정 Location코드를 가지고 관할하는 SVC Lane 목록을 조회한다.<br>
	 * 
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 */
	/*
	 * @SuppressWarnings("unchecked") public List<MdmVslSvcLaneVO> searchSvcLaneByLoc() throws DAOException { List<MdmVslSvcLaneVO> list = null; // query parameter Map<String, Object> param = new
	 * HashMap<String, Object>(); // velocity parameter Map<String, Object> velParam = new HashMap<String, Object>();
	 * 
	 * try { SQLExecuter sqlExe = new SQLExecuter("DEFAULT"); BookingUtilDBDAOmdmVslSvcLaneRSQL template = new BookingUtilDBDAOmdmVslSvcLaneRSQL(); DBRowSet dbRowset = sqlExe.executeQuery(template,
	 * param, velParam); list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO.class);
	 * 
	 * } catch(SQLException se) { log.error(se.getMessage(),se); throw new DAOException(new ErrorHandler(se).getMessage(), se); } catch(Exception ex) { log.error(ex.getMessage(),ex); throw new
	 * DAOException(new ErrorHandler(ex).getMessage(), ex); } return list; }
	 */
	/**
	 * BookingUtilDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * SVC Lane 목록을 조회한다(콤보용).<br>
	 * 
	 * @return List<MdmVslSvcLaneVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneVO> searchSvcLaneCd() throws DAOException {
		List<MdmVslSvcLaneVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOmdmVslSvcLaneRSQL template = new BookingUtilDBDAOmdmVslSvcLaneRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BookingUtilDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * SVC ContiCd 목록을 조회한다.<br>
	 * 
	 * @return List<ContinentCodeVO>
	 * @throws DAOException
	 */
	public List<ContinentCodeVO> searchSvcContiCd() throws DAOException {
		List<ContinentCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchContiCodeRSQL template = new BookingUtilDBDAOSearchContiCodeRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ContinentCodeVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BookingMasterMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param MdmYardVO vo
	 * @return List<MdmYardVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmYardVO> searchYardCode(MdmYardVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmYardVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOMdmYardVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmYardVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 특정 Location Code 를 조회한다.<br>
	 * 
	 * @param String locCd
	 * @return SearchLocationCodeVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchLocationCodeVO searchLocationCode(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLocationCodeVO> list = null;
		SearchLocationCodeVO vo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("loc_cd", locCd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchLocationCodeRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchLocationCodeVO.class);

			if (list != null && list.size() > 0) {
				vo = (SearchLocationCodeVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}

	/**
	 * Loc_Cd를 밸리데이션 check한다.<br>
	 * @param String locCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean validateLoc(String locCd) throws DAOException {
		boolean bResult = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("loc_cd", locCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOValidateLocRSQL template = new BookingUtilDBDAOValidateLocRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);

			if (dbRowset.next()) {
				bResult = true;
			} else {
				bResult = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}

	/**
	 * RHQ에 대한 Location Code인지를 check 한다.<br>
	 * @param String rhqCd
	 * @param String cntCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean validateLocByOrz(String rhqCd, String cntCd) throws DAOException {
		boolean bResult = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("rgn_ofc_cd", rhqCd);
			param.put("cnt_cd", cntCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOValidateLocByOrzRSQL template = new BookingUtilDBDAOValidateLocByOrzRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);

			if (dbRowset.next()) {
				bResult = true;
			} else {
				bResult = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}
	
	/**
	 * searchBkgCaStatus
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgCaStatus(BkgBlNoVO bkgBlNoVO) throws DAOException {
		// booking status code
		String bkgStsCd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgBlNoVO.getBlNo());
			// mapVO.put("bkg_no_split", bkgBlNoVO.getBlNo());

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOBkgCaStatusRSQL template = new BookingUtilDBDAOBkgCaStatusRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				bkgStsCd = dbRowset.getString("ca_flg");
			} else {
				bkgStsCd = "N";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgStsCd;
	}

	/**
	 * Offce cd를 이용하여 특정 Organization의 정보를 조회한다.<br>
	 * 
	 * @author Park Mangeon
	 * @param String ofcCd
	 * @return MdmOrganizationVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmOrganizationVO searchMdmOrzByOfcCd(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmOrganizationVO> list = null;
		MdmOrganizationVO mdmOrzVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchMdmOrzByOfcCdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO.class);
			if (list.size() > 0) {
				mdmOrzVO = (MdmOrganizationVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mdmOrzVO;
	}

	/**
	 * Offce cd를 이용하여 특정 Loc cd를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String loc_cd
	 * @throws DAOException
	 */
	public String searchLocCdByOfcCd(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String loc_cd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchLocCdByOfcCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				loc_cd = dbRowset.getString("loc_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return loc_cd;
	}

	/**
	 * com_user에서 user_nm을 조회한다.<br>
	 * 
	 * @param String userId
	 * @return String userNm
	 * @throws DAOException
	 */
	public String searchUserName(String userId) throws DAOException {
		String usr_nm = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("usr_id", userId);
			velParam.put("usr_id", userId);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDDAOSearchUserNameRSQL template = new BookingUtilDBDDAOSearchUserNameRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				usr_nm = dbRowset.getString("usr_nm");
			} else {
				usr_nm = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return usr_nm;
	}

	/**
	 * Container No로 조회시 연계된 B/L이 LCL인 경우,관련 B/L List를 조회하고 <br>
	 * LCL이 아닌 경우,단건의 B/L 정보를 조회한다.<br>
	 * 
	 * @param String cntrNo
	 * @return List<SearchBlListByCntrNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBlListByCntrNoVO> searchBlListByCntrNo(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBlListByCntrNoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchBlListByCntrNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchBlListByCntrNoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;

	}

	/**
	 * vsk의 vessel schedule을 조회한다. <br>
	 * 
	 * @param String vsl_cd
	 * @param String skd_voy_no
	 * @param String skd_dir_cd
	 * @param String vps_port_cd
	 * @param String clpt_ind_seq
	 * @return VskVslPortSkdVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public VskVslPortSkdVO searchEtbEtdEta(String vsl_cd, String skd_voy_no, String skd_dir_cd, String vps_port_cd, String clpt_ind_seq) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		VskVslPortSkdVO vskVslPortSkdVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vsl_cd", vsl_cd);
			param.put("skd_voy_no", skd_voy_no);
			param.put("skd_dir_cd", skd_dir_cd);
			param.put("vps_port_cd", vps_port_cd);
			param.put("clpt_ind_seq", clpt_ind_seq);

			velParam.put("vsl_cd", vsl_cd);
			velParam.put("skd_voy_no", skd_voy_no);
			velParam.put("skd_dir_cd", skd_dir_cd);
			velParam.put("vps_port_cd", vps_port_cd);
			velParam.put("clpt_ind_seq", clpt_ind_seq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchEtbEtdEtaRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO.class);

			if (list.size() > 0) {
				vskVslPortSkdVO = (VskVslPortSkdVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vskVslPortSkdVO;

	}

	/**
	 * mdm zone을 조회한다. <br>
	 * 
	 * @param String locationCd
	 * @return List<MdmZoneVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmZoneVO> searchZoneCode(String locationCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmZoneVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("zn_cd", locationCd);
			velParam.put("zn_cd", locationCd);
			;

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchZoneCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmZoneVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Booking no로 split no들을 조회한다. <br>
	 * 
	 * @param String bkgno
	 * @return List<BkgBooking>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgBookingVO> searchBookingSplitNo(String bkgno) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgno);
			velParam.put("bkg_no", bkgno);
			;

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDDAOSearchBookingSplitNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;

	}

	/**
	 * Bkg No로 BDR Flag를 조회한다.. <br>
	 * 
	 * @param BkgBlNoVO vo
	 * @return String bdr_flag
	 * @throws DAOException
	 */
	public String searchBdrFlgByBkg(BkgBlNoVO vo) throws DAOException {
		String bdr_flag = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchBdrFlgByBkgRSQL template = new BookingUtilDBDAOSearchBdrFlgByBkgRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);

			if (dbRowset.next()) {
				bdr_flag = dbRowset.getString("bdr_flg");
			} else {
				bdr_flag = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bdr_flag;
	}

	/**
	 * P.O. No에 둘이상의 B/L 또는 관련 B/L 목록을 List Up하고 아니면 단건의 B/L 항목을 조회한다. <br>
	 * 
	 * @param String poNo
	 * @return List<SearchBlListByPoNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBlListByPoNoVO> searchBlListByPoNo(String poNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBlListByPoNoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cust_ref_no", poNo);
			velParam.put("cust_ref_no", poNo);
			;

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDDAOSearchBlListByPoNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchBlListByPoNoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;

	}

	/**
	 * HB/L No로 BKG NO 조회. <br>
	 * 
	 * @param String hbl_no
	 * @return List<SearchBlListByHblNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBlListByHblNoVO> searchBlListByHblNo(String hbl_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBlListByHblNoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("hbl_no", hbl_no);
			velParam.put("hbl_no", hbl_no);
			;

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchBlListByHblNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchBlListByHblNoVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;

	}

	/**
	 * BKG No로 BKG_PFX_ROUT테이블에서 server 확인. <br>
	 * BKG NO PREFIX 조건<br>
	 * => OFFICE PREFIX 3DIGITbr> => booking no에 부여된 앞자리3개의 PreFixbr>
	 * 
	 * @param BkgBlNoVO vo
	 * @return String svr_id_cd
	 * @throws DAOException
	 */
	public String searchSvrByBkgNo(BkgBlNoVO vo) throws DAOException {
		String svr_id_cd = "";
		String ofc_pfx_cd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (vo.getBkgNo().length() < 3) {
				return svr_id_cd;
			}
			ofc_pfx_cd = vo.getBkgNo().substring(0, 3);
			param.put("ofc_pfx_cd", ofc_pfx_cd);
			velParam.put("ofc_pfx_cd", ofc_pfx_cd);
			;

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchSvrByBkgNoRSQL template = new BookingUtilDBDAOSearchSvrByBkgNoRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);

			if (dbRowset.next()) {
				svr_id_cd = dbRowset.getString("svr_id_cd");
			} else {
				svr_id_cd = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return svr_id_cd;
	}

	/**
	 * bkg별 BDR, C/A 상태 조회.<br>
	 * Table - BKG_BL_DOC<br>
	 * 
	 * @param BkgBlNoVO vo
	 * @return BkgBlNoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgBlNoVO searchBkgBlNoVO(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlNoVO> list = null;
		BkgBlNoVO bkgBlNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchBkgBlNoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlNoVO.class);
			if (list.size() > 0) {
				bkgBlNoVO = (BkgBlNoVO) list.get(0);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgBlNoVO;
	}

	/**
	 * 특정 Country Code 를 조회한다.<br>
	 * Table -mdm_country<br>
	 * 
	 * @param String cntCd
	 * @return MdmCountryVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmCountryVO searchCountryCode(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCountryVO> list = null;
		MdmCountryVO vo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("cnt_cd", cntCd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchCountryCodeRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmCountryVO.class);

			if (list != null && list.size() > 0) {
				vo = (MdmCountryVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}

	/**
	 * HTS Code 체크.<br>
	 * Table -bkg_hamo_trf<br>
	 * 
	 * @param String htsCd
	 * @param String tpCd
	 * @return BkgHamoTrfVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgHamoTrfVO searchHtsCodeDesc(String htsCd, String tpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHamoTrfVO> list = null;
		BkgHamoTrfVO vo = new BkgHamoTrfVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("hamo_trf_cd", htsCd);
			param.put("hamo_tp_cd", tpCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchHtsCodeDescRSQL template = new BookingUtilDBDAOSearchHtsCodeDescRSQL();
			dbRowset = sqlExe.executeQuery(template, param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgHamoTrfVO.class);
			if (list != null && list.size() > 0) {
				vo = (BkgHamoTrfVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}

	/**
	 * Package Code 체크.<br>
	 * Table -mdm_pck_tp<br>
	 * 
	 * @param String pkgcd
	 * @return MdmPckTpVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmPckTpVO searchPkgType(String pkgcd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmPckTpVO> list = null;
		MdmPckTpVO vo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("pck_cd", pkgcd);

			SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchPkgTypeRSQL template = new BookingUtilDBDAOSearchPkgTypeRSQL();
			dbRowset = sqlExec.executeQuery(template, param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmPckTpVO.class);

			if (list != null && list.size() > 0) {
				vo = (MdmPckTpVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}

	/**
	 * imdg_pck_cd값 체크.<br>
	 * 
	 * @param String dgPkgTpCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchPkgTypeForDg(String dgPkgTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("dg_pkg_tp_cd", dgPkgTpCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchPkgTypeForDgRSQL(), param, velParam);
			if (dbRowset.next()) {
				strResult = dbRowset.getString("DGPKGTPCD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}

	/**
	 * vvd, pol로 BDR 여부 조회.<br>
	 * Table -BKG_VVD_BDR_LOG<br>
	 * 
	 * @param BkgVvdVO bkgVvdVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchVvdBdr(BkgVvdVO bkgVvdVO) throws DAOException {
		boolean bResult = false;
		String bdr_flg = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgVvdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchVvdBdrRSQL template = new BookingUtilDBDAOSearchVvdBdrRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);

			if (dbRowset.next()) {
				bdr_flg = dbRowset.getString("bdr_flg");
				if (bdr_flg.equals("Y")) {
					bResult = true;
				} else {
					bResult = false;
				}
			} else {
				bResult = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}

	/**
	 * Vessel(VVD)존재체크.<br>
	 * Table -vsk_vsl_skd<br>
	 * 
	 * @param String vslCd <br>
	 * @param String voyNo <br>
	 * @param String dirCd <br>
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean validateVvd(String vslCd, String voyNo, String dirCd) throws DAOException {
		boolean bResult = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", voyNo);
			param.put("skd_dir_cd", dirCd);

			velParam.put("vsl_cd", vslCd);
			velParam.put("skd_voy_no", voyNo);
			velParam.put("skd_dir_cd", dirCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOValidateVvdRSQL template = new BookingUtilDBDAOValidateVvdRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);

			if (dbRowset.next()) {
				bResult = true;
			} else {
				bResult = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}

	/**
	 * Vessel(VVD)존재체크.<br>
	 * Table -vsk_vsl_port_skd<br>
	 * 
	 * @param String vslCd 
	 * @param String voyNo 
	 * @param String dirCd 
	 * @param String locCd 
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean validateVvdLoc(String vslCd, String voyNo, String dirCd, String locCd) throws DAOException {
		boolean bResult = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", voyNo);
			param.put("skd_dir_cd", dirCd);
			param.put("vps_port_cd", locCd);

			velParam.put("vsl_cd", vslCd);
			velParam.put("skd_voy_no", voyNo);
			velParam.put("skd_dir_cd", dirCd);
			velParam.put("vps_port_cd", locCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOValidateVvdLocRSQL template = new BookingUtilDBDAOValidateVvdLocRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);

			if (dbRowset.next()) {
				bResult = true;
			} else {
				bResult = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return bResult;
	}

	/**
	 * BookingUtilDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * container별 TypeSize조회<br>
	 * table-mst_container<br>
	 * 
	 * @param String cntrNo
	 * @return List<MstContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MstContainerVO> searchTypeSizeByCntr(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MstContainerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			velParam.put("length", cntrNo.length());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchTypeSizeByCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MstContainerVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 하드코딩 조회 <br>
	 * bkg_hrd_cdg_desc, bkg_hrd_cdg_desc에서 hrd_cdg_id를 기준으로 조회한다. <br>
	 * 
	 * @param BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchHardCoding(BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHrdCdgCtntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgHrdCdgCtntListCondVO != null) {
				Map<String, String> mapVO = bkgHrdCdgCtntListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchHardCodingRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BkgNo,BlNo 를 생성,조회한다.<br>
	 * 
	 * @param String blNo
	 * @return BkgBlNoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgBlNoVO chnBlNoCheckDigit(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlNoVO> list = null;
		BkgBlNoVO vo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOChnBlNoCheckDigitRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlNoVO.class);

			if (list != null && list.size() > 0) {
				vo = (BkgBlNoVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}

	/**
	 * MDM TABLE에 존재하는 코드 조회 VSK_PF_SKD_DTL,MDM_VSL_SVC_LANE 테이블에서 SVC_LANE,SKD_DIR_CD 검색으로 한다. <br>
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSvcLaneBound() throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchSvcLaneBoundRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;
	}

	/**
	 * Lane,Pod 유효성 검사.(ESM_BKG_0092)<br>
	 * 
	 * @param String slanCd
	 * @param String podCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchSvcLaneByLoc(String slanCd, String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isCount = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("slan_cd", slanCd);
			param.put("pod_cd", podCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchSvcLaneByLocRSQL(), param, velParam);

			if (dbRowset.next()) {
				if (dbRowset.getInt("CNT") > 0) {
					isCount = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isCount;
	}

	/**
	 * Vendor code Check<br>
	 * 
	 * @param String vendorCntCc 
	 * @param String vendorSeq 
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkVenodrCode(String vendorCntCc, String vendorSeq) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("vndr_cnt_cd", vendorCntCc);
			param.put("vndr_seq", vendorSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOCheckVendorCodeRSQL(), param, velParam);

			if (dbRowset.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * SpecialReportDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String rptId 
	 * @param String bkgRptKndCd  
	 * @return List<ReportItemVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReportItemVO> searchReportItemList(String rptId, String bkgRptKndCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportItemVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rptId != null) {
				param.put("rpt_id", rptId);
				param.put("bkg_rpt_knd_cd", bkgRptKndCd);

				velParam.put("rpt_id", rptId);
				velParam.put("bkg_rpt_knd_cd", bkgRptKndCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOReportItemVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportItemVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * SpecialReportDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String rptId  
	 * @param String bkgRptKndCd  
	 * @return List<ReportItemVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReportItemVO> searchTblColList(String rptId, String bkgRptKndCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportItemVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rptId != null) {
				param.put("rpt_id", rptId);
				param.put("bkg_rpt_knd_cd", bkgRptKndCd);

				velParam.put("rpt_id", rptId);
				velParam.put("bkg_rpt_knd_cd", bkgRptKndCd);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOReportItemVO2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportItemVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 해당 vvd 안에 캐나다 port를 거치는지 조회한다.(ESM_BKG_007901)<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgTrunkVvd  
	 * @param String polCd  
	 * @param String podCd  
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchCanadaFrob(String bkgNo, String bkgTrunkVvd, String polCd, String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isCount = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_trunk_vvd", bkgTrunkVvd);
			param.put("pol_cd", polCd);
			param.put("pod_cd", podCd);
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchCanadaFrobRSQL(), param, velParam);

			if (dbRowset.next()) {
				if (dbRowset.getInt("CNT") > 0) {
					isCount = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isCount;
	}

	/**
	 * 해당 vvd 안에 미국 port를 거치는지 조회한다.(ESM_BKG_007901)<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgTrunkVvd  
	 * @param String polCd  
	 * @param String podCd  
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchUsaFrob(String bkgNo, String bkgTrunkVvd, String polCd, String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isCount = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_trunk_vvd", bkgTrunkVvd);
			param.put("pol_cd", polCd);
			param.put("pod_cd", podCd);
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchUsaFrobRSQL(), param, velParam);

			if (dbRowset.next()) {
				if (dbRowset.getInt("CNT") > 0) {
					isCount = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isCount;
	}

	/**
	 * VSK_PF_SKD_DTL 테이블에서 SVC_LANE,SKD_DIR_CD 조건검색하여 Port cd List를 조회. <br>
	 * 
	 * @param String vsl_slan_cd  
	 * @param String skd_dir_cd  
	 * @param String port_cd  
	 * @return List<SearchSvcLaneBoundVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSvcLaneBoundVO> searchPortCdListByLane(String vsl_slan_cd, String skd_dir_cd, String port_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSvcLaneBoundVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vsl_slan_cd", vsl_slan_cd);
			param.put("skd_dir_cd", skd_dir_cd);
			param.put("port_cd", port_cd);
			
			velParam.put("vsl_slan_cd", vsl_slan_cd);
			velParam.put("skd_dir_cd", skd_dir_cd);
			velParam.put("port_cd", port_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchPortCdListByLaneRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSvcLaneBoundVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * RFA의 가용성을 확인한다.(ESM_BKG_007901)<br>
	 * 
	 * @param String rfaNo  
	 * @param BkgBlNoVO bkgBlNoVO 
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchRfaAvailable(String rfaNo, BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isCount = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("rfa_no", rfaNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchRfaAvailableRSQL(), param, velParam);

			if (dbRowset.next()) {
				if (dbRowset.getInt("cnt") > 0) {
					isCount = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isCount;
	}

	/**
	 * SC NO의 가용성을 확인한다..(ESM_BKG_007901)<br>
	 * 
	 * @param String scNo  
	 * @param BkgBlNoVO bkgBlNoVO  
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchScAvailable(String scNo, BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isCount = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("sc_no", scNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchScAvailableRSQL(), param, velParam);

			if (dbRowset.next()) {
				if (dbRowset.getInt("cnt") > 0) {
					isCount = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isCount;
	}

	/**
	 * Booking Split 번호를 조회  <br>
	 * 
	 * @param String bkgNo
	 * @return List<SplitNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SplitNoVO> searchBkgSplitNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SplitNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchBkgSplitNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SplitNoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 원 Booking의 BL번호를 조회 <br>
	 * 
	 * @param String bkgNo
	 * @return SplitMstBlNoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SplitMstBlNoVO searchSplitMstBlNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SplitMstBlNoVO> list = null;
		SplitMstBlNoVO splitMstBlNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchSplitMstBlNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SplitMstBlNoVO.class);
			if (list != null && list.size() > 0) {
				splitMstBlNoVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return splitMstBlNoVO;
	}

	/**
	 * bkg_hrd_cdg 테이블을 수정한다.
	 * 
	 * @param bkgHrdCdgCtntVOs
	 * @throws DAOException
	 */
	public void addHardCoding(List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgHrdCdgCtntVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingUtilDBDAOAddHardCodingCSQL(), bkgHrdCdgCtntVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * bkg_hrd_cdg 테이블을 수정한다.
	 * 
	 * @param bkgHrdCdgCtntVOs
	 * @throws DAOException
	 */
	public void modifyHardCoding(List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgHrdCdgCtntVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingUtilDBDAOModifyHardCodingUSQL(), bkgHrdCdgCtntVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * bkg_hrd_cdg 테이블을 삭제한다.
	 * 
	 * @param bkgHrdCdgCtntVOs
	 * @throws DAOException
	 */
	public void removeHardCoding(List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgHrdCdgCtntVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingUtilDBDAORemoveHardCodingDSQL(), bkgHrdCdgCtntVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MDM_PCK_TP 의 package code 의 적합 여부.
	 * 
	 * @param pckTpCd
	 * @return
	 */
	public boolean validatePkgType(String pckTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("pck_cd", pckTpCd);

			SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOValidatePkgTypeRSQL template = new BookingUtilDBDAOValidatePkgTypeRSQL();
			dbRowset = sqlExec.executeQuery(template, param, velParam);
			return dbRowset.next();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * check HtsCode By Cm
     * 
     * @param hamoTpCd
     * @param hamoTrfCd
     * @return String
     * @exception DAOException
     */
    public String checkHtsCodeByCm(String hamoTpCd, String hamoTrfCd) throws DAOException {
        DBRowSet dbRowset = null;
        String result = "N";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("hamo_tp_cd", hamoTpCd);
            mapVO.put("hamo_trf_cd", hamoTrfCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BookingUtilDBDAOHtsCodeByCmRSQL template = new BookingUtilDBDAOHtsCodeByCmRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                result = dbRowset.getString(1);
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return result;
    }

    /**
     * NCM Code Desc. 조회.
     * 
     * @param ncmNo
     * @return String 
     * @exception DAOException
     */
    public String searchNcmCodeDesc(String ncmNo) throws DAOException {
        DBRowSet dbRowset = null;
        String rsStr = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("mf_cmdt_cd", ncmNo);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);


            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            BookingUtilDBDAONcmCodeDescRSQL template = new BookingUtilDBDAONcmCodeDescRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()){
                rsStr = dbRowset.getString(1);
            }
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsStr;
    }

	/**
	 * ESM_BKG_0079_02B : receive header String생성
	 * 
	 * @author Lee NamKyung
	 * @param String sndrId
	 * @param String rcvId
	 * @param String msgId
	 * @return String
	 * @exception DAOException
	 */
	public String searchEdiHeader(String sndrId, String rcvId, String msgId) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("sndr_id", sndrId);
			param.put("rcv_id", rcvId);
			param.put("msg_id", msgId);

			velParam.put("sndr_id", sndrId);
			velParam.put("rcv_id", rcvId);
			velParam.put("msg_id", msgId);

			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOSearchEdiHeaderRSQL(), param, velParam);
			if (dbRowset.next()) {
				strReturn = dbRowset.getString("str_flatfile");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strReturn;
	}

	/**
	 * ESM_BKG_0079_01 : VVD로 Lane 조회
	 * 
	 * @author KimByungKyu
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchSvcLaneByVvd(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);

			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOSearchSvcLaneByVvdRSQL(), param, velParam);
			if (dbRowset.next()) {
				strReturn = dbRowset.getString("vsl_slan_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strReturn;
	}

	/**
	 * VVD 변경후 Save시, 승인 요청된 special cargo application이 있는 경우
	 * 
	 * @author KimByungKyu
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return Boolean
	 * @throws DAOException
	 */
	public boolean searchSpclApplForChange(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOSearchSpclApplForChangeRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getInt("CNT") > 0) {
					isOk = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isOk;
	}

	/**
	 * 미주향 BOOKING이면서 특정 화주의 경우 PO가 반드시 입력되어야함
	 * 
	 * @author KimByungKyu
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String scNo
	 * @return Boolean
	 * @throws DAOException
	 */
	public boolean searchPoNoLengthByDtl(BkgBlNoVO bkgBlNoVO, String custCntCd, String custSeq, String scNo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
			param.put("sc_no", scNo);

			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOSearchPoNoLengthByDtlRSQL(), param, velParam);
			if (dbRowset.next()) {
				if ("Y".equals(dbRowset.getString("error"))) {
					isOk = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isOk;
	}

	/**
	 * mdm_commodity의 commodity의 이름 조회
	 * 
	 * @param cmdtCd cmdt cd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMdmCmdtDesc(String cmdtCd) throws DAOException {
		// booking status code
		String cmdtDesc = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cmdt_cd", cmdtCd);
			velParam.put("cmdt_cd", cmdtCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchMdmCmdtDescRSQL template = new BookingUtilDBDAOsearchMdmCmdtDescRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				cmdtDesc = dbRowset.getString("cmdt_nm");
			} else {
				cmdtDesc = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cmdtDesc;
	}

	/**
	 * P/O 자리수 체크
	 * 
	 * @param bkgBlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPoNoLength(BkgBlNoVO bkgBlNoVO) throws DAOException {
		// booking status code
		String bkgFlag = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgBlNoVO.getBkgNo());

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchPoNoLengthRSQL template = new BookingUtilDBDAOsearchPoNoLengthRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				bkgFlag = dbRowset.getString("cust_ref_no");
			} else {
				bkgFlag = "N";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgFlag;
	}

	/**
	 * bkg no, cntr no로 mvmt의 container movement status를 조회한다.(ESM_BKG_0079_01) <br>
	 * 
	 * @author KimByungKyu
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String cntrNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchMVMTStatus(BkgBlNoVO bkgBlNoVO, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtnArray = null;
		List<String> strArray = new ArrayList<String>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);

			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOSearchMVMTStatusRSQL(), param, velParam);
			
			while (dbRowset.next()){
				if(dbRowset.getString("CNMV_STS_CD")!=null && dbRowset.getString("CNMV_STS_CD").length()>1){
					strArray.add(dbRowset.getString("CNMV_STS_CD"));
				}
			}

			rtnArray = new String[strArray.size()];
			for(int i=0;i<strArray.size();i++){
				rtnArray[i] = strArray.get(i);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rtnArray;
	}

	/**
	 * 화면안에서 security control<BR>
	 * 특정 화면 open 시에 user ID 별 또는 user가 속한 country code 별로 버튼 enable/disable 여부를 판단.<BR>
	 * 
	 * @param AcssAlwInfoVO vo
	 * @return Boolean
	 * @throws DAOException
	 */
	public boolean checkIfAccsIsAlw(AcssAlwInfoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOAcssAlwInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getInt("CNT") > 0) {
					isOk = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isOk;
	}

	/**
	 * VSK_VSL_PORT_SKD 테이블에서 VVD 조건검색하여 Port cd List를 조회. <br>
	 * 
	 * @param String vvd
	 * @return List<VskVslPortSkdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPortCdByVvdVO> searchPortCdListByVvd(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPortCdByVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd_cd", vvd);
			velParam.put("vvd_cd", vvd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchPortCdByVvdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchPortCdByVvdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * COM_USER 테이블에서 ofc_cd 조건검색하여 STAFF 정보를 조회.
	 * 
	 * @param String ofc_cd
	 * @return List<StaffListByOfcCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StaffListByOfcCdVO> searchStaffListByOfcCd(String ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<StaffListByOfcCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (!JSPUtil.getNull(ofc_cd).equals("")) {
				ofc_cd = "'" + (ofc_cd.replaceAll(",", "','") + "'");
			}
			param.put("ofc_cd", ofc_cd);
			velParam.put("ofc_cd", ofc_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchStaffListByOfcCdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, StaffListByOfcCdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BookingComboUtilDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * DMT_OFC_LVL_V에서 REGION 콤보리스트 조회-ESM_BKG_0226
	 * 
	 * @return List<BkgComboVO>
	 * @throws DAOException
	 */
	public List<BkgComboVO> searchRgnOfficeCd() throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchRgnOfficeCdRSQL template = new BookingUtilDBDAOSearchRgnOfficeCdRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<BkgComboVO>();
			while (dbRowset.next()) {
				BkgComboVO vo = new BkgComboVO();
				vo.setVal(dbRowset.getString("region_cd"));
				vo.setDesc(dbRowset.getString("region_cd"));
				vo.setName(dbRowset.getString("region_nm"));
				list.add(vo);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Memo Split 된 BKG에 대해서 최초에 생성된 BKG을 FIND. (ESM_BKG_0906) <br>
	 * 
	 * @author Lee NamKyung
	 * @param BkgBlNoVO vo
	 * @return MemoSplitMasterBkgVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MemoSplitMasterBkgVO searchMemoSplitMstBkg(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MemoSplitMasterBkgVO> list = null;
		MemoSplitMasterBkgVO memoSplitMasterBkgVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchMemoSplitMstBkgRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MemoSplitMasterBkgVO.class);
			if (list != null && list.size() > 0) {
				memoSplitMasterBkgVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return memoSplitMasterBkgVO;
	}

	/**
	 * ESM_BKG_0906 : currency code 조회 <br>
	 * 
	 * @author Lee NamKyung
	 * @param String currCd
	 * @return String
	 * @exception EventException
	 */
	public String searchMdmCurr(String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("curr_cd", currCd);
			velParam.put("curr_cd", currCd);

			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOSearchMdmCurrRSQL(), param, velParam);
			if (dbRowset.next()) {
				strReturn = dbRowset.getString("curr_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strReturn;
	}

	/**
	 * BKG의 CGO TYPE을 조회한다. <br>
	 * 
	 * @author KymByungKyu
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgCgoTp(BkgBlNoVO bkgBlNoVO) throws DAOException {
		String bkgCgoTpCd = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOSearchBkgCgoTpRSQL(), param, velParam);
			if (dbRowset.next()) {
				bkgCgoTpCd = dbRowset.getString("BKG_CGO_TP_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgCgoTpCd;
	}

	/**
	 * Office Code로 Server ID를 조회한다. <br>
	 * 
	 * @author KimByungKyu
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchSvrByOfc(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchSvrByOfcRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnString = dbRowset.getString("svr_id_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * Sender Id, Sender Tp Code(CUST)로 Host Id를 조회한다. <br>
	 * 
	 * @author Jun Yong Jin
	 * @param String rcvId <br>
	 * @param String sndrTpCd <br>
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdi301HostId(String rcvId, String sndrTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("rcv_id", rcvId);
			velParam.put("sndr_tp_cd", sndrTpCd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchEdi301HostIdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnString = dbRowset.getString("host_tp_id");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * Customer Alert 메시지를 조회한다. <br>
	 * 
	 * @author KimByungKyu
	 * @param String custCntCd
	 * @param String custSeq
	 * @return String
	 * @throws DAOException
	 */
	public String searchAlertCust(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchAlertCustRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnString = dbRowset.getString("bkg_alt_msg");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * Prd로 보낼 Booking 정보를 조회한다. <br>
	 * 
	 * @author KimByungKyu
	 * @param PrdMainInfoVO prdMainInfoVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return PrdMainInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PrdMainInfoVO searchPrdBkg(PrdMainInfoVO prdMainInfoVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PrdMainInfoVO> list = null;
		PrdMainInfoVO rtnPrdMainInfoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			velParam.put("ca_flg", bkgBlNoVO.getCaFlg());
			if (prdMainInfoVO != null) {
				Map<String, String> mapVO = prdMainInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchPrdBkgRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PrdMainInfoVO.class);
			if (list != null && list.size() > 0) {
				rtnPrdMainInfoVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnPrdMainInfoVO;
	}

	/**
	 * Prd로 보낼 Booking Quantity 정보를 조회한다. <br>
	 * 
	 * @author KimByungKyu
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<PrdQtyInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PrdQtyInfoVO> searchPrdQty(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PrdQtyInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchPrdQtyRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PrdQtyInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * VVD코드로 VSL_NM을 조회한다.(ESM_BKG_0229) <br>
	 * 
	 * @author Jun Yong Jin
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchVslNm(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchVslNmRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnString = dbRowset.getString("VSL_ENG_NM");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * bkg의 cntr_no목록을 조회한다.(ESM_BKG_0076) <br>
	 * 
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchCntrListByBkg(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtnArray = null;
		List<String> strArray = new ArrayList<String>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchCntrListByBkgRSQL(), param, velParam);
//			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOsearchCntrListByBkgRSQL(), param, velParam);
			
			while (dbRowset.next()){
				if(dbRowset.getString("CNTR_NO")!=null && dbRowset.getString("CNTR_NO").length()>9){
					strArray.add(dbRowset.getString("CNTR_NO"));
				}
			}

			rtnArray = new String[strArray.size()];
			for(int i=0;i<strArray.size();i++){
				rtnArray[i] = strArray.get(i);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rtnArray;
	}

	/**
	 * POR,DEL 유효성 검사.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu
	 * @param String locCd
	 * @param String nodeCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchNodeCode(String locCd, String nodeCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try {
			param.put("locCd", locCd);
			param.put("nodeCd", nodeCd);
			if (nodeCd == null){
				velParam.put("nodeCd", "");
			} else if (nodeCd.length() < 7) {
				velParam.put("nodeCd", "");
			} else {
				velParam.put("nodeCd", nodeCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchNodeCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getInt("CNT") > 0) {
					isOk = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isOk;
	}

	/**
	 * pol, pod는 marine terminal이어야 한다.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu
	 * @param String locCd
	 * @param String ydCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchMarineYard(String locCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try {
			param.put("locCd", locCd);
			param.put("ydCd", ydCd);
			if (ydCd.length() < 7) {
				velParam.put("ydCd", "");
			} else {
				velParam.put("ydCd", ydCd);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchMarineYardRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getInt("CNT") > 0) {
					isOk = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isOk;
	}

	/**
	 * ocean route의 vvd 들이 etd, eta의 순서가 맞는지 확인하여 true/false로 return한다.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu
	 * @param VslSkdVO vslSkdVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchVslOrder(VslSkdVO vslSkdVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;
		try {
			if (vslSkdVO != null) {
				param.put("befVvd", vslSkdVO.getBefVvd());
				param.put("befPodCd", vslSkdVO.getBefPodCd());
				param.put("befClptIndSeq", vslSkdVO.getBefClptIndSeq());
				param.put("curVvd", vslSkdVO.getCurVvd());
				param.put("curPolCd", vslSkdVO.getCurPolCd());
				param.put("curClptIndSeq", vslSkdVO.getCurClptIndSeq());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchVslOrderRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getInt("CNT") > 0) {
					isOk = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isOk;
	}

	/**
	 * BKG_SLS_REP 테이블 SREP_CD 정보를 조회합니다.<br>
	 * 
	 * @param String ofc_cd
	 * @return List<SearchSrepCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSrepCdListVO> searchSrepCdList(String ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSrepCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofc_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchSrepCdListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSrepCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Location/Node 존재여부 체크 <br>
	 * 
	 * @author Lee NamKyung
	 * @param String locCd
	 * @param String znCd
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchZone(String locCd, String znCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean isOk = false;

		try {
			param.put("loc_cd", locCd);
			param.put("zn_cd", znCd);
			if (znCd.length() < 7) {
				velParam.put("zn_cd", "");
			} else {
				velParam.put("zn_cd", znCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchZoneRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getInt("CNT") > 0) {
					isOk = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return isOk;
	}

	/**
	 * 세관 package (customsdeclaration)에서 사용하는 Flat File Header 생성 <br>
	 * 
	 * @author Min Dong Jin
	 * @param String sndrId <br>
	 * @param String rcvId <br>
	 * @param String msgId <br>
	 * @return String
	 * @throws EventException
	 */
	public String searchCstmsEdiHeader(String sndrId, String rcvId, String msgId) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("sndr_id", sndrId);
			param.put("rcv_id", rcvId);
			param.put("msg_id", msgId);

			velParam.put("sndr_id", sndrId);
			velParam.put("rcv_id", rcvId);
			velParam.put("msg_id", msgId);

			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOSearchCstmsEdiHeaderRSQL(), param, velParam);
			if (dbRowset.next()) {
				strReturn = dbRowset.getString("str_flatfile");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strReturn;
	}

	/**
	 * Booking 테이블의 ofc_cd값을 반환한다. <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgOfcByBkg(BkgBlNoVO bkgBlNoVO) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchBkgOfcByBkgRSQL template = new BookingUtilDBDAOsearchBkgOfcByBkgRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("bkg_ofc_cd");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}

	/**
	 * BKG_HRD_CDG_CTNT 테이블에 신규 하드 코딩 값 생성 <br>
	 * 
	 * @param bkgHrdCdgCtnts
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBkgHrdCdgCtnt(List<BkgHrdCdgCtntVO> bkgHrdCdgCtnts) throws DAOException, Exception {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if (bkgHrdCdgCtnts.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingUtilDBDAOaddBkgHrdCdgCtntCSQL(), bkgHrdCdgCtnts, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BKG_HRD_CDG_CTNT 테이블에 기존 하드 코딩 값 갱신 <br>
	 * 
	 * @param bkgHrdCdgCtnts
	 * @throws DAOException
	 */
	public void modifyBkgHrdCdgCtnt(List<BkgHrdCdgCtntVO> bkgHrdCdgCtnts) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgHrdCdgCtnts.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingUtilDBDAOmodifyBkgHrdCdgCtntUSQL(), bkgHrdCdgCtnts, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * removeBkgHrdCdgCtnt <br>
	 * 
	 * @param bkgHrdCdgCtnts
	 * @throws DAOException
	 */
	public void removeBkgHrdCdgCtnt(List<BkgHrdCdgCtntVO> bkgHrdCdgCtnts) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgHrdCdgCtnts.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingUtilDBDAOremoveBkgHrdCdgCtntDSQL(), bkgHrdCdgCtnts, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI로 전송할 BKG의 Customer정보를 조회한다. <br>
	 * 
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String tpCd
	 * @param String autoManualFlg
	 * @return List<CustTpIdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustTpIdVO> searchEdiCustTpId(BkgBlNoVO bkgBlNoVO, String tpCd, String autoManualFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustTpIdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("tp_cd", tpCd);
			velParam.put("tp_cd", tpCd);
			param.put("auto_manual_flg", autoManualFlg);
			velParam.put("auto_manual_flg", autoManualFlg);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchEdiCustTpIdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustTpIdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * spilt 되기전 최초 mty bkg을 조회<br>
	 * 
	 * @author KimByungKyu
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchSplitMstBkgNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchSplitMstBkgNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnString = dbRowset.getString("FM_BKG_NO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(String OfficeCd)를 호출하는 method<br>
	 * 즉, Office Cd의 Local Time을 YYYY-MM-DD HH24:MI:SS 포맷의 string으로 반환
	 * @author	Min, DongJin
	 * @param 	String ofcCd
	 * @return 	String
	 * @throws DAOException
	 */
	public String searchTimeLocalOfcFnc(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchTimeLocalOfcFncRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnString = dbRowset.getString("OFC_LCL_DT_TM");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}

	/**
	 * GLOBALDATE_PKG.TIME_CONV_FNC 를 호출하는 method<br>
	 * User Local Time을 YYYY-MM-DD HH24:MI:SS 포맷의 string으로 반환
	 * @author	Jang, JiYoung
	 * @param 	String usrLocCd
	 * @return 	String
	 * @throws DAOException
	 */
	public String searchLocalTime(String usrLocCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("usr_loc_cd", usrLocCd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchLocalTimeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnString = dbRowset.getString("LCL_DT_TM");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}
	
	/**
	 * bkg no로 bkg_bl_iss에서 OBL_RLSE_FLG & BL_NO를 조회한다.<br>
	 * 
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @return OblIssVO 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public OblIssVO searchOblIssue(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OblIssVO> list = null;
		OblIssVO oblIssVO = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchOblIssueRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OblIssVO.class);
			if (list != null && list.size() > 0) {
				oblIssVO = list.get(0);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return oblIssVO; 
	}
	
   	/**
	 * bkg으로 해당 vvd, port에서 close 되었는지 확인하여<br>
	 * close 되어 있을 경우 해당 bkg으로 notice에 포함될 내용을 조회한다.<br>
	 * @author Ryu Daeyoung
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String ofcCd
	 * @return BkgCloseVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCloseVO searchBkgClose(BkgBlNoVO bkgBlNoVO, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCloseVO> list = null;
		BkgCloseVO bkgCloseVO = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			param.put("ofc_cd", ofcCd);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchBkgCloseRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCloseVO.class);
			if (list != null && list.size() > 0) {
				bkgCloseVO = list.get(0);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return bkgCloseVO; 
	}
	
	/**
	 * ESM_Booking_Util_01 화면에서 입력받은 Sql 실행.<br>
	 * 
	 * @param  String  sql
	 * @return String
	 * @throws DAOException, Exception
	 */
	public String  executeQuery(String sql) throws DAOException, Exception {
		//Connection con = null;
        //CallableStatement cstmt = null; 

		String retVal = "";
        
		try {
			Pattern insertP = Pattern.compile("^INSERT");
			Pattern updateP = Pattern.compile("^UPDATE");
			Pattern deleteP = Pattern.compile("^DELETE");
			Pattern selectP = Pattern.compile("^SELECT");
			Pattern mergeP = Pattern.compile("^MERGE");
			
			Pattern procedureP = Pattern.compile("^CALL");
			String sql2 = sql.toUpperCase();
			String resultString ="";
			if(insertP.matcher(sql2).find()){
				resultString = " rows Inserted";	
			}else if(mergeP.matcher(sql2).find()){
				resultString = " rows Inserted";		
			}else if(updateP.matcher(sql2).find()){
				resultString = " rows Updated";	
			}else if(deleteP.matcher(sql2).find()){
				resultString = " rows Deleted";
			}else if(selectP.matcher(sql2).find()){
				resultString = " rows Selected";
			}else if(procedureP.matcher(sql2).find()){
				resultString = "PL/SQL Execution Success";
			}else{ 
				//return "ERROR This Application is only for the CRUD !!";
				retVal = "ERROR This Application is only for the CRUD !!";
			}
		
			
			if("".equals(retVal)) {
			
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				int insCnt = 0;
				if (JSPUtil.getNull(sql) != "") {
	
					param.put("sql",sql);
					velParam.put("sql",sql);
	
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					
					if(resultString.equals( " rows Selected")){
						
						DBRowSet dbRowset = null;
						param.put("sql", sql + " and rownum <= 100");
						velParam.put("sql", sql + " and rownum <= 100");
						
						dbRowset = sqlExe.executeQuery((ISQLTemplate) new BookingUtilDBDAOExcuteQueryUSQL(), param, velParam);
						insCnt = dbRowset.getRowCount();
						
						ResultSetMetaData meta = dbRowset.getMetaData();
			            int colCount = meta.getColumnCount() + 1;
			            if(insCnt >= 100){
			            	resultString = resultString + "(Being forced to limit to the Maximum 100 rows)";
			            }
			            StringBuffer sb = new StringBuffer("<table>");
			            
			            sb.append("<tr bgcolor='#F0F0F0'>");
			            sb.append("<td></td>");
			            for(int i = 1; i < colCount; i++){
			            	sb.append("<td nowrap='nowrap'>").append(dbRowset.getMetaData().getColumnName(i)).append("</td>");
			            }
			            sb.append("</tr>");
			            
			            int cnt = 1;
						while(dbRowset.next()){
							sb.append("<tr>");
							sb.append("<td nowrap='nowrap' align='center'>").append(cnt).append("</td>");
							for (int i = 1; i < colCount; i++) {
								if(dbRowset.getMetaData().getColumnType(i) == 2005)
									sb.append("<td>").append(dbRowset.getString(i)).append("</td>");
			                    else
			                    	sb.append("<td>").append(dbRowset.getObject(i)).append("</td>");
							}
							sb.append("</tr>");
							cnt++;
						}
						sb.append("<table>");
						resultString = resultString+sb.toString();
					}
//					else if(resultString.equals( "PL/SQL Execution Success")){
//						sql = "{"+ sql +"}";
//						con = getConnection(); 
//				        cstmt = con.prepareCall(sql); 
//				        String[] tempArr = sql.split("\\?");
//				        for (int i = 1; i < tempArr.length; i++) {
//				        	cstmt.registerOutParameter(i++, java.sql.Types.VARCHAR ); 
//				        }
//				        
//				        cstmt.executeUpdate(); 
//				        for (int i = 0; i < tempArr.length-1; i++) {
//				        	resultString = resultString + "\n" + cstmt.getString(++i) + "\n";
//				        }
//				        //return resultString;
//				        retVal = resultString;
//				        
//				        closeStatement(cstmt);
//					    closeConnection(con);
//				   }
					else{
					   
						insCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingUtilDBDAOExcuteQueryUSQL(), param, velParam);
					}
					
					if("".equals(retVal)){
						if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
					}
				}
				return resultString.equals( "PL/SQL Execution Success")? resultString: insCnt + resultString;  //2010.11.04 R4J 관련 수정 KHH
				//retVal = resultString.equals( "PL/SQL Execution Success")? resultString: insCnt + resultString;  //2010.11.04 R4J 관련 수정 KHH
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		} finally {
//	       closeStatement(cstmt);
//	       closeConnection(con);
		}
		return retVal;
	}
	
	/**
	 * user가 해당 bkg의 office에 있는지 확인<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  SignOnUserAccount account
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchOfcVsBkgOfc(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws DAOException{
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			param.put("bkg_ofc_cd", account.getOfc_cd());

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchOfcVsBkgOfcRSQL(), param, velParam);
			if(dbRowset.next()){
				if(dbRowset.getInt("CNT") > 0){
					result = true;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * mdm_commodity의 rep_commodity code 조회
	 * 
	 * @param cmdtCd cmdt cd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMdmCmdt(String cmdtCd) throws DAOException {
		// booking status code
		String cmdtDesc = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cmdt_cd", cmdtCd);
			velParam.put("cmdt_cd", cmdtCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchMdmCmdtRSQL template = new BookingUtilDBDAOsearchMdmCmdtRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				cmdtDesc = dbRowset.getString("rep_cmdt_cd");
			} else {
				cmdtDesc = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cmdtDesc;
	}
	/**
	 * mdm_commodity의 rep_commodity name 조회
	 * 
	 * @param String repCmdtCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchRepCmdtNm(String repCmdtCd) throws DAOException {
		// booking status code
		String cmdtDesc = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("rep_cmdt_cd", repCmdtCd);
			velParam.put("rep_cmdt_cd", repCmdtCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchMdmRepCmdtNmRSQL template = new BookingUtilDBDAOsearchMdmRepCmdtNmRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				cmdtDesc = dbRowset.getString("rep_cmdt_nm");
			} else {
				cmdtDesc = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cmdtDesc;
	}
	
	
	
	/**
	 * bkg의 pol의 service group id를 조회한다(기존 server id)<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchPolSvrByBkgNo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sysAreaGrpId = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgBlNoVO.getBkgNo());
			velParam.put("bkg_no", bkgBlNoVO.getBkgNo());

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchPolSvcByBkgNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				sysAreaGrpId = dbRowset.getString("SYS_AREA_GRP_ID");
			} else {
				sysAreaGrpId = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sysAreaGrpId;
	}
	
    /**
     * 해당 bkg의 tro, cntr에 대해서 s/o가 issue 되었는지 조회한다.<br>
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String boundCd
     * @return String
     * @throws DAOException
     */
    public String searchSoStatus(String bkgNo, String cntrNo, String boundCd) throws DAOException {
    	DBRowSet dbRowset = null;
		String rtn = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("bound_cd", boundCd);
			velParam.put("bkg_no", bkgNo);
			velParam.put("cntr_no", cntrNo);
			velParam.put("bound_cd", boundCd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchSoStatusRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn = dbRowset.getString("RSLT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtn;
    }	


    /**
     *  미 세관신고로 download 이후 VVD, POD, DEL을 변경한 경우.(ESM_BKG_0079_01) <br>
     *
     * @author      KimByungKyu
     * @param       BkgBlNoVO bkgBlNoVO
     * @return      boolean
     * @exception   DAOException
     */
    public boolean searchUsaCstmsDownload(BkgBlNoVO bkgBlNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        boolean isOk = false;
        try{
            Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
            BookingUtilDBDAOUsaCstmsDownloadRSQL template = new BookingUtilDBDAOUsaCstmsDownloadRSQL();
            
            dbRowset = sqlExec.executeQuery(template, param, velParam);
            if(dbRowset.next() && dbRowset.getInt(1) > 0){
                isOk = true;
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isOk;
    }
	/**
	 * Taa NO의 가용성을 확인한다.<br>
	 * @param String taaNo 
	 * @param BkgBlNoVO bkgBlNoVO 
	 * @return boolean
	 * @throws Exception
	 * @throws DAOException
	 */
	public boolean searchTaaAvailable(String taaNo, BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isCount = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.put("taa_no", taaNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchTaaAvailableRSQL(), param, velParam);

			if (dbRowset.next()) {
				if (dbRowset.getInt("cnt") > 0) {
					isCount = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return isCount;
	}	

	/**
	 * BKG_CHN_AGN에 CHN_AGN_CD 존재 여부 조회 <br>
	 * 
	 * @param String chnAgnCd
	 * @param String delIncFlag
	 * @return String existFlg
	 * @exception DAOException
	 */
	public String checkChnAgnCd(String chnAgnCd,String delIncFlag) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("chn_agn_cd", chnAgnCd);
			mapVO.put("del_inc_flag", delIncFlag);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOCheckDBChnAgnCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString("exist_flg");
			}
			else {
				return "N";
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	


	/**
	 * 중국 agent를 사용하는 지역인지 조회한다.(ESM_BKG_0079, 0229)<br>
	 *
	 * @author Ryu Daeyoung
	 * @param String usrId
	 * @return String
	 * @exception DAOException
	 */
	public String searchChnAgtUse(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		String receiptTypeCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(usrId != null){
				param.put("usr_id", usrId);
				velParam.put("usr_id", usrId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchChnAgtUseRSQL(), param, velParam);
			while (dbRowset.next()) {
				receiptTypeCd = dbRowset.getString("RECEIPT_TYPE_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return receiptTypeCd;
	}
	
	/**
	 * Booking의 route 정보를 조회한다.(ESM_BKG_0079_07, 0178)<br>
	 *
	 * @author Jeon Sungjin
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgRouteVO searchBkgRoute(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		BkgRouteVO bkgRouteVO = null;
		List<BkgRouteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchBkgRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRouteVO.class);
			if (list != null && list.size() > 0) {
				bkgRouteVO = list.get(0);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgRouteVO;
	}

	
	/**
	 * 대표 email 및 ofc cd 구하는 함수 <br>
	 * <pre>
	 * gubun: EM:EMAIL, OFC:OFC_CD
	 * </pre>
	 * @author Kim Gyoung sub
	 * @param String bkg_no
	 * @param String usr_id
	 * @param String gubun
	 * @param String blNtcKndCd
	 * @return String output_text
	 * @exception DAOException 
	 */
	public String searchGroupEmailAddrRSQL(String bkg_no, String usr_id, String gubun, String blNtcKndCd) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkg_no);
			mapVO.put("usr_id", usr_id);
			mapVO.put("gubun", gubun);
			mapVO.put("blNtcKndCd", blNtcKndCd);
			
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchGroupEmailAddrRSQL template = new BookingUtilDBDAOSearchGroupEmailAddrRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("RTN_VAL");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}
	
	/**
	 *  CC 로 처리 되는 대표 email 조회 <br>
	 * <pre>
	 * gubun: EM:EMAIL, OFC:OFC_CD
	 * </pre>
	 * @author Kim Gyoung sub
	 * @param String bkg_no
	 * @param String usr_id
	 * @param String gubun
	 * @param String blNtcKndCd
	 * @return String output_text
	 * @exception DAOException 
	 */
	public String searchGroupCcEmailAddrRSQL(String bkg_no, String usr_id, String gubun, String blNtcKndCd) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkg_no);
			mapVO.put("usr_id", usr_id);
			mapVO.put("gubun", gubun);
			mapVO.put("blNtcKndCd", blNtcKndCd);
			
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchGroupCcEmailAddrRSQL template = new BookingUtilDBDAOSearchGroupCcEmailAddrRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("RTN_VAL");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}	
	
	/**
	 * Cc email address 구하는 함수 <br>
	 * @param String ntc_knd_cd
	 * @param String usr_id
	 * @return String output_text
	 * @exception DAOException 
	 */
	public String searchCcEmailAddrRSQL(String ntc_knd_cd, String usr_id) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("usr_id", usr_id);
			mapVO.put("ntc_knd_cd", ntc_knd_cd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchCcEmailAddrRSQL template = new BookingUtilDBDAOSearchCcEmailAddrRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("EMAIL");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}
	

	/**
	 * 중국 agent를 사용하는 지역인지 조회한다.(ESM_BKG_0079, 0229)<br>
	 *
	 * @author Ryu Daeyoung
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchFrtTerm(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String frtTermCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchFrtTermRSQL(), param, velParam);
			while (dbRowset.next()) {
				frtTermCd = dbRowset.getString("FRT_TERM_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return frtTermCd;
	}
	
    /**
     * 유럽 tro에 대해서 ctm에서 issue한 s/o가 있는지 조회한다..<br>
     * @author 	Ryu Dae Young
     * @param  	String bkgNo
     * @return 	String
     * @throws Exception
	 * @throws DAOException
     */
	public String searchCtmSoStatus(String bkgNo) throws DAOException {
	   	DBRowSet dbRowset = null;
		String rtn = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchCtmSoStatusRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn = dbRowset.getString("RSLT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
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
	public String searchVslSvcTpCd(String vvd) throws DAOException {
	   	DBRowSet dbRowset = null;
		String rtn = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchVslSvcTpCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn = dbRowset.getString("RSLT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtn;
	}
		
    /**
     * Country에 해당하는 State 조회<br>
     * @author 	Jeon Sung Jin
     * @param  	String cnt_cd
     * @param  	String ste_cd
     * @return 	List<String>
     * @throws EventException
     */
	public List<String> searchStateByCountry(String cnt_cd, String ste_cd) throws DAOException {
	   	DBRowSet dbRowset = null;
		List<String> rtnList =  new ArrayList<String>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cnt_cd", cnt_cd);
			param.put("ste_cd", ste_cd);
			velParam.put("cnt_cd", cnt_cd);
			velParam.put("ste_cd", ste_cd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchStateByCountryRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnList.add(dbRowset.getString("ste_cd"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnList;
	}

    /**
     * 해당 bkg이 NL 지역에 들리는 지 조회<br>
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
     * @throws EventException
     */
	public String searchNlFlagByBkg(BkgBlNoVO bkgBlNoVO) throws DAOException {
	   	DBRowSet dbRowset = null;
		String rtn = "N";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgBlNoVO != null) {
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchNlFlagRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn = dbRowset.getString("RESULT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtn;
	}
	
	/**
	 * LloydNo로 VSL_CD 조회<br>
	 * @param lloydNo String
	 * @param skdVoyNo String
	 * @param skdDirCd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchVslCdByLloydNo(String lloydNo, String skdVoyNo, String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String rtn = null;
		try {
			param.put("lloyd_no", lloydNo);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchVslCdByLloydNoRSQL(), param, param);
			if (dbRowset.next()) {
				rtn = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtn;
	}
	
	/**
	 * MDM_SVC_SCP_LANE에서 VSL_SLAN_CD 조회<br>
	 * @param String slanCd 
	 * @return String
	 * @throws DAOException
	 */
	public String searchMdmVslSvcLane(String slanCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String rtn = "";
		try {
			param.put("slan_cd", slanCd);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchMdmVslSvcLaneRSQL(), param, param);
			if (dbRowset.next()) {
				rtn = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtn;
	}	
	
	/**
	 * MDM_SVC_SCP_LANE에서 VSL_SLAN_CD 조회<br>
	 * @param String portCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMdmLocPortName(String portCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String rtn = "";
		try {
			param.put("port_cd", portCd);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchMdmLocPortNameRSQL(), param, param);
			if (dbRowset.next()) {
				rtn = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtn;
	}		
	
	/**
	 * searchComUserInfo <br>
	 * 
	 * @param String usrId
	 * @return ComUserVo
	 */
	@SuppressWarnings("unchecked")
	public ComUserVO searchComUserInfo(String usrId) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<ComUserVO> list = null;
		ComUserVO comUserVo = null;
		try {
			param.put("usr_id",usrId);
			velParam.put("usr_id",usrId);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchComUserInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComUserVO.class);
			if (null!=list && 0<list.size()) {
				comUserVo = (ComUserVO)list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return comUserVo;
	}

   	/**
	 * bkg으로 해당 vvd, port에서 CBF 되었는지 확인하여<br>
	 * CBF 되어 있을 경우 해당 bkg으로 notice에 포함될 내용을 조회한다.<br>
	 * @author Ryu Daeyoung
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return BkgCloseVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCloseVO searchBkgCbf(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCloseVO> list = null;
		BkgCloseVO bkgCloseVO = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchBkgCbfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCloseVO.class);
			if (list != null && list.size() > 0) {
				bkgCloseVO = list.get(0);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return bkgCloseVO; 
	}

	/**
	 * CNTR_TP_SZ 목록조회<br>
	 * 
	 * @return List<BkgComboVO>
	 * @exception DAOException
	 */
	public List<BkgComboVO> searchMdmCntrTpSz() throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchMdmCntrTpSzRSQL template = new BookingUtilDBDAOSearchMdmCntrTpSzRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<BkgComboVO>();
			while (dbRowset.next()) {
				BkgComboVO vo = new BkgComboVO();
				vo.setVal(dbRowset.getString("cntr_tpsz_cd"));
				vo.setName(dbRowset.getString("cntr_tpsz_cd"));
				list.add(vo);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * searchOfcChgProc <br>
	 * 
	 * @param OfcChgProcVO ofcChgProcVO
	 * @return OfcChgProcVO
	 */
	@SuppressWarnings("unchecked")
	public OfcChgProcVO searchOfcChgProc(OfcChgProcVO ofcChgProcVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<OfcChgProcVO> list = null;
		try {
			Map<String, String> mapVO = ofcChgProcVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchOfcChgProcRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfcChgProcVO.class);
			if (null!=list && 0<list.size()) {
				ofcChgProcVO = (OfcChgProcVO)list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return ofcChgProcVO;
	}
	
	/**
	 * seacrhDocPerformanceUserCheck  이벤트 처리<br>
	 * @author Kim Tae Kyoung
	 * @param String input_text
	 * @return String
	 * @exception EventException
	 */
	public String seacrhDocPerformanceUserCheck(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchDocPerformanceUsrIdRSQL template = new BookingUtilDBDAOSearchDocPerformanceUsrIdRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
    }
	/**
	 *  국가코드 목록조회<br>
	 * 
	 * @return List<MdmCountryVO>
	 * @exception DAOException
	 */
	public List<MdmCountryVO> searchMdmCnt() throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCountryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchMdmCntRSQL template = new BookingUtilDBDAOSearchMdmCntRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<MdmCountryVO>();
			while (dbRowset.next()) {
				MdmCountryVO vo = new MdmCountryVO();
				vo.setCntCd(dbRowset.getString("cnt_cd"));
				vo.setCntNm(dbRowset.getString("cnt_nm"));
				list.add(vo);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * checkIranBlackCustomer <br>
	 * 
	 * @param String custNm
	 * @param String fullSchFlg
	 * @return String
	 */
	public String checkIranBlackCustomer(String custNm, String fullSchFlg) throws DAOException {
		
		String resultStr = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("cust_nm", custNm);
			param.put("full_sch_flg", fullSchFlg);
			velParam.put("cust_nm", custNm);
			velParam.put("full_sch_flg", fullSchFlg);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOCheckIranBlackCustomerRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return resultStr;
	}
	
	/**
	 * checkEuBlackCustomer <br>
	 * 
	 * @param String custNm
	 * @return String
	 */
	public String checkEuBlackCustomer(String custNm) throws DAOException {
		
		String resultStr = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("cust_nm", custNm);
			velParam.put("cust_nm", custNm);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOCheckEuBlackCustomerRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return resultStr;
	}
	
	/**
	 * checkUsBlackCustomer <br>
	 * 
	 * @param String custNm
	 * @param String fullSchFlg
	 * @return String
	 */
	public String checkUsBlackCustomer(String custNm, String fullSchFlg) throws DAOException {
		
		String resultStr = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("cust_nm", custNm);
			param.put("full_sch_flg", fullSchFlg);
			velParam.put("cust_nm", custNm);
			velParam.put("full_sch_flg", fullSchFlg);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOCheckUsBlackCustomerRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return resultStr;
	}	
	
	/**
	 * checkBkgBlackCustomer <br>
	 * 
	 * @param String custNm
	 * @return String
	 */
	public String checkBkgBlackCustomer(String custNm) throws DAOException {
		
		String resultStr = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("cust_nm", custNm);
			velParam.put("cust_nm", custNm);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOCheckBkgBlackCustomerRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return resultStr;
	}	

	/**
	 * 금지어 포함 되었는 지 체크 <br>
	 * 
	 * @param String wordKnd
	 * @param String word
	 * @return String
	 */
	public String checkWordBlackList(String wordKnd, String word) throws DAOException {
		
		String resultStr = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("word_knd", wordKnd);
			param.put("word", word);
			velParam.put("word_knd", wordKnd);
			velParam.put("word", word);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOCheckWordBlackListRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return resultStr;
	}	
	
	/**
	 * Charcoal, Calcium Hypochlorite Manufacturer가 있는지 체크하는 block list <br>
	 * @param String rmk
	 * @return String
	 */
	public String checkChaCalHypoBlckList(String rmk) throws DAOException {
		
		String resultStr = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("rmk", rmk);
			velParam.put("rmk", rmk);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOcheckChaCalHypoRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return resultStr;
	}
	
	/**
	 * Package Code 조회.<br>
	 * Table -mdm_pck_tp<br>
	 * 
	 * @param String pkgNm
	 * @return MdmPckTpVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmPckTpVO searchPkgTypeByName(String pkgNm) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmPckTpVO> list = null;
		MdmPckTpVO vo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("pck_nm", pkgNm);
			SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchPkgTypeByNameRSQL template = new BookingUtilDBDAOSearchPkgTypeByNameRSQL();
			dbRowset = sqlExec.executeQuery(template, param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmPckTpVO.class);
			if (list != null && list.size() > 0) {
				vo = (MdmPckTpVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}
	
	/**
	 * Package Code 조회.<br>
	 * Table -mdm_pck_tp<br>
	 * 
	 * @param String deTpNm
	 * @return String
	 * @throws DAOException
	 */
	public String searchDeTypeByName(String deTpNm) throws DAOException {
		String rsltStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("de_tp_nm", deTpNm);
			velParam.put("de_tp_nm", deTpNm);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchDeTypeByNameRSQL(), param, velParam);
			if (dbRowset.next()) {
				rsltStr = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rsltStr;
	}
	
	/**
	 * Reefer Cargo Nature(Cooling) Type Code 조회.<br>
	 * Code ID : CD02095<br>
	 * 
	 * @param String clngTpNm
	 * @return String
	 * @throws DAOException
	 */
	public String searchCoolingTypeByName(String clngTpNm) throws DAOException {
		String rsltStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("clng_tp_nm", clngTpNm);
			velParam.put("clng_tp_nm", clngTpNm);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchCoolingTypeByNameRSQL(), param, velParam);
			if (dbRowset.next()) {
				rsltStr = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rsltStr;
	}
	
	/**
	 * Container Ventilation Type Code 조회.<br>
	 * Code ID : CD01592<br>
	 * 
	 * @param String ventTpNm
	 * @return String
	 * @throws DAOException
	 */
	public String searchVentilationTypeByName(String ventTpNm) throws DAOException {
		String rsltStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("vent_tp_nm", ventTpNm);
			velParam.put("vent_tp_nm", ventTpNm);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchVentilationTypeByNameRSQL(), param, velParam);
			if (dbRowset.next()) {
				rsltStr = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rsltStr;
	}
	
	/**
	 * State Code 조회.<br>
	 * Table -mdm_state<br>
	 * 
	 * @param String steNm
	 * @return MdmStateVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmStateVO searchSteCodeByName(String steNm) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmStateVO> list = null;
		MdmStateVO vo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("ste_nm", steNm);
			SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchSteCodeByNameRSQL template = new BookingUtilDBDAOSearchSteCodeByNameRSQL();
			dbRowset = sqlExec.executeQuery(template, param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmStateVO.class);
			if (list != null && list.size() > 0) {
				vo = (MdmStateVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}
	
	/**
	 * 특정 Continent Code 를 조회한다.<br>
	 * Table -mdm_continent<br>
	 * 
	 * @param String contiCd
	 * @return MdmContinentVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmContinentVO searchContinentCode(String contiCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmContinentVO> list = null;
		MdmContinentVO vo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("conti_cd", contiCd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchContinentCodeRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmContinentVO.class);

			if (list != null && list.size() > 0) {
				vo = (MdmContinentVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vo;
	}
	/**
	 * front office email address 구하는 함수 <br>
	 * @param String bkgNo
	 * @return String output_text
	 * @exception DAOException 
	 */
	public String searchFntEmailAddrRSQL(String bkgNo) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchFntEmailAddrRSQL template = new BookingUtilDBDAOSearchFntEmailAddrRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("EMAIL");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}	
	
	/**
	 * seacrhManualBdrUserCheck  이벤트 처리<br>
	 * 로그인유저의 BDR권한조회(결과값이 'Y':권한 있음 / 'N':권한 없음)<br>
	 * @author Kim Bong Gyoon
	 * @param String input_text
	 * @return String
	 * @exception EventException
	 */
	public String seacrhManualBdrUserCheck(String input_text) throws DAOException {
		// output_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOseacrhManualBdrUserCheckRSQL template = new BookingUtilDBDAOseacrhManualBdrUserCheckRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
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
     * @exception 	DAOException
     */
	public String searchAmdtSeq(String ctrtType, String ctrtNo, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ctrt_type", ctrtType);
			param.put("ctrt_no", ctrtNo);
			param.put("bkg_no", bkgNo);
			
			velParam.put("ctrt_type", ctrtType);
			velParam.put("ctrt_no", ctrtNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchAmdtSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("amdt_seq");
			}
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
		
	}
	
	/**
	 * 부서코드가 권한이 있는지 확인<br>
	 * 
	 * @param BkgCoffTmVO bkgCoffTmVO
	 * @param SignOnUserAccount account
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkOfcAuth(BkgCoffTmVO bkgCoffTmVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			log.debug("1234 : "+(bkgCoffTmVO!=null?JSPUtil.getNull(bkgCoffTmVO.getBkgOfcCd()):"xx"));
			param.put("ofc_cd", account.getOfc_cd());
			if(bkgCoffTmVO != null){
				param.put("bkg_ofc_cd", bkgCoffTmVO.getBkgOfcCd());
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOCheckOfcAuthRSQL(), param, velParam);

			if (dbRowset.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 로그를 기록한다.<br>
	 * 
	 * @param String modName
	 * @param String applInfo
	 * @param String logDesc
	 * @exception DAOException
	 */
	public void addBkgLog(String modName, String applInfo, String logDesc) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("mod_name",  modName);
			mapVO.put("appl_info", applInfo);
			mapVO.put("log_desc",  logDesc);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeSP((ISQLTemplate)new BookingUtilDBDAOBkgFuncProcLogCSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}

	
	/**
	 *  ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회<br>
	 *
	 * @author Kim Gyoung-Sub
	 * @param BkgCstmsHrdCdgCtntVO bkgCstmsHrdCdgCtntVO
	 * @return List<BkgCstmsHrdCdgCtntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsHrdCdgCtntVO> searchCstmsHardCodingList(BkgCstmsHrdCdgCtntVO bkgCstmsHrdCdgCtntVO) throws DAOException {

		
		DBRowSet dbRowset = null;
		List<BkgCstmsHrdCdgCtntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCstmsHrdCdgCtntVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDDAOSearchCstmsHardCodingListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsHrdCdgCtntVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;		
	}

	
	
	/**
	 * B/L confirm , B/L Issue 상태를 체크한다.
	 * @param bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String checkBkgIssStatus(String bkgNo) throws DAOException{
		DBRowSet dbRowset = null;
		Map<String, Object> param = null;
		String result = null;
		try{
			param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingUtilDBDAOCheckBkgIssStatusRSQL(), param, param);
			if (dbRowset.next()) {
				result = dbRowset.getString("STATUS");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * Iran Sanction 관련 CM 특정 HS 코드
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchSanctionHsCdList(BkgBlNoVO bkgBlNoVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BkgHrdCdgCtntVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchSanctionHsCdListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
     * Bkg Hard Coding 데이타 확인.<br>
     * @author Lee Junkun
     * @param  BkgHrdCdgCtntVO bkgHrdCdgCtntVO
     * @return BkgHrdCdgCtntVO 
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public BkgHrdCdgCtntVO checkBkgHrdCdgCtnt(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		BkgHrdCdgCtntVO ctntVo = null;
		List<BkgHrdCdgCtntVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = bkgHrdCdgCtntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOCheckBkgHrdCdgCtntRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO.class);
			if (list != null && list.size() > 0) {
				ctntVo = (BkgHrdCdgCtntVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return ctntVo;
	}
	
	/**
	 * 자동전송 Group ID와 BKG 접수 경로를 등록해 놓고 해당 될 경우 처리되게 함
	 * @param String bkgNo
	 * @return CustTpIdVO
	 * @throws DAOException
	 */
	public CustTpIdVO searchCustTpIdInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		CustTpIdVO custTpIdVO = null;
		List<CustTpIdVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOSearchCustTpIdInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustTpIdVO.class);
			if (list != null && list.size() > 0) {
				custTpIdVO = (CustTpIdVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return custTpIdVO;
	}

   	/**
	 * bkg으로 해당 vvd, port에서 T/S close 되었는지 확인하여<br>
	 * @author Ryu Daeyoung
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchTsBkgClose(BkgBlNoVO bkgBlNoVO) throws DAOException {
	   	DBRowSet dbRowset = null;
		List<String> rtnList =  new ArrayList<String>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchTsBkgCloseRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnList.add(dbRowset.getString("ts_closed_vvd"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnList;
	}
	
	/**
     * 장애 방지를 위해 에러가 발생 가능한 로직에 대하여 적용 유무를 관리 하여 로직 롤백을 간단하게 할수 있도록 한다.<br>
     * @author 
     * @param  BkgHrdCdgCtntVO bkgHrdCdgCtntVO
     * @return BkgHrdCdgCtntVO 
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public BkgHrdCdgCtntVO checkBkgAplFlg(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		BkgHrdCdgCtntVO ctntVo = null;
		List<BkgHrdCdgCtntVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = bkgHrdCdgCtntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOCheckBkgAplFlgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO.class);
			if (list != null && list.size() > 0) {
				ctntVo = (BkgHrdCdgCtntVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return ctntVo;
	}
	
	/**
	 * searchBlRouteInfo 함수 <br>
	 * @author 
	 * @param String bkgNo
	 * @return BlIssInfoVO
     * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BlIssInfoVO searchBlRouteInfo(String bkgNo) throws DAOException {
		// input_text
		BlIssInfoVO blIssInfoVO = null;
		List<BlIssInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchBlRouteInfoRSQL template = new BookingUtilDBDAOSearchBlRouteInfoRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlIssInfoVO.class);

			if (list != null && list.size() > 0) {
				blIssInfoVO = (BlIssInfoVO) list.get(0);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return blIssInfoVO;
	}
	
	/**
	 * ESM_BKG_0726 에서 B/L Print 버튼 활성화 대상을 조회 한다.<br>
	 * @author Kim Tae Kyoung
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String search0726BlprnUsr(SignOnUserAccount account) throws DAOException {
		// cfmFlg
		String cfmFlg = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			param.put("ofc_cd", account.getOfc_cd());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearch0726BlprnUserRSQL template = new BookingUtilDBDAOSearch0726BlprnUserRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				cfmFlg = dbRowset.getString("CFM_FLG");
			} else {
				cfmFlg = "N";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cfmFlg;
    }
	
	/**
	 * existCustomsEntryCode 존재여부 판단 <br>
	 * 
	 * @author Kim Tae Kyoung
	 * @param String input_text
	 * @return String output_text
	 */
	public String existCustomsEntryCode(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("input_text", input_text);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOExistCustomsEntryCodeRSQL template = new BookingUtilDBDAOExistCustomsEntryCodeRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return output_text;
	}

	 /**
     * searchFukushimaUsedCmdt <br>
     * fukushima의 used commodity가 특정 pod로 가는지 확인함 <br>
     * @author Ryu DAe Young
     * @param BkgBlNoVO bkgBlNoVO
     * @param String cmdtCd
     * @param String cstmsDesc
     * @return String
     * @throws EventException
     */
	public String searchFukushimaUsedCmdt(BkgBlNoVO bkgBlNoVO, String cmdtCd, String cstmsDesc) throws DAOException {
		String result = "N";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("cmdt_cd", cmdtCd);
			param.put("cstms_desc", cstmsDesc);
			velParam.put("cmdt_cd", cmdtCd);
			velParam.put("cstms_desc", cstmsDesc);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchFukushimaUsedCmdtRSQL template = new BookingUtilDBDAOsearchFukushimaUsedCmdtRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("RESULT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return result;
	}
	
   /**
    * searchIranToOrdBl <br>
    * IRAN에 Order B/L이 출항, 입항하는지 확인함 <br>
    * @author Ryu DAe Young
    * @param BkgBlNoVO bkgBlNoVO
    * @return String
    * @throws EventException
    */
	public String searchIranToOrdBl(BkgBlNoVO bkgBlNoVO) throws DAOException {
		String result = "N";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchIranToOrdBlRSQL template = new BookingUtilDBDAOsearchIranToOrdBlRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("RESULT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return result;
	}

	   /**
	    * searchBkgCustCntCd <br>
	    * bkg의 Customer Type별 Country Code를 조회함 <br>
	    * @author Ryu DAe Young
	    * @param String bkgCustTpCd
	    * @param String bkgNo
	    * @return String
	    * @throws EventException
	    */
	public String searchBkgCustCntCd(String bkgCustTpCd, String bkgNo) throws DAOException {
		String result = "N";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			param.put("bkg_cust_tp_cd", bkgCustTpCd);
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_cust_tp_cd", bkgCustTpCd);
			velParam.put("bkg_no", bkgNo);
	
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchBkgCustCntCdRSQL template = new BookingUtilDBDAOSearchBkgCustCntCdRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("CUST_CNT_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return result;
	}
	
	/**
	 * allocation Standby로 notice를 취소할지 여부 조회<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchStandbyBlockFlg(BkgBlNoVO bkgBlNoVO) throws DAOException {
		String result = "N";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchStandbyBlockFlgRSQL template = new BookingUtilDBDAOsearchStandbyBlockFlgRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("RSLT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return result;
	}
	
	/**
	 * No Rate 로 notice를 취소할지 여부 조회<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchNoRateBlockFlg(BkgBlNoVO bkgBlNoVO) throws DAOException {
		String result = "N";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchNoRateBlockFlgRSQL template = new BookingUtilDBDAOsearchNoRateBlockFlgRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("RSLT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return result;
	}	

    /**
     * VVD가 한국세관 Download 된 적 있는 지 조회.<br>
     * @author 	Dongsun Moon
     * @param  	String vvd_cd
     * @param  	String pod_loc
     * @return 	String
     * @throws Exception
	 * @throws DAOException
     */
	public String searchKrCstmsDownload(String vvd_cd, String pod_loc) throws DAOException {
	   	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result = "";

		try {
			param.put("vvd_cd", vvd_cd);
			param.put("pod_loc", pod_loc);
			velParam.put("vvd_cd", vvd_cd);
			velParam.put("pod_loc", pod_loc);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchKrCstmsDownloadRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("CNT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}	
	
	/**
	 * Potential DG 화물 목록을 체크한다<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */

	public String searchPotentialDgFlg(BkgBlNoVO bkgBlNoVO) throws DAOException {
		String result = "N";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchPotentialDgFlgRSQL template = new BookingUtilDBDAOsearchPotentialDgFlgRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("RSLT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return result;
	}
	
	/**
	 * Potential DG 화물 목록을 체크한다<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String divCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchPotentialDgFlg2(BkgBlNoVO bkgBlNoVO, String divCd) throws DAOException {
		String result = "";
		String flg = "N";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			
			param.put("div_cd", divCd);
			velParam.put("div_cd", divCd);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchPotentialDgFlg2RSQL template = new BookingUtilDBDAOsearchPotentialDgFlg2RSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				flg = dbRowset.getString("FLG");
				result = dbRowset.getString("RSLT");
			}
			
			//BKG MAIN에서 DG CGO가 체크되어 있으면 검사 X
			//BKG MAIN에서 DG CGO가 체크되어 있지 않고 Potential DG 키워드 포함하고 있으면 해당 키워드 리턴
			if("Y".equalsIgnoreCase(flg)){
				if("".equals(result)){
					result = "N";
				}
			}else{
				result = "N";
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return result;
	}
	
	/**
	 * MDM_ORGANIZATION 테이블에서 ofc_cd 조건검색하여 LOC_CD 정보를 조회.
	 * 
	 * @param String ofc_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLocCdByOfcCd2(String ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (!JSPUtil.getNull(ofc_cd).equals("")) {
				ofc_cd = "'" + (ofc_cd.replaceAll(",", "','") + "'");
			}
			param.put("ofc_cd", ofc_cd);
			velParam.put("ofc_cd", ofc_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchLocCdByOfcCd2RSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;
	}
	
	/**
	 * rfaSpotPricingAvailable 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String rfaSpotPricingAvailable(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			String[] note = input_text.split("\\|");
			mapVO.put("bkg_no", note[0]);
			mapVO.put("rfa_no", note[1]);
			mapVO.put("date", note[2]);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAORfaSpotPricingAvailableRSQL template = new BookingUtilDBDAORfaSpotPricingAvailableRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}
	
	/**
	 * rfaSpotPricingAvailable 와 같은 내용이나 파라미터를 달리함 <br>
	 * @author 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rfaNo
	 * @param String obSrepCd
	 * @return String output_text
	 * @throws DAOException
	 */
	public String rfaSpotPricingAvailableForBkgCre(BkgBlNoVO bkgBlNoVO, String rfaNo, String obSrepCd) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("rfa_no", rfaNo);
			param.put("ob_srep_cd", obSrepCd);
			velParam.put("rfa_no", rfaNo);
			velParam.put("ob_srep_cd", obSrepCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAORfaSpotPricingAvailableForBkgCreRSQL template = new BookingUtilDBDAORfaSpotPricingAvailableForBkgCreRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}	
	
	/**
	 * n3rdPartyBlReqOfcAvailable 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String n3rdPartyBlReqOfcAvailable(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			String[] note = input_text.split("\\|");
			mapVO.put("bkg_no", note[0]);
			mapVO.put("login_ofc_cd", note[1]);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAON3rdPartyBlReqOfcAvailableRSQL template = new BookingUtilDBDAON3rdPartyBlReqOfcAvailableRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}
	
	/**
	 * n3rdPartyBlReqAvailable 함수 <br>
	 * @author Lee Jin Seo
	 * @param String input_text
	 * @return String output_text
	 */
	public String n3rdPartyBlReqAvailable(String input_text) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			String[] note = input_text.split("\\|");
			mapVO.put("bkg_no", note[0]);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAON3rdPartyBlReqAvailableRSQL template = new BookingUtilDBDAON3rdPartyBlReqAvailableRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				output_text = dbRowset.getString("OUTPUT_TEXT");
			} else {
				output_text = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return output_text;
	}
	
	/**
	 * searchCntrInfo 함수 <br>
	 * BKG NO, CNTR NO로 컨테이너를 검색한다
	 * @author Yang dong hun
	 * @param String bkg_no
	 * @param String cntr_no
	 * @return List<CntrInfoVO>
	 */
	public List<CntrInfoVO> searchCntrInfo(String bkg_no, String cntr_no) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<CntrInfoVO> result = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkg_no);
			param.put("cntr_no", cntr_no);
			velParam.put("cntr_no", cntr_no);
			velParam.put("bkg_no", bkg_no);
			if (("".equals(bkg_no)) && ("".equals(cntr_no))) {
				throw new DAOException("Put at least one Keyword");
			}
			dbRowset = new SQLExecuter("").executeQuery(new BookingUtilDBDAOSearchCntrInfoRSQL(), param, velParam);
			result = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrInfoVO.class);
		} catch (SQLException se) {
			this.log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			this.log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * cycle_no를 수정한다
	 * manageCntrCycNo 함수 <br>
	 * @author Yang dong hun
	 * @param CntrInfoVO vo
	 */
	public void manageCntrCycNo(CntrInfoVO vo) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate(new BookingUtilDBDAOManageCntrCycNoUSQL(), param, velParam);

			if (insCnt == -3)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			this.log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			this.log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Booking ALOC_STS_CD 상태 조회<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchAlocStsCd(BkgBlNoVO bkgBlNoVO) throws DAOException {
		// booking status code
		String bkgStsCd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgBlNoVO.getBkgNo());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchAlocStsCdRSQL template = new BookingUtilDBDAOSearchAlocStsCdRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				bkgStsCd = dbRowset.getString("ALOC_STS_CD");
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return bkgStsCd;
	}
	
	/**
	 * Receipt Notice 메일 내용에 포함 될 Vessel Name 과 Lane 을 조회 한다.
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchVesselNameByBkgNo(String bkgNo) throws DAOException{
		DBRowSet dbRowset = null;
		Map<String, Object> param = null;
		String result = "";
		try{
			param = new HashMap<String, Object>();
			param.put("bkg_no", bkgNo);
 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchVesselNameByBkgNoRSQL(), param, param);
			if (dbRowset.next()) {
				result = dbRowset.getString("VSL_ENG_NM");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * 
	 * @return List<BkgComboVO>
	 * @throws DAOException
	 */
	public List<BkgComboVO> searchYearCombo() throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchYearComboRSQL template = new BookingUtilDBDAOsearchYearComboRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<BkgComboVO>();
			while (dbRowset.next()) {
				BkgComboVO vo = new BkgComboVO();
				vo.setComboCd(dbRowset.getString("CODE"));
				vo.setVal(dbRowset.getString("CODE"));
				vo.setName(dbRowset.getString("CODE"));
				vo.setDesc(dbRowset.getString("CODE"));
				list.add(vo);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * @param String ofcCd
	 * @return List<BkgComboVO>
	 * @throws DAOException
	 */
	public List<BkgComboVO> searchOfcCombo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ofcCd == null || ofcCd.length() == 0) {
				// BKG00104 - ?꾩닔?낅젰??ぉ
				throw new RuntimeException("BKG00104");
			}

			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOsearchOfcComboRSQL template = new BookingUtilDBDAOsearchOfcComboRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);

			list = new ArrayList<BkgComboVO>();
			while (dbRowset.next()) {
				BkgComboVO vo = new BkgComboVO();
				vo.setComboCd(dbRowset.getString("OFC_CD"));
				vo.setVal(dbRowset.getString("OFC_CD"));
				vo.setName(dbRowset.getString("OFC_CD"));
				vo.setDesc(dbRowset.getString("OFC_CD"));
				list.add(vo);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	

	/**
	 * 발짜, 로직별로 적용되는 로직인지를 확인한다.
	 * @param String bkgNo
	 * @param String lgcNm
	 * @param String div
	 * @return String
	 * @throws DAOException
	 */
	public String searchEffDtDiv(String bkgNo, String lgcNm, String div) throws DAOException{
        String effFlg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			param = new HashMap<String, Object>(); 
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("lgc_nm",lgcNm);
            mapVO.put("div", div);
			
            param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchEffDtDivRSQL(), param, param);
			if (dbRowset.next()) {
				effFlg = dbRowset.getString("eff_flg");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return effFlg;
	}
	
	/**
	 *  POD가 West Africa Port 인지 확인<br>
	 * Hard Coding 테이블에 들옥된 Port를 대상으로 서아프리카인지 확인한다.
	 * 
	 * @param String bkgNo
	 * @return String
	 */
	public String searchWestAfricaPod(String bkgNo) throws DAOException {
		
		String resultStr = "N";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchWestAfricaPodRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return resultStr;
	}
	
	/**
	 *  첫 번째 VVD 찾기<br>
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchFirstVVD(String bkgNo) throws DAOException {
		
		String resultStr = "N";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchFirstVVDRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return resultStr;
	}
	
	/**
	 * bkg_blck_list_mntr 테이블에 데이터 insert한다.
	 * 
	 * @param bkgBlckListMntrVO
	 * @throws DAOException
	 */
	public void addBkgBlckListMntr(BkgBlckListMntrVO bkgBlckListMntrVO) throws DAOException {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				Map<String, String> mapVO = new HashMap<String, String>();
				
				if (null != bkgBlckListMntrVO) {
					mapVO = bkgBlckListMntrVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

//				new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOAddBkgBlckListMntrCSQL(), param, velParam);
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				BookingUtilDBDAOAddBkgBlckListMntrCSQL template = new BookingUtilDBDAOAddBkgBlckListMntrCSQL();
				sqlExe.executeUpdate(template, param, velParam);
				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
	}

	/**
	 * 
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public String genOblSerNo(String bkgNo) throws DAOException {
		String resultStr = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOgenOblSerialNumberRSQL(), param, velParam);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return resultStr;
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @param serNo
	 * @param account
	 * @throws DAOException
	 */
	public void bkgInetBlOblSerNoAdd (String bkgNo, String serNo, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			param.put("ser_no", serNo);
			velParam.put("ser_no", bkgNo);
			param.put("upd_office", account.getOfc_cd());
			velParam.put("upd_office", account.getOfc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			velParam.put("upd_usr_id", account.getUsr_id());
			velParam.put("buttonType", "btn_t11InternetAUTH");
			new SQLExecuter("").executeUpdate((ISQLTemplate) new BLIssuanceDBDAOmanageIntAuthCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @param serNo
	 * @param account
	 * @throws DAOException
	 */
	public void bkgInetBlOblSerNoChecked (String bkgNo, String serNo, String checked, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("bkg_no", bkgNo);
			param.put("ser_no", serNo);
			param.put("checked", checked);
			param.put("usr_id", account.getUsr_id());
			new SQLExecuter("").executeUpdate((ISQLTemplate) new BookingUtilDBDAOOblSerialNumberCheckedUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @param checked
	 * @param searchType
	 * @return
	 * @throws DAOException
	 */
	public List<BkgInetBlPrnAuthVO> searchOblSerialNumber(String bkgNo, String checked, String searchType) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgInetBlPrnAuthVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("checked", checked);
			param.put("search_type", searchType);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchOblSerialNumberRSQL(), param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgInetBlPrnAuthVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
     * BkgIdaSacMstVO 정보 조회.<br>
     * @author Lee Jin Seo
     * @param BkgIdaSacMstVO vo
     * @return BkgIdaSacMstVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public BkgIdaSacMstVO searchIdaSacMasterInfo(String idaSacCd) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgIdaSacMstVO> list = null;
        BkgIdaSacMstVO rtnBkgIdaSacMstVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

            Map<String, String> mapVO = new HashMap();
            mapVO.put("ida_sac_cd", idaSacCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchIdaSacMstRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgIdaSacMstVO.class);
            if (list != null && list.size() > 0) {
                rtnBkgIdaSacMstVO = list.get(0);
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rtnBkgIdaSacMstVO;
    }
    
    /**
	 * 광져우 사용자들 BKGKING 조회 제한 로직
	 * @param bkgNo
	 * @param securitySearchId
	 * @param uiId
	 * @param evnTp
	 * @param account
	 * @return
	 * @throws DAOException
	 */
	public String bkgLoginOfcCdSearchCk(String bkgNo, String securitySearchId, String uiId, String evnTp, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String flg = "N";
		try {
			param.put("bkg_no", bkgNo);
			param.put("bkg_src_tp", securitySearchId);
			param.put("usr_ofc_cd", account.getOfc_cd());
			param.put("ui_id", uiId);
			param.put("evn_tp", evnTp);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOLoginOfcCdSearchCkRSQL(), param, param);
			while(dbRowset.next()){
				flg = dbRowset.getString("BKG_SRC_FLG");
				if(flg.equals("N"))
					return flg;
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flg;
	}
	

	/**
	 * pod_cd check
	 * Y인 경우 Serial Number Validation 통과
	 * @param porCd
	 * @return
	 * @throws DAOException
	 */
	public String searchPorCdCheck(String porCd) throws DAOException {
		String resultStr = "N";
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("por_cd", porCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchPorCdCheckRSQL(), param, param);
			if (dbRowset.next()) {
				resultStr = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return resultStr;
	}
	
	/**
	 * XterRqstNoVO 정보 조회.<br>
	 * @author Lim Jae Kwan
	 * @param String bkgNo
	 * @return XterRqstNoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public XterRqstNoVO searchAperakXterRqstNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<XterRqstNoVO> list = null;
		XterRqstNoVO xterRqstNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchAperakXterRqstNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, XterRqstNoVO.class);
			if (list != null && list.size() > 0) {
				xterRqstNoVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return xterRqstNoVO;
	}
	
	/**
	 * 부킹 메일 저장 시 Product Catalog 팝업 오픈 여부 체크
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public String searchProductCatalogPopUpCheck(ProductCatalogPoupCheckVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String cnst = "Y";
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			if (null != vo) {
				mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOProductCatalogPopUpCheckRSQL(), param, velParam);
			while (dbRowset.next()) {
				cnst = dbRowset.getString("CNST");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnst;
	}
	
	/**
	 * 부킹 메일 저장 시 Product Catalog 팝업 오픈 기능 사용여부
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public boolean searchProductCatalogPopUpOpen() throws DAOException {
		DBRowSet dbRowset = null;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOProductCatalogPopUpOpenRSQL(), null, null);
			while (dbRowset.next()) {
				if(dbRowset.getString("ATTR_CTNT1").equals("Y"))
					return true;
				else 
					return false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return false;
	}
}