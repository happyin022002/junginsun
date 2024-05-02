/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : VesselReportBC.java
*@FileTitle : Vessel Report BC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.basic;


import java.util.List;

import com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORInfoVO;
import com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORListVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;


/**
 * SCEM Commission Business Logic Command Interface<br>
 * - <br>
 *
 * @author Kildong_hong
 * @see UI_ID_11EventResponse 참조
 * @since J2EE 1.4
 */
public interface VesselReportBC  {

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