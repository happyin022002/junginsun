/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri3006Event.java
*@FileTitle : Tariff Fomula Rule Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.17 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriTriNoteConvVO;
import com.clt.syscommon.common.table.PriTriNoteVO;


/**
 * ESM_PRI_3006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_3006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTriNoteConvVO priTriNoteConvVO = null;
			
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTriNoteVO priTriNoteVO = null;
	

	public EsmPri3006Event(){}

	public PriTriNoteConvVO getPriTriNoteConvVO() {
		return priTriNoteConvVO;
	}

	public void setPriTriNoteConvVO(PriTriNoteConvVO priTriNoteConvVO) {
		this.priTriNoteConvVO = priTriNoteConvVO;
	}

	public PriTriNoteVO getPriTriNoteVO() {
		return priTriNoteVO;
	}

	public void setPriTriNoteVO(PriTriNoteVO priTriNoteVO) {
		this.priTriNoteVO = priTriNoteVO;
	}
	
	

}