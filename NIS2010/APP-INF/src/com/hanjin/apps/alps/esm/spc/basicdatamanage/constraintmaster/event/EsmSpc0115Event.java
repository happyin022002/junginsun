/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmSpc0115Event.java
*@FileTitle : Constraint Mastertable
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : Seung-Man KIM
*@LastVersion : 1.0
* 2015.01.23 Arie
* 1.0 Creation
* * Cr반영용
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SpcAlocMgmtVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0115 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0115HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Arie
 * @see ESM_SPC_0115HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0115Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	/** Table Value Object 조회 조건 및 단건 처리 */
    private SpcAlocMgmtVO      spcAlocMgmtVO     = null;
    private SpcAlocMgmtVO[]    spcAlocMgmtVOs    = null;

	public EsmSpc0115Event(){}

	public SpcAlocMgmtVO getSpcAlocMgmtVO() {
		return spcAlocMgmtVO;
	}

	public void setSpcAlocMgmtVO(SpcAlocMgmtVO spcAlocMgmtVO) {
		this.spcAlocMgmtVO = spcAlocMgmtVO;
	}

	public SpcAlocMgmtVO[] getSpcAlocMgmtVOs() {
		return spcAlocMgmtVOs;
	}

	public void setSpcAlocMgmtVOs(SpcAlocMgmtVO[] spcAlocMgmtVOs) {
		this.spcAlocMgmtVOs = spcAlocMgmtVOs;
	}


}