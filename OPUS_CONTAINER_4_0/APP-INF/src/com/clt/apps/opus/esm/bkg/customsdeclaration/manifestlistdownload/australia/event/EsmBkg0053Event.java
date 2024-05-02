/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0053Event.java
*@FileTitle : ESM_BKG-0053
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AustraliaManifestTransmitVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  LIM JAE TAEK
 * @see ESM_BKG-0053HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0053Event extends EventSupport {
	private static final long serialVersionUID = 1L;


	private AustraliaManifestTransmitVO[] australiaManifestTransmitVO = null;
	private String key = "";

	public EsmBkg0053Event() {}

	public void setAustraliaManifestTransmitVO(AustraliaManifestTransmitVO[] australiaManifestTransmitVO) {
		if (australiaManifestTransmitVO != null) {
			AustraliaManifestTransmitVO[] tmpVOs = Arrays.copyOf(australiaManifestTransmitVO, australiaManifestTransmitVO.length);
			this.australiaManifestTransmitVO = tmpVOs;
		}
	}

	public AustraliaManifestTransmitVO[] getAustraliaManifestTransmitVO() {
		AustraliaManifestTransmitVO[] rtnVOs = null;
		if (this.australiaManifestTransmitVO != null) {
			rtnVOs = Arrays.copyOf(australiaManifestTransmitVO, australiaManifestTransmitVO.length);
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
