/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0136Event.java
*@FileTitle : MNR Standard Tariff Creation and Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.05 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomTariffApprovalVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffApprovalINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_0136 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0136HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author WanGyu Kim 
 * @see ees_mnr_0136HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0136Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesMnr0136Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TariffApprovalINVO tariffApprovalINVO = null;
	/** Table Value Object Multi Data 처리 */
	private CustomTariffApprovalVO[] arrayCustomTariffApprovalVOs = null;

	public TariffApprovalINVO getTariffApprovalINVO() {
		return tariffApprovalINVO;
	}
	public void setTariffApprovalINVO(TariffApprovalINVO tariffApprovalINVO) {
		this.tariffApprovalINVO = tariffApprovalINVO;
	}
	public CustomTariffApprovalVO[] getArrayCustomTariffApprovalVOs() {
		CustomTariffApprovalVO[] rtnVOs = null;
		if (this.arrayCustomTariffApprovalVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(arrayCustomTariffApprovalVOs, arrayCustomTariffApprovalVOs.length);
		}
		return rtnVOs;
	}
	public void setArrayCustomTariffApprovalVOs(CustomTariffApprovalVO[] arrayCustomTariffApprovalVOs){
		if(arrayCustomTariffApprovalVOs != null){
			CustomTariffApprovalVO[] tmpVOs = java.util.Arrays.copyOf(arrayCustomTariffApprovalVOs, arrayCustomTariffApprovalVOs.length);
			this.arrayCustomTariffApprovalVOs = tmpVOs;
		}
	}
}