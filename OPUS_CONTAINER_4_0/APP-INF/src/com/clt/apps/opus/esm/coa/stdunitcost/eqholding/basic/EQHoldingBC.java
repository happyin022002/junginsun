/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQHoldingBC.java
*@FileTitle : 실적장비비 표준단가 조회, 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.26 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.eqholding.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.eqholding.vo.EqHoldingCostVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Stdunitcost Business Logic Command Interface<br>
 * - OPUS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Song Ho Jin
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public interface EQHoldingBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO	conditionVO
	 * @return List<EqHoldingCostVO>
	 * @exception EventException
	 */
	public List<EqHoldingCostVO> searchEQHoldingCost(SearchConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EqHoldingCostVO[] eqHoldingCostVO
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiEQHoldingCost(EqHoldingCostVO[] eqHoldingCostVO, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException;
}