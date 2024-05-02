/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0052Event.java
 *@FileTitle : Integrated Customer Data Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 박성호
 *@LastVersion : 1.0
 * 2009.05.20 박성호
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MrnRtnYdVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Chang June
 * @see ESM_BKG_0052HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0052Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private MrnRtnYdVO mrnRtnYdVO = null;

	/** Table Value Object Multi Data 처리 */
	private MrnRtnYdVO[] mrnRtnYdVOs = null;

	public EsmBkg0052Event() {
	}

	public MrnRtnYdVO getMrnRtnYdVO() {
		return mrnRtnYdVO;
	}

	public void setMrnRtnYdVO(MrnRtnYdVO mrnRtnYdVO) {
		this.mrnRtnYdVO = mrnRtnYdVO;
	}

	public MrnRtnYdVO[] getMrnRtnYdVOs() {
		return mrnRtnYdVOs;
	}

	public void setMrnRtnYdVOs(MrnRtnYdVO[] mrnRtnYdVOs) {
		this.mrnRtnYdVOs = mrnRtnYdVOs;
	}

}