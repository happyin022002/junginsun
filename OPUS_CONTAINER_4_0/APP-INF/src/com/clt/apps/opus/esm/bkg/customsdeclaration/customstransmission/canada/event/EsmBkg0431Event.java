/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0431Event.java
 *@FileTitle : ManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0431 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0431HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0431HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0431Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private CstmsRcvHisListCondVO cstmsRcvHisListCondVO = null;
	/** Receive History Log 결과 */
	private CstmsRcvHisVO cstmsRcvHisVO = null;
	/** Receive History Log 결과리스트 */
	private CstmsRcvHisVO[] cstmsRcvHisVOs = null;

	public EsmBkg0431Event() {}

	public void setCstmsRcvHisListCondVO(CstmsRcvHisListCondVO cstmsRcvHisListCondVO) {
		this.cstmsRcvHisListCondVO = cstmsRcvHisListCondVO;
	}

	public void setCstmsRcvHisVO(CstmsRcvHisVO cstmsRcvHisVO) {
		this.cstmsRcvHisVO = cstmsRcvHisVO;
	}

	public void setCstmsRcvHisVOs(CstmsRcvHisVO[] cstmsRcvHisVOs) {
		if (cstmsRcvHisVOs != null)
			this.cstmsRcvHisVOs = Arrays.copyOf(cstmsRcvHisVOs, cstmsRcvHisVOs.length);
	}

	public CstmsRcvHisListCondVO getCstmsRcvHisListCondVO() {
		return cstmsRcvHisListCondVO;
	}

	public CstmsRcvHisVO getCstmsRcvHisVO() {
		return cstmsRcvHisVO;
	}

	public CstmsRcvHisVO[] getCstmsRcvHisVOs() {
		CstmsRcvHisVO[] rtnVOs = null;
		if (cstmsRcvHisVOs != null)
			rtnVOs = Arrays.copyOf(cstmsRcvHisVOs, cstmsRcvHisVOs.length);
		return rtnVOs;
	}
}