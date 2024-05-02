/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODeliveryScheduleBC.java
*@FileTitle : Ship Yard Select – Pop up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.20
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.20 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CondDeliveryScheduleVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomNewBldSkdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomShpYdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchDeliveryScheduleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchShipYardNameListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-Timecharterinoutfleetmanagement Business Logic Command Interface<br>
 * - NIS2010-Timecharterinoutfleetmanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Choi Woo-Seok
 * @see Esm_fms_0082EventResponse 참조
 * @since J2EE 1.4
 */

	public interface TCharIODeliveryScheduleBC {
		
	/**
	 * Ship Yard Name를 조회한다<br>
	 * 
	 * @return List<SearchShipYardNameListVO>
	 * @exception EventException
	 */
	public List<SearchShipYardNameListVO> searchShipYardNameList() throws EventException;
	
	/**
	 * Ship Yard Name를 생성, 수정, 삭제를 한다<br>
	 * 
	 * @param customShpYdVOs CustomShpYdVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageShipYardName(CustomShpYdVO[] customShpYdVOs, String usrid) throws EventException;
	
	/**
	 * 인도 되어질 선박을 조회한다<br>
	 * 
	 * @param condDeliveryScheduleVO CondDeliveryScheduleVO
	 * @return List<SearchDeliveryScheduleListVO>
	 * @exception EventException
	 */
	public List<SearchDeliveryScheduleListVO> searchDeliveryScheduleList(CondDeliveryScheduleVO condDeliveryScheduleVO) throws EventException;
	
	/**
	 * 인도되어질 선박을 생성, 수정, 삭제를 한다<br>
	 * 
	 * @param customNewBldSkdVOs CustomNewBldSkdVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageDeliverySchedule(CustomNewBldSkdVO[] customNewBldSkdVOs, String usrid) throws EventException;
}