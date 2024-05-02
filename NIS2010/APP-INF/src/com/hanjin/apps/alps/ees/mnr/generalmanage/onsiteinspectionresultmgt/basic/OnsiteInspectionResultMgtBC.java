/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnsiteInspectionResultMgtBC.java
*@FileTitle : OnsiteInspection Result Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.07.21 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSite2VO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSiteVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author LEE YULKYU
 * @see Ui_mnr_0273EventResponse 참조
 * @since J2EE 1.4
 */

public interface OnsiteInspectionResultMgtBC {
	/**
	 * [EES_MNR_0273]M&R Onsite Inspection Result Detail 의 정보를 조회 합니다. <br>
	 *
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @return List<MnrOnSiteVO>
	 * @exception EventException
	 */
	public List<MnrOnSiteVO> searchMnrOnsiteInspectionResultDetail(MnrOnSiteVO mnrOnSiteVO) throws EventException;
	
	/**
	 * [EES_MNR_0273]M&R Onsite Inspection Result Detail 의 정보를 갱신 합니다. <br>
	 *
	 * @param MnrOnSiteVO[] mnrOnSiteVOs
	 * @exception EventException
	 */
	public void updateMnrOnsiteInspectionResultDetail(MnrOnSiteVO[] mnrOnSiteVOs) throws EventException;
	
	/**
	 * [EES_MNR_0273]M&R Onsite Inspection Result Detail 의 정보를 삭제 합니다. <br>
	 *
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @exception EventException
	 */
	public void deleteMnrOnsiteInspectionResultDetail(MnrOnSiteVO mnrOnSiteVO) throws EventException;
	
	/**
	 * [EES_MNR_0271]M&R Onsite Inspection Result Header 의 정보를 조회 합니다. <br>
	 *
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @return List<MnrOnSiteVO>
	 * @exception EventException
	 */
	public List<MnrOnSiteVO> searchMnrOnsiteInspectionResultHeader(MnrOnSiteVO mnrOnSiteVO) throws EventException;
	
	/**
	 * [EES_MNR_0274]M&R Onsite Inspection Result 의 설문항목들을 조회 합니다. <br>
	 *
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @return List<MnrOnSiteVO>
	 * @exception EventException
	 */
	public List<MnrOnSiteVO> searchOnsiteInspectionResultItems(MnrOnSiteVO mnrOnSiteVO) throws EventException;
	
	/**
	 * [EES_MNR_0274]M&R Onsite Inspection Result 의 설문항목들을 수정/삭제 합니다. <br>
	 *
	 * @param MnrOnSiteVO[] mnrOnSiteVOs
	 * @exception EventException
	 */
	public void insertOnsiteInspectionResultItems(MnrOnSiteVO[] mnrOnSiteVOs) throws EventException;

	/**
	 * [EES_MNR_0271]M&R Onsite Inspection Result Header 의 정보를 조회 합니다. <br>
	 *
	 * @param MnrOnSite2VO mnrOnSite2VO
	 * @return List<MnrOnSite2VO>
	 * @exception EventException
	 */
	public List<MnrOnSite2VO> searchMnrOnsiteInspectionResultHeader2(MnrOnSite2VO mnrOnSite2VO) throws EventException;
}