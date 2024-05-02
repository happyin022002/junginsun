/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMasterDataBC.java
*@FileTitle : Port Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanelRegistGRPVO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Vesselschedulemasterdata Business Logic Command Interface<br>
 * - business logic interface about Vesselschedulemasterdata<br>
 *
 * @author
 * @see Vop_vsk-0033EventResponse
 * @since J2EE 1.4
 */

public interface VesselScheduleMasterDataBC {
	
	/**
	 * Retrieving Port
	 * 
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @throws EventException
	 */
	public List<LocationVO> searchPortList(LocationVO locationVO) throws EventException;
	/**
	 * Modifying Port
	 * 
	 * @param LocationVO[] locationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPortList(LocationVO[] locationVOs,SignOnUserAccount account) throws EventException;
	/**
	 * Retrieving Lane Code List of Canal Agency
	 * 
	 * @return CanelRegistGRPVO
	 * @exception EventException
	 */
	public CanelRegistGRPVO searchLaneListByCanalAgency() throws EventException;
	
	/**
	 * Adding Lane Code List of Canal Agency
	 * 
	 * @param CanelRegistGRPVO canelRegistGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLaneListByCanalAgency(CanelRegistGRPVO canelRegistGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving Lane Group per User
	 * 
	 * @param String usrId
	 * @return List<UserLaneGroupVO>
	 * @exception EventException
	 */
	public List<UserLaneGroupVO> searchUserLaneGroup(String usrId) throws EventException;
	
	/**
	 * Adding Lane Group per User
	 * 
	 * @param UserLaneGroupVO[] userLaneGroupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageUserLaneGroup(UserLaneGroupVO[] userLaneGroupVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving Lane Group per User
	 * 
	 * @param String usrId
	 * @return List<UserLaneGroupVO>
	 * @exception EventException
	 */
	public List<UserLaneGroupVO> searchLaneGrpByUsrId(String usrId) throws EventException;
}