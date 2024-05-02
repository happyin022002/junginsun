/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NoShowReflectionBC.java
*@FileTitle : No-Show Ratio Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.07 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.vo.SearchNoShowReflectionListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcNshwRfltVO;

/**
 * ALPS-Modelconstraintmanage Business Logic Command Interface<br>
 * - ALPS-Modelconstraintmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HJ.LEE
 * @see Esm_spc_0015EventResponse 참조
 * @since J2EE 1.6
 */

public interface NoShowReflectionBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchNoShowReflectionListVO	searchNoShowReflectionListVO
	 * @return List<SearchNoShowReflectionListVO>
	 * @exception EventException
	 */
	public List<SearchNoShowReflectionListVO> searchNoShowReflectionList(SearchNoShowReflectionListVO searchNoShowReflectionListVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SpcNshwRfltVO[] spcNshwRfltVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiNoShowReflection(SpcNshwRfltVO[] spcNshwRfltVO,SignOnUserAccount account) throws EventException;
}