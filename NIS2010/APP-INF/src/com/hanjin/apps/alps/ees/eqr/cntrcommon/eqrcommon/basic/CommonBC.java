/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonBC.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-27
*@LastModifier :  SHIN DONG IL
*@LastVersion : 1.0
* 2013-05-27  SHIN DONG IL
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.basic;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.event.ComboxEventResponse;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * alps-Common Business Logic Command Interface<br>
 * - alps-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SHIN DONG IL
 * @see ComboxEventResponse 참조
 * @since J2EE 1.4
 */

public interface CommonBC {
 
 
	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsmSpcCodEvent
	 * @return EventResponse EES_EQR_CODEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCodeList(Event e) throws EventException;

	/**
	 * 현재주차 정보를 조회 
	 *      
	 * @param yyyyww
	 * @param nextNum 
	 * @param direction 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getCurrentWeek() throws EventException;
	
	/**
	 * LocYardInitialInfo 를 조회한다
	 *  
	 * @param EesCommonConditionVO eesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLocYardInitialInfo(EesCommonConditionVO eesCommonConditionVO) throws EventException;
	
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO searchLocYardInfo
	 * @exception EventException
	 */			
	public EesCommonVO searchLocYardExist(EesCommonConditionVO conditionVO) throws EventException;	
	
	/**
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLocYardVesselInfo(EesCommonConditionVO conditionVO) throws EventException;	
}