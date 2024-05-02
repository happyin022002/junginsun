/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairMgtBCImpl.java
*@FileTitle : Repair
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.03 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.10.28 김상수 [CHM-201114133-01] ALPS MNR->REPAIR Estimate 에서 EDI Upload 시 Man-Hour 계산로직 수정
* 2013.05.09 조경완 [CHM-201324479-01][MNR] Repair Estimate 처리시 이미 처리된 Data를 재 Save, Request, Approval 할 경우 발생하는 SQL Error 처리
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCostCodeVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration.RepairMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkGrpVO;
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
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.DocGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EQWorkOrderHistoryListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.ESTWOMainGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.GeneralWOINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.MnrOrderInfoBySparePartVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairResultGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairResultINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairResultListVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.SparePartWOGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author park myoung sin    
 * @see RepairMgtBC 각 DAO 클래스 참조 
 * @since J2EE 1.4      
 */		         
 public  class RepairMgtBCImpl extends BasicCommandSupport implements RepairMgtBC {

	// Database Access Object  
	private transient RepairMgtDBDAO dbDao = null; 
	 	
	/** 	
	 * RepairMgtBCImpl 객체 생성<br>
	 * RepairMgtDBDAO를 생성한다.<br>
	 */    
	public RepairMgtBCImpl() {  
		dbDao = new RepairMgtDBDAO(); 
	} 
	 
	/**
	 * [EES_MNR_0015] 버젼업 하기전 미승인된 견적서 리스트를 조회합니다.. <br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException	
	 */					
	public AgreementGRPVO searchNotApprovalESTByAGMTBasic(AgreementGRPVO agreementGRPVO) throws EventException {
		List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null; 
		
		try {				    
			//헤더정보 조회			 
			customMnrRprRqstHdrVOS = dbDao.searchNotApprovalESTByAGMTData(agreementGRPVO); 
			agreementGRPVO.setCustomMnrRprRqstHdrVOS(customMnrRprRqstHdrVOS);	 
			return agreementGRPVO; 	  
		} catch (DAOException ex) {	    	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Agreement Creation] searchNotApprovalESTByAGMTBasic"}).getMessage(),ex);
		} catch (Exception ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Agreement Creation] searchNotApprovalESTByAGMTBasic"}).getMessage(),ex);
		}	
	}
	
	/**
	 * [EES_MNR_0015] 견적서에서 해당 Agreement를 사용하는 견적서 리스트를 조회합니다.. <br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException	
	 */					
	public AgreementGRPVO searchUsedEstimateByAGMTBasic(AgreementGRPVO agreementGRPVO) throws EventException {
		List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null; 
		
		try {				    
			//헤더정보 조회			 
			customMnrRprRqstHdrVOS = dbDao.searchUsedEstimateByAGMTData(agreementGRPVO); 
			agreementGRPVO.setCustomMnrRprRqstHdrVOS(customMnrRprRqstHdrVOS); 
			return agreementGRPVO; 	  
		} catch (DAOException ex) {	    	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Agreement Creation] searchUsedEstimateByAGMTBasic"}).getMessage(),ex);
		} catch (Exception ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Agreement Creation] searchUsedEstimateByAGMTBasic"}).getMessage(),ex);
		}	
	}
	
	/**
	 * [EES_MNR_0192] EDI Estimate의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchEDIEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException {
		CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;  
		
		try {    
			//헤더정보 조회	 
			customMnrRprRqstHdrVO = dbDao.searchEDIEstimateHRDData(estimateGRPVO.getEstimateINVO()); 
			estimateGRPVO.setCustomMnrRprRqstHdrVO(customMnrRprRqstHdrVO) ; 
			
			//디테일 조회  	 
			List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS = null;
			customMnrRprRqstDtlVOS = dbDao.searchEDIIFEstimateDTLData(estimateGRPVO.getEstimateINVO());
			estimateGRPVO.setCustomMnrRprRqstDtlVOS(customMnrRprRqstDtlVOS);
			return estimateGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchEstimateBasic"}).getMessage(),ex);
		} catch (Exception ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchEstimateBasic"}).getMessage(),ex);
		}	
	} 
		
	/**
	 * [EES_MNR_0028] Repair Cancellation and Deletion의 정보를 조회 합니다. <br>
	 * EES_MNR_S027, EES_MNR_0027, EES_MNR_S028 만사용
	 * 2015.03.03 Repair Inquiry, Repair Cancelation & Deletion에서 사용하던부분을
	 * Repair Inquiry(EES_MNR_0028) 는 별도 적용
	 *
	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount 	account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */
	public RepairCollectionGRPVO searchRepairInquiryListBasic(RepairCollectionGRPVO repairCollectionGRPVO,SignOnUserAccount account) throws EventException {
		try { 	
			//Location별 시간체크를 위한..	
			repairCollectionGRPVO.getRepairCollectionINVO().setCurOfcCd(account.getOfc_cd());
				
			List<CustomRepairCollectionVO> customRepairCollectionVOS = null; 
			
			if(repairCollectionGRPVO.getRepairCollectionINVO().getEdiErrorOnly().equalsIgnoreCase("Y")){
				customRepairCollectionVOS = dbDao.searchRepairInquiryEDIErrorListData(repairCollectionGRPVO.getRepairCollectionINVO());
			} else {	 			
				customRepairCollectionVOS = dbDao.searchRepairInquiryListData(repairCollectionGRPVO.getRepairCollectionINVO(),repairCollectionGRPVO.getCurrSystem());
			}		     
				
			repairCollectionGRPVO.setCustomRepairCollectionVOS(customRepairCollectionVOS);   
			return repairCollectionGRPVO;           
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Cancellation and Deletion] searchRepairInquiryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Cancellation and Deletion] searchRepairInquiryListBasic"}).getMessage(),ex);
		}
	} 

	/**
	 * [EES_MNR_0028] Repair Cancellation and Deletion의 정보를 조회 합니다. <br>
	 * EES_MNR_0028 만사용
	 * 2015.03.03 Repair Inquiry, Repair Cancelation & Deletion에서 사용하던부분을
	 * Repair Inquiry(EES_MNR_0028)만 별도 적용

	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount 	account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */
	public RepairCollectionGRPVO searchRepairInquiryListForHJS(RepairCollectionGRPVO repairCollectionGRPVO,SignOnUserAccount account) throws EventException {
		try { 	
			//Location별 시간체크를 위한..	
			repairCollectionGRPVO.getRepairCollectionINVO().setCurOfcCd(account.getOfc_cd());
				
			List<CustomRepairCollectionVO> customRepairCollectionVOS = null; 
			
			customRepairCollectionVOS = dbDao.searchRepairInquiryListDataForHJS(repairCollectionGRPVO.getRepairCollectionINVO(),repairCollectionGRPVO.getCurrSystem());
				
			repairCollectionGRPVO.setCustomRepairCollectionVOS(customRepairCollectionVOS);   
			return repairCollectionGRPVO;           
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Cancellation and Deletion] searchRepairInquiryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Cancellation and Deletion] searchRepairInquiryListBasic"}).getMessage(),ex);
		}
	} 

	/**
	 * [EES_MNR_0213] Warranty Alert_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param EQWorkOrderHistoryListGRPVO eQWorkOrderHistoryListGRPVO
	 * @return EQWorkOrderHistoryListGRPVO
	 * @exception EventException
	 */
	public EQWorkOrderHistoryListGRPVO searchEQWorkOrderHistoryListBasic(EQWorkOrderHistoryListGRPVO eQWorkOrderHistoryListGRPVO) throws EventException {
		try { 
			List<CustomEQWorkOrderHistoryListVO> customEQWorkOrderHistoryListVOS = null;
			  
			customEQWorkOrderHistoryListVOS = dbDao.searchEQWorkOrderHistoryListData(eQWorkOrderHistoryListGRPVO.getEQWorkOrderHistoryListINVO());
			  		
			eQWorkOrderHistoryListGRPVO.setCustomEQWorkOrderHistoryListVOS(customEQWorkOrderHistoryListVOS);   
			return eQWorkOrderHistoryListGRPVO;       
			  
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair History_Pop Up] searchEQWorkOrderHistoryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair History_Pop Up] searchEQWorkOrderHistoryListBasic"}).getMessage(),ex);
		}
	}  
	
	/**
	 * [EES_MNR_0023] Repair Estimate Creation의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO 	estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchEstimateSMRListBasic(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException {
		try { 
			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null; 
				
			estimateGRPVO.getEstimateINVO().setCurOfcCd(account.getOfc_cd());
			customMnrRprRqstHdrVOS = dbDao.searchEstimateSMRListData(estimateGRPVO.getEstimateINVO(),estimateGRPVO.getCurrSystem(),estimateGRPVO.getIsEDI());
				
			estimateGRPVO.setCustomMnrRprRqstHdrVOS(customMnrRprRqstHdrVOS);   
			return estimateGRPVO;          
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchEstimateSMRListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchEstimateSMRListBasic"}).getMessage(),ex);
		}
	} 
	
	/**
	 * [EES_MNR_0022] Repair Group Auditing의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchESTGroupAuditListBasic(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException {
		try { 
			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null; 
			estimateGRPVO.getEstimateINVO().setCurOfcCd(account.getOfc_cd());		
			customMnrRprRqstHdrVOS = dbDao.searchESTGroupAuditListData(estimateGRPVO.getEstimateINVO());
				
			estimateGRPVO.setCustomMnrRprRqstHdrVOS(customMnrRprRqstHdrVOS);   
			return estimateGRPVO; 	         
				
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Group Auditing] searchESTGroupAuditListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Group Auditing] searchESTGroupAuditListBasic"}).getMessage(),ex);
		}
	} 
	
	/**
	 * [EES_MNR_0019] Repair Estimate Creation의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO removeEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException {
		CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();  
			
		try {   
			//삭제로직 RQST_SEQ 단까지 모두 삭제한다.   
			dbDao.removeEstimateHDRData(customMnrRprRqstHdrVO); 
			dbDao.removeEstimateAllDTLData(customMnrRprRqstHdrVO); 
			 
			return estimateGRPVO;
		} catch (DAOException ex) {	   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] removeEstimateBasic"}).getMessage(),ex);
		} catch (Exception de) {	
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] removeEstimateBasic"}).getMessage(),de);
		} 	
	}	 
		
	/**
	 * [EES_MNR_0019] Repair Estimate Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO manageEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException{
		try {		
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();
			CustomMnrRprRqstDtlVO[] customMnrRprRqstDtlVOS = estimateGRPVO.getArrCustomMnrRprRqstDtlVOS(); 
			
			//공통의로 필요한것
			customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());
			customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
			//해당 키값이 오지 않았다면 NEW를 통해 온것 
			if(customMnrRprRqstHdrVO.getRprRqstSeq().equals("") && customMnrRprRqstHdrVO.getRprRqstVerNo().equals("")){
				List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = dbDao.checkEstimateHDRData(customMnrRprRqstHdrVO);
				//신규입력 데이타가 하나두 없을경우 
				if(customMnrRprRqstHdrVOS.size() == 0){    
					customMnrRprRqstHdrVO.setRprRqstSeq("1");  
					customMnrRprRqstHdrVO.setRprRqstVerNo("1");  
					if(!estimateGRPVO.getCurrSystem().equalsIgnoreCase("SPP")){
						customMnrRprRqstHdrVO.setRprStsCd("HS");  
					} else {
						customMnrRprRqstHdrVO.setRprStsCd("SS"); 
					}  	 
					customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y");
					customMnrRprRqstHdrVO.setCostOfcCd(account.getOfc_cd());
				/* 	2010 04-10 EQ체크 막음				 	
				} else if(!customMnrRprRqstHdrVOS.get(0).getRprStsCd().equalsIgnoreCase("HA") && !customMnrRprRqstHdrVOS.get(0).getRprStsCd().equalsIgnoreCase("HD") && customMnrRprRqstHdrVOS.get(0).getCostOfcCd().equalsIgnoreCase(account.getOfc_cd())){
					//이미 처리중인 데이타가 있다고 표시     
					throw new EventException(new ErrorHandler("MNR00211", new String[]{"EQ_NO : " + customMnrRprRqstHdrVO.getRqstEqNo()}).getMessage());
				*/			
				} else {	 	 
					//완료된건 새로 시작	 	
					int asIsRqstSeq = Integer.parseInt(customMnrRprRqstHdrVOS.get(0).getRprRqstSeq());
					customMnrRprRqstHdrVO.setRprRqstSeq(asIsRqstSeq + 1 + "");  
					customMnrRprRqstHdrVO.setRprRqstVerNo("1"); 
					if(!estimateGRPVO.getCurrSystem().equalsIgnoreCase("SPP")){
						customMnrRprRqstHdrVO.setRprStsCd("HS");  
					} else {
						customMnrRprRqstHdrVO.setRprStsCd("SS"); 
					} 
					customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y");  
					customMnrRprRqstHdrVO.setCostOfcCd(account.getOfc_cd());  
				}
				//*********  추가 요청사항 2009-11-20 Est No를 자동생성 START
				//규칙 123456(업체 고유 Code 6자리)-200911(해당년과월)-0001(해당원 발행순서) 
				if(customMnrRprRqstHdrVO.getRqstRefNo().equals("")){
					String vendSeq = customMnrRprRqstHdrVO.getVndrSeq();	
					StringBuffer tempLeftSpace = new StringBuffer("");
					for(int x = vendSeq.length(); x < 6;x++){ 	
						tempLeftSpace.append("0");						
					}			 			 	
					vendSeq = tempLeftSpace.toString() + vendSeq;  	
					String rqstRefNo = dbDao.searchRepairRqstRefNoData(vendSeq);  
					customMnrRprRqstHdrVO.setRqstRefNo(rqstRefNo);    
				}	
				//*********  추가 요청사항 2009-11-20 Est No를 자동생성 END 
				dbDao.addEstimateHDRData(customMnrRprRqstHdrVO);   
			//조회한 데이타를 수정을 하는경우  	
			} else {
				//*********  없으면 또 따준다. *********
				//규칙 123456(업체 고유 Code 6자리)-200911(해당년과월)-0001(해당원 발행순서) 
				if(customMnrRprRqstHdrVO.getRqstRefNo().equals("")){
					String vendSeq = customMnrRprRqstHdrVO.getVndrSeq();	
					StringBuffer tempLeftSpace = new StringBuffer("");
					for(int x = vendSeq.length(); x < 6;x++){ 	
						tempLeftSpace.append("0");						
					}			 			 	
					vendSeq = tempLeftSpace.toString() + vendSeq;  	
					String rqstRefNo = dbDao.searchRepairRqstRefNoData(vendSeq);  
					customMnrRprRqstHdrVO.setRqstRefNo(rqstRefNo);    
				}	
				   
				//헤더기존 데이타 수정    
				dbDao.modifyEstimateHDRData(customMnrRprRqstHdrVO);
				//디테일 기존데이타 삭제  
				dbDao.removeEstimateDTLData(customMnrRprRqstHdrVO);
			}	
			//디테일 뉴 데이타 삽입 
			if(customMnrRprRqstDtlVOS != null){
				List<CustomMnrRprRqstDtlVO> insertVoList = new ArrayList<CustomMnrRprRqstDtlVO>();
				List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = dbDao.checkEstimateDTLData(customMnrRprRqstHdrVO);
				if(customMnrRprRqstHdrVOS == null || customMnrRprRqstHdrVOS.size() == 0){
					for ( int i = 0; i < customMnrRprRqstDtlVOS.length; i++ ) {      
						customMnrRprRqstDtlVOS[i].setCreUsrId(account.getUsr_id());
						customMnrRprRqstDtlVOS[i].setUpdUsrId(account.getUsr_id());
						customMnrRprRqstDtlVOS[i].setRprRqstLstVerFlg("Y");
						customMnrRprRqstDtlVOS[i].setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
						customMnrRprRqstDtlVOS[i].setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
						customMnrRprRqstDtlVOS[i].setRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
						customMnrRprRqstDtlVOS[i].setRprRqstDtlSeq(i + 1 + ""); 
								
						//COST_CD 누락된건은 여기서 다시 넣어준다.
						if(customMnrRprRqstDtlVOS[i].getCostCd().equals("") || customMnrRprRqstDtlVOS[i].getCostCd() == null){
							if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqKndCd().equals("U")){
								if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqTpszCd().startsWith("D")){
									customMnrRprRqstDtlVOS[i].setCostCd("MRDRRC");    
								} else if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqTpszCd().startsWith("R")){
									CostCodeINVO costCodeINVO = new CostCodeINVO();
									//Component Code					
									costCodeINVO.setCmpoCd(customMnrRprRqstDtlVOS[i].getEqCmpoCd());
									//Tpsz										
									costCodeINVO.setTpSz(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqTpszCd());
										
									List<CustomCostCodeVO> customCostCodeVOS = dbDao.searchCostCodeData(costCodeINVO);
									if(customCostCodeVOS.size() > 0){		
										customMnrRprRqstDtlVOS[i].setCostCd(customCostCodeVOS.get(0).getCostCd());
									} else {										
										//DEFAULT
										customMnrRprRqstDtlVOS[i].setCostCd("MRRURC"); 
									}
								} else {
									customMnrRprRqstDtlVOS[i].setCostCd("MRDSRC");	
								}			
							} else if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqKndCd().equals("G")){
								customMnrRprRqstDtlVOS[i].setCostCd("MRGSRC"); 
							} else {
								customMnrRprRqstDtlVOS[i].setCostCd("MRZSRC");	
							}
						}	
						//COST_DTL_CD 누락된건은 여기서 다시 넣어준다.
						if(customMnrRprRqstDtlVOS[i].getCostDtlCd().equals("") || customMnrRprRqstDtlVOS[i].getCostDtlCd() == null){
							customMnrRprRqstDtlVOS[i].setCostDtlCd("NR");   
						}			 
						
						insertVoList.add(customMnrRprRqstDtlVOS[i]);  
					}   		 
					if ( insertVoList.size() > 0 ) { 	
						dbDao.addEstimateDTLData(insertVoList);
					}  
				}else{
					//MNR_RPR_RQST_DTL 테이블에 기존의 값에 중복되는 값이 입력될 경우 Insert 하지 않고 임의로 FLG 값을 반환한다.
					estimateGRPVO.setCurrDmgFlg("Y");
				}
			}
			//디테일 값 합계를 헤더 테이블에 넣는다 
			dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);  
			return estimateGRPVO;
		} catch (EventException e){ 
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] manageEstimateBasic"}).getMessage(),ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] manageEstimateBasic"}).getMessage(),de);
		} 
	}  
	
	/**
	 * [EES_MNR_0023] Repair Estimate Auditing의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO manageEstimateAuditItLaterBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException{
		try {					
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();
			CustomMnrRprRqstDtlVO[] customMnrRprRqstDtlVOS = estimateGRPVO.getArrCustomMnrRprRqstDtlVOS(); 
			
			//기존데이타의 EQ_DMG_TP_CD Y 마크						
			//Audit it Later 표시하기 위해 임시 사용 컬럼			
			customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());  
			dbDao.manageEstimateAuditItLaterData(customMnrRprRqstHdrVO);  
			dbDao.removeEstimateDTLData(customMnrRprRqstHdrVO);
			
			//디테일 뉴 데이타 삽입		 
			if(customMnrRprRqstDtlVOS != null){
				List<CustomMnrRprRqstDtlVO> insertVoList = new ArrayList<CustomMnrRprRqstDtlVO>();
				for ( int i = 0; i < customMnrRprRqstDtlVOS.length; i++ ) {      
					customMnrRprRqstDtlVOS[i].setCreUsrId(account.getUsr_id());
					customMnrRprRqstDtlVOS[i].setUpdUsrId(account.getUsr_id());
					customMnrRprRqstDtlVOS[i].setRprRqstLstVerFlg("Y");
					customMnrRprRqstDtlVOS[i].setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
					customMnrRprRqstDtlVOS[i].setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
					customMnrRprRqstDtlVOS[i].setRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
					customMnrRprRqstDtlVOS[i].setRprRqstDtlSeq(i + 1 + ""); 
					
					insertVoList.add(customMnrRprRqstDtlVOS[i]);  
				}	   		 
				if ( insertVoList.size() > 0 ) { 	
					dbDao.addEstimateDTLData(insertVoList);
				}  	  
			}
			//디테일 값 합계를 헤더 테이블에 넣는다 
			dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);  
			estimateGRPVO.setCustomMnrRprRqstHdrVO(customMnrRprRqstHdrVO); 
			return estimateGRPVO;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Auditing] manageEstimateAuditItLaterBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Auditing] manageEstimateAuditItLaterBasic"}).getMessage(),de);
		} 
	} 
	
	/**
	 * [EES_MNR_0019] Repair Estimate Creation의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO requestEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException{
		try {		
			CustomMnrRprRqstHdrVO[] arrCustomMnrRprRqstHdrVOS = estimateGRPVO.getArrCustomMnrRprRqstHdrVOS();
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;
			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = new ArrayList<CustomMnrRprRqstHdrVO>(); 
			
			for(int i = 0;i < arrCustomMnrRprRqstHdrVOS.length;i++){
				customMnrRprRqstHdrVO = arrCustomMnrRprRqstHdrVOS[i];
				customMnrRprRqstHdrVO.setRqstUsrId(account.getUsr_id()); 
				customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id()); 
				//input type은 받아온 값을 항상 유지
				if(estimateGRPVO.getCurrSystem().equals("SPP")){
					customMnrRprRqstHdrVO.setRprStsCd("SR"); 
				} else { 
					customMnrRprRqstHdrVO.setRprStsCd("HR");
				}
					
				//기존거 Last Version N 처리  
				dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO); 
				dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO); 
				
				customMnrRprRqstHdrVOS.add(customMnrRprRqstHdrVO);
			}	
				
			//HDR 입력 
			dbDao.addESTRequestHDRListData(customMnrRprRqstHdrVOS);
			//DTL 입력   
			dbDao.addESTRequestDTLListData(customMnrRprRqstHdrVOS);
			
			return estimateGRPVO;	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] requestEstimateBasic"}).getMessage(),ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] requestEstimateBasic"}).getMessage(),de);
		} 
	}   
	
	/**
	 * [EES_MNR_0023] Repair Estimate Auditing의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */ 
	public EstimateGRPVO counterOfferEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException{
		try {		
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();
			CustomMnrRprRqstDtlVO[] customMnrRprRqstDtlVOS = estimateGRPVO.getArrCustomMnrRprRqstDtlVOS(); 
				
			//공통의로 필요한것		
			customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());
			customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
			//기존데이타의 라스트 버젼 플레그 N	 
			dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO); 
			dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO); 
			
			//새로운 버젼 신규입력		 
			int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
			int asIsReviseNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprDtlStsCd());
			
			customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + ""); 		
			customMnrRprRqstHdrVO.setRprDtlStsCd(asIsReviseNo + 1 + "");  
			customMnrRprRqstHdrVO.setRprStsCd("HO");     
			customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y"); 
			customMnrRprRqstHdrVO.setAproOfcCd(customMnrRprRqstHdrVO.getCostOfcCd()); 
			dbDao.addEstimateHDRData(customMnrRprRqstHdrVO);	
			
			//디테일 뉴 데이타 삽입 
			if(customMnrRprRqstDtlVOS != null){ 
				List<CustomMnrRprRqstDtlVO> insertVoList = new ArrayList<CustomMnrRprRqstDtlVO>();
				for ( int i = 0; i < customMnrRprRqstDtlVOS.length; i++ ) {      
					customMnrRprRqstDtlVOS[i].setCreUsrId(account.getUsr_id());
					customMnrRprRqstDtlVOS[i].setUpdUsrId(account.getUsr_id());
					customMnrRprRqstDtlVOS[i].setRprRqstLstVerFlg("Y");
					customMnrRprRqstDtlVOS[i].setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
					customMnrRprRqstDtlVOS[i].setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
					customMnrRprRqstDtlVOS[i].setRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
					customMnrRprRqstDtlVOS[i].setRprRqstDtlSeq(i + 1 + ""); 
					
					insertVoList.add(customMnrRprRqstDtlVOS[i]);  
				}   		 
				if ( insertVoList.size() > 0 ) {	
					dbDao.addEstimateDTLData(insertVoList);
				}  	
			}
			
			//디테일 값 합계를 헤더 테이블에 넣는다 
			dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);
			 
			return estimateGRPVO;	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Auditing] counterOfferEstimateBasic"}).getMessage(),ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Auditing] counterOfferEstimateBasic"}).getMessage(),de);
		} 
	}   
	
	/**
	 * [EES_MNR_0023] Repair Estimate Auditing의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO rejectEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException{
		try {		
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();
			CustomMnrRprRqstDtlVO[] customMnrRprRqstDtlVOS = estimateGRPVO.getArrCustomMnrRprRqstDtlVOS(); 
				
			//공통의로 필요한것		
			customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());	
			customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
			//기존데이타의 라스트 버젼 플레그 N	 
			dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO); 
			dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO); 
					
			//새로운 버젼 신규입력		 
			int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
			int asIsReviseNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprDtlStsCd());
				
			customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + ""); 		
			customMnrRprRqstHdrVO.setRprDtlStsCd(asIsReviseNo + 1 + "");  
			customMnrRprRqstHdrVO.setRprStsCd("HJ"); 						 	     
			customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y");	 
			customMnrRprRqstHdrVO.setAproOfcCd(customMnrRprRqstHdrVO.getCostOfcCd());
			dbDao.addEstimateHDRData(customMnrRprRqstHdrVO);	
			
			//디테일 뉴 데이타 삽입 
			if(customMnrRprRqstDtlVOS != null){ 
				List<CustomMnrRprRqstDtlVO> insertVoList = new ArrayList<CustomMnrRprRqstDtlVO>();
				for ( int i = 0; i < customMnrRprRqstDtlVOS.length; i++ ) {      
					customMnrRprRqstDtlVOS[i].setCreUsrId(account.getUsr_id());
					customMnrRprRqstDtlVOS[i].setUpdUsrId(account.getUsr_id());
					customMnrRprRqstDtlVOS[i].setRprRqstLstVerFlg("Y");
					customMnrRprRqstDtlVOS[i].setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
					customMnrRprRqstDtlVOS[i].setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
					customMnrRprRqstDtlVOS[i].setRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
					customMnrRprRqstDtlVOS[i].setRprRqstDtlSeq(i + 1 + ""); 
						
					insertVoList.add(customMnrRprRqstDtlVOS[i]);  
				} 		  		 
				if ( insertVoList.size() > 0 ) {	
					dbDao.addEstimateDTLData(insertVoList);
				} 		 	
			}		
			
			//디테일 값 합계를 헤더 테이블에 넣는다 
			dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);
			 
			return estimateGRPVO;	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Auditing] rejectEstimateBasic"}).getMessage(),ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Auditing] rejectEstimateBasic"}).getMessage(),de);
		} 	
	}
		
	/**
	 * [EES_MNR_0022] Repair Group Auditing의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */   
	public EstimateGRPVO manageESTGroupAuditListBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException{
		try {	
			CustomMnrRprRqstHdrVO[] customMnrRprRqstHdrVOS = estimateGRPVO.getArrCustomMnrRprRqstHdrVOS(); 
			for(int i = 0;i < customMnrRprRqstHdrVOS.length;i ++){
				EstimateINVO estimateINVO = new EstimateINVO();
				estimateINVO.setRqstEqNo(customMnrRprRqstHdrVOS[i].getRqstEqNo());
				estimateINVO.setRprRqstSeq(customMnrRprRqstHdrVOS[i].getRprRqstSeq());
				estimateINVO.setRprRqstVerNo(customMnrRprRqstHdrVOS[i].getRprRqstVerNo());
				estimateINVO.setRprRqstLstVerFlg("Y");
				estimateINVO.setCurOfcCd(account.getOfc_cd());
				
				CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = dbDao.searchEstimateHRDData(estimateINVO);
				List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS = dbDao.searchIFEstimateDTLData(estimateINVO);
				
				//공통의로 필요한것		
				customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());	
				customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
				customMnrRprRqstHdrVO.setMnrRprRmk(customMnrRprRqstHdrVOS[i].getMnrRprRmk());
					
				dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO); 
				dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO); 
				
				//새로운 버젼 신규입력		 
				int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
				int asIsReviseNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprDtlStsCd());
				
				customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + ""); 		
				customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y");	 
				//reject
				if(estimateGRPVO.getGroupAuditAction().equals("Reject")){
					customMnrRprRqstHdrVO.setRprDtlStsCd(asIsReviseNo + 1 + "");
					customMnrRprRqstHdrVO.setRprStsCd("HJ");   	
				//approval
				} else {
					customMnrRprRqstHdrVO.setRprStsCd("HA");   
					customMnrRprRqstHdrVO.setAproOfcCd(account.getOfc_cd());
					customMnrRprRqstHdrVO.setAproUsrId(account.getUsr_id());
					java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
					String today = formatter.format(new java.util.Date()); 
					customMnrRprRqstHdrVO.setAproDt(today);  
				}  
				dbDao.addEstimateHDRData(customMnrRprRqstHdrVO);
				//TPB 사용을 위한 조회한값을 다시 넣는다.      
				customMnrRprRqstHdrVOS[i] = customMnrRprRqstHdrVO;
				 
				if(customMnrRprRqstDtlVOS != null){ 	
					for(int j = 0;j < customMnrRprRqstDtlVOS.size();j++){
						customMnrRprRqstDtlVOS.get(j).setCreUsrId(account.getUsr_id());
						customMnrRprRqstDtlVOS.get(j).setUpdUsrId(account.getUsr_id());
						customMnrRprRqstDtlVOS.get(j).setRprRqstLstVerFlg("Y");
						customMnrRprRqstDtlVOS.get(j).setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
						customMnrRprRqstDtlVOS.get(j).setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
						customMnrRprRqstDtlVOS.get(j).setRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
						customMnrRprRqstDtlVOS.get(j).setRprRqstDtlSeq(j + 1 + "");
						//쉬트에서 가져온것처럼 바꿔줌 
						if(customMnrRprRqstDtlVOS.get(j).getMnrLrAcctFlg().equals("N")){
							customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("0");
						} else {
							customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("1");
						}
							
						if(customMnrRprRqstDtlVOS.get(j).getN3ptyFlg().equals("N")){
							customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("0");	
						} else {	
							customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("0");	
						}	
					}		
					dbDao.addEstimateDTLData(customMnrRprRqstDtlVOS);
				}		 
					
				//디테일 값 합계를 헤더 테이블에 넣는다. 
				dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO); 
			}
			//TPB 사용을 위한 조회한값을 다시 넣는다.    
			estimateGRPVO.setArrCustomMnrRprRqstHdrVOS(customMnrRprRqstHdrVOS); 
			return estimateGRPVO;	
		} catch (DAOException ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Group Auditing] manageESTGroupAuditListBasic"}).getMessage(),ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Group Auditing] manageESTGroupAuditListBasic"}).getMessage(),de);
		} 
	}
	
	/**
	 * [EES_MNR_0027] Repair Cancellation and Deletion의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */  
	public RepairCollectionGRPVO manageEstimateCancelBasic(RepairCollectionGRPVO repairCollectionGRPVO, SignOnUserAccount account) throws EventException{
		try { 	
			CustomRepairCollectionVO[] customRepairCollectionVOS = repairCollectionGRPVO.getArrCustomRepairCollectionVOS(); 
			for(int i = 0;i < customRepairCollectionVOS.length;i ++){
				
				//****************** Approval Cancel *************************//
				EstimateINVO estimateINVO = new EstimateINVO();
				estimateINVO.setRqstEqNo(customRepairCollectionVOS[i].getRqstEqNo());
				estimateINVO.setRprRqstSeq(customRepairCollectionVOS[i].getRprRqstSeq());
				estimateINVO.setRprRqstVerNo(customRepairCollectionVOS[i].getRprRqstVerNo());
				estimateINVO.setRprRqstLstVerFlg("Y");
				estimateINVO.setCurOfcCd(account.getOfc_cd());
				
				CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = dbDao.searchEstimateHRDData(estimateINVO);
				List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS = dbDao.searchIFEstimateDTLData(estimateINVO);
				
				//공통의로 필요한것 		
				customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());	
				customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO); 
				dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO); 
					 
				//새로운 버젼 신규입력	 	 
				int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
					  
				//Approval Cancel HS상태로 저장 
				customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + ""); 		
				customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y");
				
				//SPP것도 처리 2009-10-06   SPP-W  MNR-M
				if(customMnrRprRqstHdrVO.getMnrInpTpCd().equalsIgnoreCase("W")){
					customMnrRprRqstHdrVO.setRprStsCd("SC");  
				} else {
					customMnrRprRqstHdrVO.setRprStsCd("HC");    
				}   
				customMnrRprRqstHdrVO.setAproDt("");     
				customMnrRprRqstHdrVO.setAproUsrId("");   
														
				//WORK ORDER 지워줌 	
				customMnrRprRqstHdrVO.setMnrOrdOfcCtyCd("");
				customMnrRprRqstHdrVO.setMnrOrdSeq("");    
				
				dbDao.addEstimateHDRData(customMnrRprRqstHdrVO); 	 
					
				if(customMnrRprRqstDtlVOS != null){ 	
					for(int j = 0;j < customMnrRprRqstDtlVOS.size();j++){
						customMnrRprRqstDtlVOS.get(j).setCreUsrId(account.getUsr_id());
						customMnrRprRqstDtlVOS.get(j).setUpdUsrId(account.getUsr_id());
						customMnrRprRqstDtlVOS.get(j).setRprRqstLstVerFlg("Y");
						customMnrRprRqstDtlVOS.get(j).setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
						customMnrRprRqstDtlVOS.get(j).setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
						customMnrRprRqstDtlVOS.get(j).setRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
						customMnrRprRqstDtlVOS.get(j).setRprRqstDtlSeq(j + 1 + "");
						//쉬트에서 가져온것처럼 바꿔줌 
						if(customMnrRprRqstDtlVOS.get(j).getMnrLrAcctFlg().equals("N")){
							customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("0");
						} else {
							customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("1");
						}	
						
						if(customMnrRprRqstDtlVOS.get(j).getN3ptyFlg().equals("N")){
							customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("0");	
						} else { 	
							customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("0");	
						}	 
					}	 
					dbDao.addEstimateDTLData(customMnrRprRqstDtlVOS);
				}
				
				//디테일 값 합계를 헤더 테이블에 넣는다 
				dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);   
				//****************** Approval Cancel *************************//
							
				//****************** Work Order Delete ***********************//
				if(!customRepairCollectionVOS[i].getWoNo().equals("") && customRepairCollectionVOS[i].getWoNo() != null){	
					CustomMnrOrdHdrVO customMnrOrdHdrVO = new CustomMnrOrdHdrVO();
					customMnrOrdHdrVO.setMnrOrdOfcCtyCd(customRepairCollectionVOS[i].getMnrOrdOfcCtyCd()); 
					customMnrOrdHdrVO.setMnrOrdSeq(customRepairCollectionVOS[i].getMnrOrdSeq());  
						
					dbDao.removeWOHeaderData(customMnrOrdHdrVO);     
					dbDao.removeWODetailData(customMnrOrdHdrVO); 
				}
				//****************** Work Order Delete ***********************//
			} 
			return repairCollectionGRPVO;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Cancellation and Deletion] manageEstimateCancelBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Cancellation and Deletion] manageEstimateCancelBasic"}).getMessage(),de);
		} 
	}
	
	/**
	 * [EES_MNR_0027] Repair Cancellation and Deletion의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */  
	public RepairCollectionGRPVO manageRepairDeleteBasic(RepairCollectionGRPVO repairCollectionGRPVO, SignOnUserAccount account) throws EventException{
		try { 	
			CustomRepairCollectionVO[] customRepairCollectionVOS = repairCollectionGRPVO.getArrCustomRepairCollectionVOS(); 
			RepairCollectionINVO repairCollectionINVO = repairCollectionGRPVO.getRepairCollectionINVO();
				
			for(int i = 0;i < customRepairCollectionVOS.length;i ++){
				if(repairCollectionINVO.getWoType().equals("EST")){ 
					//****************** Approval Delete *************************//
					EstimateINVO estimateINVO = new EstimateINVO();
					estimateINVO.setRqstEqNo(customRepairCollectionVOS[i].getRqstEqNo());
					estimateINVO.setRprRqstSeq(customRepairCollectionVOS[i].getRprRqstSeq());
					estimateINVO.setRprRqstVerNo(customRepairCollectionVOS[i].getRprRqstVerNo());
					estimateINVO.setRprRqstLstVerFlg("Y");
					estimateINVO.setCurOfcCd(account.getOfc_cd());
					
					CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = dbDao.searchEstimateHRDData(estimateINVO);
					List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS = dbDao.searchIFEstimateDTLData(estimateINVO);
						
					//공통의로 필요한것 		
					customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());	
					customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO); 
					dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO); 
					
					//새로운 버젼 신규입력	 	 
					int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
					
					//DELETE HD 상태로 저장 
					customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + ""); 		
					customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y");	 
					customMnrRprRqstHdrVO.setRprStsCd("HD");   
					customMnrRprRqstHdrVO.setAproDt("");    
					customMnrRprRqstHdrVO.setAproUsrId(""); 
					//WORK ORDER 지워줌 	
					customMnrRprRqstHdrVO.setMnrOrdOfcCtyCd("");
					customMnrRprRqstHdrVO.setMnrOrdSeq("");  
					  
					dbDao.addEstimateHDRData(customMnrRprRqstHdrVO);
					
					if(customMnrRprRqstDtlVOS != null){ 	
						for(int j = 0;j < customMnrRprRqstDtlVOS.size();j++){
							customMnrRprRqstDtlVOS.get(j).setCreUsrId(account.getUsr_id());
							customMnrRprRqstDtlVOS.get(j).setUpdUsrId(account.getUsr_id());
							customMnrRprRqstDtlVOS.get(j).setRprRqstLstVerFlg("Y");
							customMnrRprRqstDtlVOS.get(j).setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
							customMnrRprRqstDtlVOS.get(j).setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
							customMnrRprRqstDtlVOS.get(j).setRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
							customMnrRprRqstDtlVOS.get(j).setRprRqstDtlSeq(j + 1 + "");
							//쉬트에서 가져온것처럼 바꿔줌 
							if(customMnrRprRqstDtlVOS.get(j).getMnrLrAcctFlg().equals("N")){
								customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("0");
							} else {
								customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("1");
							}
							
							if(customMnrRprRqstDtlVOS.get(j).getN3ptyFlg().equals("N")){
								customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("0");	
							} else { 	
								customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("0");	
							}	 
						}	 
						dbDao.addEstimateDTLData(customMnrRprRqstDtlVOS);
					} 
					//디테일 값 합계를 헤더 테이블에 넣는다 
					dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);   
				}    
				//****************** Approval Delete *************************//
				
				//****************** Work Order Delete ***********************//
				if(!customRepairCollectionVOS[i].getWoNo().equals("") && customRepairCollectionVOS[i].getWoNo() != null){	
					CustomMnrOrdHdrVO customMnrOrdHdrVO = new CustomMnrOrdHdrVO();
					customMnrOrdHdrVO.setMnrOrdOfcCtyCd(customRepairCollectionVOS[i].getMnrOrdOfcCtyCd()); 
					customMnrOrdHdrVO.setMnrOrdSeq(customRepairCollectionVOS[i].getMnrOrdSeq());  
					
					dbDao.removeWOHeaderData(customMnrOrdHdrVO);      
					dbDao.removeWODetailData(customMnrOrdHdrVO);  
				}
				//****************** Work Order Delete ***********************//
			} 
			return repairCollectionGRPVO;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Cancellation and Deletion] manageRepairDeleteBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Cancellation and Deletion] manageRepairDeleteBasic"}).getMessage(),de);
		} 
	}
	
	/**
	 * [EES_MNR_0023] Repair Estimate Creation의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */	    
	public EstimateGRPVO approvalEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException{
		try {		
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();
			CustomMnrRprRqstDtlVO[] customMnrRprRqstDtlVOS = estimateGRPVO.getArrCustomMnrRprRqstDtlVOS(); 
			
			//공통의로 필요한것		
			customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());
			customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
			
			if(customMnrRprRqstHdrVO.getRprRqstSeq().equals("") && customMnrRprRqstHdrVO.getRprRqstVerNo().equals("")){
				List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = dbDao.checkEstimateHDRData(customMnrRprRqstHdrVO);
				//신규입력 데이타가 하나두 없을경우 
				if(customMnrRprRqstHdrVOS.size() == 0){     
					customMnrRprRqstHdrVO.setRprRqstSeq("1");  
					customMnrRprRqstHdrVO.setRprRqstVerNo("1");
				/* 	2010 04-10 EQ체크 막음						
				} else if(!customMnrRprRqstHdrVOS.get(0).getRprStsCd().equalsIgnoreCase("HA") && !customMnrRprRqstHdrVOS.get(0).getRprStsCd().equalsIgnoreCase("HD") && customMnrRprRqstHdrVOS.get(0).getCostOfcCd().equalsIgnoreCase(account.getOfc_cd())){
					//이미 처리중인 데이타가 있다고 표시     
					throw new EventException(new ErrorHandler("MNR00211", new String[]{"EQ_NO : " + customMnrRprRqstHdrVO.getRqstEqNo()}).getMessage());
				*/
				} else {			  	 
					//완료된건 새로 시작 	
					int asIsRqstSeq = Integer.parseInt(customMnrRprRqstHdrVOS.get(0).getRprRqstSeq());
					customMnrRprRqstHdrVO.setRprRqstSeq(asIsRqstSeq + 1 + "");  
					customMnrRprRqstHdrVO.setRprRqstVerNo("1");  
				}	
			} else {
			//새로운 버젼 신규입력 ==> 조회후 날라온거
				int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
				customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + "");
			}			
				
			//*********  추가 요청사항 2009-11-20 Est No를 자동생성 START
			//규칙 123456(업체 고유 Code 6자리)-200911(해당년과월)-0001(해당원 발행순서) 
			if(customMnrRprRqstHdrVO.getRqstRefNo().equals("")){
				String vendSeq = customMnrRprRqstHdrVO.getVndrSeq();	
				StringBuffer tempLeftSpace = new StringBuffer("");
				for(int x = vendSeq.length(); x < 6;x++){ 	
					tempLeftSpace.append("0");						
				}			 			 	
				vendSeq = tempLeftSpace.toString() + vendSeq;  	
				String rqstRefNo = dbDao.searchRepairRqstRefNoData(vendSeq);  
				customMnrRprRqstHdrVO.setRqstRefNo(rqstRefNo);    
			}			
			//*********  추가 요청사항 2009-11-20 Est No를 자동생성 END 
				
			//상위로 UPPER 되는 케이스	        
			if(!customMnrRprRqstHdrVO.getAproOfcCd().equalsIgnoreCase(account.getOfc_cd())){
				customMnrRprRqstHdrVO.setRprStsCd("HR");      
			} else { 	
				customMnrRprRqstHdrVO.setRprStsCd("HA"); 
				customMnrRprRqstHdrVO.setAproOfcCd(account.getOfc_cd());
				customMnrRprRqstHdrVO.setAproUsrId(account.getUsr_id());
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date()); 
				customMnrRprRqstHdrVO.setAproDt(today);  
			}	
			customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y");	
			
			//기존데이타의 라스트 버젼 플레그 N	  
			dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO);  
			dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO);  
			 
			dbDao.addEstimateHDRData(customMnrRprRqstHdrVO);
			 
			//디테일 값 합계를 헤더 테이블에 넣는다. 
			dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);  
				
			//디테일 뉴 데이타 삽입 
			if(customMnrRprRqstDtlVOS != null){	
				List<CustomMnrRprRqstDtlVO> insertVoList = new ArrayList<CustomMnrRprRqstDtlVO>();
				for ( int i = 0; i < customMnrRprRqstDtlVOS.length; i++ ) {      
					customMnrRprRqstDtlVOS[i].setCreUsrId(account.getUsr_id());
					customMnrRprRqstDtlVOS[i].setUpdUsrId(account.getUsr_id());
					customMnrRprRqstDtlVOS[i].setRprRqstLstVerFlg("Y");
					customMnrRprRqstDtlVOS[i].setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
					customMnrRprRqstDtlVOS[i].setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
					customMnrRprRqstDtlVOS[i].setRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
					customMnrRprRqstDtlVOS[i].setRprRqstDtlSeq(i + 1 + ""); 
					
					insertVoList.add(customMnrRprRqstDtlVOS[i]);  
				}   		 
				if ( insertVoList.size() > 0 ) {	
					dbDao.addEstimateDTLData(insertVoList);
				}     	
			}
				
			//디테일 값 합계를 헤더 테이블에 넣는다 
			dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);
			
			
			////////// ACEP 자동 생성 로직 Start //////////
			AcepChkHdrVO acepChkHdrVO = new AcepChkHdrVO();
			acepChkHdrVO.setEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
			acepChkHdrVO.setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
			acepChkHdrVO = dbDao.searchAcepChkHeaderInfo(acepChkHdrVO);
			
			if( "".equals(acepChkHdrVO.getAcepSeq()) ){
				String acepSeq = dbDao.searchAcepSeq();
				acepChkHdrVO.setAcepSeq(acepSeq);
				acepChkHdrVO.setMnrWoTpCd("EST");
				acepChkHdrVO.setCreUsrId(account.getUsr_id());
				acepChkHdrVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addAutoAcepChkHeaderInfo(acepChkHdrVO);
				dbDao.addAutoAcepChkDetailList(acepChkHdrVO);
			}
			////////// ACEP 자동 생성 로직 End //////////
			      
			estimateGRPVO.setCustomMnrRprRqstHdrVO(customMnrRprRqstHdrVO); 
			return estimateGRPVO;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Audit] approvalEstimateBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Audit] approvalEstimateBasic"}).getMessage(),de);
		} 
	}   
	
	/**
	 * [EES_MNR_0192] Repair Estimate Creation의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO 	estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchEstimateBasic(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException {
		CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;  
			
		try {    
			//헤더정보 조회		
			estimateGRPVO.getEstimateINVO().setCurOfcCd(account.getOfc_cd());
			customMnrRprRqstHdrVO = dbDao.searchEstimateHRDData(estimateGRPVO.getEstimateINVO()); 
			estimateGRPVO.setCustomMnrRprRqstHdrVO(customMnrRprRqstHdrVO) ; 
				
			//디테일 조회 	 
			List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS = null;
			customMnrRprRqstDtlVOS = dbDao.searchIFEstimateDTLData(estimateGRPVO.getEstimateINVO());
			estimateGRPVO.setCustomMnrRprRqstDtlVOS(customMnrRprRqstDtlVOS);
			return estimateGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchEstimateBasic"}).getMessage(),ex);
		} catch (	Exception ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchEstimateBasic"}).getMessage(),ex);
		}
	} 
	
	/**
	 * [EES_MNR_0211] Work Order의 정보를 조회 합니다. <br>
	 *
	 * @param WONoInquiryListGRPVO wONoInquiryListGRPVO
	 * @return WONoInquiryListGRPVO
	 * @exception EventException
	 */ 
	public WONoInquiryListGRPVO searchWONoInquiryListBasic(WONoInquiryListGRPVO wONoInquiryListGRPVO)throws EventException {
		try { 
			List<WONoInquiryVO> arrWONoInquiryVOS = dbDao.searchWONoInquiryListData(wONoInquiryListGRPVO);
			  		
			wONoInquiryListGRPVO.setArrWONoInquiryVOS(arrWONoInquiryVOS);   
			
			return wONoInquiryListGRPVO;       
			  
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Purchase W/O Inquiry - Popup] searchWONoInquiryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Purchase W/O Inquiry - Popup] searchWONoInquiryListBasic"}).getMessage(),ex);
		}
	}
	 
	/**
	 * [EES_MNR_0058] Extra Expense Work Order을 조회합니다.<br> 
	 * 
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @return GeneralWOGRPVO generalWOGRPVO
	 * @exception EventException
	 */ 	
	public GeneralWOGRPVO searchExtraWOBasic (GeneralWOGRPVO generalWOGRPVO)throws EventException {
		try { 
			List<CustomMnrOrdHdrVO> customMnrOrdHdrVOLst = dbDao.searchExtraWOHeaderData(generalWOGRPVO);
		
			generalWOGRPVO.setCustomMnrOrdHdrVOLst(customMnrOrdHdrVOLst);   
			if (generalWOGRPVO.getCustomMnrOrdHdrVOLst().size() > 0)
			{
				List<CustomMnrOrdDtlVO> customMnrOrdDtlVOLst = dbDao.searchExtraWODetailData(generalWOGRPVO);
				generalWOGRPVO.setCustomMnrOrdDtlVOLst(customMnrOrdDtlVOLst);  
			}
		} catch (DAOException de) { 
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Vessel Reefer Spare Part Purchase W/O Creation] searchExtraWOBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Vessel Reefer Spare Part Purchase W/O Creation] searchExtraWOBasic"}).getMessage(),de);
		} 
		 
		return generalWOGRPVO;     
	}
	
	/**
	 * [EES_MNR_0032] Repair Result creatioln by W/O의 정보를 조회 합니다. <br>
	 *
	 * @param RepairResultGRPVO repairResultGRPVO
	 * @return RepairResultGRPVO
	 * @exception EventException
	 */	
	public RepairResultGRPVO searchRepairResultListBasic (RepairResultGRPVO repairResultGRPVO)throws EventException {
		try { 
			List<RepairResultListVO> repairResultListVOLst  
				= dbDao.searchRepairResultListData(repairResultGRPVO);
				
			repairResultGRPVO.setRepairResultListVOLst(repairResultListVOLst);   
			return repairResultGRPVO;        
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Result creatioln by W/O] searchRepairResultListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Result creatioln by W/O] searchRepairResultListBasic"}).getMessage(),ex);
		}

	}	
     
	/**
	 * [EES_MNR_0032] Repair Result creatioln by W/O의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RepairResultGRPVO repairResultGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairResultGRPVO
	 * @exception EventException
	 */
	public RepairResultGRPVO manageRepairResultBasic(RepairResultGRPVO repairResultGRPVO, SignOnUserAccount account)throws EventException {
		
		try {		
			RepairResultListVO[] repairResultListVOS = repairResultGRPVO.getArrRepairResultListVOS(); 
			RepairResultINVO repairResultINVO = repairResultGRPVO.getRepairResultINVO();

			String agmtOfcCtyCd = account.getOfc_cd();
			if(agmtOfcCtyCd.length() >= 3){ 
				agmtOfcCtyCd = agmtOfcCtyCd.substring(0, 3);   
			}
			
			//디테일 뉴 데이타 삽입 
			if(repairResultListVOS != null){
				List<RepairResultListVO> insertVoList = new ArrayList<RepairResultListVO>();
				for ( int i = 0; i < repairResultListVOS.length; i++ ) {    
					if(repairResultListVOS[i].getIbflag().equals("U")){
						repairResultListVOS[i].setUpdUsrId(account.getUsr_id());
						repairResultListVOS[i].setMnrOrdOfcCtyCd(repairResultListVOS[i].getMnrOrdSeq().substring(0,3));
						repairResultListVOS[i].setMnrOrdSeq(repairResultListVOS[i].getMnrOrdSeq().substring(3));
						insertVoList.add(repairResultListVOS[i]);
					}
				}   	  
				if ( insertVoList.size() > 0 ) {	

					//다시입력한다.       
					dbDao.modifyRepairResultWODetailData(insertVoList);
				}  	
			}

			//TEMP VO
			if(!repairResultINVO.getMnrOrdSeq().equals(""))
			{
				repairResultINVO.setMnrOrdSeq(repairResultINVO.getMnrOrdSeq().substring(3));     
				repairResultINVO.setAgmtOfcCtyCd(repairResultINVO.getMnrOrdSeq().substring(0,3));
			}
			repairResultGRPVO.setRepairResultINVO(repairResultINVO);  
			
			return repairResultGRPVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Result creatioln by W/O] manageRepairResultBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Result creatioln by W/O] manageRepairResultBasic"}).getMessage(),de);
		} 
	}
	 
	/**
	 * [EES_MNR_0058] Simple W/O Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */
	public GeneralWOGRPVO manageExtraWOBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account)throws EventException {
		try {		
			
			CustomMnrOrdHdrVO customMnrOrdHdrVO = generalWOGRPVO.getCustomMnrOrdHdrVO();
			CustomMnrOrdDtlVO[] customMnrOrdDtlVOS = generalWOGRPVO.getArrCustomMnrOrdDtlVOS(); 
			//헤더에 데이타 세팅  


			//공통의로 필요한것
			customMnrOrdHdrVO.setCreUsrId(account.getUsr_id());
			customMnrOrdHdrVO.setUpdUsrId(account.getUsr_id());
		

			GeneralWOINVO generalWOINVO = generalWOGRPVO.getGeneralWOINVO();
			String agmtOfcCtyCd = account.getOfc_cd();
			if(agmtOfcCtyCd.length() >= 3){ 
				agmtOfcCtyCd = agmtOfcCtyCd.substring(0, 3);   
			}
			
			customMnrOrdHdrVO.setMnrGrpTpCd(generalWOINVO.getMnrGrpTpCd());
			customMnrOrdHdrVO.setMnrWoTpCd(generalWOINVO.getMnrWoTpCd());
				
			customMnrOrdHdrVO.setAgmtOfcCtyCd(generalWOINVO.getAgmtOfcCtyCd());
			customMnrOrdHdrVO.setAgmtSeq(generalWOINVO.getAgmtSeq());
			customMnrOrdHdrVO.setAgmtVerNo(generalWOINVO.getAgmtVerNo());
			
			customMnrOrdHdrVO.setEqKndCd(generalWOINVO.getEqKndCd());
			customMnrOrdHdrVO.setCostOfcCd(generalWOINVO.getCostOfcCd());
			customMnrOrdHdrVO.setCurrCd(generalWOINVO.getCurrCd());
			customMnrOrdHdrVO.setCostCd(generalWOINVO.getCostCd());
			customMnrOrdHdrVO.setOrdHdrRmk(generalWOINVO.getOrdHdrRmk());
			customMnrOrdHdrVO.setFileSeq(generalWOINVO.getFileSeq());
			String strMnrOrdSeq= customMnrOrdHdrVO.getMnrOrdSeq();
			//신규 INSERT 
			
			if(strMnrOrdSeq.equalsIgnoreCase("NEW") || strMnrOrdSeq.equalsIgnoreCase("")){
				//헤더 데이타 입력 
				//seq를 새로 딴다 신규건 이므로 
				customMnrOrdHdrVO.setMnrOrdOfcCtyCd(agmtOfcCtyCd);
				customMnrOrdHdrVO.setMnrOrdSeq(dbDao.searchMnrOrdSeqData()); 
			} else {
				customMnrOrdHdrVO.setMnrOrdOfcCtyCd(generalWOINVO.getMnrOrdSeq().substring(0,3)); 
				customMnrOrdHdrVO.setMnrOrdSeq(generalWOINVO.getMnrOrdSeq().substring(3)); 

			}
		    int intRprQty=0;
		    Double lngBzeAmt=0.00;
		    Double lngMnrAgmtAmt=0.00;
		    BigDecimal lngMnrWrkAmt = new BigDecimal("0"); 
			//디테일 뉴 데이타 삽입 
			if(customMnrOrdDtlVOS != null){
				List<CustomMnrOrdDtlVO> insertVoList = new ArrayList<CustomMnrOrdDtlVO>();
				for ( int i = 0; i < customMnrOrdDtlVOS.length; i++ ) {    
					if(!customMnrOrdDtlVOS[i].getIbflag().equals("D")){
						customMnrOrdDtlVOS[i].setCreUsrId(account.getUsr_id());
						customMnrOrdDtlVOS[i].setUpdUsrId(account.getUsr_id());
						customMnrOrdDtlVOS[i].setMnrOrdOfcCtyCd(customMnrOrdHdrVO.getMnrOrdOfcCtyCd());
						customMnrOrdDtlVOS[i].setMnrOrdSeq(customMnrOrdHdrVO.getMnrOrdSeq());
						customMnrOrdDtlVOS[i].getRprOffhFlg();
						if(customMnrOrdDtlVOS[i].getRprOffhFlg()==null || customMnrOrdDtlVOS[i].getRprOffhFlg().equalsIgnoreCase(""))
						customMnrOrdDtlVOS[i].setRprOffhFlg("N"); 
						customMnrOrdDtlVOS[i].setOrdDtlSeq(i + 1 + ""); 

						if(customMnrOrdDtlVOS[i].getRprQty()!=null && !customMnrOrdDtlVOS[i].getRprQty().equals(""))
							intRprQty=Integer.parseInt(customMnrOrdDtlVOS[i].getRprQty());
						
						if(customMnrOrdDtlVOS[i].getBzcAmt()!=null&& !customMnrOrdDtlVOS[i].getBzcAmt().equals(""))
							lngBzeAmt=Double.parseDouble(customMnrOrdDtlVOS[i].getBzcAmt());
						
						lngMnrAgmtAmt+=(intRprQty*lngBzeAmt);
						if(customMnrOrdDtlVOS[i].getCostAmt()!=null&& !customMnrOrdDtlVOS[i].getCostAmt().equals(""))
							lngMnrWrkAmt = lngMnrWrkAmt.add(new BigDecimal(customMnrOrdDtlVOS[i].getCostAmt()));
						customMnrOrdDtlVOS[i].setEqKndCd(generalWOINVO.getEqKndCd());
						insertVoList.add(customMnrOrdDtlVOS[i]); 
					}
				}   
				
				if(strMnrOrdSeq.equalsIgnoreCase("NEW") || strMnrOrdSeq.equalsIgnoreCase("")){
					if(!generalWOINVO.getFGubuns().equals("DTL"))
					{
						customMnrOrdHdrVO.setMnrAgmtAmt(String.valueOf(lngMnrAgmtAmt)); 
						customMnrOrdHdrVO.setMnrWrkAmt(String.valueOf(lngMnrWrkAmt)); 
						dbDao.addExtraWOHeaderData(generalWOGRPVO.getCustomMnrOrdHdrVO());
					}
				} else {
					if(!generalWOINVO.getFGubuns().equals("DTL"))
					{
						customMnrOrdHdrVO.setMnrAgmtAmt(String.valueOf(lngMnrAgmtAmt)); 
						customMnrOrdHdrVO.setMnrWrkAmt(String.valueOf(lngMnrWrkAmt)); 
						dbDao.modifyExtraWOHeaderData(generalWOGRPVO.getCustomMnrOrdHdrVO());
					}
				}				

				//모두 지우고        
				dbDao.removeWODetailData(customMnrOrdHdrVO);    
				if ( insertVoList.size() > 0 ) {	

					//다시입력한다.       
					dbDao.addExtraWODetailData(insertVoList);
				}  	
			}
	    	
	    	////////// ACEP 자동 생성 로직 Start //////////
	    	for( int idx = 0; idx < customMnrOrdDtlVOS.length; idx++ ){
	    		if( !customMnrOrdDtlVOS[idx].getIbflag().equals("D") && !"".equals(customMnrOrdDtlVOS[idx].getEqNo()) ){
			    	AcepChkHdrVO acepChkHdrVO = new AcepChkHdrVO();
					
					String acepSeq = dbDao.searchAcepSeq();
					acepChkHdrVO.setAcepSeq(acepSeq);
					acepChkHdrVO.setEqNo(customMnrOrdDtlVOS[idx].getEqNo());
					acepChkHdrVO.setMnrOrdOfcCtyCd(customMnrOrdDtlVOS[idx].getMnrOrdOfcCtyCd());
					acepChkHdrVO.setMnrOrdSeq(customMnrOrdDtlVOS[idx].getMnrOrdSeq());
					acepChkHdrVO.setOrdDtlSeq(customMnrOrdDtlVOS[idx].getOrdDtlSeq());
					acepChkHdrVO.setMnrWoTpCd("SPL");
					acepChkHdrVO.setCreUsrId(account.getUsr_id());
					acepChkHdrVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addAutoAcepChkHeaderInfo(acepChkHdrVO);
					dbDao.addAutoAcepChkDetailList(acepChkHdrVO);
	    		}
	    	}
	    	////////// ACEP 자동 생성 로직 End //////////
	    	
	    	
	    	//TEMP VO
	    	generalWOINVO.setMnrOrdSeq(customMnrOrdHdrVO.getMnrOrdSeq());     
	    	generalWOINVO.setAgmtOfcCtyCd(customMnrOrdHdrVO.getMnrOrdOfcCtyCd());
	    	generalWOGRPVO.setGeneralWOINVO(generalWOINVO);
			
			return generalWOGRPVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Simple W/O Creation] manageExtraWOBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Simple W/O Creation] manageExtraWOBasic"}).getMessage(),de);
		} 
	}
	
	/**
	 * [EES_MNR_0054] Vessel Reefer Spare Part Purchase W/O Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */
	public GeneralWOGRPVO manageRFSpareWOBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account)throws EventException {
		try {		
			CustomMnrOrdHdrVO customMnrOrdHdrVO = generalWOGRPVO.getCustomMnrOrdHdrVO();
			CustomMnrOrdDtlVO[] customMnrOrdDtlVOS = generalWOGRPVO.getArrCustomMnrOrdDtlVOS(); 

			//공통의로 필요한것
			customMnrOrdHdrVO.setCreUsrId(account.getUsr_id());
			customMnrOrdHdrVO.setUpdUsrId(account.getUsr_id());

			GeneralWOINVO generalWOINVO = generalWOGRPVO.getGeneralWOINVO();
			String agmtOfcCtyCd = account.getOfc_cd();
			if(agmtOfcCtyCd.length() >= 3){ 
				agmtOfcCtyCd = agmtOfcCtyCd.substring(0, 3);   
			}
			
			customMnrOrdHdrVO.setMnrGrpTpCd(generalWOINVO.getMnrGrpTpCd());
			customMnrOrdHdrVO.setMnrWoTpCd(generalWOINVO.getMnrWoTpCd());
				
			customMnrOrdHdrVO.setAgmtOfcCtyCd(generalWOINVO.getAgmtOfcCtyCd());
			customMnrOrdHdrVO.setAgmtSeq(generalWOINVO.getAgmtSeq());
			customMnrOrdHdrVO.setAgmtVerNo(generalWOINVO.getAgmtVerNo());
			
			customMnrOrdHdrVO.setEqKndCd(generalWOINVO.getEqKndCd());
			customMnrOrdHdrVO.setCostOfcCd(generalWOINVO.getCostOfcCd());
			customMnrOrdHdrVO.setCurrCd(generalWOINVO.getCurrCd());
			customMnrOrdHdrVO.setCostCd(generalWOINVO.getCostCd());
			customMnrOrdHdrVO.setOrdHdrRmk(generalWOINVO.getOrdHdrRmk());
			customMnrOrdHdrVO.setFileSeq(generalWOINVO.getFileSeq());
			
			customMnrOrdHdrVO.setSprPrtSplTpCd(generalWOINVO.getSprPrtSplTpCd());
			customMnrOrdHdrVO.setVslCd(generalWOINVO.getVslCd());
			customMnrOrdHdrVO.setSkdVoyNo(generalWOINVO.getSkdVoyNo());
			customMnrOrdHdrVO.setSkdDirCd(generalWOINVO.getSkdDirCd());
			customMnrOrdHdrVO.setSprPrtSplYdCd(generalWOINVO.getSprPrtSplYdCd());
			customMnrOrdHdrVO.setSprPrtSplDt(generalWOINVO.getSprPrtSplDt());
			
			String strMnrOrdSeq= customMnrOrdHdrVO.getMnrOrdSeq();
			
			//신규 INSERT 
			if(strMnrOrdSeq.equalsIgnoreCase("NEW") || strMnrOrdSeq.equalsIgnoreCase("")){
				//헤더 데이타 입력 
				//seq를 새로 딴다 신규건 이므로 
				customMnrOrdHdrVO.setMnrOrdOfcCtyCd(agmtOfcCtyCd);
				customMnrOrdHdrVO.setMnrOrdSeq(dbDao.searchMnrOrdSeqData()); 
			} else {
				customMnrOrdHdrVO.setMnrOrdOfcCtyCd(generalWOINVO.getMnrOrdSeq().substring(0,3)); 
				customMnrOrdHdrVO.setMnrOrdSeq(generalWOINVO.getMnrOrdSeq().substring(3)); 
			}
			
		    int intRprQty=0;
		    long lngBzeAmt=0;
		    long lngMnrAgmtAmt=0;
		    BigDecimal lngMnrWrkAmt = new BigDecimal("0"); 
			//디테일 뉴 데이타 삽입 
			if(customMnrOrdDtlVOS != null){
				List<CustomMnrOrdDtlVO> insertVoList = new ArrayList<CustomMnrOrdDtlVO>();
				for ( int i = 0; i < customMnrOrdDtlVOS.length; i++ ) {    
					if(!customMnrOrdDtlVOS[i].getIbflag().equals("D")){
						customMnrOrdDtlVOS[i].setCreUsrId(account.getUsr_id());
						customMnrOrdDtlVOS[i].setUpdUsrId(account.getUsr_id());
						customMnrOrdDtlVOS[i].setMnrOrdOfcCtyCd(customMnrOrdHdrVO.getMnrOrdOfcCtyCd());
						customMnrOrdDtlVOS[i].setMnrOrdSeq(customMnrOrdHdrVO.getMnrOrdSeq());

						if(customMnrOrdDtlVOS[i].getRprOffhFlg()==null || customMnrOrdDtlVOS[i].getRprOffhFlg().equalsIgnoreCase(""))
						customMnrOrdDtlVOS[i].setRprOffhFlg("N"); 
						customMnrOrdDtlVOS[i].setOrdDtlSeq(i + 1 + ""); 

						if(customMnrOrdDtlVOS[i].getRprQty()!=null && !customMnrOrdDtlVOS[i].getRprQty().equals(""))
							intRprQty=Integer.parseInt(customMnrOrdDtlVOS[i].getRprQty());
						
						if(customMnrOrdDtlVOS[i].getBzcAmt()!=null&& !customMnrOrdDtlVOS[i].getBzcAmt().equals(""))
							lngBzeAmt=Long.valueOf(customMnrOrdDtlVOS[i].getBzcAmt());
						lngMnrAgmtAmt+=(intRprQty*lngBzeAmt);
						if(customMnrOrdDtlVOS[i].getCostAmt()!=null&& !customMnrOrdDtlVOS[i].getCostAmt().equals(""))
							lngMnrWrkAmt = lngMnrWrkAmt.add(new BigDecimal(customMnrOrdDtlVOS[i].getCostAmt()));

						customMnrOrdDtlVOS[i].setEqKndCd(generalWOINVO.getEqKndCd());
						insertVoList.add(customMnrOrdDtlVOS[i]); 
					}
				}   	
				
				if(strMnrOrdSeq.equalsIgnoreCase("NEW") || strMnrOrdSeq.equalsIgnoreCase("")){
					if(!generalWOINVO.getFGubuns().equals("DTL"))
					{
						customMnrOrdHdrVO.setMnrAgmtAmt(String.valueOf(lngMnrAgmtAmt)); 
						customMnrOrdHdrVO.setMnrWrkAmt(String.valueOf(lngMnrWrkAmt)); 
						dbDao.addRFSpareWOHeaderData(generalWOGRPVO.getCustomMnrOrdHdrVO());
					}
				} else {
					if(!generalWOINVO.getFGubuns().equals("DTL"))
					{
						customMnrOrdHdrVO.setMnrAgmtAmt(String.valueOf(lngMnrAgmtAmt)); 
						customMnrOrdHdrVO.setMnrWrkAmt(String.valueOf(lngMnrWrkAmt)); 
						dbDao.modifyRFSpareWOHeaderData(generalWOGRPVO.getCustomMnrOrdHdrVO());
					}
				}				

				//모두 지우고        
				dbDao.removeWODetailData(customMnrOrdHdrVO);    
				if ( insertVoList.size() > 0 ) {	
					//다시입력한다.       
					dbDao.addRFSpareWODetailData(insertVoList);
				
				}  	
			}
			generalWOINVO.setMnrOrdSeq(customMnrOrdHdrVO.getMnrOrdSeq());     
			generalWOINVO.setAgmtOfcCtyCd(customMnrOrdHdrVO.getMnrOrdOfcCtyCd());
			generalWOGRPVO.setGeneralWOINVO(generalWOINVO);  
			
	    	return generalWOGRPVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Vessel Reefer Spare Part Purchase W/O Creation] manageRFSpareWOBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Vessel Reefer Spare Part Purchase W/O Creation] manageRFSpareWOBasic"}).getMessage(),de);
		} 
	}	
	 
	/**
	 * [EES_MNR_0058] Vessel Reefer Spare Part Purchase W/O Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */ 
	public GeneralWOGRPVO removeWOBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account)throws EventException {
		try {		
			CustomMnrOrdHdrVO customMnrOrdHdrVO = generalWOGRPVO.getCustomMnrOrdHdrVO();

			//공통의로 필요한것
			if(!account.getUsr_id().equals("") && account !=null)
			{
				GeneralWOINVO generalWOINVO = generalWOGRPVO.getGeneralWOINVO();
				customMnrOrdHdrVO.setMnrOrdOfcCtyCd(generalWOINVO.getMnrOrdSeq().substring(0,3)); 
				customMnrOrdHdrVO.setMnrOrdSeq(generalWOINVO.getMnrOrdSeq().substring(3)); 
				dbDao.removeWODetailData(customMnrOrdHdrVO);    
				dbDao.removeWOHeaderData(customMnrOrdHdrVO);

			}
			
			////////// ACEP 삭제 로직 Start//////////
			AcepChkHdrVO acepChkHdrVO = new AcepChkHdrVO();
			
			acepChkHdrVO.setMnrOrdOfcCtyCd(customMnrOrdHdrVO.getMnrOrdOfcCtyCd());
			acepChkHdrVO.setMnrOrdSeq(customMnrOrdHdrVO.getMnrOrdSeq());
			acepChkHdrVO.setMnrWoTpCd("SPL");
			
			//ACEP Check List Detail 내역 삭제
			dbDao.removeAcepChkDetailForWO(acepChkHdrVO);
			
			//ACEP Check List Header 내역 삭제
			dbDao.removeAcepChkHeaderForWO(acepChkHdrVO);
			////////// ACEP 삭제 로직 End //////////
			
			GeneralWOINVO generalWOINVO = generalWOGRPVO.getGeneralWOINVO();
			generalWOINVO.setMnrOrdSeq(customMnrOrdHdrVO.getMnrOrdSeq());     
			generalWOINVO.setAgmtOfcCtyCd(customMnrOrdHdrVO.getMnrOrdOfcCtyCd());
			generalWOGRPVO.setGeneralWOINVO(generalWOINVO);
			

			return generalWOGRPVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Vessel Reefer Spare Part Purchase W/O Creation] removeWOBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Vessel Reefer Spare Part Purchase W/O Creation] removeWOBasic"}).getMessage(),de);
		} 
	}	 
	
	/**
	 * [EES_MNR_0226] Simple W/O Inquiry Pop Up의 정보를 작업 합니다. <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */
	public GeneralWOGRPVO getBzcAmtBasic (GeneralWOGRPVO generalWOGRPVO)throws EventException {
		try { 
			List<CustomBzcAmtVO> customBzcAmtVOLst  
				= dbDao.getBzcAmtData(generalWOGRPVO);
			generalWOGRPVO.setCustomBzcAmtVOLST(customBzcAmtVOLst);   
			return generalWOGRPVO;				  	      
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Simple W/O Inquiry Pop Up] getBzcAmtBasic"}).getMessage(),ex);
		} catch (Exception e) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Simple W/O Inquiry Pop Up] getBzcAmtBasic"}).getMessage(),e);
		}	 
	}
	
	/**
	 * [EES_MNR_0023] Repair Estimate Creation의 정보를 조회 합니다. <br>
	 * 최근 6개월 같은건을 처리한 견적서를 조회 합니다.<br>
	 * @param EstimateGRPVO estimateGRPVO
	 * @return GeneralEventResponse
	 * @exception EventException
	 */ 
	public GeneralEventResponse searchLatestEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();  
		List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;  
			
		try {	  
			customMnrRprRqstHdrVOS = dbDao.searchLatestEstimateData(estimateGRPVO);
			//첫번째놈 가져오기때문에  	
			if(customMnrRprRqstHdrVOS.size() > 0){
				eventResponse.setETCData("RQST_EQ_NO",customMnrRprRqstHdrVOS.get(0).getRqstEqNo());
				eventResponse.setETCData("RPR_RQST_SEQ",customMnrRprRqstHdrVOS.get(0).getRprRqstSeq());
				eventResponse.setETCData("RPR_RQST_VER_NO",customMnrRprRqstHdrVOS.get(0).getRprRqstVerNo());
				eventResponse.setETCData("EQ_KND_CD",customMnrRprRqstHdrVOS.get(0).getEqKndCd());
				eventResponse.setETCData("RECENT_RPR_TP_CD",customMnrRprRqstHdrVOS.get(0).getRecentRprTpCd());
			}					
				
			return eventResponse;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchLatestEstimateBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchLatestEstimateBasic"}).getMessage(),e);
		}  
	} 	
	
	/**
	 * [EES_MNR_0036] M&R Document Transmission의 정보를 조회 합니다. <br>
	 *
	 * @param DocGRPVO docGRPVO
	 * @return DocGRPVO
	 * @exception EventException
	 */
	public DocGRPVO searchDocSendBasic(DocGRPVO docGRPVO) throws EventException {
		List<CustomDocHeaderVO> customDocHeaderVO = null;  
			
		try {  
			//헤더정보 조회	 
			customDocHeaderVO = dbDao.searchDocWOHeaderData(docGRPVO.getDocINVO()); 

			docGRPVO.setCustomDocHeaderVOs(customDocHeaderVO);
			return docGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Document Transmission] searchDocSendBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Document Transmission] searchDocSendBasic"}).getMessage(),e);
		}  
	} 	

	/**
	 * [EES_MNR_0036] M&R Document Transmission의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DocGRPVO docGRPVO
	 * @param SignOnUserAccount account
	 * @return DocGRPVO
	 * @exception EventException
	 */
	public DocGRPVO manageDocSendBasic(DocGRPVO docGRPVO, SignOnUserAccount account) throws EventException {

		try {  
			//헤더정보 조회	 
			dbDao.manageDocSendData(docGRPVO.getCustomMnrOrdHdrVO());
			
 			return docGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Document Transmission] manageDocSendBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Document Transmission] manageDocSendBasic"}).getMessage(),e);
		}  
	} 	

	/**
	 * [EES_MNR_0030] W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param ESTWOMainGRPVO eSTWOMainGRPVO
	 * @param SignOnUserAccount account
	 * @return ESTWOMainGRPVO
	 * @exception EventException
	 */
	public ESTWOMainGRPVO searchESTWorkOrderListBasic(ESTWOMainGRPVO eSTWOMainGRPVO, SignOnUserAccount account) throws EventException {
		try { 
			List<CustomESTWOMainSMRVO> listCustomESTWOMainSMRVO = dbDao.searchESTWOSMRData(eSTWOMainGRPVO, account);
			
			eSTWOMainGRPVO.setCustomESTWOMainSMRVO(listCustomESTWOMainSMRVO);   
			return eSTWOMainGRPVO;        
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[W/O Creation] searchESTWorkOrderListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[W/O Creation] searchESTWorkOrderListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0030] W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param ESTWOMainGRPVO eSTWOMainGRPVO
	 * @param SignOnUserAccount account
	 * @return ESTWOMainGRPVO
	 * @exception EventException
	 */
	public ESTWOMainGRPVO searchESTWorkOrderDetailListBasic(ESTWOMainGRPVO eSTWOMainGRPVO, SignOnUserAccount account) throws EventException {
		
		try { 
			List<CustomESTWOMainINFOVO> listCustomESTWOMainINFOVO = dbDao.searchESTWOINFOData(eSTWOMainGRPVO, account);
			
			eSTWOMainGRPVO.setCustomESTWOMainINFOVO(listCustomESTWOMainINFOVO);   
			return eSTWOMainGRPVO;        
				
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[W/O Creation] searchESTWorkOrderDetailListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[W/O Creation] searchESTWorkOrderDetailListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0030] W/O Creation의 정보를 작업 합니다. <br>
	 *
	 * @param ESTWOMainGRPVO eSTWOMainGRPVO
	 * @param SignOnUserAccount account
	 * @return ESTWOMainGRPVO
	 * @exception EventException
	 */ 
	public ESTWOMainGRPVO createESTWOCreationBasic(ESTWOMainGRPVO eSTWOMainGRPVO, SignOnUserAccount account) throws EventException{
		try {		
			CustomESTWOMainINFOVO[] arrayCustomESTWOMainINFOVOs = eSTWOMainGRPVO.getArrayCustomESTWOMainINFOVOs();

			if(arrayCustomESTWOMainINFOVOs != null){
				//W/O No 설정 시작
				String mnrOrdOfcCtyCd	= account.getOfc_cd().substring(0, 3);
				List<String> mnrOrdSeqList = new ArrayList<String>();
				//List<String> woNoList = new ArrayList();
				for ( int i = 0; i < arrayCustomESTWOMainINFOVOs.length; i++ ) {      
					mnrOrdSeqList.add(dbDao.searchMnrOrdSeqData());
				}
				//W/O No 설정 끝
                
				List<CustomESTWOMainINFOVO> insertVoList = new ArrayList<CustomESTWOMainINFOVO>();
				for ( int i = 0; i < arrayCustomESTWOMainINFOVOs.length; i++ ) {  
					arrayCustomESTWOMainINFOVOs[i].setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd);
					arrayCustomESTWOMainINFOVOs[i].setMnrOrdSeq(mnrOrdSeqList.get(i));
					arrayCustomESTWOMainINFOVOs[i].setCreUsrId(account.getUsr_id());
					arrayCustomESTWOMainINFOVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(arrayCustomESTWOMainINFOVOs[i]); 
				} 
				if ( insertVoList.size() > 0 ) {	
					dbDao.addESTWOCreationHeaderData(insertVoList);
					dbDao.addESTWOCreationDetailData(insertVoList);
					dbDao.modifyESTWOCreationHeaderData(insertVoList);
				}
				//저장후 W/O No 리턴 
				StringBuffer woNos = new StringBuffer(512);

				for (int i = 0; i < mnrOrdSeqList.size(); i++ ) {
					if(i==(mnrOrdSeqList.size()-1)) {
						woNos.append(mnrOrdOfcCtyCd).append(mnrOrdSeqList.get(i));
					} else {
						woNos.append(mnrOrdOfcCtyCd).append(mnrOrdSeqList.get(i)).append(",");
					}
				}
				eSTWOMainGRPVO.setWoNos(woNos.toString());    
			}
			return eSTWOMainGRPVO; 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[W/O Creation] createESTWOCreationBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[W/O Creation] createESTWOCreationBasic"}).getMessage(),de);
		} 
	}   
	


	/**
	 * [UDEVHJS_ALPSMNR_T_WESTIM] EDI Recieve 견적서를 견적서 테이블에 넣는다. <br>
	 *  
	 * @param InterfaceGRPVO interfaceGRPVO  
	 * @exception EventException
	 */		
	public void ediEstimateCopyToEstimateBasic(InterfaceGRPVO interfaceGRPVO) throws EventException{
		try {		
			CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVO();
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = interfaceGRPVO.getCheckCustomMnrRprRqstHdrVO();
			
			if(customMnrRprRqstHdrVO == null){	   
				//값이 업는경우 SEQ를 새로 딴다. SEQ 증가 
				customMnrRprRqstHdrVO = dbDao.searchEstimateSeqNewEqData(customMnrRprRqstTmpHdrVO);
			} else {	  
				//HA 이외의 것은 새로 넣는다.  VERSION 증가 
				CustomMnrRprRqstHdrVO tempCustomMnrRprRqstHdrVO = new CustomMnrRprRqstHdrVO();
				tempCustomMnrRprRqstHdrVO.setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo()); 
				tempCustomMnrRprRqstHdrVO.setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
				tempCustomMnrRprRqstHdrVO.setUpdUsrId(customMnrRprRqstTmpHdrVO.getUpdUsrId());
					
				//기존데이타의 라스트 버젼 플레그 N 
				dbDao.modifyESTHDRLastVersionUnFlagData(tempCustomMnrRprRqstHdrVO); 
				dbDao.modifyESTDTLLastVersionUnFlagData(tempCustomMnrRprRqstHdrVO); 
					
				//버젼만 증가  	
				int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
				customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + "");
			}	    
				
			//TMP HDR 에 있는 데이타를 견적서 HDR 에 넣는다.       
			dbDao.addEstimateHDRDataFromTmpData(customMnrRprRqstHdrVO,customMnrRprRqstTmpHdrVO);
			//TMP DTL에 있는 데이타를 견적서 DTL에 넣는다.   
			dbDao.addEstimateDTLDataFromTmpData(customMnrRprRqstHdrVO,customMnrRprRqstTmpHdrVO);
			//DTL에 합계를 헤더에 다시 맟춘다.		 
			dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);  
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate EDI] ediEstimateCopyToEstimateBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate EDI] ediEstimateCopyToEstimateBasic"}).getMessage(),de);
		} 
	}
	
	/**
	 * [EES_MNR_0194] Reefer Spare Part Summary List의 정보를 조회 합니다. <br>
	 *
	 * @param SparePartWOGRPVO sparePartWOGRPVO
	 * @return SparePartWOGRPVO
	 * @exception EventException
	 */
	public SparePartWOGRPVO searchWOInfoListBySparePartBasic(SparePartWOGRPVO sparePartWOGRPVO) throws EventException {
		try { 
			List<MnrOrderInfoBySparePartVO> mnrOrderInfoBySparePartVOS = null;
			  
			mnrOrderInfoBySparePartVOS = dbDao.searchWOInfoListBySparePartData(sparePartWOGRPVO.getSparePartWOINVO());
			  		
			sparePartWOGRPVO.setMnrOrderInfoBySparePartVOS(mnrOrderInfoBySparePartVOS);   
			return sparePartWOGRPVO;       
			  
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Reefer Spare Part Summary List] searchWOInfoListBySparePartBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Reefer Spare Part Summary List] searchWOInfoListBySparePartBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 수정 합니다.  <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyWEBInvoiceLinkBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account) throws EventException {
		try { 

			List<CustomMnrOrdDtlVO> insertVoList = new ArrayList<CustomMnrOrdDtlVO>();
			CustomMnrOrdDtlVO customMnrOrdDtlVO = new CustomMnrOrdDtlVO(); 
			
			if(generalWOGRPVO.getArrCustomMnrOrdDtlVOS() != null){
				CustomMnrOrdDtlVO[] arrCustomMnrOrdDtlVO = generalWOGRPVO.getArrCustomMnrOrdDtlVOS();
				for ( int i = 0; i < arrCustomMnrOrdDtlVO.length; i++ ) {
					customMnrOrdDtlVO = arrCustomMnrOrdDtlVO[0];
					
					arrCustomMnrOrdDtlVO[i].setCreUsrId(account.getUsr_id());
					
					// SQL 오류로그 제거작업, 신용찬, 2014-01-28
					// repair result date 가 날짜 형식이 아니면 null 로 강제 변경 (2013-10-10, 20131010 이 아닌 경우)
					if(arrCustomMnrOrdDtlVO[i].getRprRsltDt().length() != 10 &&  arrCustomMnrOrdDtlVO[i].getRprRsltDt().length() != 8) {
						arrCustomMnrOrdDtlVO[i].setRprRsltDt(null); // repair Result Date = null 
					}
					// SQL 오류로그 제거작업[종료]
					
					insertVoList.add(arrCustomMnrOrdDtlVO[i]);  
				}                 
			}
			if ( insertVoList.size() > 0 ) {  
			     if(account.getAccess_system().equals("ALP")){
			    	 dbDao.modifyWEBInvoiceLinkData(insertVoList);
			    	 		
			    	 //Confirm 일때만 DTL 추가 
			    	 if(generalWOGRPVO.getMnrInvStsCd().equals("HC")){
			    		 //하나의 Invoice No 처리시  Sale Tax 는 하나의 Other repair charge(511591) 로 반영되어 interface 됩니다.
				    	 //임으로 첫번째 워크오더의 511591 ACCT_CD로 행을 만들어준다. 
			    		 String slsTaxAmt = customMnrOrdDtlVO.getSlsTaxAmt().replaceAll(",", "");
				     	 
					     customMnrOrdDtlVO.setAcctCd("511591");
					     customMnrOrdDtlVO.setCostCd("MRSTOT");
					     customMnrOrdDtlVO.setInvAmt(slsTaxAmt);
					     customMnrOrdDtlVO.setEqKndCd("");  
					     customMnrOrdDtlVO.setEqTpszCd("");  
					     customMnrOrdDtlVO.setEqNo("");     
					     customMnrOrdDtlVO.setOrdDtlRmk("SALES TAX AUTO INPUT");
					     customMnrOrdDtlVO.setCostAmt("0");
					     customMnrOrdDtlVO.setRprQty("0");
					     customMnrOrdDtlVO.setRprOffhFlg("N"); 
					     customMnrOrdDtlVO.setCreUsrId(account.getUsr_id());
					     customMnrOrdDtlVO.setUpdUsrId(account.getUsr_id());
					     
					     //기존게 있다면 삭제 		
						 dbDao.removeWODetailByPayINVSeqData(customMnrOrdDtlVO);    
								 
					     //삽입	
						 if(!customMnrOrdDtlVO.getSlsTaxAmt().equals("") && Double.parseDouble(slsTaxAmt) != 0){
							 dbDao.addWODetailByPayINVSeqData(customMnrOrdDtlVO);	 
						 }
						 
						 String envChgTax = customMnrOrdDtlVO.getEnvChgTax().replaceAll(",", ""); 
						 
						 customMnrOrdDtlVO.setAcctCd("511591");
					     customMnrOrdDtlVO.setCostCd("MRSBCT");
					     customMnrOrdDtlVO.setInvAmt(envChgTax);
					     customMnrOrdDtlVO.setEqKndCd("");  
					     customMnrOrdDtlVO.setEqTpszCd("");  
					     customMnrOrdDtlVO.setEqNo("");     
					     customMnrOrdDtlVO.setOrdDtlRmk("SBC Tax");
					     customMnrOrdDtlVO.setCostAmt("0");
					     customMnrOrdDtlVO.setRprQty("0");
					     customMnrOrdDtlVO.setRprOffhFlg("N"); 
					     customMnrOrdDtlVO.setCreUsrId(account.getUsr_id());
					     customMnrOrdDtlVO.setUpdUsrId(account.getUsr_id());
					     
					     //삽입	
						 if(!customMnrOrdDtlVO.getEnvChgTax().equals("") && Double.parseDouble(envChgTax) != 0){
							 dbDao.addWODetailByPayINVSeqData(customMnrOrdDtlVO);	 
						 }
			    	 }
			     } else if(account.getAccess_system().equals("SPP")){
			    	 dbDao.modifyWEBInvoiceResultDTLinkData(insertVoList);
			     }		
			}  

		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation & Correction] modifyWEBInvoiceLinkBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation & Correction] modifyWEBInvoiceLinkBasic"}).getMessage(),e);
		}  
	}

	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 삭제 합니다.  <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyWEBInvoiceLinkClearBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account) throws EventException {
		try { 
			generalWOGRPVO.getCustomMnrOrdDtlVO().setUpdUsrId(account.getUsr_id());		
			dbDao.modifyWEBInvoiceLinkClearData(generalWOGRPVO.getCustomMnrOrdDtlVO());	
		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation & Correction] modifyWEBInvoiceLinkBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation & Correction] modifyWEBInvoiceLinkBasic"}).getMessage(),e);
		}  
	}
	
	/**
	 * [EDI Estimate Auditing]Repair Estimate Creation의 디테일정보만 정보 조회를 합니다. <br>
	 *
	 * @param EstimateGRPVO 	estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchEstimateDtl(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException {
		CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;  
		List<CustomMnrRprRqstVDtlVO> customMnrRprRqstVDtlVOS = null;
		try {    
			//헤더정보 조회	 
			customMnrRprRqstHdrVO = dbDao.searchEDIEstimateHRDData(estimateGRPVO.getEstimateINVO()); 
			estimateGRPVO.setCustomMnrRprRqstHdrVO(customMnrRprRqstHdrVO) ; 
			
			//디테일 조회 	 
			customMnrRprRqstVDtlVOS = dbDao.searchIFEstimateVDTLData(estimateGRPVO.getEstimateINVO());
			estimateGRPVO.setCustomMnrRprRqstVDtlVOS(customMnrRprRqstVDtlVOS);
			
			return estimateGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Auditing] searchEstimateDtl"}).getMessage(),ex);
		} catch (	Exception ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Auditing] searchEstimateDtl"}).getMessage(),ex);
		}
	} 

	/**
	 * [UDEVHJS_ALPSMNR_T_WESTIM] EDI Recieve 견적서를 견적서 테이블에 넣는다. <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return  CustomMnrRprRqstHdrVO
	 * @exception EventException
	 */
	public CustomMnrRprRqstHdrVO ediEstimateCopyToEstimateDetail(InterfaceGRPVO interfaceGRPVO) throws EventException{
		CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVO();
		CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = interfaceGRPVO.getCheckCustomMnrRprRqstHdrVO();
		try {
			if(customMnrRprRqstHdrVO == null){
				//값이 업는경우 SEQ를 새로 딴다. SEQ 증가
				customMnrRprRqstHdrVO = dbDao.searchEstimateSeqNewEqData(customMnrRprRqstTmpHdrVO);
			} else {
				//HA 이외의 것은 새로 넣는다.  VERSION 증가
				CustomMnrRprRqstHdrVO tempCustomMnrRprRqstHdrVO = new CustomMnrRprRqstHdrVO();
				tempCustomMnrRprRqstHdrVO.setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
				tempCustomMnrRprRqstHdrVO.setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
				tempCustomMnrRprRqstHdrVO.setUpdUsrId(customMnrRprRqstTmpHdrVO.getUpdUsrId());

				//기존데이타의 라스트 버젼 플레그 N
				dbDao.modifyESTHDRLastVersionUnFlagData(tempCustomMnrRprRqstHdrVO);
				dbDao.modifyESTDTLLastVersionUnFlagData(tempCustomMnrRprRqstHdrVO);

				//버젼만 증가
				int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
				customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + "");
			}

			//TMP HDR 에 있는 데이타를 견적서 HDR 에 넣는다.
			dbDao.addEstimateHDRDataFromTmpData(customMnrRprRqstHdrVO, customMnrRprRqstTmpHdrVO);
			//TMP DTL에 있는 데이타를 견적서 DTL에 넣는다.
			dbDao.addEstimateDTLDataFromTmpData(customMnrRprRqstHdrVO, customMnrRprRqstTmpHdrVO);
			//DTL에 합계를 헤더에 다시 맟춘다.
			dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate EDI] ediEstimateCopyToEstimateDetail"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate EDI] ediEstimateCopyToEstimateDetail"}).getMessage(),de);
		}
		return customMnrRprRqstHdrVO;
	}

	/**
	 * [UDEVHJS_ALPSMNR_T_WESTIM] TMP_DTL과 견적서DTL의 Labor Hour를 수정<br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param EstimateGRPVO estimateGRPVO
	 * @exception EventException
	 */
	public void modifyEstimateDTLTmpDTLBasic(InterfaceGRPVO interfaceGRPVO, EstimateGRPVO estimateGRPVO) throws EventException {
		try {
			dbDao.modifyEstimateTmpDTLData(interfaceGRPVO.getCustomMnrRprRqstTmpHdrVO(), estimateGRPVO.getEstimateINVO().getTmpSeq());
			dbDao.modifyEstimateDTLData(estimateGRPVO.getEstimateINVO());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate EDI] modifyEstimateDTLTmpDTLBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate EDI] modifyEstimateDTLTmpDTLBasic"}).getMessage(),de);
		}
	}
	
	/**
	 * [EES_MNR_0019] Repair Estimate 의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO 	estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchESTNextVerNoListBasic(EstimateGRPVO estimateGRPVO) throws EventException {
		try { 
			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = new ArrayList<CustomMnrRprRqstHdrVO>(); 
			CustomMnrRprRqstHdrVO list = new CustomMnrRprRqstHdrVO();
			CustomMnrRprRqstHdrVO[] arrCustomMnrRprRqstHdrVOS = estimateGRPVO.getArrCustomMnrRprRqstHdrVOS();
			
			for(int i = 0; i < arrCustomMnrRprRqstHdrVOS.length; i++){
				list = dbDao.checkESTNextVerNoData(arrCustomMnrRprRqstHdrVOS[i]);
				
				if(!"".equals(list.getRqstEqNo())&&list.getRqstEqNo()!=null){
					customMnrRprRqstHdrVOS.add(list);
				}
			}
			
			estimateGRPVO.setCustomMnrRprRqstHdrVOS(customMnrRprRqstHdrVOS);   
			return estimateGRPVO;          
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchEstimateSMRListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchEstimateSMRListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0023] Repair Estimate 의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO 	estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchESTApprovalNextVerNoListBasic(EstimateGRPVO estimateGRPVO) throws EventException {
		try { 
			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = new ArrayList<CustomMnrRprRqstHdrVO>(); 
			CustomMnrRprRqstHdrVO list = new CustomMnrRprRqstHdrVO();
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();
			
			list = dbDao.checkESTNextVerNoData(customMnrRprRqstHdrVO);
				
			if(!"".equals(list.getRqstEqNo())&&list.getRqstEqNo()!=null){
				customMnrRprRqstHdrVOS.add(list);
			}

			estimateGRPVO.setCustomMnrRprRqstHdrVOS(customMnrRprRqstHdrVOS);   
			return estimateGRPVO;          
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchEstimateSMRListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] searchEstimateSMRListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0023] Repair Estimate 의 썸네일 정보를 조회 합니다. <br>
	 *
	 * @param String fileSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchHtmlCodeForThumbnail(String fileSeq) throws EventException {
		String htmlCodeForThumbnail = new String();
		
		htmlCodeForThumbnail = dbDao.searchHtmlCodeForThumbnail(fileSeq);
		
		return htmlCodeForThumbnail;
	}
	
	/**
	 * [EES_MNR_0061] ACEP Check List 조회 <br>
	 *
	 * @param acepChkGrpVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public AcepChkGrpVO searchAcepChk(AcepChkGrpVO acepChkGrpVO,SignOnUserAccount account) throws EventException {
		AcepChkHdrVO acepChkHdrInfo = null;
		List<AcepChkDtlVO> acepChkDtlList = null;
		try {
			//헤더정보 조회
			acepChkHdrInfo = dbDao.searchAcepChkHeaderInfo(acepChkGrpVO.getAcepChkHdrVO());
			
			//디테일 조회
			acepChkDtlList = dbDao.searchAcepChkDetailList(acepChkGrpVO.getAcepChkHdrVO());
			
			acepChkGrpVO.setAcepChkHdrVO(acepChkHdrInfo);
			acepChkGrpVO.setAcepChkDtlVOs(acepChkDtlList);
			return acepChkGrpVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[ACEP Check List] searchAcepChk"}).getMessage(),ex);
		} catch (	Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[ACEP Check List] searchAcepChk"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0061] ACEP Check List Insert <br>
	 * @param acepChkGrpVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public AcepChkGrpVO manageAcepChk(AcepChkGrpVO acepChkGrpVO,SignOnUserAccount account) throws EventException{
		try {
			AcepChkHdrVO acepChkHdrVO = acepChkGrpVO.getAcepChkHdrVO();
			AcepChkDtlVO[] acepChkDtlVOs = acepChkGrpVO.getArrAcepChkDtlVOs();
			
			//공통의로 필요한것
			acepChkHdrVO.setCreUsrId(account.getUsr_id());
			acepChkHdrVO.setUpdUsrId(account.getUsr_id());
			
			//해당 키값이 오지 않았다면 NEW를 통해 온것 
			if( "".equals(acepChkHdrVO.getAcepSeq()) ){
				String acepSeq = dbDao.searchAcepSeq();
				acepChkHdrVO.setAcepSeq(acepSeq);
				
				
				dbDao.addAcepChkHeaderInfo(acepChkHdrVO);
				
				
				if(acepChkDtlVOs != null){
					List<AcepChkDtlVO> insertVoList = new ArrayList<AcepChkDtlVO>();
					for ( int idx = 0; idx < acepChkDtlVOs.length; idx++ ) {
						acepChkDtlVOs[idx].setAcepSeq(acepSeq);
						if( "1".equals(acepChkDtlVOs[idx].getAcepChk()) ){
							acepChkDtlVOs[idx].setInspChkFlg("Y");
						} else{
							acepChkDtlVOs[idx].setInspChkFlg("N");
						}
						
						acepChkDtlVOs[idx].setCreUsrId(account.getUsr_id());
						acepChkDtlVOs[idx].setUpdUsrId(account.getUsr_id());
						
						insertVoList.add(acepChkDtlVOs[idx]);  
					}   		 
					if ( insertVoList.size() > 0 ) {	
						dbDao.addAcepChkDetailList(insertVoList);
					}     	
				}
			} else{
				
				dbDao.removeAcepChkDetailList(acepChkHdrVO);
				
				
				if(acepChkDtlVOs != null){
					List<AcepChkDtlVO> insertVoList = new ArrayList<AcepChkDtlVO>();
					for ( int idx = 0; idx < acepChkDtlVOs.length; idx++ ) {
						if( "1".equals(acepChkDtlVOs[idx].getAcepChk()) ){
							acepChkDtlVOs[idx].setInspChkFlg("Y");
						} else{
							acepChkDtlVOs[idx].setInspChkFlg("N");
						}
						acepChkDtlVOs[idx].setCreUsrId(account.getUsr_id());
						acepChkDtlVOs[idx].setUpdUsrId(account.getUsr_id());
						
						insertVoList.add(acepChkDtlVOs[idx]);  
					}   		 
					if ( insertVoList.size() > 0 ) {	
						dbDao.addAcepChkDetailList(insertVoList);
					}     	
				}
			}
			
			//디테일 조회
			List<AcepChkDtlVO> acepChkDtlList = null;
			acepChkDtlList = dbDao.searchAcepChkDetailList(acepChkHdrVO);
			
			acepChkGrpVO.setAcepChkDtlVOs(acepChkDtlList);
			return acepChkGrpVO;
		} catch (EventException e){ 
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] manageEstimateBasic"}).getMessage(),ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] manageEstimateBasic"}).getMessage(),de);
		} 
	}
}