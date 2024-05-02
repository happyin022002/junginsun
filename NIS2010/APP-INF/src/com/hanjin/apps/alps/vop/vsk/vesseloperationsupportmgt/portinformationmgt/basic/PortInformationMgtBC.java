/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortInformationMgtBC.java
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.26 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmYardComboVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationMgtVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlPassCondVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlTrScgListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDistVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDocBufTmVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortNworkVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortTrspCondVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskPortCnlTrScgVO;

/**
 * NIS2010-Vesseloperationsupportmgt Business Logic Command Interface<br>
 * - NIS2010-Vesseloperationsupportmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jong Ock
 * @see Vop_vsk_0004EventResponse 참조
 * @since J2EE 1.6
 */

public interface PortInformationMgtBC {
	/**
	 * Port Information Creation에 Maneuvering 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<PortInformationMgtVO>
	 * @exception EventException
	 */
	public List<PortInformationMgtVO> searchManueveringList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Port Information Creation에 Terminal Non-Working 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortNworkVO>
	 * @exception EventException
	 */	
	public List<VskPortNworkVO> searchNonWorkingList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Port Information Creation에 Distance 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortDistVO>
	 * @exception EventException
	 */	
	public List<VskPortDistVO> searchDistanceList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Port Information Creation에 Doc.&Dead Hrs 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortDocBufTmVO>
	 * @exception EventException
	 */	
	public List<VskPortDocBufTmVO> searchDocHourList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Port Information Creation에 Canal 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlPassCondVO> 
	 * @exception EventException
	 */	
	public List<VskPortCnlPassCondVO> searchCanelList(PortInformationConditionVO portInformationConditionVO) throws EventException;	
	/**
	 * Port Information Creation에 Canal 을 두번재 그리드 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlTrScgListVO> 
	 * @exception EventException
	 */	
	public List<VskPortCnlTrScgListVO> searchPortCnlTrScgList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Port Information Creation에 Canal 을 두번재 그리드 저장용 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlTrScgVO> 
	 * @exception EventException
	 */	
	public List<VskPortCnlTrScgVO> searchPortCnlTrScg(PortInformationConditionVO portInformationConditionVO) throws EventException;	
	/**
	 * Port Information Creation에 Trucking 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortTrspCondVO> 
	 * @exception EventException
	 */	
	public List<VskPortTrspCondVO> searchTruckingList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Port Information Creation에 Railroad 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortTrspCondVO> 
	 * @exception EventException
	 */	
	public List<VskPortTrspCondVO> searchRailLoadList(PortInformationConditionVO portInformationConditionVO) throws EventException;	
	
	/**
	 *  Maneuvering에 등록 가능한 TMNL Code을 조회(콤보생성) 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmYardCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * 조회 조건에서 Port Code에 해당하는 RHQ를 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmRhqLocCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Doc.&Dead Hrs 등록 가능한 Port 을 조회(콤보생성) 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmRhqDocLocCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * 등록 가능한 Port Code 을 조회(콤보생성) 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmRhqComboVO>
	 * @exception EventException
	 */
	public List<MdmRhqComboVO> searchMdmRhqCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * 등록 가능한 Port 을 조회(콤보생성) 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmLocCdCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * RHQ Code 을 조회 합니다.<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmTrspLocCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	
	/**
	 * Maneuvering 을 저장 합니다.<br>
	 * 
	 * @param PortInformationMgtVO[] portInformationMgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortInfo(PortInformationMgtVO[] portInformationMgtVO,SignOnUserAccount account) throws EventException;
	/**
	 * Terminal Non-Working 을 저장 합니다.<br>
	 * 
	 * @param VskPortNworkVO[] vskPortNworkVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNonWorking(VskPortNworkVO[] vskPortNworkVO,SignOnUserAccount account) throws EventException;
	/**
	 * Distance 을 저장 합니다.<br>
	 * 
	 * @param VskPortDistVO[] vskPortDistVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortDistance(VskPortDistVO[] vskPortDistVO,SignOnUserAccount account) throws EventException;
	/**
	 * Doc.&Dead Hrs 을 저장 합니다.<br>
	 * 
	 * @param VskPortDocBufTmVO[] vskPortDocBufTmVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortDocHour(VskPortDocBufTmVO[] vskPortDocBufTmVO,SignOnUserAccount account) throws EventException;
	/**
	 * Canal 을 저장 합니다.<br>
	 * 
	 * @param VskPortCnlPassCondVO[] vskPortCnlPassCondVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortCanel(VskPortCnlPassCondVO[] vskPortCnlPassCondVO,SignOnUserAccount account) throws EventException;
	/**
	 * Canal 을 저장 합니다.<br>
	 * 
	 * @param VskPortCnlTrScgVO[] vskPortCnlTrScgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortCnlTrScg(VskPortCnlTrScgVO[] vskPortCnlTrScgVO,SignOnUserAccount account) throws EventException;	
	/**
	 * Trucking 을 저장 합니다.<br>
	 * 
	 * @param VskPortTrspCondVO[] vskPortTrspCondVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortTrucking(VskPortTrspCondVO[] vskPortTrspCondVO,SignOnUserAccount account) throws EventException;
	/**
	 * Railroad 을 저장 합니다.<br>
	 * 
	 * @param VskPortTrspCondVO[] vskPortTrspCondVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortRailLoad(VskPortTrspCondVO[] vskPortTrspCondVO,SignOnUserAccount account) throws EventException;
	
}