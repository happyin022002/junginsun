/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SendEdiFromPartnerLinesMgtBC.java
 *@FileTitle : SendEdiFromPartnerLinesMgtBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.19
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.19 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.basic;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SendDgEdiRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SendDgEmailRequestVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Send Edi From PartnerLines Mgt Basic Command<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.6
 */
public interface SendEdiFromPartnerLinesMgtBC {
	/**
	 * flatfile 생성 및 전송  <br>
	 * 
	 * @param SendDgEdiRequestVO sendDgEdiRequestVO
	 * @param SignOnUserAccount account
	 * @return boolean
	 * @exception EventException
	 */
	public boolean sendDgApvlOwnBkgEdi(SendDgEdiRequestVO sendDgEdiRequestVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * email trans info save <br>
	 * 
	 * @param SendDgEmailRequestVO sendDgEmailRequestVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setEmailHis(SendDgEmailRequestVO sendDgEmailRequestVO, SignOnUserAccount account) throws EventException;
	
}
