/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultiDimensionRPTBC.java
*@FileTitle : 점소 Weekly 비정형 실적 분석 RPT조회
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-09
*@LastModifier : Sangwook_nam
*@LastVersion : 1.0
* 2006-11-09 Sangwook_nam
* 1.0 최초 생성    
* 2008.04.03 전성진 N200803310003 물류레포트 파일 분리
* 2008.08.29 박상희 N200807298360 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리
* 2008.10.20 전윤주 N200810200014 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [057]
* 2008.10.21 박상희 N200810200009 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [078]  
* 2009.07.23 박수훈 New Framework 적용 [0130]      
* 2009.09.21 김기식   New FrameWork 적용 [0063,0065,0066,0067
* 2010.09.01 김기종 CSR No. CHM-201005370-01 Inquiry by customized condition 기능 개선
* 2012.06.25 이석준 [CHM-201218363-01] P&L by Lane Report data creation 기능 추가
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
* 2013.06.13 서미진 [CHM-201325024] 2주차씩 Creation이 되고 완료 되었을때 완료 메세지가 뜨게 수정
* 2014.01.02 김수정 [CHM-201327858] [MAS] IAS P&L 추가
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.MultiDimensionPfmcByOfficeListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.MultiDimensionRptRtnVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.SearchAdjCostDtlListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.SearchIasSubCdListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.SearchMultiDimension068ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo.SearchReportViewListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo.SearchCondition0153VO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.SearchCostSetUpListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasUtCostCreStsVO;
 
/**
 * ALPS-MAS Business Logic Command Interface<br>
 * - ALPS-MAS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Sangwook_nam
 * @see 
 * @since J2EE 1.6
 */ 
public interface MultiDimensionRPTBC  {
	  
	/** 
	 * 물류레포트 쿼리 속도 향상을 위해 로딩시 VVD를 메모리에 올려주는 작업
	 * 
	 * @param  e ESM_MAS_080Event, ESM_MAS_081Event, ESM_MAS_082Event
	 * @return ESM_MAS_080EventResponse, ESM_MAS_081EventResponse, ESM_MAS_082EventResponse
	 * @throws EventException
	 */
	/* 
	public EventResponse loadingCurrentVVD(Event e) throws EventException;
	20070914 임옥영*/

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @return List<MultiDimensionPfmcByOfficeListVO>
	 * @exception EventException
	 */
	public List<MultiDimensionPfmcByOfficeListVO> searchMultiDimension0063List(RepoPfmcConditionVO repoPfmcConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response ESM_MAS_065EventResponse
	 * @exception EventException
	 */
	//public EventResponse searchMultiDimension065List(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * @param RepoPfmcConditionVO repoPfmcConditionVO 
	 * @return MultiDimensionPfmcByOfficeListVO
	 * @exception EventException
	 */
	public MultiDimensionPfmcByOfficeListVO searchMultiDimension0066List(RepoPfmcConditionVO repoPfmcConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response ESM_MAS_067EventResponse
	 * @exception EventException
	 */
	//public EventResponse searchMultiDimension067List(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * @param RepoPfmcConditionVO repoPfmcConditionVO 
	 * @return List<SearchMultiDimension068ListVO>
	 * @exception EventException
	 */
	public List<SearchMultiDimension068ListVO> searchMultiDimension0068List(RepoPfmcConditionVO repoPfmcConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response ESM_MAS_068EventResponse
	 * @exception EventException
	 */
	//public EventResponse searchMultiDimension0682List(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionPfmcByOfficeListVO>
	 * @exception EventException
	 */
	public List<MultiDimensionPfmcByOfficeListVO> searchMultiDimension0069List(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * @param RepoPfmcConditionVO repoPfmcConditionVO 
	 * @return MultiDimensionPfmcByOfficeListVO
	 * @exception EventException
	 */
	public MultiDimensionPfmcByOfficeListVO searchMultiDimension00692List(RepoPfmcConditionVO repoPfmcConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response ESM_MAS_067EventResponse
	 * @exception EventException
	 */
	//public EventResponse searchMultiDimension0672List(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response ESM_MAS_063EventResponse
	 * @exception EventException
	 */
	//public EventResponse searchMultiDimension0632List(Event e) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * ESM_MAS_0130화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchReportViewListVO searchReportViewListVO
	 * @return List<SearchReportViewListVO>
	 * @exception EventException
	 */
	public List<SearchReportViewListVO> searchReportViewList(SearchReportViewListVO searchReportViewListVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * ESM_MAS_0130 화면에 대한 저장 이벤트를 처리
	 * 
	 * @param SearchReportViewListVO[] searchReportViewListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiReportView(SearchReportViewListVO[] searchReportViewListVO,SignOnUserAccount account) throws EventException;

	/**
	 * ESM_MAS_072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased1List(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * ESM_MAS_072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased2List(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * ESM_MAS_072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased3List(RepoPfmcConditionVO vo) throws EventException;

	/**
	 * ESM_MAS_072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased4List(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * ESM_MAS_072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased5List(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * ESM_MAS_072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased6List(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * ESM_MAS_072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased7List(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * ESM_MAS_072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased8List(RepoPfmcConditionVO vo) throws EventException;
	
	/**
     * ESM_MAS_072: 조회 이벤트 처리<br>
     * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
     * 
     * @param vo RepoPfmcConditionVO
     * @return List<MultiDimensionRptRtnVO>
     * @exception EventException
     */
    public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased9List(RepoPfmcConditionVO vo) throws EventException;
    
    /**
     * ESM_MAS_072: 조회 이벤트 처리<br>
     * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
     * 
     * @param vo RepoPfmcConditionVO
     * @return List<MultiDimensionRptRtnVO>
     * @exception EventException
     */
    public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased10List(RepoPfmcConditionVO vo) throws EventException;
    
    /**
     * ESM_MAS_072: 조회 이벤트 처리<br>
     * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
     * 
     * @param vo RepoPfmcConditionVO
     * @return List<MultiDimensionRptRtnVO>
     * @exception EventException
     */
    public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased11List(RepoPfmcConditionVO vo) throws EventException;
    		
	/**
	 * ESM_MAS_072: 헤더 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 헤더 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3HeaderList(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * IAS 협의체별 Scop 조회 (ESM_MAS_0178)<br>
	 * 
	 * @param  SearchIasSubCdListVO vo
	 * @return List<SearchIasSubCdListVO>
	 * @exception EventException
	 */
	public List<SearchIasSubCdListVO> searchIasSubCdList(SearchIasSubCdListVO vo) throws EventException;

	/**
	 * IAS 협의체별 Scop 관리화면 Save 이벤트 처리(ESM_MAS_0178)<br>
	 * 
	 * @param SearchIasSubCdListVO[] searchIasSubCdListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageIasSubCdList(	SearchIasSubCdListVO[] searchIasSubCdListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * P/L Creation batch가 실행중인지를 check 한다.
	 * 
	 * @param String ucCd
	 * @return String
	 * @throws EventException
	 */
	public String checkProfitLossCreateBatchStatus(String ucCd) throws EventException ;
	
	/**
	 * Week 단위로 P/L Summary batch를 수행한다.
	 *
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createProfitLossSummary(RepoPfmcConditionVO repoPfmcConditionVO,SignOnUserAccount account) throws EventException ;
	
	/**
	 * PL BATCH CREATE TABLE로부터 현재 BATCH의 STATUS를 알아본다.
	 * 
	 * @param  RepoPfmcConditionVO repoPfmcConditionVO
	 * @return List<MasUtCostCreStsVO>
	 * @exception EventException
	 **/
	public List<MasUtCostCreStsVO> searchProfitLossCreationStatus(RepoPfmcConditionVO repoPfmcConditionVO) throws EventException;
	
	   /**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * @param RepoPfmcConditionVO repoPfmcConditionVO 
	 * @return List<SearchAdjCostDtlListVO>
	 * @exception EventException
	 */
	public List<SearchAdjCostDtlListVO> searchAdjCostDetail(RepoPfmcConditionVO repoPfmcConditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @exception EventException
	 */
	public List<SearchCostSetUpListVO> searchCostStupMTAbcList(SearchConditionVO searchConditionVO) throws EventException ;
	
	/**
	 * PNL BATCH status 를 생성한다. <br>
	 *
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addProfitLossSummaryBatchStatus(RepoPfmcConditionVO repoPfmcConditionVO,SignOnUserAccount account) throws EventException ;
	
	/**
	 * ESM_MAS_0192: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchPlAdjustmentTotalList(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * ESM_MAS_0192: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchPlAdjustmentTradeList(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * ESM_MAS_0192: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchPlAdjustmentVVDList(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * Week 단위로 P/L Adjustment batch를 수행한다.
	 *
	 * @param RepoPfmcConditionVO repoPfmcConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createProfitLossAdjustment(RepoPfmcConditionVO repoPfmcConditionVO,SignOnUserAccount account) throws EventException ;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_0153 MTY Rtn YD로 RHQ 구하기<br>
	 * @param SearchCondition0153VO searchCondition0153VO
	 * @return List<SearchCondition0153VO>
	 * @exception EventException
	 */
//	public String searchYdToRhq(String rtn_yd) throws EventException;
	public List<SearchCondition0153VO> searchYdToRhq(SearchCondition0153VO searchCondition0153VO) throws EventException;
}