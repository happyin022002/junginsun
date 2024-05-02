/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairMgtBCImpl.java
*@FileTitle : Repair
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCostCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration.RepairMgtDBDAO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomBzcAmtVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomDocHeaderVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomEQWorkOrderHistoryListVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomESTWOMainINFOVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomESTWOMainSMRVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomRepairCollectionVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.DocGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotDTLDataVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotHDRDataVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EQWorkOrderHistoryListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.ESTWOMainGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.MnrOrderInfoBySparePartVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairResultGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairResultINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairResultListVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.SparePartWOGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
/**
 * COM-GeneralManage Business Logic Basic Command implementation<br>
 * - COM-GeneralManage - disposing business logic<br>
 *
 * @author
 * @see RepairMgtBC, RepairMgtDBDAO
 * @since J2EE 1.4
 */
 public  class RepairMgtBCImpl extends BasicCommandSupport implements RepairMgtBC {

	// Database Access Object
	private transient RepairMgtDBDAO dbDao = null;

	/**
	 * RepairMgtBCImpl - Creating object<br>
	 * RepairMgtDBDAO - Creating object<br>
	 */
	public RepairMgtBCImpl() {
		dbDao = new RepairMgtDBDAO();
	}

	/**
	 * [EES_MNR_0015] Retrieving unapproved estimate list before update<br>
	 *	
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */
	public AgreementGRPVO searchNotApprovalESTByAGMTBasic(AgreementGRPVO agreementGRPVO) throws EventException {
		List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;

		try {
			//Retrieving header data
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
	 * [EES_MNR_0015] Retrieving estimate list for used agreement<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */
	public AgreementGRPVO searchUsedEstimateByAGMTBasic(AgreementGRPVO agreementGRPVO) throws EventException {
		List<CustomMnrOrdHdrVO> customMnrOrdHdrVOs = null;

		try {
			//Retrieving header data
			customMnrOrdHdrVOs = dbDao.searchUsedEstimateByAGMTData(agreementGRPVO);
			agreementGRPVO.setCustomMnrOrdHdrVOS(customMnrOrdHdrVOs);
			return agreementGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Agreement Creation] searchUsedEstimateByAGMTBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Agreement Creation] searchUsedEstimateByAGMTBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0192] Retrieving "EDI Estimate" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException 
	 */
	public EstimateGRPVO searchEDIEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException {
		CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;

		try {
			//Retrieving header data
			customMnrRprRqstHdrVO = dbDao.searchEDIEstimateHRDData(estimateGRPVO.getEstimateINVO());
			estimateGRPVO.setCustomMnrRprRqstHdrVO(customMnrRprRqstHdrVO) ;

			//Retrieving detail data
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
	 * [EES_MNR_0028] Retrieving "Repair Cancellation and Deletion" data<br>
	 *	
	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount 	account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */
	public RepairCollectionGRPVO searchRepairInquiryListBasic(RepairCollectionGRPVO repairCollectionGRPVO,SignOnUserAccount account) throws EventException {
		try {
			//Assigning office code for Checking time
			repairCollectionGRPVO.getRepairCollectionINVO().setCurOfcCd(account.getOfc_cd());

			List<CustomRepairCollectionVO> customRepairCollectionVOS = null;

			if(repairCollectionGRPVO.getRepairCollectionINVO().getEdiErrorOnly().equalsIgnoreCase("Y")){
				customRepairCollectionVOS = dbDao.searchRepairInquiryEDIErrorListData(repairCollectionGRPVO.getRepairCollectionINVO());
			} 
//			else if(repairCollectionGRPVO.getRepairCollectionINVO().getNewPortOnly().equalsIgnoreCase("Y")){
//				customRepairCollectionVOS = dbDao.searchNewPortInquiryListData(repairCollectionGRPVO.getRepairCollectionINVO(), repairCollectionGRPVO.getCurrSystem());
//			} 
			else {
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
	 * [EES_MNR_0213] Retrieving "Warranty Alert_Pop-up" data<br>
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
	 * [EES_MNR_0023] Retrieving "Repair Estimate Creation" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
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
	 * [EES_MNR_0022] Retrieving "Repair Group Auditing" data<br>
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
	 * [EES_MNR_0019] Deleting "Repair Estimate Creation" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException 
	 */
	public EstimateGRPVO removeEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException {
		CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();

		try {
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
	 * [EES_MNR_0019] Adding, modifying, deleting "Repair Estimate Creation" data<br>
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

			//common data
			customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());
			customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
			
			//Case of new
			if(customMnrRprRqstHdrVO.getRprRqstSeq().equals("") && customMnrRprRqstHdrVO.getRprRqstVerNo().equals("")){
				List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = dbDao.checkEstimateHDRData(customMnrRprRqstHdrVO);
				//In case of empty data of new
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
				} else {
					//New start in case of finished data
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
				//format 123456(6 digits of company unique code)-200911(6 digits of corresponding year and month)-0001(4 digits of sequence of corresponding month)
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
				dbDao.addEstimateHDRData(customMnrRprRqstHdrVO);
			//Case of modifying from retrieved data
			} else {
				//Case of nothing data
				//format 123456(6 digits of company unique code)-200911(6 digits of corresponding year and month)-0001(4 digits of sequence of corresponding month)
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

				//Modifying header data 
				dbDao.modifyEstimateHDRData(customMnrRprRqstHdrVO);
				//Deleting detailed data case of existing
				dbDao.removeEstimateDTLData(customMnrRprRqstHdrVO);
			}
			//Inserting new detail data
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

					//COST_CD (Inserting missing data)
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
					//COST_DTL_CD (Inserting missing data)
					if(customMnrRprRqstDtlVOS[i].getCostDtlCd().equals("") || customMnrRprRqstDtlVOS[i].getCostDtlCd() == null){
						customMnrRprRqstDtlVOS[i].setCostDtlCd("NR");
					}

					insertVoList.add(customMnrRprRqstDtlVOS[i]);
				}
				if ( insertVoList.size() > 0 ) {
					dbDao.addEstimateDTLData(insertVoList);
				}
			}
			//Inserting header table after detail data sum
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
	 * [EES_MNR_0023] Adding, modifying, deleting "Repair Estimate Auditing" data<br>
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

			customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
			dbDao.manageEstimateAuditItLaterData(customMnrRprRqstHdrVO);
			dbDao.removeEstimateDTLData(customMnrRprRqstHdrVO);

			//Inserting new detail data
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
			//Inserting header table after detail data sum
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
	 * [EES_MNR_0019] Modifying "Repair Estimate Creation" data<br>
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
				//keeping received data
				if(estimateGRPVO.getCurrSystem().equals("SPP")){
					customMnrRprRqstHdrVO.setRprStsCd("SR"); 
				} else { 
					customMnrRprRqstHdrVO.setRprStsCd("HR");
				}

				//Disable the existing data processing
				dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO);
				dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO);

				customMnrRprRqstHdrVOS.add(customMnrRprRqstHdrVO);
			}

			dbDao.addESTRequestHDRListData(customMnrRprRqstHdrVOS);
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
	 * [EES_MNR_0023] Modifying "Repair Estimate Auditing" data<br>
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

			//Setting user information
			customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());
			customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
			
			//Disable the existing data processing
			dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO);
			dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO);

			//Inserting new data
			int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
			int asIsReviseNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprDtlStsCd());

			customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + "");
			customMnrRprRqstHdrVO.setRprDtlStsCd(asIsReviseNo + 1 + "");
			customMnrRprRqstHdrVO.setRprStsCd("HO");
			customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y");
			customMnrRprRqstHdrVO.setAproOfcCd(customMnrRprRqstHdrVO.getCostOfcCd());
			dbDao.addEstimateHDRData(customMnrRprRqstHdrVO);

			//Inserting new detail data
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

			//Inserting header table after detail data sum
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
	 * [EES_MNR_0023] Modifying "Repair Estimate Auditing" data<br>
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

			//Setting user information
			customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());
			customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
			
			//Disable the existing data processing
			dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO);
			dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO);

			//Inserting new data
			int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
			int asIsReviseNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprDtlStsCd());

			customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + "");
			customMnrRprRqstHdrVO.setRprDtlStsCd(asIsReviseNo + 1 + "");
			customMnrRprRqstHdrVO.setRprStsCd("HJ");
			customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y");
			customMnrRprRqstHdrVO.setAproOfcCd(customMnrRprRqstHdrVO.getCostOfcCd());
			dbDao.addEstimateHDRData(customMnrRprRqstHdrVO);

			//Inserting new detail data
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

			//Inserting header table after detail data sum
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
	 * [EES_MNR_0022] Adding, modifying, deleting "Repair Group Auditing" data<br>
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

				//Setting user information
				customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());
				customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
				customMnrRprRqstHdrVO.setMnrRprRmk(customMnrRprRqstHdrVOS[i].getMnrRprRmk());

				dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO);
				dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO);

				//Inserting new data
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

						if(customMnrRprRqstDtlVOS.get(j).getMnrLrAcctFlg().equals("N")){
							customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("0");
						} else {
							customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("1");
						}

						if(customMnrRprRqstDtlVOS.get(j).getN3ptyFlg().equals("N")){
							customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("0");
						} else {
							customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("1");
						}
					}
					dbDao.addEstimateDTLData(customMnrRprRqstDtlVOS);
				}

				//Inserting header table after detail data sum
				dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);
			}
			
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
	 * [EES_MNR_0027] Adding, modifying, deleting "Repair Cancellation and Deletion" data<br>
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

				//Setting user information
				customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());
				customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO);
				dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO);

				//Inserting new data
				int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());

				customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + "");
				customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y");
				
				if(customMnrRprRqstHdrVO.getMnrInpTpCd().equalsIgnoreCase("W")){
					customMnrRprRqstHdrVO.setRprStsCd("SC");  
				} else {
					customMnrRprRqstHdrVO.setRprStsCd("HC");    
				}   
				customMnrRprRqstHdrVO.setAproDt("");     
				customMnrRprRqstHdrVO.setAproUsrId("");

				//Deleting "WORK ORDER"
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

						if(customMnrRprRqstDtlVOS.get(j).getMnrLrAcctFlg().equals("N")){
							customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("0");
						} else {
							customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("1");
						}

						if(customMnrRprRqstDtlVOS.get(j).getN3ptyFlg().equals("N")){
							customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("0");
						} else {
							customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("1");
						}
					}
					dbDao.addEstimateDTLData(customMnrRprRqstDtlVOS);
				}

				//Inserting header table after detail data sum
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
	 * [EES_MNR_0027] Adding, modifying, deleting "Repair Cancellation and Deletion" data<br>
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
					if(!"N".equals(customRepairCollectionVOS[i].getMnrInpTpCd())&&!"S".equals(customRepairCollectionVOS[i].getMnrInpTpCd())){
						//****************** Approval Delete *************************//
						EstimateINVO estimateINVO = new EstimateINVO();
						estimateINVO.setRqstEqNo(customRepairCollectionVOS[i].getRqstEqNo());
						estimateINVO.setRprRqstSeq(customRepairCollectionVOS[i].getRprRqstSeq());
						estimateINVO.setRprRqstVerNo(customRepairCollectionVOS[i].getRprRqstVerNo());
						estimateINVO.setRprRqstLstVerFlg("Y");
						estimateINVO.setCurOfcCd(account.getOfc_cd());
	
						CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = dbDao.searchEstimateHRDData(estimateINVO);
						List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS = dbDao.searchIFEstimateDTLData(estimateINVO);
	
						if(customMnrRprRqstHdrVO != null){
							//Setting user information
							customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());
							customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());
	
							dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO);
							dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO);
	
							//Inserting new data
							int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
	
							//Setting "HD" for status
							customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + "");
							customMnrRprRqstHdrVO.setRprRqstLstVerFlg("Y");
							customMnrRprRqstHdrVO.setRprStsCd("HD");
							customMnrRprRqstHdrVO.setAproDt("");
							customMnrRprRqstHdrVO.setAproUsrId("");
							//Clearing WORK ORDER
							customMnrRprRqstHdrVO.setMnrOrdOfcCtyCd("");
							customMnrRprRqstHdrVO.setMnrOrdSeq("");
	
							dbDao.addEstimateHDRData(customMnrRprRqstHdrVO);
						}
	
						if(customMnrRprRqstDtlVOS != null){
							for(int j = 0;j < customMnrRprRqstDtlVOS.size();j++){
								customMnrRprRqstDtlVOS.get(j).setCreUsrId(account.getUsr_id());
								customMnrRprRqstDtlVOS.get(j).setUpdUsrId(account.getUsr_id());
								customMnrRprRqstDtlVOS.get(j).setRprRqstLstVerFlg("Y");
								if(customMnrRprRqstHdrVO != null){
									customMnrRprRqstDtlVOS.get(j).setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
									customMnrRprRqstDtlVOS.get(j).setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
									customMnrRprRqstDtlVOS.get(j).setRprRqstVerNo(customMnrRprRqstHdrVO.getRprRqstVerNo());
								}
								customMnrRprRqstDtlVOS.get(j).setRprRqstDtlSeq(j + 1 + "");
	
								if(customMnrRprRqstDtlVOS.get(j).getMnrLrAcctFlg().equals("N")){
									customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("0");
								} else {
									customMnrRprRqstDtlVOS.get(j).setMnrLrAcctFlg("1");
								}
	
								if(customMnrRprRqstDtlVOS.get(j).getN3ptyFlg().equals("N")){
									customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("0");
								} else {
									customMnrRprRqstDtlVOS.get(j).setN3ptyFlg("1");
								}
							}
							dbDao.addEstimateDTLData(customMnrRprRqstDtlVOS);
						}
						if(customMnrRprRqstHdrVO != null){
							//Inserting header table after detail data sum
							dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);
						}
					}
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
	 * [EES_MNR_0023] Modify "Repair Estimate Creation" data<br>
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

			customMnrRprRqstHdrVO.setCreUsrId(account.getUsr_id());
			customMnrRprRqstHdrVO.setUpdUsrId(account.getUsr_id());

			if(customMnrRprRqstHdrVO.getRprRqstSeq().equals("") && customMnrRprRqstHdrVO.getRprRqstVerNo().equals("")){
				List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = dbDao.checkEstimateHDRData(customMnrRprRqstHdrVO);
				//If there is no new input data
				if(customMnrRprRqstHdrVOS.size() == 0){
					customMnrRprRqstHdrVO.setRprRqstSeq("1");
					customMnrRprRqstHdrVO.setRprRqstVerNo("1");
				} else {
					int asIsRqstSeq = Integer.parseInt(customMnrRprRqstHdrVOS.get(0).getRprRqstSeq());
					customMnrRprRqstHdrVO.setRprRqstSeq(asIsRqstSeq + 1 + "");
					customMnrRprRqstHdrVO.setRprRqstVerNo("1");
				}
			} else {
			//Inserting new data
				int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
				customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + "");
			}

			//format 123456(6 digits of company unique code)-200911(6 digits of corresponding year and month)-0001(4 digits of sequence of corresponding month)
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

			//Disable the existing data processing
			dbDao.modifyESTHDRLastVersionUnFlagData(customMnrRprRqstHdrVO);
			dbDao.modifyESTDTLLastVersionUnFlagData(customMnrRprRqstHdrVO);

			dbDao.addEstimateHDRData(customMnrRprRqstHdrVO);

			//Inserting header table after detail data sum
			dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);

			//Inserting new detail data
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

			//Inserting header table after detail data sum
			dbDao.modifyEstimateHDRSumData(customMnrRprRqstHdrVO);

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
	 * [EES_MNR_0192] Retrieving "Repair Estimate Creation" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchEstimateBasic(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException {
		CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;

		try {
			//Retrieving header data
			estimateGRPVO.getEstimateINVO().setCurOfcCd(account.getOfc_cd());
			customMnrRprRqstHdrVO = dbDao.searchEstimateHRDData(estimateGRPVO.getEstimateINVO());
			estimateGRPVO.setCustomMnrRprRqstHdrVO(customMnrRprRqstHdrVO) ;

			//Retrieving detail data
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
	 * [EES_MNR_0211] Retrieving "Work Order" data<br>
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
	 * [EES_MNR_0058] Retrieving "Extra Expense Work Order" data<br> 
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
	 * [EES_MNR_0032] Retrieving "Repair Result creation by W/O" data<br>
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
	 * [EES_MNR_0032] Adding, modifying, deleting "Repair Result creation by W/O" data<br>
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

			//Inserting new detail data
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

					//Re-inserting to data
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
	 * [EES_MNR_0058] Adding, modifying, deleting "Simple W/O Creation" data<br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */
	public GeneralWOGRPVO manageExtraWOBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account)throws EventException {
		InterfaceMgtBC command1 = new InterfaceMgtBCImpl();
		try {

			CustomMnrOrdHdrVO customMnrOrdHdrVO = generalWOGRPVO.getCustomMnrOrdHdrVO();
			CustomMnrOrdDtlVO[] customMnrOrdDtlVOS = generalWOGRPVO.getArrCustomMnrOrdDtlVOS();

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
			
			//Inserting new data
			if(strMnrOrdSeq.equalsIgnoreCase("NEW") || strMnrOrdSeq.equalsIgnoreCase("")){
				//Getting sequence
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
			
		    //Inserting new detail data
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
						
						if(!"".equals(customMnrOrdDtlVOS[i].getBkgNo())){
							String revVVdCd = command1.searchRevVvdInfoBasic(customMnrOrdDtlVOS[i].getBkgNo());
							
							if(revVVdCd.length() >= 10){
								customMnrOrdDtlVOS[i].setVslCd(revVVdCd.substring(0, 4));
								customMnrOrdDtlVOS[i].setSkdVoyNo(revVVdCd.substring(4, 8));
								customMnrOrdDtlVOS[i].setSkdDirCd(revVVdCd.substring(8, 9));
								customMnrOrdDtlVOS[i].setRevDirCd(revVVdCd.substring(9, 10));
								customMnrOrdDtlVOS[i].setSlanCd(revVVdCd.substring(10));
							}
						}
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

				//Deleting
				dbDao.removeWODetailData(customMnrOrdHdrVO);
				if ( insertVoList.size() > 0 ) {
					//Re-inserting to data
					dbDao.addExtraWODetailData(insertVoList);
				}
			}
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
	 * [EES_MNR_0054] Adding, modifying, deleting "Vessel Reefer Spare Part Purchase W/O Creation" data<br>
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

			//Inserting new data
			if(strMnrOrdSeq.equalsIgnoreCase("NEW") || strMnrOrdSeq.equalsIgnoreCase("")){
				//Getting sequence
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
			//Inserting new detail data
			if(customMnrOrdDtlVOS != null){
				List<CustomMnrOrdDtlVO> insertVoList = new ArrayList<CustomMnrOrdDtlVO>();
				for ( int i = 0; i < customMnrOrdDtlVOS.length; i++ ) {
					if(!customMnrOrdDtlVOS[i].getIbflag().equals("D")){
						customMnrOrdDtlVOS[i].setCreUsrId(account.getUsr_id());
						customMnrOrdDtlVOS[i].setUpdUsrId(account.getUsr_id());
						customMnrOrdDtlVOS[i].setMnrOrdOfcCtyCd(customMnrOrdHdrVO.getMnrOrdOfcCtyCd());
						customMnrOrdDtlVOS[i].setMnrOrdSeq(customMnrOrdHdrVO.getMnrOrdSeq());
						customMnrOrdDtlVOS[i].setCostDtlCd("PW");

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

				//Deleting
				dbDao.removeWODetailData(customMnrOrdHdrVO);
				if ( insertVoList.size() > 0 ) {
					//Re-inserting
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
	 * [EES_MNR_0058] Deleting "Vessel Reefer Spare Part Purchase W/O Creation" data<br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */
	public GeneralWOGRPVO removeWOBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account)throws EventException {
		try {
			CustomMnrOrdHdrVO customMnrOrdHdrVO = generalWOGRPVO.getCustomMnrOrdHdrVO();

			if(!account.getUsr_id().equals("") && account !=null)
			{
				GeneralWOINVO generalWOINVO = generalWOGRPVO.getGeneralWOINVO();
				customMnrOrdHdrVO.setMnrOrdOfcCtyCd(generalWOINVO.getMnrOrdSeq().substring(0,3));
				customMnrOrdHdrVO.setMnrOrdSeq(generalWOINVO.getMnrOrdSeq().substring(3));
				dbDao.removeWODetailData(customMnrOrdHdrVO);
				dbDao.removeWOHeaderData(customMnrOrdHdrVO);
			}
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
	 * [EES_MNR_0226] Getting "Simple W/O Inquiry Pop-up" data<br>
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
	 * [EES_MNR_0023] Retrieving "Repair Estimate Creation" data<br>
	 * Retrieving the estimate data the last six months same disposed<br>
	 * @param EstimateGRPVO estimateGRPVO
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchLatestEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;

		try {
			customMnrRprRqstHdrVOS = dbDao.searchLatestEstimateData(estimateGRPVO);

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
	 * [EES_MNR_0036] Retrieving "M&R Document Transmission" data<br>
	 *
	 * @param DocGRPVO docGRPVO
	 * @return DocGRPVO
	 * @exception EventException
	 */
	public DocGRPVO searchDocSendBasic(DocGRPVO docGRPVO) throws EventException {
		List<CustomDocHeaderVO> customDocHeaderVO = null;

		try {
			//Retrieving header data
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
	 * [EES_MNR_0036] Adding, modifying, deleting "M&R Document Transmission" data<br>
	 *
	 * @param DocGRPVO docGRPVO
	 * @param SignOnUserAccount account
	 * @return DocGRPVO
	 * @exception EventException
	 */
	public DocGRPVO manageDocSendBasic(DocGRPVO docGRPVO, SignOnUserAccount account) throws EventException {

		try {
			//Retrieving header data
			dbDao.manageDocSendData(docGRPVO.getCustomMnrOrdHdrVO());

 			return docGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Document Transmission] manageDocSendBasic"}).getMessage(),ex);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Document Transmission] manageDocSendBasic"}).getMessage(),e);
		}
	}

	/**
	 * [EES_MNR_0030] Retrieving "W/O Creation" data<br>
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
	 * [EES_MNR_0030] Retrieving "W/O Creation" data<br>
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
	 * [EES_MNR_0030] Adding "W/O Creation" data<br>
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
				String mnrOrdOfcCtyCd = account.getOfc_cd().substring(0, 3);
				List<String> mnrOrdSeqList = new ArrayList<String>();
				for ( int i = 0; i < arrayCustomESTWOMainINFOVOs.length; i++ ) {
					mnrOrdSeqList.add(dbDao.searchMnrOrdSeqData());
				}

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
				//Returning after saving the "W/O"
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
	 * Insert into table the data from EDI Received estimate<br>
	 * 	 	
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @exception EventException								  
	 */
	public void ediEstimateCopyToEstimateBasic(InterfaceGRPVO interfaceGRPVO) throws EventException{
		try {
			CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVO();
			CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = interfaceGRPVO.getCheckCustomMnrRprRqstHdrVO();

			//Getting sequence in case of null data
			if(customMnrRprRqstHdrVO == null){
				customMnrRprRqstHdrVO = dbDao.searchEstimateSeqNewEqData(customMnrRprRqstTmpHdrVO);
			} else {
				//Excluding saving in case of "HA"
				CustomMnrRprRqstHdrVO tempCustomMnrRprRqstHdrVO = new CustomMnrRprRqstHdrVO();
				tempCustomMnrRprRqstHdrVO.setRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
				tempCustomMnrRprRqstHdrVO.setRprRqstSeq(customMnrRprRqstHdrVO.getRprRqstSeq());
				tempCustomMnrRprRqstHdrVO.setUpdUsrId(customMnrRprRqstTmpHdrVO.getUpdUsrId());

				//Disable the existing data processing
				dbDao.modifyESTHDRLastVersionUnFlagData(tempCustomMnrRprRqstHdrVO);
				dbDao.modifyESTDTLLastVersionUnFlagData(tempCustomMnrRprRqstHdrVO);

				//Version increase
				int asIsVerNo = Integer.parseInt(customMnrRprRqstHdrVO.getRprRqstVerNo());
				customMnrRprRqstHdrVO.setRprRqstVerNo(asIsVerNo + 1 + "");
			}

			dbDao.addEstimateHDRDataFromTmpData(customMnrRprRqstHdrVO,customMnrRprRqstTmpHdrVO);
			dbDao.addEstimateDTLDataFromTmpData(customMnrRprRqstHdrVO,customMnrRprRqstTmpHdrVO);
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
	 * [EES_MNR_0194] Retrieving "Reefer Spare Part Summary List" data<br>
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
	 * [EES_MNR_0041] Modifying "M&R Invoice Creation & Correction" data<br>
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
					insertVoList.add(arrCustomMnrOrdDtlVO[i]);
				}
			}
			if ( insertVoList.size() > 0 ) {
				if(account.getAccess_system().equals("ALP")){
			    	 dbDao.modifyWEBInvoiceLinkData(insertVoList);
	
			    	 //Inserting detail data in case of Confirm
			    	 if(generalWOGRPVO.getMnrInvStsCd().equals("HC")){
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
	
					     //Delete the existing data
						 dbDao.removeWODetailByPayINVSeqData(customMnrOrdDtlVO);
	
					     //Inserting the data
						 if(!customMnrOrdDtlVO.getSlsTaxAmt().equals("") && Double.parseDouble(slsTaxAmt) != 0){
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
	 * [EES_MNR_0041] Modifying "M&R Invoice Creation & Correction" data<br>
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
	  * [EES_MNR_B001] Cost Shipment Update 대상을 조회한다<br> 
	  *
	  * @return List<CustomMnrOrdDtlVO>
	  * @exception EventException
	  */
	@Override
	public List<CustomMnrOrdDtlVO> searchEmptyCostShipmentData() throws EventException {
		try { 
			return dbDao.searchEmptyCostShipmentData();
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_B001] searchEmptyCostShipmentData"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_B001] searchEmptyCostShipmentData"}).getMessage(),ex);
		}
	}

	/**
	  * [EES_MNR_B001]Cost Shipment Update <br>
	  * 
	  * @param CustomMnrOrdDtlVO customMnrOrdDtlVO
	  * @param String updUsrId
	  * @exception EventException
	  */
	@Override
	public void modifyEmptyCostShipmentData(CustomMnrOrdDtlVO customMnrOrdDtlVO, String updUsrId) throws EventException {
		try {
			customMnrOrdDtlVO.setCreUsrId(updUsrId);
			customMnrOrdDtlVO.setUpdUsrId(updUsrId);
			dbDao.modifyEmptyCostShipmentData(customMnrOrdDtlVO);
			dbDao.addMnrOrdDtlTrcData(customMnrOrdDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_B001] modifyEmptyCostShipmentData"}).getMessage(),ex);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_B001] modifyEmptyCostShipmentData"}).getMessage(),e);
		}
	}	
	
	/**
	  * [EES_MNR_0247]EDI Invoice Parking Lot Search Main Data<br>
	  * 
	  * @param EDIInvoiceParkingLotHDRDataVO eDIInvoiceParkingLotHDRDataVO
	  * @return List<EDIInvoiceParkingLotHDRDataVO>
	  * @exception EventException
	  */
	public List<EDIInvoiceParkingLotHDRDataVO> searchEDIInvoiceParkingLotHDRData(EDIInvoiceParkingLotHDRDataVO eDIInvoiceParkingLotHDRDataVO) throws EventException{
		List<EDIInvoiceParkingLotHDRDataVO> list = null;
		try{
			list = dbDao.searchEDIInvoiceParkingLotHDRData(eDIInvoiceParkingLotHDRDataVO);
		}catch(DAOException ex){
			log.error("DAOException" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("Exception" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	  * [EES_MNR_0247]EDI Invoice Parking Lot Search Detail Data<br>
	  * 
	  * @param EDIInvoiceParkingLotDTLDataVO eDIInvoiceParkingLotDTLDataVO
	  * @return List<EDIInvoiceParkingLotDTLDataVO>
	  * @exception DAOException
	  */
	public List<EDIInvoiceParkingLotDTLDataVO> searchEDIInvoiceParkingLotDTLData(EDIInvoiceParkingLotDTLDataVO eDIInvoiceParkingLotDTLDataVO) throws EventException{
		List<EDIInvoiceParkingLotDTLDataVO> list = null;
		try{
			list = dbDao.searchEDIInvoiceParkingLotDTLData(eDIInvoiceParkingLotDTLDataVO);
		}catch(DAOException ex){
			log.error("DAOException" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("Exception" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * manageEDIInvoiceParkingLotHDRData<br>
	 * 
	 * @param CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEDIInvoiceParkingLotHDRData(CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs, SignOnUserAccount account) throws EventException{
		try{
			List<CustomMnrOrdTmpHdrVO> updateVoList = new ArrayList<CustomMnrOrdTmpHdrVO>();
			List<CustomMnrOrdTmpHdrVO> deleteVoList = new ArrayList<CustomMnrOrdTmpHdrVO>();
			
			for(int i = 0; i < customMnrOrdTmpHdrVOs.length; i++){
				if(customMnrOrdTmpHdrVOs[i].getIbflag().equals("U")){
					customMnrOrdTmpHdrVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(customMnrOrdTmpHdrVOs[i]);
				} else if(customMnrOrdTmpHdrVOs[i].getIbflag().equals("D")){
					deleteVoList.add(customMnrOrdTmpHdrVOs[i]);
				} 
			}
			
			if(updateVoList.size()>0){
				dbDao.modifyEDIInvoiceParkingLotHDRData(updateVoList);
			}
			if(deleteVoList.size()>0){
				dbDao.modifyEDIInvoiceParkingLotHDRData(deleteVoList);
			}
		}catch(DAOException ex){
			log.error("DAOException" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("Exception" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * manageEDIInvoiceParkingLotData<br>
	 * 
	 * @param EDIInvoiceParkingLotGRPVO eDIInvoiceParkingLotGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEDIInvoiceParkingLotData(EDIInvoiceParkingLotGRPVO eDIInvoiceParkingLotGRPVO, SignOnUserAccount account) throws EventException{
		try{
			List<CustomMnrOrdTmpDtlVO> updateVoList = new ArrayList<CustomMnrOrdTmpDtlVO>();
			List<CustomMnrOrdTmpHdrVO> deleteVoList = new ArrayList<CustomMnrOrdTmpHdrVO>();
			
			CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs = eDIInvoiceParkingLotGRPVO.getCustomMnrOrdTmpDtlVOs();
			CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = eDIInvoiceParkingLotGRPVO.getCustomMnrOrdTmpHdrVOs();	
			
			if(customMnrOrdTmpHdrVOs != null){
				for(int i = 0; i < customMnrOrdTmpHdrVOs.length; i++){
					if(customMnrOrdTmpHdrVOs[i].getIbflag().equals("D")){
						deleteVoList.add(customMnrOrdTmpHdrVOs[i]);
					} 
				}
				
				if(deleteVoList.size()>0){
					dbDao.removeEDIInvoiceParkingLotDTLData(deleteVoList);
					dbDao.removeEDIInvoiceParkingLotHDRData(deleteVoList);
				}
			}
			
			if(customMnrOrdTmpDtlVOs != null){
				for(int i = 0; i < customMnrOrdTmpDtlVOs.length; i++){
					if(customMnrOrdTmpDtlVOs[i].getIbflag().equals("U")){
						customMnrOrdTmpDtlVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(customMnrOrdTmpDtlVOs[i]);
					} 
				}
				
				if(updateVoList.size()>0){
					dbDao.modifyEDIInvoiceParkingLotDTLData(updateVoList);
				}
			}
		}catch(DAOException ex){
			log.error("DAOException" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("Exception" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * manageEDIInvoiceParkingLotDTLData<br>
	 * 
	 * @param CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEDIInvoiceParkingLotDTLData(CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs, SignOnUserAccount account) throws EventException{
		try{
			List<CustomMnrOrdTmpDtlVO> updateVoList = new ArrayList<CustomMnrOrdTmpDtlVO>();
			List<CustomMnrOrdTmpDtlVO> deleteVoList = new ArrayList<CustomMnrOrdTmpDtlVO>();
			
			for(int i = 0; i < customMnrOrdTmpDtlVOs.length; i++){
				if(customMnrOrdTmpDtlVOs[i].getIbflag().equals("U")){
					customMnrOrdTmpDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(customMnrOrdTmpDtlVOs[i]);
				} else if(customMnrOrdTmpDtlVOs[i].getIbflag().equals("D")){
					deleteVoList.add(customMnrOrdTmpDtlVOs[i]);
				} 
			}
			
			if(updateVoList.size()>0){
				dbDao.modifyEDIInvoiceParkingLotDTLData(updateVoList);
			}
			if(deleteVoList.size()>0){
				dbDao.modifyEDIInvoiceParkingLotDTLData(deleteVoList);
			}
		}catch(DAOException ex){
			log.error("DAOException" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("Exception" + ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0247] Retrieving Back End Job <br>
	 *
	 * @return String
	 * @exception EventException
	 */ 
	public String searchBackEndJobCntBasic() throws EventException {
		String result = "";
		try {
			result = dbDao.searchBackEndJobCntData();
			return result;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Purchase W/O Inquiry - Popup] searchWONoInquiryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tire Purchase W/O Inquiry - Popup] searchWONoInquiryListBasic"}).getMessage(),ex);
		}
	}
}