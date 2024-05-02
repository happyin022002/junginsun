/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAO.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.08 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstApprovalVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstRequestCheckVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstShHistVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstShRInqVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.DmtScExptVerVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForCalculationVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltAmdtHisMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpAmdHstMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpInqVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropAmdtSmryVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropMnInqVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropMnScpInqListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropMnScpListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltReturnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaMainStsVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltStatusVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpAproRqstRefUsrVO;
import com.clt.syscommon.common.table.PriRpAproRqstRefVO;
import com.clt.syscommon.common.table.PriRpHdrVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpProgVO;
import com.clt.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpProgVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;


/**
 *  RFAProposalMainDBDAO <br>
 * - RFAProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Byeon Young Joo
 * @see RFAProposalMainBCImpl 참조
 * @since J2EE 1.4
 */
public class RFAProposalMainDBDAO extends DBDAOSupport {

	/**
	 * RFA Main 정보를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
     * @param SignOnUserAccount account
	 * @return List<RsltPropMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropMnVO> searchProposalMain(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("rfa_no", priRpHdrVO.getRfaNo());

		try{
			if(priRpHdrVO != null){
				Map<String, String> mapVO = priRpHdrVO .getColumnValues();
				mapVO.put("usr_id",account.getUsr_id());
				mapVO.put("srep_cd",account.getSrep_cd());	
				mapVO.put("ofc_cd",account.getOfc_cd());	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltPropMnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * RFA Scope 정보를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param String usrId
	 * @return List<RsltPropMnScpListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropMnScpListVO> searchProposalMainScpList(PriRpHdrVO priRpHdrVO, String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnScpListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("rfa_no", priRpHdrVO.getRfaNo());
		
		try{
			if(priRpHdrVO != null){
				Map<String, String> mapVO = priRpHdrVO .getColumnValues();
				mapVO.put("usr_id",usrId);			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltPropMnScpListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnScpListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 *   Customer 정보를 조회합니다.<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltPropCustInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropCustInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * RFA Header 정보를 추가합니다.<br>
	 * 
	 * @param List<PriRpHdrVO> insModels
	 * @exception DAOException
	 */
	public void addProposalHeader(List<PriRpHdrVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpHdrVOCSQL(), insModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * RFA Main 정보를 추가합니다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalMain(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpMnVOCSQL(), insModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * RFA Header 정보를 수정합니다.<br>
	 * 
	 * @param List<PriRpHdrVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalHeader(List<PriRpHdrVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpHdrVOUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * RFA Main 정보를 수정합니다.<br>
	 * 
	 * @param List<PriRpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalMain(List<PriRpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("init_cancel", "N");
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpMnVOUSQL(), updModels,velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * RFA Scope 정보를 추가합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeMain(List<PriRpScpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnVOCSQL(), insModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/**
	 * RFA Scope 정보를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeMain(List<PriRpScpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 * RFA Main 정보를 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalScopeMain(List<PriRpScpMnVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "N");
								
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
     * 새로운 RFA Proposal Number 를 조회합니다.<br>
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
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltCrePropNoVORSQL(),
                    param, velParam);
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
	 * Main Progress  테이블에 데이터를 추가 합니다.<br>
	 * 
	 * @param List<PriRpProgVO> insModels
	 * @exception DAOException
	 */
	public void addProposalProgress(List<PriRpProgVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpProgVOCSQL(), insModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	  
	
	/**
	 * Main의 Amendment Summary Table에 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriRpAmdtSmryVO> insModels
	 * @exception DAOException
	 */
	public void addProposalAmendmentSummary(List<PriRpAmdtSmryVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpAmdtSmryVOCSQL(), insModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		

    /**
     * Proposal Main Amendment Summary 테이블에 데이터를 추가 합니다.<br>
     * 
     * @param PriRpAmdtSmryVO priRpAmdtSmryVO
     * @exception DAOException
     */
    public void addProposalAmendmentSummary(PriRpAmdtSmryVO priRpAmdtSmryVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpAmdtSmryVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAmdtSmryVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
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
	 * Scope의 상태코드가 변경될 때 Scope Progress 테이블에 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriRpScpProgVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeProgress(List<PriRpScpProgVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpProgVOCSQL(), insModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Scope의 상태코드가 변경될 때 Scope Progress 테이블에 추가합니다.<br>
	 * 
	 * @param PriRpScpProgVO vo
	 * @exception DAOException
	 */
	public void addProposalScopeProgressChange(PriRpScpProgVO vo) throws DAOException {
		
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
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpProgChgVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	
	/**
	 * Proposal Scope Amendment Summary 테이블에 데이터를 추가 합니다.<br>
	 * 
	 * @param List<PriRpScpAmdtSmryVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeAmendmentSummary(List<PriRpScpAmdtSmryVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpAmdtSmryVOCSQL(), insModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param List<PriRpScpMnVO> delModels
	 * @exception EventException
	 */
    public void removeProposalScopeAmdtSmry(List<PriRpScpMnVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
							
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpAmdtSmryVODSQL(), delModels,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}       
    	
    }		
    
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param List<PriRpScpMnVO> delModels
	 * @exception EventException
	 */
    public void removeProposalScopeProgress(List<PriRpScpMnVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
							
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpProgressVODSQL(), delModels,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}      
    }	    
	
    
	/**
	 * Amendment Summary 데이터를 Accept, Accept Cancel 상태로 수정합니다.<br>
	 * 
	 * @param List<PriRpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalAutoAcceptAmendmentSummary(List<PriRpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();	
				velParam.put("auto_accept", "Y");	
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpAmdtSmryAllVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	/**
	 * 자동  Accept되는 Terms의 상태 Flag를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeAutoAcceptAmendmentSummary(List<PriRpScpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("auto_accept", "Y");		
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpAllAmdtSmryVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
		
    
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpScpMnVO vo
	 * @exception EventException
	 */
    public void removeProposalScopeAmdtSmry(PriRpScpMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAmdtSmryVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
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
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpScpMnVO vo
	 * @exception EventException
	 */
    public void removeProposalScopeProgress(PriRpScpMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpProgressVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
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
     * Terms의 Amendment Summary 정보를 조회 합니다.<br>
	 * 
	 * @param PriRpAmdtSmryVO priRpAmdtSmryVO
	 * @return List<RsltPropAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropAmdtSmryVO> searchProposalAmendmentSummary(PriRpAmdtSmryVO priRpAmdtSmryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropAmdtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpAmdtSmryVO != null){
				Map<String, String> mapVO = priRpAmdtSmryVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltPropAmdtSmryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropAmdtSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}    
	
	/**
     * Scope Terms의 Amendment Summary 정보를 조회 합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummary(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpAmdtSmryVO != null){
				Map<String, String> mapVO = priRpScpAmdtSmryVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltPropScpAmdtSmryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
     * Terms가 ACCEPT 되었는지 조회 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriRpMnVO> searchProposalAcceptCheck (PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltAcceptListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriRpMnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}		
	
	/**
	 * C/OFFER 시 TERMS에 INIT인 데이터가 있는지 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltStatusVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltStatusVO> searchCountOfferStatus(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltStatusVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltStatusVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}		
	
	/**
	 * Rate Commodity Header 는 있고 detail은 없는 데이터를 조회합니다.<br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<CstRequestCheckVO> 
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CstRequestCheckVO> searchRequestTermsCheck(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstRequestCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORequestCheckVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstRequestCheckVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	 
	/**
	 * Request 전 Calculate를 하지 않은 Scope를 조회합니다.<br>
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RequestCheckForCalculationVO> searchRequestCheckCalculate(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RequestCheckForCalculationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpMnVO != null){
				Map<String, String> mapVO = priRpScpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORequestCheckForCalculationVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RequestCheckForCalculationVO .class);
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
	 * Scope의 상태를 조회합니다. <br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<PriRpScpMnVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriRpScpMnVO> searchProposalScopeStatusCheck (PriRpScpMnVO priRpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpScpMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpMnVO != null){
				Map<String, String> mapVO = priRpScpMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnStatusCheckVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriRpScpMnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}			
	
	/**
	 * Scope삭제시 Terms의 데이터가 있는지 확인합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMn
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck (PriRpScpMnVO priRpScpMn) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try{
			if(priRpScpMn != null){
				Map<String, String> mapVO = priRpScpMn .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpCntVORSQL(), param, velParam);
            if (dbRowset.next()) {
            	cnt = dbRowset.getInt(1);            
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}		
	
	/**
     * Request 시 자동으로 Accept된 Terms를 Init 상태로 수정합니다.<br>
	 * 
	 * @param List<PriRpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalRequestCancelAmendmentSummary(List<PriRpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();	
				velParam.put("auto_accept", "N");	
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpAmdtSmryAllVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * 자동 Accept된 Terms의 Amendement Summary데이터를 이전 상태로 수정합니다.<br>
	 * 
	 * @param List<PriRpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeRequestCancelAmendmentSummary(List<PriRpScpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("auto_accept", "N");		
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpAllAmdtSmryVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Scope의 상태를 일괄 변경합니다.<br>
	 * 
	 * @param  PriRpScpMnVO vo
	 * @exception DAOException
	 */
	public void modifyAllScopeStatus(PriRpScpMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnAllStatusVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception DAOException
	 */
	public void modifyProposalMainExpiry(PriRpMnVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			velParam.put("init_cancel", "Y");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpMnVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	} 
	
    /**
     *  Init Cancel시 Main 데이터를 삭제처리합니다.<br>
     * 
     * @param PriRpMnVO vo
     * @exception DAOException
     */
    public void removeProposal (PriRpMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpMnVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
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
     *  Init Cancel시 Header 데이터를 삭제처리합니다.<br>
     * 
     * @param PriRpMnVO vo
     * @exception DAOException
     */
    public void removeProposalHdr (PriRpMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpHdrVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
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
     *  Init Cancel시 AproRqstRef 데이터를 삭제처리합니다.<br>
     * 
     * @param PriRpMnVO vo
     * @exception DAOException
     */
    public void removeProposalAproRqstRef (PriRpMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAproRqstRefInitVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
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
     *  Init Cancel시 AproRqstRefUsr 데이터를 삭제처리합니다.<br>
     * 
     * @param PriRpMnVO vo
     * @exception DAOException
     */
    public void removeProposalAproRqstRefUsr (PriRpMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAproRqstRefUsrInitDSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
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
	 * Init Cancel시 Amend seq에 해당하는 Main Progress 의 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception EventException
	 */
    public void removeProposalProgress(PriRpMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpProgressVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
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
	 * Init Cancel시 Amend seq에 해당하는 Amend Summary 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception EventException
	 */
    public void removeProposalAmdtSmry(PriRpMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAmdtSmryVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
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
	 * Init Cancel시 Amend seq에 해당하는 Scope Main 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpScpMnVO vo
	 * @exception EventException
	 */
    public void removeProposalScopeMain(PriRpScpMnVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpMnVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
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
	 * Scope MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriRpScpMnVO vo
	 * @exception DAOException
	 */
	public void modifyProposalScopeMainExpiryChange(PriRpScpMnVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			velParam.put("init_cancel", "Y");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnExpVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}      
	
	/**
     * Main Amendment Summary 를 수정합니다.<br>
	 * 
	 * @param List<PriRpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalAmendmentSummary(List<PriRpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("prop_term_tp_cd", updModels.get(0).getPropTermTpCd());								
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpAmdtSmryVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
    /**
     * RFA Proposal Main Amendment Summary 정보를 Copy 하여 수정합니다.<br>
     * 
     * @param PriRpAmdtSmryVO priRpAmdtSmryVO
     * @exception DAOException
     */
    public void modifyProposalAmendmentSummary(PriRpAmdtSmryVO priRpAmdtSmryVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpAmdtSmryVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpAmdtSmryVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
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
     * S/C Proposal Scope Main 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeMain (RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPropCpPriRpScpMnCSQL(),
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

	/**
     * Proposal Scope Amendment Summary 정보를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeAmendmentSummary(List<PriRpScpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("prop_scp_term_tp_cd", updModels.get(0).getPropScpTermTpCd());		
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpAmdtSmryVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * RFA Proposal Scope Amendment Summary 정보를 한건 씩 수정합니다.<br>
     * 
     * @param PriRpScpAmdtSmryVO vo
     * @exception DAOException
     */
    public void modifyProposalScopeAmendmentSummary (PriRpScpAmdtSmryVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriRpScpAmdtSmryVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
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
	 * Scope Main의 Status를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpAmdtSmryVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeStatus(List<PriRpScpAmdtSmryVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpStsUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Summary table에서 Accept 처리된 데이터를 조회합니다. <br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchProposalScopeAcceptCheck (PriRpScpMnVO priRpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try{
			if(priRpScpMnVO != null){
				Map<String, String> mapVO = priRpScpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnStatusVORSQL(), param, velParam);
            if (dbRowset.next()) {
            	cnt = dbRowset.getInt(1);            
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}	
	
	/**
	 * Scope Main의 Status를 수정합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyScopeStatus(List<PriRpScpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnStatusVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
    /**
     * Terms중 하나라도 Returned 가 있다면 Scope의 상태를 Returned로 변경합니다.<br>
     * 
     * @param PriRpScpMnVO vo
     * @exception EventException
     */
    public void modifyAutoScopeReturnStatus(PriRpScpMnVO vo) throws DAOException {
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
            result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnReturnedVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }	
	
	/**
	 * Scope Progress와 Scope main의 상태를 조회합니다. <br>
	 * 
     * @param PriRpScpMnVO priRpScpMn
	 * @return int
	 * @exception DAOException
	 */
	public int searchScopeProgressStatus (PriRpScpMnVO priRpScpMn) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try{
			if(priRpScpMn != null){
				Map<String, String> mapVO = priRpScpMn .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnProgVORSQL(), param, velParam);
            if (dbRowset.next()) {
            	cnt = dbRowset.getInt(1);
            
            }

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}      
	
	/**
	 * Scope Main의 Progress테이블에 데이터를 추가합니다. <br>
	 * 
     * @param List<PriRpScpProgVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeProgressScopeMn(List<PriRpScpProgVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnProgVOCSQL(), insModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/**
	 * Proposal Main의 status 를 수정합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @exception DAOException
	 */
	public void modifyMainStatus(PriRpMnVO priRpMnVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPriStatusVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
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
     * Scope MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalScopeMainExpiry(PriRpMnVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			velParam.put("init_cancel", "N");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnExpVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	} 	
	
	
	/**
	 *  새로운 Proposal Number 를 조회합니다.<br>
	 * 
	 * @param String ofcCd
	 * @param String trfCtrtFlg  2014.10.15 (ADD : When it is Tariff, create RFA No)
	 * @return String
	 * @exception DAOException
	 * @LastModifier 2014.10.15
	 */
	public String searchCreationRFANo(String ofcCd, String trfCtrtFlg) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			param.put("trf_ctrf_flg", trfCtrtFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltCreRFANoVORSQL(), param, velParam);
			dbRowset.next();
			rtnVal = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}
	
	/**
	 *  새로운 Proposal Number 를 조회합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCreationRFANo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltCreRFANoVORSQL(), param, velParam);
			dbRowset.next();
			rtnVal = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVal;
	}
	
	/**
	 * 해당 조건의 Proposal Main 데이터를 Amend Seq + 1하여 추가합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @exception DAOException
	 */
	public void addProposalMainAmend(PriRpMnVO priRpMnVO) throws DAOException {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpMnVO.getColumnValues();
			param.putAll(mapVO);
            velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpMnAmdVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 해당 조건의 Proposal Scope 데이터를 Amend Seq + 1하여 추가합니다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeMainAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnAmdVOCSQL(), insModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * 이전 Amend Seq의 Main Expire Date를 수정합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalMainAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpMnAmdVOUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * 이전 Amend Seq의 Main Expire Date를 수정합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeMainAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnAmdVOUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Main Progress 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalProgressAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			//query parameter
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpProgAmdVOCSQL(), insModels, null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Main Amendment Summary 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalAmendmentSummaryAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpAmdtSmryAmdVOCSQL(), insModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Scope Progress 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeProgressAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){

				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpProgAmdVOCSQL(), insModels, null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/**
	 * Scope Amendment Summary 데이터를 현재 Amend No + 1하여 추가합니다. <br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addProposalScopeAmendmentSummaryAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpAmdtSmryAmdVOCSQL(), insModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/**
	 * c/offer 이 있는 terms 에서 returned 인 데이터를 조회합니다.<br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltReturnVO> 
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltReturnVO> searchProposalReturnedList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltReturnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltReturnVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltReturnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	 	
	 
	/**
	 * Main status 를 Returned 에서 Request로 변경합니다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAutoChangeMainStatus(PriRpMnVO vo) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpMnAutoVOUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}		
	
	/**
	 * Scope 코드를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpScpMnVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriRpScpMnVO> searchProposalScope(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpScpMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpAutoVORSQL(), param, velParam);
		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriRpScpMnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	 
	/**
	 * Approve Cancel시 Main Expire Date를 Approve 이전 값으로 수정합니다.
	 * @param PriRpMnVO priRpMnVO
	 * @exception DAOException
	 */
	public void modifyProposalApproveCancelMain(PriRpMnVO priRpMnVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("<<<<<<<<<<<<<<<<<<<<<<<manageProposalApproveCancel<<<<<<<<<<<<<<<<<<<<<<<");
		int result = 0;
		try {
			Map<String, String> mapVO = priRpMnVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpMnApproveCancelVOUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Approve Cancel시 Scope Expire Date를 Approve 이전 값으로 수정합니다.
	 * @param PriRpMnVO priRpMnVO
	 * @exception DAOException
	 */
	public void modifyProposalApproveCancelScopeMain(PriRpMnVO priRpMnVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("<<<<<<<<<<<<<<<<<<<<<<<manageProposalApproveCancel<<<<<<<<<<<<<<<<<<<<<<<");
		int result = 0;
		try {
			Map<String, String> mapVO = priRpMnVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnApproveCancelVOUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
			 
	/**
	 * DMT_SC_EXPT_VER에서  Status를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<DmtScExptVerVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<DmtScExptVerVO> searchCheckDmdtList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DmtScExptVerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAODmtScExptVerVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtScExptVerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	 
	/**
	 * Duration(Main,Scope)과 Dem/Det 데이터가 변경 되었는지 조회 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCheckDurationList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltRequestCheckVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	 
	 
	

	/**
	 * Amend History Main 데이터를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltPriRpAmdHstMnVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriRpAmdHstMnVO> searchAmendmentHistoryMain(PriRpHdrVO priRpHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpAmdHstMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpHdrVO != null){
				Map<String, String> mapVO = priRpHdrVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltPriRpAmdHstMnVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpAmdHstMnVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	 
	/**
	 * Amend History List 데이터를 조회합니다.<br>
	 * 
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltAmdtHisMnVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltAmdtHisMnVO> searchAmendmentHistoryList(CstShHistVO cstShHistVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltAmdtHisMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstShHistVO != null){
				Map<String, String> mapVO = cstShHistVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltAmdtHisMnVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltAmdtHisMnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	 
	/**
	 * Amend 된 Terms를 조회합니다.<br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropScpAmdtSmryVO> searchHistoryAmendTermList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltHisAmdTermVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * Proposal No로 Scope Main에 등록된 모든 Scope을 조회합니다.<br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltCdListVO> searchHistoryScopeList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltHisScpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	 
	
	/**
	 *  Amend Summry 에서 amdt_flg가 Y 인 Terms 를 조회합니다 <br>
	 * 
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropScpAmdtSmryVO> searchAmendmentHistorySummary(CstShHistVO cstShHistVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstShHistVO != null){
				Map<String, String> mapVO = cstShHistVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltHisAmdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}			

    /**
     * RFA Proposal Affiliate 의 Copy 정보를 조회합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @return List<RsltRfaPropCopyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRfaPropCopyVO> searchProposalCopyAfilList (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRfaPropCopyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltRfaPropCopyVO != null) {
                Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropAfilVORSQL(), param,
                    velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaPropCopyVO.class);
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
     * RFA Proposal Main / Scope 의 Copy 정보를 조회합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @return List<RsltRfaPropCopyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRfaPropCopyVO> searchProposalCopyList (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRfaPropCopyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltRfaPropCopyVO != null) {
                Map<String, String> mapVO = rsltRfaPropCopyVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAORsltPropCopyVORSQL(), param,
                    velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaPropCopyVO.class);
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
     * RFA Proposal Main 정보를 Copy 해서 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalMain (RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPropCpPriRpMnCSQL(),
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
    
    /**
     * RFA Proposal HEADER 정보를 Copy 해서 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalHdr (RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPropCpPriRpHdrCSQL(),
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
    
    /**
     * RFA Proposal PROGRESS 정보를 Copy 해서 생성합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalProg (RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOPropCpPriRpProgCSQL(),
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

    /**
     * Proposal Request 테이블의 새로운 SEQ 를 조회합니다.<br>
     * 
     * @param PriRpAproRqstRefVO vo
     * @return String
     * @exception DAOException
     */
     public String searchProposalRequestNewSeq(PriRpAproRqstRefVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        String newSeq = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(vo != null){
                Map<String, String> mapVO = vo .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOPriRpAproRqstNewSeqRSQL(), param, velParam);
            
            if (dbRowset.next()) {
                newSeq = dbRowset.getString(1);
            } else {
                newSeq = "1";
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return newSeq;
    }

    /**
     * Proposal Request 정보를 생성합니다.<br>
     * 
     * @param PriRpAproRqstRefVO vo
     * @exception DAOException
     */
    public void addProposalRequestRef(PriRpAproRqstRefVO vo) throws DAOException {
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
            result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpAproRqstRefVOCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Proposal Request User 정보를 생성합니다.<br>
     * 
     * @param PriRpAproRqstRefUsrVO vo
     * @exception DAOException
     */
    public void addProposalRequestRefUser(PriRpAproRqstRefUsrVO vo) throws DAOException {
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
            result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpAproRqstRefUsrVOCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Proposal Request 의 상태를 수정합니다.<br>
     * 
     * @param PriRpAproRqstRefVO vo
     * @exception DAOException
     */
    public void modifyProposalRequestStatus(PriRpAproRqstRefVO vo) throws DAOException {
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
            result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpAproRqstRefVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * RFA 승인을 위해 접수한 Proposal Request 를 조회합니다.<br>
     * 
     * @param RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO
     * @return List<RsltRfaAproRqstRefVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked") 
    public List<RsltRfaAproRqstRefVO> searchProposalReceivedRequestList(RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRfaAproRqstRefVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rsltRfaAproRqstRefVO != null){
                Map<String, String> mapVO = rsltRfaAproRqstRefVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOPriRpAproRcvdRqstRefVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRfaAproRqstRefVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * RFA 승인을 위해 신청한 Proposal Request 를 조회합니다.<br>
     * 
     * @param RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO
     * @return List<RsltRfaAproRqstRefVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked") 
    public List<RsltRfaAproRqstRefVO> searchProposalSentRequestList(RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRfaAproRqstRefVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rsltRfaAproRqstRefVO != null){
                Map<String, String> mapVO = rsltRfaAproRqstRefVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOPriRpAproSentRqstRefVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRfaAproRqstRefVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * Proposal & Amendment Search List 를 조회합니다.<br>
	 * 
	 * @param CstShRInqVO cstShRInqVO
	 * @return List<RsltPriRpInqVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPriRpInqVO> searchProposalMainInquiryList(CstShRInqVO cstShRInqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpInqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstShRInqVO != null){
				Map<String, String> mapVO = cstShRInqVO .getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltPriRpInqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpInqVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * Proposal & Amendment Main을 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPropMnInqVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropMnInqVO> searchProposalMainInquiry(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnInqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltPropMnInqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnInqVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * Proposal & Amendment Scope List를  조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPropMnScpInqListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPropMnScpInqListVO> searchProposalMainScpInquiryList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropMnScpInqListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltPropMnScpInqListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropMnScpInqListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * Customer 데이터를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPropCustInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropCustInfoVO> searchProposalCustomerInfoInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltPropCustInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropCustInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	

	/**
	 * Summry 테이블에서 terms의 데이터가 수정 되었는지 조회합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummaryInquiry(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPropScpAmdtSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpScpAmdtSmryVO != null){
				Map<String, String> mapVO = priRpScpAmdtSmryVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltPropScpAmdtSmryInqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPropScpAmdtSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BKG_BOOKING,BKG_RATE테이블에서 사용되는 RFA_NO가 있는지 조회합니다. <br>
	 * @param CstApprovalVO cstApprovalVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltCdListVO> searchApprovalCancelCheck(CstApprovalVO cstApprovalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstApprovalVO != null){
				Map<String, String> mapVO = cstApprovalVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOApprovalCancelVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

    /**
     * Guideline Copy 대상 정보를 조회합니다.<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @return List<RpScpGlineCopyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked") 
    public List<RpScpGlineCopyVO> searchGuidelineCopyCheck(RpScpGlineCopyVO rpScpGlineCopyVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RpScpGlineCopyVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rpScpGlineCopyVO != null){
                Map<String, String> mapVO = rpScpGlineCopyVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOGlineCopyCheckSelectRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RpScpGlineCopyVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Copy 할 Guideline 의 gline_seq 를 가져온다. <br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @return String
     * @exception DAOException
     */
    public String searchCopyGlineSeq(RpScpGlineCopyVO rpScpGlineCopyVO) throws DAOException {
        DBRowSet dbRowset = null;
        String glineSeq = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(rpScpGlineCopyVO != null){
                Map<String, String> mapVO = rpScpGlineCopyVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOGlineCopyGetGlineSeqRSQL(), param, velParam);
            if (dbRowset.next()) {
                glineSeq = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return glineSeq;
    }
    
	/**
	 * Amend Request 시 Duration을 변경할 경우 Scope Main 의 Expire Date를 변경합니다.<br>
	 * 
	 * @param List<PriRpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalScopeMainAmd(List<PriRpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
	
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnAmdDurVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}						
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	    

       
    /**
     * Main의 상태를 조회한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltRfaMainStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRfaMainStsVO> searchProposalMainStatus (PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRfaMainStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltRfaMainStsVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRfaMainStsVO .class);
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
	 * Proposal No,Amend Seq 에 해당하는  Scope을 조회합니다.<br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<RsltCdListVO> searchScopeList(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORsltRfaMainStsVORSQL(), param, velParam);
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
     *  C/Offer/Request Cancel 시 Rate  CALCULATE  Flag를 변경합니다.<br>
     * 
     * @param PriRpScpMnVO priRpScpMnVO
     * @exception EventException
     */
    public void modifyPrsCalcFlgOnChangeStatus(PriRpScpMnVO priRpScpMnVO) throws DAOException,Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOPriRpScpMnPrsCalcFlgOnChangeStatusVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }  
    
	/**
	 * Accept 가능 테이블에서 Accept, Returned 데이터가 있는지 조회한다.<br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<CstRequestCheckVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CstRequestCheckVO> searchProposalRequestCancelCheck(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstRequestCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priRpMnVO != null){
				Map<String, String> mapVO = priRpMnVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAORequestCancelCheckVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CstRequestCheckVO .class);
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
     * Main Approval Date 를 수정합니다.<br>
	 * 
	 * @param List<PriRpMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalApprovalDate(List<PriRpMnVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("prop_sts_cd", updModels.get(0).getPropStsCd());								
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpMnAproDtVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		 
	 
	/**
	 * RFA No 정보를 입력 합니다.<br>
	 * 
	 * @param List<PriRpHdrVO> insModels
	 * @exception DAOException
	 */
	public void modifyProposalRFANO(List<PriRpHdrVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RFAProposalMainDBDAOPriRpHdrApproveVOUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/**
     * check the RFA No. to exists <br>
     *
     * @param PriRpHdrVO priRpHdrVo
     * @return String : Y/N
     * @exception DAOException
     * @LastModifyDate : 2014.11.04
     */
    public String checkRFAno(PriRpHdrVO priRpHdrVo) throws DAOException {
       
    	String isRFAno = "N";
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priRpHdrVo != null){
                Map<String, String> mapVO = priRpHdrVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFAProposalMainDBDAOCheckRFAnoRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
            	isRFAno = "Y";
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isRFAno;
    }
    
	/**
	 * RFA 계약의 Minimum Amend Seq를 확인합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCancelMinAmdtSeq(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		String minAmdtSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = priRpMnVO.getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAProposalMainDBDAOInitCancelMinAmdtSeqCheckRSQL(), param, velParam);
	        if(dbRowset.next()){
	        	minAmdtSeq = dbRowset.getString("amdt_seq");
	        }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return minAmdtSeq; 
	}
	
	/**
	 * RFA 삭제 정보를 추가합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void addContractAmendmentDeleteHistory(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws DAOException {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpMnVO.getColumnValues();

            param.putAll(mapVO);
            param.put("prc_ctrt_delt_usr_id", account.getUsr_id());
            param.put("usr_id", account.getUsr_id());
            
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAProposalMainDBDAOaddContractDeleteHistoryCSQL(), param, velParam);
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
	 * RFA Header  삭제 시 History Table에 관리합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param String amdtSeq
	 * @exception DAOException
	 */
	public void modifyContractHdrDeleteHistory(PriRpHdrVO priRpHdrVO, String amdtSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priRpHdrVO.getColumnValues();
			param.putAll(mapVO);
			param.put("amdt_seq", amdtSeq);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RFAProposalMainDBDAOmodifyContractHdrDeleteHistoryUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
}