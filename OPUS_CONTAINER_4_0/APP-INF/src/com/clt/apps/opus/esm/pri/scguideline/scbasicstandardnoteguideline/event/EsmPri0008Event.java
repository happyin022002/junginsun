/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0008Event.java
*@FileTitle : Standard Note Conversion Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.23 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.event;

import com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.vo.PriScNoteConvListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriScNoteConvCpyVO;
import com.clt.syscommon.common.table.PriScNoteConvVO;


/**
 * ESM_PRI_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScNoteConvVO priScNoteConvVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScNoteConvCpyVO priScNoteConvCpyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScNoteConvVO[] priScNoteConvVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScNoteConvCpyVO[] priScNoteConvCpyVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScNoteConvListVO priScNoteConvListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScNoteConvListVO[] priScNoteConvListVOs = null;

	public EsmPri0008Event(){}
	
	public void setPriScNoteConvVO(PriScNoteConvVO priScNoteConvVO){
		this. priScNoteConvVO = priScNoteConvVO;
	}
	
	public void setPriScNoteConvCpyVO(PriScNoteConvCpyVO priScNoteConvCpyVO) {
		this.priScNoteConvCpyVO = priScNoteConvCpyVO;
	}
	

	public void setPriScNoteConvVOS(PriScNoteConvVO[] priScNoteConvVOs){
		if (priScNoteConvVOs != null) {
			PriScNoteConvVO[] tmpVOs = new PriScNoteConvVO[priScNoteConvVOs.length];
			System.arraycopy(priScNoteConvVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScNoteConvVOs = tmpVOs;
		}
	}
	
	public void setPriScNoteConvCpyVOS(PriScNoteConvCpyVO[] priScNoteConvCpyVOs){
		if (priScNoteConvCpyVOs != null) {
			PriScNoteConvCpyVO[] tmpVOs = new PriScNoteConvCpyVO[priScNoteConvCpyVOs.length];
			System.arraycopy(priScNoteConvCpyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScNoteConvCpyVOs = tmpVOs;
		}
	}

	public PriScNoteConvVO getPriScNoteConvVO(){
		return priScNoteConvVO;
	}

	public PriScNoteConvVO[] getPriScNoteConvVOS(){
		PriScNoteConvVO[] tmpVOs = null;
		if (this.priScNoteConvVOs != null) {
			tmpVOs = new PriScNoteConvVO[priScNoteConvVOs.length];
			System.arraycopy(priScNoteConvVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriScNoteConvCpyVO[] getPriScNoteConvCpyVOS(){
		PriScNoteConvCpyVO[] tmpVOs = null;
		if (this.priScNoteConvCpyVOs != null) {
			tmpVOs = new PriScNoteConvCpyVO[priScNoteConvCpyVOs.length];
			System.arraycopy(priScNoteConvCpyVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriScNoteConvCpyVO getPriScNoteConvCpyVO() {
		return priScNoteConvCpyVO;
	}

	public PriScNoteConvListVO getPriScNoteConvListVO() {
		return priScNoteConvListVO;
	}

	public PriScNoteConvListVO[] getPriScNoteConvListVOs() {
		PriScNoteConvListVO[] tmpVOs = null;
		if (this.priScNoteConvListVOs != null) {
			tmpVOs = new PriScNoteConvListVO[priScNoteConvListVOs.length];
			System.arraycopy(priScNoteConvListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriScNoteConvListVO(PriScNoteConvListVO priScNoteConvListVO) {
		this.priScNoteConvListVO = priScNoteConvListVO;
	}

	public void setPriScNoteConvListVOs(PriScNoteConvListVO[] priScNoteConvListVOs) {
		if (priScNoteConvListVOs != null) {
			PriScNoteConvListVO[] tmpVOs = new PriScNoteConvListVO[priScNoteConvListVOs.length];
			System.arraycopy(priScNoteConvListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScNoteConvListVOs = tmpVOs;
		}
	}

	

}