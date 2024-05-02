/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanCompareBC.java
*@FileTitle : 이송계획 및 비용 상세 비교 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.12 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.basic;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo.EesEqr0135ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo.EesEqr0070ConditionVO;

/**
 * ALPS-CntrRepoPlanCompare Business Logic Command Interface<br>
 * - ALPS-CntrRepoPlanCompare 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author ChungEunHo
 * @see	EventResponse 참조
 * @since J2EE 1.6
 */

public interface CntrRepoPlanCompareBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EesEqr0070ConditionVO eesEqr0070ConditionVO
	 * @return List<EesEqr0070ConditionVO>
	 * @exception EventException
	 */
	public CommonRsVO searchRepoPlanAndCostDetail(EesEqr0070ConditionVO eesEqr0070ConditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0135ConditionVO EesEqr0135ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchRepoPlanAndCostFromToDetail(EesEqr0135ConditionVO eesEqr0135ConditionVO) throws EventException;
}