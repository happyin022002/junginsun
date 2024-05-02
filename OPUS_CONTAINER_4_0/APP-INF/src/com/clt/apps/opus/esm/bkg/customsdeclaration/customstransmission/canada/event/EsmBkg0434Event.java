/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0434Event.java
 *@FileTitle : CustomsTransmission
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogDtlVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0434 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0434HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0434HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0434Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private CndCstmsRcvLogDtlCondVO cstmsRcvLogDtlCondVO = null;
	/** Receive History Log 결과 */
	private CndCstmsRcvLogDtlVO cstmsRcvLogDtlVO = null;
	/** Receive History Log 결과리스트 */
	private CndCstmsRcvLogDtlVO[] cstmsRcvLogDtlVOs = null;

	public EsmBkg0434Event() {}

	public void setCstmsRcvLogDtlCondVO(CndCstmsRcvLogDtlCondVO cstmsRcvLogDtlCondVO) {
		this.cstmsRcvLogDtlCondVO = cstmsRcvLogDtlCondVO;
	}

	public void setCstmsRcvLogDtlVO(CndCstmsRcvLogDtlVO cstmsRcvLogDtlVO) {
		this.cstmsRcvLogDtlVO = cstmsRcvLogDtlVO;
	}

	public void setCstmsRcvLogDtlVOs(CndCstmsRcvLogDtlVO[] cstmsRcvLogDtlVOs) {
		if (cstmsRcvLogDtlVOs != null)
			this.cstmsRcvLogDtlVOs = Arrays.copyOf(cstmsRcvLogDtlVOs, cstmsRcvLogDtlVOs.length);
	}

	public CndCstmsRcvLogDtlCondVO getCstmsRcvLogDtlCondVO() {
		return cstmsRcvLogDtlCondVO;
	}

	public CndCstmsRcvLogDtlVO getCstmsRcvLogDtlVO() {
		return cstmsRcvLogDtlVO;
	}

	public CndCstmsRcvLogDtlVO[] getCstmsRcvLogDtlVOs() {
		CndCstmsRcvLogDtlVO[] rtnVOs = null;
		if (cstmsRcvLogDtlVOs != null)
			rtnVOs = Arrays.copyOf(cstmsRcvLogDtlVOs, cstmsRcvLogDtlVOs.length);
		return rtnVOs;
	}
}