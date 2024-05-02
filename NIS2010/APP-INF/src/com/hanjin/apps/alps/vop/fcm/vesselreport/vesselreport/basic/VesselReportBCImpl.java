/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VesselReportBCImpl.java
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

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.fcm.fcmcommonutil.fcmgeneralutil.FCMGeneralUtil;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration.VesselReportDBDAO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptErrClsVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptLogVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmDepRptVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptLogVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.SearchMailingListVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.SearchVslPortSkdVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.VskSkdInfoForDepRptVO;
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
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.FcmDepRptClsHisVO;
import com.hanjin.syscommon.common.table.FcmDepRptErrRtSetVO;
import com.hanjin.syscommon.common.table.FcmDepRptErrVO;

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
	public void modifyDepRptLog(FcmDepRptLogVO fcmDepRptLogVO) throws EventException {
		String eaiIfRmk = "";
		String ifFlg = "Y";
		
		try {
			dbDao.modifyDepRptLog(fcmDepRptLogVO);
		} catch (DAOException e) {
			eaiIfRmk = e.toString();
			ifFlg = "N";
			// COM12208 : Failed to update ($s). Please try again.
			throw new EventException(new ErrorHandler("COM12208", new String[] { "Departure Report Log" }).getMessage(), e);
		} catch (Exception e) {
			eaiIfRmk = e.toString();
			ifFlg = "N";
			// COM12208 : Failed to update ($s). Please try again.
			throw new EventException(new ErrorHandler("COM12208", new String[] { "Departure Report Log" }).getMessage(), e);
		} finally {
			fcmDepRptLogVO.setIfFlg(ifFlg);
			fcmDepRptLogVO.setEaiIfRmk(eaiIfRmk);
		}
	}
	
	/**
	 * Manage Departure Report<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception EventException
	 */
	public void manageDepRpt(FcmDepRptLogVO fcmDepRptLogVO) throws EventException {
		String eaiIfRmk = "";
		String ifFlg = "Y";
		Map<String, String> errAddParam = new HashMap<String, String>();
		String depRptErrTpCd = "";
		String originCallIndSeq = "";
		List<VskSkdInfoForDepRptVO> vskSkdInfoForDepRptVOList = null;
		VskSkdInfoForDepRptVO vskSkdInfoForDepRptVO = null;
		FcmDepRptVO lastPortDepRptVO = null;
		boolean isCallIndSeqRevised = false;
		
		try {
			log.debug("\n<<<<<<<<<< Manage Departure Report Start >>>>>>>>>>>>>>>>");
			
			// Delete Flag = "D" 일 경우 본 테이블에서 삭제 후 끝
			if ("D".equals(fcmDepRptLogVO.getVslRptTjTpCd())) {
				dbDao.removeDepRpt(fcmDepRptLogVO);
				return;
			}
			
			//[CHM-201429498][FCM] Vessel Report Status-Departure Report VMS I/F rule 변경 관련 조치
			if (fcmDepRptLogVO.getOldVslCd() != "") {
				dbDao.removeDepRptOld(fcmDepRptLogVO);
			}
			
			/** PK 누락 체크 */
			if (fcmDepRptLogVO.getVslCd() == null || fcmDepRptLogVO.getVoyDirCd() == null || fcmDepRptLogVO.getDepPortCd() == null || fcmDepRptLogVO.getClptIndSeq() == null
					|| "".equals(fcmDepRptLogVO.getVslCd()) || "".equals(fcmDepRptLogVO.getVoyDirCd()) || "".equals(fcmDepRptLogVO.getDepPortCd()) || "".equals(fcmDepRptLogVO.getClptIndSeq())) {
				ifFlg = "N";
				eaiIfRmk = "PK Missing";
				return;
			}
			
			/** Overlap Check */
			if (dbDao.checkDepRptClsHis(fcmDepRptLogVO)) {
				// Error Type Code 셋팅
				depRptErrTpCd = "PO"; // PK Overlap
				errAddParam.put("dep_rpt_err_tp_cd", depRptErrTpCd);
				// FCM_DEP_RPT_ERR 테이블 Insert
				dbDao.addDepRptErr(fcmDepRptLogVO, errAddParam);
				return;
			}
			
			/** Multi Call Check 및 PK Check */
			// CLPT_IND_SEQ 제외 한 Vessel Schedule 조회
			vskSkdInfoForDepRptVOList = dbDao.searchVskSkdInfoForDepRpt(fcmDepRptLogVO, "");
			if (vskSkdInfoForDepRptVOList == null || vskSkdInfoForDepRptVOList.size() == 0) {
				// Error Type Code 셋팅
				depRptErrTpCd = "PM"; // PK Mismatched
				errAddParam.put("dep_rpt_err_tp_cd", depRptErrTpCd);
				// FCM_DEP_RPT_ERR 테이블 Insert
				dbDao.addDepRptErr(fcmDepRptLogVO, errAddParam);
				return;
			} else if (vskSkdInfoForDepRptVOList.size() > 1) {
				// Error Type Code 셋팅
				depRptErrTpCd = "MC"; // Multi Calling
				errAddParam.put("dep_rpt_err_tp_cd", depRptErrTpCd);
				// FCM_DEP_RPT_ERR 테이블 Insert
				dbDao.addDepRptErr(fcmDepRptLogVO, errAddParam);
				return;
			}
			
			/** Call Ind Seq 자동 보정 */
			vskSkdInfoForDepRptVO = vskSkdInfoForDepRptVOList.get(0);
			originCallIndSeq = fcmDepRptLogVO.getClptIndSeq();
			
			if (!originCallIndSeq.equals(vskSkdInfoForDepRptVO.getClptIndSeq())) {
				fcmDepRptLogVO.setClptIndSeq(vskSkdInfoForDepRptVO.getClptIndSeq());
				isCallIndSeqRevised = true;
			}
			
			/** Last Port Departure Report Check */
			lastPortDepRptVO = dbDao.searchLastPortDepRpt(vskSkdInfoForDepRptVO);
			
			if (lastPortDepRptVO == null) {
				
				// Call Ind Seq 보정된 경우에는 원복하고 PK Mismatched 처리
				if (isCallIndSeqRevised) {
					fcmDepRptLogVO.setClptIndSeq(originCallIndSeq);
					// Error Type Code 셋팅
					depRptErrTpCd = "PM"; // PK Mismatched
					errAddParam.put("dep_rpt_err_tp_cd", depRptErrTpCd);
					
				// Call Ind Seq 보정되지 않은 경우에는 Last Report Missing 처리
				} else {
					// Error Type Code 셋팅
					depRptErrTpCd = "LM"; // Last Report Missing
					errAddParam.put("dep_rpt_err_tp_cd", depRptErrTpCd);
				}
				
				// FCM_DEP_RPT_ERR 테이블 Insert
				dbDao.addDepRptErr(fcmDepRptLogVO, errAddParam);
				return;
			}
			
			/** Item 항목 Validation Check */
			validationCheckDepRptItems(fcmDepRptLogVO, isCallIndSeqRevised, originCallIndSeq);
			eaiIfRmk = fcmDepRptLogVO.getEaiIfRmk();
			
			log.debug("\n<<<<<<<<<< Manage Departure Report End >>>>>>>>>>>>>>>>");
			
		} catch (DAOException e) {
			eaiIfRmk = e.toString();
			ifFlg = "N";
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		} catch (Exception e) {
			eaiIfRmk = e.toString();
			ifFlg = "N";
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		} finally {
			fcmDepRptLogVO.setIfFlg(ifFlg);
			fcmDepRptLogVO.setEaiIfRmk(eaiIfRmk);
		}
	}
	
	/**
	 * Departure Report Item Validation Check
	 * 
	 * @param fcmDepRptErrVO
	 * @throws EventException
	 */
	public void validationCheckDepRptItems(FcmDepRptErrVO fcmDepRptErrVO) throws EventException {
		try {
			// Departure Report Log 테이블에서 기본 정보 추출
			FcmDepRptLogVO fcmDepRptLogVO = dbDao.searchDepRptLog(fcmDepRptErrVO);
			
			// 화면에서 변경 된 값으로 PK 값 셋팅
			fcmDepRptLogVO.setVslCd(fcmDepRptErrVO.getVslCd());
			fcmDepRptLogVO.setVoyDirCd(fcmDepRptErrVO.getSkdVoyNo() + fcmDepRptErrVO.getSkdDirCd());
			fcmDepRptLogVO.setDepPortCd(fcmDepRptErrVO.getDepPortCd());
			String clptIndSeq = null;
			if ("1".equals(fcmDepRptErrVO.getClptIndSeq())) {
				clptIndSeq = "F";
			} else if ("2".equals(fcmDepRptErrVO.getClptIndSeq())) {
				clptIndSeq = "S";
			} else if ("3".equals(fcmDepRptErrVO.getClptIndSeq())) {
				clptIndSeq = "T";
			}
			fcmDepRptLogVO.setClptIndSeq(clptIndSeq);
			
			// Item 항목 Validation Check 진행
			validationCheckDepRptItems(fcmDepRptLogVO, false, "");
			
		} catch (DAOException e) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		} catch (Exception e) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		}
	}
	
	/**
	 * Departure Report Item Validation Check
	 * 
	 * @param fcmDepRptLogVO
	 * @param isCallIndSeqRevised
	 * @param originCallIndSeq
	 * @throws EventException
	 */
	public void validationCheckDepRptItems(FcmDepRptLogVO fcmDepRptLogVO, boolean isCallIndSeqRevised, String originCallIndSeq) throws EventException {
		String eaiIfRmk = "";
		String ifFlg = "Y";
		String depRptErrTpCd = "";
		Map<String, String> errAddParam = new HashMap<String, String>();
		boolean isAllItemOK = true;
		StringBuffer errItmCtnt = new StringBuffer();
		FcmDepRptErrRtSetVO errRt = null;
		FcmDepRptErrClsVO standardData = null;
		boolean isNvgtMlDistValid = false;
		
		try {
			log.debug("\n<<<<<<<<<< Departure Report Item Validation Check Start >>>>>>>>>>>>>>>>");
			
			/** Validation Check 대상 Item 추출 */
			String rupDt = null;
			String sbEngDt = null;
			String vpsEtbDt = null;
			String vpsEtdDt = null;
			String pltInDt = null;
			String bfrBrthAnkDrpDt = null;
			String bfrBrthAnkOffDt = null;
			String cgoWrkStDt = null;
			String cgoWrkEndDt = null;
			String aftUnbrthAnkDrpDt = null;
			String aftUnbrthAnkOffDt = null;
			String pltOutDt = null;
			String nvgtMlDist = null;
			String engMlDist = null;
			String mnvrInMlDist = null;
			String mnvrOutMlDist = null;
			String avgRpmPwr = null;
			String avgSpd = null;
			String arrFoilWgt = null;
			String arrDoilWgt = null;
			String arrLowSulpFoilWgt = null;
			String arrLowSulpDoilWgt = null;
			String depFoilWgt = null;
			String depDoilWgt = null;
			String depLowSulpFoilWgt = null;
			String depLowSulpDoilWgt = null;
			String seaMnFoilCsmQty = null;
			String seaGnrFoilCsmQty = null;
			String seaBlrFoilCsmQty = null;
			String seaMnDoilCsmQty = null;
			String seaGnrDoilCsmQty = null;
			String seaBlrDoilCsmQty = null;
			String seaMnLowSulpFoilCsmQty = null;
			String seaGnrLowSulpFoilCsmQty = null;
			String seaBlrLowSulpFoilCsmQty = null;
			String seaMnLowSulpDoilCsmQty = null;
			String seaGnrLowSulpDoilCsmQty = null;
			String seaBlrLowSulpDoilCsmQty = null;
			String portMnFoilCsmQty = null;
			String portGnrFoilCsmQty = null;
			String portBlrFoilCsmQty = null;
			String portMnDoilCsmQty = null;
			String portGnrDoilCsmQty = null;
			String portBlrDoilCsmQty = null;
			String portMnLowSulpFoilCsmQty = null;
			String portGnrLowSulpFoilCsmQty = null;
			String portBlrLowSulpFoilCsmQty = null;
			String portMnLowSulpDoilCsmQty = null;
			String portGnrLowSulpDoilCsmQty = null;
			String portBlrLowSulpDoilCsmQty = null;
			String fullCntrObrdTeu = null;
			String mtyCntrObrdTeu = null;
			String ttlCntrObrdTeu = null;
			String rfCntrDchgKnt = null;
			String rfCntrLodKnt = null;
			String rfCntrObrdKnt = null;
			String depCgoWgt = null;
			
			if (fcmDepRptLogVO != null) {
				rupDt = fcmDepRptLogVO.getRupDt();
				sbEngDt = fcmDepRptLogVO.getSbEngDt();
				vpsEtbDt = fcmDepRptLogVO.getVpsEtbDt();
				vpsEtdDt = fcmDepRptLogVO.getVpsEtdDt();
				pltInDt = fcmDepRptLogVO.getPltInDt();
				bfrBrthAnkDrpDt = fcmDepRptLogVO.getBfrBrthAnkDrpDt();
				bfrBrthAnkOffDt = fcmDepRptLogVO.getBfrBrthAnkOffDt();
				cgoWrkStDt = fcmDepRptLogVO.getCgoWrkStDt();
				cgoWrkEndDt = fcmDepRptLogVO.getCgoWrkEndDt();
				aftUnbrthAnkDrpDt = fcmDepRptLogVO.getAftUnbrthAnkDrpDt();
				aftUnbrthAnkOffDt = fcmDepRptLogVO.getAftUnbrthAnkOffDt();
				pltOutDt = fcmDepRptLogVO.getPltOutDt();
				nvgtMlDist = fcmDepRptLogVO.getNvgtMlDist();
				engMlDist = fcmDepRptLogVO.getEngMlDist();
				mnvrInMlDist = fcmDepRptLogVO.getMnvrInMlDist();
				mnvrOutMlDist = fcmDepRptLogVO.getMnvrOutMlDist();
				avgRpmPwr = fcmDepRptLogVO.getAvgRpmPwr();
				avgSpd = fcmDepRptLogVO.getAvgSpd();
				depCgoWgt = fcmDepRptLogVO.getDepCgoWgt();
				
				List<String> arrRobCtntList = FCMGeneralUtil.convertListByString(fcmDepRptLogVO.getArrRobCtnt(), "|");
				if (arrRobCtntList.size() > 0) {
					arrFoilWgt = (String) arrRobCtntList.get(0);
				}
				if (arrRobCtntList.size() > 1) {
					arrDoilWgt = (String) arrRobCtntList.get(1);
				}
				if (arrRobCtntList.size() > 4) {
					arrLowSulpFoilWgt = (String) arrRobCtntList.get(4);
				}
				if (arrRobCtntList.size() > 5) {
					arrLowSulpDoilWgt = (String) arrRobCtntList.get(5);
				}
				
				List<String> depRobCtntList = FCMGeneralUtil.convertListByString(fcmDepRptLogVO.getDepRobCtnt(), "|");
				if (depRobCtntList.size() > 0) {
					depFoilWgt = (String) depRobCtntList.get(0);
				}
				if (depRobCtntList.size() > 1) {
					depDoilWgt = (String) depRobCtntList.get(1);
				}
				if (depRobCtntList.size() > 4) {
					depLowSulpFoilWgt = (String) depRobCtntList.get(4);
				}
				if (depRobCtntList.size() > 5) {
					depLowSulpDoilWgt = (String) depRobCtntList.get(5);
				}
				
				List<String> seaFuelCsmCtntList = FCMGeneralUtil.convertListByString(fcmDepRptLogVO.getSeaFuelCsmCtnt(), "|");
				if (seaFuelCsmCtntList.size() > 0) {
					seaMnFoilCsmQty = (String) seaFuelCsmCtntList.get(0);
				}
				if (seaFuelCsmCtntList.size() > 1) {
					seaGnrFoilCsmQty = (String) seaFuelCsmCtntList.get(1);
				}
				if (seaFuelCsmCtntList.size() > 2) {
					seaBlrFoilCsmQty = (String) seaFuelCsmCtntList.get(2);
				}
				if (seaFuelCsmCtntList.size() > 3) {
					seaMnDoilCsmQty = (String) seaFuelCsmCtntList.get(3);
				}
				if (seaFuelCsmCtntList.size() > 4) {
					seaGnrDoilCsmQty = (String) seaFuelCsmCtntList.get(4);
				}
				if (seaFuelCsmCtntList.size() > 5) {
					seaBlrDoilCsmQty = (String) seaFuelCsmCtntList.get(5);
				}
				
				List<String> seaLowSulpFuelCsmCtnt = FCMGeneralUtil.convertListByString(fcmDepRptLogVO.getSeaLowSulpFuelCsmCtnt(), "|");
				if (seaLowSulpFuelCsmCtnt.size() > 0) {
					seaMnLowSulpFoilCsmQty = (String) seaLowSulpFuelCsmCtnt.get(0);
				}
				if (seaLowSulpFuelCsmCtnt.size() > 1) {
					seaGnrLowSulpFoilCsmQty = (String) seaLowSulpFuelCsmCtnt.get(1);
				}
				if (seaLowSulpFuelCsmCtnt.size() > 2) {
					seaBlrLowSulpFoilCsmQty = (String) seaLowSulpFuelCsmCtnt.get(2);
				}
				if (seaLowSulpFuelCsmCtnt.size() > 3) {
					seaMnLowSulpDoilCsmQty = (String) seaLowSulpFuelCsmCtnt.get(3);
				}
				if (seaLowSulpFuelCsmCtnt.size() > 4) {
					seaGnrLowSulpDoilCsmQty = (String) seaLowSulpFuelCsmCtnt.get(4);
				}
				if (seaLowSulpFuelCsmCtnt.size() > 5) {
					seaBlrLowSulpDoilCsmQty = (String) seaLowSulpFuelCsmCtnt.get(5);
				}
				
				List<String> portFuelCsmCtntList = FCMGeneralUtil.convertListByString(fcmDepRptLogVO.getPortFuelCsmCtnt(), "|");
				if (portFuelCsmCtntList.size() > 0) {
					portMnFoilCsmQty = (String) portFuelCsmCtntList.get(0);
				}
				if (portFuelCsmCtntList.size() > 1) {
					portGnrFoilCsmQty = (String) portFuelCsmCtntList.get(1);
				}
				if (portFuelCsmCtntList.size() > 2) {
					portBlrFoilCsmQty = (String) portFuelCsmCtntList.get(2);
				}
				if (portFuelCsmCtntList.size() > 3) {
					portMnDoilCsmQty = (String) portFuelCsmCtntList.get(3);
				}
				if (portFuelCsmCtntList.size() > 4) {
					portGnrDoilCsmQty = (String) portFuelCsmCtntList.get(4);
				}
				if (portFuelCsmCtntList.size() > 5) {
					portBlrDoilCsmQty = (String) portFuelCsmCtntList.get(5);
				}
				
				List<String> portLowSulpFuelCsmCtntList = FCMGeneralUtil.convertListByString(fcmDepRptLogVO.getPortLowSulpFuelCsmCtnt(), "|");
				if (portLowSulpFuelCsmCtntList.size() > 0) {
					portMnLowSulpFoilCsmQty = (String) portLowSulpFuelCsmCtntList.get(0);
				}
				if (portLowSulpFuelCsmCtntList.size() > 1) {
					portGnrLowSulpFoilCsmQty = (String) portLowSulpFuelCsmCtntList.get(1);
				}
				if (portLowSulpFuelCsmCtntList.size() > 2) {
					portBlrLowSulpFoilCsmQty = (String) portLowSulpFuelCsmCtntList.get(2);
				}
				if (portLowSulpFuelCsmCtntList.size() > 3) {
					portMnLowSulpDoilCsmQty = (String) portLowSulpFuelCsmCtntList.get(3);
				}
				if (portLowSulpFuelCsmCtntList.size() > 4) {
					portGnrLowSulpDoilCsmQty = (String) portLowSulpFuelCsmCtntList.get(4);
				}
				if (portLowSulpFuelCsmCtntList.size() > 5) {
					portBlrLowSulpDoilCsmQty = (String) portLowSulpFuelCsmCtntList.get(5);
				}
				
				List<String> cntrCgoCtnt = FCMGeneralUtil.convertListByString(fcmDepRptLogVO.getCntrCgoCtnt(), "|");
				if (cntrCgoCtnt.size() > 0) {
					fullCntrObrdTeu = (String) cntrCgoCtnt.get(0);
				}
				if (cntrCgoCtnt.size() > 1) {
					mtyCntrObrdTeu = (String) cntrCgoCtnt.get(1);
				}
				if (cntrCgoCtnt.size() > 2) {
					ttlCntrObrdTeu = (String) cntrCgoCtnt.get(2);
				}
				if (cntrCgoCtnt.size() > 3) {
					rfCntrDchgKnt = (String) cntrCgoCtnt.get(3);
				}
				if (cntrCgoCtnt.size() > 4) {
					rfCntrLodKnt = (String) cntrCgoCtnt.get(4);
				}
				if (cntrCgoCtnt.size() > 5) {
					rfCntrObrdKnt = (String) cntrCgoCtnt.get(5);
				}
			}
		
			/** Item 누락 체크 */
			// 1. RUP_DT 누락 체크
			if (FCMGeneralUtil.isNull(rupDt) || !FCMGeneralUtil.isNumberChk(rupDt) || rupDt.length() != 12) {
				// Error Type Code 셋팅
				depRptErrTpCd = "IM"; // Item Missing
				// ERR_ITM_CTNT 셋팅
				errItmCtnt.append("RUP_DT|");
				isAllItemOK = false;
			}
			
			// 2. SB_ENG_DT 누락 체크
			if (FCMGeneralUtil.isNull(sbEngDt) || !FCMGeneralUtil.isNumberChk(sbEngDt) || sbEngDt.length() != 12) {
				// Error Type Code 셋팅
				depRptErrTpCd = "IM"; // Item Missing
				// ERR_ITM_CTNT 셋팅
				errItmCtnt.append("SB_ENG_DT|");
				isAllItemOK = false;
			}
			
			// 3. AVG_RPM_PWR 누락 체크
			// OBS Mile 이 30 이상인데, RPM 값이 없거나 숫자형이 아닌 경우에는 누락 처리
			Double nvgtMlDistDouble = new Double(FCMGeneralUtil.convertDoubleByString(nvgtMlDist));
			int resultCompare = nvgtMlDistDouble.compareTo(new Double("30"));
			if (resultCompare != -1) {
				isNvgtMlDistValid = true;
			}
			
			log.debug("\n>>>>> Is NVGT_ML_DIST more than 30? : " + isNvgtMlDistValid);
			
			if (isNvgtMlDistValid && (FCMGeneralUtil.isNull(avgRpmPwr) || !FCMGeneralUtil.isNumberChk(avgRpmPwr))) {
				// Error Type Code 셋팅
				depRptErrTpCd = "IM"; // Item Missing
				// ERR_ITM_CTNT 셋팅
				errItmCtnt.append("AVG_RPM_PWR_CTNT|");
				isAllItemOK = false;
			}
			
			// 4. AVG_SPD 누락 체크
			// OBS Mile 이 30 이상인데, SPD 값이 없거나 숫자형이 아닌 경우에는 누락 처리
			if (isNvgtMlDistValid && (FCMGeneralUtil.isNull(avgSpd) || !FCMGeneralUtil.isNumberChk(avgSpd))) {
				// Error Type Code 셋팅
				depRptErrTpCd = "IM"; // Item Missing
				// ERR_ITM_CTNT 셋팅
				errItmCtnt.append("AVG_SPD_CTNT|");
				isAllItemOK = false;
			}
			
			// 5. Rob(Arr) 누락 체크
			// Rob(Arr)의 F.O, LS F.O, D.O, LS D.O이 빈칸인 경우(Or 조건)
			if (FCMGeneralUtil.isNull(arrFoilWgt) || FCMGeneralUtil.isNull(arrDoilWgt) || FCMGeneralUtil.isNull(arrLowSulpFoilWgt) || FCMGeneralUtil.isNull(arrLowSulpDoilWgt)
					|| !FCMGeneralUtil.isNumberChk(arrFoilWgt) || !FCMGeneralUtil.isNumberChk(arrDoilWgt) || !FCMGeneralUtil.isNumberChk(arrLowSulpFoilWgt) || !FCMGeneralUtil.isNumberChk(arrLowSulpDoilWgt)) {
				// Error Type Code 셋팅
				depRptErrTpCd = "IM"; // Item Missing
				// ERR_ITM_CTNT 셋팅
				errItmCtnt.append("ARR_FOIL_CTNT|");
				errItmCtnt.append("ARR_DOIL_CTNT|");
				errItmCtnt.append("ARR_LOW_SULP_FOIL_CTNT|");
				errItmCtnt.append("ARR_LOW_SULP_DOIL_CTNT|");
				isAllItemOK = false;
			}
			
			// 6. Rob(Dep) 누락 체크
			// Rob(Dep)의 F.O, LS F.O, D.O, LS D.O이 빈칸인 경우(Or 조건)
			if (FCMGeneralUtil.isNull(depFoilWgt) || FCMGeneralUtil.isNull(depDoilWgt) || FCMGeneralUtil.isNull(depLowSulpFoilWgt) || FCMGeneralUtil.isNull(depLowSulpDoilWgt)
					|| !FCMGeneralUtil.isNumberChk(depFoilWgt) || !FCMGeneralUtil.isNumberChk(depDoilWgt) || !FCMGeneralUtil.isNumberChk(depLowSulpFoilWgt) || !FCMGeneralUtil.isNumberChk(depLowSulpDoilWgt)) {
				// Error Type Code 셋팅
				depRptErrTpCd = "IM"; // Item Missing
				// ERR_ITM_CTNT 셋팅
				errItmCtnt.append("DEP_FOIL_CTNT|");
				errItmCtnt.append("DEP_DOIL_CTNT|");
				errItmCtnt.append("DEP_LOW_SULP_FOIL_CTNT|");
				errItmCtnt.append("DEP_LOW_SULP_DOIL_CTNT|");
				isAllItemOK = false;
			}
			
			
			// 7. Sea Steaming 누락 체크
			// [Sea Steaming F.O], [Sea Steaming LS F.O], [Sea Steaming D.O], [Sea Steaming LS D.O]의 각 M/E, G/E BLR 값이 모두 빈칸인 경우 (And 조건)
			if (FCMGeneralUtil.isNull(seaMnFoilCsmQty) && FCMGeneralUtil.isNull(seaGnrFoilCsmQty) && FCMGeneralUtil.isNull(seaBlrFoilCsmQty)
					&& FCMGeneralUtil.isNull(seaMnDoilCsmQty) && FCMGeneralUtil.isNull(seaGnrDoilCsmQty) && FCMGeneralUtil.isNull(seaBlrDoilCsmQty)
					&& FCMGeneralUtil.isNull(seaMnLowSulpFoilCsmQty) && FCMGeneralUtil.isNull(seaGnrLowSulpFoilCsmQty) && FCMGeneralUtil.isNull(seaBlrLowSulpFoilCsmQty)
					&& FCMGeneralUtil.isNull(seaMnLowSulpDoilCsmQty) && FCMGeneralUtil.isNull(seaGnrLowSulpDoilCsmQty) && FCMGeneralUtil.isNull(seaBlrLowSulpDoilCsmQty)) {
				
				// Error Type Code 셋팅
				depRptErrTpCd = "IM"; // Item Missing
				// ERR_ITM_CTNT 셋팅
				errItmCtnt.append("SEA_MN_FOIL_CTNT|");
				errItmCtnt.append("SEA_GNR_FOIL_CTNT|");
				errItmCtnt.append("SEA_BLR_FOIL_CTNT|");
				errItmCtnt.append("SEA_MN_LOW_SULP_FOIL_CTNT|");
				errItmCtnt.append("SEA_GNR_LOW_SULP_FOIL_CTNT|");
				errItmCtnt.append("SEA_BLR_LOW_SULP_FOIL_CTNT|");
				errItmCtnt.append("SEA_MN_DOIL_CTNT|");
				errItmCtnt.append("SEA_GNR_DOIL_CTNT|");
				errItmCtnt.append("SEA_BLR_DOIL_CTNT|");
				errItmCtnt.append("SEA_MN_LOW_SULP_DOIL_CTNT|");
				errItmCtnt.append("SEA_GNR_LOW_SULP_DOIL_CTNT|");
				errItmCtnt.append("SEA_BLR_LOW_SULP_DOIL_CTNT|");
				isAllItemOK = false;
			}
			
			// 8. Harbor/In Port 누락 체크
			// [Harbor/In Port F.O], [Harbor/In Port LS F.O], [Harbor/In Port D.O], [Harbor/In Port LS D.O]의 각 M/E, G/E BLR 값이 모두 빈칸인 경우 (And 조건)
			if (FCMGeneralUtil.isNull(portMnFoilCsmQty) && FCMGeneralUtil.isNull(portGnrFoilCsmQty) && FCMGeneralUtil.isNull(portBlrFoilCsmQty)
					&& FCMGeneralUtil.isNull(portMnDoilCsmQty) && FCMGeneralUtil.isNull(portGnrDoilCsmQty) && FCMGeneralUtil.isNull(portBlrDoilCsmQty)
					&& FCMGeneralUtil.isNull(portMnLowSulpFoilCsmQty) && FCMGeneralUtil.isNull(portGnrLowSulpFoilCsmQty) && FCMGeneralUtil.isNull(portBlrLowSulpFoilCsmQty)
					&& FCMGeneralUtil.isNull(portMnLowSulpDoilCsmQty) && FCMGeneralUtil.isNull(portGnrLowSulpDoilCsmQty) && FCMGeneralUtil.isNull(portBlrLowSulpDoilCsmQty)) {
				
				// Error Type Code 셋팅
				depRptErrTpCd = "IM"; // Item Missing
				// ERR_ITM_CTNT 셋팅
				errItmCtnt.append("PORT_MN_FOIL_CTNT|");
				errItmCtnt.append("PORT_GNR_FOIL_CTNT|");
				errItmCtnt.append("PORT_BLR_FOIL_CTNT|");
				errItmCtnt.append("PORT_MN_LOW_SULP_FOIL_CTNT|");
				errItmCtnt.append("PORT_GNR_LOW_SULP_FOIL_CTNT|");
				errItmCtnt.append("PORT_BLR_LOW_SULP_FOIL_CTNT|");
				errItmCtnt.append("PORT_MN_DOIL_CTNT|");
				errItmCtnt.append("PORT_GNR_DOIL_CTNT|");
				errItmCtnt.append("PORT_BLR_DOIL_CTNT|");
				errItmCtnt.append("PORT_MN_LOW_SULP_DOIL_CTNT|");
				errItmCtnt.append("PORT_GNR_LOW_SULP_DOIL_CTNT|");
				errItmCtnt.append("PORT_BLR_LOW_SULP_DOIL_CTNT|");
				isAllItemOK = false;
			}
			
			/** Item 오차율 체크 */
			// Departure Report Error Rate 정보 조회
			errRt = dbDao.searchDepRptErrRt(fcmDepRptLogVO);
			
			if (errRt != null) { // Error Rate 정보가 등록이 안 된 Vessel 은 오차율 체크를 Pass 한다.
				// Departure Report Standard Data 정보 조회
				standardData = searchDepRptStandardData(fcmDepRptLogVO);
				
				// 오차율 체크 공통 변수
				BigDecimal itemVal = null; // 오차율 체크 대상 Item 값
				BigDecimal standardVal = null; // 오차율 체크 대상 Item의 Standard 값
				BigDecimal rateVal = null; // 오차율 체크 대상 Item의 Rate 값
				BigDecimal diffVal = null; // 오차율 체크 대상 Item의 Item Value - Standard Value 값
				BigDecimal diffPerVal = null; // 오차율 체크 대상 Item의 Item Value - Standard Value 값의 Percent 값
				BigDecimal perVal = new BigDecimal("100"); // Percent 값을 구하기 위한 공통 변수
				BigDecimal sailTmHrsVal = null; // Sailing Time
				
				// 1. LAST LINE 오차율 체크
				if (FCMGeneralUtil.isNotNull(vpsEtdDt) && vpsEtdDt.length() == 12 && FCMGeneralUtil.isNotNull(standardData.getVpsEtdDt()) && FCMGeneralUtil.isNotNull(errRt.getVpsEtdDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(vpsEtdDt, "yyyyMMddHHmm", standardData.getVpsEtdDt(), "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getVpsEtdDtRt());
					
					log.debug("\n>>>>> 1. VPS_ETD_DT - Standard : " + standardData.getVpsEtdDt() + ", Item : " + vpsEtdDt);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("VPS_ETD_DT|");
						isAllItemOK = false;
					}
				}
				
				// 2. S/B ENG 오차율 체크
				if (FCMGeneralUtil.isNotNull(sbEngDt) && sbEngDt.length() == 12 && FCMGeneralUtil.isNotNull(standardData.getSbEngDt()) && FCMGeneralUtil.isNotNull(errRt.getSbEngDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(sbEngDt, "yyyyMMddHHmm", standardData.getSbEngDt(), "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getSbEngDtRt());
					
					log.debug("\n>>>>> 2. SB_ENG_DT - Standard : " + standardData.getSbEngDt() + ", Item : " + sbEngDt);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("SB_ENG_DT|");
						isAllItemOK = false;
					}
				}
				
				// 3. Sailing Time 오차율 체크
				// OBS Mile 이 30 이상일 경우에만 체크
				if (isNvgtMlDistValid && FCMGeneralUtil.isNotNull(nvgtMlDist) && FCMGeneralUtil.isNumberChk(nvgtMlDist) && FCMGeneralUtil.checkZeroStr(avgSpd) && FCMGeneralUtil.checkZeroStr(standardData.getSailTmHrs()) && FCMGeneralUtil.isNotNull(errRt.getSailTmRt())) {
					BigDecimal nvgtMlDistVal = new BigDecimal(nvgtMlDist);
					BigDecimal avgSpdVal = new BigDecimal(avgSpd);
					
					itemVal = nvgtMlDistVal.divide(avgSpdVal, 1, BigDecimal.ROUND_HALF_UP);
					sailTmHrsVal = itemVal;
					standardVal = new BigDecimal(standardData.getSailTmHrs());
					rateVal = new BigDecimal(errRt.getSailTmRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 3. SAIL_TM_HRS - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("SAIL_TM_HRS|");
						isAllItemOK = false;
					}
				}

				// 4. AVG. Pro.Pitch 오차율 체크
				// OBS Mile 이 30 이상일 경우에만 체크
				if (isNvgtMlDistValid && FCMGeneralUtil.isNotNull(engMlDist) && FCMGeneralUtil.isNumberChk(engMlDist) && sailTmHrsVal != null && (sailTmHrsVal.compareTo(new BigDecimal("0")) != 0) && FCMGeneralUtil.checkZeroStr(avgRpmPwr) && FCMGeneralUtil.checkZeroStr(standardData.getAvgPrlrPchVal()) && FCMGeneralUtil.isNotNull(errRt.getPrlrPchRt())) {
					BigDecimal engMlDistVal = new BigDecimal(engMlDist);
					BigDecimal calVal = sailTmHrsVal.multiply(new BigDecimal("60")).multiply(new BigDecimal(avgRpmPwr));
					
					itemVal = engMlDistVal.divide(calVal, 7, BigDecimal.ROUND_HALF_UP);
					standardVal = new BigDecimal(standardData.getAvgPrlrPchVal());
					rateVal = new BigDecimal(errRt.getPrlrPchRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 4. AVG_PRLR_PCH_VAL - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("AVG_PRLR_PCH_VAL|");
						isAllItemOK = false;
					}
				}
				
				// 5. RPM 오차율 체크
				// OBS Mile 이 30 이상일 경우에만 체크
				if (isNvgtMlDistValid && FCMGeneralUtil.isNotNull(avgRpmPwr) && FCMGeneralUtil.isNumberChk(avgRpmPwr) && FCMGeneralUtil.checkZeroStr(standardData.getAvgRpmPwrCtnt()) && FCMGeneralUtil.isNotNull(errRt.getAvgRpmPwrRt())) {
					itemVal = new BigDecimal(avgRpmPwr);
					standardVal = new BigDecimal(standardData.getAvgRpmPwrCtnt());
					rateVal = new BigDecimal(errRt.getAvgRpmPwrRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 5. AVG_RPM_PWR_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("AVG_RPM_PWR_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 6. Miles Eng 오차율 체크
				// OBS Mile 이 30 이상일 경우에만 체크
				if (isNvgtMlDistValid && FCMGeneralUtil.isNotNull(engMlDist) && FCMGeneralUtil.isNumberChk(engMlDist) && FCMGeneralUtil.checkZeroStr(standardData.getEngMlDistCtnt()) && FCMGeneralUtil.isNotNull(errRt.getEngMlDistRt())) {
					itemVal = new BigDecimal(engMlDist);
					standardVal = new BigDecimal(standardData.getEngMlDistCtnt());
					rateVal = new BigDecimal(errRt.getEngMlDistRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 6. ENG_ML_DIST_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("ENG_ML_DIST_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 7. Miles Obs 오차율 체크
				if (FCMGeneralUtil.isNotNull(nvgtMlDist) && FCMGeneralUtil.isNumberChk(nvgtMlDist) && FCMGeneralUtil.checkZeroStr(standardData.getNvgtMlDistCtnt()) && FCMGeneralUtil.isNotNull(errRt.getNvgtMlDistRt())) {
					itemVal = new BigDecimal(nvgtMlDist);
					standardVal = new BigDecimal(standardData.getNvgtMlDistCtnt());
					rateVal = new BigDecimal(errRt.getNvgtMlDistRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 7. NVGT_ML_DIST_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("NVGT_ML_DIST_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 8. SPD 오차율 체크
				// OBS Mile 이 30 이상일 경우에만 체크
				if (isNvgtMlDistValid && FCMGeneralUtil.isNotNull(avgSpd) && FCMGeneralUtil.isNumberChk(avgSpd) && FCMGeneralUtil.checkZeroStr(standardData.getAvgSpdCtnt()) && FCMGeneralUtil.isNotNull(errRt.getAvgSpdRt())) {
					itemVal = new BigDecimal(avgSpd);
					standardVal = new BigDecimal(standardData.getAvgSpdCtnt());
					rateVal = new BigDecimal(errRt.getAvgSpdRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 8. AVG_SPD_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("AVG_SPD_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 9. Miles In 오차율 체크
				if (FCMGeneralUtil.isNotNull(mnvrInMlDist) && FCMGeneralUtil.isNumberChk(mnvrInMlDist) && FCMGeneralUtil.checkZeroStr(standardData.getMnvrInMlDistCtnt()) && FCMGeneralUtil.isNotNull(errRt.getMnvrInMlDistRt())) {
					itemVal = new BigDecimal(mnvrInMlDist);
					standardVal = new BigDecimal(standardData.getMnvrInMlDistCtnt());
					rateVal = new BigDecimal(errRt.getMnvrInMlDistRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 9. MNVR_IN_ML_DIST_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("MNVR_IN_ML_DIST_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 10. Miles Out 오차율 체크
				if (FCMGeneralUtil.isNotNull(mnvrOutMlDist) && FCMGeneralUtil.isNumberChk(mnvrOutMlDist) && FCMGeneralUtil.checkZeroStr(standardData.getMnvrOutMlDistCtnt()) && FCMGeneralUtil.isNotNull(errRt.getMnvrOutMlDistRt())) {
					itemVal = new BigDecimal(mnvrOutMlDist);
					standardVal = new BigDecimal(standardData.getMnvrOutMlDistCtnt());
					rateVal = new BigDecimal(errRt.getMnvrOutMlDistRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 10. MNVR_OUT_ML_DIST_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("MNVR_OUT_ML_DIST_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 11. Sea Steaming 오차율 체크
				// Trend Line Auto Batch 개발 완료 후 적용 예정
				log.debug("\n>>>>> 11. SEA_STMNG_MN_ENG_TTL_QTY - Pass!!!");
				
				BigDecimal portQtySum = new BigDecimal("0");
				
				if (FCMGeneralUtil.isNumberChk(portMnFoilCsmQty) && FCMGeneralUtil.isNumberChk(portGnrFoilCsmQty) && FCMGeneralUtil.isNumberChk(portBlrFoilCsmQty)
						&& FCMGeneralUtil.isNumberChk(portMnDoilCsmQty) && FCMGeneralUtil.isNumberChk(portGnrDoilCsmQty) && FCMGeneralUtil.isNumberChk(portBlrDoilCsmQty)
						&& FCMGeneralUtil.isNumberChk(portMnLowSulpFoilCsmQty) && FCMGeneralUtil.isNumberChk(portGnrLowSulpFoilCsmQty) && FCMGeneralUtil.isNumberChk(portBlrLowSulpFoilCsmQty)
						&& FCMGeneralUtil.isNumberChk(portMnLowSulpDoilCsmQty) && FCMGeneralUtil.isNumberChk(portGnrLowSulpDoilCsmQty) && FCMGeneralUtil.isNumberChk(portBlrLowSulpDoilCsmQty)) {
					
					if (FCMGeneralUtil.isNotNull(portMnFoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portMnFoilCsmQty));
					}
					if (FCMGeneralUtil.isNotNull(portGnrFoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portGnrFoilCsmQty));
					}
					if (FCMGeneralUtil.isNotNull(portBlrFoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portBlrFoilCsmQty));
					}
					if (FCMGeneralUtil.isNotNull(portMnDoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portMnDoilCsmQty));
					}
					if (FCMGeneralUtil.isNotNull(portGnrDoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portGnrDoilCsmQty));
					}
					if (FCMGeneralUtil.isNotNull(portBlrDoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portBlrDoilCsmQty));
					}
					if (FCMGeneralUtil.isNotNull(portMnLowSulpFoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portMnLowSulpFoilCsmQty));
					}
					if (FCMGeneralUtil.isNotNull(portGnrLowSulpFoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portGnrLowSulpFoilCsmQty));
					}
					if (FCMGeneralUtil.isNotNull(portBlrLowSulpFoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portBlrLowSulpFoilCsmQty));
					}
					if (FCMGeneralUtil.isNotNull(portMnLowSulpDoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portMnLowSulpDoilCsmQty));
					}
					if (FCMGeneralUtil.isNotNull(portGnrLowSulpDoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portGnrLowSulpDoilCsmQty));
					}
					if (FCMGeneralUtil.isNotNull(portBlrLowSulpDoilCsmQty)) {
						portQtySum = portQtySum.add(new BigDecimal(portBlrLowSulpDoilCsmQty));
					}
					
					// 12. Harbor/In Port 오차율 체크
					if (FCMGeneralUtil.checkZeroStr(standardData.getAvgPortTtlQty()) && FCMGeneralUtil.isNotNull(errRt.getPortTtlRt())) {
						itemVal = portQtySum;
						standardVal = new BigDecimal(standardData.getAvgPortTtlQty());
						rateVal = new BigDecimal(errRt.getPortTtlRt());
						
						diffVal = itemVal.subtract(standardVal);
						diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
						
						log.debug("\n>>>>> 12. AVG_PORT_TTL_QTY - Standard : " + standardVal + ", Item : " + itemVal);
						
						if (rateVal.compareTo(diffPerVal.abs()) != 1) {
							// Error Type Code 셋팅
							depRptErrTpCd = "IE"; // Item Error
							// ERR_ITM_CTNT 셋팅
							errItmCtnt.append("AVG_PORT_TTL_QTY|");
							isAllItemOK = false;
						}
					}
					
					// 13. AVG. HarborInport FOC/HR 오차율 체크
					if (FCMGeneralUtil.isNotNull(rupDt) && rupDt.length() == 12 && FCMGeneralUtil.isNotNull(sbEngDt) && sbEngDt.length() == 12
							&& FCMGeneralUtil.checkZeroStr(standardData.getAvgPortTtlHrQty()) && FCMGeneralUtil.isNotNull(errRt.getPortTtlHrRtRt())) {
						
						long diffMin = FCMGeneralUtil.dateDiff(sbEngDt, "yyyyMMddHHmm", rupDt, "yyyyMMddHHmm", "m");
						BigDecimal diffHour = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
						
						if ((new BigDecimal("0").compareTo(diffHour)) != 0) {
							itemVal = portQtySum.divide(diffHour, 10, BigDecimal.ROUND_HALF_UP);
							standardVal = new BigDecimal(standardData.getAvgPortTtlHrQty());
							rateVal = new BigDecimal(errRt.getPortTtlHrRtRt());
							
							diffVal = itemVal.subtract(standardVal);
							diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
							
							log.debug("\n>>>>> 13. AVG_PORT_TTL_HR_QTY - Standard : " + standardVal + ", Item : " + itemVal);
							
							if (rateVal.compareTo(diffPerVal.abs()) != 1) {
								// Error Type Code 셋팅
								depRptErrTpCd = "IE"; // Item Error
								// ERR_ITM_CTNT 셋팅
								errItmCtnt.append("AVG_PORT_TTL_HR_QTY|");
								isAllItemOK = false;
							}
						}
					}
				}
				
				// 14. Rob(Arr) - F.O 오차율 체크
				if (FCMGeneralUtil.isNotNull(arrFoilWgt) && FCMGeneralUtil.isNumberChk(arrFoilWgt) && FCMGeneralUtil.isNotNull(standardData.getArrFoilCtnt())  && FCMGeneralUtil.isNotNull(errRt.getArrFoilRt())) {
					itemVal = new BigDecimal(arrFoilWgt);
					standardVal = new BigDecimal(standardData.getArrFoilCtnt());
					rateVal = new BigDecimal(errRt.getArrFoilRt());
					
					diffVal = itemVal.subtract(standardVal);
					
					log.debug("\n>>>>> 14. ARR_FOIL_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("ARR_FOIL_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 15. Rob(Arr) - LS F.O 오차율 체크
				if (FCMGeneralUtil.isNotNull(arrLowSulpFoilWgt) && FCMGeneralUtil.isNumberChk(arrLowSulpFoilWgt) && FCMGeneralUtil.isNotNull(standardData.getArrLowSulpFoilCtnt())  && FCMGeneralUtil.isNotNull(errRt.getArrLowSulpFoilRt())) {
					itemVal = new BigDecimal(arrLowSulpFoilWgt);
					standardVal = new BigDecimal(standardData.getArrLowSulpFoilCtnt());
					rateVal = new BigDecimal(errRt.getArrLowSulpFoilRt());
					
					diffVal = itemVal.subtract(standardVal);
					
					log.debug("\n>>>>> 15. ARR_LOW_SULP_FOIL_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("ARR_LOW_SULP_FOIL_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 16. Rob(Arr) - D.O 오차율 체크
				if (FCMGeneralUtil.isNotNull(arrDoilWgt) && FCMGeneralUtil.isNumberChk(arrDoilWgt) && FCMGeneralUtil.isNotNull(standardData.getArrDoilCtnt())  && FCMGeneralUtil.isNotNull(errRt.getArrDoilRt())) {
					itemVal = new BigDecimal(arrDoilWgt);
					standardVal = new BigDecimal(standardData.getArrDoilCtnt());
					rateVal = new BigDecimal(errRt.getArrDoilRt());
					
					diffVal = itemVal.subtract(standardVal);
					
					log.debug("\n>>>>> 16. ARR_DOIL_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("ARR_DOIL_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 17. Rob(Arr) - LS D.O 오차율 체크
				if (FCMGeneralUtil.isNotNull(arrLowSulpDoilWgt) && FCMGeneralUtil.isNumberChk(arrLowSulpDoilWgt) && FCMGeneralUtil.isNotNull(standardData.getArrLowSulpDoilCtnt())  && FCMGeneralUtil.isNotNull(errRt.getArrLowSulpDoilRt())) {
					itemVal = new BigDecimal(arrLowSulpDoilWgt);
					standardVal = new BigDecimal(standardData.getArrLowSulpDoilCtnt());
					rateVal = new BigDecimal(errRt.getArrLowSulpDoilRt());
					
					diffVal = itemVal.subtract(standardVal);
					
					log.debug("\n>>>>> 17. ARR_LOW_SULP_DOIL_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("ARR_LOW_SULP_DOIL_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 18. Rob(Dep) - F.O 오차율 체크
				if (FCMGeneralUtil.isNotNull(depFoilWgt) && FCMGeneralUtil.isNumberChk(depFoilWgt) && FCMGeneralUtil.isNotNull(standardData.getDepFoilCtnt())  && FCMGeneralUtil.isNotNull(errRt.getDepFoilRt())) {
					itemVal = new BigDecimal(depFoilWgt);
					standardVal = new BigDecimal(standardData.getDepFoilCtnt());
					rateVal = new BigDecimal(errRt.getDepFoilRt());
					
					diffVal = itemVal.subtract(standardVal);
					
					log.debug("\n>>>>> 18. DEP_FOIL_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("DEP_FOIL_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 19. Rob(Dep) - LS F.O 오차율 체크
				if (FCMGeneralUtil.isNotNull(depLowSulpFoilWgt) && FCMGeneralUtil.isNumberChk(depLowSulpFoilWgt) && FCMGeneralUtil.isNotNull(standardData.getDepLowSulpFoilCtnt())  && FCMGeneralUtil.isNotNull(errRt.getDepLowSulpFoilRt())) {
					itemVal = new BigDecimal(depLowSulpFoilWgt);
					standardVal = new BigDecimal(standardData.getDepLowSulpFoilCtnt());
					rateVal = new BigDecimal(errRt.getDepLowSulpFoilRt());
					
					diffVal = itemVal.subtract(standardVal);
					
					log.debug("\n>>>>> 19. DEP_LOW_SULP_FOIL_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("DEP_LOW_SULP_FOIL_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 20. Rob(Dep) - D.O 오차율 체크
				if (FCMGeneralUtil.isNotNull(depDoilWgt) && FCMGeneralUtil.isNumberChk(depDoilWgt) && FCMGeneralUtil.isNotNull(standardData.getDepDoilCtnt())  && FCMGeneralUtil.isNotNull(errRt.getDepDoilRt())) {
					itemVal = new BigDecimal(depDoilWgt);
					standardVal = new BigDecimal(standardData.getDepDoilCtnt());
					rateVal = new BigDecimal(errRt.getDepDoilRt());
					
					diffVal = itemVal.subtract(standardVal);
					
					log.debug("\n>>>>> 20. DEP_DOIL_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("DEP_DOIL_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 21. Rob(Dep) - LS D.O 오차율 체크
				if (FCMGeneralUtil.isNotNull(depLowSulpDoilWgt) && FCMGeneralUtil.isNumberChk(depLowSulpDoilWgt) && FCMGeneralUtil.isNotNull(standardData.getDepLowSulpDoilCtnt())  && FCMGeneralUtil.isNotNull(errRt.getDepLowSulpDoilRt())) {
					itemVal = new BigDecimal(depLowSulpDoilWgt);
					standardVal = new BigDecimal(standardData.getDepLowSulpDoilCtnt());
					rateVal = new BigDecimal(errRt.getDepLowSulpDoilRt());
					
					diffVal = itemVal.subtract(standardVal);
					
					log.debug("\n>>>>> 21. DEP_LOW_SULP_DOIL_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("DEP_LOW_SULP_DOIL_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 22. P.O.B 오차율 체크
				if (FCMGeneralUtil.isNotNull(pltInDt) && pltInDt.length() == 12 && FCMGeneralUtil.isNotNull(sbEngDt) && sbEngDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getPltInDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(sbEngDt, "yyyyMMddHHmm", pltInDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getPltInDtRt());
					
					log.debug("\n>>>>> 22. PLT_IN_DT - pltInDt : " + pltInDt + ", sbEngDt : " + sbEngDt);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("PLT_IN_DT|");
						isAllItemOK = false;
					}
				}
				
				// 23. ANCHOR 오차율 체크
				if (FCMGeneralUtil.isNotNull(bfrBrthAnkDrpDt) && bfrBrthAnkDrpDt.length() == 12 && FCMGeneralUtil.isNotNull(sbEngDt) && sbEngDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getBfrBrthAnkDrpDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(sbEngDt, "yyyyMMddHHmm", bfrBrthAnkDrpDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getBfrBrthAnkDrpDtRt());
					
					log.debug("\n>>>>> 23. BFR_BRTH_ANK_DRP_DT - bfrBrthAnkDrpDt : " + bfrBrthAnkDrpDt + ", sbEngDt : " + sbEngDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("BFR_BRTH_ANK_DRP_DT|");
						isAllItemOK = false;
					}
				}
				
				// 24. ANCHOR AWAY 오차율 체크
				if (FCMGeneralUtil.isNotNull(bfrBrthAnkOffDt) && bfrBrthAnkOffDt.length() == 12 && FCMGeneralUtil.isNotNull(bfrBrthAnkDrpDt) && bfrBrthAnkDrpDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getBfrBrthAnkOffDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(bfrBrthAnkDrpDt, "yyyyMMddHHmm", bfrBrthAnkOffDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getBfrBrthAnkOffDtRt());
					
					log.debug("\n>>>>> 24. BFR_BRTH_ANK_OFF_DT - bfrBrthAnkOffDt : " + bfrBrthAnkOffDt + ", bfrBrthAnkDrpDt : " + bfrBrthAnkDrpDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("BFR_BRTH_ANK_OFF_DT|");
						isAllItemOK = false;
					}
				}
				
				// 25. FIRST LINE 오차율 체크
				if (FCMGeneralUtil.isNotNull(vpsEtbDt) && vpsEtbDt.length() == 12 && FCMGeneralUtil.isNotNull(standardData.getVpsEtbDt()) && FCMGeneralUtil.isNotNull(errRt.getVpsEtbDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(vpsEtbDt, "yyyyMMddHHmm", standardData.getVpsEtbDt(), "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getVpsEtbDtRt());
					
					log.debug("\n>>>>> 25. VPS_ETB_DT - Standard : " + standardData.getVpsEtbDt() + ", Item : " + vpsEtbDt);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("VPS_ETB_DT|");
						isAllItemOK = false;
					}
				}
				
				// 26. COMM'CED WKG 오차율 체크
				if (FCMGeneralUtil.isNotNull(cgoWrkStDt) && cgoWrkStDt.length() == 12 && FCMGeneralUtil.isNotNull(vpsEtbDt) && vpsEtbDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getCgoWrkStDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(vpsEtbDt, "yyyyMMddHHmm", cgoWrkStDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getCgoWrkStDtRt());
					
					log.debug("\n>>>>> 26. CGO_WRK_ST_DT - cgoWrkStDt : " + cgoWrkStDt + ", vpsEtbDt : " + vpsEtbDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("CGO_WRK_ST_DT|");
						isAllItemOK = false;
					}
				} else if (FCMGeneralUtil.isNotNull(cgoWrkStDt) && cgoWrkStDt.length() == 12 && FCMGeneralUtil.isNotNull(sbEngDt) && sbEngDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getCgoWrkStDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(sbEngDt, "yyyyMMddHHmm", cgoWrkStDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getCgoWrkStDtRt());
					
					log.debug("\n>>>>> 26. CGO_WRK_ST_DT - cgoWrkStDt : " + cgoWrkStDt + ", sbEngDt : " + sbEngDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("CGO_WRK_ST_DT|");
						isAllItemOK = false;
					}
				}
				
				// 27. COMP'TED WKG 오차율 체크
				if (FCMGeneralUtil.isNotNull(cgoWrkEndDt) && cgoWrkEndDt.length() == 12 && FCMGeneralUtil.isNotNull(cgoWrkStDt) && cgoWrkStDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getCgoWrkEndDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(cgoWrkStDt, "yyyyMMddHHmm", cgoWrkEndDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getCgoWrkEndDtRt());
					
					log.debug("\n>>>>> 27. CGO_WRK_END_DT - cgoWrkEndDt : " + cgoWrkEndDt + ", cgoWrkStDt : " + cgoWrkStDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("CGO_WRK_END_DT|");
						isAllItemOK = false;
					}
				}
				
				// 28. DROP ANCHOR 오차율 체크
				if (FCMGeneralUtil.isNotNull(aftUnbrthAnkDrpDt) && aftUnbrthAnkDrpDt.length() == 12 && FCMGeneralUtil.isNotNull(vpsEtdDt) && vpsEtdDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getAftUnbrthAnkDrpDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(vpsEtdDt, "yyyyMMddHHmm", aftUnbrthAnkDrpDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getAftUnbrthAnkDrpDtRt());
					
					log.debug("\n>>>>> 28. AFT_UNBRTH_ANK_DRP_DT - aftUnbrthAnkDrpDt : " + aftUnbrthAnkDrpDt + ", vpsEtdDt : " + vpsEtdDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("AFT_UNBRTH_ANK_DRP_DT|");
						isAllItemOK = false;
					}
				} else if (FCMGeneralUtil.isNotNull(aftUnbrthAnkDrpDt) && aftUnbrthAnkDrpDt.length() == 12 && FCMGeneralUtil.isNotNull(sbEngDt) && sbEngDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getAftUnbrthAnkDrpDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(sbEngDt, "yyyyMMddHHmm", aftUnbrthAnkDrpDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getAftUnbrthAnkDrpDtRt());
					
					log.debug("\n>>>>> 28. AFT_UNBRTH_ANK_DRP_DT - aftUnbrthAnkDrpDt : " + aftUnbrthAnkDrpDt + ", sbEngDt : " + sbEngDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("AFT_UNBRTH_ANK_DRP_DT|");
						isAllItemOK = false;
					}
				}
				
				// 29. ANCHOR AWAY 오차율 체크
				if (FCMGeneralUtil.isNotNull(aftUnbrthAnkOffDt) && aftUnbrthAnkOffDt.length() == 12 && FCMGeneralUtil.isNotNull(aftUnbrthAnkDrpDt) && aftUnbrthAnkDrpDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getAftUnbrthAnkOffDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(aftUnbrthAnkDrpDt, "yyyyMMddHHmm", aftUnbrthAnkOffDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getAftUnbrthAnkOffDtRt());
					
					log.debug("\n>>>>> 29. AFT_UNBRTH_ANK_OFF_DT - aftUnbrthAnkOffDt : " + aftUnbrthAnkOffDt + ", aftUnbrthAnkDrpDt : " + aftUnbrthAnkDrpDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("AFT_UNBRTH_ANK_OFF_DT|");
						isAllItemOK = false;
					}
				} else if (FCMGeneralUtil.isNotNull(aftUnbrthAnkOffDt) && aftUnbrthAnkOffDt.length() == 12 && FCMGeneralUtil.isNotNull(sbEngDt) && sbEngDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getAftUnbrthAnkOffDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(sbEngDt, "yyyyMMddHHmm", aftUnbrthAnkOffDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getAftUnbrthAnkOffDtRt());
					
					log.debug("\n>>>>> 29. AFT_UNBRTH_ANK_OFF_DT - aftUnbrthAnkOffDt : " + aftUnbrthAnkOffDt + ", sbEngDt : " + sbEngDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("AFT_UNBRTH_ANK_OFF_DT|");
						isAllItemOK = false;
					}
				}
				
				// 30. PILOT AWAY 오차율 체크
				if (FCMGeneralUtil.isNotNull(pltOutDt) && pltOutDt.length() == 12 && FCMGeneralUtil.isNotNull(vpsEtdDt) && vpsEtdDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getPltOutDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(vpsEtdDt, "yyyyMMddHHmm", pltOutDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getPltOutDtRt());
					
					log.debug("\n>>>>> 30. PLT_OUT_DT - pltOutDt : " + pltOutDt + ", vpsEtdDt : " + vpsEtdDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) == -1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("PLT_OUT_DT|");
						isAllItemOK = false;
					}
				} else if (FCMGeneralUtil.isNotNull(pltOutDt) && pltOutDt.length() == 12 && FCMGeneralUtil.isNotNull(sbEngDt) && sbEngDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getPltOutDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(sbEngDt, "yyyyMMddHHmm", pltOutDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getPltOutDtRt());
					
					log.debug("\n>>>>> 30. PLT_OUT_DT - pltOutDt : " + pltOutDt + ", sbEngDt : " + sbEngDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) == -1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("PLT_OUT_DT|");
						isAllItemOK = false;
					}
				}
				
				// 31. R/UP ENG 오차율 체크
				if (FCMGeneralUtil.isNotNull(rupDt) && rupDt.length() == 12 && FCMGeneralUtil.isNotNull(pltOutDt) && pltOutDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getRupDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(pltOutDt, "yyyyMMddHHmm", rupDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getRupDtRt());
					
					log.debug("\n>>>>> 31. RUP_DT - rupDt : " + rupDt + ", pltOutDt : " + pltOutDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) == -1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("RUP_DT|");
						isAllItemOK = false;
					}
				} else if (FCMGeneralUtil.isNotNull(rupDt) && rupDt.length() == 12 && FCMGeneralUtil.isNotNull(vpsEtdDt) && vpsEtdDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getRupDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(vpsEtdDt, "yyyyMMddHHmm", rupDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getRupDtRt());
					
					log.debug("\n>>>>> 31. RUP_DT - rupDt : " + rupDt + ", vpsEtdDt : " + vpsEtdDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) == -1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("RUP_DT|");
						isAllItemOK = false;
					}
				} else if (FCMGeneralUtil.isNotNull(rupDt) && rupDt.length() == 12 && FCMGeneralUtil.isNotNull(sbEngDt) && sbEngDt.length() == 12 && FCMGeneralUtil.isNotNull(errRt.getRupDtRt())) {
					long diffMin = FCMGeneralUtil.dateDiff(sbEngDt, "yyyyMMddHHmm", rupDt, "yyyyMMddHHmm", "m");
					
					diffVal = new BigDecimal(diffMin).divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
					rateVal = new BigDecimal(errRt.getRupDtRt());
					
					log.debug("\n>>>>> 31. RUP_DT - rupDt : " + rupDt + ", sbEngDt : " + sbEngDt);
					
					if (rateVal.compareTo(diffVal) != 1 || diffVal.compareTo(new BigDecimal("0")) == -1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("RUP_DT|");
						isAllItemOK = false;
					}
				}
				
				// 32. R/F CNTR - Disch. 오차율 체크
				if (FCMGeneralUtil.isNumberChk(rfCntrDchgKnt) && FCMGeneralUtil.isNotNull(standardData.getRfCntrDchgKntCtnt()) && FCMGeneralUtil.isNotNull(errRt.getRfCntrDchgKntRt())) {
					if (FCMGeneralUtil.isNull(rfCntrDchgKnt)) {
						itemVal = new BigDecimal("0");
					} else {
						itemVal = new BigDecimal(rfCntrDchgKnt);
					}
					standardVal = new BigDecimal(standardData.getRfCntrDchgKntCtnt());
					rateVal = new BigDecimal(errRt.getRfCntrDchgKntRt());
					
					log.debug("\n>>>>> 32. RF_CNTR_DCHG_KNT_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					diffVal = itemVal.subtract(standardVal);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("RF_CNTR_DCHG_KNT_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 33. R/F CNTR - Load 오차율 체크
				if (FCMGeneralUtil.isNumberChk(rfCntrLodKnt) && FCMGeneralUtil.isNotNull(standardData.getRfCntrLodKntCtnt()) && FCMGeneralUtil.isNotNull(errRt.getRfCntrLodKntRt())) {
					if (FCMGeneralUtil.isNull(rfCntrLodKnt)) {
						itemVal = new BigDecimal("0");
					} else {
						itemVal = new BigDecimal(rfCntrLodKnt);
					}
					standardVal = new BigDecimal(standardData.getRfCntrLodKntCtnt());
					rateVal = new BigDecimal(errRt.getRfCntrLodKntRt());
					
					diffVal = itemVal.subtract(standardVal);
					
					log.debug("\n>>>>> 33. RF_CNTR_LOD_KNT_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("RF_CNTR_LOD_KNT_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 34. R/F CNTR - On Board 오차율 체크
				if (FCMGeneralUtil.isNumberChk(rfCntrObrdKnt) && FCMGeneralUtil.isNotNull(standardData.getRfCntrObrdKntCtnt()) && FCMGeneralUtil.isNotNull(errRt.getRfCntrObrdKntRt())) {
					if (FCMGeneralUtil.isNull(rfCntrObrdKnt)) {
						itemVal = new BigDecimal("0");
					} else {
						itemVal = new BigDecimal(rfCntrObrdKnt);
					}
					standardVal = new BigDecimal(standardData.getRfCntrObrdKntCtnt());
					rateVal = new BigDecimal(errRt.getRfCntrObrdKntRt());
					
					diffVal = itemVal.subtract(standardVal);
					
					log.debug("\n>>>>> 34. RF_CNTR_OBRD_KNT_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("RF_CNTR_OBRD_KNT_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 35. On Board CNTR - Full 오차율 체크
				if (FCMGeneralUtil.isNumberChk(fullCntrObrdTeu) && FCMGeneralUtil.isNotNull(standardData.getFcntrObrdTeuCtnt()) && FCMGeneralUtil.isNotNull(errRt.getFcntrObrdTeuRt())) {
					if (FCMGeneralUtil.isNull(fullCntrObrdTeu)) {
						itemVal = new BigDecimal("0");
					} else {
						itemVal = new BigDecimal(fullCntrObrdTeu);
					}
					standardVal = new BigDecimal(standardData.getFcntrObrdTeuCtnt());
					rateVal = new BigDecimal(errRt.getFcntrObrdTeuRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 35. FCNTR_OBRD_TEU_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("FCNTR_OBRD_TEU_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 36. On Board CNTR - Em'ty 오차율 체크
				if (FCMGeneralUtil.isNumberChk(mtyCntrObrdTeu) && FCMGeneralUtil.isNotNull(standardData.getMcntrObrdTeuCtnt()) && FCMGeneralUtil.isNotNull(errRt.getMcntrObrdTeuRt())) {
					if (FCMGeneralUtil.isNull(mtyCntrObrdTeu)) {
						itemVal = new BigDecimal("0");
					} else {
						itemVal = new BigDecimal(mtyCntrObrdTeu);
					}
					standardVal = new BigDecimal(standardData.getMcntrObrdTeuCtnt());
					rateVal = new BigDecimal(errRt.getMcntrObrdTeuRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 36. MCNTR_OBRD_TEU_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("MCNTR_OBRD_TEU_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 37. On Board CNTR - Total 오차율 체크
				if (FCMGeneralUtil.isNumberChk(ttlCntrObrdTeu) && FCMGeneralUtil.isNotNull(standardData.getTtlCntrObrdTeuCtnt()) && FCMGeneralUtil.isNotNull(errRt.getTtlCntrObrdTeuRt())) {
					if (FCMGeneralUtil.isNull(ttlCntrObrdTeu)) {
						itemVal = new BigDecimal("0");
					} else {
						itemVal = new BigDecimal(ttlCntrObrdTeu);
					}
					standardVal = new BigDecimal(standardData.getTtlCntrObrdTeuCtnt());
					rateVal = new BigDecimal(errRt.getTtlCntrObrdTeuRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 37. TTL_CNTR_OBRD_TEU_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("TTL_CNTR_OBRD_TEU_CTNT|");
						isAllItemOK = false;
					}
				}
				
				// 38. On Board CNTR - Cargo Weight 오차율 체크
				if (FCMGeneralUtil.isNumberChk(depCgoWgt) && FCMGeneralUtil.isNotNull(standardData.getDepCgoCtnt()) && FCMGeneralUtil.isNotNull(errRt.getDepCgoRt())) {
					if (FCMGeneralUtil.isNull(depCgoWgt)) {
						itemVal = new BigDecimal("0");
					} else {
						itemVal = new BigDecimal(depCgoWgt);
					}
					standardVal = new BigDecimal(standardData.getDepCgoCtnt());
					rateVal = new BigDecimal(errRt.getDepCgoRt());
					
					diffVal = itemVal.subtract(standardVal);
					diffPerVal = diffVal.divide(standardVal, 10, BigDecimal.ROUND_HALF_UP).multiply(perVal);
					
					log.debug("\n>>>>> 38. DEP_CGO_CTNT - Standard : " + standardVal + ", Item : " + itemVal);
					
					if (rateVal.compareTo(diffPerVal.abs()) != 1) {
						// Error Type Code 셋팅
						depRptErrTpCd = "IE"; // Item Error
						// ERR_ITM_CTNT 셋팅
						errItmCtnt.append("DEP_CGO_CTNT|");
						isAllItemOK = false;
					}
				}
				
			}
			
			if (isAllItemOK) {
				/** Call Ind Seq 자동 보정된 경우에는 Log 테이블에 Remark를 남긴다. */
				if (isCallIndSeqRevised) {
					eaiIfRmk = "At FCM_DEP_RPT table CLPT_IND_SEQ was auto revised. AS-IS : " + originCallIndSeq + ", TO-BE : " + fcmDepRptLogVO.getClptIndSeq();
				}
				
				/** 모든 Validation Check 결과 이상이 없는 경우 FCM_DEP_RPT 테이블에 적용 */
				dbDao.addDepRpt(fcmDepRptLogVO);
			} else {
				// Call Ind Seq 보정된 경우에는 원복하고 PK Mismatched 처리
				if (isCallIndSeqRevised) {
					fcmDepRptLogVO.setClptIndSeq(originCallIndSeq);
					// Error Type Code 셋팅
					depRptErrTpCd = "PM"; // PK Mismatched
				}
				
				errAddParam.put("dep_rpt_err_tp_cd", depRptErrTpCd);
				errAddParam.put("err_itm_ctnt", errItmCtnt.toString());
				// FCM_DEP_RPT_ERR 테이블 Insert
				dbDao.addDepRptErr(fcmDepRptLogVO, errAddParam);
			}
			
			log.debug("\n<<<<<<<<<< Departure Report Item Validation Check End >>>>>>>>>>>>>>>>");
			
		} catch (DAOException e) {
			eaiIfRmk = e.toString();
			ifFlg = "N";
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		} catch (Exception e) {
			eaiIfRmk = e.toString();
			ifFlg = "N";
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		} finally {
			fcmDepRptLogVO.setIfFlg(ifFlg);
			fcmDepRptLogVO.setEaiIfRmk(eaiIfRmk);
		}
	}
	
	/**
	 * Departure Report Item Standard Data 조회<br>
	 * Item Error Cleansing Pop-up 화면에서 Error Data Cleansing 시 호출한다.<br>
	 * 
	 * @param fcmDepRptErrClsVO
	 * @return FcmDepRptErrClsVO
	 * @throws EventException
	 */
	public FcmDepRptErrClsVO searchDepRptStandardData(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException {
		FcmDepRptErrClsVO resultVO = null;
		StringBuffer seaFuelCsmCtnt = new StringBuffer();
		StringBuffer seaLowSulpFuelCsmCtnt = new StringBuffer();
		StringBuffer arrRobCtnt = new StringBuffer();
		StringBuffer portFuelCsmCtnt = new StringBuffer();
		StringBuffer portLowSulpFuelCsmCtnt = new StringBuffer();
		StringBuffer splOilCtnt = new StringBuffer();
		StringBuffer splLowSulpOilCtnt = new StringBuffer();
		StringBuffer cntrCgoCtnt = new StringBuffer();
		
		try {
			// Departure Report Log 테이블에서 기본 정보 조회
			FcmDepRptErrVO fcmDepRptErrVO = new FcmDepRptErrVO();
			fcmDepRptErrVO.setRcvDt(fcmDepRptErrClsVO.getRcvDt());
			fcmDepRptErrVO.setRcvSeq(fcmDepRptErrClsVO.getRcvSeq());
			FcmDepRptLogVO fcmDepRptLogVO = dbDao.searchDepRptLog(fcmDepRptErrVO);
			
			// 화면에서 변경 된 값으로 Item 값 셋팅
			fcmDepRptLogVO.setSbEngDt(fcmDepRptErrClsVO.getSbEngDt());
			fcmDepRptLogVO.setEngMlDist(fcmDepRptErrClsVO.getEngMlDistCtnt());
			fcmDepRptLogVO.setNvgtMlDist(fcmDepRptErrClsVO.getNvgtMlDistCtnt());
			fcmDepRptLogVO.setAvgSpd(fcmDepRptErrClsVO.getAvgSpdCtnt());
			fcmDepRptLogVO.setAvgRpmPwr(fcmDepRptErrClsVO.getAvgRpmPwrCtnt());
			fcmDepRptLogVO.setRupDt(fcmDepRptErrClsVO.getRupDt());
			
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaMnFoilCtnt()).append("|");
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaGnrFoilCtnt()).append("|");
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaBlrFoilCtnt()).append("|");
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaMnDoilCtnt()).append("|");
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaGnrDoilCtnt()).append("|");
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaBlrDoilCtnt()).append("|");
			fcmDepRptLogVO.setSeaFuelCsmCtnt(seaFuelCsmCtnt.toString());
			
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaMnLowSulpFoilCtnt()).append("|");
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaGnrLowSulpFoilCtnt()).append("|");
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaBlrLowSulpFoilCtnt()).append("|");
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaMnLowSulpDoilCtnt()).append("|");
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaGnrLowSulpDoilCtnt()).append("|");
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaBlrLowSulpDoilCtnt()).append("|");
			fcmDepRptLogVO.setSeaLowSulpFuelCsmCtnt(seaLowSulpFuelCsmCtnt.toString());
			
			arrRobCtnt.append(fcmDepRptErrClsVO.getArrFoilCtnt()).append("|");
			arrRobCtnt.append(fcmDepRptErrClsVO.getArrDoilCtnt()).append("|");
			arrRobCtnt.append("").append("|");
			arrRobCtnt.append("").append("|");
			arrRobCtnt.append(fcmDepRptErrClsVO.getArrLowSulpFoilCtnt()).append("|");
			arrRobCtnt.append(fcmDepRptErrClsVO.getArrLowSulpDoilCtnt()).append("|");
			fcmDepRptLogVO.setArrRobCtnt(arrRobCtnt.toString());
			
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortMnFoilCtnt()).append("|");
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortGnrFoilCtnt()).append("|");
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortBlrFoilCtnt()).append("|");
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortMnDoilCtnt()).append("|");
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortGnrDoilCtnt()).append("|");
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortBlrDoilCtnt()).append("|");
			fcmDepRptLogVO.setPortFuelCsmCtnt(portFuelCsmCtnt.toString());
			
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortMnLowSulpFoilCtnt()).append("|");
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortGnrLowSulpFoilCtnt()).append("|");
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortBlrLowSulpFoilCtnt()).append("|");
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortMnLowSulpDoilCtnt()).append("|");
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortGnrLowSulpDoilCtnt()).append("|");
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortBlrLowSulpDoilCtnt()).append("|");
			fcmDepRptLogVO.setPortLowSulpFuelCsmCtnt(portLowSulpFuelCsmCtnt.toString());
			
			splOilCtnt.append(fcmDepRptErrClsVO.getSplFoilBdrCtnt()).append("|");
			splOilCtnt.append(fcmDepRptErrClsVO.getSplFoilActCtnt()).append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append(fcmDepRptErrClsVO.getSplDoilBdrCtnt()).append("|");
			splOilCtnt.append(fcmDepRptErrClsVO.getSplDoilActCtnt()).append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append("").append("|");
			fcmDepRptLogVO.setSplOilCtnt(splOilCtnt.toString());
			
			splLowSulpOilCtnt.append(fcmDepRptErrClsVO.getSplLowSulpFoilBdrCtnt()).append("|");
			splLowSulpOilCtnt.append(fcmDepRptErrClsVO.getSplLowSulpFoilActCtnt()).append("|");
			splLowSulpOilCtnt.append("").append("|");
			splLowSulpOilCtnt.append("").append("|");
			splLowSulpOilCtnt.append("").append("|");
			splLowSulpOilCtnt.append(fcmDepRptErrClsVO.getSplLowSulpDoilBdrCtnt()).append("|");
			splLowSulpOilCtnt.append(fcmDepRptErrClsVO.getSplLowSulpDoilActCtnt()).append("|");
			splLowSulpOilCtnt.append("").append("|");
			splLowSulpOilCtnt.append("").append("|");
			splLowSulpOilCtnt.append("").append("|");
			fcmDepRptLogVO.setSplLowSulpOilCtnt(splLowSulpOilCtnt.toString());
			
			cntrCgoCtnt.append("").append("|");
			cntrCgoCtnt.append("").append("|");
			cntrCgoCtnt.append("").append("|");
			cntrCgoCtnt.append(fcmDepRptErrClsVO.getRfCntrDchgKntCtnt()).append("|");
			cntrCgoCtnt.append(fcmDepRptErrClsVO.getRfCntrLodKntCtnt()).append("|");
			cntrCgoCtnt.append(fcmDepRptErrClsVO.getRfCntrObrdKntCtnt()).append("|");
			fcmDepRptLogVO.setCntrCgoCtnt(cntrCgoCtnt.toString());
			
			// Departure Report Item Standard Data 조회
			resultVO = searchDepRptStandardData(fcmDepRptLogVO);
			
			// 각 항목 소수점 뒷자리수 셋팅
			resultVO.setAvgSpdCtnt(FCMGeneralUtil.convertScale(resultVO.getAvgSpdCtnt(), 1));
			resultVO.setAvgRpmPwrCtnt(FCMGeneralUtil.convertScale(resultVO.getAvgRpmPwrCtnt(), 1));
			resultVO.setAvgPrlrPchVal(FCMGeneralUtil.convertScale(resultVO.getAvgPrlrPchVal(), 7));
			resultVO.setSailTmHrs(FCMGeneralUtil.convertScale(resultVO.getSailTmHrs(), 1));
			resultVO.setArrFoilCtnt(FCMGeneralUtil.convertScale(resultVO.getArrFoilCtnt(), 1));
			resultVO.setArrLowSulpFoilCtnt(FCMGeneralUtil.convertScale(resultVO.getArrLowSulpFoilCtnt(), 1));
			resultVO.setArrDoilCtnt(FCMGeneralUtil.convertScale(resultVO.getArrDoilCtnt(), 1));
			resultVO.setArrLowSulpDoilCtnt(FCMGeneralUtil.convertScale(resultVO.getArrLowSulpDoilCtnt(), 1));
			resultVO.setDepFoilCtnt(FCMGeneralUtil.convertScale(resultVO.getDepFoilCtnt(), 1));
			resultVO.setDepLowSulpFoilCtnt(FCMGeneralUtil.convertScale(resultVO.getDepLowSulpFoilCtnt(), 1));
			resultVO.setDepDoilCtnt(FCMGeneralUtil.convertScale(resultVO.getDepDoilCtnt(), 1));
			resultVO.setDepLowSulpDoilCtnt(FCMGeneralUtil.convertScale(resultVO.getDepLowSulpDoilCtnt(), 1));
			resultVO.setSeaStmngMnEngTtlQty(FCMGeneralUtil.convertScale(resultVO.getSeaStmngMnEngTtlQty(), 1));
			resultVO.setAvgPortTtlQty(FCMGeneralUtil.convertScale(resultVO.getAvgPortTtlQty(), 1));
			resultVO.setAvgPortTtlHrQty(FCMGeneralUtil.convertScale(resultVO.getAvgPortTtlHrQty(), 10));
			
		} catch (DAOException ex) {
			// COM12203 : Failed to retrieve ($s). Please try again.
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report Standard Data" }).getMessage(), ex);
		} catch (Exception ex) {
			// COM12203 : Failed to retrieve ($s). Please try again.
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report Standard Data" }).getMessage(), ex);
		}
		
		return resultVO;
	}
	
	/**
	 * Departure Report Item Standard Data 조회<br>
	 * Item Error Cleansing Pop-up 화면에서 본테이블 데이터 수정 시 호출한다.<br>
	 * 
	 * @param fcmDepRptVO
	 * @return FcmDepRptErrClsVO
	 * @throws EventException
	 */
	public FcmDepRptErrClsVO searchDepRptStandardData(FcmDepRptVO fcmDepRptVO) throws EventException {
		FcmDepRptLogVO fcmDepRptLogVO = new FcmDepRptLogVO();
		StringBuffer seaFuelCsmCtnt = new StringBuffer();
		StringBuffer seaLowSulpFuelCsmCtnt = new StringBuffer();
		StringBuffer arrRobCtnt = new StringBuffer();
		StringBuffer portFuelCsmCtnt = new StringBuffer();
		StringBuffer portLowSulpFuelCsmCtnt = new StringBuffer();
		StringBuffer splOilCtnt = new StringBuffer();
		StringBuffer splLowSulpOilCtnt = new StringBuffer();
		StringBuffer cntrCgoCtnt = new StringBuffer();
		FcmDepRptErrClsVO resultVO = null;
		
		try {
			fcmDepRptLogVO.setVslCd(fcmDepRptVO.getVslCd());
			fcmDepRptLogVO.setVoyDirCd(fcmDepRptVO.getSkdVoyNo() + fcmDepRptVO.getSkdDirCd());
			fcmDepRptLogVO.setDepPortCd(fcmDepRptVO.getDepPortCd());
			String clptIndSeq = null;
			if ("1".equals(fcmDepRptVO.getClptIndSeq())) {
				clptIndSeq = "F";
			} else if ("2".equals(fcmDepRptVO.getClptIndSeq())) {
				clptIndSeq = "S";
			} else if ("3".equals(fcmDepRptVO.getClptIndSeq())) {
				clptIndSeq = "T";
			}
			fcmDepRptLogVO.setClptIndSeq(clptIndSeq);
			fcmDepRptLogVO.setSbEngDt(fcmDepRptVO.getSbEngDt());
			fcmDepRptLogVO.setEngMlDist(fcmDepRptVO.getEngMlDist());
			fcmDepRptLogVO.setNvgtMlDist(fcmDepRptVO.getNvgtMlDist());
			fcmDepRptLogVO.setAvgSpd(fcmDepRptVO.getAvgSpd());
			fcmDepRptLogVO.setAvgRpmPwr(fcmDepRptVO.getAvgRpmPwr());
			fcmDepRptLogVO.setRupDt(fcmDepRptVO.getRupDt());
			
			seaFuelCsmCtnt.append(fcmDepRptVO.getSeaMnFoilCsmQty()).append("|");
			seaFuelCsmCtnt.append(fcmDepRptVO.getSeaGnrFoilCsmQty()).append("|");
			seaFuelCsmCtnt.append(fcmDepRptVO.getSeaBlrFoilCsmQty()).append("|");
			seaFuelCsmCtnt.append(fcmDepRptVO.getSeaMnDoilCsmQty()).append("|");
			seaFuelCsmCtnt.append(fcmDepRptVO.getSeaGnrDoilCsmQty()).append("|");
			seaFuelCsmCtnt.append(fcmDepRptVO.getSeaBlrDoilCsmQty()).append("|");
			fcmDepRptLogVO.setSeaFuelCsmCtnt(seaFuelCsmCtnt.toString());
			
			seaLowSulpFuelCsmCtnt.append(fcmDepRptVO.getSeaMnLowSulpFoilCsmQty()).append("|");
			seaLowSulpFuelCsmCtnt.append(fcmDepRptVO.getSeaGnrLowSulpFoilCsmQty()).append("|");
			seaLowSulpFuelCsmCtnt.append(fcmDepRptVO.getSeaBlrLowSulpFoilCsmQty()).append("|");
			seaLowSulpFuelCsmCtnt.append(fcmDepRptVO.getSeaMnLowSulpDoilCsmQty()).append("|");
			seaLowSulpFuelCsmCtnt.append(fcmDepRptVO.getSeaGnrLowSulpDoilCsmQty()).append("|");
			seaLowSulpFuelCsmCtnt.append(fcmDepRptVO.getSeaBlrLowSulpDoilCsmQty()).append("|");
			fcmDepRptLogVO.setSeaLowSulpFuelCsmCtnt(seaLowSulpFuelCsmCtnt.toString());
			
			arrRobCtnt.append(fcmDepRptVO.getArrFoilWgt()).append("|");
			arrRobCtnt.append(fcmDepRptVO.getArrDoilWgt()).append("|");
			arrRobCtnt.append("").append("|");
			arrRobCtnt.append("").append("|");
			arrRobCtnt.append(fcmDepRptVO.getArrLowSulpFoilWgt()).append("|");
			arrRobCtnt.append(fcmDepRptVO.getArrLowSulpDoilWgt()).append("|");
			fcmDepRptLogVO.setArrRobCtnt(arrRobCtnt.toString());
			
			portFuelCsmCtnt.append(fcmDepRptVO.getPortMnFoilCsmQty()).append("|");
			portFuelCsmCtnt.append(fcmDepRptVO.getPortGnrFoilCsmQty()).append("|");
			portFuelCsmCtnt.append(fcmDepRptVO.getPortBlrFoilCsmQty()).append("|");
			portFuelCsmCtnt.append(fcmDepRptVO.getPortMnDoilCsmQty()).append("|");
			portFuelCsmCtnt.append(fcmDepRptVO.getPortGnrDoilCsmQty()).append("|");
			portFuelCsmCtnt.append(fcmDepRptVO.getPortBlrDoilCsmQty()).append("|");
			fcmDepRptLogVO.setPortFuelCsmCtnt(portFuelCsmCtnt.toString());
			
			portLowSulpFuelCsmCtnt.append(fcmDepRptVO.getPortMnLowSulpFoilCsmQty()).append("|");
			portLowSulpFuelCsmCtnt.append(fcmDepRptVO.getPortGnrLowSulpFoilCsmQty()).append("|");
			portLowSulpFuelCsmCtnt.append(fcmDepRptVO.getPortBlrLowSulpFoilCsmQty()).append("|");
			portLowSulpFuelCsmCtnt.append(fcmDepRptVO.getPortMnLowSulpDoilCsmQty()).append("|");
			portLowSulpFuelCsmCtnt.append(fcmDepRptVO.getPortGnrLowSulpDoilCsmQty()).append("|");
			portLowSulpFuelCsmCtnt.append(fcmDepRptVO.getPortBlrLowSulpDoilCsmQty()).append("|");
			fcmDepRptLogVO.setPortLowSulpFuelCsmCtnt(portLowSulpFuelCsmCtnt.toString());
			
			splOilCtnt.append(fcmDepRptVO.getSplFoilBdrWgt()).append("|");
			splOilCtnt.append(fcmDepRptVO.getSplFoilActWgt()).append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append(fcmDepRptVO.getSplDoilBdrWgt()).append("|");
			splOilCtnt.append(fcmDepRptVO.getSplDoilActWgt()).append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append("").append("|");
			splOilCtnt.append("").append("|");
			fcmDepRptLogVO.setSplOilCtnt(splOilCtnt.toString());
			
			splLowSulpOilCtnt.append(fcmDepRptVO.getSplLowSulpFoilBdrWgt()).append("|");
			splLowSulpOilCtnt.append(fcmDepRptVO.getSplLowSulpFoilActWgt()).append("|");
			splLowSulpOilCtnt.append("").append("|");
			splLowSulpOilCtnt.append("").append("|");
			splLowSulpOilCtnt.append("").append("|");
			splLowSulpOilCtnt.append(fcmDepRptVO.getSplLowSulpDoilBdrWgt()).append("|");
			splLowSulpOilCtnt.append(fcmDepRptVO.getSplLowSulpDoilActWgt()).append("|");
			splLowSulpOilCtnt.append("").append("|");
			splLowSulpOilCtnt.append("").append("|");
			splLowSulpOilCtnt.append("").append("|");
			fcmDepRptLogVO.setSplLowSulpOilCtnt(splLowSulpOilCtnt.toString());
			
			cntrCgoCtnt.append("").append("|");
			cntrCgoCtnt.append("").append("|");
			cntrCgoCtnt.append("").append("|");
			cntrCgoCtnt.append(fcmDepRptVO.getRfCntrDchgKnt()).append("|");
			cntrCgoCtnt.append(fcmDepRptVO.getRfCntrLodKnt()).append("|");
			cntrCgoCtnt.append(fcmDepRptVO.getRfCntrObrdKnt()).append("|");
			fcmDepRptLogVO.setCntrCgoCtnt(cntrCgoCtnt.toString());
			
			// Departure Report Item Standard Data 조회
			resultVO = searchDepRptStandardData(fcmDepRptLogVO);
			
			// 각 항목 소수점 뒷자리수 셋팅
			resultVO.setAvgSpdCtnt(FCMGeneralUtil.convertScale(resultVO.getAvgSpdCtnt(), 1));
			resultVO.setAvgRpmPwrCtnt(FCMGeneralUtil.convertScale(resultVO.getAvgRpmPwrCtnt(), 1));
			resultVO.setAvgPrlrPchVal(FCMGeneralUtil.convertScale(resultVO.getAvgPrlrPchVal(), 7));
			resultVO.setSailTmHrs(FCMGeneralUtil.convertScale(resultVO.getSailTmHrs(), 1));
			resultVO.setArrFoilCtnt(FCMGeneralUtil.convertScale(resultVO.getArrFoilCtnt(), 1));
			resultVO.setArrLowSulpFoilCtnt(FCMGeneralUtil.convertScale(resultVO.getArrLowSulpFoilCtnt(), 1));
			resultVO.setArrDoilCtnt(FCMGeneralUtil.convertScale(resultVO.getArrDoilCtnt(), 1));
			resultVO.setArrLowSulpDoilCtnt(FCMGeneralUtil.convertScale(resultVO.getArrLowSulpDoilCtnt(), 1));
			resultVO.setDepFoilCtnt(FCMGeneralUtil.convertScale(resultVO.getDepFoilCtnt(), 1));
			resultVO.setDepLowSulpFoilCtnt(FCMGeneralUtil.convertScale(resultVO.getDepLowSulpFoilCtnt(), 1));
			resultVO.setDepDoilCtnt(FCMGeneralUtil.convertScale(resultVO.getDepDoilCtnt(), 1));
			resultVO.setDepLowSulpDoilCtnt(FCMGeneralUtil.convertScale(resultVO.getDepLowSulpDoilCtnt(), 1));
			resultVO.setSeaStmngMnEngTtlQty(FCMGeneralUtil.convertScale(resultVO.getSeaStmngMnEngTtlQty(), 1));
			resultVO.setAvgPortTtlQty(FCMGeneralUtil.convertScale(resultVO.getAvgPortTtlQty(), 1));
			resultVO.setAvgPortTtlHrQty(FCMGeneralUtil.convertScale(resultVO.getAvgPortTtlHrQty(), 10));
		
		} catch (Exception ex) {
			// COM12203 : Failed to retrieve ($s). Please try again.
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report Standard Data" }).getMessage(), ex);
		}
		
		return resultVO;
	}
	
	/**
	 * Departure Report Item Standard Data 조회
	 * 
	 * @param fcmDepRptLogVO
	 * @return FcmDepRptErrClsVO
	 * @throws EventException
	 */
	public FcmDepRptErrClsVO searchDepRptStandardData(FcmDepRptLogVO fcmDepRptLogVO) throws EventException {
		FcmDepRptErrClsVO resultVO = null;
		List<VskSkdInfoForDepRptVO> vskSkdInfoForDepRptVOList = null;
		VskSkdInfoForDepRptVO vskSkdInfoForDepRptVO = null;
		FcmDepRptVO lastPortDepRptVO = null;
		String blank = "";
		String delim = "|";
		
		try {
			// CLPT_IND_SEQ 포함 한 Vessel Schedule 단 건 조회
			vskSkdInfoForDepRptVOList = dbDao.searchVskSkdInfoForDepRpt(fcmDepRptLogVO, fcmDepRptLogVO.getClptIndSeq());
			
			if (vskSkdInfoForDepRptVOList != null && vskSkdInfoForDepRptVOList.size() == 1) {
				vskSkdInfoForDepRptVO = vskSkdInfoForDepRptVOList.get(0);
				
				// Last Port Departure Report 조회
				lastPortDepRptVO = dbDao.searchLastPortDepRpt(vskSkdInfoForDepRptVO);
				
				if (lastPortDepRptVO != null) {
					// Standard Data 추출을 위한 임시 Departure Report Log VO 를 생성한다.
					FcmDepRptLogVO tmpFcmDepRptLogVO = new FcmDepRptLogVO();
					tmpFcmDepRptLogVO.setVslCd(fcmDepRptLogVO.getVslCd());
					tmpFcmDepRptLogVO.setVoyDirCd(fcmDepRptLogVO.getVoyDirCd());
					tmpFcmDepRptLogVO.setDepPortCd(fcmDepRptLogVO.getDepPortCd());
					tmpFcmDepRptLogVO.setClptIndSeq(fcmDepRptLogVO.getClptIndSeq());
					tmpFcmDepRptLogVO.setSbEngDt(fcmDepRptLogVO.getSbEngDt());
					tmpFcmDepRptLogVO.setEngMlDist(fcmDepRptLogVO.getEngMlDist());
					tmpFcmDepRptLogVO.setNvgtMlDist(fcmDepRptLogVO.getNvgtMlDist());
					tmpFcmDepRptLogVO.setAvgSpd(fcmDepRptLogVO.getAvgSpd());
					tmpFcmDepRptLogVO.setAvgRpmPwr(fcmDepRptLogVO.getAvgRpmPwr());
					tmpFcmDepRptLogVO.setRupDt(fcmDepRptLogVO.getRupDt());
					tmpFcmDepRptLogVO.setSeaFuelCsmCtnt(fcmDepRptLogVO.getSeaFuelCsmCtnt());
					tmpFcmDepRptLogVO.setSeaLowSulpFuelCsmCtnt(fcmDepRptLogVO.getSeaLowSulpFuelCsmCtnt());
					tmpFcmDepRptLogVO.setArrRobCtnt(fcmDepRptLogVO.getArrRobCtnt());
					tmpFcmDepRptLogVO.setPortFuelCsmCtnt(fcmDepRptLogVO.getPortFuelCsmCtnt());
					tmpFcmDepRptLogVO.setPortLowSulpFuelCsmCtnt(fcmDepRptLogVO.getPortLowSulpFuelCsmCtnt());
					tmpFcmDepRptLogVO.setSplOilCtnt(fcmDepRptLogVO.getSplOilCtnt());
					tmpFcmDepRptLogVO.setSplLowSulpOilCtnt(fcmDepRptLogVO.getSplLowSulpOilCtnt());
					tmpFcmDepRptLogVO.setCntrCgoCtnt(fcmDepRptLogVO.getCntrCgoCtnt());
					
					// Standard Data 조회 시 쿼리 에러를 방지하기 위한 값 보정 - 숫자형 String이 아닐 경우 Blank 처리 한다.
					if (FCMGeneralUtil.isNull(tmpFcmDepRptLogVO.getEngMlDist()) || !FCMGeneralUtil.isNumberChk(tmpFcmDepRptLogVO.getEngMlDist())) {
						tmpFcmDepRptLogVO.setEngMlDist(blank);
					}
					if (FCMGeneralUtil.isNull(tmpFcmDepRptLogVO.getNvgtMlDist()) || !FCMGeneralUtil.isNumberChk(tmpFcmDepRptLogVO.getNvgtMlDist())) {
						tmpFcmDepRptLogVO.setNvgtMlDist(blank);
					}
					if (FCMGeneralUtil.isNull(tmpFcmDepRptLogVO.getAvgSpd()) || !FCMGeneralUtil.isNumberChk(tmpFcmDepRptLogVO.getAvgSpd())) {
						tmpFcmDepRptLogVO.setAvgSpd(blank);
					}
					if (FCMGeneralUtil.isNull(tmpFcmDepRptLogVO.getAvgRpmPwr()) || !FCMGeneralUtil.isNumberChk(tmpFcmDepRptLogVO.getAvgRpmPwr())) {
						tmpFcmDepRptLogVO.setAvgRpmPwr(blank);
					}
					
					List<String> arrRobCtntList = FCMGeneralUtil.convertListByString(tmpFcmDepRptLogVO.getArrRobCtnt(), delim);
					if (arrRobCtntList.size() > 0 && (FCMGeneralUtil.isNull(arrRobCtntList.get(0)) || !FCMGeneralUtil.isNumberChk(arrRobCtntList.get(0)))) {
						arrRobCtntList.set(0, blank);
					}
					if (arrRobCtntList.size() > 1 && (FCMGeneralUtil.isNull(arrRobCtntList.get(1)) || !FCMGeneralUtil.isNumberChk(arrRobCtntList.get(1)))) {
						arrRobCtntList.set(1, blank);
					}
					if (arrRobCtntList.size() > 4 && (FCMGeneralUtil.isNull(arrRobCtntList.get(4)) || !FCMGeneralUtil.isNumberChk(arrRobCtntList.get(4)))) {
						arrRobCtntList.set(4, blank);
					}
					if (arrRobCtntList.size() > 5 && (FCMGeneralUtil.isNull(arrRobCtntList.get(5)) || !FCMGeneralUtil.isNumberChk(arrRobCtntList.get(5)))) {
						arrRobCtntList.set(5, blank);
					}
					tmpFcmDepRptLogVO.setArrRobCtnt(FCMGeneralUtil.convertStringByList(arrRobCtntList, delim));
					
					List<String> depRobCtntList = FCMGeneralUtil.convertListByString(tmpFcmDepRptLogVO.getDepRobCtnt(), delim);
					if (depRobCtntList.size() > 0 && (FCMGeneralUtil.isNull(depRobCtntList.get(0)) || !FCMGeneralUtil.isNumberChk(depRobCtntList.get(0)))) {
						depRobCtntList.set(0, blank);
					}
					if (depRobCtntList.size() > 1 && (FCMGeneralUtil.isNull(depRobCtntList.get(1)) || !FCMGeneralUtil.isNumberChk(depRobCtntList.get(1)))) {
						depRobCtntList.set(1, blank);
					}
					if (depRobCtntList.size() > 4 && (FCMGeneralUtil.isNull(depRobCtntList.get(4)) || !FCMGeneralUtil.isNumberChk(depRobCtntList.get(4)))) {
						depRobCtntList.set(4, blank);
					}
					if (depRobCtntList.size() > 5 && (FCMGeneralUtil.isNull(depRobCtntList.get(5)) || !FCMGeneralUtil.isNumberChk(depRobCtntList.get(5)))) {
						depRobCtntList.set(5, blank);
					}
					tmpFcmDepRptLogVO.setDepRobCtnt(FCMGeneralUtil.convertStringByList(depRobCtntList, delim));
					
					List<String> seaFuelCsmCtntList = FCMGeneralUtil.convertListByString(tmpFcmDepRptLogVO.getSeaFuelCsmCtnt(), delim);
					if (seaFuelCsmCtntList.size() > 0 && (FCMGeneralUtil.isNull(seaFuelCsmCtntList.get(0)) || !FCMGeneralUtil.isNumberChk(seaFuelCsmCtntList.get(0)))) {
						seaFuelCsmCtntList.set(0, blank);
					}
					if (seaFuelCsmCtntList.size() > 1 && (FCMGeneralUtil.isNull(seaFuelCsmCtntList.get(1)) || !FCMGeneralUtil.isNumberChk(seaFuelCsmCtntList.get(1)))) {
						seaFuelCsmCtntList.set(1, blank);
					}
					if (seaFuelCsmCtntList.size() > 2 && (FCMGeneralUtil.isNull(seaFuelCsmCtntList.get(2)) || !FCMGeneralUtil.isNumberChk(seaFuelCsmCtntList.get(2)))) {
						seaFuelCsmCtntList.set(2, blank);
					}
					if (seaFuelCsmCtntList.size() > 3 && (FCMGeneralUtil.isNull(seaFuelCsmCtntList.get(3)) || !FCMGeneralUtil.isNumberChk(seaFuelCsmCtntList.get(3)))) {
						seaFuelCsmCtntList.set(3, blank);
					}
					if (seaFuelCsmCtntList.size() > 4 && (FCMGeneralUtil.isNull(seaFuelCsmCtntList.get(4)) || !FCMGeneralUtil.isNumberChk(seaFuelCsmCtntList.get(4)))) {
						seaFuelCsmCtntList.set(4, blank);
					}
					if (seaFuelCsmCtntList.size() > 5 && (FCMGeneralUtil.isNull(seaFuelCsmCtntList.get(5)) || !FCMGeneralUtil.isNumberChk(seaFuelCsmCtntList.get(5)))) {
						seaFuelCsmCtntList.set(5, blank);
					}
					tmpFcmDepRptLogVO.setSeaFuelCsmCtnt(FCMGeneralUtil.convertStringByList(seaFuelCsmCtntList, delim));
					
					List<String> seaLowSulpFuelCsmCtnt = FCMGeneralUtil.convertListByString(tmpFcmDepRptLogVO.getSeaLowSulpFuelCsmCtnt(), delim);
					if (seaLowSulpFuelCsmCtnt.size() > 0 && (FCMGeneralUtil.isNull(seaLowSulpFuelCsmCtnt.get(0)) || !FCMGeneralUtil.isNumberChk(seaLowSulpFuelCsmCtnt.get(0)))) {
						seaLowSulpFuelCsmCtnt.set(0, blank);
					}
					if (seaLowSulpFuelCsmCtnt.size() > 1 && (FCMGeneralUtil.isNull(seaLowSulpFuelCsmCtnt.get(1)) || !FCMGeneralUtil.isNumberChk(seaLowSulpFuelCsmCtnt.get(1)))) {
						seaLowSulpFuelCsmCtnt.set(1, blank);
					}
					if (seaLowSulpFuelCsmCtnt.size() > 2 && (FCMGeneralUtil.isNull(seaLowSulpFuelCsmCtnt.get(2)) || !FCMGeneralUtil.isNumberChk(seaLowSulpFuelCsmCtnt.get(2)))) {
						seaLowSulpFuelCsmCtnt.set(2, blank);
					}
					if (seaLowSulpFuelCsmCtnt.size() > 3 && (FCMGeneralUtil.isNull(seaLowSulpFuelCsmCtnt.get(3)) || !FCMGeneralUtil.isNumberChk(seaLowSulpFuelCsmCtnt.get(3)))) {
						seaLowSulpFuelCsmCtnt.set(3, blank);
					}
					if (seaLowSulpFuelCsmCtnt.size() > 4 && (FCMGeneralUtil.isNull(seaLowSulpFuelCsmCtnt.get(4)) || !FCMGeneralUtil.isNumberChk(seaLowSulpFuelCsmCtnt.get(4)))) {
						seaLowSulpFuelCsmCtnt.set(4, blank);
					}
					if (seaLowSulpFuelCsmCtnt.size() > 5 && (FCMGeneralUtil.isNull(seaLowSulpFuelCsmCtnt.get(5)) || !FCMGeneralUtil.isNumberChk(seaLowSulpFuelCsmCtnt.get(5)))) {
						seaLowSulpFuelCsmCtnt.set(5, blank);
					}
					tmpFcmDepRptLogVO.setSeaLowSulpFuelCsmCtnt(FCMGeneralUtil.convertStringByList(seaLowSulpFuelCsmCtnt, delim));
					
					List<String> portFuelCsmCtntList = FCMGeneralUtil.convertListByString(tmpFcmDepRptLogVO.getPortFuelCsmCtnt(), delim);
					if (portFuelCsmCtntList.size() > 0 && (FCMGeneralUtil.isNull(portFuelCsmCtntList.get(0)) || !FCMGeneralUtil.isNumberChk(portFuelCsmCtntList.get(0)))) {
						portFuelCsmCtntList.set(0, blank);
					}
					if (portFuelCsmCtntList.size() > 1 && (FCMGeneralUtil.isNull(portFuelCsmCtntList.get(1)) || !FCMGeneralUtil.isNumberChk(portFuelCsmCtntList.get(1)))) {
						portFuelCsmCtntList.set(1, blank);
					}
					if (portFuelCsmCtntList.size() > 2 && (FCMGeneralUtil.isNull(portFuelCsmCtntList.get(2)) || !FCMGeneralUtil.isNumberChk(portFuelCsmCtntList.get(2)))) {
						portFuelCsmCtntList.set(2, blank);
					}
					if (portFuelCsmCtntList.size() > 3 && (FCMGeneralUtil.isNull(portFuelCsmCtntList.get(3)) || !FCMGeneralUtil.isNumberChk(portFuelCsmCtntList.get(3)))) {
						portFuelCsmCtntList.set(3, blank);
					}
					if (portFuelCsmCtntList.size() > 4 && (FCMGeneralUtil.isNull(portFuelCsmCtntList.get(4)) || !FCMGeneralUtil.isNumberChk(portFuelCsmCtntList.get(4)))) {
						portFuelCsmCtntList.set(4, blank);
					}
					if (portFuelCsmCtntList.size() > 5 && (FCMGeneralUtil.isNull(portFuelCsmCtntList.get(5)) || !FCMGeneralUtil.isNumberChk(portFuelCsmCtntList.get(5)))) {
						portFuelCsmCtntList.set(5, blank);
					}
					tmpFcmDepRptLogVO.setPortFuelCsmCtnt(FCMGeneralUtil.convertStringByList(portFuelCsmCtntList, delim));
					
					List<String> portLowSulpFuelCsmCtntList = FCMGeneralUtil.convertListByString(tmpFcmDepRptLogVO.getPortLowSulpFuelCsmCtnt(), delim);
					if (portLowSulpFuelCsmCtntList.size() > 0 && (FCMGeneralUtil.isNull(portLowSulpFuelCsmCtntList.get(0)) || !FCMGeneralUtil.isNumberChk(portLowSulpFuelCsmCtntList.get(0)))) {
						portLowSulpFuelCsmCtntList.set(0, blank);
					}
					if (portLowSulpFuelCsmCtntList.size() > 1 && (FCMGeneralUtil.isNull(portLowSulpFuelCsmCtntList.get(1)) || !FCMGeneralUtil.isNumberChk(portLowSulpFuelCsmCtntList.get(1)))) {
						portLowSulpFuelCsmCtntList.set(1, blank);
					}
					if (portLowSulpFuelCsmCtntList.size() > 2 && (FCMGeneralUtil.isNull(portLowSulpFuelCsmCtntList.get(2)) || !FCMGeneralUtil.isNumberChk(portLowSulpFuelCsmCtntList.get(2)))) {
						portLowSulpFuelCsmCtntList.set(2, blank);
					}
					if (portLowSulpFuelCsmCtntList.size() > 3 && (FCMGeneralUtil.isNull(portLowSulpFuelCsmCtntList.get(3)) || !FCMGeneralUtil.isNumberChk(portLowSulpFuelCsmCtntList.get(3)))) {
						portLowSulpFuelCsmCtntList.set(3, blank);
					}
					if (portLowSulpFuelCsmCtntList.size() > 4 && (FCMGeneralUtil.isNull(portLowSulpFuelCsmCtntList.get(4)) || !FCMGeneralUtil.isNumberChk(portLowSulpFuelCsmCtntList.get(4)))) {
						portLowSulpFuelCsmCtntList.set(4, blank);
					}
					if (portLowSulpFuelCsmCtntList.size() > 5 && (FCMGeneralUtil.isNull(portLowSulpFuelCsmCtntList.get(5)) || !FCMGeneralUtil.isNumberChk(portLowSulpFuelCsmCtntList.get(5)))) {
						portLowSulpFuelCsmCtntList.set(5, blank);
					}
					tmpFcmDepRptLogVO.setPortLowSulpFuelCsmCtnt(FCMGeneralUtil.convertStringByList(portLowSulpFuelCsmCtntList, delim));
					
					List<String> cntrCgoCtnt = FCMGeneralUtil.convertListByString(tmpFcmDepRptLogVO.getCntrCgoCtnt(), delim);
					if (cntrCgoCtnt.size() > 0 && (FCMGeneralUtil.isNull(cntrCgoCtnt.get(0)) || !FCMGeneralUtil.isNumberChk(cntrCgoCtnt.get(0)))) {
						cntrCgoCtnt.set(0, blank);
					}
					if (cntrCgoCtnt.size() > 1 && (FCMGeneralUtil.isNull(cntrCgoCtnt.get(1)) || !FCMGeneralUtil.isNumberChk(cntrCgoCtnt.get(1)))) {
						cntrCgoCtnt.set(1, blank);
					}
					if (cntrCgoCtnt.size() > 2 && (FCMGeneralUtil.isNull(cntrCgoCtnt.get(2)) || !FCMGeneralUtil.isNumberChk(cntrCgoCtnt.get(2)))) {
						cntrCgoCtnt.set(2, blank);
					}
					if (cntrCgoCtnt.size() > 3 && (FCMGeneralUtil.isNull(cntrCgoCtnt.get(3)) || !FCMGeneralUtil.isNumberChk(cntrCgoCtnt.get(3)))) {
						cntrCgoCtnt.set(3, blank);
					}
					if (cntrCgoCtnt.size() > 4 && (FCMGeneralUtil.isNull(cntrCgoCtnt.get(4)) || !FCMGeneralUtil.isNumberChk(cntrCgoCtnt.get(4)))) {
						cntrCgoCtnt.set(4, blank);
					}
					if (cntrCgoCtnt.size() > 5 && (FCMGeneralUtil.isNull(cntrCgoCtnt.get(5)) || !FCMGeneralUtil.isNumberChk(cntrCgoCtnt.get(5)))) {
						cntrCgoCtnt.set(5, blank);
					}
					tmpFcmDepRptLogVO.setCntrCgoCtnt(FCMGeneralUtil.convertStringByList(cntrCgoCtnt, delim));
					
					if (FCMGeneralUtil.isNull(lastPortDepRptVO.getDepFoilWgt()) || !FCMGeneralUtil.isNumberChk(lastPortDepRptVO.getDepFoilWgt())) {
						lastPortDepRptVO.setDepFoilWgt(blank);
					}
					if (FCMGeneralUtil.isNull(lastPortDepRptVO.getDepLowSulpFoilWgt()) || !FCMGeneralUtil.isNumberChk(lastPortDepRptVO.getDepLowSulpFoilWgt())) {
						lastPortDepRptVO.setDepLowSulpFoilWgt(blank);
					}
					if (FCMGeneralUtil.isNull(lastPortDepRptVO.getDepDoilWgt()) || !FCMGeneralUtil.isNumberChk(lastPortDepRptVO.getDepDoilWgt())) {
						lastPortDepRptVO.setDepDoilWgt(blank);
					}
					if (FCMGeneralUtil.isNull(lastPortDepRptVO.getDepLowSulpDoilWgt()) || !FCMGeneralUtil.isNumberChk(lastPortDepRptVO.getDepLowSulpDoilWgt())) {
						lastPortDepRptVO.setDepLowSulpDoilWgt(blank);
					}
					if (FCMGeneralUtil.isNull(lastPortDepRptVO.getRfCntrObrdKnt()) || !FCMGeneralUtil.isNumberChk(lastPortDepRptVO.getRfCntrObrdKnt())) {
						lastPortDepRptVO.setRfCntrObrdKnt(blank);
					}
					
					// Departure Report Item Standard Data 조회
					resultVO = dbDao.searchDepRptStandardData(tmpFcmDepRptLogVO, lastPortDepRptVO);
				} else {
					// Last Port Departure Report 정보가 조회 되지 않을 경우 빈 VO 를 Return
					resultVO = new FcmDepRptErrClsVO();
				}
				
			} else {
				// Vessel Schedule 정보가 조회 되지 않을 경우 빈 VO 를 Return
				resultVO = new FcmDepRptErrClsVO();
			}
			
		} catch (DAOException ex) {
			// COM12203 : Failed to retrieve ($s). Please try again.
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report Standard Data" }).getMessage(), ex);
		} catch (Exception ex) {
			// COM12203 : Failed to retrieve ($s). Please try again.
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Departure Report Standard Data" }).getMessage(), ex);
		}
		
		return resultVO;
	}
	
	/**
	 * Create departure report log. Update result of creation.<br>
	 * 
	 * @param FcmDepRptLogVO fcmDepRptLogVO
	 * @exception EventException
	 */
	public void modifyDepRptLogPost(FcmDepRptLogVO fcmDepRptLogVO)
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
	 * @param VslRptInqVO vslRptInqVO
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
	 * @param VslRptInqVO vslRptInqVO
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
	 * Departure Report Error 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptErrVO>
	 * @exception EventException
	 */
	public List<VslDepRptErrVO> searchVslDepRptErr(VslRptInqVO vslRptInqVO) throws EventException {
		try {
			return dbDao.searchVslDepRptErr(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Error"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Error"}).getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * VOP_FCM_0001 화면에 대한 조회 이벤트 처리<br>
	 * Departure Report Overlap 정보를 조회한다.<br>
	 * 
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslDepRptOverlapVO>
	 * @exception EventException
	 */
	public List<VslDepRptOverlapVO> searchVslDepRptOverlap(VslRptInqVO vslRptInqVO) throws EventException {
		try {
			return dbDao.searchVslDepRptOverlap(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Overlap"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Overlap"}).getMessage(), ex);
		}
	}


	/**
	 * VOP_FCM_0001 화면에 대한 삭제 이벤트 처리
	 * Departure Report Error 항목을 삭제한다.
	 * 
	 * @param VslDepRptErrVO[] vslDepRptErrVOs
	 * @exception EventException
	 */
	public void removeVslDepRptErrList(VslDepRptErrVO[] vslDepRptErrVOs) throws EventException{
		try {
			List<VslDepRptErrVO> deleteVoList = new ArrayList<VslDepRptErrVO>();
			for ( int i=0; i<vslDepRptErrVOs.length; i++ ) {
				if ( vslDepRptErrVOs[i].getIbflag().equals("D")){
					deleteVoList.add(vslDepRptErrVOs[i]);
				}
			}
		
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeVslDepRptErrList(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Departure Report Error"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Departure Report Error"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_FCM_0001 화면에 대한 삭제 이벤트 처리
	 * Departure Report Error 항목을 삭제한다.
	 * 
	 * @param VslDepRptOverlapVO[] vslDepRptOverlapVOs
	 * @exception EventException
	 */
	public void removeVslDepRptOverlapList(VslDepRptOverlapVO[] vslDepRptOverlapVOs) throws EventException{
		try {
			List<VslDepRptOverlapVO> deleteVoList = new ArrayList<VslDepRptOverlapVO>();
			for ( int i=0; i<vslDepRptOverlapVOs.length; i++ ) {
				if ( vslDepRptOverlapVOs[i].getIbflag().equals("D")){
					deleteVoList.add(vslDepRptOverlapVOs[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeVslDepRptOverlapList(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Departure Report Error"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Departure Report Error"}).getMessage(), ex);
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
	 * @param VslRptInqVO vslRptInqVO
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
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslABLogRptNotRcvVO>
	 * @exception EventException
	 */
	public List<VslABLogRptNotRcvVO> searchVslABLogRptNotRcv(VslRptInqVO vslRptInqVO) throws EventException {
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
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslABLogRptMssMtchVO>
	 * @exception EventException
	 */
	public List<VslABLogRptMssMtchVO> searchVslABLogRptMssMtch(VslRptInqVO vslRptInqVO) throws EventException {
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
	 * @param VslRptInqVO vslRptInqVO
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
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslRobMthEndRptNotRcvVO>
	 * @exception EventException
	 */
	public List<VslRobMthEndRptNotRcvVO> searchVslRobMthEndRptNotRcv(VslRptInqVO vslRptInqVO) throws EventException {
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
	 * @param VslRptInqVO vslRptInqVO
	 * @return List<VslRobMthEndRptMssMtchVO>
	 * @exception EventException
	 */
	public List<VslRobMthEndRptMssMtchVO> searchVslRobMthEndRptMssMtch(VslRptInqVO vslRptInqVO) throws EventException {
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
	 * @param searchMailingListVO searchMailingListVO
	 * @return List<SearchMailingListVO>
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
	
	/**
	 * Departure Report Inquiry 조회
	 * 
	 * @param vslRptInqVO VslRptInqVO
	 * @return List<VslFcmDepRptVO>
	 * @throws EventException
	 */
	public List<VslFcmDepRptVO> searchVslFcmDepRptList(VslRptInqVO vslRptInqVO) throws EventException {
		try {
			return dbDao.searchVslFcmDepRptList(vslRptInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", "Departure Report").getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", "Departure Report").getMessage(), ex);
		}
	}
	
	/**
	 * Departure Report Inquiry 업데이트
	 * 
	 * @param vslFcmDepRptVOs VslFcmDepRptVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void updateVslFcmDepRptList(VslFcmDepRptVO[] vslFcmDepRptVOs, SignOnUserAccount account) throws EventException {
		try {
			List<VslFcmDepRptVO> vslFcmDepRptVOList = new ArrayList<VslFcmDepRptVO>();
			
			for (int i = 0; i < vslFcmDepRptVOs.length; i++) {
				if ("U".equals(vslFcmDepRptVOs[i].getIbflag())) {
					vslFcmDepRptVOs[i].setUpdUsrId(account.getUsr_id());
					if ("1".equals(vslFcmDepRptVOs[i].getAvgExptFlg())) {
						vslFcmDepRptVOs[i].setAvgExptFlg("Y");
					} else {
						vslFcmDepRptVOs[i].setAvgExptFlg("N");
					}
					vslFcmDepRptVOList.add(vslFcmDepRptVOs[i]);
				}
			}
			
			if (vslFcmDepRptVOList.size() > 0) {
				dbDao.updateVslFcmDepRptList(vslFcmDepRptVOList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192", "Departure Report").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192", "Departure Report").getMessage(), ex);
		}
	}
	
	/**-----------------------------------------------------------0003 start-------------------------------------------**/
	
	/**
	 * Departure Report PK Error Cleansing sheet2(SKD) 조회
	 * 
	 * @param SearchVslPortSkdVO vslPortSkdVO
	 * @return List<VslPortSkdVO>
	 * @throws EventException
	 */
	public List<SearchVslPortSkdVO> searchVslPortSkdList(SearchVslPortSkdVO vslPortSkdVO) throws EventException {
		try {
			return dbDao.searchVslPortSkdList(vslPortSkdVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", "Departure Report").getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", "Departure Report").getMessage(), ex);
		}
	}
	
	
	/**
	 * Departure Report PK Error Cleansing 업데이트
	 * 
	 * @param FcmDepRptErrVO vslFcmDepRptVO
	 * @param FcmDepRptClsHisVO fcmDepRptClsHisVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiFcmDepRptErrPkCleasing(FcmDepRptErrVO vslFcmDepRptVO, FcmDepRptClsHisVO fcmDepRptClsHisVO,SignOnUserAccount account) throws EventException {
		try {
			
			log.debug("\n\n\n user_id=" + account.getUsr_id());
				if(vslFcmDepRptVO != null) {
					fcmDepRptClsHisVO.setCreUsrId(account.getUsr_id());
					fcmDepRptClsHisVO.setUpdUsrId(account.getUsr_id());
					dbDao.insertFcmDepRptClsHis(fcmDepRptClsHisVO); 
					dbDao.deleteFcmDepRptErr(vslFcmDepRptVO);
				}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192", "Departure Report").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192", "Departure Report").getMessage(), ex);
		}
	}
	
	/**-----------------------------------------------------------0003 end  -------------------------------------------**/
	
	/**
	 * Departure Report Item ERROR Data [FCM_DEP_RPT_ERR] 조회
	 * 
	 * @param searchType
	 * @param sEventName
	 * @param fcmDepRptErrClsVO
	 * @return List<FcmDepRptErrClsVO>
	 * @throws EventException
	 */
	public List<FcmDepRptErrClsVO> searchFcmDepRptErrCls(String searchType, String sEventName, FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException {

		List<FcmDepRptErrClsVO> fcmDepRptErrClsVOList = new ArrayList<FcmDepRptErrClsVO>();
		FcmDepRptErrClsVO 	depRptClsVO		= new FcmDepRptErrClsVO();
		String				sDepRptErrTpCd	= "";
		
		
		try {
			if("VopFcm0004Event".equalsIgnoreCase(sEventName)){
				sDepRptErrTpCd = "IE,IM";
			}else if("VopFcm0005Event".equalsIgnoreCase(sEventName)){
				sDepRptErrTpCd = "PO";
			}
			
			if("SRCH".equals(searchType)){
				depRptClsVO	= dbDao.searchFcmDepRptErrCls(sDepRptErrTpCd, fcmDepRptErrClsVO);	// FCM_DEP_RPT_ERR
			}else if("SIM".equals(searchType)){
				// Simulation 시 기존 ErrItmCtnt 항목 초기화 2016.08.12
				fcmDepRptErrClsVO.setErrItmCtnt("");
				depRptClsVO = fcmDepRptErrClsVO;
			}
			
			FcmDepRptErrClsVO errClsVO	= new FcmDepRptErrClsVO();
			FcmDepRptErrClsVO stndVO	= new FcmDepRptErrClsVO();
			FcmDepRptErrClsVO errSetVO	= dbDao.SearchFcmDepRptErrRtSetCls(fcmDepRptErrClsVO);
			
			if(errSetVO == null){
				errSetVO = new FcmDepRptErrClsVO();
			}
			
			// Dep.Report Calc
			errClsVO = errItemCalcDepRpt(depRptClsVO);
			
			// Standard
			stndVO = searchDepRptStandardData(depRptClsVO);

			// Dep.Report, Standard, DIFF. , Rate / Range Row
//			fcmDepRptErrClsVOList = errItemCalcAll(errClsVO, stndVO);
			
			fcmDepRptErrClsVOList = errItemCalcAll(errClsVO, stndVO, errSetVO, searchType);
			
			// Error Setting Row
			fcmDepRptErrClsVOList.add(4, errSetVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Item Error Correction"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Item Error Correction"}).getMessage(), ex);
		}
		return fcmDepRptErrClsVOList;
	}
	
	/**
	 * Departure Report Cleansing Data 조회
	 * @param searchType
	 * @param depRptVO
	 * @return List<FcmDepRptErrClsVO>
	 * @throws EventException
	 */
	public List<FcmDepRptErrClsVO> searchFcmDepRptErrCls(String searchType, FcmDepRptVO depRptVO) throws EventException {

		List<FcmDepRptErrClsVO> depRptErrClsVOList	= new ArrayList<FcmDepRptErrClsVO>();
		FcmDepRptErrClsVO 		depRptErrClsVO		= new FcmDepRptErrClsVO();
		
		try {
			depRptErrClsVO = depRptVOTOdepRptClsVO(depRptVO);
			
			
			FcmDepRptErrClsVO errClsVO	= new FcmDepRptErrClsVO();
			FcmDepRptErrClsVO stndVO	= new FcmDepRptErrClsVO();
			FcmDepRptErrClsVO errSetVO	= dbDao.SearchFcmDepRptErrRtSetCls(depRptErrClsVO);
			
			if(errSetVO == null){
				errSetVO = new FcmDepRptErrClsVO();
			}
			
			// Dep.Report Calc
			errClsVO = errItemCalcDepRpt(depRptErrClsVO);
			
			// Standard
			stndVO = searchDepRptStandardData(depRptVO);

			// Dep.Report, Standard, DIFF. , Rate / Range Row
			depRptErrClsVOList = errItemCalcAll(errClsVO, stndVO, errSetVO, searchType);
			
			// Error Setting Row
			depRptErrClsVOList.add(4, errSetVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Item Error Correction"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Item Error Correction"}).getMessage(), ex);
		}
		return depRptErrClsVOList;
	}
	
	/**
	 * Departure Report Cleansing Data [FCM_DEP_RPT] 조회
	 * 
	 * @param fcmDepRptErrClsVO
	 * @return FcmDepRptVO
	 * @throws EventException
	 */
	public FcmDepRptVO searchFcmDepRptCls(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException {
		FcmDepRptVO depRptVO = new FcmDepRptVO();
		
		try {
			depRptVO = dbDao.searchFcmDepRptCls(fcmDepRptErrClsVO);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Item Error Correction"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Item Error Correction"}).getMessage(), ex);
		}
		return depRptVO;
	}
	
	/**
	 * Departure Report Past Cleansing History 조회
	 * 
	 * @param fcmDepRptErrClsVO
	 * @return List<FcmDepRptErrClsVO>
	 * @throws EventException
	 */
	public List<FcmDepRptErrClsVO> searchFcmDepRptClsHis(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException {
		try {
			
			List<FcmDepRptErrClsVO> list = dbDao.searchFcmDepRptPastClsHis(fcmDepRptErrClsVO);
			List<FcmDepRptErrClsVO> clsHisVOList = new ArrayList<FcmDepRptErrClsVO>();			
			
			FcmDepRptErrClsVO clsHisVO = new FcmDepRptErrClsVO();
			if(list != null){
				clsHisVOList = list;
				// 조회건수가 3건 미만일 겨우 clsHisVO 로 채움
				if(clsHisVOList.size() > 0 && clsHisVOList.size() < 3){
					for(int i=clsHisVOList.size(); i < 3; i++){
						clsHisVOList.add(i, clsHisVO);
					}
				}
			}
			
			return clsHisVOList;
			
      } catch (DAOException ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report"}).getMessage(), ex);
      } catch (Exception ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report"}).getMessage(), ex);
		}
	}
	
	/**
	 * Departure Report Same Section Data 조회
	 * 
	 * @param fcmDepRptErrClsVO
	 * @return List<FcmDepRptErrClsVO>
	 * @throws EventException
	 */
	public List<FcmDepRptErrClsVO> searchFcmDepRptSamSectDat(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException {
		try {
			List<FcmDepRptErrClsVO> list = dbDao.searchFcmDepRptSamSectDat(fcmDepRptErrClsVO);
			List<FcmDepRptErrClsVO> samSectDatVOList = new ArrayList<FcmDepRptErrClsVO>();			
			
			FcmDepRptErrClsVO samSectDatVO = new FcmDepRptErrClsVO();
			
			if(list != null){
				// 계산식 적용하여 samSectDatVOList 담기
				for(int i=0; i < list.size(); i++){
					samSectDatVOList.add(i, errItemCalcDepRpt(list.get(i)));
				}
				
				// 조회건수가 3건 미만일 겨우 samSectDatVO 로 채움
				if(samSectDatVOList.size() > 0 && samSectDatVOList.size() < 3){
					for(int i=samSectDatVOList.size(); i < 3; i++){
						samSectDatVOList.add(i, samSectDatVO);
					}
				}
			}
			
			return samSectDatVOList;
			
      } catch (DAOException ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report"}).getMessage(), ex);
      } catch (Exception ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report"}).getMessage(), ex);
		}
	}
	
	/**
	 * Dep. Report 의 각 항목 계산식 적용
	 * 
	 * @param depRptVO
	 * @return FcmDepRptErrClsVO
	 * @throws EventException
	 */
	@SuppressWarnings("static-access")
	public FcmDepRptErrClsVO errItemCalcDepRpt(FcmDepRptErrClsVO depRptClsVO) throws EventException {
		FCMGeneralUtil fcmUtil		= new FCMGeneralUtil();
		FcmDepRptErrClsVO resultVO	= depRptClsVO;
		
		try {
			double sailTmHrs			= 0;
			double avgPrlrPchVal		= 0;
			double seaStmngMnEngTtlQty	= 0;
			double avgPortTtlQty		= 0;
			double avgPortTtlHrQty		= 0;
			double timeDiff				= 0;
			BigDecimal zeroVal			= new BigDecimal("0");
			BigDecimal compareVal1		= null;
			BigDecimal compareVal2		= null;
			DecimalFormat decFmt		= new DecimalFormat("0.0");
			
			if(depRptClsVO != null){
				
				// 15 : PERFORMANCE : Sailing Time
				// Calc : SAIL_TM_HRS = NVGT_ML_DIST_CTNT / AVG_SPD_CTNT
				if(errCalcItemChk(depRptClsVO.getNvgtMlDistCtnt()) && errCalcItemChk(depRptClsVO.getAvgSpdCtnt())){

					compareVal1 = new BigDecimal(depRptClsVO.getAvgSpdCtnt());
					
					if(zeroVal.compareTo(compareVal1) != 0){
						sailTmHrs = fcmUtil.convertDoubleByString(depRptClsVO.getNvgtMlDistCtnt()) / fcmUtil.convertDoubleByString(depRptClsVO.getAvgSpdCtnt());
						decFmt = new DecimalFormat("0.0");
						resultVO.setSailTmHrs(decFmt.format(sailTmHrs));						
					}
				}
				
				// 14 : PERFORMANCE : AVG. nPro.Pitch (SAIL_TM_HRS 을 먼저 구해야함)
				// Calc : AVG_PRLR_PCH_VAL = ENG_ML_DIST_CTNT / (( SAIL_TM_HRS * 60 ) * AVG_RPM_PWR_CTNT )
				if(errCalcItemChk(depRptClsVO.getEngMlDistCtnt()) && errCalcItemChk(depRptClsVO.getSailTmHrs()) && errCalcItemChk(depRptClsVO.getAvgRpmPwrCtnt())){
					compareVal1 = new BigDecimal(depRptClsVO.getSailTmHrs());
					compareVal2 = new BigDecimal(depRptClsVO.getAvgRpmPwrCtnt());
					
					if(zeroVal.compareTo(compareVal1) != 0 && zeroVal.compareTo(compareVal2) != 0){
						avgPrlrPchVal = fcmUtil.convertDoubleByString(depRptClsVO.getEngMlDistCtnt()) / ((fcmUtil.convertDoubleByString(depRptClsVO.getSailTmHrs()) * 60 ) * fcmUtil.convertDoubleByString(depRptClsVO.getAvgRpmPwrCtnt()));
						decFmt = new DecimalFormat("0.0000000");
						resultVO.setAvgPrlrPchVal(decFmt.format(avgPrlrPchVal));
					}
				}
				
				// 28 : FUEL CONDUM. :Sea Steaming : M/E
				// Calc : SEA_STMNG_MN_ENG_TTL_QTY = SEA_MN_FOIL_CTNT + SEA_MN_LOW_SULP_FOIL_CTNT + SEA_MN_DOIL_CTNT + SEA_MN_LOW_SULP_DOIL_CTNT
				seaStmngMnEngTtlQty	= fcmUtil.convertDoubleByString(depRptClsVO.getSeaMnFoilCtnt()) 
									+ fcmUtil.convertDoubleByString(depRptClsVO.getSeaMnLowSulpFoilCtnt())
									+ fcmUtil.convertDoubleByString(depRptClsVO.getSeaMnDoilCtnt())
									+ fcmUtil.convertDoubleByString(depRptClsVO.getSeaMnLowSulpDoilCtnt());
				decFmt = new DecimalFormat("0.0");
				resultVO.setSeaStmngMnEngTtlQty(decFmt.format(seaStmngMnEngTtlQty));
				
				// 29 : FUEL CONSUM. : Harbor/In Port : TTL
				// Calc : AVG_PORT_TTL_QTY = PORT_MN_FOIL_CTNT + PORT_GNR_FOIL_CTNT + PORT_BLR_FOIL_CTNT + PORT_MN_LOW_SULP_FOIL_CTNT 
				//							+ PORT_GNR_LOW_SULP_FOIL_CTNT + PORT_BLR_LOW_SULP_FOIL_CTNT + PORT_MN_DOIL_CTNT 
				//							+ PORT_GNR_DOIL_CTNT + PORT_BLR_DOIL_CTNT + PORT_MN_LOW_SULP_DOIL_CTNT 
				//							+ PORT_GNR_LOW_SULP_DOIL_CTNT + PORT_BLR_LOW_SULP_DOIL_CTNT
				avgPortTtlQty	= fcmUtil.convertDoubleByString(depRptClsVO.getPortMnFoilCtnt())
								+ fcmUtil.convertDoubleByString(depRptClsVO.getPortGnrFoilCtnt())
								+ fcmUtil.convertDoubleByString(depRptClsVO.getPortBlrFoilCtnt())
								+ fcmUtil.convertDoubleByString(depRptClsVO.getPortMnLowSulpFoilCtnt())
								+ fcmUtil.convertDoubleByString(depRptClsVO.getPortGnrLowSulpFoilCtnt()) 
								+ fcmUtil.convertDoubleByString(depRptClsVO.getPortBlrLowSulpFoilCtnt()) 
								+ fcmUtil.convertDoubleByString(depRptClsVO.getPortMnDoilCtnt())
								+ fcmUtil.convertDoubleByString(depRptClsVO.getPortGnrDoilCtnt()) 
								+ fcmUtil.convertDoubleByString(depRptClsVO.getPortBlrDoilCtnt()) 
								+ fcmUtil.convertDoubleByString(depRptClsVO.getPortMnLowSulpDoilCtnt())
								+ fcmUtil.convertDoubleByString(depRptClsVO.getPortGnrLowSulpDoilCtnt()) 
								+ fcmUtil.convertDoubleByString(depRptClsVO.getPortBlrLowSulpDoilCtnt());
				
				decFmt = new DecimalFormat("0.0");
				depRptClsVO.setAvgPortTtlQty(decFmt.format(avgPortTtlQty));
				
				// 30 : FUEL CONSUM. : AVG. HarborInport FOC/HR : TTL
				if(errCalcItemChk(depRptClsVO.getSbEngDt()) && errCalcItemChk(depRptClsVO.getRupDt())){
					timeDiff		= (double) fcmUtil.dateDiff(depRptClsVO.getSbEngDt(), "yyyyMMddHHmm", depRptClsVO.getRupDt(), "yyyyMMddHHmm", "s");
					avgPortTtlHrQty	= fcmUtil.convertDoubleByString(depRptClsVO.getAvgPortTtlQty()) / (timeDiff / (60 * 60));
					
					decFmt = new DecimalFormat("0.0000000000");
					resultVO.setAvgPortTtlHrQty(decFmt.format(avgPortTtlHrQty));
				}
			}
			
			return resultVO;
      } catch (Exception ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Item Error Correction"}).getMessage(), ex);
		}
	}
	
	/**
	 * simulation 시 기준치 오차범위인치 확인
	 * 
	 * @param compareType
	 * @param errSetValue
	 * @param compareValue
	 * @return Boolean
	 * @throws EventException
	 */
	public Boolean  simErrItmChk(String compareType, String errSetValue, String itemValue) throws EventException {
		Boolean resultVal = false;
		
		BigDecimal zeroVal =  new BigDecimal("0");
		BigDecimal itemeVal = null;
		BigDecimal errSetVal = null;
		
		
		try{
			if(errCalcItemChk(errSetValue) && errCalcItemChk(itemValue)){
				itemeVal	= new BigDecimal(itemValue);
				errSetVal	= new BigDecimal(errSetValue);
				
				if("PM".equals(compareType)){// 기준치 이내 plus, minus
					if(errSetVal.compareTo(itemeVal.abs()) != -1){
						resultVal = true;
					}else{
						resultVal = false;
					}
				}else if("ZP".equals(compareType)){ // 0보다 크거나 기준치보다 작은 거 zero plus
					if((errSetVal.compareTo(itemeVal) == 1) && (zeroVal.compareTo(itemeVal) == -1)){
						resultVal = true;
					}else{
						resultVal = false;
					}
				}else if("ZE".equals(compareType)){ // 0보다 크거나 같고 기준치보다 작은 거 zero
					if((errSetVal.compareTo(itemeVal) == 1) && (zeroVal.compareTo(itemeVal) != 1)){
						resultVal = true;
					}else{
						resultVal = false;
					}
				}else if("MI".equals(compareType)){ // OBS Mile Check 설정값보다 미만일경우 Pass
					if((errSetVal.compareTo(itemeVal) == 1)){
						resultVal = false;
					}else{
						resultVal = true;
					}
				}
			}
			
		} catch (Exception ex) {
	          log.error("err " + ex.toString(), ex);
	          throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Item Error, Overlap Correction - dataCompare"}).getMessage(), ex);
		}
		return resultVal;
	}
	
	/**
	 * Dep. Report 와 Standard 의 VO 를 받아 계산식 처리 
	 * 
	 * @param depRptVO
	 * @param stndVO
	 * @param errSetVO
	 * @param searchTyp
	 * @return List<FcmDepRptErrClsVO>
	 * @throws EventException
	 */
	@SuppressWarnings({ "static-access", "unused" })
	public List<FcmDepRptErrClsVO> errItemCalcAll(FcmDepRptErrClsVO depRptVO, FcmDepRptErrClsVO stndVO, FcmDepRptErrClsVO errSetVO, String searchType) throws EventException {
		FCMGeneralUtil fcmUtil		= new FCMGeneralUtil();
		FcmDepRptErrClsVO diffVO	= new FcmDepRptErrClsVO();
		FcmDepRptErrClsVO rtRngVO	= new FcmDepRptErrClsVO();
		
		List<FcmDepRptErrClsVO> rtnVOList = new ArrayList<FcmDepRptErrClsVO>();
		
		StringBuffer errItmCtnt	= new StringBuffer();
		String calcStr			= "";
		String[] noPct			= new String[2];
		double timeDiff			= 0;
		DecimalFormat decFmt	= new DecimalFormat("#.#");
		Boolean milesObsChk		= false;
		
		try {
			// Miles Obs 가 30 Mile 이상인지 확인
			if(errCalcItemChk(depRptVO.getNvgtMlDistCtnt()) && simErrItmChk("MI","30", depRptVO.getNvgtMlDistCtnt())){
				milesObsChk = true;
			}
			
			// OBS Mile 30미만인 경우 RPM Data 없으면 빈칸 처리
			if(!milesObsChk && !errCalcItemChk(depRptVO.getAvgRpmPwrCtnt())){
				// 14 : PERFORMANCE : AVG. Pro.Pitch
				depRptVO.setAvgPrlrPchVal("");
				// 15 : PERFORMANCE : Sailing Time
				depRptVO.setSailTmHrs("");
			}
			
			// DIFF. , Rate / Range 처리
			// 8 : PERFORMANCE : Miles Obs 
			if(errCalcItemChk(depRptVO.getNvgtMlDistCtnt()) && errCalcItemChk(stndVO.getNvgtMlDistCtnt())){
				calcStr		= errItemCalc("A",  "", "1", depRptVO.getNvgtMlDistCtnt(), stndVO.getNvgtMlDistCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1]	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setNvgtMlDistCtnt(noPct[0]);
				rtRngVO.setNvgtMlDistCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getNvgtMlDistCtnt(), noPct[1]))){
					errItmCtnt.append("NVGT_ML_DIST_CTNT|");
				}
			}
			
			// 9 : PERFORMANCE : Miles Eng
			if(errCalcItemChk(depRptVO.getEngMlDistCtnt()) && errCalcItemChk(stndVO.getEngMlDistCtnt())){
				calcStr 	= errItemCalc("A", "", "1", depRptVO.getEngMlDistCtnt(), stndVO.getEngMlDistCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setEngMlDistCtnt(noPct[0]);
				rtRngVO.setEngMlDistCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getEngMlDistCtnt(), noPct[1])) && milesObsChk){
					errItmCtnt.append("ENG_ML_DIST_CTNT|");
				}
			}
			
			// 10 : PERFORMANCE : Miles In
			if(errCalcItemChk(depRptVO.getMnvrInMlDistCtnt()) && errCalcItemChk(stndVO.getMnvrInMlDistCtnt())){
				calcStr 	= errItemCalc("A", "", "1", depRptVO.getMnvrInMlDistCtnt(), stndVO.getMnvrInMlDistCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setMnvrInMlDistCtnt(noPct[0]);
				rtRngVO.setMnvrInMlDistCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getMnvrInMlDistCtnt(), noPct[1]))){
					errItmCtnt.append("MNVR_IN_ML_DIST_CTNT|");
				}
			}
			
			// 11 : PERFORMANCE : Miles Out
			if(errCalcItemChk(depRptVO.getMnvrOutMlDistCtnt()) && errCalcItemChk(stndVO.getMnvrOutMlDistCtnt())){
				calcStr 	= errItemCalc("A", "", "1", depRptVO.getMnvrOutMlDistCtnt(), stndVO.getMnvrOutMlDistCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setMnvrOutMlDistCtnt(noPct[0]);
				rtRngVO.setMnvrOutMlDistCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getMnvrOutMlDistCtnt(), noPct[1]))){
					errItmCtnt.append("MNVR_OUT_ML_DIST_CTNT|");
				}
			}
			
			// 12 : PERFORMANCE : SPD
			if(errCalcItemChk(depRptVO.getAvgSpdCtnt()) && errCalcItemChk(stndVO.getAvgSpdCtnt())){
				calcStr 	= errItemCalc("A", "1", "1", depRptVO.getAvgSpdCtnt(), stndVO.getAvgSpdCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setAvgSpdCtnt(noPct[0]);
				rtRngVO.setAvgSpdCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getAvgSpdCtnt(), noPct[1]))){
					errItmCtnt.append("AVG_SPD_CTNT|");
				}
			}
			
			// 13 : PERFORMANCE : RPM
			if(errCalcItemChk(depRptVO.getAvgRpmPwrCtnt()) && errCalcItemChk(stndVO.getAvgRpmPwrCtnt())){
				calcStr		= errItemCalc("A", "1", "1", depRptVO.getAvgRpmPwrCtnt(), stndVO.getAvgRpmPwrCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setAvgRpmPwrCtnt(noPct[0]);
				rtRngVO.setAvgRpmPwrCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getAvgRpmPwrCtnt(), noPct[1]))){
					errItmCtnt.append("AVG_RPM_PWR_CTNT|");
				}
			}
			
			// 14 : PERFORMANCE : AVG. Pro.Pitch
			if(errCalcItemChk(depRptVO.getAvgPrlrPchVal()) && errCalcItemChk(stndVO.getAvgPrlrPchVal())){
				calcStr 	= errItemCalc("A", "7", "1", depRptVO.getAvgPrlrPchVal(), stndVO.getAvgPrlrPchVal());
				noPct		= calcStr.split("\\|");
				noPct[1]	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setAvgPrlrPchVal(noPct[0]);
				rtRngVO.setAvgPrlrPchVal(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getAvgPrlrPchVal(), noPct[1]))){
					errItmCtnt.append("AVG_PRLR_PCH_VAL|");
				}
			}
			
			// 15 : PERFORMANCE : Sailing Time
			if(errCalcItemChk(depRptVO.getSailTmHrs()) && errCalcItemChk(stndVO.getSailTmHrs())){
				calcStr 	= errItemCalc("A", "1", "1", depRptVO.getSailTmHrs(), stndVO.getSailTmHrs());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setSailTmHrs(noPct[0]);
				rtRngVO.setSailTmHrs(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getSailTmHrs(), noPct[1]))){
					errItmCtnt.append("SAIL_TM_HRS|");
				}
			}
			
			// 16 : R.O.B : Rob(Arr) : F.O
			if(errCalcItemChk(depRptVO.getArrFoilCtnt()) && errCalcItemChk(stndVO.getArrFoilCtnt())){
				calcStr = errItemCalc("D", "1", "", depRptVO.getArrFoilCtnt(), stndVO.getArrFoilCtnt());
				diffVO.setArrFoilCtnt(calcStr);
				rtRngVO.setArrFoilCtnt("-");
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getArrFoilCtnt(), calcStr))){
					errItmCtnt.append("ARR_FOIL_CTNT|");
				}
			}

			// 17 : R.O.B : Rob(Arr) : LS F.O
			if(errCalcItemChk(depRptVO.getArrLowSulpFoilCtnt()) && errCalcItemChk(stndVO.getArrLowSulpFoilCtnt())){
				calcStr = errItemCalc("D", "1", "", depRptVO.getArrLowSulpFoilCtnt(), stndVO.getArrLowSulpFoilCtnt());
				diffVO.setArrLowSulpFoilCtnt(calcStr);
				rtRngVO.setArrLowSulpFoilCtnt("-");
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getArrLowSulpFoilCtnt(), calcStr))){
					errItmCtnt.append("ARR_LOW_SULP_FOIL_CTNT|");
				}
			}
			
			// 18 : R.O.B : Rob(Arr) : D.O
			if(errCalcItemChk(depRptVO.getArrDoilCtnt()) && errCalcItemChk(stndVO.getArrDoilCtnt())){
				calcStr = errItemCalc("D", "1", "", depRptVO.getArrDoilCtnt(), stndVO.getArrDoilCtnt());
				diffVO.setArrDoilCtnt(calcStr);
				rtRngVO.setArrDoilCtnt("-");
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getArrDoilCtnt(), calcStr))){
					errItmCtnt.append("ARR_DOIL_CTNT|");
				}
			}
			
			// 19 : R.O.B : Rob(Arr) : LS D.O
			if(errCalcItemChk(depRptVO.getArrLowSulpDoilCtnt()) && errCalcItemChk(stndVO.getArrLowSulpDoilCtnt())){
				calcStr = errItemCalc("D", "1", "", depRptVO.getArrLowSulpDoilCtnt(), stndVO.getArrLowSulpDoilCtnt());
				diffVO.setArrLowSulpDoilCtnt(calcStr);
				rtRngVO.setArrLowSulpDoilCtnt("-");
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getArrLowSulpDoilCtnt(), calcStr))){
					errItmCtnt.append("ARR_LOW_SULP_DOIL_CTNT|");
				}
			}
			
			// 20 : R.O.B : Rob(Dep) : F.O
			if(errCalcItemChk(depRptVO.getDepFoilCtnt()) && errCalcItemChk(stndVO.getDepFoilCtnt())){
				calcStr = errItemCalc("D", "1", "", depRptVO.getDepFoilCtnt(), stndVO.getDepFoilCtnt());
				diffVO.setDepFoilCtnt(calcStr);
				rtRngVO.setDepFoilCtnt("-");
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getDepFoilCtnt(), calcStr))){
					errItmCtnt.append("DEP_FOIL_CTNT|");
				}
			}
			
			// 21 : R.O.B : Rob(Dep) : LS F.O
			if(errCalcItemChk(depRptVO.getDepLowSulpFoilCtnt()) && errCalcItemChk(stndVO.getDepLowSulpFoilCtnt())){
				calcStr = errItemCalc("D", "1", "", depRptVO.getDepLowSulpFoilCtnt(), stndVO.getDepLowSulpFoilCtnt());
				diffVO.setDepLowSulpFoilCtnt(calcStr);
				rtRngVO.setDepLowSulpFoilCtnt("-");
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getDepLowSulpFoilCtnt(), calcStr))){
					errItmCtnt.append("DEP_LOW_SULP_FOIL_CTNT|");
				}
			}
			
			// 22 : R.O.B : Rob(Dep) : D.O
			if(errCalcItemChk(depRptVO.getDepDoilCtnt()) && errCalcItemChk(stndVO.getDepDoilCtnt())){
				calcStr = errItemCalc("D", "1", "", depRptVO.getDepDoilCtnt(), stndVO.getDepDoilCtnt());
				diffVO.setDepDoilCtnt(calcStr);
				rtRngVO.setDepDoilCtnt("-");
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getDepDoilCtnt(), calcStr))){
					errItmCtnt.append("DEP_DOIL_CTNT|");
				}
			}
			
			// 23 : R.O.B : Rob(Dep) : LS D.O
			if(errCalcItemChk(depRptVO.getDepLowSulpDoilCtnt()) && errCalcItemChk(stndVO.getDepLowSulpDoilCtnt())){
				calcStr = errItemCalc("D", "1", "", depRptVO.getDepLowSulpDoilCtnt(), stndVO.getDepLowSulpDoilCtnt());
				diffVO.setDepLowSulpDoilCtnt(calcStr);
				rtRngVO.setDepLowSulpDoilCtnt("-");
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getDepLowSulpDoilCtnt(), calcStr))){
					errItmCtnt.append("DEP_LOW_SULP_DOIL_CTNT|");
				}
			}
			
			// 28 : FUEL CONSUM. : Sea Steaming : M/E 
			if(errCalcItemChk(depRptVO.getSeaStmngMnEngTtlQty()) && errCalcItemChk(stndVO.getSeaStmngMnEngTtlQty())){
				calcStr 	= errItemCalc("A", "1", "1", depRptVO.getSeaStmngMnEngTtlQty(), stndVO.getSeaStmngMnEngTtlQty());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setSeaStmngMnEngTtlQty(noPct[0]);
				rtRngVO.setSeaStmngMnEngTtlQty(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getSeaStmngMnEngTtlQty(), noPct[1])) && milesObsChk){
					errItmCtnt.append("SEA_STMNG_MN_ENG_TTL_QTY|");
				}
			}
			
			// 29 : FUEL CONSUM. : Harbor/In Port : TTL
			if(errCalcItemChk(depRptVO.getAvgPortTtlQty()) && errCalcItemChk(stndVO.getAvgPortTtlQty())){
				calcStr 	= errItemCalc("A", "1", "1", depRptVO.getAvgPortTtlQty(), stndVO.getAvgPortTtlQty());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setAvgPortTtlQty(noPct[0]);
				rtRngVO.setAvgPortTtlQty(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getAvgPortTtlQty(), noPct[1]))){
					errItmCtnt.append("AVG_PORT_TTL_QTY|");
				}
			}
			
			// 30 : FUEL CONSUM. : AVG. HarborInport FOC/HR : TTL
			if(errCalcItemChk(depRptVO.getAvgPortTtlHrQty()) && errCalcItemChk(stndVO.getAvgPortTtlHrQty())){
				calcStr 	= errItemCalc("A", "10", "1", depRptVO.getAvgPortTtlHrQty(), stndVO.getAvgPortTtlHrQty());
				noPct		= calcStr.split("\\|");
				noPct[1]	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setAvgPortTtlHrQty(noPct[0]);
				rtRngVO.setAvgPortTtlHrQty(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getAvgPortTtlHrQty(), noPct[1]))){
					errItmCtnt.append("AVG_PORT_TTL_HR_QTY|");
				}
			}
			
			// 71 : TIME : S/B ENG ① (ETA-①)
			if(fcmUtil.isNotNull(depRptVO.getSbEngDt()) && fcmUtil.isNotNull(stndVO.getSbEngDt())){
				timeDiff	= (double) fcmUtil.dateDiff(depRptVO.getSbEngDt(), "yyyyMMddHHmm", stndVO.getSbEngDt(), "yyyyMMddHHmm", "s");
				decFmt		= new DecimalFormat("0.0");
				diffVO.setSbEngDt(decFmt.format(timeDiff / (60 * 60)));
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getSbEngDt(), diffVO.getSbEngDt()))){
					errItmCtnt.append("SB_ENG_DT|");
				}
			}
			rtRngVO.setSbEngDt("-");
			
			// 72 : TIME : P.O.B ② (②-①)
			if(fcmUtil.isNotNull(depRptVO.getSbEngDt()) && fcmUtil.isNotNull(depRptVO.getPltInDt())){
				timeDiff	= (double) fcmUtil.dateDiff(depRptVO.getSbEngDt(), "yyyyMMddHHmm", depRptVO.getPltInDt(), "yyyyMMddHHmm", "s");
				decFmt		= new DecimalFormat("0.0");
				diffVO.setPltInDt(decFmt.format(timeDiff / (60 * 60)));
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getPltInDt(), diffVO.getPltInDt()))){
					errItmCtnt.append("PLT_IN_DT|");
				}
			}
			rtRngVO.setPltInDt("-");
			
			// 73 : TIME : ANCHOR ③ (③-①)
			if(fcmUtil.isNotNull(depRptVO.getSbEngDt()) && fcmUtil.isNotNull(depRptVO.getBfrBrthAnkDrpDt())){
				timeDiff	= (double) fcmUtil.dateDiff(depRptVO.getSbEngDt(), "yyyyMMddHHmm", depRptVO.getBfrBrthAnkDrpDt(), "yyyyMMddHHmm", "s");
				decFmt		= new DecimalFormat("0.0");
				diffVO.setBfrBrthAnkDrpDt(decFmt.format(timeDiff / (60 * 60)));
				
				if("SIM".equals(searchType) && (!simErrItmChk("ZP",errSetVO.getBfrBrthAnkDrpDt(), diffVO.getBfrBrthAnkDrpDt()))){
					errItmCtnt.append("BFR_BRTH_ANK_DRP_DT|");
				}
			}
			rtRngVO.setBfrBrthAnkDrpDt("-");
			
			// 74 : TIME : ANCHOR AWAY ④ (④-③)
			if(fcmUtil.isNotNull(depRptVO.getBfrBrthAnkDrpDt()) && fcmUtil.isNotNull(depRptVO.getBfrBrthAnkOffDt())){
				timeDiff	= (double) fcmUtil.dateDiff(depRptVO.getBfrBrthAnkDrpDt(), "yyyyMMddHHmm", depRptVO.getBfrBrthAnkOffDt(), "yyyyMMddHHmm", "s");
				decFmt		= new DecimalFormat("0.0");
				diffVO.setBfrBrthAnkOffDt(decFmt.format(timeDiff / (60 * 60)));
				
				if("SIM".equals(searchType) && (!simErrItmChk("ZP",errSetVO.getBfrBrthAnkOffDt(), diffVO.getBfrBrthAnkOffDt()))){
					errItmCtnt.append("BFR_BRTH_ANK_OFF_DT|");
				}
			}
			rtRngVO.setBfrBrthAnkOffDt("-");
			
			// 75 : TIME : FIRST LINE ⑤ (ETB-⑤)
			if(fcmUtil.isNotNull(depRptVO.getVpsEtbDt()) && fcmUtil.isNotNull(stndVO.getVpsEtbDt())){
				timeDiff	= (double) fcmUtil.dateDiff(depRptVO.getVpsEtbDt(), "yyyyMMddHHmm", stndVO.getVpsEtbDt(), "yyyyMMddHHmm", "s");
				decFmt		= new DecimalFormat("0.0");
				diffVO.setVpsEtbDt(decFmt.format(timeDiff / (60 * 60)));
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getVpsEtbDt(), diffVO.getVpsEtbDt()))){
					errItmCtnt.append("VPS_ETB_DT|");
				}
			}
			rtRngVO.setVpsEtbDt("-");
			
			// 76 : TIME : COMM'CED WKG ⑥ (⑥-⑤)
			// 1st : COMM'CED WKG - FIRST LINE [CGO_WRK_ST_DT - VPS_ETB_DT]
			// 2nd : [Error RPT의 FIRST LINE] 시간이 없는 경우 
			//       COMM'CED WKG - S/B ENG ① [CGO_WRK_ST_DT - SB_ENG_DT]
			if(fcmUtil.isNotNull(depRptVO.getCgoWrkStDt())){
				decFmt = new DecimalFormat("0.0");
				if(fcmUtil.isNotNull(depRptVO.getVpsEtbDt())){
					timeDiff = (double) fcmUtil.dateDiff(depRptVO.getVpsEtbDt(), "yyyyMMddHHmm", depRptVO.getCgoWrkStDt(), "yyyyMMddHHmm", "s");
					diffVO.setCgoWrkStDt(decFmt.format(timeDiff / (60 * 60)));
				}else if(fcmUtil.isNull(depRptVO.getVpsEtbDt()) && fcmUtil.isNotNull(depRptVO.getSbEngDt())){
					timeDiff = (double) fcmUtil.dateDiff(depRptVO.getSbEngDt(), "yyyyMMddHHmm", depRptVO.getCgoWrkStDt(), "yyyyMMddHHmm", "s");
					diffVO.setCgoWrkStDt(decFmt.format(timeDiff / (60 * 60)));
				}
				
				if("SIM".equals(searchType) && (!simErrItmChk("ZP",errSetVO.getCgoWrkStDt(), diffVO.getCgoWrkStDt()))){
					errItmCtnt.append("CGO_WRK_ST_DT|");
				}
				
			}
			rtRngVO.setCgoWrkStDt("-");
			
			// 77 : TIME : COMP'TED WKG ⑦ (⑦-⑥)
			if(fcmUtil.isNotNull(depRptVO.getCgoWrkStDt()) && fcmUtil.isNotNull(depRptVO.getCgoWrkEndDt())){
				timeDiff	= (double) fcmUtil.dateDiff(depRptVO.getCgoWrkStDt(), "yyyyMMddHHmm", depRptVO.getCgoWrkEndDt(), "yyyyMMddHHmm", "s");
				decFmt		= new DecimalFormat("0.0");
				diffVO.setCgoWrkEndDt(decFmt.format(timeDiff / (60 * 60)));
				
				if("SIM".equals(searchType) && (!simErrItmChk("ZP",errSetVO.getCgoWrkEndDt(), diffVO.getCgoWrkEndDt()))){
					errItmCtnt.append("CGO_WRK_END_DT|");
				}
			}
			rtRngVO.setCgoWrkEndDt("-");
			
			// 78 : TIME : LAST LINE ⑧ (ETD-⑧)
			if(fcmUtil.isNotNull(depRptVO.getVpsEtdDt()) && fcmUtil.isNotNull(stndVO.getVpsEtdDt())){
				timeDiff	= (double) fcmUtil.dateDiff(depRptVO.getVpsEtdDt(), "yyyyMMddHHmm", stndVO.getVpsEtdDt(), "yyyyMMddHHmm", "s");
				decFmt		= new DecimalFormat("0.0");
				diffVO.setVpsEtdDt(decFmt.format(timeDiff / (60 * 60)));
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getVpsEtdDt(), diffVO.getVpsEtdDt()))){
					errItmCtnt.append("VPS_ETD_DT|");
				}
			}
			rtRngVO.setVpsEtdDt("-");
			
			// 79 : TIME : DROP ANCHOR ⑨ (⑨-⑧)
			// 1st : DROP ANCHOR ⑨ (⑨-⑧) - LAST LINE ⑧ (ETD-⑧) [AFT_UNBRTH_ANK_DRP_DT - VPS_ETD_DT]
			// 2nd : [Error RPT의 LAST LINE] 시간이 없는 경우 
			//       DROP ANCHOR ⑨ (⑨-⑧) - S/B ENG ① [AFT_UNBRTH_ANK_DRP_DT - SB_ENG_DT]
			if(fcmUtil.isNotNull(depRptVO.getAftUnbrthAnkDrpDt())){
				decFmt = new DecimalFormat("0.0");
				if(fcmUtil.isNotNull(depRptVO.getVpsEtdDt())){
					timeDiff = (double) fcmUtil.dateDiff(depRptVO.getVpsEtdDt(), "yyyyMMddHHmm", depRptVO.getAftUnbrthAnkDrpDt(), "yyyyMMddHHmm", "s");
					diffVO.setAftUnbrthAnkDrpDt(decFmt.format(timeDiff / (60 * 60)));
				}else if(fcmUtil.isNull(depRptVO.getVpsEtdDt()) && fcmUtil.isNotNull(depRptVO.getSbEngDt())){
					timeDiff = (double) fcmUtil.dateDiff(depRptVO.getSbEngDt(), "yyyyMMddHHmm", depRptVO.getAftUnbrthAnkDrpDt(), "yyyyMMddHHmm", "s");
					diffVO.setAftUnbrthAnkDrpDt(decFmt.format(timeDiff / (60 * 60)));
				}
				
				if("SIM".equals(searchType) && (!simErrItmChk("ZP",errSetVO.getAftUnbrthAnkDrpDt(), diffVO.getAftUnbrthAnkDrpDt()))){
					errItmCtnt.append("AFT_UNBRTH_ANK_DRP_DT|");
				}
			}
			rtRngVO.setAftUnbrthAnkDrpDt("-");
			
			// 80 : TIME : ANCHOR AWAY ⑩ (⑩-⑨)
			// 1st : ANCHOR AWAY ⑩ (⑩-⑨) - DROP ANCHOR ⑨ (⑨-⑧) [AFT_UNBRTH_ANK_OFF_DT - AFT_UNBRTH_ANK_DRP_DT]
			// 2nd : [Error RPT의 DROP ANCHOR] 시간이 없는 경우
			//       ANCHOR AWAY ⑩ (⑩-⑨) - S/B ENG ① [AFT_UNBRTH_ANK_OFF_DT - SB_ENG_DT]
			if(fcmUtil.isNotNull(depRptVO.getAftUnbrthAnkOffDt())){
				decFmt = new DecimalFormat("0.0");
				if(fcmUtil.isNotNull(depRptVO.getAftUnbrthAnkDrpDt())){
					timeDiff = (double) fcmUtil.dateDiff(depRptVO.getAftUnbrthAnkDrpDt(), "yyyyMMddHHmm", depRptVO.getAftUnbrthAnkOffDt(), "yyyyMMddHHmm", "s");
					diffVO.setAftUnbrthAnkOffDt(decFmt.format(timeDiff / (60 * 60)));
				}else if(fcmUtil.isNull(depRptVO.getAftUnbrthAnkDrpDt()) && fcmUtil.isNotNull(depRptVO.getSbEngDt())){
					timeDiff = (double) fcmUtil.dateDiff(depRptVO.getSbEngDt(), "yyyyMMddHHmm", depRptVO.getAftUnbrthAnkOffDt(), "yyyyMMddHHmm", "s");
					diffVO.setAftUnbrthAnkOffDt(decFmt.format(timeDiff / (60 * 60)));
				}
				
				if("SIM".equals(searchType) && (!simErrItmChk("ZP",errSetVO.getAftUnbrthAnkOffDt(), diffVO.getAftUnbrthAnkOffDt()))){
					errItmCtnt.append("AFT_UNBRTH_ANK_OFF_DT|");
				}
			}
			rtRngVO.setAftUnbrthAnkOffDt("-");
			
			// 81 : TIME : PILOT AWAY ⑪ (⑪-⑧)
			// 1st : PILOT AWAY ⑪ (⑪-⑧) - LAST LINE ⑧ (ETD-⑧) [PLT_OUT_DT - VPS_ETD_DT]
			// 2nd : [Error RPT의 LAST LINE] 시간이 없는 경우
			//       PILOT AWAY ⑪ (⑪-⑧) - S/B ENG ① [PLT_OUT_DT - SB_ENG_DT]
			if(fcmUtil.isNotNull(depRptVO.getPltOutDt())){
				decFmt = new DecimalFormat("0.0");
				if(fcmUtil.isNotNull(depRptVO.getVpsEtdDt())){
					timeDiff = (double) fcmUtil.dateDiff(depRptVO.getVpsEtdDt(), "yyyyMMddHHmm", depRptVO.getPltOutDt(), "yyyyMMddHHmm", "s");
					diffVO.setPltOutDt(decFmt.format(timeDiff / (60 * 60)));
				}else if(fcmUtil.isNull(depRptVO.getVpsEtdDt()) && fcmUtil.isNotNull(depRptVO.getSbEngDt())){
					timeDiff = (double) fcmUtil.dateDiff(depRptVO.getSbEngDt(), "yyyyMMddHHmm", depRptVO.getPltOutDt(), "yyyyMMddHHmm", "s");
					diffVO.setPltOutDt(decFmt.format(timeDiff / (60 * 60)));
				}
				
				if("SIM".equals(searchType) && (!simErrItmChk("ZE",errSetVO.getPltOutDt(), diffVO.getPltOutDt()))){
					errItmCtnt.append("PLT_OUT_DT|");
				}
			}
			rtRngVO.setPltOutDt("-");
			
			// 82 : TIME : R/UP ENG ⑫ (⑫-⑪)
			// 1st : R/UP ENG ⑫ (⑫-⑪) - PILOT AWAY ⑪ (⑪-⑧) [RUP_DT - PLT_OUT_DT]
			// 2nd : [Error RPT의 R/UP ENG ⑫ (⑫-⑪)]가 없는 경우
			//       R/UP ENG ⑫ (⑫-⑪) - LAST LINE ⑧ (ETD-⑧) [RUP_DT - VPS_ETD_DT]
			// 3rd : [Error RPT의 PILOT AWAY]도 없는 경우
			//       R/UP ENG ⑫ (⑫-⑪) - S/B ENG ① [RUP_DT - SB_ENG_DT]
			if(fcmUtil.isNotNull(depRptVO.getRupDt())){
				decFmt	= new DecimalFormat("0.0");
				if(fcmUtil.isNotNull(depRptVO.getPltOutDt())){
					timeDiff = (double) fcmUtil.dateDiff(depRptVO.getPltOutDt(), "yyyyMMddHHmm", depRptVO.getRupDt(), "yyyyMMddHHmm", "s");
					diffVO.setRupDt(decFmt.format(timeDiff / (60 * 60)));
				}else if(fcmUtil.isNull(depRptVO.getPltOutDt()) && fcmUtil.isNotNull(depRptVO.getVpsEtdDt())){
					timeDiff = (double) fcmUtil.dateDiff(depRptVO.getVpsEtdDt(), "yyyyMMddHHmm", depRptVO.getRupDt(), "yyyyMMddHHmm", "s");
					diffVO.setRupDt(decFmt.format(timeDiff / (60 * 60)));
				}else if(fcmUtil.isNull(depRptVO.getPltOutDt()) && fcmUtil.isNull(depRptVO.getVpsEtdDt()) && fcmUtil.isNotNull(depRptVO.getSbEngDt())){
					timeDiff = (double) fcmUtil.dateDiff(depRptVO.getSbEngDt(), "yyyyMMddHHmm", depRptVO.getRupDt(), "yyyyMMddHHmm", "s");
					diffVO.setRupDt(decFmt.format(timeDiff / (60 * 60)));
				}
				
				if("SIM".equals(searchType) && (!simErrItmChk("ZE",errSetVO.getRupDt(), diffVO.getRupDt()))){
					errItmCtnt.append("RUP_DT|");
				}
			}
			rtRngVO.setRupDt("-");
			
			// 92~95 Dep Report Data 없을경우 0 으로 입력하고 계산함
			// CARGO : On Board CNTR : Full, Em'ty, Total, Cargo Weight
			
			// 92 : CARGO : On Board CNTR : Full
			if(errCalcItemChk(depRptVO.getFcntrObrdTeuCtnt()) && errCalcItemChk(stndVO.getFcntrObrdTeuCtnt())){
				calcStr 	= errItemCalc("A", "", "2", depRptVO.getFcntrObrdTeuCtnt(), stndVO.getFcntrObrdTeuCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setFcntrObrdTeuCtnt(noPct[0]);
				rtRngVO.setFcntrObrdTeuCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getFcntrObrdTeuCtnt(), noPct[1]))){
					errItmCtnt.append("FCNTR_OBRD_TEU_CTNT|");
				}
			}else if (fcmUtil.isNull(depRptVO.getFcntrObrdTeuCtnt()) && errCalcItemChk(stndVO.getFcntrObrdTeuCtnt())){
				calcStr 	= errItemCalc("A", "", "2", "0", stndVO.getFcntrObrdTeuCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setFcntrObrdTeuCtnt(noPct[0]);
				rtRngVO.setFcntrObrdTeuCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getFcntrObrdTeuCtnt(), noPct[1]))){
					errItmCtnt.append("FCNTR_OBRD_TEU_CTNT|");
				}
			}
			
			// 93 : CARGO : On Board CNTR : Em'ty
			if(errCalcItemChk(depRptVO.getMcntrObrdTeuCtnt()) && errCalcItemChk(stndVO.getMcntrObrdTeuCtnt())){
				calcStr 	= errItemCalc("A", "", "2", depRptVO.getMcntrObrdTeuCtnt(), stndVO.getMcntrObrdTeuCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setMcntrObrdTeuCtnt(noPct[0]);
				rtRngVO.setMcntrObrdTeuCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getMcntrObrdTeuCtnt(), noPct[1]))){
					errItmCtnt.append("MCNTR_OBRD_TEU_CTNT|");
				}
			}else if(fcmUtil.isNull(depRptVO.getMcntrObrdTeuCtnt()) && errCalcItemChk(stndVO.getMcntrObrdTeuCtnt())){
				calcStr 	= errItemCalc("A", "", "2", "0", stndVO.getMcntrObrdTeuCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setMcntrObrdTeuCtnt(noPct[0]);
				rtRngVO.setMcntrObrdTeuCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getMcntrObrdTeuCtnt(), noPct[1]))){
					errItmCtnt.append("MCNTR_OBRD_TEU_CTNT|");
				}
			}
			
			// 94 : CARGO : On Board CNTR : Total
			if(errCalcItemChk(depRptVO.getTtlCntrObrdTeuCtnt()) && errCalcItemChk(stndVO.getTtlCntrObrdTeuCtnt())){
				calcStr 	= errItemCalc("A", "", "2", depRptVO.getTtlCntrObrdTeuCtnt(), stndVO.getTtlCntrObrdTeuCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setTtlCntrObrdTeuCtnt(noPct[0]);
				rtRngVO.setTtlCntrObrdTeuCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getTtlCntrObrdTeuCtnt(), noPct[1]))){
					errItmCtnt.append("TTL_CNTR_OBRD_TEU_CTNT|");
				}
			}else if(fcmUtil.isNull(depRptVO.getTtlCntrObrdTeuCtnt()) && errCalcItemChk(stndVO.getTtlCntrObrdTeuCtnt())){
				calcStr 	= errItemCalc("A", "", "2", "0", stndVO.getTtlCntrObrdTeuCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setTtlCntrObrdTeuCtnt(noPct[0]);
				rtRngVO.setTtlCntrObrdTeuCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getTtlCntrObrdTeuCtnt(), noPct[1]))){
					errItmCtnt.append("TTL_CNTR_OBRD_TEU_CTNT|");
				}
			}
			
			// 95 : CARGO : On Board CNTR : Cargo Weight
			if(errCalcItemChk(depRptVO.getDepCgoCtnt()) && errCalcItemChk(stndVO.getDepCgoCtnt())){
				calcStr 	= errItemCalc("A", "", "2", depRptVO.getDepCgoCtnt(), stndVO.getDepCgoCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setDepCgoCtnt(noPct[0]);
				rtRngVO.setDepCgoCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getDepCgoCtnt(), noPct[1]))){
					errItmCtnt.append("DEP_CGO_CTNT|");
				}
			}else if(fcmUtil.isNull(depRptVO.getDepCgoCtnt()) && errCalcItemChk(stndVO.getDepCgoCtnt())){
				calcStr 	= errItemCalc("A", "", "2", "0", stndVO.getDepCgoCtnt());
				noPct		= calcStr.split("\\|");
				noPct[1] 	= "0".equals(noPct[1]) ? "" : noPct[1];
				diffVO.setDepCgoCtnt(noPct[0]);
				rtRngVO.setDepCgoCtnt(noPct[1]);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getDepCgoCtnt(), noPct[1]))){
					errItmCtnt.append("DEP_CGO_CTNT|");
				}
			}
			
			// 97~99 Dep Report Data 없을경우 0 으로 입력하고 계산함
			// CARGO : R/F CNTR : Disch., Load, On Board
			
			// 97 : CARGO : R/F CNTR : Disch
			if(errCalcItemChk(depRptVO.getRfCntrDchgKntCtnt()) && errCalcItemChk(stndVO.getRfCntrDchgKntCtnt())){
				calcStr = errItemCalc("D", "", "", depRptVO.getRfCntrDchgKntCtnt(), stndVO.getRfCntrDchgKntCtnt());
				diffVO.setRfCntrDchgKntCtnt(calcStr);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getRfCntrDchgKntCtnt(), calcStr))){
					errItmCtnt.append("RF_CNTR_DCHG_KNT_CTNT|");
				}
			}else if(fcmUtil.isNull(depRptVO.getRfCntrDchgKntCtnt()) && errCalcItemChk(stndVO.getRfCntrDchgKntCtnt())){
				calcStr = errItemCalc("D", "", "", depRptVO.getRfCntrDchgKntCtnt(), stndVO.getRfCntrDchgKntCtnt());
				diffVO.setRfCntrDchgKntCtnt(calcStr);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getRfCntrDchgKntCtnt(), calcStr))){
					errItmCtnt.append("RF_CNTR_DCHG_KNT_CTNT|");
				}
			}
			rtRngVO.setRfCntrDchgKntCtnt("-");
			
			// 98 : CARGO : R/F CNTR : Load
			if(errCalcItemChk(depRptVO.getRfCntrLodKntCtnt()) && errCalcItemChk(stndVO.getRfCntrLodKntCtnt())){
				calcStr = errItemCalc("D", "", "", depRptVO.getRfCntrLodKntCtnt(), stndVO.getRfCntrLodKntCtnt());
				diffVO.setRfCntrLodKntCtnt(calcStr);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getRfCntrLodKntCtnt(), calcStr))){
					errItmCtnt.append("RF_CNTR_LOD_KNT_CTNT|");
				}
			}else if(fcmUtil.isNull(depRptVO.getRfCntrLodKntCtnt()) && errCalcItemChk(stndVO.getRfCntrLodKntCtnt())){
				calcStr = errItemCalc("D", "", "", depRptVO.getRfCntrLodKntCtnt(), stndVO.getRfCntrLodKntCtnt());
				diffVO.setRfCntrLodKntCtnt(calcStr);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getRfCntrLodKntCtnt(), calcStr))){
					errItmCtnt.append("RF_CNTR_LOD_KNT_CTNT|");
				}
			}
			rtRngVO.setRfCntrLodKntCtnt("-");
			
			// 99 : CARGO : R/F CNTR : On Board
			if(errCalcItemChk(depRptVO.getRfCntrObrdKntCtnt()) && errCalcItemChk(stndVO.getRfCntrObrdKntCtnt())){
				calcStr = errItemCalc("D", "", "", depRptVO.getRfCntrObrdKntCtnt(), stndVO.getRfCntrObrdKntCtnt());
				diffVO.setRfCntrObrdKntCtnt(calcStr);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getRfCntrObrdKntCtnt(), calcStr))){
					errItmCtnt.append("RF_CNTR_OBRD_KNT_CTNT|");
				}
			}else if(fcmUtil.isNull(depRptVO.getRfCntrObrdKntCtnt()) && errCalcItemChk(stndVO.getRfCntrObrdKntCtnt())){
				calcStr = errItemCalc("D", "", "", depRptVO.getRfCntrObrdKntCtnt(), stndVO.getRfCntrObrdKntCtnt());
				diffVO.setRfCntrObrdKntCtnt(calcStr);
				
				if("SIM".equals(searchType) && (!simErrItmChk("PM",errSetVO.getRfCntrObrdKntCtnt(), calcStr))){
					errItmCtnt.append("RF_CNTR_OBRD_KNT_CTNT|");
				}
			}
			rtRngVO.setRfCntrObrdKntCtnt("-");
			
			if(depRptVO != null){
				// simulation 이고 errItmCtnt 에 적용할 항목이 있을때
				if("SIM".equals(searchType) && !"".equals(errItmCtnt.toString())){
					depRptVO.setErrItmCtnt(errItmCtnt.toString().toLowerCase());
				}
				rtnVOList.add(0, depRptVO);
			}else{
				rtnVOList.add(0, new FcmDepRptErrClsVO());
			}
			
			if(stndVO != null){
				rtnVOList.add(1, stndVO);
			}else{
				rtnVOList.add(1, new FcmDepRptErrClsVO());
			}
			
			rtnVOList.add(2, diffVO);
			rtnVOList.add(3, rtRngVO);
			
			return rtnVOList;
      } catch (Exception ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Item Error Correction"}).getMessage(), ex);
		}
	}
	
	/**
	 * Departure Report merge, Cleansing History insert
	 * @param fcmDepRptErrClsVO
	 * @param account
	 * @throws EventException
	 */
	public void multiFcmDepRptErrCls(FcmDepRptErrClsVO fcmDepRptErrClsVO, SignOnUserAccount account) throws EventException {
		try {
			String arrFrshWtrWgt	= "";
			String arrBlstWgt		= "";
			String depFrshWtrWgt	= "";
			String depBlstWgt		= "";
			String splFoilBrgWgt1	= "";
			String splFoilBrgWgt2	= "";
			String splDoilBrgWgt1	= "";
			String splDoilBrgWgt2	= "";
			String splFrshWtrActWgt	= "";
			String splLowSulpFoilBrgWgt1	= "";
			String splLowSulpFoilBrgWgt2	= "";
			String splLowSulpDoilBrgWgt1	= "";
			String splLowSulpDoilBrgWgt2	= "";
			
			StringBuffer arrDrftCtnt = new StringBuffer();
			StringBuffer arrRobCtnt = new StringBuffer();
			StringBuffer depRobCtnt = new StringBuffer();
			StringBuffer depDrftCtnt = new StringBuffer();
			StringBuffer seaFuelCsmCtnt = new StringBuffer();
			StringBuffer seaLowSulpFuelCsmCtnt = new StringBuffer();
			StringBuffer portFuelCsmCtnt = new StringBuffer();
			StringBuffer portLowSulpFuelCsmCtnt = new StringBuffer();
			StringBuffer splOilCtnt = new StringBuffer();
			StringBuffer splLowSulpOilCtnt = new StringBuffer();
			StringBuffer cntrCgoCtnt = new StringBuffer();
			
			// Departure Report Log 테이블에서 기본 정보 추출
			FcmDepRptErrVO fcmDepRptErrVO = new FcmDepRptErrVO();
			
			if(fcmDepRptErrClsVO != null){
				fcmDepRptErrVO.setRcvDt(fcmDepRptErrClsVO.getRcvDt());
				fcmDepRptErrVO.setRcvSeq(fcmDepRptErrClsVO.getRcvSeq());
			}
			
			FcmDepRptLogVO fcmDepRptLogVO = dbDao.searchDepRptLog(fcmDepRptErrVO);
			
			// 화면에서 변경 된 값으로 PK 값 셋팅
			fcmDepRptLogVO.setVslCd(fcmDepRptErrClsVO.getVslCd());
			fcmDepRptLogVO.setVoyDirCd(fcmDepRptErrClsVO.getSkdVoyNo());
			fcmDepRptLogVO.setDepPortCd(fcmDepRptErrClsVO.getDepPortCd());
			String clptIndSeq = null;
			if ("1".equals(fcmDepRptErrClsVO.getClptIndSeq())) {
				clptIndSeq = "F";
			} else if ("2".equals(fcmDepRptErrClsVO.getClptIndSeq())) {
				clptIndSeq = "S";
			} else if ("3".equals(fcmDepRptErrClsVO.getClptIndSeq())) {
				clptIndSeq = "T";
			}
			fcmDepRptLogVO.setClptIndSeq(clptIndSeq);
			
			// 5	Lane	VSL_SLAN_CD
			fcmDepRptLogVO.setVslSlanCd(fcmDepRptErrClsVO.getVslSlanCd());
			
			// 67	Destination - Next Port	NXT_PORT_CD
			fcmDepRptLogVO.setNxtPortCd(fcmDepRptErrClsVO.getNxtPortCd());
			
			// 69	Destination - Togo Mile	RMN_DIST_CTNT
			fcmDepRptLogVO.setRmnDist(fcmDepRptErrClsVO.getRmnDistCtnt());
			
			// 70	Destination - Togo Speed	RMN_AVG_SPD_CTNT
			fcmDepRptLogVO.setRmnAvgSpd(fcmDepRptErrClsVO.getRmnAvgSpdCtnt());
			
			// 68	Destination - ETA	NXT_PORT_ETA_DT
			fcmDepRptLogVO.setNxtPortEtaDt(fcmDepRptErrClsVO.getNxtPortEtaDt());
			
			// 71	Time - S/B ENG	SB_ENG_DT
			fcmDepRptLogVO.setSbEngDt(fcmDepRptErrClsVO.getSbEngDt());
			
			// 72	Time - P.O.B	PLT_IN_DT
			fcmDepRptLogVO.setPltInDt(fcmDepRptErrClsVO.getPltInDt());
			
			// 73	Time - Drop Anchor	BFR_BRTH_ANK_DRP_DT
			fcmDepRptLogVO.setBfrBrthAnkDrpDt(fcmDepRptErrClsVO.getBfrBrthAnkDrpDt());
			
			// 74	Time - Anchor Away	BFR_BRTH_ANK_OFF_DT
			fcmDepRptLogVO.setBfrBrthAnkOffDt(fcmDepRptErrClsVO.getBfrBrthAnkOffDt());
			
			// 75	Time - First Line	VPS_ETB_DT
			fcmDepRptLogVO.setVpsEtbDt(fcmDepRptErrClsVO.getVpsEtbDt());
			
			// 76	Time - Comm'ced Work	CGO_WRK_ST_DT
			fcmDepRptLogVO.setCgoWrkStDt(fcmDepRptErrClsVO.getCgoWrkStDt());
			
			// 77	Time - Comp'ted Work	CGO_WRK_END_DT
			fcmDepRptLogVO.setCgoWrkEndDt(fcmDepRptErrClsVO.getCgoWrkEndDt());
			
			// 78	Time - Last Line	VPS_ETD_DT
			fcmDepRptLogVO.setVpsEtdDt(fcmDepRptErrClsVO.getVpsEtdDt());
			
			// 79	Time - Drop Anchor	AFT_UNBRTH_ANK_DRP_DT
			fcmDepRptLogVO.setAftUnbrthAnkDrpDt(fcmDepRptErrClsVO.getAftUnbrthAnkDrpDt());
			
			// 80	Time - Anchor Away	AFT_UNBRTH_ANK_OFF_DT
			fcmDepRptLogVO.setAftUnbrthAnkOffDt(fcmDepRptErrClsVO.getAftUnbrthAnkOffDt());
			
			// 81	Time - Pilot Away	PLT_OUT_DT
			fcmDepRptLogVO.setPltOutDt(fcmDepRptErrClsVO.getPltOutDt());
			
			// 82	Time - R/Up Engine	RUP_DT
			fcmDepRptLogVO.setRupDt(fcmDepRptErrClsVO.getRupDt());

			// 10	PERFORMANCE : Miles In	MNVR_IN_ML_DIST_CTNT
			fcmDepRptLogVO.setMnvrInMlDist(fcmDepRptErrClsVO.getMnvrInMlDistCtnt());
			
			// 11	PERFORMANCE : Miles Out	MNVR_OUT_ML_DIST_CTNT
			fcmDepRptLogVO.setMnvrOutMlDist(fcmDepRptErrClsVO.getMnvrOutMlDistCtnt());
			
			// 8	PERFORMANCE : Miles Obs	NVGT_ML_DIST_CTNT
			fcmDepRptLogVO.setNvgtMlDist(fcmDepRptErrClsVO.getNvgtMlDistCtnt());
			
			// 9	PERFORMANCE : Miles Eng	ENG_ML_DIST_CTNT
			fcmDepRptLogVO.setEngMlDist(fcmDepRptErrClsVO.getEngMlDistCtnt());
			
			// 12	PERFORMANCE : SPD	AVG_SPD_CTNT
			fcmDepRptLogVO.setAvgSpd(fcmDepRptErrClsVO.getAvgSpdCtnt());
			
			// 13	PERFORMANCE : RPM	AVG_RPM_PWR_CTNT
			fcmDepRptLogVO.setAvgRpmPwr(fcmDepRptErrClsVO.getAvgRpmPwrCtnt());
			
			// arr_drft_ctnt
			arrDrftCtnt.append(fcmDepRptErrClsVO.getArrFwddrCtnt()).append("|");	// 84	CONDITION : Draft(Arr) : FWD	ARR_FWDDR_CTNT
			arrDrftCtnt.append(fcmDepRptErrClsVO.getArrMidDrftCtnt()).append("|");	// 85	CONDITION : Draft(Arr) : MID	ARR_MID_DRFT_CTNT
			arrDrftCtnt.append(fcmDepRptErrClsVO.getArrAftdrCtnt()).append("|");	// 86	CONDITION : Draft(Arr) : AFT	ARR_AFTDR_CTNT
			arrDrftCtnt.append(fcmDepRptErrClsVO.getArrGmCtnt()).append("|");		// 87	CONDITION : Draft(Arr) : GM	ARR_GM_CTNT
			fcmDepRptLogVO.setArrDrftCtnt(arrDrftCtnt.toString());
			
			// arr_rob_ctnt
			// FCM_DEP_RPT_LOG TABLE DATA
			List<String> arrRobCtntList = FCMGeneralUtil.convertListByString(fcmDepRptLogVO.getArrRobCtnt(), "|");
			if (arrRobCtntList.size() > 2) {
				arrFrshWtrWgt = (String) arrRobCtntList.get(2);
			}
			if (arrRobCtntList.size() > 3) {
				arrBlstWgt = (String) arrRobCtntList.get(3);
			}
			
			arrRobCtnt.append(fcmDepRptErrClsVO.getArrFoilCtnt()).append("|");	// 16	R.O.B : Rob(Arr) F.O	ARR_FOIL_CTNT
			arrRobCtnt.append(fcmDepRptErrClsVO.getArrDoilCtnt()).append("|");	// 18	R.O.B : Rob(Arr) D.O	ARR_DOIL_CTNT
			arrRobCtnt.append(arrFrshWtrWgt).append("|");
			arrRobCtnt.append(arrBlstWgt).append("|");
			arrRobCtnt.append(fcmDepRptErrClsVO.getArrLowSulpFoilCtnt()).append("|");	// 17	R.O.B : Rob(Arr) LS F.O	ARR_LOW_SULP_FOIL_CTNT
			arrRobCtnt.append(fcmDepRptErrClsVO.getArrLowSulpDoilCtnt()).append("|");	// 19	R.O.B : Rob(Arr) LS D.O	ARR_LOW_SULP_DOIL_CTNT
			fcmDepRptLogVO.setArrRobCtnt(arrRobCtnt.toString());
			
			// dep_drft_ctnt
			depDrftCtnt.append(fcmDepRptErrClsVO.getDepFwddrCtnt()).append("|");	// 88	CONDITION : Draft(Dep) : FWD	DEP_FWDDR_CTNT
			depDrftCtnt.append(fcmDepRptErrClsVO.getDepMidDrftCtnt()).append("|");	// 89	CONDITION : Draft(Dep) : MID	DEP_MID_DRFT_CTNT
			depDrftCtnt.append(fcmDepRptErrClsVO.getDepAftdrCtnt()).append("|");	// 90	CONDITION : Draft(Dep) : AFT	DEP_AFTDR_CTNT
			depDrftCtnt.append(fcmDepRptErrClsVO.getDepGmCtnt()).append("|");		// 91	CONDITION : Draft(Dep) : GM	DEP_GM_CTNT
			fcmDepRptLogVO.setDepDrftCtnt(depDrftCtnt.toString());
			
			// dep_rob_ctnt
			// FCM_DEP_RPT_LOG TABLE DATA
			List<String> depRobCtntList = FCMGeneralUtil.convertListByString(fcmDepRptLogVO.getDepRobCtnt(), "|");
			if (depRobCtntList.size() > 2) {
				depFrshWtrWgt = (String) depRobCtntList.get(2);
			}
			if (depRobCtntList.size() > 3) {
				depBlstWgt = (String) depRobCtntList.get(3);
			}
			
			depRobCtnt.append(fcmDepRptErrClsVO.getDepFoilCtnt()).append("|");	// 20	R.O.B : Rob(Dep) F.O	DEP_FOIL_CTNT
			depRobCtnt.append(fcmDepRptErrClsVO.getDepDoilCtnt()).append("|");	// 22	R.O.B : Rob(Dep) D.O	DEP_DOIL_CTNT
			depRobCtnt.append(depFrshWtrWgt).append("|");
			depRobCtnt.append(depBlstWgt).append("|");
			depRobCtnt.append(fcmDepRptErrClsVO.getDepLowSulpFoilCtnt()).append("|");	// 21	R.O.B : Rob(Dep) LS F.O	DEP_LOW_SULP_FOIL_CTNT
			depRobCtnt.append(fcmDepRptErrClsVO.getDepLowSulpDoilCtnt()).append("|");	// 23	R.O.B : Rob(Dep) LS D.O	DEP_LOW_SULP_DOIL_CTNT
			fcmDepRptLogVO.setDepRobCtnt(depRobCtnt.toString());
			
			// sea_fuel_csm_ctnt
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaMnFoilCtnt()).append("|");	// 31	FUEL CONSUM. : Sea Steaming - F.O M/E	SEA_MN_FOIL_CTNT
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaGnrFoilCtnt()).append("|");	// 32	FUEL CONSUM. : Sea Steaming - F.O G/E	SEA_GNR_FOIL_CTNT
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaBlrFoilCtnt()).append("|");	// 33	FUEL CONSUM. : Sea Steaming - F.O BLR	SEA_BLR_FOIL_CTNT
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaMnDoilCtnt()).append("|");	// 37	FUEL CONSUM. : Sea Steaming - D.O M/E	SEA_MN_DOIL_CTNT
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaGnrDoilCtnt()).append("|");	// 38	FUEL CONSUM. : Sea Steaming - D.O G/E	SEA_GNR_DOIL_CTNT
			seaFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaBlrDoilCtnt()).append("|");	// 39	FUEL CONSUM. : Sea Steaming - D.O BLR	SEA_BLR_DOIL_CTNT
			fcmDepRptLogVO.setSeaFuelCsmCtnt(seaFuelCsmCtnt.toString());
			
			// sea_low_sulp_fuel_csm_ctnt
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaMnLowSulpFoilCtnt()).append("|");	// 34	FUEL CONSUM. : Sea Steaming - LS F.O M/E	SEA_MN_LOW_SULP_FOIL_CTNT
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaGnrLowSulpFoilCtnt()).append("|");	// 35	FUEL CONSUM. : Sea Steaming - LS F.O G/E	SEA_GNR_LOW_SULP_FOIL_CTNT
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaBlrLowSulpFoilCtnt()).append("|");	// 36	FUEL CONSUM. : Sea Steaming - LS F.O BLR	SEA_BLR_LOW_SULP_FOIL_CTNT
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaMnLowSulpDoilCtnt()).append("|");	// 40	FUEL CONSUM. : Sea Steaming - LS D.O M/E	SEA_MN_LOW_SULP_DOIL_CTNT
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaGnrLowSulpDoilCtnt()).append("|");	// 41	FUEL CONSUM. : Sea Steaming - LS D.O G/E	SEA_GNR_LOW_SULP_DOIL_CTNT
			seaLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getSeaBlrLowSulpDoilCtnt()).append("|");	// 42	FUEL CONSUM. : Sea Steaming - LS D.O BLR	SEA_BLR_LOW_SULP_DOIL_CTNT
			fcmDepRptLogVO.setSeaLowSulpFuelCsmCtnt(seaLowSulpFuelCsmCtnt.toString());
			
			// port_fuel_csm_ctnt
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortMnFoilCtnt()).append("|");	// 43	FUEL CONSUM. : Harbor / In Port - F.O M/E	PORT_MN_FOIL_CTNT
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortGnrFoilCtnt()).append("|");	// 44	FUEL CONSUM. : Harbor / In Port - F.O G/E	PORT_GNR_FOIL_CTNT
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortBlrFoilCtnt()).append("|");	// 45	FUEL CONSUM. : Harbor / In Port - F.O BLR	PORT_BLR_FOIL_CTNT
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortMnDoilCtnt()).append("|");	// 49	FUEL CONSUM. : Harbor / In Port - D.O M/E	PORT_MN_DOIL_CTNT
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortGnrDoilCtnt()).append("|");	// 50	FUEL CONSUM. : Harbor / In Port - D.O G/E	PORT_GNR_DOIL_CTNT
			portFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortBlrDoilCtnt()).append("|");	// 51	FUEL CONSUM. : Harbor / In Port - D.O BLR	PORT_BLR_DOIL_CTNT
			fcmDepRptLogVO.setPortFuelCsmCtnt(portFuelCsmCtnt.toString());
			
			// port_low_sulp_fuel_csm_ctnt
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortMnLowSulpFoilCtnt()).append("|");	// 46	FUEL CONSUM. : Harbor / In Port - LS F.O M/E	PORT_MN_LOW_SULP_FOIL_CTNT
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortGnrLowSulpFoilCtnt()).append("|");	// 47	FUEL CONSUM. : Harbor / In Port - LS F.O G/E	PORT_GNR_LOW_SULP_FOIL_CTNT
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortBlrLowSulpFoilCtnt()).append("|");	// 48	FUEL CONSUM. : Harbor / In Port - LS F.O BLR	PORT_BLR_LOW_SULP_FOIL_CTNT
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortMnLowSulpDoilCtnt()).append("|");	// 52	FUEL CONSUM. : Harbor / In Port - LS D.O M/E	PORT_MN_LOW_SULP_DOIL_CTNT
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortGnrLowSulpDoilCtnt()).append("|");	// 53	FUEL CONSUM. : Harbor / In Port - LS D.O G/E	PORT_GNR_LOW_SULP_DOIL_CTNT
			portLowSulpFuelCsmCtnt.append(fcmDepRptErrClsVO.getPortBlrLowSulpDoilCtnt()).append("|");	// 54	FUEL CONSUM. : Harbor / In Port - LS D.O BLR	PORT_BLR_LOW_SULP_DOIL_CTNT
			fcmDepRptLogVO.setPortLowSulpFuelCsmCtnt(portLowSulpFuelCsmCtnt.toString());
			
			// spl_oil_ctnt
			// FCM_DEP_RPT_LOG TABLE DATA
			List<String> splOilCtntList = FCMGeneralUtil.convertListByString(fcmDepRptLogVO.getSplOilCtnt(), "|");
			if (splOilCtntList.size() > 3) {
				splFoilBrgWgt1 = (String) splOilCtntList.get(3);
			}
			if (splOilCtntList.size() > 4) {
				splFoilBrgWgt2 = (String) splOilCtntList.get(4);
			}
			if (splOilCtntList.size() > 8) {
				splDoilBrgWgt1 = (String) splOilCtntList.get(8);
			}
			if (splOilCtntList.size() > 9) {
				splDoilBrgWgt2 = (String) splOilCtntList.get(9);
			}
			if (splOilCtntList.size() > 10) {
				splFrshWtrActWgt = (String) splOilCtntList.get(10);
			}
			
			splOilCtnt.append(fcmDepRptErrClsVO.getSplFoilBdrCtnt()).append("|");	// 55	Q'ty(BDR) - F.O	SPL_FOIL_BDR_CTNT
			splOilCtnt.append(fcmDepRptErrClsVO.getSplFoilActCtnt()).append("|");	// 56	Q'ty(Act.) - F.O	SPL_FOIL_ACT_CTNT
			splOilCtnt.append(fcmDepRptErrClsVO.getSplFoilSulpCtnt()).append("|");	// 57	Sulfur(%) - F.O	SPL_FOIL_SULP_CTNT
			splOilCtnt.append(splFoilBrgWgt1).append("|");
			splOilCtnt.append(splFoilBrgWgt2).append("|");
			splOilCtnt.append(fcmDepRptErrClsVO.getSplDoilBdrCtnt()).append("|");	// 61	Q'ty(BDR) - D.O	SPL_DOIL_BDR_CTNT
			splOilCtnt.append(fcmDepRptErrClsVO.getSplDoilActCtnt()).append("|");	// 62	Q'ty(Act.) - D.O	SPL_DOIL_ACT_CTNT
			splOilCtnt.append(fcmDepRptErrClsVO.getSplDoilSulpCtnt()).append("|");	// 63	Sulfur(%) - D.O	SPL_DOIL_SULP_CTNT
			splOilCtnt.append(splDoilBrgWgt1).append("|");
			splOilCtnt.append(splDoilBrgWgt2).append("|");
			splOilCtnt.append(splFrshWtrActWgt).append("|");
			fcmDepRptLogVO.setSplOilCtnt(splOilCtnt.toString());
			
			// spl_low_sulp_oil_ctnt
			// FCM_DEP_RPT_LOG TABLE DATA
			List<String> splLowSulpOilCtntList = FCMGeneralUtil.convertListByString(fcmDepRptLogVO.getSplLowSulpOilCtnt(), "|");
			if (splLowSulpOilCtntList.size() > 3) {
				splLowSulpFoilBrgWgt1 = (String) splLowSulpOilCtntList.get(3);
			}
			if (splLowSulpOilCtntList.size() > 4) {
				splLowSulpFoilBrgWgt2 = (String) splLowSulpOilCtntList.get(4);
			}
			if (splLowSulpOilCtntList.size() > 8) {
				splLowSulpDoilBrgWgt1 = (String) splLowSulpOilCtntList.get(8);
			}
			if (splLowSulpOilCtntList.size() > 9) {
				splLowSulpDoilBrgWgt2 = (String) splLowSulpOilCtntList.get(9);
			}
			
			splLowSulpOilCtnt.append(fcmDepRptErrClsVO.getSplLowSulpFoilBdrCtnt()).append("|");		// 58	Q'ty(BDR) - LS F.O	SPL_LOW_SULP_FOIL_BDR_CTNT
			splLowSulpOilCtnt.append(fcmDepRptErrClsVO.getSplLowSulpFoilActCtnt()).append("|");		// 59	Q'ty(Act.) - LS F.O	SPL_LOW_SULP_FOIL_ACT_CTNT
			splLowSulpOilCtnt.append(fcmDepRptErrClsVO.getSplLowSulpFoilSulpCtnt()).append("|");	// 60	Sulfur(%) - LS F.O	SPL_LOW_SULP_FOIL_SULP_CTNT
			splLowSulpOilCtnt.append(splLowSulpFoilBrgWgt1).append("|");
			splLowSulpOilCtnt.append(splLowSulpFoilBrgWgt2).append("|");
			splLowSulpOilCtnt.append(fcmDepRptErrClsVO.getSplLowSulpDoilBdrCtnt()).append("|");		// 64	Q'ty(BDR) - LS D.O	SPL_LOW_SULP_DOIL_BDR_CTNT
			splLowSulpOilCtnt.append(fcmDepRptErrClsVO.getSplLowSulpDoilActCtnt()).append("|");		// 65	Q'ty(Act.) - LS D.O	SPL_LOW_SULP_DOIL_ACT_CTNT
			splLowSulpOilCtnt.append(fcmDepRptErrClsVO.getSplLowSulpDoilSulpCtnt()).append("|");	// 66	Sulfur(%) - LS D.O	SPL_LOW_SULP_DOIL_SULP_CTNT
			splLowSulpOilCtnt.append(splLowSulpDoilBrgWgt1).append("|");
			splLowSulpOilCtnt.append(splLowSulpDoilBrgWgt2).append("|");
			fcmDepRptLogVO.setSplLowSulpOilCtnt(splLowSulpOilCtnt.toString());
			
			// cntr_cgo_ctnt
			cntrCgoCtnt.append(fcmDepRptErrClsVO.getFcntrObrdTeuCtnt()).append("|");	// 92	CARGO : On Board CNTR : Full	FCNTR_OBRD_TEU_CTNT
			cntrCgoCtnt.append(fcmDepRptErrClsVO.getMcntrObrdTeuCtnt()).append("|");	// 93	CARGO : On Board CNTR : Em'ty	MCNTR_OBRD_TEU_CTNT
			cntrCgoCtnt.append(fcmDepRptErrClsVO.getTtlCntrObrdTeuCtnt()).append("|");	// 94	CARGO : On Board CNTR : Total	TTL_CNTR_OBRD_TEU_CTNT
			cntrCgoCtnt.append(fcmDepRptErrClsVO.getRfCntrDchgKntCtnt()).append("|");	// 97	CARGO : R/F CNTR : Disch	RF_CNTR_DCHG_KNT_CTNT
			cntrCgoCtnt.append(fcmDepRptErrClsVO.getRfCntrLodKntCtnt()).append("|");	// 98	CARGO : R/F CNTR : Load	RF_CNTR_LOD_KNT_CTNT
			cntrCgoCtnt.append(fcmDepRptErrClsVO.getRfCntrObrdKntCtnt()).append("|");	// 99	CARGO : R/F CNTR : On Board	RF_CNTR_OBRD_KNT_CTNT
			fcmDepRptLogVO.setCntrCgoCtnt(cntrCgoCtnt.toString());
			
			// 95	CARGO : On Board CNTR : Cargo Weight	DEP_CGO_CTNT
			fcmDepRptLogVO.setDepCgoWgt(fcmDepRptErrClsVO.getDepCgoCtnt());
			
			// 96	CARGO : On Board CNTR : Displacement	DEP_DPL_CTNT
			fcmDepRptLogVO.setDepDplWgt(fcmDepRptErrClsVO.getDepDplCtnt());
			
			
			fcmDepRptLogVO.setCreUsrId(account.getUsr_id());
			fcmDepRptLogVO.setUpdUsrId(account.getUsr_id());
			
			fcmDepRptErrClsVO.setCreUsrId(account.getUsr_id());
			fcmDepRptErrClsVO.setUpdUsrId(account.getUsr_id());
			
			/* Item 수정항목 LogVO 와 합쳐서 FCM_DEP_RPT 테이블에 적용*/
			dbDao.addDepRpt(fcmDepRptLogVO);
			
			/* Item 수정 내역 FCM_DEP_RPT_CLS_HIS 테이블에 적용 */
			dbDao.addFcmDepRptPastClsHis(fcmDepRptErrClsVO);
			
			/* Cleansing 완료 데이터 FCM_DEP_RPT_ERR 테이블에서 삭제 */
			dbDao.removeFcmDepRptErr(fcmDepRptErrClsVO);
			
		} catch (DAOException e) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		} catch (Exception e) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		}
	}
	
	/**
	 * Departure Report Update, Cleansing History insert
	 * @param depRptVO
	 * @param depRptErrClsVO
	 * @param account
	 * @throws EventException
	 */
	public void multiFcmDepRptErrCls(FcmDepRptVO depRptVO, FcmDepRptErrClsVO depRptErrClsVO, SignOnUserAccount account) throws EventException {
		try {

			depRptVO.setUpdUsrId(account.getUsr_id());

			dbDao.modifyDepRpt(depRptVO);
			
			// 본테이블 수정은 IE로 설정
			depRptErrClsVO.setDepRptErrTpCd("IE");
			depRptErrClsVO.setCreUsrId(account.getUsr_id());
			depRptErrClsVO.setUpdUsrId(account.getUsr_id());
			
			/* Item 수정 내역 FCM_DEP_RPT_CLS_HIS 테이블에 적용 */
			dbDao.addFcmDepRptPastClsHis(depRptErrClsVO);
			
		} catch (DAOException e) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		} catch (Exception e) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		}
	}
	
	/**
	 * Departure Report Err data delete
	 * 
	 * @param fcmDepRptErrClsVO
	 * @throws EventException
	 */
	public void removeFcmDepRptErr(FcmDepRptErrClsVO fcmDepRptErrClsVO) throws EventException {
		try {
			/* FCM_DEP_RPT_ERR 테이블에서 삭제  */
			dbDao.removeFcmDepRptErr(fcmDepRptErrClsVO);
			
		} catch (DAOException e) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		} catch (Exception e) {
			// COM12192 : Failed to save ($s).  Please try again.
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Departure Report"}).getMessage(), e);
		}
	}
	
	/**
	 * depRptClsVO 를 depRptVO 에  setting
	 * 
	 * @param depRptVO
	 * @param depRptClsVO
	 * @return FcmDepRptVO
	 * @throws EventException
	 */
	public FcmDepRptVO depRptClsVOTOdepRptVO(FcmDepRptVO depRptVO, FcmDepRptErrClsVO depRptClsVO) throws EventException {
		FcmDepRptVO resultVO = new FcmDepRptVO();
		try {
			if(depRptVO != null && depRptClsVO != null){
				
				// 2 : INFORMATION : Class	
				depRptVO.setCntrDznCapa(depRptClsVO.getCntrDznCapa());
					
				// 3 : INFORMATION : Vessel	
				depRptVO.setVslCd(depRptClsVO.getVslCd());
					
				// 4 : INFORMATION : Voy No.
				depRptVO.setSkdVoyNo(depRptClsVO.getSkdVoyNo().substring(0, 4));
				depRptVO.setSkdDirCd(depRptClsVO.getSkdVoyNo().substring(4, 5));
					
				// 5 : INFORMATION : Lane	
				depRptVO.setVslSlanCd(depRptClsVO.getVslSlanCd());
					
				// 6 : INFORMATION : Last Port	
				depRptVO.setLstDepPortCd(depRptClsVO.getLstDepPortCd());
					
				// 7 : INFORMATION : Dep Port	
				depRptVO.setDepPortCd(depRptClsVO.getDepPortCd());
					
				// 8 : PERFORMANCE : Miles Obs	
				depRptVO.setNvgtMlDist(depRptClsVO.getNvgtMlDistCtnt());
					
				// 9 : PERFORMANCE : Miles Eng	
				depRptVO.setEngMlDist(depRptClsVO.getEngMlDistCtnt());
					
				// 10 : PERFORMANCE : Miles In	
				depRptVO.setMnvrInMlDist(depRptClsVO.getMnvrInMlDistCtnt());
					
				// 11 : PERFORMANCE : Miles Out	
				depRptVO.setMnvrOutMlDist(depRptClsVO.getMnvrOutMlDistCtnt());
					
				// 12 : PERFORMANCE : SPD	
				depRptVO.setAvgSpd(depRptClsVO.getAvgSpdCtnt());
					
				// 13 : PERFORMANCE : RPM	
				depRptVO.setAvgRpmPwr(depRptClsVO.getAvgRpmPwrCtnt());
					
				// 16 : R.O.B : Rob(Arr) F.O	
				depRptVO.setArrFoilWgt(depRptClsVO.getArrFoilCtnt());
					
				// 17 : R.O.B : Rob(Arr) LS F.O	
				depRptVO.setArrLowSulpFoilWgt(depRptClsVO.getArrLowSulpFoilCtnt());
					
				// 18 : R.O.B : Rob(Arr) D.O	
				depRptVO.setArrDoilWgt(depRptClsVO.getArrDoilCtnt());
					
				// 19 : R.O.B : Rob(Arr) LS D.O	
				depRptVO.setArrLowSulpDoilWgt(depRptClsVO.getArrLowSulpDoilCtnt());
					
				// 20 : R.O.B : Rob(Dep) F.O	
				depRptVO.setDepFoilWgt(depRptClsVO.getDepFoilCtnt());
					
				// 21 : R.O.B : Rob(Dep) LS F.O	
				depRptVO.setDepLowSulpFoilWgt(depRptClsVO.getDepLowSulpFoilCtnt());
					
				// 22 : R.O.B : Rob(Dep) D.O	
				depRptVO.setDepDoilWgt(depRptClsVO.getDepDoilCtnt());
					
				// 23 : R.O.B : Rob(Dep) LS D.O	
				depRptVO.setDepLowSulpDoilWgt(depRptClsVO.getDepLowSulpDoilCtnt());
					
				// 24 : R.O.B : Rob(Dep)-Last port F.O	
				depRptVO.setLstDepFoilCtnt(depRptClsVO.getLstDepFoilCtnt());
					
				// 25 : R.O.B : Rob(Dep)-Last port LS F.O	
				depRptVO.setLstDepLowSulpFoilCtnt(depRptClsVO.getLstDepLowSulpFoilCtnt());
					
				// 26 : R.O.B : Rob(Dep)-Last port D.O	
				depRptVO.setLstDepDoilCtnt(depRptClsVO.getLstDepDoilCtnt());
					
				// 27 : R.O.B : Rob(Dep)-Last port LS D.O	
				depRptVO.setLstDepLowSulpDoilCtnt(depRptClsVO.getLstDepLowSulpDoilCtnt());
					
				// 31 : FUEL CONSUM. : Sea Steaming - F.O M/E	
				depRptVO.setSeaMnFoilCsmQty(depRptClsVO.getSeaMnFoilCtnt());
					
				// 32 : FUEL CONSUM. : Sea Steaming - F.O G/E	
				depRptVO.setSeaGnrFoilCsmQty(depRptClsVO.getSeaGnrFoilCtnt());
					
				// 33 : FUEL CONSUM. : Sea Steaming - F.O BLR	
				depRptVO.setSeaBlrFoilCsmQty(depRptClsVO.getSeaBlrFoilCtnt());
					
				// 34 : FUEL CONSUM. : Sea Steaming - LS F.O M/E	
				depRptVO.setSeaMnLowSulpFoilCsmQty(depRptClsVO.getSeaMnLowSulpFoilCtnt());
					
				// 35 : FUEL CONSUM. : Sea Steaming - LS F.O G/E	
				depRptVO.setSeaGnrLowSulpFoilCsmQty(depRptClsVO.getSeaGnrLowSulpFoilCtnt());
					
				// 36 : FUEL CONSUM. : Sea Steaming - LS F.O BLR	
				depRptVO.setSeaBlrLowSulpFoilCsmQty(depRptClsVO.getSeaBlrLowSulpFoilCtnt());
					
				// 37 : FUEL CONSUM. : Sea Steaming - D.O M/E	
				depRptVO.setSeaMnDoilCsmQty(depRptClsVO.getSeaMnDoilCtnt());
					
				// 38 : FUEL CONSUM. : Sea Steaming - D.O G/E	
				depRptVO.setSeaGnrDoilCsmQty(depRptClsVO.getSeaGnrDoilCtnt());
					
				// 39 : FUEL CONSUM. : Sea Steaming - D.O BLR	
				depRptVO.setSeaBlrDoilCsmQty(depRptClsVO.getSeaBlrDoilCtnt());
					
				// 40 : FUEL CONSUM. : Sea Steaming - LS D.O M/E	
				depRptVO.setSeaMnLowSulpDoilCsmQty(depRptClsVO.getSeaMnLowSulpDoilCtnt());
					
				// 41 : FUEL CONSUM. : Sea Steaming - LS D.O G/E	
				depRptVO.setSeaGnrLowSulpDoilCsmQty(depRptClsVO.getSeaGnrLowSulpDoilCtnt());
					
				// 42 : FUEL CONSUM. : Sea Steaming - LS D.O BLR	
				depRptVO.setSeaBlrLowSulpDoilCsmQty(depRptClsVO.getSeaBlrLowSulpDoilCtnt());
					
				// 43 : FUEL CONSUM. : Harbor / In Port - F.O M/E	
				depRptVO.setPortMnFoilCsmQty(depRptClsVO.getPortMnFoilCtnt());
					
				// 44 : FUEL CONSUM. : Harbor / In Port - F.O G/E	
				depRptVO.setPortGnrFoilCsmQty(depRptClsVO.getPortGnrFoilCtnt());
					
				// 45 : FUEL CONSUM. : Harbor / In Port - F.O BLR	
				depRptVO.setPortBlrFoilCsmQty(depRptClsVO.getPortBlrFoilCtnt());
					
				// 46 : FUEL CONSUM. : Harbor / In Port - LS F.O M/E	
				depRptVO.setPortMnLowSulpFoilCsmQty(depRptClsVO.getPortMnLowSulpFoilCtnt());
					
				// 47 : FUEL CONSUM. : Harbor / In Port - LS F.O G/E	
				depRptVO.setPortGnrLowSulpFoilCsmQty(depRptClsVO.getPortGnrLowSulpFoilCtnt());
					
				// 48 : FUEL CONSUM. : Harbor / In Port - LS F.O BLR	
				depRptVO.setPortBlrLowSulpFoilCsmQty(depRptClsVO.getPortBlrLowSulpFoilCtnt());
					
				// 49 : FUEL CONSUM. : Harbor / In Port - D.O M/E	
				depRptVO.setPortMnDoilCsmQty(depRptClsVO.getPortMnDoilCtnt());
					
				// 50 : FUEL CONSUM. : Harbor / In Port - D.O G/E	
				depRptVO.setPortGnrDoilCsmQty(depRptClsVO.getPortGnrDoilCtnt());
					
				// 51 : FUEL CONSUM. : Harbor / In Port - D.O BLR	
				depRptVO.setPortBlrDoilCsmQty(depRptClsVO.getPortBlrDoilCtnt());
					
				// 52 : FUEL CONSUM. : Harbor / In Port - LS D.O M/E	
				depRptVO.setPortMnLowSulpDoilCsmQty(depRptClsVO.getPortMnLowSulpDoilCtnt());
					
				// 53 : FUEL CONSUM. : Harbor / In Port - LS D.O G/E	
				depRptVO.setPortGnrLowSulpDoilCsmQty(depRptClsVO.getPortGnrLowSulpDoilCtnt());
					
				// 54 : FUEL CONSUM. : Harbor / In Port - LS D.O BLR	
				depRptVO.setPortBlrLowSulpDoilCsmQty(depRptClsVO.getPortBlrLowSulpDoilCtnt());
					
				// 55 : Q'ty(BDR) - F.O	
				depRptVO.setSplFoilBdrWgt(depRptClsVO.getSplFoilBdrCtnt());
					
				// 56 : Q'ty(Act.) - F.O	
				depRptVO.setSplFoilActWgt(depRptClsVO.getSplFoilActCtnt());
					
				// 57 : Sulfur(%) - F.O	
				depRptVO.setSplFoilSulpWgt(depRptClsVO.getSplFoilSulpCtnt());
					
				// 58 : Q'ty(BDR) - LS F.O	
				depRptVO.setSplLowSulpFoilBdrWgt(depRptClsVO.getSplLowSulpFoilBdrCtnt());
					
				// 59 : Q'ty(Act.) - LS F.O	
				depRptVO.setSplLowSulpFoilActWgt(depRptClsVO.getSplLowSulpFoilActCtnt());
					
				// 60 : Sulfur(%) - LS F.O	
				depRptVO.setSplLowSulpFoilSulpWgt(depRptClsVO.getSplLowSulpFoilSulpCtnt());
					
				// 61 : Q'ty(BDR) - D.O	
				depRptVO.setSplDoilBdrWgt(depRptClsVO.getSplDoilBdrCtnt());
					
				// 62 : Q'ty(Act.) - D.O	
				depRptVO.setSplDoilActWgt(depRptClsVO.getSplDoilActCtnt());
					
				// 63 : Sulfur(%) - D.O	
				depRptVO.setSplDoilSulpWgt(depRptClsVO.getSplDoilSulpCtnt());
					
				// 64 : Q'ty(BDR) - LS D.O	
				depRptVO.setSplLowSulpDoilBdrWgt(depRptClsVO.getSplLowSulpDoilBdrCtnt());
					
				// 65 : Q'ty(Act.) - LS D.O	
				depRptVO.setSplLowSulpDoilActWgt(depRptClsVO.getSplLowSulpDoilActCtnt());
					
				// 66 : Sulfur(%) - LS D.O	
				depRptVO.setSplLowSulpDoilSulpWgt(depRptClsVO.getSplLowSulpDoilSulpCtnt());
					
				// 67 : Destination - Next Port	
				depRptVO.setNxtPortCd(depRptClsVO.getNxtPortCd());
					
				// 68 : Destination - ETA	
				depRptVO.setNxtPortEtaDt(depRptClsVO.getNxtPortEtaDt());
					
				// 69 : Destination - Togo Mile	
				depRptVO.setRmnDist(depRptClsVO.getRmnDistCtnt());
					
				// 70 : Destination - Togo Speed	
				depRptVO.setRmnAvgSpd(depRptClsVO.getRmnAvgSpdCtnt());
					
				// 71 : Time - S/B ENG	
				depRptVO.setSbEngDt(depRptClsVO.getSbEngDt());
					
				// 72 : Time - P.O.B	
				depRptVO.setPltInDt(depRptClsVO.getPltInDt());
					
				// 73 : Time - Drop Anchor	
				depRptVO.setBfrBrthAnkDrpDt(depRptClsVO.getBfrBrthAnkDrpDt());
					
				// 74 : Time - Anchor Away	
				depRptVO.setBfrBrthAnkOffDt(depRptClsVO.getBfrBrthAnkOffDt());
					
				// 75 : Time - First Line	
				depRptVO.setVpsEtbDt(depRptClsVO.getVpsEtbDt());
					
				// 76 : Time - Comm'ced Work	
				depRptVO.setCgoWrkStDt(depRptClsVO.getCgoWrkStDt());
					
				// 77 : Time - Comp'ted Work	
				depRptVO.setCgoWrkEndDt(depRptClsVO.getCgoWrkEndDt());
					
				// 78 : Time - Last Line	
				depRptVO.setVpsEtdDt(depRptClsVO.getVpsEtdDt());
					
				// 79 : Time - Drop Anchor	
				depRptVO.setAftUnbrthAnkDrpDt(depRptClsVO.getAftUnbrthAnkDrpDt());
					
				// 80 : Time - Anchor Away	
				depRptVO.setAftUnbrthAnkOffDt(depRptClsVO.getAftUnbrthAnkOffDt());
					
				// 81 : Time - Pilot Away	
				depRptVO.setPltOutDt(depRptClsVO.getPltOutDt());
					
				// 82 : Time - R/Up Engine	
				depRptVO.setRupDt(depRptClsVO.getRupDt());
					
				// 83 : Time - R/UP ENG (Last Port) 	
				depRptVO.setLstPortRupDt(depRptClsVO.getLstPortRupDt());
					
				// 84 : CONDITION : Draft(Arr) : FWD	
				depRptVO.setArrFwddrHgt(depRptClsVO.getArrFwddrCtnt());
					
				// 85 : CONDITION : Draft(Arr) : MID	
				depRptVO.setArrMidDrftHgt(depRptClsVO.getArrMidDrftCtnt());
					
				// 86 : CONDITION : Draft(Arr) : AFT	
				depRptVO.setArrAftdrHgt(depRptClsVO.getArrAftdrCtnt());
					
				// 87 : CONDITION : Draft(Arr) : GM	
				depRptVO.setArrGmHgt(depRptClsVO.getArrGmCtnt());
					
				// 88 : CONDITION : Draft(Dep) : FWD	
				depRptVO.setDepFwddrHgt(depRptClsVO.getDepFwddrCtnt());
					
				// 89 : CONDITION : Draft(Dep) : MID	
				depRptVO.setDepMidDrftHgt(depRptClsVO.getDepMidDrftCtnt());
					
				// 90 : CONDITION : Draft(Dep) : AFT	
				depRptVO.setDepAftdrHgt(depRptClsVO.getDepAftdrCtnt());
					
				// 91 : CONDITION : Draft(Dep) : GM	
				depRptVO.setDepGmHgt(depRptClsVO.getDepGmCtnt());
					
				// 92 : CARGO : On Board CNTR : Full	
				depRptVO.setFullCntrObrdTeu(depRptClsVO.getFcntrObrdTeuCtnt());
					
				// 93 : CARGO : On Board CNTR : Em'ty	
				depRptVO.setMtyCntrObrdTeu(depRptClsVO.getMcntrObrdTeuCtnt());
					
				// 94 : CARGO : On Board CNTR : Total	
				depRptVO.setTtlCntrObrdTeu(depRptClsVO.getTtlCntrObrdTeuCtnt());
					
				// 95 : CARGO : On Board CNTR : Cargo Weight	
				depRptVO.setDepCgoWgt(depRptClsVO.getDepCgoCtnt());
					
				// 96 : CARGO : On Board CNTR : Displacement	
				depRptVO.setDepDplWgt(depRptClsVO.getDepDplCtnt());
					
				// 97 : CARGO : R/F CNTR : Disch	
				depRptVO.setRfCntrDchgKnt(depRptClsVO.getRfCntrDchgKntCtnt());
					
				// 98 : CARGO : R/F CNTR : Load	
				depRptVO.setRfCntrLodKnt(depRptClsVO.getRfCntrLodKntCtnt());
					
				// 99 : CARGO : R/F CNTR : On Board	
				depRptVO.setRfCntrObrdKnt(depRptClsVO.getRfCntrObrdKntCtnt());
					
				// 100 : CARGO : R/F CNTR : On Board(Last Port)	
				depRptVO.setLstRfCntrObrdKntCtnt(depRptClsVO.getLstRfCntrObrdKntCtnt());

				resultVO = depRptVO;
			}
			return resultVO;
      } catch (Exception ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Item Error Correction"}).getMessage(), ex);
		}

	}
	
	/**
	 * depRptVO 를 depRptClsVO 에 setting
	 * @param depRptVO
	 * @return FcmDepRptErrClsVO
	 * @throws EventException
	 */
	public FcmDepRptErrClsVO depRptVOTOdepRptClsVO(FcmDepRptVO depRptVO) throws EventException {
		FcmDepRptErrClsVO resultVO = new FcmDepRptErrClsVO();
		try {
			if(depRptVO != null){
				
				// 필수 항목
				resultVO.setSkdDirCd(depRptVO.getSkdDirCd());
				resultVO.setClptIndSeq(depRptVO.getClptIndSeq());
				
				// 2 : INFORMATION : Class
				resultVO.setCntrDznCapa(depRptVO.getCntrDznCapa());

				// 3 : INFORMATION : Vessel
				resultVO.setVslCd(depRptVO.getVslCd());

				// 4 : INFORMATION : Voy No.
				resultVO.setSkdVoyNo(depRptVO.getSkdVoyNo() + depRptVO.getSkdDirCd());

				// 5 : INFORMATION : Lane
				resultVO.setVslSlanCd(depRptVO.getVslSlanCd());

				// 6 : INFORMATION : Last Port
				resultVO.setLstDepPortCd(depRptVO.getLstDepPortCd());

				// 7 : INFORMATION : Dep Port
				resultVO.setDepPortCd(depRptVO.getDepPortCd());

				// 8 : PERFORMANCE : Miles Obs
				resultVO.setNvgtMlDistCtnt(depRptVO.getNvgtMlDist());

				// 9 : PERFORMANCE : Miles Eng
				resultVO.setEngMlDistCtnt(depRptVO.getEngMlDist());

				// 10 : PERFORMANCE : Miles In
				resultVO.setMnvrInMlDistCtnt(depRptVO.getMnvrInMlDist());

				// 11 : PERFORMANCE : Miles Out
				resultVO.setMnvrOutMlDistCtnt(depRptVO.getMnvrOutMlDist());

				// 12 : PERFORMANCE : SPD
				resultVO.setAvgSpdCtnt(depRptVO.getAvgSpd());

				// 13 : PERFORMANCE : RPM
				resultVO.setAvgRpmPwrCtnt(depRptVO.getAvgRpmPwr());

				// 16 : R.O.B : Rob(Arr) F.O
				resultVO.setArrFoilCtnt(depRptVO.getArrFoilWgt());

				// 17 : R.O.B : Rob(Arr) LS F.O
				resultVO.setArrLowSulpFoilCtnt(depRptVO.getArrLowSulpFoilWgt());

				// 18 : R.O.B : Rob(Arr) D.O
				resultVO.setArrDoilCtnt(depRptVO.getArrDoilWgt());

				// 19 : R.O.B : Rob(Arr) LS D.O
				resultVO.setArrLowSulpDoilCtnt(depRptVO.getArrLowSulpDoilWgt());

				// 20 : R.O.B : Rob(Dep) F.O
				resultVO.setDepFoilCtnt(depRptVO.getDepFoilWgt());

				// 21 : R.O.B : Rob(Dep) LS F.O
				resultVO.setDepLowSulpFoilCtnt(depRptVO.getDepLowSulpFoilWgt());

				// 22 : R.O.B : Rob(Dep) D.O
				resultVO.setDepDoilCtnt(depRptVO.getDepDoilWgt());

				// 23 : R.O.B : Rob(Dep) LS D.O
				resultVO.setDepLowSulpDoilCtnt(depRptVO.getDepLowSulpDoilWgt());

				// 24 : R.O.B : Rob(Dep)-Last port F.O
				resultVO.setLstDepFoilCtnt(depRptVO.getLstDepFoilCtnt());

				// 25 : R.O.B : Rob(Dep)-Last port LS F.O
				resultVO.setLstDepLowSulpFoilCtnt(depRptVO.getLstDepLowSulpFoilCtnt());

				// 26 : R.O.B : Rob(Dep)-Last port D.O
				resultVO.setLstDepDoilCtnt(depRptVO.getLstDepDoilCtnt());

				// 27 : R.O.B : Rob(Dep)-Last port LS D.O
				resultVO.setLstDepLowSulpDoilCtnt(depRptVO.getLstDepLowSulpDoilCtnt());

				// 31 : FUEL CONSUM. : Sea Steaming - F.O M/E
				resultVO.setSeaMnFoilCtnt(depRptVO.getSeaMnFoilCsmQty());

				// 32 : FUEL CONSUM. : Sea Steaming - F.O G/E
				resultVO.setSeaGnrFoilCtnt(depRptVO.getSeaGnrFoilCsmQty());

				// 33 : FUEL CONSUM. : Sea Steaming - F.O BLR
				resultVO.setSeaBlrFoilCtnt(depRptVO.getSeaBlrFoilCsmQty());

				// 34 : FUEL CONSUM. : Sea Steaming - LS F.O M/E
				resultVO.setSeaMnLowSulpFoilCtnt(depRptVO.getSeaMnLowSulpFoilCsmQty());

				// 35 : FUEL CONSUM. : Sea Steaming - LS F.O G/E
				resultVO.setSeaGnrLowSulpFoilCtnt(depRptVO.getSeaGnrLowSulpFoilCsmQty());

				// 36 : FUEL CONSUM. : Sea Steaming - LS F.O BLR
				resultVO.setSeaBlrLowSulpFoilCtnt(depRptVO.getSeaBlrLowSulpFoilCsmQty());

				// 37 : FUEL CONSUM. : Sea Steaming - D.O M/E
				resultVO.setSeaMnDoilCtnt(depRptVO.getSeaMnDoilCsmQty());

				// 38 : FUEL CONSUM. : Sea Steaming - D.O G/E
				resultVO.setSeaGnrDoilCtnt(depRptVO.getSeaGnrDoilCsmQty());

				// 39 : FUEL CONSUM. : Sea Steaming - D.O BLR
				resultVO.setSeaBlrDoilCtnt(depRptVO.getSeaBlrDoilCsmQty());

				// 40 : FUEL CONSUM. : Sea Steaming - LS D.O M/E
				resultVO.setSeaMnLowSulpDoilCtnt(depRptVO.getSeaMnLowSulpDoilCsmQty());

				// 41 : FUEL CONSUM. : Sea Steaming - LS D.O G/E
				resultVO.setSeaGnrLowSulpDoilCtnt(depRptVO.getSeaGnrLowSulpDoilCsmQty());

				// 42 : FUEL CONSUM. : Sea Steaming - LS D.O BLR
				resultVO.setSeaBlrLowSulpDoilCtnt(depRptVO.getSeaBlrLowSulpDoilCsmQty());

				// 43 : FUEL CONSUM. : Harbor / In Port - F.O M/E
				resultVO.setPortMnFoilCtnt(depRptVO.getPortMnFoilCsmQty());

				// 44 : FUEL CONSUM. : Harbor / In Port - F.O G/E
				resultVO.setPortGnrFoilCtnt(depRptVO.getPortGnrFoilCsmQty());

				// 45 : FUEL CONSUM. : Harbor / In Port - F.O BLR
				resultVO.setPortBlrFoilCtnt(depRptVO.getPortBlrFoilCsmQty());

				// 46 : FUEL CONSUM. : Harbor / In Port - LS F.O M/E
				resultVO.setPortMnLowSulpFoilCtnt(depRptVO.getPortMnLowSulpFoilCsmQty());

				// 47 : FUEL CONSUM. : Harbor / In Port - LS F.O G/E
				resultVO.setPortGnrLowSulpFoilCtnt(depRptVO.getPortGnrLowSulpFoilCsmQty());

				// 48 : FUEL CONSUM. : Harbor / In Port - LS F.O BLR
				resultVO.setPortBlrLowSulpFoilCtnt(depRptVO.getPortBlrLowSulpFoilCsmQty());

				// 49 : FUEL CONSUM. : Harbor / In Port - D.O M/E
				resultVO.setPortMnDoilCtnt(depRptVO.getPortMnDoilCsmQty());

				// 50 : FUEL CONSUM. : Harbor / In Port - D.O G/E
				resultVO.setPortGnrDoilCtnt(depRptVO.getPortGnrDoilCsmQty());

				// 51 : FUEL CONSUM. : Harbor / In Port - D.O BLR
				resultVO.setPortBlrDoilCtnt(depRptVO.getPortBlrDoilCsmQty());

				// 52 : FUEL CONSUM. : Harbor / In Port - LS D.O M/E
				resultVO.setPortMnLowSulpDoilCtnt(depRptVO.getPortMnLowSulpDoilCsmQty());

				// 53 : FUEL CONSUM. : Harbor / In Port - LS D.O G/E
				resultVO.setPortGnrLowSulpDoilCtnt(depRptVO.getPortGnrLowSulpDoilCsmQty());

				// 54 : FUEL CONSUM. : Harbor / In Port - LS D.O BLR
				resultVO.setPortBlrLowSulpDoilCtnt(depRptVO.getPortBlrLowSulpDoilCsmQty());

				// 55 : Q'ty(BDR) - F.O
				resultVO.setSplFoilBdrCtnt(depRptVO.getSplFoilBdrWgt());

				// 56 : Q'ty(Act.) - F.O
				resultVO.setSplFoilActCtnt(depRptVO.getSplFoilActWgt());

				// 57 : Sulfur(%) - F.O
				resultVO.setSplFoilSulpCtnt(depRptVO.getSplFoilSulpWgt());

				// 58 : Q'ty(BDR) - LS F.O
				resultVO.setSplLowSulpFoilBdrCtnt(depRptVO.getSplLowSulpFoilBdrWgt());

				// 59 : Q'ty(Act.) - LS F.O
				resultVO.setSplLowSulpFoilActCtnt(depRptVO.getSplLowSulpFoilActWgt());

				// 60 : Sulfur(%) - LS F.O
				resultVO.setSplLowSulpFoilSulpCtnt(depRptVO.getSplLowSulpFoilSulpWgt());

				// 61 : Q'ty(BDR) - D.O
				resultVO.setSplDoilBdrCtnt(depRptVO.getSplDoilBdrWgt());

				// 62 : Q'ty(Act.) - D.O
				resultVO.setSplDoilActCtnt(depRptVO.getSplDoilActWgt());

				// 63 : Sulfur(%) - D.O
				resultVO.setSplDoilSulpCtnt(depRptVO.getSplDoilSulpWgt());

				// 64 : Q'ty(BDR) - LS D.O
				resultVO.setSplLowSulpDoilBdrCtnt(depRptVO.getSplLowSulpDoilBdrWgt());

				// 65 : Q'ty(Act.) - LS D.O
				resultVO.setSplLowSulpDoilActCtnt(depRptVO.getSplLowSulpDoilActWgt());

				// 66 : Sulfur(%) - LS D.O
				resultVO.setSplLowSulpDoilSulpCtnt(depRptVO.getSplLowSulpDoilSulpWgt());

				// 67 : Destination - Next Port
				resultVO.setNxtPortCd(depRptVO.getNxtPortCd());

				// 68 : Destination - ETA
				resultVO.setNxtPortEtaDt(depRptVO.getNxtPortEtaDt());

				// 69 : Destination - Togo Mile
				resultVO.setRmnDistCtnt(depRptVO.getRmnDist());

				// 70 : Destination - Togo Speed
				resultVO.setRmnAvgSpdCtnt(depRptVO.getRmnAvgSpd());

				// 71 : Time - S/B ENG
				resultVO.setSbEngDt(depRptVO.getSbEngDt());

				// 72 : Time - P.O.B
				resultVO.setPltInDt(depRptVO.getPltInDt());

				// 73 : Time - Drop Anchor
				resultVO.setBfrBrthAnkDrpDt(depRptVO.getBfrBrthAnkDrpDt());

				// 74 : Time - Anchor Away
				resultVO.setBfrBrthAnkOffDt(depRptVO.getBfrBrthAnkOffDt());

				// 75 : Time - First Line
				resultVO.setVpsEtbDt(depRptVO.getVpsEtbDt());

				// 76 : Time - Comm'ced Work
				resultVO.setCgoWrkStDt(depRptVO.getCgoWrkStDt());

				// 77 : Time - Comp'ted Work
				resultVO.setCgoWrkEndDt(depRptVO.getCgoWrkEndDt());

				// 78 : Time - Last Line
				resultVO.setVpsEtdDt(depRptVO.getVpsEtdDt());

				// 79 : Time - Drop Anchor
				resultVO.setAftUnbrthAnkDrpDt(depRptVO.getAftUnbrthAnkDrpDt());

				// 80 : Time - Anchor Away
				resultVO.setAftUnbrthAnkOffDt(depRptVO.getAftUnbrthAnkOffDt());

				// 81 : Time - Pilot Away
				resultVO.setPltOutDt(depRptVO.getPltOutDt());

				// 82 : Time - R/Up Engine
				resultVO.setRupDt(depRptVO.getRupDt());

				// 83 : Time - R/UP ENG (Last Port) 
				resultVO.setLstPortRupDt(depRptVO.getLstPortRupDt());

				// 84 : CONDITION : Draft(Arr) : FWD
				resultVO.setArrFwddrCtnt(depRptVO.getArrFwddrHgt());

				// 85 : CONDITION : Draft(Arr) : MID
				resultVO.setArrMidDrftCtnt(depRptVO.getArrMidDrftHgt());

				// 86 : CONDITION : Draft(Arr) : AFT
				resultVO.setArrAftdrCtnt(depRptVO.getArrAftdrHgt());

				// 87 : CONDITION : Draft(Arr) : GM
				resultVO.setArrGmCtnt(depRptVO.getArrGmHgt());

				// 88 : CONDITION : Draft(Dep) : FWD
				resultVO.setDepFwddrCtnt(depRptVO.getDepFwddrHgt());

				// 89 : CONDITION : Draft(Dep) : MID
				resultVO.setDepMidDrftCtnt(depRptVO.getDepMidDrftHgt());

				// 90 : CONDITION : Draft(Dep) : AFT
				resultVO.setDepAftdrCtnt(depRptVO.getDepAftdrHgt());

				// 91 : CONDITION : Draft(Dep) : GM
				resultVO.setDepGmCtnt(depRptVO.getDepGmHgt());

				// 92 : CARGO : On Board CNTR : Full
				resultVO.setFcntrObrdTeuCtnt(depRptVO.getFullCntrObrdTeu());

				// 93 : CARGO : On Board CNTR : Em'ty
				resultVO.setMcntrObrdTeuCtnt(depRptVO.getMtyCntrObrdTeu());

				// 94 : CARGO : On Board CNTR : Total
				resultVO.setTtlCntrObrdTeuCtnt(depRptVO.getTtlCntrObrdTeu());

				// 95 : CARGO : On Board CNTR : Cargo Weight
				resultVO.setDepCgoCtnt(depRptVO.getDepCgoWgt());

				// 96 : CARGO : On Board CNTR : Displacement
				resultVO.setDepDplCtnt(depRptVO.getDepDplWgt());

				// 97 : CARGO : R/F CNTR : Disch
				resultVO.setRfCntrDchgKntCtnt(depRptVO.getRfCntrDchgKnt());

				// 98 : CARGO : R/F CNTR : Load
				resultVO.setRfCntrLodKntCtnt(depRptVO.getRfCntrLodKnt());

				// 99 : CARGO : R/F CNTR : On Board
				resultVO.setRfCntrObrdKntCtnt(depRptVO.getRfCntrObrdKnt());

				// 100 : CARGO : R/F CNTR : On Board(Last Port)
				resultVO.setLstRfCntrObrdKntCtnt(depRptVO.getLstRfCntrObrdKntCtnt());
				
			}
			return resultVO;
      } catch (Exception ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Item Error Correction"}).getMessage(), ex);
		}
	}
	
	/**
	 * Dep. Report 와 Standard 의 반환 형태(자료형), 자릿수(소수점) , 반항 항목 등을 입력받이 처리 
	 * @param flg
	 * @param rtnDiffScale
	 * @param rtnRateScale
	 * @param depVal
	 * @param stndVal
	 * @return returnValue
	 * @throws EventException
	 */
	public String errItemCalc(String flg, String rtnDiffScale, String rtnRateScale, String depVal, String stndVal ) throws EventException {
		// rtnDiffScale, rtnRateScale: return scale
		// flg :  A = ALL, D = DIFF, R = Rate / Range
		
		String returnValue		= "";
		int rtnScale			= 0;
		String diffStr			= "";
		String rateStr			= "";
		BigDecimal zeroVal		= new BigDecimal("0");
		BigDecimal perVal		= new BigDecimal("100");
		BigDecimal bigDepVal	= new BigDecimal(depVal);
		BigDecimal bigStndVal	= new BigDecimal(stndVal);
		BigDecimal diffVal		= null;
		BigDecimal rateVal		= null;
		
		rtnDiffScale			= "".equals(rtnDiffScale) ? "0" : rtnDiffScale;
		rtnRateScale			= "".equals(rtnRateScale) ? "0" : rtnRateScale;
		
		try{
			if("A".equals(flg) || "D".equals(flg)){
				rtnScale	= Integer.parseInt(rtnDiffScale);
				
				if(bigDepVal.compareTo(bigStndVal) == 0){
					diffVal = new BigDecimal("0");
				}else{
					diffVal = bigDepVal.subtract(bigStndVal).setScale(rtnScale, BigDecimal.ROUND_HALF_UP);					
				}
				
				diffStr = diffVal.toPlainString();
			}
			
			if("A".equals(flg) || "R".equals(flg)){
				rtnScale	= Integer.parseInt(rtnRateScale);
				
				if(bigStndVal.compareTo(zeroVal) == 0){
					rateStr = "0";
				}else{
					rateVal = diffVal.divide(bigStndVal, rtnScale + 2, BigDecimal.ROUND_HALF_UP).multiply(perVal).setScale(rtnScale);
					rateStr = rateVal.toPlainString();
				}
			}
			
			// flag별 최종 리턴 값 
			if("A".equals(flg)){
				returnValue = diffStr + "|" + rateStr;
			}else if("D".equals(flg)){
				returnValue = diffStr;
			}else if("R".equals(flg)){
				returnValue = rateStr;
			}
			
		} catch (Exception ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report - errorDataCalculation"}).getMessage(), ex);
		}
		
		return returnValue;
	}
	
	/**
	 * 입력 값이  숫자 인지 확인
	 * 
	 * @param str
	 * @return returnValue
	 */
	@SuppressWarnings("static-access")
	public boolean errCalcItemChk( String str ) {
		boolean returnValue = false;
		FCMGeneralUtil fcmUtil = new FCMGeneralUtil();
		
		if(str != null && !"".equals(str.trim()) && str.length() >= 1){
			if(fcmUtil.isNumberChk(str)){
				returnValue = true;
			}
		}
		
		return returnValue;
	}
	
	/**
	 * 자릿수 관계없이 입력값이 동일한지 비교
	 * 
	 * @param firstVal
	 * @param secondVal
	 * @return returnValue
	 * @throws EventException
	 */
	public boolean dataCompareChk(String firstVal, String secondVal ) throws EventException {
		
		boolean returnValue		= false;
		BigDecimal bigFirstVal	= new BigDecimal(firstVal);
		BigDecimal bigSecondVal	= new BigDecimal(secondVal);

		if(bigFirstVal.compareTo(bigSecondVal) == 0){
			returnValue = true;
		}else{
			returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * overLapVO 와 historyVO 각 항목 비교
	 * 
	 * @param overLapVO
	 * @param historyVO
	 * @return historyVO
	 * @throws EventException
	 */
	public FcmDepRptErrClsVO overLapDataCompare(FcmDepRptErrClsVO overLapVO, FcmDepRptErrClsVO historyVO) throws EventException {
		
		Map<String, Object> overLapMap		= new HashMap<String, Object>();
		Map<String, Object> historyMap		= new HashMap<String, Object>();
		StringBuffer 		compareCtnt		= new StringBuffer();
		String				compareValues	= "";
		String				overLapVal		= "";
		String				historyVal		= "";
		
		compareValues = compareValues + "vsl_slan_cd|nvgt_ml_dist_ctnt|eng_ml_dist_ctnt|mnvr_in_ml_dist_ctnt|mnvr_out_ml_dist_ctnt|avg_spd_ctnt|avg_rpm_pwr_ctnt|avg_prlr_pch_val|sail_tm_hrs|arr_foil_ctnt";
		compareValues = compareValues + "|arr_low_sulp_foil_ctnt|arr_doil_ctnt|arr_low_sulp_doil_ctnt|dep_foil_ctnt|dep_low_sulp_foil_ctnt|dep_doil_ctnt|dep_low_sulp_doil_ctnt|lst_dep_foil_ctnt";
		compareValues = compareValues + "|lst_dep_low_sulp_foil_ctnt|lst_dep_doil_ctnt|lst_dep_low_sulp_doil_ctnt|sea_stmng_mn_eng_ttl_qty|avg_port_ttl_qty|avg_port_ttl_hr_qty|sea_mn_foil_ctnt|sea_gnr_foil_ctnt";
		compareValues = compareValues + "|sea_blr_foil_ctnt|sea_mn_low_sulp_foil_ctnt|sea_gnr_low_sulp_foil_ctnt|sea_blr_low_sulp_foil_ctnt|sea_mn_doil_ctnt|sea_gnr_doil_ctnt|sea_blr_doil_ctnt|sea_mn_low_sulp_doil_ctnt";
		compareValues = compareValues + "|sea_gnr_low_sulp_doil_ctnt|sea_blr_low_sulp_doil_ctnt|port_mn_foil_ctnt|port_gnr_foil_ctnt|port_blr_foil_ctnt|port_mn_low_sulp_foil_ctnt|port_gnr_low_sulp_foil_ctnt";
		compareValues = compareValues + "|port_blr_low_sulp_foil_ctnt|port_mn_doil_ctnt|port_gnr_doil_ctnt|port_blr_doil_ctnt|port_mn_low_sulp_doil_ctnt|port_gnr_low_sulp_doil_ctnt|port_blr_low_sulp_doil_ctnt";
		compareValues = compareValues + "|spl_foil_bdr_ctnt|spl_foil_act_ctnt|spl_foil_sulp_ctnt|spl_low_sulp_foil_bdr_ctnt|spl_low_sulp_foil_act_ctnt|spl_low_sulp_foil_sulp_ctnt|spl_doil_bdr_ctnt|spl_doil_act_ctnt";
		compareValues = compareValues + "|spl_doil_sulp_ctnt|spl_low_sulp_doil_bdr_ctnt|spl_low_sulp_doil_act_ctnt|spl_low_sulp_doil_sulp_ctnt|nxt_port_cd|nxt_port_eta_dt|rmn_dist_ctnt|rmn_avg_spd_ctnt|sb_eng_dt";
		compareValues = compareValues + "|plt_in_dt|bfr_brth_ank_drp_dt|bfr_brth_ank_off_dt|vps_etb_dt|cgo_wrk_st_dt|cgo_wrk_end_dt|vps_etd_dt|aft_unbrth_ank_drp_dt|aft_unbrth_ank_off_dt|plt_out_dt|rup_dt|lst_port_rup_dt";
		compareValues = compareValues + "|arr_fwddr_ctnt|arr_mid_drft_ctnt|arr_aftdr_ctnt|arr_gm_ctnt|dep_fwddr_ctnt|dep_mid_drft_ctnt|dep_aftdr_ctnt|dep_gm_ctnt|fcntr_obrd_teu_ctnt|mcntr_obrd_teu_ctnt|ttl_cntr_obrd_teu_ctnt";
		compareValues = compareValues + "|dep_cgo_ctnt|dep_dpl_ctnt|rf_cntr_dchg_knt_ctnt|rf_cntr_lod_knt_ctnt|rf_cntr_obrd_knt_ctnt|";

		String[] compareValueList = compareValues.split("\\|");
		
		try{
			if(overLapVO != null && historyVO != null){
				
				overLapMap.putAll(overLapVO.getColumnValues());
				historyMap.putAll(historyVO.getColumnValues());
				
				for(int i=0; i < compareValueList.length; i++){
					overLapVal = (overLapMap.get(compareValueList[i])).toString().trim();
					historyVal = (historyMap.get(compareValueList[i])).toString().trim();
					
					if(!(overLapVal).equals(historyVal)){
						if(errCalcItemChk(overLapVal) && errCalcItemChk(historyVal)){
							if(!dataCompareChk(overLapVal,historyVal)){
								compareCtnt.append(compareValueList[i] + "|");
							}
						}else{
							compareCtnt.append(compareValueList[i] + "|");
						}
					}
				}
				
				historyVO.setErrItmCtnt(compareCtnt.toString());
			}

		} catch (Exception ex) {
	          log.error("err " + ex.toString(), ex);
	          throw new EventException(new ErrorHandler("COM12203", new String[]{"Departure Report Overlap Correction - dataCompare"}).getMessage(), ex);
		}
		return historyVO;
	}
}
