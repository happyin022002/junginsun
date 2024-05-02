/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaInlandCostManageDBDAO.java
*@FileTitle : Inland Cost Manage(SHA/SIN)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
*=========================================================
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
* 2014.03.17 서미진 [CHM-201429382] 1. DG, Overweight adjust한 data만 update 한다. 
									2. Confirm시 adjust 하지 않는 DG, Overweight transmode를 삭제한다.
									3. Confirm cancel시 삭제된 DG, Overweight transmode를 넣어준다.
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostDetailVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlandCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaStatusMonitorVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS AsiaInlandCostManageDBDAO <br>
 * - ALPS-CostManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see AsiaCostManageBCImpl 참조
 * @since J2EE 1.6
 */
public class AsiaInlandCostManageDBDAO extends DBDAOSupport {

	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @return List<AsiaInlandCostVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AsiaInlandCostVO> searchInlandCost(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaInlandCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlandCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaInlandCostVO .class);
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
	 * Inland Cost Management tab DG - Retrieve<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @return List<AsiaInlandCostSpecialCargoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AsiaInlandCostSpecialCargoVO> searchInlandCostSpecialCargo(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaInlandCostSpecialCargoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlandCostSpecialCargoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaInlandCostSpecialCargoVO .class);
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
	  * Inland Cost Management tab Reefer - Retrieve<br>
	  * 
	  * @param asiaInlandCostConditionVO
	  * @return
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<AsiaInlandCostVO> searchInlandCostReefer(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AsiaInlandCostVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(asiaInlandCostConditionVO != null){
				 Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlandCostReeferRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaInlandCostVO .class);
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
	 * Inland Cost Management - Cost Tariff No<br>
	 * 
	 * @param String inCntCd
	 * @return List<AsiaInlandCostTariffNoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AsiaInlandCostTariffNoVO> searchInlandCostTariffNo(String inCntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaInlandCostTariffNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cnt_cd", inCntCd);
			velParam.put("in_cnt_cd", inCntCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlandCostTariffNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaInlandCostTariffNoVO .class);
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
	 * Inland Cost Management - Country Code 확인<br>
	 * 
	 * @param String inCntCd
	 * @return String
	 * @throws DAOException
	 */
	public String verifyCountryCode(String inCntCd) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cnt_cd", inCntCd);
			velParam.put("in_cnt_cd", inCntCd);

			List<String> cntCds = new ArrayList<String>();
			String[] arrEqNo =  inCntCd.split(",");
			for(int i = 0; i < arrEqNo.length; i ++){
				cntCds.add(arrEqNo[i]);
			}
			velParam.put("cntCds", cntCds);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOVerifyCountryCodeRSQL(), param, velParam);
			if(dbRowset.next()){
				cnt = dbRowset.getString("cnt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	 
	/**
	 * Inland Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param String inCostTrfNo
	 * @return AsiaInlandCostTariffInfoVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public AsiaInlandCostTariffInfoVO searchInlandCostTariffInfo(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaInlandCostTariffInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlandCostTariffInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaInlandCostTariffInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?new AsiaInlandCostTariffInfoVO():list.get(0);
	}

	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param List<AsiaInlandCostVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCost(List<AsiaInlandCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaInlandCostManageDBDAOMultiInlandCostUSQL(), updModels, null);
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
	 * Inland Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void multiInlandCostHdr(AsiaInlandCostConditionVO asiaInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AsiaInlandCostManageDBDAOMultiInlandCostHdrUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
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
	 * Inland Cost Management tab Reefer - 추가<br>
	 * 
	 * @param insModels
	 * @throws EventException
	 * @throws DAOException
	 */
	public void addInlandCostReefer(List<AsiaInlandCostVO> insModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaInlandCostManageDBDAOAddInlandCostReeferCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Inland Cost Management tab Reefer - 수정<br>
	 * 
	 * @param updModels
	 * @throws EventException
	 * @throws DAOException
	 */
	public void modifyInlandCostReefer(List<AsiaInlandCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaInlandCostManageDBDAOModifyInlandCostReeferUSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * Inland Cost Management tab Reefer - 삭제<br>
	 * 
	 * @param updModels
	 * @throws EventException
	 * @throws DAOException
	 */
	public void removeInlandCostReefer(List<AsiaInlandCostVO> updModels) throws EventException, DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try	{
			if(updModels != null){
				int result = 0;
				for (int i = 0; i < updModels.size(); i++) {
					if (updModels.get(i) != null) {
						Map<String, String> mapVO = updModels.get(i).getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					SQLExecuter sqlExe = new SQLExecuter("");
					result = sqlExe.executeUpdate((ISQLTemplate) new AsiaInlandCostManageDBDAORemoveInlandCostReeferUSQL(), param, velParam);
					if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

					param.clear();
					velParam.clear();
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
	 * Inland Cost Management - verifyInlandCostConfirm<br>
	 * 
	 * @param String inCostTrfNo
	 * @return String
	 * @throws DAOException
	 */
	public String verifyInlandCostConfirm(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOVerifyInlandCostConfirmRSQL(), param, velParam);
			if(dbRowset.next()){
				cnt = dbRowset.getString("cnt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * Inland Cost Management - Location Group 에 대한 Verify <br>
	 * 
	 * @param inCostTrfNo
	 * @return
	 * @throws DAOException
	 */
	public String verifyInlandCostLocGrpCnt(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOVerifyInlandCostLocGrpCntRSQL(), param, velParam);
			if(dbRowset.next()){
				cnt = dbRowset.getString("cnt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}

	/**
	 * Inland Cost Management - confirmInlandCostPreVer<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmInlandCostPreVer(AsiaInlandCostConditionVO asiaInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AsiaInlandCostManageDBDAOConfirmInlandCostPreVerUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
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
	 * Inland Cost Management - confirmInlandCost<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmInlandCost(AsiaInlandCostConditionVO asiaInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AsiaInlandCostManageDBDAOConfirmInlandCostUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
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
	 * ESD_AOC_3202 : Confirm Cancel
	 * Inland Cost Management tab Special - Create<br>
	 * 
	 * @param AsiaInlandCostConditionVO inlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addInlandCostSpecialCargoS(AsiaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws DAOException {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			int result = 0;
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("cre_usr_id", account.getUsr_id());			
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AsiaInlandCostManageDBDAOMultiInlandCostSpecialCargoCSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
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
	 * Inland Cost Management tab Special - Save - Update<br>
	 * 
	 * @param List<AsiaInlandCostSpecialCargoVO> updModels
	 * @throws DAOException 
	 */
	public void modifyInlandCostSpecialCargoS(List<AsiaInlandCostSpecialCargoVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaInlandCostManageDBDAOMultiInlandCostSpecialCargoUSQL(), updModels, null);
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
	 * ESD_AOC_3202 : Confirm 
	 * Inland Cost Management tab Special - Delete<br>
	 * 
	 * @param AsiaInlandCostConditionVO inlandCostConditionVO
	 * @throws DAOException
	 */
	public void removeInlandCostSpecialCargoS(AsiaInlandCostConditionVO inlandCostConditionVO) throws DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			int result = 0;
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();			
				param.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AsiaInlandCostManageDBDAOMultiInlandCostSpecialCargoDSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
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
	 * Inland Cost Management – Route Detail  - Retrieve<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @return List<AsiaInlandCostDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AsiaInlandCostDetailVO> searchInlandCostDetail(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaInlandCostDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlandCostDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaInlandCostDetailVO .class);
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
	 * Inland Cost Management – Route Detail  - Apply Select<br>
	 * 
	 * @param List<AsiaInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailSelect(List<AsiaInlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaInlandCostManageDBDAOMultiInlandCostDetailSelectUSQL(), updModels, null);
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
	 * Inland Cost Management – Route Detail - Delete Check<br>
	 * 
	 * @param List<AsiaInlandCostDetailVO> updModels
	 * @return String
	 * @throws DAOException
	 */
	public String searchInlandCostDetailDeleteCheck(List<AsiaInlandCostDetailVO> updModels) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = "";

		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(updModels.size() > 0){
				List<String> condtions = new ArrayList<String>();
				String strCondtion = "";

				for(int i=0; i<updModels.size(); i++){
					strCondtion = "";
					strCondtion = "('"+updModels.get(i).getPortNodCd()+"', '"+updModels.get(i).getHubNodCd()+"', '"+updModels.get(i).getLocNodCd()+"', '"+updModels.get(i).getRcvDeTermCd()+"')";
					condtions.add(strCondtion);
				}
				velParam.put("condtions", condtions);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlandCostDetailDeleteCheckRSQL(), null, velParam);
			if(dbRowset.next()){
				cnt = dbRowset.getString("cnt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * Inland Cost Management – Route Detail - Delete<br>
	 * 
	 * @param List<AsiaInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailDelete(List<AsiaInlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaInlandCostManageDBDAOMultiInlandCostDetailDeleteUSQL(), updModels, null);
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
	 * Inland Cost Management – Route Detail - Delete 후 1st Row Select<br>
	 * 
	 * @param List<AsiaInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetail1stSelect(List<AsiaInlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(updModels.size() > 0){
				param.put("cost_trf_no", updModels.get(0).getCostTrfNo());
				
				List<String> condtions = new ArrayList<String>();
				String strCostSelRoutFlg = "";
				String strCondtion = "";

				for(int i=0; i<updModels.size(); i++){
					if(updModels.get(i).getCostSelRoutFlg().equals("1")){
						strCostSelRoutFlg = "Y";
					}else{
						strCostSelRoutFlg = "N";
					}
					strCondtion = "";
					strCondtion = "('"+updModels.get(i).getCostRoutGrpNo()+"', '"+strCostSelRoutFlg+"')";
					condtions.add(strCondtion);
				}
				velParam.put("condtions", condtions);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AsiaInlandCostManageDBDAOMultiInlandCostDetail1stSelectUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");			
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
	 * Inland Cost Management – Route Detail  - Apply Rest<br>
	 * 
	 * @param List<AsiaInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailRest(List<AsiaInlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaInlandCostManageDBDAOMultiInlandCostDetailRestUSQL(), updModels, null);
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
	 * Inland Cost Management – Cost Detail  - Retrieve.<br>
	 * 
	 * @param inputVo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AsiaInlandCostAccountVO> searchInlandCostAccount(AsiaInlandCostAccountVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaInlandCostAccountVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inputVo != null){
				Map<String, String> mapVO = inputVo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlandCostAccountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaInlandCostAccountVO .class);
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
	 * Cost & Guideline Tariff Status Monitoring - Retrieve.<br>
	 * 
	 * @param inputVo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AsiaStatusMonitorVO> searchStatusMonitor(AsiaStatusMonitorVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaStatusMonitorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inputVo != null){
				Map<String, String> mapVO = inputVo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchStatusMonitorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaStatusMonitorVO .class);
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
	 * SHQ Office 판단 조회<br>
	 * 
	 * @param usrOfcCd
	 * @return
	 * @throws DAOException
	 */
	public String searchShqOfcFlg(String usrOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String shqFlg = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("usr_ofc_cd", usrOfcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchShqOfcFlgRSQL(), param, null);
			if(dbRowset.next()){
				shqFlg = dbRowset.getString("shq_flg");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return shqFlg;
	}
	
	/**
	 * Inland Cost Inquiry tab Dry - Retrieve<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @return List<AsiaInlnadCostInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AsiaInlnadCostInquiryVO> searchInlnadCostInquiry(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaInlnadCostInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(asiaInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  asiaInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"".equals(asiaInlandCostConditionVO.getHubNodCd())){
					List<String> hubNodCds = new ArrayList<String>();
					String[] arrhubNodCd =  asiaInlandCostConditionVO.getHubNodCd().split(",");
					for(int i = 0; i < arrhubNodCd.length; i ++){
						hubNodCds.add(arrhubNodCd[i]);
					}
					velParam.put("hubNodCds", hubNodCds);
				}
				
				if(!"".equals(asiaInlandCostConditionVO.getPortNodCd())){
					List<String> portNodCds = new ArrayList<String>();
					String[] arrportNodCd =  asiaInlandCostConditionVO.getPortNodCd().split(",");
					for(int i = 0; i < arrportNodCd.length; i ++){
						portNodCds.add(arrportNodCd[i]);
					}
					velParam.put("portNodCds", portNodCds);
				}
				
				if(!"ALL".equals(asiaInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  asiaInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(asiaInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  asiaInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(asiaInlandCostConditionVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  asiaInlandCostConditionVO.getCostFactorCd().split(",");
					for(int i = 0; i < arrcostFactorCd.length; i ++){
						
						if("F2".equals(arrcostFactorCd[i])){
							fullTrans20 = "Y";
						}else if("F4".equals(arrcostFactorCd[i])){
							fullTrans40 = "Y";
						}else if("T2".equals(arrcostFactorCd[i])){
							tmnl20 = "Y";
						}else if("T4".equals(arrcostFactorCd[i])){
							tmnl40 = "Y";
						}else if("E2".equals(arrcostFactorCd[i])){
							empty20 = "Y";
						}else if("E4".equals(arrcostFactorCd[i])){
							empty40 = "Y";
						}
						
						costFactorCds.add(arrcostFactorCd[i]);
					}
					velParam.put("costFactorCds", costFactorCds);
					velParam.put("fullTrans20", fullTrans20);
					velParam.put("fullTrans40", fullTrans40);
					velParam.put("tmnl20", tmnl20);
					velParam.put("tmnl40", tmnl40);
					velParam.put("empty20", empty20);
					velParam.put("empty40", empty40);
				}
				
				if(!"ALL".equals(asiaInlandCostConditionVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  asiaInlandCostConditionVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlnadCostInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaInlnadCostInquiryVO .class);
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
		 * Inland Cost Inquiry tab Dry - Retrieve<br>
		 * 
		 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
		 * @return List<AsiaInlnadCostInquiryVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<AsiaInlnadCostInquiryVO> searchInlnadCostRefInquiry(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<AsiaInlnadCostInquiryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(asiaInlandCostConditionVO != null){
					Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);

					if(!"".equals(asiaInlandCostConditionVO.getLocNodCd())){
						List<String> locNodCds = new ArrayList<String>();
						String[] arrlocNodCd =  asiaInlandCostConditionVO.getLocNodCd().split(",");
						for(int i = 0; i < arrlocNodCd.length; i ++){
							locNodCds.add(arrlocNodCd[i]);
						}
						velParam.put("locNodCds", locNodCds);
					}
					
					if(!"".equals(asiaInlandCostConditionVO.getHubNodCd())){
						List<String> hubNodCds = new ArrayList<String>();
						String[] arrhubNodCd =  asiaInlandCostConditionVO.getHubNodCd().split(",");
						for(int i = 0; i < arrhubNodCd.length; i ++){
							hubNodCds.add(arrhubNodCd[i]);
						}
						velParam.put("hubNodCds", hubNodCds);
					}
					
					if(!"".equals(asiaInlandCostConditionVO.getPortNodCd())){
						List<String> portNodCds = new ArrayList<String>();
						String[] arrportNodCd =  asiaInlandCostConditionVO.getPortNodCd().split(",");
						for(int i = 0; i < arrportNodCd.length; i ++){
							portNodCds.add(arrportNodCd[i]);
						}
						velParam.put("portNodCds", portNodCds);
					}
					
					if(!"ALL".equals(asiaInlandCostConditionVO.getTrspCrrModCd())){
						List<String> trspCrrModCds = new ArrayList<String>();
						String[] arrtrspCrrModCd =  asiaInlandCostConditionVO.getTrspCrrModCd().split(",");
						for(int i = 0; i < arrtrspCrrModCd.length; i ++){
							trspCrrModCds.add(arrtrspCrrModCd[i]);
						}
						velParam.put("trspCrrModCds", trspCrrModCds);
					}

					if(!"".equals(asiaInlandCostConditionVO.getCostTrfNo())){
						List<String> costTrfNos = new ArrayList<String>();
						String[] arrcostTrfNo =  asiaInlandCostConditionVO.getCostTrfNo().split(",");
						for(int i = 0; i < arrcostTrfNo.length; i ++){
							costTrfNos.add(arrcostTrfNo[i]);
						}
						velParam.put("costTrfNos", costTrfNos);
					}

					if(!"ALL".equals(asiaInlandCostConditionVO.getCostFactorCd())){
						String fullTrans20 = "N";
						String fullTrans40 = "N";
						String tmnl20 = "N";
						String tmnl40 = "N";
						String empty20 = "N";
						String empty40 = "N";
						
						List<String> costFactorCds = new ArrayList<String>();
						String[] arrcostFactorCd =  asiaInlandCostConditionVO.getCostFactorCd().split(",");
						for(int i = 0; i < arrcostFactorCd.length; i ++){
							
							if("F2".equals(arrcostFactorCd[i])){
								fullTrans20 = "Y";
							}else if("F4".equals(arrcostFactorCd[i])){
								fullTrans40 = "Y";
							}else if("T2".equals(arrcostFactorCd[i])){
								tmnl20 = "Y";
							}else if("T4".equals(arrcostFactorCd[i])){
								tmnl40 = "Y";
							}else if("E2".equals(arrcostFactorCd[i])){
								empty20 = "Y";
							}else if("E4".equals(arrcostFactorCd[i])){
								empty40 = "Y";
							}
							
							costFactorCds.add(arrcostFactorCd[i]);
						}
						velParam.put("costFactorCds", costFactorCds);
						velParam.put("fullTrans20", fullTrans20);
						velParam.put("fullTrans40", fullTrans40);
						velParam.put("tmnl20", tmnl20);
						velParam.put("tmnl40", tmnl40);
						velParam.put("empty20", empty20);
						velParam.put("empty40", empty40);
					}
					
					if(!"ALL".equals(asiaInlandCostConditionVO.getSysSrcCd())){
						List<String> sysSrcCds = new ArrayList<String>();
						String[] arrsysSrcCd =  asiaInlandCostConditionVO.getSysSrcCd().split(",");
						for(int i = 0; i < arrsysSrcCd.length; i ++){
							sysSrcCds.add(arrsysSrcCd[i]);
						}
						velParam.put("sysSrcCds", sysSrcCds);
					}
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlandCostRefInquiryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaInlnadCostInquiryVO .class);
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
	 * Inland Cost Inquiry tab Special - Retrieve<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @return List<AsiaInlnadCostSpeInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AsiaInlnadCostSpeInquiryVO> searchInlnadCostSpeInquiry(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaInlnadCostSpeInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(asiaInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  asiaInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						if(arrlocNodCd[i].length() > 1){
							locNodCds.add(arrlocNodCd[i].substring(0,2));
						}else{
							locNodCds.add(arrlocNodCd[i]);
						}
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"ALL".equals(asiaInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  asiaInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(asiaInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  asiaInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlnadCostSpeInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaInlnadCostSpeInquiryVO .class);
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
	 * Inland Cost Inquiry tab Dry - Down Excel without Displaying<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInlnadCostInquiryExcel(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(asiaInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  asiaInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"".equals(asiaInlandCostConditionVO.getHubNodCd())){
					List<String> hubNodCds = new ArrayList<String>();
					String[] arrhubNodCd =  asiaInlandCostConditionVO.getHubNodCd().split(",");
					for(int i = 0; i < arrhubNodCd.length; i ++){
						hubNodCds.add(arrhubNodCd[i]);
					}
					velParam.put("hubNodCds", hubNodCds);
				}
				
				if(!"".equals(asiaInlandCostConditionVO.getPortNodCd())){
					List<String> portNodCds = new ArrayList<String>();
					String[] arrportNodCd =  asiaInlandCostConditionVO.getPortNodCd().split(",");
					for(int i = 0; i < arrportNodCd.length; i ++){
						portNodCds.add(arrportNodCd[i]);
					}
					velParam.put("portNodCds", portNodCds);
				}
				
				if(!"ALL".equals(asiaInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  asiaInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(asiaInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  asiaInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(asiaInlandCostConditionVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  asiaInlandCostConditionVO.getCostFactorCd().split(",");
					for(int i = 0; i < arrcostFactorCd.length; i ++){
						
						if("F2".equals(arrcostFactorCd[i])){
							fullTrans20 = "Y";
						}else if("F4".equals(arrcostFactorCd[i])){
							fullTrans40 = "Y";
						}else if("T2".equals(arrcostFactorCd[i])){
							tmnl20 = "Y";
						}else if("T4".equals(arrcostFactorCd[i])){
							tmnl40 = "Y";
						}else if("E2".equals(arrcostFactorCd[i])){
							empty20 = "Y";
						}else if("E4".equals(arrcostFactorCd[i])){
							empty40 = "Y";
						}
						
						costFactorCds.add(arrcostFactorCd[i]);
					}
					velParam.put("costFactorCds", costFactorCds);
					velParam.put("fullTrans20", fullTrans20);
					velParam.put("fullTrans40", fullTrans40);
					velParam.put("tmnl20", tmnl20);
					velParam.put("tmnl40", tmnl40);
					velParam.put("empty20", empty20);
					velParam.put("empty40", empty40);
				}
				
				if(!"ALL".equals(asiaInlandCostConditionVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  asiaInlandCostConditionVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlnadCostInquiryRSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Inland Cost Inquiry tab Reefer - Down Excel without Displaying<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInlnadCostRefInquiryExcel(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(asiaInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  asiaInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"".equals(asiaInlandCostConditionVO.getHubNodCd())){
					List<String> hubNodCds = new ArrayList<String>();
					String[] arrhubNodCd =  asiaInlandCostConditionVO.getHubNodCd().split(",");
					for(int i = 0; i < arrhubNodCd.length; i ++){
						hubNodCds.add(arrhubNodCd[i]);
					}
					velParam.put("hubNodCds", hubNodCds);
				}
				
				if(!"".equals(asiaInlandCostConditionVO.getPortNodCd())){
					List<String> portNodCds = new ArrayList<String>();
					String[] arrportNodCd =  asiaInlandCostConditionVO.getPortNodCd().split(",");
					for(int i = 0; i < arrportNodCd.length; i ++){
						portNodCds.add(arrportNodCd[i]);
					}
					velParam.put("portNodCds", portNodCds);
				}
				
				if(!"ALL".equals(asiaInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  asiaInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(asiaInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  asiaInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(asiaInlandCostConditionVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  asiaInlandCostConditionVO.getCostFactorCd().split(",");
					for(int i = 0; i < arrcostFactorCd.length; i ++){
						
						if("F2".equals(arrcostFactorCd[i])){
							fullTrans20 = "Y";
						}else if("F4".equals(arrcostFactorCd[i])){
							fullTrans40 = "Y";
						}else if("T2".equals(arrcostFactorCd[i])){
							tmnl20 = "Y";
						}else if("T4".equals(arrcostFactorCd[i])){
							tmnl40 = "Y";
						}else if("E2".equals(arrcostFactorCd[i])){
							empty20 = "Y";
						}else if("E4".equals(arrcostFactorCd[i])){
							empty40 = "Y";
						}
						
						costFactorCds.add(arrcostFactorCd[i]);
					}
					velParam.put("costFactorCds", costFactorCds);
					velParam.put("fullTrans20", fullTrans20);
					velParam.put("fullTrans40", fullTrans40);
					velParam.put("tmnl20", tmnl20);
					velParam.put("tmnl40", tmnl40);
					velParam.put("empty20", empty20);
					velParam.put("empty40", empty40);
				}
				
				if(!"ALL".equals(asiaInlandCostConditionVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  asiaInlandCostConditionVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlandCostRefInquiryRSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Inland Cost Inquiry tab Special - Down Excel without Displaying<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInlnadCostSpeInquiryExcel(AsiaInlandCostConditionVO asiaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"ALL".equals(asiaInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  asiaInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(asiaInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  asiaInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlnadCostSpeInquiryRSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Inland Cost Management - searchInlandCostGuidelineExist<br>
	 * 
	 * @param String inCostTrfNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchInlandCostGuidelineExist(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		String existFlg = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOSearchInlandCostGuidelineExistRSQL(), param, velParam);
			if(dbRowset.next()){
				existFlg = dbRowset.getString("exist_flg");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return existFlg;
	}
	
	/**
	 * Inland Cost Management - modifyInlandCostMgtCfmCxl<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void modifyInlandCostMgtCfmCxl(AsiaInlandCostConditionVO asiaInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AsiaInlandCostManageDBDAOModifyInlandCostMgtCfmCxlUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
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
	 * Inland Cost Management - modifyInlandCostMgtCfmCxlPreVer<br>
	 * 
	 * @param AsiaInlandCostConditionVO asiaInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void modifyInlandCostMgtCfmCxlPreVer(AsiaInlandCostConditionVO asiaInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(asiaInlandCostConditionVO != null){
				Map<String, String> mapVO = asiaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AsiaInlandCostManageDBDAOModifyInlandCostMgtCfmCxlPreVerUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
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
	 * @param trfNo
	 * @return
	 * @throws DAOException
	 */
	public String verifyInlndCostTrfNo(String trfNo) throws DAOException {
		 DBRowSet dbRowset = null;
		 String errFlg = "";
		 List<String> trfNos = new ArrayList<String>();
		 
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 String dupFlg = "";
			 String[] trfNoTmpArr =  trfNo.split(",");
			 String[] trfNoArr = new String[trfNoTmpArr.length];
			 
			 int kdx = 0;
			 if(trfNoTmpArr != null){
				 //Checking Duplication
				 for(int idx=0;idx<trfNoTmpArr.length-1;idx++){
					 dupFlg = "N";
					 for(int jdx=idx+1;jdx<trfNoTmpArr.length;jdx++){
						 if( trfNoTmpArr[idx].equals(trfNoTmpArr[jdx]) ){
							 dupFlg = "Y";
						 }
					 }
					 if( "N".equals(dupFlg) ){
						 trfNoArr[kdx] = trfNoTmpArr[idx];
						 kdx++;
					 }
				 }
				 trfNoArr[kdx] = trfNoTmpArr[trfNoTmpArr.length-1];
				 
				 
				 for(int idx=0;idx<trfNoArr.length;idx++){
					 if( !"".equals(trfNoArr[idx]) && trfNoArr[idx] != null ){
						 trfNos.add(trfNoArr[idx].toString());
					 }
				 }
				 
				 if(trfNos.size()>0){
					 velParam.put("trf_no_arr", trfNos);						
				 }
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaInlandCostManageDBDAOVerifyInlndCostTrfNoRSQL(), null, velParam);
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

}