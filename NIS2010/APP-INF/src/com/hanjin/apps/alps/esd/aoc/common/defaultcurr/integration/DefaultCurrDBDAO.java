/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DefaultCurrDBDAO.java
*@FileTitle : Inland Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.basic.DefaultCurrBCImpl;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntDefaultCurrVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntInfoVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.InlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.RHQComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS EurInlandCostManageDBDAO <br>
 * - ALPS-CostManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see DefaultCurrBCImpl 참조
 * @since J2EE 1.6
 */
public class DefaultCurrDBDAO extends DBDAOSupport {
	
	/**
	 * Default Currency Creation - RHQ<br>
	 * 
	 * @return List<RHQComboVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RHQComboVO> searchRHQCombo() throws DAOException {
		DBRowSet dbRowset = null;
		List<RHQComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DefaultCurrDBDAOSearchRHQComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RHQComboVO .class);
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
	 * Default Currency Creation - Retrieve<br>
	 * 
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @return List<CntDefaultCurrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CntDefaultCurrVO> searchCntDefaultCurr(InlandCostConditionVO inlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntDefaultCurrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DefaultCurrDBDAOSearchCntDefaultCurrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntDefaultCurrVO .class);
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
	 * Default Currency Creation - Country Info<br>
	 * 
	 * @param String cntCd
	 * @return CntInfoVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CntInfoVO searchCntInfo(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DefaultCurrDBDAOSearchCntInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?new CntInfoVO():list.get(0);
	}
	 
	/**
	 * Default Currency Creation - Currency Name<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCurrNm(String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		String curr_nm = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("curr_cd", currCd);
			velParam.put("curr_cd", currCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DefaultCurrDBDAOSearchCurrNmRSQL(), param, velParam);
			if(dbRowset.next()){
				curr_nm = dbRowset.getString("curr_nm");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return curr_nm;
	}
	
	/**
	 * Default Currency Creation - Save - Create<br>
	 * 
	 * @param List<CntDefaultCurrVO> insModels
	 * @throws DAOException
	 */
	public void addCntDefaultCurrS(List<CntDefaultCurrVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DefaultCurrDBDAOMultiCntDefaultCurrCSQL(), insModels,null);
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
	 * Default Currency Creation의 Duplication Checking<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	public String searchDupChkCostTrfCurr(CntDefaultCurrVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dupFlg = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DefaultCurrDBDAOSearchDupChkCostTrfCurrRSQL(), param, velParam);
			if ( dbRowset!=null && dbRowset.next() ){
				dupFlg = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dupFlg;
	}
	
	/**
	 * Default Currency Creation - Save - Update<br>
	 * 
	 * @param List<CntDefaultCurrVO> updModels
	 * @throws DAOException 
	 */
	public void modifyCntDefaultCurrS(List<CntDefaultCurrVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DefaultCurrDBDAOMultiCntDefaultCurrUSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}		
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Default Currency Creation - Save - Delete<br>
	 * 
	 * @param List<CntDefaultCurrVO> delModels
	 * @throws DAOException
	 */
	public void removeCntDefaultCurrS(List<CntDefaultCurrVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DefaultCurrDBDAOMultiCntDefaultCurrDSQL(), delModels,null);
				for(int i = 0; i < 1; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Default Currency Creation - Currency Code 확인<br>
	 * 
	 * @param currCd
	 * @return
	 * @throws DAOException
	 */
	public String verifyCurrencyCode(String currCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String errFlg = "";
		 List<String> currCds = new ArrayList<String>();
		 
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 String dupFlg = "";
			 String[] currCdTmpArr =  currCd.split(",");
			 String[] currCdArr = new String[currCdTmpArr.length];
			 
			 int kdx = 0;
			 if(currCdTmpArr != null){
				 //Checking Duplication
				 for(int idx=0;idx<currCdTmpArr.length-1;idx++){
					 dupFlg = "N";
					 for(int jdx=idx+1;jdx<currCdTmpArr.length;jdx++){
						 if( currCdTmpArr[idx].equals(currCdTmpArr[jdx]) ){
							 dupFlg = "Y";
						 }
					 }
					 if( "N".equals(dupFlg) ){
						 currCdArr[kdx] = currCdTmpArr[idx];
						 kdx++;
					 }
				 }
				 currCdArr[kdx] = currCdTmpArr[currCdTmpArr.length-1];
				 
				 
				 for(int idx=0;idx<currCdArr.length;idx++){
					 if( !"".equals(currCdArr[idx]) && currCdArr[idx] != null ){
						 currCds.add(currCdArr[idx].toString());
					 }
				 }
				 
				 if(currCds.size()>0){
					 velParam.put("curr_cd_arr", currCds);						
				 }
			 }
			 
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DefaultCurrDBDAOVerifyCurrencyCodeRSQL(), null, velParam);
			 if(dbRowset.next()){
				 errFlg = dbRowset.getString("ERR_FLG");
			 }
		 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return errFlg;
	}
	
	/**
	 * Default Currency Creation - Country Code 확인<br>
	 * 
	 * @param String rhqCd
	 * @param String cntCd
	 * @return
	 * @throws DAOException
	 */
	public String verifyCountryCode(String rhqCd, String cntCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String knt = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 param.put("rhq_cd", rhqCd);
			 param.put("cnt_cd", cntCd);
			 velParam.put("rhq_cd", rhqCd);
			 velParam.put("cnt_cd", cntCd);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DefaultCurrDBDAOVerifyCountryCodeRSQL(), param, velParam);
			 if(dbRowset.next()){
				 knt = dbRowset.getString("KNT");
			 }
		 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return knt;
	}
	


}