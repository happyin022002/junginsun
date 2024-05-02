/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageDBDAO.java
*@FileTitle : InvoiceManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.tpb.common.combo.vo.TpbComboVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.basic.InvoiceManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.GetIndiaTaxInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceDetailListForRevisionVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchErpInterfaceCheckDataVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchIndiaTaxInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceStatusVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchOtsGrpInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchTPBHandlingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchThirdPartyInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SendInvoiceEdiItemVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SendInvoiceEdiVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.TPBEdiSndLogDtlVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.TpbInvIfDtlVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.TpbInvIfSmryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.management.alps.file.integration.FileManagementDBDAOComUpldFileVOCSQL;
import com.hanjin.syscommon.management.alps.jobcodemanagement.integration.JobCodeManagementDBDAOModifyApprovalHdrUSQL;


/**
 * ALPS InvoiceManageDBDAO <br>
 * - ALPS-InvoiceManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sun, CHOI
 * @see InvoiceManageBCImpl 참조
 * @since J2EE 1.6
 */
public class InvoiceManageDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBHandlingVO searchTPBHandlingVO
	 * @return List<SearchInvoiceManageListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchTPBHandlingVO> searchTPBHandling(SearchTPBHandlingVO searchTPBHandlingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTPBHandlingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		ArrayList tempArrL = new ArrayList();
		StringTokenizer strSearch = null;
		String tempSN3ptyInvNoSearch = ""; 
		
		try{
			if(searchTPBHandlingVO != null){
				Map<String, String> mapVO = searchTPBHandlingVO .getColumnValues();

				param.putAll(mapVO);
				mapVO.remove("s_n3pty_no_strs_link"); // s_n3pty_no_strs_link 처리를 위해 추가
				velParam.putAll(mapVO);
			}
			
			SearchTPBHandlingVO sThVO = searchTPBHandlingVO;

			String s_n3pty_no_strs_link = sThVO.getSN3ptyNoStrsLink();
			int len_s_n3pty_no_strs_link = s_n3pty_no_strs_link.length();
			
//			String s_vndr_cust_div_cd = sThVO.getSVndrCustDivCd();
//			String s_trd_party_val = sThVO.getSTrdPartyVal();
//			
//			log.debug("s_n3pty_no_strs_link =============>["+s_n3pty_no_strs_link+"]");
//			log.debug("s_vndr_cust_div_cd ===============>["+s_vndr_cust_div_cd+"]");
//			log.debug("s_trd_party_val ==================>["+s_trd_party_val+"]");	
			
			//s_n3pty_no_strs_link 넣는 부분
			if(!s_n3pty_no_strs_link.equals("")){
				s_n3pty_no_strs_link = s_n3pty_no_strs_link.substring(0,len_s_n3pty_no_strs_link - 1);
				strSearch = new StringTokenizer(s_n3pty_no_strs_link, "|");
				tempSN3ptyInvNoSearch = strSearch.nextToken();
//				log.debug("tempSN3ptyInvNoSearch ============>["+tempSN3ptyInvNoSearch+"]");
				tempArrL.add(tempSN3ptyInvNoSearch);

				while(strSearch.hasMoreTokens()){
					tempSN3ptyInvNoSearch = strSearch.nextToken();
					tempArrL.add(tempSN3ptyInvNoSearch);
				}
			}
			if(tempArrL.size()>0){
				velParam.put("s_n3pty_no_strs_link", tempArrL);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchTPBHandlingRSQL(), param, velParam);
			
//			String[] rtnVal = {"","",""};
//			
//			if (dbRowset.next()) {
//				rtnVal[0] = dbRowset.getString(1);
//				rtnVal[1] = dbRowset.getString(2);
//				rtnVal[2] = dbRowset.getString(3);
//			
//				log.debug("rtnVal[0]======>"+rtnVal[0]);
//				log.debug("rtnVal[1]======>"+rtnVal[1]);
//				log.debug("rtnVal[2]======>"+rtnVal[2]);
//			} else {
//				//rtnValue = "";
//			}
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTPBHandlingVO .class);
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
	 * @param SearchIndiaTaxInfoVO searchIndiaTaxInfoVO
	 * @return List<SearchIndiaTaxInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchIndiaTaxInfoVO> searchIndiaTaxInfo(SearchIndiaTaxInfoVO searchIndiaTaxInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchIndiaTaxInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchIndiaTaxInfoVO != null){
				Map<String, String> mapVO = searchIndiaTaxInfoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchIndiaTaxInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIndiaTaxInfoVO .class);
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
	 * @param SearchIndiaTaxInfoVO searchIndiaTaxInfoVO
	 * @return List<SearchIndiaTaxInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchIndiaTaxInfoVO> searchIndiaTaxInfoByEffDate(SearchIndiaTaxInfoVO searchIndiaTaxInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchIndiaTaxInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchIndiaTaxInfoVO != null){
				Map<String, String> mapVO = searchIndiaTaxInfoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchIndiaTaxInfoByEffDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIndiaTaxInfoVO .class);
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
	 * @param SearchInvoiceSettingVO searchInvoiceSettingVO
	 * @return List<SearchInvoiceSettingVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchInvoiceSettingVO> searchInvoiceSheetSet(SearchInvoiceSettingVO searchInvoiceSettingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInvoiceSettingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchInvoiceSettingVO != null){
				Map<String, String> mapVO = searchInvoiceSettingVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchInvoiceSheetSetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceSettingVO .class);
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
	 * @param List<SearchInvoiceSettingVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addInvoiceSheetSet(List<SearchInvoiceSettingVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceManageDBDAOCreateInvoiceSettingCSQL(), insModels,null);
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
		return insCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchInvoiceSettingVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyInvoiceSheetSet(List<SearchInvoiceSettingVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceManageDBDAOModifyInvoiceSettingUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return List<InvoiceCreationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchOutstandingDetailListForInvoiceCreationVO> searchOutstandingDetailListForInvoiceCreation(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOutstandingDetailListForInvoiceCreationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invoiceCreationVO != null){
				Map<String, String> mapVO = invoiceCreationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchOutstandingDetailListForInvoiceCreationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOutstandingDetailListForInvoiceCreationVO .class);
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
		 * @param InvoiceCreationVO invoiceCreationVO
		 * @return List<InvoiceCreationVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchThirdPartyInfoVO> searchThirdPartyInfo(InvoiceCreationVO invoiceCreationVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchThirdPartyInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(invoiceCreationVO != null){
					Map<String, String> mapVO = invoiceCreationVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchThirdPartyInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchThirdPartyInfoVO .class);
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
		 * @param InvoiceCreationVO invoiceCreationVO
		 * @return List<InvoiceCreationVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchOtsGrpInfoVO> searchOtsGrpInfo(InvoiceCreationVO invoiceCreationVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchOtsGrpInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(invoiceCreationVO != null){
					Map<String, String> mapVO = invoiceCreationVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchOtsGrpInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOtsGrpInfoVO .class);
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
		 * @param InvoiceCreationVO invoiceCreationVO
		 * @return List<InvoiceCreationVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<GetIndiaTaxInfoVO> getIndiaTaxInfo(String ofc_cd) throws DAOException {
			DBRowSet dbRowset = null;
			List<GetIndiaTaxInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			param.put("ofc_cd", ofc_cd);

			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOGetIndiaTaxInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, GetIndiaTaxInfoVO .class);
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
	 * @param SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO
	 * @return List<SearchInvoiceDefaultDataVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchInvoiceDefaultDataVO> searchInvoiceDefaultData(SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInvoiceDefaultDataVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchInvoiceDefaultDataVO != null){
				Map<String, String> mapVO = searchInvoiceDefaultDataVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchInvoiceDefaultDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceDefaultDataVO .class);
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
	 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
	 * @return List<SearchInvoiceStatusVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchInvoiceStatusVO> searchIssueInfo(SearchInvoiceStatusVO searchInvoiceStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInvoiceStatusVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchInvoiceStatusVO != null){
				Map<String, String> mapVO = searchInvoiceStatusVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchIssueInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceStatusVO .class);
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
		 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
		 * @return List<SearchInvoiceStatusVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public SendInvoiceEdiVO searchIssueEdiInfo(SearchInvoiceStatusVO searchInvoiceStatusVO) throws DAOException {
			DBRowSet dbRowset = null;
			SendInvoiceEdiVO sendInvoiceEdiVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchInvoiceStatusVO != null){
					Map<String, String> mapVO = searchInvoiceStatusVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchIssueEdiRSQL(), param, velParam);
				List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, SendInvoiceEdiVO.class);
				
				if (list != null && list.size() > 0){
					sendInvoiceEdiVO = (SendInvoiceEdiVO) list.get(0);
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return sendInvoiceEdiVO;
		}	 
		 
		 
			/**
			 * [처리대상] 정보를 [행위] 합니다.<br>
			 * 
			 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
			 * @return List<SearchInvoiceStatusVO>
			 * @throws DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<SendInvoiceEdiItemVO> searchIssueEdiItemInfo(SearchInvoiceStatusVO searchInvoiceStatusVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<SendInvoiceEdiItemVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(searchInvoiceStatusVO != null){
						Map<String, String> mapVO = searchInvoiceStatusVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchIssueEdiItemRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendInvoiceEdiItemVO .class);
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
		 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
		 * @return List<SearchInvoiceStatusVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchInvoiceStatusVO> searchContactInfo(SearchInvoiceStatusVO searchInvoiceStatusVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchInvoiceStatusVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchInvoiceStatusVO != null){
					Map<String, String> mapVO = searchInvoiceStatusVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchContactInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceStatusVO .class);
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
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return List<InvoiceCreationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvoiceCreationVO> searchInvoiceInfo(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceCreationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invoiceCreationVO != null){
				Map<String, String> mapVO = invoiceCreationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOGetIndiaTaxInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceCreationVO .class);
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
	 * @param SearchInvoiceStatusVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateInvoiceIssue(SearchInvoiceStatusVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceManageDBDAOUpdateInvoiceRevisionIssueCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
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
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return List<InvoiceCreationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchInvoiceStatusVO getSendTargetInfo(SearchInvoiceStatusVO searchInvoiceStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInvoiceStatusVO> list = null;
		SearchInvoiceStatusVO vo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchInvoiceStatusVO != null){
				Map<String, String> mapVO = searchInvoiceStatusVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchSendTargetInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceStatusVO .class);
			vo = list.get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vo;
	}
	
	 /**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<InvoiceCreationVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyCreateInvoiceRvisDtl(List<InvoiceCreationVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceManageDBDAOCreateInvoiceRvisDtlCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchOutstandingDetailCheckForInvoiceCreation(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtnValue = "";
		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchOutstandingDetailCheckForInvoiceCreationRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("validYn");
			} else {
				rtnValue = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return String[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String[] createInvoiceRvis(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//Map<String, Object> resultMap = new HashMap<String, Object>();
		Map resultMap = null;
		
		String[] rtnValue = {"",""};
		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new InvoiceManageDBDAOCreateInvoiceRvisCSQL(), param, velParam);
			
			rtnValue[0] = (String)resultMap.get("n3pty_inv_no");
			rtnValue[1] = (String)resultMap.get("n3pty_inv_rvis_seq");
			
			 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchIndiaTaxInfoVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiIndiaTaxInfo(List<SearchIndiaTaxInfoVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceManageDBDAOMultiIndiaTaxInfoUSQL(), insModels,null);
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
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchIndiaTaxInfoVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMmultiIndiaTaxInfo(List<SearchIndiaTaxInfoVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceManageDBDAOMultiIndiaTaxInfoDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
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
		return delCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchInvoiceStatus(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
//			log.debug("searchInvoiceStatus_DAO");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchInvoiceStatusRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("n3pty_inv_sts_cd");
			} else {
				rtnValue = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return String[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String[] updateInvoiceRevisionErpInterface(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//Map<String, String> resultMap = new HashMap<String, String>();
		Map resultMap = null;
		
		String[] rtnValue = {"","","",""};

		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new InvoiceManageDBDAOUpdateInvoiceRevisionErpInterfaceUSQL(), param, velParam);
			
			rtnValue[0] = (String)resultMap.get("out_erpif_rvis_seq");
			rtnValue[1] = (String)resultMap.get("out_erpif_rvis_cd");
			rtnValue[2] = (String)resultMap.get("out_erpif_creditnote_seq");
			rtnValue[3] = (String)resultMap.get("out_erpif_creditnote_cd");
			 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return List<InvoiceCreationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchErpInterfaceCheckDataVO searchErpInterfaceCheckData(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchErpInterfaceCheckDataVO> list = null;
		SearchErpInterfaceCheckDataVO vo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invoiceCreationVO != null){
				Map<String, String> mapVO = invoiceCreationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchErpInterfaceCheckDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchErpInterfaceCheckDataVO .class);
			vo = list.get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vo;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkCustomerInfo(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnValue = 0;
		boolean okFlag = false; 
		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOCheckCustomerInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getInt("cnt");
				if(rtnValue == 1){
					okFlag = true;
				}
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return okFlag;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] checkArOfficeCode(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String[] rtnValue = {"",""};

		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOCheckArOfficeCodeRSQL(), param, velParam);
			
			if(dbRowset.next()){
				rtnValue[0] = dbRowset.getString(1);
				rtnValue[1] = dbRowset.getString(2);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return List<TpbInvIfSmryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TpbInvIfSmryVO> searchErpInterfaceDataForCreditNote(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TpbInvIfSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invoiceCreationVO != null){
				Map<String, String> mapVO = invoiceCreationVO .getColumnValues();
//				log.debug("mapVO========================>"+mapVO);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TpbInvIfSmryVO .class);
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
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return List<TpbInvIfDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TpbInvIfDtlVO> searchErpInterfaceDataForCreditNoteDtl(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TpbInvIfDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invoiceCreationVO != null){
				Map<String, String> mapVO = invoiceCreationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TpbInvIfDtlVO .class);
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
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return List<TpbInvIfSmryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TpbInvIfSmryVO> searchErpInterfaceData(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TpbInvIfSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invoiceCreationVO != null){
				Map<String, String> mapVO = invoiceCreationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchErpInterfaceDataStr1RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TpbInvIfSmryVO .class);
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
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return List<TpbInvIfDtlVO>
	 * @throws DAOException 
	 */
	 @SuppressWarnings("unchecked")
	public List<TpbInvIfDtlVO> searchErpInterfaceDataDtl(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TpbInvIfDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invoiceCreationVO != null){
				Map<String, String> mapVO = invoiceCreationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchErpInterfaceDataStr2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TpbInvIfDtlVO .class);
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
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return String
	 * @throws DAOException
	 */
	 public String searchErpInterfaceDataAddDdt(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtnValue = "";
		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchErpInterfaceDataStr3RSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("ADDAMT");
			} else {
				rtnValue = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<TpbInvIfSmryVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] createErpDataToTPBSmry(List<TpbInvIfSmryVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceManageDBDAOCreateErpDataToTPBSmryCSQL(), insModels,null);
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
		return insCnt;
	}
	/** 
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<TpbInvIfDtlVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] createErpDataToTPBDtl(List<TpbInvIfDtlVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceManageDBDAOCreateErpDataToTPBDtlCSQL(), insModels,null);
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
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO
	 * @return List<InvoiceDetailListForRevisionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvoiceDetailListForRevisionVO> searchInvoiceRevisionInfo(InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceDetailListForRevisionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invoiceDetailListForRevisionVO != null){
				Map<String, String> mapVO = invoiceDetailListForRevisionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchInvoiceRevisionInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceDetailListForRevisionVO .class);
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
	 * @param InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO
	 * @return List<InvoiceDetailListForRevisionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvoiceDetailListForRevisionVO> searchTrdPartyDataForCorrectionInvOts(InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceDetailListForRevisionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invoiceDetailListForRevisionVO != null){
				Map<String, String> mapVO = invoiceDetailListForRevisionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOtsRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceDetailListForRevisionVO .class);
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
	 * @param InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO
	 * @return List<InvoiceDetailListForRevisionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvoiceDetailListForRevisionVO> searchTrdPartyDataForCorrectionInvOrg(InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceDetailListForRevisionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invoiceDetailListForRevisionVO != null){
				Map<String, String> mapVO = invoiceDetailListForRevisionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOrgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceDetailListForRevisionVO .class);
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
	 * @param InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO
	 * @return List<InvoiceDetailListForRevisionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvoiceDetailListForRevisionVO> searchInvoiceRevisionDetailList(InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceDetailListForRevisionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invoiceDetailListForRevisionVO != null){
				Map<String, String> mapVO = invoiceDetailListForRevisionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchInvoiceRevisionDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceDetailListForRevisionVO .class);
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
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchInvoiceStatusCheckForRevision(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtnValue = "";
		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchInvoiceStatusCheckForRevisionRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("validyn");
			} else {
				rtnValue = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchInvoiceStatusCheckForCorrection(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtnValue = "";
		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchInvoiceStatusCheckForCorrectionRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("validyn");
			} else {
				rtnValue = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return String[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String[] modifyInvoiceRvis(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//Map<String, Object> resultMap = new HashMap<String, Object>();
		Map resultMap = null;
		
		String[] rtnValue = {"","","","","",""};
		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();
//			log.debug("modifyInvoiceRvismapVO=============>"+mapVO);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
//			log.debug("modifyInvoiceRvis======================>");
			
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new InvoiceManageDBDAOModifyInvoiceRvisCSQL(), param, velParam);
			
			rtnValue[0] = (String)resultMap.get("n3pty_inv_no_tmp");
			rtnValue[1] = (String)resultMap.get("new_rvis_seq");
			rtnValue[2] = (String)resultMap.get("new_rvis_cd");
			rtnValue[3] = (String)resultMap.get("new_creditnote_seq");
			rtnValue[4] = (String)resultMap.get("new_creditnote_cd");
//			log.debug("rtnValue[0]======================>"+rtnValue[0]);
//			log.debug("rtnValue[1]======================>"+rtnValue[1]);
//			log.debug("rtnValue[2]======================>"+rtnValue[2]);
//			log.debug("rtnValue[3]======================>"+rtnValue[3]);
//			log.debug("rtnValue[4]======================>"+rtnValue[4]);
			
			 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return String[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String[] removeInvoice(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//Map<String, Object> resultMap = new HashMap<String, Object>();
		Map resultMap = null;
		
		String[] rtnValue = {"","","","",""};
		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
//			log.debug("removeInvoiceRvis======================>");
			
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new InvoiceManageDBDAORemoveInvoiceRvisUSQL(), param, velParam);
			
			rtnValue[0] = "Y";
			rtnValue[2] = (String)resultMap.get("new_creditnote_seq");
			rtnValue[3] = (String)resultMap.get("new_creditnote_cd");
			
			 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<InvoiceCreationVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyInvoiceDtl(List<InvoiceCreationVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceManageDBDAOModifyInvoiceDtlCSQL(), insModels,null);
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
		return insCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<InvoiceCreationVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyInvoiceOtsDtlInfo(List<InvoiceCreationVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceManageDBDAOModifyInvoiceOtsDtlInfoUSQL(), insModels,null);
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
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param List<CreateTPBCandidateVO> insModels
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public String getRate(TpbInvIfDtlVO tpbInvIfDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtnValue = "";
		try{
			Map<String, String> mapVO = tpbInvIfDtlVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOGetRateRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("RATE");
			} else {
				rtnValue = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchInvoiceRvisSeq(InvoiceCreationVO invoiceCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtnValue = "";
		try{
			Map<String, String> mapVO = invoiceCreationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOCheckInvoiceRvisSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("validyn");
			} else {
				rtnValue = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}
	
	/**
	 * Account Code, Name<br>
	 * 
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TpbComboVO> searchAcctCd() throws DAOException {
		DBRowSet dbRowset = null;
		List<TpbComboVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchAcctCdRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TpbComboVO .class);
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
	 * Terminal Name, ATD 조회<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchOutstandingDetailListForInvoiceCreationVO> searchYdNmAtd(InvoiceCreationVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOutstandingDetailListForInvoiceCreationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = inputVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceManageDBDAOSearchYdNmAtdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOutstandingDetailListForInvoiceCreationVO .class);
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
	 * TPB EDI 송신 log 저장 (송신 Detail)<Br>
	 * @param TPBEdiSndLogDtlVO inputVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addTPBEdiSndLogDtl(TPBEdiSndLogDtlVO inputVO) throws DAOException,Exception {

		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        
        try {
        	if(inputVO != null) {        		
	            Map<String, String> mapVO = inputVO.getColumnValues();    
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new InvoiceManageDBDAOAddTPBEdiSndLogDtlCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
           		throw new DAOException(new ErrorHandler("TPB EDI",new String[]{}).getMessage());
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * ROC Rollback <br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @param String n3ptyNo
	 * @return String
	 * @exception DAOException
	 */	

	public String checkRocRollback(String ofcCd, String userId, String n3ptyNo) throws DAOException {
		
//		int insCnt[] = null;
		String strReturn = "SUCCESS";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> resultMap  = new HashMap<String, Object>();
		
		try{
			
			param.put("in_usr_ofc_cd",ofcCd);
			param.put("in_usr_id",userId);
			param.put("in_n3pty_no",n3ptyNo);

//			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new InvoiceManageDBDAOCheckRocRollbackRSQL(), param, null);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new InvoiceManageDBDAOCheckRocRollbackRSQL(), param, null);
			if (updCnt == Statement.EXECUTE_FAILED)
				strReturn = "FAIL";
			
		}catch(SQLException se){
			strReturn = "FAIL";
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			strReturn = "FAIL";
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn; 
	}
	
	 /**
	 * Email Fax 전송이력을 저장합니다.<br>
	 * 
	 * @param SearchInvoiceStatusVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addInvoiceSendHistory(SearchInvoiceStatusVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceManageDBDAOAddInvoiceFaxEmailSentHistoryCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}