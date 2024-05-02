/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EurCustomsReportBCImpl.java
 *@FileTitle : EurCustomsReportBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.07.20 경종윤
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.basic.CustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.integration.IndiaCustomsReportDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndDecCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndExpAavanceListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndExpVesselPlanListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndReexportListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * NIS2010-CustomsReport Business Logic Basic Command implementation<br>
 * - NIS2010- IndiaCustomsReport에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Shin Kyu Jeong
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class IndiaCustomsReportBCImpl extends CustomsReportBCImpl {

	// Database Access Object
	private transient IndiaCustomsReportDBDAO dbDao = null;

	/**
	 * IndiaCustomsReportBCImpl 객체 생성<br>
	 * IndiaCustomsReportBCImpl 생성한다.<br>
	 */
	public IndiaCustomsReportBCImpl() {
		dbDao = new IndiaCustomsReportDBDAO();
	}

	/**
	 * 인도 Export Vessel Plan List 조회(ESM_BKG_1223)<br>
	 * 
	 * @param  IndDecCondVO indDecCondVO
	 * @return List<IndExpVesselPlanListVO>
	 * @throws DAOException
	 */
	public List<IndExpVesselPlanListVO> searchExpVesselList( IndDecCondVO indDecCondVO ) throws EventException {
		try {
			return dbDao.searchExpVesselList((IndDecCondVO)indDecCondVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * 인도 Re export List 조회(ESM_BKG_1221)<br>
	 * 
	 * @param  IndDecCondVO indDecCondVO
	 * @return List<IndReexportListVO>
	 * @throws DAOException
	 */
	public List<IndReexportListVO> searchReexportList( IndDecCondVO indDecCondVO ) throws EventException {
		try {
			return dbDao.searchReexportList((IndDecCondVO)indDecCondVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	
	
	/**
	 * 인도 Export Advanced List 조회(ESM_BKG_1222)<br>
	 * 
	 * @param  IndDecCondVO indDecCondVO
	 * @return List<IndExpAavanceListVO>
	 * @throws DAOException
	 *//*
	public List<IndExpAavanceListVO> searchExpAdvanceList( IndDecCondVO indDecCondVO ) throws EventException {
		try {
			return dbDao.searchExpAdvanceList((IndDecCondVO)indDecCondVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}*/

	

}