/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffCodeBC.java
*@FileTitle : Tariff Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.14
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.14 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffcode.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo.InPriTariffVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo.RsltSvcScpCdVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo.SearchTariffCodeALLVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo.SearchTariffCodeUsedVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo.SearchTariffScopeDupVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTariffVO;

/**
 * ALPS-Tariff Business Logic Command Interface<br>
 * - ALPS-Tariff에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SEO MIJIN
 * @since J2EE 1.6
 */

public interface TariffCodeBC {
	
	/**
	 * ESM_PRI_3502 : Retrieve <br>
	 * 입력한 Tariff Code에 해당하는 Tariff Scope 조회
	 * 
	 * @param RsltSvcScpCdVO rsltSvcScpCdVO
	 * @return List<RsltSvcScpCdVO>
	 * @exception EventException
	 */
	public List<RsltSvcScpCdVO> searchTariffCode(RsltSvcScpCdVO rsltSvcScpCdVO) throws EventException;
	
	/**
	 * ESM_PRI_3502 : SAVE <br>
	 * Tariff Name 변경, Tariff Scope 추가 및 삭제
	 * 
	 * @param InPriTariffVO inPriTariffVO RsltSvcScpCdVO[] rsltSvcScpCdVOs SignOnUserAccount account
	 * @throws EventException 
	 * @exception EventException   
	 */
	public void manageTariffCode(InPriTariffVO inPriTariffVO, RsltSvcScpCdVO[] rsltSvcScpCdVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_3502 : DELETE <br>
	 * Tariff 삭제
	 * 
	 * @param PriTariffVO priTariffVO
	 * @throws EventException 
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
	 * Tariff 삭제 전, 사용중인지 체크 
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
	 * 입력한 Tariff Code에 해당하는 Inland Rates 조회
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return List<PriTariffVO>
	 * @exception EventException
	 */
	public List<PriTariffVO> searchInlandRates(PriTariffVO priTariffVO) throws EventException;


}