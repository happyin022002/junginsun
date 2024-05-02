/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PPSOAgentCanalTransitFeeBC.java
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.basic;

import java.util.List;

import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTransitScheduleVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzAllowanceTEUVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzBkgVvdVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeInvDtlByVvdVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeSumVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzInvAllowanceTEUVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzVVDListVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaBalVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaDisbVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaRemVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.PsoCanalInvAttachFileVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PsoCnlTzFeeDtlVO;
import com.clt.syscommon.common.table.PsoCnlTzFeeVO;
import com.clt.syscommon.common.table.PsoMsaVO;

/**
 * ALPS-PPSOAgentCanalTransitFee Business Logic Command Interface<br>
 * - The interface of the business logic about ALPS-PPSOAgentCanalTransitFee<br>
 *
 * @author 
 * @see Exp_Spp_0001EventResponse 
 * @since J2EE 1.6
 */

public interface AgentCanalTransitFeeBC {
	
	/**
	 * Retrieving Canal Invoice
	 * 
	 * @param CanalTzFeeSumVO canalTzFeeSumVO
	 * @return List<CanalTzFeeSumVO>
	 * @exception EventException
	 */
	public List<CanalTzFeeSumVO> searchCanalTzFeeSumRpt(CanalTzFeeSumVO canalTzFeeSumVO) throws EventException;	
	
	/**
	 * Retrieving VVD
	 * 
	 * @param CanalTzVVDListVO canalTzVVDListVO
	 * @return List<CanalTzVVDListVO>
	 * @exception EventException 
	 */
	public List<CanalTzVVDListVO> searchCanalTzVVDList(CanalTzVVDListVO canalTzVVDListVO) throws EventException;
	
	/**
	 * Requested Advanced Payment windows_open
	 * @category EXP_SPP_0002_windowopen
	 * @param canalTzFeeEstDtlByVvdCondVO
	 * @return List<CanalTzFeeEstDtlByVvdVO>
	 * @exception EventException 
	 */	
	public List<CanalTzFeeEstDtlByVvdVO> searchCanalTzFeeEstDtlByVvd(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException;
	
	/**
	 * Requested Advanced Payment windows_open allowance TEU
	 *
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return CanalTzAllowanceTEUVO
	 * @exception EventException 
	 */	
	public CanalTzAllowanceTEUVO searchCanalTzAllowanceTEU(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException;	
	
	/**
	 * Saving or requesting CanalTzFee by VVD
	 * 
	 * @param PsoCnlTzFeeVO psoCnlTzFeeVO
	 * @param PsoCnlTzFeeDtlVO[] psoCnlTzFeeDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void manageCanalTzFeeByVvd(PsoCnlTzFeeVO psoCnlTzFeeVO, PsoCnlTzFeeDtlVO[] psoCnlTzFeeDtlVOs, SignOnUserAccount account) throws EventException;	
	
		
	
	/**
	 * Retrieving Request Actual Invoice by VVD
	 *
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<CanalTzFeeInvDtlByVvdVO>
	 * @exception EventException 
	 */	
	public List<CanalTzFeeInvDtlByVvdVO> searchCanalTzFeeInvDtlByVvd(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException;
	
	/**
	 * Retrieving Request Actual Invoice allowance TEU
	 *
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return CanalTzInvAllowanceTEUVO
	 * @exception EventException 
	 */	
	public CanalTzInvAllowanceTEUVO searchCanalTzInvAllowanceTEU(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException;	
	
	/**
	 * Retrieving MSA Balance
	 * 
	 * @param MsaBalVO msaBalVO
	 * @return List<MsaBalVO>
	 * @exception EventException
	 */
	public List<MsaBalVO> searchMsaBal(MsaBalVO msaBalVO) throws EventException;  	
	
	/**
	 * Saving or requesting MSA Balance<br>
	 * 
	 * @param PsoMsaVO psoMsaVO
	 * @param MsaBalVO[] msaBalVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void manageMsaBal(PsoMsaVO psoMsaVO, MsaBalVO[] msaBalVOs, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Retrieving MSA Remittance
	 *
	 * @param MsaRemVO msaRemVO
	 * @return List<MsaRemVO>
	 * @exception EventException
	 */
	public List<MsaRemVO> searchMsaRem(MsaRemVO msaRemVO) throws EventException;  	
	
	/**
	 * Retrieving MSA Disbursement
	 *
	 * @param MsaDisbVO msaDisbVO
	 * @return List<MsaDisbVO>
	 * @exception EventException
	 */
	public List<MsaDisbVO> searchMsaDisb(MsaDisbVO msaDisbVO) throws EventException; 	
	
	/**
	 * Retrieving Canal booking status for Panama
	 *
	 * @param CanalTzBkgVvdVO canalTzBkgVvdVO
	 * @return List<CanalTzBkgVvdVO>
	 * @exception EventException
	 */
	public List<CanalTzBkgVvdVO> searchCanalTzBkgVvd(CanalTzBkgVvdVO canalTzBkgVvdVO) throws EventException; 	
	
	/**
	 * Saving Canal booking status for Panama<br>
	 * 
	 * @param CanalTzBkgVvdVO[] canalTzBkgVvdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void manageCanalTzBkgList(CanalTzBkgVvdVO[] canalTzBkgVvdVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Canal Transit schedule 조회<br>
	 * 
	 * @param CanalTzBkgVvdVO canalTzBkgVvdVO
	 * @return List<CanalTzBkgVvdVO>
	 * @exception EventException
	 */	
	public List<CanalTransitScheduleVO> searchCanalTransitSchedule(CanalTransitScheduleVO canalTransitScheduleVO) throws EventException;
	
	/**
	 * Canal Transit Attach File list 조회<br>
	 * 
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<PsoCanalInvAttachFileVO>
	 * @exception EventException
	 */	
	public List<PsoCanalInvAttachFileVO> searchPsoCanalInvAttachFileList(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException;
	
}