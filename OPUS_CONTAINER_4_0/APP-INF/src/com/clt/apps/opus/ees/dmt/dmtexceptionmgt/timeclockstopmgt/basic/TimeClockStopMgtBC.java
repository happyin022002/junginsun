/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeClockStopMgtBC.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockStopParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.YardByOfficeVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * APLS-Dmtexceptionmgt Business Logic Command Interface<br>
 *
 * @author
 * @see reference Ui_dmt_2010EventResponse
 * @since J2EE 1.4
 */

public interface TimeClockStopMgtBC {
	/**
	 *  Search Clock Stop no data.
	 * 
	 * @param TimeClockStopParmVO  timeClockStopParmVO
	 * @return List<DmtTimeClockStopVO>
	 * @exception EventException
	 */
	public List<DmtTimeClockStopVO> searchTimeClockStop(TimeClockStopParmVO  timeClockStopParmVO ) throws EventException;
	/**
	 * Search Clock Stop no data List.
	 * 
	 * @param TimeClockStopParmVO timeClockStopParmVO
	 * @return List<DmtTimeClockStopVO>
	 * @exception EventException
	 */
	public List<DmtTimeClockStopVO> searchTimeClockStopList(TimeClockStopParmVO timeClockStopParmVO ) throws EventException;
	/**
	 * Change statue of data about Clock Stop no.
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
//	public void cancelTimeClockStop(DmtTimeClockStopVO dmtTimeClockStopVO,SignOnUserAccount account) throws EventException;
	/**
	 * Clock Stop apply to information.
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @param SignOnUserAccount account
	 * @return List<DmtTimeClockStopVO>
	 * @exception EventException
	 */
//	public List<DmtTimeClockStopVO> CreateTimeClockStop(DmtTimeClockStopVO dmtTimeClockStopVO,SignOnUserAccount account) throws EventException;
	/**
	 * search autority.
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchAuthExist(String ofcCd) throws EventException;
	
	/////////////////////////////////////////////////////////////////////////////////////
	////////// START BACK END JOB AREA //////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * EES_DMT_2010 : BACKENDJOB START.<br>
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
     * @param SignOnUserAccount account
	 * @return String
	 */
	public String doBackEndJob(DmtTimeClockStopVO dmtTimeClockStopVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * BACKENDJOB return status.<br>
	 * 
	 * @param String key
	 * @return String
	 */
	public String comBackEndJb(String key) throws EventException ;
	
	/**
	 * BackEndJob Read <br>
	 * BackEndJob  return result.<br>
	 *
	 * @param String key
	 * @return DmtTimeClockStopVO
	 * @exception EventException
	 */
	public DmtTimeClockStopVO createTimeClockStopBackEndJob(String key) throws EventException;
	
	/**
	 * EES_DMT_2010 : BACKENDJOB START.<br>
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
     * @param SignOnUserAccount account
	 * @return String
	 */
	public String doCancelBackEndJob(DmtTimeClockStopVO dmtTimeClockStopVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * BACKENDJOB  return status.<br>
	 * 
	 * @param String key
	 * @return String
	 */
	public String comCancelBakEndJb(String key) throws EventException ;
	
	/**
	 * BackEndJob Read <br>
	 * BackEndJob return result<br>
	 *
	 * @param String key
	 * @return DmtTimeClockStopVO
	 * @exception EventException
	 */
	public DmtTimeClockStopVO cancelTimeClockStopBackEndJob(String key) throws EventException;
	
	/**
	 * Search Yard Code of Office.<br>
	 * 
	 * @param TimeClockStopParmVO timeClockStopParamVO
	 * @return List<YardByOfficeVO>
	 * @exception EventException
	 */
	public List<YardByOfficeVO> searchDMTYardByOffice(TimeClockStopParmVO timeClockStopParamVO ) throws EventException;
	
}
