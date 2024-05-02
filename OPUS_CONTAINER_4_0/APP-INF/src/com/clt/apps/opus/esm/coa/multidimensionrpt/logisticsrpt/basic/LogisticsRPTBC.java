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
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0158ListVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-COA Business Logic Command Interface<br>
 * - OPUS-COA에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Sangwook_nam
 * @see ESM_COA_060EventResponse 참조
 * @since J2EE 1.4  
 */
public interface LogisticsRPTBC  {	

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
	 * @return List<SearchLogisticsRPT0080ListVO2>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0080ListVO2> searchLogisticsRPT0080List2(SearchLgstConditionVO searchLgstConditionVO ) throws EventException;
	
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
	 * @return List<SearchLogisticsRPT0081ListVO2>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0081ListVO2> searchLogisticsRPT0081List2(SearchLgstConditionVO searchLgstConditionVO ) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0082화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO 
	 * @return List<SearchLogisticsRPT0082ListVO2>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0082ListVO2> searchLogisticsRPT0082List2(SearchLgstConditionVO searchLgstConditionVO ) throws EventException;
	
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