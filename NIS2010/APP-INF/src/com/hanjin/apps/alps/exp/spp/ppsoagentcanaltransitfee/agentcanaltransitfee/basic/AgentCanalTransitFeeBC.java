/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PPSOAgentCanalTransitFeeBC.java
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.07.15 김성광
* 1.0 Creation
*  
* History
* 2012.02.17 박연진 CHM-201216307 SPP 및 PSO내 Canal invoice 화면 변경 및 File upload 기능 개발 
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.basic;

import java.util.List;

import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTransitScheduleVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzAllowanceTEUVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzBkgVvdVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeInvDtlByVvdVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeSumVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzInvAllowanceTEUVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzVVDListVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaBalVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaDisbVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaRemVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.PsoCanalInvAttachFileVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PsoCnlTzAtchFileVO;
import com.hanjin.syscommon.common.table.PsoCnlTzFeeDtlVO;
import com.hanjin.syscommon.common.table.PsoCnlTzFeeVO;
import com.hanjin.syscommon.common.table.PsoMsaVO;

/**
 * ALPS-PPSOAgentCanalTransitFee Business Logic Command Interface<br>
 * - ALPS-PPSOAgentCanalTransitFee 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Seong Kwang
 * @see Exp_Spp_0001EventResponse 참조
 * @since J2EE 1.6
 */

public interface AgentCanalTransitFeeBC {
	
	/**
	 * Canal Invoice 조회
	 * 
	 * @param CanalTzFeeSumVO canalTzFeeSumVO
	 * @return List<CanalTzFeeSumVO>
	 * @exception EventException
	 */
	public List<CanalTzFeeSumVO> searchCanalTzFeeSumRpt(CanalTzFeeSumVO canalTzFeeSumVO) throws EventException;	
	
	/**
	 * VVD 조회
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
	 * CanalTzFee by VVD 저장
	 * 
	 * @param PsoCnlTzFeeVO psoCnlTzFeeVO
	 * @param PsoCnlTzFeeDtlVO[] psoCnlTzFeeDtlVOs
	 * @param PsoCnlTzAtchFileVO[] psoCnlTzAtchFileVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void manageCanalTzFeeByVvd(PsoCnlTzFeeVO psoCnlTzFeeVO, PsoCnlTzFeeDtlVO[] psoCnlTzFeeDtlVOs, PsoCnlTzAtchFileVO[] psoCnlTzAtchFileVOs, SignOnUserAccount account) throws EventException;	
	
		
	
	/**
	 * Request Actual Invoice windows_open
	 *
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return List<CanalTzFeeInvDtlByVvdVO>
	 * @exception EventException 
	 */	
	public List<CanalTzFeeInvDtlByVvdVO> searchCanalTzFeeInvDtlByVvd(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException;
	
	/**
	 * Request Actual Invoice windows_open allowance TEU
	 *
	 * @param CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO
	 * @return CanalTzInvAllowanceTEUVO
	 * @exception EventException 
	 */	
	public CanalTzInvAllowanceTEUVO searchCanalTzInvAllowanceTEU(CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO) throws EventException;	
	
	/**
	 * MSA Balance 조회
	 * 
	 * @param MsaBalVO msaBalVO
	 * @return List<MsaBalVO>
	 * @exception EventException
	 */
	public List<MsaBalVO> searchMsaBal(MsaBalVO msaBalVO) throws EventException;  	
	
	/**
	 * Msa Balance Save/Request<br>
	 * 
	 * @param PsoMsaVO psoMsaVO
	 * @param MsaBalVO[] msaBalVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void manageMsaBal(PsoMsaVO psoMsaVO, MsaBalVO[] msaBalVOs, SignOnUserAccount account) throws EventException;	
	
	/**
	 * MSA Remittance 조회
	 *
	 * @param MsaRemVO msaRemVO
	 * @return List<MsaRemVO>
	 * @exception EventException
	 */
	public List<MsaRemVO> searchMsaRem(MsaRemVO msaRemVO) throws EventException;  	
	
	/**
	 * MSA Disbursement 조회
	 *
	 * @param MsaDisbVO msaDisbVO
	 * @return List<MsaDisbVO>
	 * @exception EventException
	 */
	public List<MsaDisbVO> searchMsaDisb(MsaDisbVO msaDisbVO) throws EventException; 	
	
	/**
	 * Canal booking status for Panama 조회
	 *
	 * @param CanalTzBkgVvdVO canalTzBkgVvdVO
	 * @return List<CanalTzBkgVvdVO>
	 * @exception EventException
	 */
	public List<CanalTzBkgVvdVO> searchCanalTzBkgVvd(CanalTzBkgVvdVO canalTzBkgVvdVO) throws EventException; 	
	
	/**
	 * Canal booking status for Panama Save 저장<br>
	 * 
	 * @param CanalTzBkgVvdVO[] canalTzBkgVvdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void manageCanalTzBkgList(CanalTzBkgVvdVO[] canalTzBkgVvdVOs, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Canal Transit schedule 조회<br>
	 * 
	 * @param CanalTransitScheduleVO canalTransitScheduleVO
	 * @return List<CanalTransitScheduleVO>
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
	
	/**
	 * Canal booking status for Panama Save 저장<br>
	 * 
	 * @param CanalTzBkgVvdVO[] canalTzBkgVvdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException 
	 */
	public void manageCanalTransitBookingList(CanalTransitScheduleVO[] canalTransitScheduleVOs, SignOnUserAccount account) throws EventException;	
}