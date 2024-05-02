/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt5001Event.java
*@FileTitle : A/R Interface Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.03 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceParmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_5001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_5001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Sung Hwan
 * @see EES_DMT_5001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt5001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInterfaceParmVO aRInterfaceParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInterfaceParmVO[] aRInterfaceParmVOs = null;

	public EesDmt5001Event(){}
	
	public void setARInterfaceParmVO(ARInterfaceParmVO aRInterfaceParmVO){
		this. aRInterfaceParmVO = aRInterfaceParmVO;
	}

	public void setARInterfaceParmVOS(ARInterfaceParmVO[] aRInterfaceParmVOs){
		if (aRInterfaceParmVOs != null) {
			ARInterfaceParmVO[] tmpVOs = new ARInterfaceParmVO[aRInterfaceParmVOs.length];
			System.arraycopy(aRInterfaceParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInterfaceParmVOs = tmpVOs;
		}
	}

	public ARInterfaceParmVO getARInterfaceParmVO(){
		return aRInterfaceParmVO;
	}

	public ARInterfaceParmVO[] getARInterfaceParmVOS(){
		ARInterfaceParmVO[] tmpVOs = null;
		if (this.aRInterfaceParmVOs != null) {
			tmpVOs = new ARInterfaceParmVO[aRInterfaceParmVOs.length];
			System.arraycopy(aRInterfaceParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}