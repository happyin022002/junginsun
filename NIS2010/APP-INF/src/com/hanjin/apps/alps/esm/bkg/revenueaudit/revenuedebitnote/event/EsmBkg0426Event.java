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
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltSearchRDNIssueMailingListVO;
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

public class EsmBkg0426Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	RevDrNoteVO revDrNoteVO = new RevDrNoteVO();
	
	private RsltSearchRDNIssueMailingListVO rsltSearchRDNIssueMailingListVO = null;
	public RsltSearchRDNIssueMailingListVO[] rsltSearchRDNIssueMailingListVOs = null;
	
	public EsmBkg0426Event(){}

	/* set */
	public void setRevDrNoteVO(RevDrNoteVO revDrNoteVO) {
		this.revDrNoteVO = revDrNoteVO;
	}

	public void setRsltSearchRDNIssueMailingListVO(RsltSearchRDNIssueMailingListVO rsltSearchRDNIssueMailingListVO) {
		this.rsltSearchRDNIssueMailingListVO = rsltSearchRDNIssueMailingListVO;
	}
	public void setRsltSearchRDNIssueMailingListVOS(RsltSearchRDNIssueMailingListVO[] rsltSearchRDNIssueMailingListVOs) {
		this.rsltSearchRDNIssueMailingListVOs = rsltSearchRDNIssueMailingListVOs;
	}
	
	/* get */
	public RevDrNoteVO getRevDrNoteVO() {
		return revDrNoteVO;
	}

	public RsltSearchRDNIssueMailingListVO getRsltSearchRDNIssueMailingListVO() {
		return this.rsltSearchRDNIssueMailingListVO;
	}	
	public RsltSearchRDNIssueMailingListVO[] getRsltSearchRDNIssueMailingListVOS() {
		return this.rsltSearchRDNIssueMailingListVOs;
	}	
	
}