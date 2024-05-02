/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OceanFeederCostManageDBDAO.java
*@FileTitle : Ocean Feeder Cost Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.03 변종건 [CHM-201217633] Ocean Feeder Cost Management 수정 및 신규 탭 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration.InlandCostManageDBDAOVerifyInlndCostTrfNoRSQL;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostDGVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostTariffInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostTariffNoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.OceanFeederCostCondVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederDgCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederReeferCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchOceanFeederCostAccountVO;
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
 * ALPS OceanFeederCostManageDBDAO <br>
 * - ALPS-CostManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong Ock
 * @see CostManageBCImpl 참조
 * @since J2EE 1.6
 */
public class OceanFeederCostManageDBDAO extends DBDAOSupport {

	/**
	 * Ocean Feeder Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param String inCostTrfNo
	 * @return List<FeederCostVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FeederCostVO> searchFeederCost(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<FeederCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOsearchFeederCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FeederCostVO .class);
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
	 * @param inCostTrfNo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchFeederDgCostVO> searchFeederDgCost(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFeederDgCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOSearchFeederDgCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFeederDgCostVO .class);
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
	 * @param inCostTrfNo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchFeederReeferCostVO> searchFeederRfCost(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFeederReeferCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOSearchFeederReeferCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFeederReeferCostVO .class);
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
	 * @param String inOfcCd
	 * @return List<FeederCostTariffNoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FeederCostTariffNoVO> searchFeederCostTariffNo(String inOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<FeederCostTariffNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_ofc_cd", inOfcCd);
			velParam.put("in_ofc_cd", inOfcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOsearchFeederCostTariffNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FeederCostTariffNoVO .class);
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
	 * @param String inCostTrfNo
	 * @param String inOfcCd
	 * @return FeederCostTariffInfoVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public FeederCostTariffInfoVO searchFeederCostTariffInfo(String inCostTrfNo, String inOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<FeederCostTariffInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			param.put("in_ofc_cd", inOfcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOsearchFeederCostTariffInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FeederCostTariffInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?new FeederCostTariffInfoVO():list.get(0);
	}

	/**
	 * Ocean Feeder Cost Management tab Dry - Save<br>
	 * 
	 * @param updModels
	 * @throws EventException
	 * @throws DAOException
	 */
	public void multiFeederCost(List<FeederCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OceanFeederCostManageDBDAOmultiFeederCostUSQL(), updModels, null);
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
	public void multiFeederDgCost(List<SearchFeederDgCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OceanFeederCostManageDBDAOMultiFeederDgCostUSQL(), updModels, null);
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
	public void multiFeederRfCost(List<SearchFeederReeferCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OceanFeederCostManageDBDAOMultiFeederRfCostUSQL(), updModels, null);
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
	 * Ocean Feeder Cost Management tab Dry - Save - State 변경<br>
	 * 
	 * @param String inCostTrfNo
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void multiFeederCostHdr(String inCostTrfNo, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			param.put("upd_usr_id", account.getUsr_id());

			param.put("ofc_cd", account.getOfc_cd());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new OceanFeederCostManageDBDAOmultiFeederCostHdrUSQL(), param, velParam);
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
	 * @param String inCostTrfNo
	 * @return String
	 * @throws DAOException
	 */
	public String verifyFeederCostConfirm(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOverifyFeederCostConfirmRSQL(), param, velParam);
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
	 * @param String inCostTrfNo 
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmFeederCostPreVer(String inCostTrfNo, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			param.put("ofc_cd", account.getOfc_cd());
			param.put("rhq_ofc_cd", account.getRhq_ofc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new OceanFeederCostManageDBDAOconfirmFeederCostPreVerUSQL(), param, velParam);
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
	 * @param String inCostTrfNo
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmFeederCost(String inCostTrfNo, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			param.put("ofc_cd", account.getOfc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new OceanFeederCostManageDBDAOconfirmFeederCostUSQL(), param, velParam);
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
	 * @param String inCostTrfNo
	 * @param String inRhqCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchFeederCostGuidelineExist(String inCostTrfNo, String inRhqCd) throws DAOException {
		DBRowSet dbRowset = null;
		String existFlg = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cost_trf_no", inCostTrfNo);
			param.put("rhq_cd", inRhqCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOsearchFeederCostGuidelineExistRSQL(), param, velParam);
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
	 * @param String inCostTrfNo
	 * @param String inRhqCd
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void modifyFeederCostMgtCfmCxlPreVer(String inCostTrfNo, String inRhqCd, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			param.put("in_cost_trf_no", inCostTrfNo);
			param.put("in_rhq_cd", inRhqCd);
			param.put("ofc_cd", account.getOfc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new OceanFeederCostManageDBDAOmodifyFeederCostMgtCfmCxlPreVerUSQL(), param, velParam);
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
	 * @param String inCostTrfNo
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void modifyFeederCostMgtCfmCxl(String inCostTrfNo, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			param.put("in_cost_trf_no", inCostTrfNo);
			param.put("usr_ofc_cd", account.getOfc_cd());
			param.put("upd_usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new OceanFeederCostManageDBDAOmodifyFeederCostMgtCfmCxlUSQL(), param, velParam);
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
	 * Ocean Feeder Cost Management tab Special - Save - Update<br>
	 * 
	 * @param List<FeederCostSpecialCargoVO> updModels
	 * @throws DAOException 
	 */
	public void modifyFeederCostSpecialCargoS(List<FeederCostSpecialCargoVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OceanFeederCostManageDBDAOmultiFeederCostSpecialCargoUSQL(), updModels, null);
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
	 * Ocean Feeder Cost Management – Cost Detail  - Retrieve.<br>
	 * 
	 * @param inputVo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOceanFeederCostAccountVO> searchOceanFeederCostAccount(SearchOceanFeederCostAccountVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOceanFeederCostAccountVO> list = null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOSearchOceanFeederCostAccountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOceanFeederCostAccountVO .class);
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
	 * @param OceanFeederCostCondVO oceanFeederCostCondVO
	 * @return List<FeederCostInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FeederCostInquiryVO> searchFeederCostInquiry(OceanFeederCostCondVO oceanFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FeederCostInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(oceanFeederCostCondVO != null){
				Map<String, String> mapVO = oceanFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(oceanFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  oceanFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  oceanFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  oceanFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"ALL".equals(oceanFeederCostCondVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  oceanFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(oceanFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  oceanFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOsearchFeederCostInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FeederCostInquiryVO .class);
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
	 * @param oceanFeederCostCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FeederCostDGVO> searchFeederCostDG(OceanFeederCostCondVO oceanFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FeederCostDGVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(oceanFeederCostCondVO != null){
				Map<String, String> mapVO = oceanFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(oceanFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  oceanFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  oceanFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  oceanFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOSearchFeederCostDGRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FeederCostDGVO .class);
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
	 * @param oceanFeederCostCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FeederCostInquiryVO> searchFeederCostRF(OceanFeederCostCondVO oceanFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FeederCostInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(oceanFeederCostCondVO != null){
				Map<String, String> mapVO = oceanFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(oceanFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  oceanFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  oceanFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  oceanFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"ALL".equals(oceanFeederCostCondVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  oceanFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(oceanFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  oceanFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOSearchFeederCostRFRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FeederCostInquiryVO .class);
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
	 * @param OceanFeederCostCondVO oceanFeederCostCondVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFeederCostInquiryExcel(OceanFeederCostCondVO oceanFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(oceanFeederCostCondVO != null){
				Map<String, String> mapVO = oceanFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(oceanFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  oceanFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  oceanFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  oceanFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(oceanFeederCostCondVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  oceanFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(oceanFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  oceanFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOsearchFeederCostInquiryRSQL(), param, velParam);
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
	 * @param oceanFeederCostCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchFeederCostDGExcel(OceanFeederCostCondVO oceanFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(oceanFeederCostCondVO != null){
				Map<String, String> mapVO = oceanFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(oceanFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  oceanFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  oceanFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  oceanFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOSearchFeederCostDGRSQL(), param, velParam);
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
	 * @param OceanFeederCostCondVO oceanFeederCostCondVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchFeederCostRFExcel(OceanFeederCostCondVO oceanFeederCostCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(oceanFeederCostCondVO != null){
				Map<String, String> mapVO = oceanFeederCostCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(oceanFeederCostCondVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  oceanFeederCostCondVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getFromNodCd())){
					List<String> fromNodCds = new ArrayList<String>();
					String[] arrfromNodCd =  oceanFeederCostCondVO.getFromNodCd().split(",");
					for(int i = 0; i < arrfromNodCd.length; i ++){
						fromNodCds.add(arrfromNodCd[i]);
					}
					velParam.put("fromNodCds", fromNodCds);
				}
				
				if(!"".equals(oceanFeederCostCondVO.getToNodCd())){
					List<String> toNodCds = new ArrayList<String>();
					String[] arrtoNodCd =  oceanFeederCostCondVO.getToNodCd().split(",");
					for(int i = 0; i < arrtoNodCd.length; i ++){
						toNodCds.add(arrtoNodCd[i]);
					}
					velParam.put("toNodCds", toNodCds);
				}
				
				if(!"ALL".equals(oceanFeederCostCondVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  oceanFeederCostCondVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(oceanFeederCostCondVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  oceanFeederCostCondVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOSearchFeederCostRFRSQL(), param, velParam);
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
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OceanFeederCostManageDBDAOVerifyFeederCostTrfNoRSQL(), null, velParam);
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