/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ScgReportBCImpl.java
*@FileTitle : Surcharge Report
*Open Issues :
*Change history :
*@LastModifyDate : 2013-10-16
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.scgreport.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.report.scgreport.integration.ScgReportDBDAO;
import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgCondVO;
import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgDtlVO;
import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgSmryVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
 
/**
 * ALPS-Surcharge Report Business Logic Basic Command implementation<br>
 * - ALPS-Surcharge Report에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 조인영
 * @see ESD_TRS_3001EventResponse,ScgReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ScgReportBCImpl extends BasicCommandSupport implements ScgReportBC {
	
	// Database Access Object
	private transient ScgReportDBDAO dbDao = null;

	/**
	 * ScgReportBCImpl 객체 생성<br>
	 * ScgReportDBDAO를 생성한다.<br>
	 */
	public ScgReportBCImpl() {
		dbDao = new ScgReportDBDAO();
	}

	/**
	 * Surcharge Report - Summary<br>
	 * 
	 * @param ScgCondVO ScgCondVO
	 * @return List<ScgSmryVO>
	 * @exception EventException
	 */
	public List<ScgSmryVO> searchScgSmry(ScgCondVO ScgCondVO) throws EventException {
		try {
			return dbDao.searchScgSmry(ScgCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		        
	}

	/**
	 * Surcharge Report - Detail<br>
	 * 
	 * @param ScgCondVO ScgCondVO
	 * @return List<ScgDtlVO>
	 * @exception EventException
	 */
	public List<ScgDtlVO> searchScgDtl(ScgCondVO ScgCondVO) throws EventException {
		try {
			return dbDao.searchScgDtl(ScgCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		        
	}


}