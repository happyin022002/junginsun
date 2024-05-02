/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairMgtDBDAO.java
*@FileTitle : Repair DAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.10.28 김상수 [CHM-201114133-01] ALPS MNR->REPAIR Estimate 에서 EDI Upload 시 Man-Hour 계산로직 수정
* 2013.05.09 조경완 [CHM-201324479-01][MNR] Repair Estimate 처리시 이미 처리된 Data를 재 Save, Request, Approval 할 경우 발생하는 SQL Error 처리
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration.GeneralCodeSearchMgtDBDAOsearchCostCodeDataRSQL;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCostCodeVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrThumbnailFileAtchVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomBzcAmtVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomDocHeaderVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomEQWorkOrderHistoryListVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomESTWOMainINFOVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomESTWOMainSMRVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstVDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomRepairCollectionVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.DocINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EQWorkOrderHistoryListINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.ESTWOMainGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.ESTWOMainINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.GeneralWOINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.MnrOrderInfoBySparePartVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairResultGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairResultINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairResultListVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.SparePartWOINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryListINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/** 
 * Repair 관련 디비 처리를 합니다.
 * @author park myoung sin
 * @see RepairMgtBCImpl 참조
 * @since J2EE 1.4
 */			
public class RepairMgtDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L; 
	
	/**
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 조회 합니다. <br>
	 * Cost Code을 조회한다.<br>
	 * 
	 * @param CostCodeINVO costCodeINVO
	 * @return List<CustomCostCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomCostCodeVO> searchCostCodeData(CostCodeINVO costCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomCostCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = costCodeINVO.getColumnValues();
		
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchCostCodeDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomCostCodeVO.class);
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
	  * [EES_MNR_0015] 견적서에서 해당 Agreement를 사용하는 견적서 리스트를 조회합니다.. <br>
	  * @param AgreementGRPVO agreementGRPVO
	  * @return List<CustomMnrRprRqstHdrVO>
	  * @exception DAOException	
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprRqstHdrVO> searchUsedEstimateByAGMTData(AgreementGRPVO agreementGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOs = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter  
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{				  
			 String agmtOfcCtyCd = agreementGRPVO.getAgreementINVO().getAgmtOfcCtyCd();
			 param.put("agmt_ofc_cty_cd", agmtOfcCtyCd);
			 velParam.put("agmt_ofc_cty_cd", agmtOfcCtyCd);	 
			 
			 String agmtSeq = agreementGRPVO.getAgreementINVO().getAgmtSeq();
			 param.put("agmt_seq", agmtSeq);	
			 velParam.put("agmt_seq", agmtSeq);	 
			 
			 String agmtVerNo = agreementGRPVO.getAgreementINVO().getAgmtVerNo();
			 param.put("agmt_ver_no", agmtVerNo);		
			 velParam.put("agmt_ver_no", agmtVerNo);	 
			 	
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchUsedEstimateByAGMTDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class);
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrRprRqstHdrVOs;
	 }
	 
	 /**
	  * [EES_MNR_0015] 버젼업 하기전 미승인된 견적서 리스트를 조회합니다.. <br>
	  * @param AgreementGRPVO agreementGRPVO
	  * @return List<CustomMnrRprRqstHdrVO>
	  * @exception DAOException	
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprRqstHdrVO> searchNotApprovalESTByAGMTData(AgreementGRPVO agreementGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOs = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter  
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{				  
			 String agmtOfcCtyCd = agreementGRPVO.getAgreementINVO().getAgmtOfcCtyCd();
			 param.put("agmt_ofc_cty_cd", agmtOfcCtyCd);
			 velParam.put("agmt_ofc_cty_cd", agmtOfcCtyCd);	 
			 
			 String agmtSeq = agreementGRPVO.getAgreementINVO().getAgmtSeq();
			 param.put("agmt_seq", agmtSeq);				
			 velParam.put("agmt_seq", agmtSeq);		 
			 
			 String agmtVerNo = agreementGRPVO.getAgreementINVO().getAgmtVerNo();
			 param.put("agmt_ver_no", agmtVerNo);  	 			
			 velParam.put("agmt_ver_no", agmtVerNo); 		 
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchNotApprovalESTByAGMTDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class);
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrRprRqstHdrVOs;
	 }
	 
	/**
	 * [EES_MNR_0019] Estimate Multy Request를 DTL를 저장합니다. <br>
	 *
	 * @param List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS
	 * @exception DAOException 
	 */ 
	public void addESTRequestDTLListData(List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS) throws DAOException,Exception {
		try {   
			SQLExecuter sqlExe = new SQLExecuter("");
			int intCnt[] = null;  
			if(customMnrRprRqstHdrVOS.size() > 0){ 
				intCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOaddESTRequestDTLListDataCSQL(), customMnrRprRqstHdrVOS ,null);
				for(int i = 0; i < intCnt.length; i++){ 
					if(intCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addESTRequestDTLListData No"+ i + " SQL");
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
	 * [EES_MNR_0023]  Repair Estimate Auditing의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int manageEstimateAuditItLaterData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;	 
		
		try { 
			Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);	   
					
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOmanageEstimateAuditItLaterDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update manageEstimateAuditItLaterData"); 
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
	 * [EES_MNR_0019] Estimate Multy Request를 HDR를 저장합니다. <br>
	 *
	 * @param List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS
	 * @exception DAOException 
	 */ 
	public void addESTRequestHDRListData(List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS) throws DAOException,Exception {
		try {   
			SQLExecuter sqlExe = new SQLExecuter("");
			int intCnt[] = null;  
			if(customMnrRprRqstHdrVOS.size() > 0){ 
				intCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOaddESTRequestHDRListDataCSQL(), customMnrRprRqstHdrVOS ,null);
				for(int i = 0; i < intCnt.length; i++){ 
					if(intCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addESTRequestHDRListData No"+ i + " SQL");
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
	  * [EES_MNR_0192]Repair Group Auditing의 정보를 조회 합니다. <br>
	  *
	  * @param EstimateINVO estimateINVO
	  * @return List<CustomMnrRprRqstDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprRqstDtlVO> searchEDIIFEstimateDTLData(EstimateINVO estimateINVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS = null;
		 	
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = estimateINVO.getColumnValues();
			 
			 param.putAll(mapVO); 	                      
			 velParam.putAll(mapVO); 	          
			  	
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchEDIIFEstimateDTLDataRSQL(), param, velParam);
			 customMnrRprRqstDtlVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstDtlVO .class); 
		 }catch(SQLException se){	  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }   
		 return customMnrRprRqstDtlVOS; 
	 }
	 
	 /**
	  * [EES_MNR_0192] EDI Estimate 의 정보를 조회 합니다. <br>
	  *	
	  * @param EstimateINVO estimateINVO
	  * @return CustomMnrRprRqstHdrVO
	  * @exception DAOException
	  */ 	
	 @SuppressWarnings("unchecked")
	 public CustomMnrRprRqstHdrVO searchEDIEstimateHRDData(EstimateINVO estimateINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = estimateINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           
			 	
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchEDIEstimateHRDDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class);  
			 
			 if(customMnrRprRqstHdrVOS.size() > 0){
				 customMnrRprRqstHdrVO = customMnrRprRqstHdrVOS.get(0);
			 }
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrRprRqstHdrVO; 
	 }
	 
	 /**
	  * [EES_MNR_0019] Estimate Creation의 견적서 번호를 생성합니다. <br>
	  *  
	  * @param String venderSeq 
	  * @return String
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public String searchRepairRqstRefNoData(String venderSeq) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;
		 CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = new CustomMnrRprRqstHdrVO();
		 
		 //query parameter 
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{  
			 param.put("rqst_ref_no",venderSeq);           	  	                    
			 velParam.put("rqst_ref_no",venderSeq);         
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchRepairRqstRefNoDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class);
			 if(customMnrRprRqstHdrVOS.size() > 0){
				 customMnrRprRqstHdrVO = customMnrRprRqstHdrVOS.get(0); 
			 }   
			 
		 }catch(SQLException se){    
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }   
		 return customMnrRprRqstHdrVO.getRqstRefNo(); 
	 }
	 
	/**
	 * [EES_MNR_0028] Repair Cancellation and Deletion의 정보를 조회 합니다. <br>
	 * EES_MNR_S027, EES_MNR_0027, EES_MNR_S028 만사용
	 * 2015.03.03 Repair Inquiry, Repair Cancelation & Deletion에서 사용하던부분을
	 * Repair Inquiry(EES_MNR_0028) 는 별도 적용
	 *
	 * @param RepairCollectionINVO repairCollectionINVO
	 * @param String currSystem 
	 * @return List<CustomRepairCollectionVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")  
	public List<CustomRepairCollectionVO> searchRepairInquiryListData(RepairCollectionINVO repairCollectionINVO,String currSystem) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CustomRepairCollectionVO> customRepairCollectionVOS = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			Map<String, String> mapVO = repairCollectionINVO.getColumnValues();
			
			param.putAll(mapVO);                      
			velParam.putAll(mapVO); 
				
			if (repairCollectionINVO.getRqstEqNo() != null && repairCollectionINVO.getRqstEqNo().trim().length() > 0) {
				 List<String> eqNos = new ArrayList<String>(); 
				 String[] arrayEqNo =  repairCollectionINVO.getRqstEqNo().split(",");
				 for(int i = 0; i < arrayEqNo.length; i ++){      
					 eqNos.add(arrayEqNo[i]);	      
				 } 			
				 		
				 param.put("eqNos",eqNos);  	  	                    
				 velParam.put("eqNos",eqNos); 
			}
			
			if (repairCollectionINVO.getWoNo() != null && repairCollectionINVO.getWoNo().trim().length() > 0) {
				 List<String> woNos = new ArrayList<String>();
				 String[] arrayWoNo =  repairCollectionINVO.getWoNo().split(",");
				 for(int i = 0; i < arrayWoNo.length; i ++){      
					 woNos.add(arrayWoNo[i]);	      
				 } 		
				 		
				 param.put("woNos",woNos);  	  	                    
				 velParam.put("woNos",woNos);  
			}	
			
			if (repairCollectionINVO.getRqstRefNo() != null && repairCollectionINVO.getRqstRefNo().trim().length() > 0) {
				 List<String> rqstRefNos = new ArrayList<String>(); 
				 String[] arrRqstRefNos =  repairCollectionINVO.getRqstRefNo().split(",");
				 for(int i = 0; i < arrRqstRefNos.length; i ++){      
					 rqstRefNos.add(arrRqstRefNos[i]);	      
				 } 		
				 			
				 param.put("rqstRefNos",rqstRefNos);  	  	                    
				 velParam.put("rqstRefNos",rqstRefNos);  
			}
			
			//cost_ofc_cd CostOfcCd
			if (repairCollectionINVO.getCostOfcCd() != null && repairCollectionINVO.getCostOfcCd().trim().length() > 0) {
				 List<String> costOfcCds = new ArrayList<String>(); 
				 String[] arrCostOfcCds =  repairCollectionINVO.getCostOfcCd().split(",");
				 for(int i = 0; i < arrCostOfcCds.length; i ++){      
					 costOfcCds.add(arrCostOfcCds[i]);	      
				 } 		
				 			
				 param.put("costOfcCds",costOfcCds);  	  	                    
				 velParam.put("costOfcCds",costOfcCds);  
			}

			param.put("curr_system",currSystem);        	  	                    
			velParam.put("curr_system",currSystem);      
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchRepairInquiryListDataRSQL(), param, velParam);
			customRepairCollectionVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomRepairCollectionVO .class);
		}catch(SQLException se){  
			log.error(se.getMessage(),se);  
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
		return customRepairCollectionVOS;
	}
	 
	/**
	 * [EES_MNR_0028] Repair Cancellation and Deletion의 정보를 조회 합니다. <br>
	 * EES_MNR_0028 만사용
	 * 2015.03.03 Repair Inquiry, Repair Cancelation & Deletion에서 사용하던부분을
	 * Repair Inquiry(EES_MNR_0028)만 별도 적용
	 * 
	 * @param RepairCollectionINVO repairCollectionINVO
	 * @param String currSystem 
	 * @return List<CustomRepairCollectionVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")  
	public List<CustomRepairCollectionVO> searchRepairInquiryListDataForHJS(RepairCollectionINVO repairCollectionINVO,String currSystem) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CustomRepairCollectionVO> customRepairCollectionVOS = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			Map<String, String> mapVO = repairCollectionINVO.getColumnValues();
			
			param.putAll(mapVO);                      
			velParam.putAll(mapVO); 
				
			if (repairCollectionINVO.getRqstEqNo() != null && repairCollectionINVO.getRqstEqNo().trim().length() > 0) {
				 List<String> eqNos = new ArrayList<String>(); 
				 String[] arrayEqNo =  repairCollectionINVO.getRqstEqNo().split(",");
				 for(int i = 0; i < arrayEqNo.length; i ++){      
					 eqNos.add(arrayEqNo[i]);	      
				 } 			
				 		
				 param.put("eqNos",eqNos);  	  	                    
				 velParam.put("eqNos",eqNos); 
			}
			
			if (repairCollectionINVO.getWoNo() != null && repairCollectionINVO.getWoNo().trim().length() > 0) {
				 List<String> woNos = new ArrayList<String>();
				 String[] arrayWoNo =  repairCollectionINVO.getWoNo().split(",");
				 for(int i = 0; i < arrayWoNo.length; i ++){      
					 woNos.add(arrayWoNo[i]);	      
				 } 		
				 		
				 param.put("woNos",woNos);  	  	                    
				 velParam.put("woNos",woNos);  
			}	
			
			if (repairCollectionINVO.getRqstRefNo() != null && repairCollectionINVO.getRqstRefNo().trim().length() > 0) {
				 List<String> rqstRefNos = new ArrayList<String>(); 
				 String[] arrRqstRefNos =  repairCollectionINVO.getRqstRefNo().split(",");
				 for(int i = 0; i < arrRqstRefNos.length; i ++){      
					 rqstRefNos.add(arrRqstRefNos[i]);	      
				 } 		
				 			
				 param.put("rqstRefNos",rqstRefNos);  	  	                    
				 velParam.put("rqstRefNos",rqstRefNos);  
			}
			
			//cost_ofc_cd CostOfcCd
			if (repairCollectionINVO.getCostOfcCd() != null && repairCollectionINVO.getCostOfcCd().trim().length() > 0) {
				 List<String> costOfcCds = new ArrayList<String>(); 
				 String[] arrCostOfcCds =  repairCollectionINVO.getCostOfcCd().split(",");
				 for(int i = 0; i < arrCostOfcCds.length; i ++){      
					 costOfcCds.add(arrCostOfcCds[i]);	      
				 } 		
				 			
				 param.put("costOfcCds",costOfcCds);  	  	                    
				 velParam.put("costOfcCds",costOfcCds);  
			}

			param.put("curr_system",currSystem);        	  	                    
			velParam.put("curr_system",currSystem);      
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchRepairInquiryListDataForHJSRSQL(), param, velParam);
			customRepairCollectionVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomRepairCollectionVO .class);
		}catch(SQLException se){  
			log.error(se.getMessage(),se);  
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
		return customRepairCollectionVOS;
	}
	 
	 /**
	  * [EES_MNR_0028] Repair Cancellation and Deletion의 정보를 조회 합니다. <br>
	  *	
	  * @param RepairCollectionINVO repairCollectionINVO
	  * @return List<CustomRepairCollectionVO> 
	  * @exception DAOException 
	  */
	 @SuppressWarnings("unchecked")   
	 public List<CustomRepairCollectionVO> searchRepairInquiryEDIErrorListData(RepairCollectionINVO repairCollectionINVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomRepairCollectionVO> customRepairCollectionVOS = null;
		  
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = repairCollectionINVO.getColumnValues();
			 
			 param.putAll(mapVO);											                      
			 velParam.putAll(mapVO);								  
			 	
			 if (repairCollectionINVO.getRqstEqNo() != null && repairCollectionINVO.getRqstEqNo().trim().length() > 0) {
				 List<String> eqNos = new ArrayList<String>(); 
				 String[] arrayEqNo =  repairCollectionINVO.getRqstEqNo().split(",");
				 for(int i = 0; i < arrayEqNo.length; i ++){      
					 eqNos.add(arrayEqNo[i]);	      
				 } 			
				 		
				 param.put("eqNos",eqNos);  	  	                    
				 velParam.put("eqNos",eqNos); 
			 }
			 
			 if (repairCollectionINVO.getRqstRefNo() != null && repairCollectionINVO.getRqstRefNo().trim().length() > 0) {
				 List<String> rqstRefNos = new ArrayList<String>(); 
				 String[] arrRqstRefNos =  repairCollectionINVO.getRqstRefNo().split(",");
				 for(int i = 0; i < arrRqstRefNos.length; i ++){      
					 rqstRefNos.add(arrRqstRefNos[i]);	      
				 } 		
				 	
				 param.put("rqstRefNos",rqstRefNos);  	  	                    
				 velParam.put("rqstRefNos",rqstRefNos);  
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchRepairInquiryEDIErrorListDataRSQL(), param, velParam);
			 customRepairCollectionVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomRepairCollectionVO .class);
		 } catch(SQLException se){			 	 
			 log.error(se.getMessage(),se);	  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }		  	
		 return customRepairCollectionVOS;
	 }
	 
	 /**
	  * [EES_MNR_0213] Warranty Alert_Pop Up의 정보를 조회 합니다. <br>
	  *
	  * @param EQWorkOrderHistoryListINVO eQWorkOrderHistoryListINVO
	  * @return List<CustomEQWorkOrderHistoryListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomEQWorkOrderHistoryListVO> searchEQWorkOrderHistoryListData(EQWorkOrderHistoryListINVO eQWorkOrderHistoryListINVO) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CustomEQWorkOrderHistoryListVO> customEQWorkOrderHistoryListVOS = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			Map<String, String> mapVO = eQWorkOrderHistoryListINVO.getColumnValues();
			  	
			param.putAll(mapVO);                      
			velParam.putAll(mapVO);          
			 		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchEQWorkOrderHistoryListDataRSQL(), param, velParam);
			customEQWorkOrderHistoryListVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomEQWorkOrderHistoryListVO .class);
		}catch(SQLException se){  
			log.error(se.getMessage(),se);  
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	  	
		return customEQWorkOrderHistoryListVOS;
	}	
	 	
	 /**
	  * [EES_MNR_0194]Reefer Spare Part Summary List의 정보를 조회 합니다. <br>
	  *
	  * @param SparePartWOINVO sparePartWOINVO
	  * @return List<MnrOrderInfoBySparePartVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<MnrOrderInfoBySparePartVO> searchWOInfoListBySparePartData(SparePartWOINVO sparePartWOINVO) throws DAOException {
		DBRowSet dbRowset = null;  
		List<MnrOrderInfoBySparePartVO> mnrOrderInfoBySparePartVOS = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			Map<String, String> mapVO = sparePartWOINVO.getColumnValues();
			param.putAll(mapVO);                      
			velParam.putAll(mapVO);          
			 		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchWOInfoListBySparePartDataRSQL(), param, velParam);
			mnrOrderInfoBySparePartVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, MnrOrderInfoBySparePartVO.class);
		}catch(SQLException se){  
			log.error(se.getMessage(),se);  
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
		return mnrOrderInfoBySparePartVOS;
	}	 
	 
	 /**
	  * [EES_MNR_0023]Repair Estimate Creation의 정보를 조회 합니다. <br>
	  *  최근 6개월 같은건을 처리한 견적서를 조회 합니다.<br>
	  * @param EstimateGRPVO estimateGRPVO
	  * @return List<CustomMnrRprRqstHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprRqstHdrVO> searchLatestEstimateData(EstimateGRPVO estimateGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOs = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter  
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{  
			 String rqst_eqno = estimateGRPVO.getCustomMnrRprRqstHdrVO().getRqstEqNo();
			 
			 param.put("rqst_eqno", rqst_eqno);
			 velParam.put("rqst_eqno", rqst_eqno); 
			 
			 String self_chk = estimateGRPVO.getCustomMnrRprRqstHdrVO().getRqstEqNo() + estimateGRPVO.getCustomMnrRprRqstHdrVO().getRprRqstSeq() + estimateGRPVO.getCustomMnrRprRqstHdrVO().getRprRqstVerNo();
			 	
			 param.put("self_chk", self_chk);          
			 velParam.put("self_chk", self_chk); 
			 
			 String vndr_seq = estimateGRPVO.getCustomMnrRprRqstHdrVO().getVndrSeq();
			 
			 param.put("vndr_seq", vndr_seq);          
			 velParam.put("vndr_seq", vndr_seq); 
			 	
			 List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS = estimateGRPVO.getCustomMnrRprRqstDtlVOS();
			 
			 List<String> eq_loc_cds = new ArrayList<String>();
			 for(int i = 0; i < customMnrRprRqstDtlVOS.size(); i ++){      
				 eq_loc_cds.add(customMnrRprRqstDtlVOS.get(i).getEqLocCd());     
			 }  			    
			 param.put("eq_loc_cds", eq_loc_cds);          
			 velParam.put("eq_loc_cds", eq_loc_cds); 
			 	
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchLatestEstimateDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class);
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrRprRqstHdrVOs;
	 }
	 
	 /**
	  * [EES_MNR_0023]Repair Estimate Creation의 정보를 조회 합니다. <br>
	  *
	  * @param EstimateINVO estimateINVO
	  * @param String currSystem 
	  * @param String isEdi 
	  * @return List<CustomMnrRprRqstHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprRqstHdrVO> searchEstimateSMRListData(EstimateINVO estimateINVO,String currSystem,String isEdi) throws DAOException {
		 DBRowSet dbRowset = null; 	 
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;
		 	
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = estimateINVO.getColumnValues();
			 
			 param.putAll(mapVO);                          
			 velParam.putAll(mapVO);  
			  
			 param.put("curr_sys", currSystem);   
			 velParam.put("curr_sys", currSystem); 
			 
			 param.put("is_edi", isEdi);   			
			 velParam.put("is_edi", isEdi);			
			  
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchEstimateSMRListDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class); 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrRprRqstHdrVOS; 
	 }
	 
	 /**
	  * [EES_MNR_0022]Repair Group Auditing의 정보를 조회 합니다. <br>
	  *
	  * @param EstimateINVO estimateINVO
	  * @return List<CustomMnrRprRqstHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprRqstHdrVO> searchESTGroupAuditListData(EstimateINVO estimateINVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;	
		 
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 	
			 Map<String, String> mapVO = estimateINVO.getColumnValues();
			 	
			 param.putAll(mapVO);  	  	                    
			 velParam.putAll(mapVO); 	          
			 
			 if (estimateINVO.getRqstEqNo() != null && estimateINVO.getRqstEqNo().trim().length() > 0) {
				 List<String> eqNos = new ArrayList<String>();
				 String[] arrayEqNo =  estimateINVO.getRqstEqNo().split(",");
				 for(int i = 0; i < arrayEqNo.length; i ++){      
					 eqNos.add(arrayEqNo[i]);      
				 } 
				 param.put("eqNos",eqNos);  	  	                    
				 velParam.put("eqNos",eqNos); 
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchESTGroupAuditListDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class); 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 } 	 
		 return customMnrRprRqstHdrVOS; 
	 }		
	 
	 /**
	  * [EES_MNR_0192]Repair Group Auditing의 정보를 조회 합니다. <br>
	  *
	  * @param EstimateINVO estimateINVO
	  * @return List<CustomMnrRprRqstDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprRqstDtlVO> searchIFEstimateDTLData(EstimateINVO estimateINVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS = null;
		 	
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = estimateINVO.getColumnValues();
			 
			 param.putAll(mapVO); 	                      
			 velParam.putAll(mapVO); 	          
			 	
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchIFEstimateDTLDataRSQL(), param, velParam);
			 customMnrRprRqstDtlVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstDtlVO .class); 
		 }catch(SQLException se){	  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }   
		 return customMnrRprRqstDtlVOS; 
	 }
	 
	 /**
	  * [EES_MNR_0192]Repair Group Auditing의 정보를 조회 합니다. <br>
	  *
	  * @param EstimateINVO estimateINVO
	  * @return List<CustomMnrRprRqstDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public CustomMnrRprRqstHdrVO searchEstimateHRDData(EstimateINVO estimateINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = estimateINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           
			 	
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchIFEstimateHRDDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class);  
			 
			 if(customMnrRprRqstHdrVOS.size() > 0){
				 customMnrRprRqstHdrVO = customMnrRprRqstHdrVOS.get(0);
			 }
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrRprRqstHdrVO; 
	 }
	 
	 /**
	  * [EES_MNR_0019]Repair Estimate Creation의 정보를 작업 합니다. <br>
	  *
	  * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	  * @return int
	  * @exception DAOException
	  */
	 public int removeEstimateHDRData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException {
		//query parameter 
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;	 	
			
		try { 
			Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();
				
			param.putAll(mapVO);      
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			 	
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOremoveEstimateHDRDataDSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update deleteEstimateHDRData"); 
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
	  * [EES_MNR_0019]Repair Estimate Creation의 정보를 작업 합니다. <br>
	  *
	  * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	  * @return int
	  * @exception DAOException
	  */
	 public int removeEstimateAllDTLData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException {
		 //query parameter 
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 int result = 0; 	 	
		   
		 try { 
			 Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();
			 
			 param.putAll(mapVO);      
			 velParam.putAll(mapVO);    
			 
			 SQLExecuter sqlExe = new SQLExecuter("");  
			 
			 result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOremoveEstimateAllDTLDataDSQL(), param, velParam);
			 
			 if(result == Statement.EXECUTE_FAILED)     
				 throw new DAOException("Fail to Update deleteEstimateAllDTLData");   
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
	  * [EES_MNR_0019]Repair Estimate Creation의 정보를 체크 합니다. <br>
	  *
	  * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	  * @return List<CustomMnrRprRqstHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprRqstHdrVO> checkEstimateHDRData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;   
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();	
			 
			 param.putAll(mapVO);      
			 velParam.putAll(mapVO);  
			  
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOcheckEstimateHDRDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class); 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrRprRqstHdrVOS; 
	 }
	 
	 /**
	  * [EES_MNR_0027]Repair Group Auditing의 정보를 수정 합니다. <br>
	  *
	  * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	  * @return int
	  * @exception DAOException
	  */
	public int modifyEstimateHDRSumData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				  
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOmodifyEstimateHDRSumDataUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyEstimateHDRSumData"); 
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
	 * [EES_MNR_0019]Repair Estimate Creation의 정보를 수정 합니다. <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @return int
	 * @exception DAOException
	 */ 
	public int modifyEstimateHDRData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOmodifyEstimateHDRDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyEstimateHDRData"); 
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
	 * [EES_MNR_0027]Repair Group Auditing의 정보를 수정 합니다. <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyESTHDRLastVersionUnFlagData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;	 
		
		try { 
			Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOmodifyESTHDRLastVersionUnFlagDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyESTHDRLastVersionUnFlagData"); 
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
	 * [EES_MNR_0027]Repair Group Auditing의 정보를 수정 합니다. <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyESTDTLLastVersionUnFlagData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;	 
				
		try { 
			Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOmodifyESTDTLLastVersionUnFlagDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyESTDTLLastVersionUnFlagData"); 
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
	 * [EES_MNR_0019]Repair Estimate Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeEstimateDTLData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				   
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOremoveEstimateDTLDataDSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update removeEstimateDTLData"); 
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
	 * [EES_MNR_0027]Repair Group Auditing의 정보를 추가 합니다. <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addEstimateHDRData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOaddEstimateHDRDataCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update addEstimateHDRData"); 
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
	 * [UDEVHJS_ALPSMNR_T_WESTIM] EDI 견적서를 견적서 HRD 테이블에 넣는다. <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addEstimateHDRDataFromTmpData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO,CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);  
			
			param.put("new_rqst_eq_no", customMnrRprRqstHdrVO.getRqstEqNo());
			velParam.put("new_rqst_eq_no", customMnrRprRqstHdrVO.getRqstEqNo());
			
			param.put("new_rpr_rqst_seq", customMnrRprRqstHdrVO.getRprRqstSeq());
			velParam.put("new_rpr_rqst_seq", customMnrRprRqstHdrVO.getRprRqstSeq());
			 	
			param.put("new_rpr_rqst_ver_no", customMnrRprRqstHdrVO.getRprRqstVerNo());
			velParam.put("new_rpr_rqst_ver_no", customMnrRprRqstHdrVO.getRprRqstVerNo());
			  
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOaddEstimateHDRDataFromTmpDataCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)       
				throw new DAOException("Fail to Insert addEstimateHDRDataFromTmpData"); 
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
	 * [UDEVHJS_ALPSMNR_T_WESTIM] TMP_DTL의 Labor Hour를 수정<br>
	 *
	 * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	 * @param String tmpSeq
	 * @return int
	 * @exception DAOException
	 */
	public int modifyEstimateTmpDTLData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO, String tmpSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();
			mapVO.put("tmp_seq", tmpSeq);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOmodifyEstimateTmpDTLDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to udpate modifyEstimateTmpDTLData");
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
	 * [UDEVHJS_ALPSMNR_T_WESTIM] 견적서DTL의 Labor Hour를 수정<br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyEstimateDTLData(EstimateINVO estimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = estimateINVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOmodifyEstimateDTLDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to udpate modifyEstimateTmpDTLData");
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
	 * [UDEVHJS_ALPSMNR_T_WESTIM] EDI 견적서를 견적서 DTL 테이블에 넣는다. <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addEstimateDTLDataFromTmpData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO,CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);  
			
			param.put("new_rqst_eq_no", customMnrRprRqstHdrVO.getRqstEqNo());
			velParam.put("new_rqst_eq_no", customMnrRprRqstHdrVO.getRqstEqNo());
			
			param.put("new_rpr_rqst_seq", customMnrRprRqstHdrVO.getRprRqstSeq());
			velParam.put("new_rpr_rqst_seq", customMnrRprRqstHdrVO.getRprRqstSeq());
			
			param.put("new_rpr_rqst_ver_no", customMnrRprRqstHdrVO.getRprRqstVerNo());
			velParam.put("new_rpr_rqst_ver_no", customMnrRprRqstHdrVO.getRprRqstVerNo());
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOaddEstimateDTLDataFromTmpDataCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Insert addEstimateDTLDataFromTmpData");  
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
	 * [EES_MNR_0027]Repair Group Auditing의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOs
	 * @exception DAOException
	 */
	public void addEstimateDTLData(List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrRprRqstDtlVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOaddEstimateDTLDataCSQL(), customMnrRprRqstDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " addEstimateDTLData");
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
	 * [EES_MNR_0211] Work Order의 정보를 조회 합니다. <br>
	 *
	 * @param WONoInquiryListGRPVO wONoInquiryListGRPVO
	 * @return List<WONoInquiryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<WONoInquiryVO> searchWONoInquiryListData(WONoInquiryListGRPVO wONoInquiryListGRPVO)throws DAOException {
		    DBRowSet dbRowset = null;  
		    List<WONoInquiryVO> wONoInquiryVOs = null;
		    
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			try{ 
				WONoInquiryListINVO wONoInquiryListINVO = wONoInquiryListGRPVO.getWONoInquiryListINVO();
				Map<String, String> mapVO = wONoInquiryListINVO.getColumnValues();
				  	
				param.putAll(mapVO);                      
				velParam.putAll(mapVO);          
				 		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchWONoInquiryListDataRSQL(), param, velParam);
				wONoInquiryVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, WONoInquiryVO .class);
			}catch(SQLException se){  
				log.error(se.getMessage(),se);  
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}  
			return wONoInquiryVOs;
	 }
	
	/**
	 * [EES_MNR_0058]W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @return String
	 * @exception DAOException
	 */   
	 public String searchMnrOrdSeqData() throws DAOException{
	 	DBRowSet dbRowset = null;    
	 	String returnVal = "";
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();
	 	
	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchMnrOrdSeqDataRSQL(), param, velParam);
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
	  * [EES_MNR_0058] Extra Expense Work Order 헤더을 조회합니다.<br> 
	  *
	  * @param GeneralWOGRPVO extraWOGRPVO
	  * @return List<CustomMnrOrdHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	public List<CustomMnrOrdHdrVO> searchExtraWOHeaderData (GeneralWOGRPVO extraWOGRPVO) throws DAOException {
		    DBRowSet dbRowset = null;  
		    List<CustomMnrOrdHdrVO> customMnrOrdHdrVOs = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			try{ 
				GeneralWOINVO generalWOINVO = extraWOGRPVO.getGeneralWOINVO();
				Map<String, String> mapVO = generalWOINVO.getColumnValues();
				if(generalWOINVO.getMnrOrdSeq().length() > 3){
					String cty_cd  = generalWOINVO.getMnrOrdSeq().substring(0, 3);
					String ord_seq = generalWOINVO.getMnrOrdSeq().substring(3);
					mapVO.put("mnr_ord_ofc_cty_cd", cty_cd);
					mapVO.put("mnr_ord_seq", ord_seq);
					mapVO.put("mnr_wo_tp_cd", generalWOINVO.getMnrWoTpCd());
					mapVO.put("cost_of_cd", generalWOINVO.getCostOfcCd());	
					mapVO.put("f_gubuns", generalWOINVO.getFGubuns());	

				}
				param.putAll(mapVO);                      
				velParam.putAll(mapVO);          
				 		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchExtraWOHeaderDataRSQL(), param, velParam);
				customMnrOrdHdrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrOrdHdrVO .class);
			}catch(SQLException se){  
				log.error(se.getMessage(),se);  
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}  
			return customMnrOrdHdrVOs;
	 }
	 
	 /**
	  * [EES_MNR_0058] Extra Expense Work Order DTL을 조회합니다.<br> 
	  *
	  * @param GeneralWOGRPVO extraWOGRPVO
	  * @return List<CustomMnrOrdDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrOrdDtlVO> searchExtraWODetailData (GeneralWOGRPVO extraWOGRPVO) throws DAOException {
		    DBRowSet dbRowset = null;  
		    List<CustomMnrOrdDtlVO> customMnrOrdDtlVOs = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			try{ 
				GeneralWOINVO generalWOINVO = extraWOGRPVO.getGeneralWOINVO();
				Map<String, String> mapVO = generalWOINVO.getColumnValues();
				if(generalWOINVO.getMnrOrdSeq().length() > 3){
					String cty_cd  = generalWOINVO.getMnrOrdSeq().substring(0, 3);
					String ord_seq = generalWOINVO.getMnrOrdSeq().substring(3);
					mapVO.put("mnr_ord_ofc_cty_cd", cty_cd);
					mapVO.put("mnr_ord_seq", ord_seq);
				}
				param.putAll(mapVO);                      
				velParam.putAll(mapVO);          
				 		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchExtraWODetailDataRSQL(), param, velParam);
				customMnrOrdDtlVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrOrdDtlVO .class);
			}catch(SQLException se){  
				log.error(se.getMessage(),se);  
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}  
			return customMnrOrdDtlVOs;
	 }
	 
	 /**
	  * [EES_MNR_0032]Repair Result creatioln by W/O의 정보를 조회 합니다. <br>
	  *
	  * @param RepairResultGRPVO repairResultGRPVO
	  * @return List<RepairResultListVO>
	  * @exception DAOException
	  */ 
	 @SuppressWarnings("unchecked") 
	 public List<RepairResultListVO> searchRepairResultListData (RepairResultGRPVO repairResultGRPVO) throws DAOException {
		    DBRowSet dbRowset = null;  
		    List<RepairResultListVO> repairResultListVOs = null;
		    
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			try{ 
				RepairResultINVO repairResultINVO = repairResultGRPVO.getRepairResultINVO();
				Map<String, String> mapVO = repairResultINVO.getColumnValues();
				if(repairResultINVO.getMnrOrdSeq().length() > 3){
					String cty_cd  = repairResultINVO.getMnrOrdSeq().substring(0, 3);
					//2010-04-16 OrdSeq는 Number 형이므로 숫자형이 아닌 문자는 잘라버린다.
					String ord_seq = repairResultINVO.getMnrOrdSeq().substring(3);
					StringBuilder tempSerWoNo = new StringBuilder("");
					char chars[] = ord_seq.toCharArray();
					for(int k = 0; k < chars.length;k ++){
						if(!(chars[k] < '0' || chars[k] > '9')) { 
							Character ch = new Character(chars[k]);
							tempSerWoNo.append(ch.toString());	
						} 		
					}		
					ord_seq = tempSerWoNo.toString(); 
					mapVO.put("mnr_ord_ofc_cty_cd", cty_cd);
					mapVO.put("mnr_ord_seq", ord_seq);
				}
				param.putAll(mapVO);                      
				velParam.putAll(mapVO);          
				 		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchRepairResultListDataRSQL(), param, velParam);
				repairResultListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, RepairResultListVO .class);
			}catch(SQLException se){  
				log.error(se.getMessage(),se);  
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}  
			return repairResultListVOs;
	 }	 	 
	 
	 /**
	  * [EES_MNR_0226]Simple W/O Inquiry Pop Up의 정보를 작업 합니다. <br>
	  *
	  * @param GeneralWOGRPVO extraWOGRPVO
	  * @return List<CustomBzcAmtVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomBzcAmtVO> getBzcAmtData (GeneralWOGRPVO extraWOGRPVO) throws DAOException {
		    DBRowSet dbRowset = null;  
		    List<CustomBzcAmtVO> customBzcAmtVOs = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			try{ 
				GeneralWOINVO generalWOINVO = extraWOGRPVO.getGeneralWOINVO();
				Map<String, String> mapVO = generalWOINVO.getColumnValues();
				  	
				param.putAll(mapVO);                      
				velParam.putAll(mapVO);          
				 		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOgetBzcAmtDataRSQL(), param, velParam);
				customBzcAmtVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomBzcAmtVO .class);
			}catch(SQLException se){  
				log.error(se.getMessage(),se);  
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}  
			return customBzcAmtVOs; 
	 }
	 
	 /**
	  * [EES_MNR_0058]Simple W/O Creation의 정보를 추가 합니다. <br>
	  *
	  * @param CustomMnrOrdHdrVO customMnrOrdHdrVO
	  * @return int
	  * @exception DAOException
	  */ 
	public int addExtraWOHeaderData(CustomMnrOrdHdrVO customMnrOrdHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrOrdHdrVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOaddExtraWOHeaderDataCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update removeEstimateDTLData"); 
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
	 * [EES_MNR_0054]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 추가 합니다. <br>
	 *
	 * @param CustomMnrOrdHdrVO customMnrOrdHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addRFSpareWOHeaderData(CustomMnrOrdHdrVO customMnrOrdHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrOrdHdrVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOaddRFSpareWOHeaderDataCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update removeEstimateDTLData"); 
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
	 * [EES_MNR_0058]Simple W/O Creation의 정보를 수정 합니다. <br>
	 *
	 * @param CustomMnrOrdHdrVO customMnrOrdHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyExtraWOHeaderData(CustomMnrOrdHdrVO customMnrOrdHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrOrdHdrVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOmodifyExtraWOHeaderDataUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyExtraWOHeaderData"); 
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
	 * [EES_MNR_0032]Repair Result creatioln by W/O의 정보를 수정 합니다. <br>
	 *
	 * @param List<RepairResultListVO> repairResultListVOs
	 * @exception DAOException
	 */ 
	public void modifyRepairResultWODetailData(List<RepairResultListVO> repairResultListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(repairResultListVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOmodifyRepairResultWODetailDataUSQL(), repairResultListVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " RepairMgtDBDAOaddExtraWODetailDataCSQL");
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
	 * [EES_MNR_0054]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 수정 합니다. <br>
	 *
	 * @param CustomMnrOrdHdrVO customMnrOrdHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyRFSpareWOHeaderData(CustomMnrOrdHdrVO customMnrOrdHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrOrdHdrVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOmodifyRFSpareWOHeaderDataUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyExtraWOHeaderData"); 
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
	 * [EES_MNR_0058]Simple W/O Creation의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrOrdDtlVO> customMnrOrdDtlVOs
	 * @exception DAOException
	 */
	public void addExtraWODetailData(List<CustomMnrOrdDtlVO> customMnrOrdDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrOrdDtlVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOaddExtraWODetailDataCSQL(), customMnrOrdDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " RepairMgtDBDAOaddExtraWODetailDataCSQL");
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
	 * [EES_MNR_0054]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrOrdDtlVO> customMnrOrdDtlVOs
	 * @exception DAOException
	 */
	public void addRFSpareWODetailData(List<CustomMnrOrdDtlVO> customMnrOrdDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrOrdDtlVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOaddRFSpareWODetailDataCSQL(), customMnrOrdDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " RepairMgtDBDAOaddSimpleWODetailDataCSQL");
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
	 * [EES_MNR_0058]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrOrdHdrVO customMnrOrdHdrVO
	 * @return int
	 * @exception DAOException
	 */
	 public int removeWOHeaderData(CustomMnrOrdHdrVO customMnrOrdHdrVO) throws DAOException {
		 //query parameter 
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 int result = 0;		 	
		 
		 try {  
			 Map<String, String> mapVO = customMnrOrdHdrVO.getColumnValues();

			 param.putAll(mapVO);      
			 velParam.putAll(mapVO);    
			 
			 SQLExecuter sqlExe = new SQLExecuter("");  
			 
			 result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOremoveWOHeaderDataDSQL(), param, velParam);
			 
			 if(result == Statement.EXECUTE_FAILED)     
				 throw new DAOException("Fail to Delete RepairMgtDBDAOremoveExtraWOHeaderDataDSQL");   
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
	  * [EES_MNR_0058]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 삭제 합니다. <br>
	  *
	  * @param CustomMnrOrdHdrVO customMnrOrdHdrVO
	  * @return int
	  * @exception DAOException
	  */
	 public int removeWODetailData(CustomMnrOrdHdrVO customMnrOrdHdrVO) throws DAOException {
		 //query parameter 
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 int result = 0;	 	
		 
		 try { 
			 Map<String, String> mapVO = customMnrOrdHdrVO.getColumnValues();

			 param.putAll(mapVO);      
			 velParam.putAll(mapVO);    
			 
			 SQLExecuter sqlExe = new SQLExecuter("");  
			 
			 result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOremoveWODetailDataDSQL(), param, velParam);
			 
			 if(result == Statement.EXECUTE_FAILED)     
				 throw new DAOException("Fail to Delete RepairMgtDBDAOremoveExtraWODetailDataDSQL");   
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
	  * [EES_MNR_0036]M&R Document Transmission의 정보를 조회 합니다. <br>
	  *
	  * @param DocINVO docINVO
	  * @return List<CustomDocHeaderVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomDocHeaderVO> searchDocWOHeaderData(DocINVO docINVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 List<CustomDocHeaderVO> customDocHeaderVOs = null;
		 	
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = docINVO.getColumnValues();
			 
			 param.putAll(mapVO);                       
			 velParam.putAll(mapVO);           

			 if(docINVO.getMnrOrdOfcCtyCd().length()>0){
				 List<String> mnrOrdOfcCtyCds = new ArrayList<String>();     
				 String[] arrMnrOrdOfcCtyCd =  docINVO.getMnrOrdOfcCtyCd().split(",");
				 for(int i = 0; i < arrMnrOrdOfcCtyCd.length; i ++){         
					 mnrOrdOfcCtyCds.add(arrMnrOrdOfcCtyCd[i]);           
				 }     
				 velParam.put("mnrOrdOfcCtyCds", mnrOrdOfcCtyCds);
			 }	 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchDocWOHeaderDataRSQL(), param, velParam);
			 customDocHeaderVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomDocHeaderVO .class); 
			 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customDocHeaderVOs; 
	 }

	 /**
	  * [EES_MNR_0036]M&R Document Transmission의 정보를 추가/수정/삭제 합니다. <br>
	  *
	  * @param CustomMnrOrdHdrVO customMnrOrdHdrVO
	  * @return int
	  * @exception DAOException
	  */
	public int manageDocSendData(CustomMnrOrdHdrVO customMnrOrdHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrOrdHdrVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOmanageDocSendDataUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update manageDocSendData"); 
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
	 * [EES_MNR_0030]W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param ESTWOMainGRPVO eSTWOMainGRPVO
	 * @param SignOnUserAccount account
	 * @return List<CustomESTWOMainSMRVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CustomESTWOMainSMRVO> searchESTWOSMRData(ESTWOMainGRPVO eSTWOMainGRPVO, SignOnUserAccount account) throws DAOException {
	    DBRowSet dbRowset = null;  
	    List<CustomESTWOMainSMRVO> customESTWOMainSMRVOs = null;
	    
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			ESTWOMainINVO eSTWOMainINVO = eSTWOMainGRPVO.getESTWOMainINVO();
			Map<String, String> mapVO = eSTWOMainINVO.getColumnValues();

			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			param.put("user_ofc_cd", account.getOfc_cd());
			velParam.put("user_ofc_cd", account.getOfc_cd());
			

			List<String> wo_nos = new ArrayList<String>();
			String[] arrayWoNo =  eSTWOMainINVO.getWoNo().split(",");
			for(int i = 0; i < arrayWoNo.length; i ++){      
				 wo_nos.add(arrayWoNo[i]);     
			}    
		    param.put("wo_nos", wo_nos);          
			velParam.put("wo_nos", wo_nos);    
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchESTWOSMRDataRSQL(), param, velParam);
			customESTWOMainSMRVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomESTWOMainSMRVO .class);
		}catch(SQLException se){  
			log.error(se.getMessage(),se);  
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
		return customESTWOMainSMRVOs;  
	 }
		 
	 /**
	  * [EES_MNR_0030]W/O Creation의 정보를 조회 합니다. <br>
	  *
	  * @param ESTWOMainGRPVO eSTWOMainGRPVO
	  * @param SignOnUserAccount account
	  * @return List<CustomESTWOMainINFOVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomESTWOMainINFOVO> searchESTWOINFOData(ESTWOMainGRPVO eSTWOMainGRPVO, SignOnUserAccount account) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomESTWOMainINFOVO> customESTWOMainINFOVOs = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 ESTWOMainINVO eSTWOMainINVO = eSTWOMainGRPVO.getESTWOMainINVO();
			 Map<String, String> mapVO = eSTWOMainINVO.getColumnValues();

			 param.putAll(mapVO);  
			 velParam.putAll(mapVO); 
			 param.put("user_ofc_cd", account.getOfc_cd());
			 velParam.put("user_ofc_cd", account.getOfc_cd());

			 List<String> wo_nos = new ArrayList<String>();
			 String[] arrayWoNo =  eSTWOMainINVO.getWoNo().split(",");
			 for(int i = 0; i < arrayWoNo.length; i ++){      
				 wo_nos.add(arrayWoNo[i]);     
			 } 
			 param.put("wo_nos", wo_nos);    
			 velParam.put("wo_nos", wo_nos); 
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchESTWOINFODataRSQL(), param, velParam);
			 customESTWOMainINFOVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomESTWOMainINFOVO .class);
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customESTWOMainINFOVOs;
	 }

	 /**
	  * [EES_MNR_0030]W/O Creation의 정보를 추가 합니다. <br>
	  *
	  * @param List<CustomESTWOMainINFOVO> customESTWOMainINFOVOs
	  * @exception DAOException
	  */
	public void addESTWOCreationHeaderData(List<CustomESTWOMainINFOVO> customESTWOMainINFOVOs) throws DAOException,Exception {
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customESTWOMainINFOVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOaddESTWOCreationHeaderDataCSQL(), customESTWOMainINFOVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addESTWOCreationHeaderData");
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
	 * [EES_MNR_0030]W/O Creation의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomESTWOMainINFOVO> customESTWOMainINFOVOs
	 * @exception DAOException
	 */
	public void addESTWOCreationDetailData(List<CustomESTWOMainINFOVO> customESTWOMainINFOVOs) throws DAOException,Exception {
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customESTWOMainINFOVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOaddESTWOCreationDetailDataCSQL(), customESTWOMainINFOVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addESTWOCreationDetailData");
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
	 * [EES_MNR_0030]W/O Creation의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomESTWOMainINFOVO> customESTWOMainINFOVOs
	 * @exception DAOException
	 */
	public void modifyESTWOCreationHeaderData(List<CustomESTWOMainINFOVO> customESTWOMainINFOVOs) throws DAOException,Exception {
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customESTWOMainINFOVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOmodifyESTWOCreationHeaderDataUSQL(), customESTWOMainINFOVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyESTWOCreationHeaderData");
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
	  * [UDEVHJS_ALPSMNR_T_WESTIM] 견적서 넣을 SEQ을 조회합니다. <br>
	  *  
	  * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	  * @return CustomMnrRprRqstHdrVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked") 
	 public CustomMnrRprRqstHdrVO searchEstimateSeqNewEqData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;	 	 
		 CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;
		 
		 //query parameter	
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 	 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();
			 
			 param.putAll(mapVO);   	                     
			 velParam.putAll(mapVO);             
			 		
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchEstimateSeqNewEqDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class); 
			 
			 if(customMnrRprRqstHdrVOS.size() > 0){ 			
				 customMnrRprRqstHdrVO = customMnrRprRqstHdrVOS.get(0);
			 }     		
		 }catch(SQLException se){  				  			  
			 log.error(se.getMessage(),se);    
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){   
			 log.error(ex.getMessage(),ex);			
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }     
		 return customMnrRprRqstHdrVO;      
	 }

	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 삭제 합니다. <br>
	 *	
	 * @param List<CustomMnrOrdDtlVO> customMnrOrdDtlVOs
	 * @exception DAOException 
	 */
	public void modifyWEBInvoiceLinkData(List<CustomMnrOrdDtlVO> customMnrOrdDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrOrdDtlVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOmodifyWEBInvoiceLinkDataUSQL(), customMnrOrdDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to RepairMgtDBDAOmodifyWEBInvoiceLinkDataUSQL ins No"+ i + " SQL");
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
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrOrdDtlVO> customMnrOrdDtlVOs
	 * @exception DAOException
	 */
	public void modifyWEBInvoiceResultDTLinkData(List<CustomMnrOrdDtlVO> customMnrOrdDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrOrdDtlVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOmodifyWEBInvoiceResultDTLinkDataUSQL(), customMnrOrdDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to RepairMgtDBDAOmodifyWEBInvoiceResultDTLinkDataUSQL ins No"+ i + " SQL");
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
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrOrdDtlVO customMnrOrdDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyWEBInvoiceLinkClearData(CustomMnrOrdDtlVO customMnrOrdDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrOrdDtlVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOmodifyWEBInvoiceLinkClearDataUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyWEBInvoiceLinkClearData"); 
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
	  * [EES_MNR_0041] 해당 MNR_ORD_DTL 테이블에서 해당 PAY_INV_SEQ에 ACCT_CD가 511591인 놈들을 삭제한다.  <br>
	  *
	  * @param CustomMnrOrdDtlVO customMnrOrdDtlVO
	  * @return int
	  * @exception DAOException
	  */
	 public int removeWODetailByPayINVSeqData(CustomMnrOrdDtlVO customMnrOrdDtlVO) throws DAOException {
		 //query parameter 
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 int result = 0;	 	
		 
		 try { 	
			 Map<String, String> mapVO = customMnrOrdDtlVO.getColumnValues();
			 
			 param.putAll(mapVO);      
			 velParam.putAll(mapVO);	    
			 
			 SQLExecuter sqlExe = new SQLExecuter("");  
			 	
			 result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOremoveWODetailByPayINVSeqDataDSQL(), param, velParam);
			 
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
	 
	 /**
	 * [EES_MNR_0041]  해당 MNR_ORD_DTL 테이블에서 해당 PAY_INV_SEQ에 ACCT_CD가 511591인 정보를 추가 합니다. <br>
	 *
	 * @param CustomMnrOrdDtlVO customMnrOrdDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int addWODetailByPayINVSeqData(CustomMnrOrdDtlVO customMnrOrdDtlVO) throws DAOException,Exception {
		//query parameter 
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = customMnrOrdDtlVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOaddWODetailByPayINVSeqDataCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Insert addWODetailByPayINVSeqData"); 
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
	  * [EDI Estimate Auditing]EDI Estimate Auditing의 디테일 정보를 조회 합니다. <br>
	  *
	  * @param EstimateINVO estimateINVO
	  * @return List<CustomMnrRprRqstDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprRqstVDtlVO> searchIFEstimateVDTLData(EstimateINVO estimateINVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrRprRqstVDtlVO> customMnrRprRqstVDtlVOs = null;
		 	
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = estimateINVO.getColumnValues();
			 
			 param.putAll(mapVO); 	                      
			 velParam.putAll(mapVO); 	          
			 	
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchIFEstimateDTLDataRSQL(), param, velParam);
			 customMnrRprRqstVDtlVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstVDtlVO .class); 
		 }catch(SQLException se){	  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }   
		 return customMnrRprRqstVDtlVOs; 
	 }
	 
	 /**
	  * [EES_MNR_0019]Repair Estimate Creation의 정보를 체크 합니다. <br>
	  *
	  * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	  * @return List<CustomMnrRprRqstHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprRqstHdrVO> checkEstimateDTLData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;   
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();	
			 
			 param.putAll(mapVO);      
			 velParam.putAll(mapVO);  
			  
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOcheckEstimateDTLDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class); 
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrRprRqstHdrVOS; 
	 }
	 
	 /**
	  * [EES_MNR_0023] Repair Estimate 의 정보를 체크 합니다. <br>
	  *
	  * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	  * @return CustomMnrRprRqstHdrVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public CustomMnrRprRqstHdrVO checkESTNextVerNoData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;   
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;
		 CustomMnrRprRqstHdrVO result = new CustomMnrRprRqstHdrVO();
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{ 
			 Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();	
			 
			 param.putAll(mapVO);      
			 velParam.putAll(mapVO);  
			  
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOcheckESTNextVerNoDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class);
			 
			 if(customMnrRprRqstHdrVOS.size() > 0){ 			
				 result = customMnrRprRqstHdrVOS.get(0);
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
	  * [EES_MNR_0023] 썸네일 관련 HTML 코드를 생성하여 반환합니다. <br>
	  *
	  * @param String fileSeq
	  * @return String
	  */
	@SuppressWarnings("unchecked")
	public String searchHtmlCodeForThumbnail(String fileSeq) {
		StringBuffer htmlCodeForThumbnail = new StringBuffer(512);
		List<CustomMnrThumbnailFileAtchVO> customMnrThumbnailFileAtchVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			 if(fileSeq != null){
				 param.put("file_seq", fileSeq);
				 velParam.put("file_seq", fileSeq);
			 }

			DBRowSet dbRowset = new SQLExecuter().executeQuery(new RepairMgtDBDAOsearchHtmlCodeForThumbnailRSQL(), param, velParam);
			customMnrThumbnailFileAtchVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrThumbnailFileAtchVO .class);
			
			for(int i = 0; i < customMnrThumbnailFileAtchVO.size(); i++){
				
				htmlCodeForThumbnail.append("<IMG SRC='FileDownload?key=");
				htmlCodeForThumbnail.append(customMnrThumbnailFileAtchVO.get(i).getThmFilePathNm());
				htmlCodeForThumbnail.append("' HEIGHT='100' WIDTH='100' border='1' hspace='3' vspace='3' onclick='OpenThumbnailWindow(this.src)'/>");
				
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
		}
		return htmlCodeForThumbnail.toString();
	}
	
	
	/**
	 * [EES_MNR_0061] ACEP Check Header Info Search <br>
	 * @param acepChkHdrVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AcepChkHdrVO searchAcepChkHeaderInfo(AcepChkHdrVO acepChkHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AcepChkHdrVO> acepChkHdrVOs = null;
		 AcepChkHdrVO acepChkHdrInfo = new AcepChkHdrVO();
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = acepChkHdrVO.getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			  
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOSearchAcepChkHeaderInfoRSQL(), param, velParam);
			 acepChkHdrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, AcepChkHdrVO .class);
			 
			 if(acepChkHdrVOs.size() > 0){
				 acepChkHdrInfo = acepChkHdrVOs.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return acepChkHdrInfo;
	 }
	
	
	/**
	 * [EES_MNR_0061] ACEP Check Detail List Search <br>
	 * @param acepChkHdrVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AcepChkDtlVO> searchAcepChkDetailList(AcepChkHdrVO acepChkHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AcepChkDtlVO> acepChkDtlList = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{ 
			 Map<String, String> mapVO = acepChkHdrVO.getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			  
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOSearchAcepChkDetailListRSQL(), param, velParam);
			 acepChkDtlList = (List)RowSetUtil.rowSetToVOs(dbRowset, AcepChkDtlVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return acepChkDtlList;
	}
	
	/**
	 * [EES_MNR_0061] ACEP Seq Search <br>
	 * @param String venderSeq 
	 * @return String
	 * @exception DAOException
	 */
	/**
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAcepSeq() throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";
		 
		 //query parameter 
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 try{  
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOSearchAcepSeqRSQL(), param, velParam);
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
	 * [EES_MNR_0061] ACEP Check List Header Info Insert
	 * @param acepChkHdrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAcepChkHeaderInfo(AcepChkHdrVO acepChkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = acepChkHdrVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOAddAcepChkHeaderCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Insert addAcepChkHeaderInfo"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0023] Estimate Auditing 시 ACEP Header Data 자동 생성
	 * @param acepChkHdrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAutoAcepChkHeaderInfo(AcepChkHdrVO acepChkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = acepChkHdrVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOAddAutoAcepChkHeaderCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Insert addAutoAcepChkHeaderInfo"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0061] ACEP Check List Detail List Insert
	 * @param acepChkDtlVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAcepChkDetailList(List<AcepChkDtlVO> acepChkDtlVOs) throws DAOException,Exception {
		try {   
			SQLExecuter sqlExe = new SQLExecuter("");
			int intCnt[] = null;  
			if(acepChkDtlVOs.size() > 0){ 
				intCnt = sqlExe.executeBatch((ISQLTemplate)new RepairMgtDBDAOAddAcepChkDetailCSQL(), acepChkDtlVOs ,null);
				for(int i = 0; i < intCnt.length; i++){ 
					if(intCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addAcepChkDetailList No"+ i + " SQL");
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
	 * [EES_MNR_0023] Estimate Auditing 시 ACEP Detail Data 자동 생성
	 * @param acepChkHdrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAutoAcepChkDetailList(AcepChkHdrVO acepChkHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
		try {
			Map<String, String> mapVO = acepChkHdrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
				
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAOAddAutoAcepChkDetailCSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Insert addAutoAcepChkDetailList");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0061] ACEP Check List Detail List Delete
	 * @param acepChkHdrVO
	 * @return
	 * @throws DAOException
	 */
	public void removeAcepChkDetailList(AcepChkHdrVO acepChkHdrVO) throws DAOException {
		//query parameter 
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;	 	
			
		try { 
			Map<String, String> mapVO = acepChkHdrVO.getColumnValues();
				
			param.putAll(mapVO);      
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			 	
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAORemoveAcepChkDetailDSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to removeAcepChkDetailList"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0052] Simple W/O Creation - ACEP Check List Header Info Delete
	 * @param acepChkHdrVO
	 * @return
	 * @throws DAOException
	 */
	public void removeAcepChkHeaderForWO(AcepChkHdrVO acepChkHdrVO) throws DAOException {
		//query parameter 
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;	 	
			
		try { 
			Map<String, String> mapVO = acepChkHdrVO.getColumnValues();
				
			param.putAll(mapVO);      
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			 	
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAORemoveAcepChkHeaderForWODSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to removeAcepChkHeader"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0052] Simple W/O Creation - ACEP Check List Detail List Delete
	 * @param acepChkHdrVO
	 * @return
	 * @throws DAOException
	 */
	public void removeAcepChkDetailForWO(AcepChkHdrVO acepChkHdrVO) throws DAOException {
		//query parameter 
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;	 	
			
		try { 
			Map<String, String> mapVO = acepChkHdrVO.getColumnValues();
				
			param.putAll(mapVO);      
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			 	
			result = sqlExe.executeUpdate((ISQLTemplate)new RepairMgtDBDAORemoveAcepChkDetailForWODSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to removeAcepChkDetailList"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}