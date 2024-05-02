/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TRIProposalBC.java
 *@FileTitle : TRI Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.13
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.13 박성수
 * 1.0 Creation
=========================================================
 * History
 * 2016.06.17 [CHM-201642005] TRI Amendment & Creation 상에서 Publish 버튼 클릭 후 30초가 지나도 서비스 가능하도록 시스템 개발  
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.PriPrsInCalculateVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropDtlListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropInquiryListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropParamVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriTriMnVO;
import com.hanjin.syscommon.common.table.PriTriRtScgVO;
import com.hanjin.syscommon.common.table.PriTriRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriTriRtVO;

/**
 * ALPS-Triproposal Business Logic Command Interface<br>
 * - ALPS-Triproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Sungsoo Park
 * @since J2EE 1.6
 */

public interface TRIProposalBC {

	/**
	 * TRI Proposal List를 조회합니다.<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return List<RsltTriPropListVO>
	 * @exception EventException
	 */
	public List<RsltTriPropListVO> searchTRIProposalList(TriPropParamVO triPropParamVO) throws EventException;

	/**
	 * TRI Proposal - Rate 및 Route정보를 조회합니다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @return RsltTriPropDtlListVO
	 * @exception EventException
	 */
	public RsltTriPropDtlListVO searchTRIRateProposalList(PriTriMnVO priTriMnVO) throws EventException;
	
	/**
	 * 중복된 TRI Rate가 존재하는지 검색한다.<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckRateDuplicate(TriPropParamVO triPropParamVO) throws EventException;
	
	/**
	 * 새로운 TRI_PROP_NO를 채번한다.<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchNextTRIPropNo(SignOnUserAccount account) throws EventException;

	/**
	 * TRI Proposal 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param TriPropVO triPropVO
	 * @param SignOnUserAccount account
	 * @param String newTriPropNo
	 * @exception EventException
	 */
	public void manageTRIRateProposal(TriPropVO triPropVO, SignOnUserAccount account, String newTriPropNo) throws EventException;

	/**
	 * TRI Proposal 데이터의 승인을 요청한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 다건의 TRI Proposal 데이터의 승인을 요청한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * TRI Proposal 데이터를 Amend한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * TRI Proposal 데이터의 C/Offer 처리한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cofferTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * TRI Proposal 데이터를 승인한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 다건의 TRI Proposal 데이터를 승인한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * TRI Proposal 데이터를 Publish한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 다건의 TRI Proposal 데이터를 Publish한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 다건의 TRI Proposal 데이터를 BackEnd 로 Publish한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String publishMultiTRIRateProposalPublishBackEnd(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * TRI Proposal 데이터에 TRI Number를 Assign한다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void assignNoTRIRateProposal(PriTriMnVO priTriMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * TRI Proposal 데이터의 상태를 이전으로 되돌린다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * 다건의 TRI Proposal 데이터의 상태를 이전으로 되돌린다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * TRI GRI가 Apply가능한지 검색한다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckGRIApplicable(TriPropGRIVO triPropGRIVO) throws EventException;
	
	/**
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException;

	/**
	 * TRI Note Content 정보를 저장합니다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * Pre CM/OP Simulation Cost관련 Cost, CMPB,OPB 값을 갱신.
	 * 
	 * @param RsltTriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsSimulationCost(RsltTriPrsCostListVO[] rsltTriPrsCostListVOS, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다..<BR>
	 * 
	 * @param RsltTriPrsCostListVO[] rsltTriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsCost(RsltTriPrsCostListVO[] rsltTriPrsCostListVOS, SignOnUserAccount account) throws EventException ;
	
	
	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltTriPrsCostDetailVO rsltTriPrsCostDetailVO
	 * @return List<RsltTriPrsCostDetailVO>
	 * @exception EventException
	 */
	public List<RsltTriPrsCostDetailVO> searchCostDetailInquiryList(RsltTriPrsCostDetailVO rsltTriPrsCostDetailVO) throws EventException ;
	
	
	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltTriPrsCostListVO rsltTriPrsCostListVO
	 * @return List<RsltTriPrsCostListVO>
	 * @exception EventException
	 */
	public List<RsltTriPrsCostListVO> searchCostDetailList(RsltTriPrsCostListVO rsltTriPrsCostListVO) throws EventException ;
	
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
	 * @param PriTriRtScgVO[] priPriTriRtScgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateSurcharge(PriTriRtScgVO[] priPriTriRtScgVO, SignOnUserAccount account)	throws EventException;
	
	/**
	 * TRI Proposal Inquiry List를 조회합니다.<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return List<RsltTriPropListVO>
	 * @exception EventException
	 */
	public List<RsltTriPropInquiryListVO> searchTRIProposalInquiryList(TriPropParamVO triPropParamVO) throws EventException;

    /**
     * TRI Proposal Excel Data 를 첨부하여 Descartes 로 메일을 전송합니다.<br>
     * 
     * @param TriPropSendMailVO triPropSendMailVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void sendMailTRIProposal(TriPropSendMailVO triPropSendMailVO, SignOnUserAccount account) throws EventException;

    /**
     * TRI Proposal Rate 의 Send Date 를 업데이트 합니다.<BR>
     * 
     * @param PriTriRtVO[] priTriRtVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyPriTriRtSendDate(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Calculate Batch ID를 조회 하기 위한 Parameter를 조합한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO searchMonitorCalculateParam(PriTriRtVO priTriRtVO ) throws EventException ;
	
	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO executeCalculate_BATCH(PriTriRtVO priTriRtVO,SignOnUserAccount account) throws EventException ;
	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param PriPrsBatVO priPrsBatVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String executeCalculate(PriTriRtVO priTriRtVO,PriPrsBatVO priPrsBatVO,SignOnUserAccount account) throws EventException ;
	
	/**
	 * Calculate Batch의 상태 조회.<br>
	 * 
	 * @param PrsBatchVO prsBatchVO
	 * @return String
	 * @exception EventException
	 */
	public String monitorCalculate(PrsBatchVO prsBatchVO) throws EventException ;
	
	/**
	 * Rate Route Case를 추가 한다. .<br>
	 * 
	 * @param PriTriRtUsdRoutCsVO priTriRtUsdRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriTriRateUsedRouteCase(PriTriRtUsdRoutCsVO priTriRtUsdRoutCsVO, SignOnUserAccount account) throws EventException;	
	/**
	 * Route의 선택여부를 Mark해둔다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltTriPrsCostListVO>  routCsUpdateVoList) throws EventException;

	/**
	 * Calculate Logic을 이용해 data를 갱신한다..<BR>
	 * 
	 * @param List<RsltTriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyCalculateLogicData(List<RsltTriPrsCostListVO>  rsltPriPrsCostListVO) throws EventException;

	/**
	 * COST CM/OP PRE SIMULATION 화면에서 ROUTE정보를 조회 한다.<br>
	 * 
	 * @param InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO
	 * @return List<RsltPriCostSimulationCheckRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws EventException ;

    /**
     * TRI Proposal 에서 Publish 할 때 담당자에게 GW 메일을 전송합니다.<br>
     * 
     * @param PriTriRtVO priTriRtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void sendMailTRIProposalPublish(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * MAIN table에 calculate 여부를 Mark해둔다..<BR>
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception EventException
	 */
	public void modifyPriTriMnCalcFlgCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws EventException;
	
	
}