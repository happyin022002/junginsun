/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpSpp0005Event.java
*@FileTitle : Canal booking status for Panama
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.12 김성광
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event;

import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzBkgVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PsoTgtVvdVO;


/**
 * EXP_SPP_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EXP_SPP_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seong Kwang
 * @see EXP_SPP_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class ExpSpp0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoTgtVvdVO psoTgtVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoTgtVvdVO[] psoTgtVvdVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CanalTzBkgVvdVO canalTzBkgVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CanalTzBkgVvdVO[] canalTzBkgVvdVOs = null;	
	
	public ExpSpp0005Event(){}
	
	public void setPsoTgtVvdVO(PsoTgtVvdVO psoTgtVvdVO){
		this. psoTgtVvdVO = psoTgtVvdVO;
	}

	public void setPsoTgtVvdVOS(PsoTgtVvdVO[] psoTgtVvdVOs){
		this. psoTgtVvdVOs = psoTgtVvdVOs;
	}

	public PsoTgtVvdVO getPsoTgtVvdVO(){
		return psoTgtVvdVO;
	}

	public PsoTgtVvdVO[] getPsoTgtVvdVOS(){
		return psoTgtVvdVOs;
	}
	
	public void setCanalTzBkgVvdVO(CanalTzBkgVvdVO canalTzBkgVvdVO) {
		this.canalTzBkgVvdVO = canalTzBkgVvdVO;
	}	

	public CanalTzBkgVvdVO getCanalTzBkgVvdVO() {
		// TODO Auto-generated method stub
		return this.canalTzBkgVvdVO ;
	}
	
	public void setCanalTzBkgVvdVOS(CanalTzBkgVvdVO[] canalTzBkgVvdVOs){
		this. canalTzBkgVvdVOs = canalTzBkgVvdVOs;
	}	
	
	public CanalTzBkgVvdVO[] getCanalTzBkgVvdVOS(){
		return canalTzBkgVvdVOs;
	}	

}