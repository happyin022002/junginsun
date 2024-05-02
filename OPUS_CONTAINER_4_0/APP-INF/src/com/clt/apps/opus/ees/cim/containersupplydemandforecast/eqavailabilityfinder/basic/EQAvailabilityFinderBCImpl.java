/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQAvailabilityFinderBCImpl.java
*@FileTitle : EQ Availability
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.basic;

import java.util.List;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration.EQAvailabilityFinderDBDAO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailDetailListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailOptionVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailRepoListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ContainerSupplyDemandForecast Business Logic Basic Command implementation
 *
 * @author
 * @see EES_CIM_0034EventResponse,EQAvailabilityFinderBC DAO class reference
 * @since J2EE 1.4
 */

public class EQAvailabilityFinderBCImpl extends BasicCommandSupport implements EQAvailabilityFinderBC {

	// Database Access Object
	private transient EQAvailabilityFinderDBDAO dbDao = null;

	/**
	 * creating EQAvailabilityFinderBCImpl Object
	 * creating ${DAO}DAO
	 */
	public EQAvailabilityFinderBCImpl() {
		dbDao = new EQAvailabilityFinderDBDAO();
	}
	/**
	 * retrieving available MTY EQ quantity for 2 weeks from retrieving day by yard and daily
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return List<AvailListVO>
	 * @exception EventException
	 */
	public List<AvailListVO> searchAvailList(AvailOptionVO availOptionVO) throws EventException {
		try {
			return dbDao.searchAvailList(availOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"EQ Availability Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * retrieving MTY booking information and MTY transfer plan form Inland route 
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailRepoListVO[]
	 * @exception EventException
	 */
	public AvailRepoListVO[] searchAvailRepoList(AvailOptionVO availOptionVO) throws EventException {
		AvailRepoListVO[] availRepoListVOs=null; 
		try {
			availRepoListVOs=dbDao.searchAvailRepoList(availOptionVO);
			
			return availRepoListVOs;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"MTY Reposition for EQ Availability Retrieve"}).getMessage(),de);
		}
		
	}
	
	/**
	 * retrieving late booking information for expected MTY Pick-up 
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailPastBRList(AvailOptionVO availOptionVO) throws EventException {
		AvailDetailListVO[] availDetailListVOs=null; 
		try {
			availDetailListVOs=dbDao.searchAvailPastBRList(availOptionVO);
			
			return availDetailListVOs;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"MTY Reposition for EQ Availability Past BR Retrieve"}).getMessage(),de);
		}
		
	}	
	
	/**
	 * retrieving Booking Detail for BR(Booking Reserved)
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailBRList(AvailOptionVO availOptionVO) throws EventException {
		AvailDetailListVO[] availDetailListVOs=null; 
		try {
			availDetailListVOs=dbDao.searchAvailBRList(availOptionVO);
			
			return availDetailListVOs;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"MTY Reposition for EQ Availability BR Retrieve"}).getMessage(),de);
		}
		
	}
	
	/**
	 * retrieving Today's Pick-up(PUP, Picked Up) container quantity
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailPickUpList(AvailOptionVO availOptionVO) throws EventException {
		AvailDetailListVO[] availDetailListVOs=null; 
		try {
			availDetailListVOs=dbDao.searchAvailPickUpList(availOptionVO);
			
			return availDetailListVOs;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"MTY Reposition for EQ Availability Picked Up Retrieve"}).getMessage(),de);
		}
		
	}	

	/**
	 * retrieving expected quantity detail for IG(I/B MTY Generation) 
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailIGList(AvailOptionVO availOptionVO) throws EventException {
		AvailDetailListVO[] availDetailListVOs=null; 
		try {
			availDetailListVOs=dbDao.searchAvailIGList(availOptionVO);
			
			return availDetailListVOs;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"MTY Reposition for EQ Availability IG Retrieve"}).getMessage(),de);
		}
		
	}
	
	/**
	 * retrieving container quantity for Today's MTY Returned 
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailRTNList(AvailOptionVO availOptionVO) throws EventException {
		AvailDetailListVO[] availDetailListVOs=null; 
		try {
			availDetailListVOs=dbDao.searchAvailRTNList(availOptionVO);
			
			return availDetailListVOs;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"MTY Reposition for EQ Availability RTN Retrieve"}).getMessage(),de);
		}
		
	}	

	/**
	 * retrieving details for Off-hire plan and performance
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailOFFList(AvailOptionVO availOptionVO) throws EventException {
		AvailDetailListVO[] availDetailListVOs=null; 
		try {
			availDetailListVOs=dbDao.searchAvailOFFList(availOptionVO);
			
			return availDetailListVOs;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"MTY Reposition for EQ Availability OFF Retrieve"}).getMessage(),de);
		}
		
	}

	/**
	 * retrieving details for Off-hire plan and performance
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailONList(AvailOptionVO availOptionVO) throws EventException {
		AvailDetailListVO[] availDetailListVOs=null; 
		try {
			availDetailListVOs=dbDao.searchAvailONList(availOptionVO);
			
			return availDetailListVOs;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"MTY Reposition for EQ Availability OFF Retrievee"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"MTY Reposition for EQ Availability OFF Retrieve"}).getMessage(),ex);
		}		
		
	}
	
	
	/**
	 * retrieving available MTY EQ quantity for 2 weeks from retrieving day by yard and daily
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return List<AvailListVO>
	 * @exception EventException
	 */
	public List<AvailListVO> searchAvailTpSzList(AvailOptionVO availOptionVO) throws EventException {
		try {
			return dbDao.searchAvailTpSzList(availOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"EQ Availability Retrieve"}).getMessage(),ex);
		}
	}
}