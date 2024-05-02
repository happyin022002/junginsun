/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisLongStayingReportBC.java
*@FileTitle : Chassis Long Staying Report
*Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.07
 *@LastModifier : 이율규
 *@LastVersion : 1.0
 * 2015.04.07 이율규
 * 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.vo.ChassisLongStayingVO;
import com.hanjin.apps.alps.ees.cgm.chassisreport.chassisreportinventory.vo.LandInvMonitoringVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 *
 * @author Lee, YulKyu
 * @see Ees_cgm_1028EventResponse 참조
 * @since J2EE 1.4 
 */

public interface ChassisLongStayingReportBC {
	/**
	 * [EES_CGM_1158]<br>
	 * Detail의 정보를 조회<br>
	 *
	 * @return List<ChassisLongStayingVO>
	 * @param ChassisLongStayingVO chassisLongStayingVO
	 * @exception EventException
	 */
	public List<ChassisLongStayingVO> searchLongStayingChassisList(ChassisLongStayingVO chassisLongStayingVO) throws EventException;

}