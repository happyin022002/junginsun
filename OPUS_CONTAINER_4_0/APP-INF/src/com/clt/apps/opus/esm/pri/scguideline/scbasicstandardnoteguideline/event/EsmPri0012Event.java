/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0008Event.java
*@FileTitle : Standard Note Conversion Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.23 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriScNoteConvVO;


/**
 * ESM_PRI_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScNoteConvVO priScNoteConvVO = null;
	
	public EsmPri0012Event(){}
	
	public void setPriScNoteConvVO(PriScNoteConvVO priScNoteConvVO){
		this. priScNoteConvVO = priScNoteConvVO;
	}
	
	
	public PriScNoteConvVO getPriScNoteConvVO(){
		return priScNoteConvVO;
	}
}