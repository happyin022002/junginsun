/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : AdjustmentBC.java
*@FileTitle      : Adjustment
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.16
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.16 이혜민
* 1.0 Creation
* 2014.09.17 이혜민 [CHM-201431755-01] New Lane Add시 Bound 삽입
* 2014.12.12 이혜민 [CHM-201432763] RF SPCL TPSZ Master 화면 신규 생성
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze)
* 2015.11.24 김용습 [CHM-201538493] [CSR 전환건] Current KPI Report 화면 보완 (조회 조건 Week → Month 변경, Raw Data Export 버튼 추가)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaAdjustmentVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchCurrentKpiReportVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchKpiCreationEditNewOfcHisVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchKpiCreationEditVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchQtaAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchReeferSpclTpSzMgmtVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmSpclCfmQtaVO;
import com.hanjin.syscommon.common.table.SqmSpclNewLaneVO;
import com.hanjin.syscommon.common.table.SqmSpclNewOfcVO;

/**
 * ALPS-Adjustment Business Logic Command Interface<br>
 * - ALPS-Adjustment 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 이혜민
 * @see
 * @since J2EE 1.6
 */
public interface AdjustmentBC {
	
	/**
	 * ESM_SQM_0504 : [SEARCH]<br>
	 * [KPI Creation & Edit]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchKpiCreationEditVO>
	 * @exception EventException
	 */
	public List<SearchKpiCreationEditVO> searchKpiCreationEdit(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0504 : [SEARCH]<br>
	 * [KPI Creation & Edit]을 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchKpiCreationEditCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0504 : [SEARCH01]<br>
	 * [KPI Creation & Edit]화면에서 Creation 후 또는 이미 Yearly 데이터가 있을 경우 1Q 데이터가 있는지 없는지 [확인]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String search1QTransferDataCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0504 : [MULTI]<br>
	 * [KPI Creation & Edit]을 [저장] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmSpclCfmQtaVO[] sqmSpclCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageKpiCreationEdit(ConditionVO conditionVO, SqmSpclCfmQtaVO[] sqmSpclCfmQtaVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0504 : [MULTI01]<br>
	 * [KPI Creation & Edit]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createKpiCreationEdit(ConditionVO conditionVO, String usrId) throws EventException;
	
	/**
	 * ESM_SQM_0504 : [MULTI02]<br>
	 * [1Q Data]을 [Transfer] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String create1QTransferData(ConditionVO conditionVO, String usrId) throws EventException;
	
	/**
	 * ESM_SQM_0505 : [SEARCH]<br>
	 * [KPI Creation & Edit New Lane Add History]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmSpclNewLaneVO>
	 * @exception EventException
	 */
	public List<SqmSpclNewLaneVO> searchKpiCreationEditNewLaneHis(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0505 : [MULTI]<br>
	 * [KPI Creation & Edit New Lane Add]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createKpiCreationEditNewLane(ConditionVO conditionVO, String usrId) throws EventException;
	
	/**
	 * ESM_SQM_0505 : [SEARCH01]<br>
	 * [KPI Creation & Edit New Lane Add] 팝업 내 New Lane 입력시 Bound를 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchNewLaneAddBound(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0506 : [SEARCH]<br>
	 * [KPI Creation & Edit New Office Add History]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchKpiCreationEditNewOfcHisVO>
	 * @exception EventException
	 */
	public List<SearchKpiCreationEditNewOfcHisVO> searchKpiCreationEditNewOfcHis(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0506 : [MULTI]<br>
	 * [KPI Creation & Edit New Office]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmSpclNewOfcVO[] sqmSpclNewOfcVOS
	 * @param String usrId
	 * @throws EventException
	 */
	public void createKpiCreationEditNewOfc(ConditionVO conditionVO, SqmSpclNewOfcVO[] sqmSpclNewOfcVOS, String usrId) throws EventException;
	
	/**
	 * ESM_SQM_0508 : [SEARCH]<br>
	 * [Current KPI Report]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchCurrentKpiReportVO>
	 * @exception EventException
	 */
	public List<SearchCurrentKpiReportVO> searchCurrentKpiReport(ConditionVO conditionVO, String excelFlg) throws EventException;
	
	/**
	 * ESM_SQM_0508 : [SEARCH02]<br>
	 * [Current KPI Report]을 [조회]합니다. (PreviousVersion)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchCurrentKpiReportVO>
	 * @exception EventException
	 */
	public List<SearchCurrentKpiReportVO> searchCurrentKpiReportPreviousVersion(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0507 : Retrieve 이벤트 처리<br>
	 * [SKD Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> searchQtaAdjustmentList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0507 : MULTI 이벤트 처리<br>
	 * [SKD Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaAdjustment(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0509 : [SEARCH]<br>
	 * [Reefer/Special Type/Size Master]을 [조회]합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchReeferSpclTpSzMgmtVO>
	 * @exception EventException
	 */
	public List<SearchReeferSpclTpSzMgmtVO> searchReeferSpclTpSzMgmt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0509 : [SAVE]<br>
	 * [Reefer/Special Type/Size Master]을 [저장]합니다.
	 * 
	 * @param SearchReeferSpclTpSzMgmtVO[] searchReeferSpclTpSzMgmtVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageReeferSpclTpSzMgmt(SearchReeferSpclTpSzMgmtVO[] searchReeferSpclTpSzMgmtVOS, SignOnUserAccount account) throws EventException;
}