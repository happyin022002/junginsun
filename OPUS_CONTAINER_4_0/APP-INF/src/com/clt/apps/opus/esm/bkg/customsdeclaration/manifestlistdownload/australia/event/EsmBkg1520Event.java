/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmBkg1520Event.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgListCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1520에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1520HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1520HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1520Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AusDgListCondVO ausDgListCondVO = null;

	private AusDgEdiVO[] ausDgEdiVOs = null;

	public AusDgListCondVO getAusDgListCondVO() {
		return ausDgListCondVO;
	}

	public void setAusDgListCondVO(AusDgListCondVO ausDgListCondVO) {
		this.ausDgListCondVO = ausDgListCondVO;
	}

	public AusDgEdiVO[] getAusDgEdiVOs() {
		AusDgEdiVO[] rtnVOs = null;
		if (this.ausDgEdiVOs != null) {
			rtnVOs = Arrays.copyOf(ausDgEdiVOs, ausDgEdiVOs.length);
		}
		return rtnVOs;
	}

	public void setAusDgEdiVOs(AusDgEdiVO[] ausDgEdiVOs) {
		if (ausDgEdiVOs != null) {
			AusDgEdiVO[] tmpVOs = Arrays.copyOf(ausDgEdiVOs, ausDgEdiVOs.length);
			this.ausDgEdiVOs = tmpVOs;
		}
	}



}
