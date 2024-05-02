/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EQFlagMgtDBDAO.java
 *@FileTitle : Damage Flagging/Unflagging Pop Up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 박명신
 *@LastVersion : 1.0
 * 2009.05.19 박명신
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.CustomWarrantyAlertListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqRngStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.DisposalCandidateFlagGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.DisposalCandidateFlagINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * COM EQFlagMgtDBDAO <br>
 * - COM-OperationManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author park myoung sin
 * @see EQFlagMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class EQFlagMgtDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * [EES_MNR_0156] MNR_EQ_STS 의 mkr_nm,mdl_nm 추가/수정 합니다. <br>
	 *
	 * @param CustomMnrDispDtlVO customMnrDispDtlVO
	 * @return int  
	 * @exception DAOException 
	 */  
	public int modifyEqStsMkrNmMdlNmData(CustomMnrDispDtlVO customMnrDispDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 

		try { 
			Map<String, String> mapVO = customMnrDispDtlVO.getColumnValues();
			param.putAll(mapVO);      
			velParam.putAll(mapVO);      
			 
			SQLExecuter sqlExe = new SQLExecuter("");   
				 
			result = sqlExe.executeUpdate((ISQLTemplate)new EQFlagMgtDBDAOmodifyEqStsMkrNmMdlNmDataUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyEqStsMkrNmMdlNmData"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * [EES_MNR_0122]Hanger Bar Attatch/Detach Qty by CNTR의 정보를 조회 합니다. <br>
	 *
	 * @param EQFlagListINVO eQFlagListINVO
	 * @return List<CustomMnrEqStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrEqStsVO> searchEQFlagStatusListData(EQFlagListINVO eQFlagListINVO) throws DAOException {
		int currentPage = eQFlagListINVO.getIPage();
		int pageRow	  = Integer.parseInt(eQFlagListINVO.getPagerows());
   	  	int startNo = pageRow * (currentPage -1) +1;
   	  	int endNo   = pageRow *  currentPage;
		
		DBRowSet dbRowset = null;   
		List<CustomMnrEqStsVO> list = null;  
		//query parameter       
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter     
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{ 
			
			Map<String, String> mapVO = eQFlagListINVO.getColumnValues();

			param.putAll(mapVO);             
			velParam.putAll(mapVO); 
			
			param.put("startno", startNo);
			param.put("endno", endNo);
	        velParam.put("startno", startNo);
	        velParam.put("endno", endNo);

			//멀티 콤보로 넘어온 값 tpsz
			List<String> tpszCds = new ArrayList<String>();   
			String[] arrYdCd =  eQFlagListINVO.getEqTpszCd().split(",");
			for(int i = 0; i < arrYdCd.length; i ++){      
				tpszCds.add(arrYdCd[i]);     
			}     
			velParam.put("tpszCds", tpszCds);	            

			//rep_Multiful_inquiry eq_no	
			List<String> eqNos = new ArrayList<String>(); 	
					
			String[] arrEqNo =  eQFlagListINVO.getEqList().split(",");
			for(int i = 0; i < arrEqNo.length; i ++){   
				eqNos.add(arrEqNo[i]);		           
			}     
			velParam.put("eqNos", eqNos);      	

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOsearchEQFlagStatusListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqStsVO .class);                  
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
	 * [EES_MNR_0122]W/O Creation의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrFlgHisVO> customMnrFlgHisVOS
	 * @param String 				  curOfcCd
	 * @exception DAOException
	 */
	public void addEQFlagHistoryListData(List<CustomMnrFlgHisVO> customMnrFlgHisVOS,String curOfcCd) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 

		try {  
			for(int i=0;i<customMnrFlgHisVOS.size();i++)
			{
				Map<String, String> mapVO=customMnrFlgHisVOS.get(i).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
					
				param.put("cur_ofc_cd", curOfcCd);
				velParam.put("cur_ofc_cd", curOfcCd);
						
				SQLExecuter sqlExe = new SQLExecuter("");  
	
				result = sqlExe.executeUpdate((ISQLTemplate)new EQFlagMgtDBDAOaddEQFlagHistoryListDataCSQL(), param, velParam);
	
				if(result == Statement.EXECUTE_FAILED)     
					throw new DAOException("Fail to Insert addEQFlagHistoryListData"); 
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
	 * [EES_MNR_0125]Hanger Bar CNTR History의 정보를 조회 합니다. <br>
	 *	
	 * @param EQFlagListINVO eQFlagListINVO
	 * @param String curOfcCd
	 * @return List<CustomMnrFlgHisVO>
	 * @exception DAOException
	 */ 
	@SuppressWarnings("unchecked")
	public List<CustomMnrFlgHisVO> searchEQFlagHistoryListData(EQFlagListINVO eQFlagListINVO,String curOfcCd) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrFlgHisVO> list = null;    
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter       
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{              
			Map<String, String> mapVO = eQFlagListINVO.getColumnValues();

			param.putAll(mapVO);               
			velParam.putAll(mapVO);  
			
			param.put("cur_ofc_cd", curOfcCd);
			velParam.put("cur_ofc_cd", curOfcCd);
			
			//2014-03-27 Jonghee HAN Multi combo value handling logic added 
			//멀티 콤보로 넘어온 값 tpsz
			List<String> tpszCds = new ArrayList<String>();
			String[] arrTpszCd =  eQFlagListINVO.getEqTpszCd().split(",");
			for(int i = 0; i < arrTpszCd.length; i ++){
				tpszCds.add(arrTpszCd[i]);
			}
			velParam.put("tpszCds", tpszCds);

			//rep_Multiful_inquiry eq_no
			List<String> eqNos = new ArrayList<String>();
			String[] arrEqNo =  eQFlagListINVO.getEqList().split(",");
			for(int i = 0; i < arrEqNo.length; i ++){
				eqNos.add(arrEqNo[i]);
			}
			velParam.put("eqNos", eqNos);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOsearchEQFlagHistoryListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrFlgHisVO .class);                  
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
	 * [EES_MNR_0122]Hanger Bar Attatch/Detach Qty by CNTR의 정보를 조회 합니다. <br>
	 *
	 * @param EQFlagListINVO eQFlagListINVO
	 * @return List<CustomMnrEqStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrEqStsVO> searchHangerFlagStatusListData(EQFlagListINVO eQFlagListINVO) throws DAOException {
		int currentPage = eQFlagListINVO.getIPage();
		int pageRow	  = Integer.parseInt(eQFlagListINVO.getPagerows());
   	  	int startNo = pageRow * (currentPage -1) +1;
   	  	int endNo   = pageRow *  currentPage;
		
		DBRowSet dbRowset = null;
		List<CustomMnrEqStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrLabelValueList = null;

		try{
			if(eQFlagListINVO != null){
				Map<String, String> mapVO = eQFlagListINVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("startno", startNo);
				param.put("endno", endNo);
		        velParam.put("startno", startNo);
		        velParam.put("endno", endNo);
			
				if (eQFlagListINVO.getEqList() != null && eQFlagListINVO.getEqList().trim().length() > 0) {
					 List<String> eqNos = new ArrayList<String>(); 
					 String[] arrayEqNo =  eQFlagListINVO.getEqList().split(",");
					 for(int i = 0; i < arrayEqNo.length; i ++){      
						 eqNos.add(arrayEqNo[i]);	      
					 } 			
					 		  
					 param.put("eqNos",eqNos);  	  	                    
					 velParam.put("eqNos",eqNos); 
				}
				
				if (eQFlagListINVO.getEqTpszCd() != null && eQFlagListINVO.getEqTpszCd().trim().length() > 0) {
					List<String> tpszNos = new ArrayList<String>(); 
					String[] arrayTpszNo =  eQFlagListINVO.getEqTpszCd().split(",");
					for(int i = 0; i < arrayTpszNo.length; i ++){      
						tpszNos.add(arrayTpszNo[i]);			      
					} 			
					
					param.put("tpszNos",tpszNos);	 		  	                    
					velParam.put("tpszNos",tpszNos); 	
				}
				
				if ( !JSPUtil.getNull(eQFlagListINVO.getRstrUsgLbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(eQFlagListINVO.getRstrUsgLbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOsearchHangerFlagStatusListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqStsVO .class);

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
	 * [EES_MNR_0158]Disposal Candidate Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalCandidateFlagINVO disposalCandidateFlagINVO
	 * @return List<CustomMnrEqStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrEqStsVO> searchDisposalCandidatePopupListData(DisposalCandidateFlagINVO disposalCandidateFlagINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrEqStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		  
		try{ 
			if(disposalCandidateFlagINVO != null){
				Map<String, String> mapVO = disposalCandidateFlagINVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//멀티 콤보로 넘어온 값 tpsz
				List<String> tpszCds = new ArrayList<String>();   
				String[] arrYdCd =  disposalCandidateFlagINVO.getEqTpszCd().split(",");
				for(int i = 0; i < arrYdCd.length; i ++){      
					tpszCds.add(arrYdCd[i]);     
				}     
				velParam.put("tpszCds", tpszCds);	      
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOsearchDisposalCandidatePopupListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqStsVO .class);

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
	 * [EES_MNR_0151]Disposal Candidate Selection Flag  정보를 조회합니다.<br>
	 * 
	 * @param DisposalCandidateFlagINVO disposalCandidateFlagINVO
	 * @param SignOnUserAccount account
	 * @return List<CustomMnrEqStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrEqStsVO> searchDisposalCandidateFlagByEQData(DisposalCandidateFlagINVO disposalCandidateFlagINVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrEqStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrLabelValueList = null;
		
		try{
			if(disposalCandidateFlagINVO != null){
				Map<String, String> mapVO = disposalCandidateFlagINVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("user_ofc_cd", account.getOfc_cd());
				velParam.put("user_ofc_cd", account.getOfc_cd());
				//멀티 콤보로 넘어온 값 tpsz
				List<String> tpszCds = new ArrayList<String>();   
				String[] arrYdCd =  disposalCandidateFlagINVO.getEqTpszCd().split(",");
				for(int i = 0; i < arrYdCd.length; i ++){      
					tpszCds.add(arrYdCd[i]);     
				}     
				velParam.put("tpszCds", tpszCds);	  
				
				
				if ( !JSPUtil.getNull(disposalCandidateFlagINVO.getRstrUsgLbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(disposalCandidateFlagINVO.getRstrUsgLbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
				
				
				if("ALL".equals(disposalCandidateFlagINVO.getRuLableType())) {
					param.put("ru_lable_type", "");
					velParam.put("ru_lable_type", "");
				}
				
				
				if("ALL".equals(disposalCandidateFlagINVO.getRstrUsgLbl())) {
					param.put("rstr_usg_lbl", "");
					velParam.put("rstr_usg_lbl", "");
				}
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOsearchDisposalCandidateFlagByEQDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqStsVO .class);

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
	 * [EES_MNR_0151]Disposal Candidate Selection Range의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalCandidateFlagINVO disposalCandidateFlagINVO
	 * @param SignOnUserAccount account
	 * @return List<CustomMnrEqRngStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrEqRngStsVO> searchDisposalCandidateFlagByRangeData(DisposalCandidateFlagINVO disposalCandidateFlagINVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrEqRngStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(disposalCandidateFlagINVO != null){
				Map<String, String> mapVO = disposalCandidateFlagINVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("user_ofc_cd", account.getOfc_cd());
				velParam.put("user_ofc_cd", account.getOfc_cd());

				//멀티 콤보로 넘어온 값 tpsz
				List<String> tpszCds = new ArrayList<String>();   
				String[] arrYdCd =  disposalCandidateFlagINVO.getEqTpszCd().split(",");
				for(int i = 0; i < arrYdCd.length; i ++){      
					tpszCds.add(arrYdCd[i]);     
				}     
				velParam.put("tpszCds", tpszCds);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOsearchDisposalCandidateFlagByRangeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqRngStsVO .class);

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
	 * [EES_MNR_0151]Disposal Candidate Selection by EQ No  정보를 생성합니다. <br>
	 *
	 * @param List<CustomMnrEqStsVO> customMnrEqStsVOS
	 * @exception DAOException
	 */
	public void mergeDisposalCandidateFlagByEQData(List<CustomMnrEqStsVO> customMnrEqStsVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrEqStsVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOmergeDisposalCandidateFlagByEQDataCSQL(), customMnrEqStsVOS,null);
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
	 * [EES_MNR_0151]Disposal Candidate Selection by Serial Rang  정보를 생성합니다.<br>
	 *
	 * @param List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS
	 * @exception DAOException
	 */
	public void mergeDisposalCandidateFlagByRangeData(List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrEqRngStsVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOmergeDisposalCandidateFlagByRangeDataCSQL(), customMnrEqRngStsVOS,null);
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
	 * [EES_MNR_0151]Disposal Candidate Selection의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS
	 * @exception DAOException
	 */
	public void addDisposalCandidateFlagByRangeAfterData(List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			int insCnt[] = null;
			if(customMnrEqRngStsVOS.size() > 0){
				param.put("eq_knd_cd", customMnrEqRngStsVOS.get(0).getEqKndCd());          
				velParam.put("eq_knd_cd", customMnrEqRngStsVOS.get(0).getEqKndCd());
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOaddDisposalCandidateFlagByRangeAfterDataCSQL(), customMnrEqRngStsVOS, param, velParam);
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
	 * [EES_MNR_0151]Disposal Candidate Selection의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS
	 * @exception DAOException
	 */
	public void modifyDisposalCandidateFlagByRangeAfterData(List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			int modCnt[] = null;
			if(customMnrEqRngStsVOS.size() > 0){
				param.put("eq_knd_cd", customMnrEqRngStsVOS.get(0).getEqKndCd());          
				velParam.put("eq_knd_cd", customMnrEqRngStsVOS.get(0).getEqKndCd());
				modCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOmodifyDisposalCandidateFlagByRangeAfterDataUSQL(), customMnrEqRngStsVOS, param, velParam);
				for(int i = 0; i < modCnt.length; i++){
					if(modCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [EES_MNR_0151]Disposal Candidate Selection의 정보를 체크 합니다. <br>
	 *
	 * @param List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS
	 * @return List<CustomMnrEqStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<CustomMnrEqStsVO> checkDisposalCandidateFlagByRangeAfterData(List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CustomMnrEqStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try {

			if(customMnrEqRngStsVOS.size() > 0){
				param.put("eq_knd_cd", customMnrEqRngStsVOS.get(0).getEqKndCd());          
				velParam.put("eq_knd_cd", customMnrEqRngStsVOS.get(0).getEqKndCd());
				param.put("lot_eq_pfx_cd", customMnrEqRngStsVOS.get(0).getLotEqPfxCd());          
				velParam.put("lot_eq_pfx_cd", customMnrEqRngStsVOS.get(0).getLotEqPfxCd());	
				param.put("fm_ser_no", customMnrEqRngStsVOS.get(0).getFmSerNo());          
				velParam.put("fm_ser_no", customMnrEqRngStsVOS.get(0).getFmSerNo());	
				param.put("to_ser_no", customMnrEqRngStsVOS.get(0).getToSerNo());          
				velParam.put("to_ser_no", customMnrEqRngStsVOS.get(0).getToSerNo());	


				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOcheckDisposalCandidateFlagByRangeAfterDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqStsVO.class);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}					 


	/**
	 * [EES_MNR_0122]W/O Creation의 정보를 추가 합니다. <br>
	 * Hanger Rack/Bar Installation/Uninstallation  정보를 생성합니다.<br>
	 * @param List<CustomMnrFlgHisVO> customMnrFlgHisVOS
	 * @exception DAOException
	 */
	public void addHangerFlagHistoryListData(List<CustomMnrFlgHisVO> customMnrFlgHisVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrFlgHisVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOaddHangerFlagHistoryListDataCSQL(), customMnrFlgHisVOS,null);
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
	 * [EES_MNR_0122]W/O Creation의 정보의 Hanger Rack/Bar Installation/Uninstallation  정보를 조회합니다.. <br>
	 *
	 * @param String eqNo
	 * @return int
	 * @exception DAOException
	 */
	 public int checkHangerFlagStatusData(String eqNo) throws DAOException {
		 DBRowSet dbRowset = null;
		 int cnt = 0;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eqNo != null && eqNo != null){
				 param.put("eq_no", eqNo);
				 velParam.put("eq_no", eqNo); 
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOcheckHangerFlagStatusDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 cnt = dbRowset.getInt(1); 
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
	 * [EES_MNR_0122]W/O Creation의 정보의 Hanger Rack/Bar Installation/Uninstallation  정보를 등록합니다.. <br>
	 *
	 * @param List<CustomMnrEqStsVO> customMnrEqStsVOS
	 * @exception DAOException
	 */
	public void addHangerFlagStatusData(List<CustomMnrEqStsVO> customMnrEqStsVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrEqStsVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOaddHangerFlagStatusDataCSQL(), customMnrEqStsVOS,null);
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
	 * [EES_MNR_0122] Damage Flagging  정보를 등록합니다.. <br>
	 *
	 * @param List<CustomMnrEqStsVO> customMnrEqStsVOS
	 * @exception DAOException
	 */
	public void addEQFlagStatusData(List<CustomMnrEqStsVO> customMnrEqStsVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");  
			int insCnt[] = null;
			if(customMnrEqStsVOS.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOaddEQFlagStatusDataCSQL(), customMnrEqStsVOS,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addEQFlagStatusData No"+ i + " SQL");
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
	 * [EES_MNR_0122]W/O Creation의 정보의 Hanger Rack/Bar Installation/Uninstallation  정보를 수정합니다.. <br>
	 *
	 * @param List<CustomMnrEqStsVO> customMnrEqStsVOS
	 * @exception DAOException
	 */
	public void modifyHangerFlagStatusData(List<CustomMnrEqStsVO> customMnrEqStsVOS) throws DAOException,Exception {
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrEqStsVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOmodifyHangerFlagStatusDataUSQL(), customMnrEqStsVOS,null);
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
	 * [EES_MNR_0122]Damage Falgging  정보를 수정합니다.. <br>
	 *
	 * @param List<CustomMnrEqStsVO> customMnrEqStsVOS
	 * @exception DAOException
	 */
	public void modifyEQFlagStatusData(List<CustomMnrEqStsVO> customMnrEqStsVOS) throws DAOException,Exception {
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrEqStsVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOmodifyEQFlagStatusDataUSQL(), customMnrEqStsVOS,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyEQFlagStatusData No"+ i + " SQL");
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
	 * [EES_MNR_0151] Range 안에 EQ NO 리스트의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @return CustomMnrHngrInvtVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<IFMnrFlagVO> searchRangeToEQNoData(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO) throws DAOException {
		 DBRowSet dbRowset = null; 
		 List<IFMnrFlagVO> iFMnrFlagVOS = null;
		 //query parameter  
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>();
		    
		 //파라미터 세팅  하드 코딩을 위해  
		 IFMnrFlagVO iFMnrFlagVO = disposalCandidateFlagGRPVO.getIFMnrFlagVO();
		 Map<String, String> mapVO = iFMnrFlagVO.getColumnValues();
		 param.putAll(mapVO);                      
		 velParam.putAll(mapVO); 
		  
		 String eqFrNo = disposalCandidateFlagGRPVO.getEqFrNo();
		 String eqToNo = disposalCandidateFlagGRPVO.getEqToNo();
		 String eqPfx = disposalCandidateFlagGRPVO.getEqPfx();
		     
		 param.put("eq_fr_no", eqFrNo);      
		 param.put("eq_to_no", eqToNo);     
		 param.put("eq_prefix", eqPfx);     
		               
		 try{   
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOsearchRangeToEQNoDataRSQL(), param, velParam);
			 iFMnrFlagVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, IFMnrFlagVO .class);
		 }catch(SQLException se){    
			 log.error(se.getMessage(),se);    
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){   
			 log.error(ex.getMessage(),ex);   	
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }    
		 return iFMnrFlagVOS;    
	 }  
	 
	 /**
	  * [EES_MNR_0019] EQ NO 정보 단건 조회<br> 
	  * @param String eqNo
	  * @return CustomMnrEqStsVVO  
	  * @exception DAOException 
	  */
	 @SuppressWarnings("unchecked")
	 public CustomMnrEqStsVVO searchEqInfoData(String eqNo) throws DAOException {
		 DBRowSet dbRowset = null; 
		 List<CustomMnrEqStsVVO> customMnrEqStsVVOS = null;
		 CustomMnrEqStsVVO customMnrEqStsVVO = new CustomMnrEqStsVVO();
		 //query parameter  
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 param.put("eq_no", eqNo);      
		  
		 try{   
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOsearchEqInfoDataRSQL(), param, velParam);
			 customMnrEqStsVVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqStsVVO .class);
			 if(customMnrEqStsVVOS.size() > 0){
				 customMnrEqStsVVO = customMnrEqStsVVOS.get(0);
			 }   
			 
		 }catch(SQLException se){     
			 log.error(se.getMessage(),se);     
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){    
			 log.error(ex.getMessage(),ex);   	
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }     
		 return customMnrEqStsVVO;    
	 }  
	 
	/**
	 * [EES_MNR_0170]Reefer Unit Warranty 데이타가 이미 존재하는지 체크 <br>
	 *
	 * @param CustomWarrantyAlertListVO customWarrantyAlertListVO
	 * @return String 
	 * @exception DAOException 
	 */
	@SuppressWarnings("unchecked")
	 public String checkWarrantyAlertData(CustomWarrantyAlertListVO customWarrantyAlertListVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomWarrantyAlertListVO> customWarrantyAlertListVOS = null; 
		 	
		//query parameter	
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 	
			Map<String, String> mapVO = customWarrantyAlertListVO.getColumnValues();
				
			param.putAll(mapVO);                       
			velParam.putAll(mapVO);     
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOcheckWarrantyAlertDataRSQL(), param, velParam);
			customWarrantyAlertListVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomWarrantyAlertListVO .class);
			 
			if(customWarrantyAlertListVOS.size() > 0){  
				return "U"; 
			} else {
				return "I";
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
	 * [EES_MNR_0170]Reefer Unit Warranty Period의 정보를 삽입 합니다. <br>
	 *
	 * @param List<CustomWarrantyAlertListVO> customWarrantyAlertListVOs
	 * @exception DAOException
	 */
	public void addWarrantyAlertData(List<CustomWarrantyAlertListVO> customWarrantyAlertListVOs) throws DAOException,Exception {
		try {           
			SQLExecuter sqlExe = new SQLExecuter("");      
			int addCnt[] = null;       
			if(customWarrantyAlertListVOs.size() > 0){            
				addCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOaddWarrantyAlertDataCSQL(), customWarrantyAlertListVOs,null);
				          
				for(int i = 0; i < addCnt.length; i++){  
					if(addCnt[i]== Statement.EXECUTE_FAILED)      
						throw new DAOException("Fail to addWarrantyAlertData No"+ i + " SQL"); 
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
	 * [EES_MNR_0170]Reefer Unit Warranty Period의 정보를 작업 합니다. <br>
	 *
	 * @param List<CustomWarrantyAlertListVO> customWarrantyAlertListVOs
	 * @exception DAOException
	 */
	public void modifyWarrantyAlertData(List<CustomWarrantyAlertListVO> customWarrantyAlertListVOs) throws DAOException,Exception {
		try {      
			SQLExecuter sqlExe = new SQLExecuter("");     
			int modifyCnt[] = null;       
			if(customWarrantyAlertListVOs.size() > 0){           
				modifyCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOmodifyWarrantyAlertDataUSQL(), customWarrantyAlertListVOs,null);
					
				for(int i = 0; i < modifyCnt.length; i++){  
					if(modifyCnt[i]== Statement.EXECUTE_FAILED)        
						throw new DAOException("Fail to modifyWarrantyAlertData No"+ i + " SQL"); 
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
	 * [EES_MNR_0170]Reefer Unit Warranty Period의 정보를 삭제 합니다. <br>
	 *  
	 * @param List<CustomWarrantyAlertListVO> customWarrantyAlertListVOs
	 * @exception DAOException
	 */  
	public void removeWarrantyAlertData(List<CustomWarrantyAlertListVO> customWarrantyAlertListVOs) throws DAOException,Exception {
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");
			int removeCnt[] = null;
			if(customWarrantyAlertListVOs.size() > 0){
				removeCnt = sqlExe.executeBatch((ISQLTemplate)new EQFlagMgtDBDAOremoveWarrantyAlertDataDSQL(), customWarrantyAlertListVOs,null);
				for(int i = 0; i < removeCnt.length; i++){
					if(removeCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeWarrantyAlertData No"+ i + " SQL");
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
	 * [EES_MNR_0058] Hanger Bar Attatch/Detach Qty by CNTR의 정보를 조회 합니다. <br>
	 * WO 삭제전 EQ_STS 테이블 정보를 참조한다. 
	 * @param EQFlagListINVO eQFlagListINVO
	 * @return CustomMnrEqStsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CustomMnrEqStsVO searchHangerEQFlagListData(EQFlagListINVO eQFlagListINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrEqStsVO> list = null;
		CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eQFlagListINVO != null){
				Map<String, String> mapVO = eQFlagListINVO.getColumnValues();
				param.putAll(mapVO);	
				velParam.putAll(mapVO);
			}	
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOsearchHangerEQFlagListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqStsVO .class);
			if(list.size() > 0){
				customMnrEqStsVO = list.get(0);    
			}

		}catch(SQLException se){	
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return customMnrEqStsVO;
	}
	
	/**
	 * [EES_MNR_0109]MNR_STS_RMK 체크 <br>
	 *
	 * @param CustomMnrFlgHisVO customMnrFlgHisVO
	 * @return String 
	 * @exception DAOException 
	 */
	 public String searchEqStsRmkData(CustomMnrFlgHisVO customMnrFlgHisVO) throws DAOException {
		DBRowSet dbRowset = null;   
		String result = ""; 	
		//query parameter	
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 	
			Map<String, String> mapVO = customMnrFlgHisVO.getColumnValues();
				
			param.putAll(mapVO);                       
			velParam.putAll(mapVO);     
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOsearchEqStsRmkDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("MNR_STS_RMK");
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
	 * [EES_MNR_0109]EQ Flagging 체크 <br>
	 *
	 * @param CustomMnrEqStsVO customMnrEqStsVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkHngrFlaggingData(CustomMnrEqStsVO customMnrEqStsVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customMnrEqStsVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EQFlagMgtDBDAOcheckHngrFlaggingDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("MNR_HNGR_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [EES_MNR_0109]EQ Flagging Count <br>
	 *
	 * @param EQFlagListINVO eQFlagListINVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchHangerFlagStatusCountData(EQFlagListINVO eQFlagListINVO) throws DAOException {
		
		
		DBRowSet dbRowset = null;
//		List<CustomMnrEqStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrLabelValueList = null;
		String result = "";
		
		try{
			if(eQFlagListINVO != null){
				Map<String, String> mapVO = eQFlagListINVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if (eQFlagListINVO.getEqList() != null && eQFlagListINVO.getEqList().trim().length() > 0) {
					 List<String> eqNos = new ArrayList<String>(); 
					 String[] arrayEqNo =  eQFlagListINVO.getEqList().split(",");
					 for(int i = 0; i < arrayEqNo.length; i ++){      
						 eqNos.add(arrayEqNo[i]);	      
					 } 			
					 		  
					 param.put("eqNos",eqNos);  	  	                    
					 velParam.put("eqNos",eqNos); 
				}
				
				if (eQFlagListINVO.getEqTpszCd() != null && eQFlagListINVO.getEqTpszCd().trim().length() > 0) {
					List<String> tpszNos = new ArrayList<String>(); 
					String[] arrayTpszNo =  eQFlagListINVO.getEqTpszCd().split(",");
					for(int i = 0; i < arrayTpszNo.length; i ++){      
						tpszNos.add(arrayTpszNo[i]);			      
					} 			
					
					param.put("tpszNos",tpszNos);	 		  	                    
					velParam.put("tpszNos",tpszNos); 	
				}
				
				if ( !JSPUtil.getNull(eQFlagListINVO.getRstrUsgLbl()).equals("") ) {
					arrLabelValueList = JSPUtil.convertStringToArrayList(JSPUtil.replace(eQFlagListINVO.getRstrUsgLbl(),",","|"));
		        	param.put("labelvalue_list", arrLabelValueList);
		        	velParam.put("labelvalue_list", arrLabelValueList);        	
		        } 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOsearchHangerFlagStatusCountDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("TOTAL_CNT");
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
	 * [EES_MNR_0122] Container OP 여부를 체크합니다<br>
	 *
	 * @param String cntrNo
	 * @param String evntDt
	 * @return String
	 * @exception DAOException
	 */
	 public String checkOpStatusData(String cntrNo, String evntDt) throws DAOException {
		 DBRowSet dbRowset = null;
		 String result = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(cntrNo != null && evntDt != null){
				 param.put("cntr_no", cntrNo);
				 param.put("evnt_dt", evntDt);
				 velParam.put("cntr_no", cntrNo);
				 velParam.put("evnt_dt", evntDt); 
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQFlagMgtDBDAOcheckOpStatusDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 result = dbRowset.getString("MVMT_STS_CD");
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