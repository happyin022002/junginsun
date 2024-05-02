/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonBC.java
*@FileTitle : PRICommon
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmChargeVO;

/**
 * OPUS-Pricommon Business Logic Command Interface<br>
 * - OPUS-Pricommon biz logic process<br>
 *
 * @author Park Sungsoo
 * @see PricommonEventResponse reference
 * @since J2EE 1.4
 */

public interface RASCommonBC {
	/**
	 * Service Scope Code List retrieve<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList (RsltCdListVO rsltcdlistvo) throws EventException;

	/**
	 *  ComCodeDescList retrieve event<br>
	 *  common code, name retrieve event<br>
	 * 
	 * @param RsltCdListVO paramCdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComCodeDescList(RsltCdListVO paramCdlistvo) throws EventException;
	

	/**
	 *  ComCodeList retrieve event<br>
	 *  common code, name retrieve event<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	 public List<RsltCdListVO> searchComCodeList(RsltCdListVO rsltcdlistvo) throws EventException;


	/**
	 *  RasOrganizationList retrieve event<br>
	 *  organization retrieve(Ras)<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRasOrganizationList(RsltCdListVO rsltcdlistvo) throws EventException;	

	/**
	 *  RasContiList retrieve event<br>
	 *  organization retrieve(Ras)<br>
	 * 
	 * @param RsltContiListVO rsltcontilistvo
	 * @return List<RsltContiListVO>
	 * @exception EventException
	 */
	public List<RsltContiListVO> seacrhRasContiList(RsltContiListVO rsltcontilistvo) throws EventException;
	
	/**
	 *  UsExangeAmount retrieve event<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchUsExangeAmount(RsltCdListVO rsltcdlistvo) throws EventException;


	/**
	 * BkgRevUmchTpList retrieve event<br>
	 * BKG_REV_UMCH_TP table retrieve<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchTpList(RsltCdListVO rsltcdlistvo) throws EventException;


	/**
	 * BkgRevUmchSubTpList retrieve event<br>
	 * BKG_REV_UMCH_SUB_TP table retrieve<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchSubTpList(RsltCdListVO rsltcdlistvo) throws EventException;


	/**
	 * retrieve event<br>
	 *  PRICommon screen retrieve event<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRatingUnitCodeList(RsltCdListVO rsltcdlistvo) throws EventException;	

	/**
	 * retrieve event<br>
	 *  PRICommon screen retrieve event<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRepChargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException;	

	/**
     * charge list retrieve<br>
     * 
     * @param  MdmChargeVO mdmChargeVO
     * @return List<MdmChargeVO>
     * @exception EventException
     */
    public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws EventException;
}