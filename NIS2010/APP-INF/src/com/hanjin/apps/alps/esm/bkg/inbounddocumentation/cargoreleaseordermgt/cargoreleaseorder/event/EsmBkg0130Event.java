/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0130Event.java
 *@FileTitle : Integrated Customer Data Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.17
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.08.17 손윤석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0130 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0130HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Son Yun Seuk
 * @see ESM_BKG_0130HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0130Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private DoRcvrInfoVO doRcvrInfoVO = null;

	public EsmBkg0130Event() {
	}

	public DoRcvrInfoVO getDoRcvrInfoVO() {
		return doRcvrInfoVO;
	}

	public void setDoRcvrInfoVO(DoRcvrInfoVO doRcvrInfoVO) {
		this.doRcvrInfoVO = doRcvrInfoVO;
	}
}