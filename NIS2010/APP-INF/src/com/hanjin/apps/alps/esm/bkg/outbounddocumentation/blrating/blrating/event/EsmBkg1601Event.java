/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1601Event.java
*@FileTitle : Audit by CNTR Qty Discrepancy
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.07 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRequestListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1601 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1601HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_1601HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1601Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeAmendAuthRequestListVO chargeAmendAuthRequestListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ChargeAmendAuthRequestListVO[] chargeAmendAuthRequestListVOs = null;

	
	public void setChargeAmendAuthRequestListVO(ChargeAmendAuthRequestListVO chargeAmendAuthRequestListVO){
		this. chargeAmendAuthRequestListVO = chargeAmendAuthRequestListVO;
	}

	public void setChargeAmendAuthRequestListVOs(ChargeAmendAuthRequestListVO[] chargeAmendAuthRequestListVOs){
		this. chargeAmendAuthRequestListVOs = chargeAmendAuthRequestListVOs;
	}

	public ChargeAmendAuthRequestListVO getChargeAmendAuthRequestListVO(){
		return chargeAmendAuthRequestListVO;
	}

	public ChargeAmendAuthRequestListVO[] getChargeAmendAuthRequestListVOs(){
		return chargeAmendAuthRequestListVOs;
	}
	
}