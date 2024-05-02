/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtDBDAO.java
*@FileTitle : Disposal
*Open Issues :
*Change history : 
*@LastModifyDate : 2009.09.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.09.11 박명신 
* 1.0 Creation 
* --------------------------------------------------------
* History
* 2011.08.30 나상보 [CHM-201113102] ALPS MNR-Disposal-Disposal Inquiry화면에 조회 Status 추가 개발 요청
* 2011.10.14 허철용 [CHM-201113679-01] ALPS MNR-Disposal-SOLD Creation 에서
*                  office로 sold creation 할 수 있게 office 입력 및 조회할 수 있게 보완 개발
* 2011.11.03 신혜정 [CHM-201114270-01] Disposal Invoice Inquiry 화면 Invoice No. 체크박스 선택해서 Detail 정보 조회 가능하게 추가 요청
* 2011.11.21 신혜정 [CHM-201114467-01] Cancelled Disposal Invoice history 저장 
* 2012.04.12 신혜정 [CHM-201217048] Disposal Inquiry 화면에서 not pick-up 된 장비 list 조회 기능 추가 
* 2012.11.29 조경완 [CHM-201221414-01] ALPS-MNR-DISPOSAL-MANAGEMENT-MANAGEMENT INQUIRY 화면에서 수정 건           
* 2013.04.25 조경완 [CHM-201324321-01] [MNR] 동일 장비에 대해 중복 Disposal Request되는 현상 제거를 위한 기능 보완     
* 2013.09.27 조경완 [CHM-201326609-01] ALPS MNR-Disposal-Disposal Management에서 비딩 결과를 이메일로 통보해주는 기능
* 2015.08.24 박정민 [CHM-201537246] Disposal RQST 삭제 권한 조정 - SELCON의 경우 DISPOSAL MANAGEMENT상에서 OFC별 조회 가능하도록 처리 
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableINVInquiryINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.EmailSendInfoVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.GeneralMailFormVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.basic.DisposalMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomBkgOtsDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomDispInvDtIVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyerPartVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyrDtlPartVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispCancelVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispNoPickUpVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrRcvInvWrkVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMyBiddingDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMyBiddingHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalInquiryINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalNVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingINVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
  
/**
 * alps DisposalMgtDBDAO <br> 
 * - alps-OperationManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author park myoung sin
 * @see DisposalMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class DisposalMgtDBDAO extends DBDAOSupport {
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * [EES_MNR_0157]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	 public String searchDisposalSeqData(String ofcCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String dispNo = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 	
		 try{
			 if(ofcCd != null){
				 param.put("ofc_cd", ofcCd);
				 velParam.put("ofc_cd", ofcCd);  
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalSeqDataRSQL(), param, velParam);
			  
			 if(dbRowset.next()){
				 dispNo = dbRowset.getString(1);  
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dispNo;
	 }
	 
	 /**
	  * [EES_MNR_0164]Disposal Request의 정보를 조회 합니다. <br>
	  *
	  * @param DisposalNVO disposalNVO
	  * @param SignOnUserAccount account 
	  * @return List<CustomMnrDispHdrVO> 
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDispHdrVO> searchDisposalListData(DisposalNVO disposalNVO,SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrDispHdrVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			Map<String, String> mapVO = disposalNVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO); 
			
			//CHM-201537246 - Disposal RQST 삭제 권한 조정 
			// Dsiposal Management에서는 SELCON의 경우 모든 OFFICE 대상 조회
			if(!"manage".equals(disposalNVO.getDispSearchType()) && !"SELCON".equals(account.getOfc_cd())){
				//account Ofc_cd
				param.put("self_ofc_cd",account.getOfc_cd());        	  	                    
				velParam.put("self_ofc_cd",account.getOfc_cd());   
			}
			
			if(disposalNVO.getDispNoList() != null && disposalNVO.getDispNoList().trim().length() > 0){
				 List<String> dispNos = new ArrayList(); 
				 String[] arrayDispNo =  disposalNVO.getDispNoList().split(",");
				 for(int i = 0; i < arrayDispNo.length; i ++){      
					 dispNos.add(arrayDispNo[i]); 	      
				 } 		
				 		
				 param.put("dispNos",dispNos);     	  	                    
				 velParam.put("dispNos",dispNos);   
			}
			
			if(disposalNVO.getInputStatusTypeCode() != null && disposalNVO.getInputStatusTypeCode().trim().length() > 0){
				 List<String> statusCodes = new ArrayList(); 
				 String[] arrayStatusCode =  disposalNVO.getInputStatusTypeCode().split(",");
				 for(int i = 0; i < arrayStatusCode.length; i ++){      
					 statusCodes.add(arrayStatusCode[i]); 	      
				 } 		
				 		
				 param.put("status_codes",statusCodes);     	  	                    
				 velParam.put("status_codes",statusCodes);   
			}

			if(disposalNVO.getEqNoList() != null && disposalNVO.getEqNoList().trim().length() > 0){
				 List<String> eqNos = new ArrayList(); 
				 String[] arrayEqNo =  disposalNVO.getEqNoList().split(",");
				 for(int i = 0; i < arrayEqNo.length; i ++){      
					 eqNos.add(arrayEqNo[i]); 	      
				 } 		
				 		
				 param.put("eqNos",eqNos);     	  	                    
				 velParam.put("eqNos",eqNos);   
			}

			if(disposalNVO.getInvNoList() != null && disposalNVO.getInvNoList().trim().length() > 0){
				 List<String> invNos = new ArrayList(); 
				 String[] arrayInvNo =  disposalNVO.getInvNoList().split(",");
				 for(int i = 0; i < arrayInvNo.length; i ++){      
					 invNos.add(arrayInvNo[i]); 	      
				 } 		
				 		
				 param.put("invNos",invNos);     	  	                    
				 velParam.put("invNos",invNos);   
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispHdrVO .class);  
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
	 * [EES_MNR_0200]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @param SignOnUserAccount account
	 * @return List<CustomMnrDispBuyrDtlPartVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDispBuyrDtlPartVO> searchDSPBuyerDTLPartData(CustomMnrDispHdrVO customMnrDispHdrVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrDispBuyrDtlPartVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{    
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
			
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO);
			
			/*
			 *  [CHM-201432978] MNR-Disposal-Disposal Request 및 SPP  EQ Bidding 시에 Bidding Time간의 로직 수정 요청 으로 인한 수정
			 * 쿼리에서 더이상 @[rqst_ofc_cd]를 사용하지 않음
			 *  VNDR_BID_TMS를 가져오는 function : GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELCON',A.VNDR_BID_TMS,@[rqst_ofc_cd])
			 * 에서 제1param은 From Office, 제3param은 To Office이지만 해당쿼리를 SELCON에서 검색할 경우엔
			 * 1param과 3param이 모두 'SELCON'가 되어 쿼리의 의도와 맞지않고 시차에 따라 Bidding 허용시간을 오버한 Bidd time으로
			 * 보이는 오류도 발생함.
			 * 이에 3param을 rqst_ofc_cd -> MNR_PARTNER.CTRL_OFC_CD로 변경함
			 * 2015.01.19 Chang Young Kim
			-------------------------------------------------
			param.put("rqst_ofc_cd",account.getOfc_cd());
			velParam.put("rqst_ofc_cd",account.getOfc_cd());
			-------------------------------------------------
			*/
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDSPBuyerDTLPartDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispBuyrDtlPartVO .class);  
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
	 * [EES_MNR_0200]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return List<CustomMnrDispDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<CustomMnrDispDtlVO> searchDisposalDTLListData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrDispDtlVO> list = null;    
		//query parameter	      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter	 
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{	   
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
			
			param.putAll(mapVO);     	 	            
			velParam.putAll(mapVO);   	
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalDTLListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispDtlVO .class);  
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
	 * [EES_MNR_0159]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return List<GeneralMailFormVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<EmailSendInfoVO> searchDisposalMailListData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<EmailSendInfoVO> list = null;    
		//query parameter	       
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter	 
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{ 	   
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
				
			param.putAll(mapVO);     	 	            
			velParam.putAll(mapVO);   	
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalMailListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EmailSendInfoVO .class);   
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
	 * [EES_MNR_0159]Disposal Mail Send 정보를 조회 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return List<GeneralMailFormVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<EmailSendInfoVO> searchDispContractMailListData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<EmailSendInfoVO> list = null;    
		//query parameter	       
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter	 
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{ 	   
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
				
			param.putAll(mapVO);     	 	            
			velParam.putAll(mapVO);   	
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDispContractMailListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EmailSendInfoVO .class);   
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
	 * [EES_MNR_0159]Disposal Management의 정보를 조회 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return List<GeneralMailFormVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<GeneralMailFormVO> searchDSPConfirmMailListData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<GeneralMailFormVO> list = null;    
		//query parameter	       
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter	 
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{ 	   
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
					
			param.putAll(mapVO);     	 	            
			velParam.putAll(mapVO);   	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDSPConfirmMailListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GeneralMailFormVO .class);   
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
	 * [EES_MNR_0200]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return List<CustomMnrDispBuyerPartVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDispBuyerPartVO> searchDisposalBuyerHeaderData(DisposalGRPVO disposalGRPVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrDispBuyerPartVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{   
			Map<String, String> mapVO = disposalGRPVO.getCustomMnrDispHdrVO().getColumnValues();
			
			param.putAll(mapVO);     	 	            
			velParam.putAll(mapVO);   	
			velParam.put("buyerNoOuterJoinFlg", disposalGRPVO.getBuyerNoOuterJoinFlg());
			 

			param.put("buyerGlobal", disposalGRPVO.getBuyerGlobal());
			param.put("buyerRHQ", disposalGRPVO.getBuyerRHQ());
			param.put("buyerLocal", disposalGRPVO.getBuyerLocal());	

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalBuyerHeaderDataRSQL(), param, velParam);
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
	 * [EES_MNR_0159]Disposal Request의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeDisposalHRDData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
						
			param.putAll(mapVO);   
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				   
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOremoveDisposalHRDDataDSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Update removeDisposalHRDData"); 
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
	 * [EES_MNR_0159]Disposal Request의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return int
	 * @exception DAOException
	 */ 
	public int removeDisposalDTLData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;	 	
			
		try { 
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOremoveDisposalDTLDataDSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update removeDisposalDTLData"); 
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
	 * [EES_MNR_0159]Disposal Request의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return int
	 * @exception DAOException
	 */	
	public int removeDisposalBuyerHRDData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
			
			param.putAll(mapVO);   
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");   
			
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOremoveDisposalBuyerHRDDataDSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update removeDisposalBuyerHRDData"); 
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
	 * [EES_MNR_0159]Disposal Management의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return int
	 * @exception DAOException
	 */	
	public int removeDisposalBuyerDTLData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
				
			param.putAll(mapVO);      
			velParam.putAll(mapVO);    
				
			SQLExecuter sqlExe = new SQLExecuter("");    
			
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOremoveDisposalBuyerDTLDataDSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update removeDisposalBuyerDTLData"); 
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
	 * [EES_MNR_0159]Disposal Request의 정보를 추가 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addDisposalHRDData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOaddDisposalHRDDataCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Insert addDisposalHRDData"); 
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
	 * [EES_MNR_0157]Disposal Request의 정보를 추가 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addContractDisposalBuyerDTLData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
				
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOaddContractDisposalBuyerDTLDataCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Insert addContractDisposalBuyerDTLData"); 
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
	 * [EES_MNR_0159]Disposal Request의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrDispDtlVO> customMnrDispDtlVOs
	 * @exception DAOException
	 */
	public void addDisposalDTLData(List<CustomMnrDispDtlVO> customMnrDispDtlVOs) throws DAOException,Exception {
		try {	
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrDispDtlVOs.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOaddDisposalDTLDataCSQL(), customMnrDispDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " addDisposalDTLData");
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
	 * [EES_MNR_0159]Disposal Request의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrDispBuyerPartVO> customMnrDispBuyerPartVOs
	 * @exception DAOException
	 */
	public void addDisposalBuyerHeaderData(List<CustomMnrDispBuyerPartVO> customMnrDispBuyerPartVOs) throws DAOException,Exception {
		try {	
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrDispBuyerPartVOs.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOaddDisposalBuyerHeaderDataCSQL(), customMnrDispBuyerPartVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " addDisposalBuyerHeaderData");
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
	 * [EES_MNR_0159]Disposal Management의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrDispBuyrDtlPartVO> customMnrDispBuyrDtlPartVOs
	 * @exception DAOException
	 */
	public void addDisposalBuyerDetailData(List<CustomMnrDispBuyrDtlPartVO> customMnrDispBuyrDtlPartVOs) throws DAOException,Exception {
		try {	
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrDispBuyrDtlPartVOs.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOaddDisposalBuyerDetailDataCSQL(), customMnrDispBuyrDtlPartVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " addDisposalBuyerDetailData");
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
	 * [EES_MNR_0159]Disposal Request의 정보를 수정 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyDisposalHDRSumData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
						
			param.putAll(mapVO);   
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				   
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOmodifyDisposalHDRSumDataUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Update modifyDisposalHDRSumData"); 
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
	 * [EES_MNR_0159]Disposal Request의 정보를 수정 합니다. <br>
	 *
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyDisposalHRDData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try {  
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
			
			param.putAll(mapVO);   
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOmodifyDisposalHRDDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Update modifyDisposalHRDData"); 
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
	 * [EES_MNR0160] Retrive. <br> 
	 *  
	 * @param DisposalSoldGRPVO disposalSoldGRPVO 
	 * @param SignOnUserAccount account 
	 * @return List<CustomMnrDispHdrVO> list 
	 * @exception EventException 
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDispHdrVO> searchDisposalSoldListData(DisposalSoldGRPVO disposalSoldGRPVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrDispHdrVO> customMnrDispHdrVOS = null;    
		//query parameter  	    
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			DisposalSoldINVO disposalSoldINVO = disposalSoldGRPVO.getDisposalSoldINVO();
			Map<String, String> mapVO = disposalSoldINVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO);   
			
			if(disposalSoldINVO.getDispNo() != null && disposalSoldINVO.getDispNo().trim().length() > 0){
				 String[] arrayDispNo =  disposalSoldINVO.getDispNo().split(",");
				 List<String> dispNos = new ArrayList(); 
				 for(int i = 0; i < arrayDispNo.length; i ++){      
					 dispNos.add(arrayDispNo[i]); 	      
				 } 		
				 param.put("disp_no",dispNos);     	  	                    
				 velParam.put("disp_no",dispNos);   
			}
			
			if(disposalSoldINVO.getEqNo() != null && disposalSoldINVO.getEqNo().trim().length() > 0){
				String[] arrayEqNo =  disposalSoldINVO.getEqNo().split(",");
				List<String> eqNos = new ArrayList(); 
				for(int i = 0; i < arrayEqNo.length; i ++){      
					eqNos.add(arrayEqNo[i]); 	      
				} 		
				param.put("eq_no",eqNos);     	  	                    
				velParam.put("eq_no",eqNos);   
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalSoldListDataRSQL(), param, velParam);
			customMnrDispHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispHdrVO .class);  
		}catch(SQLException se){  
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     
		return customMnrDispHdrVOS;    
	} 

	/**
	 * [EES_MNR_0160]Disposal Sold Creation의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @return List<CustomMnrDispDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDispDtlVO> searchDisposalSoldDetailData(DisposalSoldGRPVO disposalSoldGRPVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrDispDtlVO> list = null;    

		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{   
			Map<String, String> mapVO = disposalSoldGRPVO.getDisposalSoldINVO().getColumnValues();
			
			param.putAll(mapVO);     	 	            
			velParam.putAll(mapVO);   	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalSoldDetailDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispDtlVO .class);  
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
	 * [EES_MNR_0160]Disposal Sold Detail의 정보를 Buyer 별로 조회 합니다. <br>
	 *
	 * @param DisposalSoldGRPVO disposalSoldGRPVO
	 * @return List<CustomMnrDispDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<CustomMnrDispDtlVO> searchDisposalSoldDTLByBuyerData(DisposalSoldGRPVO disposalSoldGRPVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrDispDtlVO> list = null;    
		
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{   
			Map<String, String> mapVO = disposalSoldGRPVO.getDisposalSoldINVO().getColumnValues();
			 
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO);    	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalSoldDTLByBuyerDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispDtlVO .class);  
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
	 * [EES_MNR0251] Sold Cancellation 의 Detail Information 리스트를 조회합니다. <br> 
	 *  
	 * @param DisposalSoldINVO disposalSoldINVO 
	 * @return List<CustomMnrDispCancelVO> 
	 * @exception EventException 
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDispCancelVO> searchDisposalSoldCancelListData(DisposalSoldINVO disposalSoldINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrDispCancelVO> list = null;    
		//query parameter  	    
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{
			if(disposalSoldINVO != null){
				Map<String, String> mapVO = disposalSoldINVO.getColumnValues();
					
				param.putAll(mapVO);       	 	            
				velParam.putAll(mapVO);   
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalSoldCancelListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispCancelVO .class);  
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
	 * [EES_MNR_0251] Sold Cancellation의 정보를 Detail 저장 합니다.<br>
	 * 
	 * @param List<CustomMnrDispCancelVO> updModels
	 * @throws DAOException
	 */
	public void modfyDisposalSoldCancelDetail(List<CustomMnrDispCancelVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOmodfyDisposalSoldCancelDetailDataUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " modfyDisposalSoldCancelDetail");
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
	 * [EES_MNR_0251] Sold Cancellation의 정보를 저장 합니다.<br>
	 * 
	 * @param List<CustomMnrDispCancelVO> updModels
	 * @throws DAOException
	 */
	public void modifyDisposalSoldCancelForStatus(List<CustomMnrDispCancelVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOmodifyDisposalSoldCancelForStatusDataUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " modifyDisposalSoldCancelForStatus");
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
	 * [EES_MNR_0163]Disposal Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryINVO disposalInquiryINVO
	 * @return List<CustomMnrRcvInvWrkVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrRcvInvWrkVO> searchDisposalInquiryListData(DisposalInquiryINVO disposalInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrRcvInvWrkVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			Map<String, String> mapVO = disposalInquiryINVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO);   
			
			if(disposalInquiryINVO.getInvNo() != null && disposalInquiryINVO.getInvNo().trim().length() > 0){
				 List<String> invNos = new ArrayList(); 
				 String[] arrayInvNo =  disposalInquiryINVO.getInvNo().split(",");
				 for(int i = 0; i < arrayInvNo.length; i ++){      
					 invNos.add(arrayInvNo[i]); 	      
				 } 		
				 		
				 param.put("invNos",invNos);     	  	                    
				 velParam.put("invNos",invNos);   
			}

			if(disposalInquiryINVO.getDispNo() != null && disposalInquiryINVO.getDispNo().trim().length() > 0){
				 List<String> dispNos = new ArrayList(); 
				 String[] arrayDispNo =  disposalInquiryINVO.getDispNo().split(",");
				 for(int i = 0; i < arrayDispNo.length; i ++){      
					 dispNos.add(arrayDispNo[i]); 	      
				 } 		
				 		
				 param.put("dispNos",dispNos);     	  	                    
				 velParam.put("dispNos",dispNos);   
			}
			
			if(disposalInquiryINVO.getDispRlseNo() != null && disposalInquiryINVO.getDispRlseNo().trim().length() > 0){
				 List<String> dispRlseNos = new ArrayList(); 
				 String[] arrayDispRlseNo =  disposalInquiryINVO.getDispRlseNo().split(",");
				 for(int i = 0; i < arrayDispRlseNo.length; i ++){      
					 dispRlseNos.add(arrayDispRlseNo[i]); 	      
				 } 		
				 		
				 param.put("dispRlseNos",dispRlseNos);     	  	                    
				 velParam.put("dispRlseNos",dispRlseNos);   
			}

			if(disposalInquiryINVO.getEqNoList() != null && disposalInquiryINVO.getEqNoList().trim().length() > 0){
				 List<String> eqNos = new ArrayList(); 
				 String[] arrayEqNo =  disposalInquiryINVO.getEqNoList().split(",");
				 for(int i = 0; i < arrayEqNo.length; i ++){      
					 eqNos.add(arrayEqNo[i]); 	      
				 } 		
				 		
				 param.put("eqNos",eqNos);     	  	                    
				 velParam.put("eqNos",eqNos);   
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalInquiryListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRcvInvWrkVO .class);  
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
	 * [EES_MNR_0163]Disposal Invoice Detail의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryINVO disposalInquiryINVO
	 * @return List<CustomDispInvDtIVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomDispInvDtIVO> searchDisposalDetailInquiryListData(DisposalInquiryINVO disposalInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomDispInvDtIVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			Map<String, String> mapVO = disposalInquiryINVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO);   
			
			if(disposalInquiryINVO.getInvNoList() != null && disposalInquiryINVO.getInvNoList().trim().length() > 0){
				 List<String> invNos = new ArrayList(); 
				 String[] arrayInvNo =  disposalInquiryINVO.getInvNoList().split(",");
				 
				 for(int i = 0; i < arrayInvNo.length; i ++){      
					 invNos.add(arrayInvNo[i]); 	      
				 } 		
				 param.put("invNos",invNos);     	  	                    
				 velParam.put("invNos",invNos);   
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalDetailInquiryListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomDispInvDtIVO .class);  
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
	 * [EES_MNR_0163]Disposal Invoice Collection의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryINVO disposalInquiryINVO
	 * @return List<CustomBkgOtsDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomBkgOtsDtlVO> searchDisposalCollectionInquiryListData(DisposalInquiryINVO disposalInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomBkgOtsDtlVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			Map<String, String> mapVO = disposalInquiryINVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO);   

			if(disposalInquiryINVO.getInvNoList() != null && disposalInquiryINVO.getInvNoList().trim().length() > 0){
				 List<String> invNos = new ArrayList(); 
				 String[] arrayInvNo =  disposalInquiryINVO.getInvNoList().split(",");
				 
				 for(int i = 0; i < arrayInvNo.length; i ++){      
					 invNos.add(arrayInvNo[i]); 	      
				 } 		
				 param.put("invNos",invNos);     	  	                    
				 velParam.put("invNos",invNos);   
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalCollectionInquiryListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomBkgOtsDtlVO .class);  
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
	 * [EES_MNR_0160]Disposal Sold Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrDispDtlVO> customMnrDispDtlVOs
	 * @return int
	 * @exception DAOException
	 */
	public int removeDisposalSoldDetailData(List<CustomMnrDispDtlVO> customMnrDispDtlVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrDispDtlVOs.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOremoveDisposalSoldDetailDataDSQL(), customMnrDispDtlVOs, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " removeDisposalSoldDetailData");
				}		 		  
			}	 	
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
	 * [EES_MNR_0160]Disposal Sold Creation DTL의 정보를 건당 삭제 합니다. <br>
	 *	
	 * @param List<CustomMnrDispDtlVO> customMnrDispDtlVOs 
	 * @return int   
	 * @exception DAOException    
	 */ 
	public int removeDisposalSoldDetailbyDTLSeqData(List<CustomMnrDispDtlVO> customMnrDispDtlVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;	 
		
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrDispDtlVOs.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOremoveDisposalSoldDetailbyDTLSeqDataDSQL(), customMnrDispDtlVOs, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " removeDisposalSoldDetailbyDTLSeqData");
				}  		 		  
			}		 	
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
	 * [EES_MNR_0160]Disposal Sold Creation의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrDispDtlVO> customMnrDispDtlVOs
	 * @return int
	 * @exception DAOException
	 */
	public int addDisposalSoldDetailData(List<CustomMnrDispDtlVO> customMnrDispDtlVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;  
		 
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrDispDtlVOs.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOaddDisposalSoldDetailDataCSQL(), customMnrDispDtlVOs, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " addDisposalSoldDetailData");
				}		 		  
			}	 	
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		} catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [EES_MNR_0160]Disposal Sold Creation DTL의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrDispDtlVO> customMnrDispDtlVOs
	 * @return int
	 * @exception DAOException
	 */
	public int modfyDisposalSoldDetailData(List<CustomMnrDispDtlVO> customMnrDispDtlVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");	
			int modCnt[] = null; 
			if(customMnrDispDtlVOs.size() > 0){    
				modCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOmodfyDisposalSoldDetailDataUSQL(), customMnrDispDtlVOs, param, velParam);
				for(int i = 0; i < modCnt.length; i++){     
					if(modCnt[i]== Statement.EXECUTE_FAILED) 
						throw new DAOException("Fail to update No"+ i + " modfyDisposalSoldDetailData");
				} 			 		  
			}	 	
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
	  * [EES_MNR_0160]Disposal Sold Creation의 정보를 수정 합니다. <br>
	  *
	  * @param String dispNo
	  * @exception DAOException
	  */
	 public void modifyDisposalSoldListForStatusData(String dispNo) throws DAOException {
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 int result = 0;
		 
		 try{
			 if(!dispNo.equals("") && dispNo != null){
				 param.put("disp_no", dispNo); 
				 velParam.put("disp_no", dispNo);     

				 SQLExecuter sqlExe = new SQLExecuter("");  
				 result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOmodifyDisposalSoldListForStatusDataUSQL(), param, velParam);
				 
				 if(result == Statement.EXECUTE_FAILED) {
					 throw new DAOException("Fail to Update modifyDisposalSoldListForStatusData"); 
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
	 * [EES_MNR_0160] Disposal Sold Creation 의 Release No 를 조회 합니다. <br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	 public String searchDispRlseNoData(String ofcCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String dispRlseNo = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 	
		 try{
			 if(ofcCd != null){
				 param.put("ofc_cd", ofcCd);
				 velParam.put("ofc_cd", ofcCd);  
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDispRlseNoDataRSQL(), param, velParam);
			  
			 if(dbRowset.next()){
				 dispRlseNo = dbRowset.getString(1);  
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dispRlseNo;
	 }
	
	 
	 /**
	 * [EES_MNR_0157,0159]Disposal Comfirm 시 DISP_DTL에 추가 Sum작업을 실행 <br>
	 *  
	 * @param CustomMnrDispHdrVO customMnrDispHdrVO
	 * @return int
	 * @exception DAOException
	 */ 
	public int modifyDisposalDetailAmountData(CustomMnrDispHdrVO customMnrDispHdrVO) throws DAOException,Exception {
		//query parameter   
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		 	
		try {  
			Map<String, String> mapVO = customMnrDispHdrVO.getColumnValues();
						
			param.putAll(mapVO);         
			velParam.putAll(mapVO);       
			 
			SQLExecuter sqlExe = new SQLExecuter("");  
			 	   
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOmodifyDisposalDetailAmountDataUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Update modifyDisposalDetailAmountData"); 
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
	 * [EES_MNR_0160] Sold Creation 조회시 buyer 정보를 조회 합니다. <br>
	 *
	 * @param String dispNo
	 * @param String dispDtlSeq
	 * @return List<CustomMnrDispBuyrDtlPartVO>
	 * @exception DAOException
	 */ 
	@SuppressWarnings("unchecked")
	public List<CustomMnrDispBuyrDtlPartVO> searchDispBuyrDtlPartData(String dispNo, String dispDtlSeq) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrDispBuyrDtlPartVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{        
			 param.put("disp_no", dispNo);
			 velParam.put("disp_no", dispNo);  
			 param.put("disp_dtl_seq", dispDtlSeq);
			 velParam.put("disp_dtl_seq", dispDtlSeq);  
                          
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDispBuyrDtlPartDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispBuyrDtlPartVO .class);      
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
	 * [EES_MNR_0160] Disposal Sold Creation 조회시 Buyer 정보를 추가 합니다. <br>
	 *
	 * @param CustomMnrDispBuyrDtlPartVO customMnrDispBuyrDtlPartVO
	 * @return int
	 * @exception DAOException
	 */
	public int addDispBuyrDtlPartData(CustomMnrDispBuyrDtlPartVO customMnrDispBuyrDtlPartVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrDispBuyrDtlPartVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOaddDispBuyrDtlPartDataCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Insert addDispBuyrDtlPartData"); 
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
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 삭제 합니다. <br>
	 *  
	 * @param CustomMnrDispDtlVO customMnrDispDtlVO
	 * @return int
	 * @exception DAOException
	 */ 
	public int modifyDisposalInvoiceLinkClearData(CustomMnrDispDtlVO customMnrDispDtlVO) throws DAOException,Exception {
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
			 	   
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOmodifyDisposalInvoiceLinkClearDataUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Update DisposalMgtDBDAOmodifyDisposalInvoiceLinkClearDataUSQL"); 
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
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 수정 합니다. 
	 *
	 * @param List<CustomMnrDispDtlVO> CustomMnrDispDtlVOs
	 * @exception DAOException
	 */
	public void modifyDisposalInvoiceLinkData(List<CustomMnrDispDtlVO> CustomMnrDispDtlVOs) throws DAOException,Exception {
		try {	
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			int insCnt[] = null;
			if(CustomMnrDispDtlVOs.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOmodifyDisposalInvoiceLinkDataUSQL(), CustomMnrDispDtlVOs, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " modifyDisposalInvoiceLinkData");
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
	 * [EES_MNR_S308] 파트너정보를 조회 합니다.<br>
	 * 
	 * 
	 * @param String sp_ptal_id
	 * @return MnrPartnerVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public DisposalInquiryINVO searchPartnerData(String sp_ptal_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<DisposalInquiryINVO> list = null;
		DisposalInquiryINVO disposalInquiryINVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			param.put("sp_ptal_id",sp_ptal_id);
			velParam.put("sp_ptal_id",sp_ptal_id);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchMnrPartnerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DisposalInquiryINVO .class);
			 if(list.size() > 0){
				 disposalInquiryINVO = list.get(0);
			 }
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return disposalInquiryINVO;
	}
	 
	 /**
	  * [EES_MNR_S304] My Bidding List 헤더 목록을 조회합니다.<br> 
	  *
	  * @param MyBiddingGRPVO myBiddingGRPVO
	  * @return List<CustomMyBiddingHdrVO>
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<CustomMyBiddingHdrVO> searchMyBiddingHdrListData(MyBiddingGRPVO myBiddingGRPVO) throws DAOException {
		DBRowSet dbRowset = null;	 	 
		List<CustomMyBiddingHdrVO> listCustomMyBiddingHdrVOs = null;
		 	
		//query parameter	
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 	
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			MyBiddingINVO myBiddingINVO = myBiddingGRPVO.getMyBiddingINVO();
			Map<String, String> mapVO = myBiddingINVO.getColumnValues();

			param.putAll(mapVO);                       
			velParam.putAll(mapVO);           

			if(myBiddingINVO.getDispNo() != null && myBiddingINVO.getDispNo().trim().length() > 0){
				String[] arrayDispNo =  myBiddingINVO.getDispNo().split(",");
				List<String> dispNos = new ArrayList(); 
				for(int i = 0; i < arrayDispNo.length; i ++){      
					dispNos.add(arrayDispNo[i]); 	      
				} 		
				param.put("disp_no",dispNos);     	  	                    
				velParam.put("disp_no",dispNos);   
			}

			if(myBiddingINVO.getEqNo() != null && myBiddingINVO.getEqNo().trim().length() > 0){
				String[] arrayEqNo =  myBiddingINVO.getEqNo().split(",");
				List<String> eqNos = new ArrayList(); 
				for(int i = 0; i < arrayEqNo.length; i ++){      
					eqNos.add(arrayEqNo[i]); 	      
				} 		
				param.put("eq_no",eqNos);     	  	                    
				velParam.put("eq_no",eqNos);   
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchMyBiddingHdrListDataRSQL(), param, velParam);
			listCustomMyBiddingHdrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMyBiddingHdrVO .class); 

		}catch(SQLException se){  
			log.error(se.getMessage(),se);  
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
		return listCustomMyBiddingHdrVOs; 
	}

	/**
	 * [EES_MNR_S304] My Bidding List의 디테일 정보를 조회 합니다. <br>
	 *
	 * @param MyBiddingGRPVO myBiddingGRPVO
	 * @return List<CustomMyBiddingDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 
	public List<CustomMyBiddingDtlVO> searchMyBiddingDtlListData(MyBiddingGRPVO myBiddingGRPVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMyBiddingDtlVO> list = null;    
		//query parameter	      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter	 
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{	   
			Map<String, String> mapVO = myBiddingGRPVO.getMyBiddingINVO().getColumnValues();
			
			param.putAll(mapVO);     	 	            
			velParam.putAll(mapVO);   	
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchMyBiddingDtlListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMyBiddingDtlVO .class);  
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
	 * [EES_MNR_S304] 선택된 Bidding No의 Bidding Status을 조회합니다.<br>
	 * 
	 * @param MyBiddingINVO myBiddingINVO
	 * @return List<CustomMyBiddingHdrVO>
	 * @exception EventException
	 */	 
	@SuppressWarnings("unchecked")
	public List<CustomMyBiddingHdrVO> searchMyBiddingStatus(MyBiddingINVO myBiddingINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMyBiddingHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(myBiddingINVO != null){
				Map<String, String> mapVO = myBiddingINVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchMyBiddingStatusRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMyBiddingHdrVO.class);
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
	  * [EES_MNR_S304] My Bidding List 디테일 정보의 저장상태를 체크조회한다.<br>
	  *
	  * @param String dispNo
	  * @param String dispDtlSeq
	  * @param String mnrPrnrCntCd
	  * @param String mnrPrnrSeq
	  * @return int
	  * @exception DAOException
	  */
	 public int checkMyBiddingDtlListUIStatusData(String dispNo, String dispDtlSeq, String mnrPrnrCntCd, String mnrPrnrSeq) throws DAOException {
		 DBRowSet dbRowset = null;
		 int cnt = 0;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(dispNo != null && dispDtlSeq != null){
				 param.put("disp_no", dispNo);
				 param.put("disp_dtl_seq", dispDtlSeq);
				 param.put("mnr_prnr_cnt_cd", mnrPrnrCntCd);
				 param.put("mnr_prnr_seq", mnrPrnrSeq);
				 velParam.put("disp_no", dispNo); 
				 velParam.put("disp_dtl_seq", dispDtlSeq); 
				 velParam.put("mnr_prnr_cnt_cd", mnrPrnrCntCd); 
				 velParam.put("mnr_prnr_seq", mnrPrnrSeq); 
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOcheckMyBiddingDtlListUIStatusDataRSQL(), param, velParam);
			 
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
	 * [EES_MNR_0S304]My Bidding List 의 디테일정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMyBiddingDtlVO> customMyBiddingDtlVOs
	 * @param String spPtalId
	 * @return int
	 * @exception DAOException
	 */
	public int addMyBiddingDtlListData(List<CustomMyBiddingDtlVO> customMyBiddingDtlVOs, String spPtalId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		param.put("sp_ptal_id", spPtalId);
		velParam.put("sp_ptal_id", spPtalId); 
		int result = 0;  
		 
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMyBiddingDtlVOs.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOaddMyBiddingDtlListDataCSQL(), customMyBiddingDtlVOs, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " addMyBiddingDtlListData");
				}		 		  
			}	 	
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		} catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [EES_MNR_0S304]My Bidding List 의 디테일정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMyBiddingDtlVO> customMyBiddingDtlVOs
	 * @return int
	 * @exception DAOException
	 */
	public int modifyMyBiddingDtlListData(List<CustomMyBiddingDtlVO> customMyBiddingDtlVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;  
		 
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMyBiddingDtlVOs.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOmodifyMyBiddingDtlListDataUSQL(), customMyBiddingDtlVOs, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " modifyMyBiddingDtlListData");
				}		 		  
			}	 	
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		} catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	/**
	 * [EES_MNR_0S304]My Bidding List 의 디테일정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMyBiddingDtlVO> customMyBiddingDtlVOs
	 * @return int
	 * @exception DAOException
	 */
	public int removeMyBiddingDtlListData(List<CustomMyBiddingDtlVO> customMyBiddingDtlVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;  
		
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMyBiddingDtlVOs.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DisposalMgtDBDAOremoveMyBiddingDtlListDataDSQL(), customMyBiddingDtlVOs, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " removeMyBiddingDtlListData");
				}		 		  
			}	 	
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		} catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	 

	/**
	 * [EES_MNR_S304] My Bidding List의 Local_Time 정보를 조회 합니다. <br>
	 *
	 * * @param String sp_ptal_id
	 * @return MyBiddingINVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked") 	
	public MyBiddingINVO searchMyBiddingLocalTimeListData(String sp_ptal_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<MyBiddingINVO> list = null;
		MyBiddingINVO myBiddingINVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("sp_ptal_id",sp_ptal_id);
			velParam.put("sp_ptal_id",sp_ptal_id);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchMyBiddingLocalTimeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MyBiddingINVO .class);
			if(list.size() > 0){
				 myBiddingINVO = list.get(0);
			}
			 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return myBiddingINVO;
	}   
	
	/**
	 * [EES_MNR_0161]Cancelled Disposal Invoice history 정보를 저장한다.
	 * @param receivableINVInquiryINVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDisposalHRDCancelledData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOaddDisposalHRDCancelledDataCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Insert addDisposalHRDCancelledData"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0161]Cancelled Disposal Invoice history 정보를 저장한다. 
	 * @param receivableINVInquiryINVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDisposalDTLCancelledData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new DisposalMgtDBDAOaddDisposalDTLCancelledDataCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Insert addDisposalDTLCancelledData"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [EES_MNR_0256]Disposal Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryINVO disposalInquiryINVO
	 * @return List<CustomMnrRcvInvWrkVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrRcvInvWrkVO> searchDisposalCancelledInquiryListData(DisposalInquiryINVO disposalInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrRcvInvWrkVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			Map<String, String> mapVO = disposalInquiryINVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO);   
			
			if(disposalInquiryINVO.getInvNo() != null && disposalInquiryINVO.getInvNo().trim().length() > 0){
				 List<String> invNos = new ArrayList<String>(); 
				 String[] arrayInvNo =  disposalInquiryINVO.getInvNo().split(",");
				 for(int i = 0; i < arrayInvNo.length; i ++){      
					 invNos.add(arrayInvNo[i]); 	      
				 } 		
				 		
				 param.put("invNos",invNos);     	  	                    
				 velParam.put("invNos",invNos);   
			}

			if(disposalInquiryINVO.getDispNo() != null && disposalInquiryINVO.getDispNo().trim().length() > 0){
				 List<String> dispNos = new ArrayList<String>(); 
				 String[] arrayDispNo =  disposalInquiryINVO.getDispNo().split(",");
				 for(int i = 0; i < arrayDispNo.length; i ++){      
					 dispNos.add(arrayDispNo[i]); 	      
				 } 		
				 		
				 param.put("dispNos",dispNos);     	  	                    
				 velParam.put("dispNos",dispNos);   
			}

			if(disposalInquiryINVO.getEqNoList() != null && disposalInquiryINVO.getEqNoList().trim().length() > 0){
				 List<String> eqNos = new ArrayList<String>(); 
				 String[] arrayEqNo =  disposalInquiryINVO.getEqNoList().split(",");
				 for(int i = 0; i < arrayEqNo.length; i ++){      
					 eqNos.add(arrayEqNo[i]); 	      
				 } 		
				 		
				 param.put("eqNos",eqNos);     	  	                    
				 velParam.put("eqNos",eqNos);   
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalCancelledInquiryListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRcvInvWrkVO .class);  
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
	 * [EES_MNR_0256]Disposal Cancelled Invoice Detail의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalInquiryINVO disposalInquiryINVO
	 * @return List<CustomDispInvDtIVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomDispInvDtIVO> searchDisposalDetailCancelledInquiryListData(DisposalInquiryINVO disposalInquiryINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomDispInvDtIVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			Map<String, String> mapVO = disposalInquiryINVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO);   
			
			if(disposalInquiryINVO.getInvNoList() != null && disposalInquiryINVO.getInvNoList().trim().length() > 0){
				 List<String> invNos = new ArrayList<String>(); 
				 String[] arrayInvNo =  disposalInquiryINVO.getInvNoList().split(",");
				 
				 for(int i = 0; i < arrayInvNo.length; i ++){      
					 invNos.add(arrayInvNo[i]); 	      
				 } 		
				 param.put("invNos",invNos);     	  	                    
				 velParam.put("invNos",invNos);   
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalDetailCancelledInquiryListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomDispInvDtIVO .class);  
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
	 * [EES_MNR_0261] Disposal Inquiry 화면에서 not pick-up 된 장비 pop up list를 조회합니다. <br>
	 *
	 * @param DisposalNVO disposalNVO
	 * @return List<CustomMnrDispNoPickUpVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDispNoPickUpVO> searchDisposalNoPickUpListData(DisposalNVO disposalNVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrDispNoPickUpVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			Map<String, String> mapVO = disposalNVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO);   
			
			if(disposalNVO.getDispNoList() != null && disposalNVO.getDispNoList().trim().length() > 0){
				 List<String> dispNos = new ArrayList<String>(); 
				 String[] arrayDispNo =  disposalNVO.getDispNoList().split(",");
				 for(int i = 0; i < arrayDispNo.length; i ++){      
					 dispNos.add(arrayDispNo[i]); 	      
				 } 		
				 		
				 param.put("dispNos",dispNos);     	  	                    
				 velParam.put("dispNos",dispNos);   
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDisposalNoPickUpListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispNoPickUpVO .class);  
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
	  * [EES_MNR_0159]Disposal No 를 체크 합니다. <br>
	  *
	  * @param DisposalNVO disposalNVO
	  * @return List<CustomMnrDispHdrVO> 
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDispHdrVO> searchVerifyDisposalNoData(DisposalNVO disposalNVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrDispHdrVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			Map<String, String> mapVO = disposalNVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO); 
			
			if(disposalNVO.getDispNoList() != null && disposalNVO.getDispNoList().trim().length() > 0){
				 List<String> dispNos = new ArrayList(); 
				 String[] arrayDispNo =  disposalNVO.getDispNoList().split(",");
				 for(int i = 0; i < arrayDispNo.length; i ++){      
					 dispNos.add(arrayDispNo[i]); 	      
				 } 		
				 		
				 param.put("dispNos",dispNos);     	  	                    
				 velParam.put("dispNos",dispNos);   
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchVerifyDisposalNoDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispHdrVO .class);  
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
	  * [EES_MNR_0156]Disposal No 중복체크를 합니다 <br>
	  *
	  * @param DisposalNVO disposalNVO
	  * @return List<CustomMnrDispHdrVO> 
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDispHdrVO> searchDisposalNoDubChkData(DisposalNVO disposalNVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrDispHdrVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{   
			Map<String, String> mapVO = disposalNVO.getColumnValues();
					
			param.putAll(mapVO);       	 	            
			velParam.putAll(mapVO); 

			if(disposalNVO.getEqNoList() != null && disposalNVO.getEqNoList().trim().length() > 0){
				 List<String> eqNos = new ArrayList(); 
				 String[] arrayEqNo =  disposalNVO.getEqNoList().split(",");
				 for(int i = 0; i < arrayEqNo.length; i ++){      
					 eqNos.add(arrayEqNo[i]); 	      
				 } 		
				 		
				 param.put("eqNos",eqNos);     	  	                    
				 velParam.put("eqNos",eqNos);   
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DisposalMgtDBDAOsearchDispNoDubChkDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDispHdrVO .class);  
		}catch(SQLException se){  
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}     
		return list;    
	}
}
