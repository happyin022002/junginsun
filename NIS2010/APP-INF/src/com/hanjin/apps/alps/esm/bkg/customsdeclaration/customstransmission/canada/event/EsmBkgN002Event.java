/*=========================================================
 *Copyright(c) SMLines. All Rights Reserved.
 *@FileName : EsmBkgN002Event.java
 *@FileTitle : EsmBkgN002Event
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event;

import java.util.Arrays; 

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_N002에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_N002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_N002HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkgN002Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	// 조회조건
	private CstmsManifestCondVO cstmsManifestCondVO = null;
	// 삭제시 VO 세팅
	private CstmsBlVO[] cstmsBlVOs = null;
	// 전송시 VO 세팅
	private ManifestTransmitVO manifestTransmitVO = null;

	public EsmBkgN002Event() {}

	/** Set Method */
	public void setCstmsManifestCondVO(CstmsManifestCondVO cstmsManifestCondVO) {
		this.cstmsManifestCondVO = cstmsManifestCondVO;
	}
	public void setCstmsBlVOs(CstmsBlVO[] cstmsBlVOs) {
		if (cstmsBlVOs != null)
			this.cstmsBlVOs = Arrays.copyOf(cstmsBlVOs, cstmsBlVOs.length);
	}
	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}

	/** Get Method */
	public CstmsManifestCondVO getCstmsManifestCondVO() {
		return cstmsManifestCondVO;
	}
	public CstmsBlVO[] getCstmsBlVOs() {
		CstmsBlVO[] rtnVOs = null;
		if (cstmsBlVOs != null)
			rtnVOs = Arrays.copyOf(cstmsBlVOs, cstmsBlVOs.length);
		return rtnVOs;
	}
	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}

	private String key = "";
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}