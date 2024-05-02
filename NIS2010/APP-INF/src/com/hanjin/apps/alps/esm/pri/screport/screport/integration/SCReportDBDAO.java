/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportDBDAO.java
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.06.25 변영주
* 1.0 Creation
* =========================================================
* History
* 2013.05.28 이혜민 [CHM-201324516-01] Surcharge 종합체계 구축 T/F - Surcharge Summary Report 화면 신규개발 
* 2013.06.24 송호진 [CHM-201324516] MDM_CHARGE 에 새로 추가된 MDT_RAT_FLG 적용
* 2014.02.26 전윤주 [CHM-201429075] Charge Summary Report_Detail view 조회 기능 추가    
* 2016.05.26 [CHM-201641700] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발
* 2016.09.07 [CHM-201642825] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식)
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.basic.SCReportBCImpl;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.PriMofMapgHisVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.PriMofMapgVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptParaVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportBlInquiryVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportSummaryViewVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltRptPropListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSCPrnVwRDInfoVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSCRetRDInfoVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchKoreaMOTListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOFLaneListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOFListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchMOTSSEFilingListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCBlListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCInfromationVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCMOTFilingListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCOutOfDateBkgListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceBulletListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailSumVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerfromanceVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchBulletListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchDARListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchDoorListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCTimelyRateListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCTradeSubTradeLaneListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.PriMotTrfMnVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;


/**
 * NIS2010 SCReportDBDAO <br>
 * - NIS2010-SCReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Byeon Young Joo
 * @see SCReportBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
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
				if (account.getRhq_ofc_cd().equals("HAMRU")
				    ||account.getRhq_ofc_cd().equals("NYCRA")
					||account.getRhq_ofc_cd().equals("SHARC") ){
					velParam.put("rhq_yn", "Y");
				}else{
					velParam.put("rhq_yn", "N");
				}
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                log.debug("[SCReportDBDAO.searchSCPrintViewRDInfo::velParam]\n"+velParam);
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
				if (account.getRhq_ofc_cd().equals("HAMRU")
				    ||account.getRhq_ofc_cd().equals("NYCRA")
					||account.getRhq_ofc_cd().equals("SHARC") ){
					velParam.put("rhq_yn", "Y");
				}else{
					velParam.put("rhq_yn", "N");
				}
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                log.debug("[SCReportDBDAO.searchSCMOTFilingList::velParam]\n"+velParam);
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
				if (account.getRhq_ofc_cd().equals("HAMRU")
				    ||account.getRhq_ofc_cd().equals("NYCRA")
					||account.getRhq_ofc_cd().equals("SHARC") ){
					velParam.put("rhq_yn", "Y");
				}else{
					velParam.put("rhq_yn", "N");
				}
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                log.debug("[SCReportDBDAO.searchSCRetrievalRDInfo::velParam]\n"+velParam);
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
     * US Route Cost Inquiry 리스트를 조회한다. <br>
     * 
     * @param RsltSearchSCRateSearchDoorListVO rsltSearchSCRateSearchDoorListVO
     * @return List<RsltSearchSCRateSearchDoorListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchSCRateSearchDoorListVO> searchSCRateSearchDoorList (RsltSearchSCRateSearchDoorListVO rsltSearchSCRateSearchDoorListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCRateSearchDoorListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchSCRateSearchDoorListVO != null) {
                Map<String, String> mapVO = rsltSearchSCRateSearchDoorListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchSCRateSearchDoorListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCRateSearchDoorListVO.class);
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
     * Office /  S’rep 별로  적기 계약  생성에 대한  결과 값을 조회<br>
     * 
     * @param RsltSearchSCTimelyRateListVO rsltSearchSCTimelyRateListVO
     * @return List<RsltSearchSCTimelyRateListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchSCTimelyRateListVO> searchTimelyRateCreationReport (RsltSearchSCTimelyRateListVO rsltSearchSCTimelyRateListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCTimelyRateListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltSearchSCTimelyRateListVO != null) {
                Map<String, String> mapVO = rsltSearchSCTimelyRateListVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchTimelyRateCreationReportRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCTimelyRateListVO.class);
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
     * 전체 대상 BKG 중 Batch Result 가 E (Error) 인 목록조회 <br>
     * 
     * @param RsltSearchSCOutOfDateBkgListVO rsltSearchSCOutOfDateBkgListVO
     * @return List<RsltSearchSCOutOfDateBkgListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchSCOutOfDateBkgListVO> searchTimelyOutOfDateBookingList(RsltSearchSCOutOfDateBkgListVO rsltSearchSCOutOfDateBkgListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchSCOutOfDateBkgListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltSearchSCOutOfDateBkgListVO != null) {
                Map<String, String> mapVO = rsltSearchSCOutOfDateBkgListVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchTimelyOutOfDateBookingListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchSCOutOfDateBkgListVO.class);
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
	 * Charge Summary Report - Summary View Tab을 조회한다.<br>
	 * 
	 * @param RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO
	 * @return List<RptSearchChargeSummaryReportSummaryViewVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RptSearchChargeSummaryReportSummaryViewVO> searchChargeSummaryReportSummaryView(RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RptSearchChargeSummaryReportSummaryViewVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String year = rptSearchChargeSummaryReportSummaryViewVO.getFYear();
		String frmweek = rptSearchChargeSummaryReportSummaryViewVO.getFFmWk();
		String toweek = rptSearchChargeSummaryReportSummaryViewVO.getFToWk();
		String frmmonth = rptSearchChargeSummaryReportSummaryViewVO.getFFmMon();
		String tomonth = rptSearchChargeSummaryReportSummaryViewVO.getFToMon();
		String fslsmon = rptSearchChargeSummaryReportSummaryViewVO.getFSlsMon();
		String startdt = rptSearchChargeSummaryReportSummaryViewVO.getStartDt();
		String enddt = rptSearchChargeSummaryReportSummaryViewVO.getEndDt();
		String gubun ="";
		
		try{
			if (rptSearchChargeSummaryReportSummaryViewVO != null) {
				//Week 선택시
				if(!year.equals("") && !frmweek.equals("") && !toweek.equals("")) {
					gubun = "1";
				//Month 선택시	
				}else if (!year.equals("") && !frmmonth.equals("") && !tomonth.equals("")) {
					gubun = "2";
				//Appl 선택시	
				}else if (!startdt.equals("") && !enddt.equals("")) {
					gubun ="3";
				}
				param.put("f_year", year);
				param.put("f_fm_wk", frmweek);
				param.put("f_to_wk", toweek);
				param.put("f_fm_mon", frmmonth);
				param.put("f_to_mon", tomonth);
				param.put("start_dt", startdt);
				param.put("end_dt", enddt);
				param.put("f_sls_mon", fslsmon);
				param.put("rep_chg_cd", rptSearchChargeSummaryReportSummaryViewVO.getRepChgCd());
				param.put("chg_cd", rptSearchChargeSummaryReportSummaryViewVO.getChgCd());
				param.put("mdtr_cd", rptSearchChargeSummaryReportSummaryViewVO.getMdtrCd());
				param.put("cust_clss", rptSearchChargeSummaryReportSummaryViewVO.getCustClss());
				param.put("cust_tp_cd", rptSearchChargeSummaryReportSummaryViewVO.getCustTpCd());
				param.put("cust_grp_id", rptSearchChargeSummaryReportSummaryViewVO.getCustGrpId());
				param.put("cust_cd", rptSearchChargeSummaryReportSummaryViewVO.getCustCd());
				param.put("svc_scp_cd", rptSearchChargeSummaryReportSummaryViewVO.getSvcScpCd());
				param.put("ctrt_ofc_cd", rptSearchChargeSummaryReportSummaryViewVO.getCtrtOfcCd());
				param.put("per_cd", rptSearchChargeSummaryReportSummaryViewVO.getPerCd());
				param.put("rhq_cd", rptSearchChargeSummaryReportSummaryViewVO.getRhqCd());
				
				velParam.put("f_sls_mon", fslsmon);
				velParam.put("rep_chg_cd", rptSearchChargeSummaryReportSummaryViewVO.getRepChgCd());
				velParam.put("chg_cd", rptSearchChargeSummaryReportSummaryViewVO.getChgCd());
				velParam.put("mdtr_cd", rptSearchChargeSummaryReportSummaryViewVO.getMdtrCd());
				velParam.put("cust_clss", rptSearchChargeSummaryReportSummaryViewVO.getCustClss());
				velParam.put("cust_tp_cd", rptSearchChargeSummaryReportSummaryViewVO.getCustTpCd());
				velParam.put("cust_grp_id", rptSearchChargeSummaryReportSummaryViewVO.getCustGrpId());
				velParam.put("cust_cd", rptSearchChargeSummaryReportSummaryViewVO.getCustCd());
				velParam.put("svc_scp_cd", rptSearchChargeSummaryReportSummaryViewVO.getSvcScpCd());
				velParam.put("ctrt_ofc_cd", rptSearchChargeSummaryReportSummaryViewVO.getCtrtOfcCd());
				velParam.put("per_cd", rptSearchChargeSummaryReportSummaryViewVO.getPerCd());
				velParam.put("rhq_cd", rptSearchChargeSummaryReportSummaryViewVO.getRhqCd());
                velParam.put("gubun", gubun);
            }
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCReportDBDAOSearchChargeSummaryReportSummaryViewRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RptSearchChargeSummaryReportSummaryViewVO.class);
			
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
	 * 입력한 OFC 유효성을 검증한다.<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchOfcValid(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCReportDBDAOSearchOfcValidRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnStr = dbRowset.getString("CNT");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnStr;
	}
	
	/**
	 * Charge Summary Report - Detail View Tab을 조회한다.<br>
	 * 
	 * @param RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO
	 * @return List<RptSearchChargeSummaryReportSummaryViewVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RptSearchChargeSummaryReportSummaryViewVO> searchChargeSummaryReportDetailView(RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RptSearchChargeSummaryReportSummaryViewVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String year = rptSearchChargeSummaryReportSummaryViewVO.getFYear();
		String frmweek = rptSearchChargeSummaryReportSummaryViewVO.getFFmWk();
		String toweek = rptSearchChargeSummaryReportSummaryViewVO.getFToWk();
		String frmmonth = rptSearchChargeSummaryReportSummaryViewVO.getFFmMon();
		String tomonth = rptSearchChargeSummaryReportSummaryViewVO.getFToMon();
		String fslsmon = rptSearchChargeSummaryReportSummaryViewVO.getFSlsMon();
		String startdt = rptSearchChargeSummaryReportSummaryViewVO.getStartDt();
		String enddt = rptSearchChargeSummaryReportSummaryViewVO.getEndDt();
		String gubun ="";
		
		try{
			if (rptSearchChargeSummaryReportSummaryViewVO != null) {
				//Week 선택시
				if(!year.equals("") && !frmweek.equals("") && !toweek.equals("")) {
					gubun = "1";
				//Month 선택시	
				}else if (!year.equals("") && !frmmonth.equals("") && !tomonth.equals("")) {
					gubun = "2";
				//Appl 선택시	
				}else if (!startdt.equals("") && !enddt.equals("")) {
					gubun ="3";
				}
				param.put("f_year", year);
				param.put("f_fm_wk", frmweek);
				param.put("f_to_wk", toweek);
				param.put("f_fm_mon", frmmonth);
				param.put("f_to_mon", tomonth);
				param.put("start_dt", startdt);
				param.put("end_dt", enddt);
				param.put("f_sls_mon", fslsmon);
				param.put("chg_cd", rptSearchChargeSummaryReportSummaryViewVO.getChgCd());
				param.put("bkg_ofc_cd", rptSearchChargeSummaryReportSummaryViewVO.getBkgOfcCd());
				param.put("por_cd", rptSearchChargeSummaryReportSummaryViewVO.getPorCd());
				param.put("pol_cd", rptSearchChargeSummaryReportSummaryViewVO.getPolCd());
				param.put("pod_cd", rptSearchChargeSummaryReportSummaryViewVO.getPodCd());
				param.put("del_cd", rptSearchChargeSummaryReportSummaryViewVO.getDelCd());
				param.put("svc_scp_cd", rptSearchChargeSummaryReportSummaryViewVO.getSvcScpCd());
				param.put("rhq_cd", rptSearchChargeSummaryReportSummaryViewVO.getRhqCd());
				param.put("per_cd", rptSearchChargeSummaryReportSummaryViewVO.getPerCd());
				param.put("cgo_cate_cd", rptSearchChargeSummaryReportSummaryViewVO.getCgoCateCd());
				param.put("mdtr_cd", rptSearchChargeSummaryReportSummaryViewVO.getMdtrCd());
				
				velParam.put("f_sls_mon", fslsmon);
				velParam.put("chg_cd", rptSearchChargeSummaryReportSummaryViewVO.getChgCd());
				velParam.put("bkg_ofc_cd", rptSearchChargeSummaryReportSummaryViewVO.getBkgOfcCd());
				velParam.put("por_cd", rptSearchChargeSummaryReportSummaryViewVO.getPorCd());
				velParam.put("pol_cd", rptSearchChargeSummaryReportSummaryViewVO.getPolCd());
				velParam.put("pod_cd", rptSearchChargeSummaryReportSummaryViewVO.getPodCd());
				velParam.put("del_cd", rptSearchChargeSummaryReportSummaryViewVO.getDelCd());
				velParam.put("svc_scp_cd", rptSearchChargeSummaryReportSummaryViewVO.getSvcScpCd());
				velParam.put("rhq_cd", rptSearchChargeSummaryReportSummaryViewVO.getRhqCd());
				velParam.put("per_cd", rptSearchChargeSummaryReportSummaryViewVO.getPerCd());
				velParam.put("cgo_cate_cd", rptSearchChargeSummaryReportSummaryViewVO.getCgoCateCd());
				velParam.put("mdtr_cd", rptSearchChargeSummaryReportSummaryViewVO.getMdtrCd());
                velParam.put("gubun", gubun);
            }
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCReportDBDAOSearchChargeSummaryReportDetailViewRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RptSearchChargeSummaryReportSummaryViewVO.class);
			
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
	 * Charge Summary Report - BL Inquiry 조회한다.<br>
	 * 
	 * @param RptSearchChargeSummaryReportBlInquiryVO rptSearchChargeSummaryReportBlInquiryVO
	 * @return List<RptSearchChargeSummaryReportBlInquiryVO>
	 * @exception DAOException
	 */
	public DBRowSet searchChargeSummaryBlInquiry(RptSearchChargeSummaryReportBlInquiryVO rptSearchChargeSummaryReportBlInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String year = rptSearchChargeSummaryReportBlInquiryVO.getFYear();
		String frmweek = rptSearchChargeSummaryReportBlInquiryVO.getFFmWk();
		String toweek = rptSearchChargeSummaryReportBlInquiryVO.getFToWk();
		String frmmonth = rptSearchChargeSummaryReportBlInquiryVO.getFFmMon();
		String tomonth = rptSearchChargeSummaryReportBlInquiryVO.getFToMon();
		String fslsmon = rptSearchChargeSummaryReportBlInquiryVO.getFSlsMon();
		String startdt = rptSearchChargeSummaryReportBlInquiryVO.getStartDt();
		String enddt = rptSearchChargeSummaryReportBlInquiryVO.getEndDt();
		String uiId = rptSearchChargeSummaryReportBlInquiryVO.getUiId();
		String fExcel = rptSearchChargeSummaryReportBlInquiryVO.getFExcel();
		String gubun = "";
		
		try{
			if (rptSearchChargeSummaryReportBlInquiryVO != null) {
				//Week 선택시
				if(!year.equals("") && !frmweek.equals("") && !toweek.equals("")) {
					gubun = "1";
				//Month 선택시	
				}else if (!year.equals("") && !frmmonth.equals("") && !tomonth.equals("")) {
					gubun = "2";
				//Appl 선택시	
				}else if (!startdt.equals("") && !enddt.equals("")) {
					gubun ="3";
				}
				param.put("f_year", year);
				param.put("f_fm_wk", frmweek);
				param.put("f_to_wk", toweek);
				param.put("f_fm_mon", frmmonth);
				param.put("f_to_mon", tomonth);
				param.put("start_dt", startdt);
				param.put("end_dt", enddt);
				param.put("f_sls_mon", fslsmon);
				param.put("rvis_cntr_cust_tp_cd", rptSearchChargeSummaryReportBlInquiryVO.getRvisCntrCustTpCd());
				param.put("ctrt_cust_cnt_cd", rptSearchChargeSummaryReportBlInquiryVO.getCtrtCustCntCd());
				param.put("ctrt_cust_seq", rptSearchChargeSummaryReportBlInquiryVO.getCtrtCustSeq());
				param.put("rep_chg_cd", rptSearchChargeSummaryReportBlInquiryVO.getRepChgCd());
				param.put("chg_cd", rptSearchChargeSummaryReportBlInquiryVO.getChgCd());
				param.put("mdtr_cd", rptSearchChargeSummaryReportBlInquiryVO.getMdtrCd());
				param.put("cust_clss", rptSearchChargeSummaryReportBlInquiryVO.getCustClss());
				param.put("cust_tp_cd", rptSearchChargeSummaryReportBlInquiryVO.getCustTpCd());
				param.put("cust_grp_id", rptSearchChargeSummaryReportBlInquiryVO.getCustGrpId());
				param.put("cust_cd", rptSearchChargeSummaryReportBlInquiryVO.getCustCd());
				param.put("svc_scp_cd", rptSearchChargeSummaryReportBlInquiryVO.getSvcScpCd());
				param.put("ctrt_ofc_cd", rptSearchChargeSummaryReportBlInquiryVO.getCtrtOfcCd());
				param.put("per_cd", rptSearchChargeSummaryReportBlInquiryVO.getPerCd());
				param.put("rhq_cd", rptSearchChargeSummaryReportBlInquiryVO.getRhqCd());
				param.put("bkg_ofc_cd", rptSearchChargeSummaryReportBlInquiryVO.getBkgOfcCd());
				param.put("por_cd", rptSearchChargeSummaryReportBlInquiryVO.getPorCd());
				param.put("pol_cd", rptSearchChargeSummaryReportBlInquiryVO.getPolCd());
				param.put("pod_cd", rptSearchChargeSummaryReportBlInquiryVO.getPodCd());
				param.put("del_cd", rptSearchChargeSummaryReportBlInquiryVO.getDelCd());
				param.put("cgo_cate_cd", rptSearchChargeSummaryReportBlInquiryVO.getCgoCateCd());
				
				velParam.put("f_sls_mon", fslsmon);
				velParam.put("rvis_cntr_cust_tp_cd", rptSearchChargeSummaryReportBlInquiryVO.getRvisCntrCustTpCd());
				velParam.put("ctrt_cust_cnt_cd", rptSearchChargeSummaryReportBlInquiryVO.getCtrtCustCntCd());
				velParam.put("ctrt_cust_seq", rptSearchChargeSummaryReportBlInquiryVO.getCtrtCustSeq());
				velParam.put("rep_chg_cd", rptSearchChargeSummaryReportBlInquiryVO.getRepChgCd());
				velParam.put("chg_cd", rptSearchChargeSummaryReportBlInquiryVO.getChgCd());
				velParam.put("mdtr_cd", rptSearchChargeSummaryReportBlInquiryVO.getMdtrCd());
				velParam.put("cust_clss", rptSearchChargeSummaryReportBlInquiryVO.getCustClss());
				velParam.put("cust_tp_cd", rptSearchChargeSummaryReportBlInquiryVO.getCustTpCd());
				velParam.put("cust_grp_id", rptSearchChargeSummaryReportBlInquiryVO.getCustGrpId());
				velParam.put("cust_cd", rptSearchChargeSummaryReportBlInquiryVO.getCustCd());
				velParam.put("svc_scp_cd", rptSearchChargeSummaryReportBlInquiryVO.getSvcScpCd());
				velParam.put("ctrt_ofc_cd", rptSearchChargeSummaryReportBlInquiryVO.getCtrtOfcCd());
				velParam.put("per_cd", rptSearchChargeSummaryReportBlInquiryVO.getPerCd());
				velParam.put("rhq_cd", rptSearchChargeSummaryReportBlInquiryVO.getRhqCd());
				velParam.put("bkg_ofc_cd", rptSearchChargeSummaryReportBlInquiryVO.getBkgOfcCd());
				velParam.put("por_cd", rptSearchChargeSummaryReportBlInquiryVO.getPorCd());
				velParam.put("pol_cd", rptSearchChargeSummaryReportBlInquiryVO.getPolCd());
				velParam.put("pod_cd", rptSearchChargeSummaryReportBlInquiryVO.getPodCd());
				velParam.put("del_cd", rptSearchChargeSummaryReportBlInquiryVO.getDelCd());
				velParam.put("cgo_cate_cd", rptSearchChargeSummaryReportBlInquiryVO.getCgoCateCd());
				velParam.put("ui_id", uiId);
				velParam.put("gubun", gubun);
				velParam.put("f_excel", fExcel);
                
            }
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCReportDBDAOSearchChargeSummaryReportBlInquiryRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * charge 리스트를 조회합니다.<br>
	 * 
	 * @param MdmChargeVO mdmChargeVO
	 * @return List<MdmChargeVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws DAOException {
		List<MdmChargeVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (mdmChargeVO != null) {
				Map<String, String> mapVO = mdmChargeVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltMdmChargeListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmChargeVO.class);
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
     * MOT/SSE Filing Daily List 를  조회<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @return List<RsltSearchMOTSSEFilingListVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchMOTSSEFilingListVO> searchMOTSSEFilingDailyList (RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws DAOException {
        log.debug("********************************searchMOTSSEFilingSCList - DBDAO");

        DBRowSet dbRowset = null;
        List<RsltSearchMOTSSEFilingListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltSearchMOTSSEFilingListVO != null) {
            	log.debug("********************************************rsltSearchMOTSSEFilingListVO != null");
                Map<String, String> mapVO = rsltSearchMOTSSEFilingListVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchMOTSSEFilingDailyListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchMOTSSEFilingListVO.class);
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
     * MOT/SSE Filing Daily Log List 를  조회<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @return List<RsltSearchMOTSSEFilingListVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchMOTSSEFilingListVO> searchMOTSSEFilingDailyLogList (RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws DAOException {
        log.debug("********************************searchMOTSSEFilingSCList - DBDAO");

        DBRowSet dbRowset = null;
        List<RsltSearchMOTSSEFilingListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltSearchMOTSSEFilingListVO != null) {
            	log.debug("********************************************rsltSearchMOTSSEFilingListVO != null");
                Map<String, String> mapVO = rsltSearchMOTSSEFilingListVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchMOTSSEFilingDailyLogListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchMOTSSEFilingListVO.class);
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
     * MOT/SSE Filing Daily Log With Bkg No List 를  조회<br>
     * 
     * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
     * @return List<RsltSearchMOTSSEFilingListVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchMOTSSEFilingListVO> searchMOTSSEFilingDailyLogWithBkgList (RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO ) throws DAOException {
        log.debug("********************************searchMOTSSEFilingSCList - DBDAO");

        DBRowSet dbRowset = null;
        List<RsltSearchMOTSSEFilingListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltSearchMOTSSEFilingListVO != null) {
            	log.debug("********************************************rsltSearchMOTSSEFilingListVO != null");
                Map<String, String> mapVO = rsltSearchMOTSSEFilingListVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchMOTSSEFilingDailyLogWithBkgListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchMOTSSEFilingListVO.class);
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
     * MOT/SSE Filing 을 위한 일별 데이터 중에서 OFT 가 Null or Zero 인 경우에 대해 MOT Tariff 정보를 Matching 시켜 해당 Surcharge Data 를 복제 생성  한다.<br>
     *
     * @param RsltSearchMOTSSEFilingListVO vo
     * @exception DAOException
     */
    public void createPriMotFileRtLogDtlMatchingTariff(RsltSearchMOTSSEFilingListVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCReportDBDAOcreatePriMotFileRtLogDtlMatchingTariffCSQL(), param,
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
     * MOT/SSE Filing 을 위한 일별 데이터 중에서 OFT 가 Null or Zero 인 경우들에 대해 MOT Tariff 를 Matching 하여 OFT 와 Remark 를 Update 한다.<br>
     *
     * @param RsltSearchMOTSSEFilingListVO vo
     * @exception DAOException
     */
    public void mergePriMotFileRtLogOFT(RsltSearchMOTSSEFilingListVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCReportDBDAOmergePriMotFileRtLogOFTUSQL(), param,
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



	/**
	 * MOT Tariff List 를  조회 합니다.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @return List<RsltSearchMOTSSEFilingListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltSearchMOTSSEFilingListVO> searchMOTSSETariffList(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSearchMOTSSEFilingListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltSearchMOTSSEFilingListVO != null){
				Map<String, String> mapVO = rsltSearchMOTSSEFilingListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCReportDBDAORsltMOTSSETariffListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSearchMOTSSEFilingListVO .class);
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
	 * MOT Tariff List 를  생성 합니다.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addMOTSSETariffList(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltSearchMOTSSEFilingListVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAORsltSearchMOTSSEFilingListVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * MOT Tariff List 를  변경 합니다.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyMOTSSETariffList(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = rsltSearchMOTSSEFilingListVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAORsltSearchMOTSSEFilingListVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * MOT Tariff List 를  삭제  합니다.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removeMOTSSETariffList(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = rsltSearchMOTSSEFilingListVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAORsltSearchMOTSSEFilingListVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * MOT Tariff List 를  다건 생성 합니다.<br>
	 * 
	 * @param List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addMOTSSETariffListS(List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOTSSEFilingListVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAORsltSearchMOTSSEFilingListVOCSQL(), rsltSearchMOTSSEFilingListVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * MOT Tariff List 를  다건 변경  합니다.<br>
	 * 
	 * @param List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyMOTSSETariffListS(List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOTSSEFilingListVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAORsltSearchMOTSSEFilingListVOUSQL(), rsltSearchMOTSSEFilingListVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * MOT Tariff List 를  다건 삭제  합니다.<br>
	 * 
	 * @param List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeMOTSSETariffListS(List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOTSSEFilingListVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAORsltSearchMOTSSEFilingListVODSQL(), rsltSearchMOTSSEFilingListVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * 선택된 Service Scope에 등록된 MOT Tariff 리스트를 조회한다.<br>
	 * 
	 * @param RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO
	 * @return List<RsltSearchMOTSSEFilingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltSearchMOTSSEFilingListVO> searchMotTrfScopeEffectiveDateList(RsltSearchMOTSSEFilingListVO rsltSearchMOTSSEFilingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSearchMOTSSEFilingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltSearchMOTSSEFilingListVO != null) {
				Map<String, String> mapVO = rsltSearchMOTSSEFilingListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCReportDBDAORsltMotTrfSeqEffDtListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchMOTSSEFilingListVO.class);
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
	 * MOT Base Port List 를 조회합니다.<br>
	 * 
	 * @param String svcScpCd
	 * @param String orgDestTpCd
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchMotBsePortList(String svcScpCd, String orgDestTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (orgDestTpCd != null ) {
				param.put( "svc_scp_cd", svcScpCd);
				param.put( "org_dest_tp_cd", orgDestTpCd);
				velParam.put( "org_dest_tp_cd", orgDestTpCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltMotBsePortListRSQL(), param, velParam);
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
	 * PRI_MOT_TRF_MN 을 생성 합니다.<br>
	 * 
	 * @param PriMotTrfMnVO priMotTrfMnVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPriMotTrfMn(PriMotTrfMnVO priMotTrfMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priMotTrfMnVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAOPriMotTrfMnCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PRI_MOT_TRF_MN 을 수정 합니다.<br>
	 * 
	 * @param PriMotTrfMnVO priMotTrfMnVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyPriMotTrfMn(PriMotTrfMnVO priMotTrfMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priMotTrfMnVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAOPriMotTrfMnUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PRI_MOT_TRF_MN 을 삭제 합니다.<br>
	 * 
	 * @param PriMotTrfMnVO priMotTrfMnVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriMotTrfMn(PriMotTrfMnVO priMotTrfMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priMotTrfMnVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAOPriMotTrfMnDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PRI_MOT_TRF_RT 를 다건 생성 합니다.<br>
	 * 
	 * @param List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriMotTrfRtList(List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOTSSEFilingListVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMotTrfRtCSQL(), rsltSearchMOTSSEFilingListVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * PRI_MOT_TRF_RT 를 다건 변경 합니다.<br>
	 * 
	 * @param List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyPriMotTrfRtList(List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOTSSEFilingListVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMotTrfRtUSQL(), rsltSearchMOTSSEFilingListVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * PRI_MOT_TRF_RT 를 다건 삭제 합니다.<br>
	 * 
	 * @param List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removePriMotTrfRtList(List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOTSSEFilingListVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMotTrfRtDSQL(), rsltSearchMOTSSEFilingListVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	
	/**
	 * 하나의 PRI_MOT_TRF_MN 에 연결되어 있는 모든 PRI_MOT_TRF_RT 를  일괄 삭제 합니다.<br>
	 * 
	 * @param PriMotTrfMnVO priMotTrfMnVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriMotTrfRtAll(PriMotTrfMnVO priMotTrfMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priMotTrfMnVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAOremovePriMotTrfRtAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * PRI_MOT_TRF_RT_SCG_DTL 를  다건 생성 합니다.<br>
	 * 
	 * @param List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriMotTrfRtScgDtlList(List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOTSSEFilingListVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMotTrfRtScgDtlCSQL(), rsltSearchMOTSSEFilingListVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * PRI_MOT_TRF_RT_SCG_DTL 을 다건 삭제 합니다.<br>
	 * 
	 * @param List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removePriMotTrfRtScgDtlList(List<RsltSearchMOTSSEFilingListVO> rsltSearchMOTSSEFilingListVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOTSSEFilingListVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMotTrfRtScgDtlDSQL(), rsltSearchMOTSSEFilingListVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	
	/**
	 * 하나의 PRI_MOT_TRF_MN 에 연결되어 있는 모든 PRI_MOT_TRF_RT_SCG_DTL 을  일괄 삭제 합니다.<br>
	 * 
	 * @param PriMotTrfMnVO priMotTrfMnVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePriMotTrfRtScgDtlAll(PriMotTrfMnVO priMotTrfMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priMotTrfMnVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCReportDBDAOremovePriMotTrfRtScgDtlAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * MOT Tariff Effective Date가 중복인지 조회합니다. <br>
	 * 
	 * @param PriMotTrfMnVO priMotTrfMnVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean chkPriMotTrfMnEffDtExist(PriMotTrfMnVO priMotTrfMnVO) throws DAOException {
		boolean rtnChk = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priMotTrfMnVO != null) {
				Map<String, String> mapVO = priMotTrfMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAOChkPriMotTrfMnEffDtExistRSQL(), param,
					velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0) {
				rtnChk = true;
			} else {
				rtnChk = false;
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnChk;
	}

    /**
     * PRI_MOT_TRF_MN 의 지정된 Service Scope 별 신규 MOT Tariff Sequence 를 조회합니다.<br>
     * 
     * @param PriMotTrfMnVO priMotTrfMnVO
     * @return int
     * @exception DAOException
     */
    public int searchPriMotTrfMnNewSeq(PriMotTrfMnVO priMotTrfMnVO) throws DAOException {
        int nextSeq = -1;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = priMotTrfMnVO.getColumnValues();
            param.putAll(mapVO);
                
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltPriMotTrfMnNewSeqRSQL(), param, null);
            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
                nextSeq = dbRowset.getInt("new_mot_trf_seq");
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return nextSeq;
    }

    /**
     * PRI_MOT_TRF_RT 의 지정된 Service Scope, MOT_TRF_SEQ 별 Max RT_SEQ 를 조회합니다.<br>
     * 
     * @param PriMotTrfMnVO priMotTrfMnVO
     * @return int
     * @exception DAOException
     */
    public int searchPriMotTrfRtMaxSeq(PriMotTrfMnVO priMotTrfMnVO) throws DAOException {
        int nextSeq = -1;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = priMotTrfMnVO.getColumnValues();
            param.putAll(mapVO);
                
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltPriMotTrfRtMaxRtSeqRSQL(), param, null);
            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
                nextSeq = dbRowset.getInt("max_rt_seq");
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return nextSeq;
    }


	/**
	 * MOT Tariff 화면을 위한 Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchMotTrfSvcScpCdList() throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltMotTrfSvcScpCdListRSQL(), null, null);
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
	 * MOT Tariff 화면을 위한 Service Scope Code 별 Lane Code List 를 조회합니다.<br>
	 * 
     * @param String svc_scp_cd
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchMotTrfLaneCdList(String svc_scp_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();

		try {
			if (svc_scp_cd != null && !svc_scp_cd.equals("") ) {
				param.put("svc_scp_cd", svc_scp_cd);
                
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltMotTrfLaneCdListRSQL(), param, null);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Korea MOF Filing (by Upload) 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO
	 * @return List<RsltSearchKoreaMOTListVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<RsltSearchKoreaMOTListVO> searchKoreaMOTFilingList(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO) throws DAOException {
        log.debug("********************************searchKoreaMOTFilingList - DBDAO");
        
        DBRowSet dbRowset = null;
        List<RsltSearchKoreaMOTListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            if (rsltSearchKoreaMOTListVO != null) {
            	log.debug("********************************************rsltSearchKoreaMOTListVO != null");
                Map<String, String> mapVO = rsltSearchKoreaMOTListVO.getColumnValues();
                //Contract Type Multi Select
                String type = mapVO.get("f_ctrt_tp");
                if(type.indexOf("S")!=-1){
                	mapVO.put("f_ctrt_tp_s", "SC");
                }else{
                	mapVO.put("f_ctrt_tp_s", "");
                }
                if(type.indexOf("R")!=-1){
                	mapVO.put("f_ctrt_tp_r", "RFA");
                }else{
                	mapVO.put("f_ctrt_tp_r", "");
                }
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchKoreaMOTListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchKoreaMOTListVO.class);
            
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
	 * MOF Filing (Formatted) RFA의 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO
	 * @return List<RsltSearchMOFListVO>
	 * @exception DAOException
	 */
	public List<RsltSearchMOFListVO> searchMOFFilingFormattedRFAList(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO) throws DAOException {
        log.debug("********************************searchMotFilingFormattedList - DBDAO");

        DBRowSet dbRowset = null;
        List<RsltSearchMOFListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = rsltSearchKoreaMOTListVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchMOFRFAListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchMOFListVO.class);
            
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
	 * MOF Filing (Formatted) SC의 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO
	 * @return List<RsltSearchMOFListVO>
	 * @exception DAOException
	 */
	public List<RsltSearchMOFListVO> searchMOFFilingFormattedSCList(RsltSearchKoreaMOTListVO rsltSearchKoreaMOTListVO) throws DAOException {
        log.debug("********************************searchMotFilingFormattedList - DBDAO");

        DBRowSet dbRowset = null;
        List<RsltSearchMOFListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = rsltSearchKoreaMOTListVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchMOFSCListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchMOFListVO.class);
            
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
	 * Korea MOF Filing (Base Table) - Scope & Location 리스트 조회를  실행한다. <br>
	 * 
	 * @param RsltSearchMOFLaneListVO rsltSearchMOFLaneListVO
	 * @return List<RsltSearchMOFLaneListVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<RsltSearchMOFLaneListVO> searchPriMofLaneList(RsltSearchMOFLaneListVO rsltSearchMOFLaneListVO) throws DAOException {
		log.debug("********************************searchPriMofLaneList - DBDAO");

        DBRowSet dbRowset = null;
        List<RsltSearchMOFLaneListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = rsltSearchMOFLaneListVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAORsltSearchMOFLaneListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchMOFLaneListVO.class);
            
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
	 * MOT Filing Location Property 정보를 다건 추가 합니다.<br>
	 * 
	 * @param List<RsltSearchMOFLaneListVO> rsltSearchMOFLaneListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriMOFLane(List<RsltSearchMOFLaneListVO> rsltSearchMOFLaneListVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOFLaneListVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAORsltSearchMOFLaneListVOCSQL(), rsltSearchMOFLaneListVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * MOT Filing Location Property  정보를 다건 변경  합니다.<br>
	 * 
	 * @param List<RsltSearchMOFLaneListVO> rsltSearchMOFLaneListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyMOFLane(List<RsltSearchMOFLaneListVO> rsltSearchMOFLaneListVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOFLaneListVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAORsltSearchMOFLaneListVOUSQL(), rsltSearchMOFLaneListVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * MOT Filing Location Property  정보를 다건 삭제 합니다.<br>
	 * 
	 * @param List<RsltSearchMOFLaneListVO> rsltSearchMOFLaneListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeMOFLane(List<RsltSearchMOFLaneListVO> rsltSearchMOFLaneListVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOFLaneListVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAORsltSearchMOFLaneListVODSQL(), rsltSearchMOFLaneListVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * MOT Filing Location Property History 정보를 다건 추가 합니다.<br>
	 * 
	 * @param List<RsltSearchMOFLaneListVO> rsltSearchMOFLaneListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriMOFLaneHistory(List<RsltSearchMOFLaneListVO> rsltSearchMOFLaneListVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltSearchMOFLaneListVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAORsltSearchMOFLaneHistoryListCSQL(), rsltSearchMOFLaneListVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert history No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * Korea MOF Filing (Base Table) - Mapping 리스트 조회를  실행한다. <br>
	 * 
	 * @param PriMofMapgVO priMofMapgVO
	 * @return List<PriMofMapgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriMofMapgVO> searchPriMofMapg(PriMofMapgVO priMofMapgVO) throws DAOException {
		log.debug("********************************searchPriMofMapg - DBDAO");
		
		DBRowSet dbRowset = null;
		List<PriMofMapgVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priMofMapgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAOPriMofMapgVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriMofMapgVO.class);
			
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
	 * Korea MOF Filing (Base Table) - Mapping Seq 조회를  실행한다. <br>
	 * 
	 * @param PriMofMapgVO priMofMapgVO
	 * @return List<PriMofMapgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriMofMapgVO> searchPriMofMapgSeq(PriMofMapgVO priMofMapgVO) throws DAOException {
		log.debug("********************************searchPriMofMapg - DBDAO");
		
		DBRowSet dbRowset = null;
		List<PriMofMapgVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priMofMapgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAOPriMofMapgSeqRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriMofMapgVO.class);
			
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
	 * MOT Filing Mapping 정보를 추가 합니다.<br>
	 * 
	 * @param List<PriMofMapgVO> priMofMapgVO
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] addPriMofMapg(List<PriMofMapgVO> priMofMapgVO) throws DAOException {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priMofMapgVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMofMapgVOCSQL(), priMofMapgVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * MOT Filing Mapping 정보를 변경합니다.<br>
	 * 
	 * @param List<PriMofMapgVO> priMofMapgVO
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] modifyPriMofMapg(List<PriMofMapgVO> priMofMapgVO) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priMofMapgVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMofMapgVOUSQL(), priMofMapgVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * MOT Filing Mapping  정보를 삭제 합니다.<br>
	 * 
	 * @param List<PriMofMapgVO> priMofMapgVO
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] removePriMofMapg(List<PriMofMapgVO> priMofMapgVO) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priMofMapgVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMofMapgVODSQL(), priMofMapgVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * Korea MOF Filing (Base Table) - Mapping History 리스트 조회를  실행한다. <br>
	 * 
	 * @param PriMofMapgHisVO priMofMapgHisVO
	 * @return List<PriMofMapgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriMofMapgHisVO> searchPriMofMapgHis(PriMofMapgHisVO priMofMapgHisVO) throws DAOException {
		log.debug("********************************searchPriMofMapg - DBDAO");
		
		DBRowSet dbRowset = null;
		List<PriMofMapgHisVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priMofMapgHisVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCReportDBDAOPriMofMapgHisVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriMofMapgHisVO.class);
			
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
	 * MOT Filing Mapping History 정보를 추가 합니다.<br>
	 * 
	 * @param List<PriMofMapgHisVO> priMofMapgHisVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addPriMofMapgHis(List<PriMofMapgHisVO> historyVoList) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(historyVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCReportDBDAOPriMofMapgHisVOCSQL(), historyVoList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	
}
