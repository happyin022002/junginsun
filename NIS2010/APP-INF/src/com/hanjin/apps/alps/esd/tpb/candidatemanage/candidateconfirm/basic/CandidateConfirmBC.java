/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CandidateConfirmBC.java
*@FileTitle : CandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.vo.SearchCandidateListVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.vo.SearchNonTPBDescVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Candidatemanage Business Logic Command Interface<br>
 * - ALPS-Candidatemanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author GUN-HA HWANG
 * @see Esd_tpb_1050EventResponse 참조
 * @since J2EE 1.6
 */

public interface CandidateConfirmBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCandidateListVO	searchCandidateListVO
	 * @return List<SearchCandidateListVO>
	 * @exception EventException
	 */
	public List<SearchCandidateListVO> searchCandidateList(SearchCandidateListVO searchCandidateListVO) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCandidateListVO[] searchCandidateListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchCandidateListVO>
	 * @exception EventException
	 */
	public List<SearchCandidateListVO> multiCandidateConfirm(SearchCandidateListVO[] searchCandidateListVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCandidateListVO[] searchCandidateListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiNonTPBCfmDt(SearchCandidateListVO[] searchCandidateListVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchNonTPBDescVO	searchNonTPBDescVO
	 * @return List<SearchNonTPBDescVO>
	 * @exception EventException
	 */
	public List<SearchNonTPBDescVO> searchNonTPBDesc(SearchNonTPBDescVO searchNonTPBDescVO) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchNonTPBDescVO[] searchNonTPBDescVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiNonTPBDesc(SearchNonTPBDescVO[] searchNonTPBDescVO,SignOnUserAccount account) throws EventException;
}