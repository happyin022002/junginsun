/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffRuleBC.java
*@FileTitle : Tariff Rule Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.06 최성민
* 1.0 Creation
=========================================================
* History
* 2011.04.19 이행지 [CHM-201110201-01] Tariff Rule 관련 Status 변경 관리자 기능 추가 요청
*                                  - SuperUser일 경우 Publish Cacel권한 부여
* 2011.05.16 이행지 [CHM-201110773-01] [PRI] Tariff Rule - Publish Cancel 기능 보완
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffrule.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.common.diff.DiffList;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo.InPriTrfRuleDiffVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo.PriTrfRuleHistoryVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo.PriTrfRuleListVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo.RsltPriTrfRuleVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTrfRuleVO;

/**
 * ALPS-Tariff Business Logic Command Interface<br>
 * - ALPS-Tariff에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNGMIN
 * @since J2EE 1.6
 */

public interface TariffRuleBC {

	/**
	 * [Tariff Rule Creation & Amendment 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO	priTrfRuleVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleList(PriTrfRuleVO priTrfRuleVO) throws EventException;

	/**
	 * [Tariff Rule 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO	priTrfRuleVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleInquiryList(PriTrfRuleVO priTrfRuleVO) throws EventException;

	/**
	 * [Tariff Rule History 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleHistoryVO	priTrfRuleHistoryVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleHistoryList(PriTrfRuleHistoryVO priTrfRuleHistoryVO) throws EventException;

	/**
	 * [Tariff Rule Amend History 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleHistoryVO	priTrfRuleHistoryVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleAmendHistoryList(PriTrfRuleHistoryVO priTrfRuleHistoryVO) throws EventException;

	/**
	 * [Tariff Rule 중복데이터]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO	priTrfRuleVO
	 * @return String
	 * @exception EventException
	 */
	public String checkTariffRuleNumber(PriTrfRuleVO priTrfRuleVO) throws EventException;
	
	/**
	 * [Tariff Rule Creation & Amendment 정보]을 [저장] 합니다.<br>
	 * 
	 * @param PriTrfRuleListVO priTrfRuleListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTariffRule(PriTrfRuleListVO priTrfRuleListVO,SignOnUserAccount account) throws EventException;

	/**
	 * [Tariff Rule Creation & Amendment 정보]을 [Amend] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [Tariff Rule Creation & Amendment 정보]을 [Amend Cancel] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAmendTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;

	/**
	 * [Tariff Rule Creation & Amendment 정보]을 [Request] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;

	/**
	 * [Tariff Rule Creation & Amendment 정보]을 [Approve] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;

	/**
	 * [Tariff Rule Creation & Amendment 정보]을 [Publish] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;

	/**
	 * [Tariff Rule Creation & Amendment 상태정보]을 [수정] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelStatusTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * [Tariff Rule Diff 정보]을 [조회] 합니다.<br>
	 * 
	 * @param InPriTrfRuleDiffVO inPriTrfRuleDiffVO
	 * @return DiffList
	 * @exception EventException
	 */
	public DiffList searchTariffRuleDiff(InPriTrfRuleDiffVO inPriTrfRuleDiffVO) throws EventException ;
	
	/**
	 * [Tariff Code List 정보]을 [조회] 합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdListVO) throws EventException;
	
	/**
	 * [Tariff Rule Creation & Amendment]을 [수정] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelPublishTariffRuleBySuperUser(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [Tariff Rule Publish Cancel 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO	priTrfRuleVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRulePublishCancelList(PriTrfRuleVO priTrfRuleVO) throws EventException;
	
	/**
	 * [Tariff Rule Creation & Amendment]을 [수정] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO[] priTrfRuleVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelPublishTariffRule(PriTrfRuleVO[] priTrfRuleVOs,SignOnUserAccount account) throws EventException;

}