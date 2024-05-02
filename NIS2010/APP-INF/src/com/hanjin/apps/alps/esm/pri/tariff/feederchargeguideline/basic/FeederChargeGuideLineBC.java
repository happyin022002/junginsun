/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : FeederChargeGuideLineBC.java
 *@FileTitle : Feeder Charge Guideline Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
 * 2013.07.31 [CHM-201326002] 전윤주 DG Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시 
 *                           DG Service flag check 메서드 추가
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.ComboFdrRhqCdListVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRDGSurchargeVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRProgVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchFDRAmendmentHistoryDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchFDRAmendmentHistoryMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchTariffInquiryVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.TariffInquiryListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTrfFdrRtVO;

/**
 * Business Logic Command Interface<br>
 * 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author LEE EUN-SUP
 * @see
 * @since J2EE 1.6
 */
public interface FeederChargeGuideLineBC {

	/**
	 * ESM_PRI_7003_01, ESM_PRI_7003_02 : Feeder/IHC Tariff Inquiry
	 * 
	 * @param searchTariffInquiryVO
	 * @return List<TariffInquiryListVO>
	 * @throws EventException
	 */
	public List<TariffInquiryListVO> searchTariffInquiryList(SearchTariffInquiryVO searchTariffInquiryVO) throws EventException;

	/**
	 * ESM_PRI_7003_01, ESM_PRI_7003_02 : Feeder/IHC Tariff Inquiry - 버튼 색 표시를 위한 조회
	 * 
	 * @param tariffInquiryListVO
	 * @return List<TariffInquiryListVO>
	 * @throws EventException
	 */
	public List<TariffInquiryListVO> searchTariffInquiryAddOnDgFlag(TariffInquiryListVO tariffInquiryListVO) throws EventException;
	
	/**
	 * ESM_PRI_7011 : Retrieve form <br>
	 * Retrieve form data <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<FDRMainVO>
	 * @exception EventException
	 */
	public List<FDRMainVO> searchFDRMain(FDRMainVO fDRMainVO) throws EventException;

	/**
	 * ESM_PRI_7011 : Retrieve sheet <br>
	 * Retrieve sheet data <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<FDRDetailVO>
	 * @exception EventException
	 */
	public List<FDRDetailVO> searchFDRDetail(FDRMainVO fDRMainVO) throws EventException;

	/**
	 * ESM_PRI_7011 : Save <br>
	 * Save data <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @param FDRDetailVO[] fDRDetailVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void manageFDR(FDRMainVO fDRMainVO, FDRDetailVO[] fDRDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_7011 : Confirm <br>
	 * Confirm <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @param FDRProgVO fDRProgVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void confirmFDR(FDRMainVO fDRMainVO, FDRProgVO fDRProgVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_7011 : Cancel <br>
	 * Cancel <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void cancelFDR(FDRMainVO fDRMainVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_7011 : Amend <br>
	 * Amend <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @param FDRProgVO fDRProgVO
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void amendFDR(FDRMainVO fDRMainVO, FDRProgVO fDRProgVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_7011 : Confirm <br>
	 * Retrieve pre version eff_dt <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<FDRMainVO>
	 * @exception EventException
	 */
	public List<FDRMainVO> checkPreFDR(FDRMainVO fDRMainVO) throws EventException;

	/**
	 * ESM_PRI_7011 : Amend <br>
	 * Retrieve MAX COST_TRF_NO <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<FDRMainVO>
	 * @exception EventException
	 */
	public List<FDRMainVO> checkMaxCostTrfNoFDR(FDRMainVO fDRMainVO) throws EventException;

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * 
	 * @param fdrDetailVO
	 * @param priTrfFdrRtVOs
	 * @throws EventException
	 */
	public void uploadAddonCreation(FDRDetailVO fdrDetailVO, PriTrfFdrRtVO[] priTrfFdrRtVOs) throws EventException;

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * CHECK 버튼
	 * 
	 * @param priTrfFdrRtVOs
	 * @return
	 * @throws EventException
	 */
	public List<String> uploadAddonCreationCheck(PriTrfFdrRtVO[] priTrfFdrRtVOs) throws EventException;

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * 저장전 Feeder Status 조회
	 * 
	 * @param fdrDetailVO
	 * @return String
	 * @throws EventException
	 */
	public String searchFeederStatus(FDRDetailVO fdrDetailVO) throws EventException;

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * 서비스 코드에 따른 RHQ_CD 조회
	 * 
	 * @param fdrDetailVO
	 * @return List<ComboFdrRhqCdListVO>
	 * @throws EventException
	 */
	public List<ComboFdrRhqCdListVO> comboFdrRhqCdList(FDRDetailVO fdrDetailVO) throws EventException;

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * location 코드 존재 여부 체크
	 * 
	 * @param fdrDetailVO
	 * @return int
	 * @throws EventException
	 */
	public int checkLocCode(String locCd) throws EventException;

	/**
	 * ESM_PRI_7026 : FDR Tariff Amendment History Main <br>
	 * Retrieve FDR Tariff Amendment History Main <br>
	 * 
	 * @param SearchFDRAmendmentHistoryMainVO searchFDRAmendmentHistoryMainVO
	 * @return List<SearchFDRAmendmentHistoryMainVO>
	 * @exception EventException
	 */
	public List<SearchFDRAmendmentHistoryMainVO> searchFDRAmendmentHistoryMain(SearchFDRAmendmentHistoryMainVO searchFDRAmendmentHistoryMainVO) throws EventException;

	/**
	 * ESM_PRI_7026 : Add-on Tariff Amendment History Detail <br>
	 * Retrieve Add-on Tariff Amendment History detail <br>
	 * 
	 * @param SearchFDRAmendmentHistoryDetailVO searchFDRAmendmentHistoryDetailVO
	 * @return List<SearchFDRAmendmentHistoryDetailVO>
	 * @exception EventException
	 */
	public List<SearchFDRAmendmentHistoryDetailVO> searchFDRAmendmentHistoryDetail(SearchFDRAmendmentHistoryDetailVO searchFDRAmendmentHistoryDetailVO) throws EventException;

	/**
	 * ESM_PRI_7028 : Add-On Tariff Amendment DG Cargo Inquiry <br>
	 * Retrieve Add-On Tariff Amendment DG Cargo Inquiry <br>
	 * 
	 * @param FDRDGSurchargeVO fDRDGSurchargeVO
	 * @return List<FDRDGSurchargeVO>
	 * @exception EventException
	 */
	public List<FDRDGSurchargeVO> searchFDRDGSurcharge(FDRDGSurchargeVO fDRDGSurchargeVO) throws EventException;
	
	/**
	 * ESM_PRI_7007 : update max FDR_TRF_NO's exp_dt <br>
	 * PRI_TRF_FDR_MN, PRI_TRF_FDR_DUR
	 * 
	 * @param FDRMainVO[] fDRMainVOs
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	public void confirmFDRExpDt(FDRMainVO[] fDRMainVOs, SignOnUserAccount account) throws EventException;

}
