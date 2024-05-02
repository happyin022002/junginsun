/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UsaLastCityManagementDBDAO.java
*@FileTitle : USA Last City for T&E Cargo
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-22
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-09-22 juhyun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.event.EsdTrs0076Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsDmstLstCtyVO;

 
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author juhyun
 * @see UsaLastCityManagementBCImpl 참조
 * @since J2EE 1.4
 */
public class USALastCityManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * USALastCityManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSALastCityManageList(TrsDmstLstCtyVO model) throws DAOException {
		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("deltFlg", model.getDeltFlg());
			velParam.put("deltFlg", model.getDeltFlg());
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USALastCityManageDBDAOSearchUSALastCityManageListRSQL(), param, velParam);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * ControlOfficeExceptionCaseManage의 입력데이타 검증작업을 한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchLocalCodeManage(EsdTrs0076Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{	
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USALastCityManageDBDAOSearchLocalCodeManageListRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	
	
	/**
	 * USALastCityManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param model
	 * @param event
	 * @throws DAOException
	 */
	public void multiTRS_DMST_LST_CTY(TrsDmstLstCtyVO[] model, EsdTrs0076Event event) throws DAOException {

		List<TrsDmstLstCtyVO> insertVoList = new ArrayList<TrsDmstLstCtyVO>();
		List<TrsDmstLstCtyVO> updateVoList = new ArrayList<TrsDmstLstCtyVO>();
		List<TrsDmstLstCtyVO> deleteVoList = new ArrayList<TrsDmstLstCtyVO>();
		
		String deltFlg = model[0].getDeltFlg();
		String userId1 = event.getUserId1();
	  	String today1 = event.getToday1();
	  	String userId2 = event.getUserId2();
	  	String today2 = event.getToday2();
	  	String stsVal = event.getStsVal();
	  	
	  	int insCnt[] = null;
		
		try{
			
			for(int i = 0; i < model.length; i++){
				
				model[i].setCreUsrId(userId1);
				model[i].setCreDt(today1);
				model[i].setUpdUsrId(userId2);
				model[i].setUpdDt(today2);
				if(model[i].getIbflag().equals("D")){
					model[i].setDeltFlg(stsVal);					
				}else{
					model[i].setDeltFlg(deltFlg);
				}
				
				if ( model[i].getIbflag().equals("I")){					
					insertVoList.add(model[i]);
				} else if ( model[i].getIbflag().equals("U")){				
					updateVoList.add(model[i]);
				} else if ( model[i].getIbflag().equals("D")){					
					deleteVoList.add(model[i]);					
				}				
			}
				
			//1. Last City Insert
			if(insertVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USALastCityManageDBDAOMultiTrsDmstLstCtyCSQL(), insertVoList, null);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
			}

			//2. Last City Update
			if(updateVoList.size() > 0){					
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USALastCityManageDBDAOMultiTrsDmstLstCtyUSQL(), updateVoList, null);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}

			//3. Last City Insert
			if(deleteVoList.size() > 0){
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new USALastCityManageDBDAOMultiTrsDmstLstCtyDelDSQL(), deleteVoList, null);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
			}						
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}
	
	/**
	 * USALastCityManage에서 Door/CY의 경우에 따라 해당하는 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSALastCityComboList(EsdTrs0076Event event) throws DAOException {
		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("trsp_cost_dtl_mod_cd", event.getTrspCostDtlModCd());
			param.put("org_loc_cd", event.getOrgLocCd());
			param.put("dest_loc_cd", event.getDestLocCd());
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new USALastCityManageDBDAOSearchUSALastCityComboListRSQL(), param, param);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
}
