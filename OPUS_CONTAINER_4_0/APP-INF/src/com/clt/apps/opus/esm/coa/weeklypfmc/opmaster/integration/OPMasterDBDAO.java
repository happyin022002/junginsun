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
=========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration.OPMasterDBDAOCheckOmPortMngRSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration.OPMasterDBDAOSearchOmPortMngRSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration.OPMasterDBDAOMultiOmPortMngCSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration.OPMasterDBDAOMultiOmPortMngUSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration.OPMasterDBDAOMultiOmPortMngDSQL;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.MultiOmPortMngVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.basic.OPMasterBCImpl;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.MultiHistVSLInfoVslSeqVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchHistoryLaneListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchRgstLaneListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchVslInfoListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CoaLaneRgstVO;
import com.clt.syscommon.common.table.CoaLaneTpHisVO;
import com.clt.syscommon.common.table.CoaVslRgstVO;
import com.clt.syscommon.common.table.CoaVslSubTrdCapaVO;


/**
 * COA에 대한 DB 처리를 담당<br>
 * - COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Eun Ju
 * @see OPMasterBCImpl 참조
 * @since J2EE 1.4
 */
public class OPMasterDBDAO extends DBDAOSupport {

    /**
     * COA_LANE_RGST 목록을 가져온다.<br>
     * UI - ESM_COA_00
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
	 * [Create Lane Table] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_COA_0036
	 * 
	 * @param List<CoaLaneRgstVO> insertRgstLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] addRgstLane(List<CoaLaneRgstVO> insertRgstLaneVOList) throws DAOException {
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
	 * UI - ESM_COA_0036
	 * 
	 * @param List<CoaLaneRgstVO> updateRgstLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] modifyRgstLane(List<CoaLaneRgstVO> updateRgstLaneVOList) throws DAOException {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateRgstLaneVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiRgstLaneUSQL(), updateRgstLaneVOList, null);
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
	 * UI - ESM_COA_0036
	 * 
	 * @param List<CoaLaneRgstVO> deleteRgstLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] deleteRgstLane(List<CoaLaneRgstVO> deleteRgstLaneVOList) throws DAOException {
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
     * COA_VSL_RGST 목록을 가져온다.<br>
     * ESM_COA_0037화면에 대한 조회 이벤트 처리<br>
     * 명칭변경(2009.09.30) : searchVSLInfoList ---> searchVslRgstList
     *  
     * @param  SearchConditionVO searchVO
     * @param  CommonCoaRsVO commonCoaRsVO
     * @return CommonCoaRsVO
     * @throws DAOException
     */
    public CommonCoaRsVO searchVslRgstList(SearchConditionVO searchVO, CommonCoaRsVO commonCoaRsVO) throws DAOException {
        DBRowSet dbRowset = null;
        CommonCoaRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<String> headerList = null;
		String fChkdel = null;
        try{
            if( searchVO != null ){
            	headerList = Utils.seperationParameter(commonCoaRsVO.getHeader(),"|");
            	fChkdel = Utils.iif(searchVO.getFChkdel() == null||searchVO.getFChkdel().trim().equals(""), "N", searchVO.getFChkdel());
            	
            	param.put("f_chkdel",		fChkdel);
            	param.put("f_vsl_cd",		searchVO.getFVslCd());
            	param.put("f_ofc_cd",		searchVO.getFOfcCd());
            	velParam.put("keyList", 	headerList);
            	velParam.put("f_vsl_cd",	searchVO.getFVslCd());
            	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchVslRgstListRSQL(), param, velParam);
	            retVO = new CommonCoaRsVO();
	            retVO.setDbRowset(dbRowset);
	            retVO.setHeader(commonCoaRsVO.getHeader());
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
        try{
        	if ( searchVO != null ){
        		param.put("f_trd_cd",	searchVO.getFHTrdCd());
        		param.put("f_rlane_cd",	searchVO.getFHRlaneCd());
        		param.put("f_dir_cd",	searchVO.getFHDirCd());
        		param.put("f_ioc_cd",	searchVO.getFHIocCd());
        		
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchHistoryLaneListRSQL(), param, null);
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
	 * UI - ESM_COA_0037
	 * 
	 * @param List<CoaLaneTpHisVO> insertHistLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] addHistoryLane(List<CoaLaneTpHisVO> insertHistLaneVOList) throws DAOException {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertHistLaneVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneCSQL(), insertHistLaneVOList, null);
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
	 * UI - ESM_COA_0037
	 * 
	 * @param List<CoaLaneTpHisVO> modifyHistLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] modifyHistoryLane(List<CoaLaneTpHisVO> modifyHistLaneVOList) throws DAOException {
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

//                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneTpHisFlgUSQL(), modifyHistLaneVOList, null);
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
		return insCnt;
	}
	
	/**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_COA_0037
	 * 
	 * @param List<CoaLaneTpHisVO> deleteHistLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] deleteHistoryLane(List<CoaLaneTpHisVO> deleteHistLaneVOList) throws DAOException {
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
     * COA_VSL_RGST 목록을 가져온다.<br>
     * 
     * @param  SearchConditionVO searchVO
     * @param  CommonCoaRsVO commonCoaRsVO
     * @return CommonCoaRsVO
     * @throws DAOException
     */
    public CommonCoaRsVO searchHistVSLInfoList(SearchConditionVO searchVO, CommonCoaRsVO commonCoaRsVO) throws DAOException {
        DBRowSet dbRowset = null;
        CommonCoaRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<String> headerList = null;
		
        try{
            if( searchVO != null ) {
            	headerList = Utils.seperationParameter(commonCoaRsVO.getHeader(),"|"); 
            	param.put("f_vsl_cd",	searchVO.getFVslCd());
            	velParam.put("keyList", headerList);
            	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchHistVSLInfoListRSQL(), param, velParam);
	            retVO = new CommonCoaRsVO();
	            retVO.setDbRowset(dbRowset);
	            retVO.setHeader(commonCoaRsVO.getHeader());
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
     * COA_VSL_RGST vessel sequence number 조회.(조회)<br>
	 * UI - ESM_COA_0037, ESM_COA_0146
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
	 * UI - ESM_COA_0037
	 * 
	 * @param List<CoaVslRgstVO> insertMstVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] addVslRgst(List<CoaVslRgstVO> insertMstVOList) throws DAOException {
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
	 * UI - ESM_COA_0037
	 * 
	 * @param List<CoaVslRgstVO> updateMstVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyVslRgst(List<CoaVslRgstVO> updateMstVOList) throws DAOException,Exception {
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
	 * UI - ESM_COA_0037
	 * 
	 * @param List<CoaVslRgstVO> deleteMstVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyVslRgstDeltFlg(List<CoaVslRgstVO> deleteMstVOList) throws DAOException,Exception {
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
	 * UI - ESM_COA_0146
	 * 
	 * @param List<CoaVslSubTrdCapaVO> deleteDetailVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteVSLSubTRDCapa(List<CoaVslSubTrdCapaVO> deleteDetailVOList) throws DAOException,Exception {
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
	 * UI - ESM_COA_0146
	 * 
	 * @param List<CoaVslRgstVO> insertMstVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addHistVslRgst(List<CoaVslRgstVO> insertMstVOList) throws DAOException,Exception {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertMstVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistVSLInfoCSQL(), insertMstVOList, null);
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
	 * UI - ESM_COA_0146
	 * 
	 * @param List<CoaVslRgstVO> updateMstVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyHistVslRgst(List<CoaVslRgstVO> updateMstVOList) throws DAOException,Exception {
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
	 * UI - ESM_COA_0146
	 * 
	 * @param List<CoaVslRgstVO> deleteMstVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteHistVslRgst(List<CoaVslRgstVO> deleteMstVOList) throws DAOException,Exception {
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
	 * UI - ESM_COA_0146
	 * 
	 * @param List<CoaVslSubTrdCapaVO> updatetDetailVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyHistVSLSubTRDCapa(List<CoaVslSubTrdCapaVO> updatetDetailVOList) throws DAOException,Exception {
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
	 * UI - ESM_COA_0146
	 * 
	 * @param List<CoaVslSubTrdCapaVO> deleteDetailVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteHistVSLSubTRDCapa(List<CoaVslSubTrdCapaVO> deleteDetailVOList) throws DAOException,Exception {
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
	 * UI - ESM_COA_0146
	 * 
	 * @param CommonCoaRsVO commonCoaRsVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyMultiHistLstFlg(CommonCoaRsVO commonCoaRsVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(commonCoaRsVO != null){
	
				velParam.put("table_name",	commonCoaRsVO.getHMap().get("table_name"));
				param.put("lst_flg",		commonCoaRsVO.getHMap().get("lst_flg"));				
				velParam.put("operator",	commonCoaRsVO.getHMap().get("operator"));
				param.put("vsl_cd",			commonCoaRsVO.getHMap().get("vsl_cd"));				
				
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
	 * UI - ESM_COA_0146
	 * 
	 * @param List<CoaVslSubTrdCapaVO> insertDetailVOList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addVSLSubTRDCapa(List<CoaVslSubTrdCapaVO> insertDetailVOList) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertDetailVOList.size() > 0){
				
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOVSLSubTRDCapaCSQL(), insertDetailVOList, null);
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
	 * @param CoaVslRgstVO coaVslRgstVO
	 * @return List<SearchVslInfoListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchVslInfoListVO> searchVslCount(CoaVslRgstVO coaVslRgstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVslInfoListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(coaVslRgstVO != null){
				Map<String, String> mapVO = coaVslRgstVO .getColumnValues();
			
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
	
    /**
     * ESM_COA_4009 목록을 가져온다.<br>
     * 
     * @param  SearchConditionVO searchVO
     * @param  CommonCoaRsVO commonCoaRsVO
     * @return CommonCoaRsVO
     * @throws DAOException
     * @author SJH.20140916.ADD
     */
    public CommonCoaRsVO searchOmPortMngList(SearchConditionVO searchVO, CommonCoaRsVO commonCoaRsVO) throws DAOException {
    	DBRowSet dbRowset = null;
        CommonCoaRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try{
            if( searchVO != null ) {
            	param.put("eff_fm_dt",	searchVO.getFSdate());	
            	velParam = param;
            	
            	log.debug("################# param    : "+param);
            	log.debug("################# velParam : "+velParam);
            	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchOmPortMngRSQL(), param, velParam);
	            retVO = new CommonCoaRsVO();
	            retVO.setDbRowset(dbRowset);
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
	 * ESM_COA_4009 화면에 대한 멀티 이벤트 처리(INSERT)<br>
	 * 
	 * @param MultiOmPortMngVO multiOmPortMngVO
	 * @throws DAOException
	 * @throws Exception
	 * @author 20150529.MOD
	 */
	public void addMultiOmPortMng(MultiOmPortMngVO multiOmPortMngVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = multiOmPortMngVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiOmPortMngCSQL(), param, velParam);
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
	 * ESM_COA_4009 화면에 대한 멀티 이벤트 처리(UPDATE)<br>
	 * 
	 * @param MultiOmPortMngVO multiOmPortMngVO
	 * @throws DAOException
	 * @throws Exception
	 * @author 20150529.MOD
	 */
	public void modifyMultiOmPortMng(MultiOmPortMngVO multiOmPortMngVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = multiOmPortMngVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiOmPortMngUSQL(), param, velParam);
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
	 * ESM_COA_4009 화면에 대한 멀티 이벤트 처리(DELETE)<br>
	 * 
	 * @param MultiOmPortMngVO multiOmPortMngVO
	 * @exception DAOException
	 * @author 20150529.ADD
	 */
	public void removeMultiOmPortMng(MultiOmPortMngVO multiOmPortMngVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try {
			Map<String, String> mapVO = multiOmPortMngVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OPMasterDBDAOMultiOmPortMngDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_COA_4009 <br>
	 * 
	 * @param MultiOmPortMngVO multiOmPortMngVO 
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 * @author SJH.20141006.ADD
	 */
	public int checkOmPortMng(MultiOmPortMngVO multiOmPortMngVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int checkCnt = 0;

		try{
			Map<String, String> mapVO = multiOmPortMngVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			log.debug("=============== param : "+param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOCheckOmPortMngRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkCnt = dbRowset.getInt(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkCnt;
	}	
	
	/**
	 * [Vessel History] 정보를 [삽입] 합니다.<br>
	 * UI - ESM_COA_0037
	 * 
	 * @param List<CoaLaneTpHisVO> updateMainLaneVOList
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] modifyMainLane(List<CoaLaneTpHisVO> updateMainLaneVOList) throws DAOException {
		int insCnt[] = null;
		int result = 0;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateMainLaneVOList.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new OPMasterDBDAOMultiHistoryLaneTpHisFlgUSQL(), updateMainLaneVOList, null);
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
     * ESM_COA_4010 목록을 가져온다.<br>
     * 
     * @param  SearchConditionVO searchVO
     * @param  CommonCoaRsVO commonCoaRsVO
     * @return CommonCoaRsVO
     * @throws DAOException
     * @author SJH.20140916.ADD
     */
    public CommonCoaRsVO searchCrsChkCoaBkgPeriod(SearchConditionVO searchVO, CommonCoaRsVO commonCoaRsVO) throws DAOException {
    	DBRowSet dbRowset = null;
        CommonCoaRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try{
            if( searchVO != null ) {
            	param.put("f_fm_dt", searchVO.getFFrom());	
            	param.put("f_to_dt", searchVO.getFTo());
            	
            	velParam = param;
            	
            	log.debug("################# param    : "+param);
            	log.debug("################# velParam : "+velParam);
            	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchCrsChkCoaBkgPeriodRSQL(), param, velParam);
	            retVO = new CommonCoaRsVO();
	            retVO.setDbRowset(dbRowset);
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
     * ESM_COA_4010 목록을 가져온다.<br>
     * 
     * @param  SearchConditionVO searchVO
     * @param  CommonCoaRsVO commonCoaRsVO
     * @return CommonCoaRsVO
     * @throws DAOException
     * @author SJH.20140916.ADD
     */
    public CommonCoaRsVO searchCrsChkCoaBkgVVD(SearchConditionVO searchVO, CommonCoaRsVO commonCoaRsVO) throws DAOException {
    	DBRowSet dbRowset = null;
        CommonCoaRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try{
            if( searchVO != null ) {
            	param.put("f_vsl_cd",		searchVO.getFVslCd());	
            	param.put("f_skd_voy_no",	searchVO.getFSkdVoyNo());	
            	param.put("f_dir_cd",		searchVO.getFDirCd());	
            	velParam = param;
            	
            	log.debug("################# param    : "+param);
            	log.debug("################# velParam : "+velParam);
            	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPMasterDBDAOSearchCrsChkCoaBkgVVDRSQL(), param, velParam);
	            retVO = new CommonCoaRsVO();
	            retVO.setDbRowset(dbRowset);
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
}    
