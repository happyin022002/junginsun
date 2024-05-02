/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BlockStowageManage.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.basic;

import com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.vo.PickupReturnCYVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

import java.util.List;

/**
 * PRD Business Logic Command Interface<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_002EventResponse 
 * @since J2EE 1.4
 */
public interface PickupReturnCyManageBC{

	/**
	 * retrieving
	 *
	 * @param pickupReturnCYVO
	 * @return EventResponse ESD_PRD_002EventResponse
	 * @exception EventException
	 */
	public List<PickupReturnCYVO> searchPickupList(PickupReturnCYVO pickupReturnCYVO) throws EventException;

	/**
	 * retrieving
	 *
	 * @param pickupReturnCYVOs
	 * @param signOnUserAccount
	 * @exception EventException
	 */
	public void multiPickupReturnCY(PickupReturnCYVO[] pickupReturnCYVOs, SignOnUserAccount signOnUserAccount) throws EventException;
}
