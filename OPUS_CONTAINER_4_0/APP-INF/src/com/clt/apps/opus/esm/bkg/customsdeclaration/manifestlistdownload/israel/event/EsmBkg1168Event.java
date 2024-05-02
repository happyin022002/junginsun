/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EsmBkg1168Event.java
 *@FileTitle : ESM_BKG_1168
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.08.11
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2013.08.11 김보배
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.IsraelManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1168 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1168HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author BOBAE KIM
 * @see ESM_BKG_1168HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1168Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private ManifestListCondVO manifestListCondVO = null;
	private ManifestTransmitVO manifestTransmitVO = null;
	private ManifestTransmitVO[] manifestTransmitVOs = null;
	private IsraelManifestTransmitVO israelManifestTransmitVO = null;
	private IsraelManifestTransmitVO[] israelManifestTransmitVOs = null;

	private String polCd = null;
	private String podCd = null;
	private String key = "";

	public EsmBkg1168Event() {
	}

	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}

	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}

	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}

	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}

	public ManifestTransmitVO[] getManifestTransmitVOs() {
		ManifestTransmitVO[] rtnVOs = null;
		if (manifestTransmitVOs != null)
			rtnVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
		return rtnVOs;
	}

	public void setManifestTransmitVOs(ManifestTransmitVO[] manifestTransmitVOs) {
		if (manifestTransmitVOs != null)
			this.manifestTransmitVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
	}

	public IsraelManifestTransmitVO getIsraelManifestTransmitVO() {
		return israelManifestTransmitVO;
	}

	public void setIsraelManifestTransmitVO(IsraelManifestTransmitVO israelManifestTransmitVO) {
		this.israelManifestTransmitVO = israelManifestTransmitVO;
	}

	public IsraelManifestTransmitVO[] getIsraelManifestTransmitVOs() {
		IsraelManifestTransmitVO[] rtnVOs = null;
		if (israelManifestTransmitVOs != null)
			rtnVOs = Arrays.copyOf(israelManifestTransmitVOs, israelManifestTransmitVOs.length);
		return rtnVOs;
	}

	public void setIsraelManifestTransmitVOs(IsraelManifestTransmitVO[] israelManifestTransmitVOs) {
		if (israelManifestTransmitVOs != null)
			this.israelManifestTransmitVOs = Arrays.copyOf(israelManifestTransmitVOs, israelManifestTransmitVOs.length);
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}