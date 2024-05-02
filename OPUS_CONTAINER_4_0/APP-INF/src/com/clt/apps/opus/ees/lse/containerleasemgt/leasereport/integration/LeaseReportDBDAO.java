/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ILeaseReportDBDAO.java
*@FileTitle : On Hire Result by Location / AGMT No(Contract No.)-Option
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* =======================================================
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.basic.LeaseReportBCImpl;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.InventoryDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.InventorySummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.ReportSearchVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SearchParamVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutSummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.UsingDayDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.UsingDaySummaryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil; 
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * ILeaseReportDBDAO <br>
 * ContainerLeaseMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jin Jun Sung
 * @see LeaseReportBCImpl 참조
 * @since J2EE 1.6
 */
public class LeaseReportDBDAO extends DBDAOSupport {
  /**
	* Page Size(50)<br>
	*/
  private static final int PAGE_SIZE_1000  =  10000;
  private static final int PAGE_SIZE_5000  =  5000;

  /**
   * 임차장비 임차 (ON 장비) 실적을 조회<br>
   *
   * @param  ReportSearchVO reportSearchVO
   * @return List<ReportSearchVO>
   * @throws DAOException
   */
   @SuppressWarnings("unchecked")
  public List<ReportSearchVO> searchOnHireResultbyLocationAgreementSummaryData(ReportSearchVO reportSearchVO) throws DAOException {
    DBRowSet dbRowset = null;
    List<ReportSearchVO> list = null;

    //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
    //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();

    try{

      if(reportSearchVO != null){
          String period_stdt = reportSearchVO.getPeriodStdt();
          period_stdt = period_stdt.replaceAll("-", "");
          String period_eddt = reportSearchVO.getPeriodEddt();
          period_eddt = period_eddt.replaceAll("-", "");

          List<String> arrLstmCd      = null;
          arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

          List<String> arrCntrTpszCd      = null;
          arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

          List<String> arrTysz   = null;
          arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getTysz(),",","|"));

          param.put("loc_cd"            , reportSearchVO.getLocCd());
          param.put("loc_tp"            , reportSearchVO.getLocTp());
          param.put("period_stdt"       , period_stdt);
          param.put("period_eddt"       , period_eddt);
          param.put("agmt_cty_cd"       , reportSearchVO.getAgmtCtyCd());
          param.put("agmt_seq"          , reportSearchVO.getAgmtSeq());
          param.put("lstm_cd"           , arrLstmCd);
          param.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
          param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
          param.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
          param.put("company"           , reportSearchVO.getCompany());
          param.put("vndr_seq"          , reportSearchVO.getVndrSeq());
          param.put("tysz"              , arrTysz);
          param.put("term_change"       , reportSearchVO.getTermChange());
          param.put("dii"               , reportSearchVO.getDii());

          velParam.put("loc_cd"           , reportSearchVO.getLocCd());
          velParam.put("loc_tp"           , reportSearchVO.getLocTp());
          velParam.put("period_stdt"      , period_stdt);
          velParam.put("period_eddt"      , period_eddt);
          velParam.put("agmt_cty_cd"      , reportSearchVO.getAgmtCtyCd());
          velParam.put("agmt_seq"         , reportSearchVO.getAgmtSeq());
          velParam.put("lstm_cd"          , arrLstmCd);
          velParam.put("lstm_cd_str"      , reportSearchVO.getLstmCd());
          velParam.put("cntr_tpsz_cd"     , arrCntrTpszCd);
          velParam.put("cntr_tpsz_cd_str" , reportSearchVO.getCntrTpszCd());
          velParam.put("company"          , reportSearchVO.getCompany());
          velParam.put("vndr_seq"         , reportSearchVO.getVndrSeq());
          velParam.put("tysz"             , arrTysz);
          velParam.put("term_change"      , reportSearchVO.getTermChange());
          velParam.put("dii"              , reportSearchVO.getDii());
      }
      dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOnHireResultbyLocationAgreementSummaryRSQL(), param, velParam);
      list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

    }catch(SQLException se){
      log.error(se.getMessage(),se);
      throw new DAOException(new ErrorHandler(se).getMessage());
    }catch(Exception ex){
      log.error(ex.getMessage(),ex);
      throw new DAOException(new ErrorHandler(ex).getMessage());
    }
    return list;
  }

   /**
    * 임차장비 임차실적의(ON 장비) 상세 전체건수를 조회한다.<br>
    *
    * @param  ReportSearchVO reportSearchVO
    * @return int
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
   public int searchOnHireResultbyLocationAgreementCountData(ReportSearchVO reportSearchVO) throws DAOException {
      int totalCnt = 0;
      DBRowSet dbRowset = null;
     //query parameter
     Map<String, Object> param = new HashMap<String, Object>();
     //velocity parameter
     Map<String, Object> velParam = new HashMap<String, Object>();

     try{

       if(reportSearchVO != null){
           String period_stdt = reportSearchVO.getPeriodStdt();
           period_stdt = period_stdt.replaceAll("-", "");
           String period_eddt = reportSearchVO.getPeriodEddt();
           period_eddt = period_eddt.replaceAll("-", "");

           List<String> arrLstmCd      = null;
           arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

           List<String> arrCntrTpszCd      = null;
           arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

           param.put("period_stdt"       , period_stdt);
           param.put("period_eddt"       , period_eddt);
           param.put("loc_cd"            , reportSearchVO.getLocCd());
           param.put("loc_tp"            , reportSearchVO.getLocTp());
           param.put("agmt_cty_cd"       , reportSearchVO.getAgmtCtyCd());
           param.put("agmt_seq"          , reportSearchVO.getAgmtSeq());
           param.put("lstm_cd"           , arrLstmCd);
           param.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
           param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
           param.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
           param.put("company"           , reportSearchVO.getCompany());
           param.put("vndr_seq"          , reportSearchVO.getVndrSeq());
           param.put("detail_rcc"        , reportSearchVO.getDetailRcc());
           param.put("detail_agmt_cty_cd", reportSearchVO.getDetailAgmtCtyCd());
           param.put("detail_agmt_seq"   , reportSearchVO.getDetailAgmtSeq());
           param.put("detail_cntr_tp_sz" , reportSearchVO.getDetailCntrTpSz());
           param.put("term_change"       , reportSearchVO.getTermChange());
           param.put("dii"               , reportSearchVO.getDii());

           velParam.put("period_stdt"       , period_stdt);
           velParam.put("period_eddt"       , period_eddt);
           velParam.put("loc_cd"            , reportSearchVO.getLocCd());
           velParam.put("loc_tp"            , reportSearchVO.getLocTp());
           velParam.put("agmt_cty_cd"       , reportSearchVO.getAgmtCtyCd());
           velParam.put("agmt_seq"          , reportSearchVO.getAgmtSeq());
           velParam.put("lstm_cd"           , arrLstmCd);
           velParam.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
           velParam.put("cntr_tpsz_cd"      , arrCntrTpszCd);
           velParam.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
           velParam.put("company"           , reportSearchVO.getCompany());
           velParam.put("vndr_seq"          , reportSearchVO.getVndrSeq());
           velParam.put("detail_rcc"        , reportSearchVO.getDetailRcc());
           velParam.put("detail_agmt_cty_cd", reportSearchVO.getDetailAgmtCtyCd());
           velParam.put("detail_agmt_seq"   , reportSearchVO.getDetailAgmtSeq());
           velParam.put("detail_cntr_tp_sz" , reportSearchVO.getDetailCntrTpSz());
           velParam.put("term_change"      , reportSearchVO.getTermChange());
           velParam.put("dii"              , reportSearchVO.getDii());
       }

       dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOnHireResultbyLocationAgreementCountRSQL(), param, velParam);
       if(dbRowset.next()) {
   		 totalCnt = dbRowset.getInt("TOTAL_CNT");
       }

     }catch(SQLException se){
       log.error(se.getMessage(),se);
       throw new DAOException(new ErrorHandler(se).getMessage());
     }catch(Exception ex){
       log.error(ex.getMessage(),ex);
       throw new DAOException(new ErrorHandler(ex).getMessage());
     }
     return totalCnt;
   }

/**
 * 임차장비 임차 (ON 장비) 실적을 상세조회<br>
 *
 * @param  ReportSearchVO reportSearchVO
 * @return List<ReportSearchVO>
 * @throws DAOException
 */
 @SuppressWarnings("unchecked")
public List<ReportSearchVO> searchOnHireResultbyLocationAgreementDetailData(ReportSearchVO reportSearchVO) throws DAOException {
   int currentPage = reportSearchVO.getIPage();
   int startNo = PAGE_SIZE_1000 * (currentPage -1) +1;
   int endNo   = PAGE_SIZE_1000 *  currentPage;

   DBRowSet dbRowset = null;
  List<ReportSearchVO> list = null;
  //query parameter
  Map<String, Object> param = new HashMap<String, Object>();
  param.put("startno", startNo);
  param.put("endno", endNo);
  //velocity parameter
  Map<String, Object> velParam = new HashMap<String, Object>();
  velParam.put("startno", startNo);
  velParam.put("endno", endNo);

  try{

    if(reportSearchVO != null){
        String period_stdt = reportSearchVO.getPeriodStdt();
        period_stdt = period_stdt.replaceAll("-", "");
        String period_eddt = reportSearchVO.getPeriodEddt();
        period_eddt = period_eddt.replaceAll("-", "");

        List<String> arrLstmCd      = null;
        arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

        List<String> arrCntrTpszCd      = null;
        arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

        param.put("period_stdt"       , period_stdt);
        param.put("period_eddt"       , period_eddt);
        param.put("loc_cd"            , reportSearchVO.getLocCd());
        param.put("loc_tp"            , reportSearchVO.getLocTp());
        param.put("agmt_cty_cd"       , reportSearchVO.getAgmtCtyCd());
        param.put("agmt_seq"          , reportSearchVO.getAgmtSeq());
        param.put("lstm_cd"           , arrLstmCd);
        param.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
        param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
        param.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
        param.put("company"           , reportSearchVO.getCompany());
        param.put("vndr_seq"          , reportSearchVO.getVndrSeq());
        param.put("detail_rcc"        , reportSearchVO.getDetailRcc());
        param.put("detail_agmt_cty_cd", reportSearchVO.getDetailAgmtCtyCd());
        param.put("detail_agmt_seq"   , reportSearchVO.getDetailAgmtSeq());
        param.put("detail_cntr_tp_sz" , reportSearchVO.getDetailCntrTpSz());
        param.put("term_change"       , reportSearchVO.getTermChange());
        param.put("dii"               , reportSearchVO.getDii());

        velParam.put("period_stdt"       , period_stdt);
        velParam.put("period_eddt"       , period_eddt);
        velParam.put("loc_cd"            , reportSearchVO.getLocCd());
        velParam.put("loc_tp"            , reportSearchVO.getLocTp());
        velParam.put("agmt_cty_cd"       , reportSearchVO.getAgmtCtyCd());
        velParam.put("agmt_seq"          , reportSearchVO.getAgmtSeq());
        velParam.put("lstm_cd"           , arrLstmCd);
        velParam.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
        velParam.put("cntr_tpsz_cd"      , arrCntrTpszCd);
        velParam.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
        velParam.put("company"           , reportSearchVO.getCompany());
        velParam.put("vndr_seq"          , reportSearchVO.getVndrSeq());
        velParam.put("detail_rcc"        , reportSearchVO.getDetailRcc());
        velParam.put("detail_agmt_cty_cd", reportSearchVO.getDetailAgmtCtyCd());
        velParam.put("detail_agmt_seq"   , reportSearchVO.getDetailAgmtSeq());
        velParam.put("detail_cntr_tp_sz" , reportSearchVO.getDetailCntrTpSz());
        velParam.put("term_change"      , reportSearchVO.getTermChange());
        velParam.put("dii"              , reportSearchVO.getDii());
    }

    dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOnHireResultbyLocationAgreementDetailRSQL(), param, velParam);
    list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

  }catch(SQLException se){
    log.error(se.getMessage(),se);
    throw new DAOException(new ErrorHandler(se).getMessage());
  }catch(Exception ex){
    log.error(ex.getMessage(),ex);
    throw new DAOException(new ErrorHandler(ex).getMessage());
  }
  return list;
}
  /**
   * 임차장비 임차 (Off 장비) 실적을 조회<br>
   *
   * @param  ReportSearchVO reportSearchVO
   * @return List<ReportSearchVO>
   * @throws DAOException
   */
   @SuppressWarnings("unchecked")
  public List<ReportSearchVO> searchOffHireResultbyLocationAgreementSummaryData(ReportSearchVO reportSearchVO) throws DAOException {
    DBRowSet dbRowset = null;
    List<ReportSearchVO> list = null;

    //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
    //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();

    try{
      if(reportSearchVO != null){
          String period_stdt = reportSearchVO.getPeriodStdt();
                 period_stdt = period_stdt.replaceAll("-", "");
          String period_eddt = reportSearchVO.getPeriodEddt();
                 period_eddt = period_eddt.replaceAll("-", "");

          List<String> arrLstmCd      = null;
          arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

          List<String> arrCntrTpszCd      = null;
          arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

          List<String> arrTysz   = null;
          arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getTysz(),",","|"));

          param.put("loc_cd"            , reportSearchVO.getLocCd());
          param.put("loc_tp"            , reportSearchVO.getLocTp());
          param.put("period_stdt"       , period_stdt);
          param.put("period_eddt"       , period_eddt);
          param.put("agmt_cty_cd"       , reportSearchVO.getAgmtCtyCd());
          param.put("agmt_seq"          , reportSearchVO.getAgmtSeq());
          param.put("lstm_cd"           , arrLstmCd);
          param.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
          param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
          param.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
          param.put("company"           , reportSearchVO.getCompany());
          param.put("vndr_seq"          , reportSearchVO.getVndrSeq());
          param.put("tysz"              , arrTysz);
          param.put("term_change"       , reportSearchVO.getTermChange());
          param.put("dii"               , reportSearchVO.getDii());
          param.put("old_agmt_no"       , reportSearchVO.getOldAgmtNo());
          param.put("lse_ctrt_no"       , reportSearchVO.getLseCtrtNo());
          
          velParam.put("loc_cd"           , reportSearchVO.getLocCd());
          velParam.put("loc_tp"           , reportSearchVO.getLocTp());
          velParam.put("period_stdt"      , period_stdt);
          velParam.put("period_eddt"      , period_eddt);
          velParam.put("agmt_cty_cd"      , reportSearchVO.getAgmtCtyCd());
          velParam.put("agmt_seq"         , reportSearchVO.getAgmtSeq());
          velParam.put("lstm_cd"          , arrLstmCd);
          velParam.put("lstm_cd_str"      , reportSearchVO.getLstmCd());
          velParam.put("cntr_tpsz_cd"     , arrCntrTpszCd);
          velParam.put("cntr_tpsz_cd_str" , reportSearchVO.getCntrTpszCd());
          velParam.put("company"          , reportSearchVO.getCompany());
          velParam.put("vndr_seq"         , reportSearchVO.getVndrSeq());
          velParam.put("tysz"             , arrTysz);
          velParam.put("term_change"      , reportSearchVO.getTermChange());
          velParam.put("dii"              , reportSearchVO.getDii());
          velParam.put("old_agmt_no"      , reportSearchVO.getOldAgmtNo());
          velParam.put("lse_ctrt_no"      , reportSearchVO.getLseCtrtNo());

      }
      dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireResultbyLocationAgreementSummaryRSQL(), param, velParam);
      list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

    }catch(SQLException se){
      log.error(se.getMessage(),se);
      throw new DAOException(new ErrorHandler(se).getMessage());
    }catch(Exception ex){
      log.error(ex.getMessage(),ex);
      throw new DAOException(new ErrorHandler(ex).getMessage());
    }
    return list;
  }

   /**
    * 임차장비 임차 (Off 장비) 실적의 전체건수 조회<br>
    *
    * @param  ReportSearchVO reportSearchVO
    * @return int
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
   public int searchOffHireResultbyLocationAgreementCountData(ReportSearchVO reportSearchVO) throws DAOException {
     int totalCnt = 0;
     DBRowSet dbRowset = null;

     //query parameter
     Map<String, Object> param = new HashMap<String, Object>();
     //velocity parameter
     Map<String, Object> velParam = new HashMap<String, Object>();

     try{

       if(reportSearchVO != null){
           String period_stdt = reportSearchVO.getPeriodStdt();
           period_stdt = period_stdt.replaceAll("-", "");
           String period_eddt = reportSearchVO.getPeriodEddt();
           period_eddt = period_eddt.replaceAll("-", "");

           List<String> arrLstmCd      = null;
           arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

           List<String> arrCntrTpszCd      = null;
           arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

           param.put("period_stdt"       , period_stdt);
           param.put("period_eddt"       , period_eddt);
           param.put("loc_cd"            , reportSearchVO.getLocCd());
           param.put("loc_tp"            , reportSearchVO.getLocTp());
           param.put("agmt_cty_cd"       , reportSearchVO.getAgmtCtyCd());
           param.put("agmt_seq"          , reportSearchVO.getAgmtSeq());
           param.put("lstm_cd"           , arrLstmCd);
           param.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
           param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
           param.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
           param.put("company"           , reportSearchVO.getCompany());
           param.put("vndr_seq"          , reportSearchVO.getVndrSeq());
           param.put("detail_rcc"        , reportSearchVO.getDetailRcc());
           param.put("detail_agmt_cty_cd", reportSearchVO.getDetailAgmtCtyCd());
           param.put("detail_agmt_seq"   , reportSearchVO.getDetailAgmtSeq());
           param.put("detail_cntr_tp_sz" , reportSearchVO.getDetailCntrTpSz());
           param.put("term_change"       , reportSearchVO.getTermChange());
           param.put("dii"               , reportSearchVO.getDii());

           velParam.put("period_stdt"       , period_stdt);
           velParam.put("period_eddt"       , period_eddt);
           velParam.put("loc_cd"            , reportSearchVO.getLocCd());
           velParam.put("loc_tp"            , reportSearchVO.getLocTp());
           velParam.put("agmt_cty_cd"       , reportSearchVO.getAgmtCtyCd());
           velParam.put("agmt_seq"          , reportSearchVO.getAgmtSeq());
           velParam.put("lstm_cd"           , arrLstmCd);
           velParam.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
           velParam.put("cntr_tpsz_cd"      , arrCntrTpszCd);
           velParam.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
           velParam.put("company"           , reportSearchVO.getCompany());
           velParam.put("vndr_seq"          , reportSearchVO.getVndrSeq());
           velParam.put("detail_rcc"        , reportSearchVO.getDetailRcc());
           velParam.put("detail_agmt_cty_cd", reportSearchVO.getDetailAgmtCtyCd());
           velParam.put("detail_agmt_seq"   , reportSearchVO.getDetailAgmtSeq());
           velParam.put("detail_cntr_tp_sz" , reportSearchVO.getDetailCntrTpSz());
           velParam.put("term_change"      , reportSearchVO.getTermChange());
           velParam.put("dii"              , reportSearchVO.getDii());
       }

       dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireResultbyLocationAgreementCountRSQL(), param, velParam);
       if(dbRowset.next()) {
   		 totalCnt = dbRowset.getInt("TOTAL_CNT");
       }

     }catch(SQLException se){
       log.error(se.getMessage(),se);
       throw new DAOException(new ErrorHandler(se).getMessage());
     }catch(Exception ex){
       log.error(ex.getMessage(),ex);
       throw new DAOException(new ErrorHandler(ex).getMessage());
     }
     return totalCnt;
   }

  /**
   * 임차장비 임차 (Off 장비) 실적을 상세조회<br>
   *
   * @param  ReportSearchVO reportSearchVO
   * @param  SignOnUserAccount account
   * @return List<ReportSearchVO>
   * @throws DAOException
   */
   @SuppressWarnings("unchecked")
  public List<ReportSearchVO> searchOffHireResultbyLocationAgreementDetailData(ReportSearchVO reportSearchVO, SignOnUserAccount account) throws DAOException {
	int currentPage = reportSearchVO.getIPage();
  	int startNo = PAGE_SIZE_1000 * (currentPage -1) +1;
  	int endNo   = PAGE_SIZE_1000 *  currentPage;
    DBRowSet dbRowset = null;
    List<ReportSearchVO> list = null;

    //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("startno", startNo);
	param.put("endno", endNo);
    //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();
    velParam.put("startno", startNo);
    velParam.put("endno", endNo);

    try{

      if(reportSearchVO != null){
          String period_stdt = reportSearchVO.getPeriodStdt();
          period_stdt = period_stdt.replaceAll("-", "");
          String period_eddt = reportSearchVO.getPeriodEddt();
          period_eddt = period_eddt.replaceAll("-", "");

          List<String> arrLstmCd      = null;
          arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

          List<String> arrCntrTpszCd      = null;
          arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

          param.put("period_stdt"       , period_stdt);
          param.put("period_eddt"       , period_eddt);
          param.put("loc_cd"            , reportSearchVO.getLocCd());
          param.put("loc_tp"            , reportSearchVO.getLocTp());
          param.put("agmt_cty_cd"       , reportSearchVO.getAgmtCtyCd());
          param.put("agmt_seq"          , reportSearchVO.getAgmtSeq());
          param.put("lstm_cd"           , arrLstmCd);
          param.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
          param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
          param.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
          param.put("company"           , reportSearchVO.getCompany());
          param.put("vndr_seq"          , reportSearchVO.getVndrSeq());
          param.put("detail_rcc"        , reportSearchVO.getDetailRcc());
          param.put("detail_agmt_cty_cd", reportSearchVO.getDetailAgmtCtyCd());
          param.put("detail_agmt_seq"   , reportSearchVO.getDetailAgmtSeq());
          param.put("detail_cntr_tp_sz" , reportSearchVO.getDetailCntrTpSz());
          param.put("term_change"       , reportSearchVO.getTermChange());
          param.put("dii"               , reportSearchVO.getDii());
          param.put("usr_ofc_cd"        , account.getOfc_cd());
          param.put("lse_ctrt_no"       , reportSearchVO.getLseCtrtNo());

          velParam.put("period_stdt"       , period_stdt);
          velParam.put("period_eddt"       , period_eddt);
          velParam.put("loc_cd"            , reportSearchVO.getLocCd());
          velParam.put("loc_tp"            , reportSearchVO.getLocTp());
          velParam.put("agmt_cty_cd"       , reportSearchVO.getAgmtCtyCd());
          velParam.put("agmt_seq"          , reportSearchVO.getAgmtSeq());
          velParam.put("lstm_cd"           , arrLstmCd);
          velParam.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
          velParam.put("cntr_tpsz_cd"      , arrCntrTpszCd);
          velParam.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
          velParam.put("company"           , reportSearchVO.getCompany());
          velParam.put("vndr_seq"          , reportSearchVO.getVndrSeq());
          velParam.put("detail_rcc"        , reportSearchVO.getDetailRcc());
          velParam.put("detail_agmt_cty_cd", reportSearchVO.getDetailAgmtCtyCd());
          velParam.put("detail_agmt_seq"   , reportSearchVO.getDetailAgmtSeq());
          velParam.put("detail_cntr_tp_sz" , reportSearchVO.getDetailCntrTpSz());
          velParam.put("term_change"       , reportSearchVO.getTermChange());
          velParam.put("dii"               , reportSearchVO.getDii());
          velParam.put("usr_ofc_cd"        , account.getOfc_cd());
          velParam.put("lse_ctrt_no"       , reportSearchVO.getLseCtrtNo());
      }

      dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireResultbyLocationAgreementDetailRSQL(), param, velParam);
      list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

    }catch(SQLException se){
      log.error(se.getMessage(),se);
      throw new DAOException(new ErrorHandler(se).getMessage());
    }catch(Exception ex){
      log.error(ex.getMessage(),ex);
      throw new DAOException(new ErrorHandler(ex).getMessage());
    }
    return list;
  }

  /**
   * 반납 임차장비에 대한 계약번호별 평균사용 실적목록을 조회합니다.<br>
   *
   * @param  SearchParamVO searchParamVO
   * @return List<UsingDaySummaryVO>
   * @throws DAOException
   */
   @SuppressWarnings("unchecked")
  public List<UsingDaySummaryVO> searchOffHireResultAvgUsingDaySummaryListData(SearchParamVO searchParamVO) throws DAOException {

    DBRowSet dbRowset = null;
    List<UsingDaySummaryVO> list = null;
    //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
    //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();

    try{
      if(searchParamVO != null){
        Map<String, String> mapVO = searchParamVO.getColumnValues();

        param.putAll(mapVO);
        velParam.putAll(mapVO);

        List<String> arrLstmCd  = null;
        List<String> arrCntrTpszCd = null;

        if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
          arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
          param.put("lstm_cd_seq", arrLstmCd);
          velParam.put("lstm_cd_seq", arrLstmCd);
        }

        if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
          arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
          param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
          velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
        }
      }

      dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOOffHireResultAvgUsingDaySummaryListRSQL(), param, velParam);
      list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsingDaySummaryVO.class);
    }catch(SQLException se){
      log.error(se.getMessage(),se);
      throw new DAOException(new ErrorHandler(se).getMessage());
    }catch(Exception ex){
      log.error(ex.getMessage(),ex);
      throw new DAOException(new ErrorHandler(ex).getMessage());
    }
    return list;
  }

   /**
    * 임차장비별 사용실적에 대한 전체건수를 조회합니다.<br>
    *
    * @param  SearchParamVO searchParamVO
    * @return int
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
   public int searchOffHireResultAvgUsingDayCountData(SearchParamVO searchParamVO) throws DAOException {

     int totalCnt = 0;
     DBRowSet dbRowset = null;
     //query parameter
     Map<String, Object> param = new HashMap<String, Object>();
     //velocity parameter
     Map<String, Object> velParam = new HashMap<String, Object>();

     try{
       if(searchParamVO != null){
         Map<String, String> mapVO = searchParamVO.getColumnValues();

         param.putAll(mapVO);
         velParam.putAll(mapVO);

         List<String> arrLstmCd  = null;
         List<String> arrCntrTpszCd = null;

         if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
           arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
           param.put("lstm_cd_seq", arrLstmCd);
           velParam.put("lstm_cd_seq", arrLstmCd);
         }

         if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
           arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
           param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
           velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
         }
       }

       dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOOffHireResultAvgUsingDayCountRSQL(), param, velParam);
       if(dbRowset.next()) {
   		 totalCnt = dbRowset.getInt("TOTAL_CNT");
       }
     }catch(SQLException se){
       log.error(se.getMessage(),se);
       throw new DAOException(new ErrorHandler(se).getMessage());
     }catch(Exception ex){
       log.error(ex.getMessage(),ex);
       throw new DAOException(new ErrorHandler(ex).getMessage());
     }
     return totalCnt;
   }

  /**
   * 임차장비별 사용실적에 대한 상세내역을 조회합니다.<br>
   *
   * @param  SearchParamVO searchParamVO
   * @param  SignOnUserAccount account
   * @return List<UsingDayDetailVO>
   * @throws DAOException
   */
   @SuppressWarnings("unchecked")
  public List<UsingDayDetailVO> searchOffHireResultAvgUsingDayDetailData(SearchParamVO searchParamVO, SignOnUserAccount account) throws DAOException {
	int currentPage = searchParamVO.getIPage();
  	int startNo = PAGE_SIZE_1000 * (currentPage -1) +1;
  	int endNo   = PAGE_SIZE_1000 *  currentPage;

    DBRowSet dbRowset = null;
    List<UsingDayDetailVO> list = null;
    //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
    //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();

    try{
      if(searchParamVO != null){
        Map<String, String> mapVO = searchParamVO.getColumnValues();

        param.putAll(mapVO);
        param.put("startno", startNo);
		param.put("endno", endNo);
		param.put("usr_ofc_cd", account.getOfc_cd());
        velParam.putAll(mapVO);
        velParam.put("startno", startNo);
        velParam.put("endno", endNo);
        velParam.put("usr_ofc_cd", account.getOfc_cd());
        
        List<String> arrLstmCd  = null;
        List<String> arrCntrTpszCd = null;

        if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
          arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
          param.put("lstm_cd_seq", arrLstmCd);
          velParam.put("lstm_cd_seq", arrLstmCd);
        }

        if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
          arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
          param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
          velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
        }
      }

      dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOOffHireResultAvgUsingDayDetailRSQL(), param, velParam);
      list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsingDayDetailVO.class);
    }catch(SQLException se){
      log.error(se.getMessage(),se);
      throw new DAOException(new ErrorHandler(se).getMessage());
    }catch(Exception ex){
      log.error(ex.getMessage(),ex);
      throw new DAOException(new ErrorHandler(ex).getMessage());
    }
    return list;
    }

    /**
     * 임차장비 임차 (ON 장비) 실적을 조회<br>
     * (ON-Hire Result by Lease Term/Lessor-Option)
     * @param  ReportSearchVO reportSearchVO
     * @return List<ReportSearchVO>
     * @throws DAOException
     */
       @SuppressWarnings("unchecked")
    public List<ReportSearchVO> searchOnHireResultbyTermLessorSummaryData(ReportSearchVO reportSearchVO) throws DAOException {
      DBRowSet dbRowset = null;
      List<ReportSearchVO> list = null;

      //query parameter
      Map<String, Object> param = new HashMap<String, Object>();
      //velocity parameter
      Map<String, Object> velParam = new HashMap<String, Object>();

      try{

        if(reportSearchVO != null){
            String period_stdt = reportSearchVO.getPeriodStdt();
            period_stdt = period_stdt.replaceAll("-", "");
            String period_eddt = reportSearchVO.getPeriodEddt();
            period_eddt = period_eddt.replaceAll("-", "");

            List<String> arrLstmCd      = null;
            arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

            List<String> arrCntrTpszCd      = null;
            arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

            List<String> arrTysz   = null;
            arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getTysz(),",","|"));

            param.put("loc_cd"            , reportSearchVO.getLocCd());
            param.put("loc_tp"            , reportSearchVO.getLocTp());
            param.put("period_stdt"       , period_stdt);
            param.put("period_eddt"       , period_eddt);
            param.put("lstm_cd"           , arrLstmCd);
            param.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
            param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
            param.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
            param.put("vndr_seq"          , reportSearchVO.getVndrSeq());
            param.put("company"           , reportSearchVO.getCompany());
            param.put("tysz"              , arrTysz);
            param.put("term_change"       , reportSearchVO.getTermChange());
            param.put("dii"               , reportSearchVO.getDii());

            velParam.put("loc_cd"           , reportSearchVO.getLocCd());
            velParam.put("loc_tp"           , reportSearchVO.getLocTp());
            velParam.put("period_stdt"      , period_stdt);
            velParam.put("period_eddt"      , period_eddt);
            velParam.put("lstm_cd"          , arrLstmCd);
            velParam.put("lstm_cd_str"      , reportSearchVO.getLstmCd());
            velParam.put("cntr_tpsz_cd"     , arrCntrTpszCd);
            velParam.put("cntr_tpsz_cd_str" , reportSearchVO.getCntrTpszCd());
            velParam.put("vndr_seq"         , reportSearchVO.getVndrSeq());
            velParam.put("company"          , reportSearchVO.getCompany());
            velParam.put("tysz"             , arrTysz);
            velParam.put("term_change"      , reportSearchVO.getTermChange());
            velParam.put("dii"              , reportSearchVO.getDii());
        }
        dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOnHireResultbyTermLessorSummaryRSQL(), param, velParam);
        list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

      }catch(SQLException se){
        log.error(se.getMessage(),se);
        throw new DAOException(new ErrorHandler(se).getMessage());
      }catch(Exception ex){
        log.error(ex.getMessage(),ex);
          throw new DAOException(new ErrorHandler(ex).getMessage());
      }
      return list;
    }

   /**
    * 임차장비 임차 (ON 장비) 실적을 상세 전체건수를 조회합니다.<br>
    * (On-Hire Result by Lease Term/Lessor-Option)
    * @param  ReportSearchVO reportSearchVO
    * @return int
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
   public int searchOnHireResultbyTermLessorCountData(ReportSearchVO reportSearchVO) throws DAOException {

      int totalCnt = 0;
      DBRowSet dbRowset = null;
     //query parameter
     Map<String, Object> param = new HashMap<String, Object>();
     //velocity parameter
     Map<String, Object> velParam = new HashMap<String, Object>();

     try{

       if(reportSearchVO != null){
           String period_stdt = reportSearchVO.getPeriodStdt();
           period_stdt = period_stdt.replaceAll("-", "");
           String period_eddt = reportSearchVO.getPeriodEddt();
           period_eddt = period_eddt.replaceAll("-", "");

           List<String> arrLstmCd      = null;
           arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

           List<String> arrCntrTpszCd      = null;
           arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

           String strDetailLstmCd      = reportSearchVO.getDetailLstmCd();
           String strDetailVndrSeq     = reportSearchVO.getDetailVndrSeq();
           String strDetailCntrTpszCd  = reportSearchVO.getDetailCntrTpszCd();

           param.put("period_stdt"         , period_stdt);
           param.put("period_eddt"         , period_eddt);
           param.put("detail_lstm_cd"      , strDetailLstmCd);
           param.put("detail_vndr_seq"     , strDetailVndrSeq);
           param.put("detail_cntr_tpsz_cd" , strDetailCntrTpszCd);
           param.put("lstm_cd"             , arrLstmCd);
           param.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
           param.put("cntr_tpsz_cd"        , arrCntrTpszCd);
           param.put("cntr_tpsz_cd_str"    , reportSearchVO.getCntrTpszCd());
           param.put("vndr_seq"            , reportSearchVO.getVndrSeq());
           param.put("term_change"         , reportSearchVO.getTermChange());
           param.put("dii"                 , reportSearchVO.getDii());

           velParam.put("period_stdt"         , period_stdt);
           velParam.put("period_eddt"         , period_eddt);
           velParam.put("detail_lstm_cd"      , strDetailLstmCd);
           velParam.put("detail_vndr_seq"     , strDetailVndrSeq);
           velParam.put("detail_cntr_tpsz_cd" , strDetailCntrTpszCd);
           velParam.put("lstm_cd"             , arrLstmCd);
           velParam.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
           velParam.put("cntr_tpsz_cd"        , arrCntrTpszCd);
           velParam.put("cntr_tpsz_cd_str"    , reportSearchVO.getCntrTpszCd());
           velParam.put("vndr_seq"            , reportSearchVO.getVndrSeq());
           velParam.put("term_change"         , reportSearchVO.getTermChange());
           velParam.put("dii"                 , reportSearchVO.getDii());
       }

       dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOnHireResultbyTermLessorCountRSQL(), param, velParam);
       if(dbRowset.next()) {
   		 totalCnt = dbRowset.getInt("TOTAL_CNT");
       }

     }catch(SQLException se){
       log.error(se.getMessage(),se);
       throw new DAOException(new ErrorHandler(se).getMessage());
     }catch(Exception ex){
       log.error(ex.getMessage(),ex);
       throw new DAOException(new ErrorHandler(ex).getMessage());
     }
     return totalCnt;
   }

    /**
     * 임차장비 임차 (ON 장비) 실적을 상세조회<br>
     * (On-Hire Result by Lease Term/Lessor-Option)
     * @param  ReportSearchVO reportSearchVO
     * @return List<ReportSearchVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
    public List<ReportSearchVO> searchOnHireResultbyTermLessorDetailData(ReportSearchVO reportSearchVO) throws DAOException {
       int currentPage = reportSearchVO.getIPage();
       int startNo = PAGE_SIZE_1000 * (currentPage -1) +1;
       int endNo   = PAGE_SIZE_1000 *  currentPage;
       DBRowSet dbRowset = null;
      List<ReportSearchVO> list = null;

      //query parameter
      Map<String, Object> param = new HashMap<String, Object>();
      param.put("startno", startNo);
	  param.put("endno", endNo);
      //velocity parameter
      Map<String, Object> velParam = new HashMap<String, Object>();
      velParam.put("startno", startNo);
      velParam.put("endno", endNo);

      try{

        if(reportSearchVO != null){
            String period_stdt = reportSearchVO.getPeriodStdt();
            period_stdt = period_stdt.replaceAll("-", "");
            String period_eddt = reportSearchVO.getPeriodEddt();
            period_eddt = period_eddt.replaceAll("-", "");

            List<String> arrLstmCd      = null;
            arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

            List<String> arrCntrTpszCd      = null;
            arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

            String strDetailLstmCd      = reportSearchVO.getDetailLstmCd();
            String strDetailVndrSeq     = reportSearchVO.getDetailVndrSeq();
            String strDetailCntrTpszCd  = reportSearchVO.getDetailCntrTpszCd();

            param.put("period_stdt"         , period_stdt);
            param.put("period_eddt"         , period_eddt);
            param.put("detail_lstm_cd"      , strDetailLstmCd);
            param.put("detail_vndr_seq"     , strDetailVndrSeq);
            param.put("detail_cntr_tpsz_cd" , strDetailCntrTpszCd);
            param.put("lstm_cd"             , arrLstmCd);
            param.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
            param.put("cntr_tpsz_cd"        , arrCntrTpszCd);
            param.put("cntr_tpsz_cd_str"    , reportSearchVO.getCntrTpszCd());
            param.put("vndr_seq"            , reportSearchVO.getVndrSeq());
            param.put("term_change"         , reportSearchVO.getTermChange());
            param.put("dii"                 , reportSearchVO.getDii());

            velParam.put("period_stdt"         , period_stdt);
            velParam.put("period_eddt"         , period_eddt);
            velParam.put("detail_lstm_cd"      , strDetailLstmCd);
            velParam.put("detail_vndr_seq"     , strDetailVndrSeq);
            velParam.put("detail_cntr_tpsz_cd" , strDetailCntrTpszCd);
            velParam.put("lstm_cd"             , arrLstmCd);
            velParam.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
            velParam.put("cntr_tpsz_cd"        , arrCntrTpszCd);
            velParam.put("cntr_tpsz_cd_str"    , reportSearchVO.getCntrTpszCd());
            velParam.put("vndr_seq"            , reportSearchVO.getVndrSeq());
            velParam.put("term_change"         , reportSearchVO.getTermChange());
            velParam.put("dii"                 , reportSearchVO.getDii());
        }

        dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOnHireResultbyTermLessorDetailRSQL(), param, velParam);
        list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

      }catch(SQLException se){
        log.error(se.getMessage(),se);
        throw new DAOException(new ErrorHandler(se).getMessage());
      }catch(Exception ex){
        log.error(ex.getMessage(),ex);
        throw new DAOException(new ErrorHandler(ex).getMessage());
      }
      return list;
    }

      /**
       * 임차장비 임차 (Off 장비) 실적을 조회<br>
       * (Off-Hire Result by Lease Term/Lessor-Option)
       * @param  ReportSearchVO reportSearchVO
       * @return List<ReportSearchVO>
       * @throws DAOException
       */
         @SuppressWarnings("unchecked")
      public List<ReportSearchVO> searchOffHireResultByTermLessorSummaryData (ReportSearchVO reportSearchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ReportSearchVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{

          if(reportSearchVO != null){
              String period_stdt = reportSearchVO.getPeriodStdt();
              period_stdt = period_stdt.replaceAll("-", "");
              String period_eddt = reportSearchVO.getPeriodEddt();
              period_eddt = period_eddt.replaceAll("-", "");

              List<String> arrLstmCd      = null;
              arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

              List<String> arrCntrTpszCd      = null;
              arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

              List<String> arrTysz   = null;
              arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getTysz(),",","|"));

              param.put("loc_cd"            , reportSearchVO.getLocCd());
              param.put("loc_tp"            , reportSearchVO.getLocTp());
              param.put("period_stdt"       , period_stdt);
              param.put("period_eddt"       , period_eddt);
              param.put("lstm_cd"           , arrLstmCd);
              param.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
              param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
              param.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
              param.put("vndr_seq"          , reportSearchVO.getVndrSeq());
              param.put("company"           , reportSearchVO.getCompany());
              param.put("tysz"              , arrTysz);
              param.put("term_change"       , reportSearchVO.getTermChange());
              param.put("dii"               , reportSearchVO.getDii());

              velParam.put("loc_cd"           , reportSearchVO.getLocCd());
              velParam.put("loc_tp"           , reportSearchVO.getLocTp());
              velParam.put("period_stdt"      , period_stdt);
              velParam.put("period_eddt"      , period_eddt);
              velParam.put("lstm_cd"          , arrLstmCd);
              velParam.put("lstm_cd_str"      , reportSearchVO.getLstmCd());
              velParam.put("cntr_tpsz_cd"     , arrCntrTpszCd);
              velParam.put("cntr_tpsz_cd_str" , reportSearchVO.getCntrTpszCd());
              velParam.put("vndr_seq"         , reportSearchVO.getVndrSeq());
              velParam.put("company"          , reportSearchVO.getCompany());
              velParam.put("tysz"             , arrTysz);
              velParam.put("term_change"      , reportSearchVO.getTermChange());
              velParam.put("dii"              , reportSearchVO.getDii());

          }
          dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireResultByTermLessorSummaryRSQL(), param, velParam);
          list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

        }catch(SQLException se){
          log.error(se.getMessage(),se);
          throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
          log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
      }

     /**
      * 임차장비 임차 (Off 장비) 실적의 전체건수 조회<br>
      * (Off-Hire Result by Lease Term/Lessor-Option)
      * @param  ReportSearchVO reportSearchVO
      * @return int
      * @throws DAOException
      */
      @SuppressWarnings("unchecked")
     public int searchOffHireResultByTermLessorCountData (ReportSearchVO reportSearchVO) throws DAOException {
    	int totalCnt = 0;
        DBRowSet dbRowset = null;

       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

       try{

         if(reportSearchVO != null){
             String period_stdt = reportSearchVO.getPeriodStdt();
             period_stdt = period_stdt.replaceAll("-", "");
             String period_eddt = reportSearchVO.getPeriodEddt();
             period_eddt = period_eddt.replaceAll("-", "");

             List<String> arrLstmCd      = null;
             arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

             List<String> arrCntrTpszCd      = null;
             arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

             String strDetailLstmCd      = reportSearchVO.getDetailLstmCd();
             String strDetailVndrSeq     = reportSearchVO.getDetailVndrSeq();
             String strDetailCntrTpszCd = reportSearchVO.getDetailCntrTpszCd();

             param.put("period_stdt"         , period_stdt);
             param.put("period_eddt"         , period_eddt);
             param.put("detail_lstm_cd"      , strDetailLstmCd);
             param.put("detail_vndr_seq"     , strDetailVndrSeq);
             param.put("detail_cntr_tpsz_cd" , strDetailCntrTpszCd);
             param.put("lstm_cd"           , arrLstmCd);
             param.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
             param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
             param.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
             param.put("vndr_seq"          , reportSearchVO.getVndrSeq());
             param.put("company"           , reportSearchVO.getCompany());
             param.put("term_change"       , reportSearchVO.getTermChange());
             param.put("dii"               , reportSearchVO.getDii());

             velParam.put("period_stdt"         , period_stdt);
             velParam.put("period_eddt"         , period_eddt);
             velParam.put("detail_lstm_cd"      , strDetailLstmCd);
             velParam.put("detail_vndr_seq"     , strDetailVndrSeq);
             velParam.put("detail_cntr_tpsz_cd" , strDetailCntrTpszCd);
             velParam.put("lstm_cd"           , arrLstmCd);
             velParam.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
             velParam.put("cntr_tpsz_cd"      , arrCntrTpszCd);
             velParam.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
             velParam.put("vndr_seq"          , reportSearchVO.getVndrSeq());
             velParam.put("company"           , reportSearchVO.getCompany());
             velParam.put("term_change"      , reportSearchVO.getTermChange());
             velParam.put("dii"              , reportSearchVO.getDii());
         }

         dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireResultByTermLessorCountRSQL(), param, velParam);
         if(dbRowset.next()) {
	    		totalCnt = dbRowset.getInt("TOTAL_CNT");
         }

       }catch(SQLException se){
         log.error(se.getMessage(),se);
         throw new DAOException(new ErrorHandler(se).getMessage());
       }catch(Exception ex){
         log.error(ex.getMessage(),ex);
         throw new DAOException(new ErrorHandler(ex).getMessage());
       }
       return totalCnt;
     }

      /**
       * 임차장비 임차 (Off 장비) 실적을 상세조회<br>
       * (Off-Hire Result by Lease Term/Lessor-Option)
       * @param  ReportSearchVO reportSearchVO
       * @param  SignOnUserAccount account
       * @return List<ReportSearchVO>
       * @throws DAOException
       */
       @SuppressWarnings("unchecked")
      public List<ReportSearchVO> searchOffHireResultByTermLessorDetailData (ReportSearchVO reportSearchVO, SignOnUserAccount account) throws DAOException {
    	 int currentPage = reportSearchVO.getIPage();
      	 int startNo = PAGE_SIZE_1000 * (currentPage -1) +1;
      	 int endNo   = PAGE_SIZE_1000 *  currentPage;
         DBRowSet dbRowset = null;
        List<ReportSearchVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("startno", startNo);
		param.put("endno", endNo);
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("startno", startNo);
        velParam.put("endno", endNo);

        try{

          if(reportSearchVO != null){
              String period_stdt = reportSearchVO.getPeriodStdt();
              period_stdt = period_stdt.replaceAll("-", "");
              String period_eddt = reportSearchVO.getPeriodEddt();
              period_eddt = period_eddt.replaceAll("-", "");

              List<String> arrLstmCd      = null;
              arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

              List<String> arrCntrTpszCd      = null;
              arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

              String strDetailLstmCd      = reportSearchVO.getDetailLstmCd();
              String strDetailVndrSeq     = reportSearchVO.getDetailVndrSeq();
              String strDetailCntrTpszCd = reportSearchVO.getDetailCntrTpszCd();

              param.put("period_stdt"         , period_stdt);
              param.put("period_eddt"         , period_eddt);
              param.put("detail_lstm_cd"      , strDetailLstmCd);
              param.put("detail_vndr_seq"     , strDetailVndrSeq);
              param.put("detail_cntr_tpsz_cd" , strDetailCntrTpszCd);
              param.put("lstm_cd"           , arrLstmCd);
              param.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
              param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
              param.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
              param.put("vndr_seq"          , reportSearchVO.getVndrSeq());
              param.put("company"           , reportSearchVO.getCompany());
              param.put("term_change"       , reportSearchVO.getTermChange());
              param.put("dii"               , reportSearchVO.getDii());
              param.put("usr_ofc_cd"         , account.getOfc_cd());

              velParam.put("period_stdt"         , period_stdt);
              velParam.put("period_eddt"         , period_eddt);
              velParam.put("detail_lstm_cd"      , strDetailLstmCd);
              velParam.put("detail_vndr_seq"     , strDetailVndrSeq);
              velParam.put("detail_cntr_tpsz_cd" , strDetailCntrTpszCd);
              velParam.put("lstm_cd"           , arrLstmCd);
              velParam.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
              velParam.put("cntr_tpsz_cd"      , arrCntrTpszCd);
              velParam.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
              velParam.put("vndr_seq"          , reportSearchVO.getVndrSeq());
              velParam.put("company"           , reportSearchVO.getCompany());
              velParam.put("term_change"      , reportSearchVO.getTermChange());
              velParam.put("dii"              , reportSearchVO.getDii());
              velParam.put("usr_ofc_cd"        , account.getOfc_cd());
          }

          dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireResultByTermLessorDetailRSQL(), param, velParam);
          list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

        }catch(SQLException se){
          log.error(se.getMessage(),se);
          throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
          log.error(ex.getMessage(),ex);
          throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
      }

      /**
       * 임차장비 임차 (Off 장비) 실적을 조회<br>
       * (Off-Hire Vs DOL)
       * @param  ReportSearchVO reportSearchVO
       * @return List<ReportSearchVO>
       * @throws DAOException
       */
       @SuppressWarnings("unchecked")
       public List<ReportSearchVO> searchOffHireResultvsDOLSummaryData(ReportSearchVO reportSearchVO) throws DAOException {
         DBRowSet dbRowset = null;
         List<ReportSearchVO> list = null;

         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         String strReportType = "";
         try{

           if(reportSearchVO != null){
               String year_month = reportSearchVO.getYearMonth();
               year_month = year_month.replaceAll("-", "");
               strReportType = reportSearchVO.getReportType();
               List<String> arrLstmCd      = null;
               arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

               List<String> arrCntrTpszCd      = null;
               arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

               List<String> arrTysz   = null;
               arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getTysz(),",","|"));

               param.put("year_month"          , year_month);
               param.put("report_type"         , reportSearchVO.getReportType());
               param.put("agmt_cty_cd"         , reportSearchVO.getAgmtCtyCd());
               param.put("agmt_seq"            , reportSearchVO.getAgmtSeq());
               param.put("loc_tp"              , reportSearchVO.getLocTp());
               param.put("loc_cd"              , reportSearchVO.getLocCd());
               param.put("lstm_cd"             , arrLstmCd);
               param.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
               param.put("cntr_tpsz_cd"        , arrCntrTpszCd);
               param.put("cntr_tpsz_cd_str"    , reportSearchVO.getCntrTpszCd());
               param.put("vndr_seq"            , reportSearchVO.getVndrSeq());
               param.put("period_stdt"         , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
               param.put("period_eddt"         , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
               param.put("tysz"                , arrTysz);
               param.put("term_change"         , reportSearchVO.getTermChange());
               param.put("dii"                 , reportSearchVO.getDii());

               velParam.put("year_month"          , year_month);
               velParam.put("report_type"         , reportSearchVO.getReportType());
               velParam.put("agmt_cty_cd"         , reportSearchVO.getAgmtCtyCd());
               velParam.put("agmt_seq"            , reportSearchVO.getAgmtSeq());
               velParam.put("loc_tp"              , reportSearchVO.getLocTp());
               velParam.put("loc_cd"              , reportSearchVO.getLocCd());
               velParam.put("lstm_cd"             , arrLstmCd);
               velParam.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
               velParam.put("cntr_tpsz_cd"        , arrCntrTpszCd);
               velParam.put("cntr_tpsz_cd_str"    , reportSearchVO.getCntrTpszCd());
               velParam.put("vndr_seq"            , reportSearchVO.getVndrSeq());
               velParam.put("period_stdt"         , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
               velParam.put("period_eddt"         , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
               velParam.put("tysz"                , arrTysz);
               velParam.put("term_change"         , reportSearchVO.getTermChange());
               velParam.put("dii"                 , reportSearchVO.getDii());
               velParam.put("rt_type"             , strReportType); //2010.10.14 Report Type추가
           }
/* 2010.10.14 by Agreement, by Location 쿼리 통합으로인해 변경
           if( strReportType != null && "A".equals(strReportType)){
        	   //Report type By Agreement
        	   dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireResultvsDOLSummary2RSQL(), param, velParam);
           }else{
        	   //Report type By Location
        	   dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireResultvsDOLSummaryRSQL(), param, velParam);
           }
*/
           dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireResultvsDOLSummaryRSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);


         }catch(SQLException se){
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
           log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
       }

       /**
        * 임차장비 임차 (Off 장비) 실적을 상세조회<br>
        * (Off-Hire Vs DOL)
        * @param  ReportSearchVO reportSearchVO
		* @param  SignOnUserAccount account
        * @return List<ReportSearchVO>
        * @throws DAOException
        */
        @SuppressWarnings("unchecked")
       public List<ReportSearchVO> searchOffHireResultvsDOLDetailData(ReportSearchVO reportSearchVO, SignOnUserAccount account) throws DAOException {

          DBRowSet dbRowset = null;
         List<ReportSearchVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{

           if(reportSearchVO != null){
               String year_month = reportSearchVO.getYearMonth();
               year_month = year_month.replaceAll("-", "");

               List<String> arrLstmCd      = null;
               arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

               List<String> arrCntrTpszCd      = null;
               arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

               param.put("year_month"          , year_month);
               param.put("report_type"         , reportSearchVO.getReportType());
               param.put("agmt_cty_cd"         , reportSearchVO.getAgmtCtyCd());
               param.put("agmt_seq"            , reportSearchVO.getAgmtSeq());
               param.put("loc_tp"              , reportSearchVO.getLocTp());
               param.put("loc_cd"              , reportSearchVO.getLocCd());
               param.put("detail_loc_cd"       , reportSearchVO.getDetailRcc());
               param.put("detail_sccc_cd"      , reportSearchVO.getDetailSccCd());
               param.put("detail_agmt_seq"     , reportSearchVO.getDetailAgmtSeq());
               param.put("lstm_cd"             , arrLstmCd);
               param.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
               param.put("cntr_tpsz_cd"        , arrCntrTpszCd);
               param.put("cntr_tpsz_cd_str"    , reportSearchVO.getCntrTpszCd());
               param.put("vndr_seq"            , reportSearchVO.getVndrSeq());
               param.put("detail_cntr_tpsz_cd" , reportSearchVO.getDetailCntrTpSz());
               param.put("period_stdt"         , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
               param.put("period_eddt"         , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
               param.put("term_change"         , reportSearchVO.getTermChange());
               param.put("dii"                 , reportSearchVO.getDii());
               param.put("term_change"         , reportSearchVO.getTermChange());
               param.put("dii"                 , reportSearchVO.getDii());
               param.put("usr_ofc_cd"          , account.getOfc_cd());
                
               velParam.put("year_month"          , year_month);
               velParam.put("report_type"         , reportSearchVO.getReportType());
               velParam.put("agmt_cty_cd"         , reportSearchVO.getAgmtCtyCd());
               velParam.put("agmt_seq"            , reportSearchVO.getAgmtSeq());
               velParam.put("loc_tp"              , reportSearchVO.getLocTp());
               velParam.put("loc_cd"              , reportSearchVO.getLocCd());
               velParam.put("detail_loc_cd"       , reportSearchVO.getDetailRcc());
               velParam.put("detail_sccc_cd"      , reportSearchVO.getDetailSccCd());
               velParam.put("detail_agmt_seq"     , reportSearchVO.getDetailAgmtSeq());
               velParam.put("lstm_cd"             , arrLstmCd);
               velParam.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
               velParam.put("cntr_tpsz_cd"        , arrCntrTpszCd);
               velParam.put("cntr_tpsz_cd_str"    , reportSearchVO.getCntrTpszCd());
               velParam.put("vndr_seq"            , reportSearchVO.getVndrSeq());
               velParam.put("detail_cntr_tpsz_cd" , reportSearchVO.getDetailCntrTpSz());
               velParam.put("period_stdt"         , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
               velParam.put("period_eddt"         , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
               velParam.put("term_change"         , reportSearchVO.getTermChange());
               velParam.put("dii"                 , reportSearchVO.getDii());
               velParam.put("term_change"         , reportSearchVO.getTermChange());
               velParam.put("dii"                 , reportSearchVO.getDii());
               velParam.put("usr_ofc_cd"          , account.getOfc_cd());
           }

           dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireResultvsDOLDetailRSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

         }catch(SQLException se){
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
       }

    /**
     * 선사의 관리하는 자가 및 임차장비의 현황목록을 조회합니다.<br>
     *
     * @param  SearchParamVO searchParamVO
     * @return List<InventorySummaryVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
    public List<InventorySummaryVO> searchTotalContainerInventorySummaryListData(SearchParamVO searchParamVO) throws DAOException {

      DBRowSet dbRowset = null;
      List<InventorySummaryVO> list = null;
      //query parameter
      Map<String, Object> param = new HashMap<String, Object>();
      //velocity parameter
      Map<String, Object> velParam = new HashMap<String, Object>();

      try{
        if(searchParamVO != null){
          Map<String, String> mapVO = searchParamVO.getColumnValues();

          param.putAll(mapVO);
          velParam.putAll(mapVO);

          List<String> arrLstmCd  = null;
          List<String> arrCntrTpszCd = null;
          List<String> arrCnMvStsCd = null;
          List<String> arrLsePayTpCd = null;

          if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
            arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
            param.put("lstm_cd_seq", arrLstmCd);
            velParam.put("lstm_cd_seq", arrLstmCd);
          }

          if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
            arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
            param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
            velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
          }

          if ( !JSPUtil.getNull(searchParamVO.getCnmvStsCd()).equals("") ) {
        	  arrCnMvStsCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCnmvStsCd(),",","|"));
              param.put("cnmv_sts_cd_seq", arrCnMvStsCd);
              velParam.put("cnmv_sts_cd_seq", arrCnMvStsCd);
            }
          
          if ( !JSPUtil.getNull(searchParamVO.getLsePayTpCd()).equals("") ) {
        	  arrLsePayTpCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLsePayTpCd(),",","|"));
              param.put("lse_pay_tp_cd_seq", arrLsePayTpCd);
              velParam.put("lse_pay_tp_cd_seq", arrLsePayTpCd);
            }
        }

        dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOTotalContainerInventorySummaryListRSQL(), param, velParam);
        list = (List)RowSetUtil.rowSetToVOs(dbRowset, InventorySummaryVO.class);
      }catch(SQLException se){
        log.error(se.getMessage(),se);
        throw new DAOException(new ErrorHandler(se).getMessage());
      }catch(Exception ex){
        log.error(ex.getMessage(),ex);
        throw new DAOException(new ErrorHandler(ex).getMessage());
      }
      return list;
    }

     /**
      * 선사의 관리하는 자가 및 임차장비의 상세 전체건수를 조회합니다.<br>
      *
      * @param  SearchParamVO searchParamVO
      * @return int
      * @throws DAOException
      */
      @SuppressWarnings("unchecked")
     public int searchTotalContainerInventoryCountData(SearchParamVO searchParamVO) throws DAOException {

       int totalCnt = 0;
  	   DBRowSet dbRowset = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

       try{
         if(searchParamVO != null){
           Map<String, String> mapVO = searchParamVO.getColumnValues();

           param.putAll(mapVO);
           velParam.putAll(mapVO);
           
           if(!"".equals(mapVO.get("g_ttl"))) {
        	   param.put("lstm_cd", "");
        	   velParam.put("lstm_cd", "");
           }

           List<String> arrLstmCd  = null;
           List<String> arrCntrTpszCd = null;
           List<String> arrCnMvStsCd = null;

           if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
        	   if("".equals(mapVO.get("g_ttl"))) {
        		   arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
        	 }else{
        		 arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(mapVO.get("g_ttl"),",","|"));
        	 }
        	   param.put("lstm_cd_seq", arrLstmCd);
    		   velParam.put("lstm_cd_seq", arrLstmCd);
           }

           if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
             arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
             param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
             velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
           }

           if ( !JSPUtil.getNull(searchParamVO.getCnmvStsCd()).equals("") ) {
         	  arrCnMvStsCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCnmvStsCd(),",","|"));
               param.put("cnmv_sts_cd_seq", arrCnMvStsCd);
               velParam.put("cnmv_sts_cd_seq", arrCnMvStsCd);
             }
         }

         dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOTotalContainerInventoryCountRSQL(), param, velParam);
         if(dbRowset.next()) {
	    		totalCnt = dbRowset.getInt("TOTAL_CNT");
         }
       }catch(SQLException se){
         log.error(se.getMessage(),se);
         throw new DAOException(new ErrorHandler(se).getMessage());
       }catch(Exception ex){
         log.error(ex.getMessage(),ex);
         throw new DAOException(new ErrorHandler(ex).getMessage());
       }
       return totalCnt;
     }

     /**
      * 선사의 관리하는 자가 및 임차장비의 상세내역을 조회합니다.<br>
      *
      * @param  SearchParamVO searchParamVO
      * @return List<InventoryDetailVO>
      * @throws DAOException
      */
      @SuppressWarnings("unchecked")
     public List<InventoryDetailVO> searchTotalContainerInventoryDetailData(SearchParamVO searchParamVO) throws DAOException {
    	  int currentPage = searchParamVO.getIPage();
    	  int startNo = PAGE_SIZE_5000 * (currentPage -1) +1;
    	  int endNo   = PAGE_SIZE_5000 *  currentPage;

       DBRowSet dbRowset = null;
       List<InventoryDetailVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

       try{
         if(searchParamVO != null){
           Map<String, String> mapVO = searchParamVO.getColumnValues();

           param.putAll(mapVO);
           param.put("startno", startNo);
		   param.put("endno", endNo);
           velParam.putAll(mapVO);
           velParam.put("startno", startNo);
           velParam.put("endno", endNo);

           List<String> arrLstmCd  = null;
           List<String> arrCntrTpszCd = null;
           List<String> arrCnMvStsCd = null;

           if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
        	   if("".equals(mapVO.get("g_ttl"))) {
        		   arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
        	 }else{
        		 arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(mapVO.get("g_ttl"),",","|"));
        	 }
            
             param.put("lstm_cd_seq", arrLstmCd);
             velParam.put("lstm_cd_seq", arrLstmCd);
           }

           if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
             arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
             param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
             velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
           }

           if ( !JSPUtil.getNull(searchParamVO.getCnmvStsCd()).equals("") ) {
         	  arrCnMvStsCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCnmvStsCd(),",","|"));
               param.put("cnmv_sts_cd_seq", arrCnMvStsCd);
               velParam.put("cnmv_sts_cd_seq", arrCnMvStsCd);
             }
         }

         dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOTotalContainerInventoryDetailRSQL(), param, velParam);
         list = (List)RowSetUtil.rowSetToVOs(dbRowset, InventoryDetailVO.class);
       }catch(SQLException se){
         log.error(se.getMessage(),se);
         throw new DAOException(new ErrorHandler(se).getMessage());
       }catch(Exception ex){
         log.error(ex.getMessage(),ex);
         throw new DAOException(new ErrorHandler(ex).getMessage());
       }
       return list;
     }

     /**
      * 신조장비여부 리스트 조회<br>
      * (Off-Hire Vs DOL)
      * @param  ReportSearchVO reportSearchVO
      * @return List<ReportSearchVO>
      * @throws DAOException
      */
      @SuppressWarnings("unchecked")
      public List<ReportSearchVO> searchNewContainerReceivingDetailData(ReportSearchVO reportSearchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ReportSearchVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{

          if(reportSearchVO != null){

              List<String> arrCntrTpszCd      = null;
              arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

              param.put("sn_eng_range1"       , reportSearchVO.getSnEngRange1());
              param.put("sn_num_range1"       , reportSearchVO.getSnNumRange1());
              param.put("sn_eng_range2"       , reportSearchVO.getSnEngRange2());
              param.put("sn_num_range2"       , reportSearchVO.getSnNumRange2());
              param.put("report_type"         , reportSearchVO.getReportType());
              param.put("cntr_tpsz_cd"        , arrCntrTpszCd);
              param.put("cntr_tpsz_cd_str"    , reportSearchVO.getCntrTpszCd());
              param.put("period_stdt"         , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
              param.put("period_eddt"         , reportSearchVO.getPeriodEddt().replaceAll("-", ""));

              velParam.put("sn_eng_range1"    , reportSearchVO.getSnEngRange1());
              velParam.put("sn_num_range1"    , reportSearchVO.getSnNumRange1());
              velParam.put("sn_eng_range2"    , reportSearchVO.getSnEngRange2());
              velParam.put("sn_num_range2"    , reportSearchVO.getSnNumRange2());
              velParam.put("report_type"      , reportSearchVO.getReportType());
              velParam.put("cntr_tpsz_cd"     , arrCntrTpszCd);
              velParam.put("cntr_tpsz_cd_str" , reportSearchVO.getCntrTpszCd());
              velParam.put("period_stdt"      , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
              velParam.put("period_eddt"      , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
          }

       	  dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchNewContainerReceivingDetailRSQL(), param, velParam);
          list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

        }catch(SQLException se){
          log.error(se.getMessage(),se);
          throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
          log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
      }

    /**
     * Sub Lease 자사장비 및 Mis Use 타사장비의 현황목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount account
	 * @return List<SubLeaseOutSummaryVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public List<SubLeaseOutSummaryVO> searchSubLeaseOutContainerSummaryListData(SearchParamVO searchParamVO, SignOnUserAccount account) throws DAOException {

	    DBRowSet dbRowset = null;
	    List<SubLeaseOutSummaryVO> list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try{
	    	if(searchParamVO != null){
		        Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);

				param.put("usr_ofc_cd", account.getOfc_cd());
		        velParam.put("usr_ofc_cd", account.getOfc_cd());
		        
		        List<String> arrLstmCd  = null;
		        List<String> arrCntrTpszCd = null;

		        if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
		        	arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
		        	param.put("lstm_cd_seq", arrLstmCd);
		        	velParam.put("lstm_cd_seq", arrLstmCd);
		        }

		        if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
		        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
		        	param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
		        	velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
		        }
		        
	    	} 
	    	
	    	dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOSubLeaseOutContainerSummaryListRSQL(), param, velParam);
	    	list = (List)RowSetUtil.rowSetToVOs(dbRowset, SubLeaseOutSummaryVO.class);
	    }catch(SQLException se){
	    	log.error(se.getMessage(),se);
	    	throw new DAOException(new ErrorHandler(se).getMessage());
	    }catch(Exception ex){
	    	log.error(ex.getMessage(),ex);
	    	throw new DAOException(new ErrorHandler(ex).getMessage());
	    }

	    return list;
    }

    /**
     * Sub Lease 자사장비 및 Mis Use 타사장비의 전체건수를 조회합니다.<br>
     *
     * @param  SearchParamVO searchParamVO
     * @return int
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public int searchSubLeaseOutContainerCountData(SearchParamVO searchParamVO) throws DAOException {

    	int totalCnt = 0;
	    DBRowSet dbRowset = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try{
	    	if(searchParamVO != null){
	    		Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        velParam.putAll(mapVO);

		        List<String> arrLstmCd  = null;
		        List<String> arrCntrTpszCd = null;

		        if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
		        	arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
		        	param.put("lstm_cd_seq", arrLstmCd);
		        	velParam.put("lstm_cd_seq", arrLstmCd);
		        }

		        if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
		        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
		        	param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
		        	velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
		        }
	    	}

	    	dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOSubLeaseOutContainerCountRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		totalCnt = dbRowset.getInt("TOTAL_CNT");
	    	}
	    }catch(SQLException se){
	    	log.error(se.getMessage(),se);
	    	throw new DAOException(new ErrorHandler(se).getMessage());
	    }catch(Exception ex){
	    	log.error(ex.getMessage(),ex);
	    	throw new DAOException(new ErrorHandler(ex).getMessage());
	    }

	    return totalCnt;
    }

    /**
     * Sub Lease 자사장비 및 Mis Use 타사장비의 상세내역을 조회합니다.<br>
     *
     * @param  SearchParamVO searchParamVO
     * @param  SignOnUserAccount account
     * @return List<SubLeaseOutDetailVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SubLeaseOutDetailVO> searchSubLeaseOutContainerDetailData(SearchParamVO searchParamVO, SignOnUserAccount account) throws DAOException {
    	int currentPage = searchParamVO.getIPage();
   	    int startNo = PAGE_SIZE_1000 * (currentPage -1) +1;
   	    int endNo   = PAGE_SIZE_1000 *  currentPage;

	    DBRowSet dbRowset = null;
	    List<SubLeaseOutDetailVO> list = null;
	    //query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

	    try{
	    	if(searchParamVO != null){
	    		Map<String, String> mapVO = searchParamVO.getColumnValues();

		        param.putAll(mapVO);
		        param.put("startno", startNo);
				param.put("endno", endNo);
				param.put("usr_ofc_cd", account.getOfc_cd());
		        velParam.putAll(mapVO);
		        velParam.put("startno", startNo);
		        velParam.put("endno", endNo);
		        velParam.put("usr_ofc_cd", account.getOfc_cd());

		        List<String> arrLstmCd  = null;
		        List<String> arrCntrTpszCd = null;

		        if ( !JSPUtil.getNull(searchParamVO.getLstmCd()).equals("") ) {
		        	arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getLstmCd(),",","|"));
		        	param.put("lstm_cd_seq", arrLstmCd);
		        	velParam.put("lstm_cd_seq", arrLstmCd);
		        }

		        if ( !JSPUtil.getNull(searchParamVO.getCntrTpszCd()).equals("") ) {
		        	arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getCntrTpszCd(),",","|"));
		        	param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
		        	velParam.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
		        }
	    	}
	    	dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOSubLeaseOutContainerDetailRSQL(), param, velParam);
	    	list = (List)RowSetUtil.rowSetToVOs(dbRowset, SubLeaseOutDetailVO.class);
	    }catch(SQLException se){
	    	log.error(se.getMessage(),se);
	    	throw new DAOException(new ErrorHandler(se).getMessage());
	    }catch(Exception ex){
	    	log.error(ex.getMessage(),ex);
	    	throw new DAOException(new ErrorHandler(ex).getMessage());
	    }

	    return list;
    }


    /**
     *  임차 실적을 RCC별로 조회<br>
     * (On-Hire Report Summary by RCC )
     * @param  ReportSearchVO reportSearchVO
     * @return List<ReportSearchVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
     public List<ReportSearchVO> searchOnHireReportbyRccSummaryData(ReportSearchVO reportSearchVO) throws DAOException {
       DBRowSet dbRowset = null;
       List<ReportSearchVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

       try{
         if(reportSearchVO != null){

             List<String> arrLstmCd = null;
             List<String> arrTysz   = null;

             arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));
             arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getTysz(),",","|"));

             param.put("loc_tp"              , reportSearchVO.getLocTp());
             param.put("loc_cd"              , reportSearchVO.getLocCd());
             param.put("lstm_cd"             , arrLstmCd);
             param.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
             param.put("period_stdt"         , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
             param.put("period_eddt"         , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
             param.put("tysz"                , arrTysz);
             param.put("term_change"         , reportSearchVO.getTermChange());
             param.put("dii"                 , reportSearchVO.getDii());

             velParam.put("loc_tp"           , reportSearchVO.getLocTp());
             velParam.put("loc_cd"           , reportSearchVO.getLocCd());
             velParam.put("lstm_cd"          , arrLstmCd);
             velParam.put("lstm_cd_str"      , reportSearchVO.getLstmCd());
             velParam.put("period_stdt"      , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
             velParam.put("period_eddt"      , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
             velParam.put("tysz"             , arrTysz);
             velParam.put("term_change"      , reportSearchVO.getTermChange());
             velParam.put("dii"              , reportSearchVO.getDii());
         }

      	  dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOnHireReportbyRccSummaryRSQL(), param, velParam);
         list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

       }catch(SQLException se){
         log.error(se.getMessage(),se);
         throw new DAOException(new ErrorHandler(se).getMessage());
       }catch(Exception ex){
         log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage());
       }
       return list;
     }

     /**
      * 월별로 임차한 실적을 조회<br>
      * (On-Hire Report Summary By Month )
      * @param  ReportSearchVO reportSearchVO
      * @return List<ReportSearchVO>
      * @throws DAOException
      */
      @SuppressWarnings("unchecked")
      public List<ReportSearchVO> searchOnHireReportbyMonthSummaryData(ReportSearchVO reportSearchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ReportSearchVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
          if(reportSearchVO != null){

        	  List<String> arrLstmCd = null;
              List<String> arrTysz   = null;

              arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));
              arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getTysz(),",","|"));

              param.put("loc_tp"              , reportSearchVO.getLocTp());
              param.put("loc_cd"              , reportSearchVO.getLocCd());
              param.put("lstm_cd"             , arrLstmCd);
              param.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
              param.put("period_stdt"         , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
              param.put("period_eddt"         , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
              param.put("tysz"                , arrTysz);
              param.put("term_change"         , reportSearchVO.getTermChange());
              param.put("dii"                 , reportSearchVO.getDii());

              velParam.put("loc_tp"           , reportSearchVO.getLocTp());
              velParam.put("loc_cd"           , reportSearchVO.getLocCd());
              velParam.put("lstm_cd"          , arrLstmCd);
              velParam.put("lstm_cd_str"      , reportSearchVO.getLstmCd());
              velParam.put("period_stdt"      , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
              velParam.put("period_eddt"      , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
              velParam.put("tysz"             , arrTysz);
              velParam.put("term_change"      , reportSearchVO.getTermChange());
              velParam.put("dii"              , reportSearchVO.getDii());
          }

       	  dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOnHireReportbyMonthSummaryRSQL(), param, velParam);
          list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

        }catch(SQLException se){
          log.error(se.getMessage(),se);
          throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
          log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
      }

      /**
       * 반납한 실적을 RCC별로 조회<br>
       * (Off Hire Report Summary by RCC)
       * @param  ReportSearchVO reportSearchVO
       * @return List<ReportSearchVO>
       * @throws DAOException
       */
       @SuppressWarnings("unchecked")
       public List<ReportSearchVO> searchOffHireReportbyRccSummaryData(ReportSearchVO reportSearchVO) throws DAOException {
         DBRowSet dbRowset = null;
         List<ReportSearchVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
           if(reportSearchVO != null){

        	   List<String> arrLstmCd = null;
               List<String> arrTysz   = null;

               arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));
               arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getTysz(),",","|"));

               param.put("loc_tp"              , reportSearchVO.getLocTp());
               param.put("loc_cd"              , reportSearchVO.getLocCd());
               param.put("lstm_cd"             , arrLstmCd);
               param.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
               param.put("period_stdt"         , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
               param.put("period_eddt"         , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
               param.put("tysz"                , arrTysz);
               param.put("term_change"       , reportSearchVO.getTermChange());
               param.put("dii"               , reportSearchVO.getDii());

               velParam.put("loc_tp"           , reportSearchVO.getLocTp());
               velParam.put("loc_cd"           , reportSearchVO.getLocCd());
               velParam.put("lstm_cd"          , arrLstmCd);
               velParam.put("lstm_cd_str"      , reportSearchVO.getLstmCd());
               velParam.put("period_stdt"      , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
               velParam.put("period_eddt"      , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
               velParam.put("tysz"             , arrTysz);
               velParam.put("term_change"      , reportSearchVO.getTermChange());
               velParam.put("dii"              , reportSearchVO.getDii());
           }

        	  dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireReportbyRccSummaryRSQL(), param, velParam);
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

         }catch(SQLException se){
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
           log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
       }

       /**
        * 반납한 실적을 RCC별로 조회<br>
        * (Off Hire Report Summary by RCC)
        * @param  ReportSearchVO reportSearchVO
        * @return List<ReportSearchVO>
        * @throws DAOException
        */
        @SuppressWarnings("unchecked")
        public List<ReportSearchVO> searchOffHireReportbyMonthSummaryData(ReportSearchVO reportSearchVO) throws DAOException {
          DBRowSet dbRowset = null;
          List<ReportSearchVO> list = null;
          //query parameter
          Map<String, Object> param = new HashMap<String, Object>();
          //velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();

          try{
            if(reportSearchVO != null){

            	List<String> arrLstmCd = null;
                List<String> arrTysz   = null;

                arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));
                arrTysz   = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getTysz(),",","|"));

                param.put("loc_tp"              , reportSearchVO.getLocTp());
                param.put("loc_cd"              , reportSearchVO.getLocCd());
                param.put("lstm_cd"             , arrLstmCd);
                param.put("lstm_cd_str"         , reportSearchVO.getLstmCd());
                param.put("period_stdt"         , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
                param.put("period_eddt"         , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
                param.put("tysz"                , arrTysz);
                param.put("term_change"         , reportSearchVO.getTermChange());
                param.put("dii"                 , reportSearchVO.getDii());

                velParam.put("loc_tp"           , reportSearchVO.getLocTp());
                velParam.put("loc_cd"           , reportSearchVO.getLocCd());
                velParam.put("lstm_cd"          , arrLstmCd);
                velParam.put("lstm_cd_str"      , reportSearchVO.getLstmCd());
                velParam.put("period_stdt"      , reportSearchVO.getPeriodStdt().replaceAll("-", ""));
                velParam.put("period_eddt"      , reportSearchVO.getPeriodEddt().replaceAll("-", ""));
                velParam.put("tysz"             , arrTysz);
                velParam.put("term_change"      , reportSearchVO.getTermChange());
                velParam.put("dii"              , reportSearchVO.getDii());
            }

         	  dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOffHireReportbyMonthSummaryRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

          }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
            log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
          return list;
        }

        /**
         * 년도별/계약별 자가 및 장기 장비 인수 계획 대비 실적 조회(LT의 경우)<br>
         *
         * @param  ReportSearchVO reportSearchVO
         * @return List<ReportSearchVO>
         * @throws DAOException
         */
         @SuppressWarnings("unchecked")
        public List<ReportSearchVO> searchOnHireTotalSummaryByLeaseTermYearData(ReportSearchVO reportSearchVO) throws DAOException {
          DBRowSet dbRowset = null;
          List<ReportSearchVO> list = null;

          //query parameter
          Map<String, Object> param = new HashMap<String, Object>();
          //velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();

          try{

            if(reportSearchVO != null){
                String period_stdt = reportSearchVO.getPeriodStdt();
                period_stdt = period_stdt.replaceAll("-", "");
                String period_eddt = reportSearchVO.getPeriodEddt();
                period_eddt = period_eddt.replaceAll("-", "");

                List<String> arrLocCd      = null;
                arrLocCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLocCd(),",","|"));

                List<String> arrLstmCd      = null;
                arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getLstmCd(),",","|"));

                List<String> arrCntrTpszCd      = null;
                arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getCntrTpszCd(),",","|"));

                List<String> arrVndrSeq      = null;
                arrVndrSeq = JSPUtil.convertStringToArrayList(JSPUtil.replace(reportSearchVO.getVndrSeq(),",","|"));

                param.put("loc_tp"            , reportSearchVO.getLocTp());
                param.put("period_stdt"       , period_stdt);
                param.put("period_eddt"       , period_eddt);
                param.put("loc_cd"            , arrLocCd );
                param.put("loc_cd_str"        , reportSearchVO.getLocCd());
                param.put("lstm_cd"           , arrLstmCd);
                param.put("lstm_cd_str"       , reportSearchVO.getLstmCd());
                param.put("cntr_tpsz_cd"      , arrCntrTpszCd);
                param.put("cntr_tpsz_cd_str"  , reportSearchVO.getCntrTpszCd());
                param.put("vndr_seq"          , arrVndrSeq);
                param.put("vndr_seq_str"      , reportSearchVO.getVndrSeq());

                velParam.put("loc_tp"           , reportSearchVO.getLocTp());
                velParam.put("period_stdt"      , period_stdt);
                velParam.put("period_eddt"      , period_eddt);
                velParam.put("loc_cd"           , arrLocCd );
                velParam.put("loc_cd_str"       , reportSearchVO.getLocCd());
                velParam.put("lstm_cd"          , arrLstmCd);
                velParam.put("lstm_cd_str"      , reportSearchVO.getLstmCd());
                velParam.put("cntr_tpsz_cd"     , arrCntrTpszCd);
                velParam.put("cntr_tpsz_cd_str" , reportSearchVO.getCntrTpszCd());
                velParam.put("vndr_seq"         , arrVndrSeq);
                velParam.put("vndr_seq_str"     , reportSearchVO.getVndrSeq());

            }
            dbRowset = new SQLExecuter("").executeQuery(new LeaseReportDBDAOsearchOnHireTotalSummaryByLeaseTermYearRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReportSearchVO.class);

          }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
          }
          return list;
        }
}