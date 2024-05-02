/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0730Event.java
*@FileTitle : ESM_BKG-0730
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.05.26 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestModificationVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0730 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0730HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0730HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0730Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanManifestListCondVO japanManifestListCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private JapanManifestModificationVO[] japanManifestModificationVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanManifestTransmitContainerVO japanManifestTransmitContainerVO = null;

	private String key = "";


	public EsmBkg0730Event(){}


	public JapanManifestListCondVO getJapanManifestListCondVO() {
		return japanManifestListCondVO;
	}

	public void setJapanManifestListCondVO(JapanManifestListCondVO japanManifestListCondVO) {
		this. japanManifestListCondVO = japanManifestListCondVO;
	}

	public JapanManifestModificationVO[] getJapanManifestModificationVOs(){
		JapanManifestModificationVO[] rtnVOs = null;
		if (this.japanManifestModificationVOs != null) {
			rtnVOs = Arrays.copyOf(japanManifestModificationVOs, japanManifestModificationVOs.length);
		}
		return rtnVOs;
	}

	public void setJapanManifestModificationVOs(JapanManifestModificationVO[] japanManifestModificationVOs) {
		if (japanManifestModificationVOs != null) {
			JapanManifestModificationVO[] tmpVOs = Arrays.copyOf(japanManifestModificationVOs, japanManifestModificationVOs.length);
			this.japanManifestModificationVOs = tmpVOs;
		}
	}

	public JapanManifestTransmitContainerVO getJapanManifestTransmitContainerVO() {
		return japanManifestTransmitContainerVO;
	}

	public void setJapanManifestTransmitContainerVO(JapanManifestTransmitContainerVO japanManifestTransmitContainerVO) {
		this. japanManifestTransmitContainerVO = japanManifestTransmitContainerVO;
	}

	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}
}
