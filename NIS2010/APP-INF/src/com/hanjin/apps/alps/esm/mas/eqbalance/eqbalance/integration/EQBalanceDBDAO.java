/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EQBalanceDBDAO.java
 *@FileTitle : Repo U/C 
 *Open Issues :
 *@LastModifyDate	: 2009.10.09
 *@LastModifier 	: 박수훈
 *@LastVersion : 1.16
 *2006-11-16 Sangwook_Nam
 * Change history : 
 * 2008.01.11 전윤주 CSR No.N200712280004   EQ repo rule-set X level 수정하고 저장할 수 있도록 변경 
 *                  (16번 화면 수정 )
 * 2008.02.11 전윤주 CSR NO.N200802010006   EQ repo rule-set trade tree 구조로 변경 -박보배씨 요청
 *                  (16, 17, 136번 화면 수정)                  
 * 2008.06.26 전윤주 동일 ECC 내의 MVMT 제외 하고 만든 Simulated Cost 추가로 조건절 변경
 *                  (19번 화면 수정 )  
 * 2008.09.01 전윤주 CSR No.N200808260006 EQ repo rule-set(Rlane setting을 From-To ECC setting으로) 
 *                  (136번 화면 수정 , 161번 화면 추가)  
 *                  (17번 화면 삭제)  
 * 2008.09.25 전윤주 CSR No.N200809220006 RF CNTR (R2, R5) 각각 POR, DEL setting 가능하게 수정 [136, 161] 
 * 2008.10.22 전윤주 CSR No.N200810210022 MAS_RD2, RD5 Rule-Set 화면 보완 [016, 018, 136, 161]
 * 2009.04.20 전윤주 CSR No.N200904070092 MAS_CM 계산 수식 변경 [019]   
 * 2009.06.01 박은주 CSR No.R200905280002 품질검토결과 수정사항 반영      
 * 2009.08.28 박수훈  New FrameWork 적용 [0019]
 * 2009.09.07 박수훈  New FrameWork 적용 [0018]
 * 2009.09.21 장영석  New FrameWork 적용 [0016]  
 * 2009.10.08 박수훈  New FrameWork 적용 [0161]   
 * 2009.10.09 박수훈  New FrameWork 적용 [0136]       
*  2010.02.04 임옥영 :품질검토결과 반영     
*  2010.02.12 임옥영 Line No. 513 :  : shall be matched with size of parameter
*  2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -POR 별 Credit Ratio를 setup 할수 있는 화면추가 (Rule-set)     
 =========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.basic.EQBalanceBCImpl;
import com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.vo.SearchEQBalance00163ListVO;
import com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.vo.SearchEQBalance0016ListVO;
import com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.vo.SearchEQBalance0018ListVO;
import com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.vo.SearchEQBalance0019ListVO;
import com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.vo.SearchEQBalance0136ListVO;
import com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.vo.SearchEQBalance0161ListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MasCntrRepoCrVO;
import com.hanjin.syscommon.common.table.MasCntrRepoRoutEccVO;
import com.hanjin.syscommon.common.table.MasCntrRepoRuleVO;
import com.hanjin.syscommon.common.table.MasCntrRepoShtgInfoVO;



/**
 * ALPS-MAS에 대한 DB 처리를 담당<br>
 * - ALPS-MAS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Sangwook_Nam
 * @see EQBalanceBCImpl 참조
 * @since J2EE 1.6
 */
public class EQBalanceDBDAO extends DBDAOSupport {
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * @param SearchConditionVO searchConditionVO
	 * 
	 * @return List<SearchEQBalance0163ListVO>
	 * @throws DAOException
	 */
	 public List<SearchEQBalance00163ListVO> searchEQBalance00163List(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEQBalance00163ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQBalanceDBDAOSearchEQBalance00163ListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEQBalance00163ListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }
	 
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_MAS_0016 화면에 대한 멀티 이벤트 처리(UPDATE)<br>
	 * 
	 * @param List<MasCntrRepoShtgInfoVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyEQBalance00163(List<MasCntrRepoShtgInfoVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EQBalanceDBDAOMasCntrRepoShtgInfoVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_MAS_0016 화면에 대한 멀티 이벤트 처리(Insert)<br>
	 * 
	 * @param List<MasCntrRepoShtgInfoVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addEQBalance00163(List<MasCntrRepoShtgInfoVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EQBalanceDBDAOMasCntrRepoShtgInfoVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

    /**
	 * 멀티 이벤트 처리<br>
	 * ESM_MAS_0016 화면에 대한 멀티 이벤트 처리(DELETE)<br>
	 * 
	 * @param List<MasCntrRepoShtgInfoVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	 public int[] removeEQBalance00163(List<MasCntrRepoShtgInfoVO> delModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){	
					insCnt = sqlExe.executeBatch((ISQLTemplate)new EQBalanceDBDAOMasCntrRepoShtgInfoVODSQL(), delModels,null);
			
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");				
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * ESM_MAS_0016 화면에 대한 이벤트 처리(DELETE)<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCostYrmonMasCntrRepoShtgInfo(SearchConditionVO searchConditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new EQBalanceDBDAODeleteCostYrmonMasCntrRepoShtgInfoVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * EQBalance의 모든 목록을 가져온다.<br>
	 * Set Credit Ratio popup
	 * ESM_MAS_0018 조회
	 * 
	 * @param SearchEQBalance0018ListVO searchEQBalance0018ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchEQBalance0018ListVO>
	 * @throws DAOException
	 */
	public List<SearchEQBalance0018ListVO> searchEQBalance0018List(SearchEQBalance0018ListVO searchEQBalance0018ListVO
			                                                      ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEQBalance0018ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEQBalance0018ListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQBalanceDBDAOSearchEQBalance0018ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEQBalance0018ListVO .class);
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
	 * EQBalance의 모든 목록을 가져온 후 수정한다.<br>
	 * Set Credit Ratio popup
	 * ESM_MAS_0018 수정
	 * @param List<MasCntrRepoCrVO> masCntrRepoCrVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyEQBalance0018(List<MasCntrRepoCrVO> masCntrRepoCrVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masCntrRepoCrVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EQBalanceDBDAOMasCntrRepoCrVOUSQL(), masCntrRepoCrVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}

	/**
	 * EQBalance의 모든 목록을 가져온다.<br>
	 * Repo U/C 
	 * ESM_MAS_0019 조회
	 * 
	 * @param SearchEQBalance0019ListVO searchEQBalance0019ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<searchEQBalance0019ListVO>
	 * @throws DAOException
	 */
	public List<SearchEQBalance0019ListVO> searchEQBalance0019List (SearchEQBalance0019ListVO searchEQBalance0019ListVO
			                                                       ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEQBalance0019ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEQBalance0019ListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQBalanceDBDAOSearchEQBalance0019ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEQBalance0019ListVO .class);
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
	 * EQBalance의 모든 목록을 가져온다.<br>
	 * From ECC Setting popup
	 * ESM_MAS_0136 조회
	 * 
	 * @param SearchEQBalance0136ListVO searchEQBalance0136ListVO
	 * @param SearchConditionVO searchConditionVO	 
	 * @return List<SearchEQBalance0136ListVO>
	 * @throws DAOException
	 */
	public List<SearchEQBalance0136ListVO> searchEQBalance0136List(SearchEQBalance0136ListVO searchEQBalance0136ListVO
			                                                      ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEQBalance0136ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEQBalance0136ListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQBalanceDBDAOSearchEQBalance0136ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEQBalance0136ListVO .class);
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
	 * EQBalance의 모든 목록을 가져온 후 수정한다.<br>
	 * From ECC Setting popup
	 * ESM_MAS_0136 수정
	 * 
	 * @param List<MasCntrRepoRoutEccVO> masCntrRepoRoutEccVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyEQBalance0136(List<MasCntrRepoRoutEccVO> masCntrRepoRoutEccVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masCntrRepoRoutEccVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EQBalanceDBDAOMasCntrRepoRoutEccVOPORUSQL(), masCntrRepoRoutEccVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	
	/**
	 * EQBalance의 모든 목록을 가져온다.<br>
	 * To ECC Setting popup
	 * ESM_MAS_0161 조회
	 * 
	 * @param SearchEQBalance0161ListVO searchEQBalance0161ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchEQBalance0161ListVO>
	 * @throws DAOException
	 */
	public List<SearchEQBalance0161ListVO> searchEQBalance0161List(SearchEQBalance0161ListVO searchEQBalance0161ListVO
			                                                      ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEQBalance0161ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEQBalance0161ListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQBalanceDBDAOSearchEQBalance0161ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEQBalance0161ListVO .class);
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
	 * EQBalance의 모든 목록을 가져온 후 수정한다.<br>
	 * To ECC Setting popup
	 * ESM_MAS_0161 수정
	 * @param List<MasCntrRepoRoutEccVO> masCntrRepoRoutEccVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyEQBalance0161(List<MasCntrRepoRoutEccVO> masCntrRepoRoutEccVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(masCntrRepoRoutEccVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EQBalanceDBDAOMasCntrRepoRoutEccVODELUSQL(), masCntrRepoRoutEccVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	/**
	 * ECC_CD 존재유무 체크. <br>
	 * 
	 * @param eccCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchEccYn(String eccCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String check = "Y";
		try{
			param.put("eccCd"    ,eccCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQBalanceDBDAOSearchEQBalance00163CheckEccYnRSQL(), param, velParam);
			if(!dbRowset.next()){
				check = "N";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	
	
	
	/**
	 * MAS_CNTR_REPO_SHTG_INFO 테이블의 키중복 check  합니다. <br> dupCheck
	 * 
	 * @param costYrmon
	 * @param cntrOrgDestCd
	 * @param cntrTpszCd
	 * @param eccCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchDupCheck(String costYrmon, String cntrOrgDestCd ,String cntrTpszCd,String eccCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String check = "Y";
		try{
			param.put("costYrmon", costYrmon);
			param.put("cntrOrgDestCd", cntrOrgDestCd);
			param.put("cntrTpszCd", cntrTpszCd);
			param.put("eccCd", eccCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQBalanceDBDAOSearchEQBalance00163DupCheckRSQL(), param, velParam);
			if(!dbRowset.next()){
				check = "N";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
}