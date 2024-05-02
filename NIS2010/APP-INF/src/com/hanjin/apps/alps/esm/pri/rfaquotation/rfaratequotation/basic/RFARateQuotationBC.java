/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateQuotationBC.java
 *@FileTitle : RFA Quotation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 2009.07.29 송민석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.FicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.FicRouteGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InPriQuotationRateAdjustSetVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.PriRqRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RFARateQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltFicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtCmdtRoutVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtDuplicateCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtGuidelineRateVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtListHorizontalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtListVerticalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalExcelForIHCVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListVerticalExcelForIHCVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriRqHdrVO;
import com.hanjin.syscommon.common.table.PriRqMnVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRqRtScgVO;
import com.hanjin.syscommon.common.table.PriRqRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriRqScgAdjVO;

/**
 * ALPS-Rfaquotation Business Logic Command Interface<br>
 * - ALPS-Rfaquotation에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author SONG MIN SEOK
 * @see Esm_pri_6018EventResponse 참조
 * @since J2EE 1.6
 */

public interface RFARateQuotationBC {
	/**
	 * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
	 * 
	 * @param InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO
	 * @return RsltPrsSurchargeDetailListVO
	 * @exception EventException
	 */
	public RsltPrsSurchargeDetailListVO searchRateSurchargeList(InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO) throws EventException;

	/**
	 * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param PriRqRtScgVO[] priRqRtScgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateSurcharge(PriRqRtScgVO[] priRqRtScgVOs, SignOnUserAccount account) throws EventException;

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @return List<RsltPriPrsCostListVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostListVO> searchCostDetailList(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws EventException;

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 상세 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO
	 * @return List<RsltPriPrsCostDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostDetailVO> searchCostDetailInquiryList(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO) throws EventException;

	/**
	 * PRS- Surcharge Adjust을 조회합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO
	 * @return List<RsltPriSurchargeAdjustListVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO) throws EventException;

	/**
	 * PRS- Surcharge Adjust 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param PriRqScgAdjVO[] priRqScgAdjVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageSurchargeAdjust(PriRqScgAdjVO[] priRqScgAdjVO, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Group을 조회합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityVO> searchRateCommodityAllList(RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO) throws EventException;

	/**
	 * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityDetailVO
	 * @return List<RsltPriSurchargeAdjustCommodityDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityDetailVO> searchRateGroupCommodityDetailList(
			RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityDetailVO) throws EventException;

	/**
	 * Surcharge Adjust-Location Group을 조회 합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupVO> searchRateLocationAllList(RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO)
			throws EventException;

	/**
	 * Surcharge Adjust-Location Group에 상세 정보를 조회 합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupDetailVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupDetailVO> searchRateGroupLocationDetailList(
			RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupDetailVO) throws EventException;

	/**
	 * Trans.Mode에 따른 Cost 상세정보를 조회 합니다.<br>
	 * 
	 * @param RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO
	 * @return List<RsltPriCostDetailByTransModeListVO>
	 * @exception EventException
	 */
	public List<RsltPriCostDetailByTransModeListVO> searchCostDetailByTransModeList(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO)
			throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * CM/OP View All 팝업화면 조회 처리<br>
	 * 
	 * @param RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO
	 * @return List<RsltPriRateCmViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriRateCmViewAllVO> searchRateCmViewAllList(RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * CM/OP View 의 load 값을 갱신처리 합니다.<BR>
	 * 
	 * @param PriRqRtCmdtRoutSetVO priRqRtCmdtRoutSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsPfmc(PriRqRtCmdtRoutSetVO priRqRtCmdtRoutSetVO, SignOnUserAccount account) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * RFA RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다.
	 * 
	 * @param RsltPriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account) throws EventException;

	/**
	 * Pre CM/OP Simulation Cost관련 Cost, CMPB,OPB 값을 갱신.
	 * 
	 * @param RsltPriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsSimulationCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account) throws EventException;

	/**
	 * Quotaion의 route 조회 처리<br>
	 * Quotaion의 route 리스트 조회 이벤트 처리<br>
	 * 
	 * @param String ficRtTpCd
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @return List<RsltPriCommodityRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCommodityRouteVO> searchCommodityRouteList(String ficRtTpCd, InPriCommodityRouteVO inPriCommodityRouteVO) throws EventException;

	/**
	 * Quotaion의 route의 모든 Area 리스트 조회 이벤트 처리<br>
	 * 구분에 따라 조회 하는 테이블을 달리하지만 성격이 같은 route정보를 조회한다.<BR>
	 * 
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCommodityRouteAreaList(InPriCommodityRouteVO inPriCommodityRouteVO) throws EventException;

	/**
	 * S/C Quotaion의 생성 일자를 조회 처리<br>
	 * 
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO searchSCQuotationCreationDate(InPriCommodityRouteVO inPriCommodityRouteVO) throws EventException;

	/**
	 * uotaion Rate 의 Rate Amount값을 갱신처리 합니다.
	 * 
	 * @param String ficRtTpCd
	 * @param InPriQuotationRateAdjustSetVO inPriQuotationRateAdjustSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyRateRfaQuotation(String ficRtTpCd, InPriQuotationRateAdjustSetVO inPriQuotationRateAdjustSetVO, SignOnUserAccount account) throws EventException;

	// ////////////////////////////////////////////////RQ RATE MAIN//////////////////////////////////////////////////////////

	/**
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriRqRtCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtCmdtVO> searchRfaRateQuotationList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException;

	/**
	 * PRI_RQ_RT_CMDT_ROUT 을 조회 합니다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriRqRtCmdtRoutVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtCmdtRoutVO> searchRateCommodityRouteList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException;

	/**
	 * PRI_RQ_RT_ROUT_PNT,PRI_RQ_RT_ROUT_VIA,PRI_RQ_RT 을 조회 합니다.<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return RFARateQuotationVO
	 * @exception EventException
	 */
	public RFARateQuotationVO searchRateList(RFARateQuotationVO rfaRateQuotationVO) throws EventException;

	/**
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 입력 수정 삭제한다<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCommodityRouteRateRfaRateQuotation(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException;

	/**
	 * RATE 관련 테이블을 Base SEQ 별 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @exception EventException
	 */
	public void removeRouteRateRfaRateQuotationByRout(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws EventException;

	/**
	 * PRI_RQ_RT_CMDT_ROUT, PRI_RQ_RT_ROUT_PNT, PRI_RQ_RT_ROUT_VIA, PRI_RQ_RT 입력 수정 삭제한다<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRouteRateRfaRateQuotation(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException;

	/**
	 * Rate 관련 테이블 에 가이드라인 정보를 조회 입력한다<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void glineCopyRfaRateQuotation(RsltPriRqMnVO rsltPriRqMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * RATE 관련 테이블에 COPY TO QUOTATION<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToQuotationRfaRateQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) throws EventException;

	/**
	 * Duplicate List를 조회 합니다.<br>
	 * 
	 * @param String ficRtTpCd
	 * @param PriRqMnVO priRqMnVO
	 * @return List<RsltPriRqRtDuplicateCheckVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtDuplicateCheckVO> searchRateDuplicateList(String ficRtTpCd, PriRqMnVO priRqMnVO) throws EventException;

	/**
	 * RATE 관련 테이블을 REMOVE BY QTTN NO<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @exception EventException
	 */
	public void removeRfaRateQuotation(PriRqHdrVO priRqHdrVO) throws EventException;

	/**
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN VerticalExcel)<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN Horizontal)<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException;

	/**
	 * SC Rate CMPB VIEW ALL (ESM_PRI_6076) 리스트를 조회한다.<br>
	 * 
	 * @param PriRqMnVO priRqMnVO
	 * @return List<RsltCmpbViewAllListVO>
	 * @exception EventException
	 */
	public List<RsltCmpbViewAllListVO> searchRateCmpbViewAllList(PriRqMnVO priRqMnVO) throws EventException;

	/**
	 * RQ Rate LOAD EXCEL(ESM_PRI_6056) 정보를 저장한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontal(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6056) 정보 정합성을 체크한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontal(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs)
			throws EventException;

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6057) 정보를 저장한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVertical(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6057) 정보 정합성을 체크한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) throws EventException;

	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @param String rotationPrsBatId
	 * @param SignOnUserAccount account
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO executeCalculate(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO, String rotationPrsBatId, SignOnUserAccount account) throws EventException;

	/**
	 * Calculate Batch ID를 조회 하기 위한 Parameter를 조합한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO searchMonitorCalculateParam(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws EventException;

	/**
	 * Calculate Batch의 상태 조회.<br>
	 * 
	 * @param PrsBatchVO prsBatchVO
	 * @return String
	 * @exception EventException
	 */
	public String monitorCalculate(PrsBatchVO prsBatchVO) throws EventException;

	/**
	 * Rate Route Case를 추가 한다. .<br>
	 * 
	 * @param PriRqRtUsdRoutCsVO priRqRtUsdRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriRateUsedRouteCase(PriRqRtUsdRoutCsVO priRqRtUsdRoutCsVO, SignOnUserAccount account) throws EventException;

	/**
	 * Route의 선택여부를 Mark해둔다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltPriPrsCostListVO> rsltPriPrsCostListVO) throws EventException;

	/**
	 * Calculate Logic을 이용해 data를 갱신한다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyCalculateLogicData(List<RsltPriPrsCostListVO> rsltPriPrsCostListVO) throws EventException;

	/**
	 * PRS- Surcharge Adjust 내용을 바탕으로 calc 로직을 수행 합니다.<br>
	 * 
	 * @param PriRqScgAdjVO priRqScgAdjVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeAdjustCalc(PriRqScgAdjVO priRqScgAdjVO, SignOnUserAccount account) throws EventException;

	/**
	 * COST CM/OP PRE SIMULATION 화면에서 ROUTE정보를 조회 한다.<br>
	 * 
	 * @param InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO
	 * @return List<RsltPriCostSimulationCheckRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws EventException;

	/**
	 * RFA Quotation - Rate Tab의 Surcharge View All Popup의 내용을 조회를 처리합니다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeViewAllVO> searchSurchargeViewAllList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException;

	/**
	 * RFA Quotation - Rate Tab의 Surcharge View All Popup에서 Surcharge 값이 언제 만들어 졌는지를 조회 처리합니다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException;

	/**
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriRqRtCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtCmdtVO> searchRfaRateQuotationListForIHC(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException;

	/**
	 * ESM_PRI_6014_03 : Rate Commodify Sequence <br>
	 * Rate Commodify Sequence<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return int
	 * @exception EventException
	 */
	public int searchRateCommoditySequence(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws EventException;

	/**
	 * PRI_RQ_RT_CMDT_HDR, PRI_RQ_RT_CMDT 입력 수정 삭제한다<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCommodityRouteRateRfaRateQuotationForIHC(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException;

	/**
	 * PRI_RQ_RT_CMDT_ROUT, PRI_RQ_RT_ROUT_PNT, PRI_RQ_RT_ROUT_VIA, PRI_RQ_RT 입력 수정 삭제한다<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRouteRateRfaRateQuotationForIHC(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException;

	/**
	 * PRI_RQ_RT_ROUT_PNT,PRI_RQ_RT_ROUT_VIA,PRI_RQ_RT 을 조회 합니다.<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return RFARateQuotationVO
	 * @exception EventException
	 */
	public RFARateQuotationVO searchRateListForIHC(RFARateQuotationVO rfaRateQuotationVO) throws EventException;

	/**
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param FicRouteGroupVO ficRouteGroupVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGroupVO>
	 * @exception EventException
	 */
	public List<FicRouteGroupVO> searchFicRouteGroup(FicRouteGroupVO ficRouteGroupVO, boolean addOnFlag) throws EventException;

	/**
	 * location code또는 group location code에 CY가 포함돼 있는 확인한다.<br>
	 * 
	 * @param FicCheckCYPortLocationVO ficCheckCYPortLocationVO
	 * @return List<RsltFicCheckCYPortLocationVO>
	 * @exception EventException
	 */
	public List<RsltFicCheckCYPortLocationVO> checkCYPortLocationCode(FicCheckCYPortLocationVO ficCheckCYPortLocationVO) throws EventException;

	/**
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN VerticalExcel)<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltRtListVerticalExcelForIHCVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelForIHCVO> searchRateListVerticalExcelForIHC(RFARateQuotationVO rfaRateQuotationVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN Horizontal)<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltRtListHorizontalExcelForIHCVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelForIHCVO> searchRateListHorizontalExcelForIHC(RFARateQuotationVO rfaRateQuotationVO) throws EventException;

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6095) 정보 정합성을 체크한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVerticalForIHC(RFARateQuotationVO rateQuotationVO) throws EventException;

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6095) 정보를 저장한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalForIHC(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException;

	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6096) 정보 정합성을 체크한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontalForIHC(RFARateQuotationVO rateQuotationVO) throws EventException;

	/**
	 * RQ Rate LOAD EXCEL(ESM_PRI_6096) 정보를 저장한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontalForIHC(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException;

	/**
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN VerticalExcel)<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltPriRqRtListVerticalExcelForAddOnTariffVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtListVerticalExcelForAddOnTariffVO> searchRateListVerticalExcelForAddOnTariff(RFARateQuotationVO rfaRateQuotationVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * RATE 관련 정보를 조회한다.(EXCEL DOWN Horizontal)<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltPriRqRtListHorizontalExcelForAddOnTariffVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtListHorizontalExcelForAddOnTariffVO> searchRateListHorizontalExcelForAddOnTariff(RFARateQuotationVO rfaRateQuotationVO) throws EventException;

	/**
	 * Load된 엑셀 데이터의 FIC Rate를 조회한다.<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @param boolean addOnFlag
	 * @return List<RsltPriRqRtGuidelineRateVO>
	 * @exception EventException
	 */
	public List<RsltPriRqRtGuidelineRateVO> searchFicGuidelineRateForLoadExcel(RFARateQuotationVO rfaRateQuotationVO, boolean addOnFlag) throws EventException;
	
	/**
	 * RFA Rate LOAD EXCEL(ESM_PRI_6095) 정보를 저장한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalForAddOnTariff(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * RQ Rate LOAD EXCEL(ESM_PRI_6096) 정보를 저장한다.<br>
	 * 
	 * @param RFARateQuotationVO rateQuotationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontalForAddOnTariff(RFARateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException;

}