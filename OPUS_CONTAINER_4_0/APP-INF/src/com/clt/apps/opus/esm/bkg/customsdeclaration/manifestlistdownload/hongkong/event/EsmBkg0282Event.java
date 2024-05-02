/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0282Event.java
*@FileTitle : ESM_BKG-0082
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongManifestListCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0282 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0282HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  LIM JAE TAEK
 * @see ESM_BKG-0282HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0282Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private HongKongManifestListCondVO hongKongManifestListCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private HongKongManifestListCondVO[] hongKongManifestListCondVOs = null;

	private HongKongManifestTransmitVO[] hongKongManifestTransmitVOs = null;
	private ManifestTransmitVO[] manifestTransmitVOs = null;

	private String polCd = null;
	private String podCd = null;
	private String key = "";

    public EsmBkg0282Event(){}

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

    public void setHongKongManifestListCondVO(HongKongManifestListCondVO hongKongManifestListCondVO){
		this. hongKongManifestListCondVO = hongKongManifestListCondVO;
	}

	public void setHongKongManifestListCondVOS(HongKongManifestListCondVO[] hongKongManifestListCondVOs) {
		if (hongKongManifestListCondVOs != null) {
			HongKongManifestListCondVO[] tmpVOs = Arrays.copyOf(hongKongManifestListCondVOs, hongKongManifestListCondVOs.length);
			this.hongKongManifestListCondVOs = tmpVOs;
		}
	}
	public void setHongKongManifestTransmitVOS(HongKongManifestTransmitVO[] hongKongManifestTransmitVOs) {
		if (hongKongManifestTransmitVOs != null) {
			HongKongManifestTransmitVO[] tmpVOs = Arrays.copyOf(hongKongManifestTransmitVOs, hongKongManifestTransmitVOs.length);
			this.hongKongManifestTransmitVOs = tmpVOs;
		}
	}
	public void setManifestTransmitVOS(ManifestTransmitVO[] manifestTransmitVOs) {
		if (manifestTransmitVOs != null) {
			ManifestTransmitVO[] tmpVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
			this.manifestTransmitVOs = tmpVOs;
		}
	}

	public HongKongManifestListCondVO getHongKongManifestListCondVO(){
		return hongKongManifestListCondVO;
	}

	public HongKongManifestListCondVO[] getHongKongManifestListCondVOS(){
		HongKongManifestListCondVO[] rtnVOs = null;
		if (this.hongKongManifestListCondVOs != null) {
			rtnVOs = Arrays.copyOf(hongKongManifestListCondVOs, hongKongManifestListCondVOs.length);
		}
		return rtnVOs;
	}
	public HongKongManifestTransmitVO[] getHongKongManifestTransmitVOs(){
		HongKongManifestTransmitVO[] rtnVOs = null;
		if (this.hongKongManifestTransmitVOs != null) {
			rtnVOs = Arrays.copyOf(hongKongManifestTransmitVOs, hongKongManifestTransmitVOs.length);
		}
		return rtnVOs;
	}
	public ManifestTransmitVO[] getManifestTransmitVOS(){
		ManifestTransmitVO[] rtnVOs = null;
		if (this.manifestTransmitVOs != null) {
			rtnVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
		}
		return rtnVOs;
	}

	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}
}
