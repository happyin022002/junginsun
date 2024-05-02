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
package com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.vo.SearchLaneServiceVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * CustomerScheduleEdi Business Logic Command Interface<br>
 * - CustomerScheduleEdi에 대한 비지니스 로직에 대한 인터페이스<br>
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
