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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBkgCntrQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestCrsChkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMsnNoCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

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
	
	public EsmBkg0329Event(){}
	

	public KorMsnNoCondVO[] getKorMsnNoCondVOs() {
		return korMsnNoCondVOs;
	}


	public void setKorMsnNoCondVOs(KorMsnNoCondVO[] korMsnNoCondVOs) {
		this.korMsnNoCondVOs = korMsnNoCondVOs;
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


	public KorMrnNoVO getMrnNoVO(){
		return this.mrnNoVO;
	}
	public void setMrnNoVO(KorMrnNoVO korMrnNoVO){
		this.mrnNoVO = korMrnNoVO;
	}
	
	

	/**
	 * @return the manifestInfoVOs
	 */
	public KorManifestInfoVO[] getManifestInfoVOs() {
		return manifestInfoVOs;
	}


	/**
	 * @param korManifestCrsChkInfoVOs the korManifestCrsChkInfoVOs to set
	 */
	public void setKorManifestCrsChkInfoVOs(KorManifestCrsChkInfoVO[] korManifestCrsChkInfoVOs) {
		this.korManifestCrsChkInfoVOs = korManifestCrsChkInfoVOs;
	}
	

	/**
	 * @return the korManifestCrsChkInfoVOs
	 */
	public KorManifestCrsChkInfoVO[] getKorManifestCrsChkInfoVOs() {
		return korManifestCrsChkInfoVOs;
	}


	/**
	 * @param manifestInfoVOs the manifestInfoVOs to set
	 */
	public void setManifestInfoVOs(KorManifestInfoVO[] manifestInfoVOs) {
		this.manifestInfoVOs = manifestInfoVOs;
	}



	/**
	 * @return the cntrVOs
	 */
	public KorBkgCntrQtyInfoVO[] getCntrVOs() {
		return cntrVOs;
	}



	/**
	 * @param cntrVOs the cntrVOs to set
	 */
	public void setCntrVOs(KorBkgCntrQtyInfoVO[] cntrVOs) {
		this.cntrVOs = cntrVOs;
	}



}