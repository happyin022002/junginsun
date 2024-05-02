/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TermChangeBC.java
*@FileTitle : Term Change Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.03 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.SearchParamVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.TermChangeInquiryVO;


/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Jun-Woo
 * @see Ees_lse_0005EventResponse 참조
 * @since J2EE 1.6
 */

public interface TermChangeBC {

	/**
	 * 입력받은 Activity Date에 대한 유효성을 검증합니다.<br>
	 *
	 * @param searchParamVO searchParamVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchAvailParamActivityDateBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Term Change Creation 대상 장비목록을 조회합니다.<br>
	 *
	 * @param searchParamVO SearchParamVO
	 * @return List<TermChangeCreationVO>
	 * @exception EventException
	 */
	public List<TermChangeCreationVO> searchTermChangeCreationListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Term Change Creation 장비 처리이력을 조회합니다.<br>
	 *
	 * @param searchParamVO SearchParamVO
	 * @return List<TermChangeInquiryVO>
	 * @exception EventException
	 */
	public List<TermChangeInquiryVO> searchTermChangeInquiryListBasic(SearchParamVO searchParamVO) throws EventException;
}