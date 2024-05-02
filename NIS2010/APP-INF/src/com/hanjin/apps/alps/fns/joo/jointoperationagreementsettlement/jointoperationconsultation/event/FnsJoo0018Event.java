/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0018Event.java
*@FileTitle : AP CSR Creation Evidence PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.15 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.JooTaxDtlVO;
import com.hanjin.syscommon.common.table.JooTaxVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxGrpVO;


/**
 * FN_JOO_0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FN_JOO_0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0018HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TaxGrpVO taxGrpVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooTaxVO jooTaxVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooTaxDtlVO jooTaxDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooTaxVO[]  jooTaxVOs = null;

	/** Table Value Object Multi Data 처리 */
	private JooTaxDtlVO[] jooTaxDtlVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private TaxGrpVO[] taxGrpVOs = null;
	
	/** CSR 번호*/
	private String csrNo = null;
	
	/** Vendor 코드*/
	private String vndrSeq = null;

	public FnsJoo0018Event(){}
	
	public void setTaxGrpVO(TaxGrpVO taxGrpVO){
		this. taxGrpVO = taxGrpVO;
	}

	public void setTaxGrpVOS(TaxGrpVO[] taxGrpVOs){
		if (taxGrpVOs != null) {
			TaxGrpVO[] tmpVOs = new TaxGrpVO[taxGrpVOs.length];
			System.arraycopy(taxGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.taxGrpVOs = tmpVOs;
		}		
	}

	public TaxGrpVO getTaxGrpVO(){
		return taxGrpVO;
	}

	public TaxGrpVO[] getTaxGrpVOS(){
		TaxGrpVO[] rtnVOs = null;
		if (this.taxGrpVOs != null) {
			rtnVOs = new TaxGrpVO[taxGrpVOs.length];
			System.arraycopy(taxGrpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public JooTaxVO getJooTaxVO() {
		return jooTaxVO;
	}

	public void setJooTaxVO(JooTaxVO jooTaxVO) {
		this.jooTaxVO = jooTaxVO;
	}

	public JooTaxDtlVO getJooTaxDtlVO() {
		return jooTaxDtlVO;
	}

	public void setJooTaxDtlVO(JooTaxDtlVO jooTaxDtlVO) {
		this.jooTaxDtlVO = jooTaxDtlVO;
	}

	public JooTaxVO[] getJooTaxVOs() {
		JooTaxVO[] rtnVOs = null;
		if (this.jooTaxVOs != null) {
			rtnVOs = new JooTaxVO[jooTaxVOs.length];
			System.arraycopy(jooTaxVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setJooTaxVOs(JooTaxVO[] jooTaxVOs) {
		if (jooTaxVOs != null) {
			JooTaxVO[] tmpVOs = new JooTaxVO[jooTaxVOs.length];
			System.arraycopy(jooTaxVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooTaxVOs = tmpVOs;
		}		
	}

	public JooTaxDtlVO[] getJooTaxDtlVOs() {
		JooTaxDtlVO[] rtnVOs = null;
		if (this.jooTaxDtlVOs != null) {
			rtnVOs = new JooTaxDtlVO[jooTaxDtlVOs.length];
			System.arraycopy(jooTaxDtlVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public void setJooTaxDtlVOs(JooTaxDtlVO[] jooTaxDtlVOs) {
		if (jooTaxDtlVOs != null) {
			JooTaxDtlVO[] tmpVOs = new JooTaxDtlVO[jooTaxDtlVOs.length];
			System.arraycopy(jooTaxDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooTaxDtlVOs = tmpVOs;
		}		
	}

	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

}