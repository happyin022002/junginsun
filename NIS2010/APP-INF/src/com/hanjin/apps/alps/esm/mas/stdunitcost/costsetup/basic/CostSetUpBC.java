/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostSetUpDBDAO.java
*@FileTitle : Manual Cost Set up
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.04 
* 1.0 Creation 
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
* 2012.12.13 송호진 [CHM-201221879] [MAS] Manual Cost Set up 화면 로직 수정 
* 2014.06.19 최덕우 [CHM-201430638] [MAS] BU Other (계선/대선) 항목의 각 계정별 분리 반영 위한 CSR 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.GeneralExpenseVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.MtyRepoTESTRSCostVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.SearchCostSetUpListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.VesselLayupVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.AdjustmentVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.ApproverVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.JobCodeManagementVO;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.RequestVO;

/**
 * ALPS-Stdunitcost Business Logic Command Interface<br>
 * - ALPS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jeon Yun Joo
 * @see Esm_mas_0021EventResponse 참조
 * @since J2EE 1.6
 */

public interface CostSetUpBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @exception EventException
	 */
	public List<SearchCostSetUpListVO> searchCostSetUpList(SearchConditionVO searchConditionVO ) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @exception EventException
	 */
	public List<SearchCostSetUpListVO> searchCostStupDef(SearchConditionVO searchConditionVO ) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @exception EventException
	 */
	public List<MtyRepoTESTRSCostVO> searchMtyRepoCostCreateDate(SearchConditionVO searchConditionVO ) throws EventException;

	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostSetUpListVO>
	 * @exception EventException
	 */
	public List<SearchCostSetUpListVO> searchCostStupMTAbcList(SearchConditionVO searchConditionVO) throws EventException ;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCostSetUpListVO[] searchCostSetUpListVOs
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiOtherCostSetup(SearchCostSetUpListVO[] searchCostSetUpListVOs, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchCostSetUpListVO[] searchCostSetUpListVOs
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiMTAbcCostSetup(SearchCostSetUpListVO[] searchCostSetUpListVOs, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMTAbcCostSetup(SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * 생성 이벤트 처리<br>
	 * Manual Cost Setup를월단가를 복사해서 생성한다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createManualCostStupCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<MtyRepoTESTRSCostVO>
	 * @exception EventException
	 */
	public List<MtyRepoTESTRSCostVO> searchMtyRepoCostDtl(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<MtyRepoTESTRSCostVO>
	 * @exception EventException
	 */
	public List<MtyRepoTESTRSCostVO> searchInterfaceData(SearchConditionVO searchConditionVO) throws EventException;
		
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMtyRepoTESTRSCost(MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOS,SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMtyRepoTESTRSCost(MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs,SignOnUserAccount account) throws EventException;
	

	
	/**
	 * BackEndJob을 실행
	 * 
	 * @param SignOnUserAccount account
	 * @param MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs
	 * @param String pgmNo
	 * @return String 
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs, String pgmNo)  throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param GeneralExpenseVO generalExpenseVO
	 * @return List<GeneralExpenseVO>
	 * @exception EventException
	 */
	public List<GeneralExpenseVO> searchGeneralExpenseList(GeneralExpenseVO generalExpenseVO) throws EventException ;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param GeneralExpenseVO generalExpenseVO
	 * @return List<GeneralExpenseVO>
	 * @exception EventException
	 */
	public List<GeneralExpenseVO> searchGeneralExpenseAsList(GeneralExpenseVO generalExpenseVO) throws EventException ;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param GeneralExpenseVO[] generalExpenseVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiGeneralExpense(GeneralExpenseVO[] generalExpenseVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 *
	 * @param VesselLayupVO vesselLayupVO
	 * @return List<VesselLayupVO>
	 * @exception EventException
	 */
	public List<VesselLayupVO> searchVslLayupList(VesselLayupVO vesselLayupVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String getVesselChk(String vslCd) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param VesselLayupVO[] vesselLayupVOs
	 * @param VesselLayupVO vesselLayupVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslLayupList(VesselLayupVO[] vesselLayupVOs, VesselLayupVO vesselLayupVO, SignOnUserAccount account) throws EventException;
	
}