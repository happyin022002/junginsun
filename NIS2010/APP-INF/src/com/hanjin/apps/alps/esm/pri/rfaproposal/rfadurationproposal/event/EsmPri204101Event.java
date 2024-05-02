/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri204101Event.java
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.18 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpDurVO;


/**
 * ESM_PRI_2041_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2041_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_2041_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri204101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 저장시 사용되는 커스텀 VO */
	private PriRpScpDurVO priRpScpDurVO = null;

	public PriRpScpDurVO getPriRpScpDurVO() {
		return priRpScpDurVO;
	}

	public void setPriRpScpDurVO(PriRpScpDurVO priRpScpDurVO) {
		this.priRpScpDurVO = priRpScpDurVO;
	}


	

}