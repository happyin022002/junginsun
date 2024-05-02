/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LogisticsRPTBC.java
*@FileTitle : 물류 실적 분석 RPT조회
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-09
*@LastModifier : Sangwook_nam
*@LastVersion : 1.0
* 2006-11-09 Sangwook_nam
* 1.0 최초 생성
* 2008-04-03 전성진 N200803310003 물류레포트 파일 분리
* 2008-07-21 김태윤 N200803310003 성능향상을 위한 물류레포트 신규추가.
* 2008.11.28 박은주 CSR No.N200810310004 US Route Cost Inquiry  신규화면 개발.
* 2009.10.07 장영석  New Framework 적용 [0163]
* 2009.10.13 최인경  New Framework 적용 [0080]
* 2009.10.13 최인경  New Framework 적용 [0081]
* 2009.10.26 최인경  New Framework 적용 [0082]
* 2009.10.29 최인경  New Framework 적용 [0158]
* 2011.07.13 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00802ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00812ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00822ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0158ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchUSInlandCost0163ListVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ENIS-COA Business Logic Command Interface<br>
 * - ENIS-COA에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Sangwook_nam
 * @see ESM_COA_060EventResponse 참조
 * @since J2EE 1.4  
 */
public interface LogisticsRPTBC  {	

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchUSInlandCost0163ListVO	searchUSInlandCost0163ListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchUSInlandCost0163ListVO>
	 * @exception EventException
	 */
	public List<SearchUSInlandCost0163ListVO> searchUSInlandCost0163List(SearchUSInlandCost0163ListVO searchUSInlandCost0163ListVO, SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0080화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0080ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0080ListVO> searchLogisticsRPT0080List(SearchLgstConditionVO searchLgstConditionVO ) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0080화면에 대한 조회 이벤트 처리<br>
	 * sheet2<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT00802ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT00802ListVO> searchLogisticsRPT00802List(SearchLgstConditionVO searchLgstConditionVO ) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0081화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0081ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0081ListVO> searchLogisticsRPT0081List(SearchLgstConditionVO searchLgstConditionVO ) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0081화면에 대한 조회 이벤트 처리<br>
	 * sheet2<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT00812ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT00812ListVO> searchLogisticsRPT00812List(SearchLgstConditionVO searchLgstConditionVO ) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0082화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO 
	 * @return List<SearchLogisticsRPT00822ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT00822ListVO> searchLogisticsRPT00822List(SearchLgstConditionVO searchLgstConditionVO ) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0082화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO 
	 * @return List<SearchLogisticsRPT0082ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0082ListVO> searchLogisticsRPT0082List(SearchLgstConditionVO searchLgstConditionVO ) throws EventException;
	
	/**
	 * Logistics Vol. by Offic를 조회한다.<br>
	 * ESM_COA_0158화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
     *
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0158ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0158ListVO> searchLogisticsRPT0158List(SearchLgstConditionVO searchLgstConditionVO ) throws EventException;
}