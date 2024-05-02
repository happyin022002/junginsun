/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffTariffDBDAO.java
*@FileTitle : Drop Off Tariff Management
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.02 
*@LastModifier : YOON Yong-Sang 
*@LastVersion : 1.1
* 2015.12.02 YOON Yong-Sang 1.0 최초 생성
* -------------------------------------------------------
* History
* 2000.00.00 
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.integration.DropOffInquiryDBDAOsearchDropOffInvoiceInquiryDetailListRSQL;
import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.basic.DropOffTariffBCImpl;
import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.vo.SearchDodTariffListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 DropOffTariffDBDAO <br>
 * - NIS2010 Drop Off Tariff Management system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see DropOffTariffBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class DropOffTariffDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO searchDodTariffListVO
	 * @return List<SearchDodTariffListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchDodTariffListVO> searchDodTariffList(SearchDodTariffListVO searchDodTariffListVO) throws DAOException {		
		DBRowSet dbRowset = null;
		List<SearchDodTariffListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchDodTariffListVO != null){
				Map<String, String> mapVO = searchDodTariffListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffTariffDBDAOSearchDodTariffListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDodTariffListVO.class);

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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO searchDodTariffListVO
	 * @return List<SearchDodTariffListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchDodTariffListVO> searchDodTariffConti(SearchDodTariffListVO searchDodTariffListVO) throws DAOException {		
		DBRowSet dbRowset = null;
		List<SearchDodTariffListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchDodTariffListVO != null){
				Map<String, String> mapVO = searchDodTariffListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffTariffDBDAOSearchDodTariffContiRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDodTariffListVO.class);

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
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 * 
		 * @param SearchDodTariffListVO searchDodTariffListVO
		 * @param String sTrfDivCd
		 * @return List<SearchDodTariffListVO>
		 * @throws DAOException
		 */
	public List<SearchDodTariffListVO> searchDodTariffList (SearchDodTariffListVO searchDodTariffListVO, String sTrfDivCd) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchDodTariffListVO> list = null;
		String sTrfCfmPage = "TC"; //tariff confirm
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchDodTariffListVO != null){
				Map<String, String> mapVO = searchDodTariffListVO .getColumnValues();
				
				param.putAll(mapVO);
				param.put("s_trf_div_cd", sTrfDivCd);
				param.put("s_trf_cfm_page",sTrfCfmPage);  // tariff confirm page 조회 용 
				velParam.putAll(mapVO);
				velParam.put("s_trf_div_cd", sTrfDivCd);
				velParam.put("s_trf_cfm_page",sTrfCfmPage);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffTariffDBDAOSearchDodTariffListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDodTariffListVO.class);

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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchDodTariffListVO> searchDodTariffListVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeDodTariffData(List<SearchDodTariffListVO> searchDodTariffListVOs) throws DAOException,Exception {
		int cnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");			
			if(searchDodTariffListVOs.size() > 0){
		        cnt = sqlExe.executeBatch((ISQLTemplate) new DropOffTariffDBDAORemoveDodTariffDataDSQL() , searchDodTariffListVOs, null);
		        for(int i = 0; i < cnt.length; i++){
					if(cnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchDodTariffListVO> searchDodTariffListVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyDodTariffData(List<SearchDodTariffListVO> searchDodTariffListVOs) throws DAOException,Exception {
		int cnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");			
			if(searchDodTariffListVOs.size() > 0){
		        cnt = sqlExe.executeBatch((ISQLTemplate) new DropOffTariffDBDAOModifyDodTariffDataUSQL() , searchDodTariffListVOs, null);
		        for(int i = 0; i < cnt.length; i++){
					if(cnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchDodTariffListVO> searchDodTariffListVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addDodTariffData(List<SearchDodTariffListVO> searchDodTariffListVOs) throws DAOException,Exception {
		int cnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchDodTariffListVOs.size() > 0){
				cnt = sqlExe.executeBatch((ISQLTemplate)new DropOffTariffDBDAOAddDodTariffDataCSQL(), searchDodTariffListVOs,null);
				for(int i = 0; i < cnt.length; i++){
					if(cnt[i]== Statement.EXECUTE_FAILED)
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
		return cnt;
	}
	
	
	 /**
	  * DodTariffList Confirm
	  * @param searchDodTariffListVOs
	  * @throws DAOException
	  */
	 
	public void manageConfirmDodTariffList(List<SearchDodTariffListVO> confirmDodTariffList) throws DAOException{
	try{
		SQLExecuter sqlExe = new SQLExecuter("");
		int updCnt[] = null;
		if(confirmDodTariffList.size()>0){
			updCnt = sqlExe.executeBatch((ISQLTemplate)new DropOffTariffDBDAOModifyConfirmDodTariffListUSQL(), confirmDodTariffList, null);
			for (int i = 0 ; i<updCnt.length; i++){
				if(updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + "SQL");
			}
		}
	
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
}	
	}
	 
	 
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchDodTariffListVO> searchDodTariffListVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] expireDodTariffData(List<SearchDodTariffListVO> searchDodTariffListVOs) throws DAOException,Exception {
		int cnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchDodTariffListVOs.size() > 0){
				cnt = sqlExe.executeBatch((ISQLTemplate)new DropOffTariffDBDAOExpireDodTariffDataUSQL(), searchDodTariffListVOs,null);
				for(int i = 0; i < cnt.length; i++){
					if(cnt[i]== Statement.EXECUTE_FAILED)
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
		return cnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchDodTariffListVO> searchDodTariffListVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] expireRestOfDodTariffData(List<SearchDodTariffListVO> searchDodTariffListVOs) throws DAOException,Exception {
		int cnt[] = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(searchDodTariffListVOs != null && !searchDodTariffListVOs.isEmpty()){
				Map<String, String> mapVO = searchDodTariffListVOs.get(0).getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchDodTariffListVOs.size() > 0){
				cnt = sqlExe.executeBatch((ISQLTemplate)new DropOffTariffDBDAOExpireRestOfDodTariffDataUSQL(), searchDodTariffListVOs,velParam);
				for(int i = 0; i < cnt.length; i++){
					if(cnt[i]== Statement.EXECUTE_FAILED)
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
		return cnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchDodTariffListVO searchDodTariffListVO
	 * @return List<SearchDodTariffListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchDodTariffListVO> searchDodDuplTariffList(SearchDodTariffListVO[] searchDodTariffListVOs) throws DAOException {		
		DBRowSet dbRowset = null;
		List<SearchDodTariffListVO> list = null;
		List<SearchDodTariffListVO> rtnLst = new ArrayList();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchDodTariffListVOs != null && searchDodTariffListVOs.length > 0){
				for(SearchDodTariffListVO vo : searchDodTariffListVOs){
					if("I".equals(vo.getIbflag())){
						Map<String, String> mapVO = vo .getColumnValues();
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DropOffTariffDBDAOSearchDodDuplTariffListRSQL(), param, velParam);
						
						list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDodTariffListVO.class);
						if(list.size() > 0){
							rtnLst.add(list.get(0));
							break;
						}	
					}					
				}				
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnLst;
	}
	 
	 
	/**
	 * DropOff Tarriff Creation Special Customer Tab Grid에서 Customer조회
	 * SC_NO, RFA_NO에 종속된 Customer List를 조회 
	 * @param rfaNo
	 * @param scNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDodTariffSpecialCustomer(String rfaNo, String scNo) throws DAOException {
		DBRowSet dbRowset = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("rfa_no", rfaNo);
			param.put("sc_no", scNo);
			velParam.put("rfa_no", rfaNo);
			velParam.put("sc_no", scNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DropOffTariffDBDAOsearchSpecialCustomerCustomerComboRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
}
