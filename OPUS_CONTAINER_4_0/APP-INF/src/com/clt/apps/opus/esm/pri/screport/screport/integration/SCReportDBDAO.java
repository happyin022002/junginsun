/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportDBDAO.java
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.06.25 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.screport.screport.basic.SCReportBCImpl;
import com.clt.apps.opus.esm.pri.screport.screport.vo.PriMotChgRtVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RptParaVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltMOTFileHeaderVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltPriMotChgRtVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltRptPropListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSCPrnVwRDInfoVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSCRetRDInfoVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchMOTSSEFilingListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchNoteCtntVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCBlListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCInfromationVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCMOTFilingListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceBulletListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailSumVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerfromanceVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCRateSearchBulletListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCRateSearchDARListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCRateSearchListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCTradeSubTradeLaneListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.SearchMOTFileVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpHdrVO;
import com.clt.syscommon.common.table.PriSpMnVO;



/**
 *  SCReportDBDAO <br>
 * - SCReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Byeon Young Joo
 * @see SCReportBCImpl 참조
 * @since J2EE 1.6
 */
public class SCReportDBDAO extends DBDAOSupport {

	/**
     * 대상 SC List 를 조회<br>
     * 
     * @param RptParaVO rptParaVO
     * @return List<RsltRptPropListVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRptPropListVO> searchReportProposalList (RptParaVO rptParaVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRptPropListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rptParaVO != null) {
                Map<String, String> mapVO = rptParaVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltRptPropListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRptPropListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * SC 기본 정보를 조회<br>
     * 
     * @param PriSpHdrVO priSpHdrVO
     * @return List<RsltRptPropListVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRptPropListVO> searchReportProposalInfo (PriSpHdrVO priSpHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRptPropListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priSpHdrVO != null) {
                Map<String, String> mapVO = priSpHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltRptPropInfoVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRptPropListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * Report 관련 정보를 조회<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @return List<RsltSCPrnVwRDInfoVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSCPrnVwRDInfoVO> searchSCPrintViewRDInfo (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws DAOException {
        log.debug("********************************searchSCPrintViewRDInfo - DBDAO");
        log.debug("********************************searchSCPrintViewRDInfo - DBDAO");
        log.debug("********************************searchSCPrintViewRDInfo - DBDAO");
        DBRowSet dbRowset = null;
        List<RsltSCPrnVwRDInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priSpMnVO != null) {
                Map<String, String> mapVO = priSpMnVO.getColumnValues();
				mapVO.put("usr_id",account.getUsr_id());
				mapVO.put("srep_cd",account.getSrep_cd());	
				mapVO.put("ofc_cd", account.getOfc_cd());
				mapVO.put("rhq_ofc_cd",account.getRhq_ofc_cd());	
				if (account.getRhq_ofc_cd().equals("HAMUR")
				    ||account.getRhq_ofc_cd().equals("NYCNA")
					||account.getRhq_ofc_cd().equals("SHAAS") ){
					velParam.put("rhq_yn", "Y");
				}else{
					velParam.put("rhq_yn", "N");
				}
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSCPrnVwRDInfoVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSCPrnVwRDInfoVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
     * MOT Filing List를 조회<br>
     * 
     * @param RsltSearchSCMOTFilingListVO rsltSearchSCMOTFilingListVO
     * @param SignOnUserAccount account
     * @return List<RsltSearchSCMOTFilingListVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchSCMOTFilingListVO> searchSCMOTFilingList (RsltSearchSCMOTFilingListVO rsltSearchSCMOTFilingListVO, SignOnUserAccount account) throws DAOException {
        log.debug("********************************searchSCMOTFilingList - DBDAO");

        DBRowSet dbRowset = null;
        List<RsltSearchSCMOTFilingListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltSearchSCMOTFilingListVO != null) {
            	log.debug("********************************************rsltSearchSCMOTFilingListVO != null");
                Map<String, String> mapVO = rsltSearchSCMOTFilingListVO.getColumnValues();
				mapVO.put("usr_id",account.getUsr_id());
				mapVO.put("srep_cd",account.getSrep_cd());	
				mapVO.put("ofc_cd", account.getOfc_cd());
				mapVO.put("rhq_ofc_cd",account.getRhq_ofc_cd());	
				if (account.getRhq_ofc_cd().equals("HAMUR")
				    ||account.getRhq_ofc_cd().equals("NYCNA")
					||account.getRhq_ofc_cd().equals("SHAAS") ){
					velParam.put("rhq_yn", "Y");
				}else{
					velParam.put("rhq_yn", "N");
				}
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCMOTFilingListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCMOTFilingListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    

    /**
     * Report 관련 정보를 조회<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @return List<RsltSCRetRDInfoVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSCRetRDInfoVO> searchSCRetrievalRDInfo (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSCRetRDInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priSpMnVO != null) {
                Map<String, String> mapVO = priSpMnVO.getColumnValues();
				mapVO.put("usr_id",account.getUsr_id());
				mapVO.put("srep_cd",account.getSrep_cd());	
				mapVO.put("ofc_cd", account.getOfc_cd());
				mapVO.put("rhq_ofc_cd",account.getRhq_ofc_cd());	
				if (account.getRhq_ofc_cd().equals("HAMUR")
				    ||account.getRhq_ofc_cd().equals("NYCNA")
					||account.getRhq_ofc_cd().equals("SHAAS") ){
					velParam.put("rhq_yn", "Y");
				}else{
					velParam.put("rhq_yn", "N");
				}
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSCRetRDInfoVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSCRetRDInfoVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * S/C List Inquiry 리스트를 조회<br>
     * 
     * @param RsltSearchSCListVO rsltSearchSCListVO
     * @return List<RsltSearchSCListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchSCListVO> searchSCList (RsltSearchSCListVO rsltSearchSCListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchSCListVO != null) {
                Map<String, String> mapVO = rsltSearchSCListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
	 * S/C List Inquiry sum 과 sc no 갯수를 조회한다.<br>
     * 
     * @param RsltSearchSCListVO rsltSearchSCListVO
     * @return List<RsltSearchSCListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchSCListVO> searchSCSumList (RsltSearchSCListVO rsltSearchSCListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchSCListVO != null) {
                Map<String, String> mapVO = rsltSearchSCListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCSumListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * S/C Performance Summary 리스트 조회를 한다.<br>
     * 
     * @param RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO
     * @return List<RsltSearchSCPerfromanceVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")    
    public List<RsltSearchSCPerfromanceVO> searchSCPerformanceSummaryList (RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCPerfromanceVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchSCPerfromanceVO != null) {
                Map<String, String> mapVO = rsltSearchSCPerfromanceVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            if (param.get("by_scope").equals("Y")) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCPerformanceSummaryByScopeListRSQL(), param, velParam);
            } else {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCPerformanceSummaryListRSQL(), param, velParam);
            }
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCPerfromanceVO.class);                
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
	 * S/C Performance Summary 리스트 조회를 위해 Single scope S/C의 count를 조회한다.<br>
     * 
     * @param RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO
     * @return List<RsltSearchSCPerfromanceVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")    
    public List<RsltSearchSCPerfromanceVO> searchSCPerformanceSummaryListScopeCnt (RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCPerfromanceVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchSCPerfromanceVO != null) {
                Map<String, String> mapVO = rsltSearchSCPerfromanceVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCPerformanceSummaryByScopeListScopeCntRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCPerfromanceVO.class);                
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
     * SC Performance Summary - View BL 리스트 조회한다.<br>
     * 
     * @param RsltSearchSCBlListVO rsltSearchSCBlListVO
     * @return List<RsltSearchSCBlListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")    
    public List<RsltSearchSCBlListVO> searchSCBlList (RsltSearchSCBlListVO rsltSearchSCBlListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCBlListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchSCBlListVO != null) {
                Map<String, String> mapVO = rsltSearchSCBlListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCBlListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCBlListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * SC Performance Summary - Detail 리스트를 조회한다.<br>
     * 
     * @param RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO
     * @return List<RsltSearchSCPerformanceDetailListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")    
    public List<RsltSearchSCPerformanceDetailListVO> searchSCPerformanceDetailList (RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCPerformanceDetailListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchSCPerformanceDetailListVO != null) {
                Map<String, String> mapVO = rsltSearchSCPerformanceDetailListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

 
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCPerformanceDetailListRSQL(), param, velParam);

 /*
            if ( 
            	(null != param.get("chk_gen_spcl_rt_tp_cd") && !param.get("chk_gen_spcl_rt_tp_cd").equals(""))
            	|| (null != param.get("chk_cmdt_nm") && !param.get("chk_cmdt_nm").equals(""))
            	|| (null != param.get("chk_act_cust_nm") && !param.get("chk_act_cust_nm").equals(""))
               ) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCPerformanceDetailListRSQL(), param, velParam);
            }else{
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCPerformanceDetailOnlyBookingListRSQL(), param, velParam);            	
            }
*/
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCPerformanceDetailListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * S/C Performance Summary - Detail 의 trade, sub trade, lane 콤보를 조회한다.<br>
     * 
     * @param RsltSearchSCTradeSubTradeLaneListVO rsltSearchSCTradeSubTradeLaneListVO
     * @return List<RsltSearchSCTradeSubTradeLaneListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchSCTradeSubTradeLaneListVO> searchSCTradeSubTradeLaneList (RsltSearchSCTradeSubTradeLaneListVO rsltSearchSCTradeSubTradeLaneListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCTradeSubTradeLaneListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltSearchSCTradeSubTradeLaneListVO != null) {
                Map<String, String> mapVO = rsltSearchSCTradeSubTradeLaneListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCTradeSubTradeLaneListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCTradeSubTradeLaneListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * 해당 SC NO 에 대한 기본 내용을 조회한다.<br>
     * 
     * @param RsltSearchSCInfromationVO rsltSearchSCInfromationVO
     * @return List<RsltSearchSCInfromationVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")    
    public List<RsltSearchSCInfromationVO> searchSCInfromation (RsltSearchSCInfromationVO rsltSearchSCInfromationVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCInfromationVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchSCInfromationVO != null) {
                Map<String, String> mapVO = rsltSearchSCInfromationVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCInfromationRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCInfromationVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * Commodity, actual 콤보 데이터를 조회한다. <br>
     * 
     * @param RsltSearchSCPerformanceBulletListVO rsltSearchSCPerformanceBulletListVO
     * @return List<RsltSearchSCPerformanceBulletListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchSCPerformanceBulletListVO> searchSCPerformanceBulletList (RsltSearchSCPerformanceBulletListVO rsltSearchSCPerformanceBulletListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCPerformanceBulletListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchSCPerformanceBulletListVO != null) {
                Map<String, String> mapVO = rsltSearchSCPerformanceBulletListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCPerformanceBulletListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCPerformanceBulletListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * S/C Performance Summary - S/C TOTAL 합계내용을 조회한다. <br>
     * 
     * @param RsltSearchSCPerformanceDetailSumVO rsltSearchSCPerformanceDetailSumVO
     * @return List<RsltSearchSCPerformanceDetailSumVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchSCPerformanceDetailSumVO> searchSCPerformanceDetailSum (RsltSearchSCPerformanceDetailSumVO rsltSearchSCPerformanceDetailSumVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCPerformanceDetailSumVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltSearchSCPerformanceDetailSumVO != null) {
                Map<String, String> mapVO = rsltSearchSCPerformanceDetailSumVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCPerformanceDetailSumRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCPerformanceDetailSumVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * Rate Search 리스트를 조회한다.<br>
     * 
     * @param RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO
     * @return List<RsltSearchSCRateSearchListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")    
    public List<RsltSearchSCRateSearchListVO> searchSCRateSearchList (RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCRateSearchListVO> list = null;        
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchSCRateSearchListVO != null) {
                Map<String, String> mapVO = rsltSearchSCRateSearchListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCRateSearchListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCRateSearchListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * Commodity, actual 콤보 데이터를 조회한다. <br>
     * 
     * @param RsltSearchSCRateSearchBulletListVO rsltSearchSCRateSearchBulletListVO
     * @return List<RsltSearchSCRateSearchBulletListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchSCRateSearchBulletListVO> searchSCRateSearchBulletList (RsltSearchSCRateSearchBulletListVO rsltSearchSCRateSearchBulletListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCRateSearchBulletListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltSearchSCRateSearchBulletListVO != null) {
                Map<String, String> mapVO = rsltSearchSCRateSearchBulletListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCRateSearchBulletListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCRateSearchBulletListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * Destinatnion Arbitrary Guideline Inquiry 리스트를 조회한다. <br>
     * 
     * @param RsltSearchSCRateSearchDARListVO rsltSearchSCRateSearchDARListVO
     * @return List<RsltSearchSCRateSearchDARListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchSCRateSearchDARListVO> searchSCRateSearchDARList (RsltSearchSCRateSearchDARListVO rsltSearchSCRateSearchDARListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCRateSearchDARListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchSCRateSearchDARListVO != null) {
                Map<String, String> mapVO = rsltSearchSCRateSearchDARListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCRateSearchDARListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCRateSearchDARListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * MOT/SSE Filing 을 위한 일자별 대상 BKG 을 가져와 해당 일자의 Log 데이터를 생성한다.
     * -  중복 제거 이전.<br>
     *
     * @param RsltSearchMOTSSEFilingListVO vo
     * @exception DAOException
     */
    public void createPriMotFileLogData(RsltSearchMOTSSEFilingListVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCReportDBDAOcreatePriMotFileLogDataCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
	 * MOT/SSE Filing 을 위한 일별 데이터 중 OFT 가 Null 이거나 Zero 인 경우에 대해 생성된 Surcharge Detail 삭제
	 * MOT Tariff Matching 을 위한 준비 과정.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO vo
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriMotFileRtLogDtlZeroOft(RsltSearchMOTSSEFilingListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAOremovePriMotFileRtLogDtlZeroOftDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

    /**
     * MOT/SSE Filing 을 위한 일별 데이터중에서 이전 Filing 되었던 것과 같은 건을 제거한 금일 Filing 대상 데이터 생성 한다.<br>
     *
     * @param RsltSearchMOTSSEFilingListVO vo
     * @exception DAOException
     */
    public void createPriMotFileRtData(RsltSearchMOTSSEFilingListVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCReportDBDAOcreatePriMotFileRtDataCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT
	 * 
	 * @param RsltSearchMOTSSEFilingListVO vo
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriMotFileRt(RsltSearchMOTSSEFilingListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAOremovePriMotFileRtDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT_SCG_DTL
	 * 
	 * @param RsltSearchMOTSSEFilingListVO vo
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriMotFileRtScgDtl(RsltSearchMOTSSEFilingListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAOremovePriMotFileRtScgDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT_LOG
	 * 
	 * @param RsltSearchMOTSSEFilingListVO vo
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriMotFileRtLog(RsltSearchMOTSSEFilingListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAOremovePriMotFileRtLogDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 기 실행된 MOT/SSE Filing List 삭제.<br>
	 * PRI_MOT_FILE_RT_LOG_DTL
	 * 
	 * @param RsltSearchMOTSSEFilingListVO vo
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriMotFileRtLogDtl(RsltSearchMOTSSEFilingListVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAOremovePriMotFileRtLogDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	//------------------------------------------
	// MOT Filing Commission START
	//------------------------------------------
	
	/**
	 * MDM_CHARGE 테이블의 MOT CHARGE를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchMotChargeCdList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCReportDBDAOMotChargeCdListRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * MOT Surcharge Creation정보를 조회한다.<br>
	 * 
     * @param RsltPriMotChgRtVO rsltPriMotChgRtVO
	 * @return List<PriMotChgRtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriMotChgRtVO> searchPriMotChgRt(RsltPriMotChgRtVO rsltPriMotChgRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriMotChgRtVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltPriMotChgRtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAOPriMotChgRtListRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriMotChgRtVO.class);
			
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
	 * MOT Surcharge Creation의 Max CHG_RT_SEQ 를 조회한다.<br>
	 * 
	 * @param RsltPriMotChgRtVO rsltPriMotChgRtVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchMaxChgRtSeqForPriMotChgRt(RsltPriMotChgRtVO rsltPriMotChgRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = rsltPriMotChgRtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCReportDBDAOMaxChgRtSeqForPriMotChgRtRSQL(), param, velParam);
			
			if(dbRowset.next()){
				result = dbRowset.getString("CHG_RT_SEQ");
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
	 * MOT Surcharge Creation 생성.<br>
	 * PRI_MOT_CHG_RT
	 * 
	 * @param List<PriMotChgRtVO> priMotChgRtVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriMotChgRt(List<PriMotChgRtVO> priMotChgRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int rowCnt[] = null;
			if(priMotChgRtVOs.size() > 0){
				rowCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMotChgRtVOCSQL(), priMotChgRtVOs,null);
				for(int i = 0; i < rowCnt.length; i++){
					if(rowCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * MOT Surcharge Creation 수정.<br>
	 * PRI_MOT_CHG_RT
	 * 
	 * @param List<PriMotChgRtVO> priMotChgRtVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void updatePriMotChgRt(List<PriMotChgRtVO> priMotChgRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int rowCnt[] = null;
			if(priMotChgRtVOs.size() > 0){
				rowCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMotChgRtVOUSQL(), priMotChgRtVOs,null);
				for(int i = 0; i < rowCnt.length; i++){
					if(rowCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * MOT Surcharge Creation 삭제.<br>
	 * PRI_MOT_CHG_RT
	 * 
	 * @param List<PriMotChgRtVO> priMotChgRtVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriMotChgRt(List<PriMotChgRtVO> priMotChgRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int rowCnt[] = null;
			if(priMotChgRtVOs.size() > 0){
				rowCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMotChgRtVODSQL(), priMotChgRtVOs,null);
				for(int i = 0; i < rowCnt.length; i++){
					if(rowCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	
	
	//------------------------------------------
	// MOT Filing Commission END
	//------------------------------------------
	
	//------------------------------------------
	// Filing List Inquiry(2015) START
	//------------------------------------------
	
	/**
	 * MOT Filing Commission의 Charge(Header용) 목록을 조회한다.<br>
	 * 
	 * @return List<RsltMOTFileHeaderVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltMOTFileHeaderVO> searchMOTChargesForHead() throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltMOTFileHeaderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{


			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCReportDBDAOPriMotChargesForHeadRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltMOTFileHeaderVO.class);


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
	 * MOT Filing Commission의 Charge 목록을 조회한다.<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchMOTCharges() throws DAOException {
		DBRowSet dbRowset = null;
		String result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{


			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCReportDBDAOPriMotChargesRSQL(), param, velParam);
			
			if(dbRowset.next()){
				result = dbRowset.getString("CHARGES");
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
     * MOT/SSE Filing Daily Log With Bkg No List 를  조회<br>
     * 
     * @param SearchMOTFileVO searchMOTFileVO
     * @param String sCharges
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchMOTFilingLogWithBkgList(SearchMOTFileVO searchMOTFileVO, String sCharges ) throws DAOException {

        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        //searchMOTFileVO.setChargeList(sCharges);

        try {
            if (searchMOTFileVO != null) {
                Map<String, String> mapVO = searchMOTFileVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            
            //Call SCReportDBDAORsltMOTFilingLogWithBkgListRSQL
            SCReportDBDAORsltMOTFilingLogWithBkgList squery = new SCReportDBDAORsltMOTFilingLogWithBkgList();
            squery.setReplace(sCharges);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)squery, param, velParam);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return dbRowset;
    }
    
    /**
     * MOT/SSE Filing Daily Log With Contract No List 를  조회<br>
     * 
     * @param SearchMOTFileVO searchMOTFileVO
     * @param String sCharges
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchMOTFilingLogList(SearchMOTFileVO searchMOTFileVO, String sCharges ) throws DAOException {

        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        //searchMOTFileVO.setChargeList(sCharges);

        try {
            if (searchMOTFileVO != null) {
                Map<String, String> mapVO = searchMOTFileVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            
            //Call SCReportDBDAORsltMOTFilingLogRSQL
            SCReportDBDAORsltMOTFilingLog squery = new SCReportDBDAORsltMOTFilingLog();
            squery.setReplace(sCharges);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)squery, param, velParam);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return dbRowset;
    }
    
    /**
     * MOT/SSE Filing Daily Log List 를  조회<br>
     * 
     * @param SearchMOTFileVO searchMOTFileVO
     * @param String sCharges
     * @return DBRowSet
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public DBRowSet searchMOTFilingList(SearchMOTFileVO searchMOTFileVO, String sCharges ) throws DAOException {

        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        //searchMOTFileVO.setChargeList(sCharges);

        try {
            if (searchMOTFileVO != null) {
                Map<String, String> mapVO = searchMOTFileVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            
            //Call SCReportDBDAORsltMOTFilingRSQL
            SCReportDBDAORsltMOTFiling squery = new SCReportDBDAORsltMOTFiling();
            squery.setReplace(sCharges);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)squery, param, velParam);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return dbRowset;
    }
	
	
	//------------------------------------------
	// Filing List Inquiry(2015) END
	//------------------------------------------
	
    /**
	 * retrive RFA/SC 's Commodity Note/Rate Note/Special Note.<br>
	 * 
	 * @param RsltSearchNoteCtntVO vo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchNoteCtnt(RsltSearchNoteCtntVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		String result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if (vo != null) {
                Map<String, String> mapVO = vo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCReportDBDAORsltNoteCtntRSQL(), param, velParam);
			if(dbRowset.next()){
				result = dbRowset.getString("NOTE_CTNT");
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
	
}