/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOCandidateConfirmBC.java
*@FileTitle : JOCandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-10-21 O Wan-Ki 			1.0	최초 생성
* 2009-09-14 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.vo.SearchJOCandidateConfirmListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-JOCaseManage Business Logic Command Interface<br>
 * - ALPS-JOCaseManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jong-Geon Byeon
 * @see ESD_TPB_0105EventResponse 참조
 * @since J2EE 1.6
 */

public interface JOCandidateConfirmBC {
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO
	 * @return List<SearchJOCandidateConfirmListVO>
	 * @exception EventException
	 */
	public List<SearchJOCandidateConfirmListVO> searchCandidateList(SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchJOCandidateConfirmListVO[] searchJOCandidateConfirmListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchJOCandidateConfirmListVO>
	 * @exception EventException
	 */
	public List<SearchJOCandidateConfirmListVO> multiCandidateConfirm(SearchJOCandidateConfirmListVO[] searchJOCandidateConfirmListVO,SignOnUserAccount account) throws EventException;
}