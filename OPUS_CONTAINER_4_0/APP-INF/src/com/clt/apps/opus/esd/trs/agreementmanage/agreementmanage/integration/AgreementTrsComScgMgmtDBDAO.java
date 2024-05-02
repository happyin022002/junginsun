/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : AgreementTrsComScgMgmtDBDAO.java
*@FileTitle      : Common Surcharge Management
*Open Issues     : 
*Change history  : 
*@LastModifyDate : 2014-11-05
*@LastModifier   : Hyungwook Choi
*@LastVersion    : 1.0
* 2014-11-05 Hyungwook Choi
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0237Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsComScgMgmtTpSzVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-TRS에 대한 DB 처리를 담당
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.
 * @author Hyungwook Choi
 * @see DBDAOSupport
 * @since J2EE 1.6
 */
public class AgreementTrsComScgMgmtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
     * 
     * @param trsComScgMgmtTpSzVO
     * @return
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<TrsComScgMgmtTpSzVO> searchTrsComScgMgmt(TrsComScgMgmtTpSzVO trsComScgMgmtTpSzVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<TrsComScgMgmtTpSzVO> list = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if(trsComScgMgmtTpSzVO != null) {
                Map<String, String> mapVO = trsComScgMgmtTpSzVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementTrsComScgMgmtDBDAOSearchTrsComScgMgmtRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsComScgMgmtTpSzVO.class);
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
     * Modifying Common Surcharge Management
     * 
     * @param trspTmpSeq
     * @return result
     * @throws DAOException
     * @throws Exception
     */
    public int multiTrsComScgMgmt(String trspTmpSeq) throws DAOException,Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try {
            param.put("trsp_tmp_seq", trspTmpSeq);
            velParam.put("trsp_tmp_seq", trspTmpSeq);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new AgreementTrsComScgMgmtDBDAOMergeTrsComScgMgmtCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to SaveTrsComScgMgmt SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * Deleting Common Surcharge Management
     * 
     * @param trsComScgMgmtTpSzVO
     * @return
     * @throws DAOException
     * @throws Exception
     */
   public int deleteTrsComScgMgmt(TrsComScgMgmtTpSzVO trsComScgMgmtTpSzVO) throws DAOException,Exception {
       Map<String, Object> param = new HashMap<String, Object>();
       Map<String, Object> velParam = new HashMap<String, Object>();
       int result = 0;

       try {
           Map<String, String> mapVO = trsComScgMgmtTpSzVO.getColumnValues();
           param.putAll(mapVO);
           velParam.putAll(mapVO);

           SQLExecuter sqlExe = new SQLExecuter("");
           result = sqlExe.executeUpdate((ISQLTemplate)new AgreementTrsComScgMgmtDBDAODeleteTrsComScgMgmtDSQL(), param, velParam);
           if(result == Statement.EXECUTE_FAILED) {
               throw new DAOException("Fail to DeleteTrsComScgMgmt SQL");
           }
       } catch (SQLException se) {
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage(), se);
       } catch(Exception ex) {
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       }
       return result;
   }
   
   /**
    * Searching ComboList of RCC Code
    * 
    * @param e
    * @return
    * @throws EventException
    */
   @SuppressWarnings({ "unchecked", "rawtypes" })
   public List<TrsComScgMgmtTpSzVO> searchRccCdComList(EsdTrs0237Event e) throws DAOException {
	   DBRowSet dbRowset = null;
	   List<TrsComScgMgmtTpSzVO> list = null;
       Map<String, Object> param = new HashMap<String, Object>();
	   try {
		   dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementTrsComScgMgmtDBDAOSearchRccCdComListRSQL(), param, param);
	       list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsComScgMgmtTpSzVO.class);
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
	 * Insert Common Surcharge Temp ( ESD_TRS_0237 )
	 * 
	 * @param trsComScgMgmtTpSzVOs
	 * @param userId
	 * @return trspTmpSeq
	 * @throws DAOException
	 */
	public String insertAgmtVerifyData(List<TrsComScgMgmtTpSzVO> trsComScgMgmtTpSzVOs, String userId) throws DAOException {
		String trspTmpSeq = "";
        Map<String, Object> commonParams = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
//        int result = 0;

        try {
			DBRowSet dRs = null;
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOCreateNewAgmtTmpSeqRSQL(), null, null);
			if (dRs != null) {
				if (dRs.next()) {
					trspTmpSeq = JSPUtil.getNull(dRs.getString(1));
				}
			}

            if(trspTmpSeq.length() < 1) {
                throw new DAOException("Fail to SaveTrsComScgTmp SQL");
            }
        	commonParams.put("trsp_tmp_seq", trspTmpSeq);
        	commonParams.put("cre_usr_id", userId);
        	commonParams.put("upd_usr_id", userId);
            velParam.put("trsp_tmp_seq", trspTmpSeq);
            velParam.put("cre_usr_id", userId);
            velParam.put("upd_usr_id", userId);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            sqlExe.executeBatch((ISQLTemplate)new AgreementTrsComScgMgmtDBDAOMergeTrsComScgTmpCSQL(), trsComScgMgmtTpSzVOs, velParam, commonParams);
//            result = sqlExe.executeUpdate((ISQLTemplate)new AgreementTrsComScgMgmtDBDAOMergeTrsComScgMgmtCSQL(), param, velParam);
//            if(result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to SaveTrsComScgTmp SQL");
//            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return trspTmpSeq;
	}

    /**
     * Check Verification of Common Surcharge Temp ( ESD_TRS_0237 )
     * 
     * @param trspTmpSeq
     * @return dRs
     * @throws DAOException
     */
	public DBRowSet verifySurcharge(String trspTmpSeq) throws DAOException {
        DBRowSet dRs = null;
        Map<String, Object> param = new HashMap<String, Object>();
        try{
            param.put("trsp_tmp_seq",trspTmpSeq);
            dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementTrsComScgMgmtDBDAOVerifyTrsComScgRSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        } 
        return dRs;
	}

    /**
     * Deleting Common Surcharge Temp ( ESD_TRS_0237 )
     * 
     * @param trspTmpSeq
     * @throws DAOException
     */
	public void deleteTrsAgmtTmp(String trspTmpSeq) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        try {
            param.put("trsp_tmp_seq",trspTmpSeq);
            new SQLExecuter("DEFAULT").executeUpdate(new AgreementTrsComScgMgmtDBDAODeleteTrsComScgTmpDSQL(), param, param);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ee) {
            log.error(ee.getMessage(), ee);
            throw new DAOException(ee.getMessage());
        }
	}
}
