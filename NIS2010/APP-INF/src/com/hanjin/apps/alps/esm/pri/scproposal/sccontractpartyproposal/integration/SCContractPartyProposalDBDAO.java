/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractPartyProposalDBDAO.java
*@FileTitle : Contract Parties Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.14 변영주
* 1.0 Creation
=========================================================
* History
* 2011.05.02 이행지 [CHM-201110601-01] [PRI] S/C Contract Parties Information 중 첨부 파일 소실 되는 문제 해결
*                                    Main에서 호출되는 S/C Contract Parties Information 정보 Update에는 파일수정하는 부분이 없는 쿼리로 새로 생성하여 연결
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청                                    
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.basic.SCContractPartyProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.CstPriSpCtrtPtyHVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.CstPriSpCtrtPtyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.PriSpCtrtPtyInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtCustTpVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyTypeVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSpCtrtCustTpVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;


/**
 * NIS2010 SCContractPartyProposalDBDAO <br>
 * - NIS2010-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Byeon Young Joo
 * @see SCContractPartyProposalBCImpl 참조
 * @since J2EE 1.4
 */ 
public class SCContractPartyProposalDBDAO extends DBDAOSupport {

	/**
	 * Contract Party 의 해당 Amend Seq 데이터를  Amend Seq + 1하여  추가 합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalContractPartyAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				} 
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Contract Customer Type 의 해당 Amend Seq 데이터를  Amend Seq + 1하여  추가 합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalContractCustomerTypeAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtCustTpAmdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	//==============================================================================================
	/**
	 * Contract Customer Type을 조회합니다.<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpCtrtCustTpVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpCtrtCustTpVO> searchProposalContractCustomerTypeList(PriSpCtrtCustTpVO priSpCtrtCustTpVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpCtrtCustTpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpCtrtCustTpVO != null){
				Map<String, String> mapVO = priSpCtrtCustTpVO .getColumnValues();			
				param.putAll(mapVO);
				param.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
				velParam.putAll(mapVO);
				velParam.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtCustTpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpCtrtCustTpVO .class);
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
	 * Contract Customer Type 데이터를 수정합니다.<br>
	 * 
	 * @param List<PriSpCtrtCustTpVO> updModels
	 * @exception DAOException
	 */ 
	public void modifyProposalContractCustomerType(List<PriSpCtrtCustTpVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtCustTpVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}						
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		 
	 
	 
	/**
	 * Contract Customer Type 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriSpCtrtCustTpVO> insModels
	 * @exception DAOException
	 */
	public void addProposalContractCustomerType(List<PriSpCtrtCustTpVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtCustTpVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	 

	
	
	//======================================22========================================================
	/**
	 * Contract Customer Parties 데이터를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpCtrtPtyVO> searchProposalContractPartyList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpCtrtPtyVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpCtrtPtyVO .class);
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
	 * Contract Party Type을 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyTypeVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpCtrtPtyTypeVO> searchProposalContractPartyTypeList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpCtrtPtyTypeVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyTypeVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpCtrtPtyTypeVO .class);
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
	 * Contract Parties 데이터를 수정합니다.<br>
	 * 
	 * @param List<PriSpCtrtPtyVO> updModels
	 * @exception DAOException
	 */ 
	public void modifyProposalContractParty(List<PriSpCtrtPtyVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}						
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Main화면에서 사용하는 Contract Parties 데이터를 수정합니다.<br>
	 * 
	 * @param List<PriSpCtrtPtyVO> updModels
	 * @exception DAOException
	 */ 
	public void modifyProposalContractPartyForMain(List<PriSpCtrtPtyVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyForMainVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}						
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	 
	 
	/**
	 * Contract Parties 데이터를 추가합니다.<br>
	 * 
	 * @param List<CstPriSpCtrtPtyVO> insModels
	 * @exception DAOException
	 */
	public void addProposalContractParty(List<CstPriSpCtrtPtyVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 * Contract Parties중 한진해운 데이터를 추가합니다.<br>
	 * 
	 * @param List<CstPriSpCtrtPtyHVO> insModels
	 * @exception DAOException
	 */
	public void addProposalContractPartyHanjin(List<CstPriSpCtrtPtyHVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractPartyProposalDBDAOCstPriSpCtrtPtyHVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}			
	
	/**
	 * Contract Parties 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpCtrtPtyVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalContractParty(List<PriSpCtrtPtyVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	 
	 
	 
	 
	 

		//==============================================================================================
	/**
	 * Max Proposal No. 를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCreationProposalNo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
//		List<RsltPropCustInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				param.put("ofc_cd", ofcCd);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCContractPartyProposalDBDAORsltCrePropNoVORSQL(), param, velParam);
				dbRowset.next();
				rtnVal = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnVal;
	}	

    /**
     * Proposal Contract Party 정보를 Copy 생성합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalContractParty (RsltPropCopyVO rsltPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCContractPartyProposalDBDAOPropCpPriSpCtrtPtyCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }

    /**
     * Proposal Contract Customer Type 정보를 Copy 생성합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalContractCustType (RsltPropCopyVO rsltPropCopyVO) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPropCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCContractPartyProposalDBDAOPropCpPriSpCtrtCustTpCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
    /**
     *  해당 Amend Seq 해당하는 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpMnVO vo
     * @exception DAOException
     */
    public void removeProposalCtrtPty (PriSpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");            
            sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCContractPartyProposalDBDAOPriSpCtrtPtyInitVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }				
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }	 
    
    /**
     *  해당 Amend Seq 해당하는 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpMnVO vo
     * @exception DAOException
     */
    public void removeProposalCustTp (PriSpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCContractPartyProposalDBDAOPriSpCtrtCustTpInitVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }       
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }	    
    
	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalCustTpRequestCancel(PriSpMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtCustTpRequestCancelVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	    
	
	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalCtrtPtyRequestCancel(PriSpMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyRequestCancelVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 *Option의 Font Amend Summary 를 조회한다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchProposalContractPartyFont(PriSpCtrtPtyVO priSpCtrtPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyFontVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
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
	 * Contract Parties Amend History List를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpCtrtPtyVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpCtrtPtyVO> searchProposalContractPartyHistoryList(PriSpCtrtPtyVO priSpCtrtPtyVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpCtrtPtyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpCtrtPtyVO != null){
				Map<String, String> mapVO = priSpCtrtPtyVO .getColumnValues();			
				param.putAll(mapVO);
				param.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
				velParam.putAll(mapVO);
				velParam.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpCtrtPtyVO .class);
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
	 * SC Contract Party History Option의 Font 처리를 위해 amend summary 를 조회한다 .<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchProposalContractPartyHistoryFont(PriSpCtrtPtyVO priSpCtrtPtyVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpCtrtPtyVO != null){
				Map<String, String> mapVO = priSpCtrtPtyVO .getColumnValues();			
				param.putAll(mapVO);
				param.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
				velParam.putAll(mapVO);
				velParam.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyHistoryFontVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}//SCContractPartyProposalDBDAOPriSpCtrtPtyFontVORSQL
		return list;
	}
	 
	/**
     * Contract Parties Information Inquiry List를 조회한다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<PriSpCtrtPtyInqVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriSpCtrtPtyInqVO> searchProposalContractPartyInquiryList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSpCtrtPtyInqVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyInqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSpCtrtPtyInqVO .class);
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
	 * Option의 Font 처리를 위하여 PRI_SP_AMDT_SMRY,PRI_SP_CTRT_PTY를 조회한다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchProposalContractPartyFontInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyFontVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
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
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL - 대상 테이블 : PRI_SP_CTRT_CUST_TP<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int addCopyToProposalSpCtrtCustTp(RsltCopyToProposalVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtCustTpCopyToProposalCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
			return result;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL - 대상테이블: PRI_SP_CTRT_PTY<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int addCopyToProposalSpCtrtPty(RsltCopyToProposalVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCContractPartyProposalDBDAOPriSpCtrtPtyCopyToProposalCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
			return result;
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		 
}
