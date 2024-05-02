/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RfaProposalDEMDETDBDAO.java
*@FileTitle : RFA Proposal Creation [Amend] (DEM&DET)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.18 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.basic.RFAProposalDEMDETBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptHisListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriRpDmdtVO;
import com.clt.syscommon.common.table.PriRpMnVO;


/**
 *  RfaProposalDEMDETDBDAO <br>
 * - RFAProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see RFAProposalDEMDETBCImpl 참조
 * @since J2EE 1.6
 */
public class RFAProposalDEMDETDBDAO extends DBDAOSupport {

	/**
	 * DEMDET정보를 조회합니다.<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO
	 * @return List<RsltDmdtExptListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltDmdtExptListVO> searchDEMDETExceptionList(PriRpDmdtVO priRpDmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltDmdtExptListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpDmdtVO != null){
				Map<String, String> mapVO = priRpDmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalDEMDETDBDAORsltDmdtExptListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltDmdtExptListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
		}
		return list;
	}
	
	/**
	 * DEMDET정보를 저장합니다.<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addDEMDETException(PriRpDmdtVO priRpDmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpDmdtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalDEMDETDBDAOPriRpDmdtVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
		}
	}
	
	/**
	 * [DEMDET] 정보를 [수정] 합니다.<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyDEMDETException(PriRpDmdtVO priRpDmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priRpDmdtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalDEMDETDBDAOPriRpDmdtVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
		}
		return result;
	}

	/**
	 * [DEM&DET] 정보를 [저장] 합니다.<br>
	 * 
	 * @param List<PriRpDmdtVO> priRpDmdtVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addDEMDETExceptionList(List<PriRpDmdtVO> priRpDmdtVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priRpDmdtVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalDEMDETDBDAOPriRpDmdtVOCSQL(), priRpDmdtVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
		}
		return insCnt;
	}

	/**
	 * [DEM&DET] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<PriRpDmdtVO> priRpDmdtVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyDEMDETExceptionList(List<PriRpDmdtVO> priRpDmdtVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priRpDmdtVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalDEMDETDBDAOPriRpDmdtVOUSQL(), priRpDmdtVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
		}
		return updCnt;
	}
	
	/**
	 * [DEM&DET] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<PriRpDmdtVO> priRpDmdtVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeDEMDETExceptionList(List<PriRpDmdtVO> priRpDmdtVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priRpDmdtVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalDEMDETDBDAOPriRpDmdtVODSQL(), priRpDmdtVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
		}
		return delCnt;
	}
	
	/**
     * Proposal No를 조회한다.<br>
     * 
     * @param String ofcCd
     * @return String
     * @exception DAOException
     */
    public String searchCreationProposalNo (String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnVal = "";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("ofc_cd", ofcCd);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalDEMDETDBDAORsltCrePropNoVORSQL(), param, velParam);
            dbRowset.next();
            rtnVal = dbRowset.getString(1);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rtnVal;
    }	

	/**
	 * [DEMDET] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<PriRpDmdtVO> priRpDmdtVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyProposalDEMDETException(List<PriRpDmdtVO> priRpDmdtVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priRpDmdtVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalDEMDETDBDAOPriRpDmdtMainVOUSQL(), priRpDmdtVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
		}
		return updCnt;
	}
	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpMnVO vo 
	 * @exception EventException
	 */
	public void modifyProposalRequestCancel(PriRpMnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalDEMDETDBDAOPriRpDmdtRequestCancelVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
		}
	}	
	
    /**
	 * DEM&DET 의 데이터를 삭제처리한다.<br>
     * 
     * @param PriRpMnVO vo 
     * @exception DAOException
     */
    public void removeProposalDmdt (PriRpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalDEMDETDBDAOPriRpDmdtInitCancelVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }		            
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
        }
    }		
    
	/**
	 * Main Request 할때 자동으로 Accept를 합니다.<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO
	 * @exception EventException
	 */
    public void modifyProposalAutoAccept(PriRpDmdtVO priRpDmdtVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpDmdtVO.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalDEMDETDBDAOPriRpDmdtAutoAcceptVOUSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }		            
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
        }
    }	    
    
	/**
	 * DEM/DET에 Amend 데이터를 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalDmdtAmend(List<PriRpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalDEMDETDBDAOPriRpDmdtAmendVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
		}
	}	    
	
	/**
	 * [DEMDET] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO
	 * @return List<RsltDmdtExptHisListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltDmdtExptHisListVO> searchDEMDETExceptionHistoryList(PriRpDmdtVO priRpDmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltDmdtExptHisListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpDmdtVO != null){
				Map<String, String> mapVO = priRpDmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalDEMDETDBDAORsltDmdtExptHisListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltDmdtExptHisListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage() ,ex);
		}
		return list;
	}	

    /**
     * RFA Proposal DEM/DET 정보를 Copy 해서 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalDemDet (RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalDEMDETDBDAOPropCpPriRpDmdtCSQL(),
                    param, velParam);
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
    
    
}