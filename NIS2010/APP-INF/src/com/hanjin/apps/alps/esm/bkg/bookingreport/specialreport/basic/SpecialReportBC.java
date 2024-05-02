/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialReportBC.java
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
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.BkgRptSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.SpecialCargoManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.SpecialCargoSummaryReportVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Bookingreport Business Logic Command Interface<br>
 * - NIS2010-Bookingreport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kang dong yun
 * @see Esm_bkg-0896EventResponse 참조
 * @since J2EE 1.6
 */

public interface SpecialReportBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Specialreport화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String usrId
	 * @param String rptId
	 * @param String bkgRptKndCd
	 * @return List<BkgRptSetVO>
	 * @exception EventException
	 */
	public List<BkgRptSetVO> searchReportTemplateId(String usrId, String rptId, String bkgRptKndCd) throws EventException;
	/**
	 * 멀티 이벤트 처리<br>
	 * Specialreport 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ReportTemplateListVO[] reportTemplateListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyReportTemplate(ReportTemplateListVO[] reportTemplateListVO,SignOnUserAccount account) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * Specialreport화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String usrId
	 * @return List<BkgRptSetVO>
	 * @exception EventException
	 */
	public List<BkgRptSetVO> searchUserInfo(String usrId) throws EventException;
	
	/**
	 *  0104 Report template(Default, Detail, User Set) 을 조회합니다.<br>
	 *  
	 * @param ReportTemplateListVO reportTemplateListVO
	 * @return List<ReportTemplateListVO>
	 * @throws EventException
	 */
	public List<ReportTemplateListVO> searchReportTemplateBstVipList(ReportTemplateListVO reportTemplateListVO) throws EventException;
	
	 /**
	 * 0104_01 S/Route Code(MDM table Sconti_cd) 목록을 조회합니다.<br>
	 * @return List<BkgComboVO>
	 * @throws EventException
	 */
	 public List<BkgComboVO> searchScontiCd() throws EventException;	
	 
    /**
	 * VVD별 special cargo 요약정보 조회 기능(ESM_BKG_0588)<br>
	 * Special cargo summary information<br>
	 * 
	 * @param SpecialCargoSummaryReportVO vo
	 * @return List<SpecialCargoSummaryReportVO>
	 * @throws EventException
	 */
	public List<SpecialCargoSummaryReportVO> searchSpecialCargoSummaryReport(SpecialCargoSummaryReportVO vo) throws EventException ;
	
 
    /**
	 * Special Cargo Manifest 기본정보 조회(ESM_BKG_0485)<br>
	 * Special Cargo Manifest<br>
	 * 
	 * @param SpecialCargoManifestInfoVO vo
	 * @return List<SpecialCargoManifestInfoVO>
	 * @throws EventException
	 */
	public List<SpecialCargoManifestInfoVO> searchSpecialCargoManifestInfo(SpecialCargoManifestInfoVO vo) throws EventException ;
	
	/**
	 * Special Cargo Manifest RD 존재 유무 Check(ESM_BKG_0485)<br>
	 * Special Cargo Manifest<br>
	 * 
	 * @param SpecialCargoManifestInfoVO vo
	 * @return List<SpecialCargoManifestInfoVO>
	 * @throws EventException
	 */
	public List<SpecialCargoManifestInfoVO> checkSpecialCargoManifestRd(SpecialCargoManifestInfoVO vo) throws EventException ;

}
