/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3105Event.java
*@FileTitle : Office Transfer History - CNTR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.27 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3105HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3105HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3105Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeArgumentVO chargeArgumentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeArgumentVO[] chargeArgumentVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private OfficeTransferParmVO officeTransferParmVO = null;
	

	public EesDmt3105Event(){}
	
	public void setChargeArgumentVO(ChargeArgumentVO chargeArgumentVO){
		this. chargeArgumentVO = chargeArgumentVO;
	}

	public void setChargeArgumentVOS(ChargeArgumentVO[] chargeArgumentVOs){
		this. chargeArgumentVOs = chargeArgumentVOs;
	}

	public ChargeArgumentVO getChargeArgumentVO(){
		return chargeArgumentVO;
	}

	public ChargeArgumentVO[] getChargeArgumentVOS(){
		return chargeArgumentVOs;
	}
	
	public void setOfficeTransferParmVO(OfficeTransferParmVO officeTransferParmVO){
		this. officeTransferParmVO = officeTransferParmVO;
	}

	public OfficeTransferParmVO getOfficeTransferParmVO(){
		return officeTransferParmVO;
	}

}