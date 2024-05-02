/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesEqr1063Event.java
*@FileTitle : Sales Projection History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 전지예
*@LastVersion : 1.0
* 2014.11.27 전지예 [CHM-201432889]    Sales Projection History 화면 생성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.SalesProjectionHistVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_1063 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1063HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 전지예
 * @see EES_EQR_1063HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1063Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	public EesEqr1063Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SalesProjectionHistVO salesProjectionHistVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public SalesProjectionHistVO[] salesProjectionHistVOs = null;

	public final SalesProjectionHistVO getSalesProjectionHistVO() {
		return salesProjectionHistVO;
	}

	public final void setSalesProjectionHistVO(
			SalesProjectionHistVO salesProjectionHistVO) {
		this.salesProjectionHistVO = salesProjectionHistVO;
	}

	public final SalesProjectionHistVO[] getSalesProjectionHistVOs() {
		return salesProjectionHistVOs;
	}

	public final void setSalesProjectionHistVOs(
			SalesProjectionHistVO[] salesProjectionHistVOs) {
		this.salesProjectionHistVOs = salesProjectionHistVOs;
	}
	
}