/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneInformationMgtBC.java
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.16 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.LaneInfoConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusDeployedVesselVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusHJSVesselVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusServiceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.VskPortBnkRfuelRtoSheetVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskLanePicVO;

/**
 * ALPS2010-Vesseloperationsupportmgt Business Logic Command Interface<br>
 * - ALPS2010-Vesseloperationsupportmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Suk Hyun
 * @see Vop_vsk_0510EventResponse 참조
 * @since J2EE 1.6
 */

public interface LaneInformationMgtBC {
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * [Lane Group]을 [조회] 합니다.<br>
	 * 
	 * @param MdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchLaneGroupList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;

	/**
	 * VOP_VSK_0510 : Save <br>
	 * [MDM VSL SVC LANE]를 수정 합니다. <br>
	 * Lane Group Setting
	 * @param mdmVslSvcLaneVO MdmVslSvcLaneVO[] 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyLaneGroupS(MdmVslSvcLaneVO[] mdmVslSvcLaneVO, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * [Lane Group]을 [조회] 합니다.<br>
	 * 
	 * @param VskLanePicVO vskLanePicVO
	 * @return List<VskLanePicVO>
	 * @exception EventException
	 */
	public List<VskLanePicVO> searchPicList(VskLanePicVO vskLanePicVO) throws EventException;

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * [Bunkering Port Header]을 [조회] 합니다.<br>
	 * 
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchBunkeringPortHeader() throws EventException;
	
	/**
	 * VOP_VSK_0510 : Save <br>
	 * [VSK LANE PIC]를 삽입,수정,삭제 합니다. <br>
	 * 
	 * @param vskLanePicVOS VskLanePicVO[]
	 * @param account SignOnUserAccount
	 * @return List<VskLanePicVO>
	 * @exception EventException
	 */
	public List<VskLanePicVO> manageLaneInfoPic(VskLanePicVO[] vskLanePicVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * [Bunkering Port]을 [조회] 합니다.<br>
	 * 
	 * @param  vskLanePicVO VskLanePicVO
	 * @return List<VskPortBnkRfuelRtoSheetVO>
	 * @exception EventException
	 */
	public List<VskPortBnkRfuelRtoSheetVO> searchBunkeringPortList(VskLanePicVO vskLanePicVO) throws EventException;

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * [PIC RSO Code]을 [조회] 합니다.<br>
	 * 
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPicRsoList() throws EventException;
	
	/**
	 * VOP_VSK_0510 : Save <br>
	 * [VSK PORT BUNKER REFUELING RATIO]를 삽입,수정,삭제 합니다. <br>
	 * 
	 * @param vskPortBnkRfuelRtoSheetVOS VskPortBnkRfuelRtoSheetVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageLaneInfoBunkeringPort(VskPortBnkRfuelRtoSheetVO[] vskPortBnkRfuelRtoSheetVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * [Lane Status Service]을 [조회] 합니다.<br>
	 * 
	 * @param vskLanePicVO   VskLanePicVO
	 * @return List<StatusServiceVO>
	 * @exception EventException
	 */
	public List<StatusServiceVO> searchLaneStatusSearviceList(LaneInfoConditionVO vskLanePicVO) throws EventException;

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * [Lane Status Deploy Vessel]을 [조회] 합니다.<br>
	 * 
	 * @param vskLanePicVO   VskLanePicVO
	 * @return List<StatusDeployedVesselVO>
	 * @exception EventException
	 */
	public List<StatusDeployedVesselVO> searchLaneStatusDeployedVesselList(LaneInfoConditionVO vskLanePicVO) throws EventException;

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * [Lane Status Owner Vessel]을 [조회] 합니다.<br>
	 * 
	 * @param vskLanePicVO   VskLanePicVO
	 * @return List<StatusHJSVesselVO>
	 * @exception EventException
	 */
	public List<StatusHJSVesselVO> searchLaneStatusHJSVesselList(LaneInfoConditionVO vskLanePicVO) throws EventException;
	
}
