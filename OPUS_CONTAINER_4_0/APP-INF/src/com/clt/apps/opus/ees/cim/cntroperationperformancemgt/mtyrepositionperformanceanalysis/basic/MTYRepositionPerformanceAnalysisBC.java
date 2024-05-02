/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYRepositionPerformanceAnalysisBC.java
*@FileTitle : Repo Result by Port
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.basic;

import java.util.List;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSearchOptionVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultInGeneralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByLocation;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByPortVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS--Cntroperationperformancemgt Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_cim_1033EventResponse reference
 * @since J2EE 1.6
 */

public interface MTYRepositionPerformanceAnalysisBC {
	/**
	 * retrieving REPOResultByPort
	 * 
	 * @param rEPOResultSearchOptionByPortVO
	 * @return List<REPOResultInGeneralVO>
	 * @exception EventException
	 */
	public List<REPOResultInGeneralVO> searchREPOResultByPort(REPOResultSearchOptionByPortVO rEPOResultSearchOptionByPortVO) throws EventException;

	/**
	 * retrieving REPOResultByLocation
	 * 
	 * @param rEPOResultSearchOptionByLocation
	 * @return List<REPOResultInGeneralVO>
	 * @exception EventException
	 */
	public List<REPOResultInGeneralVO> searchREPOResultByLocation(REPOResultSearchOptionByLocation rEPOResultSearchOptionByLocation) throws EventException;

	/**
	 * retrieving MTYCNTRPERFByMovementSMRY Tab
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @return List<MTYCNTRPERFSummaryVO>
	 * @exception EventException
	 
	public List<MTYCNTRPERFSummaryVO> searchMTYCNTRPERFByMovementSMRY(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO) throws EventException;
	*/
	
	/**
	 * retrieving MTYCNTRPERFByMovementSMRY Tab using BACKENDJOB
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String searchMTYCNTRPERFByMovementSMRY(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO,SignOnUserAccount account) throws EventException;

	/**
	 * retrieving MTYCNTRPERFByMovementDTL Tab
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String searchMTYCNTRPERFByMovementDTL(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO,SignOnUserAccount account) throws EventException;

	/**
	 * retrieving MTYCNTRPERFByMovementTrend Tab
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String searchMTYCNTRPERFByMovementTrend(MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO,SignOnUserAccount account) throws EventException;
}