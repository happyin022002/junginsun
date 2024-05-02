/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USA404TrsStccBC.java
*@FileTitle : USA404TrsStccBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.basic;

import java.util.List;

import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0802Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.TrsStccVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Command Interface<br>
 *
 * @author 
 * @see USA404TrsStccBC
 * @since J2EE 1.4
 */
public interface USA404TrsStccBC {
	/**
	 * retrieve Trs Stcc
	 * 
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List<TrsStccVO> searchTrsStcc(EsdTrs0802Event event) throws EventException;
	
	/**
	 * manage Trs Stcc
	 * 
	 * @param trsStccVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageTrsStcc(TrsStccVO[] trsStccVOs, SignOnUserAccount account) throws EventException;
	
	
}