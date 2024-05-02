/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselInformationMgtBC.java
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 

=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DockPlanListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DraftWeightListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Vesseloperationsupportmgt Business Logic Command Interface<br>
 * - Interface of Business Logic about Vesseloperationsupportmgt
 *
 * @author 
 * @see Vop_vsk_0503EventResponse
 * @since J2EE 1.6
 */

public interface VesselInformationMgtBC {
	/**
	 * Retrieving Particular I, Particular II<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return VSLPartIVO
	 * @exception EventException
	 */
	public VSLPartIVO searchVSLPartI(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException;
	
	/**
	 * Retrieving Dock Plan<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return List<DockPlanListVO>
	 * @exception EventException
	 */
	public List<DockPlanListVO> searchDockPlanList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException;
	
	/**
	 * Retrieve Draft Weight <br>
	 * 
	 * @return List<DraftWeightListVO>
	 * @exception EventException
	 */
	public List<DraftWeightListVO> searchDraftWeightList() throws EventException;

	/**
	 * Save Draft Weight <br>
	 * 
	 * @param DraftWeightListVO[] draftWeightListVOs 
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> manageDraftWeightList(DraftWeightListVO[] draftWeightListVOs, SignOnUserAccount account) throws EventException;
}