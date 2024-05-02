/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtBCImpl.java
*@FileTitle : Damage Flagging/Unflagging Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.10.28 김상수 [CHM-201114133-01] ALPS MNR->REPAIR Estimate 에서 EDI Upload 시 Man-Hour 계산로직 수정
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.VerifyTariffFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration.GeneralCodeCheckMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrGeneralCodeVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalPriceFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.SoldEQFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.VerifyEQFlagFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.VerifyEQTypeSizeFlagFileListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.VerifyRPRCreateFileListGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-OperationManage Business Logic Basic Command implementation<br>
 * - alps-OperationManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author park myoung sin
 * @see EES_MNR_0139EventResponse,EQFlagMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4 
 */
public class GeneralCodeCheckMgtBCImpl extends BasicCommandSupport implements GeneralCodeCheckMgtBC {

	// Database Access Object
	private transient GeneralCodeCheckMgtDBDAO dbDao = null;
	
	/**
	 * GeneralCodeCheckMgtBCImpl 객체 생성<br>
	 * GeneralCodeCheckMgtDBDAODAO를 생성한다.<br>
	 */
	public GeneralCodeCheckMgtBCImpl() {
		dbDao = new GeneralCodeCheckMgtDBDAO();
	}  
	
	/**
	 *[EES_MNR_S139]Repair Creation File Import_Pop Up의 정보를 검증 합니다.  <br>
	 * 	
	 * EES_MNR_S139화면에 대한 벨리데이션체크 이벤트 처리<br>
	 * @param  VerifyRPRCreateFileListGRPVO verifyRPRCreateFileListGRPVO
	 * @return VerifyRPRCreateFileListGRPVO
	 * @exception EventException  
	 */   
	public VerifyRPRCreateFileListGRPVO verifyRPRCreateFileListBasic(VerifyRPRCreateFileListGRPVO verifyRPRCreateFileListGRPVO) throws EventException {
		try { 
			List<CustomMnrDatVrfyVO> list = null;
			
			dbDao.modifyRPRCreateFileListByRPRData(verifyRPRCreateFileListGRPVO.getRPRCreateMgtINVO());  
			dbDao.modifyRPRCreateFileListByYDData(verifyRPRCreateFileListGRPVO.getRPRCreateMgtINVO());  
			dbDao.modifyRPRCreateFileListByWOData(verifyRPRCreateFileListGRPVO.getRPRCreateMgtINVO()); 
			   
			list = dbDao.searchRPRCreateFileListData(verifyRPRCreateFileListGRPVO.getRPRCreateMgtINVO().getTmpSeq(),verifyRPRCreateFileListGRPVO.getRPRCreateMgtINVO().getVndrSeq(),verifyRPRCreateFileListGRPVO.getRPRCreateMgtINVO().getCostOfcCd(),verifyRPRCreateFileListGRPVO.getRPRCreateMgtINVO().getInpMsg3()); 
			verifyRPRCreateFileListGRPVO.setCustomMnrDatVrfyVOS(list);
			return verifyRPRCreateFileListGRPVO; 
		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler(e).getMessage());
		}  
	}
	
	/**
	 * [EES_MNR_0023] Repair Estimate Creation의 정보를 체크 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */	
	public EstimateGRPVO verifyEstimateCalcBasic(EstimateGRPVO estimateGRPVO) throws EventException {
		try { 
			String ssCode = "SS"; 
			String slCode = "SL";
			String uhCode = "UH"; 
			String urCode = "UR"; 
			String umCode = "UM";
			
			List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS = null;    
			List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS = null;    
				
			//타입 벨리데이션  
			dbDao.modifyVerifyEstimateFileListByLocationData(estimateGRPVO.getEstimateINVO()); 
			dbDao.modifyVerifyEstimateFileListByComponentData(estimateGRPVO.getEstimateINVO()); 
			dbDao.modifyVerifyEstimateFileListByRepairData(estimateGRPVO.getEstimateINVO()); 
			dbDao.modifyVerifyEstimateFileListByDemageData(estimateGRPVO.getEstimateINVO()); 
			dbDao.modifyVerifyEstimateFileListByVolumeTypeData(estimateGRPVO.getEstimateINVO()); 
		    	   		
			//로직 벨리데이션 
			dbDao.calculateEstimateLaborRateData(estimateGRPVO.getEstimateINVO()); 
			dbDao.calculateEstimateLaborHourData(estimateGRPVO.getEstimateINVO());
			dbDao.calculateEstimateMaterialCostData(estimateGRPVO.getEstimateINVO()); 
			dbDao.modifyCalculateEstimateResultData(estimateGRPVO.getEstimateINVO());  
			//유저 입력 값이 없으면 베이직으로 카피 
			customMnrDatVrfyVOS = dbDao.searchVerifyEstimateCalcData(estimateGRPVO.getEstimateINVO());
			//나머지 벨리데이션	 	
			for ( int i = 0; i < customMnrDatVrfyVOS.size(); i++ ) {
				if(customMnrDatVrfyVOS.get(i).getInpMsg4().equalsIgnoreCase(ssCode)){
					//HOUR 언메치	 		
					if(1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg11().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg16().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(uhCode);  			
					}
					//레이트 언메치
					else if(1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg12().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg18().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(urCode);	 	
					} 
					//메터리얼 언메치	
					else if(1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg14().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg17().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(umCode);      	
					}
					//HOUR 작을경우 SL 
					else if(-1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg11().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg16().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(slCode);  
					}
					//레이트 작을경우 SL
					else if(-1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg12().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg18().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(slCode);	
					}	 
					//메터리얼 작을경우 SL
					else if(-1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg14().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg17().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(slCode);	      	
					}
				}		 	
			}			 		 	
			//결과값으로 수정	 		
			dbDao.modifyVerifyEstimateCalcData(customMnrDatVrfyVOS);
			
			//INP_MSG4 = 'NS'
			dbDao.modifyCalculateEstimateResultNs(estimateGRPVO.getEstimateINVO());

			//INP_MSG4 = 'NT'
			dbDao.modifyCalculateEstimateResultNt(estimateGRPVO.getEstimateINVO());
			
		    //리스트 다시 조회							 	
			customMnrRprRqstDtlVOS = dbDao.searchVerifyToEstimateDtlData(estimateGRPVO.getEstimateINVO()); 
			estimateGRPVO.setCustomMnrRprRqstDtlVOS(customMnrRprRqstDtlVOS);     
			
			return estimateGRPVO; 
		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] verifyEstimateCalcBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] verifyEstimateCalcBasic"}).getMessage(),e);
		}  
	}
	
	/**
	 * [EES_MNR_0139]Damage Flagging/Unflagging Pop Up의 정보를 체크 합니다. <br>
	 *
	 * @param VerifyEQFlagFileListGRPVO verifyEQFlagFileListGRPVO
	 * @return VerifyEQFlagFileListGRPVO
	 * @exception EventException
	 */
	public VerifyEQFlagFileListGRPVO verifyEQFlagFileListBasic(VerifyEQFlagFileListGRPVO verifyEQFlagFileListGRPVO) throws EventException {
		try { 
			List<CustomMnrDatVrfyVO> list = null;
			dbDao.modifyEQFlagFileListByEQData(verifyEQFlagFileListGRPVO.getEQFlagMgtINVO());  
			dbDao.modifyEQFlagFileListByYDData(verifyEQFlagFileListGRPVO.getEQFlagMgtINVO());  
			dbDao.modifyEQFlagFileListByFlagData(verifyEQFlagFileListGRPVO.getEQFlagMgtINVO()); 
			   
			list = dbDao.searchEQFlagFileListData(verifyEQFlagFileListGRPVO.getEQFlagMgtINVO().getTmpSeq()); 
			verifyEQFlagFileListGRPVO.setCustomMnrDatVrfyVOS(list);  
			
			return verifyEQFlagFileListGRPVO; 
		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Damage Flagging/Unflagging Pop Up] verifyEQFlagFileListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Damage Flagging/Unflagging Pop Up] verifyEQFlagFileListBasic"}).getMessage(),e);
		}  
	}
	
	/**
	 * [EES_MNR_0221]Sold Creation File Import_Pop Up 의 정보를 작업 합니다. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */ 
	public String createMnrTempBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO,SignOnUserAccount account) throws EventException {
		String seqValue  = "";
		try {  
			List<CustomMnrDatVrfyVO> insertVoList = new ArrayList<CustomMnrDatVrfyVO>();
			           
			seqValue = dbDao.addMnrTempSequenceData();
			for ( int i=0; i < generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS().length; i++ ) {
					generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].setTmpSeq(seqValue);   
					generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].setCreUsrId(account.getUsr_id());
					generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].setUpdUsrId(account.getUsr_id());
					generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].setTmpDtlSeq((i + 1) + "");     
					insertVoList.add(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i]);
			} 			           
			if ( insertVoList.size() > 0 ) {          
				dbDao.addMnrTempData(insertVoList);   
			} 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Creation File Import_Pop Up ] createMnrTempBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Creation File Import_Pop Up ] createMnrTempBasic"}).getMessage(),de);
		} 
		return seqValue;
	}
	
	/**
	 * [EES_MNR_0226]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 체크 합니다. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @return GeneralCodeCheckMgtGRPVO
	 * @exception EventException
	 */  
	public GeneralCodeCheckMgtGRPVO checkGeneralCodeBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO) throws EventException {
		try {   
			List<CustomMnrGeneralCodeVO> list = null;
			if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("OFC")){
				list = dbDao.checkOfficeCodeData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("EQN")){
				list = dbDao.checkEQNumberData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());	
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("ESTEQN")){
				list = dbDao.checkESTEQNumberData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("YARD")){
				list = dbDao.checkYardCodeData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO()); 
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("LOC")){
				list = dbDao.checkLocCodeData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO()); 
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("MLOC")){
				list = dbDao.checkMdmLocCodeData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO()); 
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("COMP")){
				list = dbDao.checkComponentCodeData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());  
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("LANE")){
				list = dbDao.checkLaneCodeData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());  
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("DSPEQN")){
				list = dbDao.checkDSPEQNumberData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());  
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("WORKORD")){
				list = dbDao.checkWorkOrderDtlData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());  
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("TTLEQN")){
				list = dbDao.checkTLLEQNumberData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO()); 
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("SLDYARD")){
				list = dbDao.checkSldYardCodeData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO()); 
			} else if(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getCheckType().equals("CNT")){
				list = dbDao.checkCountryCodeData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO()); 
			}
			
			generalCodeCheckMgtGRPVO.setCustomMnrGeneralCodeVOS(list);  
			
			return generalCodeCheckMgtGRPVO; 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Vessel Reefer Spare Part Purchase W/O Creation] checkGeneralCodeBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Vessel Reefer Spare Part Purchase W/O Creation] checkGeneralCodeBasic"}).getMessage(),de);
		} 
	}

	/**
	 * [EES_MNR_0143]M&R Invoice Creation File Import Pop Up의 정보를 체크 합니다. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralCodeCheckMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeCheckMgtGRPVO verifyPayableInvoiceFileListBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO, SignOnUserAccount account) throws EventException {

		try {  

			List<CustomMnrDatVrfyVO> list = null;
			
			generalCodeCheckMgtGRPVO.getGeneralCodeINVO().setUserOfcCd(account.getOfc_cd());
			
			dbDao.modifyPayableInvoiceFileListByWOData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());  
			dbDao.modifyPayableInvoiceFileListByOFCData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());  
			dbDao.modifyPayableInvoiceFileListByVNDRData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());  			
			dbDao.modifyPayableInvoiceFileListByWOAmtData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());  			
			
			dbDao.modifyPayableInvoiceFileListData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO());  
  
			list = dbDao.searchPayableInvoiceFileListData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getTmpSeq()); 
			generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyListVO(list);  
			    
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation File Import Pop Up] verifyPayableInvoiceFileListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation File Import Pop Up] verifyPayableInvoiceFileListBasic"}).getMessage(),e);
		}  
		return generalCodeCheckMgtGRPVO; 
	} 
	
	/**
	 * [EES_MNR_0219] M&R Simple WO File Import Pop_Up의 정보를 체크 합니다. <br>
	 *
	 * @param VerifyEQTypeSizeFlagFileListGRPVO verifyEQTypeSizeFlagFileListGRPVO
	 * @return VerifyEQTypeSizeFlagFileListGRPVO
	 * @exception EventException
	 */
	public VerifyEQTypeSizeFlagFileListGRPVO verifyWOFileListBasic(VerifyEQTypeSizeFlagFileListGRPVO verifyEQTypeSizeFlagFileListGRPVO) throws EventException {
		try { 
			List<CustomMnrDatVrfyVO> list = null;
			dbDao.modifyWOFileListByEQData(verifyEQTypeSizeFlagFileListGRPVO.getEQFlagMgtINVO());  
			dbDao.modifyWOFileListByYDData(verifyEQTypeSizeFlagFileListGRPVO.getEQFlagMgtINVO());  
			dbDao.modifyWOFileListByIssueData(verifyEQTypeSizeFlagFileListGRPVO.getEQFlagMgtINVO()); 
			   
			list = dbDao.searchWOFileListData(verifyEQTypeSizeFlagFileListGRPVO.getEQFlagMgtINVO().getTmpSeq()); 
			verifyEQTypeSizeFlagFileListGRPVO.setCustomMnrDatVrfyVOS(list);  
			    
			return verifyEQTypeSizeFlagFileListGRPVO; 
		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Simple WO File Import Pop_Up] verifyWOFileListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Simple WO File Import Pop_Up] verifyWOFileListBasic"}).getMessage(),e);
		}  
	}
	
	/**
	 * [EES_MNR_0220]Disposal Price File Import_Pop Up의 정보를 체크 합니다. <br>
	 *
	 * @param DisposalPriceFileListGRPVO disposalPriceFileListGRPVO
	 * @return DisposalPriceFileListGRPVO
	 * @exception EventException
	 */
	public DisposalPriceFileListGRPVO verifyDisposalPriceFileListBasic(DisposalPriceFileListGRPVO disposalPriceFileListGRPVO) throws EventException {
		try { 
			List<CustomMnrDatVrfyVO> list = null;
			list = dbDao.searchDisposalPriceFileListData(disposalPriceFileListGRPVO.getEQFlagMgtINVO().getTmpSeq()); 
			dbDao.modifyDisposalPriceFileListData(list);  
			
			//dbDao.modifyEQFlagFileListByEQData(disposalPriceFileListGRPVO.getEQFlagMgtINVO());  
			   
			list = dbDao.searchDisposalPriceFileListData(disposalPriceFileListGRPVO.getEQFlagMgtINVO().getTmpSeq()); 
			disposalPriceFileListGRPVO.setCustomMnrDatVrfyVOS(list);  
			    
			return disposalPriceFileListGRPVO; 
		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Price File Import_Pop Up] verifyDisposalPriceFileListBasic"}).getMessage(),ex);
		}
		catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Price File Import_Pop Up] verifyDisposalPriceFileListBasic"}).getMessage(),e);
		}  
	}
	
	/**
	 * [EES_MNR_0190]Standard Tariff File Import_Pop Up의 정보를 작업 합니다. <br>
	 *
	 * @param VerifyTariffFileListGRPVO verifyTariffFileListGRPVO
	 * @return VerifyTariffFileListGRPVO
	 * @exception EventException
	 */
	public VerifyTariffFileListGRPVO verifyTariffFileListBasic(VerifyTariffFileListGRPVO verifyTariffFileListGRPVO) throws EventException {
		try { 
			List<CustomMnrDatVrfyVO> list = null;
			dbDao.modifyVerifyTariffFileListByCostGroupData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());	//CostGroup(Code)  
			dbDao.modifyVerifyTariffFileListByComponentData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());	//Component(Code)
			dbDao.modifyVerifyTariffFileListByRepairData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());		//Repair(Code)
			dbDao.modifyVerifyTariffFileListByDivData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());			//Div(Code)
			dbDao.modifyVerifyTariffFileListByRangeTypeData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());	//RangeType(First Volume)
			dbDao.modifyVerifyTariffFileListByRangeTypeLData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());	//RangeType(Additional Volume)
			dbDao.modifyVerifyTariffFileListByVolumeTypeData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());	//VolumeType(Type:Qty/Size)
			dbDao.modifyVerifyTariffFileListBySizeSquareData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());	//Size/Square (Fr/To)  
			dbDao.modifyVerifyTariffFileListByManHourData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());		//Man-Hour(>0.01)  
			   
			list = dbDao.searchVerifyTariffFileListData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO().getTmpSeq()); 
			verifyTariffFileListGRPVO.setCustomMnrDatVrfyVOS(list);  
			    
			return verifyTariffFileListGRPVO;
			
		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Local Tariff File Import_Pop Up] verifyTariffFileListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Local Tariff File Import_Pop Up] verifyTariffFileListBasic"}).getMessage(),e);
		}  
	} 
	
	/**
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 작업 합니다. <br>
	 *
	 * @param VerifyTariffFileListGRPVO verifyTariffFileListGRPVO
	 * @return VerifyTariffFileListGRPVO
	 * @exception EventException
	 */
	public VerifyTariffFileListGRPVO verifyLocalTariffFileListBasic(VerifyTariffFileListGRPVO verifyTariffFileListGRPVO) throws EventException {
		try { 
			List<CustomMnrDatVrfyVO> list = null;
			dbDao.modifyVerifyLocalTariffFileListByCountData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());			//Count Unmatch
			dbDao.modifyVerifyLocalTariffFileListByStandardTariffData(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());	//Standard Tariff Unmatch
			dbDao.modifyVerifyLocalTariffManHourByStandardTariff(verifyTariffFileListGRPVO.getVerifyTariffFileListINVO());		//Standard Tariff Man-Hour Unmatch
			
			String tmpSeq   = verifyTariffFileListGRPVO.getVerifyTariffFileListINVO().getTmpSeq();
			String stdTrfNo = verifyTariffFileListGRPVO.getVerifyTariffFileListINVO().getStdTrfNo();
			list = dbDao.searchVerifyLocalTariffFileListData(tmpSeq, stdTrfNo); 
			verifyTariffFileListGRPVO.setCustomMnrDatVrfyVOS(list);  
			
			return verifyTariffFileListGRPVO;
			
		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Local Tariff File Import_Pop Up] verifyLocalTariffFileListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Local Tariff File Import_Pop Up] verifyLocalTariffFileListBasic"}).getMessage(),e);
		}  
	} 
	
	/**
	 * [EES_MNR_0221]Sold Creation File Import_Pop Up 의 정보를 체크 합니다. <br>
	 *
	 * @param SoldEQFileListGRPVO soldEQFileListGRPVO
	 * @return SoldEQFileListGRPVO
	 * @exception EventException
	 */          
	public SoldEQFileListGRPVO verifySoldEQFileListBasic(SoldEQFileListGRPVO soldEQFileListGRPVO) throws EventException {
		try { 
			dbDao.modifyVerifySoldEQFileListByEQNoData(soldEQFileListGRPVO);	//EQ No  
			dbDao.modifyVerifySoldEQFileListByYardData(soldEQFileListGRPVO);	//Yard
			   
			List<CustomMnrDatVrfyVO> list = null;
			list = dbDao.searchVerifySoldEQFileListData(soldEQFileListGRPVO.getSoldEQFileListINVO().getTmpSeq()); 
			soldEQFileListGRPVO.setListCustomMnrDatVrfyVO(list);  
			    
			return soldEQFileListGRPVO;
			
		} catch (DAOException ex) {          
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Creation File Import_Pop Up ] verifySoldEQFileListBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Sold Creation File Import_Pop Up ] verifySoldEQFileListBasic"}).getMessage(),e);
		}  
	}    
	
	/**
	 * [EES_MNR_0141]M&R Invoice 금액을 환율변경적용 합니다. <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralCodeCheckMgtGRPVO
	 * @exception EventException
	 */
	public GeneralCodeCheckMgtGRPVO searchPayableINVInquiryCalCurrRateBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO, SignOnUserAccount account) throws EventException {

		try {  

			List<CustomMnrDatVrfyVO> list = null;
			
			generalCodeCheckMgtGRPVO.getGeneralCodeINVO().setUserOfcCd(account.getOfc_cd());
			
			list = dbDao.searchPayableINVInquiryCalCurrRateData(generalCodeCheckMgtGRPVO.getGeneralCodeINVO().getTmpSeq()); 
			generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyListVO(list);  
			    
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation & Correction] searchPayableINVInquiryCalCurrRateBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Invoice Creation& Correction] searchPayableINVInquiryCalCurrRateBasic"}).getMessage(),e);
		}  
		return generalCodeCheckMgtGRPVO; 
	} 
	
	/**
	  * [EES_MNR_0252]EDI Estimate Group Auditing의 EDI정보 처리 작업 합니다. <br>
	  *
	  * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	  * @param SignOnUserAccount account
	  * @return String
	  * @exception EventException
	  */ 
	 public String createMnrTempDetail(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO,SignOnUserAccount account) throws EventException {
		  String seqValue  = "";
			  try {  
			   List<CustomMnrDatVrfyVO> insertVoList = new ArrayList<CustomMnrDatVrfyVO>();
			            
			   seqValue = dbDao.addMnrTempSequenceData();
			   for ( int i=0; i < generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS().length; i++ ) {
				 CustomMnrDatVrfyVO customMnrDatVrfyVOs = new CustomMnrDatVrfyVO(); 
				 				 
				 generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].setTmpSeq(seqValue);
			     generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].setTmpDtlSeq((i + 1) + "");     
			        
			     //배열에 값이 2건 이상인 경우 데이터가 최종값만 들어가서 다시 새로운 VO에 Set
			     customMnrDatVrfyVOs.setTmpSeq(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getTmpSeq());
			     customMnrDatVrfyVOs.setCreUsrId(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getCreUsrId());
			     customMnrDatVrfyVOs.setUpdUsrId(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getUpdUsrId());
			     customMnrDatVrfyVOs.setTmpDtlSeq(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getTmpDtlSeq());			     
			     customMnrDatVrfyVOs.setInpMsg1(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg1());
				 customMnrDatVrfyVOs.setInpMsg2(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg2());
				 customMnrDatVrfyVOs.setInpMsg3(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg3());
				 customMnrDatVrfyVOs.setInpMsg4(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg4());
				 customMnrDatVrfyVOs.setInpMsg5(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg5());
				 customMnrDatVrfyVOs.setInpMsg6(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg6());
				 customMnrDatVrfyVOs.setInpMsg7(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg7());
				 customMnrDatVrfyVOs.setInpMsg8(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg8());
				 customMnrDatVrfyVOs.setInpMsg9(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg9());
				 customMnrDatVrfyVOs.setInpMsg10(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg10());
				 
				 customMnrDatVrfyVOs.setInpMsg11(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg11());
				 customMnrDatVrfyVOs.setInpMsg12(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg12());
				 customMnrDatVrfyVOs.setInpMsg13(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg13());
				 customMnrDatVrfyVOs.setInpMsg14(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg14());
				 customMnrDatVrfyVOs.setInpMsg15(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg15());
				 customMnrDatVrfyVOs.setInpMsg16(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg16());
				 customMnrDatVrfyVOs.setInpMsg17(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg17());
				 customMnrDatVrfyVOs.setInpMsg18(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg18());
				 customMnrDatVrfyVOs.setInpMsg19(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg19());
				 customMnrDatVrfyVOs.setInpMsg20(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg20());
				 
				 customMnrDatVrfyVOs.setInpMsg21(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg21());
				 customMnrDatVrfyVOs.setInpMsg22(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg22());
				 customMnrDatVrfyVOs.setInpMsg23(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg23());
			 	 customMnrDatVrfyVOs.setInpMsg24(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg24());
				 customMnrDatVrfyVOs.setInpMsg25(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg25());
				 customMnrDatVrfyVOs.setInpMsg26(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg26());
				 customMnrDatVrfyVOs.setInpMsg27(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg27());
				 customMnrDatVrfyVOs.setInpMsg28(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg28());
				 customMnrDatVrfyVOs.setInpMsg29(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg29());
				 customMnrDatVrfyVOs.setInpMsg30(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg30());
				 
				 customMnrDatVrfyVOs.setInpMsg31(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg31());
				 customMnrDatVrfyVOs.setInpMsg32(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg32());
				 customMnrDatVrfyVOs.setInpMsg33(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg33());
				 customMnrDatVrfyVOs.setInpMsg34(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg34());
				 customMnrDatVrfyVOs.setInpMsg35(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg35());
				 customMnrDatVrfyVOs.setInpMsg36(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg36());
				 customMnrDatVrfyVOs.setInpMsg37(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg37());
				 customMnrDatVrfyVOs.setInpMsg38(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg38());
				 customMnrDatVrfyVOs.setInpMsg38(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg39());
				 customMnrDatVrfyVOs.setInpMsg40(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg40());
				 
				 customMnrDatVrfyVOs.setInpMsg41(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg41());
				 customMnrDatVrfyVOs.setInpMsg42(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg42());
				 customMnrDatVrfyVOs.setInpMsg43(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg43());
				 customMnrDatVrfyVOs.setInpMsg44(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg44());
				 customMnrDatVrfyVOs.setInpMsg45(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg45());
				 customMnrDatVrfyVOs.setInpMsg46(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg46());
				 customMnrDatVrfyVOs.setInpMsg47(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg47());
				 customMnrDatVrfyVOs.setInpMsg48(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg48());
				 customMnrDatVrfyVOs.setInpMsg49(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg49());
				 customMnrDatVrfyVOs.setInpMsg50(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyVOS()[i].getInpMsg50());
			     insertVoList.add(customMnrDatVrfyVOs);
			   }
			   
			   if ( insertVoList.size() > 0 ) {     

			    dbDao.addMnrTempData(insertVoList);   
			   } 
			  } catch (DAOException de) {
			   log.error("err " + de.toString(), de);
			   throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EDI Estimate Group Auditing ] createMnrTempDetail"}).getMessage(),de);
			  } catch (Exception de) {
			   log.error("err " + de.toString(), de);
			   throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EDI Estimate Group Auditing ] createMnrTempDetail"}).getMessage(),de);
			  } 
		  return seqValue;
	 }

	/**
	 * [EES_MNR_0023] Repair Estimate Creation의 정보를 체크 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO verifyEstimateCalcDetail(EstimateGRPVO estimateGRPVO) throws EventException {
		try {
			String ssCode = "SS";
			String slCode = "SL";
			String uhCode = "UH";
			String urCode = "UR";
			String umCode = "UM";

			List<CustomMnrDatVrfyVO> customMnrDatVrfyVOList = null;
			List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOList = null;

			//타입 벨리데이션
			dbDao.modifyVerifyEstimateFileListByLocationData(estimateGRPVO.getEstimateINVO());
			dbDao.modifyVerifyEstimateFileListByComponentData(estimateGRPVO.getEstimateINVO());
			dbDao.modifyVerifyEstimateFileListByRepairData(estimateGRPVO.getEstimateINVO());
			dbDao.modifyVerifyEstimateFileListByDemageData(estimateGRPVO.getEstimateINVO());
			dbDao.modifyVerifyEstimateFileListByVolumeTypeData(estimateGRPVO.getEstimateINVO());

			//로직 벨리데이션
			dbDao.calculateEstimateLaborRateData(estimateGRPVO.getEstimateINVO());
			dbDao.calculateEstimateLaborHourData(estimateGRPVO.getEstimateINVO());
			dbDao.calculateEstimateMaterialCostData(estimateGRPVO.getEstimateINVO());
			dbDao.modifyCalculateEstimateResultData(estimateGRPVO.getEstimateINVO());

			//유저 입력 값이 없으면 베이직으로 카피
			customMnrDatVrfyVOList = dbDao.searchVerifyEstimateCalcData(estimateGRPVO.getEstimateINVO());

			//나머지 벨리데이션
			for ( int i = 0; i < customMnrDatVrfyVOList.size(); i++ ) {
				if(customMnrDatVrfyVOList.get(i).getInpMsg4().equalsIgnoreCase(ssCode)){
					//HOUR 언메치
					if(1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg11().toString()) , Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg16().toString()))){
						customMnrDatVrfyVOList.get(i).setInpMsg4(uhCode);
					}
					//레이트 언메치
					else if(1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg12().toString()) , Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg18().toString()))){
						customMnrDatVrfyVOList.get(i).setInpMsg4(urCode);
					}
					//메터리얼 언메치
					else if(1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg14().toString()) , Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg17().toString()))){
						customMnrDatVrfyVOList.get(i).setInpMsg4(umCode);
					}
					//HOUR 작을경우 SL
					else if(-1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg11().toString()) , Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg16().toString()))){
						customMnrDatVrfyVOList.get(i).setInpMsg4(slCode);
					}
					//레이트 작을경우 SL
					else if(-1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg12().toString()) , Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg18().toString()))){
						customMnrDatVrfyVOList.get(i).setInpMsg4(slCode);
					}
					//메터리얼 작을경우 SL
					else if(-1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg14().toString()) , Double.parseDouble(customMnrDatVrfyVOList.get(i).getInpMsg17().toString()))){
						customMnrDatVrfyVOList.get(i).setInpMsg4(slCode);
					}
				}
			}

			//결과값으로 수정
			dbDao.modifyVerifyEstimateCalcData(customMnrDatVrfyVOList);
			//INP_MSG4 = 'NS'
			dbDao.modifyCalculateEstimateResultNs(estimateGRPVO.getEstimateINVO());
			//INP_MSG4 = 'NT'
			dbDao.modifyCalculateEstimateResultNt(estimateGRPVO.getEstimateINVO());

			for ( int k = 0; k < customMnrDatVrfyVOList.size(); k++ ) {
				customMnrDatVrfyVOList.get(k).setTempValue1(estimateGRPVO.getEstimateINVO().getRqstEqNo());
				customMnrDatVrfyVOList.get(k).setTempValue2(estimateGRPVO.getEstimateINVO().getRprRqstVerNo());
				customMnrDatVrfyVOList.get(k).setTempValue3(estimateGRPVO.getEstimateINVO().getRprRqstSeq());
				customMnrDatVrfyVOList.get(k).setTempValue4(estimateGRPVO.getCustomMnrRprRqstVDtlVOS().get(k).getRprRqstDtlSeq());
			}

			//MNR_RPR_RQST_DTL의 MNR_VRFY_TP_CD컬럼 업데이트
			dbDao.modifyVerifyEstimateVrfyTpCd(customMnrDatVrfyVOList);

		    //리스트 다시 조회
			customMnrRprRqstDtlVOList = dbDao.searchVerifyToEstimateDtlData(estimateGRPVO.getEstimateINVO());
			estimateGRPVO.setCustomMnrRprRqstDtlVOS(customMnrRprRqstDtlVOList);

			return estimateGRPVO;

		} catch (DAOException ex) {
			if (ex.toString().contains("FRM10501")) {
				throw new EventException(new ErrorHandler("COM12244", new String[]{}).getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] verifyEstimateCalcDetail"}).getMessage(),ex);
			}
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Repair Estimate Creation] verifyEstimateCalcDetail"}).getMessage(),e);
		}
	}

}