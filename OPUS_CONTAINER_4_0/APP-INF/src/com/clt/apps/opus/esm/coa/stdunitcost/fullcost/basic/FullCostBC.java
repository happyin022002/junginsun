/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FullCostBC.java
*@FileTitle : Node Cost (PA/RA)
*Open Issues : Node별 표준단가 조회
*Change history :2007-06-07=EMS_COA_008 관련 메소드:prd과 프로그램 공유를 위해 sheet1, 2, 3삭제하고 4를 1로 대체
*@LastModifyDate : 2009-09-01
*@LastModifier : 장영석
*@LastVersion : 1.8
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.fullcost.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListByPRDVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchMonthNodeCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchMonthYardCodeListVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-COA Business Logic Command Interface<br>
 * - OPUS-COA에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author IM OKYOUNG
 * @see ESM_COA_004EventResponse 참조
 * @since J2EE 1.5
 */
public interface FullCostBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * FullCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0004 조회
	 * 
	 * @param SearchMonthYardCodeListVO	searchMonthYardCodeListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchMonthYardCodeListVO>
	 * @exception EventException
	 */
	public List<SearchMonthYardCodeListVO> searchMonthYardCodeList(SearchMonthYardCodeListVO searchMonthYardCodeListVO
			                                                      ,SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * FullCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0004 조회
	 * 
	 * @param SearchMonthYardCodeListVO	searchMonthYardCodeListVO
	 * @param SearchMonthNodeCostListVO	searchMonthNodeCostListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchMonthNodeCostListVO>
	 * @exception EventException
	 */	
	public List<SearchMonthNodeCostListVO> searchMonthNodeCostList (SearchMonthYardCodeListVO searchMonthYardCodeListVO
																   ,SearchMonthNodeCostListVO searchMonthNodeCostListVO
                                                                   ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 *  Link별 표준단가 조회 이벤트 처리 sheet1<br>
	 *  ESM_COA_0008 조회
	 * 
	 * @param SearchLinkCostListVO	searchLinkCostListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchLinkCostListVO>
	 * @exception EventException
	 */
	public List<SearchLinkCostListVO> searchLinkCostList(SearchLinkCostListVO searchLinkCostListVO
			                                            ,SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Link별 표준단가 조회 팝업 이벤트 처리 sheet1<br>
	 *
	 * @param SearchLinkCostListByPRDVO searchLinkCostListByPRDVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchLinkCostListByPRDVO> 
	 * @exception EventException
	 */
		public List<SearchLinkCostListByPRDVO> searchLinkCostListByPRD(SearchLinkCostListByPRDVO searchLinkCostListByPRDVO, SearchConditionVO searchConditionVO) throws EventException;

}