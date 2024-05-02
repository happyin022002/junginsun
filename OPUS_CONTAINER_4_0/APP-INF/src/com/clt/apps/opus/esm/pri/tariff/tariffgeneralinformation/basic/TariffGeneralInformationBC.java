/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffGeneralInformationBC.java
*@FileTitle : Tariff General Information Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryAmendVO;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryVO;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcListVO;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcVO;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.vo.TrfBzcMnVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTrfBzcVO;

/**
 * Tariff Business Logic Command Interface<br>
 * - Handling a biz logic about Tariff<br>
 *
 * @author PRI
 * @see EsmPri3001EventResponse
 * @since J2EE 1.6
 */
public interface TariffGeneralInformationBC {

	/**
	 * Retrieving Tariff Code's General Information<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @param SignOnUserAccount account
	 * @return RsltPriTrfBzcListVO
	 * @exception EventException
	 */
	public RsltPriTrfBzcListVO searchTariffGeneralInformation(PriTrfBzcVO priTrfBzcVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Saving Tariff Code's General Information<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Deleting Tariff Code's General Information<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @exception EventException
	 */
	public void removeTariffGeneralInformation(PriTrfBzcVO priTrfBzcVO) throws EventException;

	/**
	 * Requesting Tariff Code's General Information<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Approving Tariff Code's General Information<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling Tariff Code's General Information<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Amending Tariff Code'sGeneral Information<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Publishing Tariff Code's General Information<br>
	 * 
	 * @param TrfBzcMnVO trfBzcMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTariffGeneralInformation(TrfBzcMnVO trfBzcMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving Tariff General Information List<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return List<RsltPriTrfBzcVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfBzcVO> searchTariffGeneralInformationInquiryList(PriTrfBzcVO priTrfBzcVO) throws EventException;

	/**
	 * Retrieving Tariff General Information Detail<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return RsltPriTrfBzcListVO
	 * @exception EventException
	 */
	public RsltPriTrfBzcListVO searchTariffGeneralInformationInquiry(PriTrfBzcVO priTrfBzcVO) throws EventException;
	
	/**
	 * Retrieving Tariff General Information History <br>
	 * 
	 * @param PriTrfBzcHistoryVO priTrfBzcHistoryVO
	 * @return List<PriTrfBzcHistoryVO>
	 * @exception EventException
	 */
	public List<PriTrfBzcHistoryVO> searchTariffGeneralHistoryList(PriTrfBzcHistoryVO priTrfBzcHistoryVO) throws EventException;
	
	/**
	 * ESM_PRI_3504 : sheet1 double click <br>
	 * Retrieving Tariff General Information Amend History
	 * 
	 * @param PriTrfBzcHistoryAmendVO priTrfBzcHistoryAmendVO
	 * @return List<PriTrfBzcHistoryAmendVO>
	 * @exception EventException
	 */
	public List<PriTrfBzcHistoryAmendVO> searchTariffGeneralAmendHistoryList(PriTrfBzcHistoryAmendVO priTrfBzcHistoryAmendVO) throws EventException;
	
	/**
	 * ESM_PRI_3511 : Sheet Double Click<br>
	 * Retrieving Tariff General Information Detail<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return RsltPriTrfBzcListVO
	 * @exception EventException
	 */
	public RsltPriTrfBzcListVO searchTariffGeneralHistory(PriTrfBzcVO priTrfBzcVO) throws EventException;
	
	/**
	 * ESM_PRI_3501 : Save <br>
	 * checking before Tariff Basic Save/Delete/Request/Cancel <br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return int
	 * @exception EventException
	 */
	public int searchTariffCodeExistCheck(PriTrfBzcVO priTrfBzcVO) throws EventException;
	
	/**
	 * ESM_PRI_3501 : Save <br>
	 * Checking before Tariff Basic Save/Delete/Request/Cancel<br>
	 * 
	 * @param PriTrfBzcVO priTrfBzcVO
	 * @return int
	 * @exception EventException
	 */
	public int searchTariffBasicExistCheck(PriTrfBzcVO priTrfBzcVO) throws EventException;
	
}