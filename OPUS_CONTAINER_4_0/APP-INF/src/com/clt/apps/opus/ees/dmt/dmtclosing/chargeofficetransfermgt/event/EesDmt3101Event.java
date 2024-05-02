/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3101Event.java
*@FileTitle : Office Transfer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.21 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.event;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3101HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OfficeTransferParmVO officeTransferParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OfficeTransferParmVO[] officeTransferParmVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeArgumentVO chargeArgumentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeArgumentVO[] chargeArgumentVOs = null;

	public EesDmt3101Event(){}
	
	public void setOfficeTransferParmVO(OfficeTransferParmVO officeTransferParmVO){
		this. officeTransferParmVO = officeTransferParmVO;
	}

	public void setOfficeTransferParmVOS(OfficeTransferParmVO[] officeTransferParmVOs){
		if (officeTransferParmVOs != null) {
			OfficeTransferParmVO[] tmpVOs = new OfficeTransferParmVO[officeTransferParmVOs.length];
			System.arraycopy(officeTransferParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.officeTransferParmVOs = tmpVOs;
		}
	}

	public void setChargeArgumentVO(ChargeArgumentVO chargeArgumentVO){
		this. chargeArgumentVO = chargeArgumentVO;
	}

	public void setChargeArgumentVOS(ChargeArgumentVO[] chargeArgumentVOs){
		if (chargeArgumentVOs != null) {
			ChargeArgumentVO[] tmpVOs = new ChargeArgumentVO[chargeArgumentVOs.length];
			System.arraycopy(chargeArgumentVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.chargeArgumentVOs = tmpVOs;
		}
	}

	public OfficeTransferParmVO getOfficeTransferParmVO(){
		return officeTransferParmVO;
	}

	public OfficeTransferParmVO[] getOfficeTransferParmVOS(){
		OfficeTransferParmVO[] tmpVOs = null;
		if (this.officeTransferParmVOs != null) {
			tmpVOs = new OfficeTransferParmVO[officeTransferParmVOs.length];
			System.arraycopy(officeTransferParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public ChargeArgumentVO getChargeArgumentVO(){
		return chargeArgumentVO;
	}

	public ChargeArgumentVO[] getChargeArgumentVOS(){
		ChargeArgumentVO[] tmpVOs = null;
		if (this.chargeArgumentVOs != null) {
			tmpVOs = new ChargeArgumentVO[chargeArgumentVOs.length];
			System.arraycopy(chargeArgumentVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}