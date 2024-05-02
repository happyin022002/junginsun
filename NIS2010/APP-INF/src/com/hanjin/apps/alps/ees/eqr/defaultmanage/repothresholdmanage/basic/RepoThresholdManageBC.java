/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoThresholdManageBC.java
*@FileTitle : RepoThresholdManageBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-20
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-07-20 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.vo.SearchRepoPlanRLAThresholdVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.vo.RepoThresholdManageRsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrInpDatRedLgtAltVO;
import com.hanjin.syscommon.common.table.EqrObFcastRedLgtAltVO;
import com.hanjin.syscommon.common.table.EqrRepoExePlnFbExptVO;
import com.hanjin.syscommon.common.table.EqrRepoExePlnFbVO;
import com.hanjin.syscommon.common.table.EqrRepoPlnRedLgtAltDtlVO;
import com.hanjin.syscommon.common.table.EqrRepoPlnRedLgtAltMstVO;

/**
 * ALPS-RepoThresholdManage Business Logic Command Interface<br>
 * - ALPS-RepoThresholdManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author chung eun ho
 * @see 참조
 * @since J2EE 1.6
 */
public interface RepoThresholdManageBC  { 

	/**
	 * @return RepoThresholdManageRsVO
	 * @exception EventException
	 */
	public RepoThresholdManageRsVO searchCntrRepoPlanInputDataRLAThreshold() throws EventException;
	/**
	 * @param vos EqrInpDatRedLgtAltVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */	
	public void multiCntrRepoPlanInputDataRLAThreshold(EqrInpDatRedLgtAltVO[] vos , SignOnUserAccount account) throws EventException;
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 이송 계획 조회 이벤트 처리<br>
	 * 
	 * @return List<SearchRepoPlanRLAThresholdVO>
	 * @exception EventException
	 */
	public List<SearchRepoPlanRLAThresholdVO> searchCntrRepoPlanRLAThreshold() throws EventException;
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 이송 계획 조회 이벤트 처리<br>
	 * 
	 * @param rccCd String
	 * @param tpsz String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoPlanRLADTLThreshold(String rccCd, String tpsz) throws EventException;
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 이송 계획 멀티 이벤트 처리<br>
	 * 
	 * @param eqrRepoPlnRedLgtAltMstVOs EqrRepoPlnRedLgtAltMstVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrRepoPlanRLAThreshold(EqrRepoPlnRedLgtAltMstVO[] eqrRepoPlnRedLgtAltMstVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 이송 계획 멀티 이벤트 처리<br>
	 * 
	 * @param eqrRepoPlnRedLgtAltDtlVOs EqrRepoPlnRedLgtAltMstVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrRepoPlanRLADTLThreshold(EqrRepoPlnRedLgtAltDtlVO[] eqrRepoPlnRedLgtAltDtlVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * 실행 계획 Feedback 기준 설정 조회 이벤트 처리<br>
	 * 
	 * @param tpsz String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchExecutionFeedback(String tpsz) throws EventException;
	
	/**
	 * 실행 계획 Feedback 기준 설정 멀티 이벤트 처리<br>
	 * 
	 * @param eqrRepoExePlnFbVOs EqrRepoExePlnFbVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiExecutionFeedback(EqrRepoExePlnFbVO[] eqrRepoExePlnFbVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * 실행 계획 Feedback 기준 설정 멀티 이벤트 처리<br>
	 * 
	 * @param eqrRepoExePlnFbExptVOs EqrRepoExePlnFbExptVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiExecutionFeedbackExpt(EqrRepoExePlnFbExptVO[] eqrRepoExePlnFbExptVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 수급 예측 조회 이벤트 처리<br>
	 * 
	 * @param tpsz String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrForecastRLAThreshold(String tpsz) throws EventException;
	
	/**
	 * Red Light Alert 기준 조회/수정---컨테이너 수급 예측 수정 이벤트 처리<br>
	 * 
	 * @param eqrObFcastRedLgtAltVOs EqrObFcastRedLgtAltVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrForecastRLAThreshold(EqrObFcastRedLgtAltVO[] eqrObFcastRedLgtAltVOs,SignOnUserAccount account) throws EventException;
	
}