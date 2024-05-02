/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :DMTExceptionChargeCalculationUtil.java
*@FileTitle : 
*@LastModifyDate : 2012. 10. 5.
*@LastModifier : KIM HYUN HWA
*@LastVersion : 
* 2012. 10. 5. KIM HYUN HWA
* History
* 2012.12.03 Exception 금액계산 변경  
*            DEM  = {(tml+cntr+chz+oth ) * exceptDay } + Stock
*            DET  = {(cntr+chz+oth ) * exceptDay } + Stock
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
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffInfoParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BkgContainerInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtBFRGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtSCGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DtocFreeTimeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExceptionChargeCalculationVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExceptionCostParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixORGLocationVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPODLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPOLLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixORGLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeEndParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeStartParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;


/**
 * Exception Charge Calculation 함수 <br>
 *
 * @author KIM HYUN HWA
 * @see DMTCalculationDBDAO 클래스 참조
 * @since J2EE 1.6
 */
public class DMTExceptionChargeCalculationUtil {
	
	// Database Access Object
	public transient DMTCalculationDBDAO dbDao = null; 
	protected transient Logger log = null;
	
	DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
	/**
	 * DMTCalculationUtil 객체 생성<br>
	 * DMTCalculationDBDAO 생성한다.<br>
	 */
	public DMTExceptionChargeCalculationUtil() {
		dbDao = new DMTCalculationDBDAO();
		log = Logger.getLogger(getClass().getName());
	}
	
	/**
	 *  Exception Charge Calculation 대한 해당 데이터를 조회한다.
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return ExceptionChargeCalculationVO
	 * @exception EventException
	 * @throws DAOException 
	 */
	public ExceptionChargeCalculationVO exceptionChargeCalculation(ChargeCalculationParmVO chargeCalculationParmVO) 
	throws EventException, DAOException{
		
		ExceptionChargeCalculationVO exceptionChargeCalculationVO = new ExceptionChargeCalculationVO();
		//parameter values
	
		CalculationParmVO 			calculationParmVO 			= new CalculationParmVO();
		FixPOLLocationParmVO 		fixPOLLocationParmVO 		= new FixPOLLocationParmVO();
		FixPODLocationParmVO 		fixPODLocationParmVO 		= new FixPODLocationParmVO();
		FixDELLocationParmVO 		fixDELLocationParmVO 		= new FixDELLocationParmVO();
		FixORGLocationParmVO 		fixORGLocationParmVO 		= new FixORGLocationParmVO();
		FreeTimeStartParmVO 		freeTimeStartParmVO 		= new FreeTimeStartParmVO();
		FreeTimeEndParmVO 			freeTimeEndParmVO 			= new FreeTimeEndParmVO();
		LocationByBoundParmVO 		locationByBoundParmVO 		= new LocationByBoundParmVO();
		ExceptionCostParmVO         exceptionCostParmVO         = new ExceptionCostParmVO();
		BasicTariffKeyVO            basicTariffKeyVO            = new BasicTariffKeyVO();
		DtocFreeTimeParmVO 			dtocFreeTimeParmVO 			= new DtocFreeTimeParmVO();
		OverdayNStatusParmVO 		overdayNStatusParmVO 		= new OverdayNStatusParmVO();
	
		//param 지역변수 
		String zSvrId       = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getSvrId());
		String zBkgNo       = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getBkgNo());
		String zCntrNo      = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrNo());
		long   zCnmvCycNo  	= DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getCntrCycNo());
		String zDttCode     = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtTrfCd());
		String zLocDiv  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtChgLocDivCd());
		long   zChgSeq      = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getChgSeq());
		String zDcFmDate   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtDt());
		String zDcFmYdCd  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtYdCd());
		String zDcToDate   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtDt());
		String zDcToYdCd  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtYdCd());
		String zDcApplRate  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtTrfAplyTpCd());
		long   zDtnSeq      = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getBzcTrfSeq());
		String zDmdtDeTermCd= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getBzcDmdtDeTermCd());
		long   zDtgGrpId    = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getBzcTrfGrpSeq());
		String zDarNo       = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getRfaExptDarNo());
		long   zMapgSeq     = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getRfaExptMapgSeq());
		long   zVerSeq      = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getRfaExptVerSeq());
		long   zDtlSeq      = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getRfaRqstDtlSeq());
		String zScNo        = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getScNo());
		long   zScVerSeq    = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getScExptVerSeq());
		long   zScGrpSeq    = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getScExptGrpSeq());
		String zCntrtsCd    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrTpszCd());
		String zDbcIoBnd   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getIoBndCd());
		String zOfcCd		= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getOfcCd());
		String zDcFmCnms    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtStsCd());
		String zDcToCnms    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtStsCd());
		String dulTpExptFlg = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDulTpExptFlg());
		String cgoTpCd      = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCgoTpCd());
		
		log.debug("***********************************************************");
		log.debug("[exceptionChargeCalculation - ChargeCalculationParmVO]>> zSvrId 		:"+ zSvrId);
		log.debug("[exceptionChargeCalculation - ChargeCalculationParmVO]>> zCntrNo 	:"+ zCntrNo);
		log.debug("[exceptionChargeCalculation - ChargeCalculationParmVO]>> zCnmvCycNo 	:"+ zCnmvCycNo);
		log.debug("[exceptionChargeCalculation - ChargeCalculationParmVO]>> zDcFmYdCd 	:"+ zDcFmYdCd);
		log.debug("[exceptionChargeCalculation - ChargeCalculationParmVO]>> zDcToYdCd 	:"+ zDcToYdCd);
		log.debug("[exceptionChargeCalculation - ChargeCalculationParmVO]>> zDttCode 	:"+ zDttCode);
		log.debug("[exceptionChargeCalculation - ChargeCalculationParmVO]>> zLocDiv 	:"+ zLocDiv);
		log.debug("*************************************************************");
	
	//////////////////////  START    변수 정의    /////////////////
		
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
		
		String zBbRcvTermCd		= "";
		String zBbDeTermCd 		= "";
		
		String fixPolLoc		= "";
		String zPreRly			= "";
		
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
		long   zDbcBkgQty		= 0;  
		String zDcsCntrTp		= "";                                                      
		String dtgEfftDt		= ""; // 2012.01.08 Basic Tariff 에 적용하기 위해  분리
		String dtyEfftDt		= ""; // 2012.01.08 Exception Yard 에 적용하기 위해 분리
	                                       
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
	
		// Basic 
		String bsFtEnd = "";   
		double zBscRateAmt		= 0; 
		long   zDtocFtime		= 0;
		String zWebMtDate		= "";
		long   bsFtDays		    = 0;
		
		//S/C
		String scFtEnd = "";
		String zPropNo        	= "";
		
		String dsdFtimeMk		= "";                                                      
		String dsdExclSat		= "";                                                      
		String dsdExclSun		= "";                                                      
		String dsdExclHoli		= "";                                                      
		String dsdFtAddMk		= "";                                                      
		long   dsdFtAddDay		= 0;                                                     
		String dsdFtAdjMk		= "";                                                      
		String dsdRtAdjMk		= "";                                                      
		String dsdCurCd			= "";    
	 
		//RFA 
		String rfaFtEnd = "";  
	
		long   zCmbSeq			= 0;
		
		String dbdFtimeMk		= "";                                                      
		long   dbdAddDay		= 0;                                                
		long   dbdTtlDay		= 0;                                               
		String dbdExclSat		= "";                                                      
		String dbdExclSun		= "";                                                      
		String dbdExclHoli		= "";                                                      
		String dbdRateMk		= "";                                                      
		String dbdCurCd			= "";                                                      
	
		double exptCostAmt = 0; 
		long exptDys       = 0;
		String	tmpTsp			= "";
		String	zOrgContiCd		= "";
		String	zOrgCntCd		= "";
		String	zOrgRgnCd		= "";
		String	zOrgStateCd		= "";
		String	zOrgLocCd		= "";
		/* ------------------------------------------- */
		String awkInOut			= "";  
		String zFixedCmnc		= "";	
		
		List<String> cstopNoList = null;
		long		idxCstop	= 0;
		String  dmttrfCd = "";
		
		String	zClptIndSeq		= "";
		
		//////////////////////END    변수 정의    /////////////////
		/*
		 * Baisc Tariff 관련 정보는 DmdtTrfCd = "CTIC" && dulTpExptFlg = "Y" 인 경우 DmdtTrfCd  "DMIF" 인 정보를 사용함.
		   (DTIC에서 DMIF로  2012.11.13 변경.)
		 */
			
		if ("CTIC".equals(zDttCode) &&  "Y".equals(dulTpExptFlg)){	
			dmttrfCd = "DMIF";
		}else{
			dmttrfCd =  zDttCode ;
		}
		
		/*		
		[logic] Booking Container 정보가져오기 : BKG_CONTAINER 테이블 Data 
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
		
		if(DMTCalculationUtil.nullToString(bkgContainerInfoVO.getIbflag()).equals("NoDataFound")){
			log.error("*******************************************************");
			log.error("[Invalid BKG No(No Data Found) ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			log.error("*******************************************************");
		}
		
		zPorLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorCd());
		zPolLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolCd());
		zPodLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPodCd());
		zDelLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelCd());
		zYrdLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdCd());
	
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
		zBcntrRcvTerm	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRcvTermCd()); 
		zPreRly 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPreRlyPortCd(), 5);
		
		zBbRcvTermCd	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getBbRcvTermCd());
		zBbDeTermCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDeTermCd());
		
		log.debug("*******************************************************");
		log.debug("[searchBkgContainerInfo]");
		log.debug("[BkgContainerInfoVO] zPorLoc 		: "+ zPorLoc);
		log.debug("[BkgContainerInfoVO] zPolLoc 		: "+ zPolLoc);
		log.debug("[BkgContainerInfoVO] zPodLoc 		: "+ zPodLoc);
		log.debug("[BkgContainerInfoVO] zDelLoc 		: "+ zDelLoc);
		log.debug("[BkgContainerInfoVO] zYrdLoc 		: "+ zYrdLoc);
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
	
		fixPODLocationParmVO.setPodCd(zPodLoc);
		fixPODLocationParmVO.setDelCd(zDelLoc);
		fixPODLocationParmVO.setPostRly(zPostRly);
		fixPODLocationParmVO.setBkgNo(zBkgNo);
		
		if ("TSP".equals(zLocDiv)){
			fixPodLoc = DMTCalculationUtil.nullToString(dmtCalculationUtil.fixPODLocation(fixPODLocationParmVO), 5);
		}else{
			fixPodLoc = zPodLoc ;
		}
	
		/*	
		[logic] POL Loc Fix
		*/
	
		fixPOLLocationParmVO.setPorCd(zPorLoc);
		fixPOLLocationParmVO.setPolCd(zPolLoc);
		fixPOLLocationParmVO.setPreRly(zPreRly);
		fixPOLLocationParmVO.setBkgNo(zBkgNo);
		
		if ("TSP".equals(zLocDiv)){
			fixPolLoc = DMTCalculationUtil.nullToString(dmtCalculationUtil.fixPOLLocation(fixPOLLocationParmVO), 5);
		}else{
			fixPolLoc = zPolLoc ;
		}
		
		/*	
		[logic] DEL Loc Fix
		*/
		
		fixDELLocationParmVO.setDmdtTrfCd(dmttrfCd);
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
	
		/*
		[logic] Tariff의 Origin 지역 조정 - 구주 T/S O/B 인 경우 DEL 지역을 ORG으로 조정
		*/
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
	
		/*
		[logic] 1. Booking의 Container 물량 가져오기 : Get BKG Qty 
		*/
		try {
			zDbcBkgQty = dmtCalculationUtil.searchBookingContainerQuantity(zBkgNo);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("** Bkg Qty Select Error :"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("Bkg Qty Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		log.debug("*******************************************************");
		log.debug("[searchBookingContainerQuantity]");
		log.debug("zDbcBkgQty : "+ zDbcBkgQty);
		log.debug("*******************************************************");		
		
		/*
		[logic] POD ETA Date
		*/
		
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
		
		/*  Set DMDT_CNTR_TP_CD	*/
		
		zDcsCntrTp = dmtCalculationUtil.settingDemDetContainerTypeCode( zCntrtsCd );
		
		/*  EfftDt	 */
		if(zDbcIoBnd.substring(0, 1).equals("I") && zVpsEtaDt.length() != 0){
			dtyEfftDt = DMTCalculationUtil.nullToString(zVpsEtaDt,8).substring(0, 8);
		} else {
			dtyEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
		}
		
		BasicTariffParmVO effDateParmVO = new BasicTariffParmVO();
		
		effDateParmVO.setIoBndCd(zDbcIoBnd.substring(0, 1));
		effDateParmVO.setPolLocCd(fixPolLoc);
		effDateParmVO.setPodLocCd(fixPodLoc);
		effDateParmVO.setVpsEtaDt(DMTCalculationUtil.nullToString(zVpsEtaDt,8).substring(0, 8));
		effDateParmVO.setCntrNo(zCntrNo);
		effDateParmVO.setCnmvCycNo(chargeCalculationParmVO.getCntrCycNo());
		effDateParmVO.setFmDate(DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8));
		
		dtgEfftDt = dmtCalculationUtil.getEfftDt(effDateParmVO);
		
		/*  Awkward In/Out-Gauge  */
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
		log.debug("searchInOutGauge  awkInOut : "+ awkInOut);
		log.debug("*******************************************************");
			
		/*
		[logic]2.basicTariff  정보가져오기
		DmdtTrfCd = "CTIC" && dulTpExptFlg = "Y" 인 경우 DmdtTrfCd  "DMIF" 인 정보로 구함.
		(DTIC에서 DMIF로  2012.11.13 변경.)
		*/
		
		log.debug("*******************************************************");
		log.debug("* [logic] basicTariff 정보가져오기");
		log.debug("*******************************************************");
		
		/*CTIC 이면서  DualTypeFlag가 Y 인 경우는 DTIC와 같이 처리 함. */
		if ("CTIC".equals(zDttCode) &&  "Y".equals(dulTpExptFlg)){
			BasicTariffParmVO basicTariffParmVO = new BasicTariffParmVO();
			basicTariffParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
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
			
			basicTariffParmVO.setDmdtTrfCd(dmttrfCd);
			basicTariffParmVO.setEffDt(dtgEfftDt.trim());
			basicTariffParmVO.setDmdtCntrTpCd(zDcsCntrTp); 
			basicTariffParmVO.setDmdtCgoTpCd(cgoTpCd);
			basicTariffParmVO.setIoBndCd(zDbcIoBnd);
			basicTariffParmVO.setAwkInOut(awkInOut);
			
			basicTariffParmVO.setSuthChnUseFlg(DMTCalculationUtil.nullToString(chargeCalculationParmVO.getSuthChnUseFlg()));
	
			try {
				basicTariffKeyVO = dmtCalculationUtil.searchBasicTariffByGeneration(basicTariffParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*searchBasicTariffByGeneration Functon Error!"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchBasicTariffByGeneration Functon Error!" + new ErrorHandler(e).getMessage());
			}
	
			zDtnSeq 		= DMTCalculationUtil.stringToLong(basicTariffKeyVO.getTrfSeq());
			zDmdtDeTermCd	= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtDeTermCd());
			zDtgGrpId		= DMTCalculationUtil.stringToLong(basicTariffKeyVO.getTrfGrpSeq());
			
			dtgCmncTp		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtChgCmncTpCd());
			dtgCmncHr		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getCmncHr());
			dtgExclSat		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSatFlg());
			dtgExclSun		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSunFlg());
			dtgExclHoli		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldHolFlg());
			zCurCd			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getCurrCd());
	
		} else {
		
			BasicTariffInfoParamVO bzcTrfinfoParmVO  = new BasicTariffInfoParamVO();
			
			bzcTrfinfoParmVO.setSvrId(zSvrId);
			bzcTrfinfoParmVO.setDmdtTrfCd(dmttrfCd);	
			bzcTrfinfoParmVO.setDmdtChgLocDivCd(zLocDiv);
			bzcTrfinfoParmVO.setTrfSeq(String.valueOf(zDtnSeq));
			bzcTrfinfoParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
			bzcTrfinfoParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
			
			try {
				basicTariffKeyVO = dbDao.searchBasicTariffInfo(bzcTrfinfoParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("[Invalid BasicTariffInfo ! : "+zSvrId +", "+zBkgNo +", "+ zCntrNo +", "+ dmttrfCd +", "+  zDtnSeq+", "+ zDmdtDeTermCd+", "+ zDtgGrpId);
				log.error("*******************************************************");
				throw new EventException("[Invalid BasicTariffInfo ! : " + new ErrorHandler(e).getMessage());
			}
			
			dtgCmncTp		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtChgCmncTpCd());
			dtgCmncHr		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getCmncHr());
			dtgExclSat		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSatFlg());
			dtgExclSun		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSunFlg());
			dtgExclHoli		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldHolFlg());
			zCurCd			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getCurrCd());
		}
	
		/*		
		[logic] Basic Tariff의 Free days 가져오기 : Get Basic Free Days
		>>>>> zDbcBkgQty -> Booking의 Container 물량
		*/
		log.debug("*******************************************************");
		log.debug("* [logic]  Basic Tariff의 Free days 가져오기*");
		log.debug("*******************************************************");
		 
		try {
			zDcFtDays = dmtCalculationUtil.basicFreeTime(zSvrId, dmttrfCd, zDtnSeq, zDmdtDeTermCd, zDtgGrpId, zDbcBkgQty);
			bsFtDays = zDcFtDays;
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("** FreeTime Function Error ! "+ e.getMessage() + ", "+ dmttrfCd+ ", "+ zDtnSeq+ ", "+ zDmdtDeTermCd+", "+ zDtgGrpId+ ", "+ zDbcBkgQty);
			log.error("*******************************************************");
			throw new EventException("FreeTime Function Error ! " + new ErrorHandler(e).getMessage());
		}
		log.debug("*******************************************************");
		log.debug("[basicFreeTime]");
		log.debug("	bsFtDays :"+	bsFtDays);
		log.debug("*******************************************************");	
	
		/*	
		[logic] ID->OC Case Free days 조정 : ID -> OC F/Days Adjust
		>>>>> getDTOCFtime
		*/
		
		if( dmttrfCd.equals("DTIC") &&  zDcFmCnms.equals("ID")	&&  zDcToCnms.equals("OC") ){
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
					log.debug("getDTOCFtime Function Error :"+zDtocFtime);
					zDtocFtime = 0 ;
				}
				
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getDTOCFtime Function Error ! "+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("getDTOCFtime Function Error ! " + new ErrorHandler(e).getMessage());
			}
			log.debug("*******************************************************");
			log.debug("zDtocFtime :"+zDtocFtime);
			log.debug("*******************************************************");
			
			zDcFtDays = zDcFtDays + zDtocFtime	; 
			bsFtDays = zDcFtDays;
			
			log.debug("*******************************************************");
			log.debug("* [ ID->OC BSC Ftime] ");
			log.debug("* [ DTIC FTIME += DTOC FTIME] zDcFtDays :"+zDcFtDays);
			log.debug("*******************************************************");
		}

		/*
		  [logic] Basic Free Time Start / End 
		  */	
		
		/* Basic FreeTime Start */
		
		/* Init Clock Stop Ary */
		cstopNoList = new ArrayList<String>();
		idxCstop = 0;
	
		if( ( dmttrfCd.equals("DMIF") ||  dmttrfCd.equals("CTIC") ) 
				&& DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(fixPodLoc,5).substring(0,5)) 
				&& zDcFmCnms.equals("VD")) {
				
			try {
				zFixedCmnc = DMTCalculationUtil.nullToString(dbDao.getFixedCmnc(zVslCd, zSkdVoyageNo, zSkdDirCd, zDcFmYdCd, dmttrfCd, "fm",zClptIndSeq));
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
			
			freeTimeStartParmVO.setDttCode(dmttrfCd);
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
				cstopNoList	= freeTimeStartVO.getCStopNoList();
				
				log.debug("**********************************************************");
				log.debug("* [FreeTimeVO(return) ] zDcFtCmnc 	:["+zDcFtCmnc+"]");
				log.debug("* [FreeTimeVO(return) ] idxCstop 	:["+idxCstop+"]");
				log.debug("* [FreeTimeVO(return) ] cstopNoList 	:["+cstopNoList+"]");
				log.debug("**********************************************************");
				
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* BasicTriff searchFreeTimeStart Function Error : "+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("BasicTriff searchFreeTimeStart Function Error :  " + new ErrorHandler(e).getMessage());
			}
		}

		/*	
		 Get Basic FreeTime End
		*/
		
		freeTimeEndParmVO.setFromDt(zDcFtCmnc);  
		
		freeTimeEndParmVO.setBkgCntCd(bkgCntCd);
		freeTimeEndParmVO.setBkgRgnCd(bkgRgnCd);
		freeTimeEndParmVO.setBkgStateCd(bkgStateCd);
		freeTimeEndParmVO.setBkgLocCd(bkgLocCd);
		
		freeTimeEndParmVO.setYrdCntCd(zYrdCntCd);
		freeTimeEndParmVO.setYrdRgnCd(zYrdRgnCd);
		freeTimeEndParmVO.setYrdStateCd(zYrdStateCd);
		freeTimeEndParmVO.setYrdLocCd(zYrdLoc);
		
		freeTimeEndParmVO.setDttCode(dmttrfCd);
		freeTimeEndParmVO.setOfcCd(zOfcCd);
		freeTimeEndParmVO.setExclSat(dtgExclSat);
		freeTimeEndParmVO.setExclSun(dtgExclSun);
		freeTimeEndParmVO.setExclHoli(dtgExclHoli);
		
		freeTimeEndParmVO.setFreeTime(String.valueOf(bsFtDays));
		freeTimeEndParmVO.setSvrId(zSvrId);
		freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
		freeTimeEndParmVO.setCStopNoList(cstopNoList);
		freeTimeEndParmVO.setYardCd(zDcFmYdCd);	
		freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
		freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
		freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
		
		FreeTimeVO freeTimeEndVO = null;
		try {
			freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
			zDcFtEnd  	  = DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
			idxCstop 	  = DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
			cstopNoList   = freeTimeEndVO.getCStopNoList();
			bsFtEnd  	  = DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
			log.debug("*******************************************************");
			log.debug("* [BasicTriff FreeTimeVO(return) ] bsFtEnd 	:["+bsFtEnd+"]");
			log.debug("* [BasicTriff FreeTimeVO(return) ] ioIdxCstop 	:["+idxCstop+"]");
			log.debug("* [BasicTriff FreeTimeVO(return) ] cstopNoList 	:["+cstopNoList+"]");
			log.debug("*******************************************************");
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("BasicTriff searchFreeTimeEnd Function Error -"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("BasicTriff searchFreeTimeEnd Function Error - " + new ErrorHandler(e).getMessage());
		}

 /*
 * [logic] RFA Exception Tariff
 */

		if( zDarNo.length() != 0 ){
		
			log.debug("*******************************************************");
			log.debug("* [logic]  Get RFA Exception Values ");
			log.debug("*******************************************************");
	
			 DmtBFRGrpVO dmtBFRGrpVO = null;
			try {
				   dmtBFRGrpVO	= dbDao.searchRFAExceptionInfo(zDarNo, zMapgSeq, zVerSeq, zDtlSeq);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* searchRFAExceptioninfo Functon Error -"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchRFAExceptioninfo Functon Error - " + new ErrorHandler(e).getMessage());
			}
			
				dbdFtimeMk		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getFtimeMk());
				dbdAddDay   	= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getAddDay());
				dbdTtlDay		= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getTtlDay());
				dbdExclSat		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getExclSat());
				dbdExclSun		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getExclSun());
				dbdExclHoli		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getExclHoli());
				dbdRateMk		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getRateMk());
				dbdCurCd		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getCurCd());
				zCmbSeq         = DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getCmbSeq());
				
				log.debug("*******************************************************");
				log.debug("[searchRFAExceptioninfo]");
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
						freeTimeEndParmVO.setYardCd(zDcFmYdCd);
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
	
						freeTimeEndVO = null;
						try {
							freeTimeEndVO 	= dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
							zDcFtEnd        = freeTimeEndVO.getFtimeEnd();
							rfaFtEnd   		= freeTimeEndVO.getFtimeEnd();
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
						log.debug("[ BFR freeTimeEndVO ] rfaFtEnd 		:"+rfaFtEnd);
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
							freeTimeStartParmVO.setYardCd(zDcFmYdCd);	
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
						freeTimeEndParmVO.setYardCd(zDcFmYdCd);	
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
					
						freeTimeEndVO = null;
						try {
							freeTimeEndVO 	= dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
							zDcFtEnd        = DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
							rfaFtEnd   		= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
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
						log.debug("[ BFR freeTimeEndVO ] rfaFtEnd 	:"+rfaFtEnd);
						log.debug("[ BFR freeTimeEndVO ] idxCstop 		:"+idxCstop);
						log.debug("[ BFR freeTimeEndVO ] cstopNoList 	:"+cstopNoList);
						log.debug("*******************************************************");	
						
					}
				} /* if(dbdFtimeMk == "Y" ) */
				
		}  /*_________ RFA(BFR) Exception End	*/	

/*
 * SC Exception
 */
	
		if(zScNo.length() != 0  && zDarNo.length() == 0) {
			
			log.debug("*******************************************************");
			log.debug("* [logic]  Get USC Exception Values 					 ");
			log.debug("*******************************************************");
			
			DmtSCGrpVO dmtSCGrpVO = null;
			try {
				dmtSCGrpVO = dbDao.searchSCExceptionInfo(zScNo, zScVerSeq, zScGrpSeq);
		
				
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* searchSCExceptionInfo Functon Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchSCExceptionInfo Functon Error :" + new ErrorHandler(e).getMessage());
			}
			
			if(DMTCalculationUtil.nullToString(dmtSCGrpVO.getPropNo()).equals("")){
				log.debug("[searchSCExceptionInfo -> No data found]");
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
				log.debug("[searchSCExceptionInfo]");
				log.debug("[ USC No (DmtSCGrpVO)] zBrhScNo 		:"+zScNo);
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
						freeTimeEndParmVO.setYardCd(zDcFmYdCd);	
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
						
						freeTimeEndParmVO.setExpType("SC");
						
						freeTimeEndVO = null;
						try {
							freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
							zDcFtEnd      = DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
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
							freeTimeStartParmVO.setIoBndCd(zDbcIoBnd);
							freeTimeStartParmVO.setBkgDeTermCd(zBcntrDlvTerm);
							freeTimeStartParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
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
						freeTimeEndParmVO.setYardCd(zDcFmYdCd);	
						freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
						freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
						freeTimeEndParmVO.setBkgRcvTermCd(zBcntrRcvTerm);
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
					
				} 
				scFtEnd = zDcFtEnd ;
				log.debug("[ SC (freeTimeEndVO) ]scFtEnd 		:"+scFtEnd);
			}
		 }  /*_________ SC Exception End	*/
	
		if ("".equals(zDcFtEnd)){
			 zDcFtEnd =  bsFtEnd ;
		}
	
		/*  Exception calc 구분
		 1. To Movement Date가 Exception Free Time End 이전인 경우
		 2. To Movement Date가 Exception Free Time End 이후인 경우
		 */
		String calc_fg = "";
		try {
			calc_fg = dbDao.searchExceptionCostCase(zDcToDate, zDcFtEnd);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("[error Exception Cost calc 구분 ! : "+zDcToDate +", "+ zDcFtEnd);
			log.error("*******************************************************");
			throw new EventException("[error Exception Cost calc 구분 ! : " + new ErrorHandler(e).getMessage());
		}

/*
[logic] Get Grace Period Overday 
*/
		log.debug("*******************************************************");
		log.debug("* [logic]  Get Grace Period Overday");
		log.debug("*******************************************************");
		
		try {
			zWebMtDate =	DMTCalculationUtil.nullToString(dmtCalculationUtil.getMTNotify(zSvrId, zCntrNo, zCnmvCycNo, dmttrfCd, zDcFmCnms));
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
		
		if (calc_fg.equals("1")){
		   overdayNStatusParmVO.setToDate(zDcToDate);
		   overdayNStatusParmVO.setFtimeEnd(bsFtEnd);
		}else{
		   overdayNStatusParmVO.setToDate(zDcFtEnd);
		   overdayNStatusParmVO.setFtimeEnd(bsFtEnd);
		}
		overdayNStatusParmVO.setDttCode(dmttrfCd);
		overdayNStatusParmVO.setOfcCd(zOfcCd);
		overdayNStatusParmVO.setMtDate(zWebMtDate);
		overdayNStatusParmVO.setCstopIdx(String.valueOf(idxCstop));
		overdayNStatusParmVO.setCStopNoList(cstopNoList);
		overdayNStatusParmVO.setYardCd(zDcFmYdCd);
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
		overdayNStatusParmVO.setExptCostFlg("Y");
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
	
		calculationParmVO.setSvrId(zSvrId);
		calculationParmVO.setDmdtTrfCd(dmttrfCd);
		calculationParmVO.setTrfSeq(String.valueOf(zDtnSeq));
		calculationParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
		calculationParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
		calculationParmVO.setCntrts(zCntrtsCd);
		calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
		calculationParmVO.setDivOverDay("0");
		calculationParmVO.setFtDys(String.valueOf(zDcFtDays));			// 2014.03.12
		calculationParmVO.setFmMvmtYdCd(zDcFmYdCd);						// 2014.03.12
		calculationParmVO.setTrfAplyDt(dtgEfftDt);						// 2014.03.12
		calculationParmVO.setOrgFtOvrDys(String.valueOf(bsFtDays));		// 2014.03.12
		if (zDcFtDays > bsFtDays) {										// 2014.03.12
			// Exception 발생시
        	calculationParmVO.setDmdtTrfAplyTpCd("B");					// 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
        } else {
        	calculationParmVO.setDmdtTrfAplyTpCd("G");					// 2014.03.12
        }
		
		CalculationAMTVO calculationBAMTVO = null;
		try {
			calculationBAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
			zBscRateAmt = DMTCalculationUtil.stringToDouble(calculationBAMTVO.getTotal());
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* Charge & Total Function Error -"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* Charge & Total Function Error -" + new ErrorHandler(e).getMessage());
		}	

//////////////////////////////////////////////////////////////////////////////////		
//	  /*  
//	  [logic] Yard별 Exception Cost 조회
//	  From Yard에 해당하는 Cost조회
//	    1. DMIF면 Exception Cost에 TMNL COST도 포함
//	    2. DTIC나 CTIC면 Exception Cost에 TMNL COST 불포함
//	    3. Yard 기준 - I/B Demurrage(DMIF) 및 I/B Detention(DTIC, CTIC) : From Yard 기준
//	    4. Date 기준 - I/B : POD-ETA 기준
//	  */

		log.debug("*******************************************************");
		log.debug("* [logic] searchExceptionCostbyYard 정보가져오기");
		log.debug("*******************************************************");

/*  
[logic] Exception Cost 비용 계산

 1. To Movement Date가 Exception Free Time End 이전인 경우
    Exception Days = To Movement Date - Basic Free Time End Date
    Exception COST AMT = Exception Days * Exception Cost
    EXPT_TRF_RT_ADJ_AMT = 0

 2. To Movement Date가 Exception Free Time End 이후인 경우
    Exception Days = Exception Free Time End - Basic Free Time End Date
    Exception COST AMT = Exception Days * Exception Cost
    EXPT_FT_AMT = Basic Tariff rate * Exception Days( overday 적용계산금액)
    EXPT_TRF_RT_ADJ_AMT = DMT_CHG_CALC.SC_RFA_EXPT_AMT - EXPT_FT_AMT
  
  INCUR_QTY = 1
  INCUR_CNTR_TEU_KNT  
    - Container의 TP/SZ중 SZ가 '2'면 1, 그외는 2
  EXPT_QTY  = 1
  EXPT_CNTR_TEU_KNT
    - Container의 TP/SZ중 SZ가 '2'면 1, 그외는 2
*/

		 exceptionCostParmVO.setCntrNo(zCntrNo);
		 exceptionCostParmVO.setCntrCycNo(String.valueOf(zCnmvCycNo));
		 exceptionCostParmVO.setChgSeq(String.valueOf(zChgSeq));
		 exceptionCostParmVO.setYdCd(zDcFmYdCd);
		 exceptionCostParmVO.setEtaDt(dtyEfftDt);
		 exceptionCostParmVO.setDmdtBzcFtEndDt(bsFtEnd);
		 exceptionCostParmVO.setExptFtEndDt(zDcFtEnd);
		 exceptionCostParmVO.setDmdtChgLocDivCd(zLocDiv);
		 exceptionCostParmVO.setDmdtTrfCd(zDttCode);
		 exceptionCostParmVO.setCntrTpszCd(zCntrtsCd);
		 exceptionCostParmVO.setDmdtTrfAplyTpCd(zDcApplRate);
		 exceptionCostParmVO.setBzcRt(String.valueOf(zBscRateAmt));
		 exceptionCostParmVO.setToMvmtDt(zDcToDate); 
		 exceptionCostParmVO.setBzcCurrCd(zCurCd);
		 exceptionCostParmVO.setFmMvmtDt(zDcFmDate);
			
		 if (zDbcIoBnd.equals("O")){
			 exceptionCostParmVO.setTermCd(zBcntrRcvTerm);
		 }else{
			 exceptionCostParmVO.setTermCd(zBbDeTermCd);
		 }
	
		try {
			exceptionChargeCalculationVO = dbDao.searchExceptionCostbyYard(exceptionCostParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("[Invalid Exception Cost ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			log.error("*******************************************************");
			throw new EventException("[Invalid Exception Cost ! : " + new ErrorHandler(e).getMessage());
		}
	
		exptDys = DMTCalculationUtil.stringToLong(exceptionChargeCalculationVO.getExptDys());
		
		if (exptDys <= 0) {
			exptCostAmt  = 0 ;
			exceptionChargeCalculationVO.setExptCostAmt(String.valueOf(exptCostAmt)) ; 
		}
	
		exceptionChargeCalculationVO.setBkgNo(zBkgNo);
		exceptionChargeCalculationVO.setCntrNo(zCntrNo);
		exceptionChargeCalculationVO.setCntrCycNo(String.valueOf(zCnmvCycNo));
		exceptionChargeCalculationVO.setChgSeq(String.valueOf(zChgSeq));
		exceptionChargeCalculationVO.setDmdtTrfCd(zDttCode);
		exceptionChargeCalculationVO.setDmdtBzcFtEndDt(bsFtEnd);
		exceptionChargeCalculationVO.setExptFtEndDt(zDcFtEnd);
		exceptionChargeCalculationVO.setBkgQty(String.valueOf(zDbcBkgQty));
	
		return exceptionChargeCalculationVO;
	
	}
}
