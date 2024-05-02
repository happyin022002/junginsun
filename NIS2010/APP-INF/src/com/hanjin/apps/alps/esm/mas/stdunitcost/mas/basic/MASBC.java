/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MASBC.java
*@FileTitle : ABC (PA) / STP Cost (RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 전윤주 
*@LastVersion : 1.0
* 2009.08.04 전윤주
* 1.0 Creation
* 
* 2012.08.27 이석준[CHM-201219844-01]   ABC(PA)/STP Cost(RA)화면에 Month Copy 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mas.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mas.vo.SearchMAS0012ListVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.syscommon.common.table.MasSvcTrnsPrcVO;

/**
 * ALPS-Stdunitcost Business Logic Command Interface<br>
 * - ALPS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jeon Yun Joo
 * @see Esm_mas_0012EventResponse 참조
 * @since J2EE 1.6
 */

public interface MASBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchMAS0012ListVO	searchMAS0012ListVO
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<SearchMAS0012ListVO>
	 * @exception EventException
	 */
	public List<SearchMAS0012ListVO> searchMAS0012List(SearchMAS0012ListVO searchMAS0012ListVO
			                                          ,SearchConditionVO searchConditionVO ) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param MasSvcTrnsPrcVO[] masSvcTrnsPrcVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiMAS0012(MasSvcTrnsPrcVO[] masSvcTrnsPrcVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse createAbcStpCostMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
}