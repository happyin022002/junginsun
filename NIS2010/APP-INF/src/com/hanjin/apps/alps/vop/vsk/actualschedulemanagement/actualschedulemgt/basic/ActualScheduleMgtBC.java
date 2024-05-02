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
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActPortSkdHisVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdEdiMntrVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdRtoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdSumVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.EdiLogDataGRPVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.VvdListByPortVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskActPortSkdEdiLogVO;
import com.hanjin.syscommon.common.table.VskActPortSkdVO;

/**
 * NIS2010-Actualschedulemanagement Business Logic Command Interface<br>
 * - NIS2010-Actualschedulemanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jung Jinwoo
 * @see Vop_vsk_0027EventResponse 참조
 * @since J2EE 1.6
 */

public interface ActualScheduleMgtBC {
	
	/**
	 * 조회 이벤트 처리<br>
	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
	 * Vessel Port Schedule, Actual Port Schedule 정보를 조회한다.<br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdMgtVO
	 * @exception EventException
	 */
	public ActSkdMgtVO searchActPortSkd(ActSkdMgtVO actSkdMgtVO) throws EventException;
	/**
	 * 멀티 이벤트 처리<br>
	 * Actualschedulemgt 화면에 대한 멀티 이벤트 처리<br>
	 * 해당 Port에서 VVD별로 입력한 Actual Schedule 정보를 생성 및 변경하고, 각 모쥴별 필요한 정보를 인터페이스 한다.<br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageActPortSkd(ActSkdMgtVO actSkdMgtVO) throws EventException;
	/**
	 * 등록된 Actual Port SKD 정보를 삭제한다.<br>
	 * @param VskActPortSkdVO vskActPortSkdVO
	 * @throws EventException
	 */
	public void removeVskActPortSkd(VskActPortSkdVO vskActPortSkdVO) throws EventException;
	/**
	 * 등록된 관련 대상 Lane List를 조회한다.<br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchActualTargetLaneList(ActSkdRtoVO actSkdRtoVO) throws EventException;
//	/**
//	 * 조회 이벤트 처리<br>
//	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
//	 * 
//	 * @param ServiceLaneVO serviceLaneVO
//	 * @return List<ServiceLaneVO>
//	 * @exception EventException
//	 */
//	public List<ServiceLaneVO> searchActPortSkdTgtLane(ServiceLaneVO serviceLaneVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
	 * 사용자가 입력한 조건에 맞는 Port들에 Actual Report 입력 현황을 조회한다.<br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdSumVO>
	 * @exception EventException
	 */
	public List<ActSkdSumVO> searchActPortSkdInputSum(ActSkdRtoVO actSkdRtoVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
	 * 사용자가 입력한 조건에 맞는 Port들의 Actual Report 현황을 상세 조회한다.<br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdDtlVO>
	 * @exception EventException
	 */
	public List<ActSkdDtlVO> searchActPortSkdInputDtl(ActSkdRtoVO actSkdRtoVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
	 * Actual Schedule이 작성되지 않는 Report를 조회한다.<br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdDtlVO>
	 * @exception EventException
	 */
	public List<ActSkdDtlVO> searchActPortSkdUnCmplDtl(ActSkdRtoVO actSkdRtoVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
	 * EDI로 수신된 Actual SKD 접수 정보를 조회한다.<br>
	 * 
	 * @param ActSkdEdiMntrVO actSkdEdiMntrVO
	 * @return List<ActSkdEdiMntrVO>
	 * @exception EventException
	 */
	public List<ActSkdEdiMntrVO> searchActPortSkdEdiMntr(ActSkdEdiMntrVO actSkdEdiMntrVO) throws EventException;
	
	/**
	 * MQ 메세지 전문 저장 및 체크.<br>
	 * 터미널에 입력해 준 EDI 데이터 원본을 DB[VSK_ACT_PORT_SKD_EDI_LOG]에 저장한다.<br>
	 * 
	 * @param String ediFlatFlie
	 * @return VskActPortSkdEdiLogVO
	 * @exception EventException
	 */
	public List<VskActPortSkdEdiLogVO> createVskActPortSkdEdiLog(String ediFlatFlie) throws EventException;
	
	/**
	 * MQ 메세지 전문 저장 및 체크.<br>
	 * 터미널에 입력해 준 EDI 데이터 원본을 DB[VSK_ACT_PORT_SKD_EDI_LOG]에 저장한다.<br>
	 * 
	 * @param List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs
	 * @param SignOnUserAccount account
	 * @return EdiLogDataGRPVO
	 * @exception EventException
	 */
	public EdiLogDataGRPVO auditReceivedEdiData(List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * MQ 메세지 전문 저장 및 체크.<br>
	 * 터미널에 입력해 준 EDI 데이터 원본을 DB[VSK_ACT_PORT_SKD_EDI_LOG]에 저장한다.<br>
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyVskActPortSkdEdiLog(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * SPP에서 받은 조건으로 Calling하는 Vvd를 조회.<br>
	 * 입력받은 Port Code를 ETA 기준 -7일 ~ +7일에 Calling하는 Vvd를 조회한다.<br>
	 * 
	 * @param String vpsPortCd
	 * @param String vslSvcTpCd
	 * @return List<VvdListByPortVO>
	 * @exception EventException
	 */
	public List<VvdListByPortVO> searchSppVvdListByPort(String vpsPortCd, String vslSvcTpCd) throws EventException;
	/**
	 * Actual Schedule History를 조회한다.<br>
	 * 
	 * @param VvdPortLaneOtherVO vvdPortLaneOtherVO
	 * @return List<ActPortSkdHisVO>
	 * @exception EventException
	 */
	public List<ActPortSkdHisVO> searchActPortSkdHis(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws EventException;
	
	/**
	 * Actual Port Schedule 정보를 삭제합니다.<br>
	 *  
	 * @param List<VvdVO> vvdVOs
	 * @exception EventException
	 */
	public void removeVskActPortSkd(List<VvdVO> vvdVOs) throws EventException;
}