/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OPMasterDBDAO.java
*@FileTitle : 항로 생성/조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-12
*@LastModifier : Park Eun Ju
*@LastVersion : 1.0
* 2006-10-12 Park Eun Ju
* 1.0 최초 생성
* History
* 2009.10.08 박은주 Alps 전환작업 진행  ESM_MAS_0123 searchVslInfoList
* 2009.09.30 김기대 0036 화면 New FrameWork 적용
* 2009.09.30 김기대 0037 화면 New FrameWork 적용
* 2009.09.30 김기대 0038 화면 New FrameWork 적용 ( modifyVSLSubTrade - ALPS 변환 후 저장 038번 화면 저장로직 제거)
* 2009.09.30 김기대 0145 화면 New FrameWork 적용
* 2009.09.30 김기대 0146 화면 New FrameWork 적용 
* 2010.01.29 이행지 0037, 0146화면에 대한 로직 수정, 불필요한 메소드 삭제
*                  addVSLSubTrade (MAS_VSL_SUB_TRD -> MDM_SUB_TRD 대체되면서 삭제)
* 2011.08.16 최성민 [CHM-201112855-01] [MAS]Create VSL table Operator 정보 표시
* 2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.apps.alps.esm.mas.common.vo.CommonMasRsVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.basic.OPMasterBCImpl;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.MultiHistVSLInfoVslSeqVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.SearchHistoryLaneListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.SearchRgstLaneListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.SearchVslInfoListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MasLaneRgstVO;
import com.hanjin.syscommon.common.table.MasLaneTpHisVO;
import com.hanjin.syscommon.common.table.MasVslRgstVO;
import com.hanjin.syscommon.common.table.MasVslSubTrdCapaVO;

/**
 * eNIS-MAS에 대한 DB 처리를 담당<br>
 * - eNIS-MAS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Eun Ju
 * @see OPMasterBCImpl 참조
 * @since J2EE 1.4
 */
public class OPMasterDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = -585724994118837930L;

	/**
     * MAS_LANE_RGST 목록을 가져온다.<br>
     * UI - ESM_MAS_00
     * 
     * @param  SearchConditionVO searchVO
     * @return List<SearchRgstLaneListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchRgstLaneListVO> searchRgstLaneList(SearchConditionVO searchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchRgstLaneListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if(searchVO != null){
        		String fChkdel = Utils.iif((searchVO.getFChkdel() == null || searchVO.getFChkdel().trim().equals("")), "N", searchVO.getFChkdel());
        		param.put("delt_flg",	fChkdel);
        		param.put("trd_cd",		searchVO.getFCbotrade());
        		param.put("slan_cd",	searchVO.getFCboslane());
        		
        		velParam.put("trd_cd",	searchVO.getFCbotrade());
        		velParam.put("slan_cd",	searchVO.getFCboslane());

                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchRgstLaneListRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRgstLaneListVO.class);
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
     * @param  SearchConditionVO searchVO
     * @return List<SearchRgstLaneListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<SearchRgstLaneListVO> searchDataForDateCheckOfLaneHistory(SearchConditionVO searchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchRgstLaneListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if(searchVO != null){
        		param.put("f_trd_cd",		searchVO.getFTrdCd());
        		param.put("f_rlane_cd",		searchVO.getFRlaneCd());
        		param.put("f_dir_cd",		searchVO.getFDirCd());
        		param.put("f_ioc_cd",		searchVO.getFIocCd());
        		param.put("date_check_flag", "Y");
        		
        		velParam.put("f_trd_cd",		searchVO.getFTrdCd());
        		velParam.put("f_rlane_cd",		searchVO.getFRlaneCd());
        		velParam.put("f_dir_cd",		searchVO.getFDirCd());
        		velParam.put("f_ioc_cd",		searchVO.getFIocCd());
        		velParam.put("date_check_flag",	"Y");

                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchHistoryLaneListRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRgstLaneListVO.class);
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
	 * [Create Lane Table] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0036
	 * 
	 * @param List<MasLaneRgstVO> insertRgstLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] addRgstLane(List<MasLaneRgstVO> insertRgstLaneVOList) throws DAOException {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertRgstLaneVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiRgstLaneCSQL(), insertRgstLaneVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	result++;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

    
    /**
	 * [Create Lane Table] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0036
	 * 
	 * @param List<MasLaneRgstVO> updateRgstLaneVOList
	 * @throws DAOException
	 */
	public void modifyRgstLane(List<MasLaneRgstVO> updateRgstLaneVOList) throws DAOException {
		int insCnt = 0;
		int result = 0;
		DBRowSet dbRowset1 = null;
		DBRowSet dbRowset2 = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateRgstLaneVOList.size() > 0){
                
                int size = updateRgstLaneVOList.size();
                for(int i = 0; i<size; i++){
                	
                	MasLaneRgstVO vo = updateRgstLaneVOList.get(i);
                	if(vo.getAutoFlg().equals("Y")){
	                	//query parameter
	            		Map<String, Object> param = new HashMap<String, Object>();
	            		//velocity parameter
	            		Map<String, Object> velParam = new HashMap<String, Object>();
	            		Map<String, String> mapVO = vo.getColumnValues();
						param.putAll(mapVO);				
						velParam.putAll(mapVO); 
						
						//seq이 있나 없나 체크 -> 없으면 seq 1 데이터를 생성해줘야 함
						dbRowset1 =  new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneSeeIfFirstSequenceExistsRSQL(), param, velParam);
						
						if(dbRowset1 != null){
							if(dbRowset1.next() == false){ // seq1이 없으면 아래 seq1 생성 쿼리 탐
								sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneCreateFirstSequenceCSQL(), param, velParam);
							}
						}
						
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiRgstLaneUSQL(), param, velParam);
						
	                    if(insCnt == Statement.EXECUTE_FAILED){
	                    	result++;
	                        throw new DAOException("Fail to insert No"+ i + " SQL");
	                    }
						
						//update인지 insert인치 체크
						dbRowset2 =  new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneSeeIfUpdateOrInsertRSQL(), param, velParam);	
						
						if(dbRowset2 != null){
							if(dbRowset2.next() != false){
								velParam.put("update_flg", "Y");
							}
						}
						//이전 SEQ를 가진 데이터의 TO 데이터를 SYSDATE - 1로 변경
						sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneChangeDateOfFormerSequenceUSQL(), param, velParam);
						
						sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneCSQL(), param, velParam);
						
					}else{
						//query parameter
	            		Map<String, Object> param = new HashMap<String, Object>();
	            		//velocity parameter
	            		Map<String, Object> velParam = new HashMap<String, Object>();
	            		Map<String, String> mapVO = vo.getColumnValues();
						param.putAll(mapVO);				
						velParam.putAll(mapVO);
						
						insCnt = sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiRgstLaneUSQL(), param, velParam);
						
	                    if(insCnt == Statement.EXECUTE_FAILED){
	                    	result++;
	                        throw new DAOException("Fail to insert No"+ i + " SQL");
	                    }
					}
                }
                
//                for(int i = 0; i < insCnt.length; i++){
//                    if(insCnt[i]== Statement.EXECUTE_FAILED){
//                    	result++;
//                        throw new DAOException("Fail to insert No"+ i + " SQL");
//                    }
//                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

    
    /**
	 * [Create Lane Table] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0036
	 * 
	 * @param List<MasLaneRgstVO> deleteRgstLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] deleteRgstLane(List<MasLaneRgstVO> deleteRgstLaneVOList) throws DAOException {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteRgstLaneVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiRgstLaneDSQL(), deleteRgstLaneVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	result++;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	} 
    
    /**
     * MAS_VSL_RGST 목록을 가져온다.<br>
     * ESM_MAS_0037화면에 대한 조회 이벤트 처리<br>
     * 명칭변경(2009.09.30) : searchVSLInfoList ---> searchVslRgstList
     *  
     * @param  SearchConditionVO searchVO
     * @param  CommonMasRsVO commonMasRsVO
     * @return CommonMasRsVO
     * @throws DAOException
     */
    public CommonMasRsVO searchVslRgstList(SearchConditionVO searchVO, CommonMasRsVO commonMasRsVO) throws DAOException {
        DBRowSet dbRowset = null;
        CommonMasRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<String> headerList = null;
		String fChkdel = null;
        try{
            if( searchVO != null ){
            	headerList = Utils.seperationParameter(commonMasRsVO.getHeader(),"|");
            	fChkdel = Utils.iif(searchVO.getFChkdel() == null||searchVO.getFChkdel().trim().equals(""), "N", searchVO.getFChkdel());
            	
            	param.put("f_chkdel",		fChkdel);
            	param.put("f_vsl_cd",		searchVO.getFVslCd());
            	param.put("f_ofc_cd",		searchVO.getFOfcCd());
            	velParam.put("keyList", 	headerList);
            	velParam.put("f_vsl_cd",	searchVO.getFVslCd());
            	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchVslRgstListRSQL(), param, velParam);
	            retVO = new CommonMasRsVO();
	            retVO.setDbRowset(dbRowset);
	            retVO.setHeader(commonMasRsVO.getHeader());
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
        return retVO;
    }

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return List<SearchVslInfoListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchVslInfoListVO> searchVslInfoList(SearchConditionVO searchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchVslInfoListVO> list = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if ( searchVO != null ){
        		param.put("f_vsl_cd", searchVO.getFVslCd());
        		param.put("f_crr_cd", searchVO.getFCrrCd());

        		velParam.put("f_vsl_cd", searchVO.getFVslCd());
        		velParam.put("f_crr_cd", searchVO.getFCrrCd());
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchVslInfoListRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVslInfoListVO.class);        		
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
	 * OPMaster의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return List<SearchHistoryLaneListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<SearchHistoryLaneListVO> searchHistoryLaneList(SearchConditionVO searchVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchHistoryLaneListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if ( searchVO != null ){
        		param.put("f_trd_cd",	searchVO.getFHTrdCd());
        		param.put("f_rlane_cd",	searchVO.getFHRlaneCd());
        		param.put("f_dir_cd",	searchVO.getFHDirCd());
        		param.put("f_ioc_cd",	searchVO.getFHIocCd());
        		
        		velParam.put("date_check_flag",	"");
        		
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchHistoryLaneListRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchHistoryLaneListVO.class);        		
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
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0037
	 * 
	 * @param List<MasLaneTpHisVO> insertHistLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] addHistoryLane(List<MasLaneTpHisVO> insertHistLaneVOList) throws DAOException {
		int insCnt[] = null;
		int result = 0;
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertHistLaneVOList.size() > 0){
				velParam.put("date_check_flag",	"");
				
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneCSQL(), insertHistLaneVOList, velParam);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	result++;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0037
	 * 
	 * @param List<MasLaneTpHisVO> modifyHistLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] modifyHistoryLane(List<MasLaneTpHisVO> modifyHistLaneVOList) throws DAOException {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(modifyHistLaneVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneUSQL(), modifyHistLaneVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	result++;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                }

                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneTpHisFlgUSQL(), modifyHistLaneVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	result++;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0037
	 * 
	 * @param List<MasLaneTpHisVO> deleteHistLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] deleteHistoryLane(List<MasLaneTpHisVO> deleteHistLaneVOList) throws DAOException {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteHistLaneVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneDSQL(), deleteHistLaneVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	result++;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

    /**
     * MAS_VSL_RGST 목록을 가져온다.<br>
     * 
     * @param  SearchConditionVO searchVO
     * @param  CommonMasRsVO commonMasRsVO
     * @return CommonMasRsVO
     * @throws DAOException
     */
    public CommonMasRsVO searchHistVSLInfoList(SearchConditionVO searchVO, CommonMasRsVO commonMasRsVO) throws DAOException {
        DBRowSet dbRowset = null;
        CommonMasRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<String> headerList = null;
		
        try{
            if( searchVO != null ) {
            	headerList = Utils.seperationParameter(commonMasRsVO.getHeader(),"|"); 
            	param.put("f_vsl_cd",	searchVO.getFVslCd());
            	param.put("date_check_flag", "");
            	velParam.put("keyList", headerList);
            	velParam.put("date_check_flag", "");
            	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchHistVSLInfoListRSQL(), param, velParam);
	            retVO = new CommonMasRsVO();
	            retVO.setDbRowset(dbRowset);
	            retVO.setHeader(commonMasRsVO.getHeader());
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
        return retVO;
    }
    
    /**
     * MAS_VSL_RGST 목록을 가져온다.<br>
     * 
     * @param  SearchConditionVO searchVO
     * @param  CommonMasRsVO commonMasRsVO
     * @return CommonMasRsVO
     * @throws DAOException
     */
    public CommonMasRsVO searchDataForDateCheckOfVesselHistory(SearchConditionVO searchVO, CommonMasRsVO commonMasRsVO) throws DAOException {
        DBRowSet dbRowset = null;
        CommonMasRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try{
            if( searchVO != null ) {
            	param.put("f_vsl_cd",	searchVO.getFVslCd());
            	param.put("date_check_flag", "Y");
            	velParam.put("f_vsl_cd",	searchVO.getFVslCd());
            	velParam.put("date_check_flag", "Y");
            	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchHistVSLInfoListRSQL(), param, velParam);
	            retVO = new CommonMasRsVO();
	            retVO.setDbRowset(dbRowset);
	            retVO.setHeader(commonMasRsVO.getHeader());
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
        
        log.debug("\n retVOretVOretVO "+retVO);
        
        return retVO;
    }
    
    /**
     * MAS_VSL_RGST vessel sequence number 조회.(조회)<br>
	 * UI - ESM_MAS_0037, ESM_MAS_0146
     * 
     * @param  String vsl_cd
     * @return List<MultiHistVSLInfoVslSeqVO>
     * @throws DAOException
     */    
    @SuppressWarnings("unchecked")
	public List<MultiHistVSLInfoVslSeqVO> maxVslSeq(String vsl_cd) throws DAOException {
        DBRowSet dbRowset = null;
        List<MultiHistVSLInfoVslSeqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        try{
            if(vsl_cd != null){
            	param.put("vsl_cd", vsl_cd);
            	
            	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOMultiHistVSLInfoVslSeqRSQL(), param, null);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, MultiHistVSLInfoVslSeqVO.class);
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
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0037
	 * 
	 * @param List<MasVslRgstVO> insertMstVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] addVslRgst(List<MasVslRgstVO> insertMstVOList) throws DAOException {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertMstVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiVslRgstCSQL(), insertMstVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	result++;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0037
	 * 
	 * @param List<MasVslRgstVO> updateMstVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyVslRgst(List<MasVslRgstVO> updateMstVOList) throws DAOException,Exception {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateMstVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiVslRgstUSQL(), updateMstVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	result++;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                }
                // Return Date에 대한 정보 Update.. VSL_SEQ에 관계없이 VSL_CODE에 해당하는 모든 Data를 수정하기 위해서 
                // 따로 호출해서 사용.
                if ( result == 0 ){
                    insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOVslRgstRetnDateUSQL(), updateMstVOList, null);
                    for(int i = 0; i < insCnt.length; i++){
                        if(insCnt[i]== Statement.EXECUTE_FAILED){
                        	result++;
                            throw new DAOException("Fail to insert No"+ i + " SQL");
                        }
                    }
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0037
	 * 
	 * @param List<MasVslRgstVO> deleteMstVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyVslRgstDeltFlg(List<MasVslRgstVO> deleteMstVOList) throws DAOException,Exception {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteMstVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOVslRgstDeltFlgUSQL(), deleteMstVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	result++;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	

    
    /**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0146
	 * 
	 * @param List<MasVslSubTrdCapaVO> deleteDetailVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteVSLSubTRDCapa(List<MasVslSubTrdCapaVO> deleteDetailVOList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteDetailVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiVSLSubTRDCapaDSQL(), deleteDetailVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
    
    /**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0146
	 * 
	 * @param List<MasVslRgstVO> insertMstVOList
	 * @param List<MasVslSubTrdCapaVO> updateDetailVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addHistVslRgst(List<MasVslRgstVO> insertMstVOList, List<MasVslSubTrdCapaVO> updateDetailVOList) throws DAOException,Exception {
		int insCnt1[] = null;
		int insCnt2[] = null;
		int result1 = 0;
		int result2 = 0;
		DBRowSet dbRowset1 = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int size1 = insertMstVOList.size();
			int size2 = updateDetailVOList.size();
			insCnt1 = new int[size1];
			insCnt2 = new int[size2];
			for(int i = 0; i<size1; i++){
				MasVslRgstVO vo1 = insertMstVOList.get(i);
				//query parameter
        		Map<String, Object> param1 = new HashMap<String, Object>();
        		//velocity parameter
        		Map<String, Object> velParam1 = new HashMap<String, Object>();
        		Map<String, String> mapVO1 = vo1.getColumnValues();
				param1.putAll(mapVO1);			
				velParam1.putAll(mapVO1); 
				String updateFlag = ""; // velParam2에 넣을 때 구분하려고 생성
				if(vo1.getAutoFlg().equals("Y")){
					dbRowset1 =  new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOMultiHistVSLInfoSeeIfInsertOrUpdateRSQL(), param1, velParam1); // 업데이트인지 아닌지 체크하는 쿼리
					if(dbRowset1 != null){ 
						if(dbRowset1.next() != false){ // 업데이트면
							param1.put("update_flg", "Y");
							velParam1.put("update_flg", "Y");
							updateFlag = "Y";
						}
					}
				}
				//이전 SEQ를 가진 데이터의 TO 데이터를 SYSDATE - 1로 변경
				sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiHistVSLInfoChangeDateOfFormerSequenceUSQL(), param1, velParam1);
				insCnt1[i] = sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiHistVSLInfoCSQL(), param1, velParam1);
				for(int j = 0; j<size2; j++){
					MasVslSubTrdCapaVO vo2 = updateDetailVOList.get(j);
					Map<String, Object> param2 = new HashMap<String, Object>();
					Map<String, Object> velParam2 = new HashMap<String, Object>();
					Map<String, String> mapVO2 = vo2.getColumnValues();
					velParam2.putAll(mapVO2); 
					param2.putAll(mapVO2);
					if(updateFlag.equals("Y")){ // 업데이트면
						param2.put("update_flg", "Y");
						velParam2.put("update_flg", "Y");
					}
					insCnt2[j] = sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOVSLSubTRDCapaCSQL(), param2, velParam2);
				}
				for(int j = 0; j < insCnt2.length; j++){
		              if(insCnt2[j]== Statement.EXECUTE_FAILED){
		              	result2++;
		                  throw new DAOException("Fail to insert No"+ j + " SQL");
		              }
				}
			}
			
				for(int i = 0; i < insCnt1.length; i++){
	              if(insCnt1[i]== Statement.EXECUTE_FAILED){
	              	result1++;
	                  throw new DAOException("Fail to insert No"+ i + " SQL");
	              }
				}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt1;
	}
	
//	/**
//	 * [Vessel History] 정보를 [삽입] 합니다.<br>
//	 * UI - ESM_MAS_0146
//	 * 
//	 * @param List<MasVslRgstVO> insertMstVOList
//	 * @return int[]
//	 * @throws DAOException
//	 * @throws Exception
//	 */
//	public int[] searchHistVslRgstDecideUpdateOrInsert(List<MasVslRgstVO> insertMstVOList) throws DAOException,Exception {
//		int insCnt[] = null;
//		int result = 0;
//		DBRowSet dbRowset1 = null;
//		
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int size = insertMstVOList.size();
//			insCnt = new int[size];
//			for(int i = 0; i<size; i++){
//				MasVslRgstVO vo = insertMstVOList.get(i);
//				//query parameter
//        		Map<String, Object> param = new HashMap<String, Object>();
//        		//velocity parameter
//        		Map<String, Object> velParam = new HashMap<String, Object>();
//        		Map<String, String> mapVO = vo.getColumnValues();
//				param.putAll(mapVO);				
//				velParam.putAll(mapVO); 
//				if(vo.getAutoFlg().equals("Y")){
//					dbRowset1 =  new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOMultiHistVSLInfoSeeIfInsertOrUpdateRSQL(), param, velParam); // 업데이트인지 아닌지 체크하는 쿼리
//					if(dbRowset1 != null){ 
//						if(dbRowset1.next() != false){ // 업데이트면
//							velParam.put("update_flg", "Y");
//						}
//					}else{ //insert면 이전 seq 데이터 to date 변경해야함
//						
//					}
//				}
//				insCnt[i] = sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiHistVSLInfoCSQL(), param, velParam);
//			}
//			
//				for(int i = 0; i < insCnt.length; i++){
//	              if(insCnt[i]== Statement.EXECUTE_FAILED){
//	              	result++;
//	                  throw new DAOException("Fail to insert No"+ i + " SQL");
//	              }
//				}
//		}catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return insCnt;
//	}
	
	/**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0146
	 * 
	 * @param List<MasVslRgstVO> updateMstVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyHistVslRgst(List<MasVslRgstVO> updateMstVOList) throws DAOException,Exception {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateMstVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistVSLInfoUSQL(), updateMstVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	result++;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0146
	 * 
	 * @param List<MasVslRgstVO> deleteMstVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteHistVslRgst(List<MasVslRgstVO> deleteMstVOList) throws DAOException,Exception {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteMstVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistVSLInfoDSQL(), deleteMstVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED){
                    	result++;
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                    }
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
    
    /**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0146
	 * 
	 * @param List<MasVslSubTrdCapaVO> updatetDetailVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyHistVSLSubTRDCapa(List<MasVslSubTrdCapaVO> updatetDetailVOList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updatetDetailVOList.size() > 0){
				
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistVSLSubTRDCapaUSQL(), updatetDetailVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
    
    /**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0146
	 * 
	 * @param List<MasVslSubTrdCapaVO> deleteDetailVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteHistVSLSubTRDCapa(List<MasVslSubTrdCapaVO> deleteDetailVOList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteDetailVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistVSLSubTRDCapaDSQL(), deleteDetailVOList, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

    /**
	 * [Vessel History - LST_FLG] 정보를 [수정] 합니다.<br>
	 * UI - ESM_MAS_0146
	 * 
	 * @param CommonMasRsVO commonMasRsVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyMultiHistLstFlg(CommonMasRsVO commonMasRsVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Object[] value = null;
		int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(commonMasRsVO != null){
				
				value = commonMasRsVO.getHMap().values().toArray();
				velParam.put("table_name",	value[0]);
				param.put("lst_flg",		value[1]);				
				velParam.put("operator",	value[2]);
				param.put("vsl_cd",			value[3]);
				
                insCnt = sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiHistLstFlgUSQL(), param, velParam);

    			if(insCnt == Statement.EXECUTE_FAILED)
    					throw new DAOException("Fail to insert SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_MAS_0146
	 * 
	 * @param List<MasVslSubTrdCapaVO> insertDetailVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addVSLSubTRDCapa(List<MasVslSubTrdCapaVO> insertDetailVOList) throws DAOException,Exception {
		int insCnt[] = null;
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertDetailVOList.size() > 0){
				velParam.put("update_flg", "");
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOVSLSubTRDCapaCSQL(), insertDetailVOList, velParam);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	 
	/**
	 * [Vessel 등록 유무 ] 정보를 [check] 합니다.<br>
	 * 
	 * @param MasVslRgstVO masVslRgstVO
	 * @return List<SearchVslInfoListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchVslInfoListVO> searchVslCount(MasVslRgstVO masVslRgstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVslInfoListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(masVslRgstVO != null){
				Map<String, String> mapVO = masVslRgstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchVslCountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVslInfoListVO .class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}    
