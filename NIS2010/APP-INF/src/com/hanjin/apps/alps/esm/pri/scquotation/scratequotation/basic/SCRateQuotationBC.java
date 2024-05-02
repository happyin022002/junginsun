/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationBC.java
*@FileTitle : S/C Quotation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.29 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InPriQuotationRateAdjustSetVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.PriSqRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RateQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtAllViewVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtCmdtRoutVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtCmdtVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriSqHdrVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSqRtScgVO;
import com.hanjin.syscommon.common.table.PriSqRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriSqScgAdjVO;


/**
 * ALPS-Scquotation Business Logic Command Interface<br>
 * - ALPS-Scquotation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SONG MIN SEOK
 * @see Esm_pri_6018EventResponse 참조
 * @since J2EE 1.6
 */

public interface SCRateQuotationBC {

	/**
	 * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
	 * 
	 * @param inpPrsSurchargeDetailApplicableRouteVO InpPrsSurchargeDetailApplicableRouteVO
	 * @return List<RsltRQPrsSurchargeDetailListVO>
	 * @exception EventException
	 */
	public RsltPrsSurchargeDetailListVO searchRateSurchargeList(InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO)
			throws EventException;

	/**
	 * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param priSqRtScgVOs PriSqRtScgVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageRateSurcharge(PriSqRtScgVO[] priSqRtScgVOs, SignOnUserAccount account)
			throws EventException;
	

	

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param rsltPriPrsCostListVO RsltPriPrsCostListVO
	 * @return List<RsltPriPrsCostListVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostListVO> searchCostDetailList(RsltPriPrsCostListVO rsltPriPrsCostListVO)
			throws EventException;

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 상세 내용  확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param rsltPriPrsCostDetailVO RsltPriPrsCostDetailVO
	 * @return List<RsltPriPrsCostDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostDetailVO> searchCostDetailInquiryList(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO)
			throws EventException;

	


	/**
	 * PRS- Surcharge Adjust을 조회합니다.<br>
	 * 
	 * @param rsltPriSurchargeAdjustListVO RsltPriSurchargeAdjustListVO
	 * @return List<RsltPriSurchargeAdjustListVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(
			RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO) throws EventException;

	/**
	 * PRS- Surcharge Adjust 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param priSqScgAdjVO PriSqScgAdjVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageSurchargeAdjust(PriSqScgAdjVO[] priSqScgAdjVO, SignOnUserAccount account)
			throws EventException;

	/**
	 * Commodity Group을 조회합니다.<br>
	 * 
	 * @param rsltPriSurchargeAdjustCommodityVO RsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityVO> searchRateCommodityAllList(
			RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO) throws EventException;

	/**
	 * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회합니다.<br>
	 * 
	 * @param rsltPriSurchargeAdjustCommodityDetailVO RsltPriSurchargeAdjustCommodityDetailVO
	 * @return List<RsltPriSurchargeAdjustCommodityDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityDetailVO> searchRateGroupCommodityDetailList(
			RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityDetailVO) throws EventException;

	/**
	 * Surcharge Adjust-Location Group을 조회 합니다.<br>
	 * 
	 * @param rsltPriSurchargeAdjustLocationGroupVO RsltPriSurchargeAdjustLocationGroupVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupVO> searchRateLocationAllList(
			RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO) throws EventException;

	/**
	 * Surcharge Adjust-Location Group에 상세 정보를 조회 합니다.<br>
	 * 
	 * @param rsltPriSurchargeAdjustLocationGroupVO RsltPriSurchargeAdjustLocationGroupDetailVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupDetailVO> searchRateGroupLocationDetailList(
			RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupVO) throws EventException;


	/**
	 * CM/OP View 내용을 조회 합니다.<br>
	 * 
	 * @param rsltPriRateCmViewAllVO RsltPriRateCmViewAllVO
	 * @return List<RsltPriRateCmViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriRateCmViewAllVO> searchRateCmViewAllList(
			RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * CM/OP View 의 Load 값을 갱신처리 합니다.<BR>
	 * 
	 * @param priSqRtCmdtRoutSetVO PriSqRtCmdtRoutSetVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyPrsPfmc(PriSqRtCmdtRoutSetVO priSqRtCmdtRoutSetVO, SignOnUserAccount account)
			throws EventException;


	
	/**
	 * Cost Detail by Trans.Mode 를 조회 합니다.<br>
	 *  
	 * @param RsltPriCostDetailByTransModeListVO    rsltPriCostDetailByTransModeListVO
	 * @return List<RsltPriCostDetailByTransModeListVO>
	 * @exception EventException
	 */
	public  List<RsltPriCostDetailByTransModeListVO> searchCostDetailByTransModeList(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO) 
	throws EventException;
	

	
	
	
	//////////////////////////////////////////////////SQ RATE MAIN//////////////////////////////////////////////////////////
	
	
	
	
	/**
	 * PRI_SQ_RT_CMDT_HDR, PRI_SQ_RT_CMDT 을 조회 합니다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSqRtCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriSqRtCmdtVO> searchSCRateQuotationList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException;
	
	
	/**
	 * PRI_SQ_RT_CMDT_ROUT 을 조회 합니다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSqRtCmdtVO>
	 * @exception EventException
	 */
	public List<RsltPriSqRtCmdtRoutVO> searchRateCommodityRouteList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException;
	
	
	/**
	 * PRI_SQ_RT_ROUT_PNT,PRI_SQ_RT_ROUT_VIA,PRI_SQ_RT 을 조회 합니다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return RateQuotationVO
	 * @exception EventException
	 */
	public RateQuotationVO searchRateList(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws EventException;
	
	
	/**
	 * PRI_SQ_RT_CMDT_HDR, PRI_SQ_RT_CMDT 입력 수정 삭제한다<br>
	 * 
	 * @param rateQuotationVO RateQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCommoditySCRateQuotation(RateQuotationVO rateQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	/**
	 * Rate 관련 테이블 Base 별 삭제한다<br>
	 * 
	 * @param priSqRtCmdtRoutVO PriSqRtCmdtRoutVO
	 * @exception EventException
	 */
	public void removeRouteRateSCRateQuotationByRout(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws EventException;
	
	/**
	 * PRI_SQ_RT_CMDT_ROUT, PRI_SQ_RT_ROUT_PNT, PRI_SQ_RT_ROUT_VIA, PRI_SQ_RT 입력 수정 삭제한다<br>
	 * 
	 * @param rateQuotationVO RateQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageRouteRateSCRateQuotation(RateQuotationVO rateQuotationVO, SignOnUserAccount account) throws EventException;
	
	
	

	/**
	 * Quotaion의 route 리스트 조회 이벤트 처리<br>
	 * 
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @return List<RsltPriCommodityRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCommodityRouteVO> searchCommodityRouteList(InPriCommodityRouteVO inPriCommodityRouteVO)
			throws EventException;	
	
	
	/**
	 * Quotaion의 route의 모든 Area 리스트 조회 이벤트 처리<br>
	 * 구분에 따라 조회 하는 테이블을 달리하지만 성격이 같은 route정보를 조회한다.<BR>
	 * 
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCommodityRouteAreaList(InPriCommodityRouteVO inPriCommodityRouteVO)
			throws EventException;	
	
	
 
	
	/**
	 * S/C Quotaion의 생성 일자를 조회 처리<br>
	 * 
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO searchSCQuotationCreationDate(InPriCommodityRouteVO inPriCommodityRouteVO)	throws EventException;	
	
	
	



	/**
	 * Quotaion Rate 의 Surcharge Amount값을  갱신처리 합니다.
	 * 
	 * @param inPriQuotationRateAdjustSetVO InPriQuotationRateAdjustSetVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyRateScQuotation(InPriQuotationRateAdjustSetVO inPriQuotationRateAdjustSetVO, SignOnUserAccount account)
			throws EventException;	
	
	
	/**
	 * Rate 관련 테이블 에 가이드라인 정보를 조회 입력한다<br>
	 * 
	 * @param rsltPriSqMnVO RsltPriSqMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void glineCopyScRateQuotation(RsltPriSqMnVO rsltPriSqMnVO, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * COPY TO QUOTATION Rate 관련 테이블<br>
	 * 
	 * @param RsltCopyToQuotationVO rsltCopyToQuotationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyToQuotationScRateQuotaionReport(RsltCopyToQuotationVO rsltCopyToQuotationVO, SignOnUserAccount account) 
		throws EventException;
	
	
	
	/**
	 * REMOVE Rate 관련 테이블 BY QTTN NO<br>
	 * 
	 * @param priSqHdrVO PriSqHdrVO
	 * @exception EventException
	 */
	public void removeScRateQuotation(PriSqHdrVO priSqHdrVO) throws EventException;
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	/**
	 * Quotaion Rate View All<br>
	 * 
	 * @param priSqRtCmdtHdrVO PriSqRtCmdtHdrVO
	 * @return List<RsltPriSqRtAllViewVO>
	 * @exception EventException
	 */
	public List<RsltPriSqRtAllViewVO> searchViewAllSCRateQuotationList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO)
			throws EventException;
	
	
	

	
	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @param  String rotationPrsBatId
	 * @param SignOnUserAccount account
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO executeCalculate(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO,  String rotationPrsBatId,SignOnUserAccount account) throws EventException ;
	
	/**
	 * Calculate Batch의 상태 조회.<br>
	 * 
	 * @param PrsBatchVO prsBatchVO
	 * @return String
	 * @exception EventException
	 */
	public String monitorCalculate(PrsBatchVO prsBatchVO) throws EventException ;
	
	/**
	 * Calculate Batch ID를 조회 하기 위한 Parameter를 조합한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO searchMonitorCalculateParam(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws EventException ;
	
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * S/C RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다.
	 * 
	 * @param rsltPriPrsCostListVOS RsltPriPrsCostListVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyPrsCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account)
			throws EventException;
	
	
	/**
	 * Rate Vertical Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException;
	
	/**
	 * Rate Horizontal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param priSqRtCmdtHdrVO PriSqRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException;
	
	
	/**
	 * SC Rate CMPB VIEW ALL (ESM_PRI_6074) 리스트를 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltCmpbViewAllListVO> searchRateCmpbViewAllList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException;
	
	
	/**
	 * SQ Rate LOAD EXCEL(ESM_PRI_6006) 화면에 대한 입력 이벤트 처리<br>
	 * 
	 * @param PriSqRtCmdtHdrVO PriSqRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontal(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * SQ Rate LOAD EXCEL(ESM_PRI_6006) 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param priSqRtCmdtHdrVO PriSqRtCmdtHdrVO
	 * @param rsltRtListHorizontalExcelVOs RsltRtListHorizontalExcelVO[]
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontal(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs) 
	throws EventException;
	
	
	/**
	 * SQ Rate LOAD EXCEL(ESM_PRI_6007) 화면에 대한 입력 이벤트 처리<br>
	 * 
	 * @param PriSqRtCmdtHdrVO PriSqRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVertical(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) 
		throws EventException;
	
	
	/**
	 * SQ Rate LOAD EXCEL(ESM_PRI_6007) 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) 
	throws EventException;

	
	
	/**
	 * Pre CM/OP Simulation Cost관련 Cost, CMPB,OPB 값을 갱신.
	 * 
	 * @param RsltPriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsSimulationCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account) throws EventException;

	/**
	 * Rate Route Case를 추가 한다. .<br>
	 * 
	 * @param PriSqRtUsdRoutCsVO priSqRtUsdRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriRateUsedRouteCase(PriSqRtUsdRoutCsVO priSqRtUsdRoutCsVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Calculate Logic을 이용해 data를 갱신한다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyCalculateLogicData(List<RsltPriPrsCostListVO>  rsltPriPrsCostListVO) throws EventException;
	
	/**
	 * Route의 선택여부를 Mark해둔다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltPriPrsCostListVO>  rsltPriPrsCostListVO) throws EventException;
	
	/**
	 * PRS- Surcharge Adjust 내용을 바탕으로 calc 로직을 수행 합니다.<br>
	 * 
	 * @param PriSqScgAdjVO priSqScgAdjVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeAdjustCalc(PriSqScgAdjVO priSqScgAdjVO, SignOnUserAccount account) throws EventException;

	
	


	/**
	 * COST CM/OP PRE SIMULATION 화면에서 ROUTE정보를 조회 한다.<br>
	 * 
	 * @param InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO
	 * @return List<RsltPriCostSimulationCheckRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(
			InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws EventException ;




    
	/**
	 * S/C Quotation - Rate Tab의 Surcharge View All Popup의 내용을 조회를 처리합니다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeViewAllVO> searchSurchargeViewAllList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException ;
	

	/**
	 * S/C Quotation - Rate Tab의 Surcharge View All Popup에서 Surcharge 값이 언제 만들어 졌는지를 조회 처리합니다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws EventException;
	

	
}