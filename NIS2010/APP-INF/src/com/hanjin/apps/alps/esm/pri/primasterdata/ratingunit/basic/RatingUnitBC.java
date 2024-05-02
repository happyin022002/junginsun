/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RatingUnitBC.java
*@FileTitle : Rating Unit Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.11 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.ratingunit.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRatUtVO;

/**
 * NIS2010-Primasterdata Business Logic Command Interface<br>
 * - NIS2010-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung Jun Lee
 * @see Esm_pri_4001EventResponse 참조
 * @since J2EE 1.4
 */

public interface RatingUnitBC {
	/**
	 * Ratingunit List를 조회합니다. <br>
	 * 
	 * @param PriRatUtVO priRatUtVO
	 * @return List<PriRatUtVO>
	 * @exception EventException
	 */
	public List<PriRatUtVO> searchRatingUnitList(PriRatUtVO priRatUtVO) throws EventException;
	
	/**
	 * Ratingunit를 수정합니다. <br>
	 * 
	 * @param PriRatUtVO[] priRatUtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRatingUnit(PriRatUtVO[] priRatUtVO,SignOnUserAccount account) throws EventException;

	
	/**
	 * Rating Unit을 저장하기 전 코드가 중복인지 검사한다.<br>
	 * 
	 * @param PriRatUtVO[] priRatUtVOs 
	 * @return List<PriRatUtVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkExistRatingUnitCd(PriRatUtVO[] priRatUtVOs) throws EventException;
}