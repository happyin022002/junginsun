/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpenseMgtDBDAO.java
*@FileTitle : MNR Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : Chagn Young Kim
*@LastVersion : 1.0
* 2009.08.17 함형석
* 1.0 Creation
* 2014-10-06 Chang Young Kim 10만불 비용지급 결재 3차 Invoice File Attatch 기능 추가
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration;
  
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.basic.ExpenseMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.CustomMnrPayInvWrkVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.CustomPayableINVInquiryListVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.CustomPayableInvoiceDetailINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.GLEstimateINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.GLEstimateVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.PayableINVInquiryINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
 
/** 
 * Expense관련 디비 처리를 합니다.
 * @author 함형석
 * @see ExpenseMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ExpenseMgtDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;	
		
	/**
	 * [EES_MNR_0042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param PayableINVInquiryINVO payableINVInquiryINVO
	 * @return List<CustomPayableINVInquiryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomPayableINVInquiryListVO> searchPayableInvoiceListByWEBData(PayableINVInquiryINVO payableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomPayableINVInquiryListVO> customPayableINVInquiryListVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = payableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           
			 
			 if(payableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> woNos = new ArrayList<String>();     
				 String[] arrWoNo =  payableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrWoNo.length; i ++){         
			 	 	woNos.add(arrWoNo[i]);           
				 }     
				 velParam.put("woNos", woNos);
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOsearchPayableInvoiceListByWEBDataRSQL(), param, velParam);
			 customPayableINVInquiryListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomPayableINVInquiryListVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customPayableINVInquiryListVOs; 
	 }

	
	/**
	 * [EES_MNR_0042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param PayableINVInquiryINVO payableINVInquiryINVO
	 * @return List<CustomPayableINVInquiryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomPayableINVInquiryListVO> searchPayableInvoiceListByWOData(PayableINVInquiryINVO payableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomPayableINVInquiryListVO> customPayableINVInquiryListVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = payableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           
			 
			 if(payableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> woNos = new ArrayList<String>();     
				 //2010-04-14 OrdSeq는 Number 형이므로 숫자형이 아닌 문자는 잘라버린다.
				 String[] arrWoNo =  payableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrWoNo.length; i ++){ 
					String tempArrWoNo = arrWoNo[i].substring(3);
					StringBuilder tempSerWoNo = new StringBuilder("");
					char chars[] = tempArrWoNo.toCharArray();
					for(int k = 0; k < chars.length;k ++){
						if(!(chars[k] < '0' || chars[k] > '9')) { 
							Character ch = new Character(chars[k]);
							tempSerWoNo.append(ch.toString());	
						} 		
					}		
			 	 	woNos.add(tempSerWoNo.toString());           
				 }   	  
				 velParam.put("woNos", woNos);	
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOsearchPayableInvoiceListByWODataRSQL(), param, velParam);
			 customPayableINVInquiryListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomPayableINVInquiryListVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customPayableINVInquiryListVOs; 
	 }
	 
	/**
	 * [EES_MNR_0042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param PayableINVInquiryINVO payableINVInquiryINVO
	 * @return List<CustomPayableINVInquiryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomPayableINVInquiryListVO> searchPayableInvoiceListByINVData(PayableINVInquiryINVO payableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomPayableINVInquiryListVO> customPayableINVInquiryListVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = payableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           


			 if(payableINVInquiryINVO.getMnrInvStsCd().length()==2){
				 velParam.put("InvStsLen", "2");
			 }else{
				 velParam.put("InvStsLen", "1");
			 }
				
			 if(payableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> woNos = new ArrayList<String>();     
				 String[] arrWoNo =  payableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrWoNo.length; i ++){     
					String kind = payableINVInquiryINVO.getInvSchTypeCode();
					if(kind.equals("WI")){
						woNos.add(arrWoNo[i]);  
					}else if(kind.equals("MI")){
						woNos.add(arrWoNo[i].substring(3));  
					}else if(kind.equals("CO")){
						woNos.add(arrWoNo[i]);  
					}
				 }     
				 velParam.put("woNos", woNos);
			 }

			 if(payableINVInquiryINVO.getInvNo().length()>0){
				 List<String> invNos = new ArrayList<String>();     
				 String[] arrInvNo =  payableINVInquiryINVO.getInvNo().split(",");
				 for(int i = 0; i < arrInvNo.length; i ++){         
			 	 	invNos.add(arrInvNo[i]);           
				 }     
				 velParam.put("invNos", invNos);
			 }
			 
			 if(payableINVInquiryINVO.getCsrNo().length()>0){
				 List<String> csrNos = new ArrayList<String>();     
				 String[] arrCsrNo =  payableINVInquiryINVO.getCsrNo().split(",");
				 for(int i = 0; i < arrCsrNo.length; i ++){         
					 csrNos.add(arrCsrNo[i]);           
				 }     
				 velParam.put("csrNos", csrNos);
			 }


			 if(payableINVInquiryINVO.getInvWoNo().length()>0){
				 List<String> invWoNos = new ArrayList<String>();     
				 String[] arrInvWoNo =  payableINVInquiryINVO.getInvWoNo().split(",");
				 for(int i = 0; i < arrInvWoNo.length; i ++){         
			 	 	invWoNos.add(arrInvWoNo[i].substring(3));           
				 }     
				 velParam.put("invWoNos", invWoNos);
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOsearchPayableInvoiceListByINVDataRSQL(), param, velParam);
			 customPayableINVInquiryListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomPayableINVInquiryListVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customPayableINVInquiryListVOs; 
	 }

	/**
	 * [EES_MNR_S042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param PayableINVInquiryINVO payableINVInquiryINVO
	 * @return List<CustomPayableINVInquiryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomPayableINVInquiryListVO> searchPayableInvoiceListByINVSPPData(PayableINVInquiryINVO payableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomPayableINVInquiryListVO> customPayableINVInquiryListVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = payableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           



				
			 if(payableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> woNos = new ArrayList<String>();     
				 String[] arrWoNo =  payableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrWoNo.length; i ++){     
					String kind = payableINVInquiryINVO.getInvSchTypeCode();
					if(kind.equals("WI")){
						woNos.add(arrWoNo[i]);  
					}else if(kind.equals("MI")){
						woNos.add(arrWoNo[i].substring(3));  
					}else if(kind.equals("CO")){
						woNos.add(arrWoNo[i]);  
					}
				 }     
				 velParam.put("woNos", woNos);
			 }

			 if(payableINVInquiryINVO.getInvNo().length()>0){
				 List<String> invNos = new ArrayList<String>();     
				 String[] arrInvNo =  payableINVInquiryINVO.getInvNo().split(",");
				 for(int i = 0; i < arrInvNo.length; i ++){         
			 	 	invNos.add(arrInvNo[i]);           
				 }     
				 velParam.put("invNos", invNos);
			 }
			 
			 if(payableINVInquiryINVO.getCsrNo().length()>0){
				 List<String> csrNos = new ArrayList<String>();     
				 String[] arrCsrNo =  payableINVInquiryINVO.getCsrNo().split(",");
				 for(int i = 0; i < arrCsrNo.length; i ++){         
					 csrNos.add(arrCsrNo[i]);           
				 }     
				 velParam.put("csrNos", csrNos);
			 }


			 if(payableINVInquiryINVO.getInvWoNo().length()>0){
				 List<String> invWoNos = new ArrayList<String>();     
				 String[] arrInvWoNo =  payableINVInquiryINVO.getInvWoNo().split(",");
				 for(int i = 0; i < arrInvWoNo.length; i ++){         
			 	 	invWoNos.add(arrInvWoNo[i].substring(3));           
				 }     
				 velParam.put("invWoNos", invWoNos);
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOsearchPayableInvoiceListByINVSPPDataRSQL(), param, velParam);
			 customPayableINVInquiryListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomPayableINVInquiryListVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customPayableINVInquiryListVOs; 
	 }
	
	/**
	 * [EES_MNR_0042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param PayableINVInquiryINVO payableINVInquiryINVO
	 * @return List<CustomPayableInvoiceDetailINVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomPayableInvoiceDetailINVO> searchInvoiceDetailListByWEBData(PayableINVInquiryINVO payableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomPayableInvoiceDetailINVO> customPayableInvoiceDetailINVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = payableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           
			 
			 if(payableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> woNos = new ArrayList<String>();     
				 String[] arrWoNo =  payableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrWoNo.length; i ++){         
			 	 	woNos.add(arrWoNo[i]);           
				 }     
				 velParam.put("woNos", woNos);
			 }
				
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOsearchInvoiceDetailListByWEBDataRSQL(), param, velParam);
			 customPayableInvoiceDetailINVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomPayableInvoiceDetailINVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customPayableInvoiceDetailINVOs; 
	 }

	/**
	 * [EES_MNR_0042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param PayableINVInquiryINVO payableINVInquiryINVO
	 * @return List<CustomPayableInvoiceDetailINVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomPayableInvoiceDetailINVO> searchInvoiceDetailListByWOData(PayableINVInquiryINVO payableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomPayableInvoiceDetailINVO> customPayableInvoiceDetailINVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = payableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           

			 
			 if(payableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> mnrOrdOfcCtyCds = new ArrayList<String>();     
				 String[] arrmnrOrdOfcCtyCd =  payableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrmnrOrdOfcCtyCd.length; i ++){         
					 mnrOrdOfcCtyCds.add(arrmnrOrdOfcCtyCd[i].substring(0,3));           
				 }     
				 velParam.put("mnrOrdOfcCtyCds", mnrOrdOfcCtyCds);
			 }			 
			 
			 if(payableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> woNos = new ArrayList<String>();     
				 String[] arrWoNo =  payableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrWoNo.length; i ++){         
			 	 	woNos.add(arrWoNo[i].substring(3));           
				 }     
				 velParam.put("woNos", woNos);
			 }
				
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOsearchInvoiceDetailListByWODataRSQL(), param, velParam);
			 customPayableInvoiceDetailINVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomPayableInvoiceDetailINVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customPayableInvoiceDetailINVOs; 
	 }
	 
	/**
	 * [EES_MNR_0042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param PayableINVInquiryINVO payableINVInquiryINVO
	 * @return List<CustomPayableInvoiceDetailINVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomPayableInvoiceDetailINVO> searchInvoiceDetailListByINVData(PayableINVInquiryINVO payableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomPayableInvoiceDetailINVO> customPayableInvoiceDetailINVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = payableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           
			 
			 log.debug("\n----------------- DAO payableINVInquiryINVO.getMnrOrdSeq().length() : "+payableINVInquiryINVO.getMnrOrdSeq().length());
			 
			 if(payableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> woNos = new ArrayList<String>();     
				 String[] arrWoNo =  payableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrWoNo.length; i ++){         
			 	 	woNos.add(arrWoNo[i]);           
				 }     
				 velParam.put("woNos", woNos);
			 }
				
			 // // CHM-201429630, ALPS-MNR-REPAIR-INVOICE INQUIRY 보완 요청
			 if(payableINVInquiryINVO.getPayInvSeq().length()>0){
				 List<String> payInvSeqs = new ArrayList<String>();     
				 String[] arrPayInvSeq =  payableINVInquiryINVO.getPayInvSeq().split(",");
				 for(int i = 0; i < arrPayInvSeq.length; i ++){         
					 payInvSeqs.add(arrPayInvSeq[i]);           
				 }     
				 log.debug("\n----------------- DAO payInvSeqs : "+payInvSeqs);
				 velParam.put("payInvSeqs", payInvSeqs);
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOsearchInvoiceDetailListByINVDataRSQL(), param, velParam);
			 customPayableInvoiceDetailINVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomPayableInvoiceDetailINVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customPayableInvoiceDetailINVOs; 
	 }	 
	
	/**
	 * [EES_MNR_0042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param PayableINVInquiryINVO payableINVInquiryINVO
	 * @return List<CustomPayableInvoiceDetailINVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<CustomPayableInvoiceDetailINVO> searchInvoiceDetailListByINVSPPData(PayableINVInquiryINVO payableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomPayableInvoiceDetailINVO> customPayableInvoiceDetailINVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = payableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           
			 
			 if(payableINVInquiryINVO.getMnrOrdSeq().length()>0){
				 List<String> woNos = new ArrayList<String>();     
				 String[] arrWoNo =  payableINVInquiryINVO.getMnrOrdSeq().split(",");
				 for(int i = 0; i < arrWoNo.length; i ++){         
			 	 	woNos.add(arrWoNo[i]);           
				 }     
				 velParam.put("woNos", woNos);
			 }
				
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOsearchInvoiceDetailListByINVSPPDataRSQL(), param, velParam);
			 customPayableInvoiceDetailINVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomPayableInvoiceDetailINVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customPayableInvoiceDetailINVOs; 
	 }	 
	
	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 체크 합니다. <br>
	 *
	 * @param CustomMnrPayInvWrkVO customMnrPayInvWrkVO
	 * @return String
	 * @exception DAOException
	 */
	 public String checkPayableInvoiceData(CustomMnrPayInvWrkVO customMnrPayInvWrkVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String retVal = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 	
		try{
			Map<String, String> mapVO = customMnrPayInvWrkVO.getColumnValues();
	     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOcheckPayableInvoiceDataRSQL(), param, velParam);
			 
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
	  * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 추가 합니다. <br>
	  *
	  * @param CustomMnrPayInvWrkVO customMnrPayInvWrkVO
	  * @exception DAOException
	  */   
	public void addPayableInvoiceData(CustomMnrPayInvWrkVO customMnrPayInvWrkVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customMnrPayInvWrkVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new ExpenseMgtDBDAOaddPayableInvoiceDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to ExpenseMgtDBDAOaddPayableInvoiceDataCSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 

	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 수정 합니다. <br>
	 *
	 * @param CustomMnrPayInvWrkVO customMnrPayInvWrkVO
	 * @exception DAOException
	 */  
	public void modifyPayableInvoiceData(CustomMnrPayInvWrkVO customMnrPayInvWrkVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customMnrPayInvWrkVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new ExpenseMgtDBDAOmodifyPayableInvoiceDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to ExpenseMgtDBDAOmodifyPayableInvoiceDataUSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 

	/**
	 * [EES_MNR_0229] M&R Estimate expense 를 삭제합니다.<br>
	 * 
	 * @param GLEstimateINVO gLEstimateINVO
	 * @exception DAOException
	 */  
	public void removeGLEstimateIFData(GLEstimateINVO gLEstimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = gLEstimateINVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
	        		 
			SQLExecuter sqlExe = new SQLExecuter("");    
			int result = sqlExe.executeUpdate((ISQLTemplate)new ExpenseMgtDBDAOremoveGLEstimateIFDataDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)  
					throw new DAOException("Fail to removeGLEstimateIFData");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 
	
	/**
	 * [EES_MNR_0229] M&R Estimate expense 를 입력합니다.<br>
	 * 
	 * @param GLEstimateINVO gLEstimateINVO
	 * @exception DAOException
	 */  
	public void addGLEstimateIFData(GLEstimateINVO gLEstimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			//************ ORA-01861 addMonth를 사용하지 않고 자바에서 구해버림 START
			StringBuffer resultDate = new StringBuffer ("");
			String[] splitTemp = gLEstimateINVO.getMonth().split("-");  
			int year = Integer.parseInt(splitTemp[0]);  
			int month = Integer.parseInt(splitTemp[1]) - 2;  
			int day = 1;		       
			
			Calendar sysdt = Calendar.getInstance(); 	 
			sysdt.set(year, month, day);	 	                        
			sysdt.add(Calendar.MONTH, 1);          
				
			int afYear = sysdt.get(Calendar.YEAR);
			int afMonth = sysdt.get(Calendar.MONTH)+1;
			int afDay = sysdt.getActualMaximum(sysdt.DAY_OF_MONTH);
			
			resultDate.append(afYear);
			 	
			if(afMonth < 10){
				resultDate.append("0");
			}	
			resultDate.append(afMonth); 
			resultDate.append(afDay); 
			
			gLEstimateINVO.setMonth(resultDate.toString());            
			Map<String, String> mapVO = gLEstimateINVO.getColumnValues();
			//************ ORA-01861 addMonth를 사용하지 않고 자바에서 구해버림 END
			
			param.putAll(mapVO);     
			velParam.putAll(mapVO);    
			 
			SQLExecuter sqlExe = new SQLExecuter("");     
			int result = sqlExe.executeUpdate((ISQLTemplate)new ExpenseMgtDBDAOaddGLEstimateIFDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)  
				throw new DAOException("Fail to addGLEstimateIFData");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 

	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 조회 합니다. <br>
	 *
	 * @return String
	 * @exception DAOException
	 */ 
	 public String searchPayInvSeqData() throws DAOException{
	 	DBRowSet dbRowset = null;    
	 	String returnVal = "";
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();
	 	
	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOsearchPayInvSeqDataRSQL(), param, velParam);
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
	  * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 삭제 합니다. <br>
	  *
	  * @param PayableINVInquiryINVO payableINVInquiryINVO
	  * @exception DAOException
	  */  
	public void removePayableInvoiceData(PayableINVInquiryINVO payableINVInquiryINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = payableINVInquiryINVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new ExpenseMgtDBDAOremovePayableInvoiceDataDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to ExpenseMgtDBDAOremovePayableInvoiceDataDSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 	  
	} 
		
	/**
	 * [EES_MNR_0229]M&R Estimate expense를 조회합니다.<br>
	 * 
	 * @param GLEstimateINVO gLEstimateINVO
	 * @param SignOnUserAccount account
	 * @return List<GLEstimateVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<GLEstimateVO> searchGLEstimateIFListData(GLEstimateINVO gLEstimateINVO, SignOnUserAccount account) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<GLEstimateVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//파라미터 맵핑시에 모델 설계 문서 질문
			
			if(gLEstimateINVO != null){
				Map<String, String> mapVO = gLEstimateINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("user_ofc_cd", account.getOfc_cd());
				velParam.put("user_ofc_cd", account.getOfc_cd());
			}

			// By Buyer
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOSearchGLEstimateIFListDataRSQL(), param, velParam);										
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GLEstimateVO .class);
			
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
	 * [EES_MNR_0096] Total Loss 정보를 조회 합니다. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @return List<CustomMnrPayInvWrkVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrPayInvWrkVO> searchTotalLossPayableInvoiceData(PayableInvoiceGRPVO payableInvoiceGRPVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrPayInvWrkVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{        
			String ttlLssNo = payableInvoiceGRPVO.getTtlLssNo();
			param.put("ttl_lss_no", ttlLssNo);      
			String ttlLssDtlSeq = payableInvoiceGRPVO.getTtlLssDtlSeq();
			param.put("ttl_lss_dtl_seq", ttlLssDtlSeq);     
			String ttlLssIssDt = payableInvoiceGRPVO.getTtlLssIssDt();
			param.put("ttl_lss_iss_dt", ttlLssIssDt);        
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExpenseMgtDBDAOsearchTotalLossPayableInvoiceDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrPayInvWrkVO .class);      
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
	  * [EES_MNR_0096]Total Loss 정보를 M&R Invoice Creation & Correction의 정보에 추가 합니다. <br>
	  *
	  * @param CustomMnrPayInvWrkVO customMnrPayInvWrkVO
	  * @exception DAOException
	  */   
	public void addTotalLossPayableInvoiceData(CustomMnrPayInvWrkVO customMnrPayInvWrkVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customMnrPayInvWrkVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new ExpenseMgtDBDAOaddTotalLossPayableInvoiceDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to ExpenseMgtDBDAOaddTotalLossPayableInvoiceDataCSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 
	
	/**
	 * [EES_MNR_0096]Total Loss 정보를 M&R Invoice Creation & Correction의 정보에 추가 합니다. <br>
	 *
	 * @param String  payInvSeq
	 * @param String  invRgstNo
	 * @param String  updUsrId
	 * @exception DAOException
	 */   
	public void modifyTotalLossPayableInvoiceData(String  payInvSeq, String invRgstNo, String updUsrId, String fileSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("pay_inv_seq", payInvSeq);
			param.put("inv_rgst_no", invRgstNo);
			param.put("upd_usr_id", updUsrId);
			param.put("file_seq", fileSeq);
			velParam.put("pay_inv_seq", payInvSeq);
			velParam.put("inv_rgst_no", invRgstNo);
			velParam.put("upd_usr_id", updUsrId);
			velParam.put("file_seq", fileSeq);
			
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new ExpenseMgtDBDAOmodifyTotalLossPayableInvoiceDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
				throw new DAOException("Fail to ExpenseMgtDBDAOmodifyTotalLossPayableInvoiceDataUSQL update SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 

	/**
	 * [EES_MNR_0041]Payable Invoice 상태정보를 수정 합니다.  <br>
	 *
	 * @param PayableINVInquiryINVO payableINVInquiryINVO
	 * @exception DAOException
	 */  
	public void modifyPayableInvoiceStatusData(PayableINVInquiryINVO payableINVInquiryINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = payableINVInquiryINVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  

			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new ExpenseMgtDBDAOmodifyPayableInvoiceStatusDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to ExpenseMgtDBDAOmodifyPayableInvoiceStatusDataUSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 

	 /**
	  * [EES_MNR_S041] invoice Tmp을 삭제합니다.<br> 
	  * 
	  * @param  CustomMnrPayInvWrkVO customMnrPayInvWrkVO
	  * @return int 						
	  * @throws DAOException
	  */
	 public int deleteWEBInvoiceLinkData(CustomMnrPayInvWrkVO customMnrPayInvWrkVO) throws DAOException {
		//query parameter 
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;	 	
			
		try { 
			Map<String, String> mapVO = customMnrPayInvWrkVO.getColumnValues();
				
			param.putAll(mapVO);      
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new ExpenseMgtDBDAOremoveWEBInvoiceLinkDataDSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update ExpenseMgtDBDAOremoveWEBInvoiceLinkDataDSQL"); 
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
	 * [EES_MNR_S041] invoice Tmp을 생성합니다.<br>
	 * 
	 * @param List<CustomPayableInvoiceDetailINVO> customPayableInvoiceDetailINVOs
	 * @throws DAOException
	 */

	public void addWEBInvoiceLinkData(List<CustomPayableInvoiceDetailINVO> customPayableInvoiceDetailINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customPayableInvoiceDetailINVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ExpenseMgtDBDAOaddWEBInvoiceLinkDataCSQL(), customPayableInvoiceDetailINVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to ExpenseMgtDBDAOaddWEBInvoiceLinkDataCSQL ins No"+ i + " SQL");
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
	  * [EES_MNR_S041] MNR_PAY_INV_WRK 정보를 수정한다.<br>
	  *  
	  * @param CustomMnrPayInvWrkVO customMnrPayInvWrkVO 
	  * @throws DAOException    
	  */   
	public void modifyWEBInvoiceFlagData(CustomMnrPayInvWrkVO customMnrPayInvWrkVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customMnrPayInvWrkVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new ExpenseMgtDBDAOmodifyWEBInvoiceFlagDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to ExpenseMgtDBDAOmodifyWEBInvoiceFlagDataUSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 
	
	/**
	  * [EES_MNR_0041] 해당 MNR_ORD_DTL 테이블에서 해당 PAY_INV_SEQ에 ACCT_CD가 511591인 놈들을 삭제한다.  <br>
	  *
	  * @param PayableINVInquiryINVO payableINVInquiryINVO
	  * @return int
	  * @exception DAOException
	  */
	 public int removeWODetailByPayINVSeqData(PayableINVInquiryINVO payableINVInquiryINVO) throws DAOException {
		 //query parameter 
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 int result = 0;	 	
		 
		 try { 	
			 Map<String, String> mapVO = payableINVInquiryINVO.getColumnValues();
			 
			 param.putAll(mapVO);      
			 velParam.putAll(mapVO);	    
			 
			 SQLExecuter sqlExe = new SQLExecuter("");  
			 	
			 result = sqlExe.executeUpdate((ISQLTemplate)new ExpenseMgtDBDAOremoveWODetailByPayINVSeqDataDSQLDSQL(), param, velParam);
			 
			 if(result == Statement.EXECUTE_FAILED)     
				 throw new DAOException("Fail to Delete removeWODetailByPayINVSeqData");   
		 } catch (SQLException se) { 
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage()); 
		 }catch(Exception ex){ 
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }		
		 return result;
	 }	
}