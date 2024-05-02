/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CargoTrackingBC.java
*@FileTitle : Cargo Tracking BC
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-18
*@LastModifier : 전병석
*@LastVersion : 1.5
* 2006-11-24 Seong-mun Kang
* 1.0 최초 생성
* 2009-09-18
* 1.5 전병석
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.basic;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.vo.CargoTrackingOptionsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;


/**
 * ENIS-SCEM Commission Business Logic Command Interface<br>
 * - ENIS-SCEM Commission에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kildong_hong
 * @see UI_ID_11EventResponse 참조
 * @since J2EE 1.4
 */
public interface CargoTrackingBC  {

	/**
     * Car Location Message 조회
     * 
     * @param CargoTrackingOptionsVO ctopt
     * @return EventResponse 
     * @throws EventException
     */
	public EventResponse searchUSCargoTrackingList(CargoTrackingOptionsVO ctopt) throws EventException;
	//public List<SearchUSCargoTrackingListVO> searchUSCargoTrackingList(SearchUSCargoTrackingListVO schUSCtl)  throws EventException;

	/**
     * Customer 이름을 가져온다.<br>
     * 
     * @param CargoTrackingOptionsVO ctopt
     * @return EventResponse 
     * @exception EventException
     */
	public EventResponse searchCustomerName(CargoTrackingOptionsVO ctopt) throws EventException;
	
	

}