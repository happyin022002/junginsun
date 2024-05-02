/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri3002Event.java
*@FileTitle : TRI Creation &amp; Amendment - Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.17 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.event;

import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.vo.PriTriNoteConvListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriTriNoteConvVO;
import com.clt.syscommon.common.table.PriTriRtVO;


/**
 * ESM_PRI_3002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_3002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTriNoteConvVO priTriNoteConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTriNoteConvVO[] priTriNoteConvVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTriNoteConvListVO priTriNoteConvListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTriNoteConvListVO[] priTriNoteConvListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTriRtVO priTriRtVO = null;
	
	public EsmPri3002Event(){}
	
	public void setPriTriNoteConvVO(PriTriNoteConvVO priTriNoteConvVO){
		this. priTriNoteConvVO = priTriNoteConvVO;
	}

	public PriTriNoteConvVO getPriTriNoteConvVO(){
		return priTriNoteConvVO;
	}

	public PriTriNoteConvListVO getPriTriNoteConvListVO() {
		return priTriNoteConvListVO;
	}

	public PriTriNoteConvListVO[] getPriTriNoteConvListVOs() {
		PriTriNoteConvListVO[] tmpVOs = null;
		if (this.priTriNoteConvListVOs != null) {
			tmpVOs = new PriTriNoteConvListVO[priTriNoteConvListVOs.length];
			System.arraycopy(priTriNoteConvListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriTriNoteConvListVO(PriTriNoteConvListVO priTriNoteConvListVO) {
		this.priTriNoteConvListVO = priTriNoteConvListVO;
	}

	public void setPriTriNoteConvListVOs(PriTriNoteConvListVO[] priTriNoteConvListVOs) {
		if (priTriNoteConvListVOs != null) {
			PriTriNoteConvListVO[] tmpVOs = new PriTriNoteConvListVO[priTriNoteConvListVOs.length];
			System.arraycopy(priTriNoteConvListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTriNoteConvListVOs = tmpVOs;
		}
	}

	public PriTriNoteConvVO[] getPriTriNoteConvVOs() {
		PriTriNoteConvVO[] tmpVOs = null;
		if (this.priTriNoteConvVOs != null) {
			tmpVOs = new PriTriNoteConvVO[priTriNoteConvVOs.length];
			System.arraycopy(priTriNoteConvVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriTriNoteConvVOs(PriTriNoteConvVO[] priTriNoteConvVOs) {
		if (priTriNoteConvVOs != null) {
			PriTriNoteConvVO[] tmpVOs = new PriTriNoteConvVO[priTriNoteConvVOs.length];
			System.arraycopy(priTriNoteConvVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTriNoteConvVOs = tmpVOs;
		}
	}

	public PriTriRtVO getPriTriRtVO() {
		return priTriRtVO;
	}

	public void setPriTriRtVO(PriTriRtVO priTriRtVO) {
		this.priTriRtVO = priTriRtVO;
	}
	

}