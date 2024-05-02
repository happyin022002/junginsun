/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000408Event.java
*@FileTitle : S/C Proposal Standard Note - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.04 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteHeaderVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpNoteCtntVO;
import com.clt.syscommon.common.table.PriSpScpNoteVO;


/**
 * ESM_PRI_0004_08 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0004_08HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0004_08HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri000408Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteCtntListVO rsltNoteCtntListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteHeaderVO rsltNoteHeaderVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteListVO rsltNoteListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteVO priSpScpNoteVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteCtntVO priSpScpNoteCtntVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteListVO priSpScpNoteListVO = null;
	

	public EsmPri000408Event(){}
	
	public void setRsltNoteCtntListVO(RsltNoteCtntListVO rsltNoteCtntListVO){
		this. rsltNoteCtntListVO = rsltNoteCtntListVO;
	}

	public void setRsltNoteHeaderVO(RsltNoteHeaderVO rsltNoteHeaderVO){
		this. rsltNoteHeaderVO = rsltNoteHeaderVO;
	}


	public void setRsltNoteListVO(RsltNoteListVO rsltNoteListVO){
		this. rsltNoteListVO = rsltNoteListVO;
	}

	public void setPriSpScpNoteVO(PriSpScpNoteVO priSpScpNoteVO){
		this. priSpScpNoteVO = priSpScpNoteVO;
	}


	public RsltNoteCtntListVO getRsltNoteCtntListVO(){
		return rsltNoteCtntListVO;
	}

	public RsltNoteHeaderVO getRsltNoteHeaderVO(){
		return rsltNoteHeaderVO;
	}

	public RsltNoteListVO getRsltNoteListVO(){
		return rsltNoteListVO;
	}

	public PriSpScpNoteVO getPriSpScpNoteVO(){
		return priSpScpNoteVO;
	}

	public PriSpScpNoteCtntVO getPriSpScpNoteCtntVO() {
		return priSpScpNoteCtntVO;
	}

	public void setPriSpScpNoteCtntVO(PriSpScpNoteCtntVO priSpScpNoteCtntVO) {
		this.priSpScpNoteCtntVO = priSpScpNoteCtntVO;
	}

	public PriSpScpNoteListVO getPriSpScpNoteListVO() {
		return priSpScpNoteListVO;
	}

	public void setPriSpScpNoteListVO(PriSpScpNoteListVO priSpScpNoteListVO) {
		this.priSpScpNoteListVO = priSpScpNoteListVO;
	}


}