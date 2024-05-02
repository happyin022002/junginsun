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
=========================================================
2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
조회 가능토록 수정 - searchRFARateSearchListDoStart,searchRFAList SignOnUserAccount parameter 추가
2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만
                                                                    자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
* 2014.11.25 최성환 [CHM-201432700] Retroactive RFA Minimization관련 시스템 개발요청                                                                    
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.basic.RFAReportBCImpl;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.MasterRFAConditionVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriCopiedRFAVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriMasterRFAOnlyVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRFABlVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRpRetroInfoVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltRFARetRDInfoVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltSearchRFAListVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltSearchRFARateSearchListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;


/**
 * ALPS RFAReportDBDAO <br>
 * - ALPS-RFAReport system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
     * @param SignOnUserAccount account
     * @return List<RsltSearchRFAListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchRFAListVO> searchRFAList (RsltSearchRFAListVO rsltSearchRFAListVO,SignOnUserAccount account) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchRFAListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchRFAListVO != null) {
                Map<String, String> mapVO = rsltSearchRFAListVO.getColumnValues();
                mapVO.put("ofc_cd",account.getOfc_cd());
                mapVO.put("rhq_cd",account.getRhq_ofc_cd());
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
     * @param String logInOfcCd
     * @param String logInRhqOfcCd
     * @return List<RsltSearchRFARateSearchListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltSearchRFARateSearchListVO> searchRFARateSearchList (RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO,String logInOfcCd,String logInRhqOfcCd) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltSearchRFARateSearchListVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltSearchRFARateSearchListVO != null) {
                Map<String, String> mapVO = rsltSearchRFARateSearchListVO.getColumnValues();
                mapVO.put("ofc_cd",logInOfcCd);
                mapVO.put("rhq_cd",logInRhqOfcCd);
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
    
    /**
     * Retroactive RFA Search -Retroactive RFA Retrieval 리스트를 조회한다.<br>
     * 
     * @param RsltPriRpRetroInfoVO rsltPriRpRetroInfoVO
     * @param SignOnUserAccount account
     * @return List<RsltPriRpRetroInfoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltPriRpRetroInfoVO> searchRetroactiveRFAList (RsltPriRpRetroInfoVO rsltPriRpRetroInfoVO,SignOnUserAccount account) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltPriRpRetroInfoVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (rsltPriRpRetroInfoVO != null) {
                Map<String, String> mapVO = rsltPriRpRetroInfoVO.getColumnValues();
                mapVO.put("ofc_cd",account.getOfc_cd());
                mapVO.put("rhq_cd",account.getRhq_ofc_cd());
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAReportDBDAORsltPriRpRetroInfoVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpRetroInfoVO.class);
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
	 * ESM_PRI_2219_01 - Retrieve
	 * 
	 * @param MasterRFAConditionVO masterRFAConditionVO
	 * @return List<RsltPriMasterRFAOnlyVO>
	 * @throws DAOException
	 */
	public List<RsltPriMasterRFAOnlyVO> searchMasterRFAOnlyList(MasterRFAConditionVO masterRFAConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriMasterRFAOnlyVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = masterRFAConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAReportDBDAORsltPriMasterRFAOnlyRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriMasterRFAOnlyVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_PRI_2219_02 - Retrieve
	 * 
	 * @param MasterRFAConditionVO masterRFAConditionVO
	 * @return List<RsltPriCopiedRFAVO>
	 * @throws DAOException
	 */
	public List<RsltPriCopiedRFAVO> searchCopiedRFAList(MasterRFAConditionVO masterRFAConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCopiedRFAVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = masterRFAConditionVO.getColumnValues();
		
			//RFA Type Multi Select
			String type = mapVO.get("f_rfa_tp");
			if(type.indexOf("B")!=-1){
				mapVO.put("f_rfa_tp_b", "B");
			}else{
				mapVO.put("f_rfa_tp_b", "");
			}
			if(type.indexOf("C")!=-1){
				mapVO.put("f_rfa_tp_c", "C");
			}else{
				mapVO.put("f_rfa_tp_c", "");
			}
			if(type.indexOf("S")!=-1){
				mapVO.put("f_rfa_tp_s", "S");
			}else{
				mapVO.put("f_rfa_tp_s", "");
			}
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAReportDBDAORsltPriCopiedRFARSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriCopiedRFAVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_PRI_2211 - Retrieve
	 * 
	 * @param MasterRFAConditionVO masterRFAConditionVO
	 * @return List<RsltPriRFABlVO>
	 * @throws DAOException
	 */
	public List<RsltPriRFABlVO> searchRFABlList(MasterRFAConditionVO masterRFAConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRFABlVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = masterRFAConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAReportDBDAORsltPriRFABlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRFABlVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}