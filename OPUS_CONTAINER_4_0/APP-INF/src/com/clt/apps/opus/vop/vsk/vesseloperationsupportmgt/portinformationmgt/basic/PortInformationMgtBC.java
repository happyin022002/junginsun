/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortInformationMgtBC.java
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmYardComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationMgtVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlPassCondVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlTrScgListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDistVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDocBufTmVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortNworkVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortTrspCondVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.VskPortCnlTrScgVO;

/**
 * Vesseloperationsupportmgt Business Logic Command Interface<br>
 * - Interface of Business Logic about Vesseloperationsupportmgt<br>
 *
 * @author 
 * @see Vop_vsk_0004EventResponse
 * @since J2EE 1.6
 */

public interface PortInformationMgtBC {
	/**
	 * Retrieving Maneuvering in Port Information Creation<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<PortInformationMgtVO>
	 * @exception EventException
	 */
	public List<PortInformationMgtVO> searchManueveringList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Maneuvering Terminal Non-Working in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortNworkVO>
	 * @exception EventException
	 */	
	public List<VskPortNworkVO> searchNonWorkingList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Retrieving Distance in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortDistVO>
	 * @exception EventException
	 */	
	public List<VskPortDistVO> searchDistanceList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Retrieving Doc.&Dead Hrs in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortDocBufTmVO>
	 * @exception EventException
	 */	
	public List<VskPortDocBufTmVO> searchDocHourList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Retrieving Canal in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlPassCondVO> 
	 * @exception EventException
	 */	
	public List<VskPortCnlPassCondVO> searchCanelList(PortInformationConditionVO portInformationConditionVO) throws EventException;	
	/**
	 * Retrieving 2nd grid of Canal in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlTrScgListVO> 
	 * @exception EventException
	 */	
	public List<VskPortCnlTrScgListVO> searchPortCnlTrScgList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Retrieving 2nd grid for saving of Canal in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlTrScgVO> 
	 * @exception EventException
	 */	
	public List<VskPortCnlTrScgVO> searchPortCnlTrScg(PortInformationConditionVO portInformationConditionVO) throws EventException;	
	/**
	 * Retrieving Trucking in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortTrspCondVO> 
	 * @exception EventException
	 */	
	public List<VskPortTrspCondVO> searchTruckingList(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Retrieving Railroad in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortTrspCondVO> 
	 * @exception EventException
	 */	
	public List<VskPortTrspCondVO> searchRailLoadList(PortInformationConditionVO portInformationConditionVO) throws EventException;	
	
	/**
	 *  Retrieving TMNL Code in Maneuvering
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmYardCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Retrieving RHQ of Port Code
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmRhqLocCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Retrieving Port for Doc.&Dead Hrs
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmRhqDocLocCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Retrieving Port Code
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmRhqComboVO>
	 * @exception EventException
	 */
	public List<MdmRhqComboVO> searchMdmRhqCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Retrieving Port Code
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmLocCdCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	/**
	 * Retrieving RHQ Code
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmTrspLocCombo(PortInformationConditionVO portInformationConditionVO) throws EventException;
	
	/**
	 * Saving Maneuvering
	 * 
	 * @param PortInformationMgtVO[] portInformationMgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortInfo(PortInformationMgtVO[] portInformationMgtVO,SignOnUserAccount account) throws EventException;
	/**
	 * Saving Terminal Non-Working
	 * 
	 * @param VskPortNworkVO[] vskPortNworkVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNonWorking(VskPortNworkVO[] vskPortNworkVO,SignOnUserAccount account) throws EventException;
	/**
	 * Saving Distance
	 * 
	 * @param VskPortDistVO[] vskPortDistVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortDistance(VskPortDistVO[] vskPortDistVO,SignOnUserAccount account) throws EventException;
	/**
	 * Saving Doc.&Dead Hrs>
	 * 
	 * @param VskPortDocBufTmVO[] vskPortDocBufTmVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortDocHour(VskPortDocBufTmVO[] vskPortDocBufTmVO,SignOnUserAccount account) throws EventException;
	/**
	 * Saving Canal
	 * 
	 * @param VskPortCnlPassCondVO[] vskPortCnlPassCondVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortCanel(VskPortCnlPassCondVO[] vskPortCnlPassCondVO,SignOnUserAccount account) throws EventException;
	/**
	 * Saving Canal
	 * 
	 * @param VskPortCnlTrScgVO[] vskPortCnlTrScgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortCnlTrScg(VskPortCnlTrScgVO[] vskPortCnlTrScgVO,SignOnUserAccount account) throws EventException;	
	/**
	 * Saving Trucking
	 * 
	 * @param VskPortTrspCondVO[] vskPortTrspCondVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortTrucking(VskPortTrspCondVO[] vskPortTrspCondVO,SignOnUserAccount account) throws EventException;
	/**
	 * Saving Railroad
	 * 
	 * @param VskPortTrspCondVO[] vskPortTrspCondVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortRailLoad(VskPortTrspCondVO[] vskPortTrspCondVO,SignOnUserAccount account) throws EventException;
	
		/**
	 * Save Tier Surcharge <br>
	 * 
	 * @param VskPortCnlTrScgVO[] vskPortCnlTrScgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTierSurcharge(VskPortCnlTrScgVO[] vskPortCnlTrScgVO, SignOnUserAccount account) throws EventException;
	
}