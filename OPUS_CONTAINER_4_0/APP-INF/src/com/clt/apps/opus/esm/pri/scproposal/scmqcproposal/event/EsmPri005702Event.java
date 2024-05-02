/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri005702Event.java
*@FileTitle : Amendment History Inquiry - MQC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier :  공백진
*@LastVersion : 1.0
* 2009.09.09 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpMqcVO;


/**
 * ESM_PRI_005702 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_005702HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0057_02HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri005702Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회시 사용되는 커스텀 VO */
	private PriSpScpMqcVO priSpScpMqcVO = null;

	public PriSpScpMqcVO getPriSpScpMqcVO() {
		return priSpScpMqcVO;
	}

	public void setPriSpScpMqcVO(PriSpScpMqcVO priSpScpMqcVO) {
		this.priSpScpMqcVO = priSpScpMqcVO;
	}	
	
	

}