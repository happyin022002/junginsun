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
package com.hanjin.apps.alps.vop.fcm.performance.performance.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.fcm.performance.performance.integration.PerformanceDBDAO;
import com.hanjin.apps.alps.vop.fcm.performance.performance.vo.FcmMasterTableInquiryVO;
import com.hanjin.apps.alps.vop.fcm.performance.performance.vo.FcmMonFoilSavCostVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

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
	 * Monthly Fuel Saving Cost 정보를 조회한다.
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return List<FcmMonFoilSavCostVO>
	 * @exception EventException
	 */
	public List<FcmMonFoilSavCostVO> searchFcmMonFoilSavCostList(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws EventException {
		try{
			fcmMonFoilSavCostVO.setFmYrmon(fcmMonFoilSavCostVO.getFmYrmon().replaceAll("-", ""));
			fcmMonFoilSavCostVO.setToYrmon(fcmMonFoilSavCostVO.getToYrmon().replaceAll("-", ""));
			return dbDao.searchFcmMonFoilSavCostList(fcmMonFoilSavCostVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		}
	}
	
//	/**
//	 * Monthly Fuel Saving Cost 정보를 삭제한다.
//	 * 
//	 * @param List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs
//	 * @return int
//	 * @exception EventException
//	 */
//	public int deleteFcmMonFoilSavCostList(List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs) throws EventException {
//		try{
//			return dbDao.deleteFcmMonFoilSavCostList(fcmMonFoilSavCostVOs);
//		} catch (DAOException ex) {
//            throw new EventException(new ErrorHandler("COM12203", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
//		} catch (Exception ex) {
//            throw new EventException(new ErrorHandler("COM12203", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
//		}
//	}
	
	/**
	 * Monthly Fuel Saving Cost 정보를 생성한다.
	 * 
	 * @param List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs
	 * @return int
	 * @exception EventException
	 */
	public int addFcmMonFoilSavCostList(List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs) throws EventException {
		try{
			return dbDao.addFcmMonFoilSavCostList(fcmMonFoilSavCostVOs);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		}
	}
	
	/**
	 * Monthly Fuel Saving Cost 정보가 기존재하는지 조회한다.
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return String
	 * @exception EventException
	 */
	public String searchFcmMonFoilSavCostExist(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws EventException {
		try{
			return dbDao.searchFcmMonFoilSavCostExist(fcmMonFoilSavCostVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		}
	}
	
	/**
	 * Monthly Fuel Saving Cost 생성을 위하여 정보를 조회한다.
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return List<FcmMonFoilSavCostVO>
	 * @exception EventException
	 */
	public List<FcmMonFoilSavCostVO> searchFcmMonFoilSavCostForCre(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws EventException {
		try{
			return dbDao.searchFcmMonFoilSavCostForCre(fcmMonFoilSavCostVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		}
	}
	
	/**
	 * Monthly Fuel Saving Cost 생성.
	 * 
	 * @param FcmMonFoilSavCostVO[] fcmMonFoilSavCostVOs
	 * @param SignOnUserAccount account
	 * @param String inqVslSlanCd
	 * @exception EventException
	 */
	public void manageFcmMonFoilSavCostList(FcmMonFoilSavCostVO[] fcmMonFoilSavCostVOs, SignOnUserAccount account, String inqVslSlanCd) throws EventException {
		try{
			List<FcmMonFoilSavCostVO> aryFcmMonFoilSavCostVOs = new ArrayList<FcmMonFoilSavCostVO>();
			for(int i=0; i<fcmMonFoilSavCostVOs.length; i++){
				fcmMonFoilSavCostVOs[i].setSavCostCreYrmon(fcmMonFoilSavCostVOs[i].getSavCostCreYrmon().replaceAll("-", ""));
				fcmMonFoilSavCostVOs[i].setCreUsrId(account.getUsr_id());
				aryFcmMonFoilSavCostVOs.add(fcmMonFoilSavCostVOs[i]);
			}
			dbDao.deleteFcmMonFoilSavCostList(aryFcmMonFoilSavCostVOs.get(0), inqVslSlanCd);
			dbDao.addFcmMonFoilSavCostList(aryFcmMonFoilSavCostVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"Monthly Fuel Saving Cost List"}).getMessage(), ex);
		}
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
