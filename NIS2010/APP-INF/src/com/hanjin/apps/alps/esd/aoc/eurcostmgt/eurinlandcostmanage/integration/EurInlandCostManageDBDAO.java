/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurInlandCostManageDBDAO.java
*@FileTitle : Inland Cost Manage(EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
* 2014.03.17 서미진 [CHM-201429382] 1. DG, Overweight adjust한 data만 update 한다. 
									2. Confirm시 adjust 하지 않는 DG, Overweight transmode를 삭제한다.
									3. Confirm cancel시 삭제된 DG, Overweight transmode를 넣어준다.
* 2015.02.03 전지예 [CHM-201533794] 45' Cost 추가
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostDetailVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlandCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurInlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo.EurStatusMonitorVO;
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
 * ALPS EurInlandCostManageDBDAO <br>
 * - ALPS-CostManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see EurCostManageBCImpl 참조
 * @since J2EE 1.6
 */
public class EurInlandCostManageDBDAO extends DBDAOSupport {

	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @return List<EurInlandCostVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EurInlandCostVO> searchInlandCost(EurInlandCostConditionVO eurInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurInlandCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlandCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurInlandCostVO .class);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @return List<EurInlandCostSpecialCargoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EurInlandCostSpecialCargoVO> searchInlandCostSpecialCargo(EurInlandCostConditionVO eurInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurInlandCostSpecialCargoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlandCostSpecialCargoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurInlandCostSpecialCargoVO .class);
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
	  * @param eurInlandCostConditionVO
	  * @return
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EurInlandCostVO> searchInlandCostReefer(EurInlandCostConditionVO eurInlandCostConditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EurInlandCostVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(eurInlandCostConditionVO != null){
				 Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlandCostReeferRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurInlandCostVO .class);
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
	 * @return List<EurInlandCostTariffNoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EurInlandCostTariffNoVO> searchInlandCostTariffNo(String inCntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurInlandCostTariffNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cnt_cd", inCntCd);
			velParam.put("in_cnt_cd", inCntCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlandCostTariffNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurInlandCostTariffNoVO .class);
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOVerifyCountryCodeRSQL(), param, velParam);
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
	 * @return EurInlandCostTariffInfoVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public EurInlandCostTariffInfoVO searchInlandCostTariffInfo(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurInlandCostTariffInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlandCostTariffInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurInlandCostTariffInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?new EurInlandCostTariffInfoVO():list.get(0);
	}

	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param List<EurInlandCostVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCost(List<EurInlandCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EurInlandCostManageDBDAOMultiInlandCostUSQL(), updModels, null);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void multiInlandCostHdr(EurInlandCostConditionVO eurInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new EurInlandCostManageDBDAOMultiInlandCostHdrUSQL(), param, velParam);
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
	public void addInlandCostReefer(List<EurInlandCostVO> insModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EurInlandCostManageDBDAOAddInlandCostReeferCSQL(), insModels, null);
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
	public void modifyInlandCostReefer(List<EurInlandCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EurInlandCostManageDBDAOModifyInlandCostReeferUSQL(), updModels, null);
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
	public void removeInlandCostReefer(List<EurInlandCostVO> updModels) throws EventException, DAOException {
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
					result = sqlExe.executeUpdate((ISQLTemplate) new EurInlandCostManageDBDAORemoveInlandCostReeferUSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOVerifyInlandCostConfirmRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOVerifyInlandCostLocGrpCntRSQL(), param, velParam);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmInlandCostPreVer(EurInlandCostConditionVO eurInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new EurInlandCostManageDBDAOConfirmInlandCostPreVerUSQL(), param, velParam);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmInlandCost(EurInlandCostConditionVO eurInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new EurInlandCostManageDBDAOConfirmInlandCostUSQL(), param, velParam);
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
	 * ESD_AOC_3002 : Confirm Cancel
	 * Inland Cost Management tab Special - Create<br>
	 * 
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addInlandCostSpecialCargoS(EurInlandCostConditionVO eurInlandCostConditionVO, SignOnUserAccount account) throws DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			int result = 0;
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("cre_usr_id", account.getUsr_id());
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new EurInlandCostManageDBDAOMultiInlandCostSpecialCargoCSQL(), param, null);
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
	 * @param List<EurInlandCostSpecialCargoVO> updModels
	 * @throws DAOException 
	 */
	public void modifyInlandCostSpecialCargoS(List<EurInlandCostSpecialCargoVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EurInlandCostManageDBDAOMultiInlandCostSpecialCargoUSQL(), updModels, null);
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
	 * ESD_AOC_3002 : Confirm 
	 * Inland Cost Management tab Special - Delete<br>
	 * 
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @throws DAOException
	 */
	public void removeInlandCostSpecialCargoS(EurInlandCostConditionVO eurInlandCostConditionVO) throws DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			int result = 0;
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO.getColumnValues();			
				param.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new EurInlandCostManageDBDAOMultiInlandCostSpecialCargoDSQL(), param, null);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @return List<EurInlandCostDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EurInlandCostDetailVO> searchInlandCostDetail(EurInlandCostConditionVO eurInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurInlandCostDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlandCostDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurInlandCostDetailVO .class);
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
	 * @param List<EurInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailSelect(List<EurInlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EurInlandCostManageDBDAOMultiInlandCostDetailSelectUSQL(), updModels, null);
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
	 * @param List<EurInlandCostDetailVO> updModels
	 * @return String
	 * @throws DAOException
	 */
	public String searchInlandCostDetailDeleteCheck(List<EurInlandCostDetailVO> updModels) throws DAOException {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlandCostDetailDeleteCheckRSQL(), null, velParam);
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
	 * @param List<EurInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailDelete(List<EurInlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EurInlandCostManageDBDAOMultiInlandCostDetailDeleteUSQL(), updModels, null);
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
	 * @param List<EurInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetail1stSelect(List<EurInlandCostDetailVO> updModels) throws EventException, DAOException {
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
				result = sqlExe.executeUpdate((ISQLTemplate)new EurInlandCostManageDBDAOMultiInlandCostDetail1stSelectUSQL(), param, velParam);
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
	 * @param List<EurInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailRest(List<EurInlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EurInlandCostManageDBDAOMultiInlandCostDetailRestUSQL(), updModels, null);
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
	public List<EurInlandCostAccountVO> searchInlandCostAccount(EurInlandCostAccountVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurInlandCostAccountVO> list = null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlandCostAccountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurInlandCostAccountVO .class);
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
	public List<EurStatusMonitorVO> searchStatusMonitor(EurStatusMonitorVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurStatusMonitorVO> list = null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchStatusMonitorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurStatusMonitorVO .class);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchShqOfcFlgRSQL(), param, null);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @return List<EurInlnadCostInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EurInlnadCostInquiryVO> searchInlnadCostInquiry(EurInlandCostConditionVO eurInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurInlnadCostInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(eurInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  eurInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"".equals(eurInlandCostConditionVO.getHubNodCd())){
					List<String> hubNodCds = new ArrayList<String>();
					String[] arrhubNodCd =  eurInlandCostConditionVO.getHubNodCd().split(",");
					for(int i = 0; i < arrhubNodCd.length; i ++){
						hubNodCds.add(arrhubNodCd[i]);
					}
					velParam.put("hubNodCds", hubNodCds);
				}
				
				if(!"".equals(eurInlandCostConditionVO.getPortNodCd())){
					List<String> portNodCds = new ArrayList<String>();
					String[] arrportNodCd =  eurInlandCostConditionVO.getPortNodCd().split(",");
					for(int i = 0; i < arrportNodCd.length; i ++){
						portNodCds.add(arrportNodCd[i]);
					}
					velParam.put("portNodCds", portNodCds);
				}
				
				if(!"ALL".equals(eurInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  eurInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(eurInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  eurInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(eurInlandCostConditionVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					// 45' Cost 추가
					String fullTrans45 = "N";
					String tmnl45 = "N";
					String empty45 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  eurInlandCostConditionVO.getCostFactorCd().split(",");
					for(int i = 0; i < arrcostFactorCd.length; i ++){
						
						if("F2".equals(arrcostFactorCd[i])){
							fullTrans20 = "Y";
						}else if("F4".equals(arrcostFactorCd[i])){
							fullTrans40 = "Y";
						}else if("F45".equals(arrcostFactorCd[i])){
							fullTrans45 = "Y";
						}else if("T2".equals(arrcostFactorCd[i])){
							tmnl20 = "Y";
						}else if("T4".equals(arrcostFactorCd[i])){
							tmnl40 = "Y";
						}else if("T45".equals(arrcostFactorCd[i])){
							tmnl45 = "Y";
						}else if("E2".equals(arrcostFactorCd[i])){
							empty20 = "Y";
						}else if("E4".equals(arrcostFactorCd[i])){
							empty40 = "Y";
						}else if("E45".equals(arrcostFactorCd[i])){
							empty45 = "Y";
						}
						
						costFactorCds.add(arrcostFactorCd[i]);
					}
					velParam.put("costFactorCds", costFactorCds);
					velParam.put("fullTrans20", fullTrans20);
					velParam.put("fullTrans40", fullTrans40);
					velParam.put("fullTrans45", fullTrans45);
					velParam.put("tmnl20", tmnl20);
					velParam.put("tmnl40", tmnl40);
					velParam.put("tmnl45", tmnl45);
					velParam.put("empty20", empty20);
					velParam.put("empty40", empty40);
					velParam.put("empty45", empty45);
				}
				
				if(!"ALL".equals(eurInlandCostConditionVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  eurInlandCostConditionVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlnadCostInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurInlnadCostInquiryVO .class);
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
		 * @param EurInlandCostConditionVO eurInlandCostConditionVO
		 * @return List<EurInlnadCostInquiryVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<EurInlnadCostInquiryVO> searchInlnadCostRefInquiry(EurInlandCostConditionVO eurInlandCostConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<EurInlnadCostInquiryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(eurInlandCostConditionVO != null){
					Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);

					if(!"".equals(eurInlandCostConditionVO.getLocNodCd())){
						List<String> locNodCds = new ArrayList<String>();
						String[] arrlocNodCd =  eurInlandCostConditionVO.getLocNodCd().split(",");
						for(int i = 0; i < arrlocNodCd.length; i ++){
							locNodCds.add(arrlocNodCd[i]);
						}
						velParam.put("locNodCds", locNodCds);
					}
					
					if(!"".equals(eurInlandCostConditionVO.getHubNodCd())){
						List<String> hubNodCds = new ArrayList<String>();
						String[] arrhubNodCd =  eurInlandCostConditionVO.getHubNodCd().split(",");
						for(int i = 0; i < arrhubNodCd.length; i ++){
							hubNodCds.add(arrhubNodCd[i]);
						}
						velParam.put("hubNodCds", hubNodCds);
					}
					
					if(!"".equals(eurInlandCostConditionVO.getPortNodCd())){
						List<String> portNodCds = new ArrayList<String>();
						String[] arrportNodCd =  eurInlandCostConditionVO.getPortNodCd().split(",");
						for(int i = 0; i < arrportNodCd.length; i ++){
							portNodCds.add(arrportNodCd[i]);
						}
						velParam.put("portNodCds", portNodCds);
					}
					
					if(!"ALL".equals(eurInlandCostConditionVO.getTrspCrrModCd())){
						List<String> trspCrrModCds = new ArrayList<String>();
						String[] arrtrspCrrModCd =  eurInlandCostConditionVO.getTrspCrrModCd().split(",");
						for(int i = 0; i < arrtrspCrrModCd.length; i ++){
							trspCrrModCds.add(arrtrspCrrModCd[i]);
						}
						velParam.put("trspCrrModCds", trspCrrModCds);
					}

					if(!"".equals(eurInlandCostConditionVO.getCostTrfNo())){
						List<String> costTrfNos = new ArrayList<String>();
						String[] arrcostTrfNo =  eurInlandCostConditionVO.getCostTrfNo().split(",");
						for(int i = 0; i < arrcostTrfNo.length; i ++){
							costTrfNos.add(arrcostTrfNo[i]);
						}
						velParam.put("costTrfNos", costTrfNos);
					}

					if(!"ALL".equals(eurInlandCostConditionVO.getCostFactorCd())){
						String fullTrans20 = "N";
						String fullTrans40 = "N";
						String tmnl20 = "N";
						String tmnl40 = "N";
						String empty20 = "N";
						String empty40 = "N";
						// 45' Cost 추가
						String fullTrans45 = "N";
						String tmnl45 = "N";
						String empty45 = "N";
						
						List<String> costFactorCds = new ArrayList<String>();
						String[] arrcostFactorCd =  eurInlandCostConditionVO.getCostFactorCd().split(",");
						for(int i = 0; i < arrcostFactorCd.length; i ++){
							
							if("F2".equals(arrcostFactorCd[i])){
								fullTrans20 = "Y";
							}else if("F4".equals(arrcostFactorCd[i])){
								fullTrans40 = "Y";
							}else if("F45".equals(arrcostFactorCd[i])){
								fullTrans45 = "Y";
							}else if("T2".equals(arrcostFactorCd[i])){
								tmnl20 = "Y";
							}else if("T4".equals(arrcostFactorCd[i])){
								tmnl40 = "Y";
							}else if("T45".equals(arrcostFactorCd[i])){
								tmnl45 = "Y";
							}else if("E2".equals(arrcostFactorCd[i])){
								empty20 = "Y";
							}else if("E4".equals(arrcostFactorCd[i])){
								empty40 = "Y";
							}else if("E45".equals(arrcostFactorCd[i])){
								empty45 = "Y";
							}
							
							costFactorCds.add(arrcostFactorCd[i]);
						}
						velParam.put("costFactorCds", costFactorCds);
						velParam.put("fullTrans20", fullTrans20);
						velParam.put("fullTrans40", fullTrans40);
						velParam.put("fullTrans45", fullTrans45);
						velParam.put("tmnl20", tmnl20);
						velParam.put("tmnl40", tmnl40);
						velParam.put("tmnl45", tmnl45);
						velParam.put("empty20", empty20);
						velParam.put("empty40", empty40);
						velParam.put("empty45", empty45);
					}
					
					if(!"ALL".equals(eurInlandCostConditionVO.getSysSrcCd())){
						List<String> sysSrcCds = new ArrayList<String>();
						String[] arrsysSrcCd =  eurInlandCostConditionVO.getSysSrcCd().split(",");
						for(int i = 0; i < arrsysSrcCd.length; i ++){
							sysSrcCds.add(arrsysSrcCd[i]);
						}
						velParam.put("sysSrcCds", sysSrcCds);
					}
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlandCostRefInquiryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurInlnadCostInquiryVO .class);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @return List<EurInlnadCostSpeInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EurInlnadCostSpeInquiryVO> searchInlnadCostSpeInquiry(EurInlandCostConditionVO eurInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurInlnadCostSpeInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(eurInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  eurInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						if(arrlocNodCd[i].length() > 1){
							locNodCds.add(arrlocNodCd[i].substring(0,2));
						}else{
							locNodCds.add(arrlocNodCd[i]);
						}
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"ALL".equals(eurInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  eurInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(eurInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  eurInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlnadCostSpeInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurInlnadCostSpeInquiryVO .class);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInlnadCostInquiryExcel(EurInlandCostConditionVO eurInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(eurInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  eurInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"".equals(eurInlandCostConditionVO.getHubNodCd())){
					List<String> hubNodCds = new ArrayList<String>();
					String[] arrhubNodCd =  eurInlandCostConditionVO.getHubNodCd().split(",");
					for(int i = 0; i < arrhubNodCd.length; i ++){
						hubNodCds.add(arrhubNodCd[i]);
					}
					velParam.put("hubNodCds", hubNodCds);
				}
				
				if(!"".equals(eurInlandCostConditionVO.getPortNodCd())){
					List<String> portNodCds = new ArrayList<String>();
					String[] arrportNodCd =  eurInlandCostConditionVO.getPortNodCd().split(",");
					for(int i = 0; i < arrportNodCd.length; i ++){
						portNodCds.add(arrportNodCd[i]);
					}
					velParam.put("portNodCds", portNodCds);
				}
				
				if(!"ALL".equals(eurInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  eurInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(eurInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  eurInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(eurInlandCostConditionVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					// 45' Cost 추가
					String fullTrans45 = "N";
					String tmnl45 = "N";
					String empty45 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  eurInlandCostConditionVO.getCostFactorCd().split(",");
					for(int i = 0; i < arrcostFactorCd.length; i ++){
						
						if("F2".equals(arrcostFactorCd[i])){
							fullTrans20 = "Y";
						}else if("F4".equals(arrcostFactorCd[i])){
							fullTrans40 = "Y";
						}else if("F45".equals(arrcostFactorCd[i])){
							fullTrans45 = "Y";
						}else if("T2".equals(arrcostFactorCd[i])){
							tmnl20 = "Y";
						}else if("T4".equals(arrcostFactorCd[i])){
							tmnl40 = "Y";
						}else if("T45".equals(arrcostFactorCd[i])){
							tmnl45 = "Y";
						}else if("E2".equals(arrcostFactorCd[i])){
							empty20 = "Y";
						}else if("E4".equals(arrcostFactorCd[i])){
							empty40 = "Y";
						}else if("E45".equals(arrcostFactorCd[i])){
							empty45 = "Y";
						}
						
						costFactorCds.add(arrcostFactorCd[i]);
					}
					velParam.put("costFactorCds", costFactorCds);
					velParam.put("fullTrans20", fullTrans20);
					velParam.put("fullTrans40", fullTrans40);
					velParam.put("fullTrans45", fullTrans45);
					velParam.put("tmnl20", tmnl20);
					velParam.put("tmnl40", tmnl40);
					velParam.put("tmnl45", tmnl45);
					velParam.put("empty20", empty20);
					velParam.put("empty40", empty40);
					velParam.put("empty45", empty45);
				}
				
				if(!"ALL".equals(eurInlandCostConditionVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  eurInlandCostConditionVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlnadCostInquiryRSQL(), param, velParam);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInlnadCostRefInquiryExcel(EurInlandCostConditionVO eurInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(eurInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  eurInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"".equals(eurInlandCostConditionVO.getHubNodCd())){
					List<String> hubNodCds = new ArrayList<String>();
					String[] arrhubNodCd =  eurInlandCostConditionVO.getHubNodCd().split(",");
					for(int i = 0; i < arrhubNodCd.length; i ++){
						hubNodCds.add(arrhubNodCd[i]);
					}
					velParam.put("hubNodCds", hubNodCds);
				}
				
				if(!"".equals(eurInlandCostConditionVO.getPortNodCd())){
					List<String> portNodCds = new ArrayList<String>();
					String[] arrportNodCd =  eurInlandCostConditionVO.getPortNodCd().split(",");
					for(int i = 0; i < arrportNodCd.length; i ++){
						portNodCds.add(arrportNodCd[i]);
					}
					velParam.put("portNodCds", portNodCds);
				}
				
				if(!"ALL".equals(eurInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  eurInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(eurInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  eurInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(eurInlandCostConditionVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  eurInlandCostConditionVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(eurInlandCostConditionVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  eurInlandCostConditionVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlandCostRefInquiryRSQL(), param, velParam);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInlnadCostSpeInquiryExcel(EurInlandCostConditionVO eurInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"ALL".equals(eurInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  eurInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(eurInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  eurInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlnadCostSpeInquiryRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOSearchInlandCostGuidelineExistRSQL(), param, velParam);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void modifyInlandCostMgtCfmCxl(EurInlandCostConditionVO eurInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new EurInlandCostManageDBDAOModifyInlandCostMgtCfmCxlUSQL(), param, velParam);
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
	 * @param EurInlandCostConditionVO eurInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void modifyInlandCostMgtCfmCxlPreVer(EurInlandCostConditionVO eurInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(eurInlandCostConditionVO != null){
				Map<String, String> mapVO = eurInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new EurInlandCostManageDBDAOModifyInlandCostMgtCfmCxlPreVerUSQL(), param, velParam);
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
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurInlandCostManageDBDAOVerifyInlndCostTrfNoRSQL(), null, velParam);
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