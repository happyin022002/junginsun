/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0551Event.java
 *@FileTitle : AncsManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.20 정재엽
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.BkgCstmsNtfyAddrCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.BkgCstmsNtfyAddrVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0551HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0551HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0728Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private BkgCstmsNtfyAddrCondVO bkgCstmsNtfyAddrCondVO = null;
	/** 조회결과 단건 */
	private BkgCstmsNtfyAddrVO bkgCstmsNtfyAddrVO = null;
	/** 조회결과 복수 */
	private BkgCstmsNtfyAddrVO[] bkgCstmsNtfyAddrVOs = null;

	public BkgCstmsNtfyAddrVO getBkgCstmsNtfyAddrVO() {
		return bkgCstmsNtfyAddrVO;
	}

	public void setBkgCstmsNtfyAddrVO(BkgCstmsNtfyAddrVO bkgCstmsNtfyAddrVO) {
		this.bkgCstmsNtfyAddrVO = bkgCstmsNtfyAddrVO;
	}

	public BkgCstmsNtfyAddrVO[] getBkgCstmsNtfyAddrVOs() {
		BkgCstmsNtfyAddrVO[] rtnVOs = null;
		if (bkgCstmsNtfyAddrVOs != null)
			rtnVOs = Arrays.copyOf(bkgCstmsNtfyAddrVOs, bkgCstmsNtfyAddrVOs.length);
		return rtnVOs;
	}

	public void setBkgCstmsNtfyAddrVOs(BkgCstmsNtfyAddrVO[] bkgCstmsNtfyAddrVOs) {
		if (bkgCstmsNtfyAddrVOs != null)
			this.bkgCstmsNtfyAddrVOs = Arrays.copyOf(bkgCstmsNtfyAddrVOs, bkgCstmsNtfyAddrVOs.length);
	}

	public BkgCstmsNtfyAddrCondVO getBkgCstmsNtfyAddrCondVO() {
		return bkgCstmsNtfyAddrCondVO;
	}

	public void setBkgCstmsNtfyAddrCondVO(BkgCstmsNtfyAddrCondVO bkgCstmsNtfyAddrCondVO) {
		this.bkgCstmsNtfyAddrCondVO = bkgCstmsNtfyAddrCondVO;
	}
}