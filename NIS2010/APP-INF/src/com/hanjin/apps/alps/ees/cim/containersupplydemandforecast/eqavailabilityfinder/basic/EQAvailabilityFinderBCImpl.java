/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQAvailabilityFinderBCImpl.java
*@FileTitle : EQ Availability
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.04 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration.EQAvailabilityFinderDBDAO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailDetailListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailOptionVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailRepoListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-ContainerSupplyDemandForecast Business Logic Basic Command implementation<br>
 * - ALPS-ContainerSupplyDemandForecast에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author kim jong jun
 * @see EES_CIM_0034EventResponse,EQAvailabilityFinderBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class EQAvailabilityFinderBCImpl extends BasicCommandSupport implements EQAvailabilityFinderBC {

	// Database Access Object
	private transient EQAvailabilityFinderDBDAO dbDao = null;

	/**
	 * EQAvailabilityFinderBCImpl 객체 생성<br>
	 * ${DAO}DAO를 생성한다.<br>
	 */
	public EQAvailabilityFinderBCImpl() {
		dbDao = new EQAvailabilityFinderDBDAO();
	}
	/**
	 * 조회일로부터 2Week 기간의 가용 MTY 수량을 Yard, Daily별로 조회 <br>
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
	 * EQR의 MTY BKG정보 및 Inland 구간의 MTY 이송계획을 조회한다. <br>
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
	 *예정 MTY Pick-up 일자가 지난 BR(Booking 정보)를 조회한다. <br>
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
	 *BR(Booking Reserved)의 Detail한 BKG 정보를 조회한다. <br>
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
	 *금일 Pick-up된(PUP, Picked Up) 컨테이너 수량을 조회한다.<br>
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
	 *IG(I/B MTY Generation) 예측수량을 Detail하게 조회.<br>
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
	 *금일 MTY Returned 컨테이너 수량을 확인하는 화면.<br>
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
	 *Off-hire 계획 및 실적(조회당일)의 Detail 정보를 확인.<br>
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
	 *Off-hire 계획 및 실적(조회당일)의 Detail 정보를 확인.<br>
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
}