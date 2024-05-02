/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrSafetyStockManageBC.java
*@FileTitle : Safty Stock
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.11 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrEccSftStkVO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.vo.EesEqr0026ConditionVO;

/**
 * ALPS-Scenariomanage Business Logic Command Interface<br>
 * - ALPS-Scenariomanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Haeng-ji,Lee
 * @see Ees_eqr_0026EventResponse 참조
 * @since J2EE 1.6
 */

public interface CntrSafetyStockManageBC {

	/**
	 * [EES_EQR_0026 : Safty Stock - Search ]<br>
	 * 
	 * @param EesEqr0026ConditionVO	eesEqr0026ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrSafetyStock(EesEqr0026ConditionVO eesEqr0026ConditionVO) throws EventException;
	
	/**
	 * [EES_EQR_0026 : Safty Stock - Check SFST_VOL_QTY ]<br>
	 * 
	 * @param EesEqr0026ConditionVO	eesEqr0026ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrSafetyStockQty(EesEqr0026ConditionVO eesEqr0026ConditionVO) throws EventException;
	
	/**
	 * [EES_EQR_0026 : Safty Stock - Merge, Delete ]<br>
	 * 
	 * @param EqrScnrEccSftStkVO[] eqrScnrEccSftStkVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCntrSafetyStock(EqrScnrEccSftStkVO[] eqrScnrEccSftStkVO,SignOnUserAccount account) throws EventException;
}