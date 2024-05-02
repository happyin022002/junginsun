/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalProductivityBC.java
*@FileTitle : Terminal Productivity Target Input
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.vo.TmlProdTgtInpVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Performancemanagement Business Logic Command Interface<br>
 * - ALPS-Performancemanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface TerminalProductivityBC {


	/**
	 * Terminal Productivity Target Input 을 조회한다.<br>
	 * 
	 * @param TmlProdTgtInpVO	tmlProdTgtInpVO
	 * @return List<EGAndBEMappingVO>
	 * @exception EventException
	 */
	public List<TmlProdTgtInpVO> selectTmlProdTgtInp(TmlProdTgtInpVO tmlProdTgtInpVO) throws EventException;
	
	/**
	 * Terminal Productivity 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param TmlProdTgtInpVO[]	tmlProdTgtInpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiTmlProdTgtInp(TmlProdTgtInpVO[] tmlProdTgtInpVOs,SignOnUserAccount account) throws EventException;
	
}