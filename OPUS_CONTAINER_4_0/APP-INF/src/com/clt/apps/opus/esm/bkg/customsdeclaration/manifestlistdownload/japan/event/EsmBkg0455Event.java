/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0455Event.java
*@FileTitle : ESM_BKG-0455
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.06.02 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrCntrModificationVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0455 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0455HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0455HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0455Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanManifestListMfrCondVO japanManifestListMfrCondVO = null;
	/** Table Value Object Multi Data 처리 */
	private JapanMfrCntrModificationVO[] japanMfrCntrModificationVOs = null;

	public EsmBkg0455Event() {}

	public void setJapanManifestListMfrCondVO(JapanManifestListMfrCondVO japanManifestListMfrCondVO) {
		this. japanManifestListMfrCondVO = japanManifestListMfrCondVO;
	}

	public JapanManifestListMfrCondVO getJapanManifestListMfrCondVO() {
		return japanManifestListMfrCondVO;
	}

	public void setJapanMfrCntrModificationVOs(JapanMfrCntrModificationVO[] japanMfrCntrModificationVOs) {
		if (japanMfrCntrModificationVOs != null) {
			JapanMfrCntrModificationVO[] tmpVOs = Arrays.copyOf(japanMfrCntrModificationVOs, japanMfrCntrModificationVOs.length);
			this.japanMfrCntrModificationVOs = tmpVOs;
		}
	}

	public JapanMfrCntrModificationVO[] getJapanMfrCntrModificationVOs() {
		JapanMfrCntrModificationVO[] rtnVOs = null;
		if (this.japanMfrCntrModificationVOs != null) {
			rtnVOs = Arrays.copyOf(japanMfrCntrModificationVOs, japanMfrCntrModificationVOs.length);
		}
		return rtnVOs;
	}
}
