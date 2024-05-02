/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VesselReportBCImpl.java
 *@FileTitle : VesselReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.09.12
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
 * 2012.09.12 이혜민 CHM-201220162-01 [FCM] DSL Report 제거
 * 2014.04.07 박다은  CHM-201429498-01 [FCM] Vessel Report Status-Departure Report VMS I/F rule 변경 관련 조치
 * 2014.05.19 박다은 [CHM-201429883] [FCM] Departure Report Tap내 mail Function 신설
=========================================================*/
package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.integration.VesselReportDBDAO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptLogVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptLogVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.SearchMailingListVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslDepRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslDepRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslDepRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptMssMtchVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptNotRcvVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-VesselReport Business Logic Basic Command implementation<br>
 * - ALPS-VesselReport에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0001EventResponse,VesselReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class VesselReportBCImpl extends BasicCommandSupport implements
		VesselReportBC {

	// Database Access Object
	private transient VesselReportDBDAO dbDao = null;

	/**
	 * VesselReportBCImpl 객체 생성<br>
	 * VesselReportBCDBDAO 생성한다.<br>
	 */
	public VesselReportBCImpl() {
		dbDao = new VesselReportDBDAO();
	}
	
	////////////// DEPARTURE REPORT ///////////////
	
	/**
	 * Create departure report log. Create Initial data.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 */
	public void createDepRptLogInit(FcmDepRptLogVO fcmDepRptLogVO)
			throws EventException {
		// Search max sequence of departure report log for update.
		try {
			dbDao.searchDepRptLogMaxRcvSeq(fcmDepRptLogVO);
			dbDao.addDepRptLogInit(fcmDepRptLogVO);
		} catch (DAOException ex) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] { "Departure Report Log" }).getMessage(), ex);
		} catch (Exception ex) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] { "Departure Report Log" }).getMessage(), ex);
		}
	}
	
	/**
	 * Create departure report log. Create general data.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception EventException
	 */
	public void createDepRptLog(FcmDepRptLogVO fcmDepRptLogVO)
			throws EventException {
		try {
			dbDao.modifyDepRptLog(fcmDepRptLogVO);
		} catch (DAOException ex) {
			// COM12208 : Failed to update ($s). Please try again.
			throw new EventException(new ErrorHandler("COM12208", new String[] { "Departure Report Log" }).getMessage(), ex);
		} catch (Exception ex) {
			// COM12208 : Failed to update ($s). Please try again.
			throw new EventException(new ErrorHandler("COM12208", new String[] { "Departure Report Log" }).getMessage(), ex);
		}
	}
	
	/**
	 * Create or update departure report.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception EventException
	 */
	public void manageDepRpt(FcmDepRptLogVO fcmDepRptLogVO) throws EventException {

		String eaiIfRmk = "";
		String ifFlg = "Y";
		try {
			if("D".equals(fcmDepRptLogVO.getVslRptTjTpCd())){
				dbDao.removeDepRpt(fcmDepRptLogVO);
			}else{
				//[CHM-201429498][FCM] Vessel Report Status-Departure Report VMS I/F rule 변경 관련 조치
				if(fcmDepRptLogVO.getOldVslCd() != ""){
					dbDao.removeDepRptOld(fcmDepRptLogVO);					
				}
				dbDao.addDepRpt(fcmDepRptLogVO);
			}
		} catch (DAOException e) {
			eaiIfRmk = e.toString();
			ifFlg = "N";
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] { "Departure Report Log" }).getMessage(), e);
		} catch (Exception e) {
			eaiIfRmk = e.toString();
			ifFlg = "N";
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] { "Departure Report Log" }).getMessage(), e);
		} finally {
			fcmDepRptLogVO.setIfFlg(ifFlg);
			fcmDepRptLogVO.setEaiIfRmk(eaiIfRmk);
		}
	}
	
	/**
	 * Create departure report log. Update result of creation.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception EventException
	 */
	public void createDepRptLogPost(FcmDepRptLogVO fcmDepRptLogVO)
			throws EventException {
		try {
			dbDao.modifyDepRptLogPost(fcmDepRptLogVO);
		} catch (DAOException ex) {
			// COM12208 : Failed to update ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12208", new String[] { "Departure Report Log" }).getMessage(), ex);
		} catch (Exception ex) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12208", new String[] { "Departure Report Log" }).getMessage(), ex);
		}
	}
	
	////////////// NOON REPORT ///////////////

	/**
	 * Create noon report log. Create Initial data.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 */
	public void createNoonRptLogInit(FcmNoonRptLogVO fcmNoonRptLogVO) throws EventException {
		// Search max sequence of noon report log for update.
		try {
			dbDao.searchNoonRptLogMaxRcvSeq(fcmNoonRptLogVO);
			dbDao.addNoonRptLogInit(fcmNoonRptLogVO);
		} catch (DAOException ex) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] { "Noon Report Log" }).getMessage(), ex);
		} catch (Exception ex) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] { "Noon Report Log" }).getMessage(), ex);
		}
	}
	
	/**
	 * Create noon report log. Create general data.<br>
	 *  
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception EventException
	 */
	public void createNoonRptLog(FcmNoonRptLogVO fcmNoonRptLogVO) throws EventException {
		try {
			dbDao.modifyNoonRptLog(fcmNoonRptLogVO);
		} catch (DAOException ex) {
			// COM12208 : Failed to update ($s). Please try again.
			throw new EventException(new ErrorHandler("COM12208", new String[] { "Noon Report Log" }).getMessage(), ex);
		} catch (Exception ex) {
			// COM12208 : Failed to update ($s). Please try again.
			throw new EventException(new ErrorHandler("COM12208", new String[] { "Noon Report Log" }).getMessage(), ex);
		}	
	}
	
	/**
	 * Create or update noon report.<br>
	 *  
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception EventException
	 */
	public void manageNoonRpt(FcmNoonRptLogVO fcmNoonRptLogVO) throws EventException {
		String eaiIfRmk = "";
		String ifFlg = "Y";
		try {
			if("D".equals(fcmNoonRptLogVO.getVslRptTjTpCd())){
				dbDao.removeNoonRpt(fcmNoonRptLogVO);
			}else{
				dbDao.addNoonRpt(fcmNoonRptLogVO);
			}
		} catch (DAOException e) {
			eaiIfRmk = e.toString();
			ifFlg = "N";
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] { "Noon Report Log" }).getMessage(), e);
		} catch (Exception e) {
			eaiIfRmk = e.toString();
			ifFlg = "N";
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] { "Noon Report Log" }).getMessage(), e);
		} finally {
			fcmNoonRptLogVO.setIfFlg(ifFlg);
			fcmNoonRptLogVO.setEaiIfRmk(eaiIfRmk);
		}
	}
	
	/**
	 * Create noon report log. Update result of creation.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception EventException
	 */
	public void createNoonRptLogPost(FcmNoonRptLogVO fcmNoonRptLogVO) throws EventException {
		try {
			dbDao.modifyNoonRptLogPost(fcmNoonRptLogVO);
		} catch (DAOException ex) {
			// COM12208 : Failed to update ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12208", new String[] { "Noon Report Log" }).getMessage(), ex);
		} catch (Exception ex) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12208", new String[] { "Noon Report Log" }).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Vessel Report에 대한 주어진 구간의 스케줄 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslRptInqVO>
	 * @exception EventException
	 */
	public List<List<VslRptInqVO>> searchVslRptSkdInfo(VslRptInqVO vslRptInqVO) throws EventException {
		try {
			List<List<VslRptInqVO>> vslRptSkdInfoList = new ArrayList<List<VslRptInqVO>>();
			vslRptInqVO.setIbflag("1");
			vslRptSkdInfoList.add(dbDao.searchVslRptSkdInfo(vslRptInqVO));
			vslRptInqVO.setIbflag("2");
			vslRptSkdInfoList.add(dbDao.searchVslRptSkdInfo(vslRptInqVO));
			vslRptInqVO.setIbflag("3");
			vslRptSkdInfoList.add(dbDao.searchVslRptSkdInfo(vslRptInqVO));
			return vslRptSkdInfoList;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Report"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Report"}).getMessage(), ex);
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Departure Report 기본 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO
	 *            vslRptInqVO
	 * @return List<VslDepRptVO>
	 * @exception EventException
	 */
	public List<VslDepRptVO> searchVslDepRpt(VslRptInqVO vslRptInqVO)
			throws EventException {
		try {
			return dbDao.searchVslDepRpt(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report"}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Departure Report Not Received 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO
	 *            vslRptInqVO
	 * @return List<VslDepRptNotRcvVO>
	 * @exception EventException
	 */
	public List<VslDepRptNotRcvVO> searchVslDepRptNotRcv(VslRptInqVO vslRptInqVO)
			throws EventException {
		try {
			return dbDao.searchVslDepRptNotRcv(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Not Received"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Not Received"}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Departure Report Mismatched 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO
	 *            vslRptInqVO
	 * @return List<VslDepRptMssMtchVO>
	 * @exception EventException
	 */
	public List<VslDepRptMssMtchVO> searchVslDepRptMssMtch(
			VslRptInqVO vslRptInqVO) throws EventException {
		try {
			return dbDao.searchVslDepRptMssMtch(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Mismatched"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Mismatched"}).getMessage(), ex);
		}
	}


	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Noon Report 기본 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslNoonRptVO>
	 * @exception EventException
	 */
	public List<VslNoonRptVO> searchVslNoonRpt(VslRptInqVO vslRptInqVO)
			throws EventException {
		try {
			return dbDao.searchVslNoonRpt(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Noon Report"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Noon Report"}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Noon Report Not Received 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslNoonRptNotRcvVO>
	 * @exception EventException
	 */
	public List<VslNoonRptNotRcvVO> searchVslNoonRptNotRcv(
			VslRptInqVO vslRptInqVO) throws EventException {
		
		try {
			return dbDao.searchVslNoonRptNotRcv(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Noon Report Not Received"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Noon Report Not Received"}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Noon Report Mismatched 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslNoonRptMssMtchVO>
	 * @exception EventException
	 */
	public List<VslNoonRptMssMtchVO> searchVslNoonRptMssMtch(
			VslRptInqVO vslRptInqVO) throws EventException {
		
		try {
			return dbDao.searchVslNoonRptMssMtch(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Noon Report Mismatched"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Noon Report Mismatched"}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ABLog Report 기본 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO
	 *            vslRptInqVO
	 * @return List<VslABLogRptVO>
	 * @exception EventException
	 */
	public List<VslABLogRptVO> searchVslABLogRpt(VslRptInqVO vslRptInqVO)
			throws EventException {

		try {
			return dbDao.searchVslABLogRpt(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ABLog Report"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ABLog Report"}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ABLog Report Not Received 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO
	 *            vslRptInqVO
	 * @return List<VslABLogRptNotRcvVO>
	 * @exception EventException
	 */
	public List<VslABLogRptNotRcvVO> searchVslABLogRptNotRcv(
			VslRptInqVO vslRptInqVO) throws EventException {
		try {
			return dbDao.searchVslABLogRptNotRcv(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ABLog Report Not Received"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ABLog Report Not Received"}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ABLog Report Mismatched 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO
	 *            vslRptInqVO
	 * @return List<VslABLogRptMssMtchVO>
	 * @exception EventException
	 */
	public List<VslABLogRptMssMtchVO> searchVslABLogRptMssMtch(
			VslRptInqVO vslRptInqVO) throws EventException {
		try {
			return dbDao.searchVslABLogRptMssMtch(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ABLog Report Mismatched"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ABLog Report Mismatched"}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ROB Month End Report 기본 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO
	 *            vslRptInqVO
	 * @return List<VslRobMthEndRptVO>
	 * @exception EventException
	 */
	public List<VslRobMthEndRptVO> searchVslRobMthEndRpt(VslRptInqVO vslRptInqVO)
			throws EventException {
		try {
			return dbDao.searchVslRobMthEndRpt(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ROB Month End Report"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ROB Month End Report"}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ROB Month End Report Not Received 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO
	 *            vslRptInqVO
	 * @return List<VslRobMthEndRptNotRcvVO>
	 * @exception EventException
	 */
	public List<VslRobMthEndRptNotRcvVO> searchVslRobMthEndRptNotRcv(
			VslRptInqVO vslRptInqVO) throws EventException {
		try {
			return dbDao.searchVslRobMthEndRptNotRcv(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ROB Month End Report Not Received"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ROB Month End Report Not Received"}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ROB Month End Report Mismatched 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO
	 *            vslRptInqVO
	 * @return List<VslRobMthEndRptMssMtchVO>
	 * @exception EventException
	 */
	public List<VslRobMthEndRptMssMtchVO> searchVslRobMthEndRptMssMtch(
			VslRptInqVO vslRptInqVO) throws EventException {
		try {
			return dbDao.searchVslRobMthEndRptMssMtch(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ROB Month End Report Mismatched"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ROB Month End Report Mismatched"}).getMessage(), ex);
		}
	}

	/**
	 * Mail Preview 를 조회 합니다. <br>
	 * 
	 * @param searchMailingListVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchMailingListVO> searchMailingList(SearchMailingListVO searchMailingListVO) throws EventException {
		try {
			return dbDao.searchMailingList(searchMailingListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Preview"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Preview"}).getMessage(), ex);
		}
	}
	
	
//	/**
//	 * VMS0004(Departure Report) EAI로 수신시 특수문자를 찾아서 replace한다.
//	 * 
//	 * @param String depRmk
//	 * @return String
//	 * @exception EventException
//	 */
//	public String searchSpcCharacterReplace(String depRmk) throws EventException {
//		try {
//			return dbDao.searchSpcCharacterReplace(depRmk);
//		} catch (DAOException ex) {
//            throw new EventException(new ErrorHandler().getMessage(), ex);
//		} catch (Exception ex) {
//            throw new EventException(new ErrorHandler().getMessage(), ex);
//		}
//	}
}
