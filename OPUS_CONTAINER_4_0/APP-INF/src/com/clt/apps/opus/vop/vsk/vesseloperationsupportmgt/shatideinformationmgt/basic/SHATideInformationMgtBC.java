/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SHATideInformationMgtBC.java
*@FileTitle : SHA Tide Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.SHATideInformationMgtConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.VskPortTideVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Vesseloperationsupportmgt Business Logic Command Interface<br>
 * - Interface of Business Logic about Vesseloperationsupportmgt
 *
 * @author 
 * @see Vop_vsk_0013EventResponse
 * @since J2EE 1.6
 */

public interface SHATideInformationMgtBC {
	/**
	 * Retrieving SHA Tide Information Creation
	 * 
	 * @param SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO
	 * @return List<VskPortTideVO> 
	 * @exception EventException
	 */
	public List<VskPortTideVO> searchTideInfoList(SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO) throws EventException;
	/**
	 * Saving SHA Tide Information Creation
	 * 
	 * @param VskPortTideVO[] vskPortTideVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTideInfo(VskPortTideVO[] vskPortTideVOs,SignOnUserAccount account) throws EventException;
	/**
	 * Retrieving Port Code<br>
	 * 
	 * @param SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO
	 * @return VskPortTideVO
	 * @exception EventException
	 */
	public VskPortTideVO searchPortCode(SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO) throws EventException;
}