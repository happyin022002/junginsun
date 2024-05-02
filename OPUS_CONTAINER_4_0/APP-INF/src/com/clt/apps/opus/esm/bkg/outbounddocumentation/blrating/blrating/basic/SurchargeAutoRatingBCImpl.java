/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingBC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration.SurchargeAutoRatingDBDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargeAutoratingListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-SurchargeAutoRating Business Logic Command Interface<br>
 * - OPUS-SurchargeAutoRating business logic interface<br>
 * 
 * @author LEE JINSEO
 * @see Esm_bkg_0269EventResponse 
 * @since J2EE 1.6
 */

public class SurchargeAutoRatingBCImpl extends BasicCommandSupport implements SurchargeAutoRatingBC{

	// Database Access Object
	private transient SurchargeAutoRatingDBDAO dbDao = null;

	/**
	 * BlRatingBCImpl creating object<br>
	 * BlRatingDBDAO.<br>
	 */
	public SurchargeAutoRatingBCImpl() {
		dbDao = new SurchargeAutoRatingDBDAO();
	}
	
	/**
	 * EsmBkg0269 handling of search event<br>
	 * showing the  freight charge of booking on the screen, Booking surcharge AutoRating, inputing data to middle table in INV System <br>
	 * Service which includes the surcharge (additional charge, surcharges,  charge in addition, primage )
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @return List<SearchSurchargeAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchSurchargeAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd ,String cmdtCd, String ctrtTpCd) throws EventException {
		try {
			return dbDao.searchSurchargeAutoratingList(bkgNo,caFlag,scpCd, cmdtCd,ctrtTpCd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}


	
	
	
	
}