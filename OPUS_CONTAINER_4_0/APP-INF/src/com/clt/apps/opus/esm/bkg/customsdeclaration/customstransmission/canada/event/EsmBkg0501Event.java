/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0501Event.java
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndLogDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndLogDtlVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0501 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0501HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0501HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0501Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private CstmsSndLogDtlCondVO cstmsSndLogDtlCondVO = null;
	/** Receive History Log 결과 */
	private CstmsSndLogDtlVO cstmsSndLogDtlVO = null;
	/** Receive History Log 결과리스트 */
	private CstmsSndLogDtlVO[] cstmsSndLogDtlVOs = null;

	public EsmBkg0501Event() {}

	public void setCstmsSndLogDtlCondVO(CstmsSndLogDtlCondVO cstmsSndLogDtlCondVO) {
		this.cstmsSndLogDtlCondVO = cstmsSndLogDtlCondVO;
	}

	public void setCstmsSndLogDtlVO(CstmsSndLogDtlVO cstmsSndLogDtlVO) {
		this.cstmsSndLogDtlVO = cstmsSndLogDtlVO;
	}

	public void setCstmsSndLogDtlVOs(CstmsSndLogDtlVO[] cstmsSndLogDtlVOs) {
		if (cstmsSndLogDtlVOs != null)
			this.cstmsSndLogDtlVOs = Arrays.copyOf(cstmsSndLogDtlVOs, cstmsSndLogDtlVOs.length);
	}

	public CstmsSndLogDtlCondVO getCstmsSndLogDtlCondVO() {
		return cstmsSndLogDtlCondVO;
	}

	public CstmsSndLogDtlVO getCstmsSndLogDtlVO() {
		return cstmsSndLogDtlVO;
	}

	public CstmsSndLogDtlVO[] getCstmsSndLogDtlVOs() {
		CstmsSndLogDtlVO[] rtnVOs = null;
		if (cstmsSndLogDtlVOs != null)
			rtnVOs = Arrays.copyOf(cstmsSndLogDtlVOs, cstmsSndLogDtlVOs.length);
		return rtnVOs;
	}
}