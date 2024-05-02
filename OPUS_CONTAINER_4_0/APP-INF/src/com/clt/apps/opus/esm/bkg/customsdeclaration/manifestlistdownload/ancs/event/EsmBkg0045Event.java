/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0045Event.java
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

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlNtfyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsCmdtVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestTransmitVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgCstmsAnrCmdtVO;

/**
 * ESM_BKG_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0045HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0045Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private AncsCstmsBlCondVO ancsCstmsBlCondVO = null;
	/** 조회결과 단건 */
	private AncsCstmsBlVO ancsCstmsBlVO = null;
	/** 조회결과 복수 */
	private AncsCstmsBlVO[] ancsCstmsBlVOs = null;

	private AncsCstmsBlContainerVO ancsCstmsBlContainerVO = null;
	private AncsCstmsBlContainerVO[] ancsCstmsBlContainerVOs = null;

	private AncsCstmsBlNtfyVO ancsCstmsBlNtfyVO = null;
	private AncsCstmsBlNtfyVO[] ancsCstmsBlNtfyVOs = null;

	private AncsCstmsCntrVO ancsCstmsCntrVO = null;
	private AncsCstmsCntrVO[] ancsCstmsCntrVOs = null;

	private AncsCstmsCmdtVO[] ancsCstmsCmdtVOs = null;

	private BkgCstmsAnrCmdtVO[] bkgCstmsAnrCmdtVOs = null;

	/** 다운로드 단건 */
	private AncsManifestModificationVO ancsManifestModificationVO = null;

	/** 다운로드 복수 */
	private AncsManifestModificationVO[] ancsManifestModificationVOs = null;

	/** EDI 연동 **/
	private AncsManifestTransmitVO[] ancsManifestTransmitVOs = null;

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

	public AncsManifestModificationVO getAncsManifestModificationVO() {
		return ancsManifestModificationVO;
	}

	public void setAncsManifestModificationVO(AncsManifestModificationVO ancsManifestModificationVO) {
		this.ancsManifestModificationVO = ancsManifestModificationVO;
	}

	public AncsManifestModificationVO[] getAncsManifestModificationVOs() {
		AncsManifestModificationVO[] rtnVOs = null;
		if (ancsManifestModificationVOs != null)
			rtnVOs = Arrays.copyOf(ancsManifestModificationVOs, ancsManifestModificationVOs.length);
		return rtnVOs;
	}

	public void setAncsManifestModificationVOs(AncsManifestModificationVO[] ancsManifestModificationVOs) {
		if (ancsManifestModificationVOs != null)
			this.ancsManifestModificationVOs = Arrays.copyOf(ancsManifestModificationVOs, ancsManifestModificationVOs.length);
	}

	public BkgCstmsAnrCmdtVO[] getBkgCstmsAnrCmdtVOs() {
		BkgCstmsAnrCmdtVO[] rtnVOs = null;
		if (bkgCstmsAnrCmdtVOs != null)
			rtnVOs = Arrays.copyOf(bkgCstmsAnrCmdtVOs, bkgCstmsAnrCmdtVOs.length);
		return rtnVOs;
	}

	public void setBkgCstmsAnrCmdtVOs(BkgCstmsAnrCmdtVO[] bkgCstmsAnrCmdtVOs) {
		if (bkgCstmsAnrCmdtVOs != null)
			this.bkgCstmsAnrCmdtVOs = Arrays.copyOf(bkgCstmsAnrCmdtVOs, bkgCstmsAnrCmdtVOs.length);
	}

	public AncsCstmsBlCondVO getAncsCstmsBlCondVO() {
		return ancsCstmsBlCondVO;
	}

	public void setAncsCstmsBlCondVO(AncsCstmsBlCondVO ancsCstmsBlCondVO) {
		this.ancsCstmsBlCondVO = ancsCstmsBlCondVO;
	}

	public AncsCstmsBlVO getAncsCstmsBlVO() {
		return ancsCstmsBlVO;
	}

	public void setAncsCstmsBlVO(AncsCstmsBlVO ancsCstmsBlVO) {
		this.ancsCstmsBlVO = ancsCstmsBlVO;
	}

	public AncsCstmsBlVO[] getAncsCstmsBlVOs() {
		AncsCstmsBlVO[] rtnVOs = null;
		if (ancsCstmsBlVOs != null)
			rtnVOs = Arrays.copyOf(ancsCstmsBlVOs, ancsCstmsBlVOs.length);
		return rtnVOs;
	}

	public void setAncsCstmsBlVOs(AncsCstmsBlVO[] ancsCstmsBlVOs) {
		if (ancsCstmsBlVOs != null)
			this.ancsCstmsBlVOs = Arrays.copyOf(ancsCstmsBlVOs, ancsCstmsBlVOs.length);
	}

	public AncsCstmsBlContainerVO getAncsCstmsBlContainerVO() {
		return ancsCstmsBlContainerVO;
	}

	public void setAncsCstmsBlContainerVO(AncsCstmsBlContainerVO ancsCstmsBlContainerVO) {
		this.ancsCstmsBlContainerVO = ancsCstmsBlContainerVO;
	}

	public AncsCstmsBlContainerVO[] getAncsCstmsBlContainerVOs() {
		AncsCstmsBlContainerVO[] rtnVOs = null;
		if (ancsCstmsBlContainerVOs != null)
			rtnVOs = Arrays.copyOf(ancsCstmsBlContainerVOs, ancsCstmsBlContainerVOs.length);
		return rtnVOs;
	}

	public void setAncsCstmsBlContainerVOs(AncsCstmsBlContainerVO[] ancsCstmsBlContainerVOs) {
		if (ancsCstmsBlContainerVOs != null)
			this.ancsCstmsBlContainerVOs = Arrays.copyOf(ancsCstmsBlContainerVOs, ancsCstmsBlContainerVOs.length);
	}

	public AncsCstmsBlNtfyVO getAncsCstmsBlNtfyVO() {
		return ancsCstmsBlNtfyVO;
	}

	public void setAncsCstmsBlNtfyVO(AncsCstmsBlNtfyVO ancsCstmsBlNtfyVO) {
		this.ancsCstmsBlNtfyVO = ancsCstmsBlNtfyVO;
	}

	public AncsCstmsBlNtfyVO[] getAncsCstmsBlNtfyVOs() {
		AncsCstmsBlNtfyVO[] rtnVOs = null;
		if (ancsCstmsBlNtfyVOs != null)
			rtnVOs = Arrays.copyOf(ancsCstmsBlNtfyVOs, ancsCstmsBlNtfyVOs.length);
		return rtnVOs;
	}

	public void setAncsCstmsBlNtfyVOs(AncsCstmsBlNtfyVO[] ancsCstmsBlNtfyVOs) {
		if (ancsCstmsBlNtfyVOs != null)
			this.ancsCstmsBlNtfyVOs = Arrays.copyOf(ancsCstmsBlNtfyVOs, ancsCstmsBlNtfyVOs.length);
	}

	public AncsCstmsCntrVO getAncsCstmsCntrVO() {
		return ancsCstmsCntrVO;
	}

	public void setAncsCstmsCntrVO(AncsCstmsCntrVO ancsCstmsCntrVO) {
		this.ancsCstmsCntrVO = ancsCstmsCntrVO;
	}

	public AncsCstmsCntrVO[] getAncsCstmsCntrVOs() {
		AncsCstmsCntrVO[] rtnVOs = null;
		if (ancsCstmsCntrVOs != null)
			rtnVOs = Arrays.copyOf(ancsCstmsCntrVOs, ancsCstmsCntrVOs.length);
		return rtnVOs;
	}

	public void setAncsCstmsCntrVOs(AncsCstmsCntrVO[] ancsCstmsCntrVOs) {
		if (ancsCstmsCntrVOs != null)
			this.ancsCstmsCntrVOs = Arrays.copyOf(ancsCstmsCntrVOs, ancsCstmsCntrVOs.length);
	}

	public AncsCstmsCmdtVO[] getAncsCstmsCmdtVOs() {
		AncsCstmsCmdtVO[] rtnVOs = null;
		if (ancsCstmsCmdtVOs != null)
			rtnVOs = Arrays.copyOf(ancsCstmsCmdtVOs, ancsCstmsCmdtVOs.length);
		return rtnVOs;
	}

	public void setAncsCstmsCmdtVOs(AncsCstmsCmdtVO[] ancsCstmsCmdtVOs) {
		if (ancsCstmsCmdtVOs != null)
			this.ancsCstmsCmdtVOs = Arrays.copyOf(ancsCstmsCmdtVOs, ancsCstmsCmdtVOs.length);
	}
}