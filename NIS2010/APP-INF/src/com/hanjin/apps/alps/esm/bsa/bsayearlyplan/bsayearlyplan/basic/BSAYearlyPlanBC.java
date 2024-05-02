/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanBC.java
*@FileTitle : BSA Creation/Update
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.17 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.17 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2011.04.04 최윤성 [CHM-201109932-01] BSA Yearly PLan 메뉴에 Live Data I/F 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.CreateBSAVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.BsaYearlyPlanConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.ParamCoaMonVvdYryPlnVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.RsltCoaMonVvdYryPlnVO;
import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BsaBudJntOpBzcVO;
import com.hanjin.syscommon.common.table.BsaBudJntOpCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaBudSltChtrBzcVO;
import com.hanjin.syscommon.common.table.BsaBudSltChtrCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaBudSltPrcCrrVO;
import com.hanjin.syscommon.common.table.BsaBudSltPrcVO;

/**
 * ALPS-Bsayearlyplan Business Logic Command Interface<br>
 * - ALPS-Bsayearlyplan에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Haeng-ji,Lee
 * @see 
 * @since J2EE 1.6
 */

public interface BSAYearlyPlanBC {


	//===============================================================================
	// ESM_BSA_0040: BSA Creation/Update(Yearly Plan)
	//=============================================================================== 
	/**
	 * @param BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchBSATableJOList(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO) throws EventException;

	/**
	 * @param BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchBSATableSCList(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO) throws EventException;
	
	/**
	 * @param BsaBudJntOpBzcVO[] bsaBudJntOpBzcVOs
	 * @param BsaBudJntOpCrrCapaVO[] bsaBudJntOpCrrCapaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBSATableJO(BsaBudJntOpBzcVO[] bsaBudJntOpBzcVOs, BsaBudJntOpCrrCapaVO[] bsaBudJntOpCrrCapaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * @param BsaBudSltChtrBzcVO[] bsaBudSltChtrBzcVOs
	 * @param BsaBudSltChtrCrrCapaVO[] bsaBudSltChtrCrrCapaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBSATableSC(BsaBudSltChtrBzcVO[] bsaBudSltChtrBzcVOs, BsaBudSltChtrCrrCapaVO[] bsaBudSltChtrCrrCapaVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param BsaBudJntOpBzcVO[] bsaBudJntOpBzcVOs
	 * @exception EventException
	 */
	public void removeBSATableJO(BsaBudJntOpBzcVO[] bsaBudJntOpBzcVOs) throws EventException;

	/**
	 * @param BsaBudSltChtrBzcVO[] bsaBudSltChtrBzcVOs
	 * @exception EventException
	 */
	public void removeBSATableSC(BsaBudSltChtrBzcVO[] bsaBudSltChtrBzcVOs) throws EventException;
	
	/**
	 * @param BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO
	 * @param SignOnUserAccount account
	 * @return CreateBSAVO
	 * @exception EventException
	 */
	public CreateBSAVO createBSA(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO, SignOnUserAccount account) throws EventException;

	//===============================================================================
	// ESM_BSA_0041: Slot Price Creation/Update(Yearly Plan)
	//=============================================================================== 
	/** 
	 * @param BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchSlotCostList(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param BsaBudSltPrcVO[] bsaBudSltPrcVOs
	 * @param BsaBudSltPrcCrrVO[] bsaBudSltPrcCrrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSlotCost(BsaBudSltPrcVO[] bsaBudSltPrcVOs, BsaBudSltPrcCrrVO[] bsaBudSltPrcCrrVOs, SignOnUserAccount account) throws EventException;
	
	//===============================================================================
	// ESM_BSA_0042: BSA Inquiry by VVD(Yearly Plan)
	//=============================================================================== 
	/**
	 * 
	 * @param     BsaYearlyPlanConditionVO
	 * @return    CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchTEUPrcSwapVvdList(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO) throws EventException;
	
	/**
	 * ESM_BSA_0042화면의 조회 이벤트를 처리한다.(수입/비용)<br>
	 * 
	 * @param BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO
	 * @return CommonBsaRsVO
	 * @exception EventException
	 */
	public CommonBsaRsVO searchRevCostSwapVvdList(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO) throws EventException;
	
	//===============================================================================
	// ESM_BSA_0043: Target VVD(Yearly Plan)
	//=============================================================================== 	
	/**
	 * Target VVD 정보를 조회한다.
	 * 
	 * @param ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO
	 * @return List<RsltCoaMonVvdYryPlnVO>
	 * @exception EventException
	 */
	public List<RsltCoaMonVvdYryPlnVO> searchYearlyPlanTargetVVDList(ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO) throws EventException;
	
	
	/**
     * 대상항차화면에 대한 배치를 실행한다.<br>
     * 
     * @param ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
	public String createYearlyPlanTargetVVD(ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO, SignOnUserAccount account) throws EventException;
    	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String searchBackEndJobVO(String object) throws EventException;
	//===============================================================================
	// ESM_BSA_0044: BSA Creation/Update(Yearly Plan) [Create] PopUp
	//=============================================================================== 
	/**
	 * @param BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createBSABatch(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO, SignOnUserAccount account) throws EventException;
	
	//===============================================================================
	// ESM_BSA_0045: BSA Data I/F PopUp
	//===============================================================================
	/**
	 * @param BsaTableSaveVO[] bsaTableSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void interfaceBSAJO(BsaTableSaveVO[] bsaTableSaveVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param BsaTableSaveVO[] bsaTableSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void interfaceBSASC(BsaTableSaveVO[] bsaTableSaveVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * @param BsaTableSaveVO[] bsaTableSaveVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void interfaceSlotCost(BsaTableSaveVO[] bsaTableSaveVOs, SignOnUserAccount account) throws EventException;

}