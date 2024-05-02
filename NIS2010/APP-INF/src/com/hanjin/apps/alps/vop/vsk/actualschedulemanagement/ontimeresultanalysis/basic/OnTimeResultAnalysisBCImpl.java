/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnTimeResultAnalysisBCImpl.java
*@FileTitle : SKD for Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.22
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2009.07.13 정명훈 1.0 Creation
*
* History
* 2012.08.14 진마리아 CHM-201219281-01 타선사 SKD에 대해 PAPAC, EGSUZ 입력필수항목 제외처리
* 2013.01.25 황태진    CHM-201322271-01 정시율 조회 조건 변경 및 멀티 저장 처리  
* 2013-04.22 정상기   [CHM-201324042] [VOP-VSK] 정시율 - Report data Creation VVD 첫포트 대상에 추가 
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.basic;

//import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration.OnTimeResultAnalysisDBDAO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortInfoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortListVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwSkdSearchVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwTrdInfoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultChangeStatusVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultDelayStatusVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultOnTimeRatioVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultRemarkVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultSkipStatusVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.SkdResultVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
//import com.hanjin.syscommon.common.table.VskVslSkdRsltVO;

/**
 * ALPS-ActualScheduleManagement Business Logic Basic Command implementation<br>
 * - ALPS-ActualScheduleManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jeong Myounghun
 * @see VOP_VSK_0231EventResponse,OnTimeResultAnalysisBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OnTimeResultAnalysisBCImpl extends BasicCommandSupport implements OnTimeResultAnalysisBC {

	// Database Access Object
	private transient OnTimeResultAnalysisDBDAO dbDao = null;

	/**
	 * OnTimeResultAnalysisBCImpl 객체 생성<br>
	 * OnTimeResultAnalysisDBDAO를 생성한다.<br>
	 */
	public OnTimeResultAnalysisBCImpl() {
		dbDao = new OnTimeResultAnalysisDBDAO();
	}
	/**
	 * Port Schedule에서 정시성 대상 VVD를 조회합니다.<br>
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchRsltConvVslSkd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException {
		try {
			return dbDao.searchRsltConvVslSkd(onTimeRsltAnalGRPVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * SKD Status (Delay Status - Header List)를 조회합니다.<br>
	 * 
	 * @param String intgCdId
	 * @return String
	 * @exception EventException
	 */
	public String searchDelayReason(String intgCdId) throws EventException {
		try {
			return dbDao.searchDelayReason(intgCdId);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * SKD Status (Delay Status)를 조회합니다.<br>
	 * 
	 * @param ResultChangeStatusVO resultChangeStatusVO
	 * @return List<ResultDelayStatusVO>
	 * @exception EventException
	 */
	public List<ResultDelayStatusVO> searchRsltDlayStsList(ResultChangeStatusVO resultChangeStatusVO) throws EventException {
		try {
			return dbDao.searchRsltDlayStsList(resultChangeStatusVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Target VVD & Remark(s)를 조회합니다.<br>
	 * 
	 * @param ResultRemarkVO resultRemarkVO
	 * @return List<ResultRemarkVO>
	 * @exception EventException
	 */
	public List<ResultRemarkVO> searchRsltRmkDtlList(ResultRemarkVO resultRemarkVO) throws EventException{
		try {
			return dbDao.searchRsltRmkDtlList(resultRemarkVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * SKD Status (Skip Status)를 조회합니다.<br>
	 * 
	 * @param ResultSkipStatusVO resultSkipStatusVO
	 * @return List<ResultSkipStatusVO>
	 * @exception EventException
	 */
	public List<ResultSkipStatusVO> searchRsltSkipStsList(ResultSkipStatusVO resultSkipStatusVO) throws EventException {
		try {
			return dbDao.searchRsltSkipStsList(resultSkipStatusVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * SKD Status (Skip Change Status)를 조회합니다.<br>
	 * 
	 * @param ResultChangeStatusVO resultChangeStatusVO
	 * @return List<ResultChangeStatusVO>
	 * @exception EventException
	 */
	public List<ResultChangeStatusVO> searchRsltCngStsList(ResultChangeStatusVO resultChangeStatusVO) throws EventException {
		try {
			return dbDao.searchRsltCngStsList(resultChangeStatusVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * 스케쥴 지연 사유를 조회합니다.
	 * 
	 * @param ResultOnTimeRatioVO resultOnTimeRatioVO
	 * @return List<ResultOnTimeRatioVO>
	 * @exception EventException
	 */
	public List<ResultOnTimeRatioVO> searchRsltOnTimeRtoList (ResultOnTimeRatioVO resultOnTimeRatioVO) throws EventException {
		try {
			return dbDao.searchRsltOnTimeRtoList(resultOnTimeRatioVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 조회합니다.
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @return OnTimeRsltAnalVO
	 * @exception EventException
	 */
	public OnTimeRsltAnalGRPVO searchRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException {
		try {

			OnTimeRsltAnalGRPVO result = dbDao.searchRsltCstSkdtTarget(onTimeRsltAnalGRPVO);
				
			List<SkdResultVO> skdResultVOs = result.getSkdResultVOs();
				if(skdResultVOs==null || skdResultVOs.size()==0){
					result.setExist("");
				}else{
//					result = calRsltCstSkdDlayHr(result);
					result.setExist("1");
				}
				
				//for(SkdResultVO tmpVO : skdResultVOs)
				//{
				//	log.info("\n\n ::jskjskjsk::   bfr_pf_etd_dt ["+tmpVO.getBfrPfEtdDt()+"]\n");
				//	log.info("\n\n ::jskjskjsk::   bfr_act_det_dt ["+tmpVO.getBfrActDepDt()+"]\n");
				//}
			
			return result;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
//			throw new EventException(new ErrorHandler(Constants.ERR_MSG_CD_VSK10035).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
//			throw new EventException(new ErrorHandler(Constants.ERR_MSG_CD_VSK10039).getMessage(), ex);
		}
	}
	
//	/**
//	 * VVD에 대해서 VSK VESSEL SCHEDULE 정보를 이용하여 지연 정보를 조회합니다. 
//	 * 
//	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
//	 * @return OnTimeRsltAnalVO
//	 * @exception EventException
//	 */
//	public OnTimeRsltAnalGRPVO calRsltCstSkdDlayHr(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException {
//		try{
//			String contiCd = null;
//			boolean firstContiPort = false;
//			
////			List<VskVslSkdRsltVO> vskVslSkdRsltVOs = onTimeRsltAnalVO.getVskVslSkdRsltVOs();
//			List<SkdResultVO> skdResultVOs = onTimeRsltAnalVO.getSkdResultVOs();
//			
//			for(int i=0; i<skdResultVOs.size(); i++){
//				SkdResultVO vo = skdResultVOs.get(i);
//				
//				if(contiCd!=null){
//					// 운하를 제외한 각 지역(Conti Code)의 첫번째 port 임을 인식 
//					if( (!"EGSUZ".equals(vo.getVpsPortCd()) && !"PAPAC".equals(vo.getVpsPortCd()))  && !contiCd.equals(vo.getContiCd())){
//						firstContiPort = true;
//					}
//				}
//				contiCd = vo.getContiCd();
//				
//				String arrDlayHrs1 = null;
//				String depDlayHrs1 = null;
//				
//				if(i==0){
//					arrDlayHrs1 = "0";
//					depDlayHrs1 = getDepartureDelay(skdResultVOs.get(0));
//					
//					// P/F와 Actual이 같은 날이면 On-Time으로 간주.
//					if(vo.getPfEtdDt().length()>10 && vo.getActDepDt().length()>10){
//						if(vo.getPfEtdDt().substring(0, 10).equals(vo.getActDepDt().substring(0, 10))){
//							depDlayHrs1 = "0";
//						}
//					}
//				}else{
//					arrDlayHrs1 = getArrivalDelay(skdResultVOs.get(i-1), skdResultVOs.get(i));
//					if(i==skdResultVOs.size()-1){
//						depDlayHrs1 = "0";
//					}else{
//						depDlayHrs1 = getDepartureDelay(skdResultVOs.get(i));	
//					}
//					
//					// 지역(CONTI Code)에 따른 Delay 시간 조절
//					// 지역내 첫 Port인 경우 ==> 2시간 이내 지연시간은 On-Time으로 간주.
//					// 지역내 타 Port인 경우 ==> 지연이 발생하더라고 P/F와 같은 날이면 On-Time으로 간주.
//					// ※ 단, 운하포트(EGSUZ, PAPAC)는 시간 조절이 없음.
//					if(firstContiPort){
//						if(Integer.parseInt(arrDlayHrs1)<=2){
//							arrDlayHrs1 = "0";
//						}
//						if(Integer.parseInt(depDlayHrs1)<=2){
//							depDlayHrs1 = "0";
//						}
//					}else{
//						if(vo.getPfEtbDt().length()>10 && vo.getActBrthDt().length()>10){
//							if(vo.getPfEtbDt().substring(0, 10).equals(vo.getActBrthDt().substring(0, 10))){
//								arrDlayHrs1 = "0";
//							}
//						}
//						if(vo.getPfEtdDt().length()>10 && vo.getActDepDt().length()>10){
//							if(vo.getPfEtdDt().substring(0, 10).equals(vo.getActDepDt().substring(0, 10))){
//								depDlayHrs1 = "0";
//							}
//						}
//					}
//				}
//				
//				vo.setArrDlayHrs1(arrDlayHrs1);
//				vo.setDepDlayHrs1(depDlayHrs1);
////				vo.setInitArrDlayHrs(arrDlayHrs1);		// 최초 ARR_DLAY_HRS 를 기록하기 위해 
////				vo.setInitDepDlayHrs(depDlayHrs1);	// 최초 DEP_DLAY_HRS 를 기록하기 위해
//				vo.setArrDlayHrs2("0");
//				vo.setDepDlayHrs2("0");
//			}
//			onTimeRsltAnalVO.setSkdResultVOs(skdResultVOs);
//			//onTimeRsltAnalVO.setVskVslSkdRsltVOs(vskVslSkdRsltVOs);
//		} catch (Exception ex) {
//			/*
//			 * MSG - 서비스 실행중 오류가 발생하였습니다.
//			 */
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		}
//		return onTimeRsltAnalVO;
//	}
	
//	/**
//	 * 각 Port 사이의 P/F 스케쥴과 Actual 스케쥴 간의 Arrival 시간차(Delay)를 구한다. 
//	 * 
//	 * @param SkdResultVO vo1
//	 * @param SkdResultVO vo2
//	 * @return String
//	 * @exception EventException
//	 */
//	private String getArrivalDelay(SkdResultVO vo1, SkdResultVO vo2) throws ParseException {
//			String delay = null;
//			
//			String pfEtd = vo1.getPfEtdDt();
//			String pfEtb = vo2.getPfEtbDt();
//			String actEtd = vo1.getActDepDt();
//			String actEtb = vo2.getActBrthDt();
//			
//			/*
//			 ===============
//			 시간차를 구하는 방식
//			 ===============
//			 
//			 vo1 : 연속된 두 port 중 선행 port 정보
//			 vo2 : 연속된 두 port 중 후행 port 정보
//			 
//			 P/F 스케쥴 Arrival 소요 시간 = vo2의 P/F ETB - vo1의 P/F ETD
//			 Actual 스케쥴 Arrival 소요 시간 = vo2의 ACT Berth Date - vo1의 ACT Departure Date
//			 
//			 >>> 시간차 = Actual 스케쥴 Arrival 소요 시간 - P/F 스케쥴 Arrival 소요 시간
//			 
//			만약 P/F 스케쥴 Arrival 소요 시간이 커서 시간차가 음수가 나오는 경우,
//			(Exclude 방식에서 볼때) 지연이 발생하지 않은 것으므로 시간차는 0으로 감안한다. 
//			 			 
//			 */
//			
//			// 시간차를 구하기 위한 4항목(위의 시간차 구하는 방식 참고)의 시간 정보중 하나라도 없는 경우 시간차는 0이 된다.
//			if( pfEtd==null || pfEtd.length()==0 
//					|| pfEtb == null || pfEtb.length()==0 
//					|| actEtd == null || actEtd.length()==0
//					|| actEtb == null || actEtb.length()==0
//					){
//				return "0";
//			}
//			
//			SimpleDateFormat sfg = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//			
//			Date pfEtdDt = sfg.parse(vo1.getPfEtdDt()); 
//			Date pfEtbDt = sfg.parse(vo2.getPfEtbDt());
//			
//			Date actEtdDt = sfg.parse(vo1.getActDepDt());
//			Date actEtbDt = sfg.parse(vo2.getActBrthDt());
//			
//			// Hour로 환산한 P/F Arrival 소요 시간
//			// 0.5시간(30분)은 1시간으로 반올림한다.
//			long pfArrTimeByHour = Math.round( (pfEtbDt.getTime() - pfEtdDt.getTime()) / (1000 * 60 * 60.0) );
//			
//			// Hour로 환산한 Actual Arrival 소요 시간
//			// 0.5시간(30분)은 1시간으로 반올림한다.
//			long actArrTimeByHour = Math.round( (actEtbDt.getTime() - actEtdDt.getTime()) / (1000 * 60 * 60.0) );
//			
//			delay = actArrTimeByHour - pfArrTimeByHour <= 0 ? "0" : Long.toString(actArrTimeByHour - pfArrTimeByHour); 
//			
//			return delay;
//	}
	
//	/**
//	 * 각 Port 사이의 P/F 스케쥴과 Actual 스케쥴 간의 Departure 시간차(Delay)를 구한다.
//	 * 
//	 * @param SkdResultVO skdResultVO
//	 * @return String
//	 * @exception ParseException
//	 */
//	private String getDepartureDelay(SkdResultVO skdResultVO) throws ParseException {
//		
//		String delay = null;
//		
//		String pfEtd = skdResultVO.getPfEtdDt();
//		String pfEtb = skdResultVO.getPfEtbDt();
//		String actEtd = skdResultVO.getActDepDt();
//		String actEtb = skdResultVO.getActBrthDt();
//		
//		/*
//		 ===============
//		 시간차를 구하는 방식
//		 ===============
//		 
//		 P/F 스케쥴 Arrival 소요 시간 =  P/F ETD - P/F ETB
//		 Actual 스케쥴 Arrival 소요 시간 = ACT Departure Date - ACT Berth Date 
//		 
//		 >>> 시간차 = Actual 스케쥴 Arrival 소요 시간 - P/F 스케쥴 Arrival 소요 시간
//		 
//		만약 P/F 스케쥴 Arrival 소요 시간이 커서 시간차가 음수가 나오는 경우,
//		(Exclude 방식에서 볼때) 지연이 발생하지 않은 것으므로 시간차는 0으로 감안한다. 
//		 			 
//		 */
//		
//		// 시간차를 구하기 위한 4항목(위의 시간차 구하는 방식 참고)의 시간 정보중 하나라도 없는 경우 시간차는 0이 된다.
//		if( pfEtd==null || pfEtd.length()==0 
//				|| pfEtb == null || pfEtb.length()==0 
//				|| actEtd == null || actEtd.length()==0
//				|| actEtb == null || actEtb.length()==0
//				){
//			return "0";
//		}
//		
//		SimpleDateFormat sfg = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		
//		Date pfEtdDt = sfg.parse(skdResultVO.getPfEtdDt()); 
//		Date pfEtbDt = sfg.parse(skdResultVO.getPfEtbDt());
//		
//		Date actEtdDt = sfg.parse(skdResultVO.getActDepDt());
//		Date actEtbDt = sfg.parse(skdResultVO.getActBrthDt());
//		
//		// Hour로 환산한 P/F Arrival 소요 시간
//		// 0.5시간(30분)은 1시간으로 반올림한다.
//		long pfArrTimeByHour = Math.round( (pfEtdDt.getTime() - pfEtbDt.getTime()) / (1000 * 60 * 60.0) );
//		
//		// Hour로 환산한 Actual Arrival 소요 시간
//		// 0.5시간(30분)은 1시간으로 반올림한다.
//		long actArrTimeByHour = Math.round( (actEtdDt.getTime() - actEtbDt.getTime()) / (1000 * 60 * 60.0) );
//		
//		delay = actArrTimeByHour - pfArrTimeByHour <= 0 ? "0" : Long.toString(actArrTimeByHour - pfArrTimeByHour); 
//		
//		return delay;
//		
//	}
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 삭제합니다. 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @exception EventException
	 */
	public void removeRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException {
		try {
			dbDao.removeRsltByVvd(onTimeRsltAnalGRPVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 저장합니다. 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO, SignOnUserAccount account) throws EventException {
		try {
			onTimeRsltAnalGRPVO.setCreUsrId(account.getUsr_id());
			onTimeRsltAnalGRPVO.setUpdUsrId(account.getUsr_id());
			dbDao.manageRsltByVvd(onTimeRsltAnalGRPVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 입력 중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 수정합니다. 
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyRsltByVvd(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO, SignOnUserAccount account) throws EventException {
		try {
			onTimeRsltAnalGRPVO.setCreUsrId(account.getUsr_id());
			onTimeRsltAnalGRPVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyRsltByVvd(onTimeRsltAnalGRPVO);

		} catch (DAOException ex) {
			/*
			 * MSG - 입력 중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10038").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/*
	 * VVD에 대해서 ACTUAL CARRIER 정보를 조회한다.
	 * 
	 * @param OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO
	 * @return String
	 * @exception EventException
	 */
/*
	private String searchActualCarrierforVVD(OnTimeRsltAnalGRPVO onTimeRsltAnalGRPVO) throws EventException {
		try {
			return dbDao.searchActualCarrierforVVD(onTimeRsltAnalGRPVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
*/	
	
	/**
	 *  정보를 조회합니다.
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @return List<DrwSkdSearchVO>
	 * @exception EventException
	 */
	public List<DrwSkdSearchVO> searchDrwSkd(DrwSkdSearchVO drwSkdSearchVO) throws EventException {
		try {

			return dbDao.searchDrwSkdInfo(drwSkdSearchVO);
				
			
			//return result;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
//			throw new EventException(new ErrorHandler(Constants.ERR_MSG_CD_VSK10035).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
//			throw new EventException(new ErrorHandler(Constants.ERR_MSG_CD_VSK10039).getMessage(), ex);
		}
	}
	
	/**
	 *  정보를 조회합니다.
	 * 
	 * @param DrwPortListVO drwPortListVO
	 * @return List<DrwPortListVO>
	 * @exception EventException
	 */
	public List<DrwPortListVO> searchDrwPortList() throws EventException{
		try {
			return dbDao.searchDrwPortList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}

	
	/**
	 * VVD에 대해서 VSK Drewry Report 정보를 저장합니다. 
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDrwRptByVvd(DrwSkdSearchVO drwSkdSearchVO, SignOnUserAccount account) throws EventException {
		try {
			drwSkdSearchVO.setCreUsrId(account.getUsr_id());
			drwSkdSearchVO.setUpdUsrId(account.getUsr_id());
			dbDao.manageDrwRptByVvd(drwSkdSearchVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 입력 중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * VVD에 대해서 VSK Drewry Report 정보를 삭제합니다. 
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @exception EventException
	 */
	public void removeDrwRptByVvd(DrwSkdSearchVO drwSkdSearchVO) throws EventException {
		try {
			dbDao.removeDrwRptByVvd(drwSkdSearchVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 * VVD에 대해서 VSK Drewry Report 정보를 수정합니다. 
	 * 
	 * @param DrwSkdSearchVO drwSkdSearchVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyDrwRptByVvd(DrwSkdSearchVO drwSkdSearchVO, SignOnUserAccount account) throws EventException {
		try {
			drwSkdSearchVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyDrwRptByVvd(drwSkdSearchVO);

		} catch (DAOException ex) {
			/*
			 * MSG - 입력 중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10038").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 *  정보를 조회합니다.
	 * 
	 * @param DrwPortInfoVO drwPortInfoVO
	 * @return List<DrwPortInfoVO>
	 * @exception EventException
	 */
	public List<DrwPortInfoVO> searchDrwPortInfo(DrwPortInfoVO drwPortInfoVO) throws EventException{
		
		try {
			return dbDao.searchDrwPortInfo(drwPortInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * VSK Drewry Report의 Port Setup에서 Port를 추가하여  저장합니다.
	 * 
	 * @param DrwPortListVO drwPortListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDrwPortList(DrwPortListVO drwPortListVO, SignOnUserAccount account) throws EventException {
		try {
			drwPortListVO.setCreUsrId(account.getUsr_id());
			drwPortListVO.setUpdUsrId(account.getUsr_id());
			dbDao.manageDrwPortList(drwPortListVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 입력 중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * VSK Drewry Report의 Port Setup에서 Port를  삭제합니다. 
	 * 
	 * @param DrwPortListVO drwPortListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDrwPortList(DrwPortListVO drwPortListVO, SignOnUserAccount account) throws EventException {
		try {
			drwPortListVO.setUpdUsrId(account.getUsr_id());
			dbDao.removeDrwPortList(drwPortListVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
	/**
	 *  정보를 조회합니다.
	 * 
	 * @return List<DrwTrdInfoVO>
	 * @exception EventException
	 */
	public List<DrwTrdInfoVO> searchDrwTrdInfo() throws EventException{
		
		try {
			return dbDao.searchDrwTrdInfo();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * VSK Drewry Report의 Trade Setup에서 Trade를 추가하여  저장합니다.
	 * 
	 * @param DrwTrdInfoVO drwTrdInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDrwTrdInfo(DrwTrdInfoVO drwTrdInfoVO, SignOnUserAccount account) throws EventException {
		try {
			drwTrdInfoVO.setCreUsrId(account.getUsr_id());
			drwTrdInfoVO.setUpdUsrId(account.getUsr_id());
			dbDao.manageDrwTrdInfo(drwTrdInfoVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 입력 중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * VSK Drewry Report의 Trade Setup에서 Trade를  삭제합니다. 
	 * 
	 * @param DrwTrdInfoVO drwTrdInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDrwTrdInfo(DrwTrdInfoVO drwTrdInfoVO, SignOnUserAccount account) throws EventException {
		try {
			drwTrdInfoVO.setUpdUsrId(account.getUsr_id());
			dbDao.removeDrwTrdInfo(drwTrdInfoVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}		
	}
	
}