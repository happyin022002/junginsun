/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableAgentDBDAO.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.basic.AccountReceivableAgentBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.AGnCltRfndN3rdAmtSumVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.AGnCltRfndUsdLclAmtSumVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASACltRfndAdjListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASACltRfndTTLAmtVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAExpenseDrCrAmtVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAInfoByOfcAgnVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAInquiryListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAnoListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.AgentCollectionListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.BatHisVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.CheckASAperiodVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.CheckPreASAStausVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ManageAgentCollectionListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.UnreportedOtsReportVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SarAgnCltRfndMstVO;
import com.clt.syscommon.common.table.SarAsaDtlVO;
import com.clt.syscommon.common.table.SarAsaMstVO;
import com.clt.syscommon.common.table.SarAsaNoSeqVO;

/**
 * AccountReceivableAgentDBDAO <br>
 * - AccountReceivableAgent system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author
 * @see AccountReceivableAgentBCImpl 참조
 * @since J2EE 1.4
 */
public class AccountReceivableAgentDBDAO extends DBDAOSupport {
	/**
     * ASA NO Popup 화면<br>
     *
     * @author YJLEE
     * @category STM_SAR_0200
     * @category searchASAnoList
     * @param String asa_no
     * @param String asa_ofc_cd
     * @param String flag_cd
     * @return List<ASAnoListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ASAnoListVO> searchASAnoList(String asa_no,String asa_ofc_cd,String flag_cd) throws DAOException {
        DBRowSet dbRowset = null;

        List<ASAnoListVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

        	param.put("asa_no", asa_no);
         	velParam.put("asa_no", asa_no);

            param.put("asa_ofc_cd", asa_ofc_cd);
         	velParam.put("asa_ofc_cd", asa_ofc_cd);

         	param.put("flag_cd", flag_cd);
         	velParam.put("flag_cd", flag_cd);

             dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOASAnoListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, ASAnoListVO.class);
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
     * Agent Collection Inquiry<br><br>
     *
     * @author YJLEE
     * @category STM_SAR_5005
     * @category searchAgentCollectionListInquiry
     * @param AgentCollectionListVO agentCollectionListVO
     * @return List<AgentCollectionListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<AgentCollectionListVO> searchAgentCollectionListInquiry(AgentCollectionListVO agentCollectionListVO) throws DAOException {
        DBRowSet dbRowset = null;

        List<AgentCollectionListVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

       try {

    	   if(agentCollectionListVO != null){
				Map<String, String> mapVO = agentCollectionListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//System.out.println("log test" + AgentCollectionListVO.getVvd());
			}
             dbRowset = new SQLExecuter("").executeQuery(new AccountReceivalbeAgentDBDAOsearchAgentCollectionListInquiryRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentCollectionListVO.class);
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
     * Agent Collection Inquiry<br><br>
     *
     * @author YJLEE
     * @category STM_SAR_5005
     * @category searchAgentCollectionListInquiry
     * @param AgentCollectionListVO agentCollectionListVO
     * @return List<AgentCollectionListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<AgentCollectionListVO> searchAgentCollectionListFOREntry(AgentCollectionListVO agentCollectionListVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	
    	List<AgentCollectionListVO> list = null;
    	
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	
    	try {
    		
    		if(agentCollectionListVO != null){
    			Map<String, String> mapVO = agentCollectionListVO.getColumnValues();
    			 
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}
    		dbRowset = new SQLExecuter("").executeQuery(new AccountReceivalbeAgentDBDAOsearchAgentCollectionListFOREntryRSQL(), param, velParam);
    		list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentCollectionListVO.class);
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
     * Agent Collection Entry<br><br>
     *
     * @author YJLEE
     * @category STM_SAR_5001
     * @category searchAgentCollectionList
     * @param AgentCollectionListVO agentCollectionListVO
     * @return List<AgentCollectionListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<AgentCollectionListVO> searchAgentCollectionList(AgentCollectionListVO agentCollectionListVO) throws DAOException {
        DBRowSet dbRowset = null;

        List<AgentCollectionListVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

       try {

    	   if(agentCollectionListVO != null){
				Map<String, String> mapVO = agentCollectionListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
             dbRowset = new SQLExecuter("").executeQuery(new AccountReceivalbeAgentDBDAOsearchAgentCollectionListRSQLRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentCollectionListVO.class);
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
     * Agent Collection Entry<br><br>
     *
     * @author YJLEE
     * @category STM_SAR_5001
     * @category addAgentCollectionList
     * @param List<ManageAgentCollectionListVO> manageAgentCollectionListVOs
     * @throws DAOException
     */
	public void addAgentCollectionList(List<ManageAgentCollectionListVO> manageAgentCollectionListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (manageAgentCollectionListVOs.size() > 0) {
				updCnt = sqlExe.executeBatch(new AccountReceivalbeAgentDBDAOaddAgentCollectionListVOCSQL(), manageAgentCollectionListVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * Agent Collection Entry<br><br>
     *
     * @author YJLEE
     * @category STM_SAR_5001
     * @category modifyAgentCollectionList
     * @param List<ManageAgentCollectionListVO> manageAgentCollectionListVOs
     * @throws DAOException
     */
	public void modifyAgentCollectionList(List<ManageAgentCollectionListVO> manageAgentCollectionListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (manageAgentCollectionListVOs.size() > 0) {
				updCnt = sqlExe.executeBatch(new AccountReceivalbeAgentDBDAOmodifyAgentCollectionListVOUSQL(), manageAgentCollectionListVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * Agent Collection Entry<br><br>
     *
     * @author YJLEE
     * @category STM_SAR_5001
     * @category removeAgentCollectionList
     * @param List<ManageAgentCollectionListVO> manageAgentCollectionListVOs
     * @throws DAOException
     */
	public void removeAgentCollectionList(List<ManageAgentCollectionListVO> manageAgentCollectionListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (manageAgentCollectionListVOs.size() > 0) {
				updCnt = sqlExe.executeBatch(new AccountReceivalbeAgentDBDAOremoveAgentCollectionListVODSQL(), manageAgentCollectionListVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * Unreported OTS Report<br><br>
     *
     * @author YJLEE
     * @category STM_SAR_5004
     * @category searchUnreportedOtsReportList
     * @param UnreportedOtsReportVO unreportedOtsReportVO
     * @return List<UnreportedOtsReportVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<UnreportedOtsReportVO> searchUnreportedOtsReportList(UnreportedOtsReportVO unreportedOtsReportVO) throws DAOException {
        DBRowSet dbRowset = null;

        List<UnreportedOtsReportVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

       try {

    	   if(unreportedOtsReportVO != null){
				Map<String, String> mapVO = unreportedOtsReportVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//System.out.println("log test" + UnreportedOtsReportVO.getVvd());
			}
             dbRowset = new SQLExecuter("").executeQuery(new AccountReceivalbeAgentDBDAOsearchUnreportedOtsReportListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnreportedOtsReportVO.class);
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
     * Agent Statement of Account Inquiry<br><br>
     *
     * @author YJLEE
     * @category STM_SAR_5003
     * @category searchASAInquiryList
     * @param ASAInquiryListVO aSAInquiryListVO
     * @return List<ASAInquiryListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ASAInquiryListVO> searchASAInquiryList(ASAInquiryListVO aSAInquiryListVO) throws DAOException {
        DBRowSet dbRowset = null;

        List<ASAInquiryListVO> list = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

       try {

    	   if(aSAInquiryListVO != null){
				Map<String, String> mapVO = aSAInquiryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//System.out.println("log test" + ASAInquiryListVO.getVvd());
			}
             dbRowset = new SQLExecuter("").executeQuery(new AccountReceivalbeAgentDBDAOsearchASAInquiryListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, ASAInquiryListVO.class);
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
     * Search ASA Info By office code and  agent code
     * MAX(ASA_PRD_TO_DT)
     * COUNT(ASA_NO)
     * MAX(ASA_NO)
     * @author jinyoonoh 2014. 5. 12.
     * @param ASAInfoByOfcAgnVO paramVO
     * @return ASAInfoByOfcAgnVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ASAInfoByOfcAgnVO searchASAInfoByOfcAgn(ASAInfoByOfcAgnVO paramVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ASAInfoByOfcAgnVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        ASAInfoByOfcAgnVO retVO = null;
        try {

    	   if(paramVO != null) {
				Map<String, String> mapVO = paramVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
		   }

    	   dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOSearchASAInfoByOfcAgnRSQL(), param, velParam);
    	   list = (List)RowSetUtil.rowSetToVOs(dbRowset, ASAInfoByOfcAgnVO .class);

           if(list != null && !list.isEmpty())  {
        	   retVO = list.get(0);
           }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return retVO;
    }


    /**
     * Search ASA MASTER
     * @author jinyoonoh 2014. 5. 12.
     * @param SarAsaMstVO paramVO
     * @return SarAsaMstVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public SarAsaMstVO searchASAMst(SarAsaMstVO paramVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SarAsaMstVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        SarAsaMstVO retVO = null;
        try {

    	   if(paramVO != null) {
				Map<String, String> mapVO = paramVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
		   }

    	   dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOSearchASAMstRSQL(), param, velParam);
    	   list = (List)RowSetUtil.rowSetToVOs(dbRowset, SarAsaMstVO .class);

           if(list != null && !list.isEmpty())  {
        	   retVO = list.get(0);
           }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return retVO;
    }


    /**
     * Search ASA Detail
     * @author jinyoonoh 2014. 5. 12.
     * @param SarAsaDtlVO paramVO
     * @return List<SarAsaDtlVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SarAsaDtlVO> searchASADtl(SarAsaDtlVO paramVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SarAsaDtlVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

    	   if(paramVO != null) {
				Map<String, String> mapVO = paramVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
		   }

    	   dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOSearchASADtlRSQL(), param, velParam);
    	   list = (List)RowSetUtil.rowSetToVOs(dbRowset, SarAsaDtlVO .class);
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
     * Search ASA Detail
     * @author jinyoonoh 2014. 5. 12.
     * @param SarAsaDtlVO paramVO
     * @return List<SarAsaDtlVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SarAsaDtlVO> searchASADtlForUpdate(SarAsaDtlVO paramVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	List<SarAsaDtlVO> list = null;
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	
    	try {
    		
    		if(paramVO != null) {
    			Map<String, String> mapVO = paramVO.getColumnValues();
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}
    		
    		dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOsearchASADtlForUpdateRSQL(), param, velParam);
    		list = (List)RowSetUtil.rowSetToVOs(dbRowset, SarAsaDtlVO .class);
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
     * Search ASA No Sequence
     * @author jinyoonoh 2014. 5. 12.
     * @param SarAsaNoSeqVO paramVO
     * @return SarAsaNoSeqVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public SarAsaNoSeqVO searchASASeqNo(SarAsaNoSeqVO paramVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SarAsaNoSeqVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        SarAsaNoSeqVO retVO = null;
        try {

    	   if(paramVO != null) {
				Map<String, String> mapVO = paramVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
		   }

    	   dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOSearchASANoSeqRSQL(), param, velParam);
    	   list = (List)RowSetUtil.rowSetToVOs(dbRowset, SarAsaNoSeqVO .class);

           if(list != null && !list.isEmpty())  {
        	   retVO = list.get(0);
           }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return retVO;
    }


	/**
	 * Insert into ASA Master<br>
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaMstVO paramVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addASAMst (SarAsaMstVO paramVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = paramVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAgentDBDAOInsertASAMstCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * Update ASA Master<br>
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaMstVO paramVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyASAMst (SarAsaMstVO paramVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = paramVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAgentDBDAOUpdateASAMstUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * Insert into ASA Detail<br>
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaDtlVO paramVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addASADtl (SarAsaDtlVO paramVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = paramVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAgentDBDAOInsertASADtlCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * Update ASA Detail<br>
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaDtlVO paramVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyASADtl(SarAsaDtlVO paramVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = paramVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAgentDBDAOUpdateASADtlUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Insert into ASA No Sequence<br>
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaNoSeqVO paramVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addASANoSeq (SarAsaNoSeqVO paramVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = paramVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAgentDBDAOInsertASANoSeqCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * Update ASA No Sequence<br>
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAsaNoSeqVO paramVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyASANoSeq (SarAsaNoSeqVO paramVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = paramVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAgentDBDAOUpdateASANoSeqUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

    /**
     * Search ASA Detail
     * @author jinyoonoh 2014. 5. 14.
     * @param SarAgnCltRfndMstVO paramVO
     * @return List<SarAgnCltRfndMstVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SarAgnCltRfndMstVO> searchSarAgnCltRfndMstList(SarAgnCltRfndMstVO paramVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SarAgnCltRfndMstVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {

    	   if(paramVO != null) {
				Map<String, String> mapVO = paramVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
		   }
    	   dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOSearchSarAgnCltRfndMstRSQL(), param, velParam);
    	   list = (List)RowSetUtil.rowSetToVOs(dbRowset, SarAgnCltRfndMstVO .class);
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
     * Collect,Refund Total Amount Summary
     * @author jinyoonoh 2014. 5. 14.
     * @param String asaNo
     * @param String asaTpCd
     * @return BigDecimal
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public BigDecimal searchSarAgnCltRfndSumTtlAmt(String asaNo, String asaTpCd) throws DAOException {
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("asa_no", asaNo);
			param.put("asa_tp_cd", asaTpCd);
			velParam.putAll(param);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableAgentDBDAOSearchSarAgnCltRfndSumTtlAmtRSQL(),
							param, velParam);
			if(dbRowset.next()) {
				return dbRowset.getBigDecimal("TTL_AMT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return new BigDecimal("0.00");
    }

    /**
     * Excpense Debit, Credit Amount
     * @author jinyoonoh 2014. 5. 14.
     * @param String asaNo
     * @param String chgTpCd
     * @return ASAExpenseDrCrAmtVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ASAExpenseDrCrAmtVO searchASAExpenseDrCrAmt(String asaNo, String chgTpCd) throws DAOException {
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        ASAExpenseDrCrAmtVO retVO = new ASAExpenseDrCrAmtVO();

		try {
			param.put("asa_no", asaNo);
			param.put("chg_tp_cd", chgTpCd);
			velParam.putAll(param);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableAgentDBDAOSearchASAExpenseDrCrAmtRSQL(),
							param, velParam);
			List<ASAExpenseDrCrAmtVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ASAExpenseDrCrAmtVO .class);
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			} else {
				retVO.setAsaNo(asaNo);
				retVO.setChgTpCd(chgTpCd);
				retVO.setDebitAmt("0");
				retVO.setCreditAmt("0");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return retVO;
    }

    /**
     * Remittance Debit, Credit Amount
     * @author jinyoonoh 2014. 5. 14.
     * @param String asaNo
     * @return ASAExpenseDrCrAmtVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ASAExpenseDrCrAmtVO searchASARemittanceDrCrAmt(String asaNo) throws DAOException {
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        ASAExpenseDrCrAmtVO retVO = new ASAExpenseDrCrAmtVO();

		try {
			param.put("asa_no", asaNo);
			velParam.putAll(param);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableAgentDBDAOSearchASARemittanceDrCrAmtRSQL(),
							param, velParam);
			List<ASAExpenseDrCrAmtVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ASAExpenseDrCrAmtVO .class);
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			} else {
				retVO.setAsaNo(asaNo);
				retVO.setDebitAmt("0");
				retVO.setCreditAmt("0");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return retVO;
    }

    /**
     * Remittance Expense Debit, Credit Amount
     * @author jinyoonoh 2014. 5. 14.
     * @param String asaNo
     * @return ASAExpenseDrCrAmtVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ASAExpenseDrCrAmtVO searchASARemittanceExpDrCrAmt(String asaNo) throws DAOException {
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        ASAExpenseDrCrAmtVO retVO = new ASAExpenseDrCrAmtVO();

		try {
			param.put("asa_no", asaNo);
			velParam.putAll(param);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableAgentDBDAOSearchASARemittanceExpDrCrAmtRSQL(),
							param, velParam);
			List<ASAExpenseDrCrAmtVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ASAExpenseDrCrAmtVO .class);
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			} else {
				retVO.setAsaNo(asaNo);
				retVO.setDebitAmt("0");
				retVO.setCreditAmt("0");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return retVO;
    }


    /**
     * Remittance Expense Debit, Credit Amount
     * @author jinyoonoh 2014. 5. 14.
     * @param String asaNo
     * @return BigDecimal
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public BigDecimal searchASABalanceFowardAmt(String asaNo) throws DAOException {
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        //ASAExpenseDrCrAmtVO retVO = new ASAExpenseDrCrAmtVO();

		try {
			param.put("asa_no", asaNo);
			velParam.putAll(param);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableAgentDBDAOSearchASABalanceFowardAmtRSQL(),
							param, velParam);

			if(dbRowset.next()) {
				return dbRowset.getBigDecimal("BAL_AMT");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return new BigDecimal("0.00");
    }

    /**
     * ASA Actual Balance amount
     * for update ASA Master
     * @author jinyoonoh 2014. 5. 14.
     * @param String asaNo
     * @return BigDecimal
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public BigDecimal searchASAActualBalAmt(String asaNo) throws DAOException {
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        //ASAExpenseDrCrAmtVO retVO = new ASAExpenseDrCrAmtVO();

		try {
			param.put("asa_no", asaNo);
			velParam.putAll(param);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableAgentDBDAOSearchASAActualBalAmtRSQL(),
							param, velParam);

			if(dbRowset.next()) {
				return dbRowset.getBigDecimal("ACTUAL_BAL_AMT");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return new BigDecimal("0.00");
    }


    /**
     * ASA USD total Balance amount by ASA No
     * @author jinyoonoh 2014. 5. 14.
     * @param String asaNo
     * @param String asaPrdToDt
     * @return BigDecimal
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public BigDecimal searchAsaUsdTtlAmt(String asaNo, String asaPrdToDt) throws DAOException {
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("asa_no", asaNo);
			param.put("asa_prd_to_dt", asaPrdToDt);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableAgentDBDAOSearchAsaUsdTtlAmtRSQL(),
							param, velParam);

			if(dbRowset.next()) {
				return dbRowset.getBigDecimal("ASA_USD_AMT");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return new BigDecimal("0.00");
    }


    /**
     * OTS USD total Balance amount by office code
     * @author jinyoonoh 2014. 5. 14.
     * @param String asaNo
     * @param String asaPrdToDt
     * @param String otsOfcCd
     * @return BigDecimal
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public BigDecimal searchAcutalOTSAmtByOffcd(String asaNo, String asaPrdToDt, String otsOfcCd) throws DAOException {
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("asa_no", asaNo);
			param.put("asa_prd_to_dt", asaPrdToDt);
			param.put("ots_ofc_cd", otsOfcCd);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableAgentDBDAOSearchAcutalOTSAmtByOffcdRSQL(),
							param, velParam);

			if(dbRowset.next()) {
				return dbRowset.getBigDecimal("OTS_USD_AMT");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return new BigDecimal("0.00");
    }


    /**
     * Search ASA Collection & Refund for adjust
     * @author jinyoonoh 2014. 5. 28.
     * @param String asaNo
     * @return List<ASACltRfndAdjListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ASACltRfndAdjListVO> searchASACltRfndAdjList(String asaNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<ASACltRfndAdjListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("asa_no", asaNo);
        	velParam.putAll(param);
    	   dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOSearchASACltRfndAdjListRSQL(), param, velParam);
    	   list = (List)RowSetUtil.rowSetToVOs(dbRowset, ASACltRfndAdjListVO .class);
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
     * Sum ASA Collection & Refund TTL Amount
     * @author jinyoonoh 2014. 5. 28.
     * @param String asaNo
     * @return ASACltRfndTTLAmtVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ASACltRfndTTLAmtVO searchASACltRfndTTLAmt(String asaNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<ASACltRfndTTLAmtVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("asa_no", asaNo);
        	velParam.putAll(param);
    	    dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOSearchASACltRfndTTLAmtRSQL(), param, velParam);
    	    list = (List)RowSetUtil.rowSetToVOs(dbRowset, ASACltRfndTTLAmtVO .class);

    	    if (list != null && !list.isEmpty()) {
    	    	return list.get(0);
    	    }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return null;
    }



	/**
	 * Update ASA No Sequence<br>
	 * @author jinyoonoh 2014. 5. 12.
	 * @param SarAgnCltRfndMstVO paramVO
	 * @throws DAOException
	 */
	public void modifySarGgnCltRfndMst (SarAgnCltRfndMstVO paramVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = paramVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate(new AccountReceivableAgentDBDAOUpdateSarAgnCltRfndMstUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}



    /**
     * Search Agent Collection & Refund USD Local Amount Summary
     * @author jinyoonoh 2014. 8. 18.
     * @param String asaNo
     * @return List<AGnCltRfndUsdLclAmtSumVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<AGnCltRfndUsdLclAmtSumVO> searchAGnCltRfndUsdLclAmtSum(String asaNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<AGnCltRfndUsdLclAmtSumVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("asa_no", asaNo);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableAgentDBDAOSearchAGnCltRfndUsdLclAmtSumRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AGnCltRfndUsdLclAmtSumVO.class);
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
     * Search Agent Collection & Refund Third Amount Summary
     * @author jinyoonoh 2014. 8. 18.
     * @param String asaNo
     * @return List<AGnCltRfndN3rdAmtSumVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<AGnCltRfndN3rdAmtSumVO> searchAGnCltRfndN3rdAmtSum(String asaNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<AGnCltRfndN3rdAmtSumVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("asa_no", asaNo);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							new AccountReceivableAgentDBDAOSearchAGnCltRfndN3rdAmtSumRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AGnCltRfndN3rdAmtSumVO.class);
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
     * Agent Collection Entry<br><br>
     *
     * @author myoungsin park
     * @category STM_SAR_5002
     * @category searchAgentCollectionList
     * @param  ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO
     * @return CheckASAperiodVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public CheckASAperiodVO searchASAperiod(ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO) throws DAOException {
        DBRowSet dbRowset = null;

        List<CheckASAperiodVO> list = null;
        CheckASAperiodVO returnVO =  new CheckASAperiodVO();

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

       try {

    	   if(aSAInfoByOfcAgnVO != null){
				Map<String, String> mapVO = aSAInfoByOfcAgnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
            dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOsearchASAperiodRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckASAperiodVO.class);

            if(list.size() > 0){
            	returnVO = list.get(0);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
       	return returnVO;
    }

    /**
     * Agent Collection Entry<br><br>
     *
     * @author myoungsin park
     * @category STM_SAR_5002
     * @category searchAgentCollectionList
     * @param  ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO
     * @return CheckASAperiodVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public CheckPreASAStausVO searchPreASAStatus(ASAInfoByOfcAgnVO aSAInfoByOfcAgnVO) throws DAOException {
    	DBRowSet dbRowset = null;

    	List<CheckPreASAStausVO> list = null;
    	CheckPreASAStausVO returnVO =  new CheckPreASAStausVO();

    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();

    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();

    	try {

    		if(aSAInfoByOfcAgnVO != null){
    			Map<String, String> mapVO = aSAInfoByOfcAgnVO.getColumnValues();

    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}
    		dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOsearchPreASAStatusRSQL(), param, velParam);
    		list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckPreASAStausVO.class);

    		if(list.size() > 0){
    			returnVO = list.get(0);
    		}
    	}catch(SQLException se){
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage());
    	}catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage());
    	}
    	return returnVO;
    }

    /**
   	 * search SCO_BAT_HIS seq. <br>
   	 *
   	 * @return String
   	 * @exception DAOException
   	 * @throws DAOException
   	 */
   	 public String searchBatHisSeqData() throws DAOException{
   	 	DBRowSet dbRowset = null;
   	 	String returnVal = "";
   	 	Map<String, Object> param = new HashMap<String, Object>();
   	 	//velocity parameter
   	 	Map<String, Object> velParam = new HashMap<String, Object>();

   	 	try{
   	 		dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOsearchBatHisSeqDataRSQL(), param, velParam);
   	 		if(dbRowset.next()){
   	 			returnVal = dbRowset.getString("SEQ");
   	 		}
   	 	}catch(SQLException se){
   	 		log.error(se.getMessage(),se);
   	 		throw new DAOException(new ErrorHandler(se).getMessage());
   	 	}catch(Exception ex){
   	 		log.error(ex.getMessage(),ex);
   	 		throw new DAOException(new ErrorHandler(ex).getMessage());
   	 	}
   	 	return returnVal;
   	 }

   	/**
   	 * Insert into SCO_BAT_HIS <br>
   	 * @author myoungsin park
   	 * @param BatHisVO paramVO
   	 * @throws DAOException
   	 */
   	public void addBatHis(BatHisVO paramVO) throws DAOException,Exception {
   		//query parameter
   		Map<String, Object> param = new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam = new HashMap<String, Object>();
   		try {

   			Map<String, String> mapVO = paramVO.getColumnValues();

   			param.putAll(mapVO);
   			velParam.putAll(mapVO);
   			SQLExecuter sqlExe = new SQLExecuter("");
   			sqlExe.executeUpdate(new AccountReceivableAgentDBDAOaddBatHisCSQL(), param, velParam);
   		}catch(SQLException se){
   			log.error(se.getMessage(),se);
   			throw new DAOException(new ErrorHandler(se).getMessage(),se);
   		}catch(Exception ex){
   			log.error(ex.getMessage(),ex);
   			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
   		}
   	}

   	/**
        * STM_SAR_5002 : searchBatHisStatus
        *
        * @author myoungsin park
        * @param String batSeq
        * @return BatHisVO
        * @exception DAOException
        */
       @SuppressWarnings("unchecked")
       public BatHisVO searchBatHisStatus(String batSeq) throws DAOException {
       	DBRowSet dbRowset = null;

       	List<BatHisVO> list = null;
       	BatHisVO returnVO =  new BatHisVO();

       	//query parameter
       	Map<String, Object> param = new HashMap<String, Object>();
       	//velocity parameter
       	Map<String, Object> velParam = new HashMap<String, Object>();
       	try {
       		param.put("bat_seq",batSeq);
       		dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOsearchBatHisStatusRSQL(), param, velParam);
       		list = (List)RowSetUtil.rowSetToVOs(dbRowset, BatHisVO.class);

       		if(list.size() > 0){
       			returnVO = list.get(0);
       		}
       	}catch(SQLException se){
       		log.error(se.getMessage(),se);
       		throw new DAOException(new ErrorHandler(se).getMessage());
       	}catch(Exception ex){
       		log.error(ex.getMessage(),ex);
       		throw new DAOException(new ErrorHandler(ex).getMessage());
       	}
       	return returnVO;
       }
       
       /**
        * Search Open ASA list
        * @author myoungsin park
        * @param String asaNo
        * @return List<ASAnoListVO>
        * @throws DAOException
        */
       @SuppressWarnings("unchecked")
       public List<ASAnoListVO> searchOpenAsa(String asaNo) throws DAOException {
           DBRowSet dbRowset = null;
           List<ASAnoListVO> list = null;
           //query parameter
           Map<String, Object> param = new HashMap<String, Object>();

           //velocity parameter
           Map<String, Object> velParam = new HashMap<String, Object>();

           try {
        		param.put("asa_no", asaNo);
            	velParam.putAll(param); 
            	dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOsearchOpenAsaRSQL(), param, velParam);
            	list = (List)RowSetUtil.rowSetToVOs(dbRowset, ASAnoListVO .class);
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
   	 * [STM_SAR_500] Agent Statement of Account Entry
   	 * searchASAApprovalCheck<br> 
   	 * @author JBLEE
   	 * @param String asaNo
   	 * @return String
   	 * @exception DAOException
   	*/
   	public String searchASAApprovalCheck(String asaNo) throws DAOException {
   		
   		DBRowSet dbRowset = null;
   		String rtnCnt = "";
   		//query parameter
   		Map<String, Object> param = new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam = new HashMap<String, Object>();
   	
   		try{
   			
   			param.put("asa_no", asaNo);		
   			velParam.put("asa_no", asaNo);	
   			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOSearchASAApprovalCheckRSQL(), param, velParam);
   			
   			if(dbRowset.next()) {								
   				rtnCnt = dbRowset.getString("BAT_RSLT_CD");
   			}     
   			
   		} catch(SQLException se) {
   			log.error(se.getMessage(), se);
   			throw new DAOException(new ErrorHandler(se).getMessage());
   		} catch(Exception ex) {
   			log.error(ex.getMessage(), ex);
   			throw new DAOException(new ErrorHandler(ex).getMessage());
   		}
   		return rtnCnt;
   	}
   	
   	/**
	 * [STM_SAR_5002]
	 * Search duplicated collection/refund B/L list<br> 
	 * 
	 * @author SYPARK
	 * @param String asaNo
	 * @return String
	 * @exception DAOException
	*/
	public String searchDuplicateColRfnd(String asaNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String blList = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("asa_no", asaNo);		
			velParam.put("asa_no", asaNo);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableAgentDBDAOSearchDuplicateColRfndRSQL(), param, velParam);
			if(dbRowset.next()) {								
				blList = dbRowset.getString("bl_list");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return blList;
	} 	
	
	/**
     * Agent Collection Entry<br><br>
     *
     * @author YJLEE
     * @category STM_SAR_5001
     * @category addAgentCollectionList
     * @param List<AgentCollectionListVO> agentCollectionListVOs
     * @throws DAOException
     */
	public void addAgentCollectionTempList(List<AgentCollectionListVO> agentCollectionListVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (agentCollectionListVOs.size() > 0) {
				updCnt = sqlExe.executeBatch(new AccountReceivalbeAgentDBDAOaddAgentCollectionTempListCSQL(), agentCollectionListVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
  	 * [STM_SAR_5002] Agent Statement of Account Entry
  	 * searchUnreportedFlag<br> 
  	 * @author ORKIM
  	 * @param String asaNo
  	 * @return String
  	 * @exception DAOException
  	*/
  	public String searchUnreportedFlag(String asaNo) throws DAOException {
  		
  		DBRowSet dbRowset = null;
  		String rtnStr = "";
  		//query parameter
  		Map<String, Object> param = new HashMap<String, Object>();
  		//velocity parameter
  		Map<String, Object> velParam = new HashMap<String, Object>();
  	
  		try{
  			
  			param.put("asa_no", asaNo);		
  			velParam.put("asa_no", asaNo);	
  			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableAgentDBDAOSearchUnreportedFlagRSQL(), param, velParam);
  			
  			if(dbRowset.next()) {								
  				rtnStr = dbRowset.getString("AGN_OTS_LMT_FLG");
  			}     
  			
  		} catch(SQLException se) {
  			log.error(se.getMessage(), se);
  			throw new DAOException(new ErrorHandler(se).getMessage());
  		} catch(Exception ex) {
  			log.error(ex.getMessage(), ex);
  			throw new DAOException(new ErrorHandler(ex).getMessage());
  		}
  		return rtnStr;
  	}	
  	
	/**
	 * batch 가 running 상태일 경우, E로 update
	 * 
	 * @param batSeq
	 * @throws DAOException
	 */
	public void manageCancelASABat(String batSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {

			param.put("bat_seq",batSeq);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableAgentDBDAOManageCancelASABatUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
  	
}