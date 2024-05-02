/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0703Event.java
*@FileTitle : Berth window input 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.01 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VskPortFltgCrnVO;


/**
 * VOP_VSK_0703 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0703HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Suk Hyun
 * @see VOP_VSK_0703HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0703Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskPortFltgCrnVO vskPortFltgCrnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskPortFltgCrnVO[] vskPortFltgCrnVOs = null;

	public VopVsk0703Event(){}
	
	public void setVskPortFltgCrnVO(VskPortFltgCrnVO vskPortFltgCrnVO){
		this. vskPortFltgCrnVO = vskPortFltgCrnVO;
	}

	public void setVskPortFltgCrnVOS(VskPortFltgCrnVO[] vskPortFltgCrnVOs){
		if(vskPortFltgCrnVOs != null){
			VskPortFltgCrnVO[] tmpVOs = Arrays.copyOf(vskPortFltgCrnVOs, vskPortFltgCrnVOs.length);
			this.vskPortFltgCrnVOs = tmpVOs;
		}
	}

	public VskPortFltgCrnVO getVskPortFltgCrnVO(){
		return vskPortFltgCrnVO;
	}

	public VskPortFltgCrnVO[] getVskPortFltgCrnVOS(){
		VskPortFltgCrnVO[] rtnVOs = null;
		if (this.vskPortFltgCrnVOs != null) {
			rtnVOs = Arrays.copyOf(vskPortFltgCrnVOs, vskPortFltgCrnVOs.length);
		}
		return rtnVOs;
	}

}