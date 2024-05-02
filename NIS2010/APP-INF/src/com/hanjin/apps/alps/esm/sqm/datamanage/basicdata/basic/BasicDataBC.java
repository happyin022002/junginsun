/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : BasicDataBC.java
*@FileTitle      : BasicData
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* History
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2016.05.11 Sector Office Relation Setting for IAS Sector 화면 및 P/F Skd Group 화면 로직 수정 요청
-P/F Skd Group Management for IAS Sector : Target VVD Fix 에서 대상항차 Fix 할 때부터 P/F Group 도 Planning에서 Freezing 될 때까지는 Add Creation 불가하도록 로직 수정 (Target VVD Fix ~ Planning의 Freezing동안)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchBasicDataCreationForSecterListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchAddPolPodPairForSectorVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchBasicDataCreationListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchBasicDataRelationListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchLaneDirectionChangeListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchPfSkdGrpForSectorListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchPolPodPairSectorListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo.SearchTargerVvdFixListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmDatRltVO;
import com.hanjin.syscommon.common.table.SqmDirConvVO;
import com.hanjin.syscommon.common.table.SqmQtaLaneMgmtVO;
import com.hanjin.syscommon.common.table.SqmQtaTgtVvdVO;
import com.hanjin.syscommon.common.table.SqmSctrPairMgmtVO;

/**
 * ALPS-BasicData Business Logic Command Interface<br>
 * - ALPS-BasicData 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see
 * @since J2EE 1.6
 */
public interface BasicDataBC {
	
	/**
	 * ESM_SQM_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataRelationVO>
	 * @exception EventException
	 */
	public List<SearchBasicDataRelationListVO> searchBasicDataRelationList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [저장] 합니다.<br>
	 * 
	 * @param SqmDatRltVO[] sqmDatRltVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBasicDataRelation(SqmDatRltVO[] sqmDatRltVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyBasicDataRelation(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicDataRelationListCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * Reverse Sailing 노선들의 Direction 을 조회.
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneDirectionChangeListVO>
	 * @throws EventException
	 */
	public List<SearchLaneDirectionChangeListVO> searchLaneDirectionChangeList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * Reverse Sailing 노선들의 Direction 을 변경 또는 삭제
	 * @param SqmDirConvVO[] sqmDirConvVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageLaneDirectionChange(SqmDirConvVO[] sqmDirConvVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 최근 이전 분기의 데이터를 복사
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void copyLaneDirectionChange(ConditionVO conditionVO, String usrId) throws EventException;
	
	/**
	 * Reverse Sailing 노선들의 Direction 조회 리스트를 count
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchLaneDirectionChangeListCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0003 : [이벤트]<br>
	 * [Basic Data Creation]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataCreationListVO>
	 * @exception EventException
	 */
	public List<SearchBasicDataCreationListVO> searchBasicDataCreationList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD Fix]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTargerVvdFixListVO>
	 * @exception EventException
	 */
	public List<SearchTargerVvdFixListVO> searchTargerVvdFixList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD Fix]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String flg
	 * @param String usrId
	 * @exception EventException
	 */
	public void createTargerVvdFix(ConditionVO conditionVO, String flg, String usrId) throws EventException;
	
	/**
	 * ESM_SQM_0006 : [이벤트]<br>
	 * [Lane List]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTargerVvdFixListVO>
	 * @exception EventException
	 */
	public List<SearchTargerVvdFixListVO> searchLaneList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD Fix]을 [저장] 합니다.<br>
	 * @param SqmQtaTgtVvdVO[] sqmQtaTgtVvdVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTargerVvdFix(SqmQtaTgtVvdVO[] sqmQtaTgtVvdVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchTargerVvdFixListCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0004 : [이벤트]<br>
	 * [Basic Data Creation]의 [Creation batch 수행] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createSqmPerfIf(ConditionVO conditionVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * ESM_SQM_0003 : [이벤트]<br>
	 * [Basic Data Creation]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicDataCreationListCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0038 : [이벤트]<br>
	 * [Lane Master]을 [조회] 합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SqmQtaLaneMgmtVO>
	 * @throws EventException
	 */
	public List<SqmQtaLaneMgmtVO> searchLaneMasterList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0038 : [이벤트]<br>
	 * [Lane Master]을 [저장,삭제] 합니다.<br>
	 * @param SqmQtaLaneMgmtVO[] sqmQtaLaneMgmtVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageLaneMaster(SqmQtaLaneMgmtVO[] sqmQtaLaneMgmtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD Fix]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String flg
	 * @return List<SearchTargerVvdFixListVO>
	 * @exception EventException
	 */
	public List<SearchTargerVvdFixListVO> searchTargerVvdFixForCreation(ConditionVO conditionVO, String flg) throws EventException;
	
	
	/**
	 * ESM_SQM_0005 : [이벤트]<br>
	 * [Target VVD]의 접속 ofc를 확인 합니다.<br>
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchCreationUser(String ofcCd) throws EventException;
	/**
	 * ESM_SQM_0201 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SearchPfSkdGrpForSectorListVO>
	 * @throws EventException
	 */
	public List<SearchPfSkdGrpForSectorListVO> searchPfSkdGrpForSectorList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0201 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [Data Count]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPfSkdGrpForSectorListCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0201 : Add Creation<br>
	 * Add Creation시 유효성 검사<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchValidationAddPfSkdGrpForSector(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0201 : Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createPfSkdGrpForSector(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBackEndJobVO(String key) throws EventException;
	/**
	 * ESM_SQM_0201 : Add-Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [추가생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @exception EventException
	 */
	public void createAddPfSkdGrpForSector(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * ESM_SQM_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @throws EventException
	 */
	public List<SearchPolPodPairSectorListVO> searchPolPodPairSectorList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List]을 [Data Count]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPolPodPairSectorListCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List Tab2]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @throws EventException
	 */
	public List<SearchPolPodPairSectorListVO> searchPolPodPairSectorListT2(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0202 : Creation 또는 Retrieve 후<br>
	 * [POL POD Pair for IAS Sector List 중 Main Flag가 하나도 없는 Lane, Bound]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchPolPodPairNMainFlgList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0202 : Creation<br>
	 * [POL POD Pair for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createPolPodPairForSector(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * ESM_SQM_0202 : SAVE<br>
	 * [POL POD Pair for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param SqmSctrPairMgmtVO[] sqmSctrPairMgmtVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePolPodPairForSector(SqmSctrPairMgmtVO[] sqmSctrPairMgmtVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0203 : Retrieve<br>
	 * [POL POD Pair for IAS Sector Add List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @throws EventException
	 */
	public List<SearchAddPolPodPairForSectorVO> searchAddPolPodPairForSector(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0203 : CREATION<br>
	 * [POL POD Pair for IAS Sector Add List]을 [생성]합니다.<br>
	 * 
	 * @param SearchAddPolPodPairForSectorVO[] searchAddPolPodPairForSectorVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createAddPolPodPairForSector(SearchAddPolPodPairForSectorVO[] searchAddPolPodPairForSectorVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0207 : [Retrieve]<br>
	 * [Basic Data Creation for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataCreationForSecterListVO>
	 * @exception EventException
	 */
	public List<SearchBasicDataCreationForSecterListVO> searchBasicDataCreationForSecterList(ConditionVO conditionVO) throws EventException ;

	/**
	 * ESM_SQM_0207 : [Retrieve]<br>
	 * [Basic Data Creation for IAS Sector]의 [COUNT] 를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String  searchBasicDataCreationForSecterListCnt(ConditionVO conditionVO) throws EventException ;

	/**
	 * ESM_SQM_0208 : [Creation]<br>
	 *  [Basic Data Creation for IAS Sector]의 [Creation batch 수행] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createBasicDataCreationForSecter(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
}