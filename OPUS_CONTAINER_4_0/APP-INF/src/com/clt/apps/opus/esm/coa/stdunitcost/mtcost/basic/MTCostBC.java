/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MTCostBC.java
*@FileTitle : ECC별 MT 표준단가&MT Turntime 생성 
*Open Issues :
*Change history : EQ Repo cost(009) 화면 LCC레벨 추가
*@LastModifyDate : 2009.09.14
*@LastModifier 	: 장영석
*@LastVersion : 1.4
* 2006-11-16 IM OKYOUNG
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListPopUpVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO10;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO11;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO12;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO13;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO14;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO2;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO3;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO4;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO5;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO6;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO7;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO8;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO9;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.EqRepoCostVO;		//SJH.20140922.ADD
import com.clt.framework.core.layer.event.Event;							//SJH.20141001.ADD
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;



/**
 * OPUS-Stdunitcost Business Logic Command Interface<br>
 * - OPUS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author IM OKYOUNG
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.5
 */

public interface MTCostBC {
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet1_MT 조회
	 * @param SearchMTCostListVO searchMTCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO> searchMTCostList(SearchMTCostListVO searchMTCostListVO
			                                        ,SearchConditionVO searchConditionVO) throws EventException; 
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet2_MT 조회 
	 * @param SearchMTCostListVO2 searchMTCostListVO2
	 * @param SearchMTCostListVO searchMTCostListVO
	 * @return List<SearchMTCostListVO2>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO2> searchMTCostList2(SearchMTCostListVO2 searchMTCostListVO2
			                                          ,SearchMTCostListVO searchMTCostListVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet3_MT 조회
	 * @param SearchMTCostListVO3 searchMTCostListVO3
	 * @param SearchMTCostListVO2 searchMTCostListVO2
	 * @return List<SearchMTCostListVO3>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO3> searchMTCostList3(SearchMTCostListVO3 searchMTCostListVO3
			                                          ,SearchMTCostListVO2 searchMTCostListVO2) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * ESM_COA_0009 Sheet4_MT 조회
	 * @param SearchMTCostListVO4 searchMTCostListVO4
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO4>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO4> searchMTCostList4(SearchMTCostListVO4 searchMTCostListVO4
			                                          ,SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet5_MT 조회
	 * @param SearchMTCostListVO5 searchMTCostListVO5
	 * @param SearchMTCostListVO4 searchMTCostListVO4
	 * @return List<SearchMTCostListVO5>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO5> searchMTCostList5(SearchMTCostListVO5 searchMTCostListVO5
			                                          ,SearchMTCostListVO4 searchMTCostListVO4) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet6_MT 조회
	 * @param SearchMTCostListVO6 searchMTCostListVO6
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO6>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO6> searchMTCostList6(SearchMTCostListVO6 searchMTCostListVO6
			                                          ,SearchConditionVO searchConditionVO) throws EventException;
	 
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet7_MT 조회
	 * @param SearchMTCostListVO7 searchMTCostListVO7
	 * @param SearchMTCostListVO6 searchMTCostListVO6
	 * @return List<SearchMTCostListVO7>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO7> searchMTCostList7(SearchMTCostListVO7 searchMTCostListVO7
			                                          ,SearchMTCostListVO6 searchMTCostListVO6) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * ESM_COA_0009 Sheet8_FULL 조회
	 * @param SearchMTCostListVO8 searchMTCostListVO8
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO8>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO8> searchMTCostList8(SearchMTCostListVO8 searchMTCostListVO8
			                                          ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet9_FULL 조회
	 * @param SearchMTCostListVO9 searchMTCostListVO9
	 * @param SearchMTCostListVO8 searchMTCostListVO8
	 * @return List<SearchMTCostListVO9>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO9> searchMTCostList9(SearchMTCostListVO9 searchMTCostListVO9
			                                          ,SearchMTCostListVO8 searchMTCostListVO8) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet10_FULL 조회
	 * @param SearchMTCostListVO10 searchMTCostListVO10
	 * @param SearchMTCostListVO9 searchMTCostListVO9
	 * @return List<SearchMTCostListVO10>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO10> searchMTCostList10(SearchMTCostListVO10 searchMTCostListVO10
			                                            ,SearchMTCostListVO9 searchMTCostListVO9) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * 
	 * ESM_COA_0009 Sheet11_FULL 조회
	 * @param SearchMTCostListVO11 searchMTCostListVO11
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO11>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO11> searchMTCostList11(SearchMTCostListVO11 searchMTCostListVO11
			                                            ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet12_FULL 조회
	 * @param SearchMTCostListVO12 searchMTCostListVO12
	 * @param SearchMTCostListVO11 searchMTCostListVO11
	 * @return List<SearchMTCostListVO12>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO12> searchMTCostList12(SearchMTCostListVO12 searchMTCostListVO12
			                                            ,SearchMTCostListVO11 searchMTCostListVO11) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet13_FULL 조회
	 * @param SearchMTCostListVO13 searchMTCostListVO13
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListVO13>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO13> searchMTCostList13(SearchMTCostListVO13 searchMTCostListVO13
			                                            ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0009 Sheet14_FULL 조회
	 * @param SearchMTCostListVO14 searchMTCostListVO14
	 * @param SearchMTCostListVO13 searchMTCostListVO13
	 * @return List<SearchMTCostListVO14>
	 * @exception EventException
	 */
	public List<SearchMTCostListVO14> searchMTCostList14(SearchMTCostListVO14 searchMTCostListVO14
			                                            ,SearchMTCostListVO13 searchMTCostListVO13) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * MTCost화면에 대한 조회 이벤트 처리_팝업<br>
	 * ESM_COA_0010 조회
	 * @param SearchMTCostListPopUpVO searchMTCostListPopUpVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMTCostListPopUpVO>
	 * @exception EventException
	 */
	public List<SearchMTCostListPopUpVO> searchMTCostListPopUp(SearchMTCostListPopUpVO searchMTCostListPopUpVO, SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * 저장 이벤트 처리<br>
	 * M/B Data I/F<br>

	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createMBInfo(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4003 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @param Event e 
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author SJH.20140922.ADD
	 */
    public CommonCoaRsVO searchEqRepoCostList(SearchConditionVO searchVO, Event e) throws EventException;
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4003 화면 대한 멀티 이벤트 처리<br>
     * 
     * @param EqRepoCostVO[] eqRepoCostVO
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account 
	 * @param Event e 
     * @exception EventException
     * @author SJH.20140923.ADD
     */
    public void multiEqRepoCostInfo(EqRepoCostVO[] eqRepoCostVO, SearchConditionVO searchConditionVO, SignOnUserAccount account, Event e) throws EventException;    
}