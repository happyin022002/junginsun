/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageBC.java
*@FileTitle : Modelship by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.17 진마리아
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.05.06 [CHM-201324211-01] 프로젝트 안정화 및 HELP DESK - SMP Season Creation 배치->backend로 변경
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.03.17 [CHM-20142960] SMP/Allocation control보완 요청
* 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가 
* 2015.07.23 이혜민 [CHM-201536881] SMP 보완 요청 (1.Import 팝업 Acct.add시 계약번호 Valid 및 MVC, C.OFC 가져옴. 2.Amend 팝업 계약번호 중복체크)
* 2015.09.15 이혜민 [CHM-201537538] SMP 오류 수정 건 및 Sub Trade Add 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustCtrlGrpVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustManageVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.ModelPfmcVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SearchModelManageListVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpCustHisVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpHisVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpRptVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SpcBkgCmpbVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SpcHdHulVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcMdlExptWkVO;
import com.hanjin.syscommon.common.table.SpcMdlVerMstVO;

/**
 * ALPS-Modelmanage Business Logic Command Interface<br>
 * - ALPS-Modelmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Maria Chin
 * @see ESM_SPC_0090EventResponse
 * @since J2EE 1.6
 */

public interface ModelManageBC {

	/**
	 * 해당 Season,Version의 Performance(최초) 또는 SMP 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchModelManageListVO>
	 * @exception EventException
	 */
	public List<SearchModelManageListVO> searchModelList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * Season/Version에 등록되어 있는 Modelship Account를 조회합니다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @return List<CustManageVO>
	 * @exception EventException
	 */
	public List<CustManageVO> searchModelshipAcctList(CustManageVO custManageVO) throws EventException;
	
	/**
	 * 선택된 Customer, SC 에 대한 Sub Trade별, 노선별 PFMC를 조회합니다.<br>
	 * 
	 * @param ModelPfmcVO modelPfmcVO
	 * @return List<ModelPfmcVO>
	 * @exception EventException
	 */
	public List<ModelPfmcVO> searchWeeklyAvgPfmc(ModelPfmcVO modelPfmcVO) throws EventException;
	
	/**
	 * Season/Version 미컨펌시 Account 정보를 수정 / 컨펌시 version up 하며 Account 정보를 등록합니다.<br>
	 * 
	 * @param CustManageVO[] custManageVOs
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> manageModelshipAcctList(CustManageVO[] custManageVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Space Management Plan 을 수립합니다.(H/O & RHQ)<br>
	 * 
	 * @param SearchModelManageListVO[] searchModelManageListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSpaceManagementPlan(SearchModelManageListVO[] searchModelManageListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 해당 season 의 실적 기준 - from, to, duration 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSeasonInfo(ConditionVO conditionVO) throws EventException;
	
	/**
	 * 새로운 Space Management Plan 의 Season을 생성합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @param CustCtrlGrpVO[] custCtrlGrpVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createNewSeason(SpcMdlVerMstVO spcMdlVerMstVO, CustCtrlGrpVO[] custCtrlGrpVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Space Management Plan 의 version을 Confirm합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @param List<SpcMdlExptWkVO> spcMdlExptWkVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmVersion(SpcMdlVerMstVO spcMdlVerMstVO,List<SpcMdlExptWkVO> spcMdlExptWkVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 선택된 Customer, SC 에 대한 Sub Trade별, 노선별 BKG pol,pod CMPB를 조회합니다.<br>
	 * 
	 * @param SpcBkgCmpbVO spcBkgCmpbVO
	 * @return List<SpcBkgCmpbVO>
	 * @exception EventException
	 */
	public List<SpcBkgCmpbVO> searchBkgCmpb(SpcBkgCmpbVO spcBkgCmpbVO) throws EventException;
	
	/**
	 * 조건에 맞는 SMP Loading 정보 Lane 관점에서 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SmpRptVO>
	 * @exception EventException
	 */
	public List<SmpRptVO> searchSmpRptByLane(ConditionVO conditionVO) throws EventException;
	
	/**
	 * 조건에 맞는 SMP Loading 정보 Office 관점에서 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SmpRptVO>
	 * @exception EventException
	 */
	public List<SmpRptVO> searchSmpRptByOfc(ConditionVO conditionVO) throws EventException;
	
	/**
	 * 삭제 처리된 office 또는 lane을 재사용하기 위해 살립니다.<br>
	 * 
	 * @param SearchModelManageListVO searchModelManageListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageReviveOfcLane(SearchModelManageListVO searchModelManageListVO, SignOnUserAccount account) throws EventException;

	/**
	 * 노선별 Head Haul Bound 조회한다.<br>
	 *  
	 * @param conditionVO
	 * @return List<SpcHdHulVO>
	 * @throws EventException
	 */
	public List<SpcHdHulVO> searchHdHul(ConditionVO conditionVO) throws EventException;

	/**
	 * 노선별 Head Haul Bound 저장한다.<br>
	 *  
	 * @param SpcHdHulVO[] spcHdHulVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageHdHul(SpcHdHulVO[] spcHdHulVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * SMP History를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SmpHisVO>
	 * @throws EventException
	 */
	public List<SmpHisVO> searchSMPHistory(ConditionVO conditionVO) throws EventException;
	
	/**
	 * SMP Customer History를 조회한다.
	 * 
	 * @param  ConditionVO conditionVO
	 * @return List<SmpCustHisVO>
	 * @throws EventException
	 */
	public List<SmpCustHisVO> searchSMPCustHistory(ConditionVO conditionVO) throws EventException;
	
//	/**
//	 * 입력한 ofc가 삭제되어 있는 상태라면, 본사의 intention인지 아닌지 확인합니다.
//	 * 
//	 * @param SearchModelManageListVO searchModelManageListVO
//	 * @return String
//	 * @exception EventException
//	 */
//	public String checkDelAuth(SearchModelManageListVO searchModelManageListVO) throws EventException;
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBackEndJobVO(String key) throws EventException;

	/**
	 * Trade, 조회주차에 해당하는 Season의 Yield Group 정보를 조회합니다.<br>
	 *  
	 * @param conditionVO
	 * @return List<CustCtrlGrpVO>
	 * @throws EventException
	 */
	public List<CustCtrlGrpVO> searchCustCtrlGrp(ConditionVO conditionVO) throws EventException;
	
	/**
	 * Trade, 조회주차에 해당하는 Season의 Yield Group 정보를 저장합니다.<br>
	 * 
	 * @param CustCtrlGrpVO[] CustCtrlGrpVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustCtrlGrp(CustCtrlGrpVO[] CustCtrlGrpVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Season/Version에 등록되어 있는 Modelship Account 중 유효하지 않은 S/C, RFA 를 조회합니다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @return List<CustManageVO>
	 * @exception EventException
	 */
	public List<CustManageVO> searchModelshipAcctAmendList(CustManageVO custManageVO) throws EventException;
	
	/**
	 * 입력한 S/C, RFA 가 유효 한지 확인합니다.
	 * 
	 * @param CustManageVO custManageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkAmendScRfa(CustManageVO custManageVO) throws EventException;

	/**
	 * S/C, RFA 정보를 Update 한다. <br>
	 *  
	 * @param CustManageVO[] custManageVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageModelshipAcctAmend(CustManageVO[] custManageVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Amend 해야할 S/C, RFA 존재 여부 확인합니다.
	 * 
	 * @param CustManageVO custManageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkSmpAmendList(CustManageVO custManageVO) throws EventException;
	
	/**
	 * ESM_SPC_0092 : SEARCH02<br>
	 * Amend 팝업에서 입력한 SC, RFA#의 중복을 체크합니다. (SPC_MDL_CUST_CTRL 테이블내)
	 * 
	 * @param CustManageVO custManageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkScRfaDup(CustManageVO custManageVO) throws EventException;
	
	/**
	 * Space Management Plan 의 PERF 를 재생성합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageSeasonRegeneration(SpcMdlVerMstVO spcMdlVerMstVO, SignOnUserAccount account) throws EventException;

	/**
	 * SMP 저장을 BackEnd Job으로 변경
	 * 
	 * @param searchModelManageListVOs
	 * @param account
	 * @return
	 */
	public String multSMP(SearchModelManageListVO[] searchModelManageListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SPC_0090 : MULTI05<br>
	 * 실적이 아예 없는 화주를 조회 후 Sub Trade Add 했을 경우 해당 Account 기본 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchModelManageListVO>
	 * @exception EventException
	 */
	public List<SearchModelManageListVO> searchNewAccountInfo(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SPC_0095 : SEARCHLIST01<br>
	 * Acct. Add 후 Account, SC, RFA 입력 시 해당 계약의 유효성 체크 및  MVC, C.OFC 조회해온다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAcctValidEtcData(CustManageVO custManageVO) throws EventException;
	
	
    public String copyNewSeason(SpcMdlVerMstVO spcMdlVerMstVO,  SignOnUserAccount account) throws EventException ;

}