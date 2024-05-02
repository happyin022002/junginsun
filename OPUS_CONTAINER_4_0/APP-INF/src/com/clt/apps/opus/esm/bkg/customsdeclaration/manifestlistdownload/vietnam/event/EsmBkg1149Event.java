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
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListCondVO;
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
public class EsmBkg1149Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private VietnamManifestListCondVO vietnamManifestListCondVO = null;
	private VietnamManifestTransmitVO vietnamManifestTransmitVO = null;


	private String polCd = null;
	private String podCd = null;
	private String key = "";
	private String polGubun = null;


	public EsmBkg1149Event() {}


	public VietnamManifestListCondVO getVietnamManifestListCondVO() {
		return vietnamManifestListCondVO;
	}

	public void setVietnamManifestListCondVO(VietnamManifestListCondVO vietnamManifestListCondVO) {
		this.vietnamManifestListCondVO = vietnamManifestListCondVO;
	}

	public VietnamManifestTransmitVO getVietnamManifestTransmitVO() {
		return vietnamManifestTransmitVO;
	}

	public void setVietnamManifestTransmitVO(VietnamManifestTransmitVO vietnamManifestTransmitVO) {
		this.vietnamManifestTransmitVO = vietnamManifestTransmitVO;
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