/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0044Event.java
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

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jae yoeb jeong
 * @see ESM_BKG_0044HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0044Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private AncsCstmsVvdInfoCondVO ancsCstmsVvdInfoCondVO  = null;
	/** 조회결과 단건 */
	private AncsCstmsVvdInfoVO ancsCstmsVvdInfoVO = null;
	/** 조회결과 복수 */
	private AncsCstmsVvdInfoVO[] ancsCstmsVvdInfoVOs = null;
	
	/** 조회조건 */
	private AncsCstmsMfListCondVO ancsCstmsMfListCondVO   = null;
	/** 조회결과 단건 */
	private AncsCstmsMfVO ancsCstmsMfVO = null;
	/** 조회결과 복수 */
	private AncsCstmsMfVO[] ancsCstmsMfVOs = null;
	
	/** 조회조건 */
	private AncsCstmsMfDtlCondVO ancsCstmsMfDtlCondVO   = null;
	/** 조회결과 단건 */
	private AncsCstmsMfDtlVO ancsCstmsMfDtlVO = null;
	/** 조회결과 복수 */
	private AncsCstmsMfDtlVO[] ancsCstmsMfDtlVOs = null;
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
		return ancsCstmsVvdInfoVOs;
	}
	public void setAncsCstmsVvdInfoVOs(AncsCstmsVvdInfoVO[] ancsCstmsVvdInfoVOs) {
		this.ancsCstmsVvdInfoVOs = ancsCstmsVvdInfoVOs;
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
		return ancsCstmsMfVOs;
	}
	public void setAncsCstmsMfVOs(AncsCstmsMfVO[] ancsCstmsMfVOs) {
		this.ancsCstmsMfVOs = ancsCstmsMfVOs;
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
		return ancsCstmsMfDtlVOs;
	}
	public void setAncsCstmsMfDtlVOs(AncsCstmsMfDtlVO[] ancsCstmsMfDtlVOs) {
		this.ancsCstmsMfDtlVOs = ancsCstmsMfDtlVOs;
	}
	
}