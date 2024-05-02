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
* 2009-09-17 장영석  New Framework 적용 [0152]
* 2010.02.05 임옥영 품질검토 결과 반영
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mriinquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaMonMiscRevPreTeuVO;


/**
 * ALPS-Stdunitcost Business Logic Command Interface<br>
 * - ALPS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
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
}