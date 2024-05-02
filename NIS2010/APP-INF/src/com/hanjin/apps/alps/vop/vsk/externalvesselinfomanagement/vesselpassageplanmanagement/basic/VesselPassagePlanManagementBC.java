/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : VesselPassagePlanManagementBC.java
 *@FileTitle : Passage Plan Receive from VMS
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015-04-20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.04.20
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.basic;

import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpassageplanmanagement.vo.PassagePlanDtVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * VMS JMS Consuming에 따른 JMS receive Interface<br> 
 * VMS 에 대한 JMS Inbound 처리에 대한 규칙을 정의한다.<br>
 * 
 * @author Myoung Sin Park
 * @see VesselPassagePlanManagementBC 참조
 * @since J2EE 1.4
 */
public interface VesselPassagePlanManagementBC {
	
	/**
	 * Create or update departure report.<br>
	 *  
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception EventException
	 */
	public void managePassagePlan(PassagePlanDtVO passagePlanDtVO) throws EventException;
}
