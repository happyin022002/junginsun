/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1056Event.java
*@FileTitle : ESM_BKG_1056
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;
import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSppVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * ESM_BKG_1056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son Yun Seuk
 * @see ESM_BKG_1056HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1056Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private KorCllSppVO[] korCllSppVOs = null;
	private String entryTp = null;

	public EsmBkg1056Event(){}

	public KorCllSppVO[] getKorCllSppVOs() {
		KorCllSppVO[] rtnVOs = null;
		if (this.korCllSppVOs != null) {
			rtnVOs = Arrays.copyOf(korCllSppVOs, korCllSppVOs.length);
		}
		return rtnVOs;
	}

	public void setKorCllSppVOs(KorCllSppVO[] korCllSppVOs) {
		if (korCllSppVOs != null) {
			KorCllSppVO[] tmpVOs = Arrays.copyOf(korCllSppVOs, korCllSppVOs.length);
			this.korCllSppVOs = tmpVOs;
		}
	}

	public String getEntryTp() {
		return entryTp;
	}

	public void setEntryTp(String entryTp) {
		this.entryTp = entryTp;
	}


}