/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LaneServiceBC.java
 *@FileTitle : LaneServiceBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.07.15
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2010.07.15 함대성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.vo.SearchLaneServiceVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomerScheduleEdi Business Logic Command Interface<br>
 * - NIS2010-CustomerScheduleEdi에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author HAM DAE SUNG
 * @see
 * @since J2EE 1.4
 */
public interface LaneServiceBC {
	
	/** 
	 * 화주 ID에 해당하는 이름을 조회한다.
	 * 
	 * @param String partnerId
	 * @return List<SearchGetPartnerVO>
	 * @exception EventException
	 */
	public List<SearchGetPartnerVO> searchCustomerInfo(String partnerId) throws EventException;
	
	/**
	 * Lane Type 화주에게 제공할 Lane을 조회한다.
	 * 
	 * @param String partnerId
	 * @return List<SearchLaneServiceVO>
	 * @exception EventException
	 */
	public List<SearchLaneServiceVO> searchLaneServiceList(String partnerId) throws EventException;
	
	/**
	 * Lane Type인 화주에게 제공할 Lane을 등록/삭제 한다.
	 * 
	 * @param SearchLaneServiceVO[] laneServiceVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLaneService(SearchLaneServiceVO[] laneServiceVOs, SignOnUserAccount account) throws EventException;
	

}
