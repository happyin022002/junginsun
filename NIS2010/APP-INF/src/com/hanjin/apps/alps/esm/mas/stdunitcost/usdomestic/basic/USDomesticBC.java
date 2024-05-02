/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USDomesticBC.java
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.16 김보배
* 1.0 Creation
*=========================================================
* History
* 2013.05.10 최성민 [CHM-201324573-01] [MAS] Domestic Saving Credit 화면 버튼 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.vo.SearchUSDomesticVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Stdunitcost Business Logic Command Interface<br>
 * - ALPS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author BOBAE KIM
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.5
 */

public interface USDomesticBC {
	
	/**
	 * USDomesticCost 조회
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @return List<SearchUSDomesticVO>
	 * @throws EventException
	 */
	public List<SearchUSDomesticVO> searchUSDomesticCost(SearchUSDomesticVO searchUSDomesticVO) throws EventException; 
	
	/**
	 * USDomesticCost 수정 후 저장
	 * 
	 * @param SearchUSDomesticVO[] searchUSDomesticVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiUSDomesticCost(SearchUSDomesticVO[] searchUSDomesticVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * USDomesticCost 월 단가 생성
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createUSDomesticCost(SearchUSDomesticVO searchUSDomesticVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * BackEndJob을 실행
	 * 
	 * @param SignOnUserAccount account
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @param String pgmNo
	 * @return String 
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, SearchUSDomesticVO searchUSDomesticVO, String pgmNo) throws EventException;
	
	/**
	 * CREATE 하기 전 MAS_MTY_ECC_UT_COST 테이블 데이터 유무 확인
	 * 
	 * @param fCostYrmon
	 * @return String 
	 * @throws EventException
	 */
	public String searchMasMtyEccUtCostCnt(String fCostYrmon) throws EventException;
	
	/**
	 * ESM_MAS_0014 : CREATE 된 기간 조회
	 *
	 * @param String fCostYrmon
	 * @return String
	 * @throws EventException
	 */
	public String searchUSDomCreationStatus(String fCostYrmon) throws EventException;

	/**
	 * [Domestic Saving Credit 월단가]을 [복사] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createDomesticMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account)  throws EventException;
}