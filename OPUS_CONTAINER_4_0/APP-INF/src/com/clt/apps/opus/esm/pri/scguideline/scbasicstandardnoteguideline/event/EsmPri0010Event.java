/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPri0005Event.java
*@FileTitle : Standard Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.17 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.event;

import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.StndNoteGlineVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgStndNoteCtntVO;
import com.clt.syscommon.common.table.PriSgStndNoteHdrVO;
import com.clt.syscommon.common.table.PriSgStndNoteVO;


/**
 * ui_pri_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ui_pri_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_0005HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgStndNoteVO prisgstndnotevo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgStndNoteCtntVO prisgstndnotectntvo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgStndNoteHdrVO prisgstndnotehdrvo = null;
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO = null;
	
	
	/** container vo  */
	public StndNoteGlineVO getStndnoteglinevo() {
		return stndnoteglinevo;
	}

	public void setStndnoteglinevo(StndNoteGlineVO stndnoteglinevo) {
		this.stndnoteglinevo = stndnoteglinevo;
	}

	private StndNoteGlineVO stndnoteglinevo = null;
	

	public EsmPri0010Event(){}
	
	public void setPriSgStndNoteVO(PriSgStndNoteVO prisgstndnotevo){
		this. prisgstndnotevo = prisgstndnotevo;
	}

	public void setPriSgStndNoteCtntVO(PriSgStndNoteCtntVO prisgstndnotectntvo){
		this. prisgstndnotectntvo = prisgstndnotectntvo;
	}


	public void setPriSgStndNoteHdrVO(PriSgStndNoteHdrVO prisgstndnotehdrvo){
		this. prisgstndnotehdrvo = prisgstndnotehdrvo;
	}


	public PriSgStndNoteVO getPriSgStndNoteVO(){
		return prisgstndnotevo;
	}

	public PriSgStndNoteCtntVO getPriSgStndNoteCtntVO(){
		return prisgstndnotectntvo;
	}

	public PriSgStndNoteHdrVO getPriSgStndNoteHdrVO(){
		return prisgstndnotehdrvo;
	}

	public RsltPriSgStndNoteHdrCopyVO getRsltPriSgStndNoteHdrCopyVO() {
		return rsltPriSgStndNoteHdrCopyVO;
	}

	public void setRsltPriSgStndNoteHdrCopyVO(
			RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO) {
		this.rsltPriSgStndNoteHdrCopyVO = rsltPriSgStndNoteHdrCopyVO;
	}
	

}