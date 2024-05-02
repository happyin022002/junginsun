/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : SLTIntDBDAO.java
*@FileTitle      : MRI 운임수입 단가 생성
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-17
*@LastModifier   : PEJ
*@LastVersion    : 1.3
* 2008-04-30 PEJ
* 1.0 최초 생성
* ========================================================

=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.sltint.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration.MTCostDBDAOEqRepoCostBatchVOUSQL;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.EqRepoCostVO;
import com.clt.apps.opus.esm.coa.stdunitcost.sltint.vo.SlotInternalPricingVO;

/**
 * COA에 대한 DB 처리를 담당<br>
 * - COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author IM OKYOUNG
 * @see eqholdingBCImpl 참조
 * @since J2EE 1.4
 */
public class SLTIntDBDAO extends DBDAOSupport { 
	
    /**
     * ESM_COA_4001 목록을 가져온다.<br>
     * 
     * @param  SearchConditionVO searchVO
     * @param  CommonCoaRsVO commonCoaRsVO
     * @return CommonCoaRsVO
     * @throws DAOException
     * @author SJH.20140916.ADD
     */
    public CommonCoaRsVO searchSlotIPList(SearchConditionVO searchVO, CommonCoaRsVO commonCoaRsVO) throws DAOException {
    	DBRowSet dbRowset = null;
        CommonCoaRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try{
            if( searchVO != null ) {
            	param.put("f_eff_fm_yrmon",	searchVO.getFFmMon());
            	param.put("f_slane_cd",		searchVO.getFSelslane());
            	param.put("f_trd_cd",		searchVO.getFTrdCd());
            	param.put("f_sub_trd_cd",	searchVO.getFSubTrdCd());
            	param.put("f_fm_port_cd",	searchVO.getFFrom());
            	param.put("f_to_port_cd",	searchVO.getFTo());
            	param.put("f_cgo_tp_cd",	searchVO.getFTypeCd());			//Cargo Type            	
            	velParam = param;
            	velParam.put("f_fm_len",    searchVO.getFFrom().length());
            	velParam.put("f_to_len",    searchVO.getFTo().length());
            	
            	log.debug("################# param    : "+param);
            	log.debug("################# velParam : "+velParam);
            	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SLTIntDBDAOSlotInternalPricingVORSQL(), param, velParam);
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
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_4001 화면에 대한 멀티 이벤트 처리(INSERT)<br>
	 * 
	 * @param SlotInternalPricingVO slotInternalPricingVO
	 * @throws DAOException
	 * @throws Exception
	 * @author SJH.20140917.ADD
	 */
	public void addSlotInternalPricing(SlotInternalPricingVO slotInternalPricingVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = slotInternalPricingVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SLTIntDBDAOSlotInternalPricingVOCSQL(), param, velParam);
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
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_4001 화면에 대한 멀티 이벤트 처리(UPDATE)<br>
	 * 
	 * @param List<SlotInternalPricingVO> updModels
	 * @param SearchConditionVO searchConditionVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 * @author SJH.20140917.ADD
	 */
	public int[] modifySlotInternalPricing(List<SlotInternalPricingVO> updModels, SearchConditionVO searchConditionVO) throws DAOException,Exception {
		int updCnt[] = null;		
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
				
				velParam.putAll(mapVO);
			}
				
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SLTIntDBDAOSlotInternalPricingVOUSQL(), updModels,velParam);
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
	 * Slot Internal Pricing 정보를 삭제한다.<br>
	 * 
	 * @param List<SlotInternalPricingVO> delModels
	 * @exception DAOException
	 * @author SJH.20140917.ADD
	 */
	public void removeSlotInternalPricing(List<SlotInternalPricingVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){				
				HashMap<String, Object> velParam = new HashMap<String, Object>();					
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SLTIntDBDAOSlotInternalPricingVODSQL(), delModels, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * ESM_COA_4001 <br>
	 * 
	 * @param SlotInternalPricingVO slotInternalPricingVO 
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 * @author SJH.20141006.ADD
	 */
	public int[] checkSltInt(SlotInternalPricingVO slotInternalPricingVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int checkCnt[] = {0, 0};

		try{
			Map<String, String> mapVO = slotInternalPricingVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			log.debug("=============== param : "+param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SLTIntDBDAOCheckSltIntRSQL(), param, velParam);
            while(dbRowset.next()){
            	checkCnt[0] = dbRowset.getInt(1);
            	checkCnt[1] = dbRowset.getInt(2);
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
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_4003 화면에 대한 EFF_TO_YRMON 일괄 처리(UPDATE)<br>
	 * 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void batchUpSltIntPrc() throws DAOException,Exception {
//		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
//			if(slotInternalPricingVO .size() > 0){				
				int result = sqlExe.executeUpdate((ISQLTemplate)new SLTIntDBDAOSltIntPrcbatchUpUSQL(), null,null);					
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
//		return updCnt;
	}
	
}