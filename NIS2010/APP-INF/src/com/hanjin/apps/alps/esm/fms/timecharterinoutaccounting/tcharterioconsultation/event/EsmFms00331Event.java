/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms00331Event.java
*@FileTitle : RCS / Invoice No Inquiry - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.03 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchInvoiceNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0033_1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0033_1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi, WooSeok
 * @see ESM_FMS_00331HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms00331Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondSearchInvoiceNoVO condSearchInvoiceNoVO = null;
	
	public CondSearchInvoiceNoVO getCondSearchInvoiceNoVO(){
		return condSearchInvoiceNoVO;
	}

	public void setCondSearchInvoiceNoVO(CondSearchInvoiceNoVO condSearchInvoiceNoVO){
		this. condSearchInvoiceNoVO = condSearchInvoiceNoVO;
	}
}