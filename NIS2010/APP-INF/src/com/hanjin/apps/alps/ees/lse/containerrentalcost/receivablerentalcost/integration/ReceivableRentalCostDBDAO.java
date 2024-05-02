/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableRentalCostDBDAO.java
*@FileTitle : EQ Receivable Charge Summary By Charge Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.17 진준성
* 1.0 Creation
* =======================================================
* 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.basic.ReceivableRentalCostBCImpl;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeDetailVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReportSearchReceivableVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.SearchParamVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS ReceivableRentalCostDBDAO <br>
 * - ALPS-ContainerRentalCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jin Jun Sung
 * @see ReceivableRentalCostBCImpl 참조
 * @since J2EE 1.6
 */
public class ReceivableRentalCostDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Receivable Invoice 한 결과에 대하여 Charge Type별로 실적을 조회<br>
	 *
	 * @param  ReportSearchReceivableVO reportSearchReceivableVO
	 * @return List<ReportSearchReceivableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportSearchReceivableVO> searchReceivableRentalReportByChargeTypeData(ReportSearchReceivableVO reportSearchReceivableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchReceivableVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(reportSearchReceivableVO != null){
				String strPeriodStdt = reportSearchReceivableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchReceivableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");

				List<String> arrLstmCd = null;
	            arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getLstmCd(),",","|"));

				List<String> arrCntrTpszCd = null;
	            arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getCntrTpszCd(),",","|"));

	            List<String> arrChargeTypeCd = null;
	            arrChargeTypeCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getChargeTypeCd(),",","|"));

	            param.put("report_type"       , reportSearchReceivableVO.getReportType());
	            param.put("period_stdt"       , strPeriodStdt);
	            param.put("period_eddt"       , strPeriodEddt);
	            param.put("period_year"       , reportSearchReceivableVO.getPeriodYear());
	            param.put("company"           , reportSearchReceivableVO.getCompany());
	            param.put("status"            , reportSearchReceivableVO.getStatus());
	            param.put("receivable"        , reportSearchReceivableVO.getReceivable());
	            param.put("agmt_cty_cd"       , reportSearchReceivableVO.getAgmtCtyCd());
	            param.put("agmt_seq"          , reportSearchReceivableVO.getAgmtSeq());
	            param.put("vndr_seq"          , reportSearchReceivableVO.getVndrSeq());
	            param.put("loc_tp"            , reportSearchReceivableVO.getLocTp());
	            param.put("loc_cd"            , reportSearchReceivableVO.getLocCd());

	            velParam.put("report_type"    , reportSearchReceivableVO.getReportType());
	            velParam.put("period_stdt"    , strPeriodStdt);
	            velParam.put("period_eddt"    , strPeriodEddt);
	            velParam.put("period_year"    , reportSearchReceivableVO.getPeriodYear());
	            velParam.put("company"        , reportSearchReceivableVO.getCompany());
	            velParam.put("status"         , reportSearchReceivableVO.getStatus());
	            velParam.put("receivable"     , reportSearchReceivableVO.getReceivable());
	            velParam.put("agmt_cty_cd"    , reportSearchReceivableVO.getAgmtCtyCd());
	            velParam.put("agmt_seq"       , reportSearchReceivableVO.getAgmtSeq());
	            velParam.put("vndr_seq"       , reportSearchReceivableVO.getVndrSeq());
	            velParam.put("loc_tp"         , reportSearchReceivableVO.getLocTp());
	            velParam.put("loc_cd"         , reportSearchReceivableVO.getLocCd());
	            velParam.put("lstm_cd"            , arrLstmCd);
	            velParam.put("lstm_cd_str"        , reportSearchReceivableVO.getLstmCd());
	            velParam.put("cntr_tpsz_cd"       , arrCntrTpszCd);
	            velParam.put("cntr_tpsz_cd_str"   , reportSearchReceivableVO.getCntrTpszCd());
	            velParam.put("charge_type_cd"     , arrChargeTypeCd);
	            velParam.put("charge_type_cd_str" , reportSearchReceivableVO.getChargeTypeCd());
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOsearchReceivableRentalReportByChargeTypeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchReceivableVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 * Receivable Invoice 한 결과에 대하여 TP/SZ , Month 별로 실적을 조회<br>
	 *
	 * @param  ReportSearchReceivableVO reportSearchReceivableVO
	 * @return List<ReportSearchReceivableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportSearchReceivableVO> searchReceivableRentalReportByTySzMonthData(ReportSearchReceivableVO reportSearchReceivableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchReceivableVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(reportSearchReceivableVO != null){
				String strPeriodStdt = reportSearchReceivableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchReceivableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");

				List<String> arrLstmCd = null;
	            arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getLstmCd(),",","|"));

				List<String> arrCntrTpszCd = null;
	            arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getCntrTpszCd(),",","|"));

	            List<String> arrChargeTypeCd = null;
	            arrChargeTypeCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getChargeTypeCd(),",","|"));

	            param.put("report_type"       , reportSearchReceivableVO.getReportType());
	            param.put("period_stdt"       , strPeriodStdt);
	            param.put("period_eddt"       , strPeriodEddt);
	            param.put("period_year"       , reportSearchReceivableVO.getPeriodYear());
	            param.put("company"           , reportSearchReceivableVO.getCompany());
	            param.put("status"            , reportSearchReceivableVO.getStatus());
	            param.put("receivable"        , reportSearchReceivableVO.getReceivable());
	            param.put("agmt_cty_cd"       , reportSearchReceivableVO.getAgmtCtyCd());
	            param.put("agmt_seq"          , reportSearchReceivableVO.getAgmtSeq());
	            param.put("vndr_seq"          , reportSearchReceivableVO.getVndrSeq());
	            param.put("loc_tp"            , reportSearchReceivableVO.getLocTp());
	            param.put("loc_cd"            , reportSearchReceivableVO.getLocCd());

	            velParam.put("report_type"    , reportSearchReceivableVO.getReportType());
	            velParam.put("period_stdt"    , strPeriodStdt);
	            velParam.put("period_eddt"    , strPeriodEddt);
	            velParam.put("period_year"    , reportSearchReceivableVO.getPeriodYear());
	            velParam.put("company"        , reportSearchReceivableVO.getCompany());
	            velParam.put("status"         , reportSearchReceivableVO.getStatus());
	            velParam.put("receivable"     , reportSearchReceivableVO.getReceivable());
	            velParam.put("agmt_cty_cd"    , reportSearchReceivableVO.getAgmtCtyCd());
	            velParam.put("agmt_seq"       , reportSearchReceivableVO.getAgmtSeq());
	            velParam.put("vndr_seq"       , reportSearchReceivableVO.getVndrSeq());
	            velParam.put("loc_tp"         , reportSearchReceivableVO.getLocTp());
	            velParam.put("loc_cd"         , reportSearchReceivableVO.getLocCd());
	            velParam.put("lstm_cd"            , arrLstmCd);
	            velParam.put("lstm_cd_str"        , reportSearchReceivableVO.getLstmCd());
	            velParam.put("cntr_tpsz_cd"       , arrCntrTpszCd);
	            velParam.put("cntr_tpsz_cd_str"   , reportSearchReceivableVO.getCntrTpszCd());
	            velParam.put("charge_type_cd"     , arrChargeTypeCd);
	            velParam.put("charge_type_cd_str" , reportSearchReceivableVO.getChargeTypeCd());
			}
			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOsearchReceivableRentalReportByTySzMonthRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchReceivableVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Receivable Invoice 한 결과에 대하여 Charge Type , TP/SZ별로 실적을 조회<br>
	 *
	 * @param  ReportSearchReceivableVO reportSearchReceivableVO
	 * @return List<ReportSearchReceivableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportSearchReceivableVO> searchReceivableRentalReportByChargeTypeTySzData(ReportSearchReceivableVO reportSearchReceivableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchReceivableVO> list =  new ArrayList<ReportSearchReceivableVO>();
		ReportSearchReceivableVO rsVo = new ReportSearchReceivableVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(reportSearchReceivableVO != null){
				String strPeriodStdt = reportSearchReceivableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchReceivableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");

				List<String> arrLstmCd = null;
	            arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getLstmCd(),",","|"));

				List<String> arrCntrTpszCd = null;
	            arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getCntrTpszCd(),",","|"));

	            List<String> arrChargeTypeCd = null;
	            arrChargeTypeCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getChargeTypeCd(),",","|"));

	            List<String> arrTysz   = null;
	            arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getTysz(),",","|"));

	            param.put("report_type"       , reportSearchReceivableVO.getReportType());
	            param.put("period_stdt"       , strPeriodStdt);
	            param.put("period_eddt"       , strPeriodEddt);
	            param.put("period_year"       , reportSearchReceivableVO.getPeriodYear());
	            param.put("company"           , reportSearchReceivableVO.getCompany());
	            param.put("status"            , reportSearchReceivableVO.getStatus());
	            param.put("receivable"        , reportSearchReceivableVO.getReceivable());
	            param.put("agmt_cty_cd"       , reportSearchReceivableVO.getAgmtCtyCd());
	            param.put("agmt_seq"          , reportSearchReceivableVO.getAgmtSeq());
	            param.put("vndr_seq"          , reportSearchReceivableVO.getVndrSeq());
	            param.put("loc_tp"            , reportSearchReceivableVO.getLocTp());
	            param.put("loc_cd"            , reportSearchReceivableVO.getLocCd());
	            param.put("tysz"              , arrTysz);

	            velParam.put("report_type"    , reportSearchReceivableVO.getReportType());
	            velParam.put("period_stdt"    , strPeriodStdt);
	            velParam.put("period_eddt"    , strPeriodEddt);
	            velParam.put("period_year"    , reportSearchReceivableVO.getPeriodYear());
	            velParam.put("company"        , reportSearchReceivableVO.getCompany());
	            velParam.put("status"         , reportSearchReceivableVO.getStatus());
	            velParam.put("receivable"     , reportSearchReceivableVO.getReceivable());
	            velParam.put("agmt_cty_cd"    , reportSearchReceivableVO.getAgmtCtyCd());
	            velParam.put("agmt_seq"       , reportSearchReceivableVO.getAgmtSeq());
	            velParam.put("vndr_seq"       , reportSearchReceivableVO.getVndrSeq());
	            velParam.put("loc_tp"         , reportSearchReceivableVO.getLocTp());
	            velParam.put("loc_cd"         , reportSearchReceivableVO.getLocCd());
	            velParam.put("lstm_cd"            , arrLstmCd);
	            velParam.put("lstm_cd_str"        , reportSearchReceivableVO.getLstmCd());
	            velParam.put("cntr_tpsz_cd"       , arrCntrTpszCd);
	            velParam.put("cntr_tpsz_cd_str"   , reportSearchReceivableVO.getCntrTpszCd());
	            velParam.put("charge_type_cd"     , arrChargeTypeCd);
	            velParam.put("charge_type_cd_str" , reportSearchReceivableVO.getChargeTypeCd());
	            velParam.put("tysz"               , arrTysz);
			}
			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOsearchReceivableRentalReportByChargeTypeTySzRSQL(), param, velParam);
			if(reportSearchReceivableVO.getReportType() != null)
				rsVo.setReportType(reportSearchReceivableVO.getReportType());
			else
				rsVo.setReportType(null);
			
			if(reportSearchReceivableVO.getTysz() != null)
				rsVo.setTysz(reportSearchReceivableVO.getTysz());
			else
				rsVo.setTysz(null);
			rsVo.setDbRowset(dbRowset);
			
			list.add(rsVo);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Receivable Invoice 한 결과에 대하여 Lease Term , Month별로 실적을 조회<br>
	 *
	 * @param  ReportSearchReceivableVO reportSearchReceivableVO
	 * @return List<ReportSearchReceivableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportSearchReceivableVO> searchReceivableRentalReportByLeaseTermMonthData(ReportSearchReceivableVO reportSearchReceivableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchReceivableVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(reportSearchReceivableVO != null){
				String strPeriodStdt = reportSearchReceivableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchReceivableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");

				List<String> arrLstmCd = null;
	            arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getLstmCd(),",","|"));

				List<String> arrCntrTpszCd = null;
	            arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getCntrTpszCd(),",","|"));

	            List<String> arrChargeTypeCd = null;
	            arrChargeTypeCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getChargeTypeCd(),",","|"));

	            param.put("report_type"       , reportSearchReceivableVO.getReportType());
	            param.put("period_stdt"       , strPeriodStdt);
	            param.put("period_eddt"       , strPeriodEddt);
	            param.put("period_year"       , reportSearchReceivableVO.getPeriodYear());
	            param.put("company"           , reportSearchReceivableVO.getCompany());
	            param.put("status"            , reportSearchReceivableVO.getStatus());
	            param.put("receivable"        , reportSearchReceivableVO.getReceivable());
	            param.put("agmt_cty_cd"       , reportSearchReceivableVO.getAgmtCtyCd());
	            param.put("agmt_seq"          , reportSearchReceivableVO.getAgmtSeq());
	            param.put("vndr_seq"          , reportSearchReceivableVO.getVndrSeq());
	            param.put("loc_tp"            , reportSearchReceivableVO.getLocTp());
	            param.put("loc_cd"            , reportSearchReceivableVO.getLocCd());

	            velParam.put("report_type"    , reportSearchReceivableVO.getReportType());
	            velParam.put("period_stdt"    , strPeriodStdt);
	            velParam.put("period_eddt"    , strPeriodEddt);
	            velParam.put("period_year"    , reportSearchReceivableVO.getPeriodYear());
	            velParam.put("company"        , reportSearchReceivableVO.getCompany());
	            velParam.put("status"         , reportSearchReceivableVO.getStatus());
	            velParam.put("receivable"     , reportSearchReceivableVO.getReceivable());
	            velParam.put("agmt_cty_cd"    , reportSearchReceivableVO.getAgmtCtyCd());
	            velParam.put("agmt_seq"       , reportSearchReceivableVO.getAgmtSeq());
	            velParam.put("vndr_seq"       , reportSearchReceivableVO.getVndrSeq());
	            velParam.put("loc_tp"         , reportSearchReceivableVO.getLocTp());
	            velParam.put("loc_cd"         , reportSearchReceivableVO.getLocCd());
	            velParam.put("lstm_cd"            , arrLstmCd);
	            velParam.put("lstm_cd_str"        , reportSearchReceivableVO.getLstmCd());
	            velParam.put("cntr_tpsz_cd"       , arrCntrTpszCd);
	            velParam.put("cntr_tpsz_cd_str"   , reportSearchReceivableVO.getCntrTpszCd());
	            velParam.put("charge_type_cd"     , arrChargeTypeCd);
	            velParam.put("charge_type_cd_str" , reportSearchReceivableVO.getChargeTypeCd());
			}
			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOsearchReceivableRentalReportByLeaseTermMonthRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchReceivableVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Receivable Invoice 한 결과에 대하여 Lessor , Month별로 실적을 조회<br>
	 *
	 * @param  ReportSearchReceivableVO reportSearchReceivableVO
	 * @return List<ReportSearchReceivableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportSearchReceivableVO> searchReceivableRentalReportByLessorMonthData(ReportSearchReceivableVO reportSearchReceivableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchReceivableVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(reportSearchReceivableVO != null){
				String strPeriodStdt = reportSearchReceivableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchReceivableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");

				List<String> arrLstmCd = null;
	            arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getLstmCd(),",","|"));

				List<String> arrCntrTpszCd = null;
	            arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getCntrTpszCd(),",","|"));

	            List<String> arrChargeTypeCd = null;
	            arrChargeTypeCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getChargeTypeCd(),",","|"));

	            param.put("report_type"       , reportSearchReceivableVO.getReportType());
	            param.put("period_stdt"       , strPeriodStdt);
	            param.put("period_eddt"       , strPeriodEddt);
	            param.put("period_year"       , reportSearchReceivableVO.getPeriodYear());
	            param.put("company"           , reportSearchReceivableVO.getCompany());
	            param.put("status"            , reportSearchReceivableVO.getStatus());
	            param.put("receivable"        , reportSearchReceivableVO.getReceivable());
	            param.put("agmt_cty_cd"       , reportSearchReceivableVO.getAgmtCtyCd());
	            param.put("agmt_seq"          , reportSearchReceivableVO.getAgmtSeq());
	            param.put("vndr_seq"          , reportSearchReceivableVO.getVndrSeq());
	            param.put("loc_tp"            , reportSearchReceivableVO.getLocTp());
	            param.put("loc_cd"            , reportSearchReceivableVO.getLocCd());

	            velParam.put("report_type"    , reportSearchReceivableVO.getReportType());
	            velParam.put("period_stdt"    , strPeriodStdt);
	            velParam.put("period_eddt"    , strPeriodEddt);
	            velParam.put("period_year"    , reportSearchReceivableVO.getPeriodYear());
	            velParam.put("company"        , reportSearchReceivableVO.getCompany());
	            velParam.put("status"         , reportSearchReceivableVO.getStatus());
	            velParam.put("receivable"     , reportSearchReceivableVO.getReceivable());
	            velParam.put("agmt_cty_cd"    , reportSearchReceivableVO.getAgmtCtyCd());
	            velParam.put("agmt_seq"       , reportSearchReceivableVO.getAgmtSeq());
	            velParam.put("vndr_seq"       , reportSearchReceivableVO.getVndrSeq());
	            velParam.put("loc_tp"         , reportSearchReceivableVO.getLocTp());
	            velParam.put("loc_cd"         , reportSearchReceivableVO.getLocCd());
	            velParam.put("lstm_cd"            , arrLstmCd);
	            velParam.put("lstm_cd_str"        , reportSearchReceivableVO.getLstmCd());
	            velParam.put("cntr_tpsz_cd"       , arrCntrTpszCd);
	            velParam.put("cntr_tpsz_cd_str"   , reportSearchReceivableVO.getCntrTpszCd());
	            velParam.put("charge_type_cd"     , arrChargeTypeCd);
	            velParam.put("charge_type_cd_str" , reportSearchReceivableVO.getChargeTypeCd());

			}
			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOsearchReceivableRentalReportByLessorMonthRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchReceivableVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Receivable Invoice 한 결과에 대하여 Charge Type별로 실적을 조회<br>
	 *
	 * @param  ReportSearchReceivableVO reportSearchReceivableVO
	 * @return List<ReportSearchReceivableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings( "unchecked")
	public List<ReportSearchReceivableVO> searchReceivablebyLessorMonthReportData(ReportSearchReceivableVO reportSearchReceivableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchReceivableVO> list = new ArrayList<ReportSearchReceivableVO>();
		ReportSearchReceivableVO rsVo = new ReportSearchReceivableVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(reportSearchReceivableVO != null){
				String strPeriodStdt = reportSearchReceivableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchReceivableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");

				List<String> arrLstmCd = null;
	            arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getLstmCd(),",","|"));

				List<String> arrCntrTpszCd = null;
	            arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getCntrTpszCd(),",","|"));

	            List<String> arrTysz   = null;
                arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchReceivableVO.getTysz(),",","|"));

                param.put("period_stdt"         , strPeriodStdt);
	            param.put("period_eddt"         , strPeriodEddt);
	            param.put("company"             , reportSearchReceivableVO.getCompany());
	            param.put("receivable"          , reportSearchReceivableVO.getReceivable());
	            param.put("status"              , reportSearchReceivableVO.getStatus());
	            param.put("agmt_cty_cd"         , reportSearchReceivableVO.getAgmtCtyCd());
	            param.put("agmt_seq"            , reportSearchReceivableVO.getAgmtSeq());
	            param.put("vndr_seq"            , reportSearchReceivableVO.getVndrSeq());
	            param.put("loc_tp"              , reportSearchReceivableVO.getLocTp());
	            param.put("loc_cd"              , reportSearchReceivableVO.getLocCd());
	            param.put("tysz"                , arrTysz);

	            velParam.put("period_stdt"      , strPeriodStdt);
	            velParam.put("period_eddt"      , strPeriodEddt);
	            velParam.put("company"          , reportSearchReceivableVO.getCompany());
	            velParam.put("receivable"       , reportSearchReceivableVO.getReceivable());
	            velParam.put("status"           , reportSearchReceivableVO.getStatus());
	            velParam.put("agmt_cty_cd"      , reportSearchReceivableVO.getAgmtCtyCd());
	            velParam.put("agmt_seq"         , reportSearchReceivableVO.getAgmtSeq());
	            velParam.put("vndr_seq"         , reportSearchReceivableVO.getVndrSeq());
	            velParam.put("loc_tp"           , reportSearchReceivableVO.getLocTp());
	            velParam.put("loc_cd"           , reportSearchReceivableVO.getLocCd());
	            velParam.put("lstm_cd"          , arrLstmCd);
	            velParam.put("lstm_cd_str"      , reportSearchReceivableVO.getLstmCd());
	            velParam.put("cntr_tpsz_cd"     , arrCntrTpszCd);
	            velParam.put("cntr_tpsz_cd_str" , reportSearchReceivableVO.getCntrTpszCd());
	            velParam.put("tysz"             , arrTysz);
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOsearchReceivablebyLessorMonthReportDataRSQL(), param, velParam);
			if( reportSearchReceivableVO.getReportType() != "" )
				rsVo.setReportType(reportSearchReceivableVO.getReportType());
			if(reportSearchReceivableVO.getTysz() != "")
				rsVo.setTysz(reportSearchReceivableVO.getTysz());
			rsVo.setDbRowset(dbRowset);
			
			list.add(rsVo);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 입력 월에 대한 Receivable Rental Charge 작업 현황목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableChargeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReceivableChargeVO> searchReceivableRentalChargeListData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<ReceivableChargeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOReceivableRentalChargeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceivableChargeVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 입력 월에 대한 Receivable Rental Preparation 일괄작업을 수행합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addReceivableRentalPreparationListData(SearchParamVO searchParamVO) throws DAOException, Exception {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new ReceivableRentalCostDBDAOReceivableRentalPreparationListCSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 계약번호별 Receivable Rental Charge Creation 작업대상 장비목록을 조회합니다.<br>
	 *
	 * @param  ReceivableChargeVO receivableChargeVO
	 * @return List<ReceivableChargeDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReceivableChargeDetailVO> searchReceivableRentalChargeDetailListData(ReceivableChargeVO receivableChargeVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<ReceivableChargeDetailVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(receivableChargeVO != null){
				 Map<String, String> mapVO = receivableChargeVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }

			 dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOReceivableRentalChargeDetailListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceivableChargeDetailVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

		 return list;
	}

	/**
	 * 장비번호별 Receivable Rental Charge Detail Creation 자료를 생성합니다.<br>
	 *
	 * @param  ReceivableChargeDetailVO receivableChargeDetailVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addReceivableRentalChargeDetailData(ReceivableChargeDetailVO receivableChargeDetailVO) throws DAOException, Exception {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(receivableChargeDetailVO != null){
				Map<String, String> mapVO = receivableChargeDetailVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new ReceivableRentalCostDBDAOReceivableRentalChargeDetailCSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 계약번호별 Receivable Rental Charge Creation 자료를 개별 생성합니다.<br>
	 *
	 * @param  ReceivableChargeVO receivableChargeVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addReceivableRentalChargeData(ReceivableChargeVO receivableChargeVO) throws DAOException, Exception {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(receivableChargeVO != null){
				Map<String, String> mapVO = receivableChargeVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new ReceivableRentalCostDBDAOReceivableRentalChargeCSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 계약번호별 Receivable Rental Charge Creation 자료를 개별 갱신합니다.<br>
	 *
	 * @param  ReceivableChargeVO receivableChargeVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyReceivableRentalChargeData(ReceivableChargeVO receivableChargeVO) throws DAOException, Exception {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(receivableChargeVO != null){
				Map<String, String> mapVO = receivableChargeVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new ReceivableRentalCostDBDAOReceivableRentalChargeUSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 장비번호별 Receivable Rental Charge Detail Creation 자료를 삭제합니다.<br>
	 *
	 * @param  ReceivableChargeVO receivableChargeVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeReceivableRentalChargeDetailListData(ReceivableChargeVO receivableChargeVO) throws DAOException, Exception {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(receivableChargeVO != null){
				Map<String, String> mapVO = receivableChargeVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new ReceivableRentalCostDBDAOReceivableRentalChargeDetailListDSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Receivable Rental Charge Creation 처리된 내역을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableChargeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReceivableChargeVO> searchReceivableRentalChargeInfoData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<ReceivableChargeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOReceivableRentalChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceivableChargeVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 신규 Receivable Rental Invoice Number를 조회합니다.<br>
	 *
	 * @param  String qtyYrmon
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchNewReceivableInvoiceNumberData(String qtyYrmon) throws DAOException {
		String invoiceNo = "";
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
	    	param.put("qty_yrmon", qtyYrmon);
			velParam.put("qty_yrmon", qtyYrmon);

			dbRowset = new SQLExecuter().executeQuery(new ReceivableRentalCostDBDAONewReceivableInvoiceNumberRSQL(), param, velParam);
			if(dbRowset.next()) {
				invoiceNo = dbRowset.getString("INV_NO");
	    	}
	    } catch(SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

		return invoiceNo;
	}

	/**
	 * 입력받은 AGMT No.에 대한 Receivable Charge 허용여부를 조회합니다.<br>
	 *
	 * @param  String agmtSeq
	 * @param  String qtyYrmon
	 * @return List<ReceivableChargeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReceivableChargeVO> searchReceivableAgreementAvailInfoData(String agmtSeq, String qtyYrmon) throws DAOException {

		DBRowSet dbRowset = null;
		List<ReceivableChargeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
	    	param.put("agmt_seq", agmtSeq);
	    	param.put("qty_yrmon", qtyYrmon);
			velParam.put("agmt_seq", agmtSeq);
			velParam.put("qty_yrmon", qtyYrmon);

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOReceivableAgreementAvailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceivableChargeVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Receivable Rental Invoice Summary 내역을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReceivableInvoiceVO> searchReceivableInvoiceSummaryListData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<ReceivableInvoiceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);

		        List<String> arrRcvRntlSeq  = null;
		        if ( !JSPUtil.getNull(searchParamVO.getRcvRntlSeq()).equals("") ) {
		        	arrRcvRntlSeq = JSPUtil.convertStringToArrayList(searchParamVO.getRcvRntlSeq());
					param.put("rcv_rntl_no_seq", arrRcvRntlSeq);
					velParam.put("rcv_rntl_no_seq", arrRcvRntlSeq);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOReceivableInvoiceSummaryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceivableInvoiceVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Receivable Rental Invoice Amount 정보를 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReceivableInvoiceVO> searchReceivableInvoiceAmountInfoData(SearchParamVO searchParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReceivableInvoiceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOReceivableInvoiceAmountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceivableInvoiceVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Invoice 자료의 AR Interface Main 정보를 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return InvArIfMnVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public InvArIfMnVO searchGeneralARInterfaceInvoiceInfoData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		InvArIfMnVO info = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);

		        List<String> arrRcvRntlSeq  = null;
		        if ( !JSPUtil.getNull(searchParamVO.getRcvRntlSeq()).equals("") ) {
		        	arrRcvRntlSeq = JSPUtil.convertStringToArrayList(searchParamVO.getRcvRntlSeq());
					param.put("rcv_rntl_no_seq", arrRcvRntlSeq);
					velParam.put("rcv_rntl_no_seq", arrRcvRntlSeq);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOARInterfaceInvoiceInfoRSQL(), param, velParam);
			List<InvArIfMnVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfMnVO .class);
			info = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return info;
	}

	/**
	 * Invoice 자료의 AR Interface Charge 정보를 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<InvArIfChgVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvArIfChgVO> searchGeneralARInterfaceChargeListData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<InvArIfChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOARInterfaceChargeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfChgVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Invoice 자료의 AR Interface Container 정보를 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<InvArIfCntrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvArIfCntrVO> searchGeneralARInterfaceContainersData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<InvArIfCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);

		        List<String> arrRcvRntlSeq  = null;
		        if ( !JSPUtil.getNull(searchParamVO.getRcvRntlSeq()).equals("") ) {
		        	arrRcvRntlSeq = JSPUtil.convertStringToArrayList(searchParamVO.getRcvRntlSeq());
					param.put("rcv_rntl_no_seq", arrRcvRntlSeq);
					velParam.put("rcv_rntl_no_seq", arrRcvRntlSeq);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOARInterfaceContainerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfCntrVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 계약번호별 Receivable Rental Invoice Creation 자료를 갱신합니다.<br>
	 *
	 * @param  ReceivableInvoiceVO receivableInvoiceVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyReceivableRentalInvoiceData(ReceivableInvoiceVO receivableInvoiceVO) throws DAOException, Exception {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(receivableInvoiceVO != null){
				Map<String, String> mapVO = receivableInvoiceVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new ReceivableRentalCostDBDAOReceivableRentalInvoiceUSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return trxCnt;
	}

	/**
	 * Receivable Rental Invoice Cost 목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceCostVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReceivableInvoiceCostVO> searchReceivableInvoiceCostListData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<ReceivableInvoiceCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);

		        List<String> arrRcvRntlSeq  = null;
		        if ( !JSPUtil.getNull(searchParamVO.getRcvRntlSeq()).equals("") ) {
		        	arrRcvRntlSeq = JSPUtil.convertStringToArrayList(searchParamVO.getRcvRntlSeq());
					param.put("rcv_rntl_no_seq", arrRcvRntlSeq);
					velParam.put("rcv_rntl_no_seq", arrRcvRntlSeq);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOReceivableInvoiceCostListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceivableInvoiceCostVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Receivable Rental Invoice Cost 내역을 생성합니다.<br>
	 *
	 * @param  ReceivableInvoiceCostVO receivableInvoiceCostVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addReceivableInvoiceCostData(ReceivableInvoiceCostVO receivableInvoiceCostVO) throws DAOException, Exception {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(receivableInvoiceCostVO != null){
				Map<String, String> mapVO = receivableInvoiceCostVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new ReceivableRentalCostDBDAOReceivableInvoiceCostCSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Receivable Rental Invoice Cost 내역을 갱신합니다.<br>
	 *
	 * @param  ReceivableInvoiceCostVO receivableInvoiceCostVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyReceivableInvoiceCostData(ReceivableInvoiceCostVO receivableInvoiceCostVO) throws DAOException, Exception {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(receivableInvoiceCostVO != null){
				Map<String, String> mapVO = receivableInvoiceCostVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new ReceivableRentalCostDBDAOReceivableInvoiceCostUSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Receivable Rental Invoice Charge I/F 현황을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReceivableInvoiceInquiryVO> searchReceivableInvoiceInquiryListData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<ReceivableInvoiceInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOReceivableInvoiceInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceivableInvoiceInquiryVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Invoice Cancel 자료의 AR Interface Main 정보를 조회합니다.<br>
	 *
	 * @param  ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO
	 * @return InvArIfMnVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public InvArIfMnVO searchGeneralARInterfaceInvoiceCancelData(ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO) throws DAOException {

		DBRowSet dbRowset = null;
		InvArIfMnVO info = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(receivableInvoiceInquiryVO != null){
				Map<String, String> mapVO = receivableInvoiceInquiryVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOARInterfaceInvoiceCancelRSQL(), param, velParam);
			List<InvArIfMnVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfMnVO .class);
			info = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return info;
	}

	/**
	 * Invoice Cancel 자료의 AR Interface Charge 정보를 조회합니다.<br>
	 *
	 * @param  ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO
	 * @return List<InvArIfChgVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvArIfChgVO> searchGeneralARInterfaceChargeCancelData(ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<InvArIfChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(receivableInvoiceInquiryVO != null){
				Map<String, String> mapVO = receivableInvoiceInquiryVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOARInterfaceChargeCancelRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfChgVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Invoice Cancel 자료의 AR Interface Container 정보를 조회합니다.<br>
	 *
	 * @param  ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO
	 * @return List<InvArIfCntrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvArIfCntrVO> searchGeneralARInterfaceContainersCancelData(ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<InvArIfCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(receivableInvoiceInquiryVO != null){
				Map<String, String> mapVO = receivableInvoiceInquiryVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(new ReceivableRentalCostDBDAOARInterfaceContainerCancelRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfCntrVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Receivable Rental Invoice Charge I/F 처리내역을 취소합니다.<br>
	 *
	 * @param  ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyReceivableInvoiceCancelData(ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO) throws DAOException, Exception {
		int trxCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(receivableInvoiceInquiryVO != null){
				Map<String, String> mapVO = receivableInvoiceInquiryVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			trxCnt = sqlExe.executeUpdate(new ReceivableRentalCostDBDAOReceivableInvoiceCancelUSQL(), param, velParam);

			if(trxCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}