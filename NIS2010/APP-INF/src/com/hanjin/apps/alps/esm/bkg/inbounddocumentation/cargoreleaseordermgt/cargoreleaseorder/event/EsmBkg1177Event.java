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
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoVtyDtUpdHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.ESM_BKG_1099HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_1177 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1177HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Park Chang June
 * @see ESM_BKG_1099HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class EsmBkg1177Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private DoVtyDtUpdHisVO doVtyDtUpdHisVO = null;

	public EsmBkg1177Event() {
	}

	/**
	 * @return the doVtyDtUpdHisVO
	 */
	public DoVtyDtUpdHisVO getDoVtyDtUpdHisVO() {
		return doVtyDtUpdHisVO;
	}

	/**
	 * @param bkgIbCustCntcStupVO the bkgIbCustCntcStupVO to set
	 */  
	public void setDoVtyDtUpdHisVO(DoVtyDtUpdHisVO doVtyDtUpdHisVO) {
		this.doVtyDtUpdHisVO = doVtyDtUpdHisVO;
	}


		
}