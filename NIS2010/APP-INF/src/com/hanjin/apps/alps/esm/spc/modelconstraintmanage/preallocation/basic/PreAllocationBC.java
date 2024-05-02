/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreAllocationBC.java
*@FileTitle : Pre-Allocation Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.07 주선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.vo.SearchPreAllocation0068List01VO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqPreAlocVO;

/**
 * ALPS-Modelconstraintmanage Business Logic Command Interface<br>
 * - ALPS-Modelconstraintmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ju Sun Young
 * @see ESM_SPC_0067EventResponse 참조
 * @since J2EE 1.6
 */

public interface PreAllocationBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO	conditionVO
	 * @return List<ConditionVO>
	 * @exception EventException
	 */
	public List<SearchPreAllocation0068List01VO> searchPreAllocation0068List01(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SaqPreAlocVO[] saqPreAlocVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSaqPreAloc0067(SaqPreAlocVO[] saqPreAlocVO,SignOnUserAccount account) throws EventException;
}