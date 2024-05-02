/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : PerformanceBCImpl
 *@FileTitle : PerformanceBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.04
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.11.15 진마리아
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
 * 2015.01.23 이병훈 [CHM-201430612] Fuel Consumption Master table 개발
=========================================================*/
package com.clt.apps.opus.vop.fcm.performance.performance.basic;

import java.util.List;

import com.clt.apps.opus.vop.fcm.performance.performance.integration.PerformanceDBDAO;
import com.clt.apps.opus.vop.fcm.performance.performance.vo.FcmMasterTableInquiryVO;
import com.clt.apps.opus.vop.fcm.performance.performance.vo.FcmMonFoilSavCostVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-Performance Business Logic Basic Command implementation<br>
 * - ALPS-Performance에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0061EventResponse,PerformanceBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PerformanceBCImpl extends BasicCommandSupport implements
		PerformanceBC {

	// Database Access Object
	private transient PerformanceDBDAO dbDao = null;

	/**
	 * VesselReportBCImpl 객체 생성<br>
	 * VesselReportBCDBDAO 생성한다.<br>
	 */
	public PerformanceBCImpl() {
		dbDao = new PerformanceDBDAO();
	}
	
	/**
	 * Fuel Consumption Master Table Inquiry 정보를 조회합니다.<br>
	 * [CHM-201430612] Fuel Consumption Master table 개발
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return List<FcmMasterTableInquiryVO>
	 * @exception EventException
	 */
	public List<FcmMasterTableInquiryVO> searchFcmMasterTableInquiry(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws EventException {
		try {
			fcmMonFoilSavCostVO.setFmYrmon(fcmMonFoilSavCostVO.getFmYrmon().replaceAll("-", ""));
			fcmMonFoilSavCostVO.setToYrmon(fcmMonFoilSavCostVO.getToYrmon().replaceAll("-", ""));
			return dbDao.searchFcmMasterTableInquiry(fcmMonFoilSavCostVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Fuel Consumption Master Table Inquiryt"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Fuel Consumption Master Table Inquiry"}).getMessage(), ex);
		}
	}
	
}
