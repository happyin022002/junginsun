/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0044Event.java
*@FileTitle : Tax Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.18 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxVO;


/**
 * FNS_JOO_0044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0044HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsJoo0044Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String taxInvYrmonFr = null;

	private String taxInvYrmonTo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TaxVO taxVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TaxVO[] taxVOs = null;

	public FnsJoo0044Event(){}
	
	public void setTaxVO(TaxVO taxVO){
		this. taxVO = taxVO;
	}

	public void setTaxVOS(TaxVO[] taxVOs){
		if (taxVOs != null) {
			TaxVO[] tmpVOs = new TaxVO[taxVOs.length];
			System.arraycopy(taxVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.taxVOs = tmpVOs;
		}		
	}

	public TaxVO getTaxVO(){
		return taxVO;
	}

	public TaxVO[] getTaxVOS(){
		TaxVO[] rtnVOs = null;
		if (this.taxVOs != null) {
			rtnVOs = new TaxVO[taxVOs.length];
			System.arraycopy(taxVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public String getTaxInvYrmonFr() {
		return taxInvYrmonFr;
	}

	public void setTaxInvYrmonFr(String taxInvYrmonFr) {
		this.taxInvYrmonFr = taxInvYrmonFr;
	}

	public String getTaxInvYrmonTo() {
		return taxInvYrmonTo;
	}

	public void setTaxInvYrmonTo(String taxInvYrmonTo) {
		this.taxInvYrmonTo = taxInvYrmonTo;
	}

}