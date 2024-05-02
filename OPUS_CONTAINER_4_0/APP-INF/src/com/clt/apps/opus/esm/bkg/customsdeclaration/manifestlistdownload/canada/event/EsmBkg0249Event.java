/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0013Event.java
 *@FileTitle : CndManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0013HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0249Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private CstmsVvdVO oneVO = null;

	/** Table Value Object Multi Data 처리 */
	private CstmsVvdVO[] multiVO = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private CstmsVvdListCondVO condVO = null;

	public EsmBkg0249Event() {
	}

	public void setCstmsVvdVO(CstmsVvdVO oneVO) {
		this.oneVO = oneVO;
	}

	public void setCstmsVvdVOS(CstmsVvdVO[] multiVO) {
		if (multiVO != null)
			this.multiVO = Arrays.copyOf(multiVO, multiVO.length);
	}

	public void setCstmsVvdListCondVO(CstmsVvdListCondVO condVO) {
		this.condVO = condVO;
	}

	public CstmsVvdVO getCstmsVvdVO() {
		return oneVO;
	}

	public CstmsVvdVO[] getCstmsVvdVOS() {
		CstmsVvdVO[] rtnVOs = null;
		if (multiVO != null)
			rtnVOs = Arrays.copyOf(multiVO, multiVO.length);
		return rtnVOs;
	}

	public CstmsVvdListCondVO getCstmsVvdListCondVO() {
		return condVO;
	}
}