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

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1178 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1178HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Shin Kyu Jeong
 * @see ESM_BKG_1178HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1178Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO = null;
	private CndCstmsVslCrnNoVO[] cndCstmsVslCrnNoVOs = null;

	/**
	 * @return the cndCstmsVslCrnNoVO
	 */
	public CndCstmsVslCrnNoVO getCndCstmsVslCrnNoVO() {
		return cndCstmsVslCrnNoVO;
	}

	/**
	 * @param cndCstmsVslCrnNoVO
	 *            the cndCstmsVslCrnNoVO to set
	 */
	public void setCndCstmsVslCrnNoVO(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) {
		this.cndCstmsVslCrnNoVO = cndCstmsVslCrnNoVO;
	}

	/**
	 * @return the cndCstmsVslCrnNoVOs
	 */
	public CndCstmsVslCrnNoVO[] getCndCstmsVslCrnNoVOs() {
		CndCstmsVslCrnNoVO[] rtnVOs = null;
		if (cndCstmsVslCrnNoVOs != null)
			rtnVOs = Arrays.copyOf(cndCstmsVslCrnNoVOs, cndCstmsVslCrnNoVOs.length);
		return rtnVOs;
	}

	/**
	 * @param cndCstmsVslCrnNoVOs
	 *            the cndCstmsVslCrnNoVOs to set
	 */
	public void setCndCstmsVslCrnNoVOs(CndCstmsVslCrnNoVO[] cndCstmsVslCrnNoVOs) {
		if (cndCstmsVslCrnNoVOs != null)
			this.cndCstmsVslCrnNoVOs = Arrays.copyOf(cndCstmsVslCrnNoVOs, cndCstmsVslCrnNoVOs.length);
	}

}