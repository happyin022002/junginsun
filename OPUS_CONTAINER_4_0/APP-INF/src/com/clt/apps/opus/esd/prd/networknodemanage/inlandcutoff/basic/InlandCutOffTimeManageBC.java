/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : InlandCutOffTimeManageBC.JAVA
 *@FileTitle : Inland Cut Off Time Management
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.basic;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PrdInlndCutOffTmMgmtVO;

/**
 * Inland Cut Off Time Management Command Interface<br>
 * 
 * @author
 * @see ESD_PRD_0038EventResponse
 * @since J2EE 1.4
 */
public interface InlandCutOffTimeManageBC {
	/**
	 * searchInlandCutOffTime
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<AbstractValueObject> searchInlandCutOffTime(PrdInlndCutOffTmMgmtVO vo) throws EventException;

	/**
	 * 
	 * @param vos
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public int multiInlandCutOffTime(PrdInlndCutOffTmMgmtVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public int checkEffectDate(PrdInlndCutOffTmMgmtVO vo) throws EventException;
}
