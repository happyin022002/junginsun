/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOInvoiceManageDBDAO.java
*@FileTitle : JOInvoiceManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.basic.JOInvoiceManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.GetIndiaTaxInfoVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.InvoiceDetailListForRevisionVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchErpInterfaceCheckDataVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchOtsGrpInfoVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchTPBHandlingListVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchThirdPartyInfoVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.TpbInvIfDtlVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.TpbInvIfSmryVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS JOInvoiceManageDBDAO <br>
 * - ALPS-JOInvoiceManageManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author GUN-HA HWANG
 * @see JOInvoiceManageBCImpl 참조
 * @since J2EE 1.6
 */
public class JOInvoiceManageDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBHandlingListVO searchTPBHandlingListVO
	 * @return List<SearchTPBHandlingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTPBHandlingListVO> searchTPBHandlingList(SearchTPBHandlingListVO searchTPBHandlingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTPBHandlingListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList tempArrL = new ArrayList();
		StringTokenizer strSearch = null;
		String tempSN3ptyInvNoSearch = ""; 
		
		try{
			if(searchTPBHandlingListVO != null){
				Map<String, String> mapVO = searchTPBHandlingListVO .getColumnValues();
				
				param.putAll(mapVO);
				mapVO.remove("s_n3pty_no_strs_link"); // s_n3pty_inv_no_search 처리를 위해 추가
				velParam.putAll(mapVO);
			}
			SearchTPBHandlingListVO sThVO = searchTPBHandlingListVO;

			String s_n3pty_no_strs_link = sThVO.getSN3ptyNoStrsLink();
			int len_s_n3pty_no_strs_link = s_n3pty_no_strs_link.length();
			
			if(!s_n3pty_no_strs_link.equals("")){
				s_n3pty_no_strs_link = s_n3pty_no_strs_link.substring(0,len_s_n3pty_no_strs_link - 1);
				strSearch = new StringTokenizer(s_n3pty_no_strs_link, "|");
				tempSN3ptyInvNoSearch = strSearch.nextToken();
				tempArrL.add(tempSN3ptyInvNoSearch);

				while(strSearch.hasMoreTokens()){
					tempSN3ptyInvNoSearch = strSearch.nextToken();
					tempArrL.add(tempSN3ptyInvNoSearch);
				}
			}
			if(tempArrL.size()>0){
				velParam.put("s_n3pty_no_strs_link", tempArrL);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchTPBHandlingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTPBHandlingListVO .class);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchOutstandingDetailListForInvoiceCreationRSQL(), param, velParam);
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
		 * @param SearchInvoiceSheetSetVO searchInvoiceSheetSetVO
		 * @return List<SearchInvoiceSheetSetVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchInvoiceSheetSetVO> searchInvoiceSheetSet(SearchInvoiceSheetSetVO searchInvoiceSheetSetVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchInvoiceSheetSetVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchInvoiceSheetSetVO != null){
					Map<String, String> mapVO = searchInvoiceSheetSetVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchInvoiceSheetSetRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceSheetSetVO .class);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchThirdPartyInfoRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchOtsGrpInfoRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOGetIndiaTaxInfoRSQL(), param, velParam);
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
	 * @param List<SearchInvoiceSheetSetVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addInvoiceSheetSet(List<SearchInvoiceSheetSetVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JOInvoiceManageDBDAOCreateInvoiceSheetSetCSQL(), insModels,null);
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
	 * @param List<SearchInvoiceSheetSetVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyInvoiceSheetSet(List<SearchInvoiceSheetSetVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
//				log.debug("abc:DBDAO");
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JOInvoiceManageDBDAOModifyInvoiceSheetSetUSQL(), updModels,null);
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
			
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new JOInvoiceManageDBDAORemoveInvoiceRvisUSQL(), param, velParam);
			
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOGetIndiaTaxInfoRSQL(), param, velParam);
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
			
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new JOInvoiceManageDBDAOCreateInvoiceRvisCSQL(), param, velParam);
			
			rtnValue[0] = (String)resultMap.get("n3pty_inv_no");
			rtnValue[1] = (String)resultMap.get("n3pty_inv_rvis_seq");
			
			 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
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
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JOInvoiceManageDBDAOCreateInvoiceRvisDtlCSQL(), updModels,null);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchOutstandingDetailCheckForInvoiceCreationRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOGetRateRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("rate");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOCheckCustomerInfoRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOCheckArOfficeCodeRSQL(), param, velParam);
			
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchInvoiceStatusRSQL(), param, velParam);
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
			
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new JOInvoiceManageDBDAOUpdateInvoiceRevisionErpInterfaceUSQL(), param, velParam);
			
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchErpInterfaceCheckDataRSQL(), param, velParam);
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
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteDetailRSQL(), param, velParam);
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
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JOInvoiceManageDBDAOCreateErpDataToTPBSmryCSQL(), insModels,null);
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
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JOInvoiceManageDBDAOCreateErpDataToTPBDtlCSQL(), insModels,null);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchErpInterfaceDataStr1RSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchErpInterfaceDataStr2RSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchErpInterfaceDataStr3RSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOtsRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchTrdPartyDataForCorrectionInvOrgRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchInvoiceRevisionInfoRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchInvoiceRevisionDetailListRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchInvoiceDefaultDataRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchInvoiceStatusCheckForRevisionRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOSearchInvoiceStatusCheckForCorrectionRSQL(), param, velParam);
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
//			log.debug("JOmapVO======================>"+mapVO);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
//			log.debug("JOmodifyInvoiceRvis======================>");
			
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new JOInvoiceManageDBDAOModifyInvoiceRvisCSQL(), param, velParam);

			rtnValue[0] = (String)resultMap.get("n3pty_inv_no_tmp");
			rtnValue[1] = (String)resultMap.get("new_rvis_seq");
			rtnValue[2] = (String)resultMap.get("new_rvis_cd");
			rtnValue[3] = (String)resultMap.get("new_creditnote_seq");
			rtnValue[4] = (String)resultMap.get("new_creditnote_cd");
			log.debug("rtnValue[0]======================>"+rtnValue[0]);
			log.debug("rtnValue[1]======================>"+rtnValue[1]);
			log.debug("rtnValue[2]======================>"+rtnValue[2]);
			log.debug("rtnValue[3]======================>"+rtnValue[3]);
			log.debug("rtnValue[4]======================>"+rtnValue[4]);
			 
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
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JOInvoiceManageDBDAOModifyInvoiceDtlCSQL(), insModels,null);
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
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JOInvoiceManageDBDAOModifyInvoiceOtsDtlInfoUSQL(), insModels,null);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOInvoiceManageDBDAOCheckInvoiceRvisSeqRSQL(), param, velParam);
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
}