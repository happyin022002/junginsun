/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TAAProposalDBDAO.java
*@FileTitle : TAA Creation & Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.11.18 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.basic.TAAProposalBCImpl;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaTriListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriAuthorizationVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;
import com.clt.syscommon.common.table.PriTriMnVO;


/**
 *  TAAProposalDBDAO <br>
 * - TRIProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see TAAProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class TAAProposalDBDAO extends DBDAOSupport {

	/**
	 * TRI Proposal TAA Main 정보를 조회합니다.<br>
	 * 
	 * @param RsltTaaMnVO rsltTaaMnVO
	 * @return List<RsltTaaMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<RsltTaaMnVO> searchTRIProposalTAAMain(RsltTaaMnVO rsltTaaMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltTaaMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltTaaMnVO != null){
				Map<String, String> mapVO = rsltTaaMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TAAProposalDBDAOPriTaaMnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltTaaMnVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

    /**
     * TRI Proposal TAA Main 의 Amdt Seq Combo Item 을 조회합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltCdListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltCdListVO> searchTRIProposalTAAAmdtSeqList (RsltTaaMnVO rsltTaaMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltCdListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltTaaMnVO != null) {
                Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TAAProposalDBDAOTaaAmdtSeqComboRSQL(), param,
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
     * Customer 정보를 조회합니다.<br>
     * 
     * @param PriSpCtrtPtyVO priSpCtrtPtyVO
     * @return List<RsltPropCustInfoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked") 
    public List<RsltPropCustInfoVO> searchProposalCustomerInfo(PriSpCtrtPtyVO priSpCtrtPtyVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltPropCustInfoVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSpCtrtPtyVO != null){
                Map<String, String> mapVO = priSpCtrtPtyVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TAAProposalDBDAORsltPropCustInfoVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropCustInfoVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }   

    /**
     * TRI Proposal TAA 에 해당하는 TRI List 정보를 조회합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltTaaTriListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltTaaTriListVO> searchTRIProposalTAAList (RsltTaaMnVO rsltTaaMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltTaaTriListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltTaaMnVO != null) {
                Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TAAProposalDBDAOPriTaaTriListVORSQL(), param,
                    velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTaaTriListVO.class);
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
     * TRI Proposal 신규 TAA Proposal Number 를 조회합니다.<br>
     * 
     * @param String ofcCd
     * @return String
     * @exception DAOException
     */
    public String searchTRIProposalTAAPropNo(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        String taaPropNo = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            param.put("ofc_cd",JSPUtil.getNull(ofcCd));
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TAAProposalDBDAOCreTaaPropNoRSQL(), param, velParam);
            if (dbRowset.next()) {
                taaPropNo = dbRowset.getString(1);
            }
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return taaPropNo;
    }    
    
    /**
     * TRI Proposal 신규 TAA Number 를 조회합니다.<br>
     * 
     * @param String ofcCd
     * @return String
     * @exception DAOException
     */
    public String searchTRIProposalTAANo(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        String taaPropNo = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            param.put("ofc_cd",JSPUtil.getNull(ofcCd));
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TAAProposalDBDAOCreTaaNoRSQL(), param, velParam);
            if (dbRowset.next()) {
                taaPropNo = dbRowset.getString(1);
            }
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return taaPropNo;
    }    

    /**
     * TRI Proposal TAA Header 정보를 생성합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @exception DAOException
     * @exception Exception
     */
    public void addmanageTRIProposalTAAHeader(RsltTaaMnVO rsltTaaMnVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new TAAProposalDBDAOPriTaaHdrCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * TRI Proposal TAA Header 정보를 삭제합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return int
     * @exception DAOException
     * @exception Exception
     */
    public int removemanageTRIProposalTAAHeader(RsltTaaMnVO rsltTaaMnVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new TAAProposalDBDAOPriTaaHdrDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

	/**
	 * TRI Proposal TAA Main 정보를 생성합니다.<br>
	 * 
	 * @param RsltTaaMnVO rsltTaaMnVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addmanageTRIProposalTAAMain(RsltTaaMnVO rsltTaaMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TAAProposalDBDAOPriTaaMnVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * TRI Proposal TAA Main 정보를 수정합니다.<br>
	 * 
	 * @param RsltTaaMnVO rsltTaaMnVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifymanageTRIProposalTAAMain(RsltTaaMnVO rsltTaaMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TAAProposalDBDAOPriTaaMnVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * TRI Proposal TAA Main 정보를 삭제합니다.<br>
	 * 
	 * @param RsltTaaMnVO rsltTaaMnVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int removemanageTRIProposalTAAMain(RsltTaaMnVO rsltTaaMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TAAProposalDBDAOPriTaaMnVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * TRI Proposal TAA TRI List 정보를 생성합니다.<br>
	 * 
	 * @param List<RsltTaaTriListVO> rsltTaaTriListVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addmanageTRIProposalTAAList(List<RsltTaaTriListVO> rsltTaaTriListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(rsltTaaTriListVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TAAProposalDBDAOPriTaaTriListVOCSQL(), rsltTaaTriListVOs,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}

    /**
     * TRI Proposal TAA TRI List 정보를 삭제합니다.<br>
     * 
     * @param List<RsltTaaTriListVO> rsltTaaTriListVOs
     * @return int[]
     * @exception DAOException
     * @exception Exception
     */
    public int[] removemanageTRIProposalTAAList (List<RsltTaaTriListVO> rsltTaaTriListVOs) throws DAOException, Exception {
        int delCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            if (rsltTaaTriListVOs.size() > 0) {
                delCnt = sqlExe.executeBatch((ISQLTemplate) new TAAProposalDBDAOPriTaaTriListVODSQL(), rsltTaaTriListVOs, null);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return delCnt;
    }

    /**
     * TRI Proposal TAA TRI List 정보를 모두 삭제합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return int
     * @exception DAOException
     * @exception Exception
     */
    public int removemanageTRIProposalTAAListAll (RsltTaaMnVO rsltTaaMnVO) throws DAOException, Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new TAAProposalDBDAOPriTaaTriListAllDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * TRI Proposal TAA Confirm/Confirm Cancel 시 Confirm Flag 정보를 수정합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return int
     * @exception DAOException
     * @exception Exception
     */
    public int modifyConfirmTRIProposalTAA(RsltTaaMnVO rsltTaaMnVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new TAAProposalDBDAOPriTaaMnConfirmUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * TRI Proposal TAA Amend Confirm/Confirm Cancel 시 이전회차 Expire Date 를 수정합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return int
     * @exception DAOException
     * @exception Exception
     */
    public int modifyAmendConfirmTRIProposalTAA(RsltTaaMnVO rsltTaaMnVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new TAAProposalDBDAOPriTaaAmendConfirmUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * TRI Proposal TAA Main Amend 정보를 생성합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return int
     * @exception DAOException
     * @exception Exception
     */
    public int addAmendTRIProposalTAAMain(RsltTaaMnVO rsltTaaMnVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new TAAProposalDBDAOPriTaaMnAmendCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * TRI Proposal TAA TRI List Amend 정보를 생성합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return int
     * @exception DAOException
     * @exception Exception
     */
    public int addAmendTRIProposalTAAList(RsltTaaMnVO rsltTaaMnVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new TAAProposalDBDAOPriTaaTriListAmendCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }
    
    /**
     * TRI Inquiry List 정보를 조회합니다.<br>
     * 
     * @param PriTriMnVO priTriMnVO
     * @return List<RsltTaaMnVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltTaaMnVO> searchTRIProposalTAAInquiryList(PriTriMnVO priTriMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltTaaMnVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priTriMnVO != null) {
                Map<String, String> mapVO = priTriMnVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TAAProposalDBDAOPriTaaTriInquiryListRSQL(), param,
                    velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTaaMnVO.class);
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
     * TRI Proposal Select List 를 조회합니다.<br>
     * 
     * @param RsltTaaTriListVO rsltTaaTriListVO
     * @return List<RsltTaaTriListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltTaaTriListVO> searchTRIProposalSelectList(RsltTaaTriListVO rsltTaaTriListVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltTaaTriListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rsltTaaTriListVO != null){
                Map<String, String> mapVO = rsltTaaTriListVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TAAProposalDBDAOPriTriSelectListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltTaaTriListVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * TRI Proposal TAA No List 정보를 조회합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltTaaMnVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltTaaMnVO> searchTRIProposalTAANoList (RsltTaaMnVO rsltTaaMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltTaaMnVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltTaaMnVO != null) {
                Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TAAProposalDBDAOPriTaaNoListRSQL(), param,
                    velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTaaMnVO.class);
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
     * TRI Proposal TAA 정보를 Booking 에서 사용여부를 조회합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return String[]
     * @exception DAOException
     */
    public String[] searchTRIProposalTAACheckUseBkg (RsltTaaMnVO rsltTaaMnVO) throws DAOException {
        DBRowSet dbRowset = null;
//        boolean isUsed = false;
        ArrayList<String> list = new ArrayList<String>();
        String[] bkgNos = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltTaaMnVO != null) {
                Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TAAProposalDBDAOCheckBkgTaaNoRSQL(), param,
                    velParam);
            
            while (dbRowset.next()) {
                list.add(dbRowset.getString(1));
            }
            bkgNos = new String[list.size()];
            list.toArray(bkgNos);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return bkgNos;
    }

    /**
     * CRM 으로 전송할 TAA Main 정보를 조회합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltTaaMnVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltTaaMnVO> searchTAAMainInfo (RsltTaaMnVO rsltTaaMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltTaaMnVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltTaaMnVO != null) {
                Map<String, String> mapVO = rsltTaaMnVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TAAProposalDBDAOCrmTaaInfoVORSQL(), param,
                    velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTaaMnVO.class);
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
     * TRI Proposal TAA 승인권한을 조회합니다.<br>
     * 
     * @param PriAuthorizationVO priAuthorizationVO
     * @return String
     * @exception DAOException
     */
    public String searchTRIProposalTAAApprovalAuth(PriAuthorizationVO priAuthorizationVO) throws DAOException {
        DBRowSet dbRowset = null;
        String authYn = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priAuthorizationVO != null){
                Map<String, String> mapVO = priAuthorizationVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TAAProposalDBDAOPriTaaApprovalAuthRSQL(), param, velParam);
            if (dbRowset.next()) {
                authYn = "Y";
            } else {
                authYn = "N";
            }
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return authYn;
    }
}