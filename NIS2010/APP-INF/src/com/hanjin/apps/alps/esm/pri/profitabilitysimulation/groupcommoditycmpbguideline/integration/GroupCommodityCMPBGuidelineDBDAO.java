/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GroupCommodityCMPBGuidelineDBDAO.java
*@FileTitle : CMPB Guideline Creation - Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.14 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.basic.GroupCommodityCMPBGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.vo.RsltPriCmpbGrpCmdtDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpCmdtVO;


/**
 * ALPS GroupCommodityCMPBGuidelineDBDAO <br>
 * - ALPS-ProfitabilitySimulation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung-Jun,Lee
 * @see GroupCommodityCMPBGuidelineBCImpl 참조
 * @since J2EE 1.6
 */
public class GroupCommodityCMPBGuidelineDBDAO extends DBDAOSupport {

	/**
	 * Group cmdt detail 정보를 조회한다.<br>
	 * 
	 * @param priCmpbGrpCmdtVO PriCmpbGrpCmdtVO
	 * @return List<RsltPriCmpbGrpCmdtDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriCmpbGrpCmdtDtlVO> searchCmpbGroupCommodityDetailList(PriCmpbGrpCmdtVO priCmpbGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCmpbGrpCmdtDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGrpCmdtVO != null){
				Map<String, String> mapVO = priCmpbGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCmpbGrpCmdtDtlVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * Group cmdt를 조회한다.<br>
	 * 
	 * @param priCmpbGrpCmdtVO PriCmpbGrpCmdtVO
	 * @return List<PriCmpbGrpCmdtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriCmpbGrpCmdtVO> searchCmpbGroupCommodityList(PriCmpbGrpCmdtVO priCmpbGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriCmpbGrpCmdtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priCmpbGrpCmdtVO != null){
				Map<String, String> mapVO = priCmpbGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriCmpbGrpCmdtVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Group cmdt를 등록한다.<br>
	 * 
	 * @param vo PriCmpbGrpCmdtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCmpbGroupCommodity(PriCmpbGrpCmdtVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Group Commodity를 신규로 복사하여 등록한다.<br>
	 * 
	 * @param vo RsltDurationCreationOfficeVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyCmpbGroupCommodity(RsltDurationCreationOfficeVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtVOAddCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 *  Group Commodity를 수정한다.<br>
	 * 
	 * @param vo PriCmpbGrpCmdtVO 
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCmpbGroupCommodity(PriCmpbGrpCmdtVO vo) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 *  Group Commodity를 삭제한다.<br>
	 * 
	 * @param vo PriCmpbGrpCmdtVO 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGroupCommodity(PriCmpbGrpCmdtVO vo) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * PRI_CMPB_GRP_CMDT 테이블을 등록한다.<br>
	 * 
	 * @param insModels List<PriCmpbGrpCmdtVO>
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] addCmpbGroupCommodityS(List<PriCmpbGrpCmdtVO> insModels) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * PRI_CMPB_GRP_CMDT 테이블을 일괄 갱신한다.<br>
	 * 
	 * @param updModels List<PriCmpbGrpCmdtVO>
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] modifyCmpbGroupCommodityS(List<PriCmpbGrpCmdtVO> updModels) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_CMPB_GRP_CMDT 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param delModels List<PriCmpbGrpCmdtVO> 
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeCmpbGroupCommodityS(List<PriCmpbGrpCmdtVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	/**
	 * PRI_CMPB_GRP_CMDT_DTL 테이블을 생성한다.<br>
	 * 
	 * @param vo PriCmpbGrpCmdtDtlVO 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCmpbGroupCommodityDetail(PriCmpbGrpCmdtDtlVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtDtlVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_CMPB_GRP_CMDT_DTL 테이블을 카피 생성한다.<br>
	 * 
	 * @param vo PriCmpbGrpCmdtDtlVO 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyCmpbGroupCommodityDetail(RsltDurationCreationOfficeVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtDtlVOAddCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * [PRI_CMPB_GRP_CMDT_DTL 테이블을 갱신한다.<br>
	 * 
	 * @param PriCmpbGrpCmdtDtlVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyCmpbGroupCommodityDetail(PriCmpbGrpCmdtDtlVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtDtlVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * PRI_CMPB_GRP_CMDT_DTL 테이블을 삭제한다.<br>
	 * 
	 * @param PriCmpbGrpCmdtDtlVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeCmpbGroupCommodityDetail(PriCmpbGrpCmdtDtlVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtDtlVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * PRI_CMPB_GRP_CMDT_DTL 테이블을 CMDT_SEQ 별 삭제한다.<br>
	 * 
	 * @param PriCmpbGrpCmdtVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeCmpbGroupCommodityDetail(PriCmpbGrpCmdtVO vo) throws DAOException,Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtDtlVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * PRI_CMPB_GRP_CMDT_DTL 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriCmpbGrpCmdtDtlVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addCmpbGroupCommodityDetailS(List<PriCmpbGrpCmdtDtlVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtDtlVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * PRI_CMPB_GRP_CMDT_DTL 테이블을 일괄 갱신한다.<br>
	 * 
	 * @param List<PriCmpbGrpCmdtDtlVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyCmpbGroupCommodityDetailS(List<PriCmpbGrpCmdtDtlVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtDtlVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_CMPB_GRP_CMDT_DTL 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriCmpbGrpCmdtDtlVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeCmpbGroupCommodityDetailS(List<PriCmpbGrpCmdtDtlVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtDtlVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	/**
	 * remove PRI_CMPB_GRP_CMDT by header.<br>
	 * 
	 * @param vo PriCmpbGlineMnVO 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGroupCommodity(PriCmpbGlineMnVO vo) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * remove PRI_CMPB_GRP_CMDT_DTL by header.<br>
	 * 
	 * @param vo PriCmpbGlineMnVO 
	 * @return int
	 * @throws DAOException
	 */
	public int removeCmpbGroupCommodityDetail(PriCmpbGlineMnVO vo) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new GroupCommodityCMPBGuidelineDBDAOPriCmpbGrpCmdtDtlVOAllHdrDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * RATE에서 사용하는 COMMODITY 를 조회한다.
	 * @param PriCmpbGrpCmdtVO priCmpbGrpCmdtVO
	 * @return RsltCdListVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RsltCdListVO searchCheckGroupCommodityInUse(PriCmpbGrpCmdtVO priCmpbGrpCmdtVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priCmpbGrpCmdtVO.getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GroupCommodityCMPBGuidelineDBDAOCheckGroupCommodityInUseRSQL(), param, null);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}	
	
	
}