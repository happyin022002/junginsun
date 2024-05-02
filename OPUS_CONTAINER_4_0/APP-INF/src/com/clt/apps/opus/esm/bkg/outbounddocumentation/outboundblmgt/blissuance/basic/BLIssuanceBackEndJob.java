/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceBackEndJob.java
*@FileTitle : BLIssuanceBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31
* 1.0 Creation
* ======================================================================
* History
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlStatusVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;

/**
 * B/L Issue & Onboard Date Update 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 
 * @see BLIssuanceDBDAO
 * @since J2EE 1.6
 */
public class BLIssuanceBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = -1149789439988228547L;

	private GrpBlDtVO grpBlDtIN ;
	private SignOnUserAccount account;
	

	/**
	 * BLIssuanceBackEndJob 생성자<br>
	 * @param GrpBlDtVO grpBlDtIN
	 * @param SignOnUserAccount account
	 * @throws Exception
	 */
	public BLIssuanceBackEndJob(GrpBlDtVO grpBlDtIN, SignOnUserAccount account) throws Exception {
		this.grpBlDtIN = grpBlDtIN;
		this.account = account;
	}

	/**
	 * modify B/L(onboard date, issue date etc) by group<br>
     * 
	 * @return GeneralEventResponse
	 * @exception Exception
	 */
	public String doStart() throws Exception {

		BookingUtil utilCmd = new BookingUtil();
		BLIssuanceBC issueCmd = new BLIssuanceBCImpl();
		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();

		GrpBlDtInVO grpBlDtInVO = grpBlDtIN.getGrpBlDtInVO();
		List<GrpBlDtListVO> grpBlDtListVOs = grpBlDtIN.getGrpBlDtListVOs();

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        BkgBlNoVO bkgBlNoOUT = null;
		HistoryTableVO historyTableVO = null;
        BlStatusVO blStatusVO = null;

//		String vvd = grpBlDtInVO.getVvd();
//		String vslCd = vvd.substring(0, 4);
//		String voyNo = vvd.substring(4, 8);
//		String dirCd = vvd.substring(8, 9);
//		String portCd = grpBlDtInVO.getPolCd();
//		String clptIndSeq = "";
		
		String bkgNo = null;
		
		String cntrReady = null;
        String chgReady = null;
        String mkReady = null;
        String doChkInd = null;
        String cneeReady = null;

		//not update bkg error message
		StringBuffer errBkg = new StringBuffer();
		StringBuffer cntrErrBkg = new StringBuffer();
		StringBuffer chgErrBkg = new StringBuffer();
		StringBuffer mkErrBkg = new StringBuffer();
		StringBuffer doErrBkg = new StringBuffer();
		StringBuffer cneeErrBkg = new StringBuffer();
		StringBuffer noErrBkg = new StringBuffer();
        BLIssuanceBC 			command 	= new BLIssuanceBCImpl();
        BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
        //history
        String uiId = "ESM_BKG_0726";
        
		try {
			int voCnt = grpBlDtListVOs == null ? 0 : grpBlDtListVOs.size();
			log.debug("########### grpBlDtListVOs : " + voCnt);
			for (int i = 0; i < voCnt; i++) {
                // BKG No.
                bkgNo = grpBlDtListVOs.get(i).getBkgNo();
                log.debug("## bkgNo      : " + bkgNo);
//                // Check ETA/ETD
//				VskVslPortSkdVO vskVslPortSkdVO = utilCmd.searchEtbEtdEta(vslCd, voyNo, dirCd, portCd, clptIndSeq);
//				String vslETA = vskVslPortSkdVO.getVpsEtaDt();
//				String vslETD = vskVslPortSkdVO.getVpsEtdDt();
//              String oblIssDtShould = grpBlDtListVOs.get(i).getOblIssDtSd();
//				log.debug("## vslETA     : " + vslETA);
//				log.debug("## vslETD     : " + vslETD);
//              log.debug("## oblIssDtSd : " + oblIssDtShould);
//				if(oblIssDtShould != null && oblIssDtShould.length() >= 10 &&
//				   vslETA != null && vslETA.length() >= 10 &&
//				   vslETD != null && vslETD.length() >= 10){
//                    int d1 = DateTime.daysBetween(vslETA.substring(0, 10).replaceAll("-", ""), oblIssDtShould.replaceAll("-", ""));
//                    int d2 = DateTime.daysBetween(oblIssDtShould.replaceAll("-", ""), vslETD.substring(0, 10).replaceAll("-", ""));
//                    log.debug("## d1     : " + d1);
//                    log.debug("## d2     : " + d2);
//				    if(d1 > 3 || d2 > 3){
//				        throw new EventException(new ErrorHandler("BKG00385").getMessage());
//				    }
//				}
                // O.B/L Issued Flag
                log.debug("## chkdIss  : " + grpBlDtInVO.getChkdIss());
                if("Y".equals(grpBlDtInVO.getChkdIss())){
                    blStatusVO = issueCmd.validateBlIssue(bkgNo, null);
                    
                    cntrReady = blStatusVO.getCntrReady();
                    chgReady = blStatusVO.getChgReady();
                    mkReady = blStatusVO.getMkReady();
                    doChkInd = blStatusVO.getDoChkInd();
                    cneeReady = blStatusVO.getCneeReady();
                    if("N".equals(cntrReady)) {
                        cntrErrBkg.append(bkgNo);
                        cntrErrBkg.append(",");
                    }
                    if("N".equals(chgReady)) {
                        chgErrBkg.append(bkgNo);
                        chgErrBkg.append(",");
                    } 
                    if ("N".equals(mkReady)) {
                        mkErrBkg.append(bkgNo);
                        mkErrBkg.append(",");
                    } 
                    if ("N".equals(doChkInd)){
                        doErrBkg.append(bkgNo);
                        doErrBkg.append(",");
                    }
                    if ("N".equals(cneeReady)){
                        cneeErrBkg.append(bkgNo);
                        cneeErrBkg.append(",");
                    } 
                    
                    if (!"N".equals(chgReady) && !"N".equals(mkReady) && !"N".equals(doChkInd) && !"N".equals(cntrReady)&& !"N".equals(cneeReady)) {
                    	/* set message */
                    	noErrBkg.append(bkgNo);
                    	noErrBkg.append(",");
                    	
                        /* set O.B/L Issue Flag */
                        grpBlDtListVOs.get(i).setOblIssFlg("Y");
                    }
                     /* searchBkgBlNo */
                     bkgBlNoIN.setBkgNo(bkgNo);
                     bkgBlNoIN.setCaUsrId(account.getUsr_id());
                     bkgBlNoOUT = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
                        
                     /* Search Booking History */
                     historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoOUT);
                        
                     /* Manage Doc Process */
                     String oRIGINAL_BL = "";
                     if("B".equalsIgnoreCase(grpBlDtListVOs.get(i).getBlIssTpCd())){
                    	 oRIGINAL_BL = "OBLISS";
                     }else if("W".equalsIgnoreCase(grpBlDtListVOs.get(i).getBlIssTpCd())){
                    	 oRIGINAL_BL = "SWBISS";
                     }
                     
                     if(!oRIGINAL_BL.equals("")){
                    	 log.debug("[method][======== [BLIssuanceBC] :: oRIGINAL_BL]=========="+oRIGINAL_BL);
            	
                    	 // < in case of docPrcModyFlg='Y'> 
                    	 // 5. [] IBookingHistoryMgtBC::manageDocProcess ( docProcSkd )
                    	 BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
                    	 docProcSkdVO.setBkgNo(bkgNo);
                    	 docProcSkdVO.setBkgDocProcTpCd(oRIGINAL_BL);
                    	 
                    	 histCmd.manageDocProcess(docProcSkdVO, account);
                     }
                     // Save All the Date no matter if Booking is completed to Issue.
                     docCmd.modifyBlObrdDt(grpBlDtListVOs.get(i));
                     grpBlDtListVOs.get(i).setUpdUsrId(account.getUpd_usr_id());
                     issueCmd.modifyGroupBlUpdate(grpBlDtListVOs.get(i), grpBlDtInVO);
                     
                     // ca_no ='TMP0000001' , BKG_BL_DOC_HIS, BKG_BL_ISS_HIS update
                     String caNo = bkgBlNoOUT.getCaNo();
                     if("TMP0000001".equals(caNo)){
                    	 docCmd.modifyBlObrdDtHistory(grpBlDtListVOs.get(i));
                    	 issueCmd.modifyGroupBlUpdateHistory(grpBlDtListVOs.get(i), grpBlDtInVO);
                     }	
                     

                     /* Manage Booking History */
                     bkgBlNoOUT.setCaFlg("N");
                     bkgBlNoOUT.setCaNo("");
                     historyTableVO.setBkgBlNoVO(bkgBlNoOUT);
                     histCmd.manageBookingHistory(uiId, historyTableVO, account);
                     
                     // save transaction in case of issue 
                     if("Y".equals(grpBlDtListVOs.get(i).getOblIssFlg()) && "Y".equals(grpBlDtInVO.getChkdIss())){
         	            log.debug("\n======= Auto EDI Send ======\n");

         	        	List<BkgNtcHisVO> bkgNtcHisVOs = command.createDraftBlEdiAuto(grpBlDtListVOs.get(i).getBkgNo(), account);
         	
         				if (bkgNtcHisVOs != null) {
         					if (bkgNtcHisVOs.size() > 0) {
         						bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0095");
         					}
         				}	
                     }
                                            
//                    }
                }else{
                    /* searchBkgBlNo */
                    bkgBlNoIN.setBkgNo(bkgNo);
            		bkgBlNoIN.setCaUsrId(account.getUsr_id());
                    bkgBlNoOUT = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
                    // ca_no ='TMP0000001' , BKG_BL_DOC_HIS, BKG_BL_ISS_HIS update
                    String caNo = bkgBlNoOUT.getCaNo();
                    
                    /* Search Booking History */
                    historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoOUT);
                    log.debug("\n##################getBlObrdDt " +grpBlDtListVOs.get(i).getBlObrdDt());
                    if("" != grpBlDtListVOs.get(i).getBlObrdDtSd() || "" != grpBlDtListVOs.get(i).getBlObrdDt()){
                    	docCmd.modifyBlObrdDt(grpBlDtListVOs.get(i));
                        if("TMP0000001".equals(caNo)){
                        	docCmd.modifyBlObrdDtHistory(grpBlDtListVOs.get(i));
                        }	
                    }
                    log.debug("\n##################BKG_NO " +grpBlDtListVOs.get(i).getBkgNo());
                    log.debug("\n##################credit " +grpBlDtListVOs.get(i).getCreditChk());
                    if((null != grpBlDtListVOs.get(i).getOblIssDtSd() && grpBlDtListVOs.get(i).getOblIssDtSd().length()>0) 
                    		|| (null != grpBlDtListVOs.get(i).getOblIssDt() && grpBlDtListVOs.get(i).getOblIssDt().length()>0)){
                    	grpBlDtListVOs.get(i).setUpdUsrId(account.getUpd_usr_id());
                    	issueCmd.modifyGroupBlUpdate(grpBlDtListVOs.get(i), grpBlDtInVO);
                        if("TMP0000001".equals(caNo)){
                        	issueCmd.modifyGroupBlUpdateHistory(grpBlDtListVOs.get(i), grpBlDtInVO);
                        }	
                    }

                    /* Manage Booking History */
                    bkgBlNoOUT.setCaFlg("N");
                    bkgBlNoOUT.setCaNo("");
                    historyTableVO.setBkgBlNoVO(bkgBlNoOUT);
                    histCmd.manageBookingHistory(uiId, historyTableVO, account);
                    
                }
			}


			/*
			 * have to save Bkg
			 */
            // set message
            if (chgErrBkg.length()>0) {
                errBkg.append("[ Charge ]\n" + chgErrBkg.substring(0, chgErrBkg.length()-1) + "\n");
            }           
            if (mkErrBkg.length()>0) {
                errBkg.append("[ M&D ]\n" + mkErrBkg.substring(0, mkErrBkg.length()-1) + "\n");                          
            }
            if (doErrBkg.length()>0) {
                errBkg.append("[ DO ]\n" + doErrBkg.substring(0, doErrBkg.length()-1) + "\n");              
            }
            if (cntrErrBkg.length()>0) {
            	errBkg.append("[ Container ]\n" + cntrErrBkg.substring(0, cntrErrBkg.length()-1) + "\n");
            }

			if (errBkg.length() > 0) {
				if (noErrBkg.length()>0) {
	            	errBkg.append("[ Success ]\n" + noErrBkg.substring(0, noErrBkg.length()-1));
	            }
				ErrorHandler eh = new ErrorHandler("BKG08084", new String[]{"\n" + errBkg});
				return eh.getMessage();
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return "Y";
	}

}
