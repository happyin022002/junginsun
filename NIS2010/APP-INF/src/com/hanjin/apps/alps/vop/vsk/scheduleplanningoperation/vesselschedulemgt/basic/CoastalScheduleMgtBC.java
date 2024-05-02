/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtBC.java
*@FileTitle : VSL SKD Delete & Closing
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.24
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.04 서창열
* 1.0 Creation
*
* History
* 2010.12.08 진마리아 [CHM-201007135-01] Actaul Carrier update 로직 변경 요청건
* 2011.04.11 진마리아 [CHM-201109577-01] Delete Vessel Code에 대한 조회 로직 보완
* 2011.10.26 김민아 [CHM-201114112-01] VSL SKD History Inquiry 화면 로직 변경
* 2012.10.24 진마리아 [CHM-201220527-01] Departure/Noon Report 데이터를 FCM 데이터와 I/F하도록 변경 요청
* 2012.12.12 김상수 [CHM-201221818-01] VVD SKD INTERFACE TO ERP 보완 요청
* 2012.12.18 김상수 [CHM-201221884-01] CNTR 진행기준 대상항차 선정기능 보완
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgListByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalBnkSavVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalTransitTargetVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdBerthWdoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPolPodVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdHisByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdSimDtlCalcInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SkipPortGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VskVslSkdPhsIoHisVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHisDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdRepeatErpIfVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdPortTariffVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskCustSkdEdiSetVO;
import com.hanjin.syscommon.common.table.VskPortDistVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;


/**
 * NIS2010-Scheduleplanningoperation Business Logic Command Interface<br>
 * - NIS2010-Scheduleplanningoperation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SEO CHANG YUL
 * @see
 * @since J2EE 1.4
 */

public interface CoastalScheduleMgtBC {
	/**
	 * 해당 Lane의 Vessel Schedule 리스트 정보를 조회합니다.<br>
	 *
	 * @param ActivationVvdVO activationVvdVO
	 * @return List<ActivationVvdVO>
	 * @exception EventException
	 */
	public List<ActivationVvdVO> searchVslSkdListByLane(ActivationVvdVO activationVvdVO) throws EventException;

	/**
	 * 해당 VVD 스케쥴을 삭제합니다.
	 *
	 * @param ActivationVvdVO[] activationVvdVO1
	 * @param ActivationVvdVO[] activationVvdVO2
	 * @param VskVslSkdHisVO vskVslSkdHisVO
	 * @param SignOnUserAccount account
	 * @param String sFromEventSystem
	 * @exception EventException
	 */
	public void removeCstSkdByVvd(
			ActivationVvdVO[] activationVvdVO1,
			ActivationVvdVO[] activationVvdVO2,
			VskVslSkdHisVO vskVslSkdHisVO,
			SignOnUserAccount account,
			String sFromEventSystem) throws EventException;
	/**
	 * Calling한 Port 정보를 조회합니다.<br>
	 *
	 * @param VvdVO vvdVO
	 * @return SkipPortGRPVO
	 * @exception EventException
	 */
	public SkipPortGRPVO searchCallingPortList(VvdVO vvdVO) throws EventException ;
	/**
	 * 해당 VVD를 사용하는 Booking 정보가 있는지 확인한다.
	 *
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception EventException
	 * @author jinwoo
	 */
	public int checkVvdApplyBooking(VvdVO vvdVO) throws EventException ;
	/**
	 * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
	 *
	 * @param VesselVO vesselVO
	 * @return int
	 * @exception EventException
	 */
	public int checkVslCntr(VesselVO vesselVO) throws EventException ;
	/**
	 * 해당 VVD로 Actual Port Schedule이 입력되여 있는지 확인한다.
	 *
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception EventException
	 * @author jinwoo
	 */
	public int checkVvdActualSkdInput(VvdVO vvdVO) throws EventException ;
	/**
	 * 해당 VVD로 RUSE_PROHI_FLG 값을 확인한다.
	 *
	 * @param VvdVO vvdVO
	 * @return String
	 * @throws EventException
	 */
	public String checkReuseVvd(VvdVO vvdVO) throws EventException ;
	/**
	 * VVD별 Vessel Schedule 정보를 조회합니다.
	 *
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception EventException
	 */
	public List<CstSkdByVvdVO> searchCstSkdByVvd(CstSkdByVvdVO cstSkdByVvdVO) throws EventException ;
	/**
	 * Proforma Schedule 을 조회합니다.<br>
	 *
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception EventException
	 */
	public List<CstSkdByVvdVO> searchCstSkdByPfSkdUse(CstSkdByVvdVO cstSkdByVvdVO) throws EventException ;
	/**
	 * Proforma Schedule 을 조회합니다.<br>
	 *
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @throws EventException
	 */
	public List<SwapCstSkdSimVO> searchCstSkdByPfSkdSim(SwapCstSkdSimVO swapCstSkdSimVO) throws EventException ;
	/**
	 * 변경된 Vessel Port SKD 정보를 변경 및 삭제한다.
	 *
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @throws EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdByVvd(CstSkdByVvdVO[] cstSkdByVvdVOs, SignOnUserAccount account) throws EventException ;
	/**
	 *  Actual SKD 삭제에 따른 Vessel Port Schedule 정보를 변경한다.
	 *
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @throws EventException
	 */
	public void modifyVskVslPortSkdByActSkdDelelet(List<VskVslPortSkdVO> vskVslPortSkdVOs) throws EventException ;
	/**
	 * Simulation Data 를 Coastal Schedule 에 반영한다.
	 *
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @throws EventException
	 */
	public VslSkdChgStsGRPVO manageSettleByVvd(CstSkdByVvdVO[] cstSkdByVvdVOs, SwapCstSkdSimVO swapCstSkdSimVO, SignOnUserAccount account) throws EventException ;
	/**
	 * VVD Remark 정보를 관리합니다.<br>
	 *
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstSkdByRmk(CstSkdByVvdVO cstSkdByVvdVO, SignOnUserAccount account) throws EventException ;
	/**
	 * 변경된 Vessel Port SKD 정보를 변경 및 삭제한다.
	 *
	 * @param SwapCstGRPVO swapCstGRPVO
	 * @return VslSkdChgStsGRPVO
	 * @throws EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdByActual(SwapCstGRPVO swapCstGRPVO) throws EventException ;
	/**
	 * Costal Schedule Simulation 정보를 조회합니다.<br>
	 *
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @exception EventException
	 */
	public List<SwapCstSkdSimVO> searchCstSkdSim(SwapCstSkdSimVO swapCstSkdSimVO) throws EventException ;
	/**
	 * Port의 Costal Schedule 정보를 조회합니다.<br>
	 *
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return VslPortSkdVO
	 * @exception EventException
	 */
	public VslPortSkdVO searchCstSkdByVvdPort(VslPortSkdVO vslPortSkdVO) throws EventException ;
	/**
	 * 해당 Port의 Vessel Berth 정보를 조회합니다.<br>
	 *
	 * @param CstSkdBerthWdoVO cstSkdBerthWdoVO
	 * @return List<CstSkdBerthWdoVO>
	 * @exception EventException
	 */
	public List<CstSkdBerthWdoVO> searchCstSkdBerthWdo(CstSkdBerthWdoVO cstSkdBerthWdoVO) throws EventException ;
	/**
	 * 기간별 Por에 기항하는 Coastal 정보, ETA, ETB, ETD, Next ETA등 기타 정보를 변경한다.
	 *
	 * @param CstSkdBerthWdoVO[] cstSkdBerthWdoVOs
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @throws EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdBerthWdo(CstSkdBerthWdoVO[] cstSkdBerthWdoVOs, SignOnUserAccount account) throws EventException ;
	/**
	 * KTNET EAI 전송합니다.<br>
	 *
	 * @param CstSkdBerthWdoVO[] cstSkdBerthWdoVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String sendEdiToKlNet(CstSkdBerthWdoVO[] cstSkdBerthWdoVOs, SignOnUserAccount account) throws EventException ;
	/**
	 * Coastal SKD Simulation(Recovery Plan)을 관리합니다.<br>
	 *
	 * @param SwapCstSkdSimVO[] swapCstSkdSimVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageCstSkdSim(SwapCstSkdSimVO[] swapCstSkdSimVOs, SignOnUserAccount account) throws EventException ;
	/**
	 * Skip Call 이 발생하는 Port 에 Container 물량 및 기타 비용 정보를 조회하고, 이전, 이후 Port 간 거리 정보등을 조회한다.<br>
	 *
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @throws EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchSkipCallInfo(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException;
	/**
	 * Add Call이 발생하는 Port에 Port 비용 정보를 조회하고, 이전과 자신 그리고, 자신과 이후 Port간 거리 정보등을 조회한다.
	 *
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @throws EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchAddCallInfo(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException;
	/**
	 * Port Charge 를 조회합니다.
	 *
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchPortExpenceByVessel(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException;
	/**
	 * 포트간 거리 정보를 조회합니다.<br>
	 *
	 * @param List<VskPortDistVO> vskPortDistVOs
	 * @return List<VskPortDistVO>
	 * @exception EventException
	 */
	public List<VskPortDistVO> searchVskPortDist(List<VskPortDistVO> vskPortDistVOs) throws EventException ;
	/**
	 * POL, POD에 의한 Costal Schedule 정보를 조회합니다.<br>
	 *
	 * @param CstSkdByPolPodVO cstSkdByPolPodVO
	 * @return List<CstSkdByPolPodVO>
	 * @exception EventException
	 */
	public List<CstSkdByPolPodVO> searchCstSkdByPolPod(CstSkdByPolPodVO cstSkdByPolPodVO) throws EventException ;
	/**
	 * 해당 Port의 Costal Schedule 정보를 조회합니다.<br>
	 *
	 * @param CstSkdByPortVO cstSkdByPortVO
	 * @return List<CstSkdByPortVO>
	 * @exception EventException
	 */
	public List<CstSkdByPortVO> searchCstSkdByPort(CstSkdByPortVO cstSkdByPortVO) throws EventException ;
	/**
	 * 해당 포트의 Time Zone, Manu In/Out, Terminal Productivity, Port Expence를 조회합니다.<br>
	 *
	 * @param SwapCstGRPVO swapCstGRPVO
	 * @return SwapCstSkdSimVO
	 * @exception EventException
	 */
	public SwapCstSkdSimVO searchCstSkdSimBaseInfo(SwapCstGRPVO swapCstGRPVO) throws EventException ;
	/**
	 * Speed 변경 시 필요한 정보를 조회합니다.<br>
	 *
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchBunkerQtyBySpeed(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException ;
	/**
	 * VSL SKD History 정보를 조회해 온다.
	 *
	 * @param VvdPortLaneOtherVO  vvdPortLaneOtherVO
	 * @return List<CstSkdHisByVvdVO>
	 * @exception EventException
	 */
	public List<CstSkdHisByVvdVO> searchCstSkdHisByVvd(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws EventException ;
	/**
	 * CNSHA Port 및 이전 Boud에 기항지 정보를 찾고 Bay Plan이 입력되는 Port를 조회한다.
	 *
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @throws EventException
	 */
	public List<VskVslPortSkdVO> searchBayPlanInputPort(VskVslPortSkdVO vskVslPortSkdVO) throws EventException ;
	/**
	 * 입출항일시 기준으로 최대 선적 화물량을 계산 및 조회
	 *
	 * @param LoadWgtGRPVO loadWgtGRPVO
	 * @return LoadWgtGRPVO
	 * @exception EventException
	 */
	public LoadWgtGRPVO calLoadableWgt(LoadWgtGRPVO loadWgtGRPVO) throws EventException ;

	/**
	 * VVD별 연결되어 있는 Booking List를 조회합니다.
	 *
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<BkgListByVvdVO>
	 * @exception EventException
	 */
	public List<BkgListByVvdVO> searchBkgListByVvd(String vslCd, String skdVoyNo, String skdDirCd) throws EventException;

	/**
	 * 해당 VVD 스케쥴을 수동 Close 처리합니다.
	 *
	 * @param ActivationVvdVO[] activationVvdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslSkdListByLane(ActivationVvdVO[] activationVvdVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 해당 VVD 스케쥴을 Activate 처리합니다.
	 *
	 * @param ActivationVvdVO activationVvdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSkdActivate(ActivationVvdVO activationVvdVO, SignOnUserAccount account) throws EventException;

	/**
	 * 운하별 통항 선박의 스케뷸 및 Surcharge를 조회합니다.
	 *
	 * @param CanalTransitTargetVvdVO canalTransitTargetVvdVO
	 * @return List<CanalTransitTargetVvdVO>
	 * @exception EventException
	 */
	public List<CanalTransitTargetVvdVO> searchCanalTzList(CanalTransitTargetVvdVO canalTransitTargetVvdVO) throws EventException;
	
	/**
	 * 운하의 통항을 위한 운하 Booking 정보를 저장 및 업데이트 한다.
	 *
	 * @param CanalTransitTargetVvdVO[] canalTransitTargetVvdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCanalTzBkg(CanalTransitTargetVvdVO[] canalTransitTargetVvdVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 선박의 최대 선속으로 인한 Bunker 비용과 Canal Surcharge 비용 차이를 조회합니다.
	 *
	 * @param CanalBnkSavVO canalBnkSavVO
	 * @return List<CanalBnkSavVO>
	 * @exception EventException
	 */
	public List<CanalBnkSavVO> calCanalBunkerSaving(CanalBnkSavVO canalBnkSavVO) throws EventException;

	/**
	 * Vessel Port Schedule에 CUD가 발생할 경우 ERP로 변경 정보를 송신
	 *
	 * @param List<VvdVO> erpIfVvdVOs
	 * @exception EventException
	 */
	public void sendVslSkdErpIf(List<VvdVO> erpIfVvdVOs) throws EventException;

	/**
	 * KTNET에게 송신, BKG이 들어오고 이를 (주)한진으로 국내운송 ORDER를 내릴때
	 * (주)한진 시스템에 선명이 등록되어 있어야 하기 때문에 선명마다,
	 * 또 PORT마다 (주)한지 시스템에 직접 입력하여 선명등록 EDI 전송하는 형식임
	 *
	 * @param List<VvdVO> vvdVOs
	 * @exception EventException
	 */
	public void sendEdiToDLS(List<VvdVO> vvdVOs) throws EventException;

	/**
	 * Booking 모쥴에 BDR 정보를 변경하기 위해 Target 정보를 조회한다.
	 *
	 * @param List<VvdVO> vvdVOs
	 * @return List<BkgVvdBdrLogVO>
	 * @exception EventException
	 */
	public List<BkgVvdBdrLogVO> searchBkgBdrLog(List<VvdVO> vvdVOs) throws EventException;

	/**
	 * XML 메시지를 parsing 하고 DBDAO에게 넘겨준다.
	 *
	 * EDI011-0001 : Receive<br>
	 * VesdSettingReceiveJMS<br>
	 * @param  VskCustSkdEdiSetVO[] vskCustSkdEdiSetVOs
	 * @exception EventException
	 */
	public void esdSettingReceiveJMS(VskCustSkdEdiSetVO[] vskCustSkdEdiSetVOs) throws EventException;

	/**
	 * VOP_VSK_0018 : crr_cd 입력시 체크
	 * @param String crrCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCrrCd(String crrCd) throws EventException;

	/**
	 * [VOP_VSK_0095]
	 * ERP로 전송 할 VVD SKD 목록을 조회<br>
	 *
	 * @param VslSkdRepeatErpIfVO vslSkdRepeatErpIfVO
	 * @return List<VslSkdRepeatErpIfVO>
	 * @exception EventException
	 */
	public List<VslSkdRepeatErpIfVO> searchVslSkdRepeatErpIf(VslSkdRepeatErpIfVO vslSkdRepeatErpIfVO) throws EventException;

	/**
	 * [VOP_VSK_0095] I/F to ERP<br>
	 * 선택된 VVD SKD 목록을 ERP로 전송<br>
	 *
	 * @param VvdVO vvdVO
	 * @exception EventException
	 */
	public void sendVslSkdRepeatErpIf(VvdVO vvdVO) throws EventException;
	
	/**
	 * Vessel Schedule 변경이력관리<br>
	 *
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @param List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs
	 * @param String sFromEventSystem
	 * @exception EventException
	 */
	public void createVesselScheduleChangeHistory(List<VskVslSkdVO> vskVslSkdVOs, List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs, String sFromEventSystem) throws EventException;

	/**
	 * Port Tariff Calculation >> Surcharge/Discount Exist Checking<br>
	 *
	 * @param List<VvdPortTariffVO> vvdPortTariffVOs
	 * @return List<VvdPortTariffVO>
	 * @exception EventException
	 */
	public List<VvdPortTariffVO> checkPortTariffSurchargeDiscountExistList(List<VvdPortTariffVO> vvdPortTariffVOs) throws EventException;
	
	/**
	 * Vessel / Lane 에 대해서 마지막 Port 의 정보를 체크한다.
	 * 
	 * @param swapCstSkdSimVO swapCstSkdSimVO
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkVesselLaneLastPort(SwapCstSkdSimVO swapCstSkdSimVO) throws EventException;


	/**
	 * Phase In/Out에 대한 히스토리 정보를 저장
	 *
	 * @param VskVslSkdPhsIoHisVO[] vskVslSkdPhsIoHisVOs
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public void createVslSkdPhaseInOutHistory(VskVslSkdPhsIoHisVO[] vskVslSkdPhsIoHisVOs, SignOnUserAccount account) throws EventException;
	
}