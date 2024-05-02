/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncomeMgtDBDAO.java
*@FileTitle : Disposal Invoice Issue & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.21 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableINVInquiryListVO;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableInvoiceDetailINVO;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.ReceivableINVInquiryINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/** 
 * IncomeMgt 관련 디비 처리를 합니다.
 * @author 함형석
 * @see IncomeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class IncomeMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * [ EES_MNR_0161] 의 정보를 조회 합니다. <br>
	 *
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @return List<CustomReceivableINVInquiryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomReceivableINVInquiryListVO> searchReceivableInvoiceListByDisposalData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomReceivableINVInquiryListVO> customReceivableINVInquiryListVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           
			 
			 if(receivableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> dispNos = new ArrayList<String>();     
				 String[] arrDispNo =  receivableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrDispNo.length; i ++){         
					 dispNos.add(arrDispNo[i]);           
				 }     
				 velParam.put("dispNos", dispNos);
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncomeMgtDBDAOsearchReceivableInvoiceListByDisposalDataRSQL(), param, velParam);
			 customReceivableINVInquiryListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomReceivableINVInquiryListVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customReceivableINVInquiryListVOs; 
	 }
	 
	/**
	 * [EES_MNR_0161 ] 의 정보를 조회 합니다. <br>
	 *
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @return List<CustomReceivableINVInquiryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomReceivableINVInquiryListVO> searchReceivableInvoiceListByINVData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomReceivableINVInquiryListVO> customReceivableINVInquiryListVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           

			 if(receivableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> invNos = new ArrayList<String>();     
				 String[] arrInvNo =  receivableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrInvNo.length; i ++){         
					 invNos.add(arrInvNo[i]);           
				 }     
				 velParam.put("invNos", invNos);
			 }

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncomeMgtDBDAOsearchReceivableInvoiceListByINVDataRSQL(), param, velParam);
			 customReceivableINVInquiryListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomReceivableINVInquiryListVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customReceivableINVInquiryListVOs; 
	 }
	 
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 조회 합니다. <br>
	 *
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @return List<CustomReceivableInvoiceDetailINVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomReceivableInvoiceDetailINVO> searchReceivableInvoiceDetailListByDisposalData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomReceivableInvoiceDetailINVO> customReceivableInvoiceDetailINVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           
			 
			 if(receivableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> dispNos = new ArrayList<String>();     
				 String[] arrDispNo =  receivableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrDispNo.length; i ++){         
					 dispNos.add(arrDispNo[i]);           
				 }     
				 velParam.put("dispNos", dispNos);
			 }
				
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncomeMgtDBDAOsearchReceivableInvoiceDetailListByDisposalDataRSQL(), param, velParam);
			 customReceivableInvoiceDetailINVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomReceivableInvoiceDetailINVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customReceivableInvoiceDetailINVOs; 
	 }
	 
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 조회 합니다. <br>
	 *
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @return List<CustomReceivableInvoiceDetailINVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomReceivableInvoiceDetailINVO> searchReceivableInvoiceDetailListINVData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomReceivableInvoiceDetailINVO> customReceivableInvoiceDetailINVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           
			 
			 if(receivableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> invNos = new ArrayList<String>();     
				 String[] arrInvNo =  receivableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrInvNo.length; i ++){         
					 invNos.add(arrInvNo[i]);           
				 }     
				 velParam.put("invNos", invNos);
			 }
				
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncomeMgtDBDAOsearchReceivableInvoiceDetailListINVDataRSQL(), param, velParam);
			 customReceivableInvoiceDetailINVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomReceivableInvoiceDetailINVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customReceivableInvoiceDetailINVOs; 
	 }	 
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 체크 합니다. <br>
	 *
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @return String
	 * @exception DAOException
	 */
	 public String checkReceivableInvoiceData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String retVal = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
	     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncomeMgtDBDAOcheckReceivableInvoiceDataRSQL(), param, velParam);
			 
			if(dbRowset.next()){
			 retVal = dbRowset.getString("MNR_INV_STS_CD");
			}
			 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}


	 /**
	  * [EES_MNR_0161]Disposal Invoice Issue의 정보를 추가 합니다. <br>
	  *
	  * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	  * @exception DAOException
	  */   
	public void addReceivableInvoiceData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new IncomeMgtDBDAOaddReceivableInvoiceDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to IncomeMgtDBDAOaddReceivableInvoiceDataCSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 

	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 수정 합니다. <br>
	 *
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @exception DAOException
	 */ 
	public void modifyReceivableInvoiceData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new IncomeMgtDBDAOmodifyReceivableInvoiceDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to IncomeMgtDBDAOmodifyReceivableInvoiceDataUSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 
	
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 조회 합니다. <br>
	 *
	 * @return String
	 * @exception DAOException
	 */
	 public String searchReceivableInvSeqData() throws DAOException{
	 	DBRowSet dbRowset = null;    
	 	String returnVal = "";
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();
	 	
	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncomeMgtDBDAOsearchReceivableInvSeqDataRSQL(), param, velParam);
	 		if(dbRowset.next()){ 
	 			returnVal = dbRowset.getString("SEQ");
	 		}
	 	}catch(SQLException se){
	 		log.error(se.getMessage(),se); 
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	}catch(Exception ex){
	 		log.error(ex.getMessage(),ex);  	
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}    
	 	return returnVal;
	 }	


	 /**
	  * [EES_MNR_0161]Disposal Invoice Issue의 정보를 삭제 합니다. <br>
	  *
	  * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	  * @exception DAOException
	  */
	public void removeReceivableInvoiceData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new IncomeMgtDBDAOremoveReceivableInvoiceDataDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to IncomeMgtDBDAOremoveReceivableInvoiceDataDSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 
	
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 상태정보를 수정 합니다. <br>
	 *
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @exception DAOException
	 */ 
	public void modifyReceivableInvoiceStatusData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new IncomeMgtDBDAOmodifyReceivableInvoiceStatusDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to IncomeMgtDBDAOmodifyReceivableInvoiceStatusDataUSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 	
	
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue의 INV_NO 정보를 조회 합니다. <br>
	 *
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @return String
	 * @exception DAOException
	 */
	 public String searchReceivableInvoiceNoData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException{
	 	DBRowSet dbRowset = null;    
	 	String returnVal = "";
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();
	 	
	 	try{
			 Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);  
			 
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncomeMgtDBDAOsearchReceivableInvoiceNoDataRSQL(), param, velParam);
	 		if(dbRowset.next()){ 
	 			returnVal = dbRowset.getString("INV_NO");
	 		}
	 	}catch(SQLException se){
	 		log.error(se.getMessage(),se); 
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	}catch(Exception ex){
	 		log.error(ex.getMessage(),ex);  	
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}    
	 	return returnVal;
	 }		
}