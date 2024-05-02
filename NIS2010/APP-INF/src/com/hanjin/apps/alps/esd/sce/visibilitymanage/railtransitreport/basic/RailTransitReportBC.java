/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailTransitReportBC.java
*@FileTitle : Rail Transit Report BC
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-16 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListOptionsVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListPopVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBKGNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBLNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputCntrVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputVVDVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRListVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchTRCListOptionsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.Event;

/**
 * ENIS-SCEM Commission Business Logic Command Interface<br>
 * - ENIS-SCEM Commission에 대한 비지니스 로직에 대한 인터페이스<br>
 * @author Kildong_hong
 * @see UI_ID_11EventResponse 참조
 * @since J2EE 1.4
 */
public interface RailTransitReportBC  {

	/**
     * Car Location Message 조회
     * 
     * @param SearchCLMListOptionsVO schClmlOpts
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse searchCLMList(SearchCLMListOptionsVO schClmlOpts) throws EventException;
    
    /**
     * Car Location Message 조회
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return List<SearchCLMListPopVO>
     * @throws EventException
     */
	public List<SearchCLMListPopVO> searchCLMListPop(SearchRTRInfoVO rtrInfo) throws EventException;
    /**
     * CLM Message 조회
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchCLMCountPop(SearchRTRInfoVO rtrInfo) throws EventException;
	
	/**
     * Train & Rail Car 조회
     * 
     * @param SearchTRCListOptionsVO schTrlOpts
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchTRCList(SearchTRCListOptionsVO schTrlOpts) throws EventException;
	
	/**
     * Rail Transit Report
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @param String searchType
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchRTRCnt(SearchRTRInfoVO rtrInfo, String searchType) throws EventException;
	// String searchType 파라메타는 멀티에서 사용. 아래 searchRTRList(SearchRTRInfoVO rtrInfo)는 single 사용.
	/**
     * Rail Transit Report 조회
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @param SearchRTRListVO[] rtrLists
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchRTRList(SearchRTRInfoVO rtrInfo, SearchRTRListVO[] rtrLists) throws EventException;

	/**
     * Rail Transit Report 조회
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchRTRList(SearchRTRInfoVO rtrInfo) throws EventException;
	/**
     * Multi Input
     * 
     * @param SearchMultiInputCntrVO[] cntrInfos
     * @return List<SearchMultiInputCntrVO>
     * @throws EventException
     */
	public List<SearchMultiInputCntrVO> searchMultiInput(SearchMultiInputCntrVO[] cntrInfos) throws EventException ;

	/**
     * Multi Input
     * 
     * @param SearchMultiInputBKGNoVO[] bkgInfos
     * @return List<SearchMultiInputBKGNoVO>
     * @throws EventException
     */
	public List<SearchMultiInputBKGNoVO> searchMultiInputBkgNo(SearchMultiInputBKGNoVO[] bkgInfos) throws EventException ;

	/**
     * Multi Input
     * 
     * @param SearchMultiInputBLNoVO[] bkgInfos
     * @return List<SearchMultiInputBLNoVO>
     * @throws EventException
     */
	public List<SearchMultiInputBLNoVO> searchMultiInputBlNo(SearchMultiInputBLNoVO[] bkgInfos) throws EventException ;

	/**
     * Multi Input
     * 
     * @param SearchMultiInputVVDVO[] vvdInfos
     * @return List<SearchMultiInputVVDVO>
     * @throws EventException
     */
	public List<SearchMultiInputVVDVO> searchMultiInputVvd(SearchMultiInputVVDVO[] vvdInfos) throws EventException ;
    //public EventResponse searchMultiInput(EsdSce048Event event) throws EventException ;	
	/**
     * Rail Transit Report Modify
     * 
     * @param SearchRTRListVO[] models
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse modifyRTRReport(SearchRTRListVO[] models) throws EventException ;
	/**
     * Rail Transit Report Modify
     * 
     * @param SearchRTRListVO[] models
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse modifyRTRReportRemark(SearchRTRListVO[] models) throws EventException ;
	/**
     * RTR Summary List 조회
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchRTRSmmyList(Event e) throws EventException;
	/**
     * RTR Summary Detail 조회
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
	public EventResponse searchRTRSmmyDetail(Event e) throws EventException;
	
	
}