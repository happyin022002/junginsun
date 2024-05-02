/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpSpp0004Event.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.07.30 김성광
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event;

import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaBalVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaDisbVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaRemVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PsoMsaDtlVO;
import com.clt.syscommon.common.table.PsoMsaVO;


/**
 * EXP_SPP_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EXP_SPP_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seong Kwang
 * @see EXP_SPP_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class ExpSpp0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private MsaBalVO msaBalVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private MsaBalVO[] msaBalVOs = null;	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaVO psoMsaVO = null;
	/** Table Value Object Multi Data 처리 */
	private PsoMsaVO[] psoMsaVOs = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaDtlVO psoMsaDtlVO = null;
	/** Table Value Object Multi Data 처리 */
	private PsoMsaDtlVO[] psoMsaDtlVOs = null;	
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private MsaRemVO msaRemVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */	
	private MsaDisbVO msaDisbVO = null;	
	
	public ExpSpp0004Event(){}	
	

	public void setMsaBalVO(MsaBalVO msaBalVO) {
		this.msaBalVO = msaBalVO;
	}
	
	public MsaRemVO getMsaRemVO() {
		return this.msaRemVO ; 
	}
	
	public void setMsaDisbVO(MsaDisbVO msaDisbVO) {
		this.msaDisbVO = msaDisbVO;
	}
	
	public MsaDisbVO getMsaDisbVO() {
		return this.msaDisbVO ; 
	}
	
	public void setMsaRemVO(MsaRemVO msaRemVO) {
		this.msaRemVO = msaRemVO;
	}	
	
	public MsaBalVO getMsaBalVO() {
		return this.msaBalVO ; 
	}	
	
	public void setMsaBalVOS(MsaBalVO[] msaBalVOs) {
		this.msaBalVOs = msaBalVOs;
	}
	
	public MsaBalVO[] getMsaBalVOS() {
		return this.msaBalVOs ; 
	}	
	
	public void setPsoMsaVO(PsoMsaVO psoMsaVO){
		this. psoMsaVO = psoMsaVO;
	}

	public void setPsoMsaVOS(PsoMsaVO[] psoMsaVOs){
		this. psoMsaVOs = psoMsaVOs;
	}

	public void setPsoMsaDtlVO(PsoMsaDtlVO psoMsaDtlVO){
		this. psoMsaDtlVO = psoMsaDtlVO;
	}

	public void setPsoMsaDtlVOS(PsoMsaDtlVO[] psoMsaDtlVOs){
		this. psoMsaDtlVOs = psoMsaDtlVOs;
	}

	public PsoMsaVO getPsoMsaVO(){
		return psoMsaVO;
	}

	public PsoMsaVO[] getPsoMsaVOS(){
		return psoMsaVOs;
	}

	public PsoMsaDtlVO getPsoMsaDtlVO(){
		return psoMsaDtlVO;
	}

	public PsoMsaDtlVO[] getPsoMsaDtlVOS(){
		return psoMsaDtlVOs;
	}
}