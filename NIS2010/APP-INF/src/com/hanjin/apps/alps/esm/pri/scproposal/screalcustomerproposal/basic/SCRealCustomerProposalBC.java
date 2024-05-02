/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCRealCustomerPoposalBC.java
*@FileTitle : Real Customer Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.23
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.09.23 
* 1.0 Creation
=========================================================
* History
* 2011.11.11 서미진 [CHM-201114405] Location 정보 추가로 입력할 수 있도록 처리
* =========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.PriSpRealCustVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.RsltRealCustInquiryVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;

/**
 * ALPS-Scproposal Business Logic Command Interface<br>
 * - ALPS-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SEO MI JIN
 * @see Esm_pri_0040EventResponse 참조
 * @since J2EE 1.6
 */

public interface SCRealCustomerProposalBC {

	/**
	 * ESM_PRI_0040 : RETRIEVE 
	 * Real Customer 정보를 조회 합니다.<br>
	 * 
	 * @param RsltRealCustInquiryVO rsltRealCustInquiryVO
     * @return List<RsltRealCustInquiryVO>
	 * @exception EventException
	 */
	public List<RsltRealCustInquiryVO> searchRealCustomerList(RsltRealCustInquiryVO rsltRealCustInquiryVO) throws EventException;	
	
	/**
	 * ESM_PRI_0040 : SAVE 
	 * Real Customer 정보를 저장 합니다.<br>
	 * 
	 * @param PriSpRealCustVO[] priSpRealCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRealCustomer(PriSpRealCustVO[] priSpRealCustVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Proposal No. AMD NO.에 해당하는 Real Customer를 모두 삭제 합니다. <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @exception EventException
	 */
	public void removeAllRealCustomer(PriSpMnVO priSpMnVO) throws EventException;
	
	/**
	 * Real Customer를 COPY 합니다. <br>
	 * 
	 * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyRealCustomer(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
	
	/**
	 * Real Customer를 Amnd +1  합니다. <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyAmendRealCustomer(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
     * ESM_PRI_0040 : OPEN<br>
     * Affiliate와 Loading Agent 의 cust 정보를 조회합니다.<br>
	 * 
	 * @param PriSpRealCustVO priSpRealCustVO
     * @return List<PriSpRealCustVO>
	 * @exception EventException
	 */
	public List<PriSpRealCustVO> searchAffiliateLoadingagentInfo(PriSpRealCustVO priSpRealCustVO) throws EventException;	
}