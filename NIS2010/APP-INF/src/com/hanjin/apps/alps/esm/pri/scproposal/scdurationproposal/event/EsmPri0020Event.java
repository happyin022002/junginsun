/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0020Event.java
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.13 변영주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scdurationproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;


/**
 * ESM_PRI_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0020HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpDurVO priSpScpDurVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpDurVO[] priSpScpDurVOs = null;

	public EsmPri0020Event(){}
	
	public void setPriSpScpDurVO(PriSpScpDurVO priSpScpDurVO){
		this. priSpScpDurVO = priSpScpDurVO;
	}

	public void setPriSpScpDurVOS(PriSpScpDurVO[] priSpScpDurVOs){
		this. priSpScpDurVOs = priSpScpDurVOs;
	}

	public PriSpScpDurVO getPriSpScpDurVO(){
		return priSpScpDurVO;
	}

	public PriSpScpDurVO[] getPriSpScpDurVOS(){
		return priSpScpDurVOs;
	}

}