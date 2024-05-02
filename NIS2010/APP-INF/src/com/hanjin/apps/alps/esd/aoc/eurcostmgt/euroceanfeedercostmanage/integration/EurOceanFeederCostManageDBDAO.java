/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurOceanFeederCostManageDBDAO.java
*@FileTitle : Ocean Feeder Cost Management(EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
* 2013.03.19 이재위 [CHM-201323286] [AOC] OCN FDR management 화면 Delete function 관련 기능보완
* 2015.02.03 전지예 [CHM-201533794] [AOC] 45' Cost 추가
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostDGVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostInquiryVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostTariffNoVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostCondVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederDgCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederMgtCondVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederReeferCostVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo.EurFeederCostAccountVO;
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
 * ALPS EurOceanFeederCostManageDBDAO <br>
 * - ALPS-CostManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong Ock
 * @see CostManageBCImpl 참조
 * @since J2EE 1.6
 */
public class EurOceanFeederCostManageDBDAO extends DBDAOSupport {

	/**
	 * Ocean Feeder Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurFeederCostVO> searchFeederCost(EurFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurFeederCostVO> list = null;
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurFeederCostVO .class);
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
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurFeederDgCostVO> searchFeederDgCost(EurFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurFeederDgCostVO> list = null;
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederDgCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurFeederDgCostVO .class);
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
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurFeederReeferCostVO> searchFeederRfCost(EurFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurFeederReeferCostVO> list = null;
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederReeferCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurFeederReeferCostVO .class);
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
	public List<EurFeederCostTariffNoVO> searchFeederCostTariffNo(EurFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurFeederCostTariffNoVO> list = null;
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederCostTariffNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurFeederCostTariffNoVO .class);
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
	 * @param EurFeederMgtCondVO inputVO
	 * @return EurFeederCostTariffInfoVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public EurFeederCostTariffInfoVO searchFeederCostTariffInfo(EurFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurFeederCostTariffInfoVO> list = null;
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederCostTariffInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurFeederCostTariffInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?new EurFeederCostTariffInfoVO():list.get(0);
	}

	/**
	 * Ocean Feeder Cost Management tab Dry - Save<br>
	 * 
	 * @param updModels
	 * @throws EventException
	 * @throws DAOException
	 */
	public void multiFeederCost(List<EurFeederCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EurOceanFeederCostManageDBDAOMultiFeederCostUSQL(), updModels, null);
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
	public void multiFeederDgCost(List<EurFeederDgCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EurOceanFeederCostManageDBDAOMultiFeederDgCostUSQL(), updModels, null);
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
	public void multiFeederRfCost(List<EurFeederReeferCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EurOceanFeederCostManageDBDAOMultiFeederRfCostUSQL(), updModels, null);
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
	public void removeFdrTrfDtl(List<EurFeederCostVO> delModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			if(delModels.size() > 0){
				// Dry, Reefer 삭제 
				if(!"DG".equalsIgnoreCase(delModels.get(0).getCgoTpCd())){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new EurOceanFeederCostManageDBDAORemoveFdrRfTrfDtlAcctDSQL(), delModels, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
					
					delCnt = sqlExe.executeBatch((ISQLTemplate)new EurOceanFeederCostManageDBDAORemoveFdrRfTrfDtlDSQL(), delModels, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				} 
				// Dry, DG 삭제
				if(!"RF".equalsIgnoreCase(delModels.get(0).getCgoTpCd())){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new EurOceanFeederCostManageDBDAORemoveFdrDgTrfDtlDSQL(), delModels, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
				// Dry 삭제
				if("".equalsIgnoreCase(delModels.get(0).getCgoTpCd())){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new EurOceanFeederCostManageDBDAORemoveFdrTrfDtlAcctDSQL(), delModels, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
					
					delCnt = sqlExe.executeBatch((ISQLTemplate)new EurOceanFeederCostManageDBDAORemoveFdrTrfDtlDSQL(), delModels, null);
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
	 * @param EurFeederMgtCondVO inputVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void multiFeederCostHdr(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException, DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new EurOceanFeederCostManageDBDAOMultiFeederCostHdrUSQL(), param, velParam);
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
	 * @param EurFeederMgtCondVO inputVO
	 * @return String
	 * @throws DAOException
	 */
	public String verifyFeederCostConfirm(EurFeederMgtCondVO inputVO) throws DAOException {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOVerifyFeederCostConfirmRSQL(), param, velParam);
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
	 * @param inputVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmFeederCostPreVer(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException, DAOException {
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
			
			param.put("ofc_cd", account.getOfc_cd());
			param.put("rhq_ofc_cd", account.getRhq_ofc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new EurOceanFeederCostManageDBDAOConfirmFeederCostPreVerUSQL(), param, velParam);
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
	 * @param inputVO
	 * @param account
	 * @throws EventException
	 * @throws DAOException
	 */
	public void confirmFeederCost(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException, DAOException {
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
			
			param.put("ofc_cd", account.getOfc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new EurOceanFeederCostManageDBDAOConfirmFeederCostUSQL(), param, velParam);
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
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	public String searchFeederCostGuidelineExist(EurFeederMgtCondVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		String existFlg = "";

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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederCostGuidelineExistRSQL(), param, velParam);
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
	 * @param EurFeederMgtCondVO inputVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void modifyFeederCostMgtCfmCxlPreVer(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException, DAOException {
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
			
			param.put("ofc_cd", account.getOfc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new EurOceanFeederCostManageDBDAOModifyFeederCostMgtCfmCxlPreVerUSQL(), param, velParam);
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
	public void modifyFeederCostMgtCfmCxl(EurFeederMgtCondVO inputVO, SignOnUserAccount account) throws EventException, DAOException {
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
			
			param.put("usr_ofc_cd", account.getOfc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new EurOceanFeederCostManageDBDAOModifyFeederCostMgtCfmCxlUSQL(), param, velParam);
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
	 * @param inputVo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurFeederCostAccountVO> searchOceanFeederCostAccount(EurFeederCostAccountVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurFeederCostAccountVO> list = null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchOceanFeederCostAccountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurFeederCostAccountVO .class);
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
	 * @param EurFeederCostCondVO eurFeederCostCondVO
	 * @return List<EurFeederCostInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EurFeederCostInquiryVO> searchFeederCostInquiry(EurFeederCostCondVO eurFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurFeederCostInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurFeederCostCondVO != null){
				Map<String, String> mapVO = eurFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(eurFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  eurFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(eurFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  eurFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(eurFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  eurFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"ALL".equals(eurFeederCostCondVO.getCostFactorCd())){
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
					String[] arrcostFactorCd =  eurFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(eurFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  eurFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederCostInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurFeederCostInquiryVO .class);
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
	 * @param eurFeederCostCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurFeederCostDGVO> searchFeederCostDG(EurFeederCostCondVO eurFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurFeederCostDGVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurFeederCostCondVO != null){
				Map<String, String> mapVO = eurFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(eurFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  eurFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(eurFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  eurFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(eurFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  eurFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederCostDGRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurFeederCostDGVO .class);
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
	 * @param eurFeederCostCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurFeederCostInquiryVO> searchFeederCostRF(EurFeederCostCondVO eurFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurFeederCostInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurFeederCostCondVO != null){
				Map<String, String> mapVO = eurFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(eurFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  eurFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(eurFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  eurFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(eurFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  eurFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"ALL".equals(eurFeederCostCondVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  eurFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(eurFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  eurFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederCostRFRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EurFeederCostInquiryVO .class);
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
	 * @param EurFeederCostCondVO eurFeederCostCondVO
	 * @return DBRowSet 
	 * @throws DAOException
	 */
	public DBRowSet searchFeederCostInquiryExcel(EurFeederCostCondVO eurFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(eurFeederCostCondVO != null){
				Map<String, String> mapVO = eurFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(eurFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  eurFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(eurFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  eurFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"".equals(eurFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  eurFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(eurFeederCostCondVO.getCostFactorCd())){
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
					String[] arrcostFactorCd =  eurFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(eurFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  eurFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederCostInquiryRSQL(), param, velParam);
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
	 * @param eurFeederCostCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchFeederCostDGExcel(EurFeederCostCondVO eurFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurFeederCostCondVO != null){
				Map<String, String> mapVO = eurFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(eurFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  eurFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(eurFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  eurFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(eurFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  eurFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederCostDGRSQL(), param, velParam);
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
	 * @param EurFeederCostCondVO eurFeederCostCondVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFeederCostRFExcel(EurFeederCostCondVO eurFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurFeederCostCondVO != null){
				Map<String, String> mapVO = eurFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(eurFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  eurFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(eurFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  eurFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(eurFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  eurFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"ALL".equals(eurFeederCostCondVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  eurFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(eurFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  eurFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOSearchFeederCostRFRSQL(), param, velParam);
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
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurOceanFeederCostManageDBDAOVerifyFeederCostTrfNoRSQL(), null, velParam);
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