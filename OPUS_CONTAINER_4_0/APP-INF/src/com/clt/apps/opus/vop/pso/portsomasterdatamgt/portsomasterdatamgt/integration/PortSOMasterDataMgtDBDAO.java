/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSOMasterDataMgtDAO.java
*@FileTitle : Bank Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.30 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.basic.PortSOMasterDataMgtBCImpl;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.AuditDataCheckListVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.CurrencyVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultCostVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.DefaultVendorVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoInvOfcYdVO;
import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.SearchYardsVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS PortSOMasterDataMgtDAO <br>
 * - ALPS-PortSOMasterDataMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jin Ihl
 * @see PortSOMasterDataMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class PortSOMasterDataMgtDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Subject Favorites : 선박 vessel 조회            
	 * 
	 * @param String fromDate
	 * @param String toDate
	 * @param String srhCnd
	 * @return List<AuditDataCheckListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AuditDataCheckListVO> searchAuditDataCheckList(String fromDate, String toDate, String srhCnd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<AuditDataCheckListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fromDate != null && toDate != null && srhCnd != null ){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("from_date", fromDate);
				hMap.put("to_date", toDate);
				hMap.put("srh_cnd", srhCnd);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDBDAOSearchAuditDataCheckListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AuditDataCheckListVO .class);
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
	 *  vndrSeq를 기준으로 해당 Vendor의 이름을 조회한다.
	 * @param String vndrSeq
	 * @return String 
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String searchVendorInfo(String vndrSeq) throws DAOException {
		// TODO Auto-generated method stub
		String strRet = "";
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vndrSeq != null ){
				HashMap hMap = new HashMap<String, Integer>();
				hMap.put("vndr_seq", vndrSeq);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOsearchVendorsRSQL(), param, velParam);
			if(dbRowset.next())
				strRet = dbRowset.getString("VNDR_LGL_ENG_NM");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		//return list.toString();
		return strRet;
	}
	

	/**
	 * Subject Favorites : pso yard조회            
	 * 
	 * @param String ofcCd
	 * @param String ydCd
	 * @return List<SearchYardsVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchYardsVO> searchPsoYardList(String ofcCd , String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchYardsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("ofc_cd", ofcCd);
				hMap.put("yd_cd", ydCd);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOsearchPsoYardsRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchYardsVO .class);
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
	 * Subject Favorites : yard 조회            
	 * @param String ofcCd 
	 * @param String ydCd
	 * @return List<SearchYardsVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchYardsVO> searchYardList(String ofcCd , String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchYardsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("ofc_cd", ofcCd);
				hMap.put("yd_cd", ydCd);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOsearchYardsRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchYardsVO .class);
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
	 * Subject Favorites : yard 조회            
	 * @param String ofcCd
	 * @return List<PsoInvOfcYdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsoInvOfcYdVO> searchYardListByUserOffice(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoInvOfcYdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("ofc_cd", ofcCd);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOsearchYardListByUserOfficeRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoInvOfcYdVO .class);
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
	 * Subject Favorites : vendor 조회            
	 * @param String ofcCd
	 * @return List<DefaultVendorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DefaultVendorVO> searchVendorListByUserOffice(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<DefaultVendorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("ofc_cd", ofcCd);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOsearchVendorListByUserOfficeRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DefaultVendorVO .class);
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
	 * Subject Favorites : cost 조회            
	 * @param String ofcCd
	 * @param String chargeType
	 * @return List<DefaultCostVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DefaultCostVO> searchCostListByUserOffice(String ofcCd, String chargeType) throws DAOException {
		DBRowSet dbRowset = null;
		List<DefaultCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("ofc_cd", ofcCd);
				hMap.put("charge_type", chargeType);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOsearchCostListByUserOfficeRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DefaultCostVO .class);
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
	 *  vndrSeq를 기준으로 해당 Vendor의 BankInfo를 조회한다.
	 * @param Integer vndrSeq
	 * @return String 
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String searchAgentBankInfo(Integer vndrSeq) throws DAOException {
		// TODO Auto-generated method stub
		String strRet = "";
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vndrSeq != null && vndrSeq >= 0){
				HashMap hMap = new HashMap<String, Integer>();
				hMap.put("vndr_seq", vndrSeq);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOsearchAgentBankInfoRSQL(), param, velParam);
			if(dbRowset.next())
				strRet = dbRowset.getString("CNL_AGN_BANK_DESC");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		//return list.toString();
		return strRet;
	}
	


	/**
	 * pso_inv_ofc_yd 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoInvOfcYdVO> psoInvOfcYdVOs
	 * @throws DAOException
	 */
	public void addOfficeYards(List<PsoInvOfcYdVO> psoInvOfcYdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoInvOfcYdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortSOMasterDataMgtDAOaddOfficeYardsCSQL(), psoInvOfcYdVOs,null);
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
	 * pso_inv_ofc_cost 데이터를 저장한다.<br>
	 * 
	 * @param List<DefaultCostVO> defaultCostVOs
	 * @throws DAOException
	 */
	public void addOfficeCosts(List<DefaultCostVO> defaultCostVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(defaultCostVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortSOMasterDataMgtDAOaddOfficeCostsCSQL(), defaultCostVOs,null);
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
	 * pso_inv_ofc_vndr 데이터를 저장한다.<br>
	 * 
	 * @param List<DefaultVendorVO> defaultVendorVOs
	 * @throws DAOException
	 */
	public void addOfficeVendors(List<DefaultVendorVO> defaultVendorVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(defaultVendorVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortSOMasterDataMgtDAOaddOfficeVendorsCSQL(), defaultVendorVOs,null);
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
	 * pso_inv_ofc_yd 데이터를 삭제한다.<br>
	 * @param List<PsoInvOfcYdVO> psoInvOfcYdVOs
	 * @throws DAOException
	 */
	public void removeOfficeYards(List<PsoInvOfcYdVO> psoInvOfcYdVOs) throws DAOException,Exception {
		
		//String ofcCd = psoInvOfcYdVOs.get(0).getOfcCd();
		//query parameter
		//Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		//int result = 0;
		try {
			int insCnt[] = null;
			if(psoInvOfcYdVOs.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new PortSOMasterDataMgtDAOremoveOfficeYardsDSQL(), psoInvOfcYdVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Remove No"+ i + " SQL");
				}
			}
			
			/*
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortSOMasterDataMgtDAOremoveOfficeYardsDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to Remove SQL");
			}
			*/
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * PSO_INV_OFC_COST 데이터를 삭제한다.<br>
	 * @param List<DefaultCostVO> defaultCostVOs
	 * @throws DAOException
	 */
	public void removeOfficeCosts(List<DefaultCostVO> defaultCostVOs) throws DAOException,Exception {
		/*
		String ofcCd = defaultCostVOs.get(0).getOfcCd();
		String chargeType = defaultCostVOs.get(0).getChargeType();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		*/
		try {
			int insCnt[] = null;
			if(defaultCostVOs.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new PortSOMasterDataMgtDAOremoveOfficeCostsDSQL(), defaultCostVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Remove No"+ i + " SQL");
				}
			}
			/*
			param.put("ofc_cd", ofcCd);
			param.put("charge_type", chargeType);
			velParam.put("ofc_cd", ofcCd);
			velParam.put("charge_type", chargeType);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortSOMasterDataMgtDAOremoveOfficeCostsDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to Remove SQL");
			}*/
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * pso_inv_ofc_vndr 데이터를 삭제한다.<br>
	 * @param List<DefaultVendorVO> defaultVendorVOs
	 * @throws DAOException
	 */
	public void removeOfficeVendors(List<DefaultVendorVO> defaultVendorVOs) throws DAOException,Exception {
		/*
		String ofcCd = defaultVendorVOs.get(0).getOfcCd();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		*/
		try {
			int insCnt[] = null;
			if(defaultVendorVOs.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new PortSOMasterDataMgtDAOremoveOfficeVendorsDSQL(), defaultVendorVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Remove No"+ i + " SQL");
				}
			}
			/*
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortSOMasterDataMgtDAODefaultVendorVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to Remove SQL");
			}*/
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Invoice Creation & Audit 화면의 초기 데이터 쿼리
	 * @category VOP_PSO_0014_WndowsOpen
	 * @param String ofcCd
	 * @param String chargeType
	 * @param String cnlAgnFlg
	 * @return List<DefaultCostVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DefaultCostVO> searchOfficeCosts(String ofcCd, String chargeType, String cnlAgnFlg) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<DefaultCostVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(ofcCd != null && !ofcCd.equals("")){
				param.put("ofc_cd", ofcCd);
				velParam.put("ofc_cd", ofcCd);
			}
			cnlAgnFlg = (cnlAgnFlg != null && !cnlAgnFlg.equals("")) ? cnlAgnFlg : "N";
			if(cnlAgnFlg != null && !cnlAgnFlg.equals("")){
				param.put("cnl_anag_flg", cnlAgnFlg);
				velParam.put("cnl_anag_flg", cnlAgnFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOsearchOfficeCostsRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DefaultCostVO.class);
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
	 * Invoice Creation & Audit 화면의 초기 데이터 쿼리
	 * @category VOP_PSO_0014_WndowsOpen
	 * @param String currCd
	 * @param String issDt
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchExistExchageRate(String currCd, String issDt) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String strRet = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("curr_cd", currCd);
			param.put("iss_dt", issDt);
			

			velParam.put("curr_cd", currCd);
			velParam.put("iss_dt", issDt);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOSearchExistExchangeRateRSQL(), param, velParam);
			if(dbRowset.next())
				strRet = dbRowset.getString("EXIST_YN");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}

	/**
	 * 로긴 유저의 office Yard 를 조회 한다.
	 * @param String ofcCd
	 * @return List<PsoInvOfcYdVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PsoInvOfcYdVO> searchOfficeYards(String ofcCd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<PsoInvOfcYdVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(ofcCd != null && !ofcCd.equals("")){
				param.put("ofc_cd", ofcCd);
				velParam.put("ofc_cd", ofcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOsearchOfficeYardsRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoInvOfcYdVO.class);
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
	 * Currency 정보를 조회한다. 
	 * @return List<CurrencyVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CurrencyVO> searchCurrency() throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CurrencyVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDBDAOsearchCurrencyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CurrencyVO.class);
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
	 * VOP_PSO_0014 : Window Open <br/>
	 * Invoice Creation & Audit 화면의 초기 데이터 쿼리
	 * @category VOP_PSO_0014_WndowsOpen
	 * @param String ofcCd
	 * @return List<DefaultVendorVO>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DefaultVendorVO> searchOfficeVendors(String ofcCd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<DefaultVendorVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(ofcCd != null && !ofcCd.equals("")){
				param.put("ofc_cd", ofcCd);
				velParam.put("ofc_cd", ofcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDBDAOsearchOfficeVendorsRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DefaultVendorVO.class);
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
	 * Search Exist Office Cost 존재 여부.
	 * @param DefaultCostVO defaultCostVO
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchExistOfficeCost(DefaultCostVO defaultCostVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String strRet = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(defaultCostVO != null){
				Map<String, String> mapVO = defaultCostVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOSearchExistOfficeCostRSQL(), param, velParam);
			if(dbRowset.next())
				strRet = dbRowset.getString("EXIST_YN");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}


	/**
	 * Search Exist Office Yard 존재 여부.
	 * @param PsoInvOfcYdVO psoInvOfcYdVO
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchExistOfficeYard(PsoInvOfcYdVO psoInvOfcYdVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String strRet = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(psoInvOfcYdVO != null){
				Map<String, String> mapVO = psoInvOfcYdVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOSearchExistOfficeYardRSQL(), param, velParam);
			if(dbRowset.next())
				strRet = dbRowset.getString("EXIST_YN");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}


	/**
	 * Search Exist Office Vendor 존재 여부.
	 * @param DefaultVendorVO defaultVendorVO
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchExistOfficeVendor(DefaultVendorVO defaultVendorVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String strRet = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(defaultVendorVO != null){
				Map<String, String> mapVO = defaultVendorVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSOMasterDataMgtDAOSearchExistOfficeVendorRSQL(), param, velParam);
			if(dbRowset.next())
				strRet = dbRowset.getString("EXIST_YN");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
}
