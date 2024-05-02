/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000402Event.java
*@FileTitle : S/C Proposal Location Group - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.07 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.event;


import com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.vo.GrpLocPropVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpGrpLocDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpLocVO;


/**
 * ESM_PRI_0004_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0004_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0004_02HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000402Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpGrpLocDtlVO[] priSpScpGrpLocDtlVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpGrpLocVO priSpScpGrpLocVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpGrpLocVO[] priSpScpGrpLocVOs = null;

	private GrpLocPropVO grplocpropvo = null;
	
	public EsmPri000402Event(){}
	
	public void setPriSpScpGrpLocDtlVO(PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO){
		this. priSpScpGrpLocDtlVO = priSpScpGrpLocDtlVO;
	}

	public void setPriSpScpGrpLocDtlVOS(PriSpScpGrpLocDtlVO[] priSpScpGrpLocDtlVOs){
		if (priSpScpGrpLocDtlVOs != null) {
			PriSpScpGrpLocDtlVO[] tmpVOs = new PriSpScpGrpLocDtlVO[priSpScpGrpLocDtlVOs.length];
			System.arraycopy(priSpScpGrpLocDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpGrpLocDtlVOs = tmpVOs;
		}
	}

	public void setPriSpScpGrpLocVO(PriSpScpGrpLocVO priSpScpGrpLocVO){
		this. priSpScpGrpLocVO = priSpScpGrpLocVO;
	}

	public void setPriSpScpGrpLocVOS(PriSpScpGrpLocVO[] priSpScpGrpLocVOs){
		if (priSpScpGrpLocVOs != null) {
			PriSpScpGrpLocVO[] tmpVOs = new PriSpScpGrpLocVO[priSpScpGrpLocVOs.length];
			System.arraycopy(priSpScpGrpLocVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpGrpLocVOs = tmpVOs;
		}
	}

	public PriSpScpGrpLocDtlVO getPriSpScpGrpLocDtlVO(){
		return priSpScpGrpLocDtlVO;
	}

	public PriSpScpGrpLocDtlVO[] getPriSpScpGrpLocDtlVOS(){
		PriSpScpGrpLocDtlVO[] tmpVOs = null;
		if (this.priSpScpGrpLocDtlVOs != null) {
			tmpVOs = new PriSpScpGrpLocDtlVO[priSpScpGrpLocDtlVOs.length];
			System.arraycopy(priSpScpGrpLocDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpScpGrpLocVO getPriSpScpGrpLocVO(){
		return priSpScpGrpLocVO;
	}

	public PriSpScpGrpLocVO[] getPriSpScpGrpLocVOS(){
		PriSpScpGrpLocVO[] tmpVOs = null;
		if (this.priSpScpGrpLocVOs != null) {
			tmpVOs = new PriSpScpGrpLocVO[priSpScpGrpLocVOs.length];
			System.arraycopy(priSpScpGrpLocVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public GrpLocPropVO getGrpLocPropVO() {
		return grplocpropvo;
	}

	public void setGrpLocPropVO(GrpLocPropVO grplocpropvo) {
		this.grplocpropvo = grplocpropvo;
	}	

}