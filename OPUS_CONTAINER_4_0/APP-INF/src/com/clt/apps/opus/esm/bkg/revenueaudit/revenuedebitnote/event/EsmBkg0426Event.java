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
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltSearchRDNIssueMailingListVO;
import com.clt.framework.support.layer.event.EventSupport;


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
	private RsltSearchRDNIssueMailingListVO[] rsltSearchRDNIssueMailingListVOs = null;
	
	public EsmBkg0426Event(){}

	/* set */
	public void setRevDrNoteVO(RevDrNoteVO revDrNoteVO) {
		this.revDrNoteVO = revDrNoteVO;
	}

	public void setRsltSearchRDNIssueMailingListVO(RsltSearchRDNIssueMailingListVO rsltSearchRDNIssueMailingListVO) {
		this.rsltSearchRDNIssueMailingListVO = rsltSearchRDNIssueMailingListVO;
	}
	/* get */
	public RevDrNoteVO getRevDrNoteVO() {
		return revDrNoteVO;
	}

	public RsltSearchRDNIssueMailingListVO getRsltSearchRDNIssueMailingListVO() {
		return this.rsltSearchRDNIssueMailingListVO;
	}

	public RsltSearchRDNIssueMailingListVO[] getRsltSearchRDNIssueMailingListVOS() {
		RsltSearchRDNIssueMailingListVO[] rtnVOs = null;
		if (this.rsltSearchRDNIssueMailingListVOs != null) {
			rtnVOs = Arrays.copyOf(rsltSearchRDNIssueMailingListVOs,rsltSearchRDNIssueMailingListVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltSearchRDNIssueMailingListVOS(RsltSearchRDNIssueMailingListVO[] rsltSearchRDNIssueMailingListVOs) {
		if (rsltSearchRDNIssueMailingListVOs != null) {
			RsltSearchRDNIssueMailingListVO[] tmpVOs = Arrays.copyOf(rsltSearchRDNIssueMailingListVOs,rsltSearchRDNIssueMailingListVOs.length);
			this.rsltSearchRDNIssueMailingListVOs = tmpVOs;
		}
	}	
	
}