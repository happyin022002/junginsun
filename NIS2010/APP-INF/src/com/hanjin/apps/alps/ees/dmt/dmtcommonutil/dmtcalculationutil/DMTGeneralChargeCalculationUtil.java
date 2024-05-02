/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationUtil.java
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
* 2011.07.25 김경섭 [] [DMT] if(zBrhScNo.length() != 0) >> if(zBrhScNo.length() != 0  && zBrhRfaNo.length() == 0)로 수정
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
* 2013.02.28 임창빈 [CHM-201322954] 
*            [DMT] 신규 장비에 대한 DMT charge 청구를 위한 Table Mapping 요청
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
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ActCustInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.AFTExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BFRExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BkgContainerInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CommodityExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtAFTGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtBFRGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtCmdtGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtSCGrpVO;
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
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * General calculation 함수 <br>
 *
 * @author Choi Sung Hwan
 * @see DMTCalculationDBDAO 클래스 참조
 * @since J2EE 1.6
 */
public class DMTGeneralChargeCalculationUtil {
	
	// Database Access Object
	public transient DMTCalculationDBDAO dbDao = null; 
	protected transient Logger log = null;
	
	DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
	/**
	 * DMTCalculationUtil 객체 생성<br>
	 * DMTCalculationDBDAO 생성한다.<br>
	 */
	public DMTGeneralChargeCalculationUtil() {
		dbDao = new DMTCalculationDBDAO();
		log = Logger.getLogger(getClass().getName());
	}
	
	
	/**
	 *  General Charge Calculation 대한 해당 데이터를 조회한다.
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return ChargeCalculationContainerVO
	 * @exception EventException
	 * @throws DAOException 
	 */
	public ChargeCalculationContainerVO generalChargeCalculation(ChargeCalculationParmVO chargeCalculationParmVO) 
	throws EventException, DAOException{
		
		ChargeCalculationContainerVO chargeCalculationContainerVO = new ChargeCalculationContainerVO();
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

		if( !zDbcIoBnd.equals(zDttCode.substring(2, 3))){
			zDbcIoBnd = zDttCode.substring(2, 3);
			log.debug("[ChargeCalculationParmVO-if]>> zDbcIoBnd 	:"+ zDbcIoBnd);
		}
		//////////////////////  START    변수 정의    /////////////////
		
		String zBlNo			= "";  
		
		String zPorContiCd 		= ""; 
		String zPorCntCd 		= ""; 
		String zPorRgnCd 		= ""; 
		String zPorStateCd 		= ""; 
		
		String zPolContiCd		= "";                                                      
		String zPolCntCd		= "";                                                      
		String zPolRgnCd		= "";                                                      
		String zPolStateCd		= "";                                                      
		
		String zDelContiCd		= "";                                                      
		String zDelCntCd		= "";                                                      
		String zDelRgnCd		= "";                                                      
		String zDelStateCd		= "";                                                      
		
		String zYrdContiCd		= "";                                                      
		String zYrdLoc			= "";                                                      
		String zYrdCntCd		= "";                                                      
		String zYrdRgnCd		= "";                                                      
		String zYrdStateCd		= "";                                                      
		
		String fixPodLoc		= "";                                                                                      
		
		String fixDelContiCd	= "";                                                                      
		String fixDelCntCd		= "";                                                                     
		String fixDelRgnCd		= "";                                                                      
		String fixDelStateCd	= "";                                                                       
		String fixDelLoc		= "";    
		
		String zPorLoc			= "";                                                      
		String zPodLoc			= "";                                                      
		String zPolLoc			= "";                                                      
		String zDelLoc			= "";                                                      
		
		String zPostRly			= "";                                                      
		String zBcntrSpeDg		= "";                                                      
		String zBcntrSpeRf		= "";                                                      
		String zBcntrSpeAk		= "";                                                      
		String zBcntrSpeRd		= "";                                                      
		String zBcntrSpeBb		= "";                                                      
		String zBcntrSocInd		= "";                                                      
		String zBcntrPartial	= "";                                                      
		String zBcntrExcept		= "";                                                      
		String zBbRcvTermCd		= "";
		String zBbDeTermCd 		= "";
		String zOfcCd			= "";                                              
		String zOfcRhq			= ""; 
		String zSalOfc			= "";                                                      
		String zSalRhq			= "";                                                      
		String zBcntrDlvTerm	= "";
		String zBcntrRcvTerm	= "";
		String bkgCntCd			= "";                                                      
		String bkgRgnCd			= "";                                                      
		String bkgStateCd		= "";                                                      
		String bkgLocCd			= "";                                                      
		String zVslCd			= "";                                              
		String zSkdVoyageNo		= "";                                                      
		String zSkdDirCd		= "";                                                      
		String zVpsEtaDt		= "";                                                      
		String dtgEfftDt		= "";                                                      
		String fixDtgEfftDt		= "";                                              
		String zDcsCntrTp		= "";                                                      
		String zDcsCgoTp		= "";                                                      
		long   zDbcBkgQty		= 0;    
		
		long   zDtnSeq			= 0;
		String zDmdtDeTermCd	= "";
		long   zDtgGrpId		= 0;                                             
		String dtgCmncTp		= "";                                                      
		String dtgCmncHr		= "";                                                      
		String dtgExclSat		= "";                                                      
		String dtgExclSun		= "";                                                      
		String dtgExclHoli		= "";                                                      
		String zCurCd			= "";                                              
		long   zDcFtDays		= 0;                                           
		String zDcFtCmnc		= "";                                                      
		String zDcFtEnd			= "";                                                      
		long   zDcFtOver		= 0;                                                                                           
		String zDcStatus		= "";    
		
		long   zDcOrgOver		= 0;                                             
		long   zDcBfrOver		= 0;                                             
		long   zDcAftOver		= 0;  
		
		String zDcApplRate		= "";                                                      
		double zDcOrgAmt		= 0;                                               
		double zDcExpAmt		= 0;                                               
		double zDcDscAmt		= 0;                                               
		double zDcBillAmt		= 0;                                              
		double zDcBfrAmt		= 0;                                              
		double zDcAftAmt		= 0;    
		
		//S/C
		String zBrhScNo			= "";                                                      
		String zBrhRfaNo		= "";                                                      
		                                                               
		String zScNo			= "";
		
		String zPropNo        	= "";
		long   zScVerSeq		= 0;                                             
		long   zScGrpSeq		= 0; 
		
		String dsdFtimeMk		= "";                                                      
		String dsdExclSat		= "";                                                      
		String dsdExclSun		= "";                                                      
		String dsdExclHoli		= "";                                                      
		String dsdFtAddMk		= "";                                                      
		long   dsdFtAddDay		= 0;                                                     
		String dsdFtAdjMk		= "";                                                      
		String dsdRtAdjMk		= "";                                                      
		String dsdCurCd			= "";    
		
		//COMMODITY
		String zCmdtCd			= "";     
		String zCmdtCdC			= "";     
		String zRepCmdtCd		= "";                                                      
		
		String dcrExclSat		= "";                                                      
		String dcrExclSun		= "";                                                      
		String dcrExclHoli		= "";                                                      
		long   zDcrSeq			= 0;                                                
		long   dcrAddDay		= 0;                                                
		long   dcrTtlDay		= 0;                                                
		long   zDcCmdtOver		= 0;                                                        
		double zDcCmdtAmt		= 0;           
		
		//RFA -  BEFORE
		String zApprNo			= ""; 
		String zDarNo			= ""; 
		long   zMapgSeq			= 0;  
		long   zVerSeq			= 0;  
		long   zDtlSeq			= 0;  
		long   zCmbSeq			= 0;
		
		String dbdFtimeMk		= "";                                                      
		long   dbdAddDay		= 0;                                                
		long   dbdTtlDay		= 0;                                               
		String dbdExclSat		= "";                                                      
		String dbdExclSun		= "";                                                      
		String dbdExclHoli		= "";                                                      
		String dbdRateMk		= "";                                                      
		String dbdCurCd			= "";                                                      
	
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
		
		String fixPolLoc		= "";
		String zPreRly			= "";
		
		long   rateDtlCnt 		= 0;
		double getBfrExRate		= 1.0;	
		double getAftExRate		= 1.0;	
		
		long   zDtocFtime		= 0;   
		
		double tmp1				= 0;					
		double tmp2				= 0;
		
		String zFixedVlDt		= "";	
		String zFixedCmnc		= "";	
		
		String zWebMtDate		= "";	
		
		String actCustCntCd  	= "";	
		long   actCustSeq     	= 0;        	                                     
		String awkInOut			= "";    
		
		List<String> cstopNoList = null;
		long	idxCstop		= 0;

		String	tmpTsp			= "";	
		String	zOrgContiCd		= "";
		String	zOrgCntCd		= "";
		String	zOrgRgnCd		= "";
		String	zOrgStateCd		= "";
		String	zOrgLocCd		= "";
		
		String	zClptIndSeq		= "";
		
		//////////////////////END    변수 정의    /////////////////                                                                            
		
		/*
		[logic] From Date Checking
		*/
		if(zDcFmDate.length() == 0){
			chargeCalculationContainerVO.setMsgCd("2");
			chargeCalculationContainerVO.setMsgDesc("From Movement Not Found !");
			//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
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
			log.error("(From Yard)[Exception]>> DEM/DET Office Select Error !  ");
			log.error("*******************************************************");
			throw new EventException("(From Yard)DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		log.debug("*******************************************************");
		log.debug("(From Yard)[DEM/DET Office Setting]>> officeInfoVO.getCollectYn() : "+ officeInfoVO.getCollectYn());
		log.debug("*******************************************************");
		
		if(DMTCalculationUtil.nullToString(officeInfoVO.getCollectYn()).equals("") ){
			log.debug("*******************************************************");
			log.debug("(From Yard)[officeInfoVO is null !  88 DEM/DET Office Skip !");
			log.debug("*******************************************************");
			
			chargeCalculationContainerVO.setMsgCd("88");
			chargeCalculationContainerVO.setMsgDesc("(From Yard)DEM/DET Office Skip ! : ("+zDcFmYdCd+ " ) " );
			
			//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
			return chargeCalculationContainerVO;
		} else {
			
			if(officeInfoVO.getCollectYn().equals("N") && zDttCode.substring(0, 2).equals("DM") ){
				/*
				[logic] Collection Office가 존재하고 Tariff 가 Demurrage 면서 Collection 여부가 "N"이면 Charge Calculation을 Skip한다
					   비록 DMT Yard 이지만, DMT Office에서 Collection 활동을 할 수 없는 지역일 경우 Skip 처리.
				 */
				log.debug("*******************************************************");
				log.debug("(From Yard)[officeInfoVO.getCollectYn() == N zDttCode == DM 88 Not a DEM CLT Office");
				log.debug("*******************************************************");
				
				chargeCalculationContainerVO.setMsgCd("88");
				chargeCalculationContainerVO.setMsgDesc("(From Yard) DEM/DET Collection Mark is No for yard "+officeInfoVO.getOfcCd()+" "+zDcFmYdCd );
				
				//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
				return chargeCalculationContainerVO;
			} else {
				
				//위 조건에 해당하지 않으면 Charge Calculation 시의 Office 와 RHQ 를 Setting 한다.
				zOfcCd = officeInfoVO.getOfcCd();
				zOfcRhq = officeInfoVO.getOfcRhq();
				
				chargeCalculationContainerVO.setOfcCd(zOfcCd);
				chargeCalculationContainerVO.setOfcRhq(zOfcRhq);
				
				log.debug("*******************************************************");
				log.debug("[(From Yard)Office/RHQ]  "+officeInfoVO.getOfcCd()+" "+ officeInfoVO.getOfcRhq()+" "+ zDcFmYdCd);
				log.debug("*******************************************************");
			}
		}
	
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
			//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
			return chargeCalculationContainerVO;
		}
		
		log.debug("*******************************************************");
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcRhq 		: "+ officeInfoVO.getOfcRhq());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcCd 		: "+ officeInfoVO.getOfcCd());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getCollectYn 	: "+ officeInfoVO.getCollectYn());
		log.debug("*******************************************************");
		
		if(zDcToYdCd.length() != 0 && !zDcToCnms.equals("XX")){	
			try {
				officeInfoVO = dbDao.searchOfficeInfoByToYardCd(zDbcIoBnd, zDcToYdCd);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("[Exception]>> DEM/DET Office Select Error !  ");
				log.error("*******************************************************");
				throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
			}
			
			if(officeInfoVO.getCollectYn() == null || officeInfoVO.getCollectYn().equals("N") && zDttCode.substring(0, 2).equals("DM")){
				log.debug("*******************************************************");
				log.debug("officeInfoVO.getCollectYn() == N && zDttCode ==DM 89 Not a DEM CLT Office");
				log.debug("*******************************************************");
				chargeCalculationContainerVO.setMsgCd("89");
				//chargeCalculationContainerVO.setMsgDesc("Not a DEM CLT Office ! (ToYd) : "+officeInfoVO.getOfcCd()+" "+zDcToYdCd);
				chargeCalculationContainerVO.setMsgDesc("Yard: " + zDcToYdCd + " does not have DEM/DET Office! Pls correct yard"); //2010.04.07
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
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("[Invalid BKG No ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			log.error("*******************************************************");
			throw new EventException("[Invalid BKG No ! : " + new ErrorHandler(e).getMessage());
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
		zBcntrDlvTerm	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDeTermCd()); 	// Booking Container Delivery Term Code
		zBcntrRcvTerm	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRcvTermCd()); 	// Booking Container Receive Term Code. 2012.03.19  KHH추가. 
		zPreRly 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPreRlyPortCd(), 5);
		
		zBbRcvTermCd	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getBbRcvTermCd());	// Booking Main Receive Term Code.
		zBbDeTermCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getBbDeTermCd());	// Booking Main Delivery Term Code.
		
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
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("** Bkg Qty Select Error :"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("Bkg Qty Select Error ! : " + new ErrorHandler(e).getMessage());
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
		log.debug("[LocationByBoundVO] bkgCntCd 	: "+ bkgCntCd);
		log.debug("[LocationByBoundVO] bkgRgnCd 	: "+ bkgRgnCd);
		log.debug("[LocationByBoundVO] bkgStateCd 	: "+ bkgStateCd);
		log.debug("[LocationByBoundVO] bkgLocCd 	: "+ bkgLocCd);
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
		log.debug("[fixPodLoc] 	: "+ fixPodLoc);
		log.debug("[tmpTsp] 	: "+ tmpTsp);
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
		log.debug("[fixPolLoc]  : "+ fixPolLoc);
		log.debug("[tmpTsp]     : "+ tmpTsp);
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
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("** Eta Date Select Error - "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("Eta Date Select Error - " + new ErrorHandler(e).getMessage());
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
			chargeCalculationContainerVO.setMsgDesc("* BKG VVD Not Found - BKG NO:"+zBkgNo+", BND:"+zDbcIoBnd+", POL: "+fixPolLoc+", POD:"+fixPodLoc);
			//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
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
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* Fixed DEL Loc Select Error!"+ e.getMessage());
			log.error("*******************************************************");
			throw new EventException("Fixed DEL Loc Select Error! : " + new ErrorHandler(e).getMessage());
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
		log.debug("*[Booking의 DEL Location 결정 :  BKG DEL Loc Fix]");
		log.debug("fixDelContiCd   : "+ fixDelContiCd);
		log.debug("fixDelCntCd     : "+ fixDelCntCd);
		log.debug("fixDelRgnCd 	   : "+ fixDelRgnCd);
		log.debug("fixDelStateCd   : "+ fixDelStateCd);
		log.debug("fixDelLoc       : "+ fixDelLoc);
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
		log.debug("*[Tariff의 Origin 지역 조정]");
		log.debug("zOrgContiCd 	: "+ zOrgContiCd);
		log.debug("zOrgCntCd    : "+ zOrgCntCd);
		log.debug("zOrgRgnCd    : "+ zOrgRgnCd);
		log.debug("zOrgStateCd 	: "+ zOrgStateCd);
		log.debug("zOrgLocCd    : "+ zOrgLocCd);
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
			throw new EventException("*Get the Awkward Cargo in/out-gauge Error! " + new ErrorHandler(e).getMessage());
		}
		
		log.debug("*******************************************************");
		log.debug("[searchInOutGauge]");
		log.debug("awkInOut : "+ awkInOut);
		log.debug("*******************************************************");
		
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* |||||||||||||||||||Get Basic Tariff Values |||||||||||||||||||||| */
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */		
		
		/*
		[logic] Basic Tariff정보 가져오기 : Get Basic Tariff No
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]Basic Tariff정보 가져오기 : Get Basic Tariff No*");
		log.debug("*******************************************************");
		
		basicTariffParmVO.setCvrgYdCd(zDcFmYdCd); //[2009.10.19  YARDCD추가: param:zDcFmYdCd]
		
		if( DMTCalculationUtil.nullToString(zDttCode, 4).substring(2,3).equals("I")){
			zDmdtDeTermCd	= zBcntrDlvTerm;
		} else {
			zDmdtDeTermCd	= zBcntrRcvTerm;
		}
		
		log.debug("*********************************************");
		log.debug("zDmdtDeTermCd 		:"+ zDmdtDeTermCd);
		log.debug("*********************************************");
		
		basicTariffParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
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
		else{
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
			log.debug("zSvrId        :"+ zSvrId);
			log.debug("zDttCode      :"+ zDttCode);
			log.debug("zDtnSeq 	     :"+ zDtnSeq);
			log.debug("zDmdtDeTermCd :"+ zDmdtDeTermCd);
			log.debug("zDtgGrpId     :"+ zDtgGrpId);
			log.debug("dtgCmncTp     :"+dtgCmncTp);
			log.debug("dtgCmncHr     :"+dtgCmncHr);
			log.debug("dtgExclSat    :"+dtgExclSat);
			log.debug("dtgExclSun    :"+dtgExclSun);
			log.debug("dtgExclHoli   :"+dtgExclHoli);
			log.debug("zCurCd        :"+zCurCd);
			log.debug("*********************************************");
		}

		/*		
		[logic] Basic Tariff의 Free days 가져오기 : Get Basic Free Days
		>>>>> zDbcBkgQty -> Booking의 Container 물량
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]  Basic Tariff의 Free days 가져오기*");
		log.debug("*******************************************************");
		 
		try {
			zDcFtDays = dmtCalculationUtil.basicFreeTime(zSvrId, zDttCode, zDtnSeq, zDmdtDeTermCd, zDtgGrpId, zDbcBkgQty);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("** FreeTime Function Error ! "+ e.getMessage() + ", "+ zDttCode+ ", "+ zDtnSeq+ ", "+ zDmdtDeTermCd + ", "+ zDtgGrpId+ ", "+ zDbcBkgQty);
			log.error("*******************************************************");
			throw new EventException("FreeTime Function Error ! " + new ErrorHandler(e).getMessage());
		}
		
		log.debug("*******************************************************");
		log.debug("[basicFreeTime]");
		log.debug("zDcFtDays :"+zDcFtDays);
		log.debug("*******************************************************");		
		
		/*	
		[logic] ID->OC Case Free days 조정 : ID -> OC F/Days Adjust
		ID 이후 OC가 바로 발생한 경우 DTIC의 F/Time과 DTOC의 F/Time Sum을 동시에 DTIC쪽의  할당하려고 하는 의도인 듯 함..(확인 필요. 2013.01.08)
		>>>>> getDTOCFtime
		*/
		
		if(( zDttCode.equals("DTIC") && zDcFmCnms.equals("ID")&&  zDcToCnms.equals("OC") )
		   ||( zDttCode.equals("CTIC") && zDcFmCnms.equals("VD")&&  zDcToCnms.equals("OC"))){
			log.debug("**************************************************************");
			log.debug("* [logic]  ID->OC Case Free days 조정 : ID -> OC F/Days Adjust*");
			log.debug("**************************************************************");
			
			dtocFreeTimeParmVO.setCntrNo(zCntrNo);
			dtocFreeTimeParmVO.setCnmvCycNo(String.valueOf(zCnmvCycNo + 1));
			//dtocFreeTimeParmVO.setEfftDt(dtgEfftDt);
			dtocFreeTimeParmVO.setEfftDt(zDcToDate.substring(0, 8));
			dtocFreeTimeParmVO.setFmYdCd(zDcFmYdCd);
						
			try {
				zDtocFtime = dmtCalculationUtil.getDTOCFtime(dtocFreeTimeParmVO);
				
				if(zDtocFtime < 0){
					chargeCalculationContainerVO.setMsgCd("-1");
					chargeCalculationContainerVO.setMsgDesc("* getDTOCFtime Function Error -" +zDtocFtime);
					//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
					return chargeCalculationContainerVO;
				}
				
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getDTOCFtime Function Error ! "+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("getDTOCFtime Function Error ! " + new ErrorHandler(e).getMessage());
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
			log.debug("* [ T/S Charge BSC Ftime] zDcFtDays 		:"+zDcFtDays);
			log.debug("* [ T/S Charge BSC Ftime] dtgExclSat 	:"+dtgExclSat);
			log.debug("* [ T/S Charge BSC Ftime] dtgExclSun 	:"+dtgExclSun);
			log.debug("* [ T/S Charge BSC Ftime] dtgExclHoli 	:"+dtgExclHoli);
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

			try {
				zFixedCmnc = DMTCalculationUtil.nullToString(dbDao.getFixedCmnc(zVslCd, zSkdVoyageNo, zSkdDirCd, zDcFmYdCd, zDttCode, "fm", zClptIndSeq));
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Fixed CMNC Date Select Error - "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("Fixed CMNC Date Select Error - " + new ErrorHandler(e).getMessage());
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
				zDcFtCmnc 		= DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());					
				idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
				cstopNoList 	= freeTimeStartVO.getCStopNoList();
				
				log.debug("**********************************************************");
				log.debug("* [FreeTimeVO(return) ] zDcFtCmnc 	:["+zDcFtCmnc+"]");
				log.debug("* [FreeTimeVO(return) ] idxCstop 	:["+idxCstop+"]");
				log.debug("* [FreeTimeVO(return) ] cstopNoList 	:["+cstopNoList+"]");
				log.debug("**********************************************************");
				
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* BSC searchFreeTimeStart Function Error : "+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("BSC searchFreeTimeStart Function Error :  " + new ErrorHandler(e).getMessage());
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
		log.debug("* [freeTimeEndParmVO(param) ] ioIdxCstop  :["+idxCstop+"]");
		log.debug("* [freeTimeEndParmVO(param) ] cstopNoList :["+cstopNoList+"]");
		log.debug("****************************************************************");
		
		FreeTimeVO freeTimeEndVO = null;
		
		try {
			freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
			zDcFtEnd  	= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
			idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
			cstopNoList 	= freeTimeEndVO.getCStopNoList();
			
			log.debug("*******************************************************");
			log.debug("* [FreeTimeVO(return) ] zDcFtEnd 	:["+zDcFtEnd+"]");
			log.debug("* [FreeTimeVO(return) ] ioIdxCstop 	:["+idxCstop+"]");
			log.debug("* [FreeTimeVO(return) ] cstopNoList 	:["+cstopNoList+"]");
			log.debug("*******************************************************");
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("BSC searchFreeTimeEnd Function Error -"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("BSC searchFreeTimeEnd Function Error - " + new ErrorHandler(e).getMessage());
		}
		
		/*	
		[logic] VL(To Date) Change
		*/
		if(	( zDttCode.equals("DMOF" ) || zDttCode.equals("CTOC") ) && zDcToCnms.equals("VL")){
			
			log.debug("*******************************************************");
			log.debug("* [logic]  VL(To Date) Change   ");
			log.debug("*******************************************************");
			
			try {
				zFixedVlDt = DMTCalculationUtil.nullToString(dbDao.getFixedCmnc(zVslCd, zSkdVoyageNo, zSkdDirCd, zDcToYdCd, "", "to", zClptIndSeq));
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("Fixed VL Date Select Error -"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("Fixed VL Date Select Error - " + new ErrorHandler(e).getMessage());
			}
		}
	
		if( zFixedVlDt.length() != 0 ){
			zDcToDate = zFixedVlDt;
		}
		log.debug("*******************************************************");
		log.debug("* [VL(To Date) Change ] zFixedVlDt :"+zFixedVlDt);
		log.debug("* [VL(To Date) Change ] zDcToDate  :"+zDcToDate);
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
			throw new EventException("*  Get MT Notification Function Error : " + new ErrorHandler(e).getMessage());
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
		log.debug("* [overdayNStatusParmVO(param) ] idxCstop 		:["+idxCstop+"]");
		log.debug("* [overdayNStatusParmVO(param) ] cstopNoList 	:["+cstopNoList+"]");
		log.debug("*******************************************************************");
		
		OverdayNStatusVO overdayNStatusVO = null;
		try {
			log.debug("*******************************************************************");
			log.debug("* [overdayNStatusParmVO(param) ] idxCstop_1 		:["+idxCstop+"]");
			log.debug("* [overdayNStatusParmVO(param) ] cstopNoList 	:["+cstopNoList+"]");
			log.debug("*******************************************************************");
			overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
			zDcFtOver	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
			zDcOrgOver 	= zDcFtOver;
			zDcStatus 	= DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
			idxCstop 		= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
			cstopNoList 	= overdayNStatusVO.getCStopNoList();
			log.debug("*******************************************************************");
			log.debug("* [overdayNStatusParmVO(param) ] idxCstop_2 		:["+idxCstop+"]");
			log.debug("* [overdayNStatusParmVO(param) ] cstopNoList 	:["+cstopNoList+"]");
			log.debug("*******************************************************************");
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* G.Overday Function Error -"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* G.Overday Function Error - " + new ErrorHandler(e).getMessage());
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
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Charge & Total Function Error -"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Charge & Total Function Error -" + new ErrorHandler(e).getMessage());
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
		
			chargeCalculationContainerVO.setCstopIdx(String.valueOf(idxCstop));
			chargeCalculationContainerVO.setCStopNoList(cstopNoList);
			
			chargeCalculationContainerVO.setMsgCd("0");
			
			return chargeCalculationContainerVO;
		}
	
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
				log.debug("* [dmtCmdtGrpVO]"+dmtCmdtGrpVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* CMDT searchCommodityExceptionByGeneration Functon Error -"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* CMDT searchCommodityExceptionByGeneration Functon Error - " + new ErrorHandler(e).getMessage());
			}
			if( DMTCalculationUtil.stringToLong(dmtCmdtGrpVO.getDcrSeq()) == 0 ){
				zDcCmdtAmt	=	0;
				zDcCmdtOver	=	0;
				zDcrSeq		=	0;
			} else {
				/* Commodity Key */
				zCmdtCdC	= zCmdtCd;
				zDcrSeq 	= DMTCalculationUtil.stringToLong(dmtCmdtGrpVO.getDcrSeq());  
				dcrExclSat 	= DMTCalculationUtil.nullToString(dmtCmdtGrpVO.getExclSat());
				dcrExclSun 	= DMTCalculationUtil.nullToString(dmtCmdtGrpVO.getExclSun());
				dcrExclHoli = DMTCalculationUtil.nullToString(dmtCmdtGrpVO.getExclHoli());
				dcrAddDay 	= DMTCalculationUtil.stringToLong(dmtCmdtGrpVO.getAddDay());
				dcrTtlDay 	= DMTCalculationUtil.stringToLong(dmtCmdtGrpVO.getTtlDay());

				log.debug("*******************************************************");
				log.debug("* [searchCommodityExceptionByGeneration]");
				log.debug("* zCmdtCdC 							:"+zCmdtCdC);
				log.debug("* [DmtCmdtGrpVO(return)] zDcrSeq 	:"+zDcrSeq);
				log.debug("* [DmtCmdtGrpVO(return)] dcrExclSat 	:"+dcrExclSat);
				log.debug("* [DmtCmdtGrpVO(return)] dcrExclSun 	:"+dcrExclSun);
				log.debug("* [DmtCmdtGrpVO(return)] dcrExclHoli :"+dcrExclHoli);
				log.debug("* [DmtCmdtGrpVO(return)] dcrAddDay 	:"+dcrAddDay);
				log.debug("* [DmtCmdtGrpVO(return)] dcrTtlDay 	:"+dcrTtlDay);
				log.debug("*******************************************************");
				
				if( dcrAddDay != 0 ) {
					zDcFtDays += dcrAddDay;
					
					log.debug("[logic] zDcFtDays += dcrAddDay;"+zDcFtDays);
				
					/* Next Day -------- */
					zDcFtEnd = DMTCalculationUtil.nullToString(dbDao.getNextDay(zDcFtEnd));
					
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
					freeTimeEndParmVO.setExclSat(dcrExclSat);
					freeTimeEndParmVO.setExclSun(dcrExclSun);
					freeTimeEndParmVO.setExclHoli(dcrExclHoli);
					
					freeTimeEndParmVO.setFreeTime(String.valueOf(dcrAddDay));
					freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
					freeTimeEndParmVO.setCStopNoList(cstopNoList);
					freeTimeEndParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
					//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
					freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
					freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
					freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
					
	
					freeTimeEndVO = null;
					try {
						freeTimeEndVO 	= dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
						zDcFtEnd   		= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
						idxCstop 	  	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
						cstopNoList 	= freeTimeEndVO.getCStopNoList();
					}catch(Exception e) {
						log.error("*******************************************************");
						log.error("* CMDT searchFreeTimeEnd Function Error:"+e.getMessage());
						log.error("*******************************************************");
						throw new EventException("CMDT searchFreeTimeEnd Function Error:" + new ErrorHandler(e).getMessage());
					}
					log.debug("*******************************************************");
					log.debug("[searchFreeTimeEnd]");
					log.debug("[freeTimeEndVO(return)] zDcFtEnd 	:"+zDcFtEnd);
					log.debug("[freeTimeEndVO(return)] idxCstop 	:"+idxCstop);
					log.debug("[freeTimeEndVO(return)] cstopNoList 	:"+cstopNoList);
					log.debug("*******************************************************");
					
				} 
				else {		// end of the if clause :dcrAddDay != 0
					
					/* Init Clock Stop Ary */
					cstopNoList = new ArrayList<String>();
					idxCstop = 0;
	
					/*
					[logic]   Get CMDT Free Day
					*/
					zDcFtDays = dcrTtlDay;
					zDcFtDays += zDtocFtime;
					log.debug("*******************************************************");
					log.debug("zDtocFtime :"+zDtocFtime);
					log.debug("*******************************************************");
					/*
					[logic]   Get CMDT FreeTime Start
					*/
					if( zFixedCmnc.length() == 0 ){
						
						zDcFtCmnc = "";
						
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
						freeTimeStartParmVO.setExclSat(dcrExclSat);
						freeTimeStartParmVO.setExclSun(dcrExclSun);
						freeTimeStartParmVO.setExclHoli(dcrExclHoli);
						freeTimeStartParmVO.setCmncTp(dtgCmncTp);
						freeTimeStartParmVO.setCmncHr(dtgCmncHr);
						
						freeTimeStartParmVO.setCstopIdx(String.valueOf(idxCstop));
						freeTimeStartParmVO.setCStopNoList(cstopNoList);
						freeTimeStartParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
						//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
						freeTimeStartParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeStartParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeStartParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
					
						log.debug("*******************************************************");
						log.debug("* [freeTimeStartParmVO(param)]idxCstop 		:["+idxCstop+"]");
						log.debug("* [freeTimeStartParmVO(param)]cstopNoList 	:["+cstopNoList+"]");
						log.debug("*******************************************************");	
						FreeTimeVO freeTimeStartVO = null;
						try {
							freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
							zDcFtCmnc 		= DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());
							idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
							cstopNoList 	= freeTimeStartVO.getCStopNoList();
							
							log.debug("*******************************************************");
							log.debug("[searchFreeTimeStart]");
							log.debug("[FreeTimeVO(return)]zDcFtCmnc 	:["+zDcFtCmnc+"]");
							log.debug("[FreeTimeVO(return)]idxCstop 	:["+idxCstop+"]");
							log.debug("[FreeTimeVO(return)]cstopNoList 	:["+cstopNoList+"]");
							log.debug("*******************************************************");		
							
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("CMDT searchFreeTimeStart Function Error -"+ e.getMessage());
							log.error("*******************************************************");
							throw new EventException("CMDT searchFreeTimeStart Function Error - " + new ErrorHandler(e).getMessage());
						}
	
					}						

					log.debug("[logic]  Get CMDT FreeTime Start;"+zDcFtDays);
					
					zDcFtEnd = "";
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
					freeTimeEndParmVO.setExclSat(dcrExclSat);
					freeTimeEndParmVO.setExclSun(dcrExclSun);
					freeTimeEndParmVO.setExclHoli(dcrExclHoli);
					
					freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
					freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
					freeTimeEndParmVO.setCStopNoList(cstopNoList);
					freeTimeEndParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
					//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
					freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
					freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
					freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
					
					log.debug("*******************************************************");
					log.debug("* [freeTimeEndParmVO(param)]idxCstop 	:["+idxCstop+"]");
					log.debug("* [freeTimeEndParmVO(param)]cstopNoList 	:["+cstopNoList+"]");
					log.debug("*******************************************************");	
					freeTimeEndVO = null;
					try {
						freeTimeEndVO 	= dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
						zDcFtEnd   		= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
						idxCstop 	  	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
						cstopNoList 	= freeTimeEndVO.getCStopNoList();
					}catch(Exception e) {
						log.error("*******************************************************");
						log.error("* CMDT searchFreeTimeEnd Function Error -"+e.getMessage());
						log.error("*******************************************************");
						throw new EventException("CMDT searchFreeTimeEnd Function Error -" + new ErrorHandler(e).getMessage());
					}
					log.debug("*******************************************************");
					log.debug("[searchFreeTimeEnd]");
					log.debug("[FreeTimeVO(return)]zDcFtEnd 		:["+zDcFtEnd+"]");
					log.debug("[FreeTimeVO(return)]idxCstop 		:["+idxCstop+"]");
					log.debug("[FreeTimeVO(return)]cstopNoList 	:["+cstopNoList+"]");
					log.debug("*******************************************************");		
				}	
				
				/*
				[logic]   Get CMDT Overday
				*/
				zDcFtOver = 0;
				zDcStatus  = "";	
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
				
				overdayNStatusParmVO.setEndHr(basicTariffKeyVO.getEndHr());
				
				log.debug("*******************************************************");
				log.debug("* [overdayNStatusParmVO(param)]idxCstop 	:["+idxCstop+"]");
				log.debug("* [overdayNStatusParmVO(param)]cstopNoList :["+cstopNoList+"]");
				log.debug("*******************************************************");	
				try {
					overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
					zDcFtOver	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
					zDcCmdtOver	= zDcFtOver;
					zDcStatus 	= DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
					idxCstop 		= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
					cstopNoList 	= overdayNStatusVO.getCStopNoList();
					
					log.debug("*******************************************************");
					log.debug("[overdayNStatus]");
					log.debug("[overdayNStatusVO(return)]zDcStatus 		:["+zDcStatus+"]");
					log.debug("[overdayNStatusVO(return)]zDcCmdtOver 	:["+zDcCmdtOver+"]");
					log.debug("[overdayNStatusVO(return)]idxCstop 		:["+idxCstop+"]");
					log.debug("[overdayNStatusVO(return)]cstopNoList 	:["+cstopNoList+"]");
					log.debug("*******************************************************");
					
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("*  CMDT overdayNStatus Function Error:"+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("*  CMDT overdayNStatus Function Error:" + new ErrorHandler(e).getMessage());
				}
					
				
				/*
				[logic]  Get CMDT Amount
				*/
				rateDtlCnt = 0;
				zDcCmdtAmt = 0;
				
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
						
						calculationAMTVO 	= dmtCalculationUtil.basicCalculation(calculationParmVO);
						
						zDcCmdtAmt 			= DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
						rateDtlCnt  		= DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
					}catch(Exception e) {
						log.error("*******************************************************");
						log.error("*  CMDT basicCalculation Function Error :"+e.getMessage());
						log.error("*******************************************************");
						throw new EventException("CMDT basicCalculation Function Error :" + new ErrorHandler(e).getMessage());
					}
					
				}
				log.debug("*******************************************************");
				log.debug("* [ CMDT Amount Set ] zDcOrgAmt 		:"+zDcOrgAmt);
				log.debug("* [ CMDT Amount Set ] zDcCmdtAmt 	:"+zDcCmdtAmt);
				log.debug("*******************************************************");
				/* CMDT Amount Set */
				zDcCmdtAmt	=	zDcOrgAmt - zDcCmdtAmt ;	
				
				chargeCalculationContainerVO.setCmdtExptAplyDt(dtgEfftDt);
				log.debug("* [ChargeCalculationContainerVO ] setCmdtExptAplyDt 	:"+zDcrSeq);
				
				log.debug("* [ CMDT Amount Set ] zDcCmdtAmt	=	zDcOrgAmt - zDcCmdtAmt :"+zDcCmdtAmt);
				log.debug("*******************************************************");

			}
		} // Commodity Exception End 

		/*  CMDT Amount Fixing  */
		log.debug("***************************************************************************************");
		log.debug("* [ CMDT Amount Fixing ] zDcBillAmt :"+zDcBillAmt);
		log.debug("* [ CMDT Amount Fixing ] zDcCmdtAmt :"+zDcCmdtAmt);
		log.debug("***************************************************************************************");
		zDcBillAmt = zDcBillAmt - zDcCmdtAmt  ;    
		
		log.debug("***************************************************************************************");
		log.debug("* [ CMDT Amount Fixing ] zDcBillAmt = zDcBillAmt - zDcCmdtAmt :"+zDcBillAmt);
		log.debug("***************************************************************************************");
		
		
		/* |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* |||||||||||||||||||||||||||||||||||||| OutBound first 'OCVL' Data Checking */
		/* |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		
		/*
		[logic] OutBound first 'OCVL' Data Checking
		*  SC  :: OutBound 1순위: OC DATE , 2순위:From Mvmt Date 
		*  SC  :: InBound  1순위: OC DATE , 2순위:POL ETA 
		*  RFA :: OutBound 1순위: POL ETA , 2순위:From Mvmt Date 
		*  RFA :: InBound  1순위: VL DATE , 2순위:POL ETA 
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] OutBound first 'OCVL' Data Checking ");
		log.debug("*******************************************************");
		
		VVDNEtaVO polEta = new VVDNEtaVO();
		try {
			polEta 			= dmtCalculationUtil.searchVVDNEta(zBkgNo, fixPolLoc, "", "I/O");	
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("[Exception]>> DEM/DET Office Select Error !  ");
			log.error("*******************************************************");
			throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
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
					log.error("InBound SC getMinOCVLDate Error!  ");
					log.error("*******************************************************");
					throw new EventException("InBound SC getMinOCVLDate Error!   " + new ErrorHandler(e).getMessage());
				}
				//OC Date가 없으면 POL ETA로 :: 2010.03.04
				if(fixDtgEfftDt.length() == 0){
					fixDtgEfftDt = DMTCalculationUtil.nullToString(polEta.getVpsEtaDt());
				} 
				log.debug("*******************************************************");
				log.debug(" [InBound SC CASE]:: "+ fixDtgEfftDt);
				log.debug("*******************************************************");
			} else if( zBrhRfaNo.length() != 0 ){
				//[InBound RFA CASE]
				try {
					fixDtgEfftDt = DMTCalculationUtil.nullToString(dmtCalculationUtil.getMinOCVLDate(zCntrNo, zCnmvCycNo, "VL", "VD"));
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("InBound RFA getMinOCVLDate Error!  ");
					log.error("*******************************************************");
					throw new EventException("InBound RFA getMinOCVLDate Error! " + new ErrorHandler(e).getMessage());
				}
				//VL Date가 없으면 POL ETA로 :: 2010.03.04
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
					log.error("OutBound SC getMinOCVLDate Error!  ");
					log.error("*******************************************************");
					throw new EventException("OutBound SC getMinOCVLDate Error!" + new ErrorHandler(e).getMessage());
				}
				//OC Date가 없으면 From Mvmt Date로 :: 2010.03.04
				if(fixDtgEfftDt.length() == 0){
					fixDtgEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
				} 
				log.debug("*******************************************************");
				log.debug(" [OutBound SC CASE]:: "+ fixDtgEfftDt);
				log.debug("*******************************************************");
			} else if( zBrhRfaNo.length() != 0 ){
				//[OutBound RFA CASE]
				fixDtgEfftDt = DMTCalculationUtil.nullToString(polEta.getVpsEtaDt());
				//POL ETA가 없으면 From Mvmt Date로
				if(fixDtgEfftDt.length() == 0){
					fixDtgEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
				} 
				log.debug("*******************************************************");
				log.debug(" [OutBound RFA CASE]:: "+ fixDtgEfftDt);
				log.debug("*******************************************************");
			}
		}
		
		/*
		[logic] Get USC Exception Values
				1.SC 만 존재 할경우 SC로직만 처리
				2.RFA 만 존재 할경우 RFA로직만 처리
				3.SC/RFA 둘다 존재 할경우 순차적으로 SC를 처리 후 RFA로 처리. 
				  RFA 값이 없을 경우 SC / RFA 값이 존재 할 경우는 RFA 로직이 최종으로 반영됨. 
		*/
		
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* |||||||||||||||||||||||||||||||||||||||||||||||||| Get USC Exception Values */
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		//2011.07.25 if(zBrhScNo.length() != 0) >> if(zBrhScNo.length() != 0  && zBrhRfaNo.length() == 0)로 수정 
		if(zBrhScNo.length() != 0  && zBrhRfaNo.length() == 0 ) { //if(zBrhScNo.length() != 0 && zBrhRfaNo.length() == 0) { 2010.02.12
			
			log.debug("*******************************************************");
			log.debug("* [logic]  Get USC Exception Values 					 ");
			log.debug("*******************************************************");
			
//			Map<String, String> custMap = new HashMap<String, String>();
			List<ActCustInfoVO> custList = null;
			/* cust info : actCustCntCd, actCustSeq -------- */
			actCustCntCd  	= "";	
			actCustSeq     	= 0;   
			try {
				custList 		= dbDao.getCustInfo(zBkgNo);
//				actCustCntCd 	= DMTCalculationUtil.nullToString(custMap.get("act_cust_cnt_cd"));
//				actCustSeq 		= DMTCalculationUtil.stringToLong(custMap.get("act_cust_seq"));
				if (custList!=null && custList.size()>0){
					ActCustInfoVO tmp = custList.get(0);
					if (tmp!=null){
						actCustCntCd 	= DMTCalculationUtil.nullToString(tmp.getActCustCntCd());
						actCustSeq 		= DMTCalculationUtil.stringToLong(tmp.getActCustSeq());
					}
				}
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* SC getCustInfo Functon Error -"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* SC getCustInfo Functon Error - " + new ErrorHandler(e).getMessage());
			}
			
			
			log.debug("*******************************************************");
			log.debug("* [logic]  Get SC Exception No 						 ");
			log.debug("*******************************************************");
			
			scExceptionParmVO.setPorContiCd(zPorContiCd);
			scExceptionParmVO.setPorCntCd(zPorCntCd);
			scExceptionParmVO.setPorRgnCd(zPorRgnCd);
			scExceptionParmVO.setPorSteCd(zPorStateCd);
			scExceptionParmVO.setPorLocCd(zPorLoc);
			
			scExceptionParmVO.setPolContiCd(zPolContiCd);
			scExceptionParmVO.setPolCntCd(zPolCntCd);
			scExceptionParmVO.setPolRgnCd(zPolRgnCd);
			scExceptionParmVO.setPolSteCd(zPolStateCd);
			scExceptionParmVO.setPolLocCd(zPolLoc);
			
			scExceptionParmVO.setYrdContiCd(zYrdContiCd);
			scExceptionParmVO.setYrdCntCd(zYrdCntCd);
			scExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
			scExceptionParmVO.setYrdSteCd(zYrdStateCd);
			scExceptionParmVO.setYrdLocCd(zYrdLoc);

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
			scExceptionParmVO.setEfftDt(fixDtgEfftDt.trim()); //2010.04.05.

			scExceptionParmVO.setCmdtCd(zCmdtCd);
			scExceptionParmVO.setRepCmdtCd(zRepCmdtCd);
			scExceptionParmVO.setCustCntCd(zCustCntCd);
			scExceptionParmVO.setCustCd(zCustCd);
			scExceptionParmVO.setActCustCntCd(actCustCntCd); 				//추가 2009.12.28
			scExceptionParmVO.setActCustSeq(String.valueOf(actCustSeq));	//추가 2009.12.28
			
			scExceptionParmVO.setBbRcvTermCd(zBbRcvTermCd);
			scExceptionParmVO.setBbDeTermCd(zBbDeTermCd);
			
			scExceptionParmVO.setBkgNo(zBkgNo);
			
			DmtSCGrpVO dmtSCGrpVO = null;
			try {
				dmtSCGrpVO = dmtCalculationUtil.searchSCExceptionByGeneration(scExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* searchSCExceptionByGeneration Functon Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchSCExceptionByGeneration Functon Error :" + new ErrorHandler(e).getMessage());
			}
			
			if(DMTCalculationUtil.nullToString(dmtSCGrpVO.getPropNo()).equals("")){
				zDcExpAmt = 0;
				zDcBfrAmt = 0;
				log.debug("[searchSCExceptionByGeneration -> No data found]");
			} else {
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
				log.debug("[searchSCExceptionByGeneration]");
				log.debug("[ USC No (DmtSCGrpVO)] zBrhScNo 		:"+zBrhScNo);
				log.debug("[ USC No (DmtSCGrpVO)] zScVerSeq 	:"+zScVerSeq);
				log.debug("[ USC No (DmtSCGrpVO)] zScGrpSeq 	:"+zScGrpSeq);
				log.debug("*******************************************************");
				log.debug("*******************************************************");
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdFtimeMk 	:"+dsdFtimeMk);
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdExclSat 	:"+dsdExclSat);
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdExclSun 	:"+dsdExclSun);
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdExclHoli :"+dsdExclHoli);
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdFtAddMk 	:"+dsdFtAddMk);
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdFtAddDay :"+dsdFtAddDay);
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdFtAdjMk 	:"+dsdFtAdjMk);
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdRtAdjMk 	:"+dsdRtAdjMk);
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdCurCd 	:"+dsdCurCd);
				log.debug("*******************************************************");
				
				/* SCE Key */
				zScNo = zBrhScNo;
				
				if( dsdFtimeMk.equals("Y")){
					if( dsdFtAddDay != 0 && dsdFtAddMk.equals("Y")){
						zDcFtDays += dsdFtAddDay;

						log.debug("[logic] zDcFtDays += dsdFtAddDay;"+zDcFtDays);						
						
						
						log.debug("*******************************************************");
						log.debug("* [logic]  Get USCE Freetime End Day  ");
						log.debug("*******************************************************");
						/* Next Day -------- */
						zDcFtEnd = DMTCalculationUtil.nullToString(dbDao.getNextDay(zDcFtEnd));
						
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
						freeTimeEndParmVO.setExclSat(dsdExclSat);
						freeTimeEndParmVO.setExclSun(dsdExclSun);
						freeTimeEndParmVO.setExclHoli(dsdExclHoli);
						
						freeTimeEndParmVO.setFreeTime(String.valueOf(dsdFtAddDay));
						freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
						freeTimeEndParmVO.setCStopNoList(cstopNoList);
						freeTimeEndParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가

						//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
						//2012.06.26 
						freeTimeEndParmVO.setExpType("SC");
						
						freeTimeEndVO = null;
						try {
							freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
							zDcFtEnd   = DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
							idxCstop 	  = DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
							cstopNoList = freeTimeEndVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("USC searchFreeTimeEnd Function Error :"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("USC searchFreeTimeEnd Function Error : " + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("[searchFreeTimeEnd]");
						log.debug("[ USC freeTimeEndVO ]zDcFtEnd 	:["+zDcFtEnd+"]");
						log.debug("[ USC freeTimeEndVO ]idxCstop 	:["+idxCstop+"]");
						log.debug("[ USC freeTimeEndVO ]cstopNoList :["+cstopNoList+"]");
						log.debug("*******************************************************");
						
					} 
					else if( dsdFtAddDay != 0  && dsdFtAddMk.equals("N")){
						zDcFtDays = 0;
						zDcFtDays = dsdFtAddDay;
						zDcFtDays = zDcFtDays + zDtocFtime;
						log.debug("[logic] zDcFtDays = dsdFtAddDay;"+zDcFtDays);
						log.debug("*******************************************************");
						log.debug("zDtocFtime :"+zDtocFtime);
						log.debug("*******************************************************");

						log.debug("*******************************************************");
						log.debug("* [logic]  Get USCE Freetime End Day  ");
						log.debug("*******************************************************");
						/* Init Clock Stop Ary */
						cstopNoList = new ArrayList<String>();
						idxCstop = 0;

						log.debug("[logic] zDcFtDays = dsdFtAddDay"+zDcFtDays);
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
							freeTimeStartParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
							
							//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
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
								throw new EventException("USCE searchFreeTimeStart Function Error -" + new ErrorHandler(e).getMessage());
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
						log.debug("[logic] Get USCE FreeTime End"+zDcFtDays);
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
				      	freeTimeEndParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
						//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
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
					} //if( dsdFtAddDay != 0  && dsdFtAddMk.equals("N")){
					else if (dsdFtAdjMk.equals("Y")){		/* if( dsdFtAdjMk  == 'Y' ) */ 
						
						/* Init Clock Stop Ary */
						cstopNoList = new ArrayList<String>();
						idxCstop = 0;

						/*
						[logic] Get USCE Free Day
						*/
						zDcFtDays = 0;

						try {
							zDcFtDays = dmtCalculationUtil.getSCEFreeTime(zPropNo, zScVerSeq, zScGrpSeq, zDbcBkgQty);
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("* USCE  getSCEFreeTime Function Error :"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("USCE  getSCEFreeTime Function Error :" + new ErrorHandler(e).getMessage());
						}

						zDcFtDays = zDcFtDays + zDtocFtime;
						log.debug("*******************************************************");
						log.debug("* [ USC Freetime ] zDcFtDays :"+zDcFtDays);
						log.debug("*******************************************************");
						log.debug("*******************************************************");
						log.debug("zDtocFtime :"+zDtocFtime);
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
							freeTimeStartParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
							//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
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
								log.error("* USCE searchFreeTimeStart Function Error -"+ e.getMessage());
								log.error("*******************************************************");
								throw new EventException("USCE searchFreeTimeStart Function Error -" + new ErrorHandler(e).getMessage());
							}
							log.debug("*******************************************************");
							log.debug("[searchFreeTimeStart]");
							log.debug("[ USC (FreeTimeVO) ]zDcFtCmnc 	:"+zDcFtCmnc);
							log.debug("[ USC (FreeTimeVO) ] zFixedCmnc 	:"+zFixedCmnc);
							log.debug("[ USC (FreeTimeVO) ] idxCstop 	:"+idxCstop);
							log.debug("[ USC (FreeTimeVO) ] cstopNoList :"+cstopNoList);
							log.debug("*******************************************************");						
						}

						/*
						[logic] Get USCE FreeTime End
						*/
						log.debug("[logic] Get USCE FreeTime End"+zDcFtDays);
						
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
						freeTimeEndParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
						//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
						
						//2012.06.26 
						freeTimeEndParmVO.setExpType("SC");
						
						freeTimeEndVO = null;
						try {
							freeTimeEndVO 	= dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
							zDcFtEnd   		= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
							idxCstop 	  	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
							cstopNoList 	= freeTimeEndVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("* USCE searchFreeTimeEnd Function Error -"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("USCE searchFreeTimeEnd Function Error -" + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("[searchFreeTimeEnd]");
						log.debug("[ USC (freeTimeEndVO) ]zDcFtEnd 		:"+zDcFtEnd);
						log.debug("[ USC (freeTimeEndVO) ] idxCstop 	:"+idxCstop);
						log.debug("[ USC (freeTimeEndVO) ] cstopNoList 	:"+cstopNoList);
						log.debug("*******************************************************");
					}
					
				} // if( dsdFtimeMk.equals("Y")){
				
				
				/*
				[logic] Get USCE Overday End
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
				
				overdayNStatusParmVO.setEndHr(basicTariffKeyVO.getEndHr());

				try {
					overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
					zDcFtOver  		= DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
					zDcBfrOver 		= zDcFtOver;
					zDcStatus   	= DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
					idxCstop 	  	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
					cstopNoList 	= overdayNStatusVO.getCStopNoList();
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("*  USCE overdayNStatus Function Error:"+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("USCE overdayNStatus Function Error:" + new ErrorHandler(e).getMessage());
				}
				log.debug("*******************************************************");
				log.debug("[overdayNStatus]");
				log.debug("[ USC (overdayNStatus) ]zDcBfrOver 	:"+zDcBfrOver);
				log.debug("[ USC (overdayNStatus) ]zDcStatus 		:"+zDcStatus);
				log.debug("[ USC (overdayNStatus) ]idxCstop 		:"+idxCstop);
				log.debug("[ USC (overdayNStatus) ]cstopNoList 	:"+cstopNoList);
				log.debug("*******************************************************");
				
				/*
				[logic] Get USCE Amount
				*/
				rateDtlCnt = 0;

				zDcExpAmt = 0;
				zDcBfrAmt = 0;

				if( zDcStatus.equals("L") || zDcStatus.equals("F") ){
					if( dsdRtAdjMk.equals("Y")){
						zDcApplRate = "S"; 	/* Applied Rate Set */
				
						calculationParmVO.setPropNo(zScNo);//zScNo zPropNo
						calculationParmVO.setVerSeq(String.valueOf(zScVerSeq));
						calculationParmVO.setGrpSeq(String.valueOf(zScGrpSeq));
						
						calculationParmVO.setCntrts(zCntrtsCd);
						calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
						calculationParmVO.setDivOverDay("0");
						
						calculationParmVO.setFtDys(String.valueOf(zDcFtDays));				// 2014.03.12
						calculationParmVO.setFmMvmtYdCd(zDcFmYdCd);							// 2014.03.12
						calculationParmVO.setTrfAplyDt(fixDtgEfftDt);						// 2014.03.12
						
						CalculationAMTVO calcSCAMTVO = null;
						
						try {
							calculationParmVO.setDmdtTrfAplyTpCd("S");						// 2014.03.12
							calculationParmVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));	// 2014.03.12
							
							calcSCAMTVO = dmtCalculationUtil.scCalculation(calculationParmVO);
							
							rateDtlCnt 	= DMTCalculationUtil.stringToLong(calcSCAMTVO.getDtlCnt());
							zDcBfrAmt 	= Double.parseDouble(calcSCAMTVO.getTotal());
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  USCE Amount - scCalculation Function Error :"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException(" USCE Amount - scCalculation Function Error :" + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("[scCalculation]");
						log.debug("[ USC (scCalculation) ]zDcBfrAmt 	:"+zDcBfrAmt);
						log.debug("[ USC (scCalculation) ]rateDtlCnt 	:"+rateDtlCnt);
						log.debug("[ USC (scCalculation) ]idxCstop 		:"+idxCstop);
						log.debug("*******************************************************");
						
						if( !zCurCd.equals(dsdCurCd) ){
							/*
							[logic] Basic Tariff Currency, SC Exception Currency
							*/
							exchangeRateParmVO.setPolLoc(fixPolLoc);
							exchangeRateParmVO.setPodLoc(fixPodLoc);
							exchangeRateParmVO.setIoBnd(zDbcIoBnd);
							exchangeRateParmVO.setVslCd(zVslCd);
							exchangeRateParmVO.setSkdVoyageNo(zSkdVoyageNo);
							exchangeRateParmVO.setSkdDirCd(zSkdDirCd);
							exchangeRateParmVO.setFmCurCd(dsdCurCd);
							exchangeRateParmVO.setToCurCd(zCurCd);
							exchangeRateParmVO.setOfcCd(zOfcCd);
							try 
							{
								getBfrExRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("* USCE Amount searchExchangeRate Function Error :"+e.getMessage());
								log.error("*******************************************************");
								throw new EventException("* USCE Amount searchExchangeRate Function Error : " + new ErrorHandler(e).getMessage());
							}
								
								log.debug("*******************************************************");
								log.debug("[searchExchangeRate]");
								log.debug(" USC getBfrExRate 	:"+getBfrExRate);
								log.debug(" USC zDcBfrAmt 		:"+zDcBfrAmt);
								log.debug("*******************************************************");
								
								zDcBfrAmt = zDcBfrAmt * getBfrExRate;
								
								log.debug("*******************************************************");
								log.debug(" USC zDcBfrAmt = zDcBfrAmt * getBfrExRate :"+zDcBfrAmt);
								log.debug("*******************************************************");
//							}
						}
					} 
					else {		//dsdRtAdjMk != "Y" 
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
						calculationParmVO.setTrfAplyDt(fixDtgEfftDt);							// 2014.03.12
						
						CalculationAMTVO calculationAMTVO = null;
						
						try {
							calculationParmVO.setDmdtTrfAplyTpCd("S");						// 2014.03.12
							calculationParmVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));	// 2014.03.12
							
							calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
							zDcBfrAmt 		= DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
							
							rateDtlCnt 		= DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("*  USCE Amount - basicCalculation Function Error :"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("USCE Amount - basicCalculation Function Error : " + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("[basicCalculation]");
						log.debug("[USC (CalculationAMTVO)] zDcBfrAmt :"+zDcBfrAmt);
						log.debug("*******************************************************");
					}
				}
				 /* Exp Amount Set */
				log.debug("***************************************************************************************");
				log.debug("* [ SCE Exp Amount Set ] zDcBillAmt 	:"+zDcBillAmt);
				log.debug("* [ SCE Exp Amount Set ] zDcBfrAmt 	:"+zDcBfrAmt);
				log.debug("***************************************************************************************");
				
				zDcExpAmt	=	zDcBillAmt - zDcBfrAmt;		
				
				chargeCalculationContainerVO.setScRfaExptAplyDt(fixDtgEfftDt);
				log.debug("* [ChargeCalculationContainerVO ] setScRfaExptAplyDt :"+fixDtgEfftDt);
				
				log.debug("***************************************************************************************");
				log.debug("* [ SCE Exp Amount Set ] zDcExpAmt	=	zDcBillAmt - zDcBfrAmt :"+zDcExpAmt);
				log.debug("***************************************************************************************");

			}
		 }  /*_________ SC Exception End	*/
		
		
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* |||||||||||||||||||||||||||||||||||||||||||||||||||| Get BFR Exception Values */
		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		
		/*
		[logic] Get BFR Exception Values
		*/
		if(  zBrhRfaNo.length() != 0 ){  //zBrhRfaNo.length() != 0 ){ { 2010.02.12
			log.debug("*******************************************************");
			log.debug("* [logic]  Get BFR Exception Values ");
			log.debug("*******************************************************");
			
//			Map<String, String> custMap = new HashMap<String, String>();
			List<ActCustInfoVO> custList = null;
			/* cust info : actCustCntCd, actCustSeq -------- */
			actCustCntCd  	= "";	
			actCustSeq     	= 0;   
			try {
				custList 		= dbDao.getCustInfo(zBkgNo);
//				actCustCntCd 	= DMTCalculationUtil.nullToString(custMap.get("act_cust_cnt_cd"));
//				actCustSeq 		= DMTCalculationUtil.stringToLong(custMap.get("act_cust_seq"));
				if (custList!=null && custList.size()>0){
					ActCustInfoVO tmp = custList.get(0);
					if (tmp!=null){
						actCustCntCd 	= DMTCalculationUtil.nullToString(tmp.getActCustCntCd());
						actCustSeq 		= DMTCalculationUtil.stringToLong(tmp.getActCustSeq());
					}
				}
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* BFR getCustInfo Functon Error -"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("BFR getCustInfo Functon Error - " + new ErrorHandler(e).getMessage());
			}
			
			bfrExceptionParmVO.setPorContiCd(zPorContiCd);
			bfrExceptionParmVO.setPorCntCd(zPorCntCd);
			bfrExceptionParmVO.setPorRgnCd(zPorRgnCd);
			bfrExceptionParmVO.setPorSteCd(zPorStateCd);
			bfrExceptionParmVO.setPorLocCd(zPorLoc);
			
			bfrExceptionParmVO.setPolContiCd(zPolContiCd);                    
			bfrExceptionParmVO.setPolCntCd(zPolCntCd);                
			bfrExceptionParmVO.setPolRgnCd(zPolRgnCd);  
			bfrExceptionParmVO.setPolSteCd(zPolStateCd);
			bfrExceptionParmVO.setPolLocCd(zPolLoc);      

			bfrExceptionParmVO.setYrdContiCd(zYrdContiCd);
			bfrExceptionParmVO.setYrdCntCd(zYrdCntCd);
			bfrExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
			bfrExceptionParmVO.setYrdSteCd(zYrdStateCd);
			bfrExceptionParmVO.setYrdLocCd(zYrdLoc);

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
			bfrExceptionParmVO.setEfftDt(fixDtgEfftDt.trim()); //2010.04.05.         
			bfrExceptionParmVO.setActCustCntCd(actCustCntCd); 
			bfrExceptionParmVO.setActCustSeq(String.valueOf(actCustSeq));
			bfrExceptionParmVO.setAwkInOut(awkInOut);
			
			DmtBFRGrpVO dmtBFRGrpVO = null;
			try {
				dmtBFRGrpVO = dmtCalculationUtil.searchBFRExceptionByGeneration(bfrExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("BFR searchBFRExceptionByGeneration Function Error :  ");
				log.error("*******************************************************");
				throw new EventException("BFR searchBFRExceptionByGeneration Function Error : " + new ErrorHandler(e).getMessage());
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
				
				log.debug("*******************************************************");
				log.debug("[searchBFRExceptionByGeneration]");
				log.debug("* BFR Req No (DmtBFRGrpVO)] zApprNo 	:"+zApprNo);
				log.debug("* BFR Req No (DmtBFRGrpVO)] zDarNo 	:"+zDarNo);
				log.debug("* BFR Req No (DmtBFRGrpVO)] zMapgSeq :"+zMapgSeq);
				log.debug("* BFR Req No (DmtBFRGrpVO)] zVerSeq 	:"+zVerSeq);
				log.debug("* BFR Req No (DmtBFRGrpVO)] zDtlSeq 	:"+zDtlSeq);
				log.debug("* BFR Req No (DmtBFRGrpVO)] zCmbSeq 	:"+zCmbSeq);
				log.debug("*******************************************************");
				log.debug("*******************************************************");
				log.debug("* BFR EXP (DmtBFRGrpVO)] dbdFtimeMk 	:"+dbdFtimeMk);
				log.debug("* BFR EXP (DmtBFRGrpVO)] dbdAddDay 	:"+dbdAddDay);
				log.debug("* BFR EXP (DmtBFRGrpVO)] dbdTtlDay 	:"+dbdTtlDay);
				log.debug("* BFR EXP (DmtBFRGrpVO)] dbdExclSat 	:"+dbdExclSat);
				log.debug("* BFR EXP (DmtBFRGrpVO)] dbdExclSun 	:"+dbdExclSun);
				log.debug("* BFR EXP (DmtBFRGrpVO)] dbdExclHoli :"+dbdExclHoli);
				log.debug("* BFR EXP (DmtBFRGrpVO)] dbdRateMk 	:"+dbdRateMk);
				log.debug("* BFR EXP (DmtBFRGrpVO)] dbdCurCd 	:"+dbdCurCd);
				log.debug("*******************************************************");
				
				if( dbdFtimeMk.equals("Y") ){
					if( dbdAddDay != 0 ){
						zDcFtDays += dbdAddDay;

						log.debug("[logic] zDcFtDays += dbdAddDay;"+zDcFtDays);
						
						/*
						[logic] Get Before FreeTime End
						*/
						try {
							zDcFtEnd = dbDao.getNextDay(zDcFtEnd);
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("* BFR getNextDay Function Error ::"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("BFR getNextDay Function Error ::" + new ErrorHandler(e).getMessage());
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
						freeTimeEndParmVO.setExclSat(dbdExclSat);
						freeTimeEndParmVO.setExclSun(dbdExclSun);
						freeTimeEndParmVO.setExclHoli(dbdExclHoli);
						
						freeTimeEndParmVO.setFreeTime(String.valueOf(dbdAddDay));
						freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
						freeTimeEndParmVO.setCStopNoList(cstopNoList);
						freeTimeEndParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
						//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);

						freeTimeEndVO = null;
						try {
							freeTimeEndVO 	= dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
							zDcFtEnd   		= freeTimeEndVO.getFtimeEnd();
							idxCstop 	  	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
							cstopNoList 	= freeTimeEndVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("BFR searchFreeTimeEnd Function Error :: "+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("BFR searchFreeTimeEnd Function Error :: " + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("[ BFR searchFreeTimeEnd]");
						log.debug("[ BFR freeTimeEndVO ] zDcFtEnd 		:"+zDcFtEnd);
						log.debug("[ BFR freeTimeEndVO ] idxCstop 		:"+idxCstop);
						log.debug("[ BFR freeTimeEndVO ] cstopNoList 	:"+cstopNoList);
						log.debug("*******************************************************");
						
					} 
					else { 		/* if( dbdTtlDay != 0 ) */
					
						/* Init Clock Stop Ary */
						cstopNoList = new ArrayList<String>();
						idxCstop = 0;
						
						zDcFtDays = dbdTtlDay;
						zDcFtDays = zDcFtDays + zDtocFtime;
						log.debug("[logic] zDcFtDays = dbdTtlDay"+zDcFtDays);
						log.debug("*******************************************************");
						log.debug("zDtocFtime :"+zDtocFtime);
						log.debug("*******************************************************");

						/*
						[logic] Get Before FreeTime Start
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
							freeTimeStartParmVO.setExclSat(dbdExclSat);
							freeTimeStartParmVO.setExclSun(dbdExclSun);
							freeTimeStartParmVO.setExclHoli(dbdExclHoli);
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
								zDcFtCmnc 		= DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());
								idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
								cstopNoList 	= freeTimeStartVO.getCStopNoList();
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("* BFR searchFreeTimeStart:"+ e.getMessage());
								log.error("*******************************************************");
								throw new EventException("BFR searchFreeTimeStart: " + new ErrorHandler(e).getMessage());
							}
							log.debug("*******************************************************");
							log.debug("[ BFR searchFreeTimeStart]");
							log.debug("[ BFR freeTimeStartVO ] zDcFtCmnc 	:"+zDcFtCmnc);
							log.debug("[ BFR freeTimeStartVO ] zFixedCmnc 	:"+zFixedCmnc);
							log.debug("[ BFR freeTimeStartVO ] idxCstop 	:"+idxCstop);
							log.debug("[ BFR freeTimeStartVO ] cstopNoList 	:"+cstopNoList);
							log.debug("*******************************************************");	
						}	
						
						
						/*
						[logic] Get Before FreeTime End
						*/
						log.debug("[logic] Get Before FreeTime End"+zDcFtDays);
						
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
						freeTimeEndParmVO.setExclSat(dbdExclSat);
						freeTimeEndParmVO.setExclSun(dbdExclSun);
						freeTimeEndParmVO.setExclHoli(dbdExclHoli);
						
						freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
						freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
						freeTimeEndParmVO.setCStopNoList(cstopNoList);
						freeTimeEndParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
						//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
					
						freeTimeEndVO = null;
						try {
							freeTimeEndVO 	= dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
							zDcFtEnd   		= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
							idxCstop 	  	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
							cstopNoList 	= freeTimeEndVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("* BFR FreeTime End Function Error ::"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("BFR FreeTime End Function Error :: " + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("[ BFR searchFreeTimeEnd]");
						log.debug("[ BFR freeTimeEndVO ] zDcFtEnd 	:"+zDcFtEnd);
						log.debug("[ BFR freeTimeEndVO ] idxCstop 		:"+idxCstop);
						log.debug("[ BFR freeTimeEndVO ] cstopNoList 	:"+cstopNoList);
						log.debug("*******************************************************");	
						
					}
				} /* if(dbdFtimeMk == "Y" ) */
				
				/*
				[logic] Get Before FreeTime Overday 
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
				
				overdayNStatusParmVO.setEndHr(basicTariffKeyVO.getEndHr());
				
				try {
					overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
					zDcFtOver  		= DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
					zDcBfrOver 		= zDcFtOver;
					zDcStatus   	= DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
					idxCstop 	  	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
					cstopNoList 	= overdayNStatusVO.getCStopNoList();
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("* BFR overdayNStatus Function Error ::"+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("BFR overdayNStatus Function Error :: " + new ErrorHandler(e).getMessage());
				}
				log.debug("*******************************************************");
				log.debug("[ BFR overdayNStatus ]");
				log.debug("[ BFR overdayNStatusVO ] zDcStatus 	:"+zDcStatus);
				log.debug("[ BFR overdayNStatusVO ] zDcBfrOver 	:"+zDcBfrOver);
				log.debug("[ BFR overdayNStatusVO ] idxCstop 	:"+idxCstop);
				log.debug("[ BFR overdayNStatusVO ] cstopNoList :"+cstopNoList);
				log.debug("*******************************************************");
				
				/*
				[logic] Get Before FreeTime Amount 
				*/
				
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
						calculationParmVO.setFtDys(String.valueOf(zDcFtDays));				// 2014.03.12
						calculationParmVO.setFmMvmtYdCd(zDcFmYdCd);							// 2014.03.12
						calculationParmVO.setTrfAplyDt(bfrExceptionParmVO.getEfftDt());		// 2014.03.12
						
						CalculationAMTVO calcBeforeAMTVO = null;
						
						try {
							calculationParmVO.setDmdtTrfAplyTpCd("B");						// 2014.03.12
							calculationParmVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));	// 2014.03.12
							
							calcBeforeAMTVO = dmtCalculationUtil.beforeCalculation(calculationParmVO);
							
							rateDtlCnt = DMTCalculationUtil.stringToLong(calcBeforeAMTVO.getDtlCnt());
							zDcBfrAmt = Double.parseDouble(calcBeforeAMTVO.getTotal());
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("BFR beforeCalculation Function Error ::  ");
							log.error("*******************************************************");
							throw new EventException("BFR beforeCalculation Function Error :: " + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("[ BFR beforeCalculation ]");
						log.debug("[ BFR CalculationAMTVO ] zDcBfrAmt 	:"+zDcBfrAmt);
						log.debug("[ BFR CalculationAMTVO ] rateDtlCnt 	:"+rateDtlCnt);
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
								log.error("BFR searchExchangeRate Function Error ::"+e.getMessage());
								log.error("*******************************************************");
								throw new EventException("BFR searchExchangeRate Function Error ::" + new ErrorHandler(e).getMessage());
							}
							
							log.debug("*******************************************************");
							log.debug("[ BFR searchExchangeRate]");
							log.debug("[ BFR getBfrExRate :"+getBfrExRate);
							log.debug("*******************************************************");
							
							zDcBfrAmt = zDcBfrAmt * getBfrExRate;
							
							log.debug("*******************************************************");
							log.debug("[ BFR zDcBfrAmt = zDcBfrAmt * getBfrExRate :"+zDcBfrAmt);
							log.debug("*******************************************************");
						}
					} 
					else {	/*_ dbdRateMk <>  "Y" */
					
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
						calculationParmVO.setTrfAplyDt(fixDtgEfftDt);							// 2014.03.12
						
						CalculationAMTVO calculationAMTVO = null;
						
						try {
							calculationParmVO.setDmdtTrfAplyTpCd("B");						// 2014.03.12
							calculationParmVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));	// 2014.03.12
							
							calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
							
							zDcBfrAmt = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
							rateDtlCnt = DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("* BFR basicCalculation Function Error ::"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("BFR basicCalculation Function Error ::" + new ErrorHandler(e).getMessage());
						}
						log.debug("*******************************************************");
						log.debug("[ BFR basicCalculation]");
						log.debug("[ BFR CalculationAMTVO ] zDcBfrAmt :"+zDcBfrAmt);
						log.debug("[ BFR CalculationAMTVO ] rateDtlCnt :"+rateDtlCnt);
						log.debug("*******************************************************");
					}
				}
				
				/* Exp Amount Set */
				log.debug("***************************************************************************************");
				log.debug("* [ BFR Exp Amount Set ] zDcBillAmt 	:"+zDcBillAmt);
				log.debug("* [ BFR Exp Amount Set ] zDcBfrAmt 	:"+zDcBfrAmt);
				log.debug("***************************************************************************************");
				
				zDcExpAmt = zDcBillAmt - zDcBfrAmt;	
				
				chargeCalculationContainerVO.setScRfaExptAplyDt(fixDtgEfftDt);
				log.debug("* [ChargeCalculationContainerVO ] setScRfaExptAplyDt :"+fixDtgEfftDt);
				log.debug("***************************************************************************************");
				log.debug("* [ BFR Exp Amount Set ] zDcExpAmt = zDcBillAmt - zDcBfrAmt :"+zDcExpAmt);
				log.debug("***************************************************************************************");

			} 
		}  /*_________ RFA(BFR) Exception End	*/

		
		/* 	EXP Amount Fixing	*/
		log.debug("***************************************************************************************");
		log.debug("* [ EXP Amount Fixing ] zDcBillAmt 	:"+zDcBillAmt);
		log.debug("* [ EXP Amount Fixing ] zDcExpAmt 	:"+zDcExpAmt);
		log.debug("***************************************************************************************");
		
		zDcBillAmt = zDcBillAmt - zDcExpAmt  ;							
			
		log.debug("***************************************************************************************");
		log.debug("* [ EXP Amount Fixing ] zDcBillAmt - zDcExpAmt = zDcBillAmt :"+zDcExpAmt);
		log.debug("***************************************************************************************");
			
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
				if(( dadFtimeMk.equals("Y") && (dadAddDay > 0 || dadTtlDay > 0 ) && zDcBillAmt == 0 && !("Y").equals(DcFlg) )
				    ||
				    (!dadFtimeMk.equals("Y") && zDcBillAmt == 0 && !("Y").equals(DcFlg) )){
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
					
					if( dadFtimeMk.equals("Y") ){
						if( dadAddDay != 0 ){
							zDcFtDays += dadAddDay;

							log.debug("[[logic] zDcFtDays += dadAddDay"+zDcFtDays);
							
							/*
							[logic] Get After FreeTime End
							*/
							try {
								zDcFtEnd = dbDao.getNextDay(zDcFtEnd);
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("*  AFT getNextDay End Error ::"+e.getMessage()+", zDcFtEnd: :"+zDcFtEnd);
								log.error("*******************************************************");
								throw new EventException("AFT getNextDay End Error :: " + new ErrorHandler(e).getMessage());
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
							
							freeTimeEndParmVO.setFreeTime(String.valueOf(dadAddDay));
							freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
							freeTimeEndParmVO.setCStopNoList(cstopNoList);
							freeTimeEndParmVO.setYardCd(zDcFmYdCd);	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
							//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
							freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
							freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
							freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);

							
							freeTimeEndVO = null;
							try {
								freeTimeEndVO 	= dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
								zDcFtEnd   		= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
								idxCstop 	  	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
								cstopNoList 	= freeTimeEndVO.getCStopNoList();
							}catch(Exception e) {
								log.error("*******************************************************");
								log.error("[Exception]>> DEM/DET Office Select Error !  ");
								log.error("*******************************************************");
								throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
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
							
							log.debug("[[logic] zDcFtDays = dadTtlDay]"+zDcFtDays);

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
										log.error("[Exception]>> DEM/DET Office Select Error !  ");
										log.error("*******************************************************");
										throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
									}
							// 품질결함에 의해서 Exception에 return을 throw로 변경함.		
//									} catch (DAOException e) {
//										chargeCalculationContainerVO.setMsgCd("-1");
//										chargeCalculationContainerVO.setMsgDesc("* AFT searchFreeTimeStart Function Error -"+ e.getMessage());
//										//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
//										return chargeCalculationContainerVO;
//									}
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
								
								log.debug("[[logic] Get After FreeTime End:]"+zDcFtDays);
						
								
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
								
								freeTimeEndVO = null;
								try {
									freeTimeEndVO 	= dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
									zDcFtEnd   		= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
									idxCstop 	  	= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
									cstopNoList 	= freeTimeEndVO.getCStopNoList();
								}catch(Exception e) {
									log.error("*******************************************************");
									log.error("* AFT searchFreeTimeEnd Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException("AFT searchFreeTimeEnd Function Error ::" + new ErrorHandler(e).getMessage());
								}
						// 품질결함에 의해서 Exception에 return을 throw로 변경함.		
//								} catch (DAOException e) {
//									chargeCalculationContainerVO.setMsgCd("-1");
//									chargeCalculationContainerVO.setMsgDesc("* AFT searchFreeTimeEnd Function Error ::"+e.getMessage());
//									//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
//									return chargeCalculationContainerVO;
//								}
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
						
						overdayNStatusParmVO.setEndHr(basicTariffKeyVO.getEndHr());
						
						log.debug("*555free end [overdayNStatusParmVO ] prmExclHoli 		:"+dadExclHoli);
						
						try {
							overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
							zDcFtOver  		= DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
							zDcAftOver 		= zDcFtOver;
							zDcStatus   	= DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
							idxCstop 	  	= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
							cstopNoList 	= overdayNStatusVO.getCStopNoList();
						}catch(Exception e) {
							log.error("*******************************************************");
							log.error("AFT overdayNStatus Function Error ::"+e.getMessage());
							log.error("*******************************************************");
							throw new EventException("AFT overdayNStatus Function Error :: " + new ErrorHandler(e).getMessage());
						}
							
						log.debug("*******************************************************");
						log.debug("[ AFT overdayNStatus ]");
						log.debug("[ AFT overdayNStatus ] zDcStatus 	:"+zDcStatus);
						log.debug("[ AFT overdayNStatus ] zDcAftOver 	:"+zDcAftOver);
						log.debug("[ AFT overdayNStatus ] idxCstop 		:"+idxCstop);
						log.debug("[ AFT overdayNStatus ] cstopNoList 	:"+cstopNoList);
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
								calculationParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
								calculationParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
								
								calculationParmVO.setCntrts(zCntrtsCd);
								calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
								calculationParmVO.setDivOverDay("0");
								
								CalculationAMTVO calculationAMTVO = null;
								
								try {
									calculationParmVO.setDmdtTrfAplyTpCd("G");
									calculationParmVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));	// Basic Over Days
									
									calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
									
									zDcAftAmt 		= DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
									rateDtlCnt 		= DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
								}catch(Exception e) {
									log.error("*******************************************************");
									log.error("* AFT  basicCalculation Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException("AFT  basicCalculation Function Error ::" + new ErrorHandler(e).getMessage());
								}
							} 
							else if(zDcApplRate.equals("B") ){   // Before BKG Exception	
							
								calculationParmVO.setDarNo(zDarNo);
								calculationParmVO.setMapgSeq(String.valueOf(zMapgSeq));
								calculationParmVO.setVerSeq(String.valueOf(zVerSeq));
								calculationParmVO.setDtlSeq(String.valueOf(zDtlSeq));
								calculationParmVO.setCmbSeq(String.valueOf(zCmbSeq));
								
								calculationParmVO.setCntrts(zCntrtsCd);
								calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
								calculationParmVO.setDivOverDay("0");	
								
								calculationParmVO.setFtDys(String.valueOf(zDcFtDays));				// 2014.03.12
								calculationParmVO.setFmMvmtYdCd(zDcFmYdCd);							// 2014.03.12
								calculationParmVO.setTrfAplyDt(fixDtgEfftDt);						// 2014.03.12
								
								CalculationAMTVO calcBeforeAMTVO = null;
								
								try {
									calculationParmVO.setDmdtTrfAplyTpCd("B");						// 2014.03.12
									calculationParmVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));	// 2014.03.12
									
									calcBeforeAMTVO = dmtCalculationUtil.beforeCalculation(calculationParmVO);
									
									zDcAftAmt 		= DMTCalculationUtil.stringToDouble(calcBeforeAMTVO.getTotal());
									rateDtlCnt 		= DMTCalculationUtil.stringToLong(calcBeforeAMTVO.getDtlCnt());
								}catch(Exception e) {
									log.error("*******************************************************");
									log.error("* AFT beforeCalculation Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException(" AFT beforeCalculation Function Error ::" + new ErrorHandler(e).getMessage());
								}
							} 
							else if (zDcApplRate.equals("S")){   // SC Exception			
								calculationParmVO.setPropNo(zScNo);//zScNo zPropNo
								calculationParmVO.setVerSeq(String.valueOf(zScVerSeq));
								calculationParmVO.setGrpSeq(String.valueOf(zScGrpSeq));
								
								calculationParmVO.setCntrts(zCntrtsCd);
								calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
								calculationParmVO.setDivOverDay("0");	
								
								calculationParmVO.setFtDys(String.valueOf(zDcFtDays));				// 2014.03.12
								calculationParmVO.setFmMvmtYdCd(zDcFmYdCd);							// 2014.03.12
								calculationParmVO.setTrfAplyDt(fixDtgEfftDt);						// 2014.03.12
							
								CalculationAMTVO calcSCAMTVO = null;
								
								try {
									calculationParmVO.setDmdtTrfAplyTpCd("S");						// 2014.03.12
									calculationParmVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));	// 2014.03.12
									
									calcSCAMTVO = dmtCalculationUtil.scCalculation(calculationParmVO);
									
									zDcAftAmt 	= DMTCalculationUtil.stringToDouble(calcSCAMTVO.getTotal());
									rateDtlCnt 	= DMTCalculationUtil.stringToLong(calcSCAMTVO.getDtlCnt());
								}catch(Exception e) {
									log.error("*******************************************************");
									log.error("* AFT scCalculation Function Error ::"+e.getMessage());
									log.error("*******************************************************");
									throw new EventException("* AFT scCalculation Function Error ::" + new ErrorHandler(e).getMessage());
								}
							} 
							else {
									chargeCalculationContainerVO.setMsgCd("-1");
									chargeCalculationContainerVO.setMsgDesc("* AFT  Appl Rate Error  ");
									//오류가 발생할경우 상태값을 넘겨주기 위함. throw를 통해서 중단시키면 안됨.
									return chargeCalculationContainerVO;
							}

							log.debug("*******************************************************");
							log.debug("[ Get After Amount ] getBfrExRate 	:"+getBfrExRate);
							log.debug("[ Get After Amount ] zDcAftAmt 		:"+zDcAftAmt);
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
									throw new EventException("AFT DC searchExchangeRate Function Error :: " + new ErrorHandler(e).getMessage());
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

						double zDcAftAmt_round = dmtCalculationUtil.trimCurrencyAmount(zCurCd, zDcAftAmt);
						
						if( zDcAftAmt_round <= 0 ){
							zDcStatus = "N" ;
						} else if ( "N".equals(zDcStatus) ) {
							zDcStatus = "F" ;
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
//		zDcBillAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcBillAmt);
		zDcBillAmt 	= zDcBillAmt < 0 ? 0 : dmtCalculationUtil.trimCurrencyAmount(zCurCd, zDcBillAmt);
		zDcBfrAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcBfrAmt);
		zDcAftAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcAftAmt);
		zDcCmdtAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,zDcCmdtAmt);
		
		/* Set The chargeCalculationContainerVO */
		log.debug("*************************************************************");
		log.debug("****  Set The chargeCalculationContainerVO of General********");
		log.debug("* [ChargeCalculationContainerVO ] zDcFtDays 		:"+zDcFtDays);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtCmnc 		:"+zDcFtCmnc);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtEnd 		:"+zDcFtEnd);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtOver 		:"+zDcFtOver);
		log.debug("* [ChargeCalculationContainerVO ] zDcOrgOver 	:"+zDcOrgOver);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcBfrOver 	:"+zDcBfrOver);
		log.debug("* [ChargeCalculationContainerVO ] zDcAftOver 	:"+zDcAftOver);
		log.debug("* [ChargeCalculationContainerVO ] zCurCd 		:"+zCurCd);
		log.debug("* [ChargeCalculationContainerVO ] zDcApplRate 	:"+zDcApplRate);
		log.debug("* [ChargeCalculationContainerVO ] zDcOrgAmt 		:"+zDcOrgAmt);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcExpAmt 		:"+zDcExpAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcDscAmt 		:"+zDcDscAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcBillAmt 	:"+zDcBillAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcStatus 		:"+zDcStatus);
		log.debug("* [ChargeCalculationContainerVO ] zDcBfrAmt 		:"+zDcBfrAmt);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcAftAmt 		:"+zDcAftAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDtnSeq 		:"+zDtnSeq);
		log.debug("* [ChargeCalculationContainerVO ] zDmdtDeTermCd 		:"+zDmdtDeTermCd);
		log.debug("* [ChargeCalculationContainerVO ] zDtgGrpId 		:"+zDtgGrpId);
		log.debug("* [ChargeCalculationContainerVO ] zApprNo 		:"+zApprNo);
		log.debug("* [ChargeCalculationContainerVO ] zDarNo 		:"+zDarNo);
		
		log.debug("* [ChargeCalculationContainerVO ] zMapgSeq 		:"+zMapgSeq);
		log.debug("* [ChargeCalculationContainerVO ] zVerSeq 		:"+zVerSeq);
		log.debug("* [ChargeCalculationContainerVO ] zDtlSeq 		:"+zDtlSeq);
		log.debug("* [ChargeCalculationContainerVO ] zCmbSeq 		:"+zCmbSeq);
		log.debug("* [ChargeCalculationContainerVO ] zAftApprNo 	:"+zAftApprNo);
		log.debug("* [ChargeCalculationContainerVO ] zAftDarNo 		:"+zAftDarNo);
		
		log.debug("* [ChargeCalculationContainerVO ] zAftAdjSeq 	:"+zAftAdjSeq);
		log.debug("* [ChargeCalculationContainerVO ] zScNo 			:"+zScNo);
		log.debug("* [ChargeCalculationContainerVO ] zScVerSeq 		:"+zScVerSeq);
		log.debug("* [ChargeCalculationContainerVO ] zScGrpSeq 		:"+zScGrpSeq);
		log.debug("* [ChargeCalculationContainerVO ] zCmdtCd 		:"+zCmdtCd);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcrSeq 		:"+zDcrSeq);
		log.debug("* [ChargeCalculationContainerVO ] zDcCmdtOver 	:"+zDcCmdtOver);
		log.debug("* [ChargeCalculationContainerVO ] zDcCmdtAmt 	:"+zDcCmdtAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcToDate 		:"+zDcToDate);
			
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
		chargeCalculationContainerVO.setMtDate(zWebMtDate);
		chargeCalculationContainerVO.setMsgCd("0");
		chargeCalculationContainerVO.setToMvmtYdCd(zDcToYdCd);

		return chargeCalculationContainerVO;
	}
}
