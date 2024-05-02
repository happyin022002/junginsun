/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationProposalDBDAO.java
*@FileTitle : S/C Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.06 변영주
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.basic.SCGroupLocationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpLocVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;


/**
 * NIS2010 SCGroupLocationProposalDBDAO <br>
 * - NIS2010-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Byeon Young Joo
 * @see SCGroupLocationProposalBCImpl 참조
 * @since J2EE 1.4
 */ 
public class SCGroupLocationProposalDBDAO extends DBDAOSupport {
 
	 
	/**
	 * SCGroupLocationProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpGrpLocVO priSpScpGrpLocVO
	 * @param List<String> txtArr
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<RsltGrpLocListVO> searchGroupLocationRateApplyList (PriSpScpGrpLocVO priSpScpGrpLocVO, List<String> txtArr) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpLocVO != null){
				Map<String, String> mapVO = priSpScpGrpLocVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("txtArr", txtArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationProposalDBDAORsltRtApplyListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
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
	 * SCGroupLocationProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpGrpLocVO priSpScpGrpLocVO
	 * @param List<String> txtArr
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<RsltGrpLocListVO> searchGroupLocationRateAcceptedList (PriSpScpGrpLocVO priSpScpGrpLocVO, List<String> txtArr) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpLocVO != null){
				Map<String, String> mapVO = priSpScpGrpLocVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("txtArr", txtArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationProposalDBDAORsltRtAcceptedListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
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
	 * SCGroupLocationProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpLocDtlVO != null){
				Map<String, String> mapVO = priSpScpGrpLocDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationProposalDBDAORsltGrpLocDtlListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
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
	 * SCGroupLocationProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpGrpLocVO priSpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchGroupLocationList (PriSpScpGrpLocVO priSpScpGrpLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpLocVO != null){
				Map<String, String> mapVO = priSpScpGrpLocVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationProposalDBDAORsltGrpLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
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
	 * 다건의 Group Location 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpScpGrpLocVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocation(List<PriSpScpGrpLocVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocVOCSQL(), insModels,null);
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
	 * 다건의 Group Location 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriSpScpGrpLocVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupLocation(List<PriSpScpGrpLocVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocVOUSQL(), updModels,null);
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
	 * 다건의 Group Location 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriSpScpGrpLocVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupLocation(List<PriSpScpGrpLocVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocVODSQL(), delModels,velParam);
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
	 * 다건의 Group Location  Detail 데이터를 일괄적으로 갱신한다.<br>
	 * 해당 seq에 추가되지 않은 대상 Detail 데이터를 AD로 갱신한다.
	 * @param List<PriSpScpGrpLocVO> updModels
	 * @exception DAOException
	 */
	public void modifyDeleteGroupLocationDtl(List<PriSpScpGrpLocVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGrpAmdVOUSQL(), updModels, null);
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
	 * 다건의 Group Location Detail 데이터를 일괄적으로 삭제한다.<br>
	 * 해당 seq 에 신규 추가된 Location Detail 데이터를 일괄적으로 삭제함
	 * @param List<PriSpScpGrpLocVO> delModels
	 * @exception DAOException
	 */
	public void removeAddedGroupLocationDtl(List<PriSpScpGrpLocVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "N");
								
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGrpAmdVODSQL(), delModels,velParam);
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
	 * 다건의 Group Location Detail 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpScpGrpLocDtlVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocationDetail(List<PriSpScpGrpLocDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlVOCSQL(), insModels,null);
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
	 * 다건의 Group Location  Detail 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriSpScpGrpLocDtlVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupLocationDetail(List<PriSpScpGrpLocDtlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlVOUSQL(), updModels,null);
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
	 * 모든  Group Location Detail데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO vo
	 * @exception DAOException
	 */
	public void modifyAllGroupLocationDetail(PriSpScpGrpLocDtlVO vo) throws DAOException,Exception {
		
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlAllVOUSQL(),
                    param, velParam);
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
	 * 다건의 Group Location Detail 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriSpScpGrpLocDtlVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupLocationDetail(List<PriSpScpGrpLocDtlVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "N");
								
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlVODSQL(), delModels,velParam);
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
	 * 다건의 Amend 대상 Group Location 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocationAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocAmdVOCSQL(), insModels,null);
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
	 * 다건의 Amend 대상 Group Location Detail 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocationDetailAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlAmdVOCSQL(), insModels,null);
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
	 * 다건의 Group Location 데이터를 Guideline 으로부터 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpScpGrpLocDtlVO> insModels
	 * @exception DAOException
	 */
	public void addProposalMainGroupLocationGlineCopy(List<PriSpScpGrpLocDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocGlineCpVOCSQL(), insModels,null);
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
	 * 다건의 Group Location Detail 데이터를 Guideline 으로부터 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpScpGrpLocDtlVO> insModels
	 * @exception DAOException
	 */
	public void addProposalMainGroupLocationDetailGlineCopy(List<PriSpScpGrpLocDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlGlineCpVOCSQL(), insModels,null);
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
     * Proposal Scope Group Location Master 정보를 Copy 생성합니다.<br>
     * 
     * @param vo RsltPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalScopeLocation (RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupLocationProposalDBDAOPropCpPriSpScpGrpLocCSQL(),
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
     * Proposal Scope Group Location Detail 정보를 Copy 합니다.<br>
     * 
     * @param vo RsltPropCopyVO
     * @exception DAOException
     */
    public void addCopyProposalScopeLocationDtl (RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupLocationProposalDBDAOPropCpPriSpScpGrpLocDtlCSQL(),
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
     * Guideline Location Group 정보를 Copy하여 Proposal Location Group 정보를 생성합니다.<br>
     * 
     * @param vo SpScpGlineCopyVO
     * @exception DAOException
     */
    public void addCopyScopeGuidelineGrpLoc (SpScpGlineCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupLocationProposalDBDAOGlineCopyPriSpScpGrpLocCSQL(),
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
     * Guideline Location Group Detail 정보를 Copy하여 Proposal Location Group Detail 정보를 생성합니다.<br>
     * 
     * @param vo SpScpGlineCopyVO
     * @exception DAOException
     */
    public void addCopyScopeGuidelineGrpLocDtl (SpScpGlineCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupLocationProposalDBDAOGlineCopyPriSpScpGrpLocDtlCSQL(),
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
	 * SCGroupLocationProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchGroupLocationDetailStatusList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int cnt = 0;

		try{
			if(priSpScpGrpLocDtlVO != null){
				Map<String, String> mapVO = priSpScpGrpLocDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationProposalDBDAORsltGrpLocDtlStsListVORSQL(), param, velParam);
			cnt = dbRowset.getRowCount();
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
     *  SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
     * 
     * @param vo PriSpScpMnVO
     * @exception DAOException, Exception
     */
    public void removeProposalGrpLocDtl (PriSpScpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlAllVODSQL(), param, velParam);
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
     *  SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
     * 
     * @param vo PriSpScpMnVO
     * @exception DAOException, Exception
     */
    public void removeProposalGrpLoc (PriSpScpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
                   
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupLocationProposalDBDAOPriSpScpGrpLocAllVODSQL(), param, velParam);
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
	 * Request Cancel시 Group location의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception DAOException,Exception
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlRequestCancelVOUSQL(), param, velParam);
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
	 * Location Group 을 조회한다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailHistoryList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpLocDtlVO != null){
				Map<String, String> mapVO = priSpScpGrpLocDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
				velParam.putAll(mapVO);
				velParam.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationProposalDBDAORsltGrpLocDtlHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
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
	 * Location Group Detail 을 조회한다.<br>
	 * 
	 * @param PriSpScpGrpLocVO priSpScpGrpLocVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchGroupLocationHistoryList (PriSpScpGrpLocVO priSpScpGrpLocVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpLocVO != null){
				Map<String, String> mapVO = priSpScpGrpLocVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
				velParam.putAll(mapVO);
				velParam.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationProposalDBDAORsltGrpLocHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
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
	 * Location Group 을 조회한다.<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailInquiryList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpLocDtlVO != null){
				Map<String, String> mapVO = priSpScpGrpLocDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationProposalDBDAORsltGrpLocDtlInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
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
	 * Location Group Detail 을 조회한다.<br>
	 * 
	 * @param PriSpScpGrpLocVO priSpScpGrpLocVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchGroupLocationInquiryList (PriSpScpGrpLocVO priSpScpGrpLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpLocVO != null){
				Map<String, String> mapVO = priSpScpGrpLocVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupLocationProposalDBDAORsltGrpLocInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
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
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL - 대상테이블 : PRI_SP_SCP_GRP_LOC<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToProposalSpScpGrpLoc(RsltCopyToProposalVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocCopyToProposalCSQL(), param, velParam);
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
	 * 
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL - 대상 테이블 : PRI_SP_SCP_GRP_LOC_DTL<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToProposalSpScpGrpLocDtl(RsltCopyToProposalVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupLocationProposalDBDAOPriSpScpGrpLocDtlCopyToProposalCSQL(), param, velParam);
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
	
	
}