/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0296Event.java
*@FileTitle : ManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.20 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0296 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0296HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0296HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0296Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private IndiaManifestListCondVO indiaManifestListCondVO = null;
	private IndiaManifestListDetailVO indiaManifestListDetailVO = null;
	private IndiaManifestListDetailVO[] indiaManifestListDetailVOs = null;

	private ManifestModificationVO manifestModificationVO = null;
	private ManifestModificationVO[] manifestModificationVOs = null;

	public EsmBkg0296Event(){}

	/**
	 * @return the indiaManifestListCondVO
	 */
	public IndiaManifestListCondVO getIndiaManifestListCondVO() {
		return indiaManifestListCondVO;
	}

	/**
	 * @param indiaManifestListCondVO the indiaManifestListCondVO to set
	 */
	public void setIndiaManifestListCondVO(
			IndiaManifestListCondVO indiaManifestListCondVO) {
		this.indiaManifestListCondVO = indiaManifestListCondVO;
	}

	/**
	 * @return the indiaManifestListDetailVO
	 */
	public IndiaManifestListDetailVO getIndiaManifestListDetailVO() {
		return indiaManifestListDetailVO;
	}

	/**
	 * @param indiaManifestListDetailVO the indiaManifestListDetailVO to set
	 */
	public void setIndiaManifestListDetailVO(
			IndiaManifestListDetailVO indiaManifestListDetailVO) {
		this.indiaManifestListDetailVO = indiaManifestListDetailVO;
	}

	/**
	 * @return the indiaManifestListDetailVOs
	 */
	public IndiaManifestListDetailVO[] getIndiaManifestListDetailVOs() {
		IndiaManifestListDetailVO[] rtnVOs = null;
		if (this.indiaManifestListDetailVOs != null) {
			rtnVOs = Arrays.copyOf(indiaManifestListDetailVOs, indiaManifestListDetailVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param indiaManifestListDetailVOs the indiaManifestListDetailVOs to set
	 */
	public void setIndiaManifestListDetailVOs(IndiaManifestListDetailVO[] indiaManifestListDetailVOs) {
		if (indiaManifestListDetailVOs != null) {
			IndiaManifestListDetailVO[] tmpVOs = Arrays.copyOf(indiaManifestListDetailVOs, indiaManifestListDetailVOs.length);
			this.indiaManifestListDetailVOs = tmpVOs;
		}
	}

	/**
	 * @return the manifestModificationVOs
	 */
	public ManifestModificationVO[] getManifestModificationVOs() {
		ManifestModificationVO[] rtnVOs = null;
		if (this.manifestModificationVOs != null) {
			rtnVOs = Arrays.copyOf(manifestModificationVOs, manifestModificationVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manifestModificationVOs the manifestModificationVOs to set
	 */
	public void setManifestModificationVOs(ManifestModificationVO[] manifestModificationVOs) {
		if (manifestModificationVOs != null) {
			ManifestModificationVO[] tmpVOs = Arrays.copyOf(manifestModificationVOs, manifestModificationVOs.length);
			this.manifestModificationVOs = tmpVOs;
		}
	}

	/**
	 * @return the manifestModificationVO
	 */
	public ManifestModificationVO getManifestModificationVO() {
		return manifestModificationVO;
	}

	/**
	 * @param manifestModificationVO the manifestModificationVO to set
	 */
	public void setManifestModificationVO(
			ManifestModificationVO manifestModificationVO) {
		this.manifestModificationVO = manifestModificationVO;
	}



}