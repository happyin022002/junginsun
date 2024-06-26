/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000302Event.java
*@FileTitle : S/C Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.06 변영주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo.GrpLocPropVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpLocVO;


/**
 * ESM_PRI_0003_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0003_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0003_02HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000302Event extends EventSupport {

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
	
	private String propNo = null;
	
	private String amdtSeq = null;
	
	private String svcScpCd = null;
	
	public EsmPri000302Event(){}
	
	public void setPriSpScpGrpLocDtlVO(PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO){
		this. priSpScpGrpLocDtlVO = priSpScpGrpLocDtlVO;
	}

	public void setPriSpScpGrpLocDtlVOS(PriSpScpGrpLocDtlVO[] priSpScpGrpLocDtlVOs){
		this. priSpScpGrpLocDtlVOs = priSpScpGrpLocDtlVOs;
	}

	public void setPriSpScpGrpLocVO(PriSpScpGrpLocVO priSpScpGrpLocVO){
		this. priSpScpGrpLocVO = priSpScpGrpLocVO;
	}

	public void setPriSpScpGrpLocVOS(PriSpScpGrpLocVO[] priSpScpGrpLocVOs){
		this. priSpScpGrpLocVOs = priSpScpGrpLocVOs;
	}

	public PriSpScpGrpLocDtlVO getPriSpScpGrpLocDtlVO(){
		return priSpScpGrpLocDtlVO;
	}

	public PriSpScpGrpLocDtlVO[] getPriSpScpGrpLocDtlVOS(){
		return priSpScpGrpLocDtlVOs;
	}

	public PriSpScpGrpLocVO getPriSpScpGrpLocVO(){
		return priSpScpGrpLocVO;
	}

	public PriSpScpGrpLocVO[] getPriSpScpGrpLocVOS(){
		return priSpScpGrpLocVOs;
	}
	
	public GrpLocPropVO getGrpLocPropVO() {
		return grplocpropvo;
	}

	public void setGrpLocPropVO(GrpLocPropVO grplocpropvo) {
		this.grplocpropvo = grplocpropvo;
	}	
	
	public String getPropNo() {
		return propNo;
	}

	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}	
	
	public String getAmdtSeq() {
		return amdtSeq;
	}

	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}	
	
	public String getSvcScpCd() {
		return svcScpCd;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}		

}