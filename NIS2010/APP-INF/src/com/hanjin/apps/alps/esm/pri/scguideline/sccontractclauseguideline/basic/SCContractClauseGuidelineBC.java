/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractClauseGuidelineBC.java
*@FileTitle : SC Guideline Contract Clause
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.28 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.basic;

import com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.vo.CtrtCluzGlineVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgCtrtCluzVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung Jun Lee
 * @see Esm_pri_0001_07EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCContractClauseGuidelineBC {
	/**
	 * 조회 이벤트 처리<br>
	 *  SCBasicStandardNoteGuideline화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PriSgCtrtCluzVO priSgCtrtCluzVO
	 * @param String searchGubun
	 * @return CtrtCluzGlineVO
	 * @exception EventException
	 */
	public CtrtCluzGlineVO searchContractClauseGuidelineList(PriSgCtrtCluzVO priSgCtrtCluzVO, String searchGubun) throws EventException;
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * contract clause를 저장한다<br>
	 * 
	 * @param CtrtCluzGlineVO ctrtCluzGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageContractClauseGuideline(CtrtCluzGlineVO ctrtCluzGlineVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * contract clause  타이틀, 본문을 삭제한다<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException;
}