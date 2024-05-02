/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongRangeScheduleMgtBC.java
*@FileTitle : LongRangeScheduleMgtBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SimulationVvdCheckVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * Scheduleplanningoperation Business Logic Command Interface<br>
 * - Interface of Business Logic about Scheduleplanningoperation<br>
 *
 * @author 
 * @since J2EE 1.4
 * @see
 */
public interface LongRangeScheduleMgtBC {
	/**
	 * Simulating Long Range Schedule
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return List<LongRangeSkdVO>
	 * @exception EventException
	 */
	public List<LongRangeSkdVO> simulateLongRngSkd(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException;
	/**
	 * Creating LongRangeSchedule
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return LongRangeSkdGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdGRPVO createLongRngSkd(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException;
	
	/**
	 * Creating LongRangeScheduleMultiple
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return LongRangeSkdGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdGRPVO createLongRngSkdMultiple(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException;
	/**
	 * Checking Booking status of VVD
	 * 
	 * @param SimulationVvdCheckVO simulationVvdCheckVO
	 * @return List<VvdBkgStsVO>
	 * @throws EventException
	 */
	public List<VvdBkgStsVO> checkBkgStsByVvd(SimulationVvdCheckVO simulationVvdCheckVO) throws EventException;
	
	/**
	 * Setting P/F
	 * 
	 * @param List<ActivationVvdVO> activationVvdVOs
	 * @exception EventException
	 * @date 2009. 11. 11.
	 */
	public void manageVvdPf(List<ActivationVvdVO> activationVvdVOs) throws EventException;
	
	/**
	 * Retrieving Vessel Port SKD
	 *  
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return List<PortSkdOnLongRangeVO>
	 * @throws EventException
	 */
	public List<PortSkdOnLongRangeVO> searchPortSkd(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException;
	
	/**
	 * Retrieving Vessel Port SKD in Long Range SKD Form
	 * 
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return LongRangeSkdInqGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdInqGRPVO searchPortSkdOnLongRange(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException;

	// :: VIPS START ::
	/**
	 * Retrieving Vessel Port SKD
	 * @return List<VskVslPortSkdVO>
	 */
	public List<VskVslPortSkdVO> getVslPortSkdList();
	
	/**
	 * Retrieving Vessel SKD
	 * @return List<VskVslSkdVO>
	 */
	public List<VskVslSkdVO> getVskVslSkdList();
	// :: VIPS END ::
}