/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmPri4005Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.05.06 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.event;

import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo.NoteConversionGroupLocationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_4005HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri4005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private NoteConversionGroupLocationVO noteConversionGroupLocationVO = new NoteConversionGroupLocationVO();

	public EsmPri4005Event(){}

	
	public NoteConversionGroupLocationVO getNoteConversionGroupLocationVO() {
		return noteConversionGroupLocationVO;
	}

	public void setNoteConversionGroupLocationVO(
			NoteConversionGroupLocationVO noteConversionGroupLocationVO) {
		this.noteConversionGroupLocationVO = noteConversionGroupLocationVO;
	}


}