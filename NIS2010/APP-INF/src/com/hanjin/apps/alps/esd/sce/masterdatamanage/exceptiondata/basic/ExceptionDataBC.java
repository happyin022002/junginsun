/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ScemSetupBC.java
*@FileTitle : Exception Alert/통지 대상 등록 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : yong_cheon_shin
*@LastVersion : 1.0
* 2006-08-29 yong_cheon_shin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcList3VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMasterOfcListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListForMultiVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpmasterOfcInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDTLTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailList3VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStr2VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStrVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchSubscriberGroupMappingVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
 
/**
 * ENIS-SCEM Business Logic Command Interface<br>
 * - ENIS-SCEM에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author yong_cheon_shin
 * @see EsdSce0028EventResponse 참조
 * @since J2EE 1.4
 */
public interface ExceptionDataBC  {

    /**
     * Exception Tolerance list 조회
     * @param SearchToleranceInfoVO tolInfo
     * @return List<SearchToleranceListVO>
     * @throws EventException
     */
    public List<SearchToleranceListVO> searchToleranceList(SearchToleranceInfoVO tolInfo) throws EventException;

    /**
     * Exception tolerance 입력/수정
     * @param Event e
     * @param String usr_id
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse multiTolerance(Event e, String usr_id) throws EventException;

    /**
     * Yard 명 가져오기
     *
     * @param e Event
     * @return EventResponse
     * @throws EventException
     */
//    public EventResponse searchYardName(Event e) throws EventException;

// 20080923 미사용table관련 정리    
//    /**
//     * Tolerance Validation Check
//     *
//     * @param e Event
//     * @return EventResponse
//     * @throws EventException
//     */
//    public EventResponse searchToleranceValidate(Event e) throws EventException;
// 20080923 미사용table관련 정리    

	/**
	 * validation Check Location
	 * @param chkData
	 * @return
	 * @throws EventException
	 */
//    public EventResponse validationLoc(Event e) throws EventException;

    /**
     * Exception Type Registration 조회
     *
     * @return List<SearchExpTypeListVO>
     * @throws EventException
     */
    public List<SearchExpTypeListVO> searchExpTypeList() throws EventException;

    /**
     * Exception Type Detail Registration 議고쉶
     *
     * @return List<SearchExpTypeDetailListVO>
     * @throws EventException
     */
    public List<SearchExpTypeDetailListVO> searchExpTypeDetailList() throws EventException;

    /**
     * Exception Type Registration 입력/수정
     *
     * @param Event e
     * @param String usrId
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse multiExpType(Event e, String usrId) throws EventException;

    /**
     * Exception Type Detail Registration ?낅젰/?섏젙
     *
     * @param Event e
     * @param String usrId
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse multiExpTypeDetail(Event e, String usrId) throws EventException;
    
    /**
     * Exception Type Detail by Exception Type
     *
     * @param SearchExpInfoVO expt
     * @return List<SearchExptDetailList3VO>
     * @throws EventException
     */
    public List<SearchExptDetailList3VO> searchExptDetailList3(SearchExpInfoVO expt) throws EventException; 
    
    /**
     * Location 명 가져오기
     *
     * @param e Event
     * @return EventResponse
     * @throws EventException
     */
//    public EventResponse searchLocationName(EsdSce0028Event event) throws EventException;

    /**
     * Exception Notification Subscriber Registration 입력/수정
     *
     * @param Event e
     * @param String usrId
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse multiExptNoticeSubscriber(Event e, String usrId) throws EventException;

//    /**
//     * Exception Notification Office 입력/수정
//     *
//     * @param event EsdSce0052Event
//     * @return EventResponse
//     * @throws EventException
//     */
//    public EventResponse multiExptNoticeOffice(EsdSce0052Event event) throws EventException;

// 20080923 미사용table 관련 정리
//    /**
//     * Exception Notification Subscriber Registration 조회
//     *
//     * @param event EsdSce0028Event
//     * @return EventResponse
//     * @exception EventException
//     */
//    public EventResponse searchExptNoticeSubscriber(EsdSce0028Event event) throws EventException ;

//    /**
//     * Exception Notification Office 조회
//     *
//     * @param event EsdSce0052Event
//     * @return EventResponse
//     * @exception EventException
//     */
//    public EventResponse searchExptNoticeOfficeList(EsdSce0052Event event) throws EventException ;
//    /**
//     * Rail Exception Tolerance 조회
//     *
//     * @param event EsdSce0047Event
//     * @return EventResponse
//     * @exception EventException
//     */
//    public EventResponse searchRailExptTolerance(EsdSce0047Event event) throws EventException ;

// 20080923 미사용table관련 정리
//    /**
//     * Exception Type & Subscriber Group Mapping 조회
//     *
//     * @param event EsdSce0047Event
//     * @return EventResponse
//     * @exception EventException
//     */
//    public EventResponse searchSubscriberGroupMapping(EsdSce0049Event event) throws EventException ;

//    /**
//     * Rail Exception Tolerance 조회
//     *
//     * @param event EsdSce0047Event
//     * @return EventResponse
//     * @exception EventException
//     */
//    public EventResponse searchRailExptYard(EsdSce0047Event event) throws EventException ;

    /**
     * Exception Type Detail Max Seq 조회
     *
     * @param SearchExpTypeDetailListForMultiVO detail
     * @return List<SearchExptDetailQueryStrVO>
     * @exception EventException
     */
    public List<SearchExptDetailQueryStrVO> searchExptDetail(SearchExpTypeDetailListForMultiVO detail) throws EventException ;
    
    /**
     * Exception Type Detail Max Seq 조회
     *
     * @param SearchExpTypeDetailListForMultiVO detail
     * @return List<SearchExptDetailQueryStr2VO>
     * @exception EventException
     */
    public List<SearchExptDetailQueryStr2VO> searchExptDetail2(SearchExpTypeDetailListForMultiVO detail) throws EventException ;

    /**
     * Exception Tolerance Activity
     *
     * @param event EsdSce0029Event
     * @return EventResponse
     * @exception EventException
     */
//    public EventResponse searchExptTolAct(EsdSce0029Event event) throws EventException ;
//    /**
//     * Rail Exception Tolerance Registration 입력/수정
//     *
//     * @param event EsdSce0047Event
//     * @return EventResponse
//     * @throws EventException
//     */
//    public EventResponse multiRailExptTolerance(EsdSce0047Event event) throws EventException;

    /**
     * Exception Type & Subscriber Group Mapping 입력/수정
     *
     * @param Event e
     * @param String usr_id
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse multiSubscriberGroupMapping(Event e, String usr_id) throws EventException;
    
    /**
     * minestar - Subscriber Group Mapping 조회
     *
     * @param SearchToleranceInfoVO tolInfo
     * @return List<SearchSubscriberGroupMappingVO>
     * @exception EventException
     */
    public List<SearchSubscriberGroupMappingVO> searchSubscriberGroupMapping(SearchToleranceInfoVO tolInfo) throws EventException ;

    /**
     * * minestar - Subscriber Registration 조회
     *
     * @param SearchExptSubReqInfoVO reqInfo
     * @return List<SearchExptSubReqListVO>
     * @throws EventException
     */
    public List<SearchExptSubReqListVO> searchExptSubscriberRegistration(SearchExptSubReqInfoVO reqInfo) throws EventException ;

    /**
     * 조회 이벤트 처리<br>
     * Exception Type 조회 이벤트 처리<br>
     *
     * @return List<SearchExptTPListVO>
     * @exception EventException
     */
	public List<SearchExptTPListVO> searchExptTPList() throws EventException;	
//	public EventResponse searchExptTPList(EsdSce0049Event e) throws EventException;&&& 소스품질수정	

    /**
     * 조회 이벤트 처리<br>
     * Exception Detail Type 조회 이벤트 처리<br>
     *
     * @param SearchExpInfoVO expInfo
     * @return List<SearchExptDTLTPListVO>
     * @exception EventException
     */
	public List<SearchExptDTLTPListVO> searchExptDTLTPList(SearchExpInfoVO expInfo) throws EventException;	


    /**
     * 조회 이벤트 처리<br>
     * Exception Type 조회 이벤트 처리<br>
     *
     * @return List<SearchExptTPListVO>
     * @exception EventException
     */
	public List<SearchExptTPListVO> searchTOLExptTPList() throws EventException;	

    /**
     * 조회 이벤트 처리<br>
     * Exception Detail Type 조회 이벤트 처리<br>
     *
     * @param SearchExpInfoVO expInfo
     * @return List<SearchExptDTLTPListVO>
     * @exception EventException
     */
	public List<SearchExptDTLTPListVO> searchTOLExptDTLTPList(SearchExpInfoVO expInfo) throws EventException;	

    /**
     * 조회 이벤트 처리<br>
     * Exception Loc/Ofc 조회 이벤트 처리<br>
     *
     * @param  e Event
     * @return response EventResponse
     * @exception EventException
     */
//	public EventResponse searchLocOfcList() throws EventException;	
//	public EventResponse searchLocOfcList(EsdSce0028Event e) throws EventException;&&& 소스품질수정	
    /**
     * Exception Office Mapping(master office) 조회 &&&
     *
     * @param SearchExpmasterOfcInfoVO ofcInfo
     * @return List<SearchExpMasterOfcListVO>
     * @throws EventException
     */
    public List<SearchExpMasterOfcListVO> searchExpMasterOfcList(SearchExpmasterOfcInfoVO ofcInfo) throws EventException;
    
    /**
     * Exception Office Mapping(searchExpMapgOfcList) &&&
     *
     * @return List<SearchExpMapgOfcListVO>
     * @throws EventException
     */
    public List<SearchExpMapgOfcListVO> searchExpMapgOfcList() throws EventException;
    
    /**
     * Exception Office Mapping(multiExpMapgOfc) &&&
     *
     * @param Event e
     * @param String usrId
     * @return EventResponse
     * @throws EventException
     */
    public EventResponse multiExpMapgOfc(Event e, String usrId) throws EventException; 
    
    /**   
     * Exception Office Mapping(searchExpMapgOfcList3) &&&
     *
     * @param SearchExpmasterOfcInfoVO ofcInfo
     * @return List<SearchExpMapgOfcList3VO>
     * @throws EventException
     */
    public List<SearchExpMapgOfcList3VO> searchExpMapgOfcList3(SearchExpmasterOfcInfoVO ofcInfo) throws EventException; 


}