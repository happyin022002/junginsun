/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConstraintItemBC.java
*@FileTitle : Constraints List Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.07.30 이현주
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.vo.SearchConstraintItem063LoadableListVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.vo.SearchConstraintItemListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqMdlCnstVO;

/**
 * ALPS-Modelconstraintmanage Business Logic Command Interface<br>
 * - ALPS-Modelconstraintmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HJ.LEE
 * @see Esm_spc_0011EventResponse 참조
 * @since J2EE 1.6
 */

public interface ConstraintItemBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConstraintItemListVO	searchConstraintItemListVO
	 * @return List<SearchConstraintItemListVO>
	 * @exception EventException
	 */
	public List<SearchConstraintItemListVO> searchConstraintItemList(SearchConstraintItemListVO searchConstraintItemListVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO	conditionVO
	 * @return List<SearchConstraintItem063LoadableListVO>
	 * @exception EventException
	 */
	public List<SearchConstraintItem063LoadableListVO> searchConstraintItem063LoadableList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SaqMdlCnstVO[] saqMdlCnstVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiConstraintItem(SaqMdlCnstVO[] saqMdlCnstVO,SignOnUserAccount account) throws EventException;
}