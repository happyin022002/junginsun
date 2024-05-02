/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BlockStowageManage.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.basic;

import com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.vo.PickupReturnCYVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import java.util.List;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_002EventResponse 참조
 * @since J2EE 1.4
 */
public interface PickupReturnCyManageBC{

	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param pickupReturnCYVO
	 * @return EventResponse ESD_PRD_002EventResponse
	 * @exception EventException
	 */
	public List<PickupReturnCYVO> searchPickupList(PickupReturnCYVO pickupReturnCYVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param pickupReturnCYVOs
	 * @param signOnUserAccount
	 * @exception EventException
	 */
	public void multiPickupReturnCY(PickupReturnCYVO[] pickupReturnCYVOs, SignOnUserAccount signOnUserAccount) throws EventException;
}
