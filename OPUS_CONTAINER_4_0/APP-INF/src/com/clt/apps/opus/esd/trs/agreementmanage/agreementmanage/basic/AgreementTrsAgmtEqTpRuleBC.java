/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementTrsAgmtEqTpRuleBC.java
*@FileTitle : AgreementTrsAgmtEqTpRuleBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0801Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsAgmtEqTpRuleVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * 
 * @author
 * @see AgreementTrsAgmtEqTpRuleBC
 * @since J2EE 1.6
 */
public interface AgreementTrsAgmtEqTpRuleBC {
	
	/**
	 * TRS AGMT EQ TP RULE Manage
	 * 
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List<TrsAgmtEqTpRuleVO> searchTrsAgmtEqTpRule(EsdTrs0801Event event) throws EventException;
	
	/**
	 * TRS AGMT EQ TP RULE Manage
	 * 
	 * @param trsAgmtEqTpRuleVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageTrsAgmtEqTpRule(TrsAgmtEqTpRuleVO[] trsAgmtEqTpRuleVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * TRS AGMT EQ TP RULE Manage
	 * 
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List<ComIntgCdDtlVO> searchComIntgCdDtl(EsdTrs0801Event event) throws EventException;
	
}