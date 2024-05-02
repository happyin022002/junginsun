/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalInterface301FullDGApprovalBC.java
*@FileTitle : Common Utility in SCG
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.04
*@LastModifier : TOP
*@LastVersion : 1.0
* 2015.09.04 TOP
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.externalinterface301fulldgapproval.basic;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgAprovalAuthCdVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Scgcommon Business Logic Command Interface<br>
 * - OPUS-Scgcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author TOP
 * @see Scg_com_EventResponse 참조
 * @since J2EE 1.4
 */
public interface ExternalInterface301FullDGApprovalBC {
	
	/**
	 * Sending 301F through EDI <br>
	 * 
	 * @param SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO
	 * @param SignOnUserAccount account
	 * @return boolean
	 * @exception EventException
	 */
	public boolean interfaceSendEDISpecialCargoApproval(SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO, SignOnUserAccount account) throws EventException;

 
}