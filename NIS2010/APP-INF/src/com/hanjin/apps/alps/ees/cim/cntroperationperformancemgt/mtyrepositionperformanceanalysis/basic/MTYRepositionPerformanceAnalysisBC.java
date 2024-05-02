/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYRepositionPerformanceAnalysisBC.java
*@FileTitle : Repo Result by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.26 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSearchOptionVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultInGeneralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByLocationVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByPortVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Cntroperationperformancemgt Business Logic Command Interface<br>
 * - ALPS-Cntroperationperformancemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Prak Kwang Seok
 * @see Ees_cim_1033EventResponse 참조
 * @since J2EE 1.6
 */

public interface MTYRepositionPerformanceAnalysisBC {
	/**
	 * REPOResultByPort 을 조회 합니다. <br>
	 * 
	 * @param rEPOResultSearchOptionByPortVO
	 * @return List<REPOResultInGeneralVO>
	 * @exception EventException
	 */
	public List<REPOResultInGeneralVO> searchREPOResultByPort(REPOResultSearchOptionByPortVO rEPOResultSearchOptionByPortVO) throws EventException;

	/**
	 * REPOResultByLocation 을 조회 합니다. <br>
	 * 
	 * @param rEPOResultSearchOptionByLocation
	 * @return List<REPOResultInGeneralVO>
	 * @exception EventException
	 */
	public List<REPOResultInGeneralVO> searchREPOResultByLocation(REPOResultSearchOptionByLocationVO rEPOResultSearchOptionByLocation) throws EventException;

	/**
	 * MTYCNTRPERFByMovementSMRY Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @return List<MTYCNTRPERFSummaryVO>
	 * @exception EventException
	 
	public List<MTYCNTRPERFSummaryVO> searchMTYCNTRPERFByMovementSMRY(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO) throws EventException;
	*/
	
	/**
	 * MTYCNTRPERFByMovementSMRY Tab 을 BACKENDJOB 으로 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String searchMTYCNTRPERFByMovementSMRY(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO,SignOnUserAccount account) throws EventException;

	/**
	 * MTYCNTRPERFByMovementDTL Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String searchMTYCNTRPERFByMovementDTL(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO,SignOnUserAccount account) throws EventException;

	/**
	 * MTYCNTRPERFByMovementTrend Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String searchMTYCNTRPERFByMovementTrend(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO,SignOnUserAccount account) throws EventException;
	/**
	 * MTYCNTRPERFByMovementDailyTrend Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String searchMTYCNTRPERFByMovementDailyTrend(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO,SignOnUserAccount account) throws EventException;
}