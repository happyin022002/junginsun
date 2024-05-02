/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0471Event.java
*@FileTitle : ESM_BKG-0471
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListReceiveHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanRcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanReceiveLogVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0471 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0471HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0471HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0471Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanRcvHistCondVO japanRcvHistCondVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanReceiveLogVO japanReceiveLogVO = null;
	/** Table Value Object Multi Data 처리 */
	private JapanManifestListReceiveHistDetailVO[] japanManifestListReceiveHistDetailVOs  = null;

	public EsmBkg0471Event() {}

	public void setJapanRcvHistCondVO(JapanRcvHistCondVO japanRcvHistCondVO) {
		this.japanRcvHistCondVO = japanRcvHistCondVO;
	}

	public JapanRcvHistCondVO getJapanRcvHistCondVO() {
		return japanRcvHistCondVO;
	}

	public void setJapanReceiveLogVO(JapanReceiveLogVO japanReceiveLogVO) {
		this.japanReceiveLogVO = japanReceiveLogVO;
	}

	public JapanReceiveLogVO getJapanReceiveLogVO() {
		return japanReceiveLogVO;
	}

	public void setJapanManifestListReceiveHistDetailVOs(JapanManifestListReceiveHistDetailVO[] japanManifestListReceiveHistDetailVOs) {
		if (japanManifestListReceiveHistDetailVOs != null) {
			JapanManifestListReceiveHistDetailVO[] tmpVOs = Arrays.copyOf(japanManifestListReceiveHistDetailVOs, japanManifestListReceiveHistDetailVOs.length);
			this.japanManifestListReceiveHistDetailVOs = tmpVOs;
		}
	}

	public JapanManifestListReceiveHistDetailVO[] getJapanManifestListReceiveHistDetailVOs() {
		JapanManifestListReceiveHistDetailVO[] rtnVOs = null;
		if (this.japanManifestListReceiveHistDetailVOs != null) {
			rtnVOs = Arrays.copyOf(japanManifestListReceiveHistDetailVOs, japanManifestListReceiveHistDetailVOs.length);
		}
		return rtnVOs;
	}
}
