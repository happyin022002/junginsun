/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateProposalDBDAO.java
*@FileTitle : Bolier Plate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.28 공백진
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.basic.SCBoilerPlateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplSearchVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.CstPriSpBlplVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltBlplGcCntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplExcelVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplHeaderVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSpBlplCtntVO;
import com.hanjin.syscommon.common.table.PriSpBlplVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;


/**
 * NIS2010 SCBoilerPlateProposalDBDAO <br>
 * - NIS2010-SCProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kong Back Jin
 * @see SCBoilerPlateProposalBCImpl 참조
 * @since J2EE 1.6 
 */
public class SCBoilerPlateProposalDBDAO extends DBDAOSupport {
 
	/**
	 * Boiler Plate List를 조회합니다.<br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @return List<RsltPriSpBlplVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpBlplVO> searchBoilerPlateList(CstBlplSearchVO cstBlplSearchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpBlplVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstBlplSearchVO != null){
				Map<String, String> mapVO = cstBlplSearchVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpBlplVO .class);
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
	 * Boiler Plate Detail List를 조회합니다.<br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @return List<RsltPriSpBlplCtntVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpBlplCtntVO> searchBoilerPlateDetailList(PriSpBlplCtntVO priSpBlplCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpBlplCtntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpBlplCtntVO != null){
				Map<String, String> mapVO = priSpBlplCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpBlplCtntVO .class);
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
	 * Boiler Plate Title 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriSpBlplVO> insModels
	 * @exception DAOException
	 */
	public void addBoilerPlateS(List<PriSpBlplVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplVOCSQL(), insModels,null);
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
	 * Boiler Plate Content 데이터를 추가합니다.<br>
	 * 
	 * @param List<PriSpBlplCtntVO> insModels
	 * @exception DAOException
	 */
	public void addBoilerPlateDetailS(List<PriSpBlplCtntVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntVOCSQL(), insModels,null);
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
	 * Boiler Plate Title 데이터를 수정합니다.<br>
	 * 
	 * @param List<PriSpBlplVO> updModels
	 * @exception DAOException
	 */
	public void modifyBoilerPlateS(List<PriSpBlplVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplVOUSQL(), updModels,null);
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
	 * Boiler Plate Content 데이터를 수정합니다.<br>
	 * 
	 * @param List<PriSpBlplCtntVO> updModels
	 * @exception DAOException
	 */
	public void modifyBoilerPlateDetailS(List<PriSpBlplCtntVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntVOUSQL(), updModels,null);
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
	 * Boiler Plate Title 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpBlplVO> delModels
	 * @exception DAOException
	 */
	public void removeBoilerPlateS(List<PriSpBlplVO> delModels) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				velParam.put("is_init_delete", "N"); // INIT Cancel 삭제시 사용
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplVODSQL(), delModels,velParam);
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
	
	/**
	 * Boiler Plate Content 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpBlplCtntVO> delModels
	 * @exception DAOException
	 */
	public void removeBoilerPlateDetailS(List<PriSpBlplCtntVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntVODSQL(), delModels,null);
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
	
	
	
	/**
	 * Boiler Plate Header를 조회합니다.<br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateHeader(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpBlplHeaderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSpBlplHeaderVO != null){
				Map<String, String> mapVO = rsltPriSpBlplHeaderVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplHeaderVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpBlplHeaderVO .class);
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
	 * Guide Line Boiler Plate Title 데이터를 <br>
	 * S/C Proposal Boiler Plate Title 에 Copy합니다.<br>
	 * 
	 * @param CstBlplCopyVO vo
	 * @exception DAOException
	 */
	public void addBoilerPlateCopy(CstBlplCopyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCopyVOCSQL(), param, velParam);
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
	 * Guide Line Boiler Plate Content 데이터를 <br>
	 * S/C Proposal Boiler Plate Content 에 Copy합니다.<br>
	 * 
	 * @param CstBlplCopyVO vo
	 * @exception DAOException
	 */
	public void addBoilerPlateCtntCopy(CstBlplCopyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntCopyVOCSQL(), param, velParam);
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
	 * Boiler Plate 데이터를 Excel로 보내기위하여 Boiler Plate Title과 Content를 합쳐서 조회합니다.<br>
	 * 
	 * @param PriSpBlplVO priSpBlplVO
	 * @return List<RsltPriSpBlplExcelVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpBlplExcelVO> searchBoilerPlateListExcel(PriSpBlplVO priSpBlplVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpBlplExcelVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpBlplVO != null){
				Map<String, String> mapVO = priSpBlplVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplExcelVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpBlplExcelVO .class);
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
	 * Boiler Plate Title 의 Status를 Accept로 수정합니다.<br>
	 * 
	 * @param CstPriSpBlplVO cstPriSpBlplVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllBoilerPlate(CstPriSpBlplVO cstPriSpBlplVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = cstPriSpBlplVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplAcceptUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * Boiler Plate Title 의 Status를 Accept Cancel로 수정합니다.<br>
	 * 
	 * @param CstPriSpBlplVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyCancelAllBoilerPlate(CstPriSpBlplVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplAcceptUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * Boiler Plate Content 의 Status를 Accept로 수정합니다.<br>
	 * 
	 * @param CstPriSpBlplVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllBoilerPlateContent(CstPriSpBlplVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntAcceptUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * Boiler Plate Content 의 Status를 Accept Cancel로 수정합니다.<br>
	 * 
	 * @param CstPriSpBlplVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyCancelAllBoilerPlateContent(CstPriSpBlplVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntAcceptUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * Boiler Plate Title의 해당 Amend Seq 데이터를  Amend Seq + 1하여  추가 합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addBoilerPlateAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplAmdVOCSQL(), insModels,null);
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
	 * Boiler Plate Content의 해당 Amend Seq 데이터를  Amend Seq + 1하여  추가 합니다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addBoilerPlateContentAmend(List<PriSpMnVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntAmdVOCSQL(), insModels,null);
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
	 *Boiler Plate Title의 조건으로 Boiler Plate Content를 Amend 처리합니다.<br>
	 * 
	 * @param List<PriSpBlplVO> updModels
	 * @exception DAOException
	 */
	public void modifyBoilerPlateDetailAmendS(List<PriSpBlplVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntAmendVOUSQL(), updModels,null);
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
	 * Boiler Plate Title의 조건으로 Boiler Plate Content를 삭제 처리합니다.<br>
	 * @param List<PriSpBlplVO> delModels
	 * @exception DAOException
	 */
	public void removeBoilerPlateDetailAllS(List<PriSpBlplVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntAllVODSQL(), delModels,null);
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

	/**
	 * Boiler Plate Title의 조건으로 해당 회차의 Boiler Plate Content를 삭제 처리합니다.<br>
	 * @param List<PriSpBlplVO> delModels
	 * @exception DAOException
	 */
	public void removeBoilerPlateDetailAllAmendS(List<PriSpBlplVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntAllAmendVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
     * SP BoilerPlate 데이터를 Copy한다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalBoilerPlate (RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCBoilerPlateProposalDBDAOPropCpPriSpBlplCSQL(),
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
     * SP BoilerPlate Content 데이터를 Copy한다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalBoilerPlateCtnt (RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCBoilerPlateProposalDBDAOPropCpPriSpBlplCtntCSQL(),
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
     *  해당 Amend Seq 해당하는 모든 데이터를 삭제처리합니다.<br>
     * 
     * @param PriSpMnVO vo
     * @exception DAOException
     */
    public void removeProposalTitle (PriSpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.put("is_init_delete", "Y"); // INIT Cancel 삭제시 사용
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCBoilerPlateProposalDBDAOPriSpBlplVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to Remove SQL");
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
     *  해당 Amend Seq 해당하는 모든 데이터를 삭제처리합니다.<br>
     * 
     * @param PriSpMnVO vo
     * @exception DAOException
     */
    public void removeProposalCtnt (PriSpMnVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.put("is_init_delete", "Y"); // INIT Cancel 삭제시 사용
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCBoilerPlateProposalDBDAOPriSpBlplCtntInitVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to Remove SQL");
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
	 * Boiler Plate Title,Content의 Accept된 Status를 모두 Init 으로 변경합니다.<br>
	 * 해당 회차의 모든데이터가 대상이다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalCtntRequestCancel(PriSpMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntRequestCancelVOUSQL(), param, velParam);
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
	 * Boiler Plate Title,Content의 Accept된 Status를 모두 Init 으로 변경합니다.<br>
	 * 해당 회차의 모든데이터가 대상이다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalTitleRequestCancel(PriSpMnVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplRequestCancelVOUSQL(), param, velParam);
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
	 * GuideLine Boiler Plate 에서 Header Seq No를 조회합니다..<br>
	 * 
	 * @param CstBlplCopyVO vo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBoilerPlateHeaderSeq(CstBlplCopyVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplHdrSeqRSQL(), param, velParam);
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
	 * Boiler Plate Record Count를 조회합니다.<br>
	 * 
	 * @param PriSpBlplVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int searchBoilerPlateCount(PriSpBlplVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnVal = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCntVORSQL(), param, velParam);
			dbRowset.next();
			rtnVal = dbRowset.getInt(1);
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
	 * Boiler Plate Amend History Title을 조회합니다.<br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateTitle(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpBlplHeaderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSpBlplHeaderVO != null){
				Map<String, String> mapVO = rsltPriSpBlplHeaderVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplTitleVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpBlplHeaderVO .class);
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
	 * Boiler Plate Amend History Content를 조회합니다.<br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpBlplCtntVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpBlplCtntVO> searchBoilerPlateDetailHistoryList(PriSpBlplCtntVO priSpBlplCtntVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpBlplCtntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpBlplCtntVO != null){
				Map<String, String> mapVO = priSpBlplCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
				velParam.putAll(mapVO);
				velParam.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntHistoryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpBlplCtntVO .class);
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
	 * Boiler Plate Amend History List를 조회합니다.<br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpBlplVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpBlplVO> searchBoilerPlateHistoryList(CstBlplSearchVO cstBlplSearchVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpBlplVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstBlplSearchVO != null){
				Map<String, String> mapVO = cstBlplSearchVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
				velParam.putAll(mapVO);
				velParam.put("con_flg", priSpHistoryInquiryParamVO.getConFlg());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplHistoryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpBlplVO .class);
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
	 *Inquiry - Boiler Plate Header 정보를 조회합니다<br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateHeaderInquiry(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpBlplHeaderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSpBlplHeaderVO != null){
				Map<String, String> mapVO = rsltPriSpBlplHeaderVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplHdrInqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpBlplHeaderVO .class);
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
	 *Inquiry - Boiler Plate Title 정보를 조회합니다<br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @return  List<RsltPriSpBlplInqVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpBlplInqVO> searchBoilerPlateInquiryList(CstBlplSearchVO cstBlplSearchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpBlplInqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstBlplSearchVO != null){
				Map<String, String> mapVO = cstBlplSearchVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAORsltPriSpBlplInqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpBlplInqVO .class);
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
	 * Inquiry - Boiler Plate Contents 정보를 조회합니다<br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @return List<RsltPriSpBlplCtntInqVO> 
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSpBlplCtntInqVO> searchBoilerPlateDetailInquiryList(PriSpBlplCtntVO priSpBlplCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSpBlplCtntInqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpBlplCtntVO != null){
				Map<String, String> mapVO = priSpBlplCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAORsltPriSpBlplCtntInqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSpBlplCtntInqVO .class);
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
	 * Detail 에서 Accept된 데이터를 조회합니다.<br>
	 * 
	 * @param PriSpBlplVO priSpBlplVO
	 * @param List<String> txtArr
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchDetailAccept(PriSpBlplVO priSpBlplVO, List<String> txtArr ) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpBlplVO != null){
				Map<String, String> mapVO = priSpBlplVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("txtArr", txtArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAOAcceptCntPriSpBlplCtntVORSQL(), param, velParam);		
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
	 * Boiler Plate에서 GC가 아닌 데이터 갯수와 삭제된 데이터의 갯수를 조회합니다.<br>
	 * 
	 * @param PriSpBlplVO priSpBlplVO
	 * @return RsltBlplGcCntVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public RsltBlplGcCntVO searchRowCountNotFromGuideline(PriSpBlplVO priSpBlplVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltBlplGcCntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSpBlplVO != null){
				Map<String, String> mapVO = priSpBlplVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateProposalDBDAORsltBlplGcCntVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltBlplGcCntVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list.get(0);
	}	 
	 
	 
	 
	/**
	 * 자동 승인시 Boiler Plate Title 의 Status를 Accept로 수정합니다.<br>
	 * 
	 * @param PriSpBlplVO priSpBlplVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAutoAcceptOrCancelBoilerPlate(PriSpBlplVO priSpBlplVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSpBlplVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplAutoAcceptUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * Boiler Plate Content 의 Status를 Accept로 수정합니다.<br>
	 * 
	 * @param PriSpBlplVO priSpBlplVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAutoAcceptOrCancelBoilerPlateContent(PriSpBlplVO priSpBlplVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSpBlplVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateProposalDBDAOPriSpBlplCtntAutoAcceptUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
}