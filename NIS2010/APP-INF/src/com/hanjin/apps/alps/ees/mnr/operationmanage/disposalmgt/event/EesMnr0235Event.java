/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesMnr0235Event.java
 *@FileTitle : Document Transmission - Popup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.01.14
 *@LastModifier : 김완규
 *@LastVersion : 1.0
 * 2010.01.14 김완규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.DocGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESS_MNR_0235 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESS_MNR_0235HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 김완규
 * @see EES_MNR_0235HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0235Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EesMnr0235Event(){}   
	
	/** Document Transmission 조회 조건 및 단건 처리  */
	private DocGRPVO docGRPVO = null;

	public DocGRPVO getDocGRPVO() {
		return docGRPVO;
	}

	public void setDocGRPVO(DocGRPVO docGRPVO) {
		this.docGRPVO = docGRPVO;
	}
}