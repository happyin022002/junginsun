/*============================================
*Copyright(c) 2016 CyberLogitec
*@FileName :CreditIncentiveSummaryBC.java
*@FileTitle : 
*@LastModifyDate : 2016.04.26.
*@LastModifier : 
*@LastVersion : 
* 2016.04.26. SHIN DONG IL
*============================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrIssueVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrRhqVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrSrcVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * Credit & Incentive Summaryh Business Logic Command Interface<br> 
 * @author SHIN DONG IL
 * @see  ESD_EAS_0502EventResponse 참조
 * @since J2EE 1.6
 */
public interface CreditIncentiveSummaryBC {
	
/**
 * EsdEas0502Event  <br>
 * Credti & Invcentive Summary by RHQ를 조회한다. <br>
 * @param e
 * @return List<CreditSmmrRhqVO>
 * @exception EventException
 */
public List<CreditSmmrRhqVO> searchCreditByRhqList(Event e) throws EventException;

/**
 * EsdEas0502Event  <br>
 * Credti & Invcentive Summary by RHQ를 조회한다. <br>
 * @param e 
 * @return List<CreditSmmrSrcVO>
 * @exception EventException
 */
public List<CreditSmmrSrcVO> searchCreditBySourceList(Event e) throws EventException;

/**
 * EsdEas0502Event  <br>
 * CCredti & Invcentive Summary M&R Mileage를 조회한다. <br>
 * @param e 
 * @return List<CreditSmmrIssueVO>
 * @exception EventException
 */
public List<CreditSmmrIssueVO> searchCreditIssuetList(Event e) throws EventException;
	
}