/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : TargetGroupBC.java
*@FileTitle      : TargetGroup
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.basic;

import java.util.List;

import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchCostManagement0170ListVO;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchTargetGroup0014ListVO;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchTargetGroupTrade0013ListVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ModelConditionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqCostApplBseVO;
import com.clt.syscommon.common.table.SaqTgtGrpTrdVO;
import com.clt.syscommon.common.table.SaqTgtGrpVO;


/**
 * Basicdatamanage Business Logic Command Interface<br>
 * - Basicdatamanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jong-Ho Kim
 * @see Esm_saq_0014EventResponse 참조
 * @since J2EE 1.6
 */

public interface TargetGroupBC {

	/**
	 * [Traget Group Control]을 [조회] 합니다.<br>
	 * 
	 * 
	 * @return List<SearchTargetGroup0014ListVO>
	 * @exception EventException
	 */
	public List<SearchTargetGroup0014ListVO> searchTargetGroup0014List() throws EventException;
	
	/**
	 * [Traget Group Control]을 [멀티] 합니다.<br>
	 * 
	 * @param saqTgtGrpVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiTargetGroup0014(SaqTgtGrpVO[] saqTgtGrpVO,SignOnUserAccount account) throws EventException;

	/**
	 * [Sales Quota Scope]을 [조회] 합니다.<br>
	 * 
	 * @param modelConditionVO
	 * @return List<SearchTargetGroupTrade0013ListVO>
	 * @exception EventException
	 */
	public List<SearchTargetGroupTrade0013ListVO> searchTargetGroupTrade0013List(ModelConditionVO modelConditionVO) throws EventException;
	
	/**
	 * [Sales Quota Scope]을 [멀티] 합니다.<br>
	 * 
	 * @param saqTgtGrpTrdVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiTargetGroupTrade0013(SaqTgtGrpTrdVO[] saqTgtGrpTrdVO,SignOnUserAccount account) throws EventException;

	/**
	 * [Year/Month Set for Cost Management ]을 [조회] 합니다.<br>
	 * 
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @return List<SearchCostManagement0170ListVO>
	 * @exception EventException
	 */
	public List<SearchCostManagement0170ListVO> searchCostManagement0170List(String bse_yr, String bse_qtr_cd) throws EventException;
	
	/**
	 * [Year/Month Set for Cost Management ]을 [멀티1] 합니다.<br>
	 * 
	 * @param saqCostApplBseVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostManagementSave0170(SaqCostApplBseVO[] saqCostApplBseVO, SignOnUserAccount account) throws EventException;

	/**
	 * [Year/Month Set for Cost Management ]을 [멀티2] 합니다.<br>
	 * 
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostManagementCopy0170(String bse_yr, String bse_qtr_cd, SignOnUserAccount account) throws EventException;

	/**
	 * [Year/Month Set for Cost Management] Create Initial Data 버튼 활성화 유무에 대한 처리를 위해 해당 테이블에 데이터 존재 유무를 체크. <br>
	 * 
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchCostManagementExistCheck0170(String bse_yr ,String bse_qtr_cd) throws EventException;
}