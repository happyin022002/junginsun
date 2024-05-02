/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1055Event.java
*@FileTitle : Unmatch Description
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.05 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchTypeListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_1055HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchUnmatchTypeListVO rsltSearchUnmatchTypeListVO = null;

	/* set */
	public void setRsltSearchUnmatchTypeListVO(RsltSearchUnmatchTypeListVO rsltSearchUnmatchTypeListVO) {
		this.rsltSearchUnmatchTypeListVO = rsltSearchUnmatchTypeListVO;
	}
	
	/* get */
	public RsltSearchUnmatchTypeListVO getRsltSearchUnmatchTypeListVO() {
		return rsltSearchUnmatchTypeListVO;
	}
	
}