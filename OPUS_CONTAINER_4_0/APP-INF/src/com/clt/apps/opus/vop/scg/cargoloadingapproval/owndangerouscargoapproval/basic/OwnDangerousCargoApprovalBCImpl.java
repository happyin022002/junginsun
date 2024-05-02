/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnDangerousCargoApprovalBCImpl.java
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.CargoLoadingApprovalSC;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.cargoapprovalcommon.integration.CargoApprovalCommonDBDAO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.cargoapprovalcommon.vo.ScgCargoApprovalCommonVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration.OwnDangerousCargoApprovalDBDAO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration.OwnDangerousCargoApprovalDBEmailDAO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalEmlVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionPortVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionSegregationVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionVesselOperatorVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnScgListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgAprovalAuthCdVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeDetailVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestDetailVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SendDgEdiRequestVO;
import com.clt.apps.opus.vop.scg.scgcommon.externalinterface301fulldgapproval.basic.ExternalInterface301FullDGApprovalBC;
import com.clt.apps.opus.vop.scg.scgcommon.externalinterface301fulldgapproval.basic.ExternalInterface301FullDGApprovalBCImpl;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.basic.ScgUtilEai;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.FlatFileAckVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.SendFlatFileVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.basic.SendEdiFromPartnerLinesMgtBC;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.basic.SendEdiFromPartnerLinesMgtBCImpl;
import com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.vo.ConsortiumVoyageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.core.layer.service.Command;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.ScgAproRqstVO;
import com.clt.syscommon.common.table.ScgAuthorizationVO;
import com.clt.syscommon.common.table.ScgDgCgoVO;
import com.clt.syscommon.common.table.ScgRfCgoVO;
import com.clt.syscommon.common.table.ScgVvdAproRqstVO;



/**
 * OPUS-CargoLoadingApproval Business Logic Basic Command implementation<br>
 * - Handling business transactions of OPUS-CargoLoadingApproval<br>
 *
 * @author
 * @see VOP_SCG-0014EventResponse,OwnDangerousCargoApprovalBC
 * @since J2EE 1.6
 */
public class OwnDangerousCargoApprovalBCImpl extends BasicCommandSupport implements OwnDangerousCargoApprovalBC {

	// Database Access Object
	private transient OwnDangerousCargoApprovalDBDAO dbDao = null;
	private transient OwnDangerousCargoApprovalDBEmailDAO dbEmlDao = null;
	
	private transient CargoApprovalCommonDBDAO dbDao2 = null;

	/**
	 * OwnDangerousCargoApprovalBCImpl  object creation<br>
	 * OwnDangerousCargoApprovalDBDAO creation<br>
	 */
	public OwnDangerousCargoApprovalBCImpl() {
		dbDao    = new OwnDangerousCargoApprovalDBDAO();
		dbEmlDao = new OwnDangerousCargoApprovalDBEmailDAO();
		
		dbDao2 = new CargoApprovalCommonDBDAO();
	}
	
	/**
	 * Booking에서의 SCG's Request save <br>
	 * 
	 * @param scgAproRqstVOs
	 * @param scgVvdAproRqstVOs
	 * @param account
	 * @exception EventException
	 */ 
	
	public void requestSpecialCargoApproval(ScgAproRqstVO[] scgAproRqstVOs, ScgVvdAproRqstVO[] scgVvdAproRqstVOs, SignOnUserAccount account) throws EventException {
		
		SendEdiFromPartnerLinesMgtBC	sendEdiCmd	= new SendEdiFromPartnerLinesMgtBCImpl();
		
		try {
			
			//Always Insert in BKG, delete [U,D]
			List<ScgAproRqstVO> 	insertVoList 	= new ArrayList<ScgAproRqstVO>();
			List<ScgVvdAproRqstVO> 	insertVvdVoList = new ArrayList<ScgVvdAproRqstVO>();
			
			for ( int i=0; scgAproRqstVOs != null && !"".equals(scgAproRqstVOs) && i<scgAproRqstVOs.length; i++ ) {
				scgAproRqstVOs[i].setCreUsrId(account.getUsr_id());
				insertVoList.add			(scgAproRqstVOs[i]);
			}
			
			if ( insertVoList.size() > 0 ) {
				//Before inserting SCG_APRO_RQST, change previous request's LST_RQST_DAT_FLG value to 'N'.
				dbDao.modifySCGRequestLstFlg(insertVoList);
				dbDao.addSCGRequest			(insertVoList);
				
				
			}

			for ( int i=0; scgVvdAproRqstVOs != null && !"".equals(scgVvdAproRqstVOs) && i<scgVvdAproRqstVOs.length; i++ ) {
				scgVvdAproRqstVOs[i].setCreUsrId(account.getUsr_id());
				insertVvdVoList.add			(scgVvdAproRqstVOs[i]);
			}			
			if ( insertVvdVoList.size() > 0 ) {
				dbDao.addSCGVvdRequest		(insertVvdVoList);
			}
			
			
			boolean			isAutoCxlTarget	= false;
			String			tmpBKGNo		= null;
			List<String> 	tmpBkgNoList	= new ArrayList<String>();		
			
			for(int i=0; i< insertVoList.size(); i++){
				
				if ("DG".equals(insertVoList.get(i).getSpclCgoCateCd())) {
					dbDao.addScgDgCgoDetail		(insertVoList.get(i).getBkgNo(), insertVoList.get(i).getSpclCgoAproRqstSeq(), "");
					dbDao.addDeclarantCustomer	(insertVoList.get(i).getBkgNo(), insertVoList.get(i).getSpclCgoAproRqstSeq(), "");
					
					
					/************************************************************************** 
					 * Handling VVD Change for DG Application 
					 **************************************************************************/
					tmpBKGNo		= insertVoList.get(i).getBkgNo();
					
					if(!tmpBkgNoList.contains(tmpBKGNo)){
						isAutoCxlTarget		= true;
						tmpBkgNoList.add	(tmpBKGNo);
					}else{
						isAutoCxlTarget		= false;
					}
					
					if(isAutoCxlTarget){
						
						//--==========================================================================--//
						
						List<SendDgEdiRequestVO> tmpVOList	= dbDao.selectAproRqstForVVDChange(insertVoList.get(i));
						
						if(tmpVOList != null && tmpVOList.size()>0){
							
							for(SendDgEdiRequestVO tmpVO : tmpVOList){
								
								dbDao.updateAproRqstForVVDChange	(tmpVO);
								SendDgEdiRequestVO tmpVO2			= dbDao.searchVVDAproRqstForVVDChange(tmpVO);
								
								tmpVO2.setEdiStatus					("EDI_AUTO_CXL");	//AUTO CANCELLATION EDI
								tmpVO2.setEdiMsgStsCd				("R");				//"R" REJECT EDI MESSAGE
								sendEdiCmd.sendDgApvlOwnBkgEdi		(tmpVO2, account);
								
							}
						}
						//--==========================================================================--//
					}
					/************************************************************************** 
					 * Handling VVD Change for DG Application 
					 **************************************************************************/
					
				}else if ("AK".equals(insertVoList.get(i).getSpclCgoCateCd())) {
					
					dbDao.addScgAwkCgoDetail	(insertVoList.get(i).getBkgNo(), insertVoList.get(i).getSpclCgoAproRqstSeq(), "");
					dbDao.addScgAwkDimDetail	(insertVoList.get(i).getBkgNo(), insertVoList.get(i).getSpclCgoAproRqstSeq(), "");
					
				}else if ("BB".equals(insertVoList.get(i).getSpclCgoCateCd())) {
					
					dbDao.addScgBbCgoDetail		(insertVoList.get(i).getBkgNo(), insertVoList.get(i).getSpclCgoAproRqstSeq(), "");
					
				}else if ("RF".equals(insertVoList.get(i).getSpclCgoCateCd())) {
					
//					log.info("\n <<<<TEST111>>>>>> ["+insertVoList.get(i).getSpclCgoAproRqstSeq()+"]"); //null why?
					dbDao.addScgRfCgoDetail		(insertVoList.get(i).getBkgNo(), insertVoList.get(i).getSpclCgoAproRqstSeq(), "");
								
					/**
					 * 2016-07-28
					 * REEFER 자동 승인 처리 
					 * SCG_AUTHORIZATION 으로의 자동 INSERT START 
					 **/
					
					SpecialCargoReceiptBC 		   		command1 	= new SpecialCargoReceiptBCImpl();				//Send approval info to own BKG-SPCL-CGO
					GeneralBookingReceiptBC 	   		command2 	= new GeneralBookingReceiptBCImpl();			//Send approval info to own BKG-STATUS
					List<ScgAuthorizationVO> 			rfAuthVO	= new ArrayList<ScgAuthorizationVO>();
					ScgCargoApprovalCommonVO 			comvo 	    = new ScgCargoApprovalCommonVO();				//Make Approval Reference Number 
					List<SearchScgAprovalAuthCdVO> 		list 		= new ArrayList<SearchScgAprovalAuthCdVO>();	//Find update flag and Approval Status code 
					
					rfAuthVO = dbDao.searchScgRfCgoAutoApproval(insertVoList.get(i).getBkgNo(), insertVoList.get(i).getSpclCgoAproRqstSeq());
					
//					log.info("\n <<<<TEST>>>>>> ["+insertVoList.get(i).getSpclCgoAproRqstSeq()+"]"); //null why?
					for (int k=0; k<rfAuthVO.size(); k++){
						
						ScgAuthorizationVO vo = rfAuthVO.get(k);
						
						vo.setBkgNo(rfAuthVO.get(k).getBkgNo());
						vo.setSpclCgoAproRqstSeq(rfAuthVO.get(k).getSpclCgoAproRqstSeq());
						vo.setVslPrePstCd(rfAuthVO.get(k).getVslPrePstCd());
						vo.setSpclCgoCateCd(rfAuthVO.get(k).getSpclCgoCateCd()); //RF
						vo.setVslSeq(rfAuthVO.get(k).getVslSeq());
						vo.setRcSeq(rfAuthVO.get(k).getRcSeq());
						vo.setRgnShpOprCd(rfAuthVO.get(k).getRgnShpOprCd());	
						vo.setCreUsrId(rfAuthVO.get(k).getCreUsrId());
						vo.setUpdUsrId(rfAuthVO.get(k).getUpdUsrId());
						
						dbDao.addRfAutoSCGApprovalS(vo);	
						String strPolCd = insertVvdVoList.get(i).getPolCd();
						comvo.setPolCd(strPolCd);
						String aproRefNo = dbDao2.searchSpclAproRefNo(comvo);
						vo.setAproRefNo(aproRefNo);
						dbDao.modifySCGAproRefNoS(vo, strPolCd, "RF");
					}
					
//					List<SearchScgAprovalAuthCdVO> 	list 		= new ArrayList<SearchScgAprovalAuthCdVO>();
					
//					for (int k=0; k<rfAuthVO.size(); k++) {
//					    List<SearchScgAprovalAuthCdVO> authCd  = dbDao.searchScgApprovalAuthCd(rfAuthVO.get(k), "RF");
//						if(authCd.get(0).getSpclCgoAuthCd() != null){
//							log.info("\n\n ========= TOP.TOP.TOP scgAuthorizationVO >> i ["+i+"] authCd ["+authCd.get(0).getSpclCgoAuthCd()+"] ========= \n\n");	
//						}
//						
//						list.addAll	(authCd);
//					}
					
					for (int k=0; k<rfAuthVO.size(); k++) {
						
						SearchScgAprovalAuthCdVO vo = new SearchScgAprovalAuthCdVO();
						
						vo.setBkgNo(rfAuthVO.get(k).getBkgNo());
						vo.setSpclCgoAproRqstSeq(rfAuthVO.get(k).getSpclCgoAproRqstSeq());
						vo.setUpdFlg("Y");
					    vo.setSpclCgoAuthCd("Y");
					    vo.setCgoSeq(rfAuthVO.get(k).getRcSeq());
						list.add(vo);
					}
					
					for(int j= 0; j<list.size(); j ++){
						
						BkgBlNoVO bkgBlNoVO 		= new BkgBlNoVO();
						bkgBlNoVO.setBkgNo			(list.get(i).getBkgNo());
//						log.info("\n\n ========= TW.TW.TW RF AUTO APPROVAL >> j ["+j+"] authCd ["+bkgBlNoVO.getBkgNo()+"] <++++++> ["+bkgBlNoVO.getBkgStsCd()+"] ========= \n\n");
//						log.info("\n\n ========= TW.TW.TW RF AUTO APPROVAL >> j ["+j+"] authCd ["+list.get(j).getSpclCgoAuthCd()+"] <++++++> ["+list.get(j).getCgoSeq()+"]<++++++>" +account.getUsr_id() + " ========= \n\n");
						//Calling for BKG_RF_CGO 
						command1.modifyAproStatus	(list.get(j).getBkgNo(), list.get(j).getSpclCgoAuthCd(), list.get(j).getCgoSeq(), "R", account.getUsr_id());
						//Calling for Booking Status change
						command2.changeBkgStatus	("Y", bkgBlNoVO, false, account);
						}
					
					/*******************************************************************************************
					 * THE START OF INTERFACING EXTERNAL MODULE OR SYSTEM
					 *******************************************************************************************/
					BookingARCreationBC 			 		command3 					= new BookingARCreationBCImpl();				//A/R INV  I/F calling about Rating existing BKG in case of special cargo loading approval
					OwnDangerousCargoApprovalBC 			command4 					= new OwnDangerousCargoApprovalBCImpl();		//Approval handling of own booking
					CostAssignBC 					    	command5 					= new CostAssignBCImpl();						//COA I/F calling in case of Special Cargo Approval
					ExternalInterface301FullDGApprovalBC 	command6					= new ExternalInterface301FullDGApprovalBCImpl();
					ARBkgInterfaceCreationVO 				bkgIfVo 					= new ARBkgInterfaceCreationVO();	
					CoaBkgComIfVO 							coaBkgComIfVo				= new CoaBkgComIfVO();
					SearchScgAprovalAuthCdVO				searchScgAprovalAuthCdVO 	= new SearchScgAprovalAuthCdVO();
					
					searchScgAprovalAuthCdVO.setBkgNo						(list.get(i).getBkgNo				());
					searchScgAprovalAuthCdVO.setSpclCgoAproRqstSeq			(list.get(i).getSpclCgoAproRqstSeq	());
					searchScgAprovalAuthCdVO.setVslPrePstCd					(list.get(i).getVslPrePstCd			());
					searchScgAprovalAuthCdVO.setVslSeq						(list.get(i).getVslSeq				());
					
					
					/** INTERFACE TO INV WHEN APPROVING SPECIAL CARGO ******************************************/
					
					bkgIfVo.setBkgNo					(list.get(i).getBkgNo());
					bkgIfVo.setBkgCorrNo				("");
					bkgIfVo.setUserId					(account.getUsr_id() == null || "".equals(account.getUsr_id()) ? "SYSTEM" : account.getUsr_id());
					bkgIfVo.setManDivInd				("S");

					String sFlag = "";
					String sIfRmk	= null;
					if(sFlag != null && "INIT".equals(sFlag)){
						sIfRmk	= "A/R(INV) I/F Finished for First Initialization";
						
					}else{
						sIfRmk	= "A/R(INV) I/F Finished";
					}
//					log.info("\n\n ========= TW.TW.TW RF AUTO AR/INV IF >> j ["+i+"] authCd ["+list.get(i).getBkgNo()+"] <++++++> ["+list.get(i).getSpclCgoAproRqstSeq()+"] ========= \n\n");
					command3.interfaceBKGARInvoiceToINV(bkgIfVo);
					//INSERT LOG FOR COA I/F >> [SCG_APRO_RQST.IF_RMK]//
					searchScgAprovalAuthCdVO.setIfRmk	(sIfRmk);
					command4.modifySCGRequestIfRmk		(searchScgAprovalAuthCdVO, account);
						
					/** INTERFACE TO COA WHEN APPROVING SPECIAL CARGO ******************************************/
					
					coaBkgComIfVo.setBkgNo				(list.get(i).getBkgNo());
					coaBkgComIfVo.setCostSrcSysCd		("BKG");
					coaBkgComIfVo.setIfRmk				("Booking Status Change");
					coaBkgComIfVo.setCreUsrId			(account.getUsr_id() == null || "".equals(account.getUsr_id()) ? "SYSTEM" : account.getUsr_id());
					coaBkgComIfVo.setUpdUsrId			(account.getUsr_id() == null || "".equals(account.getUsr_id()) ? "SYSTEM" : account.getUsr_id());
					command5.modifyCoaCommonInterface	(coaBkgComIfVo);
					//INSERT LOG FOR COA I/F >> [SCG_APRO_RQST.IF_RMK]//
					searchScgAprovalAuthCdVO.setIfRmk	("COA I/F Finished");
					command4.modifySCGRequestIfRmk		(searchScgAprovalAuthCdVO, account);

						
						
					/** INTERFACE TO BKG FOR 301F **************************************************************/
					
					command6.interfaceSendEDISpecialCargoApproval			(searchScgAprovalAuthCdVO, account);	
					//INSERT LOG FOR COA I/F >> [SCG_APRO_RQST.IF_RMK]//
					searchScgAprovalAuthCdVO.setIfRmk	("301F(BKG) I/F Finished");
					command4.modifySCGRequestIfRmk		(searchScgAprovalAuthCdVO, account);
					
						
					/*******************************************************************************************
					 * THE END OF INTERFACING EXTERNAL MODULE OR SYSTEM
					 *******************************************************************************************/
					
					/**
					 * 2016-07-28
					 * REEFER 자동 승인 처리 
					 * SCG_AUTHORIZATION 으로의 자동 INSERT END
					 **/
					
				}else if ("SS".equals(insertVoList.get(i).getSpclCgoCateCd())) {
					
					dbDao.addScgStwgCgoDetail	(insertVoList.get(i).getBkgNo(), insertVoList.get(i).getSpclCgoAproRqstSeq(), "");
					
				}
							
			}

			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Request"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Request"}).getMessage(), ex);
		}
	}

	
	/**
	 * Booking SCG CARGO CANCEL or DELETE request save. <br>
	 * 
	 * @param scgFlg		'DG','AK','BB','RF'
	 * @param bkgNo			booking_no
	 * @param cgoSeqs		cargo_seq
	 * @param spclCgoAproCds	SPCL_CGO_APRO_CD
	 * @param account
	 * @exception EventException
	 */
	public void cancelSpecialCargoRequest(String scgFlg, String bkgNo, String[] cgoSeqs, String[] spclCgoAproCds, SignOnUserAccount account) throws EventException {
		
		try {
		
			String strSpclCgoAproRqstSeq = "";
			String dumyCgoSeq = "";
			
			for ( int i=0; i<cgoSeqs.length; i++ ) {
				
				if (spclCgoAproCds[i].equals("C")) {
					spclCgoAproCds[i] = "C";
				}else{
					spclCgoAproCds[i] = "D";
				}
				
				//In SCG, about requested bookings, build history on cancel in SCG Cargo Table.(Except Split, Combined Bookings)
				if (dbDao.searchAproRqst(bkgNo, scgFlg).size() > 0) {
					
					if (scgFlg.equals("DG")){
						
						if (dbDao.searchScgDgCgoDetail(bkgNo, strSpclCgoAproRqstSeq).size() < 1) {
							dbDao.addScgDgCgoDetail(bkgNo, strSpclCgoAproRqstSeq, dumyCgoSeq);
							dbDao.addScgDgCgoDetail(bkgNo, strSpclCgoAproRqstSeq, cgoSeqs[i]);
						}else{
							dbDao.modifyScgDgCgoDetail(bkgNo, cgoSeqs[i], spclCgoAproCds[i]);
						}
						
					}else if (scgFlg.equals("AK")){
						
						if (dbDao.searchScgAwkCgoDetail(bkgNo, strSpclCgoAproRqstSeq).size() < 1) {
							dbDao.addScgAwkCgoDetail(bkgNo, strSpclCgoAproRqstSeq, dumyCgoSeq);
							dbDao.addScgAwkDimDetail(bkgNo, strSpclCgoAproRqstSeq, dumyCgoSeq);
							dbDao.addScgAwkCgoDetail(bkgNo, strSpclCgoAproRqstSeq, cgoSeqs[i]);
							dbDao.addScgAwkDimDetail(bkgNo, strSpclCgoAproRqstSeq, cgoSeqs[i]);
						}else{
							dbDao.modifyScgAwkCgoDetail(bkgNo, cgoSeqs[i], spclCgoAproCds[i]);
						}
						
					}else if (scgFlg.equals("BB")){
						
						if (dbDao.searchScgBbCgoDetail(bkgNo, strSpclCgoAproRqstSeq).size() < 1) {
							dbDao.addScgBbCgoDetail(bkgNo, strSpclCgoAproRqstSeq, dumyCgoSeq);
							dbDao.addScgBbCgoDetail(bkgNo, strSpclCgoAproRqstSeq, cgoSeqs[i]);
						}else{
							dbDao.modifyScgBbCgoDetail(bkgNo, cgoSeqs[i], spclCgoAproCds[i]);
						}
						
					}else if (scgFlg.equals("RF")){
						
						if (dbDao.searchScgRfCgoDetail(bkgNo, strSpclCgoAproRqstSeq).size() < 1) {
							dbDao.addScgRfCgoDetail(bkgNo, strSpclCgoAproRqstSeq, dumyCgoSeq);
							dbDao.addScgRfCgoDetail(bkgNo, strSpclCgoAproRqstSeq, cgoSeqs[i]);
						}else{
							dbDao.modifyScgRfCgoDetail(bkgNo, cgoSeqs[i], spclCgoAproCds[i]);
						}
						
					}
				}
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Request"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Request"}).getMessage(), ex);
		}
	}	
	/**
	 * SPCL CGO APVL for Own BKG's List retrieve <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @return SearchOwnScgListVO
	 * @exception EventException
	 */
	public SearchOwnScgListVO searchScgRequestList(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws EventException {
		
		try {
			return dbDao.searchScgRequestList(scgRequestListOptionVO, account);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
		
	}

	/**
	 * SPCL CGO APVL for Own BKG approval save. <br>
	 * 
	 * @param scgAuthorizationVO
	 * @param arrCrrCd
	 * @param arrPolCd
	 * @param strScgFlg
	 * @param account
	 * @return List<SearchScgAprovalAuthCdVO>
	 * @exception EventException
	 */
	public List<SearchScgAprovalAuthCdVO> manageSCGApproval(ScgAuthorizationVO[] scgAuthorizationVO, String[] arrCrrCd, String[] arrPolCd, String strScgFlg, SignOnUserAccount account) throws EventException{
		
		try {

			String 							dumyCgoSeq 	= "";
			List<SearchScgAprovalAuthCdVO> 	list 		= new ArrayList<SearchScgAprovalAuthCdVO>();
			//2016-03-21 Own, Partner Approval Reference Number 통합
			ScgCargoApprovalCommonVO 		comvo 		= new ScgCargoApprovalCommonVO();
			
			List<ScgAuthorizationVO> chkVoList	= new ArrayList<ScgAuthorizationVO>();
			
			for (int i=0; i<scgAuthorizationVO.length; i++) {
				
				log.info("\n scgAuthorizationVO[i].getSpclCgoAuthCd() <<< "+scgAuthorizationVO[i].getSpclCgoAuthCd()+" >>> \n");
				
				if (scgAuthorizationVO[i].getSpclCgoAuthCd().equals("N") || scgAuthorizationVO[i].getSpclCgoAuthCd().equals("P") || scgAuthorizationVO[i].getSpclCgoAuthCd().equals("Y")) {
					
//					String strCrrCd = arrCrrCd[i];
					//String strPolCd = arrPolCd[i].substring(arrPolCd[i].length()-3, arrPolCd[i].length());
					String strPolCd = arrPolCd[i];
				
					log.info("\n scgAuthorizationVO[i].getSpclCgoAuthSeq() <<< "+scgAuthorizationVO[i].getSpclCgoAuthSeq()+" >>> \n");
					
					if (scgAuthorizationVO[i].getSpclCgoAuthSeq().equals("") || scgAuthorizationVO[i].getSpclCgoAuthSeq() == null) {
						
						scgAuthorizationVO[i].setRgnShpOprCd(scgAuthorizationVO[0].getRgnShpOprCd());
						scgAuthorizationVO[i].setAuthOfcCd(account.getOfc_cd());
						scgAuthorizationVO[i].setAuthUsrId(account.getUsr_id());
						scgAuthorizationVO[i].setCreUsrId(account.getUsr_id());
	
						if (!scgAuthorizationVO[i].getSpclCgoAuthCd().equals("P")) {
							
							//스토이지인경우
							if("Y".equals(scgAuthorizationVO[i].getStwgFlg())){	//2015-01-05 추가

								if (dbDao.searchScgStwgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
									dbDao.addScgStwgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
								}
								
							}else{
							
								if (!scgAuthorizationVO[i].getDcgoSeq().equals("")) {
									if (dbDao.searchScgDgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
										dbDao.addScgDgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
									}
								}
								if (!scgAuthorizationVO[i].getAwkCgoSeq().equals("")) {
									if (dbDao.searchScgAwkCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
										dbDao.addScgAwkCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
										dbDao.addScgAwkDimDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
									}
								}
								if (!scgAuthorizationVO[i].getBbCgoSeq().equals("")) {
									if (dbDao.searchScgBbCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
										dbDao.addScgBbCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
									}
								}
								if (!scgAuthorizationVO[i].getRcSeq().equals("")) {
									if (dbDao.searchScgRfCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
										dbDao.addScgRfCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
									}
								}
								
							}
							
						}else if(scgAuthorizationVO[i].getSpclCgoAuthCd().equals("P")) {
							//스토이지인경우
							if("Y".equals(scgAuthorizationVO[i].getStwgFlg())){	//2015-01-05 추가
								if (dbDao.searchScgStwgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
									dbDao.addScgStwgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
								}
							}
						}
						
						if("Y".equals(scgAuthorizationVO[i].getStwgFlg())){
							scgAuthorizationVO[i].setSpclCgoCateCd("SS");	//스토이지 카테고리
						}
						
						//dbDao.addSCGApprovalS		(scgAuthorizationVO[i]);
						/**
						 * 2016-07-01
						 * SCG_AUTHORIZATION에 Insert 하기 전, 같은 정보가 존재 하는 경우 Exception 처리 
						 * COM_ERR_MSG : SCG60085
						 * [#Booking No.] has been updated by other user while you are updating and couldn't update all booking you updated. Please kindly retrieve new data and update again.
						 */
						//List<ScgAuthorizationVO> chkVoList	= new ArrayList<ScgAuthorizationVO>();
						
							chkVoList  = dbDao.searchScgAuthorizationInputVO(scgAuthorizationVO[i]);
						   	if(chkVoList.size()>0){
						   							   		
							   	for(ScgAuthorizationVO chkVo : chkVoList){
							   		
							   		if(scgAuthorizationVO[i].getBkgNo().equals(chkVo.getBkgNo()) &&
							   		   scgAuthorizationVO[i].getSpclCgoAproRqstSeq().equals(chkVo.getSpclCgoAproRqstSeq()) &&	
							   		   scgAuthorizationVO[i].getVslPrePstCd().equals(chkVo.getVslPrePstCd()) &&
							   		   scgAuthorizationVO[i].getVslSeq().equals(chkVo.getVslSeq()) &&
							   		   scgAuthorizationVO[i].getSpclCgoCateCd().equals(chkVo.getSpclCgoCateCd())
							   		   ){
								   			if(!scgAuthorizationVO[i].getDcgoSeq().equals("")){
								   				if(!scgAuthorizationVO[i].getUpdDt().equals(chkVo.getUpdDt())){
	
							   					log.info("\n ======== <<scgAuthorizationVo[i] ===== getUpdDt>> ["+scgAuthorizationVO[i].getUpdDt()+"]"
							   							+"\n ======== <<chkVo ===== getUpdDt>> ["+chkVo.getUpdDt()+"]");
							   					log.info("\n ========DCGO_SEQ <<scgAuthorizationVo[i] ===== getDcgoSeq>> ["+scgAuthorizationVO[i].getDcgoSeq()+"]" 
							   							+"\n ========DCGO_SEQ <<chkVo ===== getDcgoSeq>> ["+chkVo.getDcgoSeq()+"]");
												throw new EventException(new ErrorHandler("SCG60085", new String[]{scgAuthorizationVO[i].getBkgNo()}).getMessage());
								   				}
								   			}
								   			if(!scgAuthorizationVO[i].getAwkCgoSeq().equals("")){
								   				if(!scgAuthorizationVO[i].getUpdDt().equals(chkVo.getUpdDt())){
	
							   					log.info("\n ======== <<scgAuthorizationVo[i] ===== getUpdDt>> ["+scgAuthorizationVO[i].getUpdDt()+"]"
							   							+"\n ======== <<chkVo ===== getUpdDt>> ["+chkVo.getUpdDt()+"]");
							   					log.info("\n ========AWK_CGO_SEQ <<scgAuthorizationVo[i] ===== getAwkCgoSeq>> ["+scgAuthorizationVO[i].getAwkCgoSeq()+"]"
							   							+"\n ========AWK_CGO_SEQ <<chkVo ===== getAwkCgoSeq>> ["+chkVo.getAwkCgoSeq()+"]");
												throw new EventException(new ErrorHandler("SCG60085", new String[]{scgAuthorizationVO[i].getBkgNo()}).getMessage());
								   				}
								   			}
								   			if(!scgAuthorizationVO[i].getBbCgoSeq().equals("")){
								   				if(!scgAuthorizationVO[i].getUpdDt().equals(chkVo.getUpdDt())){
							   					log.info("\n ======== <<scgAuthorizationVo[i] ===== getUpdDt>> ["+scgAuthorizationVO[i].getUpdDt()+"]"
							   							+"\n ======== <<chkVo ===== getUpdDt>> ["+chkVo.getUpdDt()+"]");
							   					log.info("\n ========BB_CGO_SEQ <<scgAuthorizationVo[i] ===== getBbCgoSeq>> ["+scgAuthorizationVO[i].getBbCgoSeq()+"]"
							   							+"\n ========BB_CGO_SEQ <<chkVo ===== getBbCgoSeq>> ["+chkVo.getBbCgoSeq()+"]");
												throw new EventException(new ErrorHandler("SCG60085", new String[]{scgAuthorizationVO[i].getBkgNo()}).getMessage());
								   				}
								   			}
								   			if(!scgAuthorizationVO[i].getRcSeq().equals("")){
								   				if(!scgAuthorizationVO[i].getUpdDt().equals(chkVo.getUpdDt())){
							   					log.info("\n ======== <<scgAuthorizationVo[i] ===== getUpdDt>> ["+scgAuthorizationVO[i].getUpdDt()+"]"
							   							+"\n ======== <<chkVo ===== getUpdDt>> ["+chkVo.getUpdDt()+"]");
							   					log.info("\n ========RC_SEQ <<scgAuthorizationVo[i] ===== getRcSeq>> ["+scgAuthorizationVO[i].getRcSeq()+"]"
							   							+"\n ========RC_SEQ <<chkVo ===== getRcSeq>> ["+chkVo.getRcSeq()+"]");
												throw new EventException(new ErrorHandler("SCG60085", new String[]{scgAuthorizationVO[i].getBkgNo()}).getMessage());
								   				}
								   			}
								   			if(!scgAuthorizationVO[i].getStwgCgoSeq().equals("")){
								   				if(!scgAuthorizationVO[i].getUpdDt().equals(chkVo.getUpdDt())){
							   					log.info("\n ======== <<scgAuthorizationVo[i] ===== getUpdDt>> ["+scgAuthorizationVO[i].getUpdDt()+"]"
							   							+"\n ======== <<chkVo ===== getUpdDt>> ["+chkVo.getUpdDt()+"]");
							   					log.info("\n ========STWG_CGO_SEQ <<scgAuthorizationVo[i] ===== getStwgCgoSeq>> ["+scgAuthorizationVO[i].getStwgCgoSeq()+"]"
							   							+"\n ========STWG_CGO_SEQ <<chkVo ===== getStwgCgoSeq>> ["+chkVo.getStwgCgoSeq()+"]");
												throw new EventException(new ErrorHandler("SCG60085", new String[]{scgAuthorizationVO[i].getBkgNo()}).getMessage());
								   				}
								   			}
							   			}
							   		}
								}
							
							
						
						/**
						 * When creating SCG_AUTHORIZATION, SPCL_CGO_AUTH_SEQ has to be MAX+1
						 * Create by executeUpdate, not executeBatch, so call addSCGApprovalS in FOR clause.
						 * Doesn't use insertVoList.add(scgAuthorizationVO[i])
						 */
						dbDao.addSCGApprovalS		(scgAuthorizationVO[i]);
						
					}else{
						
						scgAuthorizationVO[i].setAuthOfcCd(account.getOfc_cd());
						scgAuthorizationVO[i].setAuthUsrId(account.getUsr_id());
						scgAuthorizationVO[i].setUpdUsrId(account.getUsr_id());
						
						//스토이지인경우
						if("Y".equals(scgAuthorizationVO[i].getStwgFlg())){	//2015-01-05 추가

							if (dbDao.searchScgStwgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
								dbDao.addScgStwgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
							}
							
						}else{
	
							if (!scgAuthorizationVO[i].getDcgoSeq().equals("")) {
								if (dbDao.searchScgDgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
									dbDao.addScgDgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
								}
							}
							if (!scgAuthorizationVO[i].getAwkCgoSeq().equals("")) {
								if (dbDao.searchScgAwkCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
									dbDao.addScgAwkCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
									dbDao.addScgAwkDimDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
								}
							}
							if (!scgAuthorizationVO[i].getBbCgoSeq().equals("")) {
								if (dbDao.searchScgBbCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
									dbDao.addScgBbCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
								}
							}
							if (!scgAuthorizationVO[i].getRcSeq().equals("")) {
								if (dbDao.searchScgRfCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
									dbDao.addScgRfCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
								}
							}
							
						}

//						dbDao.modifySCGApprovalS	(scgAuthorizationVO[i]);
						
						/** 
						 * 2016-07-01
						 * SCG_AUTHORIZATION에 Update 하기 전, 같은 정보가 존재 하는 경우 Exception 처리 
						 * COM_ERR_MSG : SCG60085
						 * [#Booking No.] has been updated by other user while you are updating and couldn't update all booking you updated. Please kindly retrieve new data and update again.
						 */
					   	chkVoList  = dbDao.searchScgAuthorizationUpdateVO(scgAuthorizationVO[i]);
					   	if(chkVoList.size()>0){
						   	for(ScgAuthorizationVO chkVo : chkVoList){
						   		
						   		if(scgAuthorizationVO[i].getBkgNo().equals(chkVo.getBkgNo()) &&
						   		   scgAuthorizationVO[i].getSpclCgoAproRqstSeq().equals(chkVo.getSpclCgoAproRqstSeq()) &&	
						   		   scgAuthorizationVO[i].getVslPrePstCd().equals(chkVo.getVslPrePstCd()) &&
						   		   scgAuthorizationVO[i].getVslSeq().equals(chkVo.getVslSeq()) &&
						   		   scgAuthorizationVO[i].getSpclCgoCateCd().equals(chkVo.getSpclCgoCateCd())
						   		   ){
							   			if(!scgAuthorizationVO[i].getDcgoSeq().equals("")){
							   				if(!scgAuthorizationVO[i].getUpdDt().equals(chkVo.getUpdDt())){
							   					log.info("\n ======== <<scgAuthorizationVo[i] ===== getUpdDt>> ["+scgAuthorizationVO[i].getUpdDt()+"]"
							   							+"\n ======== <<chkVo ===== getUpdDt>> ["+chkVo.getUpdDt()+"]");
							   					log.info("\n ========DCGO_SEQ <<scgAuthorizationVo[i] ===== getDcgoSeq>> ["+scgAuthorizationVO[i].getDcgoSeq()+"]" 
							   							+"\n ========DCGO_SEQ <<chkVo ===== getDcgoSeq>> ["+chkVo.getDcgoSeq()+"]");
											throw new EventException(new ErrorHandler("SCG60085", new String[]{scgAuthorizationVO[i].getBkgNo()}).getMessage());
							   				}
							   			}
							   			if(!scgAuthorizationVO[i].getAwkCgoSeq().equals("")){
							   				if(!scgAuthorizationVO[i].getUpdDt().equals(chkVo.getUpdDt())){
							   					log.info("\n ======== <<scgAuthorizationVo[i] ===== getUpdDt>> ["+scgAuthorizationVO[i].getUpdDt()+"]"
							   							+"\n ======== <<chkVo ===== getUpdDt>> ["+chkVo.getUpdDt()+"]");
							   					log.info("\n ========AWK_CGO_SEQ <<scgAuthorizationVo[i] ===== getAwkCgoSeq>> ["+scgAuthorizationVO[i].getAwkCgoSeq()+"]"
							   							+"\n ========AWK_CGO_SEQ <<chkVo ===== getAwkCgoSeq>> ["+chkVo.getAwkCgoSeq()+"]");
											throw new EventException(new ErrorHandler("SCG60085", new String[]{scgAuthorizationVO[i].getBkgNo()}).getMessage());
							   				}
							   			}
							   			if(!scgAuthorizationVO[i].getBbCgoSeq().equals("")){
							   				if(!scgAuthorizationVO[i].getUpdDt().equals(chkVo.getUpdDt())){
							   					log.info("\n ======== <<scgAuthorizationVo[i] ===== getUpdDt>> ["+scgAuthorizationVO[i].getUpdDt()+"]"
							   							+"\n ======== <<chkVo ===== getUpdDt>> ["+chkVo.getUpdDt()+"]");
							   					log.info("\n ========BB_CGO_SEQ <<scgAuthorizationVo[i] ===== getBbCgoSeq>> ["+scgAuthorizationVO[i].getBbCgoSeq()+"]"
							   							+"\n ========BB_CGO_SEQ <<chkVo ===== getBbCgoSeq>> ["+chkVo.getBbCgoSeq()+"]");
											throw new EventException(new ErrorHandler("SCG60085", new String[]{scgAuthorizationVO[i].getBkgNo()}).getMessage());
							   				}
							   			}
							   			if(!scgAuthorizationVO[i].getRcSeq().equals("")){
							   				if(!scgAuthorizationVO[i].getUpdDt().equals(chkVo.getUpdDt())){
							   					log.info("\n ======== <<scgAuthorizationVo[i] ===== getUpdDt>> ["+scgAuthorizationVO[i].getUpdDt()+"]"
							   							+"\n ======== <<chkVo ===== getUpdDt>> ["+chkVo.getUpdDt()+"]");
							   					log.info("\n ========RC_SEQ <<scgAuthorizationVo[i] ===== getRcSeq>> ["+scgAuthorizationVO[i].getRcSeq()+"]"
							   							+"\n ========RC_SEQ <<chkVo ===== getRcSeq>> ["+chkVo.getRcSeq()+"]");
											throw new EventException(new ErrorHandler("SCG60085", new String[]{scgAuthorizationVO[i].getBkgNo()}).getMessage());
							   				}
							   			}
							   			if(!scgAuthorizationVO[i].getStwgCgoSeq().equals("")){
							   				if(!scgAuthorizationVO[i].getUpdDt().equals(chkVo.getUpdDt())){
							   					log.info("\n ======== <<scgAuthorizationVo[i] ===== getUpdDt>> ["+scgAuthorizationVO[i].getUpdDt()+"]"
							   							+"\n ======== <<chkVo ===== getUpdDt>> ["+chkVo.getUpdDt()+"]");
							   					log.info("\n ========STWG_CGO_SEQ <<scgAuthorizationVo[i] ===== getStwgCgoSeq>> ["+scgAuthorizationVO[i].getStwgCgoSeq()+"]"
							   							+"\n ========STWG_CGO_SEQ <<chkVo ===== getStwgCgoSeq>> ["+chkVo.getStwgCgoSeq()+"]");
											throw new EventException(new ErrorHandler("SCG60085", new String[]{scgAuthorizationVO[i].getBkgNo()}).getMessage());
							   				}
							   			}
						   			}
						   		}
						   	}
					   		dbDao.modifySCGApprovalS	(scgAuthorizationVO[i]);	
						
	
					}
					
					//log.info("\n\n ======== <<2007816>> ================================\n\n");
					
					//log.info("\n ======== <<getSpclCgoAuthCd>> ["+scgAuthorizationVO[i].getSpclCgoAuthCd()+"]");
					//log.info("\n ======== <<getCompanyCode>> ["+ConstantMgr.getCompanyCode()+"]");
					//log.info("\n ======== <<strCrrCd>> ["+strCrrCd+"]");
					//log.info("\n ======== <<strScgFlg>> ["+strScgFlg+"]");
					
					//log.info("\n\n ======== <<2007816>> ================================\n\n");
					
					//::2007816-20140708:://if (scgAuthorizationVO[i].getSpclCgoAuthCd().equals("Y") && ConstantMgr.getCompanyCode().equals(strCrrCd) && ("DG1".equals(strScgFlg) || "DG2".equals(strScgFlg) || "AWK".equals(strScgFlg) || "BB".equals(strScgFlg)) ) {
					//::2007816-20150121:://if (scgAuthorizationVO[i].getSpclCgoAuthCd().equals("Y") && ("DG1".equals(strScgFlg) || "DG2".equals(strScgFlg) || "AWK".equals(strScgFlg) || "BB".equals(strScgFlg)) ) {
					if (scgAuthorizationVO[i].getSpclCgoAuthCd().equals("Y") && ("DG1".equals(strScgFlg) || "DG2".equals(strScgFlg) || "AWK".equals(strScgFlg) || "BB".equals(strScgFlg) || "RF".equals(strScgFlg) || "SS".equals(strScgFlg)) ) {
					
						if("SS".equals(strScgFlg)){
							//2016-03-21 Own, Partner Approval Reference Number 통합
							comvo.setPolCd(strPolCd);
							String aproRefNo = dbDao2.searchSpclAproRefNo(comvo);
							//scgAuthorizationVO[i].setAproRefNo(comvo.getAproRefNo());
							scgAuthorizationVO[i].setAproRefNo(aproRefNo);
							dbDao.modifySCGAproRefNoS(scgAuthorizationVO[i], strPolCd, strScgFlg);
							
						}else{
							if (dbDao.searchScgAuthorization(scgAuthorizationVO[i]).size() < 1) {
								//2016-03-21 Own, Partner Approval Reference Number 통합
								comvo.setPolCd(strPolCd);
								String aproRefNo = dbDao2.searchSpclAproRefNo(comvo);
								//scgAuthorizationVO[i].setAproRefNo(comvo.getAproRefNo());+
								scgAuthorizationVO[i].setAproRefNo(aproRefNo);
								dbDao.modifySCGAproRefNoS(scgAuthorizationVO[i], strPolCd, strScgFlg);
							}
						}
					} 
	
					//:2016-04-22:by TOP://List<SearchScgAprovalAuthCdVO> authCd  = dbDao.searchScgApprovalAuthCd(scgAuthorizationVO[i], strScgFlg);
					//:2016-04-22:by TOP://list.addAll(authCd);
				}
			}
			
			
			for (int i=0; i<scgAuthorizationVO.length; i++) {
				List<SearchScgAprovalAuthCdVO> authCd  = dbDao.searchScgApprovalAuthCd(scgAuthorizationVO[i], strScgFlg);
				
				if(authCd.get(0).getSpclCgoAuthCd() != null){
					log.info("\n\n ========= TOP.TOP.TOP scgAuthorizationVO >> i ["+i+"] authCd ["+authCd.get(0).getSpclCgoAuthCd()+"] ========= \n\n");	
				}
				
				list.addAll	(authCd);				
			}
			
			return list;
			
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO APVL for Own BKG's mail send result retrieve. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @exception EventException
	 */
	public void modifySCGApprovalMail(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws EventException{
		try {

			scgRequestListOptionVO.setUpdUsrId(account.getUsr_id());
			if ("RF".equals(scgRequestListOptionVO.getScgFlg())) {
				List<ScgRequestListOptionVO> updMailKeys  = dbDao.searchScgApprovalRFMailKey(scgRequestListOptionVO);
				for ( int i=0; i < updMailKeys.size(); i++ ) {
					scgRequestListOptionVO.setBkgNo(updMailKeys.get(i).getBkgNo());
					scgRequestListOptionVO.setSpclCgoAproRqstSeq((updMailKeys.get(i).getSpclCgoAproRqstSeq()));
					//2015.06.23 Add
					scgRequestListOptionVO.setVslPrePstCd(updMailKeys.get(i).getVslPrePstCd());
					scgRequestListOptionVO.setVslSeq(updMailKeys.get(i).getVslSeq());
					scgRequestListOptionVO.setEmlSndTpCd("I");//개별 발송
					dbDao.modifySCGApprovalMail(scgRequestListOptionVO);					
				}
			}else{
				dbDao.modifySCGApprovalMail(scgRequestListOptionVO);				
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Approved Details's modification save. <br>
	 * 
	 * @param scgAuthorizationVOs 
	 * @param account
	 * @exception EventException
	 */
	public void manageSCGApproved(ScgAuthorizationVO[] scgAuthorizationVOs, SignOnUserAccount account) throws EventException{
		try {
			
			String spclCgoAuthSeq = "";
			for ( int i=0; i<scgAuthorizationVOs.length; i++ ) {
				spclCgoAuthSeq = scgAuthorizationVOs[i].getSpclCgoAuthSeq()==null?"":scgAuthorizationVOs[i].getSpclCgoAuthSeq();
				if(!"".equals(spclCgoAuthSeq)) {
					scgAuthorizationVOs[i].setAuthOfcCd(account.getOfc_cd());
					scgAuthorizationVOs[i].setAuthUsrId(account.getUsr_id());
					scgAuthorizationVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifySCGApprovalS(scgAuthorizationVOs[i]);
				}
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
		}
	}
	
	/**
	 * Application Request & Approval Status's List retrieve <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @return SearchOwnScgListVO
	 * @exception EventException
	 */
	public SearchOwnScgListVO searchScgApprovalStatusList(ScgRequestListOptionVO scgRequestListOptionVO) throws EventException {
		try {
			return dbDao.searchScgApprovalStatusList(scgRequestListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status"}).getMessage(), ex);
		}
	}

	/**
	 * Application Request & Approval Status's apro_ref_no modify <br>
	 * 
	 * @param scgRequestListOptionVOs
	 * @param account
	 * @exception EventException
	 */
	public void modifySCGAproRefNoByHis(ScgRequestListOptionVO[] scgRequestListOptionVOs, SignOnUserAccount account) throws EventException{

		try {			
			List<ScgRequestListOptionVO> updateVoList = new ArrayList<ScgRequestListOptionVO>();

			for ( int i=0; i<scgRequestListOptionVOs.length; i++ ) {
				scgRequestListOptionVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(scgRequestListOptionVOs[i]);
			}
			
			dbDao.modifySCGAproRefNoByHis(updateVoList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Application Request & Approval Status"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Application Request & Approval Status"}).getMessage(), ex);
        }
	}
	
	
	/**
	 * Dangerous CGO Application Details for Own BKG's Detail retrieve <br>
	 * 
	 * @param scgDgCgoVO 
	 * @return List<SearchScgDgRequestDetailVO>
	 * @exception EventException
	 */
	public List<SearchScgRequestDetailVO> searchScgRequestDetail(ScgDgCgoVO scgDgCgoVO) throws EventException {
		try {
			return dbDao.searchScgRequestDetail(scgDgCgoVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Own BKG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Own BKG"}).getMessage(), ex);
		}
	}

	/**
	 * Pre Checking Report retrieve <br>
	 * 
	 * @param preRestrictionInputVO
	 * @return PreRestrictionOutputVO
	 * @exception EventException
	 */
	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO) throws EventException {
		try {
			PreRestrictionOutputVO preRestrictionOutputVO = new PreRestrictionOutputVO();
			
			if(preRestrictionInputVO != null && preRestrictionInputVO.getInnerPreRestrictionInputVOS() != null && preRestrictionInputVO.getInnerPreRestrictionInputVOS().length > 0) {
				String f_cmd = preRestrictionInputVO.getInnerPreRestrictionInputVO().getFCmd();			
				if(Integer.toString(FormCommand.SEARCH01).equals(f_cmd)) {
					//Sorting for Container type check
					PreRestrictionInputVO[] sortVO = preRestrictionInputVO.getInnerPreRestrictionInputVOS();
					PreRestrictionInputVO   tmpVO = null;
					String spclCntrSeq1 = "", spclCgoSeq1 = "";
					String spclCntrSeq2 = "", spclCgoSeq2 = "";
					for(int sortCt1=0; sortCt1 < sortVO.length; sortCt1++) {
						spclCntrSeq1 = sortVO[sortCt1].getSpclCntrSeq();
						spclCgoSeq1  = sortVO[sortCt1].getSpclCgoSeq();
						for(int sortCt2=sortCt1+1; sortCt2 < sortVO.length; sortCt2++) {
							spclCntrSeq2 = sortVO[sortCt2].getSpclCntrSeq();
							spclCgoSeq2  = sortVO[sortCt2].getSpclCgoSeq();
							if(Integer.parseInt(spclCntrSeq1) > Integer.parseInt(spclCntrSeq2) || (Integer.parseInt(spclCntrSeq1) == Integer.parseInt(spclCntrSeq2) && Integer.parseInt(spclCgoSeq1) > Integer.parseInt(spclCgoSeq2))) {
								tmpVO = sortVO[sortCt1]; 
								sortVO[sortCt1] = sortVO[sortCt2];
								sortVO[sortCt2] = tmpVO;
							}
						}
					}
					preRestrictionInputVO.setInnerPreRestrictionInputVOS(sortVO);
					
					//Container type check
					List<PreRestrictionSegregationVO> rsltVO = null;
					List<PreRestrictionSegregationVO> rtnVO  = new ArrayList<PreRestrictionSegregationVO>();
					spclCntrSeq1 = "";
					spclCntrSeq2 = "";
					int startNum = 0, endNum = 0;
					for(int addCt=0; addCt<sortVO.length; addCt++) {
						spclCntrSeq1 = sortVO[addCt].getSpclCntrSeq();
						if((!"".equals(spclCntrSeq2) && !spclCntrSeq1.equals(spclCntrSeq2)) || addCt == sortVO.length-1) {	
							endNum = addCt;
							
							//Set ending point for last container performance
							if(("".equals(spclCntrSeq2) || spclCntrSeq1.equals(spclCntrSeq2)) && addCt == sortVO.length-1) {
								endNum++;
							}
							preRestrictionInputVO.getInnerPreRestrictionInputVO().setStartNum(Integer.toString(startNum));
							preRestrictionInputVO.getInnerPreRestrictionInputVO().setEndNum(Integer.toString(endNum));
							rsltVO = dbDao.checkPreRestrictionSegregation(preRestrictionInputVO);
							
							String[] rmList = new String[rsltVO.size()];					
							for(int rsltCt=0; rsltCt<rsltVO.size(); rsltCt++) {
								for(int rmCt=rsltCt+1; rmCt<rsltVO.size(); rmCt++) {
									if(rsltVO.get(rsltCt).getSpclCntrSeq1().equals(rsltVO.get(rmCt).getSpclCntrSeq2())
									   && rsltVO.get(rsltCt).getSpclCgoSeq1().equals(rsltVO.get(rmCt).getSpclCgoSeq2())
									   && rsltVO.get(rsltCt).getImdgUnNo1().equals(rsltVO.get(rmCt).getImdgUnNo2())
									   && rsltVO.get(rsltCt).getImdgUnNoSeq1().equals(rsltVO.get(rmCt).getImdgUnNoSeq2())
									   && rsltVO.get(rsltCt).getSpclCntrSeq2().equals(rsltVO.get(rmCt).getSpclCntrSeq1())
									   && rsltVO.get(rsltCt).getSpclCgoSeq2().equals(rsltVO.get(rmCt).getSpclCgoSeq1())
									   && rsltVO.get(rsltCt).getImdgUnNo2().equals(rsltVO.get(rmCt).getImdgUnNo1())
									   && rsltVO.get(rsltCt).getImdgUnNoSeq2().equals(rsltVO.get(rmCt).getImdgUnNoSeq1())
									) 
									{
										rmList[rmCt] = "Y";
									}
								}
							}	
							
							for(int rsltCt=0; rsltCt<rsltVO.size(); rsltCt++) {
								rtnVO.add(rsltVO.get(rsltCt));
							}
							
							startNum = addCt;
						}
						spclCntrSeq2 = spclCntrSeq1;
					}
					preRestrictionOutputVO.setPreRestrictionSegregationVOs(rtnVO);
				} else if(Integer.toString(FormCommand.SEARCH02).equals(f_cmd)) {
					
					/*
					 * 1. In case of UN No. checking, C(Excepted fm Class Prohibition, not included VVD in Target Lane-except other companies) except these cases, check again by Class.
					 * 2. Two checks are all Prohibition L,P,T, return to list.
					 */
					//1. First Un No. standard Restriction
					preRestrictionInputVO.getInnerPreRestrictionInputVO().setOptClss("U");
					List<PreRestrictionVesselOperatorVO> preRestrictionVesselOperatorVOs = dbDao.checkPreRestrictionVesselOperator(preRestrictionInputVO);
					
					//2. Second Class standard Restriction
					Iterator<PreRestrictionVesselOperatorVO> rsltlist = preRestrictionVesselOperatorVOs.iterator();	
					ArrayList<Integer> expList 		= new ArrayList<Integer>();
					ArrayList<Integer> expLaneList 	= new ArrayList<Integer>();
					int expCt = 0;
					String restrictYn = "";
		        	while(rsltlist.hasNext()){
		        		PreRestrictionVesselOperatorVO vo = (PreRestrictionVesselOperatorVO)rsltlist.next();
		        		restrictYn = vo.getProhibitionCd();
			        	if(restrictYn == null || "".equals(restrictYn) || "C".equals(restrictYn) ) {  	        				
			        		expList.add(new Integer(expCt));
		        		}else if ("L".equals(restrictYn)){
	        				expLaneList.add(new Integer(expCt));	        			
		        		}
		        		expCt++;
		        	}	
		        	
		        	int expCount = expList.size();
		        	if(expCount > 0) {
			        	PreRestrictionInputVO[] tndInputVOs = null;
						PreRestrictionInputVO   tndInputVO  = null;
						PreRestrictionVesselOperatorVO tVO  = null;
						
						tndInputVOs = new PreRestrictionInputVO[expCount];
						expCt = 0;
			        	for(int delCt=0; delCt < expList.size(); delCt++) {
			        		tndInputVO = new PreRestrictionInputVO();
			        		
			        		tVO = preRestrictionVesselOperatorVOs.get(expList.get(delCt).intValue());
			        		
			        		restrictYn = tVO.getProhibitionCd();
			        		
			        		if(!"C".equals(restrictYn)) {
				        		tndInputVO.setSpclCntrSeq(tVO.getSpclCntrSeq());
				        		tndInputVO.setSpclCgoSeq(tVO.getSpclCgoSeq());
				        		tndInputVO.setImdgUnNo(tVO.getImdgUnNo());
				        		tndInputVO.setImdgUnNoSeq(tVO.getImdgUnNoSeq());
				        		tndInputVO.setImdgClssCd(tVO.getImdgClssCd());
				        		tndInputVO.setVslCd(tVO.getVslCd());
				        		tndInputVO.setSkdVoyNo(tVO.getSkdVoyNo());
				        		tndInputVO.setSkdDirCd(tVO.getSkdDirCd());
				        		tndInputVO.setCrrCd(tVO.getCrrCd());
				        		tndInputVO.setSlanCd(tVO.getSlanCd());
				        		
				        		tndInputVOs[expCt++] = tndInputVO;
			        		}
		        		}
			        	
			        	for(int delCt=expCount-1; delCt >= 0; delCt--) {
			        		if (!"P".equals(restrictYn) && !"R".equals(restrictYn)) {	
			        			preRestrictionVesselOperatorVOs.remove(expList.get(delCt).intValue());
			        		}
		        		}
			        	
			        	preRestrictionInputVO.setInnerPreRestrictionInputVOS(tndInputVOs);
			        	preRestrictionInputVO.getInnerPreRestrictionInputVO().setOptClss("C");
			        	List<PreRestrictionVesselOperatorVO> tndVOs = dbDao.checkPreRestrictionVesselOperator(preRestrictionInputVO);
			        	
			        	Iterator<PreRestrictionVesselOperatorVO> tndRsltlist = tndVOs.iterator();	
			        	while(tndRsltlist.hasNext()){
			        		PreRestrictionVesselOperatorVO vo = (PreRestrictionVesselOperatorVO)tndRsltlist.next();
				        	//In case there's more than two VVD, UN Checked contents are priority, so delete Class Checked contents. 
			        		for(int delCt=0; delCt < expCt; delCt++) {
				        		if (tndInputVOs[delCt].getSpclCntrSeq().equals(vo.getSpclCntrSeq()) 
				        			&& tndInputVOs[delCt].getSpclCgoSeq().equals(vo.getSpclCgoSeq()) 
				        			&& tndInputVOs[delCt].getImdgUnNo().equals(vo.getImdgUnNo()) 
				        			&& tndInputVOs[delCt].getImdgUnNoSeq().equals(vo.getImdgUnNoSeq()) 
				        			&& tndInputVOs[delCt].getImdgClssCd().equals(vo.getImdgClssCd())
				        			&& tndInputVOs[delCt].getVslCd().equals(vo.getVslCd()) 
				        			&& tndInputVOs[delCt].getSkdVoyNo().equals(vo.getSkdVoyNo()) 
				        			&& tndInputVOs[delCt].getSkdDirCd().equals(vo.getSkdDirCd()) 
				        			&& tndInputVOs[delCt].getCrrCd().equals(vo.getCrrCd()) ) {
			        				preRestrictionVesselOperatorVOs.add(vo);
				        		}
				        	}
			        	}
		        	}
		        	
					preRestrictionOutputVO.setPreRestrictionVesselOperatorVOs(preRestrictionVesselOperatorVOs);
				} else if(Integer.toString(FormCommand.SEARCH03).equals(f_cmd)) {
					preRestrictionOutputVO.setPreRestrictionPortVOs(dbDao.checkPreRestrictionPort(preRestrictionInputVO));
				}
			}
			
			return preRestrictionOutputVO;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report"}).getMessage(), ex);
		}
	}
	
	/**
	 * Pre Checking Report(Check by VVD) retrieve <br>
	 * 
	 * @param preRestrictionInputVO
	 * @param segChk
	 * @param vslChk
	 * @param prtChk
	 * @return PreRestrictionOutputVO
	 * @exception EventException
	 */
	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO, boolean segChk, boolean vslChk, boolean prtChk) throws EventException {
		/********************************************************************************************************************************************
		 * cf.) 
		 * PreRestrictionInputVO containerVO = new PreRestrictionInputVO();
		 * PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
		 * preRestrictionInputVO.setBkgNo("ATLX1210006");
		 * preRestrictionInputVO.setVslCd("HNBR");
		 * preRestrictionInputVO.setSkdVoyNo("0039");
		 * preRestrictionInputVO.setSkdDirCd("E");
		 * containerVO.setInnerPreRestrictionInputVO(preRestrictionInputVO);
		 * PreRestrictionOutputVO chkRslt = checkPreRestriction(containerVO, false, true, true);
		 * boolean segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
		 * boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator’s Prohibition
		 * boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
		 * List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();		//Detail of Segregation Validation
		 * List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator’s Prohibition
		 * List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
		 ********************************************************************************************************************************************/
		try {
			PreRestrictionOutputVO preRestrictionOutputVO = new PreRestrictionOutputVO();
			
			//Step1 : select list of dangerous cargo in booking
			List<PreRestrictionInputVO> dgCgoList = dbDao.searchBkgDgCargoList(preRestrictionInputVO);
			
			if(dgCgoList != null && dgCgoList.size() > 0) {
				PreRestrictionInputVO[] dgCgos = (PreRestrictionInputVO[])(dgCgoList.toArray(new PreRestrictionInputVO[dgCgoList.size()]));
				preRestrictionInputVO.setInnerPreRestrictionInputVOS(dgCgos);
				
				String vslCd    = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				
				//Step2 : check segregation
				if(segChk) {
					preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(Integer.toString(FormCommand.SEARCH01));
					List<PreRestrictionSegregationVO> segChkRslt = checkPreRestriction(preRestrictionInputVO).getPreRestrictionSegregationVOs();
					
					if(segChkRslt != null && segChkRslt.size() > 0) {
						preRestrictionOutputVO.setSegChkRslt(true);
						preRestrictionOutputVO.setPreRestrictionSegregationVOs(segChkRslt);
					}
				}
				//Step3 : check vessel
				if(vslChk) {
					preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(Integer.toString(FormCommand.SEARCH02));
					List<PreRestrictionVesselOperatorVO> vslChkRslt = checkPreRestriction(preRestrictionInputVO).getPreRestrictionVesselOperatorVOs();
					
					if(vslChkRslt != null && vslChkRslt.size() > 0) {	
						vslCd    = preRestrictionInputVO.getVslCd();
						if(vslCd != null && !"".equals(vslCd)) {							
							skdVoyNo = preRestrictionInputVO.getSkdVoyNo();
							skdDirCd = preRestrictionInputVO.getSkdDirCd();
							
							List<PreRestrictionVesselOperatorVO> vslChkVos = new ArrayList<PreRestrictionVesselOperatorVO>();
							
							for(int rsltCt=0; rsltCt<vslChkRslt.size(); rsltCt++) {
								if(vslChkRslt.get(rsltCt).getVslCd().equals(vslCd) && vslChkRslt.get(rsltCt).getSkdVoyNo().equals(skdVoyNo) && vslChkRslt.get(rsltCt).getSkdDirCd().equals(skdDirCd)) {
									preRestrictionOutputVO.setVslChkRslt(true);
									vslChkVos.add(vslChkRslt.get(rsltCt));
								}
							}
							preRestrictionOutputVO.setPreRestrictionVesselOperatorVOs(vslChkVos);
						} else {
							preRestrictionOutputVO.setVslChkRslt(true);
							preRestrictionOutputVO.setPreRestrictionVesselOperatorVOs(vslChkRslt);
						}
					}
				}
				//Step4 : check port
				if(prtChk) {
					preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(Integer.toString(FormCommand.SEARCH03));
					
					preRestrictionInputVO.setInnerPreRestrictionInputVOS(dgCgos);
					List<PreRestrictionPortVO> prtChkRslt = checkPreRestriction(preRestrictionInputVO).getPreRestrictionPortVOs();
					
					List<PreRestrictionPortVO> prtChkVos = new ArrayList<PreRestrictionPortVO>();
					
					for(int rsltCt=0; prtChkRslt!=null && rsltCt<prtChkRslt.size(); rsltCt++) {
						if(!"".equals(prtChkRslt.get(rsltCt).getImdgCmptnAuthDesc().trim())) {
							vslCd    = preRestrictionInputVO.getVslCd();
							skdVoyNo = preRestrictionInputVO.getSkdVoyNo();
							skdDirCd = preRestrictionInputVO.getSkdDirCd();
							
							if(vslCd != null && !"".equals(vslCd)) {							
								if(prtChkRslt.get(rsltCt).getVvdCd().equals(vslCd+skdVoyNo+skdDirCd)) {
									preRestrictionOutputVO.setPrtChkRslt(true);
									prtChkVos.add(prtChkRslt.get(rsltCt));
								}
							} else {
								preRestrictionOutputVO.setPrtChkRslt(true);
								prtChkVos.add(prtChkRslt.get(rsltCt));
							}
						}
					}
					if(preRestrictionOutputVO.getPrtChkRslt()) preRestrictionOutputVO.setPreRestrictionPortVOs(prtChkVos);
				}
			}

			return preRestrictionOutputVO;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report by VVD"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report by VVD"}).getMessage(), ex);
		}
	}
	
	/**
	 * Mail Preview retrieve <br>
	 * 
	 * @param ownApprovalRequestVO
	 * @return List<OwnApprovalRequestVO>
	 * @exception EventException
	 */
	public List<OwnApprovalRequestVO> searchSCGMailingList(OwnApprovalRequestVO ownApprovalRequestVO) throws EventException {
		try {
			return dbDao.searchSCGMailingList(ownApprovalRequestVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Preview"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Preview"}).getMessage(), ex);
		}
	}
	
	/**
	 * Dangerous CGO Application Details for Partner Lines's Restrictions retrieve <br>
	 * 
	 * @param restrictionInputVO
	 * @return List<RestrictionOutputVO>
	 * @exception EventException
	 */
	public List<RestrictionOutputVO> searchRestrictions(RestrictionInputVO restrictionInputVO) throws EventException {
		try {
			return dbDao.searchRestrictions(restrictionInputVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);
		}
	}
	
	/**
	 * Time of SPCL CGO Request APVL's KPI retrieve <br>
	 * 
	 * @param searchScgRequestApvlTimeInputVO
	 * @return List<SearchScgRequestApvlTimeOutputVO>
	 * @exception EventException
	 */
	public List<SearchScgRequestApvlTimeOutputVO> searchScgRequestApvlTimeList(SearchScgRequestApvlTimeInputVO searchScgRequestApvlTimeInputVO) throws EventException {
		try {
			return dbDao.searchScgRequestApvlTimeList(searchScgRequestApvlTimeInputVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Time of SPCL CGO Request APVL"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Time of SPCL CGO Request APVL"}).getMessage(), ex);
		}
	}
	
	/**
	 * Time of SPCL CGO Request APVL's KPI detail info retrieve. <br>
	 * 
	 * @param searchScgRequestApvlTimeInputVO
	 * @return List<SearchScgRequestApvlTimeDetailVO>
	 * @exception EventException
	 */
	public List<SearchScgRequestApvlTimeDetailVO> searchScgRequestApvlTimeDetailList(SearchScgRequestApvlTimeInputVO searchScgRequestApvlTimeInputVO) throws EventException {
		try {
			return dbDao.searchScgRequestApvlTimeDetailList(searchScgRequestApvlTimeInputVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Time of SPCL CGO Request APVL Detail"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Time of SPCL CGO Request APVL Detail"}).getMessage(), ex);
		}
	}
	
	/**
	 * Mail Target retrieve <br>
	 * 
	 * @param mapVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCGMailAdrsList(Map<String, String> mapVO) throws EventException {
		try {
			return dbDao.searchSCGMailAdrsList(mapVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Search"}).getMessage(), ex);
		}
	}
	
	/**
	 * Mail Target retrieve <br>
	 *  
	 * @param ownApprovalEmlVO
	 * @param ownApprovalRequestVO
	 * @param account 
	 * @return String
	 * @exception EventException
	 */
	public String specialCargoRequestApprovalEml(OwnApprovalEmlVO ownApprovalEmlVO, OwnApprovalRequestVO ownApprovalRequestVO, SignOnUserAccount account) throws EventException {
		try {
			return dbEmlDao.sendEml(ownApprovalEmlVO, ownApprovalRequestVO, account);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Search"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO APVL for Own BKG's List retrieve <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @return SearchOwnScgListVO
	 * @exception EventException
	 */
	public SearchOwnScgListVO searchEdiCancelRequestList(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchEdiCancelRequestList(scgRequestListOptionVO, account);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
	}
	
	/**
	 * Mail Target retrieve <br>
	 * 
	 * @param mapVO
	 * @return String
	 * @exception EventException
	 */
	public List<SendDgEdiRequestVO> searchEdiCancelStatus(Map<String, String> mapVO) throws EventException {
		try {
			return dbDao.searchEdiCancelStatus(mapVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Search"}).getMessage(), ex);
		}
	}
	
	/**
	 * Mail Target retrieve <br>
	 * 
	 * @param mapVO
	 * @return String
	 * @exception EventException
	 */
	public List<SendDgEdiRequestVO> searchVVDAproRqstForNormal(Map<String, String> mapVO) throws EventException {
		try {
			return dbDao.searchVVDAproRqstForNormal(mapVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Search"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Search"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * DG CGO Detail 조회 <br>
	 * 
	 * @param ScgDgCgoVO scgDgCgoVO
	 * @return List<ScgDgCgoVO>
	 * @exception EventException
	 */
	public List<ScgDgCgoVO> searchScgDgCgoRctDetail(ScgDgCgoVO scgDgCgoVO) throws EventException{
		try {
			return dbDao.searchScgDgCgoRctDetail(scgDgCgoVO.getBkgNo());
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG CGO Detail"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG CGO Detail"}).getMessage(), ex);
		}
	}
	
	/**
	 * BKG POL의 CONTINENT CODE 조회 <br>
	 * 
	 * @param String sBkgNo
	 * @return String
	 * @throws EventException
	 */
//	public String searchContiCdforBKGRSQL(String sBkgNo) throws EventException{
//		
//		try {
//			
//			return dbDao.searchContiCdforBKGRSQL(sBkgNo);
//			
//        } catch (DAOException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG CGO Detail"}).getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("COM12203", new String[]{"DG CGO Detail"}).getMessage(), ex);
//		}
//	}

	/**
	 * SPCL CGO Approved Details DG List를 조회 합니다 <br>
	 * 
	 * @param ScgRequestListOptionVO scgRequestListOptionVO
	 * @param SignOnUserAccount account
	 * @return SearchOwnScgListVO
	 * @exception EventException
	 */
	public SearchOwnScgListVO searchScgAprvDetailtList(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchScgAprvDetailtList(scgRequestListOptionVO, account);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Approved Details DG IF Remark Update <br>
	 * 
	 * @param SearchScgAprovalAuthCdVO	searchScgAprovalAuthCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifySCGRequestIfRmk(SearchScgAprovalAuthCdVO	searchScgAprovalAuthCdVO, SignOnUserAccount account) throws EventException {
		
		try {
			
			dbDao.modifySCGRequestIfRmk(searchScgAprovalAuthCdVO, account);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
		}
		
	}

}