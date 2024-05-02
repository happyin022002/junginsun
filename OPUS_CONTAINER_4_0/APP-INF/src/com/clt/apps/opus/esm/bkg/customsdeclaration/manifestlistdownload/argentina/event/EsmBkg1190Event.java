/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1190Event.java
*@FileTitle : ESM_BKG_1190
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2014.12.29 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.ArgManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.ArgManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.ArgManifestListDetailVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1190 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1190HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  김민정
 * @see ESM_BKG_1190HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1190Event extends EventSupport {
	private static final long serialVersionUID = 1L;


	/** Table Value Object 조회 조건 및 단건 처리 */
	private ArgManifestListCondVO manifestListCondVO = null;
	private ArgManifestListDetailVO[] manifestListDetailVOs = null;
	private ArgManifestTransmitVO[] manifestTransmitVOs = null;

	public EsmBkg1190Event() {}


	/**
	 * @return the manifestListCondVO
	 */
	public ArgManifestListCondVO getArgManifestListCondVO() {
		return manifestListCondVO;
	}

	/**
	 * @param manifestListCondVO the manifestListCondVO to set
	 */
	public void setArgManifestListCondVO(ArgManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO  = manifestListCondVO;
	}

	/**
	 * @return getArgManifestListDetailVOs
	 */
	public ArgManifestListDetailVO[] getArgManifestListDetailVOs() {
		ArgManifestListDetailVO[] rtnVOs = null;
		if (this.manifestListDetailVOs != null) {
			rtnVOs = new ArgManifestListDetailVO[manifestListDetailVOs.length];
			System.arraycopy(manifestListDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param getArgManifestListDetailVOs
	 */
	public void setArgManifestListDetailVOs(ArgManifestListDetailVO[] manifestListDetailVOs) {
		if (manifestListDetailVOs != null) {
			ArgManifestListDetailVO[] tmpVOs = new ArgManifestListDetailVO[manifestListDetailVOs.length];
			System.arraycopy(manifestListDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.manifestListDetailVOs = tmpVOs;
		}
	}

	/**
	 * @return manifestTransmitVOs
	 */
	public ArgManifestTransmitVO[] getArgManifestTransmitVOs() {
		ArgManifestTransmitVO[] rtnVOs = null;
		if (this.manifestTransmitVOs != null) {
			rtnVOs = new ArgManifestTransmitVO[manifestTransmitVOs.length];
			System.arraycopy(manifestTransmitVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manifestTransmitVOs
	 */
	public void setArgManifestTransmitVOs(ArgManifestTransmitVO[] manifestTransmitVOs) {
		if (manifestTransmitVOs != null) {
			ArgManifestTransmitVO[] tmpVOs = new ArgManifestTransmitVO[manifestTransmitVOs.length];
			System.arraycopy(manifestTransmitVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.manifestTransmitVOs = tmpVOs;
		}
	}
}
