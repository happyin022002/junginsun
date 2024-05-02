/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffCodeBC.java
*@FileTitle : Tariff Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffcode.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.InPriTariffVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.RsltSvcScpCdVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffCodeALLVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffCodeUsedVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffScopeDupVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTariffVO;

/**
 * Tariff Business Logic Command Interface<br>
 * - Handling a biz logic about Tariff<br>
 *
 * @author SHKIM
 * @see EsmPri3502EventResponse
 * @since J2EE 1.6
 */
public interface TariffCodeBC {
	
	/**
	 * ESM_PRI_3502 : Retrieve <br>
	 * Retrieving tariff scope by inputed Tariff Code
	 * 
	 * @param RsltSvcScpCdVO rsltSvcScpCdVO
	 * @return List<RsltSvcScpCdVO>
	 * @exception EventException
	 */
	public List<RsltSvcScpCdVO> searchTariffCode(RsltSvcScpCdVO rsltSvcScpCdVO) throws EventException;
	
	/**
	 * ESM_PRI_3502 : SAVE <br>
	 * Modifying Tariff Name ,Adding and deleting Tariff Scope
	 * 
	 * @param InPriTariffVO inPriTariffVO
	 * @param RsltSvcScpCdVO[] rsltSvcScpCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException   
	 */
	public void manageTariffCode(InPriTariffVO inPriTariffVO, RsltSvcScpCdVO[] rsltSvcScpCdVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_3502 : DELETE <br>
	 * Deleting Tariff and scope with tariff  
	 * 
	 * @param PriTariffVO priTariffVO
	 * @exception EventException
	 */
	public void removeTariffCode(PriTariffVO priTariffVO) throws EventException;
	
	/**
	 * ESM_PRI_3502 : SAVE <br>
	 * Tariff Scope duplicate check
	 * 
	 * @param RsltSvcScpCdVO[] rsltSvcScpCdVOs
	 * @return List<SearchTariffScopeDupVO>
	 * @exception EventException
	 */
	public List<SearchTariffScopeDupVO> searchTariffScopeDuplicate(RsltSvcScpCdVO[] rsltSvcScpCdVOs) throws EventException;

	/**
	 * ESM_PRI_3502 : DELETE <br>
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return SearchTariffCodeUsedVO
	 * @exception EventException
	 */
	public SearchTariffCodeUsedVO searchTariffCodeUsed(PriTariffVO priTariffVO) throws EventException;
	
	/**
	 * ESM_PRI_3503 : Retrieve <br>
	 * Tariff Code Inquiry
	 * 
	 * @param SearchTariffCodeALLVO searchTariffCodeALLVO
	 * @return List<SearchTariffCodeALLVO>
	 * @exception EventException
	 */
	public List<SearchTariffCodeALLVO> searchTariffCodeList(SearchTariffCodeALLVO searchTariffCodeALLVO) throws EventException;
	
	/**
	 * ESM_PRI_3502 : Tariff Code Focus out <br>
	 * Retrieving inland rates by inputed Tariff Code
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return List<PriTariffVO>
	 * @exception EventException
	 */
	public List<PriTariffVO> searchInlandRates(PriTariffVO priTariffVO) throws EventException;

}