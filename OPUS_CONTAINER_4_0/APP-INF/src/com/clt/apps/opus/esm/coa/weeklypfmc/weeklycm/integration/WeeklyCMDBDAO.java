/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName 		: WeeklyPFMCDBDAO.java
 *@FileTitle 		: Weekly PFMC DBDAO
 *Open Issues 		:
 *Change history 	: EMU화면(115) LCC레벨 추가
 *@LastModifyDate	: 2007-10-10
 *@LastModifier 	: Ari
 *@LastVersion 		: 1.0
 * 2006-10-23 Park Eun Ju
 * 1.0 최초 생성

 * =========================================================
 * History
 =========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.ProcedureParamVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.basic.WeeklyCMBCImpl;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.BsaProcedureParamVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.IsLaneRgstVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDCheckListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDChkWithARListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVslRgstCountVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVDListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchYrWkDuVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CoaMonVvdVO;

/**
 * COA에 대한 DB 처리를 담당<br> - COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Park Eun Ju
 * @see WeeklyCMBCImpl 참조
 * @since J2EE 1.5
 */
public class WeeklyCMDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 134912223077318811L;

	/**
	 * 주차별 대상 항차/운항리수를 구한다.
	 *
	 * @param ProcedureParamVO procedureParamVO
	 * @return ProcedureParamVO
	 * @throws DAOException
	 */
    public ProcedureParamVO createNtwkCostALL(ProcedureParamVO procedureParamVO) throws DAOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
    	ProcedureParamVO result = new ProcedureParamVO();
    	
        try{
        	resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new WeeklyCMDBDAOCreateNtwkCostALLCSQL(), procedureParamVO.getColumnValues(), null);
        	
        	if ( resultMap != null) {
	        	result.setOutErrCd((String) resultMap.get("out_err_cd"));
	        	result.setOutErrMsg((String) resultMap.get("out_err_msg"));
        	}
        	
        }catch (SQLException se) {
        	log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result;
    }

    /**
	 * COA_MON_VVD 목록을 가져온다.<br>
	 * ESM_COA_0142 화면 조회
	 * @param SearchVVDCheckListVO searchVVDCheckListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchVVDCheckListVO>
	 * @throws DAOException
	 */
	public List<SearchVVDCheckListVO> searchVVDCheckList(SearchVVDCheckListVO searchVVDCheckListVO
			                                            ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVVDCheckListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchVVDCheckListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchVVDCheckListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVVDCheckListVO .class);
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
	 * COA_MON_VVD 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * ESM_COA_0142 화면 수정
	 * 
	 * 변경내역 ------------------------------------------------------------------------------
	 * - Trunk IPC와 Ocean 정보를 달리 가면서  Ocean 수정시 역내구간을 같이 수정해주는것을 해지
	 * - Ocean의 내용 변경시 역내구간 중 아주(IAS) 즉 Trunk IPC 를 제외한 구주역내구간은 
	 *   Ocean과 동일하게 가도록 변경[R200710194124][2007-10-30]
	 * ---------------------------------------------------------------------------------------
	 * 
	 * @param List<CoaMonVvdVO> coaMonVvdVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymodifyVVDCheckS(List<CoaMonVvdVO> coaMonVvdVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaMonVvdVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOCoaMonVvdVOChkUSQL(), coaMonVvdVO,null);
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
	 * COA_MON_VVD 목록을 가져온다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchWeeklyTargetVVDListVO>
	 * @throws DAOException
	 */
    public List<SearchWeeklyTargetVVDListVO> searchWeeklyTargetVVDList(SearchConditionVO searchConditionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchWeeklyTargetVVDListVO> list = null;
        //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(searchConditionVO != null){
            	param.putAll(searchConditionVO.getColumnValues());
            	velParam.putAll(searchConditionVO.getColumnValues());
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchWeeklyTargetVVDListRSQL(), param, velParam);
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchWeeklyTargetVVDListVO.class);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	
    
    /**
	 * COA_VSL_RGST중 stnd_ldb_capa가 0인것의 갯수를 조회한다.<br>
	 * 
	 * @param SearchConditionVO vo
	 * @return List<SearchVslRgstCountVO>
	 * @throws DAOException
	 */
    public List<SearchVslRgstCountVO> searchVslRgstCount(SearchConditionVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchVslRgstCountVO> list = null;
        
        //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(vo == null) return null;
            param.putAll(vo.getColumnValues());
            velParam.putAll(vo.getColumnValues());
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchVslRgstCountRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVslRgstCountVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

	/**
	 * COA_MON_VVD TABLE에 해당 VVD의 BKG실적을 UPDATE 한다.<br>
	 *
	 * @param WeeklyCMCommonVO vo
	 * @throws DAOException
	 */
    public void modifyBkgQtyToMonVVD(WeeklyCMCommonVO vo) throws DAOException {
        int updCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiUpdateList().size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOModifyBkgQtyToMonVVDUSQL(), vo.getMultiUpdateList(), null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/**
	 * COA_LANE_RGST에 유효한 정보인지를 확인한다.<br>
	 *
	 * @param WeeklyCMCommonVO vo
	 * @return List<IsLaneRgstVO>
	 * @throws DAOException
	 */
    public List<IsLaneRgstVO> isLaneRgst(WeeklyCMCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<IsLaneRgstVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOIsLaneRgstRSQL(), null, vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, IsLaneRgstVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

	/**
	 * COA_MON_VVD 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 변경내역 ------------------------------------------------------------------------------
	 * - Trunk IPC와 Ocean 정보를 달리 가면서  Ocean 수정시 역내구간을 같이 수정해주는것을 해지
	 * - Ocean의 내용 변경시 역내구간 중 아주(IAS) 즉 Trunk IPC 를 제외한 구주역내구간은 
	 *   Ocean과 동일하게 가도록 변경[R200710194124][2007-10-30]
	 * ---------------------------------------------------------------------------------------
	 * @param WeeklyCMCommonVO vo
	 * @return boolean(Insert 유무)
	 * @throws DAOException
	 */
    public boolean modifyWeeklyTargetVVD(WeeklyCMCommonVO vo) throws DAOException {
        int insCnt[]  = null;
        int updCnt[]  = null;
        int updCnt2[] = null;
        int updCnt3[] = null;

		boolean isInsert  = false;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMultiWeeklyTargetVVDCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	isInsert = false;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                    else{
                    	isInsert = true;
                    }
                }
            }

            if(vo.getMultiUpdateList() != null && vo.getMultiUpdateList().size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMultiWeeklyTargetVVD1USQL(), vo.getMultiUpdateList(), null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
            
            if(vo.getMultiUpdateList2() != null && vo.getMultiUpdateList2().size() > 0){
                updCnt2 = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMultiWeeklyTargetVVD2USQL(), vo.getMultiUpdateList2(), null);
                for(int i = 0; i < updCnt2.length; i++){
                    if(updCnt2[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
            
            if(vo.getMultiUpdateList3() != null && vo.getMultiUpdateList3().size() > 0){
                updCnt3 = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOMultiWeeklyTargetVVD3USQL(), vo.getMultiUpdateList3(), null);
                for(int i = 0; i < updCnt3.length; i++){
                    if(updCnt3[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }            
            
            return isInsert;

        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	

	/* -------------------------------------------------------------------------------------------------- */

	
	/**
	 * VVD Check With AR List 조회한다.<br>
	 * ESM_COA_0112 조회
	 * @param SearchVVDChkWithARListVO searchVVDChkWithARListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchVVDChkWithARListVO>
	 * @throws DAOException
	 */
	public List<SearchVVDChkWithARListVO> searchVVDChkWithARList (SearchVVDChkWithARListVO searchVVDChkWithARListVO
			                                                     ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVVDChkWithARListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchVVDChkWithARListVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchVVDChkWithARListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVVDChkWithARListVO .class);
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
	 * VVD Check With AR List 추가 <br>
	 * ESM_COA_0112 삽입
	 * @param List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addVVDChkWithARList(List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchVVDChkWithARListVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOCoaMonVvdVOCSQL(), searchVVDChkWithARListVO ,null);
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
	 * VVD Check With AR List 수정 1<br>
	 * ESM_COA_0112 수정 1
	 * @param List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyVVDChkWithARList(List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchVVDChkWithARListVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOCoaMonVvdVOUSQL(), searchVVDChkWithARListVO,null);
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
	 * VVD Check With AR List 수정 2<br>
	 * ESM_COA_0112 수정 2
	 * @param List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyVVDChkWithARList2(List<SearchVVDChkWithARListVO> searchVVDChkWithARListVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchVVDChkWithARListVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new WeeklyCMDBDAOCoaMonVvdVO2USQL(), searchVVDChkWithARListVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}
	
	/**
	 * 검색조건의 년 주차 기간을 조회한다. 
	 * 
	 * @param ProcedureParamVO durationParamVO
	 * @return SearchYrWkDuVO
	 * @throws DAOException
	 */
	public SearchYrWkDuVO searchYrWkDu(ProcedureParamVO durationParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		SearchYrWkDuVO searchYrWkDuVO = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(durationParamVO != null){
				param.putAll(durationParamVO.getColumnValues());
				velParam.putAll(durationParamVO.getColumnValues());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WeeklyCMDBDAOSearchYrWkDuRSQL(), param, velParam);
				searchYrWkDuVO = (SearchYrWkDuVO) (RowSetUtil.rowSetToVOs(dbRowset, SearchYrWkDuVO.class)).get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err " + se.toString(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err " + ex.toString(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchYrWkDuVO;
	}
	
	/**
	 * Daily Batch를 돌린다.
	 * 
	 * @param BsaProcedureParamVO dailyBatchConditionVO
	 * @return WeeklyCMCommonVO
	 * @throws DAOException
	 */
	public BsaProcedureParamVO bsaDailyBatch(BsaProcedureParamVO dailyBatchConditionVO) throws DAOException {
		Map<String, Object> result = null;
		
		try{
			if( dailyBatchConditionVO != null ){
				result = new HashMap<String, Object>();
				result.putAll(dailyBatchConditionVO.getColumnValues());
				SQLExecuter sqlExe = new SQLExecuter("");
				
				result = sqlExe.executeSP((ISQLTemplate)new WeeklyCMDBDAODailyBatchCSQL(), dailyBatchConditionVO.getColumnValues(), null);
				dailyBatchConditionVO.setPErrCd( (String)result.get("p_error_code") );
				dailyBatchConditionVO.setPErrMsg((String)result.get("p_error_msg") );
			}

		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dailyBatchConditionVO;
	}
	
	 
	 
	
	/**
	 * VVD Status 의 데이타 모델에 해당되는 값을 불러온 후 삭제한다.<br>
	 * 
	 * @param SearchVVDChkWithARListVO searchVVDChkWithARListVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeMonthVVDIFStatus(SearchVVDChkWithARListVO searchVVDChkWithARListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchVVDChkWithARListVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new WeeklyCMDBDAOCoaMonVvdIfVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	 	
	/**
	 * VVD Status 의 데이타 모델에 해당되는 값을 불러온 후 추가,수정한다.<br>
	 * 
	 * @param SearchVVDChkWithARListVO searchVVDChkWithARListVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyMonthVVDIFStatus(SearchVVDChkWithARListVO searchVVDChkWithARListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchVVDChkWithARListVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new WeeklyCMDBDAOCoaMonVvdIfVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}
