/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRoutePointProposalBC.java
*@FileTitle : S/C Proposal Org/Dst Location Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.vo.RsltRoutPntLocListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpRoutPntVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * -Handling a biz logic about  Scproposal<br>
 *
 * @author 
 * @see Esm_pri_0003_01EventResponse 
 * @since J2EE 1.6
 */

public interface SCRoutePointProposalBC {

    /**
	 *Checking whether data by ROUTE TYPE exists or not<br>
	 * 
	 * @param RsltRoutPntLocListVO rsltRoutPntLocListVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationType(RsltRoutPntLocListVO rsltRoutPntLocListVO) throws EventException;

	/**
	 * Retrieving Org/Dst Location<br>
	 * 
	 * @param RsltRoutPntLocListVO rsltRoutPntLocListVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationList(RsltRoutPntLocListVO rsltRoutPntLocListVO) throws EventException;

	/**
	 * Cancelling acceptance of Org/Dst Location<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRoutePointLocation(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * copying Org/Dst Location <br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
//	public void copyProposal(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * Cancelling all acceptance of Org/Dst Location information<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllRoutePoint(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * Accepting Org/Dst Location information=<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRoutePointLocation(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * Deleting all datas with related Amend seq no when Cancelling init status of Main<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Saving Org/Dst Location information<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRoutePointLocation(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * Accepting all of Org/Dst Location information<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllRoutePoint(PriSpScpRoutPntVO[] priSpScpRoutPntVO,SignOnUserAccount account) throws EventException;

	/**
	 * Requesting Amend<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     *  Copying Proposal Scope Route Point information<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeRoute(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * Modifying accepted data of main duration to "Init" at once when cancelling request<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException; 
	
	/**
	 * Retrieving Org/Dst Location information<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationHistoryList(PriSpScpRoutPntVO priSpScpRoutPntVO) throws EventException;
	/**
	 * Checking whether data by ROUTE TYPE exists or not<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationHistoryType(PriSpScpRoutPntVO priSpScpRoutPntVO) throws EventException;

	/**
	 * Retrieving Org/Dst Location information<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationInquiryList(PriSpScpRoutPntVO priSpScpRoutPntVO) throws EventException;
	/**
	 * Checking whether data by ROUTE TYPE exists or not<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO  
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationInquiryType(PriSpScpRoutPntVO priSpScpRoutPntVO) throws EventException;

}