/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAReportDBDAO.java
*@FileTitle : RFA Proposal Creation – Draft
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.09.15 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfareport.rfareport.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.rfareport.rfareport.basic.RFAReportBCImpl;
import com.clt.apps.opus.esm.pri.rfareport.rfareport.vo.RsltRFARetRDInfoVO;
import com.clt.apps.opus.esm.pri.rfareport.rfareport.vo.RsltSearchRFAListVO;
import com.clt.apps.opus.esm.pri.rfareport.rfareport.vo.RsltSearchRFARateSearchListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriRpMnVO;


/**
 *  RFAReportDBDAO <br>
 * - RFAReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Byeon Young Joo
 * @see RFAReportBCImpl 참조
 * @since J2EE 1.6
 */
public class RFAReportDBDAO extends DBDAOSupport {

	/**
     * RFAReportDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
     * RFAReport의 Report 관련 정보 조회 이벤트 처리
     * 
     * @param PriRpMnVO priRpMnVO
     * @return List<RsltRFARetRDInfoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRFARetRDInfoVO> searchRFARetrievalRDInfo (PriRpMnVO priRpMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRFARetRDInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpMnVO != null) {
                Map<String, String> mapVO = priRpMnVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAReportDBDAORsltRFARetRDInfoVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRFARetRDInfoVO.class);
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
     * RFA Search - RFA Retrieval 리스트를 조회한다. <br>
     * 
     * @param RsltSearchRFAListVO rsltSearchRFAListVO
     * @return List<RsltSearchRFAListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchRFAListVO> searchRFAList (RsltSearchRFAListVO rsltSearchRFAListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchRFAListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchRFAListVO != null) {
                Map<String, String> mapVO = rsltSearchRFAListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAReportDBDAORsltSearchRFAListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchRFAListVO.class);
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
     * RFA Search - Rate Retrieval 리스트를 조회한다. <br>
     * 
     * @param RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO
     * @return List<RsltSearchRFARateSearchListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchRFARateSearchListVO> searchRFARateSearchList (RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchRFARateSearchListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchRFARateSearchListVO != null) {
                Map<String, String> mapVO = rsltSearchRFARateSearchListVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAReportDBDAORsltSearchRFARateSearchListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltSearchRFARateSearchListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	

}