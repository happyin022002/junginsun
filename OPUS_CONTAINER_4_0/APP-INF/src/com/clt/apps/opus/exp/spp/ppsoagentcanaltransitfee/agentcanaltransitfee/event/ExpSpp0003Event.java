/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpSpp0003Event.java
*@FileTitle : Request Actual Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.07.27 김성광
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event;

import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdCondVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PsoCnlTzFeeDtlVO;
import com.clt.syscommon.common.table.PsoCnlTzFeeVO;


/**
 * EXP_SPP_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EXP_SPP_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seong Kwang
 * @see EXP_SPP_0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class ExpSpp0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoCnlTzFeeVO psoCnlTzFeeVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoCnlTzFeeDtlVO psoCnlTzFeeDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoCnlTzFeeDtlVO[] psoCnlTzFeeDtlVOs = null;	

	/*조회조건 VO*/
	private CanalTzFeeEstDtlByVvdCondVO canalTzFeeEstDtlByVvdCondVO;
	
	public ExpSpp0003Event(){}
	

	public void setPsoCnlTzFeeDtlVO(PsoCnlTzFeeDtlVO psoCnlTzFeeDtlVO){
		this. psoCnlTzFeeDtlVO = psoCnlTzFeeDtlVO;
	}

	public void setPsoCnlTzFeeDtlVOS(PsoCnlTzFeeDtlVO[] psoCnlTzFeeDtlVOs){
		this. psoCnlTzFeeDtlVOs = psoCnlTzFeeDtlVOs;
	}

	public PsoCnlTzFeeDtlVO getPsoCnlTzFeeDtlVO(){
		return psoCnlTzFeeDtlVO;
	}

	public PsoCnlTzFeeDtlVO[] getPsoCnlTzFeeDtlVOS(){
		return psoCnlTzFeeDtlVOs;
	}
	
	public void setPsoCnlTzFeeVO(PsoCnlTzFeeVO psoCnlTzFeeVO){
		this. psoCnlTzFeeVO = psoCnlTzFeeVO;
	}
	
	public PsoCnlTzFeeVO getPsoCnlTzFeeVO(){
		return psoCnlTzFeeVO;
	}
	
	/**
	 * 메인 조회 조건 
	 * @category EXP_SPP_0003_searchcond_voset
	 * @param vo
	 */
	public void setCanalTzFeeEstDtlByVvdCondVO(CanalTzFeeEstDtlByVvdCondVO vo) {
		// TODO Auto-generated method stub
		this.canalTzFeeEstDtlByVvdCondVO = vo;
	}
	
	/**
	 * 조회조건 VO Getter
	 * @return
	 */
	public CanalTzFeeEstDtlByVvdCondVO getCanalTzFeeEstDtlByVvdCondVO() {
		return canalTzFeeEstDtlByVvdCondVO;
	}	

}