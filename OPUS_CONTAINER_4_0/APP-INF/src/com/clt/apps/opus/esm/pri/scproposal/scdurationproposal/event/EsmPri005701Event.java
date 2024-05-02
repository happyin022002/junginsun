/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri005701Event.java
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.18 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpDurVO;


/**
 * ESM_PRI_0057_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0057_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0057_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri005701Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 저장시 사용되는 커스텀 VO */
	private PriSpScpDurVO priSpScpDurVO = null;

	public PriSpScpDurVO getPriSpScpDurVO() {
		return priSpScpDurVO;
	}

	public void setPriSpScpDurVO(PriSpScpDurVO priSpScpDurVO) {
		this.priSpScpDurVO = priSpScpDurVO;
	}


	

}