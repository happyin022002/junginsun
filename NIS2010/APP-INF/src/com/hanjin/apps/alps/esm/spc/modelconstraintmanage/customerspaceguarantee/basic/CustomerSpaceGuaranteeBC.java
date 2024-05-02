/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomerSpaceGuaranteeBC.java
*@FileTitle : TP/SZ Volume Calculation Terms
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.07 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.vo.SearchCustomerSpaceGuaranteeConvLaneListVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.vo.SearchCustomerSpaceGuaranteeConvListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqCntrSzConvLaneVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqCntrSzConvVO;

/**
 * ALPS-Modelconstraintmanage Business Logic Command Interface<br>
 * - ALPS-Modelconstraintmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0062EventResponse 참조
 * @since J2EE 1.6
 */

public interface CustomerSpaceGuaranteeBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCustomerSpaceGuaranteeConvLaneListVO	searchCustomerSpaceGuaranteeConvLaneListVO
	 * @return List<SearchCustomerSpaceGuaranteeConvLaneListVO>
	 * @exception EventException
	 */
	public List<SearchCustomerSpaceGuaranteeConvLaneListVO> searchCustomerSpaceGuaranteeConvLaneList(SearchCustomerSpaceGuaranteeConvLaneListVO searchCustomerSpaceGuaranteeConvLaneListVO) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCustomerSpaceGuaranteeConvListVO	searchCustomerSpaceGuaranteeConvListVO
	 * @return List<SearchCustomerSpaceGuaranteeConvListVO>
	 * @exception EventException
	 */
	public List<SearchCustomerSpaceGuaranteeConvListVO> searchCustomerSpaceGuaranteeConvList(SearchCustomerSpaceGuaranteeConvListVO searchCustomerSpaceGuaranteeConvListVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SaqCntrSzConvVO[] saqCntrSzConvVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCustomerSpaceGuarantee1(SaqCntrSzConvVO[] saqCntrSzConvVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SaqCntrSzConvLaneVO[] saqCntrSzConvLaneVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCustomerSpaceGuarantee2(SaqCntrSzConvLaneVO[] saqCntrSzConvLaneVO,SignOnUserAccount account) throws EventException;
}