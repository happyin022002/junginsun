/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IOnOffHireAuditBC.java
*@FileTitle : On off Hire Audit
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditDetailVO;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditGroupVO;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditSearchVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Containercostanalysis Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_lse_0055EventResponse
 * @since J2EE 1.6
 */

public interface OnOffHireAuditBC {
	/**
	 * retrieving for audi result onoff hire <br>
	 *
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @return OnOffHireAuditGroupVO
	 * @exception EventException
	 */
	public OnOffHireAuditGroupVO searchAuditResultOnOffHirelistBasic(OnOffHireAuditSearchVO onOffHireAuditSearchVO) throws EventException;
	/**
	 * verifying LSE_CTRT_NO<br>
	 *
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @return List<OnOffHireAuditSearchVO>
	 * @exception EventException
	 */
	public List<OnOffHireAuditSearchVO> verifyImportOnOffHireListBasic(OnOffHireAuditSearchVO onOffHireAuditSearchVO) throws EventException;
	/**
	 * creating excel import data<br>
	 *
	 * @param OnOffHireAuditSearchVO[] onOffHireAuditSearchVOs
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String createImportOnOffHireListBasic(OnOffHireAuditSearchVO[] onOffHireAuditSearchVOs , SignOnUserAccount account) throws EventException;
	/**
	 * retrieving for Audit version list
	 * 
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @return List<OnOffHireAuditSearchVO>
	 * @exception EventException
	 */
	public List<OnOffHireAuditSearchVO> searchAuditResultOnOffHireVersionlistBasic(OnOffHireAuditSearchVO onOffHireAuditSearchVO) throws EventException;

	/**
	 * retrieving for Audit Result  <br>
	 * 
	 * @param  OnOffHireAuditDetailVO onOffHireAuditDetailVO
	 * @return List<List<OnOffHireAuditDetailVO>>
	 * @exception EventException
	 */
	public OnOffHireAuditGroupVO searchAuditResultOnOffHireBasic(OnOffHireAuditDetailVO onOffHireAuditDetailVO) throws EventException;



	/**
	 * saving On/Off-Hire Audit result<br>
	 *
	 * @param OnOffHireAuditDetailVO onOffHireAuditDetailVO
	 * @param OnOffHireAuditDetailVO[] onOffHireAuditDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createOnOffHireListBasic( OnOffHireAuditDetailVO onOffHireAuditDetailVO , OnOffHireAuditDetailVO[] onOffHireAuditDetailVOs , SignOnUserAccount account) throws EventException;

}