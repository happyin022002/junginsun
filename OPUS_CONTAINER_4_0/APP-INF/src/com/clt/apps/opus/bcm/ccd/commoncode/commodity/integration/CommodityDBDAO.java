/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommodityDBDAO.java
*@FileTitle : Commodity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.24 조인영
* 1.0 Creation
=========================================================*/
 
package com.clt.apps.opus.bcm.ccd.commoncode.commodity.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.ccd.commoncode.commodity.basic.CommodityBCImpl;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.CommodityVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.CustPackageTypeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.GrpCommodityVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.PackageTypeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.RepCommodityVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS_CNTR-Commodity <br>
 * OPUS_CNTR-Commodity system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 조인영
 * @see CommodityBCImpl 참조
 * @since J2EE 1.6
 */

public class CommodityDBDAO extends DBDAOSupport {
	
	/**
	 * Group Commodity 정보를 가져온다<br>
	 * 
	 * @param String grpCmdtCd
	 * @return List<GrpCommodityVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<GrpCommodityVO> searchGroupCommodity(String grpCmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<GrpCommodityVO> grpCmdtVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("grp_cmdt_cd", grpCmdtCd);
			vparam.put("grp_cmdt_cd", grpCmdtCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOSearchGroupCommodityRSQL(), param, vparam);
			grpCmdtVO = (List)RowSetUtil.rowSetToVOs(dbRowset, GrpCommodityVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return grpCmdtVO;
	}
    
	/**
	 * Group Commodity 정보를 저장한다(입력)<br>
	 * 
	 * @param grpCmdtVO List<GrpCommodityVO>
	 * @throws DAOException
	 */
	public void addGroupCommodity(List<GrpCommodityVO> grpCmdtVO) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(grpCmdtVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOAddGroupCommodityCSQL(), grpCmdtVO, null);
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
	 * Group Commodity 정보를 저장한다(수정)<br>
	 * 
	 * @param grpCmdtVO List<GrpCommodityVO>
	 * @throws DAOException
	 */
	public void modifyGroupCommodity(List<GrpCommodityVO> grpCmdtVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(grpCmdtVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOModifyGroupCommodityUSQL(), grpCmdtVO, null);
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
	 * Rep Commodity 정보를 가져온다<br>
	 * 
	 * @param String repCmdtCd
	 * @return List<RepCommodityVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<RepCommodityVO> searchRepCommodity(String repCmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<RepCommodityVO> repCmdtVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("rep_cmdt_cd", repCmdtCd);
			vparam.put("rep_cmdt_cd", repCmdtCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOSearchRepCommodityRSQL(), param, vparam);
			repCmdtVO = (List)RowSetUtil.rowSetToVOs(dbRowset, RepCommodityVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return repCmdtVO;
	}
    
	/**
	 * Rep Commodity 정보를 저장한다(입력)<br>
	 * 
	 * @param repCmdtVO List<RepCommodityVO>
	 * @throws DAOException
	 */
	public void addRepCommodity(List<RepCommodityVO> repCmdtVO) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(repCmdtVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOAddRepCommodityCSQL(), repCmdtVO, null);
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
	 * Rep Commodity 정보를 저장한다(수정)<br>
	 * 
	 * @param repCmdtVO List<RepCommodityVO>
	 * @throws DAOException
	 */
	public void modifyRepCommodity(List<RepCommodityVO> repCmdtVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(repCmdtVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOModifyRepCommodityUSQL(), repCmdtVO, null);
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
	 * Commodity 정보를 가져온다<br>
	 * 
	 * @param String cmdtCd
	 * @return List<CommodityVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<CommodityVO> searchCommodity(String cmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<CommodityVO> cmdtVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("cmdt_cd", cmdtCd);
			vparam.put("cmdt_cd", cmdtCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOSearchCommodityRSQL(), param, vparam);
			cmdtVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CommodityVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cmdtVO;
	}
	 
	 /**
		 * Commodity 정보를 가져온다<br>
		 * 
		 * @param rqstNo String
		 * @return List<CommodityVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		 
		public List<CommodityVO> searchCommodityRqst(String rqstNo) throws DAOException {
			DBRowSet dbRowset = null;
			
			List<CommodityVO> cmdtVO = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			Map<String, Object> vparam = new HashMap<String, Object>();

			try{
				//query parameter
				param.put("rqst_no", rqstNo);
				vparam.put("rqst_no", rqstNo);
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOSearchCommodityRqstRSQL(), param, vparam);
				cmdtVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CommodityVO.class);
				
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return cmdtVO;
		}
    
	/**
	 * Commodity 정보를 저장한다(입력)<br>
	 * 
	 * @param cmdtVO List<CommodityVO>
	 * @throws DAOException
	 */
	public void addCommodity(List<CommodityVO> cmdtVO) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cmdtVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOAddCommodityCSQL(), cmdtVO, null);
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
	 * Commodity 정보를 저장한다(입력)<br>
	 * 
	 * @param cmdtVO List<CommodityVO>
	 * @throws DAOException
	 */
	public void addCommodityRqst(List<CommodityVO> cmdtVO) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cmdtVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOAddCommodityRqstCSQL(), cmdtVO, null);
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
	 * Commodity 정보를 저장한다(수정)<br>
	 * 
	 * @param cmdtVO List<CommodityVO>
	 * @throws DAOException
	 */
	public void modifyCommodity(List<CommodityVO> cmdtVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(cmdtVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOModifyCommodityUSQL(), cmdtVO, null);
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
	 * Commodity 정보를 저장한다(수정)<br>
	 * 
	 * @param cmdtVO List<CommodityVO>
	 * @throws DAOException
	 */
	public void modifyCommodityRqst(List<CommodityVO> cmdtVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(cmdtVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOModifyCommodityRqstUSQL(), cmdtVO, null);
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
	 * Customer Package Type 정보를 가져온다<br>
	 * 
	 * @param String pckCd
	 * @param String cstmsCntCd
	 * @return List<CustPackageTypeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<CustPackageTypeVO> searchCustPackageType(String pckCd, String cstmsCntCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<CustPackageTypeVO> custPackTypeVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("pck_cd", pckCd);
			vparam.put("pck_cd", pckCd);
			param.put("cstms_cnt_cd", cstmsCntCd);
			vparam.put("cstms_cnt_cd", cstmsCntCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOSearchCustPackageTypeRSQL(), param, vparam);
			custPackTypeVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CustPackageTypeVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return custPackTypeVO;
	}
    
	/**
	 * Customer Package Type 정보를 저장한다(입력)<br>
	 * 
	 * @param custPackTypeVO List<CustPackageTypeVO>
	 * @throws DAOException
	 */
	public void addCustPackageType(List<CustPackageTypeVO> custPackTypeVO) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(custPackTypeVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOAddCustPackageTypeCSQL(), custPackTypeVO, null);
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
	 * Customer Package Type 정보를 저장한다(수정)<br>
	 * 
	 * @param custPackTypeVO List<CustPackageTypeVO>
	 * @throws DAOException
	 */
	public void modifyCustPackageType(List<CustPackageTypeVO> custPackTypeVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(custPackTypeVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOModifyCustPackageTypeUSQL(), custPackTypeVO, null);
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
	 * Package Type 정보를 가져온다<br>
	 * 
	 * @param String pckCd
	 * @return List<PackageTypeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
	public List<PackageTypeVO> searchPackageType(String pckCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<PackageTypeVO> packTypeVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.put("pck_cd", pckCd);
			vparam.put("pck_cd", pckCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOSearchPackageTypeRSQL(), param, vparam);
			packTypeVO = (List)RowSetUtil.rowSetToVOs(dbRowset, PackageTypeVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return packTypeVO;
	}
    
	/**
	 * Package Type 정보를 저장한다(입력)<br>
	 * 
	 * @param packTypeVO List<PackageTypeVO>
	 * @throws DAOException
	 */
	public void addPackageType(List<PackageTypeVO> packTypeVO) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(packTypeVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOAddPackageTypeCSQL(), packTypeVO, null);
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
	 * Package Type 정보를 저장한다(수정)<br>
	 * 
	 * @param packTypeVO List<PackageTypeVO>
	 * @throws DAOException
	 */
	public void modifyPackageType(List<PackageTypeVO> packTypeVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(packTypeVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CommodityDBDAOModifyPackageTypeUSQL(), packTypeVO, null);
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
}
