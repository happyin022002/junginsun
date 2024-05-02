/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityProposalDBDAO.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.25 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.basic.SCGroupCommodityProposalBCImpl;
import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;


/**
 *  SCGroupCommodityProposalDBDAO <br>
 * - SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUNG MIN
 * @see SCGroupCommodityProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class SCGroupCommodityProposalDBDAO extends DBDAOSupport {

	/**
	 * SCGroupCommodityProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO priSpScpGrpCmdtVO
	 * @param List<String> txtArr
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateApplyList (PriSpScpGrpCmdtVO priSpScpGrpCmdtVO, List<String> txtArr) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpCmdtVO != null){
				Map<String, String> mapVO = priSpScpGrpCmdtVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("txtArr", txtArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityProposalDBDAORsltRtApplyListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * SCGroupCommodityProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO priSpScpGrpCmdtVO
	 * @param List<String> txtArr
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateAcceptedList (PriSpScpGrpCmdtVO priSpScpGrpCmdtVO, List<String> txtArr) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpCmdtVO != null){
				Map<String, String> mapVO = priSpScpGrpCmdtVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("txtArr", txtArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityProposalDBDAORsltRtAcceptedListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * SCGroupCommodityProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpCmdtDtlVO != null){
				Map<String, String> mapVO = priSpScpGrpCmdtDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityProposalDBDAORsltGrpCmdtDtlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtDtlListVO .class);
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
	 * SCGroupCommodityProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO priSpScpGrpCmdtVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchGroupCommodityList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpCmdtVO != null){
				Map<String, String> mapVO = priSpScpGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityProposalDBDAORsltGrpCmdtListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpScpGrpCmdtDtlVO> insModels
	 * @exception DAOException
	 */
	public void addProposalMainGroupCommodityGlineCopy(List<PriSpScpGrpCmdtDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtGlineCpVOCSQL(), insModels,null);
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
	}		

	/**
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpScpGrpCmdtDtlVO> insModels
	 * @exception DAOException
	 */
	public void addProposalMainGroupCommodityDetailGlineCopy(List<PriSpScpGrpCmdtDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtDtlGlineCpVOCSQL(), insModels,null);
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
	}	
	
    /**
	 * 단건의 데이터를 생성한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO vo
	 * @exception DAOException
	 */
	public void addCopyProposal(PriSpScpGrpCmdtVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtVOCSQL(), param, velParam);
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
	 * 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyCopyProposal(PriSpScpGrpCmdtVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtVOUSQL(), param, velParam);
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
	 * 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeCopyProposal(PriSpScpGrpCmdtVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtVODSQL(), param, velParam);
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
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpScpGrpCmdtVO> insModels
	 * @exception DAOException
	 */
	public void addGroupCommodity(List<PriSpScpGrpCmdtVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtVOCSQL(), insModels,null);
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
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSpScpGrpCmdtDtlVO> insModels
	 * @exception DAOException
	 */
	public void addGroupCommodityDetail(List<PriSpScpGrpCmdtDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtDtlVOCSQL(), insModels,null);
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
	}

	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 *AMEND시 MASTER에서 삭제할 경우 DETAIL의 모든 데이터를 AMEND DELETE처리한다.
	 * 
	 * @param List<PriSpScpGrpCmdtVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupCommodity(List<PriSpScpGrpCmdtVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtVOUSQL(), updModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<PriSpScpGrpCmdtDtlVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupCommodityDetail(List<PriSpScpGrpCmdtDtlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtDtlVOUSQL(), updModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriSpScpGrpCmdtDtlVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupCommodityDetail(List<PriSpScpGrpCmdtDtlVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "N");
								
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtDtlVODSQL(), delModels,velParam);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<PriSpScpGrpCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupCommodity(List<PriSpScpGrpCmdtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtVODSQL(), delModels,velParam);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 해당 seq에 추가되지 않은 대상 Detail 데이터를 AD로 갱신한다.
	 * @param List<PriSpScpGrpCmdtVO> updModels
	 * @exception DAOException
	 */
	public void modifyDeleteGroupCommodityDtl(List<PriSpScpGrpCmdtVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtDtlGrpAmdVOUSQL(), updModels,null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		

	/**
	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 해당 seq 에 신규 추가된 Location Detail 데이터를 일괄적으로 삭제함
	 * @param List<PriSpScpGrpCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removeAddedGroupCommodityDtl(List<PriSpScpGrpCmdtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtDtlGrpAmdVODSQL(), delModels, null);
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
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * Group commodity Main 에 Amend 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addGroupCommodityAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtAmdVOCSQL(), insModels,null);
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
	}

	/**
	 * Group commodity Detail 에 Amend 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addGroupCommodityDetailAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtDtlAmdVOCSQL(), insModels,null);
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
	}	

    /**
     * Proposal Scope Group Commodity Master 정보를 Copy 생성합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeCommodity (RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupCommodityProposalDBDAOPropCpPriSpScpGrpCmdtCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
     * Proposal Scope Group Commodity Detail 정보를 Copy 생성합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeCommodityDtl (RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupCommodityProposalDBDAOPropCpPriSpScpGrpCmdtDtlCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
     * SCOPE에 해당하는 모든 Detail 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpMnVO vo
     * @exception DAOException
     */
    public void removeProposalCmdtDtl (PriSpScpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtDtlAllVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
            }        
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	
    
    /**
     * SCOPE에 해당하는 모든 Master 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpMnVO vo
     * @exception DAOException
     */
    public void removeProposalCmdt (PriSpScpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();
            param.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtAllVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to delete SQL");
            }				                        
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    

    /**
     *  Guideline Commodity Group Master 정보를 Proposal 로 Copy 생성합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineGrpCmdt (SpScpGlineCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupCommodityProposalDBDAOGlineCopyPriSpScpGrpCmdtCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
     * Guideline Commodity Group Detail 정보를 Proposal 로 Copy 생성합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineGrpCmdtDtl (SpScpGlineCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupCommodityProposalDBDAOGlineCopyPriSpScpGrpCmdtDtlCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
     * Guideline Commodity Group(TPW) Master 정보를 Proposal 로 Copy 생성합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineGrpCmdtTpw (SpScpGlineCopyVO vo) throws DAOException, Exception {   
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupCommodityProposalDBDAOGlineCopyPriSpScpGrpCmdtTpwCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
     * Guideline Commodity Group(TPW) Detail 정보를 Proposal 로 Copy 생성합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineGrpCmdtDtlTpw (SpScpGlineCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupCommodityProposalDBDAOGlineCopyPriSpScpGrpCmdtDtlTpwCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
	/**
	 * SCGroupCommodityProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int searchGroupCommodityDetailStatusList (PriSpScpGrpCmdtDtlVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int cnt = 0;

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityProposalDBDAORsltGrpCmdtDtlStsListVORSQL(), param, velParam);
			cnt = dbRowset.getRowCount();
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}       
	 
	/**
	 * Detail의  status를 수정한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO vo
	 * @exception DAOException
	 */
	public void modifyAllGroupCommodityDetail(PriSpScpGrpCmdtDtlVO vo) throws DAOException,Exception {
		
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtDtlAllVOUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupCommodityProposalDBDAOPriSpScpGrpCmdtDtlRequestCancelVOUSQL(), param, velParam);
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
	 * Commodity Group History Detail 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailHistoryList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpCmdtDtlVO != null){
				Map<String, String> mapVO = priSpScpGrpCmdtDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityProposalDBDAORsltGrpCmdtDtlHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtDtlListVO .class);
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
	 * Commodity Group History 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO priSpScpGrpCmdtVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchGroupCommodityHistoryList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpCmdtVO != null){
				Map<String, String> mapVO = priSpScpGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityProposalDBDAORsltGrpCmdtHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
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
	 * Commodity Group History Detail 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO
	 * @return List<RsltGrpCmdtDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailInquiryList(PriSpScpGrpCmdtDtlVO priSpScpGrpCmdtDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpCmdtDtlVO != null){
				Map<String, String> mapVO = priSpScpGrpCmdtDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityProposalDBDAORsltGrpCmdtDtlInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtDtlListVO .class);
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
	 * Commodity Group History 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpGrpCmdtVO priSpScpGrpCmdtVO
	 * @return List<RsltGrpCmdtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGrpCmdtListVO> searchGroupCommodityInquiryList(PriSpScpGrpCmdtVO priSpScpGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpCmdtListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpScpGrpCmdtVO != null){
				Map<String, String> mapVO = priSpScpGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityProposalDBDAORsltGrpCmdtInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpCmdtListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
}