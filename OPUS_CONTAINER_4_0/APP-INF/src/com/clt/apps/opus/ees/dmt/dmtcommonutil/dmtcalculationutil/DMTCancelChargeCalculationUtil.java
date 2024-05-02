/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCancelChargeCalculationUtil.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil;

import java.util.ArrayList;
//import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration.DMTCalculationDBDAO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.AFTExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BkgContainerInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtAFTGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DtocFreeTimeParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixORGLocationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixORGLocationVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPODLocationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPOLLocationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeEndParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeStartParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OfficeInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;


/**
 * Cancel calculation function <br>
 * = DMTGeneralChargeCalculationUtil: Basic + After Calculation
 *
 * @author 
 * @see DMTCalculationDBDAO class reference
 * @since J2EE 1.6
 */
public class DMTCancelChargeCalculationUtil {
	
	// Database Access Object
	public transient DMTCalculationDBDAO dbDao = null;
	protected transient Logger log = null;
	
	DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
	/**
	 * DMTCalculationUtilCreate object<br>
	 * DMTCalculationDBDAO Creation<br>
	 */
	public DMTCancelChargeCalculationUtil() {
		dbDao = new DMTCalculationDBDAO();
		log = Logger.getLogger(getClass().getName());
	}
	
	
	
	/**
	 *  cancel Charge Calculation Search
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return ChargeCalculationContainerVO
	 * @exception EventException
	 */
	public ChargeCalculationContainerVO cancelChargeCalculation(ChargeCalculationParmVO chargeCalculationParmVO) 
	throws EventException{
		
		ChargeCalculationContainerVO chargeCalculationContainerVO = new ChargeCalculationContainerVO();
		//parameter values
		ContainerCargoTypeParmVO 	containerCargoTypeParmVO 	= new ContainerCargoTypeParmVO();
		CalculationParmVO 			calculationParmVO 			= new CalculationParmVO();
		FixPOLLocationParmVO 		fixPOLLocationParmVO 		= new FixPOLLocationParmVO();
		FixPODLocationParmVO 		fixPODLocationParmVO 		= new FixPODLocationParmVO();
		FreeTimeStartParmVO 		freeTimeStartParmVO 		= new FreeTimeStartParmVO();
		FreeTimeEndParmVO 			freeTimeEndParmVO 			= new FreeTimeEndParmVO();
		LocationByBoundParmVO 		locationByBoundParmVO 		= new LocationByBoundParmVO();
		FixDELLocationParmVO 		fixDELLocationParmVO 		= new FixDELLocationParmVO();
		FixORGLocationParmVO 		fixORGLocationParmVO 		= new FixORGLocationParmVO();
		BasicTariffParmVO 			basicTariffParmVO 			= new BasicTariffParmVO();
		DtocFreeTimeParmVO 			dtocFreeTimeParmVO 			= new DtocFreeTimeParmVO();
		OverdayNStatusParmVO 		overdayNStatusParmVO 		= new OverdayNStatusParmVO();
		AFTExceptionParmVO 			aftExceptionParmVO 			= new AFTExceptionParmVO();
		ExchangeRateParmVO 			exchangeRateParmVO	 		= new ExchangeRateParmVO();
		
		//param local variables 
		String zSvrId       = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getSvrId());
		String zCntrNo      = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrNo());
		long   zCnmvCycNo  	= DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getCntrCycNo());
		String zBkgNo       = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getBkgNo());
		String zDcFmDate   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtDt());
		String zDcFmYdCd  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtYdCd());
		String zDcFmCnms   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtStsCd());
		String zDcToDate   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtDt());
		String zDcToYdCd  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtYdCd()); 
		String zDcToCnms   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtStsCd());
		String zDttCode     = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtTrfCd());
		String zCntrtsCd    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrTpszCd());
		String zDbcIoBnd   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getIoBndCd());
		String zCustCntCd  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCustCntCd());
		String zCustCd      = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCustSeq());
		String zAczCnzCd   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getActCntCd());
		String zAczCuszCd  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getActCustSeq());
		String zLocDiv  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtChgLocDivCd());
		
		String runDate  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getRunDate());
		
		if(zDcToDate.equals("")){
			zDcToDate   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getRunDate());
			zDcToYdCd  		= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtYdCd());
			zDcToCnms   	= "MT";
		} 
		
		// 2015.02.24
		if(zDttCode.equals("DMIF") && zDcFmYdCd.substring(0,2).equals("US")) {
			String evntDt = null;
			try {
				evntDt = dbDao.searchNTdate(zCntrNo, zDcFmYdCd, zBkgNo);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("searchNTdate Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchNTdate Select Error ! " + new ErrorHandler(e).getMessage());
			}
			if(evntDt!=null) {
				zDcFmDate = evntDt;
			}
		}
		
		log.debug("***********************************************************");
		log.debug("[ChargeCalculationParmVO]>> zSvrId 		:"+ zSvrId);
		log.debug("[ChargeCalculationParmVO]>> zCntrNo 		:"+ zCntrNo);
		log.debug("[ChargeCalculationParmVO]>> zCnmvCycNo 	:"+ zCnmvCycNo);
		log.debug("[ChargeCalculationParmVO]>> zDcFmDate 	:"+ zDcFmDate);
		log.debug("[ChargeCalculationParmVO]>> zDcFmYdCd 	:"+ zDcFmYdCd);
		log.debug("[ChargeCalculationParmVO]>> zDcFmCnms 	:"+ zDcFmCnms);
		log.debug("[ChargeCalculationParmVO]>> zDcToDate 	:"+ zDcToDate);
		log.debug("[ChargeCalculationParmVO]>> zDcToYdCd 	:"+ zDcToYdCd);
		log.debug("[ChargeCalculationParmVO]>> zDcToCnms 	:"+ zDcToCnms);
		log.debug("[ChargeCalculationParmVO]>> zDttCode 	:"+ zDttCode);
		log.debug("[ChargeCalculationParmVO]>> zCntrtsCd 	:"+ zCntrtsCd);
		log.debug("[ChargeCalculationParmVO]>> zDbcIoBnd 	:"+ zDbcIoBnd);
		log.debug("[ChargeCalculationParmVO]>> zCustCntCd 	:"+ zCustCntCd);
		log.debug("[ChargeCalculationParmVO]>> zCustCd 		:"+ zCustCd);
		log.debug("[ChargeCalculationParmVO]>> zAczCnzCd 	:"+ zAczCnzCd);
		log.debug("[ChargeCalculationParmVO]>> zAczCuszCd 	:"+ zAczCuszCd);
		
		log.debug("[ChargeCalculationParmVO]>> zLocDiv 		:"+ zLocDiv);
		log.debug("*************************************************************");

		//////////////////////  START   defind variables    /////////////////
		
		String zBlNo		= "";  
		
		String zPorContiCd 	= ""; 
		String zPorCntCd 	= ""; 
		String zPorRgnCd 	= ""; 
		String zPorStateCd 	= ""; 
		
		String zPolContiCd	= "";                                                      
		String zPolCntCd	= "";                                                      
		String zPolRgnCd	= "";                                                      
		String zPolStateCd	= "";                                                      
		
		String zDelContiCd	= "";                                                      
		String zDelCntCd	= "";                                                      
		String zDelRgnCd	= "";                                                      
		String zDelStateCd	= "";                                                      
		
		String zYrdContiCd	= "";                                                      
		String zYrdLoc		= "";                                                      
		String zYrdCntCd	= "";                                                      
		String zYrdRgnCd	= "";                                                      
		String zYrdStateCd	= "";                                                      
		
		String fixPodLoc	= "";                                                                                      
		
		String fixDelContiCd= "";                                                                      
		String fixDelCntCd	= "";                                                                     
		String fixDelRgnCd	= "";                                                                      
		String fixDelStateCd= "";                                                                       
		String fixDelLoc	= "";    
		
		String zPorLoc		= "";                                                      
		String zPodLoc		= "";                                                      
		String zPolLoc		= "";                                                      
		String zDelLoc		= "";                                                      
		
		String zPostRly		= "";                                                      
		String zBcntrSpeDg	= "";                                                      
		String zBcntrSpeRf	= "";                                                      
		String zBcntrSpeAk	= "";                                                      
		String zBcntrSpeRd	= "";                                                      
		String zBcntrSpeBb	= "";                                                      
		String zBcntrSocInd	= "";                                                      
		String zBcntrPartial= "";                                                      
		String zBcntrExcept	= "";                                                      
		
		String zBbRcvTermCd = "";
		String zBbDeTermCd  = "";
		
		String zOfcCd		= "";                                              
		String zOfcRhq		= "";
		String zSalOfc		= "";                                                      
		String zSalRhq		= "";                                                      
		String zBcntrDlvTerm= "";                                              
		String bkgCntCd		= "";                                                      
		String bkgRgnCd		= "";                                                      
		String bkgStateCd	= "";                                                      
		String bkgLocCd		= "";                                                      
		String zVslCd		= "";                                              
		String zSkdVoyageNo	= "";                                                      
		String zSkdDirCd	= "";                                                      
		String zVpsEtaDt	= "";                                                      
		String dtgEfftDt	= "";                                              
		String zDcsCntrTp	= "";                                                      
		String zDcsCgoTp	= "";                                                      
		long   zDbcBkgQty	= 0;    
		
		long   zDtnSeq		= 0;                                           
		long   zDtgGrpId	= 0;                                             
		String dtgCmncTp	= "";                                                      
		String dtgCmncHr	= "";                                                      
		String dtgExclSat	= "";                                                      
		String dtgExclSun	= "";                                                      
		String dtgExclHoli	= "";                                                      
		String zCurCd		= "";                                              
		long   zDcFtDays	= 0;                                           
		String zDcFtCmnc	= "";                                                      
		String zDcFtEnd		= "";                                                      
		long   zDcFtOver	= 0;                                                                                           
		String zDcStatus	= "";    
		
		long   zDcOrgOver	= 0;                                             
		long   zDcBfrOver	= 0;                                             
		long   zDcAftOver	= 0;  
		
		String zDcApplRate	= "";                                                      
		double zDcOrgAmt	= 0;                                               
		double zDcExpAmt	= 0;                                               
		double zDcDscAmt	= 0;                                               
		double zDcBillAmt	= 0;                                              
		double zDcBfrAmt	= 0;                                              
		double zDcAftAmt	= 0;    
		
		//S/C
		String zBrhScNo		= "";                                                      
		String zBrhRfaNo	= "";                                                      
		                                                               
		String zScNo		= "";
		long   zScVerSeq	= 0;                                             
		long   zScGrpSeq	= 0;
		
		//COMMODITY
		String zCmdtCd		= "";     
		String zCmdtCdC		= "";     
		String zRepCmdtCd	= "";                                                      
		                                                      
		long   zDcrSeq		= 0;                                                
		long   zDcCmdtOver	= 0;                                                        
		double zDcCmdtAmt	= 0;           
		
		
		//RFA -  BEFORE
		String zApprNo		= ""; 
		String zDarNo		= ""; 
		long   zMapgSeq		= 0;  
		long   zVerSeq		= 0;  
		long   zDtlSeq		= 0;  
		long   zCmbSeq		= 0;
		
		//AFTER
		String zAftApprNo	= "";                                                      
		String zAftDarNo	= "";                                                      
		long   zAftAdjSeq	= 0;  

		String dadFtimeMk	= "";                                                      
		long   dadAddDay	= 0;                                              
		long   dadTtlDay	= 0;                                              
		String dadExclSat	= "";                                                      
		String dadExclSun	= "";                                                      
		String dadExclHoli	= "";                                                      
		String dadDcMk		= "";                                                      
		String dadCurCd		= "";                                                      
		double dadDcAmt		= 0;                                                
		double dadDcRate	= 0;                                                
		
		String fixPolLoc	= "";
		String zPreRly		= "";
		
		/* ------------------------------------------- */
		
		long   rateDtlCnt 	= 0;
		double getBfrExRate	= 1.0;	
		double getAftExRate	= 1.0;	
		
		long   zDtocFtime	= 0;   
		
		double tmp1		= 0;					
		double tmp2		= 0;
		
		String zFixedCmnc	= zDcFmDate;
		String zWebMtDate	= "";        	                                     
		String awkInOut		= "";    
		
		List<String> cstopNoList = null;
		long		idxCstop	 = 0;

		
		String	tmpTsp		= "";	
		String	zOrgContiCd	= "";
		String	zOrgCntCd	= "";
		String	zOrgRgnCd	= "";
		String	zOrgStateCd	= "";
		String	zOrgLocCd	= "";
				
		//////////////////////END   defind variables    /////////////////                                                                            
                                                                               

		/*
		[logic] Set CNTR TYPE 
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Set CNTR TYPE ");
		log.debug("*******************************************************");
		zDcsCntrTp = DMTCalculationUtil.nullToString(zCntrtsCd,1).substring(0, 1);
		if(zDcsCntrTp.equals("P")){
			zDcsCntrTp = "F";
		}
		chargeCalculationContainerVO.setCntrTp(zDcsCntrTp);
		
		log.debug("*******************************************************");
		log.debug("[Set Cntr Type] zDcsCntrTp :"+ zDcsCntrTp);
		log.debug("*******************************************************");
		
		/*
		[logic] DEM/DET Office Setting : DEM/DET Collection Office 확인
		*/
		
		if(zDcFmYdCd.length() == 0){
			zDcFmYdCd = zDcToYdCd;
		}
		log.debug("*******************************************************");
		log.debug("[DEM/DET Office Setting] zDcFmYdCd : "+ zDcFmYdCd);
		log.debug("[DEM/DET Office Setting] zDcToYdCd : "+ zDcToYdCd);
		log.debug("*******************************************************");
		
		OfficeInfoVO officeInfoVO = null;
		try {
			officeInfoVO = dbDao.searchOfficeInfoByFmYardCd(zDbcIoBnd, zDcFmYdCd);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("[Exception]>> DEM/DET Office Select Error !  ");
			log.error("*******************************************************");
			throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		log.debug("*******************************************************");
		log.debug("[DEM/DET Office Setting]>> officeInfoVO.getCollectYn() : "+ officeInfoVO.getCollectYn());
		log.debug("*******************************************************");
		
		if(DMTCalculationUtil.nullToString(officeInfoVO.getCollectYn()).equals("")){
			log.debug("*******************************************************");
			log.debug("[officeInfoVO is null !  88 DEM/DET Office Skip !");
			log.debug("*******************************************************");
			chargeCalculationContainerVO.setMsgCd("88");
			chargeCalculationContainerVO.setMsgDesc("DEM/DET Office Skip ! : ("+zDcFmYdCd+ " ) " );
			
			return chargeCalculationContainerVO;
		} else {
			

			if(officeInfoVO.getCollectYn().equals("N") && zDttCode.substring(0, 2).equals("DM")){
				log.debug("*******************************************************");
				log.debug("[officeInfoVO.getCollectYn() == N zDttCode == DM 88 Not a DEM CLT Office");
				log.debug("*******************************************************");
				chargeCalculationContainerVO.setMsgCd("88");
				chargeCalculationContainerVO.setMsgDesc("DEM/DET Collection Mark is No for yard "+officeInfoVO.getOfcCd()+" "+zDcFmYdCd );
				
				return chargeCalculationContainerVO;
			} else {
				
				zOfcCd = officeInfoVO.getOfcCd();
				zOfcRhq = officeInfoVO.getOfcRhq();
				
				chargeCalculationContainerVO.setOfcCd(zOfcCd);
				chargeCalculationContainerVO.setOfcRhq(zOfcRhq);		
				log.debug("*******************************************************");
				log.debug("[ Office/RHQ ]  "+officeInfoVO.getOfcCd()+" "+ officeInfoVO.getOfcRhq()+" "+ zDcFmYdCd);
				log.debug("*******************************************************");
			}
		}
		log.debug("*******************************************************");
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcCd : "+ officeInfoVO.getOfcCd());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getCollectYn : "+ officeInfoVO.getCollectYn());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcRhq : "+ officeInfoVO.getOfcRhq());
		log.debug("*******************************************************"); 
		
		if(zDcToYdCd.length() != 0){
			try {
				officeInfoVO = dbDao.searchOfficeInfoByToYardCd(zDbcIoBnd, zDcToYdCd);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("DEM/DET Yard Select Error ! (ToYd) : ("+zDcToYdCd+ " ) " +e.getMessage());
				log.error("*******************************************************");
				throw new EventException("DEM/DET Yard Select Error ! (ToYd) : " + new ErrorHandler(e).getMessage());
			}
			
			if(officeInfoVO.getCollectYn() == null || officeInfoVO.getCollectYn().equals("N") && zDttCode.substring(0, 2).equals("DM")){
				log.debug("*******************************************************");
				log.debug("officeInfoVO.getCollectYn() == N && zDttCode ==DM 88 Not a DEM CLT Office");
				log.debug("*******************************************************");
				chargeCalculationContainerVO.setMsgCd("88");
				//chargeCalculationContainerVO.setMsgDesc("Not a DEM CLT Office ! (ToYd) : "+officeInfoVO.getOfcCd()+" "+zDcToYdCd);
				chargeCalculationContainerVO.setMsgDesc("Yard: " + zDcToYdCd + " does not have DEM/DET Office! Pls correct yard"); //2010.04.07
				
				return chargeCalculationContainerVO;
			}			
		}
		
		/*		
		[logic] Booking Container  information get : Get BKG Data 
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Booking Container  information get");
		log.debug("*******************************************************");
		
		BkgContainerInfoVO bkgContainerInfoVO = null;
		
		try {
			bkgContainerInfoVO = dbDao.searchBkgContainerInfo(zBkgNo, zCntrNo, zDcFmYdCd, "CANCEL");
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchBkgContainerInfo Select Error ! : "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchBkgContainerInfo Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		if(DMTCalculationUtil.nullToString(bkgContainerInfoVO.getIbflag()).equals("NoDataFound")){
			log.error("*******************************************************");
			log.error("[Invalid BKG No(No Data Found) ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			log.error("*******************************************************");
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("Invalid BKG No(No Data Found) ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
			
			return chargeCalculationContainerVO;
		}
		
		zBlNo 			= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getBlNo());
		zBrhScNo 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getScNo());
		zBrhRfaNo 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRfaNo());
	
		zCmdtCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getCmdtCd());
		zRepCmdtCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRepCmdtCd());
		zBcntrSpeDg 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDcgoFlg());
		zBcntrSpeRf 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRcFlg());
		
		zBcntrSpeAk 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getAwkCgoFlg());
		zBcntrSpeRd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRdCgoFlg());
		zBcntrSpeBb 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getBbCgoFlg());
		zBcntrSocInd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getSocFlg());
		zBcntrPartial 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getCntrPrtFlg());
		zBcntrExcept 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getAdvShtgCd());
		
		zPorLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorCd());
		zPolLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolCd());
		zPodLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPodCd());
		zDelLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelCd());
		zYrdLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdCd());
		
		zSalOfc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getObSlsOfcCd());
		zSalRhq 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getSalRhq());
		
		zPorContiCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorContiCd());
		zPorCntCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorCntCd());
		zPorRgnCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorRgnCd());
		zPorStateCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorSteCd());
		
		zPolContiCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolContiCd());
		zPolCntCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolCntCd());
		zPolRgnCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolRgnCd());
		zPolStateCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolSteCd());
		
		zDelContiCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelContiCd());
		zDelCntCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelCntCd());
		zDelRgnCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelRgnCd());
		zDelStateCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelSteCd());
		
		zYrdContiCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdContiCd());
		zYrdCntCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdCntCd());
		zYrdRgnCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdRgnCd());
		zYrdStateCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdSteCd());

		zPostRly 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPstRlyPortCd(), 5);
		zBcntrDlvTerm	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDeTermCd());
		zPreRly 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPreRlyPortCd(), 5);
		
		zBbRcvTermCd	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getBbRcvTermCd());
		zBbDeTermCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDeTermCd());
		
		chargeCalculationContainerVO.setBlNo(zBlNo);
		chargeCalculationContainerVO.setBrhScNo(zBrhScNo);
		chargeCalculationContainerVO.setBrhRfaNo(zBrhRfaNo);
		chargeCalculationContainerVO.setCmdtCd(zCmdtCd);
		chargeCalculationContainerVO.setRepCmdtCd(zRepCmdtCd);
		chargeCalculationContainerVO.setDcgoFlg(zBcntrSpeDg);
		chargeCalculationContainerVO.setRcFlg(zBcntrSpeRf);
		chargeCalculationContainerVO.setAwkCgoFlg(zBcntrSpeAk);
		chargeCalculationContainerVO.setRdCgoFlg(zBcntrSpeRd);
		chargeCalculationContainerVO.setBbCgoFlg(zBcntrSpeBb);
		chargeCalculationContainerVO.setSocFlg(zBcntrSocInd);
		chargeCalculationContainerVO.setCntrPrtFlg(zBcntrPartial);
		chargeCalculationContainerVO.setAdvShtgCd(zBcntrExcept);
		chargeCalculationContainerVO.setPorCd(zPorLoc);
		chargeCalculationContainerVO.setPodCd(zPodLoc);
		chargeCalculationContainerVO.setPolCd(zPolLoc);
		chargeCalculationContainerVO.setDelCd(zDelLoc);
		chargeCalculationContainerVO.setSalOfc(zSalOfc);
		chargeCalculationContainerVO.setSalRhq(zSalRhq);
		chargeCalculationContainerVO.setBbRcvTermCd(zBbRcvTermCd);
		chargeCalculationContainerVO.setBbDeTermCd(zBbDeTermCd);

		log.debug("*******************************************************");
		log.debug("[searchBkgContainerInfo]");
		log.debug("[BkgContainerInfoVO] zBlNo 		: "+ zBlNo);
		log.debug("[BkgContainerInfoVO] zBrhScNo 	: "+ zBrhScNo);
		log.debug("[BkgContainerInfoVO] zBrhRfaNo 	: "+ zBrhRfaNo);
		log.debug("[BkgContainerInfoVO] zCmdtCd 		: "+ zCmdtCd);
		log.debug("[BkgContainerInfoVO] zRepCmdtCd 	: "+ zRepCmdtCd);
		log.debug("[BkgContainerInfoVO] zBcntrSpeDg 	: "+ zBcntrSpeDg);
		log.debug("[BkgContainerInfoVO] zBcntrSpeRf 	: "+ zBcntrSpeRf);
		log.debug("[BkgContainerInfoVO] zBcntrSpeAk 	: "+ zBcntrSpeAk);
		log.debug("[BkgContainerInfoVO] zBcntrSpeRd 	: "+ zBcntrSpeRd);
		log.debug("[BkgContainerInfoVO] zBcntrSpeBb 	: "+ zBcntrSpeBb);
		log.debug("[BkgContainerInfoVO] zBcntrSocInd : "+ zBcntrSocInd);
		log.debug("[BkgContainerInfoVO] zBcntrPartial : "+ zBcntrPartial);
		log.debug("[BkgContainerInfoVO] zBcntrExcept 	: "+ zBcntrExcept);
		log.debug("[BkgContainerInfoVO] zPorLoc 		: "+ zPorLoc);
		log.debug("[BkgContainerInfoVO] zPolLoc 		: "+ zPolLoc);
		log.debug("[BkgContainerInfoVO] zPodLoc 		: "+ zPodLoc);
		log.debug("[BkgContainerInfoVO] zDelLoc 		: "+ zDelLoc);
		log.debug("[BkgContainerInfoVO] zYrdLoc 		: "+ zYrdLoc);
		log.debug("[BkgContainerInfoVO] zSalOfc 		: "+ zSalOfc);
		log.debug("[BkgContainerInfoVO] zSalRhq 		: "+ zSalRhq);
		log.debug("[BkgContainerInfoVO] zPorContiCd 	: "+ zPorContiCd);
		log.debug("[BkgContainerInfoVO] zPorCntCd 	: "+ zPorCntCd);
		log.debug("[BkgContainerInfoVO] zPorRgnCd 	: "+ zPorRgnCd);
		log.debug("[BkgContainerInfoVO] zPorStateCd 	: "+ zPorStateCd);
		log.debug("[BkgContainerInfoVO] zPolContiCd 	: "+ zPolContiCd);
		log.debug("[BkgContainerInfoVO] zPolCntCd 	: "+ zPolCntCd);
		log.debug("[BkgContainerInfoVO] zPolRgnCd 	: "+ zPolRgnCd);
		log.debug("[BkgContainerInfoVO] zPolStateCd 	: "+ zPolStateCd);
		log.debug("[BkgContainerInfoVO] zDelContiCd 	: "+ zDelContiCd);
		log.debug("[BkgContainerInfoVO] zDelCntCd 	: "+ zDelCntCd);
		log.debug("[BkgContainerInfoVO] zDelRgnCd 	: "+ zDelRgnCd);
		log.debug("[BkgContainerInfoVO] zDelStateCd 	: "+ zDelStateCd);
		log.debug("[BkgContainerInfoVO] zYrdContiCd 	: "+ zYrdContiCd);
		log.debug("[BkgContainerInfoVO] zYrdCntCd 	: "+ zYrdCntCd);
		log.debug("[BkgContainerInfoVO] zYrdRgnCd 	: "+ zYrdRgnCd);
		log.debug("[BkgContainerInfoVO] zYrdStateCd 	: "+ zYrdStateCd);
		log.debug("[BkgContainerInfoVO] zPostRly 		: "+ zPostRly);
		log.debug("[BkgContainerInfoVO] zBcntrDlvTerm: "+ zBcntrDlvTerm);
		log.debug("[BkgContainerInfoVO] zPreRly 		: "+ zPreRly);
		log.debug("[BkgContainerInfoVO] zBbRcvTermCd: "+ zBbRcvTermCd);
		log.debug("[BkgContainerInfoVO] zBbDeTermCd : "+ zBbDeTermCd);
		log.debug("*******************************************************");

		/*
		[logic] Cargo type decision : Set Cntr & Cgo Type
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Cargo type decision : Set Cntr & Cgo Type*");
		log.debug("*******************************************************");
		
		containerCargoTypeParmVO.setDcgoFlg(zBcntrSpeDg);
		containerCargoTypeParmVO.setRcFlg(zBcntrSpeRf);
		containerCargoTypeParmVO.setAwkCgoFlg(zBcntrSpeAk);
		containerCargoTypeParmVO.setRdCgoFlg(zBcntrSpeRd);
		containerCargoTypeParmVO.setSocFlg(zBcntrSocInd);
		containerCargoTypeParmVO.setBbCgoFlg(zBcntrSpeBb);
		
		ContainerCargoTypeVO containerCargoTypeVO = dmtCalculationUtil.settingContainerCargoType(containerCargoTypeParmVO);
		zDcsCgoTp = containerCargoTypeVO.getCgoTp();
		chargeCalculationContainerVO.setDmdtCgoTpCd(zDcsCgoTp);
		
		log.debug("*******************************************************");
		log.debug("[settingContainerCargoType]");
		log.debug("[ContainerCargoTypeVO] zDcsCgoTp : "+ zDcsCgoTp);
		log.debug("*******************************************************");
		
		/*
		[logic] Booking Container count  get : Get BKG Qty 
		*/
		try {
			zDbcBkgQty = dmtCalculationUtil.searchBookingContainerQuantity(zBkgNo);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("** Bkg Qty Select Error :"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("** Bkg Qty Select Error : " + new ErrorHandler(e).getMessage());
		}
		chargeCalculationContainerVO.setBkgQty(String.valueOf(zDbcBkgQty));

		log.debug("*******************************************************");
		log.debug("[searchBookingContainerQuantity]");
		log.debug("zDbcBkgQty : "+ zDbcBkgQty);
		log.debug("*******************************************************");
			
		/*	
		[logic] Booking I/O Bound Location decision :  Set In/Out Bound
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Booking I/O Bound Location decision :  Set In/Out Bound *");
		log.debug("*******************************************************");
		
		locationByBoundParmVO.setIoBnd(zDbcIoBnd);
		locationByBoundParmVO.setPorCntCd(zPorCntCd);
		locationByBoundParmVO.setPorRgnCd(zPorRgnCd);
		locationByBoundParmVO.setPorStateCd(zPorStateCd);
		locationByBoundParmVO.setPorLocCd(zPorLoc);
		
		locationByBoundParmVO.setDelCntCd(zDelCntCd);
		locationByBoundParmVO.setDelRgnCd(zDelRgnCd);
		locationByBoundParmVO.setDelStateCd(zDelStateCd);
		locationByBoundParmVO.setDelLocCd(zDelLoc);
		
		LocationByBoundVO locationByBoundVO = dmtCalculationUtil.setLocationByBound(locationByBoundParmVO);
		bkgCntCd 		=	locationByBoundVO.getBkgCntCd();
		bkgRgnCd  	=	locationByBoundVO.getBkgRgnCd();
		bkgStateCd	=	locationByBoundVO.getBkgStateCd();
		bkgLocCd  	=	locationByBoundVO.getBkgLocCd();
		
		log.debug("*******************************************************");
		log.debug("[setLocationByBound]");
		log.debug("[LocationByBoundVO] bkgCntCd : "+ bkgCntCd);
		log.debug("[LocationByBoundVO] bkgRgnCd : "+ bkgRgnCd);
		log.debug("[LocationByBoundVO] bkgStateCd : "+ bkgStateCd);
		log.debug("[LocationByBoundVO] bkgLocCd : "+ bkgLocCd);
		log.debug("*******************************************************");
		
		/*		
		[logic] POD Loc Fix  
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] POD Loc Fix *");
		log.debug("*******************************************************");
		
		fixPODLocationParmVO.setPodCd(zPodLoc);
		fixPODLocationParmVO.setDelCd(zDelLoc);
		fixPODLocationParmVO.setPostRly(zPostRly);
		fixPODLocationParmVO.setBkgNo(zBkgNo); 
		fixPodLoc = DMTCalculationUtil.nullToString(dmtCalculationUtil.fixPODLocation(fixPODLocationParmVO), 5);
		
		if( zDbcIoBnd.equals("I") && !DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(fixPodLoc,5).substring(0,5)) && 
			 DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5)) &&  
		   ( DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("DEHAM") || DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("DEBRE") ||
		     DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("NLRTM") || DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("BEANR"))
		     && DMTCalculationUtil.nullToString(zDcFmCnms,2).substring(0,2).equals("VD")	){		
			
			fixPodLoc = zPostRly;
			tmpTsp		= "Y";
		}
		
		log.debug("*******************************************************");
		log.debug("[fixPODLocation]");
		log.debug("[fixPodLoc] : "+ fixPodLoc);
		log.debug("[tmpTsp] : "+ tmpTsp);
		log.debug("*******************************************************");
		
		
		/*	
		[logic] POL Loc Fix
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] POL Loc Fix *");
		log.debug("*******************************************************");
		
		fixPOLLocationParmVO.setPorCd(zPorLoc);
		fixPOLLocationParmVO.setPolCd(zPolLoc);
		fixPOLLocationParmVO.setPreRly(zPreRly);
		fixPOLLocationParmVO.setBkgNo(zBkgNo); 
		fixPolLoc = DMTCalculationUtil.nullToString(dmtCalculationUtil.fixPOLLocation(fixPOLLocationParmVO), 5);
		
		if( zDbcIoBnd.equals("O") && !DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(fixPolLoc,5).substring(0,5)) && 
			 DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5)) &&  
		   ( DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("DEHAM") || DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("DEBRE") ||
		     DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("NLRTM") || DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("BEANR"))
		     && DMTCalculationUtil.nullToString(zDcFmCnms,2).substring(0,2).equals("VD")	){						
				
			 fixPolLoc = zPreRly;
			 tmpTsp	 = "Y";
		}
		log.debug("*******************************************************");
		log.debug("[fixPOLLocation]");
		log.debug("[fixPolLoc] : "+ fixPolLoc);
		log.debug("[tmpTsp] : "+ tmpTsp);
		log.debug("*******************************************************");
		
		
		/*
		[logic] Booking VVD, ETA  get : Get VVD & ETA Date
		*/
		log.debug("**********************************************************");
		log.debug("* [logic] Booking의 VVD, ETA  get : Get VVD & ETA Date *");
		log.debug("**********************************************************");
		
		VVDNEtaVO vvEtaVO = new VVDNEtaVO();
		try {
			vvEtaVO = dmtCalculationUtil.searchVVDNEta(zBkgNo, fixPolLoc, fixPodLoc, zDbcIoBnd);	
			zVslCd			= DMTCalculationUtil.nullToString(vvEtaVO.getVslCd());
			zSkdVoyageNo		= DMTCalculationUtil.nullToString(vvEtaVO.getSkdVoyNo());
			zSkdDirCd		= DMTCalculationUtil.nullToString(vvEtaVO.getSkdDirCd());
			zVpsEtaDt		= DMTCalculationUtil.nullToString(vvEtaVO.getVpsEtaDt());
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("[Exception]>> DEM/DET Office Select Error !  ");
			log.error("*******************************************************");
			throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		if(!DMTCalculationUtil.nullToString(vvEtaVO.getBkgNo()).equals("")){
			chargeCalculationContainerVO.setVslCd(zVslCd);
			chargeCalculationContainerVO.setSkdVoyNo(zSkdVoyageNo);
			chargeCalculationContainerVO.setSkdDirCd(zSkdDirCd);
			chargeCalculationContainerVO.setVpsEtaDt(zVpsEtaDt);
		} 
		else if(DMTCalculationUtil.nullToString(vvEtaVO.getBkgNo()).equals("")){
			log.debug("********************************");
			log.debug("** BKG VVD Not Found - BKG NO **");
			log.debug("********************************");
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("* BKG VVD Not Found - BKG NO:"+zBkgNo+
					", BND:"+zDbcIoBnd+", POL: "+fixPolLoc+", POD:"+fixPodLoc);
			chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
			
			return chargeCalculationContainerVO;
		}
		log.debug("*******************************************************");
		log.debug("[searchVVDNEta]");
		log.debug("[VVDNEtaVO] zVslCd : "+ zVslCd);
		log.debug("[VVDNEtaVO] zSkdVoyageNo : "+ zSkdVoyageNo);
		log.debug("[VVDNEtaVO] zSkdDirCd : "+ zSkdDirCd);
		log.debug("[VVDNEtaVO] zVpsEtaDt : "+ zVpsEtaDt);
		log.debug("*******************************************************");
		
		/*
		[logic] Tariff Effective Date decision : Set Tariff Effective Date
		*/
		log.debug("*****************************************************************");
		log.debug("* [logic] Tariff Effective Date decision : Set Tariff Effective Date *");
		log.debug("*****************************************************************");
		
		if(zDbcIoBnd.substring(0, 1).equals("I") && zVpsEtaDt.length() != 0){
			dtgEfftDt = DMTCalculationUtil.nullToString(zVpsEtaDt,8).substring(0, 8);
		} else {
			dtgEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
		}
		
		log.debug("************************************************************");
		log.debug("[Set Tariff Effective Date] dtgEfftDt : "+ dtgEfftDt);
		log.debug("************************************************************");
		
		/*
		[logic] Check DEM/DET Office Code 
		*/
		log.debug("*************************************");
		log.debug("* [logic] Check DEM/DET Office Code *");
		log.debug("*************************************");
		
		if(zOfcCd.length() == 0){
			log.debug("*******************************************************************");
			log.debug("* if(zOfcCd.length() == 0){    2  DEM/DET Office Code Not Found *");
			log.debug("*******************************************************************");
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("DEM/DET Office Code Not Found !");
			chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
			
			return chargeCalculationContainerVO;
		}
		/*
		[logic] From Date Checking
		*/
		if(zDcFmDate.length() == 0){
			log.debug("*****************************************************************");
			log.debug("* if(zDcFmDate.length() == 0){    2  From Movement Not Found *");
			log.debug("****************************************************************");
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("From Movement Not Found !");
			chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
			
			return chargeCalculationContainerVO;
		}
		
		/*
		[logic]  Booking DEL Location decision :  BKG DEL Loc Fix
				 According to (POD->DEL), decision apply  DEL Tariff to POD Tariff 
				 case in EUR T/S ,apply  DEL Tariff to POST/PRE RLY
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Booking DEL Location decision :  BKG DEL Loc Fix*");
		log.debug("*******************************************************");
		
		fixDELLocationParmVO.setDmdtTrfCd(zDttCode);
		fixDELLocationParmVO.setPodCd(zPodLoc);
		fixDELLocationParmVO.setDelCd(zDelLoc);
		fixDELLocationParmVO.setDeTermCd(zBcntrDlvTerm);
		fixDELLocationParmVO.setFmMvmtStsCd(zDcFmCnms);
		fixDELLocationParmVO.setToMvmtStsCd(zDcToCnms);
		fixDELLocationParmVO.setIoBnd(zDbcIoBnd);
		fixDELLocationParmVO.setTspFlag(tmpTsp);
		fixDELLocationParmVO.setPostRly(zPostRly);
		fixDELLocationParmVO.setPreRly(zPreRly);
		FixDELLocationVO fixDELLocationVO;
		try {
			fixDELLocationVO = dmtCalculationUtil.fixDELLocation(fixDELLocationParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* Fixed DEL Loc Select Error!"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* Fixed DEL Loc Select Error!" + new ErrorHandler(e).getMessage());
		}
		if(fixDELLocationVO.getMsgCd().equals("1")){
			fixDelContiCd	= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelContiCd());
			fixDelCntCd		= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelCntCd());
			fixDelRgnCd		= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelRgnCd());
			fixDelStateCd	= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelSteCd());
			fixDelLoc			= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelCd()); 
		} 
		else if(fixDELLocationVO.getMsgCd().equals("0")){
			/* Not Changed */
			fixDelContiCd 	= zDelContiCd;
			fixDelCntCd 		= zDelCntCd;
			fixDelRgnCd 		= zDelRgnCd;
			fixDelStateCd 	= zDelStateCd;
			fixDelLoc 		= zDelLoc;
		}
		log.debug("*******************************************************");
		log.debug("*[Booking의 DEL Location decision :  BKG DEL Loc Fix]");
		log.debug("fixDelContiCd : "+ fixDelContiCd);
		log.debug("fixDelCntCd : "+ fixDelCntCd);
		log.debug("fixDelRgnCd : "+ fixDelRgnCd);
		log.debug("fixDelStateCd : "+ fixDelStateCd);
		log.debug("fixDelLoc : "+ fixDelLoc);
		log.debug("*******************************************************");

		/*
		[logic] Tariff의 Origin Area adjustment - case in EUR T/S O/B , change DEL to ORG
		*/
		log.debug("****************************************************************************");
		log.debug("* [logic] Tariff의 Origin Area adjustment - case in EUR T/S O/B , change DEL to ORG*");
		log.debug("****************************************************************************");
		
		fixORGLocationParmVO.setIoBnd(zDbcIoBnd);
		fixORGLocationParmVO.setTspFlag(tmpTsp);
		fixORGLocationParmVO.setDelLocCd(zDelLoc);
		FixORGLocationVO fixORGLocationVO;
		try {
			fixORGLocationVO = dmtCalculationUtil.fixORGLocation(fixORGLocationParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* Fixed ORG Loc Select Error!"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* Fixed ORG Loc Select Error!" + new ErrorHandler(e).getMessage());
		}
		if(fixORGLocationVO.getMsgCd().equals("1")){
			zOrgContiCd		= DMTCalculationUtil.nullToString(fixORGLocationVO.getOrgContiCd());
			zOrgCntCd		= DMTCalculationUtil.nullToString(fixORGLocationVO.getOrgCntCd());
			zOrgRgnCd		= DMTCalculationUtil.nullToString(fixORGLocationVO.getOrgRgnCd());
			zOrgStateCd		= DMTCalculationUtil.nullToString(fixORGLocationVO.getOrgSteCd());
			zOrgLocCd		= DMTCalculationUtil.nullToString(fixORGLocationVO.getOrgCd()); 
		} 
		else if(fixORGLocationVO.getMsgCd().equals("0")){
			/* Not Changed */
			zOrgContiCd 		= zPolContiCd;
			zOrgCntCd 		= zPolCntCd;
			zOrgRgnCd 		= zPolRgnCd;
			zOrgStateCd 		= zPolStateCd;
			zOrgLocCd 		= zPolLoc;
		}
		log.debug("*******************************************************");
		log.debug("*[Tariff의 Origin Area adjustment]");
		log.debug("zOrgContiCd : "+ zOrgContiCd);
		log.debug("zOrgCntCd : "+ zOrgCntCd);
		log.debug("zOrgRgnCd : "+ zOrgRgnCd);
		log.debug("zOrgStateCd : "+ zOrgStateCd);
		log.debug("zOrgLocCd : "+ zOrgLocCd);
		log.debug("*******************************************************");
	
		
		/*
		[logic] Awkward In/Out-Gauge	
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Awkward In/Out-Gauge*");
		log.debug("*******************************************************");
		try {
			awkInOut = dmtCalculationUtil.searchInOutGauge(zCntrNo, zBkgNo);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("*Get the Awkward Cargo in/out-gauge Error!"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("Get the Awkward Cargo in/out-gauge Error!" + new ErrorHandler(e).getMessage());
		}
		log.debug("*******************************************************");
		log.debug("[searchInOutGauge]");
		log.debug("awkInOut : "+ awkInOut);
		log.debug("*******************************************************");
		
		
		
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* ||||||||||||||||||||||||||||||||||||||||| Get Basic Tariff Values */
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */		
		
		/*
		[logic] Basic Tariff information  get : Get Basic Tariff No
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]Basic Tariff information  get : Get Basic Tariff No*");
		log.debug("*******************************************************");
		
		basicTariffParmVO.setCvrgYdCd(zDcFmYdCd); //[2009.10.19  YARDCD추가: param:zDcFmYdCd]
		basicTariffParmVO.setPorContiCd(zPorContiCd);
		basicTariffParmVO.setPorCntCd(zPorCntCd);
		basicTariffParmVO.setPorRgnCd(zPorRgnCd);
		basicTariffParmVO.setPorSteCd(zPorStateCd);
		basicTariffParmVO.setPorLocCd(zPorLoc);
		
		basicTariffParmVO.setYrdContiCd(zYrdContiCd);
		basicTariffParmVO.setYrdCntCd(zYrdCntCd);
		basicTariffParmVO.setYrdRgnCd(zYrdRgnCd);
		basicTariffParmVO.setYrdSteCd(zYrdStateCd);
		basicTariffParmVO.setYrdLocCd(zYrdLoc);
		
		basicTariffParmVO.setPolContiCd(zOrgContiCd);
		basicTariffParmVO.setPolCntCd(zOrgCntCd);
		basicTariffParmVO.setPolRgnCd(zOrgRgnCd);
		basicTariffParmVO.setPolSteCd(zOrgStateCd);
		basicTariffParmVO.setPolLocCd(zOrgLocCd);
		
		basicTariffParmVO.setDelContiCd(fixDelContiCd);
		basicTariffParmVO.setDelCntCd(fixDelCntCd);
		basicTariffParmVO.setDelRgnCd(fixDelRgnCd);
		basicTariffParmVO.setDelSteCd(fixDelStateCd);
		basicTariffParmVO.setDelLocCd(fixDelLoc);
		
		basicTariffParmVO.setDmdtTrfCd(zDttCode);
		basicTariffParmVO.setEffDt(dtgEfftDt.trim()); 
		basicTariffParmVO.setDmdtCntrTpCd(zDcsCntrTp);
		basicTariffParmVO.setDmdtCgoTpCd(zDcsCgoTp);
		basicTariffParmVO.setIoBndCd(zDbcIoBnd);
		basicTariffParmVO.setAwkInOut(awkInOut);
		
		basicTariffParmVO.setSuthChnUseFlg(DMTCalculationUtil.nullToString(chargeCalculationParmVO.getSuthChnUseFlg()));
		
		
		
		
		BasicTariffKeyVO basicTariffKeyVO = null;
		try {
			basicTariffKeyVO = dmtCalculationUtil.searchBasicTariffByGeneration(basicTariffParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("*searchBasicTariffByGeneration Functon Error!"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchBasicTariffByGeneration Functon Error!" + new ErrorHandler(e).getMessage());
		}
		if(DMTCalculationUtil.nullToString(basicTariffKeyVO.getMsgCd()).equals("-99")){
			chargeCalculationContainerVO.setMsgCd("3");
			chargeCalculationContainerVO.setMsgDesc("Tariff Not Applicable !");
			chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
			
			return chargeCalculationContainerVO;
		} 
		else if(DMTCalculationUtil.nullToString(basicTariffKeyVO.getSvrId()).equals("")){
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("Tariff Not Found ! "+ zDttCode + ", "+ zPorCntCd+ ", "+ zYrdCntCd
					+ ", "+ zPolCntCd+ ", "+ fixDelCntCd+ ", "+ zDcsCntrTp+ ", "+ zDcsCgoTp+ ", "+ dtgEfftDt);
			chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
			
			return chargeCalculationContainerVO;
		} 
		else {
			zSvrId			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getSvrId());		
			zDttCode		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtTrfCd());
			zDtnSeq 		= DMTCalculationUtil.stringToLong(basicTariffKeyVO.getTrfSeq());
			zDtgGrpId		= DMTCalculationUtil.stringToLong(basicTariffKeyVO.getTrfGrpSeq());
			
			dtgCmncTp		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtChgCmncTpCd());
			dtgCmncHr		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getCmncHr());
			dtgExclSat		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSatFlg());
			dtgExclSun		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSunFlg());
			dtgExclHoli		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldHolFlg());
			zCurCd			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getCurrCd());
			
			log.debug("*********************************************");
			log.debug("[searchBasicTariffByGeneration]");
			log.debug("zSvrId : "+ zSvrId);
			log.debug("zDttCode : "+ zDttCode);
			log.debug("zDtnSeq : "+ zDtnSeq);
			log.debug("zDtgGrpId : "+ zDtgGrpId);
			log.debug("dtgCmncTp :"+dtgCmncTp);
			log.debug("dtgCmncHr :"+dtgCmncHr);
			log.debug("dtgExclSat :"+dtgExclSat);
			log.debug("dtgExclSun :"+dtgExclSun);
			log.debug("dtgExclHoli :"+dtgExclHoli);
			log.debug("zCurCd :"+zCurCd);
			log.debug("*********************************************");

		}


		
		if( zDttCode.equals("DTIC") &&  zDcFmCnms.equals("ID")	&&  zDcToCnms.equals("OC") ){
			log.debug("**************************************************************");
			log.debug("* [logic]  ID->OC Case Free days 조정 : ID -> OC F/Days Adjust*");
			log.debug("**************************************************************");
			
			dtocFreeTimeParmVO.setCntrNo(zCntrNo);
			dtocFreeTimeParmVO.setCnmvCycNo(String.valueOf(zCnmvCycNo + 1));
			dtocFreeTimeParmVO.setEfftDt(dtgEfftDt);
			dtocFreeTimeParmVO.setFmYdCd(zDcFmYdCd);
			try {
				zDtocFtime = dmtCalculationUtil.getDTOCFtime(dtocFreeTimeParmVO);
				
				if(zDtocFtime < 0){
					chargeCalculationContainerVO.setMsgCd("-1");
					chargeCalculationContainerVO.setMsgDesc("* getDTOCFtime Function Error -" +zDtocFtime);
					chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
					
					return chargeCalculationContainerVO;
				}
				
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("**getDTOCFtime Function Error !"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("getDTOCFtime Function Error !" + new ErrorHandler(e).getMessage());
			}
			log.debug("*******************************************************");
			log.debug("[getDTOCFtime]");
			log.debug("zDtocFtime :"+zDtocFtime);
			log.debug("*******************************************************");
			
			zDcFtDays = zDcFtDays + zDtocFtime	;  
			
			log.debug("*******************************************************");
			log.debug("* [ ID->OC BSC Ftime] ");
			log.debug("* [ DTIC FTIME += DTOC FTIME] zDcFtDays :"+zDcFtDays);
			log.debug("*******************************************************");
		}
		
		
		if( DMTCalculationUtil.nullToString(tmpTsp, 1).substring(0,1).equals("Y")){

			
			zDttCode	=	"DMIF";
			dtgExclSat	=	"N";
			dtgExclSun	=	"N";
			dtgExclHoli	=	"N";

			log.debug("*******************************************************");
			log.debug("* [ T/S Charge BSC Ftime] zDcFtDays :"+zDcFtDays);
			log.debug("* [ T/S Charge BSC Ftime] dtgExclSat :"+dtgExclSat);
			log.debug("* [ T/S Charge BSC Ftime] dtgExclSun :"+dtgExclSun);
			log.debug("* [ T/S Charge BSC Ftime] dtgExclHoli :"+dtgExclHoli);
			log.debug("*******************************************************");
		}
		
		
		/* Init Clock Stop Ary */
		cstopNoList = new ArrayList<String>();
		idxCstop = 0;
		

		
		zDcFtCmnc = zFixedCmnc;
		
//		if( zFixedCmnc.length() != 0 ){
//			zDcFtCmnc = zFixedCmnc;
//		} else {
//			freeTimeStartParmVO.setFromDt(zDcFmDate);
//			
//			freeTimeStartParmVO.setBkgCntCd(bkgCntCd);
//			freeTimeStartParmVO.setBkgRgnCd(bkgRgnCd);
//			freeTimeStartParmVO.setBkgStateCd(bkgStateCd);
//			freeTimeStartParmVO.setBkgLocCd(bkgLocCd);
//			
//			freeTimeStartParmVO.setYrdCntCd(zYrdCntCd);
//			freeTimeStartParmVO.setYrdRgnCd(zYrdRgnCd);
//			freeTimeStartParmVO.setYrdStateCd(zYrdStateCd);
//			freeTimeStartParmVO.setYrdLocCd(zYrdLoc);
//			
//			freeTimeStartParmVO.setDttCode(zDttCode);
//			freeTimeStartParmVO.setOfcCd(zOfcCd);
//			freeTimeStartParmVO.setExclSat(dtgExclSat);
//			freeTimeStartParmVO.setExclSun(dtgExclSun);
//			freeTimeStartParmVO.setExclHoli(dtgExclHoli);
//			freeTimeStartParmVO.setCmncTp(dtgCmncTp);
//			freeTimeStartParmVO.setCmncHr(dtgCmncHr);
//			freeTimeStartParmVO.setSvrId(zSvrId);
//			
//			freeTimeStartParmVO.setCstopIdx(String.valueOf(idxCstop));
//			freeTimeStartParmVO.setCStopNoList(cstopNoList);
//
//			log.debug("******************************************************************");
//			log.debug("* [freeTimeStartParmVO(param) ] idxCstop :["+idxCstop+"]");
//			log.debug("* [freeTimeStartParmVO(param) ] cstopNoList :["+cstopNoList+"]");
//			log.debug("******************************************************************");
//			
//			FreeTimeVO freeTimeStartVO = null;
//			try {
//				
//				freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
//				zDcFtCmnc 		= DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());					
//				idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
//				cstopNoList 	= freeTimeStartVO.getCStopNoList();
//				
//				log.debug("**********************************************************");
//				log.debug("* [FreeTimeVO(return) ] zDcFtCmnc 	:["+zDcFtCmnc+"]");
//				log.debug("* [FreeTimeVO(return) ] idxCstop 		:["+idxCstop+"]");
//				log.debug("* [FreeTimeVO(return) ] cstopNoList 	:["+cstopNoList+"]");
//				log.debug("**********************************************************");
//				
//			} catch (DAOException e) {
//				chargeCalculationContainerVO.setMsgCd("-1");
//				chargeCalculationContainerVO.setMsgDesc("* BSC searchFreeTimeStart Function Error : "+ e.getMessage());
//				
//				return chargeCalculationContainerVO;
//			}
//		}
		
		
		zDcFtDays = 0;  // 20091211  modify
		dtgCmncTp = "1"; 	// 20091228  modify
		dtgExclSat = "N";
		dtgExclSun = "N";
		dtgExclHoli = "N";
		


		
		zDcFtEnd = zDcFtCmnc; // 20091211  modify
		
		
//		/*	
//		[logic] VL(To Date) Change
//		*/
//		if(	( zDttCode.equals("DMOF" ) || zDttCode.equals("CTOC") ) && zDcToCnms.equals("VL")){
//			
//			log.debug("*******************************************************");
//			log.debug("* [logic]  VL(To Date) Change   ");
//			log.debug("*******************************************************");
//			
//			/* >>>>>  getFixedCmnc 
//			 * @param String  zVslCd
//			 * @param String  zSkdVoyageNo
//			 * @param String  zSkdDirCd
//			 * @param String  zDcYdCd
//			 * @param String  zDttCode
//			 * @param String  type
//			 */
//			try {
//				zFixedVlDt = DMTCalculationUtil.nullToString(dbDao.getFixedCmnc(zVslCd, zSkdVoyageNo, zSkdDirCd, zDcToYdCd, "", "to"));
//			} catch (DAOException e) {
//				chargeCalculationContainerVO.setMsgCd("-1");
//				chargeCalculationContainerVO.setMsgDesc("* Fixed VL Date Select Error -"+e.getMessage());
//				
//				return chargeCalculationContainerVO;
//			}
//			
//		}
//	
//		if( zFixedVlDt.length() != 0 ){
//			zDcToDate = zFixedVlDt;
//		}
//		log.debug("*******************************************************");
//		log.debug("* [VL(To Date) Change ] zFixedVlDt :"+zFixedVlDt);
//		log.debug("* [VL(To Date) Change ] zDcToDate :"+zDcToDate);
//		log.debug("*******************************************************");
//		
//		/*
//		[logic] Get Grace Period Overday 
//		*/
//		log.debug("*******************************************************");
//		log.debug("* [logic]  Get Grace Period Overday");
//		log.debug("*******************************************************");
//		try {
//			zWebMtDate =	DMTCalculationUtil.nullToString(dmtCalculationUtil.getMTNotify(zSvrId, zCntrNo, zCnmvCycNo, zDttCode, zDcFmCnms));
//		} catch (DAOException e) {
//			chargeCalculationContainerVO.setMsgCd("-1");
//			chargeCalculationContainerVO.setMsgDesc("*  Get MT Notification Function Error :"+e.getMessage());
//			
//			return chargeCalculationContainerVO;
//		}
//		log.debug("*******************************************************");
//		log.debug("* [ Get Grace Period Overday ] zWebMtDate :"+zWebMtDate);
//		log.debug("*******************************************************");
		
		
		/*
		[logic] Get Basic Overday 
		 */
		log.debug("*******************************************************");
		log.debug("* [logic]  Get Basic Overday    ");
		log.debug("*******************************************************");
		
		zDcFtOver = 0;
		
		//zDcToDate  value exists
		if(!zDcToDate.equals("")){
			overdayNStatusParmVO.setToDate(zDcToDate);
		} else {
			//zDcToDate  value exists
			overdayNStatusParmVO.setToDate(runDate);
		}

		overdayNStatusParmVO.setFtimeEnd(zDcFtEnd);
		
		overdayNStatusParmVO.setDttCode(zDttCode);
		overdayNStatusParmVO.setOfcCd(zOfcCd);
		overdayNStatusParmVO.setMtDate(zWebMtDate);
		overdayNStatusParmVO.setCstopIdx(String.valueOf(idxCstop));
		overdayNStatusParmVO.setCStopNoList(cstopNoList);
		overdayNStatusParmVO.setYardCd(zDcFmYdCd);

		//2012.02.15
		overdayNStatusParmVO.setIoBndCd(zDbcIoBnd);
		overdayNStatusParmVO.setBkgDeTermCd("D");
		overdayNStatusParmVO.setBkgRcvTermCd("D");
		overdayNStatusParmVO.setBkgCntCd(bkgCntCd);
		overdayNStatusParmVO.setBkgRgnCd(bkgRgnCd);
		overdayNStatusParmVO.setBkgStateCd(bkgStateCd);
		overdayNStatusParmVO.setBkgLocCd(bkgLocCd);
		overdayNStatusParmVO.setYrdCntCd(zYrdCntCd);
		overdayNStatusParmVO.setYrdRgnCd(zYrdRgnCd);
		overdayNStatusParmVO.setYrdStateCd(zYrdStateCd);
		overdayNStatusParmVO.setYrdLocCd(zYrdLoc);
		overdayNStatusParmVO.setSvrId(zSvrId);
		

		log.debug("*******************************************************************");
		log.debug("* [overdayNStatusParmVO(param) ] idxCstop 		:["+idxCstop+"]");
		log.debug("* [overdayNStatusParmVO(param) ] cstopNoList 	:["+cstopNoList+"]");
		log.debug("*******************************************************************");
		OverdayNStatusVO overdayNStatusVO = null;
		try {
			overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
			zDcFtOver	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
			zDcOrgOver 	= zDcFtOver;
			zDcStatus 	= DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
			idxCstop 	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
			cstopNoList = overdayNStatusVO.getCStopNoList();
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* G.Overday Function Error -"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* G.Overday Function Error -" + new ErrorHandler(e).getMessage());
		}
		
		log.debug("****************************************************************");
		log.debug("* [OverdayNStatusVO(return) ] zDcOrgOver 	:["+zDcOrgOver+"]");
		log.debug("* [OverdayNStatusVO(return) ] zDcStatus 		:["+zDcStatus+"]");
		log.debug("* [OverdayNStatusVO(return) ] idxCstop 		:["+idxCstop+"]");
		log.debug("* [OverdayNStatusVO(return) ] cstopNoList 	:["+cstopNoList+"]");
		log.debug("****************************************************************");
		
		/*
		[logic]  Get Basic Amount
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Get Basic Amount   ");
		log.debug("*******************************************************");
	
		if( zDcStatus.equals("L") || zDcStatus.equals("F") ){
			calculationParmVO.setSvrId(zSvrId);
			calculationParmVO.setDmdtTrfCd(zDttCode);
			calculationParmVO.setTrfSeq(String.valueOf(zDtnSeq));
			calculationParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
			calculationParmVO.setDivOverDay("0");
			CalculationAMTVO calculationAMTVO = null;
			try {
				calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
				rateDtlCnt = DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
				zDcOrgAmt = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Charge & Total Function Error -"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("Charge & Total Function Error -" + new ErrorHandler(e).getMessage());
			}
			
		}
		
		zDcApplRate = "G" ; 				/* Applied Rate Set  */
		zDcBillAmt  = zDcOrgAmt ;  	/* Basic  Amount Fixing */
		
		chargeCalculationContainerVO.setBzcTrfAplyDt(dtgEfftDt);
		log.debug("* [ChargeCalculationContainerVO ] setBzcTrfAplyDt 	:"+dtgEfftDt);
		
		log.debug("*******************************************************");
		log.debug("* [ORG AMT] zDcOrgAmt :"+zDcOrgAmt);
		log.debug("*******************************************************");
		
		
		if(DMTCalculationUtil.nullToString(tmpTsp,1).substring(0,1).equals("Y")){

			/* Trim Amount Values */
			zDcOrgAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcOrgAmt);
			zDcExpAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcExpAmt);
			zDcDscAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcDscAmt);
			zDcBillAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcBillAmt);
			zDcBfrAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcBfrAmt);
			zDcAftAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcAftAmt);
			zDcCmdtAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcCmdtAmt);
			
			/* if(tmpTsp == 'Y') -> Set The chargeCalculationContainerVO */
			chargeCalculationContainerVO.setFtDys(String.valueOf(zDcFtDays));
			chargeCalculationContainerVO.setFtCmncDt(zDcFtCmnc);
			chargeCalculationContainerVO.setFtEndDt(zDcFtEnd);
			chargeCalculationContainerVO.setFxFtOvrDys(String.valueOf(zDcFtOver));
			chargeCalculationContainerVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));
			chargeCalculationContainerVO.setScRfaExptOvrDys(String.valueOf(zDcBfrOver));
			chargeCalculationContainerVO.setAftExptOvrDys(String.valueOf(zDcAftOver));
			chargeCalculationContainerVO.setBzcTrfCurrCd(zCurCd);
			chargeCalculationContainerVO.setDmdtTrfAplyTpCd(zDcApplRate);
			chargeCalculationContainerVO.setOrgChgAmt(String.valueOf(zDcOrgAmt));
			chargeCalculationContainerVO.setScRfaExptAmt(String.valueOf(zDcExpAmt));
			chargeCalculationContainerVO.setAftExptDcAmt(String.valueOf(zDcDscAmt));
			chargeCalculationContainerVO.setBilAmt(String.valueOf(zDcBillAmt));
			chargeCalculationContainerVO.setDmdtChgStsCd(zDcStatus);
			chargeCalculationContainerVO.setScRfaAmt(String.valueOf(zDcBfrAmt));
			chargeCalculationContainerVO.setAftExptAmt(String.valueOf(zDcAftAmt));
			chargeCalculationContainerVO.setBzcTrfSeq(String.valueOf(zDtnSeq));
			chargeCalculationContainerVO.setBzcTrfGrpSeq(String.valueOf(zDtgGrpId));
			chargeCalculationContainerVO.setRfaExptAproNo(zApprNo);
			chargeCalculationContainerVO.setRfaExptDarNo(zDarNo);
			chargeCalculationContainerVO.setRfaExptMapgSeq(String.valueOf(zMapgSeq));
			chargeCalculationContainerVO.setRfaExptVerSeq(String.valueOf(zVerSeq));
			chargeCalculationContainerVO.setRfaRqstDtlSeq(String.valueOf(zDtlSeq));
			chargeCalculationContainerVO.setCvrgCmbSeq(String.valueOf(zCmbSeq));
			chargeCalculationContainerVO.setAftExptAproNo(zAftApprNo);
			chargeCalculationContainerVO.setAftExptDarNo(zAftDarNo);
			chargeCalculationContainerVO.setAftExptAdjSeq(String.valueOf(zAftAdjSeq));
			chargeCalculationContainerVO.setScNo(zScNo);
			chargeCalculationContainerVO.setScExptVerSeq(String.valueOf(zScVerSeq));
			chargeCalculationContainerVO.setScExptGrpSeq(String.valueOf(zScGrpSeq));
			chargeCalculationContainerVO.setCmdtCdC(zCmdtCdC);
			chargeCalculationContainerVO.setCmdtTrfSeq(String.valueOf(zDcrSeq));
			chargeCalculationContainerVO.setCmdtOvrDys(String.valueOf(zDcCmdtOver));
			chargeCalculationContainerVO.setCmdtExptAmt(String.valueOf(zDcCmdtAmt));
			chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
		
			chargeCalculationContainerVO.setCstopIdx(String.valueOf(idxCstop));
			chargeCalculationContainerVO.setCStopNoList(cstopNoList);
			
			chargeCalculationContainerVO.setMsgCd("0");
			
			return chargeCalculationContainerVO;
		}
			
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* |||||||||||||||||||||||||||||||||||||||||||||||||||||| Get AFT Exception Values */
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
			
		/*
		[logic] Get AFT Exception Values
		*/
			
		if( zDcBillAmt >= 0 ) {  
			log.debug("*******************************************************");
			log.debug("* [logic]  Get AFT Exception Values ");
			log.debug("*******************************************************");
			
			aftExceptionParmVO.setDttCode(zDttCode);
			aftExceptionParmVO.setBkgNo(zBkgNo);
			//aftExceptionParmVO.setSvrId(zSvrId);
			aftExceptionParmVO.setCntrNo(zCntrNo);
			aftExceptionParmVO.setCnmvCycNo(String.valueOf(zCnmvCycNo));
			aftExceptionParmVO.setLocDiv(zLocDiv);
			DmtAFTGrpVO dmtAFTGrpVO = null;
			try {
				dmtAFTGrpVO = dmtCalculationUtil.searchAFTExceptionByGeneration(aftExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* AFT searchAFTExceptionByGeneration Function Error ::"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException(" AFT searchAFTExceptionByGeneration Function Error :: " + new ErrorHandler(e).getMessage());
			}
			if( DMTCalculationUtil.nullToString(dmtAFTGrpVO.getApprNo()).equals("") ){
				zDcDscAmt = 0;
				zDcAftAmt = 0;
			} 
			else {
				zAftApprNo		= DMTCalculationUtil.nullToString(dmtAFTGrpVO.getApprNo());
				zAftDarNo		= DMTCalculationUtil.nullToString(dmtAFTGrpVO.getDarNo());
				zAftAdjSeq		= DMTCalculationUtil.stringToLong(dmtAFTGrpVO.getAdjSeq());
				
				dadFtimeMk		= DMTCalculationUtil.nullToString(dmtAFTGrpVO.getFtimeMk());
				dadAddDay		= DMTCalculationUtil.stringToLong(dmtAFTGrpVO.getAddDay());
				dadTtlDay		= DMTCalculationUtil.stringToLong(dmtAFTGrpVO.getTtlDay());
				
				dadExclSat		= DMTCalculationUtil.nullToString(dmtAFTGrpVO.getExclSat());
				dadExclSun		= DMTCalculationUtil.nullToString(dmtAFTGrpVO.getExclSun());
				dadExclHoli		= DMTCalculationUtil.nullToString(dmtAFTGrpVO.getExclHoli());
				dadDcMk			= DMTCalculationUtil.nullToString(dmtAFTGrpVO.getDcMk());
				dadCurCd		= DMTCalculationUtil.nullToString(dmtAFTGrpVO.getCurCd());
				
				dadDcAmt		= DMTCalculationUtil.stringToDouble(dmtAFTGrpVO.getDcAmt());
				dadDcRate		= DMTCalculationUtil.stringToDouble(dmtAFTGrpVO.getDcRate());
				
				if(( dadFtimeMk.equals("Y") && (dadAddDay > 0 || dadTtlDay > 0) && zDcBillAmt == 0 )
					||
				    (!dadFtimeMk.equals("Y") && zDcBillAmt == 0 )){
					zAftApprNo = "";
					zAftDarNo  = "";
					zAftAdjSeq = 0;
				} 
				else {

					log.debug("*******************************************************");
					log.debug("[ AFT searchAFTExceptionByGeneration]");
					log.debug("[ AFT Req No ] zAftApprNo :"+zAftApprNo);
					log.debug("[ AFT Req No ] zAftDarNo 	:"+zAftDarNo);
					log.debug("[ AFT Req No ] zAftAdjSeq :"+zAftAdjSeq);
					log.debug("*******************************************************");
					log.debug("*******************************************************");
					log.debug("[ AFT EXP ] dadFtimeMk 	:"+dadFtimeMk);
					log.debug("[ AFT EXP ] dadAddDay 		:"+dadAddDay);
					log.debug("[ AFT EXP ] dadTtlDay 		:"+dadTtlDay);
					log.debug("[ AFT EXP ] dadExclSat		:"+dadExclSat);
					log.debug("[ AFT EXP ] dadExclSun 	:"+dadExclSun);
					log.debug("[ AFT EXP ] dadExclHoli 	:"+dadExclHoli);
					log.debug("*******************************************************");
					
					if( dadFtimeMk.equals("Y") ){
						if( dadAddDay != 0 ){
							zDcFtDays += dadAddDay;

							log.info("[[logic] zDcFtDays += dadAddDay"+zDcFtDays);
							
							/*
							[logic] Get After FreeTime End
							*/
							try {
								zDcFtEnd = dbDao.getNextDay(zDcFtEnd);
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("*  AFT getNextDay End Error ::"+e.getMessage()+", zDcFtEnd: :"+zDcFtEnd);
								log.error("*******************************************************");
								throw new EventException("*  AFT getNextDay End Error ::" + new ErrorHandler(e).getMessage());
							}
							freeTimeEndParmVO.setFromDt(zDcFtEnd);
							
							freeTimeEndParmVO.setBkgCntCd(bkgCntCd);
							freeTimeEndParmVO.setBkgRgnCd(bkgRgnCd);
							freeTimeEndParmVO.setBkgStateCd(bkgStateCd);
							freeTimeEndParmVO.setBkgLocCd(bkgLocCd);
							
							freeTimeEndParmVO.setYrdCntCd(zYrdCntCd);
							freeTimeEndParmVO.setYrdRgnCd(zYrdRgnCd);
							freeTimeEndParmVO.setYrdStateCd(zYrdStateCd);
							freeTimeEndParmVO.setYrdLocCd(zYrdLoc);
							
							freeTimeEndParmVO.setDttCode(zDttCode);
							freeTimeEndParmVO.setOfcCd(zOfcCd);
							freeTimeEndParmVO.setExclSat(dadExclSat);
							freeTimeEndParmVO.setExclSun(dadExclSun);
							freeTimeEndParmVO.setExclHoli(dadExclHoli);
							
							freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
							freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
							freeTimeEndParmVO.setCStopNoList(cstopNoList);
							freeTimeEndParmVO.setYardCd(zDcFmYdCd);	

							
//							freeTimeEndVO = null;
							FreeTimeVO freeTimeEndVO = null;
							try {
								freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
								zDcFtEnd    = DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
								idxCstop    = DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
								cstopNoList = freeTimeEndVO.getCStopNoList();
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("* AFT searchFreeTimeEnd Function Error -"+e.getMessage());
								log.error("*******************************************************");
								throw new EventException("AFT searchFreeTimeEnd Function Error -" + new ErrorHandler(e).getMessage());
							}
							log.debug("*******************************************************");
							log.debug("[ AFT searchFreeTimeEnd]");
							log.debug("[ AFT freeTimeEndVO ] zDcFtEnd 	:"+zDcFtEnd);
							log.debug("[ AFT freeTimeEndVO ] idxCstop 		:"+idxCstop);
							log.debug("[ AFT freeTimeEndVO ] cstopNoList 	:"+cstopNoList);
							log.debug("*******************************************************");
							
						} 
						else { /* if( dadTtlDay != 0 ) */
						
							/* Init Clock Stop Ary */
							cstopNoList = new ArrayList<String>();
							idxCstop = 0;

							
							
							zDcFtDays = dadTtlDay;
							
							log.info("[[logic] zDcFtDays = dadTtlDay]"+zDcFtDays);

							// case in Total Day = 0,  CMNC, End Date =  From Date
							if( zDcFtDays == 0 )	{
								zDcFtCmnc = zDcFmDate;
								zDcFtEnd = zDcFmDate;
							} 
							else {
								/*
								[logic] Get After FreeTime Start
								*/
								if( zFixedCmnc.length() == 0 ) {
									
									freeTimeStartParmVO.setFromDt(zDcFmDate);
									
									freeTimeStartParmVO.setBkgCntCd(bkgCntCd);
									freeTimeStartParmVO.setBkgRgnCd(bkgRgnCd);
									freeTimeStartParmVO.setBkgStateCd(bkgStateCd);
									freeTimeStartParmVO.setBkgLocCd(bkgLocCd);
									
									freeTimeStartParmVO.setYrdCntCd(zYrdCntCd);
									freeTimeStartParmVO.setYrdRgnCd(zYrdRgnCd);
									freeTimeStartParmVO.setYrdStateCd(zYrdStateCd);
									freeTimeStartParmVO.setYrdLocCd(zYrdLoc);
									
									freeTimeStartParmVO.setDttCode(zDttCode);
									freeTimeStartParmVO.setOfcCd(zOfcCd);
									freeTimeStartParmVO.setExclSat(dadExclSat);
									freeTimeStartParmVO.setExclSun(dadExclSun);
									freeTimeStartParmVO.setExclHoli(dadExclHoli);
									freeTimeStartParmVO.setCmncTp(dtgCmncTp);
									freeTimeStartParmVO.setCmncHr(dtgCmncHr);
									
									freeTimeStartParmVO.setCstopIdx(String.valueOf(idxCstop));
									freeTimeStartParmVO.setCStopNoList(cstopNoList);
									
									freeTimeStartParmVO.setYardCd(zDcFmYdCd);	

									
									FreeTimeVO freeTimeStartVO = null;
									try {
										freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
										zDcFtCmnc    = DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());
										idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
										cstopNoList 	= freeTimeStartVO.getCStopNoList();
									}catch(Exception e) {
										log.error("*******************************************************");
										log.error("* AFT searchFreeTimeStart Function Error -"+ e.getMessage());
										log.error("*******************************************************");
										throw new EventException("* AFT searchFreeTimeStart Function Error -" + new ErrorHandler(e).getMessage());
									}
									log.debug("*******************************************************");
									log.debug("[ AFT searchFreeTimeStart ]");
									log.debug("[ AFT freeTimeStartVO] zDcFtCmnc 	:"+zDcFtCmnc);
									log.debug("[ AFT freeTimeStartVO] zFixedCmnc 	:"+zFixedCmnc);
									log.debug("[ AFT freeTimeStartVO] idxCstop 	:"+idxCstop);
									log.debug("[ AFT freeTimeStartVO] cstopNoList :"+cstopNoList);
									log.debug("*******************************************************");	
									
								}

								/*
								[logic] Get After FreeTime End
								*/
								
								log.info("[[logic] Get After FreeTime End:]"+zDcFtDays);
						
								
								freeTimeEndParmVO.setFromDt(zDcFtCmnc);
								
								freeTimeEndParmVO.setBkgCntCd(bkgCntCd);
								freeTimeEndParmVO.setBkgRgnCd(bkgRgnCd);
								freeTimeEndParmVO.setBkgStateCd(bkgStateCd);
								freeTimeEndParmVO.setBkgLocCd(bkgLocCd);
								
								freeTimeEndParmVO.setYrdCntCd(zYrdCntCd);
								freeTimeEndParmVO.setYrdRgnCd(zYrdRgnCd);
								freeTimeEndParmVO.setYrdStateCd(zYrdStateCd);
								freeTimeEndParmVO.setYrdLocCd(zYrdLoc);
								
								freeTimeEndParmVO.setDttCode(zDttCode);
								freeTimeEndParmVO.setOfcCd(zOfcCd);
								freeTimeEndParmVO.setExclSat(dadExclSat);
								freeTimeEndParmVO.setExclSun(dadExclSun);
								freeTimeEndParmVO.setExclHoli(dadExclHoli);
								
								freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
								freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
								freeTimeEndParmVO.setCStopNoList(cstopNoList);
								freeTimeEndParmVO.setYardCd(zDcFmYdCd);	

								FreeTimeVO freeTimeEndVO = null;
								try {
									freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
									zDcFtEnd   = DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
									idxCstop 	  = DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
									cstopNoList = freeTimeEndVO.getCStopNoList();
								}catch(Exception e) {
									log.error("*******************************************************");
									log.error("* AFT searchFreeTimeEnd Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException("AFT searchFreeTimeEnd Function Error ::" + new ErrorHandler(e).getMessage());
								}
								log.debug("*******************************************************");
								log.debug("[ AFT searchFreeTimeEnd ]");
								log.debug("[ AFT freeTimeEndVO ] zDcFtEnd 	:"+zDcFtEnd);
								log.debug("[ AFT freeTimeEndVO ] idxCstop 		:"+idxCstop);
								log.debug("[ AFT freeTimeEndVO ] cstopNoList 	:"+cstopNoList);
								log.debug("*******************************************************");	
							}
						}

						/*
						[logic] Get After OverDay
						*/
						zDcFtOver = 0;
						
						overdayNStatusParmVO.setToDate(zDcToDate);
						overdayNStatusParmVO.setFtimeEnd(zDcFtEnd);
						overdayNStatusParmVO.setDttCode(zDttCode);
						overdayNStatusParmVO.setOfcCd(zOfcCd);
						overdayNStatusParmVO.setMtDate(zWebMtDate);
						overdayNStatusParmVO.setCstopIdx(String.valueOf(idxCstop));
						overdayNStatusParmVO.setCStopNoList(cstopNoList);
						overdayNStatusParmVO.setYardCd(zDcFmYdCd);	

						//2012.02.15
						overdayNStatusParmVO.setIoBndCd(zDbcIoBnd);
						overdayNStatusParmVO.setBkgDeTermCd("D");
						overdayNStatusParmVO.setBkgRcvTermCd("D");
						overdayNStatusParmVO.setBkgCntCd(bkgCntCd);
						overdayNStatusParmVO.setBkgRgnCd(bkgRgnCd);
						overdayNStatusParmVO.setBkgStateCd(bkgStateCd);
						overdayNStatusParmVO.setBkgLocCd(bkgLocCd);
						overdayNStatusParmVO.setYrdCntCd(zYrdCntCd);
						overdayNStatusParmVO.setYrdRgnCd(zYrdRgnCd);
						overdayNStatusParmVO.setYrdStateCd(zYrdStateCd);
						overdayNStatusParmVO.setYrdLocCd(zYrdLoc);
						overdayNStatusParmVO.setSvrId(zSvrId);
						
						try {
							overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
							zDcFtOver   = DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
							zDcAftOver  = zDcFtOver;
							zDcStatus   = DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
							idxCstop 	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
							cstopNoList = overdayNStatusVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("* AFT overdayNStatus Function Error ::"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("* AFT overdayNStatus Function Error ::" + new ErrorHandler(e).getMessage());
						}
							
						log.debug("*******************************************************");
						log.debug("[ AFT overdayNStatus ]");
						log.debug("[ AFT overdayNStatus ] zDcStatus 	:"+zDcStatus);
						log.debug("[ AFT overdayNStatus ] zDcAftOver :"+zDcAftOver);
						log.debug("[ AFT overdayNStatus ] idxCstop 	:"+idxCstop);
						log.debug("[ AFT overdayNStatus ] cstopNoList :"+cstopNoList);
						log.debug("*******************************************************");
						
						/*
						[logic] Get After Amount
						*/
						rateDtlCnt	=	0;
						zDcDscAmt	=	0;
						zDcAftAmt	=	0;

						if( zDcStatus.equals("L") || zDcStatus.equals("F") ){
							if(zDcApplRate.equals("G") ){		// Baisc Tariff		
							
								calculationParmVO.setSvrId(zSvrId);
								calculationParmVO.setDmdtTrfCd(zDttCode);
								calculationParmVO.setTrfSeq(String.valueOf(zDtnSeq));
								calculationParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
								
								calculationParmVO.setCntrts(zCntrtsCd);
								calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
								calculationParmVO.setDivOverDay("0");
								CalculationAMTVO calculationAMTVO = null;
								try {
									calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
									zDcAftAmt  = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
									rateDtlCnt = DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
								}catch(Exception e) {
									log.error("*******************************************************");
									log.error("* AFT  basicCalculation Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException("AFT  basicCalculation Function Error :: " + new ErrorHandler(e).getMessage());
								}
								
							} 
							else {
									chargeCalculationContainerVO.setMsgCd("-1");
									chargeCalculationContainerVO.setMsgDesc("* AFT  Appl Rate Error  ");
									return chargeCalculationContainerVO;
							}

							log.debug("*******************************************************");
							log.debug("[ Get After Amount ] getBfrExRate :"+getBfrExRate);
							log.debug("[ Get After Amount ] zDcAftAmt 	:"+zDcAftAmt);
							log.debug("*******************************************************");
							
							zDcAftAmt = zDcAftAmt * getBfrExRate;
							
							log.debug("*******************************************************");							
							log.debug("[ Get After Amount ] zDcAftAmt = zDcAftAmt * getBfrExRate :"+zDcAftAmt);
							log.debug("*******************************************************");								
						}

					} /* if( strcmp( dadFtimeMk.arr, "Y" ) == 0 ) */
					/*
					[logic] Get After DC Amount
					*/
					if( dadDcMk.equals("Y") ){
						if( dadDcAmt != 0 ){
							if( !zCurCd.equals(dadCurCd) ){
								exchangeRateParmVO.setPolLoc(fixPolLoc);
								exchangeRateParmVO.setPodLoc(fixPodLoc);
								exchangeRateParmVO.setIoBnd(zDbcIoBnd);
								exchangeRateParmVO.setVslCd(zVslCd);
								exchangeRateParmVO.setSkdVoyageNo(zSkdVoyageNo);
								exchangeRateParmVO.setSkdDirCd(zSkdDirCd);
								exchangeRateParmVO.setFmCurCd(dadCurCd);
								exchangeRateParmVO.setToCurCd(zCurCd);
								exchangeRateParmVO.setOfcCd(zOfcCd);
								try {
									getAftExRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
								}catch(Exception e) {
									log.error("*******************************************************");
									log.error("* AFT DC searchExchangeRate Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException("* AFT DC searchExchangeRate Function Error ::" + new ErrorHandler(e).getMessage());
								}
							
								dadDcAmt = dadDcAmt * getAftExRate	;
								
								log.debug("*******************************************************");
								log.debug("[ AFT DC searchExchangeRate ]");
								log.debug("[ AFT DC ExRate ] getAftExRate 	:"+getAftExRate);
								log.debug("[ AFT DC Amt    ] dadDcAmt 		:"+dadDcAmt);
								log.debug("*******************************************************");
							}

							if( dadFtimeMk.equals("Y") ){
								zDcAftAmt -= dadDcAmt;
							} else {
								zDcAftAmt = zDcBillAmt - dadDcAmt;
							}
							
							log.debug("*******************************************************");
							log.debug("[ AFT Amt (DA) ] zDcAftAmt :"+zDcAftAmt);
							log.debug("*******************************************************");
						} 
						else {				 /* if ( dadDcRate != 0 ) */
						
							if( dadFtimeMk.equals("Y") ){
								zDcAftAmt -= zDcAftAmt * dadDcRate / 100 ;
							} else {
								/* Don't Remove Below Variable TMP1, TMP2 */
								tmp1 = 0.0;
								tmp2 = 0.0;
								tmp1 = zDcBillAmt * dadDcRate;
								tmp2 = tmp1 / 100;

								zDcAftAmt = zDcBillAmt - tmp2;
							}
							log.debug("*******************************************************");
							log.debug("[ AFT Amt (DR)] zDcAftAmt :"+zDcAftAmt);
							log.debug("*******************************************************");
						}

						if( zDcAftAmt <= 0 ){
							zDcStatus = "N" ;
						}
					}  
					
					log.debug("*******************************************************");
					log.debug("[ DSC Amt ] zDcBillAmt 	:"+zDcBillAmt);
					log.debug("[ DSC Amt ] zDcAftAmt 	:"+zDcAftAmt);
					log.debug("*******************************************************");
					
					/* DSC Amount Set */
					zDcDscAmt = zDcBillAmt - zDcAftAmt;	
					
					log.debug("*******************************************************");
					log.debug("[ DSC Amt ] zDcDscAmt = zDcBillAmt - zDcAftAmt :"+zDcDscAmt);
					log.debug("*******************************************************");
				}
			}
		
			/* AFT Amount Fixing	*/
			log.debug("***************************************************************************************");
			log.debug("* [ AFT Amount Fixing ] zDcBillAmt :"+zDcBillAmt);
			log.debug("* [ AFT Amount Fixing ] zDcDscAmt :"+zDcDscAmt);
			
			zDcBillAmt = zDcBillAmt - zDcDscAmt  ;		
			
			log.debug("***************************************************************************************");
			log.debug("* [ AFT Amount Fixing ] zDcBillAmt = zDcBillAmt - zDcDscAmt :"+zDcBillAmt);
			log.debug("***************************************************************************************");

		} //End date Calculation
		
		/* Trim Amount Values */
		zDcOrgAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcOrgAmt);
		zDcExpAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcExpAmt);
		zDcDscAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcDscAmt);
		zDcBillAmt 	= zDcBillAmt < 0 ? 0 : dmtCalculationUtil.trimCurrencyAmount(zCurCd, zDcBillAmt);
		zDcBfrAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcBfrAmt);
		zDcAftAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcAftAmt);
		zDcCmdtAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,zDcCmdtAmt);
		
		/* Set The chargeCalculationContainerVO */
		log.debug("*************************************************************");
		log.debug("****  Set The chargeCalculationContainerVO of General********");
		log.debug("* [ChargeCalculationContainerVO ] zDcFtDays 	:"+zDcFtDays);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtCmnc 	:"+zDcFtCmnc);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtEnd 	:"+zDcFtEnd);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtOver 	:"+zDcFtOver);
		log.debug("* [ChargeCalculationContainerVO ] zDcOrgOver 	:"+zDcOrgOver);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcBfrOver 	:"+zDcBfrOver);
		log.debug("* [ChargeCalculationContainerVO ] zDcAftOver 	:"+zDcAftOver);
		log.debug("* [ChargeCalculationContainerVO ] zCurCd 		:"+zCurCd);
		log.debug("* [ChargeCalculationContainerVO ] zDcApplRate :"+zDcApplRate);
		log.debug("* [ChargeCalculationContainerVO ] zDcOrgAmt 	:"+zDcOrgAmt);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcExpAmt 	:"+zDcExpAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcDscAmt 	:"+zDcDscAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcBillAmt 	:"+zDcBillAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcStatus 	:"+zDcStatus);
		log.debug("* [ChargeCalculationContainerVO ] zDcBfrAmt 	:"+zDcBfrAmt);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcAftAmt 	:"+zDcAftAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDtnSeq 		:"+zDtnSeq);
		log.debug("* [ChargeCalculationContainerVO ] zDtgGrpId 	:"+zDtgGrpId);
		log.debug("* [ChargeCalculationContainerVO ] zApprNo 		:"+zApprNo);
		log.debug("* [ChargeCalculationContainerVO ] zDarNo 		:"+zDarNo);
		
		log.debug("* [ChargeCalculationContainerVO ] zMapgSeq 	:"+zMapgSeq);
		log.debug("* [ChargeCalculationContainerVO ] zVerSeq 		:"+zVerSeq);
		log.debug("* [ChargeCalculationContainerVO ] zDtlSeq 		:"+zDtlSeq);
		log.debug("* [ChargeCalculationContainerVO ] zCmbSeq 		:"+zCmbSeq);
		log.debug("* [ChargeCalculationContainerVO ] zAftApprNo 	:"+zAftApprNo);
		log.debug("* [ChargeCalculationContainerVO ] zAftDarNo 	:"+zAftDarNo);
		
		log.debug("* [ChargeCalculationContainerVO ] zAftAdjSeq 	:"+zAftAdjSeq);
		log.debug("* [ChargeCalculationContainerVO ] zScNo 		:"+zScNo);
		log.debug("* [ChargeCalculationContainerVO ] zScVerSeq 	:"+zScVerSeq);
		log.debug("* [ChargeCalculationContainerVO ] zScGrpSeq 	:"+zScGrpSeq);
		log.debug("* [ChargeCalculationContainerVO ] zCmdtCd 		:"+zCmdtCd);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcrSeq 		:"+zDcrSeq);
		log.debug("* [ChargeCalculationContainerVO ] zDcCmdtOver :"+zDcCmdtOver);
		log.debug("* [ChargeCalculationContainerVO ] zDcCmdtAmt 	:"+zDcCmdtAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcToDate 	:"+zDcToDate);
			
		log.debug("* [ChargeCalculationContainerVO ] setCstopIdx 	:"+idxCstop);
		log.debug("* [ChargeCalculationContainerVO ] setCStopNoList :"+cstopNoList);
		if(cstopNoList != null){
			if(cstopNoList.size() > 0){
				for(int i = 0; i < cstopNoList.size(); i++){
					log.debug(" [ChargeCalculationContainerVO ] cstopNoList.get("+i+")]"+cstopNoList.get(i));
				}
			}
		}
		log.debug("* [ChargeCalculationContainerVO ] msgCd :"+0);
		log.debug("***************************************************************");
		
		chargeCalculationContainerVO.setFtDys(String.valueOf(zDcFtDays));
		chargeCalculationContainerVO.setFtCmncDt(zDcFtCmnc);
		chargeCalculationContainerVO.setFtEndDt(zDcFtEnd);
		chargeCalculationContainerVO.setFxFtOvrDys(String.valueOf(zDcFtOver));
		chargeCalculationContainerVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));
		chargeCalculationContainerVO.setScRfaExptOvrDys(String.valueOf(zDcBfrOver));
		chargeCalculationContainerVO.setAftExptOvrDys(String.valueOf(zDcAftOver));
		chargeCalculationContainerVO.setBzcTrfCurrCd(zCurCd);
		chargeCalculationContainerVO.setDmdtTrfAplyTpCd(zDcApplRate);
		chargeCalculationContainerVO.setOrgChgAmt(String.valueOf(zDcOrgAmt));
		chargeCalculationContainerVO.setScRfaExptAmt(String.valueOf(zDcExpAmt));
		chargeCalculationContainerVO.setAftExptDcAmt(String.valueOf(zDcDscAmt));
		chargeCalculationContainerVO.setBilAmt(String.valueOf(zDcBillAmt));
		chargeCalculationContainerVO.setDmdtChgStsCd(zDcStatus);
		chargeCalculationContainerVO.setScRfaAmt(String.valueOf(zDcBfrAmt));
		chargeCalculationContainerVO.setAftExptAmt(String.valueOf(zDcAftAmt));
		chargeCalculationContainerVO.setBzcTrfSeq(String.valueOf(zDtnSeq));
		chargeCalculationContainerVO.setBzcTrfGrpSeq(String.valueOf(zDtgGrpId));
		chargeCalculationContainerVO.setRfaExptAproNo(zApprNo);
		chargeCalculationContainerVO.setRfaExptDarNo(zDarNo);
		chargeCalculationContainerVO.setRfaExptMapgSeq(String.valueOf(zMapgSeq));
		chargeCalculationContainerVO.setRfaExptVerSeq(String.valueOf(zVerSeq));
		chargeCalculationContainerVO.setRfaRqstDtlSeq(String.valueOf(zDtlSeq));
		chargeCalculationContainerVO.setCvrgCmbSeq(String.valueOf(zCmbSeq));
		chargeCalculationContainerVO.setAftExptAproNo(zAftApprNo);
		chargeCalculationContainerVO.setAftExptDarNo(zAftDarNo);		
		chargeCalculationContainerVO.setAftExptAdjSeq(String.valueOf(zAftAdjSeq));
		chargeCalculationContainerVO.setScNo(zScNo);
		chargeCalculationContainerVO.setScExptVerSeq(String.valueOf(zScVerSeq));
		chargeCalculationContainerVO.setScExptGrpSeq(String.valueOf(zScGrpSeq));
		chargeCalculationContainerVO.setCmdtCdC(zCmdtCd);
		chargeCalculationContainerVO.setCmdtTrfSeq(String.valueOf(zDcrSeq));
		chargeCalculationContainerVO.setCmdtOvrDys(String.valueOf(zDcCmdtOver));
		chargeCalculationContainerVO.setCmdtExptAmt(String.valueOf(zDcCmdtAmt));
		chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
		chargeCalculationContainerVO.setToMvmtYdCd(zDcToYdCd);
		chargeCalculationContainerVO.setToMvmtStsCd(zDcToCnms);
		chargeCalculationContainerVO.setCstopIdx(String.valueOf(idxCstop));
		if(cstopNoList != null) chargeCalculationContainerVO.setCStopNoList(cstopNoList);
		chargeCalculationContainerVO.setMsgCd("0");

		return chargeCalculationContainerVO;
	}
	
}
