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

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsSndHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsSndHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.ESM_BKG_0551HTMLAction;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdInfoVO;
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

public class EsmBkg0183Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private AncsCstmsSndHisListCondVO ancsCstmsSndHisListCondVO   = null;
	/** 조회결과 단건 */
	private AncsCstmsSndHisVO ancsCstmsSndHisVO = null;
	/** 조회결과 복수 */
	private AncsCstmsSndHisListCondVO[] ancsCstmsSndHisListCondVOs = null;
	
	/** 조회조건 */
	private AncsCstmsVvdInfoCondVO ancsCstmsVvdInfoCondVO  = null;
	/** 조회결과 단건 */
	private AncsCstmsVvdInfoVO ancsCstmsVvdInfoVO = null;
	/** 조회결과 복수 */
	private AncsCstmsVvdInfoVO[] ancsCstmsVvdInfoVOs = null;
	
	
	
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
	public AncsCstmsSndHisListCondVO getAncsCstmsSndHisListCondVO() {
		return ancsCstmsSndHisListCondVO;
	}
	public void setAncsCstmsSndHisListCondVO(AncsCstmsSndHisListCondVO ancsCstmsSndHisListCondVO) {
		this.ancsCstmsSndHisListCondVO = ancsCstmsSndHisListCondVO;
	}
	public AncsCstmsSndHisVO getAncsCstmsSndHisVO() {
		return ancsCstmsSndHisVO;
	}
	public void setAncsCstmsSndHisVO(AncsCstmsSndHisVO ancsCstmsSndHisVO) {
		this.ancsCstmsSndHisVO = ancsCstmsSndHisVO;
	}
	public AncsCstmsSndHisListCondVO[] getAncsCstmsSndHisListCondVOs() {
		return ancsCstmsSndHisListCondVOs;
	}
	public void setAncsCstmsSndHisListCondVOs(AncsCstmsSndHisListCondVO[] ancsCstmsSndHisListCondVOs) {
		this.ancsCstmsSndHisListCondVOs = ancsCstmsSndHisListCondVOs;
	}
	
	
	
}