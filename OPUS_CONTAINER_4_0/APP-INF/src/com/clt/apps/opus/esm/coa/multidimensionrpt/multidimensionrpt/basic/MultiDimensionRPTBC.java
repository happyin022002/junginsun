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
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.MultiDimensionRptRtnVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.PnlRptItemVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchReportViewListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-COA Business Logic Command Interface<br>
 * - OPUS-COA에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Sangwook_nam
 * @see 
 * @since J2EE 1.6
 */
public interface MultiDimensionRPTBC  {
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * ESM_COA_0130화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchReportViewListVO searchReportViewListVO
	 * @return List<SearchReportViewListVO>
	 * @exception EventException
	 */
	public List<SearchReportViewListVO> searchReportViewList(SearchReportViewListVO searchReportViewListVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * ESM_COA_0130 화면에 대한 저장 이벤트를 처리
	 * 
	 * @param SearchReportViewListVO[] searchReportViewListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiReportView(SearchReportViewListVO[] searchReportViewListVO,SignOnUserAccount account) throws EventException;

	/**
	 * ESM_COA_072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased1List(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * ESM_COA_072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased2List(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * ESM_COA_072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased3List(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * ESM_COA_072: 헤더 조회 이벤트 처리<br>
	 * MultiDimensionRPT화면에 대한 헤더 조회 이벤트 처리<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3HeaderList(RepoPfmcConditionVO vo) throws EventException;
	
	/**
	 * P/L Report Item retrieve<br>
	 * 
	 * @return List<PnlRptItemVO>
	 * @exception EventException
	 */
	public List<PnlRptItemVO> searchPnlRptItem() throws EventException;
	
	/**
	 *  P/L Report Item add/modify/remove<br>
	 * 
	 * @param  PnlRptItemVO[] pnlRptItemVOs
	 * @param  SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	public String multiPnlRptItem(PnlRptItemVO[] pnlRptItemVOs, SignOnUserAccount account) throws EventException;
}