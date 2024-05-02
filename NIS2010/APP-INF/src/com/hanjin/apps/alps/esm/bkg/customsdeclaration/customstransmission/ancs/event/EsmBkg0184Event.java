/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0551Event.java
 *@FileTitle : AncsManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.20 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.ESM_BKG_0551HTMLAction;
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

public class EsmBkg0184Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private AncsCstmsLogDtlCondVO ancsCstmsLogDtlCondVO   = null;
	/** 조회결과 단건 */
	private AncsCstmsLogDtlVO ancsCstmsLogDtlVO = null;
	/** 조회결과 복수 */
	private AncsCstmsLogDtlVO[] ancsCstmsLogDtlVOs = null;
	public AncsCstmsLogDtlCondVO getAncsCstmsLogDtlCondVO() {
		return ancsCstmsLogDtlCondVO;
	}
	public void setAncsCstmsLogDtlCondVO(AncsCstmsLogDtlCondVO ancsCstmsLogDtlCondVO) {
		this.ancsCstmsLogDtlCondVO = ancsCstmsLogDtlCondVO;
	}
	public AncsCstmsLogDtlVO getAncsCstmsLogDtlVO() {
		return ancsCstmsLogDtlVO;
	}
	public void setAncsCstmsLogDtlVO(AncsCstmsLogDtlVO ancsCstmsLogDtlVO) {
		this.ancsCstmsLogDtlVO = ancsCstmsLogDtlVO;
	}
	public AncsCstmsLogDtlVO[] getAncsCstmsLogDtlVOs() {
		return ancsCstmsLogDtlVOs;
	}
	public void setAncsCstmsLogDtlVOs(AncsCstmsLogDtlVO[] ancsCstmsLogDtlVOs) {
		this.ancsCstmsLogDtlVOs = ancsCstmsLogDtlVOs;
	}
	
	
	
}