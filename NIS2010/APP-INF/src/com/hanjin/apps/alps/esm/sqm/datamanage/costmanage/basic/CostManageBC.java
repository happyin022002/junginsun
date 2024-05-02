/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CostManageBC.java
*@FileTitle      : CostManageBC
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.31 SQM USER
* 1.0 Creation
* 2016.08.11 Basic CMCB (CM Cost Per Box) 화면 Add Creation 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.CommonVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchAddedNewLaneListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbMasPfmcListListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbMasUcPfmcVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchNewLaneOfficeCmcbListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchNewLaneSecCmcbListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;
import com.hanjin.syscommon.common.table.SqmQtaNewLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmQtaNewLaneVO;

/**
 * ALPS-CostManage Business Logic Command Interface<br>
 * - ALPS-CostManage 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see
 * @since J2EE 1.6
 */
public interface CostManageBC {
	
	/**
	 * 추가된 Lane list를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddedNewLaneListVO>
	 * @throws EventException
	 */
	public List<SearchAddedNewLaneListVO> searchAddedNewLaneList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * 추가된 Lane list에 CMCB정보를 카피할 대상 rlane정보를 저장한다.
	 * 
	 * @param SqmQtaNewLaneVO[] sqmQtaNewLaneVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAddedNewLane(SqmQtaNewLaneVO[] sqmQtaNewLaneVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0010 : [이벤트]<br>
	 * [New Lane OFfice CMCB]을 [생성] 합니다.<br>
	 * 
	 * @param SqmQtaNewLaneVO[] sqmQtaNewLaneVOS
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createNewLaneOfficeCmcb(SqmQtaNewLaneVO[] sqmQtaNewLaneVOS, ConditionVO conditionVO,String usrId) throws EventException;
	
	/**
	 * New Lane - Office의 Cmcb를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmQtaNewLaneVO sqmQtaNewLaneVO
	 * @return List<SearchNewLaneOfficeCmcbListVO>
	 * @throws EventException
	 */
	public List<SearchNewLaneOfficeCmcbListVO> searchNewLaneOfficeCmcbList(ConditionVO conditionVO, SqmQtaNewLaneVO sqmQtaNewLaneVO) throws EventException;
	
	/**
	 * New Lane - Office의 Cmcb를 업데이트한다.
	 * 
	 * @param SqmQtaNewLaneOfcCostVO[] VOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageNewLaneOfficeCmcb(SqmQtaNewLaneOfcCostVO[] VOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * 추가된 Office에 대해서 Lane-Office정보와 CMCB를 생성한다.
	 * 
	 * @param SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOS
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createRelatedData(SqmQtaLaneOfcVO[] sqmQtaLaneOfcVOS, ConditionVO conditionVO,String usrId) throws EventException;
	
	/**
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbListVO>
	 * @exception EventException
	 */
	public List<SearchBasicCmcbListVO> searchBasicCmcbList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicCmcbListCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createBasicCmcb(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [수정] 합니다.<br>
	 * 
	 * @param SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBasicCmcb(SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0012 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmQtaLaneOfcCostVO>
	 * @exception EventException
	 */
	public List<SqmQtaLaneOfcCostVO> searchBasicCmcbNewLaneCostIfList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0012 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [생성] 합니다.<br>
	 * 
	 * @param SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBasicCmcbNewLaneCostIf(SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0013 : [이벤트]<br>
	 * [Basic CMCB_MAS UC PFMC Retrieve)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbMasPfmcListListVO>
	 * @exception EventException
	 */
	public List<SearchBasicCmcbMasPfmcListListVO> searchBasicCmcbMasPfmcList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0209 : Retrieve1<br>
	 * [New Lane Sector CMCB List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @throws EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchNewLaneSecCmcbList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0209 : Save1<br>
	 * [New Lane Sector CMCB List]을 [수정]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageNewLaneSecCmcbNewLane(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0209 : Creation<br>
	 * [New Lane Sector CMCB Pair Cost]을 [생성]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createNewLaneSecCmcbPairCost(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0209 : Retrieve2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @throws EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchNewLaneSecCmcbPairCost(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0209 : Save2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [수정]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageNewLaneSecCmcbPairCost(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0210 : [Retrieve]<br>
	 * [Basic CMCB for IAS Sector List]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchBasicCmcbForIasSectorList(ConditionVO conditionVO) throws EventException ;
	/**
	 * ESM_SQM_0210 : [Retrieve]<br>
	 * [Basic CMCB for IAS Sector List]의 [COUNT] 를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String  searchBasicCmcbForIasSectorListCnt(ConditionVO conditionVO) throws EventException ;
	/**
	 * ESM_SQM_0210 : Save<br>
	 * [Basic CMCB for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBasicCmcbForIasSectorList(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0210 : Creation<br>
	 * [Basic CMCB for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createBasicCmcbForIasSector(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * ESM_SQM_0211 : Retrieve<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchBasicCmcbForIasSecNewLaneIf(ConditionVO conditionVO) throws EventException ;
	/**
	 * ESM_SQM_0211 : New Lane Cost Apply<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [Apply]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addBasicCmcbForIasSecNewLaneIf(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0212 : Retrieve<br>
	 * [Basic CMCB_MAS UC PFMC]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbMasUcPfmcVO>
	 * @exception EventException
	 */
	public List<SearchBasicCmcbMasUcPfmcVO> searchBasicCmcbMasUcPfmc(ConditionVO conditionVO) throws EventException ;
	
	/**
	 * ESM_SQM_0111 : [이벤트]<br>
	 * [Basic CMCB]의 [Creation batch 수행] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return CommonVO
	 * @throws EventException
	 */
	public CommonVO createAddBasicCmcb(ConditionVO conditionVO, SignOnUserAccount account) throws EventException ;

	/**
	 * ESM_SQM_0111 : Add Creation<br>
	 * [Basic CMCB]을 [수정]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAddBasicCmcb(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
}