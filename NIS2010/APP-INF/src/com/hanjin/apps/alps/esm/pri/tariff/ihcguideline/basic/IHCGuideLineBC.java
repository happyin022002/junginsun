/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : IHCGuideLineBC.java
 *@FileTitle : IHC Guide Line 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================
 * History
 * 2013.06.10 서미진 [선처리 CSR] Load Excel data 의 증가로 backendjob으로 upload 로직 변경
 * 2013.08.01 전윤주 [CHM-201326002] DG Overweight Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시 
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.basic;

import java.util.List;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCTariffInquiryListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.PriTrfIHCRtVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIHCAmendmentHistoryDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIHCAmendmentHistoryMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIhcTariffInquiryVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchUsInlandServiceModeTotalVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchUsTariffInquiryListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SpecialCargoPopupListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTrfIhcProgVO;

/**
 * Business Logic Command Interface<br>
 * 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author LEE EUN-SUP
 * @see
 * @since J2EE 1.6
 */
public interface IHCGuideLineBC {

	/**
	 * ESM_PRI_7004 :: IHC Tariff Inquiry
	 * 
	 * @param searchTariffInquiryVO
	 * @return List<IHCTariffInquiryListVO>
	 * @throws EventException
	 */
	public List<IHCTariffInquiryListVO> searchIhcTariffInquiryList(SearchIhcTariffInquiryVO searchIhcTariffInquiryVO) throws EventException;

	/**
	 * ESM_PRI_7024 :: IHC Tariff Creation & Amendment – Special Pop up
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO 
	 * @return List<SpecialCargoPopupListVO>
	 * @throws EventException
	 */
	public List<SpecialCargoPopupListVO> searchSpecialCargoPopupList(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException;

	/**
	 * ESM_PRI_7001 : Retrieve form <br>
	 * Retrieve form data <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<IHCGuidelineMainVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineMainVO> searchIHCGuidelineMain(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException;

	/**
	 * ESM_PRI_7001_01, ESM_PRI_7001_02 : Retrieve sheet <br>
	 * Retrieve sheet data <br>
	 * 
	 * @param IHCGuidelineDetailVO iHCGuidelineDetailVO
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> searchIHCGuidelineDetail(IHCGuidelineDetailVO iHCGuidelineDetailVO) throws EventException;

	/**
	 * ESM_PRI_7001 : Save <br>
	 * Save data <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param IHCGuidelineDetailVO [] iHCGuidelineDetailVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageIHCGuidelineMain(IHCGuidelineMainVO iHCGuidelineMainVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_7001_01 : Save <br>
	 * Save data <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param IHCGuidelineDetailVO [] iHCGuidelineDetailVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageIHCGuidelineDetail(IHCGuidelineMainVO iHCGuidelineMainVO, IHCGuidelineDetailVO[] iHCGuidelineDetailVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * ESM_PRI_7001 : Confirm <br>
	 * Confirm <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param PriTrfIhcProgVO priTrfIhcProgVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void confirmIHCGuidelineMain(IHCGuidelineMainVO iHCGuidelineMainVO, PriTrfIhcProgVO priTrfIhcProgVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_7001 : Cancel <br>
	 * Cancel <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void cancelIHCGuidelineMain(IHCGuidelineMainVO iHCGuidelineMainVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_7001 : Amend <br>
	 * Amend <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param PriTrfIhcProgVO priTrfIhcProgVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void amendIHCGuideline(IHCGuidelineMainVO iHCGuidelineMainVO, PriTrfIhcProgVO priTrfIhcProgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_7001 :  Confirm <br>
	 * Retrieve pre version eff_dt <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<IHCGuidelineMainVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineMainVO> checkPreIHCGuideline(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException;
	
	/**
	 * ESM_PRI_7001 :  Amend <br>
	 * Retrieve MAX COST_TRF_NO <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<IHCGuidelineMainVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineMainVO> checkMaxCostTrfNo(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException;
	
	/**
	 * ESM_PRI_7025 : IHC Tariff No. Combo <br>
	 * Retrieve IHC Tariff No. Combo <br>
	 * 
	 * @param SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchIHCAmendmentHistoryMainCombo(SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO) throws EventException;
	
	/**
	 * ESM_PRI_7025 : IHC Tariff Amendment History Main <br>
	 * Retrieve IHC Tariff Amendment History Main <br>
	 * 
	 * @param SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO
	 * @return List<SearchIHCAmendmentHistoryMainVO>
	 * @exception EventException
	 */
	public List<SearchIHCAmendmentHistoryMainVO> searchIHCAmendmentHistoryMain(SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO) throws EventException;
	
	/**
	 * ESM_PRI_7025 : IHC Tariff Amendment History Main <br>
	 * DG, Overweight 팝업 버튼 색 변경을 위한 조회 <br>
	 * 
	 * @param IHCTariffInquiryListVO iHCTariffInquiryListVO
	 * @return List<IHCTariffInquiryListVO>
	 * @exception EventException
	 */
	public List<IHCTariffInquiryListVO> searchIHCDgOverWeightFlag(IHCTariffInquiryListVO iHCTariffInquiryListVO) throws EventException;
	
	/**
	 * ESM_PRI_7025 : Retrieve Max seq. <br>
	 * Retrieve IHC Tariff Amendment History Max seq. <br>
	 * 
	 * @param SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO
	 * @return List<SearchIHCAmendmentHistoryMainVO>
	 * @exception EventException
	 */
	public List<SearchIHCAmendmentHistoryMainVO> searchIHCAmendmentHistoryMainMaxSeq(SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO) throws EventException;
	
	/**
	 * ESM_PRI_7025 : IHC Tariff Amendment History Detail <br>
	 * Retrieve IHC Tariff Amendment History detail <br>
	 * 
	 * @param SearchIHCAmendmentHistoryDetailVO searchIHCAmendmentHistoryDetailVO
	 * @return List<SearchIHCAmendmentHistoryDetailVO>
	 * @exception EventException
	 */
	public List<SearchIHCAmendmentHistoryDetailVO> searchIHCAmendmentHistoryDetail(SearchIHCAmendmentHistoryDetailVO searchIHCAmendmentHistoryDetailVO) throws EventException;
	
	/**
	 * ESM_PRI_7006 : update max IHC_TRF_NO's exp_dt <br>
	 * PRI_TRF_IHC_MN, PRI_TRF_IHC_DUR
	 * 
	 * @param IHCGuidelineMainVO[] iHCGuidelineMainVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void confirmIHCExpDt(IHCGuidelineMainVO[] iHCGuidelineMainVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_7031_01 : Save <br>
	 * Save data for US <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @param IHCGuidelineDetailVO [] iHCGuidelineDetailVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageUsIHCGuidelineDetail(IHCGuidelineMainVO iHCGuidelineMainVO, IHCGuidelineDetailVO[] iHCGuidelineDetailVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * ESM_PRI_7031_01, ESM_PRI_7031_02 : Retrieve sheet <br>
	 * Retrieve Inland SVC Mode data for US<br>
	 * 
	 * @param SearchUsInlandServiceModeTotalVO searchUsInlandServiceModeTotalVO
	 * @return List<SearchUsInlandServiceModeTotalVO>
	 * @exception EventException
	 */
	public List<SearchUsInlandServiceModeTotalVO> searchUsInlandServiceModeTotal(SearchUsInlandServiceModeTotalVO searchUsInlandServiceModeTotalVO) throws EventException;
	
	/**
	 * ESM_PRI_7033 : Route Retrieve  <br>
	 * Route Retrieve <br>
	 * 
	 * @param IHCGuidelineDetailVO iHCGuidelineDetailVO
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> searchUsRailIHCGuidelineDetail(IHCGuidelineDetailVO iHCGuidelineDetailVO) throws EventException;
	
	/**
	 * ESM_PRI_7033 : Apply to Tariff <br>
	 * Update Rate data<br>
	 * 
	 * @param IHCGuidelineDetailVO [] iHCGuidelineDetailVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageUsRailIHCGuidelineDetail(IHCGuidelineDetailVO[] iHCGuidelineDetailVOs, SignOnUserAccount account)	throws EventException;
	
	/**
	 * ESM_PRI_7033 : Check  <br>
	 * Check Point - Base port pair <br>
	 * 
	 * @param IHCGuidelineDetailVO [] iHCGuidelineDetailVOs
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> checkUsRailIHCGuidelineDetail(IHCGuidelineDetailVO[] iHCGuidelineDetailVOs) throws EventException;
	
	/**
	 * ESM_PRI_7034 : Retrieve <br>
	 * Retrieve Inland add-on inquiry in local currency (TRO) <br>
	 * 
	 * @param SearchUsTariffInquiryListVO searchUsTariffInquiryListVO
	 * @return List<SearchUsTariffInquiryListVO>
	 * @exception EventException
	 */
	public List<SearchUsTariffInquiryListVO> searchUsTariffInquiryList(SearchUsTariffInquiryListVO searchUsTariffInquiryListVO) throws EventException;
	
	/**
	 * ESM_PRI_7031 : Confirm <br>
	 * validation check 1 - total value is 0 <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<SearchUsInlandServiceModeTotalVO>
	 * @exception EventException
	 */
	public List<SearchUsInlandServiceModeTotalVO> checkUsIHCTariffTotal(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException;
	
	/**
	 * ESM_PRI_7031 : Confirm <br>
	 * validation check 2 - rate tariff tuning or not <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<SearchUsInlandServiceModeTotalVO>
	 * @exception EventException
	 */
	public List<SearchUsInlandServiceModeTotalVO> checkUsIHCTariffTuning(IHCGuidelineMainVO iHCGuidelineMainVO) throws EventException;
	
	/**
	 * ESM_PRI_7001_02 : Save  <br>
	 * Check Add RF IHC GuidelineDetail <br>
	 * 
	 * @param IHCGuidelineDetailVO[] iHCGuidelineDetailVOs
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> checkAddRFIHCGuidelineDetail(IHCGuidelineDetailVO[] iHCGuidelineDetailVOs) throws EventException;
	
	/**
	 * ESM_PRI_7035 : Delete from Tariff <br>
	 * Delete US Route<br>
	 * 
	 * @param IHCGuidelineDetailVO [] iHCGuidelineDetailVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageUsRoute(IHCGuidelineDetailVO[] iHCGuidelineDetailVOs, SignOnUserAccount account) throws EventException;
	

	/**
	 * ESM_PRI_7014 : MULTI  <br>
	 * IHC Guideline Creation / Amend ad Excel <br>
	 * @param IHCDetailVO ihcDetailVO
	 * @param PriTrfIHCRtVO[] priTrfIHCRtVOs
	 * @return String
	 * @throws EventException
	 */
	public String uploadIHCCreation(IHCDetailVO ihcDetailVO, PriTrfIHCRtVO[] priTrfIHCRtVOs) throws EventException;
	
	/**
	 * ESM_PRI_7014 : SEARCH01  <br>
	 * IHC Guideline Creation / Amend ad Excel <br>
	 * IHC의 Status를 확인한다.
	 * @param IHCDetailVO ihcDetailVO
	 * @return String
	 * @throws EventException
	 */
	public String searchIHCStatus(IHCDetailVO ihcDetailVO) throws EventException;
	
	
	/**
	 * ESM_PRI_7014 : SEARCH  <br>
	 * IHC Guideline Creation / Amend ad Excel <br>
	 * loc_cd 중복체크
	 * @param PriTrfIHCRtVO[] priTrfIHCRtVOs
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> uploadIHCCreationCheck(PriTrfIHCRtVO[] priTrfIHCRtVOs) throws EventException;
}
