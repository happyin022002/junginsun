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
===========================================================

=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.BkgRpt0061VO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoRtnVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchBkgRmk0170ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059List2VO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.ShipperVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaRptItmInfoDtlVO;
import com.clt.syscommon.common.table.CoaRptItmInfoMstVO;


/**
 * OPUS-Multidimensionrpt Business Logic Command Interface<br>
 * - OPUS-Multidimensionrpt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author NAMKOONG Jin Ho
 * @see Esm_coa_0057EventResponse 참조
 * @since J2EE 1.6
 */

public interface SalesRPTBC {
	
	/**
	 * ESM_COA_035 : 조회 이벤트 처리<br>
	 * 
	 * @param vo SalesOffiRepoConditionVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchCntrTpSzList(SalesOffiRepoConditionVO vo) throws EventException;
	
	/**
	 * ESM_COA_035 : 조회 이벤트 처리<br>
	 * 
	 * @param vo SalesOffiRepoConditionVO
	 * @return List
	 * @exception EventException
	 */
	public List<Object> searchInqSrcDtAcct0035List(SalesOffiRepoConditionVO vo) throws EventException;
	
	/**
	 * ESM_COA_035 : 조회 이벤트 처리<br>
	 * 
	 * @param vo SalesOffiRepoConditionVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public List<Object> searchInqSrcDtTpSz0035List(SalesOffiRepoConditionVO vo) throws EventException;	
	
	/**
	 * 비용 RMK 상세조회[Inquiry by BKG Remark]<br>
	 *  ESM_COA_0170화면에 대한 조회 이벤트 처리<br>
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
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchBKG0061List2(SearchConditionVO searchConditionVO) throws EventException; 

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchBKG0061List3(SearchConditionVO searchConditionVO) throws EventException;
	
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
	 * ESM_COA_003(So Cost Code)화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param SalesRPTCommonVO[] vos
	 * @param CoaRptItmInfoMstVO[] tVos
	 * @param CoaRptItmInfoDtlVO[] tVos2
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSetForm059(SearchConditionVO searchVo, SalesRPTCommonVO vo, SalesRPTCommonVO[] vos, CoaRptItmInfoMstVO[] tVos, CoaRptItmInfoDtlVO[] tVos2, SignOnUserAccount account) throws EventException;
	
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
     * COA 업무 시나리오 마감작업<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<ShipperVO>
	 * @exception EventException
	 */
	public List<ShipperVO> searchShipperList(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * Weekly Sales Report By Office1 조회 이벤트 처리[ESM_COA_070]
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchRPTbyOfc0070List11(SalesOffiRepoConditionVO vo) throws EventException;
	
	/**
	 * Weekly Sales Report By Office1 조회 이벤트 처리[ESM_COA_070]
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchRPTbyOfc0070List12(SalesOffiRepoConditionVO vo) throws EventException;

}