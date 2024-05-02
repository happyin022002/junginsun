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
* --------------------------------------------------------
* History
* 2011.11.21 신혜정 [CHM-201114467-01] Cancelled Disposal Invoice history 저장  
* 2012.04.05 신혜정 [CHM-201217201] Disposal Invoice Issue 화면내 [Confirm], [Cancel] 처리시, invoice no 체크 로직 추가
					  1. [Confirm] 처리시, invoice no 유,무에 따른 체크 로직 추가
					   - invoice no 가 있을 경우 confirm 된 데이타 확인 후 존재시 return 처리
					   - invoice no 가 없을 경우(invoice status=New) Verify List 의 disposal no, eq_no 리스트로 invoice no 존재 확인후 있으면 return 처리
					  2. [Cancel] 처리시, Cancel invoice no 체크 로직 추가
					   - 기 Cancel invoice no 존재시 return 처리
* 2013.07.05 조경완  [CHM-201325280-01] ALPS MNR-Disposal-Invoice 이중 Interface 건 검토/Data 수정 및 로직 검토
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.basic.IncomeMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableINVInquiryListVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableInvoiceDetailINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableINVInquiryINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/** 
 * IncomeMgt 관련 디비 처리를 합니다.
 * @author 함형석
 * @see IncomeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class IncomeMgtDBDAO extends DBDAOSupport {

		
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
	 * [EES_MNR_0161]Disposal Invoice Issue의 State정보를 수정 합니다. <br>
	 *
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @exception DAOException
	 */ 
	public void modifyReceivableInvoiceStateHsData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new IncomeMgtDBDAOmodifyReceivableInvoiceStateHsDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to IncomeMgtDBDAOmodifyReceivableInvoiceStateHsDataUSQL insert SQL");
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
	 
	/**
	 * [EES_MNR_0161]Cancelled Disposal Invoice history 정보를 저장한다.  
	 * @param receivableINVInquiryINVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addReceivableInvoiceCancelledData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new IncomeMgtDBDAOaddReceivableInvoiceCancelledDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to IncomeMgtDBDAOaddReceivableInvoiceCancelledDataCSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 	 
	
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue 내 Confirm, Cancel 시 invoice no 중복여부 체크 <br>
	 * @param receivableINVInquiryINVO INV_NO, MNR_INV_STS_CD
	 * @return String X:중복
	 * @throws DAOException
	 */
	public String checkReceivableInvNoData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
 
		try{
			Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
 	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
	 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncomeMgtDBDAOcheckReceivableInvNoDataRSQL(), param, velParam);
	 
			if(dbRowset.next()){
				rtnVal = "X";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}

	/**
	 * [EES_MNR_0161] Disposal Invoice Issue 내 Confirm 시 invoice no 중복여부를 점검합니다. <br>
	 * 
	 * @param CustomMnrDispDtlVO customMnrDispDtlVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkVerifiedInvNoData(CustomMnrDispDtlVO customMnrDispDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
 
		try{
			Map<String, String> mapVO = customMnrDispDtlVO.getColumnValues();
 	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
	 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncomeMgtDBDAOcheckVerifiedInvNoDataRSQL(), param, velParam);
	 
			if(dbRowset.next()){
				rtnVal = dbRowset.getString("INV_NO");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}	
	
	/**
	 * [EES_MNR_0161]Disposal Invoice Issue 내 Confirm, Cancel 시 invoice no 중복여부 체크 <br>
	 * @param ReceivableINVInquiryINVO receivableINVInquiryINVO
	 * @return Int
	 * @throws DAOException
	 */
	public int checkReceivableInvSumData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnVal = 0;
 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
 
		try{
			Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
 	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
	 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IncomeMgtDBDAOcheckReceivableInvSumDataRSQL(), param, velParam);
	 
			if(dbRowset.next()){
				rtnVal = dbRowset.getInt(1);
			 }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
	
}