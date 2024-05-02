/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0426Event.java
*@FileTitle : RDN Issuance by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.AttachmentVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0426 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0426HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_BKG_0426HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1408Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	RevDrNoteVO revDrNoteVO = new RevDrNoteVO();
	
	private AttachmentVO attachmentVO = null;
	public AttachmentVO[] attachmentVOs = null;
	public String[] keys = null;
	
	public EsmBkg1408Event(){}

	/* set */
	public void setRevDrNoteVO(RevDrNoteVO revDrNoteVO) {
		this.revDrNoteVO = revDrNoteVO;
	}

	public void setAttachmentVO(AttachmentVO attachmentVO) {
		this.attachmentVO = attachmentVO;
	}
	public void setAttachmentVOS(AttachmentVO[] attachmentVOs) {
		this.attachmentVOs = attachmentVOs;
	}

	public void setKeys(String[] keys) {
		this.keys = keys;
	}
	
	/* get */
	public RevDrNoteVO getRevDrNoteVO() {
		return revDrNoteVO;
	}

	public AttachmentVO getAttachmentVO() {
		return this.attachmentVO;
	}	
	public AttachmentVO[] getAttachmentVOS() {
		return this.attachmentVOs;
	}	
	public String[] getKeys() {
		return this.keys;
	}
	
}