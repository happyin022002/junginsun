/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : commoncodeSC.java
*@FileTitle : account
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0 
*@history
*	2014-12-03 Chang Young Kim Release Test �섏젙
=========================================================*/
package com.clt.apps.opus.ees.eqr.automtbkgmgt;
 
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052MultiVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.NewBkgSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoCntrVO;


import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.ContainerMovementMgtBC;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.ContainerMovementMgtBCImpl;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.AutoMtBkgMgtBC;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.AutoMtBkgMgtBCImpl;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.vo.AutoMtBkgVO;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.CntrMtyBkgCreateBC;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.CntrMtyBkgCreateBCImpl;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.GeneralBookingSplitCombineBC;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.GeneralBookingSplitCombineBCImpl;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.PerformanceReportBC;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.PerformanceReportBCImpl;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.BLDocumentationBLBC;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.BLDocumentationBLBCImpl;


//import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBC;
//import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBCImpl;

import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.CntrRepoExecutionPlanEstablishBC;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.CntrRepoExecutionPlanEstablishBCImpl;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.vo.EesEqr0059MultiVO;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.ContainerOnOffhireBC;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.ContainerOnOffhireBCImpl;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.BLDocumentationCMBC;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.basic.BLDocumentationCMBCImpl;
import com.clt.framework.component.message.ErrorHandler;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.MstContainerVO;


/**
 * OPUS-commoncode Business Logic ServiceCommand 
 * 
 * @author 
 * @see
 * @since 
 */

public class AutoMtBkgmgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * commoncode system preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("AutoMtBkgmgtSC begin"); 
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * commoncode system biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("AutoMtBkgmgtSC end");
	}

	/**
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("AutoMtBkgMgtEvent")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAutoMtBkg(e);
			}
		}
		
		return eventResponse;
	}

	
	/**
	 * Auto Mt Booking : SEARCH<br>
	 * Organization information retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("null")
	private EventResponse searchAutoMtBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//AutoMtBkgMgtEvent event = (AutoMtBkgMgtEvent)e;
		AutoMtBkgMgtBC command = new AutoMtBkgMgtBCImpl();
		AutoMtBkgVO autovo = new AutoMtBkgVO();
		
		CntrRepoExecutionPlanEstablishBC command01 = new CntrRepoExecutionPlanEstablishBCImpl();

		BookingUtil bookingUtil = new BookingUtil();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		CommonVO commonVO = new CommonVO();
		MtyBookingCreateVO mtyBookingCreateVO = new MtyBookingCreateVO();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		//EesEqr0059ConditionVO eesEqr0059ConditionVO = null;
		
		String[] table_name = new String[1];
		String gubun	= null;
		gubun = "V";	// Vessel						
		if(gubun != null) commonVO.setGubun(gubun);
		EesEqr0059MultiVO eesEqr0059MultiVO = new EesEqr0059MultiVO();
		EesEqr0059MultiVO[] eesEqr0059MultiVOs = new EesEqr0059MultiVO[]{eesEqr0059MultiVO};
		//BKG_BOOKING INSERT 시 필요한 변수
		//bkg_no , vsl_cd , skd_voy_no ,skd_dir_cd , pre_rly_port_cd , pst_rly_port_cd , sls_rhq_cd ,sls_rgn_ofc_cd ,doc_usr_id,bl_no
		//mty_bkg_sts_cd , mty_split_aval_cd
		
		//칼럼변경
		//pol_yd_cd => pol_cd, pod_yd_cd => pod_cd, pkup_yd_cd => MTY_PKUP_YD_CD
		//bkg_cre_svr_cd => MTY_CRE_SVR_CD, ob_sls_cd => OB_SLS_OFC_CD
		
		//cre_usr_id , bkg_rmk , upd_usr_id
		
		// 배치시 UserID 설정
		account = new SignOnUserAccount("BATCH" ,"" ,"" ,""      ,""
                ,""      ,"" ,"" ,"SINHO" ,""
                ,"2000517" ,"" ,"" ,""      ,""
                ,""      ,"" ,"" ,""      ,""
                ,""      ,""
					);
		
		//try {
			begin();
			
			List<AutoMtBkgVO> eesEqr0059MultiList = command.searchAutoMtBkg();											//automtbkgmgt
			if (eesEqr0059MultiList!=null){
				if(eesEqr0059MultiList.size() > 0){
					for(int i=0;i<eesEqr0059MultiList.size();i++) {
						autovo.setCntrNo(eesEqr0059MultiList.get(i).getCntrNo());
						//조회된 데이타를 eesEqr0059MultiVOs Set
						eesEqr0059MultiVOs[0].setIbflag("U");
						eesEqr0059MultiVOs[0].setCntrNo		(eesEqr0059MultiList.get(i).getCntrNo()		);
						eesEqr0059MultiVOs[0].setMtyBkgNo	(eesEqr0059MultiList.get(i).getBkgNo()			);	//bkg no
						eesEqr0059MultiVOs[0].setVslCd			(eesEqr0059MultiList.get(i).getVslCd()			);
						eesEqr0059MultiVOs[0].setSkdVoyNo	(eesEqr0059MultiList.get(i).getSkdVoyNo()	);
						eesEqr0059MultiVOs[0].setSkdDirCd		(eesEqr0059MultiList.get(i).getSkdDirCd()		);						
						eesEqr0059MultiVOs[0].setFmYdCd		(eesEqr0059MultiList.get(i).getInpYdCd()		);
						eesEqr0059MultiVOs[0].setToYdCd		(eesEqr0059MultiList.get(i).getOrgYdCd()		);
						eesEqr0059MultiVOs[0].setVslLaneCd	(eesEqr0059MultiList.get(i).getSlanCd()		);
						
						eesEqr0059MultiVOs[0].setCoCd			("H");						
						eesEqr0059MultiVOs[0].setRepobkgFlag("T");
						eesEqr0059MultiVOs[0].setEqRepoPurpCd("E");
						
						eesEqr0059MultiVOs[0].setFrlocRcc		(eesEqr0059MultiList.get(i).getVslLocCd()		);
						eesEqr0059MultiVOs[0].setFrlocEcc		(eesEqr0059MultiList.get(i).getVslLocCd()		);
						eesEqr0059MultiVOs[0].setTolocEcc		(eesEqr0059MultiList.get(i).getVslLocCd()		);
						
						//배치시에는 값이 존재 하지 않는다. 그래서 C1에서 command01.modifyMtyBkgNo 처리가 안된다. 
						eesEqr0059MultiVOs[0].setRepoPlnId("");
						eesEqr0059MultiVOs[0].setPlnYrwk("");
						eesEqr0059MultiVOs[0].setPlnSeq("");
						eesEqr0059MultiVOs[0].setRefId("");
						
						//Tpsz tpszcd 설정 한다.
						List<String> volList = new ArrayList<String>();
						volList.add(eesEqr0059MultiList.get(i).getCntrTpszCd());
						eesEqr0059MultiVOs[0].setTpszList		(volList);
						
						if("C1".equals(eesEqr0059MultiList.get(i).getCheckCase())) {
							if(gubun != null) {
								if ( gubun.equals("V") ){
									commonVO.setResultVo(eesEqr0059MultiVOs);		
									table_name[0]	= "EQR_VSL_LODG_DCHG_EXE_PLN";
									
									//사용안함 Repo Plan Id가 존재 하지 않는다.
									//command01.modifyTrunkVesselAndFeederCntrRepoPlan(eesEqr0059MultiVOs, account);
									//table_name[0]	= "EQR_VSL_LODG_DCHG_EXE_PLN";
									
									mtyBookingCreateVO = command01.createRepoBKG(commonVO, account);    // setting BKG VO with BKG/DOC data automtbkgmgt
									//BOOKING 번호 조회
									BkgBlNoVO newBkgNoVO = bookingUtil.manageBkgNumberGeneration("BKG",eesEqr0059MultiList.get(i).getOfcCd() , eesEqr0059MultiList.get(i).getCreUsrId());									
									String mtyBkgNo = newBkgNoVO.getBkgNo();
									
									//Try~ Catch 를 잠시 주석으로 처리해서 테스트위해 주석으로 막아놓음
									//if(mtyBkgNo == null || mtyBkgNo.equals("")) {
										//throw new DAOException(new ErrorHandler("EQR10028", "bkg_no is empty").getMessage());
									//} else {
										mtyBkgNo	= mtyBkgNo+"00";
									//}
									
									log.debug("MTY BOOKING NO >>>>>>>>>>"+mtyBkgNo);
									
									bkgBlNoVO.setBkgNo(mtyBkgNo);
									bkgBlNoVO.setBlNo(mtyBkgNo);
									
									mtyBookingCreateVO.setBkgBlNoVO(bkgBlNoVO);
									
									/************* 단계별 진행상황 **************************/
									// 2. creating Mty Booking Data 
									log.debug(">>>>>>>>>>>>>>>>>step2");
									receiptBC.createMtyRepoBooking(mtyBookingCreateVO, account);				//automtbkgmgt
									
									
									log.debug(">>>>>>>>>>>>>>>>>step3");
									// 3. creating Cntr, B/L Data of Mty Booking
									BLDocumentationBLBC blDocBC = new BLDocumentationBLBCImpl();
									blDocBC.createMtyRepoBlCntr(mtyBookingCreateVO, account);				 //automtbkgmgt
																		// Booking Split
									MtyBkgVO mtyBkgVO = new MtyBkgVO();
									mtyBkgVO.setMtyBkgNo(mtyBkgNo);
									mtyBkgVO.setUsrId(account.getUsr_id());
									if(gubun != null) mtyBkgVO.setGubun(gubun);
									mtyBkgVO.setTableName(table_name);
									
									log.debug(">>>>>>>>>>>>>>>>>step4");
									// RepoPlnId 값이 없으므로 처리되지 않는다. 
									command01.modifyMtyBkgNo(mtyBkgVO, commonVO);  // updating EQR BKG no with BKGDOC's
									
									log.debug(">>>>>>>>>>>>>>>>>step end");
									//추후 CTM_MOVEMENT 테이블 처리되었다고 UPDATE 쿼리 필요할듯
									
									//commit();		
								}
							}
						} else if("C2".equals(eesEqr0059MultiList.get(i).getCheckCase())) {
							log.debug(">>>>>>>+!+!+!+!+>>>C2 START");
							//C1 처리후 작업 ~~~ 
							
							commonVO.setResultVo(eesEqr0059MultiVOs);		
							
							//EsmBkg9424Event event02 = (EsmBkg9424Event)e;
							
							BLDocumentationBLBC     blDocBLBC = new BLDocumentationBLBCImpl();
							BookingUtil           utilBC    = new BookingUtil();
							ContainerMovementMgtBC  ctmCmd    = new ContainerMovementMgtBCImpl();
							CntrRepoExecutionPlanEstablishBC cntrRepoBC = new CntrRepoExecutionPlanEstablishBCImpl();
							//try {
								begin();			
								RepoBkgForUpdateVO repoBkgForUpdateVO = new RepoBkgForUpdateVO();
								repoBkgForUpdateVO.setBkgBlNoVO(bkgBlNoVO);
								
								//bkgBlNo set >>>>
								BkgBlNoVO bkgBlNo = new BkgBlNoVO();
								bkgBlNo.setBkgNo(eesEqr0059MultiList.get(i).getBkgNo()	);
								bkgBlNo.setBlNo(eesEqr0059MultiList.get(i).getBlNo()	);
								
								//repoBkg set >>>>
								RepoBkgVO repoBkg = new RepoBkgVO();
								repoBkg.setBkgNo(eesEqr0059MultiList.get(i).getBkgNo()	);
								repoBkg.setMtyBkgStsCd(""); // F,X 값 추출 데이타가 없는데 ...... 
								repoBkg.setBkgPodCd(eesEqr0059MultiList.get(i).getLocCd());
								repoBkg.setInterRmk(eesEqr0059MultiList.get(i).getCnmvRmk());
								
								//repoCntrs set >>>>
								RepoCntrVO repoCntrVO = new RepoCntrVO();
								RepoCntrVO[] repoCntrs = new RepoCntrVO[]{repoCntrVO};
								repoCntrs[0].setCntrNo(eesEqr0059MultiList.get(i).getCntrNo());
								repoCntrs[0].setCntrNoPst("");								
								
								repoBkgForUpdateVO.setBkgBlNoVO(bkgBlNo);
								repoBkgForUpdateVO.setRepoBkgVO(repoBkg);
								repoBkgForUpdateVO.setRepoCntrVOs(repoCntrs);		
								//mty_bkg_sts_cd
								//repoBkgForUpdateVO.set
								//eesEqr0059MultiVOs
								/*repoBkgForUpdateVO.setBkgBlNoVO(event02.getBkgBlNoVO());
								repoBkgForUpdateVO.setRepoBkgVO(event02.getRepoBkgVO());
								repoBkgForUpdateVO.setRepoCntrVOs(event02.getRepoCntrVOs());*/
								
								String vvd = (String)eesEqr0059MultiList.get(i).getVslCd()+(String)eesEqr0059MultiList.get(i).getSkdVoyNo()+(String)eesEqr0059MultiList.get(i).getSkdDirCd()	;
								String trunkVvd = vvd;
								String bkgNo = eesEqr0059MultiList.get(i).getBkgNo();
								
								// mty_bkg_sts_cd ,bkg_pod_cd , inter_rmk, upd_usr_id , bkg_no
								// cntr_no , mcntr_bdl_no , bdl_btm_flg
								// 15. modifyRepoBkg 
								receiptBC.modifyMtyRepoBkg(repoBkgForUpdateVO, account);
								// 26. manageEmptyCntr
								List<CusCtmMovementVO> ctmMovementVO = blDocBLBC.manageEmptyCntr(repoBkgForUpdateVO, trunkVvd, account);
								
								// 42. completeModifyMtyRepoBkg
								List<BkgQuantityVO> bkgQtyVO = receiptBC.completeModifyMtyRepoBkg(repoBkgForUpdateVO, account);

								// 64. 
								log.debug("to ctm ["+ctmMovementVO.size()+"] VL container");
								for(int j=0;j<ctmMovementVO.size();j++){
									// In case of VL ,  update as CTM
									if(!"VL".equals(ctmMovementVO.get(i).getMvmtStsCd())) 
										continue;
									log.debug("cntr_no:"+ctmMovementVO.get(j).getCntrNo());
									log.debug("cnmv_yr:"+ctmMovementVO.get(j).getCnmvYr());
									log.debug("cnmv_id_no:"+ctmMovementVO.get(j).getCnmvIdNo());
									log.debug("trnk_vsl_cd:"+ctmMovementVO.get(j).getTrnkVslCd());
									log.debug("crnt_vsl_cd:"+ctmMovementVO.get(j).getCrntVslCd());				
									ctmCmd.modifyMovementFromBkgForPreVL(ctmMovementVO.get(j));
								}
								
								// 65. PRE_STS_FLG,BKG_NO,VVD information UPDATE(20091123 add)			
								if(repoBkgForUpdateVO.getRepoCntrVOs() != null && repoBkgForUpdateVO.getRepoCntrVOs().length > 0){
									int cntrCnt = repoBkgForUpdateVO.getRepoCntrVOs().length;
									MstContainerVO mstContainerVO = null;
									BLDocumentationCMBC cmBlBC = new BLDocumentationCMBCImpl();
									ContainerOnOffhireBC cntrOffBC = new ContainerOnOffhireBCImpl();
									CrossItemVO crossItemVO = new CrossItemVO();
									CusCtmMovementVO custCtmVO = new CusCtmMovementVO();
									String cntrNo = "";
									for(int j = 0 ; j < cntrCnt ; j++){
										cntrNo = repoBkgForUpdateVO.getRepoCntrVOs()[j].getCntrNo()+repoBkgForUpdateVO.getRepoCntrVOs()[j].getCntrNoPst();
										// In case of VL, MST_CONTAINER占쏙옙UPDATE
										if("VL".equals(repoBkgForUpdateVO.getRepoCntrVOs()[j].getStsCd())){
											mstContainerVO = cmBlBC.searchMstCntrForMst(cntrNo);
											if(mstContainerVO != null){
												custCtmVO.setCntrSvrId(mstContainerVO.getSysAreaGrpId());
												custCtmVO.setCnmvYr(mstContainerVO.getCnmvYr());
												custCtmVO.setCnmvIdNo(mstContainerVO.getCnmvIdNo());
												custCtmVO.setCnmvSeq(mstContainerVO.getCnmvSeq());
												custCtmVO.setCnmvSplitNo(mstContainerVO.getCnmvSplitNo());
												custCtmVO.setCnmvCycNo(mstContainerVO.getCnmvCycNo());
												custCtmVO.setCnmvEvntDt(mstContainerVO.getCnmvDt());
												custCtmVO.setPreStsFlg("N");
												custCtmVO.setBkgNo(bkgNo);
												custCtmVO.setBkgKnt(mstContainerVO.getBkgKnt());
												custCtmVO.setFcntrFlg("N");
												custCtmVO.setOrgYdCd(mstContainerVO.getCrntYdCd());
												custCtmVO.setDestYdCd(mstContainerVO.getDestYdCd());
												custCtmVO.setCntrId(trunkVvd);
												custCtmVO.setMvmtStsCd(mstContainerVO.getCnmvStsCd());
												custCtmVO.setAciacDivCd(mstContainerVO.getAciacDivCd());
												custCtmVO.setUpdUsrId(account.getUsr_id());
												custCtmVO.setCntrNo(cntrNo);

												crossItemVO.setUpdateMaster(true);
												crossItemVO.setCusCtmMovementVO(custCtmVO);
												
												cntrOffBC.updateCntrMasterByMvmtBasic(crossItemVO);
											}
										}
									}
								}

								MtyBkgVO mtyBkgVO = new MtyBkgVO();
								mtyBkgVO.setMtyBkgNo(bkgNo);
								mtyBkgVO.setUsrId(account.getUsr_id());
								
								if(bkgNo.length()==11 
										||(bkgNo.length()==12&&"00".equals(bkgNo.substring(10)))){
									mtyBkgVO.setSplitFlg("N");				
								} else {
									mtyBkgVO.setSplitFlg("Y");	
								}
								
								if("Y".equals(mtyBkgVO.getSplitFlg())){
//									1. Splitchanging
//									   1) volumeChange Call
//									
									cntrRepoBC.modifyMtyBkgVolChange(mtyBkgVO);
									if(bkgQtyVO.size()==0){
										cntrRepoBC.modifyMtyBkgCancel(mtyBkgVO);
									} 

//									   2) Original BKG volumeChange Call
									MtyBkgVO mstMtyBkgVO = new MtyBkgVO();
									mstMtyBkgVO.setMtyBkgNo(utilBC.searchSplitMstBkgNo(bkgNo));
									mstMtyBkgVO.setUsrId(account.getUsr_id());
									mstMtyBkgVO.setSplitFlg("N");	
									cntrRepoBC.modifyMtyBkgVolChange(mstMtyBkgVO);
								} else {
//									2. Original changing
//									   1) volumeChange Call
									if(bkgQtyVO.size()==0){
//										cntrRepoBC.modifyMtyBkgCancel(mtyBkgVO);
										cntrRepoBC.modifyMtyBkgVolChange(mtyBkgVO);
									} else {
										cntrRepoBC.modifyMtyBkgVolChange(mtyBkgVO);
									} 
								}
								//commit();		
								//eventResponse.setETCData("SuccessYn", "Y");
							/*}catch(EventException ex){
								rollback();
								log.error("err " + ex.toString(), ex);
								throw ex;
							} catch(Exception ex) {
								rollback();
								log.error("err " + ex.toString(), ex);
								throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
							}*/
							
							//return eventResponse;
						} else if("C3".equals(eesEqr0059MultiList.get(i).getCheckCase())) {
							log.debug(">>>>>>>+!+!+!+!+>>>C3 START");							
							
							CntrMtyBkgCreateBC command03 = new CntrMtyBkgCreateBCImpl();
							//EesEqr1052Event event03 = (EesEqr1052Event)e;	
							
							EesEqr1052ConditionVO conditionVO = new EesEqr1052ConditionVO();							
							
							EesEqr1052MultiVO eesEqr1052MultiVO = new EesEqr1052MultiVO();
							EesEqr1052MultiVO[] eesEqr1052MultiVOs = new EesEqr1052MultiVO[]{eesEqr1052MultiVO};
							
							eesEqr1052MultiVOs[0].setVslCd			(eesEqr0059MultiList.get(i).getVslCd()			);
							eesEqr1052MultiVOs[0].setSkdVoyNo	(eesEqr0059MultiList.get(i).getSkdVoyNo()	);
							eesEqr1052MultiVOs[0].setSkdDirCd		(eesEqr0059MultiList.get(i).getSkdDirCd()		);
							
							//TmpSeq 이 sequence이므로 setSeq는 1이다.
							eesEqr1052MultiVOs[0].setSeq("1");
							eesEqr1052MultiVOs[0].setVlBkgNo(eesEqr0059MultiList.get(i).getCmBkgNo());
							eesEqr1052MultiVOs[0].setCntrNo(eesEqr0059MultiList.get(i).getCntrNo());
							eesEqr1052MultiVOs[0].setCntrTpszCd(eesEqr0059MultiList.get(i).getCntrTpszCd());
							eesEqr1052MultiVOs[0].setPolYd(eesEqr0059MultiList.get(i).getInpYdCd());
							eesEqr1052MultiVOs[0].setClptSeq("");
							eesEqr1052MultiVOs[0].setPodYdCd("");
							eesEqr1052MultiVOs[0].setMvmtStsCd(eesEqr0059MultiList.get(i).getMvmtStsCd());
							
							String vvd = (String)eesEqr0059MultiList.get(i).getVslCd()+(String)eesEqr0059MultiList.get(i).getSkdVoyNo()+(String)eesEqr0059MultiList.get(i).getSkdDirCd()	;
							//conditionVO = event03.getEesEqr1052ConditionVO();							
							conditionVO.setBkgNo(eesEqr0059MultiList.get(i).getBkgNo());
							conditionVO.setPodYdCd(eesEqr0059MultiList.get(i).getInpYdCd());
							conditionVO.setVvd(vvd);
							
							
							//DATA SEARCH 
							String strToEtbDt = "";
							strToEtbDt = command03.searchYardInDateInfo((String)eesEqr0059MultiList.get(i).getInpYdCd(), vvd);
							log.debug("strToEtbDt>>>>>>>>>>>>>>>"+strToEtbDt);
							conditionVO.setToEtbDt(strToEtbDt);
							
							String vsl_cd		= null;
							String skd_voy_no	= null;
							String skd_dir_cd	= null;
							String vsl_lane_cd	= null;
							String vps_port_cd	= null;
							String tmp_seq   = null; // EQR_CTRL_DAT_VRFY 테이블의 seq (나중에 화면 조회에서 사용함)
							String vl_bkg_no = null; // bkg no
							String vd_bkg_no = null; // split bkg no
							
							vsl_cd = eesEqr0059MultiList.get(i).getVslCd();	
							skd_voy_no = eesEqr0059MultiList.get(i).getSkdVoyNo();
							skd_dir_cd = eesEqr0059MultiList.get(i).getSkdDirCd()	;
							vsl_lane_cd =  eesEqr0059MultiList.get(i).getSlanCd();
							vps_port_cd = eesEqr0059MultiList.get(i).getVslLocCd();
							
							String podClptIndSeq = "";
							podClptIndSeq = command03.searchClptIndSEq(gubun,vsl_cd,skd_voy_no,skd_dir_cd,vsl_lane_cd,vps_port_cd);
							conditionVO.setPodClptIndSeq(podClptIndSeq);
							
							GeneralBookingSplitCombineBC generalBookingSplitCombineBC 	= new GeneralBookingSplitCombineBCImpl();
							GeneralBookingReceiptBC	generalBookingReceiptBC 			= new GeneralBookingReceiptBCImpl();
							BLDocumentationBLBC	bLDocumentationBLBC 					= new BLDocumentationBLBCImpl();							
							
							try {
								// TEMP 입력 및 조회(시작) --------------------------------
								begin();
								
								// SPLIT 화면 오른쪽 GRID 내용을 EQR_CTRL_DAT_VRFY 에 입력 (SEQ 를 그대로 입력)
								// 데이타 하나당 하나이므로 SEQ는 1 이다
								command03.addCntrMtyBkgSplitListTmp(eesEqr1052MultiVOs, conditionVO, account);
								tmp_seq = conditionVO.getTmpSeq();
								log.debug(">>>>>>>>>>>>>>>>>tmp_seq:"+tmp_seq);
								// EQR_CTRL_DAT_VRFY 에 입력된 ORG BKG NO 조회
								List<EesEqr1052MultiVO> listTmp = command03.searchCntrMtyBkgSplitListTmp(tmp_seq);			
								
								// TEMP 입력 및 조회(종료) ----------------------------------
								
								// BKG 모듈 작업 (시작) ---------------------------------------			
								//log.debug("listTmp size : " + listTmp.size());
								log.debug(">>>>>>>>>>>>>>>>listTmp.size():"+listTmp.size());
								// EQR_CTRL_DAT_VRFY 에 입력된 ORG BKG NO 만큼 FOR ROOP
								for(int j=0; j<listTmp.size(); j++) {
									
									vl_bkg_no = listTmp.get(j).getVlBkgNo();
									vsl_cd    = listTmp.get(j).getVslCd();
									skd_voy_no= listTmp.get(j).getSkdVoyNo();
									skd_dir_cd= listTmp.get(j).getSkdDirCd();
									
									log.debug(i + " , vl_bkg_no : " + vl_bkg_no);
									log.debug(i + " , vsl_cd : " + vsl_cd);
									log.debug(i + " , skd_voy_no : " + skd_voy_no);											
									log.debug(i + " , skd_dir_cd : " + skd_dir_cd);		
									
									MtyBookingSplitVO mtyBookingSplitVO = new MtyBookingSplitVO();
									BkgBlNoVO orgBkgBlNoVO 				= new BkgBlNoVO();
									BkgBlNoVO splitBkgBlNoVO 			= new BkgBlNoVO();
									NewBkgSplitVO newBkgBlNoVO 			= new NewBkgSplitVO();
								
									// 화면에서 넘겨받은 Original Bkg No. Setting..
									orgBkgBlNoVO.setBkgNo(vl_bkg_no);
											
									// ----- BKG/DOC 메소드 호출 시작 ------
									// Original Bkg No.를 BKG/DOC으로 넘겨 Split BKG No. 받기
									splitBkgBlNoVO = generalBookingSplitCombineBC.searchMtySplitBkgNo(orgBkgBlNoVO, account);
									vd_bkg_no = splitBkgBlNoVO.getBkgNo(); // split bkg no
									log.debug(">>>>>>>>>>>>>>>vd_bkg_no:"+vd_bkg_no);
									newBkgBlNoVO.setNewBkgNo(vd_bkg_no);
									newBkgBlNoVO.setNewBlNo(vd_bkg_no);
									
//									eesEqr0059MultiVO.setOldBkgGrpNo(vl_bkg_no);
//									eesEqr0059MultiVO.setMtyBkgNo(splitBkgBlNoVO.getBkgNo());
						
									// BKG에 넘겨줄 정보를 VO에 셋팅, EQR_VSL_LODG_DCHG_EXE_PLN, EQR_VSL_EXE_PLN_QTY 에 데이터 입력 
									log.debug(">>>>>>>>>>> BKG에 넘겨줄 VO 설정>>>");
									log.debug(">>>>>>>>>>> setVlBkgNo:"+vl_bkg_no);
									log.debug(">>>>>>>>>>> setVdBkgNo:"+vd_bkg_no);
									log.debug(">>>>>>>>>>> setVslCd:"+vsl_cd);
									log.debug(">>>>>>>>>>> setSkdVoyNo:"+skd_voy_no);
									log.debug(">>>>>>>>>>> setSkdDirCd:"+skd_dir_cd);
									conditionVO.setVlBkgNo(vl_bkg_no);
									conditionVO.setVdBkgNo(vd_bkg_no);
									conditionVO.setVslCd(vsl_cd);
									conditionVO.setSkdVoyNo(skd_voy_no);
									conditionVO.setSkdDirCd(skd_dir_cd);
									conditionVO.setOpenFlagRob("N");
									// Set 셋팅 완료 ///////
									
									
									log.debug(">>>>>>>>>TypeC>>>>>>STEP1");
									mtyBookingSplitVO = command03.createRepoBKGSplit(conditionVO, account);  
									mtyBookingSplitVO.setBkgBlNoVO(orgBkgBlNoVO);
									mtyBookingSplitVO.setNewBkgSplitVO(newBkgBlNoVO);
									log.debug(">>>>>>>>>orgBkgBlNoVO:"+orgBkgBlNoVO);
									log.debug(">>>>>>>>>newBkgBlNoVO:"+newBkgBlNoVO);
									
									log.debug(">>>>>>>>>TypeC>>>>>>STEP2");
									// Mty Booking을 Split
									generalBookingReceiptBC.splitMtyRepoBooking(mtyBookingSplitVO, account);
									
									
									log.debug(">>>>>>>>>TypeC>>>>>>STEP3");
									// Mty Booking의 Cntr, B/L을 Split
									bLDocumentationBLBC.splitMtyRepoBlCntr(mtyBookingSplitVO, account);
									
									
									log.debug(">>>>>>>>>TypeC>>>>>>STEP4");
									// 추가된 Cntr에 대해서 Qty 계산, Update시 Cntr을 전부 Detach하면 cancel 처리
									generalBookingReceiptBC.completeMtyRepoBkgSplit(mtyBookingSplitVO, account);
									
									
									// ----- BKG/DOC 메소드 호출 종료	---		
									log.debug(">>>>>>>>>TypeC>>>>>>STEP5");
									// 4. Booking 쪽 Report에서 속도향상을 위해서 미리 Qty 정보를 가공
									PerformanceReportBC performReportBc = new PerformanceReportBCImpl();		
									performReportBc.manageQtyCntrCoposite(splitBkgBlNoVO.getBkgNo(), "CQ");
									performReportBc.manageQtyCntrCoposite(orgBkgBlNoVO.getBkgNo(), "CQ");
									log.debug(">>>>>>>>>TypeC>>>>>>STEP5");
							
								}
								//commit();
								// BKG 모듈 작업 (종료) ---------------------------------------
								
								eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());

								
							}catch(EventException ex){
								rollback();
								throw ex;
							}catch(Exception ex){
								throw new EventException(ex.getMessage(), ex);
							}	
						}
					}
				}
			}
					
			//commit();
			/*eventResponse.setRsVoList(list);          
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		if(gubun != null) {
			if ( gubun.equals("V") ){
				//return this.searchTrunkVesselAndFeederCntrRepoPlan(e);
			} else if ( gubun.equals("W") ){
				// call retrieve logic after saving
				//return this.searchTruckAndRailAndBargeCntrRepoPlan(e);
			}
		}*/
			rollback();
		return eventResponse;
	}
}
