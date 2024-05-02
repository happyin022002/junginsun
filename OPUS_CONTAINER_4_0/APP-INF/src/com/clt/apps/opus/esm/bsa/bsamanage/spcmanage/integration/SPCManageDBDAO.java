/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName       : BSAManageDBDAO.java
 *@FileTitle      : BSA Manage
*Open Issues      :
*Change history   :
*@LastModifyDate  : 2006-12-21
*@LastModifier    : KimJongBeom
*@LastVersion     : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.DailyBatchConditionVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotInfoByVvdOnVesselListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotSwapByVvdListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdDetailListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdMasterListVO;
import com.clt.apps.opus.esm.bsa.common.Utils;
import com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BsaVvdMstVO;
import com.clt.syscommon.common.table.BsaVvdOtrCrrVO;
import com.clt.syscommon.common.table.BsaVvdPortDwnVO;
import com.clt.syscommon.common.table.BsaVvdSwapInfoVO;


/**
 * BSAManage에 대한 DB 처리를 담당<br>
 * - BSAManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KimJongBeom
 * @see SPCManageBCImpl 참조
 * @since J2EE 1.4
 */
public class SPCManageDBDAO extends DBDAOSupport {
	
	/**
	 * BSA_OP_JB, BSA_CRR_RGST테이블에서 ESM_BSA_0030의 HEADER목록을 조회한다.
	 * 
	 * @param  SearchSpcConditionVO vo
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchOpJobCarrierList(SearchSpcConditionVO vo) throws DAOException {
		log.debug("\n\n[ SPCManageDBDAO.searchOpJobCarrierList Start ]");
		DBRowSet dbRowset = new DBRowSet();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCManageDBDAOSearchOpJobCarrierListRSQL(), param, velParam);
			
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}		

	/**
	 * BSA_VVD_MST, BSA_VVD_CRR_PERF 테이블의 내용을 조회한다.
	 * 
	 * @param SearchSpcConditionVO vo
	 * @param String[] codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchSupplySwapVvdList(SearchSpcConditionVO vo, String[] codeArr) throws DAOException {
		log.debug("\n\n[ SPCManageDBDAO.searchSupplySwapVvdList Start ]");
		DBRowSet dbRowset  = new DBRowSet();

//		List<SearchSlotCostListVO> list = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCManageDBDAOSearchSupplySwapVvdListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	/**
	 * BSA_VVD_MST, BSA_VVD_CRR_PERF 테이블의 내용을 조회한다.
	 * 
	 * @param SearchSpcConditionVO vo
	 * @param String[] codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchSlotPrcSwapVvdList(SearchSpcConditionVO vo, String[] codeArr) throws DAOException {
		log.debug("\n\n[ SPCManageDBDAO.searchSlotPrcSwapVvdList Start ]");
		DBRowSet dbRowset  = new DBRowSet();

//		List<SearchSlotCostListVO> list = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCManageDBDAOSearchSlotPrcSwapVvdListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	/**
	 * BSA_VVD_MST, BSA_VVD_CRR_PERF 테이블의 내용을 조회한다.
	 * 
	 * @param SearchSpcConditionVO vo
	 * @param String[] codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchTEUPrcSwapVvdList(SearchSpcConditionVO vo, String[] codeArr) throws DAOException {
		log.debug("\n\n[ SPCManageDBDAO.searchTEUPrcSwapVvdList Start ]");
		DBRowSet dbRowset  = new DBRowSet();

//		List<SearchSlotCostListVO> list = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCManageDBDAOSearchTEUPrcSwapVvdListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	/**
	 * BSA_VVD_MST, BSA_VVD_CRR_PERF, BSA_VVD_PERF 테이블의 내용을 조회한다.
	 * ESM_BSA_0030
	 * @param SearchSpcConditionVO vo
	 * @param String[] codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchRevCostSwapVvdList(SearchSpcConditionVO vo, String[] codeArr) throws DAOException {
		log.debug("\n\n[ SPCManageDBDAO.searchRevCostSwapVvdList Start ]");
		DBRowSet dbRowset  = new DBRowSet();

//		List<SearchSlotCostListVO> list = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCManageDBDAOSearchRevCostSwapVvdListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	
	/**
	 * BSA_VVD_MST, BSA_VVD_CRR_PERF, BSA_VVD_PERF 테이블의 내용을 조회한다.
	 * 
	 * @param SearchSpcConditionVO vo
	 * @param String[] codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchSpcSlotInfoByVvdList(SearchSpcConditionVO vo,String[] codeArr) throws DAOException {
		DBRowSet dbRowset = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr );
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCManageDBDAOSearchSpcSlotInfoByVvdListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpcSlotInfoByVvdListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	/**
	 * BSA_VVD_OTR_CRR
	 * 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 
	 * @param  List<BsaVvdOtrCrrVO> insModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] multiSpcSlotInfoByVvdOtrCrr(List<BsaVvdOtrCrrVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new  SPCManageDBDAOMultiSpcSlotInfoByVvdOtrCrrCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_VVD_SWAP_INFO 
	 * 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 
	 * @param  List<BsaVvdSwapInfoVO> insModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] multiSpcSlotInfoByVvd(List<BsaVvdSwapInfoVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAOMultiSpcSlotInfoByVvdCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_VVD_MST 
	 * 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 
	 * @param  List<BsaVvdMstVO> updModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] modifymultiSpcSlotInfoByVvdMaster(List<BsaVvdMstVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAOModifymultiSpcSlotInfoByVvdMasterUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * BSA_VVD_PORT_DWN 
	 * 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 
	 * @param  List<BsaVvdPortDwnVO> updModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] modifymultiSpcSlotInfoByVvdPortDwn(List<BsaVvdPortDwnVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAOModifymultiSpcSlotInfoByVvdPortDwnUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * BSA_VVD_OTR_CRR
	 * 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 
	 * @param  List<BsaVvdOtrCrrVO> updModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] modifymultiSpcSlotInfoByVvdOtrCrr(List<BsaVvdOtrCrrVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAOModifymultiSpcSlotInfoByVvdOtrCrrUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * BSA_VVD_OTR_CRR
	 * 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 
	 * @param  List<BsaVvdOtrCrrVO> updModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] modifymultiSpcSlotInfoByVvdOtrCrr2(List<BsaVvdOtrCrrVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAOModifymultiSpcSlotInfoByVvdOtrCrr2USQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	

	
	/**
	 * 
	 * @param SearchSpcConditionVO vo
	 * @return  List<SearchSpcSlotInfoByVvdOnVesselListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpcSlotInfoByVvdOnVesselListVO> searchSpcSlotInfoByVvdOnVesselList(SearchSpcConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpcSlotInfoByVvdOnVesselListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCManageDBDAOSearchSpcSlotInfoByVvdOnVesselListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpcSlotInfoByVvdOnVesselListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * BSA_VVD_MST, BSA_VVD_OTL_CRR 테이블의 내용을 조회한다.
	 * 
	 * @param SearchSpcConditionVO vo
	 * @return List< SearchSpcSlotSwapByVvdListVO >
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpcSlotSwapByVvdListVO> searchSpcSlotSwapByVvdList(SearchSpcConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpcSlotSwapByVvdListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCManageDBDAOSearchSpcSlotSwapByVvdListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpcSlotSwapByVvdListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * BSA_VVD_SWAP_INFO 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.<br>
	 * ESM_BSA_0104의 팝업화면 [ESM_BSA_0121]
	 * @param  List<BsaVvdSwapInfoVO> insModels
	 * @return    EsmBsa0104Event
	 * @throws DAOException
	 */
	public int[] addmultiSpcSlotSwapByVvd(List<BsaVvdSwapInfoVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAOAddmultiSpcSlotSwapByVvdCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_VVD_SWAP_INFO 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.<br>
	 * ESM_BSA_0104의 팝업화면 [ESM_BSA_0121]
	 * @param  List<BsaVvdSwapInfoVO> updModels
	 * @return    EsmBsa0104Event
	 * @throws DAOException
	 */
	public int[] modifymultiSpcSlotSwapByVvd(List<BsaVvdSwapInfoVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAOModifymultiSpcSlotSwapByVvdUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	/**
	 * BSA_VVD_SWAP_INFO 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.<br>
	 * ESM_BSA_0104의 팝업화면 [ESM_BSA_0121]
	 * @param  List<BsaVvdMstVO> updModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] modifySpcSlotSwapByVvdMaster(List<BsaVvdMstVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAOModifySpcSlotSwapByVvdMasterUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0032
	 * @param SearchSpcConditionVO vo
	 * @return List< SearchStepUpDownVvdMasterListVO >
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchStepUpDownVvdMasterListVO> searchStepUpDownVvdMasterList(SearchSpcConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchStepUpDownVvdMasterListVO> list = null;

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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCManageDBDAOSearchStepUpDownVvdMasterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStepUpDownVvdMasterListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * BSA_VVD_PORT_DWN의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * - 사용 프로그램 : ESM_BSA_0032
	 * 
	 * @param List<BsaVvdMstVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifySetUpDownVvdMaster(List<BsaVvdMstVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAOModifySetUpDownVvdMasterUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0032
	 * @param SearchSpcConditionVO vo 
	 * @return List< SearchStepUpDownVvdDetailListVO >
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchStepUpDownVvdDetailListVO> searchStepUpDownVvdDetailList(SearchSpcConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchStepUpDownVvdDetailListVO> list = null;

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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCManageDBDAOSearchStepUpDownVvdDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStepUpDownVvdDetailListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * BSA_VVD_PORT_DWN의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * - 사용 프로그램 : ESM_BSA_0032
	 * 
	 * @param List<BsaVvdPortDwnVO> insModels
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] addmultiBsaVvdPortDwn(List<BsaVvdPortDwnVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAOAddmultiBsaVvdPortDwnCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaVvdPortDwnVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiBsaVvdPortDwn(List<BsaVvdPortDwnVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAOModifymultiBsaVvdPortDwnUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaVvdPortDwnVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiBsaVvdPortDwn(List<BsaVvdPortDwnVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SPCManageDBDAORemovemultiBsaVvdPortDwnDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * Daily Batch를 돌린다.
	 * @param DailyBatchConditionVO vo
	 * @return DailyBatchConditionVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DailyBatchConditionVO dailyBatch (DailyBatchConditionVO vo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> result = new HashMap<String, Object>();
		
		String err_cd ="";
		String err_msg ="";
		try{
				if(vo != null){												//SJH.20150508.소스품질
					Map<String, String> mapVO = vo .getColumnValues();
					param.putAll(mapVO);				
				
		        	SQLExecuter sqlExe = new SQLExecuter("");
		        	result = sqlExe.executeSP((ISQLTemplate)new SPCManageDBDAODailyBatchCSQL(), param, null);
	
		        	
		        	err_cd = (String)result.get("p_err_cd");
		        	err_msg = (String)result.get("p_err_msg");
		        	
					err_cd  = Utils.iif(err_cd == null, "99999", err_cd);
					err_msg = Utils.iif(err_msg== null, "PROCEDURE 수행 중 예상치 못한 에러가 발생하였습니다. 관리자에게 문의하십시오.",err_msg);
					
					vo.setPErrCd(err_cd);
		        	vo.setPErrMsg(err_msg);
				}
				
	        }catch (SQLException se) {
	        	log.error("err "+se.toString(),se);
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	        	log.error("err "+ex.toString(),ex);
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return vo;
	    }	
	
	/**
	 * 검색조건의 년 주차 기간을 조회한다. 
	 * 
	 * @param String year
	 * @param String fmWk
	 * @param String toWk
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchYrWkDu(String year, String fmWk, String toWk) throws DAOException {
		DBRowSet dbRowset = new DBRowSet();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(year != null){
				param.put("cost_yr",year);
				param.put("fm_wk",fmWk);
				param.put("to_wk",toWk);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCManageDBDAOSearchYrWkDuRSQL(), param, null);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
}