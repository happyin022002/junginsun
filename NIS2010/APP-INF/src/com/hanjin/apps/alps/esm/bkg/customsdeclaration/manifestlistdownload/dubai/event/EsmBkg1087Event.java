/*=========================================================
 *Copyright(c) 2017 SM Line
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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.ESM_BKG_0016HTMLAction;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.hanjin.framework.support.layer.event.EventSupport;

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
		this.cstmsBlVOs = cstmsBlVOs;
	}
	
	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}
	
	public CstmsBlVO[] getCstmsBlVOs() {
		return cstmsBlVOs;
	}
}
