/*============================================
*Copyright(c) 2016 CyberLogitec
*@FileName :CreditIncentiveSummaryBCImpl.java
*@FileTitle : 
*@LastModifyDate : 2016.04.26.
*@LastModifier : 
*@LastVersion : 
* 2016.04.26. SHIN DONG IL
*============================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.event.EsdEas0502Event;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.integration.CreditIncentiveSummaryDBDAO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrIssueVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrRhqVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrSrcVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * CreditIncentiveSummaryBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author SHIN DONG IL
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public class CreditIncentiveSummaryBCImpl extends BasicCommandSupport implements CreditIncentiveSummaryBC {
	// Database Access Object
	private transient CreditIncentiveSummaryDBDAO dbDao = null;
	
	/**
	 * DBDAO 객체 생성
	 */
	public CreditIncentiveSummaryBCImpl() {
		dbDao = new CreditIncentiveSummaryDBDAO();
	}
	
	/**
	 * EsdEas0502Event  <br>
	 * Credti & Invcentive Summary by RHQ를 조회한다. <br>
	 * @param e
	 * @return List<CreditSmmrRhqVO>
	 * @exception EventException
	 */
	public List<CreditSmmrRhqVO> searchCreditByRhqList(Event e) throws EventException{
		try {
			EsdEas0502Event event  = (EsdEas0502Event)e ;
			return dbDao.searchCreditByRhqList(event);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * EsdEas0502Event  <br>
	 * Credti & Invcentive Summary by Source를 조회한다. <br>
	 * @param e 
	 * @return List<CreditSmmrSrcVO>
	 * @exception EventException
	 */
	public List<CreditSmmrSrcVO> searchCreditBySourceList(Event e) throws EventException{
		try {
			EsdEas0502Event event  = (EsdEas0502Event)e ;
			return dbDao.searchCreditBySourceList(event);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	/**
	 * EsdEas0502Event  <br>
	 * CCredti & Invcentive Summary M&R Mileage를 조회한다. <br>
	 * @param e 
	 * @return List<CreditSmmrIssueVO>
	 * @exception EventException
	 */
	public List<CreditSmmrIssueVO> searchCreditIssuetList(Event e) throws EventException{
		try {
			EsdEas0502Event event  = (EsdEas0502Event)e ;
			return dbDao.searchCreditIssuetList(event);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	
	
}