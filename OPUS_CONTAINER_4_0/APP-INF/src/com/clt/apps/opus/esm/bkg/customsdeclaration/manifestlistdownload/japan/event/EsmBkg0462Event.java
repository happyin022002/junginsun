/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0462Event.java
*@FileTitle : ESM_BKG-0462
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.05.18 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestModificationVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0462 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0462HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0462HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0462Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanManifestListCondVO japanManifestListCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private JapanManifestModificationVO[] japanManifestModificationVOs = null;


	public EsmBkg0462Event() {}


	public JapanManifestListCondVO getJapanManifestListCondVO() {
		return japanManifestListCondVO;
	}

	public void setJapanManifestListCondVO(JapanManifestListCondVO japanManifestListCondVO) {
		this. japanManifestListCondVO = japanManifestListCondVO;
	}

	public JapanManifestModificationVO[] getJapanManifestModificationVOs() {
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

}
