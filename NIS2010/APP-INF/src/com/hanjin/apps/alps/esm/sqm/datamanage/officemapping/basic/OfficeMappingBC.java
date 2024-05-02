/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : OfficeMappingBC.java
*@FileTitle      : OfficeMapping
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2013.12.10 PEJ   [CHM-201328059] QTA Edit_Office Add 팝업 추가(modifyLaneOfficeRelation)
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2015.05.12 김용습 [CHM-201535562] [SQM] Sector-Office Relation Setting for IAS Sector - 타임아웃 방지를 위해 데이터를 반으로 나누어 생성되게 함(createSectorOfcRelationSetForEastBoundData와 createSectorOfcRelationSetForWestBoundData)
* 2015.10.27 김용습 [CHM-201537712] [CSR 전환건] "Sector-Office Relation Setting for IAS Sector 화면 내 Creation"의 로직 변경
* 2015.12.02 김용습 [CHM-201539212] 연간/분기동안 확정 Data에 한번 들어간 Sector Pair는 active 해제할 수 없도록 로직 수정
* 2016.01.13 [CHM-201539389] Lane Office Inactive 불가하도록 비활성화 로직 변경
* 2016.07.04 최성민 [CHM-201642330] SQM 화면 버튼 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchAddSectorOfcRelSetVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchLaneOfficeRelationListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchLaneOfficeRelationNewLaneAddListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchSectorOfcRelationSetListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;
import com.hanjin.syscommon.common.table.SqmQtaOfcVO;
import com.hanjin.syscommon.common.table.SqmSctrLaneOfcVO;

/**
 * ALPS-OfficeMapping Business Logic Command Interface<br>
 * - ALPS-OfficeMapping 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see
 * @since J2EE 1.6
 */

public interface OfficeMappingBC {
	
	/**
	 * RHQ별 산하의 판매목표 수립 대상인 모든 Office를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmQtaOfcVO>
	 * @throws EventException
	 */
	public List<SqmQtaOfcVO> searchRhqOfcMappingList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneOfficeRelationListVO>
	 * @exception EventException
	 */
	public List<SearchLaneOfficeRelationListVO> searchLaneOfficeRelationList(ConditionVO conditionVO) throws EventException;

	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneOfficeRelationListVO>
	 * @exception EventException
	 */
	public List<SearchLaneOfficeRelationListVO> searchLoadingViewCheckList(ConditionVO conditionVO) throws EventException;
	
	
	
	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLaneOfficeRelationListCnt(ConditionVO conditionVO) throws EventException;
	

	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]의 [Freezing 데이터] 가 존재하는지 체크합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchQtaReleaseVersion(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0008<br>
	 * Active cell을 uncheck하려고 할 때 타는 로직(이미 해당 pair로 확정 데이터가 생성된 것이 있으면 uncheck될 수 없도록 함)
	 * 
	 * @param SqmQtaLaneOfcVO sqmQtaLaneOfcVO
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchConfirmedDataOfLaneOffice(SqmQtaLaneOfcVO sqmQtaLaneOfcVO, ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [저장] 합니다.<br>
	 * 
	 * @param SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLaneOfficeRelation(SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_SQM_0045 : [Creation](adjustment-QTA Edit - IAS Office Add- Creation)<br>
	 * [Lane Office Relation Setting] Office의 상태를 변경한다.<br>
	 * 
	 * @param SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void modifyLaneOfficeRelation(SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createLaneOfficeRelation(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0009 : [이벤트]<br>
	 * [RHQ-Office Mapping Data]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneOfficeRelationNewLaneAddListVO>
	 * @exception EventException
	 */
	public List<SearchLaneOfficeRelationNewLaneAddListVO> searchLaneOfficeRelationNewLaneAddList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * RHQ별 산하의 판매목표 수립 대상인 Office 정보를 저장한다.
	 * 
	 * @param SqmQtaOfcVO[] sqmQtaOfcVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRhqOfcMapping(SqmQtaOfcVO[] sqmQtaOfcVOS, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0204 : Retrieve<br>
	 * [Sector Office Relation Setting List]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SearchSectorOfcRelationSetListVO>
	 * @throws EventException
	 */
	public List<SearchSectorOfcRelationSetListVO> searchSectorOfcRelationSetList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0204 : Retrieve<br>
	 * [Sector Office Relation Setting List]을 [Data Count]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSectorOfcRelationSetListCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0204 : Retrieve<br>
	 * [Sector Office Relation Setting Tab2]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SearchSectorOfcRelationSetListVO>
	 * @throws EventException
	 */
	public List<SearchSectorOfcRelationSetListVO> searchSectorOfcRelationSetListT2(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0204<br>
	 * Active cell을 uncheck하려고 할 때 타는 로직(이미 해당 pair로 확정 데이터가 생성된 것이 있으면 uncheck될 수 없도록 함)
	 * 
	 * @param SqmSctrLaneOfcVO sqmSctrLaneOfcVO
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchConfirmedDataOfPair(SqmSctrLaneOfcVO sqmSctrLaneOfcVO, ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0204 : [이벤트]<br>
	 * [Creation batch 수행] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createSectorOfcRelationSet(ConditionVO conditionVO, SignOnUserAccount account) throws EventException ;
	/**
	 * ESM_SQM_0204 : Creation<br>
	 * [Sector Office Relation Setting_Act_flag가 하나도 없는 Lane List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchSectorOfcRelationSetNActList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0204 : SAVE<br>
	 * [Sector Office Relation Setting List]을 [수정]합니다.<br>
	 * 
	 * @param SqmSctrLaneOfcVO[] sqmSctrLaneOfcVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageSectorOfcRelationSet(SqmSctrLaneOfcVO[] sqmSctrLaneOfcVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0205 : Retrieve<br>
	 * [Sector Office Relation Set_Add Creation List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddSectorOfcRelSetVO>
	 * @throws EventException
	 */
	public List<SearchAddSectorOfcRelSetVO> searchAddSectorOfcRelSetPfGrp(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0205 : Retrieve<br>
	 * [Sector Office Relation Set_Add Creation List의 Act Cnt]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAddSectorOfcRelSetPfGrpActCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0205 : CREATION<br>
	 * [Sector Office Relation Set_Add Creation List]을 [생성]합니다.<br>
	 * 
	 * @param SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createAddSectorOfcRelSetPfGrp(SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0206 : Retrieve<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddSectorOfcRelSetVO>
	 * @throws EventException
	 */
	public List<SearchAddSectorOfcRelSetVO> searchAddSectorOfcRelSetPolPod(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * 
	 * @param SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createAddSectorOfcRelSetPolPod(SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
}