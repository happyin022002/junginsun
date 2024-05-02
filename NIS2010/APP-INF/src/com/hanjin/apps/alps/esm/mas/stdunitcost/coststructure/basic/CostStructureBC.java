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
* 2009.07.09 김기대  New Framework 적용 [0002]
* 2009.07.10 박은주  New Framework 적용 [0001]
* 2009.08.03 전윤주  New Framework 적용 [0140]
* 2009.08.21 장영석  New Framework 적용 [0139]
* 2009.08.28 임옥영  New Framework 적용 [0137]
* 2009.10.07 장영석 New Framework 적용 [0160]
* 2009.10.21 김기식  New Framework 적용 [0003] 
* 2010.06.17 이행지 Ticket ID:ITM-201001650 - GeneralEventResponse => void로 변경, 실제 return 되는 값이 없어서
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.basic;

import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.MasAgmtRstrMgmtConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.GetVariableheader2VO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.NodLnkCostCodeVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchCostCodeListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.CostStructureSoCodeRtnVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.CostStructureConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchCostStructure0139ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchCostStructure0140ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchSoCode0160ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchSoCodeListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SpclRepoCntrVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.TableColumnVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.RevExpChargeVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasSpclRepoCntrRgstVO;
import com.hanjin.syscommon.common.table.MasStndAcctVO;
import com.hanjin.syscommon.common.table.MasTrnsFdrTermVO;
import com.hanjin.syscommon.common.table.MasTrnsTermCalcVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.InqOffice0138VO;


/**
 * eNIS-MAS Business Logic Command Interface<br>
 * - eNIS-MAS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author OKYOUNG IM
 * @see ESM_MAS_002EventResponse 참조
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
	 * @param MasSpclRepoCntrRgstVO[] masSpclRepoCntrRgstVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSpclRepoCntr(MasSpclRepoCntrRgstVO[] masSpclRepoCntrRgstVO,SignOnUserAccount account) throws EventException;

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
	 * @param MasStndAcctVO[] vo
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	
	public EventResponse multiCostCode(MasStndAcctVO[] vo, String userId) throws EventException;
	

	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_MAS_0003 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param  SearchSoCodeListVO vo
	 * @param  SearchSoCodeListVO[] vos
	 * @param  String userId
	 * @exception EventException
	 */
	public void multiSoCode(SearchSoCodeListVO vo, SearchSoCodeListVO[] vos, String userId) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_003 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param CostStructureConditionVO vo
	 * @param String userId
	 * @return CostStructureSoCodeRtnVO
	 * @exception EventException
	 */
	public CostStructureSoCodeRtnVO searchSoCodeList(CostStructureConditionVO vo, String userId) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_MAS_003 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return CostStructureSoCodeRtnVO
	 * @exception EventException
	 */
	public CostStructureSoCodeRtnVO searchSoCodeList() throws EventException;
	
		
//	/**
//	 * 비용 생성(조회, OP관련비용)  Creation 이벤트 처리<br>
//	 * ESM_MAS_108 화면<br>
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
//	 * ESM_MAS_108 화면<br>
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
//	 * @param e ESM_MAS_108Event
//	 * @return EventResponse ESM_MAS_108EventResponse
//	 * @exception EventException
//	 */
//	//public EventResponse searchCostStructure108List(Event e) throws EventException;
//
//	/**
//	 * multi
//	 * 	
//	 * @param e ESM_MAS_108Event
//	 * @return EventResponse ESM_MAS_108EventResponse
//	 * @exception EventException
//	 */
//	//public EventResponse multiCostStructure108(Event e) throws EventException;
//
//	/**
//	 * Container Type Size를 리턴해준다.
//	 * 	
//	 * @param e ESM_MAS_108Event
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
//	public void modifyMAS_UT_COST_CRE_STS(String msg) throws EventException;
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
	 * ESM_MAS_138 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<InqOffice0138VO>
	 * @exception EventException
	 */
	public List<InqOffice0138VO> searchInqOffice0138List(SearchConditionVO searchConditionVO) throws EventException;

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
	 * @param MasTrnsFdrTermVO[] masTrnsFdrTermVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostStructure0139(MasTrnsFdrTermVO[] masTrnsFdrTermVO,SignOnUserAccount account) throws EventException;
	
	
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
	 * @param MasTrnsTermCalcVO[] masTrnsTermCalcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiCostStructure0140(MasTrnsTermCalcVO[] masTrnsTermCalcVO,SignOnUserAccount account) throws EventException;


	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchSoCode0160List() throws EventException;


	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSoCode0160ListVO searchSoCode0160ListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @param GetVariableheader2VO	variableheader2VO
	 * @return List<SearchSoCode0160ListVO>
	 * @exception EventException
	 */
	public SearchSoCode0160ListVO searchSoCode0160List(SearchSoCode0160ListVO searchSoCode0160ListVO, SearchConditionVO searchConditionVO, GetVariableheader2VO variableheader2VO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param vo GetVariableheader2VO 
	 * @param vos MasAgmtRstrMgmtConditionVO[]  
	 * @param SearchConditionVO condVo 
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSoCode0160(GetVariableheader2VO vo, MasAgmtRstrMgmtConditionVO[] vos, SearchConditionVO condVo, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0134 조회<br>
	 * 
	 * @param RevExpChargeVO revExpChargeVO
	 * @return List<RevExpChargeVO>
	 * @exception EventException
	 */
	public List<RevExpChargeVO> searchRevExpChargeList(RevExpChargeVO revExpChargeVO) throws EventException;

	/**
	 * ESM_MAS_0134 - Save<br>
	 * @param RevExpChargeVO[] revExpChargeVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiRevExpCharge(RevExpChargeVO[] revExpChargeVOs, SignOnUserAccount account) throws EventException ;
	
	/**
	 * ESM_MAS_0134 - Delete<br>
	 * @param RevExpChargeVO[] revExpChargeVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void deleteRevExpCharge(RevExpChargeVO[] revExpChargeVOs, SignOnUserAccount account) throws EventException ;
	
}
