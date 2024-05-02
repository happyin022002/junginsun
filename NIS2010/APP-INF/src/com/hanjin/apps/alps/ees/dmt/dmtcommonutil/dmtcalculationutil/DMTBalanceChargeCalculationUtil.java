/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTBalanceChargeCalculationUtil.java
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
* 2010.09.10 유병희 [] [EES-DMT] CSR 요청에 의해 SvrId 설정 변경
* 2010.11.12 김태균 [CHM-201006793-01] 소스 결함 관련 수정
* 2011.01.24 김태균 [CHM-201108455-01] [DMT] Invoice Error - HKG086108700 :  Partial invoice
* 2011.03.31 김태균 [CHM-201109458-01] [DMT] T/S BKG의 T/S 미실행(육상운송) CNTR의 Port DEM 생성 Logice 보완
* 2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
* 2012.03.19 김현화 [CHM-201216014-01]Time Clock Stop 기능 보완:freeTimeStart/freeTimeEnd/overday 관련 Term cd 변경(BKG_CONTAINER정보)
* 2012.06.04 김현화 [CHM-201217905-01]유럽지역 TS DMIF 생성 중단 요청 :  DMDT_CHG_LOC_DIV_CD = 'TSP'이면  fixedpod, fixedpol를 호출, 그외는 호출하지 않음   
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration.DMTCalculationDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.AFTExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BkgContainerInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeDataVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtAFTGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPODLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPOLLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeEndParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeStartParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OfficeInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * Balance calculation 함수 <br>
 *
 * @author Choi Sung Hwan
 * @see DMTCalculationDBDAO 클래스 참조
 * @since J2EE 1.4
 */
public class DMTBalanceChargeCalculationUtil {
	
	// Database Access Object
	public transient DMTCalculationDBDAO dbDao = null; 
	protected transient Logger log = null;
	
	DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
	/**
	 * DMTCalculationUtil 객체 생성<br>
	 * DMTCalculationDBDAO 생성한다.<br>
	 */
	public DMTBalanceChargeCalculationUtil() {
		dbDao = new DMTCalculationDBDAO();
		log = Logger.getLogger(getClass().getName());
	}
	
	/**
	 *  balanceChargeCalculation 대한 해당 데이터를 조회한다.
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return ChargeCalculationContainerVO
	 * @exception EventException
	 */
	public ChargeCalculationContainerVO balanceChargeCalculation(ChargeCalculationParmVO chargeCalculationParmVO) throws EventException{
		
		ChargeCalculationContainerVO chargeCalculationContainerVO = new ChargeCalculationContainerVO();
		FixPOLLocationParmVO fixPOLLocationParmVO = new FixPOLLocationParmVO();
		FixPODLocationParmVO fixPODLocationParmVO = new FixPODLocationParmVO();
		OverdayNStatusParmVO overdayNStatusParmVO = new OverdayNStatusParmVO();
		OverdayNDivParmVO 	 overdayNDivParmVO    = new OverdayNDivParmVO();
		CalculationParmVO 	 calculationParmVO 	  = new CalculationParmVO();
		ExchangeRateParmVO 	 exchangeRateParmVO   = new ExchangeRateParmVO();
		
		AFTExceptionParmVO 			aftExceptionParmVO 			= new AFTExceptionParmVO();
		
		String zSvrId	  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getSvrId());				/*	Server ID			*/
		String zCntrNo    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrNo());
		long   zCnmvCycNo = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getCntrCycNo());
		String zDttCode   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtTrfCd());
		String zLocDiv    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtChgLocDivCd());
		long   zDccSeq 	  = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getChgSeq());
		String zDcFmDate  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtDt());
		String zDcFmYdCd  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtYdCd());
		String zDcFmCnms  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtStsCd());
		String zDcToDate  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtDt());
		String zDcToYdCd  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtYdCd());
		String zDcToCnms  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtStsCd());
		
		log.debug("***********************************************************");
		log.debug("[ChargeCalculationParmVO]>> zSvrId 		:"+ zSvrId);
		log.debug("[ChargeCalculationParmVO]>> zCntrNo 		:"+ zCntrNo);
		log.debug("[ChargeCalculationParmVO]>> zCnmvCycNo 	:"+ zCnmvCycNo);
		log.debug("[ChargeCalculationParmVO]>> zDttCode 	:"+ zDttCode);
		log.debug("[ChargeCalculationParmVO]>> zLocDiv 		:"+ zLocDiv);
		log.debug("[ChargeCalculationParmVO]>> zDccSeq	 	:"+ zDccSeq);
		log.debug("[ChargeCalculationParmVO]>> zDcFmDate 	:"+ zDcFmDate);
		log.debug("[ChargeCalculationParmVO]>> zDcFmYdCd 	:"+ zDcFmYdCd);
		log.debug("[ChargeCalculationParmVO]>> zDcFmCnms 	:"+ zDcFmCnms);
		log.debug("[ChargeCalculationParmVO]>> zDcToDate 	:"+ zDcToDate);
		log.debug("[ChargeCalculationParmVO]>> zDcToYdCd 	:"+ zDcToYdCd);
		log.debug("[ChargeCalculationParmVO]>> zDcToCnms 	:"+ zDcToCnms);
		log.debug("*************************************************************");
		
		/////////////////////START    변수 정의    /////////////////
		
		String		zOfcCd				= "";
		String		zOfcRhq				= "";
		String		zPorLoc				= "";
		String		zPolLoc				= "";
		String		zPodLoc				= "";
		String		zDelLoc				= "";
		
		String		zPostRly			= "";
		String		fixPodLoc			= "";
		String		zVslCd				= "";
		String		zSkdVoyageNo		= "";
		String		zSkdDirCd			= "";
		long		zDtnSeq				= 0 ;
		String		zDmdtDeTermCd		= "";
		long		zDtgGrpId			= 0 ;
		String		zCurCd				= "";
		long		zDcFtDays			= 0 ;
		String		zDcFtCmnc			= "";
		String		zDcFtEnd			= "";
		long		zDcFtOver			= 0 ;
		String		zDcStatus			= "";
		long		zDcOrgOver			= 0 ;
		long		zDcBfrOver			= 0 ;
		long		zDcAftOver			= 0 ;
		String		zDcApplRate			= "";
		double		zDcOrgAmt			= 0 ;
		double		zDcExpAmt			= 0 ;
		double		zDcDscAmt			= 0 ;
		double		zDcBillAmt			= 0 ;
		double		zDcBfrAmt			= 0 ;
		double		zDcAftAmt			= 0 ;
		
		String 		zScNo				= "";   
		long   		zScVerSeq			= 0;                                             
		long   		zScGrpSeq			= 0;	
		String		dsdCurCd			= "";
		
		String 		bzcTrfAplyDt 	    = ""; //2010.02.05
		String      zBkgNo				= ""; //2010.03.26
		
		String 		zRfaApprNo			= ""; 
		String 		zRfaDarNo			= ""; 
		long		zRfaMapgSeq			= 0;  
		long		zRfaVerSeq			= 0;  
		long		zRfaDtlSeq			= 0;  
		long	 	zCmbSeq				= 0;  
		String		dbdCurCd			= "";
		String		zCntrtsCd			= "";
		String		zDbcIoBnd			= "";
		double		getBfrExRate		= 1.0;	
		long		divOverDay			= 0;	
		String		zFixedVlDt			= "";	
		String		zWebMtDate			= "";
		String		fixPolLoc			= "";
		String		zPreRly				= "";
		String      zDccTrsInd          = ""; //2010.04.15.
		List<String> cstopNoList 		= null;
		long		idxCstop			= 0;
		String		zScRfaExptAplyDt	= ""; //2011.01.24.
		String		scRfaExptAmt		= "0";//2014.03.14
		
		String	zClptIndSeq		= "";
	
		//AFTER
		String zAftApprNo		= "";                                                      
		String zAftDarNo		= "";                                                      
		long   zAftAdjSeq		= 0;  
		
		String dadFtimeMk		= "";                                                      
		long   dadAddDay		= 0;                                              
		long   dadTtlDay		= 0;                                              
		String dadExclSat		= "";                                                      
		String dadExclSun		= "";                                                      
		String dadExclHoli		= "";                                                      
		String dadDcMk			= "";                                                      
		String dadCurCd			= "";                                                      
		double dadDcAmt			= 0;                                                
		double dadDcRate		= 0;

		double getAftExRate		= 1.0;	
		
		double tmp1				= 0;					
		double tmp2				= 0;
        
		//////////////////////END    변수 정의    ///////////////// 
		
		/*
		[logic] From Date Checking
		*/
		if(zDcFmDate.length() == 0){
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("From Movement Not Found !");
			return chargeCalculationContainerVO;
		}
		
		List<ChargeDataVO> chargeData = null;
		
		try {
			chargeData = dbDao.getChargeData(chargeCalculationParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("Bal - Chrg Data Select Error ! SQL:  " + e.getMessage());
			log.error("*******************************************************");
			throw new EventException("Bal - Chrg Data Select Error ! SQL: " + e.getMessage());
		}
		
		if (chargeData!=null && chargeData.size()>0){
			ChargeDataVO tmp = chargeData.get(0);
			if (tmp!=null){
	
				zDcApplRate 	= DMTCalculationUtil.nullToString(tmp.getZDcApplRate()); 
				zCurCd 			= DMTCalculationUtil.nullToString(tmp.getZCurCd());    
				zOfcRhq 		= DMTCalculationUtil.nullToString(tmp.getZOfcRhq());    
				zDtnSeq 		= DMTCalculationUtil.stringToLong(tmp.getZDtnSeq());
				zDmdtDeTermCd	= DMTCalculationUtil.nullToString(tmp.getBzcDmdtDeTermCd());   
				zDtgGrpId 		= DMTCalculationUtil.stringToLong(tmp.getZDtgGrpId());  
				zRfaApprNo 		= DMTCalculationUtil.nullToString(tmp.getZRfaApprNo());   
				zRfaDarNo 		= DMTCalculationUtil.nullToString(tmp.getZRfaDarNo());    
				zRfaMapgSeq 	= DMTCalculationUtil.stringToLong(tmp.getZRfaMapgSeq());  
				zRfaVerSeq 		= DMTCalculationUtil.stringToLong(tmp.getZRfaVerSeq());   
				zRfaDtlSeq 		= DMTCalculationUtil.stringToLong(tmp.getZRfaDtlSeq());   
				zScNo 			= DMTCalculationUtil.nullToString(tmp.getZScNo());    
				zScVerSeq 		= DMTCalculationUtil.stringToLong(tmp.getZScVerSeq());
				zScGrpSeq 		= DMTCalculationUtil.stringToLong(tmp.getZScGrpSeq());
				zScRfaExptAplyDt= DMTCalculationUtil.nullToString(tmp.getZScRfaExptAplyDt());    //2011.01.24.
				zDbcIoBnd 		= DMTCalculationUtil.nullToString(tmp.getZDbcIoBnd());
				zCntrtsCd 		= DMTCalculationUtil.nullToString(tmp.getZCntrtsCd());
				zVslCd 			= DMTCalculationUtil.nullToString(tmp.getZVslCd());   
				zSkdVoyageNo 	= DMTCalculationUtil.nullToString(tmp.getZSkdVoyageNo());
				zSkdDirCd 		= DMTCalculationUtil.nullToString(tmp.getZSkdDirCd());   
				zPolLoc 		= DMTCalculationUtil.nullToString(tmp.getZPolLoc());   
				zPodLoc 		= DMTCalculationUtil.nullToString(tmp.getZPodLoc());   
				zPorLoc 		= DMTCalculationUtil.nullToString(tmp.getZPorLoc());   
				zDelLoc 		= DMTCalculationUtil.nullToString(tmp.getZDelLoc());   
				zPostRly 		= DMTCalculationUtil.nullToString(tmp.getZPostRly());  
				zPreRly 		= DMTCalculationUtil.nullToString(tmp.getZPreRly());   
				dbdCurCd 		= DMTCalculationUtil.nullToString(tmp.getZRfaCurCd()); 
				dsdCurCd 		= DMTCalculationUtil.nullToString(tmp.getZScCurCd());  
				bzcTrfAplyDt    = DMTCalculationUtil.nullToString(tmp.getBzcTrfAplyDt());
				zBkgNo		    = DMTCalculationUtil.nullToString(tmp.getZBkgNo());    
				zDccTrsInd		= DMTCalculationUtil.nullToString(tmp.getZDccTrsInd());
				scRfaExptAmt	= DMTCalculationUtil.nullToString(tmp.getScRfaExptAmt());					
				zClptIndSeq		= DMTCalculationUtil.nullToString(tmp.getClptIndSeq());
			}
		}
	
		log.debug("*****************************************************************");
		log.debug("*[ Balance - getChargeData ] zDcApplRate	:"+zDcApplRate		);
		log.debug("*[ Balance - getChargeData ] zCurCd 		:"+zCurCd			);
		log.debug("*[ Balance - getChargeData ] zOfcRhq 	:"+zOfcRhq			);
		log.debug("*[ Balance - getChargeData ] zDtnSeq 	:"+zDtnSeq			);
		log.debug("*[ Balance - getChargeData ] zDmdtDeTermCd 	:"+zDmdtDeTermCd);
		log.debug("*[ Balance - getChargeData ] zDtgGrpId 	:"+zDtgGrpId		);
		
		log.debug("*[ Balance - getChargeData ] zRfaApprNo 	:"+zRfaApprNo		);
		log.debug("*[ Balance - getChargeData ] zRfaDarNo 	:"+zRfaDarNo		);
		log.debug("*[ Balance - getChargeData ] zRfaMapgSeq :"+zRfaMapgSeq		);
		log.debug("*[ Balance - getChargeData ] zRfaVerSeq 	:"+zRfaVerSeq		);
		log.debug("*[ Balance - getChargeData ] zRfaDtlSeq 	:"+zRfaDtlSeq		);
		log.debug("*[ Balance - getChargeData ] zScRfaExptAplyDt	:"+zScRfaExptAplyDt		);
		log.debug("*[ Balance - getChargeData ] zCmbSeq 	:"+zCmbSeq			);
		
		log.debug("*[ Balance - getChargeData ] zScNo 		:"+zScNo			);
		log.debug("*[ Balance - getChargeData ] zScVerSeq 	:"+zScVerSeq		);
		log.debug("*[ Balance - getChargeData ] zScGrpSeq 	:"+zScGrpSeq		);
		
		log.debug("*[ Balance - getChargeData ] zDbcIoBnd 	:"+zDbcIoBnd		);
		log.debug("*[ Balance - getChargeData ] zCntrtsCd 	:"+zCntrtsCd		);
		log.debug("*[ Balance - getChargeData ] zVslCd		:"+zVslCd			);
		log.debug("*[ Balance - getChargeData ] zSkdVoyageNo:"+zSkdVoyageNo		);
		log.debug("*[ Balance - getChargeData ] zSkdDirCd 	:"+zSkdDirCd		);
		log.debug("*[ Balance - getChargeData ] zPolLoc 	:"+zPolLoc			);
		log.debug("*[ Balance - getChargeData ] zPodLoc 	:"+zPodLoc			);
		log.debug("*[ Balance - getChargeData ] zPorLoc 	:"+zPorLoc			);
		log.debug("*[ Balance - getChargeData ] zDelLoc 	:"+zDelLoc			);
		log.debug("*[ Balance - getChargeData ] zPostRly 	:"+zPostRly			);
		log.debug("*[ Balance - getChargeData ] zPreRly 	:"+zPreRly			);
		log.debug("*[ Balance - getChargeData ] dbdCurCd 	:"+dbdCurCd			);
		log.debug("*[ Balance - getChargeData ] dsdCurCd	:"+dsdCurCd			);
		
		log.debug("*[ Balance - getChargeData ] bzcTrfAplyDt:"+bzcTrfAplyDt		);
		log.debug("*[ Balance - getChargeData ] zBkgNo		:"+zBkgNo			);
		log.debug("*[ Balance - getChargeData ] zDccTrsInd	:"+zDccTrsInd		);
		log.debug("*****************************************************************");
	
		//2010.04.12 [DEM/DET Office Setting] - zOfcCd 생성.
		OfficeInfoVO officeInfoVO = null;
		
		try {
			officeInfoVO = dbDao.searchOfficeInfoByFmYardCd(zDbcIoBnd, zDcFmYdCd);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("[Exception]>> DEM/DET Office Select Error ! : (BKG_NO: "+zBkgNo+"YARD: "+zDcFmYdCd+ " ) " );
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
			chargeCalculationContainerVO.setMsgDesc("DEM/DET Office Skip ! : (BKG_NO: "+zBkgNo+"YARD: "+zDcFmYdCd+ " ) " );
			//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
			return chargeCalculationContainerVO;
		} else {
			
			//위 조건에 해당하지 않으면 Charge Calculation시의 Office와 RHQ를 Setting한다
			zOfcCd = officeInfoVO.getOfcCd();
			zOfcRhq = officeInfoVO.getOfcRhq();
			
			//하단 리턴시에 ofc_cd 반영.
			log.debug("*******************************************************");
			log.debug("[ Office/RHQ ]  "+officeInfoVO.getOfcCd()+" "+ officeInfoVO.getOfcRhq()+" "+ zDcFmYdCd);
			log.debug("*******************************************************");
		}
		
		log.debug("*******************************************************");
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcCd 		: "+ officeInfoVO.getOfcCd());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getCollectYn 	: "+ officeInfoVO.getCollectYn());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcRhq 		: "+ officeInfoVO.getOfcRhq());
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
		
		/*		
		[logic] 
		*/
		//2010.04.15 [return: Select Sever ID] 
		String rtnSvrId = "";
		try {
			rtnSvrId = dbDao.searchSvrId(zOfcCd);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("Select Sever ID Error ! : ("+zOfcCd+ " ) " );
			log.error("*******************************************************");
			throw new EventException("Select Sever ID Error ! : " + new ErrorHandler(e).getMessage());
		}
		log.debug("*******************************************************");
		log.debug("[return: Select Sever ID]>> rtnSvrId : "+ rtnSvrId);
		log.debug("*******************************************************");
		
		/*		
		[logic] POD Loc Fix  
		*/
		fixPODLocationParmVO.setPodCd(zPodLoc);
		fixPODLocationParmVO.setDelCd(zDelLoc);
		fixPODLocationParmVO.setPostRly(zPostRly);
		fixPODLocationParmVO.setBkgNo(zBkgNo); //2010.03.26 

		// 2012.06.04 김현화 [CHM-201217905-01]유럽지역 TS DMIF 생성 중단 요청	
		
		if ( "TSP".equals(zLocDiv)){
			fixPodLoc = dmtCalculationUtil.fixPODLocation(fixPODLocationParmVO);
		}else{
			fixPodLoc = zPodLoc ;
		}
		
		log.debug("*******************************************************");
		log.debug("[fixPODLocation] fixPodLoc : "+ fixPodLoc);
		log.debug("*******************************************************");
		
		/*	
		[logic] POL Loc Fix
		*/
		
		fixPOLLocationParmVO.setPorCd(zPorLoc);
		fixPOLLocationParmVO.setPolCd(zPolLoc);
		fixPOLLocationParmVO.setPreRly(zPreRly);
		fixPOLLocationParmVO.setBkgNo(zBkgNo); //2010.03.26
		
		//fixPolLoc = dmtCalculationUtil.fixPOLLocation(fixPOLLocationParmVO);
		// 2012.06.04 김현화 [CHM-201217905-01]유럽지역 TS DMIF 생성 중단 요청
		if ("TSP".equals(zLocDiv)){
			fixPolLoc = dmtCalculationUtil.fixPOLLocation(fixPOLLocationParmVO);
		}else{
			fixPolLoc = zPolLoc;
		}
		
		log.debug("*******************************************************");
		log.debug("[fixPOLLocation] fixPolLoc : "+ fixPolLoc);
		log.debug("*******************************************************");
		
		/*		
		[logic] Set FT CMNC, FT END  
		*/
		
		zDcFtDays 	= 0;

		zDcFtCmnc 	= zDcFmDate;
		zDcFtEnd  	= zDcFmDate;
	
		/*	
		[logic] VL(To Date) Change
		*/
		if(	( zDttCode.equals("DMOF" ) || zDttCode.equals("CTOC")) && zDcToCnms.equals("VL")){
			try {
				zFixedVlDt = dbDao.getFixedCmnc(zVslCd, zSkdVoyageNo, zSkdDirCd, 
													zDcToYdCd, "", "to",zClptIndSeq);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Fixed VL Date Select Error:"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Fixed VL Date Select Error:" + new ErrorHandler(e).getMessage());
			}
		}
	
		if( zFixedVlDt.length() != 0 ){
			zDcToDate = zFixedVlDt;
		}
		
		log.debug("*******************************************************");
		log.debug("* [VL(To Date) Change ] zFixedVlDt 	:"+zFixedVlDt);
		log.debug("* [VL(To Date) Change ] zDcToDate 	:"+zDcToDate);
		log.debug("*******************************************************");
	
		/*
		[logic] Get Grace Period Overday 
		*/
		try {
			zWebMtDate =	dmtCalculationUtil.getMTNotify(zSvrId, zCntrNo, zCnmvCycNo, zDttCode, zDcFmCnms);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* Get MT Notification Function Error:"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* Get MT Notification Function Error:" + new ErrorHandler(e).getMessage());
		}
		
		log.debug("*******************************************************");
		log.debug("* [ Get Grace Period Overday ] zWebMtDate "+zWebMtDate);
		log.debug("*******************************************************");
		
		/*
		[logic] Get Basic Overday 
		 */
		/* Init Clock Stop Ary */
		cstopNoList = new ArrayList<String>();
		idxCstop = 0;
		
		zDcFtOver = 0;
		
//******2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완		
		BkgContainerInfoVO bkgContainerInfoVO = null;
		
		try {
			bkgContainerInfoVO = dbDao.searchBkgContainerInfo(zBkgNo, zCntrNo, zDcFmYdCd, "", zSvrId, zDttCode, zCnmvCycNo);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("[Invalid BKG No ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			log.error("*******************************************************");
			throw new EventException("[Invalid BKG No ! : " + new ErrorHandler(e).getMessage());
		}
	
		String zYrdCntCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdCntCd());
		String zYrdRgnCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdRgnCd());
		String zYrdStateCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdSteCd());
		String zYrdLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdCd());
		String zRcvTermCd	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRcvTermCd());
		String zDeTermCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDeTermCd());
		
		//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완********//
		overdayNStatusParmVO.setToDate(zDcToDate);
		overdayNStatusParmVO.setFtimeEnd(zDcFtEnd);
		overdayNStatusParmVO.setDttCode(zDttCode);
		overdayNStatusParmVO.setOfcCd(zOfcCd);
		overdayNStatusParmVO.setMtDate(zWebMtDate);
		overdayNStatusParmVO.setCstopIdx(String.valueOf(idxCstop));
		overdayNStatusParmVO.setCStopNoList(cstopNoList);
		
		//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
		overdayNStatusParmVO.setIoBndCd(zDbcIoBnd);
		overdayNStatusParmVO.setBkgDeTermCd(zDeTermCd);
		overdayNStatusParmVO.setBkgRcvTermCd(zRcvTermCd);
		overdayNStatusParmVO.setBkgCntCd(zYrdCntCd);
		overdayNStatusParmVO.setBkgRgnCd(zYrdRgnCd);
		overdayNStatusParmVO.setBkgStateCd(zYrdStateCd);
		overdayNStatusParmVO.setBkgLocCd(zYrdLoc);
		overdayNStatusParmVO.setYrdCntCd(zYrdCntCd);
		overdayNStatusParmVO.setYrdRgnCd(zYrdRgnCd);
		overdayNStatusParmVO.setYrdStateCd(zYrdStateCd);
		overdayNStatusParmVO.setYrdLocCd(zYrdLoc);
		overdayNStatusParmVO.setSvrId(zSvrId);
		overdayNStatusParmVO.setYardCd(zDcFmYdCd);
		// 2015-09-17. 김기태 [CHM-201537972] [DMT] US DTC USLGB, USLAX, USOAK로직 수정 
		overdayNStatusParmVO.setToYrdCd(zDcToYdCd);
		
		OverdayNStatusVO overdayNStatusVO = null;
		try {
			overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
			zDcFtOver  	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
			zDcOrgOver 	= zDcFtOver;
			zDcStatus  	= DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
			idxCstop	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
			cstopNoList = overdayNStatusVO.getCStopNoList();
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* Bal - overdayNStatus Function Error:"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* Bal - overdayNStatus Function Error:" + new ErrorHandler(e).getMessage());
		}
		
		log.debug("*******************************************************");
		log.debug("* [ Bal - BSC overdayNStatus ] zDcOrgOver :"+zDcOrgOver);
		log.debug("* [ Bal - BSC overdayNStatus ] zDcStatus 	:"+zDcStatus);
		log.debug("* [ Bal - BSC overdayNStatus ] idxCstop 	:"+idxCstop);
		log.debug("* [ Bal - BSC overdayNStatus ] cstopNoList :"+cstopNoList);
		log.debug("*******************************************************");
		
		/*
		[logic] Get Amount
		 */
		zDcOrgAmt 	= 0;
		zDcExpAmt 	= 0;
		zDcDscAmt 	= 0;
		zDcBillAmt 	= 0;

		zDcBfrAmt 	= 0;
		zDcAftAmt 	= 0;
		
		CalculationAMTVO calculationAMTVO = new CalculationAMTVO(); 
		
		if( zDcStatus.equals("L") || zDcStatus.equals("F") ){

			/* _________Get OverdayDiv */
			
			overdayNDivParmVO.setSvrId(zSvrId);
			overdayNDivParmVO.setCntrNo(zCntrNo);
			overdayNDivParmVO.setCnmvCycNo(String.valueOf(zCnmvCycNo));
			overdayNDivParmVO.setDttCode(zDttCode);
			overdayNDivParmVO.setLocDiv(zLocDiv);
			overdayNDivParmVO.setDccSeq(String.valueOf(zDccSeq));
	
			OverdayNDivVO overdayNDivVO = null;
			try {
				overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Bal Cal - get OverdayDiv Error:"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Bal Cal - get OverdayDiv Error:" + new ErrorHandler(e).getMessage());
			}
			{
				divOverDay 	= DMTCalculationUtil.stringToLong(overdayNDivVO.getDivOverDay());
			}
			
			log.debug("*******************************************************");
			log.debug("* [Bal Cal - get OverdayDiv ] divOverDay "+divOverDay);
			log.debug("*******************************************************");

			/* ------------------------------------------------ Basic Amt */
			
			/**
			 * 2010-09-10 : SvrId 설정 변경 (zDcFmYdCd로 COM_SYS_AREA_GRP_ID table에서 조회하여 SvrId조회하기로 변경)
			 */
			log.debug("\n\n zDcFmYdCd:"+zDcFmYdCd+" \n\n");
			String bscSvrId = "";
			
			try {
				bscSvrId = dmtCalculationUtil.searchBscSvrId(zDcFmYdCd);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Bal Cal - searchBscSvrId Error:"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Bal Cal - searchBscSvrId Error:" + new ErrorHandler(e).getMessage());
			}

			calculationParmVO.setSvrId(bscSvrId);
			calculationParmVO.setDmdtTrfCd(zDttCode);
			calculationParmVO.setTrfSeq(String.valueOf(zDtnSeq));
			calculationParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
			calculationParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
			calculationParmVO.setDivOverDay(String.valueOf(divOverDay));
			calculationParmVO.setFtDys(String.valueOf(zDcFtDays));				// 2014.03.12
			calculationParmVO.setFmMvmtYdCd(zDcFmYdCd);							// 2014.03.12
			calculationParmVO.setTrfAplyDt(bzcTrfAplyDt);						// 2014.03.12
			calculationParmVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));		// 2014.03.12
			
			calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
			
			try {
//				if (DMTCalculationUtil.stringToDouble(scRfaExptAmt) > 0) {		// 2014.03.12?
				if (!"".equals(zScRfaExptAplyDt)) {	// 2014.03.12
                	calculationParmVO.setDmdtTrfAplyTpCd("B");					// 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
                	calculationParmVO.setTrfAplyDt(zScRfaExptAplyDt);			// 2014.03.12
                } else {
                	calculationParmVO.setDmdtTrfAplyTpCd("G");					// 2014.03.12
                }
				
				calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
				
				zDcOrgAmt  = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Bal Cal - basicCalculation Function Error:"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Bal Cal - basicCalculation Function Error:" + new ErrorHandler(e).getMessage());
			}

			zDcBillAmt = zDcOrgAmt;

			log.debug("*******************************************************");
			log.debug("* [ Bal - ORG AMT ] zDcOrgAmt "+zDcOrgAmt);
			log.debug("*******************************************************");

			/* ----------------------------------------------- BFR Amt */

			if(  zDcApplRate.equals("S") ){
				calculationParmVO.setPropNo(zScNo);
				calculationParmVO.setVerSeq(String.valueOf(zScVerSeq));
				calculationParmVO.setGrpSeq(String.valueOf(zScGrpSeq));
				
				calculationParmVO.setCntrts(zCntrtsCd);
				calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
				calculationParmVO.setTrfAplyDt(zScRfaExptAplyDt);					// 2014.03.12
				
				try {
					calculationParmVO.setDmdtTrfAplyTpCd("S");						// 2014.03.12
					
					calculationAMTVO = dmtCalculationUtil.scCalculation(calculationParmVO);
					
					zDcBfrAmt  = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("* Bal Cal - scCalculation Function Error:"+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("* Bal Cal - scCalculation Function Error:" + new ErrorHandler(e).getMessage());
				}

				if( !zCurCd.equals(dsdCurCd) ){
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
						zDcBfrAmt = zDcBfrAmt * getBfrExRate;
					}catch(Exception e) {
						log.error("*******************************************************");
						log.error("* Bal Cal - searchExchangeRate Function Error:"+e.getMessage());
						log.error("*******************************************************");
						throw new EventException("* Bal Cal - searchExchangeRate Function Error:" + new ErrorHandler(e).getMessage());
					}
				}
				zDcExpAmt = zDcOrgAmt - zDcBfrAmt;		/* Exp Amount Set */
			}
			else if( zDcApplRate.equals("B") ){
				calculationParmVO.setDarNo(zRfaDarNo);
				calculationParmVO.setMapgSeq(String.valueOf(zRfaMapgSeq));
				calculationParmVO.setVerSeq(String.valueOf(zRfaVerSeq));
				calculationParmVO.setDtlSeq(String.valueOf(zRfaDtlSeq));
				calculationParmVO.setCmbSeq(String.valueOf(zCmbSeq));
				
				calculationParmVO.setCntrts(zCntrtsCd);
				calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
				calculationParmVO.setTrfAplyDt(zScRfaExptAplyDt);					// 2014.03.12
				
				try {
					calculationParmVO.setDmdtTrfAplyTpCd("B");						// 2014.03.12
					
					calculationAMTVO = dmtCalculationUtil.beforeCalculation(calculationParmVO);
					
					zDcBfrAmt  = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("* Bal Cal - searchExchangeRate Function Error:"+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("* Bal Cal - searchExchangeRate Function Error:" + new ErrorHandler(e).getMessage());
				}
				
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
						zDcBfrAmt = zDcBfrAmt * getBfrExRate;
					}catch(Exception e) {
						log.error("*******************************************************");
						log.error("* Bal Cal - searchExchangeRate Function Error:"+e.getMessage());
						log.error("*******************************************************");
						throw new EventException("* Bal Cal - searchExchangeRate Function Error:" + new ErrorHandler(e).getMessage());
					}
				}
				zDcExpAmt = zDcOrgAmt - zDcBfrAmt;		/* Exp Amount Set */
			}

			zDcBillAmt = zDcBillAmt - zDcExpAmt;

			log.debug("*************************************************");
			log.debug("* [ Bal - EXP AMT ] zDcExpAmt  :"+zDcExpAmt);
			log.debug("* [ Bal - BIL AMT ] zDcBillAmt :"+zDcBillAmt);
			log.debug("*************************************************");
	
			/* ---------------------------------------------------- AFT Amt */
		}
		
		/* After Booking 로직 추가 */
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
			aftExceptionParmVO.setChgSeq(String.valueOf(zDccSeq));
			
			
			DmtAFTGrpVO dmtAFTGrpVO = null;
			try {
				dmtAFTGrpVO = dmtCalculationUtil.searchAFTExceptionByGeneration(aftExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* AFT searchAFTExceptionByGeneration Function Error ::"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("AFT searchAFTExceptionByGeneration Function Error :: " + new ErrorHandler(e).getMessage());
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
				
				dadDcAmt		= DMTCalculationUtil.stringToDouble(dmtAFTGrpVO.getDcAmt()); // 2010.03.19 long -> Double
				dadDcRate		= DMTCalculationUtil.stringToDouble(dmtAFTGrpVO.getDcRate()); // 2010.03.19 long -> Double

				String DcFlg = "N";
				if( dadDcAmt < 0 ){
					DcFlg = "Y";
				}
				if(zDcBillAmt == 0 && !("Y").equals(DcFlg) ){
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
					log.debug("[ AFT EXP ] dadAddDay 	:"+dadAddDay);
					log.debug("[ AFT EXP ] dadTtlDay 	:"+dadTtlDay);
					log.debug("[ AFT EXP ] dadExclSat	:"+dadExclSat);
					log.debug("[ AFT EXP ] dadExclSun 	:"+dadExclSun);
					log.debug("[ AFT EXP ] dadExclHoli 	:"+dadExclHoli);
					log.debug("*******************************************************");
					
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
									throw new EventException("AFT DC searchExchangeRate Function Error :: " + new ErrorHandler(e).getMessage());
								}
							
								dadDcAmt = dadDcAmt * getAftExRate	;
								
								log.debug("*******************************************************");
								log.debug("[ AFT DC searchExchangeRate ]");
								log.debug("[ AFT DC ExRate ] getAftExRate 	:"+getAftExRate);
								log.debug("[ AFT DC Amt    ] dadDcAmt 		:"+dadDcAmt);
								log.debug("*******************************************************");
							}

							zDcAftAmt = zDcBillAmt - dadDcAmt;
							
							log.debug("*******************************************************");
							log.debug("[ AFT Amt (DA) ] zDcAftAmt :"+zDcAftAmt);
							log.debug("*******************************************************");
						} 
						else {				 /* if ( dadDcRate != 0 ) */
						
//							if( dadFtimeMk.equals("Y") ){
//								zDcAftAmt -= zDcBillAmt * dadDcRate / 100 ;
//							} else {
								/* Don't Remove Below Variable TMP1, TMP2 */
								tmp1 = 0.0;
								tmp2 = 0.0;
								tmp1 = zDcBillAmt * dadDcRate;
								tmp2 = tmp1 / 100;

								zDcAftAmt = zDcBillAmt - tmp2;
//							}
							log.debug("*******************************************************");
							log.debug("[ AFT Amt (DR)] zDcAftAmt :"+zDcAftAmt);
							log.debug("*******************************************************");
						}

						double zDcAftAmt_round = dmtCalculationUtil.trimCurrencyAmount(zCurCd, zDcAftAmt);
						
						if( zDcAftAmt_round <= 0 ){
							zDcStatus = "N" ;
						} else if ( "N".equals(zDcStatus) ) {
							zDcStatus = "F" ;
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
			}
		
			/* AFT Amount Fixing	*/
			log.debug("***************************************************************************************");
			log.debug("* [ AFT Amount Fixing ] zDcBillAmt 	:"+zDcBillAmt);
			log.debug("* [ AFT Amount Fixing ] zDcDscAmt 	:"+zDcDscAmt);
			
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
		zDcBillAmt 	= zDcBillAmt < 0 ? 0 : dmtCalculationUtil.trimCurrencyAmount(zCurCd, zDcBillAmt);
		zDcBfrAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcBfrAmt);
		zDcAftAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcAftAmt);
		
		/* Set The chargeCalculationContainerVO */
		log.debug("*******************************************************************");
		log.debug("****  Set The chargeCalculationContainerVO of Balance **************");
		log.debug("* [ChargeCalculationContainerVO ] zDccTrsInd :"+zDccTrsInd);
		log.debug("* [ChargeCalculationContainerVO ] rtnSvrId 	:"+rtnSvrId);
		log.debug("* [ChargeCalculationContainerVO ] zSvrId 	:"+zSvrId);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcFtDays 	:"+zDcFtDays);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtCmnc 	:"+zDcFtCmnc);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtEnd 	:"+zDcFtEnd);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtOver 	:"+zDcFtOver);
		log.debug("* [ChargeCalculationContainerVO ] zDcOrgOver :"+zDcOrgOver);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcBfrOver :"+zDcBfrOver);
		log.debug("* [ChargeCalculationContainerVO ] zDcAftOver :"+zDcAftOver);
		log.debug("* [ChargeCalculationContainerVO ] zCurCd 	:"+zCurCd);
		log.debug("* [ChargeCalculationContainerVO ] zDcApplRate:"+zDcApplRate);
		log.debug("* [ChargeCalculationContainerVO ] zDcOrgAmt 	:"+zDcOrgAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcExpAmt 	:"+zDcExpAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcDscAmt 	:"+zDcDscAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcBillAmt :"+zDcBillAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcStatus 	:"+zDcStatus);
		log.debug("* [ChargeCalculationContainerVO ] zDcBfrAmt 	:"+zDcBfrAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcAftAmt 	:"+zDcAftAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDtnSeq 	:"+zDtnSeq);
		log.debug("* [ChargeCalculationContainerVO ] zDmdtDeTermCd 	:"+zDmdtDeTermCd);
		log.debug("* [ChargeCalculationContainerVO ] zDtgGrpId 	:"+zDtgGrpId);
		log.debug("* [ChargeCalculationContainerVO ] zRfaApprNo :"+zRfaApprNo);
		log.debug("* [ChargeCalculationContainerVO ] zRfaDarNo 	:"+zRfaDarNo);
		log.debug("* [ChargeCalculationContainerVO ] zRfaMapgSeq:"+zRfaMapgSeq);
		log.debug("* [ChargeCalculationContainerVO ] zRfaVerSeq :"+zRfaVerSeq);
		log.debug("* [ChargeCalculationContainerVO ] zRfaDtlSeq :"+zRfaDtlSeq);
		log.debug("* [ChargeCalculationContainerVO ] zScRfaExptAplyDt :"+zScRfaExptAplyDt);//2011.01.24
		log.debug("* [ChargeCalculationContainerVO ] zCmbSeq 	:"+zCmbSeq);
		log.debug("* [ChargeCalculationContainerVO ] zScNo 		:"+zScNo);
		log.debug("* [ChargeCalculationContainerVO ] zScVerSeq 	:"+zScVerSeq);
		log.debug("* [ChargeCalculationContainerVO ] zScGrpSeq 	:"+zScGrpSeq);
		log.debug("* [ChargeCalculationContainerVO ] zOfcCd 	:"+zOfcCd);
		log.debug("* [ChargeCalculationContainerVO ] zOfcRhq 	:"+zOfcRhq);
		log.debug("* [ChargeCalculationContainerVO ] zDcToDate 	:"+zDcToDate);
		log.debug("* [ChargeCalculationContainerVO ] setCstopIdx	:"+idxCstop);
		log.debug("* [ChargeCalculationContainerVO ] setCStopNoList :"+cstopNoList);
		
		if(cstopNoList != null){
			if(cstopNoList.size() > 0){
				for(int i = 0; i < cstopNoList.size(); i++){
					log.debug(" [ChargeCalculationContainerVO ] cstopNoList.get("+i+")]"+cstopNoList.get(i));
				}
			}
		}
		
		log.debug("* [ChargeCalculationContainerVO ] msgCd :"+0);
		log.debug("******************************************************************");
		//2010.04.15. 
		if(zDccTrsInd.equals("Y")){
			chargeCalculationContainerVO.setSvrId(rtnSvrId); //2010.04.15.
		} else {
			chargeCalculationContainerVO.setSvrId(zSvrId); //2010.04.15.
		}
		
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
		chargeCalculationContainerVO.setBilAmt(String.valueOf(zDcBillAmt));
		chargeCalculationContainerVO.setDmdtChgStsCd(zDcStatus);
		chargeCalculationContainerVO.setScRfaAmt(String.valueOf(zDcBfrAmt));
		chargeCalculationContainerVO.setAftExptDcAmt(String.valueOf(zDcDscAmt));
		chargeCalculationContainerVO.setAftExptAmt(String.valueOf(zDcAftAmt));
		chargeCalculationContainerVO.setBzcTrfSeq(String.valueOf(zDtnSeq));
		chargeCalculationContainerVO.setBzcDmdtDeTermCd(zDmdtDeTermCd);
		chargeCalculationContainerVO.setBzcTrfGrpSeq(String.valueOf(zDtgGrpId));
		chargeCalculationContainerVO.setRfaExptAproNo(zRfaApprNo);
		chargeCalculationContainerVO.setRfaExptDarNo(zRfaDarNo);
		chargeCalculationContainerVO.setRfaExptMapgSeq(String.valueOf(zRfaMapgSeq));
		chargeCalculationContainerVO.setRfaExptVerSeq(String.valueOf(zRfaVerSeq));
		chargeCalculationContainerVO.setRfaRqstDtlSeq(String.valueOf(zRfaDtlSeq));
		chargeCalculationContainerVO.setScRfaExptAplyDt(String.valueOf(zScRfaExptAplyDt));//2011.01.24
		chargeCalculationContainerVO.setCvrgCmbSeq(String.valueOf(zCmbSeq));
		
		chargeCalculationContainerVO.setAftExptAproNo(zAftApprNo);
		chargeCalculationContainerVO.setAftExptDarNo(zAftDarNo);		
		chargeCalculationContainerVO.setAftExptAdjSeq(String.valueOf(zAftAdjSeq));
		
		chargeCalculationContainerVO.setScNo(zScNo);
		chargeCalculationContainerVO.setScExptVerSeq(String.valueOf(zScVerSeq));
		chargeCalculationContainerVO.setScExptGrpSeq(String.valueOf(zScGrpSeq));
		chargeCalculationContainerVO.setOfcCd(zOfcCd);
		chargeCalculationContainerVO.setOfcRhq(zOfcRhq);
		chargeCalculationContainerVO.setToMvmtDt(zDcToDate);		
		chargeCalculationContainerVO.setBzcTrfAplyDt(bzcTrfAplyDt);
		chargeCalculationContainerVO.setCstopIdx(String.valueOf(idxCstop));
		chargeCalculationContainerVO.setCStopNoList(cstopNoList);		
		chargeCalculationContainerVO.setMsgCd("0");
		chargeCalculationContainerVO.setToMvmtYdCd(zDcToYdCd);
		
		return chargeCalculationContainerVO;
	}
}