/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostManageDBDAO.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.CntDefaultCurrVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.CntInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostConditionVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostDetailVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostSpecialCargoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostTariffInfoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostTariffNoVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlnadCostInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlnadCostSpeInquiryVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.RHQComboVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.SearchInlandCostAccountVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.SearchStatusMonitorVO;
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
 * ALPS InlandCostManageDBDAO <br>
 * - ALPS-CostManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong Ock
 * @see CostManageBCImpl 참조
 * @since J2EE 1.6
 */
public class InlandCostManageDBDAO extends DBDAOSupport {

	/**
	 * Inland Cost Management tab Dry - Retrieve<br>
	 * 
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @return List<InlandCostVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InlandCostVO> searchInlandCost(InlandCostConditionVO inlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlandCostVO> list = null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchInlandCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InlandCostVO .class);
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
	 * Inland Cost Management tab Special - Retrieve<br>
	 * 
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @return List<InlandCostSpecialCargoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InlandCostSpecialCargoVO> searchInlandCostSpecialCargo(InlandCostConditionVO inlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlandCostSpecialCargoVO> list = null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchInlandCostSpecialCargoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InlandCostSpecialCargoVO .class);
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
	 * @return List<InlandCostTariffNoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InlandCostTariffNoVO> searchInlandCostTariffNo(String inCntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlandCostTariffNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cnt_cd", inCntCd);
			velParam.put("in_cnt_cd", inCntCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchInlandCostTariffNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InlandCostTariffNoVO .class);
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOverifyCountryCodeRSQL(), param, velParam);
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
	 * @return InlandCostTariffInfoVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public InlandCostTariffInfoVO searchInlandCostTariffInfo(String inCostTrfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlandCostTariffInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("in_cost_trf_no", inCostTrfNo);
			velParam.put("in_cost_trf_no", inCostTrfNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchInlandCostTariffInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InlandCostTariffInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?new InlandCostTariffInfoVO():list.get(0);
	}

	/**
	 * Inland Cost Management tab Dry - Save<br>
	 * 
	 * @param List<InlandCostVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCost(List<InlandCostVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InlandCostManageDBDAOmultiInlandCostUSQL(), updModels, null);
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
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void multiInlandCostHdr(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new InlandCostManageDBDAOmultiInlandCostHdrUSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOverifyInlandCostConfirmRSQL(), param, velParam);
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
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmInlandCostPreVer(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new InlandCostManageDBDAOconfirmInlandCostPreVerUSQL(), param, velParam);
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
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void confirmInlandCost(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new InlandCostManageDBDAOconfirmInlandCostUSQL(), param, velParam);
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
	 * Inland Cost Management tab Special - Save - Create<br>
	 * 
	 * @param List<InlandCostSpecialCargoVO> insModels
	 * @throws DAOException
	 */
	public void addInlandCostSpecialCargoS(List<InlandCostSpecialCargoVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InlandCostManageDBDAOmultiInlandCostSpecialCargoCSQL(), insModels,null);
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
	 * Inland Cost Management tab Special - Save - Update<br>
	 * 
	 * @param List<InlandCostSpecialCargoVO> updModels
	 * @throws DAOException 
	 */
	public void modifyInlandCostSpecialCargoS(List<InlandCostSpecialCargoVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InlandCostManageDBDAOmultiInlandCostSpecialCargoUSQL(), updModels, null);
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
	 * Inland Cost Management tab Special - Save - Delete<br>
	 * 
	 * @param List<InlandCostSpecialCargoVO> delModels
	 * @throws DAOException
	 */
	public void removeInlandCostSpecialCargoS(List<InlandCostSpecialCargoVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new InlandCostManageDBDAOmultiInlandCostSpecialCargoDSQL(), delModels,null);
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
	 * Inland Cost Management – Route Detail  - Retrieve<br>
	 * 
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @return List<InlandCostDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InlandCostDetailVO> searchInlandCostDetail(InlandCostConditionVO inlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlandCostDetailVO> list = null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchInlandCostDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InlandCostDetailVO .class);
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
	 * @param List<InlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailSelect(List<InlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InlandCostManageDBDAOmultiInlandCostDetailSelectUSQL(), updModels, null);
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
	 * @param List<InlandCostDetailVO> updModels
	 * @return String
	 * @throws DAOException
	 */
	public String searchInlandCostDetailDeleteCheck(List<InlandCostDetailVO> updModels) throws DAOException {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchInlandCostDetailDeleteCheckRSQL(), null, velParam);
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
	 * @param List<InlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailDelete(List<InlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InlandCostManageDBDAOmultiInlandCostDetailDeleteUSQL(), updModels, null);
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
	 * @param List<InlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetail1stSelect(List<InlandCostDetailVO> updModels) throws EventException, DAOException {
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
				result = sqlExe.executeUpdate((ISQLTemplate)new InlandCostManageDBDAOmultiInlandCostDetail1stSelectUSQL(), param, velParam);
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
	 * @param List<InlandCostDetailVO> updModels
	 * @throws DAOException 
	 */
	public void multiInlandCostDetailRest(List<InlandCostDetailVO> updModels) throws EventException, DAOException {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InlandCostManageDBDAOmultiInlandCostDetailRestUSQL(), updModels, null);
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
	public List<SearchInlandCostAccountVO> searchInlandCostAccount(SearchInlandCostAccountVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInlandCostAccountVO> list = null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOSearchInlandCostAccountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInlandCostAccountVO .class);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchRHQComboRSQL(), param, velParam);
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchCntDefaultCurrRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchCntInfoRSQL(), param, velParam);
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
	 * @param String inCurrCd
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchCurrNmRSQL(), param, velParam);
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
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InlandCostManageDBDAOmultiCntDefaultCurrCSQL(), insModels,null);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOSearchDupChkCostTrfCurrRSQL(), param, velParam);
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
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InlandCostManageDBDAOmultiCntDefaultCurrUSQL(), updModels, null);
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
				delCnt = sqlExe.executeBatch((ISQLTemplate)new InlandCostManageDBDAOmultiCntDefaultCurrDSQL(), delModels,null);
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
			 
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOverifyCurrencyCodeRSQL(), null, velParam);
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
	 * Cost & Guideline Tariff Status Monitoring - Retrieve.<br>
	 * 
	 * @param inputVo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchStatusMonitorVO> searchStatusMonitor(SearchStatusMonitorVO inputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchStatusMonitorVO> list = null;
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOSearchStatusMonitorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStatusMonitorVO .class);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOSearchShqOfcFlgRSQL(), param, null);
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
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @return List<InlnadCostInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InlnadCostInquiryVO> searchInlnadCostInquiry(InlandCostConditionVO inlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlnadCostInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(inlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  inlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"".equals(inlandCostConditionVO.getHubNodCd())){
					List<String> hubNodCds = new ArrayList<String>();
					String[] arrhubNodCd =  inlandCostConditionVO.getHubNodCd().split(",");
					for(int i = 0; i < arrhubNodCd.length; i ++){
						hubNodCds.add(arrhubNodCd[i]);
					}
					velParam.put("hubNodCds", hubNodCds);
				}
				
				if(!"".equals(inlandCostConditionVO.getPortNodCd())){
					List<String> portNodCds = new ArrayList<String>();
					String[] arrportNodCd =  inlandCostConditionVO.getPortNodCd().split(",");
					for(int i = 0; i < arrportNodCd.length; i ++){
						portNodCds.add(arrportNodCd[i]);
					}
					velParam.put("portNodCds", portNodCds);
				}
				
				if(!"ALL".equals(inlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  inlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(inlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  inlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(inlandCostConditionVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  inlandCostConditionVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(inlandCostConditionVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  inlandCostConditionVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchInlnadCostInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InlnadCostInquiryVO .class);
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
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @return List<InlnadCostSpeInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InlnadCostSpeInquiryVO> searchInlnadCostSpeInquiry(InlandCostConditionVO inlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlnadCostSpeInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(inlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  inlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						if(arrlocNodCd[i].length() > 1){
							locNodCds.add(arrlocNodCd[i].substring(0,2));
						}else{
							locNodCds.add(arrlocNodCd[i]);
						}
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"ALL".equals(inlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  inlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(inlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  inlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchInlnadCostSpeInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InlnadCostSpeInquiryVO .class);
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
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInlnadCostInquiryExcel(InlandCostConditionVO inlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"".equals(inlandCostConditionVO.getLocNodCd())){
					List<String> locNodCds = new ArrayList<String>();
					String[] arrlocNodCd =  inlandCostConditionVO.getLocNodCd().split(",");
					for(int i = 0; i < arrlocNodCd.length; i ++){
						locNodCds.add(arrlocNodCd[i]);
					}
					velParam.put("locNodCds", locNodCds);
				}
				
				if(!"".equals(inlandCostConditionVO.getHubNodCd())){
					List<String> hubNodCds = new ArrayList<String>();
					String[] arrhubNodCd =  inlandCostConditionVO.getHubNodCd().split(",");
					for(int i = 0; i < arrhubNodCd.length; i ++){
						hubNodCds.add(arrhubNodCd[i]);
					}
					velParam.put("hubNodCds", hubNodCds);
				}
				
				if(!"".equals(inlandCostConditionVO.getPortNodCd())){
					List<String> portNodCds = new ArrayList<String>();
					String[] arrportNodCd =  inlandCostConditionVO.getPortNodCd().split(",");
					for(int i = 0; i < arrportNodCd.length; i ++){
						portNodCds.add(arrportNodCd[i]);
					}
					velParam.put("portNodCds", portNodCds);
				}
				
				if(!"ALL".equals(inlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  inlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(inlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  inlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}

				if(!"ALL".equals(inlandCostConditionVO.getCostFactorCd())){
					String fullTrans20 = "N";
					String fullTrans40 = "N";
					String tmnl20 = "N";
					String tmnl40 = "N";
					String empty20 = "N";
					String empty40 = "N";
					
					List<String> costFactorCds = new ArrayList<String>();
					String[] arrcostFactorCd =  inlandCostConditionVO.getCostFactorCd().split(",");
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
				
				if(!"ALL".equals(inlandCostConditionVO.getSysSrcCd())){
					List<String> sysSrcCds = new ArrayList<String>();
					String[] arrsysSrcCd =  inlandCostConditionVO.getSysSrcCd().split(",");
					for(int i = 0; i < arrsysSrcCd.length; i ++){
						sysSrcCds.add(arrsysSrcCd[i]);
					}
					velParam.put("sysSrcCds", sysSrcCds);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchInlnadCostInquiryRSQL(), param, velParam);
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
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @return DBRowSet DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInlnadCostSpeInquiryExcel(InlandCostConditionVO inlandCostConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(!"ALL".equals(inlandCostConditionVO.getTrspCrrModCd())){
					List<String> trspCrrModCds = new ArrayList<String>();
					String[] arrtrspCrrModCd =  inlandCostConditionVO.getTrspCrrModCd().split(",");
					for(int i = 0; i < arrtrspCrrModCd.length; i ++){
						trspCrrModCds.add(arrtrspCrrModCd[i]);
					}
					velParam.put("trspCrrModCds", trspCrrModCds);
				}

				if(!"".equals(inlandCostConditionVO.getCostTrfNo())){
					List<String> costTrfNos = new ArrayList<String>();
					String[] arrcostTrfNo =  inlandCostConditionVO.getCostTrfNo().split(",");
					for(int i = 0; i < arrcostTrfNo.length; i ++){
						costTrfNos.add(arrcostTrfNo[i]);
					}
					velParam.put("costTrfNos", costTrfNos);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchInlnadCostSpeInquiryRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOsearchInlandCostGuidelineExistRSQL(), param, velParam);
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
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void modifyInlandCostMgtCfmCxl(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new InlandCostManageDBDAOmodifyInlandCostMgtCfmCxlUSQL(), param, velParam);
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
	 * @param InlandCostConditionVO inlandCostConditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException 
	 */
	public void modifyInlandCostMgtCfmCxlPreVer(InlandCostConditionVO inlandCostConditionVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(inlandCostConditionVO != null){
				Map<String, String> mapVO = inlandCostConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("ofc_cd", account.getOfc_cd());				
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new InlandCostManageDBDAOmodifyInlandCostMgtCfmCxlPreVerUSQL(), param, velParam);
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
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InlandCostManageDBDAOVerifyInlndCostTrfNoRSQL(), null, velParam);
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