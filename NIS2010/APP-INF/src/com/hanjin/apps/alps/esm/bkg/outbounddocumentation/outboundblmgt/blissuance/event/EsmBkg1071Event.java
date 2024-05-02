/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1071Event.java
*@FileTitle : Multi Fax / E-Mail Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : Ilmin Lee
*@LastVersion : 1.0
* 2009.11.05 Ilmin Lee
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MultiNtcHisVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1071 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ilmin Lee
 * @see ESM_BKG_1071HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1071Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private MultiNtcHisVO multiNtcHisVO;
	private MultiNtcHisVO[] multiNtcHisVOs;

	public MultiNtcHisVO getMultiNtcHisVO() {
		return multiNtcHisVO;
	}
	public void setMultiNtcHisVO(MultiNtcHisVO multiNtcHisVO) {
		this.multiNtcHisVO = multiNtcHisVO;
	}
	public MultiNtcHisVO[] getMultiNtcHisVOs() {
		return multiNtcHisVOs;
	}
	public void setMultiNtcHisVOs(MultiNtcHisVO[] multiNtcHisVOs) {
		this.multiNtcHisVOs = multiNtcHisVOs;
	}

}
