/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0310Event.java
*@FileTitle : Indonesian Customs EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.09.29 민동진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0310 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0310HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Min, DongJin
 * @see ESM_BKG_0310HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0310Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private IndonesiaManifestListCondVO indonesiaManifestListCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private IndonesiaManifestListCondVO[] indonesiaManifestListCondVOs = null;

	private ManifestTransmitVO manifestTransmitVO = null;

	private String vvd = null;
	private String polCd = null;
	private String podCd = null;

	public EsmBkg0310Event(){}

    public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

    public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	 public String getPoDCd() {
		return podCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

    public void setIndonesiaManifestListCondVO(IndonesiaManifestListCondVO indonesiaManifestListCondVO){
		this. indonesiaManifestListCondVO = indonesiaManifestListCondVO;
	}

	public void setIndonesiaManifestListCondVOS(IndonesiaManifestListCondVO[] indonesiaManifestListCondVOs) {
		if (indonesiaManifestListCondVOs != null) {
			IndonesiaManifestListCondVO[] tmpVOs = Arrays.copyOf(indonesiaManifestListCondVOs, indonesiaManifestListCondVOs.length);
			this.indonesiaManifestListCondVOs = tmpVOs;
		}
	}

	public IndonesiaManifestListCondVO getIndonesiaManifestListCondVO(){
		return indonesiaManifestListCondVO;
	}

	public IndonesiaManifestListCondVO[] getIndonesiaManifestListCondVOS(){
		IndonesiaManifestListCondVO[] rtnVOs = null;
		if (this.indonesiaManifestListCondVOs != null) {
			rtnVOs = Arrays.copyOf(indonesiaManifestListCondVOs, indonesiaManifestListCondVOs.length);
		}
		return rtnVOs;
	}

	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}

	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}
}