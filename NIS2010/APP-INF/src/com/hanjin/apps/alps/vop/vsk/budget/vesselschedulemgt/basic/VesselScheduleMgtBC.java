/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongRangeScheduleMgtBC.java
*@FileTitle : LongRangeScheduleMgtBC
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2014.07.14 이용준   searchCstSkdByPort 추가
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SimulationVvdCheckVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;

/** 
 * NIS2010-budget Business Logic Command Interface<br>
 * - NIS2010-budget 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ryu Hyuk
 * @since J2EE 1.4
 * @see
 */
public interface VesselScheduleMgtBC {
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
			SignOnUserAccount account) throws EventException;
	
	/**
	 * Booking 모쥴에 BDR 정보를 변경하기 위해 Target 정보를 조회한다.
	 * 
	 * @param List<VvdVO> vvdVOs
	 * @return List<BkgVvdBdrLogVO>
	 * @exception EventException
	 * @author jinwoo
	 */
	public List<BkgVvdBdrLogVO> searchBkgBdrLog(List<VvdVO> vvdVOs) throws EventException;
	
	/**
	 * 주어진 조건(기간, Lane, Vessel Code)에 따른 Vessel Port SKD을 조회합니다.
	 * 
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return List<PortSkdOnLongRangeVO>
	 * @exception EventException
	 */
	public List<PortSkdOnLongRangeVO> searchPortSkd(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException;
	
	/**
	 * LongRangeSchedule을 생성합니다.<br>
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return LongRangeSkdGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdGRPVO createLongRngSkd(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException;
	
//	/**
//	 * KTNET에게 송신, BKG이 들어오고 이를 (주)한진으로 국내운송 ORDER를 내릴때
//	 * (주)한진 시스템에 선명이 등록되어 있어야 하기 때문에 선명마다,
//	 * 또 PORT마다 (주)한지 시스템에 직접 입력하여 선명등록 EDI 전송하는 형식임
//	 * 
//	 * @param List<VvdVO> vvdVOs
//	 * @exception EventException
//	 */
//	public void sendEdiToDLS(List<VvdVO> vvdVOs) throws EventException;
	
//	/**
//	 * Vessel Port Schedule에 CUD가 발생할 경우 ERP로 변경 정보를 송신
//	 * 
//	 * @param List<VvdVO> erpIfVvdVOs
//	 * @exception EventException
//	 */
//	public void sendVslSkdErpIf(List<VvdVO> erpIfVvdVOs) throws EventException;
	
	/**
	 * Long Range Schedule 을 시뮬레이션 합니다. 
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return List<LongRangeSkdVO>
	 * @exception EventException
	 */
	public List<LongRangeSkdVO> simulateLongRngSkd(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException;
	
	/**
	 * 해당 VVD로 RUSE_PROHI_FLG 값을 확인한다.
	 * 
	 * @param VvdVO vvdVO
	 * @return String
	 * @exception EventException
	 */
	public String checkReuseVvd(VvdVO vvdVO) throws EventException;
	
//	/**
//	 * 해당 VVD를 사용하는 Booking 정보가 있는지 확인합니다.<br>
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return int
//	 * @exception EventException
//	 * @author jinwoo
//	 */
//	public int checkVvdApplyBooking(VvdVO vvdVO) throws EventException;
	
//	/**
//	 * 해당 VVD로 Actual Port Schedule이 입력되여 있는지 확인한다.<br>
//	 * 
//	 * @param VvdVO vvdVO
//	 * @return int
//	 * @exception EventException
//	 * @author jinwoo
//	 */
//	public int checkVvdActualSkdInput(VvdVO vvdVO) throws EventException;
	
	/**
	 * VVD별 Vessel Schedule 정보를 조회합니다.
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception EventException
	 * @author jinwoo
	 */
	public List<CstSkdByVvdVO> searchCstSkdByVvd(CstSkdByVvdVO cstSkdByVvdVO) throws EventException;
	
	/**
	 * VVD의 Costal Schedule을 조회합니다.<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception EventException
	 * @author jinwoo
	 */
	public List<CstSkdByVvdVO> searchCstSkdByPfSkdUse(CstSkdByVvdVO cstSkdByVvdVO) throws EventException;
	
	/**
	 * 변경된 Vessel Port SKD 정보를 변경 및 삭제한다.
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstSkdByVvd(CstSkdByVvdVO[] cstSkdByVvdVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VVD Remark 정보를 관리합니다.<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstSkdByRmk(CstSkdByVvdVO cstSkdByVvdVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
	 * @param VesselVO vesselVO
	 * @return int
	 * @exception EventException
	 */
	public int checkVslCntr(VesselVO vesselVO) throws EventException;
	
	/**
	 * Long Range SKD 방식으로 Vessel Port SKD을 조회합니다.
	 * 
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return LongRangeSkdInqGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdInqGRPVO searchPortSkdOnLongRange(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException;
	
//	/**
//	 * 해당 VVD 스케쥴을 수동 Close 처리합니다.
//	 * 
//	 * @param ActivationVvdVO[] activationVvdVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageVslSkdListByLane(ActivationVvdVO[] activationVvdVOs, SignOnUserAccount account) throws EventException;
	
//	/**
//	 * 해당 VVD 스케쥴을 Activate 처리합니다.
//	 *  
//	 * @param ActivationVvdVO activationVvdVO
//	 * @param SignOnUserAccount account 
//	 * @exception EventException
//	 */
//	public void manageSkdActivate(ActivationVvdVO activationVvdVO, SignOnUserAccount account) throws EventException;
	
//	/**
//	 * VVD 정보의 P/F를 설정합니다.<br>
//	 * 
//	 * @param List<ActivationVvdVO> activationVvdVOs
//	 * @exception EventException
//	 * @author Hyuk Ryu
//	 * @date 2009. 11. 11.
//	 */
//	public void manageVvdPf(List<ActivationVvdVO> activationVvdVOs) throws EventException;
	
	/**
	 * VOP_VSK_0018 : crr_cd 입력시 체크
	 * @param String crrCd
	 * @return String 
	 * @exception EventException
	 */
	public String searchCrrCd(String crrCd) throws EventException;
	
	/**
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param PfLaneTypeVO pfLaneTypeVO
	 * @return List<PfLaneTypeVO>
	 * @exception EventException
	 */
	public List<PfLaneTypeVO> searchPfLaneTypeList(PfLaneTypeVO pfLaneTypeVO) throws EventException;
	/**
	 * VVD이 Booking 상태를 검증합니다.<br>
	 * 
	 * @param SimulationVvdCheckVO simulationVvdCheckVO
	 * @return List<VvdBkgStsVO>
	 * @throws EventException
	 */
	public List<VvdBkgStsVO> checkBkgStsByVvd(SimulationVvdCheckVO simulationVvdCheckVO) throws EventException;
	
	/**
	 * 해당 Port의 Costal Schedule 정보를 조회합니다.<br>
	 *
	 * @param CstSkdByPortVO cstSkdByPortVO
	 * @return List<CstSkdByPortVO>
	 * @exception EventException
	 * VOP_VSK_0113.do 에 대한 Retrieve 기능 - 이용준 추가 2014.07.15
	 */
	public List<CstSkdByPortVO> searchCstSkdByPort(CstSkdByPortVO cstSkdByPortVO) throws EventException ;
}