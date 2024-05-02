/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCollectionOfficeMgtBC.java
*@FileTitle : DEM/DET Office Inquiry by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.29 mun jung cheol
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.CollectionOfficeFinderVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.DmtYdExptCostParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.DmtYdExptCostVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.OfficeYardListVO;

/**
 * ALPS-Dmtperformanceanalysis Business Logic Command Interface<br>
 * - ALPS-Dmtperformanceanalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang HyoKeun
 * @see DMTCollectionOfficeMgtBCImpl 클래스 참조
 * @since J2EE 1.6
 */

public interface DMTCollectionOfficeMgtBC {
    /**
     * [DEM/DET Office Inquiry by Yard]을 [SEARCH] 합니다.<br>
     * 
     * @param CollectionOfficeFinderVO CollectionOfficeFinderVO
     * @return List<OfficeYardListVO>
     * @exception EventException
     */
    public List<OfficeYardListVO> searchCollectionOfficeList ( CollectionOfficeFinderVO CollectionOfficeFinderVO ) throws EventException;

    /**
     * [YardExceptionCost]을 [SEARCH] 합니다.<br>
     * 
     * @param DmtYdExptCostParmVO dmtYdExptCostParmVO
     * @return List<DmtYdExptCostVO>
     * @exception EventException
     */   
    public List<DmtYdExptCostVO> searchYardExceptionCost( DmtYdExptCostParmVO dmtYdExptCostParmVO ) throws EventException;
    
    
	/**
	 * YardExceptionCost를 수정한다<br>
	 * 
	 * @param DmtYdExptCostVO[] dmtYdExptCostVOs   
	 * @exception EventException
	 */
	public void modifyYardExceptionCost(DmtYdExptCostVO[] dmtYdExptCostVOs ) throws EventException;
    
	/**
	 * YardExceptionCost를 Confirm한다<br>
	 * 
	 * @param DmtYdExptCostVO[] dmtYdExptCostVOs
	 * @param String cfmCancel   
	 * @exception EventException
	 */
	public void confirmYardExceptionCost(DmtYdExptCostVO[] dmtYdExptCostVOs, String cfmCancel  ) throws EventException;
    
    /**
     * [YardExceptionCost]을 [dup check] 합니다.<br>
     * 
     * @param String ydCd
     * @param String effDt
     * @param String expDt
     * @return String
     * @exception EventException
     */   
    public String checkCostDup(String ydCd, String effDt, String expDt ) throws EventException;
   
}