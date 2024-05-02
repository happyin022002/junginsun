/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleMgtBC.java
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.07.06 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActPortSkdHisVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdDtlVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdEdiMntrVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdRtoVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdSumVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.EdiLogDataGRPVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.VvdListByPortVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskActPortSkdEdiLogVO;
import com.clt.syscommon.common.table.VskActPortSkdVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * ActualScheduleManagement Business Logic Basic Command implementation<br>
 * - Interface of Business Logic about ActualScheduleManagement<br>
 *
 * @author 
 * @see Vop_vsk_0027EventResponse 참조
 * @since J2EE 1.6
 */

public interface ActualScheduleMgtBC {
	
	/**
	 * Handling Retrieve Event about Actual schedule management<br>
	 * Retrieving Vessel Port Schedule, Actual Port Schedule Information <br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdMgtVO
	 * @exception EventException
	 */
	public ActSkdMgtVO searchActPortSkd(ActSkdMgtVO actSkdMgtVO) throws EventException;
	/**
	 * Creating and Updating created actual schedule information, and Interfacing necessary information to each module 
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageActPortSkd(ActSkdMgtVO actSkdMgtVO) throws EventException;
	/**
	 * Deleting registered Actual Port Schedule <br>
	 * @param VskActPortSkdVO vskActPortSkdVO
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @throws EventException
	 */
	public void removeVskActPortSkd(VskActPortSkdVO vskActPortSkdVO, ActSkdMgtVO actSkdMgtVO) throws EventException;
	/**
	 * Retrieving Target Lane List<br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchActualTargetLaneList(ActSkdRtoVO actSkdRtoVO) throws EventException;
	/**
	 * Retrieving Actual Report input state of Ports
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdSumVO>
	 * @exception EventException
	 */
	public List<ActSkdSumVO> searchActPortSkdInputSum(ActSkdRtoVO actSkdRtoVO) throws EventException;
	/**
	 * Retrieving Detail Actual Report input state of Ports<br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdDtlVO>
	 * @exception EventException
	 */
	public List<ActSkdDtlVO> searchActPortSkdInputDtl(ActSkdRtoVO actSkdRtoVO) throws EventException;
	/**
	 * Retrieving Uncompleted Actual Schedule Report <br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdDtlVO>
	 * @exception EventException
	 */
	public List<ActSkdDtlVO> searchActPortSkdUnCmplDtl(ActSkdRtoVO actSkdRtoVO) throws EventException;
	/**
	 * Retrieving Actual SKD Information through EDI.<br>
	 * 
	 * @param ActSkdEdiMntrVO actSkdEdiMntrVO
	 * @return List<ActSkdEdiMntrVO>
	 * @exception EventException
	 */
	public List<ActSkdEdiMntrVO> searchActPortSkdEdiMntr(ActSkdEdiMntrVO actSkdEdiMntrVO) throws EventException;
	
	/**
	 * Saving and Checking MQ Full Message<br>
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
	 * 
	 * @param String ediFlatFlie
	 * @return VskActPortSkdEdiLogVO
	 * @exception EventException
	 */
	public List<VskActPortSkdEdiLogVO> createVskActPortSkdEdiLog(String ediFlatFlie) throws EventException;
	
	/**
	 * Saving and Checking MQ Full Message<br>
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
	 * 
	 * @param List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs
	 * @param SignOnUserAccount account
	 * @return EdiLogDataGRPVO
	 * @exception EventException
	 */
	public EdiLogDataGRPVO auditReceivedEdiData(List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Saving and Checking MQ Full Message<br>
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyVskActPortSkdEdiLog(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving Calling Port by condition from SPP
	 * Finding ETA of inputed Port Code between -7 day and +7 day<br>
	 * 
	 * @param String vpsPortCd
	 * @param String vslSvcTpCd
	 * @return List<VvdListByPortVO>
	 * @exception EventException
	 */
	public List<VvdListByPortVO> searchSppVvdListByPort(String vpsPortCd, String vslSvcTpCd) throws EventException;
	/**
	 * Retrieving Actual Schedule History<br>
	 * 
	 * @param VvdPortLaneOtherVO vvdPortLaneOtherVO
	 * @return List<ActPortSkdHisVO>
	 * @exception EventException
	 */
	public List<ActPortSkdHisVO> searchActPortSkdHis(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws EventException;
	
	/**
	 * Deleting Actual Port Schedule Information<br>
	 *  
	 * @param List<VvdVO> vvdVOs
	 * @exception EventException
	 */
	public void removeVskActPortSkd(List<VvdVO> vvdVOs) throws EventException;
	
	//::FOR.NYK.START::by TOP:2014-09-16:://
	/**
	 * Adding Validation Check Logic for Inputted Future Date<br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdDtlVO
	 * @exception EventException
	 */
	public ActSkdDtlVO checkInputActDateEffectiveness(ActSkdMgtVO actSkdMgtVO) throws EventException;
	//::FOR.NYK.FINISH::by TOP:2014-09-16:://
	// :: VIPS START ::
	/**
	 * Retrieving Vessel Port SKD
	 * @return List<VskVslPortSkdVO>
	 */
	public List<VskVslPortSkdVO> getVslPortSkdList();
	
	/**
	 * Retrieving Vessel Port Actual SKD
	 * @return List<VskActPortSkdVO>
	 */
	public List<VskActPortSkdVO> getVskActPortSkdList();
	
	/**
	 * Retrieving Vessel  SKD
	 * @return List<VskVslSkdVO>
	 */
	public List<VskVslSkdVO> getVskVslSkdList();
	// :: VIPS END ::
}