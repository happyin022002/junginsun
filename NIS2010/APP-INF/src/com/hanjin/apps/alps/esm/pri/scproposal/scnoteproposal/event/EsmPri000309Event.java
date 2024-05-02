/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000309Event.java
*@FileTitle : S/C Proposal Standard Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.04 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteHeaderVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriSpScpNoteVO;


/**
 * ESM_PRI_0003_09 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0003_09HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0003_09HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri000309Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteCtntListVO rsltNoteCtntListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltNoteCtntListVO[] rsltNoteCtntListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteHeaderVO rsltNoteHeaderVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltNoteHeaderVO[] rsltNoteHeaderVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteListVO rsltNoteListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltNoteListVO[] rsltNoteListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteVO priSpScpNoteVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpNoteVO[] priSpScpNoteVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteCtntVO priSpScpNoteCtntVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteListVO priSpScpNoteListVO = null;
	

	public EsmPri000309Event(){}
	
	public void setRsltNoteCtntListVO(RsltNoteCtntListVO rsltNoteCtntListVO){
		this. rsltNoteCtntListVO = rsltNoteCtntListVO;
	}

	public void setRsltNoteCtntListVOS(RsltNoteCtntListVO[] rsltNoteCtntListVOs){
		this. rsltNoteCtntListVOs = rsltNoteCtntListVOs;
	}

	public void setRsltNoteHeaderVO(RsltNoteHeaderVO rsltNoteHeaderVO){
		this. rsltNoteHeaderVO = rsltNoteHeaderVO;
	}

	public void setRsltNoteHeaderVOS(RsltNoteHeaderVO[] rsltNoteHeaderVOs){
		this. rsltNoteHeaderVOs = rsltNoteHeaderVOs;
	}

	public void setRsltNoteListVO(RsltNoteListVO rsltNoteListVO){
		this. rsltNoteListVO = rsltNoteListVO;
	}

	public void setRsltNoteListVOS(RsltNoteListVO[] rsltNoteListVOs){
		this. rsltNoteListVOs = rsltNoteListVOs;
	}

	public void setPriSpScpNoteVO(PriSpScpNoteVO priSpScpNoteVO){
		this. priSpScpNoteVO = priSpScpNoteVO;
	}

	public void setPriSpScpNoteVOS(PriSpScpNoteVO[] priSpScpNoteVOs){
		this. priSpScpNoteVOs = priSpScpNoteVOs;
	}

	public RsltNoteCtntListVO getRsltNoteCtntListVO(){
		return rsltNoteCtntListVO;
	}

	public RsltNoteCtntListVO[] getRsltNoteCtntListVOS(){
		return rsltNoteCtntListVOs;
	}

	public RsltNoteHeaderVO getRsltNoteHeaderVO(){
		return rsltNoteHeaderVO;
	}

	public RsltNoteHeaderVO[] getRsltNoteHeaderVOS(){
		return rsltNoteHeaderVOs;
	}

	public RsltNoteListVO getRsltNoteListVO(){
		return rsltNoteListVO;
	}

	public RsltNoteListVO[] getRsltNoteListVOS(){
		return rsltNoteListVOs;
	}

	public PriSpScpNoteVO getPriSpScpNoteVO(){
		return priSpScpNoteVO;
	}

	public PriSpScpNoteVO[] getPriSpScpNoteVOS(){
		return priSpScpNoteVOs;
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