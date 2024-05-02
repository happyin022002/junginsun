/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0477Event.java
*@FileTitle : ESM_BKG-0477
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.06.02 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListTransmitHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanTransmitHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitForReVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0477 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0477HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0477HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0477Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanTransmitHistCondVO japanTransmitHistCondVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanManifestTransmitForReVO japanManifestTransmitForReVO = null;
	/** Table Value Object Multi Data 처리 */
	private JapanManifestListTransmitHistDetailVO[] japanManifestListTransmitHistDetailVOs  = null;

	public EsmBkg0477Event() {}

	public void setJapanTransmitHistCondVO(JapanTransmitHistCondVO japanTransmitHistCondVO) {
		this.japanTransmitHistCondVO = japanTransmitHistCondVO;
	}

	public JapanTransmitHistCondVO getJapanTransmitHistCondVO() {
		return japanTransmitHistCondVO;
	}

	public void setJapanManifestTransmitForReVO(JapanManifestTransmitForReVO japanManifestTransmitForReVO) {
		this.japanManifestTransmitForReVO = japanManifestTransmitForReVO;
	}

	public JapanManifestTransmitForReVO getJapanManifestTransmitForReVO() {
		return japanManifestTransmitForReVO;
	}

	public void setJapanManifestListTransmitHistDetailVOs(JapanManifestListTransmitHistDetailVO[] japanManifestListTransmitHistDetailVOs) {
		if (japanManifestListTransmitHistDetailVOs != null) {
			JapanManifestListTransmitHistDetailVO[] tmpVOs = Arrays.copyOf(japanManifestListTransmitHistDetailVOs, japanManifestListTransmitHistDetailVOs.length);
			this.japanManifestListTransmitHistDetailVOs = tmpVOs;
		}
	}

	public JapanManifestListTransmitHistDetailVO[] getJapanManifestListTransmitHistDetailVO() {
		JapanManifestListTransmitHistDetailVO[] rtnVOs = null;
		if (this.japanManifestListTransmitHistDetailVOs != null) {
			rtnVOs = Arrays.copyOf(japanManifestListTransmitHistDetailVOs, japanManifestListTransmitHistDetailVOs.length);
		}
		return rtnVOs;
	}
}
