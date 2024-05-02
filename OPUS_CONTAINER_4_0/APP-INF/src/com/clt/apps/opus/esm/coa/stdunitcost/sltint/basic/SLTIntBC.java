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
package com.clt.apps.opus.esm.coa.stdunitcost.sltint.basic;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.sltint.vo.SlotInternalPricingVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Stdunitcost Business Logic Command Interface<br>
 * - OPUS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Yeong-seok
 * @see 
 * @since J2EE 1.6
 */

public interface SLTIntBC {

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4001 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author SJH.20140916.ADD
	 */
    public CommonCoaRsVO searchSlotIPList(SearchConditionVO searchVO) throws EventException;
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4001 화면 대한 멀티 이벤트 처리<br>
     * 
     * @param SlotInternalPricingVO[] slotInternalPricingVO
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account 
     * @return String
     * @exception EventException
     * @author SJH.20140916.ADD
     */
    public String multiSlotIPInfo(SlotInternalPricingVO[] slotInternalPricingVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;    
	
}