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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdDtlListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdDtlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestModificationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0551 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0551HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0551HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0551Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private AncsCstmsVvdListCondVO ancsCstmsVvdListCondVO = null;
	/** 조회결과 단건 */
	private AncsManifestModificationVO ancsCstmsVvdVO = null;
	/** 조회결과 복수 */
	private AncsManifestModificationVO[] ancsCstmsVvdVOs = null;
	
	/** 상세조회조건 */
	private AncsCstmsVvdDtlListCondVO ancsCstmsVvdDtlListCondVO = null;
	/** 상세조회결과 단건 */
    private AncsCstmsVvdDtlListVO ancsCstmsVvdDtlListVO = null;
    /** 상세조회결과 복건 */
    private AncsCstmsVvdDtlListVO[] ancsCstmsVvdDtlListVOs = null;
    
    /** 다운로드 단건 */
    private AncsManifestModificationVO ancsManifestModificationVO = null;
    
    /** 다운로드 복수 */
    private AncsManifestModificationVO[] ancsManifestModificationVOs = null;
    	
    
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

	public AncsCstmsVvdDtlListCondVO getAncsCstmsVvdDtlListCondVO() {
		return ancsCstmsVvdDtlListCondVO;
	}

	public void setAncsCstmsVvdDtlListCondVO(AncsCstmsVvdDtlListCondVO ancsCstmsVvdDtlListCondVO) {
		this.ancsCstmsVvdDtlListCondVO = ancsCstmsVvdDtlListCondVO;
	}

	public AncsCstmsVvdDtlListVO getAncsCstmsVvdDtlListVO() {
		return ancsCstmsVvdDtlListVO;
	}

	public void setAncsCstmsVvdDtlListVO(AncsCstmsVvdDtlListVO ancsCstmsVvdDtlListVO) {
		this.ancsCstmsVvdDtlListVO = ancsCstmsVvdDtlListVO;
	}

	public AncsCstmsVvdDtlListVO[] getAncsCstmsVvdDtlListVOs() {
		return ancsCstmsVvdDtlListVOs;
	}

	public void setAncsCstmsVvdDtlListVOs(AncsCstmsVvdDtlListVO[] ancsCstmsVvdDtlListVOs) {
		this.ancsCstmsVvdDtlListVOs = ancsCstmsVvdDtlListVOs;
	}

	public EsmBkg0551Event() {}

	public AncsCstmsVvdListCondVO getAncsCstmsVvdListCondVO() {
		return ancsCstmsVvdListCondVO;
	}

	public void setAncsCstmsVvdListCondVO(AncsCstmsVvdListCondVO ancsCstmsVvdListCondVO) {
		this.ancsCstmsVvdListCondVO = ancsCstmsVvdListCondVO;
	}

	public AncsManifestModificationVO getAncsCstmsVvdVO() {
		return ancsCstmsVvdVO;
	}

	public void setAncsCstmsVvdVO(AncsManifestModificationVO ancsCstmsVvdVO) {
		this.ancsCstmsVvdVO = ancsCstmsVvdVO;
	}

	public AncsManifestModificationVO[] getAncsCstmsVvdVOs() {
		return ancsCstmsVvdVOs;
	}

	public void setAncsCstmsVvdVOs(AncsManifestModificationVO[] ancsCstmsVvdVOs) {
		this.ancsCstmsVvdVOs = ancsCstmsVvdVOs;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}