/*=========================================================
 *Copyright(c) 2017 SM Line
 *@FileName : EsmBkg1085Event.java
 *@FileTitle : DubaiManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.02.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.ESM_BKG_0016HTMLAction;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCstmsCdConvCtntVO;

/**
 * ESM_BKG_1085 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1085HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0016HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1085Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private ManifestListCondVO manifestListCondVO = null;
	private ManifestListDetailVO[] manifestListDetailVOs = null;
	private ManifestTransmitVO[] manifestTransmitVOs = null;
	private BkgCstmsCdConvCtntVO bkgCstmsCdConvCtntVO = null;
	
	public EsmBkg1085Event() {
	}

	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}

	public void setManifestListDetailVOs(ManifestListDetailVO[] manifestListDetailVOs) {
		this.manifestListDetailVOs = manifestListDetailVOs;
	}

	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}

	public ManifestListDetailVO[] getManifestListDetailVOs() {
		return manifestListDetailVOs;
	}

	public ManifestTransmitVO[] getManifestTransmitVOs() {
		return manifestTransmitVOs;
	}

	public void setManifestTransmitVOs(ManifestTransmitVO[] manifestTransmitVOs) {
		this.manifestTransmitVOs = manifestTransmitVOs;
	}

	public void setBkgCstmsCdConvCtntVO(BkgCstmsCdConvCtntVO bkgCstmsCdConvCtntVO) {
		this.bkgCstmsCdConvCtntVO = bkgCstmsCdConvCtntVO;
	}
	
	public BkgCstmsCdConvCtntVO getBkgCstmsCdConvCtntVO() {
		return bkgCstmsCdConvCtntVO;
	}
}