/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1106Event.java
 *@FileTitle : ESM_BKG-1106
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.09.03
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2010.09.03 김경섭
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eu24ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24CountryListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-1106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG-1106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author KIM GYOUNG SUB
 * @see ESM_BKG_1106HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1106Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private String key = "";

	private Eu24CountryListVO eu24CountryListVO = null;
	private ManifestListCondVO manifestListCondVO = null;
	private ManifestListDetailVO[] eu24ManifestListVOs = null;
	private Eu24ManifestTransmitVO[] eu24ManifestTransmitVOs = null;

	public Eu24CountryListVO getEu24CountryListVO() {
		return eu24CountryListVO;
	}

	public void setEu24CountryListVO(Eu24CountryListVO eu24CountryListVO) {
		this.eu24CountryListVO = eu24CountryListVO;
	}

	public Eu24ManifestTransmitVO[] getEu24ManifestTransmitVOs() {
		Eu24ManifestTransmitVO[] rtnVOs = null;
		if (eu24ManifestTransmitVOs != null)
			rtnVOs = Arrays.copyOf(eu24ManifestTransmitVOs, eu24ManifestTransmitVOs.length);
		return rtnVOs;
	}

	public void setEu24ManifestTransmitVOs(Eu24ManifestTransmitVO[] eu24ManifestTransmitVOs) {
		if (eu24ManifestTransmitVOs != null)
			this.eu24ManifestTransmitVOs = Arrays.copyOf(eu24ManifestTransmitVOs, eu24ManifestTransmitVOs.length);
	}

	public ManifestListDetailVO[] getEu24ManifestListVOs() {
		ManifestListDetailVO[] rtnVOs = null;
		if (eu24ManifestListVOs != null)
			rtnVOs = Arrays.copyOf(eu24ManifestListVOs, eu24ManifestListVOs.length);
		return rtnVOs;
	}

	public void setEu24ManifestListVOs(ManifestListDetailVO[] eu24ManifestListVOs) {
		if (eu24ManifestListVOs != null)
			this.eu24ManifestListVOs = Arrays.copyOf(eu24ManifestListVOs, eu24ManifestListVOs.length);
		;
	}

	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}

	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}

	public EsmBkg1106Event() {
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}