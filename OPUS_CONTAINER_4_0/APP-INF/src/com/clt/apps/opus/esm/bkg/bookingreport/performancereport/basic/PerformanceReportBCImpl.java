/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PerformanceReportBCImpl.java
 *@FileTitle : bookingReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import weblogic.wsee.util.StringUtil;

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration.PerformanceReportDBDAO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.AutoratingReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BkgRptDfltVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BlCaDetailListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaInquiryReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaIssueDateInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaIssueDateOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaPerformanceReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaPerformanceReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaSummaryReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaSummaryReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailReturnInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DpcsWebBookingVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchBookingTrendReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchEDIGrpIDVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchUserGroupIdVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselVVDListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsUserGroupCdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgObChnRcvHisVO;
import com.clt.syscommon.common.table.BkgObChnRcvVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BDRBookingStatusListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchFCLListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.InBoundReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.RbcvesselVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.FreightChargeSummaryReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocPFMCOfcListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocPFMCBLListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.InBoundReportInVO;

/**
 * -BookingReport Business Logic Basic Command implementation<br>
 * - BookingReport handling business logic<br>
 * 
 * @author
 * @see ESM_BKG_0753EventResponse,PerformanceReportBC Related DAO class
 * @since J2EE 1.6    
 */  
public class PerformanceReportBCImpl extends BasicCommandSupport implements PerformanceReportBC {

	// Database Access Object
	private transient PerformanceReportDBDAO dbDao = null;

	/**
	 * PerformanceReportBCImpl objects creation<br>
	 * PerformanceReportDBDAO creation<br>
	 */
	public PerformanceReportBCImpl() {
		dbDao = new PerformanceReportDBDAO();
	}

	/**
	 * Searching the VVD list (ESM_BKG_0753)<br>
	 * 
	 * @param VesselVVDListVO vesselVVDListVO
	 * @return List<VesselVVDListVO>  
	 * @throws EventException
	 */
	public List<VesselVVDListVO> searchVVDList(VesselVVDListVO vesselVVDListVO) throws EventException {
		try {
			return dbDao.searchVVDList(vesselVVDListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Checking the validation of VVD list (ESM_BKG_0753)<br>
	 * 
	 * @param VesselVVDListVO vesselVVDListVO
	 * @throws EventException
	 */
	public void checkVVDList(VesselVVDListVO[] vesselVVDListVO) throws EventException {

		try {
			for (int i = 0; i < vesselVVDListVO.length; i++) {
				dbDao.checkVVDList(vesselVVDListVO[i]);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Searching for C/A Summary Template (ESM_BKG_0767)<br>
	 * 
	 * @param BkgRptDfltVO bkgRptDfltVO
	 * @return List<BkgRptDfltVO>
	 * @throws EventException
	 */
	public List<BkgRptDfltVO> searchReportTemplateList(BkgRptDfltVO bkgRptDfltVO) throws EventException {
		try {
			return dbDao.searchReportTemplateList(bkgRptDfltVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Adding and modifying the C/A Summary Template (ESM_BKG_0767)<br>
	 * 
	 * @param BkgRptDfltVO[] bkgRptDfltVOS
	 * @throws EventException
	 */
	public void addReportTemplate(BkgRptDfltVO[] bkgRptDfltVOS) throws EventException {

		try {
			for (int i = 0; i < bkgRptDfltVOS.length; i++) {
				if (bkgRptDfltVOS[i].getIbflag().equals("I")) {

					dbDao.addReportTemplate(bkgRptDfltVOS[i]);
				} else if (bkgRptDfltVOS[i].getIbflag().equals("U")) {

					dbDao.modifyReportTemplate(bkgRptDfltVOS[i]);
				} else if (bkgRptDfltVOS[i].getIbflag().equals("D")) {

					dbDao.removeReportTemplate(bkgRptDfltVOS[i]);
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Deleting the C/A Summary Template (ESM_BKG_0767)<br>
	 * 
	 * @param BkgRptDfltVO[] bkgRptDfltVOS
	 * @throws EventException
	 */
	public void removeReportTemplate(BkgRptDfltVO[] bkgRptDfltVOS) throws EventException {

		try {
			for (int i = 0; i < bkgRptDfltVOS.length; i++) {
				if (bkgRptDfltVOS[i].getIbflag().equals("D")) {

					dbDao.removeReportTemplate(bkgRptDfltVOS[i]);
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

 
	/**
	 * Searching for C/A Detail(s)(ESM_BKG_0651)<br>
	 * 
	 * @param String blNo
	 * @param String bkgNo
	 * @param String caNo
	 * @return List<BlCaDetailListVO>
	 * @throws EventException
	 */
	public List<BlCaDetailListVO> searchBLCaDetailList(String blNo, String bkgNo, String caNo) throws EventException {

		try {
			return dbDao.searchBLCaDetailList(blNo, bkgNo, caNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Searching the History List of C/A Detail(s)(ESM_BKG_0651)<br>
	 * 
	 * @param String bkgNo
	 * @param String corrNo
	 * @return List<BlCaDetailListVO>
	 * @throws EventException
	 */
	public List<BlCaDetailListVO> searchBLCaDetailHisList(String bkgNo,String corrNo) throws EventException {
		
		try {
			return dbDao.searchBLCaDetailHisList(bkgNo,corrNo);
		} catch (DAOException ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);			
		}
	}


	/**
	 * Searching the C/A Performance Report (ESM_BKG_0110)<br>
	 * 
	 * @param CaPerformanceReportInVO vo
	 * @return List<CaPerformanceReportOutVO>
	 * @throws EventException
	 */
	public List<CaPerformanceReportOutVO> searchCAPerformanceReport(CaPerformanceReportInVO vo) throws EventException {

		try {
			return dbDao.searchCAPerformanceReport(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}


	/**
	 * Searching the User Group Id<br>
	 * 
	 * @param String usrId
	 * @return List<DocQueueListOutVO>
	 * @throws EventException
	 */
	public List<SearchUserGroupIdVO> searchUserGroupId(String usrId) throws EventException {
		try {
			return dbDao.searchUserGroupId(usrId);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0985 Managing(Create/modify) the data related with Return table<br>	
	 * 
	 * @param DocQueueDetailReturnInVO docQueueDetailReturnInVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO, SignOnUserAccount account) throws EventException {

		if (docQueueDetailReturnInVO == null) return;
		try {
			dbDao.addQueueDetailReturn(docQueueDetailReturnInVO);
			dbDao.modifyQueueDetailReturn(docQueueDetailReturnInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * 0984 Managing(Create/modify) the data related with Return table<br>	
	 * 
	 * @param DocQueueDetailReturnInVO docQueueDetailReturnInVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageQueueRtnToRtn(DocQueueDetailReturnInVO docQueueDetailReturnInVO, SignOnUserAccount account) throws EventException {

		if (docQueueDetailReturnInVO == null) return;
		try {
			dbDao.addQueueRtnToRtn(docQueueDetailReturnInVO);
			dbDao.modifyQueueRtnToRtn(docQueueDetailReturnInVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}


	/**
	 * Searching the C/A Report (ESM_BKG_0568)<br>
	 * 
	 * @param CaIssueDateInVO vo
	 * @return List<CaIssueDateOutVO>
	 * @throws EventException
	 */
	public List<CaIssueDateOutVO> searchCaIssueDateList(CaIssueDateInVO vo) throws EventException {

		try {
			return dbDao.searchCaIssueDateList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}


	/**
	 * 0274 Searching the General Cargo Manifest by VVD/PORT<br>
	 * 
	 * @param BlCargoManifestInVO blCargoManifestInVO
	 * @return List<BlCargoManifestOutVO>
	 * @throws EventException
	 */
	public List<BlCargoManifestOutVO> searchBLCargoManifestList(BlCargoManifestInVO blCargoManifestInVO) throws EventException {
		try {
			return dbDao.searchBLCargoManifestList(blCargoManifestInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Searching the C/A Report_B/L Inquiry >>> Main (ESM_BKG_0570)<br>
	 * 
	 * @param String blNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	public List<CaInquiryReportVO> searchCaByBLno(String blNo) throws EventException {

		try {
			return dbDao.searchCaByBLno(blNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Searching the C/A Report_B/L Inquiry >>> Customer Info. (ESM_BKG_0570)<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	public List<CaInquiryReportVO> searchCaByCustomerInfo(String blNo, String corrNo) throws EventException {

		try {
			return dbDao.searchCaByCustomerInfo(blNo, corrNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Searching the C/A Report_B/L Inquiry >>> Marks&Desc Info. (ESM_BKG_0570)<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	public List<CaInquiryReportVO> searchCaByMarkDescInfo(String blNo, String corrNo) throws EventException {

		try {
			return dbDao.searchCaByMarkDescInfo(blNo, corrNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Searching the C/A Report_B/L Inquiry >>> Container Info. (ESM_BKG_0570)<br>
	 * 
	 * @param String blNo
	 * @param String corrNo
	 * @return List<CaInquiryReportVO>
	 * @throws EventException
	 */
	public List<CaInquiryReportVO> searchCaByContainerInfo(String blNo, String corrNo) throws EventException {

		try {
			return dbDao.searchCaByContainerInfo(blNo, corrNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Searching the C/A Summary Report (ESM_BKG_0174)<br>
	 * 
	 * @param CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */
	public List<CaSummaryReportOutVO> searchCaSummaryReport(CaSummaryReportInVO vo) throws EventException {

		try {
			/*
			 * //CA REASON SETTING >>>>> START String tempStr = vo.getCaReasonM();
			 * 
			 * if (tempStr == null || tempStr.equals("")){
			 * 
			 * tempStr = vo.getCaReasonC(); }else{
			 * 
			 * if (vo.getCaReasonC() != null && !vo.getCaReasonC().equals("")){ tempStr += "," + vo.getCaReasonC(); } }
			 * 
			 * if (tempStr == null || tempStr.equals("")){
			 * 
			 * tempStr = vo.getCaReasonG(); }else{
			 * 
			 * if (vo.getCaReasonG() != null && !vo.getCaReasonG().equals("")){ tempStr += "," + vo.getCaReasonG(); } }
			 * 
			 * if (tempStr == null || tempStr.equals("")){
			 * 
			 * tempStr = vo.getCaReasonA(); }else{
			 * 
			 * if (vo.getCaReasonA() != null && !vo.getCaReasonA().equals("")){ tempStr += "," + vo.getCaReasonA(); } }
			 * 
			 * if (tempStr == null || tempStr.equals("")){
			 * 
			 * tempStr = vo.getCaReasonO(); }else{
			 * 
			 * if (vo.getCaReasonO() != null && !vo.getCaReasonO().equals("")){ tempStr += "," + vo.getCaReasonO(); } }
			 * 
			 * if (tempStr.indexOf(",") > -1){
			 * 
			 * String[] tempArr = tempStr.split(",");
			 * 
			 * for (int i = 0 ; i < tempArr.length ; i++){
			 * 
			 * if (i == 0){
			 * 
			 * tempStr = " COR.CA_RSN_CD = '" + tempArr[i] + "'"; }else{
			 * 
			 * tempStr += " OR COR.CA_RSN_CD = '" + tempArr[i] + "'"; } }
			 * 
			 * vo.setCaReason(tempStr); } //CA REASON SETTING >>>>> END
			 * 
			 * //CA CLASS SETTING >>>>> START tempStr = "";
			 * 
			 * if (vo.getCaClass1() != null && !vo.getCaClass1().equals("")){
			 * 
			 * tempStr = " COR.RAT_FLG = '" + vo.getCaClass1() + "'"; }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaClass2() != null && !vo.getCaClass2().equals("")){ tempStr += " OR COR.RAT_FLG = '" + vo.getCaClass2() + "'"; } }else{
			 * 
			 * if (vo.getCaClass2() != null && !vo.getCaClass2().equals("")){ tempStr = " COR.RAT_FLG = '" + vo.getCaClass2() + "'"; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaClass3() != null && !vo.getCaClass3().equals("")){ tempStr += " OR COR.EXPN_FLG = '" + vo.getCaClass3() + "'"; } }else{
			 * 
			 * if (vo.getCaClass3() != null && !vo.getCaClass3().equals("")){ tempStr = " COR.EXPN_FLG = '" + vo.getCaClass3() + "'"; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * vo.setCaClass(tempStr); } //CA CLASS SETTING >>>>> END
			 * 
			 * //CA KIND SETTING >>>>> START tempStr = "";
			 * 
			 * if (vo.getCaKindA() != null && !vo.getCaKindA().equals("")){
			 * 
			 * tempStr = " COR.RT_CORR_FLG = 'Y' "; }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindB() != null && !vo.getCaKindB().equals("")){ tempStr += " OR COR.CHG_TERM_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindB() != null && !vo.getCaKindB().equals("")){ tempStr = " COR.CHG_TERM_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindC() != null && !vo.getCaKindC().equals("")){ tempStr += " OR COR.RCVDE_TERM_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindC() != null && !vo.getCaKindC().equals("")){ tempStr = " COR.RCVDE_TERM_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindD() != null && !vo.getCaKindD().equals("")){ tempStr += " OR COR.ROUT_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindD() != null && !vo.getCaKindD().equals("")){ tempStr = " COR.ROUT_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindE() != null && !vo.getCaKindE().equals("")){ tempStr += " OR COR.CUST_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindE() != null && !vo.getCaKindE().equals("")){ tempStr = " COR.COR.CUST_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindF() != null && !vo.getCaKindF().equals("")){ tempStr += " OR COR.QTY_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindF() != null && !vo.getCaKindF().equals("")){ tempStr = " COR.QTY_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindG() != null && !vo.getCaKindG().equals("")){ tempStr += " OR COR.MEAS_QTY_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindG() != null && !vo.getCaKindG().equals("")){ tempStr = " COR.COR.MEAS_QTY_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindH() != null && !vo.getCaKindH().equals("")){ tempStr += " OR COR.CMDT_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindH() != null && !vo.getCaKindH().equals("")){ tempStr = " COR.CMDT_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindI() != null && !vo.getCaKindI().equals("")){ tempStr += " OR COR.TRNK_VSL_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindI() != null && !vo.getCaKindI().equals("")){ tempStr = " COR.TRNK_VSL_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindJ() != null && !vo.getCaKindJ().equals("")){ tempStr += " OR COR.PRPST_VSL_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindJ() != null && !vo.getCaKindJ().equals("")){ tempStr = " COR.PRPST_VSL_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * if (vo.getCaKindK() != null && !vo.getCaKindK().equals("")){ tempStr += " OR COR.CA_OTR_RSN_CORR_FLG = 'Y' "; } }else{
			 * 
			 * if (vo.getCaKindK() != null && !vo.getCaKindK().equals("")){ tempStr = " COR.CA_OTR_RSN_CORR_FLG = 'Y' "; } }
			 * 
			 * if (tempStr != null && !tempStr.equals("")){
			 * 
			 * vo.setCaKind(tempStr); } //CA KIND SETTING >>>>> END
			 */
			return dbDao.searchCaSummaryReport(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Searching the C/A Summary Report BL List (ESM_BKG_0174)<br>
	 * 
	 * @param CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */
	public List<CaSummaryReportOutVO> searchCaSummaryReportBLList(CaSummaryReportInVO vo) throws EventException {

		try {			
			return dbDao.searchCaSummaryReportBLList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
 
	
	/**
	  * 0985 Searching the Queue Detail Return<br>
	  * @param  DocQueueDetailReturnInVO docQueueDetailReturnInVO 
	  * @return List<DocQueueDetailReturnInVO>
	  * @throws EventException
	  */
	 public List<DocQueueDetailReturnInVO> searchQueueDetailReturn(DocQueueDetailReturnInVO docQueueDetailReturnInVO) throws EventException {
		try {
			return dbDao.searchQueueDetailReturn(docQueueDetailReturnInVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	 
	 /**
	 * Searching the Correction(C/A) monthly Summary Batch (BAT_BKG_004)<br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @exception EventException
	 */	
    public void manageCASummary(String fromDt, String toDt) throws EventException{
    	
    	try {
    		dbDao.manageCASummary(fromDt, toDt);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
	/**
	  * 1073 Searching the Customer EDI ID Inquiry<br>
	  * @param  SearchEDIGrpIDVO searchEDIGrpIDVO
	  * @return List<SearchEDIGrpIDVO>
	  * @throws EventException
	  */
    public List<SearchEDIGrpIDVO> searchEDIGrpId(SearchEDIGrpIDVO searchEDIGrpIDVO) throws EventException {
		try {
			return dbDao.searchEDIGrpId(searchEDIGrpIDVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	

	/**
	 * addBkgSrRequest
	 * @param  DpcsWebBookingVO dpcsWebBookingVO
	 * @throws EventException
	 */
    public void addBkgSrRequest(DpcsWebBookingVO dpcsWebBookingVO) throws EventException {
		try {
			dbDao.addBkgSrRequest(dpcsWebBookingVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
	 * 0104 Managing(transaction) the Report template(Default, Detail, User Set)<br>	
	 * 
	 * @param ReportTemplateListVO[] reportTemplateListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageReportTemplateBstVipList(ReportTemplateListVO[] reportTemplateListVO, SignOnUserAccount account) throws EventException {

		if (reportTemplateListVO == null) return;
		try {
			List<ReportTemplateListVO> insertVoList = new ArrayList<ReportTemplateListVO>();
			List<ReportTemplateListVO> updateVoList = new ArrayList<ReportTemplateListVO>();
			List<ReportTemplateListVO> deleteVoList = new ArrayList<ReportTemplateListVO>();
			for (int i = 0; i < reportTemplateListVO.length; i++) {

				reportTemplateListVO[i].setBkgRptKndCd(reportTemplateListVO[0].getPBkgRptKndCd());
				reportTemplateListVO[i].setUpdUsrId(account.getUsr_id());

				if (reportTemplateListVO[i].getIbflag().equals("I")) {
					insertVoList.add(reportTemplateListVO[i]);
				} else if (reportTemplateListVO[i].getIbflag().equals("U")) {
					updateVoList.add(reportTemplateListVO[i]);
				} else if (reportTemplateListVO[i].getIbflag().equals("D")) {
					deleteVoList.add(reportTemplateListVO[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeReportTemplateBstVipList(deleteVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyReportTemplateBstVipList(updateVoList);
			}

			if (insertVoList.size() > 0) {
				dbDao.addReportTemplateBstVipList(insertVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}    

	/**
	 * 1004 Managing(modify) the Super User Authority Change - PIC CHANGE(0421)<br>
	 * 
	 * @param DocsUserGroupCdVO docsUserGroupCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyDocsUserGroupCd(DocsUserGroupCdVO docsUserGroupCdVO, SignOnUserAccount account) throws EventException {

		if (docsUserGroupCdVO == null) return;
		try {
			String[] arrSrcCd = JSPUtil.getNull(docsUserGroupCdVO.getSrcCd()).split(",");
			String[] arrSrNo = JSPUtil.getNull(docsUserGroupCdVO.getSrNo()).split(",");
			String[] arrBkgNo = JSPUtil.getNull(docsUserGroupCdVO.getBkgNo()).split(",");
			String[] arrBeforeUsrId = JSPUtil.getNull(docsUserGroupCdVO.getBeforeUsrId()).split(",");
			
			DocsUserGroupCdVO tempObj = null;
			for (int i = 0; i < arrSrcCd.length; i++) {
				if(JSPUtil.getNull(arrSrcCd[i]).equals("") || JSPUtil.getNull(arrSrNo[i]).equals("")
				   || JSPUtil.getNull(arrBkgNo[i]).equals("") || JSPUtil.getNull(arrBeforeUsrId[i]).equals("")){
					continue;
				}
				tempObj = new DocsUserGroupCdVO(); 
				ObjectCloner.build(docsUserGroupCdVO, tempObj);
				
				tempObj.setSrcCd(arrSrcCd[i]);
				tempObj.setSrNo(arrSrNo[i]);
				tempObj.setBkgNo(arrBkgNo[i]);
				tempObj.setBeforeUsrId(arrBeforeUsrId[i]);
				dbDao.modifyDocsUserGroupCd(tempObj);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * Container NO , Type Size - by bkg_no
	 * bkgCzStsCd: Container NO - "CN", Type Size - "CQ" 
	 * @param  String bkgNo 
	 * @param  String bkgCzStsCd  
	 * @throws EventException
	 */
	public void manageQtyCntrCoposite(String bkgNo , String bkgCzStsCd )throws EventException {
		
		try{
			if (!StringUtil.isEmpty(bkgNo)) {
				dbDao.manageQtyCntrCoposite(bkgNo,bkgCzStsCd);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * BKG_AUTO_RT_HIS creation<br>
	 * @param  String bkgNo 
	 * @throws EventException
	 */
	public void addAutoRtHistory(String bkgNo) throws EventException {
		try{
				dbDao.addAutoRtHistory(bkgNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	 /**
	  * Searching the Autorating Accuracy monitoring Report(ESM_BKG_1081).<br>
	  * 1.Autorating Accuracy Ration<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchAutoratingReport(AutoratingReportVO autoratingReportVO) throws EventException {
		 try {
				return dbDao.searchAutoratingReport(autoratingReportVO);
				
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			}
	 }	
	 

	 /**
	  * Searching the Autorating Accuracy monitoring Report(ESM_BKG_1081).<br>
	  * 2.Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchAutoBLListReport(AutoratingReportVO autoratingReportVO) throws EventException {
		 try {
				return dbDao.searchAutoBLListReport(autoratingReportVO);
				
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			}
	 }	
	 
	 /**
	  * Searching the Autorating Accuracy monitoring Report(ESM_BKG_1081).<br>
	  * 3.Non Autorating B/L List<br>
	  * 
	  * @param  AutoratingReportVO autoratingReportVO
	  * @return List<AutoratingReportVO>
	  * @throws EventException
	  */
	 public List<AutoratingReportVO> searchNonAutoratingReport(AutoratingReportVO autoratingReportVO) throws EventException {
		 try {
				return dbDao.searchNonAutoratingReport(autoratingReportVO);
				
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
			}
	 }	
	 
	 
	 /**
	  * Searching the 2 weeks Daily Booking Trend by Customer >>> B/L Detail (ESM_BKG_1083)<br>
	  * 
	  * @param  SearchBookingTrendReportVO vo
	  * @return List<SearchBookingTrendReportVO>
	  * @throws EventException
	  */
	 public List<SearchBookingTrendReportVO> searchBookingTrendReportBLDetail(SearchBookingTrendReportVO vo) throws EventException{
		 
		try {
			return dbDao.searchBookingTrendReportBLDetail(vo);
				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	 }
	 
	/**
	 * China EDI Receive
	 * 
	 * @param rcvMsg String
	 * @throws EventException
	 */
	public void loadRcvMsg(String rcvMsg) throws EventException {
	
		log.info("<<<< PerformanceReportBCImpl.loadRcvMsg Start >>>>");

		String sUsrId = "CHN_RCV";
		String sDiv = "";
		if (rcvMsg.indexOf("\r\n") != -1)
		{
			sDiv = "\r\n";
		}
		else
		{
			sDiv = "\n";
		}
		String[] arrRcvMsg = rcvMsg.split(sDiv);
			
		try
		{	
			BkgObChnRcvHisVO hisVO = new BkgObChnRcvHisVO();
			hisVO.setChnEdiMsgTpId(arrRcvMsg[0].substring(12, 15));
			hisVO.setMsgRcvNo(arrRcvMsg[0].substring(68, 77));
			hisVO.setEdiRcvMsg(arrRcvMsg[0]);
			hisVO.setCreUsrId(sUsrId);
			dbDao.addBkgObChnRcvHis(hisVO);
		}
		catch (DAOException ex) 
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		catch (Exception ex) 
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		
		try
		{
			BkgObChnRcvVO bkgObChnRcvVO = new BkgObChnRcvVO();
			List<BkgObChnRcvVO> bkgObChnRcvVOs = new ArrayList<BkgObChnRcvVO>();
			int iCnt = 1;
			StringTokenizer st = null;
			String key = null;
			String value = null;
			for (int i = 1; i < arrRcvMsg.length; i++)
			{
				if ("{MAIN".equals(arrRcvMsg[i])) {
					bkgObChnRcvVO = new BkgObChnRcvVO();
					// header
					bkgObChnRcvVO.setChnEdiMsgTpId(arrRcvMsg[0].substring(12, 15));
					bkgObChnRcvVO.setMsgRcvNo(arrRcvMsg[0].substring(68, 77));
					bkgObChnRcvVO.setCreUsrId(sUsrId);
					bkgObChnRcvVO.setRcvLogSeq(String.valueOf(iCnt++));
					continue;
				}
				if ("}MAIN".equals(arrRcvMsg[i])) {
					bkgObChnRcvVOs.add(bkgObChnRcvVO);
					continue;
				}
				// Because sometimes nothing after the delimiter ":", use the key and value separately by the count
				st = new StringTokenizer(arrRcvMsg[i], ":");
				if (st.countTokens() == 2) {
					key = st.nextToken();
					value = st.nextToken().trim();
				}
				else if (st.countTokens() == 1) {
					key = st.nextToken();
					value = "";
				}
				else
				{
					break;
				}
				// Key, Value
				if ("BKG_NO".equals(key)) {
					bkgObChnRcvVO.setBkgNo(value);
					continue;
				}
				if ("EIR_DATE".equals(key)) {
					bkgObChnRcvVO.setEirXchDt(value);
					continue;
				}
				if ("POL_NAME".equals(key)) {
					bkgObChnRcvVO.setPolNm(value);
					continue;
				}
				if ("POD_NAME".equals(key)) {
					bkgObChnRcvVO.setPodNm(value);
					continue;
				}
				if ("VVD".equals(key)) {
					bkgObChnRcvVO.setVvdCd(value);
					continue;
				}
				if ("VSL_NAME".equals(key)) {
					bkgObChnRcvVO.setVvdNm(value);
					continue;
				}
				if ("CT_LOC_CD".equals(key)) {
					bkgObChnRcvVO.setCstmsLocCd(value);
					continue;
				}
				if ("CNTR_NO".equals(key)) {
					bkgObChnRcvVO.setCntrNo(value);
					continue;
				}
				if ("CT_DATE".equals(key)) {
					bkgObChnRcvVO.setCgorDt(value);
					continue;
				}
			}
			dbDao.addBkgObChnRcv(bkgObChnRcvVOs);
		}
		catch (DAOException ex) 
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	

	
	/**
	 * BDR Status를 기간 및 BKG Office별로 조회한다.
	 * 
	 * @param BDRBookingStatusListVO bdrBookingStatusListVO
	 * @return List<BDRBookingStatusListVO>
	 * @exception EventException
	 */
	public List<BDRBookingStatusListVO> searchBDRBookingPfmcStatusList(BDRBookingStatusListVO bdrBookingStatusListVO) throws EventException {
		try {
			return dbDao.searchBDRBookingPfmcStatusList(bdrBookingStatusListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * 1.Office List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param DocPFMCOfcListVO vo
	 * @return List<DocPFMCOfcListVO>
	 * @throws EventException
	 */
	public List<DocPFMCOfcListVO> searchDocPFMCOfcList(DocPFMCOfcListVO vo) throws EventException {
		try {
			return dbDao.searchDocPFMCOfcList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Doc Performance Report(ESM_BKG_0214)<br>
	 * 2.B/L List -Documentation 실적 산출 기능 조회 화면<br>
	 * 
	 * @param DocPFMCBLListVO vo
	 * @return List<DocPFMCBLListVO>
	 * @throws EventException
	 */
	public List<DocPFMCBLListVO> searchDocPFMCBLList(DocPFMCBLListVO vo) throws EventException {
		try {
			return dbDao.searchDocPFMCBLList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회이벤트 처리<br>
	 * Performancereport화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @return List<RbcvesselVO>
	 * @exception EventException
	 */
	public List<RbcvesselVO> searchRBCVesselList(String fromDt, String toDt) throws EventException {
		try {
			return dbDao.searchRBCVesselList(fromDt, toDt);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}
	
	/**
	 * Sales Performance Report (ESM_BKG_0632)를 조회합니다.<br>
	 * 
	 * @param SaelsPerformanceReportInVO vo
	 * @return List<SaelsPerformanceReportOutVO>
	 * @throws EventException
	 */
	public List<SaelsPerformanceReportOutVO> searchSalesPerformanceReport(SaelsPerformanceReportInVO vo) throws EventException {

		try {
			return dbDao.searchSalesPerformanceReport(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Vessel Utilization Status vs. Bsa by Lane 에 Trade Code 를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportInVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationTrade(VesselUtilizationStatusReportInVO vo) throws EventException{
    	try{
    		return dbDao.searchVesselUtilizationTrade(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
	 * Vessel Utilization Status vs. Bsa by Lane 에 Sub Trade Code 를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportInVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationSubTrade(VesselUtilizationStatusReportInVO vo) throws EventException{
    	
    	try{
    		return dbDao.searchVesselUtilizationSubTrade(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
	 * Vessel Utilization Status vs. Bsa by Lane 에 Bound Code 를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportInVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportInVO> searchVesselUtilizationBound(VesselUtilizationStatusReportInVO vo) throws EventException{
    	
    	try{
    		return dbDao.searchVesselUtilizationBound(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
	 * Vessel Utilization Status vs. Bsa by Lane 에 BSA by Lane 리스트를 조회합니다. (ESM_BKG_0746)<br>
	 * 
	 * @param  VesselUtilizationStatusReportInVO vo
	 * @return List<VesselUtilizationStatusReportOutVO>
	 * @throws EventException
	 */	
    public List<VesselUtilizationStatusReportOutVO> searchVesselUtilizationStatusReport(VesselUtilizationStatusReportInVO vo) throws EventException{
    	
    	List<VesselUtilizationStatusReportOutVO> list  = null;    	
    	
    	try{
    		    		
    		list = dbDao.searchVesselUtilizationStatusReport(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
		return list;
    }      
	
	/**
	 * 0940 I/B DOC Performance Report 정보를 조회합니다.<br>
	 * 
	 * @param InBoundReportInVO inBoundReportInVO
	 * @return List<InBoundReportOutVO>
	 * @throws EventException
	 */
	public List<InBoundReportOutVO> searchInBoundPfmcReport(InBoundReportInVO inBoundReportInVO) throws EventException {
		try {
			return dbDao.searchInBoundPfmcReport(inBoundReportInVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회이벤트 처리<br>
	 * Freight & Charge List by VVD 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchFCLListVO searchFCLListVO
	 * @return List<SearchFCLListVO>
	 * @exception EventException
	 */
	public List<SearchFCLListVO> searchFCLList(SearchFCLListVO searchFCLListVO) throws EventException {
		try {
			return dbDao.searchFCLList(searchFCLListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Freight & Charge 요약 리포트 조회한다. 화면 - ESM_BKG_0595
	 * 
	 * @param FreightChargeSummaryReportInVO vo
	 * @return List<FreightChargeSummaryReportInVO>
	 * @throws EventException
	 */
	public List<FreightChargeSummaryReportInVO> searchFrtSumList(FreightChargeSummaryReportInVO vo) throws EventException {
		try {
			return dbDao.searchFrtSumList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	
}