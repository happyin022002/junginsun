/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: OPMasterBC.java
*@FileTitle 	: 항로 생성/조회/변경
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-10-12
*@LastModifier 	: Park Eun Ju
*@LastVersion 	: 1.0
* 2006-10-12 Park Eun Ju
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.MultiOmPortMngVO;			//20150519.ADD
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchHistoryLaneListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchRgstLaneListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchVslInfoListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaLaneRgstVO;
import com.clt.syscommon.common.table.CoaLaneTpHisVO;
import com.clt.syscommon.common.table.CoaVslRgstVO;
import com.clt.syscommon.common.table.CoaVslSubTrdCapaVO;

/**
 * COA Business Logic Command Interface<br>
 * - COA에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Eun Ju
 * @see ESM_COA_036EventResponse 참조
 * @since J2EE 1.4
 */
public interface OPMasterBC  {

    /**
     * 1. 기능 : OPMaster 항로관리 화면에 대한 조회 이벤트 처리(ESM_COA_036)<p>
     * 2. 처리개요 : <p>
     *    - 항로관리에 대한 리스트를 조회
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park eun ju /2006.10.12<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * 
     * @param SearchConditionVO searchVo
     * @param SignOnUserAccount account
     * @return List<SearchRgstLaneListVO>
     * @exception EventException
     */
	public List<SearchRgstLaneListVO> searchRgstLaneList(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * OPMaster 선박관리화면에서 관리하는 Sub Trade 화면에 대한 조회 이벤트 처리
     * <p/>
     * 
     * @return CommonCoaRsVO
     * @exception EventException
	 */
	public CommonCoaRsVO searchVSLSubTradeList() throws EventException;
	
	/**
	 * OPMaster 선박관리 화면에 대한 조회한다.<br>
	 * ESM_COA_0036화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
     *
	 * @param SearchConditionVO searchVo
	 * @return CommonCoaRsVO
	 * @exception EventException
	 *  명칭변경(2009.09.30) : searchVslInfoList ---> searchVslRgstList
	 */	
	public CommonCoaRsVO searchVslRgstList(SearchConditionVO searchVo) throws EventException;
	
    /**
     * 1. 기능 : OPMaster 항로관리 화면에 대한 멀티 이벤트 처리(ESM_COA_036)<p>
     * 2. 처리개요 : <p>
     *    - OPMaster에 대한 리스트를 조회
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park eun ju /2006.10.12<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * 
     * @param SearchConditionVO searchVO
     * @param CoaLaneRgstVO[] coaLaneRgstVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
	public EventResponse multiRgstLane(SearchConditionVO searchVO, CoaLaneRgstVO[] coaLaneRgstVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * OPMaster 선박관리화면에서 관리하는 Sub Trade 화면의 멀티 이벤트 처리
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	변환 후 저장 038번 화면 저장로직 제거
	public EventResponse modifyVSLSubTrade(Event e) throws EventException; 
   */
	/**
	 * OPMaster 선박관리화면의 멀티처리한다.
 	 * ESM_COA_0037화면에 대한 조회 이벤트 처리<br>
     * 명칭 변경 multiVSLInfo --->  multiVslRgst
 	 * 
	 * @param SearchConditionVO searchVo
     * @param CommonCoaRsVO commonCoaRsVO
     * @param CoaVslRgstVO[] coaVslRgstVOs
     * @param CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
	 */
	public EventResponse multiVslRgst(SearchConditionVO searchVo, CommonCoaRsVO commonCoaRsVO, CoaVslRgstVO[] coaVslRgstVOs, CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 	OPMaster 선박관리화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<SearchVslInfoListVO>
	 * @exception EventException
	 */
	public List<SearchVslInfoListVO> searchVslInfoList(SearchConditionVO searchVO) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * BSA용 OPMaster화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
     * @return CommonCoaRsVO
     * @exception EventException
	 */
	public CommonCoaRsVO searchHistVslInfoList(SearchConditionVO searchVO) throws EventException;
	
	/**
	 * OPMaster BSA용 선박관리화면의 멀티 이벤트 처리
	 * 
	 * @param SearchConditionVO searchVo
     * @param CommonCoaRsVO commonCoaRsVO
     * @param CoaVslRgstVO[] coaVslRgstVOs
     * @param CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
	*/
	public EventResponse multiHistVSLInfo(SearchConditionVO searchVo, CommonCoaRsVO commonCoaRsVO, CoaVslRgstVO[] coaVslRgstVOs, CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs, SignOnUserAccount account) throws EventException,Exception;
	
	/**
	 * Lane History 조회 이벤트 처리<br>
	 * Create Lane Table화면의 Popup 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @param SignOnUserAccount account
	 * @return List<SearchHistoryLaneListVO> 
	 * @exception EventException
	 */
	public List<SearchHistoryLaneListVO> searchHistoryLaneList(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Lane History 수정 이벤트 처리<br>
	 * Create Lane Table화면의 Popup 대한 수정 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param CoaLaneTpHisVO[] coaLaneTpHisVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiHistoryLane(SearchConditionVO searchVo, CoaLaneTpHisVO[] coaLaneTpHisVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4009 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author 20150519.ADD
	 */
    public CommonCoaRsVO searchOmPortMngList(SearchConditionVO searchVO) throws EventException;
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4009 화면 대한 멀티 이벤트 처리<br>
     * 
     * @param MultiOmPortMngVO[] multiOmPortMngVO
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account 
     * @return String
     * @exception EventException
     * @author 20150519.ADD
     */
    public String multiOmPortMngInfo(MultiOmPortMngVO[] multiOmPortMngVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4010 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author 20150619.ADD
	 */
    public CommonCoaRsVO searchCrsChkCoaBkgPeriod(SearchConditionVO searchVO) throws EventException;
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4009 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author 20150619.ADD
	 */
    public CommonCoaRsVO searchCrsChkCoaBkgVVD(SearchConditionVO searchVO) throws EventException;    
}