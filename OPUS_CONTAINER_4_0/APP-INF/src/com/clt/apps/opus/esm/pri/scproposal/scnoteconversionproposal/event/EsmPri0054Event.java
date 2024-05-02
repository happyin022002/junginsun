/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0031Event.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.03 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriScNoteConvVO;
import com.clt.syscommon.common.table.PriSpScpNoteVO;
import com.clt.syscommon.common.table.PriSpScpRtCnoteVO;


/**
 * ESM_PRI_0054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0054HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0054Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScNoteConvVO priScNoteConvVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteVO priSpScpNoteVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpRtCnoteVO priSpScpRtCnoteVO = null;
	
		
	public EsmPri0054Event(){}
	
	public void setPriScNoteConvVO(PriScNoteConvVO priScNoteConvVO){
		this. priScNoteConvVO = priScNoteConvVO;
	}


	public PriScNoteConvVO getPriScNoteConvVO(){
		return priScNoteConvVO;
	}


	public PriSpScpNoteVO getPriSpScpNoteVO() {
		return priSpScpNoteVO;
	}


	public void setPriSpScpNoteVO(PriSpScpNoteVO priSpScpNoteVO) {
		this.priSpScpNoteVO = priSpScpNoteVO;
	}

	public PriSpScpRtCnoteVO getPriSpScpRtCnoteVO() {
		return priSpScpRtCnoteVO;
	}

	public void setPriSpScpRtCnoteVO(PriSpScpRtCnoteVO priSpScpRtCnoteVO) {
		this.priSpScpRtCnoteVO = priSpScpRtCnoteVO;
	}
	
	

}