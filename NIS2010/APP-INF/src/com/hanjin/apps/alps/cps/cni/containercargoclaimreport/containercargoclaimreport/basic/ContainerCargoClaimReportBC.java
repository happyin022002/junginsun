/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ContainerCargoClaimReportBC.java
 *@FileTitle : Container Cargo Claim Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.11.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.basic;

import java.util.List;

import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoClaimReportVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoLitigationReportVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByAreaVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByCargoVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByHofcVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.SettlementAnalysisCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.SettlementAnalysisVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.StatusCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.StatusVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.TotalOccurrenceByClaimantVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.TotalOccurrenceByVvdVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * Container Cargo Claim Command Interface<br>
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public interface ContainerCargoClaimReportBC {
    
	
    // ===========================================================================
    // 진윤오
    // ===========================================================================

	
    // ===========================================================================
    // 양정란
    // ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0020] Report-Settlement Analysis
	// ---------------------------------------------------------------------------  
	/**
	 * Report-Settlement Analysis 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0020
	 * @category searchSettlementAnalysisList 
	 * @param SettlementAnalysisCondVO settlementAnalysisCondVO
     * @return  List<SettlementAnalysisVO>
     * @throws EventException
     */
	public List<SettlementAnalysisVO> searchSettlementAnalysisList(SettlementAnalysisCondVO settlementAnalysisCondVO) throws EventException;
	/**
	 * Report-Settlement Analysis Print<br>
	 * @author 양정란
	 * @category CPS_CNI_0020
	 * @category printSettlementAnalysisList 
	 * @param SettlementAnalysisCondVO settlementAnalysisCondVO
     * @return  List<SettlementAnalysisVO>
     * @throws EventException
     */
	public List<SettlementAnalysisVO> printSettlementAnalysisList(SettlementAnalysisCondVO settlementAnalysisCondVO) throws EventException;
	// ===========================================================================
    // 정행룡
    // ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_CNI_0018] Status
	// ---------------------------------------------------------------------------
	
	/**
	 * Status 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0018
	 * @category searchStatusList 
	 * @param StatusCondVO statusCondVO
     * @return  List<StatusVO>
     * @throws EventException
     */
	public List<StatusVO> searchStatusList(StatusCondVO statusCondVO) throws EventException;

	/**
	 * Claim Main Report 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0006
	 * @category printCargoClaimReport
	 * @param String cgoClmNo
     * @param String usrId
     * @return CargoClaimReportVO 
     * @throws EventException
     */
	public CargoClaimReportVO printCargoClaimReport(String cgoClmNo, String usrId) throws EventException;
	
	/**
	 * Claim Main Report 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0006
	 * @category printCargoLitigationReport
	 * @param String cgoClmNo
     * @param String usrId
     * @return CargoLitigationReportVO 
     * @throws EventException
     */
	public CargoLitigationReportVO printCargoLitigationReport(String cgoClmNo, String usrId) throws EventException;	
    // ===========================================================================
    // 박제성
    // ===========================================================================
    /**
	 * Occurrence Analysis by Area 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchOccurrenceAnalysisByAreaList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByAreaVO>
     * @throws EventException
     */
	public List<OccurrenceAnalysisByAreaVO> searchOccurrenceAnalysisByAreaList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException;

    /**
	 * Occurrence Analysis by HOFC 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchOccurrenceAnalysisByHofcList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByHofcVO>
     * @throws EventException
     */
	public List<OccurrenceAnalysisByHofcVO> searchOccurrenceAnalysisByHofcList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException;

    /**
	 * Occurrence Analysis by Cargo 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchOccurrenceAnalysisByCargoList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByCargoVO>
     * @throws EventException
     */
	public List<OccurrenceAnalysisByCargoVO> searchOccurrenceAnalysisByCargoList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException;

    /**
	 * Total Occurrence by Area 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByAreaList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByAreaVO>
     * @throws EventException
     */
	public List<OccurrenceAnalysisByAreaVO> searchTotalOccurrenceByAreaList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException;

    /**
	 * Total Occurrence by HOFC 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByHofcList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<OccurrenceAnalysisByHofcVO>
     * @throws EventException
     */
	public List<OccurrenceAnalysisByHofcVO> searchTotalOccurrenceByHofcList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException;

    /**
	 * Total Occurrence by VVD 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByVvdList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<TotalOccurrenceByVvdVO>
     * @throws EventException
     */
	public List<TotalOccurrenceByVvdVO> searchTotalOccurrenceByVvdList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException;

    /**
	 * Total Occurrence by Claimant 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchTotalOccurrenceByClaimantList 
	 * @param OccurrenceAnalysisCondVO occurrenceAnalysisCondVO
     * @return  List<TotalOccurrenceByClaimantVO>
     * @throws EventException
     */
	public List<TotalOccurrenceByClaimantVO> searchTotalOccurrenceByClaimantList(OccurrenceAnalysisCondVO occurrenceAnalysisCondVO) throws EventException;


}