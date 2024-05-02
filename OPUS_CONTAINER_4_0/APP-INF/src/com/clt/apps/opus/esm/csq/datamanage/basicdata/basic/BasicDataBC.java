/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : BasicDataBC.java
*@FileTitle      : BasicData
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.03 CSQ USER
* 1.0 Creation
* History
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.basic;

import java.util.List;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchBasicDataCreationForSecterListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchAddPolPodPairForSectorVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchBasicDataCreationListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchBasicDataRelationListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchLaneDirectionChangeListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchPfSkdGrpForSectorListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchPolPodPairSectorListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchTargerVvdFixListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqDatRltVO;
import com.clt.syscommon.common.table.CsqDirConvVO;
import com.clt.syscommon.common.table.CsqQtaLaneMgmtVO;
import com.clt.syscommon.common.table.CsqQtaTgtVvdVO;
import com.clt.syscommon.common.table.CsqSctrPairMgmtVO;

/**
 * ALPS-BasicData Business Logic Command Interface<br>
 * - ALPS-BasicData 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
 * @see
 * @since J2EE 1.6
 */
public interface BasicDataBC {
	
	/**
	 * ESM_CSQ_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataRelationVO>
	 * @exception EventException
	 */
	public List<SearchBasicDataRelationListVO> searchBasicDataRelationList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [저장] 합니다.<br>
	 * 
	 * @param CsqDatRltVO[] csqDatRltVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBasicDataRelation(CsqDatRltVO[] csqDatRltVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyBasicDataRelation(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0001 : [이벤트]<br>
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
	 * @param CsqDirConvVO[] csqDirConvVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageLaneDirectionChange(CsqDirConvVO[] csqDirConvVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
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
	 * ESM_CSQ_0008 : [이벤트]<br>
	 * [Basic Data Creation]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataCreationListVO>
	 * @exception EventException
	 */
	public List<SearchBasicDataCreationListVO> searchBasicDataCreationList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0010 : [이벤트]<br>
	 * [Target VVD Fix]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTargerVvdFixListVO>
	 * @exception EventException
	 */
	public List<SearchTargerVvdFixListVO> searchTargerVvdFixList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0010 : [이벤트]<br>
	 * [Target VVD Fix]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String flg
	 * @param String usrId
	 * @exception EventException
	 */
	public void createTargerVvdFix(ConditionVO conditionVO, String usrId) throws EventException;
	
	/**
	 * ESM_CSQ_0011 : [이벤트]<br>
	 * [Lane List]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTargerVvdFixListVO>
	 * @exception EventException
	 */
	public List<SearchTargerVvdFixListVO> searchLaneList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0010 : [이벤트]<br>
	 * [Target VVD Fix]을 [저장] 합니다.<br>
	 * @param CsqQtaTgtVvdVO[] csqQtaTgtVvdVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTargerVvdFix(CsqQtaTgtVvdVO[] csqQtaTgtVvdVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0010 : [이벤트]<br>
	 * [Target VVD]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchTargerVvdFixListCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0009 : [이벤트]<br>
	 * [Basic Data Creation]의 [Creation batch 수행] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createCsqPerfIf(ConditionVO conditionVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * ESM_CSQ_0008 : [이벤트]<br>
	 * [Basic Data Creation]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicDataCreationListCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0002 : [이벤트]<br>
	 * [Lane Master]을 [조회] 합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<CsqQtaLaneMgmtVO>
	 * @throws EventException
	 */
	public List<CsqQtaLaneMgmtVO> searchLaneMasterList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0002 : [이벤트]<br>
	 * [Lane Master]을 [저장,삭제] 합니다.<br>
	 * @param CsqQtaLaneMgmtVO[] csqQtaLaneMgmtVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageLaneMaster(CsqQtaLaneMgmtVO[] csqQtaLaneMgmtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0010 : [이벤트]<br>
	 * [Target VVD Fix]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTargerVvdFixListVO>
	 * @exception EventException
	 */
	public List<SearchTargerVvdFixListVO> searchTargerVvdFixForCreation(ConditionVO conditionVO) throws EventException;
	
	
	/**
	 * ESM_CSQ_0010 : [이벤트]<br>
	 * [Target VVD]의 접속 ofc를 확인 합니다.<br>
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchCreationUser(String ofcCd) throws EventException;
	/**
	 * ESM_CSQ_0201 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SearchPfSkdGrpForSectorListVO>
	 * @throws EventException
	 */
	public List<SearchPfSkdGrpForSectorListVO> searchPfSkdGrpForSectorList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0201 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [Data Count]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPfSkdGrpForSectorListCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0201 : Creation<br>
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
	 * ESM_CSQ_0201 : Add-Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [추가생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @exception EventException
	 */
	public void createAddPfSkdGrpForSector(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * ESM_CSQ_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @throws EventException
	 */
	public List<SearchPolPodPairSectorListVO> searchPolPodPairSectorList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List]을 [Data Count]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPolPodPairSectorListCnt(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0202 : Retrieve<br>
	 * [POL POD Pair for IAS Sector List Tab2]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @throws EventException
	 */
	public List<SearchPolPodPairSectorListVO> searchPolPodPairSectorListT2(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0202 : Creation 또는 Retrieve 후<br>
	 * [POL POD Pair for IAS Sector List 중 Main Flag가 하나도 없는 Lane, Bound]을 [조회]합니다.<br>
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchPolPodPairNMainFlgList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0202 : Creation<br>
	 * [POL POD Pair for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createPolPodPairForSector(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * ESM_CSQ_0202 : SAVE<br>
	 * [POL POD Pair for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param CsqSctrPairMgmtVO[] csqSctrPairMgmtVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePolPodPairForSector(CsqSctrPairMgmtVO[] csqSctrPairMgmtVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0203 : Retrieve<br>
	 * [POL POD Pair for IAS Sector Add List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @throws EventException
	 */
	public List<SearchAddPolPodPairForSectorVO> searchAddPolPodPairForSector(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0203 : CREATION<br>
	 * [POL POD Pair for IAS Sector Add List]을 [생성]합니다.<br>
	 * 
	 * @param SearchAddPolPodPairForSectorVO[] searchAddPolPodPairForSectorVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createAddPolPodPairForSector(SearchAddPolPodPairForSectorVO[] searchAddPolPodPairForSectorVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0207 : [Retrieve]<br>
	 * [Basic Data Creation for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataCreationForSecterListVO>
	 * @exception EventException
	 */
	public List<SearchBasicDataCreationForSecterListVO> searchBasicDataCreationForSecterList(ConditionVO conditionVO) throws EventException ;

	/**
	 * ESM_CSQ_0207 : [Retrieve]<br>
	 * [Basic Data Creation for IAS Sector]의 [COUNT] 를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String  searchBasicDataCreationForSecterListCnt(ConditionVO conditionVO) throws EventException ;

	/**
	 * ESM_CSQ_0208 : [Creation]<br>
	 *  [Basic Data Creation for IAS Sector]의 [Creation batch 수행] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createBasicDataCreationForSecter(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0002 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [복사] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyLaneMaster(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

}