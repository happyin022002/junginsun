/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NotePropVO.java
*@FileTitle : NotePropVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.12 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo;

import java.io.Serializable;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NotePropVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private PriSpScpNoteListVO priSpScpNoteListVO = null;
	private PriSpScpNoteListVO[] priSpScpNoteListVOs = null;
	private PriSpScpNoteCtntListVO[] priSpScpNoteCtntListVOs = null;
	//MASTER DELETE ROW YES/NO
	private String masterDelChk = "";
	

	public PriSpScpNoteListVO[] getPriSpScpNoteListVOs() {
		return priSpScpNoteListVOs;
	}
	public void setPriSpScpNoteListVOs(PriSpScpNoteListVO[] priSpScpNoteListVOs) {
		this.priSpScpNoteListVOs = priSpScpNoteListVOs;
	}
	
	public PriSpScpNoteCtntListVO[] getPriSpScpNoteCtntListVOs() {
		return priSpScpNoteCtntListVOs;
	}
	public void setPriSpScpNoteCtntListVOs(
			PriSpScpNoteCtntListVO[] priSpScpNoteCtntListVOs) {
		this.priSpScpNoteCtntListVOs = priSpScpNoteCtntListVOs;
	}
	public String getMasterDelChk() {
		return masterDelChk;
	}
	public void setMasterDelChk(String masterDelChk) {
		this.masterDelChk = masterDelChk;
	}
	public PriSpScpNoteListVO getPriSpScpNoteListVO() {
		return priSpScpNoteListVO;
	}
	public void setPriSpScpNoteListVO(PriSpScpNoteListVO priSpScpNoteListVO) {
		this.priSpScpNoteListVO = priSpScpNoteListVO;
	}
	
	
	
}
