/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : VesselReportBC.java
*@FileTitle : Vessel Report BC
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-23
*@LastModifier : Jeong-Seon An , Yoon-Jung Lee
*@LastVersion : 1.0
* 2007-07-23 Jeong-Seon An , Yoon-Jung Lee
* 2007-08-20 Jeong-Seon An , Yoon-Jung Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.basic;


import java.util.List;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.event.EsdSce0056Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportInVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;


/**
 * ENIS-SCEM Commission Business Logic Command Interface<br>
 * - ENIS-SCEM Commission에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kildong_hong
 * @see UI_ID_11EventResponse 참조
 * @since J2EE 1.4
 */
public interface VesselReportBC  {

// 20080923 미사용table 관련 정리
//	/**
//     * Vessel Report
//     * 
//     * @param e EsdSce0056Event
//     * @return eventResponse EsdSce0056EventResponse
//     * @throws EventException
//     */
//	
//	public EventResponse searchVORList(EsdSce0056Event event) throws EventException;	

	/**
     * US INLAND OPERATION REPORT
     * 
     * @param SearchUSIORInfoVO usiorInfo
     * @param String ofcCd
     * @return List<SearchUSIORListVO>
     * @throws EventException
     */
	public DBRowSet searchUSIORList(SearchUSIORInfoVO usiorInfo, String ofcCd) throws EventException;	
	
	/**
	 * 
	 * US INLAND OPERATION REPORT DOWN ONLY
	 * 
	 * @param SearchUSIORInfoVO usiorInfo
	 * @param String ofcCd
	 * @return DBRowSet 
	 * @exception EventException
	 */
	DBRowSet searchUSIORInquiry(SearchUSIORInfoVO usiorInfo, String ofcCd) throws EventException ;
	
	/**
	 * 조회조건(combo)을 위한 West Cost, East Cost에 따른 Location 조회.
	 * 
	 * @param  String costDiv
	 * @return List<SearchUSIORListVO>
	 * @throws EventException
	 */	
    public List<SearchUSIORListVO> searchCostPod(String costDiv) throws EventException;
    
    /**
	 * 조회조건(combo)을 위한 Equipment Office Code 조회.
	 * 
	 * @return List<SearchUSIORListVO>
	 * @throws EventException
	 */	
    public List<SearchUSIORListVO> searchEqmtOfcCd() throws EventException;
    
	/**
	 * 
	 * US INLAND OPERATION REPORT DOWN ONLY
	 * 
	 * @return String[]
	 */
	String[] getTitle();

	/**
	 * 
	 * US INLAND OPERATION REPORT DOWN ONLY
	 * 
	 * @return String[]
	 */
	String[] getColumns();


 
}