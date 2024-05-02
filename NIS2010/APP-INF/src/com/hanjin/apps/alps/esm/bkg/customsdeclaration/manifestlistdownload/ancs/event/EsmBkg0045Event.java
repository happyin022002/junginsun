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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlNtfyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsCmdtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestTransmitVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCstmsAnrCmdtVO;

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
		return ancsManifestTransmitVOs;
	}

	public void setAncsManifestTransmitVOs(AncsManifestTransmitVO[] ancsManifestTransmitVOs) {
		this.ancsManifestTransmitVOs = ancsManifestTransmitVOs;
	}

	public AncsManifestModificationVO getAncsManifestModificationVO() {
		return ancsManifestModificationVO;
	}

	public void setAncsManifestModificationVO(AncsManifestModificationVO ancsManifestModificationVO) {
		this.ancsManifestModificationVO = ancsManifestModificationVO;
	}

	public AncsManifestModificationVO[] getAncsManifestModificationVOs() {
		return ancsManifestModificationVOs;
	}

	public void setAncsManifestModificationVOs(AncsManifestModificationVO[] ancsManifestModificationVOs) {
		this.ancsManifestModificationVOs = ancsManifestModificationVOs;
	}


	public BkgCstmsAnrCmdtVO[] getBkgCstmsAnrCmdtVOs() {
		return bkgCstmsAnrCmdtVOs;
	}

	public void setBkgCstmsAnrCmdtVOs(BkgCstmsAnrCmdtVO[] bkgCstmsAnrCmdtVOs) {
		this.bkgCstmsAnrCmdtVOs = bkgCstmsAnrCmdtVOs;
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
		return ancsCstmsBlVOs;
	}

	public void setAncsCstmsBlVOs(AncsCstmsBlVO[] ancsCstmsBlVOs) {
		this.ancsCstmsBlVOs = ancsCstmsBlVOs;
	}

	public AncsCstmsBlContainerVO getAncsCstmsBlContainerVO() {
		return ancsCstmsBlContainerVO;
	}

	public void setAncsCstmsBlContainerVO(AncsCstmsBlContainerVO ancsCstmsBlContainerVO) {
		this.ancsCstmsBlContainerVO = ancsCstmsBlContainerVO;
	}

	public AncsCstmsBlContainerVO[] getAncsCstmsBlContainerVOs() {
		return ancsCstmsBlContainerVOs;
	}

	public void setAncsCstmsBlContainerVOs(AncsCstmsBlContainerVO[] ancsCstmsBlContainerVOs) {
		this.ancsCstmsBlContainerVOs = ancsCstmsBlContainerVOs;
	}

	public AncsCstmsBlNtfyVO getAncsCstmsBlNtfyVO() {
		return ancsCstmsBlNtfyVO;
	}

	public void setAncsCstmsBlNtfyVO(AncsCstmsBlNtfyVO ancsCstmsBlNtfyVO) {
		this.ancsCstmsBlNtfyVO = ancsCstmsBlNtfyVO;
	}

	public AncsCstmsBlNtfyVO[] getAncsCstmsBlNtfyVOs() {
		return ancsCstmsBlNtfyVOs;
	}

	public void setAncsCstmsBlNtfyVOs(AncsCstmsBlNtfyVO[] ancsCstmsBlNtfyVOs) {
		this.ancsCstmsBlNtfyVOs = ancsCstmsBlNtfyVOs;
	}

	public AncsCstmsCntrVO getAncsCstmsCntrVO() {
		return ancsCstmsCntrVO;
	}

	public void setAncsCstmsCntrVO(AncsCstmsCntrVO ancsCstmsCntrVO) {
		this.ancsCstmsCntrVO = ancsCstmsCntrVO;
	}

	public AncsCstmsCntrVO[] getAncsCstmsCntrVOs() {
		return ancsCstmsCntrVOs;
	}

	public void setAncsCstmsCntrVOs(AncsCstmsCntrVO[] ancsCstmsCntrVOs) {
		this.ancsCstmsCntrVOs = ancsCstmsCntrVOs;
	}

	public AncsCstmsCmdtVO[] getAncsCstmsCmdtVOs() {
		return ancsCstmsCmdtVOs;
	}

	public void setAncsCstmsCmdtVOs(AncsCstmsCmdtVO[] ancsCstmsCmdtVOs) {
		this.ancsCstmsCmdtVOs = ancsCstmsCmdtVOs;
	}
	

	
	
}