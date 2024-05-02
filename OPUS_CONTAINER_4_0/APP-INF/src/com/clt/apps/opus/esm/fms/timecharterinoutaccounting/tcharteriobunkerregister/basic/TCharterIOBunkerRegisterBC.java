/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITCharterIOBunkerRegisterBC.java
*@FileTitle : BunkerDataManagement
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.ContractByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.CustomBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerConditionVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchIdVslCdByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchVvdByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;

/**
 * OPUS-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - OPUS-Timecharterinoutaccounting Biz Logic Interface<br>
 *
 * @author 
 * @see Esm_Fms_0050EventResponse 
 * @since J2EE 1.5
 */

public interface TCharterIOBunkerRegisterBC {
	
	/**
	 * Getting Bunker information<br>
	 * 
	 * @param searchBunkerVO SearchBunkerVO
	 * @return List<SearchBunkerVO>
	 * @exception EventException
	 */
	public List<SearchBunkerVO> searchBunkerList(SearchBunkerVO searchBunkerVO) throws EventException;
	
	/**
	 * Handling Multi-events of Bunker window(Insert/Modify/Delete)<br>
	 * 
	 * @param customBunkerVOs CustomBunkerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageBunker(CustomBunkerVO[] customBunkerVOs, String usrId) throws EventException;
	
	/**
	 * Getting VslCd relevant to Contract Number
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchIdVslCdByBunkerVO>
	 * @exception EventException
	 */
	public List<SearchIdVslCdByBunkerVO> searchIdVslCdListByBunker(String fletCtrtNo) throws EventException;
	
	/**
	 * Getting Voyage relevant to vslCd and bnkDt<br>
	 * 
	 * @param vslCd String
	 * @param bunkerDt String
	 * @param fletCtrtNo String
	 * @return List<SearchVvdByBunkerVO>
	 * @exception EventException
	 */
	public List<SearchVvdByBunkerVO> searchVvdListByBunker(String vslCd, String bunkerDt, String fletCtrtNo) throws EventException;
	
	/**
	 * Getting Location Code<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCdByBunker(String locCd) throws EventException;
	
	/**
	 * Getting Data to be updated at Contract table from Bunker table<br>
	 * 
	 * @param fletCtrtNo String 
	 * @param bnkYrmon String 
	 * @return List<ContractByBunkerVO>
	 * @exception EventException
	 */
	public List<ContractByBunkerVO> searchContractByBunker(String fletCtrtNo, String bnkYrmon) throws EventException;
	
	/**
	 * Updating Invoice table after generating Slip<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param slpSerNo String
	 * @exception EventException
	 */
	public void modifyPaymentSlipBunkers(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, String slpSerNo) throws EventException;
	
	/**
	 * In case of Charter, Slip information of Bunker is updated as Null when Slip is canceled <br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipApprovalCancelBunker(String csrNo, String usrId) throws EventException;

	/**
	 * In case of AP, AR Hire Out, Slip information of Bunker is updated as Null when Slip is canceled<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyApArSlipApprovalCancelBunker(String csrNo, String usrId) throws EventException;
	
	/**
	 * Modifying related list at Calculation table when Hire Out Slip is generated<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @exception EventException
	 */
	public void modifySubletRevenueSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException;
	
	/**
	 * Retrieving the data which is selected to be handled as payment slip on created BOD / BOR Data / Window<br>
	 * 
	 * NYK Modify 2014.10.22
	 * @param searchBunkerConditionVO SearchBunkerConditionVO
	 * @return List<SearchBunkerListByPaymentSlipVO>
	 * @throws EventException
	 */
	public List<SearchBunkerListByPaymentSlipVO> searchBunkerListByPaymentSlip(SearchBunkerConditionVO searchBunkerConditionVO) throws EventException;
	
}