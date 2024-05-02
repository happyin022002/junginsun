/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VesselScheduleMgtBCImpl.java
 *@FileTitle : VSL SKD Delete & Closing
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.10.05
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.02.10 진마리아
 * 1.0 Creation
 * 
 * History
 * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
 * 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
 * 2011.06.27 진마리아 CHM-201111838-01 소스품질 결함수정 - 문자열 비교는 문자열 비교 메소드를 사용해야 한다.
 * 2012.10.05 R4J 결함 수정(rule upgrade)
 * 2015.08.18 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.basic;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration.VesselScheduleMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PfSkdDetailVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SimulationVvdCheckVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdCheckVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.hanjin.syscommon.common.table.VskSwapCstPortVO;
import com.hanjin.syscommon.common.table.VskSwapCstVvdVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/** 
 * NIS2010-budget Business Logic Basic Command implementation<br>
 * - NIS2010-budget에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Maria Chin
 * @see UI_VSK-0018EventResponse,VesselScheduleMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class VesselScheduleMgtBCImpl extends BasicCommandSupport implements VesselScheduleMgtBC {

	// Database Access Object
	private transient VesselScheduleMgtDBDAO dbDao = null;
//	private transient VesselScheduleMgtEAIDAO eaiDao = null;

	/**
	 * VesselScheduleMgtBCImpl 객체 생성<br>
	 * VesselScheduleMgtDBDAO를 생성한다.<br>
	 */
	public VesselScheduleMgtBCImpl() {
		dbDao = new VesselScheduleMgtDBDAO();
//		eaiDao = new VesselScheduleMgtEAIDAO();
	}
	
	/**
	 * 해당 Lane의 Vessel Schedule 리스트 정보를 조회합니다.<br>
	 * 
	 * @param ActivationVvdVO activationVvdVO
	 * @return List<ActivationVvdVO>
	 * @exception EventException
	 */
	public List<ActivationVvdVO> searchVslSkdListByLane(ActivationVvdVO activationVvdVO)
			throws EventException {
		try {
			return dbDao.searchVslSkdListByLane(activationVvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * 해당 VVD 스케쥴을 삭제합니다.
	 * 첫번째인자(activationVvdVO1)는 Booking이 걸려있지 않는 스케쥴 정보배열이고
	 * 두번째인자(activationVvdVO2)는 Booking이 걸려있는 스케쥴 정보 배열이다.
	 * 
	 * @param ActivationVvdVO[] activationVvdVO1s
	 * @param ActivationVvdVO[] activationVvdVO2s
	 * @param VskVslSkdHisVO vskVslSkdHisVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeCstSkdByVvd(
			ActivationVvdVO[] activationVvdVO1s,
			ActivationVvdVO[] activationVvdVO2s,
			VskVslSkdHisVO vskVslSkdHisVO, 
			SignOnUserAccount account) throws EventException{
		try {
			
			//UI_VSK_0249에서 데이타를 입력하지 않은 경우 : Reason을 입력하지 않은 경우
			//BKG_VVD를 테이블 조회  BOOKING 데이타 확인 (있으면 : PASS (returnVoLis에 담아서 리턴), 없으면 :REMOVE(HISTORY)는 남기지 않는다)
			
			// Booking 정보가 없는 VVD를 삭제하는 경우
			// 1. VOP_VSK_0018 에서 Delete를 실행
			// 2. VOP_VSK_0249 에서 Booking 정보가 없는 VVD에 대해 거래를 실행한 경우  
			if(vskVslSkdHisVO == null){
				
				for(ActivationVvdVO vo : activationVvdVO1s){
					if(vo==null) continue;
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
				}
				
				// VVD Delete
				removeCstSkdByVvd(activationVvdVO1s);
			
			}else{
			// Booking 정보가 있는 VVD를 삭제하는 경우
			// VOP_VSK_0249 에서 Booking 정보가 있는 VVD(화면에 리스트 출력된 VVD)에 대해 거래를 실행한 경우
				
				for(int i=0; activationVvdVO1s!=null && i<activationVvdVO1s.length; i++){
					ActivationVvdVO vo = activationVvdVO1s[i];
					if(vo==null) continue;
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
				}
				
				for(int i=0; activationVvdVO2s!=null && i<activationVvdVO2s.length; i++){
					ActivationVvdVO vo = activationVvdVO2s[i];
					if(vo==null) continue;
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
				}
				
				// Booking이 걸려있는 않는 VVD Delete
				removeCstSkdByVvd(activationVvdVO1s);
				
			}
			
		} catch (EventException e) {
			log.error("err " + e.toString(), e);
			throw e;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		}
	}
	
	/**
	 * Booking 모쥴에 BDR 정보를 변경하기 위해 Target 정보를 조회한다.
	 * 
	 * @param List<VvdVO> vvdVOs
	 * @return List<BkgVvdBdrLogVO>
	 * @exception EventException
	 * @author jinwoo
	 */
	public List<BkgVvdBdrLogVO> searchBkgBdrLog(List<VvdVO> vvdVOs) throws EventException {
		List<BkgVvdBdrLogVO> bkgVvdLogList = new ArrayList<BkgVvdBdrLogVO>();
		try{
			for(VvdVO vvdVO : vvdVOs){
				/*
				 * Booking Module 변경으로 인해 VVD만 반환(2010.01.07 - 정진우).
				 */
				BkgVvdBdrLogVO bkgVvdBdrLogVO = new BkgVvdBdrLogVO();
				bkgVvdBdrLogVO.setVslCd(vvdVO.getVslCd());
				bkgVvdBdrLogVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
				bkgVvdBdrLogVO.setSkdDirCd(vvdVO.getSkdDirCd());
				bkgVvdLogList.add(bkgVvdBdrLogVO);
			}
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return bkgVvdLogList;
	}
	
	/**
	 * 주어진 조건(기간, Lane, Vessel Code)에 따른 Vessel Port SKD을 조회합니다.
	 * 
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return List<PortSkdOnLongRangeVO>
	 * @exception EventException
	 */
	public List<PortSkdOnLongRangeVO> searchPortSkd(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException {
		try {
			return dbDao.searchPortSkdOnLongRange(portSkdOnLongRangeVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		}
	}
	
	/**
	 * LongRangeSchedule을 생성합니다.<br>
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return LongRangeSkdGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdGRPVO createLongRngSkd(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException {
		
		try {
			
			PfSkdVO[] pfSkdVOs = longRangeSkdGRPVO.getPfSkdVOs();
			Map<String, MdmVslCntrVO> vesselVOs = new HashMap<String, MdmVslCntrVO>();
			String[] skdRmk = longRangeSkdGRPVO.getSkdRmk();
			String headTitle1 = longRangeSkdGRPVO.getHeadTitle1(); // SKD_DIR_CD
			String headTitle2 = longRangeSkdGRPVO.getHeadTitle2(); // VPS_PORT_CD
			String headTitle3 = longRangeSkdGRPVO.getHeadTitle3(); // ETB_DY_NO/ETD_DY_NO
			String headTitle4 = longRangeSkdGRPVO.getHeadTitle4(); // ETB_TM_HRMNT/ETD_TM_HRMNT
			String headTitle5 = longRangeSkdGRPVO.getHeadTitle5(); // CLPT_SEQ
			String headTitle6 = longRangeSkdGRPVO.getHeadTitle6(); // YD_CD
			
			boolean oneWayDir = true;
			
			Map<String, String[]> simInfo = longRangeSkdGRPVO.getSimInfoMap();
			
			// 파이프라인(|)은 정규식에서는 특수문자 이므로
			// 일반문자로 인식시키기 위해 \\를 사용한다.
			String[] titles1 = headTitle1.split("\\|");
			String[] titles2 = headTitle2.split("\\|");
			String[] titles3 = headTitle3.split("\\|");
			String[] titles4 = headTitle4.split("\\|");
			String[] titles5 = headTitle5.split("\\|");
			String[] titles6 = headTitle6.split("\\|");
			
			if(!(
					(titles1.length==titles2.length)
					&& (titles2.length==titles3.length)
					&& (titles3.length==titles4.length)
					&& (titles4.length==titles5.length)
					&& (titles5.length==titles6.length)
			))
			{
				// 헤더 길이가 다르면 오류
				throw new EventException(new ErrorHandler("VSK10039").getMessage());			
			}
			
			
			// CLPT_IND_SEQ, CLPT_SEQ, CALL_YD_IND_SEQ 설정
	
			// ---------- Step1. PfSkdVO 리스트를 생성 시작 ----------
			
			String beforeDir = null;
			// PF 정보에 헤더 정보를 추가한다.(Add Call 정보가 추가될것임)
			List<PfSkdVO> pfSkdList = new ArrayList<PfSkdVO>();
			for(int i=1,k=0; i<titles1.length; i=i+2){
				PfSkdVO pfSkdVO = pfSkdVOs[k];
				
				// 전 P/F Detail 정보와 Direction이 다르다면 이 P/F는 2 Direction으로 구성된것이다.
				if(oneWayDir && beforeDir!=null && !pfSkdVO.getSkdDirCd().equals(beforeDir)){
					oneWayDir = false;
				}
				beforeDir = pfSkdVO.getSkdDirCd();
				
				// 일부 Feeder P/F SKD의 경우 TURN_PORT_IND_CD 값이 비어있는 경우가 있음.
				// 이런 경우 일괄적으로 N으로 인식하도록 함.
				// 2009.11.4
				if(pfSkdVOs[k].getTurnPortIndCd()==null || "".equals(pfSkdVOs[k].getTurnPortIndCd())){
					pfSkdVOs[k].setTurnPortIndCd("N");
				}
				
				if(titles2[i].equals(pfSkdVO.getPortCd())){
					pfSkdList.add(pfSkdVO);
					k++;
				}else{
					// add call 되어 title 정보에는 있지만 P/F에는 없는 상태
					// title 정보를 이용해서 PfSkdVO를 생성한다.
					// ETB/ETD Day Code(요일) 값이 NULL 이므로,
					// 이를 이용하여 Add Call Port로 인식할 수 있다. 
					PfSkdVO vo = new PfSkdVO();
					vo.setPortCd(titles2[i]);
					vo.setSkdDirCd(titles1[i]);
					vo.setYdCd(titles6[i]);
					vo.setVslSlanCd(longRangeSkdGRPVO.getVslSlanCd());
					vo.setVslSvcTpCd(longRangeSkdGRPVO.getVslSvcTpCd());
					vo.setTurnPortIndCd("N");
					
					pfSkdList.add(vo);
				}
			}
			
			// ---------- Step1. PfSkdVO 리스트를 생성 완료 ----------
			
	
			
			
			// ---------- Step2. 화면의 시뮬레이션 정보를 Vessel별 리스트로 전환 시작 ----------
			
			Map<String, List<VskSwapCstPortVO>> skdByVsl = new HashMap<String, List<VskSwapCstPortVO>>();
			{	
		
				String[] vvd1 = longRangeSkdGRPVO.getVVD1();
				String[] vvd2 = longRangeSkdGRPVO.getVVD2();
				String[] vvd2_1 = new String[vvd2.length];
				String[] vvd2_2 = new String[vvd2.length];
				
				//VskSwapCstPortVO skdVO = null;
				PfSkdVO pfSkdVO = null;
				
				String skdCngStsCd = null;
				String uiFormat = "MM/ddyyyyHHmm";
				String dataFormat = "yyyyMMddHHmm";
				
				boolean phaseOut = false;
				
				// 4개의 Row가 하나의 VVD에 대한 정보이므로
				// 4개씩 묶어서 처리한다.
				for(int m=0; m<vvd1.length; m=m+4){
					
					// Phase Out 된 VVD는 저장하지 않는다.
					if(longRangeSkdGRPVO.getPOutFlag()!=null && longRangeSkdGRPVO.getPOutFlag()[m]!=null && longRangeSkdGRPVO.getPOutFlag()[m].length()!=0){
						continue;
					}
					
					for(int k=0; k<pfSkdList.size(); k++){
						
						if(phaseOut){
							break;
						}
						
						VskSwapCstPortVO skdVO = new VskSwapCstPortVO();
						pfSkdVO = pfSkdList.get(k);
						
						skdVO.setCreUsrId(longRangeSkdGRPVO.getCreUsrId());
						skdVO.setUpdUsrId(longRangeSkdGRPVO.getUpdUsrId());
						
						skdVO.setVslCd(vvd1[m]);
						skdVO.setSkdDirCd(pfSkdVO.getSkdDirCd());
						
						if(!vesselVOs.containsKey(vvd1[m])){
							vesselVOs.put(vvd1[m], dbDao.searchMdmVslCntr(vvd1[m]));
						}
						
						// skd_voy_no가 direction의 변경에 따라 증가되는 겨우
						if(vvd2[m].length()>4){
							vvd2_1[m] = vvd2[m].substring(0, 4);
							vvd2_2[m] = vvd2[m].substring(5, 9);
							
							if(skdVO.getSkdDirCd().equals(pfSkdList.get(0).getSkdDirCd())){
								skdVO.setSkdVoyNo(vvd2_1[m]);
							}else if(skdVO.getSkdDirCd().equals(pfSkdList.get(pfSkdList.size()-1).getSkdDirCd())){
								skdVO.setSkdVoyNo(vvd2_2[m]);
							}
							
						}else{
							skdVO.setSkdVoyNo(vvd2[m]);	
						}
						
						skdVO.setVpsPortCd(pfSkdVO.getPortCd());
						skdVO.setSlanCd(pfSkdVO.getVslSlanCd());
						skdVO.setYdCd(pfSkdVO.getYdCd());
						skdVO.setTurnPortFlg(pfSkdVO.getTurnPortFlg());
						skdVO.setTurnPortIndCd(pfSkdVO.getTurnPortIndCd());
						
						skdVO.setSeaBufHrs(pfSkdVO.getSeaBufHrs());
						skdVO.setPortBufHrs(pfSkdVO.getPortBufHrs());
						
						// CLPT_IND_SEQ, CALL_YD_IND_SEQ 는 1로 초기화한다.
						// Step3 에서 Virtual Port 정보를 생성하는 과정에서 재조정된다.
						skdVO.setClptIndSeq("1");
						skdVO.setCallYdIndSeq("1");
	
						// PF_ET, INIT_ET, VPS_ET 설정
						// 화면에서 ETB, ETD가 비어있는 부분은 모두 널스트링으로 설정됨
						// 
						// SKIP 포트일때
						// m+1 : INIT_ET
						// m+2 : PF_ET
						// m+3 : VPS_ET
						//
						// SKIP 포트가 아닐때
						// m : VPS_ET
						// m+1 : INIT_ET
						// m+2 : PF_ET
						// m+3 : SKD_CNG_STS_CD
						
						// m+1(공통)
						skdVO.setInitEtbDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + k)[m+1], uiFormat, dataFormat));
						skdVO.setInitEtdDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + k)[m+1], uiFormat, dataFormat));
						skdVO.setInitEtaDt(
								getETA(skdVO.getInitEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
						
						// m+2(공통)
						skdVO.setPfEtbDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + k)[m+2], uiFormat, dataFormat));
						skdVO.setPfEtdDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + k)[m+2], uiFormat, dataFormat));
						skdVO.setPfEtaDt(
								getETA(skdVO.getPfEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
	
						
						if(" SKIP".equals(simInfo.get("ETB" + k)[m])){
							// SKIP 포트일때
							// m+3 : VPS_ET
							skdCngStsCd = "S";
							
							skdVO.setVpsEtbDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + k)[m+3], uiFormat, dataFormat));
							skdVO.setVpsEtdDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + k)[m+3], uiFormat, dataFormat));
							skdVO.setVpsEtaDt(
									getETA(skdVO.getVpsEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
							
						}else{
							// SKIP 포트가 아닐때
							// m : VPS_ET
							// m+3 : SKD_CNG_STS_CD
							
							skdVO.setVpsEtbDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + k)[m], uiFormat, dataFormat));
							skdVO.setVpsEtdDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + k)[m], uiFormat, dataFormat));
							skdVO.setVpsEtaDt(
									getETA(skdVO.getVpsEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
							
							skdCngStsCd = simInfo.get("ETD" + k)[m+3];
							
							// Add Call인 경우 TURN_PORT_FLG = "N"
							if("A".equals(skdCngStsCd)){
								skdVO.setTurnPortFlg("N");
							}
							
							if(skdCngStsCd.startsWith("O:")){
								phaseOut = true;
								skdVO.setPhsIoRsnCd(skdCngStsCd.substring(2));
								skdCngStsCd = "O";
							}
							
							if(skdCngStsCd.startsWith("I:")){
								skdVO.setPhsIoRsnCd(skdCngStsCd.substring(2));
								skdCngStsCd = "I";
							}
							
						}
						
						// Add Call인 경우 PORT_BUF_HRS를 조회하여 설정한다.
						if("A".equals(skdCngStsCd)){
							String portBufHrs = dbDao.searchPortBufHrs(skdVO.getVpsPortCd());
							skdVO.setPortBufHrs(portBufHrs);
						}
						
						/*
						 * A : Add / R : Reverse / S : Skip / C : Change / I : Phase In / O : Phase Out
						 */
						skdVO.setSkdCngStsCd(skdCngStsCd);
						
						// Vessel 별로 SKD 리스트를 구성한다.
						List<VskSwapCstPortVO> list = skdByVsl.get(skdVO.getVslCd());
						if(list==null){
							list = new ArrayList<VskSwapCstPortVO>();
						}
						list.add(skdVO);
						skdByVsl.put(skdVO.getVslCd(), list);
						
					}
				}
			}
			// ---------- Step2. 화면의 시뮬레이션 정보를 Vessel별 리스트로 전환 완료 ----------
			
			
			// ---------- Step3. Virtual Port 정보를 포함하는 리스트로 전환 시작 ----------
			
			// Creation 화면에 나오는 2개의 Direction에 대응하는 각각의 리스트를 선언
			// currVVD : 현재 VVD
			// prevVVD : 이전 VVD
			List<VskSwapCstPortVO> currVVD = new ArrayList<VskSwapCstPortVO>();
			List<VskSwapCstPortVO> prevVVD = new ArrayList<VskSwapCstPortVO>();
			
			// Virtual Port를 포함하는 최종 Port SKD 리스트
			List<VskSwapCstPortVO> portSkdList = new ArrayList<VskSwapCstPortVO>();
			
			for(Iterator<List<VskSwapCstPortVO>> i = skdByVsl.values().iterator(); i.hasNext();){
				
				// Step 2에서 Vessel 별로 분류된 리스트
				List<VskSwapCstPortVO> list = i.next();
				
				/*
				
				=================================  중요 =================================
				
				LRS Creation에서는 스케쥴의 가장 첫 VVD는 Virtual Port를 생성하지 않는다. <-- SW 설계자, 현업 협의사항
				
				*/
				
				String firstVoyNo = null;
				String firstDirCd = null;
				String prevDirCd = null;
				
				for(int m=0; m<list.size();){
					
					// 화면의 헤더부분에 Port 리스트 만큼 반복 
					for(int k=0; m<list.size() && k<pfSkdList.size(); k++){
						VskSwapCstPortVO skdVO = list.get(m++);
	
						// ETB, ETD가 비어있는 경우 다음 VO으로 이동. 실제 시간이 있는 VO를 찾을때까지 계속 이동
						if("".equals(skdVO.getVpsEtbDt())){
							continue;
						}
						
						// 1 Direction으로 구성되어 있는 P/F인 경우 Virtual 구성이 필요없다.
						if(oneWayDir){
							addPortSkd(skdVO, currVVD);
							continue;
						}
	
						// first VVD 정보 획득
						if(firstVoyNo==null && firstDirCd==null){
							firstVoyNo = skdVO.getSkdVoyNo();
							firstDirCd = skdVO.getSkdDirCd();
							prevDirCd = firstDirCd;
						}
						
						// Phase In 되어 들어온 스케쥴의 첫번째 VVD는 Virtual Port를 생성하지 않도록 설정한다.
						// 즉, first VVD 취급한다.
						if("I".equals(skdVO.getSkdCngStsCd())){
							firstVoyNo = skdVO.getSkdVoyNo();
							firstDirCd = skdVO.getSkdDirCd();
						}
						
						/*
							VVD가 바뀜
								- 바뀌기이전 prevVVD 는 더이상 추가될 정보가 없으므로 최종 리스트에 추가
								- 바뀌기이전 currVVD 는 바뀌후에는 이전 VVD가 되므로 prevVVD로 변경
								- 바뀐이후 currVVD는 비어있는 상태
							
							* 2 Direction인 경우
							 	- prevDirCd가 변경되는 시점
						*/
						if(!skdVO.getSkdDirCd().equals(prevDirCd)){
							portSkdList.addAll(prevVVD);
							prevVVD.clear();
							prevVVD.addAll(currVVD);
							currVVD.clear();
						}
						
						// 현재 VVD 리스트에 Port SKD 정보를 추가한다.
						skdVO = addPortSkd(skdVO, currVVD);
						
						// 맨 처음 VVD 스케쥴인 경우 TURN_PORT_FLG, TURN_PORT_IND_CD 를 N 처리한다.
						if(firstVoyNo.equals(skdVO.getSkdVoyNo()) && firstDirCd.equals(skdVO.getSkdDirCd())){
							skdVO.setTurnPortFlg("N");
							skdVO.setTurnPortIndCd("N");
						}
						
						// 맨 처음 VVD 스케쥴이 아닌경우 이전 VVD 리스트에 Virtual Port 스케쥴을 추가한다.
						if(!(firstVoyNo.equals(skdVO.getSkdVoyNo()) && firstDirCd.equals(skdVO.getSkdDirCd()))){
							// Virtual Port 리스트를 구성한 후, 필요한 정보를 획득한다.(Turnning 정보)
							skdVO = addVirtualPortSkd(skdVO, prevVVD);
							
							// Turnning 정보가 추가된 Port SKD 정보로 업데이트
							currVVD.set(currVVD.size()-1, skdVO);
						}
						
						// VVD 변경여부를 체크하기 위해 현재 Direction Code 체크
						prevDirCd = skdVO.getSkdDirCd();
	
					}
					
					/*
					// VVD가 바뀜
							- 바뀌기이전 prevVVD 는 더이상 추가될 정보가 없으므로 최종 리스트에 추가
							- 바뀌기이전 currVVD 는 바뀌후에는 이전 VVD가 되므로 prevVVD로 변경
							- 바뀐이후 currVVD는 비어있는 상태
						
						* 1 Direction인 경우
						 	- Voyage No가 변경되는 시점
				 	*/
					if(oneWayDir){
						portSkdList.addAll(prevVVD);
						prevVVD.clear();
						prevVVD.addAll(currVVD);
						currVVD.clear();
					}
					
				}
				
				// prevVVD, currVVD에 남아있는 스케쥴 정보-스케쥴표에서 가장 마지막 라인-를 최종 리스트에 포함한다.
				portSkdList.addAll(prevVVD);
				prevVVD.clear();
				portSkdList.addAll(currVVD);
				currVVD.clear();
				
			}
			
			// ---------- Step3. Virtual Port 정보를 포함하는 리스트로 전환 완료 ----------
			
	
			// ---------- Step4. VSK_VSL_SKD 에 등록할 정보 추출 시작  ----------
				
			List<VskSwapCstVvdVO> vslSkdList = new ArrayList<VskSwapCstVvdVO>();
			Map<String, String> keyMap = new HashMap<String, String>();
			String key = null;
			
			
			for(VskSwapCstPortVO portSkdVO : portSkdList){
				
				String startPortCd = null;
				String firstPortBerthDate = null;
				
				key = portSkdVO.getVslCd() + ":" + portSkdVO.getSkdVoyNo() + ":" + portSkdVO.getSkdDirCd();
				
				// VSK_VSL_SKD 테이블은 VVD(VSL_CD, SKD_VOY_NO, SKD_DIR_CD)가 키이므로
				// 모든 VVD 스케쥴 정보를 담고있는 portSkdList 리스트에서
				// VVD별 한건씩만 선택한다.
				if(keyMap.containsKey(key)){
					continue;
				}else{
					keyMap.put(key, key);
					startPortCd = portSkdVO.getVpsPortCd();
					firstPortBerthDate = portSkdVO.getVpsEtbDt();
				}
				
				VskSwapCstVvdVO vslSkdVO = new VskSwapCstVvdVO();
				vslSkdVO.setVslCd(portSkdVO.getVslCd());
				vslSkdVO.setSkdVoyNo(portSkdVO.getSkdVoyNo());
				vslSkdVO.setSkdDirCd(portSkdVO.getSkdDirCd());
				vslSkdVO.setSlanCd(portSkdVO.getSlanCd());
				
				if(vesselVOs.containsKey(portSkdVO.getVslCd())){
					MdmVslCntrVO mdmVslCntrVO = vesselVOs.get(portSkdVO.getVslCd());
					if("T".equals(mdmVslCntrVO.getVslClssFlg())){
						vslSkdVO.setSkdStsCd("RDY");
					}else{
						vslSkdVO.setSkdStsCd("ACT");
					}
				}
				
				vslSkdVO.setSkdUsdIndCd("H");
				vslSkdVO.setPfSkdTpCd(longRangeSkdGRPVO.getPfSvcTpCd());
				vslSkdVO.setStPortCd(startPortCd);
				vslSkdVO.setN1stPortBrthDt(firstPortBerthDate);
				vslSkdVO.setCoCd("H");
				vslSkdVO.setCreUsrId(longRangeSkdGRPVO.getCreUsrId());
				vslSkdVO.setUpdUsrId(longRangeSkdGRPVO.getUpdUsrId());
				
				vslSkdList.add(vslSkdVO);
				
			}
			
			for(int i=0; i<vslSkdList.size(); i++){
				// 화면에서 remark는 VVD두개에 걸쳐 이루어져 있으므로
				// 같은 항차를 가지는 두개의 VVD는 Remark 값이 같다.
				VskSwapCstVvdVO vslSkdVO = vslSkdList.get(i);
				if(oneWayDir){
					vslSkdVO.setSkdRmk(skdRmk[i*4]);
				}else{
					vslSkdVO.setSkdRmk(skdRmk[(i/2)*4]);
				}
			}
			
			// PSDO_VVD_CD 생성
			// "FD" + YYMMDD(첫번째 PORT VPS_ETD_DT) + "E"
			String vslSkdVvd = null;
			String portSkdVvd = null;
			for(VskSwapCstVvdVO vslSkdVO : vslSkdList){
				
				vslSkdVvd = vslSkdVO.getVslCd() + ":" + vslSkdVO.getSkdVoyNo() + ":" + vslSkdVO.getSkdDirCd();
				for(VskSwapCstPortVO portSkdVO : portSkdList){
					portSkdVvd = portSkdVO.getVslCd() + ":" + portSkdVO.getSkdVoyNo() + ":" + portSkdVO.getSkdDirCd();
					
					if(vslSkdVvd.equals(portSkdVvd)){
						
						// 첫번째 Port를 찾으면 PSDO_VVD_CD를 설정한다.
						vslSkdVO.setPsdoVvdCd("FD" + getDateString("yyMMdd", "yyyyMMddHHmm", portSkdVO.getVpsEtbDt()) + "E");
						
						break;
					}
				}
	
			}
		
		// ---------- Step4. VSK_VSL_SKD 에 등록할 정보 추출 완료  ----------
		
		
		// ---------- Step5. 시뮬레이션 스케쥴 정보를 DB에 저장 시작  ----------
			
			List<VskVslSkdVO> vskVslSkdList = new ArrayList<VskVslSkdVO>();
			for(VskSwapCstVvdVO vslSkdVO : vslSkdList){
				VskVslSkdVO vo = new VskVslSkdVO();
				vo.setVslCd(vslSkdVO.getVslCd());
				vo.setSkdVoyNo(vslSkdVO.getSkdVoyNo());
				vo.setSkdDirCd(vslSkdVO.getSkdDirCd());
				vo.setVslSlanCd(vslSkdVO.getSlanCd());
				vo.setSkdStsCd(vslSkdVO.getSkdStsCd());
				vo.setSkdUsdIndCd("H");
				vo.setPfSkdTpCd(longRangeSkdGRPVO.getPfSvcTpCd());
				vo.setStPortCd(vslSkdVO.getStPortCd());
				vo.setN1stPortBrthDt(vslSkdVO.getN1stPortBrthDt());
				vo.setCoCd("H");
				vo.setSkdRmk(vslSkdVO.getSkdRmk());
				vo.setCreUsrId(longRangeSkdGRPVO.getCreUsrId());
				vo.setUpdUsrId(longRangeSkdGRPVO.getUpdUsrId());
				vo.setPsdoVvdCd(vslSkdVO.getPsdoVvdCd());
				vskVslSkdList.add(vo);
			}
			
			dbDao.addVskVslSkd(vskVslSkdList);				// VSK_VSL_SKD
			
			longRangeSkdGRPVO.setVskVslSkdList(vskVslSkdList);
			
			List<VslPortSkdVO> vskVslPortSkdList = new ArrayList<VslPortSkdVO>();
			for(VskSwapCstPortVO portSkdVO : portSkdList){
				
				if(portSkdVO.getInitEtaDt()==null){
					continue;
				}
				
				VslPortSkdVO vo = new VslPortSkdVO();
				
				vo.setVslCd(portSkdVO.getVslCd());
				vo.setSkdVoyNo(portSkdVO.getSkdVoyNo());
				vo.setSkdDirCd(portSkdVO.getSkdDirCd());
				vo.setVpsPortCd(portSkdVO.getVpsPortCd());
				vo.setNewClptIndSeq(portSkdVO.getClptIndSeq());
				vo.setClptSeq(portSkdVO.getClptSeq());
				vo.setSlanCd(portSkdVO.getSlanCd());
				vo.setPortSkdStsCd(portSkdVO.getPortSkdStsCd());
				vo.setYdCd(portSkdVO.getYdCd());
				vo.setCallYdIndSeq(portSkdVO.getCallYdIndSeq());
				vo.setPfEtaDt(portSkdVO.getPfEtaDt());
				vo.setPfEtbDt(portSkdVO.getPfEtbDt());
				vo.setPfEtdDt(portSkdVO.getPfEtdDt());
				vo.setInitEtaDt(portSkdVO.getInitEtaDt());
				vo.setInitEtbDt(portSkdVO.getInitEtbDt());
				vo.setInitEtdDt(portSkdVO.getInitEtdDt());
				vo.setVpsEtaDt(portSkdVO.getVpsEtaDt());
				vo.setVpsEtbDt(portSkdVO.getVpsEtbDt());
				vo.setVpsEtdDt(portSkdVO.getVpsEtdDt());
				vo.setPortSkpTpCd(portSkdVO.getPortSkpTpCd());
				vo.setPortSkpRsnCd(portSkdVO.getPortSkpRsnCd());
				vo.setPortSkpRsnOffrRmk(portSkdVO.getPortSkpRsnOffrRmk());
				vo.setTtlDlayHrs(portSkdVO.getTtlDlayHrs());
				vo.setTsPortCd(portSkdVO.getTsPortCd());
				vo.setUsdFlg(portSkdVO.getUsdFlg());
				vo.setNoonRptInpFlg(portSkdVO.getNoonRptInpFlg());
				vo.setDepRptInpFlg(portSkdVO.getDepRptInpFlg());
				vo.setActInpFlg(portSkdVO.getActInpFlg());
				vo.setPrtChkFlg(portSkdVO.getPrtChkFlg());
				vo.setCreUsrId(portSkdVO.getCreUsrId());
				vo.setUpdUsrId(portSkdVO.getUpdUsrId());
				vo.setVslDlayRsnCd(portSkdVO.getVslDlayRsnCd());
				vo.setVslDlayRsnDesc(portSkdVO.getVslDlayRsnDesc());
				vo.setShpCallNo(portSkdVO.getShpCallNo());
				vo.setShpCallNoUpdUsrId(portSkdVO.getShpCallNoUpdUsrId());
				vo.setShpCallNoUpdDt(portSkdVO.getShpCallNoUpdDt());
				vo.setTmlVoyNo(portSkdVO.getTmlVoyNo());
				vo.setTmlVslCd(portSkdVO.getTmlVslCd());
				vo.setFtDt(portSkdVO.getFtDt());
				vo.setPlismYdCd(portSkdVO.getPlismYdCd());
				vo.setPlismVoyNo(portSkdVO.getPlismVoyNo());
				vo.setPlismVslCd(portSkdVO.getPlismVslCd());
				vo.setSkdCngStsCd(portSkdVO.getSkdCngStsCd());
				vo.setTurnPortFlg(portSkdVO.getTurnPortFlg());
				vo.setTurnPortIndCd(portSkdVO.getTurnPortIndCd());
				vo.setTurnSkdVoyNo(portSkdVO.getTurnSkdVoyNo());
				vo.setTurnSkdDirCd(portSkdVO.getTurnSkdDirCd());
				vo.setTurnClptIndSeq(portSkdVO.getTurnClptIndSeq());
				vo.setIbCgoQty(portSkdVO.getIbCgoQty());
				vo.setObCgoQty(portSkdVO.getObCgoQty());
				vo.setVpsRmk(portSkdVO.getVpsRmk());
				vo.setPhsIoRsnCd(portSkdVO.getPhsIoRsnCd());
				vo.setPhsIoRmk(portSkdVO.getPhsIoRmk());
				vo.setSkdBrthNo(portSkdVO.getSkdBrthNo());
				vo.setInitSkdInpFlg("Y");
				vo.setOfcInpFlg(portSkdVO.getOfcInpFlg());
				vo.setSeaBufHrs(portSkdVO.getSeaBufHrs());
				vo.setPortBufHrs(portSkdVO.getPortBufHrs());
				
				vskVslPortSkdList.add(vo);
			}
			
			// Long Range SKD Creation 에서 마지막 스케쥴( Turnning Port가 F인 것)은 저장하지 않는다.
			if("F".equals(vskVslPortSkdList.get(vskVslPortSkdList.size()-1).getTurnPortFlg())){
				vskVslPortSkdList.remove(vskVslPortSkdList.size()-1);
			}
			
			dbDao.addVskVslPortSkd(vskVslPortSkdList);		// VSK_VSL_PORT_SKD
			
			return longRangeSkdGRPVO;

		}catch(DAOException ex){
			log.error("err " + ex.toString(), ex);
			
			if(ex.toString().indexOf("FRM10501")>-1 || ex.toString().indexOf("TimedOutException")>-1){
				// TimeOutException 이 발생하면 Framework에서 FRM10501 Exception을 발생한다.
				throw new EventException(new ErrorHandler("VSK10076").getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
			}
			
		} catch (EventException e) {
			throw e;
		}catch(Exception e){
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), e);
		}
		
		// ---------- Step5. 시뮬레이션 스케쥴 정보를 DB에 저장 완료  ----------		
		
	}
	
//	/**
//	 * KTNET에게 송신, BKG이 들어오고 이를 (주)한진으로 국내운송 ORDER를 내릴때
//	 * (주)한진 시스템에 선명이 등록되어 있어야 하기 때문에 선명마다,
//	 * 또 PORT마다 (주)한지 시스템에 직접 입력하여 선명등록 EDI 전송하는 형식임
//	 * 
//	 * @param List<VvdVO> vvdVOs
//	 * @exception EventException
//	 */
//	public void sendEdiToDLS(List<VvdVO> vvdVOs) throws EventException {
//		try{
//
//			if(vvdVOs != null && vvdVOs.size() > 0){
//				for(int i=0; i<vvdVOs.size(); i++){
//					
//					VvdVO vvdVO = new VvdVO();
//					vvdVO = vvdVOs.get(i);
//					
//					//해당 vvd에 대한 port list
//					List<EdiMsgToDLSVO> list = dbDao.searchEdiMsgToDLS(vvdVO);
//					
//					if(list != null && list.size() > 0){
//						
//						// ACT 인 경우만 채번하도록 수정. 2010.03.08
//						//전문의  seq를 증가시킨 헤더
//						String jumunHeader = dbDao.searchEdiHdToDLS();
//						//new line
//						String suffix = "\n";
//						
//						//String jumun = "";
//						StringBuilder jumun = new StringBuilder();
//						//interface id
////						String queueName = "";
//						
//						jumun.append(jumunHeader).append(suffix);
//						for(int k=0; k<list.size(); k++){
//							jumun.append("{VVD").append(suffix);
//							jumun.append("VSL_CD:").append(list.get(k).getVslCd()).append(suffix);
//							jumun.append("VOY:").append(list.get(k).getVoy()).append(suffix);
//							jumun.append("DIR:").append(list.get(k).getDir()).append(suffix);
//							jumun.append("POL_LOC:").append(list.get(k).getPolLoc()).append(suffix);
//							jumun.append("LANE:").append(list.get(k).getLane()).append(suffix);
//							jumun.append("VSL_NM:").append(list.get(k).getVslNm()).append(suffix);
//							jumun.append("CCT:").append(list.get(k).getCct()).append(suffix);
//							jumun.append("ETB:").append(list.get(k).getEtb()).append(suffix);
//							jumun.append("ETD:").append(list.get(k).getEtd()).append(suffix);
//							jumun.append("VVD}").append(suffix);
//						}
//						
////						queueName = SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.QUEUE");
//						//flatFile = 전문의 헤더와 내용
//						//전문 헤더와 내용을 담을 변수
//						String flatFile = jumun.toString();
//						
////						sendEdiToDLS(queueName , flatFile);
//						
//						// CHM-201006129-01
//						// EDI 전송후 전송내역을 VSK_CUST_EDI_LOG 테이블에 기록
//						
//						//전문 SEQ 조회
//						String vskdEdiSndId = dbDao.searchEdiHdSeqToKlnet();
//						VskCustEdiLogVO vskCustEdiLogVO = new VskCustEdiLogVO();
//						vskCustEdiLogVO.setCustTrdPrnrId("DLS");
//						vskCustEdiLogVO.setVskdEdiSndId(vskdEdiSndId);
//						vskCustEdiLogVO.setN1stVslCd(vvdVO.getVslCd());
//						vskCustEdiLogVO.setN1stSkdVoyNo(vvdVO.getSkdVoyNo());
//						vskCustEdiLogVO.setN1stSkdDirCd(vvdVO.getSkdDirCd());
//						vskCustEdiLogVO.setCreUsrId(vvdVO.getCreUsrId());
//						vskCustEdiLogVO.setUpdUsrId(vvdVO.getUpdUsrId());
//						vskCustEdiLogVO.setDiffRmk(flatFile);
//						dbDao.addVskCustEdiLogToDLS(vskCustEdiLogVO);
//					}
//				}
//			}
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
////		} catch (EventException ex) {
////			throw ex;
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		}
//	}
	
//	/**
//	 * Vessel Port Schedule에 CUD가 발생할 경우 ERP로 변경 정보를 송신
//	 * 
//	 * @param List<VvdVO> erpIfVvdVOs
//	 * @exception EventException
//	 */
//	public void sendVslSkdErpIf(List<VvdVO> erpIfVvdVOs) throws EventException {
//		try{
//			if(erpIfVvdVOs != null && erpIfVvdVOs.size() > 0){
//				for(int i=0; i<erpIfVvdVOs.size(); i++){
//					VvdVO vvdVO = new VvdVO();
//					vvdVO = erpIfVvdVOs.get(i);
//				
//					List<ErpMsgFns017VO> list = dbDao.searchErpIfSendingData(vvdVO);
//					if(list.size() > 0){
//						
//						
////						String reString = sendVslSkdErpIf2(list);
//						String reString = "";//진마리아
//						String[] res = new String[]{"", ""};
//						
//						if(reString!=null && reString.indexOf(":")>-1){
//							res = reString.split(":");	
//						}
//						
//						// CHM-201006456-01
//						// EDI 전송후 전송내역을 VSK_CUST_EDI_LOG 테이블에 기록
//						
//						//전문 SEQ 조회
//						String vskdEdiSndId = dbDao.searchEdiHdSeqToKlnet();
//						VskCustEdiLogVO vskCustEdiLogVO = new VskCustEdiLogVO();
//						vskCustEdiLogVO.setCustTrdPrnrId("FNS017");
//						if(res[1]!=null && res[1].length()>0){						
//							vskCustEdiLogVO.setVskdEdiSndId(res[1]);
//						}else{
//							vskCustEdiLogVO.setVskdEdiSndId(vskdEdiSndId);
//						}
//						vskCustEdiLogVO.setN1stVslCd(vvdVO.getVslCd());
//						vskCustEdiLogVO.setN1stSkdVoyNo(vvdVO.getSkdVoyNo());
//						vskCustEdiLogVO.setN1stSkdDirCd(vvdVO.getSkdDirCd());
//						vskCustEdiLogVO.setCreUsrId(vvdVO.getCreUsrId()==null?" ":vvdVO.getCreUsrId());
//						vskCustEdiLogVO.setUpdUsrId(vvdVO.getUpdUsrId()==null?" ":vvdVO.getUpdUsrId());
//						vskCustEdiLogVO.setDiffRmk(res[0]);
//						dbDao.addVskCustEdiLogToDLS(vskCustEdiLogVO);
//					}
//				}
//			}
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			if(ex.toString().indexOf("FRM10501")>-1 || ex.toString().indexOf("TimedOutException")>-1){
//				// TimeOutException 이 발생하면 Framework에서 FRM10501 Exception을 발생한다.
//				throw new EventException(new ErrorHandler("VSK10076").getMessage(), ex);
//			}else{
//				throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//			}
////		} catch (EventException ex) {
////			throw ex;
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		}
//	}
	
	/**
	 * Long Range Schedule 을 시뮬레이션 합니다. 
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return List<LongRangeSkdVO>
	 * @exception EventException
	 */
	public List<LongRangeSkdVO> simulateLongRngSkd(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException {
		
		try {
			List<String[]> vslInfo = longRangeSkdGRPVO.getVslInfo();
			String endDate = longRangeSkdGRPVO.getEndDate().replaceAll("-", "");
			
			PfSkdVO[] pfSkdVOS = longRangeSkdGRPVO.getPfSkdVOs();
			String voyNoType = longRangeSkdGRPVO.getVoyNoType();
			String svcDurDys = longRangeSkdGRPVO.getSvcDurDys();
			int iSvcDurDys = VSKGeneralUtil.getCheckNullToString(svcDurDys).equals("")?0:Integer.parseInt(svcDurDys);
			
			String vslCount = longRangeSkdGRPVO.getVslCount();
			int iVslCount = VSKGeneralUtil.getCheckNullToString(vslCount).equals("")?0:Integer.parseInt(vslCount);
			
			validatePfSkd(pfSkdVOS);
	
			List<LongRangeSkdVO> list = null;
	
			if ("btn_Simulation".equals(longRangeSkdGRPVO.getOpType())) { // simulation
				list = getSimSkd(pfSkdVOS, vslInfo, endDate, 0, voyNoType, iSvcDurDys, iVslCount);
			} else if ("btn_PhaseIn".equals(longRangeSkdGRPVO.getOpType())) { // phase in
				
				
				list = new ArrayList<LongRangeSkdVO>();
				int phaseInPort = Integer.parseInt(longRangeSkdGRPVO.getPhaseinCol()) - 1;
				
				List<String[]> phaseInVslInfo = new ArrayList<String[]>();
				String[] phaseinVslInfo = new String[]{
						longRangeSkdGRPVO.getPhaseinStartDate(),
						longRangeSkdGRPVO.getPhaseinVslCd(),
						longRangeSkdGRPVO.getPhaseinVoyNo()
				};
				phaseInVslInfo.add(phaseinVslInfo);
	
				// PhaseIn 된 Vessel에 대한 스케쥴만 생성. 기존 Vessel 리스트는 백업
				List<String[]> orgVslInfo = longRangeSkdGRPVO.getVslInfo();
				longRangeSkdGRPVO.setVslInfo(phaseInVslInfo);
				List<LongRangeSkdVO> phaseInVOList = getSimSkd(pfSkdVOS, phaseInVslInfo, endDate, phaseInPort, voyNoType, iSvcDurDys, iVslCount);
				
				// 화면 스케쥴 정보 획득
				List<LongRangeSkdVO> srcList = loadSimDataList(longRangeSkdGRPVO, 0, 0, null, false);
				
				longRangeSkdGRPVO.setVslInfo(orgVslInfo);
				
				////////////////////////////////
				
				List<List<LongRangeSkdVO>> skdSplitList = new ArrayList<List<LongRangeSkdVO>>();
				List<List<LongRangeSkdVO>> phaseInSplitList = new ArrayList<List<LongRangeSkdVO>>();
				List<List<LongRangeSkdVO>> finalList = new ArrayList<List<LongRangeSkdVO>>();
				
				int pos = 0;
				for(int i=0; i<srcList.size(); i++){
					// split
					if(srcList.get(i).getVslCd()==null){
						skdSplitList.add(srcList.subList(pos, i));
						pos = i+1;
					}
				}
				
				pos = 0;
				for(int i=0; i<phaseInVOList.size(); i++){
					// split
					if(phaseInVOList.get(i).getVslCd()==null){
						phaseInSplitList.add(phaseInVOList.subList(pos, i));
						pos = i+1;
					}
				}
				
				// 최종 조합
				
				List<String[]> vslInfos = longRangeSkdGRPVO.getVslInfo();
				int m = 0;
				int k = 0;
		
				// longRangeSkdGRPVO.getPhaseinRow() <== 화면에서 phasein 선택한 줄
				// 1부터 4단위로 늘어남.
				while(m!=skdSplitList.size() || k!=phaseInSplitList.size()){
					if(
							!"0".equals(longRangeSkdGRPVO.getPhaseinRow()) && // simple phasein 인 경우는 기존스케쥴(srcList)이 없으므로 final에 반영할 것도 없다.
							m<Integer.parseInt(longRangeSkdGRPVO.getPhaseinRow())+3){ // 선택된 phasein 줄 + 숨겨진 3row 은 먼저 표시함
						finalList.add(skdSplitList.get(m++));
					}else{
						if(k<phaseInSplitList.size()){
							finalList.add(phaseInSplitList.get(k++));
							finalList.add(phaseInSplitList.get(k++));
							finalList.add(phaseInSplitList.get(k++));
							finalList.add(phaseInSplitList.get(k++));
						}
						for(int i=0; i<vslInfos.size()*4;i++){
							if(m<skdSplitList.size()){
								finalList.add(skdSplitList.get(m++));
							}
						}
					}
				}
				
				for(int i=0; i<finalList.size(); i++){
					List<LongRangeSkdVO> fList = finalList.get(i);
					for(int j=0; j<fList.size(); j++){
						list.add(fList.get(j));
					}
					list.add(new LongRangeSkdVO());
				}
				
				
			} else if ("btn_AddCall".equals(longRangeSkdGRPVO.getOpType())) { // add call
				int addCallPos = Integer.parseInt(longRangeSkdGRPVO.getAddCallPoint());
				
				String addCallPosition = longRangeSkdGRPVO.getAddCallPosition();
				if("before".equals(addCallPosition)){
					addCallPos = addCallPos + 0; 
				}else if("after".equals(addCallPosition)){
					addCallPos = addCallPos + 1;
				}
				
				int addVvdPos = Integer.parseInt(longRangeSkdGRPVO.getAddVvdPoint());			
				String addPortCd = longRangeSkdGRPVO.getAddCallPortCd();
				String etb = longRangeSkdGRPVO.getAddCallEtb();
				String etd = longRangeSkdGRPVO.getAddCallEtd();
				
				LongRangeSkdVO addCallVo = new LongRangeSkdVO();
				addCallVo.setPortCd(addPortCd);
				
				addCallVo.setEtbDyCd("");
				addCallVo.setInitEtbDay("");
				addCallVo.setInitEtbDay("");
				addCallVo.setInitEtbDate(etb);
						
				addCallVo.setEtdDyCd("");
				addCallVo.setInitEtdDay("");
				addCallVo.setInitEtdDay("");
				addCallVo.setInitEtdDate(etd);
				
				// 화면 스케쥴 정보 획득
				list = loadSimDataList(longRangeSkdGRPVO, addCallPos, addVvdPos, addCallVo, false);
			} else if ("btn_AddCallCancel".equals(longRangeSkdGRPVO.getOpType())) { // add call cancel
				
				int addCallPos = Integer.parseInt(longRangeSkdGRPVO.getAddCallPoint());
				int addVvdPos = Integer.parseInt(longRangeSkdGRPVO.getAddVvdPoint());
				
				// 화면 스케쥴 정보 획득
				list = loadSimDataList(longRangeSkdGRPVO, addCallPos, addVvdPos, null, true);
			}

			return list;
			
		} catch (EventException e) {
			log.error("err " + e.toString(), e);
			throw e;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), de);
		}

	}
	
	/**
	 * 해당 VVD로 RUSE_PROHI_FLG 값을 확인한다.
	 * 
	 * @param VvdVO vvdVO
	 * @return String
	 * @exception EventException
	 */
	public String checkReuseVvd(VvdVO vvdVO) throws EventException {
		try {
			return dbDao.checkReuseVvd(vvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
//	/**
//	 * 해당 VVD를 사용하는 Booking 정보가 있는지 확인합니다.<br>
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return int
//	 * @exception EventException
//	 * @author jinwoo
//	 */
//	public int checkVvdApplyBooking(VvdVO vvdVO) throws EventException {
//		try {
//			return dbDao.checkVvdApplyBooking(vvdVO);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		}
//	}
	
//	/**
//	 * 해당 VVD로 Actual Port Schedule이 입력되여 있는지 확인한다.<br>
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return int
//	 * @exception EventException
//	 * @author jinwoo
//	 */
//	public int checkVvdActualSkdInput(VvdVO vvdVO) throws EventException {
//		try {
//			return dbDao.checkVvdActualSkdInput(vvdVO);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		}
//	}
	
	/**
	 * VVD별 Vessel Schedule 정보를 조회합니다.
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception EventException
	 * @author jinwoo
	 */
	public List<CstSkdByVvdVO> searchCstSkdByVvd(CstSkdByVvdVO cstSkdByVvdVO) throws EventException {
		try {
			return dbDao.searchCstSkdByVvd(cstSkdByVvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * VVD의 Costal Schedule을 조회합니다.<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception EventException
	 * @author jinwoo
	 */
	public List<CstSkdByVvdVO> searchCstSkdByPfSkdUse(CstSkdByVvdVO cstSkdByVvdVO) throws EventException {
		try {
			return dbDao.searchCstSkdByPfSkdUse(cstSkdByVvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * 변경된 Vessel Port SKD 정보를 변경 및 삭제한다.
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param SignOnUserAccount account
	 * 
	 * @exception EventException
	 */
	public void manageCstSkdByVvd(CstSkdByVvdVO[] cstSkdByVvdVOs, SignOnUserAccount account) throws EventException{
//		VslSkdChgStsGRPVO vslSkdChgStsGRPVO = new VslSkdChgStsGRPVO();
		
		try{
			if(cstSkdByVvdVOs != null){
				List<VskVslSkdVO> insertVoList = new ArrayList<VskVslSkdVO>();
				List<VskVslSkdVO> updateVoList = new ArrayList<VskVslSkdVO>();
				List<VskVslSkdVO> deleteVoList = new ArrayList<VskVslSkdVO>();
				
				String userId = currentUserId(account, cstSkdByVvdVOs[0].getUpdUsrId());
				
				/*************************************************************************************
				 * VVD
				 *************************************************************************************/
				insertVoList = getMasterInsertData(cstSkdByVvdVOs, userId);
				updateVoList = getMasterUpdateData(cstSkdByVvdVOs, userId);
				deleteVoList = getMasterDeleteData(cstSkdByVvdVOs, userId);
				
				if(insertVoList != null && insertVoList.size() > 0) isCheckLaneDir(insertVoList);
				if(insertVoList != null && insertVoList.size() > 0) isCheckVslCntr(insertVoList);
				if(updateVoList != null && updateVoList.size() > 0) isCheckLaneDir(updateVoList);
				if(updateVoList != null && updateVoList.size() > 0) isCheckVslCntr(updateVoList);
				if(deleteVoList != null && deleteVoList.size() > 0) isCheckVslCntr(deleteVoList);
				
				/*************************************************************************************
				 * Port
				 *************************************************************************************/
				List<VslPortSkdVO> insertPortVoList = new ArrayList<VslPortSkdVO>();
				List<VslPortSkdVO> updatePortVoList = new ArrayList<VslPortSkdVO>();
				
				// VSK_VSL_PORT_SKD의 키값이 아닌 항목에 대해서만 수정이 발생하는 경우
				List<VslPortSkdVO> updatePortDataList = new ArrayList<VslPortSkdVO>();  
				
				List<VslPortSkdVO> deletePortVoList = new ArrayList<VslPortSkdVO>();
				List<VskVslPortSkdVO> deleteVirtualPortVoList = new ArrayList<VskVslPortSkdVO>();
				List<VslPortSkdVO> insertVirtualPortVoList = new ArrayList<VslPortSkdVO>();
				List<VskVslPortSkdVO> updateNextPortVoList = new ArrayList<VskVslPortSkdVO>();
				List<VskVslPortSkdVO> deleteVirtualPortERPVoList = new ArrayList<VskVslPortSkdVO>();	//삭제된 Virtual Port 를 ERP에 전송하기 위해.
				List<VskVslPortSkdVO> curPortInfoVOList = null;			// 화면에서 넘어 온 VVD 별 Port 정보(VVD 가 여러 건일 경우 사용).
				List<VskVslPortSkdVO> prePortInfoVOList = null;			// 화면에서 넘어 온 VVD 별 Port 정보(VVD 가 여러 건일 경우 사용).
				
				List<VskVslPortSkdVO> totalOrgPortList = new ArrayList<VskVslPortSkdVO>();
	
//				boolean isFirstPort = false;		// 첫번째 Port 여부.
				int vitualSeq = 0; 					// Virtual 순서(몇번째 Virtual 인지 알기 위해 : 첫번째 Virtual 은 Next Port 생성 시 turn_port_ind_cd 를 'N' 으로)
	
				List<VskVslSkdVO> masterVoList = getMasterVvdList(cstSkdByVvdVOs, userId);		// cstSkdByVvdVOs 로 넘어 온 VVD
				boolean firstVVD = true;
				
				for(VskVslSkdVO vskVslSkdVO : masterVoList){
					String vslCd = vskVslSkdVO.getVslCd();
					String skdVoyNo = vskVslSkdVO.getSkdVoyNo();
					String skdDirCd = vskVslSkdVO.getSkdDirCd();
					
					VskVslPortSkdVO originPortParamVO = new VskVslPortSkdVO();
					originPortParamVO.setVslCd(vslCd);
					originPortParamVO.setSkdVoyNo(skdVoyNo);
					originPortParamVO.setSkdDirCd(skdDirCd);
					List<VskVslPortSkdVO> originPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(originPortParamVO);	//현재 VVD의 저장되기 전의 Port 정보를 조회한다.
					
					if(originPortVoList != null && originPortVoList.size()>0){
						totalOrgPortList.addAll(originPortVoList);
					}
					
					if(curPortInfoVOList != null){ //for R4J rule
						prePortInfoVOList = curPortInfoVOList;
					}
					curPortInfoVOList = new ArrayList<VskVslPortSkdVO>();
					int currSeq = 0;		// Port - for loop seq
//					isFirstPort = true;
					
					for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs){
						// VVD 별 실행.
						if(vslCd.equals(cstSkdByVvdVO.getVslCd()) && skdVoyNo.equals(cstSkdByVvdVO.getSkdVoyNo()) && skdDirCd.equals(cstSkdByVvdVO.getSkdDirCd())){
							String ibFlag = cstSkdByVvdVO.getIbflag();
							String newClptIndSeq = cstSkdByVvdVO.getNewClptIndSeq();		// 동일 VVD 내의 Port 갯수
							String vpsPortCd = cstSkdByVvdVO.getVpsPortCd();
							String ydCd = vpsPortCd + cstSkdByVvdVO.getTmlCd();				// Yard Code = Port Code + Terminal Code
							String turnPortFlg = cstSkdByVvdVO.getTurnPortFlg();
							String turnPortIndCd = cstSkdByVvdVO.getTurnPortIndCd();
							String turnClptIndSeq = cstSkdByVvdVO.getTurnClptIndSeq();
							String turnSkdVoyNo = cstSkdByVvdVO.getTurnSkdVoyNo();
							String turnSkdDirCd = cstSkdByVvdVO.getTurnSkdDirCd();
							int nTurnClptIndSeq = 0;	//Turnning VVD 내의 Port 갯수
							int nCallYdIndSeq = makeCallYardSeq(cstSkdByVvdVOs, currSeq);	//Yard Seq(동일 VVD 내의 Yard 갯수)
							
							//================================================================================================================
							// 현재VVD(화면에서 넘어온 정보)의 Port 정보들을 Table(TABLE VO) 기준으로 갖고 있는다.
							VskVslPortSkdVO curPortInfoVO = new VskVslPortSkdVO();
							curPortInfoVO.setIbflag(ibFlag);
							curPortInfoVO.setVslCd(vslCd);
							curPortInfoVO.setSkdVoyNo(skdVoyNo);
							curPortInfoVO.setSkdDirCd(skdDirCd);
							curPortInfoVO.setVpsPortCd(vpsPortCd);
							curPortInfoVO.setClptIndSeq(cstSkdByVvdVO.getClptIndSeq());
							curPortInfoVO.setSlanCd(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSlanCd(), cstSkdByVvdVO.getVslSlanCd()));
							curPortInfoVO.setYdCd(ydCd);
							curPortInfoVO.setTurnPortFlg(turnPortFlg);
							
							curPortInfoVOList.add(curPortInfoVO);
							//================================================================================================================
							
							//================================================================================================================
							//[사용자가 조회한 후 Data가 변경이 되어 있는 경우 START]
							if(originPortVoList != null && originPortVoList.size()>0){
								for(VskVslPortSkdVO vskVslPortSkdVO : originPortVoList){
									if(vpsPortCd.equals(vskVslPortSkdVO.getVpsPortCd()) && cstSkdByVvdVO.getClptIndSeq().equals(vskVslPortSkdVO.getClptIndSeq())){
										if(!cstSkdByVvdVO.getUpdDt().equals(vskVslPortSkdVO.getUpdDt())){
											/*
											 * 저장시 동일한 데이터가 누군가가 이미 변경했을 경우. 동일 데이터를 여러 사용자가 공유할 경우 발생하는 에러방지
											 * MSG - Someone has already changed same data. After retrieve and retry again.
											 */
											throw new EventException(new ErrorHandler("VSK10077", new String[]{vskVslPortSkdVO.getUpdUsrId()}).getMessage());
										}
									}
								}
							}
							//[사용자가 조회한 후 Data가 변경이 되어 있는 경우 END]
							//================================================================================================================
							
							
							// turn_port_ind_cd 를 각 경우별로 판단한다.
							turnPortIndCd = turnPortIndCdControl(turnPortIndCd, turnPortFlg, cstSkdByVvdVO.getPortRotnSeq(), cstSkdByVvdVO.getVslSlanCd(), skdDirCd, cstSkdByVvdVO.getClptSeq());
							
							String originTurnVoyNo = "";		// 화면에서 변경하기 전의 Original TurnVoyNo
							String originTurnDirCd = "";		// 화면에서 변경하기 전의 Original TurnDirCd
							
							if(originPortVoList != null && originPortVoList.size()>0){
								for(VskVslPortSkdVO vskVslPortSkdVO : originPortVoList){
									if("Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
										originTurnVoyNo = vskVslPortSkdVO.getTurnSkdVoyNo();
										originTurnDirCd = vskVslPortSkdVO.getTurnSkdDirCd();
										break;
									}
								}
							}
							
							//================================================================================================================
							// [Virtual Port 정보 조회 START]
							
							if("Y".equals(turnPortFlg)){
								// Tunning Port Validation(정합성 Check).
								checkVskVslPortSkd(vslCd, skdVoyNo, skdDirCd, turnSkdVoyNo, turnSkdDirCd);
								
								// Virtual 정보를 조회한다.
								VskVslPortSkdVO virtualPortParamVO = new VskVslPortSkdVO();
								virtualPortParamVO.setVslCd(vslCd);
								virtualPortParamVO.setSkdVoyNo(turnSkdVoyNo);
								virtualPortParamVO.setSkdDirCd(turnSkdDirCd);
								
								// 화면에서 생성하려는 Virtual Port
								List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(virtualPortParamVO);
								
								// 첫번째 VVD일 때, turning으로 연결된 앞선 VVD의, Virtual Port 리스트를 totalOrgPortList에 추가한다.
								// 이유는 첫번째 VVD에서 변경 사항이 발생한 경우, 이와 연결된 VVD에도 변경 사항을 적용해 주기 위해서이다.
								if(firstVVD){
									for(VskVslPortSkdVO vskVslPortSkdVO : virtualPortVoList){
										if("D".equals(vskVslPortSkdVO.getTurnPortIndCd()) ||
												"V".equals(vskVslPortSkdVO.getTurnPortIndCd()) ||
												"F".equals(vskVslPortSkdVO.getTurnPortIndCd())){
											totalOrgPortList.add(vskVslPortSkdVO);
										}
									}
								}else{
									firstVVD = false;
								}
								
								// Virtual Port Turn Indicator Code 판단.
								String virtualTurnPortIndCd = virtualTurnPortIndCdControl(cstSkdByVvdVO, virtualPortVoList.get(0).getSlanCd(), turnPortIndCd);
								
								// 입력받은 Turning Vvd, Port 정보를 이용하여 Virtual Vessel Port Schedule 정보를 생성한다.
								if(virtualPortVoList != null && virtualPortVoList.size() > 0){
									int preVvdExCnt  = 0;			//이전 VVD 의 Virtual을 제외한 Port 수
									int virtualCallYdIndSeq = 0;
									String prePortCd = "";
									String virtualLaneCd = "";
									
									// 화면에서 Port 를 삭제등 조작할 수 있으므로 화면상에 존재하는 VVD는 화면상의 Data 로 판단.
									if(prePortInfoVOList != null && prePortInfoVOList.size() > 0){
										// 여러건의 VVD 가 넘어와서 첫번째 이후의 Virtual을 생성할때 화면에서 넘어온 이전 VVD 의 정보를 참조하여 생성.
										String delFlag = "";
										for(VskVslPortSkdVO prePortInfoVO : prePortInfoVOList){
											delFlag = prePortInfoVO.getIbflag();
											//삭제 건은 Count 하지 않는다.
											if(!"D".equals(delFlag)){
												preVvdExCnt++;
			
												prePortCd = prePortInfoVO.getVpsPortCd();
												if(vpsPortCd.equals(prePortCd)){
													nTurnClptIndSeq++;	//(= Virtual clpt_ind_seq)
												}
												
												if(ydCd.equals(prePortInfoVO.getYdCd())){
													virtualCallYdIndSeq++;
												}
											}
										}
										virtualLaneCd = prePortInfoVOList.get(0).getSlanCd();
									}else{
										// 단건의 VVD 가 넘어오거나 여러건의 VVD 가 넘어와서 첫번째 VVD 의 Virtual 을 생성할 경우.
										String tmpTurnPortIndCd = "";	//조회한 Virtual Port의 TurnPortIndCd
										for(VskVslPortSkdVO virtualPortVo : virtualPortVoList){
											tmpTurnPortIndCd = virtualPortVo.getTurnPortIndCd();
											//Virtual Port 인 것은 Count 하지 않는다.
											if(!VSKGeneralUtil.isVirtualPort(tmpTurnPortIndCd)){
												preVvdExCnt++;
			
												prePortCd = virtualPortVo.getVpsPortCd();
												if(vpsPortCd.equals(prePortCd)){
													nTurnClptIndSeq++;	//(= Virtual clpt_ind_seq)
												}
												
												if(ydCd.equals(virtualPortVo.getYdCd())){
													virtualCallYdIndSeq++;
												}
											}
										}
										virtualLaneCd = virtualPortVoList.get(0).getSlanCd();
									}
									
									//Virtual Port 에 해당 Port 를 추가하므로 해당 Port의 clptIndSeq만큼 증가 시킨다.
									nTurnClptIndSeq = getParsingTurnClptIndSeq(nTurnClptIndSeq, newClptIndSeq);
									virtualCallYdIndSeq = virtualCallYdIndSeq + nCallYdIndSeq;
									
									// ****************************** Virtual Info ******************************
									VslPortSkdVO virtualPortVO = makeVirtualDataSet(cstSkdByVvdVO
																					, Integer.toString(nTurnClptIndSeq)
																					, Integer.toString(preVvdExCnt + curTurnPortCnt(curPortInfoVOList)) //이전 Port의 Virtual을 제외한 Port 수 + 현재까지의 Turnning 수(Turnning 이 띄엄띄엄 들어오는 경우 고려함.)
																					, virtualLaneCd
																					, ydCd
																					, Integer.toString(virtualCallYdIndSeq)
																					, virtualTurnPortIndCd
																					, userId);
									
									// ****************************** Virtual Delete Info ******************************
									// Virtual 정보는 Delete 후 다시 Insert
									if(deleteVirtualPortVoList != null && deleteVirtualPortVoList.size() > 0){
										int voSize = deleteVirtualPortVoList.size();
										for(int n=0; n<voSize; n++){
											VskVslPortSkdVO delPortVO = deleteVirtualPortVoList.get(n);
											if(!(delPortVO.getVslCd().equals(vslCd) 
													&& delPortVO.getSkdVoyNo().equals(turnSkdVoyNo)
													&& delPortVO.getSkdDirCd().equals(turnSkdDirCd))){
												VskVslPortSkdVO virtualDelPortVO = new VskVslPortSkdVO();
												virtualDelPortVO.setVslCd(vslCd);
												virtualDelPortVO.setSkdVoyNo(turnSkdVoyNo);
												virtualDelPortVO.setSkdDirCd(turnSkdDirCd);
												virtualDelPortVO.setSlanCd(virtualLaneCd);
												
												deleteVirtualPortVoList.add(virtualDelPortVO);
											}
											
											//기존 Virtual 정보와 새로 입력받은 Virtual 정보가 틀리면 기존 Virtual 정보 삭제.
											if(!(turnSkdVoyNo.equals(originTurnVoyNo) && turnSkdDirCd.equals(originTurnDirCd))){
												if(!(delPortVO.getVslCd().equals(vslCd) 
														&& delPortVO.getSkdVoyNo().equals(originTurnVoyNo)
														&& delPortVO.getSkdDirCd().equals(originTurnDirCd))){
													VskVslPortSkdVO virtualDelPortVO = new VskVslPortSkdVO();
													virtualDelPortVO.setVslCd(vslCd);
													virtualDelPortVO.setSkdVoyNo(originTurnVoyNo);
													virtualDelPortVO.setSkdDirCd(originTurnDirCd);
													virtualDelPortVO.setSlanCd(virtualLaneCd);
													
													deleteVirtualPortVoList.add(virtualDelPortVO);
												}
											}
										}
									}else{
										VskVslPortSkdVO virtualDelPortVO = new VskVslPortSkdVO();
										virtualDelPortVO.setVslCd(vslCd);
										virtualDelPortVO.setSkdVoyNo(turnSkdVoyNo);
										virtualDelPortVO.setSkdDirCd(turnSkdDirCd);
										virtualDelPortVO.setSlanCd(virtualLaneCd);
										
										deleteVirtualPortVoList.add(virtualDelPortVO);
										
										//기존 Virtual 정보와 새로 입력받은 Virtual 정보가 틀리면 기존 Virtual 정보 삭제.
										if(VSKGeneralUtil.isNotNull(originTurnVoyNo) && VSKGeneralUtil.isNotNull(originTurnDirCd)){
											if(!(turnSkdVoyNo.equals(originTurnVoyNo) && turnSkdDirCd.equals(originTurnDirCd))){
												VskVslPortSkdVO orgVirtualDelPortVO = new VskVslPortSkdVO();
												orgVirtualDelPortVO.setVslCd(vslCd);
												orgVirtualDelPortVO.setSkdVoyNo(originTurnVoyNo);
												orgVirtualDelPortVO.setSkdDirCd(originTurnDirCd);
												orgVirtualDelPortVO.setSlanCd(virtualLaneCd);
												
												deleteVirtualPortVoList.add(orgVirtualDelPortVO);
											}
										}
									}
									
									// ****************************** Virtual Insert Info ******************************
									//삭제인 경우는 Virtual Port 생성 막음.
									if(!"D".equals(ibFlag)){
										virtualPortVO.setCreDt(cstSkdByVvdVO.getCreDt());
										insertVirtualPortVoList.add(virtualPortVO);
									}
								}
							}
							//turnPortFlg 가 'Y'에서 'N'으로 변경된 건을 찾아 해당 작업 처리.
							else if("N".equals(turnPortFlg)){
								if(VSKGeneralUtil.isNotNull(originTurnVoyNo) && VSKGeneralUtil.isNotNull(originTurnDirCd)){
									VskVslPortSkdVO virtualPortParamVO = new VskVslPortSkdVO();
									// 기존 Virtual 정보로 Virtual 정보를 조회한다.
									virtualPortParamVO.setVslCd(vslCd);
									virtualPortParamVO.setSkdVoyNo(originTurnVoyNo);
									virtualPortParamVO.setSkdDirCd(originTurnDirCd);
									
									// 화면에서 변경하기 전의 Virtual Port
									List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(virtualPortParamVO);

									//Turn Port Flg 가 'Y'인 Virtual Port를 찾아 'N'으로 변경된 건 확인하여 해당 Virtual Port를 삭제.
									if(virtualPortVoList != null && virtualPortVoList.size() > 0){
										String orgVirtualTurnPortIndCd = "";
										String orgVirtualClptIndSeq = "";
										String orgVirtualVpsPortCd = "";
										for(VskVslPortSkdVO virtualPortVo : virtualPortVoList){
											orgVirtualTurnPortIndCd = virtualPortVo.getTurnPortIndCd();
											orgVirtualClptIndSeq = virtualPortVo.getClptIndSeq();
											orgVirtualVpsPortCd = virtualPortVo.getVpsPortCd();
											
											if(VSKGeneralUtil.isVirtualPort(orgVirtualTurnPortIndCd)){
												if(vpsPortCd.equals(orgVirtualVpsPortCd) && turnClptIndSeq.equals(orgVirtualClptIndSeq)){
													deleteVirtualPortVoList.add(virtualPortVo);
													
													nTurnClptIndSeq = 0;
													
													break;
												}
											}
										}
									}
								}
							}
							//[Virtual Port 정보 조회 END]
							//================================================================================================================
	
							//================================================================================================================
							//Virtual Port 변경 시 Next Port 수정.
							//TURN_PORT_IND_CD IN ('F', 'V', 'D')
							if(VSKGeneralUtil.isVirtualPort(turnPortIndCd)){
								vitualSeq++;
								VskVslPortSkdVO nxtVskVslPortSkdVO = makeNextPortDataSet(cstSkdByVvdVO, newClptIndSeq, turnClptIndSeq, vitualSeq, userId);
								updateNextPortVoList.add(nxtVskVslPortSkdVO);
								
								if(VSKGeneralUtil.isNull(turnClptIndSeq)){
									nTurnClptIndSeq = 0;
								}else{
									nTurnClptIndSeq = Integer.parseInt(turnClptIndSeq);
								}
							}
							// End Next Port Setting...
							//================================================================================================================
							
							if(nTurnClptIndSeq == 0){
								turnClptIndSeq = "";	//TURN_CLPT_IND_SEQ는 0이 아닌 NULL로 변경해야함.
							}else{
								turnClptIndSeq = Integer.toString(nTurnClptIndSeq);
							}
	
							// ************************************ VskVslPortSkdVO Info ************************************
							VslPortSkdVO vslPortSkdVO = makeVskVslPortDataSet(cstSkdByVvdVO
																			, Integer.toString(nCallYdIndSeq)
																			, turnClptIndSeq
																			, turnPortIndCd
																			, userId);
							
							
							if("I".equals(ibFlag)){
								vslPortSkdVO.setInitEtaDt(cstSkdByVvdVO.getVpsEtaDt());
								vslPortSkdVO.setInitEtbDt(cstSkdByVvdVO.getVpsEtbDt());
								vslPortSkdVO.setInitEtdDt(cstSkdByVvdVO.getVpsEtdDt());
								
								insertPortVoList.add(vslPortSkdVO);
							}else if ("U".equals(ibFlag)){
								vslPortSkdVO.setInitEtaDt(cstSkdByVvdVO.getInitEtaDt());
								vslPortSkdVO.setInitEtbDt(cstSkdByVvdVO.getInitEtbDt());
								vslPortSkdVO.setInitEtdDt(cstSkdByVvdVO.getInitEtdDt());
								
								boolean findSamePort = false;
								for(CstSkdByVvdVO vo : cstSkdByVvdVOs){
									if(
											vo.getVpsPortCd().equals(vpsPortCd) &&
											vo.getClptIndSeq().equals(newClptIndSeq) &&
											!vo.getIbflag().equals("D")){
										findSamePort = true;
										vslPortSkdVO.setClptIndSeq(newClptIndSeq);
										break;
									}
								}
								
								if(findSamePort){
									updatePortDataList.add(vslPortSkdVO);
								}else{
									updatePortVoList.add(vslPortSkdVO);									
								}
								
							}else if ("D".equals(ibFlag)){
//								if(isFirstPort){
									// Booking 정보 있는지 점검.
//									VvdVO vvdVO = new VvdVO();
//									vvdVO.setVslCd(vslCd);
//									vvdVO.setSkdVoyNo(skdVoyNo);
//									vvdVO.setSkdDirCd(skdDirCd);
//									int chkCnt = dbDao.checkVvdApplyBooking(vvdVO);
//									if(chkCnt > 0){
//										String curDate = VSKGeneralUtil.replaceDateTypeToString(JSPUtil.getKSTDate());
//										String etaDt = cstSkdByVvdVO.getVpsEtaDt().substring(0, 8);
//										long dateL = VSKGeneralUtil.dateDiff(curDate, "yyyyMMdd", etaDt, "yyyyMMdd", "d");
//										if(Math.abs(dateL) <= 3){
//											/*
//											 * MSG - 3일 이내에 Booking 이 존재하여 삭제할 수 없습니다.
//											 */
//											String[] errMsgs = new String[]{vslCd + skdVoyNo + skdDirCd};
//											throw new EventException(new ErrorHandler("VSK10075", errMsgs).getMessage());
//										}
//									}
//								}
								
								deletePortVoList.add(vslPortSkdVO);
								
								//Turnning Port 삭제 시 해당 Virtual 정보를 ERP에 전송하기 위해.
								if("Y".equals(vslPortSkdVO.getTurnPortFlg())){
									VskVslPortSkdVO tmpVO = new VskVslPortSkdVO();
									tmpVO.setVslCd(vslPortSkdVO.getVslCd());
									tmpVO.setSkdVoyNo(vslPortSkdVO.getTurnSkdVoyNo());
									tmpVO.setSkdDirCd(vslPortSkdVO.getTurnSkdDirCd());
									tmpVO.setSlanCd(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSlanCd(), cstSkdByVvdVO.getVslSlanCd()));
									
									deleteVirtualPortERPVoList.add(tmpVO);
								}
							}
						}
						
//						isFirstPort = false;
						currSeq++;
					}// end for(Port)
				}// end for(Master)
	
				
				// ***************** History START *****************
//				List<VslSkdHisInVO> vslSkdHisInVOs = makeHistoryDataSetByCoastal(cstSkdByVvdVOs, insertVirtualPortVoList, updateNextPortVoList, userId);
//				vslSkdChgStsGRPVO = manageVslSkdChgSts(vslSkdHisInVOs);
				// ***************** History  END  *****************
				
				//=============== VSK_VSL_SKD [INSERT, UPDATE]===============
				if(insertVoList != null && insertVoList.size() > 0){
					//VSK_VSL_SKD Table 에 Insert 시 Data 존재여부 체크.
					VskVslSkdVO chkVO = insertVoList.get(0);
					int chkCnt = dbDao.checkVvd(chkVO);
					if(chkCnt > 0){
						/*
						 * MASSAGE - 이미 등록된 Data가 존재합니다.
						 */
						throw new EventException(new ErrorHandler("VSK10017").getMessage());
					}else{
						dbDao.addVskVslSkd(insertVoList);
					}
				}
				if(updateVoList != null && updateVoList.size() > 0){
					dbDao.modifyVskVslSkd(updateVoList);
				}
				
				//=============== VSK_VSL_PORT_SKD ===============
				//입력받은 Turning Vvd에 대해서 TURN_PORT_IND_CD 값이 'D', 'V', 'F'인 Vessel Port Schedule 정보를 삭제한다.
				if(deleteVirtualPortVoList != null && deleteVirtualPortVoList.size() > 0){
					dbDao.removeVskVslPortSkdByVirtualPort(deleteVirtualPortVoList);
				}
				if(deletePortVoList != null && deletePortVoList.size() > 0){
					dbDao.removeVskVslPortSkd(deletePortVoList);
				}
				if(updatePortVoList != null && updatePortVoList.size() > 0){
					if(insertPortVoList != null && insertPortVoList.size() > 0){
						if(deletePortVoList != null && deletePortVoList.size() > 0){
							//동일한 Port로 Insert 와 Delete 를 동시에 하는 경우 문제 발생 소지 다분함.
							//어떻게 처리할지...
							dbDao.modifyVskVslPortSkd(updatePortVoList);
						}else{
							/*
							 * 입력한 List를 순차적으로 입력하면 무결성 제약조건에 걸림.
							 * Port의 clpt_ind seq가 PK로 잡혀 있음.
							 * 따라서 List를 역순으로 update해야함.
							 * 임창빈 수석 요청 - 2009.07.21
							 * -PK 를 update 하고 있으므로 이런 현상이 발생함.
							 */
							List<VslPortSkdVO> tmpPoList = new ArrayList<VslPortSkdVO>();
							int tmpCnt = updatePortVoList.size(); 
							for(int k=tmpCnt; k>0; k--){
								VslPortSkdVO tmpVO = updatePortVoList.get(k-1);
								tmpPoList.add(tmpVO);
							}
							
							dbDao.modifyVskVslPortSkd(tmpPoList);
						}
					}else{
						dbDao.modifyVskVslPortSkd(updatePortVoList);
					}
				}
				
				if(updatePortDataList != null && updatePortDataList.size() > 0){
					dbDao.modifyVskVslPortSkdDataOnly(updatePortDataList);
				}
				
				if(insertPortVoList != null && insertPortVoList.size() > 0){
					dbDao.addVskVslPortSkd(insertPortVoList);
				}
				if(insertVirtualPortVoList != null && insertVirtualPortVoList.size() > 0){
					dbDao.addVskVslPortSkd(insertVirtualPortVoList);
				}
				if(updateNextPortVoList != null && updateNextPortVoList.size() > 0){
					dbDao.modifyVskVslPortSkdByNextPort(updateNextPortVoList);
				}
				
				//=============== VSK_VSL_SKD [DELETE] ===============
				if(deleteVoList != null && deleteVoList.size() > 0){
					//해당 Port 정보가 모두 삭제되어 조회된 건이 없으면 VSK_VSL_SKD 의 정보도 삭제한다.
					/*
					 * VVD 삭제 시 Booking 과 상관없이 모든 기록을 Hitory 남긴다.
					 */
//					for(VskVslSkdVO vskVslSkdVO : deleteVoList){
//
//						VskVslSkdHisVO vskVslSkdDelHisVO = new VskVslSkdHisVO();
//						vskVslSkdDelHisVO.setBfrVslCd(vskVslSkdVO.getVslCd());
//						vskVslSkdDelHisVO.setBfrSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
//						vskVslSkdDelHisVO.setBfrSkdDirCd(vskVslSkdVO.getSkdDirCd());
//						vskVslSkdDelHisVO.setBfrVslSlanCd(vskVslSkdVO.getVslSlanCd());
//						vskVslSkdDelHisVO.setCreUsrId(vskVslSkdVO.getCreUsrId());
//						vskVslSkdDelHisVO.setUpdUsrId(vskVslSkdVO.getUpdUsrId());
//						
//						addVskVslSkdDelHis(vskVslSkdDelHisVO);
//					}
					
					dbDao.removeVskVslSkd(deleteVoList);
				}
				
//				//===================== EDI 전송을 위한 자료 생성 ========================
//				List<VvdVO> ediVvdVOs = new ArrayList<VvdVO>();
//	
//				// 특정 VVD 전체가 추가된 경우
//				ediVvdVOs = setTransObjectByVvd(ediVvdVOs, insertVoList, "I");
//				
//				// Add Port한 경우
//				if(insertPortVoList != null && insertPortVoList.size() > 0){
//					for(VslPortSkdVO vslPortSkdVO : insertPortVoList){
//						VvdVO vvdVO = new VvdVO();
//						vvdVO.setIbflag("I");
//						vvdVO.setVslCd(vslPortSkdVO.getVslCd());
//						vvdVO.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
//						vvdVO.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
//						vvdVO.setVslSlanCd(vslPortSkdVO.getSlanCd());
//						
//						if(!isCheckObjectByVvd(ediVvdVOs, vvdVO)){
//							ediVvdVOs.add(vvdVO);
//						}
//					}
//				}
//				
//				// CHM-201006129-01
//				// Virtual Port로 대상 Port(KR)가 추가되는 경우에도 EDI 전송이 되도록 수정
//				for(VslPortSkdVO virVslPortSkdVO : insertVirtualPortVoList){
//					
////					boolean targetVVD = false;
////					
////					// -- 대상항차만 적용
////					for(VskVslSkdVO vskVslSkdVO : masterVoList){
////						if( (vskVslSkdVO.getVslCd().equals(virVslPortSkdVO.getVslCd())) &&
////								(vskVslSkdVO.getSkdVoyNo().equals(virVslPortSkdVO.getSkdVoyNo())) &&
////								(vskVslSkdVO.getSkdDirCd().equals(virVslPortSkdVO.getSkdDirCd()))
////								){
////							targetVVD = true;
////							break;
////						}
////					}
////					
////					if(!targetVVD){
////						continue;
////					}
////					// -- 대상항차만 적용
//					
//					// 기존 포트에 없던것만 추가
//					// 추후 변경된 스케줄도 EDI 포함하는 경우 아래 체크구문을 수정함
//					boolean newVirPort = true;
//					for(VskVslPortSkdVO vskVslPortSkdVO : totalOrgPortList){
//						if(	(virVslPortSkdVO.getVslCd().equals(vskVslPortSkdVO.getVslCd())) &&
//								(virVslPortSkdVO.getSkdVoyNo().equals(vskVslPortSkdVO.getSkdVoyNo())) &&
//								(virVslPortSkdVO.getSkdDirCd().equals(vskVslPortSkdVO.getSkdDirCd())) &&
//								(virVslPortSkdVO.getVpsPortCd().equals(vskVslPortSkdVO.getVpsPortCd())) &&
//								(virVslPortSkdVO.getClptIndSeq().equals(vskVslPortSkdVO.getClptIndSeq()))){
////							!(virVslPortSkdVO.getVpsEtaDt().equals(vskVslPortSkdVO.getVpsEtaDt()))
////							!(virVslPortSkdVO.getVpsEtbDt().equals(vskVslPortSkdVO.getVpsEtbDt()))
////							!(virVslPortSkdVO.getVpsEtdDt().equals(vskVslPortSkdVO.getVpsEtdDt()))
//							newVirPort = false;
//							break;
//						}
//					}
//					
//					if(newVirPort){
//						VvdVO vvdVO = new VvdVO();
//						vvdVO.setIbflag("I");
//						vvdVO.setVslCd(virVslPortSkdVO.getVslCd());
//						vvdVO.setSkdVoyNo(virVslPortSkdVO.getSkdVoyNo());
//						vvdVO.setSkdDirCd(virVslPortSkdVO.getSkdDirCd());
//						vvdVO.setVslSlanCd(virVslPortSkdVO.getSlanCd());
//						
//						if(!isCheckObjectByVvd(ediVvdVOs, vvdVO)){
//							ediVvdVOs.add(vvdVO);
//						}
//					}
//				}
//				
//				for(VvdVO vvdVO : ediVvdVOs){
////					vvdVO.setCreUsrId(account.getUsr_id());
////					vvdVO.setUpdUsrId(account.getUsr_id());
//					if(VSKGeneralUtil.isNull(vvdVO.getCreUsrId())){
//						vvdVO.setCreUsrId(userId);	
//					}
//					if(VSKGeneralUtil.isNull(vvdVO.getUpdUsrId())){
//						vvdVO.setUpdUsrId(userId);
//					}
//				}
//				//===================== EDI 전송을 위한 자료 생성 끝 ========================
//
//				//			********************* 변경된 VVD ERP에 전송 *********************
//				//			변경이 일어난 모든 건에 대해 전송.
//							
//				List<VvdVO> erpVvdVOs = new ArrayList<VvdVO>();		//변경(I,U,D)된 모든 건
//				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, insertVoList, "I");
//				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, updateVoList, "U");
//				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, deleteVoList, "D");
//				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, deletePortVoList, "D");	// 삭제된 Port 발생 시 실행
//				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, deleteVirtualPortERPVoList, "D");	// Virtual Port 삭제건이 있으면 실행.
//				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, insertVirtualPortVoList, "U");	// Virtual Port 수정 시 실행.
//				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, updateNextPortVoList, "U");	// Next Port 수정 시 실행.
//				//SC 에서 마지막에 전송하는 것으로 수정(임창빈 - 2009.12.08)
//				vslSkdChgStsGRPVO.setErpVvdVOs(erpVvdVOs);
//				vslSkdChgStsGRPVO.setEdiVvdVOs(ediVvdVOs);
				
	//			Booking BDR LOG
//				if(erpVvdVOs != null && erpVvdVOs.size() > 0){
//					List<BkgVvdBdrLogVO> bkgVvdLogList = searchBkgBdrLog(erpVvdVOs);
//					vslSkdChgStsGRPVO.setBkgVvdBdrLogVOs(bkgVvdLogList);
//				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

//		return vslSkdChgStsGRPVO;
	}
	
	/**
	 * VVD Remark 정보를 관리합니다.<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstSkdByRmk(CstSkdByVvdVO cstSkdByVvdVO, SignOnUserAccount account) throws EventException {
		try {
			List<VskVslSkdVO> updateVoList = new ArrayList<VskVslSkdVO>();
			VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
			
			String userId = currentUserId(account, cstSkdByVvdVO.getUpdUsrId());
			
			vskVslSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
			vskVslSkdVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
			vskVslSkdVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
			vskVslSkdVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd());
			vskVslSkdVO.setPfSkdTpCd(cstSkdByVvdVO.getPfSvcTpCd());
			vskVslSkdVO.setSkdRmk(cstSkdByVvdVO.getSkdRmk());
			vskVslSkdVO.setUpdUsrId(userId);
			updateVoList.add(vskVslSkdVO);
			
			if(updateVoList != null && updateVoList.size() > 0){
				dbDao.modifyVskVslSkdByRmk(updateVoList);
			}
		} catch (DAOException ex) {
			/*
			 * MSG - 수정중 오류가 발생하였습니다.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
			
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
	 * @param VesselVO vesselVO
	 * @return int
	 * @exception EventException
	 */
	public int checkVslCntr(VesselVO vesselVO) throws EventException {
		try {
			return dbDao.checkVslCntr(vesselVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Long Range SKD 방식으로 Vessel Port SKD을 조회합니다.
	 * 
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return LongRangeSkdInqGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdInqGRPVO searchPortSkdOnLongRange(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException {
		
		LongRangeSkdInqGRPVO longRangeSkdInqGRPVO = null;
		Map<String, List<PfSkdDetailVO>> pfSkdDetailsByGroup = new HashMap<String, List<PfSkdDetailVO>>();
		
		try{
//			1. 위에 쿼리 실행. PORT SKD 데이터 조회
//			2. 조회된 PORT SKD에서 P/F TYPE 목록 획득
//			3. P/F TYPE 정보 조회
//			4. P/F 정보 /  PORT SKD 결합 (무조건 P/F 첫번째 포트 기준 정렬)
//			5. 정렬된 리스트 -> P/F 타입에 따라 분리
			
			List<PortSkdOnLongRangeVO> subVVDList = null;
			
			// VVD 리스트를 가지는 리스트
			// key : VVD
			// value : 해당 VVD의 Port Schedule 리스트
			Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD = new HashMap<String, List<PortSkdOnLongRangeVO>>();
			
//			// VVV 별 P/F 첫번째 Port의 ETB 목록
//			// key : P/F상 첫번째 Port의 ETB + VVD (VVD를 추가한 이유는, ETB가 같을 경우 키값 중복의 우려가 있기 때문)
//			// value : VVD
//			SortedMap<String, String> firstEtbByVVD = new TreeMap<String, String>();
			
			// VVV 별 P/F 첫번째 Port의 ETB 목록
			// key : VVD
			// value : P/F상 첫번째 Port의 ETB + VVD (VVD를 추가한 이유는, ETB가 같을 경우 중복의 우려가 있기 때문)
			Map<String, String> firstEtbByVVD = new HashMap<String, String>();
			
			// 1. 위에 쿼리 실행. PORT SKD 데이터 조회
			List<PortSkdOnLongRangeVO> portSkdOnLongRangeVOs = searchPortSkd(portSkdOnLongRangeVO);
			
			if(portSkdOnLongRangeVOs==null || portSkdOnLongRangeVOs.size()==0){
				throw new EventException(new ErrorHandler("VSK10018", new String[]{"Schedule"}).getMessage());
			}else{
				longRangeSkdInqGRPVO = new LongRangeSkdInqGRPVO();
			}
			
			List<PfSkdDetailVO> pfTypes = new ArrayList<PfSkdDetailVO>();
			Map<String, String> portNmMap = new HashMap<String, String>(); 
			Map<String, String> vslEngNmMap = new HashMap<String, String>();
			
			
			for(PortSkdOnLongRangeVO vo1 : portSkdOnLongRangeVOs){

				// 2.1 조회된 PORT SKD에서 P/F TYPE 목록 획득
				// Feeder Port Skd인 경우, P/F TYPE이 의미가 없으므로 모든 Feeder Port Skd 정보가 동일한 값을 갖도록 조정해준다.
				if("O".equals(vo1.getVslSvcTpCd())){ // Trunk인 경우
					vo1.setPfSkdTpCd("FEEDER");
				}
				
				PfSkdDetailVO pfSkdDetailVO = new PfSkdDetailVO();
				pfSkdDetailVO.setVslSlanCd(vo1.getVslSlanCd());
				pfSkdDetailVO.setVslSvcTpCd(vo1.getVslSvcTpCd());
				pfSkdDetailVO.setPfSvcTpCd(vo1.getPfSkdTpCd());
				
				boolean sameExist = false;
				for(PfSkdDetailVO vo2 : pfTypes){
					if(vo2.isSameType(pfSkdDetailVO)){ // VSL_SLAN_CD, PF_SVC_TP_CD 비교
						sameExist = true;
						break;
					}
				}
				
				if(!sameExist){
					pfTypes.add(pfSkdDetailVO);
				}
				
				// 하나의 리스트로 되어있는 Port SKD를 VVD별 리스트로 나누어 보관(Map)한다.  
				//------------- [START] VVD 별로 서브리스트 구성
				String vvdKey = vo1.getVslCd() + vo1.getSkdVoyNo() + vo1.getSkdDirCd();
				if(portSkdByVVD.containsKey(vvdKey)){
					subVVDList = portSkdByVVD.get(vvdKey);
					subVVDList.add(vo1);
				}else{
					subVVDList = new ArrayList<PortSkdOnLongRangeVO>();
					subVVDList.add(vo1);
				}
				portSkdByVVD.put(vvdKey, subVVDList);
				//------------- [END] VVD 별로 서브리스트 구성
				
				// for문 반복 수행 하지 않기 위해 2.1과 동시 수행
				// 2.2 조회된 PORT SKD에서 Port Name 목록과 Vessel Eng Name 목록 획득
				if(!portNmMap.containsKey(vo1.getVpsPortCd())){
					portNmMap.put(vo1.getVpsPortCd(), vo1.getPortNm());
				}
				if(!vslEngNmMap.containsKey(vo1.getVslCd())){
					vslEngNmMap.put(vo1.getVslCd(), vo1.getVslEngNm());
				}
				
			}
			
			// 2.3  Port Name 목록과 Vessel Eng Name 목록을 Group VO에 설정
			longRangeSkdInqGRPVO.setPortNms(portNmMap);
			longRangeSkdInqGRPVO.setVslEngNms(vslEngNmMap);			
			
			// 3. P/F TYPE 정보 조회
			Map<String, List<PfSkdDetailVO>> pfSkdDetails = new HashMap<String, List<PfSkdDetailVO>>();
			for(PfSkdDetailVO vo : pfTypes){
				if(!"O".equals(vo.getVslSvcTpCd())){ // Trunk인 경우만 조회
					if("".equals(VSKGeneralUtil.getCheckNullToString(vo.getPfSvcTpCd()))){ // Trunk Lane인 경우, PF_SVC_TP_CD가 없으면 오류처리.
						throw new EventException(new ErrorHandler("VSK10068").getMessage());
					}
					List<PfSkdDetailVO> pfSkdDetailVOs = dbDao.searchPfSkdDetail(vo);
					
					// P/F 정보 백업
					pfSkdDetails.put(vo.getVslSlanCd() + vo.getPfSvcTpCd(), pfSkdDetailVOs);
					longRangeSkdInqGRPVO.setPfSkdDetails(pfSkdDetails);
				}
			}
			
			// 4. VVD를 정렬한다.
			// P/F 정보를 가지고 있는 VVD는 정렬 Map에 첫번째 PF_ETB_DT를 등록하고,
			// P/F 정보가 없는 VVD는 INIT_ETB_DT를 이용하여 첫번째 PF_ETB_DT를 계산하여 등록한다.
			for(Iterator<String> i = portSkdByVVD.keySet().iterator(); i.hasNext(); ){
				String vvdKey = i.next();
				
				List<PortSkdOnLongRangeVO> portSkds = portSkdByVVD.get(vvdKey);
				PortSkdOnLongRangeVO firstPortSkd = portSkds.get(0);
				
				if("O".equals(firstPortSkd.getVslSvcTpCd())){
					
					// Feeder Lane의 스케쥴인 경우 P/F가 아닌(없는 경우도 있으므로) 첫 Port 의 ETB를 정렬 Map에 등록한다. << 20100325
					// Feeder Lane의 스케쥴인 경우 강제로 할당한 P/F Type값("FEEDER")를 가지므로 첫 Port 의 ETB를 정렬 Map에 등록한다. << 20100328
					
					for(PortSkdOnLongRangeVO vo : portSkds){
						if(firstEtbByVVD.containsKey(vvdKey)){
							break;
						}
						firstEtbByVVD.put(vvdKey, VSKGeneralUtil.changeDateFormat(vo.getVpsEtbDt(), "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss"));
					}
					
				}else{

					List<PfSkdDetailVO> pfSkdDetailVOs = pfSkdDetails.get(firstPortSkd.getVslSlanCd() + firstPortSkd.getPfSkdTpCd());
					
					// for loop a1
					// P/F를 이용하여 해당 VVD의 첫번째 PF_ETB_DT를 구하고, 정렬 Map에 등록한다.
					for(PortSkdOnLongRangeVO vo : portSkds){
						
						// 해당 VVD가 정렬(ETB기준)이 된 상태(정렬 Map에 VVD등록)이면 for문을 마치고 다음 VVD의 정렬을 수행한다. 
						if(firstEtbByVVD.containsKey(vvdKey)){
							break;
						}
						
						// PF_ETB_DT가 정보가 없으면 pass
						// PF_ETB_DT 만 사용하는 이유는, PF_ETB_DT가 null이면 PF_ETD_DT도 항상 null이므로
						if(VSKGeneralUtil.getCheckNullToString(vo.getPfEtbDt()).length()==0){
							continue;
						}
						
						setFirstEtbByPF(vvdKey, vo, pfSkdDetailVOs, firstEtbByVVD);
					}
					
					// for loop a2
					// INIT_ETB_DT를 이용하여 해당 VVD의 첫번째 PF_ETB_DT를 구하고, 정렬 Map에 등록한다.
					for(PortSkdOnLongRangeVO vo : portSkds){
						
						// 해당 VVD가 정렬(ETB기준)이 된 상태(정렬 Map에 VVD등록)이면 for문을 마치고 다음 VVD의 정렬을 수행한다. 
						if(firstEtbByVVD.containsKey(vvdKey)){
							break;
						}
						
						// 위의 {for loop a1} 이 수행되고 난 후, 정렬 Map에 등록되지 않은 vvd는 두 종류가 있다.
						// 1. vvd를 구성하고 있는 Port Skd 정보(PortSkdOnLongRangeVO)에 PF_ETB_DT가 모두 없는 경우
						// 2. PF_ETB_DT 정보는 있으나 P/F 상의 Port 정보와 일치하는 항목이 없는 경우
						// 여기서는 INIT_ETB_DT를 이용하여 정렬 Map에 등록한다.
						setFirstEtbByInit(vvdKey, vo, pfSkdDetailVOs, firstEtbByVVD);
					
					}
					
					// for loop a3
					// for loop a1, a2를 수행하고 난 후에도 아직 정렬Map에 등록되지 못한 VVD가 있으면,
					// 해당 VVD 는 P/F와 일치하는 항목이 없는 경우 이므로
					// 항상 존재하는 INIT_ETB_DT 값을 정렬 Map에 등록한다.
					// 해당 INIT_ETB_DT는 P/F가 아닌 해당 VVD의 첫번째 Calling Port의 INIT_ETB_DT이다.
					for(PortSkdOnLongRangeVO vo : portSkds){
						
						if(firstEtbByVVD.containsKey(vvdKey)){
							break;
						}
						
						firstEtbByVVD.put(vvdKey, VSKGeneralUtil.changeDateFormat(vo.getInitEtbDt(), "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss"));
					}
					
				}
			}
			
			// 연결된 VVD는 Inquiry 화면에서 하나의 Row로 표시된다.
			linkTurningVVD(portSkdByVVD);
			linkSameVoyageVVD(portSkdByVVD);
			
			// 5. 정렬된 리스트 
			List<List<PortSkdOnLongRangeVO>> orderedPortSkdOnLongRangeVOs = sortPortSkd(portSkdByVVD, firstEtbByVVD);
			longRangeSkdInqGRPVO.setPortSkdVOs(orderedPortSkdOnLongRangeVOs);
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// Remark 정보 처리
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			LongRangeSkdInqVO remarkVO = null;
			List<LongRangeSkdInqVO> rmkList = new ArrayList<LongRangeSkdInqVO>();
			Map<String, String> rmkVVD = new HashMap<String, String>();
			
			for(List<PortSkdOnLongRangeVO> list : orderedPortSkdOnLongRangeVOs){
				PortSkdOnLongRangeVO first = list.get(0);
				PortSkdOnLongRangeVO last = list.get(list.size()-1);
				
				String vvd = first.getVslCd() + first.getSkdVoyNo() + first.getSkdDirCd();
				
				if(first.getVpsRmk()!=null && first.getVpsRmk().trim().length()!=0){
					if(!rmkVVD.containsKey(vvd)){
						remarkVO = new LongRangeSkdInqVO();
						remarkVO.setRemarkFlag(true);
						remarkVO.setVslCd(first.getVslCd());
						remarkVO.setSkdVoyNo(first.getSkdVoyNo()); 
						remarkVO.setSkdDirCd(first.getSkdDirCd());
						remarkVO.setVpsRmk(first.getVpsRmk());
						rmkList.add(remarkVO);
						rmkVVD.put(vvd, vvd);
					}
				}
				
				vvd = last.getVslCd() + last.getSkdVoyNo() + last.getSkdDirCd();
				
				if(last.getVpsRmk()!=null && last.getVpsRmk().trim().length()!=0){
					if(!rmkVVD.containsKey(vvd)){
						remarkVO = new LongRangeSkdInqVO();
						remarkVO.setRemarkFlag(true);
						remarkVO.setVslCd(last.getVslCd());
						remarkVO.setSkdVoyNo(last.getSkdVoyNo()); 
						remarkVO.setSkdDirCd(last.getSkdDirCd());
						remarkVO.setVpsRmk(last.getVpsRmk());
						rmkList.add(remarkVO);
						rmkVVD.put(vvd, vvd);
					}
				}
			}
			
			longRangeSkdInqGRPVO.setRemarks(rmkList);
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			// 항차스케쥴을 P/F 별로 grouping 한다.
			// 이전 또는 이후 항차와 동일한 P/F일 경우 같은 그룹으로 모으는 과정이다.
			// 항차스케쥴 ==> P/F에 대응되는 2 Direction VVD가 모여진 스케쥴. 즉, P/F SKD Detail에 대응되는 2개의 VVD의 합
			List<List<List<PortSkdOnLongRangeVO>>> groupByPf = new ArrayList<List<List<PortSkdOnLongRangeVO>>>();
			
			String beforePfSkdTpCd = null;
			String currentPfSkdTpCd = null;
			
			List<List<PortSkdOnLongRangeVO>> tmp = new ArrayList<List<PortSkdOnLongRangeVO>>();
			for(List<PortSkdOnLongRangeVO> portSkds : orderedPortSkdOnLongRangeVOs){
				
				currentPfSkdTpCd = portSkds.get(0).getPfSkdTpCd();

				if(beforePfSkdTpCd==null){
					tmp.add(portSkds);
				}else{
					if(beforePfSkdTpCd.equals(currentPfSkdTpCd)){
						tmp.add(portSkds);
					}else{
						groupByPf.add(tmp);
						tmp = new ArrayList<List<PortSkdOnLongRangeVO>>();
						tmp.add(portSkds);
					}
				}	
				
				beforePfSkdTpCd = currentPfSkdTpCd;
			}
			groupByPf.add(tmp);
			
			// 그리드가 10개 이상이 표현될 수 있는 경우
			// Feeder 레인인 경우
			// UI에서 원할한 성능을 발현할 수 없으므로 하나의 그리드로 통합하여 보여준다.
			if(groupByPf.size()>10){
				
				List<List<PortSkdOnLongRangeVO>> mergedGrid = new ArrayList<List<PortSkdOnLongRangeVO>>();
				
				for(int i=0; i<groupByPf.size(); i++){
					adjustAllSkd(groupByPf.get(i), mergedGrid);
				}

				// 하나짜리 그리드 완성
				groupByPf = new ArrayList<List<List<PortSkdOnLongRangeVO>>>();
				groupByPf.add(mergedGrid);
				
				// PF 도 하나로 통합
				List<PfSkdDetailVO> pfSkdDetailVOs = new ArrayList<PfSkdDetailVO>();
				for(PortSkdOnLongRangeVO portSkdVO : mergedGrid.get(0)){
					PfSkdDetailVO pfSkdDetailVO = new PfSkdDetailVO();
					pfSkdDetailVO.setVslSlanCd(portSkdVO.getVslSlanCd());
					pfSkdDetailVO.setSkdDirCd(portSkdVO.getSkdDirCd());
					pfSkdDetailVO.setPortCd(portSkdVO.getVpsPortCd());
					pfSkdDetailVO.setEtbDyCd("*");
					pfSkdDetailVO.setEtbTmHrmnt("*");
					pfSkdDetailVO.setEtdDyCd("*");
					pfSkdDetailVO.setEtdTmHrmnt("*");
					pfSkdDetailVO.setClptSeq(portSkdVO.getClptIndSeq());
					pfSkdDetailVO.setYdCd(portSkdVO.getYdCd());
					pfSkdDetailVO.setCallYdIndSeq("");
					pfSkdDetailVOs.add(pfSkdDetailVO);
				}
				
				// empty가 아닌 첫번째 포트의 PF 정보로 등록 <-- 그리드가 여러개 나오는 로직을 동일하게 사용하기 위한 작업
				for(PortSkdOnLongRangeVO portSkdVO : mergedGrid.get(0)){
					if(!portSkdVO.isEmptySkd()){
						pfSkdDetailsByGroup.put(portSkdVO.getVslSlanCd() + portSkdVO.getPfSkdTpCd() + portSkdVO.getVslCd() + portSkdVO.getSkdVoyNo(), pfSkdDetailVOs);		
					}
				}
				
			}else{
				// 화면에 표현하기 위한 Header와 SKD 조절 시작
				for(int i=0; i<groupByPf.size(); i++){
					List<List<PortSkdOnLongRangeVO>> samePfGroup = groupByPf.get(i);
					
					PortSkdOnLongRangeVO vo = samePfGroup.get(0).get(0);
					if("FEEDER".equals(vo.getPfSkdTpCd())){
						List<List<PortSkdOnLongRangeVO>> mergedGrid = new ArrayList<List<PortSkdOnLongRangeVO>>();
						adjustAllSkd(samePfGroup, mergedGrid);
						groupByPf.set(i, mergedGrid);
						
						// 하나짜리 그리드 완성
						groupByPf = new ArrayList<List<List<PortSkdOnLongRangeVO>>>();
						groupByPf.add(mergedGrid);
						
						// PF 도 하나로 통합
						List<PfSkdDetailVO> pfSkdDetailVOs = new ArrayList<PfSkdDetailVO>();
						for(PortSkdOnLongRangeVO portSkdVO : mergedGrid.get(0)){
							PfSkdDetailVO pfSkdDetailVO = new PfSkdDetailVO();
							pfSkdDetailVO.setVslSlanCd(portSkdVO.getVslSlanCd());
							pfSkdDetailVO.setSkdDirCd(portSkdVO.getSkdDirCd());
							pfSkdDetailVO.setPortCd(portSkdVO.getVpsPortCd());
							pfSkdDetailVO.setEtbDyCd("*");
							pfSkdDetailVO.setEtbTmHrmnt("*");
							pfSkdDetailVO.setEtdDyCd("*");
							pfSkdDetailVO.setEtdTmHrmnt("*");
							pfSkdDetailVO.setClptSeq(portSkdVO.getClptIndSeq());
							pfSkdDetailVO.setYdCd(portSkdVO.getYdCd());
							pfSkdDetailVO.setCallYdIndSeq("");
							pfSkdDetailVOs.add(pfSkdDetailVO);
						}
						
						// empty가 아닌 첫번째 포트의 PF 정보로 등록 <-- 그리드가 여러개 나오는 로직을 동일하게 사용하기 위한 작업
						for(PortSkdOnLongRangeVO portSkdVO : mergedGrid.get(0)){
							if(!portSkdVO.isEmptySkd()){
								pfSkdDetailsByGroup.put(portSkdVO.getVslSlanCd() + portSkdVO.getPfSkdTpCd() + portSkdVO.getVslCd() + portSkdVO.getSkdVoyNo(), pfSkdDetailVOs);
								break;
							}
						}
						
					}else{
						// 해당 P/F를 기준으로 스케쥴을 정렬한다.
						groupByPf.set(i, adjustSkd(pfSkdDetails, samePfGroup, pfSkdDetailsByGroup));
					}
				}
			}
			
			longRangeSkdInqGRPVO.setPortSkdVOsByPf(groupByPf);
			longRangeSkdInqGRPVO.setPfSkdDetailsByGroup(pfSkdDetailsByGroup);
			
			return longRangeSkdInqGRPVO;
		}catch(DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		}
	}
	
	
//	/**
//	 * 해당 VVD 스케쥴을 수동 Close 처리합니다.
//	 * 
//	 * @param ActivationVvdVO[] activationVvdVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageVslSkdListByLane(ActivationVvdVO[] activationVvdVOs, SignOnUserAccount account) throws EventException {
//		try{
//			for(ActivationVvdVO vo : activationVvdVOs){
//				vo.setUpdUsrId(account.getUsr_id());
//			}
//			dbDao.modifyVslSkdListByLane(activationVvdVOs);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
//		}
//	}
	
//	/**
//	 * 해당 VVD 스케쥴을 Activate 처리합니다.
//	 *  
//	 * @param ActivationVvdVO activationVvdVO
//	 * @param SignOnUserAccount account 
//	 * @exception EventException
//	 */
//	public void manageSkdActivate(ActivationVvdVO activationVvdVO, SignOnUserAccount account) throws EventException {
//		try{
//			activationVvdVO.setUpdUsrId(account.getUsr_id());
//			dbDao.manageSkdActivate(activationVvdVO);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
//		}
//	}
	
//	/**
//	 * VVD 정보의 P/F를 설정합니다.<br>
//	 * 
//	 * @param List<ActivationVvdVO> activationVvdVOs
//	 * @exception EventException
//	 * @author Hyuk Ryu
//	 * @date 2009. 11. 11.
//	 */
//	public void manageVvdPf(List<ActivationVvdVO> activationVvdVOs) throws EventException {
//		try{
//			dbDao.manageVvdPf(activationVvdVOs);
//		}catch(DAOException e){
//			log.error("err " + e.toString(), e);
//			throw new EventException(new ErrorHandler("VSK10038").getMessage(), e);
//		}catch(Exception e){
//			log.error("err " + e.toString(), e);
//			throw new EventException(new ErrorHandler("VSK10038").getMessage(), e);
//		}
//	}
	
	/**
	 * VOP_VSK_0018 : crr_cd 입력시 체크
	 * @param String crrCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCrrCd(String crrCd) throws EventException {
		try{
			return dbDao.searchCrrCd(crrCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}	
	}
	
	
	/**
	 * 해당 스케쥴을 삭제합니다. 
	 * 
	 * @param ActivationVvdVO[] activationVvdVOs
	 * @exception EventException
	 */
	private void removeCstSkdByVvd(ActivationVvdVO[] activationVvdVOs) throws EventException {
		
		if(activationVvdVOs==null || activationVvdVOs.length==0){
			return;
		}
		
		try{
			
			for(int i=0; i<activationVvdVOs.length; i++){
				
				// Booking 이 연결되어 있는 스케줄은 SC에서 null로 변경하여 구분할 수 있도록 하였다.
				// 따라서 null 인 경우는 처리하지 않는다.
				if(activationVvdVOs[i]==null) continue;
				
				VvdVO paramVO = new VvdVO();
				paramVO.setVslCd(activationVvdVOs[i].getVslCd());
				paramVO.setSkdVoyNo(activationVvdVOs[i].getSkdVoyNo());
				paramVO.setSkdDirCd(activationVvdVOs[i].getSkdDirCd());
				
//				//책임테이블 위배. Actual 쪽으로 이관.. 2009.10.31
//				//VSK_ACT_PORT_SKD 테이블 삭제
//				dbDao.removeVskActPortSkd(paramVO);
				
				//자신에 VVD와 연결되는 VSL_PORT의 Pre-VVD와 Next-VVD 정보를 찾아 온다.
				List<VvdVO> rePreNextVoList = new ArrayList<VvdVO>();
				//전차수 로우 하나와 후차수 로우 하나만 리턴된다
				rePreNextVoList = dbDao.searchConnectVvd(paramVO);
				
				//k == 0이면 전차수 삭제 및 이력 추가 ,k ==1 이면 후차수 update
				for(int k=0; k<rePreNextVoList.size(); k++){
					String tempTurnCd = rePreNextVoList.get(k).getTurnPortIndCd();
					
					if(tempTurnCd.equals("N") || tempTurnCd.equals("Y")){
						dbDao.removeVskVslPortSkdByPreVvd(rePreNextVoList.get(k));
					}else if(tempTurnCd.equals("D") || tempTurnCd.equals("V") || tempTurnCd.equals("F")){
						dbDao.modifyVskVslPortSkdNextTurnPort (rePreNextVoList.get(k));
					}
				}
				
				//자신에 VVD와 연결되는 SWAP_CST_PORT의 Pre-VVD와 Next-VVD 정보를 찾아 온다.
//				List<VvdVO> rePreNextCstVoList = new ArrayList<VvdVO>();
				//전차수 로우 하나와 후차수 로우 하나만 리턴된다
//				rePreNextCstVoList = dbDao.searchConnectVvdSim(paramVO);
				
//				for(int l = 0; l < rePreNextCstVoList.size(); l++){
//					String tempCstTurnCd = rePreNextCstVoList.get(l).getTurnPortIndCd();
//					if(tempCstTurnCd.equals("N") || tempCstTurnCd.equals("Y")){
////						dbDao.removeVskSwapCstPortByPreVvd(rePreNextCstVoList.get(l));
//						
////						===================================================================================
//						//VSK_SWAP_CST_PORT 삭제하기 위하여 추가 및 수정 2009.06.30 정진우
//						VskSwapCstPortVO vskSwapCstPortVO = new VskSwapCstPortVO();
//						vskSwapCstPortVO.setVslCd(rePreNextCstVoList.get(l).getVslCd());
//						vskSwapCstPortVO.setSkdVoyNo(rePreNextCstVoList.get(l).getSkdVoyNo());
//						vskSwapCstPortVO.setSkdDirCd(rePreNextCstVoList.get(l).getSkdDirCd());
//						dbDao.removeVskSwapCstPort(vskSwapCstPortVO);
////						===================================================================================
//					}else if(tempCstTurnCd.equals("D") || tempCstTurnCd.equals("V") || tempCstTurnCd.equals("F")){
//						dbDao.modifyVskSwapCstPort (rePreNextCstVoList.get(l));
//					}
//				}
				
				//SIM_DT,SIM_NO을 담을  VO 
//				List<VskSwapCstSimVO> reCstSimVoList = new ArrayList<VskSwapCstSimVO>();
				//VSK_SWAP_CST_SIM TABLE을 지우기 위해 
				//SIM_DT,SIM_NO을 가져온다
//				reCstSimVoList = dbDao.searchSimNoVskSwapCstVvd(paramVO);
				
//				===================================================================================
				//VSK_SWAP_CST_VVD 삭제하기 위하여 추가 및 수정 2009.06.30 정진우
//				VskSwapCstVvdVO vskSwapCstVvdVO = new VskSwapCstVvdVO();
//				vskSwapCstVvdVO.setVslCd(paramVO.getVslCd());
//				vskSwapCstVvdVO.setSkdVoyNo(paramVO.getSkdVoyNo());
//				vskSwapCstVvdVO.setSkdDirCd(paramVO.getSkdDirCd());
//				dbDao.removeVskSwapCstVvd(vskSwapCstVvdVO);
//				===================================================================================
//				dbDao.removeVskSwapCstRmk (paramVO);
				
//				int cnt = 0;
//				for(int m=0; m < reCstSimVoList.size(); m++){
//					cnt = dbDao.searchVskSwapCstVvdCount(reCstSimVoList.get(i));
//					if(cnt == 0){
//						dbDao.removeVskSwapCstSim(reCstSimVoList.get(i));
//					}
//				}
				
				dbDao.removeVskVslPortSkdByVvd(paramVO);
				dbDao.removeVskVslSkdByVvd(paramVO);
				
//				VskVslSkdHisVO vskVslSkdDelHisVO = new VskVslSkdHisVO();
//				vskVslSkdDelHisVO.setBfrVslSlanCd(activationVvdVOs[i].getVslSlanCd());
//				vskVslSkdDelHisVO.setBfrVslCd(activationVvdVOs[i].getVslCd());
//				vskVslSkdDelHisVO.setBfrSkdVoyNo(activationVvdVOs[i].getSkdVoyNo());
//				vskVslSkdDelHisVO.setBfrSkdDirCd(activationVvdVOs[i].getSkdDirCd());
//				vskVslSkdDelHisVO.setCreUsrId(activationVvdVOs[i].getCreUsrId());
//				vskVslSkdDelHisVO.setUpdUsrId(activationVvdVOs[i].getUpdUsrId());
				
//				addVskVslSkdDelHis(vskVslSkdDelHisVO);

			}
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
//		} catch (EventException ex) {
//			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		}
		
	}
	
//	/**
//	 * 해당 스케쥴을 삭제하고 history를 남깁니다. 
//	 * 
//	 * @param ActivationVvdVO[] activationVvdVOs
//	 * @param VskVslSkdHisVO vskVslSkdHisVO
//	 * @exception EventException
//	 */
//	private void removeCstSkdByVvd(ActivationVvdVO[] activationVvdVOs, VskVslSkdHisVO vskVslSkdHisVO) throws EventException {
//		
//		if(activationVvdVOs==null || activationVvdVOs.length==0){
//			return;
//		}
//		
//		try{
//			
//			for(int i=0; i<activationVvdVOs.length; i++){
//				
//				// Booking 이 연결되어 있는 스케줄은 SC에서 null로 변경하여 구분할 수 있도록 하였다.
//				// 따라서 null 인 경우는 처리하지 않는다.
//				if(activationVvdVOs[i]==null) continue;
//
//				vskVslSkdHisVO.setBfrVslSlanCd(activationVvdVOs[i].getVslSlanCd());
//				vskVslSkdHisVO.setBfrVslCd(activationVvdVOs[i].getVslCd());
//				vskVslSkdHisVO.setBfrSkdVoyNo(activationVvdVOs[i].getSkdVoyNo());
//				vskVslSkdHisVO.setBfrSkdDirCd(activationVvdVOs[i].getSkdDirCd());
//				vskVslSkdHisVO.setVskdTpCd("M");
//				vskVslSkdHisVO.setVskdCngTpCd("V");
//				vskVslSkdHisVO.setCreUsrId(activationVvdVOs[i].getCreUsrId());
//				vskVslSkdHisVO.setUpdUsrId(activationVvdVOs[i].getCreUsrId());
//				
//				VvdVO paramVO = new VvdVO();
//				paramVO.setVslCd(activationVvdVOs[i].getVslCd());
//				paramVO.setSkdVoyNo(activationVvdVOs[i].getSkdVoyNo());
//				paramVO.setSkdDirCd(activationVvdVOs[i].getSkdDirCd());
//				
//				//자신에 VVD와 연결되는 VSL_PORT의 Pre-VVD와 Next-VVD 정보를 찾아 온다.
//				List<VvdVO> rePreNextVoList = new ArrayList<VvdVO>();
//				//전차수 로우 하나와 후차수 로우 하나만 리턴된다
//				rePreNextVoList = dbDao.searchConnectVvd(paramVO);
//				
//				//k == 0이면 전차수 삭제 및 이력 추가 ,k ==1 이면 후차수 update
//				for(int k=0; k<rePreNextVoList.size(); k++){
//					String tempTurnCd = rePreNextVoList.get(k).getTurnPortIndCd();
//					
//					if(tempTurnCd.equals("N") || tempTurnCd.equals("Y")){
//						
//						// Virtual Port에 Booking이 연결되어 있는 경우 : "VIR"
//						// 현재 VVD, Virtual Port 모두에 Booking이 연결되어 있는 경우 : "ALL":
//						// history를 남긴다.
//						if("VIR".equals(activationVvdVOs[i].getHisflag()) || "ALL".equals(activationVvdVOs[i].getHisflag())){
//							List<VskVslSkdHisVO> podYardList = new ArrayList<VskVslSkdHisVO>();
//							podYardList = dbDao.checkPreVvdBkgPodYard(rePreNextVoList.get(k));
//							if(podYardList.size() != 0){
//								for(int j=0; j < podYardList.size(); j++){
//									VskVslSkdHisVO hisVO = podYardList.get(j);
//									hisVO.setVskdTpCd("M");
//									hisVO.setVskdCngTpCd("D");
//									hisVO.setCreUsrId(activationVvdVOs[i].getCreUsrId());
//									hisVO.setUpdUsrId(activationVvdVOs[i].getCreUsrId());
//									hisVO.setAftVslSlanCd(vskVslSkdHisVO.getAftVslSlanCd());
//									hisVO.setAftVslCd(vskVslSkdHisVO.getAftVslCd());
//									hisVO.setAftSkdVoyNo(vskVslSkdHisVO.getAftSkdVoyNo());
//									hisVO.setAftSkdDirCd(vskVslSkdHisVO.getAftSkdDirCd());
//									hisVO.setAftVpsPortCd(vskVslSkdHisVO.getAftVpsPortCd());
//									hisVO.setAftClptIndSeq(vskVslSkdHisVO.getAftClptIndSeq());
//									
//									String tempRemark = vskVslSkdHisVO.getDiffRmk() 
//																+ "/Deleted Virtual Port by Turning Port["
//																+ activationVvdVOs[i].getVslCd()
//																+ activationVvdVOs[i].getSkdVoyNo()
//																+ activationVvdVOs[i].getSkdDirCd()+ "]";
//									hisVO.setDiffRmk(tempRemark);
//									dbDao.addVslSkdHis(hisVO);
//								}
//							}
//						}
//						
//						dbDao.removeVskVslPortSkdByPreVvd(rePreNextVoList.get(k));
//					}else if(tempTurnCd.equals("D") || tempTurnCd.equals("V") || tempTurnCd.equals("F")){
//						dbDao.modifyVskVslPortSkdNextTurnPort (rePreNextVoList.get(k));
//					}	
//				}
//				
//				//현재 VVD에 대한 Booking이 연결되어 있는 경우 history를 남긴다.
//				if("VVD".equals(activationVvdVOs[i].getHisflag()) || "ALL".equals(activationVvdVOs[i].getHisflag())){
//					dbDao.addVslSkdHis(vskVslSkdHisVO);
//				}
//				
//				//자신에 VVD와 연결되는 SWAP_CST_PORT의 Pre-VVD와 Next-VVD 정보를 찾아 온다.
//				List<VvdVO> rePreNextCstVoList = new ArrayList<VvdVO>();
//				//전차수 로우 하나와 후차수 로우 하나만 리턴된다
//				rePreNextCstVoList = dbDao.searchConnectVvdSim(paramVO);
//				
//				for(int l = 0; l < rePreNextCstVoList.size(); l++){
//					String tempCstTurnCd = rePreNextCstVoList.get(l).getTurnPortIndCd();
//					if(tempCstTurnCd.equals("N") || tempCstTurnCd.equals("Y")){
//						dbDao.removeVskSwapCstPortByPreVvd(rePreNextCstVoList.get(l));
//						
////						===================================================================================
//						//VSK_SWAP_CST_PORT 삭제하기 위하여 추가 및 수정 2009.06.30 정진우
//						VskSwapCstPortVO vskSwapCstPortVO = new VskSwapCstPortVO();
//						vskSwapCstPortVO.setVslCd(rePreNextCstVoList.get(l).getVslCd());
//						vskSwapCstPortVO.setSkdVoyNo(rePreNextCstVoList.get(l).getSkdVoyNo());
//						vskSwapCstPortVO.setSkdDirCd(rePreNextCstVoList.get(l).getSkdDirCd());
//						dbDao.removeVskSwapCstPort(vskSwapCstPortVO);
////						===================================================================================
//					}else if(tempCstTurnCd.equals("D") || tempCstTurnCd.equals("V") || tempCstTurnCd.equals("F")){
//						dbDao.modifyVskSwapCstPort (rePreNextCstVoList.get(l));
//					}
//				}
//				
//				//SIM_DT,SIM_NO을 담을  VO 
//				List<VskSwapCstSimVO> reCstSimVoList = new ArrayList<VskSwapCstSimVO>();
//				//VSK_SWAP_CST_SIM TABLE을 지우기 위해 
//				//SIM_DT,SIM_NO을 가져온다
//				reCstSimVoList = dbDao.searchSimNoVskSwapCstVvd(paramVO);
//				
////				===================================================================================
//				//VSK_SWAP_CST_VVD 삭제하기 위하여 추가 및 수정 2009.06.30 정진우
//				VskSwapCstVvdVO vskSwapCstVvdVO = new VskSwapCstVvdVO();
//				vskSwapCstVvdVO.setVslCd(paramVO.getVslCd());
//				vskSwapCstVvdVO.setSkdVoyNo(paramVO.getSkdVoyNo());
//				vskSwapCstVvdVO.setSkdDirCd(paramVO.getSkdDirCd());
//				dbDao.removeVskSwapCstVvd(vskSwapCstVvdVO);
////				===================================================================================
//				dbDao.removeVskSwapCstRmk (paramVO);
//				
//				int cnt = 0;
//				for(int m=0; m < reCstSimVoList.size(); m++){
//					cnt = dbDao.searchVskSwapCstVvdCount(reCstSimVoList.get(i));
//					if(cnt == 0){
//						dbDao.removeVskSwapCstSim(reCstSimVoList.get(i));
//					}
//				}
//				
//				dbDao.removeVskVslPortSkdByVvd(paramVO);
//				dbDao.removeVskVslSkdByVvd(paramVO);
//				
//				VskVslSkdHisVO vskVslSkdDelHisVO = new VskVslSkdHisVO();
//				vskVslSkdDelHisVO.setBfrVslSlanCd(vskVslSkdHisVO.getBfrVslSlanCd());
//				vskVslSkdDelHisVO.setBfrVslCd(vskVslSkdHisVO.getBfrVslCd());
//				vskVslSkdDelHisVO.setBfrSkdVoyNo(vskVslSkdHisVO.getBfrSkdVoyNo());
//				vskVslSkdDelHisVO.setBfrSkdDirCd(vskVslSkdHisVO.getBfrSkdDirCd());
//				vskVslSkdDelHisVO.setCreUsrId(vskVslSkdHisVO.getCreUsrId());
//				vskVslSkdDelHisVO.setUpdUsrId(vskVslSkdHisVO.getUpdUsrId());
//				
//				addVskVslSkdDelHis(vskVslSkdDelHisVO);
//				
//			}
//			
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
//		} catch (EventException ex){
//			throw ex;
//		} catch (Exception de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
//		}
//		
//	}
	
	/**
	 * LRS 시뮬레이션에 사용되는 P/F에 대해 검증합니다.<br>
	 * 
	 * @param PfSkdVO[] pfSkdVOs
	 * @exception EventException
	 * @author Hyuk Ryu
	 * @date 2009. 11. 3.
	 */
	private void validatePfSkd(PfSkdVO[] pfSkdVOs) throws EventException {
		{ // etbDyNo, etdDyNo 가 계속 증가되는지 체크한다.
			int dyNo = Integer.parseInt(pfSkdVOs[0].getEtbDyNo());
			for(PfSkdVO vo : pfSkdVOs){
				if(dyNo <= Integer.parseInt(vo.getEtbDyNo())){
					dyNo = Integer.parseInt(vo.getEtbDyNo());
				}else{
					// VSK10050 : P/F SKD 정보에 검증이 필요합니다.
					throw new EventException(new ErrorHandler("VSK10050").getMessage());
				}
				if(dyNo <= Integer.parseInt(vo.getEtdDyNo())){
					dyNo = Integer.parseInt(vo.getEtdDyNo());
				}else{
					// VSK10050 : P/F SKD 정보에 검증이 필요합니다.
					throw new EventException(new ErrorHandler("VSK10050").getMessage());
				}
			}
		}
	}

	/**
	 * UI 시뮬레이션된 정보를 load 합니다.
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @param int addCallPos
	 * @param int addVvdPos
	 * @param LongRangeSkdVO addPort
	 * @param boolean addCancel
	 * @return List<LongRangeSkdVO>
	 * @exception EventException
	 */
	private List<LongRangeSkdVO> loadSimDataList(
			LongRangeSkdGRPVO longRangeSkdGRPVO,
			int addCallPos,
			int addVvdPos,
			LongRangeSkdVO addPort,
			boolean addCancel) throws EventException {
		
		try {
			
			PfSkdVO[] pfSkdVOs = longRangeSkdGRPVO.getPfSkdVOs();
			String headTitle1 = longRangeSkdGRPVO.getHeadTitle1();
			String headTitle2 = longRangeSkdGRPVO.getHeadTitle2();
			String headTitle3 = longRangeSkdGRPVO.getHeadTitle3();
			String headTitle4 = longRangeSkdGRPVO.getHeadTitle4();
			
			Map<String, String[]> simInfoMap = longRangeSkdGRPVO.getSimInfoMap();
			
			// 파이프라인(|)은 정규식에서는 특수문자 이므로
			// 일반문자로 인식시키기 위해 \\를 사용한다.
			String[] titles1 = headTitle1.split("\\|");
			String[] titles2 = headTitle2.split("\\|");
			String[] titles3 = headTitle3.split("\\|");
			String[] titles4 = headTitle4.split("\\|");
			
			if(!(
					(titles1.length==titles2.length)
					&& (titles2.length==titles3.length)
					&& (titles3.length==titles4.length)
					&& (titles4.length==titles1.length)
			))
			{
				// 헤더 길이가 다르면 오류
				throw new EventException(new ErrorHandler("VSK10039").getMessage());			
			}
			
			// CLPT_IND_SEQ, CLPT_SEQ, CALL_YD_IND_SEQ 설정

			// ---------- Step1. PfSkdVO 리스트를 생성 시작 ----------
			
			// PF 정보에 헤더 정보를 추가한다.(Add Call 정보가 추가될것임)
			List<PfSkdVO> pfSkdList = new ArrayList<PfSkdVO>();
			for(int i=1,k=0; i<titles1.length; i=i+2){
				PfSkdVO pfSkdVO = pfSkdVOs[k];
				if(titles2[i].equals(pfSkdVO.getPortCd())){
					pfSkdList.add(pfSkdVO);
					k++;
				}else{
					// add call 되어 title 정보에는 있지만 P/F에는 없는 상태
					// title 정보를 이용해서 PfSkdVO를 생성한다.
					// ETB/ETD Day Code(요일) 값이 NULL 이므로,
					// 이를 이용하여 Add Call Port로 인식할 수 있다. 
					PfSkdVO vo = new PfSkdVO();
					vo.setPortCd(titles2[i]);
					vo.setSkdDirCd(titles1[i]);
					pfSkdList.add(vo);
				}
			}
			
			// ---------- Step1. PfSkdVO 리스트를 생성 완료 ----------
			
			// ---------- Step2. 화면의 시뮬레이션 정보를 Vessel별 리스트로 전환 시작 ----------
			
			String[] vvd1 = longRangeSkdGRPVO.getVVD1();
			String[] vvd2 = longRangeSkdGRPVO.getVVD2();
			String[] vvd3 = longRangeSkdGRPVO.getVVD3();
			
			List<LongRangeSkdVO> skdList = new ArrayList<LongRangeSkdVO>(); // 화면 스케쥴 정보
			List<LongRangeSkdVO> tmpList = new ArrayList<LongRangeSkdVO>();
			
			String initEtbDate = null;
			String initEtbDay = null;
			String initEtdDate = null;
			String initEtdDay = null;
			
			LongRangeSkdVO dummy = new LongRangeSkdVO();
			LongRangeSkdVO empty = null;
			
			String uiFormat = "MM/ddyyyyHHmm";
			String dataFormat = "yyyyMMddHHmm";
			
			//simulation 하지 않고 P/IN을 실행한 경우, vvd1/vvd2/vvd3는 null일 수 있다.
			for(int m=0; vvd1!=null && m<vvd1.length; m++){
				
				empty = new LongRangeSkdVO();
				if(!addCancel && addPort!=null){
					empty.setPortCd(addPort.getPortCd());
					empty.setEtbDyCd("");
					empty.setEtdDyCd("");
					empty.setInitEtbDay("");
					empty.setInitEtdDay("");
				}
				
				if(vvd1[m].equals(longRangeSkdGRPVO.getPhaseinVslCd())){
					continue;
				}
				
				tmpList.clear();
				
				for(int k=0; k<pfSkdList.size(); k++){
					
					if(addCancel && k==addCallPos-1){
						continue;
					}
					
					LongRangeSkdVO skdVo = new LongRangeSkdVO();
					PfSkdVO pfSkdVO = pfSkdList.get(k);
					
					skdVo.setVslCd(vvd1[m]);
					skdVo.setVoyNo(vvd2[m]);
					skdVo.setSkdDirCd(vvd3[m]);
					skdVo.setPortCd(pfSkdVO.getPortCd());
					
					boolean skip = false;
					
					if(m!=0 && (m+1)%4==0){
						initEtbDate = simInfoMap.get("ETB" + k)[m];
						initEtdDate = simInfoMap.get("ETD" + k)[m];
						
						if("SKIP".equals(initEtbDate.trim())){
							skip = true;
						}
						
						if("SKIP".equals(initEtdDate.trim())){
							skip = true;
						}
						
						if(!skip){
							skdVo.setInitEtbDate(initEtbDate);
							skdVo.setInitEtdDate(initEtdDate);
						}else{
							skdVo.setSkip(true);
						}
						
					}else{
						skdVo.setEtbDyCd(pfSkdVO.getEtbDyCd());
						skdVo.setEtdDyCd(pfSkdVO.getEtdDyCd());
						
						initEtbDate = simInfoMap.get("ETB" + k)[m];
						initEtdDate = simInfoMap.get("ETD" + k)[m];
						
						if("SKIP".equals(initEtbDate.trim())){
							skip = true;
						}
						
						if("SKIP".equals(initEtdDate.trim())){
							skip = true;
						}
						
						if(!skip){
							initEtbDate = VSKGeneralUtil.changeDateFormat(initEtbDate, uiFormat, dataFormat);
							initEtdDate = VSKGeneralUtil.changeDateFormat(initEtdDate, uiFormat, dataFormat);
							
							initEtbDay = VSKGeneralUtil.getDay(initEtbDate);
							initEtdDay = VSKGeneralUtil.getDay(initEtdDate);
							
							skdVo.setInitEtbDate(initEtbDate);
							skdVo.setInitEtdDate(initEtdDate);
							skdVo.setInitEtbDay(initEtbDay);
							skdVo.setInitEtdDay(initEtdDay);
						}else{
							skdVo.setSkip(true);
						}
					}
					
					tmpList.add(skdVo);
					
				}
				
				tmpList.add(dummy);
				if(!addCancel && addPort!=null){
					
					if(m==addVvdPos){
						// addPort가 VVD의 첫번째 오는 경우를 대비해서 기존 첫번째 port의 VVD를 복사해준다.
						LongRangeSkdVO firstPort = tmpList.get(0);
						addPort.setVslCd(firstPort.getVslCd());
						addPort.setVoyNo(firstPort.getVoyNo());
						addPort.setSkdDirCd(firstPort.getSkdDirCd());
						addPort.setSkdCngStsCd("A");
						tmpList.add(addCallPos-1, addPort);
					}else{
						// addPort가 VVD의 첫번째 오는 경우를 대비해서 기존 첫번째 port의 VVD를 복사해준다.
						LongRangeSkdVO firstPort = tmpList.get(0);
						empty.setVslCd(firstPort.getVslCd());
						empty.setVoyNo(firstPort.getVoyNo());
						empty.setSkdDirCd(firstPort.getSkdDirCd());
						tmpList.add(addCallPos-1, empty);
					}
					
				}
	 			skdList.addAll(tmpList);
			}
			
			return skdList;
				
			// ---------- Step2. 화면의 시뮬레이션 정보를 Vessel별 리스트로 전환 완료 ----------
			
		} catch (EventException e) {
			throw e;			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), de);
		}
		
	}

	/**
	 * 기본 시뮬레이션 정보를 생성한다.
	 * 
	 * @param PfSkdVO[] pfSkdVOs
	 * @param List<String[]> vslValues
	 * @param String endDate
	 * @param int initPortPos
	 * @param String voyNoType
	 * @param int iSvcDurDys
	 * @param int iVslCount
	 * @return List<LongRangeSkdVO>
	 * @exception EventException
	 */
	private List<LongRangeSkdVO> getSimSkd(PfSkdVO[] pfSkdVOs, List<String[]> vslValues, String endDate, int initPortPos, String voyNoType, int iSvcDurDys, int iVslCount) throws EventException {
		
		try {
			
			List<LongRangeSkdVO> skdlist = new ArrayList<LongRangeSkdVO>();
			
			String[] vslCd = new String[vslValues.size()];
			String[] voyNo = new String[vslValues.size()];
			String[] startDate = new String[vslValues.size()];
			String[] standDate = new String[vslValues.size()];
			boolean[] validDate = new boolean[vslValues.size()];
			Arrays.fill(validDate, true);
			
			int i = 0;
			int m = 0;
			
			// P/F의 ETB_DY_NO가 0으로 시작하는 경우 모든 ETB_DY_NO, ETD_DY_NO를 +1 증가시킨다.
			if("0".equals(pfSkdVOs[0].getEtbDyNo())){
				for(int k=0; k<pfSkdVOs.length; k++){
					pfSkdVOs[k].setEtbDyNo(Integer.toString(Integer.parseInt(pfSkdVOs[k].getEtbDyNo())+1));
					pfSkdVOs[k].setEtdDyNo(Integer.toString(Integer.parseInt(pfSkdVOs[k].getEtdDyNo())+1));
				}
			}
			
			for(String[] array : vslValues){
				startDate[i] = array[m++].replaceAll("-", "");
				vslCd[i] = array[m++];
				voyNo[i] = array[m++];
				
				i++;
				m=0;
			}
			
			/*
				voyNoType
				
				0 : Normal
				1 : Direction (ADD One)
				2 : Sequence
			*/
			voyNoType = (voyNoType==null || "".equals(voyNoType))?"0":voyNoType;
			int iVoyNoType = Integer.parseInt(voyNoType);
			
			/* voy_no_type을 2로 설정한 경우(Sequence 타입) VSL_COUNT가 0 이면 사용자가 입력한 Vessel 갯수를 사용한다 */
			if(iVoyNoType==2 && iVslCount==0){
				iVslCount = vslValues.size();
			}
			
			PfSkdVO pfSkdVO = null;
			LongRangeSkdVO skdVO = null;
			LongRangeSkdVO dummy = new LongRangeSkdVO();
			
			pfSkdVO = pfSkdVOs[0];
			
			String etb = null;
			String etd = null;
			
			// VVD-3
			String vvd3 = null;
			if(pfSkdVO.getSkdDirCd().equals(pfSkdVOs[pfSkdVOs.length-1].getSkdDirCd())){
				vvd3 = pfSkdVO.getSkdDirCd();
			}else{
				vvd3 = pfSkdVO.getSkdDirCd() + "/" + pfSkdVOs[pfSkdVOs.length-1].getSkdDirCd();
			}
			
			// Start Port
			PfSkdVO initPort = null;
			int initPortDyNo = 0;
			
			String firstDirCd = pfSkdVO.getSkdDirCd();
			boolean oneWayDirCd = true;
			for(PfSkdVO vo : pfSkdVOs){
				if(firstDirCd.equals(vo.getSkdDirCd())){
					continue;
				}else{
					oneWayDirCd = false; // 이 P/F는 2 Direction으로 구성되어 있음.
					break;
				}
			}
			
			for(i=0; true; i++){
				
				int pos = i%vslCd.length;
				
				// 모든 Vessel 의 시뮬레이션 날짜가 endDate를 넘어서는 경우 스케쥴 생성을 중지한다.
				if(VSKGeneralUtil.isFinish(validDate)){
					break;
				}
				
				// 어떤 Vessel이 시뮬레이션 날짜가 endDate를 넘어서는 경우 다음 Vessel로 넘어간다.
				if(!validDate[pos]){
					continue;
				}
				
				// Vessel별 시뮬레이션 진행 날짜를 보관하고 있는 standDate 배열은
				// 맨 처음에는 null 이므로, 이때는 startDate를 기준으로 시작한다.
				if(standDate[pos]==null){
					standDate[pos] = startDate[pos];
				}
				
				// 스케쥴이 시작되는 최초 Port 지정
				// 최초 VVD 생성시에만 first calling port를 선택할 수 있음.
				// 이후 VVD는 스케쥴대로 생성됨.
				// 스케쥴이 항상 첫번째 port에서 시작되는 것은 아니기 때문이다.(skip, phasein, phaseout 의 경우)
				if(i==0){
					initPort = pfSkdVOs[initPortPos];
				}else{
					initPort = pfSkdVOs[0];
				}
				initPortDyNo = Integer.parseInt(initPort.getEtbDyNo());
				
				// P/F를 기준으로 데이터를 생성했을때 UI상에서 하나의 Row 데이터가 생성되는데
				// DB에서 3가지 시간을 관리하기 때문에 3 Row를 생성해주며 (PF시간, INIT시간, VPS시간)
				// 각 셀의 temp 역할을 하는 4번째 Row가 추가된다.
				// 사용자 조작구분(Add/Skip Call 등)을 구분하기 위해 하나의 Row를 더 추가해준다.
				// 즉, 실제 화면에서 보여지는 Row는 k=0 일때의 Row이며, 나머지 Row는 LongRangeViewAdapter에서 hidden 처리된다. 
				for(int k=0; k<4; k++){
					for(m=0; m<pfSkdVOs.length; m++){
						
						pfSkdVO = pfSkdVOs[m];
						
//						 LongRangeSkdVO
						skdVO = new LongRangeSkdVO();
						
						if(vslCd[pos]==null || vslCd[pos].length()==0){
							continue;
						}
						
						skdVO.setVslCd(vslCd[pos]);
						if(iVoyNoType==0){
							skdVO.setVoyNo(VSKGeneralUtil.getVoyNo(voyNo[pos]));
						}else if(iVoyNoType==1){
							String voyNo1 = VSKGeneralUtil.getVoyNo(voyNo[pos]);
							String voyNo2 = VSKGeneralUtil.nextVoyNo(voyNo[pos], 1);
							skdVO.setVoyNo(voyNo1 + "/" + voyNo2);
						}else if(iVoyNoType==2){
							skdVO.setVoyNo(VSKGeneralUtil.getVoyNo(voyNo[pos]));
						}
						skdVO.setSkdDirCd(vvd3);
						
						// 최초 VVD 생성시에만 first calling port를 선택할 수 있음.
						// 이후 VVD는 스케쥴대로 생성됨.
						// phasein 또는 phaseout 인 경우,
						// 스케쥴이 항상 첫번째 port에서 시작되는 것은 아니기 때문이다. 
						if(i==0 && m<initPortPos){
							
							skdVO.setPortCd(pfSkdVO.getPortCd());
							skdVO.setEtbDyCd(pfSkdVO.getEtbDyCd());
							skdVO.setEtdDyCd(pfSkdVO.getEtdDyCd());
							
							skdVO.setInitEtbDate("");
							skdVO.setInitEtbDay(pfSkdVO.getEtbDyCd());
							
							skdVO.setInitEtdDate("");
							skdVO.setInitEtdDay(pfSkdVO.getEtdDyCd());
							
						}else{
						
							skdVO.setPortCd(pfSkdVO.getPortCd());
							skdVO.setEtbDyCd(pfSkdVO.getEtbDyCd());
							skdVO.setEtdDyCd(pfSkdVO.getEtdDyCd());
							
							// 최초 시뮬레이션의 ETB는 P/F를 기준으로 생성됨.
							etb = VSKGeneralUtil.getActionDate(standDate[pos], Integer.parseInt(pfSkdVO.getEtbDyNo()) - initPortDyNo);
							if(k!=3){
								skdVO.setInitEtbDay(VSKGeneralUtil.getDay(etb));
								skdVO.setInitEtbDate(etb + pfSkdVO.getEtbTmHrmnt());
							}
							
							// 최초 시뮬레이션의 ETD는 P/F를 기준으로 생성됨.
							etd = VSKGeneralUtil.getActionDate(standDate[pos], Integer.parseInt(pfSkdVO.getEtdDyNo()) - initPortDyNo);
							if(k!=3){
								skdVO.setInitEtdDay(VSKGeneralUtil.getDay(etd));
								skdVO.setInitEtdDate(etd + pfSkdVO.getEtdTmHrmnt());
							}
						
						}
						
						skdlist.add(skdVO);
					}
					
					//vessel별 가장 마지막 스케줄은 표시하지 않음.
					if(etb != null && etb.compareTo(endDate)>=0){
						skdlist.remove(skdlist.size()-1);
					}
					
					skdlist.add(dummy);	
				}
				
				if(iVoyNoType==0){
					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], 1);
				}else if(iVoyNoType==1){
					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], 2);
				}else if(iVoyNoType==2){
					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], iVslCount);
				}
				
				// 앞선VVD의 ETB를 다음 VVD의 시작날짜로 한다. 
				// ==> 변경(2009.12.21)
				// 2 Direction인 경우는, 기존과 동일
				// 1 Direction인 경우는, Duration으로 다음 VVD의 시작날짜를 잡는다.(1 Direction으로 구성된 Feeder의 경우)
				if(oneWayDirCd){
					//standDate[pos] = VSKGeneralUtil.getActionDate(standDate[pos], Integer.parseInt(pfSkdVOs[pfSkdVOs.length-1].getEtbDyNo()));
					standDate[pos] = VSKGeneralUtil.getActionDate(standDate[pos], iSvcDurDys);
				}else{
					standDate[pos] = etb;
				}
				
				if(standDate[pos].compareTo(endDate)>=0){
					validDate[pos] = false;
				}
				
			}
			
			return skdlist;
			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), de);
		}
		
	}
	
	/**
	 * 현재 VVD 리스트에 Port SKD 정보를 추가한다.
	 * 
	 * @param VskSwapCstPortVO skdVO
	 * @param List<VskSwapCstPortVO> currVVD
	 * @return VskSwapCstPortVO
	 */
	private VskSwapCstPortVO addPortSkd(VskSwapCstPortVO skdVO, List<VskSwapCstPortVO> currVVD){
		
		int clptIndSeq = 1;
		int callYdIndSeq = 1;
		
		for(VskSwapCstPortVO vo : currVVD){
			if(vo.getVpsPortCd().equals(skdVO.getVpsPortCd())){
				skdVO.setClptIndSeq(Integer.toString(++clptIndSeq));  // CLPT_IND_SEQ					
			}
			if(skdVO.getYdCd()!=null 
					&& skdVO.getYdCd().trim().length()!=0
					&& skdVO.getYdCd().equals(vo.getYdCd())){
				skdVO.setCallYdIndSeq(Integer.toString(++callYdIndSeq));  // CALL_YD_IND_SEQ
			}
		}
		skdVO.setClptSeq(Integer.toString(currVVD.size()+1));  // CLPT_SEQ
		currVVD.add(skdVO);
		return skdVO;
	}
	
	/*
	 * CHM-201005742-01 Non-Weekly P/F SKD에 대한 LRS 생성
	 */
	/**
	 * 이전 VVD 리스트에 Virtual Port SKD 정보를 추가한다.
	 * 
	 * @param VskSwapCstPortVO skdVO
	 * @param List<VskSwapCstPortVO> prevVVD
	 * @return VskSwapCstPortVO
	 */
	private VskSwapCstPortVO addVirtualPortSkd(VskSwapCstPortVO skdVO, List<VskSwapCstPortVO> prevVVD){
		if("N".equals(skdVO.getTurnPortFlg())){
			return skdVO;
		}else{
			VskSwapCstPortVO lastVO = prevVVD.get(prevVVD.size()-1);			
			VskSwapCstPortVO virtualSkdVO = new VskSwapCstPortVO(); 
			ObjectCloner.build(skdVO, virtualSkdVO);
			
			int clptIndSeq = 1;
			int callYdIndSeq = 1;
			
			if(lastVO.getSkdVoyNo().equals(virtualSkdVO.getSkdVoyNo())){
				virtualSkdVO.setTurnPortFlg("N");
				virtualSkdVO.setTurnPortIndCd("D");
			}else{
				virtualSkdVO.setTurnPortFlg("N");
				virtualSkdVO.setTurnPortIndCd("V");
			}
			
			virtualSkdVO.setSkdVoyNo(lastVO.getSkdVoyNo());  // SKD_VOY_NO
			virtualSkdVO.setSkdDirCd(lastVO.getSkdDirCd());  // SKD_DIR_CD
			virtualSkdVO.setTurnSkdVoyNo(skdVO.getSkdVoyNo());  // TURN_SKD_VOY_NO
			virtualSkdVO.setTurnSkdDirCd(skdVO.getSkdDirCd());  // TURN_SKD_DIR_CD
			virtualSkdVO.setTurnClptIndSeq(skdVO.getClptIndSeq());  // TURN_CLPT_IND_SEQ
			
			// 이전 VVD의 마지막 Port와 현재 VVD의 첫번째 Port가 중복
			// 이전 정보를 제거하고 새로운 정보로 추가한다.
			// CHM-201005742-01 Final Port를 찾기 위해 YD Code도 체크한다.
			if(lastVO.getVpsPortCd().equals(virtualSkdVO.getVpsPortCd()) &&
					lastVO.getYdCd().equals(virtualSkdVO.getYdCd())){
				if("F".equals(lastVO.getTurnPortIndCd())){
					prevVVD.remove(prevVVD.size()-1);
					virtualSkdVO.setTurnPortIndCd("F");
				}
			}
			
			virtualSkdVO.setClptSeq(Integer.toString(prevVVD.size()+1));  // CLPT_SEQ
			for(VskSwapCstPortVO vo : prevVVD){
				if(vo.getVpsPortCd().equals(virtualSkdVO.getVpsPortCd())){
					virtualSkdVO.setClptIndSeq(Integer.toString(++clptIndSeq));  // CLPT_IND_SEQ					
				}
				if(virtualSkdVO.getYdCd()!=null 
						&& virtualSkdVO.getYdCd().trim().length()!=0 
						&& virtualSkdVO.getYdCd().equals(vo.getYdCd())){
					virtualSkdVO.setCallYdIndSeq(Integer.toString(++callYdIndSeq));  // CALL_YD_IND_SEQ
				}
			}
			
			prevVVD.add(virtualSkdVO);
			
			skdVO.setTurnSkdVoyNo(virtualSkdVO.getSkdVoyNo());  // TURN_SKD_VOY_NO
			skdVO.setTurnSkdDirCd(virtualSkdVO.getSkdDirCd());  // TURN_SKD_DIR_CD
			skdVO.setTurnClptIndSeq(virtualSkdVO.getClptIndSeq());  // TURN_CLPT_IND_SEQ
			
			return skdVO;
		}
	}
	
	/**
	 * ETB에서 ETA를 구한다.
	 * ETA = ETB - Maneuvering In Hour
	 * 
	 * @param String strEtb
	 * @param String format
	 * @param String mnvrInHour
	 * @return String
	 */
	private String getETA(String strEtb, String format, String mnvrInHour){
		
		if(strEtb==null || strEtb.trim().length()==0){
			return "";
		}
		
		if(mnvrInHour==null || mnvrInHour.trim().length()==0){
			mnvrInHour = "0";
		}
		
		BigDecimal mnvrInTime = new BigDecimal(mnvrInHour);
		mnvrInTime = mnvrInTime.movePointRight(1); // 곱하기 10하여 소숫점 제거
		
		int hour = mnvrInTime.intValue() / 10;
		int min = mnvrInTime.intValue() % 10 * 6; // 1은 6분, 2는 12분 ... 6분 단위
		
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date eta = null;
		Date etb = null;
		Calendar cal = Calendar.getInstance();
		try {
			etb = sf.parse(strEtb);
		} catch (ParseException e) {
			log.error(e.getMessage());
			return "";
		}
		cal.setTime(etb);
		cal.add(Calendar.HOUR_OF_DAY, hour*(-1));
		cal.add(Calendar.MINUTE, min*(-1));
		eta = cal.getTime();
		return sf.format(eta);
	}
	
	
	
	/**
	 * Service Lane Code, Direction Code 가 MDM Service Lane Table에 등록되어 있는지 확인한다.
	 * 
	 * @param List<VskVslSkdVO> list
	 * @return boolean
	 * @exception EventException
	 */
	private boolean isCheckLaneDir(List<VskVslSkdVO> list) throws EventException{
		boolean isFlag = false;
		
		try{
			for(int i=0; i<list.size(); i++) {
				//Service Lane Code, Direction Code 가 MDM Service Lane Table에 등록되어 있는지 확인한다.
				String chkFlag = dbDao.checkLaneDir(list.get(i).getVslSlanCd(), list.get(i).getSkdDirCd());
				if("X".equals(chkFlag)){
					isFlag = true;
				}else{
					/*
					 * MSG - Service Lane Code가 없습니다. MDM System에서 등록해 주세요.
					 */
					throw new EventException(new ErrorHandler("VSK10019").getMessage());
				}
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return isFlag;
	}
	
	/**
	 * MDM Container Vessel Code 정보에 등록되어 있는지 확인한다.
	 * 
	 * @param List<VskVslSkdVO> list
	 * @return boolean
	 * @exception EventException
	 */
	private boolean isCheckVslCntr(List<VskVslSkdVO> list) throws EventException{
		boolean isFlag = false;
		VesselVO vesselVO = new VesselVO();
		try{
			for(int i=0; i<list.size(); i++) {
				//MDM Container Vessel Code 정보에 등록되어 있는지 확인한다.
				vesselVO.setVslCd(list.get(i).getVslCd());
				int chkCnt = dbDao.checkVslCntr(vesselVO);
				if(chkCnt > 0){
					isFlag = true;
				}else{
					/*
					 * MSG - Vessel Code가 존재하지 않습니다. MDM 시스템에서 Vessel Code를 등록해 주세요.
					 */
					throw new EventException(new ErrorHandler("VSK10028").getMessage());
				}
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return isFlag;
	}
	
	/**
	 * 넘겨받은 List 에 해당 VVD 가 존재하는지 Check 한다.
	 * 
	 * @param List<VskVslSkdVO> list
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return boolean
	 */
	private boolean isSameDataByVvd(List<VskVslSkdVO> list, VskVslSkdVO vskVslSkdVO){
		if(list != null && list.size() > 0 && vskVslSkdVO != null){
			for(int i=0; i<list.size(); i++){
				if(list.get(i).getVslCd().equals(vskVslSkdVO.getVslCd())
						&& list.get(i).getSkdVoyNo().equals(vskVslSkdVO.getSkdVoyNo())
						&& list.get(i).getSkdDirCd().equals(vskVslSkdVO.getSkdDirCd())){
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * SKD_STS_CD 를 조회해 온다(ACT, RDY 등).
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	private String getSkdStsCd(String vslCd) throws EventException{
		String skdStsCd = "";
		try{
			skdStsCd = dbDao.searchSkdStsCd(vslCd);
		}catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}catch(Exception ex){
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return skdStsCd;
	}
	
	/**
	 * VVD 의 첫번째 Port 의 Port Code 와 ETB를 찾는다.
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param String vvd
	 * @return VskVslSkdVO
	 */
	private VskVslSkdVO getfirstPortBrthDt(CstSkdByVvdVO[] cstSkdByVvdVOs, String vvd){
		VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
		for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs) {
			String sVvd = cstSkdByVvdVO.getVslCd() + cstSkdByVvdVO.getSkdVoyNo() + cstSkdByVvdVO.getSkdDirCd();
			
			// 해당 VVD 의 Skip 이 아닌 건을 찾는다.
			if(sVvd.equals(vvd)){
				if(!"S".equals(cstSkdByVvdVO.getSkdCngStsCd())){
					vskVslSkdVO.setStPortCd(cstSkdByVvdVO.getVpsPortCd());
					vskVslSkdVO.setN1stPortBrthDt(cstSkdByVvdVO.getVpsEtbDt());
					break;
				}
			}
		}
		return vskVslSkdVO;
	}
	
	/**
	 * Vessel Port SKD 정보에서 Insert 할 Master 정보를 찾는다.
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	private List<VskVslSkdVO> getMasterInsertData(CstSkdByVvdVO[] cstSkdByVvdVOs, String userId) throws EventException{
		List<VskVslSkdVO> insertVoList = new ArrayList<VskVslSkdVO>();
		for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs) {
			if("I".equals(cstSkdByVvdVO.getIbflag())){
				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
				
				vskVslSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
				vskVslSkdVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd());
				vskVslSkdVO.setSkdUsdIndCd("H");
				vskVslSkdVO.setPfSkdTpCd(cstSkdByVvdVO.getPfSvcTpCd());
				vskVslSkdVO.setPsdoVvdCd("FD" + cstSkdByVvdVO.getVpsEtdDt().substring(2, 8) + "E");
				vskVslSkdVO.setCoCd("H");
				vskVslSkdVO.setSkdRmk(cstSkdByVvdVO.getSkdRmk());
				vskVslSkdVO.setCreUsrId(userId);
				vskVslSkdVO.setUpdUsrId(userId);
				
				if(!isSameDataByVvd(insertVoList, vskVslSkdVO)){
					// SKD_STS_CD 를 조회해 온다(ACT, RDY 등).
					if(VSKGeneralUtil.isNull(vskVslSkdVO.getSkdStsCd())){
						vskVslSkdVO.setSkdStsCd(getSkdStsCd(vskVslSkdVO.getVslCd()));
					}
					
					// 1st Port 의 ETB 를 찾아 온다.
					String vvd = vskVslSkdVO.getVslCd() + vskVslSkdVO.getSkdVoyNo() + vskVslSkdVO.getSkdDirCd();
					VskVslSkdVO firstPortInfoVO = getfirstPortBrthDt(cstSkdByVvdVOs, vvd);
					if(firstPortInfoVO == null){
						// 모든 Port 가 Skip 일 경우 1st Port의 ETB(2010.03.05 임창빈수석 요청)
						vskVslSkdVO.setStPortCd(cstSkdByVvdVO.getVpsPortCd());
						vskVslSkdVO.setN1stPortBrthDt(cstSkdByVvdVO.getVpsEtbDt());
					}else{
						vskVslSkdVO.setStPortCd(firstPortInfoVO.getStPortCd());
						vskVslSkdVO.setN1stPortBrthDt(firstPortInfoVO.getN1stPortBrthDt());
					}
					
					insertVoList.add(vskVslSkdVO);
				}
			}else{
				// 1건이라도 Insert 가 아닌 건이 있으면 Master 는 Insert 하지 않는다.
				return null;
			}
		}//end for
	
		return insertVoList;
	}
	
	/**
	 * Vessel Port SKD 정보에서 Update 할 Master 정보를 찾는다.
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	private List<VskVslSkdVO> getMasterUpdateData(CstSkdByVvdVO[] cstSkdByVvdVOs, String userId) throws EventException{
		List<VskVslSkdVO> updateVoList = new ArrayList<VskVslSkdVO>();
		
		for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs) {
			if ("U".equals(cstSkdByVvdVO.getIbflag())){
				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
				
				vskVslSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
				vskVslSkdVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd());
				vskVslSkdVO.setSkdStsCd(cstSkdByVvdVO.getSkdStsCd());
				vskVslSkdVO.setSkdUsdIndCd("H");
				vskVslSkdVO.setPfSkdTpCd(cstSkdByVvdVO.getPfSvcTpCd());
				vskVslSkdVO.setPsdoVvdCd("FD" + cstSkdByVvdVO.getVpsEtdDt().substring(2, 8) + "E");
				vskVslSkdVO.setCoCd("H");
				vskVslSkdVO.setSkdRmk(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSkdRmk(), " "));
				vskVslSkdVO.setCreUsrId(userId);
				vskVslSkdVO.setUpdUsrId(userId);
				
				if(!isSameDataByVvd(updateVoList, vskVslSkdVO)){
					// SKD_STS_CD 를 조회해 온다(ACT, RDY 등).
					if(VSKGeneralUtil.isNull(vskVslSkdVO.getSkdStsCd())){
						vskVslSkdVO.setSkdStsCd(getSkdStsCd(vskVslSkdVO.getVslCd()));
					}
					
					// 1st Port 의 ETB 를 찾아 온다.
					String vvd = vskVslSkdVO.getVslCd() + vskVslSkdVO.getSkdVoyNo() + vskVslSkdVO.getSkdDirCd();
					VskVslSkdVO firstPortInfoVO = getfirstPortBrthDt(cstSkdByVvdVOs, vvd);
					if(firstPortInfoVO == null){
						// 모든 Port 가 Skip 일 경우 1st Port의 ETB(2010.03.05 임창빈수석 요청)
						vskVslSkdVO.setStPortCd(cstSkdByVvdVO.getVpsPortCd());
						vskVslSkdVO.setN1stPortBrthDt(cstSkdByVvdVO.getVpsEtbDt());
					}else{
						vskVslSkdVO.setStPortCd(firstPortInfoVO.getStPortCd());
						vskVslSkdVO.setN1stPortBrthDt(firstPortInfoVO.getN1stPortBrthDt());
					}
					
					updateVoList.add(vskVslSkdVO);
				}
			}
		}//end for
	
		return updateVoList;
	}
	
	/**
	 * Vessel Port SKD 정보에서 Delete 할 Master 정보를 찾는다.
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	private List<VskVslSkdVO> getMasterDeleteData(CstSkdByVvdVO[] cstSkdByVvdVOs, String userId) throws EventException{
		List<VskVslSkdVO> deleteVoList = new ArrayList<VskVslSkdVO>();		// 삭제할 VVD
		List<VskVslSkdVO> masterVoList = getMasterVvdList(cstSkdByVvdVOs, userId);		// cstSkdByVvdVOs 로 넘어 온 VVD
		
		// masterVoList 에서 삭제할 VVD 를 찾아 deleteVoList 에 담는다.
		for(VskVslSkdVO vskVslSkdVO : masterVoList){
			boolean isDelFlg = true;	// 각 Port 별 삭제 여부.
			for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs){
				if(vskVslSkdVO.getVslCd().equals(cstSkdByVvdVO.getVslCd())
						&& vskVslSkdVO.getSkdVoyNo().equals(cstSkdByVvdVO.getSkdVoyNo())
						&& vskVslSkdVO.getSkdDirCd().equals(cstSkdByVvdVO.getSkdDirCd())){
					if(!"D".equals(cstSkdByVvdVO.getIbflag())){
						isDelFlg = false;	// VVD 에 삭제가 아닌 Port 가 1건이라도 존재하면 VVD 삭제 안함.
						break;
					}
				}
			}
			
			// VVD 에 모든 Port 가 삭제이면 해당 VVD 삭제.
			if(isDelFlg){
				deleteVoList.add(vskVslSkdVO);
			}
		}
		
		return deleteVoList;
	}
	
	/**
	 * 현재 User Id 를 판단하여 반환한다.
	 * 
	 * @param SignOnUserAccount account
	 * @param String strId
	 * @return String
	 */
	private String currentUserId(SignOnUserAccount account, String strId){
		String userId = "";
		
		// 임시처리.
		if(account == null){
			userId = strId;
		}else{
			userId = account.getUsr_id();
		}
		
		return userId;
	}
	
	/**
	 * Coastal Schedule 의 Port 단위의 Data 에서 Master 정보들의 목록을 간추려 반환한다.
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 */
	private List<VskVslSkdVO> getMasterVvdList(CstSkdByVvdVO[] cstSkdByVvdVOs, String userId){
		List<VskVslSkdVO> masterVoList = new ArrayList<VskVslSkdVO>();		// cstSkdByVvdVOs 로 넘어 온 VVD

		String curVvdCd = "";	//현재 VVD
		String preVvdCd = "";	//이전 VVD
		
		// cstSkdByVvdVOs 로 넘어 온 VVD 만 masterVoList 에 담는다.
		for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs){
			//VVD 코드
			curVvdCd = cstSkdByVvdVO.getVslCd() + cstSkdByVvdVO.getSkdVoyNo() + cstSkdByVvdVO.getSkdDirCd();
			
			if(!curVvdCd.equals(preVvdCd)){
				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
				vskVslSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
				vskVslSkdVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd());
				// Log 남기기 위한 User 정보
				if(VSKGeneralUtil.isNull(cstSkdByVvdVO.getCreUsrId())){
					vskVslSkdVO.setCreUsrId(userId);
				}else{
					vskVslSkdVO.setCreUsrId(cstSkdByVvdVO.getCreUsrId());
				}
				// Log 남기기 위한 User 정보
				if(VSKGeneralUtil.isNull(cstSkdByVvdVO.getUpdUsrId())){
					vskVslSkdVO.setUpdUsrId(userId);
				}else{
					vskVslSkdVO.setUpdUsrId(cstSkdByVvdVO.getUpdUsrId());
				}
				
				if(!isSameDataByVvd(masterVoList, vskVslSkdVO)){
					masterVoList.add(vskVslSkdVO);
				}
				
				preVvdCd = curVvdCd;
			}
		}
		
		return masterVoList;
	}
	
	/**
	 * Virtual Port DataSet 생성
	 *  
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param String clptIndSeq
	 * @param String clptSeq
	 * @param String laneCd
	 * @param String ydCd
	 * @param String callYdIndSeq
	 * @param String turnPortIndCd
	 * @param String userId
	 * @return
	 */
	private VslPortSkdVO makeVirtualDataSet(CstSkdByVvdVO cstSkdByVvdVO, String clptIndSeq, String clptSeq, String laneCd, String ydCd, String callYdIndSeq, String turnPortIndCd, String userId){
		VslPortSkdVO virtualPortVO = new VslPortSkdVO();
		
		virtualPortVO.setVslCd(cstSkdByVvdVO.getVslCd());
		virtualPortVO.setSkdVoyNo(cstSkdByVvdVO.getTurnSkdVoyNo());
		virtualPortVO.setSkdDirCd(cstSkdByVvdVO.getTurnSkdDirCd());
		virtualPortVO.setVpsPortCd(cstSkdByVvdVO.getVpsPortCd());
		virtualPortVO.setClptIndSeq(clptIndSeq);
		virtualPortVO.setNewClptIndSeq(clptIndSeq);
		virtualPortVO.setClptSeq(clptSeq);
		virtualPortVO.setSlanCd(laneCd);
		virtualPortVO.setPortSkdStsCd(cstSkdByVvdVO.getPortSkdStsCd());
		virtualPortVO.setYdCd(ydCd);
		virtualPortVO.setCallYdIndSeq(callYdIndSeq);
		virtualPortVO.setPfEtaDt(cstSkdByVvdVO.getPfEtaDt());
		virtualPortVO.setPfEtbDt(cstSkdByVvdVO.getPfEtbDt());
		virtualPortVO.setPfEtdDt(cstSkdByVvdVO.getPfEtdDt());
		virtualPortVO.setInitEtaDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getInitEtaDt(), cstSkdByVvdVO.getVpsEtaDt()));
		virtualPortVO.setInitEtbDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getInitEtbDt(), cstSkdByVvdVO.getVpsEtbDt()));
		virtualPortVO.setInitEtdDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getInitEtdDt(), cstSkdByVvdVO.getVpsEtdDt()));
		virtualPortVO.setVpsEtaDt(cstSkdByVvdVO.getVpsEtaDt());
		virtualPortVO.setVpsEtbDt(cstSkdByVvdVO.getVpsEtbDt());
		virtualPortVO.setVpsEtdDt(cstSkdByVvdVO.getVpsEtdDt());
		virtualPortVO.setVslDlayRsnCd(cstSkdByVvdVO.getVslDlayRsnCd());
		virtualPortVO.setVslDlayRsnDesc(cstSkdByVvdVO.getVslDlayRsnDesc());
		virtualPortVO.setVslDlayRsnLocCd(cstSkdByVvdVO.getVslDlayRsnLocCd());
		virtualPortVO.setShpCallNo(cstSkdByVvdVO.getShpCallNo());
		virtualPortVO.setShpCallNoUpdUsrId(cstSkdByVvdVO.getShpCallNoUpdUsrId());
		virtualPortVO.setShpCallNoUpdDt(cstSkdByVvdVO.getShpCallNoUpdDt());
		virtualPortVO.setTmlVslCd(cstSkdByVvdVO.getTmlVslCd());
		virtualPortVO.setTmlVoyNo(cstSkdByVvdVO.getTmlVoyNo());
		virtualPortVO.setFtDt(cstSkdByVvdVO.getFtDt());
		virtualPortVO.setPlismYdCd(cstSkdByVvdVO.getPlismYdCd());
		virtualPortVO.setPlismVslCd(cstSkdByVvdVO.getPlismVslCd());
		virtualPortVO.setPlismVoyNo(cstSkdByVvdVO.getPlismVoyNo());
		if("I".equals(cstSkdByVvdVO.getSkdCngStsCd())){
			// Turn Port Flag 가 "Y" 이고 Phase In 이면 Virtual 은 Phase Out 으로.
			virtualPortVO.setSkdCngStsCd("O");
		}else{
			virtualPortVO.setSkdCngStsCd(cstSkdByVvdVO.getSkdCngStsCd());
		}
		virtualPortVO.setTurnPortFlg("N");
		virtualPortVO.setTurnPortIndCd(turnPortIndCd);
		virtualPortVO.setTurnSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
		virtualPortVO.setTurnSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
		virtualPortVO.setTurnClptIndSeq(cstSkdByVvdVO.getNewClptIndSeq());
		virtualPortVO.setIbCgoQty(cstSkdByVvdVO.getIbCgoQty());
		virtualPortVO.setObCgoQty(cstSkdByVvdVO.getObCgoQty());
		virtualPortVO.setVpsRmk(cstSkdByVvdVO.getVpsRmk());
		virtualPortVO.setPhsIoRsnCd(cstSkdByVvdVO.getPhsIoRsnCd());
		virtualPortVO.setPhsIoRmk(cstSkdByVvdVO.getPhsIoRmk());
		virtualPortVO.setSkdBrthNo(cstSkdByVvdVO.getSkdBrthNo());
		virtualPortVO.setInitSkdInpFlg(cstSkdByVvdVO.getInitSkdInpFlg());
		virtualPortVO.setOfcInpFlg(cstSkdByVvdVO.getOfcInpFlg());
		virtualPortVO.setNoonRptInpFlg(cstSkdByVvdVO.getNoonRptInpFlg());
		virtualPortVO.setDepRptInpFlg(cstSkdByVvdVO.getDepRptInpFlg());
		virtualPortVO.setActInpFlg(cstSkdByVvdVO.getActInpFlg());
		virtualPortVO.setPrtChkFlg(cstSkdByVvdVO.getPrtChkFlg());
		virtualPortVO.setCreUsrId(userId);
		virtualPortVO.setUpdUsrId(userId);
		virtualPortVO.setEdiSndKnt(cstSkdByVvdVO.getEdiSndKnt());
		virtualPortVO.setPortSkpTpCd(cstSkdByVvdVO.getPortSkpTpCd());
		virtualPortVO.setPortSkpRsnCd(cstSkdByVvdVO.getPortSkpRsnCd());
		virtualPortVO.setPortSkpRsnOffrRmk(cstSkdByVvdVO.getPortSkpRsnOffrRmk());
		virtualPortVO.setTtlDlayHrs(cstSkdByVvdVO.getTtlDlayHrs());
		virtualPortVO.setTsPortCd(cstSkdByVvdVO.getTsPortCd());
		virtualPortVO.setUsdFlg(cstSkdByVvdVO.getUsdFlg());
		virtualPortVO.setAutoSkdCngFlg(cstSkdByVvdVO.getAutoSkdCngFlg());
		virtualPortVO.setLnkDist(cstSkdByVvdVO.getLnkDist());
		virtualPortVO.setLnkSpd(cstSkdByVvdVO.getLnkSpd());
		virtualPortVO.setTztmHrs(cstSkdByVvdVO.getTztmHrs());
		virtualPortVO.setSeaBufHrs(cstSkdByVvdVO.getSeaBufHrs());
		virtualPortVO.setMnvrInHrs(cstSkdByVvdVO.getMnvrInHrs());
		virtualPortVO.setMnvrOutHrs(cstSkdByVvdVO.getMnvrOutHrs());
		virtualPortVO.setPortWrkHrs(cstSkdByVvdVO.getActWrkHrs());
		virtualPortVO.setPortBufHrs(cstSkdByVvdVO.getPortBufHrs());
		
		return virtualPortVO;
	}
	
	/**
	 * VskVslPortSkdVO DataSet 생성
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param String callYdIndSeq
	 * @param String turnClptIndSeq
	 * @param String turnPortIndCd
	 * @param String userId
	 * @return
	 */
	private VslPortSkdVO makeVskVslPortDataSet(CstSkdByVvdVO cstSkdByVvdVO, String callYdIndSeq, String turnClptIndSeq, String turnPortIndCd, String userId){
		VslPortSkdVO vslPortSkdVO = new VslPortSkdVO();
		
		vslPortSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
		vslPortSkdVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
		vslPortSkdVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
		vslPortSkdVO.setVpsPortCd(cstSkdByVvdVO.getVpsPortCd());
		vslPortSkdVO.setClptIndSeq(cstSkdByVvdVO.getClptIndSeq());
		vslPortSkdVO.setNewClptIndSeq(cstSkdByVvdVO.getNewClptIndSeq());
		vslPortSkdVO.setClptSeq(cstSkdByVvdVO.getClptSeq());	//UI(화면)에서 Setting 
		vslPortSkdVO.setSlanCd(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSlanCd(), cstSkdByVvdVO.getVslSlanCd()));
		vslPortSkdVO.setYdCd(cstSkdByVvdVO.getVpsPortCd() + cstSkdByVvdVO.getTmlCd());
		vslPortSkdVO.setCallYdIndSeq(callYdIndSeq);
		vslPortSkdVO.setPfEtaDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPfEtaDt(), " "));
		vslPortSkdVO.setPfEtbDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPfEtbDt(), " "));
		vslPortSkdVO.setPfEtdDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPfEtdDt(), " "));
		vslPortSkdVO.setVpsEtaDt(cstSkdByVvdVO.getVpsEtaDt());
		vslPortSkdVO.setVpsEtbDt(cstSkdByVvdVO.getVpsEtbDt());
		vslPortSkdVO.setVpsEtdDt(cstSkdByVvdVO.getVpsEtdDt());
		vslPortSkdVO.setVslDlayRsnCd(cstSkdByVvdVO.getVslDlayRsnCd());
		vslPortSkdVO.setVslDlayRsnDesc(cstSkdByVvdVO.getVslDlayRsnDesc());
		vslPortSkdVO.setVslDlayRsnLocCd(cstSkdByVvdVO.getVslDlayRsnLocCd());
		vslPortSkdVO.setShpCallNo(cstSkdByVvdVO.getShpCallNo());
		vslPortSkdVO.setShpCallNoUpdUsrId(cstSkdByVvdVO.getShpCallNoUpdUsrId());
		vslPortSkdVO.setShpCallNoUpdDt(cstSkdByVvdVO.getShpCallNoUpdDt());
		vslPortSkdVO.setTmlVslCd(cstSkdByVvdVO.getTmlVslCd());
		vslPortSkdVO.setTmlVoyNo(cstSkdByVvdVO.getTmlVoyNo());
		vslPortSkdVO.setFtDt(cstSkdByVvdVO.getFtDt());
		vslPortSkdVO.setPlismYdCd(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPlismYdCd(), " "));
		vslPortSkdVO.setPlismVslCd(cstSkdByVvdVO.getPlismVslCd());
		vslPortSkdVO.setPlismVoyNo(cstSkdByVvdVO.getPlismVoyNo());
		vslPortSkdVO.setSkdCngStsCd(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSkdCngStsCd(), " "));
		vslPortSkdVO.setTurnPortFlg(cstSkdByVvdVO.getTurnPortFlg());
		vslPortSkdVO.setTurnPortIndCd(turnPortIndCd);
		vslPortSkdVO.setTurnSkdVoyNo(cstSkdByVvdVO.getTurnSkdVoyNo());
		vslPortSkdVO.setTurnSkdDirCd(cstSkdByVvdVO.getTurnSkdDirCd());
		vslPortSkdVO.setTurnClptIndSeq(turnClptIndSeq);
		vslPortSkdVO.setIbCgoQty(cstSkdByVvdVO.getIbCgoQty());
		vslPortSkdVO.setObCgoQty(cstSkdByVvdVO.getObCgoQty());
		vslPortSkdVO.setVpsRmk(cstSkdByVvdVO.getVpsRmk());
		vslPortSkdVO.setPhsIoRsnCd(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPhsIoRsnCd(), " "));
		vslPortSkdVO.setPhsIoRmk(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPhsIoRmk(), " "));
		vslPortSkdVO.setOfcInpFlg(cstSkdByVvdVO.getOfcInpFlg());
		vslPortSkdVO.setCreUsrId(userId);
		vslPortSkdVO.setUpdUsrId(userId);
		vslPortSkdVO.setPortSkpTpCd(cstSkdByVvdVO.getPortSkpTpCd());
		vslPortSkdVO.setPortSkpRsnCd(cstSkdByVvdVO.getPortSkpRsnCd());
		vslPortSkdVO.setPortSkpRsnOffrRmk(cstSkdByVvdVO.getPortSkpRsnOffrRmk());
		vslPortSkdVO.setTtlDlayHrs(cstSkdByVvdVO.getTtlDlayHrs());
		vslPortSkdVO.setTsPortCd(cstSkdByVvdVO.getTsPortCd());
		vslPortSkdVO.setUsdFlg(cstSkdByVvdVO.getUsdFlg());
		vslPortSkdVO.setAutoSkdCngFlg(cstSkdByVvdVO.getAutoSkdCngFlg());
		vslPortSkdVO.setLnkDist(cstSkdByVvdVO.getLnkDist());
		vslPortSkdVO.setLnkSpd(cstSkdByVvdVO.getLnkSpd());
		vslPortSkdVO.setTztmHrs(cstSkdByVvdVO.getTztmHrs());
		vslPortSkdVO.setSeaBufHrs(cstSkdByVvdVO.getSeaBufHrs());
		vslPortSkdVO.setMnvrInHrs(cstSkdByVvdVO.getMnvrInHrs());
		vslPortSkdVO.setMnvrOutHrs(cstSkdByVvdVO.getMnvrOutHrs());
		vslPortSkdVO.setPortWrkHrs(cstSkdByVvdVO.getActWrkHrs());
		vslPortSkdVO.setPortBufHrs(cstSkdByVvdVO.getPortBufHrs());
		
		return vslPortSkdVO;
	}
	

	
//	/**
//	 * Coastal History 를 남기기 위해 History DataSet 생성
//	 * 
//	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
//	 * @param List<VslPortSkdVO> insertVirtualPortVoList
//	 * @param List<VskVslPortSkdVO> updateNextPortVoList
//	 * @param String userId
//	 * @return List<VslSkdHisInVO>
//	 * @exception EventException
//	 */
//	private List<VslSkdHisInVO> makeHistoryDataSetByCoastal(CstSkdByVvdVO[] cstSkdByVvdVOs, List<VslPortSkdVO> insertVirtualPortVoList, List<VskVslPortSkdVO> updateNextPortVoList, String userId)throws EventException{
//		List<VslSkdHisInVO> vslSkdHisInVOs = new ArrayList<VslSkdHisInVO>();
//
//		try{
//			for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs){
//				VslSkdHisInVO vslSkdHisInVO = new VslSkdHisInVO();
//				
//				vslSkdHisInVO.setIbflag(cstSkdByVvdVO.getIbflag());
//				vslSkdHisInVO.setSkdCngStsCd(cstSkdByVvdVO.getSkdCngStsCd());
//				vslSkdHisInVO.setVslCd(cstSkdByVvdVO.getVslCd());
//				vslSkdHisInVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
//				vslSkdHisInVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
//				vslSkdHisInVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd());
//				vslSkdHisInVO.setVpsPortCd(cstSkdByVvdVO.getVpsPortCd());
//				vslSkdHisInVO.setClptIndSeq(cstSkdByVvdVO.getClptIndSeq());
//				vslSkdHisInVO.setYdCd(cstSkdByVvdVO.getVpsPortCd() + cstSkdByVvdVO.getTmlCd());
//				vslSkdHisInVO.setVpsEtaDt(cstSkdByVvdVO.getVpsEtaDt());
//				vslSkdHisInVO.setVpsEtbDt(cstSkdByVvdVO.getVpsEtbDt());
//				vslSkdHisInVO.setVpsEtdDt(cstSkdByVvdVO.getVpsEtdDt());
//				vslSkdHisInVO.setVslDlayRsnCd(cstSkdByVvdVO.getVslDlayRsnCd());
//				vslSkdHisInVO.setVslDlayRsnDesc(cstSkdByVvdVO.getVslDlayRsnDesc());
//				vslSkdHisInVO.setVslDlayRsnLocCd(cstSkdByVvdVO.getVslDlayRsnLocCd());
//				vslSkdHisInVO.setUsrId(userId);
//				vslSkdHisInVO.setNewClptIndSeq(cstSkdByVvdVO.getNewClptIndSeq());
//				vslSkdHisInVO.setTurnPortFlg(cstSkdByVvdVO.getTurnPortFlg());
//				vslSkdHisInVO.setTurnPortIndCd(cstSkdByVvdVO.getTurnPortIndCd());
//				vslSkdHisInVOs.add(vslSkdHisInVO);
//				
//				//Virtual Port History Setting.
//				if("Y".equals(cstSkdByVvdVO.getTurnPortFlg())){
//					VslSkdHisInVO virtualVslSkdHisInVO = new VslSkdHisInVO();
//					
//					virtualVslSkdHisInVO.setIbflag(cstSkdByVvdVO.getIbflag());
//					virtualVslSkdHisInVO.setSkdCngStsCd(cstSkdByVvdVO.getSkdCngStsCd());
//					virtualVslSkdHisInVO.setVslCd(cstSkdByVvdVO.getVslCd());
//					virtualVslSkdHisInVO.setSkdVoyNo(cstSkdByVvdVO.getTurnSkdVoyNo());
//					virtualVslSkdHisInVO.setSkdDirCd(cstSkdByVvdVO.getTurnSkdDirCd());
//					virtualVslSkdHisInVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd());
//					virtualVslSkdHisInVO.setVpsPortCd(cstSkdByVvdVO.getVpsPortCd());
//					virtualVslSkdHisInVO.setClptIndSeq(cstSkdByVvdVO.getTurnClptIndSeq());
//					virtualVslSkdHisInVO.setYdCd(cstSkdByVvdVO.getVpsPortCd() + cstSkdByVvdVO.getTmlCd());
//					virtualVslSkdHisInVO.setVpsEtaDt(cstSkdByVvdVO.getVpsEtaDt());
//					virtualVslSkdHisInVO.setVpsEtbDt(cstSkdByVvdVO.getVpsEtbDt());
//					virtualVslSkdHisInVO.setVpsEtdDt(cstSkdByVvdVO.getVpsEtdDt());
//					virtualVslSkdHisInVO.setVslDlayRsnCd(cstSkdByVvdVO.getVslDlayRsnCd());
//					virtualVslSkdHisInVO.setVslDlayRsnDesc(cstSkdByVvdVO.getVslDlayRsnDesc());
//					virtualVslSkdHisInVO.setVslDlayRsnLocCd(cstSkdByVvdVO.getVslDlayRsnLocCd());
//					virtualVslSkdHisInVO.setUsrId(userId);
//					
//					for(VslPortSkdVO vslPortSkdVO : insertVirtualPortVoList){
//						if(cstSkdByVvdVO.getVpsPortCd().equals(vslPortSkdVO.getVpsPortCd())
//								&& cstSkdByVvdVO.getNewClptIndSeq().equals(vslPortSkdVO.getTurnClptIndSeq())){
//							virtualVslSkdHisInVO.setNewClptIndSeq(vslPortSkdVO.getClptIndSeq());
//							virtualVslSkdHisInVO.setTurnPortFlg(vslPortSkdVO.getTurnPortFlg());
//							virtualVslSkdHisInVO.setTurnPortIndCd(vslPortSkdVO.getTurnPortIndCd());
//							break;
//						}
//					}
//					
//					vslSkdHisInVOs.add(virtualVslSkdHisInVO);
//				}
//				
//				//Next Port History Setting.
//				if(VSKGeneralUtil.isVirtualPort(cstSkdByVvdVO.getTurnPortIndCd())){
//					VslSkdHisInVO nxtVslSkdHisInVO = new VslSkdHisInVO();
//					
//					nxtVslSkdHisInVO.setIbflag("U");
//					nxtVslSkdHisInVO.setSkdCngStsCd(cstSkdByVvdVO.getSkdCngStsCd());
//					nxtVslSkdHisInVO.setVslCd(cstSkdByVvdVO.getVslCd());
//					nxtVslSkdHisInVO.setSkdVoyNo(cstSkdByVvdVO.getTurnSkdVoyNo());
//					nxtVslSkdHisInVO.setSkdDirCd(cstSkdByVvdVO.getTurnSkdDirCd());
//					nxtVslSkdHisInVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd());
//					nxtVslSkdHisInVO.setVpsPortCd(cstSkdByVvdVO.getVpsPortCd());
//					nxtVslSkdHisInVO.setClptIndSeq(cstSkdByVvdVO.getTurnClptIndSeq());
//					nxtVslSkdHisInVO.setYdCd(cstSkdByVvdVO.getVpsPortCd() + cstSkdByVvdVO.getTmlCd());
//					nxtVslSkdHisInVO.setVpsEtaDt(cstSkdByVvdVO.getVpsEtaDt());
//					nxtVslSkdHisInVO.setVpsEtbDt(cstSkdByVvdVO.getVpsEtbDt());
//					nxtVslSkdHisInVO.setVpsEtdDt(cstSkdByVvdVO.getVpsEtdDt());
//					nxtVslSkdHisInVO.setVslDlayRsnCd(cstSkdByVvdVO.getVslDlayRsnCd());
//					nxtVslSkdHisInVO.setVslDlayRsnDesc(cstSkdByVvdVO.getVslDlayRsnDesc());
//					nxtVslSkdHisInVO.setVslDlayRsnLocCd(cstSkdByVvdVO.getVslDlayRsnLocCd());
//					nxtVslSkdHisInVO.setUsrId(userId);
//					
//					for(VskVslPortSkdVO vskVslPortSkdVO : updateNextPortVoList){
//						if(cstSkdByVvdVO.getVpsPortCd().equals(vskVslPortSkdVO.getVpsPortCd())
//								&& cstSkdByVvdVO.getNewClptIndSeq().equals(vskVslPortSkdVO.getTurnClptIndSeq())){
//							nxtVslSkdHisInVO.setNewClptIndSeq(vskVslPortSkdVO.getClptIndSeq());
//							nxtVslSkdHisInVO.setTurnPortFlg(vskVslPortSkdVO.getTurnPortFlg());
//							nxtVslSkdHisInVO.setTurnPortIndCd(vskVslPortSkdVO.getTurnPortIndCd());
//							break;
//						}
//					}
//					
//					vslSkdHisInVOs.add(nxtVslSkdHisInVO);
//				}
//			}
//		}catch(Exception ex){
//			throw new EventException(new ErrorHandler("VSK10039").getMessage());
//		}
//		
//		return vslSkdHisInVOs;
//	}
	
	/**
	 * Coastal Schedule 의 Virtual 의 Turn 정보를 변경한다(Next Port 정보).
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param String clptIndSeq
	 * @param String turnClptIndSeq
	 * @param int vitualSeq
	 * @param String userId
	 * @return VskVslPortSkdVO
	 * @exception EventException
	 */
	private VskVslPortSkdVO makeNextPortDataSet(CstSkdByVvdVO cstSkdByVvdVO, String clptIndSeq, String turnClptIndSeq, int vitualSeq, String userId) throws EventException{
		VskVslPortSkdVO nxtVskVslPortSkdVO = new VskVslPortSkdVO();
		
		try{
			nxtVskVslPortSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
			nxtVskVslPortSkdVO.setSkdVoyNo(cstSkdByVvdVO.getTurnSkdVoyNo());
			nxtVskVslPortSkdVO.setSkdDirCd(cstSkdByVvdVO.getTurnSkdDirCd());
			nxtVskVslPortSkdVO.setVpsPortCd(cstSkdByVvdVO.getVpsPortCd());
			nxtVskVslPortSkdVO.setClptIndSeq(turnClptIndSeq);
			nxtVskVslPortSkdVO.setYdCd(cstSkdByVvdVO.getVpsPortCd() + cstSkdByVvdVO.getTmlCd());
			nxtVskVslPortSkdVO.setVpsEtaDt(cstSkdByVvdVO.getVpsEtaDt());
			nxtVskVslPortSkdVO.setVpsEtbDt(cstSkdByVvdVO.getVpsEtbDt());
			nxtVskVslPortSkdVO.setVpsEtdDt(cstSkdByVvdVO.getVpsEtdDt());
			nxtVskVslPortSkdVO.setVslDlayRsnCd(cstSkdByVvdVO.getVslDlayRsnCd());
			nxtVskVslPortSkdVO.setVslDlayRsnDesc(cstSkdByVvdVO.getVslDlayRsnDesc());
			nxtVskVslPortSkdVO.setVslDlayRsnLocCd(cstSkdByVvdVO.getVslDlayRsnLocCd());

			if("D".equals(cstSkdByVvdVO.getIbflag())){
				//삭제 건은 Next Port 의 Turn 정보를 제거한다.
				nxtVskVslPortSkdVO.setTurnPortFlg("N");
				nxtVskVslPortSkdVO.setTurnPortIndCd("N");
				nxtVskVslPortSkdVO.setTurnSkdVoyNo("");
				nxtVskVslPortSkdVO.setTurnSkdDirCd("");
				nxtVskVslPortSkdVO.setTurnClptIndSeq("");
			}else{
				String sTurnPortIndCd = "Y";
				nxtVskVslPortSkdVO.setTurnPortFlg("Y");
				if(vitualSeq == 1){
					VvdVO paramVO = new VvdVO();
					paramVO.setVslCd(cstSkdByVvdVO.getVslCd());
					paramVO.setSkdVoyNo(cstSkdByVvdVO.getTurnSkdVoyNo());
					paramVO.setSkdDirCd(cstSkdByVvdVO.getTurnSkdDirCd());
					// 1번째 Lane 의 1번째 Port 이면 'N' 그 외 Turnning 은 'Y'
					List<MdmVslSvcLaneDirVO> list = dbDao.searchSvcLaneDirByVvd(paramVO);
					if(list != null && list.size() > 0){
						for(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO : list){
							if(cstSkdByVvdVO.getTurnSkdDirCd().equals(mdmVslSvcLaneDirVO.getVslSlanDirCd())){
								if("1".equals(mdmVslSvcLaneDirVO.getVslSlanDirSeq())){
									sTurnPortIndCd = "N";
								}
							}
						}
					}
				}
				nxtVskVslPortSkdVO.setTurnPortIndCd(sTurnPortIndCd);
				nxtVskVslPortSkdVO.setTurnSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
				nxtVskVslPortSkdVO.setTurnSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
				nxtVskVslPortSkdVO.setTurnClptIndSeq(clptIndSeq);
			}

			nxtVskVslPortSkdVO.setAutoSkdCngFlg(cstSkdByVvdVO.getAutoSkdCngFlg());
			nxtVskVslPortSkdVO.setLnkSpd(cstSkdByVvdVO.getLnkSpd());
			nxtVskVslPortSkdVO.setSeaBufHrs(cstSkdByVvdVO.getSeaBufHrs());
			nxtVskVslPortSkdVO.setPortBufHrs(cstSkdByVvdVO.getPortBufHrs());
			nxtVskVslPortSkdVO.setTztmHrs(cstSkdByVvdVO.getTztmHrs());
			nxtVskVslPortSkdVO.setPortWrkHrs(cstSkdByVvdVO.getActWrkHrs());
			nxtVskVslPortSkdVO.setLnkDist(cstSkdByVvdVO.getLnkDist());
			nxtVskVslPortSkdVO.setMnvrOutHrs(cstSkdByVvdVO.getMnvrOutHrs());
			nxtVskVslPortSkdVO.setMnvrInHrs(cstSkdByVvdVO.getMnvrInHrs());
			nxtVskVslPortSkdVO.setUpdUsrId(userId);
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다. BA 담당자에게 문의하세요.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return nxtVskVslPortSkdVO;
	}
	
//	/**
//	 * partVvdList 의 VVD 내용이 baseVvdList 에 있는지 검사하여 없으면 baseVvdList 에 VVD 정보를 담는다.
//	 * 
//	 * @param List<VvdVO> baseVvdList
//	 * @param Object obj
//	 * @param String ibFlg
//	 * @return List<VvdVO>
//	 * @exception EventException 
//	 */
//	@SuppressWarnings("unchecked")
//	private List<VvdVO> setTransObjectByVvd(List<VvdVO> baseVvdList, Object obj, String ibFlg) throws EventException{
//		try{
//			List<Object> objList = (List<Object>)obj;
//			
//			if(objList != null && objList.size() > 0){
//				for(Object voObject : objList){
//					VvdVO vvdVO = new VvdVO();
//					
//					if(voObject.getClass().isInstance(new VskVslSkdVO())){
//						VskVslSkdVO vskVslSkdVO = (VskVslSkdVO)voObject;
//						vvdVO.setIbflag(ibFlg);
//						vvdVO.setVslCd(vskVslSkdVO.getVslCd());
//						vvdVO.setSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
//						vvdVO.setSkdDirCd(vskVslSkdVO.getSkdDirCd());
//						vvdVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
//					}else if(voObject.getClass().isInstance(new VskVslPortSkdVO())){
//						VskVslPortSkdVO vskVslPortSkdVO = (VskVslPortSkdVO)voObject;
//						vvdVO.setIbflag(ibFlg);
//						vvdVO.setVslCd(vskVslPortSkdVO.getVslCd());
//						vvdVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
//						vvdVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
//						vvdVO.setVslSlanCd(vskVslPortSkdVO.getSlanCd());
//					}else if(voObject.getClass().isInstance(new VslPortSkdVO())){
//						VslPortSkdVO vslPortSkdVO = (VslPortSkdVO)voObject;
//						vvdVO.setIbflag(ibFlg);
//						vvdVO.setVslCd(vslPortSkdVO.getVslCd());
//						vvdVO.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
//						vvdVO.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
//						vvdVO.setVslSlanCd(vslPortSkdVO.getSlanCd());
//					}else{
//						/*
//						 * 위에 정의된 Class Type 이 존재하지 않을 경우 에러 처리
//						 */
//						throw new EventException(new ErrorHandler("VSK10039").getMessage());
//					}
//					
//					if(!isCheckObjectByVvd(baseVvdList, vvdVO)){
//						baseVvdList.add(vvdVO);
//					}
//				}
//			}
//		}catch(EventException ex){
//			throw new EventException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			throw new EventException(new ErrorHandler("VSK10039").getMessage());
//		}
//		
//		return baseVvdList;
//	}
	
	/**
	 * Yard Ind Seq 를 생성한다.
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param int currSeq
	 * @return int
	 */
	private int makeCallYardSeq(CstSkdByVvdVO[] cstSkdByVvdVOs, int currSeq){
		int callYdIndSeq = 0;
		
		String ydCd = cstSkdByVvdVOs[currSeq].getVpsPortCd() + cstSkdByVvdVOs[currSeq].getTmlCd();
		String preVvd = "";		// 이전 VVD
		String curVvd = "";		// 현재 VVD
		for(int j=0; j<=currSeq; j++){
			//동일 VVD 내의 Yard 수를 알기 위해...
			curVvd = cstSkdByVvdVOs[j].getVslCd() + cstSkdByVvdVOs[j].getSkdVoyNo() + cstSkdByVvdVOs[j].getSkdDirCd();
			
			if(!preVvd.equals(curVvd)){
				callYdIndSeq = 0;
				preVvd = curVvd;
			}
			
			if(ydCd.equals(cstSkdByVvdVOs[j].getVpsPortCd() + cstSkdByVvdVOs[j].getTmlCd())){
				// 삭제 할 건은 COUNT 하지 않는다.
				if(!"D".equals(cstSkdByVvdVOs[j].getIbflag())){
					callYdIndSeq++;
				}
			}
		}
		
		return callYdIndSeq;
	}
	
	/**
	 * Tunning Port 상태를 Check.
	 * 
	 * @param String vslCd
	 * @param String turnSkdVoyNo
	 * @param String turnSkdDirCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @exception EventException
	 */
	private void checkVskVslPortSkd(String vslCd, String skdVoyNo, String skdDirCd, String turnSkdVoyNo, String turnSkdDirCd) throws EventException {
		try{
			// Turnning Port 존재여부 체크
			VslPortSkdVO paramVO = new VslPortSkdVO();
			paramVO.setVslCd(vslCd);
			paramVO.setSkdVoyNo(turnSkdVoyNo);
			paramVO.setSkdDirCd(turnSkdDirCd);
			paramVO.setTurnSkdVoyNo(skdVoyNo);
			paramVO.setTurnSkdDirCd(skdDirCd);
			VvdCheckVO vvdCheckVO = dbDao.checkVskVslPortSkd(paramVO);
			
			if(vvdCheckVO == null || vvdCheckVO.getCnt() == null || "".equals(vvdCheckVO.getCnt())){
				/*
				 * 해당 Turnning Port 가 없을 경우 에러 발생.
				 * MSG - 해당 Port가 Turning Port일 경우에 연결되는 Virtual Port 정보가 제대로 입력되어 있지 않을 경우
				 */
				throw new EventException(new ErrorHandler("VSK10013").getMessage());
			}else if(Integer.parseInt(vvdCheckVO.getCnt()) < 1){
				/*
				 * 해당 Turnning Port 가 없을 경우 에러 발생.
				 * MSG - 해당 Port가 Turning Port일 경우에 연결되는 Virtual Port 정보가 제대로 입력되어 있지 않을 경우
				 */
				throw new EventException(new ErrorHandler("VSK10013").getMessage());
			}
			
			if(Integer.parseInt(vvdCheckVO.getVrtCnt()) > 0){
				/*
				 * 생성하려는 Virtual Port에 다른 Turnning Port 가 연결 되어 있을 경우 에러 발생.
				 * MSG - The inputted turn VVD ({?msg1}) was connected with other virtual  VVD( {?msg2}).\n Please check again!
				 */
				String[] errMsgs = new String[]{vslCd+turnSkdVoyNo+turnSkdDirCd, vvdCheckVO.getVvd()};
				throw new EventException(new ErrorHandler("VSK10001", errMsgs).getMessage());
			}
		} catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * 넘겨받은 List의 Turnning Port의 수를 반환한다.
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @return int
	 */
	private int curTurnPortCnt(List<VskVslPortSkdVO> vskVslPortSkdVOs){
		int turnPortCnt = 0;
		if(vskVslPortSkdVOs != null && vskVslPortSkdVOs.size()>0){
			for(VskVslPortSkdVO vskVslPortSkdVO : vskVslPortSkdVOs){
				if("Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
					turnPortCnt++;
				}
			}
		}
		return turnPortCnt;
	}
	
	/**
	 * 각 인자를 받아 turn_port_ind_cd 를 판단한다.
	 * 
	 * @param String tPortIndCd
	 * @param String tPortFlg
	 * @param String portRotnSeq
	 * @param String vslSlanCd
	 * @param String vslSlanDirCd
	 * @param String clptSeq
	 * @return String
	 * @exception EventException
	 */
	private String turnPortIndCdControl(String tPortIndCd, String tPortFlg, String portRotnSeq, String vslSlanCd, String vslSlanDirCd, String clptSeq) throws EventException {
		String turnPortIndCd = "";
		
		try{
			if(VSKGeneralUtil.isNotNull(tPortIndCd)){
				if(!VSKGeneralUtil.isVirtualPort(tPortIndCd)){
					if("Y".equals(tPortFlg)){
						if("1".equals(portRotnSeq) && "1".equals(clptSeq)){
							turnPortIndCd = "N";
						}else{
							turnPortIndCd = "Y";
						}
					}else{
						turnPortIndCd = "N";
					}
				}else{
					turnPortIndCd = tPortIndCd;
				}
			}else{
				//새로 입력된 값이면 turnPortIndCd가 Null 이므로.
				if("Y".equals(tPortFlg)){
					if(VSKGeneralUtil.isNotNull(portRotnSeq)){
						if("1".equals(portRotnSeq) && "1".equals(clptSeq)){
							turnPortIndCd = "N";
						}else{
							turnPortIndCd = "Y";
						}
					}else{
						// P/F 를 사용하지 않고 수기로 입력했을 경우 portRotnSeq 이 NULL 이므로.
						MdmVslSvcLaneDirVO paramVO = new MdmVslSvcLaneDirVO();
						paramVO.setVslSlanCd(vslSlanCd);
						paramVO.setVslSlanDirCd(vslSlanDirCd);
						paramVO.setDeltFlg("N");
						
						String dirSeq = dbDao.searchDirectionSeq(paramVO);
						if("1".equals(dirSeq)){
							turnPortIndCd = "N";
						}else{
							turnPortIndCd = "Y";
						}
					}
				}else{
					turnPortIndCd = "N";
				}
			}
		} catch (DAOException ex) {
			/*
			 * 조회 서비스 실행중 오류가 발생하였을 경우
			 * MSG - An unknown error has occurred while retriving data. Please contact system administrator.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return turnPortIndCd;
	}
	
	/**
	 * Virtual Port Turn Indicator Code 판단하여 리턴한다.
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param VskVslPortSkdVO virtualPortVO
	 * @param String turnPortIndCd
	 * @return String
	 */
	private String virtualTurnPortIndCdControl(CstSkdByVvdVO cstSkdByVvdVO, String slanCd, String turnPortIndCd) throws EventException{
		/*
		 * [Virtual Port Turn Indicator Code 생성 조건]
		 * 
		 * LANE이 다르면 'V'
		 * 
		 * LANE이 같고
		 * pf_seq=1 and voy1!=voy2 and dir1!= dir2 => 'F'
		 * voy1!=voy2 and dir1!= dir2 => 'V'
		 * voy1!=voy2 and dir1== dir2 => 'V'
		 * voy1==voy2 and dir1!= dir2 => 'D'
		 */
		String virtualTurnPortIndCd = "";
		try{
			if(!cstSkdByVvdVO.getVslSlanCd().equals(slanCd)){
				virtualTurnPortIndCd = "V";
			}else{
				if("Y".equals(cstSkdByVvdVO.getTurnPortFlg()) && "N".equals(turnPortIndCd)){
					virtualTurnPortIndCd = "F";
				} else if (!cstSkdByVvdVO.getSkdVoyNo().equals(cstSkdByVvdVO.getTurnSkdVoyNo())){
					virtualTurnPortIndCd = "V";
				} else if(!cstSkdByVvdVO.getSkdDirCd().equals(cstSkdByVvdVO.getTurnSkdDirCd())){
					virtualTurnPortIndCd = "D";
				}
			}
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return virtualTurnPortIndCd;
	}
	
//	/**
//	 * List<VvdVO> list 에 VvdVO vvdVO 가 존재하는지 검사.
//	 * @param list List<VvdVO>
//	 * @param vvdVO VvdVO
//	 * @return boolean
//	 */
//	private boolean isCheckObjectByVvd(List<VvdVO> list, VvdVO vvdVO){
//		boolean rtnFlg = false;
//		
//		for(int i=0; i<list.size(); i++){
//			VvdVO tmpVO = list.get(i);
//			if(tmpVO.getVslCd().equals(vvdVO.getVslCd())
//					&& tmpVO.getSkdVoyNo().equals(vvdVO.getSkdVoyNo())
//					&& tmpVO.getSkdDirCd().equals(vvdVO.getSkdDirCd())){
//				rtnFlg = true;
//				break;
//			}
//		}
//		
//		return rtnFlg;
//	}
	
	/**
	 * turn_clpt_ind_seq 를 생성한다.
	 * 
	 * @param int turnClptIndSeq
	 * @param String newClptIndSeq
	 * @return int
	 * @exception EventException
	 */
	private int getParsingTurnClptIndSeq(int turnClptIndSeq, String newClptIndSeq) throws EventException {
		try{
			turnClptIndSeq = turnClptIndSeq + Integer.parseInt(newClptIndSeq);
			return turnClptIndSeq;
		}catch(NumberFormatException ne){
			throw new EventException(new ErrorHandler(ne).getMessage(), ne);
		}		
	}
	
//	/**
//	 * History 대상 건을 찾아 해당 테이블에 저장한다.
//	 * 
//	 * @param List<VslSkdHisInVO> vslSkdHisInVOs
//	 * @return VslSkdChgStsGRPVO
//	 * @exception EventException
//	 */
//	private VslSkdChgStsGRPVO manageVslSkdChgSts(List<VslSkdHisInVO> vslSkdHisInVOs) throws EventException {
//		//return Group VO
//		VslSkdChgStsGRPVO vslSkdChgStsGRPVO = new VslSkdChgStsGRPVO();
//		//return [Booking] VO List
//		List<VslSkdCngNoticeVO> bkgNoticeList = new ArrayList<VslSkdCngNoticeVO>();
//		List<VslSkdCngUpdateVO> bkgUpdateList = new ArrayList<VslSkdCngUpdateVO>();
//		
//		//return [COP] VO List
//		List<SceActRcvIfVO> copNoticeList = new ArrayList<SceActRcvIfVO>();
//		
//		List<VskVslSkdHisVO> historyList = new ArrayList<VskVslSkdHisVO>();
//		List<VskVslSkdVO> masterVOList = new ArrayList<VskVslSkdVO>();		// VSK_VSL_SKD 정보
//		
//		try{
//			if(vslSkdHisInVOs != null && vslSkdHisInVOs.size() > 0){
//				List<CstSkdByVvdVO> orgPortVoList = null;		//화면에서 변경되기 전의 Port List
//				
//				String preVvdCd = "";	//이전 VVD
//				String curVvdCd = "";	//현재 VVD
//				
//				String vslCd = "";
//				String skdVoyNo = "";
//				String skdDirCd = "";
//				String vpsPortCd = "";
//				for(VslSkdHisInVO vslSkdHisInVO : vslSkdHisInVOs){
//					//VVD 코드
//					vslCd = vslSkdHisInVO.getVslCd();
//					skdVoyNo = vslSkdHisInVO.getSkdVoyNo();
//					skdDirCd = vslSkdHisInVO.getSkdDirCd();
//					vpsPortCd = vslSkdHisInVO.getVpsPortCd();
//					
//					/* 
//					 * ###################################################################################
//					 * Booking 정보가 있을 경우만 아래 작업을 한다.
//					 * 
//					 * History를 남긴다.
//					 * BKG 에 변경내역 전송.
//					 * SCE - COP 에 변경내역 전송.
//					 * ################################################################################### 
//					 */
//					VslPortSkdVO paramVO = new VslPortSkdVO();
//					paramVO.setVslCd(vslCd);
//					paramVO.setSkdVoyNo(skdVoyNo);
//					paramVO.setSkdDirCd(skdDirCd);
//					paramVO.setVpsPortCd(vpsPortCd);
//					paramVO.setClptIndSeq(vslSkdHisInVO.getClptIndSeq());
//					VslPortSkdVO bkgCheckVO = null;
//					
//					if(!VSKGeneralUtil.isNull(vslSkdHisInVO.getClptIndSeq())){
//						bkgCheckVO = dbDao.checkVslSkdByRowID(paramVO);			//Booking 정보가 있는지 조회.
//					}
//					
//					if(bkgCheckVO != null && !"".equals(bkgCheckVO.getVpsPortCd())){
//						curVvdCd = vslCd + skdVoyNo + skdDirCd;
//						
//						// VVD 가 여러 건일 수 있으므로.
//						if(!preVvdCd.equals(curVvdCd)){
//							preVvdCd = curVvdCd;
//							
//							// 해당 VVD의 변경되기전의 Port 정보를 조회한다.
//							CstSkdByVvdVO orgParamVO = new CstSkdByVvdVO(); 
//							orgParamVO.setVslCd(vslCd);
//							orgParamVO.setSkdVoyNo(skdVoyNo);
//							orgParamVO.setSkdDirCd(skdDirCd);
//							orgPortVoList = dbDao.searchCstSkdByVvd(orgParamVO);
//							
//							// Master 정보 변경 시 History 남기기 위해(Lane, VVD 삭제)
//							boolean mstFlg = true;
//							for(VskVslSkdVO mstVO : masterVOList){
//								if(vslCd.equals(mstVO.getVslCd()) && skdVoyNo.equals(mstVO.getSkdVoyNo()) && skdDirCd.equals(mstVO.getSkdDirCd())){
//									mstFlg = false;
//									break;
//								}
//							}
//							// 기존 Master 정보에 없을 경우에만 ADD.
//							if(mstFlg){
//								VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
//								vskVslSkdVO.setVslCd(vslCd);
//								vskVslSkdVO.setSkdVoyNo(skdVoyNo);
//								vskVslSkdVO.setSkdDirCd(skdDirCd);
//								vskVslSkdVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//								vskVslSkdVO.setUpdUsrId(vslSkdHisInVO.getUsrId());
//								
//								masterVOList.add(vskVslSkdVO);
//							}
//						}
//						
//						CstSkdByVvdVO orgPortVO = null;
//						
//						//해당 Skip 된 변경 전의 Port 정보를 찾는다.
//						if(orgPortVoList != null && orgPortVoList.size() > 0){
//							for(CstSkdByVvdVO cstSkdByVvdVO : orgPortVoList){
//								if(vslSkdHisInVO.getVpsPortCd().equals(cstSkdByVvdVO.getVpsPortCd())
//										&& vslSkdHisInVO.getNewClptIndSeq().equals(cstSkdByVvdVO.getClptIndSeq())){
//									orgPortVO = cstSkdByVvdVO;
//									break;
//								}
//							}
//						}
//		       
//						/*
//						 * VskdCngTpCd - 변경된 이유를 CODE화 하여 표시.
//						 * 'S' : Port Skip
//						 * 'O' : Phase Out
//						 * 'V' : VVD 삭제
//						 * 'T' : PORT 삭제 (Virtual 이 아닌 Port)
//						 * 'D' : PORT 삭제 (Virtual Port)
//						 * 'L' : Lane 변경
//						 * 'E' : ETA, ETB, ETD
//						 * 'Y' : YARD 변경
//						 * 'P' : PORT의 CALLING SEQUENCE 변경
//						 */
//						if(orgPortVO != null){
//							//***** 'S' : Port Skip() *****
//							//기존 데이타가 Skip 이 아니었고
//							if(!"S".equals(orgPortVO.getSkdCngStsCd())){
//								//새로 입력된 데이타가 Skip 이면
//								if("S".equals(vslSkdHisInVO.getSkdCngStsCd())){
//									VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();
//									VslSkdCngNoticeVO vslSkdCngNoticeVO = new VslSkdCngNoticeVO();
//								
//									/*
//									 * VSKD_TP_CD - Vessel Schedule에서 변경했는지, Vessel Port Schedule에서 변경된 내용인지를 구분.
//									 * 
//									 * M : Vessel Schedule
//									 * P : Vessel Port Schedule (Default)
//									 */
//									vskVslSkdHisVO.setVskdTpCd("P");
//									vskVslSkdHisVO.setBfrVslCd(orgPortVO.getVslCd());
//									vskVslSkdHisVO.setBfrSkdVoyNo(orgPortVO.getSkdVoyNo());
//									vskVslSkdHisVO.setBfrSkdDirCd(orgPortVO.getSkdDirCd());
//									vskVslSkdHisVO.setBfrVslSlanCd(orgPortVO.getVslSlanCd());
//									vskVslSkdHisVO.setBfrVpsEtaDt(orgPortVO.getVpsEtaDt());
//									vskVslSkdHisVO.setBfrVpsEtbDt(orgPortVO.getVpsEtbDt());
//									vskVslSkdHisVO.setBfrVpsEtdDt(orgPortVO.getVpsEtdDt());
//									vskVslSkdHisVO.setBfrVpsPortCd(orgPortVO.getVpsPortCd());
//									vskVslSkdHisVO.setBfrClptIndSeq(orgPortVO.getClptIndSeq());
//									vskVslSkdHisVO.setBfrYdCd(orgPortVO.getYdCd());
//									vskVslSkdHisVO.setVskdCngTpCd("S");					//변경된 이유를 CODE화 하여 표시 - 'S' : Port Skip()
//									vskVslSkdHisVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//									vskVslSkdHisVO.setUpdUsrId(vslSkdHisInVO.getUsrId());
//									
//									historyList.add(vskVslSkdHisVO);
//									
//									vslSkdCngNoticeVO.setVslCd(vslCd);
//									vslSkdCngNoticeVO.setSkdVoyNo(skdVoyNo);
//									vslSkdCngNoticeVO.setSkdDirCd(skdDirCd);
//									vslSkdCngNoticeVO.setPortCd(vslSkdHisInVO.getVpsPortCd());
//									vslSkdCngNoticeVO.setClptIndSeq(vslSkdHisInVO.getClptIndSeq());
//									vslSkdCngNoticeVO.setYdCd(vslSkdHisInVO.getYdCd());
//									vslSkdCngNoticeVO.setTypeCd("S");
//									vslSkdCngNoticeVO.setRemark("Skip");
//									
//									bkgNoticeList.add(vslSkdCngNoticeVO);
//								}
//							}
//						
//							//***** 'O' : Phase Out *****
//							if("O".equals(vslSkdHisInVO.getSkdCngStsCd())){
//								VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();
//								VslSkdCngNoticeVO vslSkdCngNoticeVO = new VslSkdCngNoticeVO();
//								
//								// history...
//								vskVslSkdHisVO.setVskdTpCd("P");
//								vskVslSkdHisVO.setBfrVslCd(orgPortVO.getVslCd());
//								vskVslSkdHisVO.setBfrSkdVoyNo(orgPortVO.getSkdVoyNo());
//								vskVslSkdHisVO.setBfrSkdDirCd(orgPortVO.getSkdDirCd());
//								vskVslSkdHisVO.setBfrVslSlanCd(orgPortVO.getVslSlanCd());
//								vskVslSkdHisVO.setBfrVpsEtaDt(orgPortVO.getVpsEtaDt());
//								vskVslSkdHisVO.setBfrVpsEtbDt(orgPortVO.getVpsEtbDt());
//								vskVslSkdHisVO.setBfrVpsEtdDt(orgPortVO.getVpsEtdDt());
//								vskVslSkdHisVO.setBfrVpsPortCd(orgPortVO.getVpsPortCd());
//								vskVslSkdHisVO.setBfrClptIndSeq(orgPortVO.getClptIndSeq());
//								vskVslSkdHisVO.setBfrYdCd(orgPortVO.getYdCd());
//								vskVslSkdHisVO.setAftVslCd(vslSkdHisInVO.getCngVslCd());
//								vskVslSkdHisVO.setAftSkdVoyNo(vslSkdHisInVO.getCngSkdVoyNo());
//								vskVslSkdHisVO.setAftSkdDirCd(vslSkdHisInVO.getCngSkdDirCd());
//								vskVslSkdHisVO.setAftVslSlanCd(vslSkdHisInVO.getCngLaneCd());
//								vskVslSkdHisVO.setDiffRmk("Phase Out");
//								vskVslSkdHisVO.setVskdCngTpCd("O");					//변경된 이유를 CODE화 하여 표시 - 'O' : Phase Out
//								vskVslSkdHisVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//								vskVslSkdHisVO.setUpdUsrId(vslSkdHisInVO.getUsrId());
//								
//								historyList.add(vskVslSkdHisVO);
//								
//								// booking...
//								vslSkdCngNoticeVO.setVslCd(vslCd);
//								vslSkdCngNoticeVO.setSkdVoyNo(skdVoyNo);
//								vslSkdCngNoticeVO.setSkdDirCd(skdDirCd);
//								vslSkdCngNoticeVO.setPortCd(vslSkdHisInVO.getVpsPortCd());
//								vslSkdCngNoticeVO.setClptIndSeq(vslSkdHisInVO.getClptIndSeq());
//								vslSkdCngNoticeVO.setYdCd(vslSkdHisInVO.getYdCd());
//								vslSkdCngNoticeVO.setTypeCd("O");
//								vslSkdCngNoticeVO.setRemark("Phase Out");
//								
//								bkgNoticeList.add(vslSkdCngNoticeVO);
//							}
//							
//							//***** 'T' : Port 삭제 *****
//							if("D".equals(vslSkdHisInVO.getIbflag())){
//								VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();
//								VslSkdCngNoticeVO vslSkdCngNoticeVO = new VslSkdCngNoticeVO();
//								
//								String vskdCngTpCd = "T";
//								String diffRmk = "Port Delete";
//								if(VSKGeneralUtil.isVirtualPort(vslSkdHisInVO.getTurnPortIndCd())){
//									vskdCngTpCd = "D";	// Virtual Port 삭제인 경우 Code 를 구분
//									diffRmk = "Virtual Port Delete";
//								}
//								
//								// history...
//								vskVslSkdHisVO.setVskdTpCd("P");
//								vskVslSkdHisVO.setBfrVslCd(orgPortVO.getVslCd());
//								vskVslSkdHisVO.setBfrSkdVoyNo(orgPortVO.getSkdVoyNo());
//								vskVslSkdHisVO.setBfrSkdDirCd(orgPortVO.getSkdDirCd());
//								vskVslSkdHisVO.setBfrVslSlanCd(orgPortVO.getVslSlanCd());
//								vskVslSkdHisVO.setBfrVpsEtaDt(orgPortVO.getVpsEtaDt());
//								vskVslSkdHisVO.setBfrVpsEtbDt(orgPortVO.getVpsEtbDt());
//								vskVslSkdHisVO.setBfrVpsEtdDt(orgPortVO.getVpsEtdDt());
//								vskVslSkdHisVO.setBfrVpsPortCd(orgPortVO.getVpsPortCd());
//								vskVslSkdHisVO.setBfrClptIndSeq(orgPortVO.getClptIndSeq());
//								vskVslSkdHisVO.setBfrYdCd(orgPortVO.getYdCd());
//								vskVslSkdHisVO.setAftVslCd(vslSkdHisInVO.getCngVslCd());
//								vskVslSkdHisVO.setAftSkdVoyNo(vslSkdHisInVO.getCngSkdVoyNo());
//								vskVslSkdHisVO.setAftSkdDirCd(vslSkdHisInVO.getCngSkdDirCd());
//								vskVslSkdHisVO.setAftVslSlanCd(vslSkdHisInVO.getCngLaneCd());
//								vskVslSkdHisVO.setDiffRmk(diffRmk);
//								vskVslSkdHisVO.setVskdCngTpCd(vskdCngTpCd);					//변경된 이유를 CODE화 하여 표시 - 'T' : Port Delete
//								vskVslSkdHisVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//								vskVslSkdHisVO.setUpdUsrId(vslSkdHisInVO.getUsrId());
//								
//								historyList.add(vskVslSkdHisVO);
//								
//								// booking...
//								vslSkdCngNoticeVO.setVslCd(vslCd);
//								vslSkdCngNoticeVO.setSkdVoyNo(skdVoyNo);
//								vslSkdCngNoticeVO.setSkdDirCd(skdDirCd);
//								vslSkdCngNoticeVO.setPortCd(vslSkdHisInVO.getVpsPortCd());
//								vslSkdCngNoticeVO.setClptIndSeq(vslSkdHisInVO.getClptIndSeq());
//								vslSkdCngNoticeVO.setYdCd(vslSkdHisInVO.getYdCd());
//								vslSkdCngNoticeVO.setTypeCd(vskdCngTpCd);
//								vslSkdCngNoticeVO.setRemark(diffRmk);
//								
//								bkgNoticeList.add(vslSkdCngNoticeVO);
//							}
//							else {
//								//***** 'E' : ETA, ETB, ETD *****
//								if(
//										((!vslSkdHisInVO.getVpsEtaDt().equals(orgPortVO.getVpsEtaDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtaDt())))
//										|| ((!vslSkdHisInVO.getVpsEtbDt().equals(orgPortVO.getVpsEtbDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtbDt())))
//										|| ((!vslSkdHisInVO.getVpsEtdDt().equals(orgPortVO.getVpsEtdDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtdDt())))
//								){
//									VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();
//									
//									vskVslSkdHisVO.setVskdTpCd("P");
//									vskVslSkdHisVO.setBfrVslCd(orgPortVO.getVslCd());
//									vskVslSkdHisVO.setBfrSkdVoyNo(orgPortVO.getSkdVoyNo());
//									vskVslSkdHisVO.setBfrSkdDirCd(orgPortVO.getSkdDirCd());
//									vskVslSkdHisVO.setBfrVslSlanCd(orgPortVO.getVslSlanCd());
//									vskVslSkdHisVO.setBfrVpsEtaDt(orgPortVO.getVpsEtaDt());
//									vskVslSkdHisVO.setBfrVpsEtbDt(orgPortVO.getVpsEtbDt());
//									vskVslSkdHisVO.setBfrVpsEtdDt(orgPortVO.getVpsEtdDt());
//									vskVslSkdHisVO.setBfrVpsPortCd(orgPortVO.getVpsPortCd());
//									vskVslSkdHisVO.setBfrClptIndSeq(orgPortVO.getClptIndSeq());
//									vskVslSkdHisVO.setBfrYdCd(orgPortVO.getYdCd());
//									vskVslSkdHisVO.setAftVslCd(vslSkdHisInVO.getVslCd());
//									vskVslSkdHisVO.setAftSkdVoyNo(vslSkdHisInVO.getSkdVoyNo());
//									vskVslSkdHisVO.setAftSkdDirCd(vslSkdHisInVO.getSkdDirCd());
//									vskVslSkdHisVO.setAftVpsEtaDt(vslSkdHisInVO.getVpsEtaDt());
//									vskVslSkdHisVO.setAftVpsEtbDt(vslSkdHisInVO.getVpsEtbDt());
//									vskVslSkdHisVO.setAftVpsEtdDt(vslSkdHisInVO.getVpsEtdDt());
//									vskVslSkdHisVO.setVskdCngTpCd("E");					//변경된 이유를 CODE화 하여 표시 - 'E' : ETA, ETB, ETD
//									vskVslSkdHisVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//									vskVslSkdHisVO.setUpdUsrId(vslSkdHisInVO.getUsrId());
//									
//									historyList.add(vskVslSkdHisVO);
//									
//									// cop...
//									/*
//									 *  IF( UPDATING ) THEN 일때 Act Rcv Dt
//									 *  1. ATA가 변경된 경우 "21"
//									 *  2. ATB가 변경된 경우 "22"
//									 *  3. ATD가 변경된 경우 "23"
//									 *  4. ETA가 변경된 경우 "24"
//									 *  5. ETB가 변경된 경우 "25"
//									 *  6. ETD가 변경된 경우 "26"
//									 *  7. YD가 변경된 경우   "27"
//									 */
//									if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtaDt())){
//										if(!vslSkdHisInVO.getVpsEtaDt().equals(orgPortVO.getVpsEtaDt())){
//											SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
//											sceActRcvIfVO.setActRcvTpCd("24");
//											sceActRcvIfVO.setActDt(vslSkdHisInVO.getVpsEtaDt());
//											sceActRcvIfVO.setNodCd(vslSkdHisInVO.getYdCd());
//											sceActRcvIfVO.setVslCd(vslCd);
//											sceActRcvIfVO.setSkdVoyNo(skdVoyNo);
//											sceActRcvIfVO.setSkdDirCd(skdDirCd);
//											sceActRcvIfVO.setVpsPortCd(vslSkdHisInVO.getVpsPortCd());
//											sceActRcvIfVO.setClptIndSeq(vslSkdHisInVO.getClptIndSeq());
//											sceActRcvIfVO.setVslDlayRsnCd(vslSkdHisInVO.getVslDlayRsnCd());
//											sceActRcvIfVO.setVslDlayRsnDesc(vslSkdHisInVO.getVslDlayRsnDesc());
//											sceActRcvIfVO.setVpsLocCd(vslSkdHisInVO.getVslDlayRsnLocCd());
//											sceActRcvIfVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//											
//											copNoticeList.add(sceActRcvIfVO);
//										}
//									}
//									if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtbDt())){
//										if(!vslSkdHisInVO.getVpsEtbDt().equals(orgPortVO.getVpsEtbDt())){
//											SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
//											sceActRcvIfVO.setActRcvTpCd("25");
//											sceActRcvIfVO.setActDt(vslSkdHisInVO.getVpsEtbDt());
//											sceActRcvIfVO.setVslCd(vslCd);
//											sceActRcvIfVO.setSkdVoyNo(skdVoyNo);
//											sceActRcvIfVO.setSkdDirCd(skdDirCd);
//											sceActRcvIfVO.setVpsPortCd(vslSkdHisInVO.getVpsPortCd());
//											sceActRcvIfVO.setClptIndSeq(vslSkdHisInVO.getClptIndSeq());
//											sceActRcvIfVO.setVslDlayRsnCd(vslSkdHisInVO.getVslDlayRsnCd());
//											sceActRcvIfVO.setVslDlayRsnDesc(vslSkdHisInVO.getVslDlayRsnDesc());
//											sceActRcvIfVO.setVpsLocCd(vslSkdHisInVO.getVslDlayRsnLocCd());
//											sceActRcvIfVO.setNodCd(vslSkdHisInVO.getYdCd());
//											sceActRcvIfVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//											
//											copNoticeList.add(sceActRcvIfVO);
//										}
//									}
//									if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtdDt())){
//										if(!vslSkdHisInVO.getVpsEtdDt().equals(orgPortVO.getVpsEtdDt())){
//											SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
//											sceActRcvIfVO.setActRcvTpCd("26");
//											sceActRcvIfVO.setActDt(vslSkdHisInVO.getVpsEtdDt());
//											sceActRcvIfVO.setVslCd(vslCd);
//											sceActRcvIfVO.setSkdVoyNo(skdVoyNo);
//											sceActRcvIfVO.setSkdDirCd(skdDirCd);
//											sceActRcvIfVO.setVpsPortCd(vslSkdHisInVO.getVpsPortCd());
//											sceActRcvIfVO.setClptIndSeq(vslSkdHisInVO.getClptIndSeq());
//											sceActRcvIfVO.setVslDlayRsnCd(vslSkdHisInVO.getVslDlayRsnCd());
//											sceActRcvIfVO.setVslDlayRsnDesc(vslSkdHisInVO.getVslDlayRsnDesc());
//											sceActRcvIfVO.setVpsLocCd(vslSkdHisInVO.getVslDlayRsnLocCd());
//											sceActRcvIfVO.setNodCd(vslSkdHisInVO.getYdCd());
//											sceActRcvIfVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//											
//											copNoticeList.add(sceActRcvIfVO);
//										}
//									}
//								}
//								
//								//***** 'Y' : YARD 변경 *****
//								if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getYdCd())){
//									if(!vslSkdHisInVO.getYdCd().equals(orgPortVO.getYdCd())){
//										VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();
//										VslSkdCngUpdateVO vslSkdCngUpdateVO = new VslSkdCngUpdateVO();
//										
//										// history...
//										vskVslSkdHisVO.setVskdTpCd("P");
//										vskVslSkdHisVO.setBfrVslCd(orgPortVO.getVslCd());
//										vskVslSkdHisVO.setBfrSkdVoyNo(orgPortVO.getSkdVoyNo());
//										vskVslSkdHisVO.setBfrSkdDirCd(orgPortVO.getSkdDirCd());
//										vskVslSkdHisVO.setBfrVslSlanCd(orgPortVO.getVslSlanCd());
//										vskVslSkdHisVO.setBfrVpsEtaDt(orgPortVO.getVpsEtaDt());
//										vskVslSkdHisVO.setBfrVpsEtbDt(orgPortVO.getVpsEtbDt());
//										vskVslSkdHisVO.setBfrVpsEtdDt(orgPortVO.getVpsEtdDt());
//										vskVslSkdHisVO.setBfrVpsPortCd(orgPortVO.getVpsPortCd());
//										vskVslSkdHisVO.setBfrClptIndSeq(orgPortVO.getClptIndSeq());
//										vskVslSkdHisVO.setBfrYdCd(orgPortVO.getYdCd());
//										vskVslSkdHisVO.setAftVslCd(vslSkdHisInVO.getVslCd());
//										vskVslSkdHisVO.setAftSkdVoyNo(vslSkdHisInVO.getSkdVoyNo());
//										vskVslSkdHisVO.setAftSkdDirCd(vslSkdHisInVO.getSkdDirCd());
//										vskVslSkdHisVO.setAftVslSlanCd(vslSkdHisInVO.getVslSlanCd());
//										vskVslSkdHisVO.setAftYdCd(vslSkdHisInVO.getYdCd());
//										vskVslSkdHisVO.setVskdCngTpCd("Y");					//변경된 이유를 CODE화 하여 표시 - 'Y' : YARD 변경
//										vskVslSkdHisVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//										vskVslSkdHisVO.setUpdUsrId(vslSkdHisInVO.getUsrId());
//										
//										historyList.add(vskVslSkdHisVO);
//										
//										// booking...
//										vslSkdCngUpdateVO.setVvd(vslCd + skdVoyNo + skdDirCd);
//										vslSkdCngUpdateVO.setPortCd(vslSkdHisInVO.getVpsPortCd());
//										vslSkdCngUpdateVO.setOldClptIndSeq(orgPortVO.getClptIndSeq());
//										vslSkdCngUpdateVO.setNewClptIndSeq(vslSkdHisInVO.getClptIndSeq());
//										vslSkdCngUpdateVO.setOldYdCd(orgPortVO.getYdCd());
//										vslSkdCngUpdateVO.setNewYdCd(vslSkdHisInVO.getYdCd());
//										
//										bkgUpdateList.add(vslSkdCngUpdateVO);
//										
//										// cop...
//										SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
//										sceActRcvIfVO.setActRcvTpCd("27");
//										sceActRcvIfVO.setVslCd(vslCd);
//										sceActRcvIfVO.setSkdVoyNo(skdVoyNo);
//										sceActRcvIfVO.setSkdDirCd(skdDirCd);
//										sceActRcvIfVO.setVpsPortCd(vslSkdHisInVO.getVpsPortCd());
//										sceActRcvIfVO.setClptIndSeq(vslSkdHisInVO.getClptIndSeq());
//										sceActRcvIfVO.setVslDlayRsnCd(vslSkdHisInVO.getVslDlayRsnCd());
//										sceActRcvIfVO.setVslDlayRsnDesc(vslSkdHisInVO.getVslDlayRsnDesc());
//										sceActRcvIfVO.setVpsLocCd(vslSkdHisInVO.getVslDlayRsnLocCd());
//										sceActRcvIfVO.setNodCd(vslSkdHisInVO.getYdCd());
//										sceActRcvIfVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//										
//										copNoticeList.add(sceActRcvIfVO);
//									}
//								}
//								
//								//***** 'P' : PORT의 CALLING SEQUENCE 변경 *****
//								if(!vslSkdHisInVO.getClptIndSeq().equals(vslSkdHisInVO.getNewClptIndSeq())){
//									VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();
//									VslSkdCngUpdateVO vslSkdCngUpdateVO = new VslSkdCngUpdateVO();
//									
//									vskVslSkdHisVO.setVskdTpCd("P");
//									vskVslSkdHisVO.setBfrVslCd(orgPortVO.getVslCd());
//									vskVslSkdHisVO.setBfrSkdVoyNo(orgPortVO.getSkdVoyNo());
//									vskVslSkdHisVO.setBfrSkdDirCd(orgPortVO.getSkdDirCd());
//									vskVslSkdHisVO.setBfrVslSlanCd(orgPortVO.getVslSlanCd());
//									vskVslSkdHisVO.setBfrVpsPortCd(orgPortVO.getVpsPortCd());
//									vskVslSkdHisVO.setBfrClptIndSeq(orgPortVO.getClptIndSeq());
//									vskVslSkdHisVO.setAftVslCd(vslSkdHisInVO.getVslCd());
//									vskVslSkdHisVO.setAftSkdVoyNo(vslSkdHisInVO.getSkdVoyNo());
//									vskVslSkdHisVO.setAftSkdDirCd(vslSkdHisInVO.getSkdDirCd());
//									vskVslSkdHisVO.setAftVslSlanCd(vslSkdHisInVO.getVslSlanCd());
//									vskVslSkdHisVO.setAftVpsPortCd(vslSkdHisInVO.getVpsPortCd());
//									vskVslSkdHisVO.setAftClptIndSeq(vslSkdHisInVO.getNewClptIndSeq());
//									vskVslSkdHisVO.setVskdCngTpCd("P");					//변경된 이유를 CODE화 하여 표시 - 'P' : PORT의 CALLING SEQUENCE 변경
//									vskVslSkdHisVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//									vskVslSkdHisVO.setUpdUsrId(vslSkdHisInVO.getUsrId());
//									
//									historyList.add(vskVslSkdHisVO);
//									
//									//booking
//									vslSkdCngUpdateVO.setVvd(vslCd + skdVoyNo + skdDirCd);
//									vslSkdCngUpdateVO.setPortCd(vslSkdHisInVO.getVpsPortCd());
//									vslSkdCngUpdateVO.setPortCd(vslSkdHisInVO.getVpsPortCd());
//									vslSkdCngUpdateVO.setOldClptIndSeq(orgPortVO.getClptIndSeq());
//									vslSkdCngUpdateVO.setNewClptIndSeq(vslSkdHisInVO.getClptIndSeq());
//									vslSkdCngUpdateVO.setOldYdCd(orgPortVO.getYdCd());
//									vslSkdCngUpdateVO.setNewYdCd(vslSkdHisInVO.getYdCd());
//									
//									bkgUpdateList.add(vslSkdCngUpdateVO);
//								}
//							}
//						}
//					}
//				}//end for
//				
//				// Master 정보 변경 시 History START
//				if(masterVOList != null && masterVOList.size()>0){
//					for(VskVslSkdVO vskVslSkdVO : masterVOList){
//						//***** 'L' : Lane 변경 *****
//						for(VslSkdHisInVO vslSkdHisInVO : vslSkdHisInVOs){
//							if(vskVslSkdVO.getVslCd().equals(vslSkdHisInVO.getVslCd())
//									&& vskVslSkdVO.getSkdVoyNo().equals(vslSkdHisInVO.getSkdVoyNo())
//									&& vskVslSkdVO.getSkdDirCd().equals(vslSkdHisInVO.getSkdDirCd())){
//								//***** 'L' : Lane 변경 *****
//								if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getCngLaneCd())){
//									if(!vslSkdHisInVO.getVslSlanCd().equals(vslSkdHisInVO.getCngLaneCd())){
//										VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();
//										
//										vskVslSkdHisVO.setVskdTpCd("M");
//										vskVslSkdHisVO.setBfrVslCd(vslSkdHisInVO.getVslCd());
//										vskVslSkdHisVO.setBfrSkdVoyNo(vslSkdHisInVO.getSkdVoyNo());
//										vskVslSkdHisVO.setBfrSkdDirCd(vslSkdHisInVO.getSkdDirCd());
//										vskVslSkdHisVO.setBfrVslSlanCd(vslSkdHisInVO.getVslSlanCd());
//										vskVslSkdHisVO.setAftVslCd(vslSkdHisInVO.getVslCd());
//										vskVslSkdHisVO.setAftSkdVoyNo(vslSkdHisInVO.getSkdVoyNo());
//										vskVslSkdHisVO.setAftSkdDirCd(vslSkdHisInVO.getSkdDirCd());
//										vskVslSkdHisVO.setAftVslSlanCd(vslSkdHisInVO.getCngLaneCd());
//										vskVslSkdHisVO.setVskdCngTpCd("L");					//변경된 이유를 CODE화 하여 표시 - 'L' : Lane 변경
//										vskVslSkdHisVO.setCreUsrId(vslSkdHisInVO.getUsrId());
//										vskVslSkdHisVO.setUpdUsrId(vslSkdHisInVO.getUsrId());
//										
//										historyList.add(vskVslSkdHisVO);
//									}
//								}
//								
//								break;
//							}
//						}
//						
//						boolean vvdDelFlg = false;
//						for(VslSkdHisInVO vslSkdHisInVO : vslSkdHisInVOs){
//							if(vskVslSkdVO.getVslCd().equals(vslSkdHisInVO.getVslCd())
//									&& vskVslSkdVO.getSkdVoyNo().equals(vslSkdHisInVO.getSkdVoyNo())
//									&& vskVslSkdVO.getSkdDirCd().equals(vslSkdHisInVO.getSkdDirCd())){
//								vvdDelFlg = true;
//								//***** 'V' : VVD 삭제 *****
//								if(!"D".equals(vslSkdHisInVO.getIbflag())){
//									vvdDelFlg = false;
//									break;
//								}
//							}
//						}
//
//						//***** 'V' : VVD 삭제 *****
//						if(vvdDelFlg){
//							VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();
//							
//							vskVslSkdHisVO.setVskdTpCd("M");
//							vskVslSkdHisVO.setBfrVslCd(vskVslSkdVO.getVslCd());
//							vskVslSkdHisVO.setBfrSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
//							vskVslSkdHisVO.setBfrSkdDirCd(vskVslSkdVO.getSkdDirCd());
//							vskVslSkdHisVO.setVskdCngTpCd("V");					//변경된 이유를 CODE화 하여 표시 - 'V' : VVD 삭제
//							vskVslSkdHisVO.setCreUsrId(vskVslSkdVO.getCreUsrId());
//							vskVslSkdHisVO.setUpdUsrId(vskVslSkdVO.getUpdUsrId());
//							
//							historyList.add(vskVslSkdHisVO);
//						}
//					}
//				}
//				// Master 정보 변경 시 History END
//				
//				vslSkdChgStsGRPVO.setVslSkdCngNoticeVOs(bkgNoticeList);		// BKG
//				vslSkdChgStsGRPVO.setVslSkdCngUpdateVOs(bkgUpdateList);		// BKG
//				vslSkdChgStsGRPVO.setSceActRcvIfVOs(copNoticeList);			// COP
//				
//
////				********************* History Save *********************
//				if(historyList != null && historyList.size()>0){
//					dbDao.addVskVslSkdHis(historyList);
//				}
//			}
//		} catch (DAOException ex) {
//			/*
//			 * MSG - 입력중 오류가 발생하였습니다. BA 담당자에게 문의하세요.
//			 */
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
//		} catch (Exception ex) {
//			/*
//			 * MSG - 서비스 실행중 오류가 발생하였습니다.
//			 */
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		}
//		
//		return vslSkdChgStsGRPVO;
//	}
	
	
//	private String sendVslSkdErpIf2(List<ErpMsgFns017VO> list) throws EventException {
//		try{
//			return eaiDao.sendVslSkdErpIf(list);
//		}catch(DAOException e){
//			// VSK10046 : ERP 시스템과 통신 중 에러가 발생했습니다.
//			log.error("err " + e.toString(), e);
//			throw new EventException(new ErrorHandler("VSK10046").getMessage(), e);
//		}
//	}
	
	
//	/**
//	 * EDI 통신
//	 * 
//	 * @param String queueName
//	 * @param String flatFile
//	 * @return String
//	 * @exception EventException
//	 */
//	private String sendEdiToDLS(String queueName, String flatFile) throws EventException {
//		try{
//			return eaiDao.sendEdiToDLS(queueName , flatFile);
//		}catch(DAOException e){
//			// VSK10046 : ERP 시스템과 통신 중 에러가 발생했습니다.
//			log.error("err " + e.toString(), e);
//			throw new EventException(new ErrorHandler("VSK10046").getMessage(), e);			
//		}
//	}
	
	/**
	 * 기존 날짜 포맷 문자열을 새로운 날짜 포맷 문자열로 변경한다.
	 * 
	 * @param String newDateFormat
	 * @param String oldDateFormat
	 * @param String oldDate
	 * @return String
	 * @exception EventException
	 */
	private String getDateString(String newDateFormat, String oldDateFormat, String oldDate) throws EventException {
		try{
			String newDate = new SimpleDateFormat(newDateFormat).format(new SimpleDateFormat(oldDateFormat).parse(oldDate));
			return newDate;
		}catch(ParseException e){
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), e); 
		}
	}
	

	private void setFirstEtbByPF(String vvdKey, PortSkdOnLongRangeVO portSkdOnLongRangeVO, List<PfSkdDetailVO> pfSkdDetailVOs, Map<String, String> firstEtbByVVD) throws EventException {
		
		PfSkdDetailVO firstPfSkd = pfSkdDetailVOs.get(0);
		for(PfSkdDetailVO pfSkdDetailVO : pfSkdDetailVOs){
			// Port Skd의 정보와 일치하는 P/F 정보를 찾는다.
			if(pfSkdDetailVO.getSkdDirCd().equals(portSkdOnLongRangeVO.getSkdDirCd()) &&
					pfSkdDetailVO.getPortCd().equals(portSkdOnLongRangeVO.getVpsPortCd()) &&
					pfSkdDetailVO.getYdCd().equals(portSkdOnLongRangeVO.getYdCd()) &&
					pfSkdDetailVO.getClptSeq().equals(portSkdOnLongRangeVO.getClptIndSeq())){
				
				// Port Schedule 과 연관된 P/F 정보를 설정한다.
				// P/F와 연결되지 않는 Port Schedule은 이 부분이 null이 된다. (Add Calling 등등)
				portSkdOnLongRangeVO.setPfSkdDetailVO(pfSkdDetailVO);
				
				setFirstEtb(vvdKey, portSkdOnLongRangeVO.getPfEtbDt(), firstPfSkd, pfSkdDetailVO, firstEtbByVVD);
				break;
			}
		}
	}
	
	private void setFirstEtbByInit(String vvdKey, PortSkdOnLongRangeVO portSkdOnLongRangeVO, List<PfSkdDetailVO> pfSkdDetailVOs, Map<String, String> firstEtbByVVD) throws EventException {
		
		PfSkdDetailVO firstPfSkd = pfSkdDetailVOs.get(0);
		for(PfSkdDetailVO pfSkdDetailVO : pfSkdDetailVOs){
			// Port Skd의 정보와 일치하는 P/F 정보를 찾는다.
			if(pfSkdDetailVO.getSkdDirCd().equals(portSkdOnLongRangeVO.getSkdDirCd()) &&
					pfSkdDetailVO.getPortCd().equals(portSkdOnLongRangeVO.getVpsPortCd()) &&
					pfSkdDetailVO.getYdCd().equals(portSkdOnLongRangeVO.getYdCd()) &&
					pfSkdDetailVO.getClptSeq().equals(portSkdOnLongRangeVO.getClptIndSeq())){
				
				// Port Schedule 과 연관된 P/F 정보를 설정한다.
				// P/F와 연결되지 않는 Port Schedule은 이 부분이 null이 된다. (Add Calling 등등)
				portSkdOnLongRangeVO.setPfSkdDetailVO(pfSkdDetailVO);
				
				setFirstEtb(vvdKey, portSkdOnLongRangeVO.getInitEtbDt(), firstPfSkd, pfSkdDetailVO, firstEtbByVVD);
				break;
			}
		}
	}
	
	private void setFirstEtb(String vvdKey, String etbDt, PfSkdDetailVO firstPfSkd, PfSkdDetailVO pfSkdDetailVO, Map<String, String> firstEtbByVVD) throws EventException {
		
		// portSkdOnLongRangeVO와 일치하는 P/F 항목이 첫번째 Calling Port인 경우(PORT_ROTN_SEQ) 해당 정보를 바로 정렬 Map에 등록한다.
		if("1".equals(pfSkdDetailVO.getPortRotnSeq())){
			firstEtbByVVD.put(vvdKey, VSKGeneralUtil.changeDateFormat(etbDt, "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss"));
		}else{
			String date = VSKGeneralUtil.changeDateFormat(etbDt, "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss").substring(0, 8);
			String genDate = VSKGeneralUtil.getActionDate(date, 
					VSKGeneralUtil.convertNumberByString(firstPfSkd.getEtbDyNo()) - VSKGeneralUtil.convertNumberByString(pfSkdDetailVO.getEtbDyNo())); 
			firstEtbByVVD.put(vvdKey, genDate + firstPfSkd.getEtbTmHrmnt() + "59");
		}
		
	}
	
	/**
	 * Turning으로 연결된 1st Direction과 2nd Direction VVD를 연결한다.
	 * 연결된 Port Schedule 정보는 Inquiry 화면에서 하나의 Row로 표시된다.
	 * 
	 * @param Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD
	 * @author Hyuk Ryu
	 * @date 2009. 12. 7.
	 */
	private void linkTurningVVD(Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD){
		String[] vvdKeys = portSkdByVVD.keySet().toArray(new String[portSkdByVVD.size()]);
		
		List<PortSkdOnLongRangeVO> portSkds = null;
		List<PortSkdOnLongRangeVO> targetPortSkds = null;
		PortSkdOnLongRangeVO tmpPortSkd = null;
		String turnPortVVD = null;
		
		for(int i=0; i<vvdKeys.length; i++){
			
			if(!portSkdByVVD.containsKey(vvdKeys[i])){
				continue;
			}
			
			if("KOHD0500E".equals(vvdKeys[i])){
				log.debug("");
			}
			
			portSkds = portSkdByVVD.get(vvdKeys[i]);
			targetPortSkds = null;
			
			tmpPortSkd = null;
			turnPortVVD = null;
			for(int k=0; k<portSkds.size(); k++){
				
				if("1".equals(portSkds.get(0).getVslSlanDirSeq())){
					break;
				}
				
				tmpPortSkd = portSkds.get(k);
				
				// 1st Direction VVD와 Turning으로 연결되는 2nd Direction VVD를 연결한다.
				// 2nd VVD로부터 1st의 VVD를 찾는다.
				if("2".equals(tmpPortSkd.getVslSlanDirSeq()) && "Y".equals(tmpPortSkd.getTurnPortIndCd())){
					turnPortVVD = tmpPortSkd.getVslCd() + tmpPortSkd.getTurnSkdVoyNo() + tmpPortSkd.getTurnSkdDirCd();
					targetPortSkds = portSkdByVVD.get(turnPortVVD);
					break;
				}
				
			}
			
			if(turnPortVVD!=null && targetPortSkds!=null){
				// P/F Schedule Type CD가 같으면 연결한다. 
				if(tmpPortSkd.getPfSkdTpCd().equals(targetPortSkds.get(0).getPfSkdTpCd())){
					
					targetPortSkds.addAll(portSkdByVVD.get(vvdKeys[i]));
					portSkdByVVD.remove(vvdKeys[i]);
				}
			}
			
		}
	}
	
	/**
	 * 같은 Voyage No인 Direction과 2nd Direction VVD를 연결한다.
	 * 연결된 Port Schedule 정보는 Inquiry 화면에서 하나의 Row로 표시된다.
	 * 
	 * @param Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD
	 * @author Hyuk Ryu
	 * @date 2009. 12. 7.
	 */
	private void linkSameVoyageVVD(Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD){
		
		String[] vvdKeys = portSkdByVVD.keySet().toArray(new String[portSkdByVVD.size()]);
		
		List<PortSkdOnLongRangeVO> portSkd = null;
		PortSkdOnLongRangeVO tmpPortSkd = null;
		String sameVoyVVD = null;
		
		StringBuffer sbSameVoyVVD	= new StringBuffer();
		
		String firstDirCd = null;
		
		for(int i=0; i<vvdKeys.length; i++){
			
			if(!portSkdByVVD.containsKey(vvdKeys[i])){
				continue;
			}
			
			portSkd = portSkdByVVD.get(vvdKeys[i]);
			
			sameVoyVVD = null;
			tmpPortSkd = null;
			firstDirCd = null;
			for(int k=0; k<portSkd.size(); k++){
				tmpPortSkd = portSkd.get(k);

				if("1".equals(tmpPortSkd.getVslSlanDirSeq())){
					sameVoyVVD = tmpPortSkd.getVslCd() + tmpPortSkd.getSkdVoyNo();
					firstDirCd = tmpPortSkd.getSkdDirCd();
					if("E".equals(firstDirCd)){
						
						//sameVoyVVD = sameVoyVVD + "W";
						
						sbSameVoyVVD.append(sameVoyVVD);
						sbSameVoyVVD.append("W");
						
					}else if("W".equals(firstDirCd)){
						//sameVoyVVD = sameVoyVVD + "E";
						
						sbSameVoyVVD.append(sameVoyVVD);
						sbSameVoyVVD.append("E");
						
					}else if("S".equals(firstDirCd)){
						//sameVoyVVD = sameVoyVVD + "N";
						
						sbSameVoyVVD.append(sameVoyVVD);
						sbSameVoyVVD.append("N");
						
					}else if("N".equals(firstDirCd)){
						//sameVoyVVD = sameVoyVVD + "S";
						
						sbSameVoyVVD.append(sameVoyVVD);
						sbSameVoyVVD.append("S");
						
					}
					break;
				}

			}
			
			sameVoyVVD	= sbSameVoyVVD.toString();
			
			// 1st Direction VVD와 같은 Voyage No를 갖는 2nd Direction VVD를 연결한다.
			if(sameVoyVVD!=null && portSkdByVVD.containsKey(sameVoyVVD)){
				// P/F Schedule Type CD가 같으면 연결한다. 
				if(tmpPortSkd != null && tmpPortSkd.getPfSkdTpCd() != null &&
					tmpPortSkd.getPfSkdTpCd().equals(portSkdByVVD.get(sameVoyVVD).get(0).getPfSkdTpCd())){
					
					portSkd.addAll(portSkdByVVD.get(sameVoyVVD));
					portSkdByVVD.remove(sameVoyVVD);	
				}
			}
			
		}
	}
	
	private List<List<PortSkdOnLongRangeVO>> sortPortSkd(Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD, Map<String, String> firstEtbByVVD) throws EventException {
		
		// 하나의 vvd에 대해 나머지 vvd와 모두 비교한다.
		// 정렬이 완료되면 vvdKeys 배열 내의 원소(vvd)들은 정렬된 순서대로 재배치 되어있는 상태이다.
		
		String[] vvdKeys = portSkdByVVD.keySet().toArray(new String[portSkdByVVD.size()]);
		String tmpVVD = null;
		int compare = 0;
		
		for(int i=0; i<vvdKeys.length; i++){
			for(int m=0; m<vvdKeys.length; m++){
				compare = 0;
				
				// compareVVD는 비교하고자 하는 인자의 순서가 중요하므로
				// i와 m의 값의 크기에 주의
				
				if(i==m){
					continue;
				}else if(i<m){
					compare = compareVVD(vvdKeys[i], vvdKeys[m], firstEtbByVVD.get(vvdKeys[i]), firstEtbByVVD.get(vvdKeys[m]), portSkdByVVD);	
				}else if(i>m){
					compare = compareVVD(vvdKeys[m], vvdKeys[i], firstEtbByVVD.get(vvdKeys[m]), firstEtbByVVD.get(vvdKeys[i]), portSkdByVVD);
				}
				
				// yVVDKeys[m]이 후행 스케쥴이면 compare < 0 ==> 정상인경우
				// xVVDKeys[i] > yVVDKeys[m]. 즉, xVVDKeys[i]이 후행스케쥴이면 compare > 0  ==> 자리를 바꿔야 하는 경우
				if(compare>0){
					tmpVVD = vvdKeys[i];
					vvdKeys[i] = vvdKeys[m];
					vvdKeys[m] = tmpVVD;
				}
			}
		}
		
		// vvdKeys 배열에는 정렬된 VVD리스트가 있다.
		// 정렬된 VVD를 바탕으로 Port Schecule 정보 리스트를 구성한다.
		List<List<PortSkdOnLongRangeVO>> sortedPortList = new ArrayList<List<PortSkdOnLongRangeVO>>();
		for(int i=0; i<vvdKeys.length; i++){
			sortedPortList.add(portSkdByVVD.get(vvdKeys[i]));
		}
		
		return sortedPortList;		
	}
	
	private int compareVVD(String vvd1, String vvd2, String etb1, String etb2, Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD) throws EventException {
		List<PortSkdOnLongRangeVO> portSkd1 = portSkdByVVD.get(vvd1);
		List<PortSkdOnLongRangeVO> portSkd2 = portSkdByVVD.get(vvd2);
		
		int compare = 0;
		boolean findSamePort = false;
		PortSkdOnLongRangeVO skdVO1 = null;
		PortSkdOnLongRangeVO skdVO2 = null;
		
		// 같은 Port 정보를 찾아 두 개의 리스트간의 선,후행을 결정하고
		// 같은 Port 정보를 못찾을 때에는 ETB를 이용하여 선, 후행을 결정한다.
		// VVD1이 선행이면 return -1
		// VVD1과 VVD2가 동일하면 return 0
		// VVD1이 후행이면 return 1
		
		for(int i=0; i<portSkd1.size(); i++){
			skdVO1 = portSkd1.get(i);
			for(int m=0; m<portSkd2.size(); m++){
				skdVO2 = portSkd2.get(m);
				if(skdVO1.isSamePort(skdVO2)){
					findSamePort = true;
					break;
				}
			}
			
			if(findSamePort){
				break;
			}
			
		}
		
		if(findSamePort){
			// VPS_ETB_DT 비교
			compare = VSKGeneralUtil.compareSkdDate(skdVO1.getVpsEtbDt(), "yyyy-MM-dd HH:mm:ss", skdVO2.getVpsEtbDt(), "yyyy-MM-dd HH:mm:ss");
		}else{
			
			// 만약 VSL_CD, SKD_VOY_NO 가 동일한 두 항차(SKD_DIR_CD만 다른)라면
			// 1st Direction VVD가 선행 하도록 한다.
			if(
				skdVO1 != null && skdVO1.getVslCd() != null && skdVO1.getSkdVoyNo() != null && skdVO2 != null &&
				skdVO1.getVslCd().equals(skdVO2.getVslCd()) &&
				skdVO1.getSkdVoyNo().equals(skdVO2.getSkdVoyNo())
			){
				compare = VSKGeneralUtil.compareSkdDate(portSkd1.get(0).getVpsEtbDt(), "yyyy-MM-dd HH:mm:ss", portSkd2.get(0).getVpsEtbDt(), "yyyy-MM-dd HH:mm:ss");
			}else{
				compare = VSKGeneralUtil.compareSkdDate(etb1, "yyyyMMddHHmmss", etb2, "yyyyMMddHHmmss");
			}
		}
		
		return compare;
		
	}
	
	/**
	 * srcGrid의 정보를 tgtGrid에 반영한다.
	 * tgtGrid에서 Direction Code, Port Code, Yard Code가 같으면 반영한다.
	 * 
	 * @param List<List<PortSkdOnLongRangeVO>> srcVVDs
	 * @param List<List<PortSkdOnLongRangeVO>> tgtVVDs
	 * @return List<List<PortSkdOnLongRangeVO>>
	 */
	private List<List<PortSkdOnLongRangeVO>> adjustAllSkd(List<List<PortSkdOnLongRangeVO>> srcVVDs, List<List<PortSkdOnLongRangeVO>> tgtVVDs){
		
		List<PortSkdOnLongRangeVO> tmp = null;
		List<PortSkdOnLongRangeVO> emptyList = null;
		List<PortSkdOnLongRangeVO> newVVD = null;
		
		if(tgtVVDs.size()<0){
			tgtVVDs.addAll(srcVVDs);
		}else{
			
			for(List<PortSkdOnLongRangeVO> portSkdVOs : srcVVDs){
				if(tgtVVDs != null && tgtVVDs.size()==0){
					tgtVVDs.add(srcVVDs.get(0));
					continue;
				}
				
				tmp = new ArrayList<PortSkdOnLongRangeVO>();
				emptyList = new ArrayList<PortSkdOnLongRangeVO>();
				
				//  tgtVVD와 동일한 Port 리스트로 구성된 VVD 를 구성한다.
				newVVD = new ArrayList<PortSkdOnLongRangeVO>();
				if (tgtVVDs != null) {
					for(PortSkdOnLongRangeVO portSkdVO : tgtVVDs.get(0)){
						PortSkdOnLongRangeVO empty = new PortSkdOnLongRangeVO();
						empty.setVslSlanCd(portSkdVO.getVslSlanCd());
						empty.setPfSkdTpCd(portSkdVO.getPfSkdTpCd());
						empty.setSkdDirCd(portSkdVO.getSkdDirCd());
						empty.setVpsPortCd(portSkdVO.getVpsPortCd());
						empty.setClptIndSeq(portSkdVO.getClptIndSeq());
						empty.setYdCd(portSkdVO.getYdCd());
						empty.setCallYdIndSeq(portSkdVO.getCallYdIndSeq());
						empty.setClptSeq(portSkdVO.getClptSeq());
						empty.setEmptySkd(true);
						newVVD.add(empty);
					}
				}
				
				// tgtVVDs의 2nd Direction의 위치를 구한다.
				int startPos2nd = 0;
				if (tgtVVDs != null) {
					startPos2nd = find2ndStartPos(tgtVVDs.get(0));
				}
				
				// 반영하고자 하는 VVD의 Port와 일치하는 정보가 tgtGrid에 존재하는지 확인한다.
				// 없는 경우, 해당 정보를 따로 보관하여
				// 이후 일치하는 포트와 연속하여 반영하게 한다. (일치하는 포트와 일렬로 붙어서 반영되게 된다.)
				
				String currentDir = null;
				boolean changeDir = false;
				
				for(PortSkdOnLongRangeVO portSkdVO : portSkdVOs){
					
					// 현재 매핑 작업중인 port_skd이 이전 port_skd과 비교하여 direction이 변경되었는지 식별한다.
					if(currentDir!=null && !currentDir.equals(portSkdVO.getSkdDirCd())){
						currentDir = portSkdVO.getSkdDirCd();
						changeDir = true;
					}else{
						currentDir = portSkdVO.getSkdDirCd();
						changeDir = false;
					}
					
					// 다음 두 조건에 모두 해당하는 경우 반영한다.
					// - 반영하지 못한 Port 정보가 있음
					// - Direction이 변경(1st -> 2nd)
					if(tmp.size()>0 && changeDir){

						if(startPos2nd>-1){ //  앞쪽에 반영한다.
							newVVD.addAll(startPos2nd, tmp);
							for(List<PortSkdOnLongRangeVO> otherVVD : tgtVVDs){
								otherVVD.addAll(startPos2nd, emptyList);
							}
						}else{ // 2nd direction이 없는 경우이므로, 맨 뒤에 반영한다.
							newVVD.addAll(tmp);
							for(List<PortSkdOnLongRangeVO> otherVVD : tgtVVDs){
								otherVVD.addAll(emptyList);
							}
						}
						
						tmp = new ArrayList<PortSkdOnLongRangeVO>();
						emptyList = new ArrayList<PortSkdOnLongRangeVO>();
					}
					
					
					int tgtPos = 0;
					if (tgtVVDs != null) {
						tgtPos = findTargetPos(tgtVVDs.get(0), portSkdVO);
					}
					
					if(tgtPos==-1 || !newVVD.get(tgtPos).isEmptySkd()){
						
						// 해당 VVD에 추가될 정보
						tmp.add(portSkdVO);
						
						// 나머지 VVD에 추가될 정보
						PortSkdOnLongRangeVO empty = new PortSkdOnLongRangeVO();
						empty.setVslSlanCd(portSkdVO.getVslSlanCd());
						empty.setPfSkdTpCd(portSkdVO.getPfSkdTpCd());
						empty.setSkdDirCd(portSkdVO.getSkdDirCd());
						empty.setVpsPortCd(portSkdVO.getVpsPortCd());
						empty.setClptIndSeq(portSkdVO.getClptIndSeq());
						empty.setYdCd(portSkdVO.getYdCd());
						empty.setCallYdIndSeq(portSkdVO.getCallYdIndSeq());
						empty.setClptSeq(portSkdVO.getClptSeq());
						empty.setEmptySkd(true);
						emptyList.add(empty);
						
						continue;
					}else{
						
						// 해당 VVD에 Port 정보 반영
						newVVD.set(tgtPos, portSkdVO);
						
						if(tmp.size()>0){
							// 반영할 Port 정보가 여러개이면 해당 VVD(newVVD)에만 estimate time이 있는 정보를 추가한다.
							// tgtVVDs의 나머지 Row정보(타 VVD)에는 tgtPos 앞으로 emptyList를 추가한다.
							
							newVVD.addAll(tgtPos, tmp);
							for(List<PortSkdOnLongRangeVO> otherVVD : tgtVVDs){
								otherVVD.addAll(tgtPos, emptyList);
							}
							
							tmp = new ArrayList<PortSkdOnLongRangeVO>();
							emptyList = new ArrayList<PortSkdOnLongRangeVO>();
						}
					}
				}
				
				// 반영하지 못한 포트가 남은 경우
				// 각 Direction의 마지막 위치에 반영한다.
				if(tmp.size()>0){
					newVVD.addAll(tmp);
					if (tgtVVDs != null) {
						for(List<PortSkdOnLongRangeVO> otherVVD : tgtVVDs){
							otherVVD.addAll(emptyList);
						}
					}
				}
				
				// 신규 VVD 추가한다.			
				if (tgtVVDs != null) {
					tgtVVDs.add(newVVD);
				}
			}
			// 통합된 tgtVVDs 에는 direction이 섞여있을수 있으므로.
			// 예를 들어, W, E, W, E 가 섞여있으면 그룹핑해서 W | E로 표기한다.
			if(tgtVVDs != null && tgtVVDs.size()>0){
				sortSkdByDir(tgtVVDs);
			}
		}
		return null;
	}
	
	/**
	 * 같은 포트 순서로 구성된 여러개의 VVD들을 같은 Direction 별로 묶어서 정렬한다.
	 * 
	 * @param List<List<PortSkdOnLongRangeVO>> tgtVVDs
	 */
	private void sortSkdByDir(List<List<PortSkdOnLongRangeVO>> tgtVVDs){
		boolean finish = false;
		while(!finish){
			List<PortSkdOnLongRangeVO> firstVVDSkd = tgtVVDs.get(0);
			// tgtVVD의 첫번째 direction
			String firstSkdDirCd = firstVVDSkd.get(0).getSkdDirCd();
			int lastPos1stDir = 0; // 2nd directon이 나오기 전까지의 첫번째 direction의 최종 위치
			int pos2stDir = 0; // 2nd direction이 나오는 첫번째 port 위치
			
			
			
			// 어떤 포트의 dir_cd가 firstSkdDirCd와 다른 경우, 그 앞쪽 Port Skd와 교환한다.  
			// 예를 들어 A(W), B(W), C(E), D(W) 로 구성된 VVD라면 D를 B 앞으로 보내야 한다.
			PortSkdOnLongRangeVO portSkdOnLongRangeVO = null;
			String skdDirCd = null;
			for(int i=0; i<firstVVDSkd.size(); i++){
				portSkdOnLongRangeVO = firstVVDSkd.get(i);
				skdDirCd = portSkdOnLongRangeVO.getSkdDirCd();
				
				// 첫번째 dir_cd와 같은 포트의 앞쪽에 두번재 dir_cd를 갖는 포트가 존재하는 경우 ==> 바꿔야 하는 대상 
				if(pos2stDir>0 && firstSkdDirCd.equals(skdDirCd)){
					control(tgtVVDs, pos2stDir, i);
					break;
				}
				
				if(firstSkdDirCd.equals(skdDirCd)){
					lastPos1stDir = i;
					continue;
				}else{
					pos2stDir = i;
					continue;
				}
			}
			
			// 정렬이 모두 끝나면 while 문 빠져나옴
			if(lastPos1stDir==firstVVDSkd.size()-1 || pos2stDir==firstVVDSkd.size()-1){
				finish = true;
			}
		}
	}
	
	/**
	 * srcPos 위치의 Port Skd 정보를 tgtPos 위치로 옮긴다.
	 * 
	 * @param List<List<PortSkdOnLongRangeVO>> tgtVVDs
	 * @param int tgtPos
	 * @param int srcPos
	 */
	private void control(List<List<PortSkdOnLongRangeVO>> tgtVVDs, int tgtPos, int srcPos){
		for(List<PortSkdOnLongRangeVO> vvdSkd : tgtVVDs){
			PortSkdOnLongRangeVO tmpVO = vvdSkd.get(srcPos);
			vvdSkd.remove(srcPos);
			vvdSkd.add(tgtPos, tmpVO);
		}
	}
	
	
	private int findTargetPos(List<PortSkdOnLongRangeVO> tgtVVD, PortSkdOnLongRangeVO srcVO){
		boolean find = false;
		int tgtPos = 0;
		for(PortSkdOnLongRangeVO tgtVO : tgtVVD){
			if(tgtVO.getSkdDirCd().equals(srcVO.getSkdDirCd()) &&
					tgtVO.getVpsPortCd().equals(srcVO.getVpsPortCd()) &&
					tgtVO.getYdCd().equals(srcVO.getYdCd()) &&
					tgtVO.getClptIndSeq().equals(srcVO.getClptIndSeq())
					){
				find = true;
				break;
			}
			tgtPos++;
		}
		if(find){
			return tgtPos;
		}else{
			return -1;
		}
	}
	
	private int find2ndStartPos(List<PortSkdOnLongRangeVO> portSkdVOs){
		int pos = 0;
		boolean find = false;
		for(PortSkdOnLongRangeVO vo : portSkdVOs){
			if("2".equals(vo.getVslSlanDirSeq())){
				find = true;
				break;
			}
			pos++;
		}
		if(find){
			return pos;
		}else{
			return -1;
		}
	}
	
	/**
	 * P/F를 기준으로 PortSkd 정보를 배치한다.
	 * 
	 * @param Map<String, List<PfSkdDetailVO>> pfSkdDetails
	 * @param List<List<PortSkdOnLongRangeVO>> portSkdVOBySamePf
	 * @param Map<String, List<PfSkdDetailVO>> pfSkdDetailsByGroup
	 * @return List<List<PortSkdOnLongRangeVO>>
	 */
	private List<List<PortSkdOnLongRangeVO>> adjustSkd(
			Map<String, List<PfSkdDetailVO>> pfSkdDetails, 
			List<List<PortSkdOnLongRangeVO>> portSkdVOBySamePf,
			Map<String, List<PfSkdDetailVO>> pfSkdDetailsByGroup) throws EventException {
		
		List<PortSkdOnLongRangeVO> addingPortList = new ArrayList<PortSkdOnLongRangeVO>();
		PortSkdOnLongRangeVO vo = null;
		
		// P/F 정보를 구한다.
		vo = portSkdVOBySamePf.get(0).get(0);
		String pfSkdKey = vo.getVslSlanCd() + vo.getPfSkdTpCd();
		String pfSkdKeyByGroup = pfSkdKey + vo.getVslCd() + vo.getSkdVoyNo();
		List<PfSkdDetailVO> pfSkdDetailVOs = pfSkdDetails.get(pfSkdKey);
		List<PfSkdDetailVO> pfSkdDetailVOsByGroup = new ArrayList<PfSkdDetailVO>(pfSkdDetails.get(pfSkdKey));
	
		PortSkdOnLongRangeVO[] tmpPortSkdArr = null;
		List<List<PortSkdOnLongRangeVO>> tmpPortSkdGridData = new ArrayList<List<PortSkdOnLongRangeVO>>();
		
		// Adding Port를 제외하면 모든 Port Skd는 P/F 상의 어떤 포트와 일치한다.
		// 그러므로, 1차적으로 Adding Port 스케쥴을 제외한 나머지 스케쥴을 P/F를 이용하여 배치하고
		// 남아있는 Adding Port를 적절하게 끼워넣는다.
		
		try{
			for(List<PortSkdOnLongRangeVO> portSkdVOs : portSkdVOBySamePf){
				
				tmpPortSkdArr = initSkdByPf(pfSkdDetailVOs);
				
				//int addPortCount = 0;
				
				for(int i=0; i<portSkdVOs.size(); i++){
					vo = portSkdVOs.get(i);
					
					//if("A".equals(vo.getSkdCngStsCd()) || "".equals(vo.getPfEtaDt())){
					// PF Estimate Time 이 없으면 Adding Calling으로 간주.
					// SKD_CNG_STS_CD 코드에서 "A"는 신뢰성이 떨어짐.
					if("".equals(vo.getPfEtaDt())){
						//addPortCount++;
						vo.setAddingSkd(true);
						addingPortList.add(vo);
						continue;
					}else{
						
						// 추가(2010.02.19)
						// PF Estimate Time 이 있는 경우도 발생함. 즉 데이터 상으로는 Add Calling 인지 확인할 수 없는 경우가 존재함.
						// PF와 Port와 Yard를 조사하여 그 위치값을 찾을 수 없는 경우 Add Calling으로 인식한다. 
	
						int idx = getHeaderIdx(pfSkdDetailVOs, vo);
						if(idx!=-1){
							tmpPortSkdArr[idx] = vo;
						}else{
	
							// Final Port가 아닌 경우는 일반적인 Add Calling으로 인식한다.
							if(!"F".equals(vo.getTurnPortIndCd())){
								vo.setAddingSkd(true);
								addingPortList.add(vo);	
							}else{
								
								// Final Port로 판별된 경우 ==> Final Port 앞에 동일한 Port, Yard로 Add call port를 해서, Final Port 정보의 CLPT_IND_SEQ가 증가. 결국 PF 와의 일치 정보를 찾을 수 없게되어 버린 경우
								//
								// tmpPortSkdArr[] 배열(PF 와 일치하는 정보 배열)에서 동일한 Port, Yard를 가지는 정보중 가장 마지막 대상을 찾아서 Final Port 정보와 교환 한다.
								
								int pos = -1;
								for(int m=tmpPortSkdArr.length-1; m>=0; m--){
									if(
										vo.getSkdDirCd().equals(tmpPortSkdArr[m].getSkdDirCd()) &&
										vo.getVpsPortCd().equals(tmpPortSkdArr[m].getVpsPortCd()) &&
										vo.getYdCd().equals(tmpPortSkdArr[m].getYdCd())
									){
										pos = m;
										break;
									}
								}
								
								if(pos!=-1){
									// 대상을 찾으면 교환
									tmpPortSkdArr[pos].setAddingSkd(true);
									addingPortList.add(tmpPortSkdArr[pos]);
									tmpPortSkdArr[pos] = vo;
								}else{
									// 대상을 못찾으면 데이터에 이상이 있는 것임.
									// 일단 Add Calling으로 처리하고 데이터를 확인해 보아야 함.
									vo.setAddingSkd(true);
									addingPortList.add(vo);
								}
							}
						}
					}
				}
				
				// tmpPortSkdArr에 일반적인 포트 스케줄이 없는 경우(Adding Port로만 구성된 VVD)
				// tmpPortSkdGridData에 VVD정보만 있는 빈 스케줄을 추가한다.
				boolean emptyVVD = true;
				for(int i=0; i<tmpPortSkdArr.length; i++){
					PortSkdOnLongRangeVO tmpvo = tmpPortSkdArr[i];
					if(!tmpvo.isEmptySkd()){
						emptyVVD = false;
						break;
					}
				}
				
				if(emptyVVD){
					tmpPortSkdArr[0].setVslCd(portSkdVOs.get(0).getVslCd());
					tmpPortSkdArr[0].setSkdVoyNo(portSkdVOs.get(0).getSkdVoyNo());
					tmpPortSkdArr[0].setSkdDirCd(portSkdVOs.get(0).getSkdDirCd());
					
					tmpPortSkdArr[tmpPortSkdArr.length-1].setVslCd(portSkdVOs.get(portSkdVOs.size()-1).getVslCd());
					tmpPortSkdArr[tmpPortSkdArr.length-1].setSkdVoyNo(portSkdVOs.get(portSkdVOs.size()-1).getSkdVoyNo());
					tmpPortSkdArr[tmpPortSkdArr.length-1].setSkdDirCd(portSkdVOs.get(portSkdVOs.size()-1).getSkdDirCd());
				}
				
				tmpPortSkdGridData.add(Arrays.asList(tmpPortSkdArr));
			}
		}catch(Exception e){
			throw new EventException(new ErrorHandler("COM12114", new String[]{vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd() + " Schedule"}).getMessage(), e);
		}
		
		// Adding Port가 없다면 기본 P/F와 동일할 것임.
		pfSkdDetailsByGroup.put(pfSkdKeyByGroup, pfSkdDetailVOsByGroup);
		
		// Adding Port 정보를 추가한다.
		// 1. 어떤 VVD인지 식별
		// 2. CLPT_SEQ를 이용하여 VVD상의 위치 식별
		// 3. 해당 위치에 있는 다른 VVD 상의 Port 정보와  시간 전후 관계를 고려하여 최종 위치 선정
		// 4. 해당 VVD에 Adding Port 정보를 추가하고, 다른 VVD의 해당 위치에는 빈 스케쥴을 추가한다.

		for(int i=0; i<addingPortList.size(); i++){
			PortSkdOnLongRangeVO addPortVO = addingPortList.get(i);
			int vvdPos = 0;
			int portPos = 0;
			boolean findVvdPos = false;
			
			PortSkdOnLongRangeVO first = null;
			PortSkdOnLongRangeVO last = null;
			
			if(addPortVO.isEmptySkd()){
				continue;
			}
			
			// find vvdPos
			for(List<PortSkdOnLongRangeVO> portSkdVOs : tmpPortSkdGridData){
				first = findFirstSkd(portSkdVOs);
				last = findLastSkd(portSkdVOs);
				
				// first, last가 null 인 경우는 해당 vvd에 Adding Port가 아닌 일반적인 스케줄을 없는 상황이므로 Adding Port가 제일 먼저 등록되는 경우임.
				if(first==null && last==null){
					first = addPortVO;
					last = addPortVO;
				}
				
				if(		(addPortVO.getVslCd().equals(first.getVslCd()) && addPortVO.getSkdVoyNo().equals(first.getSkdVoyNo())) ||
						(addPortVO.getVslCd().equals(last.getVslCd()) && addPortVO.getSkdVoyNo().equals(last.getSkdVoyNo())) ||
						(addPortVO.getVslCd().equals(first.getVslCd()) && addPortVO.getSkdVoyNo().equals(first.getTurnSkdVoyNo()) && 
								("Y".equals(first.getTurnPortIndCd()) || "N".equals(first.getTurnPortIndCd())))
				){
					findVvdPos = true;
					break;
				}
				vvdPos++;
			}
			
			if(!findVvdPos){
				throw new EventException(new ErrorHandler("COM12114", new String[]{addPortVO.getVslCd() + addPortVO.getSkdVoyNo() + addPortVO.getSkdDirCd() + " Schedule"}).getMessage());
			}
			
			List<PortSkdOnLongRangeVO> targetVVD = tmpPortSkdGridData.get(vvdPos);
			int addPortClptSeq = Integer.parseInt(addPortVO.getClptSeq());
			
			// find portPos
			// Adding Port의 CLPT_SEQ 보다 작은 것들중 가장 큰 Port의 그리드 상의 컬럼 위치값를 찾는 과정
			// Adding Port의 CLPT_SEQ에서 1을 빼서 사용하지 않는 이유는
			// Adding Port가 연속되어 있는 경우가 있기 때문이다.
			boolean findPortPos = false;
			int prePortPos = 0;
			for(int prePortClptSeq = addPortClptSeq-1; prePortClptSeq>0; prePortClptSeq--){
				prePortPos = 0;
				for(PortSkdOnLongRangeVO prePort : targetVVD){
					if(
							prePort.getSkdDirCd().equals(addPortVO.getSkdDirCd()) &&
							prePort.getClptSeq().equals(Integer.toString(prePortClptSeq))
							){
						findPortPos = true;
						break;
					}
					prePortPos++;
				}
				if(findPortPos){
					break;
				}
			}
			
			// findPortPos가 false 이면 Adding Port가 맨 앞에 있다는 말이 됨.
			// 맨앞에 추가되는 경우. 각 Direction 별 처음 위치를 찾는다.
			if(!findPortPos){
				for(int m=0; m<targetVVD.size(); m++){
					if(addPortVO.getSkdDirCd().equals(targetVVD.get(m).getSkdDirCd())){
						prePortPos = m - 1;
						break;
					}
				}
			}

			// portPos 위치는 항상 prePortPos + 1 이후임
			portPos = prePortPos + 1;

			// targetVVD의 vvdPos, portPos+1 위치부터 Adding Port가 아닐때까지 검색한다.(다른 Adding된 Port가 있을 경우)
			// Adding Port가 없으면 vvdPos, portPos+1 위치에 삽입한다.
			// 기존 Adding Port가 있으면 추가할려는 Port(Yard)와 동일한지 확인하여 동일한 경우 해당 위치에 스케쥴 정보를 업데이트한다.(스케쥴이 없는 빈공간일것임)
			boolean addingComplete = false;
			
			for(int m=portPos; m<targetVVD.size(); m++){
				PortSkdOnLongRangeVO tmp = targetVVD.get(m);
				if(tmp.isEmptySkd()){
					//동일 adding port 인가
					if(
						tmp.getSkdDirCd().equals(addPortVO.getSkdDirCd()) &&
						tmp.getVpsPortCd().equals(addPortVO.getVpsPortCd()) && 
						tmp.getYdCd().equals(addPortVO.getYdCd())){
						
						addingComplete = true;
						tmpPortSkdGridData.get(vvdPos).set(m, addPortVO);
						break;
						
					}
				}
			}

			// 새로운 adding port 추가 ==> 그리드에서 Column이 추가되는 상황
			if(!addingComplete){
				PortSkdOnLongRangeVO empty = null;
				List<PortSkdOnLongRangeVO> tmp = null;
				empty = new PortSkdOnLongRangeVO();
				empty.setVslSlanCd(addPortVO.getVslSlanCd());
				empty.setPfSkdTpCd(addPortVO.getPfSkdTpCd());
				empty.setSkdDirCd(addPortVO.getSkdDirCd());
				empty.setVpsPortCd(addPortVO.getVpsPortCd());
				empty.setClptIndSeq(addPortVO.getClptIndSeq());
				empty.setYdCd(addPortVO.getYdCd());
				empty.setCallYdIndSeq(addPortVO.getCallYdIndSeq());
				empty.setClptSeq(addPortVO.getClptSeq());
				empty.setEmptySkd(true);
				for(int m=0; m<tmpPortSkdGridData.size(); m++){
					tmp = new ArrayList<PortSkdOnLongRangeVO>(tmpPortSkdGridData.get(m));
					if(m==vvdPos){
						tmp.add(portPos, addPortVO);
					}else{
						tmp.add(portPos, empty);
					}
					tmpPortSkdGridData.set(m, tmp);
				}
				
				// P/F 해당 위치에도 정보 추가
				PfSkdDetailVO addingPfSkdVO = new PfSkdDetailVO();
				addingPfSkdVO.setSkdDirCd(addPortVO.getSkdDirCd());
				addingPfSkdVO.setPortCd(addPortVO.getVpsPortCd());
				addingPfSkdVO.setClptSeq(addPortVO.getClptIndSeq());
				addingPfSkdVO.setYdCd(addPortVO.getYdCd());
				addingPfSkdVO.setCallYdIndSeq(addPortVO.getCallYdIndSeq());
				addingPfSkdVO.setEtbDyCd("*");
				addingPfSkdVO.setEtdDyCd("*");
				addingPfSkdVO.setEtbTmHrmnt("*");
				addingPfSkdVO.setEtdTmHrmnt("*");
				pfSkdDetailVOsByGroup.add(portPos, addingPfSkdVO);
				pfSkdDetailsByGroup.put(pfSkdKeyByGroup, pfSkdDetailVOsByGroup);
			}
		}

		// tmpPortSkdGridData 에서 시간이 역전된 포트를 설정한다.
		for(List<PortSkdOnLongRangeVO> vvd : tmpPortSkdGridData){
			String firstDirCd = null;
			int maxClptSeq = 1;
			for(PortSkdOnLongRangeVO portSkdOnLongRangeVO : vvd){
				if(portSkdOnLongRangeVO.isEmptySkd()){
					continue;
				}
				if(firstDirCd==null || !firstDirCd.equals(portSkdOnLongRangeVO.getSkdDirCd())){
					maxClptSeq = 1;
					firstDirCd = portSkdOnLongRangeVO.getSkdDirCd();
				}
				if(maxClptSeq > Integer.parseInt(portSkdOnLongRangeVO.getClptSeq())){
					portSkdOnLongRangeVO.setReverse(true);
				}else{
					maxClptSeq = Integer.parseInt(portSkdOnLongRangeVO.getClptSeq());
				}
			}
		}
		
		return tmpPortSkdGridData;
	}
	
	private PortSkdOnLongRangeVO findFirstSkd(List<PortSkdOnLongRangeVO> rowData){
		PortSkdOnLongRangeVO first = null;
		for(PortSkdOnLongRangeVO vo : rowData){
			if(vo.isEmptySkd() &&
					(vo.getVslCd()==null && vo.getSkdVoyNo()==null)
					){
				continue;
			}else{
				first = vo;
				break;
			}
		}
		return first;
	}
	
	private PortSkdOnLongRangeVO findLastSkd(List<PortSkdOnLongRangeVO> rowData){
		PortSkdOnLongRangeVO last = null;
		PortSkdOnLongRangeVO vo = null;
		for(int i=rowData.size()-1; i>=0; i--){
			vo = rowData.get(i);
			if(vo.isEmptySkd() &&
					(vo.getVslCd()==null && vo.getSkdVoyNo()==null)
					){
				continue;
			}else{
				last = vo;
				break;
			}
		}
		return last;
	}
	
	/**
	 * P/F 정보를 이용하여 초기상태의 Port 스케쥴 정보 배열을 생성한다.
	 * 
	 * @param List<PfSkdDetailVO> pfSkdDetailVOs
	 * @return PortSkdOnLongRangeVO[]
	 */
	private PortSkdOnLongRangeVO[] initSkdByPf(List<PfSkdDetailVO> pfSkdDetailVOs){
		PortSkdOnLongRangeVO[] portSkdArr = new PortSkdOnLongRangeVO[pfSkdDetailVOs.size()];
		PfSkdDetailVO pfSkdDetailVO = null;
		PortSkdOnLongRangeVO vo = null;
		for(int i=0; i<pfSkdDetailVOs.size(); i++){
			pfSkdDetailVO = pfSkdDetailVOs.get(i);
			vo = new PortSkdOnLongRangeVO();
			vo.setVslSlanCd(pfSkdDetailVO.getVslSlanCd());
			vo.setPfSkdTpCd(pfSkdDetailVO.getPfSvcTpCd());
			vo.setSkdDirCd(pfSkdDetailVO.getSkdDirCd());
			vo.setVpsPortCd(pfSkdDetailVO.getPortCd());
			vo.setClptIndSeq(pfSkdDetailVO.getClptSeq());
			vo.setYdCd(pfSkdDetailVO.getYdCd());
			vo.setCallYdIndSeq(pfSkdDetailVO.getCallYdIndSeq());
			vo.setClptSeq("");
			vo.setEmptySkd(true);
			portSkdArr[i] = vo;
		}
		return portSkdArr;
	}
	
	/**
	 * Port 스케쥴이 P/F 내에서 가지는 순서를 조회한다.
	 * 
	 * @param List<PfSkdDetailVO> pfSkdDetailVOs
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return int
	 */
	private int getHeaderIdx(List<PfSkdDetailVO> pfSkdDetailVOs, PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException {
		int idx = 0;
		boolean find = false;
		
		String pfEtbDtStr = null;
		String pfEtdDtStr = null;
		
		for(PfSkdDetailVO pfSkdDetailVO : pfSkdDetailVOs){
			if(
				portSkdOnLongRangeVO.getSkdDirCd().equals(pfSkdDetailVO.getSkdDirCd()) &&
				portSkdOnLongRangeVO.getVpsPortCd().equals(pfSkdDetailVO.getPortCd()) &&
				portSkdOnLongRangeVO.getYdCd().equals(pfSkdDetailVO.getYdCd()) //&&
			){
				
				pfEtbDtStr = VSKGeneralUtil.changeDateFormat(portSkdOnLongRangeVO.getPfEtbDt(), "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss");
				pfEtdDtStr = VSKGeneralUtil.changeDateFormat(portSkdOnLongRangeVO.getPfEtdDt(), "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss");
				
				// 1. Add Calling 으로 인해 VSK_VSL_POR_SKD.CLPT_IND_SEQ 와 VSK_PF_SKD_DTL.CLPT_SEQ 의 일치를 보장할 수 없다.
				// 2. Actual Port Skd로 인해 YD_CD가 업데이트 될 수 있다.
				//
				// 1과 2에 이유에 따라,
				// PORT_CD와 ETB_TM_HRMNT, ETD_TM_HRMNT 값이 일치하는 경우에만 P/F 와 일치. 그 index을 찾는 것으로 한다. 
				if(pfEtbDtStr.length()==14 && pfEtdDtStr.length()==14){
					if(
							pfEtbDtStr.substring(8, 12).equals(pfSkdDetailVO.getEtbTmHrmnt()) &&
							pfEtdDtStr.substring(8, 12).equals(pfSkdDetailVO.getEtdTmHrmnt())
					){
						find = true;
						break;
					}
				}
				
			}
			idx++;
		}
		if(find){
			return idx;
		}else{
			// 현재 Port 스케쥴 이전 Calling Port 들 중에 동일 포트가 Adding 된 경우, CLPT_IND_SEQ가 증가하게 되므로 P/F 정보를 찾을 수가 없다.
			// 따라서, CLPT_IND_SEQ를 감소시킨 후에 찾아본다.
			// 감소시킨 CLPT_IND_SEQ가 0이 되는 경우, 해당 Port 스케쥴을 찾을 수 없는 경우이므로 -1을 리턴한다.
		
			return -1;
		}
	}
	

//	/**
//	 * VVD 삭제 history를 남긴다.
//	 * 
//	 * @param VskVslSkdHisVO vskVslSkdHisVO
//	 * @exception EventException
//	 */
//	private void addVskVslSkdDelHis(VskVslSkdHisVO vskVslSkdHisVO) throws EventException {
//		try{
//			dbDao.addVskVslSkdDelHis(vskVslSkdHisVO);	
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		}
//	}
	
	/**
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param PfLaneTypeVO pfLaneTypeVO
	 * @return List<PfLaneTypeVO>
	 * @exception EventException
	 */
	public List<PfLaneTypeVO> searchPfLaneTypeList(PfLaneTypeVO pfLaneTypeVO) throws EventException {
		try {
			return dbDao.searchPfLaneTypeList(pfLaneTypeVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * VVD이 Booking 상태를 검증합니다.<br>
	 * 
	 * @param SimulationVvdCheckVO simulationVvdCheckVO
	 * @return List<VvdBkgStsVO>
	 * @exception EventException
	 */
	public List<VvdBkgStsVO> checkBkgStsByVvd(SimulationVvdCheckVO simulationVvdCheckVO) throws EventException {
		try {
			
			List<VvdBkgStsVO> vvdBkgStsVOs = new ArrayList<VvdBkgStsVO>();
			VvdBkgStsVO vo = null;
			
			String vslCd = simulationVvdCheckVO.getVslCd();
			String skdVoyNo = simulationVvdCheckVO.getSkdVoyNo();
			String startDate = simulationVvdCheckVO.getStartDate();
			String endDate = simulationVvdCheckVO.getEndDate();
			String vslCnt = simulationVvdCheckVO.getVslCnt();
			String voyNoType = simulationVvdCheckVO.getVoyNoType();
			String skdDirCd1 = simulationVvdCheckVO.getSkdDirCd1();
			String skdDirCd2 = simulationVvdCheckVO.getSkdDirCd2();
			String duration = simulationVvdCheckVO.getDuration();
			
			int iDuration = "".equals(VSKGeneralUtil.getCheckNullToString(duration))?0:Integer.parseInt(duration);
			int iSkdVoyNo = Integer.parseInt(skdVoyNo);
			int iVslCnt = "".equals(VSKGeneralUtil.getCheckNullToString(vslCnt))?0:Integer.parseInt(vslCnt);
			
			if(iDuration!=0){
				endDate = VSKGeneralUtil.changeDateFormat(endDate, "yyyy-MM-dd", "yyyyMMdd");
				
				String doingDate = startDate;
				
				while(doingDate.compareTo(endDate)<=0){
					// 1st Direction VVD
					vo = new VvdBkgStsVO();
					vo.setVslCd(vslCd);
					vo.setSkdVoyNo(VSKGeneralUtil.getVoyNo(skdVoyNo));
					vo.setSkdDirCd(skdDirCd1);
					
					if("1".equals(voyNoType)){
						iSkdVoyNo = iSkdVoyNo + 1;
						skdVoyNo = Integer.toString(iSkdVoyNo);
					}
					vvdBkgStsVOs.add(vo);
					
					// 2nd Direction VVD
					vo = new VvdBkgStsVO();
					vo.setVslCd(vslCd);
					vo.setSkdVoyNo(VSKGeneralUtil.getVoyNo(skdVoyNo));
					vo.setSkdDirCd(skdDirCd2);
					
					doingDate = VSKGeneralUtil.getActionDate(doingDate, iDuration);
					
					if("0".equals(voyNoType)){
						iSkdVoyNo = iSkdVoyNo + 1;
						skdVoyNo = Integer.toString(iSkdVoyNo);
					}else if("1".equals(voyNoType)){
						iSkdVoyNo = iSkdVoyNo + 1;
						skdVoyNo = Integer.toString(iSkdVoyNo);
					}else if("2".equals(voyNoType)){
						iSkdVoyNo = iSkdVoyNo + iVslCnt;
						skdVoyNo = Integer.toString(iSkdVoyNo);
					}
					vvdBkgStsVOs.add(vo);
				}	
			}
			
			return dbDao.checkBkgStsByVvd(vvdBkgStsVOs);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * VOP_VSK_0113 에 대한 Retrieve 기능 - 이용준 추가 2014.07.15
	 * @param CstSkdByPortVO cstSkdByPortVO
	 * @return List<CstSkdByPortVO>
	 * @exception EventException
	 * @author 이용준
	 */
	public List<CstSkdByPortVO> searchCstSkdByPort(CstSkdByPortVO cstSkdByPortVO) throws EventException {
		try {
			return dbDao.searchCstSkdByPort(cstSkdByPortVO);
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