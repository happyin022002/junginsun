/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2035Event.java
*@FileTitle : Payable Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.08.21 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;
 
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationINVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ees_cgm_2035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_2035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_2035HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm2035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS = null;

	public MGSPayableInvoiceCreationINVO getMgsPayableInvoiceCreationINVO() {
		return mgsPayableInvoiceCreationINVO;
	}

	public void setMgsPayableInvoiceCreationINVO(
			MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO) {
		this.mgsPayableInvoiceCreationINVO = mgsPayableInvoiceCreationINVO;
	}

	public MGSPayableInvoiceCreationINVO[] getMgsPayableInvoiceCreationINVOS() {
		MGSPayableInvoiceCreationINVO[] rtnVOs = null;
		if (this.mgsPayableInvoiceCreationINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsPayableInvoiceCreationINVOS, mgsPayableInvoiceCreationINVOS.length);
		}
		return rtnVOs;
	}

	public void setMgsPayableInvoiceCreationINVOS(MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS){
		if(mgsPayableInvoiceCreationINVOS != null){
			MGSPayableInvoiceCreationINVO[] tmpVOs = java.util.Arrays.copyOf(mgsPayableInvoiceCreationINVOS, mgsPayableInvoiceCreationINVOS.length);
			this.mgsPayableInvoiceCreationINVOS = tmpVOs;
		}
	}

	
}