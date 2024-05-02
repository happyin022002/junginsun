/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0017Event.java
 *@FileTitle : ESM_BKG-0017
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.21 김승민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG-0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0017HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PanamaManifestListCondVO panamaManifestListCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private PanamaManifestListCondVO[] panamaManifestListCondVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PanamaContainerVO panamaContainerVO = null;

	/** Table Value Object Multi Data 처리 */
	private PanamaContainerVO[] panamaContainerVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ManifestTransmitVO manifestTransmitVO = null;

	/** Table Value Object Multi Data 처리 */
	private ManifestTransmitVO[] manifestTransmitVOs = null;

	private String key = "";

	public EsmBkg0017Event() {
	}

	public void setPanamaManifestListCondVO(PanamaManifestListCondVO panamaManifestListCondVO) {
		this.panamaManifestListCondVO = panamaManifestListCondVO;
	}

	public void setPanamaManifestListCondVOS(PanamaManifestListCondVO[] panamaManifestListCondVOs) {
		if (panamaManifestListCondVOs != null)
			this.panamaManifestListCondVOs = Arrays.copyOf(panamaManifestListCondVOs, panamaManifestListCondVOs.length);
	}

	public void setPanamaContainerVO(PanamaContainerVO panamaContainerVO) {
		this.panamaContainerVO = panamaContainerVO;
	}

	public void setPanamaContainerVOS(PanamaContainerVO[] panamaContainerVOs) {
		if (panamaContainerVOs != null)
			this.panamaContainerVOs = Arrays.copyOf(panamaContainerVOs, panamaContainerVOs.length);
	}

	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}

	public void setManifestTransmitVOS(ManifestTransmitVO[] manifestTransmitVOs) {
		if (manifestTransmitVOs != null)
			this.manifestTransmitVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
	}

	public PanamaManifestListCondVO getPanamaManifestListCondVO() {
		return panamaManifestListCondVO;
	}

	public PanamaManifestListCondVO[] getPanamaManifestListCondVOS() {
		PanamaManifestListCondVO[] rtnVOs = null;
		if (panamaManifestListCondVOs != null)
			rtnVOs = Arrays.copyOf(panamaManifestListCondVOs, panamaManifestListCondVOs.length);
		return rtnVOs;
	}

	public PanamaContainerVO getPanamaContainerVO() {
		return panamaContainerVO;
	}

	public PanamaContainerVO[] getPanamaContainerVOS() {
		PanamaContainerVO[] rtnVOs = null;
		if (panamaContainerVOs != null)
			rtnVOs = Arrays.copyOf(panamaContainerVOs, panamaContainerVOs.length);
		return rtnVOs;
	}

	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}

	public ManifestTransmitVO[] getManifestTransmitVOS() {
		ManifestTransmitVO[] rtnVOs = null;
		if (manifestTransmitVOs != null)
			rtnVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
		return rtnVOs;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}