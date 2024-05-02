/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1148Event.java
 *@FileTitle : Pakistan Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.18
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.07.18 김보배
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1148 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1148HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author BOBAE KIM
 * @see ESM_BKG_1148HTMLAction 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class EsmBkg1148Event extends EventSupport {

	public EsmBkg1148Event() {}

	private PakistanManifestListCondVO pakistanManifestListCondVO = null;
	private PakistanManifestListCondVO[] pakistanManifestListCondVOs = null;

	private String polCd = null;
	private String podCd = null;

	public PakistanManifestListCondVO getPakistanManifestListCondVO() {
		return pakistanManifestListCondVO;
	}

	public void setPakistanManifestListCondVO(PakistanManifestListCondVO pakistanManifestListCondVO) {
		this.pakistanManifestListCondVO = pakistanManifestListCondVO;
	}

	public PakistanManifestListCondVO[] getPakistanManifestListCondVOs() {
		PakistanManifestListCondVO[] rtnVOs = null;
		if (this.pakistanManifestListCondVOs != null) {
			rtnVOs = Arrays.copyOf(pakistanManifestListCondVOs, pakistanManifestListCondVOs.length);
		}
		return rtnVOs;
	}

	public void setPakistanManifestListCondVOs(PakistanManifestListCondVO[] pakistanManifestListCondVOs) {
		if (pakistanManifestListCondVOs != null) {
			PakistanManifestListCondVO[] tmpVOs = Arrays.copyOf(pakistanManifestListCondVOs, pakistanManifestListCondVOs.length);
			this.pakistanManifestListCondVOs = tmpVOs;
		}
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String getPodCd() {
		return podCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

}