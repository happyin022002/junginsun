/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1095Event.java
 *@FileTitle : AncsManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.20 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1095HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_1095HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1095Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs = null;
	

	public BkgHrdCdgCtntVO[] getBkgHrdCdgCtntVOs() {
		return bkgHrdCdgCtntVOs;
	}
	public void setBkgHrdCdgCtntVOs(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs) {
		this.bkgHrdCdgCtntVOs = bkgHrdCdgCtntVOs;
	}
	
	
	
	
	
	
	
}