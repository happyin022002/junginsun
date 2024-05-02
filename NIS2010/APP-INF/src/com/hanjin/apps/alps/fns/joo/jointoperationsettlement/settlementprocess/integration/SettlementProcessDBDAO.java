/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JOOFindCodeAndCheckDBDAO.java
 *@FileTitle : 공통
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.07
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.05.07 박희동
 * 1.0 Creation
* ----------------------------------------------------------
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;


import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration.CarrierSettlementProcessDBDAOJooSettlementVODSQL;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration.CarrierSettlementProcessDBDAOJooSettlementVOUSQL;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration.CarrierSettlementProcessDBDAORobVvdListRSQL;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration.CarrierSettlementProcessDBDAOStlDupChkRSQL;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.JooStlVvdVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.SltHirTgtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoEstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoSettlementConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoLoadingVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.MvntEvntDtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlTgtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlStsVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoExpRptVO;




/**
 * ALPS SettlementProcessDBDAO <br>
 * - ALPS-Settlementprocess system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Hee Dong
 * @see SettlementProcessBCImpl 참조
 * @since J2EE 1.4
 */
public class SettlementProcessDBDAO extends DBDAOSupport {

    /**
     * 시행월의 마감여부를 체크한다.
     * @param JooCodeParamVO jooCodeParamVO
     * @return JooCodeInfoVO
     * @throws DAOException
     */
    public JooCodeInfoVO searchCheckEstmClz(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        JooCodeInfoVO jooCodeInfoVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOCheckSltHirClzRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
            
            
            if (list.isEmpty()){
            	jooCodeInfoVO = new JooCodeInfoVO();
            	jooCodeInfoVO.setCode("N");
            }else{
            	jooCodeInfoVO = (JooCodeInfoVO)list.get(0);
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return jooCodeInfoVO;
    }
        
	/**
	 * 추정테이블에서 TRADE코드를 조회합니다.
	 * @param JoEstmConditionVO estmConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws DAOException
	 */
	public List<JoEstmConditionVO> searchTradeCodeListEstm(JoEstmConditionVO estmConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JoEstmConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmConditionVO != null) {
				 Map<String, String> mapVO = estmConditionVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOSltHirTradeRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JoEstmConditionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}    
	
	/**
	 * 추정테이블에서 RLANE코드를 조회합니다.
	 * @param JoEstmConditionVO estmConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws DAOException
	 */
	public List<JoEstmConditionVO> searchRlaneCodeListEstm(JoEstmConditionVO estmConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JoEstmConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmConditionVO != null) {
				 Map<String, String> mapVO = estmConditionVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOSltHirRlaneRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JoEstmConditionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * 추정테이블에서 CARRIER코드를 조회합니다.
	 * @param JoEstmConditionVO estmConditionVO
	 * @return List<JoEstmConditionVO>
	 * @throws DAOException
	 */
	public List<JoEstmConditionVO> searchCarrierCodeListEstm(JoEstmConditionVO estmConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JoEstmConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmConditionVO != null) {
				 Map<String, String> mapVO = estmConditionVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOSltHirCarrierRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JoEstmConditionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/** 
	 * <pre>
	 *   JO Target Creation and Basic Slot Hire Settlement
	 *      UID : FNS_JOO_0104
	 * </pre>
	 * 
	 * @param JoSettlementConditionVO settlementConditionVO
	 * @return List<SltHirTgtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SltHirTgtVO> searchJointOperationAccrualList(JoSettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SltHirTgtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOSltHirTgtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SltHirTgtVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	/**
	 * 
	 * <pre>
	 *   JO Target Creation and Basic Slot Hire Settlement의 페이지 개수
	 *      UID : FNS_JOO_0104
	 * </pre>
	 * 
	 * @param JoSettlementConditionVO settlementConditionVO
	 * @return SltHirTgtVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SltHirTgtVO searchJointOperationAccrualTotal(JoSettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SltHirTgtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOSltHirTgtPageRSQL(), param, velParam);						
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SltHirTgtVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}		
	
	
	
//	/**
//	 * Slot Hire Target 저장
//	 * 
//	 * @param List<SltHirTgtVO> sltHirTgtVOs
//	 * @throws DAOException
//	 * @throws Exception
//	 */
//	public void addJointOperationAccruals(List<SltHirTgtVO> sltHirTgtVOs) throws DAOException, Exception {
////		try {
////			SQLExecuter sqlExe = new SQLExecuter("");
////			int updCnt[] = null;
////			if (sltHirTgtVOs.size() > 0) {
////				updCnt = sqlExe.executeBatch((ISQLTemplate) new SettlementProcessDBDAOSlotHireTgtCSQL(),sltHirTgtVOs, null);
////				for (int i = 0; i < updCnt.length; i++) {
////					if (updCnt[i] == Statement.EXECUTE_FAILED)
////						throw new DAOException("Fail to Update No" + i + " SQL");
////				}
////			}
//			
//			Map<String, Object> param = new HashMap<String, Object>();
//			// velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();
//			try {
//				Map<String, String> mapVO = null;				
//				
//	            if (sltHirTgtVOs != null){
//		            for ( int i=0; i<sltHirTgtVOs.size(); i++ ) {
//		            	mapVO = sltHirTgtVOs.get(i).getColumnValues();
//						
//						param.putAll(mapVO);
//						velParam.putAll(mapVO);
//			
//						SQLExecuter sqlExe = new SQLExecuter("");
//						int result = sqlExe.executeUpdate((ISQLTemplate) new SettlementProcessDBDAOSlotHireTgtCSQL(),param, velParam);
//						if (result == Statement.EXECUTE_FAILED)
//							throw new DAOException("Fail to insert SQL");						
//		            }
//	            }
//			
//			} catch (SQLException se) {
//				log.error(se.getMessage(), se);
//				throw new DAOException(new ErrorHandler(se).getMessage());
//			} catch (Exception ex) {
//				log.error(ex.getMessage(), ex);
//				throw new DAOException(new ErrorHandler(ex).getMessage());
//			}
//	}	
	
//	/**
//	 * Settlement 저장<br>
//	 * 
//	 * @param EstmActRsltVO estmActRsltVO
//	 * @throws DAOException
//	 * @throws Exception
//	 */
//	public void addJOOAccurals(EstmActRsltVO estmActRsltVO) throws DAOException, Exception {
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = estmActRsltVO.getColumnValues();
//
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe
//					.executeUpdate(
//							(ISQLTemplate) new SettlementProcessDBDAOJooStlTgtCSQL(),
//							param, velParam);
//			if (result == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}	
	
	
	/**
	 * Slot Hire Settlement정보를 수정한다.
	 * @param SltHirTgtVO sltHirTgtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifySettlementSltTgt(SltHirTgtVO sltHirTgtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = sltHirTgtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOSlotHireTgtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	/**
	 * Slot Hire Settlement정보를 삭제한다.
	 * @param SltHirTgtVO sltHirTgtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteSettlementSltTgt(SltHirTgtVO sltHirTgtVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {	
			Map<String, String> mapVO = sltHirTgtVO.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOSlotHireTgtDSQL(), mapVO, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 * Settlement정보를 입력한다.
	 * @param SltHirTgtVO sltHirTgtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSettlementSltTgt(SltHirTgtVO sltHirTgtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = sltHirTgtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOSlotHireTgtCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ROB 컨테이너 조회시 ETD기준 VVD List를 조회한다
	 * 
	 * @param TdrLoadVO tdrLoadVO
	 * @return List<TdrLoadVO>
	 * @throws DAOException
	 */
	public List<TdrLoadVO> searchRobVvdList(TdrLoadVO tdrLoadVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TdrLoadVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tdrLoadVO != null){
				Map<String, String> mapVO = tdrLoadVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAORobVvdListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TdrLoadVO .class);
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
	 * ROB 컨테이너 Summary를 조회한다
	 * 
	 * @param TdrLoadVO tdrLoadVO
	 * @param String gubun
	 * @return List<JoLoadingVO>
	 * @throws DAOException
	 */
	public List<JoLoadingVO> searchRobTotal(TdrLoadVO tdrLoadVO, String gubun) throws DAOException {
		DBRowSet dbRowset = null;
		List<JoLoadingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tdrLoadVO != null){
				Map<String, String> mapVO = tdrLoadVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAORobSummaryRSQL(), param, velParam);				
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JoLoadingVO .class);
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
	 * ROB 컨테이너 Summary를 조회시에 스케줄과 CTM 날짜가 맞는지 조회한다.
	 *  
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchRobPass(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAORobPassRSQL(), param, null);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("PASS");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	} 			
	
	/**
	 * Jo Loading 정보를 수정한다.
	 * @param JoLoadingVO joLoadingVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyJoLoading(JoLoadingVO joLoadingVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = joLoadingVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOJoLoadingUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	/**
	 * Jo Loading 정보를 입력한다.
	 * @param JoLoadingVO joLoadingVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJoLoading(JoLoadingVO joLoadingVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = joLoadingVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOJoLoadingCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Jo Rev Loading 정보를 입력한다.
	 * @param JoLoadingVO joLoadingVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJoRevLoading(JoLoadingVO joLoadingVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = joLoadingVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOJoRevLoadingCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Jo Rev Loading 정보를 입력한다.
	 * @param JoLoadingVO joLoadingVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJoRevLoadingMerge(JoLoadingVO joLoadingVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = joLoadingVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOJoRevLoadingMergeCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	
	
	/**
	 * Settlement정보를 조회한다.(W/R, PBS, OTH, S/H, OUS RDR, OUS, TDR 공통으로 사용된다.)
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	public List<ProcSettlementVO> searchSettlementList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(procSettlementVO != null){
				Map<String, String> mapVO = procSettlementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAOStlTgtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
	 * Jo Loading 정보를 삭제한다.
	 * @param JoLoadingVO joLoadingVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteJoLoading(JoLoadingVO joLoadingVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {	
			Map<String, String> mapVO = joLoadingVO.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOJoLoadingDSQL(), mapVO, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete JOO_LODG_TGT");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Jo Rev Loading 정보를 삭제한다.
	 * @param JoLoadingVO joLoadingVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteJoRevLoading(JoLoadingVO joLoadingVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();											
		try {	
			Map<String, String> mapVO = joLoadingVO.getColumnValues();			
			param.putAll(mapVO);
            velParam.put("yd_cd", joLoadingVO.getYdCd());
            velParam.put("clpt_ind_seq", joLoadingVO.getClptIndSeq());			
				
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOJoRevLoadingDSQL(), mapVO, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete JOO_LODG_TGT");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 * Movement Event Date 리스트 조회한다.
	 * @param MvntEvntDtVO mvntEvntDtVO 
	 * @return List<MvntEvntDtVO>
	 * @exception EventException
	 */
	public List<MvntEvntDtVO> searchMvntEvntDateList(MvntEvntDtVO mvntEvntDtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MvntEvntDtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mvntEvntDtVO != null){
				Map<String, String> mapVO = mvntEvntDtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAOMvntEvntDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MvntEvntDtVO .class);
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
	 * Skd Event Date 리스트 조회한다.
	 * @param MvntEvntDtVO mvntEvntDtVO 
	 * @return List<MvntEvntDtVO>
	 * @exception EventException
	 */
	public List<MvntEvntDtVO> searchSkdEvntDatet(MvntEvntDtVO mvntEvntDtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MvntEvntDtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mvntEvntDtVO != null){
				Map<String, String> mapVO = mvntEvntDtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAOSkdEvntDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MvntEvntDtVO .class);
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
	 *  Movement Event Date 정보를 삭제한다.
	 * @param MvntEvntDtVO mvntEvntDtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteMvntEvntDate(MvntEvntDtVO mvntEvntDtVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {	
			Map<String, String> mapVO = mvntEvntDtVO.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOMvntEvntDateDSQL(), mapVO, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete JOO_CNTR_MVMT_EVNT_DT");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Movement Event Date정보를 입력한다.
	 * @param MvntEvntDtVO mvntEvntDtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addMvntEvntDate(MvntEvntDtVO mvntEvntDtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mvntEvntDtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOMvntEvntDateCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	* FNS_JOO_0108: Retrieve
	* D : [FnsJoo0108Event]<br>
	* RDR Load DownLoad by VVD 을  조회 Retrieve 합니다.<br>
	* 
	 * @param TdrLoadVO tdrLoadVO
	 * @return List<JoLoadingVO>
	 * @throws DAOException
	 */
	public List<JoLoadingVO> searchTDRDownloadListByLane(TdrLoadVO tdrLoadVO)  throws DAOException {   
       DBRowSet dbRowset = null;
       List<JoLoadingVO> list = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       
       String sumFlg = "";
    
       try{
           if(tdrLoadVO != null){
               Map<String, String> mapVO = tdrLoadVO .getColumnValues();
           
               param.putAll(mapVO);
               velParam.putAll(mapVO);
               
               if(!(tdrLoadVO.getMergeCrr() == null || "".equals( tdrLoadVO.getMergeCrr()))){
            	   sumFlg = "Y";            	   
               }
               
        	   String crr = tdrLoadVO.getOprCd();        	   
			   String[] arrCrr = crr.split(",");
			   List<String> aryCrrList= new ArrayList(); 				   			   
			   for(int i=0; i<arrCrr.length; i++){
					aryCrrList.add(arrCrr[i]);						
			   }
       		   velParam.put("opr_cd2", aryCrrList);               
           }
           if (sumFlg.equals("Y")) {  //쿼리 분기 처리
        	   dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAOSearchTDRDownloadSumListByLaneRSQL(), param, velParam);
           } else {
        	   dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAOSearchTDRDownloadListByLaneRSQL(), param, velParam);
           }
           list = (List)RowSetUtil.rowSetToVOs(dbRowset, JoLoadingVO .class);
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
	 * <pre>
	 *   Settlement Target
	 *      UID : FNS_JOO_0110
	 * </pre>
	 * 
	 * @param JoSettlementConditionVO settlementConditionVO
	 * @return List<StlTgtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StlTgtVO> searchStlTgtList(JoSettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StlTgtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(settlementConditionVO != null){
				if("S/H".equals(settlementConditionVO.getJoStlItmCd())){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOStlTgtRSQL(), param, velParam);				
				}else{
					if("R".equals(settlementConditionVO.getReDivrCd())){	// Renvenue (Bay Plan)에서 넘어온 것
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOStlTgtOusRevRSQL(), param, velParam);
					}else{	// Expense (ROB)에서 넘어온 것
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOStlTgtOusRSQL(), param, velParam);					
					}
				}
			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, StlTgtVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	/** 
	 * <pre>
	 *   Settlement Target의 페이지 개수
	 *      UID : FNS_JOO_0110
	 * </pre>
	 * 
	 * @param JoSettlementConditionVO settlementConditionVO
	 * @return SltHirTgtVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SltHirTgtVO searchStlTgtTotalList(JoSettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SltHirTgtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOStlTgtPageRSQL(), param, velParam);						
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SltHirTgtVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}		
	
	/**
	 * Settlement Target 정보를 수정한다.
	 * @param StlTgtVO stlTgtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyStlTgt(StlTgtVO stlTgtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = stlTgtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOStlTgtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}		
	
	/**
	 * Settlement Target 정보를 입력한다.
	 * 
	 * @param StlTgtVO stlTgtVO 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addStlTgt(StlTgtVO stlTgtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = stlTgtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOStlTgtCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	 /**
	 * Settlement Target Close 정보를 수정한다.
	 * 
	 * @param StlTgtVO stlTgtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyStlTgtClz(StlTgtVO stlTgtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = stlTgtVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOStlTgtClzUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	
	
	
	
	/**
	 * Settlement Target 정보를 삭제한다.
	 * @param StlTgtVO stlTgtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteStlTgt(StlTgtVO stlTgtVO) throws DAOException {		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (stlTgtVO != null) {
				 Map<String, String> mapVO = stlTgtVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}			
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOStlTgtDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete JOO_STL_TGT");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 * Settlement Target 조회한다.
	 * 
	 * @param ProcSettlementVO procSettlementVO
	 * @return List<ProcSettlementVO>
	 * @throws DAOException
	 */
	public List<ProcSettlementVO> searchAddStlList(ProcSettlementVO procSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ProcSettlementVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (procSettlementVO != null) {
				 Map<String, String> mapVO = procSettlementVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOSearchAddStlRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 	
	
	/** 
	 * <pre>
	 *   JO Settlement Status Information
	 *      UID : FNS_JOO_0107
	 * </pre>
	 * 
	 * @param StlStsVO stlStsVO
	 * @return List<StlStsVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StlStsVO> searchJoSettlementStatusList(StlStsVO stlStsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StlStsVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (stlStsVO != null) {
				Map<String, String> mapVO = stlStsVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				if("slot".equals(stlStsVO.getGubun())){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOJoSettlementStatusRSQL(), param, velParam);				
				}else if("ous".equals(stlStsVO.getGubun())){
					if("E".equals(stlStsVO.getReDivrCd())){
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOJoSettlementStatusOusRSQL(), param, velParam);
					}else{
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOJoSettlementStatusOusRevRSQL(), param, velParam);						
					}
				}else{	
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOJoSettlementStatusOusDetailRSQL(), param, velParam);
				}
			}
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, StlStsVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	
	/** 
	 * <pre>
	 *   JO Settlement Status Information의 페이지 개수
	 *      UID : FNS_JOO_0107
	 * </pre>
	 * 
	 * @param StlStsVO stlStsVO
	 * @return StlStsVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public StlStsVO searchJoSettlementStatusListTotal(StlStsVO stlStsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StlStsVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (stlStsVO != null) {
				Map<String, String> mapVO = stlStsVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				if("slot".equals(stlStsVO.getGubun())){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOJoSettlementStatusTotalRSQL(), param, velParam);				
				}else if("ous".equals(stlStsVO.getGubun())){
					if("E".equals(stlStsVO.getReDivrCd())){
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOJoSettlementStatusOusTotalRSQL(), param, velParam);
					}else{
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOJoSettlementStatusOusRevTotalRSQL(), param, velParam);						
					}
				}else{	
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOJoSettlementStatusOusDetailTotalRSQL(), param, velParam);
				}
			}
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, StlStsVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}		
	
	/**
	 * Rev Yrmon를 조회한다.
	 * @param JoLoadingVO joLoadingVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchRevYrmon(JoLoadingVO joLoadingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JoLoadingVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String revYrmon = "";
		try {
			Map<String, String> mapVO = joLoadingVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAORevYrmonRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JoLoadingVO.class);
			
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()){
				revYrmon = ((JoLoadingVO)iterator.next()).getRevYrmon(); 
			}
			
			// 2016.07.20 REV_YRMON의 경우 JOO_SLT_LIST(S/H 정상대상)에 없는 경우 AR_MST_REV_VVD TABLE에서 직접 가져옮
			if(revYrmon == null || "".equals(revYrmon)){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAORevYrmonForARRSQL(),param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, JoLoadingVO.class);
				
				Iterator iterator2 = list.iterator();
				
				while (iterator2.hasNext()){
					revYrmon = ((JoLoadingVO)iterator2.next()).getRevYrmon(); 
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return revYrmon;
	}	
	
	/**
	 * Rev Yrmon Seq를 조회한다.
	 *  
	 * @param String revYrmon
	 * @return String
	 * @throws DAOException
	 */
	public String searchRevYrmonSeq(String revYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("revYrmon", revYrmon);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAORevYrmonSeqRSQL(), param, null);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("REV_YRMON_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	} 	
	
	/**
	 * Settlement정보를 한 건 삭제한다. (acct_yrmon, stl_vvd_seq, stl_seq)
	 * @param ProcSettlementVO procSettlementVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeSettlement(ProcSettlementVO procSettlementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = procSettlementVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	   /**
	    * Settlement 저장시에 중복되는 데이터가 있는지 Duplicate Check를 한다.
	    * (순수 Settlement만 ==> S/H, OUS, R/F, OTH)
	    * @param ProcSettlementVO procSettlementVO
	    * @return int
	    * @throws DAOException
	    */
	   public int searchSettlementDupChk(ProcSettlementVO procSettlementVO) throws DAOException {
			DBRowSet dbRowset = null;
			
			int iRtn = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(procSettlementVO != null){
					Map<String, String> mapVO = procSettlementVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierSettlementProcessDBDAOStlDupChkRSQL(), param, velParam);
				
				iRtn = dbRowset.getRowCount();
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return iRtn;
		}	
	   
		/**
		 * Settlement정보를 수정한다.
		 * @param ProcSettlementVO procSettlementVO
		 * @return int
		 * @throws DAOException
		 * @throws Exception
		 */
		public int modifySettlement(ProcSettlementVO procSettlementVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = procSettlementVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new CarrierSettlementProcessDBDAOJooSettlementVOUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}
		
		/**
		 * Settlement VVD Seq.를 조회한다.
		 *  
		 * @param String acctYrmon
		 * @return String
		 * @throws DAOException
		 */
		public String searchStlVvdSeq(String acctYrmon) throws DAOException {
			DBRowSet dbRowset = null;
			String rtnValue = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try {
				param.put("acct_yrmon", acctYrmon);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAOStlVvdSeqRSQL(), param, null);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("STL_VVD_SEQ");
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtnValue;
		} 	
		
		 /**
		 * Settlement Seq.를 조회한다.
		 *  
		 * @param String acctYrmon
		 * @param String stlVvdSeq
		 * @return String
		 * @throws DAOException
		 */
		public String searchStlSeq(String acctYrmon, String stlVvdSeq) throws DAOException {
			DBRowSet dbRowset = null;
			String rtnValue = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try {
				param.put("acct_yrmon", acctYrmon);
				param.put("stl_vvd_seq", stlVvdSeq);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAOStlSeqRSQL(), param, null);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("STL_SEQ");
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtnValue;
		} 			
		
		
		 /**
		 * JOO_SETTLEMENT에 data 한 건 입력한다.
		 * 
		 * @param ProcSettlementVO procSettlementVO
		 * @param String acctYrmon
		 * @param String stlVvdSeq
		 * @param String stlSeq
		 * @throws DAOException
		 * @throws Exception
		 */
		public void addSettlement(ProcSettlementVO procSettlementVO, String acctYrmon, String stlVvdSeq, String stlSeq) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				procSettlementVO.setAcctYrmon(acctYrmon);
				procSettlementVO.setStlVvdSeq(stlVvdSeq);
				procSettlementVO.setStlSeq(stlSeq);
				
				Map<String, String> mapVO = procSettlementVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOJooSettlementVOCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * 한건의 Target VVD를 생성한다.
		 * @param JooStlVvdVO jooStlVvdVO
		 * @throws DAOException
		 * @throws Exception
		 */
		public void addTargetVVD(JooStlVvdVO jooStlVvdVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = jooStlVvdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");

				int result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOJooStlVvdVOCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}		
		
		 /**
		 * JOO_STL_TGT테이블을 수정한다.
		 * 
		 * @param String acctYrmon
		 * @param String stlVvdSeq
		 * @param String stlSeq
		 * @param String updUsrId
		 * @param String revYrmon
		 * @param String revYrmonSeq
		 * @param String revSeq
		 * @return int
		 * @throws DAOException
		 * @throws Exception
		 */
		public int modifySettlemntTaget(String acctYrmon, String stlVvdSeq, String stlSeq, String updUsrId, String revYrmon, String revYrmonSeq, String revSeq) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();			
			int result = 0;
			try {
				param.put("acct_yrmon", acctYrmon);
				param.put("new_stl_vvd_seq", stlVvdSeq);
				param.put("new_stl_seq", stlSeq);
				param.put("upd_usr_id", updUsrId);				
				param.put("rev_yrmon", revYrmon);
				param.put("rev_yrmon_seq", revYrmonSeq);
				param.put("rev_seq", revSeq);
												
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new SettlementProcessDBDAOStlTgtAcctUSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}	

		 /**
		 * TRADE코드를 조회합니다.
		 * 
		 * @param JoSettlementConditionVO joSettlementConditionVO
		 * @return List<JoEstmConditionVO>
		 * @throws DAOException
		 */
		public List<JoEstmConditionVO> searchTradeCodeListStl(JoSettlementConditionVO joSettlementConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<JoEstmConditionVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (joSettlementConditionVO != null) {
					 Map<String, String> mapVO = joSettlementConditionVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOSltHirTradeStlRSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, JoEstmConditionVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}    
		
		/**
		 * RLANE코드를 조회합니다.
		 * @param JoSettlementConditionVO joSettlementConditionVO
		 * @return List<JoEstmConditionVO>
		 * @throws DAOException
		 */
		public List<JoEstmConditionVO> searchRlaneCodeListStl(JoSettlementConditionVO joSettlementConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<JoEstmConditionVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (joSettlementConditionVO != null) {
					 Map<String, String> mapVO = joSettlementConditionVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOSltHirRlaneStlRSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, JoEstmConditionVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	
		
		/**
		 * CARRIER코드를 조회합니다.
		 * @param JoSettlementConditionVO joSettlementConditionVO
		 * @return List<JoEstmConditionVO>
		 * @throws DAOException
		 */
		public List<JoEstmConditionVO> searchCarrierCodeListStl(JoSettlementConditionVO joSettlementConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<JoEstmConditionVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (joSettlementConditionVO != null) {
					 Map<String, String> mapVO = joSettlementConditionVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOSltHirCarrierStlRSQL(),	param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, JoEstmConditionVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	
		
		/** 
		 * <pre>
		 *   JO Settlement Status Information
		 *      UID : FNS_JOO_0107
		 * </pre>
		 * 
		 * @param String p_vsl_cd
		 * @param String p_skd_voy_no
		 * @param String p_skd_dir_cd 
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public void callProcedure(String p_vsl_cd, String p_skd_voy_no, String p_skd_dir_cd) throws DAOException {
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
			try {
				param.put("in_vsl_cd", p_vsl_cd);
				param.put("in_skd_voy_no", p_skd_voy_no);
				param.put("in_skd_dir_cd", p_skd_dir_cd);

				new SQLExecuter("").executeSP((ISQLTemplate)new SettlementProcessDBDAOexecuteProcedureRSQL(), param, velParam);

			} catch (SQLException se) {
				log.error(se.getMessage(), se); 
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/** 
		 * <pre>
		 *   JO Expense Loading Information
		 *      UID : FNS_JOO_0105
		 * </pre>
		 * 
		 * @param TdrLoadVO tdrLoadVO
		 * @return 
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public String callJELProcedure(TdrLoadVO tdrLoadVO) throws DAOException {
			String pErrorCode = "";
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			try {
				if(tdrLoadVO != null){
					/*
					Map<String, String> mapVO = tdrLoadVO .getColumnValues();				
					param.putAll(mapVO);
					*/
					param.put("pre_fr", tdrLoadVO.getPreFr());
					param.put("pre_to", tdrLoadVO.getPreTo());
					param.put("rlane_cd", tdrLoadVO.getRlaneCd());
					param.put("p_error_code", pErrorCode);
				}
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate)new SettlementProcessDBDAOexecuteJELProcedureRSQL(), param, null);
				if (rtnrslt != null){ 
					pErrorCode = (String) rtnrslt.get("p_error_code");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se); 
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return pErrorCode;
		}
		
		/** 
		 * <pre>
		 *   Movement Event Date Setting
		 *      UID : FNS_JOO_0109
		 * </pre>
		 * 
		 * @param MvntEvntDtVO mvntEvntDtVO
		 * @return 
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public String callMVMTProcedure(MvntEvntDtVO mvntEvntDtVO) throws DAOException {
			String pErrorCode = "";
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			try {
				if(mvntEvntDtVO != null){
					param.put("slane", mvntEvntDtVO.getSlane());
					param.put("p_error_code", pErrorCode);
				}
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate)new SettlementProcessDBDAOexecuteMVMTProcedureRSQL(), param, null);
				if (rtnrslt != null){ 
					pErrorCode = (String) rtnrslt.get("p_error_code");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se); 
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return pErrorCode;
		}
		
		/** 
		 * <pre>
		 *   Movement Event Date Setting
		 *      UID : FNS_JOO_0109
		 * </pre>
		 * 
		 * @param MvntEvntDtVO mvntEvntDtVO
		 * @return 
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public String callMVMTALLProcedure(MvntEvntDtVO mvntEvntDtVO) throws DAOException {
			String pErrorCode = "";
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			try {
				if(mvntEvntDtVO != null){
					param.put("p_error_code", pErrorCode);
				}
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate)new SettlementProcessDBDAOexecuteMVMTALLProcedureRSQL(), param, null);
				if (rtnrslt != null){ 
					pErrorCode = (String) rtnrslt.get("p_error_code");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se); 
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return pErrorCode;
		}
		
		/** 
		 * <pre>
		 *   JO Target Creation and Basic Slot Hire Settlement
		 *      UID : FNS_JOO_0104
		 * </pre>
		 * 
		 * @param JoEstmConditionVO estmConditionVO
		 * @return 
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public String callSLOTProcedure(JoEstmConditionVO estmConditionVO) throws DAOException {
			String pErrorCode = "";
			Map<String, Object> param = new HashMap<String, Object>();//parameter
			try {
				if(estmConditionVO != null){
					param.put("p_error_code", pErrorCode);
				}
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate)new SettlementProcessDBDAOexecuteSLOTALLProcedureRSQL(), param, null);
				if (rtnrslt != null){ 
					pErrorCode = (String) rtnrslt.get("p_error_code");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se); 
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return pErrorCode;
		}
		
		
		/**
		 * Jo Expense Report 리스트를 조회한다
		 * 
		 * @param TdrLoadVO tdrLoadVO
		 * @param String gubun
		 * @return List<JoLoadingVO>
		 * @throws DAOException
		 */
		public List<JoLoadingVO> searchExpRptList(TdrLoadVO tdrLoadVO, String gubun) throws DAOException {
			DBRowSet dbRowset = null;
			List<JoLoadingVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(tdrLoadVO != null){
					Map<String, String> mapVO = tdrLoadVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAOExpRptRSQL(), param, velParam);				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, JoExpRptVO .class);
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
		 * Settlement 에서 ROW ADD로 VVD 입력할 경우 9자리 입력하면 FIN. DIR LIST를 조회한다.
		 * @param ProcSettlementVO procSettlementVO
		 * @return List<ProcSettlementVO>
		 * @throws DAOException
		 */
		public List<ProcSettlementVO> searchRevDirList(ProcSettlementVO procSettlementVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<ProcSettlementVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(procSettlementVO != null){
					Map<String, String> mapVO = procSettlementVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAORevDirListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcSettlementVO .class);
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
		 * Acount Month를 조회하여 Target을 해제 할 수 있는지 조회한다.
		 *  
		 * @param String revYrmon
		 * @param String revYrmonSeq
		 * @param String revSeq
		 * @return String
		 * @throws DAOException
		 */
		public String searchEnblTgt(String revYrmon, String revYrmonSeq, String revSeq) throws DAOException {
			DBRowSet dbRowset = null;
			String rtnValue = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();			

			try {
				param.put("rev_yrmon", revYrmon);
				param.put("rev_yrmon_seq", revYrmonSeq);
				param.put("rev_seq", revSeq);
				velParam.put("rev_seq", revSeq);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAOEnblTgtRSQL(), param, velParam);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("ENBL_TGT");
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtnValue;
		}
		
		/** 
		 * <pre>
		 *   JO Settlement PIC
		 *      UID : FNS_JOO_0113
		 * </pre>
		 * 
		 * @param StlStsVO stlStsVO
		 * @return List<StlStsVO>
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<StlStsVO> searchJoSettlementPicList(StlStsVO stlStsVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<StlStsVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (stlStsVO != null) {
					Map<String, String> mapVO = stlStsVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
									
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOJoSettlementPicRSQL(), param, velParam);				
				}
				
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, StlStsVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se); 
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}		
		
		/** 
		 * <pre>
		 *   JO Settlement Status PIC의 페이지 개수
		 *      UID : FNS_JOO_0113
		 * </pre>
		 * 
		 * @param StlStsVO stlStsVO
		 * @return StlStsVO
		 * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public StlStsVO searchJoSettlementPicListTotal(StlStsVO stlStsVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<StlStsVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (stlStsVO != null) {
					Map<String, String> mapVO = stlStsVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
									
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOJoSettlementPicTotalRSQL(), param, velParam);				
				}				
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, StlStsVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se); 
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list.get(0);
		}	
		
		
		/** 
		 *   공동운항에서 PIC 조회
		 *    
		 * @return List<JooCodeInfoVO>
		 * @throws DAOException
		 */
		public List<JooCodeInfoVO> searchPicList() throws DAOException {
			DBRowSet dbRowset = null;
			List<JooCodeInfoVO> list = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {									
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAOPicRSQL(), param, velParam);								
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se); 
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}			
		
		
	    /**
	     * Pic 정보 Dup Check 조회 합니다
	     * @param  StlStsVO stlStsVO
	     * @return String
	     * @throws DAOException
	     */
	    public String searchPicDupCheck(StlStsVO stlStsVO) throws DAOException {
	        DBRowSet dbRowset = null;
	        String rtnValue = "";        
	        //query parameter;
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter;
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{
	            if(stlStsVO != null){
	                Map<String, String> mapVO = stlStsVO.getColumnValues();
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SettlementProcessDBDAOPicDupChkRSQL(), param, velParam);
				if (dbRowset.next()) {
					rtnValue = dbRowset.getString(1);
				} else{
					rtnValue = "";
				}
	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	        return rtnValue;
	    }		
	    
	    /**
	     * Pic 정보를 입력 합니다.
	     *  
	     * @param  List<StlStsVO>  stlStsVOs
	     * @throws DAOException 
	     */
	    public void addPic(List<StlStsVO> stlStsVOs) throws DAOException  {
	        try {
	            SQLExecuter sqlExe = new SQLExecuter("");
	            int insCnt[] = null;
	            if(stlStsVOs.size() > 0){
	                insCnt = sqlExe.executeBatch((ISQLTemplate)new SettlementProcessDBDAOPicCSQL(), stlStsVOs, null);
	                for(int i = 0; i < insCnt.length; i++){
	                    if(insCnt[i]== Statement.EXECUTE_FAILED)
	                        throw new DAOException("Fail to Insert No"+ i + " SQL");
	                }
	            }	 
	        } catch (SQLException se) {
		        log.error(se.getMessage(),se);
		        throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	    }	    
	    
		/**
		 * Pic 정보를 수정 합니다.
		 * 
		 * @param List<StlStsVO>  stlStsVOs
		 * @throws DAOException
		 */
		public void modifyPic(List<StlStsVO> stlStsVOs) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				if (stlStsVOs.size() > 0) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new SettlementProcessDBDAOPicUSQL(), stlStsVOs, null);
					for (int i = 0; i < updCnt.length; i++) {
						if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update No" + i + " SQL");
					}
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
	     * Pic 정보를 삭제 합니다.
	     * 
	     * @param List<StlStsVO> stlStsVOs
	     * @exception DAOException
	     */
	    public void removePic(List<StlStsVO> stlStsVOs) throws DAOException, Exception {
	        try {
	            SQLExecuter sqlExe = new SQLExecuter("");
	            int delCnt[] = null;
	            if(stlStsVOs.size() > 0) {
	                delCnt = sqlExe.executeBatch((ISQLTemplate) new SettlementProcessDBDAOPicDSQL(), stlStsVOs, null);
	                for(int i = 0; i < delCnt.length; i++) {
	                    if(delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No" + i + " SQL");
	                }
	            }
	        } catch(SQLException se) {
	            log.error(se.getMessage(), se);
	            throw new DAOException(new ErrorHandler(se).getMessage(),se);
	        } catch(Exception ex) {
	            log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
	        }
	    }
	    
		/**
		 * TDR Inquiry by VVD에서 사용하는 Carrier Code 조회
		 * @param TdrLoadVO tdrLoadVO
		 * @return List<JooCodeInfoVO>
		 * @throws DAOException
		 */
		public List<JooCodeInfoVO> searchJoRevCarrierCodeString(TdrLoadVO tdrLoadVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<JooCodeInfoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if (tdrLoadVO != null) {
					 Map<String, String> mapVO = tdrLoadVO.getColumnValues();

					 param.putAll(mapVO);
					 velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SettlementProcessDBDAORevCarrierByPeriodAndLaneRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	    
	    
}