/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongRangeScheduleMgtBC.java
*@FileTitle : LongRangeScheduleMgtBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.20 유혁
* 1.0 Creation
* 
* History
* 2012.05.14 진마리아 CHM-201217742-01 PF 사용하여 SKD 생성시 DELETE YARD 제어 로직 추가
* 2015.09.04 이병훈	[CHM-201537542] Yarc Code 말풍선 도움말 기능 지원
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SimulationVvdCheckVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-Scheduleplanningoperation Business Logic Command Interface<br>
 * - NIS2010-Scheduleplanningoperation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ryu Hyuk
 * @since J2EE 1.4
 * @see
 */
public interface LongRangeScheduleMgtBC {
	/**
	 * Long Range Schedule 을 시뮬레이션 합니다.<br>
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return List<LongRangeSkdVO>
	 * @exception EventException
	 */
	public List<LongRangeSkdVO> simulateLongRngSkd(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException;
	/**
	 * LongRangeSchedule을 생성합니다.<br>
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return LongRangeSkdGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdGRPVO createLongRngSkd(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException;
	/**
	 * VVD이 Booking 상태를 검증합니다.<br>
	 * 
	 * @param SimulationVvdCheckVO simulationVvdCheckVO
	 * @return List<VvdBkgStsVO>
	 * @throws EventException
	 */
	public List<VvdBkgStsVO> checkBkgStsByVvd(SimulationVvdCheckVO simulationVvdCheckVO) throws EventException;
	
	/**
	 * VVD 정보의 P/F를 설정합니다.<br>
	 * 
	 * @param List<ActivationVvdVO> activationVvdVOs
	 * @exception EventException
	 * @author Hyuk Ryu
	 * @date 2009. 11. 11.
	 */
	public void manageVvdPf(List<ActivationVvdVO> activationVvdVOs) throws EventException;
	
//	/**
//	 * 전배가 계획으로 발생할 수 있는 Cost 정보를 조회합니다.
//	 * 
//	 * @param String simNo
//	 * @param String simDt
//	 * @return List<VskSwapCstCostVO>
//	 * @exception EventException
//	 */
//	public List<VskSwapCstCostVO> searchPhsIOSkdCost(String simNo, String simDt) throws EventException;
	
	/**
	 * 주어진 조건(기간, Lane, Vessel Code)에 따른 Vessel Port SKD을 조회합니다.
	 * 2010.05.19 추가
	 *  
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return List<PortSkdOnLongRangeVO>
	 * @throws EventException
	 */
	public List<PortSkdOnLongRangeVO> searchPortSkd(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException;
	
	/**
	 * Long Range SKD 방식으로 Vessel Port SKD을 조회합니다.
	 * 
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return LongRangeSkdInqGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdInqGRPVO searchPortSkdOnLongRange(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException;
	
	/**
	 * PF 선택시 삭제된 yard가 존재하는지 check한다.
	 * @param String vslSlanCd
	 * @param String pfSvcTpCd
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> checkDeltYardByPF(String vslSlanCd, String pfSvcTpCd) throws EventException;
	
	/**
	 * Yard Code 정보로 Yard Name을 조회합니다.
	 * @param ydCd
	 * @return
	 * @throws EventException
	 */
	public String searchYardName(String ydCd) throws EventException;
	
}