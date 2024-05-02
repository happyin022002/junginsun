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
package com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.vo.GrpLocPropVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpScpGrpLocDtlVO;
import com.clt.syscommon.common.table.PriRpScpGrpLocVO;


/**
 * ESM_PRI_2003_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2003_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_2003_02HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri200302Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpGrpLocVO priRpScpGrpLocVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpGrpLocVO[] priRpScpGrpLocVOs = null;

	private GrpLocPropVO grplocpropvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltGrpLocDtlListVO[] rsltGrpLocDtlListVOs = null;
	
	
	public EsmPri200302Event(){}
	
	public void setPriRpScpGrpLocDtlVO(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO){
		this. priRpScpGrpLocDtlVO = priRpScpGrpLocDtlVO;
	}

	public void setPriRpScpGrpLocDtlVOS(PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs){
		if (priRpScpGrpLocDtlVOs != null) {
			PriRpScpGrpLocDtlVO[] tmpVOs = new PriRpScpGrpLocDtlVO[priRpScpGrpLocDtlVOs.length];
			System.arraycopy(priRpScpGrpLocDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpGrpLocDtlVOs = tmpVOs;
		}
	}

	public void setPriRpScpGrpLocVO(PriRpScpGrpLocVO priRpScpGrpLocVO){
		this. priRpScpGrpLocVO = priRpScpGrpLocVO;
	}

	public void setPriRpScpGrpLocVOS(PriRpScpGrpLocVO[] priRpScpGrpLocVOs){
		if (priRpScpGrpLocVOs != null) {
			PriRpScpGrpLocVO[] tmpVOs = new PriRpScpGrpLocVO[priRpScpGrpLocVOs.length];
			System.arraycopy(priRpScpGrpLocVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpGrpLocVOs = tmpVOs;
		}
	}

	public PriRpScpGrpLocDtlVO getPriRpScpGrpLocDtlVO(){
		return priRpScpGrpLocDtlVO;
	}

	public PriRpScpGrpLocDtlVO[] getPriRpScpGrpLocDtlVOS(){
		PriRpScpGrpLocDtlVO[] tmpVOs = null;
		if (this.priRpScpGrpLocDtlVOs != null) {
			tmpVOs = new PriRpScpGrpLocDtlVO[priRpScpGrpLocDtlVOs.length];
			System.arraycopy(priRpScpGrpLocDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriRpScpGrpLocVO getPriRpScpGrpLocVO(){
		return priRpScpGrpLocVO;
	}

	public PriRpScpGrpLocVO[] getPriRpScpGrpLocVOS(){
		PriRpScpGrpLocVO[] tmpVOs = null;
		if (this.priRpScpGrpLocVOs != null) {
			tmpVOs = new PriRpScpGrpLocVO[priRpScpGrpLocVOs.length];
			System.arraycopy(priRpScpGrpLocVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public GrpLocPropVO getGrpLocPropVO() {
		return grplocpropvo;
	}

	public void setGrpLocPropVO(GrpLocPropVO grplocpropvo) {
		this.grplocpropvo = grplocpropvo;
	}

	public RsltGrpLocDtlListVO[] getRsltGrpLocDtlListVOs() {
		RsltGrpLocDtlListVO[] tmpVOs = null;
		if (this.rsltGrpLocDtlListVOs != null) {
			tmpVOs = new RsltGrpLocDtlListVO[rsltGrpLocDtlListVOs.length];
			System.arraycopy(rsltGrpLocDtlListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setRsltGrpLocDtlListVOs(RsltGrpLocDtlListVO[] rsltGrpLocDtlListVOs) {
		if (rsltGrpLocDtlListVOs != null) {
			RsltGrpLocDtlListVO[] tmpVOs = new RsltGrpLocDtlListVO[rsltGrpLocDtlListVOs.length];
			System.arraycopy(rsltGrpLocDtlListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltGrpLocDtlListVOs = tmpVOs;
		}
	}	

}