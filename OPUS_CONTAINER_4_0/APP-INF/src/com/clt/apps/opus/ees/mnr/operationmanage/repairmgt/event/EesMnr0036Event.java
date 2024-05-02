/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesMnr0036Event.java
 *@FileTitle : Document Transmission - Popup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.03
 *@LastModifier : 함형석
 *@LastVersion : 1.0
 * 2009.08.03 함형석
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.DocGRPVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESS_MNR_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESS_MNR_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 함형석
 * @see EES_MNR_0036HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0036Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EesMnr0036Event(){}   
	
	/** Document Transmission 조회 조건 및 단건 처리  */
	private DocGRPVO docGRPVO = null;

	public DocGRPVO getDocGRPVO() {
		return docGRPVO; 
	}

	public void setDocGRPVO(DocGRPVO docGRPVO) {
		this.docGRPVO = docGRPVO;
	} 
}