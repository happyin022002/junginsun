/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1021Event.java
 *@FileTitle : Integrated Customer Data Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.08
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.07.08 손윤석
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgArrNtcWdVO;

/**
 * esm_bkg_1021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see ESM_BKG_0052HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1021Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private BkgArrNtcWdVO bkgArrNtcWdVO = null;

	public EsmBkg1021Event() {
	}


	/**
	 * @param bkgArrNtcWdVO the bkgArrNtcWdVO to set
	 */
	public void setBkgArrNtcWdVO(BkgArrNtcWdVO bkgArrNtcWdVO) {
		this.bkgArrNtcWdVO = bkgArrNtcWdVO;
	}


	/**
	 * @return the bkgArrNtcWdVO
	 */
	public BkgArrNtcWdVO getBkgArrNtcWdVO() {
		return bkgArrNtcWdVO;
	}
}