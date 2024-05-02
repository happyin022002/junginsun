/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AgencyCommissionBC.java
*@FileTitle : Agency Commission 단가 조회/수정
*Open Issues :
*@LastModifyDate : 2009-09-21
*@LastModifier : JEON SUNGJIN
*@LastVersion : 1.1
* 2007-07-03 JEON SUNGJIN
* 1.0 최초 생성
* Change history :
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaOtrCommVO;

/**
 * opus-Stdunitcost Business Logic Command Interface<br>
 * - opus-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_COA_0157EventResponse 참조
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
	 * @param CoaOtrCommVO[] coaOtrCommVO
	 * @param SearchConditionVO searchConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiAgnOtrCommCost(CoaOtrCommVO[] coaOtrCommVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
}