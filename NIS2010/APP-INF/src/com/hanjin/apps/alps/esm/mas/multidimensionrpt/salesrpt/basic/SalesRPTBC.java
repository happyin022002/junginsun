/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : SalesRPTBC.java
*@FileTitle : Monthly Average U/C(PFMC-Based) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.06 남궁진호
* 1.0 Creation
*===========================================================
* History :
* 2008.04.03 전성진 N200803310003 물류레포트 파일 분리
* 2008.08.29 박상희 N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경     
* 2008.08.16 박상희 R200809109313 저장된 RPT form 사용 가능하도록 수정 
* 2008.10.20 전윤주 N200810200014 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [057] 
* 2008.10.21 박상희 N200810200009 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [078]
* 2009.03.10 김태윤 N200903040144 MAS Cost Detail 화면 수정 및 추가 요청 [170]
* 2009.03.13 박상희 N200903040144 searchTypeSizeList 품질점검[035]. 
* 2009.08.06 남궁진호 New Framework 적용 [0057]
* 2009.09.07 박은주   New FrameWork 적용 [0170]
* 2009.09.08 송호진 Inquiry By BKG ALPS F/W 적용
* 2009.09.29 김기식   New FrameWork 적용 [0070]
* 2011.07.26 김상수 [CHM-201112106-01] Retrieve, File Download 기능을 Back end job 으로 기능 수정
* 2014.01.15 김수정 [CHM-201428428] [MAS] Inquiry by Customized Condition 조회조건 제한
* 2014.05.13 최성민 [CHM-201429994] [MAS] Office Report vs QTA 화면 항목 추가 (IAS Sector Sales)
* 2016.04.13 김성욱[CHM-201640967] inquiry by Customized Condition 검색시 제약조건 변경 및 data export 형식 변경
*=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.CommonMasRsVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.BKGDetail0148VO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.BkgRpt0061VO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.InqByLane0062VO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.RouteDetail0147VO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SalesOffiRepoRtnVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SearchBkgRmk0170ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SearchDailyBKGView0078ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgUC0057List2VO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgUC0057ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SearchSetForm059List2VO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SearchSetForm059ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SearchStpInOut0135ListVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.ShipperVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasRptItmInfoDtlVO;
import com.hanjin.syscommon.common.table.MasRptItmInfoMstVO;


/**
 * ALPS-Multidimensionrpt Business Logic Command Interface<br>
 * - ALPS-Multidimensionrpt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author NAMKOONG Jin Ho
 * @see Esm_mas_0057EventResponse 참조
 * @since J2EE 1.6
 */

public interface SalesRPTBC {
	
	/**
	 * BackEndJob공통 - BackEndJob status를 return<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String commBackEndJob(String key) throws EventException;

	/**
	 * EsmMas0035: 헤더 조회 이벤트 처리<br>
	 * Inquiry By Source Data : Account 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SalesOffiRepoConditionVO salesOffiRepoConditionVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchCntrTpSzList(SalesOffiRepoConditionVO salesOffiRepoConditionVO) throws EventException;

	/**
	 * ESM_MAS_0035 : BackEndJob 시작 - Account별 조회 이벤트 처리<br>
	 *
	 * @param SignOnUserAccount account
	 * @param SalesOffiRepoConditionVO salesOffiRepoConditionVO
	 * @return String
	 */
	public String doBackEndJobSearchInqSrcDtAcct0035(SignOnUserAccount account, SalesOffiRepoConditionVO salesOffiRepoConditionVO);

	/**
	 * ESM_MAS_0035 : BackEndJob 결과 - Account별 조회 이벤트 처리<br>
	 *
	 * @param String key
	 * @return List<Object>
	 * @exception EventException
	 */
	public List<Object> searchInqSrcDtAcct0035List(String key) throws EventException;

	/**
	 * ESM_MAS_0035 : BackEndJob 시작 - Type size별 조회 이벤트 처리<br>
	 *
	 * @param SignOnUserAccount account
	 * @param SalesOffiRepoConditionVO salesOffiRepoConditionVO
	 * @return String
	 */
	public String doBackEndJobSearchInqSrcDtTpSz0035(SignOnUserAccount account, SalesOffiRepoConditionVO salesOffiRepoConditionVO);

	/**
	 * ESM_MAS_0035 : BackEndJob 결과 - Type size별 조회 이벤트 처리<br>
	 *
	 * @param String key
	 * @return List<Object>
	 * @exception EventException
	 */
	public List<Object> searchInqSrcDtTpSz0035List(String key) throws EventException;
	
	/**
     * ESM_MAS_0035 : 조회 내용 이메일 전송 배치 실행 처리<br>
     *
     * @param SignOnUserAccount account
     * @param SalesOffiRepoConditionVO salesOffiRepoConditionVO
     * @return String
     */
    public String sendMailInqSrcDtListUsingBatch(SignOnUserAccount account, SalesOffiRepoConditionVO salesOffiRepoConditionVO, String sGubun) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_0057화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * 
	 * @param SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO
	 * @return List<SearchMonthlyAvgUC0057ListVO>
	 * @exception EventException
	 */
	public List<SearchMonthlyAvgUC0057ListVO> searchMonthlyAvgUC0057List(SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO) throws EventException;
		
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_0057화면에 대한 조회 이벤트 처리<br>
	 * sheet2<br>
	 * 
	 * @param SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO
	 * @return List<SearchMonthlyAvgUC0057List2VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyAvgUC0057List2VO> searchMonthlyAvgUC0057List2(SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO) throws EventException;

	/**
	 * 비용 RMK 상세조회[Inquiry by BKG Remark]<br>
	 *  ESM_MAS_0170화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * 
	 * @param vo SearchConditionVO
	 * @return list List<SearchBkgRmk0170ListVO> 
	 * @exception EventException
	 */
	public List<SearchBkgRmk0170ListVO> searchBkgRemarkList(SearchConditionVO vo) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<BkgRpt0061VO>
	 * @exception EventException
	 */
	public List<BkgRpt0061VO> searchBKG0061List(SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonMasRsVO
	 * @exception EventException
	 */
	public CommonMasRsVO searchBKG0061List2(SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonMasRsVO
	 * @exception EventException
	 */
	public CommonMasRsVO searchBKG0061List3(SearchConditionVO searchConditionVO) throws EventException;
	
    /**
     * group code 목록을 조회한다. <br>
     *
     * @param SearchConditionVO searchVo
     * @param SalesRPTCommonVO vo
     * @return List<SearchSetForm059ListVO>
     * @exception EventException
     */	
	public List<SearchSetForm059ListVO> searchSetForm059List(SearchConditionVO searchVo, SalesRPTCommonVO vo) throws EventException;
	
    /**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
     * @param SearchConditionVO searchVo
     * @param SalesRPTCommonVO vo
     * @param SignOnUserAccount account
     * @return List<SearchSetForm059List2VO>
     * @exception EventException	 
	 */
	public List<SearchSetForm059List2VO> searchSetForm059List2(SearchConditionVO searchVo, SalesRPTCommonVO vo, SignOnUserAccount account) throws EventException;
	
    /**
	 * 멀티 이벤트 처리<br>
	 * ESM_MAS_003(So Cost Code)화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param SalesRPTCommonVO[] vos
	 * @param MasRptItmInfoMstVO[] tVos
	 * @param MasRptItmInfoDtlVO[] tVos2
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSetForm059(SearchConditionVO searchVo, SalesRPTCommonVO vo, SalesRPTCommonVO[] vos, MasRptItmInfoMstVO[] tVos, MasRptItmInfoDtlVO[] tVos2, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param String userId
	 * @return SalesRPTCommonVO
	 * @exception EventException
	 */
	public SalesRPTCommonVO searchInqByCondition060List(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException;
	
    /**
     * MAS 업무 시나리오 마감작업<br>
     * MultiDimensionRPT업무 시나리오 종료시 관련 내부객체 해제<br>
     *
     * @param SearchConditionVO searchVo
     * @param SalesRPTCommonVO vo
     * @param String userId
     * @return SalesRPTCommonVO
     * @exception EventException
     */ 
	public SalesRPTCommonVO searchInqByCondition060List2(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException;	
	
	/**
	 * ESM_MAS_0060: BackEndJob 시작 - 조회 이벤트 처리<br>
	 *
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param String userId
	 * @return SalesRPTCommonVO
	 * @exception EventException
	 */ 
	public String doBackEndJobSearchInqByCondition060(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException;	

	/**
	 * ESM_MAS_0060 : BackEndJob 결과<br>
	 *
	 * @param String key
	 * @return List<Object>
	 * @exception EventException
	 */
	public List<Object> searchInqByCondition060List(String key) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<InqByLane0062VO>
	 * @exception EventException
	 */
	public List<InqByLane0062VO> searchInqByLane0062List(SearchConditionVO searchConditionVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<ShipperVO>
	 * @exception EventException
	 */
	public List<ShipperVO> searchShipperList(SearchConditionVO searchConditionVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<RouteDetail0147VO>
	 * @exception EventException
	 */
	public List<RouteDetail0147VO> searchRouteDetail0147List(SearchConditionVO searchConditionVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<BKGDetail0148VO>
	 * @exception EventException
	 */
	public List<BKGDetail0148VO> searchBKGDetail0148List(SearchConditionVO searchConditionVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonMasRsVO
	 * @exception EventException
	 */
	public CommonMasRsVO searchCostDetail0149List(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * Weekly Sales Report By Office1 조회 이벤트 처리[ESM_MAS_070]
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchRPTbyOfc0070List11(SalesOffiRepoConditionVO vo) throws EventException;
	
	/**
	 * Weekly Sales Report By Office1 조회 이벤트 처리[ESM_MAS_070]
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchRPTbyOfc0070List12(SalesOffiRepoConditionVO vo) throws EventException;
	
	/**
	 * Weekly Sales Report By Office1 조회 이벤트 처리[ESM_MAS_070]
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchRPTbyOfc0070List13(SalesOffiRepoConditionVO vo) throws EventException;
	
	/**
	 * Weekly Sales Report By Office2 조회 이벤트 처리(ESM_MAS_071)
	 * @param  SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchRPTbyOfc0071List(SalesOffiRepoConditionVO vo) throws EventException;
	
	/**
	 * ESM_MAS_135 화면에 대한 조회 이벤트를 처리
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return List<SearchStpInOut0135ListVO>
	 * @throws EventException
	 */
	public List<SearchStpInOut0135ListVO> searchStpInOut0135List(SalesOffiRepoConditionVO vo) throws EventException;

	/**
	 * ESM_MAS_078 화면에 대한 조회 이벤트를 처리
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return List<SearchDailyBKGView0078ListVO>
	 * @throws EventException
	 */
	public List<SearchDailyBKGView0078ListVO> searchDailyBKGView0078List(SalesOffiRepoConditionVO vo) throws EventException;
	
	/**
	 * ESM_MAS_078 화면에 대한 조회 이벤트를 처리
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return List<SearchDailyBKGView0078ListVO>
	 * @throws EventException
	 */
	public List<SearchDailyBKGView0078ListVO> searchDailyBranchView0078List(SalesOffiRepoConditionVO vo) throws EventException;
	
	/**
	 * ESM_MAS_156 화면에 대한 저장 이벤트를 처리
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return List<SalesOffiRepoRtnVO>
	 * @throws EventException
	 */
	public List<SalesOffiRepoRtnVO> searchListBkgAbcstp0156List(SalesOffiRepoConditionVO vo) throws EventException;

    /**
     * Office Report-vs QTA - IAS Sector 조회
     *
     * @param     SalesOffiRepoConditionVO vo
     * @return    DBRowSet
     * @exception EventException
     */
	public DBRowSet searchRPTbyOfc0070IASSectorList(SalesOffiRepoConditionVO vo) throws EventException;
	
	public DBRowSet searchInqByCondition060ExcelList(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException;
}