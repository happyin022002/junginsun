/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000310Event.java
*@FileTitle : S/C Proposal Special Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.09 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.event;


import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.NotePropVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpNoteCtntVO;
import com.clt.syscommon.common.table.PriSpScpNoteVO;


/**
 * ESM_PRI_0003_10 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0003_10HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0003_10HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri000310Event extends EventSupport {

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

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpNoteCtntListVO[] priSpScpNoteCtntListVOs = null;
	

	public EsmPri000310Event(){}
	
	
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
		if (rsltNoteCtntListVOs != null) {
			RsltNoteCtntListVO[] tmpVOs = new RsltNoteCtntListVO[rsltNoteCtntListVOs.length];
			System.arraycopy(rsltNoteCtntListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltNoteCtntListVOs = tmpVOs;
		}
	}

	public void setPriSpScpNoteCtntVO(PriSpScpNoteCtntVO priSpScpNoteCtntVO){
		this. priSpScpNoteCtntVO = priSpScpNoteCtntVO;
	}

	public void setPriSpScpNoteCtntVOS(PriSpScpNoteCtntVO[] priSpScpNoteCtntVOs){
		if (priSpScpNoteCtntVOs != null) {
			PriSpScpNoteCtntVO[] tmpVOs = new PriSpScpNoteCtntVO[priSpScpNoteCtntVOs.length];
			System.arraycopy(priSpScpNoteCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpNoteCtntVOs = tmpVOs;
		}
	}

	public void setRsltNoteListVO(RsltNoteListVO rsltNoteListVO){
		this. rsltNoteListVO = rsltNoteListVO;
	}

	public void setRsltNoteListVOS(RsltNoteListVO[] rsltNoteListVOs){
		if (rsltNoteListVOs != null) {
			RsltNoteListVO[] tmpVOs = new RsltNoteListVO[rsltNoteListVOs.length];
			System.arraycopy(rsltNoteListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltNoteListVOs = tmpVOs;
		}
	}

	public RsltNoteCtntListVO getRsltNoteCtntListVO(){
		return rsltNoteCtntListVO;
	}

	public RsltNoteCtntListVO[] getRsltNoteCtntListVOS(){
		RsltNoteCtntListVO[] tmpVOs = null;
		if (this.rsltNoteCtntListVOs != null) {
			tmpVOs = new RsltNoteCtntListVO[rsltNoteCtntListVOs.length];
			System.arraycopy(rsltNoteCtntListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpScpNoteCtntVO getPriSpScpNoteCtntVO(){
		return priSpScpNoteCtntVO;
	}

	public PriSpScpNoteCtntVO[] getPriSpScpNoteCtntVOS(){
		PriSpScpNoteCtntVO[] tmpVOs = null;
		if (this.priSpScpNoteCtntVOs != null) {
			tmpVOs = new PriSpScpNoteCtntVO[priSpScpNoteCtntVOs.length];
			System.arraycopy(priSpScpNoteCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public RsltNoteListVO getRsltNoteListVO(){
		return rsltNoteListVO;
	}

	public RsltNoteListVO[] getRsltNoteListVOS(){
		RsltNoteListVO[] tmpVOs = null;
		if (this.rsltNoteListVOs != null) {
			tmpVOs = new RsltNoteListVO[rsltNoteListVOs.length];
			System.arraycopy(rsltNoteListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
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


	public PriSpScpNoteCtntListVO[] getPriSpScpNoteCtntListVOs() {
		PriSpScpNoteCtntListVO[] tmpVOs = null;
		if (this.priSpScpNoteCtntListVOs != null) {
			tmpVOs = new PriSpScpNoteCtntListVO[priSpScpNoteCtntListVOs.length];
			System.arraycopy(priSpScpNoteCtntListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}


	public void setPriSpScpNoteCtntListVOs(
			PriSpScpNoteCtntListVO[] priSpScpNoteCtntListVOs) {
		if (priSpScpNoteCtntListVOs != null) {
			PriSpScpNoteCtntListVO[] tmpVOs = new PriSpScpNoteCtntListVO[priSpScpNoteCtntListVOs.length];
			System.arraycopy(priSpScpNoteCtntListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpNoteCtntListVOs = tmpVOs;
		}
	}


	
}