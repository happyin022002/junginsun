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
* =========================================================
* History :
* 2008.01.30 박은주 N200801230002 e-NIS/BSA 시스템 변경 요청
*                  Type Size(Sub-allocation)별로 판매/구매 및 Free allocation 기능 추가[104]
* 2008.02.27 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청 
*                  Month로 조회시 Cost_yrmon, Week 조회시 Sls_yrmon 으로 조회되도록 쿼리문 수정
* 2008.05.29 박은주 COA_BSA_VVD_MST 테이블의 컬럼명 변경 (rt_bsa_cfm_flg->port_bsa_cfm_flg)
* 2008.10.24 전성진 CSR No.N200810100017 [030]
*                   : Slot Price 및 TEU & Slot Price 화면 추가
*                     searchSlotPrcSwapVvdList, searchTEUPrcSwapVvdList
* 2009.01.23 박은주 CSR No.N200901190012 [030]
* 2009.01.23 박은주 CSR No.N200901200001 [030]
*                  TES&Slot Price 데이터의 Slot Price가 Contract시 단가가 아니라 
*                  Basic Slottage에 적용된 단가가 조회되도록 프로그램 수정
* 2009.06.01 박은주 CSR No.R200905280002 품질검토결과 수정사항 반영   
* 2009.09.14 남궁진호 CSR No.CHM-200900987 -searchSpcSlotInfoByVvdOnVesselList : D3 Type코드 추가 
* 2009.09.24 남궁진호 ALPS 전환 작업 1.0 Creation
 * 2009.06.01 박은주 CSR No.R200905280002 품질검토결과 수정사항 반영           
 * 2013.10.22 진마리아 - printStackTrace 수정 미태깅으로 인한 LIVE LOG 발생
 * 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
 * 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.DailyBatchConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.MultiSupplySwapVvdVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotInfoByVvdOnVesselListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotSwapByVvdListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdDetailListVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdMasterListVO;
import com.hanjin.apps.alps.esm.bsa.common.Utils;
import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BsaVvdMstVO;
import com.hanjin.syscommon.common.table.BsaVvdOtrCrrVO;
import com.hanjin.syscommon.common.table.BsaVvdPortDwnVO;
import com.hanjin.syscommon.common.table.BsaVvdSwapInfoVO;


/**
 * enis-BSAManage에 대한 DB 처리를 담당<br>
 * - enis-BSAManage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
			}
	        	SQLExecuter sqlExe = new SQLExecuter("");
	        	result = sqlExe.executeSP((ISQLTemplate)new SPCManageDBDAODailyBatchCSQL(), param, null);

	        	
	        	err_cd = (String)result.get("p_err_cd");
	        	err_msg = (String)result.get("p_err_msg");
	        	if(err_cd != null){
				err_cd  = Utils.iif(err_cd == null, "99999", err_cd);
	        	}
				
				if(err_msg != null){
				err_msg = Utils.iif(err_msg== null, "PROCEDURE 수행 중 예상치 못한 에러가 발생하였습니다. 관리자에게 문의하십시오.",err_msg);
				}
				
				if(vo != null){
					vo.setPErrCd(err_cd);
		        	vo.setPErrMsg(err_msg);
				}
				
	        }catch (SQLException se) {
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
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
	
	/**
	 * SAVE 동작 수행 - update / 2016.01.29 김성욱
	 * @param MultiSupplySwapVvdVO[] multiSupplySwapVvdVOs
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void saveSupplySwapVvd( MultiSupplySwapVvdVO[] multiSupplySwapVvdVOs , SignOnUserAccount account ) throws DAOException {
		MultiSupplySwapVvdVO rsVo = new MultiSupplySwapVvdVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(multiSupplySwapVvdVOs != null && multiSupplySwapVvdVOs.length > 0){
				//여러 row 에 대한 처리.
				for( int x=0 ; x<multiSupplySwapVvdVOs.length ; x++ ) {
					rsVo = multiSupplySwapVvdVOs[x];
					param = new HashMap<String, Object>();
					velParam = new HashMap<String, Object>();
					
					if( rsVo.getYyww() == null || rsVo.getYyww().length() == 0 ) continue;
					Map<String, String> mapVO = rsVo .getColumnValues();
					param.putAll(mapVO);				
					velParam.putAll(mapVO);
					
					//BSA Port up/down 처리용.
					if( rsVo.getTabIndex().equals("0") ){
						param.put("jb_cd","007");
						velParam.put("jb_cd","007");
					} else if( rsVo.getTabIndex().equals("1") ){
						param.put("jb_cd","015");
						velParam.put("jb_cd","015");
					}
					
					//수정되는 값의 갯수가 가변적이고 갯수가 많아서 모두 VO로 만들 수 없음.
					String tmp = rsVo.getHeaderName();
					String tmpV = rsVo.getHeaderValue();
					String tmpD = rsVo.getDValue();
					
					String[] tmpAry = tmp.split(",");
					String[] tmpVAry = tmpV.split(",");
					String[] tmpDAry = tmpD.split(",");
					
					//각 row의 CRR_CD 처리
					for( int k=0 ; k<tmpAry.length ; k++ ) {
						
						if( tmpAry[k] == null || tmpAry[k].equals("") ) continue;
						
						//선사명은 있고 값이 없는 경우 빈값이 들어가게 되어 에러 발생하므로 값을 0 으로 세팅함.
//						if( tmpVAry[k] == null || tmpVAry[k].equals("") ) tmpVAry[k] = "0";
//						if( tmpDAry[k] == null || tmpDAry[k].equals("") ) tmpDAry[k] = "0";

						param.put( "crr_cd" , tmpAry[k].substring( 0, 3 ) ); //선사 명
						param.put( "bsa_op_jb_cd" , tmpAry[k].substring( 3 ) );
						param.put( "crr_bsa_capa" , tmpVAry[k]);
						param.put("cre_usr_id", account.getUsr_id()+"_MNL");
						param.put("upd_usr_id", account.getUsr_id()+"_MNL");
						param.put("def_value", tmpDAry[k]);
						
						velParam.put( "crr_cd" , tmpAry[k].substring( 0, 3 ) );
						velParam.put( "bsa_op_jb_cd" , tmpAry[k].substring( 3 ) );
						velParam.put( "crr_bsa_capa" , tmpVAry[k]);
						velParam.put("cre_usr_id", account.getUsr_id()+"_MNL");
						velParam.put("upd_usr_id", account.getUsr_id()+"_MNL");
						velParam.put("def_value", tmpDAry[k]);
						
						log.debug("1. bsa_vvd_crr_perf 값 변경");
						//bsa_vvd_crr_perf 값 변경
						new SQLExecuter("").executeUpdate((ISQLTemplate)new SPCManageDBDAOMultiSupplySwapVvdVOUSQL(), param, velParam);
						
						log.debug("2. 모든 선사의 BSA_VVD_PORT_DWN입력");
						//BSA_VVD_PORT_DWN 변경
						// 모든 선사의 CRR_CD BSA입력
						new SQLExecuter("").executeUpdate((ISQLTemplate)new SPCManageDBDAOAddStepUpDownPortBsaCapaCSQL (), param, velParam);
						
						if( rsVo.getTabIndex().equals("0") ){
							log.debug("3. 모든 선사의 CRR_CD BSA입력");
							// 모든 선사의 CRR_CD BSA변경
							new SQLExecuter("").executeUpdate((ISQLTemplate)new SPCManageDBDAOMultiStepUpDownPortBsaCapaUSQL(), param, velParam);
							
							log.debug("4. SPC Slot Into - OTHER crr");
							// SPC Slot Into - OTHER crr
							new SQLExecuter("").executeUpdate((ISQLTemplate)new SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselUSQL(), param, velParam);
							
							log.debug("4.5. HJS이외 선사의 WEIGHT 업데이트");
							// SPC Slot Into - OTHER crr
							new SQLExecuter("").executeUpdate((ISQLTemplate)new SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselWeightUSQL(), param, velParam);
						}
					}
					
					//BSA_VVD_MST table의 MNL_FLG 값 변경 적용.
					//이전에 만들어진 query 를 사용해서 현재 VO와 맞지 않는 파라미터 명 맞추는 중
					param.put("rlane_cd", rsVo.getLaneCd());
					param.put("skd_voy_no", rsVo.getVoyNo());
					param.put("skd_dir_cd", rsVo.getDirCd());
					
					velParam.put("rlane_cd", rsVo.getLaneCd());
					velParam.put("skd_voy_no", rsVo.getVoyNo());
					velParam.put("skd_dir_cd", rsVo.getDirCd());

					//BSA_VVD_MST 값 변경
					if( param.get( "UPD_USR_ID") == null ){
						param.put("upd_usr_id", account.getUsr_id()+"_MNL");
						velParam.put("upd_usr_id", account.getUsr_id()+"_MNL");
					}
					new SQLExecuter("").executeUpdate((ISQLTemplate)new SPCManageDBDAOModifySpcSlotSwapByVvdMasterUSQL(), param, velParam);
					
					//BSA_VVD_PORT_DWN 변경
					// HJS_FINAL 변경 - 한번만 수행
					param.put("crr_cd", "SML");
					velParam.put("crr_cd", "SML");
					if( rsVo.getTabIndex().equals("0") ){
						log.debug("5. HJS_FINAL 변경 - 한번만 수행");
						new SQLExecuter("").executeUpdate((ISQLTemplate)new SPCManageDBDAOMultiStepUpDownPortBsaCapaUSQL(), param, velParam);

						// SPC Slot Into - OTHER crr 의 SML Final값
						log.debug("6. SPC Slot Into - OTHER crr 의 SML Final값");
						new SQLExecuter("").executeUpdate((ISQLTemplate)new SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselUSQL(), param, velParam);
						
						// HJS의 WEIGHT 업데이트 
						log.debug("7. HJS의 WEIGHT 업데이트");
						new SQLExecuter("").executeUpdate((ISQLTemplate)new SPCManageDBDAOModifySpcSlotInfoByVvdOnVesselWeightUSQL(), param, velParam);
					}
					
					if( rsVo.getMnlFlg()!=null && ( rsVo.getMnlFlg().equals("") || rsVo.getMnlFlg().equals("N") ) ){
						log.debug("7777777");
						new SQLExecuter("").executeUpdate((ISQLTemplate)new SPCManageDBDAORemoveSpcSlotInfoByVvdMasterDSQL(), param, velParam);
						new SQLExecuter("").executeUpdate((ISQLTemplate)new SPCManageDBDAORemoveStepUpDownVvdDSQL(), param, velParam);
					}
				}
				log.debug("EEEEEEEEENNNNNNNNNNNNNDDDDDDDDDDDDD!!!!!!!!!");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}