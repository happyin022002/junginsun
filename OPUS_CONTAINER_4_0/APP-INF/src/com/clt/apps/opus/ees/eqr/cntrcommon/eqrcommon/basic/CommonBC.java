/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonBC.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.event.ComboxEventResponse;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrCommonVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * opus-Common Business Logic Command Interface<br>
 *
 * @author 
 * @see ComboxEventResponse 
 * @since J2EE 1.4
 */

public interface CommonBC {
 
 
	/**
	 * 
	 * @param e EsmSpcCodEvent
	 * @return EventResponse EES_EQR_CODEventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCodeList(Event e) throws EventException;

	/**
	 * Search current week
	 *      
	 * @param yyyyww
	 * @param nextNum 
	 * @param direction 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getCurrentWeek() throws EventException;
	
	/**
	 * LocYard Initial Info 
	 * 
	 * @param EesCommonConditionVO eesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLocYardInitialInfo(EesCommonConditionVO eesCommonConditionVO) throws EventException;
	
	
	/**
	 * Trade 
	 * 
	 * @return CommonVO getResultString
	 * @exception EventException
	 */
	public List<EqrCommonVO> searchTradeList() throws EventException;
	
}