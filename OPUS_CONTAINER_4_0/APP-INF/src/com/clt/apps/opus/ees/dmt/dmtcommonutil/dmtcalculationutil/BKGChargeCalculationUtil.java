/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BKGCalculationUtil.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.BookingCustomerBasicVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration.DMTCalculationDBDAO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.AFTExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ActCustInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BFRExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BKGRequestInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerCntrVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerInvVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CommodityExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtAFTGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtBFRGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtCmdtGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtSCGrpVO;
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
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.SCExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;


/**
 * Booking Request calculation function <br>
 *
 * @author
 * @see DMTCalculationDBDAO class reference
 * @since J2EE 1.4
 */
public class BKGChargeCalculationUtil {
	
	// Database Access Object
	public transient DMTCalculationDBDAO dbDao = null;
	protected transient Logger log = null;
	
	DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
	/**
	 * DMTCalculationUtilCreate object<br>
	 * DMTCalculationDBDAO Creation<br>
	 */
	public BKGChargeCalculationUtil() {
		dbDao = new DMTCalculationDBDAO();
		log = Logger.getLogger(getClass().getName());
	}
	
	
	
	/**
	 *  searchBookingCustomerCntrPartialInfo Search
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String podCd
	 * @param String aplyTpCd
	 * @return ChargeByBookingCustomerCntrVO
	 * @exception EventException 
	 */
	public ChargeByBookingCustomerCntrVO searchBookingCustomerCntrPartialInfo(String bkgNo, String cntrNo, String podCd, String aplyTpCd) 
	throws EventException{
		
		ChargeByBookingCustomerCntrVO chargeByBookingCustomerCntrVO = new ChargeByBookingCustomerCntrVO();
		//parameter values
		ContainerCargoTypeParmVO 	containerCargoTypeParmVO 	= new ContainerCargoTypeParmVO();
		CalculationParmVO 			calculationParmVO 			= new CalculationParmVO();
		FixPOLLocationParmVO 		fixPOLLocationParmVO 		= new FixPOLLocationParmVO();
		FixPODLocationParmVO 		fixPODLocationParmVO 		= new FixPODLocationParmVO();
		LocationByBoundParmVO 		locationByBoundParmVO 		= new LocationByBoundParmVO();
		FixDELLocationParmVO 		fixDELLocationParmVO 		= new FixDELLocationParmVO();
		FixORGLocationParmVO 		fixORGLocationParmVO 		= new FixORGLocationParmVO();
		BasicTariffParmVO 			basicTariffParmVO 			= new BasicTariffParmVO();
		SCExceptionParmVO 			scExceptionParmVO 			= new SCExceptionParmVO();
		BFRExceptionParmVO 			bfrExceptionParmVO 			= new BFRExceptionParmVO();
		
	
		//param local variables 
		String zCntrNo      = DMTCalculationUtil.nullToString(cntrNo);
		long   zCnmvCycNo  	= 0;
		String zBkgNo       = DMTCalculationUtil.nullToString(bkgNo);
		String zDcFmYdCd  	= DMTCalculationUtil.nullToString(podCd);
		String zDttCode     = "";
		String zCntrtsCd    = "";
		String zDbcIoBnd   	= "";
		String zDcApplRate	= DMTCalculationUtil.nullToString(aplyTpCd);  

		
		log.debug("*******************************************************");
		log.debug("[searchBookingCustomerCntrPartialInfo]>> zBkgNo :"+ bkgNo);
		log.debug("[searchBookingCustomerCntrPartialInfo]>> cntrNo :"+ cntrNo);
		log.debug("[searchBookingCustomerCntrPartialInfo]>> podCd :"+ zDcFmYdCd);
		log.debug("[searchBookingCustomerCntrPartialInfo]>> zDcApplRate :"+ zDcApplRate);
		log.debug("*******************************************************");

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
		
//		String zOfcCd		= "";                                              
//		String zOfcRhq		= ""; 
//		String zCollectYn	= ""; 		
		
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
		String fixDtgEfftDt	= "";   /*___ InBound VL Date */                                            
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
//		String zDcFtCmnc	= "";                                                      
//		String zDcFtEnd		= "";                                                      
		long   zDcFtOver	= 0;                                                                                           
//		String zDcStatus	= "";    
		
//		long   zDcOrgOver	= 0;                                             
//		long   zDcBfrOver	= 0;                                             
//		long   zDcAftOver	= 0;  
		
		                                                    
//		double zDcOrgAmt	= 0;                                               
		double zDcExpAmt	= 0;                                               
//		double zDcDscAmt	= 0;                                               
//		double zDcBillAmt	= 0;                                              
		double zDcBfrAmt	= 0;                                              
//		double zDcAftAmt	= 0;    
		
		//S/C
		String zBrhScNo		= "";                                                      
		String zBrhRfaNo	= "";                                                      
		                                                               
//		String zScNo		= "";
		
		String zPropNo      = "";
		long   zScVerSeq	= 0;                                             
		long   zScGrpSeq	= 0; 
		
		String dsdFtimeMk	= "";                                                      
		String dsdExclSat	= "";                                                      
		String dsdExclSun	= "";                                                      
		String dsdExclHoli	= "";                                                      
		String dsdFtAddMk	= "";                                                      
		long   dsdFtAddDay	= 0;                                                     
		String dsdFtAdjMk	= "";                                                      
		String dsdRtAdjMk	= "";                                                      
		String dsdCurCd		= "";    
		
		//COMMODITY
		String zCmdtCd		= "";                                                      
		String zRepCmdtCd	= "";                                                      
		
//		String dcrExclSat	= "";                                                      
//		String dcrExclSun	= "";                                                      
//		String dcrExclHoli	= "";                                                      
//		long   zDcrSeq		= 0;                                                
//		long   dcrAddDay	= 0;                                                
//		long   dcrTtlDay	= 0;                                                
//		long   zDcCmdtOver	= 0;                                                        
//		double zDcCmdtAmt	= 0;           
		
		
		//RFA -  BEFORE
		String zApprNo		= ""; 
		String zDarNo		= ""; 
		long   zMapgSeq		= 0;  
		long   zVerSeq		= 0;  
		long   zDtlSeq		= 0;  
		long   zCmbSeq		= 0;
		
		String dbdFtimeMk	= "";                                                      
		long   dbdAddDay	= 0;                                                
		long   dbdTtlDay	= 0;                                               
		String dbdExclSat	= "";                                                      
		String dbdExclSun	= "";                                                      
		String dbdExclHoli	= "";                                                      
		String dbdRateMk	= "";                                                      
		String dbdCurCd		= "";                                                      
		String dbdFtAdjMk	= ""; //[2016.01.04] NYK Add                                                      
	
		//AFTER
//		String zAftApprNo	= "";                                                      
//		String zAftDarNo	= "";                                                      
//		long   zAftAdjSeq	= 0;  

//		String dadFtimeMk	= "";                                                      
//		long   dadAddDay	= 0;                                              
//		long   dadTtlDay	= 0;                                              
//		String dadExclSat	= "";                                                      
//		String dadExclSun	= "";                                                      
//		String dadExclHoli	= "";                                                      
//		String dadDcMk		= "";                                                      
//		String dadCurCd		= "";                                                      
//		double dadDcAmt		= 0;                                                
//		double dadDcRate	= 0;                                                
		
		String fixPolLoc	= "";
		String zPreRly		= "";
		
		/* ------------------------------------------- */
		
		long   rateDtlCnt 	= 0;
//		double getBfrExRate	= 1.0;	
//		double getAftExRate	= 1.0;	
		
//		long   zDtocFtime	= 0;   
		
//		double tmp1		= 0;					
//		double tmp2		= 0;
		
//		String zFixedVlDt	= "";	/* Fixed VL Date       */
//		String zFixedCmnc	= "";	/* Fixed Commence Date */
		
//		String zWebMtDate	= "";	/* MT Notification		*/
		
		String actCustCntCd = "";	/* BKG A/Cust Cd		*/
		long   actCustSeq   = 0;    /* BKG A/Cust Cd		*/    	                                     
		String awkInOut		= "";   /* In/Out-Gauge			*/ 
		
//		List<String> cstopNoList = null;
//		long		idxCstop	 = 0;

		
		
		String zSvrId 		= "";

		
		String	tmpTsp		= "";		/*	T/S Flag			*/
		String	zOrgContiCd	= "";
		String	zOrgCntCd	= "";
		String	zOrgRgnCd	= "";
		String	zOrgStateCd	= "";
		String	zOrgLocCd	= "";
		
		double	dtrRateAmt = 0.0;
		
		
		//////////////////////END   defind variables    /////////////////                                                                          
                                                                               
		//________________________________ Get BKG Data 
		
		/*		
		[logic] Booking Container  information get
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Booking Container  information get");
		log.debug("*******************************************************");
		
		
		BKGRequestInfoVO bkgRequestInfoVO = null;
		
		try {
			bkgRequestInfoVO = dbDao.searchBKGRequestInfo(zBkgNo, zCntrNo, zDcFmYdCd);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("Invalid BKG No ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			log.error("*******************************************************");
			throw new EventException("Invalid BKG No ! : " + new ErrorHandler(e).getMessage());
		}
		

		if(DMTCalculationUtil.nullToString(chargeByBookingCustomerCntrVO.getIbflag()).equals("NoDataFound")){
			log.error("*******************************************************");
			log.error("[Invalid BKG No(No Data Found) ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			log.error("*******************************************************");
			chargeByBookingCustomerCntrVO.setMsgCd("2");
			chargeByBookingCustomerCntrVO.setMsgDesc("Invalid BKG No(No Data Found) ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			// return status in error. do not stop  in throw.
			return chargeByBookingCustomerCntrVO;
		}
	
		zBlNo 			= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getBlNo());
		zBrhScNo 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getScNo());
		zBrhRfaNo 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getRfaNo());
	
		zCmdtCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getCmdtCd());
		zRepCmdtCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getRepCmdtCd());
		zBcntrSpeDg 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDcgoFlg());
		zBcntrSpeRf 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getRcFlg());
		
		zBcntrSpeAk 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getAwkCgoFlg());
		zBcntrSpeRd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getRdCgoFlg());
		zBcntrSpeBb 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getBbCgoFlg());
		zBcntrSocInd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getSocFlg());
		zBcntrPartial 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getCntrPrtFlg());
		zBcntrExcept 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getAdvShtgCd());
		
		zPorLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorCd());
		zPolLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolCd());
		zPodLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPodCd());
		zDelLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelCd());
		zYrdLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdCd());
		
		zSalOfc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getObSlsOfcCd());
		
		/********************************************************************/
		zPorContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorContiCd());
		zPorCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorCntCd());
		zPorRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorRgnCd());
		zPorStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorSteCd());
		
		zPolContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolContiCd());
		zPolCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolCntCd());
		zPolRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolRgnCd());
		zPolStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolSteCd());
		
		zDelContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelContiCd());
		zDelCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelCntCd());
		zDelRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelRgnCd());
		zDelStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelSteCd());
		
		zYrdContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdContiCd());
		zYrdCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdCntCd());
		zYrdRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdRgnCd());
		zYrdStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdSteCd());

		zPostRly 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPstRlyPortCd(), 5);
		zBcntrDlvTerm	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDeTermCd());
		zPreRly 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPreRlyPortCd(), 5);

		zBkgNo	    	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getBkgNo());
		zCntrNo   		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getCntrNo());
		zCntrtsCd     	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getCntrTpszCd(), 1);
		zCnmvCycNo   	= DMTCalculationUtil.stringToLong(bkgRequestInfoVO.getCnmvCycNo());
		zDbcIoBnd    	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getIoBndCd(), 1);
		zDttCode      	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDmdtTrfCd());

		log.debug("*******************************************************");
		log.debug("[Cal - BKG Data    = :]>> zBlNo 		: "+ zBlNo);	
		
		log.debug("[Cal - BKG Data    = :]>> zPorLoc : "+ zPorLoc);
		log.debug("[Cal - BKG Data    = :]>> zPodLoc : "+ zPodLoc);
		log.debug("[Cal - BKG Data    = :]>> zPolLoc : "+ zPolLoc);
		log.debug("[Cal - BKG Data    = :]>> zPolContiCd : "+ zPolContiCd);
		log.debug("[Cal - BKG Data    = :]>> zPolCntCd : "+ zPolCntCd);
		log.debug("[Cal - BKG Data    = :]>> zPolRgnCd : "+ zPolRgnCd);
		log.debug("[Cal - BKG Data    = :]>> zPolStateCd : "+ zPolStateCd);
		
		log.debug("[Cal - BKG Data    = :]>> zDelLoc : "+ zDelLoc);
		log.debug("[Cal - BKG Data    = :]>> zDelContiCd : "+ zDelContiCd);
		log.debug("[Cal - BKG Data    = :]>> zDelCntCd : "+ zDelCntCd);
		log.debug("[Cal - BKG Data    = :]>> zDelRgnCd : "+ zDelRgnCd);
		log.debug("[Cal - BKG Data    = :]>> zDelStateCd : "+ zDelStateCd);
		
		log.debug("[Cal - BKG Data    = :]>> zYrdLoc : "+ zYrdLoc);
		log.debug("[Cal - BKG Data    = :]>> zYrdContiCd : "+ zYrdContiCd);
		log.debug("[Cal - BKG Data    = :]>> zYrdCntCd : "+ zYrdCntCd);
		log.debug("[Cal - BKG Data    = :]>> zYrdRgnCd : "+ zYrdRgnCd);
		log.debug("[Cal - BKG Data    = :]>> zYrdStateCd : "+ zYrdStateCd);
		
		log.debug("[Cal - BKG Data    = :]>> zBcntrSpeDg : "+ zBcntrSpeDg);
		log.debug("[Cal - BKG Data    = :]>> zBcntrSpeRf : "+ zBcntrSpeRf);
		log.debug("[Cal - BKG Data    = :]>> zBcntrSpeAk : "+ zBcntrSpeAk);
		log.debug("[Cal - BKG Data    = :]>> zBcntrSpeRd : "+ zBcntrSpeRd);
		log.debug("[Cal - BKG Data    = :]>> zBcntrSpeBb : "+ zBcntrSpeBb);
		log.debug("[Cal - BKG Data    = :]>> zBcntrSocInd : "+ zBcntrSocInd);
		log.debug("[Cal - BKG Data    = :]>> zBcntrPartial : "+ zBcntrPartial);
		log.debug("[Cal - BKG Data    = :]>> zBcntrExcept : "+ zBcntrExcept);
		
		log.debug("[Cal - BKG Data    = :]>> zSalOfc : "+ zSalOfc);
		log.debug("[Cal - BKG Data    = :]>> zSalRhq : "+ zSalRhq);
		log.debug("[Cal - BKG Data    = :]>> zBrhScNo : "+ zBrhScNo);
		log.debug("[Cal - BKG Data    = :]>> zBrhRfaNo : "+ zBrhRfaNo);
		log.debug("[Cal - BKG Data    = :]>> zCmdtCd : "+ zCmdtCd);
		log.debug("[Cal - BKG Data    = :]>> zRepCmdtCd : "+ zRepCmdtCd);
		log.debug("[Cal - BKG Data    = :]>> zPostRly : "+ zPostRly);
		log.debug("[Cal - BKG Data    = :]>> zBcntrDlvTerm : "+ zBcntrDlvTerm);
		log.debug("[Cal - BKG Data    = :]>> zPreRly : "+ zPreRly);
		
		log.debug("[Cal - BKG Data    = :]>> zBkgNo : "+ zBkgNo);
		log.debug("[Cal - BKG Data    = :]>> zCntrNo : "+ zCntrNo);
		log.debug("[Cal - BKG Data    = :]>> zCntrtsCd : "+ zCntrtsCd);
		log.debug("[Cal - BKG Data    = :]>> zCnmvCycNo : "+ zCnmvCycNo);
		log.debug("[Cal - BKG Data    = :]>> zDbcIoBnd : "+ zDbcIoBnd);
		log.debug("[Cal - BKG Data    = :]>> zDttCode : "+ zDttCode);
		log.debug("*******************************************************");

		/*
		[logic] Set CNTR TYPE 
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Set CNTR TYPE ");
		log.debug("*******************************************************");
		zDcsCntrTp = zCntrtsCd.substring(0, 1);
		if(zDcsCntrTp.substring(0, 1).equals("P")){
			zDcsCntrTp = "F";
		}
		
		log.debug("*******************************************************");
		log.debug("[Set Cntr Type]>> zDcsCntrTp :"+ zDcsCntrTp);
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

		log.debug("*******************************************************");
		log.debug("[Cal - CNTR N CGO  =:]>> zDcsCntrTp : "+ zDcsCntrTp);
		log.debug("[Cal - CNTR N CGO  =:]>> zDcsCgoTp : "+ zDcsCgoTp);
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
			throw new EventException("Bkg Qty Select Error :" + new ErrorHandler(e).getMessage());
		}
		

		log.debug("*******************************************************");
		log.debug("[Cal - QTY         = :]>> zDbcBkgQty : "+ zDbcBkgQty);
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
		bkgCntCd 	=	locationByBoundVO.getBkgCntCd();
		bkgRgnCd  	=	locationByBoundVO.getBkgRgnCd();
		bkgStateCd	=	locationByBoundVO.getBkgStateCd();
		bkgLocCd  	=	locationByBoundVO.getBkgLocCd();
		
		log.debug("*******************************************************");
		log.debug("[setLocationByBound:]>> bkgCntCd : "+ bkgCntCd);
		log.debug("[setLocationByBound:]>> bkgRgnCd : "+ bkgRgnCd);
		log.debug("[setLocationByBound:]>> bkgStateCd : "+ bkgStateCd);
		log.debug("[setLocationByBound:]>> bkgLocCd : "+ bkgLocCd);
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
		fixPODLocationParmVO.setBkgNo(zBkgNo); //2010.03.26 
		fixPodLoc = DMTCalculationUtil.nullToString(dmtCalculationUtil.fixPODLocation(fixPODLocationParmVO), 5);
		
		
		log.debug("*******************************************************");
		log.debug("[2001 fixPodLoc:]>> fixPodLoc : "+ fixPodLoc);
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
		
		
		log.debug("*******************************************************");
		log.debug("[2002 fixPOLLocation:tmpTsp]>> fixPolLoc : "+ fixPolLoc);
		log.debug("*******************************************************");
		
		
		/*
		[logic] Booking VVD, ETA  get : Get VVD & ETA Date
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Booking의 VVD, ETA  get : Get VVD & ETA Date *");
		log.debug("*******************************************************");
		
		VVDNEtaVO vvEtaVO = new VVDNEtaVO();
		try {
			vvEtaVO = dmtCalculationUtil.searchVVDNEta(zBkgNo, fixPolLoc, fixPodLoc, zDbcIoBnd);	
			zVslCd			= DMTCalculationUtil.nullToString(vvEtaVO.getVslCd());
			zSkdVoyageNo	= DMTCalculationUtil.nullToString(vvEtaVO.getSkdVoyNo());
			zSkdDirCd		= DMTCalculationUtil.nullToString(vvEtaVO.getSkdDirCd());
			zVpsEtaDt		= DMTCalculationUtil.nullToString(vvEtaVO.getVpsEtaDt(), 8);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* Eta Date Select Error - :"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException(" Eta Date Select Error - :" + new ErrorHandler(e).getMessage());
		}
		if(!DMTCalculationUtil.nullToString(vvEtaVO.getBkgNo()).equals("")){
			log.debug("*******************************************************");
			log.debug("** * zVslCd:"+zVslCd);
			log.debug("*******************************************************");
		} 
		else if(DMTCalculationUtil.nullToString(vvEtaVO.getBkgNo()).equals("")){
			log.debug("********************************");
			log.debug("** BKG VVD Not Found - BKG NO **");
			log.debug("********************************");
			chargeByBookingCustomerCntrVO.setMsgCd("2");
			chargeByBookingCustomerCntrVO.setMsgDesc("* BKG VVD Not Found - BKG NO:"+zBkgNo+
					", BND:"+zDbcIoBnd+", POL: "+fixPolLoc+", POD:"+fixPodLoc);
			// return status in error. do not stop  in throw.
			return chargeByBookingCustomerCntrVO;
		}

		log.debug("*******************************************************");
		log.debug("[* Cal - VVD         =:]>> zVslCd : "+ zVslCd);
		log.debug("[* Cal - VVD         =:]>> zSkdVoyageNo : "+ zSkdVoyageNo);
		log.debug("[* Cal - VVD         =:]>> zSkdDirCd : "+ zSkdDirCd);
		log.debug("[* Cal - VVD         =:]>> zVpsEtaDt : "+ zVpsEtaDt);
		log.debug("*******************************************************");
		
		/*
		[logic] Tariff Effective Date decision : Set Tariff Effective Date
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Tariff Effective Date decision : Set Tariff Effective Date *");
		log.debug("*******************************************************");
		
		if(zDbcIoBnd.substring(0, 1).equals("I") && zVpsEtaDt.length() != 0){
			dtgEfftDt = zVpsEtaDt.substring(0, 8);
		}

		
		log.debug("*******************************************************");
		log.debug("[Set Tariff Effective Date:]>> dtgEfftDt : "+ dtgEfftDt);
		log.debug("*******************************************************");
		
				
		/*
		[logic] Booking DEL Location decision :  BKG DEL Loc Fix
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
		fixDELLocationParmVO.setFmMvmtStsCd("");
		fixDELLocationParmVO.setToMvmtStsCd("");
		fixDELLocationParmVO.setIoBnd(zDbcIoBnd);
		fixDELLocationParmVO.setTspFlag("");
		fixDELLocationParmVO.setPostRly(zPostRly);
		fixDELLocationParmVO.setPreRly(zPreRly);
		FixDELLocationVO fixDELLocationVO;
		try {
			fixDELLocationVO = dmtCalculationUtil.fixDELLocation(fixDELLocationParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* Fixed DEL Loc Select Error!"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* Fixed DEL Loc Select Error! " + new ErrorHandler(e).getMessage());
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
			fixDelCntCd 	= zDelCntCd;
			fixDelRgnCd 	= zDelRgnCd;
			fixDelStateCd 	= zDelStateCd;
			fixDelLoc 		= zDelLoc;
		}
		
		log.debug("*******************************************************");
		log.debug("[fixDelLoc:]>> fixDelContiCd : "+ fixDelContiCd);
		log.debug("[fixDelLoc:]>> fixDelCntCd : "+ fixDelCntCd);
		log.debug("[fixDelLoc:]>> fixDelRgnCd : "+ fixDelRgnCd);
		log.debug("[fixDelLoc:]>> fixDelStateCd : "+ fixDelStateCd);
		log.debug("[fixDelLoc:]>> fixDelLoc : "+ fixDelLoc);
		log.debug("*******************************************************");

		
		/*	Tariff Origin Area adjustment - case in EUR T/S O/B , DEL change to ORG	*/
		log.debug("*******************************************************");
		log.debug("* [logic] Tariff의 Origin Area adjustment - case in EUR T/S O/B , DEL change to ORG");
		log.debug("*******************************************************");
		
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
			throw new EventException("Fixed ORG Loc Select Error! " + new ErrorHandler(e).getMessage());
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
			zOrgContiCd 	= zPolContiCd;
			zOrgCntCd 		= zPolCntCd;
			zOrgRgnCd 		= zPolRgnCd;
			zOrgStateCd 	= zPolStateCd;
			zOrgLocCd 		= zPolLoc;
		}
		
		log.debug("*******************************************************");
		log.debug("[zOrgLocCd:]>> zOrgLocCd : "+ zOrgLocCd);
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
		log.debug("[searchAwkInOut:]>> awkInOut : "+ awkInOut);
		log.debug("*******************************************************");
		
		
		if(zDcApplRate.equals("G") ){		
		
			/*		
			[logic] Get 3 FLAGS / CURCD
			*/
		
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
			BasicTariffKeyVO basicTariffKeyVO = null;
			
			String podNodCd = "";
			try {
				podNodCd = dbDao.searchPodNodCd(zBkgNo);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*searchPodNodCd Functon Error!"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchPodNodCd Functon Error!" + new ErrorHandler(e).getMessage());
			}
			basicTariffParmVO.setCvrgYdCd(podNodCd);
			
			try {
				basicTariffKeyVO = dmtCalculationUtil.searchBasicTariffByGeneration(basicTariffParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*searchBasicTariffByGeneration Functon Error!"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchBasicTariffByGeneration Functon Error!" + new ErrorHandler(e).getMessage());
			}
			if(DMTCalculationUtil.nullToString(basicTariffKeyVO.getSvrId()).equals("")){
				chargeByBookingCustomerCntrVO.setMsgCd("2");
				chargeByBookingCustomerCntrVO.setMsgDesc("Tariff Not Found ! "+ zDttCode + ", "+ zPorCntCd+ ", "+ zYrdCntCd
						+ ", "+ zPolCntCd+ ", "+ fixDelCntCd+ ", "+ zDcsCntrTp+ ", "+ zDcsCgoTp+ ", "+ dtgEfftDt);
				// return status in error. do not stop  in throw.
				return chargeByBookingCustomerCntrVO;
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
	
			}
		
			log.debug("*******************************************************");
			log.debug("* [Cal - BSC TRF] zSvrId :"+zSvrId);
			log.debug("* [Cal - BSC TRF] zDttCode :"+zDttCode);
			log.debug("* [Cal - BSC TRF] zDtnSeq :"+zDtnSeq);
			log.debug("* [Cal - BSC TRF] zDtgGrpId :"+zDtgGrpId);
			
			
			log.debug("* [Cal - BSC TRF] dtgCmncTp :"+dtgCmncTp);
			log.debug("* [Cal - BSC TRF] dtgCmncHr :"+dtgCmncHr);
			log.debug("* [Cal - BSC TRF] dtgExclSat :"+dtgExclSat);
			log.debug("* [Cal - BSC TRF] dtgExclSun :"+dtgExclSun);
			log.debug("* [Cal - BSC TRF] dtgExclHoli :"+dtgExclHoli);
			log.debug("* [Cal - BSC TRF] zCurCd :"+zCurCd);
			log.debug("*******************************************************");
	
			/*		
			[logic] Get FTDAYS
			*/
			
			try {
				zDcFtDays = dmtCalculationUtil.basicFreeTime(zSvrId, zDttCode, zDtnSeq, zDtgGrpId, zDbcBkgQty);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("** FreeTime Function Error"+ e.getMessage()+ ", "+ zDttCode+ ", "+ zDtnSeq+ ", "+ zDtgGrpId+ ", "+ zDbcBkgQty);
				log.error("*******************************************************");
				throw new EventException("FreeTime Function Error ! : " + new ErrorHandler(e).getMessage());
			}
			log.debug("*******************************************************");
			log.debug("* [Cal - BSC Ftime] zDcFtDays :"+zDcFtDays);
			log.debug("*******************************************************");
			
	
			/*
			[logic]  Get RTAMT
			*/
		
			calculationParmVO.setSvrId(zSvrId);
			calculationParmVO.setDmdtTrfCd(zDttCode);
			calculationParmVO.setTrfSeq(String.valueOf(zDtnSeq));
			calculationParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
			calculationParmVO.setDivOverDay("0");
			
			try {
				dtrRateAmt = dmtCalculationUtil.basicCalculationByBKG(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*  Charge & Total Function Error:"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("Charge & Total Function Error:" + new ErrorHandler(e).getMessage());
			}
		
			
			log.debug("*******************************************************");
			log.debug("* [Cal - dtrRateAmt     = ] dtrRateAmt :"+dtrRateAmt);
			log.debug("*******************************************************");
			
			/* Set The chargeByBookingCustomerCntrVO*/
			log.debug("*******************************************************");
			log.debug("****  Set The chargeByBookingCustomerCntrVO  **************");
			log.debug("* [chargeByBookingCustomerCntrVO ] zDcFtDays :"+zDcFtDays);
			log.debug("* [chargeByBookingCustomerCntrVO ] dtgExclSat :"+dtgExclSat);
			log.debug("* [chargeByBookingCustomerCntrVO ] dtgExclSun :"+dtgExclSun);
			log.debug("* [chargeByBookingCustomerCntrVO ] dtgExclHoli :"+dtgExclHoli);
			log.debug("* [chargeByBookingCustomerCntrVO ] zCurCd :"+zCurCd);
			log.debug("* [chargeByBookingCustomerCntrVO ] dtrRateAmt :"+dtrRateAmt);
			log.debug("*******************************************************");
			
			chargeByBookingCustomerCntrVO.setFtDys(String.valueOf(zDcFtDays));
			chargeByBookingCustomerCntrVO.setXcldSatFlg(dtgExclSat);
			chargeByBookingCustomerCntrVO.setXcldSunFlg(dtgExclSun);
			chargeByBookingCustomerCntrVO.setXcldHolFlg(dtgExclHoli);
			chargeByBookingCustomerCntrVO.setCurrCd(zCurCd);
			chargeByBookingCustomerCntrVO.setCntrRtAmt(String.valueOf(dtrRateAmt));
			chargeByBookingCustomerCntrVO.setMsgCd("0");
			
		} else if(zDcApplRate.equals("S") ){		
			/*		
			[logic] Get 3 FLAGS / CURCD
			*/
			
		
			scExceptionParmVO.setPorContiCd(zPorContiCd);
			scExceptionParmVO.setPorCntCd(zPorCntCd);
			scExceptionParmVO.setPorRgnCd(zPorRgnCd);
			scExceptionParmVO.setPorSteCd(zPorStateCd);
			scExceptionParmVO.setPorLocCd(zPorLoc);
			
			scExceptionParmVO.setYrdContiCd(zYrdContiCd);
			scExceptionParmVO.setYrdCntCd(zYrdCntCd);
			scExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
			scExceptionParmVO.setYrdSteCd(zYrdStateCd);
			scExceptionParmVO.setYrdLocCd(zYrdLoc);

			scExceptionParmVO.setPolContiCd(zPolContiCd);
			scExceptionParmVO.setPolCntCd(zPolCntCd);
			scExceptionParmVO.setPolRgnCd(zPolRgnCd);
			scExceptionParmVO.setPolSteCd(zPolStateCd);
			scExceptionParmVO.setPolLocCd(zPolLoc);
			
			scExceptionParmVO.setDelContiCd(zDelContiCd);
			scExceptionParmVO.setDelCntCd(zDelCntCd);
			scExceptionParmVO.setDelRgnCd(zDelRgnCd);
			scExceptionParmVO.setDelSteCd(zDelStateCd);
			scExceptionParmVO.setDelLocCd(zDelLoc);
			
			scExceptionParmVO.setScNo(zBrhScNo);
			scExceptionParmVO.setDttCode(zDttCode);
			scExceptionParmVO.setIoBndCd(zDbcIoBnd);
			scExceptionParmVO.setCntrTp(zDcsCntrTp);
			scExceptionParmVO.setCgoTp(zDcsCgoTp);
			scExceptionParmVO.setEfftDt(fixDtgEfftDt.trim());

			scExceptionParmVO.setCmdtCd(zCmdtCd);
			scExceptionParmVO.setRepCmdtCd(zRepCmdtCd);
			scExceptionParmVO.setCustCntCd("");
			scExceptionParmVO.setCustCd("");
			
			scExceptionParmVO.setAwkInOut(awkInOut);//[CLT-000039159-04] 2015.04.28 Modify awkInOut 추가.
			log.debug("*******************************************************");
			log.debug("* searchBookingCustomerCntrPartialInfo [scExceptionParmVO] awkInOut :["+awkInOut+"]");
			log.debug("*******************************************************");
			
			
			DmtSCGrpVO dmtSCGrpVO = null;
			try {
				dmtSCGrpVO = dmtCalculationUtil.searchSCExceptionByGeneration(scExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*  searchSCExceptionByGeneration Functon Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchSCExceptionByGeneration Functon Error :" + new ErrorHandler(e).getMessage());
			}
			
			if(DMTCalculationUtil.nullToString(dmtSCGrpVO.getPropNo()).equals("")){
				zDcExpAmt = 0;
				zDcBfrAmt = 0;
			} else {
				/*_____________ Apply SC Exception */
				zPropNo			= 	DMTCalculationUtil.nullToString(dmtSCGrpVO.getPropNo()); 
				zScVerSeq		= 	DMTCalculationUtil.stringToLong(dmtSCGrpVO.getVerSeq()); 
				zScGrpSeq		= 	DMTCalculationUtil.stringToLong(dmtSCGrpVO.getGrpSeq()); 
				
				dsdFtimeMk		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getFtimeMk());
				dsdExclSat		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getExclSat());
				dsdExclSun		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getExclSun());
				dsdExclHoli		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getExclHoli());
				dsdFtAddMk		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getFtAddMk()); 
				dsdFtAddDay		=	DMTCalculationUtil.stringToLong(dmtSCGrpVO.getFtAddDay()); 
				dsdFtAdjMk		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getFtAdjMk()); 
				dsdRtAdjMk		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getRtAdjMk()); 
				dsdCurCd			=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getCurCd()); 

				log.debug("*******************************************************");
				log.debug("* Cal - USC No    =  ] zPropNo :"+zPropNo);
				log.debug("* Cal - USC No    =  ] zScVerSeq :"+zScVerSeq);
				log.debug("* Cal - USC No    =  ] zScGrpSeq :"+zScGrpSeq);
				log.debug("*******************************************************");
				
				log.debug("*******************************************************");
				log.debug("* Cal - USC EXP     =  ] dsdFtimeMk :"+dsdFtimeMk);
				log.debug("* Cal - USC EXP     =  ] dsdExclSat :"+dsdExclSat);
				log.debug("* Cal - USC EXP     =  ] dsdExclSun :"+dsdExclSun);
				log.debug("* Cal - USC EXP     =  ] dsdExclHoli :"+dsdExclHoli);
				log.debug("* Cal - USC EXP     =  ] dsdFtAddMk :"+dsdFtAddMk);
				log.debug("* Cal - USC EXP     =  ] dsdFtAddDay :"+dsdFtAddDay);
				log.debug("* Cal - USC EXP     =  ] dsdFtAdjMk :"+dsdFtAdjMk);
				log.debug("* Cal - USC EXP     =  ] dsdRtAdjMk :"+dsdRtAdjMk);
				log.debug("* Cal - USC EXP     =  ] dsdCurCd :"+dsdCurCd);
				log.debug("*******************************************************");
			}
			/*		
			[logic] Get FTDAYS
			*/
			 
			/* ________________________ Get USCE Free Day */
			zDcFtDays = 0;

			try {
				zDcFtDays = dmtCalculationUtil.getSCEFreeTime(zPropNo, zScVerSeq, zScGrpSeq, zDbcBkgQty);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*  getSCEFreeTime Function Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("getSCEFreeTime Function Error :" + new ErrorHandler(e).getMessage());
			}

			log.debug("*******************************************************");
			log.debug("*  Cal - USC Ftime     =  ] zDcFtDays :"+zDcFtDays);
			log.debug("*******************************************************");

			/*
			[logic]  Get RTAMT
			*/
//			calculationParmVO.setPropNo(zPropNo);
			calculationParmVO.setPropNo(zBrhScNo);//zScNo zPropNo
			calculationParmVO.setVerSeq(String.valueOf(zScVerSeq));
			calculationParmVO.setGrpSeq(String.valueOf(zScGrpSeq));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
			calculationParmVO.setDivOverDay("0");	
			
			try {
				dtrRateAmt = dmtCalculationUtil.scCalculationByBKG(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("USCE Amount - scCalculation Function Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("USCE Amount - scCalculation Function Error :" + new ErrorHandler(e).getMessage());
			}
		
			log.debug("*******************************************************");
			log.debug("* [Cal - dtrRateAmt     = ] dtrRateAmt :"+dtrRateAmt);
			log.debug("*******************************************************");
			
			/* Set The chargeByBookingCustomerCntrVO*/
			log.debug("*******************************************************");
			log.debug("****  Set The chargeByBookingCustomerCntrVO  **************");
			log.debug("* [chargeByBookingCustomerCntrVO ] zDcFtDays :"+zDcFtDays);
			log.debug("* [chargeByBookingCustomerCntrVO ] dsdExclSat :"+dsdExclSat);
			log.debug("* [chargeByBookingCustomerCntrVO ] dsdExclSun :"+dsdExclSun);
			log.debug("* [chargeByBookingCustomerCntrVO ] dsdExclHoli :"+dsdExclHoli);
			log.debug("* [chargeByBookingCustomerCntrVO ] zCurCd :"+zCurCd);
			log.debug("* [chargeByBookingCustomerCntrVO ] dtrRateAmt :"+dtrRateAmt);
			log.debug("*******************************************************");
			
			chargeByBookingCustomerCntrVO.setFtDys(String.valueOf(zDcFtDays));
			chargeByBookingCustomerCntrVO.setXcldSatFlg(dsdExclSat);
			chargeByBookingCustomerCntrVO.setXcldSunFlg(dsdExclSun);
			chargeByBookingCustomerCntrVO.setXcldHolFlg(dsdExclHoli);
			chargeByBookingCustomerCntrVO.setCurrCd(dsdCurCd);
			chargeByBookingCustomerCntrVO.setCntrRtAmt(String.valueOf(dtrRateAmt));
			chargeByBookingCustomerCntrVO.setMsgCd("0");
			
		} else if(zDcApplRate.equals("B") ){
			/*		
			[logic] Get 3 FLAGS / CURCD
			*/
			bfrExceptionParmVO.setPorContiCd(zPorContiCd);
			bfrExceptionParmVO.setPorCntCd(zPorCntCd);
			bfrExceptionParmVO.setPorRgnCd(zPorRgnCd);
			bfrExceptionParmVO.setPorSteCd(zPorStateCd);
			bfrExceptionParmVO.setPorLocCd(zPorLoc);
			
			bfrExceptionParmVO.setYrdContiCd(zYrdContiCd);
			bfrExceptionParmVO.setYrdCntCd(zYrdCntCd);
			bfrExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
			bfrExceptionParmVO.setYrdSteCd(zYrdStateCd);
			bfrExceptionParmVO.setYrdLocCd(zYrdLoc);

			bfrExceptionParmVO.setPolContiCd(zPolContiCd);                    
			bfrExceptionParmVO.setPolCntCd(zPolCntCd);                
			bfrExceptionParmVO.setPolRgnCd(zPolRgnCd);                
			bfrExceptionParmVO.setPolLocCd(zPolLoc);      
			
			bfrExceptionParmVO.setDelContiCd(zDelContiCd);                    
			bfrExceptionParmVO.setDelCntCd(zDelCntCd);                
			bfrExceptionParmVO.setDelRgnCd(zDelRgnCd);                
			bfrExceptionParmVO.setDelLocCd(zDelLoc);                   
			
			bfrExceptionParmVO.setDmdtTrfCd(zDttCode);                         
			bfrExceptionParmVO.setScNo(zBrhScNo);                   
			bfrExceptionParmVO.setRfaNo(zBrhRfaNo);                 
			bfrExceptionParmVO.setCntrTp(zDcsCntrTp);               
			bfrExceptionParmVO.setCgoTp(zDcsCgoTp);                 
			bfrExceptionParmVO.setIoBndCd(zDbcIoBnd);                 
			bfrExceptionParmVO.setEfftDt(fixDtgEfftDt.trim()); //2010.04.05.           
			bfrExceptionParmVO.setActCustCntCd(actCustCntCd); 
			bfrExceptionParmVO.setActCustSeq(String.valueOf(actCustSeq));
			bfrExceptionParmVO.setAwkInOut(awkInOut);
			
			bfrExceptionParmVO.setCmdtCd(zCmdtCd); //[2016.01.04] NYK Add
			
			DmtBFRGrpVO dmtBFRGrpVO = null;
			try {
				dmtBFRGrpVO = dmtCalculationUtil.searchBFRExceptionByGeneration(bfrExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("searchBFRExceptionByGeneration Function Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchBFRExceptionByGeneration Function Error :" + new ErrorHandler(e).getMessage());
			}
			if(DMTCalculationUtil.nullToString(dmtBFRGrpVO.getApprNo()).equals("")){
				zDcExpAmt = 0;
				zDcBfrAmt = 0;
			} else {
				//주요 필드는  change 
				zApprNo			= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getApprNo());
				zDarNo			= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getDarNo());
				zMapgSeq		= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getMapgSeq());
				zVerSeq			= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getVerSeq());
				zDtlSeq			= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getDtlSeq());
				zCmbSeq			= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getCmbSeq());
				
				
				dbdFtimeMk		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getFtimeMk());
				dbdAddDay   	= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getAddDay());
				dbdTtlDay		= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getTtlDay());
				dbdExclSat		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getExclSat());
				dbdExclSun		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getExclSun());
				dbdExclHoli		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getExclHoli());
				dbdRateMk		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getRateMk());
				dbdCurCd		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getCurCd());
				dbdFtAdjMk		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getFtAdjMk());//[2016.01.04] NYK Add
				
				log.debug("*******************************************************");
				log.debug("* Cal - BFR Req No  =  ] zApprNo :"+zApprNo);
				log.debug("* Cal - BFR Req No  =  ] zDarNo :"+zDarNo);
				log.debug("* Cal - BFR Req No  =  ] zMapgSeq :"+zMapgSeq);
				log.debug("* Cal - BFR Req No  =  ] zVerSeq :"+zVerSeq);
				log.debug("* Cal - BFR Req No  =  ] zDtlSeq :"+zDtlSeq);
				log.debug("* Cal - BFR Req No  =  ] zCmbSeq :"+zCmbSeq);
				log.debug("*******************************************************");
				
				log.debug("*******************************************************");
				log.debug("* Cal - BFR EXP  =  ] dbdFtimeMk :"+dbdFtimeMk);
				log.debug("* Cal - BFR EXP  =  ] dbdAddDay :"+dbdAddDay);
				log.debug("* Cal - BFR EXP  =  ] dbdTtlDay :"+dbdTtlDay);
				log.debug("* Cal - BFR EXP  =  ] dbdExclSat :"+dbdExclSat);
				log.debug("* Cal - BFR EXP  =  ] dbdExclSun :"+dbdExclSun);
				log.debug("* Cal - BFR EXP  =  ] dbdExclHoli :"+dbdExclHoli);
				log.debug("* Cal - BFR EXP  =  ] dbdRateMk :"+dbdRateMk);
				log.debug("* Cal - BFR EXP  =  ] dbdCurCd :"+dbdCurCd);
				log.debug("* Cal - BFR EXP  =  ] dbdFtAdjMk :"+dbdFtAdjMk);
				log.debug("*******************************************************");
			}
			/*		
			[logic] Get FTDAYS
			*/			
			if(dbdFtAdjMk.equals("Y")){
				//[2016.01.04] NYK Add Start.==============
				zDcFtDays = 0;
				try {
					zDcFtDays = dmtCalculationUtil.getRFAFreeTime(zDarNo, zMapgSeq, zVerSeq, zDtlSeq, zCmbSeq, zDbcBkgQty);
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("*  getRFAFreeTime 2016.01.04 Function Error :"+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("getRFAFreeTime 2016.01.04 Function Error :" + new ErrorHandler(e).getMessage());
				}
	
				log.debug("*******************************************************");
				log.debug("*  Cal - BFR EXP FreeTime ] 2016.01.04 zDcFtDays :"+zDcFtDays);
				log.debug("*******************************************************");
				//[2016.01.04] NYK Add E n d.==============		
			}else{
				zDcFtDays = dbdTtlDay; //AS-IS Logic
				
				log.debug("[logic] zDcFtDays = dbdTtlDay ["+zDcFtDays+"]");
			}
			
			/*
			[logic]  Get RTAMT
			*/
				
			calculationParmVO.setDarNo(zDarNo);
			calculationParmVO.setMapgSeq(String.valueOf(zMapgSeq));
			calculationParmVO.setVerSeq(String.valueOf(zVerSeq));
			calculationParmVO.setDtlSeq(String.valueOf(zDtlSeq));
			calculationParmVO.setCmbSeq(String.valueOf(zCmbSeq));
			
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
			calculationParmVO.setDivOverDay("0");	
			
			try {
				dtrRateAmt = dmtCalculationUtil.beforeCalculationByBKG(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*  beforeCalculation Function Error ::"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("beforeCalculation Function Error ::" + new ErrorHandler(e).getMessage());
			}
			log.debug("*******************************************************");
			log.debug("* Cal - BFR AMT    =  ] zDcBfrAmt :"+zDcBfrAmt);
			log.debug("* Cal - BFR AMT    =  ] rateDtlCnt :"+rateDtlCnt);
			log.debug("*******************************************************");
			
			chargeByBookingCustomerCntrVO.setFtDys(StringUtils.defaultString(String.valueOf(zDcFtDays)));
			chargeByBookingCustomerCntrVO.setXcldSatFlg(StringUtils.defaultString(dbdExclSat));
			chargeByBookingCustomerCntrVO.setXcldSunFlg(StringUtils.defaultString(dbdExclSun));
			chargeByBookingCustomerCntrVO.setXcldHolFlg(StringUtils.defaultString(dbdExclHoli));
			chargeByBookingCustomerCntrVO.setCurrCd(StringUtils.defaultString(dbdCurCd));
			chargeByBookingCustomerCntrVO.setCntrRtAmt(StringUtils.defaultString(String.valueOf(dtrRateAmt)));
			chargeByBookingCustomerCntrVO.setMsgCd("0");
			
		}
		
		chargeByBookingCustomerCntrVO.setBkgNo(zBkgNo);
		chargeByBookingCustomerCntrVO.setCntrNo(zCntrNo);
		chargeByBookingCustomerCntrVO.setDmdtTrfCd(zDttCode);
		
		
		
		log.debug("****searchBookingCustomerCntrPartialInfo****************");
		log.debug("* return = getBkgNo ] "+chargeByBookingCustomerCntrVO.getBkgNo());
		log.debug("* return = getCntrNo ] "+chargeByBookingCustomerCntrVO.getCntrNo());
		log.debug("* return = getFtDys ] "+chargeByBookingCustomerCntrVO.getFtDys());
		log.debug("* return = getXcldSatFlg ] "+chargeByBookingCustomerCntrVO.getXcldSatFlg());
		log.debug("* return = getXcldSunFlg ] "+chargeByBookingCustomerCntrVO.getXcldSunFlg());
		log.debug("* return = getXcldHolFlg ] "+chargeByBookingCustomerCntrVO.getXcldHolFlg());
		log.debug("* return = getCurrCd ] "+chargeByBookingCustomerCntrVO.getCurrCd());
		log.debug("* return = getCntrRtAmt ] "+chargeByBookingCustomerCntrVO.getCntrRtAmt());
		log.debug("* return = getDmdtTrfCd ] "+chargeByBookingCustomerCntrVO.getDmdtTrfCd());
		log.debug("*******************************************************");
		
		
		return chargeByBookingCustomerCntrVO;
	}


	/**
	 *  searchBookingCustomerBasicData Search
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return BookingCustomerBasicVO
	 * @throws DAOException 
	 * @exception EventException
	 */
	public BookingCustomerBasicVO searchBookingCustomerBasicData(String bkgNo, String cntrNo) throws DAOException {
		return	dbDao.searchBookingCustomerBasicData(bkgNo, cntrNo);
	}

	/**
	 *  searchBookingCustomerCntr Search
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return ChargeByBookingCustomerCntrVO
	 * @throws DAOException 
	 * @exception EventException
	 */
	public ChargeByBookingCustomerCntrVO searchBookingCustomerCntr(String bkgNo, String cntrNo) throws DAOException {
		return dbDao.searchBookingCustomerCntr(bkgNo, cntrNo);
	}


	/**
	 *  searchChargeByBookingCustomerInvList Search
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return List<ChargeByBookingCustomerInvVO>
	 * @throws DAOException 
	 * @exception EventException
	 */
	public List<ChargeByBookingCustomerInvVO> searchChargeByBookingCustomerInvList(
			String bkgNo, String cntrNo) throws DAOException {
		
		return dbDao.searchChargeByBookingCustomerInvList(bkgNo, cntrNo);
	}
	
	/**
	 *  preChargeCalculation Search
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return chargeByBookingCustomerCntrVO
	 * @exception EventException
	 * @throws DAOException 
	 */
	public ChargeByBookingCustomerCntrVO preChargeCalculation(ChargeCalculationParmVO chargeCalculationParmVO) 
	throws EventException, DAOException{
		
		ChargeByBookingCustomerCntrVO chargeByBookingCustomerCntrVO = new ChargeByBookingCustomerCntrVO();
		//parameter values
		ContainerCargoTypeParmVO 	containerCargoTypeParmVO 	= new ContainerCargoTypeParmVO();
		CalculationParmVO 			calculationParmVO 			= new CalculationParmVO();
		FixPOLLocationParmVO 		fixPOLLocationParmVO 		= new FixPOLLocationParmVO();
		FixPODLocationParmVO 		fixPODLocationParmVO 		= new FixPODLocationParmVO();
		FreeTimeStartParmVO 		freeTimeStartParmVO 		= new FreeTimeStartParmVO();
		FreeTimeEndParmVO 			freeTimeEndParmVO 			= new FreeTimeEndParmVO();
		CommodityExceptionParmVO 	commodityExceptionParmVO 	= new CommodityExceptionParmVO();
		LocationByBoundParmVO 		locationByBoundParmVO 		= new LocationByBoundParmVO();
		FixDELLocationParmVO 		fixDELLocationParmVO 		= new FixDELLocationParmVO();
		FixORGLocationParmVO 		fixORGLocationParmVO 		= new FixORGLocationParmVO();
		BasicTariffParmVO 			basicTariffParmVO 			= new BasicTariffParmVO();
		DtocFreeTimeParmVO 			dtocFreeTimeParmVO 			= new DtocFreeTimeParmVO();
		OverdayNStatusParmVO 		overdayNStatusParmVO 		= new OverdayNStatusParmVO();
		SCExceptionParmVO 			scExceptionParmVO 			= new SCExceptionParmVO();
		BFRExceptionParmVO 			bfrExceptionParmVO 			= new BFRExceptionParmVO();
		AFTExceptionParmVO 			aftExceptionParmVO 			= new AFTExceptionParmVO();
		ExchangeRateParmVO 			exchangeRateParmVO	 		= new ExchangeRateParmVO();
		
		//param local variables 
		String zCntrNo     = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrNo());
		long   zCnmvCycNo  = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getCntrCycNo());
		String zBkgNo      = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getBkgNo());
		String zDcFmDate   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtDt());
		String zDcFmYdCd   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtYdCd());
		String zDcFmCnms   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtStsCd());
		String zDcToDate   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtDt());
		String zDcToYdCd   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtYdCd());
		String zDcToCnms   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtStsCd());
		String zDttCode    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtTrfCd());
		String zCntrtsCd   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrTpszCd());
		String zDbcIoBnd   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getIoBndCd());
		String zCustCntCd  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCustCntCd());
		String zCustCd     = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCustSeq());
		String zAczCnzCd   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getActCntCd());
		String zAczCuszCd  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getActCustSeq());
		String zLocDiv  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtChgLocDivCd());
		
		log.debug("*******************************************************");
		log.debug("[ChargeCalculationParmVO]>> zCntrNo :"+ zCntrNo);
		log.debug("[ChargeCalculationParmVO]>> zCnmvCycNo :"+ zCnmvCycNo); //search
		log.debug("[ChargeCalculationParmVO]>> zDcFmDate :"+ zDcFmDate);   //search
		log.debug("[ChargeCalculationParmVO]>> zDcFmYdCd :"+ zDcFmYdCd);   //search
		log.debug("[ChargeCalculationParmVO]>> zDcFmCnms :"+ zDcFmCnms);   //search
		log.debug("[ChargeCalculationParmVO]>> zDcToDate :"+ zDcToDate);   //param
		log.debug("[ChargeCalculationParmVO]>> zDcToYdCd :"+ zDcToYdCd);   //search
		log.debug("[ChargeCalculationParmVO]>> zDcToCnms :"+ zDcToCnms);   //search
		log.debug("[ChargeCalculationParmVO]>> zDttCode :"+ zDttCode);     //search
		log.debug("[ChargeCalculationParmVO]>> zCntrtsCd :"+ zCntrtsCd);   //
		log.debug("[ChargeCalculationParmVO]>> zDbcIoBnd :"+ zDbcIoBnd);   //search
		log.debug("[ChargeCalculationParmVO]>> zCustCntCd :"+ zCustCntCd); //search
		log.debug("[ChargeCalculationParmVO]>> zCustCd :"+ zCustCd);       //search
		log.debug("[ChargeCalculationParmVO]>> zAczCnzCd :"+ zAczCnzCd);   //search
		log.debug("[ChargeCalculationParmVO]>> zAczCuszCd :"+ zAczCuszCd); //search
		log.debug("[ChargeCalculationParmVO]>> zLocDiv 		:"+ zLocDiv);  //search 
		log.debug("*******************************************************");

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
		
		String zOfcCd		= "";                                              
		String zOfcRhq		= ""; 
//		String zCollectYn	= ""; 		
		
		String zSalOfc		= "";                                                      
		String zSalRhq		= "";                                                      
		String zBcntrDlvTerm= ""; 
		String zBcntrRcvTerm= ""; // 2012.02.15
		String bkgCntCd		= "";
		String bkgRgnCd		= "";
		String bkgStateCd	= "";
		String bkgLocCd		= "";
		String zVslCd		= "";
		String zSkdVoyageNo	= "";
		String zSkdDirCd	= "";
		String zVpsEtaDt	= "";
		String dtgEfftDt	= "";
		String fixDtgEfftDt	= "";
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
		
		String zPropNo      = "";
		long   zScVerSeq	= 0;                                             
		long   zScGrpSeq	= 0; 
		
		String dsdFtimeMk	= "";                                                      
		String dsdExclSat	= "";                                                      
		String dsdExclSun	= "";                                                      
		String dsdExclHoli	= "";                                                      
		String dsdFtAddMk	= "";                                                      
		long   dsdFtAddDay	= 0;                                                     
		String dsdFtAdjMk	= "";                                                      
		String dsdRtAdjMk	= "";                                                      
		String dsdCurCd		= "";    
		
		//COMMODITY
		String zCmdtCd		= "";                                                      
		String zRepCmdtCd	= "";                                                      
		
		String dcrExclSat	= "";                                                      
		String dcrExclSun	= "";                                                      
		String dcrExclHoli	= "";                                                      
		long   zDcrSeq		= 0;                                                
		long   dcrAddDay	= 0;                                                
		long   dcrTtlDay	= 0;                                                
		long   zDcCmdtOver	= 0;                                                        
		double zDcCmdtAmt	= 0;           
		
		
		//RFA -  BEFORE
		String zApprNo		= ""; 
		String zDarNo		= ""; 
		long   zMapgSeq		= 0;  
		long   zVerSeq		= 0;  
		long   zDtlSeq		= 0;  
		long   zCmbSeq		= 0;
		
		String dbdFtimeMk	= "";                                                      
		long   dbdAddDay	= 0;                                                
		long   dbdTtlDay	= 0;                                               
		String dbdExclSat	= "";                                                      
		String dbdExclSun	= "";                                                      
		String dbdExclHoli	= "";                                                      
		String dbdRateMk	= "";                                                      
		String dbdCurCd		= "";  
		String dbdFtAdjMk 	= ""; //[2016.01.04] NYK Add.
	
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
		
		String zFixedVlDt	= "";	/* Fixed VL Date       */
		String zFixedCmnc	= "";	/* Fixed Commence Date */
		
		String zWebMtDate	= "";	/* MT Notification		*/
		
		String actCustCntCd = "";	/* BKG A/Cust Cd		*/
		long   actCustSeq     = 0;    /* BKG A/Cust Cd		*/    	                                     
		String awkInOut		= "";   /* In/Out-Gauge			*/ 
		
		List<String> cstopNoList = null;
		long		idxCstop	 = 0;
		
		String zSvrId 		= "";

		
		String	tmpTsp		= "";		/*	T/S Flag			*/
		String	zOrgContiCd	= "";
		String	zOrgCntCd	= "";
		String	zOrgRgnCd	= "";
		String	zOrgStateCd	= "";
		String	zOrgLocCd	= "";
		
		
		//////////////////////END   defind variables    /////////////////                                                                            
                                                                               

//________________________________ Get BKG Data 
		
		/*		
		[logic] Booking Container  information get
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Booking Container  information get");
		log.debug("*******************************************************");
		
		
		BKGRequestInfoVO bkgRequestInfoVO = null;
		
		try {
			bkgRequestInfoVO = dbDao.searchBKGRequestInfo(zBkgNo, zCntrNo, zDcFmYdCd);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error(" Invalid BKG No ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			log.error("*******************************************************");
			throw new EventException(" searchBKGRequestInfo Error ! : " + new ErrorHandler(e).getMessage());
		}
	
		zBlNo 			= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getBlNo());
		zBrhScNo 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getScNo());
		zBrhRfaNo 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getRfaNo());
	
		zCmdtCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getCmdtCd());
		zRepCmdtCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getRepCmdtCd());
		zBcntrSpeDg 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDcgoFlg());
		zBcntrSpeRf 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getRcFlg());
		
		zBcntrSpeAk 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getAwkCgoFlg());
		zBcntrSpeRd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getRdCgoFlg());
		zBcntrSpeBb 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getBbCgoFlg());
		zBcntrSocInd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getSocFlg());
		zBcntrPartial 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getCntrPrtFlg());
		zBcntrExcept 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getAdvShtgCd());
		
		zPorLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorCd());
		zPolLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolCd());
		zPodLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPodCd());
		zDelLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelCd());
		zYrdLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdCd());
		
		zSalOfc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getObSlsOfcCd());
		
		/********************************************************************/
		zPorContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorContiCd());
		zPorCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorCntCd());
		zPorRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorRgnCd());
		zPorStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorSteCd());
		
		zPolContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolContiCd());
		zPolCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolCntCd());
		zPolRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolRgnCd());
		zPolStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolSteCd());
		
		zDelContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelContiCd());
		zDelCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelCntCd());
		zDelRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelRgnCd());
		zDelStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelSteCd());
		
		zYrdContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdContiCd());
		zYrdCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdCntCd());
		zYrdRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdRgnCd());
		zYrdStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdSteCd());

		zPostRly 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPstRlyPortCd(), 5);
		zBcntrDlvTerm	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDeTermCd());
		zBcntrRcvTerm   = DMTCalculationUtil.nullToString(bkgRequestInfoVO.getRcvTermCd()); // 2012.02.15
		zPreRly 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPreRlyPortCd(), 5);
		
		zBkgNo	    	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getBkgNo());
		zCntrNo   		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getCntrNo());
		zCntrtsCd     	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getCntrTpszCd());
		zCnmvCycNo   	= DMTCalculationUtil.stringToLong(bkgRequestInfoVO.getCnmvCycNo());
		zDbcIoBnd    	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getIoBndCd());
		zDttCode      	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDmdtTrfCd());

		log.debug("*******************************************************");
		log.debug("[Cal - BKG Data    = :]>> zBlNo : "+ zBlNo);	
		
		log.debug("[Cal - BKG Data    = :]>> zPorLoc : "+ zPorLoc);
		log.debug("[Cal - BKG Data    = :]>> zPodLoc : "+ zPodLoc);
		log.debug("[Cal - BKG Data    = :]>> zPolLoc : "+ zPolLoc);
		log.debug("[Cal - BKG Data    = :]>> zPolContiCd : "+ zPolContiCd);
		log.debug("[Cal - BKG Data    = :]>> zPolCntCd : "+ zPolCntCd);
		log.debug("[Cal - BKG Data    = :]>> zPolRgnCd : "+ zPolRgnCd);
		log.debug("[Cal - BKG Data    = :]>> zPolStateCd : "+ zPolStateCd);
		
		log.debug("[Cal - BKG Data    = :]>> zDelLoc : "+ zDelLoc);
		log.debug("[Cal - BKG Data    = :]>> zDelContiCd : "+ zDelContiCd);
		log.debug("[Cal - BKG Data    = :]>> zDelCntCd : "+ zDelCntCd);
		log.debug("[Cal - BKG Data    = :]>> zDelRgnCd : "+ zDelRgnCd);
		log.debug("[Cal - BKG Data    = :]>> zDelStateCd : "+ zDelStateCd);
		
		log.debug("[Cal - BKG Data    = :]>> zYrdLoc : "+ zYrdLoc);
		log.debug("[Cal - BKG Data    = :]>> zYrdContiCd : "+ zYrdContiCd);
		log.debug("[Cal - BKG Data    = :]>> zYrdCntCd : "+ zYrdCntCd);
		log.debug("[Cal - BKG Data    = :]>> zYrdRgnCd : "+ zYrdRgnCd);
		log.debug("[Cal - BKG Data    = :]>> zYrdStateCd : "+ zYrdStateCd);
		
		log.debug("[Cal - BKG Data    = :]>> zBcntrSpeDg : "+ zBcntrSpeDg);
		log.debug("[Cal - BKG Data    = :]>> zBcntrSpeRf : "+ zBcntrSpeRf);
		log.debug("[Cal - BKG Data    = :]>> zBcntrSpeAk : "+ zBcntrSpeAk);
		log.debug("[Cal - BKG Data    = :]>> zBcntrSpeRd : "+ zBcntrSpeRd);
		log.debug("[Cal - BKG Data    = :]>> zBcntrSpeBb : "+ zBcntrSpeBb);
		log.debug("[Cal - BKG Data    = :]>> zBcntrSocInd : "+ zBcntrSocInd);
		log.debug("[Cal - BKG Data    = :]>> zBcntrPartial : "+ zBcntrPartial);
		log.debug("[Cal - BKG Data    = :]>> zBcntrExcept : "+ zBcntrExcept);
		
		log.debug("[Cal - BKG Data    = :]>> zSalOfc : "+ zSalOfc);
		log.debug("[Cal - BKG Data    = :]>> zSalRhq : "+ zSalRhq);
		log.debug("[Cal - BKG Data    = :]>> zBrhScNo : "+ zBrhScNo);
		log.debug("[Cal - BKG Data    = :]>> zBrhRfaNo : "+ zBrhRfaNo);
		log.debug("[Cal - BKG Data    = :]>> zCmdtCd : "+ zCmdtCd);
		log.debug("[Cal - BKG Data    = :]>> zRepCmdtCd : "+ zRepCmdtCd);
		log.debug("[Cal - BKG Data    = :]>> zPostRly : "+ zPostRly);
		log.debug("[Cal - BKG Data    = :]>> zBcntrDlvTerm : "+ zBcntrDlvTerm);
		log.debug("[Cal - BKG Data    = :]>> zPreRly : "+ zPreRly);
		
		log.debug("[Cal - BKG Data    = :]>> zBkgNo : "+ zBkgNo);
		log.debug("[Cal - BKG Data    = :]>> zCntrNo : "+ zCntrNo);
		log.debug("[Cal - BKG Data    = :]>> zCntrtsCd : "+ zCntrtsCd);
		log.debug("[Cal - BKG Data    = :]>> zCnmvCycNo : "+ zCnmvCycNo);
		log.debug("[Cal - BKG Data    = :]>> zDbcIoBnd : "+ zDbcIoBnd);
		log.debug("[Cal - BKG Data    = :]>> zDttCode : "+ zDttCode);
		log.debug("*******************************************************");

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
		
		log.debug("*******************************************************");
		log.debug("[Set Cntr Type]>> zDcsCntrTp :"+ zDcsCntrTp);
		log.debug("*******************************************************");
		
		
		/*
		[logic] DEM/DET Office Setting : DEM/DET Collection Office 

		*/
		
		if(zDcFmYdCd.length() == 0){
			zDcFmYdCd = zDcToYdCd;
		}
		log.debug("*******************************************************");
		log.debug("[DEM/DET Office Setting] zDcToYdCd : "+ zDcToYdCd);
		log.debug("[DEM/DET Office Setting] zDcFmYdCd : "+ zDcFmYdCd); 
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
			chargeByBookingCustomerCntrVO.setMsgCd("88");
			chargeByBookingCustomerCntrVO.setMsgDesc("DEM/DET Office Skip ! : ("+zDcFmYdCd+ " ) " );
			// return status in error. do not stop  in throw.
			return chargeByBookingCustomerCntrVO;
		} else {
			
			/*
			[logic]if Collection Office is exists  Tariff is Demurrage and  Collection status is "N",  Charge Calculation Skip
			*/
			if(officeInfoVO.getCollectYn().equals("N") && zDttCode.substring(0, 2).equals("DM")){
				log.debug("*******************************************************");
				log.debug("[officeInfoVO.getCollectYn() == N zDttCode == DM 88 Not a DEM CLT Office");
				log.debug("*******************************************************");
				chargeByBookingCustomerCntrVO.setMsgCd("88");
				chargeByBookingCustomerCntrVO.setMsgDesc("DEM/DET Collection Mark is No for yard "+officeInfoVO.getOfcCd()+" "+zDcFmYdCd );
				// return status in error. do not stop  in throw.
				return chargeByBookingCustomerCntrVO;
			} else {
				
				// Set Office and RHQ of Charge Calculation information
				zOfcCd = officeInfoVO.getOfcCd();
				zOfcRhq = officeInfoVO.getOfcRhq();
				
				log.debug("*******************************************************");
				log.debug("[ Office/RHQ ]  "+officeInfoVO.getOfcCd()+" "+ officeInfoVO.getOfcRhq()+" "+ zDcFmYdCd);
				log.debug("*******************************************************");
			}
		}
		log.debug("*******************************************************");
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcCd 		: "+ officeInfoVO.getOfcCd());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getCollectYn 	: "+ officeInfoVO.getCollectYn());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcRhq 		: "+ officeInfoVO.getOfcRhq());
		log.debug("*******************************************************");
		// ----------------------------------------------------------------------- 
		
		if(zDcToYdCd.length() != 0){
			try {
				officeInfoVO = dbDao.searchOfficeInfoByToYardCd(zDbcIoBnd, zDcToYdCd);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("DEM/DET Yard Select Error ! (ToYd) : ("+zDcToYdCd+ " ) " +e.getMessage());
				log.error("*******************************************************");
				throw new EventException("DEM/DET Yard Select Error ! (ToYd) :" + new ErrorHandler(e).getMessage());
			}
			
			if(officeInfoVO.getCollectYn() == null || officeInfoVO.getCollectYn().equals("N") && zDttCode.substring(0, 2).equals("DM")){
				log.debug("*******************************************************");
				log.debug("officeInfoVO.getCollectYn() == N && zDttCode ==DM 88 Not a DEM CLT Office");
				log.debug("*******************************************************");
				chargeByBookingCustomerCntrVO.setMsgCd("88");
				//chargeByBookingCustomerCntrVO.setMsgDesc("Not a DEM CLT Office ! (ToYd) : "+officeInfoVO.getOfcCd()+" "+zDcToYdCd);
				chargeByBookingCustomerCntrVO.setMsgDesc("Yard: " + zDcToYdCd + " does not have DEM/DET Office! Pls correct yard"); //2010.04.07
				// return status in error. do not stop  in throw.
				return chargeByBookingCustomerCntrVO;
			}			
		}
		
		
		
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

		log.debug("*******************************************************");
		log.debug("[Cal - CNTR N CGO  =:]>> zDcsCntrTp : "+ zDcsCntrTp);
		log.debug("[Cal - CNTR N CGO  =:]>> zDcsCgoTp : "+ zDcsCgoTp);
		log.debug("*******************************************************");
		
		/*
		[logic] Booking의 Container count  get : Get BKG Qty 
		*/
		try {
			zDbcBkgQty = dmtCalculationUtil.searchBookingContainerQuantity(zBkgNo);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("Bkg Qty Select Error :"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("Bkg Qty Select Error : " + new ErrorHandler(e).getMessage());
		}
		

		log.debug("*******************************************************");
		log.debug("[Cal - QTY         = :]>> zDbcBkgQty : "+ zDbcBkgQty);
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
		bkgCntCd 	=	locationByBoundVO.getBkgCntCd();
		bkgRgnCd  	=	locationByBoundVO.getBkgRgnCd();
		bkgStateCd	=	locationByBoundVO.getBkgStateCd();
		bkgLocCd  	=	locationByBoundVO.getBkgLocCd();
		
		log.debug("*******************************************************");
		log.debug("[setLocationByBound:]>> bkgCntCd : "+ bkgCntCd);
		log.debug("[setLocationByBound:]>> bkgRgnCd : "+ bkgRgnCd);
		log.debug("[setLocationByBound:]>> bkgStateCd : "+ bkgStateCd);
		log.debug("[setLocationByBound:]>> bkgLocCd : "+ bkgLocCd);
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
		
		
		log.debug("*******************************************************");
		log.debug("[2001 fixPodLoc:]>> fixPodLoc : "+ fixPodLoc);
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
		
		
		log.debug("*******************************************************");
		log.debug("[2002 fixPOLLocation:tmpTsp]>> fixPolLoc : "+ fixPolLoc);
		log.debug("*******************************************************");
		
		
		/*
		[logic] Booking VVD, ETA  get : Get VVD & ETA Date
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Booking의 VVD, ETA  get : Get VVD & ETA Date *");
		log.debug("*******************************************************");
		
		VVDNEtaVO vvEtaVO = new VVDNEtaVO();
		try {
			vvEtaVO = dmtCalculationUtil.searchVVDNEta(zBkgNo, fixPolLoc, fixPodLoc, zDbcIoBnd);	
			zVslCd			= DMTCalculationUtil.nullToString(vvEtaVO.getVslCd());
			zSkdVoyageNo	= DMTCalculationUtil.nullToString(vvEtaVO.getSkdVoyNo());
			zSkdDirCd		= DMTCalculationUtil.nullToString(vvEtaVO.getSkdDirCd());
			zVpsEtaDt		= DMTCalculationUtil.nullToString(vvEtaVO.getVpsEtaDt(), 8);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("** * Eta Date Select Error - :"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* Eta Date Select Error - :" + new ErrorHandler(e).getMessage());
		}
		if(!zVslCd.equals("")){
			log.debug("*******************************************************");
			log.debug("** * zVslCd:"+zVslCd);
			log.debug("*******************************************************");
		} else {
			log.debug("*******************************************************");
			log.debug("** BKG VVD Not Found - BKG NO");
			log.debug("*******************************************************");
			chargeByBookingCustomerCntrVO.setMsgCd("2");
			chargeByBookingCustomerCntrVO.setMsgDesc("** BKG VVD Not Found - BKG NO:"+zBkgNo+
					", BND:"+zDbcIoBnd+", POL: "+fixPolLoc+", POD:"+fixPodLoc);
			// return status in error. do not stop  in throw.
			return chargeByBookingCustomerCntrVO;
		}
		log.debug("*******************************************************");
		log.debug("[* Cal - VVD         =:]>> zVslCd : "+ zVslCd);
		log.debug("[* Cal - VVD         =:]>> zSkdVoyageNo : "+ zSkdVoyageNo);
		log.debug("[* Cal - VVD         =:]>> zSkdDirCd : "+ zSkdDirCd);
		log.debug("[* Cal - VVD         =:]>> zVpsEtaDt : "+ zVpsEtaDt);
		log.debug("*******************************************************");
		
		/*
		[logic] Tariff Effective Date decision : Set Tariff Effective Date
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Tariff Effective Date decision : Set Tariff Effective Date *");
		log.debug("*******************************************************");
		
		if(zDbcIoBnd.substring(0, 1).equals("I") && zVpsEtaDt.length() != 0){
			dtgEfftDt = zVpsEtaDt.substring(0, 8);
		}

		
		log.debug("*******************************************************");
		log.debug("[Set Tariff Effective Date:]>> dtgEfftDt : "+ dtgEfftDt);
		log.debug("*******************************************************");
		
				
		/*
		[logic] Booking DEL Location decision :  BKG DEL Loc Fix
				according to area pattern (POD->DEL), decision apply DEL Tariff to POD Tariff
				case in EUR T/S, apply DEL Tariff to POST/PRE RLY
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Booking의 DEL Location decision :  BKG DEL Loc Fix*");
		log.debug("*******************************************************");
		
		fixDELLocationParmVO.setDmdtTrfCd(zDttCode);
		fixDELLocationParmVO.setPodCd(zPodLoc);
		fixDELLocationParmVO.setDelCd(zDelLoc);
		fixDELLocationParmVO.setDeTermCd(zBcntrDlvTerm);
		fixDELLocationParmVO.setFmMvmtStsCd("");
		fixDELLocationParmVO.setToMvmtStsCd("");
		fixDELLocationParmVO.setIoBnd(zDbcIoBnd);
		fixDELLocationParmVO.setTspFlag("");
		fixDELLocationParmVO.setPostRly(zPostRly);
		fixDELLocationParmVO.setPreRly(zPreRly);
		FixDELLocationVO fixDELLocationVO;
		try {
			fixDELLocationVO = dmtCalculationUtil.fixDELLocation(fixDELLocationParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* Fixed DEL Loc Select Error!"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("Fixed DEL Loc Select Error!" + new ErrorHandler(e).getMessage());
		}
		if(fixDELLocationVO.getMsgCd().equals("1")){
			fixDelContiCd	= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelContiCd());
			fixDelCntCd		= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelCntCd());
			fixDelRgnCd		= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelRgnCd());
			fixDelStateCd	= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelSteCd());
			fixDelLoc		= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelCd()); 
		} 
		else if(fixDELLocationVO.getMsgCd().equals("0")){
			/* Not Changed */
			fixDelContiCd 	= zDelContiCd;
			fixDelCntCd 	= zDelCntCd;
			fixDelRgnCd 	= zDelRgnCd;
			fixDelStateCd 	= zDelStateCd;
			fixDelLoc 		= zDelLoc;
		}
		
		log.debug("*******************************************************");
		log.debug("[fixDelLoc:]>> fixDelContiCd : "+ fixDelContiCd);
		log.debug("[fixDelLoc:]>> fixDelCntCd : "+ fixDelCntCd);
		log.debug("[fixDelLoc:]>> fixDelRgnCd : "+ fixDelRgnCd);
		log.debug("[fixDelLoc:]>> fixDelStateCd : "+ fixDelStateCd);
		log.debug("[fixDelLoc:]>> fixDelLoc : "+ fixDelLoc);
		log.debug("*******************************************************");

		
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
			throw new EventException(" Fixed ORG Loc Select Error!" + new ErrorHandler(e).getMessage());
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
			zOrgContiCd 	= zPolContiCd;
			zOrgCntCd 		= zPolCntCd;
			zOrgRgnCd 		= zPolRgnCd;
			zOrgStateCd 	= zPolStateCd;
			zOrgLocCd 		= zPolLoc;
		}
		
		log.debug("*******************************************************");
		log.debug("[zOrgLocCd:]>> zOrgLocCd : "+ zOrgLocCd);
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
			throw new EventException("*Get the Awkward Cargo in/out-gauge Error!" + new ErrorHandler(e).getMessage());
		}
		log.debug("*******************************************************");
		log.debug("[searchAwkInOut:]>> awkInOut : "+ awkInOut);
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
		
		basicTariffParmVO.setCvrgYdCd(zDcFmYdCd); 
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
		basicTariffParmVO.setEffDt(dtgEfftDt);
		basicTariffParmVO.setDmdtCntrTpCd(zDcsCntrTp);
		basicTariffParmVO.setDmdtCgoTpCd(zDcsCgoTp);
		basicTariffParmVO.setIoBndCd(zDbcIoBnd);
		basicTariffParmVO.setAwkInOut(awkInOut);
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
			chargeByBookingCustomerCntrVO.setMsgCd("2");
			chargeByBookingCustomerCntrVO.setMsgDesc("Tariff Not Applicable !");
			// return status in error. do not stop  in throw.
			return chargeByBookingCustomerCntrVO;
		} 
		else if(DMTCalculationUtil.nullToString(basicTariffKeyVO.getSvrId()).equals("")){
			chargeByBookingCustomerCntrVO.setMsgCd("2");
			chargeByBookingCustomerCntrVO.setMsgDesc("Tariff Not Found ! "+ zDttCode + ", "+ zPorCntCd+ ", "+ zYrdCntCd
					+ ", "+ zPolCntCd+ ", "+ fixDelCntCd+ ", "+ zDcsCntrTp+ ", "+ zDcsCgoTp+ ", "+ dtgEfftDt);
			// return status in error. do not stop  in throw.
			return chargeByBookingCustomerCntrVO;
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

		}
	
		log.debug("*******************************************************");
		log.debug("* [Cal - BSC TRF] zSvrId :"+zSvrId);
		log.debug("* [Cal - BSC TRF] zDttCode :"+zDttCode);
		log.debug("* [Cal - BSC TRF] zDtnSeq :"+zDtnSeq);
		log.debug("* [Cal - BSC TRF] zDtgGrpId :"+zDtgGrpId);
		
		
		log.debug("* [Cal - BSC TRF] dtgCmncTp :"+dtgCmncTp);
		log.debug("* [Cal - BSC TRF] dtgCmncHr :"+dtgCmncHr);
		log.debug("* [Cal - BSC TRF] dtgExclSat :"+dtgExclSat);
		log.debug("* [Cal - BSC TRF] dtgExclSun :"+dtgExclSun);
		log.debug("* [Cal - BSC TRF] dtgExclHoli :"+dtgExclHoli);
		log.debug("* [Cal - BSC TRF] zCurCd :"+zCurCd);
		log.debug("*******************************************************");

		/*		
		[logic] Basic Tariff Free days  get : Get Basic Free Days
		>>>>> zDbcBkgQty -> Booking Container count
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]  Basic Tariff의 Free days  get*");
		log.debug("*******************************************************");
		 
		try {
			zDcFtDays = dmtCalculationUtil.basicFreeTime(zSvrId, zDttCode, zDtnSeq, zDtgGrpId, zDbcBkgQty);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("** FreeTime Function Error!"+ e.getMessage()+ ", "+ zDttCode+ ", "+ zDtnSeq+ ", "+ zDtgGrpId+ ", "+ zDbcBkgQty);
			log.error("*******************************************************");
			throw new EventException("FreeTime Function Error!" + new ErrorHandler(e).getMessage());
		}
		log.debug("*******************************************************");
		log.debug("* [Cal - BSC Ftime] zDcFtDays :"+zDcFtDays);
		log.debug("*******************************************************");
		
		
		/*	
		[logic] ID->OC Case Free days adjust : ID -> OC F/Days Adjust
		>>>>> getDTOCFtime
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]  ID->OC Case Free days adjust : ID -> OC F/Days Adjust*");
		log.debug("*******************************************************");
		if( zDttCode.equals("DTIC") &&  zDcFmCnms.equals("ID")	&&  zDcToCnms.equals("OC") ){
			dtocFreeTimeParmVO.setCntrNo(zCntrNo);
			dtocFreeTimeParmVO.setCnmvCycNo(String.valueOf(zCnmvCycNo + 1));
			dtocFreeTimeParmVO.setEfftDt(dtgEfftDt);
			dtocFreeTimeParmVO.setFmYdCd(zDcFmYdCd);
			try {
				zDtocFtime = dmtCalculationUtil.getDTOCFtime(dtocFreeTimeParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("**getDTOCFtime Function Error"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("getDTOCFtime Function Error!" + new ErrorHandler(e).getMessage());
			}
			

			log.debug("*******************************************************");
			log.debug("* [ Cal ID->OC Add] zDtocFtime :"+zDtocFtime);
			log.debug("*******************************************************");
			
			zDcFtDays = zDcFtDays + zDtocFtime	;   /* DTIC FTIME += DTOC FTIME */
			
			log.debug("*******************************************************");
			log.debug("* [ Cal - ID->OC BSC Ftime] ");
			log.debug("* [ DTIC FTIME += DTOC FTIME] zDcFtDays :"+zDcFtDays);
			log.debug("*******************************************************");
		}
		
		
		if( DMTCalculationUtil.nullToString(tmpTsp, 1).substring(0,1).equals("Y")){
			
			zDttCode	=	"DMIF";
			dtgExclSat	=	"N";
			dtgExclSun	=	"N";
			dtgExclHoli	=	"N";

			log.debug("*******************************************************");
			log.debug("* [ Cal - T/S Charge BSC Ftime] zDcFtDays :"+zDcFtDays);
			log.debug("* [ Cal - T/S Charge BSC Ftime] dtgExclSat :"+dtgExclSat);
			log.debug("* [ Cal - T/S Charge BSC Ftime] dtgExclSun :"+dtgExclSun);
			log.debug("* [ Cal - T/S Charge BSC Ftime] dtgExclHoli :"+dtgExclHoli);
			log.debug("*******************************************************");
		}
		
		
		/* Init Clock Stop Ary */
		cstopNoList = new ArrayList<String>();
		idxCstop = 0;

		/*	
		[logic]  Get Basic FreeTime Start
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]  Get Basic FreeTime Start*");
		log.debug("*******************************************************");
		if( ( zDttCode.equals("DMIF") ||  zDttCode.equals("CTIC") ) 
			&& DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(fixPodLoc,5).substring(0,5)) 
			&& zDcFmCnms.equals("VD")) {
			
			/* >>>>>  getFixedCmnc 
			 * @param String  zVslCd
			 * @param String  zSkdVoyageNo
			 * @param String  zSkdDirCd
			 * @param String  zDcYdCd
			 * @param String  zDttCode
			 * @param String  type
			 */
			try {
				zFixedCmnc = DMTCalculationUtil.nullToString(dbDao.getFixedCmnc(zVslCd, zSkdVoyageNo, zSkdDirCd, zDcFmYdCd, zDttCode, "fm"));
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Fixed CMNC Date Select Error - "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Fixed CMNC Date Select Error - " + new ErrorHandler(e).getMessage());
			}
		}
		
		
		if( zFixedCmnc.length() != 0 ){
			zDcFtCmnc = zFixedCmnc;
		} else {
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
			freeTimeStartParmVO.setExclSat(dtgExclSat);
			freeTimeStartParmVO.setExclSun(dtgExclSun);
			freeTimeStartParmVO.setExclHoli(dtgExclHoli);
			freeTimeStartParmVO.setCmncTp(dtgCmncTp);
			freeTimeStartParmVO.setCmncHr(dtgCmncHr);
			freeTimeStartParmVO.setSvrId(zSvrId);
			
			freeTimeStartParmVO.setCstopIdx(String.valueOf(idxCstop));
			freeTimeStartParmVO.setCStopNoList(cstopNoList);
			
			freeTimeStartParmVO.setYardCd(zDcFmYdCd);
			// 2012.02.15
			freeTimeStartParmVO.setIoBndCd(zDbcIoBnd);
			freeTimeStartParmVO.setBkgDeTermCd(zBcntrDlvTerm);
			freeTimeStartParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
			

			log.debug("******************************************************************");
			log.debug("* [freeTimeStartParmVO(param) ] idxCstop :["+idxCstop+"]");
			log.debug("* [freeTimeStartParmVO(param) ] cstopNoList :["+cstopNoList+"]");
			log.debug("******************************************************************");
			
			FreeTimeVO freeTimeStartVO = null;
			try {
				
				freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
				zDcFtCmnc 	= DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());					
				idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
				cstopNoList = freeTimeStartVO.getCStopNoList();
				
				log.debug("**********************************************************");
				log.debug("* [FreeTimeVO(return) ] zDcFtCmnc 	:["+zDcFtCmnc+"]");
				log.debug("* [FreeTimeVO(return) ] idxCstop 		:["+idxCstop+"]");
				log.debug("* [FreeTimeVO(return) ] cstopNoList 	:["+cstopNoList+"]");
				log.debug("**********************************************************");
				
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* BSC searchFreeTimeStart Function Error : "+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* BSC searchFreeTimeStart Function Error : " + new ErrorHandler(e).getMessage());
			}
		}
		
		/*	
		[logic] Get Basic FreeTime End
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]  Get Basic FreeTime End*");
		log.debug("*******************************************************");

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
		freeTimeEndParmVO.setExclSat(dtgExclSat);
		freeTimeEndParmVO.setExclSun(dtgExclSun);
		freeTimeEndParmVO.setExclHoli(dtgExclHoli);
		
		freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
		freeTimeEndParmVO.setSvrId(zSvrId);
		freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
		freeTimeEndParmVO.setCStopNoList(cstopNoList);
		freeTimeEndParmVO.setYardCd(zDcFmYdCd);
		// 2012.02.15
		freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
		freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
		freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);

		log.debug("****************************************************************");
		log.debug("* [freeTimeEndParmVO(param) ] ioIdxCstop  :["+idxCstop+"]");
		log.debug("* [freeTimeEndParmVO(param) ] cstopNoList :["+cstopNoList+"]");
		log.debug("****************************************************************");
		FreeTimeVO freeTimeEndVO = null;
		try {
			freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
			zDcFtEnd  	= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
			idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
			cstopNoList = freeTimeEndVO.getCStopNoList();
			
			log.debug("*******************************************************");
			log.debug("* [FreeTimeVO(return) ] zDcFtEnd 		:["+zDcFtEnd+"]");
			log.debug("* [FreeTimeVO(return) ] ioIdxCstop 	:["+idxCstop+"]");
			log.debug("* [FreeTimeVO(return) ] cstopNoList 	:["+cstopNoList+"]");
			log.debug("*******************************************************");
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* BSC searchFreeTimeEnd Function Error -"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* BSC searchFreeTimeEnd Function Error -" + new ErrorHandler(e).getMessage());
		}
		
			
		/*	
		[logic] VL(To Date) Change
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]  VL(To Date) Change   ");
		log.debug("*******************************************************");
		
		if(	( zDttCode.equals("DMOF" ) || zDttCode.equals("CTOC") ) && zDcToCnms.equals("VL")){
			
			/* >>>>>  getFixedCmnc 
			 * @param String  zVslCd
			 * @param String  zSkdVoyageNo
			 * @param String  zSkdDirCd
			 * @param String  zDcYdCd
			 * @param String  zDttCode
			 * @param String  type
			 */
			 zFixedVlDt = DMTCalculationUtil.nullToString(dbDao.getFixedCmnc(zVslCd, zSkdVoyageNo, zSkdDirCd, zDcToYdCd, "", "to"));
			
		}
	
		if( zFixedVlDt.length() != 0 ){
			log.debug("*******************************************************");
			log.debug("* [logic]  zFixedVlDt 있을 경우: "+zFixedVlDt.length());
			log.debug("*******************************************************");
			zDcToDate = zFixedVlDt;
		}
		log.debug("*******************************************************");
		log.debug("* [VL(To Date) Change ] zFixedVlDt :"+zFixedVlDt);
		log.debug("* [VL(To Date) Change ] zDcToDate :"+zDcToDate);
		log.debug("*******************************************************");
		
		/*
		[logic] Get Grace Period Overday 
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]  Get Grace Period Overday");
		log.debug("*******************************************************");
		try {
			zWebMtDate =	DMTCalculationUtil.nullToString(dmtCalculationUtil.getMTNotify(zSvrId, zCntrNo, zCnmvCycNo, zDttCode, zDcFmCnms));
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("*  Get MT Notification Function Error :"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("Get MT Notification Function Error :" + new ErrorHandler(e).getMessage());
		}
		
		log.debug("*******************************************************");
		log.debug("* [ Get Grace Period Overday ] zWebMtDate :"+zWebMtDate);
		log.debug("*******************************************************");
		
		/*
		[logic] Get Basic Overday 
		 */
		log.debug("*******************************************************");
		log.debug("* [logic]  Get Basic Overday    ");
		log.debug("*******************************************************");
		
		zDcFtOver = 0;
		
		overdayNStatusParmVO.setToDate(zDcToDate);
		overdayNStatusParmVO.setFtimeEnd(zDcFtEnd);
		overdayNStatusParmVO.setDttCode(zDttCode);
		overdayNStatusParmVO.setOfcCd(zOfcCd);
		overdayNStatusParmVO.setMtDate(zWebMtDate);
		overdayNStatusParmVO.setCstopIdx(String.valueOf(idxCstop));
		overdayNStatusParmVO.setCStopNoList(cstopNoList);
		overdayNStatusParmVO.setYardCd(zDcFmYdCd);
		
		// 2012.02.15
		overdayNStatusParmVO.setIoBndCd(zDbcIoBnd);
		overdayNStatusParmVO.setBkgDeTermCd(zBcntrDlvTerm);
		overdayNStatusParmVO.setBkgRcvTermCd(zBcntrRcvTerm);		
		overdayNStatusParmVO.setBkgCntCd(bkgCntCd);
		overdayNStatusParmVO.setBkgRgnCd(bkgRgnCd);
		overdayNStatusParmVO.setBkgStateCd(bkgStateCd);
		overdayNStatusParmVO.setBkgLocCd(bkgLocCd);
		overdayNStatusParmVO.setYrdCntCd(zYrdCntCd);
		overdayNStatusParmVO.setYrdRgnCd(zYrdRgnCd);
		overdayNStatusParmVO.setYrdStateCd(zYrdStateCd);
		overdayNStatusParmVO.setYrdLocCd(zYrdLoc);
		overdayNStatusParmVO.setSvrId(zSvrId);
		overdayNStatusParmVO.setYardCd(zDcFmYdCd);

		
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
			log.error("*  Basic Overday  Function Error :"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("Basic Overday  Function Error : " + new ErrorHandler(e).getMessage());
		}
		
		log.debug("*******************************************************");
		log.debug("* [Cal - BSC overdayNStatus    = ] zDcOrgOver :"+zDcOrgOver);
		log.debug("* [Cal - BSC overdayNStatus    = ] zDcStatus :"+zDcStatus);
		log.debug("* [Cal - BSC overdayNStatus    = ] idxCstop :"+idxCstop);
		log.debug("* [Cal - BSC overdayNStatus    = ] cstopNoList :"+cstopNoList);
		log.debug("*******************************************************");
				
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
				log.error("*  Charge & Total Function Error:"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("Charge & Total Function Error:" + new ErrorHandler(e).getMessage());
			}
			
		}
		
		zDcApplRate = "G" ; 				/* Applied Rate Set  */
		zDcBillAmt  = zDcOrgAmt ;  	/* Basic  Amount Fixing */
		
		
		log.debug("*******************************************************");
		log.debug("* [Cal - ORG AMT     = ] zDcOrgAmt :"+zDcOrgAmt);
		log.debug("*******************************************************");
		
		
			
		/* |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* ||||||||||||||||||||||||||||||||||||||||| Get Commodity Exception Values */
		/* |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */		
		
		
		/*
		[logic]   Get Commodity Exception Values
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Get Commodity Exception Values  ");
		log.debug("*******************************************************");
		
		
		
		if( zCmdtCd.length() != 0 ) {
			commodityExceptionParmVO.setSvrId(zSvrId);
			commodityExceptionParmVO.setDttCode(zDttCode);
			commodityExceptionParmVO.setDtnSeq(String.valueOf(zDtnSeq));
			commodityExceptionParmVO.setCmdtCd(zCmdtCd);
			commodityExceptionParmVO.setEfftDt(dtgEfftDt);
			DmtCmdtGrpVO dmtCmdtGrpVO = null;
			try {
				dmtCmdtGrpVO = dmtCalculationUtil.searchCommodityExceptionByGeneration(commodityExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*  searchCommodityExceptionByGeneration Functon Error:"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("*  searchCommodityExceptionByGeneration Functon Error:" + new ErrorHandler(e).getMessage());
			}
			if( DMTCalculationUtil.stringToLong(dmtCmdtGrpVO.getDcrSeq()) == 0 ){
				zDcCmdtAmt	=	0;
				zDcCmdtOver	=	0;
				zDcrSeq		=	0;
			} else {
				/* Commodity Key */
				zDcrSeq 		= DMTCalculationUtil.stringToLong(dmtCmdtGrpVO.getDcrSeq()); //cmdtTrfSeq 
				dcrExclSat 	= DMTCalculationUtil.nullToString(dmtCmdtGrpVO.getExclSat());
				dcrExclSun 	= DMTCalculationUtil.nullToString(dmtCmdtGrpVO.getExclSun());
				dcrExclHoli 	= DMTCalculationUtil.nullToString(dmtCmdtGrpVO.getExclHoli());
				dcrAddDay 	= DMTCalculationUtil.stringToLong(dmtCmdtGrpVO.getAddDay());
				dcrTtlDay 	= DMTCalculationUtil.stringToLong(dmtCmdtGrpVO.getTtlDay());

				log.debug("*******************************************************");
				log.debug("* [Cal - CMDT EXP = ] zDcrSeq :"+zDcrSeq);
				log.debug("* [Cal - CMDT EXP = ] dcrExclSat :"+dcrExclSat);
				log.debug("* [Cal - CMDT EXP = ] dcrExclSun :"+dcrExclSun);
				log.debug("* [Cal - CMDT EXP = ] dcrExclHoli :"+dcrExclHoli);
				log.debug("* [Cal - CMDT EXP = ] dcrAddDay :"+dcrAddDay);
				log.debug("* [Cal - CMDT EXP = ] dcrTtlDay :"+dcrTtlDay);
				log.debug("*******************************************************");
				
				if( dcrAddDay != 0 ) {
					zDcFtDays += dcrAddDay;
				
					/* Next Day -------- */
					try {
						zDcFtEnd = DMTCalculationUtil.nullToString(dbDao.getNextDay(zDcFtEnd));
					}catch(Exception e) {
						log.error("*******************************************************");
						log.error("getNextDay Error !  ");
						log.error("*******************************************************");
						throw new EventException("getNextDay Error ! : " + new ErrorHandler(e).getMessage());
					}
					
					/* Set End Day As Cmnc Day */
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
					freeTimeEndParmVO.setExclSat(dtgExclSat);
					freeTimeEndParmVO.setExclSun(dtgExclSun);
					freeTimeEndParmVO.setExclHoli(dtgExclHoli);
					
					freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
					freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
					freeTimeEndParmVO.setCStopNoList(cstopNoList);
					freeTimeEndParmVO.setYardCd(zDcFmYdCd);

					//2012.02.15
					freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
					freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
					freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
	
					freeTimeEndVO = null;
					try {
						freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
						zDcFtEnd   	= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
						idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
						cstopNoList = freeTimeEndVO.getCStopNoList();
					}catch(Exception e) {
						log.error("*******************************************************");
						log.error("* CMDT FT End Function Error:"+e.getMessage());
						log.error("*******************************************************");
						throw new EventException("CMDT FT End Function Error:" + new ErrorHandler(e).getMessage());
					}
					log.debug("*******************************************************");
					log.debug("* Cal - CMDT searchFreeTimeEnd     =  ] zDcFtEnd :"+zDcFtEnd);
					log.debug("* Cal - CMDT searchFreeTimeEnd     =  ] idxCstop :"+idxCstop);
					log.debug("* Cal - CMDT searchFreeTimeEnd     =  ] cstopNoList :"+cstopNoList);
					log.debug("*******************************************************");
					
				} 
				else { 		// end of the if clause :dcrAddDay != 0
					
					/* Init Clock Stop Ary */
					cstopNoList = new ArrayList<String>();
					idxCstop = 0;
	
					
					/* __________________ Get CMDT Free Day */
					
					zDcFtDays = dcrTtlDay;
					
					/* __________________ Get CMDT FreeTime Start */
					if( zFixedCmnc.length() == 0 ){
						
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
						freeTimeStartParmVO.setExclSat(dtgExclSat);
						freeTimeStartParmVO.setExclSun(dtgExclSun);
						freeTimeStartParmVO.setExclHoli(dtgExclHoli);
						freeTimeStartParmVO.setCmncTp(dtgCmncTp);
						freeTimeStartParmVO.setCmncHr(dtgCmncHr);
						
						freeTimeStartParmVO.setCstopIdx(String.valueOf(idxCstop));
						freeTimeStartParmVO.setCStopNoList(cstopNoList);
						
						freeTimeStartParmVO.setYardCd(zDcFmYdCd);
						
						//2012.02.15
						freeTimeStartParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeStartParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeStartParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
						
						FreeTimeVO freeTimeStartVO = null;
						try {
							freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
							zDcFtCmnc 	= DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());
							idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
							cstopNoList = freeTimeStartVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  searchFreeTimeStart Function Error ! "+ e.getMessage());
							log.error("*******************************************************");
							throw new EventException("*  searchFreeTimeStart Function Error ! " + new ErrorHandler(e).getMessage());
						}
	
						log.debug("*******************************************************");
						log.debug("* Cal - CMDT searchFreeTimeStart:zDcFtCmnc :["+zDcFtCmnc+"]");
						log.debug("* Cal - CMDT searchFreeTimeStart:idxCstop :["+idxCstop+"]");
						log.debug("* Cal - CMDT searchFreeTimeStart:cstopNoList :["+cstopNoList+"]");
						log.debug("*******************************************************");					
											
						
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
						freeTimeEndParmVO.setExclSat(dtgExclSat);
						freeTimeEndParmVO.setExclSun(dtgExclSun);
						freeTimeEndParmVO.setExclHoli(dtgExclHoli);
						
						freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
						freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
						freeTimeEndParmVO.setCStopNoList(cstopNoList);
						freeTimeStartParmVO.setYardCd(zDcFmYdCd);
						
						//2012.02.15
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
						
						freeTimeEndVO = null;
						try {
							freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
							zDcFtEnd   	= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
							idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
							cstopNoList = freeTimeEndVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  CMDT End Function Error :"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("*  CMDT End Function Error :" + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("* Cal - CMDT searchFreeTimeEnd:zDcFtEnd :["+zDcFtEnd+"]");
						log.debug("* Cal - CMDT searchFreeTimeEnd:idxCstop :["+idxCstop+"]");
						log.debug("* Cal - CMDT searchFreeTimeEnd:cstopNoList :["+cstopNoList+"]");
						log.debug("*******************************************************");		
					}
				}
				
				/* ________________________ Get CMDT Overday */
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
				overdayNStatusParmVO.setBkgDeTermCd(zBcntrDlvTerm);
				overdayNStatusParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
				overdayNStatusParmVO.setBkgCntCd(bkgCntCd);
				overdayNStatusParmVO.setBkgRgnCd(bkgRgnCd);
				overdayNStatusParmVO.setBkgStateCd(bkgStateCd);
				overdayNStatusParmVO.setBkgLocCd(bkgLocCd);
				overdayNStatusParmVO.setYrdCntCd(zYrdCntCd);
				overdayNStatusParmVO.setYrdRgnCd(zYrdRgnCd);
				overdayNStatusParmVO.setYrdStateCd(zYrdStateCd);
				overdayNStatusParmVO.setYrdLocCd(zYrdLoc);
				overdayNStatusParmVO.setSvrId(zSvrId);
				overdayNStatusParmVO.setYardCd(zDcFmYdCd);
				
				try {
					overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
					zDcFtOver	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
					zDcCmdtOver	= zDcFtOver;
					zDcStatus 	= DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
					idxCstop 	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
					cstopNoList = overdayNStatusVO.getCStopNoList();
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("*  CMDT Overday Function Error:"+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("CMDT Overday Function Error: " + new ErrorHandler(e).getMessage());
				}
				log.debug("*******************************************************");
				log.debug("* Cal - CMDT overdayNStatus:zDcStatus :["+zDcStatus+"]");
				log.debug("* Cal - CMDT overdayNStatus:zDcCmdtOver :["+zDcCmdtOver+"]");
				log.debug("* Cal - CMDT overdayNStatus:idxCstop :["+idxCstop+"]");
				log.debug("* Cal - CMDT overdayNStatus:cstopNoList :["+cstopNoList+"]");
				log.debug("*******************************************************");
				
				/*
				[logic]  Get CMDT Amount
				*/
				rateDtlCnt = 0;
				zDcCmdtAmt = 0;
				
				
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
						zDcCmdtAmt 	= DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
						rateDtlCnt  = DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
					}catch(Exception e) {
						log.error("*******************************************************");
						log.error("*  CMDT basicCalculation Function Error :"+e.getMessage());
						log.error("*******************************************************");
						throw new EventException("CMDT basicCalculation Function Error :" + new ErrorHandler(e).getMessage());
					}
					
				}
				log.debug("*******************************************************");
				log.debug("* [ CMDT Amount Set ] zDcOrgAmt 	:"+zDcOrgAmt);
				log.debug("* [ CMDT Amount Set ] zDcCmdtAmt 	:"+zDcCmdtAmt);
				log.debug("*******************************************************");
				/* CMDT Amount Set */
				zDcCmdtAmt	=	zDcOrgAmt - zDcCmdtAmt ;			
				
				log.debug("* [ CMDT Amount Set ] zDcCmdtAmt	=	zDcOrgAmt - zDcCmdtAmt :"+zDcCmdtAmt);
				log.debug("*******************************************************");

			}
		} // Commodity Exception End 

		/*  CMDT Amount Fixing  */
		zDcBillAmt = zDcBillAmt - zDcCmdtAmt  ;    
		
		log.debug("*******************************************************");
		log.debug("*CMDT Amount Fixing    =  ] zDcBillAmt :"+zDcBillAmt);
		log.debug("*******************************************************");
		
		
		/* |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* |||||||||||||||||||||||||||||||||||||| OutBound first 'OCVL' Data Checking */
		/* |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		
		/*
		[logic] OutBound first 'OCVL' Data Checking
		*  SC  :: OutBound 1 Order: OC DATE , 2 Order:From Mvmt Date 
		*  SC  :: InBound  1 Order: OC DATE , 2 Order:POL ETA 
		*  RFA :: OutBound 1 Order: POL ETA , 2 Order:From Mvmt Date 
		*  RFA :: InBound  1 Order: VL DATE , 2 Order:POL ETA 
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] OutBound first 'OCVL' Data Checking ");
		log.debug("*******************************************************");
		
		VVDNEtaVO polEta = new VVDNEtaVO();
		try {
			polEta 			= dmtCalculationUtil.searchVVDNEta(zBkgNo, fixPolLoc, "", "I/O");	
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("** polEta Date Select Error - "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("polEta Date Select Error -" + new ErrorHandler(e).getMessage());
		}
		
		log.debug("*******************************************************");
		log.debug(" POL ETA DATE:: "+ DMTCalculationUtil.nullToString(polEta.getVpsEtaDt()));
		log.debug("*******************************************************");
		
		if( zDbcIoBnd.equals("I") ){ 	  
			if(zBrhScNo.length() != 0 && zBrhRfaNo.length() == 0) {
				//[InBound SC CASE]
				try {
					fixDtgEfftDt = DMTCalculationUtil.nullToString(dmtCalculationUtil.getMinOCVLDate(zCntrNo, zCnmvCycNo, "OC", "VD"));
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("InBound SC getMinOCVLDate Error !  "+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("InBound SC getMinOCVLDate Error ! : " + new ErrorHandler(e).getMessage());
				}
				//no OC Date --> POL ETA
				if(fixDtgEfftDt.length() == 0){
					fixDtgEfftDt = DMTCalculationUtil.nullToString(polEta.getVpsEtaDt());
				} 
				log.debug("*******************************************************");
				log.debug(" [InBound SC CASE]:: "+ fixDtgEfftDt);
				log.debug("*******************************************************");
			} else if( zBrhRfaNo.length() != 0 ){
				//[InBound RFA CASE]
				try {
					fixDtgEfftDt = DMTCalculationUtil.nullToString(dmtCalculationUtil.getMinOCVLDate(zCntrNo, zCnmvCycNo, "VL", "OP"));
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("InBound RFA getMinOCVLDate Error ! "+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("InBound RFA getMinOCVLDate Error ! " + new ErrorHandler(e).getMessage());
				}
				//no VL Date --> POL ETA
				if(fixDtgEfftDt.length() == 0){
					fixDtgEfftDt = DMTCalculationUtil.nullToString(polEta.getVpsEtaDt());
				} 
				log.debug("*******************************************************");
				log.debug(" [InBound RFA CASE]:: "+ fixDtgEfftDt);
				log.debug("*******************************************************");
			}
		} 
		else { 		// OutBound  :: COPY: dtgEfftDt ===> fixDtgEfftDt 
			if(zBrhScNo.length() != 0 && zBrhRfaNo.length() == 0) {	
				//[OutBound SC CASE]
				try {
					fixDtgEfftDt = DMTCalculationUtil.nullToString(dmtCalculationUtil.getMinOCVLDate(zCntrNo, zCnmvCycNo, "OC", "VD"));
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("OutBound SC getMinOCVLDate Error !  "+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("OutBound SC getMinOCVLDate Error !" + new ErrorHandler(e).getMessage());
				}
				//no OC Date --> From Mvmt Date
				if(fixDtgEfftDt.length() == 0){
					fixDtgEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
				} 
				log.debug("*******************************************************");
				log.debug(" [OutBound SC CASE]:: "+ fixDtgEfftDt);
				log.debug("*******************************************************");
			} else if( zBrhRfaNo.length() != 0 ){
				//[OutBound RFA CASE]
				fixDtgEfftDt = DMTCalculationUtil.nullToString(polEta.getVpsEtaDt());
				//no OL ETA --> From Mvmt Date
				if(fixDtgEfftDt.length() == 0){
					fixDtgEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
				} 
				log.debug("*******************************************************");
				log.debug(" [OutBound RFA CASE]:: "+ fixDtgEfftDt);
				log.debug("*******************************************************");
			}
		}
		
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* |||||||||||||||||||||||||||||||||||||||||||||||||| Get USC Exception Values */
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		
		if(zBrhScNo.length() != 0 && zBrhRfaNo.length() == 0) {
			List<ActCustInfoVO> custList = null;
//			Map<String, String> custMap = new HashMap<String, String>();
			/* cust info : actCustCntCd, actCustSeq -------- */
			actCustCntCd  	= "";	
			actCustSeq     	= 0;   
			try {
				custList 		= dbDao.getCustInfo(zBkgNo);
				if (custList!=null && custList.size()>0){
					ActCustInfoVO tmp = custList.get(0);
					if (tmp!=null){
						actCustCntCd 	= DMTCalculationUtil.nullToString(tmp.getActCustCntCd());
						actCustSeq 		= DMTCalculationUtil.stringToLong(tmp.getActCustSeq());
					}
				}				
//				actCustCntCd 	= DMTCalculationUtil.nullToString(custMap.get("act_cust_cnt_cd"));
//				actCustSeq 		= DMTCalculationUtil.stringToLong(custMap.get("act_cust_seq"));
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* SC getCustInfo Functon Error -"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("SC getCustInfo Functon Error - " + new ErrorHandler(e).getMessage());
			}
			
			
			log.debug("*******************************************************");
			log.debug("* [logic]  Get SC Exception No 						 ");
			log.debug("*******************************************************");
			
			/* ____________________ Get SC Exception No */
			
			scExceptionParmVO.setPorContiCd(zPorContiCd);
			scExceptionParmVO.setPorCntCd(zPorCntCd);
			scExceptionParmVO.setPorRgnCd(zPorRgnCd);
			scExceptionParmVO.setPorSteCd(zPorStateCd);
			scExceptionParmVO.setPorLocCd(zPorLoc);
			
			scExceptionParmVO.setYrdContiCd(zYrdContiCd);
			scExceptionParmVO.setYrdCntCd(zYrdCntCd);
			scExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
			scExceptionParmVO.setYrdSteCd(zYrdStateCd);
			scExceptionParmVO.setYrdLocCd(zYrdLoc);

			scExceptionParmVO.setPolContiCd(zPolContiCd);
			scExceptionParmVO.setPolCntCd(zPolCntCd);
			scExceptionParmVO.setPolRgnCd(zPolRgnCd);
			scExceptionParmVO.setPolSteCd(zPolStateCd);
			scExceptionParmVO.setPolLocCd(zPolLoc);
			
			scExceptionParmVO.setDelContiCd(zDelContiCd);
			scExceptionParmVO.setDelCntCd(zDelCntCd);
			scExceptionParmVO.setDelRgnCd(zDelRgnCd);
			scExceptionParmVO.setDelSteCd(zDelStateCd);
			scExceptionParmVO.setDelLocCd(zDelLoc);
			
			scExceptionParmVO.setScNo(zBrhScNo);
			scExceptionParmVO.setDttCode(zDttCode);
			scExceptionParmVO.setIoBndCd(zDbcIoBnd);
			scExceptionParmVO.setCntrTp(zDcsCntrTp);
			scExceptionParmVO.setCgoTp(zDcsCgoTp);
			scExceptionParmVO.setEfftDt(fixDtgEfftDt.trim()); 
			

			scExceptionParmVO.setCmdtCd(zCmdtCd);
			scExceptionParmVO.setRepCmdtCd(zRepCmdtCd);
			scExceptionParmVO.setCustCntCd(zCustCntCd);
			scExceptionParmVO.setCustCd(zCustCd);
			scExceptionParmVO.setActCustCntCd(actCustCntCd); 				
			scExceptionParmVO.setActCustSeq(String.valueOf(actCustSeq));
			
			scExceptionParmVO.setAwkInOut(awkInOut);//[CLT-000039159-04] 2015.04.28 Modify awkInOut 추가.
			log.debug("*******************************************************");
			log.debug("* preChargeCalculation[scExceptionParmVO] awkInOut :["+awkInOut+"]");
			log.debug("*******************************************************");
			
			DmtSCGrpVO dmtSCGrpVO = null;
			try {
				dmtSCGrpVO = dmtCalculationUtil.searchSCExceptionByGeneration(scExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*  searchSCExceptionByGeneration Functon Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchSCExceptionByGeneration Functon Error :" + new ErrorHandler(e).getMessage());
			}
			
			if(DMTCalculationUtil.nullToString(dmtSCGrpVO.getPropNo()).equals("")){
				zDcExpAmt = 0;
				zDcBfrAmt = 0;
			} else {
				/*_____________ Apply SC Exception */
				zPropNo			= 	DMTCalculationUtil.nullToString(dmtSCGrpVO.getPropNo()); 
				zScVerSeq		= 	DMTCalculationUtil.stringToLong(dmtSCGrpVO.getVerSeq()); 
				zScGrpSeq		= 	DMTCalculationUtil.stringToLong(dmtSCGrpVO.getGrpSeq()); 
				
				dsdFtimeMk		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getFtimeMk());
				dsdExclSat		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getExclSat());
				dsdExclSun		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getExclSun());
				dsdExclHoli		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getExclHoli());
				dsdFtAddMk		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getFtAddMk()); 
				dsdFtAddDay		=	DMTCalculationUtil.stringToLong(dmtSCGrpVO.getFtAddDay()); 
				dsdFtAdjMk		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getFtAdjMk()); 
				dsdRtAdjMk		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getRtAdjMk()); 
				dsdCurCd		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getCurCd()); 

				log.debug("*******************************************************");
				log.debug("* Cal - USC No    =  ] zPropNo :"+zPropNo);
				log.debug("* Cal - USC No    =  ] zScVerSeq :"+zScVerSeq);
				log.debug("* Cal - USC No    =  ] zScGrpSeq :"+zScGrpSeq);
				log.debug("*******************************************************");
				
				log.debug("*******************************************************");
				log.debug("* Cal - USC EXP     =  ] dsdFtimeMk :"+dsdFtimeMk);
				log.debug("* Cal - USC EXP     =  ] dsdExclSat :"+dsdExclSat);
				log.debug("* Cal - USC EXP     =  ] dsdExclSun :"+dsdExclSun);
				log.debug("* Cal - USC EXP     =  ] dsdExclHoli :"+dsdExclHoli);
				log.debug("* Cal - USC EXP     =  ] dsdFtAddMk :"+dsdFtAddMk);
				log.debug("* Cal - USC EXP     =  ] dsdFtAddDay :"+dsdFtAddDay);
				log.debug("* Cal - USC EXP     =  ] dsdFtAdjMk :"+dsdFtAdjMk);
				log.debug("* Cal - USC EXP     =  ] dsdRtAdjMk :"+dsdRtAdjMk);
				log.debug("* Cal - USC EXP     =  ] dsdCurCd :"+dsdCurCd);
				log.debug("*******************************************************");
				
				/* SCE Key */
				zScNo = zBrhScNo;
				
				if( dsdFtimeMk.equals("Y")){
					if( dsdFtAddDay != 0 && dsdFtAddMk.equals("Y")){
						zDcFtDays += dsdFtAddDay;

						/* _______________________________ Get USCE Freetime End Day */

						/* Next Day -------- */
						try {
							zDcFtEnd = DMTCalculationUtil.nullToString(dbDao.getNextDay(zDcFtEnd));
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("getNextDay Error !  "+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("getNextDay Error ! : " + new ErrorHandler(e).getMessage());
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
						freeTimeEndParmVO.setExclSat(dtgExclSat);
						freeTimeEndParmVO.setExclSun(dtgExclSun);
						freeTimeEndParmVO.setExclHoli(dtgExclHoli);
						
						freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
						freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
						freeTimeEndParmVO.setCStopNoList(cstopNoList);
						freeTimeEndParmVO.setYardCd(zDcFmYdCd);
						//2012.02.15
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
						//2012.06.26 
						freeTimeEndParmVO.setExpType("SC");

						freeTimeEndVO = null;
						try {
							freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
							zDcFtEnd   	= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
							idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
							cstopNoList = freeTimeEndVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  S.FT End Function Error :"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("*  S.FT End Function Error :" + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("* Cal - USC searchFreeTimeEnd:zDcFtEnd :["+zDcFtEnd+"]");
						log.debug("* Cal - USC searchFreeTimeEnd:idxCstop :["+idxCstop+"]");
						log.debug("* Cal - USC searchFreeTimeEnd:cstopNoList :["+cstopNoList+"]");
						log.debug("*******************************************************");
						
					} 
					else if( dsdFtAddDay != 0  && dsdFtAddMk.equals("N")){
						zDcFtDays = 0;
						zDcFtDays = dsdFtAddDay;
						log.info("[logic] zDcFtDays = dsdFtAddDay;"+zDcFtDays);

						log.debug("*******************************************************");
						log.debug("* [logic]  Get USCE Freetime End Day  ");
						log.debug("*******************************************************");
						/* Init Clock Stop Ary */
						cstopNoList = new ArrayList<String>();
						idxCstop = 0;

						log.info("[logic] zDcFtDays = dsdFtAddDay"+zDcFtDays);
						log.debug("*******************************************************");
						log.debug("* [ USC Freetime ] zDcFtDays :"+zDcFtDays);
						log.debug("*******************************************************");
						/*
				      	[logic] Get USCE Free Day
						*/
						if( zFixedCmnc.length() == 0 ){
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
							freeTimeStartParmVO.setExclSat(dsdExclSat);
							freeTimeStartParmVO.setExclSun(dsdExclSun);
							freeTimeStartParmVO.setExclHoli(dsdExclHoli);
							freeTimeStartParmVO.setCmncTp(dtgCmncTp);
							freeTimeStartParmVO.setCmncHr(dtgCmncHr);
							freeTimeStartParmVO.setCstopIdx(String.valueOf(idxCstop));
							freeTimeStartParmVO.setCStopNoList(cstopNoList);
							freeTimeStartParmVO.setYardCd(zDcFmYdCd);

							//2012.02.15
							freeTimeStartParmVO.setIoBndCd(zDbcIoBnd);
							freeTimeStartParmVO.setBkgDeTermCd(zBcntrDlvTerm);
							freeTimeStartParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
							
							//2012.06.26
							freeTimeStartParmVO.setExpType("SC");

							FreeTimeVO freeTimeStartVO = null;
							try {
								freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
								zDcFtCmnc   = DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());
								idxCstop   = DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
								cstopNoList  = freeTimeStartVO.getCStopNoList();
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("* USCE searchFreeTimeStart Function Error -"+ e.getMessage());
								log.error("*******************************************************");
								throw new EventException("USCE searchFreeTimeStart Function Error - " + new ErrorHandler(e).getMessage());
							}
							log.debug("*******************************************************");
							log.debug("[searchFreeTimeStart]");
							log.debug("[ USC (FreeTimeVO) ]zDcFtCmnc  :"+zDcFtCmnc);
							log.debug("[ USC (FreeTimeVO) ] zFixedCmnc  :"+zFixedCmnc);
							log.debug("[ USC (FreeTimeVO) ] idxCstop  :"+idxCstop);
							log.debug("[ USC (FreeTimeVO) ] cstopNoList :"+cstopNoList);
							log.debug("*******************************************************");
						}
						/*
				      	[logic] Get USCE FreeTime End
						 */
						log.info("[logic] Get USCE FreeTime End"+zDcFtDays);
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
				      	freeTimeEndParmVO.setExclSat(dsdExclSat);
				      	freeTimeEndParmVO.setExclSun(dsdExclSun);
				      	freeTimeEndParmVO.setExclHoli(dsdExclHoli);
				      	freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
				      	freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
				      	freeTimeEndParmVO.setCStopNoList(cstopNoList);
				      	freeTimeEndParmVO.setYardCd(zDcFmYdCd);
						//2012.02.15
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
						//2012.06.26
						freeTimeEndParmVO.setExpType("SC");

				      	freeTimeEndVO = null;
				      	try {
				      		freeTimeEndVO  = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
				      		zDcFtEnd     = DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
				      		idxCstop     = DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
				      		cstopNoList  = freeTimeEndVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("* USCE searchFreeTimeEnd Function Error -"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("USCE searchFreeTimeEnd Function Error -" + new ErrorHandler(e).getMessage());
						}
				      	log.debug("*******************************************************");
				      	log.debug("[searchFreeTimeEnd]");
				      	log.debug("[ USC (freeTimeEndVO) ]zDcFtEnd   :"+zDcFtEnd);
				      	log.debug("[ USC (freeTimeEndVO) ] idxCstop  :"+idxCstop);
				      	log.debug("[ USC (freeTimeEndVO) ] cstopNoList  :"+cstopNoList);
				      	log.debug("*******************************************************");
					} //end of the if( dsdFtimeMk.equals("N")
					else if (dsdFtAdjMk.equals("Y")){		/* if( dsdFtAdjMk  == 'Y' ) */ 
						
						/* Init Clock Stop Ary */
						cstopNoList = new ArrayList<String>();
						idxCstop = 0;

						
						/* ________________________ Get USCE Free Day */
						zDcFtDays = 0;

						try {
							zDcFtDays = dmtCalculationUtil.getSCEFreeTime(zPropNo, zScVerSeq, zScGrpSeq, zDbcBkgQty);
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  getSCEFreeTime Function Error :"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("getSCEFreeTime Function Error : " + new ErrorHandler(e).getMessage());
						}

						log.debug("*******************************************************");
						log.debug("*  Cal - USC Ftime     =  ] zDcFtDays :"+zDcFtDays);
						log.debug("*******************************************************");
						/* ________________________ Get USCE FreeTime Start */

						if( zFixedCmnc.length() == 0 ){
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
							freeTimeStartParmVO.setExclSat(dtgExclSat);
							freeTimeStartParmVO.setExclSun(dtgExclSun);
							freeTimeStartParmVO.setExclHoli(dtgExclHoli);
							freeTimeStartParmVO.setCmncTp(dtgCmncTp);
							freeTimeStartParmVO.setCmncHr(dtgCmncHr);
							
							freeTimeStartParmVO.setCstopIdx(String.valueOf(idxCstop));
							freeTimeStartParmVO.setCStopNoList(cstopNoList);
							freeTimeStartParmVO.setYardCd(zDcFmYdCd);

							//2012.02.15
							freeTimeStartParmVO.setIoBndCd(zDbcIoBnd);
							freeTimeStartParmVO.setBkgDeTermCd(zBcntrDlvTerm);
							freeTimeStartParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
							
							//2012.06.26
							freeTimeStartParmVO.setExpType("SC");	

							FreeTimeVO freeTimeStartVO = null;
							try {
								freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
								zDcFtCmnc 		= DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());
								idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
								cstopNoList 	= freeTimeStartVO.getCStopNoList();
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("* searchFreeTimeStart Function Error ! "+e.getMessage());
								log.error("*******************************************************");
								throw new EventException("* searchFreeTimeStart Function Error ! " + new ErrorHandler(e).getMessage());
							}
								
							log.debug("*******************************************************");
							log.debug("* Cal - USC Cmnc    =  ] zDcFtCmnc :"+zDcFtCmnc);
							log.debug("* Cal - USC Cmnc    =  ] zFixedCmnc :"+zFixedCmnc);
							log.debug("* Cal - USC Cmnc    =  ] idxCstop :"+idxCstop);
							log.debug("* Cal - USC Cmnc    =  ] cstopNoList :"+cstopNoList);
							log.debug("*******************************************************");
						}

						/* _________________ Get USCE FreeTime End */
						
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
						freeTimeEndParmVO.setExclSat(dtgExclSat);
						freeTimeEndParmVO.setExclSun(dtgExclSun);
						freeTimeEndParmVO.setExclHoli(dtgExclHoli);
						
						freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
						freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
						freeTimeEndParmVO.setCStopNoList(cstopNoList);
						freeTimeEndParmVO.setYardCd(zDcFmYdCd);
						//2012.02.15
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
						
						//2012.06.26
						freeTimeEndParmVO.setExpType("SC");

						freeTimeEndVO = null;
						try {
							freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
							zDcFtEnd   	= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
							idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
							cstopNoList = freeTimeEndVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  S.FT End Function Error :"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("*  S.FT End Function Error : " + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("* Cal - USC searchFreeTimeEnd     =  ] zDcFtEnd :"+zDcFtEnd);
						log.debug("* Cal - USC searchFreeTimeEnd    =  ] idxCstop :"+idxCstop);
						log.debug("* Cal - USC searchFreeTimeEnd    =  ] cstopNoList :"+cstopNoList);
						log.debug("*******************************************************");	
					}
				
				} // if( dsdFtimeMk.equals("Y")){
				
				
				/* _____________________ Get USCE Overday End */
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
				overdayNStatusParmVO.setBkgDeTermCd(zBcntrDlvTerm);
				overdayNStatusParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
				overdayNStatusParmVO.setBkgCntCd(bkgCntCd);
				overdayNStatusParmVO.setBkgRgnCd(bkgRgnCd);
				overdayNStatusParmVO.setBkgStateCd(bkgStateCd);
				overdayNStatusParmVO.setBkgLocCd(bkgLocCd);
				overdayNStatusParmVO.setYrdCntCd(zYrdCntCd);
				overdayNStatusParmVO.setYrdRgnCd(zYrdRgnCd);
				overdayNStatusParmVO.setYrdStateCd(zYrdStateCd);
				overdayNStatusParmVO.setYrdLocCd(zYrdLoc);
				overdayNStatusParmVO.setSvrId(zSvrId);
				overdayNStatusParmVO.setYardCd(zDcFmYdCd);

				try {
					overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
					zDcFtOver  = DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
					zDcBfrOver = zDcFtOver;
					zDcStatus  = DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
					idxCstop   = DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
					cstopNoList = overdayNStatusVO.getCStopNoList();
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("*  USCE Overday Function Error:"+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("USCE Overday Function Error:" + new ErrorHandler(e).getMessage());
				}
				
					
				log.debug("*******************************************************");
				log.debug("* Cal - USC overdayNStatus    =  ] zDcStatus :"+zDcStatus);
				log.debug("* Cal - USC overdayNStatus    =  ] zDcBfrOver :"+zDcBfrOver);
				log.debug("* Cal - USC overdayNStatus    =  ] idxCstop :"+idxCstop);
				log.debug("* Cal - USC overdayNStatus    =  ] cstopNoList :"+cstopNoList);
				log.debug("*******************************************************");
				
						
				/* _______________________ Get USCE Amount */
				
				rateDtlCnt = 0;

				zDcExpAmt = 0;
				zDcBfrAmt = 0;

				if( zDcStatus.equals("L") || zDcStatus.equals("F") ){
					if( dsdRtAdjMk.equals("Y")){
						zDcApplRate = "S"; 	/* Applied Rate Set */
				
						calculationParmVO.setPropNo(zScNo);
						calculationParmVO.setVerSeq(String.valueOf(zScVerSeq));
						calculationParmVO.setGrpSeq(String.valueOf(zScGrpSeq));
						
						calculationParmVO.setCntrts(zCntrtsCd);
						calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
						calculationParmVO.setDivOverDay("0");	
						CalculationAMTVO calcSCAMTVO = null;
						try {
							calcSCAMTVO = dmtCalculationUtil.scCalculation(calculationParmVO);
							rateDtlCnt = DMTCalculationUtil.stringToLong(calcSCAMTVO.getDtlCnt());
							zDcBfrAmt = Double.parseDouble(calcSCAMTVO.getTotal());
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  USCE Amount - scCalculation Function Error :"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("USCE Amount - scCalculation Function Error : " + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("* Cal - USC AMT    =  ] zDcBfrAmt :"+zDcBfrAmt);
						log.debug("* Cal - USC AMT    =  ] rateDtlCnt :"+rateDtlCnt);
						log.debug("*******************************************************");
						
						if( !zCurCd.equals(dsdCurCd) ){
						/*_____________ Basic Tariff Currency, SC Exception Currency	*/
						
							exchangeRateParmVO.setPolLoc(fixPolLoc);
							exchangeRateParmVO.setPodLoc(fixPodLoc);
							exchangeRateParmVO.setIoBnd(zDbcIoBnd);
							exchangeRateParmVO.setVslCd(zVslCd);
							exchangeRateParmVO.setSkdVoyageNo(zSkdVoyageNo);
							exchangeRateParmVO.setSkdDirCd(zSkdDirCd);
							exchangeRateParmVO.setFmCurCd(dsdCurCd);
							exchangeRateParmVO.setToCurCd(zCurCd);
							exchangeRateParmVO.setOfcCd(zOfcCd);
							try {
								getBfrExRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("*  searchExchangeRate Function Error :"+e.getMessage());
								log.error("*******************************************************");
								throw new EventException("searchExchangeRate Function Error : " + new ErrorHandler(e).getMessage());
							}
							{

								log.debug("*******************************************************");
								log.debug("* Cal - USC ExRate    =  ] getBfrExRate :"+getBfrExRate);
								log.debug("*******************************************************");
								
								zDcBfrAmt = zDcBfrAmt * getBfrExRate;
								
								log.debug("*******************************************************");
								log.debug("* Cal - USC AMT    =  ] zDcBfrAmt :"+zDcBfrAmt);
								log.debug("*******************************************************");
							}
						}
					} 
					else {	/* _________ dsdRtAdjMk != "Y" */
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
							zDcBfrAmt  = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
							rateDtlCnt = DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("USCE Amount - basicCalculation Function Error :"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("USCE Amount - basicCalculation Function Error : " + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("* Cal - USC AMT    =  ] zDcBfrAmt :"+zDcBfrAmt);
						log.debug("*******************************************************");
					}
				}
				 /* Exp Amount Set */
				
				zDcExpAmt	=	zDcBillAmt - zDcBfrAmt;			
				
				
				log.debug("*******************************************************");
				log.debug("* Cal - EXP AMT     =  ] zDcExpAmt :"+zDcExpAmt);
				log.debug("*******************************************************");
			}
		 }/*_________ SC Exception End	*/

		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* |||||||||||||||||||||||||||||||||||||||||||||||||||| Get BFR Exception Values */
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		
		/*
		[logic] Get BFR Exception Values
		*/
		if(  zBrhRfaNo.length() != 0 ){
			log.debug("*******************************************************");
			log.debug("* [logic]  Get BFR Exception Values ");
			log.debug("*******************************************************");
			
			List<ActCustInfoVO> custList = null;
//			Map<String, String> custMap = new HashMap<String, String>();
			/* cust info : actCustCntCd, actCustSeq -------- */
			actCustCntCd  	= "";	
			actCustSeq     	= 0;   
			try {
				custList = dbDao.getCustInfo(zBkgNo);
				if (custList!=null && custList.size()>0){
					ActCustInfoVO tmp = custList.get(0);
					if (tmp!=null){
						actCustCntCd 	= DMTCalculationUtil.nullToString(tmp.getActCustCntCd());
						actCustSeq 		= DMTCalculationUtil.stringToLong(tmp.getActCustSeq());
					}
				}
//				actCustCntCd = DMTCalculationUtil.nullToString(custMap.get("act_cust_cnt_cd"));
//				actCustSeq 	 = DMTCalculationUtil.stringToLong(custMap.get("act_cust_seq"));
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("[Exception]>> DEM/DET Office Select Error !  ");
				log.error("*******************************************************");
				throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
			}
			
			bfrExceptionParmVO.setPorContiCd(zPorContiCd);
			bfrExceptionParmVO.setPorCntCd(zPorCntCd);
			bfrExceptionParmVO.setPorRgnCd(zPorRgnCd);
			bfrExceptionParmVO.setPorSteCd(zPorStateCd);
			bfrExceptionParmVO.setPorLocCd(zPorLoc);
			
			bfrExceptionParmVO.setYrdContiCd(zYrdContiCd);
			bfrExceptionParmVO.setYrdCntCd(zYrdCntCd);
			bfrExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
			bfrExceptionParmVO.setYrdSteCd(zYrdStateCd);
			bfrExceptionParmVO.setYrdLocCd(zYrdLoc);

			bfrExceptionParmVO.setPolContiCd(zPolContiCd);                    
			bfrExceptionParmVO.setPolCntCd(zPolCntCd);                
			bfrExceptionParmVO.setPolRgnCd(zPolRgnCd);      
			bfrExceptionParmVO.setPolSteCd(zPolStateCd);
			bfrExceptionParmVO.setPolLocCd(zPolLoc);      
			
			bfrExceptionParmVO.setDelContiCd(zDelContiCd);                    
			bfrExceptionParmVO.setDelCntCd(zDelCntCd);                
			bfrExceptionParmVO.setDelRgnCd(zDelRgnCd);    
			bfrExceptionParmVO.setDelSteCd(zDelStateCd);
			bfrExceptionParmVO.setDelLocCd(zDelLoc);                   
			
			bfrExceptionParmVO.setDmdtTrfCd(zDttCode);                         
			bfrExceptionParmVO.setScNo(zBrhScNo);                   
			bfrExceptionParmVO.setRfaNo(zBrhRfaNo);                 
			bfrExceptionParmVO.setCntrTp(zDcsCntrTp);               
			bfrExceptionParmVO.setCgoTp(zDcsCgoTp);                 
			bfrExceptionParmVO.setIoBndCd(zDbcIoBnd);                 
			bfrExceptionParmVO.setEfftDt(fixDtgEfftDt.trim());            
			bfrExceptionParmVO.setActCustCntCd(actCustCntCd); 
			bfrExceptionParmVO.setActCustSeq(String.valueOf(actCustSeq));
			bfrExceptionParmVO.setAwkInOut(awkInOut);
			
			bfrExceptionParmVO.setCmdtCd(zCmdtCd); //[2016.01.04] NYK Add
			
			DmtBFRGrpVO dmtBFRGrpVO = null;
			try {
				dmtBFRGrpVO = dmtCalculationUtil.searchBFRExceptionByGeneration(bfrExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("[Exception]>> DEM/DET Office Select Error !  ");
				log.error("*******************************************************");
				throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
			}
			if(DMTCalculationUtil.nullToString(dmtBFRGrpVO.getApprNo()).equals("")){
				//2010.02.12
				log.debug("[searchBFRExceptionByGeneration -> No data found]");
				if(zBrhScNo.length() == 0) {
					zDcExpAmt = 0;
					zDcBfrAmt = 0;
					log.debug("zBrhScNo.length() == 0 : [zBrhScNo]" + zBrhScNo + ", [zBrhScNo] "+  zBrhRfaNo);
					
				} else {
					
					log.debug("zBrhScNo.length() != 0 : [zBrhScNo]" + zBrhScNo + ", [zBrhScNo] "+  zBrhRfaNo);
				}
			} else {

				zApprNo			= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getApprNo());
				zDarNo			= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getDarNo());
				zMapgSeq		= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getMapgSeq());
				zVerSeq			= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getVerSeq());
				zDtlSeq			= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getDtlSeq());
				zCmbSeq			= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getCmbSeq());
				
				
				dbdFtimeMk		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getFtimeMk());
				dbdAddDay   	= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getAddDay());
				dbdTtlDay		= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getTtlDay());
				dbdExclSat		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getExclSat());
				dbdExclSun		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getExclSun());
				dbdExclHoli		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getExclHoli());
				dbdRateMk		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getRateMk());
				dbdCurCd		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getCurCd());
				dbdFtAdjMk		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getFtAdjMk());//[2016.01.04] NYK Add
				
				log.debug("*******************************************************");
				log.debug("* Cal - BFR Req No  =  ] zApprNo :"+zApprNo);
				log.debug("* Cal - BFR Req No  =  ] zDarNo :"+zDarNo);
				log.debug("* Cal - BFR Req No  =  ] zMapgSeq :"+zMapgSeq);
				log.debug("* Cal - BFR Req No  =  ] zVerSeq :"+zVerSeq);
				log.debug("* Cal - BFR Req No  =  ] zDtlSeq :"+zDtlSeq);
				log.debug("* Cal - BFR Req No  =  ] zCmbSeq :"+zCmbSeq);
				log.debug("*******************************************************");
				
				log.debug("*******************************************************");
				log.debug("* Cal - BFR EXP  =  ] dbdFtimeMk :"+dbdFtimeMk);
				log.debug("* Cal - BFR EXP  =  ] dbdAddDay :"+dbdAddDay);
				log.debug("* Cal - BFR EXP  =  ] dbdTtlDay :"+dbdTtlDay);
				log.debug("* Cal - BFR EXP  =  ] dbdExclSat :"+dbdExclSat);
				log.debug("* Cal - BFR EXP  =  ] dbdExclSun :"+dbdExclSun);
				log.debug("* Cal - BFR EXP  =  ] dbdExclHoli :"+dbdExclHoli);
				log.debug("* Cal - BFR EXP  =  ] dbdRateMk :"+dbdRateMk);
				log.debug("* Cal - BFR EXP  =  ] dbdCurCd :"+dbdCurCd);
				log.debug("* Cal - BFR EXP  =  ] dbdFtAdjMk :"+dbdFtAdjMk);
				log.debug("*******************************************************");
				
				if( dbdFtimeMk.equals("Y") ){
					if( dbdAddDay != 0  && dbdFtAdjMk.equals("N")){
						zDcFtDays += dbdAddDay;

						/* ________________ Get Before FreeTime End */
						try {
							zDcFtEnd = dbDao.getNextDay(zDcFtEnd);
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  Get Before getNextDay Function Error ::"+e.getMessage()+", zDcFtEnd: "+zDcFtEnd);
							log.error("*******************************************************");
							throw new EventException("*  Get Before getNextDay Function Error :: " + new ErrorHandler(e).getMessage());
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
						freeTimeEndParmVO.setExclSat(dtgExclSat);
						freeTimeEndParmVO.setExclSun(dtgExclSun);
						freeTimeEndParmVO.setExclHoli(dtgExclHoli);
						
						freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
						freeTimeEndParmVO.setCStopNoList(cstopNoList);
						freeTimeEndParmVO.setYardCd(zDcFmYdCd);
						//2012.02.15
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);

						freeTimeEndVO = null;
						try {
							freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
							zDcFtEnd    = freeTimeEndVO.getFtimeEnd();
							idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
							cstopNoList = freeTimeEndVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("* BFR .FT End Function Error ::"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("BFR .FT End Function Error :: " + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("* Cal - BFR searchFreeTimeEnd    =  ] zDcFtEnd :"+zDcFtEnd);
						log.debug("* Cal - BFR searchFreeTimeEnd    =  ] idxCstop :"+idxCstop);
						log.debug("* Cal - BFR searchFreeTimeEnd    =  ] cstopNoList :"+cstopNoList);
						log.debug("*******************************************************");
						
					} else if(dbdTtlDay != 0 && dbdFtAdjMk.equals("N")){
					
						/* Init Clock Stop Ary */
						cstopNoList = new ArrayList<String>();
						idxCstop = 0;

						
						zDcFtDays = dbdTtlDay;
						
						log.debug("[logic] zDcFtDays = dbdTtlDay ["+zDcFtDays+"]");

						/* _________________ Get Before FreeTime Start */

						if( zFixedCmnc.length() == 0 ){
							
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
							freeTimeStartParmVO.setExclSat(dtgExclSat);
							freeTimeStartParmVO.setExclSun(dtgExclSun);
							freeTimeStartParmVO.setExclHoli(dtgExclHoli);
							freeTimeStartParmVO.setCmncTp(dtgCmncTp);
							freeTimeStartParmVO.setCmncHr(dtgCmncHr);
							
							freeTimeStartParmVO.setCstopIdx(String.valueOf(idxCstop));
							freeTimeStartParmVO.setCStopNoList(cstopNoList);
							freeTimeStartParmVO.setYardCd(zDcFmYdCd);
							//2012.02.15
							freeTimeStartParmVO.setIoBndCd(zDbcIoBnd);
							freeTimeStartParmVO.setBkgDeTermCd(zBcntrDlvTerm);
							freeTimeStartParmVO.setBkgRcvTermCd(zBcntrRcvTerm);

							FreeTimeVO freeTimeStartVO = null;
							try {
								freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
								zDcFtCmnc 	 	= DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());
								idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
								cstopNoList 	= freeTimeStartVO.getCStopNoList();
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("*  freeTimeStartVO:"+ e.getMessage());
								log.error("*******************************************************");
								throw new EventException("freeTimeStartVO: " + new ErrorHandler(e).getMessage());
							}
							log.debug("*******************************************************");
							log.debug("* Cal - BFR searchFreeTimeStart   =  ] zDcFtCmnc :"+zDcFtCmnc);
							log.debug("* Cal - BFR searchFreeTimeStart   =  ] zFixedCmnc :"+zFixedCmnc);
							log.debug("* Cal - BFR searchFreeTimeStart   =  ] idxCstop :"+idxCstop);
							log.debug("* Cal - BFR searchFreeTimeStart   =  ] cstopNoList :"+cstopNoList);
							log.debug("*******************************************************");	
							
						/* _____________ Get Before FreeTime End */

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
							freeTimeEndParmVO.setExclSat(dtgExclSat);
							freeTimeEndParmVO.setExclSun(dtgExclSun);
							freeTimeEndParmVO.setExclHoli(dtgExclHoli);
							
							freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
							freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
							freeTimeEndParmVO.setCStopNoList(cstopNoList);
							freeTimeEndParmVO.setYardCd(zDcFmYdCd);
							//2012.02.15
							freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
							freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
							freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);

							freeTimeEndVO = null;
							try {
								freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
								zDcFtEnd  	= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
								idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
								cstopNoList = freeTimeEndVO.getCStopNoList();
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("* BFR FreeTime End Function Error ::"+e.getMessage());
								log.error("*******************************************************");
								throw new EventException("* BFR FreeTime End Function Error :: " + new ErrorHandler(e).getMessage());
							}
							log.debug("*******************************************************");
							log.debug("* Cal - BFR searchFreeTimeEnd    =  ] zDcFtEnd :"+zDcFtEnd);
							log.debug("* Cal - BFR searchFreeTimeEnd    =  ] idxCstop :"+idxCstop);
							log.debug("* Cal - BFR searchFreeTimeEnd    =  ] cstopNoList :"+cstopNoList);

							log.debug("*******************************************************");	
						}
						
					} else if(dbdFtAdjMk.equals("Y")){ 
					
						/* Init Clock Stop Ary */
						cstopNoList = new ArrayList<String>();
						idxCstop = 0;

						//[2016.01.04] NYK Add Start.==============
						zDcFtDays = 0;
						
						try {
							zDcFtDays = dmtCalculationUtil.getRFAFreeTime(zDarNo, zMapgSeq, zVerSeq, zDtlSeq, zCmbSeq, zDbcBkgQty);
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("* BFR 2016.01.04 getRFAFreeTime Function Error :"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("BFR  2016.01.04 getRFAFreeTime Function Error :" + new ErrorHandler(e).getMessage());
						}

						log.debug("*******************************************************");
						log.debug("* [ BFR Freetime ] 2016.01.04 zDcFtDays :"+zDcFtDays);
						log.debug("*******************************************************");
						
						//[2016.01.04] NYK Add E n d.==============	

						/* _________________ Get Before FreeTime Start */

						if( zFixedCmnc.length() == 0 ){
							
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
							freeTimeStartParmVO.setExclSat(dtgExclSat);
							freeTimeStartParmVO.setExclSun(dtgExclSun);
							freeTimeStartParmVO.setExclHoli(dtgExclHoli);
							freeTimeStartParmVO.setCmncTp(dtgCmncTp);
							freeTimeStartParmVO.setCmncHr(dtgCmncHr);
							
							freeTimeStartParmVO.setCstopIdx(String.valueOf(idxCstop));
							freeTimeStartParmVO.setCStopNoList(cstopNoList);
							freeTimeStartParmVO.setYardCd(zDcFmYdCd);
							//2012.02.15
							freeTimeStartParmVO.setIoBndCd(zDbcIoBnd);
							freeTimeStartParmVO.setBkgDeTermCd(zBcntrDlvTerm);
							freeTimeStartParmVO.setBkgRcvTermCd(zBcntrRcvTerm);

							FreeTimeVO freeTimeStartVO = null;
							try {
								freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
								zDcFtCmnc 	 	= DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());
								idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
								cstopNoList 	= freeTimeStartVO.getCStopNoList();
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("*  freeTimeStartVO:"+ e.getMessage());
								log.error("*******************************************************");
								throw new EventException("freeTimeStartVO: " + new ErrorHandler(e).getMessage());
							}
							log.debug("*******************************************************");
							log.debug("* Cal - BFR searchFreeTimeStart   =  ] zDcFtCmnc :"+zDcFtCmnc);
							log.debug("* Cal - BFR searchFreeTimeStart   =  ] zFixedCmnc :"+zFixedCmnc);
							log.debug("* Cal - BFR searchFreeTimeStart   =  ] idxCstop :"+idxCstop);
							log.debug("* Cal - BFR searchFreeTimeStart   =  ] cstopNoList :"+cstopNoList);
							log.debug("*******************************************************");	
							
						/* _____________ Get Before FreeTime End */

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
							freeTimeEndParmVO.setExclSat(dtgExclSat);
							freeTimeEndParmVO.setExclSun(dtgExclSun);
							freeTimeEndParmVO.setExclHoli(dtgExclHoli);
							
							freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
							freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
							freeTimeEndParmVO.setCStopNoList(cstopNoList);
							freeTimeEndParmVO.setYardCd(zDcFmYdCd);
							//2012.02.15
							freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
							freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
							freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);

							freeTimeEndVO = null;
							try {
								freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
								zDcFtEnd  	= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
								idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
								cstopNoList = freeTimeEndVO.getCStopNoList();
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("* BFR FreeTime End Function Error ::"+e.getMessage());
								log.error("*******************************************************");
								throw new EventException("* BFR FreeTime End Function Error :: " + new ErrorHandler(e).getMessage());
							}
							log.debug("*******************************************************");
							log.debug("* Cal - BFR searchFreeTimeEnd    =  ] zDcFtEnd :"+zDcFtEnd);
							log.debug("* Cal - BFR searchFreeTimeEnd    =  ] idxCstop :"+idxCstop);
							log.debug("* Cal - BFR searchFreeTimeEnd    =  ] cstopNoList :"+cstopNoList);

							log.debug("*******************************************************");	
						}
					}
				} /* if(dbdFtimeMk == "Y" ) */
				
				/* ________________ Get Before FreeTime Overday */
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
				overdayNStatusParmVO.setBkgDeTermCd(zBcntrDlvTerm);
				overdayNStatusParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
				overdayNStatusParmVO.setBkgCntCd(bkgCntCd);
				overdayNStatusParmVO.setBkgRgnCd(bkgRgnCd);
				overdayNStatusParmVO.setBkgStateCd(bkgStateCd);
				overdayNStatusParmVO.setBkgLocCd(bkgLocCd);
				overdayNStatusParmVO.setYrdCntCd(zYrdCntCd);
				overdayNStatusParmVO.setYrdRgnCd(zYrdRgnCd);
				overdayNStatusParmVO.setYrdStateCd(zYrdStateCd);
				overdayNStatusParmVO.setYrdLocCd(zYrdLoc);
				overdayNStatusParmVO.setSvrId(zSvrId);
				overdayNStatusParmVO.setYardCd(zDcFmYdCd);

				try {
					overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
					zDcBfrOver 	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
					zDcStatus   = DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
					idxCstop 	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
					cstopNoList = overdayNStatusVO.getCStopNoList();
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("* BFR overdayNStatus Function Error ::"+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("* BFR overdayNStatus Function Error ::" + new ErrorHandler(e).getMessage());
				}
				
				log.debug("*******************************************************");
				log.debug("* Cal - BFR overdayNStatus    =  ] zDcStatus :"+zDcStatus);
				log.debug("* Cal - BFR overdayNStatus    =  ] zDcBfrOver :"+zDcBfrOver);
				log.debug("* Cal - BFR overdayNStatus    =  ] idxCstop :"+idxCstop);
				log.debug("* Cal - BFR overdayNStatus    =  ] cstopNoList :"+cstopNoList);
				log.debug("*******************************************************");
				
				
				/* ______________________ Get Before FreeTime Amount */

				rateDtlCnt	=	0;

				zDcExpAmt	=	0;
				zDcBfrAmt	=	0;

				if( zDcStatus.equals("L") || zDcStatus.equals("F") ){

					if( dbdRateMk.equals("Y")){

						zDcApplRate = "B";			/* Applied Rate Set */

						calculationParmVO.setDarNo(zDarNo);
						calculationParmVO.setMapgSeq(String.valueOf(zMapgSeq));
						calculationParmVO.setVerSeq(String.valueOf(zVerSeq));
						calculationParmVO.setDtlSeq(String.valueOf(zDtlSeq));
						calculationParmVO.setCmbSeq(String.valueOf(zCmbSeq));
						
						calculationParmVO.setCntrts(zCntrtsCd);
						calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
						calculationParmVO.setDivOverDay("0");	
						
						CalculationAMTVO calcBeforeAMTVO = null;
						try {
							calcBeforeAMTVO = dmtCalculationUtil.beforeCalculation(calculationParmVO);
							rateDtlCnt = DMTCalculationUtil.stringToLong(calcBeforeAMTVO.getDtlCnt());
							zDcBfrAmt = Double.parseDouble(calcBeforeAMTVO.getTotal());
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  beforeCalculation Function Error ::"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("*  beforeCalculation Function Error :: " + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("* Cal - BFR AMT    =  ] zDcBfrAmt :"+zDcBfrAmt);
						log.debug("* Cal - BFR AMT    =  ] rateDtlCnt :"+rateDtlCnt);
						log.debug("*******************************************************");
						


						if( !zCurCd.equals(dbdCurCd) ){
							exchangeRateParmVO.setPolLoc(fixPolLoc);
							exchangeRateParmVO.setPodLoc(fixPodLoc);
							exchangeRateParmVO.setIoBnd(zDbcIoBnd);
							exchangeRateParmVO.setVslCd(zVslCd);
							exchangeRateParmVO.setSkdVoyageNo(zSkdVoyageNo);
							exchangeRateParmVO.setSkdDirCd(zSkdDirCd);
							exchangeRateParmVO.setFmCurCd(dbdCurCd);
							exchangeRateParmVO.setToCurCd(zCurCd);
							exchangeRateParmVO.setOfcCd(zOfcCd);
							try {
								getBfrExRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("*  searchExchangeRate Function Error ::"+e.getMessage());
								log.error("*******************************************************");
								throw new EventException("*  searchExchangeRate Function Error :: " + new ErrorHandler(e).getMessage());
							}
							log.debug("*******************************************************");
							log.debug("* Cal - BFR ExRate    =  ] getBfrExRate :"+getBfrExRate);
							log.debug("* Cal - BFR ExRate    =  ] zCurCd :"+zCurCd);
							log.debug("* Cal - BFR ExRate    =  ] dbdCurCd :"+dbdCurCd);
							log.debug("*******************************************************");
							
							zDcBfrAmt = zDcBfrAmt * getBfrExRate;
							
							log.debug("*******************************************************");
							log.debug("* Cal - BFR AMT    =  ] zDcBfrAmt :"+zDcBfrAmt);
							log.debug("*******************************************************");
						}

					} 
					else {	/*_ dbdRateMk <>  "Y" */
					
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
							zDcBfrAmt 	= DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
							rateDtlCnt 	= DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  basicCalculation Function Error ::"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("*  basicCalculation Function Error ::" + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("* Cal - BFR AMT    =  ] zDcBfrAmt :"+zDcBfrAmt);
						log.debug("*******************************************************");
					}
				}
				
				/* Exp Amount Set */
				zDcExpAmt = zDcBillAmt - zDcBfrAmt;		
				
				log.debug("*******************************************************");
				log.debug("* Cal - EXP Amt    =  ] zDcExpAmt :"+zDcExpAmt);
				log.debug("*******************************************************");

			} 
		}  /*_________ RFA(BFR) Exception End	*/
		
		/* 	EXP Amount Fixing	*/
		zDcBillAmt = zDcBillAmt - zDcExpAmt  ;							
			
			
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
				log.error("*  searchAFTExceptionByGeneration Function Error ::"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchAFTExceptionByGeneration Function Error ::" + new ErrorHandler(e).getMessage());
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
					log.debug("* Cal - AFT Req No    =  ] zAftApprNo :"+zAftApprNo);
					log.debug("* Cal - AFT Req No    =  ] zAftDarNo :"+zAftDarNo);
					log.debug("* Cal - AFT Req No    =  ] zAftAdjSeq :"+zAftAdjSeq);
					log.debug("*******************************************************");
					
					log.debug("*******************************************************");
					log.debug("* Cal - AFT EXP    =  ] dadFtimeMk :"+dadFtimeMk);
					log.debug("* Cal - AFT EXP    =  ] dadAddDay :"+dadAddDay);
					log.debug("* Cal - AFT EXP    =  ] dadTtlDay :"+dadTtlDay);
					log.debug("* Cal - AFT EXP    =  ] dadExclSat :"+dadExclSat);
					log.debug("* Cal - AFT EXP    =  ] dadExclSun :"+dadExclSun);
					log.debug("* Cal - AFT EXP    =  ] dadExclHoli :"+dadExclHoli);
					log.debug("*******************************************************");
					
					if( dadFtimeMk.equals("Y") ){
						if( dadAddDay != 0 ){
							zDcFtDays += dadAddDay;

							/* _______________ Get After FreeTime End */

							try {
								zDcFtEnd = dbDao.getNextDay(zDcFtEnd);
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("*  Get After getNextDay End Error ::"+e.getMessage()+", zDcFtEnd: :"+zDcFtEnd);
								log.error("*******************************************************");
								throw new EventException("*  Get After getNextDay End Error :: " + new ErrorHandler(e).getMessage());
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
							freeTimeEndParmVO.setExclSat(dtgExclSat);
							freeTimeEndParmVO.setExclSun(dtgExclSun);
							freeTimeEndParmVO.setExclHoli(dtgExclHoli);
							
							freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
							freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
							freeTimeEndParmVO.setCStopNoList(cstopNoList);
							freeTimeEndParmVO.setYardCd(zDcFmYdCd);
							//2012.02.15
							freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
							freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
							freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);

							
							freeTimeEndVO = null;
							try {
								freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
								zDcFtEnd    = DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
								idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
								cstopNoList = freeTimeEndVO.getCStopNoList();
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("* After FreeTime End Function Error ::"+e.getMessage());
								log.error("*******************************************************");
								throw new EventException("* After FreeTime End Function Error ::" + new ErrorHandler(e).getMessage());
							}
							log.debug("*******************************************************");
							log.debug("* Cal - AFT searchFreeTimeEnd    =  ] zDcFtEnd :"+zDcFtEnd);
							log.debug("* Cal - AFT searchFreeTimeEnd    =  ] idxCstop :"+idxCstop);
							log.debug("* Cal - AFT searchFreeTimeEnd    =  ] cstopNoList :"+cstopNoList);
							log.debug("*******************************************************");
							
						} 
						else { /* if( dadTtlDay != 0 ) */
						
							/* Init Clock Stop Ary */
							cstopNoList = new ArrayList<String>();
							idxCstop = 0;

							zDcFtDays = dadTtlDay;

						
							if( zDcFtDays == 0 )	{
								zDcFtCmnc = zDcFmDate;
								
								log.debug("*******************************************************");
								log.debug("*  Cal - AFT Cmnc     =  ] zDcFtCmnc :"+zDcFtCmnc);
								log.debug("*  Cal - AFT Cmnc     =  ] zFixedCmnc :"+zFixedCmnc);
								log.debug("*******************************************************");

								zDcFtEnd = zDcFmDate;
								
								log.debug("*******************************************************");
								log.debug("*  Cal - AFT End     =  ] zDcFtEnd :"+zDcFtEnd);
								log.debug("*******************************************************");
							} 
							else {
								/* ___________________ Get After FreeTime Start */

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
									freeTimeStartParmVO.setExclSat(dtgExclSat);
									freeTimeStartParmVO.setExclSun(dtgExclSun);
									freeTimeStartParmVO.setExclHoli(dtgExclHoli);
									freeTimeStartParmVO.setCmncTp(dtgCmncTp);
									freeTimeStartParmVO.setCmncHr(dtgCmncHr);
									
									freeTimeStartParmVO.setCstopIdx(String.valueOf(idxCstop));
									freeTimeStartParmVO.setCStopNoList(cstopNoList);
									freeTimeStartParmVO.setYardCd(zDcFmYdCd);

									//2012.02.15
									freeTimeStartParmVO.setIoBndCd(zDbcIoBnd);
									freeTimeStartParmVO.setBkgDeTermCd(zBcntrDlvTerm);
									freeTimeStartParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
									
									FreeTimeVO freeTimeStartVO = null;
									try {
										freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
										zDcFtCmnc    = DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());
										idxCstop 	 = DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
										cstopNoList  = freeTimeStartVO.getCStopNoList();
									}catch(Exception e) {
										log.error("*******************************************************");
										log.error("*  searchFreeTimeStart Funtion Error ! :"+ e.getMessage());
										log.error("*******************************************************");
										throw new EventException("*  searchFreeTimeStart Funtion Error ! : " + new ErrorHandler(e).getMessage());
									}
									log.debug("*******************************************************");
									log.debug("* Cal - AFT searchFreeTimeStart    =  ] zDcFtCmnc :"+zDcFtCmnc);
									log.debug("* Cal - AFT searchFreeTimeStart    =  ] zFixedCmnc :"+zFixedCmnc);
									log.debug("* Cal - AFT searchFreeTimeStart    =  ] idxCstop :"+idxCstop);
									log.debug("* Cal - AFT searchFreeTimeStart    =  ] cstopNoList :"+cstopNoList);
									log.debug("*******************************************************");	
									
								}

								/* _________________________ Get After FreeTime End */

								freeTimeEndParmVO.setFromDt(zDcFtCmnc);//zDcFmDate
								
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
								freeTimeEndParmVO.setExclSat(dtgExclSat);
								freeTimeEndParmVO.setExclSun(dtgExclSun);
								freeTimeEndParmVO.setExclHoli(dtgExclHoli);
								
								freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
								freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
								freeTimeEndParmVO.setCStopNoList(cstopNoList);
								freeTimeEndParmVO.setYardCd(zDcFmYdCd);
								//2012.02.15
								freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
								freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
								freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);

								freeTimeEndVO = null;
								try {
									freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
									zDcFtEnd    = DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
									idxCstop 	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
									cstopNoList = freeTimeEndVO.getCStopNoList();
								}catch(Exception e) {
									log.error("*******************************************************");
									log.error("*  After FreeTime End Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException("*  After FreeTime End Function Error :: " + new ErrorHandler(e).getMessage());
								}
								log.debug("*******************************************************");
								log.debug("* Cal - AFT searchFreeTimeEnd    =  ] zDcFtEnd :"+zDcFtEnd);
								log.debug("* Cal - AFT searchFreeTimeEnd    =  ] idxCstop :"+idxCstop);
								log.debug("* Cal - AFT searchFreeTimeEnd    =  ] cstopNoList :"+cstopNoList);
								log.debug("*******************************************************");	
							}
						}

						/* ___________________ Get After OverDay */
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
						overdayNStatusParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						overdayNStatusParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
						overdayNStatusParmVO.setBkgCntCd(bkgCntCd);
						overdayNStatusParmVO.setBkgRgnCd(bkgRgnCd);
						overdayNStatusParmVO.setBkgStateCd(bkgStateCd);
						overdayNStatusParmVO.setBkgLocCd(bkgLocCd);
						overdayNStatusParmVO.setYrdCntCd(zYrdCntCd);
						overdayNStatusParmVO.setYrdRgnCd(zYrdRgnCd);
						overdayNStatusParmVO.setYrdStateCd(zYrdStateCd);
						overdayNStatusParmVO.setYrdLocCd(zYrdLoc);
						overdayNStatusParmVO.setSvrId(zSvrId);
						overdayNStatusParmVO.setYardCd(zDcFmYdCd);
						
						try {
							overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
							zDcFtOver   = DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
							zDcAftOver  = zDcFtOver;
							zDcStatus   = DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
							idxCstop 	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
							cstopNoList = overdayNStatusVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  After OverDay Function Error ::"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
						}
							
						log.debug("*******************************************************");
						log.debug("* Cal - AFT overdayNStatus    =  ] zDcStatus :"+zDcStatus);
						log.debug("* Cal - AFT overdayNStatus    =  ] zDcAftOver :"+zDcAftOver);
						log.debug("* Cal - AFT overdayNStatus    =  ] idxCstop :"+idxCstop);
						log.debug("* Cal - AFT overdayNStatus    =  ] cstopNoList :"+cstopNoList);
						log.debug("*******************************************************");
						
						/*_______________________Get After Amount */

						rateDtlCnt	=	0;
						zDcDscAmt	=	0;
						zDcAftAmt	=	0;

						if( zDcStatus.equals("L") || zDcStatus.equals("F") ){
							if(zDcApplRate.equals("G") ){		/* Baisc Tariff			*/
							
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
									log.error("*  basicCalculation Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException("*  basicCalculation Function Error ::" + new ErrorHandler(e).getMessage());
								}
								
							} 
							else if(zDcApplRate.equals("B") ){   /* Before BKG Exception	*/
							
								calculationParmVO.setDarNo(zDarNo);
								calculationParmVO.setMapgSeq(String.valueOf(zMapgSeq));
								calculationParmVO.setVerSeq(String.valueOf(zVerSeq));
								calculationParmVO.setDtlSeq(String.valueOf(zDtlSeq));
								calculationParmVO.setCmbSeq(String.valueOf(zCmbSeq));
								
								calculationParmVO.setCntrts(zCntrtsCd);
								calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
								calculationParmVO.setDivOverDay("0");	
								
								CalculationAMTVO calcBeforeAMTVO = null;
								try {
									calcBeforeAMTVO = dmtCalculationUtil.beforeCalculation(calculationParmVO);
									rateDtlCnt = DMTCalculationUtil.stringToLong(calcBeforeAMTVO.getDtlCnt());
									zDcBfrAmt  = DMTCalculationUtil.stringToDouble(calcBeforeAMTVO.getTotal());
								}catch(Exception e) {
									log.error("*******************************************************");
									log.error("*  beforeCalculation Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException("*  beforeCalculation Function Error ::" + new ErrorHandler(e).getMessage());
								}
							} 
							else if (zDcApplRate.equals("S")){   /* SC Exception			*/
							
//								calculationParmVO.setPropNo(zPropNo);
								calculationParmVO.setPropNo(zScNo);//zScNo zPropNo
								calculationParmVO.setVerSeq(String.valueOf(zScVerSeq));
								calculationParmVO.setGrpSeq(String.valueOf(zScGrpSeq));
								
								calculationParmVO.setCntrts(zCntrtsCd);
								calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
								calculationParmVO.setDivOverDay("0");	
								CalculationAMTVO calcSCAMTVO = null;
								try {
									calcSCAMTVO = dmtCalculationUtil.scCalculation(calculationParmVO);
									rateDtlCnt = DMTCalculationUtil.stringToLong(calcSCAMTVO.getDtlCnt());
									zDcBfrAmt = DMTCalculationUtil.stringToDouble(calcSCAMTVO.getTotal());
								}catch(Exception e) {
									log.error("*******************************************************");
									log.error("*  scCalculation Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException("*  scCalculation Function Error ::" + new ErrorHandler(e).getMessage());
								}
							} 
							else {
									chargeByBookingCustomerCntrVO.setMsgCd("-1");
									chargeByBookingCustomerCntrVO.setMsgDesc("* A.Appl Rate Error  ");
									return chargeByBookingCustomerCntrVO;
							}


							zDcAftAmt = zDcAftAmt * getBfrExRate;

							log.debug("*******************************************************");
							log.debug("* Cal - AFT APPLRT    =  ] getBfrExRate :"+getBfrExRate);
							log.debug("* Cal - AFT Amt    =  ] zDcAftAmt :"+zDcAftAmt);
							log.debug("*******************************************************");								
						}

					} /* if( strcmp( dadFtimeMk.arr, "Y" ) == 0 ) */
					/* _______________ Get After DC Amount */
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
									log.error("*  searchExchangeRate Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException("*  searchExchangeRate Function Error :: " + new ErrorHandler(e).getMessage());
								}
								log.debug("*******************************************************");
								log.debug("* Cal - AFT ExRate    =  ] getAftExRate :"+getAftExRate);
								log.debug("* Cal - AFT ExRate    =  ] zCurCd :"+zCurCd);
								log.debug("* Cal - AFT ExRate    =  ] dadCurCd :"+dadCurCd);
								log.debug("*******************************************************");
								
								dadDcAmt = dadDcAmt * getAftExRate	;
								
								log.debug("*******************************************************");
								log.debug("* Cal - AFT DC Amt    =  ] dadDcAmt :"+dadDcAmt);
								log.debug("*******************************************************");
							}

							if( dadFtimeMk.equals("Y") ){
								zDcAftAmt -= dadDcAmt;
							} else {
								zDcAftAmt = zDcBillAmt - dadDcAmt;
							}
							
							log.debug("*******************************************************");
							log.debug("* Cal - AFT Amt (DA)    =  ] zDcAftAmt :"+zDcAftAmt);
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
							log.debug("* Cal - AFT Amt (DR)    =  ] zDcAftAmt :"+zDcAftAmt);
							log.debug("*******************************************************");
						}

						if( zDcAftAmt <= 0 ){
							zDcStatus = "N" ;
						}
					}  
					
					/* DSC Amount Set */
					zDcDscAmt = zDcBillAmt - zDcAftAmt;	
					
					log.debug("*******************************************************");
					log.debug("* Cal - DSC Amt    =  ] zDcDscAmt :"+zDcDscAmt);
					log.debug("*******************************************************");
				}
			}  
		
			/* AFT Amount Fixing	*/
			zDcBillAmt = zDcBillAmt - zDcDscAmt  ;							

		} //End date Calculation
		
		

		/* Trim Amount Values */
//		zDcBillAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,zDcBillAmt);
		zDcBillAmt 	= zDcBillAmt < 0 ? 0 : dmtCalculationUtil.trimCurrencyAmount(zCurCd,zDcBillAmt);
		
		/* Set The chargeByBookingCustomerCntrVO*/
		log.debug("*******************************************************");
		log.debug("****  Set The chargeByBookingCustomerCntrVO  **************");
		log.debug("* [chargeByBookingCustomerCntrVO ] zDcFtDays :"+zDcFtDays);
		log.debug("* [chargeByBookingCustomerCntrVO ] zDcFtOver :"+zDcFtOver);
		log.debug("* [chargeByBookingCustomerCntrVO ] zDcFtEnd :"+zDcFtEnd);
		log.debug("* [chargeByBookingCustomerCntrVO ] zCurCd :"+zCurCd);
		log.debug("* [chargeByBookingCustomerCntrVO ] zDcApplRate :"+zDcApplRate);
		log.debug("* [chargeByBookingCustomerCntrVO ] zDcBillAmt :"+zDcBillAmt);
		log.debug("*******************************************************");
		
		/* Copy CHRG CAL Values */
		chargeByBookingCustomerCntrVO.setBkgNo(zBkgNo);
		chargeByBookingCustomerCntrVO.setCntrNo(zCntrNo);
		chargeByBookingCustomerCntrVO.setFtDys(StringUtils.defaultString(String.valueOf(zDcFtDays)));
		chargeByBookingCustomerCntrVO.setFxFtOvrDys(StringUtils.defaultString(String.valueOf(zDcFtOver)));
		chargeByBookingCustomerCntrVO.setFtEndDt(StringUtils.defaultString(zDcFtEnd));
		chargeByBookingCustomerCntrVO.setBzcTrfCurrCd(StringUtils.defaultString(zCurCd));
		chargeByBookingCustomerCntrVO.setBilAmt(StringUtils.defaultString(String.valueOf(zDcBillAmt)));
		chargeByBookingCustomerCntrVO.setMsgCd("0");

		return chargeByBookingCustomerCntrVO;
	}
	
	
}
