/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0215Event.java
*@FileTitle : Tariff Detail Information_Pop_Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.07.14 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrRprTrfDtlVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrRprTrfHdrVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.RepairTariffMgtINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_0215 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0215HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author WanGyu Kim 
 * @see ees_mnr_0215HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0215Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesMnr0215Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RepairTariffMgtINVO repairTariffMgtINVO = null;
	/** Table Value Object Multi Data 처리 */
	private CustomMnrRprTrfHdrVO   customMnrRprTrfHdrVO = null;
	private CustomMnrRprTrfDtlVO[] arrayCustomMnrRprTrfDtlVOs = null;

	public RepairTariffMgtINVO getRepairTariffMgtINVO() {
		return repairTariffMgtINVO;
	}
	public void setRepairTariffMgtINVO(RepairTariffMgtINVO repairTariffMgtINVO) {
		this.repairTariffMgtINVO = repairTariffMgtINVO;
	}
	public CustomMnrRprTrfHdrVO getCustomMnrRprTrfHdrVO() {
		return customMnrRprTrfHdrVO;
	}
	public void setCustomMnrRprTrfHdrVO(CustomMnrRprTrfHdrVO customMnrRprTrfHdrVO) {
		this.customMnrRprTrfHdrVO = customMnrRprTrfHdrVO;
	}
	public CustomMnrRprTrfDtlVO[] getArrayCustomMnrRprTrfDtlVOs() {
		return arrayCustomMnrRprTrfDtlVOs;
	}
	public void setArrayCustomMnrRprTrfDtlVOs(
			CustomMnrRprTrfDtlVO[] arrayCustomMnrRprTrfDtlVOs) {
		this.arrayCustomMnrRprTrfDtlVOs = arrayCustomMnrRprTrfDtlVOs;
	}
	
	
}