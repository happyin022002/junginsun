/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationBC.java
*@FileTitle : Tariff General Information Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10,13
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.10.13 김민아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryAmendVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcListVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.TrfBzcMnVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTrfBzcVO;

/**
 * ALPS-Tariff Business Logic Command Interface<br>
 * - ALPS-Tariff에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM MINAH
 * @since J2EE 1.6
 */

public interface TariffGeneralInformationBC {

	/**
	 * Tariff Code의 General Information을 조회한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @param SignOnUserAccount account
	 * @return RsltPriTrfBzcListVO
	 * @exception EventException
	 */
	public RsltPriTrfBzcListVO searchTariffGeneralInformation(PriTrfBzcVO priTrfBzcVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Tariff Code의 General Information을 저장한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Tariff Code의 General Information을 삭제한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception EventException
	 */
	public void removeTariffGeneralInformation(PriTrfBzcVO priTrfBzcVO) throws EventException;

	/**
	 * Tariff Code의 General Information을 Request한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Tariff Code의 General Information을 Approve한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Tariff Code의 General Information을 Cancel한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Tariff Code의 General Information을 Amend한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Tariff Code의 General Information을 Publish한다.<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Tariff General Information List를 조회한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return List<RsltPriTrfBzcVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfBzcVO> searchTariffGeneralInformationInquiryList(PriTrfBzcVO priTrfBzcVO) throws EventException;

	/**
	 * Tariff General Information Detail을 조회한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return RsltPriTrfBzcListVO
	 * @exception EventException
	 */
	public RsltPriTrfBzcListVO searchTariffGeneralInformationInquiry(PriTrfBzcVO priTrfBzcVO) throws EventException;
	
	/**
	 * Tariff General Information History <br>
	 * 
	 * @param PriTrfBzcHistoryVO priTrfBzcHistoryVO
	 * @return List<PriTrfBzcHistoryVO>
	 * @exception EventException
	 */
	public List<PriTrfBzcHistoryVO> searchTariffGeneralHistoryList(PriTrfBzcHistoryVO priTrfBzcHistoryVO) throws EventException;
	
	/**
	 * Tariff General Information Amend History
	 * 
	 * @param PriTrfBzcHistoryAmendVO priTrfBzcHistoryAmendVO
	 * @return List<PriTrfBzcHistoryAmendVO>
	 * @exception EventException
	 */
	public List<PriTrfBzcHistoryAmendVO> searchTariffGeneralAmendHistoryList(PriTrfBzcHistoryAmendVO priTrfBzcHistoryAmendVO) throws EventException;
	
	/**
	 * ESM_PRI_3511 : Sheet Double Click<br>
	 * Tariff General Information Detail을 조회한다.<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return RsltPriTrfBzcListVO
	 * @exception EventException
	 */
	public RsltPriTrfBzcListVO searchTariffGeneralHistory(PriTrfBzcVO priTrfBzcVO) throws EventException;
	
	/**
	 * ESM_PRI_3501 : Save <br>
	 * Tariff Basic Save/Delete/Request/Cancel 전 체크<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return int
	 * @exception EventException
	 */
	public int searchTariffCodeExistCheck(PriTrfBzcVO priTrfBzcVO) throws EventException;
	
	/**
	 * ESM_PRI_3501 : Save <br>
	 * Tariff Basic Save/Delete/Request/Cancel 전 체크<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return int
	 * @exception EventException
	 */
	public int searchTariffBasicExistCheck(PriTrfBzcVO priTrfBzcVO) throws EventException;
	
}