/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0252Event.java
*@FileTitle : Empty Container Release Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.16 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdInVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0252 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0252HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see ESM_BKG_0252HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0861Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyRlseOrdInVO mtyRlseOrdInVO = null;


	public EsmBkg0861Event(){}


	public MtyRlseOrdInVO getMtyRlseOrdInVO() {
		return mtyRlseOrdInVO;
	}


	public void setMtyRlseOrdInVO(MtyRlseOrdInVO mtyRlseOrdInVO) {
		this.mtyRlseOrdInVO = mtyRlseOrdInVO;
	}
}