/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1044Event.java
 *@FileTitle : Add Concerned Party Pop-up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.07.20 손윤석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgIbCmdtCntcVO;

/**
 * esm_bkg_1044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Chang June
 * @see ESM_BKG_1044HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1044Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private BkgIbCmdtCntcVO bkgIbCmdtCntcVO = null;
	private BkgIbCmdtCntcVO[] bkgIbCmdtCntcVOs = null;

	public EsmBkg1044Event() {
	}


	/**
	 * @return the bkgIbCmdtCntcVO
	 */
	public BkgIbCmdtCntcVO getBkgIbCmdtCntcVO() {
		return bkgIbCmdtCntcVO;
	}


	/**
	 * @param bkgIbCmdtCntcVO the bkgIbCmdtCntcVO to set
	 */
	public void setBkgIbCmdtCntcVO(BkgIbCmdtCntcVO bkgIbCmdtCntcVO) {
		this.bkgIbCmdtCntcVO = bkgIbCmdtCntcVO;
	}


	/**
	 * @return the bkgIbCmdtCntcVOs
	 */
	public BkgIbCmdtCntcVO[] getBkgIbCmdtCntcVOs() {
		return bkgIbCmdtCntcVOs;
	}


	/**
	 * @param bkgIbCmdtCntcVOs the bkgIbCmdtCntcVOs to set
	 */
	public void setBkgIbCmdtCntcVOs(BkgIbCmdtCntcVO[] bkgIbCmdtCntcVOs) {
		this.bkgIbCmdtCntcVOs = bkgIbCmdtCntcVOs;
	}
	
	
}