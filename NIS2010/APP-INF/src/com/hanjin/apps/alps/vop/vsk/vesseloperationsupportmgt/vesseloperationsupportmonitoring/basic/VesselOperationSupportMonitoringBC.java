/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselOperationSupportMonitoringBC.java
*@FileTitle : VOSI Update Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.10 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringConditionVO;

/**
 * ALPS-Vesseloperationsupportmgt Business Logic Command Interface<br>
 * - ALPS-Vesseloperationsupportmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jong Ock
 * @see Vop_vsk_0517EventResponse 참조
 * @since J2EE 1.6
 */

public interface VesselOperationSupportMonitoringBC {

	/**
	 *  VOSI Update Monitoring 을 조회 합니다.<br>
	 * 
	 * @param VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO
	 * @return List<VosiUpdateMonitoringVO>
	 * @exception EventException
	 */
	public List<VosiUpdateMonitoringVO> searchVOSIUpdateList(VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO) throws EventException;
	
	/**
	 * 조회조건에 Port Code 유효성(체크) 을 조회 합니다.<br>
	 * 
	 * @param VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO
	 * @return List<MdmRhqComboVO>
	 * @exception EventException
	 */
	public List<MdmRhqComboVO> searchMdmRhqCombo(VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO) throws EventException;
	
}