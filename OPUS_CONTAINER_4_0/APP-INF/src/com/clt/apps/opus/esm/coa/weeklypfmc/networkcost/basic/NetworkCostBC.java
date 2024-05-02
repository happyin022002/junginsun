/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkCostBC.java
 *@FileTitle : Network Cost BC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-13
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-11-13 kimyoungchul
 * 1.0 최초 생성
 =========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.PndlmSvcVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchBunkerTariffListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchDailyHireListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchFixCostByVVDListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchIntervalTransitTimeListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchMissingStatusListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreRStatusListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreRStatusListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaBnkTrfVO;
import com.clt.syscommon.common.table.CoaInterPrcUtCostVO;
import com.clt.syscommon.common.table.CoaInterPrcVvdExpnVO;
import com.clt.syscommon.common.table.CoaMonVvdPortOpDysVO;
import com.clt.syscommon.common.table.CoaNtwkCostCreVO;
import com.clt.syscommon.common.table.CoaOwnVslDlyHirVO;
import com.clt.syscommon.common.table.CoaSltChtrInfoVO;



/**
 * COA Business Logic Command Interface<br>
 * - COA에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimyoungchul 
 * @see ESM_COA_042EventResponse 참조
 * @since J2EE 1.4
 */
public interface NetworkCostBC {

	/**
	 * ESM_COA_0039 화면에 대한 조회 이벤트 처리
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchIntervalTransitTimeListVO>
	 * @exception EventException
	 */
	public List<SearchIntervalTransitTimeListVO> searchIntervalTransitTimeList(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_COA_0039 화면에 대한 저장 이벤트 처리
	 * 
	 * @param CoaMonVvdPortOpDysVO[] coaMonVvdPortOpDysVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiIntervalTransitTime(CoaMonVvdPortOpDysVO[] coaMonVvdPortOpDysVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_COA_0040 화면에 대한 조회 이벤트 처리
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchPortTariffListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffListVO> searchPortTariffList(SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * ESM_COA_0041 화면에 대한 조회 이벤트를 처리
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @return List<SearchBunkerTariffListVO>
	 * @exception EventException
	 */
	public List<SearchBunkerTariffListVO> searchBunkerTariffList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException;

	/**
	 * ESM_COA_0041 화면에 대한 저장 이벤트를 처리
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param CoaBnkTrfVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiBunkerTariff(SearchConditionVO searchVo, NetworkCostCommonVO vo, CoaBnkTrfVO[] vos, String userId) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @return List<SearchDailyHireListVO>
	 * @exception EventException
	 */
	public List<SearchDailyHireListVO> searchDailyHireList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_0042 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param NetworkCostCommonVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDailyHire(SearchConditionVO searchVo, NetworkCostCommonVO vo, NetworkCostCommonVO[] vos, String userId) throws EventException;
	
	/**
	 * ESM_COA_0043 화면에 대한 동적 해더정보를 조회<br>
	 * 
	 * @param  SearchConditionVO searchVo
	 * @param  NetworkCostCommonVO vo
	 * @return List<NetworkCostCommonVO>
	 * @throws EventException
	 */
	public List<NetworkCostCommonVO> searchOptFixedCostList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException;

	/**
	 * ESM_COA_0043 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @return NetworkCostCommonVO
	 * @exception EventException
	 */
	public NetworkCostCommonVO searchOwnDailyHireList(SearchConditionVO searchVo, NetworkCostCommonVO vo) throws EventException;

	/**
	 * ESM_COA_0043 화면에 대한 저장 이벤트를 처리
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param CoaOwnVslDlyHirVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOwnDailyHire(SearchConditionVO searchVo, NetworkCostCommonVO vo, CoaOwnVslDlyHirVO[] vos, String userId) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchFixCostByVVDListVO>
	 * @exception EventException
	 */
	public List<SearchFixCostByVVDListVO> searchFixCostByVVDList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 초기화 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchNWCreListVO>
	 * @exception EventException
	 */
	public List<SearchNWCreListVO> searchNWCreList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 결과 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchNWCreRStatusListVO>
	 * @exception EventException
	 */
	public List<SearchNWCreRStatusListVO> searchNWCreRStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 생성 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param CoaNtwkCostCreVO[] coaNtwkCostCreVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createNWCreForVVD(SearchConditionVO searchConditionVO, CoaNtwkCostCreVO[] coaNtwkCostCreVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 초기화 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchSltChtrCreListVO>
	 * @exception EventException
	 */
	public List<SearchSltChtrCreListVO> searchSltChtrCreList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 결과 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchSltChtrCreRStatusListVO>
	 * @exception EventException
	 */
	public List<SearchSltChtrCreRStatusListVO> searchSltChtrCreRStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException ;

	
	/**
	 * 생성 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param CoaSltChtrInfoVO[] coaSltChtrInfoVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createSltChtrCre(SearchConditionVO searchConditionVO, CoaSltChtrInfoVO[] coaSltChtrInfoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param NetworkCostCommonVO vo
	 * @param SignOnUserAccount account
	 * @return List<SearchMissingStatusListVO>
	 * @exception EventException
	 */
	public List<SearchMissingStatusListVO> searchMissingStatusList(SearchConditionVO searchVo, NetworkCostCommonVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaInterPrcUtCostVO>
	 * @exception EventException
	 */
	public List<CoaInterPrcUtCostVO> searchTrunkIPCPricing(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * [Trunk IPC Internal Pricing]을 [수정] 합니다.<br>
	 * 
	 * @param CoaInterPrcUtCostVO[] CoaInterPrcUtCostVOs
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTrunkIPCPricing(CoaInterPrcUtCostVO[] CoaInterPrcUtCostVOs, SignOnUserAccount account) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaInterPrcVvdExpnVO>
	 * @exception EventException
	 */
	public List<CoaInterPrcVvdExpnVO> searchFixCostByVVDInterPrcList(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createFixCostByVVDInterPrc(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * Port Tariff 단가를 생성한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 * @SJH.20140728 ADD
	 */
	public EventResponse createPortTariff(SearchConditionVO searchConditionVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * DailyHire 단가를 생성한다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 * @SJH.20140728 ADD
	 */
	public String createDailyHire(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Port Tariff Create 시 기존에 존재하는 항차를 삭제한다.<br>
	 * @param SearchPortTariffListVO[] listVos
	 * @exception EventException
	 */
	public void deletePortTariff(SearchPortTariffListVO[] listVos) throws EventException;
	
	/**
	 * PSO에서 생성된 Port Tariff Data를 COA로 IF한다<br>
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @param String usr_id
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createPortTariffFromPSO(SearchPortTariffListVO[] searchPortTariffListVOs, String usr_id) throws EventException;
	
	/**
	 * ESM_COA_0040 화면에 대한 조회 이벤트 처리
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchPortTariffDetailListVO>
	 * @exception EventException
	 */
	public List<SearchPortTariffDetailListVO> searchPortTariffDetailList(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * ESM_COA_0040 화면에 대한 멀티 이벤트 처리
	 * 
	 * @param SearchConditionVO SearchConditionVO
	 * @param SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs
	 * @param String userId
	 * @return EventResponse EventResponse
	 * @throws EventException
	 */
	public EventResponse multiPortTariffDetail(SearchConditionVO SearchConditionVO, SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs, String userId) throws EventException ;
	
	/**
	 * ESM_COA_0040 화면에 대한 멀티 이벤트 처리
	 * 
	 * @param SearchConditionVO SearchConditionVO
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @param String userId
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiPortTariff(SearchConditionVO SearchConditionVO, SearchPortTariffListVO[] searchPortTariffListVOs, String userId) throws EventException;
	
	/**
	 * ESM_COA_0040 화면에 대한 카피 이벤트 처리
	 * 
	 * @param SearchPortTariffListVO[] searchPortTariffListVOs
	 * @param String usr_id
	 * @return EventResponse
	 * @throws EventException
	 * @author SJH.20150206.ADD
	 */
	public EventResponse copyPortTariff(SearchPortTariffListVO[] searchPortTariffListVOs, String usr_id) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaInterPrcVvdExpnVO>
	 * @exception EventException
	 * @author SJH.20141028
	 */
	public CommonCoaRsVO searchFixCostByVVDSltInterPrcList(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * NetworkCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account 
	 * @return EventResponse
	 * @exception EventException
	 * @author SJH.20141028
	 */
	public EventResponse createFixCostByVVDSltInterPrc(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4012 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author 20151001.ADD
	 */
    public CommonCoaRsVO searchPndlmSvcList(SearchConditionVO searchVO) throws EventException;	
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4012 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author 20151005.ADD
	 */
    public CommonCoaRsVO searchPndlmSvcDtlList(SearchConditionVO searchVO) throws EventException;	    
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4012 화면 대한 멀티 이벤트 처리<br>
     * 
     * @param PndlmSvcVO[] pndlmSvcVO
     * @param SignOnUserAccount account 
     * @exception EventException
     * @return String
     * @author 20151001.ADD
     */
    public String multiPndlmSvcInfo(PndlmSvcVO[] pndlmSvcVO, SignOnUserAccount account) throws EventException;
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4012 화면 대한 멀티 이벤트 처리<br>
     * 
     * @param SearchConditionVO searchVO
     * @param CommonCoaRsVO commonCoaRsVO
     * @param PndlmSvcVO[] pndlmSvcVO
     * @param SignOnUserAccount account 
     * @exception EventException
     * @author 20151001.ADD
     */
    public void multiPndlmSvcDtlInfo(SearchConditionVO searchVO, CommonCoaRsVO commonCoaRsVO, PndlmSvcVO[] pndlmSvcVO, SignOnUserAccount account) throws EventException;
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4012 화면 대한 create 이벤트 처리<br>
     * 
     * @param SearchConditionVO searchVO
     * @param SignOnUserAccount account 
     * @exception EventException
     * @author 20151001.ADD
     */
    public void createPndlmSvcDtlInfo(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException;    		
	
}