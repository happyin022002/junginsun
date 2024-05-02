/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageBC.java
*@FileTitle : 컨테이너 이송 계획 목록 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		sangyool pak					2006-06-29		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun				2009.08.14		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.14
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0045ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0051ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053MultiVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0054ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0129ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.GetRepoPlanListVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrOnHireApprovalVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanLaneVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanVVDVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchTSGuidelineVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrAddPlnVO;

/**
 * ALPS-CntrRepoPlanManage Business Logic Command Interface<br>
 * - ALPS-CntrRepoPlanManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see Ees_eqr_0045EventResponse 참조
 * @since J2EE 1.6
 */

public interface CntrRepoPlanManageBC {

	/**
	 * 컨테이너 이송 계획 목록 조회 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0045ConditionVO
	 * @return List<GetRepoPlanListVO>
	 * @exception EventException
	 */
	public List<GetRepoPlanListVO> searchRepoPlanList(EesEqr0045ConditionVO conditionVO) throws EventException;
	
	/**
	 * 컨테이너 이송 계획 목록 조회 Copy 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0045ConditionVO
	 * @param usrId		String
	 * @exception EventException
	 */
	public void createNewRepoPlanID(EesEqr0045ConditionVO conditionVO, String usrId) throws EventException;
	
	/**
	 * 컨테이너 이송 계획 목록 조회 Delete 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0045ConditionVO
	 * @exception EventException
	 */
	public void removeRepoPlanID(EesEqr0045ConditionVO conditionVO) throws EventException;
	
	/**
	 * 컨테이너 이송계획 관리 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0051ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchForecastedLandInventory(EesEqr0051ConditionVO conditionVO) throws EventException;
	
	/**
	 * 컨테이너 이송계획 관리 저장 이벤트 처리<br>
	 * 
	 * @param eqrAddPlnVOS EqrAddPlnVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyForecastedLandInventory(EqrAddPlnVO[] eqrAddPlnVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * 컨테이너 이송계획 관리 Distribution 가능여부 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0051ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDtrbForecastedLandInventory(EesEqr0051ConditionVO conditionVO) throws EventException;
	
	/**
	 * 컨테이너 이송계획 관리 Distribution 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0051ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void dtrbForecastedLandInventory(EesEqr0051ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 최적화된 REPO InOut 계획 수량 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0052ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoInOutPlanDtInfo(EesEqr0052ConditionVO conditionVO) throws EventException;
	
	/**
	 * 최적화된 REPO InOut 계획 수량 VVD 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0052ConditionVO
	 * @return List<SearchCntrRepoInOutPlanLaneVO>
	 * @exception EventException
	 */
	public List<SearchCntrRepoInOutPlanLaneVO> searchCntrRepoInOutPlanLaneInfo(EesEqr0052ConditionVO conditionVO) throws EventException;
	
	/**
	 * 최적화된 REPO InOut 계획 수량 LOC 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0052ConditionVO
	 * @return List<SearchCntrRepoInOutPlanVVDVO>
	 * @exception EventException
	 */
	public List<SearchCntrRepoInOutPlanVVDVO> searchCntrRepoInOutPlanVvdInfo(EesEqr0052ConditionVO conditionVO) throws EventException;
	
	/**
	 * 최적화된 REPO InOut 계획 수량 수정 이벤트 처리<br>
	 * 
	 * @param eesEqr0052MultiVOS EesEqr0052MultiVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyCntrRepoInOutPlanDtInfo(EesEqr0052MultiVO[] eesEqr0052MultiVOS, String usrId) throws EventException;
	
	/**
	 * TS Guideline PopUp 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0129ConditionVO
	 * @return List<SearchTSGuidelineVO>
	 * @exception EventException
	 */
	public List<SearchTSGuidelineVO> searchTSGuideline(EesEqr0129ConditionVO conditionVO) throws EventException;
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도(On-Hire) Sheet1 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0053ConditionVO
	 * @return
	 * @exception EventException
	 */
	public CommonRsVO searchCntrOnHireRepoPlanDtInfo(EesEqr0053ConditionVO conditionVO) throws EventException;
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도(On-Hire) Sheet2 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0053ConditionVO
	 * @return List<SearchCntrOnHireApprovalVO>
	 * @exception EventException
	 */
	public List<SearchCntrOnHireApprovalVO> searchOnHireApproval(EesEqr0053ConditionVO conditionVO) throws EventException;
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도(On-Hire) 수정 이벤트 처리<br>
	 * 
	 * @param eesEqr0053MultiVOS EesEqr0053MultiVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyCntrOnHireRepoPlanDtInfo(EesEqr0053MultiVO[] eesEqr0053MultiVOS, String usrId) throws EventException;
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도(Off-Hire) 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0054ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrOffHireRepoPlanDtInfo(EesEqr0054ConditionVO conditionVO) throws EventException;
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도(Off-Hire) 수정 이벤트 처리<br>
	 * 
	 * @param eesEqr0053MultiVOS EesEqr0053MultiVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyCntrOffHireRepoPlanDtInfo(EesEqr0053MultiVO[] eesEqr0053MultiVOS, String usrId) throws EventException;
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도 조회(RLA List) 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0048ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchRLARepoPlanDtList(EesEqr0048ConditionVO conditionVO) throws EventException;
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도 조회(RLA List) 수정 이벤트 처리<br>
	 * 
	 * @param eesEqr0048MultiVOS EesEqr0048MultiVO[]
	 * @param conditionVO EesEqr0048ConditionVO
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyRLARepoPlanDtList(EesEqr0048MultiVO[] eesEqr0048MultiVOS, EesEqr0048ConditionVO conditionVO, String usrId) throws EventException;
	
}