/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ImmediateExitBC.java
*@FileTitle : Immediate Exit Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.10 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo.SearchParamVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Containerleasemgt Business Logic Command Interface<br>
 * Containerleasemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Jun-Woo
 * @see Ees_lse_0025EventResponse 참조
 * @since J2EE 1.6
 */

public interface ImmediateExitBC {

	/**
	 * Immediate Exit Creation 대상 장비목록을 조회합니다.<br>
	 *
	 * @param SearchParamVO searchParamVO
	 * @return List<ImmediateExitCreationVO>
	 * @exception EventException
	 */
	public List<ImmediateExitCreationVO> searchImmediateExitCreationListBasic(SearchParamVO searchParamVO) throws EventException;
}