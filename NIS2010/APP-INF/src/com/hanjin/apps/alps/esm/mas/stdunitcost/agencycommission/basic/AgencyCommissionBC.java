/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AgencyCommissionBC.java
*@FileTitle : Agency Commission 단가 조회/수정
*Open Issues :
*@LastModifyDate : 2009-09-21
*@LastModifier : JEON SUNGJIN
*@LastVersion : 1.1
* 2007-07-03 JEON SUNGJIN
* 1.0 최초 생성 CSR No.N200807030011
* Change history :
* 2009-09-21 장영석  New Framework 적용 [0157]
* 2010.02.05 임옥영 소스품질검토 결과 반영 (클래스주석)
* 2010.02.16 임옥영 소스품질검토 결과 반영  Line No. 24 :  : shall be tagged using checklists
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasOtrCommVO;

/**
 * ALPS-Stdunitcost Business Logic Command Interface<br>
 * - ALPS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_MAS_0157EventResponse 참조
 * @since J2EE 1.6
 */
public interface AgencyCommissionBC {

	/**
	 * searchAgnOtrCommCostList 조회<br> 
	 * @param SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchAgnOtrCommCostListVO>
	 * @exception EventException
	 */
	public List<SearchAgnOtrCommCostListVO> searchAgnOtrCommCostList(SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO, SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * searchAgnOtrCommCostList MULTI<br>
	 * 
	 * @param MasOtrCommVO[] masOtrCommVO
	 * @param SearchConditionVO searchConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiAgnOtrCommCost(MasOtrCommVO[] masOtrCommVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;


    /**
  * [비즈니스대상]을 [행위] 합니다.<br>
  * 
  * @param SearchConditionVO conditionVO
  * @return List<DemDet3rdVO>
  * @exception EventException
  */
 public Integer searchAgnOtrCommCostMonthCount(SearchConditionVO conditionVO) throws EventException;
 public void createAgnOtrCommCostMonthCopy(SearchConditionVO conditionVO, SignOnUserAccount account)throws EventException;

}