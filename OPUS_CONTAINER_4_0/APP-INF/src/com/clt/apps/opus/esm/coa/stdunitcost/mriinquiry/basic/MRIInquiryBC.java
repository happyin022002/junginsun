/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : MRIInquiryBC.java
*@FileTitle      : MRI 운임수입 단가 생성
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-17
*@LastModifier   : 장영석
*@LastVersion    : 1.3
* 2008-04-30 PEJ
* 1.0 최초 생성
* Change history  :
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaMonMiscRevPreTeuVO;


/**
 * OPUS-Stdunitcost Business Logic Command Interface<br>
 * - OPUS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Yeong-seok
 * @see 
 * @since J2EE 1.6
 */

public interface MRIInquiryBC {

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0152 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchMRIInquiryListVO searchMRIInquiryListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMRIInquiryListVO>
	 * @exception EventException
	 */
	public List<SearchMRIInquiryListVO> searchMRIInquiryList(SearchMRIInquiryListVO searchMRIInquiryListVO, SearchConditionVO searchConditionVO) throws EventException;
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_152 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param CoaMonMiscRevPreTeuVO[] coaMonMiscRevPreTeuVO
	 * @param SearchConditionVO searchConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiMRIInquiry(CoaMonMiscRevPreTeuVO[] coaMonMiscRevPreTeuVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0152 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchMRIInquiryListVO[] searchMRIInquiryListVO
	 * @return List<GetCodeSelectVO>
	 * @exception EventException
	 */
	public List<GetCodeSelectVO> searchMRIInquiryCheck(SearchMRIInquiryListVO[] searchMRIInquiryListVO) throws EventException;
	
}