/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CalculateBC.java
 *@FileTitle : Rate Proposal
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.24
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 2010.03.24  송민석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.basic;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.RsltPriPrsRoutCsMaxRoutCsNoVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InPriPrsRoutCsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
  
 

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Moon Dong Gyu
 * @see Ui_pri_0030EventResponse 참조
 * @since J2EE 1.4
 */

public interface CalculateBC {

	/**
	 * Route Case 내용을 Used 로 카피한다.. .<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyCoaCostInfoToOnlineCostInfo(InPriPrsRoutCsVO inPriPrsRoutCsVO,SignOnUserAccount account ) throws EventException;
	
	
	/**
	 * Route Case 내용을 Used 로 카피한다.. .<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyOnlineCostInfoToBatchCostInfo(InPriPrsRoutCsVO inPriPrsRoutCsVO,SignOnUserAccount account ) throws EventException;
	
	
	
	/**
	 * BATCH DB에 Route Case를 추가 한다. .<br>
	 * 
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriPrsRouteCase(InPriPrsRoutCsVO inPriPrsRoutCsVO, SignOnUserAccount account) throws EventException;
	

	/**
	 *  
	 * ROUT_CS_NO를 sequence에서 조회 해 온다.
	 *  
	 * @param InPriPrsRoutCsVO inPriPrsRoutCsVO
	 * @return RsltPriPrsRoutCsMaxRoutCsNoVO
	 * @exception EventException
	 */
	public  RsltPriPrsRoutCsMaxRoutCsNoVO searchPriPrsRoutCsMaxRoutCsNoCalculate(InPriPrsRoutCsVO inPriPrsRoutCsVO) throws EventException ;
	
}