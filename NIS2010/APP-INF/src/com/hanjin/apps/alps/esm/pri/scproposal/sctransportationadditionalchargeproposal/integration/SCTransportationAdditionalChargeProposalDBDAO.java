/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAO.java
*@FileTitle : S/C Proposal Origin/Destination Arbitrary Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.18 김재연
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.basic.SCTransportationAdditionalChargeProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ArbitraryExcelDupCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstArbAcceptVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstPriSpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.IHCExcelDupCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.RsltAddChgListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;


/**
 * NIS2010 SCTransportationAdditionalChargeProposalDBDAO <br>
 * - NIS2010-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see SCTransportationAdditionalChargeProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class SCTransportationAdditionalChargeProposalDBDAO extends DBDAOSupport {
 
	/**
	 * Arbitrary List를 조회합니다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltAddChgListVO> searchArbitraryChargeList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltAddChgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpTrspAddChgVO != null){
				Map<String, String> mapVO = priSpScpTrspAddChgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAORsltAddChgListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltAddChgListVO .class);
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
	 * Arbitrary List를 생성한다.<br>
	 * 
	 * @param List<PriSpScpTrspAddChgVO> insModels
	 * @exception DAOException
	 */
	public void addArbitraryCharge(List<PriSpScpTrspAddChgVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgVOCSQL(), insModels,null);
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
	 * Arbitrary List를 수정한다.<br>
	 * 
	 * @param List<PriSpScpTrspAddChgVO> updModels
	 * @param String chkAccept
	 * @exception DAOException
	 */
	public void modifyArbitraryCharge(List<PriSpScpTrspAddChgVO> updModels, String chkAccept) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("is_accept", chkAccept);
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgVOUSQL(), updModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Arbitrary List를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpTrspAddChgVO> delModels
	 * @exception DAOException
	 */
	public void removeArbitraryCharge(List<PriSpScpTrspAddChgVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Arbitrary Cuideline Copy를 진행한다. <br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO vo
	 * @param SignOnUserAccount account
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean addCopyGuidelineArbitraryCharge(CstPriSpScpTrspAddChgVO vo, SignOnUserAccount account) throws DAOException,Exception {
		boolean rtnValue = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOCopyGuidelineArbitraryChargeCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			if(result > 0) {
				rtnValue = true;
			} else {
				rtnValue = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}
	
	/**
	 * Arbitrary Amend를 진행한다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addArbitraryChargeAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgAmdVOCSQL(), insModels,null);
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
     * S/C Proposal Scope Transportation Additional Charge 데이터를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeTransport(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCTransportationAdditionalChargeProposalDBDAOPropCpPriSpScpTrspAddChgCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Origin/Destination Arbitrary 를 Proposal 로 Copy 합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineArbitrary(SpScpGlineCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCTransportationAdditionalChargeProposalDBDAOGlineCopyPriSpScpTrspAddChgCSQL(),
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
	 * Guideline Copy 시 Copy할 Guideline이 존재하는지 확인한다. <br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchGuidelineArbitraryChargeExist(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean rtnVal = false;
		
		try{
			if(cstPriSpScpTrspAddChgVO != null){
				Map<String, String> mapVO = cstPriSpScpTrspAddChgVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOGuidelineArbitraryChargeExistRSQL(), param, velParam);		
			if(dbRowset.next() && dbRowset.getInt("CNT") > 0) {
				rtnVal = true;
			}
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
	 * Guideline Copy 시 Copy할 Guideline의 Gruop Location이 존재하는지 확인한다. <br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchGuidelineArbitraryChargeGroupLocationExist(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean rtnVal = true;
		
		try{
			if(cstPriSpScpTrspAddChgVO != null){
				Map<String, String> mapVO = cstPriSpScpTrspAddChgVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOGuidelineArbitraryChargeGroupLocationExistRSQL(), param, velParam);		
			if(dbRowset.next() && dbRowset.getInt("CNT") > 0) {
				rtnVal = false;
			}
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
	 * Terms의 데이터 수를 가져온다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriSpScpMnVO priSpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnt = 0;
		try{
			if(priSpScpMnVO != null){
				Map<String, String> mapVO = priSpScpMnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgDeleteChkVORSQL(), param, velParam);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRequestCancel(PriSpScpMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgRequestCancelVOUSQL(), param, velParam);
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
	
	/**
     *  SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpMnVO vo
     * @exception DAOException
     */
    public void removeProposal(PriSpScpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspMainVODSQL(), param, velParam);
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
	 * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다.  <br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChkFontStyleVO> searchFontStyle(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChkFontStyleVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstPriSpScpTrspAddChgVO != null){
				Map<String, String> mapVO = cstPriSpScpTrspAddChgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOChkFontStyleVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChkFontStyleVO .class);
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
	 * Arbitrary Amend History List를 조회합니다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltAddChgListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltAddChgListVO> searchArbitraryChargeHistoryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltAddChgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpTrspAddChgVO != null){
				Map<String, String> mapVO = priSpScpTrspAddChgVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
				velParam.putAll(mapVO);
				velParam.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAORsltAddChgHistoryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltAddChgListVO .class);
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
	 * Arbitrary Amend History의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다.  <br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChkFontStyleVO> searchHistoryFontStyle(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChkFontStyleVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstPriSpScpTrspAddChgVO != null){
				Map<String, String> mapVO = cstPriSpScpTrspAddChgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOChkHistoryFontStyleRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChkFontStyleVO .class);
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
	 * Arbitrary Inquiry List를 조회합니다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltAddChgListVO> searchArbitraryChargeInquiryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltAddChgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpTrspAddChgVO != null){
				Map<String, String> mapVO = priSpScpTrspAddChgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAORsltAddChgInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltAddChgListVO .class);
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
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용한다. <br>
	 * 해당 Arbitrary 항목에 GRI를 적용한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO pVO
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationArbOK(PriSpScpTrspAddChgGriArbOKCLListVO pVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		int result = 0;
		try {
			Map<String, String> mapVO = pVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbOKUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbOKUSQL SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	 
	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용 취소를 한다. <br>
	 * Arbitrary 항목을 이전 값으로 되돌린다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO pVO
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationArbCancle(PriSpScpTrspAddChgGriArbOKCLListVO pVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		int result = 0;
		try {
			Map<String, String> mapVO = pVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbCancleUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to SCTransportationAdditionalChargeProposalDBDAOPriSpScpTrspAddChgGriArbCancleUSQL SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Arbitrary와 IHC 중복을 확인합니다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchArbitraryChargeDuplicate(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean rtnVal = false;
		
		try {
			if (priSpScpTrspAddChgVO != null) {
				Map<String, String> mapVO = priSpScpTrspAddChgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCTransportationAdditionalChargeProposalDBDAOChkPriSpScpTrspAddChgRSQL(),
					param, velParam);
			if(dbRowset.next() && dbRowset.getInt("CNT") > 0) {
				rtnVal = true;
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
	
	/**
	 * Arbitrary 의 Status를 Accept로 수정합니다.<br>
	 * 
	 * @param CstArbAcceptVO cstArbAcceptVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllArbitrary (CstArbAcceptVO cstArbAcceptVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = cstArbAcceptVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOArbitraryAcceptAllVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}	
	
	/**
	 * Arbitrary 의 Status를 Accept 이전 상태로 수정합니다.<br>
	 * 
	 * @param CstArbAcceptVO cstArbAcceptVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllCancelArbitrary(CstArbAcceptVO cstArbAcceptVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = cstArbAcceptVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOArbitraryCancelAllVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}		
	
	
	/**
	 * 현 Amend Seq 의 Arbitrary 데이터를 조회한다.  <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<ArbitraryExcelDupCheckVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ArbitraryExcelDupCheckVO> searchArbitraryLoadExcelDupList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ArbitraryExcelDupCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpTrspAddChgVO != null){
				Map<String, String> mapVO = priSpScpTrspAddChgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOArbitraryExcelDupCheckVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArbitraryExcelDupCheckVO .class);
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
	 * LOCATION CODE와 GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @param String codeTp
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchExcelCodeList(RsltCdListVO rsltCdListVO, String codeTp) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.put("code_tp", codeTp);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAORsltCdListVORSQL(), param, velParam);
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
	 * LOCATION 의 존재 유무를 조회한다..<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchLocationExists(RsltCdListVO rsltCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO .getColumnValues();			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOExistsLocationVORSQL(), param, velParam);
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
	 * Group LOCATION 의 존재 유무를 조회한다..<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchGroupLocationExists(RsltCdListVO rsltCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO .getColumnValues();			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOExistsGrpLocationVORSQL(), param, velParam);
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
	 * Commodity 의 존재 유무를 조회한다..<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCommodityExists(RsltCdListVO rsltCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO .getColumnValues();			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOExistsCmdtVORSQL(), param, velParam);
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
	 * Group Commodity 의 존재 유무를 조회한다..<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchGroupCommodityExists(RsltCdListVO rsltCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO .getColumnValues();			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOExistsGrpCmdtVORSQL(), param, velParam);
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
	 * 현 Amend Seq 의 IHC Charge 데이터를 조회한다.  <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<IHCExcelDupCheckVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<IHCExcelDupCheckVO> searchIHCLoadExcelDupList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IHCExcelDupCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpTrspAddChgVO != null){
				Map<String, String> mapVO = priSpScpTrspAddChgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOIHCExcelDupCheckVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IHCExcelDupCheckVO .class);
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
	 * Init이외의 상태를 가지고 있는 데이터를 조회합니다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchArbGriCheck(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpTrspAddChgVO != null){
				Map<String, String> mapVO = priSpScpTrspAddChgVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCTransportationAdditionalChargeProposalDBDAOArbGriCheckVOUSQL(), param, velParam);		
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
	
}