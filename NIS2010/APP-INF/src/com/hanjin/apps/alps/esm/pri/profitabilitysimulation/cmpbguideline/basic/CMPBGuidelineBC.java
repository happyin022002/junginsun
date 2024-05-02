/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineBC.java
*@FileTitle : CMPB Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.30 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.CmpbGuidelineVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltCmpbGuidelineReportVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltCmpbGuidelineVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltOriDestLocationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltPriCmpbGlineServiceLaneVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltRepCmdtAndCmdtVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCmpbGlineBseVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;

/**
 * NIS2010-Profitabilitysimulation Business Logic Command Interface<br>
 * - NIS2010-Profitabilitysimulation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Jun,Lee
 * @see Esm_pri_6001EventResponse 참조
 * @since J2EE 1.6
 */

public interface CMPBGuidelineBC {
	
	
	/**
	 *  CMPB Guideline- SVC Lane(ESM_PRI_6039) 을 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return List<RsltPriCmpbGlineServiceLaneVO>
	 * @exception EventException
	 */
	public List<RsltPriCmpbGlineServiceLaneVO> searchServiceLaneList(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException;
	
	
	/**
	 *  CMPB Guideline Inquiry(ESM_PRI_6003)을 조회한다.<br>
	 * 
	 * @param RsltCmpbGuidelineVO rsltCmpbGuidelineVO 
	 * @return List<RsltCmpbGuidelineReportVO>
	 * @exception EventException
	 */
	public List<RsltCmpbGuidelineReportVO> searchCmpbGuidelineReportList(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) throws EventException;
	
	
	/**
	 *  CMPB Guideline Inquiry(ESM_PRI_6003) OFFICE COMBO 조회한다.<br>
	 * 
	 * @param RsltCmpbGuidelineVO rsltCmpbGuidelineVO 
	 * @return List<PriCmpbGlineMnVO>
	 * @exception EventException
	 */
	public List<PriCmpbGlineMnVO> searchReportCreationOfficeList(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) throws EventException;
	
	
	/**
	 *  CMPB Guideline Creation 메인 화면을 조회한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO 
	 * @return CmpbGuidelineVO
	 * @exception EventException
	 */
	public CmpbGuidelineVO searchCmpbGuidelineMain(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO) throws EventException;
	
	
	/**
	 *  CMPB Guideline Creation Route List를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return CmpbGuidelineVO
	 * @exception EventException
	 */
	public CmpbGuidelineVO searchCmpbGuidelineRouteList(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException;
	
	
	/**
	 *  CMPB Guideline Creation Rate 관련 정보를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return CmpbGuidelineVO
	 * @exception EventException
	 */
	public CmpbGuidelineVO searchCmpbGuidelineRateList(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException;
	
	
	/**
	 *  CMPB Guideline Creation 듀레이션 콤보 List를 조회한다.<br>
	 * 
	 * @param PriCmpbGlineBseVO priCmpbGlineBseVO 
	 * @return CmpbGuidelineVO
	 * @exception EventException
	 */
	public CmpbGuidelineVO searchDurationCreationOfficeList(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException;
	
	
	
	/**
	 * CMPB Guideline Creation Route Base 관련 정보를 저장한다.<br>
	 * 
	 * @param CmpbGuidelineVO cmpbGuidelineVO 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageBaseCmpbGuideline(CmpbGuidelineVO cmpbGuidelineVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * CMPB Guideline Creation 메인 관련 정보를 저장한다.<br>
	 * 
	 * @param cmpbGuidelineVO CmpbGuidelineVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMainCmpbGuideline(CmpbGuidelineVO cmpbGuidelineVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * CMPB Guideline Creation  RATE 관련 테이블 저장한다.<br>
	 * 
	 * @param cmpbGuidelineVO CmpbGuidelineVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageRateCmpbGuideline(CmpbGuidelineVO cmpbGuidelineVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * CMPB Guideline Creation 전체를 삭제한다<br>
	 * 
	 * @param priCmpbGlineBseVO PriCmpbGlineBseVO
	 * @exception EventException
	 */
	public void removeCmpbGuideline(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException;
	
	/**
	 * CMPB Guideline Creation Base SEQ 별 삭제한다<br>
	 * 
	 * @param priCmpbGlineBseVO PriCmpbGlineBseVO
	 * @exception EventException
	 */
	public void removeCmpbGuidelineByBase(PriCmpbGlineBseVO priCmpbGlineBseVO) throws EventException;
	
	
	/**
	 * 사용자가 Guideline을 컨폼한다.<br>
	 * 
	 * @param priCmpbGlineMnVO PriCmpbGlineMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmCmpbGuideline(PriCmpbGlineMnVO priCmpbGlineMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 사용자가 Guideline을 컨폼 cancel한다.<br>
	 * 
	 * @param priCmpbGlineMnVO PriCmpbGlineMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmCancelCmpbGuideline(PriCmpbGlineMnVO priCmpbGlineMnVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * 헤더 별 copy하여 등록한다<br>
	 * 
	 * @param rsltDurationCreationOfficeVO RsltDurationCreationOfficeVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyCmpbGuideline(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * Max Gline_seq를 조회한다.<br>
	 * 
	 * @param priCmpbGlineMnVO PriCmpbGlineMnVO
	 * @return int
	 * @exception EventException
	 */
	public int searchCmpbGuidelineMaxGlineSeq(PriCmpbGlineMnVO priCmpbGlineMnVO) throws EventException;
	
	
	/**
	 *  CMPB Guideline EXCEL DOWN(ESM_PRI_6001) 화면을 조회한다.<br>
	 * 
	 * @param  rsltDurationCreationOfficeVO RsltDurationCreationOfficeVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO) throws EventException;
	
	
	/**
	 * CMPB Guideline LOAD EXCEL(ESM_PRI_6001)을 저장한다.<br>
	 * 
	 * @param priCmpbGlineBseVO PriCmpbGlineBseVO
	 * @param rsltRtListVerticalExcelVOs RsltRtListVerticalExcelVO[]
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void uploadRateExcelVertical(PriCmpbGlineBseVO priCmpbGlineBseVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) 
	throws EventException;
	
	
	/**
	 * CMPB Guideline LOAD EXCEL(ESM_PRI_6001)을 조회한다. <br>
	 * 
	 * @param priCmpbGlineBseVO PriCmpbGlineBseVO
	 * @param rsltRtListVerticalExcelVOs RsltRtListVerticalExcelVO[] 
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriCmpbGlineBseVO priCmpbGlineBseVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) 
		throws EventException;
	
	
	/**
	 * CMPB Guideline Inquiry(ESM_PRI_6003) Origin, Dest Location 정보를 조회한다.<br>
	 * 
	 * @param RsltCmpbGuidelineVO rsltCmpbGuidelineVO 
	 * @return List<RsltRepCmdtAndCmdtVO>
	 * @exception EventException
	 */
	public List<RsltRepCmdtAndCmdtVO> searchCommodityList(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) throws EventException;
	
	/**
	 * CMPB Guideline Inquiry(ESM_PRI_6003) Origin, Dest Location 정보를 조회한다.<br>
	 * 
	 * @param RsltCmpbGuidelineVO rsltCmpbGuidelineVO 
	 * @return List<RsltOriDestLocationVO>
	 * @exception EventException
	 */
	public List<RsltOriDestLocationVO> searchLocationList(RsltCmpbGuidelineVO rsltCmpbGuidelineVO) throws EventException ;
}