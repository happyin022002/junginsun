/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0578Event.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier :
*@LastVersion : 1.0
* 2009.08.24
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.event;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0578 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0578HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0578HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0578Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PSASendHistoryCondVO psaSendHistoryCondVO = null;

	public PSASendHistoryCondVO getPsaSendHistoryCondVO() {
		return psaSendHistoryCondVO;
	}

	public void setPsaSendHistoryCondVO(PSASendHistoryCondVO psaSendHistoryCondVO) {
		this.psaSendHistoryCondVO = psaSendHistoryCondVO;
	}

}

