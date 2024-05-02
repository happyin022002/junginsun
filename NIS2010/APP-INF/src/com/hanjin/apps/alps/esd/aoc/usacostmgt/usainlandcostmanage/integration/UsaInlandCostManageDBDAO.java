/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaInlandCostManageDBDAO.java
*@FileTitle : Inland Cost Manage(EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
*2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
*2013.09.24 서미진 [CHM-201326830] Batch RF tab 관련 화면로직 보완
*2014.01.16 서미진 [CHM-201428500] 미주지역 Cost Table 생성시 SCTLAL 추가건을 하면서 Inquiry 화면의 special down excel 보완
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostDetailVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlandCostVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaInlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaIpiPortVO;
import com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo.UsaStatusMonitorVO;
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
 * ALPS UsaInlandCostManageDBDAO <br>
 * - ALPS-CostManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see UsaCostManageBCImpl 참조
 * @since J2EE 1.6
 */
public class UsaInlandCostManageDBDAO extends DBDAOSupport {

	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @return List<UsaInlandCostVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UsaInlandCostVO> searchInlandCost(UsaInlandCostConditionVO usaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInlandCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlandCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaInlandCostVO .class);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @return List<UsaInlandCostSpecialCargoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UsaInlandCostSpecialCargoVO> searchInlandCostSpecialCargo(UsaInlandCostConditionVO usaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInlandCostSpecialCargoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlandCostSpecialCargoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaInlandCostSpecialCargoVO .class);
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
	  * @param usaInlandCostConditionVO
	  * @return
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<UsaInlandCostVO> searchInlandCostReefer(UsaInlandCostConditionVO usaInlandCostConditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<UsaInlandCostVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(usaInlandCostConditionVO != null){
				 Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlandCostReeferRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaInlandCostVO .class);
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
	 * @return List<UsaInlandCostTariffNoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UsaInlandCostTariffNoVO> searchInlandCostTariffNo(String inCntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInlandCostTariffNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cnt_cd", inCntCd);
			velParam.put("in_cnt_cd", inCntCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlandCostTariffNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaInlandCostTariffNoVO .class);
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOVerifyCountryCodeRSQL(), param, velParam);
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
	 * @return UsaInlandCostTariffInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public UsaInlandCostTariffInfoVO searchInlandCostTariffInfo(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInlandCostTariffInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlandCostTariffInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaInlandCostTariffInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?new UsaInlandCostTariffInfoVO():list.get(0);
	}
	 
	/**
	 * @param inCostTrfNo
	 * @return
	 * @throws DAOException
	 */
	public List<UsaIpiPortVO> searchUsaIpiPort(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaIpiPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchUsaIpiPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaIpiPortVO .class);
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
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param List<UsaInlandCostVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCost(List<UsaInlandCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new UsaInlandCostManageDBDAOMultiInlandCostUSQL(), updModels, null);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void multiInlandCostHdr(UsaInlandCostConditionVO usaInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new UsaInlandCostManageDBDAOMultiInlandCostHdrUSQL(), param, velParam);
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
	public void addInlandCostReefer(List<UsaInlandCostVO> insModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UsaInlandCostManageDBDAOAddInlandCostReeferCSQL(), insModels, null);
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
	public void modifyInlandCostReefer(List<UsaInlandCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new UsaInlandCostManageDBDAOModifyInlandCostReeferUSQL(), updModels, null);
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
	public void removeInlandCostReefer(List<UsaInlandCostVO> updModels) throws EventException, DAOException {
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
					result = sqlExe.executeUpdate((ISQLTemplate) new UsaInlandCostManageDBDAORemoveInlandCostReeferUSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOVerifyInlandCostConfirmRSQL(), param, velParam);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmInlandCostPreVer(UsaInlandCostConditionVO usaInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new UsaInlandCostManageDBDAOConfirmInlandCostPreVerUSQL(), param, velParam);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmInlandCost(UsaInlandCostConditionVO usaInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new UsaInlandCostManageDBDAOConfirmInlandCostUSQL(), param, velParam);
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
	 * ESD_AOC_3302 : Confirm Cancel
	 * Inland Cost Management tab Special - Create<br>
	 * 
	 * @param UsaInlandCostConditionVO inlandCostConditionVO
	 * @param SignOnUserAccount account	 
	 * @throws DAOException
	 */
	public void addInlandCostSpecialCargoS(UsaInlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws DAOException {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			int result = 0;
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("cre_usr_id", account.getUsr_id());
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new UsaInlandCostManageDBDAOMultiInlandCostSpecialCargoCSQL(), param, null);
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
	 * @param List<UsaInlandCostSpecialCargoVO> updModels
	 * @throws DAOException 
	 */
	public void modifyInlandCostSpecialCargoS(List<UsaInlandCostSpecialCargoVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new UsaInlandCostManageDBDAOMultiInlandCostSpecialCargoUSQL(), updModels, null);
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
	 * ESD_AOC_3302 : Confirm 
	 * Inland Cost Management tab Special - Delete<br>
	 * 
	 * @param UsaInlandCostConditionVO inlandCostConditionVO
	 * @throws DAOException
	 */
	public void removeInlandCostSpecialCargoS(UsaInlandCostConditionVO inlandCostConditionVO) throws DAOException {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			int result = 0;
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO.getColumnValues();			
				param.putAll(mapVO);	
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new UsaInlandCostManageDBDAOMultiInlandCostSpecialCargoDSQL(), param, null);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @return List<UsaInlandCostDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UsaInlandCostDetailVO> searchInlandCostDetail(UsaInlandCostConditionVO usaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInlandCostDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlandCostDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaInlandCostDetailVO .class);
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
	 * @param List<UsaInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailSelect(List<UsaInlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new UsaInlandCostManageDBDAOMultiInlandCostDetailSelectUSQL(), updModels, null);
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
	 * @param List<UsaInlandCostDetailVO> updModels
	 * @return String
	 * @throws DAOException
	 */
	public String searchInlandCostDetailDeleteCheck(List<UsaInlandCostDetailVO> updModels) throws DAOException {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlandCostDetailDeleteCheckRSQL(), null, velParam);
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
	 * @param List<UsaInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailDelete(List<UsaInlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new UsaInlandCostManageDBDAOMultiInlandCostDetailDeleteUSQL(), updModels, null);
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
	 * @param List<UsaInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetail1stSelect(List<UsaInlandCostDetailVO> updModels) throws EventException, DAOException {
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
				result = sqlExe.executeUpdate((ISQLTemplate)new UsaInlandCostManageDBDAOMultiInlandCostDetail1stSelectUSQL(), param, velParam);
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
	 * @param List<UsaInlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailRest(List<UsaInlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new UsaInlandCostManageDBDAOMultiInlandCostDetailRestUSQL(), updModels, null);
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
	public List<UsaInlandCostAccountVO> searchInlandCostAccount(UsaInlandCostAccountVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInlandCostAccountVO> list = null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlandCostAccountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaInlandCostAccountVO .class);
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
	public List<UsaStatusMonitorVO> searchStatusMonitor(UsaStatusMonitorVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaStatusMonitorVO> list = null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchStatusMonitorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaStatusMonitorVO .class);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchShqOfcFlgRSQL(), param, null);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @return List<UsaInlnadCostInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UsaInlnadCostInquiryVO> searchInlnadCostInquiry(UsaInlandCostConditionVO usaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInlnadCostInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(usaInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  usaInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"".equals(usaInlandCostConditionVO.getHubNodCd())){
					List<String> hubNodCds = new ArrayList<String>();
					String[] arrhubNodCd =  usaInlandCostConditionVO.getHubNodCd().split(",");
					for(int i = 0; i < arrhubNodCd.length; i ++){
						hubNodCds.add(arrhubNodCd[i]);
					}
					velParam.put("hubNodCds", hubNodCds);
				}
				
				if(!"".equals(usaInlandCostConditionVO.getPortNodCd())){
					List<String> portNodCds = new ArrayList<String>();
					String[] arrportNodCd =  usaInlandCostConditionVO.getPortNodCd().split(",");
					for(int i = 0; i < arrportNodCd.length; i ++){
						portNodCds.add(arrportNodCd[i]);
					}
					velParam.put("portNodCds", portNodCds);
				}
				
				if(!"ALL".equals(usaInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  usaInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(usaInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  usaInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(usaInlandCostConditionVO.getCostFactorCd())){
//					String fullTrans20 = "N";
//					String fullTrans40 = "N";
					String fullRailBasic20 = "N";
					String fullRailFSC20 = "N";
					String fullRailBasic40 = "N";
					String fullRailFSC40 = "N";
					String truckBasic20 = "N";
					String truckFSC20 = "N";
					String truckBasic40 = "N";
					String truckFSC40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String domestic20 = "N";
					String domestic40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  usaInlandCostConditionVO.getCostFactorCd().split(",");
					for(int i = 0; i < arrcostFactorCd.length; i ++){
						
						if("RB2".equals(arrcostFactorCd[i])){
							fullRailBasic20 ="Y";
						}else if("RF2".equals(arrcostFactorCd[i])){
							fullRailFSC20 = "Y";
						}else if("RB4".equals(arrcostFactorCd[i])){
							fullRailBasic40 = "Y";
						}else if("RF4".equals(arrcostFactorCd[i])){
							fullRailFSC40 = "Y";
						}else if("TB2".equals(arrcostFactorCd[i])){
							truckBasic20 = "Y";
						}else if("TF2".equals(arrcostFactorCd[i])){
							truckFSC20 = "Y";
						}else if("TB4".equals(arrcostFactorCd[i])){
							truckBasic40 = "Y";
						}else if("TF4".equals(arrcostFactorCd[i])){
							truckFSC40 = "Y";
						}else if("T2".equals(arrcostFactorCd[i])){
							tmnl20 = "Y";
						}else if("T4".equals(arrcostFactorCd[i])){
							tmnl40 = "Y";
						}else if("D2".equals(arrcostFactorCd[i])){
							domestic20 = "Y";
						}else if("D4".equals(arrcostFactorCd[i])){
							domestic40 = "Y";
						}else if("E2".equals(arrcostFactorCd[i])){
							empty20 = "Y";
						}else if("E4".equals(arrcostFactorCd[i])){
							empty40 = "Y";
						}
						
						costFactorCds.add(arrcostFactorCd[i]);
					}
					velParam.put("costFactorCds", costFactorCds);
					velParam.put("fullRailBasic20", fullRailBasic20);
					velParam.put("fullRailFSC20", fullRailFSC20);
					velParam.put("fullRailBasic40", fullRailBasic40);
					velParam.put("fullRailFSC40", fullRailFSC40);
					velParam.put("truckBasic20", truckBasic20);
					velParam.put("truckFSC20", truckFSC20);
					velParam.put("truckBasic40", truckBasic40);
					velParam.put("truckFSC40", truckFSC40);
					velParam.put("tmnl20", tmnl20);
					velParam.put("tmnl40", tmnl40);
					velParam.put("domestic20", domestic20);
					velParam.put("domestic40", domestic40);
					velParam.put("empty20", empty20);
					velParam.put("empty40", empty40);
				}
				
				if(!"ALL".equals(usaInlandCostConditionVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  usaInlandCostConditionVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
				
				if(!"ALL".equals(usaInlandCostConditionVO.getSvcModCd())){
					List<String> svcModCds = new ArrayList<String>();
					String[] arrSvcModCd =  usaInlandCostConditionVO.getSvcModCd().split(",");
					for(int i = 0; i < arrSvcModCd.length; i ++){
						svcModCds.add(arrSvcModCd[i]);
					}
					velParam.put("svcModCds", svcModCds);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlnadCostInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaInlnadCostInquiryVO .class);
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
		 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
		 * @return List<UsaInlnadCostInquiryVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<UsaInlnadCostInquiryVO> searchInlnadCostRefInquiry(UsaInlandCostConditionVO usaInlandCostConditionVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<UsaInlnadCostInquiryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(usaInlandCostConditionVO != null){
					Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);

					if(!"".equals(usaInlandCostConditionVO.getLocNodCd())){
						List<String> locNodCds = new ArrayList<String>();
						String[] arrlocNodCd =  usaInlandCostConditionVO.getLocNodCd().split(",");
						for(int i = 0; i < arrlocNodCd.length; i ++){
							locNodCds.add(arrlocNodCd[i]);
						}
						velParam.put("locNodCds", locNodCds);
					}
					
					if(!"".equals(usaInlandCostConditionVO.getHubNodCd())){
						List<String> hubNodCds = new ArrayList<String>();
						String[] arrhubNodCd =  usaInlandCostConditionVO.getHubNodCd().split(",");
						for(int i = 0; i < arrhubNodCd.length; i ++){
							hubNodCds.add(arrhubNodCd[i]);
						}
						velParam.put("hubNodCds", hubNodCds);
					}
					
					if(!"".equals(usaInlandCostConditionVO.getPortNodCd())){
						List<String> portNodCds = new ArrayList<String>();
						String[] arrportNodCd =  usaInlandCostConditionVO.getPortNodCd().split(",");
						for(int i = 0; i < arrportNodCd.length; i ++){
							portNodCds.add(arrportNodCd[i]);
						}
						velParam.put("portNodCds", portNodCds);
					}
					
					if(!"ALL".equals(usaInlandCostConditionVO.getTrspCrrModCd())){
						List<String> trspCrrModCds = new ArrayList<String>();
						String[] arrtrspCrrModCd =  usaInlandCostConditionVO.getTrspCrrModCd().split(",");
						for(int i = 0; i < arrtrspCrrModCd.length; i ++){
							trspCrrModCds.add(arrtrspCrrModCd[i]);
						}
						velParam.put("trspCrrModCds", trspCrrModCds);
					}

					if(!"".equals(usaInlandCostConditionVO.getCostTrfNo())){
						List<String> costTrfNos = new ArrayList<String>();
						String[] arrcostTrfNo =  usaInlandCostConditionVO.getCostTrfNo().split(",");
						for(int i = 0; i < arrcostTrfNo.length; i ++){
							costTrfNos.add(arrcostTrfNo[i]);
						}
						velParam.put("costTrfNos", costTrfNos);
					}

					if(!"ALL".equals(usaInlandCostConditionVO.getCostFactorCd())){
						String fullTrans20 = "N";
						String fullTrans40 = "N";
						String tmnl20 = "N";
						String tmnl40 = "N";
						String empty20 = "N";
						String empty40 = "N";
						
						List<String> costFactorCds = new ArrayList<String>();
						String[] arrcostFactorCd =  usaInlandCostConditionVO.getCostFactorCd().split(",");
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
					
					if(!"ALL".equals(usaInlandCostConditionVO.getSysSrcCd())){
						List<String> sysSrcCds = new ArrayList<String>();
						String[] arrsysSrcCd =  usaInlandCostConditionVO.getSysSrcCd().split(",");
						for(int i = 0; i < arrsysSrcCd.length; i ++){
							sysSrcCds.add(arrsysSrcCd[i]);
						}
						velParam.put("sysSrcCds", sysSrcCds);
					}
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlandCostRefInquiryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaInlnadCostInquiryVO .class);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @return List<UsaInlnadCostSpeInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UsaInlnadCostSpeInquiryVO> searchInlnadCostSpeInquiry(UsaInlandCostConditionVO usaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInlnadCostSpeInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(usaInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  usaInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						if(arrlocNodCd[i].length() > 1){
							locNodCds.add(arrlocNodCd[i].substring(0,2));
						}else{
							locNodCds.add(arrlocNodCd[i]);
						}
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"ALL".equals(usaInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  usaInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(usaInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  usaInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlnadCostSpeInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaInlnadCostSpeInquiryVO .class);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInlnadCostInquiryExcel(UsaInlandCostConditionVO usaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(usaInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  usaInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"".equals(usaInlandCostConditionVO.getHubNodCd())){
					List<String> hubNodCds = new ArrayList<String>();
					String[] arrhubNodCd =  usaInlandCostConditionVO.getHubNodCd().split(",");
					for(int i = 0; i < arrhubNodCd.length; i ++){
						hubNodCds.add(arrhubNodCd[i]);
					}
					velParam.put("hubNodCds", hubNodCds);
				}
				
				if(!"".equals(usaInlandCostConditionVO.getPortNodCd())){
					List<String> portNodCds = new ArrayList<String>();
					String[] arrportNodCd =  usaInlandCostConditionVO.getPortNodCd().split(",");
					for(int i = 0; i < arrportNodCd.length; i ++){
						portNodCds.add(arrportNodCd[i]);
					}
					velParam.put("portNodCds", portNodCds);
				}
				
				if(!"ALL".equals(usaInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  usaInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(usaInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  usaInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(usaInlandCostConditionVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  usaInlandCostConditionVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(usaInlandCostConditionVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  usaInlandCostConditionVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
				
				if(!"ALL".equals(usaInlandCostConditionVO.getSvcModCd())){
					List<String> svcModCds = new ArrayList<String>();
					String[] arrSvcModCd =  usaInlandCostConditionVO.getSvcModCd().split(",");
					for(int i = 0; i < arrSvcModCd.length; i ++){
						svcModCds.add(arrSvcModCd[i]);
					}
					velParam.put("svcModCds", svcModCds);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlnadCostInquiryRSQL(), param, velParam);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInlnadCostRefInquiryExcel(UsaInlandCostConditionVO usaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(usaInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  usaInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"".equals(usaInlandCostConditionVO.getHubNodCd())){
					List<String> hubNodCds = new ArrayList<String>();
					String[] arrhubNodCd =  usaInlandCostConditionVO.getHubNodCd().split(",");
					for(int i = 0; i < arrhubNodCd.length; i ++){
						hubNodCds.add(arrhubNodCd[i]);
					}
					velParam.put("hubNodCds", hubNodCds);
				}
				
				if(!"".equals(usaInlandCostConditionVO.getPortNodCd())){
					List<String> portNodCds = new ArrayList<String>();
					String[] arrportNodCd =  usaInlandCostConditionVO.getPortNodCd().split(",");
					for(int i = 0; i < arrportNodCd.length; i ++){
						portNodCds.add(arrportNodCd[i]);
					}
					velParam.put("portNodCds", portNodCds);
				}
				
				if(!"ALL".equals(usaInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  usaInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(usaInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  usaInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(usaInlandCostConditionVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  usaInlandCostConditionVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(usaInlandCostConditionVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  usaInlandCostConditionVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlandCostRefInquiryRSQL(), param, velParam);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInlnadCostSpeInquiryExcel(UsaInlandCostConditionVO usaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(usaInlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  usaInlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"ALL".equals(usaInlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  usaInlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(usaInlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  usaInlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlnadCostSpeInquiryRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOSearchInlandCostGuidelineExistRSQL(), param, velParam);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void modifyInlandCostMgtCfmCxl(UsaInlandCostConditionVO usaInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new UsaInlandCostManageDBDAOModifyInlandCostMgtCfmCxlUSQL(), param, velParam);
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
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void modifyInlandCostMgtCfmCxlPreVer(UsaInlandCostConditionVO usaInlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new UsaInlandCostManageDBDAOModifyInlandCostMgtCfmCxlPreVerUSQL(), param, velParam);
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
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOVerifyInlndCostTrfNoRSQL(), null, velParam);
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
	 * ESD_AOC_3302 : Confirm
	 * Confirm : verify service mode (0 or minus value)<br>
	 * 
	 * @param UsaInlandCostConditionVO usaInlandCostConditionVO
	 * @return List<UsaInlandCostVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<UsaInlandCostVO> verifyServiceMode(UsaInlandCostConditionVO usaInlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UsaInlandCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(usaInlandCostConditionVO != null){
				Map<String, String> mapVO = usaInlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UsaInlandCostManageDBDAOVerifyServiceModeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UsaInlandCostVO .class);
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