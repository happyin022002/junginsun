/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri200301Event.java
*@FileTitle : Proposal & Amendment Creation - Special Note
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.09 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.NotePropVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRfaNoteConvVO;
import com.clt.syscommon.common.table.PriRpScpNoteCtntVO;
import com.clt.syscommon.common.table.PriRpScpNoteVO;


/**
 * ESM_PRI_2003_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2003_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_2003_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri200301Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteCtntListVO rsltNoteCtntListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltNoteCtntListVO[] rsltNoteCtntListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpNoteCtntVO priRpScpNoteCtntVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteListVO rsltNoteListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltNoteListVO[] rsltNoteListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpNoteVO priRpScpNoteVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private NotePropVO notePropVO = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpNoteListVO priRpScpNoteListVO = null;	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRfaNoteConvVO priRfaNoteConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRfaNoteConvVO[] priRfaNoteConvVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRfaNoteConvListVO priRfaNoteConvListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRfaNoteConvListVO[] priRfaNoteConvListVOs = null;
	

	public EsmPri200301Event(){}
	
	
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

	public void setPriRpScpNoteCtntVO(PriRpScpNoteCtntVO priRpScpNoteCtntVO){
		this. priRpScpNoteCtntVO = priRpScpNoteCtntVO;
	}

	public void setPriRpScpNoteCtntVOS(PriRpScpNoteCtntVO[] priRpScpNoteCtntVOs){
		if (priRpScpNoteCtntVOs != null) {
			PriRpScpNoteCtntVO[] tmpVOs = new PriRpScpNoteCtntVO[priRpScpNoteCtntVOs.length];
			System.arraycopy(priRpScpNoteCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpNoteCtntVOs = tmpVOs;
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

	public PriRpScpNoteCtntVO getPriRpScpNoteCtntVO(){
		return priRpScpNoteCtntVO;
	}

	public PriRpScpNoteCtntVO[] getPriRpScpNoteCtntVOS(){
		PriRpScpNoteCtntVO[] tmpVOs = null;
		if (this.priRpScpNoteCtntVOs != null) {
			tmpVOs = new PriRpScpNoteCtntVO[priRpScpNoteCtntVOs.length];
			System.arraycopy(priRpScpNoteCtntVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriRfaNoteConvVO getPriRfaNoteConvVO() {
		return priRfaNoteConvVO;
	}


	public PriRfaNoteConvVO[] getPriRfaNoteConvVOs() {
		PriRfaNoteConvVO[] tmpVOs = null;
		if (this.priRfaNoteConvVOs != null) {
			tmpVOs = new PriRfaNoteConvVO[priRfaNoteConvVOs.length];
			System.arraycopy(priRfaNoteConvVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}


	public void setPriRfaNoteConvVO(PriRfaNoteConvVO priRfaNoteConvVO) {
		this.priRfaNoteConvVO = priRfaNoteConvVO;
	}


	public void setPriRfaNoteConvVOs(PriRfaNoteConvVO[] priRfaNoteConvVOs) {
		if (priRfaNoteConvVOs != null) {
			PriRfaNoteConvVO[] tmpVOs = new PriRfaNoteConvVO[priRfaNoteConvVOs.length];
			System.arraycopy(priRfaNoteConvVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRfaNoteConvVOs = tmpVOs;
		}
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

	public PriRpScpNoteVO getPriRpScpNoteVO() {
		return priRpScpNoteVO;
	}

	public void setPriRpScpNoteVO(PriRpScpNoteVO priRpScpNoteVO) {
		this.priRpScpNoteVO = priRpScpNoteVO;
	}


	public PriRpScpNoteListVO getPriRpScpNoteListVO() {
		return priRpScpNoteListVO;
	}


	public void setPriRpScpNoteListVO(PriRpScpNoteListVO priRpScpNoteListVO) {
		this.priRpScpNoteListVO = priRpScpNoteListVO;
	}


	public PriRfaNoteConvListVO getPriRfaNoteConvListVO() {
		return priRfaNoteConvListVO;
	}


	public PriRfaNoteConvListVO[] getPriRfaNoteConvListVOs() {
		PriRfaNoteConvListVO[] tmpVOs = null;
		if (this.priRfaNoteConvListVOs != null) {
			tmpVOs = new PriRfaNoteConvListVO[priRfaNoteConvListVOs.length];
			System.arraycopy(priRfaNoteConvListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}


	public void setPriRfaNoteConvListVO(PriRfaNoteConvListVO priRfaNoteConvListVO) {
		this.priRfaNoteConvListVO = priRfaNoteConvListVO;
	}


	public void setPriRfaNoteConvListVOs(PriRfaNoteConvListVO[] priRfaNoteConvListVOs) {
		if (priRfaNoteConvListVOs != null) {
			PriRfaNoteConvListVO[] tmpVOs = new PriRfaNoteConvListVO[priRfaNoteConvListVOs.length];
			System.arraycopy(priRfaNoteConvListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRfaNoteConvListVOs = tmpVOs;
		}
	}

	
}