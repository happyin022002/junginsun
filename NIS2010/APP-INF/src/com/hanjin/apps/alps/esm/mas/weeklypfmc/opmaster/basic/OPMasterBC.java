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
*  2010.02.05 임옥영 :품질검토결과 반영
*  2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.CommonMasRsVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.SearchHistoryLaneListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.SearchRgstLaneListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.SearchVslInfoListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasLaneRgstVO;
import com.hanjin.syscommon.common.table.MasLaneTpHisVO;
import com.hanjin.syscommon.common.table.MasVslRgstVO;
import com.hanjin.syscommon.common.table.MasVslSubTrdCapaVO;

/**
 * eNIS-MAS Business Logic Command Interface<br>
 * - eNIS-MAS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Eun Ju
 * @see ESM_MAS_036EventResponse 참조
 * @since J2EE 1.4
 */
public interface OPMasterBC  {

    /**
     * 1. 기능 : OPMaster 항로관리 화면에 대한 조회 이벤트 처리(ESM_MAS_036)<p>
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
     * @param SearchConditionVO searchVo
     * @param SignOnUserAccount account
     * @return List<SearchRgstLaneListVO>
     * @exception EventException
     */
	public List<SearchRgstLaneListVO> searchDataForDateCheckOfLaneHistory(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * OPMaster 선박관리화면에서 관리하는 Sub Trade 화면에 대한 조회 이벤트 처리
     * <p/>
     * 
     * @return CommonMasRsVO
     * @exception EventException
	 */
	public CommonMasRsVO searchVSLSubTradeList() throws EventException;
	
	/**
	 * OPMaster 선박관리 화면에 대한 조회한다.<br>
	 * ESM_MAS_0036화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
     *
	 * @param SearchConditionVO searchVo
	 * @return CommonMasRsVO
	 * @exception EventException
	 *  명칭변경(2009.09.30) : searchVslInfoList ---> searchVslRgstList
	 */	
	public CommonMasRsVO searchVslRgstList(SearchConditionVO searchVo) throws EventException;
	
	/**
	 * @param SearchConditionVO searchVo
	 * @return CommonMasRsVO
	 * @exception EventException
	 */	
	public CommonMasRsVO searchDataForDateCheckOfVesselHistory(SearchConditionVO searchVo) throws EventException;
	
    /**
     * 1. 기능 : OPMaster 항로관리 화면에 대한 멀티 이벤트 처리(ESM_MAS_036)<p>
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
     * @param MasLaneRgstVO[] masLaneRgstVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
	public EventResponse multiRgstLane(SearchConditionVO searchVO, MasLaneRgstVO[] masLaneRgstVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * OPMaster 선박관리화면에서 관리하는 Sub Trade 화면의 멀티 이벤트 처리
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	ALPS 변환 후 저장 038번 화면 저장로직 제거
	public EventResponse modifyVSLSubTrade(Event e) throws EventException; 
   */
	/**
	 * OPMaster 선박관리화면의 멀티처리한다.
 	 * ESM_MAS_0037화면에 대한 조회 이벤트 처리<br>
     * 명칭 변경 multiVSLInfo --->  multiVslRgst
 	 * 
	 * @param SearchConditionVO searchVo
     * @param CommonMasRsVO commonMasRsVO
     * @param MasVslRgstVO[] masVslRgstVOs
     * @param MasVslSubTrdCapaVO[] masVslSubTrdCapaVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
	 */
	public EventResponse multiVslRgst(SearchConditionVO searchVo, CommonMasRsVO commonMasRsVO, MasVslRgstVO[] masVslRgstVOs, MasVslSubTrdCapaVO[] masVslSubTrdCapaVOs, SignOnUserAccount account) throws EventException;

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
     * @return CommonMasRsVO
     * @exception EventException
	 */
	public CommonMasRsVO searchHistVslInfoList(SearchConditionVO searchVO) throws EventException;
	
	/**
	 * OPMaster BSA용 선박관리화면의 멀티 이벤트 처리
	 * 
	 * @param SearchConditionVO searchVo
     * @param CommonMasRsVO commonMasRsVO
     * @param MasVslRgstVO[] masVslRgstVOs
     * @param MasVslSubTrdCapaVO[] masVslSubTrdCapaVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
	*/
	public EventResponse multiHistVSLInfo(SearchConditionVO searchVo, CommonMasRsVO commonMasRsVO, MasVslRgstVO[] masVslRgstVOs, MasVslSubTrdCapaVO[] masVslSubTrdCapaVOs, SignOnUserAccount account) throws EventException,Exception;
	
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
	 * @param MasLaneTpHisVO[] masLaneTpHisVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiHistoryLane(SearchConditionVO searchVo, MasLaneTpHisVO[] masLaneTpHisVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Lane History 수정 이벤트 처리<br> Create Lane Table에서 변경된 내역을 자동으로 쌓을 때
	 * Create Lane Table화면의 Popup 대한 수정 이벤트 처리<br>
	 * 
	 * @param MasLaneTpHisVO[] masLaneTpHisVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiAutomaticHistoryLane(MasLaneTpHisVO[] masLaneTpHisVOs, SignOnUserAccount account) throws EventException;
}