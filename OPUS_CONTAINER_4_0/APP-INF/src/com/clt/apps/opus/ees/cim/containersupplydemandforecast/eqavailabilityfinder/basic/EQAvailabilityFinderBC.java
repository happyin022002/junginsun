/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQAvailabilityFinderBC.java
*@FileTitle : EQ Availability
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.basic;

import java.util.List;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailDetailListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailOptionVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailRepoListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Containersupplydemandforecast Business Logic Command Interface
 *
 * @author 
 * @see Ees_cim_0034EventResponse reference
 * @since J2EE 1.4
 */

public interface EQAvailabilityFinderBC {
	

	/**
	 * retrieving available MTY EQ quantity for 2 weeks from retrieving day by yard and daily
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return List<AvailListVO>
	 * @exception EventException
	 */
	public List<AvailListVO> searchAvailList(AvailOptionVO availOptionVO) throws EventException;

	
	/**
	 * retrieving MTY booking information and MTY transfer plan form Inland route 
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailRepoListVO[]
	 * @exception EventException
	 */
	public AvailRepoListVO[] searchAvailRepoList(AvailOptionVO availOptionVO) throws EventException;
	
	/**
	 * retrieving late booking information for expected MTY Pick-up 
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailPastBRList(AvailOptionVO availOptionVO) throws EventException;	

	/**
	 * retrieving Booking Detail for BR(Booking Reserved)
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailBRList(AvailOptionVO availOptionVO) throws EventException;	

	/**
	 * retrieving Today's Pick-up(PUP, Picked Up) container quantity
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailPickUpList(AvailOptionVO availOptionVO) throws EventException;	

	/**
	 * retrieving expected quantity detail for IG(I/B MTY Generation) 
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailIGList(AvailOptionVO availOptionVO) throws EventException;	

	/**
	 * retrieving container quantity for Today's MTY Returned 
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailRTNList(AvailOptionVO availOptionVO) throws EventException;	
	
	/**
	 * retrieving details for Off-hire plan and performance
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailOFFList(AvailOptionVO availOptionVO) throws EventException;	
	
	/**
	 * retrieving details for Off-hire plan and performance
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailONList(AvailOptionVO availOptionVO) throws EventException;	
	
	
	/**
	 * retrieving available MTY EQ quantity for 2 weeks from retrieving day by yard and daily
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return List<AvailListVO>
	 * @exception EventException
	 */
	public List<AvailListVO> searchAvailTpSzList(AvailOptionVO availOptionVO) throws EventException;

}