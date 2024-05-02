/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RatingUnitBC.java
*@FileTitle : Rating Unit Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.ratingunit.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRatUtVO;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic about Primasterdata<br>
 *
 * @author 
 * @see Esm_pri_4001EventResponse 
 * @since J2EE 1.4
 */

public interface RatingUnitBC {
	/**
	 * Retrieving Ratingunit List. <br>
	 * 
	 * @param PriRatUtVO priRatUtVO
	 * @return List<PriRatUtVO>
	 * @exception EventException
	 */
	public List<PriRatUtVO> searchRatingUnitList(PriRatUtVO priRatUtVO) throws EventException;
	
	/**
	 * Modifying Rating unit. <br>
	 * 
	 * @param PriRatUtVO[] priRatUtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRatingUnit(PriRatUtVO[] priRatUtVO,SignOnUserAccount account) throws EventException;

	
	/**
	 * Checking whether all code is duplicated before saving Rating Unit<br>
	 * 
	 * @param PriRatUtVO[] priRatUtVOs 
	 * @return List<PriRatUtVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkExistRatingUnitCd(PriRatUtVO[] priRatUtVOs) throws EventException;
}