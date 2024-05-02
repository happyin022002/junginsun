/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CostStructureBC.java
*@FileTitle : 물류비용 코드 등록, 전사계정과목 등록
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 김기식
*@LastVersion : 1.18
* 2006-10-13 OKYOUNG IM
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.CostStructureConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.CostStructureSoCodeRtnVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.MainGrpCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.NodLnkCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostCodeListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0139ListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0140ListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchSoCodeListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SpclRepoCntrVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SubGrpCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.TableColumnVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaSpclRepoCntrRgstVO;
import com.clt.syscommon.common.table.CoaStndAcctVO;
import com.clt.syscommon.common.table.CoaTrnsFdrTermVO;
import com.clt.syscommon.common.table.CoaTrnsTermCalcVO;
import com.clt.syscommon.common.table.CoaUsaSvcModVO;
import com.clt.syscommon.common.table.CoaWkPrdVO;



/**
 * COA Business Logic Command Interface<br>
 * - COA에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author OKYOUNG IM
 * @see ESM_COA_002EventResponse 참조
 * @since J2EE 1.4
 */
public interface CostStructureBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * Set List Box 화면에 대한 조회 이벤트 처리<br> 
     *
	 * @return List<SpclRepoCntrVO> 
	 * @exception EventException
	 */
	public List<SpclRepoCntrVO> searchSpclRepoCntrList() throws EventException;
	/**
	 * 멀티 이벤트 처리<br>
	 * Set List Box 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param CoaSpclRepoCntrRgstVO[] coaSpclRepoCntrRgstVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSpclRepoCntr(CoaSpclRepoCntrRgstVO[] coaSpclRepoCntrRgstVO,SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Register C/A Code 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<SearchCostCodeListVO> 
	 * @exception EventException
	 */	
	public List<SearchCostCodeListVO> searchCostCodeList(SearchConditionVO searchVo) throws EventException;
		
	/**
	 * 멀티 이벤트 처리<br>
	 * Register C/A Code 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param CoaStndAcctVO[] vo
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	
	public EventResponse multiCostCode(CoaStndAcctVO[] vo, String userId) throws EventException;
	

	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_0003 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param  SearchSoCodeListVO vo
	 * @param  SearchSoCodeListVO[] vos
	 * @param  String userId
	 * @exception EventException
	 */
	public void multiSoCode(SearchSoCodeListVO vo, SearchSoCodeListVO[] vos, String userId) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_003 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param CostStructureConditionVO vo
	 * @param String userId
	 * @return CostStructureSoCodeRtnVO
	 * @exception EventException
	 */
	public CostStructureSoCodeRtnVO searchSoCodeList(CostStructureConditionVO vo, String userId) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_003 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return CostStructureSoCodeRtnVO
	 * @exception EventException
	 */
	public CostStructureSoCodeRtnVO searchSoCodeList() throws EventException;
	
		
//	/**
//	 * 비용 생성(조회, OP관련비용)  Creation 이벤트 처리<br>
//	 * ESM_COA_108 화면<br>
//	 * 
//	 * 공통코드 CD00806<br> 2006-11-03일 자료
//		CVFS		Full Steve	
//		CVFT		Full Trans	
//		DMDT	DEM/DET	
//		3PTB		3rd Party Billing	
//		MTRP		MT Repo. Cost	
//		EQHD	EQ Holding Cost	
//		AGTC	Agt Commission	
//		POCN	Port Charge/Canal Fee
//		VVBK	Bunker Fee
//		OWDH	Own_Daily-Hire
//		CHDH	Chartered_Daily-Hire
//	 * 
//	 */
//	
//	/**
//	 * 비용 생성(조회, OP관련비용)  Creation 이벤트 처리<br>
//	 * ESM_COA_108 화면<br>
//	 * 
//	 * 공통코드 CD00806<br> 2006-11-03일 자료
//		CVFS		Full Steve	
//		CVFT		Full Trans	
//		DMDT	DEM/DET	
//		3PTB		3rd Party Billing	
//		MTRP		MT Repo. Cost	
//		EQHD	EQ Holding Cost	
//		AGTC	Agt Commission	
//		POCN	Port Charge/Canal Fee
//		VVBK	Bunker Fee
//		OWDH	Own_Daily-Hire
//		CHDH	Chartered_Daily-Hire
//	 * 
//	 */
//	
//	/**
//	 * @param e
//	 * @return
//	 * @throws EventException
//	 * @throws Exception 
//	 */
//	//public EventResponse createUnitCost(Event e) throws EventException;
//
//	/**
//	 * search
//	 * 	
//	 * @param e ESM_COA_108Event
//	 * @return EventResponse ESM_COA_108EventResponse
//	 * @exception EventException
//	 */
//	//public EventResponse searchCostStructure108List(Event e) throws EventException;
//
//	/**
//	 * multi
//	 * 	
//	 * @param e ESM_COA_108Event
//	 * @return EventResponse ESM_COA_108EventResponse
//	 * @exception EventException
//	 */
//	//public EventResponse multiCostStructure108(Event e) throws EventException;
//
//	/**
//	 * Container Type Size를 리턴해준다.
//	 * 	
//	 * @param e ESM_COA_108Event
//	 * @return boolean 실행결과
//	 * @exception EventException
//	 */
//	public String searchContainerTpSz() throws EventException;
//	
//	/**
//	 * 
//	 * @param msg 
//	 * @return EventResponse ReceiveQueueEventResponse
//	 * @exception EventException
//	 */
//	public void receiveCharteredDailyHire(String msg) throws EventException;
//	
//	/**
//	 * 
//	 * @param msg 
//	 * @return EventResponse ReceiveQueueEventResponse
//	 * @exception EventException
//	 */
//	public void receiveEQBalance(String msg) throws EventException;
//	
//	/**
//	 * 
//	 * @param msg 
//	 * @return EventResponse ReceiveQueueEventResponse
//	 * @exception EventException
//	 */
//	public void receiveFullSteve(String msg) throws EventException;
//
//	/**
//	 * 
//	 * @param msg 
//	 * @return EventResponse ReceiveQueueEventResponse
//	 * @exception EventException
//	 */
//	public void receiveBunkerFee(String msg) throws EventException;
//	
//	/**
//	 * 
//	 * @param msg 
//	 * @return EventResponse ReceiveQueueEventResponse
//	 * @exception EventException
//	 */
//	public void receiveFulTrans(String msg) throws EventException;
//	
//	/**
//	 * 
//	 * @param msg 
//	 * @return EventResponse ReceiveQueueEventResponse
//	 * @exception EventException
//	 */
//	public void receiveOwnDailyHire(String msg) throws EventException;
//
//	/**
//	 * 
//	 * @param msg 
//	 * @return EventResponse ReceiveQueueEventResponse
//	 * @exception EventException
//	 */
//	public void receiveAbcStpCost(String msg) throws EventException;
//	
//	/**
//	 * 
//	 * @param msg 
//	 * @return EventResponse ReceiveQueueEventResponse
//	 * @exception EventException
//	 */
//	public void receiveAverageRevenue(String msg) throws EventException;
//	
//	/**
//	 * 
//	 * @param msg 
//	 * @return EventResponse ReceiveQueueEventResponse
//	 * @exception EventException
//	 */
//	public void modifyCOA_UT_COST_CRE_STS(String msg) throws EventException;
//
	
	
	/*
	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)||e.getFormCommand().isCommand(FormCommand.SEARCH02) {
		eventResponse = this.searchCostStructure0137List();
	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)||e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
		eventResponse = this.searchCostStructure0137List2(e);
	} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)||e.getFormCommand().isCommand(FormCommand.MULTI02)) {
		eventResponse = this.multiCostStructure0137(e);
	} 
	 */
	
	/**
	 *Sheet1의 테이블의 컬럼 목록을 조회(NODE, LINK))<br>
	 * 
	 * @param String fTableName
	 * @return List<TableColumnVO>
	 * @exception EventException
	 */
	public List<TableColumnVO> searchCostStructure0137List(String fTableName) throws EventException;
	
	/**
	 * NODE, LINK 단가 조회<br>
	 * 
	 * @param String fTableName
	 * @param TableColumnVO[] tableColumnVOs
	 * @return List<NodLnkCostCodeVO>
	 * @exception EventException
	 */
	public List<NodLnkCostCodeVO> searchCostStructure0137List2(String fTableName, TableColumnVO[] tableColumnVOs) throws EventException;

	/**
	 * NODE/LINK단가 입력/수정/삭제<br>
	 * 
	 * @param String fTableName
	 * @param NodLnkCostCodeVO[] nodLnkCostCodeVO
	 * @param account SignOnUserAccount
	 * @exception EventException 
	 */
	public void multiCostStructure0137(String fTableName, NodLnkCostCodeVO[] nodLnkCostCodeVO, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Feeder Term Inquiry 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchconditionVO
	 * @return List<SearchCostStructure0139ListVO> 
	 * @exception EventException
	 */	
	public List<SearchCostStructure0139ListVO> searchCostStructure0139List(SearchConditionVO searchconditionVO) throws EventException;
	

	/**
	 * 멀티 이벤트 처리<br>
	 * Feeder Term Inquiry 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param CoaTrnsFdrTermVO[] coaTrnsFdrTermVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostStructure0139(CoaTrnsFdrTermVO[] coaTrnsFdrTermVO,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Feeder Term Ratio 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchCostStructure0140ListVO searchCostStructure0140List
	 * @param SearchConditionVO searchCondition
	 * @return List<SearchCostStructure0140ListVO> 
	 * @exception EventException
	 */	
	public List<SearchCostStructure0140ListVO> searchCostStructure0140List(SearchCostStructure0140ListVO searchCostStructure0140List
			                                                              ,SearchConditionVO searchCondition) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Feeder Term Ratio 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param CoaTrnsTermCalcVO[] coaTrnsTermCalcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiCostStructure0140(CoaTrnsTermCalcVO[] coaTrnsTermCalcVO,SignOnUserAccount account) throws EventException;


	/**
	 * Register C/A Code 화면에서 Office를 생성한다.<br>
	 * 
	 * @param  SearchConditionVO searchconditionVO
	 * @exception EventException
	 */
	public void createOfficeLevel(SearchConditionVO searchconditionVO) throws EventException;

	
	/**
	 * Year month 를 조회한다.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */	
	public String searchYearMonthValue() throws EventException;
	
	/**
	 * Year month 를 수정한다.<br>
	 * 
	 * @param  SearchConditionVO searchconditionVO
	 * @exception EventException
	 */	
	public void multiYearMonthValue(SearchConditionVO searchconditionVO) throws EventException;
	
	/**
	 * Main Group Cost Code retrieve<br>
	 * 
	 * @param  String stndCostTpCd
	 * @return List<MainGrpCostCodeVO>
	 * @exception EventException
	 */
	public List<MainGrpCostCodeVO> searchMainGrpCostCode(String stndCostTpCd) throws EventException;
	
	/**
	 * Main Group Cost Code add/modify/remove<br>
	 * 
	 * @param  MainGrpCostCodeVO[] mainGrpCostCodeVOs
	 * @param  SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiMainGrpCostCode(MainGrpCostCodeVO[] mainGrpCostCodeVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Sub Group Cost Code retrieve<br>
	 * 
	 * @param  String stndCostTpCd
	 * @param  String mainGroupCostCd
	 * @return List<SubGrpCostCodeVO>
	 * @exception EventException
	 */
	public List<SubGrpCostCodeVO> searchSubGrpCostCode(String stndCostTpCd,String mainGroupCostCd) throws EventException;
	
	/**
	 * Sub Group Cost Code add/modify/remove<br>
	 * 
	 * @param  SubGrpCostCodeVO[] subGrpCostCodeVOs
	 * @param  SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiSubGrpCostCode(SubGrpCostCodeVO[] subGrpCostCodeVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving USA Service Mode<br>
	 * 
	 * @param String orgRgnCd
	 * @param String destRgnCd
	 * @param String svcModCd  
	 * @return List<CoaUsaSvcModVO>
	 * @exception EventException
	 */
	public List<CoaUsaSvcModVO> searchUsaServiceMode(String orgRgnCd, String destRgnCd, String svcModCd) throws EventException;

	/**
	 * Saving USA Service Mode<br>
	 * 
	 * @param CoaUsaSvcModVO[] coaUsaSvcModVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiUsaServiceMode(CoaUsaSvcModVO[] coaUsaSvcModVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving Week Period<br>
	 * 
	 * @param String costYr
	 * @param String costWkFm
	 * @param String costWkTo
	 * @return List<CoaWkPrdVO>
	 * @exception EventException
	 */
	public List<CoaWkPrdVO> searchWeekPeriod(String costYr, String costWkFm, String costWkTo) throws EventException;

	/**
	 * Saving Week Period<br>
	 * 
	 * @param CoaWkPrdVO[] coaWkPrdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiWeekPeriod(CoaWkPrdVO[] coaWkPrdVOs, SignOnUserAccount account) throws EventException;
}
