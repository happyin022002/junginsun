/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0100Event.java
*@FileTitle : Note Conversion History - Commodity Note Conversion Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.01 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.event;


import com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.vo.PriScNoteConvListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteCtntListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriScNoteConvVO;
import com.clt.syscommon.common.table.PriSpScpNoteVO;
import com.clt.syscommon.common.table.PriSpScpRtCnoteVO;


/**
 * ESM_PRI_0100 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0100HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0100HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0100Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScNoteConvVO priScNoteConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScNoteConvVO[] priScNoteConvVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteVO priSpScpNoteVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpRtCnoteVO priSpScpRtCnoteVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteCtntListVO  priSpScpNoteCtntListVO = null;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScNoteConvListVO priScNoteConvListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScNoteConvListVO[] priScNoteConvListVOs = null;
		
	public EsmPri0100Event(){}
	
	public void setPriScNoteConvVO(PriScNoteConvVO priScNoteConvVO){
		this. priScNoteConvVO = priScNoteConvVO;
	}

	public void setPriScNoteConvVOS(PriScNoteConvVO[] priScNoteConvVOs){
		if (priScNoteConvVOs != null) {
			PriScNoteConvVO[] tmpVOs = new PriScNoteConvVO[priScNoteConvVOs.length];
			System.arraycopy(priScNoteConvVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScNoteConvVOs = tmpVOs;
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

	public PriSpScpNoteVO getPriSpScpNoteVO() {
		return priSpScpNoteVO;
	}


	public void setPriSpScpNoteVO(PriSpScpNoteVO priSpScpNoteVO) {
		this.priSpScpNoteVO = priSpScpNoteVO;
	}

	public PriSpScpNoteCtntListVO getPriSpScpNoteCtntListVO() {
		return priSpScpNoteCtntListVO;
	}

	public void setPriSpScpNoteCtntListVO(
			PriSpScpNoteCtntListVO priSpScpNoteCtntListVO) {
		this.priSpScpNoteCtntListVO = priSpScpNoteCtntListVO;
	}
	
	public PriSpScpRtCnoteVO getPriSpScpRtCnoteVO() {
		return priSpScpRtCnoteVO;
	}

	public void setPriSpScpRtCnoteVO(PriSpScpRtCnoteVO priSpScpRtCnoteVO) {
		this.priSpScpRtCnoteVO = priSpScpRtCnoteVO;
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