/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0500Event.java
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0500 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0500HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0500HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0500Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private CstmsSndHisListCondVO cstmsSndHisListCondVO = null;
	/** Receive History Log 결과 */
	private CstmsSndHisVO cstmsSndHisVO = null;
	/** Receive History Log 결과리스트 */
	private CstmsSndHisVO[] cstmsSndHisVOs = null;

	public EsmBkg0500Event() {}

	public void setCstmsSndHisListCondVO(CstmsSndHisListCondVO cstmsSndHisListCondVO) {
		this.cstmsSndHisListCondVO = cstmsSndHisListCondVO;
	}

	public void setCstmsSndHisVO(CstmsSndHisVO cstmsSndHisVO) {
		this.cstmsSndHisVO = cstmsSndHisVO;
	}

	public void setCstmsSndHisVOs(CstmsSndHisVO[] cstmsSndHisVOs) {
		if (cstmsSndHisVOs != null)
			this.cstmsSndHisVOs = Arrays.copyOf(cstmsSndHisVOs, cstmsSndHisVOs.length);;
	}

	public CstmsSndHisListCondVO getCstmsSndHisListCondVO() {
		return cstmsSndHisListCondVO;
	}

	public CstmsSndHisVO getCstmsSndHisVO() {
		return cstmsSndHisVO;
	}

	public CstmsSndHisVO[] getCstmsSndHisVOs() {
		CstmsSndHisVO[] rtnVOs = null;
		if (cstmsSndHisVOs != null)
			rtnVOs = Arrays.copyOf(cstmsSndHisVOs, cstmsSndHisVOs.length);
		return rtnVOs;
	}
}