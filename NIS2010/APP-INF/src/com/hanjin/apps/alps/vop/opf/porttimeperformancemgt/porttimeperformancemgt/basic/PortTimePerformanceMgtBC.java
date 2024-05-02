/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerformanceMgtBC.java
*@FileTitle : Port Time Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
* 2012.01.16 김민아 [CHM-201215697-01] Port Time Reduction관리 시스템 개발(1차)
* 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
* 2012.05.03 조경완 [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건 
* 2012.07.11 문동선 [CHM-201218855-01] Base line 입력화면 추가 / Dashboard에 반영
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfCommonVariableVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.GraphPerformanceListVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.GraphYtdListVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PerformanceSummaryVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortDoubleCallVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeActivityReportVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeActivityVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeKPIDetailVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimePerformanceConditionVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeVVDRemarkVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Porttimeperformancemgt Business Logic Command Interface<br>
 * - NIS2010-Porttimeperformancemgt 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see 
 * @since J2EE 1.6
 */

public interface PortTimePerformanceMgtBC {

	/**
	 * Port Time Performance Summary를 조회합니다.<br>
	 * 
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<PerformanceSummaryVO>
	 * @exception EventException
	 */
	public List<PerformanceSummaryVO> searchPortTimePerformanceSummaryList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws EventException;
	
	/**
	 * 해당 KPI에 속해 있는 최종 년도와 Version 정보를 표시한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchKPILastYearVersion(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException;
	
	/**
	 * KPI Version 정보를 조회합니다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchKPIYearVersionList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException;
	
	/**
	 * KPI Lane 정보를 조회합니다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchKPISvcLaneCodeList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException;
	
	/**
	 * KPI RHQ 정보를 조회합니다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchKPIRHQCodeList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException;
	
	/**
	 * KPI Port 정보를 조회합니다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchKPIPortCodeList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException;
	
	/**
	 * 해당 KPI 정보를 조회한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchPortTimeKPIList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException;
	
	/**
	 * 해당 KPI 정보를 생성한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO[] portTimeKPIDetailVOs
	 * @param SignOnUserAccount account
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> addPortTimeKPIVersionList(PortTimeKPIDetailVO[] portTimeKPIDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 해당 KPI 정보를 삭제한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @exception EventException
	 */
	public void removePortTimeKPIList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException;

	/**
	 * 해당 KPI 정보를 변경한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO[] portTimeKPIDetailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPortTimeKPIList(PortTimeKPIDetailVO[] portTimeKPIDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Operation Stoppage Code 정보를 조회한다.<br>
	 * 
	 * @return List<OpfCommonVariableVO>
	 * @exception EventException
	 */
	public List<OpfCommonVariableVO> searchOprStopCodeList() throws EventException;
	
	/**
	 * Port Time Activity 탭페이지의 Grid에 표시할 정보를 조회 한다.<br>
	 * 
	 * @return List<PortTimeActivityVO>
	 * @exception EventException
	 */
	public List<PortTimeActivityVO> searchAcitivityByPortTimeList() throws EventException;
	
	/**
	 * VVD Port별 Activity Time 정보을 조회한다.<br>
	 * 
	 * @param PortTimeActivityVO portTimeActivityVO
	 * @return List<PortTimeActivityVO>
	 * @exception EventException
	 */
	public List<PortTimeActivityVO> searchPortTimeAcitvityList(PortTimeActivityVO portTimeActivityVO) throws EventException;
	
	/**
	 * VVD Port별 Activity Time 정보을 생성 및 변경한다.<br>
	 * 
	 * @param PortTimeActivityVO[] portTimeActivityVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortTimeAcitvityList(PortTimeActivityVO[] portTimeActivityVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VVD별 Port Time Activity의 입력 현황 정보를 조회 한다.<br>
	 * 
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<PortTimeActivityReportVO>
	 * @exception EventException
	 */
	public List<PortTimeActivityReportVO> searchVVDPortTimeActivitySummaryList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws EventException;
	
	/**
	 * VVD별 Port/D.Call 정보를 조회 한다.<br>
	 * 
	 * @param OpfUtilSearchOptVO opfUtilSearchOptVO
	 * @return List<PortDoubleCallVO>
	 * @exception EventException
	 */
	public List<PortDoubleCallVO> searchPortDoubleCallList(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException;

	/**
	 * VVD별 Dashboard Chart Report - Performance Data<br>
	 * 
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<GraphPerformanceListVO>
	 * @exception EventException
	 */
	public List<GraphPerformanceListVO> searchGraphPerformanceList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws EventException;

	/**
	 * VVD별 Dashboard Chart Report - Ytd Data<br>
	 * 
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<GraphYtdListVO>
	 * @exception EventException
	 */
	public List<GraphYtdListVO> searchGraphYtdList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws EventException;

	/**
	 * VVD Remark 정보를 조회 한다.<br>
	 * 
	 * @param PortTimeVVDRemarkVO[] portTimeVVDRemarkVO
	 * @return List<PortTimeVVDRemarkVO>
	 * @exception EventException
	 */
	public List<PortTimeVVDRemarkVO> searchPortTimeVVDRemarkList(PortTimeVVDRemarkVO[] portTimeVVDRemarkVO) throws EventException;

	/**
	 * VVD Remark 정보를 저장 한다.<br>
	 * 
	 * @param PortTimeVVDRemarkVO[] portTimeVVDRemarkVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortTimeVVDRemarkList(PortTimeVVDRemarkVO[] portTimeVVDRemarkVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VVD별 Dashboard Chart Report - Baseline Data<br>
	 * 
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<GraphPerformanceListVO>
	 * @exception EventException
	 */
	public List<GraphPerformanceListVO> searchGraphBaselineList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws EventException;
	
	/**
	 * Exp 정보를 저장 한다.<br>
	 * 
	 * @param PerformanceSummaryVO[] performanceSummaryVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPortTimePerformanceVVDExceptList(PerformanceSummaryVO[] performanceSummaryVO, SignOnUserAccount account) throws EventException;	

}