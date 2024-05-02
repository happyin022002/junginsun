/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MaxLoadFactorBC.java
*@FileTitle : Maximum L/F Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.08.12 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.vo.SearchMaxLoadFactorListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcMaxLodFctrVO;

/**
 * ALPS-Modelconstraintmanage Business Logic Command Interface<br>
 * - ALPS-Modelconstraintmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HJ.LEE
 * @see Esm_spc_0019EventResponse 참조
 * @since J2EE 1.6
 */

public interface MaxLoadFactorBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchMaxLoadFactorListVO>
	 * @exception EventException
	 */
	public List<SearchMaxLoadFactorListVO> searchMaxLoadFactorList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SpcMaxLodFctrVO[] spcMaxLodFctrVO
	 * @param String bse_yr
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiMaxLoadFactor(SpcMaxLodFctrVO[] spcMaxLodFctrVO, String bse_yr, SignOnUserAccount account) throws EventException;
}