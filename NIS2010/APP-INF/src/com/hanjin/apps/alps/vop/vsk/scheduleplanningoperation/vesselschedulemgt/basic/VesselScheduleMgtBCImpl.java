/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VesselScheduleMgtBCImpl.java
 *@FileTitle : VSL SKD Delete & Closing
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.02.12
 *@LastModifier : 정상기
 *@LastVersion : 1.0
 * 2009.05.04 서창열
 * 1.0 Creation
 *
 * History
 * 2010.08.17 CHM-201005255-01 유혁 <<20100817_01>>
 * 									AUTO UPDATE 시 어느 순간(ETA/ETB/ETD)에 회복(EST==PF)이 되면
 * 									그 이후 스케쥴은 계산할 필요없이 무조건 PF로 적용한다.
 *
 * 2010.09.10 CHM-201005742-01 유혁 Non-Weekly P/F SKD 생성을 위해 DY_NO 동일 체크는 제거한다.
 * 2010.09.27 SRM-201008966 진마리아 EDI의 전화번호 항목을 사용자 모바일 폰 번호에서 사무실 전화번호로 수정한다.
 * 2010.10.04 CHM-201006129-01 유혁 ALPS SKD 생성시 KTNET I/F 확인요청
 * 2010.10.28 CHM-201006456-01 유혁 SKD Auto Update 기능 보완. ERP 전송 로그 내역 기록
 * 2010.11.24 CHM-201007341-01 이석준 Actual SKD ERP I/F 로직 변경
 * 2010.12.08 CHM-201007135-01 진마리아 Actaul Carrier update 로직 변경 요청건
 * 2010.12.27 CHM-201007036-01 진마리아 Down Excel Format 변경 요청건
 * 2011.02.08 CHM-201108759-01 진마리아 Long Rane Inquiry 화면 조회 로직 변경
 * 2011.04.11 CHM-201109577-01 진마리아 Delete Vessel Code에 대한 조회 로직 보완
 * 2011.06.27 CHM-201111838-01 진마리아 소스품질 결함수정 - 문자열 비교는 문자열 비교 메소드를 사용해야 한다.
 * 2011.08.09 CHM-201111568-01 진마리아 [VOP-VSK] LRS SKD inquiry 화면 및 로직 수정 요청건
 * 2011.10.26 CHM-201114112-01 김민아   VSL SKD History Inquiry 화면 로직 변경
 * 2011.11.22 CHM-201114674-01 진마리아 [VOP_VSK] C/SKD Update 로직 수정
 * 2012.05.14 CHM-201217742-01 진마리아 PF 사용하여 SKD 생성시 DELETE YARD 제어 로직 추가
 * 2012.05.24 CHM-201217916-01 이준범   스케줄 History 로직 변경
 * 2012.08.16 선반영           이혜민   Vessel Schedule ERP 인터페이스누락 로직수정(Service Lane Code 누락수정)
 * 2012.08.21 CHM-201219792-01 이혜민   Actual Schedule 입력에 따른 Auto Update 처리시 대상VVD 추출로직수정
 * 2012.10.05 R4J 결함 수정(rule upgrade)
 * 2012.10.24 CHM-201220527-01 진마리아 Departure/Noon Report 데이터를 FCM 데이터와 I/F하도록 변경 요청
 * 2012.11.28 CHM-201220890-01 진마리아 double calling port 에 대한 virtual port calling seq. 수정
 * 2012.12.03 [긴급반영] 진마리아 2012.11.28 로직 원복
 * 2012.12.12 김상수 [CHM-201221818-01] VVD SKD INTERFACE TO ERP 보완 요청
 * 2012.12.18 김상수 [CHM-201221884-01] CNTR 진행기준 대상항차 선정기능 보완
 * 2013.02.12 정상기 [CHM-201221671] VVD Sked EDI (Daily Berth Window Update) 전송시 lane담당자 정보 F/F 반영
 * 2013.04.26 정상기 [CHM-201324261] Split 01-선박 스케줄 지연시 Notice 메일링 기능 개발건에 대한 추가 수정 요청. 
 * 2013.09.10 정상기 [CHM-201325067]   [VOP-VSK] 스케줄 변경 시 개인별 설정 시간에 따라 개별 메일 통지 기능
 * 2015.08.12 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
 * 2015.09.04 이병훈 [CHM-201537542] Yarc Code 말풍선 도움말 기능 지원
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic;

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

import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration.VesselScheduleMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration.VesselScheduleMgtEAIDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActualSkdBySimNoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgCllCngNtfyUserLaneInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgListByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalBnkSavVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalTransitTargetVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdBerthWdoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPolPodVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdHisByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdSimDtlCalcInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.EdiMsgToDLSVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ErpMsgFns017VO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PfSkdDetailVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ReversedPortInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SimulationVvdCheckVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SkipPortGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VskVslSkdPhsIoHisVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHisDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHisVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHistGroupVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdHisInVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdRepeatErpIfVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdCheckVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdPortTariffVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.hanjin.syscommon.common.table.VskCustEdiLogVO;
import com.hanjin.syscommon.common.table.VskCustSkdEdiSetVO;
import com.hanjin.syscommon.common.table.VskDepRptVO;
import com.hanjin.syscommon.common.table.VskHydrstMtxVO;
import com.hanjin.syscommon.common.table.VskPortDistVO;
import com.hanjin.syscommon.common.table.VskPortTideVO;
import com.hanjin.syscommon.common.table.VskSwapCstPortVO;
import com.hanjin.syscommon.common.table.VskSwapCstSimVO;
import com.hanjin.syscommon.common.table.VskSwapCstVvdVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;


/**
 * NIS2010-SchedulePlanningOperation Business Logic Basic Command implementation<br>
 * - NIS2010-SchedulePlanningOperation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SEO CHANG YUL
 * @see UI_VSK-0018EventResponse,VesselScheduleMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */ 
 
public class VesselScheduleMgtBCImpl extends BasicCommandSupport implements
		CoastalScheduleMgtBC, LongRangeScheduleMgtBC { 

	// Database Access Object
	private transient VesselScheduleMgtDBDAO 		dbDao 	= null;
	private transient VesselScheduleMgtEAIDAO 		eaiDao 	= null;
	
//	private transient ActualScheduleMgtDBDAO		dbDao2 	= null;

	/**
	 * VesselScheduleMgtBCImpl 객체 생성<br>
	 * VesselScheduleMgtDBDAO를 생성한다.<br>
	 */
	public VesselScheduleMgtBCImpl() {
		dbDao 	= new VesselScheduleMgtDBDAO		();
		eaiDao 	= new VesselScheduleMgtEAIDAO		();
	}

	/**
	 * 해당 Lane의 Vessel Schedule 리스트 정보를 조회합니다.<br>
	 *
	 * @param ActivationVvdVO activationVvdVO
	 * @return List<ActivationVvdVO>
	 * @exception EventException
	 */
	public List<ActivationVvdVO> searchVslSkdListByLane(ActivationVvdVO activationVvdVO) throws EventException {
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
	 * @param String sFromEventSystem
	 * @exception EventException
	 */
	public void removeCstSkdByVvd(
			ActivationVvdVO[] activationVvdVO1s,
			ActivationVvdVO[] activationVvdVO2s,
			VskVslSkdHisVO vskVslSkdHisVO,
			SignOnUserAccount account,
			String sFromEventSystem) throws EventException{
		
		String sCnvtFromEventSystem	= "";
		
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

				if(			"DELETE_LRS_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0010)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_DeletedGroupVVD_NoneBKG(VOP_VSK_0010)";
				}else if(	"DELETE_LRS_Feeder_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0054)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_Feeder_DeletedGroupVVD_NoneBKG(VOP_VSK_0054)";
				}else if(	"DELETE_CST_DeletionVvd_OnNoneBKG(VOP_VSK_0018)"			.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_NoneBKG(VOP_VSK_0018)";
				}else if(	"DELETE_CST_Feeder_DeletionVvd_OnNoneBKG(VOP_VSK_0059)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_Feeder_DeletionVvd_NoneBKG(VOP_VSK_0059)";
				}else if(	"DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)";
				}else{
					sCnvtFromEventSystem	= "";
				}
				
				// VVD Delete
				removeCstSkdByVvd(activationVvdVO1s, account, sCnvtFromEventSystem);
				////hmVskVslSkdVOs.put("DELETE_DeletionVvd_NoneBKG", vskVslSkdVOs);

			// Booking 정보가 있는 VVD를 삭제하는 경우
			// VOP_VSK_0249 에서 Booking 정보가 있는 VVD(화면에 리스트 출력된 VVD)에 대해 거래를 실행한 경우
			}else{

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

				if(			"DELETE_LRS_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0010)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_DeletedGroupVVD_NoneBKG(VOP_VSK_0010)";
				}else if(	"DELETE_LRS_Feeder_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0054)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_Feeder_DeletedGroupVVD_NoneBKG(VOP_VSK_0054)";
				}else if(	"DELETE_CST_DeletionVvd_OnNoneBKG(VOP_VSK_0018)"			.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_NoneBKG(VOP_VSK_0018)";
				}else if(	"DELETE_CST_Feeder_DeletionVvd_OnNoneBKG(VOP_VSK_0059)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_Feeder_DeletionVvd_NoneBKG(VOP_VSK_0059)";
				}else if(	"DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)";
				}else{
					sCnvtFromEventSystem	= "";
				}
				
				// Booking이 걸려있는 않는 VVD Delete
				removeCstSkdByVvd(activationVvdVO1s, account, sCnvtFromEventSystem);
				////hmVskVslSkdVOs.put("DELETE_DeletionVvd_NoneBKG", vskVslSkdVOs);

				if(			"DELETE_LRS_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0010)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_DeletedGroupVVD_OnBKG(VOP_VSK_0010)";
				}else if(	"DELETE_LRS_Feeder_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0054)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_Feeder_DeletedGroupVVD_OnBKG(VOP_VSK_0054)";
				}else if(	"DELETE_CST_DeletionVvd_OnNoneBKG(VOP_VSK_0018)"			.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_OnBKG(VOP_VSK_0018)";
				}else if(	"DELETE_CST_Feeder_DeletionVvd_OnNoneBKG(VOP_VSK_0059)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_Feeder_DeletionVvd_OnBKG(VOP_VSK_0059)";
				}else if(	"DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)";
				}else{
					sCnvtFromEventSystem	= "";
				}
				
				// Booking이 걸려있는 VVD Delete
				removeCstSkdByVvd(activationVvdVO2s, vskVslSkdHisVO, sFromEventSystem);
				////hmVskVslSkdVOs.put("DELETE_DeletionVvd_OnBKG", vskVslSkdVOs2);

			}

			/****************************************************************
			 * 운항스케쥴 이력관리를 위한 VO or VO List Return ::2013-08-28::
			 */
			////return	hmVskVslSkdVOs;
			
		} catch (EventException e) {
			log.error("err " + e.toString(), e);
			throw e;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		}
	}

	/**
	 * 해당 스케쥴을 삭제합니다.
	 *
	 * @param ActivationVvdVO[] activationVvdVOs
	 * @param SignOnUserAccount account
	 * @param String sFromEventSystem
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	private void removeCstSkdByVvd(ActivationVvdVO[] activationVvdVOs, SignOnUserAccount account, String sFromEventSystem) throws EventException {

		if(activationVvdVOs==null || activationVvdVOs.length==0){
			return;
		}

		List<VskVslSkdVO>	vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
		
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
				List<VvdVO> rePreNextCstVoList = new ArrayList<VvdVO>();
				//전차수 로우 하나와 후차수 로우 하나만 리턴된다
				rePreNextCstVoList = dbDao.searchConnectVvdSim(paramVO);

				for(int l = 0; l < rePreNextCstVoList.size(); l++){
					String tempCstTurnCd = rePreNextCstVoList.get(l).getTurnPortIndCd();
					if(tempCstTurnCd.equals("N") || tempCstTurnCd.equals("Y")){
						dbDao.removeVskSwapCstPortByPreVvd(rePreNextCstVoList.get(l));

//						===================================================================================
						//VSK_SWAP_CST_PORT 삭제하기 위하여 추가 및 수정 2009.06.30 정진우
						VskSwapCstPortVO vskSwapCstPortVO = new VskSwapCstPortVO();
						vskSwapCstPortVO.setVslCd(rePreNextCstVoList.get(l).getVslCd());
						vskSwapCstPortVO.setSkdVoyNo(rePreNextCstVoList.get(l).getSkdVoyNo());
						vskSwapCstPortVO.setSkdDirCd(rePreNextCstVoList.get(l).getSkdDirCd());
						dbDao.removeVskSwapCstPort(vskSwapCstPortVO);
//						===================================================================================
					}else if(tempCstTurnCd.equals("D") || tempCstTurnCd.equals("V") || tempCstTurnCd.equals("F")){
						dbDao.modifyVskSwapCstPort (rePreNextCstVoList.get(l));
					}
				}

				//SIM_DT,SIM_NO을 담을  VO
				List<VskSwapCstSimVO> reCstSimVoList = new ArrayList<VskSwapCstSimVO>();
				//VSK_SWAP_CST_SIM TABLE을 지우기 위해
				//SIM_DT,SIM_NO을 가져온다
				reCstSimVoList = dbDao.searchSimNoVskSwapCstVvd(paramVO);

//				===================================================================================
				//VSK_SWAP_CST_VVD 삭제하기 위하여 추가 및 수정 2009.06.30 정진우
				VskSwapCstVvdVO vskSwapCstVvdVO = new VskSwapCstVvdVO();
				vskSwapCstVvdVO.setVslCd(paramVO.getVslCd());
				vskSwapCstVvdVO.setSkdVoyNo(paramVO.getSkdVoyNo());
				vskSwapCstVvdVO.setSkdDirCd(paramVO.getSkdDirCd());
				dbDao.removeVskSwapCstVvd(vskSwapCstVvdVO);
//				===================================================================================
				dbDao.removeVskSwapCstRmk (paramVO);

				int cnt = 0;
				for(int m=0; m < reCstSimVoList.size(); m++){
					cnt = dbDao.searchVskSwapCstVvdCount(reCstSimVoList.get(i));
					if(cnt == 0){
						dbDao.removeVskSwapCstSim(reCstSimVoList.get(i));
					}
				}

				dbDao.removeVskVslPortSkdByVvd(paramVO);
				

				////List<VskVslSkdVO> vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
				VskVslSkdVO	vskVslSkdVO	= new VskVslSkdVO();
				vskVslSkdVO.setVslCd	(paramVO.getVslCd		());
				vskVslSkdVO.setSkdVoyNo	(paramVO.getSkdVoyNo	());
				vskVslSkdVO.setSkdDirCd	(paramVO.getSkdDirCd	());
				vskVslSkdVO.setUpdUsrId	(account.getUsr_id		());
				vskVslSkdVOs.add		(vskVslSkdVO);
				
				/*** :: Deleted VVD의 이력데이터 생성로직추가 ::
				 * 		TABLE NAME	: VSK_VSL_SKD_CNG_HIS
				 * 		로직추가일자	: 2013-06-18
				 * 		List<VskVslSkdVO> vskVslSkdVOs
				 ***/
				this.createVskVslSkdChangeHistoryMstOnly(vskVslSkdVOs, sFromEventSystem);	
				
				dbDao.removeVskVslSkdByVvd			(paramVO);

				VskVslSkdHisVO vskVslSkdDelHisVO = new VskVslSkdHisVO();
				vskVslSkdDelHisVO.setBfrVslSlanCd	(activationVvdVOs[i].getVslSlanCd());
				vskVslSkdDelHisVO.setBfrVslCd		(activationVvdVOs[i].getVslCd());
				vskVslSkdDelHisVO.setBfrSkdVoyNo	(activationVvdVOs[i].getSkdVoyNo());
				vskVslSkdDelHisVO.setBfrSkdDirCd	(activationVvdVOs[i].getSkdDirCd());
				vskVslSkdDelHisVO.setCreUsrId		(activationVvdVOs[i].getCreUsrId());
				vskVslSkdDelHisVO.setUpdUsrId		(activationVvdVOs[i].getUpdUsrId());

				addVskVslSkdDelHis					(vskVslSkdDelHisVO);

			}
			
			/****************************************************************
			 * 운항스케쥴 이력관리를 위한 VO or VO List Return ::2013-08-28::
			 */
			////return vskVslSkdVOs;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		}

	}

	/**
	 * 해당 스케쥴을 삭제하고 history를 남깁니다.
	 *
	 * @param ActivationVvdVO[] activationVvdVOs
	 * @param VskVslSkdHisVO vskVslSkdHisVO
	 * @param String sFromEventSystem
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	private void removeCstSkdByVvd(ActivationVvdVO[] activationVvdVOs, VskVslSkdHisVO vskVslSkdHisVO, String sFromEventSystem) throws EventException {

		if(activationVvdVOs==null || activationVvdVOs.length==0){
			return;
		}
		
		try{

			for(int i=0; i<activationVvdVOs.length; i++){

				// Booking 이 연결되어 있는 스케줄은 SC에서 null로 변경하여 구분할 수 있도록 하였다.
				// 따라서 null 인 경우는 처리하지 않는다.
				if(activationVvdVOs[i]==null) continue;

				vskVslSkdHisVO.setBfrVslSlanCd(activationVvdVOs[i].getVslSlanCd());
				vskVslSkdHisVO.setBfrVslCd(activationVvdVOs[i].getVslCd());
				vskVslSkdHisVO.setBfrSkdVoyNo(activationVvdVOs[i].getSkdVoyNo());
				vskVslSkdHisVO.setBfrSkdDirCd(activationVvdVOs[i].getSkdDirCd());
				vskVslSkdHisVO.setVskdTpCd("M");
				vskVslSkdHisVO.setVskdCngTpCd("V");
				vskVslSkdHisVO.setCreUsrId(activationVvdVOs[i].getCreUsrId());
				vskVslSkdHisVO.setUpdUsrId(activationVvdVOs[i].getCreUsrId());

				VvdVO paramVO = new VvdVO();
				paramVO.setVslCd(activationVvdVOs[i].getVslCd());
				paramVO.setSkdVoyNo(activationVvdVOs[i].getSkdVoyNo());
				paramVO.setSkdDirCd(activationVvdVOs[i].getSkdDirCd());

				//자신에 VVD와 연결되는 VSL_PORT의 Pre-VVD와 Next-VVD 정보를 찾아 온다.
				List<VvdVO> rePreNextVoList = new ArrayList<VvdVO>();
				//전차수 로우 하나와 후차수 로우 하나만 리턴된다
				rePreNextVoList = dbDao.searchConnectVvd(paramVO);

				//k == 0이면 전차수 삭제 및 이력 추가 ,k ==1 이면 후차수 update
				for(int k=0; k<rePreNextVoList.size(); k++){
					String tempTurnCd = rePreNextVoList.get(k).getTurnPortIndCd();

					if(tempTurnCd.equals("N") || tempTurnCd.equals("Y")){

						// Virtual Port에 Booking이 연결되어 있는 경우 : "VIR"
						// 현재 VVD, Virtual Port 모두에 Booking이 연결되어 있는 경우 : "ALL":
						// history를 남긴다.
						if("VIR".equals(activationVvdVOs[i].getHisflag()) || "ALL".equals(activationVvdVOs[i].getHisflag())){
							List<VskVslSkdHisVO> podYardList = new ArrayList<VskVslSkdHisVO>();
							podYardList = dbDao.checkPreVvdBkgPodYard(rePreNextVoList.get(k));
							if(podYardList.size() != 0){
								for(int j=0; j < podYardList.size(); j++){
									VskVslSkdHisVO hisVO = podYardList.get(j);
									hisVO.setVskdTpCd("M");
									hisVO.setVskdCngTpCd("D");
									hisVO.setCreUsrId(activationVvdVOs[i].getCreUsrId());
									hisVO.setUpdUsrId(activationVvdVOs[i].getCreUsrId());
									hisVO.setAftVslSlanCd(vskVslSkdHisVO.getAftVslSlanCd());
									hisVO.setAftVslCd(vskVslSkdHisVO.getAftVslCd());
									hisVO.setAftSkdVoyNo(vskVslSkdHisVO.getAftSkdVoyNo());
									hisVO.setAftSkdDirCd(vskVslSkdHisVO.getAftSkdDirCd());
									hisVO.setAftVpsPortCd(vskVslSkdHisVO.getAftVpsPortCd());
									hisVO.setAftClptIndSeq(vskVslSkdHisVO.getAftClptIndSeq());

									String tempRemark = vskVslSkdHisVO.getDiffRmk()
																+ "/Deleted Virtual Port by Turning Port["
																+ activationVvdVOs[i].getVslCd()
																+ activationVvdVOs[i].getSkdVoyNo()
																+ activationVvdVOs[i].getSkdDirCd()+ "]";
									hisVO.setDiffRmk(tempRemark);
									dbDao.addVslSkdHis(hisVO);
								}
							}
						}

						dbDao.removeVskVslPortSkdByPreVvd(rePreNextVoList.get(k));
					}else if(tempTurnCd.equals("D") || tempTurnCd.equals("V") || tempTurnCd.equals("F")){
						dbDao.modifyVskVslPortSkdNextTurnPort (rePreNextVoList.get(k));
					}
				}  

				//현재 VVD에 대한 Booking이 연결되어 있는 경우 history를 남긴다.
				if("VVD".equals(activationVvdVOs[i].getHisflag()) || "ALL".equals(activationVvdVOs[i].getHisflag())){
					dbDao.addVslSkdHis(vskVslSkdHisVO);
				}

				//자신에 VVD와 연결되는 SWAP_CST_PORT의 Pre-VVD와 Next-VVD 정보를 찾아 온다.
				List<VvdVO> rePreNextCstVoList = new ArrayList<VvdVO>();
				//전차수 로우 하나와 후차수 로우 하나만 리턴된다
				rePreNextCstVoList = dbDao.searchConnectVvdSim(paramVO);

				for(int l = 0; l < rePreNextCstVoList.size(); l++){
					String tempCstTurnCd = rePreNextCstVoList.get(l).getTurnPortIndCd();
					if(tempCstTurnCd.equals("N") || tempCstTurnCd.equals("Y")){
						dbDao.removeVskSwapCstPortByPreVvd(rePreNextCstVoList.get(l));

//						===================================================================================
						//VSK_SWAP_CST_PORT 삭제하기 위하여 추가 및 수정 2009.06.30 정진우
						VskSwapCstPortVO vskSwapCstPortVO = new VskSwapCstPortVO();
						vskSwapCstPortVO.setVslCd(rePreNextCstVoList.get(l).getVslCd());
						vskSwapCstPortVO.setSkdVoyNo(rePreNextCstVoList.get(l).getSkdVoyNo());
						vskSwapCstPortVO.setSkdDirCd(rePreNextCstVoList.get(l).getSkdDirCd());
						dbDao.removeVskSwapCstPort(vskSwapCstPortVO);
//						===================================================================================
					}else if(tempCstTurnCd.equals("D") || tempCstTurnCd.equals("V") || tempCstTurnCd.equals("F")){
						dbDao.modifyVskSwapCstPort (rePreNextCstVoList.get(l));
					}
				}

				//SIM_DT,SIM_NO을 담을  VO
				List<VskSwapCstSimVO> reCstSimVoList = new ArrayList<VskSwapCstSimVO>();
				//VSK_SWAP_CST_SIM TABLE을 지우기 위해
				//SIM_DT,SIM_NO을 가져온다
				reCstSimVoList = dbDao.searchSimNoVskSwapCstVvd(paramVO);

//				===================================================================================
				//VSK_SWAP_CST_VVD 삭제하기 위하여 추가 및 수정 2009.06.30 정진우
				VskSwapCstVvdVO vskSwapCstVvdVO = new VskSwapCstVvdVO();
				vskSwapCstVvdVO.setVslCd	(paramVO.getVslCd	());
				vskSwapCstVvdVO.setSkdVoyNo	(paramVO.getSkdVoyNo());
				vskSwapCstVvdVO.setSkdDirCd	(paramVO.getSkdDirCd());
				dbDao.removeVskSwapCstVvd	(vskSwapCstVvdVO);
//				===================================================================================
				dbDao.removeVskSwapCstRmk (paramVO);

				int cnt = 0;
				for(int m=0; m < reCstSimVoList.size(); m++){
					cnt = dbDao.searchVskSwapCstVvdCount(reCstSimVoList.get(i));
					if(cnt == 0){
						dbDao.removeVskSwapCstSim(reCstSimVoList.get(i));
					}
				}

				dbDao.removeVskVslPortSkdByVvd(paramVO);

				List<VskVslSkdVO> 	vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
				VskVslSkdVO			vskVslSkdVO		= new VskVslSkdVO();
				vskVslSkdVO.setVslCd	(paramVO.getVslCd	());
				vskVslSkdVO.setSkdVoyNo	(paramVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd	(paramVO.getSkdDirCd());
				vskVslSkdVOs.add		(vskVslSkdVO);
				
				/*** :: Deleted VVD의 이력데이터 생성로직추가 ::
			      *   TABLE NAME : VSK_VSL_SKD_CNG_HIS
			      *   로직추가일자 : 2013-06-18
			      ***/
			    this.createVskVslSkdChangeHistoryMstOnly(vskVslSkdVOs, sFromEventSystem);
				
				dbDao.removeVskVslSkdByVvd			(paramVO);

				VskVslSkdHisVO vskVslSkdDelHisVO 	= new VskVslSkdHisVO();
				vskVslSkdDelHisVO.setBfrVslSlanCd	(vskVslSkdHisVO.getBfrVslSlanCd());
				vskVslSkdDelHisVO.setBfrVslCd		(vskVslSkdHisVO.getBfrVslCd());
				vskVslSkdDelHisVO.setBfrSkdVoyNo	(vskVslSkdHisVO.getBfrSkdVoyNo());
				vskVslSkdDelHisVO.setBfrSkdDirCd	(vskVslSkdHisVO.getBfrSkdDirCd());
				vskVslSkdDelHisVO.setCreUsrId		(vskVslSkdHisVO.getCreUsrId());
				vskVslSkdDelHisVO.setUpdUsrId		(vskVslSkdHisVO.getUpdUsrId());

				addVskVslSkdDelHis					(vskVslSkdDelHisVO);

			}
			
			/****************************************************************
			 * 운항스케쥴 이력관리를 위한 VO or VO List Return ::2013-08-28::
			 */
			////return vskVslSkdVOs;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		} catch (EventException ex){
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		}

	}

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
				3 : Direction (ADD One) + Sequence
			*/
			voyNoType = (voyNoType==null || "".equals(voyNoType))?"0":voyNoType;
			int iVoyNoType = Integer.parseInt(voyNoType);

			/* voy_no_type을 2로 설정한 경우(Sequence 타입) VSL_COUNT가 0 이면 사용자가 입력한 Vessel 갯수를 사용한다 */
			if(iVoyNoType==2 && iVslCount==0 ){
				iVslCount = vslValues.size();
			}else if( iVoyNoType==3 ){
				if(  iVslCount==0 ){
					iVslCount = 2*vslValues.size();
				}
				else{
					iVslCount = 2*iVslCount;
				}
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
						}else if(iVoyNoType==3){
							String voyNo1 = VSKGeneralUtil.getVoyNo(voyNo[pos]);
							String voyNo2 = VSKGeneralUtil.nextVoyNo(voyNo[pos], 1);
							skdVO.setVoyNo(voyNo1 + "/" + voyNo2);
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
				}else if(iVoyNoType==3){
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
								skdVO.setPhsIoRsnCd(skdCngStsCd.substring(2,3));
								skdVO.setPortSkpTpCd(skdCngStsCd.substring(5));
								skdCngStsCd = "O";
							}

							if(skdCngStsCd.startsWith("I:")){
								skdVO.setPhsIoRsnCd(skdCngStsCd.substring(2,3));
								skdVO.setPortSkpTpCd(skdCngStsCd.substring(5));
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
				VskVslSkdVO 		vo = new VskVslSkdVO();
				vo.setVslCd			(vslSkdVO.getVslCd				());
				vo.setSkdVoyNo		(vslSkdVO.getSkdVoyNo			());
				vo.setSkdDirCd		(vslSkdVO.getSkdDirCd			());
				
				//log.info("\n\n ::jskjskjsk:: vslSkdVO.vsl_cd ["+vslSkdVO.getVslCd()+"]");
				//log.info("\n\n ::jskjskjsk:: vslSkdVO.skd_voy_no ["+vslSkdVO.getSkdVoyNo()+"]");
				//log.info("\n\n ::jskjskjsk:: vslSkdVO.skd_dir_cd ["+vslSkdVO.getSkdDirCd()+"]");
				
				vo.setVslSlanCd		(vslSkdVO.getSlanCd				());
				vo.setSkdStsCd		(vslSkdVO.getSkdStsCd			());
				vo.setSkdUsdIndCd	("H");
				vo.setPfSkdTpCd		(longRangeSkdGRPVO.getPfSvcTpCd	());
				vo.setStPortCd		(vslSkdVO.getStPortCd			());
				vo.setN1stPortBrthDt(vslSkdVO.getN1stPortBrthDt		());
				vo.setCoCd			("H");
				vo.setSkdRmk		(vslSkdVO.getSkdRmk				());
				vo.setCreUsrId		(longRangeSkdGRPVO.getCreUsrId	());
				vo.setUpdUsrId		(longRangeSkdGRPVO.getUpdUsrId	());
				vo.setPsdoVvdCd		(vslSkdVO.getPsdoVvdCd			());
				vskVslSkdList.add	(vo);
			}

			dbDao.addVskVslSkd(vskVslSkdList);				// VSK_VSL_SKD
			
			longRangeSkdGRPVO.setVskVslSkdList(vskVslSkdList);

			List<VslPortSkdVO> vskVslPortSkdList = new ArrayList<VslPortSkdVO>();
			for(VskSwapCstPortVO portSkdVO : portSkdList){

				if(portSkdVO.getInitEtaDt() == null){
					continue;
				}

				VslPortSkdVO vo = new VslPortSkdVO();

				vo.setVslCd				(portSkdVO.getVslCd());
				vo.setSkdVoyNo			(portSkdVO.getSkdVoyNo());
				vo.setSkdDirCd			(portSkdVO.getSkdDirCd());
				vo.setVpsPortCd			(portSkdVO.getVpsPortCd());
				vo.setNewClptIndSeq		(portSkdVO.getClptIndSeq());
				vo.setClptSeq			(portSkdVO.getClptSeq());
				vo.setSlanCd			(portSkdVO.getSlanCd());
				vo.setPortSkdStsCd		(portSkdVO.getPortSkdStsCd());
				vo.setYdCd				(portSkdVO.getYdCd());
				vo.setCallYdIndSeq		(portSkdVO.getCallYdIndSeq());
				vo.setPfEtaDt			(portSkdVO.getPfEtaDt());
				vo.setPfEtbDt			(portSkdVO.getPfEtbDt());
				vo.setPfEtdDt			(portSkdVO.getPfEtdDt());
				vo.setInitEtaDt			(portSkdVO.getInitEtaDt());
				vo.setInitEtbDt			(portSkdVO.getInitEtbDt());
				vo.setInitEtdDt			(portSkdVO.getInitEtdDt());
				vo.setVpsEtaDt			(portSkdVO.getVpsEtaDt());
				vo.setVpsEtbDt			(portSkdVO.getVpsEtbDt());
				vo.setVpsEtdDt			(portSkdVO.getVpsEtdDt());
				vo.setPortSkpTpCd		(portSkdVO.getPortSkpTpCd());
				vo.setPortSkpRsnCd		(portSkdVO.getPortSkpRsnCd());
				vo.setPortSkpRsnOffrRmk	(portSkdVO.getPortSkpRsnOffrRmk());
				vo.setTtlDlayHrs		(portSkdVO.getTtlDlayHrs());
				vo.setTsPortCd			(portSkdVO.getTsPortCd());
				vo.setUsdFlg			(portSkdVO.getUsdFlg());
				vo.setNoonRptInpFlg		(portSkdVO.getNoonRptInpFlg());
				vo.setDepRptInpFlg		(portSkdVO.getDepRptInpFlg());
				vo.setActInpFlg			(portSkdVO.getActInpFlg());
				vo.setPrtChkFlg			(portSkdVO.getPrtChkFlg());
				vo.setCreUsrId			(portSkdVO.getCreUsrId());
				vo.setUpdUsrId			(portSkdVO.getUpdUsrId());
				vo.setVslDlayRsnCd		(portSkdVO.getVslDlayRsnCd());
				vo.setVslDlayRsnDesc	(portSkdVO.getVslDlayRsnDesc());
				vo.setShpCallNo			(portSkdVO.getShpCallNo());
				vo.setShpCallNoUpdUsrId	(portSkdVO.getShpCallNoUpdUsrId());
				vo.setShpCallNoUpdDt	(portSkdVO.getShpCallNoUpdDt());
				vo.setTmlVoyNo			(portSkdVO.getTmlVoyNo());
				vo.setTmlVslCd			(portSkdVO.getTmlVslCd());
				vo.setFtDt				(portSkdVO.getFtDt());
				vo.setPlismYdCd			(portSkdVO.getPlismYdCd());
				vo.setPlismVoyNo		(portSkdVO.getPlismVoyNo());
				vo.setPlismVslCd		(portSkdVO.getPlismVslCd());
				vo.setSkdCngStsCd		(portSkdVO.getSkdCngStsCd());
				vo.setTurnPortFlg		(portSkdVO.getTurnPortFlg());
				vo.setTurnPortIndCd		(portSkdVO.getTurnPortIndCd());
				vo.setTurnSkdVoyNo		(portSkdVO.getTurnSkdVoyNo());
				vo.setTurnSkdDirCd		(portSkdVO.getTurnSkdDirCd());
				vo.setTurnClptIndSeq	(portSkdVO.getTurnClptIndSeq());
				vo.setIbCgoQty			(portSkdVO.getIbCgoQty());
				vo.setObCgoQty			(portSkdVO.getObCgoQty());
				vo.setVpsRmk			(portSkdVO.getVpsRmk());
				vo.setPhsIoRsnCd		(portSkdVO.getPhsIoRsnCd());
				vo.setPhsIoRmk			(portSkdVO.getPhsIoRmk());
				vo.setSkdBrthNo			(portSkdVO.getSkdBrthNo());
				vo.setInitSkdInpFlg		("Y");
				vo.setOfcInpFlg			(portSkdVO.getOfcInpFlg());
				vo.setSeaBufHrs			(portSkdVO.getSeaBufHrs());
				vo.setPortBufHrs		(portSkdVO.getPortBufHrs());
				
				String turnPortIndCd  = vo.getTurnPortIndCd();
				String turnSkdVoyNo = vo.getTurnSkdVoyNo();
				String turnSkdDirCd = vo.getTurnSkdDirCd();
				
				//2014 10.20 마지막포트가 turning flag 가 F인 경우 삭제로 예외처리
				log.info("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + vo.getVpsPortCd() + " :: " +  turnPortIndCd + " :: " + turnSkdVoyNo + " :: " + turnSkdDirCd);
				
				if( ("D".equals(turnPortIndCd) || "V".equals(turnPortIndCd) || "F".equals(turnPortIndCd) ) && 
						( "".equals(turnSkdVoyNo) || turnSkdVoyNo == null ) && 
						("".equals(turnSkdDirCd) || turnSkdDirCd == null ) )
				{
					continue;
				}
				
				vskVslPortSkdList.add	(vo);
			}

			// Long Range SKD Creation 에서 마지막 스케쥴( Turnning Port가 F인 것)은 저장하지 않는다.
			if("F".equals(vskVslPortSkdList.get(vskVslPortSkdList.size()-1).getTurnPortFlg())){
				vskVslPortSkdList.remove(vskVslPortSkdList.size()-1);
			}

			dbDao.addVskVslPortSkd(vskVslPortSkdList);		// VSK_VSL_PORT_SKD
			
			/* ============================================================================
			 * Vessel Schedule History 관리(Header+Detail) Started ::2013-07-30::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * 1. VSK_VSL_SKD_CNG_HIS
			 * 2. VSK_VSL_SKD_CNG_HIS_DTL
			 * ----------------------------------------------------------------------------
			 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
			 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
			 * ============================================================================
			 */
			
			//::jskjskjsk::2013-09-17:://if(vskVslSkdList != null && vskVslSkdList.size()>0){
				
				//log.info("\n\n ::jskjskjsk::CREATION_LRS::started!!! \n");
	
				////List<VslSkdCngHisVO> 	tmpVslSkdCngHisVOs 	= new ArrayList<VslSkdCngHisVO>();
				////tmpVslSkdCngHisVOs							= createVslSkdChangeHistory(vskVslSkdList, "CREATION_LRS");
				//this.createVslSkdChangeHistory(vskVslSkdList, null, "CREATION_LRS");
				
				////createVslSkdChangeHistoryDetail(tmpVslSkdCngHisVOs, null, "CREATION_LRS");
				
				//log.info("\n\n ::jskjskjsk::CREATION_LRS::finished!!! \n");
				
			//::jskjskjsk::2013-09-17:://}
			
			/* ----------------------------------------------------------------------------
			 * Vessel Schedule History 관리(Header+Detail) Finished ::2013-07-30::
			 * ============================================================================
			 */		
			
			/****************************************************************
			 * 운항스케쥴 이력관리를 위한 VO or VO List Setting ::2013-08-28
			 */
			longRangeSkdGRPVO.setVskVslSkdList(vskVslSkdList);
			/****************************************************************/

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
	 * Calling한 Port 정보를 조회합니다.<br>
	 *
	 * @param VvdVO vvdVO
	 * @return SkipPortGRPVO
	 * @exception EventException
	 */
	public SkipPortGRPVO searchCallingPortList(VvdVO vvdVO) throws EventException {
		try {
			SkipPortGRPVO skipPortGRPVO = new SkipPortGRPVO();
			skipPortGRPVO.setReasonPortList(dbDao.searchPreCallingPortList(vvdVO));
			skipPortGRPVO.setTsPortList(dbDao.searchNextCallingPortList(vvdVO));

			return skipPortGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		}
	}

	/**
	 * 해당 VVD를 사용하는 Booking 정보가 있는지 확인합니다.<br>
	 *
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception EventException
	 * @author jinwoo
	 */
	public int checkVvdApplyBooking(VvdVO vvdVO) throws EventException {
		try {
			return dbDao.checkVvdApplyBooking(vvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
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
	 * 해당 VVD로 Actual Port Schedule이 입력되여 있는지 확인한다.<br>
	 *
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception EventException
	 * @author jinwoo
	 */
	public int checkVvdActualSkdInput(VvdVO vvdVO) throws EventException {
		try {
			return dbDao.checkVvdActualSkdInput(vvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
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
	 * Proforma Schedule 을 조회합니다.<br>
	 *
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @exception EventException
	 */
	public List<SwapCstSkdSimVO> searchCstSkdByPfSkdSim(SwapCstSkdSimVO swapCstSkdSimVO) throws EventException {
		try {
			return dbDao.searchCstSkdByPfSkdSim(swapCstSkdSimVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
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

				vskVslSkdVO.setVslCd		(cstSkdByVvdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo		(cstSkdByVvdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd		(cstSkdByVvdVO.getSkdDirCd());
				vskVslSkdVO.setVslSlanCd	(cstSkdByVvdVO.getVslSlanCd());
				vskVslSkdVO.setSkdUsdIndCd	("H");
				vskVslSkdVO.setPfSkdTpCd	(cstSkdByVvdVO.getPfSvcTpCd());
				vskVslSkdVO.setPsdoVvdCd	("FD" + cstSkdByVvdVO.getVpsEtdDt().substring(2, 8) + "E");
				vskVslSkdVO.setCoCd			("H");
				vskVslSkdVO.setSkdRmk		(cstSkdByVvdVO.getSkdRmk());
				vskVslSkdVO.setCreUsrId		(userId);
				vskVslSkdVO.setUpdUsrId		(userId);

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
				
				/*** 2013-06-19 ::삭제시 Delete User Id 저장을 위한 user id setting ***/
				vskVslSkdVO.setUpdUsrId(userId);
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

		vslPortSkdVO.setVslCd			(cstSkdByVvdVO.getVslCd			());
		vslPortSkdVO.setSkdVoyNo		(cstSkdByVvdVO.getSkdVoyNo		());
		vslPortSkdVO.setSkdDirCd		(cstSkdByVvdVO.getSkdDirCd		());
		vslPortSkdVO.setVpsPortCd		(cstSkdByVvdVO.getVpsPortCd		());
		vslPortSkdVO.setClptIndSeq		(cstSkdByVvdVO.getClptIndSeq	());
		vslPortSkdVO.setNewClptIndSeq	(cstSkdByVvdVO.getNewClptIndSeq	());
		vslPortSkdVO.setClptSeq			(cstSkdByVvdVO.getClptSeq		());	//UI(화면)에서 Setting		
		
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
		vslPortSkdVO.setPhsIoRsnCd(cstSkdByVvdVO.getPhsIoRsnCd());
		vslPortSkdVO.setPhsIoRmk(cstSkdByVvdVO.getPhsIoRmk());
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

	/**
	 * 변경된 Vessel Port SKD 정보를 변경 및 삭제한다.
	 *
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdByVvd(CstSkdByVvdVO[] cstSkdByVvdVOs, SignOnUserAccount account) throws EventException{
		
		VslSkdChgStsGRPVO vslSkdChgStsGRPVO = new VslSkdChgStsGRPVO();
		
		//::jskjskjskjsk::costal-schedule::2013-04-22:://
		
		Map<String, List<VskVslSkdVO>>	hmVskVslSkdVOs			= new HashMap<String, List<VskVslSkdVO>>();
		VslSkdCngHistGroupVO			vslSkdCngHistGroupVO	= new VslSkdCngHistGroupVO();
		
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
				List<VslPortSkdVO> 		insertPortVoList 			= new ArrayList<VslPortSkdVO>();
				List<VslPortSkdVO> 		updatePortVoList 			= new ArrayList<VslPortSkdVO>();

				// VSK_VSL_PORT_SKD의 키값이 아닌 항목에 대해서만 수정이 발생하는 경우
				List<VslPortSkdVO> 		updatePortDataList 			= new ArrayList<VslPortSkdVO>();

				List<VslPortSkdVO> 		deletePortVoList 			= new ArrayList<VslPortSkdVO>();
				List<VskVslPortSkdVO> 	deleteVirtualPortVoList 	= new ArrayList<VskVslPortSkdVO>();
				List<VslPortSkdVO> 		insertVirtualPortVoList 	= new ArrayList<VslPortSkdVO>();
				List<VskVslPortSkdVO> 	updateNextPortVoList 		= new ArrayList<VskVslPortSkdVO>();
				List<VskVslPortSkdVO> 	deleteVirtualPortERPVoList 	= new ArrayList<VskVslPortSkdVO>();	//삭제된 Virtual Port 를 ERP에 전송하기 위해.
				List<VskVslPortSkdVO> 	curPortInfoVOList 			= null;								// 화면에서 넘어 온 VVD 별 Port 정보(VVD 가 여러 건일 경우 사용).
				List<VskVslPortSkdVO> 	prePortInfoVOList 			= null;								// 화면에서 넘어 온 VVD 별 Port 정보(VVD 가 여러 건일 경우 사용).

				List<VskVslPortSkdVO> 	totalOrgPortList 			= new ArrayList<VskVslPortSkdVO>();

				boolean isFirstPort = false;	// 첫번째 Port 여부.
				int 	vitualSeq 	= 0; 		// Virtual 순서(몇번째 Virtual 인지 알기 위해 : 첫번째 Virtual 은 Next Port 생성 시 turn_port_ind_cd 를 'N' 으로)
				
				//VVD 목록만 추출함//
				List<VskVslSkdVO> masterVoList = getMasterVvdList(cstSkdByVvdVOs, userId);		// cstSkdByVvdVOs 로 넘어 온 VVD
				boolean firstVVD = true;

				//VVD 단위로 LOOP하고 로직처리함//
				for(VskVslSkdVO vskVslSkdVO : masterVoList){
					String vslCd 	= vskVslSkdVO.getVslCd		();
					String skdVoyNo = vskVslSkdVO.getSkdVoyNo	();
					String skdDirCd = vskVslSkdVO.getSkdDirCd	();

					VskVslPortSkdVO originPortParamVO = new VskVslPortSkdVO();
					originPortParamVO.setVslCd		(vslCd);
					originPortParamVO.setSkdVoyNo	(skdVoyNo);
					originPortParamVO.setSkdDirCd	(skdDirCd);
					
					//VVD 기준으로 모든 PORT 데이터 조회 :TURNING+NORMAL+VIRTUAL PORT//
					List<VskVslPortSkdVO> originPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(originPortParamVO);	//현재 VVD의 저장되기 전의 Port 정보를 조회한다.

					if(originPortVoList != null && originPortVoList.size()>0){
						totalOrgPortList.addAll(originPortVoList);
					}

					if(curPortInfoVOList != null){ //for R4J rule
						prePortInfoVOList = curPortInfoVOList;
					}
					curPortInfoVOList 	= new ArrayList<VskVslPortSkdVO>();
					int currSeq 		= 0;		// Port - for loop seq
					isFirstPort			= true;
					int	orgVoCnt		= -1;
					//동일 VVD내에서 PORT별 LOOP 로직처리//
					for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs){
						orgVoCnt = orgVoCnt + 1;
						// VVD 별 실행.
						if(vslCd.equals(cstSkdByVvdVO.getVslCd()) && skdVoyNo.equals(cstSkdByVvdVO.getSkdVoyNo()) && skdDirCd.equals(cstSkdByVvdVO.getSkdDirCd())){
							String ibFlag 			= cstSkdByVvdVO.getIbflag();
							String newClptIndSeq 	= cstSkdByVvdVO.getNewClptIndSeq();			// 동일 VVD 내의 Port 갯수
							String vpsPortCd 		= cstSkdByVvdVO.getVpsPortCd();
							String ydCd 			= vpsPortCd + cstSkdByVvdVO.getTmlCd();		// Yard Code = Port Code + Terminal Code
							String turnPortFlg 		= cstSkdByVvdVO.getTurnPortFlg();
							String turnPortIndCd 	= cstSkdByVvdVO.getTurnPortIndCd();
							String turnClptIndSeq 	= cstSkdByVvdVO.getTurnClptIndSeq();
							String turnSkdVoyNo 	= cstSkdByVvdVO.getTurnSkdVoyNo();
							String turnSkdDirCd 	= cstSkdByVvdVO.getTurnSkdDirCd();
							int nTurnClptIndSeq 	= 0;										//Turnning VVD 내의 Port 갯수
							int nCallYdIndSeq 		= makeCallYardSeq(cstSkdByVvdVOs, currSeq);	//Yard Seq(동일 VVD 내의 Yard 갯수)

							//================================================================================================================
							// 현재VVD(화면에서 넘어온 정보)의 Port 정보들을 Table(TABLE VO) 기준으로 갖고 있는다.
							VskVslPortSkdVO curPortInfoVO = new VskVslPortSkdVO();
							curPortInfoVO.setIbflag		(ibFlag);
							curPortInfoVO.setVslCd		(vslCd);
							curPortInfoVO.setSkdVoyNo	(skdVoyNo);
							curPortInfoVO.setSkdDirCd	(skdDirCd);
							curPortInfoVO.setVpsPortCd	(vpsPortCd);
							curPortInfoVO.setClptIndSeq	(cstSkdByVvdVO.getClptIndSeq());
							curPortInfoVO.setSlanCd		(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSlanCd(), cstSkdByVvdVO.getVslSlanCd()));
							curPortInfoVO.setYdCd		(ydCd);
							curPortInfoVO.setTurnPortFlg(turnPortFlg);

							curPortInfoVOList.add		(curPortInfoVO);
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
								// [Truning Port Start]
								// Tunning Port Validation(정합성 Check).
								checkVskVslPortSkd(vslCd, skdVoyNo, skdDirCd, turnSkdVoyNo, turnSkdDirCd);

								// Virtual 정보를 조회한다.
								VskVslPortSkdVO virtualPortParamVO = new VskVslPortSkdVO();
								virtualPortParamVO.setVslCd		(vslCd);
								virtualPortParamVO.setSkdVoyNo	(turnSkdVoyNo);
								virtualPortParamVO.setSkdDirCd	(turnSkdDirCd);

								// 화면에서 생성하려는 Virtual Port
								List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(virtualPortParamVO);

								// 첫번째 VVD일 때, turning으로 연결된 앞선 VVD의, Virtual Port 리스트를 totalOrgPortList에 추가한다.
								// 이유는 첫번째 VVD에서 변경 사항이 발생한 경우, 이와 연결된 VVD에도 변경 사항을 적용해 주기 위해서이다.
								if(firstVVD){
									for(VskVslPortSkdVO vskVslPortSkdVO : virtualPortVoList){
										if(	"D".equals(vskVslPortSkdVO.getTurnPortIndCd()) ||
											"V".equals(vskVslPortSkdVO.getTurnPortIndCd()) ||
											"F".equals(vskVslPortSkdVO.getTurnPortIndCd()))
										{
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
									int 	preVvdExCnt  		= 0;			//이전 VVD 의 Virtual을 제외한 Port 수
									int 	virtualCallYdIndSeq = 0;
									String 	prePortCd 			= "";
									String 	virtualLaneCd 		= "";

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
									nTurnClptIndSeq 	= getParsingTurnClptIndSeq(nTurnClptIndSeq, newClptIndSeq);
									virtualCallYdIndSeq = virtualCallYdIndSeq + nCallYdIndSeq;

									// ****************************** Virtual Info ******************************
									VslPortSkdVO virtualPortVO = makeVirtualDataSet(	cstSkdByVvdVO
																					, 	Integer.toString(nTurnClptIndSeq)
																					, 	Integer.toString(preVvdExCnt + curTurnPortCnt(curPortInfoVOList)) //이전 Port의 Virtual을 제외한 Port 수 + 현재까지의 Turnning 수(Turnning 이 띄엄띄엄 들어오는 경우 고려함.)
																					, 	virtualLaneCd
																					, 	ydCd
																					, 	Integer.toString(virtualCallYdIndSeq)
																					, 	virtualTurnPortIndCd
																					, 	userId
																					);

									// ****************************** Virtual Delete Info ******************************
									// Virtual 정보는 Delete 후 다시 Insert
									if(deleteVirtualPortVoList != null && deleteVirtualPortVoList.size() > 0){
										int voSize = deleteVirtualPortVoList.size();
										for(int n=0; n<voSize; n++){
											VskVslPortSkdVO delPortVO = deleteVirtualPortVoList.get(n);
											if(!(		delPortVO.getVslCd		().equals(vslCd			)
													&& 	delPortVO.getSkdVoyNo	().equals(turnSkdVoyNo	)
													&& 	delPortVO.getSkdDirCd	().equals(turnSkdDirCd	)))
											{
												VskVslPortSkdVO virtualDelPortVO = new VskVslPortSkdVO();
												virtualDelPortVO.setVslCd	(vslCd			);
												virtualDelPortVO.setSkdVoyNo(turnSkdVoyNo	);
												virtualDelPortVO.setSkdDirCd(turnSkdDirCd	);
												virtualDelPortVO.setSlanCd	(virtualLaneCd	);

												deleteVirtualPortVoList.add(virtualDelPortVO);
											}

											//기존 Virtual 정보와 새로 입력받은 Virtual 정보가 틀리면 기존 Virtual 정보 삭제.
											if(!(turnSkdVoyNo.equals(originTurnVoyNo) && turnSkdDirCd.equals(originTurnDirCd))){
												if(!(delPortVO.getVslCd().equals(vslCd)
														&& delPortVO.getSkdVoyNo().equals(originTurnVoyNo)
														&& delPortVO.getSkdDirCd().equals(originTurnDirCd))){
													VskVslPortSkdVO virtualDelPortVO = new VskVslPortSkdVO();
													virtualDelPortVO.setVslCd	(vslCd			);
													virtualDelPortVO.setSkdVoyNo(originTurnVoyNo);
													virtualDelPortVO.setSkdDirCd(originTurnDirCd);
													virtualDelPortVO.setSlanCd	(virtualLaneCd	);

													deleteVirtualPortVoList.add	(virtualDelPortVO);
												}
											}
										}
									}else{
										VskVslPortSkdVO virtualDelPortVO = new VskVslPortSkdVO();
										virtualDelPortVO.setVslCd	(vslCd			);
										virtualDelPortVO.setSkdVoyNo(turnSkdVoyNo	);
										virtualDelPortVO.setSkdDirCd(turnSkdDirCd	);
										virtualDelPortVO.setSlanCd	(virtualLaneCd	);

										deleteVirtualPortVoList.add	(virtualDelPortVO);

										//기존 Virtual 정보와 새로 입력받은 Virtual 정보가 틀리면 기존 Virtual 정보 삭제.
										if(VSKGeneralUtil.isNotNull(originTurnVoyNo) && VSKGeneralUtil.isNotNull(originTurnDirCd)){
											if(!(turnSkdVoyNo.equals(originTurnVoyNo) && turnSkdDirCd.equals(originTurnDirCd))){
												VskVslPortSkdVO orgVirtualDelPortVO = new VskVslPortSkdVO();
												orgVirtualDelPortVO.setVslCd	(vslCd			);
												orgVirtualDelPortVO.setSkdVoyNo	(originTurnVoyNo);
												orgVirtualDelPortVO.setSkdDirCd	(originTurnDirCd);
												orgVirtualDelPortVO.setSlanCd	(virtualLaneCd	);

												deleteVirtualPortVoList.add		(orgVirtualDelPortVO);
											}
										}
									}

									// ****************************** Virtual Insert Info ******************************
									//삭제인 경우는 Virtual Port 생성 막음.
									if(!"D".equals(ibFlag)){
										cstSkdByVvdVOs[orgVoCnt].setActInpFlg(virtualPortVO.getClptIndSeq()); // Virtual Port 삭제 후 재연결시 COP 호출 대상을 찾기 위해 추가. (2014.09.30)
										
//										log.debug("\n lcb2000 Virtual Port Setting : " 	+ virtualPortVO.getVslCd() + "/"
//																						+ virtualPortVO.getSkdVoyNo() + "/"
//																						+ virtualPortVO.getSkdDirCd() + "/"
//																						+ virtualPortVO.getVpsPortCd() + "/"
//																						+ virtualPortVO.getClptIndSeq() + "/"
//												);
										virtualPortVO.setCreDt(cstSkdByVvdVO.getCreDt());
										insertVirtualPortVoList.add(virtualPortVO);
									}
								}
								// [Virtual Port 정보 조회 End]
							}
							//turnPortFlg 가 'Y'에서 'N'으로 변경된 건을 찾아 해당 작업 처리.
							else if("N".equals(turnPortFlg)){
								if(VSKGeneralUtil.isNotNull(originTurnVoyNo) && VSKGeneralUtil.isNotNull(originTurnDirCd)){
									VskVslPortSkdVO virtualPortParamVO = new VskVslPortSkdVO();
									// 기존 Virtual 정보로 Virtual 정보를 조회한다.
									virtualPortParamVO.setVslCd		(vslCd			);
									virtualPortParamVO.setSkdVoyNo	(originTurnVoyNo);
									virtualPortParamVO.setSkdDirCd	(originTurnDirCd);

									// 화면에서 변경하기 전의 Virtual Port
									List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(virtualPortParamVO);

									//Turn Port Flg 가 'Y'인 Virtual Port를 찾아 'N'으로 변경된 건 확인하여 해당 Virtual Port를 삭제.
									if(virtualPortVoList != null && virtualPortVoList.size() > 0){
										String orgVirtualTurnPortIndCd 	= "";
										String orgVirtualClptIndSeq 	= "";
										String orgVirtualVpsPortCd 		= "";
										for(VskVslPortSkdVO virtualPortVo : virtualPortVoList){
											orgVirtualTurnPortIndCd 	= virtualPortVo.getTurnPortIndCd();
											orgVirtualClptIndSeq 		= virtualPortVo.getClptIndSeq	();
											orgVirtualVpsPortCd 		= virtualPortVo.getVpsPortCd	();

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
							VslPortSkdVO vslPortSkdVO = makeVskVslPortDataSet	(		cstSkdByVvdVO
																					, 	Integer.toString(nCallYdIndSeq)
																					, 	turnClptIndSeq
																					, 	turnPortIndCd
																					, 	userId
																				);

							if("I".equals(ibFlag)){
								vslPortSkdVO.setInitEtaDt	(cstSkdByVvdVO.getVpsEtaDt());
								vslPortSkdVO.setInitEtbDt	(cstSkdByVvdVO.getVpsEtbDt());
								vslPortSkdVO.setInitEtdDt	(cstSkdByVvdVO.getVpsEtdDt());

								insertPortVoList.add		(vslPortSkdVO);
							}else if("U".equals(ibFlag)){
								vslPortSkdVO.setInitEtaDt	(cstSkdByVvdVO.getInitEtaDt());
								vslPortSkdVO.setInitEtbDt	(cstSkdByVvdVO.getInitEtbDt());
								vslPortSkdVO.setInitEtdDt	(cstSkdByVvdVO.getInitEtdDt());
								
								boolean isSameVVDTerminal 	= false;
								for(CstSkdByVvdVO vo : cstSkdByVvdVOs){
									
									/*****************************************************************************
									 * cstSkdByVvdVOs은 화면전체의 vvd+port list이기때문에 vvd를 제어문에 포함하지 않는경우 pre-vvd의 virtual port가 조건에 걸리기때문에
									 * insert/update 등의 구분을 잘못 판단할 수 있음.
									 *****************************************************************************/
									
									if(		vo.getVslCd		().equals(vslCd)			&&	//추가::2013/04/01:://
											vo.getSkdVoyNo	().equals(skdVoyNo)			&&	//추가::2013/04/01:://
											vo.getSkdDirCd	().equals(skdDirCd)			&&	//추가::2013/04/01:://
											vo.getVpsPortCd	().equals(vpsPortCd) 		&&
											vo.getClptIndSeq().equals(newClptIndSeq) 	&&
											!vo.getIbflag	().equals("D"))
									{						
										
										/*************************************************************************
										 * CLPT_IND_SEQ(PK) 변경 CASE
										 * 1. REVERSE CALL	: PK 변경불가(DUP.) 		> PK이외의 데이터만 변경처리
										 * 2. ADD CALL		: PK 변경필요 or 불필요	> PK업데이트처리
										 *    - ADD CALL.CLPT_IND_SEQ < ORG.CLPT_IND_SEQ PK 업데이트처리
										 *    - ADD CALL.CLPT_IND_SEQ > ORG.CLPT_IND_SEQ PK 업데이트제외/데이터만 업데이트
										 *************************************************************************/
										int		iTmpCurInsertRowClptIndSeq		= 0;
										int		iTmpMinInsertRowClptIndSeq		= 0;
										
										for(CstSkdByVvdVO tmpVo : cstSkdByVvdVOs)
										{
											if	( 	tmpVo.getVslCd		().equals(vslCd		)	&&	
													tmpVo.getSkdVoyNo	().equals(skdVoyNo	)	&&	
													tmpVo.getSkdDirCd	().equals(skdDirCd	)	&&	
													tmpVo.getVpsPortCd	().equals(vpsPortCd	)	&&
													tmpVo.getIbflag		().equals("I")
												)
											{
												iTmpCurInsertRowClptIndSeq		= Integer.parseInt(tmpVo.getNewClptIndSeq());
												if(iTmpMinInsertRowClptIndSeq == 0)								iTmpMinInsertRowClptIndSeq	= iTmpCurInsertRowClptIndSeq;
												if(iTmpCurInsertRowClptIndSeq < iTmpMinInsertRowClptIndSeq)		iTmpMinInsertRowClptIndSeq	= iTmpCurInsertRowClptIndSeq;
											}
										}											
											
										if(iTmpMinInsertRowClptIndSeq > 0 && (Integer.parseInt(newClptIndSeq) > iTmpMinInsertRowClptIndSeq)){
											if(!vo.getClptIndSeq().equals(vo.getNewClptIndSeq())){
												////::dbDao.modifyVskVslPortSkd 			대상이됨	::CLPT_IND_SEQ 변경-Add Calling등으로 인한 Tml 추가:://
												isSameVVDTerminal = false;
												break;
											}
										}
										
										isSameVVDTerminal = true;
										vslPortSkdVO.setClptIndSeq(newClptIndSeq);
										break;
									}
								}

								//log.info("\n\n ========= ::jskjskjsk:: findSamePort ["+isSameVVDTerminal+"]\n");

								if(isSameVVDTerminal){
									updatePortDataList.add	(vslPortSkdVO);
									//::dbDao.modifyVskVslPortSkdDataOnly 	대상이됨	::CLPT_IND_SEQ 유지//
								}else{
									updatePortVoList.add	(vslPortSkdVO);
									//::dbDao.modifyVskVslPortSkd 			대상이됨	::CLPT_IND_SEQ 변경//
								}
									
							}else if ("D".equals(ibFlag)){
								if(isFirstPort){
									// Booking 정보 있는지 점검.
									VvdVO vvdVO 		= new VvdVO();
									vvdVO.setVslCd		(vslCd);
									vvdVO.setSkdVoyNo	(skdVoyNo);
									vvdVO.setSkdDirCd	(skdDirCd);

									int chkCnt = dbDao.checkVvdApplyBooking(vvdVO);
									if(chkCnt > 0){
										String curDate 	= VSKGeneralUtil.replaceDateTypeToString(JSPUtil.getKSTDate());
										String etaDt 	= cstSkdByVvdVO.getVpsEtaDt().substring(0, 8);
										long dateL 		= VSKGeneralUtil.dateDiff(curDate, "yyyyMMdd", etaDt, "yyyyMMdd", "d");
//										if(Math.abs(dateL) <= 3L){
										if(0 <= Double.compare(Math.abs(dateL), 3L)){
											/*
											 * MSG - 3일 이내에 Booking 이 존재하여 삭제할 수 없습니다.
											 */
											String[] errMsgs = new String[]{vslCd + skdVoyNo + skdDirCd};
											throw new EventException(new ErrorHandler("VSK10075", errMsgs).getMessage());
										}
									}
								}

								deletePortVoList.add(vslPortSkdVO);

								//Turnning Port 삭제 시 해당 Virtual 정보를 ERP에 전송하기 위해.
								if("Y".equals(vslPortSkdVO.getTurnPortFlg())){
									VskVslPortSkdVO 	tmpVO = new VskVslPortSkdVO();
									tmpVO.setVslCd		(vslPortSkdVO.getVslCd			());
									tmpVO.setSkdVoyNo	(vslPortSkdVO.getTurnSkdVoyNo	());
									tmpVO.setSkdDirCd	(vslPortSkdVO.getTurnSkdDirCd	());
									tmpVO.setSlanCd		(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSlanCd(), cstSkdByVvdVO.getVslSlanCd()));

									deleteVirtualPortERPVoList.add(tmpVO);
								}
							}
						}

						isFirstPort = false;
						currSeq++;
					}// end for(Port)
				}// end for(Master)


				// ***************** History START *****************
				List<VslSkdHisInVO> 	vslSkdHisInVOs 		= this.makeHistoryDataSetByCoastal	(cstSkdByVvdVOs, insertVirtualPortVoList, updateNextPortVoList, userId);
				vslSkdChgStsGRPVO 							= this.manageVslSkdChgSts			(vslSkdHisInVOs);
				
				//////////////////// 2013-08-03 ///////////////////////////////////////////////////////////////
				//::jskjskjsk::2013-09-17:://List<VslSkdCngHisDtlVO>	vslSkdCngHisDtlVOs	= this.makeVslSkdChgHisDtlDataSet	(vslSkdHisInVOs);
				//::jskjskjsk::2013-09-17:://List<VslSkdCngHisDtlVO>	vslSkdCngHisDtlVOs	= null;
				///////////////////////////////////////////////////////////////////////////////////////////////
				
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
				
//				if(deletePortVoList != null && deletePortVoList.size() > 0){
//					dbDao.removeVskVslPortSkd(deletePortVoList);
//				}
				
			    if(deletePortVoList != null && deletePortVoList.size() > 0){
//			        /********************************************************
//			         * VVD 삭제시 Actual SKED 존재하는경우 Oracle Exception
//			         * 2014-07-15 TUE
//			         * ------------------------------------------------------
//			         * STEP 1. Removing VSK_ACT_PORT_SKD <== Adding 15JUL14
//			         * STEP 2. Removing VSK_VSL_PORT_SKD
//			         ********************************************************/
//			        for(VslPortSkdVO tmpPortVO : deletePortVoList){
//			         VskActPortSkdVO tmpVO = new VskActPortSkdVO();
//			         
//				         tmpVO.setVslCd    (tmpPortVO.getVslCd  ());
//				         tmpVO.setSkdVoyNo   (tmpPortVO.getSkdVoyNo ());
//				         tmpVO.setSkdDirCd   (tmpPortVO.getSkdDirCd ());
//				         tmpVO.setVpsPortCd   (tmpPortVO.getVpsPortCd ());
//				         tmpVO.setClptIndSeq   (tmpPortVO.getClptIndSeq());
//				         
//				         dbDao2.removeVskActPortSkd (tmpVO     );
//			        }
			        
			        dbDao.removeVskVslPortSkd  (deletePortVoList  );
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

				/* ============================================================================
				 * Vessel Schedule History 관리(Header+Detail) Started ::2013-07-30::
				 * ----------------------------------------------------------------------------
				 * <TABLE NAME>
				 * 1. VSK_VSL_SKD_CNG_HIS
				 * 2. VSK_VSL_SKD_CNG_HIS_DTL
				 * ----------------------------------------------------------------------------
				 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
				 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
				 * ============================================================================
				 */
				//insertPortVoList <== VslPortSkdVO
				
				if(insertPortVoList != null && insertPortVoList.size() > 0){
					dbDao.addVskVslPortSkd(insertPortVoList);
					
					/******************************************************************
					 * Vessel Schedule Change History 생성 :: 2013-08-08
					 * ----------------------------------------------------------------
					 * Insert & Update가 동시에 발생되기 때문에 UpdateVO가 없는경우에만
					 * 신규생성(Insert)에 대한 History 데이터 생성함
					 */
					if(updateVoList == null || updateVoList.size()==0){
						
						/* ============================================================================
						 * Vessel Schedule History 관리(Header+Detail) Started ::2013-07-30::
						 * ----------------------------------------------------------------------------
						 * <TABLE NAME>
						 * 1. VSK_VSL_SKD_CNG_HIS
						 * 2. VSK_VSL_SKD_CNG_HIS_DTL
						 * ----------------------------------------------------------------------------
						 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
						 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
						 * ============================================================================
						 */
						//log.info("\n\n ::jskjskjsk::[history+detail] insertPortVoList [INSERT_CST_ByVvd_NormalPort(VOP_VSK_0014)] started!!! :: \n");
			
						List<VskVslSkdVO>	vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
						String				sVslCd			= null;
						String				sSkdVoyNo		= null;
						String				sSkdDirCd		= null;
						
						for(int k=0; k<insertPortVoList.size(); k++){
							VslPortSkdVO	tmpVO	= new VslPortSkdVO	();
							VskVslSkdVO		tmpVO2	= new VskVslSkdVO	();
							tmpVO					= insertPortVoList.get(k);
							
							sVslCd					= tmpVO.getVslCd	();
							sSkdVoyNo				= tmpVO.getSkdVoyNo	();
							sSkdDirCd				= tmpVO.getSkdDirCd	();
								
							if(k==0){
								tmpVO2.setVslCd		(sVslCd		);
								tmpVO2.setSkdVoyNo	(sSkdVoyNo	);
								tmpVO2.setSkdDirCd	(sSkdDirCd	);
								vskVslSkdVOs.add	(tmpVO2		);
							}else{
								int iDupKnt		= 0;
								for(VskVslSkdVO tmpVO3 : vskVslSkdVOs){
									if(		sVslCd.equals	(tmpVO3.getVslCd	())
										&&	sSkdVoyNo.equals(tmpVO3.getSkdVoyNo	())
										&&	sSkdDirCd.equals(tmpVO3.getSkdDirCd	())
										)
									{
										iDupKnt++;
									}
								}
								if(iDupKnt == 0){
									tmpVO2.setVslCd		(sVslCd		);
									tmpVO2.setSkdVoyNo	(sSkdVoyNo	);
									tmpVO2.setSkdDirCd	(sSkdDirCd	);
									vskVslSkdVOs.add	(tmpVO2		);
								}
							}
							
							
						}
						//this.createVslSkdChangeHistory(vskVslSkdVOs, null, "INSERT_CST_ByVvd_NormalPort(VOP_VSK_0014)");	
						/****************************************************************
						 * 운항스케쥴 이력관리를 위한 VO or VO List Setting ::2013-08-28::
						 */
						hmVskVslSkdVOs.put("INSERT_CST_ByVvd_NormalPort", vskVslSkdVOs);
						
						//log.info("\n\n ::jskjskjsk::[history+detail]insertPortVoList [INSERT_CST_ByVvd_NormalPort(VOP_VSK_0014)] finished!!! :: \n");
						/* ----------------------------------------------------------------------------
						 * Vessel Schedule History 관리(Header+Detail) Finished ::2013-07-30::
						 * ============================================================================
						 */			
						
					}
					
				}
				
				if(insertVirtualPortVoList != null && insertVirtualPortVoList.size() > 0){
					dbDao.addVskVslPortSkd(insertVirtualPortVoList);
					
					/******************************************************************
					 * Vessel Schedule Change History 생성 :: 2013-08-08
					 * ----------------------------------------------------------------
					 * Insert & Update가 동시에 발생되기 때문에 UpdateVO가 없는경우에만
					 * 신규생성(Insert)에 대한 History 데이터 생성함
					 */
					if(updateVoList == null || updateVoList.size()==0){
						
						/* ============================================================================
						 * Vessel Schedule History 관리(Header+Detail) Started ::2013-07-30::
						 * ----------------------------------------------------------------------------
						 * <TABLE NAME>
						 * 1. VSK_VSL_SKD_CNG_HIS
						 * 2. VSK_VSL_SKD_CNG_HIS_DTL
						 * ----------------------------------------------------------------------------
						 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
						 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
						 * ============================================================================
						 */
						//log.info("\n\n ::jskjskjsk::[history+detail] insertPortVoList [INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0014)] started!!! :: \n");
			
						List<VskVslSkdVO>	vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
						String				sVslCd			= null;
						String				sSkdVoyNo		= null;
						String				sSkdDirCd		= null;
						
						for(int k=0; k<insertVirtualPortVoList.size(); k++){
							VslPortSkdVO	tmpVO	= new VslPortSkdVO	();
							VskVslSkdVO		tmpVO2	= new VskVslSkdVO	();
							tmpVO					= insertPortVoList.get(k);
							
							sVslCd					= tmpVO.getVslCd	();
							sSkdVoyNo				= tmpVO.getSkdVoyNo	();
							sSkdDirCd				= tmpVO.getSkdDirCd	();
								
							if(k==0){
								tmpVO2.setVslCd		(sVslCd		);
								tmpVO2.setSkdVoyNo	(sSkdVoyNo	);
								tmpVO2.setSkdDirCd	(sSkdDirCd	);
								vskVslSkdVOs.add	(tmpVO2		);
							}else{
								int iDupKnt		= 0;
								for(VskVslSkdVO tmpVO3 : vskVslSkdVOs){
									if(		sVslCd.equals	(tmpVO3.getVslCd	())
										&&	sSkdVoyNo.equals(tmpVO3.getSkdVoyNo	())
										&&	sSkdDirCd.equals(tmpVO3.getSkdDirCd	())
										)
									{
										iDupKnt++;
									}
								}
								if(iDupKnt == 0){
									tmpVO2.setVslCd		(sVslCd		);
									tmpVO2.setSkdVoyNo	(sSkdVoyNo	);
									tmpVO2.setSkdDirCd	(sSkdDirCd	);
									vskVslSkdVOs.add	(tmpVO2		);
								}
							}
						}
						//this.createVslSkdChangeHistory(vskVslSkdVOs, null, "INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0014)");	
						
						/****************************************************************
						 * 운항스케쥴 이력관리를 위한 VO or VO List Setting ::2013-08-28::
						 */
						hmVskVslSkdVOs.put("INSERT_CST_ByVvd_VirtualPort", vskVslSkdVOs);
						
						//log.info("\n\n ::jskjskjsk::[history+detail]insertPortVoList [INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0014)] finished!!! :: \n");
						/* ----------------------------------------------------------------------------
						 * Vessel Schedule History 관리(Header+Detail) Finished ::2013-07-30::
						 * ============================================================================
						 */			
						
					}
					
				}
							
				if(updateNextPortVoList != null && updateNextPortVoList.size() > 0){
					dbDao.modifyVskVslPortSkdByNextPort(updateNextPortVoList);
				}
				
				/* ============================================================================
				 * Vessel Schedule History 관리(Header+Detail) Started ::2013-07-30::
				 * ----------------------------------------------------------------------------
				 * <TABLE NAME>
				 * 1. VSK_VSL_SKD_CNG_HIS
				 * 2. VSK_VSL_SKD_CNG_HIS_DTL
				 * ----------------------------------------------------------------------------
				 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
				 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
				 * ============================================================================
				 */
				if(updateVoList != null && updateVoList.size() > 0){
					
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByVvd] started!!! :: \n");
	
					//this.createVslSkdChangeHistory(updateVoList, vslSkdCngHisDtlVOs, "UPDATE_CST_ByVvd");	
					
					/****************************************************************
					 * 운항스케쥴 이력관리를 위한 VO or VO List Setting ::2013-08-28::
					 */
					vslSkdCngHistGroupVO.setVskVslSkdVOs		(updateVoList		);
					//::jskjskjsk::2013-11-28:://vslSkdCngHistGroupVO.setVslSkdCngHisDtlVOs	(vslSkdCngHisDtlVOs	);
					vslSkdCngHistGroupVO.setVslSkdCngHisDtlVOs	(vslSkdChgStsGRPVO.getVslSkdCngHisDtlVOs());
					vslSkdCngHistGroupVO.setFromEventSystem		("UPDATE_CST_ByVvd"	);
					
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByVvd] finished!!! :: \n");
				}
				/* ----------------------------------------------------------------------------
				 * Vessel Schedule History 관리(Header+Detail) Finished ::2013-07-30::
				 * ============================================================================
				 */			

				//=============== VSK_VSL_SKD [DELETE] ===============
				if(deleteVoList != null && deleteVoList.size() > 0){
					//해당 Port 정보가 모두 삭제되어 조회된 건이 없으면 VSK_VSL_SKD 의 정보도 삭제한다.
					/*
					 * VVD 삭제 시 Booking 과 상관없이 모든 기록을 Hitory 남긴다.
					 */
					for(VskVslSkdVO vskVslSkdVO : deleteVoList){

						VskVslSkdHisVO vskVslSkdDelHisVO 	= new VskVslSkdHisVO();
						vskVslSkdDelHisVO.setBfrVslCd		(vskVslSkdVO.getVslCd		());
						vskVslSkdDelHisVO.setBfrSkdVoyNo	(vskVslSkdVO.getSkdVoyNo	());
						vskVslSkdDelHisVO.setBfrSkdDirCd	(vskVslSkdVO.getSkdDirCd	());
						vskVslSkdDelHisVO.setBfrVslSlanCd	(vskVslSkdVO.getVslSlanCd	());
						vskVslSkdDelHisVO.setCreUsrId		(vskVslSkdVO.getCreUsrId	());
						vskVslSkdDelHisVO.setUpdUsrId		(vskVslSkdVO.getUpdUsrId	());

						addVskVslSkdDelHis(vskVslSkdDelHisVO);
					}
					
					/*** :: Deleted VVD의 이력데이터 생성로직추가 ::
					 * 		TABLE NAME	: VSK_VSL_SKD_CNG_HIS
					 * 		로직추가일자	: 2013-06-18
					 ***/
					//this.createVskVslSkdChangeHistoryMstOnly(deleteVoList, "DELETE_CST_ByVvd");
					this.createVskVslSkdChangeHistoryMstOnly(deleteVoList, "DELETE_CST_ByVvd(0014/0015/0057/0058)");
					
					dbDao.removeVskVslSkd					(deleteVoList);
				}

				//===================== EDI 전송을 위한 자료 생성 ========================
				List<VvdVO> ediVvdVOs = new ArrayList<VvdVO>();

				// 특정 VVD 전체가 추가된 경우
				ediVvdVOs = setTransObjectByVvd(ediVvdVOs, insertVoList, "I");

				// Add Port한 경우
				if(insertPortVoList != null && insertPortVoList.size() > 0){
					for(VslPortSkdVO vslPortSkdVO : insertPortVoList){
						VvdVO vvdVO = new VvdVO();
						vvdVO.setIbflag("I");
						vvdVO.setVslCd(vslPortSkdVO.getVslCd());
						vvdVO.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
						vvdVO.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
						vvdVO.setVslSlanCd(vslPortSkdVO.getSlanCd());

						if(!isCheckObjectByVvd(ediVvdVOs, vvdVO)){
							ediVvdVOs.add(vvdVO);
						}
					}
				}

				// CHM-201006129-01
				// Virtual Port로 대상 Port(KR)가 추가되는 경우에도 EDI 전송이 되도록 수정
				if (insertVirtualPortVoList != null) {
					for(VslPortSkdVO virVslPortSkdVO : insertVirtualPortVoList){
	
	//					boolean targetVVD = false;
	//
	//					// -- 대상항차만 적용
	//					for(VskVslSkdVO vskVslSkdVO : masterVoList){
	//						if( (vskVslSkdVO.getVslCd().equals(virVslPortSkdVO.getVslCd())) &&
	//								(vskVslSkdVO.getSkdVoyNo().equals(virVslPortSkdVO.getSkdVoyNo())) &&
	//								(vskVslSkdVO.getSkdDirCd().equals(virVslPortSkdVO.getSkdDirCd()))
	//								){
	//							targetVVD = true;
	//							break;
	//						}
	//					}
	//
	//					if(!targetVVD){
	//						continue;
	//					}
	//					// -- 대상항차만 적용
	
						// 기존 포트에 없던것만 추가
						// 추후 변경된 스케줄도 EDI 포함하는 경우 아래 체크구문을 수정함
						boolean newVirPort = true;
						for(VskVslPortSkdVO vskVslPortSkdVO : totalOrgPortList){
							if(	(virVslPortSkdVO.getVslCd().equals(vskVslPortSkdVO.getVslCd())) &&
									(virVslPortSkdVO.getSkdVoyNo().equals(vskVslPortSkdVO.getSkdVoyNo())) &&
									(virVslPortSkdVO.getSkdDirCd().equals(vskVslPortSkdVO.getSkdDirCd())) &&
									(virVslPortSkdVO.getVpsPortCd().equals(vskVslPortSkdVO.getVpsPortCd())) &&
									(virVslPortSkdVO.getClptIndSeq().equals(vskVslPortSkdVO.getClptIndSeq()))){
	//							!(virVslPortSkdVO.getVpsEtaDt().equals(vskVslPortSkdVO.getVpsEtaDt()))
	//							!(virVslPortSkdVO.getVpsEtbDt().equals(vskVslPortSkdVO.getVpsEtbDt()))
	//							!(virVslPortSkdVO.getVpsEtdDt().equals(vskVslPortSkdVO.getVpsEtdDt()))
								newVirPort = false;
								break;
							}
						}
	
						if(newVirPort){
							VvdVO vvdVO = new VvdVO();
							vvdVO.setIbflag("I");
							vvdVO.setVslCd(virVslPortSkdVO.getVslCd());
							vvdVO.setSkdVoyNo(virVslPortSkdVO.getSkdVoyNo());
							vvdVO.setSkdDirCd(virVslPortSkdVO.getSkdDirCd());
							vvdVO.setVslSlanCd(virVslPortSkdVO.getSlanCd());
	
							if(!isCheckObjectByVvd(ediVvdVOs, vvdVO)){
								ediVvdVOs.add(vvdVO);
							}
						}
					}
				}

				for(VvdVO vvdVO : ediVvdVOs){
//					vvdVO.setCreUsrId(account.getUsr_id());
//					vvdVO.setUpdUsrId(account.getUsr_id());
					if(VSKGeneralUtil.isNull(vvdVO.getCreUsrId())){
						vvdVO.setCreUsrId(userId);
					}
					if(VSKGeneralUtil.isNull(vvdVO.getUpdUsrId())){
						vvdVO.setUpdUsrId(userId);
					}
				}
				//===================== EDI 전송을 위한 자료 생성 끝 ========================

				//			********************* 변경된 VVD ERP에 전송 *********************
				//			변경이 일어난 모든 건에 대해 전송.

				List<VvdVO> erpVvdVOs = new ArrayList<VvdVO>();		//변경(I,U,D)된 모든 건
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, insertVoList					, "I");
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, updateVoList					, "U");
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, deleteVoList					, "D");
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, deletePortVoList				, "D");	// 삭제된 Port 발생 시 실행
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, deleteVirtualPortERPVoList	, "D");	// Virtual Port 삭제건이 있으면 실행.
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, insertVirtualPortVoList		, "U");	// Virtual Port 수정 시 실행.
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, updateNextPortVoList			, "U");	// Next Port 수정 시 실행.
				//SC 에서 마지막에 전송하는 것으로 수정(임창빈 - 2009.12.08)
				vslSkdChgStsGRPVO.setErpVvdVOs(erpVvdVOs);
				vslSkdChgStsGRPVO.setEdiVvdVOs(ediVvdVOs);

	//			Booking BDR LOG
				if(erpVvdVOs != null && erpVvdVOs.size() > 0){
					List<BkgVvdBdrLogVO> bkgVvdLogList = searchBkgBdrLog(erpVvdVOs);
					vslSkdChgStsGRPVO.setBkgVvdBdrLogVOs(bkgVvdLogList);
				}
			}
			
			/****************************************************************
			 * 운항스케쥴 이력관리를 위한 VO or VO List Return ::2013-08-28::
			 */
			vslSkdChgStsGRPVO.setHmVskVslSkdVOs			(hmVskVslSkdVOs			);
			vslSkdChgStsGRPVO.setVslSkdCngHistGroupVO	(vslSkdCngHistGroupVO	);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return vslSkdChgStsGRPVO;
	}

	/**
	 * Coastal History 를 남기기 위해 History DataSet 생성
	 *
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param List<VslPortSkdVO> insertVirtualPortVoList
	 * @param List<VskVslPortSkdVO> updateNextPortVoList
	 * @param String userId
	 * @return List<VslSkdHisInVO>
	 * @exception EventException
	 */
	private List<VslSkdHisInVO> makeHistoryDataSetByCoastal(CstSkdByVvdVO[] cstSkdByVvdVOs, List<VslPortSkdVO> insertVirtualPortVoList, List<VskVslPortSkdVO> updateNextPortVoList, String userId)throws EventException{
		List<VslSkdHisInVO> vslSkdHisInVOs = new ArrayList<VslSkdHisInVO>();

		try{
			
			for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs){
				VslSkdHisInVO vslSkdHisInVO = new VslSkdHisInVO();

				vslSkdHisInVO.setIbflag			(cstSkdByVvdVO.getIbflag			());
				vslSkdHisInVO.setSkdCngStsCd	(cstSkdByVvdVO.getSkdCngStsCd		());
				vslSkdHisInVO.setVslCd			(cstSkdByVvdVO.getVslCd				());
				vslSkdHisInVO.setSkdVoyNo		(cstSkdByVvdVO.getSkdVoyNo			());
				vslSkdHisInVO.setSkdDirCd		(cstSkdByVvdVO.getSkdDirCd			());
				vslSkdHisInVO.setVslSlanCd		(cstSkdByVvdVO.getVslSlanCd			());
				vslSkdHisInVO.setVpsPortCd		(cstSkdByVvdVO.getVpsPortCd			());
				vslSkdHisInVO.setClptIndSeq		(cstSkdByVvdVO.getClptIndSeq		());
				vslSkdHisInVO.setYdCd			(cstSkdByVvdVO.getVpsPortCd			() + cstSkdByVvdVO.getTmlCd());
				vslSkdHisInVO.setVpsEtaDt		(cstSkdByVvdVO.getVpsEtaDt			());
				vslSkdHisInVO.setVpsEtbDt		(cstSkdByVvdVO.getVpsEtbDt			());
				vslSkdHisInVO.setVpsEtdDt		(cstSkdByVvdVO.getVpsEtdDt			());
				vslSkdHisInVO.setVslDlayRsnCd	(cstSkdByVvdVO.getVslDlayRsnCd		());
				vslSkdHisInVO.setVslDlayRsnDesc	(cstSkdByVvdVO.getVslDlayRsnDesc	());
				vslSkdHisInVO.setVslDlayRsnLocCd(cstSkdByVvdVO.getVslDlayRsnLocCd	());
				vslSkdHisInVO.setUsrId			(userId);
				vslSkdHisInVO.setNewClptIndSeq	(cstSkdByVvdVO.getNewClptIndSeq		());
				vslSkdHisInVO.setTurnPortFlg	(cstSkdByVvdVO.getTurnPortFlg		());
				vslSkdHisInVO.setTurnPortIndCd	(cstSkdByVvdVO.getTurnPortIndCd		());
				vslSkdHisInVOs.add				(vslSkdHisInVO);

				//Virtual Port History Setting.
				if("Y".equals(cstSkdByVvdVO.getTurnPortFlg())){
					VslSkdHisInVO virtualVslSkdHisInVO = new VslSkdHisInVO();

					virtualVslSkdHisInVO.setIbflag			(cstSkdByVvdVO.getIbflag		());
					virtualVslSkdHisInVO.setSkdCngStsCd		(cstSkdByVvdVO.getSkdCngStsCd	());
					virtualVslSkdHisInVO.setVslCd			(cstSkdByVvdVO.getVslCd			());
					virtualVslSkdHisInVO.setSkdVoyNo		(cstSkdByVvdVO.getTurnSkdVoyNo	());
					virtualVslSkdHisInVO.setSkdDirCd		(cstSkdByVvdVO.getTurnSkdDirCd	());
					virtualVslSkdHisInVO.setVslSlanCd		(cstSkdByVvdVO.getVslSlanCd		());
					virtualVslSkdHisInVO.setVpsPortCd		(cstSkdByVvdVO.getVpsPortCd		());
					virtualVslSkdHisInVO.setClptIndSeq		(cstSkdByVvdVO.getTurnClptIndSeq());
					virtualVslSkdHisInVO.setYdCd			(cstSkdByVvdVO.getVpsPortCd		() + cstSkdByVvdVO.getTmlCd());
					virtualVslSkdHisInVO.setVpsEtaDt		(cstSkdByVvdVO.getVpsEtaDt		());
					virtualVslSkdHisInVO.setVpsEtbDt		(cstSkdByVvdVO.getVpsEtbDt		());
					virtualVslSkdHisInVO.setVpsEtdDt		(cstSkdByVvdVO.getVpsEtdDt		());
					virtualVslSkdHisInVO.setVslDlayRsnCd	(cstSkdByVvdVO.getVslDlayRsnCd	());
					virtualVslSkdHisInVO.setVslDlayRsnDesc	(cstSkdByVvdVO.getVslDlayRsnDesc());
					virtualVslSkdHisInVO.setVslDlayRsnLocCd	(cstSkdByVvdVO.getVslDlayRsnLocCd());
					virtualVslSkdHisInVO.setUsrId			(userId);

					for(VslPortSkdVO vslPortSkdVO : insertVirtualPortVoList){
						
						if(		cstSkdByVvdVO.getVpsPortCd().equals(vslPortSkdVO.getVpsPortCd())
							&& 	cstSkdByVvdVO.getNewClptIndSeq().equals(vslPortSkdVO.getTurnClptIndSeq()))
						{
							virtualVslSkdHisInVO.setNewClptIndSeq	(vslPortSkdVO.getClptIndSeq		());
							virtualVslSkdHisInVO.setClptIndSeq		(vslPortSkdVO.getClptIndSeq		());	// Virtual Port 삭제 후 재연결시 COP 호출 대상을 찾기 위해 추가. (2014.09.30)
							virtualVslSkdHisInVO.setTurnPortFlg		(vslPortSkdVO.getTurnPortFlg	());
							virtualVslSkdHisInVO.setTurnPortIndCd	(vslPortSkdVO.getTurnPortIndCd	());
							break;
						}
						
					}

					vslSkdHisInVOs.add(virtualVslSkdHisInVO);
				}

				//Next Port History Setting.
				if(VSKGeneralUtil.isVirtualPort(cstSkdByVvdVO.getTurnPortIndCd())){
					VslSkdHisInVO nxtVslSkdHisInVO = new VslSkdHisInVO();

					nxtVslSkdHisInVO.setIbflag			("U");
					nxtVslSkdHisInVO.setSkdCngStsCd		(cstSkdByVvdVO.getSkdCngStsCd		());
					nxtVslSkdHisInVO.setVslCd			(cstSkdByVvdVO.getVslCd				());
					nxtVslSkdHisInVO.setSkdVoyNo		(cstSkdByVvdVO.getTurnSkdVoyNo		());
					nxtVslSkdHisInVO.setSkdDirCd		(cstSkdByVvdVO.getTurnSkdDirCd		());
					nxtVslSkdHisInVO.setVslSlanCd		(cstSkdByVvdVO.getVslSlanCd			());
					nxtVslSkdHisInVO.setVpsPortCd		(cstSkdByVvdVO.getVpsPortCd			());
					nxtVslSkdHisInVO.setClptIndSeq		(cstSkdByVvdVO.getTurnClptIndSeq	());
					nxtVslSkdHisInVO.setYdCd			(cstSkdByVvdVO.getVpsPortCd			() + cstSkdByVvdVO.getTmlCd());
					nxtVslSkdHisInVO.setVpsEtaDt		(cstSkdByVvdVO.getVpsEtaDt			());
					nxtVslSkdHisInVO.setVpsEtbDt		(cstSkdByVvdVO.getVpsEtbDt			());
					nxtVslSkdHisInVO.setVpsEtdDt		(cstSkdByVvdVO.getVpsEtdDt			());
					nxtVslSkdHisInVO.setVslDlayRsnCd	(cstSkdByVvdVO.getVslDlayRsnCd		());
					nxtVslSkdHisInVO.setVslDlayRsnDesc	(cstSkdByVvdVO.getVslDlayRsnDesc	());
					nxtVslSkdHisInVO.setVslDlayRsnLocCd	(cstSkdByVvdVO.getVslDlayRsnLocCd	());
					nxtVslSkdHisInVO.setUsrId			(userId);

					for(VskVslPortSkdVO vskVslPortSkdVO : updateNextPortVoList){
						
						if(		cstSkdByVvdVO.getVpsPortCd().equals(vskVslPortSkdVO.getVpsPortCd())
							&& 	cstSkdByVvdVO.getNewClptIndSeq().equals(vskVslPortSkdVO.getTurnClptIndSeq()))
						{
							nxtVslSkdHisInVO.setNewClptIndSeq	(vskVslPortSkdVO.getClptIndSeq		());
							nxtVslSkdHisInVO.setTurnPortFlg		(vskVslPortSkdVO.getTurnPortFlg		());
							nxtVslSkdHisInVO.setTurnPortIndCd	(vskVslPortSkdVO.getTurnPortIndCd	());
							break;
						}
						
					}

					vslSkdHisInVOs.add(nxtVslSkdHisInVO);
				}
			}
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}

		return vslSkdHisInVOs;
	}

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
			nxtVskVslPortSkdVO.setSlanCd(cstSkdByVvdVO.getVslSlanCd() == null ? cstSkdByVvdVO.getSlanCd() : cstSkdByVvdVO.getVslSlanCd());

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

	/**
	 * partVvdList 의 VVD 내용이 baseVvdList 에 있는지 검사하여 없으면 baseVvdList 에 VVD 정보를 담는다.
	 *
	 * @param List<VvdVO> baseVvdList
	 * @param Object obj
	 * @param String ibFlg
	 * @return List<VvdVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private List<VvdVO> setTransObjectByVvd(List<VvdVO> baseVvdList, Object obj, String ibFlg) throws EventException{
		try{
			List<Object> objList = (List<Object>)obj;

			if(objList != null && objList.size() > 0){
				for(Object voObject : objList){
					VvdVO vvdVO = new VvdVO();

					if(voObject.getClass().isInstance(new VskVslSkdVO())){
						VskVslSkdVO vskVslSkdVO = (VskVslSkdVO)voObject;
						vvdVO.setIbflag(ibFlg);
						vvdVO.setVslCd(vskVslSkdVO.getVslCd());
						vvdVO.setSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
						vvdVO.setSkdDirCd(vskVslSkdVO.getSkdDirCd());
						vvdVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
					}else if(voObject.getClass().isInstance(new VskVslPortSkdVO())){
						VskVslPortSkdVO vskVslPortSkdVO = (VskVslPortSkdVO)voObject;
						vvdVO.setIbflag(ibFlg);
						vvdVO.setVslCd(vskVslPortSkdVO.getVslCd());
						vvdVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
						vvdVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
						vvdVO.setVslSlanCd(vskVslPortSkdVO.getSlanCd());
					}else if(voObject.getClass().isInstance(new VslPortSkdVO())){
						VslPortSkdVO vslPortSkdVO = (VslPortSkdVO)voObject;
						vvdVO.setIbflag(ibFlg);
						vvdVO.setVslCd(vslPortSkdVO.getVslCd());
						vvdVO.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
						vvdVO.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
						vvdVO.setVslSlanCd(vslPortSkdVO.getSlanCd());
					}else{
						/*
						 * 위에 정의된 Class Type 이 존재하지 않을 경우 에러 처리
						 */
						throw new EventException(new ErrorHandler("VSK10039").getMessage());
					}

					if(!isCheckObjectByVvd(baseVvdList, vvdVO)){
						baseVvdList.add(vvdVO);
					}
				}
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}

		return baseVvdList;
	}

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

	/**
	 * List<VvdVO> list 에 VvdVO vvdVO 가 존재하는지 검사.
	 * @param list List<VvdVO>
	 * @param vvdVO VvdVO
	 * @return boolean
	 */
	private boolean isCheckObjectByVvd(List<VvdVO> list, VvdVO vvdVO){
		boolean rtnFlg = false;

		for(int i=0; i<list.size(); i++){
			VvdVO tmpVO = list.get(i);
			if(tmpVO.getVslCd().equals(vvdVO.getVslCd())
					&& tmpVO.getSkdVoyNo().equals(vvdVO.getSkdVoyNo())
					&& tmpVO.getSkdDirCd().equals(vvdVO.getSkdDirCd())){
				rtnFlg = true;
				break;
			}
		}

		return rtnFlg;
	}

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

	/**
	 * History 대상 건을 찾아 해당 테이블에 저장한다.
	 *
	 * @param List<VslSkdHisInVO> vslSkdHisInVOs
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	private VslSkdChgStsGRPVO manageVslSkdChgSts(List<VslSkdHisInVO> vslSkdHisInVOs) throws EventException {
		//::jskjskjskjsk::history(bkg/sce)::2013-04-22:://
		
		//return Group VO
		VslSkdChgStsGRPVO 		vslSkdChgStsGRPVO 			= new VslSkdChgStsGRPVO				();
		//return [Booking] VO List
		List<VslSkdCngUpdateVO> bkgUpdateList 				= new ArrayList<VslSkdCngUpdateVO>	();
		List<VslSkdCngNoticeVO> bkgVslSkdCngNoticeList 		= new ArrayList<VslSkdCngNoticeVO>	();
		List<VslSkdCngUpdateVO> bkgVslSkdEtaDelayNoticeList	= new ArrayList<VslSkdCngUpdateVO>	();
		
		//return [COP] VO List
		List<SceActRcvIfVO> 	copNoticeList 				= new ArrayList<SceActRcvIfVO>		();

		List<VskVslSkdHisVO> 	historyList 				= new ArrayList<VskVslSkdHisVO>		();
		List<VskVslSkdVO> 		masterVOList 				= new ArrayList<VskVslSkdVO>		();		// VSK_VSL_SKD 정보
		
		//Vessel Schedule Detail History 관리용 List::VKS_VSL_CNG_HIS_DTL//
		List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOList				= new ArrayList<VslSkdCngHisDtlVO>	();
		
		//::정상기::VSK-BKG, VSK-SCE 인터페이스::[2013-03-07]//
		/* VSK-BKG
		 * Original YARD, Original CLPT_IND_SEQ + New YARD, New CLPT_IND_SEQ
		 * ------------------------------------------------------------------------------------
		 * VSK-SCE
		 * SCE_ACT_TMNL_IF
		 * Original/New Pair 관리필요.
		 * ====================================================================================
		 * [CASE]					[INDICATOR]			[TABLE NAME]
		 * ------------------------------------------------------------------------------------
		 * 1. ACT SKD I/F			:: 21,22,23			SCE_ACT_RCV_IF
		 * 2. TERMINAL CHANGE		:: 27				SCE_ACT_TML_IF
		 * 3. CLPT_IND_SEQ CHANGE	:: 72				SCE_ACT_TML_IF
		 * 4. EST SKD I/F			:: 24,25,26			SCE_VPS_IF
		 * 5. E-SVC SKD I/F			:: 28,29,30			SCE_SVC_PTAL_VPS_IF
		 * 6. ATD I/F				:: 23 ONLY			SCE_POD_ARR_VSL_SKD_HIS
		 * ====================================================================================
		 */
		try{
			
			if(vslSkdHisInVOs != null && vslSkdHisInVOs.size() > 0){
				// [Vessel Schedule History & COP 호출 데이터 생성. START]
				List<CstSkdByVvdVO> orgPortVoList = null;		//화면에서 변경되기 전의 Port List

				String 	preVvdCd 		= "";	//이전 VVD
				String 	curVvdCd 		= "";	//현재 VVD

				String 	vslCd 			= "";
				String 	skdVoyNo 		= "";
				String 	skdDirCd 		= "";
				String 	vpsPortCd 		= "";
				boolean skipCallFlag 	= false;
				boolean reConnectFlg 	= false;
				
				for(VslSkdHisInVO vslSkdHisInVO : vslSkdHisInVOs){
					//VVD 코드
					vslCd 				= vslSkdHisInVO.getVslCd();
					skdVoyNo 			= vslSkdHisInVO.getSkdVoyNo();
					skdDirCd 			= vslSkdHisInVO.getSkdDirCd();
					vpsPortCd 			= vslSkdHisInVO.getVpsPortCd();

					skipCallFlag 		= false;
					reConnectFlg 		= false;
					
					/////////////////////////////////////////////////////////////////////////////
					int iHisDtlTargetKnt		= 0;					//1이 되면 Next Vo로 이동한다.
					//::VSL_VSL_SKD_CNG_HIS_DTL 이력데이터 생성을 위한 Temporary VO:://
					VslSkdCngHisDtlVO	tmpVslSkdCngHisDtlVO 	= new VslSkdCngHisDtlVO();
					////////////////////////////////////////////////////////////////////////////

					/*
					 * ###################################################################################
					 * Booking 정보가 있을 경우만 아래 작업을 한다.
					 *
					 * History를 남긴다.
					 * BKG 에 변경내역 전송.
					 * SCE - COP 에 변경내역 전송.
					 * ###################################################################################
					 */
					VslPortSkdVO paramVO = new VslPortSkdVO();
					
					paramVO.setVslCd		(vslCd);
					paramVO.setSkdVoyNo		(skdVoyNo);
					paramVO.setSkdDirCd		(skdDirCd);
					paramVO.setVpsPortCd	(vpsPortCd);
					paramVO.setClptIndSeq	(vslSkdHisInVO.getClptIndSeq());
					paramVO.setVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt());		// Virtual Port SKD 삭제 후 재연결한 경우. (VOP_VSK_0015 화면) 2014.09.30
					paramVO.setVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt());		// Virtual Port SKD 삭제 후 재연결한 경우. (VOP_VSK_0015 화면) 2014.09.30
					paramVO.setVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt());		// Virtual Port SKD 삭제 후 재연결한 경우. (VOP_VSK_0015 화면) 2014.09.30
					paramVO.setYdCd			(vslSkdHisInVO.getYdCd());			// Virtual Port SKD 삭제 후 재연결한 경우. (VOP_VSK_0015 화면) 2014.09.30
					paramVO.setSkdCngStsCd	(vslSkdHisInVO.getSkdCngStsCd());	// Virtual Port SKD 삭제 후 재연결한 경우. (VOP_VSK_0015 화면) 2014.09.30
					
					VslPortSkdVO bkgCheckVO = null;

//					log.info("\n manageVslSkdChgSts VVD History 1 >>> "+paramVO.getVslCd() + "/"+paramVO.getSkdVoyNo() + "/"+paramVO.getSkdDirCd() + "/"+paramVO.getVpsPortCd() + "/"+paramVO.getClptIndSeq());
					
					if(!VSKGeneralUtil.isNull(vslSkdHisInVO.getClptIndSeq())){
						
						/*** VVD에 대한 BOOKING 정보 존재유무 조회 *************************************/
						bkgCheckVO = dbDao.checkVslSkdByRowID(paramVO);			 
						/***************************************************************************/

						if (bkgCheckVO != null && "T=V".equals(bkgCheckVO.getSkdCngStsCd())) {
							// "T=V" : Virtual Port 삭제 후 재연결시 COP 호출 대상을 찾기 위해 추가. (2014.09.30)
							reConnectFlg = true;
						}
						
						if(bkgCheckVO == null) {
							// Booking 정보가 있을 경우에는 다음 로직에서 History 정보를 생성하기 때문에 통과해도 된다.
							// 단, Skip 이후 Booking를 모두 다른 VVD로 옮겼을 경우를 감안하고 있다.
							skipCallFlag = dbDao.checkSkipCallHistory(vslSkdHisInVO); // Schedule History에 내 Skip Call이 있는지 확인.
						}
					}
					
					// [BOOKING NO_ATTACHE 처리부 END]
					if(bkgCheckVO != null && !"".equals(bkgCheckVO.getVpsPortCd()) || skipCallFlag ){
						// [BOOKING NO_ATTACHE 처리부 START] 
						curVvdCd = vslCd + skdVoyNo + skdDirCd;

						// VVD 가 여러 건일 수 있으므로.
						if(!preVvdCd.equals(curVvdCd)){
							preVvdCd = curVvdCd;

							// 해당 VVD의 변경되기전의 Port 정보를 조회한다.
							CstSkdByVvdVO orgParamVO = new CstSkdByVvdVO();
							orgParamVO.setVslCd		(vslCd);
							orgParamVO.setSkdVoyNo	(skdVoyNo);
							orgParamVO.setSkdDirCd	(skdDirCd);
							orgPortVoList = dbDao.searchCstSkdByVvd(orgParamVO);

							// Master 정보 변경 시 History 남기기 위해(Lane, VVD 삭제)
							boolean mstFlg = true;
							for(VskVslSkdVO mstVO : masterVOList){
								if(vslCd.equals(mstVO.getVslCd()) && skdVoyNo.equals(mstVO.getSkdVoyNo()) && skdDirCd.equals(mstVO.getSkdDirCd())){
									mstFlg = false;
									break;
								}
							}
							// 기존 Master 정보에 없을 경우에만 ADD.
							if(mstFlg){
								VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
								vskVslSkdVO.setVslCd	(vslCd);
								vskVslSkdVO.setSkdVoyNo	(skdVoyNo);
								vskVslSkdVO.setSkdDirCd	(skdDirCd);
								vskVslSkdVO.setCreUsrId	(vslSkdHisInVO.getUsrId());
								vskVslSkdVO.setUpdUsrId	(vslSkdHisInVO.getUsrId());

								masterVOList.add(vskVslSkdVO);
							}
						}

						CstSkdByVvdVO orgPortVO = null;

						//해당 Skip 된 변경 전의 Port 정보를 찾는다.
						if(orgPortVoList != null && orgPortVoList.size() > 0){
							for(CstSkdByVvdVO cstSkdByVvdVO : orgPortVoList){
								if(vslSkdHisInVO.getVpsPortCd().equals(cstSkdByVvdVO.getVpsPortCd())
										&& vslSkdHisInVO.getClptIndSeq()!= null
										&& vslSkdHisInVO.getClptIndSeq().equals(cstSkdByVvdVO.getClptIndSeq())){

									orgPortVO = cstSkdByVvdVO;
									break;
								}
							}
						}

						/*
						 * VskdCngTpCd - reason code
						 * 'S' : Port Skip
						 * 'O' : Phase Out
						 * 'V' : VVD delete
						 * 'T' : PORT delete (no Virtual Port)
						 * 'D' : PORT delete (Virtual Port)
						 * 'L' : Lane change
						 * 'E' : ETA, ETB, ETD
						 * 'Y' : YARD change
						 * 'P' : change CALLING SEQUENCE
						 * =====================================
						 * 'A' >> Add Calling Cancellation
						 * -------------------------------------
						 * 'A' : ADHOC(ADD CALL) CANCELLATION
						 * =====================================
						 */
						
						if(orgPortVO != null && "A".equals(vslSkdHisInVO.getSkdCngStsCd()) && !reConnectFlg){
							
							//***** 'A' : ADHOC CANCELLATION *****
							VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO();
							VslSkdCngNoticeVO 	vslSkdCngNoticeVO 	= new VslSkdCngNoticeVO();
								
							/*
							 * VSKD_TP_CD - where data change
							 * 
							 * M : Vessel Schedule
							 * P : Vessel Port Schedule (Default)
							 */
								
							vskVslSkdHisVO.setVskdTpCd		("P");
							vskVslSkdHisVO.setBfrVslCd		(vslSkdHisInVO.getVslCd		());
							vskVslSkdHisVO.setBfrSkdVoyNo	(vslSkdHisInVO.getSkdVoyNo	());
							vskVslSkdHisVO.setBfrSkdDirCd	(vslSkdHisInVO.getSkdDirCd	());
							vskVslSkdHisVO.setBfrVslSlanCd	(vslSkdHisInVO.getVslSlanCd	());
							vskVslSkdHisVO.setBfrVpsEtaDt	(vslSkdHisInVO.getVpsEtaDt	());
							vskVslSkdHisVO.setBfrVpsEtbDt	(vslSkdHisInVO.getVpsEtbDt	());
							vskVslSkdHisVO.setBfrVpsEtdDt	(vslSkdHisInVO.getVpsEtdDt	());
							vskVslSkdHisVO.setBfrVpsPortCd	(vslSkdHisInVO.getVpsPortCd	());
							vskVslSkdHisVO.setBfrClptIndSeq	(vslSkdHisInVO.getClptIndSeq());
							vskVslSkdHisVO.setBfrYdCd		(vslSkdHisInVO.getYdCd		());
							vskVslSkdHisVO.setVskdCngTpCd	("A");							//'A' : ADHOC CANCELLATION vs cf)"T":Port Deletion
							vskVslSkdHisVO.setCreUsrId		(vslSkdHisInVO.getUsrId	());
							vskVslSkdHisVO.setUpdUsrId		(vslSkdHisInVO.getUsrId	());
									
							historyList.add					(vskVslSkdHisVO);

							vslSkdCngNoticeVO.setVslCd		(vslCd);
							vslSkdCngNoticeVO.setSkdVoyNo	(skdVoyNo);
							vslSkdCngNoticeVO.setSkdDirCd	(skdDirCd);
							vslSkdCngNoticeVO.setPortCd		(vslSkdHisInVO.getVpsPortCd	());
							vslSkdCngNoticeVO.setClptIndSeq	(vslSkdHisInVO.getClptIndSeq());
							vslSkdCngNoticeVO.setYdCd		(vslSkdHisInVO.getYdCd		());
							vslSkdCngNoticeVO.setTypeCd		("A");
							vslSkdCngNoticeVO.setRemark		("ADD CALL CANCELLATION");
									
							bkgVslSkdCngNoticeList.add				(vslSkdCngNoticeVO);
						}
																		
						if(orgPortVO != null && !reConnectFlg){
							//***** 'S' : Port Skip() *****
							//기존 데이타가 Skip 이 아니었고
							if(!"S".equals(orgPortVO.getSkdCngStsCd())){
								//새로 입력된 데이타가 Skip 이면
								if("S".equals(vslSkdHisInVO.getSkdCngStsCd())){
									VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO();
									VslSkdCngNoticeVO 	vslSkdCngNoticeVO 	= new VslSkdCngNoticeVO();

									/*
									 * VSKD_TP_CD - Vessel Schedule에서 변경했는지, Vessel Port Schedule에서 변경된 내용인지를 구분.
									 *
									 * M : Vessel Schedule
									 * P : Vessel Port Schedule (Default)
									 */
									vskVslSkdHisVO.setVskdTpCd		("P");
									vskVslSkdHisVO.setBfrVslCd		(orgPortVO.getVslCd());
									vskVslSkdHisVO.setBfrSkdVoyNo	(orgPortVO.getSkdVoyNo());
									vskVslSkdHisVO.setBfrSkdDirCd	(orgPortVO.getSkdDirCd());
									vskVslSkdHisVO.setBfrVslSlanCd	(orgPortVO.getVslSlanCd());
									vskVslSkdHisVO.setBfrVpsEtaDt	(orgPortVO.getVpsEtaDt());
									vskVslSkdHisVO.setBfrVpsEtbDt	(orgPortVO.getVpsEtbDt());
									vskVslSkdHisVO.setBfrVpsEtdDt	(orgPortVO.getVpsEtdDt());
									vskVslSkdHisVO.setBfrVpsPortCd	(orgPortVO.getVpsPortCd());
									vskVslSkdHisVO.setBfrClptIndSeq	(orgPortVO.getClptIndSeq());
									vskVslSkdHisVO.setBfrYdCd		(orgPortVO.getYdCd());
									vskVslSkdHisVO.setVskdCngTpCd	("S");							//변경된 이유를 CODE화 하여 표시 - 'S' : Port Skip()
									vskVslSkdHisVO.setCreUsrId		(vslSkdHisInVO.getUsrId());
									vskVslSkdHisVO.setUpdUsrId		(vslSkdHisInVO.getUsrId());

									historyList.add					(vskVslSkdHisVO);

									/* --------------------------------------------------------------------
									 * PORT SKIP에 대한 TO BKG NOTICE
									 * --------------------------------------------------------------------
									 * PORT SKIP : "S"
									 */
									vslSkdCngNoticeVO.setVslCd		(vslCd							);
									vslSkdCngNoticeVO.setSkdVoyNo	(skdVoyNo						);
									vslSkdCngNoticeVO.setSkdDirCd	(skdDirCd						);
									vslSkdCngNoticeVO.setPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
									vslSkdCngNoticeVO.setClptIndSeq	(vslSkdHisInVO.getClptIndSeq()	);
									vslSkdCngNoticeVO.setYdCd		(vslSkdHisInVO.getYdCd		()	);
									vslSkdCngNoticeVO.setTypeCd		("S"							);
									vslSkdCngNoticeVO.setRemark		("Skip"							);

									bkgVslSkdCngNoticeList.add		(vslSkdCngNoticeVO);
									
									if( iHisDtlTargetKnt == 0){
										/* --------------------------------------------------------------------
										 * PORT SKIP에 대한 VSK VESSEL SCHEDULE HISTORY
										 * --------------------------------------------------------------------
										 * PORT SKIP : "S"
										 */
										
										tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
										tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
										tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
										tmpVslSkdCngHisDtlVO.setVpsPortCd		(vpsPortCd							);
										tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
										tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("S"								);
										
										iHisDtlTargetKnt ++;
									}
								}
							}
							
							/*
							 * Orginal SKD 이 Skip 이지만, 화면에서 Skip Call Cancel 일 경우.
							 *
							 */
							if("S".equals(orgPortVO.getSkdCngStsCd())){
								//새로 입력된 데이타가 Skip Cancel이면
								if("".equals(vslSkdHisInVO.getSkdCngStsCd())){
									VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO();
									VslSkdCngNoticeVO 	vslSkdCngNoticeVO 	= new VslSkdCngNoticeVO();

									/*
									 * VSKD_TP_CD - Vessel Schedule에서 변경했는지, Vessel Port Schedule에서 변경된 내용인지를 구분.
									 *
									 * M : Vessel Schedule
									 * P : Vessel Port Schedule (Default)
									 */
									vskVslSkdHisVO.setVskdTpCd		("P");
									vskVslSkdHisVO.setBfrVslCd		(orgPortVO.getVslCd());
									vskVslSkdHisVO.setBfrSkdVoyNo	(orgPortVO.getSkdVoyNo());
									vskVslSkdHisVO.setBfrSkdDirCd	(orgPortVO.getSkdDirCd());
									vskVslSkdHisVO.setBfrVslSlanCd	(orgPortVO.getVslSlanCd());
									vskVslSkdHisVO.setBfrVpsEtaDt	(orgPortVO.getVpsEtaDt());
									vskVslSkdHisVO.setBfrVpsEtbDt	(orgPortVO.getVpsEtbDt());
									vskVslSkdHisVO.setBfrVpsEtdDt	(orgPortVO.getVpsEtdDt());
									vskVslSkdHisVO.setBfrVpsPortCd	(orgPortVO.getVpsPortCd());
									vskVslSkdHisVO.setBfrClptIndSeq	(orgPortVO.getClptIndSeq());
									vskVslSkdHisVO.setBfrYdCd		(orgPortVO.getYdCd());
									vskVslSkdHisVO.setVskdCngTpCd	("X");					//변경된 이유를 CODE화 하여 표시 - 'X' : Skip Cancel
									vskVslSkdHisVO.setCreUsrId		(vslSkdHisInVO.getUsrId());
									vskVslSkdHisVO.setUpdUsrId		(vslSkdHisInVO.getUsrId());

									historyList.add					(vskVslSkdHisVO);

									/* --------------------------------------------------------------------
									 * PORT SKIP CANCEL에 대한 TO BKG NOTICE
									 * --------------------------------------------------------------------
									 * PORT SKIP : "X"
									 */
									vslSkdCngNoticeVO.setVslCd		(vslCd							);
									vslSkdCngNoticeVO.setSkdVoyNo	(skdVoyNo						);
									vslSkdCngNoticeVO.setSkdDirCd	(skdDirCd						);
									vslSkdCngNoticeVO.setPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
									vslSkdCngNoticeVO.setClptIndSeq	(vslSkdHisInVO.getClptIndSeq()	);
									vslSkdCngNoticeVO.setYdCd		(vslSkdHisInVO.getYdCd		()	);
									vslSkdCngNoticeVO.setTypeCd		("X"							);
									vslSkdCngNoticeVO.setRemark		("Skip Cancel"					);

									bkgVslSkdCngNoticeList.add		(vslSkdCngNoticeVO);
				
									
									if( iHisDtlTargetKnt == 0){
										/* --------------------------------------------------------------------
										 * SKIP CANCEL에 대한 VSK VESSEL SCHEDULE HISTORY
										 * --------------------------------------------------------------------
										 * SKIP CANCEK : "X"
										 */
										
										tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
										tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
										tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
										tmpVslSkdCngHisDtlVO.setVpsPortCd		(vpsPortCd							);
										tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
										tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("X"								);
										
										iHisDtlTargetKnt ++;
									}
								}
							}

							//***** 'O' : Phase Out *****
							if("O".equals(vslSkdHisInVO.getSkdCngStsCd())){
								VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO();
								VslSkdCngNoticeVO 	vslSkdCngNoticeVO 	= new VslSkdCngNoticeVO();

								// history...
								vskVslSkdHisVO.setVskdTpCd		("P");
								vskVslSkdHisVO.setBfrVslCd		(orgPortVO.getVslCd());
								vskVslSkdHisVO.setBfrSkdVoyNo	(orgPortVO.getSkdVoyNo());
								vskVslSkdHisVO.setBfrSkdDirCd	(orgPortVO.getSkdDirCd());
								vskVslSkdHisVO.setBfrVslSlanCd	(orgPortVO.getVslSlanCd());
								vskVslSkdHisVO.setBfrVpsEtaDt	(orgPortVO.getVpsEtaDt());
								vskVslSkdHisVO.setBfrVpsEtbDt	(orgPortVO.getVpsEtbDt());
								vskVslSkdHisVO.setBfrVpsEtdDt	(orgPortVO.getVpsEtdDt());
								vskVslSkdHisVO.setBfrVpsPortCd	(orgPortVO.getVpsPortCd());
								vskVslSkdHisVO.setBfrClptIndSeq	(orgPortVO.getClptIndSeq());
								vskVslSkdHisVO.setBfrYdCd		(orgPortVO.getYdCd());
								vskVslSkdHisVO.setAftVslCd		(vslSkdHisInVO.getCngVslCd());
								vskVslSkdHisVO.setAftSkdVoyNo	(vslSkdHisInVO.getCngSkdVoyNo());
								vskVslSkdHisVO.setAftSkdDirCd	(vslSkdHisInVO.getCngSkdDirCd());
								vskVslSkdHisVO.setAftVslSlanCd	(vslSkdHisInVO.getCngLaneCd());
								vskVslSkdHisVO.setDiffRmk		("Phase Out");
								vskVslSkdHisVO.setVskdCngTpCd	("O");							//변경된 이유를 CODE화 하여 표시 - 'O' : Phase Out
								vskVslSkdHisVO.setCreUsrId		(vslSkdHisInVO.getUsrId());
								vskVslSkdHisVO.setUpdUsrId		(vslSkdHisInVO.getUsrId());

								historyList.add					(vskVslSkdHisVO);

								/* --------------------------------------------------------------------
								 * PORT PHASE-OUT에 대한 TO BKG NOTICE
								 * --------------------------------------------------------------------
								 * PORT PHASE-OUT : "O"
								 */
								vslSkdCngNoticeVO.setVslCd		(vslCd							);
								vslSkdCngNoticeVO.setSkdVoyNo	(skdVoyNo						);
								vslSkdCngNoticeVO.setSkdDirCd	(skdDirCd						);
								vslSkdCngNoticeVO.setPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
								vslSkdCngNoticeVO.setClptIndSeq	(vslSkdHisInVO.getClptIndSeq()	);
								vslSkdCngNoticeVO.setYdCd		(vslSkdHisInVO.getYdCd		()	);
								vslSkdCngNoticeVO.setTypeCd		("O"							);
								vslSkdCngNoticeVO.setRemark		("Phase Out"					);

								bkgVslSkdCngNoticeList.add		(vslSkdCngNoticeVO);
								
								if( iHisDtlTargetKnt == 0){
									/* --------------------------------------------------------------------
									 * PHASE OUT에 대한 VSK VESSEL SCHEDULE HISTORY
									 * --------------------------------------------------------------------
									 * PHASE OUT : "O"
									 */ 
									
									tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
									tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
									tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
									tmpVslSkdCngHisDtlVO.setVpsPortCd		(vpsPortCd							);
									tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
									tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("O"								);
									
									iHisDtlTargetKnt ++;
								}
							}

							//***** 'T' : Port 삭제 *****
							if("D".equals(vslSkdHisInVO.getIbflag())){
								VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO();
								VslSkdCngNoticeVO 	vslSkdCngNoticeVO 	= new VslSkdCngNoticeVO();

								String vskdCngTpCd 	= "T";
								String diffRmk 		= "Port Delete";
								if(VSKGeneralUtil.isVirtualPort(vslSkdHisInVO.getTurnPortIndCd())){
									vskdCngTpCd = "D";	// Virtual Port 삭제인 경우 Code 를 구분
									diffRmk 	= "Virtual Port Delete";
								}

								// history...
								vskVslSkdHisVO.setVskdTpCd			("P");
								vskVslSkdHisVO.setBfrVslCd			(orgPortVO.getVslCd				());
								vskVslSkdHisVO.setBfrSkdVoyNo		(orgPortVO.getSkdVoyNo			());
								vskVslSkdHisVO.setBfrSkdDirCd		(orgPortVO.getSkdDirCd			());
								vskVslSkdHisVO.setBfrVslSlanCd		(orgPortVO.getVslSlanCd			());
								vskVslSkdHisVO.setBfrVpsEtaDt		(orgPortVO.getVpsEtaDt			());
								vskVslSkdHisVO.setBfrVpsEtbDt		(orgPortVO.getVpsEtbDt			());
								vskVslSkdHisVO.setBfrVpsEtdDt		(orgPortVO.getVpsEtdDt			());
								vskVslSkdHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd			());
								vskVslSkdHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq		());
								vskVslSkdHisVO.setBfrYdCd			(orgPortVO.getYdCd				());
								vskVslSkdHisVO.setAftVslCd			(vslSkdHisInVO.getCngVslCd		());
								vskVslSkdHisVO.setAftSkdVoyNo		(vslSkdHisInVO.getCngSkdVoyNo	());
								vskVslSkdHisVO.setAftSkdDirCd		(vslSkdHisInVO.getCngSkdDirCd	());
								vskVslSkdHisVO.setAftVslSlanCd		(vslSkdHisInVO.getCngLaneCd		());
								vskVslSkdHisVO.setDiffRmk			(diffRmk							);
								vskVslSkdHisVO.setVskdCngTpCd		(vskdCngTpCd						);	//변경된 이유를 CODE화 하여 표시 - 'T' : Port Delete
								vskVslSkdHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			());
								vskVslSkdHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			());

								historyList.add						(vskVslSkdHisVO);

								/* --------------------------------------------------------------------
								 * PORT DELETION에 대한 TO BKG NOTICE
								 * --------------------------------------------------------------------
								 * NORMAL/TURNING PORT DELETION : "T"
								 * VIRTUAL 		  PORT DELETION : "D"
								 */
								vslSkdCngNoticeVO.setVslCd			(vslCd							);
								vslSkdCngNoticeVO.setSkdVoyNo		(skdVoyNo						);
								vslSkdCngNoticeVO.setSkdDirCd		(skdDirCd						);
								vslSkdCngNoticeVO.setPortCd			(vslSkdHisInVO.getVpsPortCd	()	);
								vslSkdCngNoticeVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq()	);
								vslSkdCngNoticeVO.setYdCd			(vslSkdHisInVO.getYdCd		()	);
								vslSkdCngNoticeVO.setTypeCd			(vskdCngTpCd					);
								vslSkdCngNoticeVO.setRemark			(diffRmk						);

								bkgVslSkdCngNoticeList.add			(vslSkdCngNoticeVO);
							}
							else {
								//***** 'E' : ETA, ETB, ETD *****
								if(        ((!vslSkdHisInVO.getVpsEtaDt().equals(orgPortVO.getVpsEtaDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtaDt())))
										|| ((!vslSkdHisInVO.getVpsEtbDt().equals(orgPortVO.getVpsEtbDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtbDt())))
										|| ((!vslSkdHisInVO.getVpsEtdDt().equals(orgPortVO.getVpsEtdDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtdDt())))
								){
									VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();

									vskVslSkdHisVO.setVskdTpCd		("P");
									vskVslSkdHisVO.setBfrVslCd		(orgPortVO.getVslCd			()	);
									vskVslSkdHisVO.setBfrSkdVoyNo	(orgPortVO.getSkdVoyNo		()	);
									vskVslSkdHisVO.setBfrSkdDirCd	(orgPortVO.getSkdDirCd		()	);
									vskVslSkdHisVO.setBfrVslSlanCd	(orgPortVO.getVslSlanCd		()	);
									vskVslSkdHisVO.setBfrVpsEtaDt	(orgPortVO.getVpsEtaDt		()	);
									vskVslSkdHisVO.setBfrVpsEtbDt	(orgPortVO.getVpsEtbDt		()	);
									vskVslSkdHisVO.setBfrVpsEtdDt	(orgPortVO.getVpsEtdDt		()	);
									vskVslSkdHisVO.setBfrVpsPortCd	(orgPortVO.getVpsPortCd		()	);
									vskVslSkdHisVO.setBfrClptIndSeq	(orgPortVO.getClptIndSeq	()	);
									vskVslSkdHisVO.setBfrYdCd		(orgPortVO.getYdCd			()	);
									vskVslSkdHisVO.setAftVslCd		(vslSkdHisInVO.getVslCd		()	);
									vskVslSkdHisVO.setAftSkdVoyNo	(vslSkdHisInVO.getSkdVoyNo	()	);
									vskVslSkdHisVO.setAftSkdDirCd	(vslSkdHisInVO.getSkdDirCd	()	);
									vskVslSkdHisVO.setAftVpsEtaDt	(vslSkdHisInVO.getVpsEtaDt	()	);
									vskVslSkdHisVO.setAftVpsEtbDt	(vslSkdHisInVO.getVpsEtbDt	()	);
									vskVslSkdHisVO.setAftVpsEtdDt	(vslSkdHisInVO.getVpsEtdDt	()	);
									vskVslSkdHisVO.setVskdCngTpCd	("E");								//변경된 이유를 CODE화 하여 표시 - 'E' : ETA, ETB, ETD
									vskVslSkdHisVO.setCreUsrId		(vslSkdHisInVO.getUsrId		()	);
									vskVslSkdHisVO.setUpdUsrId		(vslSkdHisInVO.getUsrId		()	);

									historyList.add					(vskVslSkdHisVO);
									
									if( iHisDtlTargetKnt == 0){
										/* --------------------------------------------------------------------
										 * ETA, ETB, ETD CHANGE에 대한 VSK VESSEL SCHEDULE HISTORY
										 * --------------------------------------------------------------------
										 * ETA, ETB, ETD CHANGE : "E"
										 */
										
										tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
										tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
										tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
										tmpVslSkdCngHisDtlVO.setVpsPortCd		(vpsPortCd							);
										tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
										tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("E"								);
										
										iHisDtlTargetKnt ++;
									}
									
									// cop...
									/*
									 *  IF( UPDATING ) THEN 일때 Act Rcv Dt
									 *  1. ATA가 변경된 경우 "21"
									 *  2. ATB가 변경된 경우 "22"
									 *  3. ATD가 변경된 경우 "23"
									 *  4. ETA가 변경된 경우 "24"  :: ETA DELAY NOTICE 대상임. (BKG.POD.ETA 기준 +5hrs 및 일자가 다른경우 ::
									 *  5. ETB가 변경된 경우 "25"
									 *  6. ETD가 변경된 경우 "26"
									 *  7. YD가 변경된 경우  "27"
									 *  -----------------------------------
									 *  8. Call Indicator Seq. 변경 "72" ::정상기::bkg-vsk-sce-prd::2013-03-19//
									 */
									if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtaDt())){
										if(!vslSkdHisInVO.getVpsEtaDt().equals(orgPortVO.getVpsEtaDt())){
											SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO					();
											sceActRcvIfVO.setActRcvTpCd		("24");
											sceActRcvIfVO.setActDt			(vslSkdHisInVO.getVpsEtaDt			()	);
											sceActRcvIfVO.setNodCd			(vslSkdHisInVO.getYdCd				()	);
											sceActRcvIfVO.setVslCd			(vslCd									);
											sceActRcvIfVO.setSkdVoyNo		(skdVoyNo								);
											sceActRcvIfVO.setSkdDirCd		(skdDirCd								);
											sceActRcvIfVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd			()	);
											sceActRcvIfVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq		()	);
											sceActRcvIfVO.setVslDlayRsnCd	(vslSkdHisInVO.getVslDlayRsnCd		()	);
											sceActRcvIfVO.setVslDlayRsnDesc	(vslSkdHisInVO.getVslDlayRsnDesc	()	);
											sceActRcvIfVO.setVpsLocCd		(vslSkdHisInVO.getVslDlayRsnLocCd	()	);
											sceActRcvIfVO.setCreUsrId		(vslSkdHisInVO.getUsrId());

											copNoticeList.add				(sceActRcvIfVO);
											
											/***************************************************************
											 * Booking POD ETA Delay NOTICE 발송
											 * -------------------------------------------------------------
											 * BKG POD Original ETA 기준 +5hrs & 일자가 다른경우.
											 * 
											 * int compareSkdDate(String date1, String format1, String date2, String format2)
											 * - d1.after(d2) :: return 1
											 ***************************************************************/
											
											//log.info("\n\n ::jskjskjsk::compareSkdDate:: ["+VSKGeneralUtil.compareSkdDate(vslSkdHisInVO.getVpsEtaDt(), "yyyyMMddHHmm", orgPortVO.getVpsEtaDt(), "yyyyMMddHHmm" )+"]\n");
											
											if(!vslSkdHisInVO.getVpsEtaDt().equals(orgPortVO.getVpsEtaDt()) 
												&& VSKGeneralUtil.compareSkdDate(vslSkdHisInVO.getVpsEtaDt(), "yyyyMMddHHmm", orgPortVO.getVpsEtaDt(), "yyyyMMddHHmm") == 1){
												VslSkdCngUpdateVO 	vslSkdCngUpdateVO 	= new VslSkdCngUpdateVO	();
												
												vslSkdCngUpdateVO.setVvd			(vslCd+skdVoyNo+skdDirCd		);
												vslSkdCngUpdateVO.setPortCd			(vslSkdHisInVO.getVpsPortCd	()	);
												vslSkdCngUpdateVO.setOldClptIndSeq	(orgPortVO.getClptIndSeq	()	);
												vslSkdCngUpdateVO.setOldYdCd		(orgPortVO.getYdCd			()	);
												vslSkdCngUpdateVO.setOldEtaDt		(orgPortVO.getVpsEtaDt		()	);	//::adding.2013-04-22:://
												//vslSkdCngUpdateVO.setSkdCngTpCd		("ETA"							);	//Delay Notice ETA+ETD일경우 추가예정//
												vslSkdCngUpdateVO.setNewClptIndSeq	(vslSkdHisInVO.getClptIndSeq()	);
												vslSkdCngUpdateVO.setNewYdCd		(vslSkdHisInVO.getYdCd		()	);

												bkgVslSkdEtaDelayNoticeList.add		(vslSkdCngUpdateVO);
											}
										}
									}
									if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtbDt())){
										if(!vslSkdHisInVO.getVpsEtbDt().equals(orgPortVO.getVpsEtbDt())){
											SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO					();
											sceActRcvIfVO.setActRcvTpCd		("25");
											sceActRcvIfVO.setActDt			(vslSkdHisInVO.getVpsEtbDt			()	);
											sceActRcvIfVO.setVslCd			(vslCd									);
											sceActRcvIfVO.setSkdVoyNo		(skdVoyNo								);
											sceActRcvIfVO.setSkdDirCd		(skdDirCd								);
											sceActRcvIfVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd			()	);
											sceActRcvIfVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq		()	);
											sceActRcvIfVO.setVslDlayRsnCd	(vslSkdHisInVO.getVslDlayRsnCd		()	);
											sceActRcvIfVO.setVslDlayRsnDesc	(vslSkdHisInVO.getVslDlayRsnDesc	()	);
											sceActRcvIfVO.setVpsLocCd		(vslSkdHisInVO.getVslDlayRsnLocCd	()	);
											sceActRcvIfVO.setNodCd			(vslSkdHisInVO.getYdCd				()	);
											sceActRcvIfVO.setCreUsrId		(vslSkdHisInVO.getUsrId				()	);

											copNoticeList.add				(sceActRcvIfVO);
										}
									}
									if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtdDt())){
										if(!vslSkdHisInVO.getVpsEtdDt().equals(orgPortVO.getVpsEtdDt())){
											SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO					();
											sceActRcvIfVO.setActRcvTpCd		("26");
											sceActRcvIfVO.setActDt			(vslSkdHisInVO.getVpsEtdDt			()	);
											sceActRcvIfVO.setVslCd			(vslCd									);
											sceActRcvIfVO.setSkdVoyNo		(skdVoyNo								);
											sceActRcvIfVO.setSkdDirCd		(skdDirCd								);
											sceActRcvIfVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd			()	);
											sceActRcvIfVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq		()	);
											sceActRcvIfVO.setVslDlayRsnCd	(vslSkdHisInVO.getVslDlayRsnCd		()	);
											sceActRcvIfVO.setVslDlayRsnDesc	(vslSkdHisInVO.getVslDlayRsnDesc	()	);
											sceActRcvIfVO.setVpsLocCd		(vslSkdHisInVO.getVslDlayRsnLocCd	()	);
											sceActRcvIfVO.setNodCd			(vslSkdHisInVO.getYdCd				()	);
											sceActRcvIfVO.setCreUsrId		(vslSkdHisInVO.getUsrId				()	);

											copNoticeList.add				(sceActRcvIfVO);
										}
									}
								}

								//***** 'Y' : YARD 변경 *****
								if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getYdCd())){
									if(!vslSkdHisInVO.getYdCd().equals(orgPortVO.getYdCd())){
										VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO();
										VslSkdCngUpdateVO 	vslSkdCngUpdateVO 	= new VslSkdCngUpdateVO();

										// history...
										vskVslSkdHisVO.setVskdTpCd			("P");
										vskVslSkdHisVO.setBfrVslCd			(orgPortVO.getVslCd());
										vskVslSkdHisVO.setBfrSkdVoyNo		(orgPortVO.getSkdVoyNo());
										vskVslSkdHisVO.setBfrSkdDirCd		(orgPortVO.getSkdDirCd());
										vskVslSkdHisVO.setBfrVslSlanCd		(orgPortVO.getVslSlanCd());
										vskVslSkdHisVO.setBfrVpsEtaDt		(orgPortVO.getVpsEtaDt());
										vskVslSkdHisVO.setBfrVpsEtbDt		(orgPortVO.getVpsEtbDt());
										vskVslSkdHisVO.setBfrVpsEtdDt		(orgPortVO.getVpsEtdDt());
										vskVslSkdHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd());
										vskVslSkdHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq());
										vskVslSkdHisVO.setBfrYdCd			(orgPortVO.getYdCd());
										vskVslSkdHisVO.setAftVslCd			(vslSkdHisInVO.getVslCd());
										vskVslSkdHisVO.setAftSkdVoyNo		(vslSkdHisInVO.getSkdVoyNo());
										vskVslSkdHisVO.setAftSkdDirCd		(vslSkdHisInVO.getSkdDirCd());
										vskVslSkdHisVO.setAftVslSlanCd		(vslSkdHisInVO.getVslSlanCd());
										vskVslSkdHisVO.setAftVpsPortCd		(vslSkdHisInVO.getVpsPortCd());
										vskVslSkdHisVO.setAftClptIndSeq		(vslSkdHisInVO.getClptIndSeq());
										vskVslSkdHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd());
										vskVslSkdHisVO.setVskdCngTpCd		("Y");					//변경된 이유를 CODE화 하여 표시 - 'Y' : YARD 변경
										vskVslSkdHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId());
										vskVslSkdHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId());

										historyList.add						(vskVslSkdHisVO);

										// booking...
										vslSkdCngUpdateVO.setVvd			(vslCd + skdVoyNo + skdDirCd);
										vslSkdCngUpdateVO.setPortCd			(vslSkdHisInVO.getVpsPortCd	());
										vslSkdCngUpdateVO.setOldClptIndSeq	(orgPortVO.getClptIndSeq	());
										vslSkdCngUpdateVO.setNewClptIndSeq	(vslSkdHisInVO.getClptIndSeq());
										vslSkdCngUpdateVO.setOldYdCd		(orgPortVO.getYdCd			());
										vslSkdCngUpdateVO.setNewYdCd		(vslSkdHisInVO.getYdCd		());

										bkgUpdateList.add					(vslSkdCngUpdateVO);

										// cop...
										SceActRcvIfVO sceActRcvIfVO 		= new SceActRcvIfVO();
										sceActRcvIfVO.setActRcvTpCd			("27");
										sceActRcvIfVO.setVslCd				(vslCd									);
										sceActRcvIfVO.setSkdVoyNo			(skdVoyNo								);
										sceActRcvIfVO.setSkdDirCd			(skdDirCd								);
										sceActRcvIfVO.setVpsPortCd			(vslSkdHisInVO.getVpsPortCd			()	);
										sceActRcvIfVO.setClptIndSeq			(vslSkdHisInVO.getClptIndSeq		()	);
										sceActRcvIfVO.setVslDlayRsnCd		(vslSkdHisInVO.getVslDlayRsnCd		()	);
										sceActRcvIfVO.setVslDlayRsnDesc		(vslSkdHisInVO.getVslDlayRsnDesc	()	);
										sceActRcvIfVO.setVpsLocCd			(vslSkdHisInVO.getVslDlayRsnLocCd	()	);
										sceActRcvIfVO.setNodCd				(vslSkdHisInVO.getYdCd				()	);
										sceActRcvIfVO.setCreUsrId			(vslSkdHisInVO.getUsrId				()	);
										
										//8. Call Indicator Seq. 변경 "72" ::정상기::bkg-vsk-sce-prd::2013-03-19//
										sceActRcvIfVO.setCallYdIndCngFlg("N");
										/////////////////////////////////////////////////////////////////////////
										
										copNoticeList.add(sceActRcvIfVO);
										
										if( iHisDtlTargetKnt == 0){
											/* --------------------------------------------------------------------
											 * YARD CHANGE에 대한 VSK VESSEL SCHEDULE HISTORY
											 * --------------------------------------------------------------------
											 * YARD CAHNGE : "Y"
											 */
											tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
											tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
											tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
											tmpVslSkdCngHisDtlVO.setVpsPortCd		(vpsPortCd							);
											tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
											tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("Y"								);
											
											iHisDtlTargetKnt ++;
										}									
									}
								}

								//***** 'P' : PORT의 CALLING SEQUENCE 변경 *****
								//8. Call Indicator Seq. 변경 "72" ::정상기::bkg-vsk-sce-prd::2013-03-19//
								if(!vslSkdHisInVO.getClptIndSeq().equals(vslSkdHisInVO.getNewClptIndSeq())){
									VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO();
									VslSkdCngUpdateVO 	vslSkdCngUpdateVO 	= new VslSkdCngUpdateVO();

									vskVslSkdHisVO.setVskdTpCd			("P");
									vskVslSkdHisVO.setBfrVslCd			(orgPortVO.getVslCd				());
									vskVslSkdHisVO.setBfrSkdVoyNo		(orgPortVO.getSkdVoyNo			());
									vskVslSkdHisVO.setBfrSkdDirCd		(orgPortVO.getSkdDirCd			());
									vskVslSkdHisVO.setBfrVslSlanCd		(orgPortVO.getVslSlanCd			());
									vskVslSkdHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd			());
									vskVslSkdHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq		());
									vskVslSkdHisVO.setAftVslCd			(vslSkdHisInVO.getVslCd			());
									vskVslSkdHisVO.setAftSkdVoyNo		(vslSkdHisInVO.getSkdVoyNo		());
									vskVslSkdHisVO.setAftSkdDirCd		(vslSkdHisInVO.getSkdDirCd		());
									vskVslSkdHisVO.setAftVslSlanCd		(vslSkdHisInVO.getVslSlanCd		());
									vskVslSkdHisVO.setAftVpsPortCd		(vslSkdHisInVO.getVpsPortCd		());
									vskVslSkdHisVO.setAftClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	());
									vskVslSkdHisVO.setVskdCngTpCd		("P");					//변경된 이유를 CODE화 하여 표시 - 'P' : PORT의 CALLING SEQUENCE 변경
									vskVslSkdHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			());
									vskVslSkdHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			());
									
									vskVslSkdHisVO.setBfrYdCd			(orgPortVO.getYdCd				());
									vskVslSkdHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd			());

									historyList.add						(vskVslSkdHisVO);

									//booking
									vslSkdCngUpdateVO.setVvd			(vslCd + skdVoyNo + skdDirCd		);
									vslSkdCngUpdateVO.setPortCd			(vslSkdHisInVO.getVpsPortCd		()	);
									
									vslSkdCngUpdateVO.setOldClptIndSeq	(orgPortVO.getClptIndSeq		()	);
									//vslSkdCngUpdateVO.setNewClptIndSeq(vslSkdHisInVO.getClptIndSeq());
									
									/************************************************************************
									 * After CLPT_IND_SEQ Omitting in case of interfacing to BKG.
									 *=======================================================================
									 * inforced exception
									 ************************************************************************/
									if(vslSkdHisInVO.getNewClptIndSeq() == null || "".equals(vslSkdHisInVO.getNewClptIndSeq())){
										//Unexpected system error took place during data processing. Please try again. : {?msg1}
										StringBuffer	tmpErrMsg	= new StringBuffer();
										tmpErrMsg.append("VVD : [");
										tmpErrMsg.append(vslSkdHisInVO.getVslCd());
										tmpErrMsg.append(vslSkdHisInVO.getSkdVoyNo());
										tmpErrMsg.append(vslSkdHisInVO.getSkdDirCd());
										tmpErrMsg.append("] Port [");
										tmpErrMsg.append(vslSkdHisInVO.getVpsPortCd());
										tmpErrMsg.append("] Calling Indicator [");
										tmpErrMsg.append(vslSkdHisInVO.getNewClptIndSeq());
										tmpErrMsg.append("]");
										
										throw new EventException(new ErrorHandler("VSK00011", tmpErrMsg.toString()).getMessage());
									}
									/************************************************************************/
									
									vslSkdCngUpdateVO.setNewClptIndSeq	(vslSkdHisInVO.getNewClptIndSeq	()	);

									vslSkdCngUpdateVO.setOldYdCd		(orgPortVO.getYdCd				()	);
									vslSkdCngUpdateVO.setNewYdCd		(vslSkdHisInVO.getYdCd			()	);

									bkgUpdateList.add					(vslSkdCngUpdateVO					);
									
									//8. Call Indicator Seq. 변경 "72" ::정상기::bkg-vsk-sce-prd::2013-03-19//STARTED
									//to SCE_ACT_TML_IF(COP), /Old Terminal Code
									SceActRcvIfVO sceActRcvIfVO 		= new SceActRcvIfVO();
									sceActRcvIfVO.setActRcvTpCd			("72");
									sceActRcvIfVO.setVslCd				(vslCd								);
									sceActRcvIfVO.setSkdVoyNo			(skdVoyNo							);
									sceActRcvIfVO.setSkdDirCd			(skdDirCd							);
									
									//::old information:://
									sceActRcvIfVO.setVpsPortCd			(orgPortVO.getVpsPortCd			()	);
									sceActRcvIfVO.setClptIndSeq			(orgPortVO.getClptIndSeq		()	);
									sceActRcvIfVO.setNodCd				(orgPortVO.getYdCd				()	);
									///////////////////////
									
									sceActRcvIfVO.setVslDlayRsnCd		(vslSkdHisInVO.getVslDlayRsnCd	()	);
									sceActRcvIfVO.setVslDlayRsnDesc		(vslSkdHisInVO.getVslDlayRsnDesc()	);
									sceActRcvIfVO.setVpsLocCd			(vslSkdHisInVO.getVslDlayRsnLocCd()	);
									sceActRcvIfVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);

									sceActRcvIfVO.setCallYdIndCngFlg	("Y");
									
									copNoticeList.add					(sceActRcvIfVO);
									//8. Call Indicator Seq. 변경 "72" ::정상기::bkg-vsk-sce-prd::2013-03-19//FINISHED
									
									if( iHisDtlTargetKnt == 0){
										/* --------------------------------------------------------------------
										 * PORT CALLING SEQUNCE CHANGE에 대한 VSK VESSEL SCHEDULE HISTORY
										 * --------------------------------------------------------------------
										 * CALLING INDICATOR CHANGE : "P"
										 */
										tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
										tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
										tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
										tmpVslSkdCngHisDtlVO.setVpsPortCd		(vpsPortCd							);
										tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
										tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("P"								);
										
										iHisDtlTargetKnt ++;
									}
								}								
							}
							
							if(iHisDtlTargetKnt == 0)
							{													
								/*************************************************************************
								 * Vessel Schedule Change History Detial VO 생성
								 * -----------------------------------------------------------------------
								 * NORMAL
								 *************************************************************************
								 */					
								tmpVslSkdCngHisDtlVO.setVslCd			(vslCd							);
								tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo						);
								tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd						);
								tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
								tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq());
								tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("U"							);
								
								iHisDtlTargetKnt++;

								//log.info("\n\n ================ ::jskjskjskjsk:: iHisDtlTargetKnt ================== \n");
								//log.info("\n\n ================ ::jskjskjskjsk:: sVslCd ["+sVslCd+"]\n");
								//log.info("\n\n ================ ::jskjskjskjsk:: sSkdVoyNo ["+sSkdVoyNo+"]\n");
								//log.info("\n\n ================ ::jskjskjskjsk:: sSkdDirCd ["+sSkdDirCd+"]\n");
								//log.info("\n\n ================ ::jskjskjskjsk:: getVpsPortCd ["+vslSkdHisInVO.getVpsPortCd	()+"]\n");
								//log.info("\n\n ================ ::jskjskjskjsk:: getClptIndSeq ["+vslSkdHisInVO.getClptIndSeq()+"]\n");
								//log.info("\n\n ================ ::jskjskjskjsk:: getNewClptIndSeq ["+vslSkdHisInVO.getNewClptIndSeq()+"]\n");
								//log.info("\n\n ================ ::jskjskjskjsk:: getSkdCngStsCd ["+vslSkdHisInVO.getSkdCngStsCd()+"]\n");
								//log.info("\n\n ================ ::jskjskjskjsk:: =================================== \n");	
							}
						}
						else if( reConnectFlg ){
							// Virtual Port 삭제 후 재연결시 COP 호출 대상을 찾기 위해 추가. (2014.09.30)
							VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();

							vskVslSkdHisVO.setVskdTpCd		("P");
							vskVslSkdHisVO.setBfrVslCd		(vslSkdHisInVO.getVslCd		()	);
							vskVslSkdHisVO.setBfrSkdVoyNo	(vslSkdHisInVO.getSkdVoyNo	()	);
							vskVslSkdHisVO.setBfrSkdDirCd	(vslSkdHisInVO.getSkdDirCd	()	);
							vskVslSkdHisVO.setBfrVpsPortCd	(vslSkdHisInVO.getVpsPortCd	()	);
							vskVslSkdHisVO.setBfrClptIndSeq	(vslSkdHisInVO.getClptIndSeq()	);
							vskVslSkdHisVO.setBfrYdCd		(vslSkdHisInVO.getYdCd		()	);
							vskVslSkdHisVO.setBfrVslSlanCd	(vslSkdHisInVO.getVslSlanCd	()	);
							vskVslSkdHisVO.setAftVpsEtaDt	(vslSkdHisInVO.getVpsEtaDt	()	);
							vskVslSkdHisVO.setAftVpsEtbDt	(vslSkdHisInVO.getVpsEtbDt	()	);
							vskVslSkdHisVO.setAftVpsEtdDt	(vslSkdHisInVO.getVpsEtdDt	()	);
							vskVslSkdHisVO.setVskdCngTpCd	("E");								//변경된 이유를 CODE화 하여 표시 - 'E' : ETA, ETB, ETD
							vskVslSkdHisVO.setCreUsrId		(vslSkdHisInVO.getUsrId		()	);
							vskVslSkdHisVO.setUpdUsrId		(vslSkdHisInVO.getUsrId		()	);

							historyList.add					(vskVslSkdHisVO);
							
							if( iHisDtlTargetKnt == 0){
								/* --------------------------------------------------------------------
								 * ETA, ETB, ETD CHANGE에 대한 VSK VESSEL SCHEDULE HISTORY
								 * --------------------------------------------------------------------
								 * ETA, ETB, ETD CHANGE : "E"
								 */
								
								tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
								tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
								tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
								tmpVslSkdCngHisDtlVO.setVpsPortCd		(vpsPortCd							);
								tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
								tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("E"								);
								
								iHisDtlTargetKnt ++;
							}
							
							// cop...
							/*
							 *  IF( UPDATING ) THEN 일때 Act Rcv Dt
							 *  1. ATA가 변경된 경우 "21"
							 *  2. ATB가 변경된 경우 "22"
							 *  3. ATD가 변경된 경우 "23"
							 *  4. ETA가 변경된 경우 "24"  :: ETA DELAY NOTICE 대상임. (BKG.POD.ETA 기준 +5hrs 및 일자가 다른경우 ::
							 *  5. ETB가 변경된 경우 "25"
							 *  6. ETD가 변경된 경우 "26"
							 *  7. YD가 변경된 경우  "27"
							 *  -----------------------------------
							 *  8. Call Indicator Seq. 변경 "72" ::정상기::bkg-vsk-sce-prd::2013-03-19//
							 */
							if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtaDt())){
								SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO					();
								sceActRcvIfVO.setActRcvTpCd		("24");
								sceActRcvIfVO.setActDt			(vslSkdHisInVO.getVpsEtaDt			()	);
								sceActRcvIfVO.setNodCd			(vslSkdHisInVO.getYdCd				()	);
								sceActRcvIfVO.setVslCd			(vslCd									);
								sceActRcvIfVO.setSkdVoyNo		(skdVoyNo								);
								sceActRcvIfVO.setSkdDirCd		(skdDirCd								);
								sceActRcvIfVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd			()	);
								sceActRcvIfVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq		()	);
								sceActRcvIfVO.setVslDlayRsnCd	(vslSkdHisInVO.getVslDlayRsnCd		()	);
								sceActRcvIfVO.setVslDlayRsnDesc	(vslSkdHisInVO.getVslDlayRsnDesc	()	);
								sceActRcvIfVO.setVpsLocCd		(vslSkdHisInVO.getVslDlayRsnLocCd	()	);
								sceActRcvIfVO.setCreUsrId		(vslSkdHisInVO.getUsrId());

								copNoticeList.add				(sceActRcvIfVO);
							}
							if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtbDt())){
								SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO					();
								sceActRcvIfVO.setActRcvTpCd		("25");
								sceActRcvIfVO.setActDt			(vslSkdHisInVO.getVpsEtbDt			()	);
								sceActRcvIfVO.setVslCd			(vslCd									);
								sceActRcvIfVO.setSkdVoyNo		(skdVoyNo								);
								sceActRcvIfVO.setSkdDirCd		(skdDirCd								);
								sceActRcvIfVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd			()	);
								sceActRcvIfVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq		()	);
								sceActRcvIfVO.setVslDlayRsnCd	(vslSkdHisInVO.getVslDlayRsnCd		()	);
								sceActRcvIfVO.setVslDlayRsnDesc	(vslSkdHisInVO.getVslDlayRsnDesc	()	);
								sceActRcvIfVO.setVpsLocCd		(vslSkdHisInVO.getVslDlayRsnLocCd	()	);
								sceActRcvIfVO.setNodCd			(vslSkdHisInVO.getYdCd				()	);
								sceActRcvIfVO.setCreUsrId		(vslSkdHisInVO.getUsrId				()	);

								copNoticeList.add				(sceActRcvIfVO);
							}
							if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtdDt())){
								SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO					();
								sceActRcvIfVO.setActRcvTpCd		("26");
								sceActRcvIfVO.setActDt			(vslSkdHisInVO.getVpsEtdDt			()	);
								sceActRcvIfVO.setVslCd			(vslCd									);
								sceActRcvIfVO.setSkdVoyNo		(skdVoyNo								);
								sceActRcvIfVO.setSkdDirCd		(skdDirCd								);
								sceActRcvIfVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd			()	);
								sceActRcvIfVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq		()	);
								sceActRcvIfVO.setVslDlayRsnCd	(vslSkdHisInVO.getVslDlayRsnCd		()	);
								sceActRcvIfVO.setVslDlayRsnDesc	(vslSkdHisInVO.getVslDlayRsnDesc	()	);
								sceActRcvIfVO.setVpsLocCd		(vslSkdHisInVO.getVslDlayRsnLocCd	()	);
								sceActRcvIfVO.setNodCd			(vslSkdHisInVO.getYdCd				()	);
								sceActRcvIfVO.setCreUsrId		(vslSkdHisInVO.getUsrId				()	);

								copNoticeList.add				(sceActRcvIfVO);
							}
							
							SceActRcvIfVO sceActRcvIfVO 		= new SceActRcvIfVO();
							sceActRcvIfVO.setActRcvTpCd			("27");
							sceActRcvIfVO.setVslCd				(vslCd									);
							sceActRcvIfVO.setSkdVoyNo			(skdVoyNo								);
							sceActRcvIfVO.setSkdDirCd			(skdDirCd								);
							sceActRcvIfVO.setVpsPortCd			(vslSkdHisInVO.getVpsPortCd			()	);
							sceActRcvIfVO.setClptIndSeq			(vslSkdHisInVO.getClptIndSeq		()	);
							sceActRcvIfVO.setVslDlayRsnCd		(vslSkdHisInVO.getVslDlayRsnCd		()	);
							sceActRcvIfVO.setVslDlayRsnDesc		(vslSkdHisInVO.getVslDlayRsnDesc	()	);
							sceActRcvIfVO.setVpsLocCd			(vslSkdHisInVO.getVslDlayRsnLocCd	()	);
							sceActRcvIfVO.setNodCd				(vslSkdHisInVO.getYdCd				()	);
							sceActRcvIfVO.setCreUsrId			(vslSkdHisInVO.getUsrId				()	);
							//8. Call Indicator Seq. 변경 "72" ::정상기::bkg-vsk-sce-prd::2013-03-19//
							sceActRcvIfVO.setCallYdIndCngFlg("N");
							/////////////////////////////////////////////////////////////////////////
							
							copNoticeList.add(sceActRcvIfVO);
						}
						// [BOOKING NO_ATTACHE 처리부 END]
					}
					else {
						// [BOOKING 정보가 없을 경우. START]
						///////////////////////////////////////////////////////////////////////////
						//int iHisDtlTargetKnt = 0; //1이 되면 Next VO로 이동한다.
						///////////////////////////////////////////////////////////////////////////
						//VVD 코드
						vslCd		= vslSkdHisInVO.getVslCd ();
						skdVoyNo    = vslSkdHisInVO.getSkdVoyNo ();
						skdDirCd    = vslSkdHisInVO.getSkdDirCd ();
						vpsPortCd   = vslSkdHisInVO.getVpsPortCd();
						paramVO.setVslCd  (vslCd  );
						paramVO.setSkdVoyNo  (skdVoyNo );
						paramVO.setSkdDirCd  (skdDirCd );
						paramVO.setVpsPortCd (vpsPortCd );
						paramVO.setClptIndSeq (vslSkdHisInVO.getClptIndSeq());
						String sTmpCurVvdCd	= vslCd + skdVoyNo + skdDirCd;
						String sTmpPreVvdCd	= "";
						 
						// VVD 가 여러 건일 수 있으므로.
						if(!sTmpPreVvdCd.equals(sTmpCurVvdCd)){
							sTmpPreVvdCd = sTmpCurVvdCd;
							// 해당 VVD의 변경되기전의 Port 정보를 조회한다.
							CstSkdByVvdVO orgParamVO = new CstSkdByVvdVO();
							orgParamVO.setVslCd  (vslCd);
							orgParamVO.setSkdVoyNo (skdVoyNo);
							orgParamVO.setSkdDirCd (skdDirCd);
							orgPortVoList    = dbDao.searchCstSkdByVvd(orgParamVO);
						}
						
						CstSkdByVvdVO orgPortVO = null;
					 
						//해당 Skip 된 변경 전의 Port 정보를 찾는다.
						if(orgPortVoList != null && orgPortVoList.size() > 0){
							for(CstSkdByVvdVO cstSkdByVvdVO : orgPortVoList){
								if(  vslSkdHisInVO.getVpsPortCd().equals(cstSkdByVvdVO.getVpsPortCd())
										&& vslSkdHisInVO.getClptIndSeq()!= null
										&& vslSkdHisInVO.getClptIndSeq().equals(cstSkdByVvdVO.getClptIndSeq()))
								{
									orgPortVO = cstSkdByVvdVO;
									break;
								}
							}
						}
					
						/** VESSEL SCHEDULE CHANGE/CREATION TYPE CODE **
						 * VSK_VSL_SKD_CNG_HIS_DTL.VSKD_TML_CNG_TP_CD V1
						 * - sVslSkdTmlCngTpCd
						 * ----------------------------------------------
						 * 'N' : 최초생성.
						 * ----------------------------------------------
						 * 'U' : Normal UPDATE 
						 * 'S' : Port SKIP
						 * 'I' : Phase IN
						 * 'O' : Phase OUT
						 * 'D' : Port Delete
						 * 'E' : ETA, ETB, ETD 변경
						 * 'Y' : YARD(Terminal) 변경
						 * 'P' : PORT의 Calling Indicator Seq.(CLPT_IND_SEQ) 변경
						 * 'R' : REVERSE Call
						 * ---------------------------------------------
						 * 'A' : ADD Call
						 * 'T' : AUTO UPDATE (by Acctual Schedule)
						 * ---------------------------------------------
						 * 'X' : Port SKIP Cancle
						 * ---------------------------------------------
						 */
					
						if(orgPortVO != null) {
							//기존 데이터가 Port Skip이 아니고, 새로 입력된 데이터가 Port Skip이면 
							if(!"S".equals(orgPortVO.getSkdCngStsCd()) && "S".equals(vslSkdHisInVO.getSkdCngStsCd()) && iHisDtlTargetKnt == 0){
								/* --------------------------------------------------------------------
								 * PORT SKIP에 대한 VSK VESSEL SCHEDULE HISTORY DETAIL
								 * --------------------------------------------------------------------
								 * PORT SKIP : "S"
								 */				
								tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
								tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
								tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
								tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
								tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
								tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("S"								);
						
								iHisDtlTargetKnt++;												
							}
					
							if("S".equals(orgPortVO.getSkdCngStsCd()) && "".equals(vslSkdHisInVO.getSkdCngStsCd()) && iHisDtlTargetKnt == 0){
								/* --------------------------------------------------------------------
								 * PORT SKIP CANCEL에 대한 VSK VESSEL SCHEDULE HISTORY DETAIL
								 * --------------------------------------------------------------------
								 * PORT SKIP CANCEL : "X"
								 */				
								tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
								tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
								tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
								tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
								tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
								tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("X"								);
								
								iHisDtlTargetKnt++;
							}
					
							if("O".equals(vslSkdHisInVO.getSkdCngStsCd()) && iHisDtlTargetKnt == 0){
								/* --------------------------------------------------------------------
								 * PHASE OUT에 대한 VSK VESSEL SCHEDULE HISTORY DETAIL
								 * --------------------------------------------------------------------
								 * PHASE OUT : "O"
								 */				
								tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
								tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
								tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
								tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
								tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
								tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("O"								);
								
								iHisDtlTargetKnt++;															
							}
					
							if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getYdCd()) && !vslSkdHisInVO.getYdCd().equals(orgPortVO.getYdCd()) && iHisDtlTargetKnt == 0){
								/* --------------------------------------------------------------------
								 * YARD CHANGE에 대한 VSK VESSEL SCHEDULE HISTORY DETAIL
								 * --------------------------------------------------------------------
								 * YARD CHANGE : "Y"
								 */				
								tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
								tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
								tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
								tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
								tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
								tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("Y"								);
								tmpVslSkdCngHisDtlVO.setBfrYdCd			(orgPortVO.getYdCd			()		);
							
								iHisDtlTargetKnt++;															
							}
					
							if(!vslSkdHisInVO.getClptIndSeq().equals(vslSkdHisInVO.getNewClptIndSeq()) && iHisDtlTargetKnt == 0){
								/* --------------------------------------------------------------------
								 * CALLING PORT SEQUENCE CHANGE에 대한 VSK VESSEL SCHEDULE HISTORY DETAIL
								 * --------------------------------------------------------------------
								 * CALLING PORT INDICATOR SEQUENCE CHANGE : "P"
								 */	
								tmpVslSkdCngHisDtlVO.setVslCd				(vslCd								);
								tmpVslSkdCngHisDtlVO.setSkdVoyNo			(skdVoyNo							);
								tmpVslSkdCngHisDtlVO.setSkdDirCd			(skdDirCd							);
								tmpVslSkdCngHisDtlVO.setVpsPortCd			(vslSkdHisInVO.getVpsPortCd		()	);
								tmpVslSkdCngHisDtlVO.setClptIndSeq			(vslSkdHisInVO.getNewClptIndSeq	()	);
								tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd		("P"								);
								tmpVslSkdCngHisDtlVO.setPairRvsPortCd		(orgPortVO.getVpsPortCd			()	);
								tmpVslSkdCngHisDtlVO.setPairRvsClptIndSeq	(vslSkdHisInVO.getClptIndSeq	()	);
								
								iHisDtlTargetKnt++;		
							}
					
							if(
										(((!vslSkdHisInVO.getVpsEtaDt().equals(orgPortVO.getVpsEtaDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtaDt())))
									|| 	(( !vslSkdHisInVO.getVpsEtbDt().equals(orgPortVO.getVpsEtbDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtbDt())))
									|| 	(( !vslSkdHisInVO.getVpsEtdDt().equals(orgPortVO.getVpsEtdDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtdDt())))) && iHisDtlTargetKnt == 0
							){
								/* --------------------------------------------------------------------
								 * ETA, ETB, ETD CHANGE에 대한 VSK VESSEL SCHEDULE HISTORY
								 * --------------------------------------------------------------------
								 * ETA, ETB, ETD CHANGE : "E"
								 */
							
								tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
								tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
								tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
								tmpVslSkdCngHisDtlVO.setVpsPortCd		(vpsPortCd							);
								tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
								tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("E"								);
								
								iHisDtlTargetKnt ++;
							}
					
						if(iHisDtlTargetKnt == 0){
							/*************************************************************************
							 * Vessel Schedule Change History Detial VO 생성
							 * -----------------------------------------------------------------------
							 * NORMAL
							 *************************************************************************
							 */					
							tmpVslSkdCngHisDtlVO.setVslCd			(vslCd								);
							tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo							);
							tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd							);
							tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd		()	);
							tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
							tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("U"								);
							
							iHisDtlTargetKnt++;																		
						}				
					}else{
						/*************************************************************************
						 * Vessel Schedule Change History Detial VO 생성
						 * -----------------------------------------------------------------------
						 * ADD CALLING
						 *************************************************************************
						 */				
						tmpVslSkdCngHisDtlVO.setVslCd			(vslCd							);
						tmpVslSkdCngHisDtlVO.setSkdVoyNo		(skdVoyNo						);
						tmpVslSkdCngHisDtlVO.setSkdDirCd		(skdDirCd						);
						tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
						tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq());
						tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("A"							);
						
						iHisDtlTargetKnt++;
					}
					/********** END OF VO is Not Null "orgPortVO" **********/
					
					////////////////////////// 2013-08-03 Vessel Schedule Change History Detail 관리를 위한 VO(VslSkdCngHisDtlVO) 생성 /////////////
					////////////////////////// None Unassigned Booking - Vessel Schedule List //////////////////////////////////////////////////
					
					// [BOOKING 정보가 없을 경우. END]
					}
					
					vslSkdCngHisDtlVOList.add(tmpVslSkdCngHisDtlVO);
				}
				
				// [Vessel Schedule History & COP 호출 데이터 생성. END]
			}

			// Master 정보 변경 시 History START
			if(masterVOList != null && masterVOList.size()>0){
				for(VskVslSkdVO vskVslSkdVO : masterVOList){
					//***** 'L' : Lane 변경 *****
					for(VslSkdHisInVO vslSkdHisInVO : vslSkdHisInVOs){
						if(	   vskVslSkdVO.getVslCd   ().equals(vslSkdHisInVO.getVslCd   ())
							&& vskVslSkdVO.getSkdVoyNo().equals(vslSkdHisInVO.getSkdVoyNo())
							&& vskVslSkdVO.getSkdDirCd().equals(vslSkdHisInVO.getSkdDirCd())){
							//***** 'L' : Lane 변경 *****
							if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getCngLaneCd())){
								if(!vslSkdHisInVO.getVslSlanCd().equals(vslSkdHisInVO.getCngLaneCd())){
									VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();

									vskVslSkdHisVO.setVskdTpCd("M");
									vskVslSkdHisVO.setBfrVslCd(vslSkdHisInVO.getVslCd());
									vskVslSkdHisVO.setBfrSkdVoyNo(vslSkdHisInVO.getSkdVoyNo());
									vskVslSkdHisVO.setBfrSkdDirCd(vslSkdHisInVO.getSkdDirCd());
									vskVslSkdHisVO.setBfrVslSlanCd(vslSkdHisInVO.getVslSlanCd());
									vskVslSkdHisVO.setAftVslCd(vslSkdHisInVO.getVslCd());
									vskVslSkdHisVO.setAftSkdVoyNo(vslSkdHisInVO.getSkdVoyNo());
									vskVslSkdHisVO.setAftSkdDirCd(vslSkdHisInVO.getSkdDirCd());
									vskVslSkdHisVO.setAftVslSlanCd(vslSkdHisInVO.getCngLaneCd());
									vskVslSkdHisVO.setVskdCngTpCd("L");									//변경된 이유를 CODE화 하여 표시 - 'L' : Lane 변경
									vskVslSkdHisVO.setCreUsrId(vslSkdHisInVO.getUsrId());
									vskVslSkdHisVO.setUpdUsrId(vslSkdHisInVO.getUsrId());

									historyList.add(vskVslSkdHisVO);
								}
							}

							break;
						}
					}

					boolean vvdDelFlg = false;
					for(VslSkdHisInVO vslSkdHisInVO : vslSkdHisInVOs){
						if(    vskVslSkdVO.getVslCd   ().equals(vslSkdHisInVO.getVslCd   ())
							&& vskVslSkdVO.getSkdVoyNo().equals(vslSkdHisInVO.getSkdVoyNo())
							&& vskVslSkdVO.getSkdDirCd().equals(vslSkdHisInVO.getSkdDirCd())){
							vvdDelFlg = true;
							//***** 'V' : VVD 삭제 *****
							if(!"D".equals(vslSkdHisInVO.getIbflag())){
								vvdDelFlg = false;
								break;
							}
						}
					}

					//***** 'V' : VVD 삭제 *****
					if(vvdDelFlg){
						VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();

						vskVslSkdHisVO.setVskdTpCd		("M");
						vskVslSkdHisVO.setBfrVslCd		(vskVslSkdVO.getVslCd	());
						vskVslSkdHisVO.setBfrSkdVoyNo	(vskVslSkdVO.getSkdVoyNo());
						vskVslSkdHisVO.setBfrSkdDirCd	(vskVslSkdVO.getSkdDirCd());
						vskVslSkdHisVO.setVskdCngTpCd	("V");									// 변경된 이유를 CODE화 하여 표시 - 'V' : VVD 삭제
						vskVslSkdHisVO.setCreUsrId		(vskVslSkdVO.getCreUsrId());
						vskVslSkdHisVO.setUpdUsrId		(vskVslSkdVO.getUpdUsrId());

						historyList.add					(vskVslSkdHisVO);
					}
				}
			}
			// Master 정보 변경 시 History END

			vslSkdChgStsGRPVO.setVslSkdCngNoticeVOs		(bkgVslSkdCngNoticeList			);	// VSK to BKG :: Vessel Schedule Change(Skip,P/O,...) Notice
			vslSkdChgStsGRPVO.setVslSkdEtaDelayNoticeVOs(bkgVslSkdEtaDelayNoticeList	);	// VSK to BKG :: BKG.POD.ETA Delay Notice
			vslSkdChgStsGRPVO.setVslSkdCngUpdateVOs		(bkgUpdateList					);	// BKG
			vslSkdChgStsGRPVO.setSceActRcvIfVOs			(copNoticeList					);	// COP
			vslSkdChgStsGRPVO.setVslSkdCngHisDtlVOs		(vslSkdCngHisDtlVOList			);	// GENERATING VSL SKD CHANGE HISTORY DETAIL :: VSK_VSL_SKD_CNG_HIS_DTL

//			********************* History Save *********************
			if(historyList != null && historyList.size()>0){
				dbDao.addVskVslSkdHis(historyList);
			}
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다. BA 담당자에게 문의하세요.
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

		return vslSkdChgStsGRPVO;
	}

	/**
	 * Simulation Data 를 Coastal Schedule 에 반영한다.
	 *
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageSettleByVvd(CstSkdByVvdVO[] cstSkdByVvdVOs, SwapCstSkdSimVO swapCstSkdSimVO, SignOnUserAccount account) throws EventException {
		VslSkdChgStsGRPVO vslSkdChgStsGRPVO = new VslSkdChgStsGRPVO();
		try {
//			/*
//			 * VVD 가 2,4 건인 경우는 조회한 VVD 정보를 알 수가 없음.
//			 */
			VskSwapCstSimVO paramVO = new VskSwapCstSimVO();
			paramVO.setSimDt(swapCstSkdSimVO.getSimDt());
			paramVO.setSimNo(swapCstSkdSimVO.getSimNo());

			List<String> chkSims = dbDao.searchCstSimDifference(paramVO);
			if(chkSims != null && chkSims.size()>0){
				/*
				 * MSG - 현재 Settlement 하려는 항차에 Port가 추가되었거나 삭제되었습니다.
				 */
				int errCnt = chkSims.size();
				StringBuilder errMsg = new StringBuilder();
				errMsg.append("\n------------------------------------------------------------------");
				for(int i=0; i<errCnt; i++){
					errMsg.append("\n" + chkSims.get(i));
				}
				throw new EventException(new ErrorHandler("VSK10055", new String[]{errMsg.toString()}).getMessage());
			}

			List<ActualSkdBySimNoVO> actSimList = dbDao.searchActualSkdBySimNo (paramVO);
			if(actSimList != null && actSimList.size()>0){
				cstSkdByVvdVOs = simulationDataCheckByActual(actSimList, cstSkdByVvdVOs);
				vslSkdChgStsGRPVO = manageCstSkdByVvd(cstSkdByVvdVOs, account);
			}
		} catch (DAOException ex) {
			/*
			 * MSG - 조회 서비스 실행중 오류가 발생하였을 경우.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였을 경우.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return vslSkdChgStsGRPVO;
	}

	/**
	 * Recovery Plan 에서 Settlement 시 Coastal 에 Actual 이 들어온 경우는<br>
	 * Actual Data 가 변경 안되도록 Actual 이 들어온 부분만 Actual Data 로 Simulation Data 에 덮어쓴다.
	 *
	 * @param List<ActualSkdBySimNoVO> actualSkdBySimNoVOs	: Coastal에서 조회한 Data
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs				: User가 Simulation한 Data
	 * @return CstSkdByVvdVO[]
	 */
	private CstSkdByVvdVO[] simulationDataCheckByActual(List<ActualSkdBySimNoVO> actualSkdBySimNoVOs, CstSkdByVvdVO[] cstSkdByVvdVOs) throws EventException {
		try{
			if(actualSkdBySimNoVOs != null && actualSkdBySimNoVOs.size() > 0 && cstSkdByVvdVOs != null && cstSkdByVvdVOs.length > 0){
				for(ActualSkdBySimNoVO actualSkdBySimNoVO:actualSkdBySimNoVOs){
					String portSkdStsCd = actualSkdBySimNoVO.getPortSkdStsCd();
					if(VSKGeneralUtil.isNotNull(portSkdStsCd)){		//Actual Data 만 실행.
						int voCnt = cstSkdByVvdVOs.length;
						for(int i=0; i<voCnt; i++){
							if(actualSkdBySimNoVO.getVpsPortCd().equals(cstSkdByVvdVOs[i].getVpsPortCd())
									&& actualSkdBySimNoVO.getClptIndSeq().equals(cstSkdByVvdVOs[i].getClptIndSeq())){
								if("Y".equals(cstSkdByVvdVOs[i].getUsrHdnFlg())){		// Hidden 된 Data 는 Actual Data 로 덮어 쓴다.
									String etbDt = cstSkdByVvdVOs[i].getVpsEtbDt();
									String etdDt = cstSkdByVvdVOs[i].getVpsEtdDt();
									ObjectCloner.build(actualSkdBySimNoVO, cstSkdByVvdVOs[i]);

									if("A".equals(portSkdStsCd)){
										cstSkdByVvdVOs[i].setVpsEtaDt(actualSkdBySimNoVO.getActArrDt());
										cstSkdByVvdVOs[i].setVpsEtbDt(etbDt);	// 사용자가 수정한 Data 로다시  변경.
										cstSkdByVvdVOs[i].setVpsEtdDt(etdDt);	// 사용자가 수정한 Data 로다시  변경.
									}else if("B".equals(portSkdStsCd)){
										cstSkdByVvdVOs[i].setVpsEtaDt(actualSkdBySimNoVO.getActArrDt());
										cstSkdByVvdVOs[i].setVpsEtbDt(actualSkdBySimNoVO.getActBrthDt());
										cstSkdByVvdVOs[i].setVpsEtdDt(etdDt);	// 사용자가 수정한 Data 로다시  변경.
									}else if("D".equals(portSkdStsCd)){
										cstSkdByVvdVOs[i].setVpsEtaDt(actualSkdBySimNoVO.getActArrDt());
										cstSkdByVvdVOs[i].setVpsEtbDt(actualSkdBySimNoVO.getActBrthDt());
										cstSkdByVvdVOs[i].setVpsEtdDt(actualSkdBySimNoVO.getActDepDt());
									}

									break;
								}else{													// Hidden 이 안된 Data 에 Actual 이 들어 온 경우는 막는다.
									/*
									 * MSG - 현재 Settlement 하려는 항차에 Actual Data 가 입력되었습니다.
									 */
									throw new EventException(new ErrorHandler("VSK10056").getMessage());
								}
							}
						}// end for
					}
				}// end for
			}
		} catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return cstSkdByVvdVOs;
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

			vskVslSkdVO.setVslCd	(cstSkdByVvdVO.getVslCd		());
			vskVslSkdVO.setSkdVoyNo	(cstSkdByVvdVO.getSkdVoyNo	());
			vskVslSkdVO.setSkdDirCd	(cstSkdByVvdVO.getSkdDirCd	());
			vskVslSkdVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd	());
			vskVslSkdVO.setPfSkdTpCd(cstSkdByVvdVO.getPfSvcTpCd	());
			vskVslSkdVO.setSkdRmk	(cstSkdByVvdVO.getSkdRmk	());
			vskVslSkdVO.setUpdUsrId	(userId		);
			updateVoList.add		(vskVslSkdVO);

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
	 * SPP 에서 turn 정보가 누락되어 오는 경우가 있어 SPP 는 Turn 정보 Check 하여 전송하도록 함.
	 *
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return VskVslPortSkdVO
	 * @exception EventException
	 */
	private VskVslPortSkdVO sppTurnInfoVaild(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		try {
			if("ESVCUSER".equals(vskVslPortSkdVO.getUpdUsrId())){
				if(! "Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
					// SPP 에서 turn 정보가 누락되어 오는 경우가 있어 SPP 는 Turn 정보 Check 하여 전송.
					VskVslPortSkdVO paramVO = new VskVslPortSkdVO();
					paramVO.setVslCd(vskVslPortSkdVO.getVslCd());
					paramVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
					paramVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());

					// Turnning Port
					List<VskVslPortSkdVO> turnPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(paramVO);

					if(turnPortVoList != null && turnPortVoList.size() > 0){
						for(VskVslPortSkdVO turnPortVo : turnPortVoList){
							if(vskVslPortSkdVO.getVpsPortCd().equals(turnPortVo.getVpsPortCd()) && vskVslPortSkdVO.getClptIndSeq().equals(turnPortVo.getClptIndSeq())){
								if("Y".equals(turnPortVo.getTurnPortFlg())){
									vskVslPortSkdVO.setTurnPortFlg(turnPortVo.getTurnPortFlg());
									vskVslPortSkdVO.setTurnSkdVoyNo(turnPortVo.getTurnSkdVoyNo());
									vskVslPortSkdVO.setTurnSkdDirCd(turnPortVo.getTurnSkdDirCd());
									vskVslPortSkdVO.setTurnClptIndSeq(turnPortVo.getTurnClptIndSeq());
								}
							}
						}
					}
				}
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

		return vskVslPortSkdVO;
	}

	/**
	 * VskVslPortSkdVO 를 참고로 VskVslSkdVO 의 DataSet을 만든다.
	 *
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return VskVslSkdVO
	 * @exception EventException
	 */
	private VskVslSkdVO makeVskVslSkdDataSet(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();

		try{
			VskVslPortSkdVO paramVO = new VskVslPortSkdVO();

			paramVO.setVslCd(vskVslPortSkdVO.getVslCd());
			paramVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
			paramVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
			paramVO.setVpsPortCd(vskVslPortSkdVO.getVpsPortCd());
			paramVO.setClptIndSeq(vskVslPortSkdVO.getClptIndSeq());

			if("Y".equals(dbDao.checkFirstCallingPort(paramVO))){
				vskVslSkdVO.setVslCd(vskVslPortSkdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
				vskVslSkdVO.setStPortCd(vskVslPortSkdVO.getVpsPortCd());
				vskVslSkdVO.setVslSlanCd(vskVslPortSkdVO.getSlanCd());
				vskVslSkdVO.setN1stPortBrthDt(vskVslPortSkdVO.getVpsEtbDt());
				vskVslSkdVO.setUpdUsrId(vskVslPortSkdVO.getUpdUsrId());
			}else{
				vskVslSkdVO.setVslCd(vskVslPortSkdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
				vskVslSkdVO.setVslSlanCd(vskVslPortSkdVO.getSlanCd());
				vskVslSkdVO.setUpdUsrId(vskVslPortSkdVO.getUpdUsrId());
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
		return vskVslSkdVO;
	}

	/**
	 * ActCrrCd 를 찾아 온다.
	 *
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return VskVslSkdVO
	 * @exception EventException
	 */
	private VskVslSkdVO addActCrrCd(VskVslSkdVO vskVslSkdVO) throws EventException {
		try{
			vskVslSkdVO.setActCrrCd(dbDao.searchCarrierCode(vskVslSkdVO.getVslCd()));
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);

		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return vskVslSkdVO;
	}

	/*
	 * CHM-201007341-01
	 */
	/**
	 * 변경된 Vessel Port SKD 정보를 변경 및 삭제한다.
	 *
	 * @param SwapCstGRPVO swapCstGRPVO
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdByActual(SwapCstGRPVO swapCstGRPVO) throws EventException {

		VslSkdChgStsGRPVO vslSkdChgStsGRPVO = new VslSkdChgStsGRPVO();
		
//		log.info("\n #####################################################################");
//		log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual #############");
//		log.info("\n #####################################################################");

		try {
			VskVslPortSkdVO 		vskVslPortSkdVO 	= sppTurnInfoVaild(swapCstGRPVO.getVskVslPortSkdVO());
			List<VskVslPortSkdVO> 	actPortList 		= new ArrayList<VskVslPortSkdVO>();
			List<VvdVO> 			erpVvdVOs 			= new ArrayList<VvdVO>();				//변경된 VVD ERP에 전송

			actPortList.add(vskVslPortSkdVO);

//			***************** AutoUpdate Data Set START *****************
			//Actual 이 변경되면 자동으로 변경된 스케줄 이후의 스케줄을 조정해 준다.
			
//			log.info("\n #####################################################################");
//			log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual.manageAutoSkdUpdate Outer.Started!!! #############");
//			log.info("\n ACT_AUTO_UPDATE >> VVD+PORT+CLPT_IND_SEQ	VVD : ["+vskVslPortSkdVO.getVslCd()+vskVslPortSkdVO.getSkdVoyNo()+vskVslPortSkdVO.getSkdDirCd()+"], ["+vskVslPortSkdVO.getVpsPortCd()+"] ["+vskVslPortSkdVO.getClptIndSeq()+"]");
//			log.info("\n #####################################################################");
			
			SwapCstGRPVO 			autoGRPVO 			= this.manageAutoSkdUpdate(vskVslPortSkdVO);
			
//			log.info("\n #####################################################################");
//			log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual.manageAutoSkdUpdate Outer.Finished!!! #############");
//			log.info("\n #####################################################################");
			

			List<VskVslSkdVO> 		autoVOList 			= autoGRPVO.getVskVslSkdVOList		();
			List<VskVslPortSkdVO> 	autoPortVOList 		= autoGRPVO.getVskVslPortSkdVOList	();
//			***************** AutoUpdate Data Set  END  *****************

//			***************** History START *****************
			if(autoPortVOList != null && autoPortVOList.size()>0){
				vslSkdChgStsGRPVO = manageVslSkdChgSts(makeHistoryDataSetByActual(autoPortVOList));
			}else{
				vslSkdChgStsGRPVO = manageVslSkdChgSts(makeHistoryDataSetByActual(actPortList	));
			}
//			***************** History  END  *****************

//			***************** AutoUpdate START *****************


			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if(autoVOList == null || autoVOList.size() < 1){
				autoVOList = new ArrayList<VskVslSkdVO>();
				autoVOList.add(addActCrrCd(makeVskVslSkdDataSet(vskVslPortSkdVO)));
//				dbDao.modifyVskVslSkd(swapCstGRPVO.getVskVslSkdVOList());
			}

			dbDao.modifyVskVslSkd(autoVOList);
			
			/* ============================================================================
			 * Vessel Schedule History 관리(Header+Detail) Started ::2013-07-30::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * 1. VSK_VSL_SKD_CNG_HIS
			 * 2. VSK_VSL_SKD_CNG_HIS_DTL
			 * ----------------------------------------------------------------------------
			 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
			 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
			 * ============================================================================
			 */
			
			//::jskjskjsk::2013-09-17:://if(autoVOList != null && autoVOList.size() > 0){
				
				//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_ACT_AutoUpdate] started!!! :: \n");

				////this.createVslSkdChangeHistory(autoVOList, null, "UPDATE_ACT_AutoUpdate");	
				
				//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_ACT_AutoUpdate] finished!!! :: \n");
			//::jskjskjsk::2013-09-17:://}
			
			/* ----------------------------------------------------------------------------
			 * Vessel Schedule History 관리(Header+Detail) Finished ::2013-07-30::
			 * ============================================================================
			 */			
			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

			
			if(autoPortVOList != null && autoPortVOList.size()>0){
				dbDao.modifyVskVslPortSkdByAutoUpdate(autoPortVOList		);
			}

			// Virtual 처리.
			if(autoPortVOList != null && autoPortVOList.size()>0){
				List<VskVslPortSkdVO> autoVirtualPortVOList = setAutoVirtualData(autoPortVOList);
				dbDao.modifyVskVslPortSkdByAutoUpdate(autoVirtualPortVOList	);
			}

			// Next Data 처리.
			if(autoPortVOList != null && autoPortVOList.size()>0){
				List<VskVslPortSkdVO> autoNextPortVOList = setAutoNextData(autoPortVOList);
				dbDao.modifyVskVslPortSkdByAutoUpdate(autoNextPortVOList	);
			}
//			***************** AutoUpdate  END  *****************



			//::정상기::2012.08.21:: ERP 전송용 VO 재생성::STARTED:://
			List<VvdVO> corrErpVvdVOs 		= new ArrayList<VvdVO>();		//변경된 VVD ERP에 전송
			String		sCurrentVVD			= null;
			boolean		isTempTargetVVD		= true;

			String      sTempVslCd			= null;
			String		sTempSkdVoyNo		= null;
			String		sTempSkdDirCd		= null;

			if(autoPortVOList != null && autoPortVOList.size()>0){

				//STEP-01//
				for(int i=0; i<autoPortVOList.size(); i++){
					VvdVO vvdVO 	= new VvdVO();

					sTempVslCd		= vvdVO.getVslCd()    == null || "".equals(vvdVO.getVslCd())    || "null".equals(vvdVO.getVslCd())    ? "" : vvdVO.getVslCd();
					sTempSkdVoyNo	= vvdVO.getSkdVoyNo() == null || "".equals(vvdVO.getSkdVoyNo()) || "null".equals(vvdVO.getSkdVoyNo()) ? "" : vvdVO.getSkdVoyNo();
					sTempSkdDirCd	= vvdVO.getSkdDirCd() == null || "".equals(vvdVO.getSkdDirCd()) || "null".equals(vvdVO.getSkdDirCd()) ? "" : vvdVO.getSkdDirCd();

					sCurrentVVD		= sTempVslCd+sTempSkdVoyNo+sTempSkdDirCd;

					vvdVO.setIbflag		("U");
					vvdVO.setVslCd		(autoPortVOList.get(i).getVslCd		());
					vvdVO.setSkdVoyNo	(autoPortVOList.get(i).getSkdVoyNo	());
					vvdVO.setSkdDirCd	(autoPortVOList.get(i).getSkdDirCd	());
					vvdVO.setVslSlanCd	(autoPortVOList.get(i).getSlanCd	());

					sCurrentVVD		= vvdVO.getVslCd()+vvdVO.getSkdVoyNo()+vvdVO.getSkdDirCd();

					for(int inx=0; inx<corrErpVvdVOs.size(); inx++){
						if(sCurrentVVD.equals(corrErpVvdVOs.get(inx).getVslCd()+corrErpVvdVOs.get(inx).getSkdVoyNo()+corrErpVvdVOs.get(inx).getSkdDirCd())){
							isTempTargetVVD		= false;
							break;
						}else{
							isTempTargetVVD		= true;
						} 
					}

					if(isTempTargetVVD)		corrErpVvdVOs.add(vvdVO);

				}


				//STEP-02//
				List<VskVslPortSkdVO> autoVirtualPortVOList = setAutoVirtualData(autoPortVOList);
				for(int i=0; i<autoVirtualPortVOList.size(); i++){
					VvdVO vvdVO 	= new VvdVO();

					sTempVslCd		= vvdVO.getVslCd()    == null || "".equals(vvdVO.getVslCd())    || "null".equals(vvdVO.getVslCd())    ? "" : vvdVO.getVslCd();
					sTempSkdVoyNo	= vvdVO.getSkdVoyNo() == null || "".equals(vvdVO.getSkdVoyNo()) || "null".equals(vvdVO.getSkdVoyNo()) ? "" : vvdVO.getSkdVoyNo();
					sTempSkdDirCd	= vvdVO.getSkdDirCd() == null || "".equals(vvdVO.getSkdDirCd()) || "null".equals(vvdVO.getSkdDirCd()) ? "" : vvdVO.getSkdDirCd();

					sCurrentVVD		= sTempVslCd+sTempSkdVoyNo+sTempSkdDirCd;

					vvdVO.setIbflag		("U");
					vvdVO.setVslCd		(autoVirtualPortVOList.get(i).getVslCd		());
					vvdVO.setSkdVoyNo	(autoVirtualPortVOList.get(i).getSkdVoyNo	());
					vvdVO.setSkdDirCd	(autoVirtualPortVOList.get(i).getSkdDirCd	());
					vvdVO.setVslSlanCd	(autoVirtualPortVOList.get(i).getSlanCd		());

					sCurrentVVD		= vvdVO.getVslCd()+vvdVO.getSkdVoyNo()+vvdVO.getSkdDirCd();

					for(int inx=0; inx<corrErpVvdVOs.size(); inx++){
						if(sCurrentVVD.equals(corrErpVvdVOs.get(inx).getVslCd()+corrErpVvdVOs.get(inx).getSkdVoyNo()+corrErpVvdVOs.get(inx).getSkdDirCd())){
							isTempTargetVVD		= false;
							break;
						}else{
							isTempTargetVVD		= true;
						}
					}

					if(isTempTargetVVD)		corrErpVvdVOs.add(vvdVO);

				}

				//STEP-03//
				List<VskVslPortSkdVO> autoNextPortVOList = setAutoNextData(autoPortVOList);
				for(int i=0; i<autoNextPortVOList.size(); i++){
					VvdVO vvdVO 	= new VvdVO();

					sTempVslCd		= vvdVO.getVslCd()    == null || "".equals(vvdVO.getVslCd())    || "null".equals(vvdVO.getVslCd())    ? "" : vvdVO.getVslCd();
					sTempSkdVoyNo	= vvdVO.getSkdVoyNo() == null || "".equals(vvdVO.getSkdVoyNo()) || "null".equals(vvdVO.getSkdVoyNo()) ? "" : vvdVO.getSkdVoyNo();
					sTempSkdDirCd	= vvdVO.getSkdDirCd() == null || "".equals(vvdVO.getSkdDirCd()) || "null".equals(vvdVO.getSkdDirCd()) ? "" : vvdVO.getSkdDirCd();

					sCurrentVVD		= sTempVslCd+sTempSkdVoyNo+sTempSkdDirCd;

					vvdVO.setIbflag		("U");
					vvdVO.setVslCd		(autoNextPortVOList.get(i).getVslCd		());
					vvdVO.setSkdVoyNo	(autoNextPortVOList.get(i).getSkdVoyNo	());
					vvdVO.setSkdDirCd	(autoNextPortVOList.get(i).getSkdDirCd	());
					vvdVO.setVslSlanCd	(autoNextPortVOList.get(i).getSlanCd	());

					sCurrentVVD		= vvdVO.getVslCd()+vvdVO.getSkdVoyNo()+vvdVO.getSkdDirCd();

					for(int inx=0; inx<corrErpVvdVOs.size(); inx++){
						if(sCurrentVVD.equals(corrErpVvdVOs.get(inx).getVslCd()+corrErpVvdVOs.get(inx).getSkdVoyNo()+corrErpVvdVOs.get(inx).getSkdDirCd())){
							isTempTargetVVD		= false;
							break;
						}else{
							isTempTargetVVD		= true;
						}
					}

					if(isTempTargetVVD)		corrErpVvdVOs.add(vvdVO);

				}

			}
			//::정상기::2012.08.21:: ERP 전송용 VO 재생성::FINISHED:://



//			***************** 사용자가 입력한 내용 저장 START *****************
			VskVslPortSkdVO virtualPortVO = null;
			//Virtual Port Update
			if("Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
//				VskVslPortSkdVO virtualPortVO = new VskVslPortSkdVO();
				virtualPortVO = new VskVslPortSkdVO();

				virtualPortVO.setVslCd			(vskVslPortSkdVO.getVslCd());
				virtualPortVO.setSkdVoyNo		(vskVslPortSkdVO.getTurnSkdVoyNo());
				virtualPortVO.setSkdDirCd		(vskVslPortSkdVO.getTurnSkdDirCd());
				virtualPortVO.setVpsPortCd		(vskVslPortSkdVO.getVpsPortCd());
				virtualPortVO.setClptIndSeq		(vskVslPortSkdVO.getTurnClptIndSeq());
				virtualPortVO.setPortSkdStsCd	(vskVslPortSkdVO.getPortSkdStsCd());
				virtualPortVO.setYdCd			(vskVslPortSkdVO.getYdCd());
				virtualPortVO.setVpsEtaDt		(vskVslPortSkdVO.getVpsEtaDt());
				virtualPortVO.setVpsEtbDt		(vskVslPortSkdVO.getVpsEtbDt());
				virtualPortVO.setVpsEtdDt		(vskVslPortSkdVO.getVpsEtdDt());
				virtualPortVO.setActInpFlg		(vskVslPortSkdVO.getActInpFlg());
				virtualPortVO.setSlanCd			(vskVslPortSkdVO.getSlanCd());

				virtualPortVO.setUpdUsrId(vskVslPortSkdVO.getUpdUsrId());
				actPortList.add(virtualPortVO);
			}

			dbDao.modifyVskVslPortSkdByActual(actPortList);
//			***************** 사용자가 입력한 내용 저장  END  *****************



//			********************* 변경된 VVD ERP에 전송 *********************
			if(autoVOList != null && autoVOList.size()>0){
				for(VskVslSkdVO vskVslSkdVO : autoVOList){
//					변경된 VVD ERP에 전송
					VvdVO vvdVO 		= new VvdVO();
					vvdVO.setIbflag		("U");
					vvdVO.setVslCd		(vskVslSkdVO.getVslCd());
					vvdVO.setSkdVoyNo	(vskVslSkdVO.getSkdVoyNo());
					vvdVO.setSkdDirCd	(vskVslSkdVO.getSkdDirCd());
					vvdVO.setVslSlanCd	(vskVslSkdVO.getVslSlanCd());
					erpVvdVOs.add		(vvdVO);

					//STEP::ADD-01//
					sCurrentVVD			= vvdVO.getVslCd()+vvdVO.getSkdVoyNo()+vvdVO.getSkdDirCd();

					for(int inx=0; inx<corrErpVvdVOs.size(); inx++){
						if(sCurrentVVD.equals(corrErpVvdVOs.get(inx).getVslCd()+corrErpVvdVOs.get(inx).getSkdVoyNo()+corrErpVvdVOs.get(inx).getSkdDirCd())){
							isTempTargetVVD		= false;
							break;
						}else{
							isTempTargetVVD		= true;
						}
					}

					if(isTempTargetVVD)		corrErpVvdVOs.add(vvdVO);

				}

				// Virtual Port에 대한 정보도 반영되어야 하므로 해당 VVD도 ERP I/F 대상
				// CHM-201007341-01
				if(virtualPortVO!=null){
					VvdVO vvdVO 		= new VvdVO();
					vvdVO.setIbflag		("U");
					vvdVO.setVslCd		(virtualPortVO.getVslCd());
					vvdVO.setSkdVoyNo	(virtualPortVO.getSkdVoyNo());
					vvdVO.setSkdDirCd	(virtualPortVO.getSkdDirCd());
					vvdVO.setVslSlanCd	(virtualPortVO.getSlanCd());
					
					/** ::2014-05-14:2007816:: **/

					/****************************/
					
					erpVvdVOs.add		(vvdVO);

					//STEP::ADD-02//
					sCurrentVVD		= vvdVO.getVslCd()+vvdVO.getSkdVoyNo()+vvdVO.getSkdDirCd();

					for(int inx=0; inx<corrErpVvdVOs.size(); inx++){
						if(sCurrentVVD.equals(corrErpVvdVOs.get(inx).getVslCd()+corrErpVvdVOs.get(inx).getSkdVoyNo()+corrErpVvdVOs.get(inx).getSkdDirCd())){
							isTempTargetVVD		= false;
							break;
						}else{
							isTempTargetVVD		= true;
						}
					}

					if(isTempTargetVVD)		corrErpVvdVOs.add(vvdVO);
				}
			}


			//STEP::ADD-03//
			if(vskVslPortSkdVO != null){
				
				VvdVO vvdVO			= new VvdVO();
				vvdVO.setIbflag		("U");
				vvdVO.setVslCd		(vskVslPortSkdVO.getVslCd		());
				vvdVO.setSkdVoyNo	(vskVslPortSkdVO.getSkdVoyNo	());
				vvdVO.setSkdDirCd	(vskVslPortSkdVO.getSkdDirCd	());
				vvdVO.setVslSlanCd	(vskVslPortSkdVO.getSlanCd		());

				sCurrentVVD			= vvdVO.getVslCd()+vvdVO.getSkdVoyNo()+vvdVO.getSkdDirCd();

				for(int inx=0; inx<corrErpVvdVOs.size(); inx++){
					if(sCurrentVVD.equals(corrErpVvdVOs.get(inx).getVslCd()+corrErpVvdVOs.get(inx).getSkdVoyNo()+corrErpVvdVOs.get(inx).getSkdDirCd())){
						isTempTargetVVD		= false;
						break;
					}else{
						isTempTargetVVD		= true;
					}
				}

				if(isTempTargetVVD)		corrErpVvdVOs.add(vvdVO);
			}


			//STEP-99::FINAL ERP 전송대상확인하기//
/*			for(int j=0; j<corrErpVvdVOs.size(); j++){
				String sTempVVD	= corrErpVvdVOs.get(j).getVslCd()+corrErpVvdVOs.get(j).getSkdVoyNo()+corrErpVvdVOs.get(j).getSkdDirCd()+"-"+corrErpVvdVOs.get(j).getVslSlanCd();
				log.error("\n\n ::VesselScheduleBCImpl::ERP 전송용 VO 최종확인 FINALLY:: ["+sTempVVD+"], TOTAL SIZE = ["+corrErpVvdVOs.size()+"]\n\n");
			}	*/


			//SC 에서 마지막에 전송하는 것으로 수정(임창빈 - 2009.12.08)
			//::정상기 주석처리:2012.08.21:://vslSkdChgStsGRPVO.setErpVvdVOs(erpVvdVOs);
			//::정상기::2012.08.21::TO-ERP EAI전송대상VVD누락으로 VO [corrErpVvdVOs] 재생성:://
			vslSkdChgStsGRPVO.setErpVvdVOs(corrErpVvdVOs);

			if(erpVvdVOs != null && erpVvdVOs.size() > 0){
//				[Yard Call Ind Seq]============================================
				dbDao.modifyYardCallSeq(erpVvdVOs);

//				[Booking BDR LOG]============================================
				List<BkgVvdBdrLogVO> bkgVvdLogList = searchBkgBdrLog(erpVvdVOs);
				vslSkdChgStsGRPVO.setBkgVvdBdrLogVOs(bkgVvdLogList);
			}
			
			
			/****************************************************************
			 * 운항스케쥴 이력관리를 위한 VO or VO List Return ::2013-08-28::
			 */
			vslSkdChgStsGRPVO.setVskVslSkdVOs(autoVOList);
			

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
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

		return vslSkdChgStsGRPVO;
	}

	/**
	 * Auto Update 에서 Virtual Data 생성.
	 *
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOList
	 * @return List<VskVslPortSkdVO>
	 */
	private List<VskVslPortSkdVO> setAutoVirtualData(List<VskVslPortSkdVO> vskVslPortSkdVOList){
		List<VskVslPortSkdVO> rstVOList = new ArrayList<VskVslPortSkdVO>();

		if(vskVslPortSkdVOList != null && vskVslPortSkdVOList.size()>0){
			for(VskVslPortSkdVO vskVslPortSkdVO : vskVslPortSkdVOList){
				if("Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
					vskVslPortSkdVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
					vskVslPortSkdVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
					vskVslPortSkdVO.setClptIndSeq(vskVslPortSkdVO.getTurnClptIndSeq());
					vskVslPortSkdVO.setTurnSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
					vskVslPortSkdVO.setTurnSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
					vskVslPortSkdVO.setTurnClptIndSeq(vskVslPortSkdVO.getClptIndSeq());

					rstVOList.add(vskVslPortSkdVO);
				}
			}
		}

		return rstVOList;
	}

	/**
	 * Auto Update 에서 Virtual Data 에 대한 Next Turnning Data 생성.
	 *
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOList
	 * @return List<VskVslPortSkdVO>
	 */
	private List<VskVslPortSkdVO> setAutoNextData(List<VskVslPortSkdVO> vskVslPortSkdVOList){
		List<VskVslPortSkdVO> rstVOList = new ArrayList<VskVslPortSkdVO>();

		if(vskVslPortSkdVOList != null && vskVslPortSkdVOList.size()>0){
			int listCnt = vskVslPortSkdVOList.size();
			for(int i=0; i<listCnt; i++){
				if(VSKGeneralUtil.isVirtualPort(vskVslPortSkdVOList.get(i).getTurnPortIndCd())){
					VskVslPortSkdVO vskVslPortSkdVO = vskVslPortSkdVOList.get(i);
					vskVslPortSkdVO.setSkdVoyNo(vskVslPortSkdVOList.get(i).getTurnSkdVoyNo());
					vskVslPortSkdVO.setSkdDirCd(vskVslPortSkdVOList.get(i).getTurnSkdDirCd());
					vskVslPortSkdVO.setClptIndSeq(vskVslPortSkdVOList.get(i).getTurnClptIndSeq());
					vskVslPortSkdVO.setTurnSkdVoyNo(vskVslPortSkdVOList.get(i).getSkdVoyNo());
					vskVslPortSkdVO.setTurnSkdDirCd(vskVslPortSkdVOList.get(i).getSkdDirCd());
					vskVslPortSkdVO.setTurnClptIndSeq(vskVslPortSkdVOList.get(i).getClptIndSeq());

					rstVOList.add(vskVslPortSkdVO);
				}
			}
		}

		return rstVOList;
	}

	/**
	 * History DataSet 을 만든다.
	 *
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOList
	 * @return List<VslSkdHisInVO>
	 * @exception EventException
	 */
	private List<VslSkdHisInVO> makeHistoryDataSetByActual(List<VskVslPortSkdVO> vskVslPortSkdVOList) throws EventException {
		List<VslSkdHisInVO> vslSkdHisInVOList = new ArrayList<VslSkdHisInVO>();

		try{
			for(VskVslPortSkdVO vskVslPortSkdVO : vskVslPortSkdVOList) {
				VslSkdHisInVO vslSkdHisInVO = new VslSkdHisInVO();

				vslSkdHisInVO.setIbflag("U");
				vslSkdHisInVO.setSkdCngStsCd(vskVslPortSkdVO.getSkdCngStsCd());
				vslSkdHisInVO.setVslCd(vskVslPortSkdVO.getVslCd());
				vslSkdHisInVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
				vslSkdHisInVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
				vslSkdHisInVO.setVslSlanCd(vskVslPortSkdVO.getSlanCd());
				vslSkdHisInVO.setVpsPortCd(vskVslPortSkdVO.getVpsPortCd());
				vslSkdHisInVO.setClptIndSeq(vskVslPortSkdVO.getClptIndSeq());
				vslSkdHisInVO.setYdCd(vskVslPortSkdVO.getYdCd());
				vslSkdHisInVO.setVpsEtaDt(vskVslPortSkdVO.getVpsEtaDt());
				vslSkdHisInVO.setVpsEtbDt(vskVslPortSkdVO.getVpsEtbDt());
				vslSkdHisInVO.setVpsEtdDt(vskVslPortSkdVO.getVpsEtdDt());
				vslSkdHisInVO.setVslDlayRsnCd(vskVslPortSkdVO.getVslDlayRsnCd());
				vslSkdHisInVO.setVslDlayRsnDesc(vskVslPortSkdVO.getVslDlayRsnDesc());
				vslSkdHisInVO.setVslDlayRsnLocCd(vskVslPortSkdVO.getVslDlayRsnLocCd());
				vslSkdHisInVO.setUsrId(vskVslPortSkdVO.getUpdUsrId());
				vslSkdHisInVO.setNewClptIndSeq(vskVslPortSkdVO.getClptIndSeq());

				vslSkdHisInVOList.add(vslSkdHisInVO);

				//Virtual Port History Setting.
				if("Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
					String slanCd = vskVslPortSkdVO.getSlanCd();

					// Turnning Port 의 Lane 정보를 조회한다.
					VskVslPortSkdVO paramVO = new VskVslPortSkdVO();
					paramVO.setVslCd(vskVslPortSkdVO.getVslCd());
					paramVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
					paramVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());

					// Virtual Port
					List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(paramVO);
					if(virtualPortVoList != null && virtualPortVoList.size() > 0){
						slanCd = virtualPortVoList.get(0).getSlanCd();
					}

					VslSkdHisInVO virtualVslSkdHisInVO = new VslSkdHisInVO();

					virtualVslSkdHisInVO.setIbflag("U");
					virtualVslSkdHisInVO.setSkdCngStsCd(vskVslPortSkdVO.getSkdCngStsCd());
					virtualVslSkdHisInVO.setVslCd(vskVslPortSkdVO.getVslCd());
					virtualVslSkdHisInVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
					virtualVslSkdHisInVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
					virtualVslSkdHisInVO.setVslSlanCd(slanCd);
					virtualVslSkdHisInVO.setVpsPortCd(vskVslPortSkdVO.getVpsPortCd());
					virtualVslSkdHisInVO.setClptIndSeq(vskVslPortSkdVO.getTurnClptIndSeq());
					virtualVslSkdHisInVO.setYdCd(vskVslPortSkdVO.getYdCd());
					virtualVslSkdHisInVO.setVpsEtaDt(vskVslPortSkdVO.getVpsEtaDt());
					virtualVslSkdHisInVO.setVpsEtbDt(vskVslPortSkdVO.getVpsEtbDt());
					virtualVslSkdHisInVO.setVpsEtdDt(vskVslPortSkdVO.getVpsEtdDt());
					virtualVslSkdHisInVO.setVslDlayRsnCd(vskVslPortSkdVO.getVslDlayRsnCd());
					virtualVslSkdHisInVO.setVslDlayRsnDesc(vskVslPortSkdVO.getVslDlayRsnDesc());
					virtualVslSkdHisInVO.setVslDlayRsnLocCd(vskVslPortSkdVO.getVslDlayRsnLocCd());
					virtualVslSkdHisInVO.setUsrId(vskVslPortSkdVO.getUpdUsrId());
					virtualVslSkdHisInVO.setNewClptIndSeq(vskVslPortSkdVO.getTurnClptIndSeq());

					vslSkdHisInVOList.add(virtualVslSkdHisInVO);
				}

				//Next Port History Setting.
				if(VSKGeneralUtil.isVirtualPort(vskVslPortSkdVO.getTurnPortIndCd())){
					String slanCd = vskVslPortSkdVO.getSlanCd();

					// Next Turn Port 의 Lane 정보를 조회한다.
					VskVslPortSkdVO paramVO = new VskVslPortSkdVO();
					paramVO.setVslCd(vskVslPortSkdVO.getVslCd());
					paramVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
					paramVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());

					// Next Turn Port
					List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(paramVO);
					if(virtualPortVoList != null && virtualPortVoList.size() > 0){
						slanCd = virtualPortVoList.get(0).getSlanCd();
					}

					VslSkdHisInVO nxtVslSkdHisInVO = new VslSkdHisInVO();

					nxtVslSkdHisInVO.setIbflag("U");
					nxtVslSkdHisInVO.setSkdCngStsCd(vskVslPortSkdVO.getSkdCngStsCd());
					nxtVslSkdHisInVO.setVslCd(vskVslPortSkdVO.getVslCd());
					nxtVslSkdHisInVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
					nxtVslSkdHisInVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
					nxtVslSkdHisInVO.setVslSlanCd(slanCd);
					nxtVslSkdHisInVO.setVpsPortCd(vskVslPortSkdVO.getVpsPortCd());
					nxtVslSkdHisInVO.setClptIndSeq(vskVslPortSkdVO.getTurnClptIndSeq());
					nxtVslSkdHisInVO.setYdCd(vskVslPortSkdVO.getYdCd());
					nxtVslSkdHisInVO.setVpsEtaDt(vskVslPortSkdVO.getVpsEtaDt());
					nxtVslSkdHisInVO.setVpsEtbDt(vskVslPortSkdVO.getVpsEtbDt());
					nxtVslSkdHisInVO.setVpsEtdDt(vskVslPortSkdVO.getVpsEtdDt());
					nxtVslSkdHisInVO.setVslDlayRsnCd(vskVslPortSkdVO.getVslDlayRsnCd());
					nxtVslSkdHisInVO.setVslDlayRsnDesc(vskVslPortSkdVO.getVslDlayRsnDesc());
					nxtVslSkdHisInVO.setVslDlayRsnLocCd(vskVslPortSkdVO.getVslDlayRsnLocCd());
					nxtVslSkdHisInVO.setUsrId(vskVslPortSkdVO.getUpdUsrId());
					nxtVslSkdHisInVO.setNewClptIndSeq(vskVslPortSkdVO.getTurnClptIndSeq());

					vslSkdHisInVOList.add(nxtVslSkdHisInVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return vslSkdHisInVOList;
	}

	/**
	 * 스케줄이 변경이 되면 스케줄을 자동으로 조정한다.
	 *
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return SwapCstGRPVO
	 * @exception EventException
	 */
	private SwapCstGRPVO manageAutoSkdUpdate(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		
		SwapCstGRPVO swapCstGRPVO = new SwapCstGRPVO();
		
		log.info("\n #####################################################################");
		log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual.manageAutoSkdUpdate Inner.Started!!! #############");
		log.info("\n #####################################################################");
		
		String sOrgUpdTgtVvd		= null;
		String sOrgUpdTgtVpsPortCd	= null;
		String sOrgUpdTgtClptIndSeq	= null;
		
		List<VskVslPortSkdVO>	tmpRebuildSkdList	= new ArrayList<VskVslPortSkdVO>();
		
		try{
			String 					usrId 			= vskVslPortSkdVO.getUpdUsrId();
			List<VskVslPortSkdVO> 	rebuildSkdList 	= null;											//조정된 Schedule
			
			sOrgUpdTgtVvd			= vskVslPortSkdVO.getVslCd()+vskVslPortSkdVO.getSkdVoyNo()+vskVslPortSkdVO.getSkdDirCd();
			sOrgUpdTgtVpsPortCd		= vskVslPortSkdVO.getVpsPortCd	();
			sOrgUpdTgtClptIndSeq	= vskVslPortSkdVO.getClptIndSeq	();
			
			log.info("\n #####################################################################");
			log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual.manageAutoSkdUpdate.searchAutoSkdUpdate Outer.Started!!! #############");
			log.info("\n ACT_AUTO_UPDATE >> VVD+PORT+CLPT_IND_SEQ	VVD : ["+vskVslPortSkdVO.getVslCd()+vskVslPortSkdVO.getSkdVoyNo()+vskVslPortSkdVO.getSkdDirCd()+"], ["+vskVslPortSkdVO.getVpsPortCd()+"] ["+vskVslPortSkdVO.getClptIndSeq()+"]");
			log.info("\n #####################################################################");
			
			List<VskVslPortSkdVO> 	orgList 		= this.searchAutoSkdUpdate(vskVslPortSkdVO);	//자동 Update를 하기 위한 대상 목록 조회.
			
			log.info("\n #####################################################################");
			log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual.manageAutoSkdUpdate.searchAutoSkdUpdate Outer.Finished!!! #############");
			log.info("\n #####################################################################");

			String 					portSkdStsCd 	= vskVslPortSkdVO.getPortSkdStsCd();
			long 					dlayTime 		= 0L;											//Delay Time
			long 					recvTime 		= 0L;											//Recovery Time

			log.info("\n #####################################################################");
			log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual.manageAutoSkdUpdate Inner.STEP BY STEP #############");
			log.info("\n ACT_AUTO_UPDATE >> isUsedActualSkd(orgList) : ["+isUsedActualSkd(orgList)+"]");
			log.info("\n ACT_AUTO_UPDATE >> portSkdStsCd : ["+portSkdStsCd+"]");
			log.info("\n #####################################################################");
			
			//::isUsedActualSkd <== parameter 유효한값이고 ACT_INP_FLG = "Y"이 아닌경우 TRUE:://
			if(orgList != null && orgList.size()>0 && this.isUsedActualSkd(orgList)){
				
				if("A".equals(portSkdStsCd)){
					String orgEtaDt = orgList.get(0).getVpsEtaDt();
					String usrEtaDt = vskVslPortSkdVO.getVpsEtaDt();

					int dlayFlg = isDlaySkdDate(orgEtaDt, usrEtaDt);
					if(dlayFlg < 0){
						dlayTime = diffSkdDate(orgEtaDt, usrEtaDt);
					}else if(dlayFlg > 0){
						recvTime = diffSkdDate(orgEtaDt, usrEtaDt);
					}
				}else if("B".equals(portSkdStsCd)){
					String orgEtbDt = orgList.get(0).getVpsEtbDt();
					String usrEtbDt = vskVslPortSkdVO.getVpsEtbDt();

					int dlayFlg = isDlaySkdDate(orgEtbDt, usrEtbDt);
					if(dlayFlg < 0){
						dlayTime = diffSkdDate(orgEtbDt, usrEtbDt);
					}else if(dlayFlg > 0){
						recvTime = diffSkdDate(orgEtbDt, usrEtbDt);
					}
				}else if("D".equals(portSkdStsCd)){
					String orgEtdDt = orgList.get(0).getVpsEtdDt();
					String usrEtdDt = vskVslPortSkdVO.getVpsEtdDt();

					log.info("\n ACT_AUTO_UPDATE >> portSkdStsCd -- Departure > dlayFlg : ["+isDlaySkdDate(orgEtdDt, usrEtdDt)+"]");
					
					int dlayFlg = this.isDlaySkdDate(orgEtdDt, usrEtdDt);
					if(dlayFlg < 0){
						dlayTime = this.diffSkdDate(orgEtdDt, usrEtdDt);
						log.info("\n ACT_AUTO_UPDATE >> dlayTime : ["+this.diffSkdDate(orgEtdDt, usrEtdDt)+"]");
					}else if(dlayFlg > 0){
						recvTime = this.diffSkdDate(orgEtdDt, usrEtdDt);
						log.info("\n ACT_AUTO_UPDATE >> recvTime : ["+this.diffSkdDate(orgEtdDt, usrEtdDt)+"]");
					}
				}

				// dlayTime이나 recvTime이 발생하는 경우는 기존 ETA/ETB/ETD와 다른 스케쥴을 입력하였을 경우발생한다.
				// 즉, PF 대비가 아닌 Estimate/Coastal 의 기존과 현재 값의 비교값으로 생각해야 한다.
				// 그러므로, dlayTime, recvTime 어느 경우에서나 PF 대비 Delay/Advance 상황이 발생할 수 있다.
				if(dlayTime > 0){
					
					log.info("\n #####################################################################");
					log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual.manageAutoSkdUpdate.calcDelayAutoSkdUpdate Outer.Started!!! #############");
					log.info("\n ACT_AUTO_UPDATE >> Condition::dlayTime>0 VVD+PORT+CLPT_IND_SEQ	VVD : ["+vskVslPortSkdVO.getVslCd()+vskVslPortSkdVO.getSkdVoyNo()+vskVslPortSkdVO.getSkdDirCd()+"], ["+vskVslPortSkdVO.getVpsPortCd()+"] ["+vskVslPortSkdVO.getClptIndSeq()+"]");
					log.info("\n #####################################################################");
					
					rebuildSkdList = this.calcDelayAutoSkdUpdate		(orgList, vskVslPortSkdVO, (int)dlayTime, portSkdStsCd, usrId);
					
					log.info("\n #####################################################################");
					log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual.manageAutoSkdUpdate.calcDelayAutoSkdUpdate Outer.Finished!!! #############");
					log.info("\n #####################################################################");
					
				}else if(recvTime < 0){
					
					log.info("\n #####################################################################");
					log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual.manageAutoSkdUpdate.calcRecoveryAutoSkdUpdate Outer.Started!!! #############");
					log.info("\n ACT_AUTO_UPDATE >> Condition::recvTime<0 VVD+PORT+CLPT_IND_SEQ	VVD : ["+vskVslPortSkdVO.getVslCd()+vskVslPortSkdVO.getSkdVoyNo()+vskVslPortSkdVO.getSkdDirCd()+"], ["+vskVslPortSkdVO.getVpsPortCd()+"] ["+vskVslPortSkdVO.getClptIndSeq()+"]");
					log.info("\n #####################################################################");
					
					rebuildSkdList = this.calcRecoveryAutoSkdUpdate	(orgList, vskVslPortSkdVO, (int)recvTime, portSkdStsCd, usrId);
					
					log.info("\n #####################################################################");
					log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual.manageAutoSkdUpdate.calcRecoveryAutoSkdUpdate Outer.Finished!!! #############");
					log.info("\n #####################################################################");
					
				}

				if(rebuildSkdList != null && rebuildSkdList.size()>0){
					VskVslPortSkdVO firstRebuidVO = rebuildSkdList.get(0);

					List<VskVslSkdVO> vskVslSkdVOList = new ArrayList<VskVslSkdVO>();

//					=====================================================================================
					vskVslSkdVOList.add(addActCrrCd(makeVskVslSkdDataSet(firstRebuidVO)));
//					=====================================================================================

					boolean isFirstPort = false;
					String preVVD = "";
					String curVVD = "";

					for(VskVslPortSkdVO rebuildVO : rebuildSkdList){
						String vslCd 		= rebuildVO.getVslCd		();
						String skdVoyNo 	= rebuildVO.getSkdVoyNo		();
						String skdDirCd 	= rebuildVO.getSkdDirCd		();
						String vpsPortCd 	= rebuildVO.getVpsPortCd	();
						String clptIndSeq 	= rebuildVO.getClptIndSeq	();

						curVVD = vslCd + skdVoyNo + skdDirCd;

						if(!"".equals(preVVD)){
							if(!preVVD.equals(curVVD)){
								isFirstPort = true;
							}
						}

						if(isFirstPort){
							VskVslPortSkdVO chkParamVO = new VskVslPortSkdVO();

							chkParamVO.setVslCd		(vslCd		);
							chkParamVO.setSkdVoyNo	(skdVoyNo	);
							chkParamVO.setSkdDirCd	(skdDirCd	);
							chkParamVO.setVpsPortCd	(vpsPortCd	);
							chkParamVO.setClptIndSeq(clptIndSeq	);
							
							if("Y".equals(dbDao.checkFirstCallingPort(chkParamVO))){
								VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();

								vskVslSkdVO.setVslCd			(vslCd					);
								vskVslSkdVO.setSkdVoyNo			(skdVoyNo				);
								vskVslSkdVO.setSkdDirCd			(skdDirCd				);
								vskVslSkdVO.setStPortCd			(vpsPortCd				);
								vskVslSkdVO.setVslSlanCd		(rebuildVO.getSlanCd	());
								vskVslSkdVO.setN1stPortBrthDt	(rebuildVO.getVpsEtbDt	());
								vskVslSkdVO.setUpdUsrId			(rebuildVO.getUpdUsrId	());
								
								vskVslSkdVOList.add(vskVslSkdVO);
								isFirstPort = false;
							}else{
								isFirstPort = true;
							}
						}
						preVVD = vslCd + skdVoyNo + skdDirCd;

						/**********************************************************************
						 * When Actual SKED Created, Distinguish Corresponding Port
						 * ====================================================================
						 * rebuildSkdList
						 **********************************************************************/
						VskVslPortSkdVO	tmpRebuildPortSkdVO	= new VskVslPortSkdVO();
						
						ObjectCloner.build(rebuildVO, tmpRebuildPortSkdVO);
						tmpRebuildPortSkdVO.setOrgUpdTgtVvd			(sOrgUpdTgtVvd			);
						tmpRebuildPortSkdVO.setOrgUpdTgtVpsPortCd	(sOrgUpdTgtVpsPortCd	);
						tmpRebuildPortSkdVO.setOrgUpdTgtClptIndSeq	(sOrgUpdTgtClptIndSeq	);
						
						tmpRebuildSkdList.add						(tmpRebuildPortSkdVO	);
						
					} // end for
					
					swapCstGRPVO.setVskVslSkdVOList		(vskVslSkdVOList	);
					swapCstGRPVO.setVskVslPortSkdVOList	(tmpRebuildSkdList	);
					
					////swapCstGRPVO.setVskVslSkdVOList		(vskVslSkdVOList);
					////swapCstGRPVO.setVskVslPortSkdVOList	(rebuildSkdList	);
				}
				
			}else{
				List<VskVslSkdVO> vskVslSkdVOList = new ArrayList<VskVslSkdVO>();
				vskVslSkdVOList.add(addActCrrCd(makeVskVslSkdDataSet(vskVslPortSkdVO)));

				swapCstGRPVO.setVskVslSkdVOList(vskVslSkdVOList);
			}
			
		} catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (DAOException ex) {
			/*
			 * MSG - 수정 서비스 실행중 오류가 발생하였을 경우.
			 */
			throw new EventException(new ErrorHandler("VSK10038").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return swapCstGRPVO;
	}

	/**
	 * 각 Buffer Time 을 이용하여 Delay 된 스케줄을 조정한다.
	 *
	 * @param List<VskVslPortSkdVO> list
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @param int dlayTime
	 * @param String portSkdStsCd
	 * @param String usrId
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	private List<VskVslPortSkdVO> calcDelayAutoSkdUpdate(List<VskVslPortSkdVO> vskVslPortSkdVOs, VskVslPortSkdVO vskVslPortSkdVO, int dlayTime, String portSkdStsCd, String usrId) throws EventException {
		List<VskVslPortSkdVO> 	rstList 	= new ArrayList<VskVslPortSkdVO>();
		int 					portBufTime = 0;
		int 					seaBufTime 	= 0;
		
		log.info("\n #####################################################################");
		log.info("\n ########## ACT_AUTO_UPDATE >> VesselScheduleMgtBCImpl.manageCstSkdByActual ... calcDelayAutoSkdUpdate Inner.Started!!! #############");
		log.info("\n #####################################################################");		
		
		try{
			String 			actAutoId 	= "ACT_AUTO_UPDATE";
			int 			cnt 		= vskVslPortSkdVOs.size();
			VskVslPortSkdVO firstVO 	= vskVslPortSkdVOs.get(0);

			// Port Buffer 조정.
			if("A".equals(portSkdStsCd)){
				
				firstVO.setVpsEtaDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtaDt(), dlayTime));
				firstVO.setVpsEtbDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtbDt(), dlayTime));
				portBufTime = getConvertMinByBufTime(firstVO.getPortBufHrs());
				
				if(isCompareBufTime(dlayTime, portBufTime)){
					dlayTime = dlayTime - portBufTime;
					firstVO.setVpsEtdDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtdDt(), dlayTime));
					portBufTime = 0;
					firstVO.setPortBufHrs(portBufTime+"");
				}else{
					portBufTime = portBufTime - dlayTime;
					firstVO.setPortBufHrs(getConvertHourByBufTime(portBufTime));
					dlayTime = 0;
				}
			}else if("B".equals(portSkdStsCd)){
				firstVO.setVpsEtbDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtbDt(), dlayTime));
				portBufTime = getConvertMinByBufTime(firstVO.getPortBufHrs());
				if(isCompareBufTime(dlayTime, portBufTime)){
					dlayTime = dlayTime - portBufTime;
					firstVO.setVpsEtdDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtdDt(), dlayTime));
					portBufTime = 0;
					firstVO.setPortBufHrs(portBufTime + "");
				}else{
					portBufTime = portBufTime - dlayTime;
					firstVO.setPortBufHrs(getConvertHourByBufTime(portBufTime));
					dlayTime = 0;
				}
			}else if("D".equals(portSkdStsCd)){
				//ETD 가 Delay 로 입력된 경우는 buffer time 을 무시하고 입력한 Delay 값으로 조정.
				firstVO.setVpsEtdDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtdDt(), dlayTime));
				
				log.info("\n #####################################################################");
				log.info("\n ACT_AUTO_UPDATE >> Departure : dlayTime ["+dlayTime+"], org getVpsEtdDt ["+firstVO.getVpsEtdDt()+"], adjusted setVpsEtdDt ["+VSKGeneralUtil.addDelayTime(firstVO.getVpsEtdDt(), dlayTime)+"]");
				log.info("\n #####################################################################");
			}

			if(dlayTime > 0){
				// Sea Buffer 조정 - 다음 Schedule 이 존재할 경우에만.
				if(cnt > 1){
					/*
					 * Next Port 가 auto 금지이거나 Skip 인 경우는
					 * Sea Buffer Time 을 재설정 해야 하나 정확한 값을 입력 못하고 있으므로 무시함.
					 */
					seaBufTime = getConvertMinByBufTime(firstVO.getSeaBufHrs());
					if(isCompareBufTime(dlayTime, seaBufTime)){
						firstVO.setSeaBufHrs("0");
					}else{
						firstVO.setSeaBufHrs(getConvertHourByBufTime(seaBufTime - dlayTime));
					}
				}
			}

			// 사용자가 입력한 Port 는 사용자가 입력한 변경사항도 함께 적용한다.
			firstVO.setSkdCngStsCd		(vskVslPortSkdVO.getSkdCngStsCd		());
			firstVO.setSlanCd			(vskVslPortSkdVO.getSlanCd			());
			firstVO.setYdCd				(vskVslPortSkdVO.getYdCd			());
			firstVO.setVslDlayRsnCd		(vskVslPortSkdVO.getVslDlayRsnCd	());
			firstVO.setVslDlayRsnDesc	(vskVslPortSkdVO.getVslDlayRsnDesc	());
			firstVO.setVslDlayRsnLocCd	(vskVslPortSkdVO.getVslDlayRsnLocCd	());
			firstVO.setUpdUsrId			(usrId);
			rstList.add					(firstVO);
			
			log.info("\n ACT_AUTO_UPDATE >> firstVO --- delay or advance target	VVD+Port : ["+firstVO.getVslCd()+firstVO.getSkdVoyNo()+firstVO.getSkdDirCd()+"], ["+firstVO.getVpsPortCd()+"] ["+firstVO.getClptIndSeq()+"] :: ETD ["+firstVO.getVpsEtdDt()+"]");

			for(int i=1; i<cnt; i++){
				VskVslPortSkdVO portVO = vskVslPortSkdVOs.get(i);

				
				log.info("\n ACT_AUTO_UPDATE >> FOOR.LOOP Inner isCallAutoProcess ["+this.isCallAutoProcess(portVO)+"] ["+portVO.getVslCd()+portVO.getSkdVoyNo()+portVO.getSkdDirCd()+"], ["+portVO.getVpsPortCd()+"] ["+portVO.getClptIndSeq()+"] :: ETD ["+portVO.getVpsEtdDt()+"]");
				
				/*********************************************************************************
				 * * ACT_AUTO_UPDATE 대상판별
				 * -------------------------------------------------------------------------------
				 * this.isCallAutoProcess(portVO) :: true Only Auto-Update
				 * <CASE : false> 
				 * VSK_VSL_PORT_SKD.AUTO_SKD_CNG_FLG	= "Y" (SKD AUTO UPDATE 비대상) OR
				 * VSK_VSL_PORT_SKD.SKD_CNG_STS_CD		= "S" (SKIP PORT)
				 * -------------------------------------------------------------------------------
				 */
				
				if(this.isCallAutoProcess(portVO)){
					if(dlayTime > 0){
						if(this.isCompareBufTime(dlayTime, seaBufTime)){
							dlayTime = dlayTime - seaBufTime;
							portVO.setVpsEtaDt(VSKGeneralUtil.addDelayTime(portVO.getVpsEtaDt(), dlayTime));
							portVO.setVpsEtbDt(VSKGeneralUtil.addDelayTime(portVO.getVpsEtbDt(), dlayTime));

							portBufTime = getConvertMinByBufTime(portVO.getPortBufHrs());
							if(this.isCompareBufTime(dlayTime, portBufTime)){
								dlayTime = dlayTime - portBufTime;
								portVO.setVpsEtdDt(VSKGeneralUtil.addDelayTime(portVO.getVpsEtdDt(), dlayTime));
								portVO.setPortBufHrs("0");
							}else{
								portBufTime = portBufTime - dlayTime;
								portVO.setPortBufHrs(getConvertHourByBufTime(portBufTime));
								dlayTime = 0;
							}

							if(dlayTime > 0){
								// Sea Buffer 조정 - 다음 Schedule 이 존재할 경우에만.
								if(i < cnt-1){
									seaBufTime = getConvertMinByBufTime(portVO.getSeaBufHrs());
									if(this.isCompareBufTime(dlayTime, seaBufTime)){
										portVO.setSeaBufHrs("0");
									}else{
										portVO.setSeaBufHrs(getConvertHourByBufTime(seaBufTime - dlayTime));
									}
								}
							}

							// auto update에 의한 ETA, ETB, ETD는 30분 단위로 조정한다.
							// 30분 미만은 절삭, 30분 초과는 반올림, 30분은 그냥 그대로 표현
							portVO.setVpsEtaDt(VSKGeneralUtil.controlTime(portVO.getVpsEtaDt(), 30));
							portVO.setVpsEtbDt(VSKGeneralUtil.controlTime(portVO.getVpsEtbDt(), 30));
							portVO.setVpsEtdDt(VSKGeneralUtil.controlTime(portVO.getVpsEtdDt(), 30));

						}else{
							dlayTime = 0;
						}
					}else{
						break;
					}
					portVO.setUpdUsrId	(actAutoId);
					
					rstList.add			(portVO);
					
					log.info("\n ACT_AUTO_UPDATE >> portVO --- delay or advance target	VVD+Port : ["+portVO.getVslCd()+portVO.getSkdVoyNo()+portVO.getSkdDirCd()+"], ["+portVO.getVpsPortCd()+"] ["+portVO.getClptIndSeq()+"] :: ETD ["+portVO.getVpsEtdDt()+"]");

				}
			} // end for
			
		}catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return rstList;
	}

	/**
	 * Delay 된 스케줄을 회복 할 경우.
	 *
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @param int recvTime
	 * @param String portSkdStsCd
	 * @param String usrId
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	private List<VskVslPortSkdVO> calcRecoveryAutoSkdUpdate(List<VskVslPortSkdVO> vskVslPortSkdVOs, VskVslPortSkdVO vskVslPortSkdVO, int recvTime, String portSkdStsCd, String usrId) throws EventException {
		List<VskVslPortSkdVO> rstList = new ArrayList<VskVslPortSkdVO>();
		try{
			String actAutoId = "ACT_AUTO_UPDATE";
			int cnt = vskVslPortSkdVOs.size();
			VskVslPortSkdVO firstVO = vskVslPortSkdVOs.get(0);

			// 사용자가 입력한 Port 조정.
			if("A".equals(portSkdStsCd)){
				String recvEtbDt = VSKGeneralUtil.addDelayTime(firstVO.getVpsEtbDt(), recvTime);
				String recvEtdDt = VSKGeneralUtil.addDelayTime(firstVO.getVpsEtdDt(), recvTime);
				String pfEtbDt = VSKGeneralUtil.isNotNull(firstVO.getPfEtbDt())?firstVO.getPfEtbDt():firstVO.getInitEtbDt();
				String pfEtdDt = VSKGeneralUtil.isNotNull(firstVO.getPfEtdDt())?firstVO.getPfEtdDt():firstVO.getInitEtdDt();

				firstVO.setVpsEtaDt(vskVslPortSkdVO.getVpsEtaDt());
				firstVO.setVpsEtbDt(callRecoveryDate(recvEtbDt, pfEtbDt));
				firstVO.setVpsEtdDt(callRecoveryDate(recvEtdDt, pfEtdDt));
			}else if("B".equals(portSkdStsCd)){
				String recvEtdDt = VSKGeneralUtil.addDelayTime(firstVO.getVpsEtdDt(), recvTime);
				String pfEtdDt = VSKGeneralUtil.isNotNull(firstVO.getPfEtdDt())?firstVO.getPfEtdDt():firstVO.getInitEtdDt();

				firstVO.setVpsEtbDt(vskVslPortSkdVO.getVpsEtbDt());
				firstVO.setVpsEtdDt(callRecoveryDate(recvEtdDt, pfEtdDt));
			}else if("D".equals(portSkdStsCd)){
				firstVO.setVpsEtdDt(vskVslPortSkdVO.getVpsEtdDt());
			}


			// 사용자가 입력한 Port 는 사용자가 입력한 변경사항도 함께 적용한다.
			firstVO.setSkdCngStsCd(vskVslPortSkdVO.getSkdCngStsCd());
			firstVO.setSlanCd(vskVslPortSkdVO.getSlanCd());
			firstVO.setYdCd(vskVslPortSkdVO.getYdCd());
			firstVO.setVslDlayRsnCd(vskVslPortSkdVO.getVslDlayRsnCd());
			firstVO.setVslDlayRsnDesc(vskVslPortSkdVO.getVslDlayRsnDesc());
			firstVO.setVslDlayRsnLocCd(vskVslPortSkdVO.getVslDlayRsnLocCd());
			firstVO.setUpdUsrId(usrId);
			rstList.add(firstVO);

			boolean isAdvanced = false;

			for(int i=1; i<cnt; i++){
				VskVslPortSkdVO portVO = vskVslPortSkdVOs.get(i);

				if(isCallAutoProcess(portVO)){
					String pfEtaDt = VSKGeneralUtil.isNotNull(portVO.getPfEtaDt())?portVO.getPfEtaDt():portVO.getInitEtaDt();
					String pfEtbDt = VSKGeneralUtil.isNotNull(portVO.getPfEtbDt())?portVO.getPfEtbDt():portVO.getInitEtbDt();
					String pfEtdDt = VSKGeneralUtil.isNotNull(portVO.getPfEtdDt())?portVO.getPfEtdDt():portVO.getInitEtdDt();

					portVO.setUpdUsrId(actAutoId);

					// 이미 Advanced된 스케쥴은 PF SKD을 적용한다.
					// Delay 가 된 경우.
					if(!isAdvanced && isDlaySkdDate(pfEtaDt, portVO.getVpsEtaDt()) < 0){

						// VPS_ETA_DT에 Delay 반영분을 적용
						String recvEtaDt = VSKGeneralUtil.addDelayTime(portVO.getVpsEtaDt(), recvTime);
						portVO.setVpsEtaDt(callRecoveryDate(recvEtaDt, pfEtaDt));


						if(isDlaySkdDate(pfEtbDt, portVO.getVpsEtbDt()) < 0){

							// VPS_ETB_DT에 Delay 반영분을 적용
							String recvEtbDt = VSKGeneralUtil.addDelayTime(portVO.getVpsEtbDt(), recvTime);
							portVO.setVpsEtbDt(callRecoveryDate(recvEtbDt, pfEtbDt));

							if(isDlaySkdDate(pfEtdDt, portVO.getVpsEtdDt()) < 0){

								// VPS_ETD_DT에 Delay 반영분을 적용
								String recvEtdDt = VSKGeneralUtil.addDelayTime(portVO.getVpsEtdDt(), recvTime);
								portVO.setVpsEtdDt(callRecoveryDate(recvEtdDt, pfEtdDt));
							}else{
								isAdvanced = true;

								// PF SKD보다 VPS SKD가 더 늦은 상황(Advance)
								portVO.setVpsEtdDt(pfEtdDt);
								rstList.add(portVO);
								continue;

							}
						}else{
							isAdvanced = true;

							// PF SKD보다 VPS SKD가 더 늦은 상황(Advance)
							portVO.setVpsEtbDt(pfEtbDt);
							portVO.setVpsEtdDt(pfEtdDt);
							rstList.add(portVO);
							continue;


						}

						// auto update에 의한 ETA, ETB, ETD는 30분 단위로 조정한다.
						// 30분 미만은 절삭, 30분 초과는 반올림, 30분은 그냥 그대로 표현
						portVO.setVpsEtaDt(VSKGeneralUtil.controlTime(portVO.getVpsEtaDt(), 30));
						portVO.setVpsEtbDt(VSKGeneralUtil.controlTime(portVO.getVpsEtbDt(), 30));
						portVO.setVpsEtdDt(VSKGeneralUtil.controlTime(portVO.getVpsEtdDt(), 30));

						rstList.add(portVO);
					}else{
						isAdvanced = true;

						// PF SKD보다 VPS SKD가 더 늦은 상황(Advance)
						portVO.setVpsEtaDt(pfEtaDt);
						portVO.setVpsEtbDt(pfEtbDt);
						portVO.setVpsEtdDt(pfEtdDt);
						rstList.add(portVO);
						continue;

					}
				}
			} // end for
		}catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return rstList;
	}

	/**
	 * 회복시간과 P/F시간을 비교하여 느린 시간을 반환.
	 *
	 * @param String recvDate
	 * @param String pfDate
	 * @return String
	 * @exception EventException
	 */
	private String callRecoveryDate(String recvDate, String pfDate) throws EventException{
		String rtnDate = "";
		if(diffSkdDate(recvDate, pfDate) >= 0){
			rtnDate = pfDate;
		}else{
			rtnDate = recvDate;
		}
		return rtnDate;
	}

	/**
	 * Auto Update Flag(0015 화면에 의해 체크되는 속성)가 "Y"이거나 Skip 인 경우는 Auto Update 금지.
	 * 일반적으로, Skip 인 경우는 SQL에서 제거해서 Data 를 가져옴.
	 *
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return boolean
	 */
	private boolean isCallAutoProcess(VskVslPortSkdVO vskVslPortSkdVO){
		boolean rstFlg = true;

		if("Y".equals(vskVslPortSkdVO.getAutoSkdCngFlg()) || "S".equals(vskVslPortSkdVO.getSkdCngStsCd())){
			rstFlg = false;
		}
		return rstFlg;
	}

	/**
	 * Delay 시간이 Buffer 시간보다 큰지를 검사.
	 *
	 * @param int dlayTime
	 * @param int bufTime
	 * @return boolean
	 */
	private boolean isCompareBufTime(int dlayTime, int bufTime){
		boolean flag = false;

		if(dlayTime > bufTime){
			flag = true;
		}
		return flag;
	}

	/**
	 * 시간 단위의 Buffer Time 을 분 단위로 변경.
	 *
	 * @param String bufTime
	 * @return int
	 */
	private int getConvertMinByBufTime(String bufTime){
		if(!VSKGeneralUtil.isNotNull(bufTime)){
			bufTime = "0";
		}
		int nBufTime = 0;

		nBufTime = (int)(Double.parseDouble(bufTime) * 60);

		return nBufTime;
	}

	/**
	 * 분 단위의 Buffer Time 을 시 단위로 변경.
	 *
	 * @param double dBufTime
	 * @return String
	 */
	private String getConvertHourByBufTime(double bufTime){
		double dBufTime = 0.0;

		dBufTime = bufTime / 6.0;
		dBufTime = Math.round(dBufTime) / 10.0;

		return dBufTime+"";
	}

	/**
	 * 두 날짜의 지연 여부를 확인한다.
	 *
	 * @param String date1
	 * @param String date2
	 * @return int
	 * @exception EventException
	 */
	private int isDlaySkdDate(String date1, String date2) throws EventException {
		String pattern = "yyyyMMddHHmm";
		return VSKGeneralUtil.compareSkdDate(date1, pattern, date2, pattern);
	}

	/**
	 * 두 날짜의 차이를 계산한다.
	 * date2 - date1
	 *
	 * @param String date1
	 * @param String date2
	 * @return String
	 * @exception EventException
	 */
	private long diffSkdDate(String date1, String date2) throws EventException {
		String pattern = "yyyyMMddHHmm";
		return VSKGeneralUtil.dateDiff(date1, pattern, date2, pattern, "m");
	}

	/**
	 * 자동 Update 를 하기 위한 대상 목록 조회.
	 *
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	private List<VskVslPortSkdVO> searchAutoSkdUpdate(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		List<VskVslPortSkdVO> list = null;
		try{
			list = dbDao.searchAutoSkdUpdate(vskVslPortSkdVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return list;
	}

	/**
	 * Auto Update 대상 목록중 Actual 이 존재하는지 판단하여 해당 Flag 반환.
	 *
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @return boolean
	 */
	private boolean isUsedActualSkd(List<VskVslPortSkdVO> vskVslPortSkdVOs) {
		boolean actFlag = true;
		
		if(vskVslPortSkdVOs != null && vskVslPortSkdVOs.size()>0){
			int voSize = vskVslPortSkdVOs.size();
			for(int i=1; i<voSize; i++){
				if("Y".equals(vskVslPortSkdVOs.get(i).getActInpFlg())){
					actFlag = false;
					break;
				}
			}
		}else{
			actFlag = false;
		}

		return actFlag;
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
	 * Costal Schedule Simulation 정보를 조회합니다.<br>
	 *
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @exception EventException
	 */
	public List<SwapCstSkdSimVO> searchCstSkdSim(SwapCstSkdSimVO swapCstSkdSimVO) throws EventException {
		List<SwapCstSkdSimVO> list = null;
		try {
			String rtvFlg = swapCstSkdSimVO.getRtvFlg();

			if("N".equals(rtvFlg)){
				list = dbDao.searchCstSkdSrc(swapCstSkdSimVO);
			} else if ("Y".equals(rtvFlg)) {
				list = dbDao.searchCstSkdSim(swapCstSkdSimVO);
			} else {
				/*
				 * MSG - 조회중 오류가 발생하였습니다.
				 */
				throw new EventException(new ErrorHandler("VSK10035").getMessage());
			}
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
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

		return list;
	}
	
	/**
	 * Vessel / Lane 에 대해서 마지막 Port 의 정보를 체크한다.
	 * 
	 * true 반환 조건
	 * 1. Vessel / Lane 에 대해서 마지막 Port가 List에 존재하고
	 * 2. 마지막 Port 의 VPS_ETA_DT 가 SYSTEM DATE 기준 30일 이내이고
	 * 3. 마지막 Port 의 SKD_CNG_STS_CD = 'O' 가 아닌 경우
	 * 
	 * @param swapCstSkdSimVO swapCstSkdSimVO
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkVesselLaneLastPort(SwapCstSkdSimVO swapCstSkdSimVO) throws EventException {
		boolean resultFlg = false;
		try {
			VslPortSkdVO vslPortSkdVO =  dbDao.searchVesselLaneLastPort(swapCstSkdSimVO);
			
			if (vslPortSkdVO != null && vslPortSkdVO.getVslCd() != null && vslPortSkdVO.getSkdVoyNo() != null && vslPortSkdVO.getSkdDirCd() != null && vslPortSkdVO.getVpsPortCd() != null && vslPortSkdVO.getClptIndSeq() != null && vslPortSkdVO.getVpsEtaDt() != null
					&& vslPortSkdVO.getVslCd().equals(swapCstSkdSimVO.getVslCd()) 
					&& vslPortSkdVO.getSkdVoyNo().equals(swapCstSkdSimVO.getSkdVoyNo()) 
					&& vslPortSkdVO.getSkdDirCd().equals(swapCstSkdSimVO.getSkdDirCd()) 
					&& vslPortSkdVO.getVpsPortCd().equals(swapCstSkdSimVO.getVpsPortCd()) 
					&& vslPortSkdVO.getClptIndSeq().equals(swapCstSkdSimVO.getClptIndSeq())) {
				
					String curDate = VSKGeneralUtil.replaceDateTypeToString(JSPUtil.getKSTDate());
					String etaDt = vslPortSkdVO.getVpsEtaDt();
					long dateL = VSKGeneralUtil.dateDiff(curDate, "yyyyMMdd", etaDt, "yyyyMMdd", "d");
					
					if (dateL >= 0 && dateL <= 30 && !"O".equals(vslPortSkdVO.getSkdCngStsCd())) {
						resultFlg = true;
					}
					
				}
		} catch (DAOException ex) {
			/* MSG - 조회중 오류가 발생하였습니다. */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/* MSG - 서비스 실행중 오류가 발생하였습니다. */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		
		return resultFlg;
	}

	/**
	 * Port의 Costal Schedule 정보를 조회합니다.<br>
	 *
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return VslPortSkdVO
	 * @exception EventException
	 */
	public VslPortSkdVO searchCstSkdByVvdPort(VslPortSkdVO vslPortSkdVO) throws EventException {
		try {
			return dbDao.searchCstSkdByVvdPort(vslPortSkdVO);
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
	 * 해당 Port의 Vessel Berth 정보를 조회합니다.<br>
	 *
	 * @param CstSkdBerthWdoVO cstSkdBerthWdoVO
	 * @return List<CstSkdBerthWdoVO>
	 * @exception EventException
	 */
	public List<CstSkdBerthWdoVO> searchCstSkdBerthWdo(CstSkdBerthWdoVO cstSkdBerthWdoVO) throws EventException {
		try {
			return dbDao.searchCstSkdBerthWdo(cstSkdBerthWdoVO);
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
	 * 기간별 Por에 기항하는 Coastal 정보, ETA, ETB, ETD, Next ETA등 기타 정보를 변경한다.<br>
	 *
	 * @param CstSkdBerthWdoVO[] cstSkdBerthWdoVOs
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdBerthWdo(CstSkdBerthWdoVO[] cstSkdBerthWdoVOs, SignOnUserAccount account) throws EventException {
		VslSkdChgStsGRPVO vslSkdChgStsGRPVO = new VslSkdChgStsGRPVO();

		try {
			if(cstSkdBerthWdoVOs != null){
				List<CstSkdBerthWdoVO> cstSkdBerthWdoVOList = new ArrayList<CstSkdBerthWdoVO>();
				String userId = currentUserId(account, cstSkdBerthWdoVOs[0].getUpdUsrId());

				//================================================================================================================
				//[사용자가 조회한 후 Data가 변경이 되어 있는 경우 START]
				int okCnt = 0;
				int failCnt = 0;
				List<String> failPortInfos		= new ArrayList<String>();
				List<String> reversedPortInfos	= new ArrayList<String>();
				
				for(CstSkdBerthWdoVO cstSkdBerthWdoVO : cstSkdBerthWdoVOs){
					
					if (cstSkdBerthWdoVO == null) continue;
					
					VskVslPortSkdVO originPortParamVO = new VskVslPortSkdVO();
					originPortParamVO.setVslCd(cstSkdBerthWdoVO.getVslCd());
					originPortParamVO.setSkdVoyNo(cstSkdBerthWdoVO.getSkdVoyNo());
					originPortParamVO.setSkdDirCd(cstSkdBerthWdoVO.getSkdDirCd());
					List<VskVslPortSkdVO> originPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(originPortParamVO);	//현재 VVD의 저장되기 전의 Port 정보를 조회한다.

					log.debug("---------------------------["+cstSkdBerthWdoVO.getIbflag()+"]");
					if(originPortVoList != null && originPortVoList.size()>0){
						for(VskVslPortSkdVO vskVslPortSkdVO : originPortVoList){
							if(cstSkdBerthWdoVO.getVpsPortCd().equals(vskVslPortSkdVO.getVpsPortCd()) && cstSkdBerthWdoVO.getClptIndSeq().equals(vskVslPortSkdVO.getClptIndSeq())){
								if(!cstSkdBerthWdoVO.getUpdDt().equals(vskVslPortSkdVO.getUpdDt())){
									/*
									 * 저장시 동일한 데이터가 누군가가 이미 변경했을 경우. 동일 데이터를 여러 사용자가 공유할 경우 발생하는 에러방지
									 * MSG - Someone has already changed same data. After retrieve and retry again.
									 */
									failCnt++;
									String portInfo = cstSkdBerthWdoVO.getVslCd()
													+ cstSkdBerthWdoVO.getSkdVoyNo()
													+ cstSkdBerthWdoVO.getSkdDirCd() + "/"
													+ cstSkdBerthWdoVO.getVpsPortCd() + "/"
													+ cstSkdBerthWdoVO.getClptIndSeq();
									failPortInfos.add(portInfo);
								} else {
									/*
									 * Pre ETD < ETA < ETB < ETD < Next ETA 가 맞는지 확인 한다.
									 */
									originPortParamVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
									originPortParamVO.setClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());
									originPortParamVO.setVpsEtaDt(cstSkdBerthWdoVO.getVpsEtaDt());
									originPortParamVO.setVpsEtbDt(cstSkdBerthWdoVO.getVpsEtbDt());
									originPortParamVO.setVpsEtdDt(cstSkdBerthWdoVO.getVpsEtdDt());
									List<ReversedPortInfoVO> reversedPortInfoVoList = dbDao.checkVslSkdReversedPortInfo(originPortParamVO);	//현재 VVD 기준으로 SKD DATE, TIME가 역전된 ReversedPortInfo를 조회.
				
									StringBuffer sbReversedPortInfo = new StringBuffer();
														
									if(reversedPortInfoVoList != null && reversedPortInfoVoList.size() > 0){
										for(ReversedPortInfoVO tempVO : reversedPortInfoVoList){
											if("Y".equals(tempVO.getPreRvsExistFlg())) {
												sbReversedPortInfo.append("\n").append(tempVO.getVslCd()).append(tempVO.getSkdVoyNo()).append(tempVO.getSkdDirCd()).append(" : Current ETA is reversed with Previous ETD [").append(tempVO.getPreVpsPortCd()).append("]");
											}
											if("Y".equals(tempVO.getEtaEtbRvsExistFlg())) {
												sbReversedPortInfo.append("\n").append(tempVO.getVslCd()).append(tempVO.getSkdVoyNo()).append(tempVO.getSkdDirCd()).append(" : Current ETA is reversed with Current ETB [").append(tempVO.getVpsPortCd()).append("]");
											}
											if("Y".equals(tempVO.getEtbEtdRvsExistFlg())) {
												sbReversedPortInfo.append("\n").append(tempVO.getVslCd()).append(tempVO.getSkdVoyNo()).append(tempVO.getSkdDirCd()).append(" : Current ETB is reversed with Current ETD [").append(tempVO.getVpsPortCd()).append("]");
											}
											if("Y".equals(tempVO.getNxtRvsExistFlg())) {
												sbReversedPortInfo.append("\n").append(tempVO.getVslCd()).append(tempVO.getSkdVoyNo()).append(tempVO.getSkdDirCd()).append(" : Current date is reversed with VVD/Port [").append(tempVO.getNxtVslCd()) .append(tempVO.getNxtSkdVoyNo()) .append(tempVO.getNxtSkdDirCd()) .append("/").append(tempVO.getNxtVpsPortCd()).append("]");
											}
										}	
//										reversedPortInfos.add(sbReversedPortInfo.toString());
										failCnt++;
									} else {
										okCnt++;
										cstSkdBerthWdoVOList.add(cstSkdBerthWdoVO);
									}
								}
							}
						}
					}
				}
				

				//[사용자가 조회한 후 Data가 변경이 되어 있는 경우 END]
				//================================================================================================================

				// ***************** History START *****************
				List<VslSkdHisInVO> vslSkdHisInVOList 	= makeDataSetByCstSkdBerthWdoHis	(cstSkdBerthWdoVOList, userId);
				vslSkdChgStsGRPVO 						= manageVslSkdChgSts				(vslSkdHisInVOList);
				// ***************** History END *******************

				// ***************** Coastal SKD START *****************
				List<VskVslSkdVO> 	updateList 			= makeDataSetByCstSkdBerthWdo		(cstSkdBerthWdoVOList, userId);
				List<VslPortSkdVO> 	updatePortList 		= makeDataSetByCstPortSkdBerthWdo	(cstSkdBerthWdoVOList, userId);
				// ***************** Coastal SKD END *******************

				if(updateList != null && updateList.size()>0){
					
					dbDao.modifyVskVslSkd		(updateList);
				}

				if(updatePortList != null && updatePortList.size()>0){
					dbDao.modifyVskVslPortSkd	(updatePortList);
				}


				///////////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////////
				/* ============================================================================
				 * Vessel Schedule History 관리(Header+Detail) Started ::2013-07-30::
				 * ----------------------------------------------------------------------------
				 * <TABLE NAME>
				 * 1. VSK_VSL_SKD_CNG_HIS
				 * 2. VSK_VSL_SKD_CNG_HIS_DTL
				 * ----------------------------------------------------------------------------
				 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
				 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
				 * ============================================================================
				 */
				
				List<VskVslSkdVO>	vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
				
				if(updatePortList != null && updatePortList.size() > 0){
					
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByBrthWdo].updatePortList>0 started!!! :: \n");
	
					//List<VslSkdCngHisVO> 	tmpVslSkdCngHisVOs 	= new ArrayList<VslSkdCngHisVO>();
					//tmpVslSkdCngHisVOs							= createVslSkdChangeHistory(updateList, "UPDATE_CST_ByBrthWdo(VOP_VSK_0017)");	
					
					
					String				sVslCd			= null;
					String				sSkdVoyNo		= null;
					String				sSkdDirCd		= null;
					int					iDupKnt			= 0;
					
					for(int k=0; k<updatePortList.size(); k++){
						
						VslPortSkdVO	tmpVO	= new VslPortSkdVO();
						tmpVO					= updatePortList.get(k);
						iDupKnt					= 0;

						sVslCd		= tmpVO.getVslCd	();
						sSkdVoyNo	= tmpVO.getSkdVoyNo	();
						sSkdDirCd	= tmpVO.getSkdDirCd	();
						
						if(k ==0){
							VskVslSkdVO	tmpVO2	= new VskVslSkdVO();
							
							tmpVO2.setVslCd		(sVslCd		);
							tmpVO2.setSkdVoyNo	(sSkdVoyNo	);
							tmpVO2.setSkdDirCd	(sSkdDirCd	);
							
							vskVslSkdVOs.add	(tmpVO2);
						}else{
							
							for(VskVslSkdVO tmpVO3 : vskVslSkdVOs){
								if(sVslCd.equals(tmpVO3.getVslCd()) && sSkdVoyNo.equals(tmpVO3.getSkdVoyNo()) && sSkdDirCd.equals(tmpVO3.getSkdDirCd())){
									iDupKnt++;
								}
							}
							
							if(iDupKnt == 0){
								VskVslSkdVO	tmpVO2	= new VskVslSkdVO();
								
								tmpVO2.setVslCd		(sVslCd		);
								tmpVO2.setSkdVoyNo	(sSkdVoyNo	);
								tmpVO2.setSkdDirCd	(sSkdDirCd	);
								
								vskVslSkdVOs.add	(tmpVO2);
							}
						}
						
					}
					
					//this.createVslSkdChangeHistory(vskVslSkdVOs, null, "UPDATE_CST_ByBrthWdo(VOP_VSK_0017)");	
					
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByBrthWdo].updatePortList>0 finished!!! :: \n");
					
				}else if(updateList != null && updateList.size() > 0){
					
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByBrthWdo].updateList>0 started!!! :: \n");
	
					//List<VslSkdCngHisVO> 	tmpVslSkdCngHisVOs 	= new ArrayList<VslSkdCngHisVO>();
					//tmpVslSkdCngHisVOs							= createVslSkdChangeHistory(updateList, "UPDATE_CST_ByBrthWdo(VOP_VSK_0017)");	
					
					this.createVskVslSkdChangeHistoryMstOnly(updateList, "UPDATE_CST_ByBrthWdo(VOP_VSK_0017)");	
					
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByBrthWdo].updateList>0 finished!!! :: \n");
				}
				
				/* ----------------------------------------------------------------------------
				 * Vessel Schedule History 관리(Header+Detail) Finished ::2013-07-30::
				 * ============================================================================
				 */			
				///////////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////////
				
				
//				********************* 변경된 VVD ERP에 전송 *********************
				List<VvdVO> erpVvdVOs = new ArrayList<VvdVO>();		//변경(I,U,D)된 모든 건
				if(updatePortList != null && updatePortList.size() > 0){
					int voCnt = updatePortList.size();
					for(int i=0; i<voCnt; i++){
						VvdVO vvdVO = new VvdVO();
						vvdVO.setIbflag("U");
						vvdVO.setVslCd(updatePortList.get(i).getVslCd());
						vvdVO.setSkdVoyNo(updatePortList.get(i).getSkdVoyNo());
						vvdVO.setSkdDirCd(updatePortList.get(i).getSkdDirCd());
						vvdVO.setVslSlanCd(updatePortList.get(i).getSlanCd());

						boolean isErpFlg = true;
						if(erpVvdVOs != null && erpVvdVOs.size() > 0){
							for(int j=0; j<erpVvdVOs.size(); j++){
								VvdVO tmpVO = erpVvdVOs.get(j);
								if(tmpVO.getVslCd().equals(vvdVO.getVslCd())
										&& tmpVO.getSkdVoyNo().equals(vvdVO.getSkdVoyNo())
										&& tmpVO.getSkdDirCd().equals(vvdVO.getSkdDirCd())){
									isErpFlg = false;
									break;
								}
							}
						}

						if(isErpFlg){
							erpVvdVOs.add(vvdVO);
						}
					}
				}

				//SC 에서 마지막에 전송하는 것으로 수정(임창빈 - 2009.12.08)
				vslSkdChgStsGRPVO.setErpVvdVOs(erpVvdVOs);

				if(erpVvdVOs != null && erpVvdVOs.size() > 0){
//					[★ Yard Call Ind Seq 일괄 수정]============================================
					dbDao.modifyYardCallSeq(erpVvdVOs);

//					[Booking BDR LOG]============================================
					List<BkgVvdBdrLogVO> bkgVvdLogList = searchBkgBdrLog(erpVvdVOs);
					vslSkdChgStsGRPVO.setBkgVvdBdrLogVOs(bkgVvdLogList);

				}
				vslSkdChgStsGRPVO.setOkCnt(VSKGeneralUtil.getCheckNullToZero(Integer.toString(okCnt)));
				vslSkdChgStsGRPVO.setFailCnt(VSKGeneralUtil.getCheckNullToZero(Integer.toString(failCnt)));
				vslSkdChgStsGRPVO.setFailPortInfos(failPortInfos);
				vslSkdChgStsGRPVO.setReversedPortInfos(reversedPortInfos);

				
				/****************************************************************
				 * 운항스케쥴 이력관리를 위한 VO or VO List Setting ::2013-08-28
				 */
				vslSkdChgStsGRPVO.setVskVslSkdVOs	(vskVslSkdVOs);
				////vslSkdChgStsGRPVO.setUpdateList		(updateList);
				/****************************************************************/
			}
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}

		return vslSkdChgStsGRPVO;
	}

	/**
	 * Daily Berth Window 의 변경사항을 History 남기기 위한 DataSet 을 만든다.
	 *
	 * @param List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs
	 * @param String userId
	 * @return List<VslSkdHisInVO>
	 * @exception EventException
	 */
	private List<VslSkdHisInVO> makeDataSetByCstSkdBerthWdoHis(List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs, String userId) throws EventException{
		List<VslSkdHisInVO> vslSkdHisInVOList = new ArrayList<VslSkdHisInVO>();
		try{
			if(cstSkdBerthWdoVOs != null && cstSkdBerthWdoVOs.size() > 0){
				for(CstSkdBerthWdoVO cstSkdBerthWdoVO : cstSkdBerthWdoVOs) {
					VslSkdHisInVO vslSkdHisInVO = new VslSkdHisInVO();

					vslSkdHisInVO.setIbflag(cstSkdBerthWdoVO.getIbflag());
					vslSkdHisInVO.setSkdCngStsCd(cstSkdBerthWdoVO.getSkdCngStsCd());
					vslSkdHisInVO.setVslCd(cstSkdBerthWdoVO.getVslCd());
					vslSkdHisInVO.setSkdVoyNo(cstSkdBerthWdoVO.getSkdVoyNo());
					vslSkdHisInVO.setSkdDirCd(cstSkdBerthWdoVO.getSkdDirCd());
					vslSkdHisInVO.setVslSlanCd(cstSkdBerthWdoVO.getSlanCd());
					vslSkdHisInVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
					vslSkdHisInVO.setClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());
					vslSkdHisInVO.setYdCd(cstSkdBerthWdoVO.getYdCd());
					vslSkdHisInVO.setVpsEtaDt(cstSkdBerthWdoVO.getVpsEtaDt());
					vslSkdHisInVO.setVpsEtbDt(cstSkdBerthWdoVO.getVpsEtbDt());
					vslSkdHisInVO.setVpsEtdDt(cstSkdBerthWdoVO.getVpsEtdDt());
					vslSkdHisInVO.setVslDlayRsnCd(cstSkdBerthWdoVO.getVslDlayRsnCd());
					vslSkdHisInVO.setVslDlayRsnDesc(cstSkdBerthWdoVO.getVslDlayRsnDesc());
					vslSkdHisInVO.setVslDlayRsnLocCd(cstSkdBerthWdoVO.getVslDlayRsnLocCd());
					vslSkdHisInVO.setUsrId(userId);
					vslSkdHisInVO.setNewClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());

					vslSkdHisInVOList.add(vslSkdHisInVO);

					//Virtual Port History Setting.
					if("Y".equals(cstSkdBerthWdoVO.getTurnPortFlg())){
						VslSkdHisInVO virtualVslSkdHisInVO = new VslSkdHisInVO();

						virtualVslSkdHisInVO.setIbflag("U");
						virtualVslSkdHisInVO.setSkdCngStsCd(cstSkdBerthWdoVO.getSkdCngStsCd());
						virtualVslSkdHisInVO.setVslCd(cstSkdBerthWdoVO.getVslCd());
						virtualVslSkdHisInVO.setSkdVoyNo(cstSkdBerthWdoVO.getTurnSkdVoyNo());
						virtualVslSkdHisInVO.setSkdDirCd(cstSkdBerthWdoVO.getTurnSkdDirCd());
						virtualVslSkdHisInVO.setVslSlanCd(cstSkdBerthWdoVO.getSlanCd());
						virtualVslSkdHisInVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
						virtualVslSkdHisInVO.setClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
						virtualVslSkdHisInVO.setYdCd(cstSkdBerthWdoVO.getYdCd());
						virtualVslSkdHisInVO.setVpsEtaDt(cstSkdBerthWdoVO.getVpsEtaDt());
						virtualVslSkdHisInVO.setVpsEtbDt(cstSkdBerthWdoVO.getVpsEtbDt());
						virtualVslSkdHisInVO.setVpsEtdDt(cstSkdBerthWdoVO.getVpsEtdDt());
						virtualVslSkdHisInVO.setVslDlayRsnCd(cstSkdBerthWdoVO.getVslDlayRsnCd());
						virtualVslSkdHisInVO.setVslDlayRsnDesc(cstSkdBerthWdoVO.getVslDlayRsnDesc());
						virtualVslSkdHisInVO.setVslDlayRsnLocCd(cstSkdBerthWdoVO.getVslDlayRsnLocCd());
						virtualVslSkdHisInVO.setUsrId(userId);
						virtualVslSkdHisInVO.setNewClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());

						vslSkdHisInVOList.add(virtualVslSkdHisInVO);
					}

					//Next Port History Setting.
					if(VSKGeneralUtil.isVirtualPort(cstSkdBerthWdoVO.getTurnPortIndCd())){
						VslSkdHisInVO nxtVslSkdHisInVO = new VslSkdHisInVO();

						nxtVslSkdHisInVO.setIbflag("U");
						nxtVslSkdHisInVO.setSkdCngStsCd(cstSkdBerthWdoVO.getSkdCngStsCd());
						nxtVslSkdHisInVO.setVslCd(cstSkdBerthWdoVO.getVslCd());
						nxtVslSkdHisInVO.setSkdVoyNo(cstSkdBerthWdoVO.getTurnSkdVoyNo());
						nxtVslSkdHisInVO.setSkdDirCd(cstSkdBerthWdoVO.getTurnSkdDirCd());
						nxtVslSkdHisInVO.setVslSlanCd(cstSkdBerthWdoVO.getSlanCd());
						nxtVslSkdHisInVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
						nxtVslSkdHisInVO.setClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
						nxtVslSkdHisInVO.setYdCd(cstSkdBerthWdoVO.getYdCd());
						nxtVslSkdHisInVO.setVpsEtaDt(cstSkdBerthWdoVO.getVpsEtaDt());
						nxtVslSkdHisInVO.setVpsEtbDt(cstSkdBerthWdoVO.getVpsEtbDt());
						nxtVslSkdHisInVO.setVpsEtdDt(cstSkdBerthWdoVO.getVpsEtdDt());
						nxtVslSkdHisInVO.setVslDlayRsnCd(cstSkdBerthWdoVO.getVslDlayRsnCd());
						nxtVslSkdHisInVO.setVslDlayRsnDesc(cstSkdBerthWdoVO.getVslDlayRsnDesc());
						nxtVslSkdHisInVO.setVslDlayRsnLocCd(cstSkdBerthWdoVO.getVslDlayRsnLocCd());
						nxtVslSkdHisInVO.setUsrId(userId);
						nxtVslSkdHisInVO.setNewClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());

						vslSkdHisInVOList.add(nxtVslSkdHisInVO);
					}
				} // end for
			}
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}

		return vslSkdHisInVOList;
	}

	/**
	 * Daily Berth Window 의 변경사항을 저장하기위한 Coastal Schedule DataSet 을 만든다.
	 *
	 * @param List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	private List<VskVslSkdVO> makeDataSetByCstSkdBerthWdo(List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs, String userId) throws EventException{
		List<VskVslSkdVO> vskVslSkdVOList = new ArrayList<VskVslSkdVO>();
		try{
			if(cstSkdBerthWdoVOs != null && cstSkdBerthWdoVOs.size() > 0){
				for(CstSkdBerthWdoVO cstSkdBerthWdoVO : cstSkdBerthWdoVOs){
					VskVslPortSkdVO chkParamVO = new VskVslPortSkdVO();

					String vslCd 	= cstSkdBerthWdoVO.getVslCd();
					String skdVoyNo = cstSkdBerthWdoVO.getSkdVoyNo();
					String skdDirCd = cstSkdBerthWdoVO.getSkdDirCd();

					chkParamVO.setVslCd		(vslCd);
					chkParamVO.setSkdVoyNo	(skdVoyNo);
					chkParamVO.setSkdDirCd	(skdDirCd);
					chkParamVO.setVpsPortCd	(cstSkdBerthWdoVO.getVpsPortCd());
					chkParamVO.setClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());

					if("Y".equals(dbDao.checkFirstCallingPort(chkParamVO))){
						VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();

						vskVslSkdVO.setVslCd			(vslCd);
						vskVslSkdVO.setSkdVoyNo			(skdVoyNo);
						vskVslSkdVO.setSkdDirCd			(skdDirCd);
						vskVslSkdVO.setN1stPortBrthDt	(cstSkdBerthWdoVO.getVpsEtbDt());
						vskVslSkdVO.setUpdUsrId			(userId);

						vskVslSkdVOList.add				(vskVslSkdVO);
					}
				}//end for
			}
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		return vskVslSkdVOList;
	}

	/**
	 * Daily Berth Window 의 변경사항을 저장하기위한 Coastal Schedule DataSet 을 만든다.
	 *
	 * @param List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	private List<VslPortSkdVO> makeDataSetByCstPortSkdBerthWdo(List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs, String userId) throws EventException{
		List<VslPortSkdVO> vslPortSkdVOList = new ArrayList<VslPortSkdVO>();

		try{
			if(cstSkdBerthWdoVOs != null && cstSkdBerthWdoVOs.size() > 0){
				for(CstSkdBerthWdoVO cstSkdBerthWdoVO : cstSkdBerthWdoVOs){
					String vslCd = cstSkdBerthWdoVO.getVslCd();
					String skdVoyNo = cstSkdBerthWdoVO.getSkdVoyNo();
					String skdDirCd = cstSkdBerthWdoVO.getSkdDirCd();

					VslPortSkdVO vslPortSkdVO = new VslPortSkdVO();
					vslPortSkdVO.setVslCd(vslCd);
					vslPortSkdVO.setSkdVoyNo(skdVoyNo);
					vslPortSkdVO.setSkdDirCd(skdDirCd);
					vslPortSkdVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
					vslPortSkdVO.setClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());
					vslPortSkdVO.setNewClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());
					vslPortSkdVO.setClptSeq(cstSkdBerthWdoVO.getClptSeq());
					vslPortSkdVO.setUpdUsrId(userId);
					vslPortSkdVO.setYdCd(cstSkdBerthWdoVO.getYdCd());
					vslPortSkdVO.setCallYdIndSeq(cstSkdBerthWdoVO.getCallYdIndSeq());	//(★ 해당 데이타 처리 후 Yard Call Ind Seq 일괄 수정 처리하기로 함.)
					vslPortSkdVO.setVpsEtaDt(cstSkdBerthWdoVO.getVpsEtaDt());
					vslPortSkdVO.setVpsEtbDt(cstSkdBerthWdoVO.getVpsEtbDt());
					vslPortSkdVO.setVpsEtdDt(cstSkdBerthWdoVO.getVpsEtdDt());
					vslPortSkdVO.setSkdBrthNo(cstSkdBerthWdoVO.getSkdBrthNo());
					vslPortSkdVO.setIbCgoQty(cstSkdBerthWdoVO.getIbCgoQty());
					vslPortSkdVO.setObCgoQty(cstSkdBerthWdoVO.getObCgoQty());
					vslPortSkdVO.setFtDt(cstSkdBerthWdoVO.getFreeTmDt());
					vslPortSkdVO.setTmlVslCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getTmlVslCd(), " "));
					vslPortSkdVO.setTmlVoyNo(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getTmlVoyNo(), " "));
					vslPortSkdVO.setTurnSkdVoyNo(cstSkdBerthWdoVO.getTurnSkdVoyNo());
					vslPortSkdVO.setTurnSkdDirCd(cstSkdBerthWdoVO.getTurnSkdDirCd());
					vslPortSkdVO.setTurnClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
					vslPortSkdVO.setVslDlayRsnCd(cstSkdBerthWdoVO.getVslDlayRsnCd());
					vslPortSkdVO.setVslDlayRsnDesc(cstSkdBerthWdoVO.getVslDlayRsnDesc());
					vslPortSkdVO.setVslDlayRsnLocCd(cstSkdBerthWdoVO.getVslDlayRsnLocCd());
					vslPortSkdVO.setSlanCd(cstSkdBerthWdoVO.getSlanCd());
					vslPortSkdVO.setVpsRmk(cstSkdBerthWdoVO.getVpsRmk());
					vslPortSkdVO.setPlismYdCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismYdCd(), " "));
					vslPortSkdVO.setPlismVslCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismVslCd(), " "));
					vslPortSkdVO.setPlismVoyNo(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismVoyNo(), " "));

					vslPortSkdVOList.add(vslPortSkdVO);

		//			================= [ VIRTUAL PORT ] START ==============================================
					if("Y".equals(cstSkdBerthWdoVO.getTurnPortFlg())){
						//Turnnig 정보를 조회한다.
						VskVslPortSkdVO virtualPortParamVO = new VskVslPortSkdVO();
						virtualPortParamVO.setVslCd(vslCd);
						virtualPortParamVO.setSkdVoyNo(cstSkdBerthWdoVO.getTurnSkdVoyNo());
						virtualPortParamVO.setSkdDirCd(cstSkdBerthWdoVO.getTurnSkdDirCd());
						List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(virtualPortParamVO);

						String virtualSlanCd = cstSkdBerthWdoVO.getSlanCd();
						if(virtualPortVoList != null && virtualPortVoList.size() > 0){
							virtualSlanCd = virtualPortVoList.get(0).getSlanCd();
						}

						VslPortSkdVO virtualPortSkdVO = new VslPortSkdVO();
						virtualPortSkdVO.setVslCd(vslCd);
						virtualPortSkdVO.setSkdVoyNo(cstSkdBerthWdoVO.getTurnSkdVoyNo());
						virtualPortSkdVO.setSkdDirCd(cstSkdBerthWdoVO.getTurnSkdDirCd());
						virtualPortSkdVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
						virtualPortSkdVO.setClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
						virtualPortSkdVO.setNewClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
						virtualPortSkdVO.setUpdUsrId(userId);
						virtualPortSkdVO.setYdCd(cstSkdBerthWdoVO.getYdCd());
						virtualPortSkdVO.setCallYdIndSeq("1");				//(★ 해당 데이타 처리 후 Yard Call Ind Seq 일괄 수정 처리하기로 함.)
						virtualPortSkdVO.setVpsEtaDt(cstSkdBerthWdoVO.getVpsEtaDt());
						virtualPortSkdVO.setVpsEtbDt(cstSkdBerthWdoVO.getVpsEtbDt());
						virtualPortSkdVO.setVpsEtdDt(cstSkdBerthWdoVO.getVpsEtdDt());
						virtualPortSkdVO.setSkdBrthNo(cstSkdBerthWdoVO.getSkdBrthNo());
						virtualPortSkdVO.setIbCgoQty(cstSkdBerthWdoVO.getIbCgoQty());
						virtualPortSkdVO.setObCgoQty(cstSkdBerthWdoVO.getObCgoQty());
						virtualPortSkdVO.setFtDt(cstSkdBerthWdoVO.getFreeTmDt());
						virtualPortSkdVO.setTmlVslCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getTmlVslCd(), " "));
						virtualPortSkdVO.setTmlVoyNo(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getTmlVoyNo(), " "));
						virtualPortSkdVO.setTurnSkdVoyNo(skdVoyNo);
						virtualPortSkdVO.setTurnSkdDirCd(skdDirCd);
						virtualPortSkdVO.setTurnClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());
						virtualPortSkdVO.setSlanCd(virtualSlanCd);
						virtualPortSkdVO.setVpsRmk(cstSkdBerthWdoVO.getVpsRmk());
						virtualPortSkdVO.setPlismYdCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismYdCd(), " "));
						virtualPortSkdVO.setPlismVslCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismVslCd(), " "));
						virtualPortSkdVO.setPlismVoyNo(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismVoyNo(), " "));

						vslPortSkdVOList.add(virtualPortSkdVO);
					}
//					================= [ VIRTUAL PORT ] END ==============================================
				}//end for
			}
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		return vslPortSkdVOList;
	}

	/**
	 * KTNET EAI 전송합니다.<br>
	 *
	 * @param CstSkdBerthWdoVO[] cstSkdBerthWdoVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String sendEdiToKlNet(CstSkdBerthWdoVO[] cstSkdBerthWdoVOs, SignOnUserAccount account) throws EventException{
		//String reStrEdi = "";
		StringBuilder 						reStrEdi 	= new StringBuilder();
		String 								queueName 	= SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.QUEUE");
		List<BkgCllCngNtfyUserLaneInfoVO> 	list 		= null;
		
		/**************************************************************
		 * EDI F/F DEFINITION TO KTNET
		 * ------------------------------------------------------------
		 * KR*
		 * -------------[20]                [20]                [10]---
		 * 	> HEADER :: SMLMM010             KTNETPCS            IFTSAI
		 * ------------------------------------------------------------
		 * KRPUS-HN
		 * 	> HEADER :: SML                 HJNPC010            IFTSAI
		 * ------------------------------------------------------------
		 **************************************************************/
		
		try {
			
			if(cstSkdBerthWdoVOs != null && cstSkdBerthWdoVOs.length > 0)
			{
				for(CstSkdBerthWdoVO cstSkdBerthWdoVO : cstSkdBerthWdoVOs)
				{
					
					//한국지역(KR)인 경우
					if("KR".equals(cstSkdBerthWdoVO.getVpsPortCd().substring(0, 2)))
					{
						String flatFile 	= "";
						//전문 SEQ 조회
						String headerSeq 	= dbDao.searchEdiHdSeqToKlnet();
						//log 저장
						// KTNET => 부산 ,KRPUSHN =>부산 신항
						cstSkdBerthWdoVO.setPortPos		("KTNET"		);	//HJSALPSA.VSK_CUST_EDI_LOG.CUST_TRD_PRNR_ID//
						cstSkdBerthWdoVO.setHeaderSeq	(headerSeq		);
						
						/**************************************************************
						 * LANE 담당자 정보 추출
						 * ------------------------------------------------------------
						 * Source : Booking/Documentation > Setup > User SMS Creation
						 * ------------------------------------------------------------
						 * (User Name, Office Phone No, Fax No, E-Mail)
						 * TABLE  : BKG_CLL_CNG_NTFY_SET 
						 * ------------------------------------------------------------
						 **************************************************************/
						
						String	sUserId		= null;
						String	sUserNm		= null;
						String	sUserEml	= null;
						String	sOfcPhnNo	= null;
						String	sOfcFaxNo	= null;
	
						list	= dbDao.searchBkgCllCngNtfyUserLaneInfo(cstSkdBerthWdoVO.getSlanCd(), cstSkdBerthWdoVO.getSkdDirCd(), cstSkdBerthWdoVO.getVpsPortCd());
						if(!list.isEmpty()){
							
							BkgCllCngNtfyUserLaneInfoVO bkgCllCngNtfyUserLaneInfoVO	= new BkgCllCngNtfyUserLaneInfoVO();
							bkgCllCngNtfyUserLaneInfoVO								= list.get(0);
							
							sUserId		= bkgCllCngNtfyUserLaneInfoVO.getRcvrUsrId();
							sUserNm		= bkgCllCngNtfyUserLaneInfoVO.getUsrNm();
							sUserEml	= bkgCllCngNtfyUserLaneInfoVO.getRcvrEml();
							sOfcPhnNo	= bkgCllCngNtfyUserLaneInfoVO.getOfcPhnNo();
							sOfcFaxNo	= bkgCllCngNtfyUserLaneInfoVO.getOfcFaxNo();
						
						}else{
							
/*							sUserId		= account.getUsr_id		();
							sUserNm		= account.getUsr_nm		();
							sUserEml	= account.getUsr_eml	();
							sOfcPhnNo	= account.getXtn_phn_no	();
							sOfcFaxNo	= account.getFax_no		();	*/	
							
							//::Lane info 미존재하는 경우 빈값으로 세팅처리:://
							sUserId		= "";
							sUserNm		= "";
							sUserEml	= "";
							sOfcPhnNo	= "";
							sOfcFaxNo	= "";									
						}
						
						// Session 정보 Setting.
						cstSkdBerthWdoVO.setUsrId		(sUserId	);
						cstSkdBerthWdoVO.setUsrNm		(sUserNm	);
						cstSkdBerthWdoVO.setUsrEml		(sUserEml	);
						cstSkdBerthWdoVO.setMphnNo		(sOfcPhnNo	);
						cstSkdBerthWdoVO.setFaxNo		(sOfcFaxNo	);

						log.info("\n\n ::VesselScheduleMgtBCImpl.sendEdiToKlNet ");
						log.info("\n\n ::VesselScheduleMgtBCImpl:: sUserId 		["+sUserId+"]");
						log.info("\n\n ::VesselScheduleMgtBCImpl:: sUserNm 		["+sUserNm+"]");
						log.info("\n\n ::VesselScheduleMgtBCImpl:: sUserEml 	["+sUserEml+"]");
						log.info("\n\n ::VesselScheduleMgtBCImpl:: sOfcPhnNo 	["+sOfcPhnNo+"]");
						log.info("\n\n ::VesselScheduleMgtBCImpl:: sOfcFaxNo 	["+sOfcFaxNo+"]");
						

						/**************************************************************
						 * EDI FLAT FILE 생성 ["KR" ONLY including "KRPUSHN"]
						 * ------------------------------------------------------------
						 * EDI F/F HEADER GENERATION.
						 * EDI F/F BODY   GENERATION.
						 **************************************************************/
						String header 	= dbDao.searchEdiHdToKlnet	(headerSeq			);
						String message 	= dbDao.searchEdiMsgToKlnet	(cstSkdBerthWdoVO	);
						cstSkdBerthWdoVO.setDiffRmk(header+"\n"+message);

						flatFile 		= header+"\n"+message;

						//EDI 전송
						reStrEdi.append	(sendEdiVslSkdCstSkdBerthWdo(queueName, flatFile));
						//2009 12 09 임창빈 수석 요청

						dbDao.addVskCustEdiLogToKlnet			(cstSkdBerthWdoVO, account	);

						dbDao.modifyVskVslPortSkdSendEdiCount	(cstSkdBerthWdoVO			);

						
						//신항일 경우 YD_CD가 KRPUSHN 일 경우 =================================================================
						if("KRPUSHN".equals(cstSkdBerthWdoVO.getYdCd()))
						{
							
							/**************************************************************
							 * EDI FLAT FILE 생성 ["KRPUS"+"HN"]
							 * ------------------------------------------------------------
							 * EDI F/F HEADER GENERATION.
							 * EDI F/F BODY   GENERATION.
							 **************************************************************/
							String krpushn_header 	= dbDao.searchEdiHdToKRPUSHN(headerSeq);
							String krpushn_flatFile = krpushn_header+"\n"+message;

							//EDI 전송
							reStrEdi.append(":").append(sendEdiVslSkdCstSkdBerthWdo(queueName, krpushn_flatFile));

							// KTNET => 부산 ,KRPUSHN =>부산 신항
							cstSkdBerthWdoVO.setPortPos			("KRPUSHN"					);	//HJSALPSA.VSK_CUST_EDI_LOG.CUST_TRD_PRNR_ID//
							cstSkdBerthWdoVO.setDiffRmk			(krpushn_flatFile			);
							
							dbDao.addVskCustEdiLogToKlnet		(cstSkdBerthWdoVO, account	);
						}	//END OF 2ND INNER IF.
						//신항일 경우 YD_CD가 KRPUSHN 일 경우 =================================================================
					
						
						//END OF 1ST INNER IF. ["KR" ONLY]
					}else{
					
					/* ===============================================
					 * Adding EDI Send Function except "KOREA"
					 * -----------------------------------------------
					 * 2014.01.24 by COL
					 * from Message "UAX/Klaus Backeberg"
					 * sender id   = “SMLINE”
					 * receiver id = terminal code (V7)
					 * ===============================================
					 */
						
						log.info("\n\n ::VesselScheduleMgtBCImpl:: EUR ONLY TEST STARTING");
						
						String sCntCd	= cstSkdBerthWdoVO.getYdCd() == null ? "" : cstSkdBerthWdoVO.getYdCd().substring(0, 2);
						boolean	isEur	= dbDao.isCheckContiForCountry("E", sCntCd);
						
						log.info("\n\n ::VesselScheduleMgtBCImpl:: EUR ONLY TEST STARTING isEur ["+isEur+']');
						
						if(isEur){
							
							String flatFile 	= "";
							//전문 SEQ 조회
							String headerSeq 	= dbDao.searchEdiHdSeqToOtherCoutryExceptKr("VSK");
							String sTmlCd		= cstSkdBerthWdoVO.getYdCd();
							//log 저장
							
							cstSkdBerthWdoVO.setPortPos		(sTmlCd		);	//HJSALPSA.VSK_CUST_EDI_LOG.CUST_TRD_PRNR_ID//
							cstSkdBerthWdoVO.setHeaderSeq	(headerSeq	);
							
							/**************************************************************
							 * SenderId, ReceiverId Setting
							 * ------------------------------------------------------------
							 * TERMINAL CODE :: BEANRY2
							 * sender id   = “SMLINE” + receiver id = “131208”
							 * ------------------------------------------------------------
							 **************************************************************/
							
							String sSenderId	= "SMLINE"	;
							String sReceiverId	= sTmlCd	;
							
							/**************************************************************
							 * EDI FLAT FILE 생성 ["KR" ONLY including "KRPUSHN"]
							 * ------------------------------------------------------------
							 * EDI F/F HEADER GENERATION.
							 * EDI F/F BODY   GENERATION.
							 **************************************************************/
							String header 	= dbDao.searchEdiHdToExceptKor	(sSenderId, sReceiverId, headerSeq);
							String message 	= dbDao.searchEdiMsgToEUROnly	(cstSkdBerthWdoVO	);
							cstSkdBerthWdoVO.setDiffRmk(header+"\n"+message);

							flatFile 		= header+"\n"+message;
							
							log.info("\n\n ::VesselScheduleMgtBCImpl:: EDI SEND TEST STARTING]");
							log.info("\n\n ::VesselScheduleMgtBCImpl:: flatFile 	["+flatFile+"]");	
							log.info("\n\n ::VesselScheduleMgtBCImpl:: EDI SEND TEST FINISHED]");
							
							//EDI 전송
							reStrEdi.append	(sendEdiVslSkdCstSkdBerthWdo(queueName, flatFile));
							//2009 12 09 임창빈 수석 요청

							dbDao.addVskCustEdiLogToKlnet			(cstSkdBerthWdoVO, account	);

							dbDao.modifyVskVslPortSkdSendEdiCount	(cstSkdBerthWdoVO			);
							
						}

					}		//END OF 1ST INNER IF. ["KR" ONLY >> "KR"+"All Other Country"]
					
				}			//END OF FOR.
				
			}				//END OF IF.
			

			return "SUCCESS";
			
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}

	/**
	 * EDI 통신
	 *
	 * @param String queueName
	 * @param String flatFile
	 * @return String
	 * @exception EventException
	 */
	private String sendEdiVslSkdCstSkdBerthWdo(String queueName, String flatFile) throws EventException {
		try {
			return eaiDao.sendEdiVslSkdCstSkdBerthWdo(queueName, flatFile);
		}catch(DAOException e){
			log.error("err " + e.toString(), e);
			// VSK10053 : EDI 전송시 에러 발생(An unknown error has occurred while transmitting EDI MQ. (To KL-Net & KRPUSHN))
			throw new EventException(new ErrorHandler("VSK10053").getMessage(), e);
		}
	}

	/**
	 * Coastal SKD Simulation(Recovery Plan)을 관리합니다.<br>
	 *
	 * @param SwapCstSkdSimVO[] swapCstSkdSimVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageCstSkdSim(SwapCstSkdSimVO[] swapCstSkdSimVOs, SignOnUserAccount account) throws EventException {
		String simCode = "";
		try {
			if(swapCstSkdSimVOs != null){
				List<VskSwapCstSimVO> saveVskSwapCstSimVOList = new ArrayList<VskSwapCstSimVO>();
				List<VskSwapCstVvdVO> saveVskSwapCstVvdVOList = new ArrayList<VskSwapCstVvdVO>();
				List<VskSwapCstPortVO> saveVskSwapCstPortVOList = new ArrayList<VskSwapCstPortVO>();

				VskSwapCstSimVO vskSwapCstSimVO = new VskSwapCstSimVO();

				if(swapCstSkdSimVOs != null && swapCstSkdSimVOs.length > 0){

					String simDt = "";
					String simNo = "";

					if("I".equals(swapCstSkdSimVOs[0].getIbflag())){
						vskSwapCstSimVO = dbDao.searchSimNo();

						simDt = vskSwapCstSimVO.getSimDt();
						simNo = vskSwapCstSimVO.getSimNo();

						simCode = simDt + ":" + simNo;
					}else{
						simDt = VSKGeneralUtil.replaceDateTypeToString(swapCstSkdSimVOs[0].getSimDt());
						simNo = swapCstSkdSimVOs[0].getSimNo();

						vskSwapCstSimVO.setSimDt(simDt);
						vskSwapCstSimVO.setSimNo(simNo);
					}

					/* ====================================================== */
					vskSwapCstSimVO.setVslSimTpCd(swapCstSkdSimVOs[0].getVslSimTpCd());
					vskSwapCstSimVO.setDiffRmk(swapCstSkdSimVOs[0].getDiffRmk());
					vskSwapCstSimVO.setCreDt(account.getCre_dt());
					vskSwapCstSimVO.setCreUsrId(account.getUsr_id());
					vskSwapCstSimVO.setUpdUsrId(account.getUsr_id());

					saveVskSwapCstSimVOList.add(vskSwapCstSimVO);
					/* ====================================================== */

					int voCnt = swapCstSkdSimVOs.length;
					String vvdCd = "";
					String newVvdCd = "";
					String ydCd = "";

					for(int i=0; i<voCnt; i++){
						vvdCd = swapCstSkdSimVOs[i].getVslCd()
								+ swapCstSkdSimVOs[i].getSkdVoyNo()
								+ swapCstSkdSimVOs[i].getSkdDirCd();
						/* ====================================================== */
						if(!vvdCd.equals(newVvdCd)){
							VskSwapCstVvdVO vskSwapCstVvdVO = new VskSwapCstVvdVO();

							vskSwapCstVvdVO.setSimDt(simDt);
							vskSwapCstVvdVO.setSimNo(simNo);
							vskSwapCstVvdVO.setVslCd(swapCstSkdSimVOs[i].getVslCd());
							vskSwapCstVvdVO.setSkdVoyNo(swapCstSkdSimVOs[i].getSkdVoyNo());
							vskSwapCstVvdVO.setSkdDirCd(swapCstSkdSimVOs[i].getSkdDirCd());
							vskSwapCstVvdVO.setSlanCd(swapCstSkdSimVOs[i].getVslSlanCd());
							vskSwapCstVvdVO.setSkdStsCd(swapCstSkdSimVOs[i].getPortSkdStsCd());
							vskSwapCstVvdVO.setSkdVoyTpCd(swapCstSkdSimVOs[i].getSkdVoyTpCd());
							vskSwapCstVvdVO.setSkdUsdIndCd(swapCstSkdSimVOs[i].getSkdUsdIndCd());
							vskSwapCstVvdVO.setPfSkdTpCd(swapCstSkdSimVOs[i].getPfSkdTpCd());
							vskSwapCstVvdVO.setStPortCd(swapCstSkdSimVOs[i].getVpsPortCd());
							vskSwapCstVvdVO.setN1stPortBrthDt(swapCstSkdSimVOs[i].getVpsEtbDt());
							vskSwapCstVvdVO.setPsdoVvdCd(swapCstSkdSimVOs[i].getPsdoVvdCd());
							vskSwapCstVvdVO.setCoCd(swapCstSkdSimVOs[i].getCoCd());
							vskSwapCstVvdVO.setSkdRmk(swapCstSkdSimVOs[i].getSkdRmk());
							vskSwapCstVvdVO.setDiffRmk(swapCstSkdSimVOs[i].getDiffRmk());
							vskSwapCstVvdVO.setCreDt(swapCstSkdSimVOs[i].getCreDt());
							vskSwapCstVvdVO.setCreUsrId(account.getUsr_id());
							vskSwapCstVvdVO.setUpdUsrId(account.getUsr_id());

							saveVskSwapCstVvdVOList.add(vskSwapCstVvdVO);

							newVvdCd = vvdCd;
						}
						/* ====================================================== */
						ydCd = swapCstSkdSimVOs[i].getVpsPortCd() + swapCstSkdSimVOs[i].getTmlCd();
						if(!"D".equals(swapCstSkdSimVOs[i].getIbflag())){
							VskSwapCstPortVO vskSwapCstPortVO = new VskSwapCstPortVO();

							vskSwapCstPortVO.setSimDt(simDt);
							vskSwapCstPortVO.setSimNo(simNo);
							vskSwapCstPortVO.setVslCd(swapCstSkdSimVOs[i].getVslCd());
							vskSwapCstPortVO.setSkdVoyNo(swapCstSkdSimVOs[i].getSkdVoyNo());
							vskSwapCstPortVO.setSkdDirCd(swapCstSkdSimVOs[i].getSkdDirCd());
							vskSwapCstPortVO.setVpsPortCd(swapCstSkdSimVOs[i].getVpsPortCd());
							vskSwapCstPortVO.setClptIndSeq(swapCstSkdSimVOs[i].getNewClptIndSeq());
							vskSwapCstPortVO.setClptSeq(swapCstSkdSimVOs[i].getClptSeq());
							vskSwapCstPortVO.setSlanCd(swapCstSkdSimVOs[i].getVslSlanCd());
							vskSwapCstPortVO.setPortSkdStsCd(swapCstSkdSimVOs[i].getPortSkdStsCd());
							vskSwapCstPortVO.setYdCd(ydCd);
							vskSwapCstPortVO.setCallYdIndSeq(swapCstSkdSimVOs[i].getCallYdIndSeq());
							vskSwapCstPortVO.setPfEtaDt(swapCstSkdSimVOs[i].getPfEtaDt());
							vskSwapCstPortVO.setPfEtbDt(swapCstSkdSimVOs[i].getPfEtbDt());
							vskSwapCstPortVO.setPfEtdDt(swapCstSkdSimVOs[i].getPfEtdDt());
							vskSwapCstPortVO.setInitEtaDt(swapCstSkdSimVOs[i].getInitEtaDt());
							vskSwapCstPortVO.setInitEtbDt(swapCstSkdSimVOs[i].getInitEtbDt());
							vskSwapCstPortVO.setInitEtdDt(swapCstSkdSimVOs[i].getInitEtdDt());
							vskSwapCstPortVO.setVpsEtaDt(swapCstSkdSimVOs[i].getVpsEtaDt());
							vskSwapCstPortVO.setVpsEtbDt(swapCstSkdSimVOs[i].getVpsEtbDt());
							vskSwapCstPortVO.setVpsEtdDt(swapCstSkdSimVOs[i].getVpsEtdDt());
							vskSwapCstPortVO.setVslDlayRsnCd(swapCstSkdSimVOs[i].getVslDlayRsnCd());
							vskSwapCstPortVO.setVslDlayRsnDesc(swapCstSkdSimVOs[i].getVslDlayRsnDesc());
							vskSwapCstPortVO.setVpsLocCd(swapCstSkdSimVOs[i].getVslDlayRsnLocCd());
							vskSwapCstPortVO.setShpCallNo(swapCstSkdSimVOs[i].getShpCallNo());
							vskSwapCstPortVO.setShpCallNoUpdUsrId(swapCstSkdSimVOs[i].getShpCallNoUpdUsrId());
							vskSwapCstPortVO.setShpCallNoUpdDt(swapCstSkdSimVOs[i].getShpCallNoUpdDt());
							vskSwapCstPortVO.setTmlVslCd(swapCstSkdSimVOs[i].getTmlVslCd());
							vskSwapCstPortVO.setTmlVoyNo(swapCstSkdSimVOs[i].getTmlVoyNo());
							vskSwapCstPortVO.setFtDt(swapCstSkdSimVOs[i].getFtDt());
							vskSwapCstPortVO.setPlismYdCd(swapCstSkdSimVOs[i].getPlismYdCd());
							vskSwapCstPortVO.setPlismVslCd(swapCstSkdSimVOs[i].getPlismVslCd());
							vskSwapCstPortVO.setPlismVoyNo(swapCstSkdSimVOs[i].getPlismVoyNo());
							vskSwapCstPortVO.setSkdCngStsCd(swapCstSkdSimVOs[i].getSkdCngStsCd());
							vskSwapCstPortVO.setTurnPortFlg(swapCstSkdSimVOs[i].getTurnPortFlg());
							vskSwapCstPortVO.setTurnPortIndCd(swapCstSkdSimVOs[i].getTurnPortIndCd());
							vskSwapCstPortVO.setTurnSkdVoyNo(swapCstSkdSimVOs[i].getTurnSkdVoyNo());
							vskSwapCstPortVO.setTurnSkdDirCd(swapCstSkdSimVOs[i].getTurnSkdDirCd());
							vskSwapCstPortVO.setTurnClptIndSeq(swapCstSkdSimVOs[i].getTurnClptIndSeq());
							vskSwapCstPortVO.setIbCgoQty(swapCstSkdSimVOs[i].getIbCgoQty());
							vskSwapCstPortVO.setObCgoQty(swapCstSkdSimVOs[i].getObCgoQty());
							vskSwapCstPortVO.setVpsRmk(swapCstSkdSimVOs[i].getVpsRmk());
							vskSwapCstPortVO.setPhsIoRsnCd(swapCstSkdSimVOs[i].getPhsIoRsnCd());
							vskSwapCstPortVO.setPhsIoRmk(swapCstSkdSimVOs[i].getPhsIoRmk());
							vskSwapCstPortVO.setSkdBrthNo(swapCstSkdSimVOs[i].getSkdBrthNo());
							vskSwapCstPortVO.setInitSkdInpFlg(swapCstSkdSimVOs[i].getInitSkdInpFlg());
							vskSwapCstPortVO.setOfcInpFlg(swapCstSkdSimVOs[i].getOfcInpFlg());
							vskSwapCstPortVO.setNoonRptInpFlg(swapCstSkdSimVOs[i].getNoonRptInpFlg());
							vskSwapCstPortVO.setDepRptInpFlg(swapCstSkdSimVOs[i].getDepRptInpFlg());
							vskSwapCstPortVO.setActInpFlg(swapCstSkdSimVOs[i].getActInpFlg());
							vskSwapCstPortVO.setPrtChkFlg(swapCstSkdSimVOs[i].getPrtChkFlg());
							vskSwapCstPortVO.setLnkDist(swapCstSkdSimVOs[i].getLnkDist());
							vskSwapCstPortVO.setLnkSpd(swapCstSkdSimVOs[i].getLnkSpd());
							vskSwapCstPortVO.setTztmHrs(swapCstSkdSimVOs[i].getTztmHrs());
							vskSwapCstPortVO.setTdHrs(swapCstSkdSimVOs[i].getTimeDiff());
							vskSwapCstPortVO.setMnvrInHrs(swapCstSkdSimVOs[i].getMnvrInHrs());
							vskSwapCstPortVO.setMnvrOutHrs(swapCstSkdSimVOs[i].getMnvrOutHrs());
							vskSwapCstPortVO.setTmlProdQty(swapCstSkdSimVOs[i].getTmlProdQty());
							vskSwapCstPortVO.setCrnKnt(swapCstSkdSimVOs[i].getCrnKnt());
							vskSwapCstPortVO.setPortWrkHrs(swapCstSkdSimVOs[i].getActWrkHrs());
							vskSwapCstPortVO.setSeaBufHrs(swapCstSkdSimVOs[i].getSeaBufHrs());
							vskSwapCstPortVO.setPortBufHrs(swapCstSkdSimVOs[i].getPortBufHrs());
							vskSwapCstPortVO.setAddBnkCsmQty(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getAddBnkCsmQty()));
							vskSwapCstPortVO.setAddBnkCostAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getAddBnkCostAmt()));
							vskSwapCstPortVO.setTs20ftTtlQty(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTs20ftTtlQty()));	/* 화면에서 제거됨(사용안함) */
							vskSwapCstPortVO.setTs40ftTtlQty(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTs40ftTtlQty()));	/* 화면에서 제거됨(사용안함) */
							vskSwapCstPortVO.setTs20ftTtlAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTs20ftTtlAmt()));	/* 화면에서 제거됨(사용안함) */
							vskSwapCstPortVO.setTs40ftTtlAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTs40ftTtlAmt()));	/* 화면에서 제거됨(사용안함) */
							vskSwapCstPortVO.setTmlHndl20ftTtlQty(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTmlHndl20ftTtlQty()));
							vskSwapCstPortVO.setTmlHndl40ftTtlQty(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTmlHndl40ftTtlQty()));
							vskSwapCstPortVO.setTmlHndl20ftTtlAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTmlHndl20ftTtlAmt()));
							vskSwapCstPortVO.setTmlHndl40ftTtlAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTmlHndl40ftTtlAmt()));
							vskSwapCstPortVO.setPeUsdTtlAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getPeUsdTtlAmt()));
							vskSwapCstPortVO.setUsrHdnFlg(swapCstSkdSimVOs[i].getUsrHdnFlg());
							vskSwapCstPortVO.setCreDt(swapCstSkdSimVOs[i].getCreDt());
							vskSwapCstPortVO.setCreUsrId(account.getUsr_id());
							vskSwapCstPortVO.setUpdDt(swapCstSkdSimVOs[i].getUpdDt());
							vskSwapCstPortVO.setUpdUsrId(account.getUsr_id());
							// Skip Info...
							vskSwapCstPortVO.setTtlDlayHrs(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTtlDlayHrs()));
							vskSwapCstPortVO.setPortSkpRsnOffrRmk(swapCstSkdSimVOs[i].getPortSkpRsnOffrRmk());
							vskSwapCstPortVO.setPortSkpTpCd(swapCstSkdSimVOs[i].getPortSkpTpCd());
							vskSwapCstPortVO.setPortSkpRsnCd(swapCstSkdSimVOs[i].getPortSkpRsnCd());
							vskSwapCstPortVO.setTsPortCd(swapCstSkdSimVOs[i].getTsPortCd());
							vskSwapCstPortVO.setUsdFlg(VSKGeneralUtil.getCheckNotToString(swapCstSkdSimVOs[i].getUsdFlg()));
							vskSwapCstPortVO.setAutoSkdCngFlg(swapCstSkdSimVOs[i].getAutoSkdCngFlg());

							saveVskSwapCstPortVOList.add(vskSwapCstPortVO);
						}
					}// end for

					//ibflag == "U"이면 해당 DATA Delete 후 새로 저장.
					if("U".equals(swapCstSkdSimVOs[0].getIbflag())){
						dbDao.removeVskSwapCstPort(saveVskSwapCstPortVOList.get(0));
						dbDao.removeVskSwapCstVvd(saveVskSwapCstVvdVOList.get(0));

						dbDao.modifyVskSwapCstSim(saveVskSwapCstSimVOList.get(0));
					}else{
						if(saveVskSwapCstSimVOList.size() > 0){
							dbDao.addVskSwapCstSim(saveVskSwapCstSimVOList);
						}
					}

					if(saveVskSwapCstVvdVOList.size() > 0){
						dbDao.addVskSwapCstVvd(saveVskSwapCstVvdVOList);
					}
					if(saveVskSwapCstPortVOList.size() > 0){
						dbDao.addVskSwapCstPort(saveVskSwapCstPortVOList);
					}
				}
			}
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}

		return simCode;
	}

	/**
	 * Skip Call 이 발생하는 Port 에 Container 물량 및 기타 비용 정보를 조회하고, 이전, 이후 Port 간 거리 정보등을 조회한다.<br>
	 *
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchSkipCallInfo(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException {
		CstSkdSimDtlCalcInfoVO returnVO = new CstSkdSimDtlCalcInfoVO();
		try {
			String ttlChgAmt = (dbDao.searchPortExpenceByVessel(cstSkdSimDtlCalcInfoVO)).getTtlChgAmt();
			String stndDist = dbDao.searchVskPortDist(cstSkdSimDtlCalcInfoVO.getFmLocCd(), cstSkdSimDtlCalcInfoVO.getToLocCd());
			CstSkdSimDtlCalcInfoVO tmnlReHdlCostVO = dbDao.searchTmnlReHdlCost(cstSkdSimDtlCalcInfoVO);
			CstSkdSimDtlCalcInfoVO cargoVolByBayPlanVO = dbDao.searchCargoVolByBayPlan(cstSkdSimDtlCalcInfoVO);
			CstSkdSimDtlCalcInfoVO cargoVolByTDRVO = dbDao.searchCargoVolByTDR(cstSkdSimDtlCalcInfoVO);

			returnVO.setTtlChgAmt(ttlChgAmt);
			returnVO.setStndDist(stndDist);
			if(tmnlReHdlCostVO != null){
				returnVO.setTmD2(tmnlReHdlCostVO.getTmD2());
				returnVO.setTmD4(tmnlReHdlCostVO.getTmD4());
			}
			if(cargoVolByBayPlanVO != null){
				returnVO.setTp20Qty(cargoVolByBayPlanVO.getTp20Qty());
				returnVO.setTp40Qty(cargoVolByBayPlanVO.getTp40Qty());
			}else{
				if(cargoVolByTDRVO != null){
					returnVO.setTp20Qty(cargoVolByTDRVO.getTp20Qty());
					returnVO.setTp40Qty(cargoVolByTDRVO.getTp40Qty());
				}
			}
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

		return returnVO;
	}

	/**
	 * Add Call이 발생하는 Port에 Port 비용 정보를 조회하고, 이전과 자신 그리고, 자신과 이후 Port간 거리 정보등을 조회한다.
	 *
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchAddCallInfo(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException {
		CstSkdSimDtlCalcInfoVO returnVO = new CstSkdSimDtlCalcInfoVO();
		try {
			SwapCstSkdSimVO swapCstSkdSimVO = new SwapCstSkdSimVO();

			//LNK_DIST, Manu In/Out, PORT_BUF_HRS, CRN_KNT, TML_PROD_QTY
			swapCstSkdSimVO = dbDao.searchVskPortMnvrTimeZone(cstSkdSimDtlCalcInfoVO.getLocCd(), cstSkdSimDtlCalcInfoVO.getYdCd());

			//SPD
			swapCstSkdSimVO.setLnkSpd(dbDao.searchMdmVslCntr(cstSkdSimDtlCalcInfoVO.getVslCd()).getVslSvcSpd());

			//TimeZone(Time Diff)
			swapCstSkdSimVO.setTimeDiff(dbDao.searchTimeZone(cstSkdSimDtlCalcInfoVO.getLocCd()).getTimeDiff());

			//Port Charge
			String ttlChgAmt = (dbDao.searchPortExpenceByVessel(cstSkdSimDtlCalcInfoVO)).getTtlChgAmt();

			returnVO.setSpd(swapCstSkdSimVO.getLnkSpd());
			returnVO.setTimeDiff(swapCstSkdSimVO.getTimeDiff());
			returnVO.setMnvrInHrs(swapCstSkdSimVO.getMnvrInHrs());
			returnVO.setMnvrOutHrs(swapCstSkdSimVO.getMnvrOutHrs());
			returnVO.setCrnKnt(swapCstSkdSimVO.getCrnKnt());
			returnVO.setTmlProdQty(swapCstSkdSimVO.getTmlProdQty());
			returnVO.setPortBufHrs(swapCstSkdSimVO.getPortBufHrs());
			returnVO.setTtlChgAmt(ttlChgAmt);
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

		return returnVO;
	}

	/**
	 * Port Charge 를 조회합니다.
	 *
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPortExpenceByVessel(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException {
		String ttlChgAmt = "";
		try {
			ttlChgAmt = (dbDao.searchPortExpenceByVessel(cstSkdSimDtlCalcInfoVO)).getTtlChgAmt();
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
		return ttlChgAmt;
	}

	/**
	 * 포트간 거리 정보를 조회합니다.<br>
	 *
	 * @param List<VskPortDistVO> vskPortDistVOs
	 * @return List<VskPortDistVO>
	 * @exception EventException
	 */
	public List<VskPortDistVO> searchVskPortDist(List<VskPortDistVO> vskPortDistVOs) throws EventException {
		List<VskPortDistVO> list = new ArrayList<VskPortDistVO>();

		try {
			String fmLocCd = "";
			String toLocCd = "";
			String stndDist = "";

			if(vskPortDistVOs != null && vskPortDistVOs.size() > 0){
				for(int i=0; i<vskPortDistVOs.size(); i++){
					fmLocCd = vskPortDistVOs.get(i).getFmLocCd();
					toLocCd = vskPortDistVOs.get(i).getToLocCd();

					stndDist = dbDao.searchVskPortDist(fmLocCd, toLocCd);

					VskPortDistVO vskPortDistVO = new VskPortDistVO();
					vskPortDistVO.setStndDist(stndDist);

					list.add(vskPortDistVO);
				}
			}

			return list;

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
	 * POL, POD에 의한 Costal Schedule 정보를 조회합니다.<br>
	 *
	 * @param CstSkdByPolPodVO cstSkdByPolPodVO
	 * @return List<CstSkdByPolPodVO>
	 * @exception EventException
	 */
	public List<CstSkdByPolPodVO> searchCstSkdByPolPod(CstSkdByPolPodVO cstSkdByPolPodVO) throws EventException {
		try {
			return dbDao.searchCstSkdByPolPod(cstSkdByPolPodVO);
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
	 * 해당 Port의 Costal Schedule 정보를 조회합니다.<br>
	 *
	 * @param CstSkdByPortVO cstSkdByPortVO
	 * @return List<CstSkdByPortVO>
	 * @exception EventException
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

	/**
	 * 해당 포트의 Time Zone, Manu In/Out, Terminal Productivity, Port Expence를 조회합니다.<br>
	 *
	 * @param SwapCstGRPVO swapCstGRPVO
	 * @return SwapCstSkdSimVO
	 * @exception EventException
	 */
	public SwapCstSkdSimVO searchCstSkdSimBaseInfo(SwapCstGRPVO swapCstGRPVO) throws EventException {
		try {
			SwapCstSkdSimVO swapCstSkdSimVO = new SwapCstSkdSimVO();
//			MdmVslCntrVO mdmVslCntrVO = null;

			//LNK_DIST(PORT_DIST), Manu In/Out, PORT_BUF_HRS, CRN_KNT, TML_PROD_QTY
			swapCstSkdSimVO = dbDao.searchVskPortMnvrTimeZone(swapCstGRPVO.getPortCd(), swapCstGRPVO.getYardCd());

			//SPD
//			mdmVslCntrVO = dbDao.searchMdmVslCntr(swapCstGRPVO.getVslCd());
			swapCstSkdSimVO.setLnkSpd(dbDao.searchMdmVslCntr(swapCstGRPVO.getVslCd()).getVslSvcSpd());

			//TimeZone(Time Diff)
			swapCstSkdSimVO.setTimeDiff(dbDao.searchTimeZone(swapCstGRPVO.getPortCd()).getTimeDiff());

			return swapCstSkdSimVO;

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
	 * Speed 변경 시 필요한 정보를 조회합니다.<br>
	 *
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchBunkerQtyBySpeed(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException{
		try {
			//Bunker Additional Cost
			return dbDao.searchBunkerQtyBySpeed(cstSkdSimDtlCalcInfoVO);
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
	 * VSL SKD History 정보를 조회해 온다.
	 *
	 * @param VvdPortLaneOtherVO vvdPortLaneOtherVO
	 * @return List<CstSkdHisByVvdVO>
	 * @exception EventException
	 */
	public List<CstSkdHisByVvdVO> searchCstSkdHisByVvd(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws EventException{
		try {
			return dbDao.searchCstSkdHisByVvd(vvdPortLaneOtherVO);
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
	 * CNSHA Port 및 이전 Boud에 기항지 정보를 찾고 Bay Plan이 입력되는 Port를 조회한다.
	 *
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchBayPlanInputPort(VskVslPortSkdVO vskVslPortSkdVO) throws EventException{
		try {
			return dbDao.searchBayPlanInputPort(vskVslPortSkdVO);
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
	 * 입출항일시 기준으로 최대 선적 화물량을 계산 및 조회
	 *
	 * @param LoadWgtGRPVO loadWgtGRPVO
	 * @return LoadWgtGRPVO
	 * @exception EventException
	 */
	public LoadWgtGRPVO calLoadableWgt(LoadWgtGRPVO loadWgtGRPVO) throws EventException{
		try {
			LoadWgtGRPVO rtnGRPVO = new LoadWgtGRPVO();
			LoadWgtVO paramVO = null;
			MdmVslCntrVO mdmVslCntrVO = null;
			VskDepRptVO vskDepRptVO = null;
			VskPortTideVO vskPortTideVO = null;
			VskHydrstMtxVO vskHydrstMtxVO = null;
			List<LoadWgtVO> loadWgtVOs = null;
			ArrayList<String> cwParam = new ArrayList<String>();

			paramVO = loadWgtGRPVO.getLoadWgtVO();

			/*
			 * CNTR_VSL_CLSS_CAPA AS VSL_CLASS(Vessel Class)
			 * LGT_SHP_TONG_WGT AS LIGHT_SHIP(Light Ship)
			 */
			mdmVslCntrVO = dbDao.searchMdmVslCntrInfo(paramVO.getVslCd());
			String sVslClss = "";
			String sLightShip = "";
			if(mdmVslCntrVO != null){
				sVslClss = mdmVslCntrVO.getCntrVslClssCapa();
				sLightShip = mdmVslCntrVO.getLgtShpTongWgt();
				rtnGRPVO.setVslClass(sVslClss);
				rtnGRPVO.setLightShip(sLightShip);
			}

			/*
			 * (DEP_FOIL_WGT + DEP_LOW_SULP_FOIL_WGT) AS Fuel_Oil
			 * (DEP_DOIL_WGT + DEP_LOW_SULP_DOIL_WGT) AS Diesel_Oil
			 * (DEP_FRSH_WTR_WGT) AS Fresh_Water
			 * (DEP_BLST_WGT) AS Ballast
			 */
			vskDepRptVO = dbDao.searchDeptureReport(paramVO);

			String sFuelOil = paramVO.getFuelOil();
			String sDieselOil = paramVO.getDieselOil();
			String sFreshWater = paramVO.getFreshWater();
			String sBallast = paramVO.getBallast();

			if(vskDepRptVO != null){
				/*
				 * 화면에서 입력한 값이 없으면 조회한 값을 이용하여 Displacement을 계산한다.
				 */
				if(!VSKGeneralUtil.isNotNull(sFuelOil)) sFuelOil = vskDepRptVO.getDepFoilWgt();
				if(!VSKGeneralUtil.isNotNull(sDieselOil)) sDieselOil = vskDepRptVO.getDepDoilWgt();
				if(!VSKGeneralUtil.isNotNull(sFreshWater)) sFreshWater = vskDepRptVO.getDepFrshWtrWgt();
				if(!VSKGeneralUtil.isNotNull(sBallast)) sBallast = vskDepRptVO.getDepBlstWgt();
			}
			rtnGRPVO.setFuelOil(sFuelOil);
			rtnGRPVO.setDieselOil(sDieselOil);
			rtnGRPVO.setFreshWater(sFreshWater);
			rtnGRPVO.setBallast(sBallast);

			/*
			 * N1ST_HIGH_TIDE_HGT AS DRAFT(Draft at FW)
			 */
			vskPortTideVO = dbDao.searchPortTide(paramVO);
			String sDraft = "";
			if(vskPortTideVO != null){
				sDraft = vskPortTideVO.getN1stHighTideHgt();
				rtnGRPVO.setDraft(sDraft);
			}

			/*
			 * DRFT_DPTH AS TPC, DWT_WGT AS DISPLACEMENT(Displacement)
			 */
			String sDisplacement = "";
			if(vskPortTideVO != null && VSKGeneralUtil.isNotNull(sDraft) && VSKGeneralUtil.isNotNull(sVslClss)){
				vskHydrstMtxVO = dbDao.searchHydrstWgt(vskPortTideVO.getN1stHighTideHgt(), paramVO.getVslCd());
				if(vskHydrstMtxVO != null){
					sDisplacement = vskHydrstMtxVO.getDwtWgt();
					rtnGRPVO.setTpc(vskHydrstMtxVO.getDrftDpth());
					rtnGRPVO.setDisplacement(vskHydrstMtxVO.getDwtWgt());
				}
			}

			String sConstant = JSPUtil.removeCharacter(VSKGeneralUtil.getCheckNullToZero(loadWgtGRPVO.getLoadWgtVO().getConstant()), ",");

			/*
			 * Cargo Weight 계산
			 * Cargo Weight = Displacement - (Light Ship + Constant + Fuel Oil + Diesel Oil + Fresh Water + Ballast)
			 */
			cwParam.add(sLightShip);
			cwParam.add(sConstant);
			cwParam.add(sFuelOil);
			cwParam.add(sDieselOil);
			cwParam.add(sFreshWater);
			cwParam.add(sBallast);

			String cargoWeight = calcCargoWeight(sDisplacement, cwParam);
			rtnGRPVO.setCargoWeight(cargoWeight);
			paramVO.setCargoWeight(cargoWeight);

			//BSA, Loadable Cargo Weight, Loaded Cargo Weight, Actual Loadable Weight
			loadWgtVOs = dbDao.searchCoaBsaByVvd(paramVO);
			if(loadWgtVOs != null){
				rtnGRPVO.setLoadWgtVOList(loadWgtVOs);
			}

			return rtnGRPVO;

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
	 * Cargo Weight 계산
	 *
	 * @param String sDisplacement
	 * @param ArrayList<String> sParam
	 * @return String
	 */
	private String calcCargoWeight(String sDisplacement, ArrayList<String> sParam){
		String sCargoWeight = "0.0";

		/*
		 * Cargo Weight = Displacement - (Light Ship + Constant + Fuel Oil + Diesel Oil + Fresh Water + Ballast)
		 * => sDisplacement - (ALL ADD(sParam))
		 */
		if(sParam != null && VSKGeneralUtil.isNotNull(sDisplacement)){
			BigDecimal bDisplacement = new BigDecimal(sDisplacement);

			for(int i=0; i<sParam.size(); i++){
				if(VSKGeneralUtil.isNotNull(sParam.get(i))){
					BigDecimal bParam = new BigDecimal(JSPUtil.removeCharacter(sParam.get(i), ","));
					bDisplacement = bDisplacement.subtract(bParam);
				}
			}

			sCargoWeight = bDisplacement.toString();
		}

		return sCargoWeight;
	}

	/**
	 * VVD별 연결되어 있는 Booking List를 조회합니다.
	 *
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<BkgListByVvdVO>
	 * @exception EventException
	 */
	public List<BkgListByVvdVO> searchBkgListByVvd(String vslCd, String skdVoyNo, String skdDirCd) throws EventException {
		try{
			List<BkgListByVvdVO> list = dbDao.searchBkgListByVvd(vslCd, skdVoyNo, skdDirCd);
			if(list.size()==0){
				// VSK10024 : 해당 VVD를 참조하는 Booking 정보가 없습니다.
				throw new EventException(new ErrorHandler("VSK10024").getMessage());
			}
			return list;
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
	 * 해당 VVD 스케쥴을 수동 Close 처리합니다.
	 *
	 * @param ActivationVvdVO[] activationVvdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslSkdListByLane(ActivationVvdVO[] activationVvdVOs, SignOnUserAccount account) throws EventException {
		
		try{
			for(ActivationVvdVO vo : activationVvdVOs){
				vo.setUpdUsrId(account.getUsr_id());
			}
			dbDao.modifyVslSkdListByLane(activationVvdVOs);
			
			/*** :: VVD Close<->Activate 이력데이터 생성로직추가 ::
		      *   TABLE NAME : VSK_VSL_SKD_CNG_HIS
		      *   로직추가일자 : 2013-08-08
		      ***/
			List<VskVslSkdVO>	vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
			VskVslSkdVO			tmpVO			= new VskVslSkdVO();
			
			for(ActivationVvdVO actVvdVo : activationVvdVOs){
				tmpVO.setVslCd		(actVvdVo.getVslCd		()	);
				tmpVO.setSkdVoyNo	(actVvdVo.getSkdVoyNo	()	);
				tmpVO.setSkdDirCd	(actVvdVo.getSkdDirCd	()	);
				vskVslSkdVOs.add	(tmpVO								);				
			}
			
		    this.createVskVslSkdChangeHistoryMstOnly(vskVslSkdVOs, "MODIFY_VvdStatusChange");
			
			/****************************************************************
			 * 운항스케쥴 이력관리를 위한 VO or VO List Return ::2013-08-28::
			 */
			////return vskVslSkdVOs;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		}
	}

	/**
	 * 해당 VVD 스케쥴을 Activate 처리합니다.
	 *
	 * @param ActivationVvdVO activationVvdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSkdActivate(ActivationVvdVO activationVvdVO, SignOnUserAccount account) throws EventException {
		try{
			activationVvdVO.setUpdUsrId	(account.getUsr_id());
			dbDao.manageSkdActivate		(activationVvdVO	);
			
			/*** :: VVD Activation 이력데이터 생성로직추가 ::
		      *   TABLE NAME : VSK_VSL_SKD_CNG_HIS
		      *   로직추가일자 : 2013-08-08
		      ***/
			
			List<VskVslSkdVO>	vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
			VskVslSkdVO			tmpVO			= new VskVslSkdVO();
			tmpVO.setVslCd		(activationVvdVO.getVslCd		()	);
			tmpVO.setSkdVoyNo	(activationVvdVO.getSkdVoyNo	()	);
			tmpVO.setSkdDirCd	(activationVvdVO.getSkdDirCd	()	);
			vskVslSkdVOs.add	(tmpVO								);
			
		    this.createVskVslSkdChangeHistoryMstOnly(vskVslSkdVOs, "ACTIVATE_ByVvd");
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		}
	}

	/**
	 * 운하별 통항 선박의 스케뷸 및 Surcharge를 조회합니다.
	 *
	 * @param CanalTransitTargetVvdVO canalTransitTargetVvdVO
	 * @return List<CanalTransitTargetVvdVO>
	 * @exception EventException
	 */
	public List<CanalTransitTargetVvdVO> searchCanalTzList(CanalTransitTargetVvdVO canalTransitTargetVvdVO) throws EventException {
		try{
			//List<CanalTransitTargetVvdVO> bayList = new ArrayList<CanalTransitTargetVvdVO>();
			//List<CanalTransitTargetVvdVO> afterBayList = new ArrayList<CanalTransitTargetVvdVO>();
			//Map<String, CanalTransitTargetVvdVO> item = new HashMap<String, CanalTransitTargetVvdVO>();

			// 1. schedule 조회
			List<CanalTransitTargetVvdVO> list = dbDao.searchCanalTzList(canalTransitTargetVvdVO);

/*
			// 2. bay plan 조회. EGSUZ 일때만
			if("EGSUZ".equals(canalTransitTargetVvdVO.getPortCd())){
				for(CanalTransitTargetVvdVO vo : list){
					item.put(vo.getVvd(), vo);
					if(!"".equals(VSKGeneralUtil.getCheckNullToString(vo.getBayLoc()))){
						bayList.add(vo);
					}
				}
			}

			int pos = 0;
			int cnt = 0;
			int pkgCnt = 30; // 50개씩 짤라서 조회
			for(int i=0; i<bayList.size(); i++){

				if(i==bayList.size()-1){
					afterBayList.addAll(dbDao.searchCanalTzTierCalc(  bayList.subList(pos, bayList.size())));
				}

				if(cnt<pkgCnt){
					cnt++;
					continue;
				}else{
					afterBayList.addAll(dbDao.searchCanalTzTierCalc(  bayList.subList(pos, pos+pkgCnt)));
					pos = i;
					cnt = 1;
					continue;
				}
			}

			// bay_plan 조회한 결과를 해당 VVD VO에 반영
			for(CanalTransitTargetVvdVO vo : afterBayList){
				CanalTransitTargetVvdVO orgVO = item.get(vo.getVvd());
				orgVO.setScgCarPortCd(vo.getScgCarPortCd());
				orgVO.setScgCarTier(vo.getScgCarTier());
				orgVO.setScgCarTeu(vo.getScgCarTeu());
				orgVO.setScgCarRatio(vo.getScgCarRatio());
				orgVO.setScgCarBox(vo.getScgCarBox()); 
				item.put(vo.getVvd(), orgVO);
			}

			// schedule vo 리스트를 기준으로 bay_plan의 조회 결과를 반영. EGSUZ 일 때만
			if("EGSUZ".equals(canalTransitTargetVvdVO.getPortCd())){
				for(CanalTransitTargetVvdVO vo : list){
					CanalTransitTargetVvdVO orgVO = item.get(vo.getVvd());
					vo.setScgCarPortCd(orgVO.getScgCarPortCd());
					vo.setScgCarTier(orgVO.getScgCarTier());
					vo.setScgCarTeu(orgVO.getScgCarTeu());
					vo.setScgCarRatio(orgVO.getScgCarRatio());
					vo.setScgCarBox(orgVO.getScgCarBox());
				}
			}
*/
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}

	/**
	 * Panama 운하의 통항을 위한 Booking 정보를 저장한다.<br>
	 * 
	 * @param CanalTransitTargetVvdVO[] canalTransitTargetVvdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCanalTzBkg(CanalTransitTargetVvdVO[] canalTransitTargetVvdVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CanalTransitTargetVvdVO> updateVoList = new ArrayList<CanalTransitTargetVvdVO>();
			
			for ( int i = 0; i < canalTransitTargetVvdVOs.length; i++ ) {
				canalTransitTargetVvdVOs[i].setUsrId(account.getUsr_id());
				updateVoList.add(canalTransitTargetVvdVOs[i]); 
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.manageCanalTzBkg(updateVoList);
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("VSK10018", new String[]{"Canal Transit List Booking Info"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("VSK10018", new String[]{"Canal Transit List Booking Info"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 선박의 최대 선속으로 인한 Bunker 비용과 Canal Surcharge 비용 차이를 조회합니다.
	 *
	 * @param CanalBnkSavVO canalBnkSavVO
	 * @return List<CanalBnkSavVO>
	 * @exception EventException
	 */
	public List<CanalBnkSavVO> calCanalBunkerSaving(CanalBnkSavVO canalBnkSavVO) throws EventException {
		try{

			List<CanalBnkSavVO> list = dbDao.calCanalBunkerSaving(canalBnkSavVO);
			return list;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * Vessel Port Schedule에 CUD가 발생할 경우 ERP로 변경 정보를 송신
	 *
	 * @param List<VvdVO> erpIfVvdVOs
	 * @exception EventException
	 */
	public void sendVslSkdErpIf(List<VvdVO> erpIfVvdVOs) throws EventException {
		// ****************************************************************
		// * sendVslSkdRepeatErpIf 메서드와 동일한 로직이므로 수정시 유의
		// ****************************************************************
		try{
			if(erpIfVvdVOs != null && erpIfVvdVOs.size() > 0){
				for(int i=0; i<erpIfVvdVOs.size(); i++){
					VvdVO vvdVO = new VvdVO();
					vvdVO = erpIfVvdVOs.get(i);

					List<ErpMsgFns017VO> list = dbDao.searchErpIfSendingData(vvdVO);
					if(list.size() > 0){
						 
//						log.info("+++++++++++++++++++++++++BCImpl+8897line+sendVslSkdErpIf++LYJLYJ+++++++++++++++++++++++");
//						log.info("+++++++++++++++++++++++++++++++["+vvdVO.getVslCd()+"]+++++++++++++++++++++++++++++");
//						log.info("+++++++++++++++++++++++++++++++["+vvdVO.getSkdVoyNo()+"]+++++++++++++++++++++++++++++");
//						log.info("+++++++++++++++++++++++++++++++["+vvdVO.getSkdDirCd()+"]+++++++++++++++++++++++++++++");
//						log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


						String reString = sendVslSkdErpIf2(list);
						String[] res = new String[]{"", ""};

						if(reString!=null && reString.indexOf(":")>-1){
							res = reString.split(":");
						}

						// [CHM-201006456-01] EDI 전송후 전송내역을 VSK_CUST_EDI_LOG 테이블에 기록
						//전문 SEQ 조회
						String vskdEdiSndId = dbDao.searchEdiHdSeqToKlnet();
						VskCustEdiLogVO vskCustEdiLogVO = new VskCustEdiLogVO();
						vskCustEdiLogVO.setCustTrdPrnrId("FNS017");   // ****************
						if(res[1]!=null && res[1].length()>0){
							vskCustEdiLogVO.setVskdEdiSndId(res[1]);
						}else{
							vskCustEdiLogVO.setVskdEdiSndId(vskdEdiSndId);
						}
						vskCustEdiLogVO.setN1stVslCd(vvdVO.getVslCd());
						vskCustEdiLogVO.setN1stSkdVoyNo(vvdVO.getSkdVoyNo());
						vskCustEdiLogVO.setN1stSkdDirCd(vvdVO.getSkdDirCd());
						vskCustEdiLogVO.setCreUsrId(vvdVO.getCreUsrId()==null?" ":vvdVO.getCreUsrId());
						vskCustEdiLogVO.setUpdUsrId(vvdVO.getUpdUsrId()==null?" ":vvdVO.getUpdUsrId());
						vskCustEdiLogVO.setDiffRmk(res[0]);
						dbDao.addVskCustEdiLogToDLS(vskCustEdiLogVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			if(ex.toString().indexOf("FRM10501")>-1 || ex.toString().indexOf("TimedOutException")>-1){
				// TimeOutException 이 발생하면 Framework에서 FRM10501 Exception을 발생한다.
				throw new EventException(new ErrorHandler("VSK10076").getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	private String sendVslSkdErpIf2(List<ErpMsgFns017VO> list) throws EventException {
		try{
			return eaiDao.sendVslSkdErpIf(list);
		}catch(DAOException e){
			// VSK10046 : ERP 시스템과 통신 중 에러가 발생했습니다.
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("VSK10046").getMessage(), e);
		}
	}

	/**
	 * KTNET에게 송신, BKG이 들어오고 이를 (주)한진으로 국내운송 ORDER를 내릴때
	 * (주)한진 시스템에 선명이 등록되어 있어야 하기 때문에 선명마다,
	 * 또 PORT마다 (주)한지 시스템에 직접 입력하여 선명등록 EDI 전송하는 형식임
	 *
	 * @param List<VvdVO> vvdVOs
	 * @exception EventException
	 */
	public void sendEdiToDLS(List<VvdVO> vvdVOs) throws EventException {
		try{
			log.error(" =====================VesselScheduleMgtBCImpl========================");
			if(vvdVOs != null && vvdVOs.size() > 0){
				for(int i=0; i<vvdVOs.size(); i++){

					VvdVO vvdVO = new VvdVO();
					vvdVO = vvdVOs.get(i);

					//해당 vvd에 대한 port list
					List<EdiMsgToDLSVO> list = dbDao.searchEdiMsgToDLS(vvdVO);

					if(list != null && list.size() > 0){

						// ACT 인 경우만 채번하도록 수정. 2010.03.08
						//전문의  seq를 증가시킨 헤더
						String jumunHeader = dbDao.searchEdiHdToDLS();
						//new line
						String suffix = "\n";

						//String jumun = "";
						StringBuilder jumun = new StringBuilder();
						//interface id
						String queueName = "";

						jumun.append(jumunHeader).append(suffix);
						for(int k=0; k<list.size(); k++){
							
							log.error("\n\nthis message-----for LIVE TEST------------------------------------------------");
							log.error("\n\nthis message-----for LIVE TEST------------------------------------------------");
							log.error("\n\nthis message-----for LIVE TEST------------------------------------------------");
							log.error("\n\nthis message-----for LIVE TEST------------------------------------------------");
							log.error("\n\nthis message-----for LIVE TEST------------------------------------------------");
							log.error("\nlist.get(k).getVslCd()  ::"+list.get(k).getVslCd());
							log.error("\nlist.get(k).getVoy()  ::"+list.get(k).getVoy());
							log.error("\nlist.get(k).getDir()  ::"+list.get(k).getDir());
							log.error("\n\nthis message-----for LIVE TEST------------------------------------------------");
							
							jumun.append("{VVD").append(suffix);
							jumun.append("VSL_CD:").append(list.get(k).getVslCd()).append(suffix);
							jumun.append("VOY:").append(list.get(k).getVoy()).append(suffix);
							jumun.append("DIR:").append(list.get(k).getDir()).append(suffix);
							jumun.append("POL_LOC:").append(list.get(k).getPolLoc()).append(suffix);
							jumun.append("LANE:").append(list.get(k).getLane()).append(suffix);
							jumun.append("VSL_NM:").append(list.get(k).getVslNm()).append(suffix);
							jumun.append("CCT:").append(list.get(k).getCct()).append(suffix);
							jumun.append("ETB:").append(list.get(k).getEtb()).append(suffix);
							jumun.append("ETD:").append(list.get(k).getEtd()).append(suffix);
							jumun.append("VVD}").append(suffix);
						}

						queueName = SubSystemConfigFactory.get("VSK.ALPSVSK_UBIZHJS_VENDOR_VSK.IBMMQ.QUEUE");
						//flatFile = 전문의 헤더와 내용
						//전문 헤더와 내용을 담을 변수
						String flatFile = jumun.toString();

						sendEdiToDLS(queueName , flatFile);

						// CHM-201006129-01
						// EDI 전송후 전송내역을 VSK_CUST_EDI_LOG 테이블에 기록
						log.error("\n\nthis message-----for LIVE TEST------------------------------------------------");
						log.error("\n\nthis message-----for LIVE TEST------------------------------------------------");
						log.error("\n vvdVO.getVslCd()  ::"+vvdVO.getVslCd());
						log.error("\n vvdVO.getSkdVoyNo()  ::"+vvdVO.getSkdVoyNo());
						log.error("\n vvdVO.getSkdDirCd()  ::"+vvdVO.getSkdDirCd());
						log.error("\n\nthis message-----for LIVE TEST------------------------------------------------");
						
						//전문 SEQ 조회
						String vskdEdiSndId = dbDao.searchEdiHdSeqToKlnet();
						VskCustEdiLogVO vskCustEdiLogVO = new VskCustEdiLogVO();
						vskCustEdiLogVO.setCustTrdPrnrId("DLS");
						vskCustEdiLogVO.setVskdEdiSndId(vskdEdiSndId);
						vskCustEdiLogVO.setN1stVslCd(vvdVO.getVslCd());
						vskCustEdiLogVO.setN1stSkdVoyNo(vvdVO.getSkdVoyNo());
						vskCustEdiLogVO.setN1stSkdDirCd(vvdVO.getSkdDirCd());
						vskCustEdiLogVO.setCreUsrId(vvdVO.getCreUsrId());
						vskCustEdiLogVO.setUpdUsrId(vvdVO.getUpdUsrId());
						vskCustEdiLogVO.setDiffRmk(flatFile);
						dbDao.addVskCustEdiLogToDLS(vskCustEdiLogVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * EDI 통신
	 *
	 * @param String queueName
	 * @param String flatFile
	 * @return String
	 * @exception EventException
	 */
	private String sendEdiToDLS(String queueName, String flatFile) throws EventException {
		try{
			return eaiDao.sendEdiToDLS(queueName , flatFile);
		}catch(DAOException e){
			// VSK10046 : ERP 시스템과 통신 중 에러가 발생했습니다.
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("VSK10046").getMessage(), e);
		}
	}

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

	/**
	 * VVD 정보의 P/F를 설정합니다.<br>
	 *
	 * @param List<ActivationVvdVO> activationVvdVOs
	 * @exception EventException
	 * @author Hyuk Ryu
	 * @date 2009. 11. 11.
	 */
	public void manageVvdPf(List<ActivationVvdVO> activationVvdVOs) throws EventException {
		try{
			dbDao.manageVvdPf(activationVvdVOs);

			/*** :: VVD Close<->Activate 이력데이터 생성로직추가 ::
		      *   TABLE NAME : VSK_VSL_SKD_CNG_HIS
		      *   로직추가일자 : 2013-08-08
		      ***/
			
			List<VskVslSkdVO>	vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
			VskVslSkdVO			tmpVO			= new VskVslSkdVO();
			
			for(ActivationVvdVO actVvdVo : activationVvdVOs){
				tmpVO.setVslCd		(actVvdVo.getVslCd		()	);
				tmpVO.setSkdVoyNo	(actVvdVo.getSkdVoyNo	()	);
				tmpVO.setSkdDirCd	(actVvdVo.getSkdDirCd	()	);
				vskVslSkdVOs.add	(tmpVO								);				
			}
			
		    this.createVskVslSkdChangeHistoryMstOnly(vskVslSkdVOs, "MODIFY_VvdProformaType");			
			
		}catch(DAOException e){
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), e);
		}catch(Exception e){
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), e);
		}
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
	 * Long Range SKD 방식으로 Vessel Port SKD을 조회합니다.
	 *
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return LongRangeSkdInqGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdInqGRPVO searchPortSkdOnLongRange(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException {

		LongRangeSkdInqGRPVO 				longRangeSkdInqGRPVO 	= null;
		Map<String, List<PfSkdDetailVO>> 	pfSkdDetailsByGroup 	= new HashMap<String, List<PfSkdDetailVO>>();
		
		//log.info("\n\n ::jskjskjskjskjskjsk:: VesselScheduleMgtBCImpl.searchPortSkdOnLongRange :: entering!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"] \n");
		
		try{

			String unitTp = portSkdOnLongRangeVO.getUnitTp();//by port, by yard
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

			
			//log.info("\n\n ::jskjskjsk:: STEP 1. starting!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
			
			// 1. 위에 쿼리 실행. PORT SKD 데이터 조회
			List<PortSkdOnLongRangeVO> portSkdOnLongRangeVOs = searchPortSkd(portSkdOnLongRangeVO);
			
			//log.info("\n\n ::jskjskjsk:: STEP 1. finished!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");

			if(portSkdOnLongRangeVOs==null || portSkdOnLongRangeVOs.size()==0){
				throw new EventException(new ErrorHandler("VSK10018", new String[]{"Schedule"}).getMessage());
			}else{
				longRangeSkdInqGRPVO = new LongRangeSkdInqGRPVO();
			}

			List<PfSkdDetailVO> pfTypes 	= new ArrayList<PfSkdDetailVO>();
			Map<String, String> portNmMap 	= new HashMap<String, String>();
			Map<String, String> vslEngNmMap = new HashMap<String, String>();

			//log.info("\n\n ::jskjskjsk:: STEP 2. LOOP starting!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
			for(PortSkdOnLongRangeVO vo1 : portSkdOnLongRangeVOs){

				// 2.1 조회된 PORT SKD에서 P/F TYPE 목록 획득
				// Feeder Port Skd인 경우, P/F TYPE이 의미가 없으므로 모든 Feeder Port Skd 정보가 동일한 값을 갖도록 조정해준다.
				if("O".equals(vo1.getVslSvcTpCd())){ // Trunk인 경우
					vo1.setPfSkdTpCd("FEEDER");
				}

				PfSkdDetailVO pfSkdDetailVO = new PfSkdDetailVO();
				pfSkdDetailVO.setVslSlanCd	(vo1.getVslSlanCd());
				pfSkdDetailVO.setVslSvcTpCd	(vo1.getVslSvcTpCd());
				pfSkdDetailVO.setPfSvcTpCd	(vo1.getPfSkdTpCd());

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
			
			//log.info("\n\n ::jskjskjsk:: STEP 2. LOOP finished!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			

			// 2.3  Port Name 목록과 Vessel Eng Name 목록을 Group VO에 설정
			longRangeSkdInqGRPVO.setPortNms(portNmMap);
			longRangeSkdInqGRPVO.setVslEngNms(vslEngNmMap);

			//log.info("\n\n ::jskjskjsk:: STEP 3. LOOP starting!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
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

			//log.info("\n\n ::jskjskjsk:: STEP 3. LOOP finished!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
			
			//log.info("\n\n ::jskjskjsk:: STEP 4. LOOP starting!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
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
			
			
			//log.info("\n\n ::jskjskjsk:: STEP 4. LOOP finished!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
			

			// 연결된 VVD는 Inquiry 화면에서 하나의 Row로 표시된다.
			linkTurningVVD(portSkdByVVD);
			linkSameVoyageVVD(portSkdByVVD);

			// 5. 정렬된 리스트
			List<List<PortSkdOnLongRangeVO>> orderedPortSkdOnLongRangeVOs = sortPortSkd(portSkdByVVD, firstEtbByVVD);
			longRangeSkdInqGRPVO.setPortSkdVOs(orderedPortSkdOnLongRangeVOs);

			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// Remark 정보 처리
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			LongRangeSkdInqVO 		remarkVO 	= null;
			List<LongRangeSkdInqVO> rmkList 	= new ArrayList<LongRangeSkdInqVO>();
			Map<String, String> 	rmkVVD 		= new HashMap<String, String>();

			
			//log.info("\n\n ::jskjskjsk:: STEP 5-1. LOOP starting!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
			for(List<PortSkdOnLongRangeVO> list : orderedPortSkdOnLongRangeVOs){
				PortSkdOnLongRangeVO first = list.get(0);
				PortSkdOnLongRangeVO last = list.get(list.size()-1);

				String vvd = first.getVslCd() + first.getSkdVoyNo() + first.getSkdDirCd();

				if(first.getVpsRmk()!=null && first.getVpsRmk().trim().length()!=0){
					if(!rmkVVD.containsKey(vvd)){
						remarkVO = new LongRangeSkdInqVO();
						remarkVO.setRemarkFlag	(true);
						remarkVO.setVslCd		(first.getVslCd		());
						remarkVO.setSkdVoyNo	(first.getSkdVoyNo	());
						remarkVO.setSkdDirCd	(first.getSkdDirCd	());
						remarkVO.setVpsRmk		(first.getVpsRmk	());
						rmkList.add				(remarkVO);
						rmkVVD.put				(vvd, vvd);
					}
				}

				vvd = last.getVslCd() + last.getSkdVoyNo() + last.getSkdDirCd();

				if(last.getVpsRmk()!=null && last.getVpsRmk().trim().length()!=0){
					if(!rmkVVD.containsKey(vvd)){
						remarkVO = new LongRangeSkdInqVO();
						remarkVO.setRemarkFlag	(true);
						remarkVO.setVslCd		(last.getVslCd		());
						remarkVO.setSkdVoyNo	(last.getSkdVoyNo	());
						remarkVO.setSkdDirCd	(last.getSkdDirCd	());
						remarkVO.setVpsRmk		(last.getVpsRmk		());
						rmkList.add				(remarkVO);
						rmkVVD.put(vvd, vvd);
					}
				}
			}

			
			//log.info("\n\n ::jskjskjsk:: STEP 5-1. LOOP finished!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
			
			longRangeSkdInqGRPVO.setRemarks(rmkList);

			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			// 항차스케쥴을 P/F 별로 grouping 한다.
			// 이전 또는 이후 항차와 동일한 P/F일 경우 같은 그룹으로 모으는 과정이다.
			// 항차스케쥴 ==> P/F에 대응되는 2 Direction VVD가 모여진 스케쥴. 즉, P/F SKD Detail에 대응되는 2개의 VVD의 합
			List<List<List<PortSkdOnLongRangeVO>>> groupByPf = new ArrayList<List<List<PortSkdOnLongRangeVO>>>();

			String beforePfSkdTpCd = null;
			String currentPfSkdTpCd = null;

			//log.info("\n\n ::jskjskjsk:: STEP 5-2. LOOP starting!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
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
			
			//log.info("\n\n ::jskjskjsk:: STEP 5-2. LOOP finished!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
			
			//log.info("\n\n ::jskjskjsk:: STEP 5-3. LOOP starting!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");

			// 그리드가 10개 이상이 표현될 수 있는 경우
			// Feeder 레인인 경우
			// UI에서 원할한 성능을 발현할 수 없으므로 하나의 그리드로 통합하여 보여준다.
			if(groupByPf.size()>1){

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

			//log.info("\n\n ::jskjskjsk:: STEP 5-3. LOOP finished!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			//log.info("\n\n ::jskjskjsk:: STEP 5-3. LOOP finished!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
			//진마리아 CHM-201111568-01
			if("1".equals(unitTp)){
				
				//log.info("\n\n ::jskjskjsk:: STEP 5. additional<by Port> LOOP starting!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
				
				////::jsk:2013-06-13::임시 break 처리::////
/*				if("IMU".equals(portSkdOnLongRangeVO.getVslSlanCd())){
					
					log.info("\n\n ::jskjskjsk:: additional<by Port> LOOP IMU inforced return 처리 \n");
					
					longRangeSkdInqGRPVO.setPortSkdVOsByPf		(groupByPf			);
					longRangeSkdInqGRPVO.setPfSkdDetailsByGroup	(pfSkdDetailsByGroup);
					
					return longRangeSkdInqGRPVO;
				}*/
				
				//log.info("\n\n ::jskjskjsk:: STEP 5. additional<by Port> LOOP starting!!! groupByPf.size() >>> ["+groupByPf.size()+"] ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
				
				for(int i=0; i<groupByPf.size(); i++){
					List<List<PortSkdOnLongRangeVO>> sameGrp = groupByPf.get(i);
					
					//log.info("\n STEP 5. 1st LOOP i = ["+i+"], sameGrp.get(0).size() >>> ["+sameGrp.get(0).size()+"]");
					
					///////////////////////////////////////////2013-06-13//////////////////////////////////////////////////////
					///////////////////////////////////////////////////////////////////////////////////////////////////////////
/*					if(true){
						longRangeSkdInqGRPVO.setPortSkdVOsByPf		(groupByPf			);
						longRangeSkdInqGRPVO.setPfSkdDetailsByGroup	(pfSkdDetailsByGroup);
					
						break;
					}*/
					///////////////////////////////////////////////////////////////////////////////////////////////////////////
					///////////////////////////////////////////2013-06-13//////////////////////////////////////////////////////
					
					for(int portNum=0; portNum<sameGrp.get(0).size()-1; portNum++){
						
						//log.info("\n STEP 5. 2nd LOOP portNum = ["+portNum+"]");
						
						String firPort = sameGrp.get(0).get(portNum).getVpsPortCd();
						String secPort = sameGrp.get(0).get(portNum+1).getVpsPortCd();
						
						if(!"".equals(firPort) && firPort.equals(secPort)){
							boolean merge = true;
							for(int vvdNum=0; vvdNum<sameGrp.size(); vvdNum++){
								if(sameGrp.get(vvdNum).get(portNum).getPfEtbDt() != null && sameGrp.get(vvdNum).get(portNum+1).getPfEtdDt() != null){
									merge = false;
								}
							}
							
							if(merge){

								String vslSlanCd = sameGrp.get(0).get(portNum).getVslSlanCd();
								String pfSkdTpCd = sameGrp.get(0).get(portNum).getPfSkdTpCd();
								String vslCd 	= "";
								String skdVoyNo = "";

								for(int m=0; m<sameGrp.get(0).size()-1; m++){
									vslCd 		= sameGrp.get(0).get(m).getVslCd();
									skdVoyNo 	= sameGrp.get(0).get(m).getSkdVoyNo();
									if(vslCd != null){
										break;
									}
								}
								String key = vslSlanCd+pfSkdTpCd+vslCd+skdVoyNo;

								List<PfSkdDetailVO> detailVOs = pfSkdDetailsByGroup.get(key);
								
								///////////////////////////////////////////////////////////////////////////////////////
								if(detailVOs != null){
									if("*".equals(detailVOs.get(portNum).getEtbDyCd())){
										for(int all=0; all<sameGrp.size(); all++){
											if(sameGrp.get(all).get(portNum).getVpsEtbDt()!=null){
												sameGrp.get(all).set(portNum+1, sameGrp.get(all).get(portNum));
											}
											sameGrp.get(all).remove(portNum);
										}
										detailVOs.remove(portNum);
									}else if("*".equals(detailVOs.get(portNum+1).getEtbDyCd())){
										for(int all=0; all<sameGrp.size(); all++){
											if(sameGrp.get(all).get(portNum+1).getVpsEtbDt()!=null){
												sameGrp.get(all).set(portNum, sameGrp.get(all).get(portNum+1));
											}
											sameGrp.get(all).remove(portNum+1);
										}
										detailVOs.remove(portNum+1);
									}
									
									//::2013-06-13:: unlimited loop cause :://
									////////portNum--;
								
								}	//end of if (detialVOs not null)
								///////////////////////////////////////////////////////////////////////////////////////
								
							}	//END OF IF (merge decision)
						
						}	//END OF IF
						
					}	//END OF FOR LOOP (Port Number)
					
				}	//END OF FOR LOOP (groupByPf.size)
			
				//log.info("\n\n ::jskjskjsk:: STEP 5. additional<by Port> LOOP finished!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"]\n");
			
			}

			longRangeSkdInqGRPVO.setPortSkdVOsByPf		(groupByPf			);
			longRangeSkdInqGRPVO.setPfSkdDetailsByGroup	(pfSkdDetailsByGroup);

			//log.info("\n\n ::jskjskjskjskjskjsk:: VesselScheduleMgtBCImpl.searchPortSkdOnLongRange :: finished!!! ["+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))+"] \n");
			
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
		String firstDirCd = null;

		StringBuffer sbSameVoyVVD	= new StringBuffer();
		
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
					
					//if("E".equals(firstDirCd)){
					//	sameVoyVVD = sameVoyVVD + "W";
					//}else if("W".equals(firstDirCd)){
					//	sameVoyVVD = sameVoyVVD + "E";
					//}else if("S".equals(firstDirCd)){
					//	sameVoyVVD = sameVoyVVD + "N";
					//}else if("N".equals(firstDirCd)){
					//	sameVoyVVD = sameVoyVVD + "S";
					//}
					
					if("E".equals(firstDirCd)){
						sbSameVoyVVD.append(sameVoyVVD);
						sbSameVoyVVD.append("W");
					}else if("W".equals(firstDirCd)){
						sbSameVoyVVD.append(sameVoyVVD);
						sbSameVoyVVD.append("E");
					}else if("S".equals(firstDirCd)){
						sbSameVoyVVD.append(sameVoyVVD);
						sbSameVoyVVD.append("N");
					}else if("N".equals(firstDirCd)){
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

				if(tgtVVDs.size()==0){
					tgtVVDs.add(srcVVDs.get(0));
					continue;
				}

				tmp = new ArrayList<PortSkdOnLongRangeVO>();
				emptyList = new ArrayList<PortSkdOnLongRangeVO>();

				//  tgtVVD와 동일한 Port 리스트로 구성된 VVD 를 구성한다.
				newVVD = new ArrayList<PortSkdOnLongRangeVO>();
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

				// tgtVVDs의 2nd Direction의 위치를 구한다.
				int startPos2nd = find2ndStartPos(tgtVVDs.get(0));

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


					int tgtPos = findTargetPos(tgtVVDs.get(0), portSkdVO);
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
					for(List<PortSkdOnLongRangeVO> otherVVD : tgtVVDs){
						otherVVD.addAll(emptyList);
					}
				}

				// 신규 VVD 추가한다.
				tgtVVDs.add(newVVD);
			}
			// 통합된 tgtVVDs 에는 direction이 섞여있을수 있으므로.
			// 예를 들어, W, E, W, E 가 섞여있으면 그룹핑해서 W | E로 표기한다.
			if(tgtVVDs.size()>0){
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

//				int addPortCount = 0;

				for(int i=0; i<portSkdVOs.size(); i++){
					vo = portSkdVOs.get(i);

					//if("A".equals(vo.getSkdCngStsCd()) || "".equals(vo.getPfEtaDt())){
					// PF Estimate Time 이 없으면 Adding Calling으로 간주.
					// SKD_CNG_STS_CD 코드에서 "A"는 신뢰성이 떨어짐.
					if("".equals(vo.getPfEtaDt())){
//						addPortCount++;
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
										vo.getYdCd().equals(tmpPortSkdArr[m].getYdCd())	&&
										vo.getCallYdIndSeq().equals(tmpPortSkdArr[m].getCallYdIndSeq()) // CHM-201108759-01 // Long Range Inquiry 화면에서 조회시 VVD내 같은 Yard(double calling)에 대해 구분되도록 변경
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
				)
				{
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

		// tmpPortSkdGridData 에서 시간이 역전된 포트를 설정한다. :: REVERSE CALLING PORT 결정 ::
		for(List<PortSkdOnLongRangeVO> vvd : tmpPortSkdGridData){
			String 	firstDirCd = null;
			int 	maxClptSeq = 1;
			
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
				portSkdOnLongRangeVO.getYdCd().equals(pfSkdDetailVO.getYdCd()) &&
				portSkdOnLongRangeVO.getCallYdIndSeq().equals(pfSkdDetailVO.getCallYdIndSeq()) // CHM-201108759-01 // Long Range Inquiry 화면에서 조회시 VVD내 같은 Yard(double calling)에 대해 구분되도록 변경
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

	/**
	 * XML 메시지를 parsing 하고 DBDAO에게 넘겨준다.
	 *
	 * EDI011-0001 : Receive<br>
	 * VesdSettingReceiveJMS<br>
	 * @param  VskCustSkdEdiSetVO[] vskCustSkdEdiSetVOs
	 * @exception EventException
	 */
	public void esdSettingReceiveJMS(VskCustSkdEdiSetVO[] vskCustSkdEdiSetVOs) throws EventException {

		try {
			List<VskCustSkdEdiSetVO> updateVoList = new ArrayList<VskCustSkdEdiSetVO>();
			for ( int i=0; i<vskCustSkdEdiSetVOs.length; i++ ) {
				updateVoList.add(vskCustSkdEdiSetVOs[i]);
			}
			//EAI 전송된 데이타 업데이트 & 인서트
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEsdSettingReceiveJMS(updateVoList);
				dbDao.addEsdSettingReceiveJMS(updateVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039", new String[]{"", ""}).getMessage(), ex);
		}
	}

	/**
	 * VVD 삭제 history를 남긴다.
	 *
	 * @param VskVslSkdHisVO vskVslSkdHisVO
	 * @exception EventException
	 */
	private void addVskVslSkdDelHis(VskVslSkdHisVO vskVslSkdHisVO) throws EventException {
		try{
			dbDao.addVskVslSkdDelHis(vskVslSkdHisVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	/**
	 * Actual SKD 삭제에 따른 Vessel Port Schedule 정보를 변경한다.
	 *
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @exception EventException
	 */
	public void modifyVskVslPortSkdByActSkdDelelet(List<VskVslPortSkdVO> vskVslPortSkdVOs) throws EventException {
		try{
			dbDao.modifyVskVslPortSkdByActSkdDelete(vskVslPortSkdVOs);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/*
	 * CHM-201007135-01
	*/
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
	 * PF 선택시 삭제된 yard가 존재하는지 check한다.
	 * @param String vslSlanCd
	 * @param String pfSvcTpCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> checkDeltYardByPF(String vslSlanCd, String pfSvcTpCd) throws EventException {
		try{
			return dbDao.checkDeltYardByPF(vslSlanCd, pfSvcTpCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}


	/**
	 * [VOP_VSK_0095]
	 * ERP로 전송 할 VVD SKD 목록을 조회<br>
	 *
	 * @param VslSkdRepeatErpIfVO vslSkdRepeatErpIfVO
	 * @return List<VslSkdRepeatErpIfVO>
	 * @exception EventException
	 */
	public List<VslSkdRepeatErpIfVO> searchVslSkdRepeatErpIf(VslSkdRepeatErpIfVO vslSkdRepeatErpIfVO) throws EventException {
		
		try {
			
			String sVvdDeletedYn	= vslSkdRepeatErpIfVO.getColumnValues().get("vvd_deleted_yn");
			
			//log.info("\n\n :::===== jskjskjsk ======= :::vvd_deleted_yn>> ["+sVvdDeletedYn+"]");
			
			//Deleted VVD
			if("Y".equals(sVvdDeletedYn)){
				
				return dbDao.searchDeletedVslSkdRepeatErpIf	(vslSkdRepeatErpIfVO);
				
			//Live VVD
			}else{
				return dbDao.searchVslSkdRepeatErpIf		(vslSkdRepeatErpIfVO);	
			}
			
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * [VOP_VSK_0095] I/F to ERP<br>
	 * 선택된 VVD SKD 목록을 ERP로 전송<br>
	 *
	 * @param VvdVO vvdVO
	 * @exception EventException
	 */
	public void sendVslSkdRepeatErpIf(VvdVO vvdVO) throws EventException {
		// **********************************************************
		// * sendVslSkdErpIf 메서드와 동일한 로직이므로 수정시 유의
		// **********************************************************
		try {
			if (vvdVO != null) {
				List<ErpMsgFns017VO> list = dbDao.searchErpIfSendingData(vvdVO);

				if (list.size() > 0) {
					String reString = sendVslSkdErpIf2(list);
					String[] res = new String[]{"", ""};

					if (reString!=null && reString.indexOf(":")>-1) {
						res = reString.split(":");
					}

					// 전문 SEQ 조회
					String vskdEdiSndId = dbDao.searchEdiHdSeqToKlnet();
					VskCustEdiLogVO vskCustEdiLogVO = new VskCustEdiLogVO();
					vskCustEdiLogVO.setCustTrdPrnrId("FNS017-RESEND");   // ****************
					if (res[1]!=null && res[1].length()>0) {
						vskCustEdiLogVO.setVskdEdiSndId(res[1]);
					} else {
						vskCustEdiLogVO.setVskdEdiSndId(vskdEdiSndId);
					}
					vskCustEdiLogVO.setN1stVslCd(vvdVO.getVslCd());
					vskCustEdiLogVO.setN1stSkdVoyNo(vvdVO.getSkdVoyNo());
					vskCustEdiLogVO.setN1stSkdDirCd(vvdVO.getSkdDirCd());
					vskCustEdiLogVO.setCreUsrId(vvdVO.getCreUsrId() == null ? " " : vvdVO.getCreUsrId());
					vskCustEdiLogVO.setUpdUsrId(vvdVO.getUpdUsrId() == null ? " " : vvdVO.getUpdUsrId());
					vskCustEdiLogVO.setDiffRmk(res[0]);
					dbDao.addVskCustEdiLogToDLS(vskCustEdiLogVO);
				}
			}

		} catch (DAOException ex) {
			if(ex.toString().indexOf("FRM10501")>-1 || ex.toString().indexOf("TimedOutException")>-1){
				// TimeOutException 이 발생하면 Framework에서 FRM10501 Exception을 발생한다.
				throw new EventException(new ErrorHandler("VSK10076").getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	

	/**
	 * [VOP_VSK_0015]
	 * Port Tariff Calculation >> Surcharge/Discount Exist Checking<br>
	 * @param List<VvdPortTariffVO> vvdPortTariffVOs
	 * @return List<VvdPortTariffVO>
	 * @exception EventException
	 */
	public List<VvdPortTariffVO> checkPortTariffSurchargeDiscountExistList(List<VvdPortTariffVO> vvdPortTariffVOs) throws EventException {
		
		String					sRtnalue	= "";
		List<VvdPortTariffVO>	rtnList		= new ArrayList<VvdPortTariffVO>();
		
		try {
				
			for(VvdPortTariffVO tmpVO : vvdPortTariffVOs){
				sRtnalue	= dbDao.searchPortTariffSurchargeDiscountExist	(tmpVO);
				
				tmpVO.setPortSurOrDcExistYn( "".equals(sRtnalue)||sRtnalue==null ? "N" : "Y" );
				
				log.debug("\n ============ getVpsPortCd ["+tmpVO.getVpsPortCd()+"]");
				log.debug("\n ============ getClptIndSeq ["+tmpVO.getClptIndSeq()+"]");
				log.debug("\n ============ getYdCd ["+tmpVO.getYdCd()+"]");
				log.debug("\n ============ getYdTtlUsdAmt ["+tmpVO.getYdTtlUsdAmt()+"]");
				//log.debug("\n ============ xxxx ["+xxx+"]");
				//log.debug("\n ============ xxxx ["+xxx+"]");
				//log.debug("\n ============ xxxx ["+xxx+"]");
				//log.debug("\n ============ xxxx ["+xxx+"]");
				//log.debug("\n ============ xxxx ["+xxx+"]");
						
				
				rtnList.add(tmpVO);
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return rtnList;
	}
	
	
	
	
	
	
	/**
	 * Vessel Schedule 변경이력관리<br>
	 *
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @param List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs
	 * @param String sFromEventSystem
	 * @exception EventException
	 */
	public void createVesselScheduleChangeHistory(List<VskVslSkdVO> vskVslSkdVOs, List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs, String sFromEventSystem) throws EventException {
		
		try{
		
			/******************************************************************************
			 * Change Notification Back End Job 처리
			 */
			this.createVesselScheduleChangeHistoryBackEndJob(vskVslSkdVOs, vslSkdCngHisDtlVOs, sFromEventSystem);

		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	
	}
	
	/**
	 * Vessel Schedule 변경이력관리<br>
	 *
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @param List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs
	 * @param String sFromEventSystem
	 * @return String
	 * @exception EventException
	 */
	public String createVesselScheduleChangeHistoryBackEndJob(List<VskVslSkdVO> vskVslSkdVOs, List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs, String sFromEventSystem) throws EventException {
		
		VesselScheduleCngHistCreationNotificationBackEndJob 	cngHistNtfcBackEndJob	= new VesselScheduleCngHistCreationNotificationBackEndJob();
		BackEndJobManager 										backEndJobManager 		= new BackEndJobManager();
		
		try {
			
			if(vskVslSkdVOs == null || vskVslSkdVOs.size() == 0)	return null;
			
			cngHistNtfcBackEndJob.setVslSkdVOs			(vskVslSkdVOs		);
			cngHistNtfcBackEndJob.setVslSkdCngHisDtlVOs	(vslSkdCngHisDtlVOs	);
			cngHistNtfcBackEndJob.setFromEventSystem	(sFromEventSystem	);
			
			return backEndJobManager.execute(cngHistNtfcBackEndJob, "VSK_2007816", "manageVslSkdCngHistCreationNotification");

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	
	}
	
	/**
	 * History 대상 건을 찾아 해당 테이블에 저장한다.
	 *
	 * @param List<VslSkdHisInVO> vslSkdHisInVOs
	 * @return List<VslSkdCngHisDtlVO>
	 * @exception EventException
	 */
//	private List<VslSkdCngHisDtlVO> makeVslSkdChgHisDtlDataSet(List<VslSkdHisInVO> vslSkdHisInVOs) throws EventException {
//		
//		List<VslSkdCngHisDtlVO>	rtnVslSkdCngHisDtlVOs			= new ArrayList<VslSkdCngHisDtlVO>	();
//		
//		try{
//			
//			if(vslSkdHisInVOs != null && vslSkdHisInVOs.size() > 0){
//				List<CstSkdByVvdVO> orgPortVoList = null;		//화면에서 변경되기 전의 Port List
//
//				String 	sTmpPreVvdCd 		= "";	//이전 VVD
//				String 	sTmpCurVvdCd 		= "";	//현재 VVD
//
//				String 	sVslCd 				= "";
//				String 	sSkdVoyNo 			= "";
//				String 	sSkdDirCd 			= "";
//				String 	sVpsPortCd 			= "";
//				
//				for(VslSkdHisInVO vslSkdHisInVO : vslSkdHisInVOs){
//					
//					///////////////////////////////////////////////////////////////////////////
//					int	iHisDtlTargetKnt	= 0;	//1이 되면 Next VO로 이동한다.
//					VslSkdCngHisDtlVO	tmpVslSkdCngHisDtlVO	= new VslSkdCngHisDtlVO();
//					///////////////////////////////////////////////////////////////////////////
//
//					//VVD 코드
//					sVslCd 				= vslSkdHisInVO.getVslCd	();
//					sSkdVoyNo 			= vslSkdHisInVO.getSkdVoyNo	();
//					sSkdDirCd 			= vslSkdHisInVO.getSkdDirCd	();
//					sVpsPortCd 			= vslSkdHisInVO.getVpsPortCd();
//
//					VslPortSkdVO paramVO 	= new VslPortSkdVO();
//					paramVO.setVslCd		(sVslCd		);
//					paramVO.setSkdVoyNo		(sSkdVoyNo	);
//					paramVO.setSkdDirCd		(sSkdDirCd	);
//					paramVO.setVpsPortCd	(sVpsPortCd	);
//					paramVO.setClptIndSeq	(vslSkdHisInVO.getClptIndSeq());
//
//					sTmpCurVvdCd 		= sVslCd + sSkdVoyNo + sSkdDirCd;
//
//					// VVD 가 여러 건일 수 있으므로.
//					if(!sTmpPreVvdCd.equals(sTmpCurVvdCd)){
//						sTmpPreVvdCd = sTmpCurVvdCd;
//
//						// 해당 VVD의 변경되기전의 Port 정보를 조회한다.
//						CstSkdByVvdVO orgParamVO = new CstSkdByVvdVO();
//						orgParamVO.setVslCd		(sVslCd);
//						orgParamVO.setSkdVoyNo	(sSkdVoyNo);
//						orgParamVO.setSkdDirCd	(sSkdDirCd);
//						orgPortVoList 			= dbDao.searchCstSkdByVvd(orgParamVO);
//
//					}
//
//					CstSkdByVvdVO orgPortVO = null;
//
//					//해당 Skip 된 변경 전의 Port 정보를 찾는다.
//					if(orgPortVoList != null && orgPortVoList.size() > 0){
//						for(CstSkdByVvdVO cstSkdByVvdVO : orgPortVoList){
//							if(		vslSkdHisInVO.getVpsPortCd().equals(cstSkdByVvdVO.getVpsPortCd())
//								&&	vslSkdHisInVO.getClptIndSeq()!= null
//								&&	vslSkdHisInVO.getClptIndSeq().equals(cstSkdByVvdVO.getClptIndSeq()))
//							{
//
//								orgPortVO = cstSkdByVvdVO;
//								break;
//							}
//						}
//					}
//
//					/** VESSEL SCHEDULE CHANGE/CREATION TYPE CODE **
//					 * VSK_VSL_SKD_CNG_HIS_DTL.VSKD_TML_CNG_TP_CD V1
//					 * - sVslSkdTmlCngTpCd
//					 * ----------------------------------------------
//					 * 'N' : 최초생성.
//					 * ----------------------------------------------
//					 * 'U' : Normal UPDATE 
//					 * 'S' : Port SKIP
//					 * 'I' : Phase IN
//					 * 'O' : Phase OUT
//					 * 'D' : Port Delete
//					 * 'E' : ETA, ETB, ETD 변경
//					 * 'Y' : YARD(Terminal) 변경
//					 * 'P' : PORT의 Calling Indicator Seq.(CLPT_IND_SEQ) 변경
//					 * 'R' : REVERSE Call
//					 * ---------------------------------------------
//					 * 'A' : ADD Call
//					 * 'T' : AUTO UPDATE (by Acctual Schedule)
//					 * ---------------------------------------------
//					 */
//					if(orgPortVO != null){
//						
//						//***** 'S' : Port Skip() *****
//						//기존 데이타가 Skip 이 아니었고
//						if(!"S".equals(orgPortVO.getSkdCngStsCd()) && iHisDtlTargetKnt == 0){
//							//새로 입력된 데이타가 Skip 이면
//							if("S".equals(vslSkdHisInVO.getSkdCngStsCd())){
//
//								/*************************************************************************
//								 * Vessel Schedule Change History Detial VO 생성
//								 * -----------------------------------------------------------------------
//								 * PORT SKIP : "S"
//								 *************************************************************************
//								 */					
//								tmpVslSkdCngHisDtlVO.setVslCd			(sVslCd							);
//								tmpVslSkdCngHisDtlVO.setSkdVoyNo		(sSkdVoyNo						);
//								tmpVslSkdCngHisDtlVO.setSkdDirCd		(sSkdDirCd						);
//								tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
//								tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
//								tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("S"							);
//								
//								iHisDtlTargetKnt++;
//								/*************************************************************************
//								 */
//								
//							}
//						}
//
//						/*
//						 * Orginal SKD 이 Skip 이지만, 화면에서 Skip Call Cancel 일 경우.
//						 *
//						 */
//						if("S".equals(orgPortVO.getSkdCngStsCd()) && iHisDtlTargetKnt == 0){
//							//새로 입력된 데이타가 Skip Cancel이면
//							if("".equals(vslSkdHisInVO.getSkdCngStsCd())){
//
//								/*************************************************************************
//								 * Vessel Schedule Change History Detial VO 생성
//								 * -----------------------------------------------------------------------
//								 * PORT SKIP CANCEL : "X"
//								 *************************************************************************
//								 */					
//								tmpVslSkdCngHisDtlVO.setVslCd			(sVslCd							);
//								tmpVslSkdCngHisDtlVO.setSkdVoyNo		(sSkdVoyNo						);
//								tmpVslSkdCngHisDtlVO.setSkdDirCd		(sSkdDirCd						);
//								tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
//								tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
//								tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("X"							);
//								
//								iHisDtlTargetKnt++;
//								/*************************************************************************
//								 */	
//								
//							}
//						}
//
//						//***** 'O' : Phase Out *****
//						if("O".equals(vslSkdHisInVO.getSkdCngStsCd()) && iHisDtlTargetKnt == 0){
//							
//							/*************************************************************************
//							 * Vessel Schedule Change History Detial VO 생성
//							 * -----------------------------------------------------------------------
//							 * PORT PHASE-OUT : "O"
//							 *************************************************************************
//							 */					
//							tmpVslSkdCngHisDtlVO.setVslCd			(sVslCd							);
//							tmpVslSkdCngHisDtlVO.setSkdVoyNo		(sSkdVoyNo						);
//							tmpVslSkdCngHisDtlVO.setSkdDirCd		(sSkdDirCd						);
//							tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
//							tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
//							tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("O"							);
//							
//							iHisDtlTargetKnt++;
//							/*************************************************************************
//							 */		
//							
//						}
//
//						//***** 'T' : Port 삭제 *****
///*						if("D".equals(vslSkdHisInVO.getIbflag()) && iHisDtlTargetKnt == 0){
//							
//							String vskdCngTpCd	= null;
//							if(VSKGeneralUtil.isVirtualPort(vslSkdHisInVO.getTurnPortIndCd()))
//								vskdCngTpCd		= "D";	// Virtual Port 삭제인 경우 Code 를 구분
//							else
//								vskdCngTpCd		= "T";	
//							
//							*//*************************************************************************
//							 * Vessel Schedule Change History Detial VO 생성
//							 * -----------------------------------------------------------------------
//							 * NORMAL/TURNING PORT DELETION : "T"
//							 * VIRTUAL 		  PORT DELETION : "D"
//							 *************************************************************************
//							 *//*					
//							tmpVslSkdCngHisDtlVO.setVslCd			(sVslCd							);
//							tmpVslSkdCngHisDtlVO.setSkdVoyNo		(sSkdVoyNo						);
//							tmpVslSkdCngHisDtlVO.setSkdDirCd		(sSkdDirCd						);
//							tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
//							tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq()	);
//							tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	(vskdCngTpCd					);
//							
//							iHisDtlTargetKnt++;
//							*//*************************************************************************
//							 *//*	
//							
//						}*/
//						
//						//***** 'Y' : YARD 변경 *****
//						if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getYdCd()) && iHisDtlTargetKnt == 0){
//							if(!vslSkdHisInVO.getYdCd().equals(orgPortVO.getYdCd())){
//								
//								/*************************************************************************
//								 * Vessel Schedule Change History Detial VO 생성
//								 * -----------------------------------------------------------------------
//								 * TERMINAL(YARD) CHANGE : "Y"
//								 *************************************************************************
//								 */					
//								tmpVslSkdCngHisDtlVO.setVslCd			(sVslCd							);
//								tmpVslSkdCngHisDtlVO.setSkdVoyNo		(sSkdVoyNo						);
//								tmpVslSkdCngHisDtlVO.setSkdDirCd		(sSkdDirCd						);
//								tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
//								tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
//								tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("Y"							);
//								
//								tmpVslSkdCngHisDtlVO.setBfrYdCd			(orgPortVO.getYdCd			()	);
//								
//								iHisDtlTargetKnt++;
//								/*************************************************************************
//								 */	
//								
//							}
//						}
//
//						//***** 'P' : PORT의 CALLING SEQUENCE 변경 *****
//						//8. Call Indicator Seq. 변경 "72" ::정상기::bkg-vsk-sce-prd::2013-03-19//
//						if(!vslSkdHisInVO.getClptIndSeq().equals(vslSkdHisInVO.getNewClptIndSeq()) && iHisDtlTargetKnt == 0){
//							
//							/*************************************************************************
//							 * Vessel Schedule Change History Detial VO 생성
//							 * -----------------------------------------------------------------------
//							 * CALLING PORT INDICATOR SEQUENCE CHANGE : "P"
//							 *************************************************************************
//							 */					
//							tmpVslSkdCngHisDtlVO.setVslCd				(sVslCd							);
//							tmpVslSkdCngHisDtlVO.setSkdVoyNo			(sSkdVoyNo						);
//							tmpVslSkdCngHisDtlVO.setSkdDirCd			(sSkdDirCd						);
//							tmpVslSkdCngHisDtlVO.setVpsPortCd			(vslSkdHisInVO.getVpsPortCd	()	);
//							tmpVslSkdCngHisDtlVO.setClptIndSeq			(vslSkdHisInVO.getNewClptIndSeq()	);
//							tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd		("P"							);
//							
//							tmpVslSkdCngHisDtlVO.setPairRvsPortCd		(orgPortVO.getVpsPortCd		()	);
//							tmpVslSkdCngHisDtlVO.setPairRvsClptIndSeq	(vslSkdHisInVO.getClptIndSeq()	);
//							
//							iHisDtlTargetKnt++;
//							/*************************************************************************
//							 */	
//						
//						}
//						
//						if(iHisDtlTargetKnt == 0){
//							
//							/*************************************************************************
//							 * Vessel Schedule Change History Detial VO 생성
//							 * -----------------------------------------------------------------------
//							 * NORMAL
//							 *************************************************************************
//							 */					
//							tmpVslSkdCngHisDtlVO.setVslCd			(sVslCd							);
//							tmpVslSkdCngHisDtlVO.setSkdVoyNo		(sSkdVoyNo						);
//							tmpVslSkdCngHisDtlVO.setSkdDirCd		(sSkdDirCd						);
//							tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
//							////tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq()	);
//							tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq());
//							tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("U"							);
//							
//							iHisDtlTargetKnt++;
//							/*************************************************************************
//							 */	
//							
//							
//							//log.info("\n\n ================ ::jskjskjskjsk:: iHisDtlTargetKnt ================== \n");
//							//log.info("\n\n ================ ::jskjskjskjsk:: sVslCd ["+sVslCd+"]\n");
//							//log.info("\n\n ================ ::jskjskjskjsk:: sSkdVoyNo ["+sSkdVoyNo+"]\n");
//							//log.info("\n\n ================ ::jskjskjskjsk:: sSkdDirCd ["+sSkdDirCd+"]\n");
//							//log.info("\n\n ================ ::jskjskjskjsk:: getVpsPortCd ["+vslSkdHisInVO.getVpsPortCd	()+"]\n");
//							//log.info("\n\n ================ ::jskjskjskjsk:: getClptIndSeq ["+vslSkdHisInVO.getClptIndSeq()+"]\n");
//							//log.info("\n\n ================ ::jskjskjskjsk:: getNewClptIndSeq ["+vslSkdHisInVO.getNewClptIndSeq()+"]\n");
//							//log.info("\n\n ================ ::jskjskjskjsk:: getSkdCngStsCd ["+vslSkdHisInVO.getSkdCngStsCd()+"]\n");
//							
//							//log.info("\n\n ================ ::jskjskjskjsk:: =================================== \n");
//							
//							
//							
//						}
//						
//					}else{
//						
//						/*************************************************************************
//						 * Vessel Schedule Change History Detial VO 생성
//						 * -----------------------------------------------------------------------
//						 * ADD CALLING
//						 *************************************************************************
//						 */					
//						tmpVslSkdCngHisDtlVO.setVslCd			(sVslCd							);
//						tmpVslSkdCngHisDtlVO.setSkdVoyNo		(sSkdVoyNo						);
//						tmpVslSkdCngHisDtlVO.setSkdDirCd		(sSkdDirCd						);
//						tmpVslSkdCngHisDtlVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
//						////tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq()	);
//						tmpVslSkdCngHisDtlVO.setClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq());
//						tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd	("A"							);
//						
//						iHisDtlTargetKnt++;
//						/*************************************************************************
//						 */
//						
//						
//						//log.info("\n\n ================ ::jskjskjskjsk:: orgPortVO is null ================== \n");
//						//log.info("\n\n ================ ::jskjskjskjsk:: sVslCd ["+sVslCd+"]\n");
//						//log.info("\n\n ================ ::jskjskjskjsk:: sSkdVoyNo ["+sSkdVoyNo+"]\n");
//						//log.info("\n\n ================ ::jskjskjskjsk:: sSkdDirCd ["+sSkdDirCd+"]\n");
//						//log.info("\n\n ================ ::jskjskjskjsk:: getVpsPortCd ["+vslSkdHisInVO.getVpsPortCd	()+"]\n");
//						//log.info("\n\n ================ ::jskjskjskjsk:: getClptIndSeq ["+vslSkdHisInVO.getClptIndSeq()+"]\n");
//						//log.info("\n\n ================ ::jskjskjskjsk:: getNewClptIndSeq ["+vslSkdHisInVO.getNewClptIndSeq()+"]\n");
//						//log.info("\n\n ================ ::jskjskjskjsk:: getSkdCngStsCd ["+vslSkdHisInVO.getSkdCngStsCd()+"]\n");
//						
//						//log.info("\n\n ================ ::jskjskjskjsk:: =================================== \n");
//					}
//					/********** END OF VO is Not Null "orgPortVO" **********/
//						
//						
//
//					
//					
//					////////////////////////// 2013-08-03 Vessel Schedule Change History Detail 관리를 위한 VO(VslSkdCngHisDtlVO) 생성 /////////////
//					////////////////////////// None Unassigned Booking - Vessel Schedule List //////////////////////////////////////////////////
//
//					rtnVslSkdCngHisDtlVOs.add(tmpVslSkdCngHisDtlVO);
//					
//				}
//				/*******************************************************
//				 * For Loop Statement END for vslSkdHisInVOs
//				 *******************************************************
//				 */
//				
//			}
//			
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
//		return rtnVslSkdCngHisDtlVOs;
//	}
	
	
	

	/**
	 * Vessel Schedule Delete History 관리(Header Only)<br>
	 *
	 * @param List<VskVslSkdVO> VskVslSkdVOs
	 * @param String sFromEventSystem
	 * @exception EventException
	 */
	public void createVskVslSkdChangeHistoryMstOnly(List<VskVslSkdVO> vskVslSkdVOs, String sFromEventSystem) throws EventException {
		
		try {
			
			if(vskVslSkdVOs == null || vskVslSkdVOs.size() == 0)	return;
			
			String			sCnvtHisCreUserId	= null;
			String			sCnvtVslSkdCngTpCd	= null;
			String			sSkdHisDesc			= null;
			StringBuffer	sbTmpDesc			= new StringBuffer("");
			
			/***************************************************************************************
			 * vslSkdCngHisDtlVOs is NULL		: Normal 이력데이터 생성
			 * vslSkdCngHisDtlVOs is NOT NULL	: Vessel Schedule History "VO"를 이용한 이력데이터 생성
			 */
			
			/**
			 *                				::CREATION/UPDATE 	::UI ID + UI NAME						::BC.Method Name
			 * --------------------------------------------------------------------------------------
			 * DELETE_LRS_DeletedGroupVVD_NoneBKG(VOP_VSK_0010)			: DELETE	: VOP_VSK_0010 (LRS SKD CREATION)			::removeCstSkdByVvd.removeCstSkdByVvd
			 * DELETE_LRS_DeletedGroupVVD_OnBKG(VOP_VSK_0010)			: 			
			 * DELETE_LRS_Feeder_DeletedGroupVVD_NoneBKG(VOP_VSK_0054) 	: DELETE	: VOP_VSK_0054 (LRS SKD CREATION-CCA)		::removeCstSkdByVvd.removeCstSkdByVvd
			 * DELETE_LRS_Feeder_DeletedGroupVVD_OnBKG(VOP_VSK_0054)	: 
			 * 
			 * DELETE_CST_DeletionVvd_NoneBKG(VOP_VSK_0018)				: DELETE	: VOP_VSK_0018 (VSL SKD Deletion/Closing)	::removeCstSkdByVvd.removeCstSkdByVvd
			 * DELETE_CST_DeletionVvd_OnBKG(VOP_VSK_0018)				: 
			 * DELETE_CST_Feeder_DeletionVvd_NoneBKG(VOP_VSK_0059)		: DELETE	: VOP_VSK_0059 (VSL SKD Deletion/Closing)	::removeCstSkdByVvd.removeCstSkdByVvd
			 * DELETE_CST_Feeder_DeletionVvd_OnBKG(VOP_VSK_0059)		: 
			 * DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)	: DELET		: VOP_VSK_0018.VOP_VSK_0249
			 * --------------------------------------------------------------------------------------
			 * DELETE_CST_ByVvd(0014/0015/0057/0058)					: DELETE			VOP_VSK_0015 (COSTAL SKD UPDATE)		::removeCstSkdByVvd.removeCstSkdByVvd
			 * --------------------------------------------------------------------------------------
			 * ACTIVATE_ByVvd				: UPDATE			VOP_VSK_0018 (VSL SKD Deletion/Closing)	::manageSkdActivate
			 * MODIFY_VvdStatusChange		: UPDATE			VOP_VSK_0018 (VSL SKD Deletion/Closing)	::modifyVslSkdListByLane
			 * MODIFY_VvdProformaType		: UPDATE			VOP_VSK_0018 (VSL SKD Deletion/Closing)	::manageVvdPf
			 * --------------------------------------------------------------------------------------
			 */
			
			String	sCurTime		= new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(System.currentTimeMillis()));
			String	sCarriageReturn	= "\n";
			
			if("DELETE_LRS_DeletedGroupVVD_NoneBKG(VOP_VSK_0010)".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "LRS_(VOP_VSK_0010)";
				sCnvtVslSkdCngTpCd	= "D";		//DELETE//
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("DEL TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : Long Range SKD Creation (VOP_VSK_0010)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("RMK : NONE BOOKING ATTACHED VVD");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
			}else if("DELETE_LRS_DeletedGroupVVD_OnBKG(VOP_VSK_0010)".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "LRS_(VOP_VSK_0010)";
				sCnvtVslSkdCngTpCd	= "D";		//DELETE//
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("DEL TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : Long Range SKD Creation (VOP_VSK_0010)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("RMK : BOOKING ATTACHED VVD");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
			}else if("DELETE_LRS_Feeder_DeletedGroupVVD_NoneBKG(VOP_VSK_0054)".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "LRS_(VOP_VSK_0054)";
				sCnvtVslSkdCngTpCd	= "D";		//DELETE//
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("DEL TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : Long Range SKD Creation (CCA) (VOP_VSK_0054)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("RMK : NONE BOOKING ATTACHED VVD");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
			}else if("DELETE_LRS_Feeder_DeletedGroupVVD_OnBKG(VOP_VSK_0054)".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "LRS_(VOP_VSK_0054)";
				sCnvtVslSkdCngTpCd	= "D";		//DELETE//
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("DEL TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : Long Range SKD Creation (CCA) (VOP_VSK_0054)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("RMK : BOOKING ATTACHED VVD");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("DELETE_CST_DeletionVvd_NoneBKG(VOP_VSK_0018)".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "NoBKG_(VOP_VSK_0018)";
				sCnvtVslSkdCngTpCd	= "D";		//DELETE//
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("DEL TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Delete/Closing (VOP_VSK_0018)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("RMK : NONE BOOKING ATTACHED VVD");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("DELETE_CST_DeletionVvd_OnBKG(VOP_VSK_0018)".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "OnBKG_(VOP_VSK_0018)";
				sCnvtVslSkdCngTpCd	= "D";		//DELETE//

				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("DEL TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Delete/Closing (VOP_VSK_0018)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("RMK : BOOKING ATTACHED VVD");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("DELETE_CST_Feeder_DeletionVvd_NoneBKG(VOP_VSK_0059)".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "NoBKG_(VOP_VSK_0059)";
				sCnvtVslSkdCngTpCd	= "D";		//DELETE//
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("DEL TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Delete/Closing(CCA) (VOP_VSK_0059)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("RMK : NONE BOOKING ATTACHED VVD");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
			}else if("DELETE_CST_Feeder_DeletionVvd_OnBKG(VOP_VSK_0059)".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "NoBKG_(VOP_VSK_0059)";
				sCnvtVslSkdCngTpCd	= "D";		//DELETE//
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("DEL TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Delete/Closing(CCA) (VOP_VSK_0059)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("RMK : BOOKING ATTACHED VVD");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);				
				
			}else if("DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "OnBKG_(VOP_VSK_0249)";
				sCnvtVslSkdCngTpCd	= "D";		//DELETE//
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("DEL TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Delete/Closing > [popup] > VSL SKD Delete Information(VOP_VSK_0249)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("RMK : BOOKING ATTACHED VVD for Normal/Turning Port");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);	
				
			//================================================================================================
				
			}else if("DELETE_CST_ByVvd(0014/0015/0057/0058)".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "CST_(_0014/15/57/58)";
				sCnvtVslSkdCngTpCd	= "D";		//DELETE//
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("DEL TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : Costal Schedule Update or CCA (VOP_VSK_0014/0015/0057/0058)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			//================================================================================================
				
			}else if("ACTIVATE_ByVvd".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "ACTVT_(VOP_VSK_0018)";
				sCnvtVslSkdCngTpCd	= "A";		//ACTIVATE//
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Delete/Closing (VOP_VSK_0018)");
				sbTmpDesc.append("RMK : ACTIVATE OR INACTIVATE VVD");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("MODIFY_VvdStatusChange".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "MfyST_(VOP_VSK_0018)";
				sCnvtVslSkdCngTpCd	= "M";		//VVD STATUS MODIFY//	
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Delete/Closing (VOP_VSK_0018)");
				sbTmpDesc.append("RMK : HOLDING OR REOPEN VVD");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("MODIFY_VvdProformaType".equals(sFromEventSystem)){
				sCnvtHisCreUserId	= "MfyPf_(VOP_VSK_0018)";
				sCnvtVslSkdCngTpCd	= "F";		//PROFORMA TYPE MODIFY//
				
				sbTmpDesc.append(" === Vessel Schedule HISTORY CREATION (MASTER ONLY) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Delete/Closing (VOP_VSK_0018)");
				sbTmpDesc.append("RMK : PROFORMA TYPE MODIFICATION");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else{
				sCnvtHisCreUserId	= "NO_ACCOUNT_USER_ID";
				sCnvtVslSkdCngTpCd	= "";
			}
			
			sSkdHisDesc				= sbTmpDesc.toString();
			
			/* ============================================================================
			 * Vessel Schedule History 관리(Header) Started ::2013-06-18::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * 1. VSK_VSL_SKD_CNG_HIS   "Only"
			 * ----------------------------------------------------------------------------
			 * VSK_VSL_SKD_CNG_HIS 		: INSERT
			 * ============================================================================
			 */
					
			/** VESSEL SCHEDULE CHANGE/CREATION TYPE CODE **
			 * VSK_VSL_SKD_CNG_HIS.VSKD_CNG_TP_CD V1
			 * - sVslSkdCngTpCd
			 * ------------------------------------------------------
			 * 'N' : Vessel Schedule 최초생성. 
			 * ------------------------------------------------------
			 * 'U' : Normal UPDATE
			 * 'S' : Port SKIP
			 * 'O' : Phase OUT
			 * 'V' : VVD DELETE
			 * 'L' : Lane 변경
			 * 'E' : ETA, ETB, ETD
			 * 'Y' : YARD 변경
			 * 'P' : PORT의 Calling Indicator Seq.(CLPT_IND_SEQ) 변경
			 * ------------------------------------------------------
			 * 'A' : Activate
			 * 'T' : Auto Update (by Actual Schedule)
			 * ------------------------------------------------------
			 * 'M' : Holding/Turning Port INSERT
			 * 'I' : Normal/Turning Port INSERT
			 * 'J' : Virtual Port INSERT
			 * 'F' : Proforma Type Update
			 * ------------------------------------------------------
			 */

			List<VslSkdCngHisVO>		tmpVslSkdCngHisVOs	= new ArrayList<VslSkdCngHisVO>();
			for(VskVslSkdVO vskVslSkdVO : vskVslSkdVOs){
				VslSkdCngHisVO			tmpVO	= new VslSkdCngHisVO();
				tmpVO.setVslCd			(vskVslSkdVO.getVslCd	()	);
				tmpVO.setSkdVoyNo		(vskVslSkdVO.getSkdVoyNo()	);
				tmpVO.setSkdDirCd		(vskVslSkdVO.getSkdDirCd()	);
				tmpVO.setVskdCngTpCd	(sCnvtVslSkdCngTpCd			);
				tmpVO.setHisCreUsrId	(sCnvtHisCreUserId			);
				tmpVO.setSkdHisDesc		(sSkdHisDesc				);
				
				tmpVslSkdCngHisVOs.add	(tmpVO);
			}
			
			dbDao.createVskVslSkdChangeHistoryMstOnly(tmpVslSkdCngHisVOs);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	} 
	
	/**
	 * Yard Code 정보로 Yard Name을 조회합니다.
	 * @param ydcd
	 * @return
	 * @throws EventException
	 */
	public String searchYardName(String ydCd) throws EventException {
		try {
			return dbDao.searchYardName(ydCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Yard Name"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Yard Name"}).getMessage(), ex);
		}
	}
	
//	/**
//	 * XML 메시지를 parsing 하고 DBDAO에게 넘겨준다.
//	 *
//	 * EDI011-0001 : Receive<br>
//	 * VesdSettingReceiveJMS<br>
//	 * @param  VskCustSkdEdiSetVO[] vskCustSkdEdiSetVOs
//	 * @exception EventException
//	 */
//	public void esdSettingReceiveJMS(VskCustSkdEdiSetVO[] vskCustSkdEdiSetVOs) throws EventException {
//
//		try {
//			List<VskCustSkdEdiSetVO> updateVoList = new ArrayList<VskCustSkdEdiSetVO>();
//			for ( int i=0; i<vskCustSkdEdiSetVOs.length; i++ ) {
//				updateVoList.add(vskCustSkdEdiSetVOs[i]);
//			}
//			//EAI 전송된 데이타 업데이트 & 인서트
//			if ( updateVoList.size() > 0 ) {
//				dbDao.modifyEsdSettingReceiveJMS(updateVoList);
//				dbDao.addEsdSettingReceiveJMS(updateVoList);
//			}
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039", new String[]{"", ""}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("VSK10039", new String[]{"", ""}).getMessage(), ex);
//		}
//	}
	
	/**
	 * Phase In/Out에 대한 히스토리 정보를 저장
	 *
	 * @param VskVslSkdPhsIoHisVO[] vskVslSkdPhsIoHisVOs
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public void createVslSkdPhaseInOutHistory(VskVslSkdPhsIoHisVO[] vskVslSkdPhsIoHisVOs, SignOnUserAccount account) throws EventException {
		try{
			List<VskVslSkdPhsIoHisVO> updateVoList = new ArrayList<VskVslSkdPhsIoHisVO>();
			for(int i=0; i<vskVslSkdPhsIoHisVOs.length; i++){
				vskVslSkdPhsIoHisVOs[i].setCreUsrId(account.getUsr_id());
				vskVslSkdPhsIoHisVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(vskVslSkdPhsIoHisVOs[i]);

			}
			if(updateVoList.size() > 0){
				dbDao.createVslSkdPhaseInOutHistory(updateVoList);
			}
			
		}catch(DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039", new String[]{"", ""}).getMessage(), ex);
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039", new String[]{"", ""}).getMessage(), ex);
		}
		
	}
}