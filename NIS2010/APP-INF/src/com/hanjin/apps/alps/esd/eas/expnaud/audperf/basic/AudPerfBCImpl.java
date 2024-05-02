/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AudPerfBCImpl
*@FileTitle : Performance For Logistics Expense
*Open Issues :   
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02 9014613
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.audperf.basic;


import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.audperf.event.EsdEas0317Event;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.event.EsdEas0318Event;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.event.EsdEas0319Event;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.integration.AudPerfDAO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchLgsCostCdVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfCostDtlListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfOfcListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfSpDtlListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * AudPerfBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author 9014613
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class AudPerfBCImpl extends BasicCommandSupport implements AudPerfBC {

	
	// Database Access Object
	private transient AudPerfDAO dbDao = null;

	/**
	 * AudPerfBCImpl 객체 생성<br>
	 * AudPerfDAO 생성한다.<br>
	 */
	public AudPerfBCImpl(){
		dbDao = new AudPerfDAO();
	}

	/**
	 * Performance For Logistics Expense 조회
	 * 
	 * @category EDS_EAS_0317
	 * @param e EsdEas0317Event
	 * @return List<SearchPerfOfcListVO>
	 * @throws EventException
	 */
	public List<SearchPerfOfcListVO> searchPerfOfcList(Event e) throws EventException {
		EsdEas0317Event event = (EsdEas0317Event) e;
		try {
			return dbDao.searchPerfOfcList(event.getSearchPerfOfcListVO());

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Performance For Logistics Expense - Cost Code 조회.
	 * 
	 * @category EDS_EAS_0317
	 * @param e EsdEas0317Event
	 * @return List<SearchLgsCostCdVO>
	 * @throws EventException
	 */
	public List<SearchLgsCostCdVO> searchLgsCostCd(Event e) throws EventException {
		EsdEas0317Event event = (EsdEas0317Event) e;
		try {
			return dbDao.searchLgsCostCd(event.getSearchLgsCostCdVO());

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Performance For Logistics Expense - S/P Detail 조회.
	 * 
	 * @category EDS_EAS_0318
	 * @param e EsdEas0318Event
	 * @return List<SearchPerfSpDtlListVO>
	 * @throws EventException
	 */
	public List<SearchPerfSpDtlListVO> searchPerfSpDtlList(Event e) throws EventException {
		EsdEas0318Event event = (EsdEas0318Event) e;
		try {
			return dbDao.searchPerfSpDtlList(event.getSearchPerfSpDtlListVO());

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Performance For Logistics Expense - Cost Detail 조회.
	 * 
	 * @category EDS_EAS_0319
	 * @param e EsdEas0319Event
	 * @return List<SearchPerfCostDtlListVO>
	 * @throws EventException
	 */
	public List<SearchPerfCostDtlListVO> searchPerfCostDtlList(Event e) throws EventException {
		EsdEas0319Event event = (EsdEas0319Event) e;
		try {
			return dbDao.searchPerfCostDtlList(event.getSearchPerfCostDtlListVO());

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
}
