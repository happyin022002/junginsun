/*=========================================================
*Copyright(c) 20006 CyberLogitec
*@FileName : COPManageBC.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 20006-08-29
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Seong-mun Kang
* 1.0 최초 생성
* 2009.02.26 - 안정선 - CSR NO. N20009020300014 COP Inquiry 화면과 COP Summary 화면을 하나의 화면으로 통합
* 2009.09.03 - 오현경  - NIS2010 Construction
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPDetailVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPReplanInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchCOPMainListVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSCInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSOCostInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSceCopHdrInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchTargetCOPInfoListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * ENIS-SCE Business Logic Command Interface<br>
 * - ENIS-SCE에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seong-mun Kang
 * @see EsdSce0001EventResponse 참조
 * @since J2EE 1.4
 */
public interface COPSearchBC  {
	 
	/**
     * COP Main 조회 이벤트 처리<br>
     *
     * @param inqVO COPInquiryVO
     * @return List<SearchCOPMainListVO>
     * @exception EventException ...
     */
	public List<SearchCOPMainListVO>  searchCOPMainList(COPInquiryVO inqVO) throws EventException;
	
	/**
     * COP Inqueriy Master 리스트 조회
     * @param inqVO COPInquiryVO
     * @return EventResponse
     * @throws EventException ...
     */
    public List<SearchSceCopHdrInfoVO> searchSceCopHdrInfo(COPInquiryVO inqVO) throws EventException;
    
    /**
     * COP Inquiery S/O 여부 조회
     * @param inqVO COPInquiryVO
     * @return List<SearchSCInfoVO>
     * @throws EventException ...
     */
    public List<SearchSCInfoVO> searchSCInfo(COPInquiryVO inqVO)  throws EventException;
    	
    /**
     * SCE_COP_HDR Update
     * @param inqVO COPInquiryVO
     * @throws EventException ...
     */
    public void modifyPCopHdr(COPInquiryVO inqVO) throws EventException;
       
    /**
     * trs_trsp_rail_bil_ord,trs_trsp_svc_ord Update
     * @param inqVO SearchSCInfoVO
     * @throws EventException ...
     */
    public void modifyTrsRailSvcOrd(SearchSCInfoVO inqVO) throws EventException;
    
    /**
     * SCE_COP_HDR Update
     * @param inqVO COPInquiryVO
     * @throws EventException ...
     */
    public void modifyCopHdr(COPInquiryVO inqVO) throws EventException;
    
    /**
     * SCE_COP_Log Insert
     * @param inqVO COPInquiryVO
     * @throws EventException ...
     */
    public void addSceCopHis(COPInquiryVO inqVO) throws EventException;   
    

    /**
     * 조회 이벤트 처리<br>
     * searchBookingDetail 조회 이벤트 처리<br>
     *
     * @param inqVO COPInquiryVO
     * @return List
     * @exception EventException ...
     */
	@SuppressWarnings("unchecked")
	public List searchBookingDetail(COPInquiryVO inqVO) throws EventException;
	
	/**
	 * COP Sub Status Change
	 * @param mainListVOs SearchCOPMainListVO[] 
	 * @throws EventException ...
	 */
	public void modifyCOPStatusChange(SearchCOPMainListVO[] mainListVOs) throws EventException;

    /**
     * COP Detail 조회 이벤트 처리<br>
     *
     * @param inqVO COPDetailVO 
     * @return GeneralEventResponse
     * @exception EventException ... 
     */
	public GeneralEventResponse searchCOPDetail(COPDetailVO inqVO) throws EventException ;

    /**
     * 조회 이벤트 처리<br>
     * Booking List 조회 이벤트 처리<br>
     *
     * @param inqVO COPDetailVO 
     * @return List<SearchSceCopHdrInfoVO>
     * @exception EventException ...
     */
    public List<SearchSceCopHdrInfoVO> searchBookingList(COPDetailVO inqVO) throws EventException;

    /**
     * 현재 진행중인 detail 정보를 구한다.<br>
     *
     * @param inqVOs COPReplanInfoVO[] 
     * @param inqVO COPReplanInfoVO 
     * @return String[]
     * @exception EventException ...
     */
    public String[] searchCopCurrentInfo(COPReplanInfoVO[] inqVOs, COPReplanInfoVO inqVO) throws EventException ;


    /**
     * searchTargetCOPInfoList 조회 이벤트 처리<br>
     *
     * @param inqVO COPReplanInfoVO 
     * @return List<SearchTargetCOPInfoListVO>
     * @exception EventException ...
     */
    public List<SearchTargetCOPInfoListVO> searchTargetCOPInfoList(COPReplanInfoVO inqVO) throws EventException;

	/**
     * searchTargetPCInfoList 조회 이벤트 처리<br>
     *
     * @param inqVOs COPReplanInfoVO[] 
     * @param inqVO COPReplanInfoVO 
     * @param frmtoNum String[] 
     * @return GeneralEventResponse
     * @exception EventException ...
     */
    public GeneralEventResponse searchTargetPCInfoList(COPReplanInfoVO[] inqVOs, COPReplanInfoVO inqVO,String[] frmtoNum) throws EventException;

	/** 
	 * Get MT node
	 * @param cop_no String 
	 * @param ioBndCd String 
	 * @return String
	 * @throws EventException ...
	 */
	public String getMTNode(String cop_no, String ioBndCd) throws EventException;

	/**
	 * TRS S/O Candidate Creation
	 * @throws EventException ...
	 */
	public EventResponse modifyTRSSoCnddtCreation(Event e) throws EventException;
	
//	/**
//	 * 조회 이벤트 처리<br>
//     *   2009.11.10 미사용으로 인한 주석처리	 * 
//	 * @param vvd String
//	 * @param nod String
//	 * @param port String
//	 * @return lpllist ArrayList
//	 * @exception EventException
//	 */
//	//public ArrayList getVVDCopList(String vvd, String nod, String port) throws EventException;
//
//	/**
//     *   2009.11.10 미사용으로 인한 주석처리	 * 
//	 * @param hmap
//	 * @param isAll
//	 * @return
//	 * @throws EventException ...
//	 */
//	//public String checkDY( HashMap hmap, String isAll ) throws EventException;
//
//
//	/**
//     *   2009.11.10 미사용으로 인한 주석처리	 * 
//	 * @param hmap
//	 * @return
//	 * @throws EventException ...
//	 */
//	//public String checkOrpCOP( HashMap hmap ) throws EventException;
//
//	/**
//     *   2009.11.10 미사용으로 인한 주석처리	 * 
//	 * @param hmap
//	 * @param isAll
//	 * @return
//	 * @throws EventException ...
//	 */
//	//public int checkOrpSORoute( HashMap hmap, String isAll ) throws EventException;
//
//
//	/**
//     *   2009.11.10 미사용으로 인한 주석처리	 * 
//	 * @param e
//	 * @return
//	 * @throws EventException ...
//	 */
//	//public EventResponse getSOResultList(Event e) throws EventException;
//
//	/**
//     *   2009.11.10 미사용으로 인한 주석처리	 * 
//	 * @param e
//	 * @return
//	 * @throws EventException ...
//	 */
//	//public EventResponse retrySOList(Event e) throws EventException;
//
//	/**
//     *   2009.11.10 미사용으로 인한 주석처리	 * 
//	 * @param e
//	 * @param dist
//	 * @return
//	 * @throws EventException ...
//	 */
//	//public EventResponse getCOPHeaderInfo(Event e, int dist) throws EventException;
//
//
//	/**
//     *   2009.11.10 미사용으로 인한 주석처리 
//	 * @param szBkgNo
//	 * @param szBkgNoSplit
//	 * @return
//	 * @throws EventException ...
//	 */
//	//public String getBkgVVD ( String szBkgNo, String szBkgNoSplit) throws EventException;
//
//	/**
//     *   2009.11.10 미사용으로 인한 주석처리 
//	 * @param szCntrNo
//	 * @return
//	 * @throws EventException ...
//	 */
//	//public DBRowSet getCntrVVDs ( String szCntrNo) throws EventException;
//	
//	/** Search Master booking No
//     *   - TRO cnfm 시 master가 아닌 booking인 경우, 해당 cntr의 master booking return.
//     *   2009.11.10 미사용으로 인한 주석처리
//	 * @param 
//	 * @return
//	 * @throws EventException ...
//	 */
//	//public String searchMstrBkgNo(String bkg_no, String bkg_no_split, String cntr_no_list) throws EventException ;
//	
//	/** Search Master booking No
//     *   - TRO cnfm 시 master가 아닌 booking인 경우, 해당 cntr의 master booking return.
//	 * @param 
//	 * @return
//	 * @throws EventException ...
//	 */	
//	//public RequestDataSetBC searchTransportation(String cop_no, String bkg_no, String bkg_no_split, String cntr_no) throws EventException;
//	
//	
//
//
//    /**
//     * sce_cost_act_grp Update
//     * @param e
//     * @param soIfListEvent 
//     * @return EventResponse
//     * @throws EventException
//     */
////    public void modifySceCostActGrp(Event e, TrsInterface2PrdEvent soIfListEvent) throws EventException;


 
}