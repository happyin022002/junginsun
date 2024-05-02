/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportBC.java
*@FileTitle : VesselReport
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.12
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
* History
* 2012.09.12 이혜민 CHM-201220162-01 [FCM] DSL Report 제거
* 2014.05.19 박다은 [CHM-201429883] [FCM] Departure Report Tap내 mail Function 신설
=========================================================*/
package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.basic;

import java.util.List;

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
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ALPS-VesselReport Business Logic Command Interface<br>
 * - ALPS-VesselReport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ryu Hyuk
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface VesselReportBC {

	////////////// DEPARTURE REPORT ////////////////
	
	/**
	 * Create departure report log. Create Initial data.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 */
	public void createDepRptLogInit(FcmDepRptLogVO fcmDepRptLogVO) throws EventException;
	
	/**
	 * Create departure report log. Create general data.<br>
	 *  
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception EventException
	 */
	public void createDepRptLog(FcmDepRptLogVO fcmDepRptLogVO) throws EventException;
	
	/**
	 * Create or update departure report.<br>
	 *  
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception EventException
	 */
	public void manageDepRpt(FcmDepRptLogVO fcmDepRptLogVO) throws EventException;
	
	/**
	 * Create departure report log. Update result of creation.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception EventException
	 */
	public void createDepRptLogPost(FcmDepRptLogVO fcmDepRptLogVO) throws EventException;
	
	
	////////////// NOON REPORT ////////////////
	
	/**
	 * Create noon report log. Create Initial data.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 */
	public void createNoonRptLogInit(FcmNoonRptLogVO fcmNoonRptLogVO) throws EventException;
	
	/**
	 * Create noon report log. Create general data.<br>
	 *  
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception EventException
	 */
	public void createNoonRptLog(FcmNoonRptLogVO fcmNoonRptLogVO) throws EventException;
	
	/**
	 * Create or update noon report.<br>
	 *  
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception EventException
	 */
	public void manageNoonRpt(FcmNoonRptLogVO fcmNoonRptLogVO) throws EventException;
	
	/**
	 * Create noon report log. Update result of creation.<br>
	 * 
	 * @param FcmNoonRptLogVO fcmNoonRptLogVO
	 * @exception EventException
	 */
	public void createNoonRptLogPost(FcmNoonRptLogVO fcmNoonRptLogVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Vessel Report에 대한 주어진 구간의 스케줄 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<List<VslRptInqVO>>
	 * @exception EventException
	 */
	public List<List<VslRptInqVO>> searchVslRptSkdInfo(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Departure Report 기본 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptVO>
	 * @exception EventException
	 */
	public List<VslDepRptVO> searchVslDepRpt(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Departure Report Not Received 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptNotRcvVO>
	 * @exception EventException
	 */
	public List<VslDepRptNotRcvVO> searchVslDepRptNotRcv(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Departure Report Mismatched 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptMssMtchVO>
	 * @exception EventException
	 */
	public List<VslDepRptMssMtchVO> searchVslDepRptMssMtch(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Noon Report 기본 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslNoonRptVO>
	 * @exception EventException
	 */
	public List<VslNoonRptVO> searchVslNoonRpt(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Noon Report Not Received 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslNoonRptNotRcvVO>
	 * @exception EventException
	 */
	public List<VslNoonRptNotRcvVO> searchVslNoonRptNotRcv(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Noon Report Mismatched 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslNoonRptMssMtchVO>
	 * @exception EventException
	 */
	public List<VslNoonRptMssMtchVO> searchVslNoonRptMssMtch(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ABLog Report 기본 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslABLogRptVO>
	 * @exception EventException
	 */
	public List<VslABLogRptVO> searchVslABLogRpt(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ABLog Report Not Received 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslABLogRptNotRcvVO>
	 * @exception EventException
	 */
	public List<VslABLogRptNotRcvVO> searchVslABLogRptNotRcv(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ABLog Report Mismatched 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslABLogRptMssMtchVO>
	 * @exception EventException
	 */
	public List<VslABLogRptMssMtchVO> searchVslABLogRptMssMtch(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ROB Month End Report 기본 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslRobMthEndRptVO>
	 * @exception EventException
	 */
	public List<VslRobMthEndRptVO> searchVslRobMthEndRpt(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ROB Month End Report Not Received 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslRobMthEndRptNotRcvVO>
	 * @exception EventException
	 */
	public List<VslRobMthEndRptNotRcvVO> searchVslRobMthEndRptNotRcv(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * ROB Month End Report Mismatched 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslRobMthEndRptMssMtchVO>
	 * @exception EventException
	 */
	public List<VslRobMthEndRptMssMtchVO> searchVslRobMthEndRptMssMtch(VslRptInqVO vslRptInqVO) throws EventException;

	/**
	 * Mail Preview 를 조회 합니다. <br>
	 * 
	 * @param searchMailingListVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchMailingListVO> searchMailingList(SearchMailingListVO searchMailingListVO) throws EventException;
	
//	/**
//	 * VMS0004(Departure Report) EAI로 수신시 특수문자를 찾아서 replace한다.
//	 * 
//	 * @param String depRmk
//	 * @return String
//	 * @exception EventException
//	 */
//	public String searchSpcCharacterReplace(String depRmk) throws EventException;

}
