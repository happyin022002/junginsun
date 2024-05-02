/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScheduleTransmitManagementBC.java
*@FileTitle : ETA sending (Auto FAX/TLX)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.05
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.12.05 진마리아
* 1.0 Creation
*  History
* 2012.12.20 CHM-201221649-01 진마리아  ETA sending (Auto FAX/TLX)
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendMoniVO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendTgtVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-ScheduleUtilityManagement Business Logic Command Interface<br>
 * - NIS2010-ScheduleUtilityManagement 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SEO CHANG YUL
 * @see Ui_vsk-0202EventResponse 참조
 * @since J2EE 1.4
 */

public interface ScheduleTransmitManagementBC {

	/**
	 * ETA Sending(Auto FAX/TLX) 대상 SKD을 조회합니다.
	 * 
	 * @param  EtaSendTgtVO etaSendTgtVO
	 * @return List<EtaSendTgtVO>
	 * @exception EventException
	 */
	public List<EtaSendTgtVO> searchTransmitNoticeTgtSkdList(EtaSendTgtVO etaSendTgtVO) throws EventException;

	/**
	 * 기전송된 ETA 정보에 대하여, RPM에 대한 결과값을 저장합니다.
	 * 
	 * @param  List<EtaSendTgtVO> etaSendTgtVOList
	 * @exception EventException
	 */
	public void manageEtaSendResult	(List<EtaSendTgtVO> etaSendTgtVOList) throws EventException;
	/**
	 * 변경 ETA, ETB 정보를 저장한다
	 * 
	 * @param EtaSendTgtVO etaSendTgtVO
	 * @exception EventException
	 */
	public void manageTransmitNoticeTargetSkd	(EtaSendTgtVO etaSendTgtVO) throws EventException;
	
	/**
	 * ETA Sending(Auto TLX/FAX) 내역을 조회합니다.
	 * 
	 * @param  EtaSendMoniVO etaSendMoniVO
	 * @return List<EtaSendMoniVO>
	 * @exception EventException
	 */
	public List<EtaSendMoniVO> searchTransmitNoticeMoniList(EtaSendMoniVO etaSendMoniVO) throws EventException;
	
}