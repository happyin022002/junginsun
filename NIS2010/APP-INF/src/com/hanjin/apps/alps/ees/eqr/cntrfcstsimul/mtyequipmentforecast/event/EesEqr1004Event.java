/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesEqr1004Event.java
*@FileTitle : Sales Projection Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 전지예
*@LastVersion : 1.0
* 2014.11.27 전지예 [CHM-201432889]    Sales Projection Detail 화면 생성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.SalesFcstDtlVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 전지예
 * @see EES_EQR_1004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1004Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private SalesFcstDtlVO salesFcstDtlVO = null;

	public EesEqr1004Event(){}
	
	public final SalesFcstDtlVO getSalesFcstDtlVO() {
		return salesFcstDtlVO;
	}
	
	public final void setSalesFcstDtlVO(SalesFcstDtlVO salesFcstDtlVO) {
		this.salesFcstDtlVO = salesFcstDtlVO;
	}
}