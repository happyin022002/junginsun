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
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration.BookingHistoryMgtDBDAOaddBkgNtcHisCSQL;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.AcssAlwInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgCloseVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgCstmsHrdCdgCtntVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgMdmCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgVvdRouteVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgXterUsrInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.ManualSurchargeVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmChgTaxFlgVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MemoSplitMasterBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.OblIssVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.OfcChgProcVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.ReportItemVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchBlListByCntrNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchBlListByHblNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchBlListByPoNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchLocationCodeVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchPortCdByVvdVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchSrepCdListVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchSvcLaneBoundVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SplitMstBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SplitNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.StaffListByOfcCdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAOModifyChgRateBkgBookingUSQL;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAOSearchBkgLastSaveTimeRSQL;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAOsearchVenderEdiBkgRSQL;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TmnlRcvIdVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration.UserSetupMgtDBDAOSearchPlaceOfIssueAssociationListRSQL;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ExchangeRateVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.attachment.file.support.FileUploadDAOComUpldFileRSQL;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.framework.table.ComUpldFileVO;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgCstmsCdConvCtntVO;
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.BkgHamoTrfVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgRateVO;
import com.clt.syscommon.common.table.BkgTroVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.MdmPckTpVO;
import com.clt.syscommon.common.table.MdmStateVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.MdmYardVO;
import com.clt.syscommon.common.table.MdmZoneVO;
import com.clt.syscommon.common.table.MstContainerVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;

/**
 * BookingUtilDAO <br>
 * - BookingCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * @param List<String> taxChgs
	 * @return List<ManualSurchargeVO>
	 */
	@SuppressWarnings("unchecked")
	public List<ManualSurchargeVO> manualSurcharge(String application_date , String svc_scp_cd, List<String> taxChgs) throws DAOException {
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
			if(taxChgs==null){
				taxChgs = null;
				
				param.put("tax_chgs", null);
				velParam.put("tax_chgs", null);
			}else{
				log.debug(taxChgs.size());
				
				Map<String,List<String>> chgMapVO = new HashMap<String,List<String>>(taxChgs.size());
				chgMapVO.put("tax_chgs", taxChgs);
				param.putAll(chgMapVO);
				velParam.putAll(chgMapVO);
			}
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
	 * manualSurcharge 함수 <br>
	 *1. 메뉴얼로 Insert 하는 Charge 가 PRI에 Scope 및 CHG CODE 별로 등록 되어있는 항목중에 	
	 *- Charge Code 일치, Cur 일치, Per ='PC' Term 이 일치 할경우 적용
	 * @author Lee Jin Seo
	 * @param String application_date 
	 * @param String svc_scp_cd
	 * @param List<String> taxChgs
	 * @param List<String> chgCds
	 * @return List<ManualSurchargeVO>
	 */
	@SuppressWarnings("unchecked")
	public List<ManualSurchargeVO> manualSurcharge(String application_date , String svc_scp_cd, List<String> taxChgs, List<String> chgCds) throws DAOException {
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
			if(taxChgs==null){
				taxChgs = null;
				
				param.put("tax_chgs", null);
				velParam.put("tax_chgs", null);
			}else{
				log.debug("[taxChgs]"+taxChgs.size());
				
				Map<String,List<String>> chgMapVO = new HashMap<String,List<String>>(taxChgs.size());
				chgMapVO.put("tax_chgs", taxChgs);
				param.putAll(chgMapVO);
				velParam.putAll(chgMapVO);
			}
			if(chgCds==null){
				chgCds = null;
				
				param.put("chg_cds", null);
				velParam.put("chg_cds", null);
			}else{
				log.debug("[chgCds]"+chgCds.size());
				
				Map<String,List<String>> chgMapVO = new HashMap<String,List<String>>(chgCds.size());
				chgMapVO.put("chg_cds", chgCds);
				param.putAll(chgMapVO);
				velParam.putAll(chgMapVO);
			}
			
			
			
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
	 * manualTaxCountrySurcharge 함수 <br>
	 *1. 메뉴얼로 Insert 하는 Charge 가 PRI에 Scope 및 CHG CODE 별로 등록 되어있는 항목중에 	
	 *- Charge Code 일치, Cur 일치, Per ='PC' Term 이 일치 할경우 적용
	 * @author Lee Jin Seo
	 * @param String application_date 
	 * @param String svc_scp_cd
	 * @param String tax_cnt_cd
	 * @return List<ManualSurchargeVO>
	 */
	@SuppressWarnings("unchecked")
	public List<ManualSurchargeVO> manualTaxCountrySurcharge(String application_date , String svc_scp_cd, String tax_cnt_cd) throws DAOException {
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
			mapVO.put("tax_cnt_Cd", tax_cnt_cd);
			

			param.putAll(mapVO);
			velParam.putAll(mapVO);
//			param.put("tax_chgs", null);
//			param.put("chg_cds", null);
//			velParam.put("chg_cds", null);
//			velParam.put("tax_chgs", null);
			
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
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			String[] note = input_text.split("\\|");
			if(note.length != 4) return null;
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
	public String existBlackListedCustomer(String input_text) throws DAOException {
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
			BookingUtilDBDAOExistBlackListedCustomerRSQL template = new BookingUtilDBDAOExistBlackListedCustomerRSQL();
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
			if(custCntCd != null && custSeq != null){
				if(custSeq.indexOf(custCntCd) > -1){
					custSeq = custSeq.replaceAll(custCntCd, "");
				}
			}
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
	 * MDM Code 중복체크
	 * 
	 * @author Park Mangeon
	 * @param String blIssOfcCd
	 * @return int
	 * @throws DAOException
	 */
	public int checkMdmOrzByOfcCd(String blIssOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bl_iss_ofc_cd", blIssOfcCd);
			velParam.put("bl_iss_ofc_cd", blIssOfcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UserSetupMgtDBDAOSearchPlaceOfIssueAssociationListRSQL(), param, velParam);
			return dbRowset.getRowCount();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
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
	 * bkg_no 별 BDR, C/A 상태 조회.<br>
	 * Table - BKG_BL_DOC<br>
	 * 
	 * @param String bkg_no
	 * @return BkgBlNoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgBlNoVO searchBkgBlNoVO(String bkg_no) throws DAOException {
		log.debug("[BookingUtilDBDAO]searchBkgBlNoVO(=bkg_no??" + bkg_no);
		DBRowSet dbRowset = null;
		List<BkgBlNoVO> list = null;
		BkgBlNoVO bkgBlNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkg_no == null || "".equals(bkg_no)) return null;
			param.put("bkg_no", bkg_no);
			velParam.put("bkg_no", bkg_no); // by leejinseo 2009.8.6 이유는 모르겠습니다만. velparam이 빠져있어서 추가합니다.
			SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchBkgBlNoVORSQL template = new BookingUtilDBDAOSearchBkgBlNoVORSQL();
			dbRowset = sqlExec.executeQuery(template, param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBlNoVO.class);
			log.debug("[BookingUtilDBDAO]list(=list??" + list);
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
	 * @return BkgHamoTrfVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgHamoTrfVO searchHtsCodeDesc(String htsCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHamoTrfVO> list = null;
		BkgHamoTrfVO vo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("hamo_trf_cd", htsCd);

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
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
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
//		String strResult = null;
		String strResult = "";
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
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
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
	 * 
	 * @param bkgNo
	 * @param cntrNo
	 * @return
	 * @throws DAOException
	 */
	public String cntrPrtFlgCountCheck(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOCntrPrtFlgCountCheckRSQL(), param, null);
			while(dbRowset.next()){
				return dbRowset.getString("BKG_NO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return "";
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
	 * 해당 vvd 안에 PuetoRico(미국령) port를 거치는지 조회한다.(ESM_BKG_007901)<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgTrunkVvd  
	 * @param String polCd  
	 * @param String podCd  
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchPuetoRicoFrob(String bkgNo, String bkgTrunkVvd, String polCd, String podCd) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchPuetoRicoFrobRSQL(), param, velParam);

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
			//공통 가이드 변경으로 채번 방식 수정
			String referenceNumber = ReferenceNumberGeneratorBroker.getKey("BKG","BKG_EDI_SEQ");
			
			if (dbRowset.next()) {
				strReturn = dbRowset.getString("str_flatfile");
				strReturn = strReturn + referenceNumber;
			}
			
			log.error("\nSTR_FLATFILE = " + strReturn);
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
			param.put("ofc_cd", ofc_cd);

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
			param.put("edi_rcv_id", "");
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
	 * Sender Id, Sender Tp Code(CUST)로 Host Id를 조회한다. <br>
	 * 
	 * @author Jun Yong Jin
	 * @param TmnlRcvIdVO tmnlRcvIdVO <br>
	 * @param String msgCd <br>
	 * @param String sndrTpCd <br>
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdi301HostId(TmnlRcvIdVO tmnlRcvIdVO, String msgCd, String sndrTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tmnlRcvIdVO != null) {
				Map<String, String> mapVO = tmnlRcvIdVO.getColumnValues();

				param.putAll(mapVO);
				param.put("msg_cd", msgCd);
				velParam.putAll(mapVO);
				velParam.put("sndr_tp_cd", sndrTpCd);
				velParam.put("msg_cd", msgCd);
			}
			
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
	 * 
	 * @param prdMainInfoVO
	 * @param bkgBlNoVO
	 * @return
	 * @throws DAOException
	 */
	public PrdMainInfoVO searchPrdBkg(PrdMainInfoVO prdMainInfoVO, BkgBlNoVO bkgBlNoVO) throws DAOException {
		return searchPrdBkg(prdMainInfoVO, bkgBlNoVO, null);
	}
	
	
	/**
	 * Prd로 보낼 Booking 정보를 조회한다. <br>
	 * @param prdMainInfoVO
	 * @param bkgBlNoVO
	 * @param uiNo
	 * @return
	 * @throws DAOException
	 */
	public PrdMainInfoVO searchPrdBkg(PrdMainInfoVO prdMainInfoVO, BkgBlNoVO bkgBlNoVO, String uiNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PrdMainInfoVO> list = null;
		PrdMainInfoVO rtnPrdMainInfoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(uiNo != null && !uiNo.equals(""))
				velParam.put("ui_no", uiNo);
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
			//공통 가이드 변경으로 채번 방식 수정
			String referenceNumber = ReferenceNumberGeneratorBroker.getKey("BKC","BKG_CSTM_EDI_SEQ");
			
			if (dbRowset.next()) {
				strReturn = dbRowset.getString("str_flatfile");
				strReturn = strReturn + referenceNumber;
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
		java.sql.Connection con = null;
        java.sql.CallableStatement cstmt = null; 

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
					}else if(resultString.equals( "PL/SQL Execution Success")){
						sql = "{"+ sql +"}";
						con = getConnection(); 
				        cstmt = con.prepareCall(sql); 
				        String[] tempArr = sql.split("\\?");
				        for (int i = 1; i < tempArr.length; i++) {
				        	cstmt.registerOutParameter(i++, java.sql.Types.VARCHAR ); 
				        }
				        
				        cstmt.executeUpdate(); 
				        StringBuffer tmpStrBuf = new StringBuffer(resultString);
				        
				        for (int i = 0; i < tempArr.length-1; i++) {
//				        	resultString = resultString + "\n" + cstmt.getString(++i) + "\n";
				        	tmpStrBuf.append("\n").append(cstmt.getString(++i)).append("\n");
				        }
				        //return resultString;
//				        retVal = resultString;
				        retVal = tmpStrBuf.toString();
				   }else{
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
		} finally {
	       closeStatement(cstmt);
	       closeConnection(con);
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
	 * 
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public String searchBlPrfShprFlg(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String blPrfShprFlg = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchBlPrfShprFlgRSQL(), param, null);
			while (dbRowset.next()) {
				blPrfShprFlg = dbRowset.getString("BL_PRF_SHPR_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return blPrfShprFlg;
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
	 * @return resultStr(Y/N)
	 */
	public String checkIranBlackCustomer(String custNm) throws DAOException {
		
		String resultStr = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("cust_nm", custNm);
			velParam.put("cust_nm", custNm);
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
	 * 세관 BKG_CSTMS_CD_CONV_CTNT 정보를 조회 한다.
	 * 
	 * @param BkgCstmsCdConvCtntVO bkgCstmsCdConvCtntVO
	 * @return List<BkgCstmsCdConvCtntVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsCdConvCtntVO> searchCstmsCdConv(BkgCstmsCdConvCtntVO bkgCstmsCdConvCtntVO) throws DAOException {

		List<BkgCstmsCdConvCtntVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		DBRowSet dbRowset = null;
		try
		{
			if (bkgCstmsCdConvCtntVO != null)
			{
				Map<String, String> mapVO = bkgCstmsCdConvCtntVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDDAOsearchCstmsCdConvRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsCdConvCtntVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
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
	 * 세관 package (customsdeclaration)에서 사용하는 Flat File Header 생성 <br>
	 * Header 정보를 DB에서 읽음 (하드코딩 테이블 "BKC_EDI_HEADER")
	 * 
	 * @param ediNm
	 * @return
	 * @throws DAOException
	 */
	public String searchCstmsEdiHeaderNew(String ediNm) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("edi_nm", ediNm);

			velParam.put("edi_nm", ediNm);

			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOSearchCstmsEdiHeaderNewRSQL(), param, velParam);
			//공통 가이드 변경으로 채번 방식 수정
			String referenceNumber = ReferenceNumberGeneratorBroker.getKey("BKC","BKG_CSTM_EDI_SEQ");
			
			if (dbRowset.next()) {
				strReturn = dbRowset.getString("str_flatfile");
				strReturn = strReturn + referenceNumber;
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
	 * searchMdmOrganization
	 * 
	 * @param String ofcCd
	 * @return MdmOrganizationVO
	 * @throws DAOException
	 */
	public MdmOrganizationVO searchMdmOrganization(String ofcCd)  throws DAOException{
		DBRowSet dbRowset = null;
		List<MdmOrganizationVO> mdmOrganizationVO = null;	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{	
			param.put("ofc_cd", ofcCd);	 	
			velParam.put("ofc_cd", ofcCd);	 	
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate)new BookingUtilDBDDAOUserOfcCdRSQL(), param, velParam);
			mdmOrganizationVO = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO.class);	
			if(mdmOrganizationVO.size() > 0){
				return mdmOrganizationVO.get(0);
			}

		} catch(SQLException se) {	
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return null; 
	}
	
	/**
	 * 
	 * @param paramVo
	 * @return
	 * @throws DAOException
	 */
	public BkgMdmCustomerVO searchMdmCustomerCode(BkgMdmCustomerVO paramVo)  throws DAOException{
		DBRowSet dbRowset = null;
		List<BkgMdmCustomerVO> bkgMdmCustomerVO = null;	
		//query parameter
		Map<String, String> param = new HashMap<String, String>();
		//velocity parameter
		Map<String, String> velParam = new HashMap<String, String>();
		try{	
			param = paramVo.getColumnValues();
			velParam = paramVo.getColumnValues();
			
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate)new BookingUtilDBDAOMdmCustomerCodeRSQL(), param, velParam);
			bkgMdmCustomerVO = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgMdmCustomerVO.class);	
			if(bkgMdmCustomerVO.size() > 0){
				return bkgMdmCustomerVO.get(0);
			}
		} catch(SQLException se) {	
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return null; 
	}
	
	/**
	 * MDM Carrier retrieve
	 * 
	 * @param MdmCarrierVO MdmCarrierVO
	 * @return List<MdmCarrierVO>
	 * @throws DAOException
	 * @author SJH.20150114.ADD
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCarrierVO> searchCarrier(MdmCarrierVO mdmCarrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCarrierVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		log.debug("mdmCarrierVO:" + mdmCarrierVO);
		try {
			if (mdmCarrierVO != null) {
				Map<String, String> mapVO = mdmCarrierVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOMdmCarrierVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmCarrierVO.class);
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
	 * booking 정보에 대한 japan stamp check
	 * 
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public String checkJapanStamp(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String resultStr = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter().executeQuery(new BookingUtilDBDAOCheckJapanStampRSQL(), param, velParam);
			
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
	 * E-signature flag search<br>
	 * 
	 * @param String bkgNo
	 * @return BkgBlNoVO
	 * @throws DAOException
	 */
	public BkgBlNoVO searchEsigAgent(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlNoVO> list = null;
		BkgBlNoVO vo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchEsigAgentRSQL(), param, null);
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
     * CHECKING MDM_CHARGE.CO_CHG_ACCT_CD NULL<br>
     * @param  	List<String> chgCdList
     * @return 	List<String>
     * @throws EventException
     */
	public List<String> searchChgAcctNull(List<String> chgCdList) throws DAOException {
	   	DBRowSet dbRowset = null;
		List<String> rtnList =  new ArrayList<String>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			velParam.put("chg_cd_list", chgCdList);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchChgAcctNullRSQL(), null, velParam);
			while (dbRowset.next()) {
				rtnList.add(dbRowset.getString("chg_cd"));
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
     * Bkg_DOC_PROC_SKD 'BKGSTF'의 DOC_PERF_DELT_FLG='Y' 처리한다.(changeBkgStatus)<br>
     * 
     * @param  bkgNo String
     * @param  account SignOnUserAccount
     * @exception DAOException
     */
    public void cancelBkgStateFirm(String bkgNo, SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            param.put   ("bkg_no", bkgNo);
            param.put   ("upd_usr_id", account.getUsr_id());
            
            velParam.put("bkg_no", bkgNo);
            velParam.put("upd_usr_id", account.getUsr_id());

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingUtilDBDAOCancelBkgStateFirmUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Bkg_DOC_PROC_SKD 'BKGSTF'을 생성한다. (changeBkgStatus)<br>
     * 
     * @param  bkgNo String
     * @param  account SignOnUserAccount
     * @exception DAOException
     */
    public void addBkgStateFirm(String bkgNo, SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            param.put   ("bkg_no", bkgNo);
            param.put   ("cre_usr_id", account.getUsr_id());
            param.put   ("evnt_usr_id", account.getUsr_id());
            
            velParam.put("bkg_no", bkgNo);
            velParam.put("cre_usr_id", account.getUsr_id());
            velParam.put("evnt_usr_id", account.getUsr_id());

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingUtilDBDAOAddBkgStateFirmCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }	
    
    /**
     * 
     * @param ofcCd
     * @return
     * @throws DAOException
     */
    public String searchMdmEurFlg(String ofcCd) throws DAOException {
    	DBRowSet dbRowset = null;
		String eurFlg = null;
		// velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate)new BookingUtilDBDAOMdmEurFlgRSQL(), param, null);
			while (dbRowset.next()) {
				eurFlg = dbRowset.getString("EUR_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eurFlg;
    }
    
    /**
     * 
     * @param bkgNo
     * @return
     * @throws DAOException
     */
    public String searchMdmEurFlgBkgNo(String bkgNo) throws DAOException {
    	DBRowSet dbRowset = null;
		String eurFlg = "";
		// velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate)new BookingUtilDBDAOMdmEurFlgBkgNoRSQL(), param, null);
			while (dbRowset.next()) {
				eurFlg = dbRowset.getString("EUR_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eurFlg;
    }
    /**
     * 
     * @param bkgNo
     * @param account
     * @throws DAOException
     */
    public void modifyBkgReceiptEdiHldFlg(String bkgNo, SignOnUserAccount account) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        try {
            param.put   ("bkg_no", bkgNo);
            param.put   ("cre_usr_id", account.getUsr_id());
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingUtilDBDAOModifyBkgReceiptEdiHldFlgUSQL(), param, param);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }	
    
   /**
    * 
    * @param bkgNo
    * @param title
    * @param contents
    * @param emlAddr
    * @param remark
    * @param mrdNm
    * @param account
    * @return
    * @throws DAOException
    */
    public BkgNtcHisVO internetBookingRequestAcceptedEmail(String bkgNo, String title, String contents, String emlAddr, String remark, String mrdNm, SignOnUserAccount account) throws DAOException {
		List<ComRptDsgnXptInfoVO> vos = null;
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
		try {
			log.debug("['" + bkgNo + "'][" + account.getUsr_id() + "][" + remark + "][" + emlAddr + "][][Y][][][][]");
			vo = new ComRptDsgnXptInfoVO();
			
			if(!"".equals(mrdNm)){
				vo.setRdTmpltNm(mrdNm+".mrd");
				vo.setRdParaCtnt("/rp ['" + bkgNo + "'][" + account.getUsr_id() + "][" + remark + "][" + emlAddr + "][][Y][][][][]");
				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				vo.setXptFileNm(ConstantMgr.getScacCode() + bkgNo + ".pdf");
			}
			
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vos = new ArrayList<ComRptDsgnXptInfoVO>();
			vos.add(vo);
			template = new TemplateMail();
			template.setBatFlg("N");
			template.setFrom("noreply@nykline.com");
			template.setRecipient(emlAddr);
			template.setSubject(title); 
			template.setHtmlContent(contents);
			if(!"".equals(mrdNm)){
				template.setComRptDsgnXptInfoVOs(vos);
			}
			
			template.setArg("bkgNoBody", bkgNo);
				
			String sendId = template.send();
			
			bkgNtcHisVO.setBkgNo(bkgNo);
			bkgNtcHisVO.setNtcViaCd("M");  //F:Fax,M:Email
			bkgNtcHisVO.setNtcKndCd("BK");
			bkgNtcHisVO.setNtcSeq("0");
			bkgNtcHisVO.setCustCntcTpCd(null);
			bkgNtcHisVO.setNtcEml(emlAddr);
			bkgNtcHisVO.setSndId(sendId);
			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
			bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
			bkgNtcHisVO.setDiffRmk(remark);
			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return bkgNtcHisVO;
    }
    
   /**
    * 
    * @param bkgNo
    * @return
    * @throws DAOException
    */
	public BkgBookingInfoVO internetBookingRequestEmailInfo(String bkgNo) throws DAOException {
    	DBRowSet dbRowset = null;
    	BkgBookingInfoVO bkgBookingInfoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOInternetBookingRequestEmailInfoRSQL(), param, null);
			List<BkgBookingInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBookingInfoVO.class);
			if(list.size() > 0){
				bkgBookingInfoVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgBookingInfoVO;
	}
    
   /**
    * 
    * @param bkgNtcHisVO
    * @throws DAOException
    */
    public void addBkgNtcHis(BkgNtcHisVO bkgNtcHisVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = bkgNtcHisVO.getColumnValues();
        	
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new BookingHistoryMgtDBDAOaddBkgNtcHisCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * 
     * @param bkgDocProcSkdVO
     * @throws DAOException
     */
    public void addBkgDocProcSkd(BkgDocProcSkdVO bkgDocProcSkdVO) throws DAOException {
    	 // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = bkgDocProcSkdVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new BookingUtilDBDAOaddBkgDocProcSkdCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
        } catch(SQLException ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * 
     * @param bkgNo
     * @return
     * @throws DAOException
     */
    public String searchBkgCntcPsonEml(String bkgNo) throws DAOException {
   	 // query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       DBRowSet dbRowset = null;
       String cntcPsonEml = null;
       try {
           param.put("bkg_no", bkgNo);
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchBkgCntcPsonEmlRSQL(), param, null);
           while(dbRowset.next()){
        	   cntcPsonEml = dbRowset.getString("CNTC_PSON_EML");
           }
       } catch(SQLException ex) {
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       } catch(Exception ex) {
       	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       }
       
       return cntcPsonEml;
   }
    
    /**
     * 
     * @param cntrTpszCd
     * @return
     * @throws DAOException
     */
	public String checkCntrTpszCd(String cntrTpszCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String count = "0";
		try {
			param.put("cntr_tpsz_cd", cntrTpszCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchCntrTpSzRSQL(), param, null);
			while (dbRowset.next()) {
				count = dbRowset.getString(1);
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return count;
	}

    
	/**
	 * Check whether yard exists in specified VVD and return cltp_ind_seq .<br>
	 * Table -vsk_vsl_port_skd<br>
	 * 
	 * @param String vvd 
	 * @param String ydCd 
	 * @param String cltpIndSeq 
	 * @return String
	 * @throws DAOException
	 */
	public String searchCltpIndSeq(String vvd ,String ydCd, String cltpIndSeq) throws DAOException {
		String rtnCltpIndSeq = null;
		String tempCltpIndSeq = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("vvd", vvd);
			param.put("yd_cd", ydCd);
			param.put("cltp_ind_seq", cltpIndSeq);

			velParam.put("vvd", vvd);
			velParam.put("yd_cd", ydCd);
			velParam.put("cltp_ind_seq", cltpIndSeq);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchClptIndSeqRSQL template = new BookingUtilDBDAOSearchClptIndSeqRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			if (dbRowset.next()) {
				if(!"".equals(cltpIndSeq)){
					if("1".equals(dbRowset.getString("CLPT_IND_SEQ_MATCH"))){
						rtnCltpIndSeq = ""; //Yard and cltp_ind_seq exist. OK case.
					}else{
						rtnCltpIndSeq = "E1"; //Yard exist, but cltp_ind_seq does not match.
					}
					
				}else{
					tempCltpIndSeq = dbRowset.getString("CLPT_IND_SEQ");
					if(dbRowset.next()){
						rtnCltpIndSeq = "E1"; // Yard exist, multiple cltp_ind_seq exist
					}else{
						rtnCltpIndSeq = tempCltpIndSeq; //Yard exist, cltp_ind_seq is identified by yard code
					}
				}
			}else{
				rtnCltpIndSeq = "E0"; // Yard does not exist in the VVD
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rtnCltpIndSeq;
	}

	/**
	 * Check whether yard exists or not
	 * 
	 * @param String ydCd 
	 * @return Boolean
	 * @throws DAOException
	 */
	public Boolean validateYardCode(String ydCd) throws DAOException {

		Boolean valid = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("yd_cd", ydCd);
			velParam.put("yd_cd", ydCd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOValidateYardCodeRSQL template = new BookingUtilDBDAOValidateYardCodeRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			if (dbRowset.next()) {
				valid = true;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return valid;
	}

	
	/**
	 * Retrieve all exchange information information regarding BKG<br>
	 * 
	 * @param String bkgNo
	 * @return List<ExchangeRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExchangeRateVO> searchAllXchRate(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExchangeRateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("chg_currs", null);
			velParam.put("chg_currs", null);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchAllXchRateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExchangeRateVO.class);
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}    
	
	/**
	 * Retrieve all exchange information information regarding BKG<br>
	 * 
	 * @param String bkgNo
	 * @param List<String> chgCurrs
	 * @return List<ExchangeRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExchangeRateVO> searchAllXchRate(String bkgNo, List<String> chgCurrs) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExchangeRateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			if(chgCurrs==null){
				chgCurrs = null;
				param.put("chg_currs", null);
				velParam.put("chg_currs", null);
			}else{
				Map<String,List<String>> chgMapVO = new HashMap<String,List<String>>(chgCurrs.size());
				chgMapVO.put("chg_currs", chgCurrs);
				param.putAll(chgMapVO);
				velParam.putAll(chgMapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchAllXchRateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExchangeRateVO.class);
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 	
	
	/**
	 * Retrieve prepaid Curr, collect Curr information regarding BKG, tax charge<br>
	 * 
	 * @param String bkgNo
	 * @param List<String> chgCds
	 * @return List<ExchangeRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExchangeRateVO> searchArCurByTaxChg(String bkgNo, List<String> chgCds) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExchangeRateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			if(chgCds==null){
				chgCds = null;
				param.put("chg_cds", null);
				velParam.put("chg_cds", null);
			}else{
				Map<String,List<String>> chgMapVO = new HashMap<String,List<String>>(chgCds.size());
				chgMapVO.put("chg_cds", chgCds);
				param.putAll(chgMapVO);
				velParam.putAll(chgMapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchARCurByTaxChgRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExchangeRateVO.class);
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}    
	
	/**
	 * Retrieve MDM_CHAGRE TAX_FLG<br>
	 * 
	 * @param String chgCd
	 * @return MdmChgTaxFlgVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmChgTaxFlgVO searchChgTaxFlg(String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<MdmChgTaxFlgVO> list = null;
		MdmChgTaxFlgVO mdmChgTaxFlgVO = new MdmChgTaxFlgVO();

		try {
			param.put("chg_cd", chgCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchChgTaxFlgRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmChgTaxFlgVO.class);
			if (list != null && list.size() > 0) {
				mdmChgTaxFlgVO = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mdmChgTaxFlgVO;
	}  	
	
	/**
	 * Bcc email address 구하는 함수 <br>
	 * @param String bkg_eml_knd_cd
	 * @return String output_text
	 * @exception DAOException 
	 * @author SJH.20160324.ADD
	 */
	public String searchBccEmailAddrRSQL(String bkg_eml_knd_cd) throws DAOException {
		// input_text
		String output_text = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_eml_knd_cd", bkg_eml_knd_cd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BookingUtilDBDAOSearchBccEmailAddrRSQL template = new BookingUtilDBDAOSearchBccEmailAddrRSQL();
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
     * Check S/O is already created or not<br>
     * 
     * @param String bkgNo
     * @param String boundCd
     * @param String nodCd
     * @return Boolean
     * @throws DAOException
     */
    public Boolean searchSoExist(String bkgNo, String boundCd, String nodCd) throws DAOException {
    	DBRowSet dbRowset = null;
		Boolean rtn = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("bound_cd", boundCd);
			param.put("nod_cd", nodCd);
			velParam.put("bkg_no", bkgNo);
			velParam.put("bound_cd", boundCd);
			velParam.put("nod_cd", nodCd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchSoExistRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn = true;
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
     * 
     * @param pgmNo
     * @param usrId
     * @return
     * @throws DAOException
     */
    public int searchUserPgmRoleMach(String pgmNo, String usrId) throws DAOException {
    	DBRowSet dbRowset = null;
		int cnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(pgmNo != null && !pgmNo.equals("")){
				param.put("pgm_id", pgmNo);
				velParam.put("pgm_id", pgmNo);
			}
			param.put("usr_id", usrId);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDDAOUserPgmRoleMachRSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getInt("CNT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
    }	
    
    /**
     * Return EDI_HLD_FLG value of BKG_BOOKING<br>
     * 
     * @param String bkgNo
     * @return String
     * @throws DAOException
     */
    public String searchEdiHldFlg(String bkgNo) throws DAOException {
    	DBRowSet dbRowset = null;
		String rtn = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchEdiHldFlgRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn = dbRowset.getString("EDI_HLD_FLG");
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
	 * currency에 대한 소숫점 자릿수를 조회한다.<br>
	 * 
	 * @param String currCd
	 * @return MdmCurrencyVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmCurrencyVO searchDpPrcsKntByCur(String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<MdmCurrencyVO> list = null;
		MdmCurrencyVO mdmCurrencyVO = new MdmCurrencyVO();

		try {
			param.put("curr_cd", currCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchDpPrcsKntByCurRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCurrencyVO.class);
			if (list != null && list.size() > 0) {
				mdmCurrencyVO = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mdmCurrencyVO;
	}
	
	 /**
     * 해당 bkg의 tro, cntr에 대해서 s/o가 issue 되었는지 조회한다.<br>
     * 
     * @param bkgBookingInfoVO
     * @return String
     * @throws DAOException
     */
    public String searchPrdReplanCode(BkgBookingInfoVO bkgBookingInfoVO) throws DAOException {
    	DBRowSet dbRowset = null;
		String rtn = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			param.put("bkg_no", bkgBookingInfoVO.getBkgNo());
			param.put("por", bkgBookingInfoVO.getBkgPorCd());
			param.put("pol", bkgBookingInfoVO.getBkgPolCd());
			param.put("pod", bkgBookingInfoVO.getBkgPodCd());
			param.put("del", bkgBookingInfoVO.getBkgDelCd());
			param.put("t_vvd", bkgBookingInfoVO.getBkgTrunkVvd());
			param.put("rcv_t", bkgBookingInfoVO.getRcvTermCd());
			param.put("del_t", bkgBookingInfoVO.getDeTermCd());
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchPrdReplanCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn = dbRowset.getString("E_CD");
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
     * Search Vsl Eng Nm and Cssm Voy No <br>
     * 
     * @param String bkgNo
     * @return Boolean
     * @throws DAOException
     */
    public String searchVslEngNmCssmVoyNo(String bkgNo) throws DAOException {
    	DBRowSet dbRowset = null;
		String vslEngNmCssmVoyNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchVslEngNmCssmVoyNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				vslEngNmCssmVoyNo = dbRowset.getString("VVD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vslEngNmCssmVoyNo;
    }	
    
    /**
     * Return all VVD information of specified booking<br>
     * 
     * @param String bkgNo
     * @return String
     * @throws DAOException
     */
    public String searchBkgVvd(String bkgNo) throws DAOException {
    	DBRowSet dbRowset = null;
		String vvd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchBkgVvdRSQL(), param, velParam);
			if (dbRowset.next()) {
				vvd = dbRowset.getString("VVD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvd;
    }	
    
    /**
     * 
     * @param xterRqstNoVO
     * @return
     * @throws DAOException
     */
    public BkgXterUsrInfoVO searchBkgPtyXterUsrInfo(XterRqstNoVO xterRqstNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<BkgXterUsrInfoVO> list = null;
		BkgXterUsrInfoVO bkgXterUsrInfoVO = new BkgXterUsrInfoVO();

		try {
			Map<String, String> mapVO = xterRqstNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDDAOBkgPtyXterUsrInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgXterUsrInfoVO.class);
			if (list != null && list.size() > 0) {
				bkgXterUsrInfoVO = list.get(0);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			//log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgXterUsrInfoVO;
	}
    
    /**
     * 
     * @param modName
     * @param applInfo
     * @param log
     * @throws DAOException
     */
    public void addErrorBkgLog(String modName, String applInfo, String log) throws DAOException {
    	Map<String, Object> param = new HashMap<String, Object>();
    	Map<String, Object> velParam = new HashMap<String, Object>();

    	try {
    		Map<String, String> mapVO = new HashMap<String, String>();
    		mapVO.put("mod_name",  modName);
    		mapVO.put("appl_info", applInfo);
    		mapVO.put("log_desc",  log);
    		param.putAll(mapVO);
    		velParam.putAll(mapVO);
    		new SQLExecuter("").executeSP((ISQLTemplate)new BookingUtilDBDDAOErrorBkgLogCSQL(), param, velParam);
    	} catch (SQLException se) {
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	} catch(Exception ex){
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
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
	 * FILE UPLOAD 체크 공통 쿼리
	 * @param fileKey
	 * @return
	 * @throws DAOException
	 */
	public ComUpldFileVO selectComUpldFile(String fileKey)throws DAOException{
		Map mapParam = new HashMap();
		mapParam.put("file_sav_id", fileKey);
		ComUpldFileVO comUpldFileVO = null;
		try {
			DBRowSet dbRowSet = new SQLExecuter("DEFAULTXA").executeQuery(new FileUploadDAOComUpldFileRSQL(), mapParam, null);
			while(dbRowSet.next()){
				comUpldFileVO = new ComUpldFileVO();
				comUpldFileVO.setFileSavId(dbRowSet.getString("FILE_SAV_ID"));
				comUpldFileVO.setFileUpldNm(dbRowSet.getString("FILE_UPLD_NM"));
				comUpldFileVO.setFileSzCapa(dbRowSet.getString("FILE_SZ_CAPA"));
				comUpldFileVO.setFilePathUrl(dbRowSet.getString("FILE_PATH_URL"));
				comUpldFileVO.setPgmSubSysCd(dbRowSet.getString("PGM_SUB_SYS_CD"));
				comUpldFileVO.setDeltFlg(dbRowSet.getString("DELT_FLG"));
			}
			return comUpldFileVO;
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (DAOException e) {
			throw new DAOException(e);
		} catch (IndexOutOfBoundsException e) {
			throw new DAOException(e);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

    /**
     * Obl Print 예외 사용자, 오피스 처리
     * @param SignOnUserAccount account
     * @return
     * @throws DAOException
     */
	public String checkOblAuthPass(SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String count = "0";
		try {
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOCheckOblAuthPassRSQL(), param, null);
			while (dbRowset.next()) {
				count = dbRowset.getString(1);
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return count;
	}	
	
	/**
	 * 
	 * @param bkgBookingInfoVO
	 * @return
	 * @throws DAOException
	 */
	public String bkgBookingSaveCheck(BkgBookingInfoVO bkgBookingInfoVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String lastSaveTime = null;
		try {
			param.putAll(bkgBookingInfoVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralBookingReceiptDBDAOSearchBkgLastSaveTimeRSQL(), param, param);
			while (dbRowset.next()) {
				lastSaveTime = dbRowset.getString("LST_SAV_DT");
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return lastSaveTime;
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @throws DAOException
	 */
	public void bkgBookingLstSavDtSave(String bkgNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new GeneralBookingReceiptDBDAOBkgLastSaveTimeCSQL(), param, param);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
     * HTML5 RD 사용자, 오피스 정보 조회
     * @param SignOnUserAccount account
     * @return
     * @throws DAOException
     */
	public String checkHtml5RDPass(SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String count = "0";
		try {
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingUtilDBDAOCheckHtml5RDViewerRSQL(), param, null);
			while (dbRowset.next()) {
				count = dbRowset.getString(1);
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return count;
	}
	
	/**
	 * Vender301 EDI 대상 조회 <br>
	 * @param String bkgNo
	 * @return String output_text
	 * @exception DAOException 
	 * @author 
	 */
	public String searchVenderEdiBkg(String bkgNo) throws DAOException {
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
			BookingUtilDBDAOsearchVenderEdiBkgRSQL template = new BookingUtilDBDAOsearchVenderEdiBkgRSQL();
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
	 * Get basic VVD and route information of BKG_BOOKING<br>
	 *
	 * @param String bkgNo
	 * @return BkgVvdRouteVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgVvdRouteVO searchBkgVvdRoute(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		BkgVvdRouteVO bkgVvdRouteVO = null;
		List<BkgVvdRouteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchBkgVvdRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVvdRouteVO.class);
			if (list != null && list.size() > 0) {
				bkgVvdRouteVO = list.get(0);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return bkgVvdRouteVO;
	}

    /**
     * Check S/O is already created or not<br>
     * 
     * @param String bkgNo
     * @param String boundCd 'O' or 'I'
     * @param String troSeq
     * @return Boolean
     * @throws DAOException
     */
    public Boolean searchSoExistByTro(String bkgNo, String boundCd, String troSeq) throws DAOException {
    	DBRowSet dbRowset = null;
		Boolean rtn = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("bound_cd", boundCd);
			param.put("tro_seq", troSeq);
			velParam.put("bkg_no", bkgNo);
			velParam.put("bound_cd", boundCd);
			velParam.put("tro_seq", troSeq);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchSoExistByTroRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return rtn;
    }	
    
    /**
     * Return BL value of BKG_BL_ISS<br>
     * 
     * @param BkgUsrDfltSetVO vo
     * @return String
     * @throws DAOException
     */
    public String searchBlPrnFlg(BkgUsrDfltSetVO vo) throws DAOException {
    	DBRowSet dbRowset = null;
		String rtn = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		// query parameter

		try {
			
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);;

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchBlPrnFlgRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn = dbRowset.getString("OBL_PRN_FLG");
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
     * 
     * @param locCd
     * @return
     * @throws DAOException
     */
    public String searchLocationNm(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("loc_cd", locCd);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOsearchLocationNmRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnString = dbRowset.getString("NM");
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
     * 
     * @param chgCd
     * @return
     * @throws DAOException
     */
    public String searchVietnamTaxCharge(String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("chg_cd", chgCd);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new BookingUtilDBDAOSearchVietnamTaxChargeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnString = dbRowset.getString("VN_FLG");
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
    
}
