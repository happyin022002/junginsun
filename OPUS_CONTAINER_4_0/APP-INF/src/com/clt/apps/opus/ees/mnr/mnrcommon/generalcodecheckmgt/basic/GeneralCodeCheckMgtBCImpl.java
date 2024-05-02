/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtBCImpl.java
*@FileTitle : Damage Flagging/Unflagging Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.VerifyTariffFileListGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration.GeneralCodeCheckMgtDBDAO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrGeneralCodeVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalPriceFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.SoldEQFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.VerifyEQFlagFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.VerifyEQTypeSizeFlagFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.VerifyRPRCreateFileListGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-OperationManage Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see EES_MNR_0139EventResponse,EQFlagMgtBC DAO class reference
 * @since J2EE 1.4 
 */
public class GeneralCodeCheckMgtBCImpl extends BasicCommandSupport implements GeneralCodeCheckMgtBC {

	// Database Access Object
	private transient GeneralCodeCheckMgtDBDAO dbDao = null;
	
	/**
	 * creating GeneralCodeCheckMgtBCImpl object<br>
	 * creating GeneralCodeCheckMgtDBDAODAO <br>
	 */
	public GeneralCodeCheckMgtBCImpl() {
		dbDao = new GeneralCodeCheckMgtDBDAO();
	}  
	
	/**
	 *[EES_MNR_S139]verifying Repair Creation File Import_Pop Up.  <br>
	 * 	
	 * handling event validaion on EES_MNR_S139<br>
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
	 * [EES_MNR_0023] checking Repair Estimate Creation. <br>
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
				
			//validation type  
			dbDao.modifyVerifyEstimateFileListByLocationData(estimateGRPVO.getEstimateINVO()); 
			dbDao.modifyVerifyEstimateFileListByComponentData(estimateGRPVO.getEstimateINVO()); 
			dbDao.modifyVerifyEstimateFileListByRepairData(estimateGRPVO.getEstimateINVO()); 
			dbDao.modifyVerifyEstimateFileListByDemageData(estimateGRPVO.getEstimateINVO()); 
			dbDao.modifyVerifyEstimateFileListByVolumeTypeData(estimateGRPVO.getEstimateINVO()); 
		    	   		
			//validation logic 
			dbDao.calculateEstimateLaborRateData(estimateGRPVO.getEstimateINVO()); 
			dbDao.calculateEstimateLaborHourData(estimateGRPVO.getEstimateINVO());
			dbDao.calculateEstimateMaterialCostData(estimateGRPVO.getEstimateINVO()); 
			dbDao.modifyCalculateEstimateResultData(estimateGRPVO.getEstimateINVO());  
			//copying to basic in case of users input 
			customMnrDatVrfyVOS = dbDao.searchVerifyEstimateCalcData(estimateGRPVO.getEstimateINVO());
			//Checking the rest	 	
			for ( int i = 0; i < customMnrDatVrfyVOS.size(); i++ ) {
				if(customMnrDatVrfyVOS.get(i).getInpMsg4().equalsIgnoreCase(ssCode)){
					//unmatching HOUR 	 		
					if(1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg11().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg16().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(uhCode);  			
					}
					//unmatching rate
					else if(1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg12().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg18().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(urCode);	 	
					} 
					//unmatching material	
					else if(1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg14().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg17().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(umCode);      	
					}
					//SL in case of HOUR is less
					else if(-1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg11().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg16().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(slCode);  
					}
					//SL in case of rate is less
					else if(-1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg12().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg18().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(slCode);	
					}	 
					//SL in case of matrial is less
					else if(-1 == Double.compare(Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg14().toString()) , Double.parseDouble(customMnrDatVrfyVOS.get(i).getInpMsg17().toString()))){
						customMnrDatVrfyVOS.get(i).setInpMsg4(slCode);	      	
					}
				}		 	
			}			 		 	
			//modifying to result 
			dbDao.modifyVerifyEstimateCalcData(customMnrDatVrfyVOS);
			
		    //retrieving list again
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
	 * [EES_MNR_0139]checking Damage Flagging/Unflagging Pop Up. <br>
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
	 * [EES_MNR_0221]handling Sold Creation File Import_Pop Up. <br>
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
	 * [EES_MNR_0226]checking Vessel Reefer Spare Part Purchase W/O Creation. <br>
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
			
			if(list != null)
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
	 * [EES_MNR_0143]checking M&R Invoice Creation File Import Pop Up. <br>
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
	 * [EES_MNR_0219] checking M&R Simple WO File Import Pop_Up. <br>
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
	 * [EES_MNR_0220]checking Disposal Price File Import_Pop Up. <br>
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
	 * [EES_MNR_0190]handling Standard Tariff File Import_Pop Up. <br>
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
	 * [EES_MNR_0190]handling Local Tariff File Import_Pop Up. <br>
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
	 * [EES_MNR_0221]checking Sold Creation File Import_Pop Up. <br>
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
	 * [EES_MNR_0141]Change Currency M&R Invoice. <br>
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
	 * [common]Check Tariff Flag <br>
	 *
	 * @param GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String checkTariffFlagBasic(GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO, SignOnUserAccount account) throws EventException {
		String result = "";
		try {  
			result = dbDao.searchTariffFlagData();
			    
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"checkTariffFlagBasic"}).getMessage(),ex);
		} catch (Exception e) { 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"checkTariffFlagBasic"}).getMessage(),e);
		}  
		return result; 
	}
	
}