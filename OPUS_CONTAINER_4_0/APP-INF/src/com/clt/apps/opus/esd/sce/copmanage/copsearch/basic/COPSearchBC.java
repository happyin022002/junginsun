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
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPDetailVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPReplanInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchCOPMainListVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchSCInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchSceCopHdrInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchTargetCOPInfoListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * SCE Business Logic Command Interface<br>
 * - SCE에 대한 비지니스 로직에 대한 인터페이스<br>
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
	@SuppressWarnings("rawtypes")
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
}