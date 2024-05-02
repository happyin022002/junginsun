/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortLimitManagementBC.java
*@FileTitle : PortLimitManagement
*Open Issues :
*Change history : 2014.11.21
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.basic;

import java.util.List;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsBkgVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsDataVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsDgTotalWeightVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLimitsUnNoVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.vo.PortLmtSubsRskVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-portlimitmanagement Business Logic Command Interface<br>
 * - OPUS-portlimitmanagement 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Un Jeong
 * @see VOP_SCG-5021EventResponse 참조
 * @since J2EE 1.4
 */

public interface PortLimitManagementBC {
	
	/**
	 * VOP_SCG_5021 : Retrieve <br>
	 * Retrieve Port Limit Info
	 * @category VOP_SCG_5021
	 * @category PortLimitManagementBC 
	 * @param PortLimitsDataVO portLimitsDataVO
	 * @return List<PortLimitsDataVO> 
	 * @exception EventException
	 */	
	public List<PortLimitsDataVO> searchPortLimitsData(PortLimitsDataVO portLimitsDataVO) throws EventException;
	
	/**
	 * VOP_SCG_5023 : Class Retrieve <br>
	 * Retrieve Port Limit Class Info<br>
	 * 
	 * @param PortLimitsDataVO portLimitsDataVO
	 * @return List<PortLimitsDataVO>
	 * @exception EventException
	 */
	public List<PortLimitsDataVO> searchPortLimitsClass(PortLimitsDataVO portLimitsDataVO) throws EventException;
	
	/**
	 * VOP_SCG_5024 : Bkg Retrieve <br>
	 * Retrieve Port Limit Bkg Info<br>
	 * 
	 * @param PortLimitsBkgVO portLimitsBkgVO
	 * @return List<PortLimitsBkgVO>
	 * @exception EventException
	 */
	public List<PortLimitsBkgVO> searchPortLimitsBkg(PortLimitsBkgVO portLimitsBkgVO) throws EventException;
	
	/**
	 * VOP_SCG_5922 : Un No Retrieve <br>
	 * Retrieve Port Limit Class Info<br>
	 * 
	 * @param PortLimitsDataVO portLimitsDataVO
	 * @return List<PortLimitsDataVO>
	 * @exception EventException
	 */
	public List<PortLimitsDataVO> searchPortLimitsUnNo(PortLimitsDataVO portLimitsDataVO) throws EventException;
	
	/**
	 * VOP_SCG_5923 : SubRsk Retrieve <br>
	 * Retrieve Port Limit Class Info<br>
	 * 
	 * @param PortLmtSubsRskVO portLmtSubsRskVO
	 * @return List<PortLmtSubsRskVO>
	 * @exception EventException
	 */
	public List<PortLmtSubsRskVO> searchPortLimitsSubRsk(PortLmtSubsRskVO portLmtSubsRskVO) throws EventException;
	
	/**
	 * VOP_SCG_5021 : Manage <br>
	 * Manage Port Limit Info
	 * @category VOP_SCG_5021
	 * @category PortLimitManagementBC 
	 * @param PortLimitsDataVO[] portLimitsDataVOs
	 * @param String gubun
	 * @exception EventException
	 */	
	public void managePortLimitsData(PortLimitsDataVO[] portLimitsDataVOs, String gubun) throws EventException;
	
	/**
	 * VOP_SCG_5922 : Manage <br>
	 * Manage Port Limit Detail Save
	 * @category VOP_SCG_5922
	 * @category PortLimitManagementBC 
	 * @param PortLimitsDataVO[] portLimitsDataVOs
	 * @param PortLimitsUnNoVO[] portLimitsUnNoVOs
	 * @exception EventException
	 */	
	public void managePortLimitsClass(PortLimitsDataVO[] portLimitsDataVOs, PortLimitsUnNoVO[] portLimitsUnNoVOs) throws EventException;

	/**
	 * VOP_SCG_5923 : Manage <br>
	 * Manage Port Limit SubRsk Save
	 * @category VOP_SCG_5923
	 * @category PortLimitManagementBC 
	 * @param PortLmtSubsRskVO[] portLmtSubsRskVOs
	 * @exception EventException
	 */	
	public void managePortLimitsSubRsk(PortLmtSubsRskVO[] portLmtSubsRskVOs) throws EventException;
	
	/**
	 * VOP_SCG_5022 : Retrieve <br>
	 * Retrieve Port Limits DG Total Weight
	 * @category VOP_SCG_5022
	 * @category PortLimitManagementBC 
	 * @param PortLimitsDgTotalWeightVO portLimitsDgTotalWeightVO
	 * @return List<PortLimitsDgTotalWeightVO>
	 * @exception EventException
	 */	
	public List<PortLimitsDgTotalWeightVO> searchPortLimitsDgTotalWeightCheck(PortLimitsDgTotalWeightVO portLimitsDgTotalWeightVO) throws EventException;
	
	/**
	 * VOP_SCG_5921 : PortLmtSeq Search & Setting
	 * @param portLimitsDataVO
	 * @return String
	 * @throws EventException
	 */
	public String srchPortLmtSeq(PortLimitsDataVO portLimitsDataVO) throws EventException;
	
}
