/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : TrendLineBCImpl.java
 *@FileTitle : TrendLine
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.04
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.11.15 진마리아
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
=========================================================*/
package com.clt.apps.opus.vop.fcm.trendline.trendline.basic;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.vop.fcm.trendline.trendline.integration.TrendLineDBDAO;
import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.CalcTrndLineFormulaVO;
import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.CoefficientVO;
import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.FcmTrndLineRptMtchVO;
import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-TrendLine Business Logic Basic Command implementation<br>
 * - ALPS-TrendLine에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0051EventResponse,SimulationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TrendLineBCImpl extends BasicCommandSupport implements
		TrendLineBC {

	// Database Access Object
	private transient TrendLineDBDAO dbDao = null;

	/**
	 * VesselReportBCImpl 객체 생성<br>
	 * VesselReportBCDBDAO 생성한다.<br>
	 */
	public TrendLineBCImpl() {
		dbDao = new TrendLineDBDAO();
	}
	
	/**
	 * Trend Line 정보를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmTrndLineVO>
	 * @exception EventException
	 */
	public List<FcmTrndLineVO> searchFcmTrndLineList(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try{
			return dbDao.searchFcmTrndLineList(fcmTrndLineVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line List"}).getMessage(), ex);
		}
	}
	
	/**
	 * Trend Line 과 관련있는 Noon Report Matching 정보를 조회한다.
	 *  
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<FcmNoonRptVO>
	 * @exception EventException
	 */
	public List<FcmNoonRptVO> searchFcmTrndLineRptMtchList(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try {
			return dbDao.searchFcmTrndLineRptMtchList(fcmTrndLineVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Noon Report Match List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Noon Report Match List"}).getMessage(), ex);
		}
	}
	
	/**
	 * Trend Line 생성을 위한 정보를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmNoonRptVO>
	 * @exception EventException
	 */
	public List<FcmNoonRptVO> searchFcmTrndLineBasic(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try{
			 if(fcmTrndLineVO.getAvgSlpRt()==""){
				 fcmTrndLineVO.setAvgSlpRt("0");
			 }
			 String avgSlpRt = dbDao.searchAverageSlpVal(fcmTrndLineVO);
			 fcmTrndLineVO.setAvgSlpRt(avgSlpRt);
//			 fcmTrndLineVO.setSlpVal("10.3");
			 
			 return dbDao.searchNoonRptForTrndLine(fcmTrndLineVO);
			 
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Noon Report"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Noon Report"}).getMessage(), ex);
		}
	}

	
	/**
	 * Trend Line 기초 데이터를 이용하여 Trend Line을 구한다.<br>
	 * 
	 * @param List<FcmNoonRptVO> fcmNoonRptVOs
	 * @param String pgNo
	 * @return  List<FcmTrndLineVO>
	 * @exception EventException
	 */
	public List<FcmTrndLineVO> calcTrndLine(List<FcmNoonRptVO> fcmNoonRptVOs, String pgNo) throws EventException {
		try{
			if(fcmNoonRptVOs.size()>0){
				fcmNoonRptVOs = checkNullString(fcmNoonRptVOs); //sigma를 계산하기 위해서 필요한 컬럼들의 null값을 0으로 치환한다.
				CoefficientVO coefVO = calcSigmaValues(fcmNoonRptVOs); //각 chart의 x, y 값에 의한 sigma 값들을 구한다.
				Double[] dailyCsm = calcDailyCsm(fcmNoonRptVOs);
				String[] minMax = searchMinMaxSpd(fcmNoonRptVOs);
				List<FcmTrndLineVO> fcmTrndLineVOList = new ArrayList<FcmTrndLineVO>();
				CoefficientVO coefRsltVO = null;
				FcmTrndLineVO fcmTrndLineVO = null;
				
//				1. 각 chart에 해당하는 계수를 구한다.(calcTrendCoef method)
//				2. chart에 해당하는 결정계수를 구한다.
//				3. 구해진 계수 정보, 결정계수, 기타 정보를 fcmTrndLineVO 에 setting한다.
//				위 3가지를 chart별로 수행한다.
				
				//graph1 - C.SPD vs M/E FOC
				coefRsltVO = new CoefficientVO();
				fcmTrndLineVO = new FcmTrndLineVO();
				coefRsltVO.setTrndLineChtTpCd("01");
				coefRsltVO.setSigmaX(coefVO.getSigmaCalcSpd());
				coefRsltVO.setSigmaX2(coefVO.getSigmaCalcSpdSquare());
				coefRsltVO.setSigmaX3(coefVO.getSigmaCalcSpdCubed());
				coefRsltVO.setSigmaX4(coefVO.getSigmaCalcSpdFourth());
				coefRsltVO.setSigmaX2y(coefVO.getSigmaCalcSpdSquareMefoc());
				coefRsltVO.setSigmaXy(coefVO.getSigmaCalcSpdMefoc());
				coefRsltVO.setSigmaY(coefVO.getSigmaMefoc());
				coefRsltVO.setDataCnt(coefVO.getDataCnt());
				coefRsltVO = calcTrendCoef(coefRsltVO);
				Double variance = calcVar(coefRsltVO, fcmNoonRptVOs);
				
				fcmTrndLineVO.setTrndLineChtTpCd(coefRsltVO.getTrndLineChtTpCd());
				fcmTrndLineVO.setN1stCoefVal(String.format("%.15f", coefRsltVO.getCoef1()));
				fcmTrndLineVO.setN2ndCoefVal(String.format("%.15f", coefRsltVO.getCoef2()));
				fcmTrndLineVO.setTrndLineConsVal(String.format("%.15f", coefRsltVO.getCoef3()));
				fcmTrndLineVO.setAplySlpRt(fcmNoonRptVOs.get(0).getAplySlpRt());
				fcmTrndLineVO.setAvgSlpRt(fcmNoonRptVOs.get(0).getAvgSlpRt());
				fcmTrndLineVO.setAvgGnrCsmWgt(String.format("%.3f", dailyCsm[0]));
				fcmTrndLineVO.setAvgBlrCsmWgt(String.format("%.3f", dailyCsm[1]));
				fcmTrndLineVO.setOpMinSpd(minMax[0]);
				fcmTrndLineVO.setOpMaxSpd(minMax[1]);
				fcmTrndLineVO.setCoefOfDtmnVal(String.format("%.15f", variance));
				fcmTrndLineVOList.add(fcmTrndLineVO);
				
				//graph2 - A.SPD vs M/E FOC
				coefRsltVO = new CoefficientVO();
				fcmTrndLineVO = new FcmTrndLineVO();
				coefRsltVO.setTrndLineChtTpCd("02");
				coefRsltVO.setSigmaX(coefVO.getSigmaAvgSpd());
				coefRsltVO.setSigmaX2(coefVO.getSigmaAvgSpdSquare());
				coefRsltVO.setSigmaX3(coefVO.getSigmaAvgSpdCubed());
				coefRsltVO.setSigmaX4(coefVO.getSigmaAvgSpdFourth());
				coefRsltVO.setSigmaX2y(coefVO.getSigmaAvgSpdSquareMefoc());
				coefRsltVO.setSigmaXy(coefVO.getSigmaAvgSpdMefoc());
				coefRsltVO.setSigmaY(coefVO.getSigmaMefoc());
				coefRsltVO.setDataCnt(coefVO.getDataCnt());
				coefRsltVO = calcTrendCoef(coefRsltVO);
				variance = calcVar(coefRsltVO, fcmNoonRptVOs);
				
				fcmTrndLineVO.setTrndLineChtTpCd(coefRsltVO.getTrndLineChtTpCd());
				fcmTrndLineVO.setN1stCoefVal(String.format("%.15f", coefRsltVO.getCoef1()));
				fcmTrndLineVO.setN2ndCoefVal(String.format("%.15f", coefRsltVO.getCoef2()));
				fcmTrndLineVO.setTrndLineConsVal(String.format("%.15f", coefRsltVO.getCoef3()));
				fcmTrndLineVO.setAplySlpRt(fcmNoonRptVOs.get(0).getAplySlpRt());
				fcmTrndLineVO.setAvgSlpRt(fcmNoonRptVOs.get(0).getAvgSlpRt());
				fcmTrndLineVO.setAvgGnrCsmWgt(String.format("%.3f", dailyCsm[0]));
				fcmTrndLineVO.setAvgBlrCsmWgt(String.format("%.3f", dailyCsm[1]));
				fcmTrndLineVO.setOpMinSpd(minMax[0]);
				fcmTrndLineVO.setOpMaxSpd(minMax[1]);
				fcmTrndLineVO.setCoefOfDtmnVal(String.format("%.15f", variance));
				fcmTrndLineVOList.add(fcmTrndLineVO);
				
				//graph3 - C.SPD vs RPM
				coefRsltVO = new CoefficientVO();
				fcmTrndLineVO = new FcmTrndLineVO();
				coefRsltVO.setTrndLineChtTpCd("03");
				coefRsltVO.setSigmaX(coefVO.getSigmaCalcSpd());
				coefRsltVO.setSigmaX2(coefVO.getSigmaCalcSpdSquare());
				coefRsltVO.setSigmaX3(coefVO.getSigmaCalcSpdCubed());
				coefRsltVO.setSigmaX4(coefVO.getSigmaCalcSpdFourth());
				coefRsltVO.setSigmaX2y(coefVO.getSigmaCalcSpdSquareRpmPwr());
				coefRsltVO.setSigmaXy(coefVO.getSigmaCalcSpdRpmPwr());
				coefRsltVO.setSigmaY(coefVO.getSigmaRpmPwr());
				coefRsltVO.setDataCnt(coefVO.getDataCnt());
				coefRsltVO = calcTrendCoef(coefRsltVO);
				variance = calcVar(coefRsltVO, fcmNoonRptVOs);
				
				fcmTrndLineVO.setTrndLineChtTpCd(coefRsltVO.getTrndLineChtTpCd());
				fcmTrndLineVO.setN1stCoefVal(String.format("%.15f", coefRsltVO.getCoef1()));
				fcmTrndLineVO.setN2ndCoefVal(String.format("%.15f", coefRsltVO.getCoef2()));
				fcmTrndLineVO.setTrndLineConsVal(String.format("%.15f", coefRsltVO.getCoef3()));
				fcmTrndLineVO.setAplySlpRt(fcmNoonRptVOs.get(0).getAplySlpRt());
				fcmTrndLineVO.setAvgSlpRt(fcmNoonRptVOs.get(0).getAvgSlpRt());
				fcmTrndLineVO.setAvgGnrCsmWgt(String.format("%.3f", dailyCsm[0]));
				fcmTrndLineVO.setAvgBlrCsmWgt(String.format("%.3f", dailyCsm[1]));
				fcmTrndLineVO.setOpMinSpd(minMax[0]);
				fcmTrndLineVO.setOpMaxSpd(minMax[1]);
				fcmTrndLineVO.setCoefOfDtmnVal(String.format("%.15f", variance));
				fcmTrndLineVOList.add(fcmTrndLineVO);
				
				//graph4 - RPM vs M/E FOC
				coefRsltVO = new CoefficientVO();
				fcmTrndLineVO = new FcmTrndLineVO();
				coefRsltVO.setTrndLineChtTpCd("04");
				coefRsltVO.setSigmaX(coefVO.getSigmaRpmPwr());
				coefRsltVO.setSigmaX2(coefVO.getSigmaRpmPwrSquare());
				coefRsltVO.setSigmaX3(coefVO.getSigmaRpmPwrCubed());
				coefRsltVO.setSigmaX4(coefVO.getSigmaRpmPwrFourth());
				coefRsltVO.setSigmaX2y(coefVO.getSigmaRpmPwrSquareMefoc());
				coefRsltVO.setSigmaXy(coefVO.getSigmaRpmPwrMefoc());
				coefRsltVO.setSigmaY(coefVO.getSigmaMefoc());
				coefRsltVO.setDataCnt(coefVO.getDataCnt());
				coefRsltVO = calcTrendCoef(coefRsltVO);
				variance = calcVar(coefRsltVO, fcmNoonRptVOs);
				
				fcmTrndLineVO.setTrndLineChtTpCd(coefRsltVO.getTrndLineChtTpCd());
				fcmTrndLineVO.setN1stCoefVal(String.format("%.15f", coefRsltVO.getCoef1()));
				fcmTrndLineVO.setN2ndCoefVal(String.format("%.15f", coefRsltVO.getCoef2()));
				fcmTrndLineVO.setTrndLineConsVal(String.format("%.15f", coefRsltVO.getCoef3()));
				fcmTrndLineVO.setAplySlpRt(fcmNoonRptVOs.get(0).getAplySlpRt());
				fcmTrndLineVO.setAvgSlpRt(fcmNoonRptVOs.get(0).getAvgSlpRt());
				fcmTrndLineVO.setAvgGnrCsmWgt(String.format("%.3f", dailyCsm[0]));
				fcmTrndLineVO.setAvgBlrCsmWgt(String.format("%.3f", dailyCsm[1]));
				fcmTrndLineVO.setOpMinSpd(minMax[0]);
				fcmTrndLineVO.setOpMaxSpd(minMax[1]);
				fcmTrndLineVO.setCoefOfDtmnVal(String.format("%.15f", variance));
				fcmTrndLineVOList.add(fcmTrndLineVO);
				
				if("0055".equals(pgNo)){
					//Load를 이용하는 chart의 경우, raw data set을 단독으로 한다.
					coefVO = calcSigmaValuesLoad(fcmNoonRptVOs); //Load 관련 chart의 x, y 값에 의한 sigma 값들을 구한다.
				}
				
				//graph5 - LOAD vs M/E FOC
				coefRsltVO = new CoefficientVO();
				fcmTrndLineVO = new FcmTrndLineVO();
				coefRsltVO.setTrndLineChtTpCd("05");
				coefRsltVO.setSigmaX(coefVO.getSigmaLoad());
				coefRsltVO.setSigmaX2(coefVO.getSigmaLoadSquare());
				coefRsltVO.setSigmaX3(coefVO.getSigmaLoadCubed());
				coefRsltVO.setSigmaX4(coefVO.getSigmaLoadFourth());
				coefRsltVO.setSigmaX2y(coefVO.getSigmaLoadSquareMefoc());
				coefRsltVO.setSigmaXy(coefVO.getSigmaLoadMefoc());
				coefRsltVO.setSigmaY(coefVO.getSigmaMefoc());
				coefRsltVO.setDataCnt(coefVO.getDataCnt());
				coefRsltVO = calcTrendCoef(coefRsltVO);
				variance = calcVar(coefRsltVO, fcmNoonRptVOs);
				
				fcmTrndLineVO.setTrndLineChtTpCd(coefRsltVO.getTrndLineChtTpCd());
				fcmTrndLineVO.setN1stCoefVal(String.format("%.15f", coefRsltVO.getCoef1()));
				fcmTrndLineVO.setN2ndCoefVal(String.format("%.15f", coefRsltVO.getCoef2()));
				fcmTrndLineVO.setTrndLineConsVal(String.format("%.15f", coefRsltVO.getCoef3()));
				fcmTrndLineVO.setAplySlpRt(fcmNoonRptVOs.get(0).getAplySlpRt());
				fcmTrndLineVO.setAvgSlpRt(fcmNoonRptVOs.get(0).getAvgSlpRt());
				fcmTrndLineVO.setAvgGnrCsmWgt(String.format("%.3f", dailyCsm[0]));
				fcmTrndLineVO.setAvgBlrCsmWgt(String.format("%.3f", dailyCsm[1]));
				fcmTrndLineVO.setOpMinSpd(minMax[0]);
				fcmTrndLineVO.setOpMaxSpd(minMax[1]);
				fcmTrndLineVO.setCoefOfDtmnVal(String.format("%.15f", variance));
				fcmTrndLineVOList.add(fcmTrndLineVO);
				
				//graph6 - C.SPD vs LOAD
				coefRsltVO = new CoefficientVO();
				fcmTrndLineVO = new FcmTrndLineVO();
				coefRsltVO.setTrndLineChtTpCd("06");
				coefRsltVO.setSigmaX(coefVO.getSigmaCalcSpd());
				coefRsltVO.setSigmaX2(coefVO.getSigmaCalcSpdSquare());
				coefRsltVO.setSigmaX3(coefVO.getSigmaCalcSpdCubed());
				coefRsltVO.setSigmaX4(coefVO.getSigmaCalcSpdFourth());
				coefRsltVO.setSigmaX2y(coefVO.getSigmaCalcSpdSquareLoad());
				coefRsltVO.setSigmaXy(coefVO.getSigmaCalcSpdLoad());
				coefRsltVO.setSigmaY(coefVO.getSigmaLoad());
				coefRsltVO.setDataCnt(coefVO.getDataCnt());
				coefRsltVO = calcTrendCoef(coefRsltVO);
				variance = calcVar(coefRsltVO, fcmNoonRptVOs);
				
				fcmTrndLineVO.setTrndLineChtTpCd(coefRsltVO.getTrndLineChtTpCd());
				fcmTrndLineVO.setN1stCoefVal(String.format("%.15f", coefRsltVO.getCoef1()));
				fcmTrndLineVO.setN2ndCoefVal(String.format("%.15f", coefRsltVO.getCoef2()));
				fcmTrndLineVO.setTrndLineConsVal(String.format("%.15f", coefRsltVO.getCoef3()));
				fcmTrndLineVO.setAplySlpRt(fcmNoonRptVOs.get(0).getAplySlpRt());
				fcmTrndLineVO.setAvgSlpRt(fcmNoonRptVOs.get(0).getAvgSlpRt());
				fcmTrndLineVO.setAvgGnrCsmWgt(String.format("%.3f", dailyCsm[0]));
				fcmTrndLineVO.setAvgBlrCsmWgt(String.format("%.3f", dailyCsm[1]));
				fcmTrndLineVO.setOpMinSpd(minMax[0]);
				fcmTrndLineVO.setOpMaxSpd(minMax[1]);
				fcmTrndLineVO.setCoefOfDtmnVal(String.format("%.15f", variance));
				fcmTrndLineVOList.add(fcmTrndLineVO);
				
				return fcmTrndLineVOList;
			}else{
				return null;
			}
		} catch (EventException ex) {
            throw new EventException(new ErrorHandler("COM12215", new String[]{"Trend Line"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12215", new String[]{"Trend Line"}).getMessage(), ex);
		}
	}

	/**
	 * Trend Line 기초 데이터의 각 sigma 값을 구한다.<br>
	 * 
	 * @param List<FcmNoonRptVO> fcmNoonRptVOs
	 * @return  CoefficientVO
	 */
	private CoefficientVO calcSigmaValues(List<FcmNoonRptVO> fcmNoonRptVOs) {
		
		int cnt = fcmNoonRptVOs.size();
		int dataCnt = 0; 
		//C.Spd - CALC_SPD
		Double sigmaCalcSpd = 0.0;
		Double sigmaCalcSpdSquare = 0.0;
		Double sigmaCalcSpdCubed = 0.0;
		Double sigmaCalcSpdFourth = 0.0;

		//A.Spd - SAIL_AVG_SPD
		Double sigmaAvgSpd = 0.0;
		Double sigmaAvgSpdSquare = 0.0;
		Double sigmaAvgSpdCubed = 0.0;
		Double sigmaAvgSpdFourth = 0.0;
		
		//RPM - SAIL_AVG_RPM_PWR
		Double sigmaRpmPwr = 0.0;
		Double sigmaRpmPwrSquare = 0.0;
		Double sigmaRpmPwrCubed = 0.0;
		Double sigmaRpmPwrFourth = 0.0;
		
		//LOAD
		Double sigmaLoad = 0.0;
		Double sigmaLoadSquare = 0.0;
		Double sigmaLoadCubed = 0.0;
		Double sigmaLoadFourth = 0.0;

		//Y절편 관련 데이터 - MN_FOIL_CSM_QTY
		Double sigmaCalcSpdSquareMefoc = 0.0;
		Double sigmaCalcSpdMefoc = 0.0;
		Double sigmaMefoc = 0.0;
		Double sigmaAvgSpdSquareMefoc = 0.0;
		Double sigmaAvgSpdMefoc = 0.0;
		Double sigmaCalcSpdSquareRpmPwr = 0.0;
		Double sigmaCalcSpdRpmPwr = 0.0;
		Double sigmaRpmPwrSquareMefoc = 0.0;
		Double sigmaRpmPwrMefoc = 0.0;
		
		Double sigmaLoadSquareMefoc = 0.0;
		Double sigmaLoadMefoc = 0.0;
		Double sigmaCalcSpdSquareLoad = 0.0;
		Double sigmaCalcSpdLoad = 0.0;
		
		for(int i=0; i<cnt; i++){
			if((!"Y".equals(fcmNoonRptVOs.get(i).getTrndLineXcldFlg()))){
				dataCnt++;
				sigmaCalcSpd = sigmaCalcSpd + Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd());
				sigmaCalcSpdSquare = sigmaCalcSpdSquare + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()));
				sigmaCalcSpdCubed = sigmaCalcSpdCubed + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()));
				sigmaCalcSpdFourth = sigmaCalcSpdFourth + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()));
				
				sigmaAvgSpd = sigmaAvgSpd + Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd());
				sigmaAvgSpdSquare = sigmaAvgSpdSquare + (Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()));
				sigmaAvgSpdCubed = sigmaAvgSpdCubed + (Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()));
				sigmaAvgSpdFourth = sigmaAvgSpdFourth + (Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()));
				
				sigmaRpmPwr = sigmaRpmPwr + Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr());
				sigmaRpmPwrSquare = sigmaRpmPwrSquare + (Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()));
				sigmaRpmPwrCubed = sigmaRpmPwrCubed + (Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()));
				sigmaRpmPwrFourth = sigmaRpmPwrFourth + (Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()));
				
				sigmaLoad = sigmaLoad + Double.parseDouble(fcmNoonRptVOs.get(i).getLoad());
				sigmaLoadSquare = sigmaLoadSquare + (Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()));
				sigmaLoadCubed = sigmaLoadCubed + (Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()));
				sigmaLoadFourth = sigmaLoadFourth + (Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()));
				
				//c.spd vs m/e foc
				sigmaCalcSpdSquareMefoc = sigmaCalcSpdSquareMefoc + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty()));
				sigmaCalcSpdMefoc = sigmaCalcSpdMefoc + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty()));
				sigmaMefoc = sigmaMefoc + Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty());
				
				//a.spd vs m/e foc
				sigmaAvgSpdSquareMefoc = sigmaAvgSpdSquareMefoc + (Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty()));
				sigmaAvgSpdMefoc = sigmaAvgSpdMefoc + (Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty()));
				
				//c.spd vs rpm
				sigmaCalcSpdSquareRpmPwr = sigmaCalcSpdSquareRpmPwr + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()));
				sigmaCalcSpdRpmPwr = sigmaCalcSpdRpmPwr + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()));
				
				//rpm vs m/e foc
				sigmaRpmPwrSquareMefoc = sigmaRpmPwrSquareMefoc + (Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty()));
				sigmaRpmPwrMefoc = sigmaRpmPwrMefoc + (Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty()));
				
				//lod vs m/e foc
				sigmaLoadSquareMefoc = sigmaLoadSquareMefoc + (Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty()));
				sigmaLoadMefoc = sigmaLoadMefoc + (Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty()));
				
				//c.spd vs lod
				sigmaCalcSpdSquareLoad = sigmaCalcSpdSquareLoad + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()));
				sigmaCalcSpdLoad = sigmaCalcSpdLoad + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()));
			}
		}
		
		CoefficientVO coefVO = new CoefficientVO();
		coefVO.setDataCnt(dataCnt);
		coefVO.setSigmaCalcSpd(sigmaCalcSpd);
		coefVO.setSigmaCalcSpdSquare(sigmaCalcSpdSquare);
		coefVO.setSigmaCalcSpdCubed(sigmaCalcSpdCubed);
		coefVO.setSigmaCalcSpdFourth(sigmaCalcSpdFourth);
		coefVO.setSigmaAvgSpd(sigmaAvgSpd);
		coefVO.setSigmaAvgSpdSquare(sigmaAvgSpdSquare);
		coefVO.setSigmaAvgSpdCubed(sigmaAvgSpdCubed);
		coefVO.setSigmaAvgSpdFourth(sigmaAvgSpdFourth);
		coefVO.setSigmaRpmPwr(sigmaRpmPwr);
		coefVO.setSigmaRpmPwrSquare(sigmaRpmPwrSquare);
		coefVO.setSigmaRpmPwrCubed(sigmaRpmPwrCubed);
		coefVO.setSigmaRpmPwrFourth(sigmaRpmPwrFourth);
		coefVO.setSigmaLoad(sigmaLoad);
		coefVO.setSigmaLoadSquare(sigmaLoadSquare);
		coefVO.setSigmaLoadCubed(sigmaLoadCubed);
		coefVO.setSigmaLoadFourth(sigmaLoadFourth);
		coefVO.setSigmaCalcSpdSquareMefoc(sigmaCalcSpdSquareMefoc);
		coefVO.setSigmaCalcSpdMefoc(sigmaCalcSpdMefoc);
		coefVO.setSigmaMefoc(sigmaMefoc);
		coefVO.setSigmaAvgSpdSquareMefoc(sigmaAvgSpdSquareMefoc);
		coefVO.setSigmaAvgSpdMefoc(sigmaAvgSpdMefoc);
		coefVO.setSigmaCalcSpdSquareRpmPwr(sigmaCalcSpdSquareRpmPwr);
		coefVO.setSigmaCalcSpdRpmPwr(sigmaCalcSpdRpmPwr);
		coefVO.setSigmaRpmPwrSquareMefoc(sigmaRpmPwrSquareMefoc);
		coefVO.setSigmaRpmPwrMefoc(sigmaRpmPwrMefoc);
		coefVO.setSigmaLoadSquareMefoc(sigmaLoadSquareMefoc);
		coefVO.setSigmaLoadMefoc(sigmaLoadMefoc);
		coefVO.setSigmaCalcSpdSquareLoad(sigmaCalcSpdSquareLoad);
		coefVO.setSigmaCalcSpdLoad(sigmaCalcSpdLoad);
		
		return coefVO;
	}
	
	/**
	 * Load 관련 Trend Line 을 위해 각 sigma 값을 구한다.<br>
	 * 
	 * @param List<FcmNoonRptVO> fcmNoonRptVOs
	 * @return  CoefficientVO
	 */
	private CoefficientVO calcSigmaValuesLoad(List<FcmNoonRptVO> fcmNoonRptVOs) {
		int cnt = fcmNoonRptVOs.size();
		int dataCnt = 0; 
		
		//C.Spd - CALC_SPD
		Double sigmaCalcSpd = 0.0;
		Double sigmaCalcSpdSquare = 0.0;
		Double sigmaCalcSpdCubed = 0.0;
		Double sigmaCalcSpdFourth = 0.0;
		
		//LOAD
		Double sigmaLoad = 0.0;
		Double sigmaLoadSquare = 0.0;
		Double sigmaLoadCubed = 0.0;
		Double sigmaLoadFourth = 0.0;
		
		Double sigmaCalcSpdSquareLoad = 0.0;
		Double sigmaCalcSpdLoad = 0.0;
		Double sigmaLoadSquareMefoc = 0.0;
		Double sigmaLoadMefoc = 0.0;
		Double sigmaMefoc = 0.0;
		
		for(int i=0; i<cnt; i++){
			if((!"Y".equals(fcmNoonRptVOs.get(i).getTrndLineXcldFlg())) && "Y".equals(fcmNoonRptVOs.get(i).getLoadUseFlg())){
				dataCnt++;
				
				sigmaCalcSpd = sigmaCalcSpd + Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd());
				sigmaCalcSpdSquare = sigmaCalcSpdSquare + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()));
				sigmaCalcSpdCubed = sigmaCalcSpdCubed + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()));
				sigmaCalcSpdFourth = sigmaCalcSpdFourth + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()));
				
				sigmaLoad = sigmaLoad + Double.parseDouble(fcmNoonRptVOs.get(i).getLoad());
				sigmaLoadSquare = sigmaLoadSquare + (Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()));
				sigmaLoadCubed = sigmaLoadCubed + (Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()));
				sigmaLoadFourth = sigmaLoadFourth + (Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()));
				
				//c.spd vs load
				sigmaCalcSpdSquareLoad = sigmaCalcSpdSquareLoad + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()));
				sigmaCalcSpdLoad = sigmaCalcSpdLoad + (Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()));
				
				//load vs m/e foc
				sigmaLoadSquareMefoc = sigmaLoadSquareMefoc + (Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty()));
				sigmaLoadMefoc = sigmaLoadMefoc + (Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()))*(Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty()));
				sigmaMefoc = sigmaMefoc + Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty());
				
			}
		}
		
		CoefficientVO coefVO = new CoefficientVO();
		coefVO.setDataCnt(dataCnt);
		coefVO.setSigmaCalcSpd(sigmaCalcSpd);
		coefVO.setSigmaCalcSpdSquare(sigmaCalcSpdSquare);
		coefVO.setSigmaCalcSpdCubed(sigmaCalcSpdCubed);
		coefVO.setSigmaCalcSpdFourth(sigmaCalcSpdFourth);
		coefVO.setSigmaLoad(sigmaLoad);
		coefVO.setSigmaLoadSquare(sigmaLoadSquare);
		coefVO.setSigmaLoadCubed(sigmaLoadCubed);
		coefVO.setSigmaLoadFourth(sigmaLoadFourth);
		coefVO.setSigmaLoadSquareMefoc(sigmaLoadSquareMefoc);
		coefVO.setSigmaLoadMefoc(sigmaLoadMefoc);
		coefVO.setSigmaMefoc(sigmaMefoc);
		coefVO.setSigmaCalcSpdSquareLoad(sigmaCalcSpdSquareLoad);
		coefVO.setSigmaCalcSpdLoad(sigmaCalcSpdLoad);
		
		return coefVO;
	}
	
	/**
	 * 3*3 행렬의 역행렬을 이용하여 trend line 함수의 계수를 구한다.<br>
	 * 
	 * @param CoefficientVO coefVO
	 * @return  CoefficientVO
	 */
	private CoefficientVO calcTrendCoef(CoefficientVO coefVO) {
		
		if(coefVO!=null){
			Double k = coefVO.getSigmaX();
			Double k2 = coefVO.getSigmaX2();
			Double k3 = coefVO.getSigmaX3();
			Double k4 = coefVO.getSigmaX4();
			int cnt = coefVO.getDataCnt();
			Double sigmaX2y = coefVO.getSigmaX2y();
			Double sigmaXy = coefVO.getSigmaXy();
			Double sigmaY = coefVO.getSigmaY();
			
			Double D = k4*k2*cnt + 2*k3*k2*k - k2*k2*k2 - k3*k3*cnt - k*k*k4;
			
			Double a = 1/D * ((k2*cnt-k*k)*sigmaX2y + (k*k2-cnt*k3)*sigmaXy + (k3*k-k2*k2)*sigmaY);
			Double b = 1/D * ((k*k2-cnt*k3)*sigmaX2y + (k4*cnt-k2*k2)*sigmaXy + (k2*k3-k4*k)*sigmaY);
			Double c = 1/D * ((k3*k-k2*k2)*sigmaX2y + (k2*k3-k4*k)*sigmaXy + (k4*k2-k3*k3)*sigmaY);
			
			coefVO.setCoef1(a);
			coefVO.setCoef2(b);
			coefVO.setCoef3(c);
		}
		return coefVO;
	}

	
	/**
	 * 해당 기간의 Noon Rpt가 존재하는 Lane, Vessel, Design Cap.를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<String[]>
	 * @exception EventException
	 */
	public List<String[]> searchLaneVslCapa(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try{
			String trndLineTpCd = fcmTrndLineVO.getTrndLineTpCd();
			String[] arrCapa = null;
			String[] arrSubClass = null;
			String[] arrLane = null;
			String[] arrVsl = null;
			String[] arrDirCd = null;
			
			if("1".equals(trndLineTpCd)||"2".equals(trndLineTpCd)){
				if("".equals(fcmTrndLineVO.getVslClssCd())){
					arrCapa = dbDao.searchDznCapaByNoonRpt(fcmTrndLineVO);
				}
				if("".equals(fcmTrndLineVO.getVslClssSubCd())){
					arrSubClass = dbDao.searchSubClassByNoonRpt(fcmTrndLineVO);
				}
				if("".equals(fcmTrndLineVO.getVslSlanCd())){
					arrLane = dbDao.searchLaneByNoonRpt(fcmTrndLineVO);
				}
			}else{
				if("".equals(fcmTrndLineVO.getVslCd())){
					arrVsl = dbDao.searchVslByNoonRpt(fcmTrndLineVO);
				}
				if("".equals(fcmTrndLineVO.getSkdDirCd())){
					arrDirCd = dbDao.searchDirCdByNoonRpt(fcmTrndLineVO);
				}
			}
			 
			List<String[]> list = new ArrayList<String[]>();
			list.add(arrCapa);
			list.add(arrSubClass);
			list.add(arrLane);
			list.add(arrVsl);
			list.add(arrDirCd);
			 
			 return list;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Item"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Item"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 조회한 기초 데이터에 null 이 없도록 한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmNoonRptVO>
	 * @exception EventException
	 */
	private List<FcmNoonRptVO> checkNullString(List<FcmNoonRptVO> fcmTrndLineVOs) throws EventException {
		try{
			int cnt = fcmTrndLineVOs.size();
			for(int i=0; i<cnt; i++){
				if(fcmTrndLineVOs.get(i).getCalcSpd()==null || "".equals(fcmTrndLineVOs.get(i).getCalcSpd())){
					fcmTrndLineVOs.get(i).setCalcSpd("0");
				}
				if(fcmTrndLineVOs.get(i).getSailAvgSpd()==null || "".equals(fcmTrndLineVOs.get(i).getSailAvgSpd())){
					fcmTrndLineVOs.get(i).setSailAvgSpd("0");
				}
//				if(fcmTrndLineVOs.get(i).getMnFoilCsmQty()==null || "".equals(fcmTrndLineVOs.get(i).getMnFoilCsmQty())){
//					fcmTrndLineVOs.get(i).setMnFoilCsmQty("0");
//				}
				if(fcmTrndLineVOs.get(i).getDayMnFoilCsmQty()==null || "".equals(fcmTrndLineVOs.get(i).getDayMnFoilCsmQty())){
					fcmTrndLineVOs.get(i).setDayMnFoilCsmQty("0");
				}
				if(fcmTrndLineVOs.get(i).getSailAvgRpmPwr()==null || "".equals(fcmTrndLineVOs.get(i).getSailAvgRpmPwr())){
					fcmTrndLineVOs.get(i).setSailAvgRpmPwr("0");
				}
				if(fcmTrndLineVOs.get(i).getDayGnrFoilCsmQty()==null || "".equals(fcmTrndLineVOs.get(i).getDayGnrFoilCsmQty())){
					fcmTrndLineVOs.get(i).setDayGnrFoilCsmQty("0");
				}
				if(fcmTrndLineVOs.get(i).getDayBlrFoilCsmQty()==null || "".equals(fcmTrndLineVOs.get(i).getDayBlrFoilCsmQty())){
					fcmTrndLineVOs.get(i).setDayBlrFoilCsmQty("0");
				}
				if(fcmTrndLineVOs.get(i).getLoad()==null || "".equals(fcmTrndLineVOs.get(i).getLoad())){
					fcmTrndLineVOs.get(i).setLoad("0");
				}
			}
			return fcmTrndLineVOs;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Check Null String"}).getMessage(), ex);
		}
	}
	
	/**
	 * Daily Consumption(GE, BLR) 값을 구한다.<br>
	 * 
	 * @param List<FcmNoonRptVO> fcmNoonRptVOs
	 * @return  Double[]
	 */
	private Double[] calcDailyCsm(List<FcmNoonRptVO> fcmNoonRptVOs) {
		
		int cnt = fcmNoonRptVOs.size();
		int dataCnt = 0;
		Double avg_gnr_csm_wgt = 0.0;
//		Double avg_blr_csm_wgt = 0.0; //2012.01.26 Cause BLR data is almost incorrect, use 70% of GE.
		
		for(int i=0; i<cnt; i++){
			if((!"Y".equals(fcmNoonRptVOs.get(i).getTrndLineXcldFlg()))){
				dataCnt++;
				avg_gnr_csm_wgt = avg_gnr_csm_wgt + Double.parseDouble(fcmNoonRptVOs.get(i).getDayGnrFoilCsmQty());
//				avg_blr_csm_wgt = avg_blr_csm_wgt + Double.parseDouble(fcmNoonRptVOs.get(i).getDayBlrFoilCsmQty());
			}
		}
		
		if(dataCnt>0){
			avg_gnr_csm_wgt = avg_gnr_csm_wgt / dataCnt;
//			avg_blr_csm_wgt = avg_blr_csm_wgt / dataCnt;
		}
		
		Double arr[] = new Double[2];
		arr[0] = avg_gnr_csm_wgt;
//		arr[1] = avg_blr_csm_wgt;
		arr[1] = avg_gnr_csm_wgt*0.7;
		
		return arr;
	}
	
	/**
	 * Trnd Line을 생성합니다.<br>
	 * 
	 * @param FcmTrndLineVO HdrTrndLineVO
	 * @param FcmNoonRptVO[] rawDataVOs
	 * @param FcmTrndLineVO[] RsltTrndLineVOs
	 * @param SignOnUserAccount account
	 * @return String[]
	 * @exception EventException
	 */
	public String[] manageTrndLine(FcmTrndLineVO hdrTrndLineVO, FcmNoonRptVO[] rawDataVOs, FcmTrndLineVO[] rsltTrndLineVOs, SignOnUserAccount account) throws EventException {
		String[] trndLineNo = new String[2];
		try {

			String maxTrndLineTpSubCd = dbDao.searchMaxTrndLineTpSubCd(hdrTrndLineVO);
			
			//FCM_TRND_LINE에 CHT 한 개에 대한 데이터가 INSERT된 후, 해당 데이터의 TRND_LINE_SEQ에 대해 RPT_MTCH가 INSERT되야 함.
			for(int i=0; i<rsltTrndLineVOs.length; i++){
				rsltTrndLineVOs[i].setTrndLineUseTpCd(hdrTrndLineVO.getTrndLineUseTpCd());
				rsltTrndLineVOs[i].setTrndLineTpCd(hdrTrndLineVO.getTrndLineTpCd());
				rsltTrndLineVOs[i].setTrndLineFmDt(hdrTrndLineVO.getTrndLineFmDt());
				rsltTrndLineVOs[i].setTrndLineToDt(hdrTrndLineVO.getTrndLineToDt());
				rsltTrndLineVOs[i].setVslClssCd(hdrTrndLineVO.getVslClssCd());
				rsltTrndLineVOs[i].setVslClssSubCd(hdrTrndLineVO.getVslClssSubCd());
				rsltTrndLineVOs[i].setVslSlanCd(hdrTrndLineVO.getVslSlanCd());
				rsltTrndLineVOs[i].setVslCd(hdrTrndLineVO.getVslCd());
				rsltTrndLineVOs[i].setSkdDirCd(hdrTrndLineVO.getSkdDirCd());
				rsltTrndLineVOs[i].setAvgSlpOptRt(hdrTrndLineVO.getAvgSlpOptRt());
				rsltTrndLineVOs[i].setTrndLineRmk(hdrTrndLineVO.getTrndLineRmk());
				rsltTrndLineVOs[i].setCreUsrId(account.getUsr_id());
				rsltTrndLineVOs[i].setUpdUsrId(account.getUsr_id());
				rsltTrndLineVOs[i].setTrndLineTpSubCd(maxTrndLineTpSubCd);
				dbDao.addTrndLine(rsltTrndLineVOs[i]); //FCM_TRND_LINE
				
				List<FcmTrndLineRptMtchVO> arrMtchTrndLineVOs = new ArrayList<FcmTrndLineRptMtchVO>();
				for(int k=0; k<rawDataVOs.length; k++){
					if("Y".equals(rawDataVOs[k].getTrndLineXcldFlg())){
						FcmTrndLineRptMtchVO mtchVO = new FcmTrndLineRptMtchVO();
						mtchVO.setVslCd(rawDataVOs[k].getVslCd());
						mtchVO.setSkdVoyNo(rawDataVOs[k].getSkdVoyNo());
						mtchVO.setSkdDirCd(rawDataVOs[k].getSkdDirCd());
						mtchVO.setNoonRptDt(rawDataVOs[k].getNoonRptDt());
						mtchVO.setTrndLineXcldFlg(rawDataVOs[k].getTrndLineXcldFlg());
						mtchVO.setUpdUsrId(account.getUsr_id());
						mtchVO.setCreUsrId(account.getUsr_id());
						arrMtchTrndLineVOs.add(mtchVO);
					}
				}
				dbDao.addTrndLineRptMtch(arrMtchTrndLineVOs);
			}
			
			String todayYm;
			Date today=new Date();
			SimpleDateFormat formater = new SimpleDateFormat("yyMM");
			todayYm = formater.format(today);
			
			trndLineNo[0] = hdrTrndLineVO.getTrndLineUseTpCd() +"-"+ hdrTrndLineVO.getTrndLineTpCd() +"-"+ hdrTrndLineVO.getVslClssCd()
			                  + hdrTrndLineVO.getVslClssSubCd() + hdrTrndLineVO.getVslSlanCd() + hdrTrndLineVO.getVslCd()
			                  + hdrTrndLineVO.getSkdDirCd() +"-"+ todayYm + maxTrndLineTpSubCd;
			trndLineNo[1] = maxTrndLineTpSubCd;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Trend Line"}).getMessage(), ex);
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Trend Line"}).getMessage(), ex);
		}
		return trndLineNo;
	}
	
	/**
	 * Trend Line 정보를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmTrndLineVO>
	 * @exception EventException
	 */
	public List<FcmTrndLineVO> searchFcmTrndLinePopupList(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try{
			return dbDao.searchFcmTrndLinePopupList(fcmTrndLineVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line List"}).getMessage(), ex);
		}
	}
	
	/**
	 * 기생성된 Trend Line 정보를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmTrndLineVO>
	 * @exception EventException
	 */
	public List<FcmTrndLineVO> searchFcmTrndLineForInq(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try{
			return dbDao.searchFcmTrndLineForInq(fcmTrndLineVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line"}).getMessage(), ex);
		}
	}
	
	/**
	 * 기생성된 Trend Line 의 raw data를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return  List<FcmNoonRptVO>
	 * @exception EventException
	 */
	public List<FcmNoonRptVO> searchFcmTrndLineRawDataForInq(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try{
			return dbDao.searchFcmTrndLineRawDataForInq(fcmTrndLineVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Raw Data"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Raw Data"}).getMessage(), ex);
		}
	}
	
	/**
	 * Trnd Line을 삭제합니다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @exception EventException
	 */
	public void removeTrndLine(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try{
			dbDao.removeTrndLineRptMtch(fcmTrndLineVO);
			dbDao.removeTrndLine(fcmTrndLineVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12197", new String[]{"Trend Line"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12197", new String[]{"Trend Line"}).getMessage(), ex);
		}
	}
	
	/**
	 * trend line 함수의 R(결정계수)를 구한다.<br>
	 * 
	 * @param CoefficientVO coefVO
	 * @return  CoefficientVO
	 */
	private Double calcVar(CoefficientVO coefRsltVO, List<FcmNoonRptVO> fcmNoonRptVOs) {
		
		Double upRsquare = 0.0;
		Double downRsquare = 0.0;
		
		for(int i=0; i<fcmNoonRptVOs.size(); i++){
			if(!"Y".equals(fcmNoonRptVOs.get(i).getTrndLineXcldFlg())){
				Double yi = 0.0;
				Double ybar = 0.0;
				Double fxi = 0.0;
				
				if("01".equals(coefRsltVO.getTrndLineChtTpCd())){
					yi=Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty());
					ybar=coefRsltVO.getSigmaY()/coefRsltVO.getDataCnt();
					fxi=coefRsltVO.getCoef1() * Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd())*Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd())
					   + coefRsltVO.getCoef2() * Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()) + coefRsltVO.getCoef3();
				}else if("02".equals(coefRsltVO.getTrndLineChtTpCd())){
					yi=Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty());
					ybar=coefRsltVO.getSigmaY()/coefRsltVO.getDataCnt();
					fxi=coefRsltVO.getCoef1() * Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd())*Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd())
					   + coefRsltVO.getCoef2() * Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgSpd()) + coefRsltVO.getCoef3();
				}else if("03".equals(coefRsltVO.getTrndLineChtTpCd())){
					yi=Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr());
					ybar=coefRsltVO.getSigmaY()/coefRsltVO.getDataCnt();
					fxi=coefRsltVO.getCoef1() * Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd())*Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd())
					   + coefRsltVO.getCoef2() * Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()) + coefRsltVO.getCoef3();
				}else if("04".equals(coefRsltVO.getTrndLineChtTpCd())){
					yi=Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty());
					ybar=coefRsltVO.getSigmaY()/coefRsltVO.getDataCnt();
					fxi=coefRsltVO.getCoef1() * Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr())*Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr())
					   + coefRsltVO.getCoef2() * Double.parseDouble(fcmNoonRptVOs.get(i).getSailAvgRpmPwr()) + coefRsltVO.getCoef3();
				}else if("05".equals(coefRsltVO.getTrndLineChtTpCd())){
					yi=Double.parseDouble(fcmNoonRptVOs.get(i).getDayMnFoilCsmQty());
					ybar=coefRsltVO.getSigmaY()/coefRsltVO.getDataCnt();
					fxi=coefRsltVO.getCoef1() * Double.parseDouble(fcmNoonRptVOs.get(i).getLoad())*Double.parseDouble(fcmNoonRptVOs.get(i).getLoad())
					   + coefRsltVO.getCoef2() * Double.parseDouble(fcmNoonRptVOs.get(i).getLoad()) + coefRsltVO.getCoef3();
				}else if("06".equals(coefRsltVO.getTrndLineChtTpCd())){
					yi=Double.parseDouble(fcmNoonRptVOs.get(i).getLoad());
					ybar=coefRsltVO.getSigmaY()/coefRsltVO.getDataCnt();
					fxi=coefRsltVO.getCoef1() * Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd())*Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd())
					   + coefRsltVO.getCoef2() * Double.parseDouble(fcmNoonRptVOs.get(i).getCalcSpd()) + coefRsltVO.getCoef3();
				}
				upRsquare =  upRsquare + (fxi-ybar)*(fxi-ybar);
				downRsquare = downRsquare + (yi-ybar)*(yi-ybar);
			}
		}
		Double variance = 0.0;
		if(downRsquare>0 || downRsquare<0){
			variance = upRsquare / downRsquare;
		}
		
		return variance;
	}
	
	/**
	 * 기존재하는 Trnd Line의 정보를 수정합니다.<br>
	 * 
	 * @param FcmTrndLineVO HdrTrndLineVO
	 * @param FcmNoonRptVO[] rawDataVOs
	 * @param FcmTrndLineVO[] RsltTrndLineVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTrndLineUpd(FcmTrndLineVO hdrTrndLineVO, FcmNoonRptVO[] rawDataVOs, FcmTrndLineVO[] rsltTrndLineVOs, SignOnUserAccount account) throws EventException {
		try {
			List<FcmTrndLineRptMtchVO> insertVoList = new ArrayList<FcmTrndLineRptMtchVO>();
			for(int i=0; i<rsltTrndLineVOs.length; i++){
				rsltTrndLineVOs[i].setTrndLineUseTpCd(hdrTrndLineVO.getTrndLineUseTpCd());
				rsltTrndLineVOs[i].setTrndLineTpCd(hdrTrndLineVO.getTrndLineTpCd());
				rsltTrndLineVOs[i].setTrndLineTpSubCd(hdrTrndLineVO.getTrndLineTpSubCd());
				rsltTrndLineVOs[i].setVslClssCd(hdrTrndLineVO.getVslClssCd());
				rsltTrndLineVOs[i].setVslClssSubCd(hdrTrndLineVO.getVslClssSubCd());
				rsltTrndLineVOs[i].setVslSlanCd(hdrTrndLineVO.getVslSlanCd());
				rsltTrndLineVOs[i].setVslCd(hdrTrndLineVO.getVslCd());
				rsltTrndLineVOs[i].setSkdDirCd(hdrTrndLineVO.getSkdDirCd());
				rsltTrndLineVOs[i].setUpdUsrId(account.getUsr_id());
				rsltTrndLineVOs[i].setAvgSlpOptRt(hdrTrndLineVO.getAvgSlpOptRt());
				String trndLineSeq = dbDao.searchTrndLineSeq(rsltTrndLineVOs[i]); //rpt mtch 의 데이터 변경을 위해 seq를 구한다.
				rsltTrndLineVOs[i].setTrndLineSeq(trndLineSeq);
				dbDao.modifyTrndLine(rsltTrndLineVOs[i]);
				for(int j=0; j<rawDataVOs.length; j++){
					if("Y".equals(rawDataVOs[j].getTrndLineXcldFlg())){
						FcmTrndLineRptMtchVO mtchVO = new FcmTrndLineRptMtchVO();
						mtchVO.setTrndLineSeq(trndLineSeq);
						mtchVO.setVslCd(rawDataVOs[j].getVslCd());
						mtchVO.setSkdVoyNo(rawDataVOs[j].getSkdVoyNo());
						mtchVO.setSkdDirCd(rawDataVOs[j].getSkdDirCd());
						mtchVO.setNoonRptDt(rawDataVOs[j].getNoonRptDt());
						mtchVO.setTrndLineXcldFlg(rawDataVOs[j].getTrndLineXcldFlg());
						mtchVO.setCreUsrId(account.getUsr_id());
						mtchVO.setUpdUsrId(account.getUsr_id());
						insertVoList.add(mtchVO);
					}
				}
				dbDao.removeTrndLineRptMtchUpd(trndLineSeq);
			}
			if(insertVoList.size()>0){
				dbDao.addTrndLineRptMtchUpd(insertVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"Trend Line"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"Trend Line"}).getMessage(), ex);
		}
	}
	
	/**
	 * 화면에서 온 정보를 이용하여 delete 하지 않은 데이터만의 slip,cspd를 구한다.<br>
	 * 
	 * @param FcmNoonRptVO[] rawDataVOs
	 * @return  FcmNoonRptVO[]
	 * @exception EventException
	 */
	public FcmNoonRptVO[] calcRawDataSimulation(FcmNoonRptVO[] rawDataVOs) throws EventException {
		try {
			Double slpRt = 0.0;
			int count=0;
			for(int i=0; i<rawDataVOs.length; i++){
				if((!"Y".equals(rawDataVOs[i].getTrndLineXcldFlg()))){
					slpRt = slpRt + Double.parseDouble(rawDataVOs[i].getSlpRt());
					count++;
				}
			}
			Double avgSlpRt = 0.0;
			if(count>0){
				avgSlpRt = slpRt / count;
			}
			for(int i=0; i<rawDataVOs.length; i++){
				String strAvgSlpRt = String.format("%.4f", avgSlpRt);
				rawDataVOs[i].setAvgSlpRt(strAvgSlpRt);
				BigDecimal bEngMlDist = new BigDecimal(rawDataVOs[i].getEngMlDist());
				BigDecimal bSailHrmntDay = new BigDecimal(rawDataVOs[i].getSailHrmnt());
				BigDecimal bAvgSlpRt = new BigDecimal(strAvgSlpRt);
				BigDecimal bAvgSlpOptRt = new BigDecimal(rawDataVOs[i].getAvgSlpOptRt());
				BigDecimal bHundred = new BigDecimal("100");
				BigDecimal bAplySlpRt = bAvgSlpRt.add(bAvgSlpRt.multiply(bAvgSlpOptRt).divide(bHundred));
				BigDecimal bCalcSpd = bEngMlDist.divide(bSailHrmntDay, 50, BigDecimal.ROUND_HALF_UP).multiply(bHundred.subtract(bAplySlpRt).divide(bHundred, 50, BigDecimal.ROUND_HALF_UP));
				bCalcSpd = bCalcSpd.setScale(38, BigDecimal.ROUND_HALF_UP);
				String sAplySlpRt = bAplySlpRt.toString();
				String sCalcSpd = bCalcSpd.toString();
				if ( sAplySlpRt != null ) {
			          for( int j=sAplySlpRt.length()-1 ; j >= 0 ;j--){
			              if(sAplySlpRt.charAt(j) != '0'){
			            	  sAplySlpRt = sAplySlpRt.substring(0,j+1);
			               break;
			              }
			          }
				}
				if ( sCalcSpd != null ) {
					for( int j=sCalcSpd.length()-1 ; j >= 0 ;j--){
						if(sCalcSpd.charAt(j) != '0'){
							sCalcSpd = sCalcSpd.substring(0,j+1);
							break;
						}
					}
				}
				rawDataVOs[i].setAplySlpRt(sAplySlpRt);
				rawDataVOs[i].setCalcSpd(sCalcSpd);
			}
			return rawDataVOs;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12215", new String[]{"Trend Line Simulation"}).getMessage(), ex);
		}
	}

	/**
	 * raw data의 vsl을 이용하여 Vessel regisation 의 min,max spd를 구한다.<br>
	 * 
	 * @param FcmNoonRptVO[] rawDataVOs
	 * @return String[]
	 * @exception EventException
	 */
	private String[] searchMinMaxSpd(List<FcmNoonRptVO> fcmNoonRptVOs) throws EventException {
		try {
			//raw data는 order by vsl_cd 상태.
			String bfrVslCd="";
			String vslCd="";
			for(int i=0; i<fcmNoonRptVOs.size(); i++){
				if(!"Y".equals(fcmNoonRptVOs.get(i).getTrndLineXcldFlg())){
					if("".equals(vslCd)){
						vslCd=fcmNoonRptVOs.get(i).getVslCd();
						bfrVslCd = vslCd;
					}else{
						if(!bfrVslCd.equals(fcmNoonRptVOs.get(i).getVslCd())){
							vslCd = vslCd + "," + fcmNoonRptVOs.get(i).getVslCd();
							bfrVslCd = fcmNoonRptVOs.get(i).getVslCd();
						}
					}
				}
			}
			String[] minMax = new String[2];
			minMax = dbDao.searchMinMaxSpd(vslCd);
			return minMax;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("12203", new String[]{"Min Max Speed"}).getMessage(), ex);
		}
	}
	
	/**
	 * Trend Line 수식을 이용하여 결과값을 구한다.<br>
	 * 
	 * @param CalcTrndLineFormulaVO calcTrndLineFormulaVO
	 * @return List<TrndLineFocVO>
	 * @exception EventException
	 */
	public List<CalcTrndLineFormulaVO> calcTrndLineFormula(CalcTrndLineFormulaVO calcTrndLineFormulaVO) throws EventException {
		try{
			return dbDao.calcTrndLineFormula(calcTrndLineFormulaVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12215", new String[]{"Trend Line Formula"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12215", new String[]{"Trend Line Formula"}).getMessage(), ex);
		}
	}
}
