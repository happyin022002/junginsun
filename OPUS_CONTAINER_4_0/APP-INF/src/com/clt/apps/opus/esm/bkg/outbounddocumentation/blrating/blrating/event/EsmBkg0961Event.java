/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0961Event.java
*@FileTitle : freight & Charge_booking customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustOutVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0961 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0961HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0961HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0961Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsmBkg0961Event(){}
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PpdCctCustInVO ppdCctCustInVO = null;

	/** Table Value Object Multi Data 처리 */
	private PpdCctCustOutVO[] ppdCctCustOutVOs = null;

	/**
	 * @return the ppdCctCustInVO
	 */
	public PpdCctCustInVO getPpdCctCustInVO() {
		return ppdCctCustInVO;
	}

	/**
	 * @param ppdCctCustInVO the ppdCctCustInVO to set
	 */
	public void setPpdCctCustInVO(PpdCctCustInVO ppdCctCustInVO) {
		this.ppdCctCustInVO = ppdCctCustInVO;
	}

	public PpdCctCustOutVO[] getPpdCctCustOutVOs() {
		PpdCctCustOutVO[] rtnVOs = null;
		if (this.ppdCctCustOutVOs != null) {
			rtnVOs = Arrays.copyOf(ppdCctCustOutVOs, ppdCctCustOutVOs.length);
		}
		return rtnVOs;
	}

	public void setPpdCctCustOutVOs(PpdCctCustOutVO[] ppdCctCustOutVOs) {
		if (ppdCctCustOutVOs != null) {
			PpdCctCustOutVO[] tmpVOs = Arrays.copyOf(ppdCctCustOutVOs, ppdCctCustOutVOs.length);
			this.ppdCctCustOutVOs = tmpVOs;
		}
	}




}