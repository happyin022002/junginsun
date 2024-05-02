/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PreCMSimulationBC.java
*@FileTitle : Inquiry the report 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.basic;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.vo.TrfChgVO;

/**
 * OPUS-COA Business Logic Command Interface<br>
 * - OPUS-COA에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Sangwook_nam
 * @see 
 * @since J2EE 1.6
 */
public interface PreCMSimulationBC  {
	
	/**
	 * (CMTX)Route Cost Inqiury <br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param TrfChgVO[] trfChgVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchBKG4006List(SearchConditionVO searchConditionVO, TrfChgVO[] trfChgVO) throws EventException;
	
	/**
	 * Inquiry by BKG Cost Remark]<br>
	 * About the ESM_COA_4007, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return list List<SearchBkgRmk4007ListVO> 
	 * @throws EventException
	 */
	public CommonCoaRsVO searchBkgRemarkList4007(SearchConditionVO searchConditionVO) throws EventException;	
	
	/**
     * ESM_COA_0153 비용 생성<br>
     * 
     * @param AplyRtInVO aplyRtInVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
	public String createPreCMSimulation(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String searchBackEndJobStatus(String object) throws EventException;
}