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

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargePercentBaseChargeListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-ScOftAutoRatingBC Business Logic Command Interface<br>
 * - OPUS-ScOftAutoRatingBC business logic Interface<br>
 * 
 * @author
 * @see
 * @see Esm_bkg_0269EventResponse reference
 * @since J2EE 1.6
 */

public interface ScOftAutoRatingBC {

	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about booking
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScETCOftAutoratingList(String bkgNo, String caFlag, String ScNo, String rtAplyDt, String scpCd ,String cmdtCd) throws EventException;
	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about SC no corresponding to booking no
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTAEOftAutoratingList(String bkgNo, String caFlag, String ScNo, String rtAplyDt, String scpCd ,String cmdtCd) throws EventException;
	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about ScTAWOft SC no corresponding to booking no
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTAWOftAutoratingList(String bkgNo, String caFlag, String ScNo, String rtAplyDt, String scpCd ,String cmdtCd) throws EventException;
	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about ScTPSOft SC no corresponding to booking no
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
 	 * @return List<SearchScTAEOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScTPSOftAutoratingList(String bkgNo, String caFlag, String ScNo, String rtAplyDt, String scpCd ,String cmdtCd) throws EventException;
	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about searchSurchargeAutoratingList corresponding to booking no
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @param String ctrtTpCd 
	 * @param String rtaplydt
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd ,String cmdtCd, String ctrtTpCd, String rtAplyDt ) throws EventException;
	/**
	 * EsmBkg0269 surchargeautorating registering event process<br>
	 * surchargeautorating registering
	 * 
	 * @param ScOftAutoratingListVO vo
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingList(ScOftAutoratingListVO vo ) throws EventException;
	/**
	 * EsmBkg0269 surchargeautorating registering  event process<br>
	 * surchargeautorating registering
	 * 
	 * @param SearchScOftAutoratingListVO[] vo
	 * @param String usrID
	 * @exception EventException
	 */
	public void manageScInformList(SearchScOftAutoratingListVO[] vo, String usrId) throws EventException;
	
	/**
	 * EsmBkg0269 searchSurchargePercentBaseChargeList retrieve event process<br>
	 * SurchargePercentBaseChargeList retrieve
	 * 
	 * @return List<SearchSurchargePercentBaseChargeListVO>
	 * @exception EventException
	 */
	public List<SearchSurchargePercentBaseChargeListVO> searchSurchargePercentBaseChargeList() throws EventException;
	
	/**
	 * EsmBkg0269 retrieve event process<br>
	 * calling fare calculation service about booking
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scNo
	 * @param String rtAplyDt
	 * @param String scpCd
	 * @param String cmdtCd 
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchScOftAutoratingList(String bkgNo, String caFlag, String ScNo, String rtAplyDt, String scpCd ,String cmdtCd) throws EventException;
	
	/**
	 * EsmBkg0256 Re-Audit<br>
	 * Backend로 수행하기 위해 Global Temp 테이블을 삭제시켜줌.
	 * 
	 * @author TAE KYOUNG KIM
	 * @exception EventException
	 */
	public void manageAutoratingTempTables() throws EventException;
	
	
	/**
	 * EsmBkg007908 save event process<br>
	 * tax exchange rate charge calculation
	 * @param BkgChgRateVO[] bkgChgRateVOs
	 * @param String bkgNo
	 * @param String svcScpCd
	 * @param String rtAplyDt
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchTaxSurchargeList(BkgChgRateVO[] bkgChgRateVOs, String bkgNo, String svcScpCd, String rtAplyDt) throws EventException;
	
	/**
	 * EsmBKg0739 management event process<br>
	 * calling fare calculation service about searchSurchargeAutoratingList corresponding to booking no(Inclue OFT,return Exclue OFT) <br>
	 * @param ScOftAutoratingListVO vo
	 * @param SearchScOftAutoratingListVO[] vos
	 * @return List<SearchScOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchScOftAutoratingListVO> searchSurchargeAutoratingInclTaxList(ScOftAutoratingListVO vo, SearchScOftAutoratingListVO[] vos) throws EventException;
}
