/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ApplicationDateRuleBC.java
*@FileTitle : Application Date Rule
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2011.07.07 김민아
* 1.0 Creation
=========================================================
* History
2011.07.07 김민아 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청 (Pricing)
                                                                      추가요건 - 조회 조건으로 access date 추가. Duration 중복 조건에 포함하여 그 날짜가 포함관계에 있으면 중복으로 처리.           
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.vo.RsltPriScgAplyDtRuleVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScgAplyDtRuleVO;


/**
 * NIS2010-ApplicationDateRule Business Logic Command Interface<br>
 * - NIS2010-ApplicationDateRule에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4003EventResponse 참조
 * @since J2EE 1.6
 */

public interface ApplicationDateRuleBC {
	/**
	 * Application Date Rule 리스트를 조회합니다. <br>
	 * 
	 * @param PriScgAplyDtRuleVO priScgAplyDtRuleVO
	 * @return List<RsltPriScgAplyDtRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriScgAplyDtRuleVO> searchApplicatoinDateRule(PriScgAplyDtRuleVO priScgAplyDtRuleVO) throws EventException;
	
	/**
	 * Application Date Rule을 저장합니다. <br>
	 * 
	 * @param PriScgAplyDtRuleVO[] priScgAplyDtRuleVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApplicationDateRule(PriScgAplyDtRuleVO[] priScgAplyDtRuleVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Location 체크 및 Location Type 을 조회합니다. <br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchLocationTypeAndName(RsltCdListVO rsltCdListVO) throws EventException;
	
	/**
	 * SAVE전 중복 데이터를 조회합니다. <br>
	 * 
	 * @param PriScgAplyDtRuleVO[] priScgAplyDtRuleVOs
	 * @return List<RsltPriScgAplyDtRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriScgAplyDtRuleVO> searchApplicationDateRuleDupCheck(PriScgAplyDtRuleVO[] priScgAplyDtRuleVOs) throws EventException;
}