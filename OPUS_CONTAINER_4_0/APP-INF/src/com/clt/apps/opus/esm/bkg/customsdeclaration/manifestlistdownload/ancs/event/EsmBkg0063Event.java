/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0551Event.java
 *@FileTitle : CndManifestListDownload
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestTransmitVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0551 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0551HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0551HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0063Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private AncsCstmsVvdInfoCondVO ancsCstmsVvdInfoCondVO = null;
	/** 조회결과 단건 */
	private AncsCstmsVvdInfoVO ancsCstmsVvdInfoVO = null;
	/** 조회결과 복수 */
	private AncsCstmsVvdInfoVO[] ancsCstmsVvdInfoVOs = null;

	/** 조회조건 */
	private AncsCstmsMfListCondVO ancsCstmsMfListCondVO = null;
	/** 조회결과 단건 */
	private AncsCstmsMfVO ancsCstmsMfVO = null;
	/** 조회결과 복수 */
	private AncsCstmsMfVO[] ancsCstmsMfVOs = null;

	/** 조회조건 */
	private AncsCstmsMfDtlCondVO ancsCstmsMfDtlCondVO = null;
	/** 조회결과 단건 */
	private AncsCstmsMfDtlVO ancsCstmsMfDtlVO = null;
	/** 조회결과 복수 */
	private AncsCstmsMfDtlVO[] ancsCstmsMfDtlVOs = null;

	private AncsManifestTransmitVO[] ancsManifestTransmitVOs = null;

	private AncsCstmsManifestVO[] ancsCstmsManifestVOs = null;

	public AncsCstmsManifestVO[] getAncsCstmsManifestVOs() {
		AncsCstmsManifestVO[] rtnVOs = null;
		if (ancsCstmsManifestVOs != null)
			rtnVOs = Arrays.copyOf(ancsCstmsManifestVOs, ancsCstmsManifestVOs.length);
		return rtnVOs;
	}

	public void setAncsCstmsManifestVOs(AncsCstmsManifestVO[] ancsCstmsManifestVOs) {
		if (ancsCstmsManifestVOs != null)
			this.ancsCstmsManifestVOs = Arrays.copyOf(ancsCstmsManifestVOs, ancsCstmsManifestVOs.length);
	}

	public AncsManifestTransmitVO[] getAncsManifestTransmitVOs() {
		AncsManifestTransmitVO[] rtnVOs = null;
		if (ancsManifestTransmitVOs != null)
			rtnVOs = Arrays.copyOf(ancsManifestTransmitVOs, ancsManifestTransmitVOs.length);
		return rtnVOs;
	}

	public void setAncsManifestTransmitVOs(AncsManifestTransmitVO[] ancsManifestTransmitVOs) {
		if (ancsManifestTransmitVOs != null)
			this.ancsManifestTransmitVOs = Arrays.copyOf(ancsManifestTransmitVOs, ancsManifestTransmitVOs.length);
	}

	public AncsCstmsMfDtlCondVO getAncsCstmsMfDtlCondVO() {
		return ancsCstmsMfDtlCondVO;
	}

	public void setAncsCstmsMfDtlCondVO(AncsCstmsMfDtlCondVO ancsCstmsMfDtlCondVO) {
		this.ancsCstmsMfDtlCondVO = ancsCstmsMfDtlCondVO;
	}

	public AncsCstmsMfDtlVO getAncsCstmsMfDtlVO() {
		return ancsCstmsMfDtlVO;
	}

	public void setAncsCstmsMfDtlVO(AncsCstmsMfDtlVO ancsCstmsMfDtlVO) {
		this.ancsCstmsMfDtlVO = ancsCstmsMfDtlVO;
	}

	public AncsCstmsMfDtlVO[] getAncsCstmsMfDtlVOs() {
		AncsCstmsMfDtlVO[] rtnVOs = null;
		if (ancsCstmsMfDtlVOs != null)
			rtnVOs = Arrays.copyOf(ancsCstmsMfDtlVOs, ancsCstmsMfDtlVOs.length);
		return rtnVOs;
	}

	public void setAncsCstmsMfDtlVOs(AncsCstmsMfDtlVO[] ancsCstmsMfDtlVOs) {
		if (ancsCstmsMfDtlVOs != null)
			this.ancsCstmsMfDtlVOs = Arrays.copyOf(ancsCstmsMfDtlVOs, ancsCstmsMfDtlVOs.length);
	}

	public AncsCstmsMfListCondVO getAncsCstmsMfListCondVO() {
		return ancsCstmsMfListCondVO;
	}

	public void setAncsCstmsMfListCondVO(AncsCstmsMfListCondVO ancsCstmsMfListCondVO) {
		this.ancsCstmsMfListCondVO = ancsCstmsMfListCondVO;
	}

	public AncsCstmsMfVO getAncsCstmsMfVO() {
		return ancsCstmsMfVO;
	}

	public void setAncsCstmsMfVO(AncsCstmsMfVO ancsCstmsMfVO) {
		this.ancsCstmsMfVO = ancsCstmsMfVO;
	}

	public AncsCstmsMfVO[] getAncsCstmsMfVOs() {
		AncsCstmsMfVO[] rtnVOs = null;
		if (ancsCstmsMfVOs != null)
			rtnVOs = Arrays.copyOf(ancsCstmsMfVOs, ancsCstmsMfVOs.length);
		return rtnVOs;
	}

	public void setAncsCstmsMfVOs(AncsCstmsMfVO[] ancsCstmsMfVOs) {
		if (ancsCstmsMfVOs != null)
			this.ancsCstmsMfVOs = Arrays.copyOf(ancsCstmsMfVOs, ancsCstmsMfVOs.length);
	}

	public AncsCstmsVvdInfoCondVO getAncsCstmsVvdInfoCondVO() {
		return ancsCstmsVvdInfoCondVO;
	}

	public void setAncsCstmsVvdInfoCondVO(AncsCstmsVvdInfoCondVO ancsCstmsVvdInfoCondVO) {
		this.ancsCstmsVvdInfoCondVO = ancsCstmsVvdInfoCondVO;
	}

	public AncsCstmsVvdInfoVO getAncsCstmsVvdInfoVO() {
		return ancsCstmsVvdInfoVO;
	}

	public void setAncsCstmsVvdInfoVO(AncsCstmsVvdInfoVO ancsCstmsVvdInfoVO) {
		this.ancsCstmsVvdInfoVO = ancsCstmsVvdInfoVO;
	}

	public AncsCstmsVvdInfoVO[] getAncsCstmsVvdInfoVOs() {
		AncsCstmsVvdInfoVO[] rtnVOs = null;
		if (ancsCstmsVvdInfoVOs != null)
			rtnVOs = Arrays.copyOf(ancsCstmsVvdInfoVOs, ancsCstmsVvdInfoVOs.length);
		return rtnVOs;
	}

	public void setAncsCstmsVvdInfoVOs(AncsCstmsVvdInfoVO[] ancsCstmsVvdInfoVOs) {
		if (ancsCstmsVvdInfoVOs != null)
			this.ancsCstmsVvdInfoVOs = Arrays.copyOf(ancsCstmsVvdInfoVOs, ancsCstmsVvdInfoVOs.length);
	}
}