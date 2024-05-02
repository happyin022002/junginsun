/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceBCImpl.java
*@FileTitle : Group & Multi B/L Print
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0743Event;
import com.clt.apps.opus.esm.bkg.common.Constants;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderEAIDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration.BLIssuanceDBDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration.BLIssuanceEAIDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AgentEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AuthCustVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgDocIssHisVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgDocIssRdemVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService004VO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssueVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlPrintRcvFtpVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlRemarkVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlStatusVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlBkgVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblCntVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EmlBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EmlInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.FaxSendVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.InDblWblInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MailSendVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MultiNtcHisVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ObDblWblInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.RdApplCdFtpVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ReIssueVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SeaWayBillPrintVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchBlCompleteRcvEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchBlNtcHisVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchBlPrintRcvEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchRcvEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SrndVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiCmdtCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiBlClauseVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.basic.ReAuditListBackEndJob;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rdexport.ReportDesignerExporter;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.io.FileUtils;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.syscommon.common.table.BkgAutoEmlVO;
import com.clt.syscommon.common.table.BkgBlIssVO;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.ftp.FtpMetaInfo;
import com.clt.framework.component.ftp.FtpUtility;
import com.clt.framework.component.javamail.Mail;

/**
 * OPUS-OutboundBLMgt Business Logic Basic Command implementation<br>
 * - OPUS-Process Business Logic for OutboundBLMgt.<br>
 * 
 * @author Joon Yong Park
 * @see esm_bkg_0278EventResponse,BLIssuanceBC each DAO class  reference
 * @since J2EE 1.4
 */

public class BLIssuanceBCImpl extends BasicCommandSupport implements BLIssuanceBC {

    // Database Access Object
    private transient BLIssuanceDBDAO dbDao = null;
    private transient BLIssuanceEAIDAO bleaiDao = null;
    //private transient CargoReleaseOrderDBDAO dbCargo = null;
    private transient CargoReleaseOrderEAIDAO eaiDbDao = null;
	String separator = "||"; // 구분자 
	String CFG_FILEOPEN_LOGURL_BASE = SubSystemConfigFactory.get("COM.CLT.FILEOPEN.DOMAIN") + "/"; 
	String CFG_FILEOPEN_LOGURL_LOGPATH = SubSystemConfigFactory.get("COM.CLT.FILEOPEN.URL"); 
    
    /**
     * BLIssuanceBCImpl Object Creation<br>
     * BLIssuanceDBDAO create.<br>
     */
    public BLIssuanceBCImpl() {
        dbDao = new BLIssuanceDBDAO();
        bleaiDao = new BLIssuanceEAIDAO();
        eaiDbDao = new CargoReleaseOrderEAIDAO();
        //dbCargo = new CargoReleaseOrderDBDAO();
    }
   	
	/**
	 * EsmBkg007909Event retrieve event processing<br>
	 * B/L validateBlIssue check <br>
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String issueType
	 * @return BlStatusVO
	 * @exception EventException
	 */
	public BlStatusVO validateBlIssue(String bkgNo , String issueType) throws EventException{
		BlStatusVO blsvo = null;
		
        try {
        	blsvo = dbDao.searchBlStatus(bkgNo);
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }		
		return blsvo;
	}
    
    /**
     * EsmBkg007909Event retrieve event processing<br>
     * B/L Issue info retrieve<br>
     * fill necessary item before B/L issue(B/L Type, Freight pay or not etc.)
     * @author LEE JIN SEO
     * @param BlIssueVO blIssueVO
     * @return BlIssueVO
     * @exception EventException
     */

    public  BlIssueVO searchBlIssInfo(BlIssueVO blIssueVO) throws EventException {
    log.debug("============================>[[ BLIssuanceBCImpl  searchBlIssInfo START ]]<============================");

        String bkg_no = blIssueVO.getBkg_no();
        String bl_no  = blIssueVO.getBl_no();
        SignOnUserAccount  account = blIssueVO.getAccount();
      
        try {
            //BlIssInfoList : result value setting 
            List<BlIssInfoVO> rBlIssInfoVO = dbDao.searchBlIssInfo(bkg_no,account.getUsr_id());
            //VesselVoyagedList : result value setting
            blIssueVO.setVesselVoyagedList(dbDao.searchComboVVDInfo(bkg_no,""));
            //PreCarriageList : result value setting
            blIssueVO.setPreCarriageList(dbDao.searchComboVVDInfo(bkg_no,"S"));
            //Bl_ready_no validation checked 
            blIssueVO.setBl_not_ready(dbDao.searchBLNotReady(bkg_no));
            
            if(rBlIssInfoVO != null && rBlIssInfoVO.size() > 0){
            	OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
            	otsRcvInfoVO = dbDao.searchFreightReceiveByBkgNo(bkg_no, bl_no);
            	
            	if(otsRcvInfoVO != null){
            		for(int i = 0; i < rBlIssInfoVO.size() ;  i++){
            			BlIssInfoVO vo = (BlIssInfoVO)rBlIssInfoVO.get(i);
            			vo.setPpdConfirm(otsRcvInfoVO.getPptStsCd());
            			vo.setPpdRcvUserOffice(otsRcvInfoVO.getPptRcvOfcCd());
            			vo.setPpdRcvUserId(otsRcvInfoVO.getPptRcvUsrId());
            			vo.setPpdRcvDt(otsRcvInfoVO.getPptRcvDt());
            			vo.setCctConfirm(otsRcvInfoVO.getCctStsCd());
            			vo.setCctRcvUserOffice(otsRcvInfoVO.getCctRcvOfcCd());
            			vo.setCctRcvUserId(otsRcvInfoVO.getCctRcvUsrId());
            			vo.setCctRcvDt(otsRcvInfoVO.getCctRcvDt());
            			vo.setTrdPpdConfirm(otsRcvInfoVO.getN3ptyPptStsCd());
            			vo.setTrdPpdRcvUserOffice(otsRcvInfoVO.getN3ptyPptRcvOfcCd());
            			vo.setTrdPpdRcvUserId(otsRcvInfoVO.getN3ptyPptRcvUsrId());
            			vo.setTrdPpdRcvDt(otsRcvInfoVO.getN3ptyPptRcvDt());
            			vo.setTrdCctConfirm(otsRcvInfoVO.getN3ptyCctStsCd());
            			vo.setTrdCctRcvUserOffice(otsRcvInfoVO.getN3ptyCctRcvOfcCd());
            			vo.setTrdCctRcvUserId(otsRcvInfoVO.getN3ptyCctRcvUsrId());
            			vo.setTrdCctRcvDt(otsRcvInfoVO.getN3ptyCctRcvDt());
            			vo.setFlgPpd(otsRcvInfoVO.getPptStsCd());
            			vo.setTrdFlgPpd(otsRcvInfoVO.getN3ptyPptStsCd());
            			
            			rBlIssInfoVO.set(i, vo);
            		}
            	}else{
        			BlIssInfoVO vo = (BlIssInfoVO)rBlIssInfoVO.get(0);
        			vo.setPpdConfirm("");
        			vo.setPpdRcvUserOffice("");
        			vo.setPpdRcvUserId("");
        			vo.setPpdRcvDt("");
        			vo.setCctConfirm("");
        			vo.setCctRcvUserOffice("");
        			vo.setCctRcvUserId("");
        			vo.setCctRcvDt("");
        			vo.setTrdPpdConfirm("");
        			vo.setTrdPpdRcvUserOffice("");
        			vo.setTrdPpdRcvUserId("");
        			vo.setTrdPpdRcvDt("");
        			vo.setTrdCctConfirm("");
        			vo.setTrdCctRcvUserOffice("");
        			vo.setTrdCctRcvUserId("");
        			vo.setTrdCctRcvDt("");
        			vo.setFlgPpd("");
        			vo.setTrdFlgPpd("");
        			
        			rBlIssInfoVO.set(0, vo);
            	}
            }
            
//            blIssueVO.setOtsRcvInfoVO(dbDao.searchFreightReceiveByBkgNo(bkg_no, bl_no));
            
   
            // last result value Container VO
            blIssueVO.setBlIssInfoList(rBlIssInfoVO);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450", new String[] {}).getMessage(), ex);
        }
        return blIssueVO ;
    }
       /**
     * EsmBkg007909Event save event processing <br>
     * Manage bl issue relation info.<br>
     * 
     * @author LEE JIN SEO
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
    public void manageBlIssInfo(BlIssInfoVO blIssInfoVO) throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  manageBlIssInfo START ]]<============================");

        try {
            dbDao.manageBlIssInfo(blIssInfoVO);
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }

    }
    /**
     * EsmBkg007909Event save event processing <br>
     * Manage bl issue relation info.<br>
     * 
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
    public void manageBlIssInfoHistory(BlIssInfoVO blIssInfoVO) throws EventException{
    	log.debug("============================>[[ BLIssuanceBCImpl  manageBlIssInfoHistory START ]]<============================");

     try {
         dbDao.manageBlIssInfoHistory(blIssInfoVO);
         
     } catch (DAOException ex) {
         //log.error("err " + ex.toString(), ex);
         throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
     } catch (Exception ex) {
         //log.error("err " + ex.toString(), ex);
         throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
     }

 }
    
    /**
     * EsmBkg007909Event save event processing<br>
     * Manage bl issue relation info.<br>
     * 1. update like below as per Issue Type
     							B/L type  Issued	     Released	Internet Auth
		Internet Auth			B			Y			Y			Y
		O.B/L Release			B			Y			Y			N
		SWB Release				W			Y			Y			N
		Issue          			null		Y			N			N
		Cancel Release			null		N			N			N
		Cancel Auth				null		N			N			N
		
		btn_t11InternetAUTH
		btn_t11OBLRelease
		btn_t11SWBRelease
		btn_t11Issue
		btn_t11CancelRelease
		btn_t11CancelAUTH

		,BKG_BL_DOC.BL_OBRD_TP_CD		on_board_type
		,BKG_BL_ISS.OBL_ISS_FLG			issued
		,BKG_BL_ISS.OBL_RLSE_FLG		released
		,BKG_BL_ISS.OBL_INET_FLG		internet_auth
     * @author LEE JIN SEO
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
    public void manageBlIssueFlg(BlIssInfoVO blIssInfoVO) throws EventException{
    	log.debug("[1][======== [BLIssuanceBC] :: manageBlIssueFlg ]==========");
    	
    	String bkgNo 	  = blIssInfoVO.getBkgNo();
    	String blNo 	  = blIssInfoVO.getBlNo();
    	String buttonType = blIssInfoVO.getButtontype();
    	log.debug("[1][======== [BLIssuanceBC] :: bkgNo ]=========="+bkgNo);
    	log.debug("[1][======== [BLIssuanceBC] :: blNo ]=========="+blNo);
    	log.debug("[1][======== [BLIssuanceBC] :: buttonType ]=========="+buttonType);
    	
        try {
        	//priority save data of screen before button do action.
        	manageBlIssInfo(blIssInfoVO);
        	
        	// validation 
            BookingUtil bookingUtilBC = new BookingUtil();
            BkgBlNoVO bkgBlNoIn = new BkgBlNoVO();
            bkgBlNoIn.setBkgNo(bkgNo);
            bkgBlNoIn.setBlNo(blNo);
    		bkgBlNoIn.setCaUsrId(blIssInfoVO.getUpdUsrId());
            BkgBlNoVO bkgBlNoOut = bookingUtilBC.searchBkgBlNoVO(bkgBlNoIn);
            if(bkgBlNoOut == null) {
                throw new Exception(new ErrorHandler("BKG08073").getMessage());
            }
            // Canceled booking is not processing.
            if("X".equals(bkgBlNoOut.getBkgStsCd())) {
                // TODO
                throw new Exception(new ErrorHandler("BKG08073").getMessage());
            }
           
            // 00. button setting 
        	if(buttonType.equals("btn_t11InternetAUTH")){
            	blIssInfoVO.setBlIssueblType("B");
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("Y");
            	blIssInfoVO.setInternetAuth("Y");
        	}else if(buttonType.equals("btn_t11OBLRelease")){
            	blIssInfoVO.setBlIssueblType("B");
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("Y");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11BLRelease")){
            	blIssInfoVO.setBlIssueblType(blIssInfoVO.getBlIssueblType());
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("Y");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11SWBRelease")){
            	blIssInfoVO.setBlIssueblType("W");
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("Y");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11Issue")){
//            	blIssInfoVO.setBlIssueblType(null);
        		blIssInfoVO.setBlIssueblType(blIssInfoVO.getBlIssueblType());
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("N");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11CancelRelease")){
            	blIssInfoVO.setBlIssueblType(null);
            	blIssInfoVO.setIssued("N");
            	blIssInfoVO.setReleased("N");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11CancelAUTH")){
            	blIssInfoVO.setBlIssueblType(null);
            	blIssInfoVO.setIssued("N");
            	blIssInfoVO.setReleased("N");
            	blIssInfoVO.setInternetAuth("N");
        	}

            // 01. Flg change BLIssuanceDBDAO::manageBlIssueFlg ( bkgNo , issueType )/manageBlIssueFlg ( [in] bkgNo : String , [in] issueType : String ) : void
            dbDao.manageBlIssueFlg(blIssInfoVO);

            // 02. issue InterAuth / CancelAuth  
            if(buttonType.equals("btn_t11InternetAUTH") || buttonType.equals("btn_t11CancelAUTH")){
            	log.debug("###########################issue InterAuth / CancelAuth##########################?"+blIssInfoVO.getButtontype());
                dbDao.manageIntAuth(blIssInfoVO);
            }

            log.debug("[2][======== [BLIssuanceBC] :: manageBlIssueFlg ]==========");

        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    }   
    
    /**
     * EsmBkg007909Event save event processing<br>
     * Manage bl issue relation info.<br>
     * 1. update like below as per Issue Type
     							B/L type  Issued	     Released	Internet Auth
		Internet Auth			B			Y			Y			Y
		O.B/L Release			B			Y			Y			N
		SWB Release				W			Y			Y			N
		Issue          			null		Y			N			N
		Cancel Release			null		N			N			N
		Cancel Auth				null		N			N			N
		
		btn_t11InternetAUTH
		btn_t11OBLRelease
		btn_t11SWBRelease
		btn_t11Issue
		btn_t11CancelRelease
		btn_t11CancelAUTH

		,BKG_BL_DOC.BL_OBRD_TP_CD		on_board_type
		,BKG_BL_ISS.OBL_ISS_FLG			issued
		,BKG_BL_ISS.OBL_RLSE_FLG		released
		,BKG_BL_ISS.OBL_INET_FLG		internet_auth
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
    public void manageBlIssueFlgHistory(BlIssInfoVO blIssInfoVO) throws EventException{
    	log.debug("[1][======== [BLIssuanceBC] :: manageBlIssueFlgHistory ]==========");
    	
    	String bkgNo 	  = blIssInfoVO.getBkgNo();
    	String blNo 	  = blIssInfoVO.getBlNo();
    	String buttonType = blIssInfoVO.getButtontype();
    	log.debug("[1][======== [BLIssuanceBC] :: bkgNo ]=========="+bkgNo);
    	log.debug("[1][======== [BLIssuanceBC] :: blNo ]=========="+blNo);
    	log.debug("[1][======== [BLIssuanceBC] :: buttonType ]=========="+buttonType);
    	
        try {
        	//priority save data of screen before button do action.
        	manageBlIssInfoHistory(blIssInfoVO);
        	
            // 00. button setting 
        	if(buttonType.equals("btn_t11InternetAUTH")){
            	blIssInfoVO.setBlIssueblType("B");
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("Y");
            	blIssInfoVO.setInternetAuth("Y");
        	}else if(buttonType.equals("btn_t11OBLRelease")){
            	blIssInfoVO.setBlIssueblType("B");
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("Y");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11BLRelease")){
            	blIssInfoVO.setBlIssueblType(blIssInfoVO.getBlIssueblType());
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("Y");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11SWBRelease")){
            	blIssInfoVO.setBlIssueblType("W");
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("Y");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11Issue")){
//            	blIssInfoVO.setBlIssueblType(null);
        		blIssInfoVO.setBlIssueblType(blIssInfoVO.getBlIssueblType());
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("N");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11CancelRelease")){
            	blIssInfoVO.setBlIssueblType(null);
            	blIssInfoVO.setIssued("N");
            	blIssInfoVO.setReleased("N");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11CancelAUTH")){
            	blIssInfoVO.setBlIssueblType(null);
            	blIssInfoVO.setIssued("N");
            	blIssInfoVO.setReleased("N");
            	blIssInfoVO.setInternetAuth("N");
        	}

            // 01. Flg change BLIssuanceDBDAO::manageBlIssueFlg ( bkgNo , issueType )/manageBlIssueFlg ( [in] bkgNo : String , [in] issueType : String ) : void
            dbDao.manageBlIssueFlgHistory(blIssInfoVO);

            log.debug("[2][======== [BLIssuanceBC] :: manageBlIssueFlgHistory ]==========");

        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    }      
	/**
	 * EsmBkg007909Event ftp event processing<br>
	 * VIP FTP Transmit
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BlIssInfoVO blIssInfoVO
	 * @param String[] totalpages
	 * @param SignOnUserAccount account
	 * @param String fileDownPath
	 * @exception EventException
	 */
	public void transmitFtp(BkgBlNoVO bkgBlNoVO, BlIssInfoVO blIssInfoVO, String[] totalpages, SignOnUserAccount account, String fileDownPath) throws Exception{

		BookingHistoryMgtBC bkgHisCmd = null;
		BookingUtil utilBC = null;
//		BLIssuanceBC command = new BLIssuanceBCImpl();

		List<BlPrintRcvFtpVO> blPrintRcvFtpVOs = new ArrayList<BlPrintRcvFtpVO>();
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		FtpMetaInfo ftpMetaInfo = new FtpMetaInfo();
		RdApplCdFtpVO rdApplCdFtp = new RdApplCdFtpVO();
		
		StringBuilder sbParam = null;
		String sType = null;
		String sLevel = null;
		String sMrd = null;
//		DblWblVO[] dblWblVOs = null;
		BkgRouteVO bkgRouteVO = null;
		String japanStampValue = "";
        BkgBlNoVO esigVO = null;
        String blEsigFlg = "";
        String blCpyEsigFlg = "";
        String blKntFlg = "";
        String ntcKndCd = "";
        
		String formType = "";
		String formTypeCnt = "";
		String formLevel = "";
		String blTpCd = "";
		String errNtcFlg = "";
		String scsNtcFlg = "";
		String xptFileNm = "";
        
    	String[] formTypes = null;
    	String[] formTypesCnt = null;
    	String[] formLevels = null;
		
		
		try{
			blPrintRcvFtpVOs = searchBlPrintGrpRcvFtp(bkgBlNoVO.getBkgNo());
			List<DocRqstVO> docRqstList = searchDocRqst(bkgBlNoVO.getBkgNo(),"");
			
			if(blPrintRcvFtpVOs != null && blPrintRcvFtpVOs.size() > 0){
				if(null != docRqstList && docRqstList.size() > 0 ){
					utilBC = new BookingUtil();
					bkgHisCmd = new BookingHistoryMgtBCImpl();
					
					for(BlPrintRcvFtpVO rcvFtpVO: blPrintRcvFtpVOs){
						sType = sLevel = sMrd = blTpCd = errNtcFlg = scsNtcFlg = xptFileNm = blKntFlg =  "";
						blTpCd = rcvFtpVO.getBlTpCd();		//1:Original Sea waybill + Original BL
						                                    //2:Original Sea waybill + NN Original
						                                    //3:Original BL + Copy Sea waybill
						                                    //4:Copy Sea waybill + NN Original
						errNtcFlg = rcvFtpVO.getErrNtcFlg();
						scsNtcFlg = rcvFtpVO.getScsNtcFlg();
						
						xptFileNm = rcvFtpVO.getXptFileNm();
						sbParam = new StringBuilder();
						bkgRouteVO = utilBC.searchBkgRoute(bkgBlNoVO.getBkgNo());
						
						japanStampValue = utilBC.checkJapanStamp(bkgBlNoVO.getBkgNo());
						
						esigVO = utilBC.searchEsigAgent(bkgBlNoVO.getBkgNo());
						if(esigVO == null){
							blEsigFlg = "";
							blCpyEsigFlg = "";
							blKntFlg = "";
						}else{
							blEsigFlg = esigVO.getBlEsigFlg();
							blCpyEsigFlg = esigVO.getBlCpyEsigFlg();
							blKntFlg = esigVO.getBlKntFlg();
						}
						
						if("KNN".equals(xptFileNm)){
							if(blIssInfoVO.getBlIssTpCd().equals("B")){
								//Non Copy Rated
								if(!"0".equals(docRqstList.get(0).getNonNegoRtInclKnt())){
									formType += "2_";
									formTypeCnt += docRqstList.get(0).getNonNegoRtInclKnt()+"_";
									formLevel += "1_";

								}
								//Non Unrated
								if(!"0".equals(docRqstList.get(0).getNonNegoRtXcldKnt())){
									formType += "2_";
									formTypeCnt += docRqstList.get(0).getNonNegoRtXcldKnt()+"_";
									formLevel += "6_";
								}
							}
							else if(blIssInfoVO.getBlIssTpCd().equals("W")){
								if(!"0".equals(docRqstList.get(0).getOblRtInclKnt())){
									formType += "5_";
									formTypeCnt += docRqstList.get(0).getOblRtInclKnt()+"_";
									formLevel += "1_";
								}
								//Original Unrated
								if(!"0".equals(docRqstList.get(0).getOblRtXcldKnt())){
									formType += "5_";
									formTypeCnt += docRqstList.get(0).getOblRtXcldKnt()+"_";
									formLevel += "6_";
								}
							}
							else{
								//Non Copy Rated
								if(!"0".equals(docRqstList.get(0).getNonNegoRtInclKnt())){
									formType += "2_";
									formTypeCnt += docRqstList.get(0).getNonNegoRtInclKnt()+"_";
									formLevel += "1_";
								}
								//Non Unrated
								if(!"0".equals(docRqstList.get(0).getNonNegoRtXcldKnt())){
									formType += "2_";
									formTypeCnt += docRqstList.get(0).getNonNegoRtXcldKnt()+"_";
									formLevel += "6_";
								}
							}
						}else if("BDP".equals(xptFileNm)){
							if(blIssInfoVO.getBlIssTpCd().equals("B")){
								if("1".equals(blTpCd) || "3".equals(blTpCd)){
									//Original Rated
									if(!"0".equals(docRqstList.get(0).getOblRtInclKnt())){
										formType += "4_";
										formTypeCnt += docRqstList.get(0).getOblRtInclKnt()+"_";
										formLevel += "1_";
									}									
									//Orginal UnRated
									if(!"0".equals(docRqstList.get(0).getOblRtXcldKnt())){
										formType += "4_";
										formTypeCnt += docRqstList.get(0).getOblRtXcldKnt()+"_";
										formLevel += "6_";
									}
								}else if("2".equals(blTpCd) || "4".equals(blTpCd)){		//Orginal -> NN
									//Original Rated
									if(!"0".equals(docRqstList.get(0).getOblRtInclKnt())){
										formType += "2_";
										formTypeCnt += docRqstList.get(0).getOblRtInclKnt()+"_";
										formLevel += "1_";
									}									
									//Orginal UnRated
									if(!"0".equals(docRqstList.get(0).getOblRtXcldKnt())){
										formType += "2_";
										formTypeCnt += docRqstList.get(0).getOblRtXcldKnt()+"_";
										formLevel += "6_";
									}
								}
							}else if(blIssInfoVO.getBlIssTpCd().equals("W")){
								if("1".equals(blTpCd) || "2".equals(blTpCd)){
									//Original Rated
									if(!"0".equals(docRqstList.get(0).getOblRtInclKnt())){
										formType += "5_";
										formTypeCnt += docRqstList.get(0).getOblRtInclKnt()+"_";
										formLevel += "1_";
									}									
									//Orginal UnRated
									if(!"0".equals(docRqstList.get(0).getOblRtXcldKnt())){
										formType += "5_";
										formTypeCnt += docRqstList.get(0).getOblRtXcldKnt()+"_";
										formLevel += "6_";
									}
								}else if("3".equals(blTpCd) || "4".equals(blTpCd)){	//Orginal -> NN
									//Original Rated
									if(!"0".equals(docRqstList.get(0).getOblRtInclKnt())){
										formType += "2_";
										formTypeCnt += docRqstList.get(0).getOblRtInclKnt()+"_";
										formLevel += "1_";
									}									
									//Orginal UnRated
									if(!"0".equals(docRqstList.get(0).getOblRtXcldKnt())){
										formType += "2_";
										formTypeCnt += docRqstList.get(0).getOblRtXcldKnt()+"_";
										formLevel += "6_";
									}
								}
							}
							//Non Copy Rated
							if(!"0".equals(docRqstList.get(0).getNonNegoRtInclKnt())){
								formType += "2_";
								formTypeCnt += docRqstList.get(0).getNonNegoRtInclKnt()+"_";
								formLevel += "1_";
							}
							//Non Unrated
							if(!"0".equals(docRqstList.get(0).getNonNegoRtXcldKnt())){
								formType += "2_";
								formTypeCnt += docRqstList.get(0).getNonNegoRtXcldKnt()+"_";
								formLevel += "6_";
							}
						}else if("STD".equals(xptFileNm)){
							//////////// Original B/L //////////////
							//Original Rated
							if(!"0".equals(docRqstList.get(0).getOblRtInclKnt())){
								if("1".equals(blTpCd)){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "4_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "5_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblRtInclKnt()+"_";
									formLevel += "1_";
								}else if("2".equals(blTpCd) && blIssInfoVO.getBlIssTpCd().equals("W")){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "2_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "5_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblRtInclKnt()+"_";
									formLevel += "1_";
								}else if("3".equals(blTpCd) && !blIssInfoVO.getBlIssTpCd().equals("W")){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "4_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "2_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblRtInclKnt()+"_";
									formLevel += "1_";
								}else{
									formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblRtInclKnt()+"_";
									formLevel += "1_";
								}
							}
							//Original Unrated
							if(!"0".equals(docRqstList.get(0).getOblRtXcldKnt())){
								if("1".equals(blTpCd)){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "4_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "5_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblRtXcldKnt()+"_";
									formLevel += "6_";
								}else if("2".equals(blTpCd) && blIssInfoVO.getBlIssTpCd().equals("W")){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "2_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "5_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblRtXcldKnt()+"_";
									formLevel += "6_";
								}else if("3".equals(blTpCd)){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "4_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "2_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblRtXcldKnt()+"_";
									formLevel += "6_";
								}else{
									formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblRtXcldKnt()+"_";
									formLevel += "6_";
								}

							}
							//Original Prepaid
							if(!"0".equals(docRqstList.get(0).getOblPpdKnt())){
								if("1".equals(blTpCd)){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "4_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "5_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblPpdKnt()+"_";
									formLevel += "4_";
								}else if("2".equals(blTpCd) && blIssInfoVO.getBlIssTpCd().equals("W")){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "2_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "5_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblPpdKnt()+"_";
									formLevel += "4_";
								}else if("3".equals(blTpCd)){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "4_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "2_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblPpdKnt()+"_";
									formLevel += "4_";
								}else{
									formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblPpdKnt()+"_";
									formLevel += "4_";
								}

							}
							//Original Collect
							if(!"0".equals(docRqstList.get(0).getOblCltKnt())){
								if("1".equals(blTpCd)){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "4_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "5_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblCltKnt()+"_";
									formLevel += "5_";
								}else if("2".equals(blTpCd) && blIssInfoVO.getBlIssTpCd().equals("W")){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "2_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "5_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblCltKnt()+"_";
									formLevel += "5_";
								}else if("3".equals(blTpCd) && !blIssInfoVO.getBlIssTpCd().equals("W")){
									if(blIssInfoVO.getBlIssTpCd().equals("B"))			formType += "4_";
									else if(blIssInfoVO.getBlIssTpCd().equals("W"))		formType += "2_";
									else												formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblCltKnt()+"_";
									formLevel += "5_";
								}else if("4".equals(blTpCd)){
									formType += "2_";
									formTypeCnt += docRqstList.get(0).getOblCltKnt()+"_";
									formLevel += "5_";
								}
							}
														
							//////////// N/N Copy //////////////
							//Non Copy Rated
							if(!"0".equals(docRqstList.get(0).getNonNegoRtInclKnt())){
								formType += "2_";
								formTypeCnt += docRqstList.get(0).getNonNegoRtInclKnt()+"_";
								formLevel += "1_";
							}
							//Non Unrated
							if(!"0".equals(docRqstList.get(0).getNonNegoRtXcldKnt())){
								formType += "2_";
								formTypeCnt += docRqstList.get(0).getNonNegoRtXcldKnt()+"_";
								formLevel += "6_";
							}
							//Non Prepaid
							if(!"0".equals(docRqstList.get(0).getNonNegoPpdKnt())){
								formType += "2_";
								formTypeCnt += docRqstList.get(0).getNonNegoPpdKnt()+"_";
								formLevel += "4_";
							}
							//Non Collect
							if(!"0".equals(docRqstList.get(0).getNonNegoCltKnt())){
								formType += "2_";
								formTypeCnt += docRqstList.get(0).getNonNegoCltKnt()+"_";
								formLevel += "5_";
							}
						}
						
						if(!formType.equals("")){
							formType = formType.substring(0, formType.length()-1);
							formTypeCnt = formTypeCnt.substring(0, formTypeCnt.length()-1);
							formLevel = formLevel.substring(0, formLevel.length()-1);
						}
						//form객체 배열작업
						if(formType.indexOf("_") > -1){
				    		formTypes = formType.split("_");
				    		formTypesCnt = formTypeCnt.split("_"); 
				    		formLevels = formLevel.split("_");
				    	}else{
				    		formTypes = new String[]{formType};
				    		formTypesCnt = new String[]{formTypeCnt};
				    		formLevels = new String[]{formLevel};
				    	}
						
						sbParam = new StringBuilder();
						
						if (0==bkgRouteVO.getPorCd().indexOf("US")) {
							sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
						} else {
							sMrd="ESM_BKG_0109_OBL_A4.mrd";
						}
						rdApplCdFtp = dbDao.searchRdApplCdFtp(sMrd);
						if(rdApplCdFtp==null)		continue;
						
						bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
						BkgNtcHisVO bkgNtcHisVO = null;
		                SimpleDateFormat format = null;
		                format = new SimpleDateFormat("yyyyMMddHHmmss");
						
						// PDF 갯수 만큼 실행
						int cnt = 0;
						int maxFormCnt = 0;
						String sKndCd = "";
						if("BDP".equals(xptFileNm)){
							for(int i= 0; i< formTypes.length; i++){
								if(formLevels[i].equals("1")||formLevels[i].equals("6")){
									maxFormCnt += Integer.parseInt(formTypesCnt[i]);
								}
							}
							int imrdcnt = maxFormCnt;
							String bdpParam = "";
							int iOblR = 0;
							int iOblU = 0;
							int iNNCR = 0;
							int iNNCU = 0;
							bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();								
							
							for(int i= 0; i< formTypes.length; i++){
								sType = formTypes[i];
								sLevel = formLevels[i];
								
								if("1".equals(sLevel) || "6".equals(sLevel)){
									int maxFormTypesCnt = Integer.parseInt(formTypesCnt[i]);
									if(!"".equals(bdpParam)){
										bdpParam = bdpParam + separator;
									}
									if("4".equals(sType)){
										if("1".equals(sLevel))	iOblR++;
										if("6".equals(sLevel))	iOblU++;
									}
									
									if("5".equals(sType)){
										if("1".equals(sLevel))	iOblR++;
										if("6".equals(sLevel))	iOblU++;
									}
									if("2".equals(sType)){
										if("1".equals(sLevel))	iNNCR++;
										if("6".equals(sLevel))	iNNCU++;
									}

									bdpParam += getStringParaInfoCtnt(maxFormTypesCnt, bkgBlNoVO, sType, sLevel, japanStampValue, blEsigFlg, blCpyEsigFlg, blKntFlg, fileDownPath, account, imrdcnt);
									cnt++;
								}
								
								log.debug("===============================================================");
								log.debug("[[ bdpParam  ]] "+bdpParam);
								log.debug("===============================================================");
							}
							if(cnt>0 ){
								String ftpFileNm = "";
								StringBuffer sbFtpFileNm = new StringBuffer();
								sbFtpFileNm.append("NYKS_");
								sbFtpFileNm.append(bkgBlNoVO.getBkgNo());
								if(blIssInfoVO.getBlIssTpCd().equals("W")){
									if(iOblR>0 || iNNCR>0)		sbFtpFileNm.append("_FREIGHT_SW");
									else						sbFtpFileNm.append("_UNFREIGHT_SW");
								}else{
									if(iOblR>0 || iNNCR>0)		sbFtpFileNm.append("_FREIGHT_OBL");
									else						sbFtpFileNm.append("_UNFREIGHT_OBL");
								}
								sbFtpFileNm.append(".");
								sbFtpFileNm.append("pdf");
								ftpFileNm = rcvFtpVO.getFtpSvrDirNm()+sbFtpFileNm.toString();										
									
								//FTP transmission
								ftpMetaInfo = new FtpMetaInfo();
								ftpMetaInfo.setCreUsrId(account.getUsr_id());												//
								ftpMetaInfo.setFtp_svr_ip(rcvFtpVO.getFtpSvrNm());											//
								ftpMetaInfo.setFtp_usr_id(rcvFtpVO.getFtpSvrUsrNm());										//
								ftpMetaInfo.setFtp_usr_pw(rcvFtpVO.getFtpSvrPwd());											//
								ftpMetaInfo.setFtp_dir_ctnt(ftpFileNm);		                                                // 규칙에 따라 생성함.
								ftpMetaInfo.setSys_cd(rdApplCdFtp.getRdSubSysCd());
								ftpMetaInfo.setTmplMrd(rdApplCdFtp.getRdApplCd());
								ftpMetaInfo.setParaInfoCtnt(bdpParam);
								log.debug("===============================================================");
								log.debug("[[ ftpMetaInfo Ftp_dir_ctnt]] "+ftpMetaInfo.getFtp_dir_ctnt());
								log.debug("[[ ftpMetaInfo TmplMrd]] "+ftpMetaInfo.getTmplMrd());
								log.debug("[[ ftpMetaInfo ParaInfoCtnt]] "+ftpMetaInfo.getParaInfoCtnt());
								log.debug("===============================================================");
								
								String ftpSendNo = null;
								ftpSendNo = bleaiDao.sendFileRpt(ftpMetaInfo);
								log.debug("===============================================================");
								log.debug("[[ ftpSendNo]] "+ftpSendNo);
								log.debug("===============================================================");
								if(blIssInfoVO.getBlIssTpCd().equals("W")){
									if(iOblR>0 || iOblU>0)			sKndCd = "TW";
									else							sKndCd = "TC";
								}else{
									if(iOblR>0 || iOblU>0)			sKndCd = "TO";
									else							sKndCd = "TN";
								}
								bkgNtcHisVO = new BkgNtcHisVO();
		                        bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
		                        bkgNtcHisVO.setNtcViaCd("T");
		                        bkgNtcHisVO.setNtcKndCd(sKndCd);
		                        bkgNtcHisVO.setAgnCd("");
		                        bkgNtcHisVO.setNtcFomCd("");
		                        bkgNtcHisVO.setNtcSeq("");
		                        bkgNtcHisVO.setBkgCustTpCd("");
		                        bkgNtcHisVO.setCustCntcTpCd("");
		                        bkgNtcHisVO.setNtcEml("");
		                        bkgNtcHisVO.setSndId(ftpSendNo);
		                        bkgNtcHisVO.setFrtHdnFlg("N");
//				                        bkgNtcHisVO.setFrtAllFlg(dblWblVOs[cnt].getFrtAllFlg());
//				                        bkgNtcHisVO.setFrtCltFlg(dblWblVOs[cnt].getFrtCltFlg());
//				                        bkgNtcHisVO.setFrtPpdFlg(dblWblVOs[cnt].getFrtPpdFlg());
//				                        bkgNtcHisVO.setFrtChgFlg(dblWblVOs[cnt].getFrtChgFlg());
//				                        bkgNtcHisVO.setFrtArrFlg(dblWblVOs[cnt].getFrtArrFlg());
		                        bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
		                        bkgNtcHisVO.setSndUsrId(account.getUsr_id());
		                        bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
		                        bkgNtcHisVO.setCustCntcAmdFlg("N");
		                        bkgNtcHisVO.setDiffRmk(errNtcFlg+scsNtcFlg);
		                        bkgNtcHisVO.setCreUsrId(account.getUsr_id());
		                        bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
		                        bkgNtcHisVOs.add(bkgNtcHisVO);
								
		                        bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_09");
							}
							/////////////END OF BDP............
						}else{
							// PDF 갯수 만큼 실행
							int cntStd = 0;

							for(int i= 0; i< formTypes.length; i++){
								bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
								sbParam = new StringBuilder();
								sType = formTypes[i];
								sLevel = formLevels[i];
								//NTC_KND_CD(TO:Original B/L, TW:Sea WayBill, TN:Non Nego, TC:Copy Sea Waybil, TE:Email Error, TU:Email Success)
								if("4".equals(sType)){
									ntcKndCd = "TO";
								}else if("5".equals(sType)){
									ntcKndCd = "TW";
								}else if("2".equals(sType)){
									if(blIssInfoVO.getBlIssTpCd().equals("W")){
										ntcKndCd = "TC";
									}else{
										ntcKndCd = "TN";
									}
								}
								
								//sbParam setting....  /rp parameter setting....
								int maxFormTypesCnt = Integer.parseInt(formTypesCnt[i]);
								
								String stParam = getStringParaInfoCtnt(maxFormTypesCnt, bkgBlNoVO, sType, sLevel, japanStampValue,blEsigFlg, blCpyEsigFlg, blKntFlg,fileDownPath, account, maxFormTypesCnt );
								
								String ftpFileNm = "";
								StringBuffer sbFtpFileNm = new StringBuffer();
										
								String inDayTime = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
								if("KNN".equals(xptFileNm)){

									int itotalpages0 = "".equalsIgnoreCase(totalpages[0])?0:Integer.parseInt(totalpages[0]) * maxFormTypesCnt;
									int itotalpages1 = "".equalsIgnoreCase(totalpages[1])?0:Integer.parseInt(totalpages[1]) * maxFormTypesCnt;
									
									sbFtpFileNm.append("wwwww99");
									sbFtpFileNm.append(docRqstList.get(0).getFfrefno());
									if(blIssInfoVO.getBlIssTpCd().equals("W")){
										if(sLevel.equals("1"))			sbFtpFileNm.append("X13");
										else if(sLevel.equals("6"))		sbFtpFileNm.append("X10");
									}else{
										if(sLevel.equals("1"))			sbFtpFileNm.append("X14");
										else if(sLevel.equals("6"))		sbFtpFileNm.append("X11");
									}
									sbFtpFileNm.append("01");
									if(sLevel.equals("1")){
										sbFtpFileNm.append(itotalpages0);
									}else if(sLevel.equals("6")){
										sbFtpFileNm.append(itotalpages1);
									}
									sbFtpFileNm.append(".");
									sbFtpFileNm.append("NYK");
									sbFtpFileNm.append(inDayTime);
									sbFtpFileNm.append(".");
									sbFtpFileNm.append("pdf");
								}else if("STD".equals(xptFileNm)){
									sbFtpFileNm.append(inDayTime);
									sbFtpFileNm.append(cntStd++);
									sbFtpFileNm.append(bkgBlNoVO.getBkgNo());
									sbFtpFileNm.append(".");
									sbFtpFileNm.append("pdf");
								}
								ftpFileNm = rcvFtpVO.getFtpSvrDirNm()+sbFtpFileNm.toString();
				                
								//FTP transmission
								ftpMetaInfo = new FtpMetaInfo();
								ftpMetaInfo.setCreUsrId(account.getUsr_id());												//
								ftpMetaInfo.setFtp_svr_ip(rcvFtpVO.getFtpSvrNm());											//
								ftpMetaInfo.setFtp_usr_id(rcvFtpVO.getFtpSvrUsrNm());										//
								ftpMetaInfo.setFtp_usr_pw(rcvFtpVO.getFtpSvrPwd());											//
								ftpMetaInfo.setFtp_dir_ctnt(ftpFileNm);		                                                // 규칙에 따라 생성함.
								ftpMetaInfo.setSys_cd(rdApplCdFtp.getRdSubSysCd());
								ftpMetaInfo.setTmplMrd(rdApplCdFtp.getRdApplCd());
								ftpMetaInfo.setParaInfoCtnt(stParam);
										
								log.debug("===============================================================");
								log.debug("[[ ftpMetaInfo Ftp_dir_ctnt]] "+ftpMetaInfo.getFtp_dir_ctnt());
								log.debug("[[ ftpMetaInfo TmplMrd]] "+ftpMetaInfo.getTmplMrd());
								log.debug("[[ ftpMetaInfo ParaInfoCtnt]] "+ftpMetaInfo.getParaInfoCtnt());
								log.debug("===============================================================");
								
								String ftpSendNo = null;
								ftpSendNo = bleaiDao.sendFileRpt(ftpMetaInfo);
								log.debug("===============================================================");
								log.debug("[[ ftpSendNo]] "+ftpSendNo);
								log.debug("===============================================================");
								
			                    bkgNtcHisVO = new BkgNtcHisVO();
		                        bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
		                        bkgNtcHisVO.setNtcViaCd("T");
		                        bkgNtcHisVO.setNtcKndCd(ntcKndCd);    
		                        bkgNtcHisVO.setAgnCd("");
		                        bkgNtcHisVO.setNtcFomCd("");
		                        bkgNtcHisVO.setNtcSeq("");
		                        bkgNtcHisVO.setBkgCustTpCd("");
		                        bkgNtcHisVO.setCustCntcTpCd("");
		                        bkgNtcHisVO.setNtcEml("");
		                        bkgNtcHisVO.setSndId(ftpSendNo);
		                        bkgNtcHisVO.setFrtHdnFlg("N");
//				                        bkgNtcHisVO.setFrtAllFlg(dblWblVOs[cnt].getFrtAllFlg());
//				                        bkgNtcHisVO.setFrtCltFlg(dblWblVOs[cnt].getFrtCltFlg());
//				                        bkgNtcHisVO.setFrtPpdFlg(dblWblVOs[cnt].getFrtPpdFlg());
//				                        bkgNtcHisVO.setFrtChgFlg(dblWblVOs[cnt].getFrtChgFlg());
//				                        bkgNtcHisVO.setFrtArrFlg(dblWblVOs[cnt].getFrtArrFlg());
		                        bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
		                        bkgNtcHisVO.setSndUsrId(account.getUsr_id());
		                        bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
		                        bkgNtcHisVO.setCustCntcAmdFlg("N");
		                        bkgNtcHisVO.setDiffRmk(errNtcFlg+scsNtcFlg);
		                        bkgNtcHisVO.setCreUsrId(account.getUsr_id());
		                        bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
		                        bkgNtcHisVOs.add(bkgNtcHisVO);
								
		                        bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_09");	
		                        
							}
						}
					}
				}
        	}
		}catch(Exception ex){
			throw ex;
		}
	}

    /**
     * EsmBkg0649Event retrieve event processing<br>
     * B/L searchBlReIssue info retrieve<br>
     * @author LEE JIN SEO
     * @param String bkg_no
     * @return ReIssueVO
     * @exception EventException
     */
    public ReIssueVO searchBlReIssue(String bkg_no) throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  searchBlReIssue START ]]<============================");
        ReIssueVO reIssueVO = new ReIssueVO();
        try {
            
            //B/L Issue info retrieve
            //吏ъŁ searchBlReIssueInfo ( [in] bkgNo : String ) : ReIssueInfoVO
            reIssueVO.setReIssueInfoVO(dbDao.searchBlReIssueInfo(bkg_no));

            //B/L Issue History info retrieve
            //吏ъŁ searchBlReIssueHist ( [in] bkgNo : String ) : BkgDocIssHisVO
            reIssueVO.setBkgDocIssHisVO(dbDao.searchBlReIssueHist(bkg_no));
            
            //B/L Issue Collect info retrieve
            //吏ъŁ searchBlReIssueCollect ( [in] bkgNo : String ) : BkgDocIssRdemVO[]
            reIssueVO.setBkgDocIssRdemVO(dbDao.searchBlReIssueCollect(bkg_no));
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
        return reIssueVO ; 
    }
    
    /**
     * EsmBkg0649Event save event processing <br>
     * B/L Re-Issue  info add/modify.<br>
     * 
     * @author LEE JIN SEO
     * @param ReIssueVO reIssueVO
     * @exception EventException
     */
    public void manageBlReIssue(ReIssueVO reIssueVO) throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  manageBlReIssue START ]]<============================");
    
        List<BkgDocIssHisVO> bkgDocIssHisVOList     = new ArrayList<BkgDocIssHisVO>();
        
        SignOnUserAccount account = reIssueVO.getAccount();
        String userID = account.getUsr_id();
        String bkgNo = reIssueVO.getBkg_no();
        BlIssInfoVO blIssInfoVO = null;
       
        try {

        		//[] IBLIssuanceBC::manageBlReIssue ( reIssue )
                //[] BLIssuanceDBDAO::manageBlReIssue ( docIssHis )
                //Add row in Re-Issue History
                //Don't Save in case of No.( Count) is '0'
                //吏ъŁ manageBlReIssue ( [in] docIssHis : BkgDocIssHisVO ) : void
                
                BkgDocIssHisVO[]  bkgDocIssHisVOs = reIssueVO.getBkgDocIssHisVOs();
                if(bkgDocIssHisVOs != null){
                    int cntHis = bkgDocIssHisVOs.length;
                    for(int i = 0; i < cntHis; i++) {
                        bkgDocIssHisVOs[i].setBkgNo(bkgNo);
                        bkgDocIssHisVOs[i].setCreUsrId(userID);
                        bkgDocIssHisVOs[i].setUpdUsrId(userID);
                        bkgDocIssHisVOList.add(bkgDocIssHisVOs[i]);
                    }
                    dbDao.manageBlReIssue(bkgDocIssHisVOList);
                }

                //[] BLIssuanceDBDAO::manageBlReIssueCollect ( docIssRdem )
                //B/L Re-Issue Colliect info add/modify.
                //吏ъŁ manageBlReIssueCollect ( [in] docIssRdem : BkgDocIssRdemVO )
                
                BkgDocIssRdemVO[]  bkgDocIssRdemVOs = reIssueVO.getBkgDocIssRdemVOs();
                List<BkgDocIssRdemVO> insertVoList   = new ArrayList<BkgDocIssRdemVO>();
                List<BkgDocIssRdemVO> updateVoList   = new ArrayList<BkgDocIssRdemVO>();
                List<BkgDocIssRdemVO> deleteVoList   = new ArrayList<BkgDocIssRdemVO>();
                if(bkgDocIssRdemVOs != null){
                    int cntRdem = bkgDocIssRdemVOs.length;
                    for(int i = 0; i < cntRdem; i++) {
                    	
                    	if("0".equals(bkgDocIssRdemVOs[i].getIssRdemKnt())){
                    		//update in case of seq exist
                    		bkgDocIssRdemVOs[i].setBkgNo(bkgNo);
                            deleteVoList.add(bkgDocIssRdemVOs[i]);

                    	}else {
                    		
                            if(bkgDocIssRdemVOs[i].getHisSeq() == null || bkgDocIssRdemVOs[i].getHisSeq().length() == 0 ){
                        		//insert in case of seq is null 
                        		bkgDocIssRdemVOs[i].setBkgNo(bkgNo);
                                bkgDocIssRdemVOs[i].setCreUsrId(userID);
                                bkgDocIssRdemVOs[i].setUpdUsrId(userID);
                                insertVoList.add(bkgDocIssRdemVOs[i]);
                                
                        	}else{
                        		//update in case seq is not null
                        		bkgDocIssRdemVOs[i].setBkgNo(bkgNo);
                                bkgDocIssRdemVOs[i].setUpdUsrId(userID);
                                updateVoList.add(bkgDocIssRdemVOs[i]);
                        	}
                    	}
                    }
                    // save to DB
                    if(deleteVoList.size() > 0) {
                    	dbDao.manageBlReIssueCollect(deleteVoList,"D");
                    }
                    if(insertVoList.size()>0){
                        dbDao.manageBlReIssueCollect(insertVoList,"C");
                    }
                    if(updateVoList.size()>0){
                        dbDao.manageBlReIssueCollect(updateVoList,"U");
                    }
                }

                //Comfirm 
        		if("COMFIRM".equals(reIssueVO.getCommand_type())){
        			BookingUtil bookingUtilBC = new BookingUtil();
        			BkgBlNoVO bkgBlNoIn = new BkgBlNoVO();
                    bkgBlNoIn.setBkgNo(bkgNo);
            		bkgBlNoIn.setCaUsrId(userID);
                    BkgBlNoVO bkgBlNoOut = bookingUtilBC.searchBkgBlNoVO(bkgBlNoIn);
                    String caNo = bkgBlNoOut.getCaNo();
        			
        			dbDao.confirmBlReIssue(bkgNo);
	        		 
	 	        	blIssInfoVO = new BlIssInfoVO();
		        	blIssInfoVO.setBkgNo(bkgNo);
		        	blIssInfoVO.setUpdUsrId(userID);
		        	blIssInfoVO.setUpdOffice(account.getOfc_cd());
		        	
		        	blIssInfoVO.setIssued("N");
		    		blIssInfoVO.setReleased("N");
		    		blIssInfoVO.setInternetAuth("N");
		        	
		        	dbDao.manageBlIssueFlg(blIssInfoVO);
		        	//ca_no ='TMP0000001' , BKG_BL_ISS_HIS update
		        	if("TMP0000001".equals(caNo)){
		        		dbDao.manageBlIssueFlgHistory(blIssInfoVO);
		        	}
        		}
        		
        		//2014.09.01.
	        	blIssInfoVO = new BlIssInfoVO();
	        	blIssInfoVO.setBkgNo(bkgNo);
	        	blIssInfoVO.setUpdUsrId(userID);
	        	blIssInfoVO.setUpdOffice(account.getOfc_cd());
	        	dbDao.manageIntAuth(blIssInfoVO);
	        	
	        	//2015.04.29. kimtaekyun. issue / Release Cancel
	        	dbDao.manageWayBillPrintFlag(blIssInfoVO);


        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  manageBlReIssue END ]]<============================");
    }
   
    /**
     * EsmBkg0400Event retrieve event processing<br>
     * O.B/L Surrender data retrieve<br>
     * 
     * @author LEE JIN SEO
     * @param String bkg_no
     * @param String bl_no
     * @return List<SrndVO>
     * @exception EventException
     */
    public List<SrndVO> searchSurrenderInfo(String bkg_no,String bl_no)  throws EventException {
    log.debug("============================>[[ BLIssuanceBCImpl  searchSurrenderInfo START ]]<============================");
        List<SrndVO> rlst = null;
        
        try {
            
            //<in case of retrie by BL>
        	if(bkg_no.length() == 0 && bl_no.length() > 0 ){
      		  BookingUtil bookingUtilBC = new BookingUtil();
      		  if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
      		  bkg_no = bookingUtilBC.searchBkgNoByBlNo(bl_no);	
        	}
        	
            rlst = dbDao.searchSurrenderInfo(bkg_no, bl_no);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  searchSurrenderInfo END ]]<============================");
        return rlst ; 
    }
    /**
     * EsmBkg0400Event save event processing<br>
     * update  Surrender relation item of B/L info<br>
     * 
     * @author LEE JIN SEO
     * @param SrndVO srndvo
     * @exception EventException
     */
    public void modifySurrenderInfo(SrndVO srndvo)  throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  modifyDocRqst START ]]<============================");

            String bkg_no       = srndvo.getBkgNo();
            String bl_no        = srndvo.getBlNo();
            //SignOnUserAccount ssoAcount = srndvo.getAccount();
            String errorMessage = "";
            /*1) explanation
            -surrender processing OBL.
            - in case of particular sheeper do not want issue OBL.
            -surrender and processing redemption at the same time  .-- UI_BKG-0400
            */          
        try {


            
            //1. -> [] IBLIssuanceBC::modifySurrenderInfo ( srndvo )
                //[] BLIssuanceDBDAO::searchDoStatus ( bkgNo )
                //D/O Status retrieve
                //SELECT 'X'  FROM  BKG_DO WHERE BKG_NO =@[bkg_no]
                //吏ъŁ searchDoStatus ( [in] bkgNo : String ) : String
                String result  = (String)dbDao.searchDoStatus(bkg_no);
                if(result != null){
                	errorMessage = (String)new ErrorHandler("BKG00434").getMessage();
                    throw new EventException((String)new ErrorHandler("BKG00434").getMessage());               	
                }
                else if(result == null){
                //yet status is not deliver_order  
                    
                    //2. checking exception. include D/O status
                        //[] BLIssuanceDBDAO::searchSurrenderInfo ( bkgNo , blNo )
                        //O.B/L Surrender data retrieve
                        //吏ъŁ searchSurrenderInfo ( [in] bkgNo : String , [in] blNo : String ) : SrndVO
                    List<SrndVO> srndVOList =  dbDao.searchSurrenderInfo( bkg_no, bl_no);
                    
                    if(srndVOList.size()>0){
                        SrndVO rSrndvo = srndVOList.get(0);

                        //F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled, init is W
                        //: bkg_sts_cd = 'X'
                        if("X".equals(rSrndvo.getBkgStsCd())){
                        	errorMessage = (String)new ErrorHandler("BKG08073").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG08073").getMessage());
                            
                        }
                        //OBL_RDEM_KNT
                        //: bkg_booking.bl_tp_cd = 'W' then not obl
                        else if("W".equals(rSrndvo.getBlTpCd())){
                        	errorMessage = (String)new ErrorHandler("BKG00372").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG00372").getMessage());
                            
                        }
                        //OBL_RLSE_FLG
                        //: BKG_BL_ISS.OBL_RLSE_FLG == "N"
                        else if("N".equals(rSrndvo.getOblRlseFlg())){
                        	errorMessage = (String)new ErrorHandler("BKG00373").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG00373").getMessage());
                            
                        }
                        //OBL_RDEM_OFC_CD
                        //: in case of different BKG_BL_ISS.OBL_RDEM_OFC_CD and part of session  
                        /*else if(!rSrndvo.getOblRdemOfcCd().equals(ssoAcount.getOfc_cd())){
                            throw new EventException((String)new ErrorHandler("BKG00382").getMessage());
                            
                        }*/
                        //DO_ISUUE :: D/O Release Flg
                        /*else if("Y".equals(rSrndvo.getDoIsuue())){
                        	errorMessage = (String)new ErrorHandler("BKG00434").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG00434").getMessage());
                            
                        }*/
                        //  OBL_ISS_DT > OBL_RDEM_DT    
                        else if(Integer.parseInt(rSrndvo.getOblIssDt().replace("-", "")) > Integer.parseInt(srndvo.getOblRdemDt().replace("-", "")) ){
                        	errorMessage = (String)new ErrorHandler("BKG00436").getMessage();
                        	throw new EventException((String)new ErrorHandler("BKG00436").getMessage());
                            
                        }
                        //OBL_RDEM_KNT  != OBL_ISS_KNT
                        else if(!srndvo.getOblRdemKnt().equals(srndvo.getOblIssKnt())){
                        	errorMessage = (String)new ErrorHandler("BKG00437").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG00437").getMessage());
                            
                        }
                        //8.in case of same country of Issue Office B/L issue office and DEST Country[BKG00435]
                        else if(rSrndvo.getDelCd().substring(1,2).equals(rSrndvo.getCntCd())){
                        	errorMessage = (String)new ErrorHandler("BKG00372").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG00372").getMessage());
                            
                        }                       
                        //9. in case of Order B/L [BKG00374]
                        //Y/N Order B/L :: : BKG_BOOKING.CUST_TO_ORD_FLG
                        else if("Y".equals(rSrndvo.getCustToOrdFlg())){
                        	errorMessage = (String)new ErrorHandler("BKG00372").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG00372").getMessage());
                        }
    
                        //3. update Surrender relation item of B/L info .
                            //[] BLIssuanceDBDAO::modifySurrenderInfo ( srnd )
                            //update Surrender relation item of B/L info. -- UI_BKG-0079-09
                            //吏ъŁ modifySurrenderInfo ( [in] srnd : SrndVO ) : void
 
                        dbDao.modifySurrenderInfo(srndvo);
                    
                    }

                }
                
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(errorMessage, new String[]{}).getMessage(),ex);
		} catch (EventException ex) {
			//log.error("err " + ex.toString(), ex);
			throw ex;
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(errorMessage, new String[]{}).getMessage(),ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  modifyDocRqst END ]]<============================");
    }
    
    /**
     * EsmBkg0400Event save event processing<br>
     * update  Surrender relation item of B/L info<br>
     * 
     * @param SrndVO srndvo
     * @exception EventException
     */
    public void modifySurrenderInfoHistory(SrndVO srndvo)  throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  modifySurrenderInfoHistory START ]]<============================");

        try {
            dbDao.modifySurrenderInfoHistory(srndvo);
                
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[]{}).getMessage(),ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[]{}).getMessage(),ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  modifySurrenderInfoHistory END ]]<============================");
    }    
    /**
     * EsmBkg0400Event delete event processing<br>
     * Initialize  Surrender relation item of B/L info<br>
     * 
     * @author LEE JIN SEO
     * @param String bkg_no
     * @exception EventException
     */
    public void removeSurrenderInfo(String bkg_no)  throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  removeSurrenderInfo START ]]<============================");

        try {

            //吏ъŁ removeSurrenderInfo ( [in] bkgNo : String ) : void
            dbDao.removeSurrenderInfo(bkg_no);
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  removeSurrenderInfo END ]]<============================");
    }
    /**
     * EsmBkg0400Event delete event processing<br>
     * Initialize  Surrender relation item of B/L info<br>
     * 
     * @param String bkg_no
     * @exception EventException
     */
    public void removeSurrenderInfoHistory(String bkg_no)  throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  removeSurrenderInfo START ]]<============================");

        try {

            //吏ъŁ removeSurrenderInfo ( [in] bkgNo : String ) : void
            dbDao.removeSurrenderInfoHistory(bkg_no);
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  removeSurrenderInfo END ]]<============================");
    }
    /**
     * EsmBkg00059Event retrieve event processing<br>
     * Documentation Requirement(ESM_BKG-0079 占쎌벥 B/L INFO占쎌벥 POP-UP)<br>
     * ui no : Documentation Requirement data retrieve -- UI_BKG-0059 <br>
     * 
     * @author LEE JIN SEO
     * @param String bkg_no
     * @param String ofc_cd
     * @return List<DocRqstVO>
     * @exception EventException
     */
    public List<DocRqstVO> searchDocRqst(String bkg_no ,String ofc_cd) throws EventException {
    log.debug("============================>[[ BLIssuanceBCImpl  searchDocRqst START ]]<============================");
        List<DocRqstVO> rlst = null;
        
        try {
            rlst = dbDao.searchDocRqst(bkg_no,ofc_cd);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  searchDocRqst END ]]<============================");
        return rlst ; 
    }
    /**
     * EsmBkg00059Event save event processing<br>
     * Documentation Requirement data modify. -- UI_BKG-0059<br>
     * 
     * @author LEE JIN SEO
     * @param DocRqstVO docrqstvo
     * @exception EventException
     */
    public void modifyDocRqst(DocRqstVO docrqstvo) throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  modifyDocRqst START ]]<============================");
	
	    // 01. validation
		BookingUtil bookingUtil = new BookingUtil();
	    BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
	    bkgBlNoIN.setBkgNo(docrqstvo.getBkgNo());
		bkgBlNoIN.setCaUsrId(docrqstvo.getUserId());
		
        try {
            // searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoIN);
            
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            //caFlag
            docrqstvo.setCaflag(bkgBlNoVO.getCaFlg());
            
            if(dbDao.modifyDocRqst(docrqstvo) == 0){
            	dbDao.addDocRqst(docrqstvo);
            }
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  modifyDocRqst END ]]<============================");
    }
    
    /**
     * retrieve event processing
     * MultiCombo retrieve event processing ESM_BKG_0278
     *
     * @param bkgComboVO
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchSRouteFromList(BkgComboVO bkgComboVO) throws EventException {
        try {
            return dbDao.searchSRouteFromList(bkgComboVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * retrieve event processing
     * retrieve event processing for ESM_BKG_0280
     *
     * @param grpBlPrtInVO
     * @return GrpBlPrtOutVO
     * @exception EventException
     */
    public GrpBlPrtOutVO searchBkgListForGrpBlPr(GrpBlPrtInVO grpBlPrtInVO) throws EventException {
        GrpBlPrtOutVO grpBlPrtOutVO = new GrpBlPrtOutVO();
        try {
            List<GrpBlPrtVO> grpBlPrt = dbDao.searchBkgListForGrpBlPr(grpBlPrtInVO);

            grpBlPrtOutVO.setGrpBlPrts(grpBlPrt);

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return grpBlPrtOutVO;
    }
    
    /**
     * Original B/L correct or not and detail info input event processing<br>
     * @param blIssueVO 
     * @exception EventException
     */
    public void manageOblRcv(BlIssVO blIssueVO) throws EventException {
        try {
        	/*
        	 * default initilize
        	 * if ida
        	 *     if (rdem >0 ||  (lg/lc && accept ))  && inbound doc Y then Y)  -- 20091109 占쎈땾占쎌젟 
        	 *     else N
        	 * else
        	 *     if rdem >0, or lg/lc & accept then Y
        	 *     else N 
        	 * end
        	 */
        	
        	if (blIssueVO.getOblRdemKnt() == null || blIssueVO.getOblRdemKnt().equals("")) {
        		// OB/L Redemption Count over 0 
        		// not null
        		blIssueVO.setOblRdemKnt("0");
        	}
        	
        	if (blIssueVO.getDelCntCd() != null && blIssueVO.getDelCntCd().equals("IN")) {
        		//bl_otr_doc_rcv_cd
        		//otr_doc_cgor_flg
        		// ida_bl_entr_rcv_flg
        		if ( (  (Integer.parseInt(blIssueVO.getOblRdemKnt()) > 0)
        		      ||(blIssueVO.getBlOtrDocRcvCd() != null && blIssueVO.getOtrDocCgorFlg() != null && blIssueVO.getOtrDocCgorFlg().equals("Y"))
        		     ) &&
        			  (blIssueVO.getIbdDocRcvFlg() != null && blIssueVO.getIbdDocRcvFlg().equals("Y"))
         		    )
        		{
        			blIssueVO.setOblRdemFlg("Y");
        			
        		} else {
        			blIssueVO.setOblRdemFlg("N");
        		}
        	} else {
        		//obl_rdem_knt
        		//bl_otr_doc_rcv_cd
        		//otr_doc_cgor_flg
        		if (  (Integer.parseInt(blIssueVO.getOblRdemKnt()) > 0)
        			||(blIssueVO.getBlOtrDocRcvCd().length()> 1 && blIssueVO.getOtrDocCgorFlg().equals("Y")) 
        		   ) 
        	    {
        			blIssueVO.setOblRdemFlg("Y");
        			
        		} else {
        			blIssueVO.setOblRdemFlg("N");
        		}
        	}
            int result = dbDao.modifyOblRcvByIbd(blIssueVO);
            
            if(result == 0){
            	log.debug("result of manageOblRcv 0 modify, call new input method");
            	dbDao.addOblRcvByIbd(blIssueVO);
            }

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * [0909] Original Bill of Lading Status modify
     *
     * @param BkgBlIssVO[] blStatusVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageOblRcvByUsCgo(BkgBlIssVO[] blStatusVOs,SignOnUserAccount account) throws EventException {

        try {

            BkgBlIssVO blStatusVO = null;

            for (int i = 0; i < blStatusVOs.length; i++) {
                blStatusVO = blStatusVOs[i];
                log.debug("------------------ blStatusVO " + blStatusVO.getColumnValues());
                //bl_cpy_knt,"bl_rlse_ofc_cd","bl_rlse_usr_id","bl_rlse_dt"
                if((blStatusVO.getBlCpyKnt() == null
                        || blStatusVO.getBlCpyKnt().equals(""))
                    &&(blStatusVO.getBlOtrDocRcvCd().equals("LG")
                        ||blStatusVO.getBlOtrDocRcvCd().equals("LI"))
                ){
                    //INSERT
                    dbDao.addOblRcvByUsCgo(blStatusVO,account);
                }else{
                    //MODIFY
                    dbDao.modifyOblRcvByUsCgo(blStatusVO, account);
                }
                break;
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }  
    
    
    /**
     * searchBlListForGroupUpdate
     * 
     * @param GrpBlDtInVO grpBlDtInVO
     * @return GrpBlDtVO
     * @throws EventException
     */
    public GrpBlDtVO searchBlListForGroupUpdate(GrpBlDtInVO grpBlDtInVO) throws EventException {
        GrpBlDtVO grpBlDtVO = new GrpBlDtVO();
        try {
            
            BookingUtil utilCmd = new BookingUtil();
            
            String vvd = grpBlDtInVO.getVvd();
            String vslCd = vvd.substring(0, 4);
            String voyNo = vvd.substring(4, 8);
            String dirCd = vvd.substring(8, 9);
            String portCd = grpBlDtInVO.getPolCd();
            String clptIndSeq = "1";
            
            VskVslPortSkdVO vskVslPortSkdVO = utilCmd.searchEtbEtdEta(vslCd, voyNo, dirCd, portCd, clptIndSeq);
            List<GrpBlDtListVO> grpBlDtListVOs = dbDao.searchBlListForGroupUpdate(grpBlDtInVO);

            GrpBlDtInVO grpBlDtOutVO = new GrpBlDtInVO();
            grpBlDtOutVO.setVvd(vvd);
            grpBlDtOutVO.setPolCd(portCd);
            if(vskVslPortSkdVO != null && vskVslPortSkdVO.getVslCd() != null) {
                // grpBlDtOutVO.setVvd(vskVslPortSkdVO.getVslCd()+vskVslPortSkdVO.getSkdVoyNo()+vskVslPortSkdVO.getSkdDirCd());
                // grpBlDtOutVO.setPolCd(vskVslPortSkdVO.getVpsPortCd());
                grpBlDtOutVO.setActArrDt(vskVslPortSkdVO.getVpsEtaDt());
                grpBlDtOutVO.setActDepDt(vskVslPortSkdVO.getVpsEtdDt());
            }
            grpBlDtVO.setGrpBlDtInVO(grpBlDtOutVO);
            grpBlDtVO.setGrpBlDtListVOs(grpBlDtListVOs);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return grpBlDtVO;
    }
    
    /**
     * modifyGroupBlUpdate
     * 
     * @param GrpBlDtListVO grpBlDtListVO
     * @param GrpBlDtInVO grpBlDtInVO
     * @throws EventException
     */
    public void modifyGroupBlUpdate(GrpBlDtListVO grpBlDtListVO, GrpBlDtInVO grpBlDtInVO) throws EventException {
        try {
            dbDao.modifyBlIssueDt(grpBlDtListVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } 
    }
    /**
     * modifyGroupBlUpdateHistory
     * 
     * @param GrpBlDtListVO grpBlDtListVO
     * @param GrpBlDtInVO grpBlDtInVO
     * @throws EventException
     */
    public void modifyGroupBlUpdateHistory(GrpBlDtListVO grpBlDtListVO, GrpBlDtInVO grpBlDtInVO) throws EventException {
        try {
            dbDao.modifyBlIssueDtHistory(grpBlDtListVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } 
    }
    
    /**
     * Retrieve Outbound booking list  for Draft BL and Waybill sending .<br>
     * 
     * @param ObDblWblInVO obDblWblInVO
     * @return DblWblOutVO
     * @exception EventException
     */
    public DblWblOutVO searchBkgListForObDblWbl(ObDblWblInVO obDblWblInVO) throws EventException {
        DblWblOutVO dblWblOutVO = null;
        List<DblWblVO> dblWblVOs = null;
        List<DblWblCntVO> dblWblCntVOs = null;
        try {
            if(obDblWblInVO != null){
        	dblWblVOs = dbDao.searchBkgListForObDrblWbl(obDblWblInVO);
            if (null!=dblWblVOs && 0<dblWblVOs.size()) {
                dblWblCntVOs = dbDao.searchBkgListForObDrblWblCnt(obDblWblInVO);
                if (null!=dblWblCntVOs && 0<dblWblCntVOs.size()) {
                    dblWblOutVO = new DblWblOutVO();
                    dblWblOutVO.setDblWbls(dblWblVOs);
                    dblWblOutVO.setDblWblCnts(dblWblCntVOs);
                }
              }
            }
        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return dblWblOutVO;
    }
    
    /**
     * Retrieve Inbound booking list  for Draft BL and Waybill sending.<br>
     * 
     * @param InDblWblInVO inDblWblInVO
     * @return DblWblOutVO
     * @exception EventException
     */
    public DblWblOutVO searchBkgListForIbDblWbl(InDblWblInVO inDblWblInVO) throws EventException {
        DblWblOutVO dblWblOutVO = null;
        List<DblWblVO> dblWblVOs = null;
        List<DblWblCntVO> dblWblCntVOs = null;
        try {
            dblWblVOs = dbDao.searchBkgListForIbDrblWbl(inDblWblInVO);
            if (null!=dblWblVOs && 0<dblWblVOs.size()) {
                dblWblCntVOs = dbDao.searchBkgListForIbDrblWblCnt(inDblWblInVO);
                if (null!=dblWblCntVOs && 0<dblWblCntVOs.size()) {
                    dblWblOutVO = new DblWblOutVO();
                    dblWblOutVO.setDblWbls(dblWblVOs);
                    dblWblOutVO.setDblWblCnts(dblWblCntVOs);
                }
            }
        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return dblWblOutVO;
    }
    
    /**
	 * Retrieve Email Address in Chinese Booking Agent Code when applicable to BKG Draft B/L sending.<br>
     * 
     * @param List<String> bkgNos
     * @return List<AgentEmlVO>
     * @exception EventException
     */
    public List<AgentEmlVO> searchBkgAgentEml(List<String> bkgNos) throws EventException {
        List<AgentEmlVO> agentEmlVOs = null;
        try {
        	agentEmlVOs = dbDao.searchBkgAgentEml(bkgNos);
        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return agentEmlVOs;
    }
    
    /**
     * retrieve sending result of Fax, Mail each Booking.<br>
     * 
     * @param MultiNtcHisVO multiNtcHisVO
     * @return List<MultiNtcHisVO>
     * @exception EventException
     */
    public List<MultiNtcHisVO> searchMultiNtcHis(MultiNtcHisVO multiNtcHisVO) throws EventException {
        List<MultiNtcHisVO> multiNtcHisVOs = null;
        try {
        	multiNtcHisVOs = dbDao.searchMultiNtcHis(multiNtcHisVO);
        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return multiNtcHisVOs;
    }
    
    /**
     * retrieve event processing
     *  check Rider Y or N ESM_BKG_0927
     *
     * @param String bkg_no
     * @param String hiddenData
     * @param String rate
     * @param String cntr
     * @param String corr_no
     * @return String
     * @exception EventException
     */
    public String searchRiderYn(String bkg_no, String hiddenData, String rate, String cntr, String corr_no) throws EventException {
        try {
            return dbDao.searchRiderYn(bkg_no, hiddenData, rate, cntr, corr_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * retrieve event processing
     *  check HouseB/L Y or N ESM_BKG_0927
     *
     * @param bkg_no
     * @return String
     * @exception EventException
     */
    public String searchHouseBlYn(String bkg_no) throws EventException {
        try {
            return dbDao.searchHouseBlYn(bkg_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * retrieve event processing<br>
     *  check HouseB/L Y or N ESM_BKG_0743<br>
     *
     * @param String bkg_no
     * @param String corr_no
     * @return String
     * @exception EventException
     */
    public String searchOblRlseFlg(String bkg_no, String corr_no) throws EventException {
        try {
            return dbDao.searchOblRlseFlg(bkg_no, corr_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * retrieve event processing<br>
     * OBL_ISS_FLG ESM_BKG_0743<br>
     *
     * @param String bkg_no
     * @return String
     * @exception EventException
     */
    public String searchOblIssFlg(String bkg_no) throws EventException {
        try {
            return dbDao.searchOblIssFlg(bkg_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * EsmBkg0927Event Email event processing
     * Email send
     *
     * @param DblWblVO[] dblWblVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendDblWblByEmail(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException {
        List<BkgNtcHisVO> bkgNtcHisVOs = null;
        MailSendVO mailInfo = null;
        String retEmailSndId = null;
        ArrayList<String> arrTmplMrd = null;
        ArrayList<String> arrTmplParam = null;
        ArrayList<String> arrTmplMrdPdf = null;
        List<ComRptDsgnXptInfoVO> xptVOs = new ArrayList<ComRptDsgnXptInfoVO>();
        ComRptDsgnXptInfoVO xptVO = null;
        StringTokenizer strNBkgNo = null;
        SimpleDateFormat format = null;
        BkgNtcHisVO bkgNtcHisVO = null;
        StringBuilder sbBlNos = null;
        String strBlNoTitle = null;
        String strBlNoBody = null;
        String strBlRemark = "";
        String title = null;
        String contentsParam = null;
        int cnt = 0;
        BookingUtil util = null;
		ComUserVO comUserVO = null;
		String bccRcvrEml = "";
        try {
            util = new BookingUtil();
			// modify  account.getUsr_Eml() -> getDfltEml()
            comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			
            bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            format = new SimpleDateFormat("yyyyMMddHHmmss");
            String senderMailAddr ="";
            int idx = 0;
            for (DblWblVO vo : dblWblVOs) {
                // in case of many *.mrd file send Email
                arrTmplMrd    = new ArrayList<String>();
                arrTmplParam  = new ArrayList<String>();
                arrTmplMrdPdf = new ArrayList<String>();
            	log.debug("####### [vo.getTmplmrd] ###########"+vo.getTmplmrd());
                for (String s : vo.getTmplmrd   ().split("\\|\\$\\$\\|")) { arrTmplMrd   .add(s); }
                for (String s : vo.getTmplparam ().split("\\|\\$\\$\\|")) { arrTmplParam .add(s); }
                for (String s : vo.getTmplmrdpdf().split("\\|\\$\\$\\|")) { arrTmplMrdPdf.add(s); }
                xptVOs = new ArrayList<ComRptDsgnXptInfoVO>();//Null Referencing
            	log.debug("####### [size] ###########"+arrTmplParam.size());

                for (int j=0; j < arrTmplParam.size(); j++) {
                	xptVO = new ComRptDsgnXptInfoVO();
                	log.debug("##################"+arrTmplMrd.get(j));
                	log.debug("##################"+arrTmplParam.get(j));
                	log.debug("##################"+arrTmplMrdPdf.get(j));
                	
                	
                	xptVO.setRdTmpltNm(arrTmplMrd.get(j));           // *.mrd name
                	xptVO.setRdParaCtnt(arrTmplParam.get(j));  // *.mrd parameter
                	xptVO.setXptFileNm(arrTmplMrdPdf.get(j));   // Will be changed file name when *.mrd attach
                	xptVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
                    xptVOs.add(xptVO);
                }
                // Email sending
                mailInfo = new MailSendVO();
				mailInfo.setSysCd("BKG");
				mailInfo.setTmplMrd(vo.getTmplmrd());
				mailInfo.setBatchFlg("N");
				mailInfo.setTmplParam(vo.getTmplparam());
				if(senderMailAddr.equals("")){
					mailInfo.setSndNm(account.getUsr_nm());
				}else{
					mailInfo.setSndNm("");
				}
				senderMailAddr = senderMailAddr.equals("") ? sUsrEml:senderMailAddr;
				
				mailInfo.setSndEml(senderMailAddr);
				
//				if(bkgEmlEdtVO.getEdtFromEml().equals("noreply@nykline.com")){
				if(bkgEmlEdtVO != null && "noreply@nykline.com".equals(bkgEmlEdtVO.getEdtFromEml())){
					mailInfo.setSndNm("");
					mailInfo.setSndEml("noreply@nykline.com");
				}
				
				//mailInfo.setSndEml(account.getUsr_eml());
				mailInfo.setRcvEml(vo.getRcveml());
				mailInfo.setCrtUserId(account.getUsr_id());
				mailInfo.setFileKey("");
                //once send in case of group mail
				if (!"Y".equalsIgnoreCase(vo.getGrpFlag()) || ("Y".equalsIgnoreCase(vo.getGrpFlag()) && 0==idx++)) {
					
                	if ("Y".equalsIgnoreCase(vo.getGrpFlag())) {  //in case of group mail
                		sbBlNos = new StringBuilder();
                		cnt = -1;
    					for (DblWblVO tmp : dblWblVOs) {
    						sbBlNos.append(tmp.getBlNo()).append(", ");
    						cnt++;
    					}
    					sbBlNos.delete(sbBlNos.lastIndexOf(","), sbBlNos.length());
						strBlNoTitle = vo.getBlNo()+" and "+cnt+" B/Ls";
						strBlNoBody = sbBlNos.toString();
                	} else {
						strBlNoTitle = strBlNoBody = vo.getBlNo();
                	}
                	//mail filename
					String inDate   = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
					String inTime   = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());
					String fileName = "";

                	if ("WB".equalsIgnoreCase(vo.getNtcKndCd())) {
            			fileName = "NYKS"+ vo.getBlNo() + "_seaway_"+inDate+inTime+".pdf";
            		} else if ("NN".equalsIgnoreCase(vo.getNtcKndCd())) {
            			fileName = "NYKS"+ vo.getBlNo() + "_noncopy_"+inDate+inTime+".pdf";
            		} else if("CW".equalsIgnoreCase(vo.getNtcKndCd())){
            			fileName = "NYKS"+ vo.getBlNo() + "_seaway_"+inDate+inTime+".pdf";
            		} else {
            			fileName = "NYKS"+ vo.getBlNo() + "_draft_"+inDate+inTime+".pdf";
            		}
                	mailInfo.setTmplMrdPdf(fileName);
                	
                	//mail form
                	String vslNm = this.searchVesselNameByBkgNo(vo.getBkgNo());
                	if (!StringUtils.isEmpty(vo.getTitle())) {
                		title = vo.getTitle();
                	} else {
                		StringBuilder titleSb = new StringBuilder("");
                		if ("WB".equalsIgnoreCase(vo.getNtcKndCd())) {
                			titleSb.append("Sea Waybills");
                		} else if ("NN".equalsIgnoreCase(vo.getNtcKndCd())) {
                   			titleSb.append("B/L Copy");
                		} else if("CW".equalsIgnoreCase(vo.getNtcKndCd())){
                			titleSb.append("Copy Sea Waybills");
                		} else {
                        	//mail remark
                			if(null != vo.getRemark()){
                    			String str = vo.getRemark().replaceAll("(\r\n|\n)", "<br>");
                    			if(str.endsWith("<br>")){
                    				str = str.substring(0, str.length()-4);
                    			}
                    			
                    			if(str.length() == 0){
                    				if(vo.getDiffRmk().length()==0){
                    					strBlRemark = "";
                    				}else{
                    					strBlRemark = "<br><br>"+vo.getDiffRmk();
                    				}
                    			}else{
                    				if(vo.getDiffRmk().length()==0){
                    					strBlRemark = "<br><br>"+str;
                    				}else{
                    					strBlRemark = "<br><br>"+str+"<br>"+vo.getDiffRmk();
                    				}
                    			}
                			}
                            
                			titleSb.append("Draft B/L(s)");
                		}
                		titleSb.append(" (T/VVD : ").append(vslNm).append(" / B/L No : NYKS").append(strBlNoTitle).append(")");
                		title = titleSb.toString();
                	}
                	
                	bccRcvrEml = util.searchBccEmailAddrRSQL(vo.getNtcKndCd());
                	
                	if( !StringUtils.isBlank(bccRcvrEml) ){      
                        mailInfo.setBccRcvrEml(bccRcvrEml);
                        log.debug("-------------------- getBccRcvrEml : " + mailInfo.getBccRcvrEml());
                	}      
                	
                    contentsParam = !StringUtils.isEmpty(vo.getContents()) ? vo.getContents() : "blNoTitle;T/VVD : "+vslNm+" / B/L No : NYKS"+strBlNoTitle+"@@blNoBody;NYKS"+strBlNoBody+"@@blRemark;"+strBlRemark;
					mailInfo.setTitle(title); // title
    				mailInfo.setContents(contentsParam); // contents
					mailInfo.setCcEml(util.searchCcEmailAddrRSQL(vo.getNtcKndCd(), account.getUsr_id()));
log.debug("\n\n\n\n\n\n\n\n\n\n\n\n\n==========\n"+arrTmplParam.size()+"\n==========\n\n\n\n\n\n\n\n\n\n\n\n\n");
    				if (arrTmplParam != null && arrTmplParam.size() > 1) {
	                    retEmailSndId = bleaiDao.sendReportDesignerWithFiles(mailInfo, bkgEmlEdtVO, xptVOs);
	                } else {
	                    // Send Mail - 1:1 matching in case of one *.mrd file send 
	                    // That is, send to same email address as number as *.mrd file count in case of *.mrd file is not only
	                    retEmailSndId = bleaiDao.sendEmail(mailInfo, bkgEmlEdtVO, vo.getNtcKndCd(), util.searchCcEmailAddrRSQL(vo.getNtcKndCd(), account.getUsr_id()));
	                }
                }
                // Notice History Setting(input History each bkg_no)
                strNBkgNo = new StringTokenizer(vo.getBkgNo(), "|");  // separator is "|" in case of many BKG_NO in one BL 
                while (strNBkgNo.hasMoreTokens()) {
                    bkgNtcHisVO = new BkgNtcHisVO();
                    bkgNtcHisVO.setBkgNo(strNBkgNo.nextToken());
                    bkgNtcHisVO.setNtcViaCd("M");
                    bkgNtcHisVO.setNtcKndCd((vo.getNtcKndCd()==null||"".equals(vo.getNtcKndCd()))?"BL":vo.getNtcKndCd());  // NTC_KND_CD(BL:Outbound,NN:Inbound,WB:Waybill)  
                    bkgNtcHisVO.setAgnCd("");
                    bkgNtcHisVO.setNtcFomCd("");
                    bkgNtcHisVO.setNtcSeq("");
                    bkgNtcHisVO.setBkgCustTpCd("");
                    bkgNtcHisVO.setCustCntcTpCd("");
                    bkgNtcHisVO.setNtcEml(vo.getRcveml());
                    bkgNtcHisVO.setSndId(retEmailSndId);
                    bkgNtcHisVO.setFrtHdnFlg(vo.getHiddOpt());
                    bkgNtcHisVO.setFrtAllFlg(vo.getFrtAllFlg());
                    bkgNtcHisVO.setFrtCltFlg(vo.getFrtCltFlg());
                    bkgNtcHisVO.setFrtPpdFlg(vo.getFrtPpdFlg());
                    bkgNtcHisVO.setFrtChgFlg(vo.getFrtChgFlg());
                    bkgNtcHisVO.setFrtArrFlg(vo.getFrtArrFlg());
                    bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
                    bkgNtcHisVO.setSndUsrId(account.getUsr_id());
                    bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
                    bkgNtcHisVO.setDiffRmk("");
                    bkgNtcHisVO.setCreUsrId(account.getUsr_id());
                    bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
                    bkgNtcHisVOs.add(bkgNtcHisVO);
                }
                
                //Sea Waybill Email 獄쏆뮇�꽊占쎈뻻 BKG_INET_BL_PRN_AUTH 占쎈퓠 占쏙옙占쎌삢占쎈립占쎈뼄.
                if ("WB".equalsIgnoreCase(vo.getNtcKndCd())) {
                	strNBkgNo = new StringTokenizer(vo.getBkgNo(), "|");
                	SeaWayBillPrintVO seaWayBillPrintVO = new SeaWayBillPrintVO();
            		
                	while (strNBkgNo.hasMoreTokens()) {
            			seaWayBillPrintVO = dbDao.searchSeaWayBillPrint(strNBkgNo.nextToken());
            			if(seaWayBillPrintVO != null){
            				seaWayBillPrintVO.setAuthOfcCd(account.getOfc_cd());
            				seaWayBillPrintVO.setAuthUsrId(account.getUsr_id());
            				seaWayBillPrintVO.setInetBlSndViaCd("E");		//E:Email, P:Print
            				seaWayBillPrintVO.setOblKnt("0");
            				seaWayBillPrintVO.setCpyKnt("0");
            				seaWayBillPrintVO.setWblPrnKnt("1");
            				seaWayBillPrintVO.setDocEcdProcFlg("N");
            				seaWayBillPrintVO.setPrnCustTpCd("O");
            				seaWayBillPrintVO.setPrnUsrId(account.getUsr_id());
            				seaWayBillPrintVO.setAuthLginFlg("N");
            				seaWayBillPrintVO.setDeltFlg("N");
            				seaWayBillPrintVO.setUpdUsrId(account.getUsr_id());
            				
            				dbDao.modifySeaWayBillPrint(seaWayBillPrintVO);
            				
            				dbDao.addSeaWayBillPrint(seaWayBillPrintVO);
            			}
                	}
                }
            }
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }
    
    /**
     * EsmBkg0218Event Email event processing
     * Email send
     *
     * @param DblWblVO[] dblWblVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendDblWblByGroupEmail(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException {
        List<BkgNtcHisVO> bkgNtcHisVOs = null;
        MailSendVO mailInfo = null;
        String retEmailSndId = null;
        List<ComRptDsgnXptInfoVO> xptVOs = new ArrayList<ComRptDsgnXptInfoVO>();
        ComRptDsgnXptInfoVO xptVO = null;
        SimpleDateFormat format = null;
        BkgNtcHisVO bkgNtcHisVO = null;
        StringBuilder sbBlNos = null;
        String strBlNoTitle = null;
        String strBlNoBody = null;
        String strBlRemark = "";
        String title = null;
        String contentsParam = null;
        int cnt = 0;
        BookingUtil util = null;
		ComUserVO comUserVO = null;
		String bccRcvrEml = "";
		String rcveml = "";
		String sBlNo = "";
		String sNtcKndCd = "";
        try {
            util = new BookingUtil();
			// modify  account.getUsr_Eml() -> getDfltEml()
            comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			
            bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            format = new SimpleDateFormat("yyyyMMddHHmmss");
            String senderMailAddr ="";

            for (DblWblVO vo : dblWblVOs) {
            	xptVO = new ComRptDsgnXptInfoVO();
            	log.debug("##################"+vo.getTmplmrd());
            	log.debug("##################"+vo.getTmplparam());
            	log.debug("##################"+vo.getTmplmrdpdf());
            	
            	xptVO.setRdTmpltNm(vo.getTmplmrd());           // *.mrd name
            	xptVO.setRdParaCtnt(vo.getTmplparam());  // *.mrd parameter
            	xptVO.setXptFileNm(vo.getTmplmrdpdf());   // Will be changed file name when *.mrd attach
            	xptVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
            	xptVO.setCreUsrId(account.getUsr_id());
            	xptVO.setUpdUsrId(account.getUsr_id());
                xptVOs.add(xptVO);
            }
            
            // Email sending
            mailInfo = new MailSendVO();
			mailInfo.setSysCd("BKG");
//			mailInfo.setTmplMrd(vo.getTmplmrd());
			mailInfo.setBatchFlg("N");
//			mailInfo.setTmplParam(vo.getTmplparam());
			if(senderMailAddr.equals("")){
				mailInfo.setSndNm(account.getUsr_nm());
			}else{
				mailInfo.setSndNm("");
			}
			senderMailAddr = senderMailAddr.equals("") ? sUsrEml:senderMailAddr;
			
			mailInfo.setSndEml(senderMailAddr);
			
//			if(bkgEmlEdtVO.getEdtFromEml().equals("noreply@nykline.com")){
			if(bkgEmlEdtVO != null && "noreply@nykline.com".equals(bkgEmlEdtVO.getEdtFromEml())){
				mailInfo.setSndNm("");
				mailInfo.setSndEml("noreply@nykline.com");
			}
			
			sbBlNos = new StringBuilder();
    		cnt = -1;
			for (DblWblVO tmp : dblWblVOs) {
				sbBlNos.append(tmp.getBlNo()).append(", ");
				cnt++;
				if(cnt==0){
					sBlNo = tmp.getBlNo();
					sNtcKndCd = tmp.getNtcKndCd();
					rcveml = tmp.getRcveml();
				}
			}
			//mailInfo.setSndEml(account.getUsr_eml());
			mailInfo.setRcvEml(rcveml);
			mailInfo.setCrtUserId(account.getUsr_id());
			mailInfo.setFileKey("");
            
			sbBlNos.delete(sbBlNos.lastIndexOf(","), sbBlNos.length());
			strBlNoTitle = sBlNo+" and "+cnt+" B/Ls";
			strBlNoBody = sbBlNos.toString();
			
			//mail filename
			String inDate   = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
			String inTime   = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());
			String fileName = "";

        	if ("WB".equalsIgnoreCase(sNtcKndCd)) {
    			fileName = "NYKS"+ sBlNo + " and "+cnt+" B/Ls_seaway_"+inDate+inTime+".pdf";
    		} else if ("NN".equalsIgnoreCase(sNtcKndCd)) {
    			fileName = "NYKS"+ sBlNo + " and "+cnt+" B/Ls_noncopy_"+inDate+inTime+".pdf";
    		} else if("CW".equalsIgnoreCase(sNtcKndCd)){
    			fileName = "NYKS"+ sBlNo + " and "+cnt+" B/Ls_seaway_"+inDate+inTime+".pdf";
    		} else {
    			fileName = "NYKS"+ sBlNo + " and "+cnt+" B/Ls_draft_"+inDate+inTime+".pdf";
    		}
        	mailInfo.setTmplMrdPdf(fileName);
            
        	//mail form
        	String vslNm = this.searchVesselNameByBkgNo(sBlNo);
        	
    		StringBuilder titleSb = new StringBuilder("");
    		if ("WB".equalsIgnoreCase(sNtcKndCd)) {
    			titleSb.append("Sea Waybills");
    		} else if ("NN".equalsIgnoreCase(sNtcKndCd)) {
       			titleSb.append("B/L Copy");
    		} else if("CW".equalsIgnoreCase(sNtcKndCd)){
    			titleSb.append("Copy Sea Waybills");
    		}
    		titleSb.append(" (T/VVD : ").append(vslNm).append(" / B/L No : NYKS").append(strBlNoTitle).append(")");
    		title = titleSb.toString();
        	
        	bccRcvrEml = util.searchBccEmailAddrRSQL(sNtcKndCd);
        	
        	if( !StringUtils.isBlank(bccRcvrEml) ){      
                mailInfo.setBccRcvrEml(bccRcvrEml);
                log.debug("-------------------- getBccRcvrEml : " + mailInfo.getBccRcvrEml());
        	}      
        	
            contentsParam = "blNoTitle;T/VVD : "+vslNm+" / B/L No : NYKS"+strBlNoTitle+"@@blNoBody;NYKS"+strBlNoBody+"@@blRemark;"+strBlRemark;
			mailInfo.setTitle(title); // title
			mailInfo.setContents(contentsParam); // contents
			mailInfo.setCcEml(util.searchCcEmailAddrRSQL(sNtcKndCd, account.getUsr_id()));
            log.debug("-------------------- ccEml : " + util.searchCcEmailAddrRSQL(sNtcKndCd, account.getUsr_id()));
			retEmailSndId = bleaiDao.sendReportDesignerWithFiles(mailInfo, bkgEmlEdtVO, xptVOs);
        	
        	//###############################################################################################################
            
            // Notice History Setting(input History each bkg_no)
            for (DblWblVO tmp : dblWblVOs) {
                bkgNtcHisVO = new BkgNtcHisVO();
                bkgNtcHisVO.setBkgNo(tmp.getBkgNo());
                bkgNtcHisVO.setNtcViaCd("M");
                bkgNtcHisVO.setNtcKndCd((tmp.getNtcKndCd()==null||"".equals(tmp.getNtcKndCd()))?"BL":tmp.getNtcKndCd());  // NTC_KND_CD(BL:Outbound,NN:Inbound,WB:Waybill)  
                bkgNtcHisVO.setAgnCd("");
                bkgNtcHisVO.setNtcFomCd("");
                bkgNtcHisVO.setNtcSeq("");
                bkgNtcHisVO.setBkgCustTpCd("");
                bkgNtcHisVO.setCustCntcTpCd("");
                bkgNtcHisVO.setNtcEml(tmp.getRcveml());
                bkgNtcHisVO.setSndId(retEmailSndId);
                bkgNtcHisVO.setFrtHdnFlg(tmp.getHiddOpt());
                bkgNtcHisVO.setFrtAllFlg(tmp.getFrtAllFlg());
                bkgNtcHisVO.setFrtCltFlg(tmp.getFrtCltFlg());
                bkgNtcHisVO.setFrtPpdFlg(tmp.getFrtPpdFlg());
                bkgNtcHisVO.setFrtChgFlg(tmp.getFrtChgFlg());
                bkgNtcHisVO.setFrtArrFlg(tmp.getFrtArrFlg());
                bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
                bkgNtcHisVO.setSndUsrId(account.getUsr_id());
                bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
                bkgNtcHisVO.setDiffRmk("");
                bkgNtcHisVO.setCreUsrId(account.getUsr_id());
                bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
                bkgNtcHisVOs.add(bkgNtcHisVO);
			}
            
            
            //Sea Waybill Email
            if ("WB".equalsIgnoreCase(sNtcKndCd)) {
//            	strNBkgNo = new StringTokenizer(vo.getBkgNo(), "|");
            	SeaWayBillPrintVO seaWayBillPrintVO = new SeaWayBillPrintVO();
        		
            	for (DblWblVO tmp : dblWblVOs) {
        			seaWayBillPrintVO = dbDao.searchSeaWayBillPrint(tmp.getBkgNo());
        			if(seaWayBillPrintVO != null){
        				seaWayBillPrintVO.setAuthOfcCd(account.getOfc_cd());
        				seaWayBillPrintVO.setAuthUsrId(account.getUsr_id());
        				seaWayBillPrintVO.setInetBlSndViaCd("E");		//E:Email, P:Print
        				seaWayBillPrintVO.setOblKnt("0");
        				seaWayBillPrintVO.setCpyKnt("0");
        				seaWayBillPrintVO.setWblPrnKnt("1");
        				seaWayBillPrintVO.setDocEcdProcFlg("N");
        				seaWayBillPrintVO.setPrnCustTpCd("O");
        				seaWayBillPrintVO.setPrnUsrId(account.getUsr_id());
        				seaWayBillPrintVO.setAuthLginFlg("N");
        				seaWayBillPrintVO.setDeltFlg("N");
        				seaWayBillPrintVO.setUpdUsrId(account.getUsr_id());

        				dbDao.modifySeaWayBillPrint(seaWayBillPrintVO);
        				dbDao.addSeaWayBillPrint(seaWayBillPrintVO);
        			}
            	}
            }
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }    
    
    /**
     * EsmBkg0218Event Email event processing
     * Email send
     *
     * @param DblWblVO[] dblWblVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendDblWblByGroupEmail2(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException {
        List<BkgNtcHisVO> bkgNtcHisVOs = null;
        MailSendVO mailInfo = null;
        String retEmailSndId = null;
        List<ComRptDsgnXptInfoVO> xptVOs = new ArrayList<ComRptDsgnXptInfoVO>();
        ComRptDsgnXptInfoVO xptVO = null;
        SimpleDateFormat format = null;
        BkgNtcHisVO bkgNtcHisVO = null;
        StringBuilder sbBlNos = null;
        String strBlNoTitle = null;
        String strBlNoBody = null;
        String strBlRemark = "";
        String title = null;
        String contentsParam = null;
        int cnt = 0;
        BookingUtil util = null;
		ComUserVO comUserVO = null;
		String bccRcvrEml = "";
		String rcveml = "";
		String sBkgNo = "";
		String sBlNo = "";
		String sNtcKndCd = "";
        try {
            util = new BookingUtil();
			// modify  account.getUsr_Eml() -> getDfltEml()
            comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			
            bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            format = new SimpleDateFormat("yyyyMMddHHmmss");
            String senderMailAddr ="";

            for (DblWblVO vo : dblWblVOs) {
            	xptVO = new ComRptDsgnXptInfoVO();
            	log.debug("##################"+vo.getTmplmrd());
            	log.debug("##################"+vo.getTmplparam());
            	log.debug("##################"+vo.getTmplmrdpdf());
            	
            	xptVO.setRdTmpltNm(vo.getTmplmrd());           // *.mrd name
            	xptVO.setRdParaCtnt(vo.getTmplparam());  // *.mrd parameter
            	xptVO.setXptFileNm(vo.getTmplmrdpdf());   // Will be changed file name when *.mrd attach
            	xptVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
            	xptVO.setCreUsrId(account.getUsr_id());
            	xptVO.setUpdUsrId(account.getUsr_id());
                xptVOs.add(xptVO);
            }
            
            // Email sending
            mailInfo = new MailSendVO();
			mailInfo.setSysCd("BKG");
//			mailInfo.setTmplMrd(vo.getTmplmrd());
			mailInfo.setBatchFlg("N");
//			mailInfo.setTmplParam(vo.getTmplparam());
			if(senderMailAddr.equals("")){
				mailInfo.setSndNm(account.getUsr_nm());
			}else{
				mailInfo.setSndNm("");
			}
			senderMailAddr = senderMailAddr.equals("") ? sUsrEml:senderMailAddr;
			
			mailInfo.setSndEml(senderMailAddr);
			
//			if(bkgEmlEdtVO.getEdtFromEml().equals("noreply@nykline.com")){
			if(bkgEmlEdtVO != null && "noreply@nykline.com".equals(bkgEmlEdtVO.getEdtFromEml())){
				mailInfo.setSndNm("");
				mailInfo.setSndEml("noreply@nykline.com");
			}
			
			//once send in case of group mail
			sbBlNos = new StringBuilder();
    		cnt = -1;
			for (DblWblVO tmp : dblWblVOs) {
				sbBlNos.append(tmp.getBlNo()).append(", ");
				cnt++;
				if(cnt==0){
					sBkgNo = tmp.getBkgNo();
					sBlNo = tmp.getBlNo();
					sNtcKndCd = tmp.getNtcKndCd();
					rcveml = tmp.getRcveml();
				}
			}
			//mailInfo.setSndEml(account.getUsr_eml());
			mailInfo.setRcvEml(rcveml);
			mailInfo.setCrtUserId(account.getUsr_id());
			mailInfo.setFileKey("");
            
			sbBlNos.delete(sbBlNos.lastIndexOf(","), sbBlNos.length());
			if(cnt == 0 ){
				strBlNoTitle = sBlNo;
			}else{
				strBlNoTitle = sBlNo+" and "+cnt+" B/Ls";
			}
			strBlNoBody = sbBlNos.toString();
			
			//mail filename
			String inDate   = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
			String inTime   = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());
			String fileName = "";

			if(cnt==0){
	        	if ("WB".equalsIgnoreCase(sNtcKndCd)) {
	    			fileName = "NYKS"+ sBlNo + " B/Ls_seaway_"+inDate+inTime+".pdf";
	    		} else if ("NN".equalsIgnoreCase(sNtcKndCd)) {
	    			fileName = "NYKS"+ sBlNo + " B/Ls_noncopy_"+inDate+inTime+".pdf";
	    		} else if("CW".equalsIgnoreCase(sNtcKndCd)){
	    			fileName = "NYKS"+ sBlNo + " B/Ls_seaway_"+inDate+inTime+".pdf";
	    		} else {
	    			fileName = "NYKS"+ sBlNo + " B/Ls_draft_"+inDate+inTime+".pdf";
	    		}
			}else{
	        	if ("WB".equalsIgnoreCase(sNtcKndCd)) {
	    			fileName = "NYKS"+ sBlNo + " and "+cnt+" B/Ls_seaway_"+inDate+inTime+".pdf";
	    		} else if ("NN".equalsIgnoreCase(sNtcKndCd)) {
	    			fileName = "NYKS"+ sBlNo + " and "+cnt+" B/Ls_noncopy_"+inDate+inTime+".pdf";
	    		} else if("CW".equalsIgnoreCase(sNtcKndCd)){
	    			fileName = "NYKS"+ sBlNo + " and "+cnt+" B/Ls_seaway_"+inDate+inTime+".pdf";
	    		} else {
	    			fileName = "NYKS"+ sBlNo + " and "+cnt+" B/Ls_draft_"+inDate+inTime+".pdf";
	    		}
			}
        	mailInfo.setTmplMrdPdf(fileName);
            
        	//mail form
        	String vslNm = this.searchVesselNameByBkgNo(sBkgNo);
        	
    		StringBuilder titleSb = new StringBuilder("");
    		if ("WB".equalsIgnoreCase(sNtcKndCd)) {
    			titleSb.append("Sea Waybills");
    		} else if ("NN".equalsIgnoreCase(sNtcKndCd)) {
       			titleSb.append("B/L Copy");
    		} else if("CW".equalsIgnoreCase(sNtcKndCd)){
    			titleSb.append("Copy Sea Waybills");
    		}
    		titleSb.append(" (T/VVD : ").append(vslNm).append(" / B/L No : NYKS").append(strBlNoTitle).append(")");
    		title = titleSb.toString();
        	
        	bccRcvrEml = util.searchBccEmailAddrRSQL(sNtcKndCd);
        	
        	if( !StringUtils.isBlank(bccRcvrEml) ){      
                mailInfo.setBccRcvrEml(bccRcvrEml);
                log.debug("-------------------- getBccRcvrEml : " + mailInfo.getBccRcvrEml());
        	}      
        	
            contentsParam = "blNoTitle;T/VVD : "+vslNm+" / B/L No : NYKS"+strBlNoTitle+"@@blNoBody;NYKS"+strBlNoBody+"@@blRemark;"+strBlRemark;
			mailInfo.setTitle(title); // title
			mailInfo.setContents(contentsParam); // contents
			mailInfo.setCcEml(util.searchCcEmailAddrRSQL(sNtcKndCd, account.getUsr_id()));
            log.debug("-------------------- ccEml : " + util.searchCcEmailAddrRSQL(sNtcKndCd, account.getUsr_id()));
			retEmailSndId = bleaiDao.sendReportDesignerWithFiles2(mailInfo, bkgEmlEdtVO, xptVOs, sNtcKndCd, util.searchCcEmailAddrRSQL(sNtcKndCd, account.getUsr_id()));
        	
        	//###############################################################################################################
            
            // Notice History Setting(input History each bkg_no)
            for (DblWblVO tmp : dblWblVOs) {
                bkgNtcHisVO = new BkgNtcHisVO();
                bkgNtcHisVO.setBkgNo(tmp.getBkgNo());
                bkgNtcHisVO.setNtcViaCd("M");
                bkgNtcHisVO.setNtcKndCd((tmp.getNtcKndCd()==null||"".equals(tmp.getNtcKndCd()))?"BL":tmp.getNtcKndCd());  // NTC_KND_CD(BL:Outbound,NN:Inbound,WB:Waybill)  
                bkgNtcHisVO.setAgnCd("");
                bkgNtcHisVO.setNtcFomCd("");
                bkgNtcHisVO.setNtcSeq("");
                bkgNtcHisVO.setBkgCustTpCd("");
                bkgNtcHisVO.setCustCntcTpCd("");
                bkgNtcHisVO.setNtcEml(tmp.getRcveml());
                bkgNtcHisVO.setSndId(retEmailSndId);
                bkgNtcHisVO.setFrtHdnFlg(tmp.getHiddOpt());
                bkgNtcHisVO.setFrtAllFlg(tmp.getFrtAllFlg());
                bkgNtcHisVO.setFrtCltFlg(tmp.getFrtCltFlg());
                bkgNtcHisVO.setFrtPpdFlg(tmp.getFrtPpdFlg());
                bkgNtcHisVO.setFrtChgFlg(tmp.getFrtChgFlg());
                bkgNtcHisVO.setFrtArrFlg(tmp.getFrtArrFlg());
                bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
                bkgNtcHisVO.setSndUsrId(account.getUsr_id());
                bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
                bkgNtcHisVO.setDiffRmk("");
                bkgNtcHisVO.setCreUsrId(account.getUsr_id());
                bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
                bkgNtcHisVOs.add(bkgNtcHisVO);
			}
            
            
            //Sea Waybill Email
            if ("WB".equalsIgnoreCase(sNtcKndCd)) {
//            	strNBkgNo = new StringTokenizer(vo.getBkgNo(), "|");
            	SeaWayBillPrintVO seaWayBillPrintVO = new SeaWayBillPrintVO();
        		
            	for (DblWblVO tmp : dblWblVOs) {
        			seaWayBillPrintVO = dbDao.searchSeaWayBillPrint(tmp.getBkgNo());
        			if(seaWayBillPrintVO != null){
        				seaWayBillPrintVO.setAuthOfcCd(account.getOfc_cd());
        				seaWayBillPrintVO.setAuthUsrId(account.getUsr_id());
        				seaWayBillPrintVO.setInetBlSndViaCd("E");		//E:Email, P:Print
        				seaWayBillPrintVO.setOblKnt("0");
        				seaWayBillPrintVO.setCpyKnt("0");
        				seaWayBillPrintVO.setWblPrnKnt("1");
        				seaWayBillPrintVO.setDocEcdProcFlg("N");
        				seaWayBillPrintVO.setPrnCustTpCd("O");
        				seaWayBillPrintVO.setPrnUsrId(account.getUsr_id());
        				seaWayBillPrintVO.setAuthLginFlg("N");
        				seaWayBillPrintVO.setDeltFlg("N");
        				seaWayBillPrintVO.setUpdUsrId(account.getUsr_id());

        				dbDao.modifySeaWayBillPrint(seaWayBillPrintVO);
        				dbDao.addSeaWayBillPrint(seaWayBillPrintVO);
        			}
            	}
            }
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }    
    
    /**
     * EsmBkg0927Event Fax event processing
     * Fax send
     *
     * @param DblWblVO[] dblWblVOs
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendDblWblByFax(DblWblVO[] dblWblVOs, SignOnUserAccount account) throws EventException {
        List<BkgNtcHisVO> bkgNtcHisVOs = null;
        ArrayList<String> arrTmplMrd = null;
        ArrayList<String> arrTmplParam = null;
        SimpleDateFormat format = null;
        String rcvInfo = null;
        FaxSendVO faxInfo = null;
        String retFaxSndId = null;
        StringTokenizer strNBkgNo = null;
        BkgNtcHisVO bkgNtcHisVO = null;
        String groupOfcCd="";
        String bkg_no="";
        try {
            bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            format = new SimpleDateFormat("yyyyMMddHHmmss");
            for (DblWblVO vo : dblWblVOs) {
                arrTmplMrd = new ArrayList<String>();
                arrTmplParam = new ArrayList<String>();
                // // in case of many  *.mrd file send Email
				for (String s : vo.getTmplmrd  ().split("\\|\\$\\$\\|")) { arrTmplMrd  .add(s); }
				for (String s : vo.getTmplparam().split("\\|\\$\\$\\|")) { arrTmplParam.add(s); }
                for (int j=0; j < arrTmplParam.size(); j++) {
                    rcvInfo = account.getUsr_nm() + ";" + vo.getRcvinfo();
                    // Fax info setting
                    faxInfo = new FaxSendVO();
                    faxInfo.setSysCd(vo.getSyscd());
                    faxInfo.setTmplMrd(arrTmplMrd.get(j));
                    faxInfo.setBatchFlg(vo.getBatchflg());
            		if (!StringUtils.isEmpty(vo.getTitle())) {
            			faxInfo.setTitle(vo.getTitle());
            		} else {
                        StringBuilder titleSb = new StringBuilder("");
            			if ("BL".equalsIgnoreCase(vo.getNtcKndCd())) {
            				titleSb.append("Draft BL("+"BL#: "+vo.getBlNo()+")");
            			} else if ("WB".equalsIgnoreCase(vo.getNtcKndCd())) {
                			titleSb.append("Sea Waybill("+"BL#: "+vo.getBlNo()+")");
                		} else if ("NN".equalsIgnoreCase(vo.getNtcKndCd())) {
                   			titleSb.append("BL Copy("+"BL#: "+vo.getBlNo()+")");
                		} else if("CW".equalsIgnoreCase(vo.getNtcKndCd())) {
                			titleSb.append("Copy Sea Waybill("+"BL#: "+vo.getBlNo()+")");
                		}
            			faxInfo.setTitle(titleSb.toString());
            		}
                    faxInfo.setTmplParam(arrTmplParam.get(j)); // Parameter to R.D 
                    faxInfo.setRcvInfo(rcvInfo);// fax_no, separator ','
                    

                    groupOfcCd = groupOfcCd.equals("") ? account.getOfc_cd():groupOfcCd;
     				
                    faxInfo.setOffice(groupOfcCd);
                    faxInfo.setCrtUserId(account.getUsr_id());
                    // Fax send
                    retFaxSndId = bleaiDao.sendFax(faxInfo);
                    // separator is "|" in case of many BKG_NO in one BL 
                    // input History each bkg_no
                    strNBkgNo = new StringTokenizer(vo.getBkgNo(), "|");
                    while (strNBkgNo.hasMoreTokens()) {
                    	bkg_no = strNBkgNo.nextToken();
                    	
                        bkgNtcHisVO = new BkgNtcHisVO();
                        bkgNtcHisVO.setBkgNo(bkg_no);
                        bkgNtcHisVO.setNtcViaCd("F"); //F:Fax,M:Email
                        bkgNtcHisVO.setNtcKndCd(!"".equalsIgnoreCase(vo.getNtcKndCd())?vo.getNtcKndCd():"BL"); // BL : Draft B/L -- First, using BL, change it later
                        bkgNtcHisVO.setAgnCd("");
                        bkgNtcHisVO.setNtcFomCd("");
                        bkgNtcHisVO.setNtcSeq("");
                        bkgNtcHisVO.setCustCntcTpCd("");
                        bkgNtcHisVO.setNtcFaxNo(vo.getRcvinfo());
                        bkgNtcHisVO.setSndId(retFaxSndId);

                        groupOfcCd = groupOfcCd.equals("") ? account.getOfc_cd():groupOfcCd;
         				
                        
                        bkgNtcHisVO.setSndOfcCd(groupOfcCd);
                        
                        bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
                        bkgNtcHisVO.setSndUsrId(account.getUsr_id());
                        bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
                        bkgNtcHisVO.setDiffRmk("");
                        bkgNtcHisVO.setCreUsrId(account.getUsr_id());
                        bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
                        bkgNtcHisVO.setFrtHdnFlg(vo.getHiddOpt());
                        bkgNtcHisVO.setFrtAllFlg(vo.getFrtAllFlg());
                        bkgNtcHisVO.setFrtCltFlg(vo.getFrtCltFlg());
                        bkgNtcHisVO.setFrtPpdFlg(vo.getFrtPpdFlg());
                        bkgNtcHisVO.setFrtChgFlg(vo.getFrtChgFlg());
                        bkgNtcHisVO.setFrtArrFlg(vo.getFrtArrFlg());
                    	bkgNtcHisVOs.add(bkgNtcHisVO);
                    }
                }
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }

    /**
     * B/L issue send - Draft B/L auto send
     * 
     * @author Jeon Sung-Jin
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @return List<DblEdiVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> createDraftBlEdiAuto(String bkgNo, SignOnUserAccount account) throws EventException {
    	DblEdiVO dblEdiVO = null;
    	DblEdiInVO dblEdiInVO = null;
    	BookingUtil utilCmd = new BookingUtil();
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;  
		GeneralBookingReceiptBC rcpCmd = new GeneralBookingReceiptBCImpl();
    	
    	BkgBlNoVO bkgBlNoIn = new BkgBlNoVO();
        bkgBlNoIn.setBkgNo(bkgNo);
		bkgBlNoIn.setCaUsrId(account.getUsr_id());		
    	
		try {

	    	BkgBlNoVO bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIn);
	    	
	        if(bkgBlNoOut == null) {
	            throw new EventException(new ErrorHandler("BKG01049", bkgNo).getMessage());
	        }
	        
     	
	        List<CustTpIdVO> custTpIdVos = utilCmd.searchEdiCustTpId(bkgBlNoOut, "D", "Y");
	        bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
	        
	        for(int i=0 ; i < custTpIdVos.size() ; i++) {
	        	dblEdiInVO = new DblEdiInVO();
	        	dblEdiInVO.setBkgNo(bkgNo);
	        	dblEdiInVO.setEdiReceiveId(custTpIdVos.get(i).getRcvId());
	        	dblEdiInVO.setGroupEdiId(custTpIdVos.get(i).getGroupId());
	        	dblEdiInVO.setGroupEdiCust(custTpIdVos.get(i).getRefCode());
	        	dblEdiInVO.setAutoManualFlg("Y");
	        	
	        	log.debug("\n #####################################################");
	            log.debug("\n EdiReceiveId: " + custTpIdVos.get(i).getRcvId());
	            log.debug("\n #####################################################");
	            
	        	// in case of Receive ID exist
	        	if(custTpIdVos.get(i).getRcvId() != null || custTpIdVos.get(i).getRcvId() != "") {
		        	dblEdiVO = createDraftBlEdi(dblEdiInVO, account);		        	
		        	
		        	//create History in case of sending success 
		        	if(dblEdiVO != null){
		        		String rcvId = custTpIdVos.get(i).getRcvId();
						BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
						bkgNtcHisVO.setBkgNo(bkgNo);
						bkgNtcHisVO.setNtcViaCd("E");
						bkgNtcHisVO.setNtcKndCd("BL");
						bkgNtcHisVO.setEdiId(rcvId);
						bkgNtcHisVO.setEsvcGrpCd(custTpIdVos.get(i).getGroupId());
						bkgNtcHisVO.setBkgNtcSndRsltCd(dblEdiVO.getFlatFileAckVOs().get(0).getAckStsCd());
						bkgNtcHisVO.setSndUsrId("SYSTEM");
						bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
						bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
						bkgNtcHisVO.setCreUsrId(account.getUsr_id());
						bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
						bkgNtcHisVO.setDiffRmk(dblEdiVO.getDblEdiRefNo());
						bkgNtcHisVOs.add(bkgNtcHisVO);
						if (Constants.SAMF_LIST.contains(rcvId)) {
							BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
							bkgReferenceVO.setBkgNo(bkgNo);
							bkgReferenceVO.setBkgRefTpCd("SAMF");						
							bkgReferenceVO.setCustRefNoCtnt(dblEdiVO.getDblEdiSamf());
							
							BkgReferenceVO[] bkgReferenceVOs = new BkgReferenceVO[1];
							bkgReferenceVOs[0] = bkgReferenceVO;

							rcpCmd.manageRefNo(bkgReferenceVOs, account, bkgBlNoOut);
						}
		        	}
	        	}        
	        }
		} catch (EventException ex) {
			throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        
    	return bkgNtcHisVOs;
    }
    /**
     * B/L issue send - Draft B/L send
     * 
     * @author Park Jun-Yong
     * @param DblEdiInVO dblEdiInVO
     * @param SignOnUserAccount account
     * @return DblEdiVO
     * @exception EventException
     */
    public DblEdiVO createDraftBlEdi(DblEdiInVO dblEdiInVO, SignOnUserAccount account) throws EventException {

        BookingUtil utilCmd = new BookingUtil();

        DblEdiVO dblEdiOutVO = new DblEdiVO();
        String ediRefNo 		= "";
        try {

            BkgBlNoVO bkgBlNoIn = new BkgBlNoVO();
            String bkgNo = dblEdiInVO.getBkgNo();
            bkgBlNoIn.setBkgNo(dblEdiInVO.getBkgNo());
            bkgBlNoIn.setBlNo(dblEdiInVO.getBlNo());
    		bkgBlNoIn.setCaUsrId(account.getUsr_id());

            log.debug("#####################################################");
            log.debug("validation Start");
            log.debug("#####################################################");

            String ec_edircv_id_old = null;
            // EDI RECEIVER ID
//            String[] ec_edircv_id_arr = null; 
            String ec_edircv_id_5 = "";
            String ec_edircv_id_6 = "";
            String ec_edircv_id_8 = "";
            
            String strFuncCode = null;
            
            ec_edircv_id_old = (dblEdiInVO.getEdiReceiveId() == null) ? "" : dblEdiInVO.getEdiReceiveId();
            
            log.debug("#####################################################");
            log.debug("ec_edircv_id_old : " + ec_edircv_id_old);
            log.debug("#####################################################");
            
            BkgBlNoVO bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIn);
            if(bkgBlNoOut == null) {
                throw new EventException(new ErrorHandler("BKG01049", bkgNo).getMessage());
            }
	            
            if(!"KLNETTCS".equals(ec_edircv_id_old))
        	{        	
	            // Canceled booking is not send 310
	            if("X".equals(bkgBlNoOut.getBkgStsCd())) {
	            	//user error ignore in case of send to Auto 
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
	                    throw new EventException(new ErrorHandler("BKG06097").getMessage());
	            	} else {
	            		return null;
	            	}
	            }
	            // check B/L No exist or not 
	            if(bkgBlNoOut.getBlNo() == null || bkgBlNoOut.getBlNo().equals("")) {
	            	//user error ignore in case of send to Auto 
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
	                    throw new EventException(new ErrorHandler("BKG01049", new String[]{bkgNo}).getMessage());
	            	} else {
	            		return null;
	            	}	                
	            }
	            // Name of Consignee omission or not 
	            String strCneeChk = dbDao.searchDblEdiCneeNm(dblEdiInVO);
	            if(strCneeChk == null || strCneeChk.equals("")) {
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
		                throw new EventException(new ErrorHandler("BKG00701", new String[]{"Consignee Name"}).getMessage());
	            	} else {
	            		return null;
	            	}
	            }
	            // TTL Package and Description omission or not 
	            String strTTLChk = dbDao.searchDblEdiTtlPkgDesc(dblEdiInVO);
	            if(!"Y".equals(strTTLChk)) {
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
						throw new EventException(new ErrorHandler("BKG00701",new String[] { "Total Package and Description of Goods" }).getMessage());
					} else {
						return null;
					}
	            }
	            // CNTR No exist or not
	            String strCntrNo = dbDao.searchDblEdiCntrNo(dblEdiInVO);
	            if(strCntrNo == null || strCntrNo.equals("")) {
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
	            		throw new EventException(new ErrorHandler("BKG00701", new String[]{"Container No."}).getMessage());
					} else {
						return null;
					}
	            }
	
	            
	            dblEdiInVO.setBlNo(bkgBlNoOut.getBlNo());
	            dblEdiInVO.setEdiReceiveIdOld(ec_edircv_id_old);
	            log.debug("########## validation EDI_REVEIVE_ID : " + ec_edircv_id_old);
	
	            // EDI RECEIVER ID exist or not 
	            if(ec_edircv_id_old == null || ec_edircv_id_old.equals("")) {
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
	            		throw new EventException(new ErrorHandler("BKG00701", new String[]{"EDI Receiver ID"}).getMessage());
					} else {
						return null;
					}	                
	            }
        	}
            
            if(ec_edircv_id_old.length() == 5){
                ec_edircv_id_5 = ec_edircv_id_old.substring(0, 5);
            }else if(ec_edircv_id_old.length() == 6){
                ec_edircv_id_5 = ec_edircv_id_old.substring(0, 5);
                ec_edircv_id_6 = ec_edircv_id_old.substring(0, 6);
            }else if(ec_edircv_id_old.length() == 7){
                ec_edircv_id_5 = ec_edircv_id_old.substring(0, 5);
                ec_edircv_id_6 = ec_edircv_id_old.substring(0, 6);
            }else if(ec_edircv_id_old.length() >= 8){
                ec_edircv_id_5 = ec_edircv_id_old.substring(0, 5);
                ec_edircv_id_6 = ec_edircv_id_old.substring(0, 6);
                ec_edircv_id_8 = ec_edircv_id_old.substring(0, 8);                    
            }
            
            if("LEHXML".equals(ec_edircv_id_6)) {
                /* 
                 * BL send possible after BL Release when B/L issue in case of LEHXML(Lehnkering) 
                 * B/L Release after : BKG_BL_ISS.OBL_ISS_KNT > 0 -> issue
                 * BL Type Check - W : Waybill, Null : B/L
                 */
                //String strBlTp = dbDao.searchDblEdiBlTp(dblEdiInVO);
                String strIssCnt = dbDao.searchDblEdiIssCnt(dblEdiInVO);
                int issCnt = (strIssCnt==null || strIssCnt.equals("")) ? 0 : Integer.parseInt(strIssCnt);
                if(!"W".equals(bkgBlNoOut.getBlTpCd())) {
                    if(issCnt < 1) {
                    	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
                    		throw new EventException(new ErrorHandler("BKG00701", new String[]{"B/L Release"}).getMessage());
                    	} else {
                    		return null;	
                    	}
                    }
                }
            } 
            
			if (Constants.SAMF_LIST.contains(ec_edircv_id_6) || Constants.SAMF_LIST.contains(ec_edircv_id_5)) {
                String strPkgWord = JSPUtil.getNull(dbDao.searchDblEdiPkgWord(dblEdiInVO));
                if(strPkgWord == null || strPkgWord.equals("")) {
                	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
                		throw new EventException(new ErrorHandler("BKG00701", new String[]{"Package Word"}).getMessage());
                	} else {
                		return null;	
                	}
                }
            } 
            
//            if("LGELA010".equals(ec_edircv_id_8) || 
//               "PKEXM010".equals(ec_edircv_id_8) || 
//               "PKHKCNA01".equals(ec_edircv_id_8) || 
//               "PKCNCNA01".equals(ec_edircv_id_8)) {
//                /*
//                 * in case of LG(LGELA010), Bumhan(PKEXM010), bkg_ref_no  Check : SI_REF_NO not exist  -> sending impossibility
//                 */
//                String strRefNo = dbDao.searchDblEdiRefNo(dblEdiInVO);
//                if(strRefNo == null || strRefNo.equals("")) {
//                	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
//                		throw new EventException(new ErrorHandler("BKG00701", new String[]{"SI Reference No."}).getMessage());
//	            	} else {
//	            		return null;	
//	            	}
//                }
//            }
            
//            log.debug("#####################################################");
//            log.debug("validation End");
//            log.debug("#####################################################");

            String strSamf = dbDao.searchDblEdiSamf(dblEdiInVO);
            log.debug("\n******************** samf ********************\n" + strSamf);
            
//            int rcvCnt = (ec_edircv_id_arr == null) ? 0 : ec_edircv_id_arr.length;
//            log.debug("########## EC_EDIRCV_ID_ARR.LENGTH : " + rcvCnt);

            log.debug("#####################################################");
            log.debug(" Flat File start ");
            log.debug("#####################################################");
            StringBuffer sbuff = null;
            List<FlatFileAckVO> flatFileAckVOs = new ArrayList<FlatFileAckVO>();
//            for(int l = 0; l < rcvCnt; l++) {
            	
            	sbuff = new StringBuffer();
//                log.debug("\n******************** edi_rcv_id ********************\n" + ec_edircv_id_arr[l]);
                dblEdiInVO.setEdiReceiveId(ec_edircv_id_old);

                // func_code : first trans (9)
                if("9".equals(dblEdiInVO.getFuncCode())) {
                	strFuncCode = "9";
                } else {
                	strFuncCode = dbDao.searchDblEdiFncCode(dblEdiInVO);
                }
                
                //edi_group_id
                if(dblEdiInVO.getGroupNm()==null || dblEdiInVO.getGroupEdiId()==null){
                    String[] edi_grp_cd = dbDao.searchDblEdiGrpId(dblEdiInVO);
                    dblEdiInVO.setGroupEdiCust(edi_grp_cd[0]);
                    dblEdiInVO.setGroupEdiId(edi_grp_cd[1]);
                    dblEdiInVO.setGroupNm(edi_grp_cd[2]);
                }
                String strEdiGroupCust = dblEdiInVO.getGroupEdiCust();	
                String strEdiGroupId = dblEdiInVO.getGroupEdiId();
                
                log.debug("\n******************** edi_group_cust ********************\n" + strEdiGroupCust);
                log.debug("\n******************** edi_group_id ********************\n" + strEdiGroupId);

                // B/L Type Code
                String strBlTp = dbDao.searchDblEdiBlTp(dblEdiInVO);
                log.debug("\n******************** bl_type ********************\n" + strBlTp);

                // Final ETA
                String strFnalEta = null;
                String strFnalAta = null;
                
                strFnalEta = dbDao.searchFinalEta12(dblEdiInVO);
                strFnalAta = dbDao.searchFinalAta15(dblEdiInVO);
                
                log.debug("\n******************** final_eta ********************\n" + strFnalEta);

                // Sender Id
                String strSndrId = null;
                if("KLNETTCS".equals(ec_edircv_id_old)) {
                    strSndrId = dbDao.searchEdiSndrByKlnettcs(dblEdiInVO);
                } else {
                    dblEdiInVO.setTmpCnt("1");
                    strSndrId = dbDao.searchEdiSndr1(dblEdiInVO);
                    if(strSndrId == null) strSndrId = dbDao.searchEdiSndr2(dblEdiInVO);
                }
                if(strSndrId == null ) strSndrId = "OPUSBKG";
                log.debug("\n******************** sender_id ********************\n" + strSndrId);
                // TODO
                String strEdiHostId = utilCmd.searchEdi301HostId(ec_edircv_id_old, strBlTp);
                log.debug("\n******************** edi_host_id ********************\n" + strEdiHostId);
                // TODO
                String strEdiHeader = utilCmd.searchEdiHeader(strSndrId, ec_edircv_id_old, "310");
                log.debug("\n******************** edi_header ********************\n" + strEdiHeader);
                sbuff.append(strEdiHeader + "\n");
                ediRefNo = strEdiHeader.substring(62);
                String strIbNo = dbDao.searchDblEdiIbNo(dblEdiInVO);
                log.debug("\n******************** ib_no ********************\n" + strIbNo);

                dblEdiInVO.setIbNo(strIbNo);
                String strMaxIbSeq = dbDao.searchDblEdiMaxIbSeq(dblEdiInVO);
                log.debug("\n******************** max_ib_seq ********************\n" + strMaxIbSeq);
                
                // Edi Main
                // 占쎈립�뤃占쏙쭪占쏙옙肉� 嚥≪뮇彛� 占쎌젫椰꾬옙 
                String strEdiMain1 = null;
//                if("KLNETTCS".equals(ec_edircv_id_old)) {
//                    DblEdiInfoVO ediInfoVO = dbDao.searchDblEdiInfo1(dblEdiInVO);
//                    if("KRPUS".equals(ediInfoVO.getPreRlyPortCd()) || "KRPUS".equals(ediInfoVO.getPstRlyPortCd())) {
//                        ediInfoVO = dbDao.searchDblEdiInfo2(ediInfoVO);
//                    }
//                    dblEdiInVO.setPreRlyPortCd(ediInfoVO.getPreRlyPortCd());
//                    dblEdiInVO.setPstRlyPortCd(ediInfoVO.getPstRlyPortCd());
//                    strEdiMain1 = dbDao.searchDblEdiMain11(dblEdiInVO);
//                } else {
//                    strEdiMain1 = dbDao.searchDblEdiMain12(dblEdiInVO);
//                }
                strEdiMain1 = dbDao.searchDblEdiMain12(dblEdiInVO);
                log.debug("\n******************** edi_main 1 ********************\n" + strEdiMain1);
                sbuff.append(strEdiMain1);
                
                String strGmt = dbDao.searchDblEdiGmt(dblEdiInVO);
                log.debug("\n******************** gmt ********************\n" + strGmt);
                sbuff.append(strGmt);
                
                dblEdiInVO.setFinalEta(strFnalEta);
                dblEdiInVO.setFinalAta(strFnalAta);
                dblEdiInVO.setFuncCode(strFuncCode);
                String strEdiMain2 = dbDao.searchDblEdiMain2(dblEdiInVO);
                log.debug("\n******************** edi_main 2 ********************\n" + strEdiMain2);
                sbuff.append(strEdiMain2);
                
                String strMsIbcs = dbDao.searchDblEdiMsIbcs(dblEdiInVO);
                log.debug("\n******************** ms_ibcs ********************\n" + strMsIbcs);
                sbuff.append(strMsIbcs);
                
                dblEdiInVO.setIbSeq(strMaxIbSeq);
                String strCustIbcs = dbDao.searchDblEdiCustIbcs(dblEdiInVO);
                log.debug("\n******************** cust_ibcs ********************\n" + strCustIbcs);
                sbuff.append(strCustIbcs);
                
                String strIbShRef= dbDao.searchDblEdiIbShRef(dblEdiInVO);
                log.debug("\n******************** ib_sh_ref ********************\n" + strIbShRef);
                sbuff.append(strIbShRef);
                
                String strSendCnt = dbDao.searchDblEdiSendCnt(dblEdiInVO);
                log.debug("\n******************** send_cnt ********************\n" + strSendCnt);
                sbuff.append(strSendCnt);
                
                //ec_edircv_id=FSELC,PKEXM010] IF
                if("FSELC".equals(ec_edircv_id_old) || "PKEXM010".equals(ec_edircv_id_old)){
                    String strMrnNo = dbDao.searchDblEdiMrnNo(dblEdiInVO);
                    log.debug("\n******************** mrn_no ********************\n" + strMrnNo);
                    sbuff.append(strMrnNo);
                    
                    String strPolAtd = dbDao.searchDblEdiPolAtd(dblEdiInVO);
                    log.debug("\n******************** pol_atd ********************\n" + strPolAtd);
                    sbuff.append(strPolAtd);
                    
                    String strPodAta = dbDao.searchDblEdiPodAta(dblEdiInVO);
                    log.debug("\n******************** pod_ata ********************\n" + strPodAta);
                    sbuff.append(strPodAta);
                }else{
                    sbuff.append("MRN_NO:\n"
                            + "POL_ATD:\n"
                            + "POD_ATA:\n");
                }                
                
                if(strEdiGroupId == null) strEdiGroupId = " ";
                if(strEdiGroupCust == null) strEdiGroupCust = " ";
                
                String strGroupId = "GROUP_ID:" + strEdiGroupId + "/" + strEdiGroupCust+ "\n";
                log.debug("\n******************** group_id ********************\n" + strGroupId);
                sbuff.append(strGroupId);
                
                String strCustRef = dbDao.searchDblEdiCustRef(dblEdiInVO, strBlTp);
                log.debug("\n******************** cust_ref ********************\n" + strCustRef);
                sbuff.append(strCustRef);
                
                String strIcust = dbDao.searchDblEdiIcust(dblEdiInVO);
                log.debug("\n******************** icust ********************\n" + strIcust);
                sbuff.append(strIcust);
                
                String strBkgInfo = dbDao.searchDblEdiBkgInfo(dblEdiInVO);
                log.debug("\n******************** bkg_info ********************\n" + strBkgInfo);
                sbuff.append(strBkgInfo);
                
                //CHARGE info retrieve
                String strEdiChg = null;
                if("TRAX.HPAPAC".equals(ec_edircv_id_old) || "TRAX.HPAPACPROD".equals(ec_edircv_id_old)) {
                    String[] ediChgByTrax = dbDao.searchDblEdiChgByTrax(dblEdiInVO);
                    if("SINBB".equals(ediChgByTrax[0])){
                        strEdiChg = dbDao.searchDblEdiChgBySwaTrax(dblEdiInVO);
                    }else if("SHAAS".equals(ediChgByTrax[0]) || "SHAHQ".equals(ediChgByTrax[0])){
                        strEdiChg = dbDao.searchDblEdiChgByChnTrax(dblEdiInVO);
                    }else if("SHAAS".equals(ediChgByTrax[1]) || "SHAHQ".equals(ediChgByTrax[1])){
                        strEdiChg = dbDao.searchDblEdiChgByChnTrax(dblEdiInVO);
                    }else if("SINBB".equals(ediChgByTrax[1]) || "SINBB".equals(ediChgByTrax[2])){
                        strEdiChg = dbDao.searchDblEdiChgBySwaTrax(dblEdiInVO);
                    }else{
                        strEdiChg = "{CHARGE\n"
                                  + "FCTYPE:\n"
                                  + "RATE:\n"
                                  + "RATED_AS:\n"
                                  + "REVENUETON:\n"
                                  + "DIF_AMT:\n"
                                  + "CURRENCYCODE:\n"
                                  + "TARIFF:\n"
                                  + "PERTYPE:\n"
                                  + "EXRATE:\n"
                                  + "FRT_IND:\n"
                                  + "}CHARGE\n";
                    }
//                    if("TRAX.HPAPAC".equals(ec_edircv_id_old) || "TRAX.HPAPACPROD".equals(ec_edircv_id_old)) {
                }else if("00039146".equals(ec_edircv_id_old)){
                	strEdiChg = dbDao.searchDblEdiChgExch(dblEdiInVO);
                }else{
                    strEdiChg = dbDao.searchDblEdiChg(dblEdiInVO);
                }
                log.debug("\n******************** edi_chg ********************\n" + strEdiChg);
                sbuff.append(strEdiChg);
                
                //CHARGE Detail retrieve
                String strEdiChgDtl = null;
                if("HTLXML".equals(ec_edircv_id_old) || "HTLXML_IMG".equals(ec_edircv_id_old)) {
                    strEdiChgDtl = dbDao.searchDblEdiChgDtl1(dblEdiInVO);
                }else if("TRAX.HPAPAC".equals(ec_edircv_id_old) || "TRAX.HPAPACPROD".equals(ec_edircv_id_old)) {
                    strEdiChgDtl = dbDao.searchDblEdiChgDtl2(dblEdiInVO);
                }else{
                    strEdiChgDtl = dbDao.searchDblEdiChgDtl3(dblEdiInVO);
                }
                log.debug("\n******************** edi_chg_dtl ********************\n" + strEdiChgDtl);
                sbuff.append(strEdiChgDtl);
                
                String[] mk_desc_arr = dbDao.searchDblEdiMkDesc(dblEdiInVO);
                String strCmdtDesc = mk_desc_arr[0];
                String strMkDesc = mk_desc_arr[1];
                log.debug("\n******************** descriptions ********************\n" + strCmdtDesc);
                log.debug("\n******************** marks ********************\n" + strMkDesc);
                sbuff.append("{DESC\n");
                sbuff.append(strCmdtDesc);
                sbuff.append("}DESC\n");
                sbuff.append("{MARK\n");
                sbuff.append(strMkDesc);
                sbuff.append("}MARK\n");
                
                String tmpBlClause = "{BL_CLAUSE\n"
                        + "BL_CLAUSE:\n"
                        + "}BL_CLAUSE\n";
                
                List<DblEdiBlClauseVO> blClauseList = dbDao.searchDblEdiBlClause(dblEdiInVO);
                int blClauseCnt = blClauseList == null ? 0 : blClauseList.size();
                if(blClauseCnt > 0 ){
                	sbuff.append("{BL_CLAUSE\n");
                	for(int j=0; j< blClauseCnt; j++){
                		sbuff.append(blClauseList.get(j).getBlClause()+"\n");
                	}
                	sbuff.append("}BL_CLAUSE\n");
                }else{
                	sbuff.append(tmpBlClause);
                }
                
//              String strCmdtInfo = dbDao.searchDblEdiCmdtInfo(dblEdiInVO);
//              log.debug("\n******************** strCmdtInfo ********************\n" + strCmdtInfo);
//              sbuff.append(strCmdtInfo);
              
//              sbuff.append("{CMDT_INFO\n");
//              sbuff.append(strCmdtInfo);
//              sbuff.append("}CMDT_INFO\n");
                
                String tmpCmdtDesc = "{CMDT_INFO\n"
                        + "CMDT_SEQ:\n"
                        + "CMDT_PKG_QTY:\n"
                        + "CMDT_PKG_CD:\n"
                        + "CMDT_PKG_CD_DESC:\n"
                        + "CMDT_WGT_QTY:\n"
                        + "CMDT_WGT_UNIT:\n"
                        + "CMDT_NET_WGT_QTY:\n"
                        + "CMDT_NET_WGT_UNIT:\n"
                        + "CMDT_MEA_QTY:\n"
                        + "CMDT_MEA_UNIT:\n"
                        + "CMDT_HTS_CD:\n"
                        + "CMDT_HS_CD:\n"
                        + "CMDT_NCM_CD:\n"
                        + "CMDT_DESC:\n"
                        + "CMDT_MARKNO:\n"
                        + "{CMDT_CNTRNBR\n"
                        + "CMDT_CNTRNBR:\n"
                        + "}CMDT_CNTRNBR\n"
                        + "}CMDT_INFO\n";
                
                List<DblEdiCmdtCntrVO> cmdtList = dbDao.searchDblEdiCmdt(dblEdiInVO);
                int cmdtCnt = cmdtList == null ? 0 : cmdtList.size();
                if(cmdtCnt > 0 ){
                	for(int j=0; j<cmdtCnt;j++){
                		DblEdiCmdtCntrVO dblEdiCmdtCntrVO = cmdtList.get(j);
                		
                		String strCmdtHdr = dbDao.searchDblEdiCmdtHdr(dblEdiCmdtCntrVO);
                		sbuff.append(strCmdtHdr);
                		String strCmdtDtl = dbDao.searchDblEdiCmdtDtl(dblEdiCmdtCntrVO);
                		sbuff.append(strCmdtDtl);
                		sbuff.append("}CMDT_INFO\n");
                	}
//                	sbuff.append("}CMDT_INFO\n");
                }else{
                	sbuff.append(tmpCmdtDesc);
                }
//                
                String tmpCntrDesc = "{CNTR_INFO:\n"
                                   + "CNTRNBR:\n"
                                   + "PUNIT:\n"
                                   + "PKG:\n"
                                   + "CNTRWGT:\n"
                                   + "CNTR_WGT_UNIT:\n"
                                   + "CNTRTYPE:\n"
                                   + "SEALNBR:\n"
                                   + "SEALNBR2:\n"
                                   + "SEALNBR3:\n"
                                   + "FM_IND:\n"
                                   + "RF_IND:\n"
                                   + "DG_IND:\n"
                                   + "AK_IND:\n"
                                   + "BK_IND:\n"
                                   + "SOC_IND:\n"
                                   + "TEMP:\n"
                                   + "TUNIT:\n"
                                   + "VENT:\n"
                                   + "HUMID:\n"
                                   + "MEASURE:\n"
                                   + "MEASURE_UNIT:\n"
                                   + "CN_RDTYPE:\n"
                                   + "CMDT_DESC:\n"
                                   + "CMDTCD:\n"
                                   + "RF_REMARK:\n"
                                   + "RFDRY_IND:\n"
                                   + "OVF:\n"
                                   + "OVR:\n"
                                   + "OVH:\n"
                                   + "OVLW:\n"
                                   + "OVRW:\n"
                                   + "OVWGT:\n"
                                   + "OVWGT_UNIT:\n"
                                   + "VOID_SLOT:\n"
                                   + "STWG_REQ:\n"
                                   + "PARTIAL:\n"
                                   + "EXCEPT:\n"
                                   + "SHIP_UNNO:\n";
                
                List<DblEdiCntrVO> cntrList = dbDao.searchDblEdiCntr(dblEdiInVO);
                int cntrCnt = cntrList == null ? 0 : cntrList.size();
                if(cntrCnt > 0){
                    for(int m=0;m<cntrCnt;m++){
                        DblEdiCntrVO ediCntrVO = cntrList.get(m);

                        log.debug("\n******************** cntr ********************\n" + ediCntrVO.getBkgCntr());
                        sbuff.append((ediCntrVO.getBkgCntr()==null || ediCntrVO.getBkgCntr().equals(""))?tmpCntrDesc:ediCntrVO.getBkgCntr());
                        
                        String strCntrDg = dbDao.searchDblEdiCntrDg(dblEdiInVO, ediCntrVO.getCntrNo());
                        log.debug("\n******************** cntr_dg ********************\n" + strCntrDg);
                        sbuff.append(strCntrDg);
                        
                        String strCntrMf = dbDao.searchDblEdiCntrMf(dblEdiInVO, ediCntrVO.getCntrNo());
                        log.debug("\n******************** cntr_mf ********************\n" + strCntrMf);
                        sbuff.append(strCntrMf);
                        
                        String strCntrPo = dbDao.searchDblEdiCntrPo(dblEdiInVO, ediCntrVO.getCntrNo());
                        log.debug("\n******************** cntr_po ********************\n" + strCntrPo);
                        sbuff.append(strCntrPo);
                        
                        String strCntrSeal = dbDao.searchDblEdiCntrSeal(dblEdiInVO, ediCntrVO.getCntrNo());
                        log.debug("\n******************** cntr_seal ********************\n" + strCntrSeal);
                        sbuff.append(strCntrSeal);
                        
                        sbuff.append("}CNTR_INFO\n");

                    }
                }else{
                    sbuff.append(tmpCntrDesc);
                    sbuff.append("{CNTR_DANGER\n"
                            + "UNNBR:\n"
                            + "CLASS:\n"
                            + "DG_DESC:\n"
                            + "PHONE:\n"
                            + "PAGE:\n"
                            + "FLSH_TEMP:\n"
                            + "FLSH_UNIT:\n"
                            + "DG_REMARK:\n"
                            + "EMSNO:\n"
                            + "PSACLS:\n"
                            + "PKGGRP:\n"
                            + "MFAG1:\n"
                            + "MFAG2:\n"
                            + "MAR_POLL:\n"
                            + "LABEL_CD:\n"
                            + "LABEL_DESC:\n"
                            + "DG_PKG:\n"
                            + "DG_PKGUNIT:\n"
                            + "NWGT:\n"
                            + "NWGT_UNIT:\n"
                            + "GWGT:\n"
                            + "GWGT_UNIT:\n"
                            + "MEA:\n"
                            + "MEA_UNIT:\n"
                            + "HAZ_CONT:\n"
                            + "STWG:\n"
                            + "PACK_GP:\n"
                            + "}CNTR_DANGER\n"
                            + "{CNTR_DESC\n"
                            + "D_CMDT:\n"
                            + "D_PUNIT:\n"
                            + "D_PKG:\n"
                            + "D_WGT:\n"
                            + "D_MEAS:\n"
                            + "D_DESC:\n"
                            + "{CUS_MARK\n"
                            + "D_MARK:\n"
                            + "}CUS_MARK\n"
                            + "}CNTR_DESC\n"
                            + "{MULTI_PO_NO\n"
                            + "CNTR_PO_NO:\n"
                            + "}MULTI_PO_NO\n"
                            + "{MULTI_SEAL_NO\n"
                            + "CNTR_SEAL_NO:\n"
                            + "}MULTI_SEAL_NO\n"
                            + "}CNTR_INFO\n");
                }
                
                //searchDblEdiQty 
                String strQty = dbDao.searchDblEdiQty(dblEdiInVO);
                log.debug("\n******************** qty ********************\n" + strQty);
                sbuff.append(strQty);
                
                //searchDblEdiVvd
                String strVvd = dbDao.searchDblEdiVvd(dblEdiInVO);
                log.debug("\n******************** vvd ********************\n" + strVvd);
                sbuff.append(strVvd);

                //[ec_edircv_id=SECXML,FSELC OR ec_edircv_id_old=C1T0W,C1T0S,C1T0M,110AL] BLIssuanceDBDAO::searchDblEdiMisc ( dblEdiInVO )
                String strMisc = dbDao.searchDblEdiMisc(dblEdiInVO, strSamf);
                log.debug("\n******************** misc ********************\n" + strMisc);
                sbuff.append(strMisc);
                
                // HP SHIP ID, PART NO
                String strHpSwa = dbDao.searchDblEdiHpSwa(dblEdiInVO);
                log.debug("\n******************** hp_swa ********************\n" + strHpSwa);
                sbuff.append(strHpSwa);
                
                /* CHG_APPL_DT */
                String strChgInfo = dbDao.searchDblEdiChgInfo(dblEdiInVO);
                log.debug("\n******************** chg_info ********************\n" + strChgInfo);
                sbuff.append(strChgInfo);
                
                //[ec_edircv_id="3102178910"] BLIssuanceDBDAO::searchDblEdiNtc ( dblEdiInVO )
                if ("3102178910".equals(ec_edircv_id_old)){
                    String strNtc = dbDao.searchDblEdiNtc(dblEdiInVO);
                    log.debug("\n******************** notice ********************\n" + strNtc);
                    sbuff.append(strNtc);
                }else{
                    sbuff.append("{BKG_NOTICE\n"
                            + "PU_CY:\n"
                            + "PU_CYNAME:\n"
                            + "PU_CYADDR1:\n"
                            + "PU_CYADDR2:\n"
                            + "PU_CYADDR3:\n"
                            + "PU_CYADDR4:\n"
                            + "PU_CYADDR5:\n"
                            + "PU_CYPOST:\n"
                            + "PU_CYTEL:\n"
                            + "PU_CYFAX:\n"
                            + "}BKG_NOTICE\n");
                }
                
                String strAmsInfo = dbDao.searchDblEdiAmsInfo(dblEdiInVO);
                log.debug("\n******************** ams_info ********************\n" + strAmsInfo);
                sbuff.append(strAmsInfo); 
                
                String strRefInfo = dbDao.searchDblEdiRefInfo(dblEdiInVO);
                log.debug("\n******************** ref_info ********************\n" + strRefInfo);
                sbuff.append(strRefInfo); 
                
                String strBlClause = dbDao.searchDblEdiBlClauseInfo(dblEdiInVO);
                log.debug("\n******************** ref_info ********************\n" + strBlClause);
                sbuff.append(strBlClause);
                
                log.debug("#####################################################");
                log.debug(" Flat File end ");
                log.debug("#####################################################");
;
                /* EDI sending */
                log.debug("#####################################################");
                log.debug(" EDI sending start ");
                log.debug("#####################################################");
                SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
                sendFlatFileVO.setFlatFile(sbuff.toString());
                sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER_310.IBMMQ.QUEUE"));
                FlatFileAckVO flatFileAckVO = utilCmd.sendFlatFile(sendFlatFileVO);
                log.debug("#####################################################");
                log.debug(" EDI sending end : " + ("A".equals(flatFileAckVO.getAckStsCd()) ? "Success!" : "Fail!"));
                log.debug("#####################################################");  
                flatFileAckVOs.add(flatFileAckVO);
                if ("E".equals(flatFileAckVO.getAckStsCd())){
                      throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
                }
                
            dblEdiOutVO.setDblEdiRefNo(ediRefNo);
            dblEdiOutVO.setDblEdiSamf(strSamf);
            dblEdiOutVO.setFlatFileAckVOs(flatFileAckVOs);

        } catch(EventException ex) {
			throw ex;	
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        
        return dblEdiOutVO;
    }

    /**
     * retrieve event processing
     * error check processing for B/L no or BKG no  ESM_BKG_0418
     *
     * @param String inoutMode
     * @param String vvd
     * @param String port
     * @param String[] bkgBlNos
     * @return String
     * @exception EventException
     */
    public String validBkgBlNo(String inoutMode, String vvd, String port, String[] bkgBlNos) throws EventException {
        StringBuilder sbBkgNos = null;
        int iCnt = 0;
        boolean bResult = true;
        String strResult = "";
        BkgBookingVO bkgBookingVO = null;
        try {
        	sbBkgNos = new StringBuilder();
        	if (null!=bkgBlNos && 0<bkgBlNos.length) {
	            for (int i=0; i<bkgBlNos.length; i++) {
	                bkgBookingVO = dbDao.searchBkgBookingByBkgBlNo(bkgBlNos[i]);
	                if (!"".equals(bkgBookingVO.getBkgNo())) {
	                	sbBkgNos.append(bkgBookingVO.getBkgNo()).append("@");
	                	if ("I".equalsIgnoreCase(inoutMode)) {
	                		sbBkgNos.append(bkgBookingVO.getPolCd());
	                	} else {
	                		sbBkgNos.append(bkgBookingVO.getPodCd());
	                	}
	                	sbBkgNos.append("|");
	                }
	                // in case of B/L no or BKG no  error  - CoBkg.js ===> BKG00273
	                if ("".equals(bkgBookingVO.getBkgNo()) || "".equals(bkgBookingVO.getBlNo()) || "".equals(bkgBookingVO.getBkgStsCd())) {
	                    bResult = false;
	                    iCnt = i;
	                    break;
	                }
	            }
	            if (bResult && 0 < sbBkgNos.length()) {
	            	sbBkgNos.delete(sbBkgNos.length()-1,sbBkgNos.length());
	            	strResult = sbBkgNos.toString();
	            } else {
	            	strResult = "Error_" + iCnt;
	            }
        	}
            return strResult;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * sendCanonEmlBkg
     * 
     * @param CanonEmlVO canonEml
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void sendCanonEmlBkg(CanonEmlVO canonEml, SignOnUserAccount account) throws EventException {
        BkgAutoEmlVO autoEmlVO = null;
        
        String bkgNo  = null;
        String blNo  = null;
        String usrId  = null;
        String usrNm  = null;
        String usrEml = null;
        String ofcCd = null;
        
        try {
            
            log.debug("CanonEmlVO --> AtdDt    : " + canonEml.getAtdDt());
            log.debug("CanonEmlVO --> CoNm     : " + canonEml.getCoNm());
            log.debug("CanonEmlVO --> VslCd    : " + canonEml.getVslCd());
            log.debug("CanonEmlVO --> SkdVoyNo : " + canonEml.getSkdVoyNo());
            log.debug("CanonEmlVO --> SkdDirCd : " + canonEml.getSkdDirCd());
            log.debug("CanonEmlVO --> PolCd    : " + canonEml.getPolCd());
            
            List<CanonEmlBkgVO> canonEmlVOs = dbDao.searchCanonEmlBkg(canonEml);
            int len = canonEmlVOs == null ? 0 : canonEmlVOs.size();
            if(len > 0 ){
                DblWblVO[] dblWblVOs = new DblWblVO[len];
                usrId  = "";
                usrNm  = "";
                usrEml = "";
                ofcCd  = "";

                for(int i = 0; i < len; i++) {
                    bkgNo  = canonEmlVOs.get(i).getBkgNo();
                    blNo   = canonEmlVOs.get(i).getBlNo();
                    usrId  = canonEmlVOs.get(i).getUsrId();
                    usrNm  = canonEmlVOs.get(i).getUsrNm();
                    usrEml = canonEmlVOs.get(i).getUsrEml();
                    ofcCd = canonEmlVOs.get(i).getOfcCd();
                        
                    autoEmlVO = new BkgAutoEmlVO();
                    autoEmlVO.setBkgNo(bkgNo);
                    autoEmlVO.setAtdDt(canonEml.getAtdDt());
                    autoEmlVO.setSndFlg("Y");
                    autoEmlVO.setCreUsrId(usrId);
                    autoEmlVO.setUpdUsrId(usrId);
                    log.debug("BkgNo --> " + bkgNo);
                    log.debug("BlNo  --> " + blNo);
    
                    String rmkXchRt       = dbDao.searchCanonEmlRmkXchRt(autoEmlVO);
                    String rmkMrn         = dbDao.searchCanonEmlRmkMrn(autoEmlVO);
                    String rmkVslCallSign = dbDao.searchCanonEmlRmkVslCallSign(autoEmlVO);
                    String rmkCcn         = dbDao.searchCanonEmlRmkCcn(autoEmlVO);
                    String rmkUsrDflt     = dbDao.searchCanonEmlRmUsrDflt(autoEmlVO);
    
                    String blInfos        = dbDao.searchCanonEmlSubject(autoEmlVO);
                    log.debug("BlNo --> " + blInfos);
                    String[] blInfoArr    = blInfos.split("\\^");
                    log.debug("blInfoArr --> " + blInfoArr.length);
                    
                    String emlAddr        = dbDao.searchCanonEmlUsrEmlAddr(autoEmlVO);
                    String emlSubject     = "BL Draft: I/V NO-"+blInfoArr[2]+" B/L NO-"+blInfoArr[0];
                    String emlContents    = "Dear Customer,\n"
                                          + "\n"
                                          + "Please be informed B/L(s) are ready as per your shipping instruction.\n"
                                          + "\n"
                                          + "- B/L No : " + blInfoArr[0] + "\n"
                                          + "\n"
                                          + "If you find any discrepancy on attached draft B/Ls, please advise us of what needs to be amended. \n"
                                          + "\n"
                                          + "Thank you for choosing us\n"
                                          + "\n"
                                          + "OPUS Co., Ltd\n"
                                          + "\n"
                                          + "For more detailed information on your shipments, go to <a href=\"http://www.clt.com\">http://www.clt.com</a>\n";
                    String mrdRmk         = rmkXchRt + "(##)" + rmkMrn + "(##)" + rmkVslCallSign + "(##)" + rmkCcn + "(##)" + rmkUsrDflt + "(##)";
                    String mrdParam       = "/rv "
                                          + "form_bkgNo[('"+bkgNo+"')] "
                                          + "form_type[2] "
                                          + "form_dataOnly[N] "
                                          + "form_manifest[N] "
                                          + "form_usrId["+usrId+"] "
                                          + "form_hiddeData[N] "
                                          + "form_level[(1)] "
                                          + "form_remark["+mrdRmk+"] "
                                          + "form_Cntr[1] "
                                          + "form_mainOnly[N] "
                                          + "form_CorrNo[] "
                                          + "form_his_cntr[BKG_CONTAINER] "
                                          + "form_his_bkg[BKG_BOOKING] "
                                          + "form_his_mkd[BKG_BL_MK_DESC] "
                                          + "form_his_xpt[BKG_XPT_IMP_LIC] "
                                          + "form_his_bl[BKG_BL_DOC] "
                                          + "/rp "
                                          + "[] "
                                          + "/riprnmargin ";

                    dblWblVOs[i] = new DblWblVO();
                    dblWblVOs[i].setBkgNo(bkgNo);
                    dblWblVOs[i].setBlNo(blNo);
                    dblWblVOs[i].setNtcKndCd("BL");
                    dblWblVOs[i].setSyscd("BKG");
                    dblWblVOs[i].setBatchflg("N");
                    dblWblVOs[i].setTmplmrd("ESM_BKG_0109_DBL.mrd");
                    dblWblVOs[i].setTmplparam(mrdParam);
                    dblWblVOs[i].setTmplmrdpdf(bkgNo + ".pdf");
                    dblWblVOs[i].setItr("|$$|");
                    dblWblVOs[i].setRcveml(emlAddr);
                    dblWblVOs[i].setTitle(emlSubject);
                    //dblWblVOs[i].setContents(emlContents);
                    dblWblVOs[i].setSndeml(usrEml);
                    dblWblVOs[i].setSndnm(usrNm);
                    
                    log.debug("\n---------------------------------------------------" +
                              "\n* To        : " + emlAddr +
                              "\n* Subject   : " + emlSubject +
                              "\n* Contents  : " + emlContents +
                              "\n" +
                              "\n--------------------------------------------------" +
                              "\n" +
                              "\n* MRD Name  : ESM_BKG_0109_DBL.mrd" + 
                              "\n* MRD Param : " + mrdParam +
                              "\n---------------------------------------------------");
                    
                    dbDao.createAutoEml(autoEmlVO);
                }
                
                /* account info not exist in case of EDI
                 */
                account = new SignOnUserAccount(usrId,usrNm,"","","",usrEml,"","","","","","",ofcCd,"","","","","","","","","");
                
                log.debug("#################################### START : sendDblWblByEmail");
                sendDblWblByEmail(dblWblVOs, null, account);
//                List<BkgNtcHisVO> ntcHisVOs = sendDblWblByEmail(dblWblVOs, account);
                log.debug("#################################### END : sendDblWblByEmail");

                //BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
                //histCmd.createBkgNtcHis(ntcHisVOs, "BKG_BAT_010");
            }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * copy BlIssuanceBC responsibility tables for C/A.<br>
     * : 1. bkg_bl_iss copy.
     * : 2. according to copyTypeCd , caNo = 'TMP0000001' in case of 'TEMP' or 'BKG' and caNo is bkgBlNoVO.caNo in case of 'HIST' 
     * @author    Lee NamKyung
     * @param     BkgBlNoVO bkgBlNoVO
     * @param     String copyTypeCd
     * @exception EventException
     */
    public void createIssCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
        try {
            if ("BKG".equals(copyTypeCd)) {
//                dbDao.removeIssCA(bkgBlNoVO, copyTypeCd); 
            	dbDao.modifyIssCa(bkgBlNoVO, copyTypeCd);
            } else {
            	dbDao.createIssCA(bkgBlNoVO, copyTypeCd);
            }
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * Remove responsibility table of booking relation BlIssuanceBC for C/A.
     * 
     * @author      Lee NamKyung
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       String copyTypeCd
     * @exception   EventException
     */
    public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
        try {
            //01. 
            dbDao.removeIssCA(bkgBlNoVO, copyTypeCd);   
            
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
	 * LOCAL ISS detail info modify
	 * 
	 * @param BkgBlIssVO bkgBlIssVO
	 * @exception EventException
	 */
	public void modifyIbDtlBlIss(BkgBlIssVO bkgBlIssVO) throws EventException {

        try {
            dbDao.modifyIbDtlBlIss(bkgBlIssVO);
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), de);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), ex);
        }

    }
	
	/**
	 * Manage OBL_RLSE_FLG relation info of BKG_BL_ISS table .<br>
	 * ESM_BKG_0743	interlock System	
	 * 
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void modifyOBLRlseFlg(BlIssInfoVO blIssInfoVO)  throws EventException {
		
		try {
			dbDao.modifyOBLRlseFlg(blIssInfoVO);
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
	}
	
	/**
	 * searchVesselNameByBkgNo.<br>
	 * get vessel name by bkgNo	
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchVesselNameByBkgNo(String bkgNo) throws EventException {
		String vslNm = null;
		try {
			vslNm = dbDao.searchVesselNameByBkgNo(bkgNo);
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return vslNm;
	}

    /**
     * EsmBkg0095Event Email event processing
     * Email sending (FAX&EDI > Draft B/L > when EDI Transmission  occur)
     *
     * @param DblWblVO dblWblVO
     * @param String tpId
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendDblAutoEmail(DblWblVO dblWblVO, String tpId, SignOnUserAccount account) throws EventException {
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
    	MailSendVO mailInfo = null;
        String retEmailSndId = null;
        StringTokenizer strNBkgNo = null;
        SimpleDateFormat format = null;
        BkgNtcHisVO bkgNtcHisVO = null;
        String strBlNoTitle = null;
        String title = null;
        String contentsParam = null;
        BookingUtil util = null;
        StringBuilder sbParam = new StringBuilder();
        BkgRouteVO bkgRoute = null;
        String mrdName = null;
		ComUserVO comUserVO = null;
        try {
            util = new BookingUtil();
            comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
            bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            
            // Get Receive Email Address (Search Hard Coding Table)		
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("AUTO_DBL_EMAIL");
			bkgHrdCdgCtntListCondVO.setAttrCtnt1(tpId);		
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs= util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			if(bkgHrdCdgCtntVOs.size() > 0) {
				dblWblVO.setRcveml(bkgHrdCdgCtntVOs.get(0).getAttrCtnt3());
			} else {
				return null;
			}

            format = new SimpleDateFormat("yyyyMMddHHmmss");
            String senderMailAddr ="";
            mrdName = "ESM_BKG_0109_OBL_A4.mrd";
            bkgRoute = util.searchBkgRoute(dblWblVO.getBkgNo());
            if (null!=bkgRoute && 0==bkgRoute.getPorCd().indexOf("US")) {
                mrdName = "ESM_BKG_0109_OBL_LETTER.mrd";
            }
    		//form type setting 2015.10.06. kim-taekyun
            String form_type = "2";
            if("W".equals(dblWblVO.getNtcKndCd())){
            	form_type = "5";
            }else if("D".equals(dblWblVO.getNtcKndCd())){
            	form_type = "7";
            }
            
            // Email send
            mailInfo = new MailSendVO();
			mailInfo.setSysCd("BKG");
			mailInfo.setTmplMrd(mrdName);
			mailInfo.setBatchFlg("N");
			sbParam.append("/rv");
			sbParam.append(" form_bkgNo[('").append(dblWblVO.getBkgNo()).append("')]");
			sbParam.append(" form_type[").append(form_type).append("]");
			sbParam.append(" form_dataOnly[N]");
			sbParam.append(" form_manifest[N]");
			sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
			sbParam.append(" form_hiddeData[N]");
			sbParam.append(" form_level[(1)]");
			sbParam.append(" form_remark[]");
			sbParam.append(" form_Cntr[1]");
			sbParam.append(" form_mainOnly[N]");
			sbParam.append(" form_CorrNo[]");
			sbParam.append(" form_his_cntr[BKG_CONTAINER]");
			sbParam.append(" form_his_bkg[BKG_BOOKING]");
			sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
			sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
			sbParam.append(" form_his_bl[BKG_BL_DOC]");
			sbParam.append(" isEncode[Y]");
			sbParam.append(" /rp []");
			sbParam.append(" /riprnmargin");
			mailInfo.setTmplParam(sbParam.toString());
			if(senderMailAddr.equals("")){
				mailInfo.setSndNm(account.getUsr_nm());
			}else{
				mailInfo.setSndNm("");
			}
//			senderMailAddr = senderMailAddr.equals("") ? account.getUsr_eml():senderMailAddr;
			senderMailAddr = senderMailAddr.equals("") ? sUsrEml:senderMailAddr;
			
			mailInfo.setSndEml(senderMailAddr);
			log.debug("dblWblVO.getRcveml()++++++++++++"+dblWblVO.getRcveml());
			log.debug("account.getUsr_id()++++++++++++"+account.getUsr_id());
			
			mailInfo.setRcvEml(dblWblVO.getRcveml());
			mailInfo.setCrtUserId(account.getUsr_id());
			mailInfo.setFileKey("");
			
			strBlNoTitle = dblWblVO.getBlNo();
			mailInfo.setTmplMrdPdf("OPUS"+strBlNoTitle+".pdf");

        	//Mail Title
        	if (!StringUtils.isEmpty(dblWblVO.getTitle())) {
        		title = dblWblVO.getTitle();
        	} 
        	//Mail Content
        	if (!StringUtils.isEmpty(dblWblVO.getContents())) {
        		contentsParam = dblWblVO.getContents();
        	} 
			
			mailInfo.setTitle(title); // 占쎌젫筌륅옙
			mailInfo.setContents(contentsParam); // 占쎄땀占쎌뒠
	
			
			String ccEmlAddr = util.searchCcEmailAddrRSQL(dblWblVO.getNtcKndCd(), account.getUsr_id());
			if (StringUtils.isEmpty(ccEmlAddr)){
				ccEmlAddr = "webmaster@clt.com";
			}
			retEmailSndId = bleaiDao.sendEmail(mailInfo,null,dblWblVO.getNtcKndCd(),util.searchCcEmailAddrRSQL(dblWblVO.getNtcKndCd(), account.getUsr_id()));  //筌〓챷��(cc)�빊遺쏙옙
			
//			log.debug("retEmailSndIds"+retEmailSndIds.size());
//			if (retEmailSndIds.size() > 0) retEmailSndId = retEmailSndIds.get(0);
//			else  retEmailSndId = "";
			
            // Notice History Setting(input History each bkg_no)
            strNBkgNo = new StringTokenizer(dblWblVO.getBkgNo(), "|");  // separator is "|" in case of many BKG_NO in one  BL
            while (strNBkgNo.hasMoreTokens()) {
                bkgNtcHisVO = new BkgNtcHisVO();
                bkgNtcHisVO.setBkgNo(strNBkgNo.nextToken());
                bkgNtcHisVO.setNtcViaCd("M");
                bkgNtcHisVO.setNtcKndCd((dblWblVO.getNtcKndCd()==null||"".equals(dblWblVO.getNtcKndCd()))?"BL":dblWblVO.getNtcKndCd());  // NTC_KND_CD(BL:Outbound,NN:Inbound,WB:Waybill)  
                bkgNtcHisVO.setAgnCd("");
                bkgNtcHisVO.setNtcFomCd("");
                bkgNtcHisVO.setNtcSeq("");
                bkgNtcHisVO.setBkgCustTpCd("");
                bkgNtcHisVO.setCustCntcTpCd("");
                bkgNtcHisVO.setNtcEml(dblWblVO.getRcveml());
                bkgNtcHisVO.setSndId(retEmailSndId);
                bkgNtcHisVO.setFrtHdnFlg(dblWblVO.getHiddOpt());
                bkgNtcHisVO.setFrtAllFlg(dblWblVO.getFrtAllFlg());
                bkgNtcHisVO.setFrtCltFlg(dblWblVO.getFrtCltFlg());
                bkgNtcHisVO.setFrtPpdFlg(dblWblVO.getFrtPpdFlg());
                bkgNtcHisVO.setFrtChgFlg(dblWblVO.getFrtChgFlg());
                bkgNtcHisVO.setFrtArrFlg(dblWblVO.getFrtArrFlg());
                bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
                bkgNtcHisVO.setSndUsrId(account.getUsr_id());
                bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
                bkgNtcHisVO.setDiffRmk("");
                bkgNtcHisVO.setCreUsrId(account.getUsr_id());
                bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
                bkgNtcHisVOs.add(bkgNtcHisVO);
            }
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }
    
    /**
	 * EsmBkg1074Event 鈺곌퀬�돳 占쎌뵠甕겹끋�뱜 筌ｌ꼶�봺<br>
	 * @author 
	 * @param String bkgNo
	 * @return List<AuthCustVO>
	 * @exception EventException
	 */
	public List<AuthCustVO> searchCustInfo(String bkgNo) throws EventException{
		List<AuthCustVO> list = null;
		
        try {
            // 01. validation占쎌뱽 占쎈땾占쎈뻬占쎈립占쎈뼄.
            
            // 02. �뜮袁⑹グ占쎈빍占쎈뮞 嚥≪뮇彛� 占쎈땾占쎈뻬
        	list = dbDao.searchCustInfo(bkgNo);
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }		
		return list;
	}
	
	/**
	 * EsmBkg1074Event<br>
	 * @author 
	 * @param Mail amail
	 * @exception EventException
	 */
    public void sendAuthEmail(Mail amail) throws EventException {
		try {
			bleaiDao.sendInternetAuthMail(amail);
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}   

	/**
	 * BKG_BL_ISS占쎌벥 BL_PRF_SHPR_FLG 占쎄맒占쎄묶揶쏅�れ뱽 UPDATE占쎈립占쎈뼄.(ESM_BKG_0228)<br>
	 * @param 	BlIssInfoVO blIssInfoVO
	 * @exception 	DAOException
	 */
	public void modifyBlIssByBkgNo(BlIssInfoVO blIssInfoVO) throws EventException {
		try{
			dbDao.modifyBlIssByBkgNo(blIssInfoVO);
		} catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }	
	}

	/**
	 * Web Service EAI占쎌뒠(WEB_004_0001)<br>
	 * 
	 * @param BkgWebService004VO webVo
	 * @exception EventException
	 */
	public void modifyWeb0040001Control(BkgWebService004VO webVo) throws EventException {
		try {
			String blTpCd = null;
			// UPDATE
			blTpCd = dbDao.searchBlTp(webVo.getBkgNo());
			if(null != blTpCd && "W".equals(blTpCd)){
				dbDao.modifyIntWblAuth(webVo);
				dbDao.modifyIntWblPrnAuth(webVo);
			}else{
				dbDao.modifyIntAuth(webVo);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}	
	}	

	/**
	 * ESM_BKG_0097_09 : E-mail send at save button click <br>
	 * <br>
	 * 
	 * @author	
	 * @param 	String bkgNo
	 * @param 	SignOnUserAccount account
	 * @exception 	Exception
	 */
	public void sendBlCompleteEmail(String bkgNo, SignOnUserAccount account) throws Exception{
		BookingHistoryMgtBC bkgHisCmd = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
        String outRead = null;
        Hashtable<String,String> templateArgs = null;
        EmlInfoVO emlInfoVO = null;
        EmlBkgInfoVO emlBkgInfoVO = null;
        SearchRcvEmlVO searchRcvEmlVO = null;
//        List<SearchRcvEmlVO> searchRcvEmlVOs = null;
        List<SearchBlCompleteRcvEmlVO> searchBlCompleteRcvEmlVOs = null;
        BookingUtil util = null;
        String sysHost = null;	//host file setting
        
		try {

			bkgHisCmd = new BookingHistoryMgtBCImpl();
            util = new BookingUtil();
			
			//get email address from master and check send target or not
			searchRcvEmlVO = new SearchRcvEmlVO();
			searchRcvEmlVO.setBkgNo(bkgNo);
			searchRcvEmlVO.setNtfyPrfFlg("1");
//			searchRcvEmlVOs = searchRcvEml(searchRcvEmlVO);

			searchBlCompleteRcvEmlVOs = searchBlCompleteRcvEml(bkgNo);

//			if(searchRcvEmlVOs.size()>0){
			if(searchBlCompleteRcvEmlVOs != null){
				if(searchBlCompleteRcvEmlVOs.size()>0){
					
					emlInfoVO = new EmlInfoVO();
					emlInfoVO.setNtcViaCd("M");
					emlInfoVO.setNtcKndCd("ED");
		
					//check already sent or not
//					searchBlNtcHisVO = new SearchBlNtcHisVO();
//					searchBlNtcHisVO.setBkgNo(bkgNo);
					
//					searchBlNtcHisVO.setNtcViaCd(emlInfoVO.getNtcViaCd());
//					searchBlNtcHisVO.setNtcKndCd(emlInfoVO.getNtcKndCd());
					
//					searchBlNtcHisVO = searchBlNtcHis(searchBlNtcHisVO);
					
					//send only one time
//					if(searchBlNtcHisVO==null){
							
						//get template
						outRead = FileUtils.fileReader(SiteConfigFactory.get("COM.CLT.JAF.MAIL.TEMPLATE.DIR"), "ESM_BKG_0079_09_01T.html");
						
						//system host location
						sysHost = SubSystemConfigFactory.get("ESM.BKG.ECOM.URL");
						log.debug("#########[host] "+sysHost+" #########");
						
			            //get transaction data to set in e-mail
						emlBkgInfoVO = searchEmlBkgInfo(bkgNo);
			
						//set transaction values
						templateArgs = new Hashtable<String,String>();
						templateArgs.put("bkgNo",emlBkgInfoVO.getBkgNo());
						templateArgs.put("refNo",emlBkgInfoVO.getRefNo());
						templateArgs.put("por",emlBkgInfoVO.getPor());
						templateArgs.put("pod",emlBkgInfoVO.getPod());		
						templateArgs.put("onBoardDate",emlBkgInfoVO.getBlObrdDt());
						templateArgs.put("shprName",emlBkgInfoVO.getShprNm());
						templateArgs.put("vvd",emlBkgInfoVO.getVvd());
						templateArgs.put("blNo",emlBkgInfoVO.getBlNo());
						templateArgs.put("sysHost",sysHost);	//host file setting
						outRead = util.parseTemplate(outRead,templateArgs);
						
						//set title & content into emlInfoVO
						emlInfoVO.setTitle(util.getTemplatePart(outRead, "title"));
						emlInfoVO.setContent(util.getTemplatePart(outRead, "body"));
						
	//					for(SearchRcvEmlVO rcvEmlVO: searchRcvEmlVOs){
						for(SearchBlCompleteRcvEmlVO rcvEmlVO: searchBlCompleteRcvEmlVOs){
							emlInfoVO.setRcveml(rcvEmlVO.getUsrEml());
							bkgNtcHisVOs = sendBlIssueEmails(emlBkgInfoVO, emlInfoVO, account);
							bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_09");
						}
	
						log.debug(outRead);
//					}
					
				}
			}

		} catch(Exception ex) {
			throw ex;  			
		}		
	}

	/**
	 * ESM_BKG_1074 : E-mail send at AUTHORIZE button click <br>
	 * <br>
	 * 
	 * @author	
	 * @param 	String bkgNo
	 * @param 	SignOnUserAccount account
	 * @exception 	Exception
	 */
	public void sendOblPrintAuthEmail(String bkgNo, SignOnUserAccount account) throws Exception{
		BookingHistoryMgtBC bkgHisCmd = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
        String outRead = null;
        Hashtable<String,String> templateArgs = null;
        EmlInfoVO emlInfoVO = null;
        EmlBkgInfoVO emlBkgInfoVO = null;
        BookingUtil util = null;
        SearchRcvEmlVO searchRcvEmlVO = null;
        List<SearchBlPrintRcvEmlVO> searchBlPrintRcvEmlVOs = null;
        String sysHost = null;	//host file setting
        
		try {

			bkgHisCmd = new BookingHistoryMgtBCImpl();
            util = new BookingUtil();

			emlInfoVO = new EmlInfoVO();
			emlInfoVO.setNtcViaCd("M");
			emlInfoVO.setNtcKndCd("EI");

			//get email address from master and check send target or not
			searchRcvEmlVO = new SearchRcvEmlVO();
			searchRcvEmlVO.setBkgNo(bkgNo);
			searchRcvEmlVO.setNtfyPrnFlg("1");
//			searchRcvEmlVOs = searchRcvEml(searchRcvEmlVO);			
			searchBlPrintRcvEmlVOs = searchBlPrintRcvEml(bkgNo,"IAU");			

//			if(searchRcvEmlVOs.size()>0){
			if(searchBlPrintRcvEmlVOs != null){
				if(searchBlPrintRcvEmlVOs.size()>0){
	
					//get template
					outRead = FileUtils.fileReader(SiteConfigFactory.get("COM.CLT.JAF.MAIL.TEMPLATE.DIR"), "ESM_BKG_0079_09_02T.html");
					//system host location
					sysHost = SubSystemConfigFactory.get("ESM.BKG.ECOM.URL");
					log.debug("#########[host] "+sysHost+" #########");
		
		            //get transaction data to set in e-mail
					emlBkgInfoVO = searchEmlBkgInfo(bkgNo);
	
					//set transaction values
					templateArgs = new Hashtable<String,String>();
					templateArgs.put("bkgNo",emlBkgInfoVO.getBkgNo());
					templateArgs.put("refNo",emlBkgInfoVO.getRefNo());
					templateArgs.put("por",emlBkgInfoVO.getPor());
					templateArgs.put("pod",emlBkgInfoVO.getPod());		
					templateArgs.put("onBoardDate",emlBkgInfoVO.getBlObrdDt());
					templateArgs.put("shprName",emlBkgInfoVO.getShprNm());
					templateArgs.put("vvd",emlBkgInfoVO.getVvd());
					templateArgs.put("blNo",emlBkgInfoVO.getBlNo());
					templateArgs.put("sysHost",sysHost);	//host file setting
					outRead = util.parseTemplate(outRead,templateArgs);
					
					//set title & content into emlInfoVO
					emlInfoVO.setTitle(util.getTemplatePart(outRead, "title"));
					emlInfoVO.setContent(util.getTemplatePart(outRead, "body"));
	
	//				for(SearchRcvEmlVO rcvEmlVO: searchRcvEmlVOs){
					for(SearchBlPrintRcvEmlVO rcvEmlVO: searchBlPrintRcvEmlVOs){
						emlInfoVO.setRcveml(rcvEmlVO.getUsrEml());
						bkgNtcHisVOs = sendBlIssueEmails(emlBkgInfoVO, emlInfoVO, account);		
						bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_1074");
					}
	
					log.debug(outRead);
	
				}
			}
		} catch(Exception ex) {
			throw ex;  			
		}		
	}
	
    /**
     * EsmBkg007909Event Email event processing
     * Email send
     *
     * @param EmlBkgInfoVO emlBkgInfoVO
     * @param EmlInfoVO emlInfoVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendBlIssueEmails(EmlBkgInfoVO emlBkgInfoVO,EmlInfoVO emlInfoVO, SignOnUserAccount account) throws EventException {
        List<BkgNtcHisVO> bkgNtcHisVOs = null;
        String retEmailSndId = null;
        SimpleDateFormat format = null;
        BkgNtcHisVO bkgNtcHisVO = null;
        BookingUtil util = null;
		ComUserVO comUserVO = null;
		
		Mail amail = null;
		
        try {
	        	util = new BookingUtil();
				// modify  account.getUsr_Eml() -> getDfltEml()
	            comUserVO = util.searchComUserInfo(account.getUsr_id());
				String sUsrEml = null;
				if (null!=comUserVO) {
					sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
				}
	            String senderMailAddr ="";
				senderMailAddr = senderMailAddr.equals("") ? sUsrEml:senderMailAddr;
				
	            bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
	            format = new SimpleDateFormat("yyyyMMddHHmmss");
				
				amail = new Mail();
				
				amail.setBatFlg("N");
				amail.setSubject(emlInfoVO.getTitle());
				amail.setHtmlContent(emlInfoVO.getContent());
				amail.setCreUsrIds(account.getUsr_id());
//				amail.setFrom(senderMailAddr, account.getUsr_nm());
				amail.setFrom("noreply@nykline.com");
				amail.setRecipient(emlInfoVO.getRcveml());
				//sent e-mail
				retEmailSndId = bleaiDao.sendInternetAuthMail(amail);
				
				//create record on BKG_NTC_HIS
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(emlBkgInfoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd(emlInfoVO.getNtcViaCd());			
				bkgNtcHisVO.setNtcKndCd(emlInfoVO.getNtcKndCd()); 
				bkgNtcHisVO.setAgnCd("");
				bkgNtcHisVO.setNtcFomCd("");
				bkgNtcHisVO.setNtcSeq("");
				bkgNtcHisVO.setBkgCustTpCd("");
				bkgNtcHisVO.setCustCntcTpCd("");
				bkgNtcHisVO.setNtcEml(emlInfoVO.getRcveml());
				bkgNtcHisVO.setSndId(retEmailSndId);
				bkgNtcHisVO.setFrtHdnFlg("N");
				bkgNtcHisVO.setFrtAllFlg("N");
				bkgNtcHisVO.setFrtCltFlg("N");
				bkgNtcHisVO.setFrtPpdFlg("N");
				bkgNtcHisVO.setFrtChgFlg("N");
				bkgNtcHisVO.setFrtArrFlg("N");
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
				bkgNtcHisVO.setDiffRmk("");
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
				
			
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }

	/**
	 * ESM_BKG_0079_09 : SWB Release button click (copy from ESM_BKG_0095)<br>
	 * <br>
	 * 
	 * @author	
	 * @param 	String bkgNo
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
	 * @param 	String fileDownPath
	 * @exception 	Exception
	 */
	public void sendWblReleaseEmail(String bkgNo, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account, String fileDownPath) throws Exception {

		BookingUtil utilBC = null;
		BookingHistoryMgtBC bkgHisCmd = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		StringBuilder sbParam = null;
		String sType = null;
		String sLevel = null;
		String sMrd = null;
		DblWblVO[] dblWblVOs = null;
		BkgRouteVO bkgRouteVO = null;
		BkgEmlEdtVO bkgEmlEdtVO = null;
        String outRead = null;
        Hashtable<String,String> templateArgs = null;
        EmlBkgInfoVO emlBkgInfoVO = null;
        List<SearchBlPrintRcvEmlVO> searchBlPrintRcvEmlVOs = null;
        EmlInfoVO emlInfoVO = null;
        String ntcKind = "ES";
        String japanStampValue = "";
        BkgBlNoVO esigVO = null;
        String blEsigFlg = "";
        String blCpyEsigFlg = "";
        String sysHost = null;	//host file setting
        
		try {
			
			//send e-mail 2 times. First one is without document attach, second is with document
			//None-attach email process
			emlInfoVO = new EmlInfoVO();
			emlInfoVO.setNtcViaCd("M");
			emlInfoVO.setNtcKndCd(ntcKind);

			searchBlPrintRcvEmlVOs = searchBlPrintRcvEml(bkgNo, "SWM");	// SeaWaybill Mail without attached	
			
			//system host location
			sysHost = SubSystemConfigFactory.get("ESM.BKG.ECOM.URL");
			log.debug("#########[host] "+sysHost+" #########");
        				
			if(searchBlPrintRcvEmlVOs != null){
				if(searchBlPrintRcvEmlVOs.size()>0){
					
					utilBC = new BookingUtil();
					bkgHisCmd = new BookingHistoryMgtBCImpl();
					bkgEmlEdtVO = new BkgEmlEdtVO();
		
		            //get transaction data to set in e-mail
					emlBkgInfoVO = searchEmlBkgInfo(bkgNo);
		
					//get template
					outRead = FileUtils.fileReader(SiteConfigFactory.get("COM.CLT.JAF.MAIL.TEMPLATE.DIR"), "ESM_BKG_0079_09_03T.html");
					
	
					//set transaction values
					templateArgs = new Hashtable<String,String>();
					templateArgs.put("bkgNo",emlBkgInfoVO.getBkgNo());
					templateArgs.put("refNo",emlBkgInfoVO.getRefNo());
					templateArgs.put("por",emlBkgInfoVO.getPor());
					templateArgs.put("pod",emlBkgInfoVO.getPod());		
					templateArgs.put("onBoardDate",emlBkgInfoVO.getBlObrdDt());
					templateArgs.put("shprName",emlBkgInfoVO.getShprNm());
					templateArgs.put("vvd",emlBkgInfoVO.getVvd());
					templateArgs.put("blNo",emlBkgInfoVO.getBlNo());
					templateArgs.put("sysHost",sysHost);	//host file setting
					outRead = utilBC.parseTemplate(outRead,templateArgs);
	
					//set title & content into emlInfoVO
					emlInfoVO.setTitle(utilBC.getTemplatePart(outRead, "title"));
					emlInfoVO.setContent(utilBC.getTemplatePart(outRead, "body"));
	
					for(SearchBlPrintRcvEmlVO rcvEmlVO: searchBlPrintRcvEmlVOs){
						emlInfoVO.setRcveml(rcvEmlVO.getUsrEml());
						bkgNtcHisVOs = sendBlIssueEmails(emlBkgInfoVO, emlInfoVO, account);		
						bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_09");
					}
				}
			}

			//Attached E-mail process
			searchBlPrintRcvEmlVOs = searchBlPrintRcvEml(bkgNo, "SWA");
			String formType = "";
			String formTypeCnt = "";
			String formLevel = "";
			
	    	String[] formTypes = null;
	    	String[] formTypesCnt = null;
	    	String[] formLevels = null;
			
			
			List<DocRqstVO> docRqstList = searchDocRqst(bkgNo,"");

			if(null != searchBlPrintRcvEmlVOs && searchBlPrintRcvEmlVOs.size()> 0){
				if(null != docRqstList && docRqstList.size() > 0 ){
					
					utilBC = new BookingUtil();
					bkgHisCmd = new BookingHistoryMgtBCImpl();
					bkgEmlEdtVO = new BkgEmlEdtVO();
				
					//get transaction data to set in e-mail
					emlBkgInfoVO = searchEmlBkgInfo(bkgNo);
		
					//get template
					outRead = FileUtils.fileReader(SiteConfigFactory.get("COM.CLT.JAF.MAIL.TEMPLATE.DIR"), "ESM_BKG_0079_09_03T.html");
					
					//set transaction values
					templateArgs = new Hashtable<String,String>();
					templateArgs.put("bkgNo",emlBkgInfoVO.getBkgNo());
					templateArgs.put("refNo",emlBkgInfoVO.getRefNo());
					templateArgs.put("por",emlBkgInfoVO.getPor());
					templateArgs.put("pod",emlBkgInfoVO.getPod());		
					templateArgs.put("onBoardDate",emlBkgInfoVO.getBlObrdDt());
					templateArgs.put("shprName",emlBkgInfoVO.getShprNm());
					templateArgs.put("vvd",emlBkgInfoVO.getVvd());
					templateArgs.put("blNo",emlBkgInfoVO.getBlNo());
					templateArgs.put("sysHost",sysHost);	//host file setting
					outRead = utilBC.parseTemplate(outRead,templateArgs);
	
					//set title & content into emlInfoVO
					bkgEmlEdtVO.setEdtSubject(utilBC.getTemplatePart(outRead, "title"));
					bkgEmlEdtVO.setEdtContents(utilBC.getTemplatePart(outRead, "body"));
	
					//File attach process
					bkgEmlEdtVO.setEdtNtcKndCd("ES");
					bkgEmlEdtVO.setEdtBkgNoList(bkgNo);
					bkgEmlEdtVO.setEdtCcEml("");
					bkgEmlEdtVO.setEdtFromEml("noreply@nykline.com");
					
					sType = sLevel = sMrd = "";
		
					sbParam = new StringBuilder();
		
					bkgRouteVO = utilBC.searchBkgRoute(bkgNo);
					
					//2015.03.05. by kimtaekyun. japan stamp check
					japanStampValue = utilBC.checkJapanStamp(bkgNo);
					esigVO = utilBC.searchEsigAgent(bkgNo);
					if(esigVO == null){
						blEsigFlg = "";
						blCpyEsigFlg = "";
					}else{
						blEsigFlg = esigVO.getBlEsigFlg();
						blCpyEsigFlg = esigVO.getBlCpyEsigFlg();
					}
					//Original Rated
					if(!"0".equals(docRqstList.get(0).getOblRtInclKnt())){
						formType += "5_";
						formTypeCnt += docRqstList.get(0).getOblRtInclKnt()+"_";
						formLevel += "1_";
					}
					//Original Unrated
					if(!"0".equals(docRqstList.get(0).getOblRtXcldKnt())){
						formType += "5_";
						formTypeCnt += docRqstList.get(0).getOblRtXcldKnt()+"_";
						formLevel += "6_";
					}
					//Original Prepaid
					if(!"0".equals(docRqstList.get(0).getOblPpdKnt())){
						formType += "5_";
						formTypeCnt += docRqstList.get(0).getOblPpdKnt()+"_";
						formLevel += "4_";
					}
					//Original Collect
					if(!"0".equals(docRqstList.get(0).getOblCltKnt())){
						formType += "5_";
						formTypeCnt += docRqstList.get(0).getOblCltKnt()+"_";
						formLevel += "5_";
					}
					//Non Copy Rated
					if(!"0".equals(docRqstList.get(0).getNonNegoRtInclKnt())){
						formType += "5_";
						formTypeCnt += docRqstList.get(0).getNonNegoRtInclKnt()+"_";
						formLevel += "1_";
					}
					//Non Unrated
					if(!"0".equals(docRqstList.get(0).getNonNegoRtXcldKnt())){
						formType += "5_";
						formTypeCnt += docRqstList.get(0).getNonNegoRtXcldKnt()+"_";
						formLevel += "6_";
					}
					//Non Prepaid
					if(!"0".equals(docRqstList.get(0).getNonNegoPpdKnt())){
						formType += "5_";
						formTypeCnt += docRqstList.get(0).getNonNegoPpdKnt()+"_";
						formLevel += "4_";
					}
					//Non Collect
					if(!"0".equals(docRqstList.get(0).getNonNegoCltKnt())){
						formType += "5_";
						formTypeCnt += docRqstList.get(0).getNonNegoCltKnt()+"_";
						formLevel += "5_";
					}
					if(!formType.equals("")){
						formType = formType.substring(0, formType.length()-1);
						formTypeCnt = formTypeCnt.substring(0, formTypeCnt.length()-1);
						formLevel = formLevel.substring(0, formLevel.length()-1);
					}
					//form객체 배열작업
					if(formType.indexOf("_") > -1){
			    		formTypes = formType.split("_");
			    		formTypesCnt = formTypeCnt.split("_"); 
			    		formLevels = formLevel.split("_");
			    	}else{
			    		formTypes = new String[]{formType};
			    		formTypesCnt = new String[]{formTypeCnt};
			    		formLevels = new String[]{formLevel};
			    	}
					sbParam = new StringBuilder();
					
					bkgRouteVO = utilBC.searchBkgRoute(bkgNo);
					
					//2015.03.05. by kimtaekyun. japan stamp check
					japanStampValue = utilBC.checkJapanStamp(bkgNo);
					esigVO = utilBC.searchEsigAgent(bkgNo);
					if(esigVO == null){
						blEsigFlg = "";
						blCpyEsigFlg = "";
					}else{
						blEsigFlg = esigVO.getBlEsigFlg();
						blCpyEsigFlg = esigVO.getBlCpyEsigFlg();
					}
					
					if (0==bkgRouteVO.getPorCd().indexOf("US")) {
						sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
					} else {
						sMrd="ESM_BKG_0109_OBL_A4.mrd";
					}
					
					MailSendVO mailInfo = null;
					mailInfo = new MailSendVO();
					List<ComRptDsgnXptInfoVO> xptVOs = new ArrayList<ComRptDsgnXptInfoVO>();
	                bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
	                BkgNtcHisVO bkgNtcHisVO = null;
	                StringTokenizer strNBkgNo = null;
	                SimpleDateFormat format = null;
	                String title = "";
	                String contentsParam = "";
	                String senderMailAddr ="";
	                String strBlNoTitle = null;
	                String strBlNoBody = null;
	                String strBlRemark = "";
	                ArrayList<String> arrTmplMrd = null;
	                ArrayList<String> arrTmplParam = null;
	                ArrayList<String> arrTmplMrdPdf = null;
	                xptVOs = new ArrayList<ComRptDsgnXptInfoVO>();//Null Referencing
	                arrTmplMrd    = new ArrayList<String>();
	                arrTmplParam  = new ArrayList<String>();
	                arrTmplMrdPdf = new ArrayList<String>();
	                ComRptDsgnXptInfoVO xptVO = null;
	                format = new SimpleDateFormat("yyyyMMddHHmmss");

					
					if(formTypes.length <= 0 || null == formTypes[0] || "".equals(formTypes[0])){
						
						sType="5"; //ORIGINAL NON NEGOTIABLE
						sLevel="6"; //No charge
						
						sbParam.append("/rv");
						sbParam.append(" form_bkgNo[('").append(bkgNo).append("')]");
						sbParam.append(" form_type[").append(sType).append("]");
						sbParam.append(" form_dataOnly[N]");
						sbParam.append(" form_manifest[N]");
						sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
						sbParam.append(" form_hiddeData[N]");
						sbParam.append(" form_level[(").append(sLevel).append(")]");
						sbParam.append(" form_remark[]");
						sbParam.append(" form_Cntr[1]");
						sbParam.append(" form_mainOnly[N]");
						sbParam.append(" form_CorrNo[]");
						sbParam.append(" form_his_cntr[BKG_CONTAINER]");
						sbParam.append(" form_his_bkg[BKG_BOOKING]");
						sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
						sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
						sbParam.append(" form_his_bl[BKG_BL_DOC]");
						sbParam.append(" isEncode[Y]");
						//2014.12.03 Maeda add
						sbParam.append(" form_rqst_via_cd[").append(japanStampValue).append("]");	//2015.03.05. by kimtaekyun. e-service option 'WEB' 
						sbParam.append(" form_his_bl_mkd[BKG_BL_ISS]");		
						//2014.12.03 Maeda end
						//2015.03.02 add
						sbParam.append(" form_esig[").append(blEsigFlg).append("]");				//2015.03.05. by kimtaekyun. E-signature flag
						sbParam.append(" form_cpy_esig[").append(blCpyEsigFlg).append("]");			//2015.03.05. by kimtaekyun. E-signature flag
						sbParam.append(" form_knt_flg[]");
						sbParam.append(" form_count[]");
						//2015.03.02 end
						sbParam.append(" form_path[" + fileDownPath + "]");
						
						sbParam.append(" /rp []");
						sbParam.append(" /riprnmargin");
						dblWblVOs = new DblWblVO[1];
						dblWblVOs[0] = new DblWblVO();
						dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
						dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
						dblWblVOs[0].setSyscd("BKG");
						dblWblVOs[0].setTmplmrd(sMrd);
						dblWblVOs[0].setBatchflg("N");
						dblWblVOs[0].setTmplparam(sbParam.toString());
						dblWblVOs[0].setTmplmrdpdf("NYKS_" + bkgBlNoVO.getBlNo() + ".pdf");
						dblWblVOs[0].setItr("|$$|");
						dblWblVOs[0].setNtcKndCd(bkgEmlEdtVO.getEdtNtcKndCd());
						dblWblVOs[0].setHiddOpt("N");
						dblWblVOs[0].setFrtArrFlg("N");
						
		                for (DblWblVO vo : dblWblVOs) {
		                	if(null != vo.getTmplmrd()){
		                		for (String s :  vo.getTmplmrd   ().split("\\|\\$\\$\\|")) { arrTmplMrd   .add(s); }
		                	 }
			                if(null != vo.getTmplparam()){	
			                	for (String s :  vo.getTmplparam ().split("\\|\\$\\$\\|")) { arrTmplParam .add(s); }
			                }
			                if(null != vo.getTmplmrdpdf()){
			                	for (String s :  vo.getTmplmrdpdf().split("\\|\\$\\$\\|")) { arrTmplMrdPdf.add(s); }
			                }
			            	log.debug("####### [size] ###########"+arrTmplParam.size());
			            	
			            	xptVOs = new ArrayList<ComRptDsgnXptInfoVO>(arrTmplParam.size());
			                for (int j=0; j < arrTmplParam.size(); j++) {
			                	xptVO = new ComRptDsgnXptInfoVO();
			                	log.debug("##################"+arrTmplMrd.get(j));
			                	log.debug("##################"+arrTmplParam.get(j));
			                	log.debug("##################"+arrTmplMrdPdf.get(j));
			                	
			                	
			                	xptVO.setRdTmpltNm(arrTmplMrd.get(j));           // *.mrd name
			                	xptVO.setRdParaCtnt(arrTmplParam.get(j));  // *.mrd parameter
			                	xptVO.setXptFileNm(arrTmplMrdPdf.get(j));   // Will be changed file name when *.mrd attach
			                	xptVO.setCreUsrId(account.getUsr_id());
			                	xptVO.setUpdUsrId(account.getUsr_id());
			                	xptVO.setXptFileTpCd("5");
			                    xptVOs.add(xptVO);
			                }
		                }
		                
						bkgEmlEdtVO.setEdtToEml(searchBlPrintRcvEmlVOs.get(0).getUsrEml());
						
		    			String sUsrEml = null;
		    			BookingUtil util = null;
		    			ComUserVO comUserVO = null;
		    			util = new BookingUtil();
		                comUserVO = util.searchComUserInfo(account.getUsr_id());
		                
		    			if (null!=comUserVO) {
		    				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
		    			}
						
						mailInfo.setSysCd("BKG");
						mailInfo.setTmplMrd(dblWblVOs[0].getTmplmrd());
						mailInfo.setBatchFlg("N");
						mailInfo.setTmplParam(dblWblVOs[0].getTmplparam());
						mailInfo.setSndNm(account.getUsr_nm());
						
						senderMailAddr = senderMailAddr.equals("") ? sUsrEml:senderMailAddr;
						
						mailInfo.setSndEml(senderMailAddr);
						if(bkgEmlEdtVO != null && "noreply@nykline.com".equals(bkgEmlEdtVO.getEdtFromEml())){
							mailInfo.setSndNm("");
							mailInfo.setSndEml("noreply@nykline.com");
						}
						mailInfo.setRcvEml(searchBlPrintRcvEmlVOs.get(0).getUsrEml());
						mailInfo.setCrtUserId(account.getUsr_id());
						mailInfo.setFileKey("");
						mailInfo.setTmplMrdPdf("NYKS"+bkgBlNoVO.getBlNo()+".pdf");
						mailInfo.setTitle(title); // title
						
						title = dblWblVOs[0].getTitle();
						mailInfo.setTitle(title); // title
						mailInfo.setContents(contentsParam); // contents
	                	String vslNm = this.searchVesselNameByBkgNo(bkgBlNoVO.getBkgNo());
						strBlNoTitle = strBlNoBody = bkgBlNoVO.getBlNo();
	                	
	                	
	                    contentsParam = !StringUtils.isEmpty(dblWblVOs[0].getContents()) ? dblWblVOs[0].getContents() : "blNoTitle;T/VVD : "+vslNm+" / B/L No : NYKS"+strBlNoTitle+"@@blNoBody;NYKS"+strBlNoBody+"@@blRemark;"+strBlRemark;
	                    mailInfo.setTitle(title);
	    				mailInfo.setContents(contentsParam);
						
						String retEmailSndId = null;
	                    retEmailSndId = bleaiDao.sendReportDesignerWithFiles(mailInfo, bkgEmlEdtVO, xptVOs);
	                    
	                    strNBkgNo = new StringTokenizer(bkgBlNoVO.getBkgNo(), "|");  // separator is "|" in case of many BKG_NO in one BL 
	                    while (strNBkgNo.hasMoreTokens()) {
	                        bkgNtcHisVO = new BkgNtcHisVO();
	                        bkgNtcHisVO.setBkgNo(strNBkgNo.nextToken());
	                        bkgNtcHisVO.setNtcViaCd("M");
	                        bkgNtcHisVO.setNtcKndCd("ES");  // NTC_KND_CD(BL:Outbound,NN:Inbound,WB:Waybill)  
	                        bkgNtcHisVO.setAgnCd("");
	                        bkgNtcHisVO.setNtcFomCd("");
	                        bkgNtcHisVO.setNtcSeq("");
	                        bkgNtcHisVO.setBkgCustTpCd("");
	                        bkgNtcHisVO.setCustCntcTpCd("");
	                        bkgNtcHisVO.setNtcEml(searchBlPrintRcvEmlVOs.get(0).getUsrEml());
	                        bkgNtcHisVO.setSndId(retEmailSndId);
	                        bkgNtcHisVO.setFrtHdnFlg("N");
	                        bkgNtcHisVO.setFrtAllFlg(dblWblVOs[0].getFrtAllFlg());
	                        bkgNtcHisVO.setFrtCltFlg(dblWblVOs[0].getFrtCltFlg());
	                        bkgNtcHisVO.setFrtPpdFlg(dblWblVOs[0].getFrtPpdFlg());
	                        bkgNtcHisVO.setFrtChgFlg(dblWblVOs[0].getFrtChgFlg());
	                        bkgNtcHisVO.setFrtArrFlg(dblWblVOs[0].getFrtArrFlg());
	                        bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
	                        bkgNtcHisVO.setSndUsrId(account.getUsr_id());
	                        bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
	                        bkgNtcHisVO.setDiffRmk("");
	                        bkgNtcHisVO.setCreUsrId(account.getUsr_id());
	                        bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
	                        bkgNtcHisVOs.add(bkgNtcHisVO);
	                    }
						bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_09");
						
					}else{
						// PDF 갯수 만큼 실행
//				    	dblWblVOs = new DblWblVO[formTypes.length];
						int count = 0;
						int cnt = 0;
						for(int k= 0; k< formTypesCnt.length; k++){
								count = count + Integer.parseInt(formTypesCnt[k]);
						}
						
						dblWblVOs = new DblWblVO[count];
						for(int i= 0; i< formTypes.length; i++){
							
							sbParam = new StringBuilder();
							sType = formTypes[i];
							sLevel = formLevels[i];
								
							for(int y=0; y< Integer.parseInt(formTypesCnt[i]); y++ ){
								sbParam.append("/rv");
								sbParam.append(" form_bkgNo[('").append(bkgNo).append("')]");
								sbParam.append(" form_type[").append(sType).append("]");
								sbParam.append(" form_dataOnly[N]");
								sbParam.append(" form_manifest[N]");
								sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
								sbParam.append(" form_hiddeData[N]");
								sbParam.append(" form_level[(").append(sLevel).append(")]");
								sbParam.append(" form_remark[]");
								sbParam.append(" form_Cntr[1]");
								sbParam.append(" form_mainOnly[N]");
								sbParam.append(" form_CorrNo[]");
								sbParam.append(" form_his_cntr[BKG_CONTAINER]");
								sbParam.append(" form_his_bkg[BKG_BOOKING]");
								sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
								sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
								sbParam.append(" form_his_bl[BKG_BL_DOC]");
								sbParam.append(" isEncode[Y]");
								//2014.12.03 Maeda add
								sbParam.append(" form_rqst_via_cd[").append(japanStampValue).append("]");	//2015.03.05. by kimtaekyun. e-service option 'WEB' 
								sbParam.append(" form_his_bl_mkd[BKG_BL_ISS]");		
								//2014.12.03 Maeda end
								//2015.03.02 add
								sbParam.append(" form_esig[").append(blEsigFlg).append("]");				//2015.03.05. by kimtaekyun. E-signature flag
								sbParam.append(" form_cpy_esig[").append(blCpyEsigFlg).append("]");			//2015.03.05. by kimtaekyun. E-signature flag
								sbParam.append(" form_knt_flg[]");
								sbParam.append(" form_count[").append(formTypesCnt[i]).append("]");
								//2015.03.02 end
								sbParam.append(" form_path[" + fileDownPath + "]");
								
								sbParam.append(" /rp []");
								sbParam.append(" /riprnmargin");
								
								
								dblWblVOs[cnt] = new DblWblVO();
								dblWblVOs[cnt].setBkgNo(bkgBlNoVO.getBkgNo());
								dblWblVOs[cnt].setBlNo(bkgBlNoVO.getBlNo());
								dblWblVOs[cnt].setSyscd("BKG");
								dblWblVOs[cnt].setTmplmrd(sMrd);
								dblWblVOs[cnt].setBatchflg("N");
								dblWblVOs[cnt].setTmplparam(sbParam.toString());
								dblWblVOs[cnt].setTmplmrdpdf("NYKS_" + bkgBlNoVO.getBlNo() + ".pdf");
								dblWblVOs[cnt].setItr("|$$|");
								dblWblVOs[cnt].setNtcKndCd(bkgEmlEdtVO.getEdtNtcKndCd());
								dblWblVOs[cnt].setHiddOpt("N");
								dblWblVOs[cnt].setFrtAllFlg("1".equalsIgnoreCase(sLevel)?"Y":"N");
								dblWblVOs[cnt].setFrtCltFlg("5".equalsIgnoreCase(sLevel)?"Y":"N");
								dblWblVOs[cnt].setFrtPpdFlg("4".equalsIgnoreCase(sLevel)?"Y":"N");
								dblWblVOs[cnt].setFrtChgFlg("6".equalsIgnoreCase(sLevel)?"Y":"N");
								dblWblVOs[cnt].setFrtArrFlg("N");
								cnt++;
							}
						}
						
		                for (DblWblVO vo : dblWblVOs) {
		                	if(null != vo.getTmplmrd()){
		                		for (String s :  vo.getTmplmrd   ().split("\\|\\$\\$\\|")) { arrTmplMrd   .add(s); }
		                	 }
			                if(null != vo.getTmplparam()){	
			                	for (String s :  vo.getTmplparam ().split("\\|\\$\\$\\|")) { arrTmplParam .add(s); }
			                }
			                if(null != vo.getTmplmrdpdf()){
			                	for (String s :  vo.getTmplmrdpdf().split("\\|\\$\\$\\|")) { arrTmplMrdPdf.add(s); }
			                }
			            	log.debug("####### [size] ###########"+arrTmplParam.size());
			            	
			            	xptVOs = new ArrayList<ComRptDsgnXptInfoVO>(arrTmplParam.size());
			                for (int j=0; j < arrTmplParam.size(); j++) {
			                	xptVO = new ComRptDsgnXptInfoVO();
			                	log.debug("##################"+arrTmplMrd.get(j));
			                	log.debug("##################"+arrTmplParam.get(j));
			                	log.debug("##################"+arrTmplMrdPdf.get(j));
			                	
			                	
			                	xptVO.setRdTmpltNm(arrTmplMrd.get(j));           // *.mrd name
			                	xptVO.setRdParaCtnt(arrTmplParam.get(j));  // *.mrd parameter
			                	xptVO.setXptFileNm(arrTmplMrdPdf.get(j));   // Will be changed file name when *.mrd attach
			                	xptVO.setCreUsrId(account.getUsr_id());
			                	xptVO.setUpdUsrId(account.getUsr_id());
			                	xptVO.setXptFileTpCd("5");
			                    xptVOs.add(xptVO);
			                }
		                }
		                
						bkgEmlEdtVO.setEdtToEml(searchBlPrintRcvEmlVOs.get(0).getUsrEml());
						
		    			String sUsrEml = null;
		    			BookingUtil util = null;
		    			ComUserVO comUserVO = null;
		    			util = new BookingUtil();
		                comUserVO = util.searchComUserInfo(account.getUsr_id()); 
		                
		    			if (null!=comUserVO) {
		    				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
		    			}
						
						mailInfo.setSysCd("BKG");
						mailInfo.setTmplMrd(dblWblVOs[0].getTmplmrd());
						mailInfo.setBatchFlg("N");
						mailInfo.setTmplParam(dblWblVOs[0].getTmplparam());
						mailInfo.setSndNm(account.getUsr_nm());
						
						senderMailAddr = senderMailAddr.equals("") ? sUsrEml:senderMailAddr;
						
						mailInfo.setSndEml(senderMailAddr);
						if(bkgEmlEdtVO != null && "noreply@nykline.com".equals(bkgEmlEdtVO.getEdtFromEml())){
							mailInfo.setSndNm("");
							mailInfo.setSndEml("noreply@nykline.com");
						}
						mailInfo.setRcvEml(searchBlPrintRcvEmlVOs.get(0).getUsrEml());
						mailInfo.setCrtUserId(account.getUsr_id());
						mailInfo.setFileKey("");
						mailInfo.setTmplMrdPdf("NYKS"+bkgBlNoVO.getBlNo()+".pdf");
						mailInfo.setTitle(title); // title
						
						title = dblWblVOs[0].getTitle();
						mailInfo.setTitle(title); // title
						mailInfo.setContents(contentsParam); // contents
	                	String vslNm = this.searchVesselNameByBkgNo(bkgBlNoVO.getBkgNo());
						strBlNoTitle = strBlNoBody = bkgBlNoVO.getBlNo();
	                	
	                	
	                    contentsParam = !StringUtils.isEmpty(dblWblVOs[0].getContents()) ? dblWblVOs[0].getContents() : "blNoTitle;T/VVD : "+vslNm+" / B/L No : NYKS"+strBlNoTitle+"@@blNoBody;NYKS"+strBlNoBody+"@@blRemark;"+strBlRemark;
	                    mailInfo.setTitle(title);
	    				mailInfo.setContents(contentsParam);
						
						String retEmailSndId = null;
	                    retEmailSndId = bleaiDao.sendReportDesignerWithFiles(mailInfo, bkgEmlEdtVO, xptVOs);
	                    
	                    strNBkgNo = new StringTokenizer(bkgBlNoVO.getBkgNo(), "|");  // separator is "|" in case of many BKG_NO in one BL 
	                    while (strNBkgNo.hasMoreTokens()) {
	                        bkgNtcHisVO = new BkgNtcHisVO();
	                        bkgNtcHisVO.setBkgNo(strNBkgNo.nextToken());
	                        bkgNtcHisVO.setNtcViaCd("M");
	                        bkgNtcHisVO.setNtcKndCd("ES");  // NTC_KND_CD(BL:Outbound,NN:Inbound,WB:Waybill)  
	                        bkgNtcHisVO.setAgnCd("");
	                        bkgNtcHisVO.setNtcFomCd("");
	                        bkgNtcHisVO.setNtcSeq("");
	                        bkgNtcHisVO.setBkgCustTpCd("");
	                        bkgNtcHisVO.setCustCntcTpCd("");
	                        bkgNtcHisVO.setNtcEml(searchBlPrintRcvEmlVOs.get(0).getUsrEml());
	                        bkgNtcHisVO.setSndId(retEmailSndId);
	                        bkgNtcHisVO.setFrtHdnFlg("N");
	                        bkgNtcHisVO.setFrtAllFlg(dblWblVOs[0].getFrtAllFlg());
	                        bkgNtcHisVO.setFrtCltFlg(dblWblVOs[0].getFrtCltFlg());
	                        bkgNtcHisVO.setFrtPpdFlg(dblWblVOs[0].getFrtPpdFlg());
	                        bkgNtcHisVO.setFrtChgFlg(dblWblVOs[0].getFrtChgFlg());
	                        bkgNtcHisVO.setFrtArrFlg(dblWblVOs[0].getFrtArrFlg());
	                        bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
	                        bkgNtcHisVO.setSndUsrId(account.getUsr_id());
	                        bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
	                        bkgNtcHisVO.setDiffRmk("");
	                        bkgNtcHisVO.setCreUsrId(account.getUsr_id());
	                        bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
	                        bkgNtcHisVOs.add(bkgNtcHisVO);
	                    }
						bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_09");
							
					}
				}
			}

		}catch(Exception ex){
			throw ex;
		}
	}
	/**
	 * Booking data information retrieve for Email.(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param String bkgNo
	 * @return EmlBkgInfoVO
	 * @exception EventException
	 */
	public EmlBkgInfoVO searchEmlBkgInfo(String bkgNo) throws EventException {
		try {
			return dbDao.searchEmlBkgInfo(bkgNo);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	    
	/**
	 * Check BL Complete Mail is already sent or not(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param SearchBlNtcHisVO searchBlNtcHisVO
	 * @return SearchBlNtcHisVO
	 * @exception EventException
	 */
	public SearchBlNtcHisVO searchBlNtcHis(SearchBlNtcHisVO searchBlNtcHisVO) throws EventException {
		try {
			return dbDao.searchBlNtcHis(searchBlNtcHisVO);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * get email receiver address(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param SearchRcvEmlVO searchRcvEmlVO
	 * @return SearchRcvEmlVO
	 * @exception EventException
	 */
	public List<SearchRcvEmlVO> searchRcvEml(SearchRcvEmlVO searchRcvEmlVO) throws EventException {
		try {
			return dbDao.searchRcvEml(searchRcvEmlVO);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
			
	
	/**
	 * Manage WBL_PRN_FLG relation info of BKG_BL_ISS table .<br>
	 * ESM_BKG_0743		
	 * 
	 * @param BlIssInfoVO blIssInfoVO
	 * @param String viaCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyWaybillFlg(BlIssInfoVO blIssInfoVO, String viaCd, SignOnUserAccount account)  throws EventException {
		SeaWayBillPrintVO seaWayBillPrintVO = new SeaWayBillPrintVO();
		
		try {
			seaWayBillPrintVO = dbDao.searchSeaWayBillPrint(blIssInfoVO.getBkgNo());
			if(seaWayBillPrintVO != null){
				seaWayBillPrintVO.setAuthOfcCd(account.getOfc_cd());
				seaWayBillPrintVO.setAuthUsrId(account.getUsr_id());
				seaWayBillPrintVO.setInetBlSndViaCd(viaCd);
				seaWayBillPrintVO.setOblKnt("0");
				seaWayBillPrintVO.setCpyKnt("0");
				seaWayBillPrintVO.setWblPrnKnt("1");
				seaWayBillPrintVO.setDocEcdProcFlg("N");
				seaWayBillPrintVO.setPrnCustTpCd("O");
				seaWayBillPrintVO.setPrnUsrId(account.getUsr_id());
				seaWayBillPrintVO.setAuthLginFlg("N");
				seaWayBillPrintVO.setDeltFlg("N");
				seaWayBillPrintVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.modifySeaWayBillPrint(seaWayBillPrintVO);
				
				dbDao.addSeaWayBillPrint(seaWayBillPrintVO);
			}
			
			dbDao.modifyWaybillFlg(blIssInfoVO);
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
	}
	
    /**
     * INVOICEBL EDI SEND
     * 
     * @author 
     * @param DblEdiInVO dblEdiInVO
     * @param SignOnUserAccount account
     * @return DblEdiVO
     * @exception EventException
     */
    public DblEdiVO createInvoiceBlEdi(DblEdiInVO dblEdiInVO, SignOnUserAccount account) throws EventException {

        BookingUtil utilCmd = new BookingUtil();

        DblEdiVO dblEdiOutVO = new DblEdiVO();
        
        try {

            BkgBlNoVO bkgBlNoIn = new BkgBlNoVO();
            String bkgNo = dblEdiInVO.getBkgNo();
            bkgBlNoIn.setBkgNo(dblEdiInVO.getBkgNo());
            bkgBlNoIn.setBlNo(dblEdiInVO.getBlNo());
    		bkgBlNoIn.setCaUsrId(account.getUsr_id());

            String ec_edircv_id_old = null;
            
            ec_edircv_id_old = (dblEdiInVO.getEdiReceiveId() == null) ? "" : dblEdiInVO.getEdiReceiveId();
            
            log.debug("#####################################################");
            log.debug("ec_edircv_id_old : " + ec_edircv_id_old);
            log.debug("#####################################################");
            
            BkgBlNoVO bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIn);
            if(bkgBlNoOut == null) {
                throw new EventException(new ErrorHandler("BKG01049", bkgNo).getMessage());
            }
	            
            log.debug("#####################################################");
            log.debug(" Flat File start ");
            log.debug("#####################################################");
            StringBuffer sbuff = null;
            List<FlatFileAckVO> flatFileAckVOs = new ArrayList<FlatFileAckVO>();
            	
            sbuff = new StringBuffer();
            dblEdiInVO.setEdiReceiveId(ec_edircv_id_old);
            
            // Sender Id
            String strSndrId = null;
            
            dblEdiInVO.setTmpCnt("1");
            strSndrId = dbDao.searchEdiSndr1(dblEdiInVO);
            if(strSndrId == null) strSndrId = dbDao.searchEdiSndr2(dblEdiInVO);
            
            // Header
            String strEdiHeader = utilCmd.searchEdiHeader(strSndrId, ec_edircv_id_old, "INVOICEBL");
            log.debug("\n******************** edi_header ********************\n" + strEdiHeader);
            sbuff.append(strEdiHeader + "\n");
            sbuff.append("{INVOICEBL\n");
            
            String strInvInfo = null;
            
            strInvInfo = dbDao.searchInvInfo(dblEdiInVO);
            log.debug("\n******************** strInvInfo ********************\n" + strInvInfo);
            sbuff.append(strInvInfo);
            
            String strRefInfo = null;
            
            strRefInfo = dbDao.searchInvRefInfo(dblEdiInVO);
            log.debug("\n******************** strRefInfo ********************\n" + strRefInfo);
            sbuff.append(strRefInfo);
            
            String tmpCntrDesc = "{CNTR_INFO\n"
                    + "CNTRNBR:\n"
                    + "CNTRTYPE:\n"
                    + "POR_HAUL_CD:\n"
                    + "POD_HAUL_CD:\n";
 
            List<DblEdiCntrVO> cntrList = dbDao.searchInvoiceEdiCntr(dblEdiInVO);
            int cntrCnt = cntrList == null ? 0 : cntrList.size();
            if(cntrCnt > 0){
            	for(int m=0;m<cntrCnt;m++){
            		DblEdiCntrVO ediCntrVO = cntrList.get(m);

			         log.debug("\n******************** cntr ********************\n" + ediCntrVO.getBkgCntr());
			         sbuff.append((ediCntrVO.getBkgCntr()==null || ediCntrVO.getBkgCntr().equals(""))?tmpCntrDesc:ediCntrVO.getBkgCntr());
			         
			         String strCntrSeal = dbDao.searchInvoiceEdiCntrSeal(dblEdiInVO, ediCntrVO.getCntrNo());
			         log.debug("\n******************** cntr_seal ********************\n" + strCntrSeal);
			         sbuff.append(strCntrSeal);
			         
			         String strCntrChgInfo = dbDao.searchInvoiceEdiCntrChgInfo(dblEdiInVO, ediCntrVO.getCntrNo());
			         log.debug("\n******************** searchInvoiceEdiCntrChgInfo ********************\n" + strCntrChgInfo);
			         sbuff.append(strCntrChgInfo);
			         
			         String strCntrMf = dbDao.searchInvoiceEdiCntrMf(dblEdiInVO, ediCntrVO.getCntrNo());
			         log.debug("\n******************** cntr_mf ********************\n" + strCntrMf);
			         sbuff.append(strCntrMf);
			         
			         sbuff.append("}CNTR_INFO\n");

            	}
            }else{
			     sbuff.append(tmpCntrDesc);
			     sbuff.append("{PKG_INFO\n"
			             + "PKG_LVL:\n"
			             + "PKG_QTY:\n"
			             + "PKG_UNIT:\n"
			             + "PKG_UNIT_DESC:\n"
			             + "}PKG_INFO\n"
			             + "{MEA_INFO\n"
			             + "MEA_UNIT:\n"
			             + "MEA_QTY:\n"
			             + "}MEA_INFO\n"
			             + "{SEAL_INFO\n"
			             + "SEAL_NO:\n"
			             + "}SEAL_INFO:\n"
			             + "{CNTR_CHARGE_INFO\n"
			             + "CHARGE_CD:\n"
			             + "CHARGE_DESC:\n"
			             + "CHARGE_TP_NM:\n"
			             + "CHARGE_CURR:\n"
			             + "CHARGE_AMT:\n"
			             + "CHARGE_AMT_USD:\n"
			             + "INV_CURR:\n"
			             + "INV_CURR_AMT:\n"
			             + "INV_TAX:\n"
			             + "INV_CURR_TTL_AMT:\n"
			             + "LOCAL_CURR:\n"
			             + "LOCAL_CURR_AMT:\n"
			             + "LOCAL_TAX:\n"
			             + "LOCAL_CURR_TTL_AMT:\n"
			             + "FRT_IND:\n"
			             + "RATED_AS:\n"
			             + "RATE:\n"
			             + "INV_EX_RATE:\n"
			             + "TAX_RATE:\n"
			             + "PERTYPE:\n"
			             + "TARIFF:\n"
			             + "}CNTR_CHARGE_INFO\n"
			             + "{CM_INFO\n"
			             + "CMD_CD:\n"
			             + "CMD_DESC:\n"
			             + "{PKG_INFO\n"
			             + "CM_PKG_LVL:\n"
			             + "CM_PKG_UNIT:\n"
			             + "CM_PKG_UNIT_DESC:\n"
			             + "}PKG_INFO\n"
			             + "{MEA_INFO\n"
			             + "CM_MEA_TP_CD:\n"
			             + "CM_MEA_UNIT:\n"
			             + "CM_MEA_QTY:\n"
			             + "}MEA_INFO\n"
			             + "}CNTR_INFO\n");
            	}
           
            String strInvVslInfo = null;
            
            strInvVslInfo = dbDao.searchInvoiceVslInfo(dblEdiInVO);
            log.debug("\n******************** strInvVslInfo ********************\n" + strInvVslInfo);
            sbuff.append(strInvVslInfo);
            
            String strInvLocInfo = null;
            
            strInvLocInfo = dbDao.searchInvoiceLocInfo(dblEdiInVO);
            log.debug("\n******************** strInvLocInfo ********************\n" + strInvLocInfo);
            sbuff.append(strInvLocInfo);
            
            String strInvCustInfo = null;
            
            strInvCustInfo = dbDao.searchInvoiceCustInfo(dblEdiInVO);
            log.debug("\n******************** strInvCustInfo ********************\n" + strInvCustInfo);
            sbuff.append(strInvCustInfo);
            
            String strInvChgInfo = null;
            
            strInvChgInfo = dbDao.searchInvoiceChgInfo(dblEdiInVO);
            log.debug("\n******************** strInvChgInfo ********************\n" + strInvChgInfo);
            sbuff.append(strInvChgInfo);
            
            sbuff.append("}INVOICEBL\n");
            
                log.debug("#####################################################");
                log.debug(" Flat File end ");
                log.debug("#####################################################");
                /* EDI sending */
                log.debug("#####################################################");
                log.debug(" EDI sending start ");
                log.debug("#####################################################");
                SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
                sendFlatFileVO.setFlatFile(sbuff.toString());
                sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_CUSTOMER_INVOICE.IBMMQ.QUEUE"));
                FlatFileAckVO flatFileAckVO = utilCmd.sendFlatFile(sendFlatFileVO);
                log.debug("#####################################################");
                log.debug(" EDI sending end : " + ("A".equals(flatFileAckVO.getAckStsCd()) ? "Success!" : "Fail!"));
                log.debug("#####################################################");  
                flatFileAckVOs.add(flatFileAckVO);
                if ("E".equals(flatFileAckVO.getAckStsCd())){
                      throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
                }
                
            dblEdiOutVO.setFlatFileAckVOs(flatFileAckVOs);

        } catch(EventException ex) {
			throw ex;	
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        
        return dblEdiOutVO;
    }

	/**
	 * get email receiver address(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param String bkgNO
	 * @return List<SearchBlCompleteRcvEmlVO>
	 * @exception EventException
	 */
	public List<SearchBlCompleteRcvEmlVO> searchBlCompleteRcvEml(String bkgNO) throws EventException {
		try {
			return dbDao.searchBlCompleteRcvEml(bkgNO);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * get email receiver address(ESM_BKG_0079_09)<br>
	 *
	 * @author Maeda
	 * @param String bkgNO
	 * @param String emlFlg
	 * @return List<SearchBlPrintRcvEmlVO>
	 * @exception EventException
	 */
	public List<SearchBlPrintRcvEmlVO> searchBlPrintRcvEml(String bkgNO, String emlFlg) throws EventException {
		try {
			return dbDao.searchBlPrintRcvEml(bkgNO, emlFlg);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_1074 : E-mail Template Read
	 * <br>
	 * 
	 * @author	
	 * @param 	String bkgNo
	 * @param 	String templateFile
	 * @return  String[]
	 * @exception 	Exception
	 */
	public String[] searchEmlTemplate(String bkgNo, String templateFile) throws Exception{
        String outRead = null;
        Hashtable<String,String> templateArgs = null;
        EmlBkgInfoVO emlBkgInfoVO = null;
        BookingUtil util = null;
        String sysHost = null;	//host file setting
        
		try {

            util = new BookingUtil();

			//get template
			outRead = FileUtils.fileReader(SiteConfigFactory.get("COM.CLT.JAF.MAIL.TEMPLATE.DIR"), templateFile);

			//system host location
			sysHost = SubSystemConfigFactory.get("ESM.BKG.ECOM.URL");
			log.debug("#########[host] "+sysHost+" #########");
			
            //get transaction data to set in e-mail
			emlBkgInfoVO = searchEmlBkgInfo(bkgNo);

			//set transaction values
			templateArgs = new Hashtable<String,String>();
			templateArgs.put("bkgNo",emlBkgInfoVO.getBkgNo());
			templateArgs.put("refNo",emlBkgInfoVO.getRefNo());
			templateArgs.put("por",emlBkgInfoVO.getPor());
			templateArgs.put("pod",emlBkgInfoVO.getPod());		
			templateArgs.put("onBoardDate",emlBkgInfoVO.getBlObrdDt());
			templateArgs.put("shprName",emlBkgInfoVO.getShprNm());
			templateArgs.put("vvd",emlBkgInfoVO.getVvd());
			templateArgs.put("blNo",emlBkgInfoVO.getBlNo());
			templateArgs.put("sysHost",sysHost);	//host file setting
			outRead = util.parseTemplate(outRead,templateArgs);
			
			String[] template = new String[2];
			template[0] = util.getTemplatePart(outRead, "title");
			template[1] = util.getTemplatePart(outRead, "body");
			
			return  template;
		} catch(Exception ex) {
			throw ex;  			
		}		
	}	
	
	/**
	 * BlCaluse 鈺곌퀬�돳
	 * @param BlRemarkVO blRemakVO
	 * @return BlRemarkVO
	 * @throws EventException
	 */
	public BlRemarkVO searchBlClauseInfo(BlRemarkVO blRemakVO) throws EventException{
		BlRemarkVO reVO = new BlRemarkVO();
		try{
			// customerClause
			reVO.setCus(dbDao.searchBlClauseInfo(blRemakVO.getBkgNo()));
			
			// countryClause
			String podCd = blRemakVO.getPodCd();
			String porCd = blRemakVO.getPorCd();
			String polCd = blRemakVO.getPolCd();
			String delCd = blRemakVO.getDelCd();
			
			reVO.setCnt(dbDao.searchBlCntClause(porCd, polCd, podCd, delCd));
/*
	        if(podCd !=null && podCd.length()> 2 && "BR".equals(podCd.substring(0, 2))){
	        	reVO.setCnt(Constants.CMDT_DESC_ATTD_BR); 
	        }
	        if(podCd !=null && podCd.length()> 2 && ("UY".equals(podCd.substring(0, 2)) || "AR".equals(podCd.substring(0, 2)))){
	        	reVO.setCnt(Constants.CMDT_DESC_ATTD_UY);
	        }
	        if((porCd !=null && porCd.length()> 2 && "MX".equals(porCd.substring(0, 2))) ||
	           (polCd !=null && polCd.length()> 2 && "MX".equals(polCd.substring(0, 2))) ||
	           (podCd !=null && podCd.length()> 2 && "MX".equals(podCd.substring(0, 2))) ||
	           (delCd !=null && delCd.length()> 2 && "MX".equals(delCd.substring(0, 2)))){
	        	reVO.setCnt(Constants.CMDT_DESC_ATTD_MX);
	        }
	        if((delCd !=null && delCd.length() >= 5 && !"GTPRQ".equals(delCd.substring(0, 2))) &&
	           (porCd !=null && porCd.length() >= 2 && "GT".equals(porCd.substring(0, 2))) ||
	           (polCd !=null && polCd.length() >= 2 && "GT".equals(polCd.substring(0, 2))) ||
	           (podCd !=null && podCd.length() >= 2 && "GT".equals(podCd.substring(0, 2))) ||
	           (delCd !=null && delCd.length() >= 2 && "GT".equals(delCd.substring(0, 2)))){
	        	reVO.setCnt(Constants.CMDT_DESC_ATTD_GT);
	        }
	        
	        if((podCd !=null && podCd.length() >= 2 && "GR".equals(podCd.substring(0,2))) ||
	           (delCd !=null && delCd.length() >= 2 && "GR".equals(delCd.substring(0,2)))){
	        	reVO.setCnt(Constants.CMDT_DESC_ATTD_GR);
	        }
	        if((podCd !=null && podCd.length() >= 2 && "EG".equals(podCd.substring(0,2))) ||
	           (delCd !=null && delCd.length() >= 2 && "EG".equals(delCd.substring(0,2)))){
	        	reVO.setCnt(Constants.CMDT_DESC_ATTD_EG);
	        }
*/	        
	        //remark
	        reVO.setRmk(dbDao.searchBlRemark(blRemakVO.getBkgNo()));
		} catch(DAOException ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
		return reVO;
	}	

	/**
	 * ESM_BKG_0079_09 : SWB Release button click<br>
	 * <br>
	 * 
	 * @author	
	 * @param 	String bkgNo
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
	 * @param 	String fileDownPath
	 * @param	String issType			: 'SWB'->SWB Release button,'BLD'->B/L DATA COMPLETE
	 * @exception 	Exception
	 */
	public void sendBlRDFtp(String bkgNo, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account, String fileDownPath, String issType) throws Exception {

		BookingUtil utilBC = null;
//		BookingHistoryMgtBC bkgHisCmd = null;
//		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		StringBuilder sbParam = null;
		String sType = null;
		String sLevel = null;
		String sMrd = null;
		BkgRouteVO bkgRouteVO = null;
        List<BlPrintRcvFtpVO> blPrintRcvFtpVOs = null;
        String japanStampValue = "";
        BkgBlNoVO esigVO = null;
        String blEsigFlg = "";
        String blCpyEsigFlg = "";
        FtpMetaInfo ftpMetaInfo = new FtpMetaInfo();
        RdApplCdFtpVO rdApplCdFtp = new RdApplCdFtpVO();
        
		try {
			blPrintRcvFtpVOs = dbDao.searchBlPrintRcvFtp(bkgNo, issType);

			if(blPrintRcvFtpVOs != null){
				if(blPrintRcvFtpVOs.size()>0){
					utilBC = new BookingUtil();
//					bkgHisCmd = new BookingHistoryMgtBCImpl();
	
					for(BlPrintRcvFtpVO rcvFtpVO: blPrintRcvFtpVOs){
						sType = sLevel = sMrd = "";
						sbParam = new StringBuilder();
						bkgRouteVO = utilBC.searchBkgRoute(bkgNo);
						
						if(issType.equals("SWB")){
							//japan stamp check
							japanStampValue = utilBC.checkJapanStamp(bkgNo);
							esigVO = utilBC.searchEsigAgent(bkgNo);
							if(esigVO == null){
								blEsigFlg = "";
								blCpyEsigFlg = "";
							}else{
								blEsigFlg = esigVO.getBlEsigFlg();
								blCpyEsigFlg = esigVO.getBlCpyEsigFlg();
							}
						}
						
						if(issType.equals("SWB")){
							sType="5";		//Sea Waybill
						}else if(issType.equals("BLD")){
							sType="2";		//Non-Negotiable B/L
						}
						if (0==bkgRouteVO.getPorCd().indexOf("US")) {
							sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
						} else {
							sMrd="ESM_BKG_0109_OBL_A4.mrd";
						}
						rdApplCdFtp = dbDao.searchRdApplCdFtp(sMrd);
						if(rdApplCdFtp==null)		continue;
			
						sLevel="1";
						
						sbParam.append("/rv");
						sbParam.append(" form_bkgNo[('").append(bkgNo).append("')]");
						sbParam.append(" form_type[").append(sType).append("]");
						sbParam.append(" form_dataOnly[N]");
						sbParam.append(" form_manifest[N]");
						sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
						sbParam.append(" form_hiddeData[N]");
						sbParam.append(" form_level[(").append(sLevel).append(")]");
						sbParam.append(" form_remark[]");
						sbParam.append(" form_Cntr[1]");
						sbParam.append(" form_mainOnly[N]");
						sbParam.append(" form_CorrNo[]");
						sbParam.append(" form_his_cntr[BKG_CONTAINER]");
						sbParam.append(" form_his_bkg[BKG_BOOKING]");
						sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
						sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
						sbParam.append(" form_his_bl[BKG_BL_DOC]");
						sbParam.append(" isEncode[Y]");
						sbParam.append(" form_rqst_via_cd[").append(japanStampValue).append("]"); 
						sbParam.append(" form_his_bl_mkd[BKG_BL_ISS]");		
						sbParam.append(" form_esig[").append(blEsigFlg).append("]");
						sbParam.append(" form_cpy_esig[").append(blCpyEsigFlg).append("]");
						sbParam.append(" form_knt_flg[]");
						sbParam.append(" form_count[]");
						sbParam.append(" form_path[" + fileDownPath + "]");
						sbParam.append(" /rp []");
						sbParam.append(" /riprnmargin");
						
						ftpMetaInfo = new FtpMetaInfo();
						ftpMetaInfo.setCreUsrId(account.getUsr_id());
						ftpMetaInfo.setFtp_svr_ip(rcvFtpVO.getFtpSvrNm());
						ftpMetaInfo.setFtp_usr_id(rcvFtpVO.getFtpSvrUsrNm());
						ftpMetaInfo.setFtp_usr_pw(rcvFtpVO.getFtpSvrPwd());
						ftpMetaInfo.setFtp_dir_ctnt(rcvFtpVO.getFtpSvrDirNm()+rcvFtpVO.getFtpFile() + ".pdf");
						ftpMetaInfo.setSys_cd(rdApplCdFtp.getRdSubSysCd());
						ftpMetaInfo.setTmplMrd(rdApplCdFtp.getRdApplCd());
						ftpMetaInfo.setParaInfoCtnt(sbParam.toString());
						
						log.debug("===============================================================");
						log.debug("[[ ftpMetaInfo Ftp_dir_ctnt]] "+ftpMetaInfo.getFtp_dir_ctnt());
						log.debug("[[ ftpMetaInfo TmplMrd]] "+ftpMetaInfo.getTmplMrd());
						log.debug("[[ ftpMetaInfo ParaInfoCtnt]] "+ftpMetaInfo.getParaInfoCtnt());
						log.debug("===============================================================");
						
						bleaiDao.sendFileRpt(ftpMetaInfo);
					}
				}
			}
		}catch(Exception ex){
			throw ex;
		}
	}
	
	/**
	 * ESM_BKG_0079_09 : Receive FTP (VIP)<br>
	 * <br>
	 * 
	 * @author	
	 * @param 	String bkgNo
	 * @return  List<BlPrintRcvFtpVO>
	 * @exception 	Exception
	 */
	public List<BlPrintRcvFtpVO> searchBlPrintGrpRcvFtp(String bkgNo) throws EventException {
		List<BlPrintRcvFtpVO> blPrintRcvFtpVOs = null;
        try {
        	blPrintRcvFtpVOs = dbDao.searchBlPrintGrpRcvFtp(bkgNo);
        	
        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return blPrintRcvFtpVOs;
	}
	
	
    /**
     * Draft BL 占쎌읈占쎈꽊占쎌뱽 占쎌맄占쎈립 REMARK�몴占� 鈺곌퀬�돳占쎈립占쎈뼄.<br>
     * 
     * @param String bkgNo
     * @return List<DblWblVO>
     * @exception EventException
     */
    public List<DblWblVO> searchDblRemarkByBkgNo(String bkgNo) throws EventException {
        List<DblWblVO> list = null;
        try {
        	list = dbDao.searchDblRemarkByBkgNo(bkgNo);
        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return list;
    }	
    
    /**
     * ESM_BKG_0278 Group Email event processing -- testing...
     * Email send
     *
     * @param DblWblVO[] dblWblVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendGroupBLEmail(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException {
        List<BkgNtcHisVO> bkgNtcHisVOs = null;
        MailSendVO mailInfo = null;
        String retEmailSndId = null;
        List<ComRptDsgnXptInfoVO> xptVOs = new ArrayList<ComRptDsgnXptInfoVO>();
        ComRptDsgnXptInfoVO xptVO = null;
        SimpleDateFormat format = null;
//        StringBuilder sbBlNos = null;
        String strBlNoTitle = null;
        String title = null;
        String contentsParam = null;
//        int cnt = 0;
        BookingUtil util = null;
		ComUserVO comUserVO = null;
		
        try {
            util = new BookingUtil();
			// modify  account.getUsr_Eml() -> getDfltEml()
            comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
		
            bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            format = new SimpleDateFormat("yyyyMMddHHmmss");
            String toMailAddr = bkgEmlEdtVO.getEdtToEml();
            bkgEmlEdtVO.setEdtToEml("");	// vo 珥덇린�솕
            
            int idx = 0;
            xptVOs = new ArrayList<ComRptDsgnXptInfoVO>();//Null Referencing
            
//            cnt = -1;
//            sbBlNos = new StringBuilder();
            
//            for(int i=0; i < dblWblVOs.length; i++){
//				sbBlNos.append(dblWblVOs[i].getBlNo()).append(", ");
//				cnt++;
//            }

            for(int i=0; i < dblWblVOs.length; i++){
            	xptVO = new ComRptDsgnXptInfoVO();
            	xptVO.setRdTmpltNm(dblWblVOs[i].getTmplmrd());
            	xptVO.setRdParaCtnt(dblWblVOs[i].getTmplparam());
            	xptVO.setXptFileNm(dblWblVOs[i].getTmplmrdpdf()+".pdf");
            	xptVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
            	xptVO.setCreUsrId(account.getUsr_id());
            	xptVO.setUpdUsrId(account.getUsr_id());
            	xptVOs.add(xptVO);
            	if(0==idx++){
            		strBlNoTitle = dblWblVOs[i].getTmplmrdpdf();//setTmplmrdpdf
            	}
            }
            
			title = strBlNoTitle;
			contentsParam = strBlNoTitle;
			log.debug("[email title]-------->"+title);
				
            // Email sending
            mailInfo = new MailSendVO();
			mailInfo.setSysCd("BKG");
			mailInfo.setBatchFlg("N");
			mailInfo.setSndNm("");
			mailInfo.setSndEml(sUsrEml);
			mailInfo.setRcvEml(toMailAddr);
			mailInfo.setCrtUserId(account.getUsr_id());
			mailInfo.setFileKey("");
			mailInfo.setTmplMrdPdf(strBlNoTitle+".pdf");
			mailInfo.setTitle(title); // title
			mailInfo.setContents(contentsParam); // contents
			mailInfo.setCcEml("");
			
			retEmailSndId = bleaiDao.sendReportDesignerWithFiles(mailInfo, bkgEmlEdtVO, xptVOs);
			
			log.debug("[sendId]-------->"+retEmailSndId);
			
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }
    
    /**
     * ESM_BKG_0726 modify B/L(onboard date, issue date etc) by group<br>
     * @param GrpBlDtVO grpBlDtVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String modifyGroupBlUpdate(GrpBlDtVO grpBlDtVO, SignOnUserAccount account) throws EventException{
    	BackEndJobManager backEndJobManager = null;
    	BLIssuanceBackEndJob backEndJob = null;
    	String jobID = null;
    	try {
    		backEndJobManager = new BackEndJobManager();
    		backEndJob = new BLIssuanceBackEndJob(grpBlDtVO, account);
    		jobID = backEndJobManager.execute(backEndJob, account.getUsr_id(), "BLIssuanceBackEndJob");
    		
    	} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return jobID;
    }
    
    /**
 	 * ESM_BKG_0726 modify B/L(onboard date, issue date etc) by group 결과를 BackEndJob 결과확인<br>
 	 * 
 	 * @param String key
 	 * @return String
 	 * @throws EventException
 	 */
 	public String searchGroupBlUpdateBackEndJobResult(String key) throws EventException {
 		String result = null;
 		try {
 			result = bleaiDao.searchGroupBlUpdateBackEndJobResult(key);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return result;
 	}
 	
    /**
     * Original Bill download 할때 insert BKG_INET_BL_PRN_AUTH
     * @param String bkgNo
     * @param String blNo
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public int createInetBlPrnAuth(String bkgNo, String blNo, SignOnUserAccount account) throws EventException{
    	int iInfoSeq = 0;
 		try {
 			
 			dbDao.deleteBlPrnAuth(bkgNo, account);
 			
 			dbDao.addInetBlPrnAuth(bkgNo, blNo, account);
 			iInfoSeq = dbDao.searchMaxInfoSeq(bkgNo);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return iInfoSeq;
    	
    }
    
    /**
     * Original Bill download 할때 insert BKG_INET_BL_PRN_AUTH
     * @param String[] bkgNos
     * @param String mBkgNo
     * @param String mBlNo
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public int createInetGroupBlPrnAuth(String[] bkgNos, String mBkgNo, String mBlNo, SignOnUserAccount account) throws EventException{
    	int iInfoSeq = 0;
 		try {
 			for(int i=0; i < bkgNos.length; i++){
 				dbDao.deleteBlPrnAuth(bkgNos[i], account);
 			}
 			
 			dbDao.addInetBlPrnAuth(mBlNo, mBlNo, account);
 			iInfoSeq = dbDao.searchMaxInfoSeq(mBkgNo);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return iInfoSeq;
    }

    
	/**
	 * Original B/L download
	 * @param String bkgNo
	 * @param String blNo
	 * @param String caYn
	 * @param String[] mrdFiles
	 * @param String[] mrdParams
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createOBL(String bkgNo, String blNo, String caYn, String[] mrdFiles, String[] mrdParams, SignOnUserAccount account) throws EventException{
		BLIssuanceBC command = new BLIssuanceBCImpl();
		BookingUtil  utilCmd = new BookingUtil();
		ReportDesignerExporter reportDesignerExporter = new ReportDesignerExporter();
		List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
//		String CFG_FILEOPEN_LOGURL_BASE = SubSystemConfigFactory.get("COM.CLT.FILEOPEN.DOMAIN") + "/"; 
//		String CFG_FILEOPEN_LOGURL_LOGPATH = SubSystemConfigFactory.get("COM.CLT.FILEOPEN.URL"); 
		
		String fileReturnKey = "";
		String sMrdFiles = "";
		String sMrdParams = "";
		String result = "";
		
		try{
			if(bkgNo== null || blNo== null)	return result;
			
			if(mrdFiles==null || mrdFiles.length == 0)		return result;
			if(mrdParams==null || mrdParams.length == 0)	return result;
			
			if(mrdFiles.length > 0){
				int infoSeq = 0;
				String authDt = "";
				String authFlag = "Y";
				
				String oblAuthPassCnt = utilCmd.checkOblAuthPass(account);
				int authPassCnt = Integer.parseInt(oblAuthPassCnt);
				if(authPassCnt>0){	//예외처리한다.
					authFlag = "N";
				}else{
					infoSeq = command.createInetBlPrnAuth(bkgNo, blNo, account);
					authDt = utilCmd.searchTimeLocalOfcFnc(account.getOfc_cd());//return YYYY-MM-DD HH24:MI:SS
				}
				
				
				if(authDt != null && authDt.length()>0){
					authDt = authDt.substring(0, 10).replace("-", "");
					log.debug("[authDt]"+authDt);
				}
	
				//보안 적용
//				String param_1 = "?authDt=" + authDt + "%26" + "bkgNo=" + bkgNo + "%26" + "infoSeq=" + infoSeq + "%26"+"f_cmd=" + FormCommand.SEARCH01;
				String param_1 = "?authDt=" + authDt + "%26" + "bkgNo=" + bkgNo + "%26" + "infoSeq=" + infoSeq; 
				String param_2 = authFlag;
				String param_3 = CFG_FILEOPEN_LOGURL_BASE;
				String param_4 = CFG_FILEOPEN_LOGURL_LOGPATH;
				
				String rdParam = " fileopen_flag[" + param_2 + "] ";
				rdParam += "fileopen_url[" + param_3+ "] ";
				rdParam += "fileopen_servlet[" + param_4+ "] ";
				rdParam += "fileopen_param[" + param_1+ "] ";
				
				log.debug("oblRdParam==>"+rdParam);	//보안 파라메터
				
				String inDate   = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
				String inTime   = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());
	
				for(int i=0; i< mrdFiles.length; i++){
					
					sMrdFiles = mrdFiles[i];
					if(sMrdFiles.equals("ESM_BKG_0109_OBL_A4.mrd") || sMrdFiles.equals("ESM_BKG_0109_OBL_LETTER.mrd"))
					{
						sMrdParams = mrdParams[i] + rdParam + "/rp [" + caYn + "] /riprnmargin /rmatchprndrv [3]"; 
						if (account.getOfc_cd().equals("BOMBB") || account.getOfc_cd().equals("DELBS") 
								|| account.getOfc_cd().equals("MAABS")) {
							sMrdParams += " /rpypos [25]";
						} // /rprncenteropt [1]
					}else{
						sMrdParams = mrdParams[i];
					}
					
	        		ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
	        		comRptDsgnXptInfoVO.setCreUsrId(account.getUsr_id());
	        		comRptDsgnXptInfoVO.setRdParaCtnt(sMrdParams);
	        		comRptDsgnXptInfoVO.setRdTmpltNm(sMrdFiles);
	        		comRptDsgnXptInfoVO.setXptFileNm("NYKS"+ blNo + "_original_"+inDate+inTime+".pdf");
	        		comRptDsgnXptInfoVO.setUpdUsrId(account.getUsr_id());
	        		comRptDsgnXptInfoVO.setXptFileTpCd("5");
	        		comRptDsgnXptInfoVO.setMsgQuNm("OLTP");
	        		comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
	        		
	        		log.debug("[OBL RD_PARAM]"+sMrdParams);
				}
	    		reportDesignerExporter.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
	    		fileReturnKey = reportDesignerExporter.export();
	    		
	    		if("Y".equals(authFlag)){
	    			dbDao.modifyFileSavId(bkgNo, fileReturnKey, String.valueOf(infoSeq), account);
	    		}
			}
    	} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}

		return fileReturnKey;
    }
	
	/**
	 * Original B/L download
	 * @param String fileKey
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String downLoadOBL(String fileKey, SignOnUserAccount account) throws EventException{
		BackEndJobManager backEndJobManager = null;
    	BLIssuanceOblBackEndJob backEndJob = null;
    	String jobID = null;
    	try {
    		backEndJobManager = new BackEndJobManager();
    		backEndJob = new BLIssuanceOblBackEndJob(fileKey);
    		jobID = backEndJobManager.execute(backEndJob, account.getUsr_id(), "BLIssuanceOblBackEndJob");
    		
    	} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return jobID;
    }
	
    /**
 	 * Original B/L download 결과를 BackEndJob 결과확인<br>
 	 * 
 	 * @param String key
 	 * @return String
 	 * @throws EventException
 	 */
 	public String searchDownLoadOBLBackEndJobResult(String key) throws EventException {
 		String result = null;
 		try {
 			result = bleaiDao.searchDownLoadOBLBackEndJobResult(key);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return result;
 	}	
 	
	/**
	 * Original Group B/L download
	 * @param String[] bkgNos
	 * @param String[] blNos
	 * @param String caYn
	 * @param String formType
	 * @param String[] mrdFiles
	 * @param String[] mrdParams
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createGBOBL(String[] bkgNos, String[] blNos, String caYn, String formType, String[] mrdFiles, String[] mrdParams, SignOnUserAccount account) throws EventException{
		BLIssuanceBC command = new BLIssuanceBCImpl();
		BookingUtil  utilCmd = new BookingUtil();
		ReportDesignerExporter reportDesignerExporter = new ReportDesignerExporter();
		List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
		String CFG_FILEOPEN_LOGURL_BASE = SubSystemConfigFactory.get("COM.CLT.FILEOPEN.DOMAIN") + "/"; 
		String CFG_FILEOPEN_LOGURL_LOGPATH = SubSystemConfigFactory.get("COM.CLT.FILEOPEN.URL"); 
		
		String fileReturnKey = "";
		String sMrdFiles = "";
		String sMrdParams = "";
		String result = "";
		String mainBkgNo = "";
		String mainBlNo = "";
		int mainInfoSeq = 0;
		String authFlag = "N";
		String fileName = "";
		
		try{
			if(bkgNos== null || bkgNos.length== 0)	return result;
			if(blNos== null || blNos.length == 0)	return result;
			
			if(mrdFiles==null || mrdFiles.length == 0)		return result;
			if(mrdParams==null || mrdParams.length == 0)	return result;
			
			if(mrdFiles.length > 0){
				int infoSeq = 0;
				mainBkgNo = bkgNos[bkgNos.length-1];
				mainBlNo  = blNos[blNos.length-1];
				
				if(formType.equals("4")){		//Original B/L
					String oblAuthPassCnt = utilCmd.checkOblAuthPass(account);
					int authPassCnt = Integer.parseInt(oblAuthPassCnt);
					if(authPassCnt>0){	//예외처리한다.
						authFlag = "N";
					}else{
						infoSeq = command.createInetGroupBlPrnAuth(bkgNos, mainBkgNo, mainBlNo, account);
						mainInfoSeq = infoSeq;
						authFlag = "Y";
					}
				}
				
				String authDt = utilCmd.searchTimeLocalOfcFnc(account.getOfc_cd());//return YYYY-MM-DD HH24:MI:SS
				if(authDt != null && authDt.length()>0){
					authDt = authDt.substring(0, 10).replace("-", "");
					log.debug("[authDt]"+authDt);
				}else{
					return null;
				}
	
				//보안 적용
//				String param_1 = "?authDt=" + authDt + "%26" + "bkgNo=" + bkgNo + "%26" + "infoSeq=" + infoSeq + "%26"+"f_cmd=" + FormCommand.SEARCH01;
				String param_1 = "?authDt=" + authDt + "%26" + "bkgNo=" + mainBkgNo + "%26" + "infoSeq=" + mainInfoSeq; 
				String param_2 = authFlag;
				String param_3 = CFG_FILEOPEN_LOGURL_BASE;
				String param_4 = CFG_FILEOPEN_LOGURL_LOGPATH;
				
				String rdParam = " fileopen_flag[" + param_2 + "] ";
				rdParam += "fileopen_url[" + param_3+ "] ";
				rdParam += "fileopen_servlet[" + param_4+ "] ";
				rdParam += "fileopen_param[" + param_1+ "] ";
				
				
				log.debug("oblRdParam==>"+rdParam);	//보안 파라메터
				
				String inDate   = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
				String inTime   = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());
				
				if(formType.equals("4")){
					fileName = "NYKS"+ mainBlNo + "_original_"+inDate+inTime+".pdf";
				}else if(formType.equals("5")){
					fileName = "NYKS"+ mainBlNo + "_seaway_"+inDate+inTime+".pdf";
				}else if(formType.equals("7")){
					fileName = "NYKS"+ mainBlNo + "_draft_"+inDate+inTime+".pdf";
				}else{
					fileName = "NYKS"+ mainBlNo + "_noncopy_"+inDate+inTime+".pdf";
				}
	
				for(int i=0; i< mrdFiles.length; i++){
					
					sMrdFiles = mrdFiles[i];
					if(sMrdFiles.equals("ESM_BKG_0109_OBL_A4.mrd") || sMrdFiles.equals("ESM_BKG_0109_OBL_LETTER.mrd"))
					{
						sMrdParams = mrdParams[i] + rdParam + "/rp [" + caYn + "] /riprnmargin /rmatchprndrv [3]"; 
						if (account.getOfc_cd().equals("BOMBB") || account.getOfc_cd().equals("DELBS") 
								|| account.getOfc_cd().equals("MAABS")) {
							sMrdParams += " /rpypos [25]";
						} // /rprncenteropt [1]
					}else{
						sMrdParams = mrdParams[i];
					}

//					sMrdFiles = mrdFiles[i];
//					sMrdParams = mrdParams[i] + rdParam + "/rp [" + caYn + "] /riprnmargin /rmatchprndrv [3]"; 
//					if (account.getOfc_cd() == "BOMBB" || account.getOfc_cd() == "DELBS" || account.getOfc_cd() == "MAABS") {
//						sMrdParams += " /rpypos [25]";
//					} // /rprncenteropt [1]
						
	        		ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
	        		comRptDsgnXptInfoVO.setCreUsrId(account.getUsr_id());
	        		comRptDsgnXptInfoVO.setRdParaCtnt(sMrdParams);
	        		comRptDsgnXptInfoVO.setRdTmpltNm(sMrdFiles);
	        		comRptDsgnXptInfoVO.setXptFileNm(fileName);
	        		comRptDsgnXptInfoVO.setUpdUsrId(account.getUsr_id());
	        		comRptDsgnXptInfoVO.setXptFileTpCd("5");
	        		comRptDsgnXptInfoVO.setMsgQuNm("OLTP");
	        		comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
	        		
	        		log.debug("[GROUP RD_PARAM]"+sMrdParams);
				}
	    		reportDesignerExporter.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
	    		fileReturnKey = reportDesignerExporter.export();
	    		
	    		if("Y".equals(authFlag)){
	    			dbDao.modifyFileSavId(mainBkgNo, fileReturnKey, String.valueOf(mainInfoSeq), account);
	    		}

	    		
			}
    	} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}

		return fileReturnKey;
    } 	
	

	/**
	 * BATCH 에서 EMAIL 전송처리
	 * @param String bkgNo
	 * @param MailSendVO mailInfo
	 * @param String params[]
	 * @param String emailType
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendEmailResultFTP(String bkgNo, MailSendVO mailInfo, String params[], String emailType, SignOnUserAccount account) throws EventException{
        BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
        List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
        String sendId = "";
        try{
			
			sendId = bleaiDao.sendEmailResultFTP(mailInfo, params, emailType);
			
			bkgNtcHisVO = new BkgNtcHisVO();
			bkgNtcHisVO.setBkgNo(bkgNo);
			bkgNtcHisVO.setNtcViaCd("M");
			bkgNtcHisVO.setNtcKndCd("6".equalsIgnoreCase(emailType) ? "TE" :"TU");
//			bkgNtcHisVO.setNtcSeq("0");
//			bkgNtcHisVO.setCustCntcTpCd("E0");
			bkgNtcHisVO.setSndId(sendId);
			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
			bkgNtcHisVO.setSndRqstDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			bkgNtcHisVO.setDiffRmk(params[0]);				//filename
			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
			bkgNtcHisVOs.add(bkgNtcHisVO);
        	
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;

	}
	
	/**
	 * FTP전송할 rd parameter값을 만든다.
	 * @param int maxCnt
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String sType
	 * @param String sLevel
	 * @param String japanStampValue
	 * @param String blEsigFlg
	 * @param String blCpyEsigFlg
	 * @param String blKntFlg
	 * @param String fileDownPath
	 * @param SignOnUserAccount account
	 * @param int mrdcnt
	 * @return String 
	 * @throws EventException
	 */
	public String getStringParaInfoCtnt(int maxCnt, BkgBlNoVO bkgBlNoVO, String sType, String sLevel, 
			String japanStampValue, String blEsigFlg, String blCpyEsigFlg, String blKntFlg, String fileDownPath, 
			SignOnUserAccount account, int mrdcnt) throws EventException {
		
		BookingUtil utilBC = new BookingUtil();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		StringBuffer sbParam = new StringBuffer();
		
		try{
		
			for(int y=0; y< maxCnt; y++ ){
				sbParam.append("/rv");
				sbParam.append(" form_bkgNo[('").append(bkgBlNoVO.getBkgNo()).append("')]");
				sbParam.append(" form_type[").append(sType).append("]");
				sbParam.append(" form_dataOnly[N]");
				sbParam.append(" form_manifest[N]");
				sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
				sbParam.append(" form_hiddeData[N]");
				sbParam.append(" form_level[(").append(sLevel).append(")]");
				sbParam.append(" form_remark[]");
				sbParam.append(" form_Cntr[1]");
				sbParam.append(" form_mainOnly[N]");
				sbParam.append(" form_CorrNo[]");
				sbParam.append(" form_his_cntr[BKG_CONTAINER]");
				sbParam.append(" form_his_bkg[BKG_BOOKING]");
				sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
				sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
	
				sbParam.append(" form_his_bl[BKG_BL_DOC]");
				sbParam.append(" isEncode[Y]");
				sbParam.append(" form_rqst_via_cd[").append(japanStampValue).append("]"); 
				sbParam.append(" form_his_bl_mkd[BKG_BL_ISS]");		
				sbParam.append(" form_esig[").append(blEsigFlg).append("]");			
				sbParam.append(" form_cpy_esig[").append(blCpyEsigFlg).append("]");		
				sbParam.append(" form_knt_flg[").append(blKntFlg).append("]");
				sbParam.append(" form_count[").append(y+1).append("]");
				sbParam.append(" form_path[" + fileDownPath + "]");
				
				if("4".equals(sType)){
					//보안 적용
					int infoSeq = 0;
					String authDt = "";
					String authFlag = "Y";
					infoSeq = command.createInetBlPrnAuth(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getBlNo(), account);
					authDt = utilBC.searchTimeLocalOfcFnc(account.getOfc_cd());//return YYYY-MM-DD HH24:MI:SS
					if(authDt != null && authDt.length()>0){
						authDt = authDt.substring(0, 10).replace("-", "");
						log.debug("[authDt]"+authDt);
					}
					String param_1 = "?authDt=" + authDt + "%26" + "bkgNo=" + bkgBlNoVO.getBkgNo() + "%26" + "infoSeq=" + infoSeq; 
					String param_2 = authFlag;
					String param_3 = CFG_FILEOPEN_LOGURL_BASE;
					String param_4 = CFG_FILEOPEN_LOGURL_LOGPATH;
					String rdParam = " fileopen_flag[" + param_2 + "] ";
					rdParam += "fileopen_url[" + param_3+ "] ";
					rdParam += "fileopen_servlet[" + param_4+ "] ";
					rdParam += "fileopen_param[" + param_1+ "] ";
					sbParam.append(rdParam);
				}
				
				sbParam.append(" invokerMergeFlag[Y] invokerMergeCount[").append(mrdcnt).append("]");
				sbParam.append(" /riprnmargin");
				if(y<maxCnt-1){
					sbParam.append(separator);
				}
			}
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return sbParam.toString();
	}

	
}
