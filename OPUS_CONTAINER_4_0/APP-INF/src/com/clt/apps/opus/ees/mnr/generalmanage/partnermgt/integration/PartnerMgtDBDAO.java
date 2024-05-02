/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartnerMgtDBDAO.java
*@FileTitle : partnermgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.basic.GeneralCodeMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.CustomMnrPartnerVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.CustomMnrPrnrCntcPntVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.DisposalPartnerMgtINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.PartnerMgtINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyerPartVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalNVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
          
/**   
 * COM PartnerMgtDBDAO <br>
 * - COM-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author pms  
 * @see GeneralCodeMgtBCImpl 참조
 * @since J2EE 1.4 
 */
public class PartnerMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * [EES_MNR_0015]M&R Agreement의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrPartnerVO> customMnrPartnerVOS
	 * @exception DAOException
	 */
	public void removeAGMTPartnerData(List<CustomMnrPartnerVO> customMnrPartnerVOS) throws DAOException,Exception {
		try {		  	
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null; 
			if(customMnrPartnerVOS.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerMgtDBDAOremoveAGMTPartnerDataDSQL(), customMnrPartnerVOS,null);
				for(int i = 0; i < insCnt.length; i++){ 
					if(insCnt[i]== Statement.EXECUTE_FAILED) 
						throw new DAOException("Fail to removeAGMTPartnerData No"+ i + " SQL");
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
	 * [EES_MNR_0015]M&R Agreement의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrPartnerVO> customMnrPartnerVOS
	 * @exception DAOException
	 */
	public void addPartnerListData(List<CustomMnrPartnerVO> customMnrPartnerVOS) throws DAOException,Exception {
		try { 		  	
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null; 
			if(customMnrPartnerVOS.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerMgtDBDAOaddPartnerListDataCSQL(), customMnrPartnerVOS,null);
				for(int i = 0; i < insCnt.length; i++){ 
					if(insCnt[i]== Statement.EXECUTE_FAILED) 
						throw new DAOException("Fail to addPartnerListData No"+ i + " SQL");
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
	 * [EES_MNR_0218]Tariff Detail Information_Pop_Up의 정보를 조회 합니다. <br>
	 *
	 * @param PartnerMgtINVO partnerMgtINVO
	 * @return List<CustomMnrPartnerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	 public List<CustomMnrPartnerVO> searchRepairPartnerData(PartnerMgtINVO partnerMgtINVO) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CustomMnrPartnerVO> list = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			Map<String, String> mapVO = partnerMgtINVO.getColumnValues();
		        
			param.putAll(mapVO);                     
			velParam.putAll(mapVO);      
			                
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerMgtDBDAOsearchRepairPartnerDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrPartnerVO .class);
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
	 * [EES_MNR_0156]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalNVO disposalNVO
	 * @return List<CustomMnrDispBuyerPartVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDispBuyerPartVO> searchDSPPartnerData(DisposalNVO disposalNVO) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CustomMnrDispBuyerPartVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			Map<String, String> mapVO = disposalNVO.getColumnValues();
				
			param.putAll(mapVO);                   
			velParam.putAll(mapVO);    
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerMgtDBDAOsearchDSPPartnerDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispBuyerPartVO .class);
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
	 * [EES_MNR_0155]Disposal Partner의 Sequence Key정보를 조회 합니다. <br>
	 *
	 * @return List<CustomMnrDispBuyerPartVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DisposalPartnerMgtINVO>  searchDisposalPartnerData() throws DAOException {
		DBRowSet dbRowset = null;  
		 List<DisposalPartnerMgtINVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerMgtDBDAOsearchDisposalPartnerDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DisposalPartnerMgtINVO .class);
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
	  * [EES_MNR_0155]Disposal Buyer Management의 정보를 추가 합니다. <br>
	  *
	  * @param List<CustomMnrPrnrCntcPntVO> customMnrPrnrCntcPntVOs
	  * @exception DAOException
	  */
		public void addDisposalPartnerContactData(List<CustomMnrPrnrCntcPntVO> customMnrPrnrCntcPntVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if(customMnrPrnrCntcPntVOs.size() > 0){ 
					insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerMgtDBDAOaddDisposalPartnerContactDataCSQL(), customMnrPrnrCntcPntVOs,null);
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
		 * [EES_MNR_0155]Disposal Buyer Management의 정보를 삭제 합니다. <br>
		 *
		 * @param List<CustomMnrPrnrCntcPntVO> customMnrPrnrCntcPntVOs
		 * @exception DAOException
		 */
		public void removeDisposalPartnerContractData(List<CustomMnrPrnrCntcPntVO> customMnrPrnrCntcPntVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if(customMnrPrnrCntcPntVOs.size() > 0){ 
					insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerMgtDBDAOremoveDisposalPartnerContractDataDSQL(), customMnrPrnrCntcPntVOs,null);
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
		 * [EES_MNR_0155]Disposal Buyer Management의 정보를 삭제 합니다. <br>
		 *
		 * @param List<CustomMnrPartnerVO> customMnrPartnerVOs
		 * @exception DAOException
		 */
		public void removeDisposalPartnerInfoData(List<CustomMnrPartnerVO> customMnrPartnerVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if(customMnrPartnerVOs.size() > 0){ 
					insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerMgtDBDAOremoveDisposalPartnerInfoDataDSQL(), customMnrPartnerVOs,null);
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
		 * [EES_MNR_0155]Disposal Buyer Management의 정보를 조회 합니다. <br>
		 *
		 * @param DisposalPartnerMgtINVO disposalPartnerMgtINVO
		 * @param SignOnUserAccount account
		 * @return List<CustomMnrPartnerVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		 public List<CustomMnrPartnerVO> searchDisposalPartnerListData(DisposalPartnerMgtINVO disposalPartnerMgtINVO,SignOnUserAccount account) throws DAOException {
			DBRowSet dbRowset = null;  
			List<CustomMnrPartnerVO> list = null;
				
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			try{ 
				Map<String, String> mapVO = disposalPartnerMgtINVO.getColumnValues();
			        
				param.putAll(mapVO);                     
				velParam.putAll(mapVO);   
				param.put("user_ofc_cd", account.getOfc_cd());
				velParam.put("user_ofc_cd", account.getOfc_cd());
				                
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerMgtDBDAOsearchDisposalPartnerListDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrPartnerVO .class);
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
		 * [EES_MNR_0155]Disposal Buyer Management의 정보를 조회 합니다. <br>
		 *
		 * @param DisposalPartnerMgtINVO disposalPartnerMgtINVO
		 * @return List<CustomMnrPrnrCntcPntVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		 public List<CustomMnrPrnrCntcPntVO> searchDisposalPartnerContactData(DisposalPartnerMgtINVO disposalPartnerMgtINVO) throws DAOException {
			DBRowSet dbRowset = null;  
			List<CustomMnrPrnrCntcPntVO> list = null;
				
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			try{ 
				Map<String, String> mapVO = disposalPartnerMgtINVO.getColumnValues();
			        
				param.putAll(mapVO);                     
				velParam.putAll(mapVO);      
				                
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerMgtDBDAOsearchDisposalPartnerContactDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrPrnrCntcPntVO .class);
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
		 * [EES_MNR_0155]Disposal Buyer Management의 정보를 작업 합니다. <br>
		 *
		 * @param List<CustomMnrPartnerVO> customMnrPartnerVOs
		 * @exception DAOException
		 */
		public void mergeDisposalPartnerInfoData(List<CustomMnrPartnerVO> customMnrPartnerVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if(customMnrPartnerVOs.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerMgtDBDAOmergeDisposalPartnerInfoDataCSQL(), customMnrPartnerVOs,null);
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
		  * Find Duplicated Buyer<br>
		  * 
		  * @param CustomMnrPartnerVO customMnrPartnerVO
		  * @return String
		  * @exception DAOException
		  */
		public String searchDupDSPBuyerData(CustomMnrPartnerVO customMnrPartnerVO) throws DAOException {
			DBRowSet dbRowset = null;
			String returnVal = "";

			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {

				Map<String, String> mapVO = customMnrPartnerVO.getColumnValues();
		        
				param.putAll(mapVO);                     
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PartnerMgtDBDAOsearchDSPBuyerDupDataRSQL(), param, velParam);
				if (dbRowset.next()) {
					returnVal = dbRowset.getString("MNR_CD_DP_DESC");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return returnVal;
		}
}
