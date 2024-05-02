/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1049Event.java
*@FileTitle : Unmatch Details
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.05 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchItemListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_1049HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1049Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchUnmatchItemListVO rsltSearchUnmatchItemListVO = null;

	/* set */
	public void setRsltSearchUnmatchItemListVO(RsltSearchUnmatchItemListVO rsltSearchUnmatchItemListVO) {
		this.rsltSearchUnmatchItemListVO = rsltSearchUnmatchItemListVO;
	}
	
	/* get */
	public RsltSearchUnmatchItemListVO getRsltSearchUnmatchItemListVO() {
		return rsltSearchUnmatchItemListVO;
	}
	
}