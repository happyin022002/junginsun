/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostDBDAO.java
*@FileTitle : EQ Payable Charge Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.25 진준성
* 1.0 Creation
* =======================================================
* 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic.PayableRentalCostBCImpl;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditSearchVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostCreatVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostInvoiceCreateVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostOperationalInvoiceVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalInvoiceCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.ReportSearchPayableVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.StringUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.LsePayRntlChgCoVO;
import com.hanjin.syscommon.common.table.LsePayRntlChgDtlVO;

/**
 * ALPS PayableRentalCostDBDAO <br>
 * - ALPS-ContainerRentalCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jin Jun Sung
 * @see PayableRentalCostBCImpl 참조
 * @since J2EE 1.6
 */
public class PayableRentalCostDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Payable Invoice 한 결과에 대하여 Charge Type별로 실적을 조회<br>
	 * 
	 * @param  ReportSearchPayableVO reportSearchPayableVO
	 * @return List<ReportSearchPayableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportSearchPayableVO> searchPayableRentalReportByChargeTypeData(ReportSearchPayableVO reportSearchPayableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchPayableVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(reportSearchPayableVO != null){
												
		    	String strPeriodStdt = reportSearchPayableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchPayableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");
				
				List<String> arrLstmCd = null;
		        arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getLstmCd(),",","|"));
				
				List<String> arrCntrTpszCd = null;
		        arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getCntrTpszCd(),",","|"));

		        List<String> arrChargeTypeCd = null;
		        arrChargeTypeCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getChargeTypeCd(),",","|"));
					            
		        param.put("report_type"       , reportSearchPayableVO.getReportType());
		        param.put("period_stdt"       , strPeriodStdt);
		        param.put("period_eddt"       , strPeriodEddt);
		        param.put("period_year"       , reportSearchPayableVO.getPeriodYear());
		        param.put("company"           , reportSearchPayableVO.getCompany());
		        param.put("payable"           , reportSearchPayableVO.getPayable());
		        param.put("agmt_cty_cd"       , reportSearchPayableVO.getAgmtCtyCd());
		        param.put("agmt_seq"          , reportSearchPayableVO.getAgmtSeq());
		        param.put("vndr_seq"          , reportSearchPayableVO.getVndrSeq());
		        param.put("loc_tp"            , reportSearchPayableVO.getLocTp());
		        param.put("loc_cd"            , reportSearchPayableVO.getLocCd());
		           
		        velParam.put("report_type"    , reportSearchPayableVO.getReportType());
		        velParam.put("period_stdt"    , strPeriodStdt);
		        velParam.put("period_eddt"    , strPeriodEddt);
		        velParam.put("period_year"    , reportSearchPayableVO.getPeriodYear());
		        velParam.put("company"        , reportSearchPayableVO.getCompany());
		        velParam.put("payable"        , reportSearchPayableVO.getPayable());
		        velParam.put("agmt_cty_cd"    , reportSearchPayableVO.getAgmtCtyCd());
		        velParam.put("agmt_seq"       , reportSearchPayableVO.getAgmtSeq());
		        velParam.put("vndr_seq"       , reportSearchPayableVO.getVndrSeq());
		        velParam.put("loc_tp"         , reportSearchPayableVO.getLocTp());
		        velParam.put("loc_cd"         , reportSearchPayableVO.getLocCd());
		        velParam.put("lstm_cd"            , arrLstmCd);
		        velParam.put("lstm_cd_str"        , reportSearchPayableVO.getLstmCd());
		        velParam.put("cntr_tpsz_cd"       , arrCntrTpszCd);
		        velParam.put("cntr_tpsz_cd_str"   , reportSearchPayableVO.getCntrTpszCd());
		        velParam.put("charge_type_cd"     , arrChargeTypeCd);
		        velParam.put("charge_type_cd_str" , reportSearchPayableVO.getChargeTypeCd());
			}
			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOsearchPayableRentalReportByChargeTypeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchPayableVO .class);
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
	 * Payable Invoice 한 결과에 대하여 TP/SZ별로 실적을 조회<br>
	 * 
	 * @param  ReportSearchPayableVO reportSearchPayableVO
	 * @return List<ReportSearchPayableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportSearchPayableVO> searchPayableRentalReportByTySzData(ReportSearchPayableVO reportSearchPayableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchPayableVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(reportSearchPayableVO != null){
												
		    	String strPeriodStdt = reportSearchPayableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchPayableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");
				
				List<String> arrLstmCd = null;
		        arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getLstmCd(),",","|"));
				
				List<String> arrCntrTpszCd = null;
		        arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getCntrTpszCd(),",","|"));
		        List<String> arrChargeTypeCd = null;
		        arrChargeTypeCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getChargeTypeCd(),",","|"));
					            
		        param.put("report_type"       , reportSearchPayableVO.getReportType());
		        param.put("period_stdt"       , strPeriodStdt);
		        param.put("period_eddt"       , strPeriodEddt);
		        param.put("period_year"       , reportSearchPayableVO.getPeriodYear());
		        param.put("company"           , reportSearchPayableVO.getCompany());
		        param.put("payable"           , reportSearchPayableVO.getPayable());
		        param.put("agmt_cty_cd"       , reportSearchPayableVO.getAgmtCtyCd());
		        param.put("agmt_seq"          , reportSearchPayableVO.getAgmtSeq());
		        param.put("vndr_seq"          , reportSearchPayableVO.getVndrSeq());
		        param.put("loc_tp"            , reportSearchPayableVO.getLocTp());
		        param.put("loc_cd"            , reportSearchPayableVO.getLocCd());
		           
		        velParam.put("report_type"    , reportSearchPayableVO.getReportType());
		        velParam.put("period_stdt"    , strPeriodStdt);
		        velParam.put("period_eddt"    , strPeriodEddt);
		        velParam.put("period_year"    , reportSearchPayableVO.getPeriodYear());
		        velParam.put("company"        , reportSearchPayableVO.getCompany());
		        velParam.put("payable"        , reportSearchPayableVO.getPayable());
		        velParam.put("agmt_cty_cd"    , reportSearchPayableVO.getAgmtCtyCd());
		        velParam.put("agmt_seq"       , reportSearchPayableVO.getAgmtSeq());
		        velParam.put("vndr_seq"       , reportSearchPayableVO.getVndrSeq());
		        velParam.put("loc_tp"         , reportSearchPayableVO.getLocTp());
		        velParam.put("loc_cd"         , reportSearchPayableVO.getLocCd());
		        velParam.put("lstm_cd"            , arrLstmCd);
		        velParam.put("lstm_cd_str"        , reportSearchPayableVO.getLstmCd());
		        velParam.put("cntr_tpsz_cd"       , arrCntrTpszCd);
		        velParam.put("cntr_tpsz_cd_str"   , reportSearchPayableVO.getCntrTpszCd());
		        velParam.put("charge_type_cd"     , arrChargeTypeCd);
		        velParam.put("charge_type_cd_str" , reportSearchPayableVO.getChargeTypeCd());
			}
			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOsearchPayableRentalReportByTySzRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchPayableVO .class);
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
	 * Payable Invoice 한 결과에 대하여 Charge Type , TP/SZ별로 실적을 조회<br>
	 * 
	 * @param  ReportSearchPayableVO reportSearchPayableVO
	 * @return List<ReportSearchPayableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings( "unchecked")
	public List<ReportSearchPayableVO> searchPayableRentalReportByChargeTypeTySzData(ReportSearchPayableVO reportSearchPayableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchPayableVO> list = new ArrayList<ReportSearchPayableVO>();
		ReportSearchPayableVO rsVo = new ReportSearchPayableVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(reportSearchPayableVO != null){
												
		    	String strPeriodStdt = reportSearchPayableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchPayableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");
				
				List<String> arrLstmCd = null;
		        arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getLstmCd(),",","|"));
				
				List<String> arrCntrTpszCd = null;
		        arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getCntrTpszCd(),",","|"));
		        
		        List<String> arrChargeTypeCd = null;
		        arrChargeTypeCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getChargeTypeCd(),",","|"));
				
		        List<String> arrTysz   = null;
                arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getTysz(),",","|"));
		        
		        param.put("report_type"       , reportSearchPayableVO.getReportType());
		        param.put("period_stdt"       , strPeriodStdt);
		        param.put("period_eddt"       , strPeriodEddt);
		        param.put("period_year"       , reportSearchPayableVO.getPeriodYear());
		        param.put("company"           , reportSearchPayableVO.getCompany());
		        param.put("payable"           , reportSearchPayableVO.getPayable());
		        param.put("agmt_cty_cd"       , reportSearchPayableVO.getAgmtCtyCd());
		        param.put("agmt_seq"          , reportSearchPayableVO.getAgmtSeq());
		        param.put("vndr_seq"          , reportSearchPayableVO.getVndrSeq());
		        param.put("loc_tp"            , reportSearchPayableVO.getLocTp());
		        param.put("loc_cd"            , reportSearchPayableVO.getLocCd());
		        param.put("tysz"              , arrTysz);
		        
		        velParam.put("report_type"    , reportSearchPayableVO.getReportType());
		        velParam.put("period_stdt"    , strPeriodStdt);
		        velParam.put("period_eddt"    , strPeriodEddt);
		        velParam.put("period_year"    , reportSearchPayableVO.getPeriodYear());
		        velParam.put("company"        , reportSearchPayableVO.getCompany());
		        velParam.put("payable"        , reportSearchPayableVO.getPayable());
		        velParam.put("agmt_cty_cd"    , reportSearchPayableVO.getAgmtCtyCd());
		        velParam.put("agmt_seq"       , reportSearchPayableVO.getAgmtSeq());
		        velParam.put("vndr_seq"       , reportSearchPayableVO.getVndrSeq());
		        velParam.put("loc_tp"         , reportSearchPayableVO.getLocTp());
		        velParam.put("loc_cd"         , reportSearchPayableVO.getLocCd());
		        velParam.put("lstm_cd"            , arrLstmCd);
		        velParam.put("lstm_cd_str"        , reportSearchPayableVO.getLstmCd());
		        velParam.put("cntr_tpsz_cd"       , arrCntrTpszCd);
		        velParam.put("cntr_tpsz_cd_str"   , reportSearchPayableVO.getCntrTpszCd());
		        velParam.put("charge_type_cd"     , arrChargeTypeCd);
		        velParam.put("charge_type_cd_str" , reportSearchPayableVO.getChargeTypeCd());
		        velParam.put("tysz"               , arrTysz);
			}
			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOsearchPayableRentalReportByChargeTypeTySzRSQL(), param, velParam);
			if(reportSearchPayableVO.getReportType() != "")
				rsVo.setReportType(reportSearchPayableVO.getReportType());
			if(reportSearchPayableVO.getTysz() != "")
				rsVo.setTysz(reportSearchPayableVO.getTysz());
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
	 * Payable Invoice 한 결과에 대하여 Lease Term ,  Month 별로 실적을 조회<br>
	 * 
	 * @param  ReportSearchPayableVO reportSearchPayableVO
	 * @return List<ReportSearchPayableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportSearchPayableVO> searchPayableRentalReportByLeaseTermMonthData(ReportSearchPayableVO reportSearchPayableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchPayableVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(reportSearchPayableVO != null){
												
		    	String strPeriodStdt = reportSearchPayableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchPayableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");
				
				List<String> arrLstmCd = null;
		        arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getLstmCd(),",","|"));
				
				List<String> arrCntrTpszCd = null;
		        arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getCntrTpszCd(),",","|"));
		        List<String> arrChargeTypeCd = null;
		        arrChargeTypeCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getChargeTypeCd(),",","|"));
					            
		        param.put("report_type"       , reportSearchPayableVO.getReportType());
		        param.put("period_stdt"       , strPeriodStdt);
		        param.put("period_eddt"       , strPeriodEddt);
		        param.put("period_year"       , reportSearchPayableVO.getPeriodYear());
		        param.put("company"           , reportSearchPayableVO.getCompany());
		        param.put("payable"           , reportSearchPayableVO.getPayable());
		        param.put("agmt_cty_cd"       , reportSearchPayableVO.getAgmtCtyCd());
		        param.put("agmt_seq"          , reportSearchPayableVO.getAgmtSeq());
		        param.put("vndr_seq"          , reportSearchPayableVO.getVndrSeq());
		        param.put("loc_tp"            , reportSearchPayableVO.getLocTp());
		        param.put("loc_cd"            , reportSearchPayableVO.getLocCd());
		           
		        velParam.put("report_type"    , reportSearchPayableVO.getReportType());
		        velParam.put("period_stdt"    , strPeriodStdt);
		        velParam.put("period_eddt"    , strPeriodEddt);
		        velParam.put("period_year"    , reportSearchPayableVO.getPeriodYear());
		        velParam.put("company"        , reportSearchPayableVO.getCompany());
		        velParam.put("payable"        , reportSearchPayableVO.getPayable());
		        velParam.put("agmt_cty_cd"    , reportSearchPayableVO.getAgmtCtyCd());
		        velParam.put("agmt_seq"       , reportSearchPayableVO.getAgmtSeq());
		        velParam.put("vndr_seq"       , reportSearchPayableVO.getVndrSeq());
		        velParam.put("loc_tp"         , reportSearchPayableVO.getLocTp());
		        velParam.put("loc_cd"         , reportSearchPayableVO.getLocCd());
		        velParam.put("lstm_cd"            , arrLstmCd);
		        velParam.put("lstm_cd_str"        , reportSearchPayableVO.getLstmCd());
		        velParam.put("cntr_tpsz_cd"       , arrCntrTpszCd);
		        velParam.put("cntr_tpsz_cd_str"   , reportSearchPayableVO.getCntrTpszCd());
		        velParam.put("charge_type_cd"     , arrChargeTypeCd);
		        velParam.put("charge_type_cd_str" , reportSearchPayableVO.getChargeTypeCd());
			}
			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOsearchPayableRentalReportByLeaseTermMonthRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchPayableVO .class);
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
	 * Payable Invoice 한 결과에 대하여 Lessor ,  Month 별로 실적을 조회<br>
	 * 
	 * @param  ReportSearchPayableVO reportSearchPayableVO
	 * @return List<ReportSearchPayableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportSearchPayableVO> searchPayableRentalReportByLessorMonthData(ReportSearchPayableVO reportSearchPayableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchPayableVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(reportSearchPayableVO != null){
												
		    	String strPeriodStdt = reportSearchPayableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchPayableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");
				
				List<String> arrLstmCd = null;
		        arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getLstmCd(),",","|"));
				
				List<String> arrCntrTpszCd = null;
		        arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getCntrTpszCd(),",","|"));
		        List<String> arrChargeTypeCd = null;
		        arrChargeTypeCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getChargeTypeCd(),",","|"));
					            
		        param.put("report_type"       , reportSearchPayableVO.getReportType());
		        param.put("period_stdt"       , strPeriodStdt);
		        param.put("period_eddt"       , strPeriodEddt);
		        param.put("period_year"       , reportSearchPayableVO.getPeriodYear());
		        param.put("company"           , reportSearchPayableVO.getCompany());
		        param.put("payable"           , reportSearchPayableVO.getPayable());
		        param.put("agmt_cty_cd"       , reportSearchPayableVO.getAgmtCtyCd());
		        param.put("agmt_seq"          , reportSearchPayableVO.getAgmtSeq());
		        param.put("vndr_seq"          , reportSearchPayableVO.getVndrSeq());
		        param.put("loc_tp"            , reportSearchPayableVO.getLocTp());
		        param.put("loc_cd"            , reportSearchPayableVO.getLocCd());
		           
		        velParam.put("report_type"    , reportSearchPayableVO.getReportType());
		        velParam.put("period_stdt"    , strPeriodStdt);
		        velParam.put("period_eddt"    , strPeriodEddt);
		        velParam.put("period_year"    , reportSearchPayableVO.getPeriodYear());
		        velParam.put("company"        , reportSearchPayableVO.getCompany());
		        velParam.put("payable"        , reportSearchPayableVO.getPayable());
		        velParam.put("agmt_cty_cd"    , reportSearchPayableVO.getAgmtCtyCd());
		        velParam.put("agmt_seq"       , reportSearchPayableVO.getAgmtSeq());
		        velParam.put("vndr_seq"       , reportSearchPayableVO.getVndrSeq());
		        velParam.put("loc_tp"         , reportSearchPayableVO.getLocTp());
		        velParam.put("loc_cd"         , reportSearchPayableVO.getLocCd());
		        velParam.put("lstm_cd"            , arrLstmCd);
		        velParam.put("lstm_cd_str"        , reportSearchPayableVO.getLstmCd());
		        velParam.put("cntr_tpsz_cd"       , arrCntrTpszCd);
		        velParam.put("cntr_tpsz_cd_str"   , reportSearchPayableVO.getCntrTpszCd());
		        velParam.put("charge_type_cd"     , arrChargeTypeCd);
		        velParam.put("charge_type_cd_str" , reportSearchPayableVO.getChargeTypeCd());
			}
			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOsearchPayableRentalReportByLessorMonthRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchPayableVO .class);
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
	 * Payable Rental Lessor Invoice 의 Lease Agreement No. 갯수 조회<br>
	 * 
	 * @param  String ctrtNo
	 * @return String[]
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String[] searchAgreementNoByCtrtNoData(String ctrtNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgreementVO> list = null;
		String[] result = new String[2];;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("lse_ctrt_no", ctrtNo);;

			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOLessorInvoiceFileImportAgreementNoByCtrtNoRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementVO.class);

			if ( list.size() < 1 ) {
				result[0] = "0";
				result[1] = "";
			} else if ( list.size() > 1 ) {
				result[0] = "2";
				result[1] = "";
			} else if ( list.size() == 1 ) {
				result[0] = "1";
				result[1] = (list.get(0)).getAgmtNo();
			} else {
				result[0] = "3";
				result[1] = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	/**
	 * Payable Rental Lessor Invoice Max Sequence [LSE_PAY_RNTL_CHG_CO] 조회<br>
	 * 
	 * @param  String coCostYrmon
	 * @return String
	 * @throws DAOException
	 */
	public String searchNewPayImpSeqData(String coCostYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("co_cost_yrmon", coCostYrmon);;
			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOLessorInvoiceFileImportNewPayImpSeqRSQL(), param, param);
		if ( dbRowset.next() ) {
				result = dbRowset.getString("MAX_PAY_IMP_SEQ");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Payable Rental Charge Audit 여부 [LSE_PAY_RNTL_CHG] 조회<br>
	 * 
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  String chgCostYrmon
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchPayableRentalChargeHeaderData(String agmtCtyCd, String agmtSeq, String chgCostYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("agmt_cty_cd",    agmtCtyCd);
			param.put("agmt_seq",       agmtSeq);
			param.put("chg_cost_yrmon", chgCostYrmon);

			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOLessorInvoiceFileImportAuditRSQL(), param, param);
			if ( dbRowset.next() ) {
				if ( Integer.parseInt(dbRowset.getString("CNT")) > 0 ) {
					result = true;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Payable Rental Lessor Invoice File Import [LSE_PAY_RNTL_CHG_CO] 데이터 생성<br>
	 * 
	 * @param  PayableRentalCostVO payableRentalCostVO
	 * @throws DAOException
	 */
	public void addPayableLessorInvoiceImportData(PayableRentalCostVO payableRentalCostVO) throws DAOException {
		try {
			List<LsePayRntlChgCoVO> insModels = payableRentalCostVO.getLsePayRntlChgCoVOs();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if ( insModels.size() > 0 ) {
				insCnt = sqlExe.executeBatch(new PayableRentalCostDBDAOLessorInvoiceFileImportCSQL(), insModels, null);
				for ( int i = 0 ; i < insCnt.length ; i++ ) {
					if(insCnt[i]== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Lessor Invoice File Import [LSE_PAY_RNTL_CHG_CO] 데이터 수정<br>
	 * 
	 * @param  List<LsePayRntlChgCoVO> updModels
	 * @throws DAOException
	 */
	public void modifyPayableLessorInvoiceImportData(List<LsePayRntlChgCoVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if ( updModels.size() > 0 ) {
				insCnt = sqlExe.executeBatch(new PayableRentalCostDBDAOLessorInvoiceFileImportUSQL(), updModels, null);
				for ( int i = 0 ; i < insCnt.length ; i++ ) {
					if(insCnt[i]== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Lessor Invoice File Import [LSE_PAY_RNTL_CHG_CO] 데이터 수정<br>
	 * 
	 * @param  List<LsePayRntlChgCoVO> updModels
	 * @throws DAOException
	 */
	public void modifyPayableLessorInvoiceImportInitData(List<LsePayRntlChgCoVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if ( updModels.size() > 0 ) {
				insCnt = sqlExe.executeBatch(new PayableRentalCostDBDAOLessorInvoiceFileImportInitUSQL(), updModels, null);
				for ( int i = 0 ; i < insCnt.length ; i++ ) {
					if(insCnt[i]== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Lessor Invoice File Import [LSE_PAY_RNTL_CHG_CO] 데이터 삭제<br>
	 * 
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  String coCostYrmon
	 * @throws DAOException
	 */
	public void removePayableLessorInvoiceImportData(String agmtCtyCd, String agmtSeq, String coCostYrmon) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("agmt_cty_cd",   agmtCtyCd);
			param.put("agmt_seq",      agmtSeq);
			param.put("co_cost_yrmon", coCostYrmon);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOLessorInvoiceFileImportDSQL(), param, param);
				
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Lessor Invoice File Import [LSE_PAY_RNTL_CHG_CO] 데이터 조회<br>
	 * 
	 * @param  PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public PayableRentalCostVO searchPayableLessorInvoiceData(PayableRentalCostVO payableRentalCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<LsePayRntlChgCoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if ( payableRentalCostVO != null ) {
		        param.put("agmt_cty_cd"       , payableRentalCostVO.getAgmtCtyCd());
		        param.put("agmt_seq"          , payableRentalCostVO.getAgmtSeq());
		        param.put("co_cost_yrmon"     , payableRentalCostVO.getCoCostYrmon());
			}
			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOLessorInvoiceFileImportRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LsePayRntlChgCoVO .class);
			if(list.size() > 0)
				payableRentalCostVO.setLsePayRntlChgCoVOs(list);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return payableRentalCostVO;
	}
		
	/**
	 * Payable Invoice 한 결과에 대하여 Charge Type별로 실적을 조회<br>
	 * 
	 * @param  ReportSearchPayableVO reportSearchPayableVO
	 * @return List<ReportSearchPayableVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ReportSearchPayableVO> searchPayablebyLessorMonthReportData(ReportSearchPayableVO reportSearchPayableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportSearchPayableVO> list = new ArrayList<ReportSearchPayableVO>();
		ReportSearchPayableVO rsVo = new ReportSearchPayableVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(reportSearchPayableVO != null){
				String strPeriodStdt = reportSearchPayableVO.getPeriodStdt();
				strPeriodStdt = strPeriodStdt.replaceAll("-", "");
				String strPeriodEddt = reportSearchPayableVO.getPeriodEddt();
				strPeriodEddt = strPeriodEddt.replaceAll("-", "");

				List<String> arrLstmCd = null;
	            arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getLstmCd(),",","|"));

	            List<String> arrCntrTpszCd = null;
	            arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getCntrTpszCd(),",","|"));

	            List<String> arrTysz   = null;
                arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchPayableVO.getTysz(),",","|"));
		            
	            param.put("period_stdt"         , strPeriodStdt);
	            param.put("period_eddt"         , strPeriodEddt);
	            param.put("company"             , reportSearchPayableVO.getCompany());
		        param.put("payable"             , reportSearchPayableVO.getPayable());
	            param.put("agmt_cty_cd"         , reportSearchPayableVO.getAgmtCtyCd());
	            param.put("agmt_seq"            , reportSearchPayableVO.getAgmtSeq());
	            param.put("vndr_seq"            , reportSearchPayableVO.getVndrSeq());
	            param.put("loc_tp"              , reportSearchPayableVO.getLocTp());
	            param.put("loc_cd"              , reportSearchPayableVO.getLocCd());
	            param.put("tysz"                , arrTysz);
		            
	            velParam.put("period_stdt"      , strPeriodStdt);
	            velParam.put("period_eddt"      , strPeriodEddt);
	            velParam.put("company"          , reportSearchPayableVO.getCompany());
	            velParam.put("payable"          , reportSearchPayableVO.getPayable());
	            velParam.put("agmt_cty_cd"      , reportSearchPayableVO.getAgmtCtyCd());
	            velParam.put("agmt_seq"         , reportSearchPayableVO.getAgmtSeq());
	            velParam.put("vndr_seq"         , reportSearchPayableVO.getVndrSeq());
	            velParam.put("loc_tp"           , reportSearchPayableVO.getLocTp());
	            velParam.put("loc_cd"           , reportSearchPayableVO.getLocCd());
	            velParam.put("lstm_cd"          , arrLstmCd);
	            velParam.put("lstm_cd_str"      , reportSearchPayableVO.getLstmCd());
	            velParam.put("cntr_tpsz_cd"     , arrCntrTpszCd);
	            velParam.put("cntr_tpsz_cd_str" , reportSearchPayableVO.getCntrTpszCd());
	            velParam.put("tysz"             , arrTysz);
			}

			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOsearchPayablebyLessorMonthReportRSQL(), param, velParam);
			if(reportSearchPayableVO.getReportType() != "")
				rsVo.setReportType(reportSearchPayableVO.getReportType());
			if(reportSearchPayableVO.getTysz() != "")
				rsVo.setTysz(reportSearchPayableVO.getTysz());
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
	 * Payable Rental Charge Creation : Payable Charge Creation을 위한 대상 Agreement 조회<br>
	 * 
	 * @param  String costMonth
	 * @param  String lessorNo
	 * @param  String lstmCd
	 * @return PayableRentalCostVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public PayableRentalCostVO searchPayableRentalData(String costMonth, String lessorNo, String lstmCd) throws DAOException {
		DBRowSet dbRowset = null;
		PayableRentalCostVO resultVO = new PayableRentalCostVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("vndr_seq"  , lessorNo);
		    param.put("lstm_cd"   , lstmCd);
		    param.put("cost_yrmon", costMonth);

			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOPayableChargeCreationAgreementRSQL(), param, param);
			List<PayableRentalCostCreatVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, PayableRentalCostCreatVO.class);
			resultVO.setPayableRentalCostCreatVOs(list);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return resultVO;
	}

	/**
	 * Payable Rental Charge Creation : Payable Rental New Charge Sequence [LSE_PAY_RNTL_CHG] 조회<br>
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchNewChargeSequenceData() throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";

		try{
			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOPayableChargeCreationNewChargeSequenceRSQL(), null, null);
			if ( dbRowset.next() ) {
				result = dbRowset.getString("MAX_CHG_SEQ");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Payable Rental Charge Creation : Payable ChargeMaster [LSE_PAY_RNTL_CHG] 데이터 입력<br>
	 * 
	 * @param  PayableRentalCostVO payableRentalCostVO
	 * @throws DAOException
	 */
	public void addPayableRentalChargeMasterData(PayableRentalCostVO payableRentalCostVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("chg_seq",        payableRentalCostVO.getChgSeq());
			param.put("agmt_cty_cd",    payableRentalCostVO.getAgmtCtyCd());
			param.put("agmt_seq",       payableRentalCostVO.getAgmtSeq());
			param.put("chg_cost_yrmon", payableRentalCostVO.getChgCostYrmon());
			param.put("cre_ofc_cd",     payableRentalCostVO.getOfcCd());
			param.put("usr_id",         payableRentalCostVO.getUsrId());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeCreationMasterCSQL(), param, param);
				
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Charge Createion : Payable Charge Master [LSE_PAY_RNTL_CHG] 금액 및 invoice No 수정<br>
	 * 
	 * @param  PayableRentalCostVO payableRentalCostVO
	 * @throws DAOException
	 */
	public void modifyPayableRentalChargeMasterData(PayableRentalCostVO payableRentalCostVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("chg_seq",        payableRentalCostVO.getChgSeq());
			param.put("agmt_cty_cd",    payableRentalCostVO.getAgmtCtyCd());
			param.put("agmt_seq",       payableRentalCostVO.getAgmtSeq());
			param.put("chg_cost_yrmon", payableRentalCostVO.getChgCostYrmon());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeCreationMasterUSQL(), param, param);

			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Charge Createion : Payable Charge Master [LSE_PAY_RNTL_CHG] 데이터 삭제<br>
	 * 
	 * @param  PayableRentalCostVO payableRentalCostVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removePayableRentalChargeMasterData(PayableRentalCostVO payableRentalCostVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("chg_seq",     payableRentalCostVO.getChgSeq());
			param.put("agmt_cty_cd", payableRentalCostVO.getAgmtCtyCd());
			param.put("agmt_seq",    payableRentalCostVO.getAgmtSeq());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeCreationMasterDSQL(), param, param);
				
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Charge Createion : Payable Charge Detail 저장을 위한 대상 Data 조회<br>
	 * 
	 * @param  PayableRentalCostVO payableRentalCostVO
	 * @return List<LsePayRntlChgDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LsePayRntlChgDtlVO> searchPayableRentalChargeDetailData(PayableRentalCostVO payableRentalCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LsePayRntlChgDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("chg_cost_yrmon", payableRentalCostVO.getChgCostYrmon());
		    param.put("chg_seq",        payableRentalCostVO.getChgSeq());
		    param.put("agmt_cty_cd",    payableRentalCostVO.getAgmtCtyCd());
		    param.put("agmt_seq",       payableRentalCostVO.getAgmtSeq());
		    param.put("usr_id",         payableRentalCostVO.getUsrId());

			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOPayableChargeCreationDetailRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LsePayRntlChgDtlVO.class);
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
	 * Payable Rental Lessor Invoice File Import [LSE_PAY_RNTL_CHG_CO] 데이터 생성<br>
	 * 
	 * @param  LsePayRntlChgDtlVO lsePayRntlChgDtlVO
	 * @throws DAOException
	 */
	public void addPayableRentalChargeDetailData(LsePayRntlChgDtlVO lsePayRntlChgDtlVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = lsePayRntlChgDtlVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeCreationDetailCSQL(), param, param);
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Charge Createion : 기 생성된 Payable Charge Detail [LSE_PAY_RNTL_CHG_DTL] 데이터를 삭제<br>
	 * 
	 * @param  PayableRentalCostVO payableRentalCostVO
	 * @throws DAOException
	 */
	public void removePayableRentalChargeDetailData(PayableRentalCostVO payableRentalCostVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("chg_seq",     payableRentalCostVO.getChgSeq());
			param.put("agmt_cty_cd", payableRentalCostVO.getAgmtCtyCd());
			param.put("agmt_seq",    payableRentalCostVO.getAgmtSeq());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeCreationDetailDSQL(), param, param);
				
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Charge Createion : Payable Charge Master [LSE_PAY_RNTL_CHG] Invoice No 수정<br>
	 * 
	 * @param  String chgSeq
	 * @param  String chgCostYrmon
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  String invNo
	 * @param  String usrId
	 * @throws DAOException
	 */
	public void modifyPayableRentalChargeMasterInvoiceNoData(String chgSeq, String chgCostYrmon, String agmtCtyCd,
			                                                 String agmtSeq, String invNo, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("inv_no",         invNo);
			param.put("usr_id",         usrId);
			param.put("chg_seq",        chgSeq);
			param.put("chg_cost_yrmon", chgCostYrmon);
			param.put("agmt_cty_cd",    agmtCtyCd);
			param.put("agmt_seq",       agmtSeq);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeCreationMasterInvoiceNoUSQL(), param, param);
				
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Charge Createion : Audit 화면에서 Audit 대상 데이터 조회<br>
	 * 
	 * @param  PayableRentalCostVO payableRentalCostVO
	 * @return List<PayableRentalCostAuditVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PayableRentalCostAuditVO> searchPayableRentalAuditData(PayableRentalCostVO payableRentalCostVO) throws DAOException {
		PayableRentalCostAuditSearchVO searchVO = payableRentalCostVO.getPayableRentalCostAuditSearchVO();

		DBRowSet dbRowset = null;
		List<PayableRentalCostAuditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("co_cost_yrmon", StringUtil.replace(searchVO.getChgCostYrmon().trim(),"-",""));

			List<String> arrChgSeq  = null;
			List<String> arrAgmtSeq = null;

			if ( !JSPUtil.getNull(searchVO.getChgSeq()).equals("") ) {
				arrChgSeq = JSPUtil.convertStringToArrayList(searchVO.getChgSeq());
				param.put("chg_seq", arrChgSeq);
			}

			if ( !JSPUtil.getNull(searchVO.getAgmtSeq()).equals("") ) {
				arrAgmtSeq = JSPUtil.convertStringToArrayList(searchVO.getAgmtSeq());
				param.put("agmt_seq", arrAgmtSeq);
			}

			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOPayableChargeAuditRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PayableRentalCostAuditVO.class);
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
	 * Payable Rental Charge Createion : Audit 화면에서 Payable Charge Detail [LSE_PAY_RNTL_CHG_DTL]를 삭제<br>
	 * 
	 * @param  List<PayableRentalCostAuditVO> payableRentalCostAuditVOs
	 * @throws DAOException
	 */
	public void removePayableRentalAuditData(List<PayableRentalCostAuditVO> payableRentalCostAuditVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if ( payableRentalCostAuditVOs.size() > 0 ) {
				insCnt = sqlExe.executeBatch(new PayableRentalCostDBDAOPayableChargeAuditDSQL(), payableRentalCostAuditVOs, null);
				for ( int i = 0 ; i < insCnt.length ; i++ ) {
					if(insCnt[i]== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Charge Createion : Audit 화면에서 Payable Charge Detail [LSE_PAY_RNTL_CHG_DTL]를 Audit 완료 상태(A)로 수정<br>
	 * 
	 * @param  List<PayableRentalCostAuditVO> payableRentalCostAuditVOs
	 * @throws DAOException
	 */
	public void modifyPayableRentalAuditData(List<PayableRentalCostAuditVO> payableRentalCostAuditVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if ( payableRentalCostAuditVOs.size() > 0 ) {
				//log.debug("=========>>>>>>>>>>>>>>>>> payableRentalCostAuditVOs.get(0).getAgmtCtyCd()     : "+payableRentalCostAuditVOs.get(0).getAgmtCtyCd());
				//log.debug("=========>>>>>>>>>>>>>>>>> payableRentalCostAuditVOs.get(0).getAgmtSeq()       : "+payableRentalCostAuditVOs.get(0).getAgmtSeq());
				//log.debug("=========>>>>>>>>>>>>>>>>> payableRentalCostAuditVOs.get(0).getChgSeq()        : "+payableRentalCostAuditVOs.get(0).getChgSeq());
				//log.debug("=========>>>>>>>>>>>>>>>>> payableRentalCostAuditVOs.get(0).getCntrNo()        : "+payableRentalCostAuditVOs.get(0).getCntrNo());
				//log.debug("=========>>>>>>>>>>>>>>>>> payableRentalCostAuditVOs.get(0).getDtlSeq()        : "+payableRentalCostAuditVOs.get(0).getDtlSeq());
				//log.debug("=========>>>>>>>>>>>>>>>>> payableRentalCostAuditVOs.get(0).getLsePayChgTpCd() : "+payableRentalCostAuditVOs.get(0).getLsePayChgTpCd());
				insCnt = sqlExe.executeBatch(new PayableRentalCostDBDAOPayableChargeAuditUSQL(), payableRentalCostAuditVOs, null);
				for ( int i = 0 ; i < insCnt.length ; i++ ) {
					if(insCnt[i]== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Charge Createion : Audit 화면에서 신규로 Payable Charge Detail [LSE_PAY_RNTL_CHG_DTL] 입력<br>
	 * 
	 * @param  PayableRentalCostAuditVO payableRentalCostAuditVO
	 * @throws DAOException
	 */
	public void addPayableRentalAuditData(PayableRentalCostAuditVO payableRentalCostAuditVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.putAll(payableRentalCostAuditVO.getColumnValues());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeAuditCSQL(), param, param);

			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Charge Createion : Payable Charge Master [LSE_PAY_RNTL_CHG] 수정<br>
	 * 
	 * @param  String chgSeq
	 * @param  String usrId
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @throws DAOException
	 */
	public void modifyPayableRentalAuditChargeMasterData(String chgSeq, String usrId, String agmtCtyCd, String agmtSeq) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("chg_seq",     chgSeq);
			param.put("usr_id",      usrId);
			param.put("agmt_cty_cd", agmtCtyCd);
			param.put("agmt_seq",    agmtSeq);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeAuditChargeMasterUSQL(), param, param);

			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * Payable Rental Charge Cost : Invoice Creation 대상 조회<br>
	 * 
	 * @param  PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public PayableRentalCostVO searchPayableRentalInvoiceCreateData(PayableRentalCostVO payableRentalCostVO) throws DAOException {
		PayableRentalCostVO resultVo = new PayableRentalCostVO();
		DBRowSet dbRowset = null;
		List<PayableRentalCostInvoiceCreateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			List<String> arrChgSeq  = null;

			if ( !JSPUtil.getNull(payableRentalCostVO.getChgSeq()).equals("") ) {
				arrChgSeq = JSPUtil.convertStringToArrayList(payableRentalCostVO.getChgSeq());
				param.put("chg_seq", arrChgSeq);
			}

			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOPayableChargeInvoiceRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PayableRentalCostInvoiceCreateVO.class);
			resultVo.setPayableRentalCostInvoiceCreateVOs(list);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return resultVo;
	}
	 
	 
    /**
	 * Rental payable invoice 처리에 대한 진행 상황을  조회<br>
	 * 
	 * @param  PayableRentalInvoiceCostVO payableRentalInvoiceCostVO
	 * @return List<PayableRentalInvoiceCostVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PayableRentalInvoiceCostVO> searchPayableRentalInvoiceData(PayableRentalInvoiceCostVO payableRentalInvoiceCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PayableRentalInvoiceCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(payableRentalInvoiceCostVO != null){

				String strCostStMonth = payableRentalInvoiceCostVO.getCostStMonth();
				strCostStMonth = strCostStMonth.replaceAll("-", "");
				
				String strCostEdMonth = payableRentalInvoiceCostVO.getCostEdMonth();
				strCostEdMonth = strCostEdMonth.replaceAll("-", "");
				
				String strInvoiceStMonth = payableRentalInvoiceCostVO.getInvoiceStMonth();
				strInvoiceStMonth = strInvoiceStMonth.replaceAll("-", "");
				
				String strInvoiceEdMonth = payableRentalInvoiceCostVO.getInvoiceEdMonth();
				strInvoiceEdMonth = strInvoiceEdMonth.replaceAll("-", "");
				
				List<String> arrLstmCd = null;
		        arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(payableRentalInvoiceCostVO.getLstmCd(),",","|"));
				
				param.put("cost_st_month"    , strCostStMonth);
				param.put("cost_ed_month"    , strCostEdMonth);
				param.put("invoice_st_month" , strInvoiceStMonth);
				param.put("invoice_ed_month" , strInvoiceEdMonth);
				param.put("invoice_no"       , payableRentalInvoiceCostVO.getInvoiceNo());
				param.put("register_no"      , payableRentalInvoiceCostVO.getRegisterNo());
				param.put("vndr_seq"         , payableRentalInvoiceCostVO.getVndrSeq());
				param.put("lstm_cd"          , payableRentalInvoiceCostVO.getLstmCd());
				param.put("invoice_user"     , payableRentalInvoiceCostVO.getInvoiceUser());
				param.put("search_tp"        , payableRentalInvoiceCostVO.getSearchTp());
				
				velParam.put("cost_st_month"    , strCostStMonth);
				velParam.put("cost_ed_month"    , strCostEdMonth);
				velParam.put("invoice_st_month" , strInvoiceStMonth);
				velParam.put("invoice_ed_month" , strInvoiceEdMonth);
				velParam.put("invoice_no"       , payableRentalInvoiceCostVO.getInvoiceNo());
				velParam.put("register_no"      , payableRentalInvoiceCostVO.getRegisterNo());
				velParam.put("vndr_seq"         , payableRentalInvoiceCostVO.getVndrSeq());
				velParam.put("lstm_cd"          , arrLstmCd);
				velParam.put("lstm_cd_str"      , payableRentalInvoiceCostVO.getLstmCd());
				velParam.put("invoice_user"     , payableRentalInvoiceCostVO.getInvoiceUser());
				velParam.put("search_tp"        , payableRentalInvoiceCostVO.getSearchTp());
			
			}
			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOsearchPayableRentalInvoiceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PayableRentalInvoiceCostVO.class);
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
	 * Operation Lease Payable Invoice Creation Data [LSE_OP_LSE] 조회<br>
	 * 
	 * @param String lessorNo
	 * @param String effectiveDate
	 * @param String expireDate
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public PayableRentalCostVO searchOperatingPayableRentalData(String lessorNo, String effectiveDate, String expireDate) throws DAOException {
		PayableRentalCostVO resultVo = new PayableRentalCostVO();
		DBRowSet dbRowset = null;
		List<PayableRentalCostOperationalInvoiceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("vndr_seq", lessorNo);
			param.put("bil_fm_dt", effectiveDate);
			param.put("bil_to_dt", expireDate);

			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOLseOpLseVORSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PayableRentalCostOperationalInvoiceVO.class);
			resultVo.setPayableRentalCostOperationalInvoiceVOs(list);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultVo;
	}

	/**
	 * Operation Lease Payable Invoice Creation Data [LSE_OP_LSE] 입력<br>
	 * 
	 * @param PayableRentalCostOperationalInvoiceVO payableRentalCostOperationalInvoiceVO
	 * @exception EventException
	 */
	public void addOperatingPayableRentalData(PayableRentalCostOperationalInvoiceVO payableRentalCostOperationalInvoiceVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = payableRentalCostOperationalInvoiceVO.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOLseOpLseVOCSQL(), param, param);
					
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Operation Lease Payable Invoice Creation Data [LSE_OP_LSE] 수정<br>
	 * 
	 * @param PayableRentalCostOperationalInvoiceVO payableRentalCostOperationalInvoiceVO
	 * @exception EventException
	 */
	public void modifyOperatingPayableRentalData(PayableRentalCostOperationalInvoiceVO payableRentalCostOperationalInvoiceVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = payableRentalCostOperationalInvoiceVO.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOLseOpLseVOUSQL(), param, param);
					
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Operation Lease Payable Invoice Creation Data [LSE_OP_LSE] 삭제<br>
	 * 
	 * @param PayableRentalCostOperationalInvoiceVO payableRentalCostOperationalInvoiceVO
	 * @exception EventException
	 */
	public void removeOperatingPayableRentalData(PayableRentalCostOperationalInvoiceVO payableRentalCostOperationalInvoiceVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = payableRentalCostOperationalInvoiceVO.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOLseOpLseVODSQL(), param, param);
					
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Charge Createion : Payable Charge Master [LSE_PAY_RNTL_CHG] 금액 및 invoice No 수정<br>
	 * 
	 * @param  String invNo
	 * @param  String invRgstNo
	 * @param  String chgSeqs
	 * @param  String usrId
	 * @param  String payVndrSeq
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyPayableRentalChargeInvoiceData(String invNo, String invRgstNo, String chgSeqs, String usrId, String payVndrSeq) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("inv_no"      , invNo);
			param.put("if_rgst_no"  , invRgstNo);
			param.put("usr_id"      , usrId);
			param.put("pay_vndr_seq", payVndrSeq);

			List<String> arrChgSeq  = null;

			if ( !JSPUtil.getNull(chgSeqs).equals("") ) {
				arrChgSeq = JSPUtil.convertStringToArrayList(chgSeqs);
				param.put("chg_seq", arrChgSeq);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeCreationMasterInvoiceRegNoUSQL(), param, param);

			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Operating Payable Rental Charge Createion : Payable Charge Master [LSE_PAY_RNTL_CHG] 금액 및 invoice No 수정<br>
	 * 
	 * @param  String invNo
	 * @param  String invRgstNo
	 * @param  String opSeqs
	 * @param  String usrId
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyOperatingPayableRentalChargeInvoiceData(String invNo, String invRgstNo, String opSeqs, String usrId) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("inv_no",     invNo);
			param.put("if_rgst_no", invRgstNo);
			param.put("usr_id",     usrId);

			List<String> arrChgSeq  = null;

			if ( !JSPUtil.getNull(opSeqs).equals("") ) {
				arrChgSeq = JSPUtil.convertStringToArrayList(opSeqs);
				param.put("op_seq", arrChgSeq);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOLseOpLseInvoiceRegNoUSQL(), param, param);

			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Payable invoice 를 Cancel 처리함<br>
	 * 
	 * @param  PayableRentalInvoiceCostVO payableRentalInvoiceCostVO
	 * @throws DAOException
	 */
	public void modifyPayableRentalChargeInvoiceCancelData(PayableRentalInvoiceCostVO payableRentalInvoiceCostVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("if_rgst_no", payableRentalInvoiceCostVO.getIfRgstNo());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOmodifyPayableRentalChargeInvoiceCancelUSQL(), param, param);
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Operation Payable invoice 를 Cancel 처리함<br>
	 * 
	 * @param  PayableRentalInvoiceCostVO payableRentalInvoiceCostVO
	 * @throws DAOException
	 */
	public void modifyOperationPayableRentalChargeInvoiceCancelData(PayableRentalInvoiceCostVO payableRentalInvoiceCostVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("if_rgst_no", payableRentalInvoiceCostVO.getIfRgstNo());

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOmodifyOperationPayableRentalChargeInvoiceCancelUSQL(), param, param);
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable invoice Audit Reject 처리시 Audit Data Backup.<br>
	 * 
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  String chgSeq
	 * @param  String usrId
	 * @throws DAOException
	 */
	public void createPayableRentalChargeAuditRejectData(String agmtCtyCd, String agmtSeq, String chgSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("agmt_cty_cd", agmtCtyCd);
			param.put("agmt_seq",    agmtSeq);
			param.put("chg_seq",     chgSeq);
			param.put("usr_id",      usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeAuditRejectCSQL(), param, param);
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable invoice Audit Reject 처리시 Lessor Only, 직접입력 Data 삭제.<br>
	 * 
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  String chgSeq
	 * @throws DAOException
	 */
	public void removePayableRentalChargeAuditRejectDetailData(String agmtCtyCd, String agmtSeq, String chgSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("agmt_cty_cd", agmtCtyCd);
			param.put("agmt_seq",    agmtSeq);
			param.put("chg_seq",     chgSeq);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeAuditRejectDetailDSQL(), param, param);
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable invoice Audit Reject 처리시 Audit 이전 Data 로 수정.<br>
	 * 
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  String chgSeq
	 * @param  String usrId
	 * @throws DAOException
	 */
	public void modifyPayableRentalChargeAuditRejectDetailData(String agmtCtyCd, String agmtSeq, String chgSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("agmt_cty_cd", agmtCtyCd);
			param.put("agmt_seq",    agmtSeq);
			param.put("chg_seq",     chgSeq);
			param.put("usr_id",      usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeAuditRejectDetailUSQL(), param, param);
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable invoice Audit Reject 처리시 Invoice Data 를 Audit 이전 Data 로 수정.<br>
	 * 
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  String chgCostYrmon
	 * @param  String usrId
	 * @throws DAOException
	 */
	public void modifyPayableRentalChargeAuditRejectInvoiceData(String agmtCtyCd, String agmtSeq, String chgCostYrmon, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("agmt_cty_cd",    agmtCtyCd);
			param.put("agmt_seq",       agmtSeq);
			param.put("chg_cost_yrmon", chgCostYrmon);
			param.put("usr_id",         usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeAuditRejectInvoiceUSQL(), param, param);
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable invoice Audit Reject 처리시 Charge Creation Master Data 를 Audit 이전으로 수정.<br>
	 * 
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  String chgSeq
	 * @param  String usrId
	 * @throws DAOException
	 */
	public void modifyPayableRentalChargeAuditRejectMasterData(String agmtCtyCd, String agmtSeq, String chgSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("agmt_cty_cd", agmtCtyCd);
			param.put("agmt_seq",    agmtSeq);
			param.put("chg_seq",     chgSeq);
			param.put("usr_id",      usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableRentalCostDBDAOPayableChargeAuditRejectMasterUSQL(), param, param);
			if ( result == Statement.EXECUTE_FAILED ) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payable Rental Charge Audit 여부 [LSE_PAY_RNTL_CHG] 조회<br>
	 * 
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  String chgSeq
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchPayableRentalChargeRejectMasterData(String agmtCtyCd, String agmtSeq, String chgSeq) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("agmt_cty_cd", agmtCtyCd);
			param.put("agmt_seq",    agmtSeq);
			param.put("chg_seq",     chgSeq);

			dbRowset = new SQLExecuter("").executeQuery(new PayableRentalCostDBDAOPayableChargeAuditRejectMasterRSQL(), param, param);
			if ( dbRowset.next() ) {
				if ( Integer.parseInt(dbRowset.getString("CNT")) > 0 ) {
					result = true;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	 /**
		 * groupware 전송 xmlData Agreement info<br>
		 * @author 
		 * @category COM_CSR_0008
		 * @category printComCsrLseAgmtInfo 
		 * @param String csrNo
	     * @return List<ComCsrRequestAgmtVO>
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<ComCsrRequestAgmtVO> printComCsrLseAgmtInfo(String csrNo) throws DAOException {
	    	DBRowSet dbRowset = null;     
	        List<ComCsrRequestAgmtVO> list = null;        
	       
	        try{    
	        	// query parameter
	            Map<String, Object> param = new HashMap<String, Object>();
	            // velocity parameter
	            Map<String, Object> velParam = new HashMap<String, Object>();
	            
	        	//  CSR No
	        	param.put("csr_no", csrNo);
	        	
	        	// velocity parameter 설정 
	            velParam.putAll(param);
	            
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PayableRentalCostDBDAOprintComCsrLseAgmtInfoRSQL(), param, velParam);          
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestAgmtVO.class);         
	            
	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	        }        
	        return list;      
	    }  
	    
	    /**
		 *  Agreement info<br>
		 * @author 
		 * @category EES_LSE_0001
		 * @category printComCsrAgmtInfo2 
		 * @param String csrNo
	     * @return List<ComCsrRequestAgmtVO>
	     * @throws DAOException
	     */
	    @SuppressWarnings("unchecked")
	    public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws DAOException {
	    	DBRowSet dbRowset = null;     
	        List<ComCsrRequestAgmtVO> list = null;        
	       
	        try{    
	        	// query parameter
	            Map<String, Object> param = new HashMap<String, Object>();
	            // velocity parameter
	            Map<String, Object> velParam = new HashMap<String, Object>();
	            
	        	//  csr No
	        	param.put("csr_no", csrNo);
	        	
	        	// velocity parameter 설정 
	            velParam.putAll(param);
	            
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PayableRentalCostDBDAOSearchGwApprAgmtAttach2RSQLRSQL(), param, velParam);          
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestAgmtVO.class);         
	            
	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	        }        
	        return list;      
	    }     
}