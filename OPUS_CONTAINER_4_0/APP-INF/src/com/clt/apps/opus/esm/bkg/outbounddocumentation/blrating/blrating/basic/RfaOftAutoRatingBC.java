/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingBC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargePercentBaseChargeListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-RfaOftAutoRating Business Logic Basic Command interface<br>
 * - OPUS-RfaOftAutoRating handling business transaction.<br>
 * 
 * @author
 * @see
 * @since J2EE 1.6
 */

public interface RfaOftAutoRatingBC {

	/**
	 *  Handling retrieving event of EsmBkg0739<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd, String cmdtCd, String ctrtTpCd) throws EventException;
	
	/**
	 *  Handling retrieving event of EsmBkg0739<br>
	 *  
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String rfaNo
 	 * @param String Rtaplydt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchRfaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchRfaOftAutoratingListVO> searchRfaOftAutoratingList(String bkgNo, String caFlag,String rfaNo, String Rtaplydt, String scpCd, String cmdtCd) throws EventException;

	
	
	
}