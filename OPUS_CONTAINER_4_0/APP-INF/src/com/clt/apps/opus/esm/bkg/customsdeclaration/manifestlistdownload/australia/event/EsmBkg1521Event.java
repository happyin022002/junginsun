/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1521Event.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSendHistoryCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1521에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1521HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1521HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1521Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AusSendHistoryCondVO ausSendHistoryCondVO = null;

	public AusSendHistoryCondVO getAusSendHistoryCondVO() {
		return ausSendHistoryCondVO;
	}

	public void setAusSendHistoryCondVO(AusSendHistoryCondVO ausSendHistoryCondVO) {
		this.ausSendHistoryCondVO = ausSendHistoryCondVO;
	}


}
