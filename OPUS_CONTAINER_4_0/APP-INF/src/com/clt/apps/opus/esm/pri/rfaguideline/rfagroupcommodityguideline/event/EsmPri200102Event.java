/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPri200102Event.java
*@FileTitle : Commondity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.21 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.event;

import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.GrpCmdtGlineVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriRgGrpCmdtVO;


/**
 * ESM_PRI_2001_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2001_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_2001_02HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri200102Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	private GrpCmdtGlineVO grpCmdtGlineVO = null;
	
	public GrpCmdtGlineVO getGrpCmdtGlineVO() {
		return grpCmdtGlineVO;
	}

	public void setGrpCmdtGlineVO(GrpCmdtGlineVO grpCmdtGlineVO) {
		this.grpCmdtGlineVO = grpCmdtGlineVO;
	}
	
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRgGrpCmdtVO priSgGrpCmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRgGrpCmdtVO[] priSgGrpCmdtVOs = null;

	public EsmPri200102Event(){}
	
	public void setPriRgGrpCmdtVO(PriRgGrpCmdtVO priSgGrpCmdtVO){
		this. priSgGrpCmdtVO = priSgGrpCmdtVO;
	}

	public void setPriRgGrpCmdtVOS(PriRgGrpCmdtVO[] priSgGrpCmdtVOs){
		if (priSgGrpCmdtVOs != null) {
			PriRgGrpCmdtVO[] tmpVOs = new PriRgGrpCmdtVO[priSgGrpCmdtVOs.length];
			System.arraycopy(priSgGrpCmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgGrpCmdtVOs = tmpVOs;
		}
	}

	public PriRgGrpCmdtVO getPriRgGrpCmdtVO(){
		return priSgGrpCmdtVO;
	}

	public PriRgGrpCmdtVO[] getPriRgGrpCmdtVOS(){
		PriRgGrpCmdtVO[] tmpVOs = null;
		if (this.priSgGrpCmdtVOs != null) {
			tmpVOs = new PriRgGrpCmdtVO[priSgGrpCmdtVOs.length];
			System.arraycopy(priSgGrpCmdtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRgGrpCmdtDtlVO priSgGrpCmdtDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOs = null;


	
	public void setPriRgGrpCmdtDtlVO(PriRgGrpCmdtDtlVO priSgGrpCmdtDtlVO){
		this. priSgGrpCmdtDtlVO = priSgGrpCmdtDtlVO;
	}

	public void setPriRgGrpCmdtDtlVOS(PriRgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOs){
		if (priSgGrpCmdtDtlVOs != null) {
			PriRgGrpCmdtDtlVO[] tmpVOs = new PriRgGrpCmdtDtlVO[priSgGrpCmdtDtlVOs.length];
			System.arraycopy(priSgGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgGrpCmdtDtlVOs = tmpVOs;
		}
	}

	public PriRgGrpCmdtDtlVO getPriRgGrpCmdtDtlVO(){
		return priSgGrpCmdtDtlVO;
	}

	public PriRgGrpCmdtDtlVO[] getPriRgGrpCmdtDtlVOS(){
		PriRgGrpCmdtDtlVO[] tmpVOs = null;
		if (this.priSgGrpCmdtDtlVOs != null) {
			tmpVOs = new PriRgGrpCmdtDtlVO[priSgGrpCmdtDtlVOs.length];
			System.arraycopy(priSgGrpCmdtDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	

}