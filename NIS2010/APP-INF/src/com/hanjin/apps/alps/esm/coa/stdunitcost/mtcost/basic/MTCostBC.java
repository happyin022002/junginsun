/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MTCostBC.java
*@FileTitle : ECC별 MT 표준단가&MT Turntime 생성 
*Open Issues :
*Change history : EQ Repo cost(009) 화면 LCC레벨 추가
*@LastModifyDate : 2009.09.14
*@LastModifier 	: 장영석
*@LastVersion : 1.4
* 2006-11-16 IM OKYOUNG
* 1.0 최초 생성
* 
* Change history : 
* 2008.08.04 전윤주 : CSR NO. N200807170013 COA_EQ Repo 단가 조회 화면 변경  
*                    (sheet 추가로 인한 BC 추가)
* 2009.08.20 박수훈 : New Framework 생성[0009]
* 2009.09.14 장영석: New Framework 생성[0010]
* 2010.02.05 임옥영 품질검토 결과 반영 - 주석이 원래 있는데 추출되서 공백등 다시한번 작성
* 2011.07.12 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2012.09.10 이석준 [CHM-201220070-01] EQ Repo Cost (PA) 화면에 Month Copy 기능 추가 
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost10ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost11ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost12ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost13ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost14ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost2ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost3ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost4ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost5ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost6ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost7ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost8ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCost9ListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCostDetailListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListPopUpVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;



/**
 * ALPS-Stdunitcost Business Logic Command Interface<br>
 * - ALPS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author IM OKYOUNG 
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.5
 */

public interface MTCostBC {
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet1_MT 조회
	 * @param SearchMTCostListVO searchMTCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO> searchMTCostList(SearchMTCostListVO searchMTCostListVO
			                                        ,SearchConditionVO searchConditionVO) throws EventException; 
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet2_MT 조회 
	 * @param SearchMTCost2ListVO searchMTCost2ListVO
	 * @param SearchMTCostListVO searchMTCostListVO
	 * @return List<SearchMTCost2ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost2ListVO> searchMTCost2List(SearchMTCost2ListVO searchMTCost2ListVO
			                                          ,SearchMTCostListVO searchMTCostListVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet3_MT 조회
	 * @param SearchMTCost3ListVO searchMTCost3ListVO
	 * @param SearchMTCost2ListVO searchMTCost2ListVO
	 * @return List<SearchMTCost3ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost3ListVO> searchMTCost3List(SearchMTCost3ListVO searchMTCost3ListVO
			                                          ,SearchMTCost2ListVO searchMTCost2ListVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * ESM_COA_0009 Sheet4_MT 조회
	 * @param SearchMTCost4ListVO searchMTCost4ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCost4ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost4ListVO> searchMTCost4List(SearchMTCost4ListVO searchMTCost4ListVO
			                                          ,SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet5_MT 조회
	 * @param SearchMTCost5ListVO searchMTCost5ListVO
	 * @param SearchMTCost4ListVO searchMTCost4ListVO
	 * @return List<SearchMTCost5ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost5ListVO> searchMTCost5List(SearchMTCost5ListVO searchMTCost5ListVO
			                                          ,SearchMTCost4ListVO searchMTCost4ListVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet6_MT 조회
	 * @param SearchMTCost6ListVO searchMTCost6ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCost6ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost6ListVO> searchMTCost6List(SearchMTCost6ListVO searchMTCost6ListVO
			                                          ,SearchConditionVO searchConditionVO) throws EventException;
	 
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet7_MT 조회
	 * @param SearchMTCost7ListVO searchMTCost7ListVO
	 * @param SearchMTCost6ListVO searchMTCost6ListVO
	 * @return List<SearchMTCost7ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost7ListVO> searchMTCost7List(SearchMTCost7ListVO searchMTCost7ListVO
			                                          ,SearchMTCost6ListVO searchMTCost6ListVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * ESM_COA_0009 Sheet8_FULL 조회
	 * @param SearchMTCost8ListVO searchMTCost8ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCost8ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost8ListVO> searchMTCost8List(SearchMTCost8ListVO searchMTCost8ListVO
			                                          ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet9_FULL 조회
	 * @param SearchMTCost9ListVO searchMTCost9ListVO
	 * @param SearchMTCost8ListVO searchMTCost8ListVO
	 * @return List<SearchMTCost9ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost9ListVO> searchMTCost9List(SearchMTCost9ListVO searchMTCost9ListVO
			                                          ,SearchMTCost8ListVO searchMTCost8ListVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet10_FULL 조회
	 * @param SearchMTCost10ListVO searchMTCost10ListVO
	 * @param SearchMTCost9ListVO searchMTCost9ListVO
	 * @return List<SearchMTCost10ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost10ListVO> searchMTCost10List(SearchMTCost10ListVO searchMTCost10ListVO
			                                            ,SearchMTCost9ListVO searchMTCost9ListVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * ESM_COA_0009 Sheet11_FULL 조회
	 * @param SearchMTCost11ListVO searchMTCost11ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCost11ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost11ListVO> searchMTCost11List(SearchMTCost11ListVO searchMTCost11ListVO
			                                            ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet12_FULL 조회
	 * @param SearchMTCost12ListVO searchMTCost12ListVO
	 * @param SearchMTCost11ListVO searchMTCost11ListVO
	 * @return List<SearchMTCost12ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost12ListVO> searchMTCost12List(SearchMTCost12ListVO searchMTCost12ListVO
			                                            ,SearchMTCost11ListVO searchMTCost11ListVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet13_FULL 조회
	 * @param SearchMTCost13ListVO searchMTCost13ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCost13ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost13ListVO> searchMTCost13List(SearchMTCost13ListVO searchMTCost13ListVO
			                                            ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet14_FULL 조회
	 * @param SearchMTCost14ListVO searchMTCost14ListVO
	 * @param SearchMTCost13ListVO searchMTCost13ListVO
	 * @return List<SearchMTCost14ListVO>
	 * @exception EventException
	 */
	public List<SearchMTCost14ListVO> searchMTCost14List(SearchMTCost14ListVO searchMTCost14ListVO
			                                            ,SearchMTCost13ListVO searchMTCost13ListVO) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리_팝업<br>
	 * ESM_COA_0010 조회
	 * @param SearchMTCostListPopUpVO searchMTCostListPopUpVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListPopUpVO>
	 * @exception EventException
	 */
	public List<SearchMTCostListPopUpVO> searchMTCostListPopUp(SearchMTCostListPopUpVO searchMTCostListPopUpVO, SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 생성 이벤트 처리<br>
	 * EQ Repo Cost 월단가를 복사해서 생성한다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createEqRepoCostMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;

	/**
	 * EQ Repo Cost 의  M/B 기간을 조회한다.<br>
	 * 
	 * @param fCostYrmon
	 * @return String
	 * @throws EventException
	 */
	public String searchMTCostCreationStatus(String fCostYrmon) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0011 조회
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostDetailListVO>
	 * @exception EventException
	 */
	public List<SearchMTCostDetailListVO> searchMTCostDetailList(SearchConditionVO searchConditionVO) throws EventException;
}