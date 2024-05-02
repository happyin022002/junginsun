/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CandidateConfirmBC.java
*@FileTitle : CandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.vo.SearchCandidateListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Candidatemanage Business Logic Command Interface<br>
 * - Candidatemanage Business Logic Interface<br>
 *
 * @author 
 * @see Esd_tpb_1050EventResponse reference
 * @since J2EE 1.6
 */

public interface CandidateConfirmBC {

	/**
	 * <br>
	 * 
	 * @param SearchCandidateListVO	searchCandidateListVO
	 * @return List<SearchCandidateListVO>
	 * @exception EventException
	 */
	public List<SearchCandidateListVO> searchCandidateList(SearchCandidateListVO searchCandidateListVO) throws EventException;

	/**
	 * <br>
	 * 
	 * @param SearchCandidateListVO[] searchCandidateListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchCandidateListVO>
	 * @exception EventException
	 */
	public List<SearchCandidateListVO> multiCandidateConfirm(SearchCandidateListVO[] searchCandidateListVO,SignOnUserAccount account) throws EventException;
}