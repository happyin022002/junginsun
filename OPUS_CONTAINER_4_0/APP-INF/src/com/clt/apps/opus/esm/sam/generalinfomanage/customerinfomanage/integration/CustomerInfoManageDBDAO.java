/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAO.java
*@FileTitle : Customer List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.basic.CustomerInfoManageBCImpl;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustCoverTeamVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustomerGroupCodeVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.MoreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamActivityInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustHistVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustPreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerCodeGroupingVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchKeyManVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmCustAddrVO;


/**
 * OPUS CustomerInfoManageDBDAO <br>
 * - OPUS-GeneralInfoManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author NAMKOONGJINHO
 * @see CustomerInfoManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CustomerInfoManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
	 * ESM_SAM_0001 : Retrieve<br>
  	 * Customer 정보 조회<br>
  	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<SearchCustomerVO >
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCustomerVO > searchCustomerList(SearchCustomerVO  searchCustomerVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCustomerVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCustomerVO  != null){
				Map<String, String> mapVO = searchCustomerVO  .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOSearchCustomerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerVO  .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [Basic Info] 정보를 [Retrieve] 합니다.<br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<SearchCustomerVO >
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCustomerVO > searchCustomerInfo(SearchCustomerVO  searchCustomerVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCustomerVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCustomerVO  != null){
				Map<String, String> mapVO = searchCustomerVO  .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOSearchCustomerInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerVO  .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * [KeyMan Tab] 정보를 [Retrieve] 합니다.<br>
	 * 
	 * @param String customerCode 
	 * @return List<SearchKeyManVO >
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchKeyManVO > searchKeyManList(String customerCode) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchKeyManVO > list2 = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//if(searchCustomerVO  != null){
				
				//Map<String, String> mapVO = searchCustomerVO  .getColumnValues();
				Map<String, String> mapVO = new HashMap<String, String>();
				param.put("cust_cd", customerCode);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
		//	}
			dbRowset = new SQLExecuter("").executeQuery(new CustomerInfoManageDBDAOSearchKeyManaListRSQL(), param, velParam);
			list2 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchKeyManVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list2;
	}
	
	/**
	 * [Address Tab] 정보를 [Retrieve] 합니다.<br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<MdmCustAddrVO >
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCustAddrVO > searchAddressList(SearchCustomerVO  searchCustomerVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCustAddrVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCustomerVO  != null){
				Map<String, String> mapVO = searchCustomerVO  .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManagementDBDAOCustomerAddressListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCustAddrVO  .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [Preference&Needs Tab] 정보를 [Retrieve] 합니다.<br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<SamCustPreInfoVO >
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SamCustPreInfoVO > searchCustomerPreferenceInfo(SearchCustomerVO  searchCustomerVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamCustPreInfoVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCustomerVO  != null){
				Map<String, String> mapVO = searchCustomerVO  .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOSearchCustomerPreferenceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SamCustPreInfoVO  .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [Coverage Team Tab] 정보를 [Retrieve] 합니다.<br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<CustCoverTeamVO >
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustCoverTeamVO > searchCustCoverList(SearchCustomerVO  searchCustomerVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustCoverTeamVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCustomerVO  != null){
				Map<String, String> mapVO = searchCustomerVO  .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOSearchCustCoverListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustCoverTeamVO  .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [Activity Tab] 정보를 [Retrieve] 합니다.<br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<SamActivityInfoVO >
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SamActivityInfoVO > searchCustActvityList(SearchCustomerVO  searchCustomerVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamActivityInfoVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCustomerVO  != null){
				Map<String, String> mapVO = searchCustomerVO  .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOSearchCustActvityListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SamActivityInfoVO  .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [MoreInfo Tab] 정보를 [Retrieve] 합니다.<br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<MoreInfoVO >
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MoreInfoVO > searchMoreInfo(SearchCustomerVO  searchCustomerVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<MoreInfoVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCustomerVO  != null){
				Map<String, String> mapVO = searchCustomerVO  .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOSearchMoreInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MoreInfoVO  .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [History Tab] 정보를 [Retrieve] 합니다.<br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<SamCustHistVO >
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SamCustHistVO > searchCustHistList(SearchCustomerVO  searchCustomerVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamCustHistVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCustomerVO  != null){
				Map<String, String> mapVO = searchCustomerVO  .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOSearchCustHistListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SamCustHistVO  .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * [History Tab] 정보를 [Retrieve] 합니다.<br>
	 * 
	 * @param SearchCustomerCodeGroupingVO  searchCustomerCodeGroupingVO 
	 * @return List<SamCustHistVO >
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCustomerCodeGroupingVO > searchCustomerCodeGrouping(SearchCustomerCodeGroupingVO  searchCustomerCodeGroupingVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCustomerCodeGroupingVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCustomerCodeGroupingVO  != null){
				Map<String, String> mapVO = searchCustomerCodeGroupingVO  .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOSearchCustomerCodeGroupingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerCodeGroupingVO  .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [0903] 정보를 [Retrieve] 합니다.<br>
	 * 
	 * @param CustomerGroupCodeVO  customerGroupCodeVO 
	 * @return List<CustomerGroupCodeVO >
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerGroupCodeVO > searchCustomerGroupCode(CustomerGroupCodeVO  customerGroupCodeVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerGroupCodeVO > list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(customerGroupCodeVO  != null){
				Map<String, String> mapVO = customerGroupCodeVO  .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOSearchCustomerGroupCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerGroupCodeVO  .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 /**
	 * ESM_SAM_0002 : SELECT <br>
	 * [ON_CHANGE] CheckPermission
	 * @param SearchCustomerVO searchCustomerVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkPermission(SearchCustomerVO searchCustomerVO) throws DAOException {
		DBRowSet dbRowset = null;
		String srep_cd_for_samPermission = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchCustomerVO != null) {
				Map<String, String> mapVO = searchCustomerVO  .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CustomerInfoManageDBDAOSearchSrepCdRSQL(),param, velParam);
			if (dbRowset.next()) srep_cd_for_samPermission = dbRowset.getString("srep_cd");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return srep_cd_for_samPermission;
	}

	
	/**
	 * [Preference&Needs Tab] 정보를 [Add] 합니다.<br>
	 * 
	 * @param List<SamCustPreInfoVO> insertVoList
	 * @exception DAOException
	 */
	
	public void addCustomerPreferenceInfo(List<SamCustPreInfoVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAOAddCustomerPreferenceInfoCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	 * [Preference&Needs Tab] 정보를 [Modify] 합니다.<br>
	 * 
	 * @param List<SamCustPreInfoVO> updateVoList
	 * @exception DAOException
	 */
	public void modifyCustomerPreferenceInfo(List<SamCustPreInfoVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAOModifyCustomerPreferenceInfoUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	 * [Preference&Needs Tab] 정보를 [Remove] 합니다.<br>
	 * 
	 * @param List<SamCustPreInfoVO> deleteVoList
	 * @exception DAOException
	 */
	public void removeCustomerPreferenceInfo(List<SamCustPreInfoVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAORemoveCustomerPreferenceInfoDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to Remove No"+ i + " SQL");
					}
				}
			}			} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * [Coverage Team Tab] 정보를 [Add] 합니다.<br>
	 * 
	 * @param List<CustCoverTeamVO> insertVoList 
	 * @exception DAOException
	 */
	public void addCustCoverInfo(List<CustCoverTeamVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAOAddCustCoverInfoCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	 * [Coverage Team Tab] 정보를 [Modify] 합니다.<br>
	 * 
	 * @param List<CustCoverTeamVO> updateVoList 
	 * @exception DAOException
	 */
	public void modifyCustCoverInfo(List<CustCoverTeamVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAOModifyCustCoverInfoUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	 * [Coverage Team Tab] 정보를 [Remove] 합니다.<br>
	 * 
	 * @param List<CustCoverTeamVO> deleteVoList 
	 * @exception DAOException
	 */
	public void removeCustCoverInfo(List<CustCoverTeamVO> deleteVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAORemoveCustCoverInfoUSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to Remove No"+ i + " SQL");
					}
				}
			}			} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * [MoreInfo Tab] 정보를 [Manage] 합니다.<br>
	 * 
	 * @param List<MoreInfoVO> moreInfoVO 
	 * @exception DAOException
	 */
	
	public void modifyMoreInfo(List<MoreInfoVO> moreInfoVO) throws DAOException {	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;

		try {
			if(moreInfoVO.size() > 0){
				Map<String, String> mapVO = moreInfoVO.get(0).getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new CustomerInfoManageDBDAOModifyMoreInfoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");		
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
	 * [History ] 정보를 [Manage] 합니다.<br>
	 * 
	 * @param SamCustHistVO samCustHistVO
	 * @exception DAOException
	 */

	public void addCustHistList(SamCustHistVO samCustHistVO) throws DAOException {
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (samCustHistVO != null) {
				Map<String, String> mapVO = samCustHistVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			sqlExe.executeUpdate((ISQLTemplate) new CustomerInfoManageDBDAOAddCustHisListCSQL(), param, velParam);			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	} 
	
	//@SuppressWarnings("unchecked")
/**
 * ESM_SAM_0004 : SELECT <br>
 * Retrieve   CustomerPFMCGroupDetail
 * 
 * @param SearchCustomerVO searchCustomerVO
 * @return List<SearchCustomerVO>
 * @exception DAOException
 */

public List<SearchCustomerVO> searchCustomerPFMCGroupDetail(SearchCustomerVO searchCustomerVO) throws DAOException {
	DBRowSet dbRowset = null;
	List<SearchCustomerVO> list = null;
	// query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	// velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try {
		if (searchCustomerVO != null) {
			Map<String, String> mapVO = searchCustomerVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CustomerInfoManageDBDAOSearchCustomerPFMCGroupDetailRSQL(), param, velParam);
		list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerVO.class);
	} catch (SQLException se) {
		log.error(se.getMessage(), se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	} catch (Exception ex) {
		log.error(ex.getMessage(), ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return list;
}
 
 /**
	 * ESM_SAM_0004 : SELECT [ADD] ESM_SAM_0902 SHKIM 0215 <br>
	 * [ON_CHANGE] GroupCustomerName
	 * @param SearchCustomerVO searchCustomerVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchGroupCustomerName(SearchCustomerVO searchCustomerVO) throws DAOException {
		DBRowSet dbRowset = null;
		String repInfo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchCustomerVO != null) {
				param.put("cust_grp_id", searchCustomerVO.getCustGrpId());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CustomerInfoManageDBDAOsearchGroupCustomerNameRSQL(),param, velParam);
			if (dbRowset.next()) repInfo = dbRowset.getString("cust_grp_nm");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repInfo;
	}
	
	/**
	 * Sales Rep Code 를 가져옵니다.<br>
	 * 
	 * @param String custCd
	 * @param String srepCd
	 * @return DBRowSet
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkSalesRepCode(String custCd, String srepCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		try{
			if(custCd != null && srepCd != null){
				param.put("cust_cd", custCd);
				param.put("srep_cd", srepCd);
			}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOCheckSalesRepCodeRSQL(), param, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}		
	
	/**
	 * Manage Sales Rep Info 정보 변경.<br>
	 * 
	 * @param List<MdmCustomerVO> updateList
	 * @exception DAOException
	 */
	public void modifyPrimaryFlg(List<MdmCustomerVO> updateList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAOModifyPrimaryFlgUSQL(), updateList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to Remove No"+ i + " SQL");
					}
				}
			}			} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *Manage Sales Rep Info 정보 변경.<br>
	 * 
	 * @param List<MdmCustomerVO> insertVoList
	 * @exception DAOException
	 */
	public void addPrimaryFlg(List<MdmCustomerVO> insertVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAOAddPrimaryFlgCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to Remove No"+ i + " SQL");
					}
				}
			}			} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Manage Sales Rep Info 정보 변경.<br>
	 * 
	 * @param List<MdmCustomerVO> updateVoList
	 * @exception DAOException 
	 */
	public void modifyAfterPrimaryFlg(List<MdmCustomerVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAOModifyAfterPrimaryFlgUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to Remove No"+ i + " SQL");
					}
				}
			}			} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * ESM_SAM_0011 : Retrieve<br>
	 * Group Code에 해당하는 Customer Detail 정보를 조회합니다.<br>
	 * 
	 * @param CustomerGroupCodeVO customerGroupCodeVO
	 * @return List<CustomerGroupCodeVO>
	 * @exception DAOException
	 */		
 	public List<CustomerGroupCodeVO> searchCustomerGroupCodeDetail(CustomerGroupCodeVO customerGroupCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerGroupCodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(customerGroupCodeVO != null){
				Map<String, String> mapVO = customerGroupCodeVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOSearchCustomerGroupCodeDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerGroupCodeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
 	
 	
 	
	/**
	 * Customer의 Sales Rep 변경 정보를 저장합니다.<br>
	 * 
	 * @param List<SearchCustomerVO> updateVoList
	 * @exception DAOException
	 */
	public void modifySalesRepAdjustment(List<SearchCustomerVO> updateVoList) throws DAOException {
		int creCnt[] = null;
		try{
				SQLExecuter sqlExe = new SQLExecuter("");
				if(updateVoList.size() > 0){
//					sam_cust_sls_rep_info table에 delete flag update한다.
					creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAOmodifySalesRepAdjustmentUSQL(), updateVoList, null);
					for(int j=0; j<creCnt.length;j++){
						if(creCnt[j] == Statement.EXECUTE_FAILED){
							throw new DAOException("Fail to Update No"+ j + " SQL");
						}
					}
//                  sam_cust_sls_rep_info table에 insert 한다.						
//					creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAOmodifySalesRepAdjstSlsActRptUSQL(), updateVoList, null);
//					for(int i=0; i<creCnt.length;i++){
//						if(creCnt[i] == Statement.EXECUTE_FAILED){
//							throw new DAOException("Fail to Update No"+ i + " SQL");
//						}
//					
//					creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAOmodifySalesRepAdjstSlsActUSQL(), updateVoList, null);
//					for(int k=0; k<creCnt.length;k++){
//						if(creCnt[k] == Statement.EXECUTE_FAILED){
//							throw new DAOException("Fail to Update No"+ k + " SQL");
//						}
//					}
//					
//					
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
	 * Customer의 Sales Rep 변경 정보를 저장합니다.<br>
	 * 
	 * @param List<SearchCustomerVO> insertVoList 
	 * @exception DAOException
	 */
	public void addSalesRepAdjustment(List<SearchCustomerVO> insertVoList) throws DAOException {

		
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new CustomerInfoManageDBDAOaddSalesRepAdjustmentUSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	 * Customer의 Primary Sales Rep을 확인 <br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO 
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet checkPrmrySalesRep(SearchCustomerVO searchCustomerVO) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		try{
			if(searchCustomerVO!= null){
				Map<String, String> mapVO = searchCustomerVO.getColumnValues();
				param.putAll(mapVO);
			}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerInfoManageDBDAOcheckPrmrySalesRepRSQL(), param, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
}