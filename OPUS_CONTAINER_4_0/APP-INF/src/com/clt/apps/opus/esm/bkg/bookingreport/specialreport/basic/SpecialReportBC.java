/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialReportBC.java
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
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.BkgRptSetVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.SpecialCargoManifestInfoVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.SpecialCargoSummaryReportVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Bookingreport Business Logic Basic Command interface<br>
 * - OPUS-Bookingreport handling business transaction.<br>
 *
 * @author
 * @see SpecialReportBC refer to each DAO class
 * @since J2EE 1.6
 */

public interface SpecialReportBC {
	/**
	 *  Handling retrieving event of SpecialReport<br>
	 * 
	 * @param String usrId
	 * @param String rptId
	 * @param String bkgRptKndCd
	 * @return List<BkgRptSetVO>
	 * @exception EventException
	 */
	public List<BkgRptSetVO> searchReportTemplateId(String usrId, String rptId, String bkgRptKndCd) throws EventException;
	/**
	 *  Handling retrieving event of SpecialReport<br>
	 * 
	 * @param ReportTemplateListVO[] reportTemplateListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyReportTemplate(ReportTemplateListVO[] reportTemplateListVO,SignOnUserAccount account) throws EventException;
	/**
	 *  Handling retrieving event of SpecialReport<br>
	 * 
	 * @param String usrId
	 * @return List<BkgRptSetVO>
	 * @exception EventException
	 */
	public List<BkgRptSetVO> searchUserInfo(String usrId) throws EventException;
	
	/**
	 *  Handling retrieving event of 0104 Report template(Default, Detail, User Set) .<br>
	 * 
	 * @param ReportTemplateListVO reportTemplateListVO
	 * @return List<ReportTemplateListVO>
	 * @throws EventException
	 */
	public List<ReportTemplateListVO> searchReportTemplateBstVipList(ReportTemplateListVO reportTemplateListVO) throws EventException;
	
	/**
	 *  Handling retrieving event of 0104_01 S/Route Code(MDM table Sconti_cd)<br>
	 * 
	 * @return List<BkgComboVO>
	 * @throws EventException
	 */
	 public List<BkgComboVO> searchScontiCd() throws EventException;	
 
	/**
	 *  Handling retrieving event of  special cargo(ESM_BKG_0588)<br>
	 * Special cargo summary information<br>
	 * 
	 * @param SpecialCargoSummaryReportVO vo
	 * @return List<SpecialCargoSummaryReportVO>
	 * @throws EventException
	 */
	public List<SpecialCargoSummaryReportVO> searchSpecialCargoSummaryReport(SpecialCargoSummaryReportVO vo) throws EventException ;
	
 
	/**
	 *  Handling retrieving event of Special Cargo Manifest(ESM_BKG_0485)<br>
	 * Special Cargo Manifest<br>
	 * 
	 * @param SpecialCargoManifestInfoVO vo
	 * @return List<SpecialCargoManifestInfoVO>
	 * @throws EventException
	 */
	public List<SpecialCargoManifestInfoVO> searchSpecialCargoManifestInfo(SpecialCargoManifestInfoVO vo) throws EventException ;

}
