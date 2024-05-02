/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0127Event.java
 *@FileTitle : ManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.05.18 경종윤
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrCmModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrCnpiNcmByCntrModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrManifestListDetailVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0127 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0127HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0745HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0127Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private BrManifestListCondVO brManifestListCondVO = null;
	private BrManifestListDetailVO brManifestListDetailVO = null;
	private BrCmModiVO[] brCmModiVOs = null;
	private BrCnpiNcmByCntrModiVO[] brCnpiNcmByCntrModiVOs = null;

	private BrManifestTransmitVO brManifestTransmitVO = null;
	private BrManifestTransmitVO[] brManifestTransmitVOs = null;

	private String key = "";

	public EsmBkg0127Event() {
	}

	/**
	 * @return the brManifestListCondVO
	 */
	public BrManifestListCondVO getBrManifestListCondVO() {
		return brManifestListCondVO;
	}

	/**
	 * @param brManifestListCondVO
	 *            the brManifestListCondVO to set
	 */
	public void setBrManifestListCondVO(BrManifestListCondVO brManifestListCondVO) {
		this.brManifestListCondVO = brManifestListCondVO;
	}

	/**
	 * @return the brManifestListDetailVO
	 */
	public BrManifestListDetailVO getBrManifestListDetailVO() {
		return brManifestListDetailVO;
	}

	/**
	 * @param brManifestListDetailVO
	 *            the brManifestListDetailVO to set
	 */
	public void setBrManifestListDetailVO(BrManifestListDetailVO brManifestListDetailVO) {
		this.brManifestListDetailVO = brManifestListDetailVO;
	}

	/**
	 * @return the brCmModiVOs
	 */
	public BrCmModiVO[] getBrCmModiVOs() {
		BrCmModiVO[] rtnVOs = null;
		if (brCmModiVOs != null)
			rtnVOs = Arrays.copyOf(brCmModiVOs, brCmModiVOs.length);
		return rtnVOs;
	}

	/**
	 * @param brCmModiVOs
	 *            the brCmModiVOs to set
	 */
	public void setBrCmModiVOs(BrCmModiVO[] brCmModiVOs) {
		if (brCmModiVOs != null)
			this.brCmModiVOs = Arrays.copyOf(brCmModiVOs, brCmModiVOs.length);
	}

	/**
	 * @return the brCnpiNcmByCntrModiVOs
	 */
	public BrCnpiNcmByCntrModiVO[] getBrCnpiNcmByCntrModiVOs() {
		BrCnpiNcmByCntrModiVO[] rtnVOs = null;
		if (brCnpiNcmByCntrModiVOs != null)
			rtnVOs = Arrays.copyOf(brCnpiNcmByCntrModiVOs, brCnpiNcmByCntrModiVOs.length);
		return rtnVOs;
	}

	/**
	 * @param brCnpiNcmByCntrModiVOs
	 *            the brCnpiNcmByCntrModiVOs to set
	 */
	public void setBrCnpiNcmByCntrModiVOs(BrCnpiNcmByCntrModiVO[] brCnpiNcmByCntrModiVOs) {
		if (brCnpiNcmByCntrModiVOs != null)
			this.brCnpiNcmByCntrModiVOs = Arrays.copyOf(brCnpiNcmByCntrModiVOs, brCnpiNcmByCntrModiVOs.length);
	}

	/**
	 * @return the brManifestTransmitVO
	 */
	public BrManifestTransmitVO getBrManifestTransmitVO() {
		return brManifestTransmitVO;
	}

	/**
	 * @param brManifestTransmitVO
	 *            the brManifestTransmitVO to set
	 */
	public void setBrManifestTransmitVO(BrManifestTransmitVO brManifestTransmitVO) {
		this.brManifestTransmitVO = brManifestTransmitVO;
	}

	/**
	 * @return the brManifestTransmitVOs
	 */
	public BrManifestTransmitVO[] getBrManifestTransmitVOs() {
		BrManifestTransmitVO[] rtnVOs = null;
		if (brManifestTransmitVOs != null)
			rtnVOs = Arrays.copyOf(brManifestTransmitVOs, brManifestTransmitVOs.length);
		return rtnVOs;
	}

	/**
	 * @param brManifestTransmitVOs
	 *            the brManifestTransmitVOs to set
	 */
	public void setBrManifestTransmitVOs(BrManifestTransmitVO[] brManifestTransmitVOs) {
		if (brManifestTransmitVOs != null)
			this.brManifestTransmitVOs = Arrays.copyOf(brManifestTransmitVOs, brManifestTransmitVOs.length);
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
}