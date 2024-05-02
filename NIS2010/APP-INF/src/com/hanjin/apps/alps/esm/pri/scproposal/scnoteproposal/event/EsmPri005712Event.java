/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri005712Event.java
*@FileTitle : Amendment History Inquiry - Special Note
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.07 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.NotePropVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteListVO;
import com.hanjin.syscommon.common.table.PriSpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriSpScpNoteVO;


/**
 * ESM_PRI_0057_12 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0057_12HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0057_12HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri005712Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteCtntListVO rsltNoteCtntListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltNoteCtntListVO[] rsltNoteCtntListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteCtntVO priSpScpNoteCtntVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpNoteCtntVO[] priSpScpNoteCtntVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteListVO rsltNoteListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltNoteListVO[] rsltNoteListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteVO priSpScpNoteVO = null;
	
	/** Table Value Object Multi Data 처리 */
//	private PriSpScpNoteVO[] priSpScpNoteVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private NotePropVO notePropVO = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteListVO priSpScpNoteListVO = null;
	
	

	public EsmPri005712Event(){}
	
	
	public NotePropVO getNotePropVO() {
		return notePropVO;
	}
	public void setNotePropVO(NotePropVO notePropVO) {
		this.notePropVO = notePropVO;
	}

	public void setRsltNoteCtntListVO(RsltNoteCtntListVO rsltNoteCtntListVO){
		this. rsltNoteCtntListVO = rsltNoteCtntListVO;
	}

	public void setRsltNoteCtntListVOS(RsltNoteCtntListVO[] rsltNoteCtntListVOs){
		this. rsltNoteCtntListVOs = rsltNoteCtntListVOs;
	}

	public void setPriSpScpNoteCtntVO(PriSpScpNoteCtntVO priSpScpNoteCtntVO){
		this. priSpScpNoteCtntVO = priSpScpNoteCtntVO;
	}

	public void setPriSpScpNoteCtntVOS(PriSpScpNoteCtntVO[] priSpScpNoteCtntVOs){
		this. priSpScpNoteCtntVOs = priSpScpNoteCtntVOs;
	}

	public void setRsltNoteListVO(RsltNoteListVO rsltNoteListVO){
		this. rsltNoteListVO = rsltNoteListVO;
	}

	public void setRsltNoteListVOS(RsltNoteListVO[] rsltNoteListVOs){
		this. rsltNoteListVOs = rsltNoteListVOs;
	}

	public RsltNoteCtntListVO getRsltNoteCtntListVO(){
		return rsltNoteCtntListVO;
	}

	public RsltNoteCtntListVO[] getRsltNoteCtntListVOS(){
		return rsltNoteCtntListVOs;
	}

	public PriSpScpNoteCtntVO getPriSpScpNoteCtntVO(){
		return priSpScpNoteCtntVO;
	}

	public PriSpScpNoteCtntVO[] getPriSpScpNoteCtntVOS(){
		return priSpScpNoteCtntVOs;
	}

	public RsltNoteListVO getRsltNoteListVO(){
		return rsltNoteListVO;
	}

	public RsltNoteListVO[] getRsltNoteListVOS(){
		return rsltNoteListVOs;
	}

	public PriSpScpNoteVO getPriSpScpNoteVO() {
		return priSpScpNoteVO;
	}

	public void setPriSpScpNoteVO(PriSpScpNoteVO priSpScpNoteVO) {
		this.priSpScpNoteVO = priSpScpNoteVO;
	}


	public PriSpScpNoteListVO getPriSpScpNoteListVO() {
		return priSpScpNoteListVO;
	}


	public void setPriSpScpNoteListVO(PriSpScpNoteListVO priSpScpNoteListVO) {
		this.priSpScpNoteListVO = priSpScpNoteListVO;
	}

	
}