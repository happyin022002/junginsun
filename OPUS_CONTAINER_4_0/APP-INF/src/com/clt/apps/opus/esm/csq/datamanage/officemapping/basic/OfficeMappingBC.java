/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : OfficeMappingBC.java
*@FileTitle      : OfficeMapping
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.03 CSQ USER
* 1.0 Creation
* 2013.12.10 PEJ   [CHM-201328059] QTA Edit_Office Add 팝업 추가(modifyLaneOfficeRelation)
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.basic;

import java.util.List;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchAddSectorOfcRelSetVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchLaneOfficeRelationListVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchLaneOfficeRelationNewLaneAddListVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchSectorOfcRelationSetListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqQtaLaneOfcVO;
import com.clt.syscommon.common.table.CsqQtaOfcVO;
import com.clt.syscommon.common.table.CsqSctrLaneOfcVO;

/**
 * ALPS-OfficeMapping Business Logic Command Interface<br>
 * - ALPS-OfficeMapping 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
 * @see
 * @since J2EE 1.6
 */

public interface OfficeMappingBC {
	
	/**
	 * RHQ별 산하의 판매목표 수립 대상인 모든 Office를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<CsqQtaOfcVO>
	 * @throws EventException
	 */
	public List<CsqQtaOfcVO> searchRhqOfcMappingList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneOfficeRelationListVO>
	 * @exception EventException
	 */
	public List<SearchLaneOfficeRelationListVO> searchLaneOfficeRelationList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLaneOfficeRelationListCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [저장] 합니다.<br>
	 * 
	 * @param CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLaneOfficeRelation(CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_CSQ_0056 : [Creation](adjustment-QTA Edit - IAS Office Add- Creation)<br>
	 * [Lane Office Relation Setting] Office의 상태를 변경한다.<br>
	 * 
	 * @param CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void modifyLaneOfficeRelation(CsqQtaLaneOfcVO[] csqQtaLaneOfcVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createLaneOfficeRelation(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0007 : [이벤트]<br>
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
	 * @param CsqQtaOfcVO[] csqQtaOfcVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRhqOfcMapping(CsqQtaOfcVO[] csqQtaOfcVOS, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0204 : Retrieve<br>
	 * [Sector Office Relation Setting List]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SearchSectorOfcRelationSetListVO>
	 * @throws EventException
	 */
	public List<SearchSectorOfcRelationSetListVO> searchSectorOfcRelationSetList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0204 : Retrieve<br>
	 * [Sector Office Relation Setting List]을 [Data Count]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSectorOfcRelationSetListCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0204 : Retrieve<br>
	 * [Sector Office Relation Setting Tab2]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SearchSectorOfcRelationSetListVO>
	 * @throws EventException
	 */
	public List<SearchSectorOfcRelationSetListVO> searchSectorOfcRelationSetListT2(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0204 : Creation<br>
	 * [Sector Office Relation Setting List]을 [생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createSectorOfcRelationSet(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * ESM_CSQ_0204 : Creation<br>
	 * [Sector Office Relation Setting_Act_flag가 하나도 없는 Lane List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchSectorOfcRelationSetNActList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0204 : SAVE<br>
	 * [Sector Office Relation Setting List]을 [수정]합니다.<br>
	 * 
	 * @param CsqSctrLaneOfcVO[] csqSctrLaneOfcVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageSectorOfcRelationSet(CsqSctrLaneOfcVO[] csqSctrLaneOfcVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0205 : Retrieve<br>
	 * [Sector Office Relation Set_Add Creation List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddSectorOfcRelSetVO>
	 * @throws EventException
	 */
	public List<SearchAddSectorOfcRelSetVO> searchAddSectorOfcRelSetPfGrp(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0205 : Retrieve<br>
	 * [Sector Office Relation Set_Add Creation List의 Act Cnt]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAddSectorOfcRelSetPfGrpActCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0205 : CREATION<br>
	 * [Sector Office Relation Set_Add Creation List]을 [생성]합니다.<br>
	 * 
	 * @param SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createAddSectorOfcRelSetPfGrp(SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0206 : Retrieve<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddSectorOfcRelSetVO>
	 * @throws EventException
	 */
	public List<SearchAddSectorOfcRelSetVO> searchAddSectorOfcRelSetPolPod(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * 
	 * @param SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createAddSectorOfcRelSetPolPod(SearchAddSectorOfcRelSetVO[] searchAddSectorOfcRelSetVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
}