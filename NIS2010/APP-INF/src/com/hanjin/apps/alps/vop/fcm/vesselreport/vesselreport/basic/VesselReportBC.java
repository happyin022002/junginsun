/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselReportBC.java
*@FileTitle : VesselReport
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.07
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 1.0 Creation
* 
* [CHM-201640787] 연료 소모 분석관련  Departure Report 신규 화면 개발 - 2016.04.07 이병훈
* 
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptErrClsVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptLogVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptLogVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.SearchMailingListVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.SearchVslPortSkdVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslABLogRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptErrVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptOverlapVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslFcmDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslNoonRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptMssMtchVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptNotRcvVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRobMthEndRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VslRptInqVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.FcmDepRptClsHisVO;
import com.hanjin.syscommon.common.table.FcmDepRptErrVO;

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
	public void modifyDepRptLog(FcmDepRptLogVO fcmDepRptLogVO) throws EventException;
	
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
	public void modifyDepRptLogPost(FcmDepRptLogVO fcmDepRptLogVO) throws EventException;
	
	
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
	 * Departure Report Error 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptErrVO>
	 * @exception EventException
	 */
	public List<VslDepRptErrVO> searchVslDepRptErr(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Departure Report Overlap 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptOverlapVO>
	 * @exception EventException
	 */
	public List<VslDepRptOverlapVO> searchVslDepRptOverlap(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * VOP_FCM_0001 화면에 대한 삭제 이벤트 처리
	 * Departure Report Error 항목을 삭제한다.
	 * 
	 * @param VslDepRptErrVO[] vslDepRptErrVOs
	 * @exception EventException
	 */
	public void removeVslDepRptErrList(VslDepRptErrVO[] vslDepRptErrVOs) throws EventException;
	
	/**
	 * VOP_FCM_0001 화면에 대한 삭제 이벤트 처리
	 * Departure Report Overlap 항목을 삭제한다.
	 * 
	 * @param VslDepRptOverlapVO[] vslDepRptOverlapVOs
	 * @exception EventException
	 */
	public void removeVslDepRptOverlapList(VslDepRptOverlapVO[] vslDepRptOverlapVOs) throws EventException;
	
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
	
	/**
	 * Departure Report Inquiry 조회
	 * 
	 * @param vslRptInqVO VslRptInqVO
	 * @return List<VslFcmDepRptVO>
	 * @throws EventException
	 */
	public List<VslFcmDepRptVO> searchVslFcmDepRptList(VslRptInqVO vslRptInqVO) throws EventException;
	
	/**
	 * Departure Report Inquiry 업데이트
	 * 
	 * @param vslFcmDepRptVOs VslFcmDepRptVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void updateVslFcmDepRptList(VslFcmDepRptVO[] vslFcmDepRptVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Departure Report Item Validation Check
	 * 
	 * @param fcmDepRptErrVO
	 * @throws EventException
	 */
	public void validationCheckDepRptItems(FcmDepRptErrVO fcmDepRptErrVO) throws EventException;
	
	/**
	 * Departure Report Item Standard Data 조회<br>
	 * Item Error Cleansing Pop-up 화면에서 Error Data Cleansing 시 호출한다.<br>
	 * 
	 * @param fcmDepRptErrClsVO
	 * @return FcmDepRptErrClsVO
	 * @throws EventException
	 */
	public FcmDepRptErrClsVO searchDepRptStandardData(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException;
	
	/**
	 * Departure Report Item Standard Data 조회<br>
	 * Item Error Cleansing Pop-up 화면에서 본테이블 데이터 수정 시 호출한다.<br>
	 * 
	 * @param fcmDepRptVO
	 * @return FcmDepRptErrClsVO
	 * @throws EventException
	 */
	public FcmDepRptErrClsVO searchDepRptStandardData(FcmDepRptVO fcmDepRptVO) throws EventException;
	
	/**
	 * Departure Report PK Error Cleansing sheet2(SKD) 조회
	 * 
	 * @param SearchVslPortSkdVO vslPortSkdVO
	 * @return List<VslPortSkdVO>
	 * @throws EventException
	 */
	public List<SearchVslPortSkdVO> searchVslPortSkdList(SearchVslPortSkdVO vslPortSkdVO) throws EventException;

	/**
	 *Departure Report PK Error Cleansing 업데이트
	 * 
	 * @param FcmDepRptErrVO vslFcmDepRptVO
	 * @param FcmDepRptClsHisVO fcmDepRptClsHisVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiFcmDepRptErrPkCleasing(FcmDepRptErrVO vslFcmDepRptVO, FcmDepRptClsHisVO fcmDepRptClsHisVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Departure Report Item ERROR Data [FCM_DEP_RPT_ERR] 조회
	 * 
	 * @param searchType
	 * @param sEventName
	 * @param fcmDepRptErrClsVO
	 * @return List<FcmDepRptErrClsVO>
	 * @throws EventException
	 */
	public List<FcmDepRptErrClsVO> searchFcmDepRptErrCls(String searchType, String sEventName, FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException;
	
	/**
	 * Departure Report Cleansing Data 조회
	 * @param searchType
	 * @param fcmDepRptVO
	 * @return List<FcmDepRptErrClsVO>
	 * @throws EventException
	 */
	public List<FcmDepRptErrClsVO> searchFcmDepRptErrCls(String searchType, FcmDepRptVO fcmDepRptVO) throws EventException;
	
	/**
	 * Departure Report Cleansing Data 조회
	 * 
	 * @param fcmDepRptErrClsVO
	 * @return FcmDepRptVO
	 * @throws EventException
	 */
	public FcmDepRptVO searchFcmDepRptCls(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException;
	
	/**
	 * depRptClsVO 를 depRptVO 에  setting
	 * 
	 * @param depRptVO
	 * @param depRptClsVO
	 * @return FcmDepRptVO
	 * @throws EventException
	 */
	public FcmDepRptVO depRptClsVOTOdepRptVO(FcmDepRptVO depRptVO, FcmDepRptErrClsVO depRptClsVO) throws EventException;
	
	/**
	 * Departure Report Item History 조회
	 * 
	 * @param fcmDepRptErrClsVO
	 * @return List<FcmDepRptErrClsVO>
	 * @throws EventException
	 */
	public List<FcmDepRptErrClsVO> searchFcmDepRptClsHis(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException;
	
	/**
	 * Departure Report Same Section Data 조회
	 * 
	 * @param fcmDepRptErrClsVO
	 * @return List<FcmDepRptErrClsVO>
	 * @throws EventException
	 */
	public List<FcmDepRptErrClsVO> searchFcmDepRptSamSectDat(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException;
	
	/**
	 * Departure Report merge, Cleansing History insert
	 * 
	 * @param fcmDepRptErrClsVO
	 * @param account
	 * @throws EventException
	 */
	public void multiFcmDepRptErrCls(FcmDepRptErrClsVO fcmDepRptErrClsVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Departure Report Update, Cleansing History insert
	 * @param depRptVO
	 * @param depRptErrClsVO
	 * @param account
	 * @throws EventException
	 */
	public void multiFcmDepRptErrCls(FcmDepRptVO depRptVO, FcmDepRptErrClsVO depRptErrClsVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * Departure Report Err data delete
	 * 
	 * @param fcmDepRptErrClsVO
	 * @throws EventException
	 */
	public void removeFcmDepRptErr(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException;
	
	/**
	 * overLapVO 와 historyVO 각 항목 비교
	 * @param overLapVO
	 * @param historyVO
	 * @return FcmDepRptErrClsVO
	 * @throws EventException
	 */
	public FcmDepRptErrClsVO overLapDataCompare(FcmDepRptErrClsVO overLapVO, FcmDepRptErrClsVO historyVO) throws EventException;

}
