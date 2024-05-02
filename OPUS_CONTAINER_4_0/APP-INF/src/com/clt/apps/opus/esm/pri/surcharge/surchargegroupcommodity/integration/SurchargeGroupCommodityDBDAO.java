/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonGroupCommodityDBDAO.java
*@FileTitle : GRI COMM Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.08 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.basic.SurchargeGroupCommodityBCImpl;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriComGrpCmdtExcelVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriScgGrpCmdtDtlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriScgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriScgGrpCmdtVO;


/**
 *  CommonGroupCommodityDBDAO <br>
 * - Surcharge system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung Jun Lee
 * @see SurchargeGroupCommodityBCImpl 참조
 * @since J2EE 1.4
 */
public class SurchargeGroupCommodityDBDAO extends DBDAOSupport {
	
	/**
	 * CommonGroupCommodity 시퀀스 맥스값을 조회한다.<br>
	 * 
	 * @param PriScgGrpCmdtVO priComGrpCmdtVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchGRICommodityMaxSeq(PriScgGrpCmdtVO priComGrpCmdtVO) throws DAOException {
		int max_seq = 0;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priComGrpCmdtVO != null){
				Map<String, String> mapVO = priComGrpCmdtVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtVOMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("max_seq");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}
	

	/**
	 * CommonGroupCommodity detail 정보를 조회한다.<br>
	 * 
	 * @param PriScgGrpCmdtVO priComGrpCmdtVO
	 * @return List<RsltPriScgGrpCmdtDtlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriScgGrpCmdtDtlVO> searchSurchargeGroupCommodityDetailList(PriScgGrpCmdtVO priComGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriScgGrpCmdtDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priComGrpCmdtVO != null){
				Map<String, String> mapVO = priComGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriScgGrpCmdtDtlVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * CommonGroupCommodity 정보를 조회한다.<br>
	 * 
	 * @param PriScgGrpCmdtVO priComGrpCmdtVO
	 * @return List<PriScgGrpCmdtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScgGrpCmdtVO> searchSurchargeGroupCommodityList(PriScgGrpCmdtVO priComGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScgGrpCmdtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priComGrpCmdtVO != null){
				Map<String, String> mapVO = priComGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScgGrpCmdtVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * 전체 GroupCommodity 엑셀 조회한다.<br>
	 * 
	 * @param PriScgGrpCmdtVO priComGrpCmdtVO
	 * @return List<RsltPriComGrpCmdtExcelVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriComGrpCmdtExcelVO> searchSurchargeGroupCommodityExcelList(PriScgGrpCmdtVO priComGrpCmdtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriComGrpCmdtExcelVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priComGrpCmdtVO != null){
				Map<String, String> mapVO = priComGrpCmdtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtVOExcelRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriComGrpCmdtExcelVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 
	 
	 
	/**
	 * Surcharge Group Location 단건의 데이터를 생성한다.(pri_scg_grp_cmdt)<br>
	 * 
	 * @param PriScgGrpCmdtVO priScgGrpCmdtVO
	 * @exception DAOException
	 */
	public void addGRICommodity(PriScgGrpCmdtVO priScgGrpCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScgGrpCmdtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtVOCSQL(), param, velParam);
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
	 * 단건의 Surcharge Group Location  데이터를 갱신한다.(pri_scg_grp_cmdt)<br>
	 * 
	 * @param PriScgGrpCmdtVO priScgGrpCmdtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyGRICommodity(PriScgGrpCmdtVO priScgGrpCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScgGrpCmdtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtVOUSQL(), param, velParam);
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
	 * 단건의 Surcharge Group Location  데이터를 삭제한다.(pri_scg_grp_cmdt)<br>
	 * 
	 * @param PriScgGrpCmdtVO priScgGrpCmdtVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGRICommodity(PriScgGrpCmdtVO priScgGrpCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScgGrpCmdtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtVODSQL(), param, velParam);
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
	 * 다건의Surcharge Group Location  데이터를 일괄적으로 생성한다.(pri_scg_grp_cmdt)<br>
	 * 
	 * @param List<PriScgGrpCmdtVO> insModels
	 * @exception DAOException
	 */
	public void addGRICommodityS(List<PriScgGrpCmdtVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtVOCSQL(), insModels,null);
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
	}

	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.(pri_scg_grp_cmdt)<br>
	 * 
	 * @param List<PriScgGrpCmdtVO> updModels
	 * @exception DAOException
	 */
	public void modifyGRICommodityS(List<PriScgGrpCmdtVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtVOUSQL(), updModels,null);
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
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 삭제한다.(pri_scg_grp_cmdt)<br>
	 * 
	 * @param List<PriScgGrpCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removeGRICommodityS(List<PriScgGrpCmdtVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtVODSQL(), delModels,null);
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
	}
	
	/**
	 * 단건의Surcharge Group Location  데이터를 생성한다.(PRI_SCG_GRP_CMDT_DTL)<br>
	 * 
	 * @param PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO
	 * @exception DAOException
	 */
	public void addGRICommodityDetail(PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScgGrpCmdtDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVOCSQL(), param, velParam);
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
	 * 단건의 Surcharge Group Location 데이터를 갱신한다.(PRI_SCG_GRP_CMDT_DTL)<br>
	 * 
	 * @param PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyGRICommodityDetail(PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScgGrpCmdtDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVOUSQL(), param, velParam);
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
	 * 단건의 Surcharge Group Location 데이터를 삭제한다.(PRI_SCG_GRP_CMDT_DTL)<br>
	 * 
	 * @param PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGRICommodityDetail(PriScgGrpCmdtDtlVO priScgGrpCmdtDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScgGrpCmdtDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVODSQL(), param, velParam);
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
	 * 본문별 Surcharge Group Location 데이터를 삭제한다.(PRI_SCG_GRP_CMDT_DTL)<br>
	 * 
	 * @param PriScgGrpCmdtVO priScgGrpCmdtVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGRICommodityDetail(PriScgGrpCmdtVO priScgGrpCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScgGrpCmdtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVOAllDSQL(), param, velParam);
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
	 * 다건의 Surcharge Group Location 데이터를 일괄적으로 생성한다.(PRI_SCG_GRP_CMDT_DTL)<br>
	 * 
	 * @param List<PriScgGrpCmdtDtlVO> insModels
	 * @exception DAOException
	 */
	public void addGRICommodityDetailS(List<PriScgGrpCmdtDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVOCSQL(), insModels,null);
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
	}
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.(PRI_SCG_GRP_CMDT_DTL)<br>
	 * 
	 * @param List<PriScgGrpCmdtDtlVO> updModels
	 * @exception DAOException
	 */
	public void modifyGRICommodityDetailS(List<PriScgGrpCmdtDtlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVOUSQL(), updModels,null);
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
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 삭제한다.(PRI_SCG_GRP_CMDT_DTL)<br>
	 * 
	 * @param List<PriScgGrpCmdtDtlVO> delModels
	 * @exception DAOException
	 */
	public void removeGRICommodityDetailS(List<PriScgGrpCmdtDtlVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVODSQL(), delModels,null);
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
	}
	
}
