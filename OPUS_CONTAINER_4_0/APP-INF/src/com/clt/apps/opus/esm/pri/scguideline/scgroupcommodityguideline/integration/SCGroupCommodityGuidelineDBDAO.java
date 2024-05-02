/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityGuidelineDAO.java
*@FileTitle : Commondity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.21 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.basic.SCGroupCommodityGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.PriGriGrpCmdtVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.PriSgGrpCmdtExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtCustTypeVO;
import com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtDtlVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriScgGrpCmdtVO;
import com.clt.syscommon.common.table.PriSgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriSgGrpCmdtVO;
import com.clt.syscommon.common.table.PriSgMnVO;


/**
 * SCGroupCommodityGuidelineDAO <br>
 * - SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kong Back Jin
 * @see SCGroupCommodityGuidelineBCImpl 참조
 * @since J2EE 1.4
 */
public class SCGroupCommodityGuidelineDBDAO extends DBDAOSupport {
	/**
	 * GroupCommodity Cust Type의 데이터 Count를 조회합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltPriSgGrpCmdtCustTypeVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSgGrpCmdtCustTypeVO> searchGroupCommodityGuideCustTypeCount(PriSgGrpCmdtVO priSgGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSgGrpCmdtCustTypeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(priSgGrpCmdtVO != null){
				Map<String, String> mapVO = priSgGrpCmdtVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityGuidelineDBDAORsltPriSgGrpCmdtCustTypeVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSgGrpCmdtCustTypeVO .class);
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
	 * Group Commodity 메인을 조회합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<PriSgGrpCmdtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriSgGrpCmdtVO> searchGroupCommodityGuidelineList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSgGrpCmdtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(priSgGrpCmdtVO != null){
				Map<String, String> mapVO = priSgGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgGrpCmdtVO .class);
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
	 * Group Commodity 상세를 조회합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltPriSgGrpCmdtDtlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSgGrpCmdtDtlVO> searchGroupCommodityGuidelineDtlList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSgGrpCmdtDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		try{
			if(priSgGrpCmdtVO != null){
				Map<String, String> mapVO = priSgGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSgGrpCmdtDtlVO .class);
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
	 * Commodity Group의 max seq값을 구합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchMaxGroupSeq(PriSgGrpCmdtVO priSgGrpCmdtVO) throws DAOException {
		int nextSeq = -1;
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		
		try{
			if(priSgGrpCmdtVO != null){
				Map<String, String> mapVO = priSgGrpCmdtVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOMaxGrpLocSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				nextSeq = dbRowset.getInt("next_seq");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return nextSeq;
	}	 
	 
	 


	/**
	 * Commodity Group을 추가합니다.<br>
	 * 
	 * @param List<PriSgGrpCmdtVO> insModels
	 * @exception DAOException
	 */
	public void addGroupCommodityGuidelineS(List<PriSgGrpCmdtVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtVOCSQL(), insModels,null);
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
	 * Commodity Group Detail을 추가합니다.<br>
	 * 
	 * @param List<PriSgGrpCmdtDtlVO> insModels
	 * @exception DAOException
	 */
	public void addGroupCommodityGuidelineDtl(List<PriSgGrpCmdtDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtDtlVOCSQL(), insModels,null);
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
	 * Commodity Group을  수정 합니다.<br>
	 * 
	 * @param List<PriSgGrpCmdtVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupCommodityGuidelineS(List<PriSgGrpCmdtVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtVOUSQL(), updModels,null);
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
	 * Commodity Group Detail을 수정 합니다.<br>
	 * 
	 * @param List<PriSgGrpCmdtDtlVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupCommodityGuidelineDtl(List<PriSgGrpCmdtDtlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtDtlVOUSQL(), updModels,null);
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
	 * Commodity Group을 삭제 합니다.<br>
	 * 
	 * @param List<PriSgGrpCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupCommodityGuidelineS(List<PriSgGrpCmdtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtVODSQL(), delModels,null);
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
	 * Master데이터에 해당하는 Commodity Group Detail을 삭제 합니다.<br>
	 * 
	 * @param List<PriSgGrpCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupCommodityGuidelineDtlS(List<PriSgGrpCmdtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtDtlAllVODSQL(), delModels,null);
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
	 * Commodity Group Detail을 삭제 합니다.<br>
	 * 
	 * @param List<PriSgGrpCmdtDtlVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupCommodityGuidelineDtl(List<PriSgGrpCmdtDtlVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtDtlVODSQL(), delModels,null);
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
	 * 마스터 전체 데이터를 삭제한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainGroupCommodity(PriSgMnVO priSgMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgMnDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * 디테일 전체 데이터를 삭제한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainGroupCommodityDetail(PriSgMnVO priSgMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgMnDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * Commodity Group 데이터를 Excel 로 보내기위하여 조회합니다 .<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<PriSgGrpCmdtExcelVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSgGrpCmdtExcelVO> searchGroupCommodityGuidelineExcelList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSgGrpCmdtExcelVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		
		try{
			if(priSgGrpCmdtVO != null){
				Map<String, String> mapVO = priSgGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtExcelRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgGrpCmdtExcelVO .class);
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
	 * Surcharge Group Commodity 정보를 조회합니다.<br>
	 *
	 * @param PriScgGrpCmdtVO priScgGrpCmdtVO
	 * @return List<PriScgGrpCmdtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriScgGrpCmdtVO> searchGRIGroupCommodityGuidelineList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScgGrpCmdtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScgGrpCmdtVO != null){
				Map<String, String> mapVO = priScgGrpCmdtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriScgGrpCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScgGrpCmdtVO .class);
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
	 * 선택한 TPW Group Commodity로 Group Commodity Master를 생성한다.<br>
	 *
	 * @param PriGriGrpCmdtVO priGriGrpCmdtVO
	 * @exception DAOException
	 */
	public void addGroupCommodityGuideline(PriGriGrpCmdtVO priGriGrpCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priGriGrpCmdtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtVOCSQL(), param, velParam);
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
	 * 선택한 TPW Group Commodity로 Group Commodity Detail을 생성한다.<br>
	 *
	 * @param PriGriGrpCmdtVO priGriGrpCmdtVO
	 * @exception DAOException
	 */
	public void addGroupCommodityGuidelineDetail(PriGriGrpCmdtVO priGriGrpCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priGriGrpCmdtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtListCSQL(), param, velParam);
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
	 * 선택한 TPW Group Commodity로 Group Commodity Master를 생성한다.<br>
	 *
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void addGuidelineMainGroupCommodityCopy(GlineMnCpVO glineMnCpVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = glineMnCpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtGlineMainCopyCSQL(), param, velParam);
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
	 * 선택한 TPW Group Commodity로 Group Commodity Master를 생성한다.<br>
	 *
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void addGuidelineMainGroupCommodityDetailCopy(GlineMnCpVO glineMnCpVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = glineMnCpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCGroupCommodityGuidelineDBDAOPriSgGrpCmdtDtlGlineMainCopyCSQL(), param, velParam);
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
	 * RATE에서 사용하는 COMMODITY 를 조회한다.
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCheckGroupCommodityInUse(PriSgGrpCmdtVO priSgGrpCmdtVO) throws DAOException {
		DBRowSet dbRowsetDtl = null;
		List<RsltCdListVO> listDtl = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgGrpCmdtVO != null) {
				Map<String, String> mapVO = priSgGrpCmdtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowsetDtl = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGroupCommodityGuidelineDBDAOCheckGroupCommodityInUseVORSQL(), param, velParam);

			listDtl = (List) RowSetUtil.rowSetToVOs(dbRowsetDtl, RsltCdListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return listDtl;
	}	
	
	
}
