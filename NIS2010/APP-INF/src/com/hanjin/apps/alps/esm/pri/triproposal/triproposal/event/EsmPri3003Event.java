/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri3003Event.java
*@FileTitle : TRI Creation &amp; Amendment - Note Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.30 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTriNoteConvVO;


/**
 * ESM_PRI_3003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_3003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTriNoteConvVO priTriNoteConvVO = null;
	
	public EsmPri3003Event(){}
	
	public void setPriTriNoteConvVO(PriTriNoteConvVO priTriNoteConvVO){
		this. priTriNoteConvVO = priTriNoteConvVO;
	}

	public PriTriNoteConvVO getPriTriNoteConvVO(){
		return priTriNoteConvVO;
	}
}