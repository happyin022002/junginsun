/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaOceanFeederCostManageDBDAO.java
*@FileTitle : Ocean Feeder Cost Management(Asia)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2013.03.19 이재위 [CHM-201323286-01] [AOC] OCN FDR management 화면 Delete function 관련 기능보완
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostAccountVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostCondVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostDGVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederDgCostVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederMgtCondVO;
import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo.AsiaFeederReeferCostVO;
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
 * ALPS AsiaOceanFeederCostManageDBDAO <br>
 * - ALPS-CostManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong Ock
 * @see CostManageBCImpl 참조
 * @since J2EE 1.6
 */
public class AsiaOceanFeederCostManageDBDAO extends DBDAOSupport { 

	/**
	 * Ocean Feeder Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AsiaFeederCostVO> searchFeederCost(AsiaFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaFeederCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inputVO != null){
				Map<String, String> mapVO = inputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaFeederCostVO .class);
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
	 * Ocean Feeder Cost Management tab Dangerous - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AsiaFeederDgCostVO> searchFeederDgCost(AsiaFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaFeederDgCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inputVO != null){
				Map<String, String> mapVO = inputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederDgCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaFeederDgCostVO .class);
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
	 * Ocean Feeder Cost Management tab Reefer - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AsiaFeederReeferCostVO> searchFeederRfCost(AsiaFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaFeederReeferCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inputVO != null){
				Map<String, String> mapVO = inputVO .getColumnValues();
				String trfNo = mapVO.get("in_cost_trf_no");
				String trf = trfNo.substring(0,3);
				if(trf.equals("SEL")){
					mapVO.put("in_from_nod_cd","KR");
				}else if(trf.equals("TYO")){
					mapVO.put("in_from_nod_cd","JP");
				}
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederReeferCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaFeederReeferCostVO .class);
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
	 * Ocean Feeder Cost Management - Cost Tariff No<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AsiaFeederCostTariffNoVO> searchFeederCostTariffNo(AsiaFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaFeederCostTariffNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inputVO != null){
				Map<String, String> mapVO = inputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederCostTariffNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaFeederCostTariffNoVO .class);
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
	 * Ocean Feeder Cost Management - Cost Tariff No Info<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AsiaFeederCostTariffInfoVO searchFeederCostTariffInfo(AsiaFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaFeederCostTariffInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inputVO != null){
				Map<String, String> mapVO = inputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederCostTariffInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaFeederCostTariffInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?new AsiaFeederCostTariffInfoVO():list.get(0);
	}

	/**
	 * Ocean Feeder Cost Management tab Dry - Save<br>
	 * 
	 * @param updModels
	 * @throws EventException
	 * @throws DAOException
	 */
	public void multiFeederCost(List<AsiaFeederCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOMultiFeederCostUSQL(), updModels, null);
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
	 * Ocean Feeder Cost Management tab Dangerous - Save<br>
	 * 
	 * @param updModels
	 * @throws EventException
	 * @throws DAOException
	 */
	public void multiFeederDgCost(List<AsiaFeederDgCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOMultiFeederDgCostUSQL(), updModels, null);
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
	 * Ocean Feeder Cost Management tab Reefer - Save<br>
	 * 
	 * @param updModels
	 * @throws EventException
	 * @throws DAOException
	 */
	public void multiFeederRfCost(List<AsiaFeederReeferCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOMultiFeederRfCostUSQL(), updModels, null);
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
	 * Ocean Feeder Cost Detail - Delete<br>
	 * 
	 * @param delModels
	 * @throws EventException
	 * @throws DAOException
	 */
	public void removeFdrTrfDtl(List<AsiaFeederCostVO> delModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			if(delModels.size() > 0){
				// Dry, Reefer 삭제 
				if(!"DG".equalsIgnoreCase(delModels.get(0).getCgoTpCd())){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaOceanFeederCostManageDBDAORemoveFdrRfTrfDtlAcctDSQL(), delModels, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
					
					delCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaOceanFeederCostManageDBDAORemoveFdrRfTrfDtlDSQL(), delModels, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
				// Dry, DG 삭제
				if(!"RF".equalsIgnoreCase(delModels.get(0).getCgoTpCd())){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaOceanFeederCostManageDBDAORemoveFdrDgTrfDtlDSQL(), delModels, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
				// Dry 삭제
				if("".equalsIgnoreCase(delModels.get(0).getCgoTpCd())){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaOceanFeederCostManageDBDAORemoveFdrTrfDtlAcctDSQL(), delModels, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
					
					delCnt = sqlExe.executeBatch((ISQLTemplate)new AsiaOceanFeederCostManageDBDAORemoveFdrTrfDtlDSQL(), delModels, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
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
	 * Ocean Feeder Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 * @throws DAOException
	 */
	public void multiFeederCostHdr(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("upd_usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOMultiFeederCostHdrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
	
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Ocean Feeder Cost Management - verifyFeederCostConfirm<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	public String verifyFeederCostConfirm(AsiaFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = "";

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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOVerifyFeederCostConfirmRSQL(), param, velParam);
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
	 * Ocean Feeder Cost Management - confirmFeederCostPreVer<br>
	 * 
	 * @param AsiaFeederMgtCondVO inputVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmFeederCostPreVer(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(inputVO != null){
				Map<String, String> mapVO = inputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("ofc_cd", account.getOfc_cd());
			param.put("rhq_ofc_cd", account.getRhq_ofc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOConfirmFeederCostPreVerUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * Ocean Feeder Cost Management - confirmFeederCost<br>
	 * 
	 * @param AsiaFeederMgtCondVO inputVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmFeederCost(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(inputVO != null){
				Map<String, String> mapVO = inputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("ofc_cd", account.getOfc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOConfirmFeederCostUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Inland Cost Management - searchFeederCostGuidelineExist<br>
	 * 
	 * @param AsiaFeederMgtCondVO inputVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchFeederCostGuidelineExist(AsiaFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		String existFlg = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inputVO != null){
				Map<String, String> mapVO = inputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederCostGuidelineExistRSQL(), param, velParam);
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
	 * Ocean Feeder Cost Management - modifyFeederCostMgtCfmCxlPreVer<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 * @throws DAOException
	 */
	public void modifyFeederCostMgtCfmCxlPreVer(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(inputVO != null){
				Map<String, String> mapVO = inputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("ofc_cd", account.getOfc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOModifyFeederCostMgtCfmCxlPreVerUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Ocean Feeder Cost Management - modifyFeederCostMgtCfmCxl<br>
	 * 
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 * @throws DAOException
	 */
	public void modifyFeederCostMgtCfmCxl(AsiaFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(inputVO != null){
				Map<String, String> mapVO = inputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("usr_ofc_cd", account.getOfc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOModifyFeederCostMgtCfmCxlUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Ocean Feeder Cost Management – Cost Detail  - Retrieve.<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AsiaFeederCostAccountVO> searchOceanFeederCostAccount(AsiaFeederCostAccountVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaFeederCostAccountVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inputVO != null){
				Map<String, String> mapVO = inputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchOceanFeederCostAccountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaFeederCostAccountVO .class);
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
	 * Ocean Feeder Cost Inquiry tab Dry - Retrieve<br>
	 * 
	 * @param AsiaFeederCostCondVO asiaFeederCostCondVO
	 * @return List<AsiaFeederCostInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AsiaFeederCostInquiryVO> searchFeederCostInquiry(AsiaFeederCostCondVO asiaFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaFeederCostInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaFeederCostCondVO != null){
				Map<String, String> mapVO = asiaFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(asiaFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  asiaFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  asiaFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  asiaFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"ALL".equals(asiaFeederCostCondVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  asiaFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(asiaFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  asiaFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederCostInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaFeederCostInquiryVO .class);
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
	 * Ocean Feeder Cost Inquiry Dangerous - Retrieve<br>
	 * 
	 * @param asiaFeederCostCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AsiaFeederCostDGVO> searchFeederCostDG(AsiaFeederCostCondVO asiaFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaFeederCostDGVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaFeederCostCondVO != null){
				Map<String, String> mapVO = asiaFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(asiaFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  asiaFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  asiaFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  asiaFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederCostDGRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaFeederCostDGVO .class);
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
	 * Ocean Feeder Cost Reefer - Retrieve<br>
	 * 
	 * @param asiaFeederCostCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AsiaFeederCostInquiryVO> searchFeederCostRF(AsiaFeederCostCondVO asiaFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsiaFeederCostInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaFeederCostCondVO != null){
				Map<String, String> mapVO = asiaFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(asiaFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  asiaFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  asiaFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  asiaFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"ALL".equals(asiaFeederCostCondVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  asiaFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(asiaFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  asiaFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederCostRFRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsiaFeederCostInquiryVO .class);
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
	 * Ocean Feeder Cost Inquiry tab Dry - Down Excel without Displaying<br>
	 * 
	 * @param AsiaFeederCostCondVO asiaFeederCostCondVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFeederCostInquiryExcel(AsiaFeederCostCondVO asiaFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(asiaFeederCostCondVO != null){
				Map<String, String> mapVO = asiaFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(asiaFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  asiaFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  asiaFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  asiaFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(asiaFeederCostCondVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  asiaFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(asiaFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  asiaFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederCostInquiryRSQL(), param, velParam);
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
	 * Ocean Feeder Cost Inquiry Dangerous - Retrieve<br>
	 * 
	 * @param asiaFeederCostCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchFeederCostDGExcel(AsiaFeederCostCondVO asiaFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaFeederCostCondVO != null){
				Map<String, String> mapVO = asiaFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(asiaFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  asiaFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  asiaFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  asiaFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederCostDGRSQL(), param, velParam);
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
	 * Ocean Feeder Cost RF - Down Excel without Displaying<br>
	 * 
	 * @param AsiaFeederCostCondVO asiaFeederCostCondVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFeederCostRFExcel(AsiaFeederCostCondVO asiaFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(asiaFeederCostCondVO != null){
				Map<String, String> mapVO = asiaFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(asiaFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  asiaFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  asiaFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(asiaFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  asiaFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"ALL".equals(asiaFeederCostCondVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  asiaFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(asiaFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  asiaFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOSearchFeederCostRFRSQL(), param, velParam);
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
	 * @param trfNo
	 * @return
	 * @throws DAOException
	 */
	public String verifyFeederCostTrfNo(String trfNo) throws DAOException {
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
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AsiaOceanFeederCostManageDBDAOVerifyFeederCostTrfNoRSQL(), null, velParam);
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