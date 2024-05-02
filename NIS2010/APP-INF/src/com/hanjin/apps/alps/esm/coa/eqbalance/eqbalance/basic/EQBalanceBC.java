/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EQBalanceBC.java
 *@FileTitle : Repo U/C 
 *Open Issues :
 *@LastModifyDate : 2009.10.09
 *@LastModifier : 박수훈

 *@LastVersion : 1.10
 * 2006-11-16 Sangwook_Nam
 * 1.0 최초 생성
 * 
 * Change history : 2008.02.18 ESM_COA_132번 화면 source 삭제
 *                : 2008.09.03 CSR No.N200808260006 EQ repo rule-set(Rlane setting을 From-To ECC setting으로)
 *                             17번 화면 삭제 
 * 2009.08.28 박수훈  New FrameWork 적용 [0019]
 * 2009.09.07 박수훈  New FrameWork 적용 [0018]
 * 2009.09.21 장영석  New FrameWork 적용 [0016]
 * 2009.10.08 박수훈  New FrameWork 적용 [0161]
 * 2009.10.09 박수훈  New FrameWork 적용 [0136]
*  2010.02.04 임옥영 :품질검토결과 반영
*  2010.02.12 임옥영 : Line No. 91 :  : shall be matched with type of parameter(CoaCntrRepoShtgInfoVO[] vs CoaCntrRepoRuleVO[])
 * 2010.02.19 임옥영 소스품질검토 결과 반영 Line No. 92 :  : shall be matched with name of parameter(coaCntrRepoShtgInfoVO  vs coaCntrRepoRuleVO)
 * 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -POR 별 Credit Ratio를 setup 할수 있는 화면추가 (Rule-set)
 =========================================================*/
package com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance00163ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0016ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0018ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0019ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0136ListVO;
import com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo.SearchEQBalance0161ListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaCntrRepoCrVO;
import com.hanjin.syscommon.common.table.CoaCntrRepoRoutEccVO;
import com.hanjin.syscommon.common.table.CoaCntrRepoRuleVO;
import com.hanjin.syscommon.common.table.CoaCntrRepoShtgInfoVO;


/**
 * ALPS-COA Business Logic Command Interface<br> - ALPS-COA에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Sangwook_Nam
 * @see 
 * @since J2EE 1.6
 */
public interface EQBalanceBC {
	
	/**
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * @param SearchConditionVO	SearchConditionVO
	 * @return List<SearchConditionVO>
	 * @exception EventException
	 */
	public List<SearchConditionVO> searchEQBalance00162List(SearchConditionVO searchConditionVO) throws EventException;
	

	/**
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchEQBalance00163ListVO>
	 * @exception EventException
	 */
	public List<SearchEQBalance00163ListVO> searchEQBalance00163List(SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * @param CoaCntrRepoShtgInfoVO[] coaCntrRepoShtgInfoVO
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @param String excel_load_yn
	 * @exception EventException
	 */
	public void multiEQBalance00163(CoaCntrRepoShtgInfoVO[] coaCntrRepoShtgInfoVO,SearchConditionVO searchConditionVO,SignOnUserAccount account, String excel_load_yn) throws EventException;

	
	/**
	 * 조회 이벤트 처리<br>
	 * Set Credit Ratio 팝업 화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0018 조회
	 * @param SearchEQBalance0018ListVO	searchEQBalance0018ListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchEQBalance0018ListVO>
	 * @exception EventException
	 */
	public List<SearchEQBalance0018ListVO> searchEQBalance0018List(SearchEQBalance0018ListVO searchEQBalance0018ListVO
			                                                      ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Set Credit Ratio 팝업 화면에 대한 멀티 이벤트 처리<br>
	 * ESM_COA_0018 수정
	 * @param CoaCntrRepoCrVO[] coaCntrRepoCrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEQBalance0018(CoaCntrRepoCrVO[] coaCntrRepoCrVO,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * EQBalance화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0019 조회
	 * @param SearchEQBalance0019ListVO	searchEQBalance0019ListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchEQBalance0019ListVO>
	 * @exception EventException
	 */
	public List<SearchEQBalance0019ListVO> searchEQBalance0019List (SearchEQBalance0019ListVO searchEQBalance0019ListVO
			                                                       ,SearchConditionVO searchConditionVO) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br> 
	 * From ECC Setting 팝업 화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0136 화면 조회<br>
	 * @param SearchEQBalance0136ListVO	searchEQBalance0136ListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchEQBalance0136ListVO>
	 * @exception EventException
	 */
	public List<SearchEQBalance0136ListVO> searchEQBalance0136List(SearchEQBalance0136ListVO searchEQBalance0136ListVO
			                                                      ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * From ECC Setting 팝업 화면에 대한 수정 이벤트 처리<br>
	 * ESM_COA_0136 화면 수정<br>
	 * @param CoaCntrRepoRoutEccVO[] coaCntrRepoRoutEccVO
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEQBalance0136(CoaCntrRepoRoutEccVO[] coaCntrRepoRoutEccVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * To ECC Setting 팝업 화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0161 화면 조회<br>
	 * @param SearchEQBalance0161ListVO	searchEQBalance0161ListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchEQBalance0161ListVO>
	 * @exception EventException
	 */
	public List<SearchEQBalance0161ListVO> searchEQBalance0161List(SearchEQBalance0161ListVO searchEQBalance0161ListVO
			                                                      ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * DEL ECC Setting 팝업 화면에 대한 수정 이벤트 처리<br>
	 * ESM_COA_0161 화면 수정<br>
	 * @param CoaCntrRepoRoutEccVO[] coaCntrRepoRoutEccVO
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEQBalance0161(CoaCntrRepoRoutEccVO[] coaCntrRepoRoutEccVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ECC_CD 존재유뮤 체크. <br>
	 * 
	 * @param eccCd
	 * @return String
	 * @throws EventException
	 */
	public String checkEccYn(String eccCd) throws EventException;	
	
}