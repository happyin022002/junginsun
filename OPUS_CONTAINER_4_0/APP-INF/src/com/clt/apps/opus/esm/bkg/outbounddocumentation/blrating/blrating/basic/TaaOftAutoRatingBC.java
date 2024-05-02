/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TaaOftAutoRatingBC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-TaaOftAutoRating Business Logic Command Interface<br>
 * - OPUS-TaaOftAutoRating biz Logic Interface<br>
 * 
 * @author
 * @see Esm_bkg_1076EventResponse reference
 * @since J2EE 1.6
 */

public interface TaaOftAutoRatingBC {

	/**
	 * Searching the Surcharge in Booking TAA screen<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @return List<SearchTaaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchTaaOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd, String cmdtCd, String ctrtTpCd) throws EventException;
	
	/**
	 * Searching the US Cargo rating

	 * @param String bkgNo
	 * @param String caFlag
 	 * @param String taaNo
	 * @param String rtaplydt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchTaaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchTaaOftAutoratingListVO> searchTaaOftAutoratingList (String bkgNo, String caFlag, String taaNo, String rtaplydt, String scpCd, String cmdtCd) throws EventException;

}