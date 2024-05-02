/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0013Event.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.25 손윤석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBkgCntrQtyInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestCrsChkInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMsnNoCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0329 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0329HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author charves
 * @see ESM_BKG_0329HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0329Event extends EventSupport {


	private static final long serialVersionUID = 1L;

	private KorManifestInfoVO[] manifestInfoVOs = null;
	private KorManifestCrsChkInfoVO[] korManifestCrsChkInfoVOs = null;
	private KorBkgCntrQtyInfoVO[] cntrVOs = null;
	private KorMrnNoVO mrnNoVO = null;
	private String key = null;
	private KorMsnNoCondVO[] korMsnNoCondVOs = null;

	public EsmBkg0329Event() {}

	public KorMsnNoCondVO[] getKorMsnNoCondVOs() {
		KorMsnNoCondVO[] rtnVOs = null;
		if (this.korMsnNoCondVOs != null) {
			rtnVOs = Arrays.copyOf(korMsnNoCondVOs, korMsnNoCondVOs.length);
		}
		return rtnVOs;
	}

	public void setKorMsnNoCondVOs(KorMsnNoCondVO[] korMsnNoCondVOs) {
		if (korMsnNoCondVOs != null) {
			KorMsnNoCondVO[] tmpVOs = Arrays.copyOf(korMsnNoCondVOs, korMsnNoCondVOs.length);
			this.korMsnNoCondVOs = tmpVOs;
		}
	}


	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}


	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	public KorMrnNoVO getMrnNoVO() {
		return this.mrnNoVO;
	}

	public void setMrnNoVO(KorMrnNoVO korMrnNoVO) {
		this.mrnNoVO = korMrnNoVO;
	}



	/**
	 * @return the manifestInfoVOs
	 */
	public KorManifestInfoVO[] getManifestInfoVOs() {
		KorManifestInfoVO[] rtnVOs = null;
		if (this.manifestInfoVOs != null) {
			rtnVOs = Arrays.copyOf(manifestInfoVOs, manifestInfoVOs.length);
		}
		return rtnVOs;
	}


	/**
	 * @param korManifestCrsChkInfoVOs the korManifestCrsChkInfoVOs to set
	 */
	public void setKorManifestCrsChkInfoVOs(KorManifestCrsChkInfoVO[] korManifestCrsChkInfoVOs) {
		if (korManifestCrsChkInfoVOs != null) {
			KorManifestCrsChkInfoVO[] tmpVOs = Arrays.copyOf(korManifestCrsChkInfoVOs, korManifestCrsChkInfoVOs.length);
			this.korManifestCrsChkInfoVOs = tmpVOs;
		}
	}


	/**
	 * @return the korManifestCrsChkInfoVOs
	 */
	public KorManifestCrsChkInfoVO[] getKorManifestCrsChkInfoVOs() {
		KorManifestCrsChkInfoVO[] rtnVOs = null;
		if (this.korManifestCrsChkInfoVOs != null) {
			rtnVOs = Arrays.copyOf(korManifestCrsChkInfoVOs, korManifestCrsChkInfoVOs.length);
		}
		return rtnVOs;
	}


	/**
	 * @param manifestInfoVOs the manifestInfoVOs to set
	 */
	public void setManifestInfoVOs(KorManifestInfoVO[] manifestInfoVOs) {
		if (manifestInfoVOs != null) {
			KorManifestInfoVO[] tmpVOs = Arrays.copyOf(manifestInfoVOs, manifestInfoVOs.length);
			this.manifestInfoVOs = tmpVOs;
		}
	}



	/**
	 * @return the cntrVOs
	 */
	public KorBkgCntrQtyInfoVO[] getCntrVOs() {
		KorBkgCntrQtyInfoVO[] rtnVOs = null;
		if (this.cntrVOs != null) {
			rtnVOs = Arrays.copyOf(cntrVOs, cntrVOs.length);
		}
		return rtnVOs;
	}



	/**
	 * @param cntrVOs the cntrVOs to set
	 */
	public void setCntrVOs(KorBkgCntrQtyInfoVO[] cntrVOs) {
		if (cntrVOs != null) {
			KorBkgCntrQtyInfoVO[] tmpVOs = Arrays.copyOf(cntrVOs, cntrVOs.length);
			this.cntrVOs = tmpVOs;
		}
	}



}