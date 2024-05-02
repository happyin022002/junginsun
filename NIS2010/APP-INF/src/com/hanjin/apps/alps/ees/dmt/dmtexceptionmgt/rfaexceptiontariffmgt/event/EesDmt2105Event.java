/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2105Event.java
*@FileTitle : DAR History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.24 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ees_dmt_2105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_dmt_2105HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2105HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt2105Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */

	
	/** Table Value Object Multi Data 처리 */
	
	private BeforeExceptionListInputVO inputVO = null;
	
	public void setBeforeExceptionListInputVO(BeforeExceptionListInputVO inputVO) {
		this.inputVO = inputVO;
	}
	
	public BeforeExceptionListInputVO getBeforeExceptionListInputVO() {
		return inputVO;
	}
}
