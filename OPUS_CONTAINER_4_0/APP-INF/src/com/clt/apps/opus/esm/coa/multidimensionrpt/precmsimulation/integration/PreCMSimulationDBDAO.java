/*=========================================================
*Copyright(c) 2006 CyberLogitec
 *@FileName : SalesRPTDBDAO.java
 *@FileTitle : SalesRPTDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2006-11-09 Sangwook_nam
 * 1.0 최초 생성
 * =========================================================
 * History
 =========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.MergyVolProjConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.vo.TrfChgVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.util.WebKeys;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter; 
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS SalesRPTDBDAO <br>
 * - OPUS-MultiDimensionRPT system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author NAMKOONG Jin Ho
 * @see SalesRPTBCImpl 참조
 * @since J2EE 1.6
 */
public class PreCMSimulationDBDAO extends DBDAOSupport { 
	
	
	/**
	 * (CMTX)Route Cost Inqiury <br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param List<TrfChgVO> vo2
	 * @return CommonCoaRsVO
	 * @throws DAOException
	 */
	public CommonCoaRsVO searchBKG4006List(SearchConditionVO searchConditionVO, List<TrfChgVO> vo2) throws DAOException {
		DBRowSet dbRowset = null;
		CommonCoaRsVO commonCoaRsVO = new CommonCoaRsVO();
		List<TrfChgVO> parentArr = new ArrayList<TrfChgVO>();			//20160616.ADD		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int dCnt = 0; 													//20160616.ADD		

		try{
			if(searchConditionVO != null && vo2 != null && vo2.size() > 0){				
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				//20160616.ADD		
				for(int j=0 ; j<vo2.size() ; j++){
					TrfChgVO retVo = new TrfChgVO();
					if(vo2.get(j).getIbflag().equals("I")) {
						retVo.setChgCd(vo2.get(j).getChgCd());
						retVo.setD20(vo2.get(j).getD20());
						retVo.setD40(vo2.get(j).getD40());
						retVo.setD45(vo2.get(j).getD45());
						retVo.setD70(vo2.get(j).getD70());					
						retVo.setLvl(vo2.get(j).getLvl());
						retVo.setLvl2(vo2.get(j).getLvl2());
						retVo.setPc(vo2.get(j).getPc());
						parentArr.add(retVo);						
					} else {
						dCnt++;
					}
				}
				velParam.put("rowcnt", vo2.size()-dCnt);		
				velParam.put("parentArr", parentArr);		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PreCMSimulationDBDAOsearchBkg4006ListRSQL(), param, velParam);
			commonCoaRsVO.setDbRowset(dbRowset);
			commonCoaRsVO.setEventName("GS3");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonCoaRsVO;
	}
	
	/**
	 * searchBkgRemarkList 조회<br>
	 * 
	 * @param SearchConditionVO vo
	 * @return List<SearchBkgRmk0170ListVO>
	 * @throws DAOException
	 */
	public CommonCoaRsVO searchBkgRemarkList4007(SearchConditionVO vo) throws DAOException {
    	DBRowSet dbRowset = null;
        CommonCoaRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PreCMSimulationDBDAOSearchBkgRmk4007ListRSQL(), param, velParam);
			
            retVO = new CommonCoaRsVO();
            retVO.setDbRowset(dbRowset);
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}
	
	/**
	 * 기본정보(PARA DATA) 생성
	 * 
	 * 2012.04.10 최윤성 [CHM-201217066-01] [COA] EMU 로직 보완 - MTY_PKUP_YD_CD 변수 추가
	 * 
	 * @param  aplyRtInVO AplyRtInVO
	 * @return String
	 * @throws DAOException
	 */
	public String createCostAssignPreCM(AplyRtInVO aplyRtInVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		@SuppressWarnings("rawtypes")
		Map rtnMap = null;
		String rtnValue = null;

		log.debug("\n\ncreateCostAssignPreCM " );
		try{
			if(aplyRtInVO != null){
				
				// Product Catalog Inquiry 화면에서 사용하는 Proc와의 일치화 작업으로 인해 추가됨.
				aplyRtInVO.setFStartPctlNo(aplyRtInVO.getPctlNo());
				aplyRtInVO.setFEndPctlNo(aplyRtInVO.getPctlNo());
				
				Map<String, String> mapVO = aplyRtInVO .getColumnValues();			
				param.putAll(mapVO);
				param.put("f_mty_pkup_yd", aplyRtInVO.getFMtyPkupYdCd() + aplyRtInVO.getFMtyPkupYdNode());
				param.put("f_mty_rtn_yd", aplyRtInVO.getFMtyRtnYdCd() + aplyRtInVO.getFMtyRtnYdNode());					
				param.put("f_agn_bkg_ofc_cd", aplyRtInVO.getFAgnBkgOfcCd());					
				param.put("f_agn_ctrt_ofc_cd", aplyRtInVO.getFAgnCtrtOfcCd());					
				param.put("f_agn_ff_cust", aplyRtInVO.getFAgnFfCust());					
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "PRE");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			log.debug("\n\n\ncoa_cost_assign_precm_prc result : [" + rtnMap.get("f_out_param_number") + "]" );
			rtnValue = ""; //(String)rtnMap.get("f_out_param_number");
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
	 * 기준년월 조회
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String searchBzcCostYrmon() throws DAOException{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String rtnValue = null;

		try{
/*			if(aplyRtInVO != null){
				Map<String, String> mapVO = aplyRtInVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} */
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PreCMSimulationDBDAOSearchBzcCostYrmonRSQL(), param, velParam);
			while ( dbRowset.next()){
				rtnValue = dbRowset.getString("cost_yrmon");
			}
//			commonCoaRsVO.setDbRowset(dbRowset);
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
	 * TRS 비용 생성
	 * 
	 * @param  aplyRtInVO AplyRtInVO
	 * @return String
	 * @throws DAOException
	 */
	public String createTrsAgmtApplyToCoa(AplyRtInVO aplyRtInVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map rtnMap = null;
		String rtnValue = null;

		log.debug("\n\ncreateTrsAgmtApplyToCoa" );
		try{
			if(aplyRtInVO != null){
				aplyRtInVO.setFPctlNo(aplyRtInVO.getPctlNo());
				Map<String, String> mapVO = aplyRtInVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "TRS");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			log.debug("\n\n\ntrs_agmt_apply_to_coa_prc result : [" + rtnMap.get("f_out_param_number") + "]" );
			rtnValue = ""; //(String)rtnMap.get("f_out_param_number");
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
	 * TES 비용 생성
	 * 
	 * @param  aplyRtInVO AplyRtInVO
	 * @return String
	 * @throws DAOException
	 */
	public String createTesCoaRate(AplyRtInVO aplyRtInVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map rtnMap = null;
		String rtnValue = null;
log.debug("\n\ncreateTesCoaRate=" );

		try{
			if(aplyRtInVO != null){
				aplyRtInVO.setFPctlNo(aplyRtInVO.getPctlNo());
				Map<String, String> mapVO = aplyRtInVO .getColumnValues();
				
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "TES");
				velParam.put(WebKeys.PROC_SCALE_KEY, "8");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			log.debug("\n\n\ntes_coa_rate_prc result : [" + rtnMap.get("f_out_param_number") + "]" );
			rtnValue = ""; //(String)rtnMap.get("f_out_param_number");
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
	 * COA 평균단가를 이용한 비용 생성
	 * 
	 * @param  aplyRtInVO AplyRtInVO
	 * @return String
	 * @throws DAOException
	 */
	public String createCoaCostPkgMainPreCMAvg(AplyRtInVO aplyRtInVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map rtnMap = null;
		String rtnValue = null;

		try{
			if(aplyRtInVO != null){
				aplyRtInVO.setFPctlNo(aplyRtInVO.getPctlNo());
				Map<String, String> mapVO = aplyRtInVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "AVG");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			rtnValue = "";
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
	 * AGT Other Comm 비용 생성
	 * 
	 * @param  aplyRtInVO AplyRtInVO
	 * @return String
	 * @throws DAOException
	 */
	public String createAcmAplyOtrCommToCoa(AplyRtInVO aplyRtInVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map rtnMap = null;
		String rtnValue = null;

		try{
			if(aplyRtInVO != null){
				aplyRtInVO.setFPctlNo(aplyRtInVO.getPctlNo());
				Map<String, String> mapVO = aplyRtInVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "AGT");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			rtnValue = "";
//			rtnValue = (String)rtnMap.get("f_out_param_number");
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
	 * Total 비용 계산 및 USD환산
	 * 
	 * @param  aplyRtInVO AplyRtInVO
	 * @return String
	 * @throws DAOException
	 */
	public String createCoaCostPkgMainComTtl(AplyRtInVO aplyRtInVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map rtnMap = null;
		String rtnValue = null;

		try{
			if(aplyRtInVO != null){
				aplyRtInVO.setFPctlNo(aplyRtInVO.getPctlNo());
				Map<String, String> mapVO = aplyRtInVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("f_call_id", "TTL");
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new PreCMSimulationDBDAOExecuteSPRSQL(), param, velParam);
			rtnValue = "";
//			rtnValue = (String)rtnMap.get("f_out_param_number");
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
	 * Report view 의 목록을 가져온다.<br>
	 * @param AplyRtInVO aplyRtInVO
	 * @return List<AplyRtInVO>
	 * @throws DAOException
	 */
	public List<AplyRtInVO> searchPctlNo(AplyRtInVO aplyRtInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AplyRtInVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(aplyRtInVO != null){
				Map<String, String> mapVO = aplyRtInVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PreCMSimulationDBDAOSearchPctlNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AplyRtInVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
}

