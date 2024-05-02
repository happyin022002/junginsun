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
package com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.event;


import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteHeaderVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpNoteCtntVO;
import com.clt.syscommon.common.table.PriSpScpNoteVO;


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
		if (rsltNoteCtntListVOs != null) {
			RsltNoteCtntListVO[] tmpVOs = new RsltNoteCtntListVO[rsltNoteCtntListVOs.length];
			System.arraycopy(rsltNoteCtntListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltNoteCtntListVOs = tmpVOs;
		}
	}

	public void setRsltNoteHeaderVO(RsltNoteHeaderVO rsltNoteHeaderVO){
		this. rsltNoteHeaderVO = rsltNoteHeaderVO;
	}

	public void setRsltNoteHeaderVOS(RsltNoteHeaderVO[] rsltNoteHeaderVOs){
		if (rsltNoteHeaderVOs != null) {
			RsltNoteHeaderVO[] tmpVOs = new RsltNoteHeaderVO[rsltNoteHeaderVOs.length];
			System.arraycopy(rsltNoteHeaderVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltNoteHeaderVOs = tmpVOs;
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

	public void setPriSpScpNoteVO(PriSpScpNoteVO priSpScpNoteVO){
		this. priSpScpNoteVO = priSpScpNoteVO;
	}

	public void setPriSpScpNoteVOS(PriSpScpNoteVO[] priSpScpNoteVOs){
		if (priSpScpNoteVOs != null) {
			PriSpScpNoteVO[] tmpVOs = new PriSpScpNoteVO[priSpScpNoteVOs.length];
			System.arraycopy(priSpScpNoteVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpNoteVOs = tmpVOs;
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

	public RsltNoteHeaderVO getRsltNoteHeaderVO(){
		return rsltNoteHeaderVO;
	}

	public RsltNoteHeaderVO[] getRsltNoteHeaderVOS(){
		RsltNoteHeaderVO[] tmpVOs = null;
		if (this.rsltNoteHeaderVOs != null) {
			tmpVOs = new RsltNoteHeaderVO[rsltNoteHeaderVOs.length];
			System.arraycopy(rsltNoteHeaderVOs, 0, tmpVOs, 0, tmpVOs.length);
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

	public PriSpScpNoteVO getPriSpScpNoteVO(){
		return priSpScpNoteVO;
	}

	public PriSpScpNoteVO[] getPriSpScpNoteVOS(){
		PriSpScpNoteVO[] tmpVOs = null;
		if (this.priSpScpNoteVOs != null) {
			tmpVOs = new PriSpScpNoteVO[priSpScpNoteVOs.length];
			System.arraycopy(priSpScpNoteVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
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