/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1033Event.java
*@FileTitle : EsmBkg1033Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06.
*@LastModifier : 전창현
*@LastVersion : 1.0
* 2009.10.06. 전창현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshManifestTransmitVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1033 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_1033HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 *
 * @author 전창현
 * @see ESM_BKG_1033HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1033Event extends EventSupport {

	private static final long serialVersionUID = 7562149991636194708L;
	private ManifestListDetailVO[] manifestListDetailVOs = null;
	private ManifestListCondVO manifestListCondVO = null;
	private ManifestModificationVO manifestModificationVO = null;
	private BangladeshManifestTransmitVO[] bangladeshManifestTransmitVOs = null;

	// 화면에서 넘어오는 파라메터를 저장하는 객체
	//private BkgCstmsChnDeModVO bkgCstmsChnDeModVO = null;
	// 데이터 추가/삭제용 리스트 객체

	public ManifestListCondVO getManifestListCondVO() {
		return manifestListCondVO;
	}

	public void setManifestListCondVO(ManifestListCondVO manifestListCondVO) {
		this.manifestListCondVO = manifestListCondVO;
	}

	public ManifestListDetailVO[] getManifestListDetailVOs() {
		ManifestListDetailVO[] rtnVOs = null;
		if (this.manifestListDetailVOs != null) {
			rtnVOs = Arrays.copyOf(this.manifestListDetailVOs, this.manifestListDetailVOs.length);
		}
		return rtnVOs;
	}

	public void setManifestListDetailVOs(ManifestListDetailVO[] manifestListDetailVOs) {
		if (manifestListDetailVOs != null) {
			ManifestListDetailVO[] tmpVOs = Arrays.copyOf(manifestListDetailVOs, manifestListDetailVOs.length);
			this.manifestListDetailVOs = tmpVOs;
		}
	}

	public ManifestModificationVO getManifestModificationVO() {
		return manifestModificationVO;
	}

	public void setManifestModificationVO(ManifestModificationVO manifestModificationVO) {
		this.manifestModificationVO = manifestModificationVO;
	}

	public void setBangladeshManifestTransmitVOs(BangladeshManifestTransmitVO[] bangladeshManifestTransmitVOs) {
		if (bangladeshManifestTransmitVOs != null) {
			BangladeshManifestTransmitVO[] tmpVOs = Arrays.copyOf(bangladeshManifestTransmitVOs, bangladeshManifestTransmitVOs.length);
			this.bangladeshManifestTransmitVOs = tmpVOs;
		}
	}
	public BangladeshManifestTransmitVO[] getBangladeshManifestTransmitVOs(){
		BangladeshManifestTransmitVO[] rtnVOs = null;
		if (this.bangladeshManifestTransmitVOs != null) {
			rtnVOs = Arrays.copyOf(this.bangladeshManifestTransmitVOs, this.bangladeshManifestTransmitVOs.length);
		}
		return rtnVOs;
	}

}
