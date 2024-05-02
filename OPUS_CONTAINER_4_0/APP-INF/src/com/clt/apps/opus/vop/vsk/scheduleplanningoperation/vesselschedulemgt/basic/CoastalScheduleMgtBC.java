/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtBC.java
*@FileTitle : VSL SKD Delete & Closing
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgListByVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalBnkSavVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalTransitTargetVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdBerthWdoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPolPodVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdSimDtlCalcInfoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SkipPortGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdXtraHisVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.VskDepRptVO;
import com.clt.syscommon.common.table.VskNoonRptVO;
import com.clt.syscommon.common.table.VskPortDistVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdHisVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * Scheduleplanningoperation Business Logic Command Interface<br>
 * - Interface of Business Logic about Scheduleplanningoperation
 *
 * @author
 * @see
 * @since J2EE 1.4
 */

public interface CoastalScheduleMgtBC {
	/**
	 * Retrieving Vessel Schedule of lane 
	 * 
	 * @param ActivationVvdVO activationVvdVO
	 * @return List<ActivationVvdVO>
	 * @exception EventException
	 */
	public List<ActivationVvdVO> searchVslSkdListByLane(ActivationVvdVO activationVvdVO) throws EventException;

	/**
	 * Deleting Schedule of VVD
	 * 
	 * @param ActivationVvdVO[] activationVvdVO1
	 * @param ActivationVvdVO[] activationVvdVO2
	 * @param VskVslSkdHisVO vskVslSkdHisVO 
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
//	public void removeCstSkdByVvd(
//			ActivationVvdVO[] activationVvdVO1,
//			ActivationVvdVO[] activationVvdVO2,
//			VskVslSkdHisVO vskVslSkdHisVO,
//			SignOnUserAccount account) throws EventException;
	
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
	 * Retrieving Calling Port
	 *
	 * @param VvdVO vvdVO
	 * @return SkipPortGRPVO
	 * @exception EventException
	 */
	public SkipPortGRPVO searchCallingPortList(VvdVO vvdVO) throws EventException ;
	/**
	 * Checking Booking is exist with the VVD
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception EventException
	 * @author jinwoo
	 */
	public int checkVvdApplyBooking(VvdVO vvdVO) throws EventException ;
	/**
	 * Checking Vessel Code is exist in MDM_VSL_CNTR
	 * 
	 * @param String vslCd
	 * @return int
	 * @exception EventException
	 */
	public int checkVslCntr(String vslCd) throws EventException ;
	/**
	 * Checking Actual Port Schedule is exist with the vvd
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception EventException
	 * @author jinwoo
	 */
	public int checkVvdActualSkdInput(VvdVO vvdVO) throws EventException ;
	/**
	 * Checking RUSE_PROHI_FLG with the VVD
	 * 
	 * @param VvdVO vvdVO
	 * @return String
	 * @throws EventException
	 */
	public String checkReuseVvd(VvdVO vvdVO) throws EventException ;
	/**
	 * Retrieving Vessel Schedule
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception EventException
	 */
	public List<CstSkdByVvdVO> searchCstSkdByVvd(CstSkdByVvdVO cstSkdByVvdVO) throws EventException ;
	/**
	 * Retrieving Proforma Schedule
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception EventException
	 */
	public List<CstSkdByVvdVO> searchCstSkdByPfSkdUse(CstSkdByVvdVO cstSkdByVvdVO) throws EventException ;
	/**
	 * Retrieving Proforma Schedule
	 * 
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @throws EventException
	 */
	public List<SwapCstSkdSimVO> searchCstSkdByPfSkdSim(SwapCstSkdSimVO swapCstSkdSimVO) throws EventException ;
	/**
	 * Updating and Deleting changed Vessel Port SKD
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @throws EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdByVvd(CstSkdByVvdVO[] cstSkdByVvdVOs, SignOnUserAccount account) throws EventException ;
	/**
	 * Changing Vessel Port SKD as per Deleting Actual SKD
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @throws EventException
	 */
	public void modifyVskVslPortSkdByActSkdDelelet(List<VskVslPortSkdVO> vskVslPortSkdVOs) throws EventException ;
	/**
	 * Setting Simulation Data to Coastal Schedule
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @throws EventException
	 */
	public VslSkdChgStsGRPVO manageSettleByVvd(CstSkdByVvdVO[] cstSkdByVvdVOs, SwapCstSkdSimVO swapCstSkdSimVO, SignOnUserAccount account) throws EventException ;
	/**
	 * Managing VVD Remark<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstSkdByRmk(CstSkdByVvdVO cstSkdByVvdVO, SignOnUserAccount account) throws EventException ;
	/**
	 * Changing and Deleting changed Vessel Port SKD
	 * 
	 * @param SwapCstGRPVO swapCstGRPVO
	 * @return VslSkdChgStsGRPVO
	 * @throws EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdByActual(SwapCstGRPVO swapCstGRPVO) throws EventException ;
	/**
	 * Retrieving Costal Schedule Simulation
	 * 
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @exception EventException
	 */
	public List<SwapCstSkdSimVO> searchCstSkdSim(SwapCstSkdSimVO swapCstSkdSimVO) throws EventException ;
	/**
	 * Retrieving Costal Schedule
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return VslPortSkdVO
	 * @exception EventException
	 */
	public VslPortSkdVO searchCstSkdByVvdPort(VslPortSkdVO vslPortSkdVO) throws EventException ;
	/**
	 * Retrieving Vessel Berth Information
	 * 
	 * @param CstSkdBerthWdoVO cstSkdBerthWdoVO
	 * @return List<CstSkdBerthWdoVO>
	 * @exception EventException
	 */
	public List<CstSkdBerthWdoVO> searchCstSkdBerthWdo(CstSkdBerthWdoVO cstSkdBerthWdoVO) throws EventException ;
	/**
	 * Managing Coastal, ETA, ETB, ETD, Next ETA, etc.
	 * 
	 * @param CstSkdBerthWdoVO[] cstSkdBerthWdoVOs
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @throws EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdBerthWdo(CstSkdBerthWdoVO[] cstSkdBerthWdoVOs, SignOnUserAccount account) throws EventException ;
	/**
	 * Handling Coastal SKD Simulation(Recovery Plan)
	 * 
	 * @param SwapCstSkdSimVO[] swapCstSkdSimVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageCstSkdSim(SwapCstSkdSimVO[] swapCstSkdSimVOs, SignOnUserAccount account) throws EventException ;
	/**
	 * Retrieving Container cargo weight and etc cost of Skip Call Port. And Retrieving distance info
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @throws EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchSkipCallInfo(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException;
	/**
	 * Retrieving Container cargo weight and etc cost of Skip Call Port. And Retrieving distance info
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @throws EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchAddCallInfo(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException;
	/**
	 * Retrieving Port Charge
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchPortExpenceByVessel(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException; 
	/**
	 * Retrieving distance of port to port
	 * 
	 * @param List<VskPortDistVO> vskPortDistVOs 
	 * @return List<VskPortDistVO>
	 * @exception EventException
	 */
	public List<VskPortDistVO> searchVskPortDist(List<VskPortDistVO> vskPortDistVOs) throws EventException ;
	/**
	 * Retrieving Costal Schedule of POL, POD
	 * 
	 * @param CstSkdByPolPodVO cstSkdByPolPodVO
	 * @return List<CstSkdByPolPodVO>
	 * @exception EventException
	 */
	public List<CstSkdByPolPodVO> searchCstSkdByPolPod(CstSkdByPolPodVO cstSkdByPolPodVO) throws EventException ;
	/**
	 * Retrieving Costal Schedule
	 * 
	 * @param CstSkdByPortVO cstSkdByPortVO
	 * @return List<CstSkdByPortVO>
	 * @exception EventException
	 */
	public List<CstSkdByPortVO> searchCstSkdByPort(CstSkdByPortVO cstSkdByPortVO) throws EventException ;
	/**
	 * Retrieving Time Zone, Manu In/Out, Terminal Productivity, Port Expence
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchCstSkdSimBaseInfo(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException ;
	/**
	 * Retrieving DATA in case Speed change
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchBunkerQtyBySpeed(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException ;
	/**
	 * Retrieving VSL SKD History
	 * 
	 * @param VvdPortLaneOtherVO  vvdPortLaneOtherVO
	 * @return List<VskVslSkdHisVO>
	 * @exception EventException
	 */
	public List<VskVslSkdHisVO> searchCstSkdHisByVvd(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws EventException ;
	/**
	 * Finding CNSHA Port, pre bound port, and Retrieving Bay Plan Port
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @throws EventException
	 */
	public List<VskVslPortSkdVO> searchBayPlanInputPort(VskVslPortSkdVO vskVslPortSkdVO) throws EventException ;
	/**
	 * Calculating Loadable Weight and Retrieving
	 * 
	 * @param LoadWgtGRPVO loadWgtGRPVO
	 * @return LoadWgtGRPVO
	 * @exception EventException
	 */
	public LoadWgtGRPVO calLoadableWgt(LoadWgtGRPVO loadWgtGRPVO) throws EventException ;
	
	/**
	 * Retrieving Booking List
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<BkgListByVvdVO>
	 * @exception EventException
	 */
	public List<BkgListByVvdVO> searchBkgListByVvd(String vslCd, String skdVoyNo, String skdDirCd) throws EventException;

	/**
	 * Manually Closing VVD
	 *  
	 * @param ActivationVvdVO[] activationVvdVOs 
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageVslSkdListByLane(ActivationVvdVO[] activationVvdVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Activating VVD
	 *  
	 * @param ActivationVvdVO activationVvdVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageSkdActivate(ActivationVvdVO activationVvdVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * JMS Inbound EDS061-0001
	 *  
	 * @param VskNoonRptVO[] vskNoonRptVOs
	 * @exception EventException
	 */
	public void createNoonReport(VskNoonRptVO[] vskNoonRptVOs) throws EventException;

	/**
	 * JMS Inbound EDS062-0001
	 *  
	 * @param VskDepRptVO[] vskDepRptVOs
	 * @exception EventException
	 */
	public void createDepartureReport(VskDepRptVO[] vskDepRptVOs) throws EventException;
	
	/**
	 * Retrieving Canal Transit List and Surcharge
	 * 
	 * @param CanalTransitTargetVvdVO canalTransitTargetVvdVO
	 * @return List<CanalTransitTargetVvdVO>
	 * @exception EventException
	 */
	public List<CanalTransitTargetVvdVO> searchCanalTzList(CanalTransitTargetVvdVO canalTransitTargetVvdVO) throws EventException;
	
	/**
	 * Retrieving difference of Bunker charge and Canal Surcharge
	 * 
	 * @param CanalBnkSavVO canalBnkSavVO
	 * @return List<CanalBnkSavVO>
	 * @exception EventException
	 */
	public List<CanalBnkSavVO> calCanalBunkerSaving(CanalBnkSavVO canalBnkSavVO) throws EventException;
	
	/**
	 * Retrieving Target info for changing BDR in Booking
	 * 
	 * @param List<VvdVO> vvdVOs
	 * @return List<BkgVvdBdrLogVO>
	 * @exception EventException
	 */
	public List<BkgVvdBdrLogVO> searchBkgBdrLog(List<VvdVO> vvdVOs) throws EventException;
	
	/**
	 * VOP_VSK_0018 : crr_cd
	 * @param String crrCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCrrCd(String crrCd) throws EventException;
	

	/**
	 * Vessel Schedule 변경이력관리<br>
	 *
	 * @param List<VslSkdXtraHisVO> vslSkdXtraHisVOs
	 * @param String sFromEventSystem
	 * @exception EventException
	 */
	public void createVesselScheduleExtraChangeHistory(List<VslSkdXtraHisVO> vslSkdXtraHisVOs, String sFromEventSystem) throws EventException;

	// :: VIPS START ::
	/**
	 * Retrieving Vessel Port SKD
	 * @return List<VskVslPortSkdVO>
	 */
	public List<VskVslPortSkdVO> getVslPortSkdList();
	
	/**
	 * Retrieving Vessel Port SKD
	 * @return List<VskVslPortSkdVO>
	 */
	public List<VskVslPortSkdVO> getDelNextVslPortSkdList();
	/**
	 * Retrieving Vessel Port SKD
	 * @return List<VskVslPortSkdVO>
	 */
	public List<VskVslPortSkdVO> getDelNextDirVslPortSkdList();	
	/**
	 * Retrieving Vessel SKD
	 * @return List<VskVslSkdVO>
	 */
	public List<VskVslSkdVO> getVskVslSkdList();
	// :: VIPS END ::

	/**
	 * Checking VVD ETD
	 * 
	 * @param VslPortSkdVO cstSkdByVvdVO
	 * @return int
	 * @exception EventException
	 * @author jinwoo
	 */
	public int checkVskVslPortSkdEtd(VslPortSkdVO cstSkdByVvdVO) throws EventException ;
	
	/**
	 * Checking VPS Reverse or not
	 * 
	 * @param VslPortSkdVO cstSkdByVvdVO
	 * @return boolean
	 * @exception EventException
	 * @author TOP
	 */
	public boolean isReverseVesselPortSchedule(VslPortSkdVO cstSkdByVvdVO) throws EventException ;	
}

