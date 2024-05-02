/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1018Event.java
 *@FileTitle : Integrated Customer Data Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.13
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.07.13 손윤석
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.ESM_BKG_0052HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgFullCntrRemarkVO;

/**
 * esm_bkg_1018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see ESM_BKG_0052HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1052Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	
	private BkgFullCntrRemarkVO bkgFullCntrRemarkVO = null;

	public EsmBkg1052Event() {
	}

	public BkgFullCntrRemarkVO getBkgFullCntrRemarkVO() {
		return bkgFullCntrRemarkVO;
	}

	public void setBkgFullCntrRemarkVO(BkgFullCntrRemarkVO bkgFullCntrRemarkVO) {
		this.bkgFullCntrRemarkVO = bkgFullCntrRemarkVO;
	}
}