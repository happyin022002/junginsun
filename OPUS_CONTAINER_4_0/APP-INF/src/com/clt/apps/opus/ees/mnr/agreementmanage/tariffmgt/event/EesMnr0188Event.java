/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0188Event.java
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.02 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffPopupINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_0188 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0188HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author WanGyu Kim 
 * @see ees_mnr_0188HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0188Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesMnr0188Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TariffPopupINVO tariffPopupINVO = null;

	public TariffPopupINVO getTariffPopupINVO() {
		return tariffPopupINVO;
	}

	public void setTariffPopupINVO(TariffPopupINVO tariffPopupINVO) {
		this.tariffPopupINVO = tariffPopupINVO;
	}
}