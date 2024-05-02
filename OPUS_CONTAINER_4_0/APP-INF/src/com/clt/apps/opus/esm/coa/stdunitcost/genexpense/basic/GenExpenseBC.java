/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GenExpenseBC.java
*@FileTitle : General Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.02.23 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.genexpense.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.vo.SearchGeneralExpenseVO;
import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.vo.SearchGeneralExpenseByVesselVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaDmdtN3rdPtyVO;

/**
 * OPUS-Stdunitcost Business Logic Command Interface<br>
 * - OPUS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUGMIN
 * @see 각 DAO 클래스 참조 
 * @since J2EE 1.6
 */

public interface GenExpenseBC {

	/**
	 * [일반관리비]을 [조회] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO	coaDmdtN3rdPtyVO
	 * @return List<SearchGeneralExpenseVO>
	 * @exception EventException
	 */
	public List<SearchGeneralExpenseVO> searchGeneralExpenseList(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws EventException;
	
	/**
	 * [일반관리비]을 [저장] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiGeneralExpense(CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO,SignOnUserAccount account) throws EventException;

	/**
	 * [VSL별 General Expense]을 [조회] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO	coaDmdtN3rdPtyVO
	 * @return List<SearchOwnDailyHireVO>
	 * @exception EventException
	 */
	public List<SearchGeneralExpenseByVesselVO> searchGeneralExpenseByVessel(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws EventException;

	/**
	 * [VSL Class별 평균 General Expense]을 [조회] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO	coaDmdtN3rdPtyVO
	 * @return List<SearchOwnDailyHireVO>
	 * @exception EventException
	 */
	public List<SearchGeneralExpenseByVesselVO> searchGeneralExpenseByVesselClass(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws EventException;
	
	/**
	 * [VSL별 GeneralExpense]을 [생성] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO	coaDmdtN3rdPtyVO
	 * @exception EventException
	 */
	public void createGeneralExpenseByVessel(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws EventException;

	/**
	 * [일반관리비]을 [저장] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 * @author SJH.20141229.ADD
	 */
	public void multiGeneralExpense3(CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [일반관리비]을 [저장] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 * @author SJH.20141229.ADD
	 */
	public void multiGeneralExpense4(CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO,SignOnUserAccount account) throws EventException;	
	
	
}