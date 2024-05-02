/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SpecialReportBCImpl.java
 *@FileTitle : BookingReport
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion :
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.specialreport.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.integration.SpecialReportDBDAO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.BkgRptSetVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.SpecialCargoManifestInfoVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.SpecialCargoSummaryReportVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-BookingReport Business Logic Basic Command implementation<br>
 * - OPUS-BookingReport handling business transaction.<br>
 * 
 * @author
 * @see SpecialReportBC refer to each DAO class
 * @since J2EE 1.6
 */
public class SpecialReportBCImpl extends BasicCommandSupport implements SpecialReportBC {

	// Database Access Object
	private transient SpecialReportDBDAO dbDao = null;

	/**
	 * Generating SpecialReportBCImpl Object<br>
	 * Generating SpecialReportDBDAO<br>
	 */
	public SpecialReportBCImpl() {
		dbDao = new SpecialReportDBDAO();
	}

	/**
	 *  Handling retrieving event of SpecialReport<br>
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
	 *  Handling retrieving event of SpecialReport<br>
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
	 *  Handling retrieving event of SpecialReport<br>
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
	 *  Handling retrieving event of 0104 Report template(Default, Detail, User Set) .<br>
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
	 *  Handling retrieving event of 0104_01 S/Route Code(MDM table Sconti_cd)<br>
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
	 *  Handling retrieving event of  special cargo(ESM_BKG_0588)<br>
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
	 *  Handling retrieving event of Special Cargo Manifest(ESM_BKG_0485)<br>
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

}
