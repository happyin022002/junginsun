/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SpecialReportBCImpl.java
 *@FileTitle : BookingReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.28
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.05.28 강동윤
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration.SpecialReportDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.BkgRptSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.SpecialCargoManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.SpecialCargoSummaryReportVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-BookingReport Business Logic Basic Command implementation<br>
 * - NIS2010-BookingReport에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kang dong yun
 * @see ESM_BKG-0896EventResponse,SpecialReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SpecialReportBCImpl extends BasicCommandSupport implements SpecialReportBC {

	// Database Access Object
	private transient SpecialReportDBDAO dbDao = null;

	/**
	 * SpecialReportBCImpl 객체 생성<br>
	 * SpecialReportDBDAO를 생성한다.<br>
	 */
	public SpecialReportBCImpl() {
		dbDao = new SpecialReportDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SpecialReport화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String usrId
	 * @param String rptId
	 * @param String bkgRptKndCd
	 * @return List<BkgRptSetVO>
	 * @exception EventException
	 */
	public List<BkgRptSetVO> searchReportTemplateId(String usrId, String rptId, String bkgRptKndCd) throws EventException {
		try {
			return dbDao.searchReportTemplateId(usrId, rptId, bkgRptKndCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ReportTemplateListVO[] reportTemplateListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyReportTemplate(ReportTemplateListVO[] reportTemplateListVO, SignOnUserAccount account) throws EventException {
		try {

			for (int i = 0; i < reportTemplateListVO.length; i++) {

				log.debug("flag >>>>>>>>>>>>>>>>>>>> " + reportTemplateListVO[i].getIbflag());
				if (reportTemplateListVO[i].getIbflag().equals("I")) {
					reportTemplateListVO[i].setUpdUsrId(account.getUsr_id());

					dbDao.addReportTemplateList(reportTemplateListVO[i]);
				} else if (reportTemplateListVO[i].getIbflag().equals("U")) {
					reportTemplateListVO[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifyReportTemplateList(reportTemplateListVO[i]);
				} else if (reportTemplateListVO[i].getIbflag().equals("D")) {

					dbDao.removeReportTemplateList(reportTemplateListVO[i]);
				}
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
	 * 조회 이벤트 처리<br>
	 * SpecialReport화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String usrId
	 * @return List<BkgRptSetVO>
	 * @exception EventException
	 */
	public List<BkgRptSetVO> searchUserInfo(String usrId) throws EventException {
		try {
			return dbDao.searchUserInfo(usrId);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 0104 Report template(Default, Detail, User Set) 을 조회합니다.<br>
	 * 
	 * @param ReportTemplateListVO reportTemplateListVO
	 * @return List<ReportTemplateListVO>
	 * @throws EventException
	 */
	public List<ReportTemplateListVO> searchReportTemplateBstVipList(ReportTemplateListVO reportTemplateListVO) throws EventException {

		try {
			return dbDao.searchReportTemplateBstVipList(reportTemplateListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 0104_01 S/Route Code(MDM table Sconti_cd) 목록을 조회합니다.<br>
	 * 
	 * @return List<BkgComboVO>
	 * @throws EventException
	 */
	public List<BkgComboVO> searchScontiCd() throws EventException {

		try {
			return dbDao.searchScontiCd();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	
	/**
	 * VVD별 special cargo 요약정보 조회 기능(ESM_BKG_0588)<br>
	 * Special cargo summary information<br>
	 * 
	 * @param SpecialCargoSummaryReportVO vo
	 * @return List<SpecialCargoSummaryReportVO>
	 * @throws EventException
	 */
	public List<SpecialCargoSummaryReportVO> searchSpecialCargoSummaryReport(SpecialCargoSummaryReportVO vo) throws EventException {
		try {
			return dbDao.searchSpecialCargoSummaryReport(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Special Cargo Manifest 기본정보 조회(ESM_BKG_0485)<br>
	 * Special Cargo Manifest<br>
	 * 
	 * @param SpecialCargoManifestInfoVO vo
	 * @return List<SpecialCargoManifestInfoVO>
	 * @throws EventException
	 */
	public List<SpecialCargoManifestInfoVO> searchSpecialCargoManifestInfo(SpecialCargoManifestInfoVO vo) throws EventException {
		try {
			return dbDao.searchSpecialCargoManifestInfo(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Special Cargo Manifest RD 존재 유무 Check(ESM_BKG_0485)<br>
	 * Special Cargo Manifest<br>
	 * 
	 * @param SpecialCargoManifestInfoVO vo
	 * @return List<SpecialCargoManifestInfoVO>
	 * @throws EventException
	 */
	public List<SpecialCargoManifestInfoVO> checkSpecialCargoManifestRd(SpecialCargoManifestInfoVO vo) throws EventException {
		try {
			return dbDao.checkSpecialCargoManifestRd(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

}
