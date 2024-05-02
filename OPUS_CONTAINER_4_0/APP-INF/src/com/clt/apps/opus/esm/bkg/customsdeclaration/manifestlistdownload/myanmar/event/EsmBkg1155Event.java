/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1141Event.java
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.03
 *@LastModifier : 변종건
 *@LastVersion : 1.0
 * 2012.02.03 변종건
 * 1.0 Creation
 * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event.ESM_BKG_1141HTMLAction;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1149 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1149HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Do Wan
 * @see ESM_BKG_1141HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1155Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ManifestListCondVO manifestListCondVO = null;
	private MyanmarManifestListCondVO myanmarManifestListCondVO = null;
	private MyanmarManifestListCondVO[] myanmarManifestListCondVOs = null;
	private ManifestTransmitVO manifestTransmitVO = null;
	private ManifestTransmitVO[] manifestTransmitVOs = null;


	private String polCd = null;
	private String podCd = null;
	private String key = "";
	private String polGubun = null;

	public EsmBkg1155Event() {}

	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}

	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}

	public MyanmarManifestListCondVO getMyanmarManifestListCondVO() {
		return myanmarManifestListCondVO;
	}

	public void setMyanmarManifestListCondVO(
			MyanmarManifestListCondVO myanmarManifestListCondVO) {
		this.myanmarManifestListCondVO = myanmarManifestListCondVO;
	}

	public MyanmarManifestListCondVO[] getMyanmarManifestListCondVOs() {
		MyanmarManifestListCondVO[] rtnVOs = null;
		if (this.myanmarManifestListCondVOs != null) {
			rtnVOs = Arrays.copyOf(myanmarManifestListCondVOs, myanmarManifestListCondVOs.length);
		}
		return rtnVOs;
	}

	public void setMyanmarManifestListCondVOs(MyanmarManifestListCondVO[] myanmarManifestListCondVOs) {
		if (myanmarManifestListCondVOs != null) {
			MyanmarManifestListCondVO[] tmpVOs = Arrays.copyOf(myanmarManifestListCondVOs, myanmarManifestListCondVOs.length);
			this.myanmarManifestListCondVOs = tmpVOs;
		}
	}

	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}

	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}

	public ManifestTransmitVO[] getManifestTransmitVOs() {
		ManifestTransmitVO[] rtnVOs = null;
		if (this.manifestTransmitVOs != null) {
			rtnVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
		}
		return rtnVOs;
	}

	public void setManifestTransmitVOs(ManifestTransmitVO[] manifestTransmitVOs) {
		if (manifestTransmitVOs != null) {
			ManifestTransmitVO[] tmpVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
			this.manifestTransmitVOs = tmpVOs;
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

	public String getPolGubun() {
		return polGubun;
	}

	public void setPolGubun(String polGubun) {
		this.polGubun = polGubun;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}