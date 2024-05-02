/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OPCostBC.java
*@FileTitle : OP Cost
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.15 
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUseQtyVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUtCostDtlVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUtCostVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Stdunitcost Business Logic Command Interface<br>
 * - ALPS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jong-Ock KIM
 * @see Esm_mas_0315EventResponse 참조
 * @since J2EE 1.6
 */
public interface OPCostBC {

	/**
	 * ESM_MAS_0315, ESM_MAS_0316 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<StndUtCostVO>
	 * @exception EventException
	 */
	public List<StndUtCostVO> searchStndUtCostList(SearchConditionVO searchConditionVO ) throws EventException;
	
	/**
	 * ESM_MAS_0315 - Save<br>
	 * @param StndUtCostVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiStndUtCost(StndUtCostVO[] listVos, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_MAS_0315 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String createStndUtCost(SearchConditionVO searchConditionVO) throws EventException ;	
	
	/**
	 * ESM_MAS_0317 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<StndUtCostDtlVO>
	 * @exception EventException
	 */
	public List<StndUtCostDtlVO> searchStndUtCostDtlList(SearchConditionVO searchConditionVO ) throws EventException;
	
	/**
	 * ESM_MAS_0318 조회<br>
	 * 
	 * @param SearchConditionVO     searchConditionVO
	 * @return List<SStndUseQtyVO>
	 * @exception EventException
	 */
	public List<StndUseQtyVO> searchStndUseQtyList(SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * ESM_MAS_0317 - Save<br>
	 * @param StndUtCostDtlVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiStndUtCostDtl(StndUtCostDtlVO[] listVos, SignOnUserAccount account) throws EventException ;

	/**
	 * ESM_MAS_0317 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String createStndUtCostDtl(SearchConditionVO searchConditionVO) throws EventException ;
	
	/**
	 * ESM_MAS_0318 - Save<br>
	 * @param StndUseQtyVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiStndUseQty(StndUseQtyVO[] listVos, SignOnUserAccount account) throws EventException ;

	/**
	 * ESM_MAS_0318 - Create<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String createStndUseQty(SearchConditionVO searchConditionVO) throws EventException ;
	
	/**
	 * ESM_MAS_0319 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<StndUtCostDtlVO>
	 * @exception EventException
	 */
	public List<StndUtCostDtlVO> searchStndUtCostDtlPopList(SearchConditionVO searchConditionVO) throws EventException;

}