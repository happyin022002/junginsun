/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchManageDBDAO.java
*@FileTitle : Expense Accrual Batch Main
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.10.05
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.10.05 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.integration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.basic.AccrualBatchManageBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.LeaAcclCondItmVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.vo.SearchAccrualBatchPreConditionVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration.BookingProcessMgtDBDAOManageBKGBDRLOGCSQL;
import com.hanjin.syscommon.common.table.GlAcclIfVO;


/**
 * ALPS AccrualBatchManageDBDAO <br>
 * - ALPS-LogisticsExpenseAccrual system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeon Jae Hong
 * @see AccrualBatchManageBCImpl 참조
 * @since J2EE 1.6
 */
public class AccrualBatchManageDBDAO extends DBDAOSupport {

	/**
	 * 결산 배치 프로그램 실행을 위한 사전조건을 조회한다.<br>
	 * @param SearchAccrualBatchPreConditionVO searchAccrualBatchPreConditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchAccrualBatchPreConditionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchAccrualBatchPreConditionVO> searchAccrualBatchPreCondition(SearchAccrualBatchPreConditionVO searchAccrualBatchPreConditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		DBRowSet dbRowset1 = null;
		List<SearchAccrualBatchPreConditionVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchAccrualBatchPreConditionVO != null){
				Map<String, String> mapVO = searchAccrualBatchPreConditionVO .getColumnValues();
				
				mapVO.put("cre_usr_id", account.getUsr_id());
				mapVO.put("cre_ofc_cd", account.getOfc_cd());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchManageDBDAOSearchAccrualBatchPreConditionRSQL(), param, velParam);		
						
			int resultCnt = 0;
			if(dbRowset.getRowCount() < 1){
				resultCnt = new SQLExecuter("LEA_HJSLEA").executeUpdate((ISQLTemplate)new AccrualBatchManageDBDAOCreateAccrualBatchPreConditionCSQL(), param, velParam);
			}else{			
				while(dbRowset.next()) {					
		    		if (dbRowset.getString("ERP_IF_FLG").equals("N")){
		    			resultCnt =	new SQLExecuter("LEA_HJSLEA").executeUpdate((ISQLTemplate)new AccrualBatchManageDBDAOCreateAccrualBatchPreConditionCSQL(), param, velParam);
		    		}
		    	}			
			}
			
			if(resultCnt > 0){
				dbRowset1 = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchManageDBDAOSearchAccrualBatchPreConditionRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset1, SearchAccrualBatchPreConditionVO .class);
				
			}else {
				dbRowset.beforeFirst();
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccrualBatchPreConditionVO .class);
				
			}
	
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
	 * Rev.Month/Account Code 별 정보를 ERP SUMMARY LayOut(GL_ACCL_IF) 에 적합하게 생성한다.<br>
	 * @param String frmExeYrmon
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addModifyAccrualBatchPreConditionConfirmS(String frmExeYrmon) throws DAOException,Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("frm_exe_yrmon", frmExeYrmon);
		
		try {			
			SQLExecuter sqlExe = new SQLExecuter("LEA_HJSLEA");
			sqlExe.executeUpdate((ISQLTemplate)new AccrualBatchManageDBDAOModifyAccrualBatchPreConditionConfirmCSQL(),  param, velParam);
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	
	/**
	 * 결산 사전 정보, Manual 입력 정보, ERP Summary Confirm 정보등을 갱신한다.<br>
	 * @param String frmExeYrmon
	 * @param String frmConfirmDiv
	 * @param String usrId
	 * @param String usrOfcCd
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyModifyAccrualBatchPreConditionConfirmS(String frmExeYrmon, String frmConfirmDiv , String usrId, String usrOfcCd ) throws DAOException,Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("upd_usr_id", usrId);
		param.put("upd_ofc_cd", usrOfcCd);
		param.put("frm_exe_yrmon", frmExeYrmon);
		velParam.put("frm_confirm_div", frmConfirmDiv);
		
		try {		
			SQLExecuter sqlExe = new SQLExecuter("LEA_HJSLEA");		
			sqlExe.executeUpdate((ISQLTemplate)new AccrualBatchManageDBDAOModifyAccrualBatchPreConditionConfirmUSQL(), param, velParam);
						
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	
	
	/**
	 * ERP Summary Data 를 삭제 한다.<br>
	 * @param String frmExeYrmon
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeModifyAccrualBatchPreConditionConfirmS(String frmExeYrmon) throws DAOException,Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("frm_exe_yrmon", frmExeYrmon);
		
		try {		
			SQLExecuter sqlExe = new SQLExecuter("LEA_HJSLEA");		
			sqlExe.executeUpdate((ISQLTemplate)new AccrualBatchManageDBDAOModifyAccrualBatchPreConditionConfirmDSQL(), param, velParam );
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	
	/**
	 * 결산 배치 프로그램 실행한다.<br>
	 * ( DB Procedure "LEA_BAT_START_PRC" 을 호출)<br>
	 * @param String frmExeYrmon
	 * @return String
	 * @throws Exception
	 */	
	public String executeAccrualBatch(String frmExeYrmon) throws DAOException {	
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, Object> resultMap  =null;
		
		// return Message
		String 	returnMsg = "";
		
		String a = JSPUtil.removeCharacter(frmExeYrmon, "-");
		
		try {			
			param.put("frm_exe_yrmon", a);
			param.put("msg_out", "");
			
			log.debug("param111>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+param);
			resultMap = new SQLExecuter("LEA_HJSLEA") .executeSP((ISQLTemplate)new AccrualBatchManageDBDAOExecuteAccrualBatchCSQL(),  param, null);
			returnMsg = (String) resultMap.get("msg_out");
			return returnMsg;
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}