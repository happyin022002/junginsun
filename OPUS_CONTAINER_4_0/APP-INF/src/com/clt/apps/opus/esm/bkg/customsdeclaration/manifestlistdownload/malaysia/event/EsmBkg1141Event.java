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
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1141 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1141HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Do Wan
 * @see ESM_BKG_1141HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1141Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private MalaysiaManifestListCondVO malaysiaManifestListCondVO = null;
	private MalaysiaManifestTransmitVO malaysiaManifestTransmitVO = null;

	private String polCd = null;
	private String podCd = null;
	private String key = "";

	public EsmBkg1141Event() {}

	public MalaysiaManifestListCondVO getMalaysiaManifestListCondVO() {
		return malaysiaManifestListCondVO;
	}

	public void setMalaysiaManifestListCondVO(MalaysiaManifestListCondVO malaysiaManifestListCondVO) {
		this.malaysiaManifestListCondVO = malaysiaManifestListCondVO;
	}

	public MalaysiaManifestTransmitVO getMalaysiaManifestTransmitVO() {
		return malaysiaManifestTransmitVO;
	}

	public void setMalaysiaManifestTransmitVO(MalaysiaManifestTransmitVO malaysiaManifestTransmitVO) {
		this.malaysiaManifestTransmitVO = malaysiaManifestTransmitVO;
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