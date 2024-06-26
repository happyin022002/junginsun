/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnrS171Event.java
*@FileTitle : MNR Tariff Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.12.24 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffApprovalINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_S171 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_S171HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author WanGyu Kim 
 * @see ees_mnr_S171HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnrS171Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesMnrS171Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TariffApprovalINVO tariffApprovalINVO = null;

	public TariffApprovalINVO getTariffApprovalINVO() {
		return tariffApprovalINVO;
	}

	public void setTariffApprovalINVO(TariffApprovalINVO tariffApprovalINVO) {
		this.tariffApprovalINVO = tariffApprovalINVO;
	}
}