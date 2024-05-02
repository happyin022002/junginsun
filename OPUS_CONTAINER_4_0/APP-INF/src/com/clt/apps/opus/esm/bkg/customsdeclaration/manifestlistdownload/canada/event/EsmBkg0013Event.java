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

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdRefNoCondVO;
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

public class EsmBkg0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private CstmsVvdInfoVO cstmsVvdInfoVO = null;
	private CstmsVvdInfoVO[] cstmsVvdInfoVOs = null;
	private CstmsVvdInfoCondVO cstmsVvdInfoCondVO = null;
	private CstmsVvdRefNoCondVO cstmsVvdRefNoCondVO = null;

	public EsmBkg0013Event() {
	}

	public void setCstmsVvdInfoVO(CstmsVvdInfoVO cstmsVvdInfoVO) {
		this.cstmsVvdInfoVO = cstmsVvdInfoVO;
	}

	public void setCstmsVvdInfoVOS(CstmsVvdInfoVO[] cstmsVvdInfoVOs) {
		if (cstmsVvdInfoVOs != null)
			this.cstmsVvdInfoVOs = Arrays.copyOf(cstmsVvdInfoVOs, cstmsVvdInfoVOs.length);
	}

	public void setCstmsVvdInfoCondVO(CstmsVvdInfoCondVO cstmsVvdInfoCondVO) {
		this.cstmsVvdInfoCondVO = cstmsVvdInfoCondVO;
	}

	public void setCstmsVvdRefNoCondVO(CstmsVvdRefNoCondVO cstmsVvdRefNoCondVO) {
		this.cstmsVvdRefNoCondVO = cstmsVvdRefNoCondVO;
	}

	public CstmsVvdInfoVO getCstmsVvdInfoVO() {
		return cstmsVvdInfoVO;
	}

	public CstmsVvdRefNoCondVO getCstmsVvdRefNoCondVO() {
		return cstmsVvdRefNoCondVO;
	}

	public CstmsVvdInfoVO[] getCstmsVvdInfoVOS() {
		CstmsVvdInfoVO[] rtnVOs = null;
		if (cstmsVvdInfoVOs != null)
			rtnVOs = Arrays.copyOf(cstmsVvdInfoVOs, cstmsVvdInfoVOs.length);
		return rtnVOs;
	}

	public CstmsVvdInfoCondVO getCstmsVvdInfoCondVO() {
		return cstmsVvdInfoCondVO;
	}
}