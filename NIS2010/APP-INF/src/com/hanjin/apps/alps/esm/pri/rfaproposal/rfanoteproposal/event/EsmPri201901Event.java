/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri201901Event.java
*@FileTitle : RFA Proposal Inquiry - Special Note
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.09 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRfaNoteConvVO;
import com.hanjin.syscommon.common.table.PriRpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriRpScpNoteVO;


/**
 * ESM_PRI_2019_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2019_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_2019_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri201901Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteCtntListVO rsltNoteCtntListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpNoteCtntVO priRpScpNoteCtntVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltNoteListVO rsltNoteListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpNoteVO priRpScpNoteVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpNoteListVO priRpScpNoteListVO = null;	
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRfaNoteConvVO priRfaNoteConvVO = null;
	
	public EsmPri201901Event(){}
	
	public void setRsltNoteCtntListVO(RsltNoteCtntListVO rsltNoteCtntListVO){
		this. rsltNoteCtntListVO = rsltNoteCtntListVO;
	}

	public void setPriRpScpNoteCtntVO(PriRpScpNoteCtntVO priRpScpNoteCtntVO){
		this. priRpScpNoteCtntVO = priRpScpNoteCtntVO;
	}
	public void setRsltNoteListVO(RsltNoteListVO rsltNoteListVO){
		this. rsltNoteListVO = rsltNoteListVO;
	}

	public RsltNoteCtntListVO getRsltNoteCtntListVO(){
		return rsltNoteCtntListVO;
	}

	public PriRpScpNoteCtntVO getPriRpScpNoteCtntVO(){
		return priRpScpNoteCtntVO;
	}

	public PriRfaNoteConvVO getPriRfaNoteConvVO() {
		return priRfaNoteConvVO;
	}


	public void setPriRfaNoteConvVO(PriRfaNoteConvVO priRfaNoteConvVO) {
		this.priRfaNoteConvVO = priRfaNoteConvVO;
	}


	public RsltNoteListVO getRsltNoteListVO(){
		return rsltNoteListVO;
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

	
}