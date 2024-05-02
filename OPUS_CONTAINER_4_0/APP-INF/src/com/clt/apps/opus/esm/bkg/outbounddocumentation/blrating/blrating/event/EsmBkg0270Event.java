/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0270Event.java
*@FileTitle : Freight & Charge_S/C Note
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteInVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0270 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0270HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0270HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0270Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsmBkg0270Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScNoteInVO scNoteInVO = null;
	/** Table Value Object Multi Data 처리 */
	private ScNoteInVO[] scNoteInVOs = null;
	/**
	 * @return the scNoteInVO
	 */
	public ScNoteInVO getScNoteInVO() {
		return scNoteInVO;
	}

	/**
	 * @param scNoteInVO the scNoteInVO to set
	 */
	public void setScNoteInVO(ScNoteInVO scNoteInVO) {
		this.scNoteInVO = scNoteInVO;
	}

	public ScNoteInVO[] getScNoteInVOs() {
		ScNoteInVO[] rtnVOs = null;
		if (this.scNoteInVOs != null) {
			rtnVOs = Arrays.copyOf(scNoteInVOs, scNoteInVOs.length);
		}
		return rtnVOs;
	}

	public void setScNoteInVOs(ScNoteInVO[] scNoteInVOs) {
		if (scNoteInVOs != null) {
			ScNoteInVO[] tmpVOs = Arrays.copyOf(scNoteInVOs, scNoteInVOs.length);
			this.scNoteInVOs = tmpVOs;
		}
	}






}