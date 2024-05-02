/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselOperationSupportMonitoringBCImpl.java
*@FileTitle : VOSI Update Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.10 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.basic;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hanjin.apps.alps.vop.fcm.trendline.trendline.basic.TrendLineBC;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.basic.TrendLineBCImpl;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration.VesselInformationMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LoadFactorListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPerformanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration.VoyagePerformanceMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.vo.VoyagePerformanceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
 
/**
 * ALPS-VoyagePerformanceMgt Business Logic Basic Command implementation<br>
 * - ALPS-VoyagePerformanceMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Duk Woo
 * @see VOP_VSK_0516EventResponse,VesselOperationSupportMonitoringBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class VoyagePerformanceMgtBCImpl extends BasicCommandSupport implements VoyagePerformanceMgtBC {

	// Database Access Object
	private transient VoyagePerformanceMgtDBDAO dbDao 	= null;
	private transient VesselInformationMgtDBDAO dbDao2 	= null;

	/**
	 * VoyagePerformanceMgtBCImpl 객체 생성<br>
	 * VoyagePerformanceMgtDBDAO를 생성한다.<br>
	 */
	public VoyagePerformanceMgtBCImpl() {
		dbDao 	= new VoyagePerformanceMgtDBDAO();
		dbDao2 	= new VesselInformationMgtDBDAO();
	}
	
	/**
	 * VOP_VSK_0516 : Retrieve <br>
	 *  Voyage Performance 을 조회 합니다.<br>
	 * 
	 * @param VoyagePerformanceVO voyagePerformanceVO
	 * @return List<VoyagePerformanceVO>
	 * @exception EventException
	 */
	public List<VoyagePerformanceVO> searchVoyagePerformance(VoyagePerformanceVO voyagePerformanceVO) throws EventException {
		
		List<VoyagePerformanceVO>	rtnVOs				= new ArrayList<VoyagePerformanceVO>();
		////Float						mileToKmConv		= 1.852f;
		Float						mileToKmConv		= 1.0f;
		
		Boolean						isExeQueryCsmTab	= "Y".equals(voyagePerformanceVO.getSelConsum	()) ? true : false;
		
		try {
			
			List<VoyagePerformanceVO>	tmpVOs	= new ArrayList<VoyagePerformanceVO>();
			tmpVOs								= dbDao.searchVoyagePerformance(voyagePerformanceVO);
			
			String						preVVD		= "";
			String						curVVD		= "";
			String						preFmPort	= "";
			String						preToPort	= "";
			String						curFmPort	= "";
			String						curToPort	= "";
			
			Float 	fFromAStdQty					= 0.0f;
			Float	fAccmRunHours					= 0.0f;
			
			//::2007816:2014-05-16://
			for(int i=0; i<tmpVOs.size(); i++){
				
				VoyagePerformanceVO	tmpVO	= new VoyagePerformanceVO();
				tmpVO						= tmpVOs.get(i);

				//----------------------------------------------------------
				curVVD						= tmpVO.getVvd();
				curFmPort					= tmpVO.getFromPortCd();
				curToPort					= tmpVO.getToPortCd();
				//----------------------------------------------------------
				
				if(isExeQueryCsmTab){
					
					/***********************************************************
					 * ========= FUAL CONSUMPTON CALCULATION [[START]] =========
					 ***********************************************************/
					
					VesselInformationMgtConditionVO vesselInformationMgtConditionVO	= new VesselInformationMgtConditionVO();
					vesselInformationMgtConditionVO.setVslCd	(tmpVO.getVslCd					()	);
					
					
					//::VESSEL DESIGN CAPA. FORMATTING:://
					DecimalFormat 	formatVslCapa 			= new DecimalFormat("#,###");
					tmpVO.setCntrDznCapa(String.valueOf(formatVslCapa.format(Double.parseDouble(tmpVO.getCntrDznCapa()))));
					
					String			sNoonRptExistFlg			= tmpVO.getNoonRptExistFlg();
					//Float 			fDailyFoc					= 0.0f;
					
						
					////VSLPerformanceVO tmpVSLPerformanceVO		= this.searchVSLPerformance		(vesselInformationMgtConditionVO	);
					////fHourlyFocQty								= Float.parseFloat(tmpVSLPerformanceVO.getHourlyFocQty());
					////Float			fHourlyFocQty				= 0.0f;
					
					//================================================================================================================
					Float dDailyFoc			= 0.0f;
					if("Y".equals(sNoonRptExistFlg)){
						//----------------------------------------------------------------------------------------------------------------//
						VSLPerformanceVO 	tmpVSLPerformanceVO		= this.searchVSLPerformance		(vesselInformationMgtConditionVO, tmpVO.getNaviEtaSpd());
						Float 				fHourlyFocQty			= Float.parseFloat(tmpVSLPerformanceVO.getHourlyFocQty());
						//----------------------------------------------------------------------------------------------------------------//
						
						String sRunHrs		= tmpVO.getNaviRunHrs() 			== null || "".equals(tmpVO.getNaviRunHrs()) ? "0" : tmpVO.getNaviRunHrs();
						dDailyFoc			= fHourlyFocQty*Float.parseFloat(sRunHrs);
					}else{
						
						//----------------------------------------------------------------------------------------------------------------//
						VSLPerformanceVO 	tmpVSLPerformanceVO		= this.searchVSLPerformance		(vesselInformationMgtConditionVO, tmpVO.getNaviEtaSpd());
						Float 				fHourlyFocQty			= Float.parseFloat(tmpVSLPerformanceVO.getHourlyFocQty());
						//----------------------------------------------------------------------------------------------------------------//
						
						dDailyFoc			= fHourlyFocQty*24;
					}
					
					tmpVO.setCsmDailyFocStd						(String.valueOf(dDailyFoc));		//::[C/Sked simulation시 ETA Speed FOC 의 시간당 소모량 X Running hour 만일 Noon Report 미접수 시  24시간으로 표시함]:://
					//================================================================================================================
					
					//================================================================================================================
					Float	fDailyFocTLine	= 0.0f;
					if("Y".equals(sNoonRptExistFlg)){
						
						//----------------------------------------------------------------------------------------------------------------//
						VSLPerformanceVO 	tmpVSLPerformanceVO		= this.searchVSLPerformance		(vesselInformationMgtConditionVO, tmpVO.getNoonAvgSpd());
						Float 				fHourlyFocQty			= Float.parseFloat(tmpVSLPerformanceVO.getHourlyFocQty() == null || "".equals(tmpVSLPerformanceVO.getHourlyFocQty()) ? "0.0" : tmpVSLPerformanceVO.getHourlyFocQty());
						//----------------------------------------------------------------------------------------------------------------//
						
						Float				tmpNoonSailDist			= tmpVO.getNoonSailDist	() == null || "".equals(tmpVO.getNoonSailDist	()) ? 0.0f : Float.parseFloat(tmpVO.getNoonSailDist	()); 
						Float				tmpNoonAvgSpd			= tmpVO.getNoonAvgSpd	() == null || "".equals(tmpVO.getNoonAvgSpd		()) ? 0.0f : Float.parseFloat(tmpVO.getNoonAvgSpd	()); 
								
						if(tmpNoonAvgSpd != 0){
							fDailyFocTLine								= fHourlyFocQty*tmpNoonSailDist/tmpNoonAvgSpd;
						}
					
						tmpVO.setCsmDailyFocTLine					(String.valueOf(fDailyFocTLine));	//::[FCM-Trend line으로 실제 진행한 Speed 및 Distance계산된 시간당 소모량 x Running Hrs. --- Noon report 미 접수시 24시간 기준으로 계산함]:://
					}else{

						//----------------------------------------------------------------------------------------------------------------//
						VSLPerformanceVO 	tmpVSLPerformanceVO		= this.searchVSLPerformance		(vesselInformationMgtConditionVO, tmpVO.getNoonAvgSpd());
						Float 				fHourlyFocQty			= Float.parseFloat(tmpVSLPerformanceVO.getHourlyFocQty() == null || "".equals(tmpVSLPerformanceVO.getHourlyFocQty()) ? "0.0" : tmpVSLPerformanceVO.getHourlyFocQty());
						//----------------------------------------------------------------------------------------------------------------//
						
						fDailyFocTLine								= fHourlyFocQty*24.0f;
					
						tmpVO.setCsmDailyFocTLine					(String.valueOf(fDailyFocTLine));	//::[FCM-Trend line으로 실제 진행한 Speed 및 Distance계산된 시간당 소모량 x Running Hrs. --- Noon report 미 접수시 24시간 기준으로 계산함]:://
					}
					//================================================================================================================
					
					//================================================================================================================
					Float	fDailyFocPps	= 0.0f;
					if(tmpVO.getPpsAvgSpd() != null && !"".equals(tmpVO.getPpsAvgSpd()) && Float.parseFloat(tmpVO.getPpsAvgSpd()) > 0){
					
						//----------------------------------------------------------------------------------------------------------------//
						VSLPerformanceVO 	tmpVSLPerformanceVO		= this.searchVSLPerformance		(vesselInformationMgtConditionVO, tmpVO.getPpsAvgSpd());
						Float 				fHourlyFocQty			= Float.parseFloat(tmpVSLPerformanceVO.getHourlyFocQty() == null || "".equals(tmpVSLPerformanceVO.getHourlyFocQty()) ? "0.0" : tmpVSLPerformanceVO.getHourlyFocQty());
						//----------------------------------------------------------------------------------------------------------------//
						
						if(		tmpVO.getPpsAvgSpd() == null || "".equals(tmpVO.getPpsAvgSpd()) || "0".equals(tmpVO.getPpsAvgSpd())
							||	tmpVO.getPpsSailDist() == null || "".equals(tmpVO.getPpsSailDist()) || "0".equals(tmpVO.getPpsSailDist())
						  )
						{
							fDailyFocPps								= 0.0f;
						}else{
							fDailyFocPps								= fHourlyFocQty*(Float.parseFloat(tmpVO.getPpsSailDist())*mileToKmConv/Float.parseFloat(tmpVO.getPpsAvgSpd()));	
						}
						
						tmpVO.setCsmDailyFocPps						(String.valueOf(fDailyFocPps));		//::[Trend Line을 이용하여 PPS로 계산된 Distance 와 Speed로 계산된 시간 당 소모량 x Running Hrs한 값 2개의 PPS가 값이 존재하지 않으면 공란 칼럼 숨김]:://	
					}
					//================================================================================================================
					
					////tmpVO.setCsmDailyFocNoon					("69.9");		//::[Noon Report값을 표시함 만일 Report 미 접수시 표시 하지 않음]:://
					
					//================================================================================================================
					Float  	fDailyFocStd	= tmpVO.getCsmDailyFocStd()  == null || "".equals(tmpVO.getCsmDailyFocStd())  ? 0.0f : Float.parseFloat(tmpVO.getCsmDailyFocStd());
					Float	fDailyFocNoon	= tmpVO.getCsmDailyFocNoon() == null || "".equals(tmpVO.getCsmDailyFocNoon()) ? 0.0f : Float.parseFloat(tmpVO.getCsmDailyFocNoon());
					
					StringBuffer	sbDailyFocDiff	= new StringBuffer();
					DecimalFormat 	format 			= new DecimalFormat("#,###.#");

					
					sbDailyFocDiff.append(String.valueOf(format.format(fDailyFocStd 	- fDailyFocNoon)));
					sbDailyFocDiff.append(" / ");
					sbDailyFocDiff.append(String.valueOf(format.format(fDailyFocTLine 	- fDailyFocNoon)));
					sbDailyFocDiff.append(" / ");
					sbDailyFocDiff.append(String.valueOf(format.format(fDailyFocPps 	- fDailyFocNoon)));
					
					tmpVO.setCsmDailyFocDiff					(sbDailyFocDiff.toString());		//::[Stand 대비 각각 칼럼의 Diff값을 표시함]:://
					//================================================================================================================
					
					//================================================================================================================
					String  sDailyFocFlag	= null;
					String  sDailyFocIndex	= null;
					Float  	fDailyFocFlag	= fDailyFocNoon/fDailyFocStd;
									
			        /* Float.compare method result
			         * if(f < f1)	return -1;
			         * if(f > f1)	return 1;	
			         */
					
					if(Float.compare(fDailyFocFlag, 1.1f) >= 0){
						sDailyFocFlag	= "FOC";
						sDailyFocIndex	= "RED";
					}else if((Float.compare(fDailyFocFlag, 1.1f) < 0) && (Float.compare(fDailyFocFlag, 1.0f) > 0)){
						sDailyFocFlag	= "FOC";
						sDailyFocIndex	= "YELLOW";
					}else{
						sDailyFocFlag	= "";
						sDailyFocIndex	= "GREEN";
					}					
					
					tmpVO.setCsmDailyFocColorFlag				(sDailyFocFlag	);		//::[RED : more than 10%, YELLOW : below 10%]:://
					tmpVO.setSignalFocIdx						(sDailyFocIndex	);
					
					StringBuffer 	sbTmpSingalIndex	= new StringBuffer("");
					sbTmpSingalIndex.append(tmpVO.getSignalIndex());
					sbTmpSingalIndex.append(" ");
					sbTmpSingalIndex.append(sDailyFocFlag);
					
					tmpVO.setSignalIndex(sbTmpSingalIndex.toString());
					//================================================================================================================

					////tmpVO.setCsmFocRpt						(tmpVO.getCsmFocRpt());		//::[]:://
					////tmpVO.setCsmFromFocStd						("91.1");		//::[Coastal SKED Standard 내 Port Pair값을 표시함(Initial < Revised)]:://
					////tmpVO.setCsmFromAvgStd						("92.2");		//::[xxx]:://
					////tmpVO.setCsmFromAvgFoc						("93.3");		//::[구간 noon report Oil Consumption 의 M/E Total + G/E Total 의 누적 소모량을 표시함]:://
					
					//================================================================================================================
					//::2014-06-16:://Float	fFromAStdQty						= tmpVO.getCsmFromAvgStd() == null || "".equals(tmpVO.getCsmFromAvgStd()) ? 0.0f : Float.parseFloat(tmpVO.getCsmFromAvgStd());
					
					Float fTmpNaviRunHrs	= tmpVO.getNaviRunHrs() == null || "".equals(tmpVO.getNaviRunHrs()) ? 0.0f : Float.parseFloat(tmpVO.getNaviRunHrs());
					
					if(preVVD.equals(curVVD) && preFmPort.equals(curFmPort) && preToPort.equals(curToPort)){
						fFromAStdQty	= fFromAStdQty + dDailyFoc;
						fAccmRunHours	= fAccmRunHours+ fTmpNaviRunHrs;
					}else{
						fFromAStdQty	= dDailyFoc;
						fAccmRunHours	= fTmpNaviRunHrs;
					}
					
					tmpVO.setCsmFromAvgStd						(fFromAStdQty.toString());
					
					Float	fFromAFocQty						= tmpVO.getCsmFromAvgFoc() == null || "".equals(tmpVO.getCsmFromAvgFoc()) ? 0.0f : Float.parseFloat(tmpVO.getCsmFromAvgFoc());
					
					Float	fFromFocStd							= tmpVO.getCsmFromFocStd() == null || "".equals(tmpVO.getCsmFromFocStd()) ? 0.0f : Float.parseFloat(tmpVO.getCsmFromFocStd());
					Float	fFromBalanceFocQty					= fFromFocStd - fFromAFocQty;
					tmpVO.setCsmFromBalanceFoc					(fFromBalanceFocQty.toString());		//::[Plan FOC -누적 소모량으로 Balance 표시함]:://
					
					/*****************************************************************************************
					 * ARCHIEVEMENT RATIO(달성율) :: (Daily Noon 칼럼 * 현재 기준 일수 - Balance)/ Stand 칼럼 %
					 * Daily Noon	:: fDailyFocNoon
					 * 현재기준일수		:: fRemainDays
					 * Balance		:: fFromBalanceFocQty
					 * Standard		:: fDailyFocStd
					 *****************************************************************************************/
					
					Float	fAchPercentage	= 0.0f;					
					Float	fTmpRunHours		= tmpVO.getNaviRunHrs	() == null || "".equals(tmpVO.getNaviRunHrs		()) ? 0.0f : Float.parseFloat(tmpVO.getNaviRunHrs	());
					Float	fTmpTztmHrs			= tmpVO.getTztmHrs		() == null || "".equals(tmpVO.getTztmHrs		()) ? 0.0f : Float.parseFloat(tmpVO.getTztmHrs		());
					Float	fTmpAccmFocQty		= tmpVO.getCsmFromAvgFoc() == null || "".equals(tmpVO.getCsmFromAvgFoc	()) ? 0.0f : Float.parseFloat(tmpVO.getCsmFromAvgFoc());
					
					//:: RULE ==> ((DAILY FOC NOON / RUN HOURS) * (총항해시간 - PORT PAIR별 누적 RUN HOURS) ) + ACCM FOC(NOON) :://
					Float	fAchPercentageBunza	= 0.0f;
					fAchPercentageBunza			= (fDailyFocNoon/fTmpRunHours) * (fTmpTztmHrs - fAccmRunHours) + fTmpAccmFocQty;
					
					Float	fTmpStandardFOCQty	= tmpVO.getCsmFromFocStd() == null || "".equals(tmpVO.getCsmFromFocStd	()) ? 0.0f : Float.parseFloat(tmpVO.getCsmFromFocStd());
					fAchPercentage				= (fAchPercentageBunza / fTmpStandardFOCQty) * 100;
					
					if(fTmpStandardFOCQty != 0 ){
						tmpVO.setCsmFromAchPercentage	(fAchPercentage.toString());
					}else{
						tmpVO.setCsmFromAchPercentage	("");
					}
					
					/***********************************************************
					 * ========= FUAL CONSUMPTON CALCULATION [[FINISH]] =========
					 ***********************************************************/
					
				}else{
					
					tmpVO.setCsmDailyFocNoon(null);
					tmpVO.setCsmFromAvgFoc	(null);
					
					tmpVO.setCsmFromFocStd	(null);
				}
				
				rtnVOs.add(tmpVO);
				
				//----------------------------------------------------------
				preVVD						= tmpVO.getVvd();
				preFmPort					= tmpVO.getFromPortCd();
				preToPort					= tmpVO.getToPortCd();
				//----------------------------------------------------------
			
			}
			
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
		}
		
		return	rtnVOs;
	}
	
	
	/**
	 * Performance tab 에서 Operation 정보를 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @param String sVesselSpeed
	 * @return VSLPerformanceVO
	 * @exception EventException
	 */
	public VSLPerformanceVO searchVSLPerformance(VesselInformationMgtConditionVO vesselInformationMgtConditionVO, String sVesselSpeed) throws EventException {
		
		TrendLineBC fcmCommand	= new TrendLineBCImpl();
		
		try {
			VSLPerformanceVO 		vSLPerformanceVO 	= dbDao2.searchVSLPerformance(vesselInformationMgtConditionVO);
			List<LoadFactorListVO> 	loadFactorListVO 	= dbDao2.searchLoadFactorList(vesselInformationMgtConditionVO);
			vSLPerformanceVO.setLoadFactorListVOl(loadFactorListVO);
			
			String					sConvVesselSpeed	= sVesselSpeed == null || "".equals(sVesselSpeed) ? "0" : sVesselSpeed;
			
			//::jskjskjsk::2007816:://
			
			FcmTrndLineVO 			fcmTrndLineVO		= new FcmTrndLineVO();
			
			//::TrendLineDBDAOSearchAverageSlpValRSQL >> AND T1.NOON_RPT_DT BETWEEN TO_DATE(@[trnd_line_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[trnd_line_to_dt], 'YYYY-MM-DD')+0.99999:://
			//Calendar	calendar		= new GregorianCalendar(java.util.Locale.KOREA);
			Calendar	calendar1		= Calendar.getInstance();
			Calendar	calendar2		= Calendar.getInstance();
			calendar1.add(Calendar.MONTH, -12);
			
			String		sOneYearBfrYmd	= new SimpleDateFormat("yyyy-MM-dd").format(calendar1.getTime());
			String		sCurYmd			= new SimpleDateFormat("yyyy-MM-dd").format(calendar2.getTime()); 
			
			fcmTrndLineVO.setVslSlanCd		(vesselInformationMgtConditionVO.getHVslSlanCd	()	);
			fcmTrndLineVO.setVslCd			(vesselInformationMgtConditionVO.getVslCd		()	);
			fcmTrndLineVO.setTrndLineFmDt	(sOneYearBfrYmd										);	
			fcmTrndLineVO.setTrndLineToDt	(sCurYmd											);
			
			List<FcmNoonRptVO> 		fcmNoonRptVOs 		= fcmCommand.searchFcmTrndLineBasic	(fcmTrndLineVO			);
			// back data를 이용한 Trend Line 계수 계산 - List<FcmTrndLineVO> fcmTrndLineVOs = command.calcTrndLine(fcmNoonRptVOs, "0055");
			
			List<FcmTrndLineVO> 	fcmTrndLineVOs 		= fcmCommand.calcTrndLine			(fcmNoonRptVOs, "0055"	);	
			
			Double	totPfFocQty				= 0D;	//::SEA + IN PORT + MNVR FOC:://
			Double  inportPlusMnvrFocQty	= !"null".equals(vSLPerformanceVO.getPfFocQty()) && !"".equals(vSLPerformanceVO.getPfFocQty()) && vSLPerformanceVO.getPfFocQty() != null ? Double.parseDouble(vSLPerformanceVO.getPfFocQty()) : 0D;
			Double	dailySeaFocQty			= 0D;	//::DAILY SEA FOC:://
			Double  totSeaTimeHrs			= !"null".equals(vSLPerformanceVO.getTotSeaTimeHrs()) && !"".equals(vSLPerformanceVO.getTotSeaTimeHrs()) && vSLPerformanceVO.getTotSeaTimeHrs() != null ? Double.parseDouble(vSLPerformanceVO.getTotSeaTimeHrs()) : 0D;
			
			if(fcmTrndLineVOs != null && fcmTrndLineVOs.size() != 0){

				for(FcmTrndLineVO tmpVO : fcmTrndLineVOs){
					String sTrndLindChtTp	= tmpVO.getTrndLineChtTpCd();
					
					log.info("\n\n ::2007816:: vSLPerformanceVO.getPfSpd()	["+vSLPerformanceVO.getPfSpd()+"]\n");
					
					////Double 	pfAvdSpd	= !"null".equals(vSLPerformanceVO.getPfSpd()) && !"".equals(vSLPerformanceVO.getPfSpd()) && vSLPerformanceVO.getPfSpd() != null ? Double.parseDouble(vSLPerformanceVO.getPfSpd()) : 0D;
					Double 	dAvdSpd			= Double.parseDouble(sConvVesselSpeed);
					
					/********************************************************************************************
					 * :: [calculation rule] :: ref:return (coef2 * Math.pow(cspd, 2)) + (coef * cspd) + cons; -- (nCoef2 * Math.pow(nSpd, 2)) + (nCoef * nSpd) + nCons
					 * ------------------------------------------------------------------------------------------
					 * cons + (coef1 * P/F Speed) + (coef2 * POW(P/F Speed,2)
					 ********************************************************************************************/
						
					if("01".equals(sTrndLindChtTp)){
						
						Double	coef1	= Double.parseDouble(tmpVO.getN1stCoefVal		());
						Double	coef2	= Double.parseDouble(tmpVO.getN2ndCoefVal		());
						Double	cons	= Double.parseDouble(tmpVO.getTrndLineConsVal	());
						
						log.info("\n\n ::2007816:: getN1stCoefVal 		["+tmpVO.getN1stCoefVal		()+"]\n");
						log.info("\n\n ::2007816:: getN2ndCoefVal 		["+tmpVO.getN2ndCoefVal		()+"]\n");
						log.info("\n\n ::2007816:: getTrndLineConsVal 	["+tmpVO.getTrndLineConsVal	()+"]\n");
						
						dailySeaFocQty	= cons + (coef2 * dAvdSpd) + (coef1 * Math.pow(dAvdSpd,2)); 
						
						log.info("\n\n ::2007816:: dAvdSpd 		["+dAvdSpd+"]\n");
						log.info("\n\n ::2007816:: totSeaTimeHrs 	["+totSeaTimeHrs+"]\n");
						log.info("\n\n ::2007816:: (coef1 * dAvdSpd)	["+coef1 * dAvdSpd+"]\n");
						log.info("\n\n ::2007816:: Math.pow(dAvdSpd,2)	["+Math.pow(dAvdSpd,2)+"]\n");
						log.info("\n\n ::2007816:: coef2 * Math.pow(dAvdSpd,2)	["+coef2 * Math.pow(dAvdSpd,2)+"]\n");
						
					}
				}
			}
			
			log.info("\n\n ::2007816:: vSLPerformanceVO.getPfFocQty()	["+vSLPerformanceVO.getPfFocQty()+"]\n");
			log.info("\n\n ::2007816:: calculated daily >> seaFocQty	["+dailySeaFocQty+"]\n");
			log.info("\n\n ::2007816:: totSeaTimeHrs	["+totSeaTimeHrs+"]\n");
			
			String	sTotPfFocQty	= "";
			totPfFocQty				= inportPlusMnvrFocQty + dailySeaFocQty * (totSeaTimeHrs/24);
			sTotPfFocQty			= String.format("%.1f", totPfFocQty);

			log.info("\n\n =========== ::2007816:: ============= fcm trenline finished ============ \n");
			
			vSLPerformanceVO.setPfFocQty	(sTotPfFocQty						);
			vSLPerformanceVO.setDailyFocQty	(String.valueOf(dailySeaFocQty)		);
			vSLPerformanceVO.setHourlyFocQty(String.valueOf(dailySeaFocQty/24)	);
			
			return vSLPerformanceVO;
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
		}
	}
	
	
	
/*	public VSLPerformanceVO searchVSLPerformance(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException {
		
		TrendLineBC fcmCommand	= new TrendLineBCImpl();
		
		try {
			VSLPerformanceVO 		vSLPerformanceVO 	= dbDao2.searchVSLPerformance(vesselInformationMgtConditionVO);
			List<LoadFactorListVO> 	loadFactorListVO 	= dbDao2.searchLoadFactorList(vesselInformationMgtConditionVO);
			vSLPerformanceVO.setLoadFactorListVOl(loadFactorListVO);
			
			//::jskjskjsk::2007816:://
			
			FcmTrndLineVO 			fcmTrndLineVO		= new FcmTrndLineVO();
			
			//::TrendLineDBDAOSearchAverageSlpValRSQL >> AND T1.NOON_RPT_DT BETWEEN TO_DATE(@[trnd_line_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[trnd_line_to_dt], 'YYYY-MM-DD')+0.99999:://
			//Calendar	calendar		= new GregorianCalendar(java.util.Locale.KOREA);
			Calendar	calendar1		= Calendar.getInstance();
			Calendar	calendar2		= Calendar.getInstance();
			calendar1.add(Calendar.MONTH, -12);
			
			String		sOneYearBfrYmd	= new SimpleDateFormat("yyyy-MM-dd").format(calendar1.getTime());
			String		sCurYmd			= new SimpleDateFormat("yyyy-MM-dd").format(calendar2.getTime()); 
			
			fcmTrndLineVO.setVslSlanCd		(vesselInformationMgtConditionVO.getHVslSlanCd	()	);
			fcmTrndLineVO.setVslCd			(vesselInformationMgtConditionVO.getVslCd		()	);
			fcmTrndLineVO.setTrndLineFmDt	(sOneYearBfrYmd										);	
			fcmTrndLineVO.setTrndLineToDt	(sCurYmd											);
			
			List<FcmNoonRptVO> 		fcmNoonRptVOs 		= fcmCommand.searchFcmTrndLineBasic	(fcmTrndLineVO			);
			// back data를 이용한 Trend Line 계수 계산 - List<FcmTrndLineVO> fcmTrndLineVOs = command.calcTrndLine(fcmNoonRptVOs, "0055");
			
			List<FcmTrndLineVO> 	fcmTrndLineVOs 		= fcmCommand.calcTrndLine			(fcmNoonRptVOs, "0055"	);	
			
			Double	totPfFocQty				= 0D;	//::SEA + IN PORT + MNVR FOC:://
			Double  inportPlusMnvrFocQty	= !"null".equals(vSLPerformanceVO.getPfFocQty()) && !"".equals(vSLPerformanceVO.getPfFocQty()) && vSLPerformanceVO.getPfFocQty() != null ? Double.parseDouble(vSLPerformanceVO.getPfFocQty()) : 0D;
			Double	dailySeaFocQty			= 0D;	//::DAILY SEA FOC:://
			Double  totSeaTimeHrs			= !"null".equals(vSLPerformanceVO.getTotSeaTimeHrs()) && !"".equals(vSLPerformanceVO.getTotSeaTimeHrs()) && vSLPerformanceVO.getTotSeaTimeHrs() != null ? Double.parseDouble(vSLPerformanceVO.getTotSeaTimeHrs()) : 0D;
			
			if(fcmTrndLineVOs != null && fcmTrndLineVOs.size() != 0){

				for(FcmTrndLineVO tmpVO : fcmTrndLineVOs){
					String sTrndLindChtTp	= tmpVO.getTrndLineChtTpCd();
					
					log.info("\n\n ::2007816:: vSLPerformanceVO.getPfSpd()	["+vSLPerformanceVO.getPfSpd()+"]\n");
					
					Double 	pfAvdSpd	= !"null".equals(vSLPerformanceVO.getPfSpd()) && !"".equals(vSLPerformanceVO.getPfSpd()) && vSLPerformanceVO.getPfSpd() != null ? Double.parseDouble(vSLPerformanceVO.getPfSpd()) : 0D;
					
					*//********************************************************************************************
					 * :: [calculation rule] :: ref:return (coef2 * Math.pow(cspd, 2)) + (coef * cspd) + cons; -- (nCoef2 * Math.pow(nSpd, 2)) + (nCoef * nSpd) + nCons
					 * ------------------------------------------------------------------------------------------
					 * cons + (coef1 * P/F Speed) + (coef2 * POW(P/F Speed,2)
					 ********************************************************************************************//*
						
					if("01".equals(sTrndLindChtTp)){
						
						Double	coef1	= Double.parseDouble(tmpVO.getN1stCoefVal		());
						Double	coef2	= Double.parseDouble(tmpVO.getN2ndCoefVal		());
						Double	cons	= Double.parseDouble(tmpVO.getTrndLineConsVal	());
						
						log.info("\n\n ::2007816:: getN1stCoefVal 		["+tmpVO.getN1stCoefVal		()+"]\n");
						log.info("\n\n ::2007816:: getN2ndCoefVal 		["+tmpVO.getN2ndCoefVal		()+"]\n");
						log.info("\n\n ::2007816:: getTrndLineConsVal 	["+tmpVO.getTrndLineConsVal	()+"]\n");
						
						dailySeaFocQty	= cons + (coef2 * pfAvdSpd) + (coef1 * Math.pow(pfAvdSpd,2)); 
						
						log.info("\n\n ::2007816:: pfAvdSpd 		["+pfAvdSpd+"]\n");
						log.info("\n\n ::2007816:: totSeaTimeHrs 	["+totSeaTimeHrs+"]\n");
						log.info("\n\n ::2007816:: (coef1 * pfAvdSpd)	["+coef1 * pfAvdSpd+"]\n");
						log.info("\n\n ::2007816:: Math.pow(pfAvdSpd,2)	["+Math.pow(pfAvdSpd,2)+"]\n");
						log.info("\n\n ::2007816:: coef2 * Math.pow(pfAvdSpd,2)	["+coef2 * Math.pow(pfAvdSpd,2)+"]\n");
						
					}
				}
			}
			
			log.info("\n\n ::2007816:: vSLPerformanceVO.getPfFocQty()	["+vSLPerformanceVO.getPfFocQty()+"]\n");
			log.info("\n\n ::2007816:: calculated daily >> seaFocQty	["+dailySeaFocQty+"]\n");
			log.info("\n\n ::2007816:: totSeaTimeHrs	["+totSeaTimeHrs+"]\n");
			
			String	sTotPfFocQty	= "";
			totPfFocQty				= inportPlusMnvrFocQty + dailySeaFocQty * (totSeaTimeHrs/24);
			sTotPfFocQty			= String.format("%.1f", totPfFocQty);

			log.info("\n\n =========== ::2007816:: ============= fcm trenline finished ============ \n");
			
			vSLPerformanceVO.setPfFocQty	(sTotPfFocQty						);
			vSLPerformanceVO.setDailyFocQty	(String.valueOf(dailySeaFocQty)		);
			vSLPerformanceVO.setHourlyFocQty(String.valueOf(dailySeaFocQty/24)	);
			
			return vSLPerformanceVO;
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
		}
	}	
	*/
	
	
	
	/**
	 * VOP_VSK_0516 : Retrieve <br>
	 *  Vessel List 을 조회 합니다.<br>
	 * 
	 * @return List<VoyagePerformanceVO>
	 * @exception EventException
	 */
	public List<VoyagePerformanceVO> searchVesselList() throws EventException {
		try {
			return dbDao.searchVesselList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_VSK_0516 : Retrieve <br>
	 *  Vessel List 을 조회 합니다.<br>
	 * 
	 * @return List<VoyagePerformanceVO>
	 * @exception EventException
	 */
	public List<VoyagePerformanceVO> searchLanelList() throws EventException {
		try {
			return dbDao.searchLanelList();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_VSK_0516 : Retrieve <br>
	 * VVD 유효성을 체크 합니다.<br>
	 * 
	 * @param VoyagePerformanceVO voyagePerformanceVO
	 * @return List<VoyagePerformanceVO>
	 * @exception EventException
	 */
	public List<VoyagePerformanceVO> checkVvdInvalid(VoyagePerformanceVO voyagePerformanceVO) throws EventException {
		try {
			return dbDao.checkVvdInvalid(voyagePerformanceVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
		}
	}

	/**
	 * VOP_VSK_0516 : Retrieve <br>
	 *  VVD Port to Port 을 조회 합니다.<br>
	 * 
	 * @param VoyagePerformanceVO voyagePerformanceVO
	 * @return List<VoyagePerformanceVO>
	 * @exception EventException
	 */
	public List<VoyagePerformanceVO> searchPortToPort(VoyagePerformanceVO voyagePerformanceVO) throws EventException {
		try {
			return dbDao.searchPortToPort(voyagePerformanceVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Voyage Performance"}).getMessage(), ex);
		}
	}
	
}