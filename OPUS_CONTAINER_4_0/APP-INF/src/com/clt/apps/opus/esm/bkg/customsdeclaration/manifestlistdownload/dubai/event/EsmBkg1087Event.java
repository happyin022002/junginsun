/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1087Event.java
 *@FileTitle : DubaiManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.02.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.ESM_BKG_0016HTMLAction;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1087 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1087HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Min Jeong
 * @see ESM_BKG_0016HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1087Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ManifestListCondVO manifestListCondVO = null;
	private CstmsBlVO[] cstmsBlVOs = null;

	public EsmBkg1087Event() {}

	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}

	public void setCstmsBlVOs(CstmsBlVO[] cstmsBlVOs) {
		if (cstmsBlVOs != null) {
			CstmsBlVO[] tmpVOs = Arrays.copyOf(cstmsBlVOs, cstmsBlVOs.length);
			this.cstmsBlVOs = tmpVOs;
		}
	}

	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}

	public CstmsBlVO[] getCstmsBlVOs() {
		CstmsBlVO[] rtnVOs = null;
		if (this.cstmsBlVOs != null) {
			rtnVOs = Arrays.copyOf(cstmsBlVOs, cstmsBlVOs.length);
		}
		return rtnVOs;
	}
}
