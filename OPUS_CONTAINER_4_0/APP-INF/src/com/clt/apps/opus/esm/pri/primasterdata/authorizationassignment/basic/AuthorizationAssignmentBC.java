/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AuthorizationAssignmentBC.java
*@FileTitle : Authority Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthorizationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComUserVO;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic about Primasterdata<br>
 *
 * @author
 * @see Esm_pri_0009EventResponse 
 * @since J2EE 1.6
 */

public interface AuthorizationAssignmentBC {
	/**
	 * Retrieving S/C Authority information.<br>
	 * 
	 * @param RsltAuthorizationVO rsltAuthorizationVO
	 * @return List<RsltAuthorizationVO>
	 * @exception EventException
	 */
	public List<RsltAuthorizationVO> searchScAuthorizationAssignmentList(RsltAuthorizationVO rsltAuthorizationVO) throws EventException;

    /**
     * Retrieving RFA Authority information<br>
     * 
     * @param RsltAuthorizationVO rsltAuthorizationVO
     * @return List<RsltAuthorizationVO>
     * @exception EventException
     */
    public List<RsltAuthorizationVO> searchRfaAuthorizationAssignmentList(RsltAuthorizationVO rsltAuthorizationVO) throws EventException;

	/**
	 * Saving Authority information<br>
	 * 
	 * @param RsltAuthorizationVO[] rsltAuthorizationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAuthorizationAssignment(RsltAuthorizationVO[] rsltAuthorizationVO,SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving combo list by organization user on Authority Creation screen<br>
	 * 
	 * @param ComUserVO comUserVO
	 * @return List<ComUserVO>
	 * @exception EventException
	 */
	public List<ComUserVO> searchComUserList (ComUserVO comUserVO) throws EventException;

    /**
     * Retrieving RFA Authorization's organization map<br>
     * 
     * @param OrganizationVO organizationVO
     * @return List<OrganizationVO>
     * @exception EventException
     */
    public List<OrganizationVO> searchRFAOfficeTreeList (OrganizationVO organizationVO) throws EventException;

    /**
     * Retrieving S/C Authorization's organization map<br>
     * 
     * @param OrganizationVO organizationVO
     * @return List<OrganizationVO>
     * @exception EventException
     */
    public List<OrganizationVO> searchSCOfficeTreeList (OrganizationVO organizationVO) throws EventException;
}