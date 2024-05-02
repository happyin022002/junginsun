/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailTransitReportBC.java
*@FileTitle : Rail Transit Report BC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.basic;

import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListOptionsVO;
import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;


/**
 * SCEM Commission Business Logic Command Interface<br>
 * - <br>
 *
 * @author Kildong_hong
 * @see UI_ID_11EventResponse
 * @since J2EE 1.4
 */
public interface RailTransitReportBC  {

	/**
     * retrieving Car Location Message
     * 
     * @param SearchCLMListOptionsVO schClmlOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchCLMList(SearchCLMListOptionsVO schClmlOpts) throws EventException;
    
    /**
     * retrieving Car Location Message
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchCLMListPop(SearchRTRInfoVO rtrInfo) throws EventException;
	
    /**
     * retrieving CLM Message
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchCLMCountPop(SearchRTRInfoVO rtrInfo) throws EventException;
	
	
}