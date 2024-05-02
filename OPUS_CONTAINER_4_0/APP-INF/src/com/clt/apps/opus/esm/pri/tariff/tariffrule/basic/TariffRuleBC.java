/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffRuleBC.java
*@FileTitle : Tariff Rule Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffrule.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.common.diff.DiffList;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.InPriTrfRuleDiffVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.PriTrfRuleHistoryVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.PriTrfRuleListVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.RsltPriTrfRuleVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTrfRuleVO;

/**
 * Tariff Business Logic Command Interface<br>
 * - Handling a biz logic about Tariff<br>
 *
 * @author SHKIM
 * @see EsmPri3507EventResponse
 * @since J2EE 1.6
 */
public interface TariffRuleBC {

	/**
	 * Retrieving [Tariff Rule Creation & Amendment information]<br>
	 * 
	 * @param PriTrfRuleVO	priTrfRuleVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleList(PriTrfRuleVO priTrfRuleVO) throws EventException;

	/**
	 * Retrieving [Tariff Rule information]<br>
	 * 
	 * @param PriTrfRuleVO	priTrfRuleVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleInquiryList(PriTrfRuleVO priTrfRuleVO) throws EventException;

	/**
	 * Retrieving [Tariff Rule History information].<br>
	 * 
	 * @param PriTrfRuleHistoryVO	priTrfRuleHistoryVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleHistoryList(PriTrfRuleHistoryVO priTrfRuleHistoryVO) throws EventException;

	/**
	 * Retrieving [Tariff Rule Amend History information].<br>
	 * 
	 * @param PriTrfRuleHistoryVO	priTrfRuleHistoryVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleAmendHistoryList(PriTrfRuleHistoryVO priTrfRuleHistoryVO) throws EventException;

	/**
	 * Retrieving [Tariff Rule duplication data]<br>
	 * 
	 * @param PriTrfRuleVO	priTrfRuleVO
	 * @return String
	 * @exception EventException
	 */
	public String checkTariffRuleNumber(PriTrfRuleVO priTrfRuleVO) throws EventException;
	
	/**
	 * Saving [Tariff Rule Creation & Amendment information].<br>
	 * 
	 * @param PriTrfRuleListVO priTrfRuleListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTariffRule(PriTrfRuleListVO priTrfRuleListVO,SignOnUserAccount account) throws EventException;

	/**
	 * Amending [Tariff Rule Creation & Amendment information].<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Canceling an amendment of [Tariff Rule Creation & Amendment information].<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAmendTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;

	/**
	 * Requesting [Tariff Rule Creation & Amendment information].<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;

	/**
	 * Approving [Tariff Rule Creation & Amendment information]<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;

	/**
	 * Publishing [Tariff Rule Creation & Amendment information]<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;

	/**
	 * Saving [Tariff Rule Creation & Amendment status information].<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelStatusTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving [Tariff Rule Diff information]<br>
	 * 
	 * @param InPriTrfRuleDiffVO inPriTrfRuleDiffVO
	 * @return DiffList
	 * @exception EventException
	 */
	public DiffList searchTariffRuleDiff(InPriTrfRuleDiffVO inPriTrfRuleDiffVO) throws EventException ;
	
	/**
	 * Retrieving [Tariff Code List information].<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdListVO) throws EventException;
	
}