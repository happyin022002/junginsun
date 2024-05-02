/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneInformationMgtBC.java
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.LaneInfoConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusDeployedVesselVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusVesselVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusServiceVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.VskPortBnkRfuelRtoSheetVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskLanePicVO;

/**
 * Vesseloperationsupportmgt Business Logic Command Interface<br>
 * - Interface of Business Logic about Vesseloperationsupportmgt<br>
 *
 * @author 
 * @see Vop_vsk_0510EventResponse 
 * @since J2EE 1.6
 */

public interface LaneInformationMgtBC {
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Group
	 * 
	 * @param mdmVslSvcLaneVO MdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchLaneGroupList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;

	/**
	 * VOP_VSK_0510 : Save <br>
	 * Modifying MDM VSL SVC LANE
	 * Lane Group Setting
	 * @param mdmVslSvcLaneVO MdmVslSvcLaneVO[] 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyLaneGroupS(MdmVslSvcLaneVO[] mdmVslSvcLaneVO, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Group
	 * 
	 * @param VskLanePicVO vskLanePicVO
	 * @return List<VskLanePicVO>
	 * @exception EventException
	 */
	public List<VskLanePicVO> searchPicList(VskLanePicVO vskLanePicVO) throws EventException;

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Bunkering Port Header
	 * 
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchBunkeringPortHeader() throws EventException;
	
	/**
	 * VOP_VSK_0510 : Save <br>
	 * Modifying VSK LANE PIC<br>
	 * 
	 * @param vskLanePicVOS VskLanePicVO[]
	 * @param account SignOnUserAccount
	 * @return List<VskLanePicVO>
	 * @exception EventException
	 */
	public List<VskLanePicVO> manageLaneInfoPic(VskLanePicVO[] vskLanePicVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Bunkering Port<br>
	 * 
	 * @param  vskLanePicVO VskLanePicVO
	 * @return List<VskPortBnkRfuelRtoSheetVO>
	 * @exception EventException
	 */
	public List<VskPortBnkRfuelRtoSheetVO> searchBunkeringPortList(VskLanePicVO vskLanePicVO) throws EventException;

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving PIC RSO Code
	 * 
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPicRsoList() throws EventException;
	
	/**
	 * VOP_VSK_0510 : Save <br>
	 * Modifying VSK PORT BUNKER REFUELING RATIO
	 * 
	 * @param vskPortBnkRfuelRtoSheetVOS VskPortBnkRfuelRtoSheetVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageLaneInfoBunkeringPort(VskPortBnkRfuelRtoSheetVO[] vskPortBnkRfuelRtoSheetVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Bunkering Port
	 * 
	 * @param vskLanePicVO   VskLanePicVO
	 * @return List<StatusServiceVO>
	 * @exception EventException
	 */
	public List<StatusServiceVO> searchLaneStatusSearviceList(LaneInfoConditionVO vskLanePicVO) throws EventException;

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Status Deployed Vessel
	 * 
	 * @param vskLanePicVO   VskLanePicVO
	 * @return List<StatusDeployedVesselVO>
	 * @exception EventException
	 */
	public List<StatusDeployedVesselVO> searchLaneStatusDeployedVesselList(LaneInfoConditionVO vskLanePicVO) throws EventException;

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Status Owner Vessel
	 * 
	 * @param vskLanePicVO   VskLanePicVO
	 * @return List<StatusVesselVO>
	 * @exception EventException
	 */
	public List<StatusVesselVO> searchLaneStatusVesselList(LaneInfoConditionVO vskLanePicVO) throws EventException;
	
}
