/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselInformationMgtBC.java
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.22 김종옥
* 1.0 Creation
* 
* 2014.03.17 박다은 [CHM-201428939-01] vessel particular - performance
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DockPlanListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LoadableListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LowestListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.PerformanceInfoVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPerformanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselLoadableInfoVO;

/**
 * NIS2010-Vesseloperationsupportmgt Business Logic Command Interface<br>
 * - NIS2010-Vesseloperationsupportmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jong Ock
 * @see Vop_vsk_0503EventResponse 참조
 * @since J2EE 1.6
 */

public interface VesselInformationMgtBC {
	/**
	 * Particular I, Particular II 을 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return VSLPartIVO
	 * @exception EventException
	 */
	public VSLPartIVO searchVSLPartI(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException;
	 
	/**
	 * Performance 를 조회 합니다.<br>
	 * 
	 * @param vesselInformationMgtConditionVO
	 * @return
	 * @throws EventException
	 */
	public VSLPerformanceVO searchVSLPerformance(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException;
	
	/**
	 * Performance 를 조회 합니다.<br>
	 * 
	 * @param vesselInformationMgtConditionVO
	 * @return
	 * @throws EventException
	 */
	public VSLPerformanceVO searchVSLPerformanceDetail(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException;
	
	/**
	 * Dock Plan 을 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return List<DockPlanListVO>
	 * @exception EventException
	 */
	public List<DockPlanListVO> searchDockPlanList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException;

	/**
	 * Lowest List 을 조회 합니다.<br>
	 * 
	 * @param vesselInformationMgtConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<LowestListVO> searchLowestList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException;

	/**
	 * Loadable 을 조회 합니다.<br>
	 * 
	 * @param vesselInformationMgtConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<LoadableListVO> searchLoadableList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException;

	/**
	 * Loadable Info 을 조회 합니다.<br>
	 * 
	 * @param vesselLoadableInfoVO
	 * @return
	 * @throws EventException
	 */
	public List<VesselLoadableInfoVO> searchLoadableInfoList(VesselLoadableInfoVO vesselLoadableInfoVO) throws EventException;
	
	/**
	 * Performance Info 를 저장 합니다.
	 * 
	 * @param performanceInfoVO
	 * @param account
	 * @throws EventException
	 */
	public void managePerformanceInfo(PerformanceInfoVO performanceInfoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Vessel Loadable Info 를 저장 합니다.
	 * 
	 * @param vesselLoadableInfoVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageVesselLoadableInfo(VesselLoadableInfoVO[] vesselLoadableInfoVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Vessel Summary 정보를 조회한다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return List<VSLPartIVO>
	 * @exception EventException
	 */
	public List<VSLPartIVO> searchVesselSummary(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException;
	
}