/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsuranceDBDAO.java
*@FileTitle : Insurance Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.insurance.insurance.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.cps.cni.insurance.insurance.basic.InsuranceBCImpl;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomInsuranceVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomPremiumInstallmentVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomPremiumVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.SearchInsuranceVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.SearchPremiumInstallmentListVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.SearchPremiumVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS InsuranceDBDAO <br>
 * - ALPS-Insurance system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon, Seyeong
 * @see InsuranceBCImpl 참조
 * @since J2EE 1.6
 */
public class InsuranceDBDAO extends DBDAOSupport {

	/**
	 * Insurance를 조회한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @return SearchInsuranceVO
	 * @exception DAOException
	 */
	public SearchInsuranceVO searchInsurance(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchInsuranceVO searchInsuranceVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);

			vparam.put("insur_clm_pty_no", insurClmPtyNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InsuranceDBDAOSearchInsuranceVORSQL(), param, vparam);
			if (dbRowset.getRowCount() > 0) {
				searchInsuranceVO = (SearchInsuranceVO)RowSetUtil.rowSetToVOs(dbRowset, SearchInsuranceVO.class ).get(0);
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchInsuranceVO;
	}
	
	/**
	 * Insurance를 생성한다.<br>
	 * 
	 * @param CustomInsuranceVO customInsuranceVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addInsurance(CustomInsuranceVO customInsuranceVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customInsuranceVO .getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InsuranceDBDAOCustomInsuranceVOCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Insurance를 변경한다.<br>
	 * 
	 * @param CustomInsuranceVO customInsuranceVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyInsurance(CustomInsuranceVO customInsuranceVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = customInsuranceVO .getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InsuranceDBDAOCustomInsuranceVOUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Premium를 생성한다.<br>
	 * 
	 * @param CustomPremiumVO customPremiumVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addPremium(CustomPremiumVO customPremiumVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customPremiumVO .getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InsuranceDBDAOCustomPremiumVOCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Premium를 변경한다.<br>
	 * 
	 * @param CustomPremiumVO customPremiumVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyPremium(CustomPremiumVO customPremiumVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = customPremiumVO .getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InsuranceDBDAOCustomPremiumVOUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Premium를 조회한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @return SearchPremiumVO
	 * @exception DAOException
	 */
	public SearchPremiumVO searchPremium(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		SearchPremiumVO searchPremiumVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> vparam = new HashMap<String, Object>();
	
		try{
			
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
			param.put("insur_prm_tp_cd", insurPrmTpCd);
	
			vparam.put("insur_clm_pty_no", insurClmPtyNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InsuranceDBDAOSearchPremiumVORSQL(), param, vparam);
			if (dbRowset.getRowCount() > 0) {
				searchPremiumVO = (SearchPremiumVO)RowSetUtil.rowSetToVOs(dbRowset, SearchPremiumVO.class ).get(0);
			}
	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchPremiumVO;
	}

	/**
	 * Premium Installment를 생성한다.<br>
	 * 
	 * @param List<CustomPremiumInstallmentVO> customPremiumInstallmentVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPremiumInstallments(List<CustomPremiumInstallmentVO> customPremiumInstallmentVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(customPremiumInstallmentVO .size() > 0){
	
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InsuranceDBDAOCustomPremiumInstallmentVOCSQL(), customPremiumInstallmentVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Premium Installment를 변경한다.<br>
	 * 
	 * @param List<CustomPremiumInstallmentVO> customPremiumInstallmentVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyPremiumInstallments(List<CustomPremiumInstallmentVO> customPremiumInstallmentVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(customPremiumInstallmentVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InsuranceDBDAOCustomPremiumInstallmentVOUSQL(), customPremiumInstallmentVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Premium Installment를 삭제한다.<br>
	 * 
	 * @param List<CustomPremiumInstallmentVO> customPremiumInstallmentVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removePremiumInstallments(List<CustomPremiumInstallmentVO> customPremiumInstallmentVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(customPremiumInstallmentVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new InsuranceDBDAOCustomPremiumInstallmentVODSQL(), customPremiumInstallmentVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * Premium Installment를 조회한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @return List<SearchPremiumInstallmentListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchPremiumInstallmentListVO> searchPremiumInstallmentList(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPremiumInstallmentListVO> searchPremiumInstallmentListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> vparam = new HashMap<String, Object>();
	
		try{
			
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
			param.put("insur_prm_tp_cd", insurPrmTpCd);
	
			vparam.put("insur_clm_pty_no", insurClmPtyNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InsuranceDBDAOSearchPremiumInstallmentListVORSQL(), param, vparam);
			searchPremiumInstallmentListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPremiumInstallmentListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchPremiumInstallmentListVO;
	}

	/**
	 * Premium Installment를 조회한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @param String instSeq
	 * @return String
	 * @throws DAOException
	 */
	public String searchPremiumInstallment(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd, String instSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String resultInstSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
			param.put("insur_prm_tp_cd", insurPrmTpCd);
			param.put("inst_seq", instSeq);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InsuranceDBDAOSearchPremiumInstallmentListVORSQL(), param, null);
			
			while (dbRowset.next()) {
				resultInstSeq = dbRowset.getString("inst_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultInstSeq;
	}

	/**
	 * Insurance 보험 등록 되어있는지 검사한다
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckInsurance(String insurTpCd, String insurPlcyYr) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InsuranceDBDAOSearchCheckInsuranceRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("insur_tp_cd");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Insurance 계약을 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeInsuranceContract(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {

			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InsuranceDBDAORemoveInsuranceContractDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Premium를 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePremium(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
	
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
			param.put("insur_prm_tp_cd", insurPrmTpCd);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InsuranceDBDAORemovePremiumDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Insurance 계약을 상세를 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeInsuranceDetail(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
	
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InsuranceDBDAORemoveInsuranceDetailDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 *  Insurance Premium 을 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeInsurancePremium(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
	
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InsuranceDBDAORemoveInsurancePremiumDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Insurance Premium Install을 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeInsurancePremiumInstall(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
	
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InsuranceDBDAORemoveInsurancePremiumInstallDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Premium Install를 삭제한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removePremiumInstall(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
	
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_clm_pty_no", insurClmPtyNo);
			param.put("insur_prm_tp_cd", insurPrmTpCd);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InsuranceDBDAORemovePremiumInstallDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Insurance 보험 Premium 등록 되어있는지 검사한다
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurPrmTpCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckPremium(String insurTpCd, String insurPlcyYr, String insurPrmTpCd) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("insur_tp_cd", insurTpCd);
			param.put("insur_plcy_yr", insurPlcyYr);
			param.put("insur_prm_tp_cd", insurPrmTpCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InsuranceDBDAOSearchCheckPremiumRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("insur_prm_tp_cd");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
}