/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireBalanceDBDAO.java
*@FileTitle : On-Hire Balance
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.basic.ForecastReportBCImpl;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.OnhireStatusVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalConditionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.EqrCtrlOnhOrdQtyVO;
import com.clt.syscommon.common.table.EqrCtrlOnhOrdVO;
import com.clt.syscommon.common.table.EqrCtrlOnhPlnAproQtyVO;
import com.clt.syscommon.common.table.EqrCtrlOnhPlnAproVO;


/**
 * OPUS OnhireBalanceDBDAO <br>
 * - OPUS - On-Hire Balance system Business Logic - JDBC .<br>
 * 
 * @author 
 * @see ForecastReportBCImpl 
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class OnhireBalanceDBDAO extends DBDAOSupport {

	/**
	 *  On-Hire Status <br>
	 * 
	 * @param OnhireStatusVO onhireStatusVO
	 * @return List<OnhireStatusVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OnhireStatusVO> searchOnhireStatusData(OnhireStatusVO onhireStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OnhireStatusVO> list = null;
		//CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(onhireStatusVO != null){ 
				Map<String, String> mapVO = onhireStatusVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireBalanceDBDAOsearchOnhireStatusRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OnhireStatusVO.class);
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
	 * On-Hire Status - ORDER <br>
	 * 
	 * @param List<EqrCtrlOnhOrdVO> eqrCtrlOnhOrdVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addOnhireStatusData(List<EqrCtrlOnhOrdVO> eqrCtrlOnhOrdVOs) throws DAOException,Exception {
		int insCnt = 0;
		DBRowSet dbRowset = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhOrdVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
				
				Map<String, String> mapVO = null; 
				for(int i = 0; i < eqrCtrlOnhOrdVOs.size(); i++){
					EqrCtrlOnhOrdVO eqrCtrlOnhOrdVO = eqrCtrlOnhOrdVOs.get(i);
					
					mapVO = eqrCtrlOnhOrdVO.getColumnValues();
					param.putAll(mapVO);
					
					String dupChk = "";
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireBalanceDBDAOcheckOnhireStatusRSQL(), param, null);
					while(dbRowset.next()){
						dupChk = dbRowset.getString("DUP_CHK");
		            }
					if(!dupChk.equals("0")){ 
						throw new EventException(new ErrorHandler("EQR10028", new String[]{"Duplicated Data exist. Please retrieve again."}).getMessage());
					}
					
					// insert
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new OnhireBalanceDBDAOaddOnhireStatusCSQL(), param, null);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * On-Hire Status - ORDER <br>
	 * 
	 * @param List<EqrCtrlOnhOrdVO> eqrCtrlOnhOrdVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyOnhireStatusData(List<EqrCtrlOnhOrdVO> eqrCtrlOnhOrdVOs) throws DAOException,Exception {
		int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhOrdVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
				
				Map<String, String> mapVO = null; 
				for(int i = 0; i < eqrCtrlOnhOrdVOs.size(); i++){
					EqrCtrlOnhOrdVO eqrCtrlOnhOrdVO = eqrCtrlOnhOrdVOs.get(i);
					
					mapVO = eqrCtrlOnhOrdVO.getColumnValues();
					param.putAll(mapVO);
					
					// update 수행
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new OnhireBalanceDBDAOmodifyOnhireStatusUSQL(), param,null);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * On-Hire Status - ORDER  <br>
	 * 
	 * @param List<EqrCtrlOnhOrdQtyVO> eqrCtrlOnhOrdQtyVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyOnhireStatusQtyData(List<EqrCtrlOnhOrdQtyVO> eqrCtrlOnhOrdQtyVOs) throws DAOException,Exception {
		int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhOrdQtyVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
				
				Map<String, String> mapVO = null; 
				for(int i = 0; i < eqrCtrlOnhOrdQtyVOs.size(); i++){
					EqrCtrlOnhOrdQtyVO eqrCtrlOnhOrdQtyVO = eqrCtrlOnhOrdQtyVOs.get(i);
					
					mapVO = eqrCtrlOnhOrdQtyVO.getColumnValues();
					param.putAll(mapVO);
					
					// update 수행
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new OnhireBalanceDBDAOmodifyOnhireStatusQtyUSQL(), param,null);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * On-Hire Status - ORDER <br>
	 * 
	 * @param List<EqrCtrlOnhOrdVO> eqrCtrlOnhOrdVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void removeOnhireStatusData(List<EqrCtrlOnhOrdVO> eqrCtrlOnhOrdVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhOrdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireBalanceDBDAOremoveOnhireStatusDSQL(), eqrCtrlOnhOrdVOs,null);
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
	}	 
	
	 /**
	 * On-Hire Status <br>
	 * 
	 * @param List<EqrCtrlOnhOrdQtyVO> eqrCtrlOnhOrdQtyVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void removeOnhireStatusQtyData(List<EqrCtrlOnhOrdQtyVO> eqrCtrlOnhOrdQtyVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhOrdQtyVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireBalanceDBDAOremoveOnhireStatusQtyDSQL(), eqrCtrlOnhOrdQtyVOs,null);
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
	}		

	 
	/**
	 *  RCC_CD, LCC_CD <br>
	 * 
	 * @param String loc_grp_cd
	 * @param String loc_cd
	 * @return CommonRsVO
	 * @throws DAOException
	 */
	public CommonRsVO searchRccLccCd(String loc_grp_cd, String loc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(loc_grp_cd != null){ 
				velParam.put("loc_grp_cd", loc_grp_cd);
			}
			if(loc_cd != null){
				param.put("loc_cd", loc_cd);
				velParam.put("loc_cd", loc_cd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireBalanceDBDAOsearchRccLccCdRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}	 
	
// 1006 (E)		

// 1041 (S)		

	/**
	 *  LT ST OW Plan & Approval <br>
	 * 
	 * @param PlanAndApprovalConditionVO planAndApprovalConditionVO
	 * @return List<PlanAndApprovalVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PlanAndApprovalVO> searchPlanAndApprovalData(PlanAndApprovalConditionVO planAndApprovalConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PlanAndApprovalVO> list = null;
		//CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(planAndApprovalConditionVO != null){ 
				Map<String, String> mapVO = planAndApprovalConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireBalanceDBDAOsearchPlanAndApprovalRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PlanAndApprovalVO.class);
			//commonRsVO.setDbRowset(dbRowset);
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
	 *  LT ST OW Plan & Approval - LSE_PLN_SEQ<br>
	 * 
	 * @param PlanAndApprovalVO planAndApprovalVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPlanAndApprovalSeqData(PlanAndApprovalVO planAndApprovalVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String seq = "";
		try{
			if(planAndApprovalVO != null){ 
				Map<String, String> mapVO = planAndApprovalVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireBalanceDBDAOsearchPlanAndApprovalSeqRSQL(), param, null);
			while(dbRowset.next()){
				seq = dbRowset.getString("SEQ");
            }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seq;
	}		 
	 
	 /**
	 * LT ST OW Plan & Approval <br>
	 * 
	 * @param EqrCtrlOnhPlnAproVO eqrCtrlOnhPlnAproVO
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String addPlanAndApprovalData(EqrCtrlOnhPlnAproVO eqrCtrlOnhPlnAproVO) throws DAOException,Exception {
		int insCnt = 0;
		DBRowSet dbRowset = null;
		String returnStr = "";
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhPlnAproVO != null){
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, String> mapVO = null; 
					
				mapVO = eqrCtrlOnhPlnAproVO.getColumnValues();
				param.putAll(mapVO);
				
				// new seq 
				String seq = "";
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireBalanceDBDAOsearchPlanAndApprovalSeqRSQL(), param, null);
				while(dbRowset.next()){
					seq = dbRowset.getString("SEQ");
	            }
				
				param.put("lse_pln_seq", seq);
				eqrCtrlOnhPlnAproVO.setLsePlnSeq(seq);
				
				// insert 
				insCnt = sqlExe.executeUpdate((ISQLTemplate)new OnhireBalanceDBDAOaddPlanAndApprovalCSQL(), param,null);
				if(insCnt== Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert No" + " SQL");
				}	
				
				returnStr = seq;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return returnStr;
	}	 	 	
	
	
	 /**
	 * LT ST OW Plan & Approval <br>
	 * 
	 * @param List<EqrCtrlOnhPlnAproVO> eqrCtrlOnhPlnAproVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyPlanAndApprovalData(List<EqrCtrlOnhPlnAproVO> eqrCtrlOnhPlnAproVOs) throws DAOException,Exception {
		int insCnt = 0;
		DBRowSet dbRowset = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhPlnAproVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
				
				Map<String, String> mapVO = null; 
				for(int i = 0; i < eqrCtrlOnhPlnAproVOs.size(); i++){
					EqrCtrlOnhPlnAproVO eqrCtrlOnhPlnAproVO = eqrCtrlOnhPlnAproVOs.get(i);
					
					mapVO = eqrCtrlOnhPlnAproVO.getColumnValues();
					param.putAll(mapVO);
					
					String chk = "";
					String rqstNo = "";
					String stsCd = "";
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireBalanceDBDAOcheckPlanAndApprovalRSQL(), param, null);
					while(dbRowset.next()){
						chk = dbRowset.getString("CHK");
						rqstNo = dbRowset.getString("LSE_RQST_NO");
						stsCd = dbRowset.getString("STS_CD");
		            }
					if(chk.equals("0")){ 
						//  Update data non-exist. Please retrieve again.
						throw new EventException(new ErrorHandler("EQR10028", new String[]{"Update data non-exist. Please retrieve again."}).getMessage());
					}else if(!rqstNo.equals("")){ // lse_rqst_no 
						//  Data was changed by others. Please retrieve again.
						throw new EventException(new ErrorHandler("EQR10028", new String[]{"Data was changed by others. Please retrieve again."}).getMessage());
					}else if(stsCd.equals("A")){ // Approved 
						//  Data was changed by others. Please retrieve again.
						throw new EventException(new ErrorHandler("EQR10028", new String[]{"Data was changed by others. Please retrieve again."}).getMessage());
					}
					
					// update 
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new OnhireBalanceDBDAOmodifyPlanAndApprovalUSQL(), param,null);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * LT ST OW Plan & Approval <br>
	 * 
	 * @param List<EqrCtrlOnhPlnAproVO> eqrCtrlOnhPlnAproVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void removePlanAndApprovalData(List<EqrCtrlOnhPlnAproVO> eqrCtrlOnhPlnAproVOs) throws DAOException,Exception {
		int insCnt = 0;
		DBRowSet dbRowset = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhPlnAproVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
				
				Map<String, String> mapVO = null; 
				for(int i = 0; i < eqrCtrlOnhPlnAproVOs.size(); i++){
					EqrCtrlOnhPlnAproVO eqrCtrlOnhPlnAproVO = eqrCtrlOnhPlnAproVOs.get(i);
					
					mapVO = eqrCtrlOnhPlnAproVO.getColumnValues();
					param.putAll(mapVO);
					
					String chk = "";
					String rqstNo = "";
					String stsCd = "";
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireBalanceDBDAOcheckPlanAndApprovalRSQL(), param, null);
					while(dbRowset.next()){
						chk = dbRowset.getString("CHK");
						rqstNo = dbRowset.getString("LSE_RQST_NO");
						stsCd = dbRowset.getString("STS_CD");
						
		            }
					if(chk.equals("0")){ 
						// Update data non-exist. Please retrieve again.
						throw new EventException(new ErrorHandler("EQR10028", new String[]{"Update data non-exist. Please retrieve again."}).getMessage());
					}else if(!rqstNo.equals("")){ // lse_rqst_no 
						// Data was changed by others. Please retrieve again.
						throw new EventException(new ErrorHandler("EQR10028", new String[]{"Data was changed by others. Please retrieve again."}).getMessage());
					}else if(stsCd.equals("A")){ // Approved 
						// Data was changed by others. Please retrieve again.
						throw new EventException(new ErrorHandler("EQR10028", new String[]{"Data was changed by others. Please retrieve again."}).getMessage());
					}
					
					// delete 
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new OnhireBalanceDBDAOremovePlanAndApprovalDSQL(), param,null);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * LT ST OW Plan & Approval <br>
	 * 
	 * @param List<EqrCtrlOnhPlnAproQtyVO> eqrCtrlOnhPlnAproQtyVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPlanAndApprovalQtyData(List<EqrCtrlOnhPlnAproQtyVO> eqrCtrlOnhPlnAproQtyVOs) throws DAOException,Exception {
		int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhPlnAproQtyVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
				
				Map<String, String> mapVO = null; 
				for(int i = 0; i < eqrCtrlOnhPlnAproQtyVOs.size(); i++){
					EqrCtrlOnhPlnAproQtyVO eqrCtrlOnhPlnAproQtyVO = eqrCtrlOnhPlnAproQtyVOs.get(i);
					
					mapVO = eqrCtrlOnhPlnAproQtyVO.getColumnValues();
					param.putAll(mapVO);
					
					// insert 수행
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new OnhireBalanceDBDAOaddPlanAndApprovalQtyCSQL(), param,null);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * LT ST OW Plan & Approval<br>
	 * 
	 * @param List<EqrCtrlOnhPlnAproQtyVO> eqrCtrlOnhPlnAproQtyVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyPlanAndApprovalQtyData(List<EqrCtrlOnhPlnAproQtyVO> eqrCtrlOnhPlnAproQtyVOs) throws DAOException,Exception {
		int insCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhPlnAproQtyVOs.size() > 0){
				Map<String, Object> param = new HashMap<String, Object>();
				
				Map<String, String> mapVO = null; 
				for(int i = 0; i < eqrCtrlOnhPlnAproQtyVOs.size(); i++){
					EqrCtrlOnhPlnAproQtyVO eqrCtrlOnhPlnAproQtyVO = eqrCtrlOnhPlnAproQtyVOs.get(i);
					
					mapVO = eqrCtrlOnhPlnAproQtyVO.getColumnValues();
					param.putAll(mapVO);
					
					// insert 
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new OnhireBalanceDBDAOmodifyPlanAndApprovalQtyUSQL(), param,null);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * LT ST OW Plan & Approval <br>
	 * 
	 * @param List<EqrCtrlOnhPlnAproQtyVO> eqrCtrlOnhPlnAproQtyVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void removePlanAndApprovalQtyData(List<EqrCtrlOnhPlnAproQtyVO> eqrCtrlOnhPlnAproQtyVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhPlnAproQtyVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OnhireBalanceDBDAOremovePlanAndApprovalQtyDSQL(), eqrCtrlOnhPlnAproQtyVOs,null);
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
	}		
	
	 /**
	 * LT ST OW Plan & Approval - Request/Request Cancel  <br>
	 * 
	 * @param EqrCtrlOnhPlnAproVO eqrCtrlOnhPlnAproVO
	 * @param String stsCd
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String modifyPlanAndApprovalRequestData(EqrCtrlOnhPlnAproVO eqrCtrlOnhPlnAproVO, String stsCd) throws DAOException,Exception {
		int insCnt = 0;
		DBRowSet dbRowset = null;
		String newRqstNo = "";
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrCtrlOnhPlnAproVO != null ){
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, String> mapVO = null; 

				mapVO = eqrCtrlOnhPlnAproVO.getColumnValues();
				param.putAll(mapVO);
				
				String chk = "";
				String rqstNo = "";
				String nowStsCd = "";
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireBalanceDBDAOcheckPlanAndApprovalRSQL(), param, null);
				while(dbRowset.next()){
					chk = dbRowset.getString("CHK");
					rqstNo = dbRowset.getString("LSE_RQST_NO");
					nowStsCd = dbRowset.getString("STS_CD");
	            }
				if(chk.equals("0")){ 
					//  Update data non-exist. Please retrieve again.
					throw new EventException(new ErrorHandler("EQR10028", new String[]{"Update data non-exist. Please retrieve again."}).getMessage());
				}else if(!rqstNo.equals("") && stsCd.equals("R")){ // lse_rqst_no 
					//  Data was changed by others. Please retrieve again.
					throw new EventException(new ErrorHandler("EQR10028", new String[]{"Data was changed by others. Please retrieve again."}).getMessage());
				}else if(rqstNo.equals("") && stsCd.equals("S")){ // lse_rqst_no 
					// Data was changed by others. Please retrieve again.
					throw new EventException(new ErrorHandler("EQR10028", new String[]{"Data was changed by others. Please retrieve again."}).getMessage());
				}else if(nowStsCd.equals("A")){ // Approved
					//  Data was changed by others. Please retrieve again.
					throw new EventException(new ErrorHandler("EQR10028", new String[]{"Data was changed by others. Please retrieve again."}).getMessage());
				}
				
				if(stsCd.equals("R")){ // Request 
					// Request no 
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OnhireBalanceDBDAOsearchPlanAndApprovalRequestNoRSQL(), param, null);
					while(dbRowset.next()){
						newRqstNo = dbRowset.getString("LSE_RQST_NO");
		            }
					param.put("lse_rqst_no", newRqstNo);
				}else{
					param.put("lse_rqst_no", "");
				}
				
				//  update 
				insCnt = sqlExe.executeUpdate((ISQLTemplate)new OnhireBalanceDBDAOmodifyPlanAndApprovalRequestUSQL(), param,null);
				if(insCnt== Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}	
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return newRqstNo;
	}	 	
// 1041 (E)	 
}