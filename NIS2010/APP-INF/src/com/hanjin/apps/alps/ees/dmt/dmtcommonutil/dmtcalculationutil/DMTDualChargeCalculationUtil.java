/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTDualChargeCalculationUtil.java
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
* 2013.01.31 임창빈 [CHM-201222196]
*            [DMT] Basic Tariff 및 Commodity Exception Tariff의 Effective Date 적용 기준 변경
*            Basic Tariff 및 Commodity Exception Tariff 적용 시 Inbound Charge(DMIF, DTIC, CTIC)의 경우에는 Effective Date 적용 기준을 아래와 같이 변경 
*            [AS-IS] POD_ETA 
*            [TO-BE] POD가 ‘US’ or ‘CA’이면 OC date, 그 외에는 POD_ETA 
*            - 사유 : FMC 규정에 의거 미국 및 캐나다 수출입 화물의 경우에는 Charge 부과 기준일이 OC date 임 (하지만 현재 시스템 로직은 POD_ETA를 기준으로 하고 있음) 
*            - 기타 : Outbound Charge의 경우 DTOC 및 CTOC는 OP date, DMOF는 OC date를 기준으로 Charge 계산하고 있음 
* 2013.02.28 임창빈 [CHM-201322954] [DMT] 신규 장비에 대한 DMT charge 청구를 위한 Table Mapping 요청
* TP/SZ  Description                          CGP TYPE   CNTR Size 
*--------------------------------------------------------------------
*  C2    20FT COIL RACK CONTAINER            Open Top   20FT 
*  C4    40FT COIL RACK CONTAINER            Open Top   40FT 
*  R8    LIVE FISH CONTAINER                 Reefer     R9 
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration.DMTCalculationDBDAO;
//import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.AFTExceptionParmVO;
//import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BFRExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BkgContainerInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
//import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CommodityExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DtocFreeTimeParmVO;
//import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
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
//import com.hanjin.framework.core.layer.integration.DAOException;


/**
 * Dual calculation 함수 <br>
 * DMTGeneralChargeCalculationUtil에서 Basic Calculation만 적용(commodity, s/c, rfa, after 제외) 
 *
 * @author Choi Sung Hwan
 * @see DMTCalculationDBDAO 클래스 참조
 * @since J2EE 1.6
 */
public class DMTDualChargeCalculationUtil {
	
	// Database Access Object
	public transient DMTCalculationDBDAO dbDao = null; 
	protected transient Logger log = null;
	
	DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
	/**
	 * DMTCalculationUtil 객체 생성<br>
	 * DMTCalculationDBDAO 생성한다.<br>
	 */
	public DMTDualChargeCalculationUtil() {
		dbDao = new DMTCalculationDBDAO();
		log = Logger.getLogger(getClass().getName());
	}
	
	
	
	/**
	 * Dual Charge Calculation 대한 해당 데이터를 조회한다.
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return ChargeCalculationContainerVO
	 * @exception EventException
	 */
	public ChargeCalculationContainerVO dualChargeCalculation(ChargeCalculationParmVO chargeCalculationParmVO) 
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
		String zLocDiv      = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtChgLocDivCd());

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
		log.debug("[ChargeCalculationParmVO]>> zAczCnzCd	:"+ zAczCnzCd);
		log.debug("[ChargeCalculationParmVO]>> zAczCuszCd 	:"+ zAczCuszCd);
		log.debug("[ChargeCalculationParmVO]>> zLocDiv 		:"+ zLocDiv);
		log.debug("*************************************************************");

		if( !zDbcIoBnd.equals(zDttCode.substring(2, 3))){
			zDbcIoBnd = zDttCode.substring(2, 3);
			log.debug("[ChargeCalculationParmVO-if]>> zDbcIoBnd 	:"+ zDbcIoBnd);
		}
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
		
		String zBbRcvTermCd= "";
		String zBbDeTermCd = "";
		
		String zOfcCd		= "";                                              
		String zOfcRhq		= ""; 
		
		String zSalOfc		= "";                                                      
		String zSalRhq		= "";                                                      
		String zBcntrDlvTerm = "";
		String zBcntrRcvTerm = "";    
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
		
		String fixPolLoc	= "";
		String zPreRly		= "";
		
		/* ------------------------------------------- */
		
		long   rateDtlCnt 	= 0;
		long   zDtocFtime	= 0;   
		
		String zFixedVlDt	= "";	
		String zFixedCmnc	= "";	
		
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
		
		String	zClptIndSeq		= "";
		
		//////////////////////END    변수 정의    /////////////////                                                                            

		/*
		[logic] From Date Checking
		*/
		if(zDcFmDate.length() == 0){
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
		log.debug("[Set DMDT_CNTR_TP_CD]>> zDcsCntrTp :"+ zDcsCntrTp);
		log.debug("*******************************************************");
		
		/*
		[logic] DEM/DET Office Setting : DEM/DET Collection Office 확인
		*/
		
		if(zDcFmYdCd.length() == 0){
			zDcFmYdCd = zDcToYdCd;
		}
		log.debug("*******************************************************");
		log.debug("[DEM/DET Office Setting]>> zDcFmYdCd : "+ zDcFmYdCd); 
		log.debug("[DEM/DET Office Setting]>> zDcToYdCd : "+ zDcToYdCd);
		log.debug("*******************************************************");
		
		OfficeInfoVO officeInfoVO = null;
		try {
			officeInfoVO = dbDao.searchOfficeInfoByFmYardCd(zDbcIoBnd, zDcFmYdCd);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("(From Yard) searchOfficeInfoByFmYardCd Select Error !  "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("(From Yard) searchOfficeInfoByFmYardCd Select Error ! " + new ErrorHandler(e).getMessage());
		}
		
		log.debug("*******************************************************");
		log.debug("(From Yard)[DEM/DET Office Setting]>> officeInfoVO.getCollectYn() : "+ officeInfoVO.getCollectYn());
		log.debug("*******************************************************");
		
		if(officeInfoVO == null || officeInfoVO.getCollectYn() == null){
			log.debug("*******************************************************");
			log.debug("(From Yard)[officeInfoVO is null !  88 DEM/DET Office Skip !");
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
				return chargeCalculationContainerVO;
			} else {
				
				//위 조건에 해당하지 않으면 Charge Calculation시의 Office와 RHQ를 Setting한다
				zOfcCd  = officeInfoVO.getOfcCd();
				zOfcRhq = officeInfoVO.getOfcRhq();
				
				chargeCalculationContainerVO.setOfcCd(zOfcCd);
				chargeCalculationContainerVO.setOfcRhq(zOfcRhq);		
				log.debug("*******************************************************");
				log.debug("(From Yard) [Office/RHQ]  "+officeInfoVO.getOfcCd()+" "+ officeInfoVO.getOfcRhq()+" "+ zDcFmYdCd);
				log.debug("*******************************************************");
			}
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
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("DEM/DET Office Code Not Found !");
			return chargeCalculationContainerVO;
		}
		
		if(zDcToYdCd.length() != 0){
			try {
				officeInfoVO = dbDao.searchOfficeInfoByToYardCd(zDbcIoBnd, zDcToYdCd);
			} catch (Exception e) {
				log.error("*******************************************************");
				log.error("[zDcToYdCd.length() != 0  Exception searchOfficeInfoByToYardCd]");
				log.error("*******************************************************");
				throw new EventException("(To Yard)[zDcToYdCd.length() != 0  Exception searchOfficeInfoByToYardCd] : " + new ErrorHandler(e).getMessage());				
			}
			
			if(officeInfoVO.getCollectYn() == null || officeInfoVO.getCollectYn().equals("N") && zDttCode.substring(0, 2).equals("DM")){
				log.debug("*******************************************************");
				log.debug("(To Yard) officeInfoVO.getCollectYn() == N && zDttCode ==DM 89 Not a DEM CLT Office");
				log.debug("*******************************************************");
				chargeCalculationContainerVO.setMsgCd("89");
				//chargeCalculationContainerVO.setMsgDesc("Not a DEM CLT Office ! (ToYd) : "+officeInfoVO.getOfcCd()+" "+zDcToYdCd);
				chargeCalculationContainerVO.setMsgDesc("(To Yard) : " + zDcToYdCd + " does not have DEM/DET Office! Pls correct yard"); //2010.04.07
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
			bkgContainerInfoVO = dbDao.searchBkgContainerInfo(zBkgNo, zCntrNo, zDcFmYdCd, "", zSvrId, zDttCode, zCnmvCycNo);
		} catch (Exception e) {
			log.error("*******************************************************");
			log.error("[Invalid BKG No ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			log.error("*******************************************************");
			throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
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
		log.debug("[searchBkgContainerInfo]");
		log.debug("[BkgContainerInfoVO] zBlNo 			: "+ zBlNo);
		log.debug("[BkgContainerInfoVO] zBrhScNo 		: "+ zBrhScNo);
		log.debug("[BkgContainerInfoVO] zBrhRfaNo 		: "+ zBrhRfaNo);
		log.debug("[BkgContainerInfoVO] zCmdtCd 		: "+ zCmdtCd);
		log.debug("[BkgContainerInfoVO] zRepCmdtCd 		: "+ zRepCmdtCd);
		log.debug("[BkgContainerInfoVO] zBcntrSpeDg 	: "+ zBcntrSpeDg);
		log.debug("[BkgContainerInfoVO] zBcntrSpeRf 	: "+ zBcntrSpeRf);
		log.debug("[BkgContainerInfoVO] zBcntrSpeAk 	: "+ zBcntrSpeAk);
		log.debug("[BkgContainerInfoVO] zBcntrSpeRd 	: "+ zBcntrSpeRd);
		log.debug("[BkgContainerInfoVO] zBcntrSpeBb 	: "+ zBcntrSpeBb);
		log.debug("[BkgContainerInfoVO] zBcntrSocInd 	: "+ zBcntrSocInd);
		log.debug("[BkgContainerInfoVO] zBcntrPartial 	: "+ zBcntrPartial);
		log.debug("[BkgContainerInfoVO] zBcntrExcept 	: "+ zBcntrExcept);
		log.debug("[BkgContainerInfoVO] zPorLoc 		: "+ zPorLoc);
		log.debug("[BkgContainerInfoVO] zPolLoc 		: "+ zPolLoc);
		log.debug("[BkgContainerInfoVO] zPodLoc 		: "+ zPodLoc);
		log.debug("[BkgContainerInfoVO] zDelLoc 		: "+ zDelLoc);
		log.debug("[BkgContainerInfoVO] zYrdLoc 		: "+ zYrdLoc);
		log.debug("[BkgContainerInfoVO] zSalOfc 		: "+ zSalOfc);
		log.debug("[BkgContainerInfoVO] zSalRhq 		: "+ zSalRhq);
		log.debug("[BkgContainerInfoVO] zPorContiCd 	: "+ zPorContiCd);
		log.debug("[BkgContainerInfoVO] zPorCntCd 		: "+ zPorCntCd);
		log.debug("[BkgContainerInfoVO] zPorRgnCd 		: "+ zPorRgnCd);
		log.debug("[BkgContainerInfoVO] zPorStateCd 	: "+ zPorStateCd);
		log.debug("[BkgContainerInfoVO] zPolContiCd 	: "+ zPolContiCd);
		log.debug("[BkgContainerInfoVO] zPolCntCd 		: "+ zPolCntCd);
		log.debug("[BkgContainerInfoVO] zPolRgnCd 		: "+ zPolRgnCd);
		log.debug("[BkgContainerInfoVO] zPolStateCd 	: "+ zPolStateCd);
		log.debug("[BkgContainerInfoVO] zDelContiCd 	: "+ zDelContiCd);
		log.debug("[BkgContainerInfoVO] zDelCntCd 		: "+ zDelCntCd);
		log.debug("[BkgContainerInfoVO] zDelRgnCd 		: "+ zDelRgnCd);
		log.debug("[BkgContainerInfoVO] zDelStateCd 	: "+ zDelStateCd);
		log.debug("[BkgContainerInfoVO] zYrdContiCd 	: "+ zYrdContiCd);
		log.debug("[BkgContainerInfoVO] zYrdCntCd 		: "+ zYrdCntCd);
		log.debug("[BkgContainerInfoVO] zYrdRgnCd 		: "+ zYrdRgnCd);
		log.debug("[BkgContainerInfoVO] zYrdStateCd 	: "+ zYrdStateCd);
		log.debug("[BkgContainerInfoVO] zPostRly 		: "+ zPostRly);
		log.debug("[BkgContainerInfoVO] zBcntrDlvTerm	: "+ zBcntrDlvTerm);
		log.debug("[BkgContainerInfoVO] zPreRly 		: "+ zPreRly);
		log.debug("[BkgContainerInfoVO] zBbRcvTermCd	: "+ zBbRcvTermCd);
		log.debug("[BkgContainerInfoVO] zBbDeTermCd 	: "+ zBbDeTermCd);
		log.debug("*******************************************************");
		
		/*
		[logic] Cargo 타입 결정 : Set Cntr & Cgo Type
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Cargo 타입 결정 : Set Cntr & Cgo Type*");
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
		[logic] Booking의 Container 물량 가져오기 : Get BKG Qty 
		*/
		try {
			zDbcBkgQty = dmtCalculationUtil.searchBookingContainerQuantity(zBkgNo);
		} catch (Exception e) {
			log.error("*******************************************************");
			log.error("** Bkg Qty Select Error :"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("** Bkg Qty Select Error :" + new ErrorHandler(e).getMessage());
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
		bkgCntCd 	=	locationByBoundVO.getBkgCntCd();
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
			fixPolLoc = zPolLoc ;
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
			zClptIndSeq		= DMTCalculationUtil.nullToString(vvEtaVO.getClptIndSeq());
		} catch (Exception e) {
			log.error("*******************************************************");
			log.error("** Eta Date Select Error - "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("** Eta Date Select Error :" + new ErrorHandler(e).getMessage());
		}
		if(!zVslCd.equals("")){
			chargeCalculationContainerVO.setVslCd(zVslCd);
			chargeCalculationContainerVO.setSkdVoyNo(zSkdVoyageNo);
			chargeCalculationContainerVO.setSkdDirCd(zSkdDirCd);
			chargeCalculationContainerVO.setVpsEtaDt(zVpsEtaDt);
		} else {
			log.debug("********************************");
			log.debug("** BKG VVD Not Found - BKG NO **");
			log.debug("********************************");
			
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("* BKG VVD Not Found - BKG NO:"+zBkgNo+	", BND:"+zDbcIoBnd+", POL: "+fixPolLoc+", POD:"+fixPodLoc);
			
			return chargeCalculationContainerVO;
		}
		
		log.debug("*******************************************************");
		log.debug("[searchVVDNEta]");
		log.debug("[VVDNEtaVO] zVslCd 		: "+ zVslCd);
		log.debug("[VVDNEtaVO] zSkdVoyageNo : "+ zSkdVoyageNo);
		log.debug("[VVDNEtaVO] zSkdDirCd 	: "+ zSkdDirCd);
		log.debug("[VVDNEtaVO] zVpsEtaDt 	: "+ zVpsEtaDt);
		log.debug("*******************************************************");
		
		/*
		[logic] Tariff Effective Date 결정 : Set Tariff Effective Date
		*/

		log.debug("*****************************************************************");
		log.debug("* [logic] Tariff Effective Date 결정 : Set Tariff Effective Date *");
		log.debug("*****************************************************************");
		
		BasicTariffParmVO effDateParmVO = new BasicTariffParmVO();
		
		effDateParmVO.setIoBndCd(zDbcIoBnd.substring(0, 1));
		effDateParmVO.setPolLocCd(fixPolLoc);
		effDateParmVO.setPodLocCd(fixPodLoc);
		effDateParmVO.setVpsEtaDt(DMTCalculationUtil.nullToString(zVpsEtaDt,8).substring(0, 8));
		effDateParmVO.setCntrNo(zCntrNo);
		effDateParmVO.setCnmvCycNo(chargeCalculationParmVO.getCntrCycNo());
		effDateParmVO.setFmDate(DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8));
		
		dtgEfftDt = dmtCalculationUtil.getEfftDt(effDateParmVO);
		
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
		} catch (Exception e) {
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
		log.debug("*[Booking의 DEL Location 결정 :  BKG DEL Loc Fix]");
		log.debug("fixDelContiCd 	: "+ fixDelContiCd);
		log.debug("fixDelCntCd 		: "+ fixDelCntCd);
		log.debug("fixDelRgnCd 		: "+ fixDelRgnCd);
		log.debug("fixDelStateCd 	: "+ fixDelStateCd);
		log.debug("fixDelLoc 		: "+ fixDelLoc);
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
		} catch (Exception e) {
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
			zOrgContiCd 	= zPolContiCd;
			zOrgCntCd 		= zPolCntCd;
			zOrgRgnCd 		= zPolRgnCd;
			zOrgStateCd 	= zPolStateCd;
			zOrgLocCd 		= zPolLoc;
		}
		
		log.debug("*******************************************************");
		log.debug("*[Tariff의 Origin 지역 조정]");
		log.debug("zOrgContiCd 	: "+ zOrgContiCd);
		log.debug("zOrgCntCd 	: "+ zOrgCntCd);
		log.debug("zOrgRgnCd 	: "+ zOrgRgnCd);
		log.debug("zOrgStateCd 	: "+ zOrgStateCd);
		log.debug("zOrgLocCd 	: "+ zOrgLocCd);
		log.debug("*******************************************************");
		
		/*
		[logic] Awkward In/Out-Gauge	
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] Awkward In/Out-Gauge*");
		log.debug("*******************************************************");
		
		try {
			awkInOut = dmtCalculationUtil.searchInOutGauge(zCntrNo, zBkgNo);
		} catch (Exception e) {
			log.error("*******************************************************");
			log.error("*Get the Awkward Cargo in/out-gauge Error!"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("*Get the Awkward Cargo in/out-gauge Error!" + new ErrorHandler(e).getMessage());
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
		
		// I/O Bound에 따라서, BOOKING CONTAINER 기준으로 DMDT_DE_TERM_CD를 결정한다.
		log.error("I/O Bound : ["+ DMTCalculationUtil.nullToString(zDttCode, 4).substring(2,3) + "]");
		
		if( DMTCalculationUtil.nullToString(zDttCode, 4).substring(2,3).equals("I")){
			zDmdtDeTermCd	= zBcntrDlvTerm;
		} else {
			zDmdtDeTermCd	= zBcntrRcvTerm;
		}
		
		basicTariffParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
		
		basicTariffParmVO.setEffDt(dtgEfftDt.trim()); //2010.04.05.
		basicTariffParmVO.setDmdtCntrTpCd(zDcsCntrTp);
		basicTariffParmVO.setDmdtCgoTpCd(zDcsCgoTp);
		basicTariffParmVO.setIoBndCd(zDbcIoBnd);
		basicTariffParmVO.setAwkInOut(awkInOut);
		
		basicTariffParmVO.setSuthChnUseFlg(DMTCalculationUtil.nullToString(chargeCalculationParmVO.getSuthChnUseFlg()));
		
		BasicTariffKeyVO basicTariffKeyVO = null;
		try {
			basicTariffKeyVO = dmtCalculationUtil.searchBasicTariffByGeneration(basicTariffParmVO);
		} catch (Exception e) {
			log.error("**************************************************************");
			log.error("*searchBasicTariffByGeneration Functon Error!"+ e.getMessage());
			log.error("**************************************************************");
			throw new EventException("*searchBasicTariffByGeneration Functon Error!" + new ErrorHandler(e).getMessage());			
		}
		
		if(DMTCalculationUtil.nullToString(basicTariffKeyVO.getMsgCd()).equals("-99")){
			chargeCalculationContainerVO.setMsgCd("3");  // 2에서 3으로 변경함. 2012.07.17 KHH -Exempted Error Charge 생성  중지
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
			// Door('D'), Yard('Y') 와 Default('N') 우선 순위에 따라 DMDT_DE_TERM_CD 를 변경 될 수 있다.
			// 따라서, 초기화 후 조회된 DMDT_DE_TERM_CD 를 사용하도록 한다.
			zDmdtDeTermCd 	= "";
			zDmdtDeTermCd	= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtDeTermCd());
			zDtgGrpId		= DMTCalculationUtil.stringToLong(basicTariffKeyVO.getTrfGrpSeq());
			
			dtgCmncTp		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtChgCmncTpCd());
			dtgCmncHr		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getCmncHr());
			dtgExclSat		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSatFlg());
			dtgExclSun		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSunFlg());
			dtgExclHoli		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldHolFlg());
			zCurCd			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getCurrCd());
		}

		chargeCalculationContainerVO.setBzcDmdtDeTermCd(zDmdtDeTermCd);
		
		log.debug("*********************************************");
		log.debug("[searchBasicTariffByGeneration]");
		log.debug("zSvrId 			: "+ zSvrId);
		log.debug("zDttCode 		: "+ zDttCode);
		log.debug("zDtnSeq 			: "+ zDtnSeq);
		log.debug("zDmdtDeTermCd 	: "+ zDmdtDeTermCd);
		log.debug("zDtgGrpId 		: "+ zDtgGrpId);
		
		log.debug("dtgCmncTp 		:"+dtgCmncTp);
		log.debug("dtgCmncHr 		:"+dtgCmncHr);
		log.debug("dtgExclSat 		:"+dtgExclSat);
		log.debug("dtgExclSun 		:"+dtgExclSun);
		log.debug("dtgExclHoli 		:"+dtgExclHoli);
		log.debug("zCurCd 			:"+zCurCd);
		log.debug("*********************************************");

		/*		
		[logic] Basic Tariff의 Free days 가져오기 : Get Basic Free Days
		>>>>> zDbcBkgQty -> Booking의 Container 물량
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]  Basic Tariff의 Free days 가져오기*");
		log.debug("*******************************************************");
			 
		try {
			zDcFtDays = dmtCalculationUtil.basicFreeTime(zSvrId, zDttCode, zDtnSeq, zDmdtDeTermCd, zDtgGrpId, zDbcBkgQty);
		} catch (Exception e) {
			log.error("*******************************************************");
			log.error("** FreeTime Function Error"+ e.getMessage() + "\n"+ zDttCode+ ", "+ zDtnSeq+ ", "+zDmdtDeTermCd+ ", "+zDtgGrpId+ ", "+ zDbcBkgQty);
			log.error("*******************************************************");
			throw new EventException("** FreeTime Function Error " + new ErrorHandler(e).getMessage());
		}
		log.debug("*******************************************************");
		log.debug("[basicFreeTime]");
		log.debug("zDcFtDays :"+zDcFtDays);
		log.debug("*******************************************************");
		
		/*	
		[logic] ID->OC Case Free days 조정 : ID -> OC F/Days Adjust
		>>>>> getDTOCFtime
		*/
		log.debug("**************************************************************");
		log.debug("* [logic]  ID->OC Case Free days 조정 : ID -> OC F/Days Adjust*");
		log.debug("**************************************************************");
		
		if( zDttCode.equals("DTIC") &&  zDcFmCnms.equals("ID")	&&  zDcToCnms.equals("OC") ){
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
			} catch (Exception e) {
				log.error("*******************************************************");
				log.error("**getDTOCFtime Function Error"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("**getDTOCFtime Function Error " + new ErrorHandler(e).getMessage());				
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
				zFixedCmnc = DMTCalculationUtil.nullToString(dbDao.getFixedCmnc(zVslCd, zSkdVoyageNo, zSkdDirCd, zDcFmYdCd, zDttCode, "fm",zClptIndSeq));
			} catch (Exception e) {
				log.error("*******************************************************");
				log.error("* Fixed CMNC Date Select Error - "+ e.getMessage());
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
			freeTimeStartParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
			//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
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
				zDcFtCmnc 	    = DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());					
				idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
				cstopNoList 	= freeTimeStartVO.getCStopNoList();
				
				log.debug("**********************************************************");
				log.debug("* [FreeTimeVO(return) ] zDcFtCmnc 	:["+zDcFtCmnc+"]");
				log.debug("* [FreeTimeVO(return) ] idxCstop 		:["+idxCstop+"]");
				log.debug("* [FreeTimeVO(return) ] cstopNoList 	:["+cstopNoList+"]");
				log.debug("**********************************************************");
					
			} catch (Exception e) {
				log.error("*******************************************************");
				log.error("* BSC searchFreeTimeStart Function Error :  "+ e.getMessage());
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
		// 위의 조회값 입력 >>> zDcFtCmnc
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
		freeTimeEndParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
		//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
		freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
		freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
		freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
		
		log.debug("****************************************************************");
		log.debug("* [freeTimeEndParmVO(param) ] ioIdxCstop :["+idxCstop+"]");
		log.debug("* [freeTimeEndParmVO(param) ] cstopNoList :["+cstopNoList+"]");
		log.debug("****************************************************************");
		FreeTimeVO freeTimeEndVO = null;
		try {
			freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
			zDcFtEnd  		= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
			idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
			cstopNoList 	= freeTimeEndVO.getCStopNoList();			
		} catch (Exception e) {
			log.error("*******************************************************");
			log.error("* G.FT End Function Error -"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* G.FT End Function Error -" + new ErrorHandler(e).getMessage());				
		}
		log.debug("*******************************************************");
		log.debug("* [FreeTimeVO(return) ] zDcFtEnd :["+zDcFtEnd+"]");
		log.debug("* [FreeTimeVO(return) ] ioIdxCstop :["+idxCstop+"]");
		log.debug("* [FreeTimeVO(return) ] cstopNoList :["+cstopNoList+"]");
		log.debug("*******************************************************");
		
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
			try {
				zFixedVlDt = DMTCalculationUtil.nullToString(dbDao.getFixedCmnc(zVslCd, zSkdVoyageNo, zSkdDirCd, zDcToYdCd, "", "to",zClptIndSeq));
			} catch (Exception e) {
				log.error("*******************************************************");
				log.error("* Fixed VL Date Select Error -"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Fixed VL Date Select Error -" + new ErrorHandler(e).getMessage());				
			}		
				
		}

		if( zFixedVlDt.length() != 0 ){
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
		} catch (Exception e) {
			log.error("*******************************************************");
			log.error("*  Get MT Notification Function Error :"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("*  Get MT Notification Function Error :" + new ErrorHandler(e).getMessage());				
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
		overdayNStatusParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
		//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
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
		// 2015-09-17. 김기태 [CHM-201537972] [DMT] US DTC USLGB, USLAX, USOAK로직 수정 
		overdayNStatusParmVO.setToYrdCd(zDcToYdCd);
		
		overdayNStatusParmVO.setEndHr(basicTariffKeyVO.getEndHr());
		
		log.debug("*******************************************************************");
		log.debug("* [overdayNStatusParmVO(param) ] idxCstop :["+idxCstop+"]");
		log.debug("* [overdayNStatusParmVO(param) ] cstopNoList :["+cstopNoList+"]");
		log.debug("*******************************************************************");
		OverdayNStatusVO overdayNStatusVO = null;
		try {
			overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
			zDcFtOver	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
			zDcOrgOver 	= zDcFtOver;
			zDcStatus 	= DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
			idxCstop 	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
			cstopNoList = overdayNStatusVO.getCStopNoList();
		} catch (Exception e) {
			log.error("*******************************************************");
			log.error("* G.Overday Function Error -"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* G.Overday Function Error -" + new ErrorHandler(e).getMessage());				
		}	
			
		log.debug("****************************************************************");
		log.debug("* [OverdayNStatusVO(return) ] zDcOrgOver :["+zDcOrgOver+"]");
		log.debug("* [OverdayNStatusVO(return) ] zDcStatus :["+zDcStatus+"]");
		log.debug("* [OverdayNStatusVO(return) ] idxCstop :["+idxCstop+"]");
		log.debug("* [OverdayNStatusVO(return) ] cstopNoList :["+cstopNoList+"]");
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
			calculationParmVO.setFtDys(String.valueOf(zDcFtDays));						// 2014.03.12
			calculationParmVO.setFmMvmtYdCd(zDcFmYdCd);									// 2014.03.12
			calculationParmVO.setTrfAplyDt(dtgEfftDt);									// 2014.03.12
			
			CalculationAMTVO calculationAMTVO = null;
			try {
				calculationParmVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));			// 2014.03.12
				if (zDcBfrAmt > 0) {													// 2014.03.12
                	calculationParmVO.setDmdtTrfAplyTpCd("B");							// 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
                } else {
                	calculationParmVO.setDmdtTrfAplyTpCd("G");							// 2014.03.12
                }
				
				calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
				
				rateDtlCnt = DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
				zDcOrgAmt  = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
				log.debug("rateDtlCnt=="+rateDtlCnt);
			} catch (Exception e) {
				log.error("*******************************************************");
				log.error("* Charge & Total Function Error -"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Charge & Total Function Error -" + new ErrorHandler(e).getMessage());				
			}
		}
	
		zDcApplRate = "G" ; 				/* Applied Rate Set  */
		zDcBillAmt  = zDcOrgAmt ;  	/* Basic  Amount Fixing */
		
		chargeCalculationContainerVO.setBzcTrfAplyDt(dtgEfftDt);
		
		log.debug("*******************************************************");
		log.debug("* [ORG AMT     = ] zDcOrgAmt :"+zDcOrgAmt);
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
			chargeCalculationContainerVO.setCmdtTrfSeq(String.valueOf(zDcrSeq));
			
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
			chargeCalculationContainerVO.setCmdtCdC(zCmdtCdC);
			chargeCalculationContainerVO.setCmdtTrfSeq(String.valueOf(zDcrSeq));
			chargeCalculationContainerVO.setCmdtOvrDys(String.valueOf(zDcCmdtOver));
			chargeCalculationContainerVO.setCmdtExptAmt(String.valueOf(zDcCmdtAmt));
			chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
		
			chargeCalculationContainerVO.setBzcTrfAplyDt(dtgEfftDt);
			chargeCalculationContainerVO.setCmdtExptAplyDt(dtgEfftDt);
			chargeCalculationContainerVO.setScRfaExptAplyDt(fixDtgEfftDt);
			
			chargeCalculationContainerVO.setCstopIdx(String.valueOf(idxCstop));
			chargeCalculationContainerVO.setCStopNoList(cstopNoList);
			
			chargeCalculationContainerVO.setMsgCd("0");
			
			return chargeCalculationContainerVO;
		}
		
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
		log.debug("* [ChargeCalculationContainerVO ] zDmdtDeTermCd 		:"+zDmdtDeTermCd);
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
		
		log.debug("* [ChargeCalculationContainerVO ] setBzcTrfAplyDt 	:"+dtgEfftDt);
		log.debug("* [ChargeCalculationContainerVO ] setCmdtExptAplyDt 	:"+zDcrSeq);
		log.debug("* [ChargeCalculationContainerVO ] setScRfaExptAplyDt :"+fixDtgEfftDt);
		
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
		chargeCalculationContainerVO.setCstopIdx(String.valueOf(idxCstop));
		chargeCalculationContainerVO.setCStopNoList(cstopNoList);
		chargeCalculationContainerVO.setMsgCd("0");

		return chargeCalculationContainerVO;
	}	
	
}
