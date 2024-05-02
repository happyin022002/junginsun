/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0257Event.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.23
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.07.23 경종윤
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2011.11.21 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0257 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0257HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0257HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0257Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ManifestListCondVO manifestListCondVO = null;
	private ManifestListDetailVO[] eurManifestListVOs = null;
	private EurManifestTransmitVO[] euManifestTransmitVOs = null;

	private String vvdCd = "";
	private String podCd = "";
	private String polCd = "";

	private String key = "";

	public EsmBkg0257Event() {
	}

	/**
	 * @return the vvdCd
	 */
	public String getVvdCd() {
		return vvdCd;
	}

	/**
	 * @param vvdCd
	 *            the vvdCd to set
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param podCd
	 *            the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * @return the polCd
	 */
	public String getPolCd() {
		return polCd;
	}

	/**
	 * @param polCd
	 *            the polCd to set
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the manifestListCondVO
	 */
	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}

	/**
	 * @param manifestListCondVO
	 *            the manifestListCondVO to set
	 */
	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}

	/**
	 * @return eurManifestListVOs
	 */
	public ManifestListDetailVO[] getEurManifestListVOs() {
		ManifestListDetailVO[] rtnVOs = null;
		if (eurManifestListVOs != null)
			rtnVOs = Arrays.copyOf(eurManifestListVOs, eurManifestListVOs.length);
		return rtnVOs;
	}

	/**
	 * @param eurManifestListVOs
	 */
	public void setEu24ManifestListVOs(ManifestListDetailVO[] eurManifestListVOs) {
		if (eurManifestListVOs != null)
			this.eurManifestListVOs = Arrays.copyOf(eurManifestListVOs, eurManifestListVOs.length);
	}

	/**
	 * @return the euManifestTransmitVOs
	 */
	public EurManifestTransmitVO[] getEuManifestTransmitVOs() {
		EurManifestTransmitVO[] rtnVOs = null;
		if (euManifestTransmitVOs != null)
			rtnVOs = Arrays.copyOf(euManifestTransmitVOs, euManifestTransmitVOs.length);
		return rtnVOs;
	}

	/**
	 * @param euManifestTransmitVOs
	 *            the euManifestTransmitVOs to set
	 */
	public void setEuManifestTransmitVOs(EurManifestTransmitVO[] euManifestTransmitVOs) {
		if (euManifestTransmitVOs != null)
			this.euManifestTransmitVOs = Arrays.copyOf(euManifestTransmitVOs, euManifestTransmitVOs.length);
	}
}
