/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CostManageBC.java
*@FileTitle      : CostManageBC
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.31 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.basic;

import java.util.List;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchAddedNewLaneListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbCoaPfmcListListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbCoaUcPfmcVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchNewLaneOfficeCmcbListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchNewLaneSecCmcbListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqQtaLaneOfcCostVO;
import com.clt.syscommon.common.table.CsqQtaLaneOfcVO;
import com.clt.syscommon.common.table.CsqQtaNewLaneOfcCostVO;
import com.clt.syscommon.common.table.CsqQtaNewLaneVO;

/**
 * ALPS-CostManage Business Logic Command Interface<br>
 * - ALPS-CostManage 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
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
	 * @param CsqQtaNewLaneVO[] csqQtaNewLaneVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAddedNewLane(CsqQtaNewLaneVO[] csqQtaNewLaneVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0012 : [이벤트]<br>
	 * [New Lane OFfice CMCB]을 [생성] 합니다.<br>
	 * 
	 * @param CsqQtaNewLaneVO[] csqQtaNewLaneVOS
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createNewLaneOfficeCmcb(CsqQtaNewLaneVO[] csqQtaNewLaneVOS, ConditionVO conditionVO,String usrId) throws EventException;
	
	/**
	 * New Lane - Office의 Cmcb를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param CsqQtaNewLaneVO csqQtaNewLaneVO
	 * @return List<SearchNewLaneOfficeCmcbListVO>
	 * @throws EventException
	 */
	public List<SearchNewLaneOfficeCmcbListVO> searchNewLaneOfficeCmcbList(ConditionVO conditionVO, CsqQtaNewLaneVO csqQtaNewLaneVO) throws EventException;
	
	/**
	 * New Lane - Office의 Cmcb를 업데이트한다.
	 * 
	 * @param CsqQtaNewLaneOfcCostVO[] VOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageNewLaneOfficeCmcb(CsqQtaNewLaneOfcCostVO[] VOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * 추가된 Office에 대해서 Lane-Office정보와 CMCB를 생성한다.
	 * 
	 * @param CsqQtaLaneOfcVO[] csqQtaLaneOfcVOS
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createRelatedData(CsqQtaLaneOfcVO[] csqQtaLaneOfcVOS, ConditionVO conditionVO,String usrId) throws EventException;
	
	/**
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbListVO>
	 * @exception EventException
	 */
	public List<SearchBasicCmcbListVO> searchBasicCmcbList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicCmcbListCnt(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createBasicCmcb(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [수정] 합니다.<br>
	 * 
	 * @param CsqQtaLaneOfcCostVO[] csqQtaLaneOfcCostVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBasicCmcb(CsqQtaLaneOfcCostVO[] csqQtaLaneOfcCostVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0014 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<CsqQtaLaneOfcCostVO>
	 * @exception EventException
	 */
	public List<CsqQtaLaneOfcCostVO> searchBasicCmcbNewLaneCostIfList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0014 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [생성] 합니다.<br>
	 * 
	 * @param CsqQtaLaneOfcCostVO[] csqQtaLaneOfcCostVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBasicCmcbNewLaneCostIf(CsqQtaLaneOfcCostVO[] csqQtaLaneOfcCostVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0015 : [이벤트]<br>
	 * [Basic CMCB_COA UC PFMC Retrieve)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbCoaPfmcListListVO>
	 * @exception EventException
	 */
	public List<SearchBasicCmcbCoaPfmcListListVO> searchBasicCmcbCoaPfmcList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0209 : Retrieve1<br>
	 * [New Lane Sector CMCB List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @throws EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchNewLaneSecCmcbList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0209 : Save1<br>
	 * [New Lane Sector CMCB List]을 [수정]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageNewLaneSecCmcbNewLane(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0209 : Creation<br>
	 * [New Lane Sector CMCB Pair Cost]을 [생성]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createNewLaneSecCmcbPairCost(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0209 : Retrieve2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @throws EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchNewLaneSecCmcbPairCost(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0209 : Save2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [수정]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageNewLaneSecCmcbPairCost(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0210 : [Retrieve]<br>
	 * [Basic CMCB for IAS Sector List]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchBasicCmcbForIasSectorList(ConditionVO conditionVO) throws EventException ;
	/**
	 * ESM_CSQ_0210 : [Retrieve]<br>
	 * [Basic CMCB for IAS Sector List]의 [COUNT] 를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String  searchBasicCmcbForIasSectorListCnt(ConditionVO conditionVO) throws EventException ;
	/**
	 * ESM_CSQ_0210 : Save<br>
	 * [Basic CMCB for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBasicCmcbForIasSectorList(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0210 : Creation<br>
	 * [Basic CMCB for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createBasicCmcbForIasSector(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * ESM_CSQ_0211 : Retrieve<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception EventException
	 */
	public List<SearchNewLaneSecCmcbListVO> searchBasicCmcbForIasSecNewLaneIf(ConditionVO conditionVO) throws EventException ;
	/**
	 * ESM_CSQ_0211 : New Lane Cost Apply<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [Apply]합니다.<br>
	 * 
	 * @param SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addBasicCmcbForIasSecNewLaneIf(SearchNewLaneSecCmcbListVO[] searchNewLaneSecCmcbListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0212 : Retrieve<br>
	 * [Basic CMCB_COA UC PFMC]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbCoaUcPfmcVO>
	 * @exception EventException
	 */
	public List<SearchBasicCmcbCoaUcPfmcVO> searchBasicCmcbCoaUcPfmc(ConditionVO conditionVO) throws EventException ;
}