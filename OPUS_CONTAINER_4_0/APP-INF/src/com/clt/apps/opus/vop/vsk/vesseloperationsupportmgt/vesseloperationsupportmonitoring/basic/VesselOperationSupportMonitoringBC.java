/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselOperationSupportMonitoringBC.java
*@FileTitle : VOSI Update Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo.VosiUpdateMonitoringVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Vesseloperationsupportmgt Business Logic Command Interface<br>
 *  Interface of Business Logic about Vesseloperationsupportmgt<br>
 *
 * @author 
 * @see Vop_vsk_0517EventResponse
 * @since J2EE 1.6
 */

public interface VesselOperationSupportMonitoringBC {

	/**
	 *  Retrieving VOSI Update Monitoring
	 * 
	 * @param VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO
	 * @return List<VosiUpdateMonitoringVO>
	 * @exception EventException
	 */
	public List<VosiUpdateMonitoringVO> searchVOSIUpdateList(VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO) throws EventException;
	
	/**
	 * Checking Port Code and Retrieving RHQ
	 * 
	 * @param VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO
	 * @return List<MdmRhqComboVO>
	 * @exception EventException
	 */
	public List<MdmRhqComboVO> searchMdmRhqCombo(VosiUpdateMonitoringConditionVO vosiUpdateMonitoringConditionVO) throws EventException;
	
}