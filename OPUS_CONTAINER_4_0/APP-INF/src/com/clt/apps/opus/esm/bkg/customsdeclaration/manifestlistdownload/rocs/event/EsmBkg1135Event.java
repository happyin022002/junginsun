/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1135Event.java
 *@FileTitle : ESM_BKG_1135
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.12
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2011.10.12 김보배
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;

import java.util.Arrays;

import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1135HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author BOBAE KIM
 * @see ESM_BKG_1135HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1135Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs = null;

	public BkgHrdCdgCtntVO[] getBkgHrdCdgCtntVOs() {
		BkgHrdCdgCtntVO[] rtnVOs = null;
		if (bkgHrdCdgCtntVOs != null)
			rtnVOs = Arrays.copyOf(bkgHrdCdgCtntVOs, bkgHrdCdgCtntVOs.length);
		return rtnVOs;
	}

	public void setBkgHrdCdgCtntVOs(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs) {
		if (bkgHrdCdgCtntVOs != null)
			this.bkgHrdCdgCtntVOs = Arrays.copyOf(bkgHrdCdgCtntVOs, bkgHrdCdgCtntVOs.length);
	}
}