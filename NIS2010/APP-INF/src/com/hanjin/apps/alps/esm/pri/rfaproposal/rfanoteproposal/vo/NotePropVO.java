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

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo;

import java.io.Serializable;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.hanjin.framework.component.common.AbstractValueObject;

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
	private PriRpScpNoteListVO[] priRpScpNoteListVOs = null;
	private PriRpScpNoteCtntListVO[] priRpScpNoteCtntListVOs = null;
	private PriRfaNoteConvListVO[] priRfaNoteConvListVOs = null;
	private PriRpScpNoteListVO priRpScpNoteListVO = null;
	
	//MASTER DELETE ROW YES/NO
	private String masterDelChk = "";
	

	public String getMasterDelChk() {
		return masterDelChk;
	}
	public void setMasterDelChk(String masterDelChk) {
		this.masterDelChk = masterDelChk;
	}

	public PriRpScpNoteListVO[] getPriRpScpNoteListVOs() {
		return priRpScpNoteListVOs;
	}

	public void setPriRpScpNoteListVOs(PriRpScpNoteListVO[] priRpScpNoteListVOs) {
		this.priRpScpNoteListVOs = priRpScpNoteListVOs;
	}

	public PriRfaNoteConvListVO[] getPriRfaNoteConvListVOs() {
		return priRfaNoteConvListVOs;
	}
	public void setPriRfaNoteConvListVOs(
			PriRfaNoteConvListVO[] priRfaNoteConvListVOs) {
		this.priRfaNoteConvListVOs = priRfaNoteConvListVOs;
	}
	public PriRpScpNoteCtntListVO[] getPriRpScpNoteCtntListVOs() {
		return priRpScpNoteCtntListVOs;
	}
	public void setPriRpScpNoteCtntListVOs(
			PriRpScpNoteCtntListVO[] priRpScpNoteCtntListVOs) {
		this.priRpScpNoteCtntListVOs = priRpScpNoteCtntListVOs;
	}
	public PriRpScpNoteListVO getPriRpScpNoteListVO() {
		return priRpScpNoteListVO;
	}
	public void setPriRpScpNoteListVO(PriRpScpNoteListVO priRpScpNoteListVO) {
		this.priRpScpNoteListVO = priRpScpNoteListVO;
	}
	
	
	
}
