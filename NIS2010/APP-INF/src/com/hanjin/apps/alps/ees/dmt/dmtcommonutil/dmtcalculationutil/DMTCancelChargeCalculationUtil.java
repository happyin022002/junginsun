/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCancelChargeCalculationUtil.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.25 최성환
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.06 유병희 [] [EES-DMT] CSR 요청에 의해 Billable 금액이 (-)면 0으로 설정하거나, 아니면 원래 그대로 trim하기 적용 
* 2010.10.26 황효근 [CHM-201006671-01] [EES-DMT] T/S Demurrage Free Time 변경
* 2010.11.01 황효근 [CHM-201006866-01] [EES-DMT] T/S Demurrage Free Time 재조정
* 2010.11.12 김태균 [CHM-201006793-01] 소스 결함 관련 수정
* 2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
* 2011.03.31 김태균 [CHM-201109458-01] [DMT] T/S BKG의 T/S 미실행(육상운송) CNTR의 Port DEM 생성 Logice 보완
* 2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
* 2012.03.19 김현화 [CHM-201216014-01]Time Clock Stop 기능 보완:freeTimeStart/freeTimeEnd/overday 관련 Term cd 변경(BKG_CONTAINER정보)
* 2012.06.04 김현화 [CHM-201217905-01]유럽지역 TS DMIF 생성 중단 요청 :  DMDT_CHG_LOC_DIV_CD = 'TSP'이면  fixedpod, fixedpol를 호출, 그외는 호출하지 않음
* 2012.07.16 김현화 [CHM-201218768-01]Exempted Error Charge 생성 중지.( searchBasicTariffByGeneration ) 
* 2012.10.23 김현화 [CHM-201220676-01][DMT] OP-MT Detention 계산 방법 보완 (AA - Chang-Bin LIM)
* 2013.02.28 임창빈 [CHM-201322954] [DMT] 신규 장비에 대한 DMT charge 청구를 위한 Table Mapping 요청
* TP/SZ  Description                          CGP TYPE   CNTR Size 
*--------------------------------------------------------------------
*  C2    20FT COIL RACK CONTAINER            Open Top   20FT 
*  C4    40FT COIL RACK CONTAINER            Open Top   40FT 
*  R8    LIVE FISH CONTAINER                 Reefer     R9 
==========================================================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil;

import java.util.ArrayList;
//import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration.DMTCalculationDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.AFTExceptionParmVO;
//import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BFRExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BkgContainerInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
//import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CommodityExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtAFTGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DtocFreeTimeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixORGLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixORGLocationVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPODLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPOLLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeEndParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeStartParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OfficeInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusVO;
//import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * Cancel calculation 함수 <br>
 * = DMTGeneralChargeCalculationUtil에서 Basic + After Calculation만 적용(commodity, s/c, rfa 제외) 
 *
 * @author Choi Sung Hwan
 * @see DMTCalculationDBDAO 클래스 참조
 * @since J2EE 1.6
 */
public class DMTCancelChargeCalculationUtil {
	
	// Database Access Object
	public transient DMTCalculationDBDAO dbDao = null; 
	protected transient Logger log = null;
	
	DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
	/**
	 * DMTCalculationUtil 객체 생성<br>
	 * DMTCalculationDBDAO 생성한다.<br>
	 */
	public DMTCancelChargeCalculationUtil() {
		dbDao = new DMTCalculationDBDAO();
		log = Logger.getLogger(getClass().getName());
	}
	
	/**
	 *  cancel Charge Calculation 대한 해당 데이터를 조회한다.
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return ChargeCalculationContainerVO
	 * @exception EventException
	 */
	public ChargeCalculationContainerVO cancelChargeCalculation(ChargeCalculationParmVO chargeCalculationParmVO) 
	throws EventException{
		
		ChargeCalculationContainerVO chargeCalculationContainerVO = new ChargeCalculationContainerVO();
		//parameter values
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
		
		//param 지역변수 
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
		
		log.debug("[ChargeCalculationParmVO]>> 처음 조건 -> zDcToDate 		:["+ zDcToDate +"]");
		
		//zDcToDate 값이 있으면		20100105 수정
		if(zDcToDate.equals("")){
			zDcToDate   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getRunDate());
			zDcToYdCd  		= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtYdCd());
			zDcToCnms   	= "MT";
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

		//////////////////////  START    변수 정의    /////////////////
		
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
		String zBcntrDlvTerm = "";
		String zBcntrRcvTerm = ""; //2012.03.19 KHH 추가
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
		String zDmdtDeTermCd = "";
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
		
		double tmp1			= 0;					
		double tmp2			= 0;
		
		String zFixedCmnc	= zDcFmDate;
		String zWebMtDate	= "";	    	                                     
		String awkInOut		= "";    
		
		List<String> cstopNoList = null;
		long	idxCstop	= 0;
		
		String	tmpTsp		= "";	
		String	zOrgContiCd	= "";
		String	zOrgCntCd	= "";
		String	zOrgRgnCd	= "";
		String	zOrgStateCd	= "";
		String	zOrgLocCd	= "";
		
		//////////////////////END    변수 정의    /////////////////                                                                            

		/*
		[logic] From Date Checking
		*/
		if(zDcFmDate.length() == 0){
			log.debug("*****************************************************************");
			log.debug("* if(zDcFmDate.length() == 0){    2  From Movement Not Found *");
			log.debug("****************************************************************");
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("From Movement Not Found !");
			return chargeCalculationContainerVO;
		}
		
		/*
		[logic] Set CNTR TYPE 
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Set DMDT_CNTR_TP_CD ");
		log.debug("*******************************************************");

		zDcsCntrTp = dmtCalculationUtil.settingDemDetContainerTypeCode( zCntrtsCd );
		chargeCalculationContainerVO.setCntrTp(zDcsCntrTp);
		
		log.debug("*******************************************************");
		log.debug("[Set DMDT_CNTR_TP_CD] zDcsCntrTp :"+ zDcsCntrTp);
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
			log.error("(From Yard) [Exception]>> DEM/DET Office Select Error !  ");
			log.error("*******************************************************");
			throw new EventException("(From Yard) DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		log.debug("*******************************************************");
		log.debug("(From Yard) [DEM/DET Office Setting]>> officeInfoVO.getCollectYn() : "+ officeInfoVO.getCollectYn());
		log.debug("*******************************************************");
		
		if(DMTCalculationUtil.nullToString(officeInfoVO.getCollectYn()).equals("")){
			log.debug("*******************************************************");
			log.debug("(From Yard) [officeInfoVO is null !  88 DEM/DET Office Skip !");
			log.debug("*******************************************************");
			chargeCalculationContainerVO.setMsgCd("88");
			chargeCalculationContainerVO.setMsgDesc("(From Yard) DEM/DET Office Skip ! : ("+zDcFmYdCd+ " ) " );
			//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
			return chargeCalculationContainerVO;
		} else {
			
			/*
			[logic]Collection Office가 존재하고 Tariff가 Demurrage면서 Collection여부가 "N"이면 Charge Calculation을 Skip한다
			*/
			if(officeInfoVO.getCollectYn().equals("N") && zDttCode.substring(0, 2).equals("DM")){
				log.debug("*******************************************************");
				log.debug("(From Yard) [officeInfoVO.getCollectYn() == N zDttCode == DM 88 Not a DEM CLT Office");
				log.debug("*******************************************************");
				chargeCalculationContainerVO.setMsgCd("88");
				chargeCalculationContainerVO.setMsgDesc("(From Yard) DEM/DET Collection Mark is No for yard "+officeInfoVO.getOfcCd()+" "+zDcFmYdCd );
				//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
				return chargeCalculationContainerVO;
			} else {
				
				//위 조건에 해당하지 않으면 Charge Calculation시의 Office와 RHQ를 Setting한다
				zOfcCd = officeInfoVO.getOfcCd();
				zOfcRhq = officeInfoVO.getOfcRhq();
				
				chargeCalculationContainerVO.setOfcCd(zOfcCd);
				chargeCalculationContainerVO.setOfcRhq(zOfcRhq);		
				log.debug("*******************************************************");
				log.debug("(From Yard) [Office/RHQ]  "+officeInfoVO.getOfcCd()+" "+ officeInfoVO.getOfcRhq()+" "+ zDcFmYdCd);
				log.debug("*******************************************************");
			}
		}
		
		log.debug("*******************************************************");
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcCd     : "+ officeInfoVO.getOfcCd());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getCollectYn : "+ officeInfoVO.getCollectYn());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcRhq    : "+ officeInfoVO.getOfcRhq());
		log.debug("*******************************************************");

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
			return chargeCalculationContainerVO;
		}
		
		if(zDcToYdCd.length() != 0){
			try {
				officeInfoVO = dbDao.searchOfficeInfoByToYardCd(zDbcIoBnd, zDcToYdCd);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("(To Yard) DEM/DET Yard Select Error ! (ToYd) : ("+zDcToYdCd+ " ) " +e.getMessage());
				log.error("*******************************************************");
				throw new EventException("(To Yard) DEM/DET Yard Select Error ! (ToYd) : " + new ErrorHandler(e).getMessage());
			}
			
			if(officeInfoVO.getCollectYn() == null || officeInfoVO.getCollectYn().equals("N") && zDttCode.substring(0, 2).equals("DM")){
				log.debug("*******************************************************");
				log.debug("(To Yard) officeInfoVO.getCollectYn() == N && zDttCode ==DM 89 Not a DEM CLT Office");
				log.debug("*******************************************************");
				chargeCalculationContainerVO.setMsgCd("89");
				chargeCalculationContainerVO.setMsgDesc("(To Yard) Yard: " + zDcToYdCd + " does not have DEM/DET Office! Pls correct yard"); //2010.04.07
				//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
				return chargeCalculationContainerVO;
			}			
		}
		
		/*		
		[logic] Booking Container 정보가져오기 : Get BKG Data 
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Booking Container 정보가져오기");
		log.debug("*******************************************************");
		
		BkgContainerInfoVO bkgContainerInfoVO = null;
		
		try {
		   // 2012.08.23 Cancel BKG 관련 CNTR 정보는 DMT 테이블정보를 사용하는 것으로 변경함.	
			bkgContainerInfoVO = dbDao.searchCancelBkgContainerInfo(zBkgNo, zCntrNo, zDcFmYdCd);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchCancelBkgContainerInfo Select Error ! : "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchCancelBkgContainerInfo Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		//2010.04.20. 
		if(DMTCalculationUtil.nullToString(bkgContainerInfoVO.getIbflag()).equals("NoDataFound")){
			log.error("*******************************************************");
			log.error("[Invalid BKG No(No Data Found) ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			log.error("*******************************************************");
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("Invalid BKG No(No Data Found) ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
			//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
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
		zBbDeTermCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getBbDeTermCd());
		zBcntrRcvTerm	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRcvTermCd());
		
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
		log.debug("[searchCancelBkgContainerInfo]");
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
		[logic] Cargo 타입 결정 : Set Cntr & Cgo Type
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Cargo 타입 결정 : Set Cntr & Cgo Type*");
		log.debug("*******************************************************");
		
		zDcsCgoTp = dmtCalculationUtil.settingContainerCargoTypeByBkgCancel(zDcsCntrTp);
		chargeCalculationContainerVO.setDmdtCgoTpCd(zDcsCgoTp);
		
		log.debug("*******************************************************");
		log.debug("[settingContainerCargoType]");
		log.debug("[ContainerCargoTypeVO] zDcsCgoTp : "+ zDcsCgoTp);
		log.debug("*******************************************************");
		
		/*
		[logic] Booking의 Container 물량 가져오기 : Get BKG Qty 
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
		[logic] Booking I/O Bound Location 결정 :  Set In/Out Bound
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Booking I/O Bound Location 결정 :  Set In/Out Bound *");
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
		fixPODLocationParmVO.setBkgNo(zBkgNo); //2010.03.26 
		
		if ("TSP".equals(zLocDiv)){
		    fixPodLoc = DMTCalculationUtil.nullToString(dmtCalculationUtil.fixPODLocation(fixPODLocationParmVO), 5);
		}else{
			fixPodLoc = zPodLoc ;
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
		fixPOLLocationParmVO.setBkgNo(zBkgNo); //2010.03.26

		if ("TSP".equals(zLocDiv)){
			fixPolLoc = DMTCalculationUtil.nullToString(dmtCalculationUtil.fixPOLLocation(fixPOLLocationParmVO), 5);
		}else{
			fixPolLoc = zPolLoc;
		}
		
		log.debug("*******************************************************");
		log.debug("[fixPOLLocation]");
		log.debug("[fixPolLoc] : "+ fixPolLoc);
		log.debug("[tmpTsp] : "+ tmpTsp);
		log.debug("*******************************************************");
		
		/*
		[logic] Booking의 VVD, ETA 가져오기 : Get VVD & ETA Date
		*/
		log.debug("**********************************************************");
		log.debug("* [logic] Booking의 VVD, ETA 가져오기 : Get VVD & ETA Date *");
		log.debug("**********************************************************");
		
		VVDNEtaVO vvEtaVO = new VVDNEtaVO();
		try {
			vvEtaVO = dmtCalculationUtil.searchVVDNEta(zBkgNo, fixPolLoc, fixPodLoc, zDbcIoBnd);	
			zVslCd			= DMTCalculationUtil.nullToString(vvEtaVO.getVslCd());
			zSkdVoyageNo	= DMTCalculationUtil.nullToString(vvEtaVO.getSkdVoyNo());
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
			//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
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
		[logic] Tariff Effective Date 결정 : Set Tariff Effective Date
		*/
		log.debug("*****************************************************************");
		log.debug("* [logic] Tariff Effective Date 결정 : Set Tariff Effective Date *");
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
		[logic] Booking의 DEL Location 결정 :  BKG DEL Loc Fix
				특정 지역패턴(POD->DEL)에 따라, 기본적으로 DEL Tariff 를 POD Tariff 로 적용 시킬지 결정
				구주지역 T/S 대상인 경우, DEL Tariff를 POST/PRE RLY 로 적용
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Booking의 DEL Location 결정 :  BKG DEL Loc Fix*");
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
		log.debug("*[Booking의 DEL Location 결정 :  BKG DEL Loc Fix]");
		log.debug("fixDelContiCd : "+ fixDelContiCd);
		log.debug("fixDelCntCd : "+ fixDelCntCd);
		log.debug("fixDelRgnCd : "+ fixDelRgnCd);
		log.debug("fixDelStateCd : "+ fixDelStateCd);
		log.debug("fixDelLoc : "+ fixDelLoc);
		log.debug("*******************************************************");

		/*
		[logic] Tariff의 Origin 지역 조정 - 구주 T/S O/B 인 경우 DEL 지역을 ORG으로 조정
		*/
		log.debug("****************************************************************************");
		log.debug("* [logic] Tariff의 Origin 지역 조정 - 구주 T/S O/B 인 경우 DEL 지역을 ORG으로 조정*");
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
		log.debug("*[Tariff의 Origin 지역 조정]");
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
		[logic] Basic Tariff정보 가져오기 : Get Basic Tariff No
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]Basic Tariff정보 가져오기 : Get Basic Tariff No*");
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
		basicTariffParmVO.setEffDt(dtgEfftDt.trim()); //2010.04.05.
		basicTariffParmVO.setDmdtCntrTpCd(zDcsCntrTp);
		basicTariffParmVO.setDmdtCgoTpCd(zDcsCgoTp);
		basicTariffParmVO.setIoBndCd(zDbcIoBnd);
		basicTariffParmVO.setAwkInOut(awkInOut);
		
		basicTariffParmVO.setSuthChnUseFlg(DMTCalculationUtil.nullToString(chargeCalculationParmVO.getSuthChnUseFlg()));
		
		// I/O Bound에 따라서, BOOKING CONTAINER 기준으로 DMDT_DE_TERM_CD를 결정한다.
		log.error("I/O Bound : ["+ DMTCalculationUtil.nullToString(zDttCode, 4).substring(2,3) + "]");

		if( DMTCalculationUtil.nullToString(zDttCode, 4).substring(2,3).equals("I")){
			zDmdtDeTermCd	= zBcntrDlvTerm;
		} else {
			zDmdtDeTermCd	= zBcntrRcvTerm;
		}
	
		basicTariffParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
		
		BasicTariffKeyVO basicTariffKeyVO = null;
		try {
			// 2012.10.16 OP_MT 관련하여 로직 반영되도록 별도 오퍼레이션 처리함.(zDcsCntrTp,zDcsCgoTp를 그대로 유지하도록 함.)
			basicTariffKeyVO = dmtCalculationUtil.searchBasicTariffByBkgCancel(basicTariffParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("*searchBasicTariffByGeneration Functon Error!"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchBasicTariffByGeneration Functon Error!" + new ErrorHandler(e).getMessage());
		}
		
		if(DMTCalculationUtil.nullToString(basicTariffKeyVO.getMsgCd()).equals("-99")){
			chargeCalculationContainerVO.setMsgCd("3"); // 2에서 3으로 변경함. 2012.07.17 KHH -Exempted Error Charge 생성  중지
			chargeCalculationContainerVO.setMsgDesc("Tariff Not Applicable !");
			//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
			return chargeCalculationContainerVO;
		} 
		else if(DMTCalculationUtil.nullToString(basicTariffKeyVO.getSvrId()).equals("")){
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("Tariff Not Found ! "+ zDttCode + ", "+ zPorCntCd+ ", "+ zYrdCntCd
					+ ", "+ zPolCntCd+ ", "+ fixDelCntCd+ ", "+ zDcsCntrTp+ ", "+ zDcsCgoTp+ ", "+ dtgEfftDt);
			//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
			return chargeCalculationContainerVO;
		} 
		else {
			zSvrId			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getSvrId());		
			zDttCode		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtTrfCd());
			zDtnSeq 		= DMTCalculationUtil.stringToLong(basicTariffKeyVO.getTrfSeq());
			// Door('D'), Yard('Y') 와 Default('N') 우선 순위에 따라 DMDT_DE_TERM_CD를 변경 될 수 있다.
			zDmdtDeTermCd	= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtDeTermCd());
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
			log.debug("zDmdtDeTermCd : "+ zDmdtDeTermCd);
			log.debug("zSvrId : "+ zSvrId);
			log.debug("zDtgGrpId : "+ zDtgGrpId);
			
			log.debug("dtgCmncTp :"+dtgCmncTp);
			log.debug("dtgCmncHr :"+dtgCmncHr);
			log.debug("dtgExclSat :"+dtgExclSat);
			log.debug("dtgExclSun :"+dtgExclSun);
			log.debug("dtgExclHoli :"+dtgExclHoli);
			
			log.debug("zCurCd :"+zCurCd);
			log.debug("*********************************************");
		}

		chargeCalculationContainerVO.setBzcDmdtDeTermCd(zDmdtDeTermCd);
		log.debug("zDmdtDeTermCd : "+ zDmdtDeTermCd);
		
		/*	
		[logic] ID->OC Case Free days 조정 : ID -> OC F/Days Adjust
		>>>>> getDTOCFtime
		*/
		
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
			/*
			 * 2010.11.01 T/S Demurrage Free Time 변경
			 * 1) locCd: DEBRE, DEHAM --> bzcFreeTime = 7;
			 * 2) locCd: NLRTM, BEANR --> 
			 * 							  zDcFmDate <=  2010/10/09 --> bzcFreeTime = 7
			 * 							  zDcFmDate >   2010/10/09 --> bzcFreeTime = 10
			 */
			String locCd = zDcFmYdCd.substring(0, 5);
			if(locCd.equals("DEBRE") || locCd.equals("DEHAM")) {
				zDcFtDays = 7;
			} else {
				if( "20101009".compareTo(DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8)) >= 0 ) {
					zDcFtDays = 7;
				} else {
					zDcFtDays = 10;
				}
			}
			
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
		
		dtgExclSat = "N";
		dtgExclSun = "N";
		dtgExclHoli = "N";
			
		zDcFtEnd = zDcFtCmnc; // 20091211 수정
				
		/*
		[logic] Get Basic Overday 
		 */
		log.debug("*******************************************************");
		log.debug("* [logic]  Get Basic Overday    ");
		log.debug("*******************************************************");
		
		zDcFtOver = 0;
		
		//zDcToDate 값이 있으면
		if(!zDcToDate.equals("")){
			overdayNStatusParmVO.setToDate(zDcToDate);
		} else {
			//zDcToDate 값이 있으면
			overdayNStatusParmVO.setToDate(runDate);
		}
//		overdayNStatusParmVO.setToDate(zDcToDate); 
		// 한국이외의 지역만 + 1
	
//		OP-MT Detention 계산 시, MVMT Date 당일부터 Over Day를 세었으나, 각 나라마다 Over Day를 세는 기준이 상이하여 Basic Tariff의 F/T Commence를 따라 Over Day를 세기로 함
//		또한, 독일(HAMBB)에서는 화주 귀책으로 OP->MT 발생한 경우에는 Round-Trip 기준으로 EUR 150의 Extra Handling Cost를 화주에게 청구하여 Actual Cost인 EUR 60를 충분히 구상하며,
//      Rail을 통해 OP한 경우 즉시 반납하더라도 최대 3일까지 소요된다는 점을 고려하여 Free Time 3일을 적용하는 예외 로직을 적용함. (2012.10.22)
		
		String zTmpDcFtEnd = "";
        String zTmpDcFtCmnc = "";
        String zTmpDcFtEndDate = "";
		String zTmpDcFtHHMI = zDcFmDate.substring(8);
		
// 2012.10.23 변경.
//		if(zDcFmYdCd.substring(0, 2).equals("DE")){ // GERMANY
//			zTmpDcFtEnd = DMTCalculationUtil.getAddDateByDay( zDcFtEnd,  2 );
//		} else {
//			zTmpDcFtEnd = DMTCalculationUtil.getAddDateByDay( zDcFtEnd, -1 );
//		}

		
		// zTmpDcFtEnd 변수는 FT_END_DT 컬럼에 표시용 이다.           2012.10.23 수정
		// zTmpDcFtEndDate Actual Free Time Over Days 산출용 이다. 2012.10.23 수정
		// FT_OVER Days를 맞추기 위해 Free Time End Date를 다시 구한다. 2012.10.23 수정        
		// Normal : To DT - F/T End                              2012.10.23 수정
		// Exception : To DT - F/T End + 1                       2012.10.23 수정
		
		if(zDcFmYdCd.substring(0, 2).equals("DE")){ // GERMANY
			if (dtgCmncTp.equals("1")){ // MVMT Date 기준
				zTmpDcFtEnd = DMTCalculationUtil.getAddDateByDay( zDcFtEnd,  2 );
				
				zDcFtEnd = zTmpDcFtEnd + zTmpDcFtHHMI;
			}else{ //Next Day, Next Day After etc.
				zTmpDcFtCmnc = DMTCalculationUtil.getAddDateByDay( zDcFtEnd,  1 );
				zTmpDcFtEnd  = DMTCalculationUtil.getAddDateByDay( zDcFtEnd,  3 );
				
				zDcFtCmnc = zTmpDcFtCmnc + zTmpDcFtHHMI;
				zDcFtEnd  = zTmpDcFtEnd  + zTmpDcFtHHMI;
			}
			
			zTmpDcFtEndDate = zTmpDcFtEnd;
			zDcFtDays = 3;  // 2012.10.23 수정
		} else {
			if (dtgCmncTp.equals("1")){ // MVMT Date 기준
				zTmpDcFtEnd = DMTCalculationUtil.getAddDateByDay( zDcFtEnd, 0 );
				zTmpDcFtEndDate = DMTCalculationUtil.getAddDateByDay( zDcFtEnd, -1 );
			} else { //Next Day, Next Day After etc.
				zTmpDcFtCmnc = DMTCalculationUtil.getAddDateByDay( zDcFtEnd,  1 );
				zTmpDcFtEnd  = DMTCalculationUtil.getAddDateByDay( zDcFtEnd,  1 );
				zTmpDcFtEndDate = DMTCalculationUtil.getAddDateByDay( zDcFtEnd, 0 );
				
				zDcFtCmnc = zTmpDcFtCmnc + zTmpDcFtHHMI;
				zDcFtEnd  = zTmpDcFtEnd  + zTmpDcFtHHMI;
			}
			
			zDcFtDays = 0;  // 2012.10.23 수정
		}
		
		log.debug("zTmpDcFtEnd FT_END_DT 컬럼에 표시용: " + dtgCmncTp + "-"+zTmpDcFtEnd);
		log.debug("zTmpDcFtEndDate Actual Free Time Over Days 산출용: "+zTmpDcFtEndDate);
		overdayNStatusParmVO.setFtimeEnd(zTmpDcFtEndDate);
		
		log.debug("zTmpDcFtEnd : "+zTmpDcFtEnd);
		//overdayNStatusParmVO.setFtimeEnd(zTmpDcFtEnd);
		overdayNStatusParmVO.setDttCode(zDttCode);
		overdayNStatusParmVO.setOfcCd(zOfcCd);
		overdayNStatusParmVO.setMtDate(zWebMtDate);
		overdayNStatusParmVO.setCstopIdx(String.valueOf(idxCstop));
		overdayNStatusParmVO.setCStopNoList(cstopNoList);
		overdayNStatusParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가

		//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
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
		// 2015-09-17. 김기태 [CHM-201537972] [DMT] US DTC USLGB, USLAX, USOAK로직 수정 
		overdayNStatusParmVO.setToYrdCd(zDcToYdCd);

			
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
			calculationParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
			calculationParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
			calculationParmVO.setDivOverDay("0");
			calculationParmVO.setFtDys(String.valueOf(zDcFtDays));				// 2014.03.12
			calculationParmVO.setFmMvmtYdCd(zDcFmYdCd);							// 2014.03.12
			calculationParmVO.setTrfAplyDt(dtgEfftDt);							// 2014.03.12
			
			CalculationAMTVO calculationAMTVO = null;
			try {
				calculationParmVO.setDmdtTrfAplyTpCd("G");						// 2014.03.12
				calculationParmVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));	// 2014.03.12
				
				calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
				
				rateDtlCnt = DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
				zDcOrgAmt = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
				log.debug("rateDtlCnt=="+rateDtlCnt);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Charge & Total Function Error -"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("Charge & Total Function Error -" + new ErrorHandler(e).getMessage());
			}
			
		}
		
		zDcApplRate = "G" ; 				/* Applied Rate Set  */
		zDcBillAmt  = zDcOrgAmt ;  			/* Basic  Amount Fixing */
		
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
			chargeCalculationContainerVO.setBzcDmdtDeTermCd(String.valueOf(zDmdtDeTermCd));
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
							freeTimeEndParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가

							//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
							freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
							freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
							freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
							
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

							// Total Day가 0인 경우에는 CMNC, End Date를 From Date와 동일하게 처리 
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
									
									freeTimeStartParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
									//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
									freeTimeStartParmVO.setIoBndCd(zDbcIoBnd);
									freeTimeStartParmVO.setBkgDeTermCd(zBcntrDlvTerm);
									freeTimeStartParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
									
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
								freeTimeEndParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
								//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
								freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
								freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
								freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);

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
						overdayNStatusParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가

						//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
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
								calculationParmVO.setDmdtDeTermCd(String.valueOf(zDmdtDeTermCd));
								calculationParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
								calculationParmVO.setCntrts(zCntrtsCd);
								calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
								calculationParmVO.setDivOverDay("0");
								
								CalculationAMTVO calculationAMTVO = null;
								
								try {
									calculationParmVO.setDmdtTrfAplyTpCd("G");						// 2014.03.12
									calculationParmVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));	// 2014.03.12
									
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
		/* 2010.09.06 CSR 요청에 의해 Billable 금액이 (-)면 0으로 설정하거나, 아니면 원래 그대로 trim하기 */
//		zDcBillAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcBillAmt);
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
		log.debug("* [ChargeCalculationContainerVO ] zDmdtDeTermCd 	:"+zDmdtDeTermCd);
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
		chargeCalculationContainerVO.setBzcDmdtDeTermCd(zDmdtDeTermCd);
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
		chargeCalculationContainerVO.setToMvmtYdCd(zDcToYdCd);  //20100105 cancel charge에서 사용.
		chargeCalculationContainerVO.setToMvmtStsCd(zDcToCnms); //20100105 cancel charge에서 사용.		
		chargeCalculationContainerVO.setCstopIdx(String.valueOf(idxCstop));
		chargeCalculationContainerVO.setCStopNoList(cstopNoList);
		chargeCalculationContainerVO.setMsgCd("0");
		chargeCalculationContainerVO.setToMvmtYdCd(zDcToYdCd);
		
		return chargeCalculationContainerVO;
	}	
}