/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1099Event.java
 *@FileTitle : Add Concerned Party Pop-up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 곽영범
 *@LastVersion : 1.0
 * 2010.07.26 곽영범
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgIbCustCntcStupVO;

/**
 * esm_bkg_1099 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see ESM_BKG_1099HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1099Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private BkgIbCustCntcStupVO bkgIbCustCntcStupVO = null;

	public EsmBkg1099Event() {
	}

	/**
	 * @return the bkgIbCustCntcStupVO
	 */
	public BkgIbCustCntcStupVO getBkgIbCustCntcStupVO() {
		return bkgIbCustCntcStupVO;
	}

	/**
	 * @param bkgIbCustCntcStupVO the bkgIbCustCntcStupVO to set
	 */
	public void setBkgIbCustCntcStupVO(BkgIbCustCntcStupVO bkgIbCustCntcStupVO) {
		this.bkgIbCustCntcStupVO = bkgIbCustCntcStupVO;
	}


		
}