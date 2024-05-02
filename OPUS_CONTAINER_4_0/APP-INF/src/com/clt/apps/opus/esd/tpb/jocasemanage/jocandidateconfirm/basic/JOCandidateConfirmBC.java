/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOCandidateConfirmBC.java
*@FileTitle : JOCandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.jocandidateconfirm.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.jocasemanage.jocandidateconfirm.vo.SearchJOCandidateConfirmListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -JOCaseManage Business Logic Command Interface<br>
 * - -JOCaseManage business logic interface<br>
 *
 * @author 
 * @see ESD_TPB_0105EventResponse reference
 * @since J2EE 1.6
 */

public interface JOCandidateConfirmBC {
	/**
	 * <br>
	 * 
	 * @param SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO
	 * @return List<SearchJOCandidateConfirmListVO>
	 * @exception EventException
	 */
	public List<SearchJOCandidateConfirmListVO> searchCandidateList(SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchJOCandidateConfirmListVO[] searchJOCandidateConfirmListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchJOCandidateConfirmListVO>
	 * @exception EventException
	 */
	public List<SearchJOCandidateConfirmListVO> multiCandidateConfirm(SearchJOCandidateConfirmListVO[] searchJOCandidateConfirmListVO,SignOnUserAccount account) throws EventException;
}