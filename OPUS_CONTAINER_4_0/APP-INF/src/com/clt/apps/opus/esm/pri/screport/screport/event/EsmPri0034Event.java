/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0039Event.java
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.06.25 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.event;

import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchNoteCtntVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * ESM_PRI_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0039HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchNoteCtntVO rsltSearchNoteCtntVO = null;

	public EsmPri0034Event(){}
	
	public void setRsltSearchNoteCtntVO(RsltSearchNoteCtntVO rsltSearchNoteCtntVO){
		this.rsltSearchNoteCtntVO = rsltSearchNoteCtntVO;
	}
	
	
	public RsltSearchNoteCtntVO getRsltSearchNoteCtntVO(){
		return this.rsltSearchNoteCtntVO;
	}
	
	
}